package com.hwhueng.activiti.service;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwhueng.activiti.base.BaseService;
import com.hwhueng.activiti.base.PageResp;
import com.hwhueng.activiti.domain.ActReModel;
import com.hwhueng.activiti.exception.BusinessException;
import com.hwhueng.activiti.mapper.ActReModelMapper;
import com.hwhueng.activiti.query.ActModelQuery;
import org.activiti.engine.RepositoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActReModelService extends BaseService<ActReModelMapper, ActReModel> {

    public PageResp<List<ActReModel>> getActModelList(ActModelQuery query){
        Page<ActReModel> page = new Page<>(query.getCurPage(), query.getPageSize());
        IPage<ActReModel>   actReModelIPage = baseMapper.selectPage(page, qw().lambda().ne(ActReModel::getmId, ""));
        return new PageResp<>(actReModelIPage.getRecords()).setCount(actReModelIPage.getTotal());
    }


}
