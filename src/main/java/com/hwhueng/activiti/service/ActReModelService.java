package com.hwhueng.activiti.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwhueng.activiti.base.PageResp;
import com.hwhueng.activiti.domain.ActReModel;
import com.hwhueng.activiti.mapper.ActReModelMapper;
import com.hwhueng.activiti.query.ActModelQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActReModelService extends ServiceImpl<ActReModelMapper, ActReModel> implements IService<ActReModel> {

    public PageResp<List<ActReModel>> getActModelList(ActModelQuery query){
        Page<ActReModel> page = new Page<>(query.getCurPage(), query.getPageSize());
        LambdaQueryWrapper<ActReModel> qwr = Wrappers.lambdaQuery();
        IPage<ActReModel> actReModelIPage = baseMapper.selectPage(page, qwr.ne(ActReModel::getmId, ""));
        return new PageResp<>(actReModelIPage.getRecords()).setCount(actReModelIPage.getTotal());
    }

    public LambdaQueryWrapper<ActReModel> makeQuery(ActModelQuery query){
        LambdaQueryWrapper<ActReModel> qwr = Wrappers.lambdaQuery();
        Optional.ofNullable(query.getInstanceIdList()).ifPresent(e->qwr.in(ActReModel::getCategory, e));
        return qwr;
    }




}
