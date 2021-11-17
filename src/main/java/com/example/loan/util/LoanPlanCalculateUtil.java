package com.example.loan.util;

import com.example.loan.bo.LoanPlantBo;
import com.example.loan.bo.UserLoanPlanMaterial;

/**
 * @author ：ls05
 * @date ：Created in 2021/11/17 16:16
 */
public class LoanPlanCalculateUtil {
    public static LoanPlantBo calculateUserLoanPlan(UserLoanPlanMaterial loaner) {
        return new LoanPlantBo(loaner.getGender().getMaxAgePlusLoanTerm() - loaner.getLenderAge());
    }
}
