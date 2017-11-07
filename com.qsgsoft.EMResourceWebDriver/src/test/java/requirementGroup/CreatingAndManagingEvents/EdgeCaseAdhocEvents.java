package requirementGroup.CreatingAndManagingEvents;

import static org.testng.AssertJUnit.assertTrue;
import lib.dataObject.EventSetUp_data;
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

public class EdgeCaseAdhocEvents extends TestNG_UI_EXTENSIONS{

	public EdgeCaseAdhocEvents() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***************************************************************************************
	'Description	:Verify that appropriate validation message is displayed when an attempt 
	                 is made to create an Ad Hoc event without providing mandatory data.
	'Date	 		:6-June-2014
	'Author			:Anitha
	***************************************************************************************/
	
	@Test (description = "Verify that appropriate validation message is displayed when "
			+ "an attempt is made to create an Ad Hoc event without providing mandatory data.")
	public void testEdgeCase140378() throws Exception {
		
		gstrTCID = "140378";
		gstrTO	 = "Verify that appropriate validation message is displayed when "
			+ "an attempt is made to create an Ad Hoc event without providing mandatory data.";
		
		Login login_page = new Login(this.driver1);	
		Login_data login_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data=new Event_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1=new EventManagement(this.driver1);

	    login_page.loginToApplication(login_data.strUserName, login_data.strPassword);
	    	    
	    SelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);
	    
	    RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
	    
	    RegionDefault_page.selectFrame();
	    
	    UsersList_page.navigateToUsers();
	    	        
	    UsersList_page.clickCreateNewUserButton();
	    
	    UsersList_page.enterUserDetails(objUser_data.strNewUserName,
	    		objUser_data.strNewPassword, objUser_data.strFullName);
	    
	    UsersList_page. clickAdvancedOptionAndExpand();
	    
	    UsersList_page.selectMaintainEventsOption();
	    
	    UsersList_page.selectMaintainAdHocEventsOption();
	    
	    UsersList_page.clickSaveButton();
	    
	    System.out.println(objUser_data.strNewUserName);
	   
  System.out.println("-----Precondition ends and test execution starts-------");
	       	    
	    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	    
	    RegionDefault_page1.selectFrame();
	    
	    EventManagement_page1.navigateToEventManagement();
	    
	    EventManagement_page1.verifyCreateEventButtonsDisplayed();
	    
	    EventManagement_page1.verifyAdHocEventButtonDisplayed();
	    
	    EventManagement_page1.clickOnCreateAdHocEventButton();
	    
	    EventManagement_page1.enterAdHocEventName(objEvent_data.strEventName);
	    
	    EventManagement_page1.clickOnNextButton();
	    
	    EventManagement_page1.verifyErrorMessageTitle();
	    
	    EventManagement_page1.verifyInfErrorMessageInCreateAdhocEventPage();
	    
	    EventManagement_page1.verifyCreateAdhocEventPage();
	    
	    EventManagement_page1.enterAdHocEventName(objEvent_data.strNullEventName);
	    
	    EventManagement_page1.enterAdHocEventDescription(objEvent_data.strEventDescription);
	    
	    EventManagement_page1.clickOnNextButton();
	    
	    EventManagement_page1.verifyErrorMessageTitle();
	    
        EventManagement_page1.verifyTitleErrorMessageInCreateAdhocEventPage();
	    
	    EventManagement_page1.verifyCreateAdhocEventPage();
	    
	    gstrResult="PASS";
	}
	
	/***************************************************************************************
	'Description	:Verify that Ad Hoc event cannot be created providing past end date.
	'Date	 		:6-June-2014
	'Author			:Anitha
	***************************************************************************************/
	
	@Test (description = "Verify that Ad Hoc event cannot be created providing past end date.")
	public void testEdgeCase140393() throws Exception {
	
		gstrTCID = "140393";
		gstrTO	 = "Verify that Ad Hoc event cannot be created providing past end date.";
		
		Login login_page = new Login(this.driver1);	
		Login_data objLogin_data = new Login_data();
		User_data objUser_data=new User_data();
		Event_data objEvent_data=new Event_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Date_Time_settings dts = new Date_Time_settings();
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1=new EventManagement(this.driver1);

	    login_page.loginToApplication(objLogin_data.strUserName, objLogin_data.strPassword);
	    	    
	    SelectRegion_page.selectRegionAndNavigate(objLogin_data.strRegionName);
	    
	    RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
	    
	    RegionDefault_page.selectFrame();
	    
	    UsersList_page.navigateToUsers();
	    	        
	    UsersList_page.clickCreateNewUserButton();
	    
	    UsersList_page.enterUserDetails(objUser_data.strNewUserName,
	    		objUser_data.strNewPassword, objUser_data.strFullName);
	    
	    UsersList_page. clickAdvancedOptionAndExpand();
	    
	    UsersList_page.selectMaintainEventsOption();
	    
	    UsersList_page.selectMaintainAdHocEventsOption();
	    
	    UsersList_page.clickSaveButton();
	    
	    System.out.println(objUser_data.strNewUserName);
	    
        String strApplTimeD1 = dts.getPastDayNew(1,"M/d/yyyy");
	    
	    String[] strDate=strApplTimeD1.split("/");
	    
	    System.out.println(strDate[1]);
	   
  System.out.println("-----Precondition ends and test execution starts-------");
	       	    
	    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	    
	    RegionDefault_page1.selectFrame();
	    
		EventManagement_page1.navigateToEventManagement()

		.clickOnCreateAdHocEventButton()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.clickEventEndRadioButton()

		.selectEventEndDay(strDate[1])

		.clickOnNextButton()

		.verifyErrorMessageTitle()

		.verifyPastTimeErrorMessageInCreateAdhocEventPage()

		.verifyCreateAdhocEventPage();
	    
		gstrResult="PASS";
	}
	/***************************************************************************************
	'Description	:Verify that Ad Hoc event cannot be created providing Start date=End date
	'Date	 		:6-June-2014
	'Author			:Anil
	***************************************************************************************/

	@Test (description = "Verify that Ad Hoc event cannot be created providing Start date=End date")
	public void testEdgeCase140377() throws Exception{

		gstrTCID = "140377";
		gstrTO	 = "Verify that Ad Hoc event cannot be created providing Start date=End date";
		
		Login login_page = new Login(this.driver1);
		Login_data objLogin_data = new Login_data();
		User_data objUser_data=new User_data();
		Event_data objEvent_data=new Event_data();
	    SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
	    RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
	    UsersList UsersList_page = new UsersList(this.driver1);	
	    
	    RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
	    Login login_page1 = new Login(this.driver1);
	    EventManagement EventManagement_page1 = new EventManagement(this.driver1); 
	    Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	    
	    login_page.loginToApplication(objLogin_data.strUserName, objLogin_data.strPassword);
	    
	    SelectRegion_page.selectRegionAndNavigate(objLogin_data.strRegionName);
	    
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

	    RegionDefault_page1.selectFrame()
	    
	    .verifyRegionDefaultPage(); 

	    EventManagement_page1.navigateToEventManagement()
	    
	    .verifyCreateEventButtonsDisplayed()
	    
	    .clickOnCreateAdHocEventButton()
	    
	    .enterAdHocEventDetails(objEvent_data.strEventName, objEvent_data.strEventDescription);

	    objEvent_data.strEventStartTime = EventManagement_page1.getEventStartDateAndTime();
	    
	    objEvent_data.strEventStartTime = objDate_Time_settings.AddDaytoExistingDate(objEvent_data.strEventStartTime, 1, "yyyy-MMM-dd HH:mm");
	    
	    objEvent_data.strEventStartTime = objDate_Time_settings.converDateFormat(objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");	    
	    
	    String strEndTime[]  = objEvent_data.strEventStartTime.split(" ");
	    
	    EventManagement_page1.selectEventEndDateAndTime(strEndTime)
	    
	    .selectEventStartDateAndTime(strEndTime)
	    
	    .clickOnNextButton()
	    
	    . verifyErrorMessageTitle().verifyErrorMessageForSameStartAndEndDate();

	    gstrResult="PASS";
	}
	/********************************************************************************************************
	'Description	:Verify that user cannot update the ended event end time when he is on 'Event Management'
	                 screen while the event was ended by another user.
	'Date	 		:8-Aug-2014
	'Author			:QSG
	*********************************************************************************************************/
	@Test(description = "Verify that user cannot update the ended event end time when he is on "
			+ "'Event Management' screen while the event was ended by another user.")
	public void testEdgeCase140669() throws Exception {

		gstrTCID = "140669";
		gstrTO	 = "Verify that user cannot update the ended event end time when he is on "
			+ "'Event Management' screen while the event was ended by another user.";

		
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// User creation -USER 1
		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// User creation -USER 2

		UsersList_page.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName2);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.clickOncreateEventTemplate()

		.enterEventTemplateName(objEventSetUp_data.strEventTemplate)

		.enterEventTemplateDefintion(objEventSetUp_data.strTemplateDefinition)
		
		.clickSaveButton()

		.deselectSelectAllWebOption();

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

		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.clickOnSaveButton()

		.clickOnEndEvent(objEvent_data.strEventName);

		login_page1.clickLogOut()

		.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();

		EventManagement_page1.navigateToEventManagement()

		.verifyEditEventIsNotDisplayed(objEvent_data.strEventName)

		.verifyEndEventIsNotDisplayed(objEvent_data.strEventName);

		gstrResult = "PASS";
	}
	
	@Test(description = " Verify that Ad Hoc event can be created by selecting 'Drill?' option")
	public void testEdgeCase140382() throws Exception {
		
		gstrTCID = "140382";
		gstrTO	 = " Verify that Ad Hoc event can be created by selecting 'Drill?' option";
		
		Event_data objEvent_data=new Event_data();
		Login_data objLogin_data = new Login_data();
		Date_Time_settings objDts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
		String strFilePath = objLogin_data.strTestDataPath;

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
		EventManagement EventManagement_page1=new EventManagement(this.driver1);
		ResourceType ResourceType_Page1=new ResourceType(this.driver1);
		Resource Resource_Page1 =new Resource(this.driver1);
		EventStatus objEventStatus = new EventStatus(this.driver1);
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
System.out.println(strUserNameAndPwd[0]);
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

		EventManagement_page1.selectDrillCheckBox()
                             .clickOnNextButton()
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
		
		String strEventName = "Drill: " +  objEvent_data.strEventName;
		
		EventManagement_page1.clickOnEventNameInEventBanner(strEventName);
		
		objEventStatus.verResourceTypeAndResourceName(strResourceTypeName[0], strResourceName[0]);
		
		for(int intCount = 0; intCount<strStatusTypeNames.length; intCount++){
			objEventStatus.verStatusTypes(strResourceTypeName[0], strStatusTypeNames[intCount]);
		}
		login_page1.clickLogOut();
		gstrResult = "PASS";
		
	}
	/**************************************************************************************************
	'Description	:Verify that canceling the process of ending a Ad Hoc event does not end the event.
	'Date	 		:25-June-2014
	'Author			:Anitha
	***************************************************************************************************/
	@Test(description = "Verify that canceling the process of ending a Ad Hoc event does not end the event.")
	public void testEdgeCase140394() throws Exception {

		gstrTCID = "140394";
		gstrTO	 = " Verify that canceling the process of ending a Ad Hoc event does not end the event.";
		
		Login_data objLogin_data = new Login_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strFilePath = objLogin_data.strTestDataPath;

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);

		String strUserNameAndPwd[] = new String[2];
		
		strUserNameAndPwd[0] = objOffCommonFunc.readInfoExcel("TestData", 2,
				15, strFilePath);
		strUserNameAndPwd[1] = objOffCommonFunc.readInfoExcel("TestData", 2,
				16, strFilePath);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginToApplication(strUserNameAndPwd[0],
				strUserNameAndPwd[1]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1.navigateToEventManagement()
				.clickOnCreateAdHocEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.clickOnNextButton()

		.clickOnNextButton()
		
		.clickOnNextButton()

		.clickOnYesButton()
		
		.cancelEndEvent(objEvent_data.strEventName)
		
		.verifyEventName(objEvent_data.strEventName)
		
		.verifyEditEventLink(objEvent_data.strEventName)
		
		.verifyEndEventLink(objEvent_data.strEventName);

		gstrResult = "PASS";
	}

	/********************************************************************************
	'Description	:Verify that an appropriate validation message is displayed when attempted to save an 'Ad Hoc' event selecting status type and without selecting resource. 
	'Date	 		:25-June-2014
	'Author			:Anil
	**********************************************************************************/
	@Test(description = "	Verify that an appropriate validation message is displayed when attempted to save an 'Ad Hoc' event selecting status type and without selecting resource. ")
	public void testEdgeCase140654() throws Exception {

		gstrTCID = "140654";
		gstrTO	 = "Verify that an appropriate validation message is displayed when attempted to save an 'Ad Hoc' event selecting status type and without selecting resource. ";

		Login_data objLogin_data = new Login_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strFilePath = objLogin_data.strTestDataPath;
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		ResourceType ResourceType_Page1 = new ResourceType(this.driver1);

		String strRegionName[] = new String[1];
		String strUserNameAndPwd[] = new String[2];
		String strstatusTypeNames[]=new String[2];
		String strstatusTypeValues[]=new String[2];
		
		strRegionName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 2,
				strFilePath);

		strUserNameAndPwd[0] = objOffCommonFunc.readInfoExcel("TestData", 2,
				15, strFilePath);
		strUserNameAndPwd[1] = objOffCommonFunc.readInfoExcel("TestData", 2,
				16, strFilePath);

		strstatusTypeNames[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 3, strFilePath);	
		strstatusTypeNames[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 4, strFilePath);		
			
		strstatusTypeValues[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);	
		strstatusTypeValues[1]=objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);		

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginToApplication(strUserNameAndPwd[0],
				strUserNameAndPwd[1]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1.navigateToEventManagement()
				.clickOnCreateAdHocEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		EventManagement_page1.clickOnNextButton();

		EventManagement_page1.clickOnNextButton();
		
		ResourceType_Page1.clickStatusType(strstatusTypeValues);
		
		EventManagement_page1.clickOnNextButton()

		.clickOnYesButton()

		.verifyErrorMessageTitle()

		.checkErrorMessageForStatusTypes();
		
		login_page1.clickLogOut();
		gstrResult = "PASS";
		
	}
	
	/********************************************************************************
	'Description	:Verify that an appropriate validation message is displayed when
	                 attempted to save an 'Ad Hoc' event selecting resource and 
	                 without selecting status type .
	'Date	 		:25-June-2014
	'Author			:Anitha
	**********************************************************************************/
	@Test(description = "Verify that an appropriate validation message is displayed when attempted "
			+ "to save an 'Ad Hoc' event selecting resource and without selecting status type .")
	public void testEdgeCase140655() throws Exception {

		gstrTCID = "140655";
		gstrTO	 = "Verify that an appropriate validation message is displayed when attempted "
			+ "to save an 'Ad Hoc' event selecting resource and without selecting status type .";

		
		Event_data objEvent_data = new Event_data();
		Login_data objLogin_data = new Login_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strFilePath = objLogin_data.strTestDataPath;

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		Resource Resource_Page1 = new Resource(this.driver1);

		String strRegionName[] = new String[1];
		String strResourceName[] = new String[1];
		String strResourceValue[] = new String[1];
		String strUserNameAndPwd[] = new String[2];

		strRegionName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 2,
				strFilePath);

		strUserNameAndPwd[0] = objOffCommonFunc.readInfoExcel("TestData", 2,
				15, strFilePath);
		strUserNameAndPwd[1] = objOffCommonFunc.readInfoExcel("TestData", 2,
				16, strFilePath);

		strResourceName[0] = objOffCommonFunc.readInfoExcel("TestData", 2, 14,
				strFilePath);
		strResourceValue[0] = objOffCommonFunc.readInfoExcel("TestData", 3, 14,
				strFilePath);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginToApplication(strUserNameAndPwd[0],
				strUserNameAndPwd[1]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1.navigateToEventManagement()
				.clickOnCreateAdHocEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				
		.clickOnNextButton();

		Resource_Page1.clickResource(strResourceValue);

		EventManagement_page1.clickOnNextButton()

		.clickOnNextButton()

		.clickOnYesButton()

		.verifyErrorMessageTitle1()

		.chkErrMsgCreateAdHocEventPage(strResourceName[0]);
		
		gstrResult = "PASS";
	}

	
	/********************************************************************************
	'Description	:Verify that user can update the status type and resource type selection made for an Ad Hoc event. 
	'Date	 		:21-July-2014
	'Author			:Sweta
	**********************************************************************************/
	@Test(description = "Verify that user can update the status type and resource type selection made for an Ad Hoc event.")
	public void testEdgeCase140656() throws Exception {
		

		gstrTCID = "140656";
		gstrTO	 = "Verify that user can update the status type and resource type selection made for an Ad Hoc event.";
		
		Login_data objLogin_data = new Login_data();
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion (this.driver1);
		StatusTypes_data objStatusTypes_data=new StatusTypes_data();
		String strstatusvalue [] = new String [5];
		ResourceType_data objResourceType = new ResourceType_data();
		ResourceType ResourceType_page1 = new ResourceType(this.driver1);
		String strresourcetypevalue [] = new String [2];
		Resource_data objResource = new Resource_data();
		Resource Resource_page1 = new Resource (this.driver1);
		String strresourcevalue [] = new String [2];
		EventManagement EventManagement_page = new EventManagement(this.driver1);
		Event_data objEvent = new Event_data();
		UsersList UsersList_page = new UsersList(this.driver1);	
		User_data objUser_data=new User_data();
		Login login_page = new Login(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		ResourceType ResourceType_page = new ResourceType(this.driver1);
		
		
		login_page1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword); 
		
		SelectRegion_page.selectRegionAndNavigate(objLogin_data.strRegionName);
		
		RegionDefault_page.selectFrame();
		
		StatusTypeList_page.navigateToStatusTypeList();
		
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		strstatusvalue[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		
		StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
		strstatusvalue[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		
		StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);
		
		strstatusvalue[2] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);
		
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		
		StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);
		
		strstatusvalue[3] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		
		StatusTypeList_page.createNewStatus(
					objStatusTypes_data.strStatusNameInMulti,
					objStatusTypes_data.strStatusColor)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		StatusTypeList_page.clickOnReturnToStatusTypeList();
		StatusTypeList_page.navigateToStatusTypeListNew();
		
		strstatusvalue[4] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		
		String strstatusname[] = {objStatusTypes_data.strMSTStatusTypeName,objStatusTypes_data.strSSTStatusTypeName,objStatusTypes_data.strTSTStatusTypeName};
		
		
		ResourceType_page1.navigateToResourceTypePage();
		String strstatusvalue1[] = { strstatusvalue[0], strstatusvalue[1] };
		
		ResourceType_page1.createResourceType(
				objResourceType.strResourceTypeName, strstatusvalue1);
		
		strresourcetypevalue[0] = ResourceType_page1
				.getResourceTypeValue(objResourceType.strResourceTypeName);
		
		String strstatusvalue2[] = { strstatusvalue[2], strstatusvalue[3],
				strstatusvalue[4] };
		
		ResourceType_page1.createResourceType(
				objResourceType.strResourceTypeName1, strstatusvalue2);
		
		strresourcetypevalue[1] = ResourceType_page1
				.getResourceTypeValue(objResourceType.strResourceTypeName1);
		
		Resource_page1.navigateToResourceListPage();
		
		Resource_page1.createResource(objResource.strResourceName,
				objResource.strResourceAbbrivation,
				objResourceType.strResourceTypeName,
				objResource.strStandardResourceTypename,
				objResource.strResourceFirstName,
				objResource.strResourceLastName);
		strresourcevalue [0] = Resource_page1.getResourceValue(objResource.strResourceName);
		
		Resource_page1.createResource(objResource.strResourceName1,
				objResource.strResourceAbbrivation,
				objResourceType.strResourceTypeName1,
				objResource.strStandardResourceTypename1,
				objResource.strResourceFirstName,
				objResource.strResourceLastName);
		strresourcevalue [1] = Resource_page1.getResourceValue(objResource.strResourceName1);
		
		
		UsersList_page.navigateToUsersNew();
		UsersList_page.clickCreateNewUserButton();
		UsersList_page.enterUserMandatoryDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName);
		UsersList_page.selectFirstRole();
		UsersList_page.selectViewResourceRights(objResource.strResourceName);
		
		UsersList_page.selectViewResourceRights(objResource.strResourceName1);
//		UsersList_page.selectViewResourceRight(strresourcevalue [0],true);
//		UsersList_page.selectViewResourceRight(strresourcevalue [1],true);
		UsersList_page.clickAdvancedOptionAndExpand();
		UsersList_page.selectMaintainAdHocEventsOption();
		UsersList_page.selectMaintainEventsOption();
		UsersList_page.clickSaveButton();
		
		login_page1.clickLogOut();
		
		login_page.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
		RegionDefault_page1.selectFrame();
		
		EventManagement_page.navigateToEventManagement();
		
		EventManagement_page.clickOnCreateAdHocEventButton();
		
		EventManagement_page.enterAdHocEventDetails(objEvent.strEventName,
				objEvent.strEventDescription);
		
		EventManagement_page.clickOnNextButton();
		
		EventManagement_page.selectResource(strresourcevalue[0]);
		
		EventManagement_page.clickOnNextButton();
		
		ResourceType_page1.clickStatusType(strstatusvalue1);
		
		EventManagement_page.clickOnNextButton();
		
		EventManagement_page.clickOnYesButton();
		
		EventManagement_page.verifyEventName(objEvent.strEventName);
		
		EventManagement_page1.clickOnEditLink(objEvent.strEventName);
		EventManagement_page1.clickOnNextButton();
		EventManagement_page1.verifySelectResourcesDisplayed();
		EventManagement_page1.deselectResource(strresourcevalue [0]);
		EventManagement_page1.selectResource(strresourcevalue [1]);
		EventManagement_page1.clickOnNextButton();
		EventManagement_page1.verifySelectStatusTypesDisplayed();
		ResourceType_page.clickStatusType(strstatusvalue2);
		EventManagement_page1.clickOnNextButton();
		EventManagement_page1.verifyAdHocEventConfirmationDisplayed();
		EventManagement_page1.clickOnYesButton();
		EventManagement_page1.verifyCreateEventButtonDisplayed();
		
		EventManagement_page1.clickOnEventNameInEventBanner("Update 1: "+objEvent.strEventName);
		
		EventManagement_page1.verifyStatusTypesInEventBanner(strstatusname, objResourceType.strResourceTypeName1);
		
		gstrResult = "PASS";
	}
	

	
	/********************************************************************************
	'Description	:Verify that cancelling the future Ad Hoc event does not start the event at the specified future start time. 
	'Date	 		:08-July-2014
	'Author			:QSG
	**********************************************************************************/
	@Test(description = "Verify that cancelling the future Ad Hoc event does not start the event at the specified future start time. ")
	public void testEdgeCase140379() throws Exception {


		gstrTCID = "140379";
		gstrTO	 = "Verify that cancelling the future Ad Hoc event does not start the event at the specified future start time. ";
		
		Event_data objEvent_data=new Event_data();
		Login_data objLogin_data = new Login_data();
		Date_Time_settings objDts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
		String strFilePath = objLogin_data.strTestDataPath;

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
		EventManagement EventManagement_page1=new EventManagement(this.driver1);
		EventStatus EventStatus_page1 = new EventStatus(this.driver1);
		
		String strRegionName[]=new String[1];
		String strUserNameAndPwd[]=new String[2];
		
		strRegionName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
		
		strUserNameAndPwd[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 15, strFilePath);
		strUserNameAndPwd[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 16, strFilePath);
		   
	  System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginToApplication(strUserNameAndPwd[0],
				strUserNameAndPwd[1]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1.navigateToEventManagement()
		
		.clickOnCreateAdHocEventButton()
		
		.enterAdHocEventDetails(
				objEvent_data.strEventName, objEvent_data.strEventDescription);

	    objEvent_data.strEventStartTime = EventManagement_page1.getEventStartDateAndTime();
	    
	    objEvent_data.strEventStartTime = objDts.AddTimeToExistingTimeHourAndMin(objEvent_data.strEventStartTime, 0, 5, "yyyy-MMM-dd HH:mm");
	    
	    objEvent_data.strEventStartTime = objDts.converDateFormat(objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy MMM dd HH mm");	    
	    
	    String strStartTime[]  = objEvent_data.strEventStartTime.split(" ");
	    
	    EventManagement_page1.selectEventStartDateAndTime(strStartTime);
			
		objEvent_data.strEventStartTime = objDts.converDateFormat(objEvent_data.strEventStartTime, "yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");
				
		EventManagement_page1.clickOnNextButton();

		EventManagement_page1.clickOnNextButton();

		EventManagement_page1.clickOnNextButton()
		
		.clickOnYesButton()

		.verifyEventName(objEvent_data.strEventName)

		.verifyEventStartTime(objEvent_data.strEventName,
				objEvent_data.strEventStartTime)
				
		.clickCancelEventLink(objEvent_data.strEventName);
		
		objEvent_data.strEventEndTime =EventManagement_page1.getEventEndTime(objEvent_data.strEventName);
		EventManagement_page1.verifyEventNotDisplayedInBanner(objEvent_data.strEventName);
		Thread.sleep(300000);
		
		EventManagement_page1.navigateToEventManagementNew();
		
		EventManagement_page1.verifyEventNotDisplayedInBanner(objEvent_data.strEventName);
		
		EventManagement_page1.verifyEventEndTime(objEvent_data.strEventName,
				objEvent_data.strEventEndTime)
				
		.verifyEventStartTime(objEvent_data.strEventName,
				objEvent_data.strEventStartTime)
				
		.verifyEventStatus(objEvent_data.strEventName,
				objEvent_data.strEnded);

		EventManagement_page1.verifyEventAction(objEvent_data.strEventName, objEvent_data.strViewHistoryAction);
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description	: Verify that user is taken to the Ad Hoc 'Event Staus' screen when 
	'				  clicked on the URL available in the Ad Hoc event notification received
	'				  when user is logged in to the application
	'Precondition	:
	'Date			: 26-Feb-2016
	'Author			: Pallavi
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that user is taken to the Ad Hoc 'Event Staus' screen when clicked on the"
			+ " URL available in the Ad Hoc event notification received when user is logged in to the application")
	public void testEdgeCase140376() throws Exception {

		gstrTCID = "140376";
		gstrTO = "Verify that user is taken to the Ad Hoc 'Event Staus' screen when clicked on the URL"
				+ " available in the Ad Hoc event notification received when user is logged in to the application";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		String strstatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		objEvent_data.strEventDescription = objUser_data.strFullName;
		objUser_data.strFullName = objUser_data.strFullName;

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
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		// Create event status type
		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streSSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// User creation
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
				.selectMaintainAdHocEventsOption()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strAdHocEventTemplate)
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strAdHocEventTemplate)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				.clickOnCreateAdHocEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnNextButton().verifySelectResourcesDisplayed();

		objResource1.clickResource(strResourceValue);

		objEventManagement1.clickOnNextButton()
				.verifySelectStatusTypesDisplayed();

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.streTSTStatusTypeName,
				objStatuTypes_data.streSSTStatusTypeName, };

		objEventManagement1
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypeNames);

		objResourceType1.clickStatusType(strstatusTypeValues);

		objEventManagement1.clickOnNextButton()
						   .clickOnYesButton();
						  
		String strEventStartDateAndTime = objEventManagement1
		.getEventStartTime(objEvent_data.strEventName);
		
		strEventStartDateAndTime = objDts.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH mm", "MM/dd/yy HH mm");
		
		System.out.println(objEvent_data.strEventName);
		
		objEventManagement1.verWebNotificationframe().clickAcknowledgeAllNotifications()
				.selectFrame().verifyEventName(objEvent_data.strEventName);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;

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

		objEventStatus1.verifyCreatedByDesc(objUser_data.strFullName,
				strEventStartDateAndTime, objEvent_data.strEventDescription);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	

	/*************************************************************************************
	'Description	:  	Verify that user who is NOT logged into the application, is taken
						to the 'Login' page when clicked on the URL available on the event 
						notifications received 
	'Precondition	:
	'Date			: 26-Feb-2016
	'Author			: Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that user who is NOT logged into the application, is taken"+
						"to the 'Login' page when clicked on the URL available on the event "+
						"notifications received ")
	public void testEdgeCase140381() throws Exception {

		gstrTCID = "140381";
		gstrTO = "Verify that user who is NOT logged into the application, is taken"+
				"to the 'Login' page when clicked on the URL available on the event "+
				"notifications received ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		String strstatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		objEvent_data.strEventDescription = objUser_data.strFullName;
		objUser_data.strFullName = objUser_data.strFullName;


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
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		// Create event status type
		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streSSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// User creation
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
				.selectMaintainAdHocEventsOption()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strAdHocEventTemplate)
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllResOption()
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strAdHocEventTemplate)
				.clickOnEmailNotification(objUser_data.strNewUserName, true)
				.clickOnPagerNotification(objUser_data.strNewUserName, true)
				.clickOnWebNotification(objUser_data.strNewUserName, true)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUserAndAnswerSecurityQuestion(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				.clickOnCreateAdHocEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnNextButton().verifySelectResourcesDisplayed();

		objResource1.clickResource(strResourceValue);

		objEventManagement1.clickOnNextButton()
				.verifySelectStatusTypesDisplayed();

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.streTSTStatusTypeName,
				objStatuTypes_data.streSSTStatusTypeName, };

		objEventManagement1
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypeNames);

		objResourceType1.clickStatusType(strstatusTypeValues);

		objEventManagement1.clickOnNextButton()
						   .clickOnYesButton();
						  
		String strEventStartDateAndTime = objEventManagement1
		.getEventStartTime(objEvent_data.strEventName);
		
		strEventStartDateAndTime = objDts.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH mm", "MM/dd/yy HH mm");
		
		System.out.println(objEvent_data.strEventName);
		
		objEventManagement1.verWebNotificationframe().clickAcknowledgeAllNotifications()
				.selectFrame().verifyEventName(objEvent_data.strEventName);

		Thread.sleep(5000);
		
		objLogin1.clickLogOut();

		Thread.sleep(20000);
		
		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(objUser_data.strFullName, objUser_data.strFullName, 
											objTest_data.strRegionName, objEvent_data.strEventDescription);
		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(objUser_data.strFullName, 
											objTest_data.strRegionName, objEvent_data.strEventDescription);
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = objEvent_data.strEventName;

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
		System.out.println(strUrlLink);
		Thread.sleep(10000);
		objMailVerificationFunctions.launchUrl(strUrlLink);
		
		objLogin1.enterUserName(objUser_data.strNewUserName);
		objLogin1.enterPassword(objUser_data.strNewPassword);
		objLogin1.clickLogin();
		objLogin1.clickOnCancel();
		
		objRegionDefault1.selectFrame();

		objEventStatus1.verifyCreatedByDesc(objUser_data.strFullName,
				strEventStartDateAndTime, objEvent_data.strEventDescription);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

}
