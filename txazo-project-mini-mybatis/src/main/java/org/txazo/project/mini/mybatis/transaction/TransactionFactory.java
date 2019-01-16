package org.txazo.project.mini.mybatis.transaction;

import javax.sql.DataSource;

public interface TransactionFactory {

    Transaction newTransaction(DataSource dataSource);

}
