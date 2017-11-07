package EMTrack.pages;

import qaFramework.pageObject.PageObject;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import EMTrack.Locators.Login.Locators;
import qaFramework.UserDefinedFunctions.WaitForElement;

public class EMTrackLogin extends PageObject{
	WebDriver driver;
	WaitForElement waitForElement ;

	public EMTrackLogin(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver=_driver;
		 waitForElement = new WaitForElement(this.driver);	
		}
	
	public EMTrackLogin enterUserName(String username) throws Exception {
		waitForElement.waitForElements(Locators.USERNAME, "css");
		this.page.element(Locators.USERNAME, "css").clearInputValue().sendKeys(username);
		return this;
	}
	
	public EMTrackLogin enterPassword(String password) throws Exception {
		waitForElement.waitForElements(Locators.PASSWORD, "css");
		this.page.element(Locators.PASSWORD, "css").clearInputValue().sendKeys(password);
		return this;
	}

	public EMTrackLogin clickLogin() throws Exception {
		waitForElement.waitForElements(Locators.LOGIN, "css");
		this.page.element(Locators.LOGIN, "css").getOne().click();
		waitForElement.waitForPageLoad();
		return this;
	}
	
	public EMTrackLogin verifyDashBoard() throws Exception {
		waitForElement.waitForElements(Locators.HOMEPAGE, "linktext");
		assertTrue(this.page.element(Locators.HOMEPAGE, "linktext").isElementPresent());
		assertTrue(this.page.element(Locators.HOMEPAGE, "linktext").getOne().isDisplayed());
		return this;
	}
	
	public EMTrackLogin loginToEMTrack(String username, String password)
			throws Exception {
		driver.get("https://emtrack.qa.intermedix.com/");
		this.enterUserName(username);
		this.enterPassword(password);
		this.clickLogin();
		this.verifyDashBoard();
		return this;
	}
	public EMTrackLogin logOut() throws Exception {
		waitForElement.waitForElements(Locators.LOGOUT, "linktext");
		this.page.element(Locators.LOGOUT, "linktext").getOne().click();
		waitForElement.waitForElements(Locators.USERNAME, "css");
		return this;
	}
}