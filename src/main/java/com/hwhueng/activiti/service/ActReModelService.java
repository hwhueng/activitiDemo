package com.hwhueng.activiti.service;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwhueng.activiti.base.BaseService;
import com.hwhueng.activiti.base.PageResp;
import com.hwhueng.activiti.domain.ActReModel;
import com.hwhueng.activiti.mapper.ActReModelMapper;
import com.hwhueng.activiti.query.ActModelQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActReModelService extends BaseService<ActReModelMapper, ActReModel> {

    public PageResp<List<ActReModel>> getActModelList(ActModelQuery query){
        Page<ActReModel> page = new Page<>(query.getCurPage(), query.getPageSize());
        IPage<ActReModel>   actReModelIPage = baseMapper.selectPage(page, qw());
        return new PageResp<>(actReModelIPage.getRecords()).setCount(actReModelIPage.getPages());

    }
}
