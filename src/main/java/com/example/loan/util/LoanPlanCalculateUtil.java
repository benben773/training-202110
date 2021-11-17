package com.example.loan.util;

import com.example.loan.bo.LoanPlantBo;
import com.example.loan.bo.UserLoanPlanMaterial;

/**
 * @author ：ls05
 * @date ：Created in 2021/11/17 16:16
 */
public class LoanPlanCalculateUtil {
    public static LoanPlantBo calculateUserLoanPlan(Integer loanTerm, UserLoanPlanMaterial loaner) {
        int maxLoanYearByMaxAgePlusLoanTerm = loaner.getGender().getMaxAgePlusLoanTerm() - loaner.getLenderAge();
        int maxLoanYearByLoanTermPlusHouseAge = 40 - loaner.getHouseMaterialAge();
        return new LoanPlantBo(maxLoanYearByMaxAgePlusLoanTerm<=maxLoanYearByLoanTermPlusHouseAge?maxLoanYearByMaxAgePlusLoanTerm:maxLoanYearByLoanTermPlusHouseAge );
    }
}
