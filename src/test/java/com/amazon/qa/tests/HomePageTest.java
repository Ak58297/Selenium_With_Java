package com.amazon.qa.tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import com.amazon.qa.pages.HomePage;
import com.amazon.qa.testComponents.BaseTest;
import com.amazon.qa.testComponents.RetryTest;

public class HomePageTest extends BaseTest {

	SignInPageTest spt;
	HomePage hp;
	

	@Override
	public void SetUp() 
	{	
	spt = new SignInPageTest();
	hp=new HomePage(getDriver());
	
	}

	
	@Test()
	public void CaptureFielsInDigitalContent()  
	{
		hp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		hp.ValidateUserNameAfterClickingOn_AllHamburgerMenu(prop.getProperty("CustomerName"));
		hp.Get_DigitalContentDevicesFields();
	}

	
	@Test()
	public void test2() throws InterruptedException {
		hp.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		hp.SelectElexa();

	}

}