package com.example.loan.service;

import org.springframework.stereotype.Service;

@Service
public class ThirdService {

    public static final String STR = "你好，JMockit!";

    public String sayHello() {
        return STR;
    }
}
