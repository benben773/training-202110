package com.example.loan.controller;

import com.example.loan.bo.LoanPlantBo;
import com.example.loan.bo.LoanPlantChectBo;
import com.example.loan.bo.UserLoanPlanMaterial;
import com.example.loan.service.LoanPlanService;
import com.example.loan.util.LoanPlanCalculateUtil;
import com.example.loan.util.LoanPlanCheckUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("loan-plans")
public class LoanController {
    private final LoanPlanService loanPlanService;

    public LoanController(LoanPlanService loanPlanService) {
        this.loanPlanService = loanPlanService;
    }

    @GetMapping("/{idCard}")
    public UserLoanPlanMaterial getUserLoadPlanMaterial(@PathVariable String idCard) {
        return loanPlanService.getUserLoadPlanMaterial(idCard);
    }
    @GetMapping("/loan-plans-check/{idCard}/{loanTerm}")
    public String getUserLoadPlanCheck(@PathVariable String idCard,@PathVariable Integer loanTerm) {
        UserLoanPlanMaterial loaner = loanPlanService.getUserLoadPlanMaterial(idCard);
        LoanPlantChectBo check = LoanPlanCheckUtil.check(loanTerm, loaner);
        return check.toString();
    }
    @GetMapping("/loan-calculateUserLoadPlan/{idCard}/{loanTerm}")
    public String calculateUserLoadPlan(@PathVariable String idCard,@PathVariable Integer loanTerm) {
        UserLoanPlanMaterial loaner = loanPlanService.getUserLoadPlanMaterial(idCard);
        LoanPlantBo check = LoanPlanCalculateUtil.calculateUserLoanPlan(loaner);
        return check.toString();
    }


}
