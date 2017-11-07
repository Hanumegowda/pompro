package eICS.pages;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;
import eICS.Locators.MyProfile.Locators;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;

public class MyProfile extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	
	public MyProfile(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
	}

	public MyProfile verifyMyProfilePage() throws Exception {
		waitForElement.waitForElements(Locators.MY_PROFILE_PAGE, "xpath");
		assertTrue(this.page.element(Locators.MY_PROFILE_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.MY_PROFILE_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public MyProfile verifyFirstname(String firstname) throws Exception {
		waitForElement.waitForElements(Locators.FIRST_NAME, "id");
		assertTrue(this.page.element(Locators.FIRST_NAME, "id").getOne().getAttribute("value").equals(firstname));
		return this;
	}
	
	public MyProfile verifyLastname(String lastname) throws Exception {
		waitForElement.waitForElements(Locators.LAST_NAME, "id");
		assertTrue(this.page.element(Locators.LAST_NAME, "id").getOne().getAttribute("value").equals(lastname));
		return this;
	}
	
	public MyProfile verifyOrganization(String organization) throws Exception {
		waitForElement.waitForElements(Locators.ORGANIZATION, "id");
		assertTrue(this.page.element(Locators.ORGANIZATION, "id").getOne().getAttribute("value").equals(organization));
		return this;
	}
	
	public MyProfile verifyPrimaryEmail(String email) throws Exception {
		waitForElement.waitForElements(Locators.PRIMARY_EMAILID, "id");
		assertTrue(this.page.element(Locators.PRIMARY_EMAILID, "id").getOne().getText().equals(email));
		return this;
	}
	
	public MyProfile verifyUserDeatils(String firstname, String lastname, String organization, String email) throws Exception {
		this.verifyFirstname(firstname);
		this.verifyLastname(lastname);
		this.verifyOrganization(organization);
		this.verifyPrimaryEmail(email);
		return this;
	}
}
