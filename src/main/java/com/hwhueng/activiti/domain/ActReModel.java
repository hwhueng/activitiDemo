package com.hwhueng.activiti.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

@TableName("act_re_model")
public class ActReModel {
    @TableField("ID_")
    private String mId;

    @TableField("REV_")
    private Long rev;

    @TableField("NAME_")
    private String name;

    @TableField("CATEGORY_")
    private String category;

    @TableField("CREATE_TIME_")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField("LAST_UPDATE_TIME_")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdateTime;

    @TableField("VERSION_")
    private Long version;

    @TableField("DEPLOYMENT_ID_")
    private String deploymentId;

    @TableField("EDITOR_SOURCE_VALUE_ID_")
    private String editorSourceValueId;

    @TableField("EDITOR_SOURCE_EXTRA_VALUE_ID_")
    private String editorSourceExtraValueId;

    @TableField("TENANT_ID_")
    private String tenantId;


    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public Long getRev() {
        return rev;
    }

    public void setRev(Long rev) {
        this.rev = rev;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getEditorSourceValueId() {
        return editorSourceValueId;
    }

    public void setEditorSourceValueId(String editorSourceValueId) {
        this.editorSourceValueId = editorSourceValueId;
    }

    public String getEditorSourceExtraValueId() {
        return editorSourceExtraValueId;
    }

    public void setEditorSourceExtraValueId(String editorSourceExtraValueId) {
        this.editorSourceExtraValueId = editorSourceExtraValueId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
