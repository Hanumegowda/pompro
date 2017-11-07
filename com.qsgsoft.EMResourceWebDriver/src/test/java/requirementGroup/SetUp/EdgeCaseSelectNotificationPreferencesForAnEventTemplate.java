package requirementGroup.SetUp;

import static org.testng.AssertJUnit.assertTrue;
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

public class EdgeCaseSelectNotificationPreferencesForAnEventTemplate  extends TestNG_UI_EXTENSIONS {

	public EdgeCaseSelectNotificationPreferencesForAnEventTemplate() throws Exception {
		super();
	}

	/*************************************************************************************
	'Description : Verify that notification is received via email when e-mail notification is selected for an event template
	'Precondition: 
	'Date        : 12-Dec-2014 
	'Author      : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that notification is received via email when e-mail notification is selected for an event template")
	public void testEdgeCase129535() throws Exception {

		gstrTCID = "129535";
		gstrTO = "Verify that notification is received via email when e-mail notification is selected for an event template";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		MyEventNotificationPreferences objMyEventNotificationPreferences_page1 = new MyEventNotificationPreferences(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Date_Time_settings dts = new Date_Time_settings();

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

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
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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

		objEventSetUp.navigateToEventSetUp();

		// create Event template
		objEventSetUp
				.createEventTemplate(objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption();

		System.out.println(objESetUp_data.strEventTemplate);
		// User1 creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId).selectFirstRole()
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectEditEventNotificationPreferencesOption()
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToEventNotificationInPreferences();

		objMyEventNotificationPreferences_page1
				.verifyAllNotificationForEventTemplate(
						objESetUp_data.strEventTemplate)
				.verEmailNotificationNotChecked(objESetUp_data.strEventTemplate)
				.verTextPagerNotChecked(objESetUp_data.strEventTemplate)
				.verWebNotificationNotChecked(objESetUp_data.strEventTemplate)
				.selectEmailNotification(objESetUp_data.strEventTemplate)
				.clickOnSaveButton();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEditLink(objEvent_data.strEventName)
				.enterAdHocEventName(objEvent_data.strEditedEventName)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEditedEventName)
				.verUpdateInEveBanner(
						"Update 1: " + objEvent_data.strEditedEventName + "");

		objEventManagement1.clickOnEndEvent(objEvent_data.strEditedEventName);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEditedEventName);
		
		strEventEndTime = dts.converDateFormat(strEventEndTime, "yyyy-MM-dd HH:mm", "MM/dd/yyyy HH:mm");
		
		objLogin1.clickLogOut();

		String strMsgBody1 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUser_data.strFullName + "\n\n"
				+ "Regions: " + objLogindata.strRegionName2
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = "Event Notice for: " + objUserdata.strFullName
				+ "\n" + "Information: "
				+ objEvent_data.strEventDescription + "\n\n" + "From: "
				+ objUserdata.strFullName + "\n\n" + "Regions: "
				+ objLogindata.strRegionName2
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUserdata.MailURL;

		String strMsgBody3 = "Event Notice for: "
				+ objUser_data.strFullName
				+ "\n"
				+ objEvent_data.strEditedEventName
				+ " ended at "
				+ strEventEndTime
				+ "\n\nFrom: "
				+ objUser_data.strFullName
				+ "\n"
				+ "Regions: "
				+ objLogindata.strRegionName2
				+ "\n\nPlease"
				+ " do not reply to this email message. You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;
		System.out.println(strMsgBody3);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		boolean blnMsg1 = false;

		String strSubject = objEvent_data.strEventName;
		String strSubject2 = "Update 1: " + objEvent_data.strEditedEventName
				+ "";
		String strSubject3 = "Ended: " + objEvent_data.strEditedEventName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		for (int intCount = 0; intCount < 1; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();

		}

		assertTrue(blnMsg1);

		boolean blnMsg2 = false;
		
		for (int intCount = 0; intCount < 1; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject2);

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg2);

		boolean blnMsg3 = false;
		
		for (int intCount = 0; intCount < 1; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject3);

			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg3);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that user who has subscribed for 'Pager' event notifications receives only the pager notifications 
	'Precondition: 
	'Date        : 15-Dec-2014 
	'Author      : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that user who has subscribed for 'Pager' event notifications receives only the pager notifications ")
	public void testEdgeCase129536() throws Exception {

		gstrTCID = "129536";
		gstrTO = "Verify that user who has subscribed for 'Pager' event notifications receives only the pager notifications ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		MyEventNotificationPreferences objMyEventNotificationPreferences_page1 = new MyEventNotificationPreferences(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Date_Time_settings dts = new Date_Time_settings();

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

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
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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

		objEventSetUp.navigateToEventSetUp();

		// create Event template
		objEventSetUp
				.createEventTemplate(objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption();

		System.out.println(objESetUp_data.strEventTemplate);
		// User1 creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId).selectFirstRole()
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectEditEventNotificationPreferencesOption()
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToEventNotificationInPreferences();

		objMyEventNotificationPreferences_page1
				.verifyAllNotificationForEventTemplate(
						objESetUp_data.strEventTemplate)
				.verEmailNotificationNotChecked(objESetUp_data.strEventTemplate)
				.verTextPagerNotChecked(objESetUp_data.strEventTemplate)
				.verWebNotificationNotChecked(objESetUp_data.strEventTemplate)
				.selectTextPagerIndNotification(objESetUp_data.strEventTemplate)
				.clickOnSaveButton();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEditLink(objEvent_data.strEventName)
				.enterAdHocEventName(objEvent_data.strEditedEventName)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEditedEventName)
				.verUpdateInEveBanner(
						"Update 1: " + objEvent_data.strEditedEventName + "");

		objEventManagement1.clickOnEndEvent(objEvent_data.strEditedEventName);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEditedEventName);
		
		strEventEndTime = dts.converDateFormat(strEventEndTime, "yyyy-MM-dd HH:mm", "MM/dd/yyyy HH:mm");
		
		objLogin1.clickLogOut();

		String strMsgBody1 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUser_data.strFullName + "\n\n"
				+ "Regions: " + objLogindata.strRegionName2
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = "Event Notice for: " + objUserdata.strFullName
				+ "\n" + "Information: "
				+ objEvent_data.strEventDescription + "\n\n" + "From: "
				+ objUserdata.strFullName + "\n\n" + "Regions: "
				+ objLogindata.strRegionName2
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUserdata.MailURL;

		String strMsgBody3 = "Event Notice for: "
				+ objUser_data.strFullName
				+ "\n"
				+ objEvent_data.strEditedEventName
				+ " ended at "
				+ strEventEndTime
				+ "\n\nFrom: "
				+ objUser_data.strFullName
				+ "\n"
				+ "Regions: "
				+ objLogindata.strRegionName2
				+ "\n\nPlease"
				+ " do not reply to this email message. You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;
		System.out.println(strMsgBody3);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		boolean blnMsg1 = false;

		String strSubject = objEvent_data.strEventName;
		String strSubject2 = "Update 1: " + objEvent_data.strEditedEventName
				+ "";
		String strSubject3 = "Ended: " + objEvent_data.strEditedEventName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		for (int intCount = 0; intCount < 1; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();

		}

		assertTrue(blnMsg1);

		boolean blnMsg2 = false;
		
		for (int intCount = 0; intCount < 1; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject2);

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg2);

		boolean blnMsg3 = false;
		
		for (int intCount = 0; intCount < 1; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject3);

			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg3);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that event notification preferences can be set only for an active event template.
	'Precondition: 
	'Date        : 29-Apr-2015 
	'Author      : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that event notification preferences can be set only for an active event template.")
	public void testEdgeCase129532() throws Exception {

		gstrTCID = "129532";
		gstrTO = "Verify that event notification preferences can be set only for an active event template.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		MyEventNotificationPreferences objMyEventNotificationPreferences_page = new MyEventNotificationPreferences(
				this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		MyEventNotificationPreferences objMyEventNotificationPreferences_page1 = new MyEventNotificationPreferences(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Date_Time_settings dts = new Date_Time_settings();

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

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
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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

		objEventSetUp.navigateToEventSetUp();

		// create Event template
		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		System.out.println(objESetUp_data.strEventTemplate);

		// create Event template
		objEventSetUp.createInactiveEventTemplate(
				objESetUp_data.strEventTemplate1,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		System.out.println(objESetUp_data.strEventTemplate1);

		// User1 creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectEditEventNotificationPreferencesOption()
				.clickSaveButton();

		objUsersList
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickOnEveNotPreferences()
				.verEventNotificationPreferencesPageisDisplayed(
						objUser_data.strNewUserName)
				.verEveTemplateListed(objESetUp_data.strEventTemplate)
				.verEveTemplateNotListed(objESetUp_data.strEventTemplate1);

		objMyEventNotificationPreferences_page
				.selectEmailNotification(objESetUp_data.strEventTemplate)
				.selectTextPagerIndNotification(objESetUp_data.strEventTemplate)
				.selectWebIndNotification(objESetUp_data.strEventTemplate)
				.clickOnSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToEventNotificationInPreferences();

		objMyEventNotificationPreferences_page1
				.verEveTemplateIsDisplayed(objESetUp_data.strEventTemplate)
				.verEveTemplateNotDisplayed(objESetUp_data.strEventTemplate1)
				.verTextPagerChecked(objESetUp_data.strEventTemplate)
				.verWebNotificationChecked(objESetUp_data.strEventTemplate)
				.verEmailNotificationChecked(objESetUp_data.strEventTemplate);

		objEventManagement1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame()
				.verifyEventName(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEditLink(objEvent_data.strEventName)
				.enterAdHocEventName(objEvent_data.strEditedEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEditedEventDescription)
				.clickOnSaveButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(
						"Update 1: " + objEvent_data.strEditedEventName + "",
						objEvent_data.strEditedEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame()
				.verifyEventName(objEvent_data.strEditedEventName)
				.verUpdateInEveBanner(
						"Update 1: " + objEvent_data.strEditedEventName + "");


		objEventManagement1.clickOnEndEvent(objEvent_data.strEditedEventName);

		objEventManagement1
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(
						"Ended: " + objEvent_data.strEditedEventName,
						objEvent_data.strEventEndDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEditedEventName);

		strEventEndTime = dts.converDateFormat(strEventEndTime,
				"yyyy-MM-dd HH:mm", "MM/dd/yyyy HH:mm");

		objLogin1.clickLogOut();

		String strMsgBody1 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUser_data.strFullName + "\n\n"
				+ "Regions: " + objLogindata.strRegionName2
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = "Event Notice for: " + objUserdata.strFullName
				+ "\n" + "Information: " + objEvent_data.strEditedEventDescription
				+ "\n\n" + "From: " + objUserdata.strFullName + "\n\n"
				+ "Regions: " + objLogindata.strRegionName2
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUserdata.MailURL;

		String strMsgBody3 = "Event Notice for: "
				+ objUser_data.strFullName
				+ "\n"
				+ objEvent_data.strEditedEventName
				+ " ended at "
				+ strEventEndTime
				+ "\n\nFrom: "
				+ objUser_data.strFullName
				+ "\n"
				+ "Regions: "
				+ objLogindata.strRegionName2
				+ "\n\nPlease"
				+ " do not reply to this email message. You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody4 = "Information: "
				+ objEvent_data.strEventDescription + "\nFrom: "
				+ objUserdata.strFullName + "\nRegions: "
				+ objLogindata.strRegionName2;

		String strMsgBody5 = "Information: "
				+ objEvent_data.strEditedEventDescription + "\nFrom: "
				+ objUserdata.strFullName + "\nRegions: "
				+ objLogindata.strRegionName2;

		String strMsgBody6 = objEvent_data.strEditedEventName + " ended at "
				+ strEventEndTime + "\nFrom: " + objUser_data.strFullName
				+ "\n" + "Regions: " + objLogindata.strRegionName2;

		System.out.println(strMsgBody3);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		String strSubject = objEvent_data.strEventName;
		String strSubject2 = "Update 1: " + objEvent_data.strEditedEventName
				+ "";
		String strSubject3 = "Ended: " + objEvent_data.strEditedEventName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}

			objMailVerificationFunctions.backToMailInbox();

		}

		assertTrue(blnMsg1 && blnMsg2);

		blnMsg1 = false;
		blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject2);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody5);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2);

		blnMsg1 = false;
		blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject3);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody6);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/***********************************************************************************
	'Description	: Verify that user who has subscribed for 'web' event notifications receives only the web notifications
	'Date	 		: 29-Apr-2015
	'Author			: Pallavi
	************************************************************************************/
	
	@Test(description = "Verify that user who has subscribed for 'web' event notifications receives only the web notifications")
	public void testEdgeCase129537() throws Exception {

		gstrTCID = "129537";
		gstrTO = "Verify that user who has subscribed for 'web' event notifications receives only the web notifications";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);

		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Login login_page1 = new Login(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		MyEventNotificationPreferences objMyEventNotificationPreferences_page1 = new MyEventNotificationPreferences(
				this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

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
				.clickOnSaveButton()
				.clickOnViewResChkBox()
				.clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page.navigateToUsersNew()
					  .clickCreateNewUserButton()
					  .enterUserDetails(objUser_data.strNewUserName,
							  objUser_data.strNewPassword, objUser_data.strFullName)
					  .clickAdvancedOptionAndExpand()
					  .selectMaintainEventTemplateOption()
					  .selectMaintainEventsOption()
					  .selectEditEventNotificationPreferencesOption()
					  .clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		login_page.clickLogOut();
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
							  objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame()
						   .verifyRegionDefaultPage();
		
		objNavigationToSubmenus1.navigateToEventNotificationInPreferences();
		
		objMyEventNotificationPreferences_page1
							.verifyMyEventNotificationPrefPageIsDisp()
							.verifyAllNotificationForEventTemplate(
									objEventSetUp_data.strEventTemplate)
							.verEmailNotificationNotChecked(objEventSetUp_data.strEventTemplate)
							.verTextPagerNotChecked(objEventSetUp_data.strEventTemplate)
							.verWebNotificationNotChecked(objEventSetUp_data.strEventTemplate)
							.selectWebIndNotification(objEventSetUp_data.strEventTemplate)
							.clickOnSaveButton()
							.verifytWebNotificationIsSelected(objEventSetUp_data.strEventTemplate);

		EventManagement_page1.navigateToEventManagement()
						   	 .clickOnCreateNewEvent()
						   	 .clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
						   	 .enterAdHocEventName(objEvent_data.strEventName)
						   	 .enterAdHocEventDescription(objEvent_data.strEventDescription)
						   	 .selectResource(strResourceValue)
						   	 .clickOnSaveButton()
						   	 .verifyEventName(objEvent_data.strEventName);
		
		EventManagement_page1.verWebNotificationframe()
							 .verWebNotificationAndAcknowledge(objEvent_data.strEventName,
									objEvent_data.strEventDescription)
							 .clickAcknowledgeAllNotifications();
		
		RegionDefault_page1.switchToDefaultFrame().selectFrame();
		
		EventManagement_page1.clickOnEditLink(objEvent_data.strEventName)
							 .enterAdHocEventName(objEvent_data.strEditedEventName)
						   	 .enterAdHocEventDescription(objEvent_data.strEditedEventDescription)
						   	 .clickOnSaveButton()
						   	.verifyEventName(objEvent_data.strEditedEventName);

		EventManagement_page1.verWebNotificationframe()
							 .verWebNotificationAndAcknowledge("Update 1: " + objEvent_data.strEditedEventName,
									objEvent_data.strEditedEventDescription)
							 .clickAcknowledgeAllNotifications();
		
		RegionDefault_page1.switchToDefaultFrame().selectFrame();
		
		EventManagement_page1.clickOnEndEvent(objEvent_data.strEditedEventName)
							 .verWebNotificationframe()
							 .verWebNotificationAndAcknowledge(
										"Ended: " + objEvent_data.strEditedEventName,
										objEvent_data.strEventEndDescription)
							 .clickAcknowledgeAllNotifications();
		
		RegionDefault_page1.switchToDefaultFrame().selectFrame();
		
		login_page1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
