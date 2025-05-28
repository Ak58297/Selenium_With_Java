package com.amazon.qa.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import com.amazom.qa.base.Base;
public abstract class BaseTest extends Base{
	
	public  abstract void setUp();

	
	public void InitializeBrowser() 
	{
		System.out.println("BeforeTest: Basetest initialization is called");
		try {
			Initialization();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@AfterMethod
	protected void QuitBrowser()
	{
		System.out.println("AfterMethod: Quit browser");
		driver.quit();
	}

}
