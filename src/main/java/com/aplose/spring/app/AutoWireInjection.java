package com.aplose.spring.app;

public class AutoWireInjection {
	
	private Dependency dependency;

	public Dependency getDependency() {
		return dependency;
	}

	public void setDependency(Dependency dependency) {
		this.dependency = dependency;
	}
	
}
