package com.example.loan.bo;

/**
 * @author ：ls05
 * @date ：Created in 2021/11/12 22:06
 */
public class LoanPlantChectBo {
    private String returnMessage;
    private boolean returnCode;

    public LoanPlantChectBo(String returnMessage, boolean returnCode) {
        this.returnMessage = returnMessage;
        this.returnCode = returnCode;
    }

    @Override
    public String toString() {
        return "{" +
                "\"returnMessage\":" + (returnMessage == null ? "null" : "\"" + returnMessage + "\"") + ", " +
                "\"returnCode\":\"" + returnCode + "\"" +
                "}";
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public boolean getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(boolean returnCode) {
        this.returnCode = returnCode;
    }
}
