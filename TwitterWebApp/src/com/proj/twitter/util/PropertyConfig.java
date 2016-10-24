package com.proj.twitter.util;

import java.util.Properties;

import javax.servlet.ServletContext;

public class PropertyConfig {
	
	private static PropertyConfig instance;
	
	public static synchronized PropertyConfig getInstance(ServletContext context){
		
		if(instance == null){
			instance = new PropertyConfig(context);
		}
		return instance;
	}
	
	private PropertyConfig(ServletContext context){
		try
		{
			prop.load(context.getResourceAsStream("WEB-INF/twitterapp.properties"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static synchronized PropertyConfig getInstance() throws Exception{
		if( instance == null)
			throw new Exception("Not Initialized");
		
		return instance;
	}
	
	
	static Properties prop = new Properties();
	
	public String getProperty(String key){
		return prop.getProperty(key);
		
	}

}
