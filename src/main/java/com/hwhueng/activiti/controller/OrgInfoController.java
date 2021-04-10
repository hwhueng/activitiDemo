package com.hwhueng.activiti.controller;

import com.hwhueng.activiti.base.Resp;
import com.hwhueng.activiti.service.imp.MdmOrgInfoService;
import com.hwhueng.activiti.vo.OrgTreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/org")
public class OrgInfoController {

    @Autowired
    MdmOrgInfoService mdmOrgInfoService;

    @PostMapping("/tree")
    public Resp<List<OrgTreeVo>> getOrgTree(){
        return new Resp<>(mdmOrgInfoService.getOrgTreeVo());
    }
}
