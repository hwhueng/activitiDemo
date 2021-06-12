package com.hwhueng.activiti.base;


import cn.hutool.core.util.ObjectUtil;
import com.hwhueng.activiti.utils.Msg;
import com.hwhueng.activiti.enums.EnumStatus;
import java.util.HashMap;
import java.util.Map;

public class Resp<T> {
    private T data;
    private Boolean success;

    private int code;

    private Map<String, String> errMsg;

    public Resp(T data){
        this.success = true;
        this.code = EnumStatus.Success.getCode();
        this.data = data;
    }

    public Resp(T data, boolean success, int code){
        this.success = success;
        this.code = code;
        this.data = data;
    }


    public Resp(){
        this.success = true;
        this.code = EnumStatus.Success.getCode();
    }

    public T getData() {
        this.success = true;
        this.code = EnumStatus.Success.getCode();
        return data;

    }

    public Resp<T> setData(T data) {
        this.data = data;
        return this;
    }



    public Map<String, String> getMsg() {
        return errMsg;
    }

    public Resp<T> setErrMsg(Msg msg) {
        if(ObjectUtil.isNull(this.errMsg)){
            this.errMsg = new HashMap<>(16, 0.8f);
        }
        this.errMsg.put(msg.getCode(), msg.getMsg());
        this.setCode(EnumStatus.BusinessFailure.getCode());
        return this;
    }

    public int getCode() {
        return code;
    }

    public Resp<T> setCode(int code) {
        this.code = code;
        if(EnumStatus.Success.getCode() == code){
            this.setSuccess(true);
        }else{
            this.setSuccess(false);
        }
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Resp<T> setSuccess(Boolean success) {
        this.success = success;
        return this;
    }
}
