package com.hwhueng.activiti.controller.model;

import cn.hutool.core.collection.CollectionUtil;
import com.hwhueng.activiti.base.Resp;
import com.hwhueng.activiti.exception.BusinessException;
import com.hwhueng.activiti.service.BpmModelService;
import org.activiti.engine.repository.Model;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin
@Service
@RequestMapping("/model")
public class BpmModelController {
    @Autowired
    BpmModelService bpmModelService;

    @RequestMapping("createModel")
    @ResponseBody
    public Resp<String> createModel(HttpServletRequest request, HttpServletResponse response){
        Model model = bpmModelService.createModel();
        if(model != null && StringUtils.isNotEmpty(model.getId())){
            try {
                request.setAttribute("modelId", model.getId());
                response.sendRedirect(request.getContextPath() + "/modeler.html?modelId=" + model.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            return  new Resp<>();
        }
        return new Resp<>();
    }

    @RequestMapping("delete")
    @ResponseBody
    public Resp<String> deleteModel(HttpServletRequest request) throws BusinessException{
        bpmModelService.deleteModel(request.getParameter("modelId"));
        return new Resp<>();
    }

}
