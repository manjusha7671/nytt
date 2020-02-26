package com.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	
	private static Logger log = Logger.getLogger(WaitHelper.class);
	
	private WebDriver driver;
	public WaitHelper(WebDriver driver){
		super();
		this.driver = driver;
	}
	
	public void waitForElement(WebElement element , long time){
		log.info("waiting for element to present..");
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
}
