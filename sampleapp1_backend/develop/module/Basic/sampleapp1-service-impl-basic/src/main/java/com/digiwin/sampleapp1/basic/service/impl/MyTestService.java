package com.digiwin.sampleapp1.basic.service.impl;

import com.digiwin.sampleapp1.basic.service.IMyTestService;

import java.util.Map;

public class MyTestService implements IMyTestService {
    @Override
    public String getMyTest(Map params) throws Exception {
        return "ok";
    }
}
