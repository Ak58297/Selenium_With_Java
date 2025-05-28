package com.amazon.qa.tests;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazom.qa.base.Base;
import com.amazom.qa.utils.ExcelReader;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.SignInPage;

public class SignInPageTest extends BaseTest {
	
	SignInPage si;
	HomePage hp;	
	
	@BeforeMethod
	public void setUp()
	{		
		System.out.println("BeforeMethod: SetUp is called");
		InitializeBrowser();
		hp=new HomePage();
		si=hp.SignInPage();
	}

	@DataProvider(name="FetchDataFromExcel")
	public Object[][] getTestDataFroExcel() throws IOException
	{
	  return	 ExcelReader.getDataFromExcel();
	}
	
//	@Test(priority=1,groups="Regression")
//	@Parameters({"InvalidMobileNumber"})
//	public void LogTestwith_ValidCredentials(String InvalidMobileNumber)
//	{			System.out.println("Test is called");
//
//		si.EnterMobileNumberAndClickContinue(InvalidMobileNumber);
//		si.GetTextForInValidNumber();		
//	}
	
	
	
	
	@Test(dataProvider="FetchDataFromExcel")
	public void LogTestwith_InValidCredentials(String Username,String Password, String ID) throws InterruptedException
	{			System.out.println("Test is called");

		si.EnterMobileNumberAndClickContinue(ID);
		Thread.sleep(3000);
		si.GetTextForInValidNumber();		
	}
	
	


	
	
}
