package com.hwhueng.activiti.controller.model;

import com.hwhueng.activiti.base.Resp;
import com.hwhueng.activiti.domain.ActReModel;
import com.hwhueng.activiti.query.ActModelQuery;
import com.hwhueng.activiti.service.ActReModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/act")
public class QueryListController {
    @Autowired
    ActReModelService actReModelService;

    @PostMapping("/modelList")
    public Resp<List<ActReModel>> gerReModelList(@RequestBody ActModelQuery query){
        return actReModelService.getActModelList(query);
    }
}
