package com.kakao.transinfo.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 연도별 관리점별 거래금액 합계 큰 순서로 출력하기 위한 Main dto
 */
public class AmtTopBranchMainDto {
    private String year;                        // 연도
    private List<AmtTopBranchSubDto> dataList;  // 관리점 List

    public AmtTopBranchMainDto(String year) {
        super();
        this.year = year;
        dataList = new ArrayList<AmtTopBranchSubDto>();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<AmtTopBranchSubDto> getDataList() {
        return dataList;
    }

    public void setDataList(List<AmtTopBranchSubDto> dataList) {
        this.dataList = dataList;
    }
}
