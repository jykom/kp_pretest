package com.kakao.transinfo.dto;

import java.math.BigDecimal;

/**
 * 연도별 관리점별 거래금액 합계 큰 순서로 출력하기 위한 Sub dto
 */
public class AmtTopBranchSubDto {
    private String brName;      // 관리점명
    private String brCode;      // 관리점코드
    private BigDecimal sumAmt;  // 거래금액 합계

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
