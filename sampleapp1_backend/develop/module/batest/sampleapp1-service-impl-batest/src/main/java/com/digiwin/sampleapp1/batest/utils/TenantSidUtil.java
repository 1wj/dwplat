package com.digiwin.sampleapp1.batest.utils;

import com.digiwin.app.service.DWServiceContext;

import java.util.Map;

public class TenantSidUtil {
    public static long getTenantSid(String tenantSid){
        DWServiceContext context = DWServiceContext.getContext();
        Map<String, Object> profile = context.getProfile();
        long tenantSid2 = (long) profile.get(tenantSid);
        return tenantSid2;
    }
}
