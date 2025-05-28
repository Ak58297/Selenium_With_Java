package com.amazom.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {
	
	 static Properties prop;
	public  static WebDriver driver;
	static FileInputStream fis;
	
	
//	public Base()  
//	{
//		System.out.println("Base Constructor is called");
//
//		prop= new Properties();
//		try {
//			fis =new FileInputStream("D:\\WORK\\WorkSpace\\AmazonTest\\src\\main\\java\\com\\amazom\\qa\\configurations\\config.properties");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			prop.load(fis);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	
	public static void Initialization() throws IOException 
	{
		prop= new Properties();
		fis =new FileInputStream("D:\\WORK\\WorkSpace\\AmazonTest\\src\\main\\java\\com\\amazom\\qa\\configurations\\config.properties");
		prop.load(fis);
		
		System.out.println("Base initialization is called");

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
		driver.get(prop.getProperty("Url"));	
		try {
	driver.findElement(By.xpath("//a[@onclick='window.location.reload()']")).click();
		}
		catch(Exception e)
		{System.out.println("No captcha capture came up");}
	}
	
}
