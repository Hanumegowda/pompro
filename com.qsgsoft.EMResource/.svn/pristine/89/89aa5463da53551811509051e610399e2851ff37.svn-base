package EMR.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import EMR.Locators.ManualIPNEntry.Locators;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;

public class ManualIPNEntry extends PageObject{
	
	WaitForElement waitForElement;
	WebDriver driver;
	String NotificationMessage;

	public ManualIPNEntry(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		 waitForElement = new WaitForElement(this.driver);
		// TODO Auto-generated constructor stub
	}
	
	public ManualIPNEntry verifyManualIPNEntryPage() throws Exception {
		waitForElement.waitForElements(Locators.MANUAL_IPN_ENTRY, "xpath");
		assertTrue(this.page.element(Locators.MANUAL_IPN_ENTRY, "xpath").isElementPresent());
		return this;
	}
	
	public ManualIPNEntry verifyIncomingPatientNotificationMessage() throws Exception {
		waitForElement.waitForElements(Locators.INCOMING_PATIENT_NOTIFICATION_MESSAGE, "xpath");
		assertTrue(this.page.element(Locators.INCOMING_PATIENT_NOTIFICATION_MESSAGE, "xpath").isElementPresent());
		NotificationMessage =this.page.element(Locators.INCOMING_PATIENT_NOTIFICATION_MESSAGE, "xpath").getOne().getText();
		String message = "Incoming Patient Notification has been sent.";
		System.out.println(NotificationMessage);
		assertTrue(NotificationMessage.equals(message));
		return this;
	}
	
	public ManualIPNEntry selectGender(String gender) throws Exception {
		gender = gender.toUpperCase();
		String genderElement = Locators.GENDER+gender+Locators.CLOSING_BRACKETS;
		waitForElement.waitForElements(genderElement, "css");
		assertTrue(this.page.element(genderElement, "css").isElementPresent());
		if(this.page.element(genderElement, "css").getOne().isSelected() == false){
			this.page.element(genderElement, "css").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(genderElement, "css").getOne().isSelected() == false){
			this.page.element(genderElement, "css").getOne().click();
		}	
		assertTrue(this.page.element(genderElement, "css").getOne().isSelected(), gender+ " is not selected");
		return this;
	}
	
	public ManualIPNEntry enterAge(String age)throws Exception {
		waitForElement.waitForElements(Locators.AGE, "id");
		this.page.element(Locators.AGE, "id").clearInputValue().sendKeys(age);
		return this;
	}
	
	public ManualIPNEntry selectDropDownYear(String year) throws Exception {
		waitForElement.waitForElements(Locators.YEAR, "id");
		this.page.element(Locators.YEAR, "id").webElementToSelect().selectByVisibleText(year);
		return this;
	}
	
	public ManualIPNEntry enterChiefComplaint(String chiefComplaint) throws Exception {
		waitForElement.waitForElements(Locators.CHIEF_COMPLAINT, "id");
		this.page.element(Locators.CHIEF_COMPLAINT, "id").clearInputValue().sendKeys(chiefComplaint);
		return this;
	}
	
	public ManualIPNEntry selectTriageCategory(String triageCategory) throws Exception {
		triageCategory = triageCategory.toUpperCase();
		String triageCategoryElement = Locators.TRIAGE_CATEGORY+triageCategory+Locators.CLOSING_BRACKETS; 
		waitForElement.waitForElements(triageCategoryElement, "css");
		assertTrue(this.page.element(triageCategoryElement, "css").isElementPresent());
		if(this.page.element(triageCategoryElement, "css").getOne().isSelected()== false){
			this.page.element(triageCategoryElement, "css").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(triageCategoryElement, "css").getOne().isSelected() == false){
			this.page.element(triageCategoryElement, "css").getOne().click();
		}
		assertTrue(this.page.element(triageCategoryElement, "css").getOne().isSelected(), triageCategory+ "is not slected");
		return this;
	}
	
	public ManualIPNEntry selectLevelOfCare(String levelOfCare) throws Exception{
		levelOfCare = levelOfCare.toUpperCase();
		String levelOfCareElement = Locators.LEVEL_OF_CARE+levelOfCare+Locators.CLOSING_BRACKETS;
		waitForElement.waitForElements(levelOfCareElement, "css");
		assertTrue(this.page.element(levelOfCareElement, "css").isElementPresent());
		if(this.page.element(levelOfCareElement, "css").getOne().isSelected() == false){
			this.page.element(levelOfCareElement, "css").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(levelOfCareElement, "css").getOne().isSelected() == false){
			this.page.element(levelOfCareElement, "css").getOne().click();
		}
		assertTrue(this.page.element(levelOfCareElement, "css").getOne().isSelected(), levelOfCare + "is not selected");
		return this;
	}
	
	public ManualIPNEntry enterEMSAgency(String emsAgency) throws Exception {
		waitForElement.waitForElements(Locators.EMS_AGENCY, "id");
		this.page.element(Locators.EMS_AGENCY, "id").clearInputValue().sendKeys(emsAgency);
		return this;
	}
	
	public ManualIPNEntry enterEMSUnit(String emsUnit) throws Exception {
		waitForElement.waitForElements(Locators.EMS_UNIT, "id");
		this.page.element(Locators.EMS_UNIT, "id").clearInputValue().sendKeys(emsUnit);
		return this;
	}
	
	public ManualIPNEntry selectTransportingTo(String transpotingTo) throws Exception {
		waitForElement.waitForElements(Locators.TANSPORTING_TO, "id");
		this.page.element(Locators.TANSPORTING_TO, "id").webElementToSelect().selectByVisibleText(transpotingTo);
		return this;
	}
	public ManualIPNEntry enterETA(String eta) throws Exception {
		waitForElement.waitForElements(Locators.ETA, "id");
		this.page.element(Locators.ETA, "id").clearInputValue().sendKeys(eta);
		return this;
	}
	public ManualIPNEntry clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "id");
		this.page.element(Locators.SAVE, "id").clickUsingJSE();
		waitForElement.waitForElements(Locators.MANUAL_IPN_ENTRY, "xpath");
		return this;
	}
	public ManualIPNEntry enterManualIPNEntryData(String gender, String age ,String chiefComplaint,String triageCategory
			,String levelOfCare,String emsAgency,String emsUnit,String transpotingTo,String eta) throws Exception {
		waitForElement.waitForElements(Locators.MANUAL_IPN_ENTRY, "xpath");
		assertTrue(this.page.element(Locators.MANUAL_IPN_ENTRY, "xpath").isElementPresent());
		this.selectGender(gender);
		this.enterAge(age);
		this.enterChiefComplaint(chiefComplaint);
		this.selectTriageCategory(triageCategory);
		this.selectLevelOfCare(levelOfCare);
		this.enterEMSAgency(emsAgency);
		this.enterEMSUnit(emsUnit);
		this.selectTransportingTo(transpotingTo);
		this.enterETA(eta);
		this.clickOnSave();
		return this;
	}
	
}
		
	
		

