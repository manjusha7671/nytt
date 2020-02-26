package com.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.helper.WaitHelper;
import com.testBase.DataSource;
import com.testBase.TestBase;

public class HomePage {
	
private static Logger log = Logger.getLogger(HomePage.class);
	
	private WebDriver driver;
	
	private WaitHelper waitHelper;
	
	@FindBy(className = "chegg-logo")
	WebElement logoNYTT;
	@FindBy(linkText= "Compliers")
	WebElement  compilers;
	
	public HomePage(WebDriver driver){
		super();
		this.driver= driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		System.out.println("homepage constructor");
	}

	public void clickCompilers(){
		waitHelper.waitForElement(logoNYTT, DataSource.getExplicitwait());
		compilers.click();
	}
	
}
