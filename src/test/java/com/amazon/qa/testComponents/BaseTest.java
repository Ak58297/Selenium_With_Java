 package com.amazon.qa.testComponents;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public abstract class BaseTest {
	
	public static Properties prop;
	public  static WebDriver driver;
	static FileInputStream fis;
	
	public abstract void SetUp();
	
	
	
	public WebDriver InitializeDriver() throws IOException 
	{
		prop= new Properties();
		fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\amazom\\qa\\configurations\\config.properties");
		prop.load(fis);
		
		//System.out.println("Base initialization is called");

		String browser=prop.getProperty("Browser");
		switch(browser)
		{
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\WORK\\WorkSpace\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
			
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\WORK\\WorkSpace\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();		
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
		
//		try {
//			driver.findElement(By.xpath("//a[@onclick='window.location.reload()']")).isDisplayed();
//	        driver.findElement(By.xpath("//a[@onclick='window.location.reload()']")).click();
//		}
//		catch(Exception e)
//		{
//			System.out.println("No captcha capture came up "+e.getMessage());
//		}
	}
	
	
	@BeforeMethod
	public void LaunchApplication() throws IOException
	{
		driver=InitializeDriver();
		SetUp();
		driver.get(prop.getProperty("Url"));	

	}
	
	public String TakesScreenshot(String testcaseName, WebDriver driver)
	{
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String ScreenshotPath=System.getProperty("user.dir")+"\\Reports\\"+testcaseName+".png";
		File destination= new File(ScreenshotPath);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ScreenshotPath;
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
