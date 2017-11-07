package requirementGroup.CreatingAndManagingEvents;

import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEndMultiRegionEvent extends TestNG_UI_EXTENSIONS {

	public NewEndMultiRegionEvent() throws Exception {
		super();
	}

	/*************************************************************************************
	 * 'Description 	: Verify that ending multi-region event in a region ends the event in other regions as well. . 
	 * 'Precondition	: 
	 * 'Date 			: 23-Nov-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = " Verify that ending multi-region event in a region ends the event in other regions as well. ")
	public void testHappyDay164144() throws Exception {

		gstrTCID = "164144";
		gstrTO = " Verify that ending multi-region event in a region ends the event in other regions as well. ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Roles_data objRoles_data = new Roles_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);
		Regions objRegions = new Regions(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strstatusTypeValues1[] = new String[6];
		String strResourceTypeValue1[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strRoleValue1[] = new String[1];
		String strRegionValue[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();
		
		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
		    .createNewStatus(objStatuTypes_data.strStatusNameInMulti,
		    		objStatuTypes_data.strStatusColor)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

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

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// create multi region Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);

		System.out.println("ET1 " + objESetUp_data.strEventTemplate);

		// User1 creation
		String[] strRegionNames = { objTest_data.strRegionName,
				objTest_data.strRegionName2 };

		objNavigationToSubMenus.navigateToRegions();

		strRegionValue[0] = objRegions.getRegionValue(strRegionNames[0]);

		strRegionValue[1] = objRegions.getRegionValue(strRegionNames[1]);

		System.out.println(strRegionValue[0]);
		System.out.println(strRegionValue[1]);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

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
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		System.out.println("User1: " + objUser_data.strNewUserName);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName2);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusType(objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusColor)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
					objStatuTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(
					objStatuTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();
		strstatusTypeValues1[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName1);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues1);

		strResourceTypeValue1[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName1);

		strRoleValue1[0] = objRoles.getRoleValue(objRoles_data.strRoleName1);

		// create multi region Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate1,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue1,
				strstatusTypeValues1);

		System.out.println("ET2 " + objESetUp_data.strEventTemplate1);

		// User in Region B
		objUsersList
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.selectRoleCheckBox(strRoleValue1)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1]).verifySelectAllButton()
				.clickOnRegionName(strRegionValue[0])
				.clickOnRegionName(strRegionValue[1]).clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate1)
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate1)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
						   .createNewMultiEventButton()
						   .verifyCreateMultiRegionEventPage();

		objEventManagement1
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyRegionAndETName(objTest_data.strRegionName,
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(objTest_data.strRegionName2,
						objESetUp_data.strEventTemplate1).clickOnYesButton()
				.verWebNotificationframe().verWebNotificationAndAcknowledge(objEvent_data.strMultiRegionEvent,
						objEvent_data.strMultiRegionEventDescription).clickAcknowledgeAllNotifications()
				.selectFrame();

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strMultiRegionEvent);
		
		String strEndedEve = "Ended: "+objEvent_data.strMultiRegionEvent+"";
		
		objEventManagement1.clickOnEndEvent(objEvent_data.strMultiRegionEvent)
		.verWebNotificationframe()
		.verWebNotificationAndAcknowledge(strEndedEve,
						objEvent_data.strEventEndDescription);
		
		String strWebNotDateAndTime = objEventManagement1.getTimeInWebNotification();
		
		objEventManagement1.clickAcknowledgeAllNotifications();
		
		objEventManagement1.selectFrame();
		
		objEventManagement1.verEveNotPresentInEveBanner(objEvent_data.strMultiRegionEvent);
		
		objRegionDefault1.clickRegionLink();
		
		objSelectRegion1.selectRegion(objTest_data.strRegionName2)
		.clickNextButton();
		
		objEventManagement1.selectFrame();
		
		objEventManagement1.verEveNotPresentInEveBanner(objEvent_data.strMultiRegionEvent);
		
		objLogin1.clickLogOut();
		
		String strSubject = "Ended: " + objEvent_data.strMultiRegionEvent;

		String strMsgBody1 = "Event Notice for: "
				+ objUser_data.strFullName
				+ "\n"
				+ objEvent_data.strMultiRegionEvent
				+ " ended at "
				+ strWebNotDateAndTime
				+ "\n\nFrom: "
				+ objUser_data.strFullName
				+ "\n"
				+ "Regions: "
				+ objTest_data.strRegionName2+ ", "
						+ objTest_data.strRegionName
				+ "\n\nPlease"
				+ " do not reply to this email message. You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = objEvent_data.strMultiRegionEvent + " ended at "
				+ strWebNotDateAndTime + "\nFrom: " + objUser_data.strFullName + "\n"
				+ "Regions: " + objTest_data.strRegionName2+ ", "
						+ objTest_data.strRegionName;
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {

				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}
			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	 * 'Description :Edit multi-region event and change the end time and verify that the event ends at the newly provided time.
	 * Date : 24-Nov-2015
	 * 'Author : Sangappa K
	 ********************************************************************************************************************/
	@Test(description ="Edit multi-region event and change the end time and verify that the event ends at the newly provided time.")
	public void testHappyDay133942() throws Exception {
		
		gstrTCID ="133942";
		gstrTO	 ="Edit multi-region event and change the end time and verify that the event ends at the newly provided time.";

		Login_data objTest_data = new Login_data();

		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		
		UsersList UsersList_page = new UsersList(this.driver1);
		String strRegionValue[] = new String[2];

		String strFilePath = Login_data.strTestDataPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();
		String strRegionNames[] = new String[2];
		

		strRegionNames[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 2, strFilePath);
		strRegionNames[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 3, strFilePath);
		
		System.out.println("reg1" + strRegionNames[0]);
		
		System.out.println("reg2" + strRegionNames[1]);

		strRegionValue[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 2, strFilePath);
		strRegionValue[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 3, strFilePath);

		String strResourceName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 16, strFilePath);
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);
		
		
		System.out.println("res1"+ strResourceName);
		
		System.out.println("res2"+ strResourceName1);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}


		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
	
		// User creation
		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)	
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectViewResourceRights(strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.clickRegionsLinkForUser(objUser_data.strNewUserName)

				.selectRegion(strRegionValue[1])

				.clickSaveButton();
		
		EventSetUp_page.navigateToEventSetUp();
		EventSetUp_page
				.navigateToEventNotificationPreferences(strEventTemplate);
		
		EventSetUp_page
		.deselectSelectAllEmailOption()
		.deselectSelectAllPagerOption()
		.deselectSelectAllResOption()
		.deselectSelectAllWebOption()
		.navigateToEventNotificationPreferences(
				strEventTemplate)
		.clickOnEmailNotification(objUser_data.strNewUserName, true)
		.clickOnPagerNotification(objUser_data.strNewUserName, true)
		.clickOnWebNotification(objUser_data.strNewUserName, true)
		.clickSaveButton();
		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page.selectFrame();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page
				.navigateToUsers()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName)

				.selectFirstRole()
				
				.selectViewResourceRights(strResourceName1)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName)

				.clickMultiRegionEventRights()

				.verifyEditMultiRegionEventRights()

				.verifyRegionName(strRegionValue[0])

				.verifyRegionName(strRegionValue[1])

				.verifySaveButton()

				.verifyCancelButton()

				.verifySelectAllButton()

				.selectUserRegion(strRegionValue[0])

				.selectUserRegion(strRegionValue[1])

				.clickSaveButton()

				.verifyEditUserPageIsDisplayed()

				.clickSaveButton()

				.verifyUserListPageIsDisplayed();

		EventSetUp_page.navigateToEventSetUp();
		EventSetUp_page.navigateToEventNotificationPreferences(strEventTemplate1);
		
		EventSetUp_page
		.deselectSelectAllEmailOption()
		.deselectSelectAllPagerOption()
		.deselectSelectAllResOption()
		.deselectSelectAllWebOption()
		.navigateToEventNotificationPreferences(
				strEventTemplate1)
		.clickOnEmailNotification(objUser_data.strNewUserName, true)
		.clickOnPagerNotification(objUser_data.strNewUserName, true)
		.clickOnWebNotification(objUser_data.strNewUserName, true)
		.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();
		
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();
		
		System.out.println(objEvent_data.strEventName);

		// Event creation
		EventManagement_page1.clickOnEventLink()
		                      .clickOnEventManagement() 

		.createNewMultiEventButton()
				
		.verifyCreateMultiRegionEventPage()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);
	
		EventManagement_page1.selectEventTemplateForMRE(strRegionValue[0], strEventTemplate);

		EventManagement_page1.selectEventTemplateForMRE(strRegionValue[1], strEventTemplate1);
		
		EventManagement_page1.clickOnNextButton()

		.verifyMultiRegionEventConfirmationPage()

		.verifyRegionAndETName(strRegionNames[0], strEventTemplate)

		.verifyRegionAndETName(strRegionNames[1], strEventTemplate1)

		.verifyConfirmationMessage()

		.clickOnYesButton();
		
		String actualTime = EventManagement_page1
				.getEventStartDateAndTime(objEvent_data.strEventName);

		objEvent_data.strEventEndTime = objDts.AddTimeToExistingTimeHourAndMin(
				actualTime, 0, 5, "yyyy-MM-dd HH:mm");

		EventManagement_page1
				.verifyEventName(objEvent_data.strEventName)
				.verifyEventNameAndTemplate(objEvent_data.strEventName,
						strEventTemplate)
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)

				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		EventManagement_page1.verifyEditEventLink(objEvent_data.strEventName);

		EventManagement_page1.clickOnEditLink(objEvent_data.strEventName);

		objEvent_data.strGetEventStartTime = objDts
				.AddTimeToExistingTimeHourAndMin(objEvent_data.strEventEndTime,
						0, 0, "yyyy-MM-dd HH:mm");

		objEvent_data.strGetEventStartTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm",
				"yyyy MMM dd HH mm");

		String strEndTime[] = objEvent_data.strGetEventStartTime.split(" ");

		EventManagement_page1.selectEventEndDateAndTime(strEndTime);

		EventManagement_page1.clickOnNextButton().clickOnNextButton()
				.clickOnNextButton()
				.verifyRegionAndETName(strRegionNames[0], strEventTemplate)
				.verifyRegionAndETName(strRegionNames[1], strEventTemplate1)
				.clickOnYesButton();

		System.out.println("Waiting for 5 minutes");
		Thread.sleep(300000);
		System.out.println("Waited for 5 minutes");

		EventManagement_page1.clickOnEventLink();

		EventManagement_page1
				.verWebNotificationframe()

				.verWebNotificationAndAcknowledge(
						"Ended: " + objEvent_data.strEventName,
						objEvent_data.strEventEndDescription)

				.clickAcknowledgeAllNotifications()
				.selectFrame();
		
		   Thread.sleep(5000);
		
		EventManagement_page1.clickOnEventManagement()
		.verifyEndedUnderStatusColumn(objEvent_data.strEventName);

		String strApplicationTime = objDts.converDateFormat(
				objEvent_data.strEventEndTime, "yyyy-MM-dd HH:mm",
				"MM/dd/yyyy HH:mm");

		System.out.println("strApplicationTime" + strApplicationTime);

		login_page1.clickLogOut();
		
		String strSubject1 = "Ended: "+objEvent_data.strEventName;

		String strMsgBody3 = "Event Notice for: "
				+ objUser_data.strFullName
				+ "\n"
				+ objEvent_data.strEventName
				+ " ended at "
				+ strApplicationTime
				+ "\n\nFrom: "
				+ objEvent_data.strAutomaticShchedulingsys
				+ "\n"
				+ "Regions: "
				+ strRegionNames[0]+ ", "
						+ strRegionNames[1]
				+ "\n\nPlease"
				+ " do not reply to this email message. You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;
		
		System.out.println("strMsgBody3" +   strMsgBody3);

		String strMsgBody4 = objEvent_data.strEventName + " ended at "
				+ strApplicationTime + "\nFrom: " + objEvent_data.strAutomaticShchedulingsys + "\n"
				+ "Regions: " + strRegionNames[0]+ ", "
						+ strRegionNames[1];
		
		System.out.println("strMsgBody4" +   strMsgBody4);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject1);

		boolean blnMsg3 = false;
		boolean blnMsg4 = false;
		

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject1);

			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}

			if (blnMsg4 == false) {
				blnMsg4 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}
			objMailVerificationFunctions.backToMailInbox();

		}
		    assertTrue(blnMsg3 && blnMsg4);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";	
	}	
	
	/*******************************************************************************************************************
	 * 'Description :Verify that a never ending multi-region event can be edited to end on a certain date at a specified time. 
	 * Date : 25-Nov-2015
	 * 'Author : Sangappa K
	 ********************************************************************************************************************/
	@Test(description ="Verify that a never ending multi-region event can be edited to end on a certain date at a specified time. ")
	public void testHappyDay133944() throws Exception {
		
		gstrTCID ="133944";
		gstrTO	 ="Verify that a never ending multi-region event can be edited to end on a certain date at a specified time. ";

		Login_data objTest_data = new Login_data();

		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		
		
		UsersList UsersList_page = new UsersList(this.driver1);
		String strRegionValue[] = new String[2];

		String strFilePath = Login_data.strTestDataPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();

		String strRegionNames[] = new String[2];

		strRegionNames[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 2, strFilePath);
		strRegionNames[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 3, strFilePath);

		System.out.println("reg1" + strRegionNames[0]);

		System.out.println("reg2" + strRegionNames[1]);

		strRegionValue[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 2, strFilePath);
		strRegionValue[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 3, strFilePath);

		String strResourceName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 16, strFilePath);
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		System.out.println("res1" + strResourceName);

		System.out.println("res2" + strResourceName1);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectViewResourceRights(strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.clickRegionsLinkForUser(objUser_data.strNewUserName)

				.selectRegion(strRegionValue[1])

				.clickSaveButton();

		EventSetUp_page.navigateToEventSetUp();
		EventSetUp_page
				.navigateToEventNotificationPreferences(strEventTemplate);

		EventSetUp_page.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption().deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(strEventTemplate)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();
		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page.selectFrame();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page
				.navigateToUsers()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName)

				.selectFirstRole()

				.selectViewResourceRights(strResourceName1)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName)

				.clickMultiRegionEventRights()

				.verifyEditMultiRegionEventRights()

				.verifyRegionName(strRegionValue[0])

				.verifyRegionName(strRegionValue[1])

				.verifySaveButton()

				.verifyCancelButton()

				.verifySelectAllButton()

				.selectUserRegion(strRegionValue[0])

				.selectUserRegion(strRegionValue[1])

				.clickSaveButton()

				.verifyEditUserPageIsDisplayed()

				.clickSaveButton()

				.verifyUserListPageIsDisplayed();

		EventSetUp_page.navigateToEventSetUp();
		EventSetUp_page
				.navigateToEventNotificationPreferences(strEventTemplate1);

		EventSetUp_page.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption().deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(strEventTemplate1)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		System.out.println(objEvent_data.strEventName);

		// Event creation
		EventManagement_page1.clickOnEventLink().clickOnEventManagement()

		.createNewMultiEventButton()

		.verifyCreateMultiRegionEventPage()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

		objEvent_data.strEventStartTime = EventManagement_page1
				.getEventStartDateAndTime();

		EventManagement_page1
				.clickEventNeverEndRadioButton()

				.selectEventTemplateForMRE(strRegionValue[0], strEventTemplate)

				.selectEventTemplateForMRE(strRegionValue[1], strEventTemplate1)

				.clickOnNextButton()

				.clickOnKeepButton()

				.verifyMultiRegionEventConfirmationPage()

				.verifyRegionAndETName(strRegionNames[0], strEventTemplate)

				.verifyRegionAndETName(strRegionNames[1], strEventTemplate1)

				.clickOnYesButton()

				.verifyEventEndTimeWhenItSetToNever(objEvent_data.strEventName,
						"never");

		String actualTime = EventManagement_page1
				.getEventStartDateAndTime(objEvent_data.strEventName);// star
																		// date

		objEvent_data.strEventEndTime = objDts.AddTimeToExistingTimeHourAndMin(
				actualTime, 0, 5, "yyyy-MM-dd HH:mm");

		EventManagement_page1
				.verifyEventName(objEvent_data.strEventName)
				.verifyEventNameAndTemplate(objEvent_data.strEventName,
						strEventTemplate)
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)

				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		EventManagement_page1.verifyEditEventLink(objEvent_data.strEventName);

		EventManagement_page1.clickOnEditLink(objEvent_data.strEventName);

		objEvent_data.strGetEventStartTime = objDts
				.AddTimeToExistingTimeHourAndMin(objEvent_data.strEventEndTime,
						0, 0, "yyyy-MM-dd HH:mm");

		objEvent_data.strGetEventStartTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm",
				"yyyy MMM dd HH mm");

		String strEndTime[] = objEvent_data.strGetEventStartTime.split(" ");

		EventManagement_page1.selectEventEndDateAndTime(strEndTime);

		EventManagement_page1.clickOnNextButton().clickOnNextButton()
				.clickOnNextButton()
				.verifyRegionAndETName(strRegionNames[0], strEventTemplate)
				.verifyRegionAndETName(strRegionNames[1], strEventTemplate1)
				.clickOnYesButton();

		System.out.println("Waiting for 5 minutes");
		Thread.sleep(300000);
		System.out.println("Waited for 5 minutes");

		EventManagement_page1.clickOnEventLink();

		EventManagement_page1
				.verWebNotificationframe()

				.verWebNotificationAndAcknowledge(
						"Ended: " + objEvent_data.strEventName,
						objEvent_data.strEventEndDescription)

				.clickAcknowledgeAllNotifications()

				.selectFrame();
		
		Thread.sleep(5000);
		
		EventManagement_page1.clickOnEventManagement()
		.verifyEndedUnderStatusColumn(objEvent_data.strEventName);

		String strApplicationTime = objDts.converDateFormat(
				objEvent_data.strEventEndTime, "yyyy-MM-dd HH:mm",
				"MM/dd/yyyy HH:mm");

		System.out.println("strApplicationTime" + strApplicationTime);
	
		login_page1.clickLogOut();
		
		String strSubject1 = "Ended: "+objEvent_data.strEventName;

		String strMsgBody3 = "Event Notice for: "
				+ objUser_data.strFullName
				+ "\n"
				+ objEvent_data.strEventName
				+ " ended at "
				+ strApplicationTime
				+ "\n\nFrom: "
				+ objEvent_data.strAutomaticShchedulingsys
				+ "\n"
				+ "Regions: "
				+ strRegionNames[0]+ ", "
						+ strRegionNames[1]
				+ "\n\nPlease"
				+ " do not reply to this email message. You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;
		
		System.out.println("strMsgBody3" +   strMsgBody3);

		String strMsgBody4 = objEvent_data.strEventName + " ended at "
				+ strApplicationTime + "\nFrom: " + objEvent_data.strAutomaticShchedulingsys + "\n"
				+ "Regions: " + strRegionNames[0]+ ", "
				+ strRegionNames[1];
		
		System.out.println("strMsgBody4" +   strMsgBody4);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject1);

		boolean blnMsg3 = false;
		boolean blnMsg4 = false;
		
		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject1);

			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}

			if (blnMsg4 == false) {
				blnMsg4 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}
			objMailVerificationFunctions.backToMailInbox();

		}
		    assertTrue(blnMsg3 && blnMsg4);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";	
	}	
	
	/*******************************************************************************************************************
	 * 'Description :Verify that multi-region event ends at the newly specified End date and time when the event end date is
	 *                edited to time earlier than the previously provided end date and time. 	
	 * Date : 26-Nov-2015
	 * 'Author : Sangappa K
	 ********************************************************************************************************************/
	@Test(description ="Verify that multi-region event ends at the newly specified End date and time when the event end date "
			    + "is edited to time earlier than the previously provided end date and time. 	")
	public void testHappyDay133945() throws Exception {
		
		gstrTCID ="133945";
		gstrTO	 ="Verify that multi-region event ends at the newly specified End date and time when the event end date is edited "
				+ "to time earlier than the previously provided end date and time. 	";

		Login_data objTest_data = new Login_data();

		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		String strRegionValue[] = new String[2];

		String strFilePath = Login_data.strTestDataPath;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		
		Date_Time_settings objDts = new Date_Time_settings();

		String strRegionNames[] = new String[2];
		

		strRegionNames[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 2, strFilePath);
		strRegionNames[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 3, strFilePath);

		System.out.println("reg1" + strRegionNames[0]);

		System.out.println("reg2" + strRegionNames[1]);

		strRegionValue[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 2, strFilePath);
		strRegionValue[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 3, strFilePath);

		String strResourceName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 16, strFilePath);
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		System.out.println("res1" + strResourceName);

		System.out.println("res2" + strResourceName1);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectViewResourceRights(strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1])
				.clickSaveButton();

		EventSetUp_page.navigateToEventSetUp();
		EventSetUp_page
				.navigateToEventNotificationPreferences(strEventTemplate);

		EventSetUp_page.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption().deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(strEventTemplate)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();
		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page.selectFrame();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page
				.navigateToUsers()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectFirstRole()
				.selectViewResourceRights(strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName)

				.clickMultiRegionEventRights()

				.verifyEditMultiRegionEventRights()

				.verifyRegionName(strRegionValue[0])

				.verifyRegionName(strRegionValue[1])

				.verifySaveButton()

				.verifyCancelButton()

				.verifySelectAllButton()

				.selectUserRegion(strRegionValue[0])

				.selectUserRegion(strRegionValue[1])

				.clickSaveButton()

				.verifyEditUserPageIsDisplayed()

				.clickSaveButton()

				.verifyUserListPageIsDisplayed();

		EventSetUp_page.navigateToEventSetUp();
		EventSetUp_page
				.navigateToEventNotificationPreferences(strEventTemplate1);

		EventSetUp_page.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption().deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(strEventTemplate1)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		System.out.println(objEvent_data.strEventName);

		// Event creation
		EventManagement_page1.clickOnEventLink().clickOnEventManagement()

		.createNewMultiEventButton()

		.verifyCreateMultiRegionEventPage()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

		EventManagement_page1.selectEventTemplateForMRE(strRegionValue[0],
				strEventTemplate);

		EventManagement_page1.selectEventTemplateForMRE(strRegionValue[1],
				strEventTemplate1);

		EventManagement_page1.selectEventEndDate();

		EventManagement_page1.clickOnNextButton()

		.verifyMultiRegionEventConfirmationPage()

		.verifyRegionAndETName(strRegionNames[0], strEventTemplate)

		.verifyRegionAndETName(strRegionNames[1], strEventTemplate1)

		.verifyConfirmationMessage()

		.clickOnYesButton();

		String actualTime = EventManagement_page1
				.getEventStartDateAndTime(objEvent_data.strEventName);

		objEvent_data.strEventEndTime = objDts.AddTimeToExistingTimeHourAndMin(
				actualTime, 0, 5, "yyyy-MM-dd HH:mm");

		EventManagement_page1
				.verifyEventName(objEvent_data.strEventName)
				.verifyEventNameAndTemplate(objEvent_data.strEventName,
						strEventTemplate)
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)

				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		EventManagement_page1.verifyEditEventLink(objEvent_data.strEventName);

		EventManagement_page1.clickOnEditLink(objEvent_data.strEventName);

		objEvent_data.strGetEventStartTime = objDts
				.AddTimeToExistingTimeHourAndMin(objEvent_data.strEventEndTime,
						0, 0, "yyyy-MM-dd HH:mm");

		objEvent_data.strGetEventStartTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm",
				"yyyy MMM dd HH mm");

		System.out.println("objEvent_data.strGetEventStartTime"+ objEvent_data.strGetEventStartTime);
		
		String strEndTime[] = objEvent_data.strGetEventStartTime.split(" ");

		EventManagement_page1.selectEventEndDateAndTime(strEndTime);

		EventManagement_page1.clickOnNextButton()
				.clickOnNextButton()
				.clickOnNextButton()
				.verifyRegionAndETName(strRegionNames[0], strEventTemplate)
				.verifyRegionAndETName(strRegionNames[1], strEventTemplate1)
				.clickOnYesButton();

		System.out.println("Waiting for 5 minutes");
		Thread.sleep(300000);
		System.out.println("Waited for 5 minutes");

		EventManagement_page1.clickOnEventLink();

		EventManagement_page1
				.verWebNotificationframe()

				.verWebNotificationAndAcknowledge(
						"Ended: " + objEvent_data.strEventName,
						objEvent_data.strEventEndDescription)

				.clickAcknowledgeAllNotifications().selectFrame();
		
		Thread.sleep(5000);

		EventManagement_page1.clickOnEventManagement()
				.verifyEndedUnderStatusColumn(objEvent_data.strEventName);
		login_page1.clickLogOut();

		gstrResult = "PASS";
	}

}


	


