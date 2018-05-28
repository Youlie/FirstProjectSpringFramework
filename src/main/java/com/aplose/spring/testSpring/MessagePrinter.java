package com.aplose.spring.testSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aplose.spring.hello.IMessageService;

@Component
public class MessagePrinter {

	private static IMessageService ms;

	@Autowired
	public MessagePrinter(IMessageService ms) {
		this.ms = ms;
	}

	public void printMessage() {
		System.out.println(ms.getMessage());
	}

}
