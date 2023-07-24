package com.github.mrs.exception;

import lombok.Getter;

/**
 * description: 自定义异常
 * date: 2023/7/22 19:07
 * author: MR.孙
 */
@Getter
public class BaseException extends RuntimeException{

    Object[] args;

    String message;

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Object[] args, String message) {
        super(message);
        this.message = message;
        this.args = args;
    }

    public BaseException(Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.args = args;

    }

}




