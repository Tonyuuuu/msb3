package com.bjmashibing.shiro.moduler.service.impl;

import com.bjmashibing.shiro.moduler.entity.User;
import com.bjmashibing.shiro.moduler.mapper.UserMapper;
import com.bjmashibing.shiro.moduler.service.UserService;
import com.bjmashibing.shiro.proxy.SysLog;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author 孙志强
 * @since 2020-04-13
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @SysLog
    @Override
    public void aspectj1() {
        System.out.println("aspectj1 执行。。。");
        aspectj2();
        //如何解决单独调用，注解不生效的情况
//        ((UserService) AopContext.currentProxy()).aspectj2();
    }
    @SysLog
    @Override
    public void aspectj2() {
        System.out.println("aspectj2 执行。。。");
    }

    @Override
    @Transactional
    public void parent() {
        User parent = new User();
        parent.setUsername("父亲");
        userMapper.insert(parent);
        // 工作中有这样的需求
        //事务注解和异步注解都不生效
        ((UserService) AopContext.currentProxy()).child();
//       testPrivate();
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Transactional() //根本就没生效
    public void child() {
        User child = new User();
        child.setUsername("儿子");
        userMapper.insert(child);
        System.out.println(1 / 0);
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void testPrivate(){
        User child = new User();
        child.setUsername("private");
        userMapper.insert(child);
        System.out.println(1 / 0);
    }
}
