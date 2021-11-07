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
        UserLoanPlanMaterial userLoanPlanMaterial = userLoanPlanMaterialDAO.selectUserLoanPlanMaterial(idCard);
        Gender gender = userLoanPlanMaterial.getGender();
        Integer lenderAge = userLoanPlanMaterial.getLenderAge();
        String result = LoanCheckStrategyUtil.checkeLenderAndLoanTerm(gender, lenderAge, loanTerm,userLoanPlanMaterial.getHouseMaterial().getAge()).toString();
        return result;
    }

}
