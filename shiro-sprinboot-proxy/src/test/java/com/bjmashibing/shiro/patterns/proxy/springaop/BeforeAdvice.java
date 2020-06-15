package com.bjmashibing.shiro.patterns.proxy.springaop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-13 14:48
 */
public class BeforeAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("代理方法执行："+method.getName());
    }
}
