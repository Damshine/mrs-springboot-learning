package com.github.mrs.exception;

import com.github.mrs.enums.IResponseEnum;

/**
 * description: 业务异常
 * date: 2023/7/22 19:14
 * author: MR.孙
 */
public class BusinessException extends BaseException{

    public BusinessException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public BusinessException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
