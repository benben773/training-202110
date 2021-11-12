package com.example.loan.util;

import com.example.loan.bo.UserLoanPlanMaterial;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：ls05
 * @date ：Created in 2021/11/12 19:16
 */
public class LoanPlanCheckUtil {
    public static String check(Integer loanTerm, UserLoanPlanMaterial loaner) {
        if (loaner.getLenderAge() + loanTerm > 65) {
            return "{\"returnCode\":\"false\",\"returnMessage\":\"男性_年龄_加_贷款年限_不能超过65\"}";
        }
        return "{\"returnCode\":\"true\",\"returnMessage\":\"\"}";
    }
}
