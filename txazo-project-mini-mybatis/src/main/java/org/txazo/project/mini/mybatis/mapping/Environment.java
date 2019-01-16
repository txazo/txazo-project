package org.txazo.project.mini.mybatis.mapping;

import org.txazo.project.mini.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;

public class Environment {

    private final DataSource dataSource;
    private final TransactionFactory transactionFactory;

    public Environment(DataSource dataSource, TransactionFactory transactionFactory) {
        this.dataSource = dataSource;
        this.transactionFactory = transactionFactory;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public TransactionFactory getTransactionFactory() {
        return transactionFactory;
    }

    public static class Builder {

        private DataSource dataSource;
        private TransactionFactory transactionFactory;

        public Builder dataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public Builder transactionFactory(TransactionFactory transactionFactory) {
            this.transactionFactory = transactionFactory;
            return this;
        }

        public Environment build() {
            return new Environment(dataSource, transactionFactory);
        }

    }

}
