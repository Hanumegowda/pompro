package EMR.pages;

import static org.testng.Assert.*;
import EMR.Locators.StatusReasonList.Locators;

import org.openqa.selenium.WebDriver;

import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;

public class StatusReasonList extends PageObject{
	WebDriver driver;
	WaitForElement waitForElement;  
	
	public StatusReasonList(WebDriver _driver) throws Exception {
		 super(_driver);  
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		// TODO Auto-generated constructor stub
	}
	
	public StatusReasonList clickOnCreateStatusReason() throws Exception {
		waitForElement.waitForElements(Locators.CREATESTATUSREASON, "css");
		this.page.element(Locators.CREATESTATUSREASON, "css").getOne().click();
		waitForElement.waitForElements(Locators.REASONNAME, "css");
		return this;
	}
	
	public StatusReasonList enterReasonName(String name) throws Exception {
		waitForElement.waitForElements(Locators.REASONNAME, "css");
		this.page.element(Locators.REASONNAME, "css").clearInputValue().sendKeys(name);
		assertEquals(this.page.element(Locators.REASONNAME, "css").getOne().getAttribute("value"), name);
		return this;
	}
	
	public StatusReasonList enterReasonDefinition(String definition) throws Exception {
		waitForElement.waitForElements(Locators.DEFINITION, "css");
		this.page.element(Locators.DEFINITION, "css").clearInputValue().sendKeys(definition);
		assertEquals(this.page.element(Locators.DEFINITION, "css").getOne().getAttribute("value"), definition);
		return this;
	}
	
	public StatusReasonList clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().click();
		waitForElement.waitForElements(Locators.CREATESTATUSREASON, "css");
		return this;
	}
	
	public StatusReasonList createStatusReason(String name,
			String definition) throws Exception {
		this.clickOnCreateStatusReason();
		this.enterReasonName(name);
		this.enterReasonDefinition(definition);
		this.clickOnSave();
		return this;
	}
	
	public String getStatusReasonValue(String name) throws Exception {
		String value=Locators.REASONVALUE_PART1+name+Locators.REASONVALUE_PART2;
		waitForElement.waitForElements(value,"xpath");
		String getReasonValue = this.page.element(value, "xpath").getOne().getAttribute("href");
		String[] reasonValue = getReasonValue.split("nextStepDetail=");
		return reasonValue[1];
	}
	
	public StatusReasonList verifyCreatedStatusReasonInList(String name)
			throws Exception {
		
		String reason=Locators.REASONVALUE_PART1+name+Locators.CLOSING_BRACKET;
		waitForElement.waitForElements(reason, "xpath");
		assertTrue(this.page.element(reason, "xpath").isElementPresent(), "Created Status Reason is not present.");
		assertTrue(this.page.element(reason, "xpath").getOne().isDisplayed(), "Created Status Reason is not present.");
		return this;
	}
	
	public StatusReasonList clickOnEdit(String statusReasonName) throws Exception {
		waitForElement.waitForElements(Locators.REASONVALUE_PART1+statusReasonName+Locators.CLOSING_BRACKET+EMR.Locators.InterfaceSetUp.Locators.EDITLINKPART2, "xpath");
		this.page.element(Locators.REASONVALUE_PART1+statusReasonName+Locators.CLOSING_BRACKET+EMR.Locators.InterfaceSetUp.Locators.EDITLINKPART2, "xpath").getDisplayedOne().click();
		return this;
	}
	
	public StatusReasonList editNameAndDefinition(String statusReasonName,String name,
			String definition) throws Exception {
		this.clickOnEdit(statusReasonName);
		this.enterReasonName(name);
		this.enterReasonDefinition(definition);
		this.clickOnSave();
		return this;
	}
	
	public StatusReasonList verifyReasonNameAndDefinition(String name,String definition)
			throws Exception {
		String reason=Locators.REASONVALUE_PART1+name+Locators.CLOSING_BRACKET+EMR.Locators.InterfaceSetUp.Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME+definition+Locators.CLOSING_BRACKET;
		waitForElement.waitForElements(reason, "xpath");
		assertTrue(this.page.element(reason, "xpath").isElementPresent());
		assertTrue(this.page.element(reason, "xpath").getOne().isDisplayed());
		return this;
	}

	public StatusReasonList enterReasonAbbreviation(String abbreviation) throws Exception {
		waitForElement.waitForElements(Locators.ABBREVATION, "css");
		this.page.element(Locators.ABBREVATION, "css").clearInputValue().sendKeys(abbreviation);
		assertEquals(this.page.element(Locators.ABBREVATION, "css").getOne().getAttribute("value"), abbreviation);
		return this;
	}
	
	public StatusReasonList createStatusReason(String name, String definition, String abbreviation) throws Exception {
		this.clickOnCreateStatusReason();
		this.enterReasonName(name);
		this.enterReasonDefinition(definition);
		this.enterReasonAbbreviation(abbreviation);
		this.clickOnSave();
		this.verifyStatusReasonList();
		return this;
	}
	
	public StatusReasonList verifyStatusReasonDetailsInList(String name, String definition, String abbreviation) throws Exception {
		waitForElement.waitForElements(Locators.STATUS_REASON_LIST, "xpath");
		String element = Locators.STATUS_REASON_PART1 + name + Locators.ABBREVIATION_DESCRIPTION + abbreviation + Locators.ABBREVIATION_DESCRIPTION + definition + Locators.CLOSING_BRACKET;
		waitForElement.waitForElements(element, "xpath");
		assertTrue(this.page.element(element, "xpath").isElementPresent());
		return this;
	}
	
	public StatusReasonList verifyReasonName_Disabled(String name) throws Exception {
		waitForElement.waitForElements(Locators.REASON_NAME_DISABLED, "css");
		assertEquals(this.page.element(Locators.REASON_NAME_DISABLED, "css").getOne().getAttribute("value"), name);
		return this;
	}
	
	public StatusReasonList verifyStatusReasonList() throws Exception {
		waitForElement.waitForElements(Locators.STATUS_REASON_LIST, "xpath");
		assertTrue(this.page.element(Locators.STATUS_REASON_LIST, "xpath").isElementPresent(), "status reason list is not displayed.");
		return this;
	}
	
	public StatusReasonList editDefinitionAndAbbreviation(String statusReasonName, String definition, String abbreviation) throws Exception {
		this.clickOnEdit(statusReasonName);
		this.verifyReasonName_Disabled(statusReasonName);
		this.enterReasonDefinition(definition);
		this.enterReasonAbbreviation(abbreviation);
		this.clickOnSave();
		this.verifyStatusReasonList();
		return this;
	}
}