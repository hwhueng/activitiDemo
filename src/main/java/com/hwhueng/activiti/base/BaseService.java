package com.hwhueng.activiti.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
    public BaseService(){}

    public QueryWrapper<T> qw(){
        return new QueryWrapper<>();
    }

    public QueryWrapper<T> qw(T t){
        return new QueryWrapper<>(t);
    }

    public UpdateWrapper<T> uw(){
        return new UpdateWrapper<>();
    }

    public UpdateWrapper<T> uw(T t){
        return new UpdateWrapper<>(t);
    }
}
