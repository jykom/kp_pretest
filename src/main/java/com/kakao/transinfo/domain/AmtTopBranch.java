package com.kakao.transinfo.domain;

import java.math.BigDecimal;

/**
 * 연도별 관리점별 거래금액 합계 큰 순서로 출력 Domain
 */
public class AmtTopBranch {
    private String year;        // 연도
    private String brName;      // 관리점명
    private String brCode;      // 관리점코드
    private BigDecimal sumAmt;  // 합계금액

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBrName() {
        return brName;
    }

    public void setBrName(String brName) {
        this.brName = brName;
    }

    public String getBrCode() {
        return brCode;
    }

    public void setBrCode(String brCode) {
        this.brCode = brCode;
    }

    public BigDecimal getSumAmt() {
        return sumAmt;
    }

    public void setSumAmt(BigDecimal sumAmt) {
        this.sumAmt = sumAmt;
    }
}
