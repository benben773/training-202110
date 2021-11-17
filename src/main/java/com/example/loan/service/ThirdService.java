package com.example.loan.service;

import org.springframework.stereotype.Service;

@Service
public class ThirdService {

    private static final String STR = "你好，JMockit!";

    protected String sayHello() {
        return STR;
    }
}
