package com.zb.shorturl.exception.handler;

import com.zb.shorturl.dto.ResultDTO;
import com.zb.shorturl.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhangbo
 * @date 2020-01-19
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = PermissionException.class)
    public ResultDTO handle(PermissionException e) {
        log.error("PermissionException: {}", e.getMessage());
        return ResultDTO.fail(HttpStatus.FORBIDDEN.value(), e.getMessage());
    }

    @ExceptionHandler(value = MissingRequestHeaderException.class)
    public ResultDTO handle(MissingRequestHeaderException e) {
        log.error("MissingRequestHeaderException: {}", e.getMessage());
        return ResultDTO.fail(HttpStatus.FORBIDDEN.value(), "invalid app key");
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResultDTO handle(IllegalArgumentException e) {
        log.error("IllegalArgumentException: {}", e.getMessage());
        return ResultDTO.fail(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResultDTO handle(Exception e) {
        log.error("Exception", e);
        return ResultDTO.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error");
    }

}
