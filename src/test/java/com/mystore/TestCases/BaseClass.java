package com.mystore.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import com.mystore.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig= new ReadConfig();
	String url=readconfig.getUrl();
	String browser=readconfig.getbrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		switch(browser.toLowerCase())
		 {
		 case "chrome":
			 WebDriverManager.chromedriver().setup();
			 ChromeOptions options=new ChromeOptions();
			 options.addArguments("--remote-allow-origins=*");
			 DesiredCapabilities d=new DesiredCapabilities();
			 d.setCapability(ChromeOptions.CAPABILITY, options);
			 options.merge(d);
			 driver=new ChromeDriver(options);
			 break;
			 
		 case "edge":
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			 break;
			 
		 case "firefox":
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 break;
			 
			 default:
				 driver=null;
				 break;
		 }	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		logger=LogManager.getLogger("mystore");
		driver.get(url);
		logger.info("entered url");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	 
	//user method to capture screen shot
		public void captureScreenShot(WebDriver driver,String testName) throws IOException
		{
			//step1: convert webdriver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		
			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
		}
}
