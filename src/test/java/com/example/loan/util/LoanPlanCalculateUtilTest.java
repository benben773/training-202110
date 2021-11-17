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
public class LoanPlanCalculateUtilTest {

    private Gender gender;
    private Integer age;
    private Integer loanTerm;
    private Integer houseAge;
    private boolean returnCode;
    private Integer maxLoanYear;
    private String desc;

    public LoanPlanCalculateUtilTest(Gender gender, Integer age, Integer loanTerm, Integer houseAge, boolean returnCode, Integer maxLoanYear,String desc) {
        this.gender = gender;
        this.age = age;
        this.loanTerm = loanTerm;
        this.houseAge = houseAge;
        this.returnCode = returnCode;
        this.maxLoanYear = maxLoanYear;
        this.desc = desc;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Gender.MALE, 35,30,0,true,30,"最大贷款年限计算_男性_年龄_加_贷款年限_不能超过65"},
                {Gender.MALE, 35,20,20,true,20,"贷款年限加上房龄总和不能超过40年"},
                {Gender.FEMALE, 35,26,20,true,20,"贷款年限加上房龄总、贷款年限不能超过60取最小"},
        });
    }
    @Test
    public void calculate()  {
        calculate(gender, age, loanTerm, houseAge, returnCode, maxLoanYear);
    }

    private void calculate(Gender gender, Integer age, Integer loanTerm, Integer houseAge, boolean returnCode, Integer maxLoanYear) {
        UserLoanPlanMaterial loaner = new UserLoanPlanMaterial(Long.valueOf(1), "idCard", "name", gender, new BigDecimal(0), age, new TogetherLender("idCard", "name", new BigDecimal(0)), new HouseMaterial(houseAge, new BigDecimal(0)), LocalDateTime.of(2021, Month.NOVEMBER, 12, 21, 46, 40), LocalDateTime.of(2021, Month.NOVEMBER, 12, 21, 46, 40));
        LoanPlantBo result = LoanPlanCalculateUtil.calculateUserLoanPlan(loanTerm,loaner);
        Assert.assertEquals(result.isReturnCode(), returnCode);
        Assert.assertEquals(result.getMaxLoanYear(), maxLoanYear);
    }
}
