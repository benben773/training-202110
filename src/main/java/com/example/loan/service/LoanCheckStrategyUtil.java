package com.example.loan.service;

import com.example.loan.bo.Gender;

public class LoanCheckStrategyUtil {

    public static String checkeLenderAndLoanTerm(Gender gender, Integer lenderAge, Integer loanTerm, String resultCode, String returnMessage) {
        String result = "";
        if(gender == Gender.MALE){
            if (lenderAge + loanTerm <= 65) {
                result = "{\"returnCode\": \"" + resultCode + "\",\"" + returnMessage + "\":\"\"}";
            }
        }
        return result;
    }
}
