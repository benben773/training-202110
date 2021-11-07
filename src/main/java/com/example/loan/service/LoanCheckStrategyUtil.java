package com.example.loan.service;

import com.example.loan.bo.CheckResultBo;
import com.example.loan.bo.Gender;

public class LoanCheckStrategyUtil {

    public static CheckResultBo checkeLenderAndLoanTerm(Gender gender, Integer lenderAge, Integer loanTerm) {
        CheckResultBo result =new CheckResultBo();
        if(gender == Gender.MALE){
            if (lenderAge + loanTerm <= 65) {
                result = new CheckResultBo(true, "");
            }else{
                result = new CheckResultBo(false, gender.getDesc() + "_年龄_加_贷款年限_不能超过" + gender.getMaxAgePlusLoanTermValue());
            }
        }else if(gender == Gender.FEMALE) {
            if (lenderAge + loanTerm <= 60) {
                result = new CheckResultBo(true, "");
            }else{
                result = new CheckResultBo(false, gender.getDesc() + "_年龄_加_贷款年限_不能超过" + gender.getMaxAgePlusLoanTermValue());
            }
        }
        return result;
    }

}
