package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseConfig {
	

public String getConfig(String key) throws Exception  {

	
	
	//3 use whole location
	File file = new File("/Users/parthadebnath/eclipse-Batch-41/parabank-onlinebanking-automation/Config.properties");
	
	//2
	FileInputStream fs= new FileInputStream(file);
	//1 
	Properties pro =new Properties ();
	pro.load(fs);
	
	
	String value= pro.get(key).toString();
	
	System.out.println(value);
	
	return value;
	

}

public static void main(String[] args) throws Exception {
	BaseConfig config=new BaseConfig();
	config.getConfig("INVALID_PASSWORD");
	
	
	
}}

