package com.kakao.transinfo.domain;

import java.math.BigDecimal;

/**
 * 지점명 입력 시 해당지점의 거래금액 합계 출력 Domain
 */
public class BranchSumAmt {
    private String brName;      // 관리점명
    private String brCode;      // 관리점코드
    private BigDecimal sumAmt;  // 합계금액

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
