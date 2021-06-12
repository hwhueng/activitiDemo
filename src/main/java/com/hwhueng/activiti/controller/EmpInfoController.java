package com.hwhueng.activiti.controller;

import com.hwhueng.activiti.base.Resp;
import com.hwhueng.activiti.domain.EmpInfo;
import com.hwhueng.activiti.service.IEmpInfoService;
import com.hwhueng.activiti.vo.EmpInfoVo;
import io.swagger.annotations.ApiModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@ApiModel("employee info")
@RequestMapping(value = "/employee")
public class EmpInfoController {
    @Resource
    IEmpInfoService empInfoService;


    @PostMapping("/listByName/{empName}")
    public Resp<List<EmpInfoVo>> getByEmpName(@PathVariable String empName) {
        return new Resp<>(empInfoService.getByName(empName));
    }

    @PostMapping("/info/{empId}")
    public Resp<EmpInfo> getEmpInfo(@PathVariable String empId){
        return new Resp<>(empInfoService.getByEmpId(empId));
    }
}
