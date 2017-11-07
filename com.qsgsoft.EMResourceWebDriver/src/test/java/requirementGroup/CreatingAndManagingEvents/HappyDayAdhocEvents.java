package requirementGroup.CreatingAndManagingEvents;

import static org.testng.AssertJUnit.assertTrue;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
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

public class HappyDayAdhocEvents extends TestNG_UI_EXTENSIONS {
	/**
	 * Test script to test login
	 * @throws Exception
	 */
	
	public HappyDayAdhocEvents() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***************************************************************************************
	'Description	:Verify that resources are not included in the Ad Hoc event created when
	                 resources are not selected while creating an event.
	'Date	 		:6-June-2014
	'Author			:Anil
	***************************************************************************************/

	@Test(description = "Verify that resources are not included in the Ad Hoc event created when resources are not selected while creating an event.")
	public void testHappyDay140373() throws Exception{
		
		gstrTCID = "140373";
		gstrTO	 = "Verify that resources are not included in the Ad Hoc event created when resources are not selected while creating an event.";
	
		Login login_page = new Login(this.driver1);
		Login_data objTest_data = new Login_data();
		Event_data objEvent_data=new Event_data();
		User_data objUser_data = new User_data();
	    SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
	    RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
	    UsersList UsersList_page = new UsersList(this.driver1);	 
	    
	    RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
	    Login login_page1 = new Login(this.driver1);
	    EventManagement EventManagement_page1 = new EventManagement(this.driver1); 
	    EventStatus EventStatus_page1 = new EventStatus(this.driver1); 
	    Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	    
	    login_page.loginToApplication(objTest_data.strUserName, objTest_data.strPassword);
	    
	    SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);
	    
	    RegionDefault_page.selectFrame();
	    
	    UsersList_page.navigateToUsers();    
	
	    UsersList_page.clickCreateNewUserButton();
	    
	    UsersList_page.enterUserDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName);
	    
	    UsersList_page. clickAdvancedOptionAndExpand();
	    
	    UsersList_page.selectMaintainEventsOption();
	    
	    UsersList_page.selectMaintainAdHocEventsOption();
	    
	    UsersList_page.clickSaveButton();
	    	    
	    login_page.clickLogOut();
	    
	    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	
	    RegionDefault_page1.selectFrame();
	    
	    System.out.println(objUser_data.strNewUserName);
	    
	    RegionDefault_page1.verifyRegionDefaultPage(); 
	
	    EventManagement_page1.navigateToEventManagement();
	    
	    EventManagement_page1.verifyCreateEventButtonsDisplayed();
	    
	    EventManagement_page1.clickOnCreateAdHocEventButton();
	    
	    EventManagement_page1.enterAdHocEventDetails(objEvent_data.strEventName, objEvent_data.strEventDescription);
	
	    objEvent_data.strEventStartTime = EventManagement_page1.getEventStartDateAndTime();
	    
	    objEvent_data.strEventStartTime = objDate_Time_settings.converDateFormat(objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");
	    		
	    objEvent_data.strEventEndTime = objDate_Time_settings.addTimetoExistingHour(objEvent_data.strEventStartTime,5, "yyyy-MM-dd HH:mm");
	    
	    EventManagement_page1.enterEventEndTime(objEvent_data.strEventEndTimeInHours);
	    
	    EventManagement_page1.clickOnNextButton();
	    
	    EventManagement_page1.verifyResourceDetails();
	    
	    EventManagement_page1.clickOnNextButton();
	    
	 //   EventManagement_page1.verifyStatusTypeDetails();
	    
	    EventManagement_page1.clickOnNextButton();
	    
	    EventManagement_page1.verifyAdHocEventConfirmationDisplayed();
	    
	    EventManagement_page1.clickOnYesButton();
	    
	    EventManagement_page1.verifyEventName(objEvent_data.strEventName);
	    
	    EventManagement_page1.verifyEventStartTime(objEvent_data.strEventName, objEvent_data.strEventStartTime);
	
	    EventManagement_page1.verifyEventEndTime(objEvent_data.strEventName, objEvent_data.strEventEndTime);
	
	    EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
	    
	    EventStatus_page1.verifyEventStatus();
	    
	    EventStatus_page1.verifyMessageDisplayed();
	    
	    gstrResult = "PASS";
	}
	
	/***************************************************************************************
	'Description	:Verify that user with 'Maintain Events'right cannot Create/Edit an 'Ad Hoc' event
	'Date	 		:6-June-2014
	'Author			:Anitha 
	***************************************************************************************/
	
	@Test (description = "Verify that user with 'Maintain Events'right cannot Create/Edit an 'Ad Hoc' event")
	public void testHappyDay140374() throws Exception{
		
		gstrTCID = "140374";
		gstrTO	 = "Verify that user with 'Maintain Events'right cannot Create/Edit an 'Ad Hoc' event";
	
		Login login_page = new Login(this.driver1);
		Login_data objTest_data = new Login_data();
		User_data objUser_data=new User_data();
		Event_data objEvent_data=new Event_data();
	    SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
	    RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
	    UsersList UsersList_page = new UsersList(this.driver1);	    
	    EventManagement EventManagement_page = new EventManagement(this.driver1);
	    
	    RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
	    Login login_page1 = new Login(this.driver1);
	    EventManagement EventManagement_page1 = new EventManagement(this.driver1); 
	    
	    login_page.loginToApplication(objTest_data.strUserName, objTest_data.strPassword);
	    
	    SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);
	    
	    RegionDefault_page.selectFrame();
	    
	    UsersList_page.navigateToUsers();    
	
	    UsersList_page.clickCreateNewUserButton();
	    
	    UsersList_page.enterUserDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName);
	    
	    UsersList_page. clickAdvancedOptionAndExpand();
	    
	    UsersList_page.selectMaintainEventsOption();
	    
	    UsersList_page.clickSaveButton();
	    		
	    UsersList_page.clickCreateNewUserButton();
	    
	    UsersList_page.enterUserDetails(objUser_data.strNewUserName1, objUser_data.strNewPassword, objUser_data.strFullName);
	    
	    UsersList_page.selectFirstRole();
	    
	    UsersList_page. clickAdvancedOptionAndExpand();
	    
	    UsersList_page.selectMaintainAdHocEventsOption();
	    
	    UsersList_page.selectMaintainEventsOption();
	    
	    UsersList_page.clickSaveButton();
	    
	    login_page.clickLogOut();
	    
	    login_page.loginAsNewUser(objUser_data.strNewUserName1, objUser_data.strNewPassword);
		
	    RegionDefault_page.selectFrame();
	    
	    EventManagement_page.navigateToEventManagement();
	    
	    EventManagement_page.clickOnCreateAdHocEventButton();
	    
	    EventManagement_page.createAdHocEvent(objEvent_data.strEventName, objEvent_data.strEventDescription);
	    
	    objEvent_data.strEventStartTime = EventManagement_page.getEventStartTime(objEvent_data.strEventName);
	    
	    objEvent_data.strEventEndTime =  EventManagement_page.getEventEndTime(objEvent_data.strEventName);
	    
	    login_page.clickLogOut();
	    
	    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	
	    RegionDefault_page1.selectFrame();
	    
	    RegionDefault_page1.verifyRegionDefaultPage(); 
	
	    EventManagement_page1.navigateToEventManagement();
	    
	    EventManagement_page1.verifyAdHocEventButtonNotDisplayed();
	    
	    EventManagement_page1.verifyEventDetails(objEvent_data.strEventName, objEvent_data.strEventStartTime, objEvent_data.strEventEndTime);
	    
	    gstrResult = "PASS";	
	}

	/********************************************************************************
	'Description	:Edit an Ad Hoc event and change the end time and verify that the 
	                 event ends at the newly provided time.
	'Date	 		:23-June-2014
	'Author			:Sowmya
	**********************************************************************************/
	@Test(description = "Edit an Ad Hoc event and change the end time and verify that the event " +
			"ends at the newly provided time.")
	public void testHappyDay140388() throws Exception {
		
		gstrTCID = "140388";
		gstrTO	 = "Edit an Ad Hoc event and change the end time and verify that the event " +
			"ends at the newly provided time.";
	
		Event_data objEvent_data = new Event_data();
		Date_Time_settings objDts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Login_data objTest_data = new Login_data();
		OfficeCommonFunctions objOfficeCommonFunctions = new OfficeCommonFunctions();

		String strFilePath = objTest_data.strTestDataPath;
		String strFilePath1 = objTest_data.strPartialAutoResultsPath;

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		ResourceType ResourceType_Page1 = new ResourceType(this.driver1);
		Resource Resource_Page1 = new Resource(this.driver1);
		
		String strRegionName[] = new String[1];
		String strstatusTypeNames[] = new String[10];
		String strstatusTypeValues[] = new String[10];
		String strResourceName[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeName[] = new String[1];
		String strUserNameAndPwd[] = new String[2];
	
		strRegionName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
	
		strUserNameAndPwd[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 15, strFilePath);
		strUserNameAndPwd[1] = objOffCommonFunc.readInfoExcel("TestData", 2, 16, strFilePath);
	
		strResourceTypeName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 13, strFilePath);
		strResourceName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
		strResourceValue[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
	
		strstatusTypeNames[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 3, strFilePath);
		strstatusTypeNames[1] = objOffCommonFunc.readInfoExcel("TestData", 2, 4, strFilePath);
		strstatusTypeNames[2] = objOffCommonFunc.readInfoExcel("TestData", 2, 5, strFilePath);
		strstatusTypeNames[3] = objOffCommonFunc.readInfoExcel("TestData", 2, 6, strFilePath);
		strstatusTypeNames[4] = objOffCommonFunc.readInfoExcel("TestData", 2, 7, strFilePath);
		strstatusTypeNames[5] = objOffCommonFunc.readInfoExcel("TestData", 2, 8, strFilePath);
		strstatusTypeNames[6] = objOffCommonFunc.readInfoExcel("TestData", 2, 9, strFilePath);
		strstatusTypeNames[7] = objOffCommonFunc.readInfoExcel("TestData", 2, 10, strFilePath);
		strstatusTypeNames[8] = objOffCommonFunc.readInfoExcel("TestData", 2, 11, strFilePath);
		strstatusTypeNames[9] = objOffCommonFunc.readInfoExcel("TestData", 2, 12, strFilePath);
	
		strstatusTypeValues[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);
		strstatusTypeValues[1] = objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);
		strstatusTypeValues[2] = objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
		strstatusTypeValues[3] = objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
		strstatusTypeValues[4] = objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
		strstatusTypeValues[5] = objOffCommonFunc.readInfoExcel("TestData", 3, 8, strFilePath);
		strstatusTypeValues[6] = objOffCommonFunc.readInfoExcel("TestData", 3, 9, strFilePath);
		strstatusTypeValues[7] = objOffCommonFunc.readInfoExcel("TestData", 3, 10, strFilePath);
		strstatusTypeValues[8] = objOffCommonFunc.readInfoExcel("TestData", 3, 11, strFilePath);
		strstatusTypeValues[9] = objOffCommonFunc.readInfoExcel("TestData", 3, 12, strFilePath);
	
		System.out.println("-----Precondition ends and test execution starts-------");
	
		login_page1.loginToApplication(strUserNameAndPwd[0],
				strUserNameAndPwd[1]);
	
		RegionDefault_page1.selectFrame();
	
		EventManagement_page1.navigateToEventManagement()
				             .clickOnCreateAdHocEventButton()
				             .enterAdHocEventName(objEvent_data.strEventName)
				             .enterAdHocEventDescription(objEvent_data.strEventDescription);
	
		String strEventStartTime = EventManagement_page1.getEventStartDateAndTime();
	
		objEvent_data.strEventStartTime = objDts.converDateFormat(strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");
	
		EventManagement_page1.clickOnNextButton()
				             .verifySelectResourcesDisplayed();
	
		Resource_Page1.clickResource(strResourceValue);
	
		EventManagement_page1.clickOnNextButton()
				             .verifySelectStatusTypesDisplayed();
	
		String[] strStatusTypeNames = { strstatusTypeNames[7],
				strstatusTypeNames[9], strstatusTypeNames[5],
				strstatusTypeNames[8], strstatusTypeNames[6],
				strstatusTypeNames[2], strstatusTypeNames[4],
				strstatusTypeNames[0], strstatusTypeNames[3],
				strstatusTypeNames[1] };
	
		EventManagement_page1
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypeNames);
	
		String[] strStatusTypeValues = { strstatusTypeValues[7],
				strstatusTypeValues[9], strstatusTypeValues[5],
				strstatusTypeValues[8], strstatusTypeValues[6],
				strstatusTypeValues[2], strstatusTypeValues[4],
				strstatusTypeValues[0], strstatusTypeValues[3],
				strstatusTypeValues[1] };
	
		ResourceType_Page1.clickStatusType(strStatusTypeValues);
		
		EventManagement_page1.clickOnNextButton()
				             .clickOnYesButton();
		
		String strActualTime = EventManagement_page1.verifyEventStartTimeNew(
				objEvent_data.strEventName, objEvent_data.strEventStartTime);
	
		objEvent_data.strEventEndTime = objDts.AddDaytoExistingDate(strActualTime, 1, "yyyy-MM-dd HH:mm");
	
		EventManagement_page1.verifyEventEndTime(objEvent_data.strEventName,objEvent_data.strEventEndTime);
	
		EventManagement_page1.verifyEditEventLink(objEvent_data.strEventName)
				             .verifyEndEventLink(objEvent_data.strEventName)
				             .clickOnEditLink(objEvent_data.strEventName);
		
		objEvent_data.strGetEventStartTime = objDts.AddTimeToExistingTimeHourAndMin(objEvent_data.strEventEndTime, 0, 30, "yyyy-MM-dd HH:mm");
	
		objEvent_data.strGetEventStartTime = objDts.converDateFormat(objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm", "yyyy MMM dd HH mm");
	
		String strUpdatedEventEndTime = objDts.converDateFormat(objEvent_data.strGetEventStartTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
	
		String strEndTime[] = objEvent_data.strGetEventStartTime.split(" ");
	
		EventManagement_page1.selectEventEndDateAndTime(strEndTime);
	
		EventManagement_page1.clickOnNextButton()
				             .verifySelectResourcesDisplayed()
				             .clickOnNextButton()
				             .verifySelectStatusTypesDisplayed()
				             .clickOnNextButton()
				             .verifyAdHocEventConfirmationDisplayed()
				             .clickOnYesButton();
	
		EventManagement_page1.verifyEventStartTime(objEvent_data.strEventName, strActualTime)
		                     .verifyEventEndTime(objEvent_data.strEventName, strUpdatedEventEndTime);
		
		String[] strTestData = {
				"140388",
				objTest_data.strRegionName,
				strstatusTypeNames[7] + " " + strstatusTypeNames[9] + " "
						+ strstatusTypeNames[5] + " " + strstatusTypeNames[8]
						+ " " + strstatusTypeNames[6] + " "
						+ strstatusTypeNames[2] + " " + strstatusTypeNames[4]
						+ " " + strstatusTypeNames[0] + " "
						+ strstatusTypeNames[3] + " " + strstatusTypeNames[1],
				strResourceTypeName[0], strResourceName[0],
				objEvent_data.strEventStartTime, " ",
				objEvent_data.strEventEndTime, strUpdatedEventEndTime };
		
		objOfficeCommonFunctions.writeResultData(strTestData, strFilePath1,
				"AdhocEvents");

		gstrResult = "PASS";
	}

	/*****************************************************************************
	'Description	:Verify that a never ending Ad Hoc event can be edited to end after certain number of hours. 
	'Date	 		:22-June-2014
	'Author			:QSG
	*******************************************************************************/
	@Test(description = "Verify that a never ending Ad Hoc event can be edited to end after certain number of hours.")
	public void testHappyDay140389() throws Exception {
		
		gstrTCID = "140389";
		gstrTO	 = "Verify that a never ending Ad Hoc event can be edited to end after certain number of hours.";
	
		String strTCID = "140389";
		Event_data objEvent_data=new Event_data();
		Date_Time_settings objDts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
		Login_data objLogin_data = new Login_data();

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
		EventManagement EventManagement_page1=new EventManagement(this.driver1);
		ResourceType ResourceType_Page1=new ResourceType(this.driver1);
		Resource Resource_Page1 =new Resource(this.driver1);
		String strRegionName[]=new String[1];
		String strstatusTypeNames[]=new String[10];
		String strstatusTypeValues[]=new String[10];
		String strResourceName[]=new String[1];
		String strResourceValue[]=new String[1];
		String strResourceTypeName[]=new String[1];
		String strUserNameAndPwd[]=new String[2];
		
		String strFilePath = objLogin_data.strTestDataPath;
		strRegionName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
		
		strUserNameAndPwd[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 15, strFilePath);
		strUserNameAndPwd[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 16, strFilePath);
		
		strResourceTypeName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 13, strFilePath);
		strResourceName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
		strResourceValue[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
		
		strstatusTypeNames[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 3, strFilePath);	
		strstatusTypeNames[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 4, strFilePath);		
		strstatusTypeNames[2]=objOffCommonFunc.readInfoExcel("TestData", 2, 5, strFilePath);
		strstatusTypeNames[3]=objOffCommonFunc.readInfoExcel("TestData", 2, 6, strFilePath);
		strstatusTypeNames[4]=objOffCommonFunc.readInfoExcel("TestData", 2, 7, strFilePath);
		strstatusTypeNames[5]=objOffCommonFunc.readInfoExcel("TestData", 2, 8, strFilePath);
		strstatusTypeNames[6]=objOffCommonFunc.readInfoExcel("TestData", 2, 9, strFilePath);
		strstatusTypeNames[7]=objOffCommonFunc.readInfoExcel("TestData", 2, 10, strFilePath);
		strstatusTypeNames[8]=objOffCommonFunc.readInfoExcel("TestData", 2, 11, strFilePath);
		strstatusTypeNames[9]=objOffCommonFunc.readInfoExcel("TestData", 2, 12, strFilePath);
			
		strstatusTypeValues[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);	
		strstatusTypeValues[1]=objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);		
		strstatusTypeValues[2]=objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
		strstatusTypeValues[3]=objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
		strstatusTypeValues[4]=objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
		strstatusTypeValues[5]=objOffCommonFunc.readInfoExcel("TestData", 3, 8, strFilePath);
		strstatusTypeValues[6]=objOffCommonFunc.readInfoExcel("TestData", 3, 9, strFilePath);
		strstatusTypeValues[7]=objOffCommonFunc.readInfoExcel("TestData", 3, 10, strFilePath);
		strstatusTypeValues[8]=objOffCommonFunc.readInfoExcel("TestData", 3, 11, strFilePath);
		strstatusTypeValues[9]=objOffCommonFunc.readInfoExcel("TestData", 3, 12, strFilePath);
		   
	  System.out.println("-----Precondition ends and test execution starts-------");
	
		login_page1.loginToApplication(strUserNameAndPwd[0],
				strUserNameAndPwd[1]);
	
		RegionDefault_page1.selectFrame();
	
		EventManagement_page1.navigateToEventManagement()
		
		.clickOnCreateAdHocEventButton()
		
		.enterAdHocEventDetails(
				objEvent_data.strEventName, objEvent_data.strEventDescription);
	
		objEvent_data.strEventStartTime = EventManagement_page1
				.getEventStartDateAndTime();
	
	    objEvent_data.strEventStartTime = objDts.addTimetoExisting(objEvent_data.strEventStartTime, 10, "yyyy-MMM-dd HH:mm");
	    
	    objEvent_data.strEventStartTime = objDts.converDateFormat(objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");	    
	    
	    String strStartTime[]  = objEvent_data.strEventStartTime.split(" ");
	    
	    EventManagement_page1.selectEventStartDateAndTime(strStartTime);
	    
		objEvent_data.strEventStartTime = objDts.converDateFormat(
				objEvent_data.strEventStartTime, "yyyy MMM dd HH mm",
				"yyyy-MM-dd HH:mm");
	
		EventManagement_page1
				.clickEventNeverEndRadioButton()
				
	            .clickOnNextButton()
	            
	            .clickOnKeepButton()
		
		.verifyResourceInSelectResourcePage(strResourceValue);
	
		Resource_Page1.clickResource(strResourceValue);
	
		EventManagement_page1.clickOnNextButton()
		
		.verifyStatusTypesInSelectStausTypePage(strstatusTypeValues);
	
		ResourceType_Page1.clickStatusType(strstatusTypeValues);
	
		EventManagement_page1.clickOnNextButton()
		
		.clickOnYesButton()
	
		.verifyEventName(objEvent_data.strEventName)
	
		.verifyEventStartTime(objEvent_data.strEventName,
				objEvent_data.strEventStartTime)
	
		.verifyEventEndTimeWhenItSetToNever(objEvent_data.strEventName,
				objEvent_data.strEndNever)
	
		.clickOnEditLink(objEvent_data.strEventName)
		
		.selectEventEndHourOption()
		
		.enterEventEndTime(objEvent_data.strEventEndTimeInHours)
		
		.clickOnNextButton()
		
		.clickOnNextButton()
		
		.clickOnNextButton()
		
		.clickOnYesButton();
		
		objEvent_data.strEventEndTime = objDts.AddTimeToExistingTimeHourAndMin(objEvent_data.strEventStartTime, 5, 0, "yyyy-MM-dd HH:mm");
		
		EventManagement_page1.verifyEventEndTime(objEvent_data.strEventName,
				objEvent_data.strEventEndTime);
		
		String[] strTestData = {
				strTCID,
				strRegionName[0],
				strstatusTypeNames[7] + " " + strstatusTypeNames[9] + " "
						+ strstatusTypeNames[5] + " " + strstatusTypeNames[8]
						+ " " + strstatusTypeNames[6] + " "
						+ strstatusTypeNames[2] + " " + strstatusTypeNames[4]
						+ " " + strstatusTypeNames[0] + " "
						+ strstatusTypeNames[3] + " " + strstatusTypeNames[1],
				strResourceTypeName[0], strResourceName[0],
				objEvent_data.strEventStartTime, " ",
				objEvent_data.strEndNever, objEvent_data.strEventEndTime };
		
		objOffCommonFunc.writeResultData(strTestData, Login_data.strPartialAutoResultsPath, "AdhocEvents");
		
		gstrResult = "PASS";
	}

	/********************************************************************************
	'Description	:Verify that Ad Hoc event ends at the newly specified End date and
	                 time when the event end date is edited to time earlier than the 
	                 previously provided end date and time.
	'Date	 		:24-June-2014
	'Author			:Sowmya
	**********************************************************************************/
	@Test(description = "Verify that Ad Hoc event ends at the newly specified End date and time when the event " +
			"end date is edited to time earlier than the previously provided end date and time.")
	public void testHappyDay140391() throws Exception {
		
		gstrTCID = "140391";
		gstrTO	 = "Verify that Ad Hoc event ends at the newly specified End date and time when the event " +
			"end date is edited to time earlier than the previously provided end date and time.";
		
		Event_data objEvent_data = new Event_data();
		Date_Time_settings objDts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Login_data objTest_data = new Login_data();
		OfficeCommonFunctions objOfficeCommonFunctions = new OfficeCommonFunctions();
		String strFilePath = objTest_data.strTestDataPath;
		String strFilePath1 = objTest_data.strPartialAutoResultsPath;
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		ResourceType ResourceType_Page1 = new ResourceType(this.driver1);
		Resource Resource_Page1 = new Resource(this.driver1);
		
		String strRegionName[] = new String[1];
		String strstatusTypeNames[] = new String[10];
		String strstatusTypeValues[] = new String[10];
		String strResourceName[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeName[] = new String[1];
		String strUserNameAndPwd[] = new String[2];
	
		strRegionName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
	
		strUserNameAndPwd[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 15, strFilePath);
		strUserNameAndPwd[1] = objOffCommonFunc.readInfoExcel("TestData", 2, 16, strFilePath);
	
		strResourceTypeName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 13, strFilePath);
		strResourceName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
		strResourceValue[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
	
		strstatusTypeNames[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 3, strFilePath);
		strstatusTypeNames[1] = objOffCommonFunc.readInfoExcel("TestData", 2, 4, strFilePath);
		strstatusTypeNames[2] = objOffCommonFunc.readInfoExcel("TestData", 2, 5, strFilePath);
		strstatusTypeNames[3] = objOffCommonFunc.readInfoExcel("TestData", 2, 6, strFilePath);
		strstatusTypeNames[4] = objOffCommonFunc.readInfoExcel("TestData", 2, 7, strFilePath);
		strstatusTypeNames[5] = objOffCommonFunc.readInfoExcel("TestData", 2, 8, strFilePath);
		strstatusTypeNames[6] = objOffCommonFunc.readInfoExcel("TestData", 2, 9, strFilePath);
		strstatusTypeNames[7] = objOffCommonFunc.readInfoExcel("TestData", 2, 10, strFilePath);
		strstatusTypeNames[8] = objOffCommonFunc.readInfoExcel("TestData", 2, 11, strFilePath);
		strstatusTypeNames[9] = objOffCommonFunc.readInfoExcel("TestData", 2, 12, strFilePath);
	
		strstatusTypeValues[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);
		strstatusTypeValues[1] = objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);
		strstatusTypeValues[2] = objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
		strstatusTypeValues[3] = objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
		strstatusTypeValues[4] = objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
		strstatusTypeValues[5] = objOffCommonFunc.readInfoExcel("TestData", 3, 8, strFilePath);
		strstatusTypeValues[6] = objOffCommonFunc.readInfoExcel("TestData", 3, 9, strFilePath);
		strstatusTypeValues[7] = objOffCommonFunc.readInfoExcel("TestData", 3, 10, strFilePath);
		strstatusTypeValues[8] = objOffCommonFunc.readInfoExcel("TestData", 3, 11, strFilePath);
		strstatusTypeValues[9] = objOffCommonFunc.readInfoExcel("TestData", 3, 12, strFilePath);
	
		System.out.println("-----Precondition ends and test execution starts-------");
	
		login_page1.loginToApplication(strUserNameAndPwd[0],
				strUserNameAndPwd[1]);
	
		RegionDefault_page1.selectFrame();
	
		EventManagement_page1.navigateToEventManagement()
				             .clickOnCreateAdHocEventButton()
				             .enterAdHocEventName(objEvent_data.strEventName)
				             .enterAdHocEventDescription(objEvent_data.strEventDescription);
	
		String strEventStartTime = EventManagement_page1.getEventStartDateAndTime();
	
		objEvent_data.strEventStartTime = objDts.converDateFormat(strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");
	
		EventManagement_page1.clickOnNextButton()
				             .verifySelectResourcesDisplayed();
	
		Resource_Page1.clickResource(strResourceValue);
	
		EventManagement_page1.clickOnNextButton()
				             .verifySelectStatusTypesDisplayed();
	
		String[] strStatusTypeNames = { strstatusTypeNames[7],
				strstatusTypeNames[9], strstatusTypeNames[5],
				strstatusTypeNames[8], strstatusTypeNames[6],
				strstatusTypeNames[2], strstatusTypeNames[4],
				strstatusTypeNames[0], strstatusTypeNames[3],
				strstatusTypeNames[1] };
	
		EventManagement_page1
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypeNames);
	
		String[] strStatusTypeValues = { strstatusTypeValues[7],
				strstatusTypeValues[9], strstatusTypeValues[5],
				strstatusTypeValues[8], strstatusTypeValues[6],
				strstatusTypeValues[2], strstatusTypeValues[4],
				strstatusTypeValues[0], strstatusTypeValues[3],
				strstatusTypeValues[1] };
	
		ResourceType_Page1.clickStatusType(strStatusTypeValues);
	
		EventManagement_page1.clickOnNextButton()
				             .clickOnYesButton();
		
		String actualTime = EventManagement_page1.verifyEventStartTimeNew(
				objEvent_data.strEventName, objEvent_data.strEventStartTime);
	
		objEvent_data.strEventEndTime = objDts.AddDaytoExistingDate(actualTime, 1, "yyyy-MM-dd HH:mm");
	
		EventManagement_page1.verifyEventEndTime(objEvent_data.strEventName,objEvent_data.strEventEndTime);
	
		EventManagement_page1.verifyEditEventLink(objEvent_data.strEventName)
				             .verifyEndEventLink(objEvent_data.strEventName)
				             .clickOnEditLink(objEvent_data.strEventName);
	
		objEvent_data.strGetEventStartTime = objDts.AddTimeToExistingTimeHourAndMin(actualTime, 1, 0, "yyyy-MM-dd HH:mm");
	
		objEvent_data.strGetEventStartTime = objDts.converDateFormat(objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm", "yyyy MMM dd HH mm");
	
		String strUpdatedEventEndTime = objDts.converDateFormat(objEvent_data.strGetEventStartTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
	
		String strEndTime[] = objEvent_data.strGetEventStartTime.split(" ");
	
		EventManagement_page1.selectEventEndDateAndTime(strEndTime);
	
		EventManagement_page1.clickOnNextButton()
				             .verifySelectResourcesDisplayed()
				             .clickOnNextButton()
				             .verifySelectStatusTypesDisplayed()
				             .clickOnNextButton()
				             .verifyAdHocEventConfirmationDisplayed()
				             .clickOnYesButton();
	
		EventManagement_page1.verifyEventStartTimeNew(objEvent_data.strEventName, actualTime);
		EventManagement_page1.verifyEventEndTime(objEvent_data.strEventName, strUpdatedEventEndTime);
		
		String[] strTestData = {
				"140388",
				objTest_data.strRegionName,
				strstatusTypeNames[7] + " " + strstatusTypeNames[9] + " "
						+ strstatusTypeNames[5] + " " + strstatusTypeNames[8]
						+ " " + strstatusTypeNames[6] + " "
						+ strstatusTypeNames[2] + " " + strstatusTypeNames[4]
						+ " " + strstatusTypeNames[0] + " "
						+ strstatusTypeNames[3] + " " + strstatusTypeNames[1],
				strResourceTypeName[0], strResourceName[0],
				objEvent_data.strEventStartTime, " ",
				objEvent_data.strEventEndTime, strUpdatedEventEndTime };
		
		objOfficeCommonFunctions.writeResultData(strTestData, strFilePath1, "AdhocEvents");
		
		gstrResult = "PASS";
	}

	/***************************************************************************************
	'Description	:Verify that Ad Hoc can be ended. 
	'Date	 		:6-June-2014
	'Author			:Anil
	***************************************************************************************/
	
	@Test (description = "Verify that Ad Hoc can be ended.")
	public void testHappyDay140395() throws Exception{
		
		gstrTCID = "140395";
		gstrTO	 = "Verify that Ad Hoc can be ended.";
	
		Login login_page = new Login(this.driver1);
		Login_data objTest_data = new Login_data();
		Event_data objEvent_data=new Event_data();
		User_data objUser_data = new User_data();
		EventManagement EventManagement_page = new EventManagement(this.driver1);
	    SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
	    RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
	    UsersList UsersList_page = new UsersList(this.driver1);	 
	    
	    RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
	    Login login_page1 = new Login(this.driver1);
	    EventManagement EventManagement_page1 = new EventManagement(this.driver1);
	    
	    Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	    
	    login_page.loginToApplication(objTest_data.strUserName, objTest_data.strPassword);
	    
	    SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);
	    
	    RegionDefault_page.selectFrame();
	    
	    UsersList_page.navigateToUsers();    
	
	    UsersList_page.clickCreateNewUserButton();
	    
	    UsersList_page.enterUserDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName);
	    
	    UsersList_page. clickAdvancedOptionAndExpand();
	    
	    UsersList_page.selectMaintainEventsOption();
	    
	    UsersList_page.selectMaintainAdHocEventsOption();
	    
	    UsersList_page.clickSaveButton();
	    	    
	    login_page.clickLogOut();
	    
	    System.out.println(objUser_data.strNewUserName);
	     
	    login_page.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	
	    RegionDefault_page.selectFrame();
	
	    EventManagement_page.navigateToEventManagement();
	    
	    EventManagement_page.clickOnCreateAdHocEventButton();
	    
	    EventManagement_page.createAdHocEvent(objEvent_data.strEventName, objEvent_data.strEventDescription);
	    	    
	    EventManagement_page.verifyEventName(objEvent_data.strEventName);
	    
	    EventManagement_page.clickOnCreateAdHocEventButton();
	    
	    EventManagement_page.enterAdHocEventName(objEvent_data.strEventName1);
	    
	    EventManagement_page.enterAdHocEventDescription(objEvent_data.strEventDescription);
	    
	    objEvent_data.strEventStartTime = EventManagement_page.getEventStartDateAndTime();
	    
	    objEvent_data.strEventStartTime = objDate_Time_settings.AddTimeToExistingTimeHourAndMin(objEvent_data.strEventStartTime, 0, 5, "yyyy-MMM-dd HH:mm");
	    
	    objEvent_data.strEventStartTime = objDate_Time_settings.converDateFormat(objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");	    
	    
	    objEvent_data.strEventEndTime = objDate_Time_settings.converDateFormat(objEvent_data.strEventStartTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
	    
	    String strEndTime[]  = objEvent_data.strEventStartTime.split(" ");
	    	    
	    EventManagement_page.selectEventEndDateAndTime(strEndTime);
	    
	    EventManagement_page.clickOnNextButton();
	    
	    EventManagement_page.clickOnNextButton();
	    
	    EventManagement_page.clickOnNextButton();
	    
	    EventManagement_page.clickOnYesButton();
	    
	    EventManagement_page.verifyEventName(objEvent_data.strEventName1);
	
	    login_page.clickLogOut();
	    
	    login_page1.loginToApplication(objUser_data.strNewUserName, objUser_data.strNewPassword);
	
	    RegionDefault_page1.selectFrame();
	
	    EventManagement_page1.navigateToEventManagement();
	    
	    EventManagement_page1.clickOnEndEvent(objEvent_data.strEventName);
	    
	    EventManagement_page1.verifyViewHistoryLink(objEvent_data.strEventName);
	    
	    Thread.sleep(300000);
	    
	    EventManagement_page1.navigateToEventManagementNew();
	    
	    EventManagement_page1.verifyViewHistoryLink(objEvent_data.strEventName1);
	
	    EventManagement_page1.verifyEventEndTime(objEvent_data.strEventName1, objEvent_data.strEventEndTime);
	    
	    gstrResult = "PASS";
	}

	/********************************************************************************
		'Description	:Verify that 'Edit' link is available on 'Event SetUp' page.
		'Date	 		:6-June-2014
		'Author			:QSG
		**********************************************************************************/
	
		@Test (description = "Verify that 'Edit' link is available on 'Event SetUp' page.")
		public void testHappyDay140398() throws Exception {
			
			gstrTCID = "140398";
			gstrTO	 = "Verify that 'Edit' link is available on 'Event SetUp' page.";
	
			Login login_page = new Login(this.driver1);	
			Login_data login_data = new Login_data();
			Event_data objEvent_data=new Event_data();
			User_data objUser_data = new User_data();
			SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
			UsersList UsersList_page = new UsersList(this.driver1);
			
			Login login_page1 = new Login(this.driver1);
			RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
			SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
			EventSetUp EventSetUp_page1 = new EventSetUp(this.driver1);	  
	
		    login_page.loginToApplication(login_data.strUserName, login_data.strPassword);
		    	    
		    SelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);
		    
		    RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		    
		    RegionDefault_page.selectFrame();
		    
		    UsersList_page.navigateToUsers();
		    	        
		    UsersList_page.clickCreateNewUserButton();
		    
		    UsersList_page.enterUserDetails(objUser_data.strNewUserName,
		    		objUser_data.strNewPassword, objUser_data.strFullName);
		    
		    UsersList_page. clickAdvancedOptionAndExpand();
		    
		    UsersList_page.selectMaintainEventTemplateOption();
		    
		    UsersList_page.selectConfigureRegionalUserAccessOption();
		    
		    UsersList_page.clickSaveButton();
		    
		    System.out.println(objUser_data.strNewUserName);
		    
		    login_page.clickLogOut();
		   
	  System.out.println("-----Precondition ends and test execution starts-------");
		    
		    login_page1.loginToApplication(login_data.strUserName, login_data.strPassword);
		   
		    RegionDefault_page1.selectFrame();
	        
		    SelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName);
		    
		    RegionDefault_page1.selectFrame();
		    
		    RegionDefault_page1.verifyRegionDefaultPage();
		    
		    EventSetUp_page1.navigateToEventSetUp();
	
		    EventSetUp_page1.verifyEventTempName(objEvent_data.strAdHocEventTempName);
		    
		    EventSetUp_page1.verifyEditTempLinkIsDisplayed(objEvent_data.strAdHocEventTempName);
		    
		    EventSetUp_page1.verifyNotificationTempLinkIsDisplayed(objEvent_data.strAdHocEventTempName);
		    
		    EventSetUp_page1.verifySecurityLinkForTempIsNotDisplayed(objEvent_data.strAdHocEventTempName);
		    
		    login_page1.clickLogOut();
		    
		    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
		    
		    RegionDefault_page1.selectFrame();
		    
		    EventSetUp_page1.navigateToEventSetUp();
		    
		    EventSetUp_page1.verifyEventTempName(objEvent_data.strAdHocEventTempName);
		    
		    EventSetUp_page1.verifyEditTempLinkIsDisplayed(objEvent_data.strAdHocEventTempName);
		    
		    EventSetUp_page1.verifyNotificationTempLinkIsDisplayed(objEvent_data.strAdHocEventTempName);
		    
		    EventSetUp_page1.verifySecurityLinkForTempIsNotDisplayed(objEvent_data.strAdHocEventTempName);
		    
		    gstrResult = "PASS";
		}
		
		/********************************************************************************
		'Description	:Verify that Ad Hoc event can be modified by clicking on 'Modify' button on 'Ad Hoc Event Confirmation' page 
		'Date	 		:20-June-2014
		'Author			:QSG
		**********************************************************************************/
		@Test(description = "Verify that Ad Hoc event can be modified by clicking on 'Modify' button on 'Ad Hoc Event Confirmation' page")
		public void testHappyDay140120() throws Exception {
			
			gstrTCID = "140120";
			gstrTO	 = "Verify that Ad Hoc event can be modified by clicking on 'Modify' button on 'Ad Hoc Event Confirmation' page";

			Event_data objEvent_data=new Event_data();
			Date_Time_settings objDts = new Date_Time_settings();
			OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
			Login_data objLogin_data = new Login_data();
			String strFilePath = objLogin_data.strTestDataPath;
			
			Login login_page1 = new Login(this.driver1);
			RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
			EventManagement EventManagement_page1=new EventManagement(this.driver1);
			ResourceType ResourceType_Page1=new ResourceType(this.driver1);
			Resource Resource_Page1 =new Resource(this.driver1);
			String strRegionName[]=new String[1];
			String strstatusTypeNames[]=new String[10];
			String strstatusTypeValues[]=new String[10];
			String strResourceName[]=new String[1];
			String strResourceValue[]=new String[1];
			String strResourceTypeName[]=new String[1];
			String strUserNameAndPwd[]=new String[2];
			
			strRegionName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
			
			strUserNameAndPwd[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 15, strFilePath);
			strUserNameAndPwd[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 16, strFilePath);
			
			strResourceTypeName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 13, strFilePath);
			strResourceName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
			strResourceValue[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
			
			strstatusTypeNames[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 3, strFilePath);	
			strstatusTypeNames[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 4, strFilePath);		
			strstatusTypeNames[2]=objOffCommonFunc.readInfoExcel("TestData", 2, 5, strFilePath);
			strstatusTypeNames[3]=objOffCommonFunc.readInfoExcel("TestData", 2, 6, strFilePath);
			strstatusTypeNames[4]=objOffCommonFunc.readInfoExcel("TestData", 2, 7, strFilePath);
			strstatusTypeNames[5]=objOffCommonFunc.readInfoExcel("TestData", 2, 8, strFilePath);
			strstatusTypeNames[6]=objOffCommonFunc.readInfoExcel("TestData", 2, 9, strFilePath);
			strstatusTypeNames[7]=objOffCommonFunc.readInfoExcel("TestData", 2, 10, strFilePath);
			strstatusTypeNames[8]=objOffCommonFunc.readInfoExcel("TestData", 2, 11, strFilePath);
			strstatusTypeNames[9]=objOffCommonFunc.readInfoExcel("TestData", 2, 12, strFilePath);
				
			strstatusTypeValues[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);	
			strstatusTypeValues[1]=objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);		
			strstatusTypeValues[2]=objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
			strstatusTypeValues[3]=objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
			strstatusTypeValues[4]=objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
			strstatusTypeValues[5]=objOffCommonFunc.readInfoExcel("TestData", 3, 8, strFilePath);
			strstatusTypeValues[6]=objOffCommonFunc.readInfoExcel("TestData", 3, 9, strFilePath);
			strstatusTypeValues[7]=objOffCommonFunc.readInfoExcel("TestData", 3, 10, strFilePath);
			strstatusTypeValues[8]=objOffCommonFunc.readInfoExcel("TestData", 3, 11, strFilePath);
			strstatusTypeValues[9]=objOffCommonFunc.readInfoExcel("TestData", 3, 12, strFilePath);
			   
		  System.out.println("-----Precondition ends and test execution starts-------");

			login_page1.loginToApplication(strUserNameAndPwd[0],
					strUserNameAndPwd[1]);

			RegionDefault_page1.selectFrame();

			EventManagement_page1.navigateToEventManagement()
			
			.clickOnCreateAdHocEventButton()
			
			.enterAdHocEventDetails(
					objEvent_data.strEventName, objEvent_data.strEventDescription);

		    objEvent_data.strEventStartTime = EventManagement_page1.getEventStartDateAndTime();
		    
		    objEvent_data.strEventStartTime = objDts.addTimetoExisting(objEvent_data.strEventStartTime, 10, "yyyy-MMM-dd HH:mm");
		    
		    objEvent_data.strEventStartTime = objDts.converDateFormat(objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");	    
		    
		    String strStartTime[]  = objEvent_data.strEventStartTime.split(" ");
		    
		    EventManagement_page1.selectEventStartDateAndTime(strStartTime);
			
			objEvent_data.strEventEndTime = objDts.AddDaytoExistingDate(objEvent_data.strEventStartTime, 32, "yyyy MMM dd HH mm");

			
			String strEndTime[]  = objEvent_data.strEventEndTime.split(" ");
			
			EventManagement_page1
			.selectEventEndDateAndTime(strEndTime);
			
			objEvent_data.strEventEndTime = objDts.converDateFormat(objEvent_data.strEventEndTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
		
			EventManagement_page1.clickOnNextButton()
					
			.clickOnModifyButton();
				
			objEvent_data.strEventEndTime1 = objDts.AddDaytoExistingDate(objEvent_data.strEventStartTime, 2, "yyyy MMM dd HH mm");

			String strEndTime1[]  = objEvent_data.strEventEndTime1.split(" ");
			
			EventManagement_page1
			.selectEventEndDateAndTime(strEndTime1);

			EventManagement_page1.clickOnNextButton();
			
			Resource_Page1.clickResource(strResourceValue);

			EventManagement_page1.clickOnNextButton()
			
			.verifyStatusTypesInSelectStausTypePage(strstatusTypeValues);

			ResourceType_Page1.clickStatusType(strstatusTypeValues);

			objEvent_data.strEventStartTime = objDts.converDateFormat(objEvent_data.strEventStartTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
			
			objEvent_data.strEventEndTime1 = objDts.converDateFormat(objEvent_data.strEventEndTime1, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");

			EventManagement_page1.clickOnNextButton()
			
			.clickOnYesButton()

			.verifyEventName(objEvent_data.strEventName)

			.verifyEventStartTime(objEvent_data.strEventName,
					objEvent_data.strEventStartTime)

			.verifyEventEndTime(objEvent_data.strEventName,
					objEvent_data.strEventEndTime1);
			
			gstrResult = "PASS";
		}

		/********************************************************************************
		'Description	:Verify that user with 'Maintain Adhoc Events' and 'Maintain Events'
		                 right can create an Ad Hoc event.
		'Date	 		:12-June-2014
		'Author			:QSG
		**********************************************************************************/
		@Test(description = "Verify that user with 'Maintain Adhoc Events' and 'Maintain Events'"
				+ " right can create an Ad Hoc event.")
		public void testHappyDay139772() throws Exception {
			
			gstrTCID = "139772";
			gstrTO	 = "Verify that user with 'Maintain Adhoc Events' and 'Maintain Events'"
				+ " right can create an Ad Hoc event.";
		
			boolean blnTest = false;
			Login login_page = new Login(this.driver1);
			Login_data objTest_data = new Login_data();
			Event_data objEvent_data=new Event_data();
			User_data objUser_data = new User_data();
			OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
			String strFilePath = Login_data.strTestDataPath;
			
			ResourceType_data objResourceType_data=new ResourceType_data();
			Resource_data objResource_data=new Resource_data();
			SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
			RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
			StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
			ResourceType ResourceType_Page=new ResourceType(this.driver1);
			StatusTypes_data objStatuTypes_data=new StatusTypes_data();
			Resource Resource_Page =new Resource(this.driver1);
		    UsersList UsersList_page = new UsersList(this.driver1);
			String strstatusTypeValues[]=new String[10];
			String strResourceValue[]=new String[1];
			String strResourceTypeValue[]=new String[1];
		
			Login login_page1 = new Login(this.driver1);
			RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
			EventManagement EventManagement_page1=new EventManagement(this.driver1);
			ResourceType ResourceType_Page1=new ResourceType(this.driver1);
			Resource Resource_Page1 =new Resource(this.driver1);
			
			login_page.loginToApplication(objTest_data.strUserName,
					objTest_data.strPassword);
		
			SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);
		
			RegionDefault_page.selectFrame();
		
			StatusTypeList_page.navigateToStatusTypeList()
		
			//RoleBased statustypes
			
			.createStatusType(
					objStatuTypes_data.strNumberStatusType,
					objStatuTypes_data.strNSTStatusTypeName,
					objStatuTypes_data.strStatusDescription);
			
			strstatusTypeValues[0] = StatusTypeList_page
					.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);
			
			StatusTypeList_page.createStatusType(
					objStatuTypes_data.strTextStatusType,
					objStatuTypes_data.strTSTStatusTypeName,
					objStatuTypes_data.strStatusDescription);
			
			strstatusTypeValues[1] = StatusTypeList_page
					.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
			
			StatusTypeList_page.createStatusType(
					objStatuTypes_data.strMultiStatusType,
					objStatuTypes_data.strMSTStatusTypeName,
					objStatuTypes_data.strStatusDescription);
			
			StatusTypeList_page.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
					                            objStatuTypes_data.strStatusColor)
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
 				         objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
        .clickOnReturnToStatusTypeList();
			
			strstatusTypeValues[2] = StatusTypeList_page
					.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);		
			
			StatusTypeList_page.createStatusType(
					objStatuTypes_data.strSaturationScoreStatusType,
					objStatuTypes_data.strSSTStatusTypeName,
					objStatuTypes_data.strStatusDescription);
			
			strstatusTypeValues[3] = StatusTypeList_page
					.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
			
			StatusTypeList_page.createStatusType(
					objStatuTypes_data.strNedocCalculationStatusType,
					objStatuTypes_data.strNDSTStatusTypeName,
					objStatuTypes_data.strStatusDescription);
			
			strstatusTypeValues[4] = StatusTypeList_page
					.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);
		
			//Event related statustypes
			StatusTypeList_page.createEventStatusType(
					objStatuTypes_data.strNumberStatusType,
					objStatuTypes_data.streNSTStatusTypeName,
					objStatuTypes_data.strStatusDescription);
			
			strstatusTypeValues[5] = StatusTypeList_page
					.getStatusValue(objStatuTypes_data.streNSTStatusTypeName);
		
			StatusTypeList_page.createEventStatusType(
					objStatuTypes_data.strTextStatusType,
					objStatuTypes_data.streTSTStatusTypeName,
					objStatuTypes_data.strStatusDescription);
			
			strstatusTypeValues[6] = StatusTypeList_page
					.getStatusValue(objStatuTypes_data.streTSTStatusTypeName);
			
			StatusTypeList_page.createEventStatusType(
					objStatuTypes_data.strMultiStatusType,
					objStatuTypes_data.streMSTStatusTypeName,
					objStatuTypes_data.strStatusDescription);
			
			StatusTypeList_page.createNewStatus(
					objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusColor)
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
        .clickOnReturnToStatusTypeList();
			
			strstatusTypeValues[7] = StatusTypeList_page
					.getStatusValue(objStatuTypes_data.streMSTStatusTypeName);
			
			StatusTypeList_page.createEventStatusType(
					objStatuTypes_data.strSaturationScoreStatusType,
					objStatuTypes_data.streSSTStatusTypeName,
					objStatuTypes_data.strStatusDescription);
			
			strstatusTypeValues[8] = StatusTypeList_page
					.getStatusValue(objStatuTypes_data.streSSTStatusTypeName);
			
			StatusTypeList_page.createEventStatusType(
					objStatuTypes_data.strNedocCalculationStatusType,
					objStatuTypes_data.streNDSTStatusTypeName,
					objStatuTypes_data.strStatusDescription);
			
			strstatusTypeValues[9] = StatusTypeList_page
					.getStatusValue(objStatuTypes_data.streNDSTStatusTypeName);
			
			//Resource type creation 
			ResourceType_Page.navigateToResourceTypePage()
		
			.createResourceType(objResourceType_data.strResourceTypeName,
					strstatusTypeValues);
			strResourceTypeValue[0] = ResourceType_Page.getResourceTypeValue(objResourceType_data.strResourceTypeName);
			//Resource creation 
			
			Resource_Page.navigateToResourceListPage()
		
			.createResource(objResource_data.strResourceName,
					objResource_data.strResourceAbbrivation,
					objResourceType_data.strResourceTypeName,
					objResource_data.strStandardResourceTypename,
					objResource_data.strResourceFirstName,
					objResource_data.strResourceLastName);
			
			strResourceValue[0]=Resource_Page.getResourceValue(objResource_data.strResourceName);
			
			//User creation
			
			UsersList_page
					.navigateToUsersNew()
		
					.clickCreateNewUserButton()
		
					.enterUserDetails(objUser_data.strNewUserName,
							objUser_data.strNewPassword, objUser_data.strFullName)
		
					.selectFirstRole()
		
					.clickAdvancedOptionAndExpand()
		
					.selectMaintainEventsOption()
		
					.selectMaintainAdHocEventsOption()
		
					.clickSaveButton();
					
			login_page.clickLogOut();	
			
			System.out.println(objUser_data.strNewUserName);
			   
			System.out.println("-----Precondition ends and test execution starts-------");
		
		    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
		    
		    RegionDefault_page1.selectFrame();
		    
		    EventManagement_page1.navigateToEventManagement()
		    
		    .clickOnCreateAdHocEventButton()
		    
		    .enterAdHocEventName(objEvent_data.strEventName)
		    
		    .enterAdHocEventDescription(objEvent_data.strEventDescription)
		    
		    .clickOnNextButton()
		    
		    .verifyResourceInSelectResourcePage(strResourceValue);
		    
		    Resource_Page1.clickResource(strResourceValue);
		    
		    EventManagement_page1.clickOnNextButton()
		    
		    .verifyStatusTypesInSelectStausTypePage(strstatusTypeValues);
		    
		    ResourceType_Page1.clickStatusType(strstatusTypeValues);
		    
		    EventManagement_page1.clickOnNextButton()
		    
		    .clickOnYesButton()
		    
		    .verifyEventName(objEvent_data.strEventName);
		    
		    blnTest =true;
		    
		    if (blnTest) {
		
				String[] strTestData = { "139772", objTest_data.strRegionName,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strTSTStatusTypeName,
						objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strSSTStatusTypeName,
						objStatuTypes_data.strNDSTStatusTypeName,
						objStatuTypes_data.streNSTStatusTypeName,
						objStatuTypes_data.streTSTStatusTypeName,
						objStatuTypes_data.streMSTStatusTypeName,
						objStatuTypes_data.streSSTStatusTypeName,
						objStatuTypes_data.streNDSTStatusTypeName,
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName, 
						objUser_data.strNewUserName,
						objUser_data.strNewPassword};
				objOffCommonFunc.writeResultDataToParticularRow(strTestData,
						strFilePath, "TestData", 1);
				
				String[] strTestData1 = { "139772", objTest_data.strRegionName,
						strstatusTypeValues[0], strstatusTypeValues[1],
						strstatusTypeValues[2], strstatusTypeValues[3],
						strstatusTypeValues[4], strstatusTypeValues[5],
						strstatusTypeValues[6], strstatusTypeValues[7],
						strstatusTypeValues[8], strstatusTypeValues[9], strResourceTypeValue[0],
						strResourceValue[0] };
				objOffCommonFunc.writeResultDataToParticularRow(strTestData1,
						strFilePath, "TestData", 2);
				
				gstrResult = "PASS";
			}		    
		}

		/********************************************************************************
		'Description	:Verify that Ad Hoc event can be created to start immediately and 
		                 end after a specific time period (say, 5 hrs), the event starts 
		                 immediately and ends after the specified number of hours.
		'Date	 		:12-June-2014
		'Author			:QSG
		**********************************************************************************/
		@Test(description = "Verify that Ad Hoc event can be created to start immediately and "
				+ "end after a specific time period (say, 5 hrs), the event starts immediately"
				+ " and ends after the specified number of hours.")
		public void testHappyDay140111() throws Exception {
			
			gstrTCID = "140111";
			gstrTO	 = "Verify that Ad Hoc event can be created to start immediately and "
				+ "end after a specific time period (say, 5 hrs), the event starts immediately"
				+ " and ends after the specified number of hours.";

			Event_data objEvent_data=new Event_data();
			Date_Time_settings objDts = new Date_Time_settings();
			OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
			Login_data objLogin_data = new Login_data();
			String strFilePath = objLogin_data.strTestDataPath;
				
			Login login_page1 = new Login(this.driver1);
			RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
			EventManagement EventManagement_page1=new EventManagement(this.driver1);
			ResourceType ResourceType_Page1=new ResourceType(this.driver1);
			Resource Resource_Page1 =new Resource(this.driver1);
			String strRegionName[]=new String[1];
			String strstatusTypeNames[]=new String[10];
			String strstatusTypeValues[]=new String[10];
			String strResourceName[]=new String[1];
			String strResourceValue[]=new String[1];
			String strResourceTypeName[]=new String[1];
			String strUserNameAndPwd[]=new String[2];
			
			strRegionName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
			
			strUserNameAndPwd[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 15, strFilePath);
			strUserNameAndPwd[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 16, strFilePath);
			
			strResourceTypeName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 13, strFilePath);
			strResourceName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
			strResourceValue[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
			
			strstatusTypeNames[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 3, strFilePath);	
			strstatusTypeNames[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 4, strFilePath);		
			strstatusTypeNames[2]=objOffCommonFunc.readInfoExcel("TestData", 2, 5, strFilePath);
			strstatusTypeNames[3]=objOffCommonFunc.readInfoExcel("TestData", 2, 6, strFilePath);
			strstatusTypeNames[4]=objOffCommonFunc.readInfoExcel("TestData", 2, 7, strFilePath);
			strstatusTypeNames[5]=objOffCommonFunc.readInfoExcel("TestData", 2, 8, strFilePath);
			strstatusTypeNames[6]=objOffCommonFunc.readInfoExcel("TestData", 2, 9, strFilePath);
			strstatusTypeNames[7]=objOffCommonFunc.readInfoExcel("TestData", 2, 10, strFilePath);
			strstatusTypeNames[8]=objOffCommonFunc.readInfoExcel("TestData", 2, 11, strFilePath);
			strstatusTypeNames[9]=objOffCommonFunc.readInfoExcel("TestData", 2, 12, strFilePath);
				
			strstatusTypeValues[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);	
			strstatusTypeValues[1]=objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);		
			strstatusTypeValues[2]=objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
			strstatusTypeValues[3]=objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
			strstatusTypeValues[4]=objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
			strstatusTypeValues[5]=objOffCommonFunc.readInfoExcel("TestData", 3, 8, strFilePath);
			strstatusTypeValues[6]=objOffCommonFunc.readInfoExcel("TestData", 3, 9, strFilePath);
			strstatusTypeValues[7]=objOffCommonFunc.readInfoExcel("TestData", 3, 10, strFilePath);
			strstatusTypeValues[8]=objOffCommonFunc.readInfoExcel("TestData", 3, 11, strFilePath);
			strstatusTypeValues[9]=objOffCommonFunc.readInfoExcel("TestData", 3, 12, strFilePath);
			   
		  System.out.println("-----Precondition ends and test execution starts-------");
		  
		  System.out.println(strUserNameAndPwd[0]);
		
			login_page1.loginToApplication(strUserNameAndPwd[0],
					strUserNameAndPwd[1]);
		
			RegionDefault_page1.selectFrame();
		
			EventManagement_page1.navigateToEventManagement()
			
			.clickOnCreateAdHocEventButton()
	
			.enterAdHocEventDetails(
					objEvent_data.strEventName, objEvent_data.strEventDescription);
		
			objEvent_data.strEventStartTime = EventManagement_page1
					.getEventStartDateAndTime();
		
			objEvent_data.strEventStartTime = objDts.converDateFormat(
					objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm",
					"yyyy-MM-dd HH:mm");
		
			objEvent_data.strEventEndTime = objDts.addTimetoExistingHour(
					objEvent_data.strEventStartTime, 5, "yyyy-MM-dd HH:mm");
		
			EventManagement_page1
					.enterEventEndTime(objEvent_data.strEventEndTimeInHours)
					
		            .clickOnNextButton()
		            
		        
			
			.verifyResourceInSelectResourcePage(strResourceValue);
			System.out.println(objEvent_data.strEventName);
		
			Resource_Page1.clickResource(strResourceValue);
		
			EventManagement_page1.clickOnNextButton()
			
			.verifyStatusTypesInSelectStausTypePage(strstatusTypeValues);
		
			ResourceType_Page1.clickStatusType(strstatusTypeValues);
		
			EventManagement_page1.clickOnNextButton()
			
			.clickOnYesButton()
		
			.verifyEventName(objEvent_data.strEventName)
		
			.verifyEventStartTime(objEvent_data.strEventName,
					objEvent_data.strEventStartTime)
		
			.verifyEventEndTime(objEvent_data.strEventName,
					objEvent_data.strEventEndTime);
		
			EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
			
			EventManagement_page1.verifyResourcesInEventBanner(strResourceName[0])
			
			.verifyResourceTypeInEventBanner(strResourceTypeName[0]);
			
			String[] strStatusTypeNames = { strstatusTypeNames[7],
					strstatusTypeNames[9], strstatusTypeNames[5],
					strstatusTypeNames[8], strstatusTypeNames[6],
					strstatusTypeNames[2], strstatusTypeNames[4],
					strstatusTypeNames[0], strstatusTypeNames[3],
					strstatusTypeNames[1] };
			EventManagement_page1.verifyStatusTypesInEventBanner(
					strStatusTypeNames, strResourceTypeName[0]);
			
			login_page1.clickLogOut();
			
			gstrResult = "PASS";
		}

		/********************************************************************************
		'Description  :Verify that when a Ad Hoc event can be created to start immediately 
		                 and end after a specific date & time (say, 5:00 PM on date X+1,
		                 where X is the current date), the event starts immediately and
		                 ends at the specified time on the date set (5:00 PM on date X+1)
		'Date	 	  :12-June-2014
		'Author		  :QSG
		**********************************************************************************/
		@Test(description = "Verify that when a Ad Hoc event can be created to start immediately"
				+ " and end after a specific date & time (say, 5:00 PM on date X+1,"
				+ " where X is the current date), the event starts immediately and ends"
				+ " at the specified time on the date set (5:00 PM on date X+1)")
		public void testHappyDay140112() throws Exception {
			
			gstrTCID = "140112";
			gstrTO	 = "Verify that when a Ad Hoc event can be created to start immediately"
				+ " and end after a specific date & time (say, 5:00 PM on date X+1,"
				+ " where X is the current date), the event starts immediately and ends"
				+ " at the specified time on the date set (5:00 PM on date X+1)";
		
			Login_data objLogin_data = new Login_data();
			Event_data objEvent_data=new Event_data();
			Date_Time_settings objDts = new Date_Time_settings();
			OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
			String strFilePath = objLogin_data.strTestDataPath;
				
			Login login_page1 = new Login(this.driver1);
			RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
			EventManagement EventManagement_page1=new EventManagement(this.driver1);
			ResourceType ResourceType_Page1=new ResourceType(this.driver1);
			Resource Resource_Page1 =new Resource(this.driver1);
			String strRegionName[]=new String[1];
			String strstatusTypeNames[]=new String[10];
			String strstatusTypeValues[]=new String[10];
			String strResourceName[]=new String[1];
			String strResourceValue[]=new String[1];
			String strResourceTypeName[]=new String[1];
			String strUserNameAndPwd[]=new String[2];
			
			strRegionName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
			
			strUserNameAndPwd[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 15, strFilePath);
			strUserNameAndPwd[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 16, strFilePath);
			
			strResourceTypeName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 13, strFilePath);
			strResourceName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
			strResourceValue[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
			
			strstatusTypeNames[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 3, strFilePath);	
			strstatusTypeNames[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 4, strFilePath);		
			strstatusTypeNames[2]=objOffCommonFunc.readInfoExcel("TestData", 2, 5, strFilePath);
			strstatusTypeNames[3]=objOffCommonFunc.readInfoExcel("TestData", 2, 6, strFilePath);
			strstatusTypeNames[4]=objOffCommonFunc.readInfoExcel("TestData", 2, 7, strFilePath);
			strstatusTypeNames[5]=objOffCommonFunc.readInfoExcel("TestData", 2, 8, strFilePath);
			strstatusTypeNames[6]=objOffCommonFunc.readInfoExcel("TestData", 2, 9, strFilePath);
			strstatusTypeNames[7]=objOffCommonFunc.readInfoExcel("TestData", 2, 10, strFilePath);
			strstatusTypeNames[8]=objOffCommonFunc.readInfoExcel("TestData", 2, 11, strFilePath);
			strstatusTypeNames[9]=objOffCommonFunc.readInfoExcel("TestData", 2, 12, strFilePath);
				
			strstatusTypeValues[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);	
			strstatusTypeValues[1]=objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);		
			strstatusTypeValues[2]=objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
			strstatusTypeValues[3]=objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
			strstatusTypeValues[4]=objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
			strstatusTypeValues[5]=objOffCommonFunc.readInfoExcel("TestData", 3, 8, strFilePath);
			strstatusTypeValues[6]=objOffCommonFunc.readInfoExcel("TestData", 3, 9, strFilePath);
			strstatusTypeValues[7]=objOffCommonFunc.readInfoExcel("TestData", 3, 10, strFilePath);
			strstatusTypeValues[8]=objOffCommonFunc.readInfoExcel("TestData", 3, 11, strFilePath);
			strstatusTypeValues[9]=objOffCommonFunc.readInfoExcel("TestData", 3, 12, strFilePath);
			   
		  System.out.println("-----Precondition ends and test execution starts-------");
		
			login_page1.loginToApplication(strUserNameAndPwd[0],
					strUserNameAndPwd[1]);
		
			RegionDefault_page1.selectFrame();
		
			EventManagement_page1.navigateToEventManagement()
			
			.clickOnCreateAdHocEventButton()
			
			.enterAdHocEventDetails(
					objEvent_data.strEventName, objEvent_data.strEventDescription);
			
			objEvent_data.strEventStartTime = EventManagement_page1
					.getEventStartDateAndTime();
		
			objEvent_data.strEventStartTime = objDts.converDateFormat(
					objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm",
					"yyyy MMM dd HH mm");
		
			String strStartTime[] = objEvent_data.strEventStartTime.split(" ");
		
			strStartTime[3] = "04";
		
			strStartTime[4] = "00";
		
			objEvent_data.strEventEndTime = objDts.AddDaytoExistingDate(
					objEvent_data.strEventStartTime, 1, "yyyy MMM dd HH mm");
		
			String strEndTime[] = objEvent_data.strEventEndTime.split(" ");
		
			strEndTime[3] = "03";
		
			strEndTime[4] = "00";
		
			objEvent_data.strEventEndTime = strEndTime[0] + " " + strEndTime[1]
					+ " " + strEndTime[2] + " " + strEndTime[3] + " "
					+ strStartTime[4];
		
			objEvent_data.strEventEndTime = objDts.converDateFormat(
					objEvent_data.strEventEndTime, "yyyy MMM dd HH mm",
					"yyyy-MM-dd HH:mm");
		
			objEvent_data.strEventStartTime = objDts.converDateFormat(
					objEvent_data.strEventStartTime, "yyyy MMM dd HH mm",
					"yyyy-MM-dd HH:mm");
		
			EventManagement_page1.selectEventEndDateAndTime(strEndTime)
		
			.clickOnNextButton()
		
			.verifyResourceInSelectResourcePage(strResourceValue);
		
			Resource_Page1.clickResource(strResourceValue);
		
			EventManagement_page1.clickOnNextButton()
			
			.verifyStatusTypesInSelectStausTypePage(strstatusTypeValues);
		
			ResourceType_Page1.clickStatusType(strstatusTypeValues);
		
			EventManagement_page1.clickOnNextButton()
			
			.clickOnYesButton()
		
			.verifyEventName(objEvent_data.strEventName)
		
			.verifyEventStartTime(objEvent_data.strEventName,
					objEvent_data.strEventStartTime)
		
			.verifyEventEndTime(objEvent_data.strEventName,
					objEvent_data.strEventEndTime);
		
			EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
			
			EventManagement_page1.verifyResourcesInEventBanner(strResourceName[0])
			
			.verifyResourceTypeInEventBanner(strResourceTypeName[0]);
			
			String[] strStatusTypeNames = { strstatusTypeNames[7],
					strstatusTypeNames[9], strstatusTypeNames[5],
					strstatusTypeNames[8], strstatusTypeNames[6],
					strstatusTypeNames[2], strstatusTypeNames[4],
					strstatusTypeNames[0], strstatusTypeNames[3],
					strstatusTypeNames[1] };
			EventManagement_page1.verifyStatusTypesInEventBanner(
					strStatusTypeNames, strResourceTypeName[0]);
			
			gstrResult = "PASS";
		}

		/*****************************************************************************
		'Description	:Verify that the Ad Hoc event starts immediately and does not
		                 display the end date when a Ad Hoc event is created selecting
		                  to start immediately and to end never.
		'Date	 		:12-June-2014
		'Author			:QSG
		*******************************************************************************/
		@Test(description = "Verify that the Ad Hoc event starts immediately and does not"
				+ " display the end date when a Ad Hoc event is created selecting to start"
				+ " immediately and to end never.")
		public void testHappyDay140114() throws Exception {
			
			gstrTCID = "140114";
			gstrTO	 = "Verify that the Ad Hoc event starts immediately and does not"
				+ " display the end date when a Ad Hoc event is created selecting to start"
				+ " immediately and to end never.";
		
			Event_data objEvent_data=new Event_data();
			Date_Time_settings objDts = new Date_Time_settings();
			OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
			Login_data objLogin_data = new Login_data();
			String strFilePath = objLogin_data.strTestDataPath;
					
			Login login_page1 = new Login(this.driver1);
			RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
			EventManagement EventManagement_page1=new EventManagement(this.driver1);
			ResourceType ResourceType_Page1=new ResourceType(this.driver1);
			Resource Resource_Page1 =new Resource(this.driver1);
			String strRegionName[]=new String[1];
			String strstatusTypeNames[]=new String[10];
			String strstatusTypeValues[]=new String[10];
			String strResourceName[]=new String[1];
			String strResourceValue[]=new String[1];
			String strResourceTypeName[]=new String[1];
			String strUserNameAndPwd[]=new String[2];
			
			strRegionName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
			
			strUserNameAndPwd[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 15, strFilePath);
			strUserNameAndPwd[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 16, strFilePath);
			
			strResourceTypeName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 13, strFilePath);
			strResourceName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
			strResourceValue[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
			
			strstatusTypeNames[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 3, strFilePath);	
			strstatusTypeNames[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 4, strFilePath);		
			strstatusTypeNames[2]=objOffCommonFunc.readInfoExcel("TestData", 2, 5, strFilePath);
			strstatusTypeNames[3]=objOffCommonFunc.readInfoExcel("TestData", 2, 6, strFilePath);
			strstatusTypeNames[4]=objOffCommonFunc.readInfoExcel("TestData", 2, 7, strFilePath);
			strstatusTypeNames[5]=objOffCommonFunc.readInfoExcel("TestData", 2, 8, strFilePath);
			strstatusTypeNames[6]=objOffCommonFunc.readInfoExcel("TestData", 2, 9, strFilePath);
			strstatusTypeNames[7]=objOffCommonFunc.readInfoExcel("TestData", 2, 10, strFilePath);
			strstatusTypeNames[8]=objOffCommonFunc.readInfoExcel("TestData", 2, 11, strFilePath);
			strstatusTypeNames[9]=objOffCommonFunc.readInfoExcel("TestData", 2, 12, strFilePath);
				
			strstatusTypeValues[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);	
			strstatusTypeValues[1]=objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);		
			strstatusTypeValues[2]=objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
			strstatusTypeValues[3]=objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
			strstatusTypeValues[4]=objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
			strstatusTypeValues[5]=objOffCommonFunc.readInfoExcel("TestData", 3, 8, strFilePath);
			strstatusTypeValues[6]=objOffCommonFunc.readInfoExcel("TestData", 3, 9, strFilePath);
			strstatusTypeValues[7]=objOffCommonFunc.readInfoExcel("TestData", 3, 10, strFilePath);
			strstatusTypeValues[8]=objOffCommonFunc.readInfoExcel("TestData", 3, 11, strFilePath);
			strstatusTypeValues[9]=objOffCommonFunc.readInfoExcel("TestData", 3, 12, strFilePath);
			   
		  System.out.println("-----Precondition ends and test execution starts-------");
		
			login_page1.loginToApplication(strUserNameAndPwd[0],
					strUserNameAndPwd[1]);
		
			RegionDefault_page1.selectFrame();
		
			EventManagement_page1.navigateToEventManagement()
			
			.clickOnCreateAdHocEventButton()
			
			.enterAdHocEventDetails(
					objEvent_data.strEventName, objEvent_data.strEventDescription);
		
			objEvent_data.strEventStartTime = EventManagement_page1
					.getEventStartDateAndTime();
		
			objEvent_data.strEventStartTime = objDts.converDateFormat(
					objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm",
					"yyyy-MM-dd HH:mm");
		
			EventManagement_page1
					.clickEventNeverEndRadioButton()
					
		            .clickOnNextButton()
		            
		            .clickOnKeepButton()
			
			.verifyResourceInSelectResourcePage(strResourceValue);
		
			Resource_Page1.clickResource(strResourceValue);
		
			EventManagement_page1.clickOnNextButton()
			
			.verifyStatusTypesInSelectStausTypePage(strstatusTypeValues);
		
			ResourceType_Page1.clickStatusType(strstatusTypeValues);
		
			EventManagement_page1.clickOnNextButton()
			
			.clickOnYesButton()
		
			.verifyEventName(objEvent_data.strEventName)
		
			.verifyEventStartTime(objEvent_data.strEventName,
					objEvent_data.strEventStartTime)
		
			.verifyEventEndTimeWhenItSetToNever(objEvent_data.strEventName,
					objEvent_data.strEndNever);
		
			EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
			
			EventManagement_page1.verifyResourcesInEventBanner(strResourceName[0])
			
			.verifyResourceTypeInEventBanner(strResourceTypeName[0]);
			
			String[] strStatusTypeNames = { strstatusTypeNames[7],
					strstatusTypeNames[9], strstatusTypeNames[5],
					strstatusTypeNames[8], strstatusTypeNames[6],
					strstatusTypeNames[2], strstatusTypeNames[4],
					strstatusTypeNames[0], strstatusTypeNames[3],
					strstatusTypeNames[1] };
			EventManagement_page1.verifyStatusTypesInEventBanner(
					strStatusTypeNames, strResourceTypeName[0]);
			
			login_page1.clickLogOut();
			
			gstrResult = "PASS";
		}

		/********************************************************************************
		'Description	:Verify that Ad Hoc event can be created to start immediately and 
		                 end after a specific time period (say, 5 hrs), the event starts 
		                 immediately and ends after the specified number of hours.
		'Date	 		:12-June-2014
		'Author			:QSG
		**********************************************************************************/
		@Test(description = "Verify that a Ad Hoc event can be created selecting to start"
				               + " the event at specified date (say, 4:00 PM & day as x+1 "
				               + "where x is current date) and end after 4 hours ")
		public void testHappyDay140115() throws Exception {
			
			gstrTCID = "140115";
			gstrTO	 = "Verify that a Ad Hoc event can be created selecting to start"
				               + " the event at specified date (say, 4:00 PM & day as x+1 "
				               + "where x is current date) and end after 4 hours";
		
			Event_data objEvent_data=new Event_data();
			Date_Time_settings objDts = new Date_Time_settings();
			OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
			Login_data objLogin_data = new Login_data();
			String strFilePath = objLogin_data.strTestDataPath;
				
			Login login_page1 = new Login(this.driver1);
			RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
			EventManagement EventManagement_page1=new EventManagement(this.driver1);
			ResourceType ResourceType_Page1=new ResourceType(this.driver1);
			Resource Resource_Page1 =new Resource(this.driver1);
			String strRegionName[]=new String[1];
			String strstatusTypeNames[]=new String[10];
			String strstatusTypeValues[]=new String[10];
			String strResourceName[]=new String[1];
			String strResourceValue[]=new String[1];
			String strResourceTypeName[]=new String[1];
			String strUserNameAndPwd[]=new String[2];
			
			strRegionName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
			
			strUserNameAndPwd[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 15, strFilePath);
			strUserNameAndPwd[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 16, strFilePath);
			
			strResourceTypeName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 13, strFilePath);
			strResourceName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
			strResourceValue[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
			
			strstatusTypeNames[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 3, strFilePath);	
			strstatusTypeNames[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 4, strFilePath);		
			strstatusTypeNames[2]=objOffCommonFunc.readInfoExcel("TestData", 2, 5, strFilePath);
			strstatusTypeNames[3]=objOffCommonFunc.readInfoExcel("TestData", 2, 6, strFilePath);
			strstatusTypeNames[4]=objOffCommonFunc.readInfoExcel("TestData", 2, 7, strFilePath);
			strstatusTypeNames[5]=objOffCommonFunc.readInfoExcel("TestData", 2, 8, strFilePath);
			strstatusTypeNames[6]=objOffCommonFunc.readInfoExcel("TestData", 2, 9, strFilePath);
			strstatusTypeNames[7]=objOffCommonFunc.readInfoExcel("TestData", 2, 10, strFilePath);
			strstatusTypeNames[8]=objOffCommonFunc.readInfoExcel("TestData", 2, 11, strFilePath);
			strstatusTypeNames[9]=objOffCommonFunc.readInfoExcel("TestData", 2, 12, strFilePath);
				
			strstatusTypeValues[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);	
			strstatusTypeValues[1]=objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);		
			strstatusTypeValues[2]=objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
			strstatusTypeValues[3]=objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
			strstatusTypeValues[4]=objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
			strstatusTypeValues[5]=objOffCommonFunc.readInfoExcel("TestData", 3, 8, strFilePath);
			strstatusTypeValues[6]=objOffCommonFunc.readInfoExcel("TestData", 3, 9, strFilePath);
			strstatusTypeValues[7]=objOffCommonFunc.readInfoExcel("TestData", 3, 10, strFilePath);
			strstatusTypeValues[8]=objOffCommonFunc.readInfoExcel("TestData", 3, 11, strFilePath);
			strstatusTypeValues[9]=objOffCommonFunc.readInfoExcel("TestData", 3, 12, strFilePath);
			   
		  System.out.println("-----Precondition ends and test execution starts-------");
		
			login_page1.loginToApplication(strUserNameAndPwd[0],
					strUserNameAndPwd[1]);
		
			RegionDefault_page1.selectFrame();
		
			EventManagement_page1.navigateToEventManagement()
			
			.clickOnCreateAdHocEventButton()
			
			.enterAdHocEventDetails(
					objEvent_data.strEventName, objEvent_data.strEventDescription);
		
		    objEvent_data.strEventStartTime = EventManagement_page1.getEventStartDateAndTime();
		    
		    objEvent_data.strEventStartTime = objDts.addTimetoExisting(objEvent_data.strEventStartTime, 2, "yyyy-MMM-dd HH:mm");
		    
		    objEvent_data.strEventStartTime = objDts.converDateFormat(objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");	    
		    
		    String strStartTime[]  = objEvent_data.strEventStartTime.split(" ");
		    
		    EventManagement_page1.selectEventStartDateAndTime(strStartTime);
			
			objEvent_data.strEventEndTime = objDts.addTimetoExistingHour(
					objEvent_data.strEventStartTime, 4, "yyyy MMM dd HH mm");
		
			objEvent_data.strEventEndTime = objDts.converDateFormat(objEvent_data.strEventEndTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
		
			objEvent_data.strEventStartTime = objDts.converDateFormat(objEvent_data.strEventStartTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
			
			EventManagement_page1
					.enterEventEndTime(objEvent_data.strEventEndTimeInHours1)
					
		            .clickOnNextButton()
			
			.verifyResourceInSelectResourcePage(strResourceValue);
		
			Resource_Page1.clickResource(strResourceValue);
		
			EventManagement_page1.clickOnNextButton()
			
			.verifyStatusTypesInSelectStausTypePage(strstatusTypeValues);
		
			ResourceType_Page1.clickStatusType(strstatusTypeValues);
		
			EventManagement_page1.clickOnNextButton()
			
			.clickOnYesButton()
		
			.verifyEventName(objEvent_data.strEventName)
		
			.verifyEventStartTime(objEvent_data.strEventName,
					objEvent_data.strEventStartTime)
		
			.verifyEventEndTime(objEvent_data.strEventName,
					objEvent_data.strEventEndTime);
		
			Thread.sleep(120000);
			
			EventManagement_page1.navigateToEventManagementNew();
			
			EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
			
			EventManagement_page1.verifyResourcesInEventBanner(strResourceName[0])
			
			.verifyResourceTypeInEventBanner(strResourceTypeName[0]);
			
			String[] strStatusTypeNames = { strstatusTypeNames[7],
					strstatusTypeNames[9], strstatusTypeNames[5],
					strstatusTypeNames[8], strstatusTypeNames[6],
					strstatusTypeNames[2], strstatusTypeNames[4],
					strstatusTypeNames[0], strstatusTypeNames[3],
					strstatusTypeNames[1] };
			EventManagement_page1.verifyStatusTypesInEventBanner(
					strStatusTypeNames, strResourceTypeName[0]);
			
			gstrResult = "PASS";
		}

		/********************************************************************************
		'Description	:Verify that a Ad Hoc event can be created selecting to start & end the event at specified date & time (Start say, 4:00 PM & day as x+1 & end at 3:00 PM and day as x+2 where x is current date )
		'Date	 		:12-June-2014
		'Author			:QSG
		**********************************************************************************/
		@Test(description = "Verify that a Ad Hoc event can be created selecting to start & end the event at specified date & time (Start say, 4:00 PM & day as x+1 & end at 3:00 PM and day as x+2 where x is current date )")
		public void testHappyDay140116() throws Exception {
			
			gstrTCID = "140116";
			gstrTO	 = "Verify that a Ad Hoc event can be created selecting to start & end the event at specified date & "
					+ "time (Start say, 4:00 PM & day as x+1 & end at 3:00 PM and day as x+2 where x is current date )";
		
			Event_data objEvent_data=new Event_data();
			Date_Time_settings objDts = new Date_Time_settings();
			OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
			Login_data objLogin_data = new Login_data();
		
			Login login_page1 = new Login(this.driver1);
			RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
			EventManagement EventManagement_page1=new EventManagement(this.driver1);
			ResourceType ResourceType_Page1=new ResourceType(this.driver1);
			Resource Resource_Page1 =new Resource(this.driver1);
			String strRegionName[]=new String[1];
			String strstatusTypeNames[]=new String[10];
			String strstatusTypeValues[]=new String[10];
			String strResourceName[]=new String[1];
			String strResourceValue[]=new String[1];
			String strResourceTypeName[]=new String[1];
			String strUserNameAndPwd[]=new String[2];
			
			String strFilePath = objLogin_data.strTestDataPath;
			strRegionName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
			
			strUserNameAndPwd[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 15, strFilePath);
			strUserNameAndPwd[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 16, strFilePath);
			
			strResourceTypeName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 13, strFilePath);
			strResourceName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
			strResourceValue[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
			
			strstatusTypeNames[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 3, strFilePath);	
			strstatusTypeNames[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 4, strFilePath);		
			strstatusTypeNames[2]=objOffCommonFunc.readInfoExcel("TestData", 2, 5, strFilePath);
			strstatusTypeNames[3]=objOffCommonFunc.readInfoExcel("TestData", 2, 6, strFilePath);
			strstatusTypeNames[4]=objOffCommonFunc.readInfoExcel("TestData", 2, 7, strFilePath);
			strstatusTypeNames[5]=objOffCommonFunc.readInfoExcel("TestData", 2, 8, strFilePath);
			strstatusTypeNames[6]=objOffCommonFunc.readInfoExcel("TestData", 2, 9, strFilePath);
			strstatusTypeNames[7]=objOffCommonFunc.readInfoExcel("TestData", 2, 10, strFilePath);
			strstatusTypeNames[8]=objOffCommonFunc.readInfoExcel("TestData", 2, 11, strFilePath);
			strstatusTypeNames[9]=objOffCommonFunc.readInfoExcel("TestData", 2, 12, strFilePath);
				
			strstatusTypeValues[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);	
			strstatusTypeValues[1]=objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);		
			strstatusTypeValues[2]=objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
			strstatusTypeValues[3]=objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
			strstatusTypeValues[4]=objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
			strstatusTypeValues[5]=objOffCommonFunc.readInfoExcel("TestData", 3, 8, strFilePath);
			strstatusTypeValues[6]=objOffCommonFunc.readInfoExcel("TestData", 3, 9, strFilePath);
			strstatusTypeValues[7]=objOffCommonFunc.readInfoExcel("TestData", 3, 10, strFilePath);
			strstatusTypeValues[8]=objOffCommonFunc.readInfoExcel("TestData", 3, 11, strFilePath);
			strstatusTypeValues[9]=objOffCommonFunc.readInfoExcel("TestData", 3, 12, strFilePath);
			   
		  System.out.println("-----Precondition ends and test execution starts-------");
		
		  login_page1.loginToApplication(strUserNameAndPwd[0],
					strUserNameAndPwd[1]);
		
			RegionDefault_page1.selectFrame();
		
			EventManagement_page1.navigateToEventManagement()
			
			.clickOnCreateAdHocEventButton()
			
			.enterAdHocEventDetails(
					objEvent_data.strEventName, objEvent_data.strEventDescription);
		
		    objEvent_data.strEventStartTime = EventManagement_page1.getEventStartDateAndTime();
		    
		    objEvent_data.strEventStartTime = objDts.AddDaytoExistingDate(objEvent_data.strEventStartTime, 1, "yyyy-MMM-dd HH:mm");
		    
		    objEvent_data.strEventStartTime = objDts.converDateFormat(objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");	    
		    
		    String strStartTime[]  = objEvent_data.strEventStartTime.split(" ");
		    
		    strStartTime[3] = "04";
		    
		    strStartTime[4] = "00";
		    
		    EventManagement_page1.selectEventStartDateAndTime(strStartTime);
			
			objEvent_data.strEventEndTime = objDts.AddDaytoExistingDate(objEvent_data.strEventStartTime, 1, "yyyy MMM dd HH mm");
		
		    String strEndTime[]  = objEvent_data.strEventEndTime.split(" ");
		    
		    strEndTime[3] = "03";
		    
		    strEndTime[4] = "00";
		    
		    objEvent_data.strEventStartTime = strStartTime[0]+" "+strStartTime[1]+" "+strStartTime[2]+" "+strStartTime[3]+" "+strStartTime[4];
		
		    objEvent_data.strEventEndTime = strEndTime[0]+" "+strEndTime[1]+" "+strEndTime[2]+" "+strEndTime[3]+" "+strStartTime[4];
		    
			objEvent_data.strEventEndTime = objDts.converDateFormat(objEvent_data.strEventEndTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
		
			objEvent_data.strEventStartTime = objDts.converDateFormat(objEvent_data.strEventStartTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
		    
			EventManagement_page1
					.selectEventEndDateAndTime(strEndTime)
					
		            .clickOnNextButton()
			
			.verifyResourceInSelectResourcePage(strResourceValue);
		
			Resource_Page1.clickResource(strResourceValue);
		
			EventManagement_page1.clickOnNextButton()
			
			.verifyStatusTypesInSelectStausTypePage(strstatusTypeValues);
		
			ResourceType_Page1.clickStatusType(strstatusTypeValues);
		
			EventManagement_page1.clickOnNextButton()
			
			.clickOnYesButton()
		
			.verifyEventName(objEvent_data.strEventName)
		
			.verifyEventStartTime(objEvent_data.strEventName,
					objEvent_data.strEventStartTime)
		
			.verifyEventEndTime(objEvent_data.strEventName,
					objEvent_data.strEventEndTime);
			
			gstrResult = "PASS";
		}

		/*****************************************************************************
		'Description	:Verify that a Ad Hoc event can be created selecting to start 
		                 the event at specified date & time (say, 4:00 PM & day as 
		                 x+1 where x is current date) and to end never
		'Date	 		:12-June-2014
		'Author			:QSG
		*******************************************************************************/
		@Test(description = "Verify that a Ad Hoc event can be created selecting to start"
				           + " the event at specified date & time (say, 4:00 PM & day as"
				           + " x+1 where x is current date) and to end never")
		public void testHappyDay140117() throws Exception {
			
			gstrTCID = "140117";
			gstrTO	 = "Verify that a Ad Hoc event can be created selecting to start"
				           + " the event at specified date & time (say, 4:00 PM & day as"
				           + " x+1 where x is current date) and to end never";
		
			Event_data objEvent_data=new Event_data();
			Date_Time_settings objDts = new Date_Time_settings();
			OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
			Login_data objLogin_data = new Login_data();
			String strFilePath = objLogin_data.strTestDataPath;
		
			Login login_page1 = new Login(this.driver1);
			RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
			EventManagement EventManagement_page1=new EventManagement(this.driver1);
			ResourceType ResourceType_Page1=new ResourceType(this.driver1);
			Resource Resource_Page1 =new Resource(this.driver1);
			String strRegionName[]=new String[1];
			String strstatusTypeNames[]=new String[10];
			String strstatusTypeValues[]=new String[10];
			String strResourceName[]=new String[1];
			String strResourceValue[]=new String[1];
			String strResourceTypeName[]=new String[1];
			String strUserNameAndPwd[]=new String[2];
			
			strRegionName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
			
			strUserNameAndPwd[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 15, strFilePath);
			strUserNameAndPwd[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 16, strFilePath);
			
			strResourceTypeName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 13, strFilePath);
			strResourceName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
			strResourceValue[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
			
			strstatusTypeNames[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 3, strFilePath);	
			strstatusTypeNames[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 4, strFilePath);		
			strstatusTypeNames[2]=objOffCommonFunc.readInfoExcel("TestData", 2, 5, strFilePath);
			strstatusTypeNames[3]=objOffCommonFunc.readInfoExcel("TestData", 2, 6, strFilePath);
			strstatusTypeNames[4]=objOffCommonFunc.readInfoExcel("TestData", 2, 7, strFilePath);
			strstatusTypeNames[5]=objOffCommonFunc.readInfoExcel("TestData", 2, 8, strFilePath);
			strstatusTypeNames[6]=objOffCommonFunc.readInfoExcel("TestData", 2, 9, strFilePath);
			strstatusTypeNames[7]=objOffCommonFunc.readInfoExcel("TestData", 2, 10, strFilePath);
			strstatusTypeNames[8]=objOffCommonFunc.readInfoExcel("TestData", 2, 11, strFilePath);
			strstatusTypeNames[9]=objOffCommonFunc.readInfoExcel("TestData", 2, 12, strFilePath);
				
			strstatusTypeValues[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);	
			strstatusTypeValues[1]=objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);		
			strstatusTypeValues[2]=objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
			strstatusTypeValues[3]=objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
			strstatusTypeValues[4]=objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
			strstatusTypeValues[5]=objOffCommonFunc.readInfoExcel("TestData", 3, 8, strFilePath);
			strstatusTypeValues[6]=objOffCommonFunc.readInfoExcel("TestData", 3, 9, strFilePath);
			strstatusTypeValues[7]=objOffCommonFunc.readInfoExcel("TestData", 3, 10, strFilePath);
			strstatusTypeValues[8]=objOffCommonFunc.readInfoExcel("TestData", 3, 11, strFilePath);
			strstatusTypeValues[9]=objOffCommonFunc.readInfoExcel("TestData", 3, 12, strFilePath);
			   
		  System.out.println("-----Precondition ends and test execution starts-------");
		
			login_page1.loginToApplication(strUserNameAndPwd[0],
					strUserNameAndPwd[1]);
		
			RegionDefault_page1.selectFrame();
		
			EventManagement_page1.navigateToEventManagement()
			
			.clickOnCreateAdHocEventButton()
			
			.enterAdHocEventDetails(
					objEvent_data.strEventName, objEvent_data.strEventDescription);
		
		    objEvent_data.strEventStartTime = EventManagement_page1.getEventStartDateAndTime();
		    
		    objEvent_data.strEventStartTime = objDts.AddDaytoExistingDate(objEvent_data.strEventStartTime, 1, "yyyy-MMM-dd HH:mm");
		    
		    objEvent_data.strEventStartTime = objDts.converDateFormat(objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");	    
		    
		    String strStartTime[]  = objEvent_data.strEventStartTime.split(" ");
		    
		    strStartTime[3] = "04";
		    
		    strStartTime[4] = "00";
		    
		    EventManagement_page1.selectEventStartDateAndTime(strStartTime);
		
		    objEvent_data.strEventStartTime = strStartTime[0]+" "+strStartTime[1]+" "+strStartTime[2]+" "+strStartTime[3]+" "+strStartTime[4];
		    
		    objEvent_data.strEventEndTime = objDts.addTimetoExistingHour(
					objEvent_data.strEventStartTime, 4, "yyyy MMM dd HH mm");
		
			objEvent_data.strEventEndTime = objDts.converDateFormat(objEvent_data.strEventEndTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
		
			objEvent_data.strEventStartTime = objDts.converDateFormat(objEvent_data.strEventStartTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
			
			EventManagement_page1
					.clickEventNeverEndRadioButton()
					
		            .clickOnNextButton()
		            
		            .clickOnKeepButton()
			
			.verifyResourceInSelectResourcePage(strResourceValue);
		
			Resource_Page1.clickResource(strResourceValue);
		
			EventManagement_page1.clickOnNextButton()
			
			.verifyStatusTypesInSelectStausTypePage(strstatusTypeValues);
		
			ResourceType_Page1.clickStatusType(strstatusTypeValues);
		
			EventManagement_page1.clickOnNextButton()
			
			.clickOnYesButton()
		
			.verifyEventName(objEvent_data.strEventName)
		
			.verifyEventStartTime(objEvent_data.strEventName,
					objEvent_data.strEventStartTime)
		
			.verifyEventEndTimeWhenItSetToNever(objEvent_data.strEventName,
					objEvent_data.strEndNever);
			
			gstrResult = "PASS";
		}

		/********************************************************************************
		'Description	:Verify that Ad Hoc event can not be created by deselecting the 
		                 option 'Display in Event Banner'.
		'Date	 		:18-June-2014
		'Author			:Sowmya
		
		Modified By: Sangappa K                        Date:19-May-16
		**********************************************************************************/
		@Test(description = "Verify that Ad Hoc event can not be created by deselecting the " +
				"option 'Display in Event Banner'.")
		public void testHappyDay140119() throws Exception {
			
			gstrTCID = "140119";
			gstrTO	 = "Verify that Ad Hoc event can not be created by deselecting the " +
				"option 'Display in Event Banner'.";
			
		Login_data objLogin_data = new Login_data();
		Event_data objEvent_data = new Event_data();
		Date_Time_settings objDts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strFilePath = objLogin_data.strTestDataPath;

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		ResourceType ResourceType_Page1 = new ResourceType(this.driver1);
		Resource Resource_Page1 = new Resource(this.driver1);
		String strRegionName[] = new String[1];
		String strstatusTypeNames[] = new String[10];
		String strstatusTypeValues[] = new String[10];
		String strResourceName[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeName[] = new String[1];
		String strUserNameAndPwd[] = new String[2];

		strRegionName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 2,
				strFilePath);

		strUserNameAndPwd[0] = objOffCommonFunc.readInfoExcel("TestData", 2,
				15, strFilePath);
		strUserNameAndPwd[1] = objOffCommonFunc.readInfoExcel("TestData", 2,
				16, strFilePath);

		strResourceTypeName[0] = objOffCommonFunc.readInfoExcel("TestData", 2,
				13, strFilePath);
		strResourceName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 14,
				strFilePath);
		strResourceValue[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 14,
				strFilePath);

		strstatusTypeNames[0] = objOffCommonFunc.readInfoExcel("TestData", 2,
				3, strFilePath);
		strstatusTypeNames[1] = objOffCommonFunc.readInfoExcel("TestData", 2,
				4, strFilePath);
		strstatusTypeNames[2] = objOffCommonFunc.readInfoExcel("TestData", 2,
				5, strFilePath);
		strstatusTypeNames[3] = objOffCommonFunc.readInfoExcel("TestData", 2,
				6, strFilePath);
		strstatusTypeNames[4] = objOffCommonFunc.readInfoExcel("TestData", 2,
				7, strFilePath);
		strstatusTypeNames[5] = objOffCommonFunc.readInfoExcel("TestData", 2,
				8, strFilePath);
		strstatusTypeNames[6] = objOffCommonFunc.readInfoExcel("TestData", 2,
				9, strFilePath);
		strstatusTypeNames[7] = objOffCommonFunc.readInfoExcel("TestData", 2,
				10, strFilePath);
		strstatusTypeNames[8] = objOffCommonFunc.readInfoExcel("TestData", 2,
				11, strFilePath);
		strstatusTypeNames[9] = objOffCommonFunc.readInfoExcel("TestData", 2,
				12, strFilePath);

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
		strstatusTypeValues[5] = objOffCommonFunc.readInfoExcel("TestData", 3,
				8, strFilePath);
		strstatusTypeValues[6] = objOffCommonFunc.readInfoExcel("TestData", 3,
				9, strFilePath);
		strstatusTypeValues[7] = objOffCommonFunc.readInfoExcel("TestData", 3,
				10, strFilePath);
		strstatusTypeValues[8] = objOffCommonFunc.readInfoExcel("TestData", 3,
				11, strFilePath);
		strstatusTypeValues[9] = objOffCommonFunc.readInfoExcel("TestData", 3,
				12, strFilePath);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		System.out.println(strUserNameAndPwd[0]);
		System.out.println(strUserNameAndPwd[1]);

		login_page1.loginToApplication(strUserNameAndPwd[0],
				strUserNameAndPwd[1]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1.navigateToEventManagement()
				.clickOnCreateAdHocEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		objEvent_data.strEventStartTime = EventManagement_page1
				.getEventStartDateAndTime();

		objEvent_data.strEventStartTime = objDts.converDateFormat(
				objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm",
				"yyyy-MM-dd HH:mm");

		EventManagement_page1.deSelectCheckBoxOfDisplayInEventBanner()
				.clickOnNextButton().verifySelectResourcesDisplayed()
				.verifyResourceNameInSelectResourcePage(strResourceName)
				.clickOnNextButton().verifySelectStatusTypesDisplayed();

		String[] strStatusTypeNames = { strstatusTypeNames[7],
				strstatusTypeNames[9], strstatusTypeNames[5],
				strstatusTypeNames[8], strstatusTypeNames[6],
				strstatusTypeNames[2], strstatusTypeNames[4],
				strstatusTypeNames[0], strstatusTypeNames[3],
				strstatusTypeNames[1] };

		EventManagement_page1.clickOnNextButton()
				.verifyAdHocEventConfirmationDisplayed().clickOnYesButton()
				.verifyErrorMsgForEventBanner().clickOnPreviousButton();

		Thread.sleep(20000);
		EventManagement_page1.clickOnPreviousButton();
		Thread.sleep(20000);
		EventManagement_page1.verifySelectResourcesDisplayed();

		Resource_Page1.clickResource(strResourceValue);

		EventManagement_page1.clickOnNextButton();

		String[] strStatusTypeValues = { strstatusTypeValues[7],
				strstatusTypeValues[9], strstatusTypeValues[5],
				strstatusTypeValues[8], strstatusTypeValues[6],
				strstatusTypeValues[2], strstatusTypeValues[4],
				strstatusTypeValues[0], strstatusTypeValues[3],
				strstatusTypeValues[1] };

		EventManagement_page1
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypeNames);

		ResourceType_Page1.clickStatusType(strStatusTypeValues);

		EventManagement_page1.clickOnNextButton().clickOnYesButton()
				.verifyEventName(objEvent_data.strEventName);

		String strActualTime = EventManagement_page1.verifyEventStartTimeNew(
				objEvent_data.strEventName, objEvent_data.strEventStartTime);

		objEvent_data.strEventEndTime = objDts.AddDaytoExistingDate(
				strActualTime, 1, "yyyy-MM-dd HH:mm");

		EventManagement_page1.verifyEventEndTime(objEvent_data.strEventName,
				objEvent_data.strEventEndTime);

		login_page1.clickLogOut();
			
			gstrResult = "PASS";
		}
		
		/*****************************************************************************
		'Description	:Verify that a never ending Ad Hoc event can be edited to end on a certain date at a specified time.
		'Date	 		:22-June-2014
		'Author			:Anil
		*******************************************************************************/
		@Test(description = "Verify that a never ending Ad Hoc event can be edited to end on a certain date at a specified time.")
		public void testHappyDay140390() throws Exception {
			
			gstrTCID = "140390";
			gstrTO	 = "Verify that a never ending Ad Hoc event can be edited to end on a certain date at a specified time.";
		
			Event_data objEvent_data=new Event_data();
			Date_Time_settings objDts = new Date_Time_settings();
			OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
			Login_data objLogin_data = new Login_data();

			Login login_page1 = new Login(this.driver1);
			RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
			EventManagement EventManagement_page1=new EventManagement(this.driver1);
			ResourceType ResourceType_Page1=new ResourceType(this.driver1);
			Resource Resource_Page1 =new Resource(this.driver1);
			String strRegionName[]=new String[1];
			String strstatusTypeNames[]=new String[10];
			String strstatusTypeValues[]=new String[10];
			String strResourceName[]=new String[1];
			String strResourceValue[]=new String[1];
			String strResourceTypeName[]=new String[1];
			String strUserNameAndPwd[]=new String[2];
			
			String strFilePath = objLogin_data.strTestDataPath;
			strRegionName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
			
			strUserNameAndPwd[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 15, strFilePath);
			strUserNameAndPwd[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 16, strFilePath);
			
			strResourceTypeName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 13, strFilePath);
			strResourceName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
			strResourceValue[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
			
			strstatusTypeNames[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 3, strFilePath);	
			strstatusTypeNames[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 4, strFilePath);		
			strstatusTypeNames[2]=objOffCommonFunc.readInfoExcel("TestData", 2, 5, strFilePath);
			strstatusTypeNames[3]=objOffCommonFunc.readInfoExcel("TestData", 2, 6, strFilePath);
			strstatusTypeNames[4]=objOffCommonFunc.readInfoExcel("TestData", 2, 7, strFilePath);
			strstatusTypeNames[5]=objOffCommonFunc.readInfoExcel("TestData", 2, 8, strFilePath);
			strstatusTypeNames[6]=objOffCommonFunc.readInfoExcel("TestData", 2, 9, strFilePath);
			strstatusTypeNames[7]=objOffCommonFunc.readInfoExcel("TestData", 2, 10, strFilePath);
			strstatusTypeNames[8]=objOffCommonFunc.readInfoExcel("TestData", 2, 11, strFilePath);
			strstatusTypeNames[9]=objOffCommonFunc.readInfoExcel("TestData", 2, 12, strFilePath);
				
			strstatusTypeValues[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);	
			strstatusTypeValues[1]=objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);		
			strstatusTypeValues[2]=objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
			strstatusTypeValues[3]=objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
			strstatusTypeValues[4]=objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
			strstatusTypeValues[5]=objOffCommonFunc.readInfoExcel("TestData", 3, 8, strFilePath);
			strstatusTypeValues[6]=objOffCommonFunc.readInfoExcel("TestData", 3, 9, strFilePath);
			strstatusTypeValues[7]=objOffCommonFunc.readInfoExcel("TestData", 3, 10, strFilePath);
			strstatusTypeValues[8]=objOffCommonFunc.readInfoExcel("TestData", 3, 11, strFilePath);
			strstatusTypeValues[9]=objOffCommonFunc.readInfoExcel("TestData", 3, 12, strFilePath);
			   
		  System.out.println("-----Precondition ends and test execution starts-------");
		
			login_page1.loginToApplication(strUserNameAndPwd[0],
					strUserNameAndPwd[1]);
		
			RegionDefault_page1.selectFrame();
		
			EventManagement_page1.navigateToEventManagement()
			
			.clickOnCreateAdHocEventButton()
			
			.enterAdHocEventDetails(
					objEvent_data.strEventName, objEvent_data.strEventDescription);
		
			objEvent_data.strEventStartTime = EventManagement_page1
					.getEventStartDateAndTime();
		
		    objEvent_data.strEventStartTime = objDts.addTimetoExisting(objEvent_data.strEventStartTime, 10, "yyyy-MMM-dd HH:mm");
		    
		    objEvent_data.strEventStartTime = objDts.converDateFormat(objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");	    
		    
		    String strStartTime[]  = objEvent_data.strEventStartTime.split(" ");
		    
		    EventManagement_page1.selectEventStartDateAndTime(strStartTime);
		    
			objEvent_data.strEventStartTime = objDts.converDateFormat(
					objEvent_data.strEventStartTime, "yyyy MMM dd HH mm",
					"yyyy-MM-dd HH:mm");
		
			EventManagement_page1
					.clickEventNeverEndRadioButton()
					
		            .clickOnNextButton()
		            
		            .clickOnKeepButton()
			
			.verifyResourceInSelectResourcePage(strResourceValue);
		
			Resource_Page1.clickResource(strResourceValue);
		
			EventManagement_page1.clickOnNextButton()
			
			.verifyStatusTypesInSelectStausTypePage(strstatusTypeValues);
		
			ResourceType_Page1.clickStatusType(strstatusTypeValues);
		
			EventManagement_page1.clickOnNextButton()
			
			.clickOnYesButton();
		
					
		String actualTime = EventManagement_page1.verifyEventStartTimeNew(
				objEvent_data.strEventName, objEvent_data.strEventStartTime);
	
		objEvent_data.strEventEndTime = objDts.AddDaytoExistingDate(actualTime, 1, "yyyy-MM-dd HH:mm");
		
		EventManagement_page1.verifyEventName(objEvent_data.strEventName)
		
			.verifyEventStartTime(objEvent_data.strEventName,
					objEvent_data.strEventStartTime)
		
			.verifyEventEndTimeWhenItSetToNever(objEvent_data.strEventName,
					objEvent_data.strEndNever)
		
			.clickOnEditLink(objEvent_data.strEventName);
			
		objEvent_data.strGetEventStartTime = objDts.AddTimeToExistingTimeHourAndMin(objEvent_data.strEventEndTime, 0, 30, "yyyy-MM-dd HH:mm");
	
		objEvent_data.strGetEventStartTime = objDts.converDateFormat(objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm", "yyyy MMM dd HH mm");
	
		String strUpdatedEventEndTime = objDts.converDateFormat(objEvent_data.strGetEventStartTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
	
		String strEndTime[] = objEvent_data.strGetEventStartTime.split(" ");
		
		EventManagement_page1.selectEventEndDateAndTime(strEndTime)
			
			.clickOnNextButton()
			
			.clickOnNextButton()
			
			.clickOnNextButton()
			
			.clickOnYesButton();
		
		EventManagement_page1.verifyEventStartTime(objEvent_data.strEventName, actualTime)
		                     .verifyEventEndTime(objEvent_data.strEventName, strUpdatedEventEndTime);
			
			String[] strTestData = {
					gstrTCID,
					strRegionName[0],
					strstatusTypeNames[7] + " " + strstatusTypeNames[9] + " "
							+ strstatusTypeNames[5] + " " + strstatusTypeNames[8]
							+ " " + strstatusTypeNames[6] + " "
							+ strstatusTypeNames[2] + " " + strstatusTypeNames[4]
							+ " " + strstatusTypeNames[0] + " "
							+ strstatusTypeNames[3] + " " + strstatusTypeNames[1],
					strResourceTypeName[0], strResourceName[0],
					objEvent_data.strGetEventStartTime, " ",
					" ", strUpdatedEventEndTime };
			
			objOffCommonFunc.writeResultData(strTestData, Login_data.strPartialAutoResultsPath, "AdhocEvents");
			
			gstrResult = "PASS";
		}
		

		/********************************************************************************
		'Description	:Verify that user receives event update notifications when an Ad Hoc event is edited. 
		'Date	 		:12-June-2014
		'Author			:Anil
		**********************************************************************************/
		@Test(description = "Verify that user receives event update notifications when an Ad Hoc event is edited. ")
		public void testHappyDay140383() throws Exception {
			
			gstrTCID = "140383";
			gstrTO	 = "Verify that user receives event update notifications when an Ad Hoc event is edited. ";
		
			Login login_page = new Login(this.driver1);
			Login_data objTest_data = new Login_data();
			Event_data objEvent_data=new Event_data();
			User_data objUser_data = new User_data();
			OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
			String strFilePath = Login_data.strTestDataPath;
	
			SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
			RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		    UsersList UsersList_page = new UsersList(this.driver1);
		    EventSetUp EventSetUp_page = new EventSetUp(this.driver1);	  
		    
			String strstatusTypeValues[]=new String[10];
			String strResourceValue[]=new String[1];
			String strResourceTypeName[] = new String[1];
			String strResourceName[]= new String[1];
			
			Login login_page1 = new Login(this.driver1);
			RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
			EventManagement EventManagement_page1=new EventManagement(this.driver1);
			ResourceType ResourceType_Page1=new ResourceType(this.driver1);
			Resource Resource_Page1 =new Resource(this.driver1);
			MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
					this.driver1);
			String strRegionName[] = new String[1];
			
			strRegionName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
			
			strResourceTypeName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 13, strFilePath);
			strResourceName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
			strResourceValue[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);

		
			strstatusTypeValues[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);
			strstatusTypeValues[1] = objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);
			strstatusTypeValues[2] = objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
			strstatusTypeValues[3] = objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
			strstatusTypeValues[4] = objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
			strstatusTypeValues[5] = objOffCommonFunc.readInfoExcel("TestData", 3, 8, strFilePath);
			strstatusTypeValues[6] = objOffCommonFunc.readInfoExcel("TestData", 3, 9, strFilePath);
			strstatusTypeValues[7] = objOffCommonFunc.readInfoExcel("TestData", 3, 10, strFilePath);
			strstatusTypeValues[8] = objOffCommonFunc.readInfoExcel("TestData", 3, 11, strFilePath);
			strstatusTypeValues[9] = objOffCommonFunc.readInfoExcel("TestData", 3, 12, strFilePath);
			
			login_page.loginToApplication(objTest_data.strUserName,
					objTest_data.strPassword);
		
			SelectRegion_page.selectRegionAndNavigate(strRegionName[0]);
		
			RegionDefault_page.selectFrame();
		
			//User creation
			
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
								
					.clickAdvancedOptionAndExpand()
		
					.selectMaintainEventsOption()
		
					.selectMaintainAdHocEventsOption()
		
					.clickSaveButton();
				
			EventSetUp_page.navigateToEventSetUp();
			
			EventSetUp_page.navigateToEventNotificationPreferences(objEvent_data.strAdHocEventTempName);
			EventSetUp_page.deselectSelectAllEmailOption()
			.deselectSelectAllPagerOption()
			.deselectSelectAllWebOptionOnly()
			.deselectSelectAllResOption()
			.clickOnEmailCheckBox(objUser_data.strNewUserName)
			.clickOnPagerCheckBox(objUser_data.strNewUserName)
			.clickOnWebCheckBox(objUser_data.strNewUserName)
			.clickSaveButton();
			login_page.clickLogOut();	
			
			System.out.println(objUser_data.strNewUserName);
			   
			System.out.println("-----Precondition ends and test execution starts-------");
		
		    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
		    
		    RegionDefault_page1.selectFrame();
		    
		    EventManagement_page1.navigateToEventManagement()
		    
		    .clickOnCreateAdHocEventButton()
		    
		    .enterAdHocEventName(objEvent_data.strEventName)
		    
		    .enterAdHocEventDescription(objEvent_data.strEventDescription)
		    
		    .clickOnNextButton();
		    		    
		    Resource_Page1.clickResource(strResourceValue);
		    
		    EventManagement_page1.clickOnNextButton()
		    
		    .verifyStatusTypesInSelectStausTypePage(strstatusTypeValues);
		    
		    ResourceType_Page1.clickStatusType(strstatusTypeValues);
		    
		    EventManagement_page1.clickOnNextButton()
		    
		    .clickOnYesButton()
		    
		    .verifyEventName(objEvent_data.strEventName)
		    
		    .verWebNotificationframe()
			.verWebNotificationAndAcknowledge(objEvent_data.strEventName, objEvent_data.strEventDescription)
			.clickAcknowledgeAllNotifications()
			.selectFrame()
		    .clickOnEditLink(objEvent_data.strEventName)
		    
		  	.enterAdHocEventName(objEvent_data.strEditedEventName)
		    
		    .enterAdHocEventDescription(objEvent_data.strEditedEventDescription)
		    
		    .clickOnNextButton()
		    
		    .clickOnNextButton()
		    
		    .clickOnNextButton()
		    		    
		    .clickOnYesButton()
		    
		    .verifyEventName(objEvent_data.strEditedEventName)
		    		    
		    .verWebNotificationframe()
			.verWebNotificationAndAcknowledge(objEvent_data.strUpdatedEditEventName, objEvent_data.strEditedEventDescription)
			.clickAcknowledgeAllNotifications()
			.selectFrame()
			
			.verifyEventNameInEventBanner(objEvent_data.strUpdatedEditEventName);
				
			String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(objUser_data.strFullName, objUser_data.strFullName, strRegionName[0], objEvent_data.strEditedEventDescription);
			
			String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(objUser_data.strFullName, strRegionName[0], objEvent_data.strEditedEventDescription);
			
			objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
					objUser_data.strPrimaryPwsd);

			objMailVerificationFunctions.NavToInbox(objEvent_data.strUpdatedEditEventName);

			boolean blnMsg1 = false;
			boolean blnMsg2 = false;

			for (int intCount = 0; intCount < 2; intCount++) {

				objMailVerificationFunctions.verEmail(
						objUser_data.strPrimaryMailId, objEvent_data.strUpdatedEditEventName);

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