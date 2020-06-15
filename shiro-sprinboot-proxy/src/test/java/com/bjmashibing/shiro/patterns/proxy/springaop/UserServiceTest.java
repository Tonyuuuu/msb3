package com.bjmashibing.shiro.patterns.proxy.springaop;

import com.bjmashibing.shiro.ApplicationTests;
import com.bjmashibing.shiro.moduler.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-09 21:45
 */
public class UserServiceTest extends ApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    public void test(){
        userService.parent();
    }

}
