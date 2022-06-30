package com.digiwin.sampleapp1.batest.domian;

import java.math.BigInteger;
import java.util.Date;

public class SolutionStepInfo {
        private String solutionStepId;
        private Long tenantsid;
        private String solutionKeyId;
        private String stepId;
        private String stepName;
        private String processPersonId;
        private String processPersonName;
        private int expectCompleteDays;
        private Date createTime;
        private String createName;
        private Date updateTime;
        private String updateName;
        public String getSolutionStepId() {
        return solutionStepId;
    }

    public void setSolutionStepId(String solutionStepId) {
        this.solutionStepId = solutionStepId;
    }

    public Long getTenantsid() {
        return tenantsid;
    }

    public void setTenantsid(Long tenantsid) {
        this.tenantsid = tenantsid;
    }

    public String getSolutionKeyId() {
        return solutionKeyId;
    }

    public void setSolutionKeyId(String solutionKeyId) {
        this.solutionKeyId = solutionKeyId;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getProcessPersonId() {
        return processPersonId;
    }

    public void setProcessPersonId(String processPersonId) {
        this.processPersonId = processPersonId;
    }

    public String getProcessPersonName() {
        return processPersonName;
    }

    public void setProcessPersonName(String processPersonName) {
        this.processPersonName = processPersonName;
    }

    public int getExpectCompleteDays() {
        return expectCompleteDays;
    }

    public void setExpectCompleteDays(int expectCompleteDays) {
        this.expectCompleteDays = expectCompleteDays;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    @Override
    public String toString() {
        return "SolutionStepInfo{" +
                "solutionStepId='" + solutionStepId + '\'' +
                ", tenantsid=" + tenantsid +
                ", solutionKeyId='" + solutionKeyId + '\'' +
                ", stepId='" + stepId + '\'' +
                ", stepName='" + stepName + '\'' +
                ", processPersonId='" + processPersonId + '\'' +
                ", processPersonName='" + processPersonName + '\'' +
                ", expectCompleteDays=" + expectCompleteDays +
                ", createTime=" + createTime +
                ", createName='" + createName + '\'' +
                ", updateTime=" + updateTime +
                ", updateName='" + updateName + '\'' +
                '}';
    }
}
