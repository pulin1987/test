package com.pulin.springbootpulin.test.push.serializer;

import java.util.Map;

public class Person {
	private String name;
	private Map<String,Object> map;
	
	public Person(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}
