package com.hwhueng.activiti.base;


import com.hwhueng.activiti.enums.EnumStatus;

public class Resp<T> {
    private T data;
    private Boolean success;



    private int code;



    private String msg;

    public Resp(T data){
        this.success = true;
        this.code = EnumStatus.Success.getCode();
        this.data = data;

    }

    public T getData() {
        this.success = true;
        this.code = EnumStatus.Success.getCode();
        return data;

    }

    public void setData(T data) {
        this.data = data;
    }



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
