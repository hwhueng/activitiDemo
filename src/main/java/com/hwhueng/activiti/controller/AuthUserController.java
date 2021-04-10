package com.hwhueng.activiti.controller;

import com.hwhueng.activiti.base.Resp;
import com.hwhueng.activiti.constrant.CacheNames;
import com.hwhueng.activiti.domain.AuthUser;
import com.hwhueng.activiti.service.imp.AuthUserService;
import com.hwhueng.activiti.utils.CacheUtils;
import com.hwhueng.activiti.vo.EmpInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class AuthUserController {
    @Autowired
    AuthUserService authUserService;

    @PostMapping("/info/{empId}")
    public Resp<AuthUser> getEmpInfo(@PathVariable String empId){
        return new Resp<>(authUserService.getByEmpId(empId));
    }

    @PostMapping("/evict/{empId}")
    public Resp<String> evictInfo(@PathVariable String empId){
        CacheUtils.evict(CacheNames.empInfo, empId);
        return new Resp<>();
    }

    @PostMapping("/listByName/{empName}")
    public Resp<List<EmpInfoVo>> getByEmpName(@PathVariable String empName){
        return new Resp<>(authUserService.getByName(empName));
    }
}