package com.kakao.transinfo.controller;

import java.util.List;

import com.kakao.transinfo.domain.AmtTopCustom;
import com.kakao.transinfo.domain.BranchSumAmt;
import com.kakao.transinfo.domain.TransNotExistCustom;
import com.kakao.transinfo.dto.AmtTopBranchMainDto;
import com.kakao.transinfo.service.QeuryAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 특정 고객 거래내역 조회 서비스 Controller
 */
@RestController
public class TransInfoController {
	
	@Autowired
	QeuryAction qeuryAction;	// 각 API별 Service 사용을 위한 선언

	/*
	* 각 연도별 합계 금액이 가장 많은 고객을 추출
	* HTTP Method : GET
	* return : List<AmtTopCustom>
	*/
	@GetMapping("/amtTopCustom")
	public List<AmtTopCustom> getAmtTopCustom() {
			List<AmtTopCustom> atc_lists = qeuryAction.getAmtTopCustom();
	    return atc_lists;
	}

	/*
	 * 거래가 없는 고객을 추출
	 * HTTP Method : GET
	 * return : List<TransNotExistCustom>
	 */
	@GetMapping("/transNotExistCustom")
	public List<TransNotExistCustom> getTransNotExistCustom() {
		List<TransNotExistCustom> tnec_lists = qeuryAction.getTransNotExistCustom();
		return tnec_lists;
	}

	/*
	 * 연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력
	 * HTTP Method : GET
	 * return : List<AmtTopBranchMainDto>
	 */
	@GetMapping("/amtTopBranch")
	public List<AmtTopBranchMainDto> getAmtTopBranch() {
		List<AmtTopBranchMainDto> atbl_lists = qeuryAction.getAmtTopBranch();
		return atbl_lists;
	}

	/*
	 * 지점명을 입력하면 해당지점의 거래금액 합계를 출력
	 * HTTP Method : Get
	 * return : BranchSumAmt
	 */
	@GetMapping("/branchSumAmt")
	public BranchSumAmt getBranchSumAmt(@RequestParam String brName) {

		BranchSumAmt branchSumAmt = qeuryAction.getBranchSumAmt(brName);
		return branchSumAmt;
	}
}
