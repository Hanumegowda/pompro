package requirementGroup.CreatingAndManagingEvents;

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

public class NewEditEvent extends TestNG_UI_EXTENSIONS{

	public NewEditEvent() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*******************************************************************************************
	'Description 	: Edit event and add new resources and verify that the newly added resources are displayed in the 'Event Status' screen. 
	'Date 			: 19-Jun-2015 
	'Author 		: Renushree
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Edit event and add new resources and verify that the newly added resources are displayed in the 'Event Status' screen. ")
	public void testHappyDay68436() throws Exception {

		gstrTCID = "68436";
		gstrTO = "Edit event and add new resources and verify that the newly added resources are displayed in the 'Event Status' screen. ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		
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

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
		    .createNewStatus(objStatuTypes_data.strStatusNameInMulti,
		    		objStatuTypes_data.strStatusColor)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
					objStatuTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(
					objStatuTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

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

		objResource.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOptionOnly().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.verifyEventManagementPage()
				.clickOnCreateNewEvent()
				.verifySelectEventTemplatePage()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.verifyCreateEventPage()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objEventManagement1.navigateToEventManagement()
				.clickOnEditLink(objEvent_data.strEventName)
				.selectResource(strResourceValue[1]).clickOnSaveButton();
		
		String strEventName = "Update 1: " + objEvent_data.strEventName;
		
		objEventManagement1
		.clickOnEventNameInEventBanner(strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName)
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName1);

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objLogin1.clickLogOut();
		
		String[] strTestData = {
				Login_data.strBuildName,
				gstrTCID,
				objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
				objEventSetUp_data.strEventTemplate,
				objEvent_data.strEventName,
				"Verify mobile end condition with event name and both resources name displayed",
				objStatuTypes_data.strNSTStatusTypeName + ", "
						+ objStatuTypes_data.strMSTStatusTypeName + ", "
						+ objStatuTypes_data.strSSTStatusTypeName + ", "
						+ objStatuTypes_data.strTSTStatusTypeName + ", "
						+ objStatuTypes_data.strNDSTStatusTypeName + ", "
						+ objStatuTypes_data.strDateStatusTypeName,
				objResource_data.strResourceName + ","+objResource_data.strResourceName1,
				objResourceType_data.strResourceTypeName,
				objTest_data.strRegionName };

		objOffCommonFunc.writeResultData(strTestData,
				strPartialAutoResultsPath, "Events");
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description 	: Edit event and remove resources and verify that the removed resources are no longer displayed in the event detail screen.  
	'Date 			: 19-Jun-2015 
	'Author 		: Renushree
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Edit event and remove resources and verify that the removed resources are no longer displayed in the event detail screen. ")
	public void testHappyDay68437() throws Exception {

		gstrTCID = "68437";
		gstrTO = "Edit event and remove resources and verify that the removed resources are no longer displayed in the event detail screen. ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
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

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusColor)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
					objStatuTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(
					objStatuTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();
		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

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

		objResource.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOptionOnly().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.verifyEventManagementPage()
				.clickOnCreateNewEvent()
				.verifySelectEventTemplatePage()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.verifyCreateEventPage()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName)
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName1);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objEventManagement1.navigateToEventManagement()
				.clickOnEditLink(objEvent_data.strEventName)
				.deselectResource(strResourceValue[1]).clickOnSaveButton();
		
		objEventManagement1
		.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName)
				.verResourceTypeAndResourceNameIsNotDisplayed(objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName1);

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objLogin1.clickLogOut();
		
		String[] strTestData = {
				Login_data.strBuildName,
				gstrTCID,
				objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
				objEventSetUp_data.strEventTemplate,
				objEvent_data.strEventName,
				"Verify mobile end condition with event name and only RS1 name displayed",
				objStatuTypes_data.strNSTStatusTypeName + ", "
						+ objStatuTypes_data.strMSTStatusTypeName + ", "
						+ objStatuTypes_data.strSSTStatusTypeName + ", "
						+ objStatuTypes_data.strTSTStatusTypeName + ", "
						+ objStatuTypes_data.strNDSTStatusTypeName + ", "
						+ objStatuTypes_data.strDateStatusTypeName,
				objResource_data.strResourceName,
				objResourceType_data.strResourceTypeName,
				objTest_data.strRegionName };

		objOffCommonFunc.writeResultData(strTestData,
				strPartialAutoResultsPath, "Events");
		
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	'Description : Edit event and change the start time and verify that the event starts at the newly provided time.
	'Date        : 19-June-2014 
	'Author      : Anil
	'---------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                               Modified By
	'Date					                                                           Name
	****************************************************************************************************************/
	@Test(description = "Edit event and change the start time and verify that the event starts at the newly provided time.")
	public void testHappyDay118120() throws Exception {

		gstrTCID = "118120";
		gstrTO = "Edit event and change the start time and verify that the event starts at the newly provided time.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		boolean blnTest = false;

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

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
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		// create Event template
		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objESetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objESetUp_data.strTemplateDefinition).clickSaveButton()
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly()
				.clickOnEmailCheckBox(objUser_data.strNewUserName)
				.clickOnPagerCheckBox(objUser_data.strNewUserName)
				.clickOnWebCheckBox(objUser_data.strNewUserName)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUser_data.strNewUserName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement();

		objEventManagement1.clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		String strEventStartTime = objEventManagement1
				.getEventStartDateAndTime();

		objEvent_data.strEventStartTime = objDts.converDateFormat(
				strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		objEvent_data.strGetEventStartTime = objDts
				.AddTimeToExistingTimeHourAndMin(
						objEvent_data.strEventStartTime, 0, 5,
						"yyyy-MM-dd HH:mm");

		String strEventStartTimeTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm",
				"yyyy MMM dd HH mm");

		String strStartTime[] = strEventStartTimeTime.split(" ");

		objEventManagement1.selectEventStartDateAndTime(strStartTime);

		String strGetEventEndTime = objDts.AddTimeToExistingTimeHourAndMin(
				objEvent_data.strEventStartTime, 0, 20, "yyyy-MM-dd HH:mm");

		String strUpdatedEventEndTime = objDts.converDateFormat(
				strGetEventEndTime, "yyyy-MM-dd HH:mm", "yyyy MMM dd HH mm");

		String strEndTime[] = strUpdatedEventEndTime.split(" ");

		objEventManagement1.selectEventEndDateAndTime(strEndTime);

		objEventManagement1.clickOnSaveButton();

		strUpdatedEventEndTime = objDts.converDateFormat(strGetEventEndTime,
				"yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");

		System.out.println(objESetUp_data.strEventTemplate
				+ objEvent_data.strEventName);

		objEventManagement1.clickOnEditLink(objEvent_data.strEventName);

		strEventStartTime = objEventManagement1.getEventStartDateAndTime();

		objEvent_data.strEventStartTime = objDts.converDateFormat(
				strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		objEvent_data.strGetEventStartTime = objDts
				.AddTimeToExistingTimeHourAndMin(
						objEvent_data.strEventStartTime, 0, 2,
						"yyyy-MM-dd HH:mm");

		strEventStartTimeTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm",
				"yyyy MMM dd HH mm");

		String strStartTime1[] = strEventStartTimeTime.split(" ");

		objEventManagement1.selectEventStartDateAndTime(strStartTime1);

		objEventManagement1.clickOnSaveButton();

		Thread.sleep(420000);

		strEventStartTimeTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy MMM dd HH mm",
				"yyyy-MM-dd HH:mm");

		objNavigationToSubMenus1.clickOnPreferences();

		objEventManagement1.verWebNotificationframe()
				.clickAcknowledgeAllNotifications();
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
				.verifyEditEventLink(objEvent_data.strEventName)
				.verifyEndEventLink(objEvent_data.strEventName);

		objEventManagement1.verifyEventStartTime(objEvent_data.strEventName,
				strEventStartTimeTime).verifyEventEndTime(
				objEvent_data.strEventName, strUpdatedEventEndTime);

		objLogin1.clickLogOut();

		System.out.println(objEvent_data.strEventName);

		String strSubject = objEvent_data.strEventName;

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
					objEvent_data.strEventEndTime };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	'Description : Edit event and change the end time and verify that the event ends at the newly provided time.
	'Date        : 19-June-2014 
	'Author      : Anil
	'---------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                  Modified By
	'Date					                                                              Name
	****************************************************************************************************************/
	@Test(description = "Edit event and change the end time and verify that the event ends at the newly provided time.")
	public void testHappyDay118121() throws Exception {

		gstrTCID = "118121";
		gstrTO = "Edit event and change the end time and verify that the event ends at the newly provided time.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		boolean blnTest = false;

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

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
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		// create Event template
		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objESetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objESetUp_data.strTemplateDefinition).clickSaveButton()
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly()
				.clickOnEmailCheckBox(objUser_data.strNewUserName)
				.clickOnPagerCheckBox(objUser_data.strNewUserName)
				.clickOnWebCheckBox(objUser_data.strNewUserName)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objESetUp_data.strEventTemplate
				+ objEvent_data.strEventName);

		System.out.println(objUser_data.strNewUserName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		String strEventStartTime = objEventManagement1
				.getEventStartDateAndTime();

		objEvent_data.strEventStartTime = objDts.converDateFormat(
				strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		objEvent_data.strGetEventStartTime = objDts
				.AddTimeToExistingTimeHourAndMin(
						objEvent_data.strEventStartTime, 0, 5,
						"yyyy-MM-dd HH:mm");

		String strEventStartTimeTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm",
				"yyyy MMM dd HH mm");

		String strStartTime[] = strEventStartTimeTime.split(" ");

		objEventManagement1.selectEventStartDateAndTime(strStartTime);

		String strGetEventEndTime = objDts.AddTimeToExistingTimeHourAndMin(
				objEvent_data.strEventStartTime, 0, 20, "yyyy-MM-dd HH:mm");

		String strUpdatedEventEndTime = objDts.converDateFormat(
				strGetEventEndTime, "yyyy-MM-dd HH:mm", "yyyy MMM dd HH mm");

		String strEndTime[] = strUpdatedEventEndTime.split(" ");

		objEventManagement1.selectEventEndDateAndTime(strEndTime);

		objEventManagement1.clickOnSaveButton();

		objEventManagement1.clickOnEditLink(objEvent_data.strEventName);

		objEventManagement1.selectEventStartDateAndTime(strStartTime);

		strGetEventEndTime = objDts.AddTimeToExistingTimeHourAndMin(
				objEvent_data.strEventStartTime, 0, 40, "yyyy-MM-dd HH:mm");

		strUpdatedEventEndTime = objDts.converDateFormat(strGetEventEndTime,
				"yyyy-MM-dd HH:mm", "yyyy MMM dd HH mm");

		String strEndTime1[] = strUpdatedEventEndTime.split(" ");

		objEventManagement1.selectEventEndDateAndTime(strEndTime1);

		objEventManagement1.clickOnSaveButton();

		Thread.sleep(360000);

		strEventStartTimeTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy MMM dd HH mm",
				"yyyy-MM-dd HH:mm");

		strUpdatedEventEndTime = objDts.converDateFormat(strGetEventEndTime,
				"yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");

		objNavigationToSubMenus1.clickOnPreferences();

		objEventManagement1.verWebNotificationframe()
				.clickAcknowledgeAllNotifications();
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.verifyEventStartTime(objEvent_data.strEventName,
						strEventStartTimeTime)
				.verifyEventEndTime(objEvent_data.strEventName,
						strUpdatedEventEndTime);

		objLogin1.clickLogOut();

		System.out.println(objEvent_data.strEventName);

		String strSubject = objEvent_data.strEventName;

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
					objEvent_data.strEventEndTime };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}
		gstrResult = "PASS";
	}
	
	
	/***************************************************************************************************************
	'Description : Edit an event template and deselect 'Mandatory Address' and verify that City, State and County are non mandatory
	 when a new event is created under it and is mandatory when an already created event is opened for editing
	'Date        : 19-June-2014 
	'Author      : Anil
	'---------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                  Modified By
	'Date					                                                              Name
	****************************************************************************************************************/
	@Test(description = "Edit an event template and deselect 'Mandatory Address' and verify that City, State and County are non mandatory"
			+ " when a new event is created under it and is mandatory when an already created event is opened for editing")
	public void testHappyDay119911() throws Exception {

		gstrTCID = "119911";
		gstrTO = "Edit an event template and deselect 'Mandatory Address' and verify that City, State and County are non mandatory when a new event is created under it and is mandatory when an already created event is opened for editing";

		Login_data objTest_data = new Login_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
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
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		// create Event template
		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objESetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objESetUp_data.strTemplateDefinition)
				.selMandatoryAddInCreateTemplatePage().clickSaveButton()
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly().clickSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
						objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verAddressFieldsAreMandatory()
				.enterAddress(objESetUp_data.strCity, objESetUp_data.strState,
						objESetUp_data.strCountry, objESetUp_data.strZipCode)
				.clickOnSaveButton();

		objEventSetUp1.navigateToEventSetUp();
	
		objEventSetUp1.clickOnEditTempLink(objESetUp_data.strEventTemplate)
				.deselMandatoryAddInCreateTemplatePage().clickSaveButton();
		
		objEventManagement1.navigateToEventManagementNew();

		objEventManagement1.clickOnEditLink(objEvent_data.strEventName)
				.verAddressFieldsAreMandatory().clickOnSaveButton();

		objEventManagement1.verifyEventName(objEvent_data.strEventName);

		objEventManagement1.clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName1)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		objEventManagement1.clickOnSaveButton();
		objEventManagement1.verifyEventName(objEvent_data.strEventName1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	'Description : Edit an event template and select 'Mandatory Address' and verify that City, State and County are
	     required when a new event is created under it and is non mandatory when an already created event is edited.
	'Date        : 19-June-2014 
	'Author      : Anil
	'---------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                  Modified By
	'Date					                                                              Name
	****************************************************************************************************************/
	@Test(description = "Edit an event template and select 'Mandatory Address' and verify that City, State and County"
			+ "are required when a new event is created under it and is non mandatory when an already created event is edited.")
	public void testHappyDay119851() throws Exception {

		gstrTCID = "119851";
		gstrTO = "Edit an event template and select 'Mandatory Address' and verify that City, State and County are"
				+ " required when a new event is created under it and is non mandatory when an already created event is edited.";

		Login_data objTest_data = new Login_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
	
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objEventSetUp.navigateToEventSetUp();

		// create Event template
		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objESetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objESetUp_data.strTemplateDefinition).clickSaveButton()
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly().clickSaveButton();
		
		objUsersList.navigateToUsers()
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton();

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objESetUp_data.strEventTemplate)
				.selMandatoryAddInCreateTemplatePage().clickSaveButton();

		objEventManagement1.navigateToEventManagementNew();

		objEventManagement1.clickOnEditLink(objEvent_data.strEventName)
				.verAddressFieldsAreNotMandatory().clickOnSaveButton();

		objEventManagement1
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName1)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verAddressFieldsAreMandatory()
				.enterAddress(objESetUp_data.strCity, objESetUp_data.strState,
						objESetUp_data.strCountry, objESetUp_data.strZipCode)
				.clickOnSaveButton();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	'Description : Edit a future event and provide to start at a new time and verify that user's full name is displayed in the Event notification received after the event starts. 
	'Date        : 19-June-2014 
	'Author      : Anil
	'---------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                  Modified By
	'Date					                                                              Name
	****************************************************************************************************************/
	@Test(description = "Edit a future event and provide to start at a new time and verify that user's full name is displayed in the Event notification received after the event starts. ")
	public void testHappyDay117570() throws Exception {

		gstrTCID = "117570";
		gstrTO = "Edit a future event and provide to start at a new time and verify that user's full name is displayed in the Event notification received after the event starts. ";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

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
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		// create Event template
		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objESetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objESetUp_data.strTemplateDefinition).clickSaveButton()
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllWebOptionOnly()
				.clickOnEmailCheckBox(objUser_data.strNewUserName)
				.clickOnPagerCheckBox(objUser_data.strNewUserName)
				.clickOnWebCheckBox(objUser_data.strNewUserName)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objESetUp_data.strEventTemplate
				+ objEvent_data.strEventName);

		System.out.println(objUser_data.strNewUserName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		String strEventStartTime = objEventManagement1
				.getEventStartDateAndTime();

		objEvent_data.strEventStartTime = objDts.converDateFormat(
				strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		objEvent_data.strGetEventStartTime = objDts
				.AddTimeToExistingTimeHourAndMin(
						objEvent_data.strEventStartTime, 0, 15,
						"yyyy-MM-dd HH:mm");

		String strEventStartTimeTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm",
				"yyyy MMM dd HH mm");

		String strStartTime[] = strEventStartTimeTime.split(" ");

		objEventManagement1.selectEventStartDateAndTime(strStartTime);

		String strGetEventEndTime = objDts.AddTimeToExistingTimeHourAndMin(
				objEvent_data.strEventStartTime, 0, 25, "yyyy-MM-dd HH:mm");

		String strUpdatedEventEndTime = objDts.converDateFormat(
				strGetEventEndTime, "yyyy-MM-dd HH:mm", "yyyy MMM dd HH mm");

		String strEndTime[] = strUpdatedEventEndTime.split(" ");

		objEventManagement1.selectEventEndDateAndTime(strEndTime);

		objEventManagement1.clickOnSaveButton();

		objEventManagement1.verifyEventStatus(objEvent_data.strEventName, objEvent_data.strFuture);
		
		objEventManagement1.clickOnEditLink(objEvent_data.strEventName);

		objEvent_data.strEventStartTime = objDts.converDateFormat(
				strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		objEvent_data.strGetEventStartTime = objDts
				.AddTimeToExistingTimeHourAndMin(
						objEvent_data.strEventStartTime, 0, 5,
						"yyyy-MM-dd HH:mm");

		strEventStartTimeTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm",
				"yyyy MMM dd HH mm");

		String strStartTime1[] = strEventStartTimeTime.split(" ");

		objEventManagement1.selectEventStartDateAndTime(strStartTime1);

		objEventManagement1.clickOnSaveButton();		

		Thread.sleep(300000);

//		strEventStartTimeTime = objDts.converDateFormat(
//				objEvent_data.strGetEventStartTime, "yyyy MMM dd HH mm",
//				"yyyy-MM-dd HH:mm");
//
//		strUpdatedEventEndTime = objDts.converDateFormat(strGetEventEndTime,
//				"yyyy MMM dd HH mm", "yyyy-MM-dd HH:mm");

		objNavigationToSubMenus1.clickOnPreferences();

		objEventManagement1.verWebNotificationframe()
		.verWebNotificationAndAcknowledge(objEvent_data.strEventName, objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications();
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(objEvent_data.strEventName);
		objLogin1.clickLogOut();

		System.out.println(objEvent_data.strEventName);

		String strSubject = objEvent_data.strEventName;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(objUser_data.strFullName, objUser_data.strFullName, objTest_data.strRegionName, objEvent_data.strEventDescription);

		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(objUser_data.strFullName , objTest_data.strRegionName, objEvent_data.strEventDescription);

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

		gstrResult = "PASS";
	}
	
}
