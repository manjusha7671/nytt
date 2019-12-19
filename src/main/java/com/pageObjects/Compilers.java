package com.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Compilers {
	
	public WebDriver driver;
	
	private static Logger  log = Logger.getLogger(Compilers.class);
	
	
	
	@FindBy(className = "form-control")
	WebElement  compliers;

}
