package requirementGroup.CreatingAndManagingEvents;

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
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.MyEventNotificationPreferences;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import static org.testng.AssertJUnit.*;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseDirectedEvents extends TestNG_UI_EXTENSIONS {


	public EdgeCaseDirectedEvents() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*********************************************************************************************
	'Description  :Verify that user with any of the affiliated rights on the resource, and who has
	                NOT subscribed to receive any of the notifications, does not receive the 
	                notification when an event is created selecting his/her resources.
	'Date	 	  :28-July-2014
	'Author		  :Anil
	**********************************************************************************************/
	@Test(description = "Verify that user with any of the affiliated rights on the resource, and who has"
			             + " NOT subscribed to receive any of the notifications, does not receive the"
			             + " notification when an event is created selecting his/her resources.")
	public void testEdgeCase143253() throws Exception {
	
		gstrTCID = "143253";
		gstrTO = "Verify that user with any of the affiliated rights on the resource, and who has"
			             + " NOT subscribed to receive any of the notifications, does not receive the"
			             + " notification when an event is created selecting his/her resources.";
		
		Login_data objTest_data = new Login_data();
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page=new ResourceType(this.driver1);
		Resource Resource_Page =new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		Resource Resource_Page1 =new Resource(this.driver1);
		
		StatusTypes_data objStatusTypes_data=new StatusTypes_data();
		ResourceType_data objResourceType_data=new ResourceType_data();
		Resource_data objResource_data=new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		
		String strstatusTypeValues[] = new String[3];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		
	    login_page.loginToApplication(objTest_data.strUserName, objTest_data.strPassword);
	    
	    SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);
	
		RegionDefault_page.selectFrame();
		
		StatusTypeList_page.navigateToStatusTypeList();

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		
		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		
		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);
		
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		
		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
	.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
                     objStatusTypes_data.strStatusColor)
	.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
	.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
.clickOnReturnToStatusTypeList();
		
		strstatusTypeValues[2] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		
		//Resource type creation 
		ResourceType_Page.navigateToResourceTypePage();
		
		ResourceType_Page.createResourceType(objResourceType_data.strResourceTypeName, strstatusTypeValues);
		
		strResourceTypeValue[0] = ResourceType_Page.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		//Resource creation 
		
		Resource_Page.navigateToResourceListPage();
		
		Resource_Page.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0]=Resource_Page.getResourceValue(objResource_data.strResourceName);
		
		//User creation
		
		UsersList_page.navigateToUsersNew();
	    	    
	    UsersList_page.clickCreateNewUserButton();
	    
		UsersList_page.enterUserDetails(objUser_data.strNewUserName,
				objUser_data.strNewPassword, objUser_data.strFullName);

		System.out.println(objUser_data.strNewUserName);
		
		UsersList_page.enterPrimaryEmailId(objUser_data.strPrimaryMailId);
		
		UsersList_page.selectFirstRole();
		
		
		UsersList_page.selectUpdateStatusOfResource(objResource_data.strResourceName);
		
		UsersList_page.clickAdvancedOptionAndExpand();
		
		UsersList_page.selectMaintainEventsOption();
		
		UsersList_page.clickSaveButton();
		
		UsersList_page.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption);

		EventSetUp_page.navigateToEventSetUp();
		
		EventSetUp_page.createEventTemplate(objEventSetUp_data.strEventTemplate, objEventSetUp_data.strTemplateDefinition, strResourceTypeValue, strstatusTypeValues);
	
		EventSetUp_page.deselectSelectAllWebOption();
		
		login_page.clickLogOut();
		
		System.out.println(objUser_data.strNewUserName);

		login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		
		EventManagement_page1.navigateToEventManagement();
		
		EventManagement_page1.clickOnCreateNewEvent()
		
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		
		.verifyCreateEventPage()
		
		.enterAdHocEventName(objEvent_data.strEventName)
		
		.enterAdHocEventDescription(objEvent_data.strEventDescription);
		
		Resource_Page1.clickResource(strResourceValue);
		
		EventManagement_page1.clickOnSaveButton()
		
		.verifyEventName(objEvent_data.strEventName)
		
		.verifyEventNameInEventBanner(objEvent_data.strEventName);
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		String strSubject = objEvent_data.strEventName;
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubject);
		
		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	/*************************************************************************************************************
	'Description	:Verify that user with 'Override Viewing Restrictions' right but without any of the affiliated
	                 rights on the resource, who has subscribed to receive ‘My Resources Only’ notification, does
	                  not receive notification when an event is created selecting his/her resources.
	'Date	 		:28-July-2014
	'Author			:QSG
	*************************************************************************************************************/
	@Test(description = "Verify that user with 'Override Viewing Restrictions' right but without any of the affiliated"
			+ " rights on the resource, who has subscribed to receive ‘My Resources Only’ notification, "
			+ "does not receive notification when an event is created selecting his/her resources.")
	public void testEdgeCase139024() throws Exception {

		gstrTCID = "139024";
		gstrTO = "Verify that user with 'Override Viewing Restrictions' right but without any of the affiliated"
			+ " rights on the resource, who has subscribed to receive ‘My Resources Only’ notification, "
			+ "does not receive notification when an event is created selecting his/her resources.";
		
		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		Resource Resource_page1 =new Resource(this.driver1);
		

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();
		
		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeList()
					
		.createStatusType(objStatuTypes_data.strNumberStatusType,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.selectFirstRole()

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()
				
				.selectOverrideViewingRestrictionOption()

				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.createEventTemplate(
				objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)

		.deselectSelectAllWebOption()
		
		.navigateToEventNotificationPreferences(objEventSetUp_data.strEventTemplate)

		.clickOnEmailNotification(objUser_data.strFullName, true)

		.clickOnResNotification(objUser_data.strFullName, true)

		.clickSaveButton();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// Event  creation		
		EventManagement_page1.navigateToEventManagement()

		.clickOnCreateNewEvent()

		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

		Resource_page1.clickResource(strResourceValue);

		EventManagement_page1.clickOnSaveButton();
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		String strSubject = objEvent_data.strEventName;
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubject);
		
		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	'Description	:Verify that none of the users receive notification when resource is removed from an ongoing event. 
	'Date	 		:29-July-2014
	'Author			:QSG
	********************************************************************************************************************/
	@Test(description = "Verify that none of the users receive notification when resource is removed from an ongoing event. ")
	public void testEdgeCase140836() throws Exception {

		gstrTCID = "140836";
		gstrTO = "Verify that none of the users receive notification when resource is removed from an ongoing event. ";
		
		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		Resource Resource_page1 =new Resource(this.driver1);
		

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();
		
		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeList()
					
		.createStatusType(objStatuTypes_data.strNumberStatusType,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.selectFirstRole()
								
				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.createEventTemplate(
				objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)

		.deselectSelectAllWebOption()
		
		.navigateToEventNotificationPreferences(objEventSetUp_data.strEventTemplate)

		.clickOnEmailNotification(objUser_data.strFullName, true)

		.clickOnResNotification(objUser_data.strFullName, true)

		.clickSaveButton();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// Event  creation		
		EventManagement_page1.navigateToEventManagement()

		.clickOnCreateNewEvent()

		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

		Resource_page1.clickResource(strResourceValue);

		EventManagement_page1.clickOnSaveButton()
		
		.clickOnEditLink(objEvent_data.strEventName);
		
		Resource_page1.deselectResource(strResourceValue);
		
		EventManagement_page1.clickOnSaveButton();
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		String strSubject = objEvent_data.strEventName;
		
		objMailVerificationFunctions.NavToInbox(strSubject);
		
		objMailVerificationFunctions.verEmail(objUser_data.strPrimaryMailId, strSubject);
		
		objMailVerificationFunctions.backToMailInbox();
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresentNew(strSubject);
		
		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	

	
	/*************************************************************************************************************
	'Description	:Verify that users subscribed for event template and subscribed for 'My Resource' receives event notification when an event is created without selecting any resource. 
	'Date	 		:29-July-2014
	'Author			:QSG
	*************************************************************************************************************/
	@Test(description = "Verify that users subscribed for event template and subscribed for 'My Resource' receives "
			+ "event notification when an event is created without selecting any resource. ")
	public void testEdgeCase143277() throws Exception {

		gstrTCID = "143277";
		gstrTO = "Verify that users subscribed for event template and subscribed for 'My Resource' receives "
			+ "event notification when an event is created without selecting any resource. ";
		
		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.entertextPagerId(objUser_data.strPrimaryMailId)

				.selectFirstRole()

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objUser_data.strFullName);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strstatusTypeValues)

				.deselectSelectAllWebOption()

				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)

				.clickOnEmailNotification(objUser_data.strFullName, true)

				.clickOnResNotification(objUser_data.strFullName, true)

				.clickOnPagerNotification(objUser_data.strFullName, true)

				.clickOnWebNotification(objUser_data.strFullName, true)

				.clickSaveButton();

		login_page.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// Event creation
		EventManagement_page1.navigateToEventManagement()

		.clickOnCreateNewEvent()

		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

		EventManagement_page1.clickOnSaveButton();

		EventManagement_page1.verifyEventName(objEvent_data.strEventName);

		Thread.sleep(10000);

		EventManagement_page1.verWebNotificationframe()

		.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
				objEvent_data.strEventDescription);

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

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;

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
	
	/*************************************************************************************************************
	'Description	: Verify that users who have subscribed to receive event notification for template and users having affiliated right on resource participating in event receive event end notification when an event is ended manually or by system.
	'Date	 		:30-July-2014
	'Author			:Anil
	*************************************************************************************************************/
	@Test(description = " Verify that users who have subscribed to receive event notification for template and users having affiliated right on resource participating in event receive event end notification when an event is ended manually or by system.")
	public void testEdgeCase143308() throws Exception {

		gstrTCID = "143308";
		gstrTO = " Verify that users who have subscribed to receive event notification for template and users having affiliated right on resource participating in event receive event end notification when an event is ended manually or by system.";
		
		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strEventEndTime = "";

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		Resource Resource_Page1 = new Resource(this.driver1);
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.entertextPagerId(objUser_data.strPrimaryMailId)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton();

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.entertextPagerId(objUser_data.strPrimaryMailId)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objUser_data.strFullName);

		System.out.println(objUser_data.strNewUserName1);
		System.out.println(objUser_data.strFullName1);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strstatusTypeValues)

				.deselectSelectAllWebOption()

				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)

				.clickOnEmailNotification(objUser_data.strFullName, true)

				.clickOnResNotification(objUser_data.strFullName, true)

				.clickOnPagerNotification(objUser_data.strFullName, true)

				.clickOnWebNotification(objUser_data.strFullName, true)

				.clickOnEmailNotification(objUser_data.strFullName1, true)

				.clickOnResNotification(objUser_data.strFullName1, true)

				.clickOnPagerNotification(objUser_data.strFullName1, true)

				.clickOnWebNotification(objUser_data.strFullName1, true)

				.clickSaveButton();

		login_page.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// Event creation
		EventManagement_page1.navigateToEventManagement()

		.clickOnCreateNewEvent()

		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

		Resource_Page1.clickResource(strResourceValue);

		EventManagement_page1.clickOnSaveButton();

		EventManagement_page1.verifyEventName(objEvent_data.strEventName);

		EventManagement_page1
				.verWebNotificationframe()

				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)

				.clickAcknowledgeAllNotifications();

		EventManagement_page1.selectFrame();

		EventManagement_page1.clickOnEndEvent(objEvent_data.strEventName);

		EventManagement_page1.verifyViewHistoryLink(objEvent_data.strEventName);

		strEventEndTime = EventManagement_page1
				.getEventEndTime(objEvent_data.strEventName);

		strEventEndTime = objDate_Time_settings.converDateFormat(
				strEventEndTime, "yyyy-MM-dd HH:mm", "MM/dd/yyyy HH:mm");

		Thread.sleep(10000);

		EventManagement_page1.verWebNotificationframe()

		.verWebNotificationAndAcknowledge(
				"Ended: " + objEvent_data.strEventName,
				objEvent_data.strEventEndDescription);

		String strSubject = "Ended: " + objEvent_data.strEventName;

		String strMsgBody1 = "Event Notice for: "
				+ objUser_data.strFullName
				+ "\n"
				+ objEvent_data.strEventName
				+ " ended at "
				+ strEventEndTime
				+ "\n\nFrom: "
				+ objUser_data.strFullName
				+ "\n"
				+ "Regions: "
				+ objTest_data.strRegionName
				+ "\n\nPlease"
				+ " do not reply to this email message. You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = objEvent_data.strEventName + " ended at "
				+ strEventEndTime + "\n" + "From: " + objUser_data.strFullName
				+ "\n" + "Regions: " + objTest_data.strRegionName;
		;

		String strMsgBody3 = "Event Notice for: "
				+ objUser_data.strFullName1
				+ "\n"
				+ objEvent_data.strEventName
				+ " ended at "
				+ strEventEndTime
				+ "\n\nFrom: "
				+ objUser_data.strFullName
				+ "\n"
				+ "Regions: "
				+ objTest_data.strRegionName
				+ "\n\nPlease"
				+ " do not reply to this email message. You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody4 = objEvent_data.strEventName + " ended at "
				+ strEventEndTime + "\n" + "From: " + objUser_data.strFullName
				+ "\n" + "Regions: " + objTest_data.strRegionName;

		Thread.sleep(100000);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
		boolean blnMsg4 = false;

		for (int intCount = 0; intCount < 4; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}

			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}

			if (blnMsg4 == false) {
				blnMsg4 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}

			objMailVerificationFunctions.backToMailInbox();

		}

		assertTrue(blnMsg1 && blnMsg2 && blnMsg3 && blnMsg4);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	
	/************************************************************************************************************************
	'Description  : Verify that none of the users receive notification when resource is removed from an ongoing Ad Hoc event.
	'Date	 	  : 30-July-2014
	'Author		  : Anitha
	'Reviewed by  :
	'Modified by  :                                   
	'Modified Date:
	*************************************************************************************************************************/
	@Test(description = " Verify that none of the users receive notification when resource is removed from an ongoing Ad Hoc event.")
	public void testEdgeCase140837() throws Exception {

		gstrTCID = "140837";
		gstrTO = " Verify that none of the users receive notification when resource is removed from an ongoing Ad Hoc event.";
		
		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		ResourceType ResourceType_Page1 = new ResourceType(this.driver1);
		Resource Resource_page1 = new Resource(this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.selectMaintainAdHocEventsOption()

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// Event Template creation

		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page
				.navigateToEventNotificationPreferences(
						objEvent_data.strAdHocEventTempName)

				.deselectSelectAllEmailOption()

				.deselectSelectAllPagerOption()

				.deselectSelectAllResOption()

				.clickOnEmailNotification(objUser_data.strFullName, true)

				.clickOnResNotification(objUser_data.strFullName, true)

				.deselectSelectAllWebOption();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// Event creation
		EventManagement_page1.navigateToEventManagement()

		.clickOnCreateAdHocEventButton()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.clickOnNextButton();

		Resource_page1.clickResource(strResourceValue);

		EventManagement_page1.clickOnNextButton();

		ResourceType_Page1.clickStatusType(strstatusTypeValues);

		EventManagement_page1.clickOnNextButton()

		.clickOnYesButton()

		.verifyEventName(objEvent_data.strEventName);

		EventManagement_page1.clickOnEditLink(objEvent_data.strEventName)

		.clickOnNextButton();

		Resource_page1.deselectResource(strResourceValue);

		EventManagement_page1.clickOnNextButton();

		//ResourceType_Page1.deselectStatusType(strstatusTypeValues);

		EventManagement_page1.clickOnNextButton()

		.clickOnYesButton();

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;
		
		System.out.println(strSubject);

		objMailVerificationFunctions.NavToInbox(strSubject);

		objMailVerificationFunctions.verEmail(objUser_data.strPrimaryMailId,
				strSubject);

		objMailVerificationFunctions.backToMailInbox();

		objMailVerificationFunctions
				.NavToInboxAndVerEmailIsNotPresentNew(strSubject);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************************************
	 * 'Description : Verify that user receives event notifications even though
	 * there are no resources involved in the event when the user has subscribed
	 * to receive ‘My Resources Only’ notification. 
	 * 'Date :31-July-2014 
	 * 'Author: Anil
	 *************************************************************************************************************/
	@Test(description = " Verify that user receives event notifications even though there are no resources involved in the event when the user has subscribed to receive ‘My Resources Only’ notification.")
	public void testEdgeCase138974() throws Exception {

		gstrTCID = "138974";
		gstrTO = " Verify that user receives event notifications even though there are no resources involved in the event when the user has subscribed to receive ‘My Resources Only’ notification.";
		
		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strstatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		
		MyEventNotificationPreferences MyEventNotificationPreferences_page = new MyEventNotificationPreferences(
				this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[2] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		StatusTypeList_page.createNewStatus(
				objStatuTypes_data.strStatusNameInMulti,
				objStatuTypes_data.strStatusColor)
	.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
      			     objStatuTypes_data.strStatusColor)
	.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
	.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
.clickOnReturnToStatusTypeList();

		strstatusTypeValues[4] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.entertextPagerId(objUser_data.strPrimaryMailId)

				.selectFirstRole()

				.selectAssociateWithOfResource(objResource_data.strResourceName)

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
		
		MyEventNotificationPreferences_page.clickOnEventNotification();
		
		MyEventNotificationPreferences_page.verifyAllNotificationForEventTemplate(objEventSetUp_data.strEventTemplate);
		
		MyEventNotificationPreferences_page.verifyTextMessage();
		
		MyEventNotificationPreferences_page.selectAllNotificationForEventTemplate(objEventSetUp_data.strEventTemplate);
		
		MyEventNotificationPreferences_page.clickOnSaveButton();
		// Event creation
		EventManagement_page1.navigateToEventManagement()

		.verifyEventManagementPage()
		
		.verifyCreateEventButtonDisplayed()
		
		.clickOnCreateNewEvent()

		.verifySelectEventTemplatePage()
		
		.verifyEventTemplateIsDisplayed(objEventSetUp_data.strEventTemplate)
		
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)

		.verifyCreateEventPage()
		
		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

		EventManagement_page1.clickOnSaveButton();

		EventManagement_page1.verifyEventName(objEvent_data.strEventName);

		EventManagement_page1.verifyEventNameInEventBanner(objEvent_data.strEventName);
		

		 
		EventManagement_page1
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


		Thread.sleep(10000);

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
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************************************
	'Description	: Verify that users who have subscribed to receive event notification for template and users having affiliated right on resource participating in event receive event end notification when an Ad Hoc event is ended manually or by system. 
	'Date	 		: 1-Aug-2014
	'Author			: Anil
	*************************************************************************************************************/
	@Test(description = "Verify that users who have subscribed to receive event notification for template and users having affiliated right on resource participating in event receive event end notification when an Ad Hoc event is ended manually or by system. ")
	public void testEdgeCase140842() throws Exception {

		gstrTCID = "140842";
		gstrTO = "Verify that users who have subscribed to receive event notification for template and users having affiliated right on resource participating in event receive event end notification when an Ad Hoc event is ended manually or by system. ";
		
		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strEventEndTime = "";

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		Resource Resource_Page1 = new Resource(this.driver1);
		ResourceType ResourceType_Page1 = new ResourceType(this.driver1);
		
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.entertextPagerId(objUser_data.strPrimaryMailId)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()
				
				.selectMaintainAdHocEventsOption()

				.selectMaintainEventsOption()
				
				.clickSaveButton();

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.entertextPagerId(objUser_data.strPrimaryMailId)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objUser_data.strFullName);

		System.out.println(objUser_data.strNewUserName1);
		System.out.println(objUser_data.strFullName1);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.navigateToEventNotificationPreferences(
				objEvent_data.strAdHocEventTempName)
				
				.deselectSelectAllEmailOption()
		
				.deselectSelectAllPagerOption()
		
				.deselectSelectAllResOption()
		
				.deselectSelectAllWebOption()

				.navigateToEventNotificationPreferences(
				objEvent_data.strAdHocEventTempName)
				
				.clickOnEmailNotification(objUser_data.strFullName, true)

				.clickOnResNotification(objUser_data.strFullName, true)

				.clickOnPagerNotification(objUser_data.strFullName, true)

				.clickOnWebNotification(objUser_data.strFullName, true)

				.clickOnEmailNotification(objUser_data.strFullName1, true)

				.clickOnResNotification(objUser_data.strFullName1, true)

				.clickOnPagerNotification(objUser_data.strFullName1, true)

				.clickOnWebNotification(objUser_data.strFullName1, true)

				.clickSaveButton();

		login_page.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// Event creation
		EventManagement_page1.navigateToEventManagement()

		.clickOnCreateAdHocEventButton()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.clickOnNextButton();
		
		Resource_Page1.clickResource(strResourceValue);
		
		EventManagement_page1.clickOnNextButton();
		
		ResourceType_Page1.clickStatusType(strstatusTypeValues);
		
		EventManagement_page1.clickOnNextButton()
			
			.clickOnYesButton()

		.verifyEventName(objEvent_data.strEventName);

		EventManagement_page1
				.verWebNotificationframe()

				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)

				.clickAcknowledgeAllNotifications();

		EventManagement_page1.selectFrame();

		EventManagement_page1.clickOnEndEvent(objEvent_data.strEventName);

		EventManagement_page1.verifyViewHistoryLink(objEvent_data.strEventName);

		strEventEndTime = EventManagement_page1
				.getEventEndTime(objEvent_data.strEventName);

		strEventEndTime = objDate_Time_settings.converDateFormat(
				strEventEndTime, "yyyy-MM-dd HH:mm", "MM/dd/yyyy HH:mm");

		Thread.sleep(10000);

		EventManagement_page1.verWebNotificationframe()

		.verWebNotificationAndAcknowledge(
				"Ended: " + objEvent_data.strEventName,
				objEvent_data.strEventEndDescription);

//		objEvent_data.strEventName = "Event08/01/2014-120835";
//		objUser_data.strFullName ="FNAuto1406875115700";
//		objUser_data.strFullName1 = "FN1Auto1406875115700";
//		strEventEndTime = "08/01/2014 01:41";
		 
		String strSubject = "Ended: " + objEvent_data.strEventName;

		String strMsgBody1 = "Event Notice for: "
				+ objUser_data.strFullName
				+ "\n"
				+ objEvent_data.strEventName
				+ " ended at "
				+ strEventEndTime
				+ "\n\nFrom: "
				+ objUser_data.strFullName
				+ "\n"
				+ "Regions: "
				+ objTest_data.strRegionName
				+ "\n\nPlease"
				+ " do not reply to this email message. You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = objEvent_data.strEventName + " ended at "
				+ strEventEndTime + "\n" + "From: " + objUser_data.strFullName
				+ "\n" + "Regions: " + objTest_data.strRegionName;
		;

		String strMsgBody3 = "Event Notice for: "
				+ objUser_data.strFullName1
				+ "\n"
				+ objEvent_data.strEventName
				+ " ended at "
				+ strEventEndTime
				+ "\n\nFrom: "
				+ objUser_data.strFullName
				+ "\n"
				+ "Regions: "
				+ objTest_data.strRegionName
				+ "\n\nPlease"
				+ " do not reply to this email message. You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody4 = objEvent_data.strEventName + " ended at "
				+ strEventEndTime + "\n" + "From: " + objUser_data.strFullName
				+ "\n" + "Regions: " + objTest_data.strRegionName;

		Thread.sleep(100000);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
		boolean blnMsg4 = false;

		for (int intCount = 0; intCount < 4; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}

			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}

			if (blnMsg4 == false) {
				blnMsg4 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}

			objMailVerificationFunctions.backToMailInbox();

		}

		assertTrue(blnMsg1 && blnMsg2 && blnMsg3 && blnMsg4);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	
	/**********************************************************************************************************
	'Description	:Edit the event and verify that user with any of the affiliated rights on the resource,
	                 who has subscribed to receive ‘My Resources Only’ notification, receives the notification
	                  when an event is edited selecting his/her resources.
	'Date	 		:29-July-2014
	'Author			:QSG
	**********************************************************************************************************/
	@Test(description = "Edit the event and verify that user with any of the affiliated rights on "
			             + "the resource, who has subscribed to receive ‘My Resources Only’ notification,"
			             + " receives the notification when an event is edited selecting his/her resources.")
	public void testEdgeCase139045() throws Exception {

		gstrTCID = "139045";
		gstrTO = "Edit the event and verify that user with any of the affiliated rights on "
			             + "the resource, who has subscribed to receive ‘My Resources Only’ notification,"
			             + " receives the notification when an event is edited selecting his/her resources.";
		
		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);

		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Resource Resource_page1 = new Resource(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);


		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.entertextPagerId(objUser_data.strPrimaryMailId)

				.selectFirstRole()
				
				.selectAssociateWithOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objUser_data.strFullName);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strstatusTypeValues)

				.deselectSelectAllWebOption()

				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)

				.clickOnEmailNotification(objUser_data.strFullName, true)

				.clickOnResNotification(objUser_data.strFullName, true)

				.clickOnPagerNotification(objUser_data.strFullName, true)

				.clickSaveButton();

		login_page.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// Event creation
		EventManagement_page1.navigateToEventManagement()

		.clickOnCreateNewEvent()

		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

		EventManagement_page1.clickOnSaveButton()
		
		.clickOnEditLink(objEvent_data.strEventName);
		
		Resource_page1.clickResource(strResourceValue);
		
		EventManagement_page1.clickOnSaveButton();

		Thread.sleep(5000);

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

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;

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
	
	/**********************************************************************************************************
	'Description	: Verify that when a resource (RS2) is added to an ongoing event user who has subscribed to 
	                  receive event notification for template and users having affiliated right on both the 
	                  resources (RS1 & RS2) receives event update notifications.
	'Date	 		:29-July-2014
	'Author			:QSG
	**********************************************************************************************************/
	@Test(description = " Verify that when a resource (RS2) is added to an ongoing event user who has "
			          + "subscribed to receive event notification for template and users having affiliated"
			          + " right on both the resources (RS1 & RS2) receives event update notifications.")
	public void testEdgeCase140844() throws Exception {

		gstrTCID = "140844";
		gstrTO = " Verify that when a resource (RS2) is added to an ongoing event user who has "
			          + "subscribed to receive event notification for template and users having affiliated"
			          + " right on both the resources (RS1 & RS2) receives event update notifications.";
		
		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);

		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strResourceValue2[] = new String[1];

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Resource Resource_page1 = new Resource(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);


		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue1[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);
		
		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue2[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.entertextPagerId(objUser_data.strPrimaryMailId)

				.selectFirstRole()
				
				.selectAssociateWithOfResource(objResource_data.strResourceName)

				.selectAssociateWithOfResource(objResource_data.strResourceName1)
				
				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objUser_data.strFullName);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strstatusTypeValues)

				.deselectSelectAllWebOption()

				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)

				.clickOnEmailNotification(objUser_data.strFullName, true)

				.clickOnResNotification(objUser_data.strFullName, true)

				.clickOnPagerNotification(objUser_data.strFullName, true)

				.clickSaveButton();

		login_page.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// Event creation
		EventManagement_page1.navigateToEventManagement()

		.clickOnCreateNewEvent()

		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);
		
		Resource_page1.clickResource(strResourceValue1);

		EventManagement_page1.clickOnSaveButton()
		
		.clickOnEditLink(objEvent_data.strEventName);
		
		Resource_page1.clickResource(strResourceValue2);
		
		EventManagement_page1.clickOnSaveButton();

		Thread.sleep(5000);

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

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = "Update 1: "+objEvent_data.strEventName;

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
	'Description	:Verify that none of the users receive notification when resource is removed from an ongoing Multi region event.  
	'Date	 		:04-Aug-2014
	'Author			:QSG
	********************************************************************************************************************/
	@Test(description = "Verify that none of the users receive notification when resource is removed from an ongoing Multi region event. ")
	public void testEdgeCase140838() throws Exception {

		gstrTCID = "140838";
		gstrTO = "Verify that none of the users receive notification when resource is removed from an ongoing Multi region event. ";
		
		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(this.driver1);
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		Regions Regions_page = new Regions(this.driver1);
		
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		String strstatusTypeValues1[] = new String[1];
		String strResourceTypeValue1[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strRegionValue[] = new String[2];
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		Resource Resource_page1 =new Resource(this.driver1);
		
		String strRegionNames[] = {objTest_data.strRegionName, objTest_data.strRegionName1};
		Arrays.sort(strRegionNames);
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);
		
		RegionDefault_page.selectFrame();
		
		NavigationToSubMenus_page.navigateToRegions();
		
		strRegionValue[0] = Regions_page.getRegionValue(strRegionNames[0]);
		System.out.println(strRegionValue[0]);
		
		strRegionValue[1] = Regions_page.getRegionValue(strRegionNames[1]);

		System.out.println(strRegionValue[1]);
		
		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeListNew()
					
		.createStatusType(objStatuTypes_data.strNumberStatusType,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.selectFirstRole()
								
				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()
	
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
					
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				
				.selectRegion(strRegionValue[1])
				
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)

		.deselectSelectAllWebOption()
		
		.navigateToEventNotificationPreferences(objEventSetUp_data.strEventTemplate)

		.clickOnEmailNotification(objUser_data.strFullName, true)

		.clickOnResNotification(objUser_data.strFullName, true)

		.clickSaveButton();

		login_page.clickLogOut();
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page.selectFrame();
		
		RegionDefault_page.clickRegionLink();
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page.selectFrame();
		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeList()
					
		.createStatusType(objStatuTypes_data.strNumberStatusType,
						objStatuTypes_data.strNSTStatusTypeName1,
						objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName1,
				strstatusTypeValues1);

		strResourceTypeValue1[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue1[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName)
		
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.selectFirstRole()
								
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)

				.selectViewResourceRights(objResource_data.strResourceName1)
				
				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()
		
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
		
				.editUserDetails(objUser_data.strNewUserName)
						
				.clickMultiRegionEventRights()
				
				.selectUserRegion(strRegionValue[0])
				
				.selectUserRegion(strRegionValue[1])
				
				.clickSaveButton()
				
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate1,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue1,
				strstatusTypeValues1)

		.deselectSelectAllWebOption()
		
		.navigateToEventNotificationPreferences(objEventSetUp_data.strEventTemplate1)

		.clickOnEmailNotification(objUser_data.strFullName, true)

		.clickOnResNotification(objUser_data.strFullName, true)

		.clickSaveButton();

		login_page.clickLogOut();
		
		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
				
		// Event  creation		
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.selectEventTemplateForMRE(strRegionValue[0], objEventSetUp_data.strEventTemplate)
		
		.selectEventTemplateForMRE(strRegionValue[1], objEventSetUp_data.strEventTemplate1)
				
		.clickOnNextButton()
		
		.clickOnYesButton()
		
		.verifyEventName(objEvent_data.strEventName)
		
		.clickOnEditLink(objEvent_data.strEventName)
		
		.clickOnNextButton();
		
		Resource_page1.deselectResource(strResourceValue);
		
		EventManagement_page1.clickOnNextButton();
		
		Resource_page1.deselectResource(strResourceValue1);
		
		EventManagement_page1.clickOnNextButton()
		
		.clickOnYesButton();
		
		login_page1.clickLogOut();
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		String strSubject = objEvent_data.strEventName;
		
		objMailVerificationFunctions.NavToInbox(strSubject);
		
		objMailVerificationFunctions.verEmail(objUser_data.strPrimaryMailId, strSubject);
		
		objMailVerificationFunctions.backToMailInbox();
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresentNew(strSubject);
		
		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	

	
	/*******************************************************************************************************************
	'Description	:Verify that users who have subscribed to receive event notification for template and users having affiliated right on resource participating in event receive event end notification when a MRE is ended manually or by system.
	'Date	 		:04-Aug-2014
	'Author			:QSG
	********************************************************************************************************************/
	@Test(description = "Verify that users who have subscribed to receive event notification for template and users having affiliated right on resource participating in event receive event end notification when a MRE is ended manually or by system. ")
	public void testEdgeCase140843() throws Exception {

		gstrTCID = "140843";
		gstrTO = "Verify that users who have subscribed to receive event notification for template and users having affiliated right on resource participating in event receive event end notification when a MRE is ended manually or by system. ";
		
		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(this.driver1);
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		Regions Regions_page = new Regions(this.driver1);
		
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		String strstatusTypeValues1[] = new String[1];
		String strResourceTypeValue1[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strRegionValue[] = new String[2];
		String strEventEndTime = "";
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		
		String strRegionNames[] = {objTest_data.strRegionName, objTest_data.strRegionName1};
		Arrays.sort(strRegionNames);
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);
		
		RegionDefault_page.selectFrame();
		
		NavigationToSubMenus_page.navigateToRegions();
		
		strRegionValue[0] = Regions_page.getRegionValue(strRegionNames[0]);
		System.out.println(strRegionValue[0]);
		
		strRegionValue[1] = Regions_page.getRegionValue(strRegionNames[1]);

		System.out.println(strRegionValue[1]);
		
		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeListNew()
					
		.createStatusType(objStatuTypes_data.strNumberStatusType,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.enterEmail(objUser_data.strPrimaryMailId)
				
				.entertextPagerId(objUser_data.strPrimaryMailId)
				
				.selectFirstRole()
								
				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()
	
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
					
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				
				.selectRegion(strRegionValue[1])
				
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)

		.deselectSelectAllWebOption()
		
		.navigateToEventNotificationPreferences(objEventSetUp_data.strEventTemplate)

		.clickOnEmailNotification(objUser_data.strFullName, true)

		.clickOnResNotification(objUser_data.strFullName, true)
		
		.clickOnPagerNotification(objUser_data.strFullName, true)
		
		.clickOnWebNotification(objUser_data.strFullName, true)
		
		.clickSaveButton();

		login_page.clickLogOut();
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page.selectFrame();
		
		RegionDefault_page.clickRegionLink();
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page.selectFrame();
		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeList()
					
		.createStatusType(objStatuTypes_data.strNumberStatusType,
						objStatuTypes_data.strNSTStatusTypeName1,
						objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName1,
				strstatusTypeValues1);

		strResourceTypeValue1[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue1[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName)
		
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)

				.entertextPagerId(objUser_data.strPrimaryMailId)
				
				.enterEmail(objUser_data.strPrimaryMailId)
				
				.selectFirstRole()
								
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)

				.selectViewResourceRights(objResource_data.strResourceName1)
				
				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()
		
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
		
				.editUserDetails(objUser_data.strNewUserName)
						
				.clickMultiRegionEventRights()
				
				.selectUserRegion(strRegionValue[0])
				
				.selectUserRegion(strRegionValue[1])
				
				.clickSaveButton()
				
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate1,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue1,
				strstatusTypeValues1)

		.deselectSelectAllWebOption()
		
		.navigateToEventNotificationPreferences(objEventSetUp_data.strEventTemplate1)

		.clickOnEmailNotification(objUser_data.strFullName, true)

		.clickOnPagerNotification(objUser_data.strFullName, true)
		
		.clickOnWebNotification(objUser_data.strFullName, true)
		
		.clickOnResNotification(objUser_data.strFullName, true)

		.clickSaveButton();

		login_page.clickLogOut();
		
		System.out
				.println("-----Precondition ends and test execution starts-------");
//		objUser_data.strNewUserName = "Auto1407238151985";
//		objEvent_data.strEventName = "Event08/05/2014-044246";
//		login_page1.loginToApplication(objUser_data.strNewUserName,
//				objUser_data.strNewPassword);
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		// Event  creation		
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.selectEventTemplateForMRE(strRegionValue[0], objEventSetUp_data.strEventTemplate)
		
		.selectEventTemplateForMRE(strRegionValue[1], objEventSetUp_data.strEventTemplate1)
				
		.clickOnNextButton()
		
		.clickOnYesButton()
	
		.verifyEventName(objEvent_data.strEventName)
		
		.verWebNotificationframe()

		
		.verWebNotificationAndAcknowledge(
				objEvent_data.strEventName,
				objEvent_data.strEventDescription)
		
		.clickAcknowledgeAllNotifications();

		EventManagement_page1.selectFrame()
		
		.clickOnEndEvent(objEvent_data.strEventName)

		.verifyViewHistoryLink(objEvent_data.strEventName);
		
		strEventEndTime = EventManagement_page1
				.getEventEndTime(objEvent_data.strEventName);

		strEventEndTime = objDate_Time_settings.converDateFormat(
				strEventEndTime, "yyyy-MM-dd HH:mm", "MM/dd/yyyy HH:mm");

		Thread.sleep(10000);

		EventManagement_page1.verWebNotificationframe()

		.verWebNotificationAndAcknowledge(
				"Ended: " + objEvent_data.strEventName,
				objEvent_data.strEventEndDescription);
		 
		
		String strSubject = "Ended: " + objEvent_data.strEventName;

		String strMsgBody1 = "Event Notice for: "
				+ objUser_data.strFullName
				+ "\n"
				+ objEvent_data.strEventName
				+ " ended at "
				+ strEventEndTime
				+ "\n\nFrom: "
				+ objUser_data.strFullName
				+ "\n"
				+ "Regions: "
				+ strRegionNames[0]+", "+strRegionNames[1]
				+ "\n\nPlease"
				+ " do not reply to this email message. You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = objEvent_data.strEventName + " ended at "
				+ strEventEndTime + "\n" + "From: " + objUser_data.strFullName
				+ "\n" + "Regions: " + strRegionNames[0]+", "+strRegionNames[1];
		;

		Thread.sleep(60000);

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
						.verifyMailBody(strMsgBody1);
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
	/*******************************************************************************************
	'Description 	: Verify that ‘My Resources Only’ checkbox is not available for event templates that have no Resource Types selected.
	'Date 			: 26-Feb-2016
	'Author 		: Sangappa K
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that ‘My Resources Only’ checkbox is not available for event templates that have no Resource Types selected.")
	public void testEdgeCase138975() throws Exception {

		gstrTCID ="138975";
		gstrTO = "Verify that ‘My Resources Only’ checkbox is not available for event templates that have no Resource Types selected.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToStatusTypesInSetup();

		// RoleBased statustypes
		objStatusTypeList1.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList1
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList1.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList1
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objResourceType1.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType1
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource1.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource1
				.getResourceValue(objResource_data.strResourceName);

		objRegionDefault1.clickOnHomeButton();

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.clickSaveButton().verResOnlyChkBoxNotPresent()
				.deselectSelectAllWebOptionOnly().clickSaveButton();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

}
