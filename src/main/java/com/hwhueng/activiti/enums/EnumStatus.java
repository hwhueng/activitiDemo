package com.hwhueng.activiti.enums;


public enum EnumStatus {
    Success(200),
    Unauthorized(401),
    Error(500),
    BusinessFailure(700),
    ValidateFailure(800),
    ;

    private final int code;

    private EnumStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
