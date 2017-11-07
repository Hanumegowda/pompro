package requirementGroup.CreatingAndManagingEvents;

import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.SelectRegion;
import lib.page.UsersList;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseMultiRegionEvent extends TestNG_UI_EXTENSIONS {

	public EdgeCaseMultiRegionEvent() throws Exception {
		super();
	}

	/*******************************************************************************************************************
	 * 'Description : Verify that multi-region event cannot be created providing Start date=End date
	 * Date : 23-Sep-2014 
	 * 'Author : Anil
	 ********************************************************************************************************************/
	@Test(description = " Verify that multi-region event cannot be created providing Start date=End date")
	public void testEdgeCase139655() throws Exception {
		
		gstrTCID = "139655";
		gstrTO	 = " Verify that multi-region event cannot be created providing Start date=End date";

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
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);


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
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);


		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}

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

				.clickSaveButton()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.clickRegionsLinkForUser(objUser_data.strNewUserName)

				.selectRegion(strRegionValue[1])

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

				.selectUpdateStatusOfResource(strResourceName1)

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

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		// Event creation
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()
				
		.verifyCreateMultiRegionEventPage()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

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

		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");

		EventManagement_page1
				.selectEventStartDateAndTime(strEventStartDateAndTime)
		
				.selectEventEndDateAndTime(strEventStartDateAndTime)

				.selectEventTemplateForMRE(strRegionValue[0], strEventTemplate)

				.selectEventTemplateForMRE(strRegionValue[1], strEventTemplate1)

				.clickOnNextButton()

				.verifyErrorMessageForSameStartAndEndDate();
	
				gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	 * 'Description :  	Verify that cancelling the future multi-region event does not start the event at the specified 
	 * 					future start time. 
	 * Date : 07-Aug-2014 
	 * 'Author : Anil
	 ********************************************************************************************************************/
	@Test(description = "Verify that cancelling the future multi-region event does not start the event at the specified future start time. ")
	public void testEdgeCase135911() throws Exception {
		
		gstrTCID = "135911";
		gstrTO	 = "Verify that cancelling the future multi-region event does not start the event at the specified future start time. ";

		Login_data objTest_data = new Login_data();

		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Date_Time_settings objDts = new Date_Time_settings();
		
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);

		UsersList UsersList_page = new UsersList(this.driver1);
		String strRegionValue[] = new String[2];

		String strFilePath = Login_data.strTestDataPath;

		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);


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
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}

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

				.clickSaveButton()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.clickRegionsLinkForUser(objUser_data.strNewUserName)

				.selectRegion(strRegionValue[1])

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

				.selectUpdateStatusOfResource(strResourceName1)

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

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		// Event creation
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()
				
		.verifyCreateMultiRegionEventPage()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

		strEventStartTime = EventManagement_page1.getEventStartDateAndTime();

		strEventStartTime = objDts.addTimetoExisting(strEventStartTime, 3, "yyyy-MMM-dd HH:mm");

		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");

		String strEventStartDateAndTime[] = strEventStartTime.split(" ");

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

				.selectEventTemplateForMRE(strRegionValue[0], strEventTemplate)

				.selectEventTemplateForMRE(strRegionValue[1], strEventTemplate1)

				.clickOnNextButton()

				.verifyMultiRegionEventConfirmationPage()

				.verifyRegionAndETName(strRegionNames[0], strEventTemplate)

				.verifyRegionAndETName(strRegionNames[1], strEventTemplate1)

				.verifyConfirmationMessage()

				.clickOnYesButton()

				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						objEvent_data.strFuture
						, strEventTemplate, strEventStartTime,
						strEventEndTime, objEvent_data.strYes)

				.verifyEditEventLink(objEvent_data.strEventName)
				
				.verifyCancelEventLink(objEvent_data.strEventName);

		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()

				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						objEvent_data.strFuture, strEventTemplate1, strEventStartTime,
						strEventEndTime, objEvent_data.strYes)

		.verifyEditEventLink(objEvent_data.strEventName)
		
		.verifyCancelEventLink(objEvent_data.strEventName)
		
		.clickCancelEventLink(objEvent_data.strEventName);
			
		strEventEndTime =EventManagement_page1.getEventEndTime(objEvent_data.strEventName);
		EventManagement_page1.verifyEventNotDisplayedInBanner(objEvent_data.strEventName);
		
		Thread.sleep(300000);
		
		EventManagement_page1.navigateToEventManagementNew();
		
		EventManagement_page1.verifyEventNotDisplayedInBanner(objEvent_data.strEventName);
		
		EventManagement_page1.verifyEventEndTime(objEvent_data.strEventName,
				strEventEndTime)
				
		.verifyEventStartTime(objEvent_data.strEventName,
				strEventStartTime)
				
		.verifyEventStatus(objEvent_data.strEventName,
				objEvent_data.strEnded);

		EventManagement_page1.verifyEventAction(objEvent_data.strEventName, objEvent_data.strViewHistoryAction);
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();
		
		EventManagement_page1.navigateToEventManagement();
		
		EventManagement_page1.verifyEventNotDisplayedInBanner(objEvent_data.strEventName);
		
		EventManagement_page1.verifyEventEndTime(objEvent_data.strEventName,
				strEventEndTime)
				
		.verifyEventStartTime(objEvent_data.strEventName,
				strEventStartTime)
				
		.verifyEventStatus(objEvent_data.strEventName,
				objEvent_data.strEnded);
		
		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	 * Description	: Verify that user who is logged into the application, is taken to 'Event status' page when clicked 
	 * 				  on the URL available on the notifications received for a multi-region event
	 * Date			: 29-Feb-2016
	 * Author		: Pallavi
	 ********************************************************************************************************************/
	@Test(description = "Verify that user who is logged into the application, is taken to 'Event status' page when clicked on the URL available on the notifications received for a multi-region event")
	public void testEdgeCase133934() throws Exception {
		
		gstrTCID = "133934";
		gstrTO	 = "Verify that user who is logged into the application, is taken to 'Event status' page when clicked on the URL available on the notifications received for a multi-region event";

		Login_data objTest_data = new Login_data();

		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
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
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

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
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		String strResourceType = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 14, strFilePath);
		
		String strResourceType1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 15, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];
		
		String strAllStatusTypeNames[] = new String[5];
		
		String strAllStatusTypeNames1[] = new String[5];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}

		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}
		
		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames1[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 9 + intCount, strFilePath);
		}

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
		.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
		.enterEmail(objUser_data.strPrimaryMailId)
		.entertextPagerId(objUser_data.strPrimaryMailId)
		.selectUpdateStatusOfResource(strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton()
		.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)
		.clickRegionsLinkForUser(objUser_data.strNewUserName)
		.selectRegion(strRegionValue[1])
		.clickSaveButton();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page.selectFrame();

		UsersList_page
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(strResourceName1)
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
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyEditUserPageIsDisplayed()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUser_data.strNewUserName);
		System.out.println(strEventTemplate1);
		System.out.println(strEventTemplate);
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate1)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName).clickOnPagerCheckBox(
								objUser_data.strNewUserName).clickOnWebCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(strEventTemplate)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .selectUserInEveSecutityPage(
						objUser_data.strNewUserName)
					 .clickSaveButton();
		
		System.out
		.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1
				.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications()
				.selectFrame();
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;
		
		System.out.println(strSubject);

		objMailVerificationFunctions.NavToInbox(strSubject);

		String strMsgBody1 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUser_data.strFullName + "\n\n"
				+ "Regions: " + strRegionNames[0]
				+ ", " + strRegionNames[1]
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strEventDescription + "\nFrom: "
				+ objUser_data.strFullName + "\nRegions: "
				+ strRegionNames[0]
				+ ", " + strRegionNames[1];

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
		
		String strRegLink[] = strUrlLink.split("=");

		RegionDefault_page1.selectFrame();

		objEventStatus1.verifyEventStatus();
		
		if(strRegLink[3] == strRegionValue[0]){
			objEventStatus1.verResourceTypeAndResourceName(strResourceType,
					strResourceName);

			for (int i = 0; i < strAllStatusTypeNames.length; i++) {

				objEventStatus1.verStatusTypes(
						strResourceType,
						strAllStatusTypeNames[i]);
			}
		}else{
			objEventStatus1.verResourceTypeAndResourceName(strResourceType1,
					strResourceName1);

			for (int i = 0; i < strAllStatusTypeNames1.length; i++) {
				System.out.println(strAllStatusTypeNames1[i]);
				objEventStatus1.verStatusTypes(
						strResourceType1,
						strAllStatusTypeNames1[i]);
			}
		}
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	 * Description	: Verify that user who is NOT logged into the application, is taken to the 'Login' page when clicked
	 * 				  on the URL available on the event notifications received
	 * Date			: 29-Feb-2016
	 * Author		: Pallavi
	 ********************************************************************************************************************/
	@Test(description = "Verify that user who is NOT logged into the application, is taken to the 'Login' page when clicked on the URL available on the event notifications received")
	public void testEdgeCase133935() throws Exception {
		
		gstrTCID = "133935";
		gstrTO	 = "Verify that user who is NOT logged into the application, is taken to the 'Login' page when clicked on the URL available on the event notifications received";

		Login_data objTest_data = new Login_data();

		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
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
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

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
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		String strResourceType = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 14, strFilePath);
		
		String strResourceType1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 15, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];
		
		String strAllStatusTypeNames[] = new String[5];
		
		String strAllStatusTypeNames1[] = new String[5];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}

		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}
		
		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames1[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 9 + intCount, strFilePath);
		}

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
		.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
		.enterEmail(objUser_data.strPrimaryMailId)
		.entertextPagerId(objUser_data.strPrimaryMailId)
		.selectUpdateStatusOfResource(strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton()
		.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)
		.clickRegionsLinkForUser(objUser_data.strNewUserName)
		.selectRegion(strRegionValue[1])
		.clickSaveButton();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page.selectFrame();

		UsersList_page
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(strResourceName1)
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
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyEditUserPageIsDisplayed()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUser_data.strNewUserName);
		System.out.println(strEventTemplate1);
		System.out.println(strEventTemplate);
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate1)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName).clickOnPagerCheckBox(
								objUser_data.strNewUserName).clickOnWebCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(strEventTemplate)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .selectUserInEveSecutityPage(
						objUser_data.strNewUserName)
					 .clickSaveButton();
		
		System.out
		.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUserAndAnswerSecurityQuestion(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1
				.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications()
				.selectFrame();
		
		login_page1.clickLogOut();
		Thread.sleep(3000);
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;
		
		System.out.println(strSubject);

		objMailVerificationFunctions.NavToInbox(strSubject);

		String strMsgBody1 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUser_data.strFullName + "\n\n"
				+ "Regions: " + strRegionNames[0]
				+ ", " + strRegionNames[1]
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strEventDescription + "\nFrom: "
				+ objUser_data.strFullName + "\nRegions: "
				+ strRegionNames[0]
				+ ", " + strRegionNames[1];

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
		
		String strRegLink[] = strUrlLink.split("=");

		login_page1.enterUserName(objUser_data.strNewUserName)
				   .enterPassword(objUser_data.strNewPassword)
				   .clickLogin();
		
		RegionDefault_page1.selectFrame();

		objEventStatus1.verifyEventStatus();
		
		if(strRegLink[3] == strRegionValue[0]){
			objEventStatus1.verResourceTypeAndResourceName(strResourceType,
					strResourceName);

			for (int i = 0; i < strAllStatusTypeNames.length; i++) {

				objEventStatus1.verStatusTypes(
						strResourceType,
						strAllStatusTypeNames[i]);
			}
		} else{
			objEventStatus1.verResourceTypeAndResourceName(strResourceType1,
					strResourceName1);

			for (int i = 0; i < strAllStatusTypeNames1.length; i++) {
				System.out.println(strAllStatusTypeNames1[i]);
				objEventStatus1.verStatusTypes(
						strResourceType1,
						strAllStatusTypeNames1[i]);
			}
		}
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	 * Description	: Verify that Warning message is displayed for the user, when clicked on the URL available in the 
	 * 				  event notifications, who is logged into any other region in which multi-region event is not created in that region
	 * Date			: 1-Mar-2016
	 * Author		: Pallavi
	 ********************************************************************************************************************/
	@Test(description = "Verify that Warning message is displayed for the user, when clicked on the URL available in the event notifications, who is logged into any other region in which multi-region event is not created in that region")
	public void testEdgeCase133937() throws Exception {
		
		gstrTCID = "133937";
		gstrTO	 = "Verify that Warning message is displayed for the user, when clicked on the URL available in the event notifications, who is logged into any other region in which multi-region event is not created in that region";

		Login_data objTest_data = new Login_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		String strRegionValue[] = new String[3];
		String strRegionNames[] = new String[3];

		String strFilePath = Login_data.strTestDataPath;
		
		strRegionNames[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 2, strFilePath);
		strRegionNames[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 3, strFilePath);
		
		strRegionNames[2] = objTest_data.strRegionName2;

		strRegionValue[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 2, strFilePath);
		strRegionValue[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 3, strFilePath);

		String strResourceName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 16, strFilePath);
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];
		
		String strAllStatusTypeNames[] = new String[5];
		
		String strAllStatusTypeNames1[] = new String[5];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}

		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}
		
		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames1[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 9 + intCount, strFilePath);
		}

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[2] = objRegions_page.getRegionValue(strRegionNames[2]);

		System.out.println(strRegionValue[2]);
		
		// User creation
		UsersList_page
		.navigateToUsers()
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName,
				objUser_data.strNewPassword, objUser_data.strFullName)
		.selectFirstRole()
		.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
		.enterEmail(objUser_data.strPrimaryMailId)
		.entertextPagerId(objUser_data.strPrimaryMailId)
		.selectUpdateStatusOfResource(strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton()
		.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)
		.clickRegionsLinkForUser(objUser_data.strNewUserName)
		.selectRegion(strRegionValue[1])
		.selectRegion(strRegionValue[2])
		.clickSaveButton();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page.selectFrame();

		UsersList_page
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(strResourceName1)
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
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyEditUserPageIsDisplayed()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUser_data.strNewUserName);
		System.out.println(strEventTemplate1);
		System.out.println(strEventTemplate);
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate1)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[2]);

		RegionDefault_page.selectFrame();
		
		// User creation
		UsersList_page
		.navigateToUsers()
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName1,
				objUser_data.strNewPassword, objUser_data.strFullName1)
		.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
		.selectFirstRole()
		.clickSaveButton();
		
		login_page.clickLogOut();
		
		System.out
		.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1
				.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton();
		
		login_page1.clickLogOut()
				   .loginAsNewUserAndAnswerSecurityQuestion(objUser_data.strNewUserName1,
						   objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		login_page1.clickLogOut();
		
		Thread.sleep(5000);
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;
		
		System.out.println(strSubject);

		objMailVerificationFunctions.NavToInbox(strSubject);

		String strMsgBody1 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUser_data.strFullName + "\n\n"
				+ "Regions: " + strRegionNames[0]
				+ ", " + strRegionNames[1]
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strEventDescription + "\nFrom: "
				+ objUser_data.strFullName + "\nRegions: "
				+ strRegionNames[0]
				+ ", " + strRegionNames[1];

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
		
		login_page1.enterUserName(objUser_data.strNewUserName1)
				   .enterPassword(objUser_data.strNewPassword)
				   .clickLogin();
		
		RegionDefault_page1.selectFrame()
						   .verNotAuthorizedScreenOnLogin();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	 * Description	: Verify that appropriate validation message is displayed when an attempt is made to create a multi-region
	 * 				  event without providing mandatory data.
	 * Date			: 2-Mar-2016
	 * Author		: Pallavi
	 ********************************************************************************************************************/
	@Test(description = "Verify that appropriate validation message is displayed when an attempt is made to create a multi-region event without providing mandatory data.")
	public void testEdgeCase133805() throws Exception {
		
		gstrTCID = "133805";
		gstrTO	 = "Verify that appropriate validation message is displayed when an attempt is made to create a multi-region event without providing mandatory data.";

		Login_data objTest_data = new Login_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		User_data objUser_data = new User_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		String strRegionValue[] = new String[2];
		String strRegionNames[] = new String[2];

		String strFilePath = Login_data.strTestDataPath;
		
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
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];
		
		String strAllStatusTypeNames[] = new String[5];
		
		String strAllStatusTypeNames1[] = new String[5];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}

		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}
		
		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames1[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 9 + intCount, strFilePath);
		}

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
		.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
		.enterEmail(objUser_data.strPrimaryMailId)
		.entertextPagerId(objUser_data.strPrimaryMailId)
		.selectUpdateStatusOfResource(strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton()
		.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)
		.clickRegionsLinkForUser(objUser_data.strNewUserName)
		.selectRegion(strRegionValue[0])
		.selectRegion(strRegionValue[1])
		.clickSaveButton();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page.selectFrame();

		UsersList_page
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(strResourceName1)
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
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyEditUserPageIsDisplayed()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUser_data.strNewUserName);
		System.out.println(strEventTemplate1);
		System.out.println(strEventTemplate);
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate1)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();
		
		login_page.clickLogOut();
		
		System.out
		.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1
				.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.clickOnSaveButton()
				.verifyErrorMessageTitle1()
				.verifyInfErrorMessageInCreateAdhocEventPage()
				.verifyTitleErrorMessageInCreateAdhocEventPage()
				.verifySelectETErrorMessage();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	 * Description	: Verify that Multi-regions events are listed only in those regions in which the multi-region is created
	 * Date			: 2-Mar-2016
	 * Author		: Pallavi
	 ********************************************************************************************************************/
	@Test(description = "Verify that Multi-regions events are listed only in those regions in which the multi-region is created")
	public void testEdgeCase133988() throws Exception {
		
		gstrTCID = "133988";
		gstrTO	 = "Verify that Multi-regions events are listed only in those regions in which the multi-region is created";

		Login_data objTest_data = new Login_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		String strRegionValue[] = new String[3];
		String strRegionNames[] = new String[3];

		String strFilePath = Login_data.strTestDataPath;
		
		strRegionNames[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 2, strFilePath);
		strRegionNames[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 3, strFilePath);
		
		strRegionNames[2] = objTest_data.strRegionName2;

		strRegionValue[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 2, strFilePath);
		strRegionValue[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 3, strFilePath);

		String strResourceName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 16, strFilePath);
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];
		
		String strAllStatusTypeNames[] = new String[5];
		
		String strAllStatusTypeNames1[] = new String[5];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}

		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}
		
		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames1[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 9 + intCount, strFilePath);
		}

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[2] = objRegions_page.getRegionValue(strRegionNames[2]);

		System.out.println(strRegionValue[2]);
		
		// User creation
		UsersList_page
		.navigateToUsers()
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName,
				objUser_data.strNewPassword, objUser_data.strFullName)
		.selectFirstRole()
		.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
		.enterEmail(objUser_data.strPrimaryMailId)
		.entertextPagerId(objUser_data.strPrimaryMailId)
		.selectUpdateStatusOfResource(strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton()
		.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)
		.clickRegionsLinkForUser(objUser_data.strNewUserName)
		.selectRegion(strRegionValue[1])
		.selectRegion(strRegionValue[2])
		.clickSaveButton();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page.selectFrame();

		UsersList_page
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(strResourceName1)
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
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyEditUserPageIsDisplayed()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUser_data.strNewUserName);
		System.out.println(strEventTemplate1);
		System.out.println(strEventTemplate);
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate1)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[2]);

		RegionDefault_page.selectFrame();

		UsersList_page
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectFirstRole()
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
				.verifyRegionName(strRegionValue[2])
				.verifySaveButton()
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.selectUserRegion(strRegionValue[2])
				.clickSaveButton()
				.verifyEditUserPageIsDisplayed()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();
		
		login_page.clickLogOut();
		
		System.out
		.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1
				.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton()
				.verifyEventName(objEvent_data.strEventName);
		
		SelectRegion_page1
		.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page1.selectFrame();

		EventManagement_page1.navigateToEventManagement()
							 .verifyEventName(objEvent_data.strEventName);
		
		SelectRegion_page1
		.selectRegionAndNavigate(strRegionNames[2]);
		
		RegionDefault_page1.selectFrame();
		
		EventManagement_page1.navigateToEventManagement()
							 .verifyEventNameNotDisplayed(
									 objEvent_data.strEventName);
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	 * Description	: Verify that appropriate validation message is displayed when the specified event start date and end
	 * 				  date is over 30 days
	 * Date			: 03-Mar-2016
	 * Author		: Pallavi
	 ********************************************************************************************************************/
	@Test(description = "Verify that appropriate validation message is displayed when the specified event start date and end date is over 30 days")
	public void testEdgeCase139692() throws Exception {
		
		gstrTCID = "139692";
		gstrTO	 = "Verify that appropriate validation message is displayed when the specified event start date and end date is over 30 days";

		Login_data objTest_data = new Login_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		String strRegionValue[] = new String[2];
		String strRegionNames[] = new String[2];

		String strFilePath = Login_data.strTestDataPath;
		
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
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];
		
		String strAllStatusTypeNames[] = new String[5];
		
		String strAllStatusTypeNames1[] = new String[5];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}

		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}
		
		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames1[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 9 + intCount, strFilePath);
		}

		String strDate = objDts.getCurrentDate("d/MMM/yyyy");
		
		strDate = objDts.AddDaytoExistingDate(strDate, 31, "d/MMM/yyyy");
		String[] strDateMonthYear = strDate.split("/");
		System.out.println(strDateMonthYear);
		
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
		.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
		.enterEmail(objUser_data.strPrimaryMailId)
		.entertextPagerId(objUser_data.strPrimaryMailId)
		.selectUpdateStatusOfResource(strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton()
		.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)
		.clickRegionsLinkForUser(objUser_data.strNewUserName)
		.selectRegion(strRegionValue[1])
		.clickSaveButton();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page.selectFrame();

		UsersList_page
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(strResourceName1)
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
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyEditUserPageIsDisplayed()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUser_data.strNewUserName);
		System.out.println(strEventTemplate1);
		System.out.println(strEventTemplate);
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate1)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();
		
		login_page.clickLogOut();
		
		System.out
		.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1
				.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickEventEndRadioButton();
		
		EventManagement_page1
				.selectEventEndMonth(strDateMonthYear[1])
				.selectEventEndDay(strDateMonthYear[0])
				.selectEventEndYear(strDateMonthYear[2])
				.selectEventTemplateForMRE(strRegionValue[0],
						strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						strEventTemplate1)
				.clickOnNextButton()
				.verifyTextMessageIsDisplayed()
				.clickOnKeepButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton()
				.verifyEventName(objEvent_data.strEventName);
		
		gstrResult = "PASS";
	}
}