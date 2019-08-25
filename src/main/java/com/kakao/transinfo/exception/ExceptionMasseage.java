package com.kakao.transinfo.exception;

/**
 * INPUT PARAM으로 "분당점" 입력시 사용자 EXCEPTION 처리를 위한 VO
 */
public class ExceptionMasseage {
    private String code;    // 에러코드
    private String msg;     // 에러 메시지

    public ExceptionMasseage(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
