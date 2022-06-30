package com.digiwin.sampleapp1.batest.domian;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;


public class SolutionInfo {
        private  String solutionKeyId;
        private Long tenantsid;
        private  String solutionId;
        private  String solutionName;
        private  String manageStatus;
        private  int isDefault;
        private  String liablePersonId;
        private  String liablePersonName;
        private  Date createTime;
        private  String createName;
        private  Date updateTime;
        private  String updateName;
         //用来放置解决方案步骤信息
        private List<SolutionStepInfo> solutionStepInfo;

    public List<SolutionStepInfo> getSolutionStepInfo() {
        return solutionStepInfo;
    }

    public void setSolutionStepInfo(List<SolutionStepInfo> solutionStepInfo) {
        this.solutionStepInfo = solutionStepInfo;
    }

    public String getSolutionKeyId() {
        return solutionKeyId;
    }

    public void setSolutionKeyId(String solutionKeyId) {
        this.solutionKeyId = solutionKeyId;
    }

    public Long getTenantsid() {
        return tenantsid;
    }

    public void setTenantsid(Long tenantsid) {
        this.tenantsid = tenantsid;
    }

    public String getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(String solutionId) {
        this.solutionId = solutionId;
    }

    public String getSolutionName() {
        return solutionName;
    }

    public void setSolutionName(String solutionName) {
        this.solutionName = solutionName;
    }

    public String getManageStatus() {
        return manageStatus;
    }

    public void setManageStatus(String manageStatus) {
        this.manageStatus = manageStatus;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public String getLiablePersonId() {
        return liablePersonId;
    }

    public void setLiablePersonId(String liablePersonId) {
        this.liablePersonId = liablePersonId;
    }

    public String getLiablePersonName() {
        return liablePersonName;
    }

    public void setLiablePersonName(String liablePersonName) {
        this.liablePersonName = liablePersonName;
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
        return "SolutionInfo{" +
                "solutionKeyId='" + solutionKeyId + '\'' +
                ", tenantsid=" + tenantsid +
                ", solutionId='" + solutionId + '\'' +
                ", solutionName='" + solutionName + '\'' +
                ", manageStatus='" + manageStatus + '\'' +
                ", isDefault=" + isDefault +
                ", liablePersonId='" + liablePersonId + '\'' +
                ", liablePersonName='" + liablePersonName + '\'' +
                ", createTime=" + createTime +
                ", createName='" + createName + '\'' +
                ", updateTime=" + updateTime +
                ", updateName='" + updateName + '\'' +
                ", solutionStepInfo=" + solutionStepInfo +
                '}';
    }
}
