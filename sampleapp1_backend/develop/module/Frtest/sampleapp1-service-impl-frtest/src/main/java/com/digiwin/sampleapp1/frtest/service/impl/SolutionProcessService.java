package com.digiwin.sampleapp1.frtest.service.impl;

import com.alibaba.fastjson.JSON;
import com.digiwin.app.dao.DWServiceResultBuilder;
import com.digiwin.app.service.DWServiceResult;
import com.digiwin.sampleapp1.frtest.annotation.ValidationCheck;
import com.digiwin.sampleapp1.frtest.dao.*;
import com.digiwin.sampleapp1.frtest.domain.entity.AttachmentsEntity;
import com.digiwin.sampleapp1.frtest.domain.entity.DataInstanceEntity;
import com.digiwin.sampleapp1.frtest.domain.entity.QuestionActionTraceEntity;
import com.digiwin.sampleapp1.frtest.domain.model.AttachmentModel;
import com.digiwin.sampleapp1.frtest.domain.model.QuestionInfoModel;
import com.digiwin.sampleapp1.frtest.utils.*;
import com.digiwin.sampleapp1.frtest.service.ISolutionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class SolutionProcessService implements ISolutionProcessService {

    @Autowired
    private AttachmentsDao attachmentsDao;
    @Autowired
    private DataInstanceDao dataInstanceDao;
    @Autowired
    private QuestionActionTraceDao questionActionTraceDao;

    /**
     * 增加接口
     * @param std_data
     * @return DWServiceResult
     * @throws Exception
     */
    @Transactional
    @Override
    public DWServiceResult solutionProcess(String  std_data) throws Exception {

        //对入参进行解析
        Map Models = ParseParamUtil.parseInfo(std_data);
        List<QuestionInfoModel> questionTraceInfoModelLists= (List<QuestionInfoModel>) Models.get("questionInfoModels");
        List<AttachmentModel> attachmentModelList= (List<AttachmentModel>) Models.get("attachmentModels");
        //设置并添加问题行为追踪
        QuestionActionTraceEntity traceEntity=null;
        for (int i = 0; i < questionTraceInfoModelLists.size(); i++) {
            ValidationCheck.check(questionTraceInfoModelLists.get(i));//校验
            traceEntity= TransferTool.transTraceEntity(questionTraceInfoModelLists.get(i));
            questionActionTraceDao.add(traceEntity);
        }
        //设置并添加附件
        AttachmentsEntity attachmentEntity=null;
        for (int i = 0; i < attachmentModelList.size(); i++) {
             ValidationCheck.check(attachmentModelList.get(i));//校验
             attachmentEntity=TransferTool.transAttachmentEntity(attachmentModelList.get(i),traceEntity);
             attachmentsDao.add(attachmentEntity);
        }
        //设置并添加数据实例表
        DataInstanceEntity dataInstanceEntity = this.setDataContnetEntity(traceEntity);
        dataInstanceDao.add(dataInstanceEntity);
        //查出需要返回的数据数据
        Map returnMap=this.selectInfo(traceEntity,questionTraceInfoModelLists);
        return DWServiceResultBuilder.build(returnMap);
    }

    /**
     * 查询接口
     * @param std_data
     * @return DWServiceResult
     * @throws Exception
     */
    @Override
    public DWServiceResult solutionInfo(String std_data) throws Exception {
        //解析参数
        String param = ParseParamUtil.parseQueryInfo(std_data);
        String questionResult = dataInstanceDao.selectByTraceOid(param);
        //转成json
        Map returnMap = JSON.parseObject(questionResult,Map.class);
        return DWServiceResultBuilder.build(returnMap);

    }

    /**
     * 设置数据实例表参数
     * @param traceEntity
     * @return DataInstanceEntity
     */
    private DataInstanceEntity setDataContnetEntity(QuestionActionTraceEntity traceEntity) {
        DataInstanceEntity dataInstanceEntity = new DataInstanceEntity();
        dataInstanceEntity.setOid(traceEntity.getDataInstanceOid());
        dataInstanceEntity.setQuestionTraceOid(traceEntity.getOid());
        dataInstanceEntity.setTenantsid(TenantSidUtil.getTenantSid());
        dataInstanceEntity.setCreateName(TenantSidUtil.getUserName());
        dataInstanceEntity.setUpdateName(TenantSidUtil.getUserName());
        //查找datacontent字段内容
        String data = dataInstanceDao.selectDataInfo(traceEntity.getQuestionNo());
        //设置DataContent字段
        dataInstanceEntity.setDataContent(data);
        return dataInstanceEntity;
    }

    /**
     * 增加接口后查出需要返回的数据数据
     * @param traceEntity
     * @param questionTraceInfoModelLists
     * @return Map
     */
    private  Map selectInfo(QuestionActionTraceEntity traceEntity,List<QuestionInfoModel> questionTraceInfoModelLists ) {
        Map ReturnMap=new HashMap();
        Map<String, Object> map=questionActionTraceDao.selectReturnInfo(traceEntity.getOid());
        map.put("pending_approve_question_id",questionTraceInfoModelLists.get(0).getQuestionId());
        map.put("employee_id","");
        map.put("employee_name","");
        ReturnMap.put("return_data",map);
        return ReturnMap;





    }
}