package com.bjmashibing.shiro.proxy;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.reflect.misc.MethodUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;


/**
 * 系统日志，切面处理类
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017年3月8日 上午11:07:35
 */
@Aspect
@Component
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
			System.out.println("=============");
			//执行时长(毫秒)
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
