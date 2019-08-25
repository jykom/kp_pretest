package com.kakao.transinfo.domain;

/**
 * 거래가 없는 고객 추출 Domain
 */
public class TransNotExistCustom {
    private String year;    // 연도
    private String name;    // 관리점명
    private String acctNo;  // 계좌번호

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }
}
