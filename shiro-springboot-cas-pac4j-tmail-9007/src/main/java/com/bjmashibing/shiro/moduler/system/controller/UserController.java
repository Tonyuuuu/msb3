package com.bjmashibing.shiro.moduler.system.controller;


import com.bjmashibing.shiro.framework.utils.R;
import com.bjmashibing.shiro.moduler.system.entity.User;
import com.bjmashibing.shiro.shiro.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author 孙志强
 * @since 2020-04-13
 */
@RestController
public class UserController {

    /**
     * 获取登录的用户信息
     */
    @GetMapping("/sys/user/info")
    public R info(){
        return R.ok().put("user", new User());
    }


}
