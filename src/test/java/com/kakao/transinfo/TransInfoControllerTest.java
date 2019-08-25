package com.kakao.transinfo;

import com.kakao.transinfo.controller.TransInfoController;
import com.kakao.transinfo.domain.AmtTopCustom;
import com.kakao.transinfo.domain.BranchSumAmt;
import com.kakao.transinfo.domain.TransNotExistCustom;
import com.kakao.transinfo.dto.AmtTopBranchMainDto;
import com.kakao.transinfo.dto.AmtTopBranchSubDto;
import com.kakao.transinfo.service.QeuryAction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestController
@RunWith(MockitoJUnitRunner.class)
public class TransInfoControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private TransInfoController transInfoController;

    @Mock
    private QeuryAction qeuryAction;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(transInfoController)
                .build();
    }

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

        mockMvc.perform(get("/amtTopCustom"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"year\":\"2018\",\"name\":\"테드\",\"acctNo\":\"11111114\",\"sumAmt\":28992000}]"))
                .andDo(print());
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

        mockMvc.perform(get("/transNotExistCustom"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"year\":\"2018\",\"name\":\"제임스\",\"acctNo\":\"11111118\"}]"))
                .andDo(print());
    }

    @Test
    public void amtTopBranch() throws Exception{

        List<AmtTopBranchMainDto> amtTopBranchList = new ArrayList<AmtTopBranchMainDto>();
        amtTopBranchList.add(new AmtTopBranchMainDto("2018"));
        AmtTopBranchSubDto subResult = new AmtTopBranchSubDto();

        subResult.setBrName("분당점");
        subResult.setBrCode("B");
        subResult.setSumAmt(new BigDecimal(38500000));

        amtTopBranchList.get(0).getDataList().add(subResult);

        given(this.qeuryAction.getAmtTopBranch()).willReturn(amtTopBranchList);

        mockMvc.perform(get("/amtTopBranch"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"year\":\"2018\",\"dataList\":[{\"brName\":\"분당점\",\"brCode\":\"B\",\"sumAmt\":38500000}]}]"))
                .andDo(print());
    }

    @Test
    public void branchSumAmt() throws Exception{
        BranchSumAmt data = new BranchSumAmt();
        data.setBrName("잠실점");
        data.setBrCode("D");
        data.setSumAmt(new BigDecimal(20000000));

        given(this.qeuryAction.getBranchSumAmt("잠실점")).willReturn(data);

        mockMvc.perform(get("/branchSumAmt").param("brName","잠실점").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"brName\":\"잠실점\",\"brCode\":\"D\",\"sumAmt\":20000000}"))
                .andDo(print());
    }
}