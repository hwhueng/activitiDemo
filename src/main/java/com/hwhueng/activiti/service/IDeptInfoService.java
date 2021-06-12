package com.hwhueng.activiti.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwhueng.activiti.domain.DeptInfo;
import com.hwhueng.activiti.vo.OrgTreeVo;

import java.util.List;
import java.util.Map;

public interface IDeptInfoService extends IService<DeptInfo> {
    Map<String, DeptInfo> allDeptMap();
    List<OrgTreeVo> getOrgTreeVo();
    List<DeptInfo> getAllOrgInfo();
}
