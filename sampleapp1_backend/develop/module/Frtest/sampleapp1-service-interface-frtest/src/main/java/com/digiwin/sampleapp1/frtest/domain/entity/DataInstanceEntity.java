package com.digiwin.sampleapp1.frtest.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.digiwin.sampleapp1.frtest.annotation.Validation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataInstanceEntity {

    @JSONField(name = "oid")
    @Validation
    private String oid;

    @JSONField(name = "tenantsid")
    @Validation
    private long tenantsid;

    @JSONField(name = "question_trace_oid")
    @Validation
    private String questionTraceOid;

    @JSONField(name = "data_content")
    @Validation
    private String dataContent;

    @JSONField(name = "create_date")
    @Validation
    private Date createDate;

    @JSONField(name = "create_name")
    @Validation
    private String createName;

    @JSONField(name = "update_date")
    @Validation
    private Date updateDate;

    @JSONField(name = "update_name")
    @Validation
    private String updateName;

}
