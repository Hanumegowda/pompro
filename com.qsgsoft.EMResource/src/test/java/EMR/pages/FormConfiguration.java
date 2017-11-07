package EMR.pages;

import static org.testng.Assert.*;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import EMR.pages.Shared;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.FormConfiguration.Locators;

public class FormConfiguration extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement;
	Shared shared;
	Date_Time_settings dts;
    
	public FormConfiguration(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		shared = new Shared(this.driver);
		dts = new Date_Time_settings();
	}

	public FormConfiguration verFormConfigurePage() throws Exception {
		waitForElement.waitForElements(Locators.CREATENEWFORMTEMPLETE, "css");
		assertTrue(this.page.element(Locators.CREATENEWFORMTEMPLETE, "css").isElementPresent());
		assertEquals("Form Configuration", this.page.element(Locators.HEADER, "css").getOne().getText());
		return this;
	}

	public FormConfiguration clickOnCreateNewFormTemplate() throws Exception {
		waitForElement.waitForElements(Locators.CREATENEWFORMTEMPLETE, "css");
		this.page.element(Locators.CREATENEWFORMTEMPLETE, "css").getOne().click();
		return this;
	}

	public FormConfiguration enterTitle(String titleName) throws Exception {
		waitForElement.waitForElements(Locators.TITLE, "css");
		this.page.element(Locators.TITLE, "css").clearInputValue().sendKeys(titleName);
		return this;
	}

	public FormConfiguration enterDescription(String description) throws Exception {
		waitForElement.waitForElements(Locators.DESCRIPTION, "css");
		this.page.element(Locators.DESCRIPTION, "css").clearInputValue().sendKeys(description);
		return this;
	}

	public FormConfiguration selectFormActivationMethod(String activationMethod) throws Exception {
		waitForElement.waitForElements(Locators.ACTIVATION, "css");
		this.page.element(Locators.ACTIVATION, "css").webElementToSelect().selectByVisibleText(activationMethod);
		assertEquals(
				this.page.element(Locators.ACTIVATION, "css").webElementToSelect().getFirstSelectedOption().getText(),
				activationMethod);
		return this;
	}

	public FormConfiguration selectCompletedFormDelivery(String completedFormDelivery) throws Exception {
		waitForElement.waitForElements(Locators.FORMDELIVERY, "css");
		this.page.element(Locators.FORMDELIVERY, "css").webElementToSelect().selectByVisibleText(completedFormDelivery);
		assertEquals(
				this.page.element(Locators.FORMDELIVERY, "css").webElementToSelect().getFirstSelectedOption().getText(),
				completedFormDelivery);
		return this;
	}

	public FormConfiguration clickOnNext() throws Exception {
		waitForElement.waitForElements(Locators.NEXTBUTTON, "css");
		this.page.element(Locators.NEXTBUTTON, "css").getOne().click();
		return this;
	}

	public FormConfiguration selectUserInUsersToFillOutForm(String user) throws Exception {
		String userToFillOut = Locators.USERTOFILLOUTPART1 + user + Locators.USERTOFILLOUTPART2;
		waitForElement.waitForElements(userToFillOut, "xpath");
		assertTrue(this.page.element(userToFillOut, "xpath").isElementPresent());
		this.page.element(userToFillOut, "xpath").mouseOver();
		try{
			this.page.element(userToFillOut, "xpath").getOne().sendKeys(Keys.SPACE);
			if(this.page.element(userToFillOut, "xpath").getOne().isSelected()==false){
				this.page.element(userToFillOut, "xpath").getOne().click();
				System.out.println("click");
			}
			if(this.page.element(userToFillOut, "xpath").getOne().isSelected()==false){
				this.page.element(userToFillOut, "xpath").Click();
				System.out.println("mouseOverAndClick");
			}
			if(this.page.element(userToFillOut, "xpath").getOne().isSelected()==false){
				this.page.element(userToFillOut, "xpath").getOne().sendKeys(Keys.ENTER);
				System.out.println("Keys.Enter");
			}
			assertTrue(this.page.element(userToFillOut, "xpath").getOne().isSelected());
		}catch(Exception e){
			this.page.element(userToFillOut, "xpath").Click();
			assertTrue(this.page.element(userToFillOut, "xpath").getOne().isSelected());
		}
		return this;
	}

	public FormConfiguration selectUserToActivateForm(String user) throws Exception {
		String userToActivate = Locators.USERTOACTIVATEPART1 + user + Locators.USERTOACTIVATEPART2;
		waitForElement.waitForElements(userToActivate, "xpath");
		this.page.element(userToActivate, "xpath").getOne().click();
		assertTrue(this.page.element(userToActivate, "xpath").getOne().isSelected());
		return this;
	}

	public FormConfiguration clickOnSaveOfFormSecuritySetting() throws Exception {
		Actions action = new Actions(driver);
		waitForElement.waitForElementBycssSelector(Locators.SAVE);
		action.moveToElement(this.page.element(Locators.SAVE, "css").getOne()).perform();
		this.page.element(Locators.SAVE, "css").getOne().click();
		return this;
	}

	public FormConfiguration acknowledgeForm(String form) throws Exception {
		waitForElement.waitForElementByxpathSelector(Locators.TABLECELLWITHTEXT + form + Locators.QUESTIONNAIRELINK);
		this.page.element(Locators.TABLECELLWITHTEXT + form + Locators.QUESTIONNAIRELINK, "xpath").getOne()
				.sendKeys(Keys.ENTER);
		return this;
	}

	public FormConfiguration enterTitleAndDescription(String titleName, String description) throws Exception {
		enterTitle(titleName);
		enterDescription(description);
		return this;
	}

	public FormConfiguration createFormWithInitiateAndOtherToFillOutAndIndividualUsers(String activationMethod,
			String completedFormDelivery, String userToFillOut, String userToActivate) throws Exception {
		selectFormActivationMethod(activationMethod);
		selectCompletedFormDelivery(completedFormDelivery);
		this.selectNotifyViaWebEmailAndPager();
		clickOnNext();
		selectUserInUsersToFillOutForm(userToFillOut);
		clickOnNext();
		clickOnNext();
		selectUserToActivateForm(userToActivate);
		clickOnSaveOfFormSecuritySetting();
		return this;
	}

	public String getFormStartDate() throws Exception {
		String strApplicationDate = shared.getApplicationTimeWithCSTCDT();
		String[] strDate = strApplicationDate.split(" ");
		String strCurrentDate = dts.getCurrentDate("dd");
		String strStartDate = "";
		int intDate = Integer.parseInt(strDate[0]);
		int intCurrentDate = Integer.parseInt(strCurrentDate);

		if (intDate == intCurrentDate) {
			strStartDate = dts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate < intCurrentDate) {
				strStartDate = dts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strStartDate = dts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		return strStartDate;
	}

	public FormConfiguration selectResourcesToFillForm(String resource) throws Exception {
		String res = Locators.TABLECELLWITHTEXT + resource + Locators.RESOURCETOFILL;
		waitForElement.waitForElementByxpathSelector(res);
		if (this.page.element(res, "xpath").getOne().isSelected() == false) {
			this.page.element(res, "xpath").getOne().click();
		}
		return this;
	}

	public FormConfiguration createFormWithInitiateAndOtherToFillOutAndUsersToUsersAndResources(String activationMethod,
			String completedFormDelivery, String userToFillOut, String resourceToFillOut, String userToActivate)
			throws Exception {
		selectFormActivationMethod(activationMethod);
		selectCompletedFormDelivery(completedFormDelivery);
		selectNotifyViaWebEmailAndPager();
		clickOnNext();
		selectUserInUsersToFillOutForm(userToFillOut);
		clickOnNext();
		selectResourcesToFillForm(resourceToFillOut);
		clickOnNext();
		selectUserToActivateForm(userToActivate);
		clickOnSaveOfFormSecuritySetting();
		return this;
	}

	public FormConfiguration clickOnQuestionnaire(String formName) throws Exception {
		waitForElement
				.waitForElementByxpathSelector(Locators.TABLECELLWITHTEXT + formName + Locators.QUESTIONNAIRELINK);
		this.page.element(Locators.TABLECELLWITHTEXT + formName + Locators.QUESTIONNAIRELINK, "xpath").getOne().click();
		Thread.sleep(4000);
		return this;
	}

	public FormConfiguration clickOnEditForm(String form) throws Exception {
		String editForm = Locators.TABLECELLWITHTEXT + form + Locators.EDITOFFORM;
		waitForElement.waitForElementByxpathSelector(editForm);
		this.page.element(editForm, "xpath").mouseOver();
		this.page.element(editForm, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}

	public FormConfiguration verifyFormTitle(String form) throws Exception {
		String formTittle = Locators.FORMTITLE + form + Locators.TWOCLOSINGBRACES;
		waitForElement.waitForElements(formTittle, "xpath");
		assertTrue(this.page.element(formTittle, "xpath").isElementPresent(), "Form TITLE is not displayed");
		return this;
	}

	public FormConfiguration verifyEditFormTemplatePage() throws Exception {
		waitForElement.waitForElements(Locators.EDITFORMTEMPLATE, "xpath");
		assertTrue(this.page.element(Locators.EDITFORMTEMPLATE, "xpath").isElementPresent());
		return this;
	}

	public FormConfiguration deSelectAllUsers() throws Exception {
		waitForElement.waitForElements(Locators.ALLUSERSCHECKBOX, "xpath");
		if (this.page.element(Locators.ALLUSERSCHECKBOX, "xpath").getOne().isSelected()) {
			this.page.element(Locators.ALLUSERSCHECKBOX, "xpath").getOne().click();
		}
		assertFalse(this.page.element(Locators.ALLUSERSCHECKBOX, "xpath").getOne().isSelected());
		return this;
	}

	public FormConfiguration editFormTitleDescriptionAndActivation(String form, String editTitle, String editDescption,
			String activationMethod) throws Exception {
		waitForElement.waitForElements(Locators.EDITFORMTEMPLATE, "xpath");
		clickOnEditForm(form);
		verifyEditFormTemplatePage();
		enterTitleAndDescription(editTitle, editDescption);
		selectFormActivationMethod(activationMethod);
		clickOnNext();
		deSelectAllUsers();
		clickOnNext();
		return this;
	}

	public FormConfiguration verifyFormTitleAndDescription(String title, String description) throws Exception {
		String formDetail = Locators.TABLECELLWITHTEXT + title + Locators.FORMTITLEANDDESCRIPTION + description
				+ Locators.CLOSINGBRACKET;
		System.out.println(formDetail);
		waitForElement.waitForElements(formDetail, "xpath");
		assertTrue(this.page.element(formDetail, "xpath").isElementPresent());
		return this;
	}

	public FormConfiguration selectToNotifyViaEmail()
			throws Exception {
		if(this.page.element(Locators.NOTIFYVIAEMAIL, "css").getOne().isSelected()==false){
			this.page.element(Locators.NOTIFYVIAEMAIL, "css").getOne().click();
		}
		assertTrue(this.page.element(Locators.NOTIFYVIAEMAIL, "css").getOne().isSelected());
		return this;
	}
	
	public FormConfiguration selectToNotifyViaPager()
			throws Exception {
		if(this.page.element(Locators.NOTIFYVIAPAGER, "css").getOne().isSelected()==false){
			this.page.element(Locators.NOTIFYVIAPAGER, "css").getOne().click();
		}
		assertTrue(this.page.element(Locators.NOTIFYVIAPAGER, "css").getOne().isSelected());
		return this;
	}
	
	public FormConfiguration selectToNotifyViaWeb()
			throws Exception {
		if(this.page.element(Locators.NOTIFYVIAWEB, "css").getOne().isSelected()==false){
			this.page.element(Locators.NOTIFYVIAWEB, "css").getOne().click();
		}
		assertTrue(this.page.element(Locators.NOTIFYVIAWEB, "css").getOne().isSelected());
		return this;
	}
	
	public FormConfiguration selectNotifyViaWebEmailAndPager()
			throws Exception {
		this.selectToNotifyViaWeb();
		this.selectToNotifyViaEmail();
		this.selectToNotifyViaPager();
		return this;
	}
		
	public FormConfiguration verifyWebNotificationMessageForForms(String Subject,
			String NotificationMsg) throws Exception{
		waitForElement.waitForElementBycssSelector("dt.form");
			
		assertEquals(Subject, this.page.element("dt.form", "css").getOne()
					.getText());
		String messageOnWeb =  this.page.element("dd.desc", "css").getOne()
					.getText();
		System.out.println("msgONweb"+ messageOnWeb);
		System.out.println("FormedNotification"+ NotificationMsg);
		assertTrue(messageOnWeb.contains(NotificationMsg));
		return this;
	}
	
	public FormConfiguration editFormTitleAndDescription(String form, String editTitle, String editDescription) throws Exception {
		waitForElement.waitForElements(Locators.EDITFORMTEMPLATE, "xpath");
		clickOnEditForm(form);
		verifyEditFormTemplatePage();
		enterTitleAndDescription(editTitle, editDescription);		
		clickOnNext();
		clickOnNext();
		clickOnNext();
		this.verifyFormTitleAndDescription(editTitle, editDescription);
		return this;
	}
	
	public FormConfiguration editFormTitleDescriptionActivationAndCompletedFormDelivery(String form, String editTitle, String editDescription,
			String activationMethod,String completedFormDelivery, String user) throws Exception {
		this.clickOnEditForm(form);
		this.verifyEditFormTemplatePage();
		this.enterTitleAndDescription(editTitle, editDescription);
		this.selectFormActivationMethod(activationMethod);
		this.selectCompletedFormDelivery(completedFormDelivery);
		this.clickOnNext();
		this.deSelectAllUsers();
		this.selectUserInUsersToFillOutForm(user);
		this.clickOnNext();
		this.verifyFormTitleAndDescription(editTitle, editDescription);
		return this;
	}
	
	public FormConfiguration verifyResourceNameIsUpdatedInResourcesToFillFormPage(String titleName,String description,String activationMethod,
			String completedFormDelivery,String resourceTypeName,String resourceName) throws Exception {
		clickOnCreateNewFormTemplate();
		enterTitleAndDescription(titleName, description);
		selectFormActivationMethod(activationMethod);
		selectCompletedFormDelivery(completedFormDelivery);
		clickOnNext();
		clickOnNext();
		verifyResourceInResourcesToFillFormPage(resourceTypeName,resourceName);
		clickOnCancel();
		return this;
	}
	
	public FormConfiguration clickOnCancel() throws Exception {
		waitForElement.waitForElements(Locators.CANCELBUTTON, "css");
		this.page.element(Locators.CANCELBUTTON, "css").getOne().click();
		return this;
	}
	
	public FormConfiguration verifyResourceInResourcesToFillFormPage(String resourceTypeName,String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + resourceTypeName + Locators.RESOURCENAME + resourceName + Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + resourceTypeName + Locators.RESOURCENAME + resourceName + Locators.CLOSINGBRACKET, "xpath").isElementPresent(), resourceName + "is not present");
		return this;
	}
	
	public FormConfiguration verifyStatusTypesUnderFormActivationStatusTypeSectionOfCreatingNewFormTemplate(String form, String description,String activationMethod,
			ArrayList<String> statusTypeNames) throws Exception {
		this.clickOnCreateNewFormTemplate();
		this.enterTitleAndDescription(form, description);
		this.selectFormActivationMethod(activationMethod);
		this.clickOnNext();
		this.verifyStatusTypesUnderFormActivationStatusTypeSection(statusTypeNames);
		return this;
	}
	
	public FormConfiguration verifyStatusTypesUnderFormActivationStatusTypeSection(ArrayList<String> statusTypeNames)
			throws Exception {
		for (int intCount = 0; intCount < statusTypeNames.size(); intCount++) {
			String statusTypes = Locators.FORM_ACTVATION_STATUS_TYPES+ statusTypeNames.get(intCount) + Locators.CLOSINGBRACKET;
			waitForElement.waitForElements(statusTypes, "xpath");
			this.page.element(statusTypes, "xpath").mouseOver();	
			assertTrue(this.page.element(statusTypes, "xpath").isElementPresent());
			assertTrue(this.page.element(statusTypes, "xpath").getOne().isDisplayed());
		}
		return this;
	}

	public FormConfiguration createFormWithInitiateAndOtherToFillOutAndUsersToIndividualResources(String titleName,String description,String activationMethod,
			String completedFormDelivery, String resourceToFillOut, String userToActivate)
			throws Exception {		
		clickOnCreateNewFormTemplate();
		enterTitleAndDescription(titleName, description);selectFormActivationMethod(activationMethod);
		selectCompletedFormDelivery(completedFormDelivery);
		clickOnNext();
		clickOnNext();
		selectResourcesToFillForm(resourceToFillOut);
		clickOnNext();
		selectUserToActivateForm(userToActivate);
		clickOnSaveOfFormSecuritySetting();
		return this;
	}
	
	public FormConfiguration navigateToFormSecuritySettingPage()throws Exception{
		waitForElement.waitForElements(Locators.FIRST_SECURITY_LINK_CORRESPONDING_TO_FORM, "xpath");
		this.page.element(Locators.FIRST_SECURITY_LINK_CORRESPONDING_TO_FORM, "xpath").getDisplayedOne().click();
		return this;
	}
	
	public FormConfiguration verifyRoleNotPresentOnFormSecuritySettingPage(ArrayList<String> roleValue) throws Exception{
		waitForElement.waitForElements(Locators.FIRST_SECURITY_LINK_CORRESPONDING_TO_FORM, "xpath");
		assertFalse(this.page.element(Locators.FIRST_SECURITY_LINK_CORRESPONDING_TO_FORM, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), roleValue + "Role is dispalyed");
		return this;
	}
}