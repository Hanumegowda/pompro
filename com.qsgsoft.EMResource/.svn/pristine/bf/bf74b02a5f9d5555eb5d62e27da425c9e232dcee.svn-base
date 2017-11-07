package EMR.pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import EMR.Locators.UserInfo.Locators;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;

public class UserInfo extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement;
	WebDriverWait wait;

	public UserInfo(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_SMALL);
	}

	public UserInfo verifyUpdateUserInfoPage() throws Exception {
		waitForElement.waitForElements(Locators.UPDATE_USER_INFO_PPAGE, "xpath");
		assertTrue(this.page.element(Locators.UPDATE_USER_INFO_PPAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.UPDATE_USER_INFO_PPAGE, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public UserInfo enterFirstName(String firstname) throws Exception {
		waitForElement.waitForElements(Locators.FIRSTNAME, "name");
		this.page.element(Locators.FIRSTNAME, "name").clearInputValue().sendKeys(firstname);
		assertTrue(this.page.element(Locators.FIRSTNAME, "name").getOne().getAttribute("value").equals(firstname));
		return this;
	}
	
	public UserInfo enterLastname(String lastname) throws Exception {
		waitForElement.waitForElements(Locators.LASTNAME, "name");
		this.page.element(Locators.LASTNAME, "name").clearInputValue().sendKeys(lastname);
		assertTrue(this.page.element(Locators.LASTNAME, "name").getOne().getAttribute("value").equals(lastname));
		return this;
	}

	public UserInfo enterOrganization(String organization) throws Exception {
		waitForElement.waitForElements(Locators.ORGANIZATION, "name");
		this.page.element(Locators.ORGANIZATION, "name").clearInputValue().sendKeys(organization);
		try{
			assertTrue(this.page.element(Locators.ORGANIZATION, "name").getOne().getAttribute("value").equals(organization));
		} catch (Exception e) {
			this.page.element(Locators.ORGANIZATION, "name").clearInputValue().sendKeys(organization);
			assertTrue(this.page.element(Locators.ORGANIZATION, "name").getOne().getAttribute("value").equals(organization));
		}
		return this;
	}

	public UserInfo enterPrimaryEmail(String email) throws Exception {
		waitForElement.waitForElements(Locators.PRIMARYEMAIL, "name");
		this.page.element(Locators.PRIMARYEMAIL, "name").clearInputValue().sendKeys(email);
		assertTrue(this.page.element(Locators.PRIMARYEMAIL, "name").getOne().getAttribute("value").equals(email));
		return this;
	}

	public UserInfo clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().click();
		return this;
	}
	
	public UserInfo updateUserInfoAndSave(String firstname, String lastname, String email, String organization) throws Exception {
		this.enterFirstName(firstname);
		this.enterLastname(lastname);
		this.enterPrimaryEmail(email);
		this.enterOrganization(organization);
		this.clickOnSave();
		return this;
	}
	
}
