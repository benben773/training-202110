package com.example.loan.util;

import com.example.loan.bo.LoanPlantBo;
import com.example.loan.bo.LoanPlantChectBo;
import com.example.loan.bo.UserLoanPlanMaterial;

/**
 * @author ：ls05
 * @date ：Created in 2021/11/17 16:16
 */
public class LoanPlanCalculateUtil {

    private static final int MAX_LOANTERM_PLUS_HOUSE_AGE = 40;

    public static LoanPlantBo calculateUserLoanPlan(Integer loanTerm, UserLoanPlanMaterial loaner) {
        LoanPlantChectBo check = LoanPlanCheckUtil.check(loanTerm, loaner);
        if (!check.getReturnCode()) {
            LoanPlantBo loanPlantBo = new LoanPlantBo();
            loanPlantBo.setReturnMessage(check.getReturnMessage());
            return loanPlantBo;
        }
        int maxLoanYearByMaxAgePlusLoanTerm = loaner.getGender().getMaxAgePlusLoanTerm() - loaner.getLenderAge();
        int maxLoanYearByLoanTermPlusHouseAge = MAX_LOANTERM_PLUS_HOUSE_AGE - loaner.getHouseMaterialAge();
        int minCalculate = Math.min(maxLoanYearByMaxAgePlusLoanTerm, maxLoanYearByLoanTermPlusHouseAge);
        return new LoanPlantBo(Math.min(minCalculate,loanTerm));
    }

    private LoanPlanCalculateUtil() {
        throw new IllegalStateException("Utility class");
    }

}
