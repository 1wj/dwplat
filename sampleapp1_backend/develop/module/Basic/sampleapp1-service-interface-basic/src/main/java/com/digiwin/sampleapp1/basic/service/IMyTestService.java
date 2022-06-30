package com.digiwin.sampleapp1.basic.service;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

import java.util.Map;

public interface IMyTestService  extends DWService {

    @AllowAnonymous   //不考虑登录可以运行匿名调用
    public String getMyTest(Map params)throws Exception;

}
