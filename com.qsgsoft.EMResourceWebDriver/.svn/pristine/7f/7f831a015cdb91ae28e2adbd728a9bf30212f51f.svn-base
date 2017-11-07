package requirementGroup.CreatingAndManagingEvents;

import static org.testng.AssertJUnit.assertTrue;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.RegionalInfo_data;
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
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewCreateEvent extends TestNG_UI_EXTENSIONS{

	public NewCreateEvent() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/******************************************************************
	'Description : Create an event selecting to start immediately and to end after a certain number of hours and verify that the event starts immediately and ends after the specified number of hours.
	'Precondition:
	'Date : 18-Jun-2015 
	'Author : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Create an event selecting to start immediately and to end after a certain number of hours and verify that the event starts immediately and ends after the specified number of hours.")
	public void testHappyDay118078() throws Exception {

		gstrTCID = "118078";
		gstrTO = "Create an event selecting to start immediately and to end after a certain number of hours and verify that the event starts immediately and ends after the specified number of hours.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
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


		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId("pallavidayanand.s@gmail.com"/*objUser_data.strPrimaryMailId*/)
				.enterEmail("pallavidayanand.s@gmail.com"/*objUser_data.strPrimaryMailId*/)
				.entertextPagerId("pallavidayanand.s@gmail.com"/*objUser_data.strPrimaryMailId*/)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objEventSetUp.navigateToEventSetUp();
		
		// create Event template
		objEventSetUp.clickOncreateEventTemplate()
		.enterEventTemplateName(objESetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(objESetUp_data.strTemplateDefinition)
		.clickSaveButton()
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly()
				.clickOnWebCheckBox(objUser_data.strNewUserName)
				.clickOnPagerCheckBox(objUser_data.strNewUserName)
				.clickOnEmailCheckBox(objUser_data.strNewUserName)
				.clickSaveButton();

		objLogin.clickLogOut();

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
				.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.enterEventEndTime(objEvent_data.strEventEndTimeInHours1);

		String strEventStartTime = objEventManagement1.getEventStartDateAndTime();

		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");
		System.out.println(strEventStartTime);
		
		String strGetEventEndTime = objDts.AddTimeToExistingTimeHourAndMin(
				strEventStartTime, 4, 0, "yyyy-MM-dd HH:mm");
		
		objEventManagement1.clickOnSaveButton();
		
		Thread.sleep(5000);
		
		objEventManagement1.verWebNotificationframe();
		objEventManagement1.verWebNotificationAndAcknowledge(objEvent_data.strEventName, objEvent_data.strEventDescription)
		.clickAcknowledgeAllNotifications()
				.selectFrame();

		Thread.sleep(5000);
		String[] strHeader = objEvent_data.strEventHeaders;
		
		for(int intCount = 0; intCount<strHeader.length; intCount++){
			objEventManagement1.verifyEventHeaderAndPosition(strHeader[intCount], intCount+1);
		}
		objEventManagement1
		.verifyEventStartTime(objEvent_data.strEventName, strEventStartTime)
		.verifyEventEndTime(objEvent_data.strEventName, strGetEventEndTime)
		.verifyEventInformation(objEvent_data.strEventName, objEvent_data.strEventDescription)
		.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
		.verifyEditEventLink(objEvent_data.strEventName)
		.verifyEndEventLink(objEvent_data.strEventName);
		
		objEventManagement1.navigateToEventListNew()
		.verifyEventStartTime(objEvent_data.strEventName, strEventStartTime)
		.verifyEventEndTime(objEvent_data.strEventName, strGetEventEndTime)
		.verifyEventInformation(objEvent_data.strEventName, objEvent_data.strEventDescription)
		.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
		.verifyViewLinkIsDisplayed(objEvent_data.strEventName);
		
		for(int intCount = 0; intCount<strHeader.length; intCount++){
			objEventManagement1.verifyEventHeaderAndPosition(strHeader[intCount], intCount+1);
		}
		
		objLogin1.clickLogOut();

		System.out.println(objEvent_data.strEventName);

		String strSubject = objEvent_data.strEventName;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(objUser_data.strFullName, objUser_data.strFullName, objTest_data.strRegionName, objEvent_data.strEventDescription);
		
		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(objUser_data.strFullName, objTest_data.strRegionName, objEvent_data.strEventDescription);
		
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

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					Login_data.strBuildName,
					gstrTCID,
					objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
					objESetUp_data.strEventTemplate,
					objEvent_data.strEventName,
					"Verify mobile end condition event","",""
					,"",
					objTest_data.strRegionName,strEventStartTime,  strGetEventEndTime};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}
		gstrResult = "PASS";
	}

	/******************************************************************
	'Description : Create an event selecting to start immediately and to end at a certain date and time and verify that the event starts immediately and ends at the specified date and time.
	'Precondition:
	'Date : 18-Jun-2015 
	'Author : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Create an event selecting to start immediately and to end at a certain date and time and verify that the event starts immediately and ends at the specified date and time.")
	public void testHappyDay118079() throws Exception {

		gstrTCID = "118079";
		gstrTO = "Create an event selecting to start immediately and to end at a certain date and time and verify that the event starts immediately and ends at the specified date and time.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
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
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objEventSetUp.navigateToEventSetUp();
		
		// create Event template
		objEventSetUp.clickOncreateEventTemplate()
		.enterEventTemplateName(objESetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(objESetUp_data.strTemplateDefinition)
		.clickSaveButton()
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly()
				.clickOnWebCheckBox(objUser_data.strNewUserName)
				.clickOnPagerCheckBox(objUser_data.strNewUserName)
				.clickOnEmailCheckBox(objUser_data.strNewUserName)
				.clickSaveButton();

		objLogin.clickLogOut();

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

		String strEventStartTime = objEventManagement1.getEventStartDateAndTime();

		String strEventEndTime = objDts.AddDaytoExistingDate(strEventStartTime, 1,
				"yyyy-MMM-dd HH:mm");

		strEventEndTime = objDts.converDateFormat(strEventEndTime,
				"yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");
		System.out.println(strEventEndTime);
		String strEventEndDateAndTime[] = strEventEndTime.split(" ");

		strEventEndDateAndTime[3] = "05";

		strEventEndDateAndTime[4] = "00";

		strEventEndTime = strEventEndDateAndTime[0] + " "
				+ strEventEndDateAndTime[1] + " "
				+ strEventEndDateAndTime[2] + " "
				+ strEventEndDateAndTime[3] + " "
				+ strEventEndDateAndTime[4];

		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");	
		
		strEventEndTime = objDts.converDateFormat(strEventEndTime,
				"yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");

		objEventManagement1
				.selectEventEndDateAndTime(strEventEndDateAndTime);

		
		objEventManagement1.clickOnSaveButton();
		
		Thread.sleep(5000);
		
		objEventManagement1.verWebNotificationframe();
		objEventManagement1.verWebNotificationAndAcknowledge(objEvent_data.strEventName, objEvent_data.strEventDescription)
		.clickAcknowledgeAllNotifications()
				.selectFrame();

		Thread.sleep(5000);
		String[] strHeader = objEvent_data.strEventHeaders;
		
		for(int intCount = 0; intCount<strHeader.length; intCount++){
			objEventManagement1.verifyEventHeaderAndPosition(strHeader[intCount], intCount+1);
		}
		objEventManagement1
		.verifyEventStartTime(objEvent_data.strEventName, strEventStartTime)
		.verifyEventEndTime(objEvent_data.strEventName, strEventEndTime)
		.verifyEventInformation(objEvent_data.strEventName, objEvent_data.strEventDescription)
		.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
		.verifyEditEventLink(objEvent_data.strEventName)
		.verifyEndEventLink(objEvent_data.strEventName);
		
		objEventManagement1.navigateToEventListNew()
		.verifyEventStartTime(objEvent_data.strEventName, strEventStartTime)
		.verifyEventEndTime(objEvent_data.strEventName, strEventEndTime)
		.verifyEventInformation(objEvent_data.strEventName, objEvent_data.strEventDescription)
		.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
		.verifyViewLinkIsDisplayed(objEvent_data.strEventName);
		for(int intCount = 0; intCount<strHeader.length; intCount++){
			objEventManagement1.verifyEventHeaderAndPosition(strHeader[intCount], intCount+1);
		}
		objLogin1.clickLogOut();

		System.out.println(objEvent_data.strEventName);

		String strSubject = objEvent_data.strEventName;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(objUser_data.strFullName, objUser_data.strFullName, objTest_data.strRegionName, objEvent_data.strEventDescription);
		
		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(objUser_data.strFullName, objTest_data.strRegionName, objEvent_data.strEventDescription);
		
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


		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					Login_data.strBuildName,
					gstrTCID,
					objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
					objESetUp_data.strEventTemplate,
					objEvent_data.strEventName,
					"Verify mobile end condition event","",""
					,"",
					objTest_data.strRegionName,strEventStartTime,  strEventEndTime};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}
		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Create an event selecting to start immediately and to end never and verify that the event starts immediately and does not have an end date. 
	'Precondition:
	'Date : 18-Jun-2015 
	'Author : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Create an event selecting to start immediately and to end never and verify that the event starts immediately and does not have an end date. ")
	public void testHappyDay118080() throws Exception {

		gstrTCID = "118080";
		gstrTO = "Create an event selecting to start immediately and to end never and verify that the event starts immediately and does not have an end date. ";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
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
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objEventSetUp.navigateToEventSetUp();
		
		// create Event template
		objEventSetUp.clickOncreateEventTemplate()
		.enterEventTemplateName(objESetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(objESetUp_data.strTemplateDefinition)
		.clickSaveButton()
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly()
				.clickOnWebCheckBox(objUser_data.strNewUserName)
				.clickOnPagerCheckBox(objUser_data.strNewUserName)
				.clickOnEmailCheckBox(objUser_data.strNewUserName)
				.clickSaveButton();

		objLogin.clickLogOut();

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

		String strEventStartTime = objEventManagement1.getEventStartDateAndTime();

		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");	

		objEventManagement1.clickEventNeverEndRadioButton();
		
		objEventManagement1.clickOnSaveButton();
		
		Thread.sleep(5000);
		
		objEventManagement1.verWebNotificationframe();
		objEventManagement1.verWebNotificationAndAcknowledge(objEvent_data.strEventName, objEvent_data.strEventDescription)
		.clickAcknowledgeAllNotifications()
				.selectFrame();

		Thread.sleep(5000);
		String[] strHeader = objEvent_data.strEventHeaders;
		
		for(int intCount = 0; intCount<strHeader.length; intCount++){
			objEventManagement1.verifyEventHeaderAndPosition(strHeader[intCount], intCount+1);
		}
		objEventManagement1
		.verifyEventStartTime(objEvent_data.strEventName, strEventStartTime)
		.verifyEventEndTimeWhenItSetToNever(objEvent_data.strEventName, objEvent_data.strEndNever)
		.verifyEventInformation(objEvent_data.strEventName, objEvent_data.strEventDescription)
		.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
		.verifyEditEventLink(objEvent_data.strEventName)
		.verifyEndEventLink(objEvent_data.strEventName);
		
		objEventManagement1.navigateToEventListNew()
		.verifyEventStartTime(objEvent_data.strEventName, strEventStartTime)
		.verifyEventEndTimeWhenItSetToNever(objEvent_data.strEventName, objEvent_data.strEndNever)
		.verifyEventInformation(objEvent_data.strEventName, objEvent_data.strEventDescription)
		.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
		.verifyViewLinkIsDisplayed(objEvent_data.strEventName);
		for(int intCount = 0; intCount<strHeader.length; intCount++){
			objEventManagement1.verifyEventHeaderAndPosition(strHeader[intCount], intCount+1);
		}
		objLogin1.clickLogOut();

		System.out.println(objEvent_data.strEventName);

		String strSubject = objEvent_data.strEventName;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(objUser_data.strFullName, objUser_data.strFullName, objTest_data.strRegionName, objEvent_data.strEventDescription);
		
		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(objUser_data.strFullName, objTest_data.strRegionName, objEvent_data.strEventDescription);
		
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

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					Login_data.strBuildName,
					gstrTCID,
					objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
					objESetUp_data.strEventTemplate,
					objEvent_data.strEventName,
					"Verify mobile end condition event","",""
					,"",
					objTest_data.strRegionName,strEventStartTime,  objEvent_data.strEndNever};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}
		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Create an event selecting to start at a specified date and time and to end never and verify that the event starts at the specified time and does not have an end date. 
	'Precondition:
	'Date 		 : 18-Jun-2015 
	'Author 	 : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Create an event selecting to start at a specified date and time and to end never and verify that the event starts at the specified time and does not have an end date. ")
	public void testHappyDay118083() throws Exception {

		gstrTCID = "118083";
		gstrTO = " 	Create an event selecting to start at a specified date and time and to end never and verify that the event starts at the specified time and does not have an end date. ";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

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
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objEventSetUp.navigateToEventSetUp();
		
		// create Event template
		objEventSetUp.clickOncreateEventTemplate()
		.enterEventTemplateName(objESetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(objESetUp_data.strTemplateDefinition)
		.clickSaveButton()
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly()
				.clickOnWebCheckBox(objUser_data.strNewUserName)
				.clickOnPagerCheckBox(objUser_data.strNewUserName)
				.clickOnEmailCheckBox(objUser_data.strNewUserName)
				.clickSaveButton();

		objLogin.clickLogOut();

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

		String strEventStartTime = objEventManagement1.getEventStartDateAndTime();

		System.out.println(strEventStartTime);

		String strEventStartTime1 = objDts.AddDaytoExistingDate(strEventStartTime, 1,
				"yyyy-MMM-dd HH:mm");

		strEventStartTime1 = objDts.converDateFormat(strEventStartTime1,
				"yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");
		System.out.println(strEventStartTime1);
		String strEventStartDateAndTime[] = strEventStartTime1.split(" ");

		strEventStartDateAndTime[3] = "05";

		strEventStartDateAndTime[4] = "00";

		strEventStartTime1 = strEventStartDateAndTime[0] + " "
				+ strEventStartDateAndTime[1] + " "
				+ strEventStartDateAndTime[2] + " "
				+ strEventStartDateAndTime[3] + " "
				+ strEventStartDateAndTime[4];
		
		strEventStartTime = objDts.converDateFormat(strEventStartTime1,
				"yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
		
		objEventManagement1.selectEventStartDateAndTime(strEventStartDateAndTime);

		System.out.println(strEventStartTime1);
		
		objEventManagement1.clickEventNeverEndRadioButton();
		
		objEventManagement1.clickOnSaveButton();
		
		String[] strHeader = objEvent_data.strEventHeaders;
		
		for(int intCount = 0; intCount<strHeader.length; intCount++){
			objEventManagement1.verifyEventHeaderAndPosition(strHeader[intCount], intCount+1);
		}
		objEventManagement1
		.verifyEventStartTime(objEvent_data.strEventName, strEventStartTime)
		.verifyEventEndTimeWhenItSetToNever(objEvent_data.strEventName, objEvent_data.strEndNever)
		.verifyEventInformation(objEvent_data.strEventName, objEvent_data.strEventDescription)
		.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strFuture)
		.verifyEditEventLink(objEvent_data.strEventName)
		.verifyCancelEventLink(objEvent_data.strEventName);
		
		objEventManagement1.navigateToEventListNew();

		System.out.println(objEvent_data.strEventName);
		
		for(int intCount = 0; intCount<strHeader.length; intCount++){
			objEventManagement1.verifyEventHeaderAndPosition(strHeader[intCount], intCount+1);
		}
		
		objEventManagement1.verifyEventNameNotDisplayed(objEvent_data.strEventName);

		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					Login_data.strBuildName,
					gstrTCID,
					objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
					objESetUp_data.strEventTemplate,
					objEvent_data.strEventName,
					"Verify mobile end condition event","",""
					,"",
					objTest_data.strRegionName,strEventStartTime,  objEvent_data.strEndNever};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description :  Verify that an event can be created by providing data only in the mandatory fields.
	'Precondition: 
	'Date : 23-Jun-2015
	'Author : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = " Verify that an event can be created by providing data only in the mandatory fields.")
	public void testHappyDay92364() throws Exception {

		gstrTCID = "92364";
		gstrTO = " Verify that an event can be created by providing data only in the mandatory fields.";

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
		Resource objResource1 = new Resource(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		
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

		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
				objStatuTypes_data.strStatusColor)
	.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
	.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
	.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
    .clickOnReturnToStatusTypeList();

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
//
//		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
//				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
//				strstatusTypeValues);
		

		objEventSetUp
		.clickOncreateEventTemplate()
		.enterEventTemplateName(objESetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(
				objESetUp_data.strTemplateDefinition)
		.selectETIcon(objESetUp_data.strAmberAlert);
		
				for(int intCount=0; intCount<strResourceTypeValue.length;intCount++){
					objEventSetUp.selectResourceType(strResourceTypeValue[intCount]);
				}
				
				for(int intCount=0; intCount<strstatusTypeValues.length;intCount++){
					objEventSetUp.selectStatusType(strstatusTypeValues[intCount]);
				}
				objEventSetUp.clickSaveButton()
		.deselectSelectAllWebOption()
		.verEveTemplateInList(objESetUp_data.strEventTemplate);
		
		System.out.println("templet " + objESetUp_data.strEventTemplate);

		System.out.println(objUser_data.strNewUserName);
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement();
		String[] strHeader = objEvent_data.strEventHeaders;
		
		for(int intCount = 0; intCount<strHeader.length; intCount++){
			objEventManagement1.verifyEventHeaderAndPosition(strHeader[intCount], intCount+1);
		}
		objEventManagement1.verifyCreateEventButtonDisplayed()
							.clickOnCreateNewEvent()
							.verifySelectEventTemplatePage()
							.verifyCreateEventLink(objESetUp_data.strEventTemplate)
						   .clickOnCreateEvent(objESetUp_data.strEventTemplate)
						   
						   .verifyMultiEventCountyField()

							.verifyMultiEventZipCOdeField()

							.verifyMultiEventStateField()

							.verifyMultiEventCityField()

							.verifyMultiEventStreetAddressField()

							.verifyMultiEventRenotifyField()

							.verifyMultiEventEndQuitelyField()

							.verifyMultiEventDrillField()

							.verifyMultiEventPrivateField()

							.verifyMultiEventDisplayBannerField()

							.verifyMultiEventEndRadioButton()

							.verifyMultiEventStartRadioButton()

							.verifyEventDescriptionIsDisplayed()

							.verifyEventTitleIsDisplayed()

							.verifyLatitudeLongitudeTextIsDisplayed()
							
							.verifyLatitudeIsDisplayed()
							
							.verifyLongitudeIsDisplayed()
							
							.verifyBrowseButtonIsDisplayed()
						   .enterAdHocEventName(objEvent_data.strEventName)
						   .enterAdHocEventDescription(objEvent_data.strEventDescription);
		objResource1.clickResource(strResourceValue);
		
		String strEventStartTime = objEventManagement1
				.getEventStartDateAndTime();
		
		strEventStartTime = objDts.converDateFormat(
				strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		String strGetEventEndTime = objDts.AddDaytoExistingDate(strEventStartTime, 1, "yyyy-MM-dd HH:mm");

		objEventManagement1.clickOnSaveButton();

//		strEventStartTime = objDts.converDateFormat(strEventStartTime,
//				"yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");
		
		objEventManagement1.verifyEventStartTime(objEvent_data.strEventName,
				strEventStartTime);

		objEventManagement1.verifyEventEndTime(objEvent_data.strEventName,
				strGetEventEndTime);

		objEventManagement1
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
				.verifyEditEventLink(objEvent_data.strEventName)
				.verifyEndEventLink(objEvent_data.strEventName)
				.verifyDrill(objEvent_data.strEventName, objEvent_data.strNo)
				.verifyEventIcon(objEvent_data.strEventName, objEvent_data.strEveAmbulanceIconVal)
				.verifyEventName(objEvent_data.strEventName)
				.verifyEventMultiStatus(objEvent_data.strEventName,
						objEvent_data.strNo)
				.verifyEventInformation(objEvent_data.strEventName, objEvent_data.strEventDescription)
				.verifyEventNameAndTemplate(objEvent_data.strEventName,objESetUp_data.strEventTemplate);
		
		objEventManagement1
		.navigateToEventListNew()
		.verifyEventAction(objEvent_data.strEventName,
				objEvent_data.strViewAction)
		.verifyEventStatus(objEvent_data.strEventName,
				objEvent_data.strOngoing)
		.verifyEventNameAndTemplate(objEvent_data.strEventName,
				objESetUp_data.strEventTemplate)
		.verifyEventStartTime(objEvent_data.strEventName,
				strEventStartTime)
		.verifyEventEndTime(objEvent_data.strEventName,
				strGetEventEndTime)
		.verifyEventInformation(objEvent_data.strEventName,
				objEvent_data.strEventDescription)
		.verifyDrill(objEvent_data.strEventName,
				objEvent_data.strNo)
		.verifyEventMultiStatus(objEvent_data.strEventName,
				objEvent_data.strNo)
		.verifyEventIcon(objEvent_data.strEventName,
				objEvent_data.strEveAmbulanceIconVal);
		objEventManagement1.verifyEventStartTime(objEvent_data.strEventName,
				strEventStartTime);

		objEventManagement1.verifyEventEndTime(objEvent_data.strEventName,
				strGetEventEndTime);

		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		strEventStartTime = objDts.converDateFormat(
				strEventStartTime, "yyyy-MM-dd HH mm", "MM/dd/yy HH mm");
		
		objEventStatus1.verifyCreatedByDesc(objUser_data.strFullName,
				strEventStartTime,
				objEvent_data.strEventDescription);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/******************************************************************
	'Description : Verify that a file can be attached to an event.
	'Precondition:
	'Date : 18-Jun-2015 
	'Author : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that a file can be attached to an event.")
	public void testHappyDay118085() throws Exception {

		gstrTCID = "118085";
		gstrTO = "Verify that a file can be attached to an event.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		RegionalInfo_data objRegionalInfo_data = new RegionalInfo_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		
		String fileDownloadPath = pathProps
				.getProperty(objRegionalInfo_data.strFileUpload);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);	
		String strPath = file.toString();
		
		String fileDownloadPath2 = pathProps
				.getProperty(objRegionalInfo_data.strHtmlFileUpload);

		File file2 = new File(System.getProperty("user.dir") + fileDownloadPath2);	
		String strPath2 = file2.toString();
		
		String fileDownloadPath3 = pathProps
				.getProperty(objRegionalInfo_data.strPdfFileUpload);

		File file3 = new File(System.getProperty("user.dir") + fileDownloadPath3);	
		String strPath3 = file3.toString();
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();


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
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objEventSetUp.navigateToEventSetUp();
		
		// create Event template
		objEventSetUp.clickOncreateEventTemplate()
		.enterEventTemplateName(objESetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(objESetUp_data.strTemplateDefinition)
		.clickSaveButton()
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly()
				.clickOnWebCheckBox(objUser_data.strNewUserName)
				.clickOnPagerCheckBox(objUser_data.strNewUserName)
				.clickOnEmailCheckBox(objUser_data.strNewUserName)
				.clickSaveButton();

		objLogin.clickLogOut();

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
				.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.enterEventEndTime(objEvent_data.strEventEndTimeInHours1);

		objEventManagement1.enterFilePath(strPath);
		
		objEventManagement1.clickOnSaveButton();
		
		Thread.sleep(5000);
		
		objEventManagement1.verWebNotificationframe();
		objEventManagement1.verWebNotificationAndAcknowledge(objEvent_data.strEventName, objEvent_data.strEventDescription)
		.clickAcknowledgeAllNotifications()
				.selectFrame();

		Thread.sleep(5000);
		objEventManagement1
		.verifyEventInformation(objEvent_data.strEventName, objEvent_data.strEventDescription)
		.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
		.verifyEditEventLink(objEvent_data.strEventName)
		.verifyEndEventLink(objEvent_data.strEventName);
		
		String strEventId =objEventManagement1.getEventId(objEvent_data.strEventName);
			
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventManagement1.clickOnAttachedFileLink(strEventId);
		
		Thread.sleep(5000);
		
		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objEventManagement1.verifyAttachedText(objEvent_data.strAttachedFileText);
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName1)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		objEventManagement1.enterFilePath(strPath2);
		
		objEventManagement1.clickOnSaveButton();
		
		Thread.sleep(5000);
		
		objEventManagement1.verWebNotificationframe();
		objEventManagement1.verWebNotificationAndAcknowledge(objEvent_data.strEventName1, objEvent_data.strEventDescription)
		.clickAcknowledgeAllNotifications()
				.selectFrame();

		Thread.sleep(5000);
		objEventManagement1
		.verifyEventInformation(objEvent_data.strEventName1, objEvent_data.strEventDescription)
		.verifyEventStatus(objEvent_data.strEventName1,
						objEvent_data.strOngoing)
		.verifyEditEventLink(objEvent_data.strEventName1)
		.verifyEndEventLink(objEvent_data.strEventName1);
		
		String strEventId1 =objEventManagement1.getEventId(objEvent_data.strEventName1);
			
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName1);
		
		objEventManagement1.clickOnAttachedFileLink(strEventId1);
		
		Thread.sleep(5000);
		
		String mainWindowHandle1 = driver1.getWindowHandle();

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objEventManagement1.verifyHTMLAttachedFile(objEvent_data.strAttachedHTMLText);
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName2)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		objEventManagement1.enterFilePath(strPath3);
		
		objEventManagement1.clickOnSaveButton();
		
		Thread.sleep(5000);
		
		objEventManagement1.verWebNotificationframe();
		objEventManagement1.verWebNotificationAndAcknowledge(objEvent_data.strEventName2, objEvent_data.strEventDescription)
		.clickAcknowledgeAllNotifications()
				.selectFrame();

		Thread.sleep(5000);
		objEventManagement1
		.verifyEventInformation(objEvent_data.strEventName2, objEvent_data.strEventDescription)
		.verifyEventStatus(objEvent_data.strEventName2,
						objEvent_data.strOngoing)
		.verifyEditEventLink(objEvent_data.strEventName2)
		.verifyEndEventLink(objEvent_data.strEventName2);
		
		String strEventId2 =objEventManagement1.getEventId(objEvent_data.strEventName2);
			
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName2);
		
		objEventManagement1.verifyAttachedFileLink(strEventId2);
		
//		Thread.sleep(5000);
//		
//		String mainWindowHandle2 = driver1.getWindowHandle();
//
//		Set<String> a2 = driver1.getWindowHandles();
//		Iterator<String> ite2 = a2.iterator();
//
//		while (ite2.hasNext()) {
//			String popupHandle = ite2.next().toString();
//
//			if (!popupHandle.contains(mainWindowHandle2)) {
//				driver1.switchTo().window(popupHandle);
//
//			}
//		}
//		objEventManagement1.verifyAttachedText(objEvent_data.strAttachedPDFText);
//		
//		driver1.close();
//
//		driver1.switchTo().window(mainWindowHandle1);
//
//		objRegionDefault1.selectFrame();
//
	
		objLogin1.clickLogOut();

		System.out.println(objEvent_data.strEventName);

		String strSubject = objEvent_data.strEventName;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBodyForFileAttached1(objUser_data.strFullName, objUser_data.strFullName, objTest_data.strRegionName, objEvent_data.strEventDescription);

		String strMsgBody3 = objMailVerificationFunctions.getEventEmailBodyForFileAttached2(objUser_data.strFullName, objUser_data.strFullName, objTest_data.strRegionName, objEvent_data.strEventDescription);

		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(objUser_data.strFullName, objTest_data.strRegionName, objEvent_data.strEventDescription);
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
		
		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
				if(blnMsg1==true){
					blnMsg3 = objMailVerificationFunctions
							.verifyMailContainsBody(strMsgBody3);
				}
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}
			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(blnMsg1 && blnMsg2 &&blnMsg3);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description :Verify that address fields are not mandatory if 'Mandatory address' is selected for an event template after the event was created 
	'Precondition: 
	'Date : 23-Jun-2015
	'Author : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that address fields are not mandatory if 'Mandatory address' is selected for an event template after the event was created ")
	public void testHappyDay162559() throws Exception {

		gstrTCID = "162559";
		gstrTO = "Verify that address fields are not mandatory if 'Mandatory address' is selected for an event template after the event was created ";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		// User1 creation
		objUsersList.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.clickSaveButton();

		objLogin.clickLogOut();	

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventSetUp1.navigateToEventSetUp();
		objEventSetUp1
		.clickOncreateEventTemplate()
		.enterEventTemplateName(objESetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(
				objESetUp_data.strTemplateDefinition);
		objEventSetUp1.clickSaveButton()
		.verEveTemplateInList(objESetUp_data.strEventTemplate);
				
		objEventManagement1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription( objEvent_data.strEventDescription)
				.clickOnSaveButton();
		System.out.println(objUser_data.strNewUserName);
		
		objEventManagement1.verWebNotificationframe();
		objEventManagement1.verWebNotificationAndAcknowledge(objEvent_data.strEventName, objEvent_data.strEventDescription)
		.clickAcknowledgeAllNotifications()
				.selectFrame();
		
		objRegionDefault1.clickOnHomeButton();
		
		objEventSetUp1.navigateToEventSetUp();
		objEventSetUp1.clickOnEditTempLink(objESetUp_data.strEventTemplate);
		objEventSetUp1.selMandatoryAddInCreateTemplatePage();
		objEventSetUp1.clickSaveButton();
		
		objEventManagement1.navigateToEventManagement()
							.clickOnEditLink(objEvent_data.strEventName)
							.enterAdHocEventName(objEvent_data.strEditedEventName)
							.clickOnSaveButton();
		
		objEventManagement1.verWebNotificationframe();
		objEventManagement1.verWebNotificationAndAcknowledge("Update 1: "+objEvent_data.strEditedEventName, objEvent_data.strEventDescription)
		.clickAcknowledgeAllNotifications()
				.selectFrame();
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/******************************************************************************
	'Description : Verify that address is displayed in the ‘Event Banner’ when an   
	               event is created selecting a template with ‘Mandatory Address’.
	'Date        : 08-Sep-2015 
	'Author      : Anitha
	'------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*******************************************************************************/
	@Test(description = "Verify that address is displayed in the ‘Event Banner’ when an event is created "
			+ "selecting a template with ‘Mandatory Address’.")
	public void testHappyDay118980() throws Exception {

		gstrTCID = "118980";
		gstrTO = "Verify that address is displayed in the ‘Event Banner’ when an event is created selecting"
				+ " a template with ‘Mandatory Address’.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		Date_Time_settings objDts = new Date_Time_settings();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
	
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		// User1 creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUser_data.strNewUserName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventSetUp1.navigateToEventSetUp();
		
		// create Event template
		objEventSetUp1
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selMandatoryAddInCreateTemplatePage()
				.clickSaveButton()
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly()
				.clickSaveButton();
		
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
						objEventSetUp_data.strZipCode).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strEventStartDateAndTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);

		strEventStartDateAndTime = objDts.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH mm", "MM/dd/yy HH mm");

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strEventName)
				.clickOnEventNameInEventBanner(objEvent_data.strEventName)
				.verifyCreatedByDescAndAdd(objUser_data.strFullName,
						strEventStartDateAndTime,
						objEvent_data.strEventDescription,
						objEventSetUp_data.strCity,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode,
						objEventSetUp_data.strCountrycode);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description 	:  Verify that address is not displayed in the ‘Event Banner’ when an 
						event is created selecting a template for which ‘Mandatory Address’ 
						is not selected.
	'Precondition	: 
	'Date 			: 08-Sept-2015 
	'Author 		: Pallavi
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " Verify that address is not displayed in the ‘Event Banner’ when an event is created "
			+ "selecting a template for which ‘Mandatory Address’ is not selected.")
	public void testHappyDay118981() throws Exception {

		gstrTCID = "118981";
		gstrTO = " Verify that address is not displayed in the ‘Event Banner’ when an event is created selecting"
				+ " a template for which ‘Mandatory Address’ is not selected.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.clickSaveButton()
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly()
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objEventSetUp_data.strEventTemplate);
		System.out.println(objStatusTypes_data.strTSTStatusTypeName);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton();
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		
		objEventManagement1.verifyEventName(objEvent_data.strEventName)
				.verifyEventNameInEventBanner(objEvent_data.strEventName)
				.clickOnEventNameInEventBanner(objEvent_data.strEventName)
				.verifyAddressIsNotDisplayedInEventBanner(objEventSetUp_data.strCity,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode,
						objEventSetUp_data.strCountrycode);

		gstrResult = "PASS";
	}
	
	/********************************************************************************************************
	'Description 	: Verify that event notification does not display the address provided for an event which
	                  is created selecting a template for which ‘Mandatory Address’ checkbox is not selected.
	'Date 			: 18-Sept-2015 
	'Author 		: Anitha
	'--------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*********************************************************************************************************/
	@Test(description = "Verify that event notification does not display the address provided for an event which"
			+ " is created selecting a template for which ‘Mandatory Address’ checkbox is not selected.")
	public void testHappyDay119027() throws Exception {

		gstrTCID = "119027";
		gstrTO = "Verify that event notification does not display the address provided for an event which is created"
				+ " selecting a template for which ‘Mandatory Address’ checkbox is not selected.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, "", "", "", "",
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.clickSaveButton()
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly()
				.clickOnEmailCheckBox(objUserdata.strNewUserName)
				.clickOnPagerCheckBox(objUserdata.strNewUserName)
				.clickOnWebCheckBox(objUserdata.strNewUserName)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objEventSetUp_data.strEventTemplate);
		
		System.out.println("---------Precondition ends and test execution starts------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.enterAddress(objEventSetUp_data.strCity,
						objEventSetUp_data.strState,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode)
				.clickOnSaveButton();
		
		objEventManagement1
		.verWebNotificationframe()

		.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
				objEvent_data.strEventDescription)

		.clickAcknowledgeAllNotifications();

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

		Thread.sleep(60000);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		String strSubject = objEvent_data.strEventName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUserdata.strPrimaryMailId, strSubject);

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

		//objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Create an event template selecting mandatory address check box and verify 
	               that City, State and County are required when an event is created under it. 
	'Precondition: 
	'Date        : 09-Sep-2015 
	'Author      : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = " Create an event template selecting mandatory address check box and verify that City, "
			+ "State and County are required when an event is created under it.")
	public void testHappyDay162617() throws Exception {

		gstrTCID = "162617";
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

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[6];
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
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
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

		objEventSetUp1.selMandatoryAddInCreateTemplatePage().clickSaveButton()
				.deselectSelectAllWebOptionOnly().clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objEventManagement1
				.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyErrorMessageTitle1()
				.verErrorWhenMandatoryAddNotGiven()
				.verAddressFieldsAreMandatory()
				.enterAddress(objEventSetUp_data.strCity,
						objEventSetUp_data.strState,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*******************************************************************************************************
	'Description : Create an event selecting to start immediately and to end after a certain number of hours 
	               and verify that user who created the event is displayed in the Event notification.
	'Date        : 18-Jun-2015 
	'Author      : Anil
	'-------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************************/
	@Test(description = "Create an event selecting to start immediately and to end after a certain number of hours"
			+ " and verify that user who created the event is displayed in the Event notification.")
	public void testHappyDay118243() throws Exception {

		gstrTCID = "118243";
		gstrTO = "Create an event selecting to start immediately and to end after a certain number of hours and"
				+ " verify that user who created the event is displayed in the Event notification.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
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
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objEventSetUp.navigateToEventSetUp();

		// create Event template
		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objESetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objESetUp_data.strTemplateDefinition).clickSaveButton()
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly()
				.clickOnWebCheckBox(objUser_data.strNewUserName)
				.clickOnPagerCheckBox(objUser_data.strNewUserName)
				.clickOnEmailCheckBox(objUser_data.strNewUserName)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUser_data.strNewUserName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)

				.enterEventEndTime(objEvent_data.strEventEndTimeInHours1);

		String strEventStartTime = objEventManagement1
				.getEventStartDateAndTime();

		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");
		System.out.println(strEventStartTime);

		String strGetEventEndTime = objDts.AddTimeToExistingTimeHourAndMin(
				strEventStartTime, 4, 0, "yyyy-MM-dd HH:mm");

		objEventManagement1.clickOnSaveButton();

		Thread.sleep(5000);

		objEventManagement1.verWebNotificationframe();
		objEventManagement1
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		Thread.sleep(5000);
		String[] strHeader = objEvent_data.strEventHeaders;

		for (int intCount = 0; intCount < strHeader.length; intCount++) {
			objEventManagement1.verifyEventHeaderAndPosition(
					strHeader[intCount], intCount + 1);
		}
		objEventManagement1
				.verifyEventStartTime(objEvent_data.strEventName,
						strEventStartTime)
				.verifyEventEndTime(objEvent_data.strEventName,
						strGetEventEndTime)
				.verifyEventInformation(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
				.verifyEditEventLink(objEvent_data.strEventName)
				.verifyEndEventLink(objEvent_data.strEventName);

		objEventManagement1
				.navigateToEventListNew()
				.verifyEventStartTime(objEvent_data.strEventName,
						strEventStartTime)
				.verifyEventEndTime(objEvent_data.strEventName,
						strGetEventEndTime)
				.verifyEventInformation(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
				.verifyViewLinkIsDisplayed(objEvent_data.strEventName);

		for (int intCount = 0; intCount < strHeader.length; intCount++) {
			objEventManagement1.verifyEventHeaderAndPosition(
					strHeader[intCount], intCount + 1);
		}

		objLogin1.clickLogOut();

		System.out.println(objEvent_data.strEventName);

		String strSubject = objEvent_data.strEventName;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(
				objUser_data.strFullName, objUser_data.strFullName,
				objTest_data.strRegionName, objEvent_data.strEventDescription);

		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(
				objUser_data.strFullName, objTest_data.strRegionName,
				objEvent_data.strEventDescription);

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

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					Login_data.strBuildName,
					gstrTCID,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objESetUp_data.strEventTemplate,
					objEvent_data.strEventName,
					"Verify mobile end condition event", "", "", "",
					objTest_data.strRegionName, strEventStartTime,
					strGetEventEndTime };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}
		gstrResult = "PASS";
	}
	/*******************************************************************************************************************
	 * Description 	: Verify that event notification displays the address provided for an event which is created selecting a template 
	 * for which ‘Mandatory Address’ check box is selected.
	 * Date         : 20-Nov-2015
	 * Author      	: Sangappa K
	 ********************************************************************************************************************/
	@Test(description = "Verify that event notification displays the address provided for an event which is created selecting a template for "
			+ "which ‘Mandatory Address’ check box is selected. check box is selected.")
	public void testHappyDay119026() throws Exception {

		gstrTCID ="119026";
		gstrTO ="Verify that event notification displays the address provided for an event which is created selecting a template for which "
				+ "‘Mandatory Address’ check box is selected.";

		Login_data objTest_data = new Login_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		
		Date_Time_settings objDts = new Date_Time_settings();

		String strStatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objTest_data.strRegionName);

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
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		//RT
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

		// User creation
		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName,
						objUser_data.strFirstName, objUser_data.strMiddleName,
						objUser_data.strLastName, "",
						"", objUser_data.strPrimaryMailId,
						objUser_data.strPrimaryMailId,
						objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceTypeValue[0]);

		for (int intCount = 0; intCount < strStatusTypeValues.length; intCount++) {
			objEventSetUp.selectStatusType(strStatusTypeValues[intCount]);
		}

		objEventSetUp
				.selMandatoryAddInCreateTemplatePage()
				.clickSaveButton()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		objLogin.clickLogOut();
		
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		objNavigationToSubmenus1.navigateToEventMenu();
	      EventManagement_page1.clickOnEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue)
				.enterAddress(objEventSetUp_data.strCity,
						objEventSetUp_data.strState,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		
		System.out.println(objEvent_data.strEventName);

		String strEventStartDateAndTime = EventManagement_page1
				.getEventStartTime(objEvent_data.strEventName);

		strEventStartDateAndTime = objDts.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH mm", "MM/dd/yy HH mm");

		EventManagement_page1
				.verWebNotificationframe()
				.verWebNotificationWithAddress(objEvent_data.strEventName,
						objEvent_data.strEventDescription,
						objEventSetUp_data.strCity,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode, objEventSetUp_data.strCountrycode)
				.clickAcknowledgeAllNotifications()
				.selectFrame()
				.clickOnEventNameInEventBanner(objEvent_data.strEventName)
				.verifyCreatedByDescAndAdd(objUser_data.strFullName,
						strEventStartDateAndTime,
						objEvent_data.strEventDescription,
						objEventSetUp_data.strCity,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode, objEventSetUp_data.strCountrycode);

		login_page1.clickLogOut();

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;

		objMailVerificationFunctions.NavToInbox(strSubject);
		

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUser_data.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(objMailVerificationFunctions
								.getEventMailWithAddress(
										objUser_data.strFullName,
										objUser_data.strFullName,
										objTest_data.strRegionName,
										objEvent_data.strEventDescription,
										objEventSetUp_data.strCity,
										objEventSetUp_data.strCountrycode,
										objEventSetUp_data.strZipCode,
										objEventSetUp_data.strCountry,
										objUser_data.MailURL));
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(objMailVerificationFunctions
								.getEventPagerWithAddress(
										objUser_data.strFullName,
										objUser_data.strFullName,
										objTest_data.strRegionName,
										objEvent_data.strEventDescription,
										objEventSetUp_data.strCity,
										objEventSetUp_data.strCountrycode,
										objEventSetUp_data.strZipCode,
										objEventSetUp_data.strCountry));
			}
			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	
	}
	
	
	/*******************************************************************************************************************
	 * 'Description : Create an event selecting to start at a specified date and time and to end after a certain number
	 * 				 of hours and verify that the event starts at the specified time and ends after the specified number of hours. 
	 * Date : 07-Aug-2014 
	 * 'Author : Anil
	 ********************************************************************************************************************/
	@Test(description ="Create an event selecting to start at a specified date and time and to end after a certain number"+
			"of hours and verify that the event starts at the specified time and ends after the specified number of hours." )
	public void testHappyDay118081() throws Exception {
		
		gstrTCID = "118081";
		gstrTO	 = "Create an event selecting to start at a specified date and time and to end after a certain number"+
				"of hours and verify that the event starts at the specified time and ends after the specified number of hours.";

		Login_data objTest_data = new Login_data();

		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);

		UsersList UsersList_page = new UsersList(this.driver1);
		String strRegionValue[] = new String[2];

		String strFilePath = Login_data.strTestDataPath;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);

		Date_Time_settings objDts = new Date_Time_settings();

		String strRegionNames[] = new String[2];

		strRegionNames[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 2, strFilePath);
		strRegionNames[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 3, strFilePath);

		strRegionValue[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 2, strFilePath);
		strRegionValue[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 3, strFilePath);

		String strResourceName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 16, strFilePath);
		
		String strResourceValue = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 3, 16, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);

		String strEventEndTime = "";
		String strEventStartTime = "";

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

				.selectFirstRole()

				.selectUpdateStatusOfResource(strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// Event creation
		EventManagement_page1.navigateToEventManagement()

		.clickOnCreateNewEvent()
		.clickOnCreateEvent(strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue);
				
		strEventStartTime = EventManagement_page1.getEventStartDateAndTime();

		strEventStartTime = objDts.AddDaytoExistingDate(strEventStartTime, 1,
				"yyyy-MMM-dd HH:mm");

		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");

		String strEventStartDateAndTime[] = strEventStartTime.split(" ");

		strEventStartDateAndTime[3] = "04";

		strEventStartDateAndTime[4] = "00";

		strEventStartTime = strEventStartDateAndTime[0] + " "
				+ strEventStartDateAndTime[1] + " "
				+ strEventStartDateAndTime[2] + " "
				+ strEventStartDateAndTime[3] + " "
				+ strEventStartDateAndTime[4];

		strEventEndTime = objDts.addTimetoExistingHour(
				strEventStartTime, 4, "yyyy MMM dd HH mm");

		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");

		strEventEndTime = objDts.converDateFormat(strEventEndTime,
				"yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");

		EventManagement_page1
				.selectEventStartDateAndTime(strEventStartDateAndTime)

				.enterEventEndTime(objEvent_data.strEventEndTimeInHours1)
				
				.clickOnSaveButton()
				
		.verifyEditEventLink(objEvent_data.strEventName)
				
		.verifyCancelEventLink(objEvent_data.strEventName)
				
		.verifyMultiRegionEventDetails(objEvent_data.strEventName,
				objEvent_data.strFuture, strEventTemplate, strEventStartTime,
						strEventEndTime, objEvent_data.strNo);
		
		EventManagement_page1.navigateToEventList();
		
		EventManagement_page1.verifyEventNameNotDisplayed(objEvent_data.strEventName);
		
		login_page1.clickLogOut();

		gstrResult = "PASS";
	}

	
	
	/*******************************************************************************************************************
	 * 'Description : Create an event selecting to start at a specified date and time and to end at a certain date and 
	 * 				time and verify that the event starts at the specified time and ends at the specified date and time. 
	 * Date : 07-Aug-2014 
	 * 'Author : Anil
	 ********************************************************************************************************************/
	@Test(description ="Create an event selecting to start at a specified date and time and to end at a certain date and "+
					"time and verify that the event starts at the specified time and ends at the specified date and time. " )
	public void testHappyDay118082() throws Exception {
		
		gstrTCID = "118082";
		gstrTO	 = "Create an event selecting to start at a specified date and time and to end at a certain date and "+
				"time and verify that the event starts at the specified time and ends at the specified date and time. ";

		Login_data objTest_data = new Login_data();

		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);

		UsersList UsersList_page = new UsersList(this.driver1);
		String strRegionValue[] = new String[2];

		String strFilePath = Login_data.strTestDataPath;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);

		Date_Time_settings objDts = new Date_Time_settings();

		String strRegionNames[] = new String[2];

		strRegionNames[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 2, strFilePath);
		strRegionNames[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 3, strFilePath);

		strRegionValue[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 2, strFilePath);
		strRegionValue[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 3, strFilePath);

		String strResourceName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 16, strFilePath);
		
		String strResourceValue = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 3, 16, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);

		String strEventEndTime = "";
		String strEventStartTime = "";

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

				.selectFirstRole()

				.selectUpdateStatusOfResource(strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// Event creation
		EventManagement_page1.navigateToEventManagement()

		.clickOnCreateNewEvent()
		.clickOnCreateEvent(strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue);
				
	    strEventStartTime = EventManagement_page1.getEventStartDateAndTime();
	    
	    strEventStartTime = objDts.AddDaytoExistingDate(strEventStartTime, 1, "yyyy-MMM-dd HH:mm");
	    
	    strEventStartTime = objDts.converDateFormat(strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");	    
	    
	    String strStartTime[]  = strEventStartTime.split(" ");
	    
	    strStartTime[3] = "04";
	    
	    strStartTime[4] = "00";
	    
	    EventManagement_page1.selectEventStartDateAndTime(strStartTime);
		
		strEventEndTime = objDts.AddDaytoExistingDate(strEventStartTime, 1, "yyyy MMM dd HH mm");
	
	    String strEndTime[]  = strEventEndTime.split(" ");
	    
	    strEndTime[3] = "03";
	    
	    strEndTime[4] = "00";
	    
	    strEventStartTime = strStartTime[0]+" "+strStartTime[1]+" "+strStartTime[2]+" "+strStartTime[3]+" "+strStartTime[4];
	
	    strEventEndTime = strEndTime[0]+" "+strEndTime[1]+" "+strEndTime[2]+" "+strEndTime[3]+" "+strEndTime[4];
	    
		strEventEndTime = objDts.converDateFormat(strEventEndTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
	
		strEventStartTime = objDts.converDateFormat(strEventStartTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
	    
		EventManagement_page1
				.selectEventEndDateAndTime(strEndTime)	
				
				.clickOnSaveButton()
				
		.verifyEditEventLink(objEvent_data.strEventName)
				
		.verifyCancelEventLink(objEvent_data.strEventName)
				
		.verifyMultiRegionEventDetails(objEvent_data.strEventName,
				objEvent_data.strFuture, strEventTemplate, strEventStartTime,
						strEventEndTime, objEvent_data.strNo);
		
		EventManagement_page1.navigateToEventList();
		
		EventManagement_page1.verifyEventNameNotDisplayed(objEvent_data.strEventName);
		
		login_page1.clickLogOut();

		gstrResult = "PASS";
	}


}

