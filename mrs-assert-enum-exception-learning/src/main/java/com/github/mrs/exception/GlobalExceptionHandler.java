package com.github.mrs.exception;

import com.github.mrs.po.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * description:
 * date: 2023/7/22 20:37
 * author: MR.孙
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({BusinessException.class})
    public BaseResponse businessExceptionHandler(BusinessException businessException) {


        return new BaseResponse(businessException.responseEnum.getCode(), businessException.responseEnum.getMessage());

    }




}
