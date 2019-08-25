package com.kakao.transinfo.mapper;

import com.kakao.transinfo.domain.AmtTopBranch;
import com.kakao.transinfo.domain.AmtTopCustom;
import com.kakao.transinfo.domain.BranchSumAmt;
import com.kakao.transinfo.domain.TransNotExistCustom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Data 조회를 위한 Mapper 선언
 */
@Mapper
public interface QueryMapper {
    // 각 연도별 합계 금액이 가장 많은 고객 추출
    List<AmtTopCustom> getAmtTopCustom();

    // 거래가 없는 고객 추출
    List<TransNotExistCustom> getTransNotExistCustom();

    // 연도별 관리점별 거래금액 합계 큰 순서로 출력
    List<AmtTopBranch> getAmtTopBranch();

    //지점명으로 해당지점의 거래금액 합계 출력
    BranchSumAmt getBranchSumAmt(String brName);
}
