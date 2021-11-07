package com.example.loan.service;

import com.example.loan.bo.CheckResultBo;
import com.example.loan.bo.Gender;

public class LoanCheckStrategyUtil {

    public static final Integer MAX_LOAN_YREAR = 30;
    public static final int MAX_LENDER_TERM_AND_HOUSE_AGE = 40;

    public static CheckResultBo checkeLenderAndLoanTerm(Gender gender, Integer lenderAge, Integer loanTerm , Integer houseAge) {
        CheckResultBo result = new CheckResultBo();
        if (lenderAge + loanTerm <= gender.getMaxAgePlusLoanTermValue()) {
            result = new CheckResultBo(true, "");
        } else {
            result = new CheckResultBo(false, gender.getDesc() + "_年龄_加_贷款年限_不能超过" + gender.getMaxAgePlusLoanTermValue());
        }
        if (loanTerm > MAX_LOAN_YREAR) {
            result = new CheckResultBo(false, "住房贷款年限最长为" + MAX_LOAN_YREAR + "年");
        }
        if (loanTerm+houseAge> MAX_LENDER_TERM_AND_HOUSE_AGE) {
            result = new CheckResultBo(false, "贷款年限加上房龄总和不能超过"+MAX_LENDER_TERM_AND_HOUSE_AGE+"年");
        }
        return result;
    }

}
