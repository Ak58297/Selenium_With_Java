 package com.amazon.qa.testComponents;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;



public abstract class BaseTest {
	
	protected static Properties prop;
	private static WebDriver driver;
	private static FileInputStream fis;
	
	public abstract void SetUp();
	
	
	public void InitializeDriver() throws IOException
	{
		prop= new Properties();
		fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\amazom\\qa\\configurations\\config.properties");
		prop.load(fis);		
		String Browser= System.getProperty("Browser")!=null? System.getProperty("Browser"): prop.getProperty("Browser");
	//	String browser=prop.getProperty("Browser");
		switch(Browser)
		{
		case "Chrome":
			ChromeOptions options=new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriverPath"));
			options.addArguments("--remote-allow-origins=*");
		//	options.addArguments("--headless");
			driver=new ChromeDriver(options);
			//driver.manage().window().setSize(new Dimension(1440,990));
			break;
			
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", prop.getProperty("GeckoDriverPath"));
			driver=new FirefoxDriver();	
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//return driver;
		
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
		InitializeDriver();
		//driver=getDriver();
		SetUp();
		getDriver().get(prop.getProperty("Url"));	

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
		getDriver().quit();
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
}
