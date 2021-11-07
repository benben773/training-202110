package com.example.loan.bo;

public class CheckResultBo {
    public boolean returnCode ;
    private String returnMessage ;

    public CheckResultBo() {
        returnMessage = "";
        returnCode = false;
    }

    public CheckResultBo(boolean returnCode, String returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }

    public boolean getReturnCode() {
        return returnCode;
    }

    @Override
    public String toString() {
        return "{" +
                "\"returnCode\":\"" + returnCode +
                "\",\"returnMessage\":\"" + returnMessage + "\"" +
                '}';
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
