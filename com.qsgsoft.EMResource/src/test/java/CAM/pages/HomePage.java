package CAM.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import CAM.Locators.HomePage.*;
import EMR.pages.Login;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;

public class HomePage extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	Login login;

	public HomePage(WebDriver _driver) throws Exception {
		super(_driver);
		objWaitForElement = new WaitForElement(this.driver);
	}

	public HomePage verCommonApplicationManagementPage()
			throws Exception {
		objWaitForElement.waitForElements(Locators.HOME, "xpath");
		assertTrue(this.page.element(Locators.HOME, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.HOME, "xpath").getOne()
				.isDisplayed());
		this.verifyEnterSearchStringField();
		return this;
	}

	public HomePage searchUser(String userName) throws Exception {
		objWaitForElement.waitForElements(Locators.SEARCHFIELD, "css");
		String loginName = Locators.LOGINNAME +userName+Locators.CLOSINGBRACKETS;
		this.page.element(Locators.SEARCHFIELD, "css").clearInputValue().sendKeys(userName);
		this.clickOnSearch();
		objWaitForElement.waitForElements(loginName, "css");
		return this;
	}

	public HomePage clickOnSearch() throws Exception {
		objWaitForElement.waitForElements(Locators.SEARCHBTN, "css");
		this.page.element(Locators.SEARCHBTN, "css").getOne().click();
		return this;
	}
	
	public HomePage verifyEnterSearchStringField() throws Exception {
		objWaitForElement.waitForElements(Locators.SEARCHFIELD, "css");
	assertTrue(this.page.element(Locators.SEARCHFIELD, "css").isElementPresent());
	assertTrue(this.page.element(Locators.SEARCHFIELD, "css").getOne().isDisplayed());
		return this;
	}
	
	public HomePage verifyDisplayNameInCam(String fullName) throws Exception {
		String displayName=Locators.DISPLAYNAME +fullName+Locators.CLOSINGBRACKETS;
		objWaitForElement.waitForElements(displayName, "xpath");
		assertTrue(this.page.element(displayName, "xpath").isElementPresent());
		assertTrue(this.page.element(displayName, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public HomePage verifyLoginNameInCam(String userName) throws Exception {
		String loginName = Locators.LOGINNAME +userName+Locators.CLOSINGBRACKETS;
		objWaitForElement.waitForElements(loginName, "xpath");
		assertTrue(this.page.element(loginName, "xpath").isElementPresent());
		assertTrue(this.page.element(loginName, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public HomePage verifyProductInCam(String product) throws Exception {
		String products =Locators.PRODUCT +product+Locators.CLOSINGBRACKETS;
		objWaitForElement.waitForElements(product, "xpath");
		assertTrue(this.page.element(products, "xpath").isElementPresent());
		assertTrue(this.page.element(products, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public HomePage openUserDetailes(String userName) throws Exception {
		String userDetailes = Locators.LOGINNAME + userName
				+ Locators.CLOSINGBRACKETS;
		String rightPane =Locators.LOGIN +userName+Locators.CLOSINGBRACKETS;
		objWaitForElement.waitForElements(userDetailes, "xpath");
		objWaitForElement.waitForElements(userDetailes, "xpath");
		this.page.element(userDetailes, "xpath").getOne().click();
		assertTrue(this.page.element(rightPane, "xpath").isElementPresent());
		assertTrue(this.page.element(rightPane, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public HomePage verifyUserDetailesInCAM(String fullName, String userName,
			String product) throws Exception {
		verifyDisplayNameInCam(fullName);
		verifyLoginNameInCam(userName);
		verifyProductInCam(product);
		return this;
	}

	public HomePage verifyLogin(String userName) throws Exception {
		String login =Locators.LOGIN +userName+Locators.CLOSINGBRACKETS;
		objWaitForElement.waitForElements(login, "xpath");
		assertTrue(this.page.element(login, "xpath").isElementPresent());
		assertTrue(this.page.element(login, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public HomePage verifyDisplayName(String fullName) throws Exception {
		String displayName = Locators.DISPLAYNAME1 + fullName
				+ Locators.CLOSINGBRACKETS;
		objWaitForElement.waitForElements(displayName, "xpath");
		assertTrue(this.page.element(displayName, "xpath").isElementPresent());
		assertTrue(this.page.element(displayName, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	public HomePage verifyEnabled(String enable) throws Exception {
		String enabled = Locators.ENABLED + enable + Locators.CLOSINGBRACKETS;
		objWaitForElement.waitForElements(enabled, "xpath");
		assertTrue(this.page.element(enabled, "xpath").isElementPresent());
		assertTrue(this.page.element(enabled, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public HomePage verifyWorkEmail(String mailId) throws Exception {
		String mailID = Locators.WORKEMAIL + mailId + Locators.CLOSINGBRACKETS;
		objWaitForElement.waitForElements(mailID, "xpath");
		assertTrue(this.page.element(mailID, "xpath").isElementPresent());
		assertTrue(this.page.element(mailID, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public HomePage verifyProductAccess(String productAccess) throws Exception {
		String productAcc = Locators.PRODUCTACCESS + productAccess
				+ Locators.CLOSINGBRACKETS;
		objWaitForElement.waitForElements(productAcc, "xpath");
		assertTrue(this.page.element(productAcc, "xpath").isElementPresent());
		assertTrue(this.page.element(productAcc, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	public HomePage verifyLocked(String lock) throws Exception {
		String locked = Locators.LOCKED + lock + Locators.CLOSINGBRACKETS;
		objWaitForElement.waitForElements(locked, "xpath");
		assertTrue(this.page.element(locked, "xpath").isElementPresent());
		assertTrue(this.page.element(locked, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public HomePage verifyUserDetailesInCAM(String userName, String fullName,
			String enable, String mailID, String productAccess, String Locked,
			String product) throws Exception {
		this.verifyLogin(userName);
		this.verifyDisplayName(fullName);
		this.verifyEnabled(enable);
		this.verifyWorkEmail(mailID);
		this.verifyProductAccess(productAccess);
		this.verifyLocked(Locked);
		this.verifyDisplayNameInCam(fullName);
		this.verifyLoginNameInCam(userName);
		this.verifyProductInCam(product);
		return this;
	}
}