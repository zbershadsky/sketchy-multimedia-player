package com.paziy.sketchy.request.model;

public class APIParameter {
	private String name;
	private String value;
	
	public APIParameter(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return name + "=" + value;
	}
}
