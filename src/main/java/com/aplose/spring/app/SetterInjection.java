package com.aplose.spring.app;

public class SetterInjection {
	private Dependency dependency;

	public void setDependency(Dependency dep) {
		this.dependency = dep;
	}

	public Dependency getDependency() {
		return dependency;
	}
	

}
