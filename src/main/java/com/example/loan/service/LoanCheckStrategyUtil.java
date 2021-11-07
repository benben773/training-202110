package com.example.loan.service;

import com.example.loan.bo.Gender;

public class LoanCheckStrategyUtil {

    public static String checkeLenderAndLoanTerm(Gender gender, Integer lenderAge, Integer loanTerm) {
        String result = "";
        if(gender == Gender.MALE){
            if (lenderAge + loanTerm <= 65) {
                result = generateResultMessage("0", "returnMessage");
            }
        }else if(gender == Gender.FEMALE) {
            if (lenderAge + loanTerm <= 60) {
                result = generateResultMessage("0", "returnMessage");
            }else{
                result = generateResultMessage("-1", "女性_年龄_加_贷款年限_不能超过60");
            }

        }
        return result;
    }

    private static String generateResultMessage(String resultCode, String returnMessage) {
        String result;
        result = "{\"returnCode\": \"" + resultCode + "\",\"" + returnMessage + "\":\"\"}";
        return result;
    }
}
