package EMR.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.EventSetUp.Locators;
import EMR.data.EventSetUpData;

public class EventSetUp extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	WebDriverWait wait;

	public EventSetUp(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement =  new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}

	public EventSetUp clickOncreateEventTemplate() throws Exception {
		waitForElement.waitForElements(Locators.CREATEEVENTTEMPLATE, "css");
		this.page.element(Locators.CREATEEVENTTEMPLATE, "css").getOne().click();
		return this;
	}

	public EventSetUp enterEventTemplateName(String templateName) throws Exception {
		waitForElement.waitForElements(Locators.TEMPLATENAME, "name");
		this.page.element(Locators.TEMPLATENAME, "name").clearInputValue().sendKeys(templateName);
		return this;
	}

	public EventSetUp enterEventTemplateDefintion(String definition) throws Exception {
		waitForElement.waitForElements(Locators.TEMPLATEDESCRIPTION, "name");
		this.page.element(Locators.TEMPLATEDESCRIPTION, "name").clearInputValue().sendKeys(definition);
		return this;
	}

	public EventSetUp selectResourceType(String resourceTypeValue) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPEINPUT+ resourceTypeValue + Locators.CLOSINGBRACKET, "css");
		this.page.element(Locators.RESOURCETYPEINPUT+ resourceTypeValue + Locators.CLOSINGBRACKET, "css").getOne().click();
		return this;
	}

	public EventSetUp selectStatusType(String statusTypeValue) throws Exception {
		waitForElement.waitForElements(Locators.STATUSTYPEINPUT+ statusTypeValue + Locators.CLOSINGBRACKET, "css");
		if(this.page.element(Locators.STATUSTYPEINPUT+ statusTypeValue + Locators.CLOSINGBRACKET, "css").getOne().isSelected() == false) {
			this.page.element(Locators.STATUSTYPEINPUT+ statusTypeValue + Locators.CLOSINGBRACKET, "css").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(Locators.STATUSTYPEINPUT+ statusTypeValue + Locators.CLOSINGBRACKET, "css").getOne().isSelected() == false) {
			this.page.element(Locators.STATUSTYPEINPUT+ statusTypeValue + Locators.CLOSINGBRACKET, "css").clickUsingJSE();
		}
		if(this.page.element(Locators.STATUSTYPEINPUT+ statusTypeValue + Locators.CLOSINGBRACKET, "css").getOne().isSelected() == false) {
			this.page.element(Locators.STATUSTYPEINPUT+ statusTypeValue + Locators.CLOSINGBRACKET, "css").Click();
		}
		assertTrue(this.page.element(Locators.STATUSTYPEINPUT+ statusTypeValue + Locators.CLOSINGBRACKET, "css").getOne().isSelected(), statusTypeValue+ " status type is not selected");
		return this;
	}

	public EventSetUp clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getDisplayedOne().click();
		return this;
	}

	public EventSetUp deselectSelectAllWebOption() throws Exception {
		waitForElement.waitForElements(Locators.WEBMAILSELECTALL, "xpath");
		if (this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().isSelected()) {
			this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().isSelected()) {
			this.page.element(Locators.WEBMAILSELECTALL, "xpath").clickUsingJSE();
		}
		assertFalse(this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().isSelected(), "Web notification master check box is not deselected.");
		return this;
	}

	public EventSetUp createEventTemplate(String eventTemplate, String templateDefinition, String resourceTypeValue, String statusTypeValue) throws Exception {			
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(eventTemplate);
		this.enterEventTemplateDefintion(templateDefinition);
		this.selectResourceType(resourceTypeValue);
		this.selectStatusType(statusTypeValue);
		this.clickOnSave();
		return this;
	}

	public EventSetUp createEventTemplateDeselectingWebOption(String eventTemplate, String templateDefinition, String resourceTypeValue, String statusTypeValue) throws Exception {			
		this.createEventTemplate(eventTemplate, templateDefinition, resourceTypeValue, statusTypeValue);
		this.deselectSelectAllWebOption();
		this.clickOnSave();
		return this;
	}

	public EventSetUp selectEmailNotification(String userName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.EMAILNOTIFICATIONINPUT,
				"xpath");
		if (this.page
				.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.EMAILNOTIFICATIONINPUT,
						"xpath").getOne().isSelected() == false) {
			this.page
			.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.EMAILNOTIFICATIONINPUT,
					"xpath").getOne().click();
			assertTrue(this.page.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.EMAILNOTIFICATIONINPUT,
					"xpath").getOne().isSelected());
		}
		return this;
	}

	public EventSetUp selectWebNotification(String userName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.WEBNOTIFICATIONINPUT,
				"xpath");
		if (this.page
				.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.WEBNOTIFICATIONINPUT,
						"xpath").getOne().isSelected() == false) {
			this.page
			.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.WEBNOTIFICATIONINPUT,
					"xpath").getOne().click();
			assertTrue(this.page.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.WEBNOTIFICATIONINPUT,
					"xpath").getOne().isSelected());
		}
		return this;
	}

	public EventSetUp selectPagerNotification(String userName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT_PART1 + userName+ Locators.CLOSINGBRACKET +Locators.PAGERNOTIFICATIONINPUT,
				"xpath");
		if (this.page
				.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET + Locators.PAGERNOTIFICATIONINPUT,
						"xpath").getOne().isSelected() == false) {
			this.page
			.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.PAGERNOTIFICATIONINPUT,
					"xpath").getOne().click();
			assertTrue(this.page.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.PAGERNOTIFICATIONINPUT,
					"xpath").getOne().isSelected());
		}
		return this;
	}

	public EventSetUp selectNotificationsForUserAndSave(String userName) throws Exception {
		this.deselectSelectAllWebOption();
		this.selectEmailNotification(userName);
		this.selectPagerNotification(userName);
		this.selectWebNotification(userName);
		this.clickOnSave();
		return this;
	}

	public EventSetUp createEventTemplate(String eventTemplate, String templateDefinition, String resourceTypeValue, String[] statusTypeValue) throws Exception {			
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(eventTemplate);
		this.enterEventTemplateDefintion(templateDefinition);
		this.selectResourceType(resourceTypeValue);
		for(int i = 0; i < statusTypeValue.length; i++) {
			this.selectStatusType(statusTypeValue[i]);
		}
		this.clickOnSave();
		this.deselectSelectAllWebOption();
		this.clickOnSave();
		this.verifyEventTemplateListPage();
		return this;
	}

	public EventSetUp createEventTemplateSelectingWebOption(String eventTemplate, String templateDefinition, String resourceTypeValue, String[] statusTypeValue, String userName) throws Exception {			
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(eventTemplate);
		this.enterEventTemplateDefintion(templateDefinition);
		this.selectResourceType(resourceTypeValue);
		for(int i = 0; i < statusTypeValue.length; i++) {
			this.selectStatusType(statusTypeValue[i]);
		}
		this.clickOnSave();
		this.selectNotificationsForUserAndSave(userName);
		return this;
	}

	public EventSetUp createMultiRegionEventTemplateWithAddress(String eventTemplate, String templateDefinition,String iconName, String color, String resourceTypeValue, String[] statusTypeValue, String userName) throws Exception {			
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(eventTemplate);
		this.enterEventTemplateDefintion(templateDefinition);
		this.selectEventIcon(iconName);
		this.selectEventColor(color);
		this.selectMultiRegion();
		this.selectMandatoryAddress();
		this.selectResourceType(resourceTypeValue);
		for(int i = 0; i < statusTypeValue.length; i++) {
			this.selectStatusType(statusTypeValue[i]);
		}
		this.clickOnSave();
		this.selectNotificationsForUserAndSave(userName);
		this.verifyEventTemplateListPage();
		return this;
	}

	public EventSetUp clickOnNotificationsLink(String eventTemplateName) throws Exception {
		String notificationLink = Locators.TABLECELLWITHTEXT_PART1 + eventTemplateName + Locators.CLOSINGBRACKET + Locators.TABLECELLWITHTEXT_PART2 + EventSetUpData.NOTIFICATION_LINK + Locators.CLOSINGBRACKET;
		waitForElement.waitForElementByxpathSelector(notificationLink);
		this.page.element(notificationLink, "xpath").clickUsingJSE();
		return this;
	}

	public EventSetUp clickOnNotificationsAndSelectAllNotificationsAndSave(String userName, String eventTemplateName) throws Exception {
		this.clickOnNotificationsLink(eventTemplateName);
		this.deselectSelectAllWebOption();
		this.selectEmailNotification(userName);
		this.selectPagerNotification(userName);
		this.selectWebNotification(userName);
		this.clickOnSave();
		this.verifyEventTemplateListPage();
		return this;
	}

	public EventSetUp verifyEventTemplateListPage() throws Exception {
		waitForElement.waitForElements(Locators.EVENT_TEMPLATE_LIST_PAGE, "xpath");
		assertTrue(this.page.element(Locators.EVENT_TEMPLATE_LIST_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_TEMPLATE_LIST_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventSetUp createMultiRegionEventTemplate(String eventTemplate, String templateDefinition,String iconName , String color, String resourceTypeValue, String[] statusTypeValue) throws Exception {			
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(eventTemplate);
		this.enterEventTemplateDefintion(templateDefinition);
		this.selectEventIcon(iconName);
		this.selectEventColor(color);
		this.selectMultiRegion();
		this.selectResourceType(resourceTypeValue);
		for(int i = 0; i < statusTypeValue.length; i++) {
			this.selectStatusType(statusTypeValue[i]);
		}
		this.clickOnSave();
		this.deselectSelectAllWebOption();
		this.clickOnSave();
		this.verifyEventTemplateListPage();
		return this;
	}

	public EventSetUp selectMandatoryAddress() throws Exception {
		waitForElement.waitForElements(Locators.ADDRESS_REQUIRED, "css");
		this.page.element(Locators.ADDRESS_REQUIRED, "css").clickUsingJSE();
		assertTrue(this.page.element(Locators.ADDRESS_REQUIRED, "css").getOne().isSelected());
		return this;
	}

	public EventSetUp selectMultiRegion() throws Exception {
		waitForElement.waitForElements(Locators.MULTI_REGION_CHECKBOX, "css");
		this.page.element(Locators.MULTI_REGION_CHECKBOX, "css").clickUsingJSE();
		assertTrue(this.page.element(Locators.MULTI_REGION_CHECKBOX, "css").getOne().isSelected());
		return this;
	}

	public EventSetUp createMultiRegionEventTemplateSelectingWebOption(String eventTemplate, String templateDefinition, String iconName, String color, String resourceTypeValue, String[] statusTypeValue, String userName) throws Exception {			
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(eventTemplate);
		this.enterEventTemplateDefintion(templateDefinition);
		this.selectEventIcon(iconName);
		this.selectEventColor(color);
		this.selectMultiRegion();
		this.selectResourceType(resourceTypeValue);
		for(int i = 0; i < statusTypeValue.length; i++) {
			this.selectStatusType(statusTypeValue[i]);
		}
		this.clickOnSave();
		this.selectNotificationsForUserAndSave(userName);
		return this;
	}

	public EventSetUp selectEventIcon(String iconName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_ICON, "id");
		this.page.element(Locators.EVENT_ICON, "id").webElementToSelect().selectByVisibleText(iconName);
		return this;
	}

	public EventSetUp selectEventColor(String color) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_COLOR, "css");
		this.page.element(Locators.EVENT_COLOR, "css").webElementToSelect().selectByVisibleText(color);
		return this;
	}

	public EventSetUp editTemplate(String templateName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT_PART1+templateName+Locators.CLOSINGBRACKET+Locators.EDIT_LINK, "xpath");
		this.page.element(Locators.TABLECELLWITHTEXT_PART1+templateName+Locators.CLOSINGBRACKET+Locators.EDIT_LINK, "xpath").mouseOver();
		this.page.element(Locators.TABLECELLWITHTEXT_PART1+templateName+Locators.CLOSINGBRACKET+Locators.EDIT_LINK, "xpath").getOne().click();
		try{
			if(!this.page.element(Locators.TEMPLATENAME, "name").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
				this.page.element(Locators.TABLECELLWITHTEXT_PART1+templateName+Locators.CLOSINGBRACKET+Locators.EDIT_LINK, "xpath").clickUsingJSE();
				waitForElement.waitForElements(Locators.TEMPLATENAME, "name");
			}
		} catch (Exception e) {		}
		assertTrue(this.page.element(Locators.TEMPLATENAME, "name").isElementPresent(), "edit event template screen is not displayed.");
		return this;
	}

	public EventSetUp addStatusTypesToExistingEventTemplate(String eventTemplate,ArrayList<String> statusTypeValue) throws Exception {			
		this.editTemplate(eventTemplate);
		Iterator<String> itr =statusTypeValue.iterator();
		while(itr.hasNext())
		{
			this.selectStatusType(itr.next());
		}
		this.clickOnSave();
		return this;
	}

	public EventSetUp selectAndDeSelectAllPager() throws Exception {
		waitForElement.waitForElements(Locators.PAGERSELECTALL, "xpath");
		if (this.page.element(Locators.PAGERSELECTALL, "xpath").getOne().isSelected()==false) {
			this.page.element(Locators.PAGERSELECTALL, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.PAGERSELECTALL, "xpath").getOne().isSelected()==false) {
			this.page.element(Locators.PAGERSELECTALL, "xpath").getOne().click();
		}
		assertTrue(this.page.element(Locators.PAGERSELECTALL, "xpath").getOne().isSelected(), "Web notification master check box is selected.");
		if (this.page.element(Locators.PAGERSELECTALL, "xpath").getOne().isSelected()) {
			this.page.element(Locators.PAGERSELECTALL, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.PAGERSELECTALL, "xpath").getOne().isSelected()) {
			this.page.element(Locators.PAGERSELECTALL, "xpath").getOne().click();
		}
		assertFalse(this.page.element(Locators.PAGERSELECTALL, "xpath").getOne().isSelected(), "Web notification master check box is not deselected.");
		return this;
	}

	public EventSetUp selectAndDeSelectAllEmail() throws Exception {
		waitForElement.waitForElements(Locators.EMAILSELECTALL, "xpath");
		if (this.page.element(Locators.EMAILSELECTALL, "xpath").getOne().isSelected()==false) {
			this.page.element(Locators.EMAILSELECTALL, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.EMAILSELECTALL, "xpath").getOne().isSelected()==false) {
			this.page.element(Locators.EMAILSELECTALL, "xpath").getOne().click();
		}
		assertTrue(this.page.element(Locators.EMAILSELECTALL, "xpath").getOne().isSelected(), "Web notification master check box is selected.");
		if (this.page.element(Locators.EMAILSELECTALL, "xpath").getOne().isSelected()) {
			this.page.element(Locators.EMAILSELECTALL, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.EMAILSELECTALL, "xpath").getOne().isSelected()) {
			this.page.element(Locators.EMAILSELECTALL, "xpath").getOne().click();
		}
		assertFalse(this.page.element(Locators.EMAILSELECTALL, "xpath").getOne().isSelected(), "Web notification master check box is not deselected.");
		return this;
	}

	public EventSetUp clickNotificationsAndSelectAllNotifications(String userName, String eventTemplateName) throws Exception {
		this.clickOnNotificationsLink(eventTemplateName);
		this.selectAndDeselectAllWebOption(userName);
		this.selectAndDeSelectAllPager();
		this.selectAndDeSelectAllEmail();
		this.selectEmailNotification(userName);
		this.selectPagerNotification(userName);
		this.clickOnSave();
		this.verifyEventTemplateListPage();
		return this;
	}

	public EventSetUp selectAndDeselectAllWebOption(String userName) throws Exception {
		this.deselectSelectAllWebOption();  
		this.selectWebNotification(userName);
		return this;
	}

	public EventSetUp createEventTemplateDeselectingWebOption(String eventTemplate, String templateDefinition, String resourceTypeValue,ArrayList<String> statusTypeValue) throws Exception {			
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(eventTemplate);
		this.enterEventTemplateDefintion(templateDefinition);
		this.selectResourceType(resourceTypeValue);
		Iterator<String> iterator = statusTypeValue.iterator();
		while(iterator.hasNext())
		{
			this.selectStatusType(iterator.next());
		}
		this.clickOnSave();
		this.deselectSelectAllWebOption();
		this.clickOnSave();
		return this;
	}

	public EventSetUp selectAndDeSelectAllWebOption() throws Exception {
		waitForElement.waitForElements(Locators.WEBMAILSELECTALL, "xpath");
		if (this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().isSelected()==false) {
			this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().isSelected()==false) {
			this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().click();
		}
		assertTrue(this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().isSelected(), "Web notification master check box is selected.");
		if (this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().isSelected()) {
			this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().isSelected()) {
			this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().click();
		}
		assertFalse(this.page.element(Locators.WEBMAILSELECTALL, "xpath").getOne().isSelected(), "Web notification master check box is not deselected.");
		return this;
	}

	public EventSetUp selectAndDeSelectAllMyResourceOption() throws Exception {
		waitForElement.waitForElements(Locators.MY_RESOURCE_SELECT_ALL, "xpath");
		if (this.page.element(Locators.MY_RESOURCE_SELECT_ALL, "xpath").getOne().isSelected()==false) {
			this.page.element(Locators.MY_RESOURCE_SELECT_ALL, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.MY_RESOURCE_SELECT_ALL, "xpath").getOne().isSelected()==false) {
			this.page.element(Locators.MY_RESOURCE_SELECT_ALL, "xpath").getOne().click();
		}
		assertTrue(this.page.element(Locators.MY_RESOURCE_SELECT_ALL, "xpath").getOne().isSelected(), "Web notification master check box is selected.");
		if (this.page.element(Locators.MY_RESOURCE_SELECT_ALL, "xpath").getOne().isSelected()) {
			this.page.element(Locators.MY_RESOURCE_SELECT_ALL, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.MY_RESOURCE_SELECT_ALL, "xpath").getOne().isSelected()) {
			this.page.element(Locators.MY_RESOURCE_SELECT_ALL, "xpath").getOne().click();
		}
		assertFalse(this.page.element(Locators.MY_RESOURCE_SELECT_ALL, "xpath").getOne().isSelected(), "Web notification master check box is not deselected.");
		return this;
	}

	public EventSetUp clickOnNotificationsAndDeSelectAllNotifications(String eventTemplateName) throws Exception {
		this.clickOnNotificationsLink(eventTemplateName);
		this.selectAndDeSelectAllEmail();
		this.selectAndDeSelectAllPager();
		this.selectAndDeSelectAllWebOption();
		this.selectAndDeSelectAllMyResourceOption();
		this.clickOnSave();
		this.verifyEventTemplateListPage();
		return this;
	}

	public EventSetUp createEventTemplateWithAddress(String eventTemplateName, String eventTemplateDefinition, String iconName, String color, String resourceTypeValue, ArrayList<String> statusTypeValue, String userName) throws Exception {
		this.verifyEventTemplateListPage(); 
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(eventTemplateName);
		this.enterEventTemplateDefintion(eventTemplateDefinition);
		this.selectEventIcon(iconName);
		this.selectEventColor(color);
		this.selectMandatoryAddress();
		this.selectResourceType(resourceTypeValue);
		for(int i = 0; i < statusTypeValue.size(); i++) {
			this.selectStatusType(statusTypeValue.get(i));
		}
		this.clickOnSave();
		this.selectNotificationsForUserAndSave(userName);
		return this;
	}

	public EventSetUp verifyEventTemplateIsDisplayed(String eventName)
			throws Exception {
		waitForElement.waitForElements(Locators.EVENT_SETUP_TABLE
				+ Locators.TABLECELL + eventName + Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page.element(Locators.EVENT_SETUP_TABLE
				+ Locators.TABLECELL + eventName + Locators.CLOSINGBRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_SETUP_TABLE
				+ Locators.TABLECELL + eventName + Locators.CLOSINGBRACKET, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	public EventSetUp verifyEventTemplateOnEventTemplateList(String eventTemplateName) throws Exception {
		this.verifyEventTemplateListPage(); 
		this.verifyEventTemplateIsDisplayed(eventTemplateName);
		return this;
	}
	
	public EventSetUp createEventTemplate(String eventTemplate, String templateDefinition, String resourceTypeValue,ArrayList<String> statusTypeValue) throws Exception {			
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(eventTemplate);
		this.enterEventTemplateDefintion(templateDefinition);
		this.selectResourceType(resourceTypeValue);
		while(statusTypeValue.iterator().hasNext())
		{
		this.selectStatusType(statusTypeValue.iterator().next());
		}
		this.clickOnSave();
		return this;
	}
	
	public EventSetUp createMultiRegionEventTemplateSelectingWebOption(String eventTemplateName, String eventTemplateDefinition, String iconName, String color, String resourceTypeValue, ArrayList<String> statusTypeValues, String userName) throws Exception {			
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(eventTemplateName);
		this.enterEventTemplateDefintion(eventTemplateDefinition);
		this.selectEventIcon(iconName);
		this.selectEventColor(color);
		this.selectMultiRegion();
		this.selectResourceType(resourceTypeValue);
		Iterator<String> itr =statusTypeValues.iterator();
		while(itr.hasNext())
		{
			this.selectStatusType(itr.next());
		}
		this.clickOnSave();
		this.selectNotificationsForUserAndSave(userName);
		return this;
	}
	
	public EventSetUp selectMyResourceNotification(String userName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.MY_RESOURCE_NOTIFICATION_INPUT,
				"xpath");
		if (this.page
				.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.MY_RESOURCE_NOTIFICATION_INPUT,
						"xpath").getOne().isSelected() == false) {
			this.page
			.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.MY_RESOURCE_NOTIFICATION_INPUT,
					"xpath").getOne().click();
			assertTrue(this.page.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.MY_RESOURCE_NOTIFICATION_INPUT,
					"xpath").getOne().isSelected());	
		}
		return this;
	}
	
	public EventSetUp clickNotificationsSelectAllNotifications(String userName, String eventTemplateName) throws Exception {
		this.clickOnNotificationsLink(eventTemplateName);
		this.selectAndDeSelectAllEmail();
		this.selectAndDeSelectAllPager();
		this.selectAndDeselectAllWebOption(userName);
		this.selectAndDeSelectAllMyResourceOption();
		this.selectEmailNotification(userName);
		this.selectPagerNotification(userName);
		this.selectWebNotification(userName);
		this.selectMyResourceNotification(userName);
		this.clickOnSave();
		this.verifyEventTemplateListPage();
		return this;
	}

	public EventSetUp createEventTemplateSelectingWebOption(String eventTemplate, String eventTemplateDefinition, String resourceTypeValue, ArrayList<String> statusTypeValue, String userName) throws Exception {			
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(eventTemplate);
		this.enterEventTemplateDefintion(eventTemplateDefinition);
		this.selectResourceType(resourceTypeValue);
		Iterator<String> itr =statusTypeValue.iterator();
		while(itr.hasNext())
		{
			this.selectStatusType(itr.next());
		}
		this.clickOnSave();
		this.selectNotificationsForUserAndSave(userName);
		return this;
	}
	
	public EventSetUp editEventTemplateSelectMandatoryAddress(String eventTemplateName) throws Exception {
		this.verifyEventTemplateListPage();
        this.editTemplate(eventTemplateName);
        this.selectMandatoryAddress();
        this.clickOnSave();
        this.verifyEventTemplateOnEventTemplateList(eventTemplateName);
		return this;
	}
	
	public EventSetUp deSelectMandatoryAddress() throws Exception {
		waitForElement.waitForElements(Locators.ADDRESS_REQUIRED, "css");
		if (this.page.element(Locators.ADDRESS_REQUIRED, "css").getOne().isSelected()) {
			this.page.element(Locators.ADDRESS_REQUIRED, "css").Click();
		}
		if (this.page.element(Locators.ADDRESS_REQUIRED, "css").getOne().isSelected()) {
			this.page.element(Locators.ADDRESS_REQUIRED, "css").getDisplayedOne().click();
			assertFalse(this.page.element(Locators.ADDRESS_REQUIRED, "css").getOne().isSelected(), "Address Required check box is not deselected.");
		}
		assertFalse(this.page.element(Locators.ADDRESS_REQUIRED, "css").getOne().isSelected(), "Address Required check box is not deselected.");
		return this;
	}
	
	public EventSetUp editEventTemplateDeselectMandatoryAddress(String eventTemplateName) throws Exception {
		this.verifyEventTemplateListPage();
        this.editTemplate(eventTemplateName);
        this.deSelectMandatoryAddress();
        this.clickOnSave();
        this.verifyEventTemplateOnEventTemplateList(eventTemplateName);
		return this;
	}
	
	public EventSetUp verifyCreateNewEventTemplate() throws Exception {
		waitForElement.waitForElements(Locators.CRETAE_NEW_EVENT_TEMPLATE_PAGE, "xpath");
		assertTrue(this.page.element(Locators.CRETAE_NEW_EVENT_TEMPLATE_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CRETAE_NEW_EVENT_TEMPLATE_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventSetUp verifyResourceTypeUnderResourceTypesSection(String resourceTypeValue) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCE_TYPES_SECTION + resourceTypeValue + Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_TYPES_SECTION + resourceTypeValue + Locators.CLOSINGBRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.RESOURCE_TYPES_SECTION + resourceTypeValue + Locators.CLOSINGBRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventSetUp verifyStatusTypeUnderStatusTypesSection(String statusTypeValues) throws Exception {
		waitForElement.waitForElements(Locators.STATUS_TYPES_SECTION + statusTypeValues + Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page.element(Locators.STATUS_TYPES_SECTION + statusTypeValues + Locators.CLOSINGBRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.STATUS_TYPES_SECTION + statusTypeValues + Locators.CLOSINGBRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventSetUp verifyEventNotificationPreferencesForEventTemplateScreen(String eventTemplateName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_NOTIFICATION_PREFERENCES_FOR_EVENT_TEMPLATE + eventTemplateName + Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page.element(Locators.EVENT_NOTIFICATION_PREFERENCES_FOR_EVENT_TEMPLATE + eventTemplateName + Locators.CLOSINGBRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_NOTIFICATION_PREFERENCES_FOR_EVENT_TEMPLATE + eventTemplateName + Locators.CLOSINGBRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventSetUp createNewEventTemplate(String eventTemplateName, String eventTemplateDefinition, String iconName, String color, String resourceTypeValue, ArrayList<String> statusTypeValue, String userName) throws Exception {
		this.verifyEventTemplateListPage(); 
		this.clickOncreateEventTemplate();
		this.verifyCreateNewEventTemplate();
		this.enterEventTemplateName(eventTemplateName);
		this.enterEventTemplateDefintion(eventTemplateDefinition);
		this.selectEventIcon(iconName);
		this.selectEventColor(color);
		this.verifyResourceTypeUnderResourceTypesSection(resourceTypeValue);
		this.selectResourceType(resourceTypeValue);
        for(int i = 0; i < statusTypeValue.size(); i++) {
        	this.verifyStatusTypeUnderStatusTypesSection(statusTypeValue.get(i));
            this.selectStatusType(statusTypeValue.get(i));
         }
        this.clickOnSave();
        this.verifyEventNotificationPreferencesForEventTemplateScreen(eventTemplateName);
        this.verifyAllNotificationMethodsOnEventNotificationPreferences(userName);
        this.selectNotificationsForUserAndSave(userName);
        this.verifyEventTemplateOnEventTemplateList(eventTemplateName);
		return this;
	}
	
	public EventSetUp editTemplateSelectStatusTypes(String eventTemplateName, String editeventTemplateName, String editeventTemplateDefinition, String iconName, String color, ArrayList<String> statusTypeValue) throws Exception {
		this.verifyEventTemplateListPage(); 
		this.editTemplate(eventTemplateName);
		this.enterEventTemplateName(editeventTemplateName);
		this.enterEventTemplateDefintion(editeventTemplateDefinition);
		this.selectEventIcon(iconName);
		this.selectEventColor(color);
		for(int i = 0; i < statusTypeValue.size(); i++) {
			this.selectStatusType(statusTypeValue.get(i));
        }
        this.clickOnSave();
        this.verifyEventTemplateOnEventTemplateList(editeventTemplateName);
		return this;
	}
	
	public EventSetUp verifyEmailNotification(String userName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.EMAILNOTIFICATIONINPUT,
				"xpath");
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.EMAILNOTIFICATIONINPUT,
						"xpath").isElementPresent());
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.EMAILNOTIFICATIONINPUT,
					"xpath").getDisplayedOne().isDisplayed());
		
		return this;
	}
	
	public EventSetUp verifyWebNotification(String userName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.WEBNOTIFICATIONINPUT,
				"xpath");
		assertTrue(this.page
				.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.WEBNOTIFICATIONINPUT,
						"xpath").isElementPresent());
		assertTrue(this.page
			.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.WEBNOTIFICATIONINPUT,
					"xpath").getOne().isDisplayed());
		
		return this;
	}

	public EventSetUp verifyPagerNotification(String userName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT_PART1 + userName+ Locators.CLOSINGBRACKET +Locators.PAGERNOTIFICATIONINPUT,
				"xpath");
		assertTrue(this.page
				.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET + Locators.PAGERNOTIFICATIONINPUT,
						"xpath").isElementPresent());
		assertTrue(this.page
			.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.PAGERNOTIFICATIONINPUT,
					"xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventSetUp verifyMyResourceNotification(String userName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.MY_RESOURCE_NOTIFICATION_INPUT,
				"xpath");
		assertTrue(this.page
				.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.MY_RESOURCE_NOTIFICATION_INPUT,
						"xpath").isElementPresent());
		assertTrue(this.page
			.element(Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET +Locators.MY_RESOURCE_NOTIFICATION_INPUT,
					"xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventSetUp verifyAllNotificationMethodsOnEventNotificationPreferences(String userName) throws Exception {
		this.verifyEmailNotification(userName);
		this.verifyPagerNotification(userName);
		this.verifyWebNotification(userName);
		this.verifyMyResourceNotification(userName);
		return this;
	}
	
	public EventSetUp selectSecurity() throws Exception {
		waitForElement.waitForElements(Locators.SECURITY, "css");
		this.page.element(Locators.SECURITY, "css").clickUsingJSE();
		assertTrue(this.page.element(Locators.SECURITY, "css").getOne().isSelected());
		return this;
	}
	
	public EventSetUp createEventTemplateWithSecurity(String eventTemplateName, String eventTemplateDefinition, String resourceTypeValue, String statusTypeValue) throws Exception {
		this.verifyEventTemplateListPage();
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(eventTemplateName);
		this.enterEventTemplateDefintion(eventTemplateDefinition);
		this.selectSecurity();
		this.selectResourceType(resourceTypeValue);
		this.selectStatusType(statusTypeValue);
		this.clickOnSave();
		this.deselectSelectAllWebOption();
		this.clickOnSave();
		return this;
	}
	
	public EventSetUp clickOnSecurity(String eventTemplateName) throws Exception {
		String security = Locators.TABLECELLWITHTEXT_PART1 + eventTemplateName + Locators.CLOSINGBRACKET + Locators.TABLECELLWITHTEXT_PART2 + EventSetUpData.SECURITY + Locators.CLOSINGBRACKET;
		waitForElement.waitForElementByxpathSelector(security);
		this.page.element(security, "xpath").clickUsingJSE();
		return this;
	}
	
	public EventSetUp verifyUsersOnEventSecurityForEventTemplateScreen(String userName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_SECURITY_TABLE + Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page.element(Locators.EVENT_SECURITY_TABLE + Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_SECURITY_TABLE + Locators.TABLECELLWITHTEXT_PART1 + userName + Locators.CLOSINGBRACKET, "xpath").getDisplayedOne().isDisplayed());
		return this;
	}
	
	public EventSetUp navigateToEventSecurityForEventTemplateScreen(String eventTemplateName, ArrayList<String> userName) throws Exception {
		this.clickOnSecurity(eventTemplateName);
		for(int i = 0; i < userName.size(); i++) {
			this.verifyUsersOnEventSecurityForEventTemplateScreen(userName.get(i));
        }
		return this;
	}
	
	public EventSetUp selectUserOnEventSecurityForEventTemplateScreen(String userName) throws Exception {
		waitForElement.waitForElements(Locators.SELECT_USER+ userName + Locators.CLOSINGBRACKET, "css");
		this.page.element(Locators.SELECT_USER+ userName + Locators.CLOSINGBRACKET, "css").getDisplayedOne().click();
		return this;
	}
	
	public EventSetUp editTemplate(String templateName,String editEventTemplateName, String editEventTemplateDefinition, String iconName,String color) throws Exception {
		this.editTemplate(templateName);
		this.enterEventTemplateName(editEventTemplateName);
		this.enterEventTemplateDefintion(editEventTemplateDefinition);
		this.selectEventIcon(iconName);
		this.selectEventColor(color);
		this.clickOnSave();
		return this;
	}
	
	public EventSetUp verifyEventTemplateDescription(String eventTemplateDescription)
			throws Exception {
		waitForElement.waitForElements(Locators.EVENT_SETUP_TABLE + Locators.TABLECELL + eventTemplateDescription + Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page.element(Locators.EVENT_SETUP_TABLE + Locators.TABLECELL + eventTemplateDescription + Locators.CLOSINGBRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_SETUP_TABLE + Locators.TABLECELL + eventTemplateDescription + Locators.CLOSINGBRACKET, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	public EventSetUp verifyEventTemplateIcon(String eventTemplateName, String eventTemplateIcon)
			throws Exception {
		waitForElement.waitForElements(Locators.EVENT_SETUP_TABLE + Locators.TABLECELL + eventTemplateName + Locators.CLOSINGBRACKET + Locators.EVENT_TEMPLATE_ICON + eventTemplateIcon + Locators.CLOSING_BRACKET_WITH_QUOTE, "xpath");
		assertTrue(this.page.element(Locators.EVENT_SETUP_TABLE + Locators.TABLECELL + eventTemplateName + Locators.CLOSINGBRACKET + Locators.EVENT_TEMPLATE_ICON + eventTemplateIcon + Locators.CLOSING_BRACKET_WITH_QUOTE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_SETUP_TABLE + Locators.TABLECELL + eventTemplateName + Locators.CLOSINGBRACKET + Locators.EVENT_TEMPLATE_ICON + eventTemplateIcon + Locators.CLOSING_BRACKET_WITH_QUOTE, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	public EventSetUp verifyColourOnEventBanner(String colour, String eventName) throws Exception {
		waitForElement.waitForElements(Locators.COLOUR_ON_EVENT_BANNER + colour + Locators.CLOSING_BRACKET_WITH_QUOTE + Locators.TABLE_CELL_WITH_TEXT + eventName + Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page.element(Locators.COLOUR_ON_EVENT_BANNER + colour + Locators.CLOSING_BRACKET_WITH_QUOTE + Locators.TABLE_CELL_WITH_TEXT + eventName + Locators.CLOSINGBRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.COLOUR_ON_EVENT_BANNER + colour + Locators.CLOSING_BRACKET_WITH_QUOTE + Locators.TABLE_CELL_WITH_TEXT + eventName + Locators.CLOSINGBRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventSetUp verifyEventTemplateNameDescriptionIconOnEventTemplateList(String eventTemplateName, String eventTemplateDefinition, String eventTemplateIcon, String colour, String eventName) throws Exception {
		this.verifyEventTemplateIsDisplayed(eventTemplateName);
		this.verifyEventTemplateDescription(eventTemplateDefinition);
		this.verifyEventTemplateIcon(eventTemplateName, eventTemplateIcon);
		this.verifyColourOnEventBanner(colour, eventName);
		return this;
	}
	
	public EventSetUp deSelectResourceType(String resourceTypeValue) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPEINPUT+ resourceTypeValue + Locators.CLOSINGBRACKET, "css");
		if (this.page.element(Locators.RESOURCETYPEINPUT+ resourceTypeValue + Locators.CLOSINGBRACKET, "css").getOne().isSelected()) {
			this.page.element(Locators.RESOURCETYPEINPUT+ resourceTypeValue + Locators.CLOSINGBRACKET, "css").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.RESOURCETYPEINPUT+ resourceTypeValue + Locators.CLOSINGBRACKET, "css").getOne().isSelected()) {
			this.page.element(Locators.RESOURCETYPEINPUT+ resourceTypeValue + Locators.CLOSINGBRACKET, "css").clickUsingJSE();
		}
		assertFalse(this.page.element(Locators.RESOURCETYPEINPUT+ resourceTypeValue + Locators.CLOSINGBRACKET, "css").getOne().isSelected(), "Resource Type is not deselected.");
		return this;
	}
	
	public EventSetUp editTemplateDeselectAndSelectOtherResourceType(String eventTemplateName, String editEventTemplateName,String editEventTemplateDefinition, String resourceTypeValue2, String resourceTypeValue1) throws Exception {
		this.editTemplate(eventTemplateName);
		this.enterEventTemplateName(editEventTemplateName);
		this.enterEventTemplateDefintion(editEventTemplateDefinition);
		this.deSelectResourceType(resourceTypeValue2);
		this.selectResourceType(resourceTypeValue1);
		this.clickOnSave();
		return this;
	}
	
	public EventSetUp verifyStatusTypes(String statusTypeValue) throws Exception {
		waitForElement.waitForElements(Locators.STATUSTYPEINPUT+ statusTypeValue + Locators.CLOSINGBRACKET, "css");
		this.page.element(Locators.STATUSTYPEINPUT+ statusTypeValue + Locators.CLOSINGBRACKET, "css").mouseOver();
		assertTrue(this.page.element(Locators.STATUSTYPEINPUT+ statusTypeValue + Locators.CLOSINGBRACKET, "css").isElementPresent());
		assertTrue(this.page.element(Locators.STATUSTYPEINPUT+ statusTypeValue + Locators.CLOSINGBRACKET, "css").getDisplayedOne().isDisplayed());
		return this;
	}

	public EventSetUp verifyStatusTypesInCreateEventTemplatePage(ArrayList<String> statusTypeValue) throws Exception {
		Iterator<String> ST_Values = statusTypeValue.iterator();
		this.clickOncreateEventTemplate();
		while(ST_Values.hasNext())
		{
			this.verifyStatusTypes(ST_Values.next());
		}
		return this;
	}
	
	public EventSetUp deselectActiveOfEventTemplate() throws Exception {
		waitForElement.waitForElements(Locators.ACTIVE_EVENT_TEMPLATE, "css");
		if (this.page.element(Locators.ACTIVE_EVENT_TEMPLATE, "css").getOne().isSelected()) {
			this.page.element(Locators.ACTIVE_EVENT_TEMPLATE, "css").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.ACTIVE_EVENT_TEMPLATE, "css").getOne().isSelected()) {
			this.page.element(Locators.ACTIVE_EVENT_TEMPLATE, "css").getDisplayedOne().click();
		}
		assertFalse(this.page.element(Locators.ACTIVE_EVENT_TEMPLATE, "css").getOne().isSelected(), "Event Template Active check box is not deselected.");
		return this;
	}
	
	public EventSetUp deActivateEventTemplate(String eventTemplateName) throws Exception {
		this.editTemplate(eventTemplateName);
		this.deselectActiveOfEventTemplate();
        this.clickOnSave();
		return this;
	}
	
	public EventSetUp verifyEventTemplateNotDisplayed(String eventTemplateName)
			throws Exception {
		waitForElement.waitForElements(Locators.EVENT_TEMPLATE_LIST_PAGE, "xpath");
		assertFalse(this.page.element(Locators.EVENT_SETUP_TABLE
				+ Locators.TABLECELL + eventTemplateName + Locators.CLOSINGBRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), eventTemplateName + "eventTemplate is displayed");
		return this;
	}
	
	public EventSetUp verifyEventTemplateNotOnEventTemplateList(String eventTemplateName) throws Exception {
		this.verifyEventTemplateListPage(); 
		this.verifyEventTemplateNotDisplayed(eventTemplateName);
		return this;
	}
	
	public EventSetUp selectIncludeInactiveEventTypes() throws Exception {
		waitForElement.waitForElements(Locators.INACTIVE_EVENT_TYPES, "name");
		if (this.page.element(Locators.INACTIVE_EVENT_TYPES, "name").getOne().isSelected()==false) {
			this.page.element(Locators.INACTIVE_EVENT_TYPES, "name").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.INACTIVE_EVENT_TYPES, "name").getOne().isSelected()==false) {
			this.page.element(Locators.INACTIVE_EVENT_TYPES, "name").getDisplayedOne().click();
		}
		assertTrue(this.page.element(Locators.INACTIVE_EVENT_TYPES, "name").getOne().isSelected(), "Inactive Event Types checkbox is not selected");
		return this;
	}
	
	public EventSetUp verifyEventTemplateStatus(String eventTemplateName, String Status) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT_PART1 + eventTemplateName + Locators.CLOSINGBRACKET + Locators.TABLE_CELL_WITH_TEXT_PART1 + Status + Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT_PART1 + eventTemplateName + Locators.CLOSINGBRACKET + Locators.TABLE_CELL_WITH_TEXT_PART1 + Status + Locators.CLOSINGBRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT_PART1 + eventTemplateName + Locators.CLOSINGBRACKET + Locators.TABLE_CELL_WITH_TEXT_PART1 + Status + Locators.CLOSINGBRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventSetUp selectActiveOfEventTemplate() throws Exception {
		waitForElement.waitForElements(Locators.ACTIVE_EVENT_TEMPLATE, "css");
		if (this.page.element(Locators.ACTIVE_EVENT_TEMPLATE, "css").getOne().isSelected()==false) {
			this.page.element(Locators.ACTIVE_EVENT_TEMPLATE, "css").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.ACTIVE_EVENT_TEMPLATE, "css").getOne().isSelected()==false) {
			this.page.element(Locators.ACTIVE_EVENT_TEMPLATE, "css").getDisplayedOne().click();
		}
		assertTrue(this.page.element(Locators.ACTIVE_EVENT_TEMPLATE, "css").getOne().isSelected(), "Event Template Active check box is not selected.");
		return this;
	}
	
	public EventSetUp activateEventTemplate(String eventTemplateName) throws Exception {
		this.editTemplate(eventTemplateName);
		this.selectActiveOfEventTemplate();
        this.clickOnSave();
		return this;
	}
	
	public EventSetUp verifySelectIncludeInactiveEventTypesRemainsSelected() throws Exception {
		waitForElement.waitForElements(Locators.INACTIVE_EVENT_TYPES, "name");
		assertTrue(this.page.element(Locators.INACTIVE_EVENT_TYPES, "name").getOne().isSelected(), "Inactive Event Types checkbox is not selected");
		return this;
	}
	
	public EventSetUp editEventTemplateMandatoryDetails(String eventTemplateName, String edit_name, String edit_definition) throws Exception {
		this.verifyEventTemplateListPage();
        this.editTemplate(eventTemplateName);
        this.enterEventTemplateName(edit_name);
        this.enterEventTemplateDefintion(edit_definition);
        this.clickOnSave();
        this.verifyEventTemplateOnEventTemplateList(edit_name);
		return this;
	}
}