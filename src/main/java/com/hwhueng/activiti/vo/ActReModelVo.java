package com.hwhueng.activiti.vo;

import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDateTime;

public class ActReModelVo {

    private String id;

    private Long rev;

    private String name;

    private String key;

    private String category;

    private LocalDateTime createTime;

    private LocalDateTime lastUpdateTime;

    private Long version;

    private String deploymentId;

    private String editorSourceValueId;

    private String editorSourceExtraValueId;

    private String tenantId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
