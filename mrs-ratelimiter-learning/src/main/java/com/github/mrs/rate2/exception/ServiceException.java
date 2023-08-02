package com.github.mrs.rate2.exception;

/**
 * date: 2023/8/2 20:46
 * author: MR.孙
 */
public class ServiceException extends RuntimeException{

    String message;


    public ServiceException(String msg) {
        this.message = msg;
    }

    public ServiceException(String message, String msg) {
        super(message);
        this.message = msg;
    }

    public ServiceException(String message, Throwable cause, String msg) {
        super(message, cause);
        this.message = msg;
    }

    public ServiceException(Throwable cause, String msg) {
        super(cause);
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
