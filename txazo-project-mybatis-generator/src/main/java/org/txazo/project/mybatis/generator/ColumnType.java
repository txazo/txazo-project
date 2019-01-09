package org.txazo.project.mybatis.generator;

public enum ColumnType {

    TINYINT("TINYINT"),
    SMALLINT("SMALLINT"),
    INT("INTEGER"),
    BIGINT("BIGINT"),
    DECIMAL("DECIMAL"),
    CHAR("CHAR"),
    VARCHAR("VARCHAR"),
    TEXT("TEXT"),
    DATE("DATE"),
    DATETIME("DATETIME"),
    TIMESTAMP("TIMESTAMP"),;

    private String type;

    ColumnType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
