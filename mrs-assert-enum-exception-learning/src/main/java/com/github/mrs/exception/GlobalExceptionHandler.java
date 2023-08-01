package com.github.mrs.exception;

import com.github.mrs.asserts.Assert;
import com.github.mrs.asserts.SysAssert;
import com.github.mrs.pojo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * description:
 * date: 2023/7/22 20:37
 * author: MR.孙
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({BusinessException.class})
    public BaseResponse businessExceptionHandler(BusinessException businessException) {

        log.error("发生异常{} -> {}", businessException.getArgs(), businessException.getMessage());
        return new BaseResponse(Assert.BUSINESS_EXCEPTION.getCode(), businessException.getMessage());

    }

    @ExceptionHandler({SystemException.class})
    public BaseResponse systemExceptionHandler(SystemException systemException) {

        log.error("发生异常{} -> {}", systemException.getArgs(), systemException.getMessage());
        return new BaseResponse(SysAssert.SYSTEM_EXCEPTION.getCode(), systemException.getMessage());

    }


}
