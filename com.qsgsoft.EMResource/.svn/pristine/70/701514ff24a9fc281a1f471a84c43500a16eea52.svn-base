package EMR.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.ImportUsers.Locators;
import EMR.pages.UsersList;

public class ImportUsers extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement;
	WebDriverWait wait;
	UsersList usersList;
	
	public ImportUsers(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}
	
	public ImportUsers clickOnImport() throws Exception {
		waitForElement.waitForElements(Locators.IMPORT, "css");
		this.page.element(Locators.IMPORT, "css").getOne().click();
		waitForElement.waitForElements(Locators.IMPORT_USERS_PAGE, "xpath");
		return this;
	}
	
	public ImportUsers verifyImportUserConfirmationPage() throws Exception {
		waitForElement.waitForElements(Locators.IMPORT_USERS_CONFIRMATION_PAGE, "xpath");
		waitForElement.waitForElements(Locators.IMPORT_INSTRUCTION, "xpath");
		assertTrue(this.page.element(Locators.IMPORT_INSTRUCTION, "xpath").isElementPresent());
		return this;
	}
	
	public ImportUsers verifyUsername(String username) throws Exception {
		waitForElement.waitForElements(Locators.USERNAME, "xpath");
		assertTrue(this.page.element(Locators.USERNAME, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.USERNAME, "xpath").getOne().getText().equals(username));
		return this;
	}
	
	public ImportUsers verifyUserFullname(String userFirstname, String userLastname) throws Exception {
		String userFullname = userFirstname + " " + userLastname;
		waitForElement.waitForElements(Locators.USERFULLNAME, "xpath");
		assertTrue(this.page.element(Locators.USERFULLNAME, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.USERFULLNAME, "xpath").getOne().getText().equals(userFullname));
		return this;
	}
	
	public ImportUsers verifyUserFirstname(String userFirstname) throws Exception {
		waitForElement.waitForElements(Locators.USER_FIRSTNAME, "xpath");
		assertTrue(this.page.element(Locators.USER_FIRSTNAME, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.USER_FIRSTNAME, "xpath").getOne().getText().equals(userFirstname));
		return this;
	}
	
	public ImportUsers verifyUserLastname(String userLastname) throws Exception {
		waitForElement.waitForElements(Locators.USER_LASTNAME, "xpath");
		assertTrue(this.page.element(Locators.USER_LASTNAME, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.USER_LASTNAME, "xpath").getOne().getText().equals(userLastname));
		return this;
	}
	
	public ImportUsers verifyUserOrganization(String organization) throws Exception {
		waitForElement.waitForElements(Locators.USER_ORGANIZATION, "xpath");
		assertTrue(this.page.element(Locators.USER_ORGANIZATION, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.USER_ORGANIZATION, "xpath").getOne().getText().equals(organization));
		return this;
	}
	
	public ImportUsers importUser(String username, String userFirstname, String userLastname, String organization) throws Exception {
		usersList = new UsersList(driver);
		usersList.clickOnImportUser();
		usersList.enterUsername(username);
		this.clickOnImport();
		this.verifyImportUserConfirmationPage();
		this.verifyUsername(username);
		this.verifyUserFullname(userFirstname, userLastname);
		this.verifyUserFirstname(userFirstname);
		this.verifyUserLastname(userLastname);
		this.verifyUserOrganization(organization);
		this.clickOnImport();
		return this;
	}
}
