package com.bjmashibing.shiro;

import com.bjmashibing.shiro.service.UserService;
import com.bjmashibing.shiro.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-06 17:43
 */
@Slf4j
public class UserServiceTest extends ApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    public void add(){
        //userservice 真正运行的时候，是不是代理对象？
        userService.add();

    }
}
