package com.hwhueng.activiti.exception;

import com.hwhueng.activiti.common.CodeResult;


public class BusinessException extends RuntimeException implements CodeResult {

    private int code = 500;
    private String msg;
    private boolean success;
    private CodeResult codeResult;

    public int getCode() {
        return code;
    }

    @Override
    public boolean getSuccess() {
        return false;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public CodeResult getCodeResult() {
        return codeResult;
    }

    public void setCodeResult(CodeResult codeResult) {
        this.codeResult = codeResult;
    }

    public BusinessException(String template, Object... params){
        super(String.format(template, params));
        this.msg = String.format(template, params);
    }

    public BusinessException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(String msg){
        super(msg);
        this.msg = msg;
    }

    public BusinessException(String msg, Throwable e){
        super(msg);
        this.msg = msg;
    }

    public String toString(){
        return this.msg;
    }
}
