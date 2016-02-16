package com.pear.controller;

import java.util.Map;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseContorller {
	@InitBinder("dto")  
	public void initUserBinder(WebDataBinder binder) {  
	    binder.setFieldDefaultPrefix("dto.");  
	}
	
}

class Dto{
	private Map<String, Object> map;
	
	private String id;

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
