package com.aplose.spring.testSpring;

import java.lang.reflect.Proxy;

import javax.naming.Context;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aplose.spring.app.AfterReturning;
import com.aplose.spring.app.AnnotationInjection;
import com.aplose.spring.app.AutoWireInjection;
import com.aplose.spring.app.ConsoleWriter;
import com.aplose.spring.app.ConstructorInjection;
import com.aplose.spring.app.Dependency;
import com.aplose.spring.app.MyApp;
import com.aplose.spring.app.SetterInjection;
import com.aplose.spring.app.SetterInjectionFille;
import com.aplose.spring.app.SpringAware;
import com.aplose.spring.app.User;
import com.aplose.spring.app.WriteBeforeAdvice;
import com.aplose.spring.hello.IMessageService;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan
public class App {
	// Class anonyme implémentations
	@Bean
	IMessageService mockMessageService() {
		return new IMessageService() {
			public String getMessage() {
				return "Hello World boubou2!";
			}
		};
	}

	public static void main(String[] args) {

		// récup une instance par application context de spring
		// ApplicationContext context = new
		// AnnotationConfigApplicationContext(App.class);
		

		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml", App.class);
		SpringAware springAware= context.getBean("springAware", SpringAware.class);
		MessagePrinter mp = context.getBean(MessagePrinter.class);
		mp.printMessage();

		/// 03/05/2018 >>
		MyApp app2 = context.getBean("app2", MyApp.class);
		User admin = context.getBean("admin", User.class);
		User otherUser = app2.getUsers().get(0);
		if(otherUser == admin) {
			System.out.println("otherUser et admin sont bien la même instance");
		}else {
			System.out.println("Les deux beans sont diff");
		}
		
		Dependency dependency = context.getBean("dependency", Dependency.class);
		Dependency otherDependency = context.getBean("dependency", Dependency.class);
		if(dependency == otherDependency) {
			System.out.println("C'est dommage ça devrait pas être un singleton");
		}else {
			System.out.println("ouf c est bel et bien deux instances diff wesh ");
		}

		ConstructorInjection ci = context.getBean("constructorInjection", ConstructorInjection.class);
				if(ci!=null) {
					System.out.println("constructorInjection est la");
				}
				
		SetterInjection si = context.getBean("setterInjection", SetterInjection.class);
		if(si!=null) {
			System.out.println("titi est la");
		}
		
		if(ci.getDep()==si.getDependency()) {
			System.out.println("ci.getDep()==si.getDep() : c est dommage ca ");
		}else {
			System.out.println("ci.getDep()==si.getDep() : ouf c est bien une instance diff ");
		}
		
		
		AutoWireInjection ai = context.getBean("autoWireInjection", AutoWireInjection.class);
		if(ai.getDependency()==null) {
			System.out.println("L'injectionn autowire n'a pas fonctionné");
		}else {
			System.out.println("L'injectionn autowire a fonctionné");
		}
		
		AnnotationInjection ai2 = context.getBean("annotationInjection", AnnotationInjection.class);
		if(ai2==null) {
			System.out.println("la config par annotation n'a pas fonctionné");
		}else {
			System.out.println("la config par annotation a fonctionné");
		}
		
		SetterInjectionFille sif = context.getBean("setterInjectionFille", SetterInjectionFille.class);
		Dependency d = sif.getDependency();
		String n = sif.getName();
		if(d == null) {
			System.out.println("la config par annotation a fonctionné");
		}else {
			System.out.println("la config par annotation a fonctionné "+n);
		}
		
		ConsoleWriter targetConsoleWriter = context.getBean("consoleWriter", ConsoleWriter.class);
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new WriteBeforeAdvice());
		pf.addAdvice(new AfterReturning());
		pf.setTarget(targetConsoleWriter);
		ConsoleWriter proxyConsoleWriter = (ConsoleWriter)pf.getProxy();
		proxyConsoleWriter.write("Test de message avec Proxy AOP !");
		
		
		
		//<< fin
		((AbstractApplicationContext) context).close();
	}

}
