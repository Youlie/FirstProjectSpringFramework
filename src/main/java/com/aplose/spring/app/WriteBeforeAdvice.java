package com.aplose.spring.app;
import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class WriteBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("before method : " +method.getName());
	}
}