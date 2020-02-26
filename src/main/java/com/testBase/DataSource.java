package com.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.utility.ResourceHelper;

public class DataSource {
 private static Logger log = Logger.getLogger(DataSource.class);
 
 
 
 public static Properties OR;
 private String browserType;
 private String username;
 private String password;
 private String url;
 long implicitwait;
 long explicitwait ;
 long pageloadtime;
 
 public String getBrowserType() {
	return browserType;
}
public void setBrowserType(String browserType) {
	this.browserType = browserType;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public static long getImplicitwait() {
	return Integer.parseInt(System.getProperty("implicitwait"));
}

public static long getExplicitwait() {
	return Integer.parseInt(OR.getProperty("explicitwait"));
}

public static long getPageloadtime() {
	return Integer.parseInt(OR.getProperty("pageloadtime"));
}

static{
	OR= new Properties();
	File f1= new File(ResourceHelper.getResourcePath("\\src\\main\\java\\com\\resources\\config.properties"));
	try{
		FileInputStream file = new FileInputStream(f1);
		OR.load(file);
	}catch(Exception e){
		e.printStackTrace();
	}
	log.info("loading config properties");
}
 
}
