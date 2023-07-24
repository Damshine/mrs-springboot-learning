package com.github.mrs.exception;

/**
 * description: 自定义系统异常
 * date: 2023/7/24 10:05
 * author: MR.孙
 */
public class SystemException extends BaseException{
    public SystemException(String message) {
        super(message);
    }

    public SystemException(Object[] args, String message) {
        super(args, message);
    }

    public SystemException(Object[] args, String message, Throwable cause) {
        super(args, message, cause);
    }
}
