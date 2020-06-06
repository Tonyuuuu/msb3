package com.bjmashibing.shiro.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br>
 * JVM参数
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=12m
 * 模拟Metaspace空间溢出，我们不断生成类王空间灌，类占据的空间总是会超过Metaspace指定的空间大小的。
 **/

public class MataspaceOOMTest {
	static class OOMTest{
	}
	public static void main(String[] args) {
		int i = 0;  //模拟计数多少次以后发生异常
		try {
			while(true){
				i++;
				Enhancer enhancer = new Enhancer();
				enhancer.setSuperclass(OOMTest.class);
				enhancer.setUseCache(false);
				enhancer.setCallback(new MethodInterceptor() {
					@Override
					public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
						return methodProxy.invoke(o,args);
					}
				});
				enhancer.create();
			}

		} catch (Throwable throwable) {
			System.out.println("*******多少次后发生了异常：" + i);
			throwable.printStackTrace();
		}


	}

}
