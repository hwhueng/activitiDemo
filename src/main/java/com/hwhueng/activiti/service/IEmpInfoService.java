package com.hwhueng.activiti.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwhueng.activiti.domain.EmpInfo;
import com.hwhueng.activiti.vo.EmpInfoVo;

import java.util.List;

public interface IEmpInfoService extends IService<EmpInfo> {
    List<EmpInfoVo> getByName(String name);

    EmpInfo getByEmpId(String empId);
}
