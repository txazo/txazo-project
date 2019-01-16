package org.txazo.project.mini.mybatis.session;

import org.txazo.project.mini.mybatis.exception.MyBatisException;
import org.txazo.project.mini.mybatis.executor.Executor;
import org.txazo.project.mini.mybatis.mapping.Environment;
import org.txazo.project.mini.mybatis.transaction.Transaction;
import org.txazo.project.mini.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return openSessionFromDataSource();
    }

    private SqlSession openSessionFromDataSource() {
        Transaction transaction = null;
        try {
            Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            transaction = transactionFactory.newTransaction(environment.getDataSource());
            Executor executor = configuration.newExecutor(transaction);
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            closeTransaction(transaction);
            throw new MyBatisException("Error opening session.  Cause: " + e, e);
        }
    }

    private void closeTransaction(Transaction transaction) {
        if (transaction != null) {
            try {
                transaction.close();
            } catch (SQLException e) {
            }
        }
    }

}
