package com.mystore.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	String path="E:\\ApiTestingEclipse\\mystore\\Configuration\\config.properties";
    public ReadConfig() 
    {
    	try
    	{
    	properties=new Properties();
    	FileInputStream fis=new FileInputStream(path);
    	properties.load(fis);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public String getUrl(){
    	String value=properties.getProperty("baseUrl");
    	if(value!=null)
    	{
    		return value;
    	}
    	else
    	{
    		throw new RuntimeException("url not specified in config file");
    	}
    }
    
    public String getbrowser(){
    	String value=properties.getProperty("browser");
    	if(value!=null)
    	{
    		return value;
    	}
    	else
    	{
    		throw new RuntimeException("browser not specified in config file");
    	}
    }
}
