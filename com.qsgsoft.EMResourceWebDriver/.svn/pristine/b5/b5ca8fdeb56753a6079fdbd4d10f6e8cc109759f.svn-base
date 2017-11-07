package requirementGroup.CreatingAndManagingEvents;

import static org.testng.AssertJUnit.assertTrue;
import java.util.Arrays;
import lib.dataObject.*;
import lib.module.NavigationToSubMenus;
import lib.page.*;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayMultiRegionEvent extends TestNG_UI_EXTENSIONS {

	public HappyDayMultiRegionEvent() throws Exception {
		super();
	}

	/******************************************************************************
	'Description	:Verify that admin user cannot Create/Edit 'Multi Region' event
	'Date	 		:7-Aug-2014
	'Author			:Anitha
	*******************************************************************************/

	@Test(description = "Verify that admin user cannot Create/Edit 'Multi Region' event.")
	public void testHappyDay139697() throws Exception {
		
		gstrTCID = "139697";
		gstrTO	 = "Verify that admin user cannot Create/Edit 'Multi Region' event.";

		Login_data objLogin_data = new Login_data();
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);

		login_page1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		RegionDefault_page1.selectFrame();

		EventManagement_page1.clickOnEventLink()
		
		.verifyEventManagementLinkIsNotDisplayed();
		
		gstrResult = "PASS";
	}
	
	
	/*******************************************************************************************************************
	'Description	: 	Verify that when a MRE is created to start immediately and end after a specific time period (say, 5 hrs), the event starts immediately and ends after the specified number of hours. 
	'Date	 		:	06-Aug-2014
	'Author			:	QSG
	********************************************************************************************************************/
	@Test(description = "Verify that when a MRE is created to start immediately and end after a specific time period (say, 5 hrs), the event starts immediately and ends after the specified number of hours. ")
	public void testPreCondition() throws Exception {

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		View_data objView_data = new View_data();
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(this.driver1);
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		Regions Regions_page = new Regions(this.driver1);
		ViewsList ViewsList_page = new ViewsList(this.driver1);
		
		String strstatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		String strstatusTypeValues1[] = new String[5];
		String strResourceTypeValue1[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strRegionValue[] = new String[2];
		
		String strFilePath = Login_data.strTestDataPath;
		OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
		
		boolean blnTest = false;
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		
		UsersList UsersList_page1 = new UsersList(this.driver1);
		
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
		
		NavigationToSubMenus_page.navigateToViews();
		
		ViewsList_page.createNewSection(objView_data.strSectionName);
		
		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeListNew()
					
		.createStatusTypeWithSection(objStatuTypes_data.strNumberStatusType,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusTypeWithSection(objStatuTypes_data.strTextStatusType,
						objStatuTypes_data.strTSTStatusTypeName,
						objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
	
		StatusTypeList_page.createStatusTypeWithSection(objStatuTypes_data.strSaturationScoreStatusType,
						objStatuTypes_data.strSSTStatusTypeName,
						objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[2] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
				
		StatusTypeList_page.createStatusTypeWithSection(objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[3] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		StatusTypeList_page.createStatusTypeWithSection(objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		StatusTypeList_page.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
				objStatuTypes_data.strStatusColor)
	.createNewStatus(objStatuTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor)
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

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)

		.deselectSelectAllWebOption();
//
//		login_page.clickLogOut();
//		
//		login_page.loginToApplication(objTest_data.strUserName,
//				objTest_data.strPassword);
//
//		RegionDefault_page.selectFrame();
		
		RegionDefault_page.clickRegionLink();
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page.selectFrame();
		// RoleBased statustypes
		
		NavigationToSubMenus_page.navigateToViews();
		
		ViewsList_page.createNewSection(objView_data.strSectionName1);
		
		StatusTypeList_page.navigateToStatusTypeListNew()
					
		.createStatusTypeWithSection(objStatuTypes_data.strNumberStatusType,
						objStatuTypes_data.strNSTStatusTypeName1,
						objStatuTypes_data.strStatusDescription, objView_data.strSectionName1);

		strstatusTypeValues1[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		StatusTypeList_page.createStatusTypeWithSection(objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName1);
		
		strstatusTypeValues1[1] = StatusTypeList_page
		.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);
		
		StatusTypeList_page.createStatusTypeWithSection(objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName1);
		
		strstatusTypeValues1[2] = StatusTypeList_page
		.getStatusValue(objStatuTypes_data.strSSTStatusTypeName1);
		
		StatusTypeList_page.createStatusTypeWithSection(objStatuTypes_data.strNedocCalculationStatusType,
		objStatuTypes_data.strNDSTStatusTypeName1,
		objStatuTypes_data.strStatusDescription, objView_data.strSectionName1);
		
		strstatusTypeValues1[3] = StatusTypeList_page
		.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName1);
		
		StatusTypeList_page.createStatusTypeWithSection(objStatuTypes_data.strMultiStatusType,
		objStatuTypes_data.strMSTStatusTypeName1,
		objStatuTypes_data.strStatusDescription, objView_data.strSectionName1);
		
		StatusTypeList_page.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
				objStatuTypes_data.strStatusColor)
	.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,objStatuTypes_data.strStatusColor)
	.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
	.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
    .clickOnReturnToStatusTypeList();
		
		strstatusTypeValues1[4] = StatusTypeList_page
		.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

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

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate1,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue1,
				strstatusTypeValues1)

		.deselectSelectAllWebOption();

		login_page.clickLogOut();
		
	    blnTest =true;
	    
	    if (blnTest) {
	  
			String[] strTestData = { "139575", strRegionNames[0],
					strRegionNames[1],
					objStatuTypes_data.strNSTStatusTypeName,
					objStatuTypes_data.strTSTStatusTypeName,
					objStatuTypes_data.strSSTStatusTypeName,
					objStatuTypes_data.strNDSTStatusTypeName,
					objStatuTypes_data.strMSTStatusTypeName,
					
					objStatuTypes_data.strNSTStatusTypeName1,
					objStatuTypes_data.strTSTStatusTypeName1,
					objStatuTypes_data.strSSTStatusTypeName1,
					objStatuTypes_data.strNDSTStatusTypeName1,
					objStatuTypes_data.strMSTStatusTypeName1,
					objResourceType_data.strResourceTypeName,
					objResourceType_data.strResourceTypeName1,
					objResource_data.strResourceName, 
					objResource_data.strResourceName1, 
					objEventSetUp_data.strEventTemplate,
					objEventSetUp_data.strEventTemplate1,
					objView_data.strSectionName,
					objView_data.strSectionName1};
			objOffCommonFunc.writeResultDataToParticularRow(strTestData,
					strFilePath, "MultiRegionEvent", 1);
			
			String[] strTestData1 = { "139575", strRegionValue[0],
					strRegionValue[1],
					strstatusTypeValues[0], strstatusTypeValues[1],
					strstatusTypeValues[2], strstatusTypeValues[3],
					strstatusTypeValues[4], strstatusTypeValues1[0],
					strstatusTypeValues1[1],strstatusTypeValues1[2],
					strstatusTypeValues1[3], strstatusTypeValues1[4],
					strResourceTypeValue[0], strResourceTypeValue1[0], 
					strResourceValue[0] , strResourceValue1[0]};
			objOffCommonFunc.writeResultDataToParticularRow(strTestData1,
					strFilePath, "MultiRegionEvent", 2);
		}

		System.out
				.println("-----Precondition ends and test execution starts-------");

		
		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		RegionDefault_page1.selectFrame();
		
		RegionDefault_page1.clickRegionLink();
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);
		
		RegionDefault_page1.selectFrame();


		// User creation
		UsersList_page1
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				
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

		login_page1.clickLogOut();
		
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
	
		.verifyEventName(objEvent_data.strEventName);	
	}	
	
	/*******************************************************************************************************************
	 * 'Description : Verify that a MRE can be created selecting to start the
	 * event at specified date (say, 4:00 PM & day as x+1 where x is current
	 * date) and end after 4 hours 
	 * Date : 07-Aug-2014 
	 * 'Author : Anil
	 ********************************************************************************************************************/
	@Test(description = "Verify that a MRE can be created selecting to start the event at specified date (say, 4:00 PM & day as x+1 where x is current date) and end after 4 hours")
	public void testHappyDay139563() throws Exception {
		
		gstrTCID = "139563";
		gstrTO	 = "Verify that a MRE can be created selecting to start the event at specified date "
				+ "(say, 4:00 PM & day as x+1 where x is current date) and end after 4 hours";

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
		
		.verifyCancelEventLink(objEvent_data.strEventName);
		
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
	 * 'Description : Verify that a MRE can be created selecting to start & end the event at specified date & time (Start say, 4:00 PM & day as x+1 & end at 3:00 PM and day as x+2 where x is current date )
	 * Date : 07-Aug-2014 
	 * 'Author : Anil
	 ********************************************************************************************************************/
	@Test(description = "Verify that a MRE can be created selecting to start & end the event at specified date & time (Start say, 4:00 PM & day as x+1 & end at 3:00 PM and day as x+2 where x is current date )")
	public void testHappyDay139566() throws Exception {
		
		gstrTCID = "139566";
		gstrTO	 = "Verify that a MRE can be created selecting to start & end the event at specified date & time "
				+ "(Start say, 4:00 PM & day as x+1 & end at 3:00 PM and day as x+2 where x is current date )";

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

		RegionDefault_page1.clickRegionLink();
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		// Event creation
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()
		
		.verifyCreateMultiRegionEventPage()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

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
						strEventEndTime, stMultiStatus);

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
			
			gstrResult = "PASS";
		}
	}
	
	/*******************************************************************************************************************
	 * 'Description : Verify that the MRE starts immediately and does not display the end date when a MRE is created selecting to start immediately and to end never.
	 *  Date        : 07-Aug-2014 
	 * 'Author      : Anil
	 ********************************************************************************************************************/
	@Test(description = "Verify that the MRE starts immediately and does not display the end date when a MRE is created selecting to start immediately and to end never.")
	public void testHappyDay139480() throws Exception {
		
		gstrTCID = "139480";
		gstrTO	 = "Verify that the MRE starts immediately and does not display the end date when a MRE is "
				+ "created selecting to start immediately and to end never.";

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
		
		EventManagement_page1.clickOnNextButton()

				.clickOnKeepButton()
				
				.verifyMultiRegionEventConfirmationPage()

				.verifyRegionAndETName(strRegionNames[0], strEventTemplate)

				.verifyRegionAndETName(strRegionNames[1], strEventTemplate1)

				.clickOnYesButton()

				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						strEventStatus, strEventTemplate, strEventStartTime,
						strEventEndTime, stMultiStatus)

				.verifyEventNameInEventBanner(objEvent_data.strEventName);

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
	 * 'Description : Verify that a MRE can be created selecting to start the event at specified date & time (say, 4:00 PM & day as x+1 where x is current date) and to end never 
	 * Date : 23-Sep-2014 
	 * 'Author : Anil
	 ********************************************************************************************************************/
	@Test(description = "Verify that a MRE can be created selecting to start the event at specified date & time (say, 4:00 PM & day as x+1 where x is current date) and to end never ")
	public void testHappyDay139573() throws Exception {
		
		gstrTCID = "139573";
		gstrTO	 = "Verify that a MRE can be created selecting to start the event at specified date & time (say, 4:00 PM & day as x+1 where x is current date) and to end never ";

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

		String strEventEndTime = "never";
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
		
				.clickEventNeverEndRadioButton()

				.selectEventTemplateForMRE(strRegionValue[0], strEventTemplate)

				.selectEventTemplateForMRE(strRegionValue[1], strEventTemplate1)

				.clickOnNextButton()
				
				.clickOnKeepButton()

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
		
		.verifyCancelEventLink(objEvent_data.strEventName);
		
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
	 * 'Description : Verify that when a MRE is created to start immediately and end after a specific date & time (say, 5:00 PM on date X+1, where X is the current date), the event starts immediately and ends at the specified time on the date set (5:00 PM on date X+1) 
	 * Date : 07-Aug-2014 
	 * 'Author : Anil
	 ********************************************************************************************************************/
	@Test(description = "Verify that when a MRE is created to start immediately and end after a specific date & time (say, 5:00 PM on date X+1, where X is the current date), the event starts immediately and ends at the specified time on the date set (5:00 PM on date X+1) ")
	public void testHappyDay139086() throws Exception {
		
		gstrTCID = "139086";
		gstrTO	 = "Verify that when a MRE is created to start immediately and end after a specific date & time (say, 5:00 PM on date X+1, where X is the current date), the event starts immediately and ends at the specified time on the date set (5:00 PM on date X+1) ";

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
		
		.verifyEndEventLink(objEvent_data.strEventName);
		
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
	'Description	: 	Verify that resources are not included in the multi-region event created when 'Include all resources?' check box is deselected.
	'Date	 		:	07-Aug-2014
	'Author			:	Anil
	********************************************************************************************************************/
	@Test(description = "Verify that resources are not included in the multi-region event created when 'Include all resources?' check box is deselected.")
	public void testHappyDay139647() throws Exception {
		
		gstrTCID = "139647";
		gstrTO	 = "Verify that resources are not included in the multi-region event created when 'Include all resources?' check box is deselected.";

		Login_data objTest_data = new Login_data();

		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);

		UsersList UsersList_page = new UsersList(this.driver1);
		String strRegionValue[] = new String[2];
		
		String strFilePath = Login_data.strTestDataPath;
		OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
	
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		
		String strRegionNames[] = new String[2];
		
		strRegionNames[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 2, strFilePath);
		strRegionNames[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 3, strFilePath);
		
		strRegionValue[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 3, 2, strFilePath);
		strRegionValue[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 3, 3, strFilePath);
		
		String strResourceName = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 16, strFilePath);
		String strResourceName1 = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 17, strFilePath);
		
		String strResourceType = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 14, strFilePath);
		String strResourceType1 = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 15, strFilePath);
		
		String strEventTemplate = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 19, strFilePath);
		
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
				
				.selectUserRegion(strRegionValue[0])
				
				.selectUserRegion(strRegionValue[1])
				
				.clickSaveButton()
				
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
		
		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		// Event  creation		
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.deselectIncludeAllResourcesOption()
		
		.selectEventTemplateForMRE(strRegionValue[0], strEventTemplate)
		
		.selectEventTemplateForMRE(strRegionValue[1], strEventTemplate1)
				
		.clickOnNextButton()

		.verifyRegionName(strRegionNames[0])
		
		.verifyRSAndRTName(strResourceName, strResourceType)
				
		.clickOnNextButton()
		
		.verifyRegionName(strRegionNames[1])
				
		.verifyRSAndRTName(strResourceName1, strResourceType1)
				
		.clickOnNextButton()
		
		.clickOnYesButton()
		
		.verifyEventName(objEvent_data.strEventName);		
		
		gstrResult = "PASS";
	}
	/*******************************************************************************************************************
	'Description	: Verify that all the resources under the selected event template while creating a multi-region are
	                   added to the multi-region event when 'Include all resources?' checkbox is selected.
	'Date	 		: 07-Aug-2014
	'Author			: Anil
	********************************************************************************************************************/
	@Test(description = "Verify that all the resources under the selected event template while creating a multi-region"
		            	+ " are added to the multi-region event when 'Include all resources?' checkbox is selected.")
	public void testHappyDay139645() throws Exception {
		
		gstrTCID = "139645";
		gstrTO	 = "Verify that all the resources under the selected event template while creating a multi-region"
		            	+ " are added to the multi-region event when 'Include all resources?' checkbox is selected.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		String strFilePath = Login_data.strTestDataPath;
		OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
	
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		EventStatus EventStatus_Page1=new EventStatus(this.driver1);
		
		String strRegionNames[] = new String[2];
		String strRegionValue[] = new String[2];
		
		strRegionNames[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 2, strFilePath);
		strRegionNames[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 3, strFilePath);
		
		strRegionValue[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 3, 2, strFilePath);
		strRegionValue[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 3, 3, strFilePath);
		
		String strResourceName = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 16, strFilePath);
		String strResourceName1 = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 17, strFilePath);
		
		String strEventTemplate = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 19, strFilePath);
		
		System.out
				.println("-----Precondition execution starts-------");

		
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
				
				.selectUserRegion(strRegionValue[0])
				
				.selectUserRegion(strRegionValue[1])
				
				.clickSaveButton()
				
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
		
		login_page.clickLogOut();
		
		System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		//RegionDefault_page.clickRegionLink();
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);
		
		RegionDefault_page1.selectFrame();

		// Event  creation		
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		
		.selectEventTemplateForMRE(strRegionValue[0], strEventTemplate)
		
		.selectEventTemplateForMRE(strRegionValue[1], strEventTemplate1)
				
		.clickOnNextButton()
				
		/*.clickOnNextButton()
				
		.clickOnNextButton()*/
		
		.clickOnYesButton()
		
		.clickOnEventNameInEventBanner(objEvent_data.strEventName);	
		
		EventStatus_Page1.verifyResourceInEventBanner(strResourceName);
		
		login_page1.clickLogOut();
		
		login_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page1.selectFrame();
		
		EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		EventStatus_Page1.verifyResourceInEventBanner(strResourceName1);
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	'Description	: Verify that multi-region event can be created by deselecting the option 'Display in Event Banner'.
	'Date	 		: 07-Aug-2014
	'Author			: Anitha
	********************************************************************************************************************/
	@Test(description = "Verify that multi-region event can be created by deselecting the option 'Display in Event Banner'.")
	public void testHappyDay139594() throws Exception {
		
		gstrTCID = "139594";
		gstrTO	 = "Verify that multi-region event can be created by deselecting the option 'Display in Event Banner'.";

		boolean blnTest = false;
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		String strFilePath = Login_data.strTestDataPath;
		OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
	
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		
		String strRegionNames[] = new String[2];
		String strRegionValue[] = new String[2];
		
		strRegionNames[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 2, strFilePath);
		strRegionNames[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 3, strFilePath);
		
		strRegionValue[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 3, 2, strFilePath);
		strRegionValue[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 3, 3, strFilePath);
		
		String strResourceName = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 16, strFilePath);
		String strResourceName1 = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 17, strFilePath);
		
		String strEventTemplate = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel("MultiRegionEvent", 2, 19, strFilePath);
		
		System.out
				.println("-----Precondition execution starts-------");

		
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
				
				.selectUserRegion(strRegionValue[0])
				
				.selectUserRegion(strRegionValue[1])
				
				.clickSaveButton()
				
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
		
		login_page.clickLogOut();
		
		System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();
		
		// Event  creation		
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()

		.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
		
		.deSelectCheckBoxOfDisplayInEventBanner()

		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		
		.selectEventTemplateForMRE(strRegionValue[0], strEventTemplate)
		
		.selectEventTemplateForMRE(strRegionValue[1], strEventTemplate1)
				
		.clickOnNextButton()
		
		.clickOnYesButton()
		
		.verifyEventNameNotDisplayedInEventBanner(objEvent_data.strMultiRegionEvent);
		
		login_page1.clickLogOut();
		
		login_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page1.selectFrame();
		
		EventManagement_page1.verifyEventNameNotDisplayedInEventBanner(objEvent_data.strMultiRegionEvent);
		
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
					"",
					"",
					"Verify mobile end condition", "",
					"", "" };

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
					strResourceName,
					"",
					"",
					"Verify mobile end condition", "",
					"", "" };

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "MultiRegionEvent");
		}
		
		gstrResult = "PASS";
	}
	
	
	
	/*******************************************************************************************************************
	 * 'Description : Verify that when a MRE is created to start immediately and end after a specific time period
	                 (say, 5 hrs), the event starts immediately and ends after the specified number of hours. 
	 * Date : 07-Aug-2014 
	 * 'Author : Anil
	 ********************************************************************************************************************/
	@Test(description = " Verify that when a MRE is created to start immediately and end after a specific time period"+
	                 "(say, 5 hrs), the event starts immediately and ends after the specified number of hours.")
	public void testHappyDay139575() throws Exception {
		
		gstrTCID = "139575";
		gstrTO	 = "Verify that when a MRE is created to start immediately and end after a specific time period"+
	                 "(say, 5 hrs), the event starts immediately and ends after the specified number of hours. ";

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

		.verifyMultiEventInformationField()

		.verifyMultiEventTitleField()

		.verifyLatitudeLongitudeTextIsDisplayed()
		
		.verifyLatitudeIsDisplayed()
		
		.verifyLongitudeIsDisplayed()
		
		.verifyBrowseButtonIsDisplayed()

		.verifyRegionNameAndETName(strRegionNames[0], strEventTemplate)
		
		.verifyRegionNameAndETName(strRegionNames[1], strEventTemplate1)
		
		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

		strEventStartTime = EventManagement_page1.getEventStartDateAndTime();

		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");

		strEventEndTime = objDts.addTimetoExistingHour(
				strEventStartTime, 4, "yyyy MMM dd HH mm");

		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");

		strEventEndTime = objDts.converDateFormat(strEventEndTime,
				"yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");

			
		EventManagement_page1.enterEventEndTime(objEvent_data.strEventEndTimeInHours1)

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
				
				.verifyEndEventLink(objEvent_data.strEventName)
								
				.verifyEventNameInEventBanner(objEvent_data.strEventName);
		
		login_page1.clickLogOut();

		login_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		RegionDefault_page1.clickRegionLink();
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()

				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						strEventStatus, strEventTemplate1, strEventStartTime,
						strEventEndTime, stMultiStatus)

				.verifyEditEventLink(objEvent_data.strEventName)
				
				.verifyEndEventLink(objEvent_data.strEventName)
	
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
	 * 'Description :  Verify that multi-region event can be modified by clicking on 'Modify' button on 'Multi-Region Event Confirmation' page
	 * Date : 07-Aug-2014 
	 * 'Author : Anil
	 ********************************************************************************************************************/
	@Test(description = "Verify that multi-region event can be modified by clicking on 'Modify' button on 'Multi-Region Event Confirmation' page")
	public void testHappyDay139693() throws Exception {
		
		gstrTCID = "139693";
		gstrTO	 = "Verify that multi-region event can be modified by clicking on 'Modify' button on 'Multi-Region Event Confirmation' page";

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
		System.out.println(objUser_data.strNewPassword);
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

		RegionDefault_page1.clickRegionLink();
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		// Event creation
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()
		
		.verifyCreateMultiRegionEventPage()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription);

	    strEventStartTime = EventManagement_page1.getEventStartDateAndTime();
	    
	    strEventStartTime = objDts.AddDaytoExistingDate(strEventStartTime, 1, "yyyy-MMM-dd HH:mm");
	    
	    strEventStartTime = objDts.converDateFormat(strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");	    
	    
	    String strStartTime[]  = strEventStartTime.split(" ");
	    
	    EventManagement_page1.selectEventStartDateAndTime(strStartTime);
		
		strEventEndTime = objDts.AddDaytoExistingDate(strEventStartTime, 30, "yyyy MMM dd HH mm");
	
	    String strEndTime[]  = strEventEndTime.split(" ");

	    strEventStartTime = strStartTime[0]+" "+strStartTime[1]+" "+strStartTime[2]+" "+strStartTime[3]+" "+strStartTime[4];
	
	    strEventEndTime = strEndTime[0]+" "+strEndTime[1]+" "+strEndTime[2]+" "+strEndTime[3]+" "+strEndTime[4];
	    
		strEventEndTime = objDts.converDateFormat(strEventEndTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
	
		strEventStartTime = objDts.converDateFormat(strEventStartTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
	    
		EventManagement_page1
				.selectEventEndDateAndTime(strEndTime)

				.selectEventTemplateForMRE(strRegionValue[0], strEventTemplate)

				.selectEventTemplateForMRE(strRegionValue[1], strEventTemplate1)

				.clickOnNextButton()

				.verifyMultiRegionEventConfirmationPage()

				.verifyKeepButtonIsDisplayed()
				
				.verifyModifyButtonIsDisplayed()
				
				.verifyTextMessageIsDisplayed()
				
				.clickOnKeepButton()
				
				.verifyRegionAndETName(strRegionNames[0], strEventTemplate)

				.verifyRegionAndETName(strRegionNames[1], strEventTemplate1)
				
				.verifyConfirmationMessage()

				.clickOnYesButton()

				.verifyMultiRegionEventDetails(objEvent_data.strEventName,
						strEventStatus, strEventTemplate, strEventStartTime,
						strEventEndTime, stMultiStatus);

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
			
			gstrResult = "PASS";
		}
	}
	
	/*******************************************************************************************************************
	 * Description 	: Verify that multi-region event can be created selecting a event template in which
	                   'Mandatory address' check box is selected. 
	 * Date         : 27-Nov-2014 
	 * Author      	: Renushree
	 ********************************************************************************************************************/
	@Test(description = " Verify that multi-region event can be created selecting a event template in which 'Mandatory address'"
			+ "  check box is selected.")
	public void testHappyDay139634() throws Exception {

		gstrTCID = "139634";
		gstrTO = " Verify that multi-region event can be created selecting a event template in which 'Mandatory address' "
				+ "check box is selected.";

		Login_data objTest_data = new Login_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
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
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
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
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		String strResourceTypeVal = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 3, 14, strFilePath);
		String strResourceType1Val = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 3, 15, strFilePath);

		String strStatusTypeNamesInReg1[] = new String[5];

		for (int intCount = 0; intCount < 5; intCount++) {
			strStatusTypeNamesInReg1[intCount] = objOffCommonFunc
					.readInfoExcel("MultiRegionEvent", 2, 4 + intCount,
							strFilePath);
		}

		String strStatusTypeValuesInReg1[] = new String[5];
		for (int intCount = 0; intCount < 5; intCount++) {
			strStatusTypeValuesInReg1[intCount] = objOffCommonFunc
					.readInfoExcel("MultiRegionEvent", 3, 4 + intCount,
							strFilePath);
		}

		String strStatusTypeValuesInReg2[] = new String[5];
		for (int intCount = 0; intCount < 5; intCount++) {
			strStatusTypeValuesInReg2[intCount] = objOffCommonFunc
					.readInfoExcel("MultiRegionEvent", 3, 9 + intCount,
							strFilePath);
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
				.enterAllUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName,
						objUser_data.strFirstName, objUser_data.strMiddleName,
						objUser_data.strLastName, objUser_data.strOrganization,
						objUser_data.strPhone, objUser_data.strPrimaryMailId,
						objUser_data.strPrimaryMailId,
						objUser_data.strPrimaryMailId)
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

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceTypeVal);

		for (int intCount = 0; intCount < strStatusTypeValuesInReg1.length; intCount++) {
			objEventSetUp.selectStatusType(strStatusTypeValuesInReg1[intCount]);
		}

		objEventSetUp
				.selMandatoryAddInCreateTemplatePage()
				.selectMultiRegionOption()
				.clickSaveButton()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

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
				.clickSaveButton().enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate1)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceType1Val);

		for (int intCount = 0; intCount < strStatusTypeValuesInReg2.length; intCount++) {
			objEventSetUp.selectStatusType(strStatusTypeValuesInReg2[intCount]);
		}

		objEventSetUp
				.selMandatoryAddInCreateTemplatePage()
				.selectMultiRegionOption()
				.clickSaveButton()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate1)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		String strEventTemplateWithAddressReq = objEventSetUp_data.strEventTemplate
				+ " (address required)";
		String strEventTemplate1WithAddressReq = objEventSetUp_data.strEventTemplate1
				+ " (address required)";

		EventManagement_page1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.enterAddress(objEvent_data.strCity, objEvent_data.strState,
						objEvent_data.strCounty, objEvent_data.strZipcode)
				.selectEventTemplateForMRE(strRegionValue[0],
						strEventTemplateWithAddressReq)
				.selectEventTemplateForMRE(strRegionValue[1],
						strEventTemplate1WithAddressReq).clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage().clickOnYesButton()
				.verifyEventName(objEvent_data.strEventName);

		String strEventStartDateAndTime = EventManagement_page1
				.getEventStartTime(objEvent_data.strEventName);

		strEventStartDateAndTime = objDts.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH mm", "MM/dd/yy HH mm");

		EventManagement_page1
				.verWebNotificationframe()
				.verWebNotificationWithAddress(objEvent_data.strEventName,
						objEvent_data.strEventDescription,
						objEvent_data.strCity,
						objEvent_data.strCounty,
						objEvent_data.strZipcode, objEvent_data.strCountryCode)
				.clickAcknowledgeAllNotifications()
				.selectFrame()
				.clickOnEventNameInEventBanner(objEvent_data.strEventName)
				.verifyCreatedByDescAndAdd(objUser_data.strFullName,
						strEventStartDateAndTime,
						objEvent_data.strEventDescription,
						objEvent_data.strCity,
						objEvent_data.strCounty,
						objEvent_data.strZipcode,objEvent_data.strCountryCode);

		login_page1.clickLogOut();
	
		String strMsgBody1 = "Event Notice for: " + objUser_data.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "Location: " + objEvent_data.strCity + ", "+objEvent_data.strCountryCode+" "
				+ objEvent_data.strZipcode + " "
				+ objEvent_data.strCounty + "\n\n" + "From: "
				+ objUser_data.strFullName + "\n\n" + "Regions: "
				+ strRegionNames[0]+", "+strRegionNames[1]
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUser_data.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strEventDescription + "\nLocation: "
				+ objEvent_data.strCity + ", "+objEvent_data.strCountryCode+" "
				+ objEvent_data.strZipcode + " "
				+ objEvent_data.strCounty + "\nFrom: "
				+ objUser_data.strFullName + "\nRegions: "
				+ strRegionNames[0]+", "+strRegionNames[1];

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
}