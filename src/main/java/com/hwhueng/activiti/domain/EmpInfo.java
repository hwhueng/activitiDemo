package com.hwhueng.activiti.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@TableName("emp_info")
public class EmpInfo implements Serializable {
    private static final long serialVersionUID = -8823948112828136121L;
    @ApiModelProperty(value = "primary key")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value="employee id")
    @TableField(value = "emp_id")
    private String empId;

    @ApiModelProperty(value="employee name")
    @TableField(value = "emp_name")
    private String empName;

    @ApiModelProperty(value="dept id")
    @TableField(value = "dept_id")
    private String deptId;

    @ApiModelProperty(value = "mail")
    @TableField(value = "mail")
    private String mail;

    @ApiModelProperty(value = "phone")
    @TableField(value = "phone")
    private String phone;

    @ApiModelProperty(value = "hire date")
    @TableField(value = "hire_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate hireDate;

    @ApiModelProperty(value = "probation date")
    @TableField(value = "probation_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate probationDate;

    @ApiModelProperty(value = "create time")
    @TableField(value = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "create by")
    @TableField(value = "create_by")
    private String createBy;

    @ApiModelProperty(value = "update time")
    @TableField(value = "update_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getProbationDate() {
        return probationDate;
    }

    public void setProbationDate(LocalDate probationDate) {
        this.probationDate = probationDate;
    }
}
