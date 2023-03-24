package com.jscode.spring.exception.custom;

public class NoParamException extends RuntimeException {
    public NoParamException() {
        super();
    }

    public NoParamException(String message) {
        super(message);
    }

    public NoParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoParamException(Throwable cause) {
        super(cause);
    }

    protected NoParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
