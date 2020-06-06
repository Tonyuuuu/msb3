package com.bjmashibing.shiro.service;

import com.bjmashibing.shiro.proxy.SysLog;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-06 17:41
 */
@Service
public class UserServiceImpl implements UserService{
    @SysLog
    @Override
    public int add() {
        System.out.println("添加用户");
        select();
        return 0;
    }
    @SysLog
    @Override
    public int select() {
        System.out.println("查询用户");
        return 0;
    }
}
