package com.bjmashibing.shiro.proxy;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> </p>
 *
 * @author sunzhiqiang23
 * @date 2019/9/27 13:42
 */
@Configuration
public class AnnotationProcessorConfiguration {
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }
    @Bean
    public LogAdvisor logAdvisor(){
        LogAdvisor logAdvisor = new LogAdvisor();
        return logAdvisor;
    }

}