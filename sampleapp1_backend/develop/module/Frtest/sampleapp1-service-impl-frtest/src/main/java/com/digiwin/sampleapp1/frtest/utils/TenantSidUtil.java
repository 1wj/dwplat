package com.digiwin.sampleapp1.frtest.utils;

import com.digiwin.app.service.DWServiceContext;

import java.util.Map;

public class TenantSidUtil {
    public static long getTenantSid(){
        DWServiceContext context = DWServiceContext.getContext();
        Map<String, Object> profile = context.getProfile();
        long tenantSid = (long) profile.get("tenantSid");
        return tenantSid;
    }

    public static String getUserName(){
        DWServiceContext context = DWServiceContext.getContext();
        Map<String, Object> profile = context.getProfile();
        String userName = (String) profile.get("userName");
        return userName;
    }

    public static String getUserId(){
        DWServiceContext context = DWServiceContext.getContext();
        Map<String, Object> profile = context.getProfile();
        String userId = (String) profile.get("userId");
        return userId;
    }
}
