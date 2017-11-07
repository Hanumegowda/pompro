package EMR.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.StatusTypes.Locators;

public class StatusTypes extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	WebDriverWait wait;

	public StatusTypes(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement =  new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}

	public StatusTypes clickCreateNewStatusTypeButton() throws Exception {
		waitForElement.waitForElements(Locators.CREATENEWSTATUSTYPEBUTTON, "css");
		this.page.element(Locators.CREATENEWSTATUSTYPEBUTTON, "css").getOne().click();
		if(!this.page.element(Locators.SELECT_STATUS_TYPE_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)){
			this.page.element(Locators.CREATENEWSTATUSTYPEBUTTON, "css").clickUsingJSE();
			waitForElement.waitForElements(Locators.SELECT_STATUS_TYPE_PAGE, "xpath");
		}
		assertTrue(this.page.element(Locators.SELECT_STATUS_TYPE_PAGE, "xpath").isElementPresent(), "Select status type page is not displayed.");
		return this;
	}

	public StatusTypes selectStatusType(String statusType) throws Exception {
		driver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME_SMALL,TimeUnit.SECONDS);
		waitForElement.waitForElements(Locators.SELECTTYPE, "name");
		this.page.element(Locators.SELECTTYPE, "name").webElementToSelect().selectByVisibleText(statusType);
		return this;
	}

	public StatusTypes clickNextButton() throws Exception {
		waitForElement.waitForElements(Locators.NEXTBUTTON, "css");
		this.page.element(Locators.NEXTBUTTON, "css").getOne().click();
		if(!this.page.element(Locators.STATUSTYPENAME, "name").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)){
			this.page.element(Locators.NEXTBUTTON, "css").clickUsingJSE();
		}
		return this;
	}

	public StatusTypes enterStatusTypeName(String _statusTypeName) throws Exception {
		waitForElement.waitForElements(Locators.STATUSTYPENAME, "name");
		this.page.element(Locators.STATUSTYPENAME, "name").clearInputValue().sendKeys(_statusTypeName);
		this.selectSectionName("No Section Assigned");
		return this;
	}


	public StatusTypes enterStatusTypeDescription(String _statusDescription) throws Exception {
		waitForElement.waitForElements(Locators.STATUSDESCRIPTION, "name");
		this.page.element(Locators.STATUSDESCRIPTION, "name").clearInputValue().sendKeys(_statusDescription);
		return this;
	}

	public StatusTypes clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVEBUTTON, "css");
		this.page.element(Locators.SAVEBUTTON, "css").clickUsingJSE();
		return this;
	}

	public String getStatusTypeValue(String statusTypeName) throws Exception {
		waitForElement.waitForElements(Locators.STATUSTYPEVALUEPART1 + statusTypeName + Locators.STATUSTYPEVALUEPART2, "xpath");
		String strStatValue = this.page.element(Locators.STATUSTYPEVALUEPART1 + statusTypeName + Locators.STATUSTYPEVALUEPART2, "xpath").getOne().getAttribute("href");
		String strResValueArr[] = strStatValue.split("nextStepDetail=");
		System.out.println(strResValueArr);
		strStatValue = strResValueArr[1];
		System.out.println(strStatValue);

		return strStatValue;
	}

	public StatusTypes selectSharedStatusTypeRadioBtn() throws Exception {
		waitForElement.waitForElements(Locators.SHAREDSTATUSTYPE, "css");
		if (this.page.element(Locators.SHAREDSTATUSTYPE, "css").getOne().isSelected() == false) {
			this.page.element(Locators.SHAREDSTATUSTYPE, "css").getOne().click();
		}
		return this;
	}

	public StatusTypes selectEventOnlyCheckBox() throws Exception {
		waitForElement.waitForElements(Locators.EVENTSTATUSTYPE, "name");
		this.page.element(Locators.EVENTSTATUSTYPE, "name").getOne().click();
		return this;
	}

	public StatusTypes createSharedStatusType(String statusType,
			String statusTypeName, String statusDescription) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.selectSharedStatusTypeRadioBtn();
		this.clickOnSave();
		return this;
	}

	public StatusTypes createEventStatusType(String statusType,
			String statusTypeName, String statusDescription, String section) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.selectEventOnlyCheckBox();
		this.selectSectionName(section);
		this.clickOnSave();
		return this;
	}

	public StatusTypes selectTotalsSummaryCheckBox() throws Exception {
		waitForElement.waitForElements(Locators.DISPLAYSUMMARYTOTALSCHECKBOX, "name");
		if (this.page.element(Locators.DISPLAYSUMMARYTOTALSCHECKBOX, "name").getOne()
				.isSelected() == false) {
			this.page.element(Locators.DISPLAYSUMMARYTOTALSCHECKBOX, "name").getOne()
			.click();
		}
		return this;
	}

	public StatusTypes clickOnCreateNewStatus() throws Exception {
		waitForElement.waitForElements(Locators.CREATENEWSTATUS, "css");
		this.page.element(Locators.CREATENEWSTATUS, "css").getOne().click();
		return this;
	}

	public StatusTypes enterStatusName(String strStatusName) throws Exception {
		waitForElement.waitForElements(Locators.STATUSESNAME, "name");
		this.page.element(Locators.STATUSESNAME, "name").clearInputValue().sendKeys(strStatusName);
		return this;
	}

	public StatusTypes selectStatusColor(String strStatuscolor) throws Exception {
		waitForElement.waitForElements(Locators.STATUSCOLOR, "css");
		this.page.element(Locators.STATUSCOLOR, "css").webElementToSelect().selectByVisibleText(strStatuscolor);
		return this;
	}

	public StatusTypes createNewStatus(String strStatusName, String strStatuscolor) throws Exception {
		this.clickOnCreateNewStatus();
		this.enterStatusName(strStatusName);
		this.selectStatusColor(strStatuscolor);
		this.clickOnSave();
		return this;
	}

	public StatusTypes selectEventExpirationOption() throws Exception {
		waitForElement.waitForElements(Locators.EVENTEXPIRATION, "xpath");
		this.page.element(Locators.EVENTEXPIRATION, "xpath").getOne().click();
		return this;
	}

	public StatusTypes clickOnReturnToStatusTypeList() throws Exception {
		waitForElement.waitForElements(Locators.RETURNTOSTATUSTYPELIST, "linktext");
		this.page.element(Locators.RETURNTOSTATUSTYPELIST, "linktext").getOne().click();
		return this;
	}

	public StatusTypes selectExpirationMinute(String expirationTimeInMin) throws Exception {
		waitForElement.waitForElements(Locators.EVENTEXPIRATIONINMIN, "name");
		this.page.element(Locators.EVENTEXPIRATIONINMIN, "name").webElementToSelect()
		.selectByVisibleText(expirationTimeInMin);
		return this;
	}

	public StatusTypes createStatusesWithExpirationTime(String statusesName, String statuscolor, String expirationTimeInMin) throws Exception {
		this.clickOnCreateNewStatus();
		this.enterStatusName(statusesName);
		this.selectStatusColor(statuscolor);
		this.selectEventExpirationOption();
		this.selectExpirationMinute(expirationTimeInMin);
		this.clickOnSave();
		return this;
	}

	public StatusTypes selectShiftTime(String strShiftTimeInHour,
			String strShiftTimeInMin) throws Exception {
		waitForElement.waitForElements(Locators.SHIFTTIME, "css");
		this.page.element(Locators.SHIFTTIME, "css").getOne().click();
		this.page.element(Locators.SHIFTTIMEHOUR, "css").webElementToSelect()
		.selectByVisibleText(strShiftTimeInHour);
		this.page.element(Locators.SHIFTTIMEMIN, "css").webElementToSelect()
		.selectByVisibleText(strShiftTimeInMin);
		return this;
	}

	public StatusTypes selectSectionName(String strSectionName) throws Exception {
		waitForElement.waitForElements(Locators.GROUPLISTSELECT, "name");
		this.page.element(Locators.GROUPLISTSELECT, "name").webElementToSelect().selectByVisibleText(strSectionName);
		return this;
	}

	public StatusTypes createStatusTypeWithShiftTime(String statusType,  String name, String description, String shiftTimeInHour, String shiftTimeInMin) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.enterStatusTypeName(name);
		this.enterStatusTypeDescription(description);
		this.selectShiftTime(shiftTimeInHour, shiftTimeInMin);
		this.clickOnSave();
		return this;
	}

	public StatusTypes createStatusType(String strStatusType, String statusTypeName, String statusDescription, String sectionName) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.selectSectionName(sectionName);
		this.clickOnSave();
		return this;
	}

	public StatusTypes createStatusTypeSelectSectionWithShiftTime(String statusType,  String name, String description, String shiftTimeInHour, String shiftTimeInMin, String sectionName) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.enterStatusTypeName(name);
		this.enterStatusTypeDescription(description);
		this.selectShiftTime(shiftTimeInHour, shiftTimeInMin);
		this.selectSectionName(sectionName);
		this.clickOnSave();
		return this;
	}

	public StatusTypes createSharedStatusType(String strStatusType, String statusTypeName, String statusDescription, String sectionName) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.selectSectionName(sectionName);
		this.selectSharedStatusTypeRadioBtn();
		this.clickOnSave();
		return this;
	}

	public StatusTypes createSharedStatusTypeWithShiftTime(String statusType,  String name, String description, String shiftTimeInHour, String shiftTimeInMin, String sectionName) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.enterStatusTypeName(name);
		this.enterStatusTypeDescription(description);
		this.selectShiftTime(shiftTimeInHour, shiftTimeInMin);
		this.selectSectionName(sectionName);
		this.selectSharedStatusTypeRadioBtn();
		this.clickOnSave();
		return this;
	}

	public String getStatusesValue(String strStatus) throws Exception {
		waitForElement.waitForElements(Locators.STATUS + strStatus + Locators.CLOSEBRACKETS + Locators.EDITOFSTATUS, "xpath");
		String strStatValue = this.page
				.element(Locators.STATUS + strStatus + Locators.CLOSEBRACKETS + Locators.EDITOFSTATUS, "xpath").getOne().getAttribute("href");
		String strResValueArr[] = strStatValue.split("statusID=");
		strStatValue = strResValueArr[1];
		return strStatValue;
	}

	public StatusTypes enabledPrivateOnly() throws Exception {
		waitForElement.waitForElements(Locators.PRIVATE_STATUS_TYPE_VISIBILITY, "css");
		if(this.page.element(Locators.PRIVATE_STATUS_TYPE_VISIBILITY, "css").getOne().isSelected() == false){
			this.page.element(Locators.PRIVATE_STATUS_TYPE_VISIBILITY, "css").getOne().click();
		}
		if(this.page.element(Locators.PRIVATE_STATUS_TYPE_VISIBILITY, "css").getOne().isSelected() == false){
			this.page.element(Locators.PRIVATE_STATUS_TYPE_VISIBILITY, "css").getOne().sendKeys(Keys.SPACE);
		}
		assertTrue(this.page.element(Locators.PRIVATE_STATUS_TYPE_VISIBILITY, "css").getOne().isSelected(), "private status type radio button is not selected");
		return this;
	}

	public StatusTypes createEventSharedStatusType(String statusType,
			String statusTypeName, String statusDescription, String section) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.selectSharedStatusTypeRadioBtn();
		this.selectEventOnlyCheckBox();
		this.selectSectionName(section);
		this.clickOnSave();
		return this;
	}

	public StatusTypes createEventPrivateStatusType(String statusType,
			String statusTypeName, String statusDescription, String section) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.enabledPrivateOnly();
		this.selectEventOnlyCheckBox();
		this.selectSectionName(section);
		this.clickOnSave();
		return this;
	}

	public StatusTypes createPrivateStatusType(String statusType,
			String statusTypeName, String statusDescription, String section) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.enabledPrivateOnly();
		this.selectSectionName(section);
		this.clickOnSave();
		return this;
	}

	public StatusTypes selectStatusReasons(List<String> reasonValues)
			throws Exception {
		for (int intCount = 0; intCount < reasonValues.size(); intCount++) {
			String statusTypevalues = Locators.STATUS_REASON_PART1+reasonValues.get(intCount)+Locators.CLOSEBRACKETS+Locators.STATUS_REASON_PART2;
			this.page.element(statusTypevalues, "xpath").mouseOver();
			this.page.element(statusTypevalues, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}

	public StatusTypes selectStatusReasonsForStatuses(List<String> reasonValues)
			throws Exception {
		for (int intCount = 0; intCount < reasonValues.size(); intCount++) {
			String statusTypevalues = Locators.STATUS_REASON_PART1+reasonValues.get(intCount)+Locators.CLOSEBRACKETS+Locators.STATUS_REASON_FOR_STATUSES;
			this.page.element(statusTypevalues, "xpath").mouseOver();
			this.page.element(statusTypevalues, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}

	public StatusTypes createPrivateStatusTypeWithReasons(String statusType,
			String statusTypeName, String statusDescription, String section,List<String> reasonValues) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.enabledPrivateOnly();
		this.selectSectionName(section);
		this.selectStatusReasons(reasonValues);
		this.clickOnSave();
		return this;
	}

	public StatusTypes createSharedStatusTypeWithReasons(String strStatusType, String statusTypeName, String statusDescription, String sectionName,List<String> reasonValues) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.selectSectionName(sectionName);
		this.selectSharedStatusTypeRadioBtn();
		this.selectStatusReasons(reasonValues);
		this.clickOnSave();
		return this;
	}

	public StatusTypes createEventStatusTypeWithReasons(String statusType,
			String statusTypeName, String statusDescription,String section,List<String> reasonValues) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.selectEventOnlyCheckBox();
		this.selectSectionName(section);
		this.selectStatusReasons(reasonValues);
		this.clickOnSave();
		return this;
	}

	public StatusTypes createStatusTypeWithReasons(String strStatusType, String statusTypeName, String statusDescription, String sectionName,List<String> reasonValues) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.selectSectionName(sectionName);
		this.selectStatusReasons(reasonValues);
		this.clickOnSave();
		return this;
	}

	public StatusTypes createNewStatusWithReasons(String strStatusName, String strStatuscolor,List<String> reasonValues) throws Exception {
		this.clickOnCreateNewStatus();
		this.enterStatusName(strStatusName);
		this.selectStatusColor(strStatuscolor);
		this.selectStatusReasonsForStatuses(reasonValues);
		this.clickOnSave();
		return this;
	}

	public StatusTypes verifyStatusTypeListPage() throws Exception {
		waitForElement.waitForElements(Locators.STATUS_TYPE_LIST_PAGE, "xpath");
		assertTrue(this.page.element(Locators.STATUS_TYPE_LIST_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.STATUS_TYPE_LIST_PAGE, "xpath").getDisplayedOne().isDisplayed());
		return this;
	}

	public StatusTypes createNewStatusSelectingReasonsWithStatusReasonRequired(String strStatusName, String strStatuscolor,List<String> reasonValues) throws Exception {
		this.clickOnCreateNewStatus();
		this.enterStatusName(strStatusName);
		this.selectStatusColor(strStatuscolor);
		this.selectStatusReasonsForStatuses(reasonValues);
		this.selectStatusReasonRequired();
		this.clickOnSave();
		return this;
	}

	public StatusTypes selectStatusReasonRequired() throws Exception {
		waitForElement.waitForElements(Locators.STATUS_REASON_REQUIRED, "css");
		this.page.element(Locators.STATUS_REASON_REQUIRED, "css").getOne().click();
		assertTrue(this.page.element(Locators.STATUS_REASON_REQUIRED, "css").getOne().isSelected());
		return this;
	}

	public StatusTypes clickOnEditOfStatusType(String statusTypeName) throws Exception {
		String element = Locators.STATUS + statusTypeName + Locators.CLOSEBRACKETS + Locators.EDITOFSTATUS;
		waitForElement.waitForElements(element, "xpath");
		this.page.element(element, "xpath").getDisplayedOne().click();
		if(!this.page.element(Locators.STATUSTYPENAME, "name").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
			try{
				this.page.element(element, "xpath").clickUsingJSE();
			} catch(Exception e){

			}
		}
		assertTrue(this.page.element(Locators.STATUSTYPENAME, "name").isElementPresent(), "edit status type page is not displayed.");
		return this;
	}

	public StatusTypes editSectionOfStatusType(ArrayList<String> statusTypeName, String sectionName) throws Exception {
		Iterator<String> iterator = statusTypeName.iterator();
		while(iterator.hasNext()) {
			String statusType = iterator.next();
			this.clickOnEditOfStatusType(statusType);
			this.selectSectionName(sectionName);
			this.clickOnSave();
			this.verifyStatusTypeListPage();
		}
		return this;
	}

	public StatusTypes deSelectDisplayeNedocsLabels() throws Exception {
		waitForElement.waitForElements(Locators.DISPLAY_NEDOCS_LABELS, "xpath");
		if(this.page.element(Locators.DISPLAY_NEDOCS_LABELS, "xpath").getOne().isSelected()){
			this.page.element(Locators.DISPLAY_NEDOCS_LABELS, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(Locators.DISPLAY_NEDOCS_LABELS, "xpath").getOne().isSelected()){
			this.page.element(Locators.DISPLAY_NEDOCS_LABELS, "xpath").clickUsingJSE();
		}
		assertTrue(!this.page.element(Locators.DISPLAY_NEDOCS_LABELS, "xpath").getOne().isSelected());
		return this;
	}

	public StatusTypes selectDisplayeNedocsLabels() throws Exception {
		waitForElement.waitForElements(Locators.DISPLAY_NEDOCS_LABELS, "xpath");
		if(!this.page.element(Locators.DISPLAY_NEDOCS_LABELS, "xpath").getOne().isSelected()){
			this.page.element(Locators.DISPLAY_NEDOCS_LABELS, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if(!this.page.element(Locators.DISPLAY_NEDOCS_LABELS, "xpath").getOne().isSelected()){
			this.page.element(Locators.DISPLAY_NEDOCS_LABELS, "xpath").clickUsingJSE();
		}
		assertTrue(this.page.element(Locators.DISPLAY_NEDOCS_LABELS, "xpath").getOne().isSelected());
		return this;
	}

	public StatusTypes verifyDisplayeNedocsLabelsIsSelected() throws Exception {
		waitForElement.waitForElements(Locators.DISPLAY_NEDOCS_LABELS, "xpath");
		this.page.element(Locators.DISPLAY_NEDOCS_LABELS, "xpath").mouseOver();
		assertTrue(this.page.element(Locators.DISPLAY_NEDOCS_LABELS, "xpath").getOne().isSelected());
		return this;
	}

	public StatusTypes createNedocsStatusTypeDeselectingDisplayLabels(String statusType,
			String statusTypeName, String statusDescription, String section) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.verifyDisplayeNedocsLabelsIsSelected();
		this.deSelectDisplayeNedocsLabels();
		this.selectSectionName(section);
		this.clickOnSave();
		return this;
	}

	public StatusTypes selectResourcType(String resourceTypevalue) throws Exception {
		String resourceTypevalues = Locators.RESOURCE_TYPE_VALUE+ resourceTypevalue + Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(resourceTypevalues, "xpath");
		if(this.page.element(resourceTypevalues, "xpath").getOne().isSelected()) {
			this.page.element(resourceTypevalues, "xpath").mouseOver();
			this.page.element(resourceTypevalues, "xpath").clickUsingJSE();
		}
		if(this.page.element(resourceTypevalues, "xpath").getOne().isSelected()) {
			this.page.element(resourceTypevalues, "xpath").mouseOver();
			this.page.element(resourceTypevalues, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(resourceTypevalues, "xpath").getOne().isSelected()) {
			this.page.element(resourceTypevalues, "xpath").mouseOver();
			this.page.element(resourceTypevalues, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
		}
		assertFalse(this.page.element(resourceTypevalues, "xpath").getOne().isSelected(), resourceTypevalues + " is not deselected.");
		return this;
	}


	public StatusTypes CreateStatusTypeSelectingResourcetype(String statusType, String statusTypeName, String statusDescription, String sectionName,String resourceTypeValue) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.selectSectionName(sectionName);
		this.selectResourcType(resourceTypeValue);
		this.clickOnSave();
		return this;
	}

	public StatusTypes editNedocsStatusTypeAndSelectDisplayLabels(String statusTypeName) throws Exception {
		this.clickOnEditOfStatusType(statusTypeName);
		this.selectDisplayeNedocsLabels();
		this.clickOnSave();
		this.verifyStatusTypeListPage();
		return this;
	}

	public StatusTypes clickOnCancel() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL_BUTTON, "css");
		this.page.element(Locators.CANCEL_BUTTON, "css").getDisplayedOne().click();
		return this;
	}
	
	public StatusTypes verifyDisplayNEDOCSLabelsIsSelectedByDefaultWhileCreatingNedocsStatusTypes(String statusType) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.verifyDisplayeNedocsLabelsIsSelected();
		this.clickOnCancel();
		return this;
	}

	public StatusTypes editNedocsStatusTypeAnddeSelectDisplayLabels(String statusTypeName) throws Exception {
		this.clickOnEditOfStatusType(statusTypeName);
		this.deSelectDisplayeNedocsLabels();
		this.clickOnSave();
		this.verifyStatusTypeListPage();
		return this;
	}

	public StatusTypes editNedocsStatusTypesAnddeSelectDisplayLabels(ArrayList<String> statusTypeName) throws Exception {

		Iterator<String> statusTypeNames = statusTypeName.iterator();
		while (statusTypeNames.hasNext()) {
			this.editNedocsStatusTypeAnddeSelectDisplayLabels(statusTypeNames
					.next());
		}
		return this;
	}

	public StatusTypes editNedocsStatusTypesAnSelectDisplayLabels(ArrayList<String> statusTypeName) throws Exception {

		Iterator<String> statusTypeNames = statusTypeName.iterator();
		while (statusTypeNames.hasNext()) {
			this.editNedocsStatusTypeAndSelectDisplayLabels(statusTypeNames.next());
		}
		return this;
	}

	public StatusTypes clickOnEdit(String statusTypeName) throws Exception {

		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT+statusTypeName+Locators.EDIT_LINK, "xpath");
		this.page.element(Locators.TABLECELLWITHTEXT+statusTypeName+Locators.EDIT_LINK, "xpath").mouseOver();
		this.page.element(Locators.TABLECELLWITHTEXT+statusTypeName+Locators.EDIT_LINK, "xpath").clickUsingJSE();
		return this;
	}

	public StatusTypes editStatusTypeNameAndDescription(String statusTypeName,String editStatusTypeName,String editDescription) throws Exception {
		this.clickOnEdit(statusTypeName);
		this.enterStatusTypeName(editStatusTypeName);
		this.enterStatusTypeDescription(editDescription);
		this.saveEditedStatusType();
		return this;
	}

	public StatusTypes saveEditedStatusType() throws Exception {
		waitForElement.waitForElements(Locators.SAVEBUTTON, "css");
		this.page.element(Locators.SAVEBUTTON, "css").mouseOver();
		this.page.element(Locators.SAVEBUTTON, "css").getOne().click();
		return this;
	}

	public StatusTypes deselectRolesWithViewRightsCheckBox() throws Exception {
		waitForElement.waitForElements(Locators.ROLES_WITH_VIEW_RIGHT, "css");
		if(this.page.element(Locators.ROLES_WITH_VIEW_RIGHT, "css").getOne().isSelected())
		{
			this.page.element(Locators.ROLES_WITH_VIEW_RIGHT, "css").mouseOver();
			this.page.element(Locators.ROLES_WITH_VIEW_RIGHT, "css").getOne().click();
		}
		if(this.page.element(Locators.ROLES_WITH_VIEW_RIGHT, "css").getOne().isSelected())
		{
			this.page.element(Locators.ROLES_WITH_VIEW_RIGHT, "css").mouseOver();
			this.page.element(Locators.ROLES_WITH_VIEW_RIGHT, "css").getOne().sendKeys(Keys.SPACE);
		}
		assertFalse(this.page.element(Locators.ROLES_WITH_VIEW_RIGHT, "css").getOne().isSelected());
		return this;
	}

	public StatusTypes deselectRolesWithUpdateCheckBox() throws Exception {
		waitForElement.waitForElements(Locators.ROLES_WITH_UPDATE_RIGHT, "css");
		if(this.page.element(Locators.ROLES_WITH_UPDATE_RIGHT, "css").getOne().isSelected())
		{
			this.page.element(Locators.ROLES_WITH_UPDATE_RIGHT, "css").mouseOver();
			this.page.element(Locators.ROLES_WITH_UPDATE_RIGHT, "css").getOne().click();
		}
		if(this.page.element(Locators.ROLES_WITH_UPDATE_RIGHT, "css").getOne().isSelected())
		{
			this.page.element(Locators.ROLES_WITH_UPDATE_RIGHT, "css").mouseOver();
			this.page.element(Locators.ROLES_WITH_UPDATE_RIGHT, "css").getOne().sendKeys(Keys.SPACE);
		}
		assertFalse(this.page.element(Locators.ROLES_WITH_UPDATE_RIGHT, "css").getOne().isSelected());
		return this;
	}

	public StatusTypes selectRoleUnderViewRights(String roleValue) throws Exception {
		waitForElement.waitForElements(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath");
		if(this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").getOne().isSelected()==false)
		{
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").mouseOver();
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").getDisplayedOne().click();
		}
		if(this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").getOne().isSelected()==false)
		{
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").mouseOver();
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").getOne().isSelected()==false)
		{
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").mouseOver();
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").clickUsingJSE();
		}
		assertTrue(this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").getOne().isSelected());
		return this;
	}

	public StatusTypes deSelectRoleUnderViewsection(String roleValue) throws Exception {

		waitForElement.waitForElements(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath");
		if(this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").getOne().isSelected())
		{
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").mouseOver();
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").getDisplayedOne().click();
		}
		if(this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").getOne().isSelected())
		{
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").mouseOver();
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		assertFalse(this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_VIEW, "xpath").getOne().isSelected());
		return this;
	}

	public StatusTypes deSelectRoleUnderUpdateSection(String roleValue) throws Exception {

		waitForElement.waitForElements(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_UPDATE, "xpath");
		if(this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_UPDATE, "xpath").getOne().isSelected())
		{
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_UPDATE, "xpath").mouseOver();
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_UPDATE, "xpath").getDisplayedOne().click();
		}
		if(this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_UPDATE, "xpath").getOne().isSelected())
		{
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_UPDATE, "xpath").mouseOver();
			this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_UPDATE, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		assertFalse(this.page.element(Locators.STATUS_REASON_PART1+roleValue+Locators.ROLE_UNDER_UPDATE, "xpath").getOne().isSelected());
		return this;
	}

	public StatusTypes createStatusTypeWithoutSelectingAnyRolesUnderViewAndUpdateRolesSections(String statusType, String statusTypeName, String statusDescription, String sectionName) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(statusType);
		this.clickNextButton();
		this.enterStatusTypeName(statusTypeName);
		this.enterStatusTypeDescription(statusDescription);
		this.selectSectionName(sectionName);
		this.deselectRolesWithViewRightsCheckBox();
		this.deselectRolesWithUpdateCheckBox();
		this.clickOnSave();
		return this;
	}

	public StatusTypes editStatusTyepeAndRemoveAllRolesUnderViewAndUpdateSections(String statusTypeName) throws Exception {
		this.clickOnEdit(statusTypeName);
		this.deselectRolesWithViewRightsCheckBox();
		this.deselectRolesWithUpdateCheckBox();
		return this;
	}

	public StatusTypes editAndDeselectRoleUnderViewAndUpdateSections(String statusTypeName,String roleValue) throws Exception {
		this.clickOnEdit(statusTypeName);
		this.deSelectRoleUnderViewsection(roleValue);
		this.deSelectRoleUnderUpdateSection(roleValue);
		return this;
	}
	
	public StatusTypes verifyRoleIsNotPresentInViewRightSection(ArrayList<String> roleValue) throws Exception{
		waitForElement.waitForElements(Locators.ROLE_SECTION+ roleValue+Locators.CLOSEBRACKETS+Locators.ROLE_WITH_VIEW_RIGHT_PART2, "css");
		assertFalse(this.page.element(Locators.ROLE_SECTION+ roleValue+Locators.CLOSEBRACKETS+Locators.ROLE_WITH_VIEW_RIGHT_PART2, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), roleValue + "Role is dispalyed");
		return this;
	}

	public StatusTypes verifyRoleIsNotPresentInUpdateRightSection(ArrayList<String> roleValue) throws Exception {
		waitForElement.waitForElements(Locators.ROLE_SECTION+roleValue+Locators.CLOSEBRACKETS+Locators.ROLE_WITH_UPDATE_RIGHT_PART3, "css");
		assertFalse(this.page.element(Locators.ROLE_SECTION+roleValue+Locators.CLOSEBRACKETS+Locators.ROLE_WITH_UPDATE_RIGHT_PART3, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), roleValue + "Role is dispalyed");
		return this;
	}

	public StatusTypes verifyRoleIsNotPresentInStatusTypePage(ArrayList<String> roleValue) throws Exception{
		this.verifyRoleIsNotPresentInViewRightSection(roleValue);
		this.verifyRoleIsNotPresentInUpdateRightSection(roleValue);
		return this;
	}

	public StatusTypes editFirstStatusType() throws Exception{
		waitForElement.waitForElements(Locators.EDIT_FIRST_STATUS_TYPE, "xpath");
		this.page.element(Locators.EDIT_FIRST_STATUS_TYPE, "xpath").getDisplayedOne().click();
		return this;
	 }
  
	public StatusTypes verifyStatusTypeInList(String StatusTypeName) throws Exception {
		waitForElement.waitForElements(Locators.STATUS_TYPE_TABLE + Locators.TABLECELLWITHTEXT + StatusTypeName + Locators.CLOSEBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.STATUS_TYPE_TABLE + Locators.TABLECELLWITHTEXT + StatusTypeName + Locators.CLOSEBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.STATUS_TYPE_TABLE + Locators.TABLECELLWITHTEXT + StatusTypeName + Locators.CLOSEBRACKETS, "xpath").getDisplayedOne().isDisplayed());
		return this;
	}
	
	public StatusTypes editMandatoryDataOfStatusType(String statusTypeName, String edit_STName, String edit_description, String section) throws Exception {
		this.clickOnEdit(statusTypeName);
		this.enterStatusTypeName(edit_STName);
		this.enterStatusTypeDescription(edit_description);
		this.selectSectionName(section);
		this.clickOnSave();
		this.verifyStatusTypeInList(edit_STName);
		return this;
	}
	
	public StatusTypes verifyStatusType_InList(String StatusTypeName) throws Exception {
		waitForElement.waitForElements(Locators.STATUS_TYPE_TABLE + Locators.TABLECELLWITHTEXT + StatusTypeName + Locators.CLOSEBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.STATUS_TYPE_TABLE + Locators.TABLECELLWITHTEXT + StatusTypeName + Locators.CLOSEBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.STATUS_TYPE_TABLE + Locators.TABLECELLWITHTEXT + StatusTypeName + Locators.CLOSEBRACKETS, "xpath").getDisplayedOne().isDisplayed());
		return this;
	}
	
	public StatusTypes verifyStatusTypeDetailsInList(String statusTypeName, String description, String section) throws Exception {
		String element = Locators.STATUS_TYPE_TABLE + Locators.TABLECELLWITHTEXT + statusTypeName + Locators.CLOSEBRACKETS +
				Locators.FOLLWOING_SIBLING_TEXT + section + Locators.CLOSEBRACKETS + Locators.FOLLWOING_SIBLING_TEXT + description + Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(element, "xpath");
		assertTrue(this.page.element(element, "xpath").isElementPresent(), element + " is not present.");
		assertTrue(this.page.element(element, "xpath").getDisplayedOne().isDisplayed(), element + " is not displayed.");
		return this;
	}
	
	public StatusTypes dragAndDropStatuses(String Status_1, String Status_2) throws Exception {
		String status_element_1 = Locators.STATUSES_TABLE + Locators.TABLECELLWITHTEXT + Status_1 + Locators.CLOSEBRACKETS;
		String status_element_2 = Locators.STATUSES_TABLE + Locators.TABLECELLWITHTEXT + Status_2 + Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(status_element_1, "xpath");
		WebElement destination_status = this.page.element(status_element_1, "xpath").getDisplayedOne();
		this.page.element(status_element_2, "xpath").dragAndDropElement(destination_status);
		return this;
	}
	
	public StatusTypes clickOnReOrderStatuses() throws Exception {
		waitForElement.waitForElements(Locators.RE_ORDER_STATUSES, "css");
		this.page.element(Locators.RE_ORDER_STATUSES, "css").getDisplayedOne().click();
		return this;
	}
	
	public StatusTypes clickOnDoneReOrdering() throws Exception {
		waitForElement.waitForElements(Locators.DONE_RE_ORDERING, "css");
		this.page.element(Locators.DONE_RE_ORDERING, "css").getDisplayedOne().click();
		return this;
	}
	
	public StatusTypes verifyReorderingValidationMessages() throws Exception {
		waitForElement.waitForElements(Locators.WARNING_RE_ORDERING, "xpath");
		assertTrue(this.page.element(Locators.WARNING_RE_ORDERING, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.WARNING_RE_ORDERING, "xpath").getDisplayedOne().isDisplayed());
		assertTrue(this.page.element(Locators.WARNING_SAVE_RE_ORDERING, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.WARNING_SAVE_RE_ORDERING, "xpath").getDisplayedOne().isDisplayed());
		assertTrue(this.page.element(Locators.WARNING_CANCEL_RE_ORDERING, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.WARNING_CANCEL_RE_ORDERING, "xpath").getDisplayedOne().isDisplayed());
		return this;
	}
	
	public StatusTypes clickOnStatuses_MST(String MST_name) throws Exception {
		waitForElement.waitForElements(Locators.STATUS_TYPE_TABLE + Locators.TABLECELLWITHTEXT + MST_name + Locators.STATUSES_LINK_OF_MST, "xpath");
		this.page.element(Locators.STATUS_TYPE_TABLE + Locators.TABLECELLWITHTEXT + MST_name + Locators.STATUSES_LINK_OF_MST, "xpath").getDisplayedOne().click();
		return this;
	}
	
	public StatusTypes reorderStatuses_MultiStatusType(String MST_Name, String Status_1, String Status_2, String Status_3) throws Exception {
		this.clickOnStatuses_MST(MST_Name);
		this.clickOnReOrderStatuses();
		this.dragAndDropStatuses(Status_1, Status_2);
		this.dragAndDropStatuses(Status_1, Status_3);
		this.clickOnDoneReOrdering();
		this.verifyReorderingValidationMessages();
		this.clickOnSave();
		this.page.element_wait(Locators.WARNING_RE_ORDERING, "xpath").waitForInvisibilityOfElement();
		return this;
	}
	
	public StatusTypes verifyStatuses_MST(String MST_name, ArrayList<String> statusesNames) throws Exception {
		waitForElement.waitForElements(Locators.STATUS_TYPE_TABLE, "xpath");
		Iterator<String> iterator = statusesNames.iterator();
		while(iterator.hasNext()) {
			String next = iterator.next();
			String element = Locators.STATUS_TYPE_TABLE + Locators.TABLECELLWITHTEXT + MST_name + Locators.STATUSES_PART1 + Locators.TEXT_PART + next + Locators.CLOSEBRACKETS;
			assertTrue(this.page.element(element, "xpath").isElementPresent());
			assertTrue(this.page.element(element, "xpath").getDisplayedOne().isDisplayed());
		}
		return this;
	}
	
	public StatusTypes verifyStatusesOrder(String MST_name, ArrayList<String> statusesNames) throws Exception {
		waitForElement.waitForElements(Locators.STATUS_TYPE_TABLE, "xpath");
		ArrayList<String> statuses_application = new ArrayList<String>();
		List<WebElement> statuses = this.page.element(Locators.STATUS_TYPE_TABLE + Locators.TABLECELLWITHTEXT + MST_name + Locators.STATUSES_PART1, "xpath").get();
		Iterator<WebElement> iterator2 = statuses.iterator();
		while(iterator2.hasNext()) {
			WebElement next = iterator2.next();
			statuses_application.add(next.getText());
		}
		Iterator<String> iterator = statuses_application.iterator();
		Iterator<String> iterator3 = statusesNames.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.hasNext());
			String app_status = iterator.next();
			String expected_status = iterator3.next();
			assertEquals(app_status, expected_status);
			assertEquals(statuses_application.size(), statusesNames.size());
		}
		return this;
	}
}