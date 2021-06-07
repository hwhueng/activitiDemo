package com.hwhueng.activiti.controller.model;

import com.hwhueng.activiti.base.Resp;
import com.hwhueng.activiti.exception.BusinessException;
import com.hwhueng.activiti.service.imp.BpmModelService;
import com.hwhueng.activiti.vo.DeployModelVo;
import org.activiti.engine.repository.Model;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin
@Service
@RequestMapping("/model")
public class BpmModelController {
    @Resource
    BpmModelService bpmModelService;

    @RequestMapping("/delete/{modelId}")
    @ResponseBody
    public Resp<String> deleteModel(@PathVariable String modelId) throws BusinessException{
        bpmModelService.deleteModel(modelId);
        return new Resp<>();
    }

    @RequestMapping("/deploy")
    @ResponseBody
    public Resp<String> deploy(@RequestBody DeployModelVo vo){
        return bpmModelService.deployModel(vo);
    }

}
