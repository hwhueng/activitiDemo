package com.hwhueng.activiti.base;

public class PageResp<T> extends Resp<T>{
    private Long count;
    public PageResp(T data) {
        super(data);
    }

    public Long getCount() {
        return count;
    }

    public PageResp<T> setCount(Long count) {
        this.count = count;
        return this;
    }
}
