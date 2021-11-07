package com.example.loan.service;

import com.example.loan.bo.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(Parameterized.class)
public class LoanCheckStrategyUtilTest {

    private Gender gender;
    private Integer maxAgePlusLoanTermValue;
    private Integer lenderAge;
    private Integer loanTerm;

    public LoanCheckStrategyUtilTest(Gender gender, Integer lenderAge, Integer loanTerm, Integer maxAgePlusLoanTermValue) {
        this.gender = gender;
        this.maxAgePlusLoanTermValue = maxAgePlusLoanTermValue;
        this.lenderAge = lenderAge;
        this.loanTerm = loanTerm;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Gender.FEMALE,35,26,60},
        });
    }
    @Test
    public void 女性_年龄_加_贷款年限_不能超过60() {
        check(gender, lenderAge, loanTerm, gender.getDesc() + "_年龄_加_贷款年限_不能超过" + maxAgePlusLoanTermValue);
    }

    private void check(Gender gender, Integer lenderAge, Integer loanTerm, String message) {
        String result = LoanCheckStrategyUtil.checkeLenderAndLoanTerm(gender, lenderAge, loanTerm);
        assertThat(result).isEqualTo("{\"returnCode\": \"-1\",\"" + message + "\":\"\"}");
    }
}