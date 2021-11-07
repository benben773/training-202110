package com.example.loan.service;

import com.example.loan.bo.Gender;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LoanCheckStrategyUtilTest {

    @Test
    public void 女性_年龄_加_贷款年限_不能超过60() {
        String result = LoanCheckStrategyUtil.checkeLenderAndLoanTerm(Gender.FEMALE, 35, 26, "0", "");
        assertThat(result).isEqualTo("女性_年龄_加_贷款年限_不能超过60");
    }
}