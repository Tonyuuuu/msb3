package com.bjmashibing.shiro.patterns.proxy.springaop;

import com.bjmashibing.shiro.moduler.service.UserService;
import com.bjmashibing.shiro.moduler.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-13 14:47
 */
public class SpringAdviceTest {
    @Test
    public void testAdvice() {
        UserService target = new UserServiceImpl();
        BeforeAdvice beforeAdvice = new BeforeAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(beforeAdvice);

        UserService proxy = (UserService) proxyFactory.getProxy();
        proxy.aspectj1();

    }
}
