package com.hwhueng.activiti.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwhueng.activiti.domain.AuthUser;
import com.hwhueng.activiti.vo.EmpInfoVo;

import java.util.List;

public interface IAuthUserService extends IService<AuthUser> {
    AuthUser getByEmpId(String empId);

    List<EmpInfoVo> getByName(String name);
}
