package com.amazon.qa.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazom.qa.utils.ExcelReader;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.SignInPage;
import com.amazon.qa.testComponents.BaseTest;
import com.amazon.qa.testComponents.RetryTest;

public class SignInPageTest extends BaseTest {
	
	 SignInPage si;
	 HomePage hp;
	 
	
	
	@Override
	public void SetUp() {
		
		 si=new SignInPage(driver);
		 hp=new HomePage(driver);
	}
	
	@DataProvider
	public Object[][] getTestDataFromExcel() throws IOException
	{
	  return	 ExcelReader.getDataFromExcel();
	}
	
	
	
	
	@Test(priority=1,groups="Regression", retryAnalyzer=RetryTest.class)
	public void SignInwith_ValidCredentials()
	{	
		hp.NavigateTo_SignInPage();		
		si.EnterMobileNumberAndClickContinue(prop.getProperty("Username"));
		si.EnterValidPasswordAndClickonContinue(prop.getProperty("Password"));	
	}
	
	
	
	
	@Test(priority=0,dataProvider="getTestDataFromExcel", retryAnalyzer=RetryTest.class)
	public void SignInwith_InValidCredentials(String Input, String ErrorMessage ,String ExpectedErrorMessage) throws InterruptedException
	{	
		hp.NavigateTo_SignInPage();		
		si.EnterMobileNumberAndClickContinue(Input);
		Thread.sleep(3000);
		String ActualerrorMessage=si.GetTextForInValidNumber(ErrorMessage);	
		AssertJUnit.assertEquals(ActualerrorMessage, ErrorMessage);
	}




	
	


	
	
}
