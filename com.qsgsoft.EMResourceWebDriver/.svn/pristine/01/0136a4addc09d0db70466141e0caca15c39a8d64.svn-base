package requirementGroup.PreferencesEventNotificationsPreferences;

import static org.testng.Assert.assertTrue;
import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.MyEventNotificationPreferences;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewSelectnotificationPreferencesForAnEventTemplate extends TestNG_UI_EXTENSIONS{

	public NewSelectnotificationPreferencesForAnEventTemplate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***************************************************************************************************
	'Description : Verify that user can set 'Event Notification' preferences.
	'Date	 	 : 23-June-2015
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = "Verify that user can set 'Event Notification' preferences.")
	public void testHappyDay118372() throws Exception {

		gstrTCID = "118372";
		gstrTO = "Verify that user can set 'Event Notification' preferences.";

		Login_data objLogindata = new Login_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		User_data objUserdata = new User_data();
		Event_data objEvent_data = new Event_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings dts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagementPage1 = new EventManagement(
				this.driver1);
		MyEventNotificationPreferences objMyEventNotificationPreferences_page1 = new MyEventNotificationPreferences(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectStatusType(strStatusTypeValues[0])
				.selectResourceType(strResourceTypeValue[0]).clickSaveButton()
				.deselectSelectAllWebOption();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectEditEventNotificationPreferencesOption()
				.selectMaintainEventsOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objEventManagementPage1.selectFrame();

		objNavigationToSubmenus1.navigateToEventNotificationInPreferences();

		objMyEventNotificationPreferences_page1
				.verifyMyEventNotificationPrefPageIsDisp()
				.verEmailNotificationNotChecked(
						objEventSetUp_data.strEventTemplate)
				.verTextPagerNotChecked(objEventSetUp_data.strEventTemplate)
				.verWebNotificationNotChecked(
						objEventSetUp_data.strEventTemplate)
				.selectWebIndNotification(objEventSetUp_data.strEventTemplate)
				.selectTextPagerIndNotification(
						objEventSetUp_data.strEventTemplate)
				.selectEmailNotification(objEventSetUp_data.strEventTemplate)
				.clickOnSaveButton()
				.verEmailNotificationChecked(
						objEventSetUp_data.strEventTemplate)
				.verTextPagerChecked(objEventSetUp_data.strEventTemplate)
				.verWebNotificationChecked(objEventSetUp_data.strEventTemplate);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strEquals)
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnEveNotPreferences()
				.verEventNotificationPreferencesPageisDisplayed(
						objUserdata.strNewUserName)
				.verEveTemplateListed(objEventSetUp_data.strEventTemplate);

		objMyEventNotificationPreferences_page1
				.verifytWebNotificationIsSelected(
						objEventSetUp_data.strEventTemplate)
				.verEmailNotificationChecked(
						objEventSetUp_data.strEventTemplate)
				.verTextPagerChecked(objEventSetUp_data.strEventTemplate);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1
				.selectFrame();

		objEventManagementPage1
				.navigateToEventManagement()
				.verifyCreateEventButtonDisplayed()
				.clickOnCreateNewEvent()
				.verifySelectEventTemplatePage()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		
		objEventManagementPage1.verWebNotificationframe()
		.verWebNotificationAndAcknowledge(
				objEvent_data.strEventName,
				objEvent_data.strEventDescription)
		.clickAcknowledgeAllNotifications().selectFrame();

		objEventManagementPage1
				.clickOnEditLink(objEvent_data.strEventName)
				.enterAdHocEventName(objEvent_data.strEditedEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEditedEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEditedEventName);

		objEventManagementPage1.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(
						"Update 1: " + objEvent_data.strEditedEventName + "",
						objEvent_data.strEditedEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		objEventManagementPage1.verUpdateInEveBanner("Update 1: "
				+ objEvent_data.strEditedEventName + "");

		objEventManagementPage1
				.navigateToEventManagement()
				.clickOnEndEvent(objEvent_data.strEditedEventName)
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(
						"Ended: " + objEvent_data.strEditedEventName,
						objEvent_data.strEventEndDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		String strEventEndTime = objEventManagementPage1
				.getEventEndTime(objEvent_data.strEditedEventName);

		strEventEndTime = dts.converDateFormat(strEventEndTime,
				"yyyy-MM-dd HH:mm", "MM/dd/yyyy HH:mm");

		objEventManagementPage1.verEveNotPresentInEveBanner("Update 1: "
				+ objEvent_data.strEditedEventName + "");

		objLogin1.clickLogOut();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;

		String strMsgBody1 = "Event Notice for: " + objUserdata.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUserdata.strFullName + "\n\n"
				+ "Regions: " + objLogindata.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUserdata.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strEventDescription + "\nFrom: "
				+ objUserdata.strFullName + "\nRegions: "
				+ objLogindata.strRegionName;

		System.out.println(strMsgBody1);
		System.out.println(strMsgBody2);

		String strSubject1 = "Update 1: " + objEvent_data.strEditedEventName
				+ "";

		String strMsgBody3 = "Event Notice for: " + objUserdata.strFullName
				+ "\n" + "Information: "
				+ objEvent_data.strEditedEventDescription + "\n\n" + "From: "
				+ objUserdata.strFullName + "\n\n" + "Regions: "
				+ objLogindata.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUserdata.MailURL;

		String strMsgBody4 = "Information: "
				+ objEvent_data.strEditedEventDescription + "\nFrom: "
				+ objUserdata.strFullName + "\nRegions: "
				+ objLogindata.strRegionName;

		String strSubject2 = "Ended: " + objEvent_data.strEditedEventName;

		String strMsgBody5 = "Event Notice for: "
				+ objUserdata.strFullName
				+ "\n"
				+ objEvent_data.strEditedEventName
				+ " ended at "
				+ strEventEndTime
				+ "\n\nFrom: "
				+ objUserdata.strFullName
				+ "\n"
				+ "Regions: "
				+ objLogindata.strRegionName
				+ "\n\nPlease"
				+ " do not reply to this email message. You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUserdata.MailURL;

		String strMsgBody6 = objEvent_data.strEditedEventName + " ended at "
				+ strEventEndTime + "\nFrom: " + objUserdata.strFullName + "\n"
				+ "Regions: " + objLogindata.strRegionName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;
		boolean boolCheck1 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(boolCheck && boolCheck1);

		boolCheck = false;
		boolCheck1 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject1);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}

			if (boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck && boolCheck1);

		boolCheck = false;
		boolCheck1 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject2);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody5);
			}

			if (boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody6);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck && boolCheck1);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************
	'Description : Verify that user can edit the event notification preferences. 	
	'Date	 	 : 23-June-2015
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = "Verify that user can edit the event notification preferences. 	")
	public void testHappyDay118373() throws Exception {

		gstrTCID = "118373";
		gstrTO = "Verify that user can edit the event notification preferences. 	";

		Login_data objLogindata = new Login_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		User_data objUserdata = new User_data();
		Event_data objEvent_data = new Event_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings dts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagementPage1 = new EventManagement(
				this.driver1);
		MyEventNotificationPreferences objMyEventNotificationPreferences_page1 = new MyEventNotificationPreferences(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectEditEventNotificationPreferencesOption()
				.selectMaintainEventsOption().clickSaveButton();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectStatusType(strStatusTypeValues[0])
				.selectResourceType(strResourceTypeValue[0])
				.clickSaveButton()
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

		objEventManagementPage1.selectFrame();

		objNavigationToSubmenus1.navigateToEventNotificationInPreferences();

		objMyEventNotificationPreferences_page1
				.verifyMyEventNotificationPrefPageIsDisp()
				.verEmailNotificationChecked(
						objEventSetUp_data.strEventTemplate)
				.verTextPagerChecked(objEventSetUp_data.strEventTemplate)
				.verWebNotificationChecked(objEventSetUp_data.strEventTemplate)
				.deselectPagerForEveTemplate(
						objEventSetUp_data.strEventTemplate)
				.clickOnSaveButton()
				.verTextPagerNotChecked(objEventSetUp_data.strEventTemplate)
				.verEmailNotificationChecked(
						objEventSetUp_data.strEventTemplate)
				.verWebNotificationChecked(objEventSetUp_data.strEventTemplate);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strEquals)
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnEveNotPreferences()
				.verEventNotificationPreferencesPageisDisplayed(
						objUserdata.strNewUserName)
				.verEveTemplateListed(objEventSetUp_data.strEventTemplate);

		objMyEventNotificationPreferences_page1
				.verifytWebNotificationIsSelected(
						objEventSetUp_data.strEventTemplate)
				.verEmailNotificationChecked(
						objEventSetUp_data.strEventTemplate)
				.verTextPagerNotChecked(objEventSetUp_data.strEventTemplate);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1
				.selectFrame();		

		objEventManagementPage1
				.navigateToEventManagement()
				.verifyCreateEventButtonDisplayed()
				.clickOnCreateNewEvent()
				.verifySelectEventTemplatePage()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		
		objEventManagementPage1.verWebNotificationframe()
		.verWebNotificationAndAcknowledge(
				objEvent_data.strEventName,
				objEvent_data.strEventDescription)
		.clickAcknowledgeAllNotifications().selectFrame();

		objEventManagementPage1
				.clickOnEditLink(objEvent_data.strEventName)
				.enterAdHocEventName(objEvent_data.strEditedEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEditedEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEditedEventName);
	
		objEventManagementPage1
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(
						"Update 1: " + objEvent_data.strEditedEventName + "",
						objEvent_data.strEditedEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		objEventManagementPage1.verUpdateInEveBanner("Update 1: "
				+ objEvent_data.strEditedEventName + "");

		objEventManagementPage1
				.navigateToEventManagement()
				.clickOnEndEvent(objEvent_data.strEditedEventName)
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(
						"Ended: " + objEvent_data.strEditedEventName,
						objEvent_data.strEventEndDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		String strEventEndTime = objEventManagementPage1
				.getEventEndTime(objEvent_data.strEditedEventName);

		strEventEndTime = dts.converDateFormat(strEventEndTime,
				"yyyy-MM-dd HH:mm", "MM/dd/yyyy HH:mm");

		objEventManagementPage1.verEveNotPresentInEveBanner("Update 1: "
				+ objEvent_data.strEditedEventName + "");

		objLogin1.clickLogOut();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;

		String strMsgBody1 = "Event Notice for: " + objUserdata.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUserdata.strFullName + "\n\n"
				+ "Regions: " + objLogindata.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUserdata.MailURL;

		System.out.println(strMsgBody1);

		String strSubject1 = "Update 1: " + objEvent_data.strEditedEventName
				+ "";

		String strMsgBody3 = "Event Notice for: " + objUserdata.strFullName
				+ "\n" + "Information: "
				+ objEvent_data.strEditedEventDescription + "\n\n" + "From: "
				+ objUserdata.strFullName + "\n\n" + "Regions: "
				+ objLogindata.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUserdata.MailURL;

		String strSubject2 = "Ended: " + objEvent_data.strEditedEventName;

		String strMsgBody5 = "Event Notice for: "
				+ objUserdata.strFullName
				+ "\n"
				+ objEvent_data.strEditedEventName
				+ " ended at "
				+ strEventEndTime
				+ "\n\nFrom: "
				+ objUserdata.strFullName
				+ "\n"
				+ "Regions: "
				+ objLogindata.strRegionName
				+ "\n\nPlease"
				+ " do not reply to this email message. You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUserdata.MailURL;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;

		for (int intCount = 0; intCount < 1; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(boolCheck);

		boolCheck = false;

		for (int intCount = 0; intCount < 1; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject1);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck);
		
		boolCheck = false;

		for (int intCount = 0; intCount < 1; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject2);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody5);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck);

		objMailVerificationFunctions
		.NavToInboxAndVerEmailIsNotPresentNew(strSubject);
		
		objMailVerificationFunctions
		.NavToInboxAndVerEmailIsNotPresentNew(strSubject1);
		
		objMailVerificationFunctions
				.NavToInboxAndVerEmailIsNotPresentNew(strSubject2);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
}
