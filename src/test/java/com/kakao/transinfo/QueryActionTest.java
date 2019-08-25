package com.kakao.transinfo;

import com.kakao.transinfo.domain.AmtTopBranch;
import com.kakao.transinfo.domain.AmtTopCustom;
import com.kakao.transinfo.domain.BranchSumAmt;
import com.kakao.transinfo.domain.TransNotExistCustom;
import com.kakao.transinfo.dto.AmtTopBranchMainDto;
import com.kakao.transinfo.dto.AmtTopBranchSubDto;
import com.kakao.transinfo.mapper.QueryMapper;
import com.kakao.transinfo.service.QeuryAction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;

@RunWith(MockitoJUnitRunner.class)
public class QueryActionTest {
    @InjectMocks
    private QeuryAction qeuryAction;

    @Mock
    private QueryMapper queryMapper;

    @Test
    public void amtTopCustom() throws Exception{
        List<AmtTopCustom> amtTopCustomList = new ArrayList<AmtTopCustom>();
        AmtTopCustom result = new AmtTopCustom();
        result.setYear("2018");
        result.setName("테드");
        result.setAcctNo("11111114");
        result.setSumAmt(new BigDecimal(28992000));

        amtTopCustomList.add(result);

        given(this.qeuryAction.getAmtTopCustom()).willReturn(amtTopCustomList);

        // when
        List<AmtTopCustom> testResult = qeuryAction.getAmtTopCustom();

        // then
        Mockito.verify(queryMapper, atLeastOnce()).getAmtTopCustom();

        assertThat(amtTopCustomList.get(0).getAcctNo(), is(testResult.get(0).getAcctNo()));
    }



    @Test
    public void transNotExistCustom() throws Exception{
        List<TransNotExistCustom> transNotExistCustomList = new ArrayList<TransNotExistCustom>();
        TransNotExistCustom result = new TransNotExistCustom();
        result.setYear("2018");
        result.setName("제임스");
        result.setAcctNo("11111118");

        transNotExistCustomList.add(result);

        given(this.qeuryAction.getTransNotExistCustom()).willReturn(transNotExistCustomList);

        // when
        List<TransNotExistCustom> testResult = qeuryAction.getTransNotExistCustom();

        // then
        Mockito.verify(queryMapper, atLeastOnce()).getTransNotExistCustom();

        assertThat(transNotExistCustomList.get(0).getName(), is(testResult.get(0).getName()));
    }

    @Test
    public void branchSumAmt() throws Exception{
        BranchSumAmt data = new BranchSumAmt();
        data.setBrName("잠실점");
        data.setBrCode("D");
        data.setSumAmt(new BigDecimal(20000000));

        given(this.qeuryAction.getBranchSumAmt("잠실점")).willReturn(data);

        // when
        BranchSumAmt testResult = qeuryAction.getBranchSumAmt("잠실점");

        // then
        Mockito.verify(queryMapper, atLeastOnce()).getBranchSumAmt("잠실점");

        assertThat(data.getBrCode(), is(testResult.getBrCode()));
    }
}