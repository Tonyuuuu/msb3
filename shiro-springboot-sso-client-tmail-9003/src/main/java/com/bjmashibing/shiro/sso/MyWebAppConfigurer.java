package com.bjmashibing.shiro.sso;

import com.bjmashibing.shiro.sso.SsoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-04-29 23:10
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SsoInterceptor())//增加过滤的方法类
                .addPathPatterns("/**");//定义过滤的范围
    }
}


