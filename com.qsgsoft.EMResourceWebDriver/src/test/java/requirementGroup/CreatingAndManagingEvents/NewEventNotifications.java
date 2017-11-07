package requirementGroup.CreatingAndManagingEvents;

import static org.testng.AssertJUnit.assertTrue;

import java.util.Arrays;

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
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEventNotifications extends TestNG_UI_EXTENSIONS{

	public NewEventNotifications() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/***********************************************************************************************************
	'Description : Verify that users can be selected to receive E-mail, Pager and Web notifications for an event 
	               template in 'Event Notification Preferences for "event template name"' screen.
	'Date        : 20-Aug-2014 
	'Author      : Sowmya
	'-----------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                               Modified By
	'Date					                                                           Name
	************************************************************************************************************/
	@Test(description = "Verify that users can be selected to receive E-mail, Pager and Web notifications for an event "
			+ "template in 'Event Notification Preferences for event template name' screen.")
	public void testHappyDay118229() throws Exception {

		gstrTCID = "118229";
		gstrTO = "Verify that users can be selected to receive E-mail, Pager and Web notifications for an event template"
				+ " in 'Event Notification Preferences for event template name' screen.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.clickSaveButton().deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption().deselectSelectAllWebOption();
		
		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate1)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.clickSaveButton().deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption().deselectSelectAllWebOption();
		
		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		// create Event template
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.navigateToEventNotificationPreferences(
				objEventSetUp_data.strEventTemplate)
				.clickOnEmailCheckBox(objUser_data.strNewUserName)
				.clickOnPagerCheckBox(objUser_data.strNewUserName)
				.clickOnWebCheckBox(objUser_data.strNewUserName)
				.clickSaveButton()
				.verEveTemplateListScreenIsDisplayed();
		
		objEventManagement1.navigateToEventManagementNew()
				.clickOnCreateNewEvent().verifySelectEventTemplatePage()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objEventManagement1
				.verWebNotificationframe()

				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)

				.clickAcknowledgeAllNotifications();

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

		Thread.sleep(20000);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		String strSubject = objEvent_data.strEventName;

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
						.verifyMailBody(strMsgBody2);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		
		Thread.sleep(20000);

		objLogin1.loginToApplication(objUser_data.strNewUserName,
							objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate1)
				.enterAdHocEventName(objEvent_data.strEventName1)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName1);

		objRegionDefault1.verWebNotificationframeIsNotPresent();
				
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);
	
		String strSubject1 = objEvent_data.strEventName1;
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubject1);
		
		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that user who is NOT logged into the application, is taken to the 'Login' page when 
	 * 						clicked on the URL available on the notifications received for a single event
	 * 'Precondition	: 
	 * 'Date 			: 25-Nov-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that user who is NOT logged into the application, is taken to the 'Login' page when "
			+ "clicked on the URL available on the notifications received for a single event")
	public void testHappyDay134598() throws Exception {

		gstrTCID = "134598";
		gstrTO = "Verify that user who is NOT logged into the application, is taken to the 'Login' page when "
				+ "clicked on the URL available on the notifications received for a single event";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
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
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
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

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate)
				.clickOnEmailNotification(objUserdata.strNewUserName, true)
				.clickOnPagerNotification(objUserdata.strNewUserName, true)
				.clickOnWebNotification(objUserdata.strNewUserName, true)
				.clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().creatEvent(
				objESetUp_data.strEventTemplate, objEvent_data.strEventName,
				objEvent_data.strEventDescription, strResourceValue[0]);

		objEventManagement1
				.verifyEventName(objEvent_data.strEventName)
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications();

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		String strSubject = objEvent_data.strEventName;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(
				objUserdata.strFullName, objUserdata.strFullName,
				objLogindata.strRegionName, objEvent_data.strEventDescription);

		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objEvent_data.strEventDescription);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

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

		objLogin1.verLoginButton().verifyUserName().verPasswordField();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that user who is logged into the application, is taken to 'Event status' page when clicked on the 
	 * 						URL available on the notifications received for a single event 
	 * 'Precondition	: 
	 * 'Date 			: 26-Nov-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that user who is logged into the application, is taken to 'Event status' "
			+ "page when clicked on the URL available on the notifications received for a single event ")
	public void testHappyDay134597() throws Exception {

		gstrTCID = "134597";
		gstrTO = "Verify that user who is logged into the application, is taken to 'Event status' "
				+ "page when clicked on the URL available on the notifications received for a single event ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
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
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
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

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		String strAllStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName};

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().creatEvent(
				objESetUp_data.strEventTemplate, objEvent_data.strEventName,
				objEvent_data.strEventDescription, strResourceValue[0]);

		objEventManagement1
				.verifyEventName(objEvent_data.strEventName)
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications();

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		String strSubject = objEvent_data.strEventName;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(
				objUser_data.strFullName, objUser_data.strFullName,
				objLogindata.strRegionName, objEvent_data.strEventDescription);

		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(
				objUser_data.strFullName, objLogindata.strRegionName,
				objEvent_data.strEventDescription);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

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

		objRegionDefault1.selectFrame();

		objEventStatus1.verifyEventStatus();

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	:  Verify that users with multiple access to regions subscribed to receive 
	 * 						notifications for a single event template receives one notification via email, web and pager 
	 * 'Precondition	: 
	 * 'Date 			: 30-Nov-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = " Verify that users with multiple access to regions subscribed to receive "
			+ "notifications for a single event template receives one notification via email, web and pager")
	public void testHappyDay134991() throws Exception {

		gstrTCID = "134991";
		gstrTO = " Verify that users with multiple access to regions subscribed to receive "
				+ "notifications for a single event template receives one notification via email, web and pager";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strStatusTypeValues1[] = new String[6];
		String strStatusTypeValues2[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValue1[] = new String[1];
		String strResourceTypeValue2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strResourceValue2[] = new String[1];
		String strRegionValue[] = new String[3];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		String[] strAllRegions = { objLogindata.strRegionName,
				objLogindata.strRegionName1, objLogindata.strRegionName2 };
		Arrays.sort(strAllRegions);

		objSelectRegionpage.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page.getRegionValue(strAllRegions[0]);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page.getRegionValue(strAllRegions[1]);

		System.out.println(strRegionValue[1]);

		strRegionValue[2] = objRegions_page.getRegionValue(strAllRegions[2]);

		System.out.println(strRegionValue[2]);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
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

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[0])
				.selectRegion(strRegionValue[1])
				.selectRegion(strRegionValue[2]).clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate);

		objSelectRegionpage.clickRegionLink().selectRegionAndNavigate(
				strAllRegions[1]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
					objStatusTypes_data.strStatusColor)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti3)
        .clickOnReturnToStatusTypeList();

		strStatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strStatusTypeValues1);

		strResourceTypeValue1[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate1,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue1,
				strStatusTypeValues1).deselectSelectAllWebOption();

		System.out.println(objESetUp_data.strEventTemplate1);

		objSelectRegionpage.clickRegionLink().selectRegionAndNavigate(
				strAllRegions[2]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName2);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName2,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti4,
					objStatusTypes_data.strStatusColor)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti5,	objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti4)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti5)
        .clickOnReturnToStatusTypeList();

		strStatusTypeValues2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName2);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName2);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName2);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName2);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType
				.createResourceType(objResourceType_data.strResourceTypeName2,
						strStatusTypeValues2);

		strResourceTypeValue2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName2);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName2)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName2)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue2[0] = objResource
				.getResourceValue(objResource_data.strResourceName2);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton().editUserDetails(objUserdata.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.verifyRegionName(strRegionValue[2])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.selectUserRegion(strRegionValue[2]).clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate2,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue2,
				strStatusTypeValues2).deselectSelectAllWebOption();

		System.out.println(objESetUp_data.strEventTemplate2);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.verifyCreateMultiRegionEventPage()
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1)
				.selectEventTemplateForMRE(strRegionValue[2],
						objESetUp_data.strEventTemplate2)
				.clickOnNextButton()
				.verifyRegionAndETName(strAllRegions[0],
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(strAllRegions[1],
						objESetUp_data.strEventTemplate1)
				.verifyRegionAndETName(strAllRegions[2],
						objESetUp_data.strEventTemplate2).clickOnYesButton();

		objEventManagement1
				.verifyEventName(objEvent_data.strMultiRegionEvent)
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(
						objEvent_data.strMultiRegionEvent,
						objEvent_data.strMultiRegionEventDescription)
				.clickAcknowledgeAllNotifications();

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objRegionDefault1.verWebNotificationframeIsNotPresent();

		objLogin1.clickLogOut();

		String strSubject = objEvent_data.strMultiRegionEvent;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(
				objUser_data.strFullName, objUser_data.strFullName,
				strAllRegions[0] + " ," + strAllRegions[1] + " ,"
						+ strAllRegions[2],
				objEvent_data.strMultiRegionEventDescription);

		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(
				objUser_data.strFullName, strAllRegions[0] + " ,"
						+ strAllRegions[1] + " ," + strAllRegions[2],
				objEvent_data.strMultiRegionEventDescription);

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

		objMailVerificationFunctions
				.NavToInboxAndVerEmailIsNotPresentNew(strSubject);
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that users with multiple access to regions subscribed to receive notifications 
	 * 						for more than one event template receives one notification via email, web and pager
	 * 'Precondition	: 
	 * 'Date 			: 03-Dec-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that users with multiple access to regions subscribed to receive notifications "
			+ "				for more than one event template receives one notification via email, web and pager")
	public void testHappyDay134992() throws Exception {

		gstrTCID = "134992";
		gstrTO = "Verify that users with multiple access to regions subscribed to receive notifications for more "
				+ "than one event template receives one notification via email, web and pager";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strStatusTypeValues1[] = new String[6];
		String strStatusTypeValues2[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValue1[] = new String[1];
		String strResourceTypeValue2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strResourceValue2[] = new String[1];
		String strRegionValue[] = new String[3];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		String[] strAllRegions = { objLogindata.strRegionName,
				objLogindata.strRegionName1, objLogindata.strRegionName2 };
		Arrays.sort(strAllRegions);

		objSelectRegionpage.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page.getRegionValue(strAllRegions[0]);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page.getRegionValue(strAllRegions[1]);

		System.out.println(strRegionValue[1]);

		strRegionValue[2] = objRegions_page.getRegionValue(strAllRegions[2]);

		System.out.println(strRegionValue[2]);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
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

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[0])
				.selectRegion(strRegionValue[1])
				.selectRegion(strRegionValue[2]).clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate);

		objSelectRegionpage.clickRegionLink().selectRegionAndNavigate(
				strAllRegions[1]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
					objStatusTypes_data.strStatusColor)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti2)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti3)
        .clickOnReturnToStatusTypeList();

		strStatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strStatusTypeValues1);

		strResourceTypeValue1[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate1,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue1, strStatusTypeValues1)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate1)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate1);

		objSelectRegionpage.clickRegionLink().selectRegionAndNavigate(
				strAllRegions[2]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName2);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName2,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti4,
					objStatusTypes_data.strStatusColor)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti5,	objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti4)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti5)
        .clickOnReturnToStatusTypeList();

		strStatusTypeValues2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName2);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName2);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName2);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName2);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType
				.createResourceType(objResourceType_data.strResourceTypeName2,
						strStatusTypeValues2);

		strResourceTypeValue2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName2);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName2)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName2)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue2[0] = objResource
				.getResourceValue(objResource_data.strResourceName2);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton().editUserDetails(objUserdata.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.verifyRegionName(strRegionValue[2])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.selectUserRegion(strRegionValue[2]).clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate2,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue2, strStatusTypeValues2)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objESetUp_data.strEventTemplate2)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate2);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.verifyCreateMultiRegionEventPage()
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1)
				.selectEventTemplateForMRE(strRegionValue[2],
						objESetUp_data.strEventTemplate2)
				.clickOnNextButton()
				.verifyRegionAndETName(strAllRegions[0],
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(strAllRegions[1],
						objESetUp_data.strEventTemplate1)
				.verifyRegionAndETName(strAllRegions[2],
						objESetUp_data.strEventTemplate2).clickOnYesButton();

		objEventManagement1
				.verifyEventName(objEvent_data.strMultiRegionEvent)
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(
						objEvent_data.strMultiRegionEvent,
						objEvent_data.strMultiRegionEventDescription)
				.clickAcknowledgeAllNotifications();

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objRegionDefault1.verWebNotificationframeIsNotPresent();

		objLogin1.clickLogOut();

		String strSubject = objEvent_data.strMultiRegionEvent;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(
				objUser_data.strFullName, objUser_data.strFullName,
				strAllRegions[0] + " ," + strAllRegions[1] + " ,"
						+ strAllRegions[2],
				objEvent_data.strMultiRegionEventDescription);

		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(
				objUser_data.strFullName, strAllRegions[0] + " ,"
						+ strAllRegions[1] + " ," + strAllRegions[2],
				objEvent_data.strMultiRegionEventDescription);

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

		objMailVerificationFunctions
				.NavToInboxAndVerEmailIsNotPresentNew(strSubject);
		gstrResult = "PASS";
	}
}
