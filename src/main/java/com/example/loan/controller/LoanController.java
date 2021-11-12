package com.example.loan.controller;

import com.example.loan.bo.UserLoanPlanMaterial;
import com.example.loan.service.LoanPlanService;
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
        if (loaner.getLenderAge() + loanTerm > 65) {
            return "{\"returnCode\":\"false\",\"returnMessage\":\"男性_年龄_加_贷款年限_不能超过65\"}";
        }
        return "{\"returnCode\":\"true\",\"returnMessage\":\"\"}";
    }

}
