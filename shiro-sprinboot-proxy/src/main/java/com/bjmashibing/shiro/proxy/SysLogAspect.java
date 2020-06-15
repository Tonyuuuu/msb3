package com.bjmashibing.shiro.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



/**
 * <p>系统日志，切面处理类</p>
 *
 * @author sunzhiqiang23
 * @date 2019/9/27 19:33
 */
//@Aspect
//@Component
public class SysLogAspect {

	@Pointcut("@annotation(com.bjmashibing.shiro.proxy.SysLog)")
	public void logPointCut() {

	}
	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		//执行方法
		Object result =null ;
		try {
			result = point.proceed();
			System.out.println("【记录日志】");
			//执行时长(毫秒)
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
