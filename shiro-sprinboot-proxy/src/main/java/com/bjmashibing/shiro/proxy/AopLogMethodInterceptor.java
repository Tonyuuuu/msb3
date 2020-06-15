package com.bjmashibing.shiro.proxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * <p> </p>
 *
 * @author sunzhiqiang23
 * @date 2019/9/27 13:43
 */
public class AopLogMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getThis().getClass().getDeclaredMethod(invocation.getMethod().getName(),invocation.getMethod().getParameterTypes());
        Object proceed = invocation.proceed();
        System.out.println(invocation);
        System.out.println("记录日志");
        return proceed;
    }


}
