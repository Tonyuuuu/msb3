package com.bjmashibing.shiro.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-06 17:16
 */

public class Client {

    @Test
    public void testJdkProxy(){
        LogService logService = new LogServiceImpl();
        LogInvocationHandler handler = new LogInvocationHandler(logService);
        LogService proxy = (LogService)handler.getProxy();
        proxy.log();
    }

    @Test
    public void testCglib() {
        LogService logService = new LogServiceImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(logService.getClass());
        enhancer.setCallback(NoOp.INSTANCE);
        //设置类加载器
        enhancer.setClassLoader(logService.getClass().getClassLoader());
        LogServiceImpl proxy = (LogServiceImpl)enhancer.create();
        proxy.log();
    }
}
