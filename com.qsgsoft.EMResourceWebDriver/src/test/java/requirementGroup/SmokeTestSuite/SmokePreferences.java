package requirementGroup.SmokeTestSuite;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.ChangePassword;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UpdateUserInfo;
import lib.page.UsersList;
import lib.page.ViewsList;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class SmokePreferences extends TestNG_UI_EXTENSIONS {

	public SmokePreferences() throws Exception {
		super();
	}
	
	/******************************************************************
	'Description : Verify that user does not receive expired status notification 
	for event only status type when the participating resource is removed from the event.
	'Precondition:
	'Date	 	 : 03-Sep-2014
	'Author		 : Sowmya
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that user does not receive expired status notification for event only"
			+ " status type when the participating resource is removed from the event.")
	public void testSmoke142238() throws Exception {

		gstrTCID = "142238";
		gstrTO = " Verify that user does not receive expired status notification for event only"
				+ " status type when the participating resource is removed from the event.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Roles_data objRoles_data = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		String strstatusTypeValues[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList
				.createStatusType(objStatuTypes_data.strMultiStatusType,
						objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusDescription)
				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.selectEventExpirationOption()
				.selectExpirationMinute(
						objStatusTypes_data.strStatusExpirationTime)
				.clickOnSaveButton()
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithExpirationTime(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createEventStatusTypeWithExpirationTime(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streNSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithExpirationTime(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.streNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streNDSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName1);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName1);

		System.out.println(strRoleValue[0]);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues).clickSaveButton();
		
		System.out.println();



		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.clickSystemNotificationPreferences()
				.clickExpiredStatusNotificationsEmailCheckBox()
				.clickExpiredStatusNotificationsTextPagerCheckBox()
				.clickSaveButton().clickOnOkButton();
		
		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault.selectFrame();
		// Create Event
		objEventManagement.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton();
		
		
		System.out.println(objUser_data.strNewUserName);
		System.out.println(objEvent_data.strEventName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.streNSTStatusTypeName,
				objStatuTypes_data.streNDSTStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViewsList1
		.clickOnUpdateStatus(objResource_data.strResourceName);
		
		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValues[1],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[0])
				.enterNedocsUpdateValue(strstatusTypeValues[3],
						objView_data.strValueForNDST)
				.clickOnSaveButton();
		
	   String strApplicationTime = objEventManagement1.getApplicationTime();
	    
	  String  strCurrentYear = objDts.getCurrentDate("yyyy");
	    
	    strApplicationTime = strApplicationTime+" "+strCurrentYear;
	    
	    strApplicationTime = objDts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

	    strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5, "MM/dd/yyyy HH:mm");
	    
	    System.out.println(strApplicationTime);

		objEventManagement1.navigateToEventManagement()
				.clickOnEditLink(objEvent_data.strEventName)
				.deselectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventManagementPage();

		objLogin1.clickLogOut();
		
		Thread.sleep(300000);
		
		Thread.sleep(30000);

		String strMsgBody1 = "For "
				+ objUser_data.strFullName
				+ "\nRegion: "
				+ objTest_data.strRegionName
				+ "\n\nThe "
				+ objStatuTypes_data.strSSTStatusTypeName
				+ " status for "
				+ objResource_data.strResourceName
				+ " expired "
				+ strApplicationTime
				+ ".\n\nClick the link below to go to the EMResource login screen:"
				+

				"\n\n        "
				+ "https://emresource.qa.intermedix.com"
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any action that may be required."
				+ "\n\n\nYou have signed up to receive expired "
				+ "status notifications. If you no longer"
				+ " want to receive expired status notifications,"
				+ " log onto EMResource and deselect the notification fields on the Preferences -> System Notification screen.";

		String strMsgBody2 = "For "
				+ objUser_data.strFullName
				+ "\nRegion: "
				+ objTest_data.strRegionName
				+ "\n\nThe "
				+ objStatuTypes_data.strMSTStatusTypeName
				+ " status for "
				+ objResource_data.strResourceName
				+ " expired "
				+ strApplicationTime
				+ ".\n\nClick the link below to go to the EMResource login screen:"
				+

				"\n\n        "
				+ "https://emresource.qa.intermedix.com"
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any action that may be required."
				+ "\n\n\nYou have signed up to receive expired "
				+ "status notifications. If you no longer"
				+ " want to receive expired status notifications,"
				+ " log onto EMResource and deselect the notification fields on the Preferences -> System Notification screen.";

		String strMsgBody3 = "EMResource expired status: "
				+ objResource_data.strResourceName + ". "
				+ objStatuTypes_data.strSSTStatusTypeName + " status expired "
				+ strApplicationTime;

		String strMsgBody4 = "EMResource expired status: "
				+ objResource_data.strResourceName + ". "
				+ objStatuTypes_data.strMSTStatusTypeName + " status expired "
				+ strApplicationTime;

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = "Expired Status Notification: "
				+ objResource_data.strResourceName;
		String strSubject1 = "Expired Status: Abb";

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
		boolean blnMsg4 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2);

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject1);

			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}

			if (blnMsg4 == false) {
				blnMsg4 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody4);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg4 && blnMsg3);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
    /********************************************************************************************************************
	 * 'Description : Verify that user with any of the affiliated rights on the
	 * resource, who has subscribed to receive ‘My Resources Only’ notification,
	 * receives the notification when an event is created selecting his/her
	 * resources. 
	 * 'Precondition: 'Date : 04-Sep-2014 'Author : Sinchana
	 * '-----------------------------------------------------------------------------------------------------------------
	 * - - 'Modified Date Modified By 'Date Name
	 *********************************************************************************************************************/
	@Test(description = "Verify that user with any of the affiliated rights on the resource, "
			+ "who has subscribed to receive ‘My Resources Only’ notification, receives the notification when an event is created selecting his/her resources.")
	public void testSmoke142237() throws Exception {

		gstrTCID = "142237";
		gstrTO = "Verify that user with any of the affiliated rights on the resource, who has subscribed to receive ‘My Resources Only’ notification, receives the notification when an event is created selecting his/her resources.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		String strstatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased Status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatuTypes_data.strMultiStatusType,
						objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		// Create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);

		System.out.println("templet " + objESetUp_data.strEventTemplate);

		// User1 creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterEmail(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("User1: " + objUser_data.strNewUserName);

		// User2 creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.enterEmail(objUser_data.strPrimaryMailId)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectFirstRole()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("User2: " + objUser_data.strNewUserName1);

		// User3 creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName2)
				.enterEmail(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName2,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("User3: " + objUser_data.strNewUserName2);
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate)
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnResNotification(objUser_data.strFullName, true)
				.clickOnEmailNotification(objUser_data.strNewUserName1, true)
				.clickOnResNotification(objUser_data.strFullName1, true)
				.clickOnEmailNotification(objUser_data.strNewUserName2, true)
				.clickOnResNotification(objUser_data.strFullName2, true)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		System.out.println("Log in as User1");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				           .verifyEventManagementPage()
				           .verifyCreateEventButtonDisplayed();

		objEventManagement1.clickOnCreateNewEvent()
				            .verifySelectEventTemplatePage();

		objEventManagement1.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				           .verifyCreateEventPage();

		objEventManagement1.enterAdHocEventName(objEvent_data.strEventName)
				           .enterAdHocEventDescription(objEvent_data.strEventDescription)
				           .selectResource(strResourceValue).clickOnSaveButton()
				       //    .clickAcknowledgeAllNotifications()
				           .verifyEventName(objEvent_data.strEventName)
				           .verifyEventNameInEventBanner(objEvent_data.strEventName);

		
		 objEventManagement1.navigateToEventListNew()
		                 .verifyEventName(objEvent_data.strEventName);		 

		System.out.println("Event Name: " + objEvent_data.strEventName);

		objLogin1.clickLogOut();

		String strMsgBody1 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUser_data.strFullName + "\n\n"
				+ "Regions: " + objTest_data.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;
		
		String strMsgBody2 = "Event Notice for: " + objUser_data.strFullName1
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUser_data.strFullName + "\n\n"
				+ "Regions: " + objTest_data.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;
		
		String strMsgBody3 = "Event Notice for: " + objUser_data.strFullName2
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUser_data.strFullName + "\n\n"
				+ "Regions: " + objTest_data.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
					
		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}
			
			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}
			
			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}
			
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);
		
		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Verify that a user can change his/her password from Preferences >> Change password page.
	'Precondition:
	'Date	 	 : 09-Oct-2014
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that a user can change his/her password from Preferences >> Change password page.")
	public void testSmoke117552() throws Exception {

		gstrTCID = "117552";
		gstrTO = "Verify that a user can change his/her password from Preferences >> Change password page.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ChangePassword objChangePassword1 = new ChangePassword(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubMenus.navigateToUsers();
		
		objUsersList.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.selectFirstRole()
		.clickSaveButton();
		System.out.println(objUserdata.strNewUserName);
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToChangePasswordInPreferences();
		
		objChangePassword1.verChangePasswordScreenIsDisplayed()
					      .verChangePwdScreenWithClickHere()
					      .switchTochangePwdFrame()
					      .verChangePwdWindow()
					      .changePasswordUnderPref(objUserdata.strNewPassword,objUserdata.strNewPassword1, objUserdata.strNewPassword1)
					      .verPasswordStatusScreenIsDisplayedNew()
					      .clickOnClose();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplicationNew(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objLogin1.verifyInvalidUsernameAndPwdError()
		 		 .loginToApplication(objUserdata.strNewUserName, objUserdata.strNewPassword1);
		
		objRegionDefault1.selectFrame();
		
		objRegionDefault1.verifyRegionDefaultPage();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description :  Verify that a user can change his/her information from Preferences >> 
	'Precondition:
	'Date	 	 : 10-Oct-2014
	'Author		 : Shradha
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = " Verify that a user can change his/her information from Preferences >> ")
	public void testSmoke91664() throws Exception {

		gstrTCID = "91664";
		gstrTO = " Verify that a user can change his/her information from Preferences >> ";
	
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		UpdateUserInfo objUpdateUserInfo1 =new UpdateUserInfo(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubMenus.navigateToUsers();
		
		objUsersList.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
				

		.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToUsersInfoInPreferences();
		objUpdateUserInfo1
		.verUpdateUserInfoIsDisplayed()
		.verFullnameUpdateUserInfoPage(objUserdata.strFullName)
		.editFullName(objUserdata.strEditedFullName)
		.clickOnSaveButton()
		.verPreferencesMenuPageIsDisplayed();
		objRegionDefault1
		 .verifyUserNameInFooter(objUserdata.strEditedFullName);
		
		objNavigationToSubMenus1.navigateToUsersInfoInPreferences();
		objUpdateUserInfo1
		.verUpdateUserInfoIsDisplayed()
		.verFullnameUpdateUserInfoPage(objUserdata.strEditedFullName);
		objLogin1.clickLogOut();
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objRegionDefault1.selectFrame();
		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
	
		objNavigationToSubMenus1.navigateToUsers();
		objUsersList1
		.verifyUserListPageIsDisplayed()
		.enterUsernameInSearchInputField(objUserdata.strNewUserName)
		 .clickSearchButton()
		 .verUserDetails(objUserdata.strNewUserName, objUserdata.strEditedFullName," ")
		 .editUserDetails(objUserdata.strNewUserName)
		 .verEditUserPageisDisplayed()
		 .verNameInEditUserPage(objUserdata.strNewUserName)
		 .verFullNameInEditUserPage(objUserdata.strEditedFullName);
		 objLogin1.clickLogOut();
		 
		 gstrResult = "PASS";
	}
}