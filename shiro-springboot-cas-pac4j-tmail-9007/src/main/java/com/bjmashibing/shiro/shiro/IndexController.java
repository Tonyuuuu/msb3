package com.bjmashibing.shiro.shiro;

import com.bjmashibing.shiro.framework.utils.R;
import io.buji.pac4j.subject.Pac4jPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-05-18 15:24
 */
@Slf4j
@RestController
public class IndexController {

    /**
     * cas登录认证
     *
     * @return 登录结果
     * @author jay
     * @date 2019-12-20
     */
    @GetMapping({"/", "/index"})
    public void login(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            Pac4jPrincipal principal = (Pac4jPrincipal) request.getUserPrincipal();
//            String userStr = (String) principal.getProfile().getId();
//            String loginAccount = userStr.split(":")[0];
//            //aes 16位加密，防止恶意登录
//            log.info("---sso返回参数---loginAccount："+loginAccount
//            );
//            String url = "http://localhost/#/login?loginAccount=" + loginAccount + "&sso_service_ticket=" + UUID.randomUUID().toString();
//            response.sendRedirect(url);
//        } catch (Exception e) {
//            System.out.println("登录失败,请联系管理员！");
//            e.printStackTrace();
//        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getDomain()+"==="+cookie.getName());
            System.out.println(cookie.getValue());
        }

    }
}
