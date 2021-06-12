package com.hwhueng.activiti.controller;

import com.hwhueng.activiti.base.Resp;
import com.hwhueng.activiti.service.IDeptInfoService;
import com.hwhueng.activiti.vo.OrgTreeVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/dept")
public class DeptInfoController {
    @Resource
    IDeptInfoService deptInfoService;

    @ApiOperation(value = "dept tree")
    @PostMapping("/tree")
    public Resp<List<OrgTreeVo>> getOrgTree(){
        return new Resp<>(deptInfoService.getOrgTreeVo());
    }
}
