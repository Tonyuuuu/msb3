package com.bjmashibing.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Bean 类型转换 - Jackson 版实现
 *
 * @author sunzhiqiang
 * @version 1.0
 * @date 2017/4/14
 */
@Slf4j
public class JacksonBeanConvertor {
    private static ObjectMapper objectMapper;
    static {
        objectMapper = new ObjectMapper();
        //指定时间格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //检测所有字段，包括私有的
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //序列化时忽略空属性
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //反序列化时忽略不一致成员变量
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public <T> T convert(Object fromValue, Class<T> toValueType) {
        return objectMapper.convertValue(fromValue, toValueType);
    }

    public <T> T convert(Object fromValue, Type typeOfT) {
        JavaType toValueType = objectMapper.getTypeFactory().constructType(typeOfT);
        return objectMapper.convertValue(fromValue, toValueType);
    }

}
