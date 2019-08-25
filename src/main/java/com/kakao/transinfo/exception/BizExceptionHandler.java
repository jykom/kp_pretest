package com.kakao.transinfo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * INPUT PARAM으로 "분당점" 입력시 HttpStatus.NOT_FOUND EXCEPTION 처리 위한 Handler
 */
@ControllerAdvice
@RestController
public class BizExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(BizException.class)
    public ResponseEntity<ExceptionMasseage> BizException(BizException ex, WebRequest request) {
        // HttpStatus.NOT_FOUND EXCEPTION 처리
        ExceptionMasseage exceptionMasseage = new ExceptionMasseage("404", "br code not found error");
        return new ResponseEntity<>(exceptionMasseage, HttpStatus.NOT_FOUND);
    }
}
