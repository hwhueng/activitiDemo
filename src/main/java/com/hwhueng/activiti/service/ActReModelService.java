package com.hwhueng.activiti.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwhueng.activiti.base.BaseService;
import com.hwhueng.activiti.base.PageResp;
import com.hwhueng.activiti.domain.ActReModel;
import com.hwhueng.activiti.mapper.ActReModelMapper;
import com.hwhueng.activiti.query.ActModelQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActReModelService extends BaseService<ActReModelMapper, ActReModel> {

    public PageResp<List<ActReModel>> getActModelList(ActModelQuery query){
        Page<ActReModel> page = new Page<>(query.getCurPage(), query.getPageSize());
        IPage<ActReModel>   actReModelIPage = baseMapper.selectPage(page, qw().lambda().ne(ActReModel::getmId, ""));
        return new PageResp<>(actReModelIPage.getRecords()).setCount(actReModelIPage.getTotal());
    }

    public QueryWrapper<ActReModel> makeQuery(ActModelQuery query){
        QueryWrapper<ActReModel> qwr = new QueryWrapper<>();
        Optional.ofNullable(query.getInstanceIdList()).ifPresent(e->qwr.lambda().in(ActReModel::getCategory, e));

        return qwr;
    }




}
