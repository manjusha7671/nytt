package com.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import com.excel.ReadDataFromExcelSheet;
import com.google.common.io.Files;

public class TestBase {

	public static Logger log = Logger.getLogger(TestBase.class);
	public WebDriver driver;

	public String[][] getExcelData(String excelName, String sheetName) {

		String excellocation = System.getProperty("user.dir")+"\\excelFiles\\" + excelName;
		ReadDataFromExcelSheet readDataFromExcelSheet = new ReadDataFromExcelSheet();
		return readDataFromExcelSheet.getExcelData(excellocation, sheetName);
	}

	public static void main(String[] args) {
		log.info("test log");
	}

	public WebDriver getBrowser(String browser) {
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equalsIgnoreCase("chrome")) {
					System.getProperty("Webdriver.gecko.driver",System.getProperty("user.dir")+"");
				driver = new ChromeDriver();
				
			} else {
				System.getProperty("Webdriver.gecko.driver",System.getProperty("user.dir")+"");
				 driver = new FirefoxDriver();
				
			}
		}
		return null;
	}
	
	public String getScreenshot(String imageName) throws IOException{
		if(imageName.equals("")){
			imageName="blank";
		}
		File image =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagelocation = System.getProperty("user.dir")+"/src/main/java/com/resources/screenshot/";
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String actualImageName = imagelocation+imageName+"_" + formatter.format(calendar.getTime())+".png";
		File destFile = new File(actualImageName);
		Files.copy(image, destFile);
		return actualImageName;
				
	}
	
	public String getData(String name){
		return DataSource.OR.getProperty(name);
	}
	
	
	@BeforeTest
	public void launchBrowser(){
		getBrowser(getData("browserType"));
//		driver.manage().timeouts().implicitlyWait(DataSource.getImplicitwait(), TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(DataSource.getPageloadtime(), TimeUnit.SECONDS);
	}

	public void getApplicationURL(String url){
		log.info(url);
		driver.get(url);
	}
}
