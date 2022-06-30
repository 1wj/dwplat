package com.digiwin.sampleapp1.batest.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.digiwin.sampleapp1.batest.dao.SolutionEditDao;
import com.digiwin.sampleapp1.batest.dao.SolutionMeasureDao;
import com.digiwin.sampleapp1.batest.domian.*;
import com.digiwin.sampleapp1.batest.service.IEditMessagesService;
import com.digiwin.sampleapp1.batest.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

public class EditMessageService implements IEditMessagesService {
    @Autowired
    private SolutionEditDao solutionEditDao;
    @Autowired
    private SolutionMeasureDao solutionMeasureDao;
    static int editOne;
    Map<String,String> messauseMap=new HashMap<>();
    @Override
    public Map addEditMessage(String std_data) throws Exception {
        //获取最大方案id和相应的步骤最大id
        this.frontSource();
        JSONArray solutionInfos = ParamUtil.getJSONArray(std_data);
        List<SolutionInfo> FinalInfos=new ArrayList<>();
        Map ret=new HashMap();
        //获取租户id
        long tenantSid = TenantSidUtil.getTenantSid("tenantSid");
        for (int i = 0; i < solutionInfos.size(); i++) {
            SolutionInfo solutionInfo = (SolutionInfo) solutionInfos.getObject(i,SolutionInfo.class);
            if(solutionInfo.getSolutionStepInfo().size()==0){//只新增方案
                String uuid = this.addSameEdit(solutionInfo, ret,tenantSid);
                this.find(FinalInfos,uuid);
            }else {
                String solutionKeyId = solutionInfo.getSolutionKeyId();
                if(null==solutionKeyId || "".equals(solutionKeyId)){//增加两个
                    this.fun2(solutionInfo,FinalInfos,ret,tenantSid);
                }else {//只增加步骤
                    this.fun3(solutionInfo,FinalInfos,solutionKeyId,tenantSid);
                }
            }
        }
        ret.put("solution_info",FinalInfos);
        return ret;
    }

    //增加方案和步骤
    private void  fun2(SolutionInfo solutionInfo,List<SolutionInfo> FinalInfos,Map ret,long tenantSid) throws Exception {
        String uuid1 = this.addSameEdit(solutionInfo, ret,tenantSid);
        List<SolutionStepInfo> solutionStepInfo1 = solutionInfo.getSolutionStepInfo();
        for (int j = 0; j < solutionStepInfo1.size(); j++) {
            SolutionStepInfo solutionStepInfo = solutionStepInfo1.get(j);
            this.addSameMessure(uuid1,solutionInfo, solutionStepInfo,tenantSid);
        }
        this.find(FinalInfos,uuid1);
    }
    //只新增步骤
    private void  fun3(SolutionInfo solutionInfo,List<SolutionInfo> FinalInfos,String solutionKeyId,long tenantSid){
        List<SolutionStepInfo> solutionStepInfos = solutionInfo.getSolutionStepInfo();
        for (int j = 0; j < solutionStepInfos.size(); j++) {
            SolutionStepInfo solutionStepInfo = solutionStepInfos.get(j);
            SolutionInfo solutionInfo1 = solutionEditDao.selectEditById(solutionKeyId);
            this.addSameMessure(solutionKeyId,solutionInfo1, solutionStepInfo,tenantSid);
        }
        this.find(FinalInfos,solutionKeyId);
    }
    //增加方案的共同部分
    private String addSameEdit(SolutionInfo solutionInfo,Map ret,long tenantSid) throws Exception {
        //设置solution_key_id主键
        String uuid = UUIDUtil.getUUID();
        solutionInfo.setSolutionKeyId(uuid);
        String solutionId="SE"+String.format("%03d", ++editOne);
        solutionInfo.setSolutionId(solutionId);
        solutionInfo.setTenantsid(tenantSid);
        if("Y".equals(solutionInfo.getManageStatus())||"N".equals(solutionInfo.getManageStatus())){
            solutionInfo.setManageStatus(solutionInfo.getManageStatus());
        }else {
            ret.put("errorMessage","生效输入错误");
            throw new Exception("生效输入错误");
        }
        if(solutionInfo.getIsDefault()!=0 && solutionInfo.getIsDefault()!=1){
            ret.put("errorMessage","默认输入错误");
            throw new Exception("默认输入错误");
        }
        //插入方案
        solutionEditDao.addEditOne(solutionInfo);
        return uuid;
    }
    //增加步骤的共同部分
    private  void addSameMessure(String id,SolutionInfo solutionInfo1,SolutionStepInfo solutionStepInfo,long tenantSid){
        String uuid3 = UUIDUtil.getUUID();
        solutionStepInfo .setSolutionStepId(uuid3);
        solutionStepInfo.setSolutionKeyId(id);
        //设置步骤编号
        if (messauseMap.get(id)==null){
            messauseMap.put(id,"SEXXX000");
        }
        String substring1 = messauseMap.get(id).substring(5);
        Integer messauseOne = Integer.valueOf(substring1);
        String stepId=solutionInfo1.getSolutionId()+String.format("%03d", ++messauseOne);
        solutionStepInfo.setStepId(stepId);
        messauseMap.put(id,stepId);
        //设置tenantSid
        solutionStepInfo.setTenantsid(tenantSid);
        //添加解决方案步骤
        solutionMeasureDao.addStepOne(solutionStepInfo);
    }
    //查寻结果
    private void find(List<SolutionInfo> FinalInfos, String id){
        SolutionInfo solutionInfo1 = solutionEditDao.selectEditById(id);
        List<SolutionStepInfo> solutionStepInfos1 = solutionMeasureDao.selectStepListByEditId(id);
        solutionInfo1.setSolutionStepInfo(solutionStepInfos1);
        FinalInfos.add(solutionInfo1);
    }
    //获取前置资源
    private void  frontSource(){
        String maxSolutionId = solutionEditDao.selectMaxSolutionId();
        String substring = maxSolutionId.substring(2);
        editOne=Integer.valueOf(substring);
        List<Vo> vos = solutionMeasureDao.selectMaxStepId();
        for (int i = 0; i < vos.size(); i++) {
            messauseMap.put(vos.get(i).getSolutionStepId(),vos.get(i).getMaxId());
        }
    }
}