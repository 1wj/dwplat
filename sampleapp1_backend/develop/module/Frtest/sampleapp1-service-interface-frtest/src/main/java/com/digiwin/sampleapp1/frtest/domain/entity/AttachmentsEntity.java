package com.digiwin.sampleapp1.frtest.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttachmentsEntity {

    private String oid;

    private long tenantsid;

    private String dataInstanceOid;

    private String questionNo;

    private String attachmentTitle;

    private String extensionName;

    private String attachmentDescription;

    private int attachmentType;

    private String dmcId;
}
