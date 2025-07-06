package com.amazon.qa.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.HashMap;

import com.amazom.qa.utils.ExcelReader;
import com.amazom.qa.utils.JsonReader;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.SignInPage;
import com.amazon.qa.testComponents.BaseTest;
import com.amazon.qa.testComponents.RetryTest;

public class SignInPageTest extends BaseTest {
	
	 SignInPage si;
	 HomePage hp;
	 
	
	
	@Override
	public void SetUp() {
		
		 si=new SignInPage(getDriver());
		 hp=new HomePage(getDriver());
	}
	
	@DataProvider
	public Object[][] getTestDataFromExcel() throws IOException
	{
	  return	 ExcelReader.getDataFromExcel();
	}
	
	@DataProvider(name="getTestdataFromJson")
	public Object[][] getTestdataFromJson() throws IOException
	{
		return JsonReader.getdatafromJson("testenv");	 	
	}
	
	@Test(priority=1,groups="Regression", retryAnalyzer=RetryTest.class)
	public void SignInwith_ValidCredentials()
	{	
		hp.NavigateTo_SignInPage();		
		si.EnterMobileNumberAndClickContinue(prop.getProperty("Username"));
		si.EnterValidPasswordAndClickonContinue(prop.getProperty("Password"));	
		Assert.fail("Failed purposly");
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
	
	@Test(dataProvider="getTestdataFromJson", retryAnalyzer=RetryTest.class)
	public void SignInwith_InValidCredentials2(HashMap<String,String> data) throws InterruptedException
	{	
		hp.NavigateTo_SignInPage();		
		si.EnterMobileNumberAndClickContinue(data.get("Input"));
		Thread.sleep(3000);
		String ActualerrorMessage=si.GetTextForInValidNumber(data.get("ExpectedErrorMessage"));	
		Assert.assertEquals(ActualerrorMessage, data.get("ExpectedErrorMessage"));
	}

}
