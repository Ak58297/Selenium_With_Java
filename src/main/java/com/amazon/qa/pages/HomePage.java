package com.amazon.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazom.qa.base.Base;

public class HomePage extends Base{

	Actions actions;
	WebDriverWait wait;
	
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@aria-label='Expand Account and Lists']")
	WebElement ExpandAccountAndList;
	 
	@FindBy(xpath="//*[text()='Sign in']")
	WebElement SinInLink;
	
	public SignInPage SignInPage()
	{
		actions=new Actions(driver);
		actions.moveToElement(ExpandAccountAndList).build().perform();
		wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(SinInLink));
		SinInLink.click();
		return new SignInPage();
		
	}
	
	
	
	
	
}
