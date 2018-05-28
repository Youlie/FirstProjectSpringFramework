package com.aplose.spring.app;

import java.security.MessageDigest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageDigestFactoryBeans implements FactoryBean<MessageDigest>, InitializingBean {

	
	private MessageDigest md5Digester; 
	
	public void afterPropertiesSet() throws Exception {
		//if (md5Digester)
	}

	public MessageDigest getObject() throws Exception {
		
		return null;
	}

	public Class<?> getObjectType() {
		
		return null;
	}

}
