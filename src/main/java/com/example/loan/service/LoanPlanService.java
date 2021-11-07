package com.example.loan.service;

import com.example.loan.bo.Gender;
import com.example.loan.bo.UserLoanPlanMaterial;
import com.example.loan.dao.UserLoanPlanMaterialDAO;
import org.springframework.stereotype.Service;

@Service
public class LoanPlanService {
    private final UserLoanPlanMaterialDAO userLoanPlanMaterialDAO;

    public LoanPlanService(UserLoanPlanMaterialDAO userLoanPlanMaterialDAO) {
        this.userLoanPlanMaterialDAO = userLoanPlanMaterialDAO;
    }

    public UserLoanPlanMaterial getUserLoadPlanMaterial(String idCard) {
        return userLoanPlanMaterialDAO.selectUserLoanPlanMaterial(idCard);
    }

    public String checkUserLoadPlan(String idCard, Integer loanTerm) {
        String result ="";
        UserLoanPlanMaterial userLoanPlanMaterial = userLoanPlanMaterialDAO.selectUserLoanPlanMaterial(idCard);
        Gender gender = userLoanPlanMaterial.getGender();
        Integer lenderAge = userLoanPlanMaterial.getLenderAge();
        String resultCode = "0";
        String returnMessage = "returnMessage";
        result = checkeLenderAndLoanTerm(loanTerm, result, gender, lenderAge, resultCode, returnMessage);
        return result;
    }

    private String checkeLenderAndLoanTerm(Integer loanTerm, String result, Gender gender, Integer lenderAge, String resultCode, String returnMessage) {
        if(gender == Gender.MALE){
            if (lenderAge + loanTerm <= 65) {
                result = "{\"returnCode\": \"" + resultCode + "\",\"" + returnMessage + "\":\"\"}";
            }
        }
        return result;
    }
}
