package com.digiwin.sampleapp1.batest.dao;


import com.digiwin.sampleapp1.batest.domian.SolutionStepInfo;
import com.digiwin.sampleapp1.batest.domian.Vo;


import java.util.List;
import java.util.Map;

public interface SolutionMeasureDao {

    //第一场景：只新增解决方案步骤信息
    int addStepOne(SolutionStepInfo solutionStepInfo);

    //根据步骤id查询步骤信息
    SolutionStepInfo selectStepById(String uuid);

    //根据解决方案id查询查询解决方案步骤
    List<SolutionStepInfo>  selectStepListByEditId(String uuid1);

    List<Vo> selectMaxStepId();
}
