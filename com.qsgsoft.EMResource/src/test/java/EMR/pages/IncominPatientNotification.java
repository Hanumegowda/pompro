package EMR.pages;

import org.openqa.selenium.WebDriver;
import EMR.Locators.IncomingPatientNotification.Locators;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import static org.testng.Assert.assertTrue;

public class IncominPatientNotification extends PageObject{
	WebDriver driver;
	WaitForElement waitForElement;
	Shared navigateTo;

	public IncominPatientNotification(WebDriver _driver) throws Exception {
		super(_driver);
		waitForElement= new WaitForElement(driver);
		navigateTo= new Shared(driver);
	}
	
	public IncominPatientNotification verifyIncomingPatientNotificationsInLast24Hourspage() throws Exception {
		waitForElement.waitForElements(Locators.INCOMING_PATIENT_NOTIFICATIONS_IN_LAST_24_HOURS, "id");
		assertTrue(this.page.element(Locators.INCOMING_PATIENT_NOTIFICATIONS_IN_LAST_24_HOURS, "id").isElementPresent());
		return this;
	}
	
	public IncominPatientNotification verifyIPNSentAt(String Resource, String SentAt)throws Exception{
		waitForElement.waitForElements(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + SentAt + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + SentAt + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + SentAt + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public IncominPatientNotification verifyIPNSentBy(String Resource, String SentBy)throws Exception{
		waitForElement.waitForElements(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + SentBy + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + SentBy + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + SentBy + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public IncominPatientNotification verifyIPNETA(String Resource, String ETA)throws Exception{
		waitForElement.waitForElements(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + ETA + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + ETA + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + ETA + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public IncominPatientNotification verifyIPNAge(String Resource, String Age)throws Exception{
		waitForElement.waitForElements(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + Age + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + Age + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + Age + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public IncominPatientNotification verifyIPNComplaint(String Resource, String Complaint)throws Exception{
		waitForElement.waitForElements(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + Complaint + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + Complaint + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + Complaint + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public IncominPatientNotification verifyIPNTriage(String Resource, String Triage)throws Exception{
		waitForElement.waitForElements(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + Triage + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + Triage + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + Triage + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
    }
	public IncominPatientNotification verifyIPNGender(String Resource, String Gender)throws Exception{
		waitForElement.waitForElements(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + Gender + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + Gender + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.PRECEDING_COLUMNS_OF_RESOURCE_NAME + Gender + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
    }
	
	public IncominPatientNotification verifyIPNRegion(String Resource, String Region)throws Exception{
		waitForElement.waitForElements(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.FOLLOWING_COLUMNS_OF_RESOURCE_NAME + Region + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.FOLLOWING_COLUMNS_OF_RESOURCE_NAME + Region + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.FOLLOWING_COLUMNS_OF_RESOURCE_NAME + Region + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public IncominPatientNotification verifyIPNAcknowledgeAt(String Resource, String AcknowledgeAt)throws Exception{
		waitForElement.waitForElements(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.FOLLOWING_COLUMNS_OF_RESOURCE_NAME + AcknowledgeAt + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.FOLLOWING_COLUMNS_OF_RESOURCE_NAME + AcknowledgeAt + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.FOLLOWING_COLUMNS_OF_RESOURCE_NAME + AcknowledgeAt + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public IncominPatientNotification verifyIPNAcknowledgeBy(String Resource, String AcknowledgeBy)throws Exception{
		waitForElement.waitForElements(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.FOLLOWING_COLUMNS_OF_RESOURCE_NAME + AcknowledgeBy + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.FOLLOWING_COLUMNS_OF_RESOURCE_NAME + AcknowledgeBy + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_TABLE + Resource + Locators.CLOSING_BRACKET+Locators.FOLLOWING_COLUMNS_OF_RESOURCE_NAME + AcknowledgeBy + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public IncominPatientNotification verifyIncomingPatientNotificationDetails(String Resource, String SentAt, String SentBy, String ETA, String Age, String Complaint, String Triage, String Gender, String Region, String AcknowledgeAt, String AcknowledgeBy) throws Exception {
		this.verifyIPNSentAt(Resource,SentAt);
		this.verifyIPNSentBy(Resource,SentBy);
		this.verifyIPNETA(Resource, ETA);
		this.verifyIPNAge(Resource, Age);
		this.verifyIPNComplaint(Resource, Complaint);
		this.verifyIPNTriage(Resource, Triage);
		this.verifyIPNGender(Resource, Gender);
		this.verifyIPNRegion(Resource, Region);
		this.verifyIPNAcknowledgeAt(Resource, AcknowledgeAt);
		this.verifyIPNAcknowledgeBy(Resource, AcknowledgeBy);
		return this;
	}
}