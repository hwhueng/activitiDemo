package com.hwhueng.activiti.vo;

import java.io.Serializable;
import java.util.List;

public class OrgTreeVo implements Serializable {
    private static final long serialVersionUID = -8490414043194791479L;
    private String deptName;
    private String deptId;
    private String parentId;
    private List<OrgTreeVo> childrenList;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<OrgTreeVo> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<OrgTreeVo> childrenList) {
        this.childrenList = childrenList;
    }
}
