package org.txazo.project.mybatis.generator;

import lombok.Data;

@Data
public class Column {

    private String columnName;

    private ColumnType columnType;

}
