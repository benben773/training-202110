package com.example.loan.bo;

public enum Gender {
    FEMALE("女性"), MALE("男性");

    private String desc;

    Gender(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
