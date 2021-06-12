package com.hwhueng.activiti.utils;

public class Msg {
    private final String code;
    private final String msg;

    public Msg(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
