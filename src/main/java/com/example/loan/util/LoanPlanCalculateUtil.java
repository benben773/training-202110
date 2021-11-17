package com.example.loan.util;

import com.example.loan.bo.LoanPlantBo;
import com.example.loan.bo.UserLoanPlanMaterial;

/**
 * @author ：ls05
 * @date ：Created in 2021/11/17 16:16
 */
public class LoanPlanCalculateUtil {

    private static final int MAX_LOANTERM_PLUS_HOUSE_AGE = 40;

    public static LoanPlantBo calculateUserLoanPlan(Integer loanTerm, UserLoanPlanMaterial loaner) {
        int maxLoanYearByMaxAgePlusLoanTerm = loaner.getGender().getMaxAgePlusLoanTerm() - loaner.getLenderAge();
        int maxLoanYearByLoanTermPlusHouseAge = MAX_LOANTERM_PLUS_HOUSE_AGE - loaner.getHouseMaterialAge();
        return new LoanPlantBo(maxLoanYearByMaxAgePlusLoanTerm<=maxLoanYearByLoanTermPlusHouseAge?maxLoanYearByMaxAgePlusLoanTerm:maxLoanYearByLoanTermPlusHouseAge );
    }

    private LoanPlanCalculateUtil() {
        throw new IllegalStateException("Utility class");
    }

}
