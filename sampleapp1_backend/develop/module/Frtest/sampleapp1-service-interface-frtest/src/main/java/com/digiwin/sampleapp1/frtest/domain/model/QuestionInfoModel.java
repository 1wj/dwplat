package com.digiwin.sampleapp1.frtest.domain.model;


import com.alibaba.fastjson.annotation.JSONField;
import com.digiwin.sampleapp1.frtest.annotation.Validation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuestionInfoModel {

    @JSONField(name = "question_record_id")
    @Validation(message = "问题记录oid不能为空")
    private String questionRecordOid;

    @JSONField(name = "question_process_step")
    @Validation(message = "问题解决步骤不能为空")
    private String questionProcessStep;

    @JSONField(name = "question_solve_step")
    @Validation(message = "问题解决步骤不能为空")
    private String questionSolveStep;

    @JSONField(name = "question_no")
    @Validation(message = "问题编号不能为空")
    private String questionNo;

    @JSONField(name = "question_description")
    @Validation(message = "问题描述不能为空")
    private String questionDescription;

    @JSONField(name = "question_process_status")
    @Validation(message = "问题解决状态不能为空")
    private int questionProcessStatus;

    @JSONField(name = "question_process_result")
    @Validation(message = "问题过程结果不能为空")
    private int questionProcessResult;

    @JSONField(name = "return_flag_id")
    @Validation(message = "返回标志不能为空")
    private String returnFlagId;

    @JSONField(name = "return_flag_name")
    @Validation(message = "返回标志名称不能为空")
    private String returnFlagName;

    @JSONField(name = "expect_complete_date")
    @Validation(message = "预计完成不能为空")
    private Date expectCompleteDate;

    @JSONField(name = "principal_step")
    @Validation
    private int principalStep;

    @JSONField(name = "liable_person_id")
    @Validation(message = "处理人id不能为空")
    private String liablePersonId;

    @JSONField(name = "liable_person_name")
    @Validation(message = "处理人姓名不能为空")
    private String liablePersonName;

    @JSONField(name = "liable_person_position_id")
    @Validation(message = "处理人部门id不能为空")
    private String liablePersonPositionId;

    @JSONField(name = "liable_person_position_name")
    @Validation(message = "处理人部门名称不能为空")
    private String liablePersonPositionName;

    @JSONField(name = "")
    @Validation(message = "返回编号不能为空")
    private String returnNo;

    @JSONField(name = "return_step_no")
    @Validation(message = "问题步骤编号不能为空")
    private String returnStepNo;

    @JSONField(name = "question_id")
    @Validation(message = "问题id不能为空")
    private String questionId;

    @JSONField(name = "return_person_id")
    @Validation(message = "返回人id不能为空")
    private String returnPersonId;

    @JSONField(name = "return_person_name")
    @Validation(message = "返回人姓名不能为空")
    private String returnPersonName;
}
