package com.example.loan.util;

import com.example.loan.bo.Gender;
import com.example.loan.bo.LoanPlantChectBo;
import com.example.loan.bo.UserLoanPlanMaterial;

/**
 * @author ：ls05
 * @date ：Created in 2021/11/12 19:16
 */
public class LoanPlanCheckUtil {

    public static final int MAX_LOAN_TERM = 30;

    public static LoanPlantChectBo check(Integer loanTerm, UserLoanPlanMaterial loaner) {
        if (loanTerm > MAX_LOAN_TERM) {
            return new LoanPlantChectBo("住房贷款年限最长为" + MAX_LOAN_TERM + "年",true);
        }
        if (loaner.getGender() == Gender.MALE && loaner.getLenderAge() + loanTerm > 65) {
            return new LoanPlantChectBo("男性_年龄_加_贷款年限_不能超过65",false);
        }
        if (loaner.getGender() == Gender.FEMALE && loaner.getLenderAge() + loanTerm > 60) {
            return new LoanPlantChectBo("女性_年龄_加_贷款年限_不能超过60",false);
        }
        return new LoanPlantChectBo("",true);
    }
}
