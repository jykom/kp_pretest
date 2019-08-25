package com.kakao.transinfo.service;

import com.kakao.transinfo.domain.AmtTopBranch;
import com.kakao.transinfo.domain.AmtTopCustom;
import com.kakao.transinfo.domain.BranchSumAmt;
import com.kakao.transinfo.domain.TransNotExistCustom;
import com.kakao.transinfo.dto.AmtTopBranchMainDto;
import com.kakao.transinfo.dto.AmtTopBranchSubDto;
import com.kakao.transinfo.exception.BizException;
import com.kakao.transinfo.exception.ExceptionMasseage;
import com.kakao.transinfo.mapper.QueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 특정 고객 거래내역 조회 서비스 Service
 * @author Jiyeon
 */
@Service
public class QeuryAction {

    @Autowired
    QueryMapper queryMapper;    // 각 API별 DATA 조회를 위한 선언

    /*
     * 각 연도별 합계 금액이 가장 많은 고객을 추출
     * return : List<AmtTopCustom>
     */
    public List<AmtTopCustom> getAmtTopCustom() {
        return queryMapper.getAmtTopCustom();
    }

    /*
     * 거래가 없는 고객을 추출
     * return : List<TransNotExistCustom>
     */
    public List<TransNotExistCustom> getTransNotExistCustom() {
        return queryMapper.getTransNotExistCustom();
    }

    /*
     * 연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력
     * return : List<AmtTopBranchMainDto>
     */
    public List<AmtTopBranchMainDto> getAmtTopBranch() {
        // 연도별 관리점별 거래금액 합계 MAIN LIST
        List<AmtTopBranchMainDto> rtnMainList = new ArrayList<AmtTopBranchMainDto>();

        // 연도별 관리점별 거래금액 합계 쿼리 조회 결과 LIST
        List<AmtTopBranch> qryResultList = queryMapper.getAmtTopBranch();

        // 연도별 관리점별 거래금액 합계 SUB LIST => MAIN LIST에 YEAR에 해당하는 DATALIST
        AmtTopBranchSubDto branchList = new AmtTopBranchSubDto();

        // 연도별 LIST를 생성하기 위한 INT 변수 선언
        int j = 0;
        // 연도별 LIST를 생성하기 위한 year 변수 선언
        String year = "";

        // QUERY 실행 결과 처리
        for(int i=0; i < qryResultList.size(); i++){        // QUERY 실행 결과 SIZE 만큼 FOR문 반복
            if("".equals(year)){                            // 최초 연도 발생 시
                year = qryResultList.get(i).getYear();      // 최초 연도를 year 변수에 저장
                rtnMainList.add(new AmtTopBranchMainDto(qryResultList.get(i).getYear()));   // MAIN LIST에 신규 행 추가하여 연도 입력
            }else if(!year.equals(qryResultList.get(i).getYear())) {    // 기존 입력된 연도와 다른 연도의 행이 발생한 경우
                j++;                                        // 연도별 행 추가를 위한 j++
                year = qryResultList.get(i).getYear();      // 새로 발생한 연도를 year 변수에 저장
                rtnMainList.add(new AmtTopBranchMainDto(qryResultList.get(i).getYear()));   // MAIN LIST에 신규 행 추가하여 연도 입력
            }

            branchList = new AmtTopBranchSubDto();
            branchList.setBrName(qryResultList.get(i).getBrName());     // 관리점명
            branchList.setBrCode(qryResultList.get(i).getBrCode());     // 관리점코드
            branchList.setSumAmt(qryResultList.get(i).getSumAmt());     // 합계금액

            rtnMainList.get(j).getDataList().add(branchList);           // 연도별 DATALIST에 행 추가
        }

        return rtnMainList;     // 연도별 관리점별 거래금액 합계 MAIN LIST return
    }

    /*
     * 지점명을 입력하면 해당지점의 거래금액 합계를 출력
     * 분당점과 판교점을 통폐합하여 판교점으로 관리점 이관
     * INPUT PARAM으로 "분당점"이 입력될 경우 EXCEPTION 처리
     * return : BranchSumAmt
     */
    public BranchSumAmt getBranchSumAmt(String brName) {
        if("분당점".equals(brName)){
            throw new BizException();
        }else{
            return queryMapper.getBranchSumAmt(brName);
        }
    }
}
