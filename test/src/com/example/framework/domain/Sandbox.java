package com.example.framework.domain;

import java.util.HashMap;



public class Sandbox {
	private static Sandbox objs = new Sandbox();
	private static HashMap hm = new HashMap();
	public Object get(String key)
	{
		return hm.get(key);
		
	}
	public void push(String key,Object obj)
	{
		hm.put(key, obj);
		
	}
	public  static Sandbox getInstance()
	{
		return objs;
	}

}
