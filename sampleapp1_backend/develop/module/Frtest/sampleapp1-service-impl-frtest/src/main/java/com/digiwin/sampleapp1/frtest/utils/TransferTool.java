package com.digiwin.sampleapp1.frtest.utils;

import com.digiwin.sampleapp1.frtest.domain.entity.AttachmentsEntity;
import com.digiwin.sampleapp1.frtest.domain.entity.DataInstanceEntity;
import com.digiwin.sampleapp1.frtest.domain.entity.QuestionActionTraceEntity;
import com.digiwin.sampleapp1.frtest.domain.model.AttachmentModel;
import com.digiwin.sampleapp1.frtest.domain.model.QuestionInfoModel;
import org.springframework.beans.BeanUtils;


public class TransferTool {

    /**
     * 将追踪表的model转成entity
     * @param model
     * @return
     */
    public static QuestionActionTraceEntity transTraceEntity(QuestionInfoModel model) {
            QuestionActionTraceEntity traceEntity=new QuestionActionTraceEntity();
            BeanUtils.copyProperties(model,traceEntity);
            //设置追踪表oid
            traceEntity.setOid(UUIDUtil.getUUID());
            traceEntity.setTenantsid(TenantSidUtil.getTenantSid());
            //设置追踪表的数据实例id
            traceEntity.setDataInstanceOid(UUIDUtil.getUUID());
            traceEntity.setCreateName(TenantSidUtil.getUserName());
            traceEntity.setUpdateName(TenantSidUtil.getUserName());
        return traceEntity;
    }


    /**
     * 将附件表的model转成entity
     * @param model
     * @return AttachmentsEntity
     */
    public static AttachmentsEntity transAttachmentEntity(AttachmentModel model,QuestionActionTraceEntity traceEntity) {
            AttachmentsEntity attachmentsEntity = new AttachmentsEntity();
            BeanUtils.copyProperties(model,attachmentsEntity);
            //设置附件
            attachmentsEntity.setTenantsid(TenantSidUtil.getTenantSid());
            attachmentsEntity.setDataInstanceOid(traceEntity.getDataInstanceOid());
            //设置附件后缀名
            String attachmentTitle = attachmentsEntity.getAttachmentTitle();
            attachmentsEntity.setExtensionName(attachmentTitle.substring(attachmentTitle.lastIndexOf(".")+1));
        return attachmentsEntity;
    }



}
