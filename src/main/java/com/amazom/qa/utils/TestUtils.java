package com.amazom.qa.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.SignInPage;

public class TestUtils {

	WebDriverWait wait;
	Actions actions;
	WebDriver driver;
	JavascriptExecutor js;

	public TestUtils(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;

	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	public static long IMPLICIT_WAIT_SECONDS = 5;
	@FindBy(id = "ap_email_login")
	WebElement InputBoxNumber;

	@FindBy(xpath = "//button[@aria-label='Expand Account and Lists']")
	WebElement ExpandAccountAndList;
	@FindBy(xpath = "//*[text()='Sign in']")
	WebElement SinInLink;
	@FindBy(xpath = "//*[@class='a-button-input']")
	WebElement ContinueButton;
	@FindBy(id = "signInSubmit")
	WebElement SignIn;
	@FindBy(xpath = "//input[@type='password']")
	WebElement PasswordInput;

	@FindBy(xpath = "//*[@id='nav-logo-sprites']")
	WebElement AmazonLogo;

	public void Login(String Number, String Password) {
		actions = new Actions(driver);
		actions.moveToElement(ExpandAccountAndList).build().perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(SinInLink));
		SinInLink.click();
		js = (JavascriptExecutor) driver;
		InputBoxNumber.sendKeys(Number);
		js.executeScript("arguments[0].click()", ContinueButton);
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(SignIn));
		PasswordInput.sendKeys(Password);
		SignIn.click();
		WaitForTheElementToclick(AmazonLogo);
	}

	public void WaitForTheElementToclick(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

}
