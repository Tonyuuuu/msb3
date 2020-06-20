package com.bjmashibing.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Bean (POJO) 相关工具</p>
 *
 * @author sunzhiqiang23
 * @date 2020/1/6 12:22
 */
@Slf4j
public class BeanUtil extends BeanUtils {
    private static JacksonBeanConvertor beanConvertor = new JacksonBeanConvertor();
    /**
     * 任意 Bean 类型转换，深度转换（copyProperties 方法为浅拷贝）
     *
     * @param fromValue 原始 Bean
     * @param toValueType 目标类型
     * @param <T>
     * @return
     */
    public static <T> T copyDeeply(Object fromValue, Class<T> toValueType) {
        return beanConvertor.convert(fromValue, toValueType);
    }

    /**
     * 拷贝列表，需要指定目标列表的元素类型
     *
     * @param sources 原始 Bean 的列表
     * @param target 目标列表元素的类型
     * @param <E>
     * @return
     */
    public static <E> List<E> copyTo(List<?> sources, Class<E> target) {
        if (sources == null) {
            return null;
        }
        if (sources.isEmpty()) {
            return Collections.emptyList();
        }

        List<E> list = new ArrayList<>(sources.size());
        for (Object source : sources) {
            if (source == null) {
                list.add(null);
            } else {
                list.add(copyDeeply(source, target));
            }
        }
        return list;
    }

}
