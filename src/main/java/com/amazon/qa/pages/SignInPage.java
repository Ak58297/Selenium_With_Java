package com.amazon.qa.pages;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazom.qa.base.Base;

public class SignInPage extends Base {
	
	//WebDriver driver;
	public SignInPage() 
	{		
		PageFactory.initElements(driver,this);	
	}
	

	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement SignIn;
	
	@FindBy(id="ap_email_login")
	WebElement InputBoxNumber;
	
	@FindBy(xpath="//*[@id=\"invalid-phone-alert\"]/div/div")
	WebElement ErrorMsg;
	
	
	@FindBy(xpath="//*[@class='a-button-input']")
	WebElement ContinueButton;
	
	public void EnterMobileNumberAndClickContinue(String number)
	{
		InputBoxNumber.sendKeys(number);
		ContinueButton.click();	
	}
	
	public void GetTextForInValidNumber()
	{
		String Error=ErrorMsg.getText();
		System.out.println(Error);
	}
}
