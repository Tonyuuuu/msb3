package com.bjmashibing.shiro.moduler.system.service;


import com.bjmashibing.shiro.moduler.system.entity.UserToken;
import com.bjmashibing.shiro.moduler.system.entity.User;

import java.util.List;
import java.util.Set;

/**
 * shiro相关接口
 * @author liuzp
 * @email liuzp6@163.com
 * @date 2017-06-06 8:49
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    List<String> getUserPermissions(long userId);

    UserToken queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    User queryUser(Long userId);
}
