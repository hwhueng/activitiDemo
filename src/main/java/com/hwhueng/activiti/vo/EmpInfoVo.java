package com.hwhueng.activiti.vo;

import java.io.Serializable;

public class EmpInfoVo implements Serializable {
    private static final long serialVersionUID = 3721811680914490548L;

    private String empName;
    private String empId;
    private String deptId;
    private String deptName;
    private String deptPath;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String dept) {
        this.deptId = dept;
    }

    public String getDeptPath() {
        return deptPath;
    }

    public void setDeptPath(String deptPath) {
        this.deptPath = deptPath;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
