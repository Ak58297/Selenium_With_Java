package com.amazon.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.amazom.qa.utils.TestUtils;

public class HomePage extends TestUtils {

	// SignInPage sp;
	WebDriver driver;
	Actions actions;
	WebDriverWait wait;
	JavascriptExecutor js;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@aria-label='Expand Account and Lists']")
	WebElement ExpandAccountAndList;

	@FindBy(xpath = "//*[text()='Sign in']")
	WebElement SinInLink;

	@FindBy(xpath = "(//*[@id='nav-hamburger-menu']/span)")
	WebElement All_HamburgerMenu;

	@FindBy(xpath = "(//*[@id='hmenu-customer-name']/*)")
	WebElement CustomerName;

	@FindBy(xpath = "(//*[@aria-labelledby='Digital Content and Devices']//a/div)")
	List<WebElement> DigitalContentFiels;

	@FindBy(xpath = "(//*[@class='hmenu-item']/div[contains(text(),'Echo & Alexa')])[1]")
	WebElement EchoAlexabutton;

	@FindBy(xpath = "//*[contains(text(),'See all devices with Alexa')][1]")
	WebElement AllAlexaDevice;

	@FindBy(xpath = "(//*[@class='a-truncate a-size-base'])")
	List<WebElement> ProductName;

	@FindBy(xpath = "(//*[@class='a-icon a-icon-next'])[1]")
	WebElement nextIcon;

	public void ValidateUserNameAfterClickingOn_AllHamburgerMenu(String UserName) {
		All_HamburgerMenu.click();
		// WaitForTheElementToclick(CustomerName);
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(CustomerName));
		Assert.assertEquals(CustomerName.getText(), String.format("Hello, %s", UserName));
	}

	public void NavigateTo_SignInPage() {
		actions = new Actions(driver);
		actions.moveToElement(ExpandAccountAndList).build().perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(SinInLink));
		SinInLink.click();
	}

	public void check() {
		System.out.println("check");

	}

	public void Get_DigitalContentDevicesFields() {
		for (WebElement field : DigitalContentFiels) {
			String f = field.getText();
			System.out.println(f);
		}
	}

	public void SelectElexa() throws InterruptedException {
		All_HamburgerMenu.click();
		actions = new Actions(driver);
		EchoAlexabutton.click();
		WaitForTheElementToclick(AllAlexaDevice);
		Assert.assertTrue(AllAlexaDevice.isDisplayed());
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", AllAlexaDevice);

		try {
		for (WebElement prod : ProductName) {
			String product = prod.getText();
			if (product.contains("Amazon Echo Show 10 - Premium smart")) {
				prod.click();
			} else {
				nextIcon.click();
				Thread.sleep(3000);
				for (WebElement pr : ProductName) {
					String prd = pr.getText();
					System.out.println(prd);
					if (prd.contains("Amazon Echo Show 10 - Premium smart")) {
						pr.click();
						driver.navigate().refresh();
						driver.findElement(By.id("productTitle")).isDisplayed();
					}

				}
			}

		}
		}
		catch(StaleElementReferenceException e)
		{			
		}

	}
}
