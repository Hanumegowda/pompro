package requirementGroup.CreatingAndManagingEvents;

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
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayDirectedEventsForTwoBrowsers extends TestNG_UI_EXTENSIONS {

	public HappyDayDirectedEventsForTwoBrowsers() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/********************************************************************
	'Description	:Verify that user receives event update notifications  
	                 when an Ad Hoc event is edited..
	'Date	 		:2-Dec-2015
	'Author			:Sangappa K
	*********************************************************************/
	@Test(description = "Verify that user having affiliated right on resource and subscribed"
			+ " to receive 'My Resource' notification receives event update notification when"
			+ " his / her resource is added to an ongoing Ad Hoc event .")
	public void testHappyDay142410() throws Exception {
		gstrTCID = "142410";
		gstrTO = " Verify that user having affiliated right on resource and subscribed"
			+ " to receive 'My Resource' notification receives event update notification when"
			+ " his / her resource is added to an ongoing Ad Hoc event .";
		
		Login login_page = new Login(this.driver1);
		Login_data objTest_data = new Login_data();
		Event_data objEvent_data = new Event_data();
		User_data objUser_data = new User_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventManagement EventManagement_page = new EventManagement(this.driver1);
		EventSetUp EventSetUp_Page=new EventSetUp(this.driver1);
		MyEventNotificationPreferences objEventNotificationPreferences=new MyEventNotificationPreferences(this.driver1);
		
		
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strFilePath = objTest_data.strTestDataPath;
		String strRegionName[] = new String[1];
		strRegionName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
		String strResourceName[] = new String[1];
		String strResourceValue[]=new String[1];
		String strstatusTypeValues[] = new String[1];
		strResourceName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
		strResourceValue[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
		strstatusTypeValues[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);

		Login login_page1 = new Login(this.driver1);
		Resource Resource_Page1 =new Resource(this.driver1);
		ResourceType ResourceType_Page1 = new ResourceType(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions=new MailVerificationFunctions(this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionName[0]);

		RegionDefault_page.selectFrame();

		EventSetUp_Page.navigateToEventSetUp();
		EventSetUp_Page
				.navigateToEventNotificationPreferences(
						objEvent_data.strAdHocEventTempName)
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllResOption().deselectSelectAllWebOption();

		// User creation

		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.selectFirstRole()

				.selectViewResourceRights(strResourceName[0])

				.selectAssosciateResourceRight(strResourceName[0])

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.selectMaintainAdHocEventsOption()

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.clickSaveButton()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName)

				.clickOnEveNotPreferences();

		objEventNotificationPreferences
				.selectEmailNotification(objEvent_data.strAdHocEventTempName)

				.selectWebIndNotification(objEvent_data.strAdHocEventTempName)
				.selectMyResourcesNotification(
						objEvent_data.strAdHocEventTempName)
				.clickOnSaveButton();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)

				.selectFirstRole()

				.selectViewResourceRights(strResourceName[0])

				.selectUpdateStatusOfResource(strResourceName[0])

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.clickSaveButton()

				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName1)
				.clickOnEveNotPreferences();
		objEventNotificationPreferences
				.selectEmailNotification(objEvent_data.strAdHocEventTempName)
				.selectWebIndNotification(objEvent_data.strAdHocEventTempName)
				.selectMyResourcesNotification(
						objEvent_data.strAdHocEventTempName)
				.clickOnSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		login_page.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page.selectFrame();

		EventManagement_page.navigateToEventManagement()

		.clickOnCreateAdHocEventButton()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.clickOnNextButton()

		.clickOnNextButton()

		.clickOnNextButton()

		.clickOnYesButton();

		EventManagement_page
				.verWebNotificationframe()

				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)

				.clickAcknowledgeAllNotifications().selectFrame();

		EventManagement_page.verifyEventInformation(objEvent_data.strEventName,
				objEvent_data.strEventDescription)
				.verifyEventNameInEventBanner(objEvent_data.strEventName);

		System.out.println(objEvent_data.strEventName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page.clickLogOut();

		login_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		EventManagement_page1.navigateToEventManagement()

		.clickOnEditLink(objEvent_data.strEventName)

		.clickOnNextButton();

		Resource_Page1.clickResource(strResourceValue);

		EventManagement_page1.clickOnNextButton();

		ResourceType_Page1.clickStatusType(strstatusTypeValues);

		EventManagement_page1
				.clickOnNextButton()

				.clickOnYesButton()

				.verWebNotificationframe()

				.verWebNotificationAndAcknowledge(
						"Update 1: " + objEvent_data.strEventName,
						objEvent_data.strEventDescription);

		EventManagement_page1
				.clickAcknowledgeAllNotifications()
				.selectFrame()

				.verifyEventNameInEventBanner(
						"Update 1: " + objEvent_data.strEventName);

		login_page1.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		EventManagement_page1.verWebNotificationframe()

		.verWebNotificationAndAcknowledge(
				"Update 1: " + objEvent_data.strEventName,
				objEvent_data.strEventDescription);

		EventManagement_page1
				.clickAcknowledgeAllNotifications()
				.selectFrame()
				.verifyEventNameInEventBanner(
						"Update 1: " + objEvent_data.strEventName);

		login_page1.clickLogOut();

		String strSubject = "Update 1: " + objEvent_data.strEventName;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(
				objUser_data.strFullName, objUser_data.strFullName,
				strRegionName[0], objEvent_data.strEventDescription);

		String strMsgBody3 = objMailVerificationFunctions.getEventEmailBody(
				objUser_data.strFullName1, objUser_data.strFullName,
				strRegionName[0], objEvent_data.strEventDescription);

		Thread.sleep(5000);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;
		boolean boolCheck1 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (boolCheck == false && boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}

			if (boolCheck == true && boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck && boolCheck1);

		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}
	
	/********************************************************************
	'Description	:Verify that user receives event update notifications  
	                 when an Ad Hoc event is edited..
	'Date	 		:7-July-2014
	'Author			:QSG
	*********************************************************************/
	@Test(description = "Verify that user having affiliated right on resource and subscribed "
			+ "to receive 'My Resource' notification receives event update notification "
			+ "when his / her resource is added to an ongoing event.")
	public void testHappyDay142384() throws Exception {

		gstrTCID = "142384";
		gstrTO = "Verify that user having affiliated right on resource and subscribed "
			+ "to receive 'My Resource' notification receives event update notification "
			+ "when his / her resource is added to an ongoing event.";
		
		
		Login login_page = new Login(this.driver1);
		Login_data objTest_data = new Login_data();
		Event_data objEvent_data = new Event_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data=new EventSetUp_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventManagement EventManagement_page = new EventManagement(this.driver1);
		EventSetUp EventSetUp_Page=new EventSetUp(this.driver1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strFilePath = objTest_data.strTestDataPath;
		String strRegionName[] = new String[1];
		strRegionName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
		String strResourceName[] = new String[1];
		String strResourceValue[]=new String[1];
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		strResourceName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
		strResourceTypeValue[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 13, strFilePath);
		strResourceValue[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
		strstatusTypeValues[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);

		Login login_page1 = new Login(this.driver1);
		Resource Resource_Page1 =new Resource(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventSetUp EventSetUp_Page1=new EventSetUp(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions=new MailVerificationFunctions(this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionName[0]);

		RegionDefault_page.selectFrame();

		// User creation

		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.selectFirstRole()
				
				.selectViewResourceRights(strResourceName[0])
				
				.selectUpdateStatusOfResource(strResourceName[0])

				.clickAdvancedOptionAndExpand()
				
				.selectMaintainEventsOption()

				.selectMaintainAdHocEventsOption()
				
				.selectMaintainEventTemplateOption()
				
				.selectConfigureRegionalUserAccessOption()
				
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				
				.entertextPagerId(objUser_data.strPrimaryMailId)

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		//Event template creation	
		EventSetUp_Page.navigateToEventSetUp();

		EventSetUp_Page.createEventTemplate(
				objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)
				
		.deselectSelectAllWebOption();		

		login_page.clickLogOut();
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		//Event creation		
		EventManagement_page1.navigateToEventManagement()

		.clickOnCreateNewEvent()

		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		
		.enterAdHocEventName(objEvent_data.strEventName)
		
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		
		.clickOnSaveButton();
//		System.out.println(objEvent_data.strEventName);
//		login_page.clickLogOut();
//		
//		System.out.println("-----Precondition ends and test execution starts-------");
//
//
//		RegionDefault_page1.selectFrame();
		RegionDefault_page1.clickOnHomeButton();
		
		//Select event template notifications	
		EventSetUp_Page1.navigateToEventSetUp();

		EventSetUp_Page1.navigateToEventNotificationPreferences(objEventSetUp_data.strEventTemplate)
		
		.clickOnEmailNotification(objUser_data.strFullName, true)
		
		.clickOnPagerNotification(objUser_data.strFullName, true)
		
		.clickOnWebNotification(objUser_data.strFullName, true)
		
		.clickOnResNotification(objUser_data.strFullName, true)
		
		.clickSaveButton();
		
		EventManagement_page1.navigateToEventManagementNew()

		.clickOnEditLink(objEvent_data.strEventName);
		
		System.out.println(objEvent_data.strEventName);

		Resource_Page1.clickResource(strResourceValue);

		EventManagement_page1
				.clickOnSaveButton()

				.verWebNotificationframe()

				.verWebNotificationAndAcknowledge(
						"Update 1: " + objEvent_data.strEventName,
						objEvent_data.strEventDescription)

				.clickAcknowledgeAllNotifications();

		String strSubject = "Update 1: " + objEvent_data.strEventName;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(objUser_data.strFullName, objUser_data.strFullName, strRegionName[0], objEvent_data.strEventDescription);

		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(objUser_data.strFullName, strRegionName[0], objEvent_data.strEventDescription);


		Thread.sleep(60000);


		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		objMailVerificationFunctions.NavToInbox(strSubject);
		
		boolean boolCheck= false;
		boolean boolCheck1 = false;
		for(int intCount = 0; intCount<2; intCount++){
			
			objMailVerificationFunctions.verEmail(objUser_data.strPrimaryMailId, strSubject);
			
			if(boolCheck==false){
			boolCheck = objMailVerificationFunctions.verifyMailContainsBody(strMsgBody1);
			}
			
			if(boolCheck1==false){
			boolCheck1 = objMailVerificationFunctions.verifyMailBody(strMsgBody2);
			}
			
			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck && boolCheck1);
		
		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************************************
	 * 'Description : Verify that users can subscribe to receive ‘My Resources Only’ notifications.
	 * 'Date        : 30-NOv-2015
	 * 'Author      : Sangappa K
	 *************************************************************************************************************/
	@Test(description = "Verify that users can subscribe to receive ‘My Resources Only’ notifications.")
	public void testHappyDay138972() throws Exception {

		gstrTCID = "138972";
		gstrTO = "Verify that users can subscribe to receive ‘My Resources Only’ notifications.";

		User_data objUser_data = new User_data();
		Login_data objTest_data = new Login_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
	
		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		MyEventNotificationPreferences MyEventNotificationPreferences_page = new MyEventNotificationPreferences(
				this.driver1);
		
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strFilePath = objTest_data.strTestDataPath;
		String strRegionName[] = new String[1];
		strRegionName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
		String strResourceName[] = new String[1];
		String strResourceValue[]=new String[1];
		String strstatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];
		
		
		strResourceName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
		strResourceTypeValue[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 13, strFilePath);
		strResourceValue[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
		
		strstatusTypeValues[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);
		strstatusTypeValues[1] = objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);
		strstatusTypeValues[2] = objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
		strstatusTypeValues[3] = objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
		strstatusTypeValues[4] = objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionName[0]);

		RegionDefault_page.selectFrame();

		
		// User creation
		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectAssociateWithOfResource(strResourceName[0])
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectEditEventNotificationPreferencesOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objUser_data.strFullName);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.createEventTemplate(
				objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)

		.deselectSelectAllWebOption();

		login_page.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		RegionDefault_page1.verifyRegionDefaultPage();

		NavigationToSubMenus_page.clickOnPreferences();

		MyEventNotificationPreferences_page
				.clickOnEventNotification()
				.verifyAllNotificationForEventTemplate(
						objEventSetUp_data.strEventTemplate)
				.verifyTextMessage()
				.selectMyResourcesNotification(
						objEventSetUp_data.strEventTemplate)
			    .selectEmailNotification(
					objEventSetUp_data.strEventTemplate)
						
				.clickOnSaveButton()
				.verMyResourcesOnlyChkBoxChecked(objEventSetUp_data.strEventTemplate)
				.verEmailNotificationChecked(
						objEventSetUp_data.strEventTemplate);
				
		login_page1.clickLogOut();
				
		gstrResult = "PASS";
	}	
	
	/********************************************************************
	'Description	:Verify that user with any of the affiliated rights on the resource,
	                 who has subscribed to receive ‘My Resources Only’ notification, 
	                 receives the notification when an event is created selecting his/her resources.
	'Date	 		:3-Dec-2015
	'Author			:Sangappa K
	*********************************************************************/
	@Test(description = "Verify that user with any of the affiliated rights on the resource"
			+ ", who has subscribed to receive ‘My Resources Only’ notification, receives the"
			+ " notification when an event is created selecting his/her resources.")
	public void testHappyDay138973() throws Exception {
		gstrTCID ="138973";
		gstrTO = "Verify that user with any of the affiliated rights on the resource, who has s"
				+ "ubscribed to receive ‘My Resources Only’ notification, receives the notification when"
				+ " an event is created selecting his/her resources.";
		
		Login login_page = new Login(this.driver1);
		Login_data objTest_data = new Login_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		User_data objUser_data = new User_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventManagement EventManagement_page = new EventManagement(this.driver1);
		EventSetUp EventSetUp_Page = new EventSetUp(this.driver1);
		MyEventNotificationPreferences objEventNotificationPreferences = new MyEventNotificationPreferences(
				this.driver1);

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strFilePath = objTest_data.strTestDataPath;
		String strRegionName[] = new String[1];
		strRegionName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 2,
				strFilePath);
		String strResourceName[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[5];
		strResourceName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 14,
				strFilePath);
		strResourceValue[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 14,
				strFilePath);

		strResourceTypeValue[0] = objOffCommonFunc.readInfoExcel("TestData", 3,
				13, strFilePath);

		strstatusTypeValues[0] = objOffCommonFunc.readInfoExcel("TestData", 3,
				3, strFilePath);
		strstatusTypeValues[1] = objOffCommonFunc.readInfoExcel("TestData", 3,
				4, strFilePath);
		strstatusTypeValues[2] = objOffCommonFunc.readInfoExcel("TestData", 3,
				5, strFilePath);
		strstatusTypeValues[3] = objOffCommonFunc.readInfoExcel("TestData", 3,
				6, strFilePath);
		strstatusTypeValues[4] = objOffCommonFunc.readInfoExcel("TestData", 3,
				7, strFilePath);

		System.out.println(strResourceName);
		System.out.println(strResourceName);

		Login login_page1 = new Login(this.driver1);
		Resource Resource_Page1 = new Resource(this.driver1);
		ResourceType ResourceType_Page1 = new ResourceType(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionName[0]);

		RegionDefault_page.selectFrame();

		EventSetUp_Page.navigateToEventSetUp();

		EventSetUp_Page
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strstatusTypeValues)
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		EventSetUp_Page
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllResOption().deselectSelectAllWebOption();

		// User creation

		// user1

		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.selectFirstRole()

				.selectViewResourceRights(strResourceName[0])

				.selectAssosciateResourceRight(strResourceName[0])

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.selectMaintainEventTemplateOption()

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.clickSaveButton()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName)

				.clickOnEveNotPreferences();

		objEventNotificationPreferences
				.selectEmailNotification(objEventSetUp_data.strEventTemplate)
				.selectWebIndNotification(objEventSetUp_data.strEventTemplate)
				.selectMyResourcesNotification(
						objEventSetUp_data.strEventTemplate)
				.clickOnSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// user2

		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)

				.selectFirstRole()

				.selectViewResourceRights(strResourceName[0])

				.selectUpdateStatusOfResource(strResourceName[0])

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.clickSaveButton()

				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName1)
				.clickOnEveNotPreferences();
		objEventNotificationPreferences
				.selectEmailNotification(objEventSetUp_data.strEventTemplate)
				.selectWebIndNotification(objEventSetUp_data.strEventTemplate)
				.selectMyResourcesNotification(
						objEventSetUp_data.strEventTemplate)
				.clickOnSaveButton();

		// usser3

		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserMandatoryDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName2)

				.selectFirstRole()

				.selectViewResourceRights(strResourceName[0])

				.selectRunReportRight(strResourceName[0])

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.selectMaintainEventTemplateOption()

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.clickSaveButton()

				.searchUserName(objUser_data.strNewUserName2,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName2)

				.clickOnEveNotPreferences();

		objEventNotificationPreferences
				.selectEmailNotification(objEventSetUp_data.strEventTemplate)
				.selectWebIndNotification(objEventSetUp_data.strEventTemplate)
				.selectMyResourcesNotification(
						objEventSetUp_data.strEventTemplate)
				.clickOnSaveButton();

		System.out.println(objUser_data.strNewUserName2);
		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		EventManagement_page1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		EventManagement_page1
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		EventManagement_page1.verifyEventInformation(
				objEvent_data.strEventName, objEvent_data.strEventDescription)
				.verifyEventNameInEventBanner(objEvent_data.strEventName);

		System.out.println(objEvent_data.strEventName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.clickLogOut();

		String strSubject = objEvent_data.strEventName;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(
				objUser_data.strFullName, objUser_data.strFullName,
				strRegionName[0], objEvent_data.strEventDescription);

		String strMsgBody2 = objMailVerificationFunctions.getEventEmailBody(
				objUser_data.strFullName1, objUser_data.strFullName,
				strRegionName[0], objEvent_data.strEventDescription);

		String strMsgBody3 = objMailVerificationFunctions.getEventEmailBody(
				objUser_data.strFullName2, objUser_data.strFullName,
				strRegionName[0], objEvent_data.strEventDescription);

		System.out.println("strMsgBody1" + strMsgBody1);
		System.out.println("strMsgBody2" + strMsgBody2);
		System.out.println("strMsgBody3" + strMsgBody3);

		Thread.sleep(5000);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			String strMailContent = objMailVerificationFunctions.getMailBody();

			if (strMailContent.startsWith("Event Notice for: "
					+ objUser_data.strFullName))

			{

				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);

			}
			if (strMailContent.startsWith("Event Notice for: "
					+ objUser_data.strFullName1))

			{

				boolCheck1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);

			}

			if (strMailContent.startsWith("Event Notice for: "
					+ objUser_data.strFullName2))

			{

				boolCheck2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);

			}

			objMailVerificationFunctions.backToMailInbox();

		}

		assertTrue(boolCheck && boolCheck1 && boolCheck2);

		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	 * 'Description :Verify that user having affiliated right on resource and subscribed to receive 'My Resource' notification 
	 *                receives event update notification when his / her resource is added to an ongoing Multi region event.
	 *   Date : 04-Dec-2015
	 * 'Author : Sangappa K
	 ********************************************************************************************************************/
	@Test(description ="Verify that user having affiliated right on resource and subscribed to receive 'My Resource' notification receives "
			+ "          event update notification when his / her resource is added to an ongoing Multi region event.")
	public void testHappyDay142453() throws Exception {
		
		gstrTCID ="142453";
		gstrTO	 ="Verify that user having affiliated right on resource and subscribed to receive 'My Resource' notification receives event "
				+ "update notification when his / her resource is added to an ongoing Multi region event.";

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

		String strResourceType = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 14, strFilePath);
		String strResourceType1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 15, strFilePath);

		String strResourceName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 16, strFilePath);
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		String strResourcValue1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 3, 16, strFilePath);
		String strResourcValue2 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 3, 17, strFilePath);

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

				.selectAssosciateResourceRight(strResourceName)

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
				.clickOnResNotification(objUser_data.strNewUserName, true)
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
				.navigateToEventNotificationPreferences(strEventTemplate1)
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllResOption().deselectSelectAllWebOption();
		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		System.out.println(objEvent_data.strEventName);

		// Event creation
		EventManagement_page1
				.clickOnEventLink()
				.clickOnEventManagement()
				.createNewMultiEventButton()
				.verifyCreateMultiRegionEventPage()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0], strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1], strEventTemplate1)
				.deselectIncludeAllResourcesOption()
				.clickOnNextButton()
				.verifyRegionName(strRegionNames[0])

				.verifyRSAndRTName(strResourceName, strResourceType)
				.selectResource(strResourcValue1)
				.clickOnNextButton()
				.verifyRegionName(strRegionNames[1])
				.verifyRSAndRTName(strResourceName1, strResourceType1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton()

				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications()
				.selectFrame()

				.verifyEditEventLink(objEvent_data.strEventName)
				.clickOnEditLink(objEvent_data.strEventName)
				.clickOnNextButton()
				.verifyRegionName(strRegionNames[0])
				.verifyRSAndRTName(strResourceName, strResourceType)
				.clickOnNextButton()
				.verifyRegionName(strRegionNames[1])
				.verifyRSAndRTName(strResourceName1, strResourceType1)
				.selectResource(strResourcValue2)
				.clickOnNextButton()
				.clickOnYesButton()
				.verWebNotificationframe()

				.verWebNotificationAndAcknowledge(
						objEvent_data.strUpdateEventName,
						objEvent_data.strEventDescription)

				.clickAcknowledgeAllNotifications()

				.selectFrame();
		String strMultiRegs = strRegionNames[0] + ", " + strRegionNames[1];

		login_page1.clickLogOut();

		String strSubject = objEvent_data.strUpdateEventName;

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
						.verifyMailContainsBody(objMailVerificationFunctions
								.getEventEmailBody(objUser_data.strFullName,
										objUser_data.strFullName, strMultiRegs,
										objEvent_data.strEventDescription));
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(objMailVerificationFunctions
								.getEventPagerBody(objUser_data.strFullName,
										strMultiRegs,
										objEvent_data.strEventDescription));

			}
			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	 * 'Description :Verify that users subscribed for 'My Resource' notification does not receive event update notification
	 *                 when user's region is removed from MRE.
	 *   Date : 07-Dec-2015
	 * 'Author : Sangappa K
	 ********************************************************************************************************************/
	@Test(description ="Verify that users subscribed for 'My Resource' notification does not receive event update notification"
			+ "           when user's region is removed from MRE.")
	public void testHappyDay142469() throws Exception {
		
		gstrTCID ="142469";
		gstrTO	 ="Verify that users subscribed for 'My Resource' notification does not receive event update notification when"
				+ " user's region is removed from MRE.";

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

				.selectAssosciateResourceRight(strResourceName)

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
				.deselectSelectAllPagerOption().deselectSelectAllResOption();
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
				.selectAssosciateResourceRight(strResourceName1)

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
				.navigateToEventNotificationPreferences(strEventTemplate1)
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllResOption().deselectSelectAllWebOption()

				.navigateToEventNotificationPreferences(strEventTemplate1)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickOnResNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page1.selectFrame();

		System.out.println(objEvent_data.strEventName);

		// Event creation
		EventManagement_page1
				.clickOnEventLink()
				.clickOnEventManagement()

				.createNewMultiEventButton()

				.verifyCreateMultiRegionEventPage()

				.enterAdHocEventName(objEvent_data.strEventName)

				.enterAdHocEventDescription(objEvent_data.strEventDescription)

				.selectEventTemplateForMRE(strRegionValue[0], strEventTemplate)

				.selectEventTemplateForMRE(strRegionValue[1], strEventTemplate1)

				.clickOnNextButton()

				.verifyMultiRegionEventConfirmationPage()

				.verifyRegionAndETName(strRegionNames[0], strEventTemplate)

				.verifyRegionAndETName(strRegionNames[1], strEventTemplate1)

				.verifyConfirmationMessage()

				.clickOnYesButton()

				.verifyEventName(objEvent_data.strEventName)
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
				.verifyEventNameInEventBanner(objEvent_data.strEventName)

				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications()
				.selectFrame()

				.verifyEditEventLink(objEvent_data.strEventName)
				.clickOnEditLink(objEvent_data.strEventName)

				.selectEventTemplateForMRE(strRegionValue[1],
						objEvent_data.strNotParticipating)

				.clickOnNextButton()
				.clickOnNextButton()

				.verifyRegionAndETName(strRegionNames[1],
						objEvent_data.strNoneET)

				.verifyRegionAndETName(strRegionNames[0], strEventTemplate)

				.clickOnYesButton()

				.verWebNotificationframe()

				.verWebNotificationAndAcknowledge(
						"Ended: " + objEvent_data.strEventName,
						objEvent_data.strEventEndDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		String strApplicationTime1 = EventManagement_page1.getApplicationTime();

		String strCurrentYear1 = objDts.getCurrentDate("yyyy");

		strApplicationTime1 = strApplicationTime1 + " " + strCurrentYear1;

		strApplicationTime1 = objDts.converDateFormat(strApplicationTime1,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		String UpdatedTime2 = strApplicationTime1 + " CST";

		System.out.println("2nd Update time" + UpdatedTime2);

		EventManagement_page1
				.verifyEventNameNotDisplayedInEventBanner(objEvent_data.strEventName);

		login_page1.clickLogOut();

		String strSubject = objEvent_data.strEventName;

		String strSubject1 = "Ended: " + objEvent_data.strEventName;

		String strMsgBody3 = "Event Notice for: " + objUser_data.strFullName
				+ "\n\n" + "Region: " + strRegionNames[1]
				+ " no longer participating as of " + UpdatedTime2 + "\n\n"
				+ "Information: " + objEvent_data.strEventDescription
				+ "\n\nFrom: " + objUser_data.strFullName + "\n\nRegions: "
				+ strRegionNames[0] + ", " + strRegionNames[1]
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		System.out.println(strMsgBody3);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strMultiRegs = strRegionNames[0] + ", " + strRegionNames[1];
		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		boolean blnMsg3 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {

				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(objMailVerificationFunctions
								.getEventEmailBody(objUser_data.strFullName,
										objUser_data.strFullName, strMultiRegs,
										objEvent_data.strEventDescription));
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(objMailVerificationFunctions
								.getEventPagerBody(objUser_data.strFullName,
										strMultiRegs,
										objEvent_data.strEventDescription));

			}
			objMailVerificationFunctions.backToMailInbox();

		}

		assertTrue(blnMsg1 && blnMsg2);

		for (int intCount = 0; intCount < 1; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject1);

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

}
