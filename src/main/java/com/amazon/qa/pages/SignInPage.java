package com.amazon.qa.pages;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazom.qa.utils.TestUtils;


public class SignInPage extends TestUtils {
	
	WebDriver driver;
	public SignInPage(WebDriver driver) 
	{		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	
	String VariableXpath ="//*[contains(text(),'%s')]";
	JavascriptExecutor js;
	WebDriverWait explicitWait;
	

	@FindBy(id="signInSubmit")
	WebElement SignIn;
	
	@FindBy(id="ap_email_login")
	WebElement InputBoxNumber;
	
	
	@FindBy(xpath="//*[@class='a-button-input']")
	WebElement ContinueButton;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement PasswordInput;
	
	@FindBy(xpath="//*[@id='nav-logo-sprites']")
	WebElement AmazonLogo;
	
	public void EnterMobileNumberAndClickContinue(String number)
	{
		js=(JavascriptExecutor)driver;
		InputBoxNumber.sendKeys(number);	
		js.executeScript("arguments[0].click()", ContinueButton);
		//ContinueButton.click();	
	}
	
	public void EnterValidPasswordAndClickonContinue(String Password)
	{
		explicitWait=new WebDriverWait(driver,Duration.ofSeconds(3));
		explicitWait.until(ExpectedConditions.elementToBeClickable(SignIn));
		PasswordInput.sendKeys(Password);
		SignIn.click();	
		WaitForTheElementToclick(AmazonLogo);
		
	}
	
	public String GetTextForInValidNumber(String ErrorMessage)
	{		
		String xpathString=String.format(VariableXpath,ErrorMessage );
		WebElement GetTextErrorMessage=driver.findElement(By.xpath(xpathString));
		String Error=GetTextErrorMessage.getText();
		System.out.println(Error);
		return Error;
	}
	
	
}
