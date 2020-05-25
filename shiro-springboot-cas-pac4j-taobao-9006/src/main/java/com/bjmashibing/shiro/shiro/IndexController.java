package com.bjmashibing.shiro.shiro;

import com.bjmashibing.shiro.framework.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-05-18 15:24
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public Object index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getDomain()+"==="+cookie.getName());
            System.out.println(cookie.getValue());
        }
        return R.ok();
    }
}
