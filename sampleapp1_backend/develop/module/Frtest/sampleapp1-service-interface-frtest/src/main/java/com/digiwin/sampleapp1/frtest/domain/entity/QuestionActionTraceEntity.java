package com.digiwin.sampleapp1.frtest.domain.entity;


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
public class QuestionActionTraceEntity {

    private String oid;

    private long tenantsid;

    private String questionRecordOid;

    private String questionProcessStep;

    private String questionSolveStep;

    private String questionNo;

    private String questionDescription;


    private int questionProcessStatus;

    private int questionProcessResult;

    private String handleComment;

    private String returnFlagId;

    private String returnFlagName;

    private String dataInstanceOid;

    private Date startTime;

    private Date expectCompleteDate;

    private Date actualCompleteDate;

    private int principalStep;

    private String liablePersonId;

    private String liablePersonName;

    private String liablePersonPositionId;

    private String liablePersonPositionName;

    private Date createDate;

    private String createName;

    private Date updateDate;

    private String updateName;

    private String RES01;

    private String RES02;

    private String RES03;

    private String RES04;

    private String RES05;

    private String returnNo;

    private String returnId;

    private String returnName;

    private String createId;

    private String closeReason;

    private String returnStepNo;

}
