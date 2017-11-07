package lib.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lib.dataObject.User_data;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class UsersList extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement ;
	User_data objUser_data = new User_data();
	
	//Locators
	private String setUpLink = "Setup",
			setUpLink1 = "Setup",
			usersText = "Users",
			createNewUserButton = "input[value='Create New User']",
			maintainEvents = "input[name='rightID'][value='13']",
			username = "userID",
			initPassword = "newPass",
			confirmPassword = "confirmPass",
			FullName = "fullName",
			saveButton = "input[value='Save']",
			cancelButton = "input[value='Cancel']",
			maintainEventtemplate = "input[name='rightID'][value='14']",
			overrideViewingRestriction = "input[name='rightID'][value='55']",
			configureRegionalUserAccess = "input[name='rightID'][value='5']",
			maintainAdHocEvents = "input[name='rightID'][value='15']",
			advancedOptionButton = "//table[@class='displayTable']//th[contains(text(),'Advanced Options')]/img",
			administerUsers = "//table[@id='tbl_association']/thead/tr/th[5]/input[@value='adminRight']",
			firstRole = "//input[@name='userRoleID'][1]",
			secRole = "//input[@name='userRoleID'][2]",
			systemNotifyPreferences = "//a[text()='System Notification Preferences']",
			primaryEMail = "primaryEMail",
			firstAssignRole = "//input[@name='adminRoleID'][1]",
			userTypeAndRoles = "//table[@class='displayTable']/thead/tr/th[text()=' 2. User Type & Roles']",
			userHasRole = "//td[@class='emsData']/div[1]/span[text()='User Has Role']",
			userCanAssignRole = "//td[@class='emsData']/div[2]/span[text()='User Can Assign Role']",
			searchInputField = "tblUsers_SEARCH_TEXT",
			searchButton = "input[id='tblUsers_SEARCH']",
			usernameInUsersList = "//table[@id='tblUsers']/tbody/tr/td[2]",
			roleOption = "tblUsers_ROLE",
			resourceTypeOption = "tblUsers_RESOURCE_TYPE",
			userDetailsOption = "tblUsers_SEARCH_FIELD",
			searchOption = "tblUsers_SEARCH_OPERATOR",
			textPager = "textPager",
			firstName = "input[name='firstName']",
			middleName = "input[name='middleName']",
			lastName = "input[name='lastName']",
			organization = "input[name='organization']",
			phone = "input[name='phone']",
			email = "textarea[name='eMail']",
			userListTable = "//table[@id='tblUsers']/tbody/tr/",
			editEventNotificationPreferences = "input[name='rightID'][value='10']",
			roles = "//div[@id='mainContainer']//tbody/tr/td[text()='Roles:']",
			viewResource = "//table[@id='tbl_association']/thead/tr/th/input[@value='viewRight'][@name='SELECT_ALL']",
			multiRegionEventRights = "Multi-Region Event Rights",
			userDeactivateChkBox = "deactivate-dis-guy",
			userActivateChkBox = "activate-dis-guy",
			warningPge = "//div[@id='mainContainer']/form/div",
			yesDeactivateUser = "//div[@id='mainContainer']/form/div/div[5]/input[@value='Yes, Deactivate this User']",
			noDonotDeactivateUser = "//div[@id='mainContainer']/form/div/div[5]/input[@value='No, Do NOT Deactivate this User']",
			includeInactiveChkBox = "INCLUDE_INACTIVE",
			userProfileInEditUserRegion = "//div[@id='mainContainer']/form/table/thead/tr/th[text()='1. User Profile']",
			usernameInEditUserRegion = "//div[@id='mainContainer']/form/table/tbody/tr/td[text()='Username:']/following-sibling::td/input[1]",
			fullNameInEditUserRegion = "//div[@id='mainContainer']/form/table/tbody/tr/td[text()='Full Name:']/following-sibling::td/input[1]",
			organizationInEditUserRegion = "//div[@id='mainContainer']/form/table/tbody/tr/td[text()='Organization:']/following-sibling::td/input[1]",
			userRgionsInEditUserRegion = "//div[@id='mainContainer']/form/table/thead/tr/th[text()='2. User Regions']",
			regionsInEditUserRegion = "//div[@id='mainContainer']/form/table/tbody/tr/td[text()='Regions:']",
			configureRegViews = "input[name='rightID'][value='51']",
			setupStatusTypes = "input[name='rightID'][value='1']",
			setupResourceTypes = "input[name='rightID'][value='2']",
			setupResource = "input[name='rightID'][value='4']",
			header = "h1",
			selectAllButton = "input[value='Select All']",
			strFrame = "TB_iframeContent",
			saveChangesBtnInRefine = "//p[1]//input[@value='Save Changes']",
			strDataFrame = "Data",
			viewcustomView = "input[name='rightID'][value='26']",
			refineVisibleStatusTypeWin = "TB_ajaxWindowTitle",
			SystemNotificationPreferences = "System Notification Preferences",
			ExpiredStatusNotificationsEmailCheckBox = "//div[@id='mainContainer']//table/tbody/tr[1]/td[1]/span[text()='Expired Status Notifications']/ancestor::tr/td[2]/input",
			ExpiredStatusNotificationsTextPagerCheckBox = "//div[@id='mainContainer']//table/tbody/tr[1]/td[1]/span[text()='Expired Status Notifications']/ancestor::tr/td[3]/input",
			configureMultiRegViews = "input[name='rightID'][value='51']",
			reportStatusSnapshot = "input[name='rightID'][value='43']",
			maintainDocumentLibrary = "input[name='rightID'][value='27']",
			editRegionalMessageBulletinBoard = "input[name='rightID'][value='28']",
			mustUpdateOverDueStatus = "input[name='rightID'][value='23']",
			reportEventSnapshot = "input[name='rightID'][value='49']",
			mayUpdateRegionSetupInformation = "input[name='rightID'][value='25']",
			reportEventDetail = "input[name='rightID'][value='19']",
			instantMessagingInitiateChatSession = "input[name='rightID'][value='54']",
			reportStatusResDetail = "input[name='rightID'][value='29']",
			reportStatusResSumry = "input[name='rightID'][value='47']",
			reportStatusSummary = "input[name='rightID'][value='40']",
			reportStatusDetail = "input[name='rightID'][value='36']",
			incomingPatientNotification = "input[name='rightID'][value='72']",
			editStatuschangeNotificationPreference = "input[name='rightID'][value='12']",
			editResourcesOnly = "input[name='rightID'][value='20']",
			headerName = "div#topSubNav > h1",
			reportIncomingPatientNotification = "input[name='rightID'][value='73']",
			incomingPatientNotifications = "input[name='rightID'][value='72']",
			creatincomingPatientNotifications = "input[name='rightID'][value='74']",
			formDoNotParticipateInFormsForResourcesOption = "input[name='rightID'][value='37']",
			deactivateUser = "input[name=\"deactivate-dis-guy\"]",
			reactivateUser = "css=input[name=\"activate-dis-guy\"]",
			systemNotificationEmail = "input[value='SYSTEM'][name='emailInd']",
			systemNotificationPager = "input[value='SYSTEM'][name='pagerInd']",
			systemNotificationWeb = "input[value='SYSTEM'][name='webInd']",
			viewUserInformationOnly = "input[name='rightID'][value='50']",
			reportMonthlyStatusSumry = "input[name='rightID'][value='48']",
			formActivate = "input[name='rightID'][value='32']",
			userMayActivateAndModifyForms = "input[name='rightID'][value='39']",
			userMayConfigureFormSecurity = "input[name='rightID'][value='33']",
			reportFormDetail = "input[name='rightID'][value='45']",
			setUpRoles = "input[name='rightID'][value='11']",
			assosciatedWith = "//table[@id='tbl_association']/thead/tr/th/input[@value='association'][@name='SELECT_ALL']",
			saveButton1 = "(//input[@value='Save'])[2]",
			webServiceChkBox = "input[name='webServices']",
			allCheckBoxes = "//tbody//td[text()='Additional User Rights:']/following-sibling::td/input[@class='checkbox'][@type='checkbox']",
			setupStatusReason = "input[name='rightID'][value='3']",
			showAllUsersLink = "//div[@id='toomany']/a[contains(@onclick,'showUnlimited')]",
			administerOtherRegionViews = "input[name='rightID'][value='53']",
			statusChangeNotificationPreferences = "Status Change Notification Preferences",
			monthlyStatusAssesment="input[name='rightID'][value='48']",
		    statewideResource="input[name='rightID'][value='62']",
		    auditResource="input[name='rightID'][value='63']",
		    footer="//div[@id='footer']/table/tbody/tr/td[@class='ftRt']",
		    eventNotificationPreference="Event Notification Preferences",
		    errorHeading = "//div[@class='emsError']/span",
		    errorMsg = "//div[@class='emsError']/ul/li",
		    closeInRefineWin = "#TB_closeWindowButton",
		    errorInRefineWindow = "//div/p[text()='You must save any changes made to this user's roles before refining status type visibility.']",
		    systemAdmin="//td[text()='System Admin User:']/following-sibling::td/input[@name='systemOnly'][@class='checkbox']",
		    strDeactivationWarning="//table/tbody/tr/td/span[text()='This user has been DEACTIVATED. To reactivate, change the setting below.']",
		    viewOtherRegions = "//input[@value='otherRegionViewID'][@name='SELECT_ALL']",
		    strHAvBEDScheduleActivateHAvBEDInterface="input[name='rightID'][value='61']",
		    strPreferncesDonotSendUserInfoReminderMails="input[name='rightID'][value='57']",
		    strUserResetPasswordOnly="input[name='rightID'][value='42']",
		    strRightsName = "//table[@class='displayTable']/tbody/tr/td[text()='Additional User Rights:']/following-sibling::td[1]",
    		includeInactiveUsers = "input[id='INCLUDE_INACTIVE']",
		    userProfileText = "//table[@class='displayTable']/thead/tr/th[text()=' 1. User Profile']",
		    usernameText = "//table[@class='displayTable']/tbody/tr/td[text()='Username:']",
		    initialPasswordText = "//table[@class='displayTable']/tbody/tr[2]/td[text()='Initial Password: ']",
		    confirmPasswordText = "//table[@class='displayTable']/tbody/tr[3]/td[text()='Confirm Password: ']",
		    fullNameText = "//table[@class='displayTable']/tbody/tr[4]/td[text()='Full Name:']",
		    firstNameText = "//table[@class='displayTable']/tbody/tr[5]/td[text()='First Name:']",
		    middleNameText = "//table[@class='displayTable']/tbody/tr[6]/td[text()='Middle Name:']",
		    lastNameText = "//table[@class='displayTable']/tbody/tr[7]/td[text()='Last Name:']",
		    organizationText = "//table[@class='displayTable']/tbody/tr[8]/td[text()='Organization:']",
		    contactPhoneText = "//table[@class='displayTable']/tbody/tr[9]/td[text()='Contact Phone:']",
		    primaryEMailText = "//table[@class='displayTable']/tbody/tr[10]/td[text()='Primary E-Mail:']",
		    eMailAddressesText = "//table[@class='displayTable']/tbody/tr[11]/td[text()='E-Mail Addresses (comma separate multiple addresses):']",
		    textPagerAddressesText = "//table[@class='displayTable']/tbody/tr[12]/td[text()='Text Pager Addresses (comma separate multiple addresses):']",
		    administrativeCommentsText = "//table[@class='displayTable']/tbody/tr[13]/td[text()='Administrative Comments:']",
		    userTypeRolesText = "//table[@class='displayTable']/thead/tr/th[text()=' 2. User Type & Roles']",
		    webServicesUserText = "//table[@class='displayTable']/tbody/tr[1]/td[text()='Web Services User:']",
		    rolesText = "//table[@class='displayTable']/tbody/tr[2]/td[text()='Roles:']",
		    viewsText = "//table[@class='displayTable']/thead/tr/th[text()=' 3. Views']",
		    defaultViewText = "//table[@class='displayTable']/tbody/tr[1]/td[text()='Default View:']",
		    viewsInThisRegionText = "//table[@class='displayTable']/tbody/tr[2]/td[text()='Views in This Region:']",
		    resourceRightsText = "//table[@class='displayTable']/thead/tr/th[text()=' 4. Resource Rights']",
		    advancedOptionsText = "//table[@class='displayTable']/thead/tr/th[text()=' 5. Advanced Options']",
		    anyResourceTypeDropDown = "select[id='tbl_association_RESOURCE_TYPE']",
		    resourceNameDropDown = "select[id='tbl_association_SEARCH_FIELD']",
		    containsDropDown = "select[id='tbl_association_SEARCH_OPERATOR']",
		    totalNumberOfUsers = "//div[@id='mainContainer']/form/table/tbody/tr/td/span[@id='count']",
		    searchOptionTextField = "input[id='tblUsers_SEARCH_TEXT']",
		    actionColumn = "//table[@id='tblUsers']/thead/tr/th[text()='Actions']",
		    usernameColumn = "//table[@id='tblUsers']/thead/tr/th[2]/a[text()='Username']",
		    fullnameColumn = "//table[@id='tblUsers']/thead/tr/th[3]/a[text()='Full Name']",
		    organizationColumn = "//table[@id='tblUsers']/thead/tr/th[4]/a[text()='Organization']",
		    lastLoginColumn= "//table[@id='tblUsers']/thead/tr/th[5]/a[text()='Last Login']",
		    RolesColumn = "//table[@id='tblUsers']/thead/tr/th[text()='Roles']",
		    phoneColumn = "//table[@id='tblUsers']/thead/tr/th[4]/a[text()='Phone']",
		    emailColumn = "//table[@id='tblUsers']/thead/tr/th[5]/a[text()='E-Mail']";
				    			
					 			
	public UsersList(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to navigate to 'Users'
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList clickOnSetUp() throws Exception {
		objWaitForElement.waitForElements(setUpLink, "linktext");
		this.page.element(setUpLink, "linktext").getOne().sendKeys(Keys.ENTER);
		try{
			if(this.page.element("//div[@id='topSubNav']/h1[text()='Setup Menu']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)==false){
				this.page.element(setUpLink, "linktext").getDisplayedOne().click();
			}
		} catch(Exception e) {
			
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to navigate to 'Users'
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList clickOnSetUp1() throws Exception {
		objWaitForElement.waitForElements(setUpLink1, "linktext");
		this.page.element(setUpLink1, "linktext").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to navigate to 'Users'
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList navigateToUsersNew() throws Exception {
		Actions action = new Actions(this.driver);
		this.clickOnSetUp1();
		objWaitForElement.waitForElements(usersText, "linktext");
		this.page.element(usersText, "linktext").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
//		objWaitForElement.waitForElements(createNewUserButton, "css");
		if(this.page.element(usersText, "linktext").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)==true){
			action.moveToElement(this.page.element(usersText, "linktext").getOne()).click().build().perform();
		}
		objWaitForElement.waitForElements(createNewUserButton, "css");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to navigate to 'Users'
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList navigateToUsers() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(usersText, "linktext");
		this.page.element(usersText, "linktext").getOne().click();
		objWaitForElement.waitForElements(createNewUserButton, "css");
		if(this.page.element(usersText, "linktext").isElementPresent()==true){
			this.page.element(usersText, "linktext").getOne().sendKeys(Keys.ENTER);
		}
		objWaitForElement.waitForElements(createNewUserButton, "css");
		return new UsersList(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Create New User' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList clickCreateNewUserButton() throws Exception {
		objWaitForElement.waitForElements(createNewUserButton, "css");
		this.page.element(createNewUserButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Create Ne
	 * w User' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList createNewUserButtonIsNotPresent() throws Exception {
		assertFalse(this.page.element(createNewUserButton, "css")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Create New User' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList createNewUserButtonIsPresent() throws Exception {
		objWaitForElement.waitForElements(createNewUserButton, "css");
		assertTrue(this.page.element(createNewUserButton, "css")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Advance Option' node
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList clickAdvancedOptionAndExpand() throws Exception {
		objWaitForElement.waitForElements(advancedOptionButton, "xpath");
		this.page.element(advancedOptionButton, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter username
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList enterUsername(String strusername) throws Exception {
		objWaitForElement.waitForElements(username, "name");
		this.page.element(username, "name").clearInputValue().sendKeys(strusername);
		this.selectFirstRole();
		System.out.println(strusername);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter password
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList enterPassword(String strPassword) throws Exception {
		objWaitForElement.waitForElements(initPassword, "name");
		this.page.element(initPassword, "name").clearInputValue().sendKeys(strPassword);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter confirm password
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList enterConfirmPassword(String strPassword) throws Exception {
		objWaitForElement.waitForElements(confirmPassword, "name");
		this.page.element(confirmPassword, "name").clearInputValue().sendKeys(strPassword);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter user fullname
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList enterFullName(String strFullName) throws Exception {
		objWaitForElement.waitForElements(FullName, "name");
		this.page.element(FullName, "name").clearInputValue().sendKeys(strFullName);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Maintain Event option
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList selectMaintainEventsOption() throws Exception {
		objWaitForElement.waitForElements(maintainEvents, "css");
		this.page.element(maintainEvents, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter UserDetails
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList enterUserDetails(String strusername, String strPassword, String strFullName)
			throws Exception {
		this.enterUsername(strusername);			
		this.enterPassword("Abcd@1234");		
		this.enterConfirmPassword("Abcd@1234");
		this.enterFullName(strFullName);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Save' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/

	public UsersList clickSaveButton() throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		this.page.element(saveButton, "css").clickUsingJSE();
		//objWaitForElement.waitForElements(createNewUserButton, "css"); (alert will come as soon as save button got clicked from the TC 44279)
		Thread.sleep(7000);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select ConfigureRegional User Access Option
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/

	public UsersList selectConfigureRegionalUserAccessOption() throws Exception {
		objWaitForElement.waitForElements(configureRegionalUserAccess, "css");
		this.page.element(configureRegionalUserAccess, "css").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select Maintain EventTemplate Option
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/

	public UsersList selectMaintainEventTemplateOption() throws Exception {
		objWaitForElement.waitForElements(maintainEventtemplate, "css");
		this.page.element(maintainEventtemplate, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Maintain AdHoc Event option
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList selectMaintainAdHocEventsOption() throws Exception {
		objWaitForElement.waitForElements(maintainAdHocEvents, "css");
		this.page.element(maintainAdHocEvents, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select First Role
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList selectFirstRole() throws Exception {
		objWaitForElement.waitForElements(firstRole, "xpath");
		if(this.page.element(firstRole, "xpath").getOne().isSelected() == false){
			this.page.element(firstRole, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(firstRole, "xpath").getOne().isSelected() == false){
			this.page.element(firstRole, "xpath").getOne().click();
		}
		assertTrue(this.page.element(firstRole, "xpath").getOne().isSelected(), firstRole+" is not selected");
		return this;
	}

		
	/**********************************************************************************
	 * Description : This function is to Verify Administer Users Check Box is displayed
	 * Date        : 17/06/2014
	 * Author      : Yugender
	 **********************************************************************************/
	public UsersList verAdministerUsersIsPresent() throws Exception {
		objWaitForElement.waitForElements(administerUsers, "xpath");
		assertTrue(this.page.element(administerUsers, "xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to Verify 'SetUp' is not displayed
	 * Date        : 17/06/2014
	 * Author      : Yugender
	 **********************************************************************************/
	public UsersList verSetUpIsNotPresent() throws Exception {
		assertFalse(this.page.element(setUpLink, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Verify 'SetUp' is not displayed
	 * Date        : 17/06/2014
	 * Author      : Yugender
	 **********************************************************************************/
	public UsersList verSetUpIsPresent() throws Exception {
		objWaitForElement.waitForElements(setUpLink, "linktext");
		assertTrue(this.page.element(setUpLink, "linktext").isElementPresent());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to Verify 'SetUp' is not displayed
	 * Date        : 17/06/2014
	 * Author      : Yugender
	 **********************************************************************************/
	public UsersList verSetUpPasswordIsNotPresent() throws Exception {
		assertFalse(this.page.element(
				"//div[@id='headingTitle'][text()='Set Up Your Password']",
				"xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select First Role
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList editUserDetails(String strUserName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tblUsers']/tbody/tr/td[2]"
				+ "[text()='" + strUserName
				+ "']/parent::tr/td[1]/a[text()='Edit']", "xpath");
		this.page.element("//table[@id='tblUsers']/tbody/tr/td[2]"
				+ "[text()='" + strUserName
				+ "']/parent::tr/td[1]/a[text()='Edit']", "xpath").getOne().click();
		objWaitForElement.waitForElements(username, "name");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to navigate to 'system Notification Preferences' page
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList clickOnsystemNotifyPreferences() throws Exception {
		objWaitForElement.waitForElements(systemNotifyPreferences, "xpath");
		this.page.element(systemNotifyPreferences, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter user primaryEmaiId
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList enterPrimaryEmailId(String strPrimaryMailId) throws Exception {
		objWaitForElement.waitForElements(primaryEMail, "name");
		this.page.element(primaryEMail, "name").clearInputValue().sendKeys(strPrimaryMailId);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select First User Assign Role
	 * Date        : 19/06/2014
	 * Author      : Yugender
	 **********************************************************************************/
	public UsersList selectFirstUserCanAssignRole() throws Exception {
		objWaitForElement.waitForElements(firstAssignRole,
				"xpath");
		this.page.element(firstAssignRole, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to Verify Administer Users Check Box is displayed
	 * Date        : 17/06/2014
	 * Author      : Yugender
	 **********************************************************************************/
	public UsersList selectAdministerUsersOfResource(String strResource) throws Exception {
		String strAdministerUser = "//table[@id='tbl_association']/tbody/tr/td[text()='"
				+ strResource
				+ "']/preceding-sibling::td/input[@name='adminRight']";
		objWaitForElement.waitForElements(strAdministerUser,
				"xpath");
		assertTrue(this.page.dynamicElement(strResource, strAdministerUser, "xpath").isElementPresent());
		this.page.dynamicElement(strResource, strAdministerUser, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to Verify Administer Users Check Box is displayed
	 * Date        : 17/06/2014
	 * Author      : Yugender
	 **********************************************************************************/
	public UsersList selectUpdateStatusOfResource(String strResource)
			throws Exception {
		String strAdministerUser = "//table[@id='tbl_association']/tbody/tr/td[text()='"
				+ strResource
				+ "']/preceding-sibling::td/input[@name='updateRight']";
		objWaitForElement.waitForElements(strAdministerUser,
				"xpath");
		assertTrue(this.page.dynamicElement(strResource, strAdministerUser,
				"xpath").isElementPresent());
		if (this.page.element(strAdministerUser, "xpath").getOne().isSelected() == false) {
			this.page.element(strAdministerUser, "xpath").getOne().click();
		}
		if (this.page.element(strAdministerUser, "xpath")
				.getOne().isSelected() == false) {
			this.page.element(strAdministerUser, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(strAdministerUser, "xpath")
				.getOne().isSelected() == false) {
			this.page.element(strAdministerUser, "xpath").getOne().sendKeys(Keys.ENTER);
		}
		assertTrue(this.page.element(strAdministerUser, "xpath").getOne().isSelected(), strAdministerUser+" is not selected.");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to Verify Administer Users Check Box is displayed
	 * Date        : 17/06/2014
	 * Author      : Yugender
	 **********************************************************************************/
	public UsersList verifyUserTypeAndRolesIsDisplayed(String strResource) throws Exception {
		objWaitForElement.waitForElements(userTypeAndRoles, "xpath");
		assertTrue(this.page.element(userTypeAndRoles, "xpath").isElementPresent());
		assertTrue(this.page.element(firstRole, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify User Has Role is not displayed
	 * Date        : 19/06/2014
	 * Author      : Yugender
	 **********************************************************************************/
	public UsersList verUserHasRoleIsNotPresent() throws Exception {
		assertFalse(this.page.element(userHasRole, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify User Has Role is not displayed
	 * Date        : 19/06/2014
	 * Author      : Yugender
	 **********************************************************************************/
	public UsersList verUserCanAssignRoleIsNotPresent() throws Exception {
		assertFalse(this.page.element(userCanAssignRole, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Cancel' button
	 * Date        : 19/06/2014
	 * Author      : Yugender
	 **********************************************************************************/

	public UsersList clickCancelButton() throws Exception {
		objWaitForElement.waitForElements(cancelButton, "css");
		this.page.element(cancelButton, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter Username in 'Search' input field
	 * Date        : 17/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList enterUsernameInSearchInputField(String strUsername)
			throws Exception {
		objWaitForElement.waitForElements(searchInputField, "id");
		this.page.element(searchInputField, "id").clearInputValue()
		.sendKeys(strUsername);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Search' button
	 * Date        : 17/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/

	public UsersList clickSearchButton() throws Exception {
		objWaitForElement.waitForElements(searchButton, "css");
		this.page.element(searchButton, "css").clickUsingJSE();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Role option in Users list
	 * Date        : 17/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectRoleOptionInUsersList(String strRole)
			throws Exception {
		objWaitForElement.waitForElements(roleOption, "id");
		this.page.element(roleOption, "id").webElementToSelect()
		.selectByVisibleText(strRole);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Resource type option in Users list
	 * Date        : 17/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectResourceTypeOptionInUsersList(String strResourceType)
			throws Exception {
		objWaitForElement.waitForElements(resourceTypeOption, "id");
		this.page.element(resourceTypeOption, "id").webElementToSelect()
		.selectByVisibleText(strResourceType);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select User details option in Users list
	 * Date        : 17/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectUserDetailsOptionInUsersList(String strUserDetails)
			throws Exception {
		objWaitForElement.waitForElements(userDetailsOption, "id");
		this.page.element(userDetailsOption, "id").webElementToSelect()
		.selectByVisibleText(strUserDetails);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select search option in Users list
	 * Date        : 17/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectSearchOptionInUsersList(String strsearchOption)// Field is removed from 3.29.2 version
			throws Exception {
		objWaitForElement.waitForElements(searchOption, "id");
		this.page.element(searchOption, "id").webElementToSelect()
		.selectByVisibleText(strsearchOption);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to search the Username in Users list page
	 * Date        : 17/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/ 
	public UsersList searchUserName(String strUsername,
			String strRole, String strResourceType,String strUserDetails, String strsearchOption)
					throws Exception {
		selectRoleOptionInUsersList(strRole);
		selectResourceTypeOptionInUsersList(strResourceType);
		selectUserDetailsOptionInUsersList(strUserDetails);
//		selectSearchOptionInUsersList(strsearchOption); // Field is removed from 3.29.2 version
		enterUsernameInSearchInputField(strUsername);
		Thread.sleep(1000);
		clickSearchButton();
//		assertEquals(strUsername,
//				this.page.element(usernameInUsersList, "xpath").getOne()
//				.getText());
		Thread.sleep(1000);
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select Override Viewing Restriction
	 * Date        : 28/July/2014
	 * Author      : Anitha
	 **********************************************************************************/

	public UsersList selectOverrideViewingRestrictionOption() throws Exception {
		objWaitForElement.waitForElements(overrideViewingRestriction, "css");
		this.page.element(overrideViewingRestriction, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter user textPager
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList entertextPagerId(String strtextPagerId) throws Exception {
		objWaitForElement.waitForElements(textPager, "name");
		this.page.element(textPager, "name").clearInputValue().sendKeys(strtextPagerId);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter all user details.
	 * Date 	   : 30/07/2014
	 * Author      : Rensuhree
	 **********************************************************************************/
	public UsersList enterAllUserDetails(String strUsername,
			String strPassword, String strFullName, String strFirstName,
			String strMiddleName, String strLastName, String strOrganization,
			String strPhone, String strPrimaryMailId, String strEmail,
			String strPagerMailId) throws Exception {
		this.enterUsername(strUsername);
		this.enterPassword(objUser_data.strUserPwd);
		this.enterConfirmPassword(objUser_data.strUserPwd);
		this.enterFullName(strFullName);
		this.enterFirstName(strFirstName);
		this.enterMiddleName(strMiddleName);
		this.enterLastName(strLastName);
		this.enterOrganization(strOrganization);
		this.enterPhone(strPhone);
		this.enterPrimaryEmailId(strPrimaryMailId);
		this.enterEmail(strEmail);
		this.entertextPagerId(strPagerMailId);
		this.selectFirstRole();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter user Firstname
	 * Date 	   : 30/07/2014
	 * Author      : Rensuhree
	 **********************************************************************************/
	public UsersList enterFirstName(String strFirstName) throws Exception {
		objWaitForElement.waitForElements(firstName, "css");
		this.page.element(firstName, "css").clearInputValue().sendKeys(strFirstName);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter user Middlename
	 * Date 	   : 30/07/2014 
	 * Author      : Rensuhree
	 **********************************************************************************/
	public UsersList enterMiddleName(String strMiddleName) throws Exception {
		objWaitForElement.waitForElements(middleName, "css");
		this.page.element(middleName, "css").clearInputValue().sendKeys(strMiddleName);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter user Lastname
	 * Date 	   : 30/07/2014
	 * Author      : Rensuhree
	 **********************************************************************************/
	public UsersList enterLastName(String strLastName) throws Exception {
		objWaitForElement.waitForElements(lastName, "css");
		this.page.element(lastName, "css").clearInputValue().sendKeys(strLastName);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter user Organization
	 * Date 	   : 30/07/2014
	 * Author      : Rensuhree
	 **********************************************************************************/
	public UsersList enterOrganization(String strOrganization) throws Exception {
		objWaitForElement.waitForElements(organization, "css");
		this.page.element(organization, "css").clearInputValue().sendKeys(strOrganization);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter user Phone
	 * Date 	   : 30/07/2014
	 * Author      : Rensuhree
	 **********************************************************************************/
	public UsersList enterPhone(String strPhone) throws Exception {
		objWaitForElement.waitForElements(phone, "css");
		this.page.element(phone, "css").clearInputValue().sendKeys(strPhone);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter user Emial
	 * Date 	   : 30/07/2014
	 * Author      : Rensuhree
	 **********************************************************************************/
	public UsersList enterEmail(String strEmail) throws Exception {
		objWaitForElement.waitForElements(email, "css");
		this.page.element(email, "css").clearInputValue().sendKeys(strEmail);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user details.
	 * Date 	   : 30/07/2014
	 * Author      : Rensuhree
	 **********************************************************************************/
	public UsersList verUserDetails(String strUserName, String strFullName,
			String strOrganization) throws Exception {
		objWaitForElement.waitForElements(userListTable + "td[2][text()='"+strUserName+"']", "xpath");
		assertEquals(strUserName, this.page.element(userListTable + "td[2]", "xpath").getOne().getText());
		assertEquals(strFullName, this.page.element(userListTable + "td[3]", "xpath").getOne().getText());
		assertEquals(strOrganization,
				this.page.element(userListTable + "td[4]", "xpath").getOne().getText());
		return this;
	}
	

	/**********************************************************************************
	 * Description : This function is to select associated with rights
	 * Date        : 31/07/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList selectAssociateWithOfResource(String strResource) throws Exception {
		String strAssociateWithRight = "//table[@id='tbl_association']/tbody/tr/td[text()='"
				+ strResource
				+ "']/preceding-sibling::td/input[@name='association']";
		objWaitForElement.waitForElements(strAssociateWithRight, "xpath");
		assertTrue(this.page.dynamicElement(strResource, strAssociateWithRight, "xpath").isElementPresent());
		this.page.dynamicElement(strResource, strAssociateWithRight, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Edit Event Notification Preferences option
	 * Date        : 31/07/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList selectEditEventNotificationPreferencesOption() throws Exception {
		objWaitForElement.waitForElements(editEventNotificationPreferences, "css");
		this.page.element(editEventNotificationPreferences, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify User Has Role is displayed
	 * Date        : 01/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verUserHasRoleIsPresent() throws Exception {
		objWaitForElement.waitForElements(userHasRole, "xpath");
		assertTrue(this.page.element(userHasRole, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify User Has Role is displayed
	 * Date        : 01/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verUserCanAssignRoleIsPresent() throws Exception {
		objWaitForElement.waitForElements(userCanAssignRole, "xpath");
		assertTrue(this.page.element(userCanAssignRole, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Verify Administer Users Check Box is not displayed
	 * Date        : 01/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verAdministerUsersIsNotPresent() throws Exception {
		assertFalse(this.page.element(administerUsers, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Role is displayed
	 * Date        : 01/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verRolesIsPresent() throws Exception {
		objWaitForElement.waitForElements(roles, "xpath");
		assertTrue(this.page.element(roles, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Edit' option
	 * Date        : 04/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verEditLink(String strUserName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
				+ strUserName + "']/parent::tr/td[1]/a[text()='Edit']",
		"xpath");
		assertTrue(this.page.element(
				"//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
						+ strUserName + "']/parent::tr/td[1]/a[text()='Edit']",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Edit' option
	 * Date        : 04/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verEditLinkIsNotPresent(String strUserName)
			throws Exception {
		assertFalse(this.page.element(
				"//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
						+ strUserName + "']/parent::tr/td[1]/a[text()='Edit']",
				"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Password' option
	 * Date        : 04/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verPasswordLink(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
				+ strUserName
				+ "']/parent::tr/td[1]/a[text()='Password']", "xpath");
		assertTrue(this.page.element(
				"//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
						+ strUserName
						+ "']/parent::tr/td[1]/a[text()='Password']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Password' option
	 * Date        : 04/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verPasswordLinkIsNotPresent(String strUserName)
			throws Exception {
		assertFalse(this.page.element(
				"//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
						+ strUserName
						+ "']/parent::tr/td[1]/a[text()='Password']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Resource Name' option
	 * Date        : 04/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verResourceName(String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[text()='"
				+ strResourceName + "']", "xpath");
		assertTrue(this.page.element(
				"//table[@id='tbl_association']/tbody/tr/td[text()='"
						+ strResourceName + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'View Resource' option is not present
	 * Date        : 04/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verViewResourceIsNotPresent() throws Exception {
		assertFalse(this.page.element(viewResource, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'FullName' in user list
	 * Date        : 04/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verFullName(String strUserName, String strFullName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tblUsers']/tbody/tr/td[2][text()='" + strUserName
				+ "']/parent::tr/td[3][text()='" + strFullName + "']",
		"xpath");
		assertTrue(this.page.element(
				"//table[@id='tblUsers']/tbody/tr/td[2][text()='" + strUserName
						+ "']/parent::tr/td[3][text()='" + strFullName + "']",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Organization' in user list
	 * Date        : 04/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verOrganiZation(String strUserName, String strOrganization)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tblUsers']/tbody/tr/td[2][text()='" + strUserName
				+ "']/parent::tr/td[4][text()='" + strOrganization
				+ "']", "xpath");
		assertTrue(this.page.element(
				"//table[@id='tblUsers']/tbody/tr/td[2][text()='" + strUserName
						+ "']/parent::tr/td[4][text()='" + strOrganization
						+ "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'number of rows' in resources
	 * Date        : 04/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList VerifyNoOfRowsForResources() throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[4]", "xpath");
		int count = this.page.element(
				"//table[@id='tbl_association']/tbody/tr/td[4]", "xpath")
				.getXpathCount();
		assertEquals(2, count);
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to click on Regions link of a particular username
	 * Date        : 04/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList clickRegionsLinkForUser(String strUserName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tblUsers']/tbody/tr/td[2]"
				+ "[text()='" + strUserName
				+ "']/parent::tr/td[1]/a[text()='Regions']", "xpath");
		this.page.element("//table[@id='tblUsers']/tbody/tr/td[2]"
				+ "[text()='" + strUserName
				+ "']/parent::tr/td[1]/a[text()='Regions']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Regions link of a particular username
	 * Date        : 04/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList selectRegion(String strRegionValue) throws Exception {
		objWaitForElement.waitForElements("input[name='regionID'][value='"
				+ strRegionValue + "']", "css");
		if (this.page
				.dynamicElement(
						strRegionValue + " region value",
						"input[name='regionID'][value='" + strRegionValue
								+ "']", "css").getOne().isSelected() == false) {
			this.page
					.dynamicElement(
							strRegionValue + " region value",
							"input[name='regionID'][value='" + strRegionValue
									+ "']", "css").mouseOver();
			this.page
					.dynamicElement(
							strRegionValue + " region value",
							"input[name='regionID'][value='" + strRegionValue
									+ "']", "css").getOne().sendKeys(Keys.SPACE);
		}
		assertTrue(this.page.element("input[name='regionID'][value='" + strRegionValue + "']", "css").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Edit Event Notification Preferences option
	 * Date        : 31/07/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList clickMultiRegionEventRights() throws Exception {
		objWaitForElement.waitForElements(multiRegionEventRights, "linktext");
		this.page.element(multiRegionEventRights, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Verify Administer Users Check Box is displayed
	 * Date        : 17/06/2014
	 * Author      : Yugender
	 **********************************************************************************/
	public UsersList selectViewResourceRights(String strResource)
			throws Exception {
		String strAdministerUser = "//table[@id='tbl_association']/tbody/tr/td[text()='"
				+ strResource
				+ "']/preceding-sibling::td/input[@name='viewRight']";
		objWaitForElement.waitForElements(strAdministerUser, "xpath");
		assertTrue(this.page.dynamicElement(strResource, strAdministerUser,
				"xpath").isElementPresent());
		if (this.page.dynamicElement(strResource, strAdministerUser, "xpath")
				.getOne().isSelected() == false) {
			this.page.dynamicElement(strResource, strAdministerUser, "xpath")
					.getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select region names to provide multi region access
	 * Date        : 04/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList selectUserRegion(String strRegionValue) throws Exception {
		objWaitForElement.waitForElements("input[name='userRegionID'][value='"+ strRegionValue + "']", "css");
		if(this.page.dynamicElement(strRegionValue+" region value", "input[name='userRegionID'][value='"+ strRegionValue + "']", "css").getOne().isSelected()==false){
			this.page.dynamicElement(strRegionValue+" region value", "input[name='userRegionID'][value='"+ strRegionValue + "']", "css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to click on user deactivate check box.
	 * Date        : 05/08/2014
	 * Author      : Renushree
	**********************************************************************************/
	public UsersList clickOnUserDeactivateChkBox() throws Exception {
		objWaitForElement.waitForElements(userDeactivateChkBox, "name");
		assertTrue(this.page.element(userDeactivateChkBox,"name").isElementPresent(), "User status check box is not present");
		this.page.element(userDeactivateChkBox, "name").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to click on user activate check box.
	 * Date        : 05/08/2014
	 * Author      : Renushree
	**********************************************************************************/
	public UsersList clickOnUserActivateChkBox() throws Exception {
		objWaitForElement.waitForElements(userActivateChkBox, "name");
		assertTrue(this.page.element(userActivateChkBox, "name")
				.isElementPresent(), "User status check box is not present");
		this.page.element(userActivateChkBox, "name").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to click on user status check box.
	 * Date        : 05/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verifyWarningPage(String strUserName, String strFullName)
			throws Exception {
		this.verifyWarningPageisDisplayed();
		this.verifyWarningMsgWithUserName(strUserName, strFullName);
		this.verifyWarningNoteMsgs();
		this.verifyYesDeactivateThisUserBtnIsDisplayed();
		this.verifyDonotDeactivateThisUserBtnIsDisplayed();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to verify warning page is displayed,
	 * Date        : 05/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verifyWarningPageisDisplayed() throws Exception {
		objWaitForElement.waitForElements(warningPge + "/div[1]", "xpath");
		assertEquals("Warning",
				this.page.element(warningPge + "/div[1]", "xpath").getOne()
						.getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to verify warning msgs with username.
	 * Arguments   : strUserName
	 * Date        : 05/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verifyWarningMsgWithUserName(String strUserName,
			String strFullName) throws Exception {
		objWaitForElement.waitForElements(warningPge + "/div[2]/p[1]", "xpath");
		assertEquals("The user has been saved.",
				this.page.element(warningPge + "/div[2]/p[1]", "xpath")
						.getOne().getText());
		assertEquals("You are now about to deactivate the account for "
				+ strFullName + " (username: " + strUserName + ")", this.page
				.element(warningPge + "/div[2]/p[2]", "xpath").getOne()
				.getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to verify note msgs in warning pages.
	 * Date        : 05/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verifyWarningNoteMsgs() throws Exception {
		objWaitForElement.waitForElements(warningPge + "/div[3]/p", "xpath");
		assertEquals("Please Note:",
				this.page.element(warningPge + "/div[3]/p", "xpath").getOne()
						.getText());
		assertEquals("This user will NOT be able to log into EMSystem.",
				this.page.element(warningPge + "/div[3]/ul/li[1]", "xpath")
						.getOne().getText());
		assertEquals("All email addresses for this user will be deleted.",
				this.page.element(warningPge + "/div[3]/ul/li[2]", "xpath")
						.getOne().getText());
		assertEquals("All pager addresses for this user will be deleted.",
				this.page.element(warningPge + "/div[3]/ul/li[3]", "xpath")
						.getOne().getText());
		assertEquals("Are you sure you would like to deactivate this user?",
				this.page.element(warningPge + "/div[4]", "xpath").getOne()
						.getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to verify Yes, deactivate this user button is displayed.
	 * Date        : 05/08/2014
	 * Author      : Renushree
	**********************************************************************************/
	public UsersList verifyYesDeactivateThisUserBtnIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(yesDeactivateUser, "xpath");
		assertTrue(this.page.element(yesDeactivateUser, "xpath")
				.isElementPresent(),
				"Yes, Deactivate this User button is not present");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to verify No, Donot deactivate this user button is displayed.
	 * Date        : 05/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verifyDonotDeactivateThisUserBtnIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(noDonotDeactivateUser, "xpath");
		assertTrue(this.page.element(noDonotDeactivateUser, "xpath")
				.isElementPresent(),
				"No, Do NOT Deactivate this User button is not present");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to click on Yes, deactivate this user button is displayed.
	 * Date        : 05/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList clickOnYesDeactivateThisUserBtn() throws Exception {
		objWaitForElement.waitForElements(yesDeactivateUser, "xpath");
		this.page.element(yesDeactivateUser, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to verify deactivated confirm page.
	 * Date        : 05/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verifyDeactivationConfirmPage(String strUserName,
			String strFullName) throws Exception {
		this.verifyDeactivatedConfmMsgWithUsername(strUserName, strFullName);
		this.verifyDeactivatedConfmMsg();
		this.verifyReturnToListBtnIsDisplayed();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to verify deactivated confirm message.
	 * Arguments   : strUserName
	 * Date        : 05/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verifyDeactivatedConfmMsgWithUsername(String strUserName,
			String strFullName) throws Exception {
		objWaitForElement.waitForElements(warningPge + "/div[1]", "xpath");
		assertEquals("You have successfully deactivated " + strFullName
				+ " (username: " + strUserName + ")",
				this.page.element(warningPge + "/div[1]", "xpath").getOne()
						.getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to verify deactivated confirm message.
	 * Arguments   : strUserName
	 * Date        : 05/08/2014
	 * Author      : Renushree
	**********************************************************************************/
	public UsersList verifyDeactivatedConfmMsg() throws Exception {
		objWaitForElement.waitForElements(warningPge + "/div[2]/p[1]", "xpath");
		assertEquals("This user can no longer login.",
				this.page.element(warningPge + "/div[2]/p[1]", "xpath")
						.getOne().getText());
		assertEquals("Any email and pager addresses have been deleted.",
				this.page.element(warningPge + "/div[2]/p[2]", "xpath")
						.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to verify return to list button is displayed.
	 * Date        : 05/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verifyReturnToListBtnIsDisplayed() throws Exception {
		assertTrue(this.page.element(
								warningPge
										+ "/div[3]/input[@value='Return to User List']",
								"xpath").isElementPresent(),
				"Return to User List button is not present.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to verify return to list button is displayed.
	 * Date        : 05/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList clickOnReturnToListBtn() throws Exception {
		objWaitForElement.waitForElements(warningPge
				+ "/div[3]/input[@value='Return to User List']",
		"xpath");
		this.page.element(
						warningPge
								+ "/div[3]/input[@value='Return to User List']",
						"xpath").getOne().click();
		objWaitForElement.waitForElements(createNewUserButton, "css");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to click on include inactive check box.
	 * Date        : 05/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList clickOnIncludeInactiveChkBox() throws Exception {
		objWaitForElement.waitForElements(includeInactiveChkBox, "id");
		assertTrue(this.page.element(includeInactiveChkBox, "id")
						.isElementPresent(), "Include inactive checkbox is not present.");
		this.page.element(includeInactiveChkBox, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to verify inactive user is present in a list
	 * Date        : 05/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verifyInactiveUserIsPresent(String strUserName,
			String strFulName) throws Exception {
		objWaitForElement.waitForElements(userListTable+ "td[2][text()='"+ strUserName+ "']/parent::tr/td[3][@title='user is not active'][text()='"
				+ strFulName + "']", "xpath");
		assertTrue(this.page.element(userListTable+ "td[2][text()='"+ strUserName+ "']/parent::tr/td[3][@title='user is not active'][text()='"
										+ strFulName + "']", "xpath")
						.isElementPresent(), "Inactive user " + strUserName+ " is not present.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to verify reactivated confirm message.
	 * Arguments   : strUserName
	 * Date        : 05/08/2014
	 * Author      : Renushree
	**********************************************************************************/
	public UsersList verifyReactivatedConfmMsg(String strUserName, String strFullName) throws Exception {
		objWaitForElement.waitForElements(warningPge + "/div[1]", "xpath");
		assertEquals("You have successfully re-activated "+strFullName+" (username: "+strUserName+")",
				this.page.element(warningPge + "/div[1]", "xpath")
						.getOne().getText());
		assertEquals("You or the user will need to reenter any email or pager addresses.",
				this.page.element(warningPge + "/div[2]", "xpath")
						.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'User profile' in Edit User Region page
	 * Date        : 05/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verUserProfileInEditUserRegions()
			throws Exception {
		objWaitForElement.waitForElements(userProfileInEditUserRegion, "xpath");
		assertTrue(this.page.element(userProfileInEditUserRegion, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Username' in Edit User Region page
	 * Date        : 05/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verUsernameInEditUserRegions() throws Exception {
		objWaitForElement.waitForElements(usernameInEditUserRegion, "xpath");
		assertTrue(this.page.element(usernameInEditUserRegion, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Full Name' in Edit User Region page
	 * Date        : 05/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verFullNameInEditUserRegions() throws Exception {
		objWaitForElement.waitForElements(fullNameInEditUserRegion, "xpath");
		assertTrue(this.page.element(fullNameInEditUserRegion, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Organization' in Edit User Region page
	 * Date        : 05/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verOrganizationInEditUserRegions() throws Exception {
		objWaitForElement.waitForElements(organizationInEditUserRegion, "xpath");
		assertTrue(this.page.element(organizationInEditUserRegion, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'User Regions' in Edit User Region page
	 * Date        : 05/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verUserRegionsInEditUserRegions() throws Exception {
		objWaitForElement.waitForElements(userRgionsInEditUserRegion, "xpath");
		assertTrue(this.page.element(userRgionsInEditUserRegion, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Regions' in Edit User Region page
	 * Date        : 05/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verRegionsInEditUserRegions() throws Exception {
		objWaitForElement.waitForElements(regionsInEditUserRegion, "xpath");
		assertTrue(this.page.element(regionsInEditUserRegion, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify rerify region check box is selected
	 * Date        : 05/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verRegionsCheckBoxIsSelectd(String strRegionValue) throws Exception {
		objWaitForElement.waitForElements("input[name='regionID'][value='" + strRegionValue
				+ "']", "css");
		assertTrue(this.page
				.dynamicElement(
						strRegionValue + " region value",
						"input[name='regionID'][value='" + strRegionValue
								+ "']", "css").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to 'deselect' the selected region
	 * Date        : 05/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList deselectRegion(String strRegionValue) throws Exception {
		objWaitForElement.waitForElements("input[name='regionID'][value='" + strRegionValue
				+ "']", "css");
		if (this.page
				.dynamicElement(
						strRegionValue + " region value",
						"input[name='regionID'][value='" + strRegionValue
								+ "']", "css").getOne().isSelected() == true) {
			this.page
					.dynamicElement(
							strRegionValue + " region value",
							"input[name='regionID'][value='" + strRegionValue
									+ "']", "css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Configure Region Views Option
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectConfigureRegionViewsOption() throws Exception {
		objWaitForElement.waitForElements(configureRegViews, "css");
		this.page.element(configureRegViews, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Setup Status Types Option
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectSetupStatusTypesOption() throws Exception {
		objWaitForElement.waitForElements(setupStatusTypes, "css");
		this.page.element(setupStatusTypes, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select setup resource types Option
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectSetupResourceTypesOption() throws Exception {
		objWaitForElement.waitForElements(setupResourceTypes, "css");
		this.page.element(setupResourceTypes, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select setup resource Option
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectSetupResourceOption() throws Exception {
		objWaitForElement.waitForElements(setupResource, "css");
		this.page.element(setupResource, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Edit Multi-Region Event Rights 
	 * Date :11/06/2014 
	 * Author : Anil
	 **********************************************************************************/
	public UsersList verifyEditMultiRegionEventRights() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Edit Multi-Region Event Rights']", "xpath");
		assertEquals("Edit Multi-Region Event Rights", this.page.element(header, "css")
				.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify select All Button is displayed
	 * Date        : 06/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verifySelectAllButton() throws Exception {
		objWaitForElement.waitForElements(selectAllButton, "css");
		assertTrue(this.page.element(selectAllButton, "css").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify save Button is displayed
	 * Date        : 06/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verifySaveButton() throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		assertTrue(this.page.element(saveButton, "css").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify cancel Button is displayed
	 * Date        : 06/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verifyCancelButton() throws Exception {
		objWaitForElement.waitForElements(cancelButton, "css");
		assertTrue(this.page.element(cancelButton, "css").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify region names to provide multi region access
	 * Date        : 04/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verifyRegionName(String strRegionValue) throws Exception {
		objWaitForElement.waitForElements("input[name='userRegionID'][value='"+ strRegionValue + "']", "css");
		assertTrue(this.page.dynamicElement(strRegionValue+" region value", "input[name='userRegionID'][value='"+ strRegionValue + "']", "css").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Edit User page is displayed
	 * Date :04/08/2014
	 * Author : Anil
	 **********************************************************************************/
	public UsersList verifyEditUserPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Edit User']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Edit User']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Edit User page is displayed
	 * Date :04/08/2014
	 * Author : Anil
	 **********************************************************************************/
	public UsersList verifyUserListPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Users List']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Users List']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to 'deselect' the View Resource check box
	 * Date        : 05/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList deselectViewResourceCheckBox(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tbl_association']/tbody/tr/td[5][text()='"
						+ strResourceName + "']/parent::tr/td[4]/input",
				"xpath");
		if (this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[5][text()='"
								+ strResourceName + "']/parent::tr/td[4]/input",
						"xpath").getOne().isSelected() == true) {
			this.page.element(
					"//table[@id='tbl_association']/tbody/tr/td[5][text()='"
							+ strResourceName + "']/parent::tr/td[4]/input",
					"xpath").mouseOver();
			this.page
					.element(
							"//table[@id='tbl_association']/tbody/tr/td[5][text()='"
									+ strResourceName
									+ "']/parent::tr/td[4]/input", "xpath")
					.getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to click on 'Refine' link in View resource
	 * Date        : 05/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList clickRefineLinkOfViewResource(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[5][text()='"
				+ strResourceName
				+ "']/parent::tr/td[4]/a[text()='Refine']",
		"xpath");
		this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[5][text()='"
								+ strResourceName
								+ "']/parent::tr/td[4]/a[text()='Refine']",
						"xpath").getOne().click();
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to 'deselect' the Refine Visible Status Types page checkBox
	 * Date        : 05/08/2014
	 * Author      : Sowmya
	 *******************************************************************************************/
	public UsersList deselectStatusTypesInRefine(String[] strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements(
				"//input[@name='statusTypeID'][@value='"
						+ strStatusTypeValue[0] + "']", "xpath");
		for (int count = 0; count < strStatusTypeValue.length; count++) {
			if (this.page
					.dynamicElement(
							strStatusTypeValue + " status type value",
							"//input[@name='statusTypeID'][@value='"
									+ strStatusTypeValue[count] + "']", "xpath")
					.getOne().isSelected()==true) {
				this.page
						.dynamicElement(
								strStatusTypeValue + " status type value",
								"//input[@name='statusTypeID'][@value='"
										+ strStatusTypeValue[count] + "']",
								"xpath").mouseOver();
				this.page
						.dynamicElement(
								strStatusTypeValue + " status type value",
								"//input[@name='statusTypeID'][@value='"
										+ strStatusTypeValue[count] + "']",
								"xpath").getOne().sendKeys(Keys.SPACE);
			}
		}
		return this;

	}
	
	/**************************************************************************************
	  * Description : This function is to select frame in Refine Visible Status Types page
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  ************************************************************************************/
	public UsersList selectFrameOfRefineVisibleStatusTypes() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(strFrame));
		return this;
	}
	
	/*****************************************************************************************************
	 * Description : This function is to click on 'Save changes' button in Refine Visible Status Types page
	 * Date        : 07/08/2014
	 * Author      : Sowmya
	 *****************************************************************************************************/
	public UsersList clickSaveChangesButtonInRefine() throws Exception {
		objWaitForElement.waitForElements(saveChangesBtnInRefine, "xpath");
		this.page.element(saveChangesBtnInRefine, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on acknowledge nootification
	 * Date : 10/06/2014 
	 * Author : Anil
	 **********************************************************************************/
	public UsersList selectFrame() throws Exception {
		driver.switchTo().window("");
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(strDataFrame));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select view custom view Option
	 * Date        : 12/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectViewcustomViewOption() throws Exception {
		objWaitForElement.waitForElements(viewcustomView, "css");
		this.page.element(viewcustomView, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify refine visible status types window is displayed.
	 * Date        : 12/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verRefineVisiblesttausTypesWinIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(refineVisibleStatusTypeWin, "id");
		assertEquals("Refine Visible Status Types",
				this.page.element(refineVisibleStatusTypeWin, "id").getOne()
						.getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select second Role
	 * Date        : 13/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectSecRole() throws Exception {
		objWaitForElement.waitForElements(secRole, "xpath");
		this.page.element(secRole, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to Select the roles
	   * Date        : 13/08/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public UsersList selectRoleCheckBox(String[] strRoleValues)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strRoleValues[0]
				+ "'][@name='userRoleID']", "xpath");
		this.deSelectFirstRole();
		for (int i = 0; i < strRoleValues.length; i++) {
			this.page
					.dynamicElement(
							"strRoleValues",
							"//input[@value='" + strRoleValues[i]
									+ "'][@name='userRoleID']", "xpath")
					.getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select the 'View Resource' check box
	 * Date        : 13/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectViewResourceCheckBox(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tbl_association']/tbody/tr/td[text()='"
						+ strResourceName
						+ "']/preceding-sibling::td/input[@name='viewRight']",
				"xpath");
		if (this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[text()='"
								+ strResourceName
								+ "']/preceding-sibling::td/input[@name='viewRight']",
						"xpath").getOne().isSelected() == false) {

			this.page.element(
					"//table[@id='tbl_association']/tbody/tr/td[text()='"
							+ strResourceName
							+ "']/preceding-sibling::td/input[@name='viewRight']",
					"xpath").mouseOver();
			this.page
					.element(
							"//table[@id='tbl_association']/tbody/tr/td[text()='"
									+ strResourceName
									+ "']/preceding-sibling::td/input[@name='viewRight']",
							"xpath")
					.getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select the 'Run Report' check box
	 * Date        : 13/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectRunReportsCheckBox(String strResourceName)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@id='tbl_association']/tbody/tr/td[text()='"
								+ strResourceName
								+ "']/preceding-sibling::td/input[@name='reportRight']",
						"xpath");
		if (this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[text()='"
								+ strResourceName
								+ "']/preceding-sibling::td/input[@name='reportRight']",
						"xpath").getOne().isSelected() == false) {
			this.page
					.element(
							"//table[@id='tbl_association']/tbody/tr/td[text()='"
									+ strResourceName
									+ "']/preceding-sibling::td/input[@name='reportRight']",
							"xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on region names in multi region access
	 * Date        : 03/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList clickOnRegionName(String strRegionValue) throws Exception {
		objWaitForElement.waitForElements("input[name='userRegionID'][value='" + strRegionValue
				+ "']", "css");
		this.page
				.dynamicElement(
						strRegionValue + " region value",
						"input[name='userRegionID'][value='" + strRegionValue
								+ "']", "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select System Notification Preferences
	 * option Date : 04/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList clickSystemNotificationPreferences() throws Exception {
		objWaitForElement.waitForElements(SystemNotificationPreferences, "linktext");
		this.page.element(SystemNotificationPreferences, "linktext").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Expired Status Notifications Email CheckBox
	 * option Date : 04/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList clickExpiredStatusNotificationsEmailCheckBox()
			throws Exception {
		objWaitForElement.waitForElements(ExpiredStatusNotificationsEmailCheckBox, "xpath");
		this.page.element(ExpiredStatusNotificationsEmailCheckBox, "xpath")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Expired Status Notifications Email CheckBox
	 * option Date : 04/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList clickExpiredStatusNotificationsTextPagerCheckBox()
			throws Exception {
		objWaitForElement.waitForElements(ExpiredStatusNotificationsTextPagerCheckBox, "xpath");
		this.page.element(ExpiredStatusNotificationsTextPagerCheckBox, "xpath")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on ok button
	  * Date        : 04/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public UsersList clickOnOkButton() throws Exception {	
		Thread.sleep(5000);  
		Alert alert = driver.switchTo().alert();
		  alert.accept();
		  Thread.sleep(5000); 
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Configure Multi Region Views Option
	 * Date        : 08/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectConfigureMultiRegionViewsOption() throws Exception {
		objWaitForElement.waitForElements(configureMultiRegViews, "css");
		this.page.element(configureMultiRegViews, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Report - Status Snapshot option
	 * Date        : 09/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectReportStatusSnapshotOption() throws Exception {
		objWaitForElement.waitForElements(reportStatusSnapshot, "css");
		this.page.element(reportStatusSnapshot, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Maintain Document Library Option
	 * Date        : 10/09/2014
	 * Author      : Sinchana
	 **********************************************************************************/
	public UsersList selecMaintainDocumentLibraryOption() throws Exception {
		objWaitForElement.waitForElements(maintainDocumentLibrary, "css");
		this.page.element(maintainDocumentLibrary, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Edit Regional Message Bulletin Board Option
	 * Date        : 10/09/2014
	 * Author      : Sinchana
	 **********************************************************************************/
	public UsersList selectEditRegionalMessageBulletinBoard() throws Exception {
		objWaitForElement.waitForElements(editRegionalMessageBulletinBoard, "css");
		this.page.element(editRegionalMessageBulletinBoard, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Must update overdue status Option
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList selectMustUpdateOverdueStatusOption() throws Exception {
		objWaitForElement.waitForElements(mustUpdateOverDueStatus, "css");
		this.page.element(mustUpdateOverDueStatus, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Report - Event Snapshot option
	 * Date        : 10/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectReportEventSnapshotOption() throws Exception {
		objWaitForElement.waitForElements(reportEventSnapshot, "css");
		this.page.element(reportEventSnapshot, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'May Update Region Setup Information' Option
	 * Date        : 11/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectMayUpdateRegionSetupInformationOption() throws Exception {
		objWaitForElement.waitForElements(mayUpdateRegionSetupInformation, "css");
		this.page.element(mayUpdateRegionSetupInformation, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Report - Event Detail option
	 * Date        : 11/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectReportEventDetailOption() throws Exception {
		objWaitForElement.waitForElements(reportEventDetail, "css");
		this.page.element(reportEventDetail, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Report - Status reason Detail option
	 * Date        : 15/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectReportStatusReasonDetailOption() throws Exception {
		objWaitForElement.waitForElements(reportStatusResDetail, "css");
		this.page.element(reportStatusResDetail, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Report - Status reason Summary option
	 * Date        : 16/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectReportStatusReasonSummaryOption() throws Exception {
		objWaitForElement.waitForElements(reportStatusResSumry, "css");
		this.page.element(reportStatusResSumry, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Report - Status Summary option
	 * Date        : 17/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectReportStatusSummaryOption() throws Exception {
		objWaitForElement.waitForElements(reportStatusSummary, "css");
		this.page.element(reportStatusSummary, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Report - Status Detail option
	 * Date        : 18/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectReportStatusDetailOption() throws Exception {
		objWaitForElement.waitForElements(reportStatusDetail, "css");
		this.page.element(reportStatusDetail, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Report - Status Summary option
	 * Date        : 17/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectIncomingPatientNotificationOption() throws Exception {
		objWaitForElement.waitForElements(incomingPatientNotification, "css");
		this.page.element(incomingPatientNotification, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Resource Name' option
	 * Date        : 04/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verResourceNameIsNotPresent(String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[text()='"
				+ strResourceName + "']", "xpath");
		assertFalse(this.page.element(
				"//table[@id='tbl_association']/tbody/tr/td[text()='"
						+ strResourceName + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Edit status change notification preference option
	 * Date        : 23/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectEditStatusChangeNotPrefernceOption() throws Exception {
		objWaitForElement.waitForElements(editStatuschangeNotificationPreference, "css");
		this.page.element(editStatuschangeNotificationPreference, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Edit Resources Only' option
	 * Date        : 24/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectEditResourcesOnlyOption() throws Exception {
		objWaitForElement.waitForElements(editResourcesOnly, "css");
		this.page.element(editResourcesOnly, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Resource Name' is not displayed 
	 * Date        : 23/09/2014
	 * Arguements  :strResourceName
	 * Author      : Prasanna Lakshmi
	 **********************************************************************************/
	public UsersList verResourceNameNotDispalyed(String strResourceName) throws Exception {
		assertFalse(this.page.element(
				"//table[@id='tbl_association']/tbody/tr/td[text()='"
						+ strResourceName + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify RoleName is displayed in Edit User Page
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public UsersList verifyRoleNameInEditUserPage(String strRoleValues) throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strRoleValues + "'][@name='userRoleID']",
				"xpath");
		assertTrue(this.page.dynamicElement("strRoleValues",
				"//input[@value='" + strRoleValues + "'][@name='userRoleID']",
				"xpath").getOne().isDisplayed());

		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Edit User Page is displayed 
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	 public UsersList verEditUserPageisDisplayed() throws Exception {
		objWaitForElement.waitForElements(headerName, "css");	
	  	  assertEquals("Edit User", this.page.element(headerName, "css").getOne().getText());
	  return this;
	 }
	 
	 /**********************************************************************************
	  * Description : This function is to verify ResourceName is displayed in Edit User Page
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	 public UsersList verResourceNameIsDisplayedInEditUserPage(String strResourceName) throws Exception {
			objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[5][text()='"+strResourceName+"']","xpath");		 
			assertTrue(this.page.element("//table[@id='tbl_association']/tbody/tr/td[5][text()='"+strResourceName+"']","xpath").isElementPresent());
			return this;
		}
	 
	 /**********************************************************************************
	  * Description : This function is to verify ResourceName is displayed in Edit User Page
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	 public UsersList verResourceTypeIsDisplayedInEditUserPage(String strResourceTypeName) throws Exception {
			objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[6][text()='"+strResourceTypeName+"']","xpath");
			assertTrue(this.page.element("//table[@id='tbl_association']/tbody/tr/td[6][text()='"+strResourceTypeName+"']","xpath").getOne().isDisplayed());
			return this;
		}
	 
	 /**********************************************************************************
		 * Description : This function is to verify user not present in list.
		 * Date 	   : 30/07/2014
		 * Author      : Rensuhree
	 **********************************************************************************/
	public UsersList verUserNotInList(String strUserName) throws Exception {
		assertFalse(this.page.element(
				userListTable + "td[2][text()='" + strUserName + "']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
		
	/**********************************************************************************
		 * Description : This function is to seelct view other region view of particular region
		 * Date 	   : 30/07/2014
		 * Author      : Rensuhree
	 **********************************************************************************/
	public UsersList selectViewOtherRegView(String strRegionVal)
			throws Exception {
		objWaitForElement.waitForElements("input[name='otherRegionViewID'][value='"
				+ strRegionVal + "']", "css");
		this.page
				.element(
						"input[name='otherRegionViewID'][value='"
								+ strRegionVal + "']", "css").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Name in edit  userpage
	  * Arguments	: 
	  * Date        : 07/10/2014
	  * Author      : shradha
	  **********************************************************************************/
	public UsersList verNameInEditUserPage(String strNewUserName)
			throws Exception {
		objWaitForElement.waitForElements(username, "name");
		String strFileNameInApp = this.page.element(username, "name").getOne()
				.getAttribute("value");
		assertEquals(strNewUserName, strFileNameInApp);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Name in edit  userpage
	  * Arguments	: 
	  * Date        : 07/10/2014
	  * Author      : shradha
	  **********************************************************************************/
	public UsersList verFullNameInEditUserPage(String strFullName)
			throws Exception {
		objWaitForElement.waitForElements(FullName, "name");
		String strFileNameInApp = this.page.element(FullName, "name").getOne()
				.getAttribute("value");
		assertEquals(strFullName, strFileNameInApp);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify viewresource CHECKBOX IS Selected
	 * Arguments   : strResourceName
	 * Date 	   : 07/07/2014
	 * Author      : shradha 
	 **********************************************************************************/
	public UsersList verViewResourceCheckBoxIsChecked(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[5][text()='"
				+ strResourceName
				+ "']/preceding-sibling::td[1]/input[@checked='checked']",
		"xpath");
		assertTrue(this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[5][text()='"
								+ strResourceName
								+ "']/preceding-sibling::td[1]/input[@checked='checked']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to remove emails from user
	 * Date 	   : 10/07/2014
	 * Author      : shradha 
	 **********************************************************************************/
	public UsersList removeEmailsFromUser()throws Exception {
		objWaitForElement.waitForElements(primaryEMail, "name");
		this.page.element(primaryEMail, "name").clearInputValue();
		this.page.element(email, "css").clearInputValue();
		this.page.element(textPager, "name").clearInputValue();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select Report - Incoming patient notification option
	 * Date        : 07/10/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList selectReportIncomingPatientNotificationOption() throws Exception {
		objWaitForElement.waitForElements(reportIncomingPatientNotification, "css");
		this.page.element(reportIncomingPatientNotification, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Receive Incoming Patient Notifications option
	 * Date        : 20/10/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectReceiveIncomingPatientNotificationsOption()
			throws Exception {
		objWaitForElement.waitForElements(incomingPatientNotifications, "css");
		this.page.element(incomingPatientNotifications, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Form - Do not participate in forms for resources' option
	 * Date        : 22/10/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectFormDoNotParticipateInFormsForResourcesOption()
			throws Exception {
		objWaitForElement.waitForElements(formDoNotParticipateInFormsForResourcesOption, "css");
		this.page.element(formDoNotParticipateInFormsForResourcesOption, "css")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter UserDetails Date : 26/06/2014
	 * Author : Sowmya
	 **********************************************************************************/
	public UsersList enterUserMandatoryDetails(String strusername, String strPassword,
			String strFullName) throws Exception {
		this.enterUsername(strusername);
		this.enterPassword("Abcd@1234");
		this.enterConfirmPassword("Abcd@1234");
		this.enterFullName(strFullName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to deactivate user
	  * Date		: 23/07/2014
	  * Author		: Anitha
	  **********************************************************************************/
	public UsersList deactivateUser() throws Exception {	
		objWaitForElement.waitForElements(deactivateUser, "css");
		this.page.element(deactivateUser, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to reactivate user
	  * Date		: 23/07/2014
	  * Author		: Anitha
	  **********************************************************************************/
	public UsersList reactivateUser() throws Exception {
		objWaitForElement.waitForElements(reactivateUser, "css");
		if (this.page.element(reactivateUser, "css").getOne().isSelected()== false)
			this.page.element(reactivateUser, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Edit' option is not displayed
	 * Date        : 20/11/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verifyEditAndPasswordLinksAreNotPresentforUser(String strUserName) throws Exception {
		assertFalse(this.page.element(
				"//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
						+ strUserName + "']/parent::tr/td[1]/a[text()='Edit']",
				"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select view resource right
	 * Date        : 20/11/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList selectAssosciateResourceRight(String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[text()='"+strResourceName+"']/preceding-sibling::td/input[@name='association']",
				"xpath");
		if (this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[text()='"+strResourceName+"']/preceding-sibling::td/input[@name='association']",
						"xpath").getOne().isSelected() == false ) {
			this.page
					.element(
							"//table[@id='tbl_association']/tbody/tr/td[text()='"+strResourceName+"']/preceding-sibling::td/input[@name='association']", "xpath")
					.getOne().click();
		}
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to select view resource right
	 * Date        : 20/11/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList selectRunReportRight(String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[text()='"+strResourceName+"']/preceding-sibling::td/input[@name='reportRight']",
				"xpath");
		if (this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[text()='"+strResourceName+"']/preceding-sibling::td/input[@name='reportRight']",
						"xpath").getOne().isSelected() == false ) {
			this.page
					.element(
							"//table[@id='tbl_association']/tbody/tr/td[text()='"+strResourceName+"']/preceding-sibling::td/input[@name='reportRight']", "xpath")
					.getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on System Notifications Email CheckBox
	 * option Date : 05/12/2014 
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList clickSystemNotificationsEmailCheckBox() throws Exception {
		objWaitForElement.waitForElements(systemNotificationEmail, "css");
		this.page.element(systemNotificationEmail, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on System Notifications Pager CheckBox
	 * option Date : 05/12/2014 
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList clickSystemNotificationsPagerCheckBox() throws Exception {
		objWaitForElement.waitForElements(systemNotificationPager, "css");
		this.page.element(systemNotificationPager, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on System Notifications Web CheckBox
	 * option Date : 05/12/2014 
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList clickSystemNotificationsWebCheckBox() throws Exception {
		objWaitForElement.waitForElements(systemNotificationWeb, "css");
		this.page.element(systemNotificationWeb, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on System Notifications CheckBox
	 * option Date : 05/12/2014 
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selSystemNotificationsCheckBoxes() throws Exception {
		this.clickSystemNotificationsEmailCheckBox();
		this.clickSystemNotificationsPagerCheckBox();
		this.clickSystemNotificationsWebCheckBox();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select user - view user information only
	 * Date        : 08/12/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectUserViewUserInformationOnlyOption()
			throws Exception {
		objWaitForElement.waitForElements(viewUserInformationOnly, "css");
		this.page.element(viewUserInformationOnly, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify fullname
	 * Date        : 08/12/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verFullName(String strFullName)
			throws Exception {
		objWaitForElement.waitForElements(userListTable + "td[3]", "xpath");
		assertEquals(strFullName, this.page.element(userListTable + "td[3]", "xpath").getOne().getText());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to select Report - Status reason Summary option
	 * Date        : 16/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList selectMonthlyStatusAssignmentOption() throws Exception {
		objWaitForElement.waitForElements(reportMonthlyStatusSumry, "css");
		this.page.element(reportMonthlyStatusSumry, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify user  present in list.
	  * Date     : 11/12/2014
	  * Author      : sangappa.k
	    **********************************************************************************/
	public UsersList verUserInList(String strUserName) throws Exception {
		objWaitForElement.waitForElements(userListTable + "td[2][text()='" + strUserName + "']", "xpath");
		assertTrue(this.page.element(
				userListTable + "td[2][text()='" + strUserName + "']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Form - User may activate forms  option
	 * Date        : 15/12/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectFormUserMayActivateFormsOption() throws Exception {
		objWaitForElement.waitForElements(formActivate, "css");
		this.page.element(formActivate, "css").getOne().click();
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to select Form - User may activate and Modify forms  option
	 * Date        : 15/12/2014
	 * Author      : Renushree
	 ********************************************************************************************/
	public UsersList selectFormUserMayActivateAndModifyFormsOption() throws Exception {
		objWaitForElement.waitForElements(userMayActivateAndModifyForms, "css");
		this.page.element(userMayActivateAndModifyForms, "css").getOne().click();
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to select Form - User may Configure Form Security
	 * Date        : 15/12/2014
	 * Author      : Renushree
	 ********************************************************************************************/
	public UsersList selectFormUserMayConfigureFormSecurity() throws Exception {
		objWaitForElement.waitForElements(userMayConfigureFormSecurity, "css");
		this.page.element(userMayConfigureFormSecurity, "css").getOne().click();
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to select Report - Form Detail
	 * Date        : 05/01/2015
	 * Author      : Renushree
	 ********************************************************************************************/
	public UsersList selectReportformDetail() throws Exception {
		objWaitForElement.waitForElements(reportFormDetail, "css");
		this.page.element(reportFormDetail, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Report - Event Detail option
	 * Date        : 11/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectSetUpRolesRight() throws Exception {
		objWaitForElement.waitForElements(setUpRoles, "css");
		this.page.element(setUpRoles, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Deslect Assosciated With 'Select all' option
	 * Date        : 13/01/2015
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList deselectAssosciatedWithRight() throws Exception {	
		objWaitForElement.waitForElements(assosciatedWith, "xpath");
		if(this.page.element(assosciatedWith, "xpath").getOne().isSelected()==false){
			this.page.element(assosciatedWith, "xpath").getOne().click();
			Thread.sleep(2000);
		}
		this.page.element(assosciatedWith, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on save button
	 * Date        : 28/01/2015
	 * Author      : Hanumegowda
	 **********************************************************************************/

	public UsersList clickSaveButton1() throws Exception {
		objWaitForElement.waitForElements(saveButton1, "xpath");
		this.page.element(saveButton1, "xpath").getOne().click();
		return this;	
	}

	/**********************************************************************************
	 * Description : This function is to deselect view resource right of all resources.
	 * Date        : 04/03/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList deselectAllViewResReightOption() throws Exception {
		objWaitForElement.waitForElements(viewResource, "xpath");
		if(this.page.element(viewResource, "xpath").getOne().isSelected()==true){
			this.page.element(viewResource, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select webservice checkbox.
	 * Date        : 27/04/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectWebServiceChkBox() throws Exception {
		if (this.page.element(webServiceChkBox, "css").getOne().isSelected() == false) {
			this.page.element(webServiceChkBox, "css").getOne().click();
		}
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to click on event notification preferences
	 * Date        : 29/04/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList clickOnEveNotPreferences() throws Exception {
		objWaitForElement.waitForElements(eventNotificationPreference, "linktext");
		this.page.element(eventNotificationPreference, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on event notification preferences
	 * Date        : 29/04/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verEveTemplateListed(String strEveTemplate) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Event Notification Preferences']/tbody/tr/td[1][text()='"
						+ strEveTemplate + "']", "xpath");
		assertTrue(
				this.page.element(
						"//table[@summary='Event Notification Preferences']/tbody/tr/td[1][text()='"
								+ strEveTemplate + "']", "xpath")
						.isElementPresent(), "Event Template is not listed");
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to click on event notification preferences
	 * Date        : 29/04/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verEveTemplateNotListed(String strEveTemplate)
			throws Exception {
		assertFalse(
				this.page.element(
						"//table[@summary='Event Notification Preferences']/tbody/tr/td[1][text()='"
								+ strEveTemplate + "']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Event Template is listed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Event Notification Preferences Page is displayed 
	  * Date        : 29/04/2015
	 * Author       : Renushree
	  **********************************************************************************/
	public UsersList verEventNotificationPreferencesPageisDisplayed(
			String strUser) throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Event Notification Preferences for " + strUser + "",
				this.page.element(headerName, "css").getOne().getText());
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to verify 'Report - Form Detail' right not present.
	 * Date        : 11/May/2015
	 * Author      : Renushree
	 ********************************************************************************************/
	public UsersList verReportFormDetailRightNotPresent() throws Exception {
		assertFalse(
				this.page
						.element(
								"//td[text()='Report - Form Detail']/input[@value='45']",
								"xpath").isElementPresent(
								WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Report - Form Detail is present");
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to verify 'Report - Form Reports' right present.
	 * Date        : 11/May/2015
	 * Author      : Renushree
	 ********************************************************************************************/
	public UsersList verReportFormReportsRightPresent() throws Exception {
		assertTrue(
				this.page
						.element(
								"//td[text()='Report - Form reports']/input[@value='45']",
								"xpath").isElementPresent(),
				"Report - Form Reports is not present");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select all the check boxes present under 'Advance Option' section.
	 * Date        : 15/May/2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public UsersList clickallcheckboxes() throws Exception {
		objWaitForElement.waitForElements(allCheckBoxes, "xpath");
		java.util.List<org.openqa.selenium.WebElement> checkbox = driver
				.findElements(By.xpath(allCheckBoxes));

		for (org.openqa.selenium.WebElement allcheckboxes : checkbox) {
			if (!allcheckboxes.isSelected()) {
				allcheckboxes.click();
			}
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Setup Status Reason Option
	 * Date        : 27/May/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectSetupStatusReasonOption() throws Exception {
		objWaitForElement.waitForElements(setupStatusReason, "css");
		this.page.element(setupStatusReason, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Many users meet your search criteria, 
	 * 				 but only '___' are shown. Click here to show all ___ users' link if it s displayed
	 * Date        : 02-Jun-2015
	 * Author      : Pallavi
	 **********************************************************************************/
	public UsersList clickOnShowAllUsersIfPresent() throws Exception {
		objWaitForElement.waitForElements(createNewUserButton, "css");
		if (this.page.element(showAllUsersLink, "xpath").getOne().isDisplayed() == true) {
			this.page.element(showAllUsersLink, "xpath").getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Password' link
	 * Date        : 02-Jun-2015
	 * Author      : Pallavi
	 **********************************************************************************/
	public UsersList clickOnPasswordLink(String strUserName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
						+ strUserName
						+ "']/parent::tr/td[1]/a[text()='Password']", "xpath");
		this.page
				.element(
						"//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
								+ strUserName
								+ "']/parent::tr/td[1]/a[text()='Password']",
						"xpath").getOne().click();
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to select administer Other Region Views option
	 * Date        : 15/12/2014
	 * Author      : Anil
	 ********************************************************************************************/
	public UsersList selectadministerOtherRegionViewsOption() throws Exception {
		objWaitForElement.waitForElements(administerOtherRegionViews, "css");
		this.page.element(administerOtherRegionViews, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to deselect the roles
	   * Date        : 13/08/2014
	   * Author      : Anil
	   **********************************************************************************/
	public UsersList deSelectRoleCheckBox(String[] strRoleValues)
			throws Exception {
		String strElement = "//input[@value='" + strRoleValues[0]
				+ "'][@name='userRoleID']";
		
		objWaitForElement.waitForElements(strElement, "xpath");
		for (int i = 0; i < strRoleValues.length; i++) {
			if(this.page
					.element(strElement, "xpath")
					.getOne().isSelected()){
				this.page
				.element(strElement, "xpath")
				.getOne().click();	
			}
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Instant Messaging - Initiate Chat Session option
	 * Date        : 04-Jun-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public UsersList selectInstantMessagingInitiateChatSessionOption()
			throws Exception {
		objWaitForElement.waitForElements(instantMessagingInitiateChatSession,
				"css");
		this.page.element(instantMessagingInitiateChatSession, "css").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to Select the role
	   * Date        : 08/06/2015
	   * Author      : Renushree
	   **********************************************************************************/
	public UsersList selectRoleCheckBox(String strRoleValues) throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strRoleValues
				+ "'][@name='userRoleID']", "xpath");
		this.deSelectFirstRole();
		if (this.page
				.dynamicElement(
						"strRoleValues",
						"//input[@value='" + strRoleValues
								+ "'][@name='userRoleID']", "xpath").getOne()
				.isSelected() == false) {
			this.page
					.dynamicElement(
							"strRoleValues",
							"//input[@value='" + strRoleValues
									+ "'][@name='userRoleID']", "xpath")
					.getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to clear Username in 'Search' input field
	 * Date        : 08/06/2015
	 * Author      : Rensuhree
	 **********************************************************************************/
	public UsersList clearUsernameInSearchInputField()
			throws Exception {
		objWaitForElement.waitForElements(searchInputField, "id");
		this.page.element(searchInputField, "id").clearInputValue();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify create User page is displayed
	 * Date :04/08/2014
	 * Author : Anil
	 **********************************************************************************/
	public UsersList verifyCreateUserPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Create New User']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Create New User']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Switch' Link corresponding to username
	 * Date        : 08-Jun-2015
	 * Author      : Pallavi
	 **********************************************************************************/
	public UsersList clickOnSwitchLink(String strUserName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tblUsers']/tbody/tr/td[2]"
				+ "[text()='" + strUserName
				+ "']/parent::tr/td[1]/a[text()='Switch']", "xpath");
		this.page.element("//table[@id='tblUsers']/tbody/tr/td[2]"
				+ "[text()='" + strUserName
				+ "']/parent::tr/td[1]/a[text()='Switch']", "xpath").getOne().click();
		objWaitForElement.waitForElements(username, "name");
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on Status Change Notification Preferences
	 * Date 		: 16/Jun/2015
	 * Author 		: Renushree
	 **********************************************************************************/
	public UsersList clickStatusChangeNotificationPreferencesIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(statusChangeNotificationPreferences,
				"linktext");
		this.page.element(statusChangeNotificationPreferences, "linktext")
				.getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select Report - Monthly Status Assessment
	 * Date        : 19/06/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public UsersList selectReporMonthlyStatusAssessment() throws Exception {
		objWaitForElement.waitForElements(monthlyStatusAssesment, "css");
		this.page.element(monthlyStatusAssesment, "css").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select Report - Statewide Resource Detail
	 * Date        : 19/06/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public UsersList selectReportStatewideResourceDetail() throws Exception {
		objWaitForElement.waitForElements(statewideResource, "css");
		this.page.element(statewideResource, "css").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select Report Audit Resource Detail
	 * Date        : 19/06/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public UsersList selectReporAuditResourceDetail() throws Exception {
		objWaitForElement.waitForElements(auditResource, "css");
		this.page.element(auditResource, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user name is displayed at the footer of application
	 * Date        : 19/06/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public UsersList verUserNameIsDispaledAtFooterOfApp(String userName, String fullName) throws Exception {
		String userNameAtFooter="//div[@id='footer']/table/tbody/tr/td[@class='ftRt']";
		objWaitForElement.waitForElements(userNameAtFooter, "xpath");
       String Userdetail =this.page.element(userNameAtFooter, "xpath").getOne().getText();
       System.out.println(Userdetail);
       String Userdetail1=fullName+" ("+userName+")";
       System.out.println(Userdetail1);
       assertTrue(Userdetail.startsWith(Userdetail1)); 
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user full name is displayed at the footer of application
	 * Date        : 24/06/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public UsersList veruserFullNameAtFooterOfApp(String fullName) throws Exception {
		
		objWaitForElement.waitForElements(footer, "xpath");
       String fullname =this.page.element(footer, "xpath").getOne().getText();
       System.out.println(fullname);
       assertTrue(fullname.startsWith(fullName)); 
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Edit User Region Page is displayed 
	  * Date        : 30/Jun/2015
	  * Author      : Renushree
	  **********************************************************************************/
	 public UsersList verEditUserRegionPageisDisplayed() throws Exception {
		objWaitForElement.waitForElements(headerName, "css");	
	  	  assertEquals("Edit User Regions", this.page.element(headerName, "css").getOne().getText());
	  return this;
	 }
	 
	 /**********************************************************************************
	 * Description : This function is to verify rerify region check box is not selected
	 * Date        : 30/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verRegionsCheckBoxIsNotSelectd(String strRegionValue) throws Exception {
		assertFalse(this.page
				.dynamicElement(
						strRegionValue + " region value",
						"input[name='regionID'][value='" + strRegionValue
								+ "']", "css").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify select Form - User may activate and modify forms  option is selected
	 * Date        : 01/Jul/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verSelectFormUserMayActivateandModifyFormsOptionIsSelected()
			throws Exception {
		objWaitForElement.waitForElements(userMayActivateAndModifyForms, "css");
		assertTrue(
				this.page.element(userMayActivateAndModifyForms, "css").getOne().isSelected(),
				"Form - User may activate and modify forms option is selected.");
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to deselect the roles
	   * Date        : 13/08/2014
	   * Author      : Anil
	   **********************************************************************************/
	public UsersList deselectRoleCheckBox(String[] strRoleValues)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strRoleValues[0]
				+ "'][@name='userRoleID']", "xpath");
		for (int i = 0; i < strRoleValues.length; i++) {

			if (this.page
					.dynamicElement(
							"strRoleValues",
							"//input[@value='" + strRoleValues[i]
									+ "'][@name='userRoleID']", "xpath")
					.getOne().isSelected() == true) {

				this.page.dynamicElement(
						"strRoleValues",
						"//input[@value='" + strRoleValues[i]
								+ "'][@name='userRoleID']", "xpath")
						.mouseOver();
				this.page
						.dynamicElement(
								"strRoleValues",
								"//input[@value='" + strRoleValues[i]
										+ "'][@name='userRoleID']", "xpath")
						.getOne().sendKeys(Keys.SPACE);
				;
			}
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify select Form - User may activate and modify forms  option not available
	 * Date        : 15/12/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verSelectFormUserMayActivateAndModifyFormsOptionNotAvl()
			throws Exception {
		assertFalse(
				this.page.element(userMayActivateAndModifyForms, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Form - User may activate and modify forms option is available");
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to verify select Form - User may activate and modify forms  option not available
	 * Date        : 15/12/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verSelectFormUserMayActivateAndModifyFormsOptionNotDisplayed()
			throws Exception {
		assertFalse(
				this.page.element(userMayActivateAndModifyForms, "css").getOne().isDisplayed(),
				"Form - User may activate and modify forms option is available");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to 'deselect' the associate right check box
	 * Date        : 02/Jul/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList deselectAssociatedRightCheckBox(String strResourceName)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@id='tbl_association']/tbody/tr/td[text()='"
								+ strResourceName
								+ "']/preceding-sibling::td/input[@name='association']",
						"xpath");
		if (this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[text()='"
								+ strResourceName
								+ "']/preceding-sibling::td/input[@name='association']",
						"xpath").getOne().isSelected()) {

			this.page
					.element(
							"//table[@id='tbl_association']/tbody/tr/td[text()='"
									+ strResourceName
									+ "']/preceding-sibling::td/input[@name='association']",
							"xpath").mouseOver();
			this.page
					.element(
							"//table[@id='tbl_association']/tbody/tr/td[text()='"
									+ strResourceName
									+ "']/preceding-sibling::td/input[@name='association']",
							"xpath").getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify error heading
	 * Date        : 02/Jul/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verErrorHeading() throws Exception {
		assertEquals("The following error occurred on this page:", this.page
				.element(errorHeading, "xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify error heading
	 * Date        : 02/Jul/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verErrorMsgWhenViewResNotGiven() throws Exception {
		assertEquals(
				"A user that has any of Associated With, Update Status, or Run Reports for a resource must have View Resource.",
				this.page.element(errorMsg, "xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to deselect update status right of resource
	 * Date        : 02/Jul/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList deselectUpdateStatusOfResource(String strResource)
			throws Exception {
		String strAdministerUser = "//table[@id='tbl_association']/tbody/tr/td[text()='"
				+ strResource
				+ "']/preceding-sibling::td/input[@name='updateRight']";
		objWaitForElement.waitForElements(strAdministerUser, "xpath");
		assertTrue(this.page.dynamicElement(strResource, strAdministerUser,
				"xpath").isElementPresent());
		if (this.page.dynamicElement(strResource, strAdministerUser, "xpath")
				.getOne().isSelected() == true) {
			this.page.dynamicElement(strResource, strAdministerUser, "xpath")
					.mouseOver();
			this.page.dynamicElement(strResource, strAdministerUser, "xpath")
					.getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to deselect run report right
	 * Date        : 02/Jul/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList deselectRunReportRight(String strResourceName)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@id='tbl_association']/tbody/tr/td[text()='"
								+ strResourceName
								+ "']/preceding-sibling::td/input[@name='reportRight']",
						"xpath");
		if (this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[text()='"
								+ strResourceName
								+ "']/preceding-sibling::td/input[@name='reportRight']",
						"xpath").getOne().isSelected() == true) {

			this.page
					.element(
							"//table[@id='tbl_association']/tbody/tr/td[text()='"
									+ strResourceName
									+ "']/preceding-sibling::td/input[@name='reportRight']",
							"xpath").mouseOver();
			this.page
					.element(
							"//table[@id='tbl_association']/tbody/tr/td[text()='"
									+ strResourceName
									+ "']/preceding-sibling::td/input[@name='reportRight']",
							"xpath").getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to Verify update right is selected
	 * Date        : 02/Jul/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verUpdateStatusOfResourceIsSelected(String strResource)
			throws Exception {
		String strAdministerUser = "//table[@id='tbl_association']/tbody/tr/td[text()='"
				+ strResource
				+ "']/preceding-sibling::td/input[@name='updateRight']";
		assertTrue(
				this.page
						.dynamicElement(strResource, strAdministerUser, "xpath")
						.getOne().isSelected() == true,
				"Update status resource not selected");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to veridy associated with right is selected
	 * Date        : 02/Jul/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verAssociateWithOfResourceIsSelected(String strResource)
			throws Exception {
		String strAssociateWithRight = "//table[@id='tbl_association']/tbody/tr/td[text()='"
				+ strResource
				+ "']/preceding-sibling::td/input[@name='association']";
		objWaitForElement.waitForElements(strAssociateWithRight, "xpath");
		assertTrue(
				this.page
						.dynamicElement(strResource, strAssociateWithRight,
								"xpath").getOne().isSelected() == true,
				"Associate right not selected");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to veridy associated with right is selected
	 * Date        : 02/Jul/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verAssociateWithOfResourceIsNotSelected(String strResource)
			throws Exception {
		String strAssociateWithRight = "//table[@id='tbl_association']/tbody/tr/td[text()='"
				+ strResource
				+ "']/preceding-sibling::td/input[@name='association']";
		objWaitForElement.waitForElements(strAssociateWithRight, "xpath");
		assertFalse(
				this.page
						.dynamicElement(strResource, strAssociateWithRight,
								"xpath").getOne().isSelected() == true,
				"Associate right Is selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select view resource right
	 * Date        : 20/11/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verRunReportRightSelected(String strResourceName) throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@id='tbl_association']/tbody/tr/td[text()='"
								+ strResourceName
								+ "']/preceding-sibling::td/input[@name='reportRight']",
						"xpath");
		assertTrue(
				this.page
						.element(
								"//table[@id='tbl_association']/tbody/tr/td[text()='"
										+ strResourceName
										+ "']/preceding-sibling::td/input[@name='reportRight']",
								"xpath").getOne().isSelected() == true,
				"Associate right not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select associated with rights
	 * Date        : 31/07/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verifyResourceRightsSelected(String strResourceValue)
			throws Exception {
		objWaitForElement.waitForElements("input[value='" + strResourceValue
				+ "'][name='association']", "css");
		
		assertTrue(this.page.element("input[value='" + strResourceValue
				+ "'][name='association']", "css").getOne().isSelected());
		assertTrue(this.page.element("input[value='" + strResourceValue
				+ "'][name='updateRight']", "css").getOne().isSelected());
		assertTrue(this.page.element("input[value='" + strResourceValue
				+ "'][name='reportRight']", "css").getOne().isSelected());
		assertTrue(this.page.element("input[value='" + strResourceValue
				+ "'][name='viewRight']", "css").getOne().isSelected());
		
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to deselect the role
	   * Date        : 14/07/2015
	   * Author      : Renushree
	   **********************************************************************************/
	public UsersList deselectRoleCheckBox(String strRoleValues)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strRoleValues
				+ "'][@name='userRoleID']", "xpath");
		if (this.page
				.dynamicElement(
						"strRoleValues",
						"//input[@value='" + strRoleValues
								+ "'][@name='userRoleID']", "xpath").getOne()
				.isSelected() == true) {
			this.page
					.dynamicElement(
							"strRoleValues",
							"//input[@value='" + strRoleValues
									+ "'][@name='userRoleID']", "xpath")
					.getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is used to click on 'Refine' link in View resource and to fetch res name.
	 * Date        : 20/07/2015
	 * Author      : Renushre
	 **********************************************************************************/
	public String clickRefineLinkOfViewResourceAndFetchResName()
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr[1]/td[5]",
		"xpath");
		String strResName = this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr[1]/td[5]",
						"xpath").getOne().getText();
		this.page
		.element(
				"//table[@id='tbl_association']/tbody/tr/td[5][text()='"
						+ strResName
						+ "']/parent::tr/td[4]/a[text()='Refine']",
				"xpath").getOne().click();
		return strResName;
	}
	
	/********************************************************************************************
	 * Description : This function is to verify status types dispalyed in refine window 
	 * Date        : 20/07/2015
	 * Author      : Renushree
	 *******************************************************************************************/
	public UsersList verSTDisplayedInRefineWin(String[] strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements(
				"//input[@name='statusTypeID'][@value='"
						+ strStatusTypeValue[0] + "']", "xpath");
		for (int count = 0; count < strStatusTypeValue.length; count++) {
			assertTrue(
					this.page
							.dynamicElement(
									strStatusTypeValue + " status type value",
									"//input[@name='statusTypeID'][@value='"
											+ strStatusTypeValue[count] + "']",
									"xpath").isElementPresent(),
					"Status types not present");
		}
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to verify status types is not dispalyed in refine window 
	 * Date        : 20/07/2015
	 * Author      : Renushree
	 *******************************************************************************************/
	public UsersList verSTNotDisplayedInRefineWin(String[] strStatusTypeValue)
			throws Exception {
		for (int count = 0; count < strStatusTypeValue.length; count++) {
			assertFalse(
					this.page
							.dynamicElement(
									strStatusTypeValue + " status type value",
									"//input[@name='statusTypeID'][@value='"
											+ strStatusTypeValue[count] + "']",
									"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
					"Status types is present");
		}
		return this;
	}
	
	/*****************************************************************************************************
	 * Description : This function is to verify 'Save changes' button in Refine Visible Status Types page
	 * Date        : 20/07/2015
	 * Author      : Renushree
	 *****************************************************************************************************/
	public UsersList verSaveChangesButtonInRefine() throws Exception {
		objWaitForElement.waitForElements(saveChangesBtnInRefine, "xpath");
		assertTrue(this.page.element(saveChangesBtnInRefine, "xpath").isElementPresent(), "Save changes not dispalyed");
		return this;
	}
	
	/*****************************************************************************************************
	 * Description : This function is to verify 'Close' in Refine Visible Status Types page
	 * Date        : 20/07/2015
	 * Author      : Renushree
	 *****************************************************************************************************/
	public UsersList verCloseInRefine() throws Exception {
		objWaitForElement.waitForElements(closeInRefineWin, "css");
		assertTrue(this.page.element(closeInRefineWin, "css").isElementPresent(), "Close not dispalyed in refine window");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to switch to default frame
	 * Date        : 20/07/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList switchToDefaultFrame() throws Exception {
		driver.switchTo().defaultContent();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify error in refine window.
	 * Date        : 20/07/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verErrorInRefineWindow() throws Exception {
		objWaitForElement.waitForElements(errorInRefineWindow, "xpath");
		String str = this.page.element("//div/p", "xpath").getOne().getText();
		assertEquals(
				"You must save any changes made to this user's roles before refining status type visibility.",
				str);
		return this;
	}

	/*****************************************************************************************************
	 * Description : This function is to click on 'Close' in Refine Visible Status Types page
	 * Date        : 20/07/2015
	 * Author      : Renushree
	 *****************************************************************************************************/
	public UsersList clickOnCloseInRefine() throws Exception {
		objWaitForElement.waitForElements(closeInRefineWin, "css");
		this.page.element(closeInRefineWin, "css").getOne().click();
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to verify status types is selected in refine window 
	 * Date        : 20/07/2015
	 * Author      : Renushree
	 *******************************************************************************************/
	public UsersList verSTSelectedInRefineWin(String[] strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements(
				"//input[@name='statusTypeID'][@value='"
						+ strStatusTypeValue[0] + "']", "xpath");
		for (int count = 0; count < strStatusTypeValue.length; count++) {
			assertTrue(
					this.page
							.dynamicElement(
									strStatusTypeValue + " status type value",
									"//input[@name='statusTypeID'][@value='"
											+ strStatusTypeValue[count] + "']",
									"xpath").getOne().isSelected(),
					"Status types is not selected");
		}
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to verify status types is not selected in refine window 
	 * Date        : 20/07/2015
	 * Author      : Renushree
	 *******************************************************************************************/
	public UsersList verSTDeselectedInRefineWin(String[] strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements(
				"//input[@name='statusTypeID'][@value='"
						+ strStatusTypeValue[0] + "']", "xpath");
		for (int count = 0; count < strStatusTypeValue.length; count++) {
			assertFalse(
					this.page
							.dynamicElement(
									strStatusTypeValue + " status type value",
									"//input[@name='statusTypeID'][@value='"
											+ strStatusTypeValue[count] + "']",
									"xpath").getOne().isSelected(),
					"Status types is selected");
		}
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to 'select' the Refine Visible Status Types page checkBox
	 * Date        : 20/07/2015
	 * Author      : Renushree
	 *******************************************************************************************/
	public UsersList selectStatusTypesInRefine(String[] strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements(
				"//input[@name='statusTypeID'][@value='"
						+ strStatusTypeValue[0] + "']", "xpath");
		for (int count = 0; count < strStatusTypeValue.length; count++) {
			if (this.page
					.dynamicElement(
							strStatusTypeValue + " status type value",
							"//input[@name='statusTypeID'][@value='"
									+ strStatusTypeValue[count] + "']", "xpath")
					.getOne().isSelected()==false) {
				this.page
						.dynamicElement(
								strStatusTypeValue + " status type value",
								"//input[@name='statusTypeID'][@value='"
										+ strStatusTypeValue[count] + "']",
								"xpath").mouseOver();
				this.page
						.dynamicElement(
								strStatusTypeValue + " status type value",
								"//input[@name='statusTypeID'][@value='"
										+ strStatusTypeValue[count] + "']",
								"xpath").getOne().sendKeys(Keys.SPACE);
			}
		}
		return this;

	}
	/**********************************************************************************
	 * Description : This function is to select admin user chk box
	 * Date        : 23/07/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public UsersList selSystemAdminUserChkBox() throws Exception {
		objWaitForElement.waitForElements(systemAdmin, "xpath");
		this.page.element(systemAdmin, "xpath").getOne().click();
		return this;
	}	
	/********************************************************************************************
	 * Description : This function is to select Form - User may activate and Modify forms  option
	 * Date        :23/07/2015
	 * Author      : Sangappa.k
	 ********************************************************************************************/
	public UsersList selectCreateIncomingPatientNotificationsOption() throws Exception {
		objWaitForElement.waitForElements(creatincomingPatientNotifications, "css");
		this.page.element(creatincomingPatientNotifications, "css").getOne().click();
		return this;
	}	
	
	/**********************************************************************************
	 * Description : This function is to click on edit for fisrt user in the list
	 * Date        : 24-Jul-2015
	 * Author      : Deepa
	 **********************************************************************************/
	public UsersList clickEditForFirstUser() throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tblUsers']/tbody/tr[1]/td[1]/a[text()='Edit']",
				"xpath");
		this.page
				.element(
						"//table[@id='tblUsers']/tbody/tr[1]/td[1]/a[text()='Edit']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify role checkbox is selected 
	   * Date        : 31-Jul-2015
	   * Author      : Deepa
	   **********************************************************************************/
	public UsersList verRoleCheckBoxIsSelected(String strRoleID)
			throws Exception {
		assertTrue(this.page
				.element(
						"//input[@value='" + strRoleID
								+ "'][@name='userRoleID']", "xpath").getOne()
				.isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Verify update right is not selected
	 * Date        : 25/Aug/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verUpdateStatusOfResourceIsNotSelected(String strResource)
			throws Exception {
		String strAdministerUser = "//table[@id='tbl_association']/tbody/tr/td[text()='"
				+ strResource
				+ "']/preceding-sibling::td/input[@name='updateRight']";
		assertFalse(
				this.page
						.dynamicElement(strResource, strAdministerUser, "xpath")
						.getOne().isSelected() == true,
				"Update status resource is selected");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select view resource right
	 * Date        : 20/11/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verRunReportRightNotSelected(String strResourceName) throws Exception {
		assertFalse(
				this.page
						.element(
								"//table[@id='tbl_association']/tbody/tr/td[text()='"
										+ strResourceName
										+ "']/preceding-sibling::td/input[@name='reportRight']",
								"xpath").getOne().isSelected() == true,
				"Associate right is selected");
		return this;
	}
	/********************************************************************************************
	 * Description : This function is to verify 'Report - Form Reports' right present.
	 * Date        : 11/May/2015
	 * Author      : sa
	 ********************************************************************************************/
	public UsersList selecrReportFormReportsRight() throws Exception {

		objWaitForElement.waitForElements(administerOtherRegionViews, "css");
		this.page
				.element(
						"//td[text()='Report - Form reports']/input[@value='45']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify view resource right of all resources is selected.
	 * Date        : 26/08/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verAllViewResReightOptionIsSelected() throws Exception {
		objWaitForElement.waitForElements(viewResource, "xpath");
		assertTrue(this.page.element(viewResource, "xpath").getOne()
				.isSelected(),
				"ViewResource right for all resources not selected");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify System Notifications Email CheckBox is not checked
	 * option Date : 28/08/2015 
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verSystemNotificationsEmailCheckBoxIsNotSelected()
			throws Exception {
		objWaitForElement.waitForElements(systemNotificationEmail, "css");
		assertFalse(this.page.element(systemNotificationEmail, "css").getOne()
				.isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify System Notifications Pager CheckBox is not checked
	 * option Date : 28/08/2015 
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verSystemNotificationsPagerCheckBoxIsNotSelected()
			throws Exception {
		objWaitForElement.waitForElements(systemNotificationPager, "css");
		assertFalse(this.page.element(systemNotificationPager, "css").getOne()
				.isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify System Notifications Web CheckBox is not checked
	 * option Date : 28/08/2015 
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verSystemNotificationsWebCheckBoxIsNotSelected()
			throws Exception {
		objWaitForElement.waitForElements(systemNotificationWeb, "css");
		assertFalse(this.page.element(systemNotificationWeb, "css").getOne()
				.isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Save and cancel buttons
	 * option Date : 28/08/2015 
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verSaveAndCancelButtons() throws Exception {
		objWaitForElement.waitForElements(
				"//table/tbody/tr/td[@align='left']/input[@value='Save']",
				"xpath");
		assertTrue(this.page.element(
				"//table/tbody/tr/td[@align='left']/input[@value='Save']",
				"xpath").isElementPresent());
		assertTrue(this.page.element(
				"//table/tbody/tr/td[@align='left']/input[@value='Cancel']",
				"xpath").isElementPresent());
		assertTrue(this.page.element("//form/input[@value='Save']", "xpath")
				.isElementPresent());
		assertTrue(this.page.element("//form/input[@value='Cancel']", "xpath")
				.isElementPresent());
		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Verify  appropriate validation message is displayed 
	 *                when invalid ID is provided while creating/ editing user.
	 * option Date : 30/10/2015 
	 * Author      : Sangappa K
	 **********************************************************************************/
	public UsersList verApprptValidationMsgForInvalidMailPagerIds()
			throws Exception {

		String strInvalidMail = "//div[@class='emsError']/span[text()='The following errors occurred on this page:']/parent::div/ul/li[text()='You must provide a single valid primary e-mail address (e.g. someone@someplace.com)']";
		String strInvalidPrmeryMail = "//div[@class='emsError']/span[text()='The following errors occurred on this page:']/parent::div/ul/li[text()='You have entered an invalid email address in the E-Mail Addresses field (correct format: someone@someplace.com)']";
		String strInvalidPager = "//div[@class='emsError']/span[text()='The following errors occurred on this page:']/parent::div/ul/li[text()='You have entered an invalid text pager address in the Text Pager Addresses field (correct format: number@provider.com)']";

		objWaitForElement.waitForElements(strInvalidMail, "xpath");
		assertTrue(this.page.element(strInvalidMail, "xpath")
				.isElementPresent());
		assertTrue(this.page.element(strInvalidPrmeryMail, "xpath")
				.isElementPresent());
		assertTrue(this.page.element(strInvalidPager, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user & his full name is displayed at the 
	 *                footer of application when user is switched from existing region.
	 * Date        : 2/11/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public UsersList verUserAndFullNameAtFooterOfAppWhenSwitched(String strFullName ,String strUserName,String strAdminUser) throws Exception {
		
		objWaitForElement.waitForElements(footer, "xpath");
		String fullname = this.page.element(footer, "xpath").getOne().getText();
		System.out.println(fullname);
		String strUserNameAtFooter = "" + strFullName + " (" + strAdminUser
				+ " as " + strUserName + ")";
		System.out.println(strUserNameAtFooter);
		assertTrue(fullname.startsWith(strUserNameAtFooter));
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify user & his full name is displayed at the 
	 *                footer of application when user is switched from existing region.
	 * Date        : 2/11/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public UsersList verAdminUser(String strFullName,String strAdmUserName) throws Exception {
		
		objWaitForElement.waitForElements(footer, "xpath");
		String fullname = this.page.element(footer, "xpath").getOne().getText();
		System.out.println(fullname);
		String strUserNameAtFooter = "" + strFullName + " (" + strAdmUserName
				+ ")";
		System.out.println(strUserNameAtFooter);
		assertTrue(fullname.startsWith(strUserNameAtFooter));
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to verify 'Edit' option is not displayed
	 * Date        : 20/11/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verifyEditAndPasswordLinkIsDisplayed(String strUserName) throws Exception {
		assertTrue(this.page.element(
				"//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
						+ strUserName + "']/parent::tr/td[1]/a[text()='Edit']","xpath").getOne().isDisplayed());
		assertTrue(this.page.element(
				"//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
						+ strUserName + "']/parent::tr/td[1]/a[text()='Password']","xpath").getOne().isDisplayed());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on 'Advance Option' node
	 * Date        : 09/06/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public UsersList verAdvancedOptionIsPresent() throws Exception {
		objWaitForElement.waitForElements(advancedOptionButton, "xpath");
		assertTrue(this.page.element(advancedOptionButton, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on username field
	 * Date        : 14/12/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList clickOnUsernameField() throws Exception {
		objWaitForElement.waitForElements(username, "name");
		this.page.element(username, "name").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Deactivated Msg for user
	 *               i.e (This user has been DEACTIVATED. To reactivate, change the setting below.)
	 * Date        : 14/12/2015
	 * Author      : Sangappa K
	 **********************************************************************************/
	public UsersList verDeactivatedToReactivationHeaderMsg() throws Exception {
		objWaitForElement.waitForElements(strDeactivationWarning, "xpath");
		assertTrue(this.page.element(strDeactivationWarning, "xpath")
				.isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select selectAll checkbox 'Users'
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList selectSelectAll() throws Exception {
		objWaitForElement.waitForElements(viewOtherRegions, "xpath");
		this.page.element(viewOtherRegions, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to seelct view other region view of particular region
	 * Date 	   : 30/07/2014
	 * Author      : Anil
 **********************************************************************************/
	public String[] getViewOtherRegView()
			throws Exception {
		int strRegionId1 = 0;
		 strRegionId1 = driver.findElements(By.xpath("//input[@class='checkbox'][@name='otherRegionViewID']")).size();
		 String strRegionValues[] = new String[strRegionId1];
		 String strRegionValues1[] = new String[strRegionId1];
			  String str=  driver.findElement(By.xpath("//td[@class='emsLabel'][text()='View Other Regions:']/following-sibling::td[1]")).getText();

				 strRegionValues = str.split("\n");
				 for(int intCount = 0;intCount<strRegionId1; intCount++ ){
					 strRegionValues1[intCount]= strRegionValues[intCount+1].trim();
					 System.out.println(strRegionValues1[intCount]);
				 }
		return strRegionValues1;
}
	
 /**********************************************************************************
  * Description : This function is to verify RoleName is selected in Edit User Page
  * Date        : 26/09/2014
  * Author      : Prasanna Lakshmi
 **********************************************************************************/
	public UsersList verifyRoleIsSelected(String strRoleValues)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strRoleValues
				+ "'][@name='userRoleID']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"strRoleValues",
						"//input[@value='" + strRoleValues
								+ "'][@name='userRoleID']", "xpath").getOne()
				.isSelected());

		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify RoleName is selected in Edit User Page
	  * Date        : 26/09/2014
	  * Author      : Anitha
	 **********************************************************************************/
		public UsersList verifyRoleIsNotSelected(String strRoleValues)
				throws Exception {
			objWaitForElement.waitForElements("//input[@value='" + strRoleValues
					+ "'][@name='userRoleID']", "xpath");
			assertFalse(this.page
					.dynamicElement(
							"strRoleValues",
							"//input[@value='" + strRoleValues
									+ "'][@name='userRoleID']", "xpath").getOne()
					.isSelected());

			return this;
		}
		
	/**********************************************************************************
	 * Description : This function is to verify 'number of rows' in resources
	 * Date        : 04/08/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public UsersList VerifyNoOfRowsForUsers(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tblUsers']/tbody/tr/td"
				+ "[text()='" + strUserName + "']", "xpath");
		int count = this.page.element("//table[@id='tblUsers']/tbody/tr/td[3]",
				"xpath").getXpathCount();
		assertEquals(1, count);
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify RoleName is displayed in Edit User Page
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public UsersList verifyRoleNameIsNotListed(String strRoleValues)
			throws Exception {
		assertFalse(this.page.dynamicElement("strRoleValues",
				"//input[@value='" + strRoleValues + "'][@name='userRoleID']",
				"xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));

		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Create Ne
	 * w User' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verRoleIsNotPresentInSearchDropDown(String strRoleName)
			throws Exception {
		assertFalse(this.page.element(
				"//select[@id='tblUsers_ROLE']/option[text()='"
						+ strRoleName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select First Role
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList editFirstUserDetails() throws Exception {
		objWaitForElement.waitForElements("//table[@id='tblUsers']/tbody/tr[1]/td[1]/a[text()='Edit']", "xpath");
		this.page.element("//table[@id='tblUsers']/tbody/tr[1]/td[1]/a[text()='Edit']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify error when user with duplicate names provided.
	 * Date        : 16/Feb/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verErrorMsgWhenUserWithDuplicateNameProvided()
			throws Exception {
		assertEquals("This username already exists. Please choose a new one.",
				this.page.element(errorMsg, "xpath").getOne().getText());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify 'Edit' option
	 * Date        : 04/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UsersList verRegionsLink(String strUserName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
				+ strUserName + "']/parent::tr/td[1]/a[text()='Regions']",
		"xpath");
		assertTrue(this.page.element(
				"//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
						+ strUserName + "']/parent::tr/td[1]/a[text()='Regions']",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select HAvBED - Schedule and Activate HAvBED Interface
	 * Date        : 17/Feb/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectHavBedScheduleAndActivateHaavBedInterface()
			throws Exception {
		objWaitForElement.waitForElements(
				strHAvBEDScheduleActivateHAvBEDInterface, "css");
		this.page.element(strHAvBEDScheduleActivateHAvBEDInterface, "css")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Preferences - Do NOT send User Info reminder emails
	 * Date        : 17/Feb/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectPreferencesDontNotSendUserReminderMails()
			throws Exception {
		objWaitForElement.waitForElements(
				strPreferncesDonotSendUserInfoReminderMails, "css");
		this.page.element(strPreferncesDonotSendUserInfoReminderMails, "css")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select User Reset Password Only
	 * Date        : 17/Feb/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList selectUserResetPasswordOnly() throws Exception {
		objWaitForElement.waitForElements(strUserResetPasswordOnly, "css");
		this.page.element(strUserResetPasswordOnly, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Maintain Event option
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verMaintainEventsOptionIsSelected() throws Exception {
		assertTrue(this.page.element(maintainEvents, "css").getOne()
				.isSelected(), "Maintain Event option is not selected");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Maintain AdHoc Event option is selected
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verMaintainAdHocEventsOptionIsSelected() throws Exception {
		assertTrue(this.page.element(maintainAdHocEvents, "css").getOne()
				.isSelected(), "Maintain AdHoc Event option is not selected");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Maintain EventTemplate Option is selected
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verMaintainEventTemplateOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(maintainEventtemplate, "css").getOne()
				.isSelected(), "Maintain EventTemplate Option is not selected");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Form - Do not participate in forms for resources' option is selected
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verFormDoNotParticipateInFormsForResourcesOptionIsSelected()
			throws Exception {
		assertTrue(
				this.page
						.element(formDoNotParticipateInFormsForResourcesOption,
								"css").getOne().isSelected(),
				"'Form - Do not participate in forms for resources' option is not selected");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Form - User may activate forms option is selected
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verFormUserMayActivateFormsOptionIsSelected()
			throws Exception {
		assertTrue(
				this.page.element(formActivate, "css").getOne().isSelected(),
				"Form - User may activate forms  option is not selected");
		return this;
	}

	/********************************************************************************************
	 * Description : This function is to verify Form - User may Configure Form Security is selected
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 ********************************************************************************************/
	public UsersList verFormUserMayConfigureFormSecurityIsSelected()
			throws Exception {
		assertTrue(this.page.element(userMayConfigureFormSecurity, "css")
				.getOne().isSelected(),
				"Form - User may Configure Form Security is not selected");
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to verify Form - User may activate and Modify forms option is selected
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 ********************************************************************************************/
	public UsersList verFormUserMayActivateAndModifyFormsOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(userMayActivateAndModifyForms, "css")
				.getOne().isSelected(),
				"Form - User may activate and Modify forms option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Instant Messaging - Initiate Chat Session option is selected
	 * Date        : 17-Feb-2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verInstantMessagingInitiateChatSessionOptionIsSelected()
			throws Exception {
		assertTrue(this.page
				.element(instantMessagingInitiateChatSession, "css").getOne()
				.isSelected(),
				"Instant Messaging - Initiate Chat Session option is not selected");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Report - Status Summary option is selected
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verIncomingPatientNotificationOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(incomingPatientNotification, "css")
				.getOne().isSelected(),
				"Report - Status Summary option is not selected");
		return this;
	}
	/********************************************************************************************
	 * Description : This function is to verify Form - User may activate and Modify forms  option
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 ********************************************************************************************/
	public UsersList verCreateIncomingPatientNotificationsOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(creatincomingPatientNotifications, "css")
				.getOne().isSelected(),
				"Form - User may activate and Modify forms option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Edit Event Notification Preferences option
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verEditEventNotificationPreferencesOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(editEventNotificationPreferences, "css")
				.getOne().isSelected(),
				"Edit Event Notification Preferences option is not selected");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Report Audit Resource Detail is selected
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verReporAuditResourceDetailIsSelected() throws Exception {
		assertTrue(this.page.element(auditResource, "css").getOne()
				.isSelected(), "Report Audit Resource Detail is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Report - Monthly Status Assessment is selected
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verReporMonthlyStatusAssessmentIsSelected()
			throws Exception {
		assertTrue(this.page.element(monthlyStatusAssesment, "css").getOne()
				.isSelected(),
				"Report - Monthly Status Assessment is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Report - Statewide Resource Detail
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verReportStatewideResourceDetail() throws Exception {
		assertTrue(this.page.element(statewideResource, "css").getOne()
				.isSelected(),
				"Report - Statewide Resource Detail is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Report - Status Detail option is selected
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verReportStatusDetailOptionIsSelected() throws Exception {
		assertTrue(this.page.element(reportStatusDetail, "css").getOne()
				.isSelected(), "Report - Status Detail option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Report - Status reason Detail option is selected
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verReportStatusReasonDetailOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(reportStatusResDetail, "css").getOne()
				.isSelected(),
				"Report - Status reason Detail option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Report - Status reason Summary option is selected
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verReportStatusReasonSummaryOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(reportStatusResSumry, "css").getOne()
				.isSelected(),
				"Report - Status reason Summary option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Report - Status Snapshot option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verReportStatusSnapshotOptionIsSelected() throws Exception {
		assertTrue(this.page.element(reportStatusSnapshot, "css").getOne()
				.isSelected(),
				"Report - Status Snapshot option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Report - Status Summary option is selected
	 * Date        : 17/02/2016
	 * Author      : sandhya
	 **********************************************************************************/
	public UsersList verReportStatusSummaryOptionIsSelected() throws Exception {
		assertTrue(this.page.element(reportStatusSummary, "css").getOne()
				.isSelected(), "Report - Status Summary option is not selected");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Report - Event Detail option is selected
	 * Date        : 17/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verReportEventDetailOptionIsSelected() throws Exception {
		assertTrue(this.page.element(reportEventDetail, "css").getOne()
				.isSelected(), "Report - Event Detail option is not selected");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Report - Event Snapshot option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verReportEventSnapshotOptionIsSelected() throws Exception {
		assertTrue(this.page.element(reportEventSnapshot, "css").getOne()
				.isSelected(), "Report - Event Snapshot option is not selected");
		return this;
	}

	/********************************************************************************************
	 * Description : This function is to verify Report - Form Detail is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 ********************************************************************************************/
	public UsersList verReportformDetailIsSelected() throws Exception {
		assertTrue(this.page.element(reportFormDetail, "css").getOne()
				.isSelected(), "Report - Form Detail is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify setup resource Option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verSetupResourceOptionIsSelected() throws Exception {
		assertTrue(this.page.element(setupResource, "css").getOne()
				.isSelected(), "setup resource Option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify setup resource types Option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verSetupResourceTypesOptionIsSelected() throws Exception {
		assertTrue(this.page.element(setupResourceTypes, "css").getOne()
				.isSelected(), "setup resource types Option is not selected");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Report - Event Detail option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verSetUpRolesRightIsSelected() throws Exception {
		assertTrue(this.page.element(setUpRoles, "css").getOne().isSelected(),
				"Report - Event Detail option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Setup Status Reason Option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verSetupStatusReasonOptionIsSelected() throws Exception {
		assertTrue(this.page.element(setupStatusReason, "css").getOne()
				.isSelected(), "Setup Status Reason Option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Setup Status Types Option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verSetupStatusTypesOptionIsSelected() throws Exception {
		assertTrue(this.page.element(setupStatusTypes, "css").getOne()
				.isSelected(), "Setup Status Types Option is not selected");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Configure Region Views Option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verConfigureRegionViewsOptionIsSelected() throws Exception {
		assertTrue(this.page.element(configureRegViews, "css").getOne()
				.isSelected(), "Configure Region Views Option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Configure Multi Region Views Option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verConfigureMultiRegionViewsOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(configureMultiRegViews, "css").getOne()
				.isSelected(),
				"Configure Multi Region Views Option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify ConfigureRegional User Access Option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/

	public UsersList verConfigureRegionalUserAccessOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(configureRegionalUserAccess, "css")
				.getOne().isSelected(),
				"ConfigureRegional User Access Option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify 'Edit Resources Only' option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verEditResourcesOnlyOptionIsSelected() throws Exception {
		assertTrue(this.page.element(editResourcesOnly, "css").getOne()
				.isSelected(), "'Edit Resources Only' option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify view custom view Option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verViewcustomViewOptionIsSelected() throws Exception {
		assertTrue(this.page.element(viewcustomView, "css").getOne()
				.isSelected(), "view custom view Option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Override Viewing Restriction option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/

	public UsersList verOverrideViewingRestrictionOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(overrideViewingRestriction, "css")
				.getOne().isSelected(),
				"Override Viewing Restriction option is not selected");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Must update overdue status Option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verMustUpdateOverdueStatusOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(mustUpdateOverDueStatus, "css").getOne()
				.isSelected(),
				"Must update overdue status Option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify HAvBED - Schedule and Activate HAvBED Interface option is selected
	 * Date        : 17/Feb/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verHavBedScheduleAndActivateHaavBedInterfaceIsSelected()
			throws Exception {
		assertTrue(
				this.page
						.element(strHAvBEDScheduleActivateHAvBEDInterface,
								"css").getOne().isSelected(),
				"HAvBED - Schedule and Activate HAvBED Interface option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Edit Regional Message Bulletin Board Option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verEditRegionalMessageBulletinBoardIsSelected()
			throws Exception {
		assertTrue(this.page.element(editRegionalMessageBulletinBoard, "css")
				.getOne().isSelected(),
				"Edit Regional Message Bulletin Board Option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Maintain Document Library Option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verMaintainDocumentLibraryOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(maintainDocumentLibrary, "css").getOne()
				.isSelected(),
				"Maintain Document Library Option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify user - view user information only option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verUserViewUserInformationOnlyOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(viewUserInformationOnly, "css").getOne()
				.isSelected(),
				"user - view user information only option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Preferences - Do NOT send User Info reminder emails option is selected
	 * Date        : 17/Feb/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verPreferencesDontNotSendUserReminderMailsIsSelected()
			throws Exception {
		assertTrue(
				this.page
						.element(strPreferncesDonotSendUserInfoReminderMails,
								"css").getOne().isSelected(),
				"Preferences - Do NOT send User Info reminder emails option is not selected");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Edit status change notification preference option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verEditStatusChangeNotPrefernceOptionIsSelected()
			throws Exception {
		assertTrue(
				this.page
						.element(editStatuschangeNotificationPreference, "css")
						.getOne().isSelected(),
				"Edit status change notification preference option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify 'May Update Region Setup Information' Option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verMayUpdateRegionSetupInformationOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(mayUpdateRegionSetupInformation, "css")
				.getOne().isSelected(),
				"May Update Region Setup Information Option is not selected");
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to verify administer Other Region Views option is selected
	 * Date        : 17/02/2016
	 * Author      : Sandhya
	 ********************************************************************************************/
	public UsersList veradministerOtherRegionViewsOptionIsSelected()
			throws Exception {
		assertTrue(this.page.element(administerOtherRegionViews, "css")
				.getOne().isSelected(),
				"administer Other Region Views option is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify User Reset Password Only option is selected
	 * Date        : 17/Feb/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verUserResetPasswordOnlyIsSelected() throws Exception {
		assertTrue(this.page.element(strUserResetPasswordOnly, "css").getOne()
				.isSelected(),
				"User Reset Password Only option is not selected");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Create New User' button is not present.
	 * Date        : 18/02/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public UsersList verCreateNewUserButtonIsNotPresent() throws Exception {
		assertFalse(this.page.element(createNewUserButton, "css")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"'Create New User' button is present");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify '*' asterisk symbol corresponding to a right
	 * 				 is displayed
	 * Date        : 22-Feb2016
	 * Author      : Pallavi
	 **********************************************************************************/
	public UsersList verifyAsteriskIsDisplayedCorrespondingToRight(
			String strRightValue) throws Exception {
		String strElement = "//input[@value='"
				+ strRightValue
				+ "']/following-sibling::span[1][@class='roleRight'][text()='*']";
		objWaitForElement.waitForElements(strElement, "xpath");
		assertTrue(this.page.element(strElement, "xpath").isElementPresent());
		assertTrue(this.page.element(strElement, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify '*' asterisk symbol corresponding to a right
	 * 				 is not displayed
	 * Date        : 22-Feb2016
	 * Author      : Pallavi
	 **********************************************************************************/
	public UsersList verifyAsteriskIsNotDisplayedCorrespondingToRight(
			String strRightValue) throws Exception {
		String strElement = "//input[@value='"
				+ strRightValue
				+ "']/following-sibling::span[1][@class='roleRight'][text()='*']";
		assertFalse(this.page.element(strElement, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select Maintain Event option
	 * Date        : 09/06/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public UsersList deselectSetupResourceTypesOption() throws Exception {
		objWaitForElement.waitForElements(setupResourceTypes, "css");
		if (this.page.element(setupResourceTypes, "css").getOne().isSelected() == true) {
			this.page.element(setupResourceTypes, "css").getOne().click();
		}
		return this;
	}
	
	/********************************************************************************************
	 * Description : This function is to select Form - User may activate and Modify forms  option
	 * Date        : 15/12/2014
	 * Author      : Renushree
	 ********************************************************************************************/
	public UsersList verFormUserMayActivateAndModifyFormsOptionIsNotAvailable()
			throws Exception {
		assertFalse(this.page.element(userMayActivateAndModifyForms, "css")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Form - User may activate and Modify forms is present");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Report - Incoming patient notification option is selected
	 * Date        : 07/10/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verReportIncomingPatientNotificationOptionIsSelected() throws Exception {
		assertTrue(this.page.element(reportIncomingPatientNotification, "css").getOne()
		.isSelected(), "Report - Form Detail is not selected");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify HAvBED - Schedule and Activate HAvBED Interface option is not displayed
	 * Date        : 17/Feb/2016
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verHavBedScheduleAndActivateHaavBedInterfaceIsNotDisplayed()
			throws Exception {
		assertFalse(
				this.page
						.element(strHAvBEDScheduleActivateHAvBEDInterface,
								"css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify HAvBED - Schedule and Activate HAvBED Interface option is not displayed
	 * Date        : 17/Feb/2016
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verifyRightsIsDisplayed()
			throws Exception {
		assertFalse(
				this.page
						.element(strHAvBEDScheduleActivateHAvBEDInterface,
								"css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify HAvBED - Schedule and Activate HAvBED Interface option is not displayed
	 * Date        : 17/Feb/2016
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verifyRightsNameIsNotDisplayed(String strRightName)
			throws Exception {
		String strGetValue = this.page.element(strRightsName, "xpath").getOne()
				.getText();
		String strRights[] = strGetValue.split("\n");
		for (int intCount = 0; intCount < strRights.length; intCount++) {
			assertFalse(strRights[intCount].contains(strRightName));
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify rights is displayed
	 * Date        : 17/Feb/2016
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList verifyRightsNameIsDisplayed(String strRightName)
			throws Exception {
		boolean boolCheck = false;
		String strGetValue = this.page.element(strRightsName, "xpath").getOne()
				.getText();
		String strRights[] = strGetValue.split("\n");
		for (int intCount = 0; intCount < strRights.length; intCount++) {
			if (strRights[intCount].contains(strRightName)) {
				System.out.println(strRights[intCount]);
				boolCheck = true;
				break;
			}
		}
		assertTrue(boolCheck, strRightName + " is not displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'include inactive users' checkbox is present.
	 * Date        : 25/02/2016
	 * Author      : sandhya
	 **********************************************************************************/
	public UsersList verIncludeInactiveUsersChkBxIsPresent() throws Exception {
		objWaitForElement.waitForElements(includeInactiveUsers, "css");
		assertTrue(this.page.element(includeInactiveUsers, "css")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'include inactive users' checkbox is enabled.
	 * Date        : 26/02/2016
	 * Author      : sandhya
	 **********************************************************************************/
	public UsersList verIncludeInactiveUsersChkBxIsEnabled() throws Exception {
		objWaitForElement.waitForElements(includeInactiveUsers, "css");
		assertTrue(this.page.element(includeInactiveUsers, "css").getOne()
				.isEnabled(),
				"Include inactive users check box is not selected");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify User Profile text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verUserProfileTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(userProfileText, "xpath");
		assertTrue(this.page.element(userProfileText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Username text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verUsernameTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(usernameText, "xpath");
		assertTrue(this.page.element(usernameText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Initial Password text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verInitialPasswordTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(initialPasswordText, "xpath");
		assertTrue(this.page.element(initialPasswordText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Confirm Password text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verConfirmPasswordTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(confirmPasswordText, "xpath");
		assertTrue(this.page.element(confirmPasswordText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Full Name text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verFullNameTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(fullNameText, "xpath");
		assertTrue(this.page.element(fullNameText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify First Name text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verFirstNameTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(firstNameText, "xpath");
		assertTrue(this.page.element(firstNameText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Middle Name text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verMiddleNameTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(middleNameText, "xpath");
		assertTrue(this.page.element(middleNameText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Last Name text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verLastNameTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(lastNameText, "xpath");
		assertTrue(this.page.element(lastNameText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Organization text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verOrganizationTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(organizationText, "xpath");
		assertTrue(this.page.element(organizationText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Contact Phone text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verContactPhoneTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(contactPhoneText, "xpath");
		assertTrue(this.page.element(contactPhoneText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Primary E-Mail text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verPrimaryEMailTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(primaryEMailText, "xpath");
		assertTrue(this.page.element(primaryEMailText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify EMail Addresses text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verEMailAddressesTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(eMailAddressesText, "xpath");
		assertTrue(this.page.element(eMailAddressesText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify TextPager Addresses text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verTextPagerAddressesTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(textPagerAddressesText, "xpath");
		assertTrue(this.page.element(textPagerAddressesText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Administrative Comments text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verAdministrativeCommentsTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(administrativeCommentsText, "xpath");
		assertTrue(this.page.element(administrativeCommentsText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify User Type & Roles text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verUserTypeRolesTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(userTypeRolesText, "xpath");
		assertTrue(this.page.element(userTypeRolesText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Web Services User text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verWebServicesUserTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(webServicesUserText, "xpath");
		assertTrue(this.page.element(webServicesUserText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Roles text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verRolesTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(rolesText, "xpath");
		assertTrue(this.page.element(rolesText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Views text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verViewsTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(viewsText, "xpath");
		assertTrue(this.page.element(viewsText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Default View text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verDefaultViewTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(defaultViewText, "xpath");
		assertTrue(this.page.element(defaultViewText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Views in This Region text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verViewsInThisRegionTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(viewsInThisRegionText, "xpath");
		assertTrue(this.page.element(viewsInThisRegionText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
		
	/**********************************************************************************
	 * Description : This function is to verify Resource Rights text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verResourceRightsTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(resourceRightsText, "xpath");
		assertTrue(this.page.element(resourceRightsText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Any Resource Type drop down is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verAnyResourceTypeDropDownIsPresent() throws Exception {
		objWaitForElement.waitForElements(anyResourceTypeDropDown, "css");
		assertTrue(this.page.element(anyResourceTypeDropDown, "css")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify ResourceName drop down is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verResourceNameDropDownIsPresent() throws Exception {
		objWaitForElement.waitForElements(resourceNameDropDown, "css");
		assertTrue(this.page.element(resourceNameDropDown, "css")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Advanced Options text is present
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verAdvancedOptionsTextIsPresent() throws Exception {
		objWaitForElement.waitForElements(advancedOptionsText, "xpath");
		assertTrue(this.page.element(advancedOptionsText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used verify contains drop down is displayed. 
	* Arguments		: strDropDownValues
	* Date 			: 26/02/2016
	* Author 		: Sandhya
	**********************************************************************************/
	public UsersList verContainsDropDown(String[] strDropDownValues)
			throws Exception {
		ArrayList<String> l1 = new ArrayList<String>(
				Arrays.asList(strDropDownValues));
		ArrayList<String> l3 = new ArrayList<String>();
		List<WebElement> l2 = this.page.element(containsDropDown, "css")
				.webElementToSelect().getOptions();
		for (WebElement webElement : l2) {
			String strSropDownVal = webElement.getText();
			l3.add(strSropDownVal);
		}
		l3.equals(l1);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to get number of user count 
	 * Date        : 26/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public int getUserCount() throws Exception {
		objWaitForElement.waitForElements(totalNumberOfUsers, "xpath");
		String userCount = this.page.element(totalNumberOfUsers, "xpath")
				.getOne().getText();
		System.out.println(userCount);
		String[] stringArray = userCount.split(" ");
		int userCount1 = Integer.parseInt(stringArray[0]);
		return userCount1;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify that the number of user count is incremented by one 
	 * Date        : 29/02/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verUserCountIsIncremented(int incrementedBy,
			int initialCount) throws Exception {
		objWaitForElement.waitForElements(totalNumberOfUsers, "xpath");
		String userCount = this.page.element(totalNumberOfUsers, "xpath")
				.getOne().getText();
//		System.out.println(userCount);
		String[] stringArray = userCount.split(" ");
		int userCount1 = Integer.parseInt(stringArray[0]);
		int incrementedUserCount = initialCount + incrementedBy;
		assertEquals(userCount1, incrementedUserCount);		
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'include inactive users' checkbox is not selected.
	  * Date        : 26/02/2016
	  * Author      : sandhya
	 **********************************************************************************/
	public UsersList verIncludeInactiveUsersChkBxIsNotSelected()
			throws Exception {
		objWaitForElement.waitForElements(includeInactiveUsers, "css");
		assertFalse(this.page.element(includeInactiveUsers, "css").getOne()
				.isSelected(),
				"include inactive users checkbox is not selected");
		return this;
	}
		
	/**********************************************************************************
		 * Description : This function is to verify Search Option is present
		 * Date        : 26/02/2016
		 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verSearchOptionIsPresent() throws Exception {
		objWaitForElement.waitForElements(searchOptionTextField, "css");
		assertTrue(this.page.element(searchOptionTextField, "css")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
		 * Description : This function is to verify Actions column is present in UserList page
		 * Date        : 29/02/2016
		 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verActionsColIsPresent() throws Exception {
		objWaitForElement.waitForElements(actionColumn, "xpath");
		assertTrue(this.page.element(actionColumn, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
		
	/**********************************************************************************
		 * Description : This function is to verify Username column is present in UserList page
		 * Date        : 29/02/2016
		 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verUsernameColIsPresent() throws Exception {
		objWaitForElement.waitForElements(usernameColumn, "xpath");
		assertTrue(this.page.element(usernameColumn, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
		
	/**********************************************************************************
		 * Description : This function is to verify Fullname column is present in UserList page
		 * Date        : 29/02/2016
		 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verFullnameColIsPresent() throws Exception {
		objWaitForElement.waitForElements(fullnameColumn, "xpath");
		assertTrue(this.page.element(fullnameColumn, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
		
	/**********************************************************************************
		 * Description : This function is to verify Organization column is present in UserList page
		 * Date        : 29/02/2016
		 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verOrganizationColIsPresent() throws Exception {
		objWaitForElement.waitForElements(organizationColumn, "xpath");
		assertTrue(this.page.element(organizationColumn, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
		
	/**********************************************************************************
		 * Description : This function is to verify Last Login column is present in UserList page
		 * Date        : 29/02/2016
		 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verLastLoginColIsPresent() throws Exception {
		objWaitForElement.waitForElements(lastLoginColumn, "xpath");
		assertTrue(this.page.element(lastLoginColumn, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
		 * Description : This function is to verify Roles Column is not present in UserList page
		 * Date        : 29/02/2016
		 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verRolesColIsNotPresent() throws Exception {
		assertFalse(this.page.element(RolesColumn, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;

	}
		
	/**********************************************************************************
		 * Description : This function is to verify phone Column is not present in UserList page
		 * Date        : 29/02/2016
		 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verPhoneColIsNotPresent() throws Exception {
		assertFalse(this.page.element(phoneColumn, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;

	}
		
	/**********************************************************************************
		 * Description : This function is to verify E-mail Column is not present in UserList page
		 * Date        : 29/02/2016
		 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verEmailColIsNotPresent() throws Exception {
		assertFalse(this.page.element(emailColumn, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;

	}
		
	/**********************************************************************************
		 * Description : This function is to verify 'Switch' link is present in userlist screen
		 * Date        : 29/02/2016
		 * Author      : Sandhya
	**********************************************************************************/
	public UsersList verSwitchLink(String strUserName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
						+ strUserName
						+ "']/parent::tr/td[1]/a[text()='Switch']", "xpath");
		assertTrue(this.page.element(
				"//table[@id='tblUsers']/tbody/tr/td[2]" + "[text()='"
						+ strUserName
						+ "']/parent::tr/td[1]/a[text()='Switch']", "xpath")
				.isElementPresent());
		return this;
	}
		
   /**********************************************************************************
 * Description : This function is to verify never is displayed under last login column in userlist page
 * Date 	   : 29/02/2016
 * Author      : Sandhya
 **********************************************************************************/
	public UsersList verNeverTextIsDisplayed(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tblUsers']/tbody/tr/td[text()='" + strUserName
						+ "']/following-sibling::td[3][text()='(never)']",
				"xpath");
		assertTrue(this.page.element(
				"//table[@id='tblUsers']/tbody/tr/td[text()='" + strUserName
						+ "']/following-sibling::td[3][text()='(never)']",
				"xpath").isElementPresent());
		return this;
	}
	
	
	/**********************************************************************************
	   * Description : This function is to Select the role
	   * Date        : 08/06/2015
	   * Author      : Anil
	   **********************************************************************************/
	public UsersList selectUserCanAssignRoleCheckBox(String strRoleValues) throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strRoleValues
				+ "'][@name='adminRoleID']", "xpath");
		if (this.page
				.dynamicElement(
						"strRoleValues",
						"//input[@value='" + strRoleValues
								+ "'][@name='adminRoleID']", "xpath").getOne()
				.isSelected() == false) {
			this.page
					.dynamicElement(
							"strRoleValues",
							"//input[@value='" + strRoleValues
									+ "'][@name='adminRoleID']", "xpath")
					.getOne().click();
		}
		return this;
	}
	
	 /**********************************************************************************
	  * Description : This function is to verify User Can Assign RoleName is selected in Edit User Page
	  * Date        : 26/09/2014
	  * Author      : Anil
	 **********************************************************************************/
		public UsersList verifyUserCanAssignRoleIsSelected(String strRoleValues)
				throws Exception {
			objWaitForElement.waitForElements("//input[@value='" + strRoleValues
					+ "'][@name='adminRoleID']", "xpath");
			assertTrue(this.page
					.dynamicElement(
							"strRoleValues",
							"//input[@value='" + strRoleValues
									+ "'][@name='adminRoleID']", "xpath").getOne()
					.isSelected());

			return this;
		}
		
		/**********************************************************************************
		 * Description : This function is to verify error heading
		 * Date        : 02/Jul/2015
		 * Author      : Anil
		 **********************************************************************************/
		public UsersList verErrorMsgWhenUserCanAssignRoleIsSelected() throws Exception {
			String str = this.page.element(errorMsg, "xpath").getOne().getText();
			System.out.println(str);
			assertEquals(
					"A 'Resource Admin' user must be assigned to administer one or more resources.",str);
			return this;
		}
		
		/**********************************************************************************
		 * Description : This function is to verify user details.
		 * Date 	   : 30/07/2014
		 * Author      : Anil
		 **********************************************************************************/
		public UsersList verUserDetailsInUserList(String strUserName, String strFullName,
				String strOrganization) throws Exception {
			objWaitForElement.waitForElements("//table[@id='tblUsers']/tbody/tr/td[2][text()='"+strUserName+"']", "xpath");
			assertTrue( this.page.element("//table[@id='tblUsers']/tbody/tr/td[2][text()='"+strUserName+"']/following-sibling::td[1][text()='"+strFullName+"']", "xpath").getOne().isDisplayed());
			assertTrue( this.page.element("//table[@id='tblUsers']/tbody/tr/td[2][text()='"+strUserName+"']/following-sibling::td[2][text()='"+strOrganization+"']", "xpath").getOne().isDisplayed());
			return this;
		}
		
		/********************************************************************************************
		 * Description : This function is to deselect Form - User may activate and Modify forms  option
		 * Date        : 25/02/2016
		 * Author      : Renushree
		 ********************************************************************************************/
		public UsersList deselectFormUserMayActivateAndModifyFormsOption()
				throws Exception {
			objWaitForElement.waitForElements(userMayActivateAndModifyForms, "css");
			if (this.page.element(userMayActivateAndModifyForms, "css").getOne()
					.isSelected() == true) {
				this.page.element(userMayActivateAndModifyForms, "css").getOne()
						.click();
			}
			return this;
		}
		
		/********************************************************************************************
		 * Description : This function is to verify Form - User may activate and Modify forms  option is present
		 * Date        : 26/02/2016
		 * Author      : Renushree
		 ********************************************************************************************/
		public UsersList verFormUserMayActivateAndModifyFormsOptionIsAvailable()
				throws Exception {
			assertTrue(this.page.element(userMayActivateAndModifyForms, "css")
					.isElementPresent(),
					"Form - User may activate and Modify forms is not present");
			return this;
		}
		
		/**********************************************************************************
		  * Description : This function is to verify RoleName is displayed in Edit User Page
		  * Date        : 26/09/2014
		  * Author      : Prasanna Lakshmi
		  **********************************************************************************/
		public UsersList verifyRoleNameIsListed(String strRoleValues)
				throws Exception {
			assertTrue(this.page.dynamicElement("strRoleValues",
					"//input[@value='" + strRoleValues + "'][@name='userRoleID']",
					"xpath").getOne().isDisplayed());
			return this;
		}
		
		/**********************************************************************************
		 * Description : This function is to verify 'Advance Option' is not displayed
		 * Date        : 09/06/2014
		 * Author      : Anil
		 **********************************************************************************/
		public UsersList verAdvancedOptionIsNotPresent() throws Exception {
			assertFalse(this.page.element(advancedOptionButton, "xpath")
					.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
			return this;
		}
		
		/**********************************************************************************
		 * Description : This function is to verify Advanced Options text is not present
		 * Date        : 26/02/2016
		 * Author      : Anil
		 **********************************************************************************/
		public UsersList verAdvancedOptionsTextIsNotPresent() throws Exception {
			assertFalse(this.page.element(advancedOptionsText, "xpath")
					.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
			return this;
		}
		
	/**********************************************************************************
	 * Description : This function is to verify HAvBED - Schedule and Activate HAvBED Interface option is available
	 * Date        : 22/Mar/2016
	 * Author      : Sandhya
	 **********************************************************************************/
	public UsersList verHavBedScheduleAndActivateHaavBedInterfaceIsAvailable()
			throws Exception {
		assertTrue(
				this.page.element(strHAvBEDScheduleActivateHAvBEDInterface,
						"css").isElementPresent(),
				"HAvBED - Schedule and Activate HAvBED Interface is not present");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to search the Username in Users list page
	 * Date        : 17/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/ 
	public UsersList searchUserNameAndVerifyItIsNotDisplayed(String strUsername,
			String strRole, String strResourceType,String strUserDetails, String strsearchOption)
					throws Exception {
		selectRoleOptionInUsersList(strRole);
		selectResourceTypeOptionInUsersList(strResourceType);
		selectUserDetailsOptionInUsersList(strUserDetails);
		enterUsernameInSearchInputField(strUsername);
		Thread.sleep(1000);
		clickSearchButton();
		Thread.sleep(1000);
		this.verUserNotInList(strUsername);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select First Role
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public UsersList deSelectFirstRole() throws Exception {
		objWaitForElement.waitForElements(firstRole, "xpath");
		if(this.page.element(firstRole, "xpath").getOne().isSelected() == true){
			this.page.element(firstRole, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(firstRole, "xpath").getOne().isSelected() == true){
			this.page.element(firstRole, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Save' button and accept the alert
	 * Date        : 05-Oct-2016
	 * Author      : Pallavi
	 **********************************************************************************/
	public UsersList clickSaveButtonAndAcceptAlert() throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		this.page.element(saveButton, "css").clickUsingJSE();
		this.clickOnOkButton();
		return this;
	}
}