package org.txazo.project.mybatis.generator;

import com.google.common.io.Closer;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisGenerator {

    private static final String MAPPER_PATH = "E:\\sql";

    public static void main(String[] args) throws Exception {
        Class.forName(JdbcConfig.getDriverClass());
        Connection connection = DriverManager.getConnection(JdbcConfig.getUrl(), JdbcConfig.getUser(), JdbcConfig.getPassword());
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, "%", "%", new String[]{"TABLE"});
        while (resultSet.next()) {
            Table table = new Table();
            table.setDbName(resultSet.getString("TABLE_CAT"));
            table.setTableName(resultSet.getString("TABLE_NAME"));
            ResultSet columnResultSet = metaData.getColumns(null, "%", table.getTableName(), "%");
            while (columnResultSet.next()) {
                Column column = new Column();
                column.setColumnName(columnResultSet.getString("COLUMN_NAME"));
                column.setColumnType(ColumnType.valueOf(columnResultSet.getString("TYPE_NAME")));
                table.addColumn(column);
            }
            generatorMapper(table);
        }
    }

    private static void generatorMapper(Table table) throws IOException {
        System.out.println(String.format("[MapperGenerate] %s.%s", table.getDbName(), table.getTableName()));

        BufferedWriter writer = new BufferedWriter(new FileWriter(MAPPER_PATH + "\\" + table.getDbName() + "." + table.getTableName() + ".xml"));

        Map<String, String> tableData = new HashMap<>();
        tableData.put("\\$\\{tableName\\}", table.getTableName());
        tableData.put("\\$\\{entityName\\}", NameUtils.getHumpName(table.getTableName()));
        tableData.put("\\$\\{entityClass\\}", NameUtils.getHumpName(table.getTableName()));
        tableData.put("\\$\\{mapperClass\\}", NameUtils.getHumpName(table.getTableName()) + "Mapper");

        boolean forloop = false;
        List<String> loopLines = new ArrayList<>();
        for (String line : MapperTemplate.getLines()) {
            if ("forloop".equals(line.trim())) {
                forloop = true;
                loopLines.clear();
            } else if ("/forloop".equals(line.trim())) {
                forloop = false;
                for (Column column : table.getColumns()) {
                    Map<String, String> columnData = new HashMap<>();
                    columnData.put("\\$\\{columnName\\}", column.getColumnName());
                    columnData.put("\\$\\{columnType\\}", column.getColumnType().getType());
                    columnData.put("\\$\\{fieldName\\}", NameUtils.getHumpName2(column.getColumnName()));

                    for (String loopLine : loopLines) {
                        for (Map.Entry<String, String> entry : columnData.entrySet()) {
                            loopLine = loopLine.replaceAll(entry.getKey(), entry.getValue());
                        }
                        writer.write(loopLine);
                        writer.newLine();
                    }
                }
            } else if (forloop) {
                loopLines.add(line);
            } else {
                for (Map.Entry<String, String> entry : tableData.entrySet()) {
                    line = line.replaceAll(entry.getKey(), entry.getValue());
                }
                writer.write(line);
                writer.newLine();
            }
        }

        Closer.create().register(writer).close();
    }

}
