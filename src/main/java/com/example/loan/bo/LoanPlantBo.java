package com.example.loan.bo;

/**
 * @author ：ls05
 * @date ：Created in 2021/11/17 15:38
 */
public class LoanPlantBo {
    private String returnMessage;
    private boolean returnCode;
    private Integer maxLoanYear;

    public LoanPlantBo() {
        this.returnMessage = "";
        this.returnCode = false;
    }
    public LoanPlantBo(Integer maxLoanYear) {
        this.returnMessage = "";
        this.returnCode = true;
        this.maxLoanYear = maxLoanYear;
    }

    @Override
    public String toString() {
        return "{" +
                "\"returnCode\":\"" + returnCode + "\"" + "," +
                "\"returnMessage\":" + (returnMessage == null ? "null" : "\"" + returnMessage + "\"") + "," +
                "\"maxLoanYear\":" + (maxLoanYear == null ? "null" : "\"" + maxLoanYear + "\"") +
                "}";
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public boolean isReturnCode() {
        return returnCode;
    }

    public void setReturnCode(boolean returnCode) {
        this.returnCode = returnCode;
    }

    public Integer getMaxLoanYear() {
        return maxLoanYear;
    }

    public void setMaxLoanYear(Integer maxLoanYear) {
        this.maxLoanYear = maxLoanYear;
    }
}
