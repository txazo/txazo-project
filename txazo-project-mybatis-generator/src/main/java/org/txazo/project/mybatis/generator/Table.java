package org.txazo.project.mybatis.generator;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Table {

    private String dbName;

    private String tableName;

    private List<Column> columns = new ArrayList<>();

    public void addColumn(Column column) {
        columns.add(column);
    }

}
