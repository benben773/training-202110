package com.example.loan.util;

import com.example.loan.bo.LoanPlantChectBo;
import com.example.loan.bo.UserLoanPlanMaterial;

/**
 * @author ：ls05
 * @date ：Created in 2021/11/12 19:16
 */
public class LoanPlanCheckUtil {
    public static LoanPlantChectBo check(Integer loanTerm, UserLoanPlanMaterial loaner) {
        if (loaner.getLenderAge() + loanTerm > 65) {
            return new LoanPlantChectBo("男性_年龄_加_贷款年限_不能超过65",false);
        }
        return new LoanPlantChectBo("",true);
    }
}
