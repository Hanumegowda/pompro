package eICS.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import eICS.Locators.Contacts.Locators;

public class Contacts extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement;
	
	public Contacts(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
	}
	
	public Contacts selectDoaminOrFacility(String domainOrFacilityName) throws Exception {
		waitForElement.waitForElements(Locators.DOMAIN_OR_FACILITY, "css");
		this.page.element(Locators.DOMAIN_OR_FACILITY, "css").webElementToSelect().selectByVisibleText(domainOrFacilityName);
		assertTrue(this.page.element(Locators.DOMAIN_OR_FACILITY, "css").webElementToSelect().getFirstSelectedOption().getText().equals(domainOrFacilityName));
		return this;
	}

	public Contacts clickOnAddNewContact() throws Exception {
		try{
			this.page.element_wait(Locators.LOADING_BLOCKER, "xpath").waitForInvisibilityOfElement();
			waitForElement.waitForElements(Locators.ADDNEWCONTACT, "css");
			this.page.element_wait(Locators.ADDNEWCONTACT, "css").waitForElementEnable();
			this.page.element(Locators.ADDNEWCONTACT, "css").getOne().click();
			waitForElement.waitForElements(Locators.USERNAME, "css");
		} catch(Exception e) {
			this.page.element_wait(Locators.LOADING_BLOCKER, "xpath").waitForInvisibilityOfElement();
			waitForElement.waitForElements(Locators.ADDNEWCONTACT, "css");
			this.page.element_wait(Locators.ADDNEWCONTACT, "css").waitForElementEnable();
			this.page.element(Locators.ADDNEWCONTACT, "css").clickUsingJSE();
			waitForElement.waitForElements(Locators.USERNAME, "css");
		}
		assertTrue(this.page.element(Locators.USERNAME, "css").isElementPresent());
		return this;
	}
	
	public Contacts enterFirstName(String firstName) throws Exception {
		waitForElement.waitForElements(Locators.FIRSTNAME, "css");
		this.page.element(Locators.FIRSTNAME, "css").getOne().sendKeys(firstName);
		assertTrue(this.page.element(Locators.FIRSTNAME, "css").getOne().getAttribute("value").equals(firstName));
		return this;
	}
	
	public Contacts enterMidName(String midName) throws Exception {
		waitForElement.waitForElements(Locators.MIDNAME, "css");
		this.page.element(Locators.MIDNAME, "css").getOne().sendKeys(midName);
		assertTrue(this.page.element(Locators.MIDNAME, "css").getOne().getAttribute("value").equals(midName));
		return this;
	}
	
	public Contacts enterLastName(String lastName) throws Exception {
		waitForElement.waitForElements(Locators.LASTNAME, "css");
		this.page.element(Locators.LASTNAME, "css").getOne().sendKeys(lastName);
		assertTrue(this.page.element(Locators.LASTNAME, "css").getOne().getAttribute("value").equals(lastName));
		return this;
	}
	
	public Contacts enterPhoneNumber(String phoneNumber) throws Exception {
		waitForElement.waitForElements(Locators.PHONE_NUMBER, "xpath");
		this.page.element(Locators.PHONE_NUMBER, "xpath").getOne().sendKeys(phoneNumber);
		assertTrue(this.page.element(Locators.PHONE_NUMBER, "xpath").getOne().getAttribute("value").equals(phoneNumber));
		return this;
	}
	
	public Contacts enterEmailAddress(String emailId) throws Exception {
		waitForElement.waitForElements(Locators.EMAIL, "xpath");
		this.page.element(Locators.EMAIL, "xpath").getOne().sendKeys(emailId);
		assertTrue(this.page.element(Locators.EMAIL, "xpath").getOne().getAttribute("value").equals(emailId));
		return this;
	}
	
	public Contacts enableUserAccount() throws Exception {
		waitForElement.waitForElements(Locators.ENABLE_USER_ACCOUNT, "css");
		if(this.page.element(Locators.ENABLE_USER_ACCOUNT, "css").getOne().isSelected() == false) {
			this.page.element(Locators.ENABLE_USER_ACCOUNT, "css").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(Locators.ENABLE_USER_ACCOUNT, "css").getOne().isSelected() == false) {
			this.page.element(Locators.ENABLE_USER_ACCOUNT, "css").getDisplayedOne().click();
		}
		if(this.page.element(Locators.ENABLE_USER_ACCOUNT, "css").getOne().isSelected() == false) {
			this.page.element(Locators.ENABLE_USER_ACCOUNT, "css").clickUsingJSE();
		}
		assertTrue(this.page.element(Locators.ENABLE_USER_ACCOUNT, "css").getOne().isSelected());
		return this;
	}
	
	public Contacts enterUsername(String userName) throws Exception {
		waitForElement.waitForElements(Locators.USERNAME, "css");
		this.page.element(Locators.USERNAME, "css").getOne().sendKeys(userName);
		assertTrue(this.page.element(Locators.USERNAME, "css").getOne().getAttribute("value").equals(userName));
		return this;
	}
	
	public Contacts enterOrganization(String organization) throws Exception {
		waitForElement.waitForElements(Locators.ORGANIZATION, "css");
		this.page.element(Locators.ORGANIZATION, "css").clearInputsValue();
		this.page.element(Locators.ORGANIZATION, "css").getOne().sendKeys(organization);
		assertTrue(this.page.element(Locators.ORGANIZATION, "css").getOne().getAttribute("value").equals(organization));
		return this;
	}
	
	public Contacts clickOnCreate() throws Exception {
		waitForElement.waitForElements(Locators.CREATE, "css");
		this.page.element(Locators.CREATE, "css").getOne().click();
		this.page.element_wait(Locators.LOADING_PAGE_BLOCKER, "xpath").waitForInvisibilityOfElement();
		waitForElement.waitForElements(Locators.ACCOUNT_INFORMATION_DRAWER, "xpath");
		return this;
	}
	
	public Contacts createContact(String userFirstName, String midName, String lastName, String phoneNumber, String emailId, String userName, String organization) throws Exception {
		this.clickOnAddNewContact();
		this.enterFirstName(userFirstName);
		this.enterMidName(midName);
		this.enterLastName(lastName);
		this.enterPhoneNumber(phoneNumber);
		this.enterEmailAddress(emailId);
		this.enterOrganization(organization);
		this.enableUserAccount();
		this.enterUsername(userName);
		this.clickOnCreate();
		return this;
	}
	
	public Contacts clickOnAccountInformationDrawer() throws Exception {
		this.page.element_wait(Locators.LOADING_PAGE_BLOCKER, "xpath").waitForInvisibilityOfElement();
		waitForElement.waitForElements(Locators.ACCOUNT_INFORMATION_DRAWER, "xpath");
		this.page.element(Locators.ACCOUNT_INFORMATION_DRAWER, "xpath").getOne().sendKeys(Keys.ENTER);
		waitForElement.waitForElements(Locators.RESET_PASSWORD, "css");
		return this;
	}
	
	public Contacts clickOnResetPassword() throws Exception {
		waitForElement.waitForElements(Locators.RESET_PASSWORD, "css");
		this.page.element_wait(Locators.LOADING_PAGE_BLOCKER, "xpath").waitForInvisibilityOfElement();
		this.page.element(Locators.RESET_PASSWORD, "css").getOne().sendKeys(Keys.ENTER);
		waitForElement.waitForElements(Locators.CHANGE_PASSWORD_FRAME, "id");
		return this;
	}
	
	public Contacts switchToChangePasswordFrame() throws Exception {
		waitForElement.waitForElements(Locators.CHANGE_PASSWORD_FRAME, "id");
		this.page.element_wait(Locators.CHANGE_PASSWORD_FRAME, "id").switchToFrame(Locators.CHANGE_PASSWORD_FRAME);
		waitForElement.waitForElements(Locators.NEW_PASSWORD, "id");
		return this;
	}
	
	public Contacts enterNewPassword(String password) throws Exception {
		waitForElement.waitForElements(Locators.NEW_PASSWORD, "id");
		this.page.element(Locators.NEW_PASSWORD, "id").getOne().sendKeys(password);
		return this;
	}
	
	public Contacts enterConfirmPassword(String confirmedPassword) throws Exception {
		waitForElement.waitForElements(Locators.VERIFY_PASSWORD, "id");
		this.page.element(Locators.VERIFY_PASSWORD, "id").getOne().sendKeys(confirmedPassword);
		return this;
	}
	
	public Contacts clickOnSubmitButton() throws Exception {
		waitForElement.waitForElements(Locators.SUBMIT_BUTTON, "css");
		this.page.element(Locators.SUBMIT_BUTTON, "css").getOne().click();
		return this;
	}
	
	public Contacts verifyPasswordChageSuccessMessage() throws Exception {
		waitForElement.waitForElements(Locators.PASSOWRD_CHANGE_SUCCESS_MESSAGE, "xpath");
		assertTrue(this.page.element(Locators.PASSOWRD_CHANGE_SUCCESS_MESSAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.PASSOWRD_CHANGE_SUCCESS_MESSAGE, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public Contacts switchToMainWindow() throws Exception {
		driver.switchTo().defaultContent();
		return this;
	}
	
	public Contacts closeResetPasswordWindow() throws Exception {
		waitForElement.waitForElements(Locators.CLOSE_RESET_PASSWORD_WINDOW, "xpath");
		assertTrue(this.page.element(Locators.CLOSE_RESET_PASSWORD_WINDOW, "xpath").isElementPresent());
		this.page.element(Locators.CLOSE_RESET_PASSWORD_WINDOW, "xpath").Click();
		return this;
	}
	
	public Contacts resetPassword(String password) throws Exception {
		this.clickOnAccountInformationDrawer();
		this.clickOnResetPassword();
		this.switchToChangePasswordFrame();
		this.enterNewPassword(password);
		this.enterConfirmPassword(password);
		this.clickOnSubmitButton();
		this.verifyPasswordChageSuccessMessage();
		this.switchToMainWindow();
		this.closeResetPasswordWindow();
		return this;
	}
}
