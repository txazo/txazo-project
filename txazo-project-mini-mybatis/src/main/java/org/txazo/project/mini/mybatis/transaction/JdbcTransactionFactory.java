package org.txazo.project.mini.mybatis.transaction;

import javax.sql.DataSource;

public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(DataSource dataSource) {
        return new JdbcTransaction(dataSource);
    }

}
