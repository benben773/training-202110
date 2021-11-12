package com.example.loan.util;

import com.example.loan.bo.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoanPlanCheckUtilTest {

    private Gender gender;
    private Integer age;
    private Integer loanTerm;
    private Integer houseAge;
    private boolean returnCode;
    private String returnMessage;

    public LoanPlanCheckUtilTest(Gender gender, Integer age, Integer loanTerm, Integer houseAge, boolean returnCode, String returnMessage) {
        this.gender = gender;
        this.age = age;
        this.loanTerm = loanTerm;
        this.houseAge = houseAge;
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Gender.MALE, 36,30,0,false,"男性_年龄_加_贷款年限_不能超过65"},
                {Gender.FEMALE, 31,30,0,false,"女性_年龄_加_贷款年限_不能超过60"},
                {Gender.FEMALE, 30,30,0,true,""},
                {Gender.MALE, 35,30,0,true,""},
                {Gender.FEMALE, 35,31,0,true,"住房贷款年限最长为30年"},
//                李D 男 30 31 0 否 住房贷款年限最长为30年
//                李E 男 30 30 10 是
//                李F 男 30 30 11 否 贷款年限加上房龄总和不能超过40年
//                李G 男 30 30 10 是
        });
    }
    @Test
    public void 男性_年龄_加_贷款年限_不能超过65() throws Exception {
        check(gender, age, loanTerm, houseAge, returnCode, returnMessage);
    }

    private void check(Gender gender, Integer age, Integer loanTerm, Integer houseAge, boolean returnCode, String returnMessage) {
        UserLoanPlanMaterial loaner = new UserLoanPlanMaterial(Long.valueOf(1), "idCard", "name", gender, new BigDecimal(0), age, new TogetherLender("idCard", "name", new BigDecimal(0)), new HouseMaterial(houseAge, new BigDecimal(0)), LocalDateTime.of(2021, Month.NOVEMBER, 12, 21, 46, 40), LocalDateTime.of(2021, Month.NOVEMBER, 12, 21, 46, 40));
        LoanPlantChectBo result = LoanPlanCheckUtil.check(loanTerm, loaner);
        Assert.assertEquals(result.getReturnCode(), returnCode);
        Assert.assertEquals(result.getReturnMessage(), returnMessage);
    }
}
