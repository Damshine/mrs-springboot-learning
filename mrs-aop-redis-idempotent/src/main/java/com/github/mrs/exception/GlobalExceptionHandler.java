package com.github.mrs.exception;

import com.github.mrs.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * date: 2023/8/1 22:04
 * author: MR.孙
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Throwable.class)
    public Result handleException(Throwable throwable){
        log.error("错误", throwable);
        return Result.failed(500, throwable.getCause().getMessage());
    }

}
