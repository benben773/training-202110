package com.example.loan.util;

import com.example.loan.bo.Gender;
import com.example.loan.bo.LoanPlantChectBo;
import com.example.loan.bo.UserLoanPlanMaterial;

/**
 * @author ：ls05
 * @date ：Created in 2021/11/12 19:16
 */
public class LoanPlanCheckUtil {

    private static final int MAX_LOAN_TERM = 30;
    private static final int MAX_LOAN_TERM_PLUS_HOUSE_AGE = 40;

    public static LoanPlantChectBo check(Integer loanTerm, UserLoanPlanMaterial loaner) {
        if (loanTerm > MAX_LOAN_TERM) {
            return new LoanPlantChectBo("住房贷款年限最长为" + MAX_LOAN_TERM + "年",true);
        }
        Gender gender = loaner.getGender();
        if (loaner.getLenderAge() + loanTerm > gender.getMaxAgePlusLoanTerm()) {
            return new LoanPlantChectBo(String.format("%s_年龄_加_贷款年限_不能超过%d", gender.getDesc(), gender.getMaxAgePlusLoanTerm()),false);
        }
        if (loaner.getHouseMaterialAge()+ loanTerm > MAX_LOAN_TERM_PLUS_HOUSE_AGE) {
            return new LoanPlantChectBo(String.format("贷款年限加上房龄总和不能超过%s年", MAX_LOAN_TERM_PLUS_HOUSE_AGE),false);
        }
        return new LoanPlantChectBo("",true);
    }

    private LoanPlanCheckUtil() {
        throw new IllegalStateException("Utility class");
    }
}
