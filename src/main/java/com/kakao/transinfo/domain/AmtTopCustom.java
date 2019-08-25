package com.kakao.transinfo.domain;

import java.math.BigDecimal;

/**
 * 각 연도별 합계 금액이 가장 많은 고객 추출 Domain
 */
public class AmtTopCustom {
    private String year;        // 연도
    private String name;        // 계좌명
    private String acctNo;      // 계좌번호
    private BigDecimal sumAmt;  // 합계금액

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

    public BigDecimal getSumAmt() {
        return sumAmt;
    }

    public void setSumAmt(BigDecimal sumAmt) {
        this.sumAmt = sumAmt;
    }
}