/**
 * 
 */
package com.testScripts;

import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObjects.Compilers;
import com.pageObjects.HomePage;
import com.testBase.DataSource;
import com.testBase.TestBase;


public class CompilersTest extends TestBase {

	HomePage home;
	Compilers compilers;
	
	
	@DataProvider
	public Object[][] testData(){
		String[][] data = getExcelData("compilers.xlsx", "compilers");
		return data;
	}
	
	@BeforeClass
	public void beforeClass(){
		getApplicationURL(DataSource.OR.getProperty("url"));
		home = new HomePage(driver);
		compilers = new Compilers(driver);
		System.out.println("testing1");
		home.clickCompilers();
	}
	
	@Test(dataProvider = "testData")
	public void compilersTest(String selectLanguage, String runMode){
		System.out.println("testing");
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("run Mode No");
		}
		
		
		
		System.out.println("before selecting langages" );
		
		compilers.selectLanguageandRun(selectLanguage);
		
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
		
	}
	
}
