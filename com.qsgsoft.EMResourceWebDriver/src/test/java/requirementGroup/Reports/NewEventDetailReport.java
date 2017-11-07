package requirementGroup.Reports;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEventDetailReport extends TestNG_UI_EXTENSIONS {

	public NewEventDetailReport() throws Exception {
		super();
	}

	/*********************************************************************************
	'Description : Verify that the event detail report displays appropriate data for NEDOCS status type 
	'Precondition:
	'Date	 	 : 28-Sep-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that the event detail report displays appropriate data for NEDOCS status type")
	public void testHappyDay119793() throws Exception {

		gstrTCID = "119793";
		gstrTO = "Verify that the event detail report displays appropriate data for NEDOCS status type";

		Login_data objTest_data = new Login_data();

		UsersList objUsersList_page = new UsersList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Event_data objEvent_data = new Event_data();

		String strTimeText = objDate_Time_settings
				.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Report objReport1 = new Report(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strEventTemplateValue[] = new String[1];

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		boolean blnTest = false;

		Login objLogin1 = new Login(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);


		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectRunReportRight(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectReportEventDetailOption()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		String[] strResTypeVal = { strResourceTypeValue[0] };

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResTypeVal,
				strStatusTypeValues).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);


		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement();

		objEventManagement1.clickOnCreateNewEvent();

		String[] strResVal = { strResourceValue[0] };

		objEventManagement1
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResVal).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strDrill = objEventManagement1
				.getDrillVal(objEvent_data.strEventName);

		String strEventStartTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		String strEventVal = objEventManagement1
				.getEventValue(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.clickOnUpdateStatusKey(objResource_data.strResourceName);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForNDST).clickOnSaveButton();

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		objNavigationToSubMenus1.navigateToEventReports();
		String strDate = objDate_Time_settings.timeNow("MM/dd/yyyy");

		objReport1.clickOnEventDetailLink()
				.verEventDetailReportPgeIsDisplayed()
				.selectEventTemplate(strEventTemplateValue[0])
				.enterStartDate(strDate).enterEndDate(strDate).clickOnNextBtn()
				.verEventDetailReportPge2IsDisplayed()
				.verEnteredDatesAndPgeDetails(strDate)
				.enterReportStartDate(strDate).enterReportEndDate(strDate)
				.selectEvent(strEventVal).selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		objLogin1.clickLogOut();

		String strUpdate = objReport_data.strUpdate;

		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objTest_data.strRegionName,
					objEvent_data.strEventName,
					objEventSetUp_data.strEventTemplate,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strNDSTStatusTypeName,
					strEventStartTime,
					strEventEndTime,
					objReport_data.ExternalIP,
					strDrill,
					strUpdate,
					strUpdatedTime,
					strDownloadName,
					"",
					"",
					"",
					"",
					"",
					"",
					objView_data.strNEDOCValue};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		gstrResult = "PASS";
	}
	
	/******************************************************************************************************************
	'Description : Verify that user with appropriate right can generate 'Event Detail' report for a multi region event.
	'Date	 	 : 11-Sep-2014
	'Author		 : Sowmya
	'------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                  Modified By
	'Date					                                                              Name
	*******************************************************************************************************************/
	@Test(description = "Verify that user with appropriate right can generate 'Event Detail' report for a multi region event.")
	public void testHappyDay162722() throws Exception {

		gstrTCID = "162722";
		gstrTO = "Verify that user with appropriate right can generate 'Event Detail' report for a multi region event.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Roles_data objRoles_data = new Roles_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		Regions objRegions = new Regions(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		
		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strstatusTypeValues1[] = new String[6];
		String strResourceTypeValue1[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strRoleValue1[] = new String[1];
		String strRegionValue[] = new String[2];
		String strEventTemplateValue[] = new String[1];
		String strEventTemplateValue1[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strStatusesValues1[] = new String[1];
		
		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName = file + "\\" + gstrTCID + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + gstrTCID + "_2ndRep"
				+ strTimeText + fileType;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		// User1 creation
		String[] strRegionNames = { objTest_data.strRegionName1,
				objTest_data.strRegionName2 };
		
		Arrays.sort(strRegionNames);
		
		objSelectRegion.selectRegionAndNavigate(strRegionNames[0]);

		objRegionDefault.selectFrame();
		
		objNavigationToSubMenus.navigateToRegions();

		strRegionValue[0] = objRegions.getRegionValue(strRegionNames[0]);

		strRegionValue[1] = objRegions.getRegionValue(strRegionNames[1]);

		System.out.println(strRegionValue[0]);
		System.out.println(strRegionValue[1]);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatuTypes_data.strMultiStatusType,
						objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusDescription)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti)
		
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti1);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);
		
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

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// create multi region Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objESetUp_data.strEventTemplate);

		System.out.println("ET1 " + objESetUp_data.strEventTemplate);

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectReportEventDetailOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println("user1 " + objUser_data.strNewUserName);

		// Navigate to Region B
		objRegionDefault.clickRegionLink();

		objSelectRegion.selectRegionAndNavigate(strRegionNames[1]);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);

		objStatusTypeList
				.createStatusType(objStatuTypes_data.strMultiStatusType,
						objStatuTypes_data.strMSTStatusTypeName1,
						objStatuTypes_data.strStatusDescription)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti1)
		    
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti2,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti2);
		
		strStatusesValues1[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues1[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName1);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName1);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues1);

		strResourceTypeValue1[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);
		
		System.out.println(objResource_data.strResourceName1);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName1);

		strRoleValue1[0] = objRoles.getRoleValue(objRoles_data.strRoleName1);

		// create multi region Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate1,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue1,
				strstatusTypeValues1).deselectSelectAllWebOption();
		
		System.out.println(objESetUp_data.strEventTemplate1);

		strEventTemplateValue1[0] = objEventManagement
				.getEventTemplateValue(objESetUp_data.strEventTemplate1);

		System.out.println(objUser_data.strNewUserName);
		// User in Region B
		objUsersList
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.selectRoleCheckBox(strRoleValue1)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectRunReportsCheckBox(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectReportEventDetailOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.clickOnRegionName(strRegionValue[0])
				.clickOnRegionName(strRegionValue[1]).clickSaveButton();
		
		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(strRegionNames[0]);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				           .createNewMultiEventButton()
				           .verifyCreateMultiRegionEventPage();

		objEventManagement1
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.clickOnYesButton();
		
		System.out.println(objEvent_data.strMultiRegionEvent);

		String strEventVal = objEventManagement1
				.getEventValue(objEvent_data.strMultiRegionEvent);

		String strDrill = objEventManagement1
				.getDrillVal(objEvent_data.strMultiRegionEvent);

		String strEventStartTime = objEventManagement1
				.getEventStartTime(objEvent_data.strMultiRegionEvent);

		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strMultiRegionEvent);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strMultiRegionEvent);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValues[3],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValues[2],
						strStatusesValues[0])
				.enterNedocsUpdateValue(strstatusTypeValues[4],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue).clickOnSaveButton();

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(strRegionNames[0]);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToEventReports();

		String strDate = dts.timeNow("MM/dd/yyyy");

		objReport1.clickOnEventDetailLink()
				.verEventDetailReportPgeIsDisplayed()
				.enterStartDate(strDate)
				.enterEndDate(strDate)
				.selectEventTemplate(strEventTemplateValue[0])
				.clickOnNextBtn()
				.verEventDetailReportPge2IsDisplayed()
				.verEnteredDatesAndPgeDetails(strDate)
				.enterReportStartDate(strDate)
				.enterReportEndDate(strDate)
				.selectEvent(strEventVal)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		
		File file2 = new File(strDownloadName);
		boolean strPdf1 = file2.exists();

		//In second Region B
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(strRegionNames[1]);
		
		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strMultiRegionEvent);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName1);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues1[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues1[1],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValues1[3],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValues1[2],
						strStatusesValues1[0])
				.enterNedocsUpdateValue(strstatusTypeValues1[4],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues1[5],
						objView_data.strDateUpdateValue).clickOnSaveButton();

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(strRegionNames[1]);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToEventReports();

		objReport1.clickOnEventDetailLink()
				.verEventDetailReportPgeIsDisplayed()
				.enterStartDate(strDate)
				.enterEndDate(strDate)
				.selectEventTemplate(strEventTemplateValue1[0])
				.clickOnNextBtn()
				.verEventDetailReportPge2IsDisplayed()
				.verEnteredDatesAndPgeDetails(strDate)
				.enterReportStartDate(strDate)
				.enterReportEndDate(strDate)
				.selectEvent(strEventVal).
				selectResources(strResourceValue1[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		
		File file3 = new File(strDownloadName1);
		boolean strPdf2 = file3.exists();
		
		objLogin1.clickLogOut();

		String strUpdatedTime = strEventStartTime;
		String strUpdate = objReport_data.strUpdate;

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
							strRegionNames[0]+","+strRegionNames[1],
					objEvent_data.strMultiRegionEvent,
					objESetUp_data.strEventTemplate,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strNSTStatusTypeName + ","
							+ objStatuTypes_data.strTSTStatusTypeName + ", "
							+ objStatuTypes_data.strMSTStatusTypeName + ", "
							+ objStatuTypes_data.strSSTStatusTypeName + ", "
							+ objStatuTypes_data.strNDSTStatusTypeName,
					strEventStartTime, strEventEndTime,
					objReport_data.ExternalIP, strDrill, strUpdate,
					strUpdatedTime, strDownloadName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		if (strPdf2) {
			String[] strTestData1 = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
							strRegionNames[0]+","+strRegionNames[1],
					objEvent_data.strMultiRegionEvent,
					objESetUp_data.strEventTemplate1,
					objResource_data.strResourceName1,
					objResourceType_data.strResourceTypeName1,
					objStatuTypes_data.strNSTStatusTypeName1 + ","
							+ objStatuTypes_data.strTSTStatusTypeName1 + ", "
							+ objStatuTypes_data.strMSTStatusTypeName1 + ", "
							+ objStatuTypes_data.strSSTStatusTypeName1 + ", "
							+ objStatuTypes_data.strNDSTStatusTypeName1,
					strEventStartTime, strEventEndTime,
					objReport_data.ExternalIP, strDrill, strUpdate,
					strUpdatedTime, strDownloadName1 };

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "PDFDetails");
		}
		if(strPdf2 && strPdf1){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
}
