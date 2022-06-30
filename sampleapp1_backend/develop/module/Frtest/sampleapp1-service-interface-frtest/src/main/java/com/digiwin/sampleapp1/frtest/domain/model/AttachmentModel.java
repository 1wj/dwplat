package com.digiwin.sampleapp1.frtest.domain.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.digiwin.sampleapp1.frtest.annotation.Validation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttachmentModel {

    @JSONField(name = "id")
    @Validation(message = "oid不能为空")
    private String oid;

    @JSONField(name = "question_no")
    @Validation(message = "编号不能为空")
    private String questionNo;

    @JSONField(name = "")
    @Validation(message = "标题不能为空")
    private String attachmentTitle;

    @JSONField(name = "attachment_description")
    @Validation(message = "描述不能为空")
    private String attachmentDescription;

    @JSONField(name = "attachment_type")
    @Validation(message = "类型不能为空")
    private int attachmentType;

    @JSONField(name = "dmc_id")
    @Validation(message = "dmcid不能为空")
    private String dmcId;
}
