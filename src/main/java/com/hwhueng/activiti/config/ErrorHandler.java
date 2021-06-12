package com.hwhueng.activiti.config;

import com.hwhueng.activiti.base.Resp;
import com.hwhueng.activiti.enums.EnumStatus;
import com.hwhueng.activiti.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorHandler {
 
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Resp<Object> handleCustomException(BusinessException ce){
        return new Resp<>(ce.getMsg(), ce.getSuccess(), ce.getCode());
    }

    @ExceptionHandler(value=Exception.class)
    public Resp<Object> exceptionHandler(Exception e){
        return new Resp<>(e.getMessage(), false, EnumStatus.Error.getCode());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
 
}