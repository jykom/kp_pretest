package com.kakao.transinfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * INPUT PARAM으로 "분당점" 입력 시 HttpStatus.NOT_FOUND EXCEPTION 처리
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BizException extends RuntimeException {

}
