package eICS.pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import eICS.Locators.EicsLogin.Locators;
import eICS.Locators.NavigateToEics;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;

public class EicsLogin extends PageObject {
	WebDriver driver;
	WaitForElement waitForElement ;
	
	public EicsLogin(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
	}
	
	public EicsLogin launchEics() throws Exception {
		driver.get(Locators.EICS_URL);
		waitForElement.waitForElements(Locators.USERNAME, "name");
		return this;
	}
	
	public EicsLogin clickOnLogin() throws Exception {
		waitForElement.waitForElements(Locators.LOGIN_BUTTON, "name");
		this.page.element(Locators.LOGIN_BUTTON, "name").getOne().click();
		return this;
	}

	public EicsLogin enterUserName(String _username) throws Exception {
		if(this.page.element(NavigateToEics.Locators.LOGOUT, "linktext").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == true) {
			this.page.element(NavigateToEics.Locators.LOGOUT, "linktext").Click();
		}
		waitForElement.waitForElements(Locators.USERNAME, "name");
		this.page.element(Locators.USERNAME, "name").clearInputValue().sendKeys(_username);
		assertTrue(this.page.element(Locators.USERNAME, "name").getOne().getAttribute("value").equals(_username));
		return this;
	}

	public EicsLogin enterPassword(String _password) throws Exception {
		waitForElement.waitForElements(Locators.PASSWORD, "name");
		this.page.element(Locators.PASSWORD, "name").clearInputValue().sendKeys(_password);
		assertTrue(this.page.element(Locators.PASSWORD, "name").getOne().getAttribute("value").equals(_password));
		return this;
	}
	
	public EicsLogin LoginToEics(String _username, String _password) throws Exception {
		this.launchEics();
		this.enterUserName(_username);
		this.enterPassword(_password);
		this.clickOnLogin();
		waitForElement.waitForElements(Locators.VIEW_OF_FIRST_INCIDENT, "xpath");
		return this;
	}
	
	public EicsLogin verifyHomePage() throws Exception {
		waitForElement.waitForElements(Locators.VIEW_OF_FIRST_INCIDENT, "xpath");
		assertTrue(this.page.element(Locators.CREATE_VIEW_BUTTON, "css").isElementPresent());
		assertTrue(this.page.element(Locators.CREATE_VIEW_BUTTON, "css").getOne().isDisplayed());
		return this;
	}
}