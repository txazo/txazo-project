package org.txazo.project.mini.mybatis.exception;

public class MapperNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6770671778056475258L;

    public MapperNotFoundException() {
        super();
    }

    public MapperNotFoundException(String message) {
        super(message);
    }

    public MapperNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MapperNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MapperNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
