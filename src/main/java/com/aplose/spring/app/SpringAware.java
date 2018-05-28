package com.aplose.spring.app;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringAware implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, InitializingBean, DisposableBean{

	public void destroy() throws Exception {
		System.out.println("DESTROY");
		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("AFTER PROPERTIES SET");
		
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("SET APPLICATION CONTEXT");
		
	}

	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("SET BEAN CLASS LOADER");
		
	}

	public void setBeanName(String name) {
		System.out.println("SET BEAN NAME : "+name);
		
	}
	
	
	
	

}
