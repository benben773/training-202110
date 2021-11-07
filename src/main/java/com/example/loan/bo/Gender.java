package com.example.loan.bo;

public enum Gender {
    FEMALE("女性",60), MALE("男性",65);

    private String desc;
    private Integer maxAgePlusLoanTermValue;

    public Integer getMaxAgePlusLoanTermValue() {
        return maxAgePlusLoanTermValue;
    }

    Gender(String desc, Integer maxAgePlusLoanTermValue) {
        this.desc = desc;
        this.maxAgePlusLoanTermValue = maxAgePlusLoanTermValue;
    }

    public String getDesc() {
        return desc;
    }
}
