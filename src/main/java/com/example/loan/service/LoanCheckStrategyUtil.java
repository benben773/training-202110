package com.example.loan.service;

import com.example.loan.bo.CheckResultBo;
import com.example.loan.bo.Gender;

public class LoanCheckStrategyUtil {

    public static CheckResultBo checkeLenderAndLoanTerm(Gender gender, Integer lenderAge, Integer loanTerm) {
        CheckResultBo result = new CheckResultBo();
        if (lenderAge + loanTerm <= gender.getMaxAgePlusLoanTermValue()) {
            result = new CheckResultBo(true, "");
        } else {
            result = new CheckResultBo(false, gender.getDesc() + "_年龄_加_贷款年限_不能超过" + gender.getMaxAgePlusLoanTermValue());
        }
        if (loanTerm > 30) {
            result = new CheckResultBo(false, "住房贷款年限最长为30年");
        }
        return result;
    }

}
