package com.bjmashibing.shiro.moduler.system.service.impl;

import com.bjmashibing.shiro.moduler.system.entity.User;
import com.bjmashibing.shiro.moduler.system.entity.UserToken;
import com.bjmashibing.shiro.moduler.system.mapper.UserMapper;
import com.bjmashibing.shiro.moduler.system.mapper.UserTokenMapper;
import com.bjmashibing.shiro.moduler.system.service.ShiroService;
import com.bjmashibing.shiro.moduler.system.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserTokenMapper userTokenMapper;

    @Override
    public List<String> getUserPermissions(long userId) {
        List<String> permsList = userService.queryAllPerms(userId);
        return permsList;
    }

    @Override
    public UserToken queryByToken(String token) {
        return userTokenMapper.queryByToken(token);
    }

    @Override
    public User queryUser(Long userId) {
        return userMapper.selectById(userId);
    }
}
