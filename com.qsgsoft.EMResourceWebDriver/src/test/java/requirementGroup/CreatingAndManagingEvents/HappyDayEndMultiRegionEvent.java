package requirementGroup.CreatingAndManagingEvents;

import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayEndMultiRegionEvent extends TestNG_UI_EXTENSIONS {

	public HappyDayEndMultiRegionEvent() throws Exception {
		super();
	}
	
	/*******************************************************************************************************************
	 * 'Description :  	Verify that a never ending multi-region event can be edited to end after certain number of hours. 
	 *  Date        : 07-Aug-2014 
	 * 'Author      : Anil
	 ********************************************************************************************************************/
	@Test(description = "Verify that a never ending multi-region event can be edited to end after certain number of hours. ")
	public void testHappyDay133943() throws Exception {
		
		gstrTCID = "133943";
		gstrTO	 = "Verify that a never ending multi-region event can be edited to end after certain number of hours. ";

		Login_data objTest_data = new Login_data();

		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		String strFilePath = Login_data.strTestDataPath;
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		boolean blnTest = false;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();
		
		String strRegionNames[] = new String[2];
		String strRegionValue[] = new String[2];	

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

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}
		String strSectionName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 20, strFilePath);

		String strEventEndTime = "never";
		String stMultiStatus = "Yes";
		String strEventStatus = "Ongoing";
		String strEventStartTime = "";
		System.out
				.println("-----Precondition starts-------");

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
		
		System.out.println("-----Precondition ends -------");

		System.out.println("-----Test execution starts-------");

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

		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		
				.clickEventNeverEndRadioButton()

				.selectEventTemplateForMRE(strRegionValue[0], strEventTemplate)

				.selectEventTemplateForMRE(strRegionValue[1], strEventTemplate1);

		strEventStartTime = EventManagement_page1.getEventStartDateAndTime();

		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");
		
		strEventEndTime = objDts.addTimetoExistingHour(strEventStartTime, 4, "yyyy-MM-dd HH:mm");
		
		EventManagement_page1.clickOnNextButton()

				.clickOnKeepButton()
				
				.verifyMultiRegionEventConfirmationPage()

				.verifyRegionAndETName(strRegionNames[0], strEventTemplate)

				.verifyRegionAndETName(strRegionNames[1], strEventTemplate1)

				.clickOnYesButton()

				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						strEventStatus, strEventTemplate, strEventStartTime,
						objEvent_data.strEndNever, stMultiStatus)

				.verifyEventNameInEventBanner(objEvent_data.strEventName);

		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()

				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						strEventStatus, strEventTemplate1, strEventStartTime,
						objEvent_data.strEndNever, stMultiStatus)

				.verifyEventNameInEventBanner(objEvent_data.strEventName);
		EventManagement_page1.clickOnEditLink(objEvent_data.strEventName)
		.selectEventEndHourOption()
		.enterEventEndTime(objEvent_data.strEventEndTimeInHours1)
		.clickOnNextButton()
		.clickOnNextButton()
		.clickOnNextButton()
		.clickOnYesButton()
		.verifyEventNameInEventBanner(objEvent_data.strEventName);
		
		EventManagement_page1.verifyMultiRegionEventDetails(objEvent_data.strEventName,
				strEventStatus, strEventTemplate1, strEventStartTime,
				strEventEndTime, stMultiStatus);
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()

				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						strEventStatus, strEventTemplate, strEventStartTime,
						strEventEndTime, stMultiStatus)

				.verifyEventNameInEventBanner(objEvent_data.strEventName);
		
		login_page1.clickLogOut();

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					strRegionNames[0],
					objEvent_data.strEventName,
					strEventTemplate,
					strResourceName,
					strResourceType,
					strstatusTypeNames[0] + "," + strstatusTypeNames[1] + ","
							+ strstatusTypeNames[2] + ","
							+ strstatusTypeNames[3] + ","
							+ strstatusTypeNames[4],
					"Verify mobile end condition",strEventStartTime,
					strEventEndTime, strSectionName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "MultiRegionEvent");
			
		}
	gstrResult = "PASS";
	}
	

	
	/*******************************************************************************************************************
	 * 'Description :  Verify that multi-region event ends at the newly specified End date and time when event end date is edited to a time later than the previously provided end date and time.
	 *  Date        : 07-Aug-2014 
	 * 'Author      : Anil
	 ********************************************************************************************************************/
	@Test(description = "Verify that multi-region event ends at the newly specified End date and time when event end date is edited to a time later than the previously provided end date and time.")
	public void testHappyDay133946() throws Exception {
		
		gstrTCID = "133946";
		gstrTO	 = "Verify that multi-region event ends at the newly specified End date and time when event end date is edited to a time later than the previously provided end date and time.";

		Login_data objTest_data = new Login_data();

		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);

		UsersList UsersList_page = new UsersList(this.driver1);
		String strRegionValue[] = new String[2];

		String strFilePath = Login_data.strTestDataPath;
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		boolean blnTest = false;

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

		String strResourceType = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 14, strFilePath);
		String strResourceType1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 15, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}
		String strSectionName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 20, strFilePath);
		String strSectionName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 21, strFilePath);

		String strEventEndTime = "";
		String strEventStartTime = "";
		String stMultiStatus = "Yes";
		String strEventStatus = "Ongoing";

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

		strEventEndTime = objDts.AddDaytoExistingDate(strEventStartTime, 1,
				"yyyy-MMM-dd HH:mm");

		strEventEndTime = objDts.converDateFormat(strEventEndTime,
				"yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");

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

		EventManagement_page1
				.selectEventEndDateAndTime(strEventEndDateAndTime)

				.selectEventTemplateForMRE(strRegionValue[0], strEventTemplate)

				.selectEventTemplateForMRE(strRegionValue[1], strEventTemplate1)

				.clickOnNextButton()

				.verifyMultiRegionEventConfirmationPage()

				.verifyRegionAndETName(strRegionNames[0], strEventTemplate)

				.verifyRegionAndETName(strRegionNames[1], strEventTemplate1)

				.verifyConfirmationMessage()

				.clickOnYesButton()

				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						strEventStatus, strEventTemplate, strEventStartTime,
						strEventEndTime, stMultiStatus)

				.verifyEditEventLink(objEvent_data.strEventName)
				
				.verifyEndEventLink(objEvent_data.strEventName);

		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()

				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						strEventStatus, strEventTemplate1, strEventStartTime,
						strEventEndTime, stMultiStatus)

		.verifyEditEventLink(objEvent_data.strEventName)
		
		.verifyEndEventLink(objEvent_data.strEventName)
		
		.clickOnEditLink(objEvent_data.strEventName);

				
			strEventEndDateAndTime[3] = "07";

		strEventEndDateAndTime[4] = "10";

		strEventEndTime = strEventEndDateAndTime[0] + " "
				+ strEventEndDateAndTime[1] + " "
				+ strEventEndDateAndTime[2] + " "
				+ strEventEndDateAndTime[3] + " "
				+ strEventEndDateAndTime[4];
		
		System.out.println(strEventEndTime);

		strEventEndTime = objDts.converDateFormat(strEventEndTime,
				"yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
			
		EventManagement_page1.selectEventEndDateAndTime(strEventEndDateAndTime)
		
		.clickOnNextButton()
		.clickOnNextButton()
		.clickOnNextButton()
		.clickOnYesButton()
		.verifyEventNameInEventBanner(objEvent_data.strEventName);
		
		EventManagement_page1.verifyMultiRegionEventDetails(objEvent_data.strEventName,
				strEventStatus, strEventTemplate1, strEventStartTime,
				strEventEndTime, stMultiStatus);

		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()

				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						strEventStatus, strEventTemplate, strEventStartTime,
						strEventEndTime, stMultiStatus);

		login_page1.clickLogOut();

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					strRegionNames[0],
					objEvent_data.strEventName,
					strEventTemplate,
					strResourceName,
					strResourceType,
					strstatusTypeNames[0] + "," + strstatusTypeNames[1] + ","
							+ strstatusTypeNames[2] + ","
							+ strstatusTypeNames[3] + ","
							+ strstatusTypeNames[4],
					"Verify mobile end condition", strEventStartTime,
					strEventEndTime, strSectionName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "MultiRegionEvent");

			String[] strTestData1 = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					strRegionNames[1],
					objEvent_data.strEventName,
					strEventTemplate1,
					strResourceName1,
					strResourceType1,
					strstatusTypeNames[5] + "," + strstatusTypeNames[6] + ","
							+ strstatusTypeNames[7] + ","
							+ strstatusTypeNames[8] + ","
							+ strstatusTypeNames[9],
					"Verify mobile end condition", strEventStartTime,
					strEventEndTime, strSectionName1 };

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "MultiRegionEvent");
		}
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	 * 'Description :  	Verify that multi-region event starts and ends at the newly provided date and time before the previously provided event start and end date/time for a future multi-region event.  
	 * Date : 07-Aug-2014 
	 * 'Author : Anil
	 ********************************************************************************************************************/
	@Test(description = " 	Verify that multi-region event starts and ends at the newly provided date and time before the previously provided event start and end date/time for a future multi-region event. ")
	public void testHappyDay133948() throws Exception {
		
		gstrTCID = "133948";
		gstrTO	 = "Verify that multi-region event starts and ends at the newly provided date and time before the previously provided event start and end date/time for a future multi-region event. ";

		Login_data objTest_data = new Login_data();

		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);

		UsersList UsersList_page = new UsersList(this.driver1);
		String strRegionValue[] = new String[2];

		String strFilePath = Login_data.strTestDataPath;
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		boolean blnTest = false;

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

		String strResourceType = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 14, strFilePath);
		String strResourceType1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 15, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}
		String strSectionName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 20, strFilePath);
		String strSectionName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 21, strFilePath);

		String strEventEndTime = "";
		String strEventStartTime = "";
		String stMultiStatus = "Yes";
		String strEventStatus = "Future";

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

//				.verifyEditMultiRegionEventRights()

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
						strEventStatus, strEventTemplate, strEventStartTime,
						strEventEndTime, stMultiStatus)

				.verifyEditEventLink(objEvent_data.strEventName)
				
				.verifyCancelEventLink(objEvent_data.strEventName);
		
		login_page1.clickLogOut();

		login_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()

				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						strEventStatus, strEventTemplate1, strEventStartTime,
						strEventEndTime, stMultiStatus)

		.verifyEditEventLink(objEvent_data.strEventName)
		
		.verifyCancelEventLink(objEvent_data.strEventName)
		
		.clickOnEditLink(objEvent_data.strEventName);
				
		strEventStartDateAndTime[3] = "01";

		strEventStartDateAndTime[4] = "00";

		strEventStartTime = strEventStartDateAndTime[0] + " "
				+ strEventStartDateAndTime[1] + " "
				+ strEventStartDateAndTime[2] + " "
				+ strEventStartDateAndTime[3] + " "
				+ strEventStartDateAndTime[4];


		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");

		String strEventEndDateAndTime[] = new String[5];

		for(int intCount = 0; intCount<strEventEndDateAndTime.length;intCount++){
			strEventEndDateAndTime[intCount] = strEventStartDateAndTime[intCount];
		}
		strEventEndDateAndTime[3] = "02";

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

		EventManagement_page1.selectEventStartDateAndTime(strEventStartDateAndTime);
		
		EventManagement_page1
				.selectEventEndDateAndTime(strEventEndDateAndTime)

		.clickOnNextButton()
		.clickOnNextButton()
		.clickOnNextButton()
		.clickOnYesButton();
		
		
		EventManagement_page1.verifyMultiRegionEventDetails(objEvent_data.strEventName,
				strEventStatus, strEventTemplate1, strEventStartTime,
				strEventEndTime, stMultiStatus);
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()

		.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						strEventStatus, strEventTemplate, strEventStartTime,
						strEventEndTime, stMultiStatus);

		login_page1.clickLogOut();

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					strRegionNames[0],
					objEvent_data.strEventName,
					strEventTemplate,
					strResourceName,
					strResourceType,
					strstatusTypeNames[0] + "," + strstatusTypeNames[1] + ","
							+ strstatusTypeNames[2] + ","
							+ strstatusTypeNames[3] + ","
							+ strstatusTypeNames[4],
					"Verify mobile end condition", strEventStartTime,
					strEventEndTime, strSectionName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "MultiRegionEvent");
			String[] strTestData1 = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					strRegionNames[1],
					objEvent_data.strEventName,
					strEventTemplate1,
					strResourceName1,
					strResourceType1,
					strstatusTypeNames[5] + "," + strstatusTypeNames[6] + ","
							+ strstatusTypeNames[7] + ","
							+ strstatusTypeNames[8] + ","
							+ strstatusTypeNames[9],
					"Verify mobile end condition", strEventStartTime,
					strEventEndTime, strSectionName1 };

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "MultiRegionEvent");
		}
		gstrResult = "PASS";
	}

}