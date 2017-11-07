package lib.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lib.dataObject.StatusTypes_data;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertTrue;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class StatusTypeList extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement ;
	StatusTypes_data objStatusTypes_data = new StatusTypes_data();

	//Locators
	private String setUpLink = "Setup",
			setUpLink1 = "Setup",
			statusTypeLink ="//div[@id='mainContainer']/table/tbody/tr/td/a[text()='Status Types']",
			createNewStatusTypeButton = "input[value='Create New Status Type']",
			selectType = "statusValueCode",
			nextButton = "input[class='emsButtonText'][value='Next']",
			statusTypeName = "statusTypeName",
			statusDescription = "definition",
			saveButton = "input[class='emsButtonText'][value='Save']",
			eventStatusType = "eventOnly",
			eventExpiration = "//input[@name='timeoutCode'][@value='EXPIR']",
			eventExpirationInMin = "timeoutMinutes",
			standardStatusTypeLabels = "input[value='Standard Status Type Labels']",
			createNewStatus = "input[value='Create New Status']",
			statusName = "statusName",
			returnToStatusTypeList = "Return to Status Type List",
			groupListSelect = "groupListSelect",
			privateStatusType = "input[name='visibility'][value=PRIVATE]",
			sharedStatusType = "input[name='visibility'][value=SHARED]",
			strStandardStatusType = "select[name='standardStatusTypeID']",
			statusColor = "select[name='colorCode']",
			anyDateShouildPresentradiobutton = "input[name='dateRangeType'][value='0']",
			dateRangeBetweenRadioBtn = "input[name='dateRangeType'][value='1']",
			dateRangeFromField = "#dateRangeFrom",
			dateRangeToField = "#dateRangeTo",
			datePastDatesOnly="//input[@name='dateRangeType'][@value='5']",
			inactiveStatusTypes = "inactive_st",
			inactiveResourceTypes = "inactive_rt",
			AcitveChkBox = "active",
			backButton = "input[class='emsButtonText'][value='Back']",
			cancelButton = "input[class='emsButtonText'][value='Cancel']",
			header = "//div[@id='topSubNav']/h1",
			traceUser = "input[name='trace']",
			statusesName = "select[name='toStatusID']",
			shiftTime = "input[name='shift'][value='1']",
			shiftTimeHour = "select[name='expireHour1']",
			shifttimeMin = "select[name='expireMin1']",
			timerType = "timer",
			statusReasonrequired = "input[name='reasonRequired']",
			updateExempt = "updateExempt",
			viewSelectAllChkBox= "input[name='SELECT_ALL'][value='roleView']",
			updateSelectAllChkBox= "input[name='SELECT_ALL'][value='roleUpdate']",
			nedocsTextDisplay= "input[name='nedocsTextDisplay']",
			roleBasedStatusType = "input[name='visibility'][value=REGION_ONLY]",
			displaySummaryTotalsCheckBox= "displaySummaryTotals",
			reorderStatuses = "input[value='Re-order Statuses']",
			doneReordering	= "input[value='Done Re-ordering']";


	public StatusTypeList(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to navigate to 'Users'
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList clickOnSetUp() throws Exception {
		objWaitForElement.waitForElements(setUpLink, "linktext");
		this.page.element(setUpLink, "linktext").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to navigate to 'Users'
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList clickOnSetUp1() throws Exception {
		objWaitForElement.waitForElements(setUpLink1, "linktext");
		this.page.element(setUpLink1, "linktext").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to navigate to 'Users'
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList navigateToStatusTypeList() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(statusTypeLink, "xpath");
		this.page.element(statusTypeLink, "xpath").getOne().click();
		return new StatusTypeList(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to navigate to 'Users'
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList navigateToStatusTypeListNew() throws Exception {
		this.clickOnSetUp1();
		objWaitForElement.waitForElements(statusTypeLink, "xpath");
		if(this.page.element(statusTypeLink, "xpath").isElementPresent()==true){
			this.page.element(statusTypeLink, "xpath").getOne().sendKeys(Keys.ENTER);
		}
		//		this.page.element(statusTypeLink, "xpath").getOne().sendKeys(Keys.SPACE);
		return new StatusTypeList(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Create New Status Type' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList clickCreateNewStatusTypeButton() throws Exception {
		objWaitForElement.waitForElements(createNewStatusTypeButton, "css");
		this.page.element(createNewStatusTypeButton, "css").getOne().click();
		try{
			this.verifySelectStatusTypePage();
		}catch(Exception e) {
			this.page.element(createNewStatusTypeButton, "css").getOne().sendKeys(Keys.ENTER);
			this.verifySelectStatusTypePage();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Create New User' button
	 * Date        :11/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList selectStatusType(String strStatusType) throws Exception {
		driver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME_SMALL,TimeUnit.SECONDS);
		objWaitForElement.waitForElements(selectType, "name");
		this.page.element(selectType, "name").webElementToSelect().selectByVisibleText(strStatusType);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Next' button
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList clickNextButton() throws Exception {
		objWaitForElement.waitForElements(nextButton, "css");
		this.page.element(nextButton, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter Status Type name
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList enterStatusTypeName(String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements(statusTypeName, "name");
		this.page.element(statusTypeName, "name").clearInputValue().sendKeys(strStatusTypeName);
		assertTrue(this.page.element(statusTypeName, "name").getOne().getAttribute("value").equals(strStatusTypeName));
		this.selectSectionName("No Section Assigned");
		System.out.println(strStatusTypeName);
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to enter Status Type description
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList enterStatusTypeDescription(String strStatusDescription) throws Exception {
		objWaitForElement.waitForElements(statusDescription, "name");
		this.page.element(statusDescription, "name").clearInputValue().sendKeys(strStatusDescription);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Next' button
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList clickOnSaveButton() throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		this.page.element(saveButton, "css").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create status type
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList createStatusType(String strStatusType, String strStatusTypeName, String strStatusDescription) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectSectionName("No Section Assigned");
		this.clickOnSaveButton();
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to create status type
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public String getStatusValue(String strStatusTypeName) throws Exception {
		/*this.navigateToStatusTypeListNew();*/

		String StValue="//tr/td[2][text()='"+ strStatusTypeName + "']/parent::" + "tr/td[1]/a";

		objWaitForElement.waitForElements(StValue, "xpath");
		String strStatValue = this.page.dynamicElement("StatusTypeName",StValue, "xpath").getOne().getAttribute("href");
		System.out.println(strStatValue);

		String strResValueArr[] = strStatValue.split("nextStepDetail=");
		System.out.println(strResValueArr);
		strStatValue = strResValueArr[1];
		System.out.println(strStatValue);

		return strStatValue;
	}

	/**********************************************************************************
	 * Description : This function is to select Event only option
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList selectEventOnlyOption() throws Exception {
		objWaitForElement.waitForElements(eventStatusType, "name");
		this.page.element(eventStatusType, "name").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create event status type
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList createEventStatusType(String strStatusType, String strStatusTypeName, String strStatusDescription) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectEventOnlyOption();
		this.selectSectionName("No Section Assigned");
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select status type expiration
	 * Date        : 16/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList selectEventExpirationOption() throws Exception {
		objWaitForElement.waitForElements(eventExpiration, "xpath");
		this.page.element(eventExpiration, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to get event expiration time in minutes
	 * Date        : 16/06/2014
	 * Author      : Anil
	 **********************************************************************************/	
	public StatusTypeList selectExpirationMinute(String strExpitationTimeInMin) throws Exception {
		objWaitForElement.waitForElements(eventExpirationInMin, "name");
		this.page.element(eventExpirationInMin, "name").webElementToSelect()
		.selectByVisibleText(strExpitationTimeInMin);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create event Status Type with expiration time in minutes
	 * Date        : 16/06/2014
	 * Author      : Anil
	 **********************************************************************************/	
	public StatusTypeList createEventStatusTypeWithExpirationTime(String strStatusType,  String strStatusTypeName, String strStatusDescription,String strExpitationTimeInMin) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectEventOnlyOption();
		this.selectEventExpirationOption();
		this.selectExpirationMinute(strExpitationTimeInMin);
		this.selectSectionName("No Section Assigned");
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create Status Type with expiration time in minutes
	 * Date        : 16/06/2014
	 * Author      : Anil
	 **********************************************************************************/	
	public StatusTypeList createStatusTypeWithExpirationTime(String strStatusType,  String strStatusTypeName, String strStatusDescription, String strExpitationTimeInMin) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectEventExpirationOption();
		this.selectExpirationMinute(strExpitationTimeInMin);
		this.selectSectionName("No Section Assigned");
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select section name
	 * Date        : 05/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList selectSectionName(String strSectionName) throws Exception {
		objWaitForElement.waitForElements(groupListSelect, "name");
		this.page.element(groupListSelect, "name").webElementToSelect().selectByVisibleText(strSectionName);
		assertTrue(this.page.element(groupListSelect, "name").webElementToSelect().getFirstSelectedOption().getText().equals(strSectionName));
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to create status type
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList createStatusTypeWithSection(String strStatusType, String strStatusTypeName, String strStatusDescription, String strSectionName) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectSectionName(strSectionName);
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify create new status type and standard status type labels button are present.
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList verCreateNewStatusTypeAndStandardStatusTypeLabels()
			throws Exception {
		objWaitForElement.waitForElements(createNewStatusTypeButton, "css");
		assertTrue(this.page.element(createNewStatusTypeButton, "css")
				.getOne().isDisplayed(),
				"Create New Sttaus Type button is not present.");
		objWaitForElement.waitForElements(standardStatusTypeLabels, "css");
		assertTrue(this.page.element(standardStatusTypeLabels, "css")
				.getOne().isDisplayed(),
				"Standard status type labels button is not present.");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify created status type and its section value in list.
	 * Arguments	: strStatusTypeName
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList verStatusTypeAndSectionValInList(
			String strStatusTypeName, String strSection) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
				+ strStatusTypeName
				+ "']/parent::tr/td[6][text()='" + strSection
				+ "']", "xpath");
		assertTrue(
				this.page.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
								+ strStatusTypeName
								+ "']/parent::tr/td[6][text()='" + strSection
								+ "']", "xpath").isElementPresent(),
				"Created Status Type is not present.");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on create new status button
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList clickOnCreateNewStatus() throws Exception {
		objWaitForElement.waitForElements(createNewStatus, "css");
		this.page.element(createNewStatus, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on create new status button
	 * Arguments	: strStatusName
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList enterStatusName(String strStatusName) throws Exception {
		objWaitForElement.waitForElements(statusName, "name");
		this.page.element(statusName, "name").clearInputValue().sendKeys(strStatusName);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select status color
	 * Arguments	: strStatusName
	 * Date        : 24/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList selectStatusColor(String strStatuscolor) throws Exception {
		objWaitForElement.waitForElements(statusColor, "css");
		this.page.element(statusColor, "css").webElementToSelect().selectByVisibleText(strStatuscolor);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create new status
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList createNewStatus(String strStatusName, String strStatuscolor) throws Exception {
		this.clickOnCreateNewStatus();
		this.enterStatusName(strStatusName);
		this.selectStatusColor(strStatuscolor);
		this.clickOnSaveButton();
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to verify created status in list for particular MST.
	 * Arguments	: strStatusName
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList verCreatedStatusInStatusListForMulti(
			String strStatusName) throws Exception {
		objWaitForElement.waitForElements("//tr/td[2][text()='"
				+ strStatusName + "']", "xpath");
		assertTrue(
				this.page.element(
						"//tr/td[2][text()='"
								+ strStatusName + "']", "xpath")
								.isElementPresent(), "Created Status is not present.");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on return to status type list link
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList clickOnReturnToStatusTypeList() throws Exception {
		objWaitForElement.waitForElements(returnToStatusTypeList, "linktext");
		assertTrue(this.page.element(returnToStatusTypeList, "linktext")
				.isElementPresent(),
				"return to status type list link is not present.");
		this.page.element(returnToStatusTypeList, "linktext").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify section names under section drop down while creating statsu types
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList verSectionNamesInDropDown(String[] strSectionNames) throws Exception {
		ArrayList<String> sectionNames = new ArrayList<String>(Arrays.asList(strSectionNames));
		ArrayList<String> l1 = new ArrayList<String>();
		objWaitForElement.waitForElements(groupListSelect, "name");
		List<WebElement> elements = this.page.element(groupListSelect, "name").webElementToSelect().getOptions();
		for (WebElement webElement : elements) {
			String str = webElement.getText();
			l1.add(str);
		}
		l1.contains(sectionNames);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on Shared Status Type radio button
	 * Date        : 06/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public StatusTypeList selectSharedStatusTypeRadioBtn() throws Exception {
		objWaitForElement.waitForElements(sharedStatusType, "css");
		if (this.page.element(sharedStatusType, "css").getOne()
				.isSelected() == false) {
			this.page.element(sharedStatusType, "css").getOne()
			.click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create shared status type with section
	 * Arguments   : driver
	 * Date        : 06/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public StatusTypeList createSharedStatusTypeWithSection(
			String strStatusType, String strStatusTypeName,
			String strStatusDescription, String strSectionName)
					throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectSharedStatusTypeRadioBtn();
		this.selectSectionName(strSectionName);
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on Private Status Type radio button
	 * Date        : 06/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public StatusTypeList selectPrivateStatusTypeRadioBtn() throws Exception {
		objWaitForElement.waitForElements(privateStatusType, "css");
		if (this.page.element(privateStatusType, "css").getOne()
				.isSelected() == false) {
			this.page.element(privateStatusType, "css").getOne()
			.click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create shared status type
	 * Arguments   : driver
	 * Date        : 06/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public StatusTypeList createPrivateStatusType(String strStatusType,
			String strStatusTypeName, String strStatusDescription)
					throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectPrivateStatusTypeRadioBtn();
		this.selectSectionName("No Section Assigned");
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create shared status type with section
	 * Arguments   : driver
	 * Date        : 06/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public StatusTypeList createPrivateStatusTypeWithSection(
			String strStatusType, String strStatusTypeName,
			String strStatusDescription, String strSectionName)
					throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectPrivateStatusTypeRadioBtn();
		this.selectSectionName(strSectionName);
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on edit link of status type.
	 * Date        : 08/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList clickOnEditOfStatusType(String strStatusType)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
				+ strStatusType
				+ "']/preceding-sibling::td/a[text()='edit']",
				"xpath");
		this.page
		.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
						+ strStatusType
						+ "']/preceding-sibling::td/a[text()='edit']",
				"xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create private status type with Event
	 * Arguments   : driver
	 * Date        : 06/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public StatusTypeList createPrivateStatusTypeWithEvent(String strStatusType,
			String strStatusTypeName, String strStatusDescription)
					throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectEventOnlyOption();
		this.selectPrivateStatusTypeRadioBtn();
		this.selectSectionName("No Section Assigned");
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create shared status type with section
	 * Arguments   : driver
	 * Date        : 19/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList createSharedStatusType(
			String strStatusType, String strStatusTypeName,
			String strStatusDescription)
					throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectSharedStatusTypeRadioBtn();
		this.selectSectionName("No Section Assigned");
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create status type by selecting resource type values
	 * Arguments : driver
	 * Date   : 09/09/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList createStatusTypeSelectingRT(String strStatusType, String strStatusTypeName, String strStatusDescription, String[] strResourceTypeValue) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		for(int intCount = 0; intCount<strResourceTypeValue.length; intCount++){
			this.selectResourceType(strResourceTypeValue[intCount]);	
		}
		this.selectSectionName("No Section Assigned");
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************
	 * Description : This function is to select resource type
	 * Date        : 09/09/2014
	 * Author      : Anil
	 **********************************************************************/	
	public StatusTypeList selectResourceType(String strResourceTypeValue) throws Exception {
		objWaitForElement.waitForElements("input[name='selectedRT'][value='"+strResourceTypeValue+"']", "css");
		this.page.dynamicElement("Resourcetype","input[name='selectedRT'][value='"+strResourceTypeValue+"']", "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create shared status type with Event and section
	 * Arguments   : driver
	 * Date        : 09/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList createSharedStatusTypeWithEventSection(String strStatusType,
			String strStatusTypeName, String strStatusDescription, String strSection)
					throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectSharedStatusTypeRadioBtn();
		this.selectEventOnlyOption();
		this.selectSectionName(strSection);
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create event status type with section
	 * Arguments 	: driver
	 * Date       	: 09/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList createEventStatusTypeWithSection(String strStatusType, String strStatusTypeName, 
			String strStatusDescription, String strSection) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectEventOnlyOption();
		this.selectSectionName(strSection);
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create private status type with Event ans section
	 * Arguments   : driver
	 * Date        : 09/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList createPrivateStatusTypeWithEventSection(String strStatusType,
			String strStatusTypeName, String strStatusDescription, String strSection)
					throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectPrivateStatusTypeRadioBtn();
		this.selectEventOnlyOption();
		this.selectSectionName(strSection);
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create new statuses with expiration time
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList createNewStatusWithExpirationTime(String strStatusName, String strExpitationTimeInMin) throws Exception {
		this.clickOnCreateNewStatus();
		this.enterStatusName(strStatusName);
		this.selectEventExpirationOption();
		this.selectExpirationMinute(strExpitationTimeInMin);
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to fetch statuses value
	 * Arguments : driver
	 * Date   : 10/09/2014
	 * Author  : Anil
	 **********************************************************************************/
	public String getStatusesValue(String strStatus) throws Exception {
		objWaitForElement.waitForElements("//tr/td[2][text()='"
				+ strStatus + "']/parent::tr/td[1]/a", "xpath");
		String strStatValue = this.page.dynamicElement("StatusTypeName", "//tr/td[2][text()='"
				+ strStatus + "']/parent::tr/td[1]/a", "xpath").getOne().getAttribute("href");

		String strResValueArr[] = strStatValue.split("statusID=");
		strStatValue = strResValueArr[1];

		return strStatValue;
	}

	/**********************************************************************************
	 * Description : This function is to create status type
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList createStatusTypeWithSectionAndRT(String strStatusType, String strStatusTypeName, String strStatusDescription, String strSectionName, String strResourceTypeValue) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectSectionName(strSectionName);
		this.selectResourceType(strResourceTypeValue);
		this.clickOnSaveButton();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify subresource text for a resource type.
	 * Date        : 12/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public StatusTypeList verSubresourceTextForRT(String strResourceTypeValue,
			String strResourceTypeName) throws Exception {
		boolean blnRt = false;
		objWaitForElement.waitForElements("//div[@id='mainContainer']/form/table/tbody/tr[23]/td[2]",
				"xpath");
		String[] resourceTypeName = this.page
				.dynamicElement(
						"ResourceTypeName",
						"//div[@id='mainContainer']/form/table/tbody/tr[23]/td[2]",
						"xpath").getOne().getText().split("\n");
		for (int i = 0; i < resourceTypeName.length; i++) {
			if (resourceTypeName[i].equals(strResourceTypeName
					+ " (sub-resource)"))
			{
				blnRt = true;
				break;
			}
		}
		assertEquals(blnRt, true);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select status reason 
	 * Arguments	: strReasonVal
	 * Date        : 15/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList selectStatusReason(String strReasonVal)
			throws Exception {
		objWaitForElement.waitForElements(
				"//input[@value='" + strReasonVal
				+ "'][@name='statusReasonID']", "xpath");
		this.page
		.element(
				"//input[@value='" + strReasonVal
				+ "'][@name='statusReasonID']", "xpath")
				.getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select status reason while creating status.
	 * Arguments	: strReasonVal
	 * Date        : 15/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList selectStatusReasonForStatus(String strReasonVal)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strReasonVal
				+ "'][@name='status_reason_id']", "xpath");
		this.page
		.element(
				"//input[@value='" + strReasonVal
				+ "'][@name='status_reason_id']", "xpath")
				.getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select status reason while creating status.
	 * Arguments	: strReasonVal
	 * Date        : 15/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList editStatusForMultiStatusType(String strStatus)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
				+ strStatus
				+ "']/preceding-sibling::td/a[text()='Edit']",
				"xpath");
		this.page
		.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
						+ strStatus
						+ "']/preceding-sibling::td/a[text()='Edit']",
				"xpath").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on statuses link of status type.
	 * Date        : 15/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList clickOnStatusesOfStatusType(String strStatusType)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
				+ strStatusType
				+ "']/preceding-sibling::td/a[text()='statuses']",
				"xpath");
		this.page
		.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
						+ strStatusType
						+ "']/preceding-sibling::td/a[text()='statuses']",
				"xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Standard Status Type
	 * Date        : 15/06/2014
	 * Author      : Sinchana
	 **********************************************************************************/
	public StatusTypeList selectStandardStatusTypename(
			String strStandardStatusTypename) throws Exception {
		objWaitForElement.waitForElements(strStandardStatusType, "css");
		assertTrue(this.page.element(strStandardStatusType, "css").isElementPresent());
		this.page.element(strStandardStatusType, "css")
		.webElementToSelect()
		.selectByVisibleText(strStandardStatusTypename);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create status type by selecting standard status type
	 * Date   : 15/06/2014
	 * Author  : Sinchana
	 **********************************************************************************/
	public StatusTypeList createStatusTypeWithStdStatusType(String strStatusType, String strStatusTypeName, 
			String strStatusDescription, String strStandardStatusTypename) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectStandardStatusTypename(strStandardStatusTypename);
		this.selectSectionName("No Section Assigned");
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to fetch standard status value
	 * Date   : 15/09/2014
	 * Author  : Sinchana
	 **********************************************************************************/
	public String getStandardStatusValue(String strStandardStatusTypename) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr/td/select/option[text()='"+
				strStandardStatusTypename + "']", "xpath");
		String strStdStatValue = this.page.dynamicElement("StandardStatusTypename", "//div[@id='mainContainer']//table/tbody/tr/td/select/option[text()='"+
				strStandardStatusTypename + "']", "xpath").getOne().getAttribute("value");

		return strStdStatValue;
	}
	/**********************************************************************
	 * Description : This function is to deselect resource type
	 * Date        : 16/Sep/2014
	 * Author      : Anitha
	 **********************************************************************/	
	public StatusTypeList deSelectResourceType(String strResourceTypeValue)
			throws Exception {
		objWaitForElement.waitForElements("input[name='selectedRT'][value='"
				+ strResourceTypeValue + "']", "css");
		if (this.page
				.dynamicElement(
						"Resourcetype",
						"input[name='selectedRT'][value='"
								+ strResourceTypeValue + "']", "css").getOne()
								.isSelected()) {
			this.page
			.dynamicElement(
					"Resourcetype",
					"input[name='selectedRT'][value='"
							+ strResourceTypeValue + "']", "css")
							.getOne().click();
		}
		return this;
	}

	/**********************************************************************
	 * Description : 
	 * Date        : 16/Sep/2014
	 * Author      : 
	 **********************************************************************/	
	public StatusTypeList clickOnRadioBtn() throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr/td[text()='Any date should be accepted']/input[1]",
				"xpath");
		this.page
		.element(
				"//div[@id='mainContainer']//table/tbody/tr/td[text()='Any date should be accepted']/input[1]",
				"xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create status type
	 * Arguments 	: driver
	 * Date   		: 11/06/2014
	 * Author  	: Anil
	 **********************************************************************************/
	public StatusTypeList createDateStatusType(String strStatusType, String strStatusTypeName, String strStatusDescription) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.clickOnRadioBtn();
		this.selectSectionName("No Section Assigned");
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to verify 'Any Date should accepted' option is selected by default.
	 * Arguments 		: None
	 * Date   			: 11/06/2014
	 * Author  		: Sangappa
	 **********************************************************************************/
	public StatusTypeList verifyAnyDateShouldAcceptedIsSelected() throws Exception {
		objWaitForElement.waitForElements(anyDateShouildPresentradiobutton, "css");
		assertTrue(this.page.element(anyDateShouildPresentradiobutton, "css").getOne().isSelected(),
				"Not Any date should be accepted");
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to select date range between radio button
	 * Arguments 		: None
	 * Date   			: 11/07/2014
	 * Author  		: Renushree
	 **********************************************************************************/
	public StatusTypeList selectDateRangeBetween() throws Exception {
		objWaitForElement.waitForElements(dateRangeBetweenRadioBtn, "css");
		assertTrue(this.page.element(dateRangeBetweenRadioBtn, "css").isElementPresent(),
				"Date range between radio button is not present.");
		this.page.element(dateRangeBetweenRadioBtn, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to enter date in from field.
	 * Arguments 		: None
	 * Date   			: 11/07/2014
	 * Author  		: Renushree
	 **********************************************************************************/
	public StatusTypeList enterDateFrom(String strDateFrom) throws Exception {
		objWaitForElement.waitForElements(dateRangeFromField, "css");
		this.page.element(dateRangeFromField, "css").getOne().sendKeys(strDateFrom);
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to enter date in to field.
	 * Arguments 		: None
	 * Date   			: 11/07/2014
	 * Author  		: Renushree
	 **********************************************************************************/
	public StatusTypeList enterDateTo(String strDateTo) throws Exception {
		objWaitForElement.waitForElements(dateRangeToField, "css");
		this.page.element(dateRangeToField, "css").getOne().sendKeys(strDateTo);
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to enter date in to field.
	 * Arguments 		: None
	 * Date   			: 11/07/2014
	 * Author  		: Renushree
	 **********************************************************************************/
	public StatusTypeList selectDateRange(String strDateFrom, String strDateTo) throws Exception {
		this.selectDateRangeBetween();
		this.enterDateFrom(strDateFrom);
		this.enterDateTo(strDateTo);
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to fetch Status value
	 * Date		: 08/07/2014
	 * Author		: Anil
	 **********************************************************************************/
	public String getMSTStatusesValue(String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements("//tr/td[2][text()='"
				+ strStatusTypeName + "']/parent::tr/td[1]/a", "xpath");
		String strStatValue = this.page.dynamicElement("StatusTypeName", "//tr/td[2][text()='"
				+ strStatusTypeName + "']/parent::tr/td[1]/a", "xpath").getOne().getAttribute("href");

		String strResValueArr[] = strStatValue.split("statusID=");
		strStatValue = strResValueArr[1];			   
		return strStatValue;
	}

	/**********************************************************************************
	 * Description : This function is to create statuses for Multi status type
	 * Date		: 08/07/2014
	 * Author		: Anil
	 **********************************************************************************/	
	public StatusTypeList createMultiStatusTypesWithExpirationTime(String strStatusName, String strExpitationTimeInMin) throws Exception {
		this.clickOnCreateNewStatus();
		this.enterStatusName(strStatusName);
		this.selectEventExpirationOption();
		this.selectExpirationMinute(strExpitationTimeInMin);
		this.clickOnSaveButton();		
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create shared status type with section
	 * Arguments   : driver
	 * Date        : 06/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList createSharedStatusTypeWithSectionAndRT(
			String strStatusType, String strStatusTypeName,
			String strStatusDescription, String strSectionName, String strResourceTypeValue)
					throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectSharedStatusTypeRadioBtn();
		this.selectSectionName(strSectionName);
		this.selectResourceType(strResourceTypeValue);
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create Shared Status Type with expiration time in minutes
	 * Date        : 10/11/2014
	 * Author      : Renushree
	 **********************************************************************************/	
	public StatusTypeList createSharedStatusTypeWithExpirationTimeAndSection(String strStatusType,  String strStatusTypeName, String strStatusDescription, String strSection, String strExpitationTimeInMin) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectSharedStatusTypeRadioBtn();
		this.selectEventExpirationOption();
		this.selectExpirationMinute(strExpitationTimeInMin);
		this.selectSectionName(strSection);
		this.clickOnSaveButton();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to create shared status type with section
	 * Arguments   : driver
	 * Date        : 06/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList createEventOnlySharedStatusTypeWithSectionAndRT(
			String strStatusType, String strStatusTypeName,
			String strStatusDescription, String strSectionName, String strResourceTypeValue)
					throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectSharedStatusTypeRadioBtn();
		this.selectEventOnlyOption();
		this.selectSectionName(strSectionName);
		this.selectResourceType(strResourceTypeValue);
		this.clickOnSaveButton();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify CreateStatus Page is displayed
	 * Date        : 09/06/2014
	 * Author     : Anil
	 **********************************************************************************/
	public StatusTypeList verifyCreateStatusPage(String strMultiStatusType)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Status List for "
				+ strMultiStatusType + "']", "xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Status List for "
								+ strMultiStatusType + "']", "xpath").getOne()
								.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify CreateStatus Page is displayed
	 * Date        : 09/06/2014
	 * Author     : Anil
	 **********************************************************************************/
	public StatusTypeList verifyCreateNewStatusPage()
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Create New Status']", "xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Create New Status']", "xpath").getOne()
						.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on create new status button
	 * Arguments	: strStatusName
	 * Date        : 06/08/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public StatusTypeList enterStatusNameOneChar(String strStatusName) throws Exception {
		objWaitForElement.waitForElements(statusName, "name");
		this.page.element(statusName, "name").getOne().sendKeys(strStatusName);
		return this;
	}

	/**********************************************************************************
	 * Description : This function click on past date only radio button
	 * Date        : 05/12/2014
	 * Author      : sangappa.k
	 **********************************************************************************/
	public StatusTypeList clickOnPastDateOnlyRadioButton() throws Exception {
		objWaitForElement.waitForElements(datePastDatesOnly, "xpath");
		this.page.element(datePastDatesOnly, "xpath").getOne().click();
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to deselect the active check box
	 * Date        : 09/06/2014
	 * Author     : Anil
	 **********************************************************************************/

	public StatusTypeList deselectActiveCheckBox() throws Exception
	{
		objWaitForElement.waitForElements(AcitveChkBox, "name");
		// if( this.page.element(AcitveChkBox, "name").getOne().isSelected()==true){
		this.page.element(AcitveChkBox, "name").getOne().click();
		// }
		return this;	  
	}

	/**********************************************************************************
	 * Description : This function is to select the active scheck box
	 * Date        : 09/06/2014
	 * Author     : Anil
	 **********************************************************************************/		
	public StatusTypeList selectActiveCheckBox() throws Exception
	{objWaitForElement.waitForElements(AcitveChkBox, "name");
	if( this.page.element(AcitveChkBox, "name").getOne().isSelected()==false){
		this.page.element(AcitveChkBox, "name").getOne().click();
	}
	return this;	  
	}


	/**********************************************************************************
	 * Description : This function is to select the active check box
	 * Date        : 09/06/2014
	 * Author     : Anil
	 **********************************************************************************/		
	public StatusTypeList selectInactiveStatusTypesCheckBox() throws Exception
	{objWaitForElement.waitForElements(inactiveStatusTypes, "name");
	if( this.page.element(inactiveStatusTypes, "name").getOne().isSelected()==false){
		this.page.element(inactiveStatusTypes, "name").getOne().click();
	}
	return this;	  
	}

	/**********************************************************************************
	 * Description : This function is to create status type by selecting status reason
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList createStatusTypeWithReason(String strStatusType, String strStatusTypeName, String strStatusDescription, String[] strReasonValue) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		for(int intCount = 0; intCount<strReasonValue.length; intCount++){
			this.selectStatusReason(strReasonValue[intCount]);
		}
		this.selectSectionName("No Section Assigned");
		this.clickOnSaveButton();
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to create shared status type
	 * Arguments   : driver
	 * Date        : 06/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList createPrivateStatusTypeWithReason(String strStatusType,
			String strStatusTypeName, String strStatusDescription, String[] strReasonValue)
					throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectPrivateStatusTypeRadioBtn();
		for(int intCount = 0; intCount<strReasonValue.length; intCount++){
			this.selectStatusReason(strReasonValue[intCount]);
		}
		this.selectSectionName("No Section Assigned");
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create shared status type
	 * Arguments   : driver
	 * Date        : 06/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList createSharedStatusTypeWithReason(String strStatusType,
			String strStatusTypeName, String strStatusDescription, String[] strReasonValue)
					throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectSharedStatusTypeRadioBtn();
		for(int intCount = 0; intCount<strReasonValue.length; intCount++){
			this.selectStatusReason(strReasonValue[intCount]);
		}
		this.selectSectionName("No Section Assigned");
		this.clickOnSaveButton();
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to create new status
	 * Date        : 06/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList createNewStatusWithReason(String strStatusName, String strStatuscolor, String[] strReasonValue) throws Exception {
		this.clickOnCreateNewStatus();
		this.enterStatusName(strStatusName);
		this.selectStatusColor(strStatuscolor);
		for(int intCount = 0; intCount<strReasonValue.length; intCount++){
			this.selectStatusReasonInStatuses(strReasonValue[intCount]);
		}
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select status reason 
	 * Arguments	: strReasonVal
	 * Date        : 15/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList selectStatusReasonInStatuses(String strReasonVal)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strReasonVal
				+ "'][@name='status_reason_id']", "xpath");
		this.page
		.element(
				"//input[@value='" + strReasonVal
				+ "'][@name='status_reason_id']", "xpath")
				.getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create 15 status type
	 * Arguments   : Null
	 * Date        : 31/12/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList verAndCreate15StatusTypes() throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[2]", "xpath");
		int intNoOfStatusType = this.page.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[2]", "xpath")
				.getXpathCount();
		if(intNoOfStatusType < 15){      
			for(int intCount = intNoOfStatusType; intCount<=15; intCount++){
				String strStatusTypeName = "Status"+intNoOfStatusType+System.currentTimeMillis();
				this.createStatusType(objStatusTypes_data.strTextStatusType, strStatusTypeName, objStatusTypes_data.strStatusDescription);
			}
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create 15 status type
	 * Arguments 	 : Null
	 * Date        : 31/12/2014
	 * Author      : Anil
	 **********************************************************************************/
	public String[] getStatusTypeNames() throws Exception {
		String strStatusTypeNames[]  = new String[15];
		for(int intCount = 1; intCount<16; intCount++){
			objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr["+intCount+"]/td[2]", "xpath");
			strStatusTypeNames[intCount - 1] = this.page.element(
					"//div[@id='mainContainer']/table[2]/tbody/tr["+intCount+"]/td[2]", "xpath").getOne().getText();
		}
		return strStatusTypeNames;
	}

	/**********************************************************************************
	 * Description : This function is to create 15 status type
	 * Arguments 	 : Null
	 * Date        : 31/12/2014
	 * Author      : Anil
	 **********************************************************************************/
	public String[] getMultiStatusTypeNames() throws Exception {
		String strStatusTypeNames[]  = new String[15];
		int intCount1 = 0;
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='Multi']/preceding-sibling::td[1]", "xpath");
		int intNoOfStatusType = this.page.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='Multi']/preceding-sibling::td[1]", "xpath")
				.getXpathCount();
		this.driver
		.manage()
		.timeouts()
		.implicitlyWait(0,
				TimeUnit.SECONDS);
		for(int intCount = 1; intCount<intNoOfStatusType; intCount++){
			if(this.page.element(
					"//div[@id='mainContainer']/table[2]/tbody/tr["+intCount+"]/td[3][text()='Multi']", "xpath").isElementPresent() == true){
				strStatusTypeNames[intCount1] = this.page.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr["+intCount+"]/td[2]", "xpath").getOne().getText();
				intCount1++;
				if(intCount1==15){
					break;
				}
			}
		}
		this.driver
		.manage()
		.timeouts()
		.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
				TimeUnit.SECONDS);
		return strStatusTypeNames;
	}


	/**********************************************************************************
	 * Description : This function is to create 15 status type
	 * Arguments   : Null
	 * Date        : 31/12/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList verAndCreate15MultiStatusTypes() throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='Multi']/preceding-sibling::td[1]", "xpath");
		int intNoOfStatusType = this.page.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='Multi']/preceding-sibling::td[1]", "xpath")
				.getXpathCount();
		if(intNoOfStatusType < 15){      
			for(int intCount = intNoOfStatusType; intCount<=15; intCount++){
				String strStatusTypeName = "Status"+intNoOfStatusType+System.currentTimeMillis();
				this.createStatusType(objStatusTypes_data.strMultiStatusType, strStatusTypeName, objStatusTypes_data.strStatusDescription);
				this.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor);
				this.clickOnReturnToStatusTypeList();
			}
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on edit link of resource type.
	 * Date        : 27/03/2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public StatusTypeList clickOnEditOfResourceType(String strResourceType)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
				+ strResourceType
				+ "']/preceding-sibling::td/a[text()='Edit']",
				"xpath");
		this.page
		.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
						+ strResourceType
						+ "']/preceding-sibling::td/a[text()='Edit']",
				"xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select the active check box
	 * Date        : 27/03/2015
	 * Author      : Hanumegowda
	 **********************************************************************************/		
	public StatusTypeList selectInactiveResourceTypesCheckBox() throws Exception
	{
		objWaitForElement.waitForElements(inactiveResourceTypes, "name");
		if( this.page.element(inactiveResourceTypes, "name").getOne().isSelected()==false){
			this.page.element(inactiveResourceTypes, "name").getOne().click();
		}
		return this;	  
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Standerd Status Type' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList clickStanderdStatusTypeButton() throws Exception {
		objWaitForElement.waitForElements(standardStatusTypeLabels, "css");
		this.page.element(standardStatusTypeLabels, "css").getOne().click();
		return this;
	}
	/************************************************************************************
	 * Description : This function is to verify standard status type labels are editable.
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList verStdStatusTypeLabelsNotEditable(
			String strStdTypeLabel) throws Exception {
		objWaitForElement
		.waitForElements(
				"//table/tbody/tr/td[text()='"
						+ strStdTypeLabel
						+ "']/following-sibling::td/input[@disabled='disabled']",
				"xpath");
		assertTrue(this.page
				.element(
						"//table/tbody/tr/td[text()='"
								+ strStdTypeLabel
								+ "']/following-sibling::td/input[@disabled='disabled']",
						"xpath").isElementPresent());
		return this;
	}

	/****************************************************************************************
	 * Description : This function is to verify standard status type labels are Not editable.
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 ***************************************************************************************/
	public StatusTypeList verStdStatusTypeLabelsIsEditable(
			String strStdTypeLabel) throws Exception {
		assertFalse(this.page
				.element(
						"//table/tbody/tr/td[text()='"
								+ strStdTypeLabel
								+ "']/following-sibling::td/input[@disabled='disabled']",
						"xpath").isElementPresent(
								WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************************
	 * Description : This function is to verify View Standard Status Type Labels Page is displayed
	 * Date        : 09/06/2014
	 * Author     : Anil
	 **********************************************************************************************/
	public StatusTypeList verifyViewStandardStatusTypeLabelsPage()
			throws Exception {
		objWaitForElement
		.waitForElements(
				"//div[@id='topSubNav']/h1[text()='View Standard Status Type Labels']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='View Standard Status Type Labels']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Status Type List Page is displayed
	 * Date        : 09/06/2014
	 * Author     : Anil
	 *****************************************************************************/
	public StatusTypeList verifyStatusTypeListPage()
			throws Exception {
		objWaitForElement
		.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Status Type List']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Status Type List']",
						"xpath").getOne().isDisplayed());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on 'Next' button
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList clickBackButton() throws Exception {
		objWaitForElement.waitForElements(backButton, "css");
		this.page.element(backButton, "css").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on 'Cancel' button
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList clickCancelButton() throws Exception {
		objWaitForElement.waitForElements(cancelButton, "css");
		this.page.element(cancelButton, "css").getOne().click();
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to create shred status type with Event
	 * Arguments   : driver
	 * Date        : 06/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public StatusTypeList createSharedStatusTypeWithEvent(String strStatusType,
			String strStatusTypeName, String strStatusDescription)
					throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectEventOnlyOption();
		this.selectSharedStatusTypeRadioBtn();
		this.clickOnSaveButton();
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Select Status Type Page is displayed
	 * Date        : 18/May/2015
	 * Author      : Renushree
	 *****************************************************************************/
	public StatusTypeList verifySelectStatusTypePage()
			throws Exception {
		objWaitForElement
		.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Select Status Type']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Select Status Type']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Create Number Status Type Page is displayed
	 * Date        : 18-May-2015
	 * Author      : Pallavi
	 *****************************************************************************/
	public StatusTypeList verifyCreateNumberStatusTypePage() throws Exception {
		objWaitForElement.waitForElements(header, "xpath");
		assertEquals(this.page.element(header, "xpath").getOne().getText(),
				"Create Number Status Type");
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Create Multi Status Type Page is displayed
	 * Date        : 18/May/2015
	 * Author      : Renushree
	 *****************************************************************************/
	public StatusTypeList verifyCreateMultiStatusTypePage()
			throws Exception {
		objWaitForElement
		.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Create Multi Status Type']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Create Multi Status Type']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Action column for multi status type
	 * Arguments   : strStatusTypeName
	 * Date        : 18/May/2015
	 * Author      : Renushree
	 *****************************************************************************/
	public StatusTypeList verifyActionColumnForMultiST(String strStatusTypeName)
			throws Exception {
		objWaitForElement
		.waitForElements(
				"//table[@summary='Status Types']/thead/tr/th[1][text()='Action']/parent::tr/parent::thead/following-sibling::tbody/tr/td[2][text()='"
						+ strStatusTypeName
						+ "']/preceding-sibling::td[1]/a[1][text()='edit']",
				"xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Status Types']/thead/tr/th[1][text()='Action']/parent::tr/parent::thead/following-sibling::tbody/tr/td[2][text()='"
								+ strStatusTypeName
								+ "']/preceding-sibling::td[1]/a[1][text()='edit']",
						"xpath").getOne().isDisplayed());
		assertTrue(this.page
				.element(
						"//table[@summary='Status Types']/thead/tr/th[1][text()='Action']/parent::tr/parent::thead/following-sibling::tbody/tr/td[2][text()='"
								+ strStatusTypeName
								+ "']/preceding-sibling::td[1]/a[2][text()='statuses']",
						"xpath").getOne().isDisplayed());
		assertTrue(this.page
				.element(
						"//table[@summary='Status Types']/thead/tr/th[1][text()='Action']/parent::tr/parent::thead/following-sibling::tbody/tr/td[2][text()='"
								+ strStatusTypeName
								+ "']/preceding-sibling::td[1]/a[3][text()='sort']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Name column for status type
	 * Date        : 18/May/2015
	 * Author      : Renushree
	 *****************************************************************************/
	public StatusTypeList verifyNameColumnForST(String strStatusTypeName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Status Types']/tbody/tr/td[2][text()='"
						+ strStatusTypeName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Status Types']/thead/tr/th[2]/a[text()='Name']/parent::th/parent::tr/parent::thead/following-sibling::tbody/tr/td[2][text()='"
								+ strStatusTypeName + "']", "xpath").getOne()
								.isDisplayed());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Type column for status type
	 * Date        : 18/May/2015
	 * Author      : Renushree
	 *****************************************************************************/
	public StatusTypeList verifyTypeColumnForST(String strStatusTypeType, String strStatusTypeName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Status Types']/tbody/tr/td[2][text()='"
						+ strStatusTypeName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Status Types']/thead/tr/th[3]/a[text()='Type']/parent::th/parent::tr/parent::thead/following-sibling::tbody/tr/td[2][text()='" + strStatusTypeName + "']/following-sibling::td[1][text()='" + strStatusTypeType + "']", "xpath").getOne().isDisplayed());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Section column for status type
	 * Date        : 18/May/2015
	 * Author      : Renushree
	 *****************************************************************************/
	public StatusTypeList verifySectionColumnForST(String strSection,
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Status Types']/tbody/tr/td[2][text()='"
						+ strStatusTypeName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Status Types']/thead/tr/th[6]/a[text()='Section']/parent::th/parent::tr/parent::thead/following-sibling::tbody/tr/td[2][text()='"
								+ strStatusTypeName
								+ "']/following-sibling::td[4][text()='"
								+ strSection + "']", "xpath").getOne()
								.isDisplayed());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Description column for status type
	 * Date        : 18/May/2015
	 * Author      : Renushree
	 *****************************************************************************/
	public StatusTypeList verifyDescriptionColumnForST(String strDescription,
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Status Types']/tbody/tr/td[2][text()='"
						+ strStatusTypeName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Status Types']/thead/tr/th[7]/a[text()='Description']/parent::th/parent::tr/parent::thead/following-sibling::tbody/tr/td[2][text()='"
								+ strStatusTypeName
								+ "']/following-sibling::td[5][text()='"
								+ strDescription + "']", "xpath").getOne()
								.isDisplayed());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to select trace user checkbox
	 * Date        : 18/May/2015
	 * Author      : Renushree
	 *****************************************************************************/
	public StatusTypeList selTraceUserchkBox() throws Exception {
		if (this.page.element(traceUser, "css").getOne().isSelected() == false) {
			this.page.element(traceUser, "css").getOne().click();
		}
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify 'Event Only?' column for status type
	 * Date        : 18-May-2015
	 * Author      : Pallavi
	 *****************************************************************************/
	public StatusTypeList verifyEventOnlyColumnForST(String strStatusTypeName,
			String strEventOnlyYesOrNo) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Status Types']/tbody/tr/td[2][text()='"
						+ strStatusTypeName + "']", "xpath");
		assertEquals(
				this.page
				.element(
						"//table[@summary='Status Types']/tbody/tr/td[2][text()='"
								+ strStatusTypeName
								+ "']/following-sibling::td[2][text()='"
								+ strEventOnlyYesOrNo
								+ "']/parent::tr/parent::tbody/preceding-sibling::thead/tr/th[4]/a",
						"xpath").getOne().getText(), "Event Only?");
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify 'Standard Type' column for status type
	 * Date        : 18-May-2015
	 * Author      : Pallavi
	 *****************************************************************************/
	public StatusTypeList verifyStandardTypeColumnForST(
			String strStatusTypeName, String strStandardStatusType)
					throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Status Types']/tbody/tr/td[2][text()='"
						+ strStatusTypeName + "']", "xpath");
		String strStandardST = this.page.element("//table[@summary='Status Types']/tbody/tr/td[2][text()='"
				+ strStatusTypeName
				+ "']/following-sibling::td[3]","xpath").getOne().getText();
		assertEquals(strStandardST, strStandardStatusType);
		assertEquals(
				this.page
				.element(
						"//table[@summary='Status Types']/thead/tr/th[5]/a",
						"xpath").getOne().getText(), "Standard Type");
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify 'Statuses' column for status type
	 * Date        : 18-May-2015
	 * Author      : Pallavi
	 *****************************************************************************/
	public StatusTypeList verifyStatusesColumnForST(String strStatusTypeName,
			String strStatusTypeType, String strStatusName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Status Types']/tbody/tr/td[2][text()='"
						+ strStatusTypeName + "']", "xpath");
		if (strStatusTypeType.equals("Multi")) {
			assertTrue(this.page
					.element(
							"//table[@summary='Status Types']/tbody/tr/td[2][text()='"
									+ strStatusTypeName
									+ "']/following-sibling::td[6]/font[text()='"
									+ strStatusName
									+ "']/ancestor::tbody/preceding-sibling::thead/tr/th[8][text()='Statuses']",
							"xpath").isElementPresent());
		} else {
			assertFalse(this.page.element(
					"//table[@summary='Status Types']/tbody/tr/td[2][text()='"
							+ strStatusTypeName
							+ "']/following-sibling::td[6]/font", "xpath")
							.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
			assertTrue(this.page
					.element(
							"//table[@summary='Status Types']/tbody/tr/td[2][text()='"
									+ strStatusTypeName
									+ "']/following-sibling::td[6]/ancestor::tbody/preceding-sibling::thead/tr/th[8][text()='Statuses']",
							"xpath").isElementPresent());
		}
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify 'Action' column for Number and Text 
	 * 				 status type
	 * Date        : 18-May-2015
	 * Author      : Pallavi
	 *****************************************************************************/
	public StatusTypeList verifyActionColumnForNumberAndTextST(
			String strStatusTypeName, String strStatusTypeType) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Status Types']/tbody/tr/td[2][text()='"
						+ strStatusTypeName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Status Types']/tbody/tr/td[2][text()='"
								+ strStatusTypeName
								+ "']/preceding-sibling::td[1]/a[text()='edit']/ancestor::tbody/preceding-sibling::thead/tr/th[1][text()='Action']",
						"xpath").isElementPresent());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Create text Status Type Page is displayed
	 * Date        : 18-May-2015
	 * Author      : Anil
	 *****************************************************************************/
	public StatusTypeList verifyCreateTextStatusTypePage() throws Exception {
		objWaitForElement.waitForElements(header, "xpath");
		assertEquals(this.page.element(header, "xpath").getOne().getText(),
				"Create Text Status Type");
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Create Saturation score Status Type Page is displayed
	 * Date        : 19/May/2015
	 * Author      : Renushree
	 *****************************************************************************/
	public StatusTypeList verifyCreateSaturationStatusTypePage()
			throws Exception {
		objWaitForElement
		.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Create Saturation Score Status Type']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Create Saturation Score Status Type']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select status color
	 * Arguments	: strStatusName
	 * Date        : 24/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList selectStatusforStatus(String strStatusName) throws Exception {
		objWaitForElement.waitForElements(statusesName, "css");
		this.page.element(statusesName, "css").webElementToSelect().selectByVisibleText(strStatusName);
		return this;
	}	
	/**********************************************************************************
	 * Description : This function is to create Status Type with shift time in minutes
	 * Date        : 25/May/2015
	 * Author      : Renushree
	 **********************************************************************************/	
	public StatusTypeList createStatusTypeWithShiftTime(String strStatusType,  String strStatusTypeName, String strStatusDescription, String strShiftTimeInHour, String strShiftTimeInMin) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectShiftTime(strShiftTimeInHour, strShiftTimeInMin);
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to get event expiration time in minutes
	 * Arguments	: strShiftTimeInHour, strShiftTimeInMin
	 * Date        : 25/May/2015
	 * Author      : Renushree
	 **********************************************************************************/	
	public StatusTypeList selectShiftTime(String strShiftTimeInHour,
			String strShiftTimeInMin) throws Exception {
		objWaitForElement.waitForElements(shiftTime, "css");
		this.page.element(shiftTime, "css").getOne().click();
		this.page.element(shiftTimeHour, "css").webElementToSelect()
		.selectByVisibleText(strShiftTimeInHour);
		this.page.element(shifttimeMin, "css").webElementToSelect()
		.selectByVisibleText(strShiftTimeInMin);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select timer option
	 * Date        :11/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList selectTimerType(String strTimerOption) throws Exception {
		driver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME_SMALL,TimeUnit.SECONDS);
		objWaitForElement.waitForElements(timerType, "name");
		this.page.element(timerType, "name").webElementToSelect().selectByVisibleText(strTimerOption);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select status reason reuired check box
	 * Date        : 27/May/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList selectStatusReasonRequired() throws Exception {
		objWaitForElement.waitForElements(statusReasonrequired, "css");
		this.page.element(statusReasonrequired, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Roles with update rights check box
	 * Date        : 03-Jun-2015
	 * Author      : Pallavi
	 **********************************************************************************/
	public StatusTypeList selectRoleUnderRolesWithUpdateRight(String strRoleValue) throws Exception {
		String strWebElement = "//tr/td[text()='Roles with update rights:']/following-sibling::td/input[@value='"
				+ strRoleValue + "']";
		objWaitForElement.waitForElements(strWebElement, "xpath");
		if(this.page.element(strWebElement, "xpath").getOne().isSelected() == false){
			this.page.element(strWebElement, "xpath").getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Roles with view rights check box
	 * Date        : 03-Jun-2015
	 * Author      : Pallavi
	 **********************************************************************************/
	public StatusTypeList selectRoleUnderRolesWithViewRight(String strRoleValue) throws Exception {
		String strWebElement = "//tr/td[text()='Roles with view rights:']/following-sibling::td/input[@value='"
				+ strRoleValue + "']";
		objWaitForElement.waitForElements(strWebElement, "xpath");
		if(this.page.element(strWebElement, "xpath").getOne().isSelected() == false){
			this.page.element(strWebElement, "xpath").getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create new statuses with reason
	 * Date        : 06/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList createNewStatusWithStatusReason(String strStatusName, String strStatuscolor, String strReasonVal) throws Exception {
		this.clickOnCreateNewStatus();
		this.enterStatusName(strStatusName);
		this.selectStatusColor(strStatuscolor);
		this.selectStatusReasonForStatus(strReasonVal);
		this.clickOnSaveButton();
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to create status type with reason
	 * Arguments : driver
	 * Date   : 11/06/2014
	 * Author  : Anil
	 **********************************************************************************/
	public StatusTypeList createStatusTypeWithReason(String strStatusType, String strStatusTypeName, String strStatusDescription, String strReasonVal) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectStatusReason(strReasonVal);
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on sort link of status type.
	 * Date        : 08/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList clickOnSortOfStatusType(String strStatusType)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
				+ strStatusType
				+ "']/preceding-sibling::td/a[text()='sort']",
				"xpath");
		this.page
		.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
						+ strStatusType
						+ "']/preceding-sibling::td/a[text()='sort']",
				"xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify MST is sorted 
	 * Date        : 19/May/2015
	 * Author      : Anil
	 *****************************************************************************/
	public StatusTypeList verifyMSTStatusesSort(String strMSTName,String strStatusesName, String strStatusSort)
			throws Exception {
		objWaitForElement
		.waitForElements("//td[text()='"+strMSTName+"']/following-sibling::td[6]/font["+strStatusSort+"][text()='"+strStatusesName+"']",
				"xpath");
		assertTrue(this.page
				.element("//td[text()='"+strMSTName+"']/following-sibling::td[6]/font["+strStatusSort+"][text()='"+strStatusesName+"']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select statuses order
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList selectStatusesSortOrder(String strStatusesValue, String strOrder) throws Exception {
		objWaitForElement.waitForElements("sv"+strStatusesValue, "name");
		this.page.element("sv"+strStatusesValue, "name").webElementToSelect().selectByVisibleText(strOrder);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to navigate to select Exempt From Must Update
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList selectExemptFromMustUpdate() throws Exception {
		objWaitForElement.waitForElements(updateExempt, "name");
		this.page.element(updateExempt, "name").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select Roles with view rights check box
	 * Date        : 03-Jun-2015
	 * Author      : Anitha
	 **********************************************************************************/
	public StatusTypeList deSelectRoleUnderRolesWithViewRight() throws Exception {
		objWaitForElement.waitForElements(viewSelectAllChkBox, "css");
		if (this.page.element(viewSelectAllChkBox, "css").getOne()
				.isSelected() == true) {
			this.page.element(viewSelectAllChkBox, "css").getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Roles with view rights check box
	 * Date        : 03-Jun-2015
	 * Author      : Anitha
	 **********************************************************************************/
	public StatusTypeList deSelectRoleUnderRolesWithUpdateRight() throws Exception {
		objWaitForElement.waitForElements(updateSelectAllChkBox, "css");
		if (this.page.element(updateSelectAllChkBox, "css").getOne()
				.isSelected() == true) {
			this.page.element(updateSelectAllChkBox, "css").getOne().click();
		}
		return this;
	}
	/*****************************************************************************
	 * Description : This function is to verify 'Status Type' column for status type
	 * Date        : 18-May-2015
	 * Author      : Pallavi
	 *****************************************************************************/
	public StatusTypeList verifyStatusTypeInList(String strStatusTypeName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
						+ strStatusTypeName + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
						+ strStatusTypeName + "']", "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify NEDOCS text is selected
	 * Date        : 09/06/2015
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList verifynedocsTextDisplayIsSelected() throws Exception {
		objWaitForElement.waitForElements(nedocsTextDisplay, "css");
		this.page.element(nedocsTextDisplay, "css").getOne().isSelected();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create 15 status type
	 * Arguments   : Null
	 * Date        : 31/12/2014
	 * Author      : Anil
	 **********************************************************************************/
	public int getStatusTypeCount() throws Exception {

		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[2]", "xpath");
		int intNoOfStatusType = this.page.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[2]", "xpath")
				.getXpathCount();
		return intNoOfStatusType;
	}

	/**********************************************************************************
	 * Description : This function is to create 15 status type
	 * Arguments 	 : Null
	 * Date        : 31/12/2014
	 * Author      : Anil
	 **********************************************************************************/
	public String[] getStatusTypeNames(int intCount1) throws Exception {
		String strStatusTypeNames[]  = new String[intCount1];
		for(int intCount = 1; intCount<intCount1+1; intCount++){
			objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr["+intCount+"]/td[2]", "xpath");
			strStatusTypeNames[intCount - 1] = this.page.element(
					"//div[@id='mainContainer']/table[2]/tbody/tr["+intCount+"]/td[2]", "xpath").getOne().getText();
		}
		return strStatusTypeNames;
	}

	/**********************************************************************************
	 * Description : This function is to verify Status Type Visibility Option IS Enabled
	 * Date        : 06/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList verifyStatusTypeVisibilityOptionISEnabled() throws Exception {
		objWaitForElement.waitForElements(privateStatusType, "css");
		assertTrue(this.page.element(privateStatusType, "css").getOne().isEnabled());
		assertTrue(this.page.element(sharedStatusType, "css").getOne().isEnabled());
		assertTrue(this.page.element(roleBasedStatusType, "css").getOne().isEnabled());
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to verify on role bases Status Type radio button
	 * Date        : 06/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList verifyRoleBasedStatusTypes() throws Exception {
		objWaitForElement.waitForElements(roleBasedStatusType, "css");
		assertTrue(this.page.element(roleBasedStatusType, "css").getOne().isSelected());
		return this;
	}	

	/*****************************************************************************
	 * Description : This function is to verify Create NEDOCS Calculation Status Type Page is displayed
	 * Date        : 18/May/2015
	 * Author      : Anil
	 *****************************************************************************/
	public StatusTypeList verifyCreateNedocStatusTypePage()
			throws Exception {
		objWaitForElement
		.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Create NEDOCS Calculation Status Type']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Create NEDOCS Calculation Status Type']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Edit Multi Status Type Page is displayed
	 * Date        : 18/May/2015
	 * Author      : Anil
	 *****************************************************************************/
	public StatusTypeList verifyEditMultiStatusTypePage()
			throws Exception {
		objWaitForElement
		.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Edit Multi Status Type']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Edit Multi Status Type']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Edit number Status Type Page is displayed
	 * Date        : 18/May/2015
	 * Author      : Anil
	 *****************************************************************************/
	public StatusTypeList verifyEditNumberStatusTypePage()
			throws Exception {
		objWaitForElement
		.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Edit Number Status Type']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Edit Number Status Type']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Edit number Status Type Page is displayed
	 * Date        : 18/May/2015
	 * Author      : Anil
	 *****************************************************************************/
	public StatusTypeList verifyEditNedocStatusTypePage()
			throws Exception {
		objWaitForElement
		.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Edit NEDOCS Calculation Status Type']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Edit NEDOCS Calculation Status Type']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify Edit Saturation Score Status Type Page is displayed
	 * Date        : 18/May/2015
	 * Author      : Anil
	 *****************************************************************************/
	public StatusTypeList verifyEditSaturationStatusTypePage()
			throws Exception {
		objWaitForElement
		.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Edit Saturation Score Status Type']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Edit Saturation Score Status Type']",
						"xpath").getOne().isDisplayed());
		return this;
	}



	/*****************************************************************************
	 * Description : This function is to verify Edit text Status Type Page is displayed
	 * Date        : 18/May/2015
	 * Author      : Anil
	 *****************************************************************************/
	public StatusTypeList verifyEditTextStatusTypePage()
			throws Exception {
		objWaitForElement
		.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Edit Text Status Type']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Edit Text Status Type']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/*****************************************************************************
	 * Description : This function is to verify 'Status Type' is not displayed
	 * Date        : 18-May-2015
	 * Author      : Anil
	 *****************************************************************************/
	public StatusTypeList verifyStatusTypeIsNotListed(String strStatusTypeName)
			throws Exception {
		assertFalse(this.page.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[2][text()='"
						+ strStatusTypeName + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on edit link of status type.
	 * Date        : 08/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public StatusTypeList clickOnEditOfFirstStatusType() throws Exception {
		objWaitForElement
		.waitForElements(
				"//div[@id='mainContainer']/table[2]/tbody/tr[1]/td[1]/a[text()='edit']",
				"xpath");
		this.page
		.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr[1]/td[1]/a[text()='edit']",
				"xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify RoleName is displayed in Edit User Page
	 * Date        : 26/09/2014
	 * Author      : Prasanna Lakshmi
	 **********************************************************************************/
	public StatusTypeList verifyRoleNameIsNotListed(String strRoleValues)
			throws Exception {
		assertFalse(this.page.dynamicElement("strRoleValues",
				"//input[@value='" + strRoleValues + "'][@name='roleView']",
				"xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to  deselect  'Display NEDOCS labels' checkbox while creating Nedocs St
	 * Date        : 25/01/2016
	 * Author      : Sangappa K
	 **********************************************************************************/
	public StatusTypeList deselectDisplayNEDOCSLabelCheckbox() throws Exception {
		objWaitForElement.waitForElements(nedocsTextDisplay, "css");
		if(this.page.element(nedocsTextDisplay, "css").getOne().isSelected());
		{
			this.page.element(nedocsTextDisplay, "css").getOne().click();
		}
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to  enter the status type and select standard status type
	 * Date        : 25/01/2016
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList enterStatusTypesSelectingStdStatusType(String strStatusType, String strStatusTypeName, String strDescription, String strStandardStatusTypeName) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strDescription);
		this.selectStandardStatusTypename(strStandardStatusTypeName);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create event status type with section
	 * Arguments 	: driver
	 * Date       	: 09/09/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList createSharedEventStatusTypeWithSection(String strStatusType, String strStatusTypeName, 
			String strStatusDescription, String strSection) throws Exception {
		this.clickCreateNewStatusTypeButton();
		this.selectStatusType(strStatusType);
		this.clickNextButton();
		this.enterStatusTypeName(strStatusTypeName);
		this.enterStatusTypeDescription(strStatusDescription);
		this.selectSharedStatusTypeRadioBtn();
		this.selectEventOnlyOption();
		this.selectSectionName(strSection);
		this.clickOnSaveButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select the active scheck box
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/		
	public StatusTypeList verifyActiveCheckBoxIsDisabled() throws Exception {
		objWaitForElement.waitForElements(AcitveChkBox, "name");
		assertTrue(this.page.element(AcitveChkBox, "name").getOne().isEnabled() == false);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select the active scheck box
	 * Date        : 09/06/2014
	 * Author      : Anitha
	 **********************************************************************************/		
	public StatusTypeList verifyActiveCheckBoxIsEnabled() throws Exception {
		objWaitForElement.waitForElements(AcitveChkBox, "name");
		assertTrue(this.page.element(AcitveChkBox, "name").getOne().isEnabled());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to deactivte status type
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList deActivateStatusType(String strStatusTypeName) throws Exception {
		this.clickOnEditOfStatusType(strStatusTypeName);	
		this.deselectActiveCheckBox();
		this.clickOnSaveButton();
		this.verifyStatusTypeIsNotListed(strStatusTypeName);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to reactivte status type
	 * Date        : 18-Feb-2016
	 * Author      : Pallavi
	 **********************************************************************************/
	public StatusTypeList reActivateStatusType(String strStatusTypeName) throws Exception {
		this.clickOnEditOfStatusType(strStatusTypeName);	
		this.selectActiveCheckBox();
		this.clickOnSaveButton();
		this.verifyStatusTypeInList(strStatusTypeName);
		return this;
	}

	/**********************************************************************************
	 * Description  : This function is to de-select the active check box for a ST
	 * Date         : 18-Feb-2016
	 * Author      : Pallavi
	 **********************************************************************************/		
	public StatusTypeList deSelectInactiveStatusTypesCheckBox()
			throws Exception {
		objWaitForElement.waitForElements(inactiveStatusTypes, "name");
		if (this.page.element(inactiveStatusTypes, "name").getOne()
				.isSelected()) {
			this.page.element(inactiveStatusTypes, "name").getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to  select  'Display NEDOCS labels' checkbox while creating Nedocs St
	 * Date        : 25/01/2016
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList selectDisplayNEDOCSLabelCheckbox() throws Exception {
		objWaitForElement.waitForElements(nedocsTextDisplay, "css");
		if(this.page.element(nedocsTextDisplay, "css").getOne().isSelected()==false)
		{
			this.page.element(nedocsTextDisplay, "css").getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Disabled is displayed under Active cloumn for inactive status types in Status Type List page
	 * Date 	   : 22/03/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public StatusTypeList verDisabledIsDisplayed(String strStatusTypeName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Status Types']/tbody/tr/td[text()='" + strStatusTypeName
				+ "']/following-sibling::td[1][text()='Disabled']",
				"xpath");
		assertTrue(this.page.element(
				"//table[@summary='Status Types']/tbody/tr/td[text()='" + strStatusTypeName
				+ "']/following-sibling::td[1][text()='Disabled']",
				"xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Active is displayed under Active cloumn for active status types in Status Type List page
	 * Date 	   : 22/03/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public StatusTypeList verActiveIsDisplayed(String strStatusTypeName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Status Types']/tbody/tr/td[text()='" + strStatusTypeName
				+ "']/following-sibling::td[1][text()='Active']",
				"xpath");
		assertTrue(this.page.element(
				"//table[@summary='Status Types']/tbody/tr/td[text()='" + strStatusTypeName
				+ "']/following-sibling::td[1][text()='Active']",
				"xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to  select  'Display Summary Totals	' checkbox while creating Nedocs St
	 * Date        : 25/01/2016
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList selectDisplaySummaryTotalsCheckBox() throws Exception {
		objWaitForElement.waitForElements(displaySummaryTotalsCheckBox, "name");
		if(this.page.element(displaySummaryTotalsCheckBox, "name").getOne().isSelected()==false)
		{
			this.page.element(displaySummaryTotalsCheckBox, "name").getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to  deselect  'Display Summary Totals	' checkbox while creating Nedocs St
	 * Date        : 25/01/2016
	 * Author      : Anil
	 **********************************************************************************/
	public StatusTypeList deselectDisplaySummaryTotalsCheckBox()
			throws Exception {
		objWaitForElement.waitForElements(displaySummaryTotalsCheckBox, "name");
		if (this.page.element(displaySummaryTotalsCheckBox, "name").getOne()
				.isSelected() == true) {
			this.page.element(displaySummaryTotalsCheckBox, "name").getOne()
					.click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on reorder statuses
	 * Date        : 28-Sept-2016
	 * Author      : Pallavi
	 **********************************************************************************/
	public StatusTypeList clickOnReorderStatuses() throws Exception {
		objWaitForElement.waitForElements(reorderStatuses, "css");
		this.page.element(reorderStatuses, "css").clickUsingJSE();
		objWaitForElement.waitForElements(doneReordering, "css");
		assertTrue(this.page.element(doneReordering, "css").isElementPresent(),
				doneReordering + " is not present.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to drag and drop stauses to reorder. 
	 * Date        : 28-Sept-2016
	 * Author      : Pallavi
	 **********************************************************************************/
	public StatusTypeList reorderStatuses(String status1, String status2) throws Exception {
		String sourceStatus = "//tr/td[text()='"+status1+"']";
		String destinationStatus = "//tr/td[text()='"+status2+"']";
		WebElement element = this.page.element(sourceStatus, "xpath").getOne();
		WebElement target = this.page.element(destinationStatus, "xpath").getOne();
		Actions move = new Actions(driver);
		Action action = move.dragAndDrop(element, target).build();
		action.perform();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Done re-ordering statuses
	 * Date        : 28-Sept-2016
	 * Author      : Pallavi
	 **********************************************************************************/
	public StatusTypeList clickOnDoneReordering() throws Exception {
		objWaitForElement.waitForElements(doneReordering, "css");
		this.page.element(doneReordering, "css").clickUsingJSE();
		objWaitForElement.waitForElements(reorderStatuses, "css");
		assertTrue(this.page.element(reorderStatuses, "css").isElementPresent(),
				doneReordering + " is not present.");
		return this;
	}
}