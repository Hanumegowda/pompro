package CAM.pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import CAM.Locators.Login.*;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;

public class LoginPage extends PageObject  {

	WebDriver driver;
	WaitForElement objWaitForElement ;
	WebDriverWait wait;

	public LoginPage(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);

	}
	public LoginPage launchCAMUrl() throws Exception {
		driver.get(Locators.CAM_URL);
		driver.navigate().to(Locators.CAM_URL);
		objWaitForElement.waitForElements(Locators.USERNAME, "css");
		assertTrue(this.page.element(Locators.USERNAME, "css").isElementPresent(),
				"Login page is not displayed");
		return this;
	}

	public LoginPage enterUserName(String _username) throws Exception {
		objWaitForElement.waitForElements(Locators.USERNAME, "css");
		this.page.element(Locators.USERNAME, "css").clearInputValue().sendKeys(_username);
		return this;
	}

	public LoginPage enterPassword(String _password) throws Exception {
		objWaitForElement.waitForElements(Locators.PASSWORD, "css");
		this.page.element(Locators.PASSWORD, "css").clearInputValue().sendKeys(_password);
		return this;
	}

	public LoginPage clickOnLogin() throws Exception {
		objWaitForElement.waitForElements(Locators.LOGIN, "css");
		this.page.element(Locators.LOGIN, "css").getOne().click();
		objWaitForElement.waitForElements(Locators.HOME, "xpath");
		assertTrue(this.page.element(Locators.HOME, "xpath").isElementPresent(),
				"Common Account Management home page is not displayed");
		return this;
	}

	public LoginPage loginToCAM(String userName, String password)
			throws Exception {
		this.launchCAMUrl();
		this.enterUserName(userName);
		this.enterPassword(password);
		this.clickOnLogin();
		return this;
	}

	public LoginPage clickOnLogOut() throws Exception {
		objWaitForElement.waitForElements(Locators.LOGOUT, "linktext");
		this.page.element(Locators.LOGOUT, "linktext").getOne().click();
		return this;
	}
}
