package com.github.mrs.exception;

import com.github.mrs.enums.IResponseEnum;
import lombok.Getter;

/**
 * description: 自定义异常
 * date: 2023/7/22 19:07
 * author: MR.孙
 */
@Getter
public class BaseException extends RuntimeException{

    IResponseEnum responseEnum;

    Object[] args;

    String message;

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
        super(message);
        this.responseEnum = responseEnum;
        this.args = args;
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.responseEnum = responseEnum;
        this.args = args;

    }

}




