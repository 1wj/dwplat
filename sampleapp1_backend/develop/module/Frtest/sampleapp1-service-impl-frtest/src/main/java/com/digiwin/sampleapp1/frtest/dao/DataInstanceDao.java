package com.digiwin.sampleapp1.frtest.dao;

import com.digiwin.sampleapp1.frtest.domain.entity.DataInstanceEntity;

public interface DataInstanceDao {
    //增加实例信息
    int add(DataInstanceEntity dataInstance);

    //查询实例信息根据追踪oid
    String selectByTraceOid(String questionActionTraceOid);

    //增加数据前的获取dataContent字段信息
    String selectDataInfo(String questionNo);
}
