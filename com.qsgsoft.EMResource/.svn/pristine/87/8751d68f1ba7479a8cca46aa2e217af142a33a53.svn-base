package eICS.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import eICS.Locators.EicsLogin;
import eICS.Locators.NavigateToEics.Locators;

public class NavigateToEics extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	
	public NavigateToEics(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
	}
	
	public NavigateToEics contacts() throws Exception {
		driver.get(Locators.CONTACTS_URL);
		waitForElement.waitForElements(Locators.FACILITY_LIST, "css");
		return this;
	}
	
	public NavigateToEics logout() throws Exception {
		waitForElement.waitForElements(Locators.LOGOUT, "linktext");
		this.page.element(Locators.LOGOUT, "linktext").Click();
		waitForElement.waitForElements(EicsLogin.Locators.USERNAME, "name");
		return this;
	}
	
	public NavigateToEics myProfile() throws Exception {
		driver.get(Locators.MY_PROFILE_URL);
		waitForElement.waitForElements(eICS.Locators.MyProfile.Locators.MY_PROFILE_PAGE, "xpath");
		assertTrue(this.page.element(eICS.Locators.MyProfile.Locators.MY_PROFILE_PAGE, "xpath").isElementPresent());
		return this;
	}
	
	public NavigateToEics createIncident() throws Exception {
		driver.get(Locators.CREATE_INCIDENT);
		waitForElement.waitForElements(eICS.Locators.CreateIncident.Locators.CREATE_INCIDENT_PAGE, "xpath");
		assertTrue(this.page.element(eICS.Locators.CreateIncident.Locators.CREATE_INCIDENT_PAGE, "xpath").isElementPresent());
		return this;
	}
	
    public NavigateToEics clickYesInLogoutConfirmationWindow() throws Exception {
    	waitForElement.waitForElements(Locators.LOGOUT_CONFIRMATION, "xpath");
//    	this.page.element(Locators.LOGOUT_CONFIRMATION, "xpath").mouseOver();
    	this.page.element(Locators.LOGOUT_CONFIRMATION, "xpath").clickUsingJSE();
    	try {
    		if(this.page.element(eICS.Locators.EicsLogin.Locators.USERNAME, "name").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
    			if(this.page.element(Locators.LOGOUT_CONFIRMATION, "xpath").getOne().isDisplayed()) {
    				this.page.element(Locators.LOGOUT_CONFIRMATION, "xpath").getOne().sendKeys(Keys.ENTER);
    			} else {
    				this.logout();
    				JavascriptExecutor executor = (JavascriptExecutor)driver;
    				executor.executeScript("arguments[0].click();", this.page.element(Locators.LOGOUT_CONFIRMATION, "xpath").getOne());
    			}
    		}
    	} catch(Exception e) {
    		this.logout();
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", this.page.element(Locators.LOGOUT_CONFIRMATION, "xpath").getOne());
    	}
    	return this;
    }
    
	public NavigateToEics logoutFromIncidentScreen() throws Exception {
		this.logout();
		this.clickYesInLogoutConfirmationWindow();
		return this;
	}
}