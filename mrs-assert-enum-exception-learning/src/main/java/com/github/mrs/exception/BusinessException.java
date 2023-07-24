package com.github.mrs.exception;

/**
 * description: 业务异常
 * date: 2023/7/22 19:14
 * author: MR.孙
 */
public class BusinessException extends BaseException{

    public BusinessException(Object[] args, String message) {
        super(args, message);
    }

    public BusinessException(Object[] args, String message, Throwable cause) {
        super(args, message, cause);
    }
}
