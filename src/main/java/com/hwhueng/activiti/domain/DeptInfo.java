package com.hwhueng.activiti.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;


@TableName("dept_info")
@ApiModel(value = "depart info")
public class DeptInfo implements Serializable {
    private static final long serialVersionUID = -591986162053231523L;
    @ApiModelProperty(value = "primary key")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "department id")
    @TableField(value = "dept_id")
    private String deptId;

    @ApiModelProperty(value = "department name")
    @TableField(value = "dept_name")
    private String deptName;

    @ApiModelProperty(value = "parent department id")
    @TableField(value = "parent_id")
    private String parentId;

    @ApiModelProperty(value = "department status, Y for active N for inactive")
    @TableField(value="status")
    private String status;


    @ApiModelProperty(value = "department path", notes = "separate with comma, eg: 201800000,201810000")
    @TableField(value="dept_path")
    private String deptPath;


    @ApiModelProperty(value = "create time")
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "create by")
    @TableField(value = "create_by")
    private String createBy;

    @ApiModelProperty(value = "update time")
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "update by")
    @TableField(value = "update_by")
    private String updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeptPath() {
        return deptPath;
    }

    public void setDeptPath(String deptPath) {
        this.deptPath = deptPath;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
