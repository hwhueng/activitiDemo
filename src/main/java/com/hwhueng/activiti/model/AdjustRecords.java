package com.hwhueng.activiti.model;

import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;

public class AdjustRecords implements Serializable {

    private static final long serialVersionUID = 1181993095687612090L;
    @ExcelProperty(value = "工号")
    private String empId;

    @ExcelProperty(value = "姓名")
    private String empName;

    @ExcelProperty(value = "部门")
    private String deptName;

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
