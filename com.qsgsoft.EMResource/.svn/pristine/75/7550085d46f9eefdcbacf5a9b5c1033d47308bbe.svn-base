package eICS.pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import eICS.Locators.CreateIncident.Locators;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;

public class CreateIncident extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	
	public CreateIncident(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
	}

	public CreateIncident verifyCreateIncidentPage() throws Exception {
		waitForElement.waitForElements(Locators.CREATE_INCIDENT_PAGE, "xpath");
		assertTrue(this.page.element(Locators.CREATE_INCIDENT_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CREATE_INCIDENT_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public CreateIncident selectFacility(String facilityName) throws Exception {
		waitForElement.waitForElements(Locators.FACILITY, "css");
		this.page.element(Locators.FACILITY, "css").webElementToSelect().selectByVisibleText(facilityName);
		assertTrue(this.page.element(Locators.FACILITY, "css").webElementToSelect().getFirstSelectedOption().getText().equals(facilityName));
		return this;
	}
	
	public CreateIncident selectIRG(String IRG_Name) throws Exception {
		waitForElement.waitForElements(Locators.IRG_PART1 + IRG_Name + Locators.CLOSING_BRACKETS, "xpath");
		this.page.element(Locators.IRG_PART1 + IRG_Name + Locators.CLOSING_BRACKETS, "xpath").Click();
		return this;
	}
	
	public CreateIncident clickOnNext() throws Exception {
		waitForElement.waitForElements(Locators.NEXT, "css");
		this.page.element(Locators.NEXT, "css").Click();
		this.page.element_wait(eICS.Locators.Contacts.Locators.LOADING_PAGE_BLOCKER, "xpath").waitForInvisibilityOfElement();
		return this;
	}
	
	public CreateIncident enterIncidentName(String incidentName) throws Exception {
		waitForElement.waitForElements(Locators.INCIDENT_NAME, "css");
		this.page.element(Locators.INCIDENT_NAME, "css").clearInputValue().sendKeys(incidentName);
		assertTrue((this.page.element(Locators.INCIDENT_NAME, "css").getOne().getAttribute("value").equals(incidentName)));
		return this;
	}
	
	public CreateIncident enterIncidentDescription(String description) throws Exception {
		waitForElement.waitForElements(Locators.INCIDENT_DESCRIPTION, "css");
		this.page.element(Locators.INCIDENT_DESCRIPTION, "css").clearInputValue().sendKeys(description);
		assertTrue((this.page.element(Locators.INCIDENT_DESCRIPTION, "css").getOne().getAttribute("value").equals(description)));
		return this;
	}
	
	public CreateIncident clickOnSelectNotificationContacts() throws Exception {
		waitForElement.waitForElements(Locators.SELECT_NOTIFICATION_CONTACTS, "css");
		this.page.element(Locators.SELECT_NOTIFICATION_CONTACTS, "css").Click();
		waitForElement.waitForElement(Locators.VOICE_NOTIFICATION, "css");
		return this;
	}
	
	public CreateIncident deselectVoiceNotificationMethod() throws Exception {
		waitForElement.waitForElements(Locators.VOICE_NOTIFICATION, "css");
		if(this.page.element(Locators.VOICE_NOTIFICATION, "css").getOne().isSelected()) {
			this.page.element(Locators.VOICE_NOTIFICATION, "css").Click();
		}
		assertTrue(this.page.element(Locators.VOICE_NOTIFICATION, "css").getOne().isSelected()==false);
		return this;
	}
	
	public CreateIncident deselectMailNotificationMethod() throws Exception {
		waitForElement.waitForElements(Locators.MAIL_NOTIFICATION_, "css");
		if(this.page.element(Locators.MAIL_NOTIFICATION_, "css").getOne().isSelected()) {
			this.page.element(Locators.MAIL_NOTIFICATION_, "css").Click();
		}
		assertTrue(this.page.element(Locators.MAIL_NOTIFICATION_, "css").getOne().isSelected()==false);
		return this;
	}
	
	public CreateIncident clickOnOk() throws Exception {
		waitForElement.waitForElements(Locators.OK_BUTTON, "xpath");
		this.page.element(Locators.OK_BUTTON, "xpath").Click();
		return this;
	}
	
	public CreateIncident clickOnActivateIncident() throws Exception {
		waitForElement.waitForElements(Locators.ACTIVATE_INCIDENT, "css");
		this.page.element(Locators.ACTIVATE_INCIDENT, "css").Click();
		this.page.element_wait(eICS.Locators.Contacts.Locators.LOADING_PAGE_BLOCKER, "xpath").waitForInvisibilityOfElement();
		return this;
	}
	
	public CreateIncident createIncident(String facilityName, String IrgName, String incidentName, String description) throws Exception {
		this.verifyCreateIncidentPage();
		this.selectFacility(facilityName);
		this.selectIRG(IrgName);
		this.clickOnNext();
		this.enterIncidentName(incidentName);
		this.enterIncidentDescription(description);
		this.clickOnSelectNotificationContacts();
		this.deselectVoiceNotificationMethod();
		this.deselectMailNotificationMethod();
		this.clickOnOk();
		this.clickOnActivateIncident();
		waitForElement.waitForElements(Locators.CREATED_INCIDENT_NAME + incidentName + Locators.CLOSING_BRACKETS, "xpath");
		this.page.element_wait(eICS.Locators.Contacts.Locators.LOADING_PAGE_BLOCKER, "xpath").waitForInvisibilityOfElement();
		return this;
	}
}
