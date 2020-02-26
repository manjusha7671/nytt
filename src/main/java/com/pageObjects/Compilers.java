package com.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.helper.WaitHelper;
import com.testBase.DataSource;

public class Compilers {
	
	private static WebDriver driver;
	
	private static Logger  log = Logger.getLogger(Compilers.class);
	private WaitHelper waitHelper;
	
	
	@FindBy(className = "form-control")
	WebElement  languages;
	@FindBy(id = "runBtn")
	WebElement  run;
	@FindBy(className = "CodeMirror-scroll")
	WebElement  textspace;
	
	public Compilers(WebDriver driver){
		super();
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void click(){
		run.click();
	}
	
	public  HomePage selectLanguageandRun(String lang){
		log.info("selecting compiler language");
		Select drop = new Select(languages);
	      drop.selectByVisibleText(lang);
	      run.click();
	      System.out.println(textspace.getText());
		return new HomePage(driver);
	}
}
