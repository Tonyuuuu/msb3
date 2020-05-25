package com.bjmashibing.shiro.shiro;



import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-05-14 20:39
 **/
public class CallbackFilter extends io.buji.pac4j.filter.CallbackFilter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        super.doFilter(servletRequest, servletResponse, filterChain);
    }
}
