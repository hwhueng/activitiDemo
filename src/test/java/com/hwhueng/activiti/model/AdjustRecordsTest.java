package com.hwhueng.activiti.model;


import com.alibaba.excel.annotation.ExcelProperty;
import com.google.common.collect.Lists;
import com.hwhueng.activiti.constant.CacheNames;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

public class AdjustRecordsTest {

    @Test
    public void getHeader(){
        Field[] fields = AdjustRecords.class.getDeclaredFields();
        List<String> headers = Lists.newArrayList();
        for(Field field: fields){
            ExcelProperty ann = field.getAnnotation(ExcelProperty.class);
            if(ann == null){
                continue;
            }
            headers.add(ann.value()[0]);
            System.out.printf("%s annotation: %s%n", field.getName(), ann.value()[0]);
        }
        System.out.println("Headers: " + ArrayUtils.toString(headers));
    }

    @Test
    public void getFieldValue() throws IllegalAccessException {
        for(Field field: CacheNames.class.getFields()){
            if(!Modifier.isFinal(field.getModifiers())){
                System.out.printf("%s is not final", field.getName());
                continue;
            }
            System.out.printf("%s value %s\n", field.getName(), field.get(null).toString());
        }
    }

}