package com.bjmashibing.shiro.moduler.system.controller;


import com.bjmashibing.shiro.framework.utils.R;
import com.bjmashibing.shiro.moduler.system.entity.User;
import com.bjmashibing.shiro.shiro.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


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
