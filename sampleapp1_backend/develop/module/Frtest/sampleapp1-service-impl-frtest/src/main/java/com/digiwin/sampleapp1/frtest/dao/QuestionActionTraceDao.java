package com.digiwin.sampleapp1.frtest.dao;

import com.digiwin.sampleapp1.frtest.domain.entity.QuestionActionTraceEntity;
import java.util.Map;

public interface QuestionActionTraceDao {
    //添加
    int add(QuestionActionTraceEntity questionActionTrace);

    //查询返回信息
    Map selectReturnInfo(String oid);
}
