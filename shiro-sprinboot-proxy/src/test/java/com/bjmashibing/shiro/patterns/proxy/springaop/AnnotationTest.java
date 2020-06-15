package com.bjmashibing.shiro.patterns.proxy.springaop;

import com.bjmashibing.shiro.ApplicationTests;
import com.bjmashibing.shiro.moduler.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-09 20:41
 */
public class AnnotationTest extends ApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    public void testAspectOnly(){
        userService.aspectj2();
        userService.aspectj2();
    }
    @Test
    public void testAspectMany(){
        userService.aspectj1();
    }
}
