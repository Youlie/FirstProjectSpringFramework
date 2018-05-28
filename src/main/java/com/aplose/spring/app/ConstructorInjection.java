package com.aplose.spring.app;

public class ConstructorInjection {

	private Dependency dep;
	public ConstructorInjection(Dependency d) {
		this.dep=d;
	}
	public Dependency getDep() {
		return dep;
	}
	
}
