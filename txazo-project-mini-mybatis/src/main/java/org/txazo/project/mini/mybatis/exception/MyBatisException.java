package org.txazo.project.mini.mybatis.exception;

public class MyBatisException extends RuntimeException {

    private static final long serialVersionUID = 3202964324166865795L;

    public MyBatisException() {
        super();
    }

    public MyBatisException(String message) {
        super(message);
    }

    public MyBatisException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyBatisException(Throwable cause) {
        super(cause);
    }

    protected MyBatisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
