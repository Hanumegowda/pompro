package requirementGroup.SmokeTestSuite;

import static org.testng.AssertJUnit.assertTrue;
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
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class SmokeEvents extends TestNG_UI_EXTENSIONS {

	public SmokeEvents() throws Exception {
		super();
	}

	/*************************************************************************************
	'Description : Verify that 'qsg' user and user with appropriate right can create an Ad Hoc event. 
	'Precondition: 
	'Date : 08-Aug-2014 
	'Author : Sowmya 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that 'qsg' user and user with appropriate right can create an Ad Hoc event.")
	public void testSmoke142230() throws Exception {

		gstrTCID = "142230";
		gstrTO = "Verify that 'qsg' user and user with appropriate right can create an Ad Hoc event.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		String strstatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

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
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.streTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.streSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streSSTStatusTypeName);

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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainAdHocEventsOption()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objLogin.clickLogOut();

		System.out.println(objUser_data.strNewUserName);

		System.out
				.println("-----Precondition ends and test execution starts-------");


		String[] resourceName = { objResource_data.strResourceName };

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.streTSTStatusTypeName,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.streSSTStatusTypeName };

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				.verifyEventManagementPage()
				.verifyCreateEventButtonDisplayed()
				.verifyCreateEventButtonsDisplayed()
				.clickOnCreateAdHocEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnNextButton().verifySelectResourcesDisplayed()
				.verifyResourceNameInSelectResourcePage(resourceName);

		objResource1.clickResource(strResourceValue);

		objEventManagement1.clickOnNextButton()
				.verifySelectStatusTypesDisplayed();

		objEventManagement1
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypeNames);

		objResourceType1.clickStatusType(strstatusTypeValues);

		objEventManagement1.clickOnNextButton()
				.verifyAdHocEventConfirmationDisplayed().clickOnYesButton()
				.verifyEventName(objEvent_data.strEventName);

		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}

	/*******************************************************************************************
	'Description : Verify that user receives event update notification when
	               his/her resource is added to the Ad Hoc event 
	'Precondition: 
	'Date : 12-Aug-2014 
	'Author : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user receives event update notification when his/her resource is added to the Ad Hoc event")
	public void testSmoke142231() throws Exception {

		gstrTCID = "142231";
		gstrTO = "Verify that user receives event update notification when his/her resource is added to the Ad Hoc event";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

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

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
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
		System.out.println(objResourceType_data.strResourceTypeName);
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
		System.out.println(objResource_data.strResourceName);
		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainAdHocEventsOption()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);
		System.out.println(objUser_data.strNewUserName);
		// User2 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.selectFirstRole()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.navigateToEventNotificationPreferences(
						objESetUp_data.strAdHocEventTemplate)
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objESetUp_data.strAdHocEventTemplate)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnResNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickOnEmailNotification(objUser_data.strNewUserName1, true)
				.clickOnPagerNotification(objUser_data.strNewUserName1, true)
				.clickOnResNotification(objUser_data.strNewUserName1, true)
				.clickOnWebNotification(objUser_data.strNewUserName1, true)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUser_data.strNewUserName);

		System.out.println(objUser_data.strNewUserName1);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		String[] resourceName = { objResource_data.strResourceName };

		objEventManagement1.navigateToEventManagement()
				.verifyEventManagementPage()
				.clickOnCreateAdHocEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnNextButton()
				.verifySelectResourcesDisplayed()
				.verifyResourceNameInSelectResourcePage(resourceName)
				.clickOnNextButton();
		Thread.sleep(5000);
//		objEventManagement1.verifySelectStatusTypesDisplayed();
				
		objEventManagement1.clickOnNextButton();
				
		objEventManagement1.verifyAdHocEventConfirmationDisplayed()
				.clickOnYesButton()
				.verWebNotificationframe()
				.clickAcknowledgeAllNotifications().selectFrame()
				.verifyEventName(objEvent_data.strEventName)
				.clickOnEditLink(objEvent_data.strEventName)
				.verifyEditAdHocEventScreenIsDisplayed().clickOnNextButton()
				.verifySelectResourcesDisplayed()
				.verifyResourceNameInSelectResourcePage(resourceName)
				.selectResource(strResourceValue);

		objEventManagement1.clickOnNextButton()
				.verifySelectStatusTypesDisplayed();

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName };

		objEventManagement1
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypeNames);
		
		for (int i = 0; i < strstatusTypeValues.length; i++) {
			objEventManagement1
					.selectStatusTypeDuringAdhocEvents(strstatusTypeValues[i]);
		}

		objEventManagement1.clickOnNextButton()
				.clickOnYesButton();
				
		String strEventNam = "Update 1: " + objEvent_data.strEventName;

		objEventManagement1.verifyEventNameInEventBanner(strEventNam)
				.clickOnEventNameInEventBanner(strEventNam);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objLogin1.clickLogOut();
		
		String strSubject = "Update 1: " + objEvent_data.strEventName;
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
						objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.verWebNotificationframe()
		.verWebNotificationAndAcknowledge(strSubject, objEvent_data.strEventDescription).selectFrame();
		
		objLogin1.clickLogOut();
		
		String strMsgBody1 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Information: "
				+ objEvent_data.strEventDescription + "\n\n" + "From: "
				+ objUser_data.strFullName + "\n\n" + "Regions: "
				+ objTest_data.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strEventDescription + "\nFrom: "
				+ objUser_data.strFullName + "\nRegions: "
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

	/*************************************************************************************
	'Description : Verify that security can be provided for an event template. 
	'Precondition: 
	'Date : 13-Aug-2014 
	'Author : Renushree
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that security can be provided for an event template.")
	public void testSmoke96674() throws Exception {

		gstrTCID = "96674";
		gstrTO = "Verify that security can be provided for an event template.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		boolean blnTest = false;

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectSecRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName2);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectSecurityOption()
				.clickSaveButton()
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate)
				.clickOnSecurityOfEveTemplate(
						objEventSetUp_data.strEventTemplate)
				.verUsersListedInEveSecurityPage(objUserdata.strNewUserName)
				.verUsersListedInEveSecurityPage(objUserdata.strNewUserName2)
				.selectUserInEveSecutityPage(objUserdata.strNewUserName)
				.clickSaveButton().verEveTemplateListScreenIsDisplayed();
		System.out.println(objEventSetUp_data.strEventTemplate);

		objEventManagement1.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strEveStartTimeAndDate = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);

		objLogin1.clickLogOut();
		System.out.println(objEventSetUp_data.strEventTemplate);
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventManagement1
				.navigateToEventManagement()
				.verifyEventManagementPage()
				.verifyEndEventIsNotDisplayed(objEvent_data.strEventName)
				.verifyEditEventIsNotDisplayed(objEvent_data.strEventName)
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsNotDisplayed(
						objEventSetUp_data.strEventTemplate);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventManagement1
				.navigateToEventManagement()
				.clickOnEditLink(objEvent_data.strEventName)
				.enterAdHocEventName(objEvent_data.strEditedEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEditedEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEditedEventName)
				.verUpdateInEveBanner(
						"Update 1: " + objEvent_data.strEditedEventName + "")
				.clickOnEndEvent(objEvent_data.strEditedEventName);

		String strEveEndTimeAndDate = objEventManagement1
				.getEventEndTime(objEvent_data.strEditedEventName);

		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					"96674",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/" + objLogindata.strPassword
							+ "," + objUserdata.strNewUserName2 + "/"
							+ objLogindata.strPassword,
					objLogindata.strRegionName, objEvent_data.strEventName,
					objEventSetUp_data.strEventTemplate, "", "", "",
					"Verify mobile end condition", "", strEveStartTimeAndDate,
					strEveEndTimeAndDate };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "SmokeEvents");
		}
		
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify a private event can be created. 
	'Precondition:
	'Date : 13-Aug-2014 
	'Author : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************/
	@Test(description = "Verify a private event can be created.")
	public void testSmoke96698() throws Exception {

		gstrTCID = "96698";
		gstrTO = "Verify a private event can be created.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Roles_data objRoles_data = new Roles_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		String strstatusTypeValues[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

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

		// Create event status type
		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streMSTStatusTypeName);

		// Create private status type
		objStatusTypeList.createPrivateStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strpSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpSSTStatusTypeName);

		// Create private status type with event
		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strpeTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpeTSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("1u " + objUser_data.strNewUserName);

		// Create user2
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("2u " + objUser_data.strNewUserName1);

		// Create user3
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("3u " + objUser_data.strNewUserName2);

		// Create user4
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName3,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("4u " + objUser_data.strNewUserName3);

		// Create user5
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName4,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectOverrideViewingRestrictionOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("5u " + objUser_data.strNewUserName4);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickPrivateCheckBox();

		objResource1.clickResource(strResourceValue);

		objEventManagement1.clickOnSaveButton();

		System.out.println("event name" + objEvent_data.strEventName);

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strEventName).clickOnEventNameInEventBanner(
				objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceNameIsNotDisplayed(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objEventStatus1.verifyErrorMessageDisplayed();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verResourceNameInPopupWindow(
				objResource_data.strResourceName);

		String[] strStatusTypeName1 = { objStatuTypes_data.strNSTStatusTypeName };

		objMap1.verStatusTypesInPopupWindow(strStatusTypeName1);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strEventName).clickOnEventNameInEventBanner(
				objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceNameIsNotDisplayed(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objEventStatus1.verifyErrorMessageDisplayed();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verResourceNameInPopupWindow(
				objResource_data.strResourceName);

		String[] strStatusTypeValues2 = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strpSSTStatusTypeName };

		objMap1.verStatusTypesInPopupWindow(strStatusTypeValues2);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strEventName).clickOnEventNameInEventBanner(
				objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.strpSSTStatusTypeName,
				objStatuTypes_data.strpeTSTStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName3,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strEventName).clickOnEventNameInEventBanner(
				objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames);

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName4,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strEventName).clickOnEventNameInEventBanner(
				objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that an event template can be created.
	'Precondition: 
	'Date : 18-Aug-2014 
	'Author : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = " Verify that an event template can be created.")
	public void testSmoke91539() throws Exception {

		gstrTCID = "91539";
		gstrTO = "Verify that an event template can be created.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strPrivateStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strPrivateStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createPrivateStatusType(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strPrivateStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strPrivateStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strPrivateStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);
		
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strPrivateStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);
		
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strPrivateStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		String[] strAllSTValues = { strStatusTypeValues[0],
				strStatusTypeValues[1], strStatusTypeValues[2],
				strStatusTypeValues[3],strStatusTypeValues[4],strStatusTypeValues[5], strPrivateStatusTypeValues[0],
				strPrivateStatusTypeValues[1], strPrivateStatusTypeValues[2],
				strPrivateStatusTypeValues[3], strPrivateStatusTypeValues[4], strPrivateStatusTypeValues[5] };

		String[] strAllSTNames = { objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName1 };

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strAllSTValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strAllSTValues)
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)
				.clickOnEmailNotification(objUserdata.strNewUserName, true)
				.clickOnPagerNotification(objUserdata.strNewUserName, true)
				.clickOnWebNotification(objUserdata.strNewUserName, true)
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objEventManagement1
				.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue)
				.clickOnSaveButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame()
				.verifyEventName(objEvent_data.strEventName)
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventManagement1.verifyResourcesInEventBanner(
				objResource_data.strResourceName)
				.verifyResourceTypeInEventBanner(
						objResourceType_data.strResourceTypeName);

		objEventManagement1.verStatusTypesInEventBanner(strAllSTNames,
				objResourceType_data.strResourceTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that an event template can be edited.
	'Precondition: 
	'Date : 19-Aug-2014 
	'Author : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(enabled= false,description = "Verify that an event template can be edited.")
	public void testSmoke91540() throws Exception {

		gstrTCID = "91540";
		gstrTO = "Verify that an event template can be edited.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		boolean blnTest = false;

		String strStatusTypeValues[] = new String[2];
		String strSharedStatusTypeValues[] = new String[2];
		String strPrivateStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strSharedStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strSharedStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strPrivateStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createPrivateStatusType(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strPrivateStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		String[] strAllSTValues = { strStatusTypeValues[0],
				strStatusTypeValues[1], strSharedStatusTypeValues[0],
				strSharedStatusTypeValues[1], strPrivateStatusTypeValues[0],
				strPrivateStatusTypeValues[1] };

		String[] strSTNames = { objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strAllSTValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		String[] strSTVal = { strStatusTypeValues[0], strStatusTypeValues[1],
				strSharedStatusTypeValues[0], strSharedStatusTypeValues[1] };

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strSTVal)
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");
		System.out.println(objUserdata.strNewUserName);
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName)
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventManagement1.verifyResourcesInEventBanner(
				objResource_data.strResourceName)
				.verifyResourceTypeInEventBanner(
						objResourceType_data.strResourceTypeName);

		objEventManagement1.verifyStatusTypesInEventBanner(strSTNames,
				objResourceType_data.strResourceTypeName);

		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					"91540",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/" + objLogindata.strPassword,
					objLogindata.strRegionName,
					objEvent_data.strEventName,
					objEventSetUp_data.strEventTemplate,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName + ","
							+ objStatusTypes_data.strNSTStatusTypeName + ","
							+ objStatusTypes_data.strSSTStatusTypeName + ","
							+ objStatusTypes_data.strTSTStatusTypeName + ","
							+ objStatusTypes_data.strNSTStatusTypeName1 + ","
							+ objStatusTypes_data.strMSTStatusTypeName1,
					"Verify mobile end condition", "", "", "" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "SmokeEvents");
		}

		gstrResult = "PASS";
	}

	/******************************************************************
	'Description : Verify that an event can be ended manually. 
	'Precondition:
	'Date : 18-Aug-2014 
	'Author : Sowmya
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that an event can be ended manually.")
	public void testSmoke96638() throws Exception {

		gstrTCID = "96638";
		gstrTO = "Verify that an event can be ended manually.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		boolean blnTest = false;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

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

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
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

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);

		System.out.println("templet " + objESetUp_data.strEventTemplate);

		System.out.println(objUser_data.strNewUserName);
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
		                   .clickOnCreateNewEvent()
						   .clickOnCreateEvent(objESetUp_data.strEventTemplate)
						   .enterAdHocEventName(objEvent_data.strEventName)
						   .enterAdHocEventDescription(objEvent_data.strEventDescription);
		
		System.out.println(objESetUp_data.strEventTemplate);

		String strEventStartTime = objEventManagement1
				.getEventStartDateAndTime();

		objEvent_data.strEventStartTime = objDts.converDateFormat(
				strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		objEvent_data.strGetEventStartTime = objDts
				.AddTimeToExistingTimeHourAndMin(
						objEvent_data.strEventStartTime, 1, 0,
						"yyyy-MM-dd HH:mm");

		String strEventStartTimeTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm",
				"yyyy MMM dd HH mm");

		String strStartTime[] = strEventStartTimeTime.split(" ");

		objEventManagement1.selectEventStartDateAndTime(strStartTime);

		String strGetEventEndTime = objDts.AddTimeToExistingTimeHourAndMin(
				objEvent_data.strEventStartTime, 3, 0, "yyyy-MM-dd HH:mm");

		String strUpdatedEventEndTime = objDts.converDateFormat(
				strGetEventEndTime, "yyyy-MM-dd HH:mm", "yyyy MMM dd HH mm");

		String strEndTime[] = strUpdatedEventEndTime.split(" ");

		objEventManagement1.selectEventEndDateAndTime(strEndTime);

		objEventManagement1.clickOnSaveButton();

		objEventManagement1.verifyEventStartTimeNew(objEvent_data.strEventName,
				objEvent_data.strGetEventStartTime);

		objEventManagement1.verifyEventEndTime(objEvent_data.strEventName,
				strGetEventEndTime);

		objEventManagement1
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strFuture)
				.verifyEditEventLink(objEvent_data.strEventName)
				.verifyCancelEventLink(objEvent_data.strEventName)
				.verifyEventName(objEvent_data.strEventName);

		objEventManagement1.clickOnCreateNewEvent()
						   .clickOnCreateEvent(objESetUp_data.strEventTemplate)
						   .enterAdHocEventName(objEvent_data.strEventName1)
						   .enterAdHocEventDescription(objEvent_data.strEventDescription);

		String strEventStartTime1 = objEventManagement1
				.getEventStartDateAndTime();

		String getStartTime1 = objDts.converDateFormat(strEventStartTime1,
				"yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		objEventManagement1
				.clickOnSaveButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName1,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		objEventManagement1.verifyEventStartTimeNew(
				objEvent_data.strEventName1, getStartTime1);

		String actualTime1 = objEventManagement1.verifyEventStartTimeNew(
				objEvent_data.strEventName1, objEvent_data.strEventStartTime);

		objEvent_data.strEventEndTime = objDts.AddDaytoExistingDate(
				actualTime1, 1, "yyyy-MM-dd HH:mm");

		objEventManagement1.verifyEventEndTime(objEvent_data.strEventName1,
				objEvent_data.strEventEndTime)

		.verifyEventName(objEvent_data.strEventName1);

		objEventManagement1.clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName2)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		String strEventStartTime2 = objEventManagement1
				.getEventStartDateAndTime();

		String getStartTime2 = objDts.converDateFormat(strEventStartTime2,
				"yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		objEventManagement1
				.clickEventNeverEndRadioButton()
				.clickOnSaveButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName2,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		objEventManagement1.verifyEventStartTimeNew(
				objEvent_data.strEventName2, getStartTime2);

		objEventManagement1.verifyEventEndTimeWhenItSetToNever(
				objEvent_data.strEventName2, "never")

		.verifyEventName(objEvent_data.strEventName2);

		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					"96638",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objTest_data.strPassword,
							 objTest_data.strRegionName,
					objEvent_data.strEventName + ", "
							+ objEvent_data.strEventName1 + ", "
							+ objEvent_data.strEventName2,
					objESetUp_data.strEventTemplate,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strNumberStatusType + ","
							+ objStatuTypes_data.strNDSTStatusTypeName + ", "
							+ objStatuTypes_data.strTSTStatusTypeName + ", "
							+ objStatuTypes_data.strMSTStatusTypeName + ", "
							+ objStatuTypes_data.strSSTStatusTypeName,
					"Verify mobile end condition",
					"",
					objEvent_data.strGetEventStartTime + ", " + getStartTime1,
					", " + getStartTime2,
					strGetEventEndTime + ", " + objEvent_data.strEventEndTime
							+ ", " + "never" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "SmokeEvents");
		}

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that an event can be edited. 
	'Precondition: 
	'Date : 20-Aug-2014 
	'Author : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that an event can be edited.")
	public void testSmoke91536() throws Exception {

		gstrTCID = "91536";
		gstrTO = "Verify that an event can be edited.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objResourceType_data.strResourceTypeName);
		System.out.println(objStatusTypes_data.strDateStatusType);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)
				.clickOnEmailNotification(objUserdata.strNewUserName, true)
				.clickOnPagerNotification(objUserdata.strNewUserName, true)
				.clickOnWebNotification(objUserdata.strNewUserName, true)
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventManagement1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications()
				.selectFrame()
				.verifyEventName(objEvent_data.strEventName)
				.clickOnEditLink(objEvent_data.strEventName)
				.enterAdHocEventName(objEvent_data.strEditedEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEditedEventDescription)
				.clickOnSaveButton()
				.verWebNotificationframe()
				.clickAcknowledgeAllNotifications()
				.selectFrame()
				.verifyEventName(objEvent_data.strEditedEventName)
				.verUpdateInEveBanner(
						"Update 1: " + objEvent_data.strEditedEventName + "")
				.clickOnEditLink(objEvent_data.strEditedEventName)
				.enterAdHocEventName("S" + objEvent_data.strEditedEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEditedEventDescription)
				.clickOnSaveButton()
				.verWebNotificationframe()
				.clickAcknowledgeAllNotifications()
				.selectFrame()
				.verifyEventName("S" + objEvent_data.strEditedEventName)
				.verUpdateInEveBanner(
						"Update 2: " + "S" + objEvent_data.strEditedEventName
								+ "")
				.clickOnEditLink("S" + objEvent_data.strEditedEventName)
				.enterAdHocEventName("T" + objEvent_data.strEditedEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEditedEventDescription)
				.clickOnSaveButton()
				.verWebNotificationframe()
				.clickAcknowledgeAllNotifications()
				.selectFrame()
				.verifyEventName("T" + objEvent_data.strEditedEventName)
				.verUpdateInEveBanner(
						"Update 3: " + "T" + objEvent_data.strEditedEventName
								+ "");

		objLogin1.clickLogOut();

		String strSubject = "Update 1: " + objEvent_data.strEditedEventName
				+ "";

		String strMsgBody1 = "Event Notice for: " + objUserdata.strFullName
				+ "\n" + "Information: "
				+ objEvent_data.strEditedEventDescription + "\n\n" + "From: "
				+ objUserdata.strFullName + "\n\n" + "Regions: "
				+ objLogindata.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUserdata.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strEditedEventDescription + "\nFrom: "
				+ objUserdata.strFullName + "\nRegions: "
				+ objLogindata.strRegionName;

		String strSubject1 = "Update 2: " + "S"
				+ objEvent_data.strEditedEventName + "";

		String strSubject2 = "Update 3: " + "T"
				+ objEvent_data.strEditedEventName + "";

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

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

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject1);

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

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject2);

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

	/*************************************************************************************
	'Description : Verify that user is taken to 'Event Status' screen when clicked on the URL 
	               available on the notifications received for a Ad Hoc event 
	'Precondition:
	'Date : 20-Aug-2014 
	'Author : Sowmya
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test( description = "Verify that user is taken to 'Event Status' screen when clicked on the URL available "
			+ "on the notifications received for a Ad Hoc event")
	public void testSmoke142233() throws Exception {

		gstrTCID = "142233";
		gstrTO = "Verify that user is taken to 'Event Status' screen when clicked on the URL available "
				+ "on the notifications received for a Ad Hoc event";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

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
		Resource objResource1 = new Resource(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		objEvent_data.strEventDescription = objUser_data.strFullName;
		objUser_data.strFullName = objUser_data.strFullName;

		String strMsgBody1 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUser_data.strFullName + "\n\n"
				+ "Regions: " + objTest_data.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strEventDescription + "\nFrom: "
				+ objUser_data.strFullName + "\nRegions: "
				+ objTest_data.strRegionName;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

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
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		// Create event status type
		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streSSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainAdHocEventsOption()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strAdHocEventTemplate)
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strAdHocEventTemplate)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				.clickOnCreateAdHocEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnNextButton().verifySelectResourcesDisplayed();

		objResource1.clickResource(strResourceValue);

		objEventManagement1.clickOnNextButton()
				.verifySelectStatusTypesDisplayed();

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.streTSTStatusTypeName,
				objStatuTypes_data.streSSTStatusTypeName, };

		objEventManagement1
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypeNames);

		objResourceType1.clickStatusType(strstatusTypeValues);

		objEventManagement1.clickOnNextButton().clickOnYesButton()
				.verWebNotificationframe().clickAcknowledgeAllNotifications()
				.selectFrame().verifyEventName(objEvent_data.strEventName);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		String strUrlLink = "";

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
				if (blnMsg1 == true) {
					strUrlLink = objMailVerificationFunctions
							.GetUrlLinkFromMsgBody(
									objUser_data.strPrimaryMailId, strSubject);
				}
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();

		objMailVerificationFunctions.launchUrl(strUrlLink);
		
		objEventStatus1.verifyEventStatus();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Create an event template selecting mandatory address check box and verify 
	               that City, State and County are required when an event is created under it. 
	'Precondition: 
	'Date        : 02-Sep-2014 
	'Author      : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test( description = " Create an event template selecting mandatory address check box and verify that City, "
			+ "State and County are required when an event is created under it.")
	public void testSmoke120965() throws Exception {

		gstrTCID = "120965";
		gstrTO = " Create an event template selecting mandatory address check box and verify that City, "
				+ "State and County are required when an event is created under it.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		boolean blnTest = false;

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition);

		for (int intCount = 0; intCount < strResourceTypeValue.length; intCount++) {
			objEventSetUp1.selectResourceType(strResourceTypeValue[intCount]);
		}

		for (int intCount = 0; intCount < strStatusTypeValues.length; intCount++) {
			objEventSetUp1.selectStatusType(strStatusTypeValues[intCount]);
		}

		objEventSetUp1
				.selMandatoryAddInCreateTemplatePage()
				.clickSaveButton()
				.deselectSelectAllWebOptionOnly()
				.clickOnEmailNotification(objUserdata.strNewUserName, true)
				.clickOnPagerNotification(objUserdata.strNewUserName, true)
				.clickOnWebNotification(objUserdata.strNewUserName, true)
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objEventManagement1
				.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verAddressFieldsAreMandatory()
				.enterAddress(objEventSetUp_data.strCity,
						objEventSetUp_data.strState,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strEventStartDateAndTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);
		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		strEventStartDateAndTime = objDts.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH mm", "MM/dd/yy HH mm");

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strEventName)
				.verWebNotificationframe()
				.verWebNotificationWithAddress(objEvent_data.strEventName,
						objEvent_data.strEventDescription,
						objEventSetUp_data.strCity,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode, objEventSetUp_data.strCountrycode)
				.clickAcknowledgeAllNotifications()
				.selectFrame()
				.clickOnEventNameInEventBanner(objEvent_data.strEventName)
				.verifyCreatedByDescAndAdd(objUserdata.strFullName,
						strEventStartDateAndTime,
						objEvent_data.strEventDescription,
						objEventSetUp_data.strCity,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode,objEventSetUp_data.strCountrycode);

		objLogin1.clickLogOut();

		System.out.println(objEvent_data.strEventName);
		
		String strMsgBody1 = "Event Notice for: " + objUserdata.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "Location: " + objEventSetUp_data.strCity + ", CA "
				+ objEventSetUp_data.strZipCode + " "
				+ objEventSetUp_data.strCountry + "\n\n" + "From: "
				+ objUserdata.strFullName + "\n\n" + "Regions: "
				+ objLogindata.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUserdata.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strEventDescription + "\nLocation: "
				+ objEventSetUp_data.strCity + ", CA "
				+ objEventSetUp_data.strZipCode + " "
				+ objEventSetUp_data.strCountry + "\nFrom: "
				+ objUserdata.strFullName + "\nRegions: "
				+ objLogindata.strRegionName;

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

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

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					"120965",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + ","
							+ objLogindata.strRegionName,
					objEvent_data.strEventName,
					objEventSetUp_data.strEventTemplate,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strNumberStatusType + ","
							+ objStatusTypes_data.strNDSTStatusTypeName + ", "
							+ objStatusTypes_data.strTSTStatusTypeName + ", "
							+ objStatusTypes_data.strMSTStatusTypeName + ", "
							+ objStatusTypes_data.strSSTStatusTypeName,
					"Verify mobile end condition", "",
					strEventStartDateAndTime, strEventEndTime };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "SmokeEvents");
		}
		gstrResult = "PASS";
	}

	/******************************************************************
	'Description : Verify that a future event can be created. 
	'Precondition:
	'Date : 01-Sep-2014 'Author : Sowmya
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test( description = "Verify that a future event can be created.")
	public void testSmoke96673() throws Exception {

		gstrTCID = "96673";
		gstrTO = "Verify that a future event can be created.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		String strstatusTypeValues[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		boolean blnTest = false;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

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

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
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

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objEventSetUp.navigateToEventSetUp();
		
		// create Event template
		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)
				.clickSaveButton();

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



		objLogin.clickLogOut();

		System.out.println("templet " + objESetUp_data.strEventTemplate);

		System.out.println(objUser_data.strNewUserName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		String strEventStartTime = objEventManagement1
				.getEventStartDateAndTime();

		objEvent_data.strEventStartTime = objDts.converDateFormat(
				strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		objEvent_data.strGetEventStartTime = objDts
				.AddTimeToExistingTimeHourAndMin(
						objEvent_data.strEventStartTime, 0, 2,
						"yyyy-MM-dd HH:mm");

		String strEventStartTimeTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm",
				"yyyy MMM dd HH mm");

		String strStartTime[] = strEventStartTimeTime.split(" ");

		objEventManagement1.selectEventStartDateAndTime(strStartTime);

		String strGetEventEndTime = objDts.AddTimeToExistingTimeHourAndMin(
				objEvent_data.strEventStartTime, 0, 10, "yyyy-MM-dd HH:mm");

		String strUpdatedEventEndTime = objDts.converDateFormat(
				strGetEventEndTime, "yyyy-MM-dd HH:mm", "yyyy MMM dd HH mm");

		String strEndTime[] = strUpdatedEventEndTime.split(" ");

		objEventManagement1.selectEventEndDateAndTime(strEndTime);

		objEventManagement1.clickOnSaveButton();

		objEventManagement1.verifyEventStartTimeNew(objEvent_data.strEventName,
				objEvent_data.strGetEventStartTime);

		objEventManagement1.verifyEventEndTime(objEvent_data.strEventName,
				strGetEventEndTime);

		objEventManagement1
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strFuture)
				.verifyEditEventLink(objEvent_data.strEventName)
				.verifyCancelEventLink(objEvent_data.strEventName)
				.verifyEventName(objEvent_data.strEventName);

		objEventManagement1.navigateToEventList()
				.verifyEventNameNotDisplayed(objEvent_data.strEventName);

		Thread.sleep(180000);

		objNavigationToSubMenus1.clickOnPreferences();

		objEventManagement1.verWebNotificationframe()
				.clickAcknowledgeAllNotifications().selectFrame();

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strEventName)
				.navigateToEventList()
				.verifyEventName(objEvent_data.strEventName)
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
				.verifyViewLinkIsDisplayed(objEvent_data.strEventName);

		Thread.sleep(480000);

		objNavigationToSubMenus1.clickOnPreferences();

		objEventManagement1.verWebNotificationframe()
				.clickAcknowledgeAllNotifications().selectFrame();

		objEventManagement1
				.verifyEventNameNotDisplayedInEventBanner(
						objEvent_data.strEventName)
				.navigateToEventList()
				.verifyEventName(objEvent_data.strEventName)
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strEnded)
				.verifyViewHistoryLink(objEvent_data.strEventName);

		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					"96673",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objTest_data.strPassword,
							objTest_data.strRegionName,
					objEvent_data.strEventName + ", "
							+ objEvent_data.strEventName1,
					objESetUp_data.strEventTemplate,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strNumberStatusType + ","
							+ objStatuTypes_data.strTSTStatusTypeName + ", "
							+ objStatuTypes_data.strMSTStatusTypeName + ", "
							+ objStatuTypes_data.strSSTStatusTypeName,
					"Verify mobile end condition",
					"",
					objEvent_data.strGetEventStartTime,
					strGetEventEndTime};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "SmokeEvents");
		}

		System.out.println(objEvent_data.strEventName);

		String strSubject = objEvent_data.strEventName;

		String strMsgBody1 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Information: "
				+ objEvent_data.strEventDescription + "\n\n" + "From: "
				+ objUser_data.strFullName + "\n\n" + "Regions: "
				+ objTest_data.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strEventDescription + "\nFrom: "
				+ objUser_data.strFullName + "\nRegions: "
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

	/***************************************************************************************
	'Description : Edit an event template and select ‘Mandatory Address’ check box and verify that city, 
	                state and county are required when a new event is created under it and is not required
	                 when already created event is edited.  
	'Precondition: 
	'Date : 03-Sep-2014 
	'Author : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***************************************************************************************/
	@Test(description = "Edit an event template and select ‘Mandatory Address’ check box and "
			+ "verify that city, state and county are required when a new event is created under "
			+ "it and is not required when already created event is edited.")
	public void testSmoke120982() throws Exception {

		gstrTCID = "120982";
		gstrTO = "Edit an event template and select ‘Mandatory Address’ check box and verify "
				+ "that city, state and county are required when a new event is created under it and "
				+ "is not required when already created event is edited.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		boolean blnTest = false;

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();
		
		System.out.println(objResource_data.strResourceName);
		
		System.out.println(objResourceType_data.strResourceTypeName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOptionOnly()
				.clickOnEmailNotification(objUserdata.strNewUserName, true)
				.clickOnPagerNotification(objUserdata.strNewUserName, true)
				.clickOnWebNotification(objUserdata.strNewUserName, true)
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objEventManagement1.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verAddressFieldsAreNotMandatory()
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strEventStartDateAndTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);
		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		strEventStartDateAndTime = objDts.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH mm", "MM/dd/yy HH mm");
		
		System.out.println(objEvent_data.strEventName);

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strEventName)
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications()
				.selectFrame()
				.clickOnEventNameInEventBanner(objEvent_data.strEventName)
				.verifyCreatedByDesc(objUserdata.strFullName,
						strEventStartDateAndTime,
						objEvent_data.strEventDescription);

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
				.selMandatoryAddInCreateTemplatePage().clickSaveButton();
		System.out.println(objEvent_data.strEventName2);
		objEventManagement1
				.navigateToEventManagementNew()
				.clickOnEditLink(objEvent_data.strEventName)
				.verAddressFieldsAreNotMandatory()
				.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName2)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verAddressFieldsAreMandatory()
				.enterAddress(objEventSetUp_data.strCity,
						objEventSetUp_data.strState,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName2);

		String strEventStartDateAndTime1 = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName2);
		String strEventEndTime1 = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName2);

		strEventStartDateAndTime1 = objDts
				.converDateFormat(strEventStartDateAndTime1,
						"yyyy-MM-dd HH mm", "MM/dd/yy HH mm");

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strEventName2)
				.verWebNotificationframe()
				.verWebNotificationWithAddress(objEvent_data.strEventName2,
						objEvent_data.strEventDescription,
						objEventSetUp_data.strCity,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode,objEventSetUp_data.strCountrycode)
				.clickAcknowledgeAllNotifications()
				.selectFrame()
				.clickOnEventNameInEventBanner(objEvent_data.strEventName2)
				.verifyCreatedByDescAndAdd(objUserdata.strFullName,
						strEventStartDateAndTime1,
						objEvent_data.strEventDescription,
						objEventSetUp_data.strCity,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode, objEventSetUp_data.strCountrycode);

		objLogin1.clickLogOut();

		String strMsgBody1 = "Event Notice for: " + objUserdata.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "Location: " + objEventSetUp_data.strCity + ", CA "
				+ objEventSetUp_data.strZipCode + " "
				+ objEventSetUp_data.strCountry + "\n\n" + "From: "
				+ objUserdata.strFullName + "\n\n" + "Regions: "
				+ objLogindata.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUserdata.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strEventDescription + "\nLocation: "
				+ objEventSetUp_data.strCity + ", CA "
				+ objEventSetUp_data.strZipCode + " "
				+ objEventSetUp_data.strCountry + "\nFrom: "
				+ objUserdata.strFullName + "\nRegions: "
				+ objLogindata.strRegionName;

		String strSubject = objEvent_data.strEventName2;
		
		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

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

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					"120982",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + ","
							+ objLogindata.strRegionName,
					objEvent_data.strEventName + ","
							+ objEvent_data.strEventName2,
					objEventSetUp_data.strEventTemplate,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strNumberStatusType + ","
							+ objStatusTypes_data.strNDSTStatusTypeName + ", "
							+ objStatusTypes_data.strTSTStatusTypeName + ", "
							+ objStatusTypes_data.strMSTStatusTypeName + ", "
							+ objStatusTypes_data.strSSTStatusTypeName,
					"Verify mobile end condition", "",
					strEventStartDateAndTime + "," + strEventStartDateAndTime1,
					strEventEndTime + "," + strEventEndTime1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "SmokeEvents");
		}
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that status types can be added to the running event. 
	'Precondition: 
	'Date : 1-Sep-2014 
	'Author : Sinchana
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that status types can be added to the running event.")
	public void testSmoke96715() throws Exception {

		gstrTCID = "96715";
		gstrTO = "Verify that status types can be added to the running event.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		String strstatusTypeValues[] = new String[5];
		String strEventStatusTypeValues[] = new String[5];
		String strPrivateStatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// Create RoleBased status types
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		// Create EventBased status types
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strNumberStatusType);

		strEventStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strEventStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strEventStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strEventStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strEventStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		// Create Private status type
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strPrivateStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName2);

		objStatusTypeList
				.createPrivateStatusType(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName2,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strPrivateStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strPrivateStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strPrivateStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strPrivateStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName2);

		// Resource type creation
		String[] strAllSTValues = { strstatusTypeValues[0],
				strstatusTypeValues[1], strstatusTypeValues[2],
				strstatusTypeValues[3], strstatusTypeValues[4],
				strEventStatusTypeValues[0], strEventStatusTypeValues[1],
				strEventStatusTypeValues[2], strEventStatusTypeValues[3],
				strEventStatusTypeValues[4], strPrivateStatusTypeValues[0],
				strPrivateStatusTypeValues[1], strPrivateStatusTypeValues[2],
				strPrivateStatusTypeValues[3], strPrivateStatusTypeValues[4] };

		String[] strAllStatusTypeNames = {
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strTSTStatusTypeName2,
				objStatusTypes_data.strSSTStatusTypeName2,
				objStatusTypes_data.strNDSTStatusTypeName2,
				objStatusTypes_data.strNSTStatusTypeName2 };

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strAllSTValues);

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

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		String[] strSTVal = { strstatusTypeValues[3], strstatusTypeValues[4],
				strEventStatusTypeValues[0], strEventStatusTypeValues[1],
				strPrivateStatusTypeValues[0], strPrivateStatusTypeValues[3] };

		String[] strNotselectedSTVal = { strstatusTypeValues[0],
				strstatusTypeValues[1], strstatusTypeValues[2],
				strEventStatusTypeValues[2], strEventStatusTypeValues[3],
				strEventStatusTypeValues[4], strPrivateStatusTypeValues[1],
				strPrivateStatusTypeValues[2], strPrivateStatusTypeValues[4] };

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strSTVal);

		System.out.println("Event Template: "
				+ objEventSetUp_data.strEventTemplate);

		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println("User Name: " + objUser_data.strNewUserName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.verifyEventManagementPage()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName)
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		System.out.println("Event Name: " + objEvent_data.strEventName);

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strEventName)
				.clickOnEventNameInEventBanner(	objEvent_data.strEventName);

		objEventStatus1
				.verResourceTypeAndResourceName(objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strNSTStatusTypeName2,
				objStatusTypes_data.strSSTStatusTypeName2 };

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objEventManagement1.navigateToEventManagement()
				.clickOnEditLink(objEvent_data.strEventName)
				.verifyStatusTypeIsSelectedAndChecked(strSTVal)
				.verifyStatusTypeIsDeSelectedAndChecked(strNotselectedSTVal)
				.clickOnSaveButton();

		objEventManagement1.verifyEventManagementPage();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description :  Verify that a multi region event can be created.
	'Precondition:
	'Date	 	 : 03-Sep-2014
	'Author		 : Sowmya
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that a multi region event can be created.")
	public void testSmoke96668() throws Exception {

		gstrTCID = "96668";
		gstrTO = " Verify that a multi region event can be created.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();
		View_data objView_data = new View_data();
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
		ViewsList objViewsList = new ViewsList(this.driver1);
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
		UsersList objUsersList1 = new UsersList(this.driver1);

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		boolean blnTest = false;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

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
		String[] strRegionNames = { objTest_data.strRegionName2,
				objTest_data.strRegionName };

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
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[0]).clickSaveButton();

		System.out.println("user1 " + objUser_data.strNewUserName);

		// Navigate to Region B

//		objRegionDefault.clickRegionLink();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName1);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues1[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		strstatusTypeValues1[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName1);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		strstatusTypeValues1[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName1);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName1);

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

		// User2 creation
		objUsersList
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.selectRoleCheckBox(strRoleValue1)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objUsersList1
				.navigateToUsers()
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

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				.createNewMultiEventButton().verifyCreateMultiRegionEventPage();

		objEventManagement1.enterAdHocEventName(
				objEvent_data.strMultiRegionEvent).enterAdHocEventDescription(
				objEvent_data.strMultiRegionEventDescription);

		String strEventStartTime = objEventManagement1
				.getEventStartDateAndTime();

		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		String strEventStartTime1 = objDts.converDateFormat(strEventStartTime,
				"yyyy-MM-dd HH:mm", "MM/dd/yyyy HH:mm");

		String strEventEndTime = objDts.addTimetoExistingHour(
				strEventStartTime, 4, "yyyy-MM-dd HH:mm");

		String strEventEndTime1 = 4 + " hours after event start";

		objEventManagement1
				.enterEventEndTime(objEvent_data.strEventEndTimeInHours1)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyEventTitleInMREC(objEvent_data.strMultiRegionEvent)
				.verifyEventInformationInMREC(
						objEvent_data.strMultiRegionEventDescription);

		String EventStartTime = objEventManagement1
				.verifyStartDateAndTimeInMREC(strEventStartTime1);

		objEventManagement1
				.verifyEndDateAndTimeInMREC(strEventEndTime1)
				.verifyAttachedFileOptionInMREC()
				.verifyDrillOptionInMREC()
				.verifyEndQuietlyOptionInMREC()
				.verifyRegionAndETName(objTest_data.strRegionName,
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(objTest_data.strRegionName2,
						objESetUp_data.strEventTemplate1).verifyYesButton()
				.verifyNoButton().clickOnYesButton();
		
        objEventManagement1.verWebNotificationframe()
                           .clickAcknowledgeAllNotifications()
                           .selectFrame();

		objEventManagement1
				.verifyEventName(objEvent_data.strMultiRegionEvent)
				.verifyEventInformation(objEvent_data.strMultiRegionEvent,
						objEvent_data.strMultiRegionEventDescription)
				.verifyDrill(objEvent_data.strMultiRegionEvent,
						objEvent_data.strNo)
				.verifyEventStartTimeNew(objEvent_data.strMultiRegionEvent,
						strEventStartTime);

		objEventManagement1.verifyEventEndTime(
				objEvent_data.strMultiRegionEvent, strEventEndTime);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName2);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				           .verifyEventManagementPage()
				           .verifyEventName(objEvent_data.strMultiRegionEvent);
 
		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					"96668",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objTest_data.strPassword,
					objTest_data.strRegionName + ", "
							+ objTest_data.strRegionName2,
					objEvent_data.strMultiRegionEvent,
					objESetUp_data.strEventTemplate + ", "
							+ objESetUp_data.strEventTemplate1,
					objResource_data.strResourceName + ", "
							+ objResource_data.strResourceName1,
					objResourceType_data.strResourceTypeName + ", "
							+ objResourceType_data.strResourceTypeName1,
					" ",
					"Verify mobile end condition",
					objView_data.strSectionName + ", "
							+ objView_data.strSectionName1, EventStartTime,
					strEventEndTime };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "SmokeEvents");
		}
		
		gstrResult = "PASS";
	}
	
	/********************************************************************************************************************
	'Description : Verify that user receives event end notification when an Ad Hoc event is ended.
	'Precondition: 
	'Date : 19-Aug-2014 
	'Author : Sinchana
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user receives event end notification when an Ad Hoc event is ended.")
    public void testSmoke142232() throws Exception {

        gstrTCID = "142232";
        gstrTO = "Verify that user receives event end notification when an Ad Hoc event is ended.";

        Login objLogin = new Login(this.driver1);
        Login_data objLoginData = new Login_data();
        UsersList objUsersList = new UsersList(this.driver1);
        RegionDefault objRegionDefault = new RegionDefault(this.driver1);
        SelectRegion objSelectRegion = new SelectRegion(this.driver1);
        User_data objUser_data = new User_data();
        EventSetUp objEventSetUp = new EventSetUp(this.driver1);
        EventSetUp_data objEventSetUp_data = new EventSetUp_data();
        Event_data objEvent_data = new Event_data();
        EventManagement objEventManagement = new EventManagement(this.driver1);
        NavigationToSubMenus objNavigationToSubMenus =new NavigationToSubMenus(this.driver1);

        Login objLogin1 = new Login(this.driver1);
        RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
        EventManagement objEventManagement1 = new EventManagement(this.driver1);

        objLogin.loginToApplication(objLoginData.strUserName, objLoginData.strPassword);

        objSelectRegion.selectRegionAndNavigate(objLoginData.strRegionName);
        objRegionDefault.selectFrame();

        objNavigationToSubMenus.navigateToUsers();

        //New User Creation
        objUsersList.clickCreateNewUserButton()
        .enterUserDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName)
        .selectSecRole()
        .clickAdvancedOptionAndExpand()
        .selectMaintainEventsOption()
        .selectMaintainAdHocEventsOption()
        .clickSaveButton();    
        
        System.out.println(objUser_data.strNewUserName);

        objEventSetUp.navigateToEventSetUp();
        objEventSetUp.navigateToEventNotificationPreferences(objEventSetUp_data.strAdHocEventTemplate)
        .deselectSelectAllEmailOption()
        .deselectSelectAllPagerOption()
        .deselectSelectAllResOption()
        .deselectSelectAllWebOption()
        .navigateToEventNotificationPreferences(objEventSetUp_data.strAdHocEventTemplate)
        .clickOnEmailNotification(objUser_data.strNewUserName, true)
        .clickOnPagerNotification(objUser_data.strFullName, true)
        .clickOnWebNotification(objUser_data.strFullName, true)
        .clickSaveButton();
        objLogin.clickLogOut();

        System.out.println("-----Precondition ends and test execution starts-------");

        objLogin1.loginAsNewUser(objUser_data.strNewUserName,objUser_data.strNewPassword);

        objRegionDefault1.selectFrame().verifyRegionDefaultPage();
        
        objEventManagement1.navigateToEventManagement()
        .clickOnCreateAdHocEventButton()
        .enterAdHocEventName(objEvent_data.strEventName)
        .enterAdHocEventDescription(objEvent_data.strEventDescription)
        .clickOnNextButton()
        .verifySelectResourcesDisplayed()
        .clickOnNextButton()
        .verifySelectStatusTypesDisplayed();
        
        System.out.println(objEvent_data.strEventName);

        objEventManagement1.clickOnNextButton()
        .verifyAdHocEventConfirmationDisplayed()
        .clickOnYesButton()
        .verifyEventName(objEvent_data.strEventName);


        objEventManagement1.verWebNotificationframe()
        .clickAcknowledgeAllNotifications()
        .selectFrame();

        objEventManagement1.navigateToEventManagement()
        .verifyEventManagementPage()
        .verifyEventName(objEvent_data.strEventName);

        objEventManagement1.clickOnEndEventVeifyText(objEvent_data.strEventName)
        .verWebNotificationframe()
        .clickAcknowledgeAllNotifications()
        .selectFrame()
        .verifyEventName(objEvent_data.strEventName)
        .verifyViewHistoryLink(objEvent_data.strEventName);        

        objLogin1.clickLogOut();
        gstrResult = "PASS";
    }

}