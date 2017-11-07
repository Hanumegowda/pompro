package requirementGroup.SmokeTestSuite;

import static org.testng.Assert.*;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import lib.dataObject.BlankFormData;
import lib.dataObject.EMTrack_data;
import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.IncomingPationtNotificationData;
import lib.dataObject.InterfaceInSetUp_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusReason_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.ActivateForms;
import lib.page.AutoIT;
import lib.page.BlankForm;
import lib.page.DispatchForm;
import lib.page.EMTrackLogin;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.FormConfiguration;
import lib.page.IncomingPatientNotifications;
import lib.page.InterfacesInSetUp;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusReasonList;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;
import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.CSVFunctions;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class SmokeReports extends TestNG_UI_EXTENSIONS {
	
	public SmokeReports() throws Exception {
		super();
	}
	
	/*******************************************************************************
	'Description : Verify that a 'Status Snapshot' report can be generated.
	'Precondition:
	'Date	 	 : 09-Sep-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************/
	@Test(description = "Verify that a 'Status Snapshot' report can be generated.")
	public void testSmoke91306() throws Exception {

		gstrTCID = "91306";
		gstrTO = "Verify that a 'Status Snapshot' report can be generated.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Roles_data objRoles_data = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.reportFile;

		ViewsList objViewsList = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		
		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName = file + "\\" + "TC" +gstrTCID+ "_" + strTimeText
				+ fileType;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		// RoleBased statustypes
				.createStatusType(objStatuTypes_data.strNumberStatusType,
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
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

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

		// create resource with address
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

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// create view
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName};

		objNavigationToSubMenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strStatusTypeNames);
		
		System.out.println(objView_data.strViewName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSnapshotOption()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

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

		String strUpdatedTime = objEventManagement1.getApplicationTime();

		String strTime[] = strUpdatedTime.split(" ");

		String strTime1 = strTime[0];

		String strTime2 = strTime[1];

		String strTime3 = strTime[2];

		String strDate = dts.timeNow("dd MMM yyyy");

		String strUpdateTime = strTime1 + " " + strTime2 + " " + strDate + " "
				+ strTime3;

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], objView_data.strValueForUpdate);

		objUpdateStatus_Page1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[2],
						objStatuTypes_data.strStatusNameInMulti);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[3], objView_data.strUpdatedValForSST);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strNEDOCValue);

		String strEventStartTime = objEventManagement1.getApplicationTime();

		String strStartTime[] = strEventStartTime.split(":");

		String strStartTime1[] = strStartTime[0].split(" ");

		String strHour = strStartTime1[2];

		String strMinute = strStartTime[1];

		String strCurrentDate = objDts.getCurrentDate("MM/dd/yyyy HH:mm");

		String strStartTime2[] = strCurrentDate.split(" ");

		strCurrentDate = strStartTime2[0];

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSnapshot().enterReportDate(strCurrentDate)
				.selectHour(strHour).selectMinute(strMinute)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		
		File file1 = new File(strDownloadName);
		boolean strCsv1 = file1.exists();

		objLogin1.clickLogOut();

		if (strCsv1) {
			String[] strTestDataForExcel = {
					"91306",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strNSTStatusTypeName,
					objStatuTypes_data.strTSTStatusTypeName + ","
							+ objStatuTypes_data.strMSTStatusTypeName + ", "
							+ objStatuTypes_data.strSSTStatusTypeName + ", "
							+ objStatuTypes_data.strNDSTStatusTypeName +", "
							+ objView_data.strDateUpdateValue,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					"",
					objReport_data.ExternalIP,
					strDownloadName,
					strUpdateTime,
					"",
					objView_data.strValueForUpdate + ", "
							+ objView_data.strValueForUpdate + ", "
							+ objStatuTypes_data.strStatusNameInMulti + ", "
							+ objView_data.strUpdatedValForSST + ", "
							+ objView_data.strNEDOCValue };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		if(strCsv1){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	
	/****************************************************************************************************************
	'Description : Verify that a 'Event Snapshot' report can be generated.
	'Precondition:
	'Date	 	 : 10-Sep-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Verify that a 'Event Snapshot' report can be generated.")
	public void testSmoke118735() throws Exception {

		gstrTCID = "118735";
		gstrTO = "Verify that a 'Event Snapshot' report can be generated.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Roles_data objRoles_data = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);

		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strEveTemplateValue[] = new String[1];
		String strStatusesValues[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		

		String fileType = objReport_data.reportFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";

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
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

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
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);
				
		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);

		objEventManagement.clickOnSaveButton();

		strEveTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);


		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();
	
		// User creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectReportEventSnapshotOption()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();


		objLogin.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		// create Event
		objEventManagement.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		
		String strEventStartDateAndTime = objEventManagement.getEventStartTime(objEvent_data.strEventName);
		String strEventEndTime = objEventManagement.getEventEndTime(objEvent_data.strEventName);

		strEventStartDateAndTime = objDts.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH:mm",
				"dd MMM yyyy HH:mm");

		strEventEndTime = objDts.converDateFormat(strEventEndTime,
				"yyyy-MM-dd HH:mm", "dd MMM yyyy HH:mm");
		
		objLogin.clickLogOut();
		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName};

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterComments(strstatusTypeValues[0], objView_data.strComment)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValues[3],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValues[2],
						strStatusesValues[0])
				.enterNedocsUpdateValue(strstatusTypeValues[4],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue)		
				.clickOnSaveButton();

		String strEventStartTime = objEventManagement1.getApplicationTime();

		String strStartTime[] = strEventStartTime.split(":");

		String strStartTi[] = strEventStartTime.split(" ");

		String strStartTime1[] = strStartTime[0].split(" ");

		String strDate = strStartTime1[0];

		String strMonth = strStartTime1[1];

		String strHour = strStartTime1[2];

		String strMinute = strStartTime[1];

		String oneMinuteAdded1 = objDts
				.addTimetoExisting(strStartTi[2], 1, "H:mm");
		String oneMinuteAdded = objDts
				.addTimetoExisting(strStartTi[2], 1, "HH:mm");

		String strStartTim1[] = oneMinuteAdded.split(":");
		String strStartTim2[] = oneMinuteAdded1.split(":");
		String strHour1 = strStartTim1[0];
		String strHourFrExcel = strStartTim2[0];
		String strMinute1 = strStartTim1[1];

		String strCurrentDate1 = objDts.getCurrentDate("MM/dd/yyyy HH:mm");

		String strStartTime2[] = strCurrentDate1.split(" ");

		String strCurrentDate = strStartTime2[0];

		String strYear[] = strCurrentDate.split("/");

		String strYear1 = strYear[2];

		String strTime = strDate + " " + strMonth + " " + strYear1;
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], objView_data.strValueForUpdate);

		objUpdateStatus_Page1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[2],
						objStatuTypes_data.strStatusNameInMulti);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[3], objView_data.strUpdatedValForSST);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strNEDOCValue);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);

		objNavigationToSubMenus1.navigateToEventReports();

		Thread.sleep(60000);

		objReport1.clickOnEventSnapshot().verifyEventSnapshotReport1stPage()
				.verifySearchStartDate().verifySearchEndDate()
				.enterStartDate(strCurrentDate).enterEndDate(strCurrentDate);

		objReport1.selectEventTemplate(strEveTemplateValue[0]);

		objReport1.clickOnNextBtn()
				.selectEventRadioBtn(objEvent_data.strEventName)
				.verifySnapshotDateAndTimeShouldFallBetweenOption()
				.verifySnapshotDateOption().verifySnapshotTimeHourOption()
				.verifySnapshotTimeMinutesOption()
				.enterSnapshotDate(strCurrentDate)
				.selectSnapshotTimeHour(strHour1)
				.selectSnapshotTimeMinutes(strMinute1);

		String mainWindowHandle = driver1.getWindowHandle();

		objReport1.clickOnGenerateReportBtn();

		System.out.println(objEvent_data.strEventName);

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		String TitleName = driver1.getTitle();
		assertTrue(TitleName.contains("Event Snapshot Report"));

		String strHeaderName[] = { objResourceType_data.strResourceTypeName,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName, "Comment",
				"Last Update", "By User" };

		objReport1.verifyHeadersInHTMLEventSnapshotReport(strHeaderName);

		String[] strData = new String[] { objResource_data.strResourceName,
				strCurrentDate,
				objStatuTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForUpdate, objView_data.strComment,
				strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName };

		objReport1.verifDataInHTMLEventSnapshotReport(strData);
		
		objReport1.verifSummaryTable(objStatusTypes_data.strNSTStatusTypeName, objView_data.strValueForUpdate);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		
		objNavigationToSubMenus1.navigateToEventReports();

		objReport1.clickOnEventSnapshot()
				  .selectExcelReportRadioBtn()
				  .enterStartDate(strCurrentDate1)
				  .enterEndDate(strCurrentDate1)
				  .selectEventTemplate(strEveTemplateValue[0])
				  .clickOnNextBtn()
				  .selectEventRadioBtn(objEvent_data.strEventName)
				  .enterSnapshotDate(strCurrentDate1)
				  .selectSnapshotTimeHour(strHour1)
				  .selectSnapshotTimeMinutes(strMinute1)
				  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		int intCount = 0;
		int intCount1 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount1++;
					}

				} while (intCount1 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);

		String strValue = "";

		String[] strUpdatedStatusTypeNames = { "Resource Type", "Resource",
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objTest_data.strComment, objTest_data.strLastUpdate,
				objTest_data.strUpdatedBy };
		
		String strUpdateTime1 = strTime + " " + strStartTi[2];
		
		String strUpdateTime2 = strTime + " " + strHour + ":" + strStartTim1[1];

		String[] strUpdatedExcelValues = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForUpdate,
				"", strUpdateTime1,
				objUser_data.strFullName };

		/*summary part need to verify*/
		String[] strSummaryValue = { objTest_data.strSummary,
				"", "",
				"", objView_data.strValueForUpdate,
				"", "",
				"", "", ""};
		
		strValue = objOffCommonFunc.readInfoExcel(
				"Event Snapshot", 1, 1,
				strDownloadName1);
		assertEquals("Event Snapshot for " + objEvent_data.strEventName + " - "
				+ strCurrentDate + " " + strHourFrExcel + ":" + strMinute1
				+ " Central Standard Time. Event Start: "
				+ strEventStartDateAndTime + ". Event End: "+ strEventEndTime+". ", strValue);

		for (intCount = 1; intCount <= strUpdatedStatusTypeNames.length; intCount++) {
			if(intCount == 10) {
				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 2,
						intCount, strDownloadName1);
				assertEquals(strUpdatedStatusTypeNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 3,
						intCount, strDownloadName1);
				assertTrue(strUpdatedExcelValues[intCount - 1].equals(strValue) 
						|| strUpdateTime2.equals(strValue));
			} else {
				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 2,
						intCount, strDownloadName1);
				assertEquals(strUpdatedStatusTypeNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 3,
						intCount, strDownloadName1);
				assertEquals(strUpdatedExcelValues[intCount - 1], strValue);
			}
			
			/*summary part need to verify - refer bug id EMS-5027*/
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 4,
					intCount, strDownloadName1);
			assertEquals(strSummaryValue[intCount - 1], strValue);
		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/****************************************************************************************************************
	'Description : Verify that a 'Resource Detail' report can be generated.
	'Precondition:
	'Date	 	 : 11-Sep-2014
	'Author		 : Sinchana
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Verify that a 'Resource Detail' report can be generated.")
	public void testSmoke91753() throws Exception {

		gstrTCID = "91753";
		gstrTO = "Verify that a 'Resource Detail' report can be generated.";

		Login_data objTest_data = new Login_data();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		User_data objUser_data = new User_data();		
		Report_data objReport_data = new Report_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
				
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strTimeText = objDate_Time_settings
				.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.reportFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;
		
		String filePath = file + "\\";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased Status Types
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
		objResource.navigateToResourceListPage()
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(objResource_data.strResourceAbbrivation)
				.selectResourceTypename(objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.enterStreetAddress(objResource_data.strStreetAddress)
				.selectState(objResource_data.strState)
				.enterCity(objResource_data.strCity)
				.enterzipCode(objResource_data.strZipcode)
				.selectCounty(objResource_data.strCounty)
				.clickOnLookupAddressBtn()
				.verMap();
		
		String strLatitude = objResource.getLatitude();
		String strLogitude = objResource.getLongitude();		
	
		objResource.clickOnSaveButton()
			.clickOnViewResChkBox()
			.clickOnSaveButton();
				
		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMayUpdateRegionSetupInformationOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1.clickOnSelectAll();

		objUpdateStatus1
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strDateUpdateValue)
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST)
				.clickOnCalculate()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strStatusTypeValues[4],
						objView_data.strValueForSST)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
						objView_data.strValueForTST)
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[0]).clickOnSaveButton();
		
		objNavigationToSubMenus1.clickOnResourceReports();
		
		objReport1.clickOnResourceDetails();
		objReport1.verifyResourceDetailReportPage()
				.selectResources(strResourceValue[0]).clickOnNextBtn();

		for (int i = 0; i < strStatusTypeValues.length; i++) {
			objReport1.selectStatusCheckbox(strStatusTypeValues[i]);
		}

		objReport1.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		int intCount = 0;
		int intCount1 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount1++;
					}

				} while (intCount1 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);

		
		String strValue = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 1, 1, strDownloadName1);
		assertEquals("Resource Detail Report for: "
				+ objTest_data.strRegionName + "", strValue);

		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		String[] strHeaderNames = ArrayUtils.addAll(
				objReport_data.strResDetailRep, strStatusTypeNames);

		String[] strAnswers = {
				objResource_data.strResourceName,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStreetAddress + ", "
						+ objResource_data.strCity + ", "
						+ objResource_data.strCaliforniaCode,
				objResource_data.strCounty, strLatitude, strLogitude, "", "--",
				"--", "--", objResource_data.strResourceFirstName+" "+objResource_data.strResourceLastName, "--", "--", "--", "--", "--",
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCValue, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST };

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Resource Detail Report",
					2, intCount, strDownloadName1);
			assertEquals(strHeaderNames[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel("Resource Detail Report",
					3, intCount, strDownloadName1);
			if (intCount != 7) {
				assertTrue(strValue.contains(strAnswers[intCount - 1]));
			}
		}
		
		gstrResult = "PASS";
	}
	
	/*********************************************************************************
	'Description : Verify that a 'Event Detail' report can be generated.
	'Precondition:
	'Date	 	 : 11-Sep-2014
	'Author		 : Rensuhree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a 'Event Detail' report can be generated.")
	public void testSmoke91308() throws Exception {

		gstrTCID = "91308";
		gstrTO = " Verify that a 'Event Detail' report can be generated.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strStatusTypeValues[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strEventTemplateValue[] = new String[1];
		String strStatusesValues[] = new String[1];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName = file + "\\" + "TC91308" + "_" + strTimeText
				+ fileType;

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);
		
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

		// create resource with address
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

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);

		objEventManagement.clickOnSaveButton();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objEventSetUp_data.strEventTemplate);

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectReportEventDetailOption()
				.clickSaveButton();


		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();
		
		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();
		
		objEventManagement.navigateToEventManagement();

		objEventManagement.clickOnCreateNewEvent();

		objEventManagement
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strDrill = objEventManagement
				.getDrillVal(objEvent_data.strEventName);

		String strEventStartTime = objEventManagement
				.getEventStartTime(objEvent_data.strEventName);

		String strEventEndTime = objEventManagement
				.getEventEndTime(objEvent_data.strEventName);
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String strEventVal = objEventManagement1
				.getEventValue(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strStatusTypeValues[3],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
								objView_data.strDateUpdateValue)
				.enterNedocsUpdateValue(strStatusTypeValues[4], objView_data.strValueForNDST)
				.clickOnSaveButton();

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[1],
				objStatusTypes_data.strStatusNameInMulti);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[2], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[3], objView_data.strUpdatedValForSST);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[5], objView_data.strDateUpdateValue);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[4], objView_data.strNEDOCValue);

		objNavigationToSubMenus1.navigateToEventReports();

		String strDate = dts.timeNow("MM/dd/yyyy");

		objReport1.clickOnEventDetailLink()
				.verEventDetailReportPgeIsDisplayed().enterStartDate(strDate)
				.enterEndDate(strDate)
				.selectEventTemplate(strEventTemplateValue[0]).clickOnNextBtn()
				.verEventDetailReportPge2IsDisplayed()
				.verEnteredDatesAndPgeDetails(strDate)
				.enterReportStartDate(strDate).enterReportEndDate(strDate)
				.selectEvent(strEventVal).selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		File file2 = new File(strDownloadName);
		boolean strPdf1 = file2.exists();
		objLogin1.clickLogOut();

		String strUpdatedTime = strEventStartTime;
		String strUpdate = objReport_data.strUpdate;

		if (strPdf1) {
			String[] strTestData = {
					"91308",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + ","
							+ objLogin_data.strRegionName2,
					objEvent_data.strEventName,
					objEventSetUp_data.strEventTemplate,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strNumberStatusType + ","
							+ objStatusTypes_data.strTSTStatusTypeName + ", "
							+ objStatusTypes_data.strMSTStatusTypeName + ", "
							+ objStatusTypes_data.strSSTStatusTypeName + ", "
							+ objStatuTypes_data.strNDSTStatusTypeName + ", "
							+ objStatuTypes_data.strDateStatusTypeName,
					strEventStartTime, strEventEndTime,
					objReport_data.ExternalIP, strDrill, strUpdate,
					strUpdatedTime, strDownloadName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		if(strPdf1=true){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	
	/*********************************************************************************
	'Description : Verify that user with appropriate right can generate 'Event Detail' 
	               report for a multi region event.
	'Precondition:
	'Date	 	 : 11-Sep-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that user with appropriate right can generate 'Event Detail' "
			+ "report for a multi region event.")
	public void testSmoke137783() throws Exception {

		gstrTCID = "137783";
		gstrTO = "Verify that user with appropriate right can generate 'Event Detail' "
				+ "report for a multi region event.";

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
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);
		Regions objRegions = new Regions(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

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

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

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

		String strDownloadName1 = file + "\\" + gstrTCID + "_2ndRep" + strTimeText
				+ fileType;

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
						objStatuTypes_data.strStatusNameInMulti);

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
				strstatusTypeValues);

		objEventManagement.clickOnSaveButton();

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
				.selectRegion(strRegionValue[1]).clickSaveButton();

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
						objStatuTypes_data.strStatusNameInMulti1);

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
				strstatusTypeValues1);
		
		System.out.println(objESetUp_data.strEventTemplate1);

		objEventManagement.clickOnSaveButton();

		strEventTemplateValue1[0] = objEventManagement
				.getEventTemplateValue(objESetUp_data.strEventTemplate1);

		System.out.println("ET2 " + objESetUp_data.strEventTemplate1);
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
//				.verifyEditMultiRegionEventRights()
//				.verifyRegionName(strRegionValue[0])
//				.verifyRegionName(strRegionValue[1]).verifySelectAllButton()
				.clickOnRegionName(strRegionValue[0])
				.clickOnRegionName(strRegionValue[1]).clickSaveButton();
		
	

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

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
				.verifyRegionAndETName(strRegionNames[0],
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(strRegionNames[1],
						objESetUp_data.strEventTemplate1).verifyYesButton()
				.clickOnYesButton().verWebNotificationframe()
				.clickAcknowledgeAllNotifications().selectFrame();
		
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

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

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

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], objView_data.strValueForUpdate);

		objUpdateStatus_Page1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[2],
						objStatuTypes_data.strStatusNameInMulti);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[3], objView_data.strUpdatedValForSST);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strNEDOCValue);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);

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

		// nav to reg B
		objRegionDefault1.clickRegionLink();

		objSelectRegion1.selectRegionAndNavigate(strRegionNames[1]);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName1,
				objResource_data.strResourceName1);

		String[] strStatusTypeNames1 = {
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strNDSTStatusTypeName1 };

		for (int i = 0; i < strStatusTypeNames1.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName1,
					strStatusTypeNames1[i]);
		}

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

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue1[0],
				strstatusTypeValues1[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue1[0],
				strstatusTypeValues1[1], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue1[0],
				strstatusTypeValues1[2],
				objStatuTypes_data.strStatusNameInMulti1);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue1[0],
				strstatusTypeValues1[3], objView_data.strUpdatedValForSST);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue1[0],
				strstatusTypeValues1[4], objView_data.strNEDOCValue);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue1[0],
				strstatusTypeValues1[5], objView_data.strDateUpdateValue);

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
					"137783",
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
					"137783",
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
	
	/****************************************************************************************************************
	'Description : Verify that user with appropriate right can generate 'Event Snapshot' report for a multi region event.
	'Precondition:
	'Date	 	 : 12-Sep-2014
	'Author		 : Sinchana
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Verify that user with appropriate right can generate 'Event Snapshot' report for a multi region event.")
	public void testSmoke137784() throws Exception {

		gstrTCID = "137784";
		gstrTO = "Verify that user with appropriate right can generate 'Event Snapshot' report for a multi region event.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Report_data objReport_data = new Report_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);

		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strstatusTypeValues[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strEveTemplateValue[] = new String[1];
		String strRegionValue[] = new String[2];
		String strStatusesValues[] = new String[2];

		String strstatusTypeValuesInReg2[] = new String[6];
		String strResourceValueInReg2[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strEveTemplateValueInReg2[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);

		String fileType = objReport_data.reportFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogin_data.strRegionName);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogin_data.strRegionName1);

		System.out.println(strRegionValue[1]);
		System.out.println(objStatuTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// RoleBased Status Types in Region1
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

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
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		// Resource type creation in Region1
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource in Region1
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// create Event template in Region1
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues).clickSaveButton();

		strEveTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectReportEventSnapshotOption()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// Navigate to Region2
		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// RoleBased Status Types in Region2
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValuesInReg2[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValuesInReg2[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValuesInReg2[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName1);

		// Resource type creation in Region2
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName1,
				strstatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// create resource in Region2
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// create Event template in Region2
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate1,
				objEventSetUp_data.strTemplateDefinition,
				strResourceTypeValueInReg2, strstatusTypeValuesInReg2)
				.clickSaveButton();

		strEveTemplateValueInReg2[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate1);

		System.out.println(objEventSetUp_data.strEventTemplate1);

		objUsersList
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectReportEventSnapshotOption()
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectRunReportsCheckBox(objResource_data.strResourceName1)
				.clickSaveButton().editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1]).verifySelectAllButton()
				.clickOnRegionName(strRegionValue[0])
				.clickOnRegionName(strRegionValue[1]).clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		Thread.sleep(5000);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		System.out.println(objEvent_data.strEventName);

		// create Event
		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objEventSetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objEventSetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		String strEventStartDateAndTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);
		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		strEventStartDateAndTime = dts.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH:mm",
				"dd MMM yyyy HH:mm");

		strEventEndTime = dts.converDateFormat(strEventEndTime,
				"yyyy-MM-dd HH:mm", "dd MMM yyyy HH:mm");

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValues[3],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[0])
				.enterNedocsUpdateValue(strstatusTypeValues[4],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue).clickOnSaveButton();

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1],
				objStatusTypes_data.strStatusNameInMulti);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[2], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[3], objView_data.strUpdatedValForSST);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strNEDOCValue);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);

		objSelectRegion1.selectRegionAndNavigate(objLogin_data.strRegionName1);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName1,
				objResource_data.strResourceName1);

		String[] strStatusTypeNamesInReg2 = {
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strNDSTStatusTypeName1 };

		for (int i = 0; i < strStatusTypeNamesInReg2.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName1,
					strStatusTypeNamesInReg2[i]);
		}

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName1);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValuesInReg2[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strstatusTypeValuesInReg2[2],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValuesInReg2[3],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValuesInReg2[1],
						strStatusesValues[1])
				.enterNedocsUpdateValue(strstatusTypeValuesInReg2[4],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValuesInReg2[5],
						objView_data.strDateUpdateValue).clickOnSaveButton();

		String strEventStartTime = objEventManagement1.getApplicationTime();

		String strStartTime[] = strEventStartTime.split(":");

		String strStartTi[] = strEventStartTime.split(" ");

		String strStartTime1[] = strStartTime[0].split(" ");

		String strDate = strStartTime1[0];

		String strMonth = strStartTime1[1];

		String strHour = strStartTime1[2];

		String strMinute = strStartTime[1];

		String oneMinuteAdded1 = dts
				.addTimetoExisting(strStartTi[2], 1, "H:mm");
		String oneMinuteAdded = dts
				.addTimetoExisting(strStartTi[2], 1, "HH:mm");
		String oneMinuteLessed = dts.addTimetoExisting(strStartTi[2], -1,
				"HH:mm");

		String strStartTim1[] = oneMinuteAdded.split(":");
		String strStartTim2[] = oneMinuteAdded1.split(":");
		String strUpdatedTime[] = oneMinuteLessed.split(":");
		String strHour1 = strStartTim1[0];
		String strHourFrExcel = strStartTim2[0];
		String strMinute1 = strStartTim1[1];

		String strCurrentDate1 = dts.getCurrentDate("MM/dd/yyyy HH:mm");

		String strStartTime2[] = strCurrentDate1.split(" ");

		String strCurrentDate = strStartTime2[0];

		String strYear[] = strCurrentDate.split("/");

		String strYear1 = strYear[2];

		String strTime = strDate + " " + strMonth + " " + strYear1;

		objUpdateStatus_Page1.verifyUpdatedStatusValues(
				strResourceValueInReg2[0], strstatusTypeValuesInReg2[0],
				objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(
				strResourceValueInReg2[0], strstatusTypeValuesInReg2[1],
				objStatusTypes_data.strStatusNameInMulti1);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(
				strResourceValueInReg2[0], strstatusTypeValuesInReg2[2],
				objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(
				strResourceValueInReg2[0], strstatusTypeValuesInReg2[3],
				objView_data.strUpdatedValForSST);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(
				strResourceValueInReg2[0], strstatusTypeValuesInReg2[4],
				objView_data.strNEDOCValue);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(
				strResourceValueInReg2[0], strstatusTypeValuesInReg2[5],
				objView_data.strDateUpdateValue);

		objNavigationToSubMenus1.navigateToEventReports();

		objReport1.clickOnEventSnapshot().verifyEventSnapshotReport1stPage()
				.verifySearchStartDate().verifySearchEndDate()
				.enterStartDate(strCurrentDate);
		// .verifyWebBrowserAndExcelReport();

		objReport1.selectEventTemplate(strEveTemplateValueInReg2[0])
		.enterEndDate(strCurrentDate);

		Thread.sleep(60000);

		objReport1.clickOnNextBtn()
				.selectEventRadioBtn(objEvent_data.strEventName)
				.verifySnapshotDateAndTimeShouldFallBetweenOption()
				.verifySnapshotDateOption().verifySnapshotTimeHourOption()
				.verifySnapshotTimeMinutesOption()
				.enterSnapshotDate(strCurrentDate)
				.selectSnapshotTimeHour(strHour1)
				.selectSnapshotTimeMinutes(strMinute1);

		String mainWindowHandle = driver1.getWindowHandle();

		Thread.sleep(3000);

		objReport1.clickOnGenerateReportBtn();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		String TitleName = driver1.getTitle();
		assertTrue(TitleName.contains("Event Snapshot Report"));

		String strHeaderName[] = { objResourceType_data.strResourceTypeName1,
				objStatuTypes_data.strDateStatusTypeName1,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strTSTStatusTypeName1, "Comment",
				"Last Update", "By User" };

		objReport1.verifyHeadersInHTMLEventSnapshotReport(strHeaderName);

		String[] strData = new String[] { objResource_data.strResourceName1,
				strCurrentDate, objStatuTypes_data.strStatusNameInMulti1,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForUpdate, " ",
				strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName };

		objReport1.verifDataInHTMLEventSnapshotReport(strData);
		
		objReport1.verifSummaryTable(objStatusTypes_data.strNSTStatusTypeName1, objView_data.strValueForUpdate);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToEventReports();

		objReport1.clickOnEventSnapshot().selectExcelReportRadioBtn().enterStartDate(strCurrentDate)
				.enterEndDate(strCurrentDate);

		objReport1.selectEventTemplate(strEveTemplateValue[0]);

		objReport1.clickOnNextBtn()
				.selectEventRadioBtn(objEvent_data.strEventName)
				.enterSnapshotDate(strCurrentDate)
				.selectSnapshotTimeHour(strHour1)
				.selectSnapshotTimeMinutes(strMinute1)
				.clickOnGenerateReportBtn();

		Thread.sleep(10000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		Thread.sleep(10000);
		
		/*
		 * File file3 = new File(strDownloadNameExcelFile); boolean strCsv1 =
		 * file3.exists();
		 */
		int intCount = 0;
		int intCount1 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount1++;
					}

				} while (intCount1 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);
		
		String strHeaderName1[] = { "Resource Type", "Resource",
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName, "Comment",
				"Last Update", "By User" };

		String strUpdateTime1 = strTime + " " + strStartTi[2];
		
		String strUpdateTime2 = strTime + " " + strHour + ":" + strStartTim1[1];
		
		String strUpdateTime3 = strTime + " " + strHour + ":" + strUpdatedTime[1];
		
		String[] strData1 = new String[] {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName, strCurrentDate,
				objStatuTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForUpdate, "",
				strUpdateTime1,
				objUser_data.strFullName };
		
		/*summary part need to verify*/
		String[] strSummaryValue = { objLogin_data.strSummary,
				"", "",
				"", objView_data.strValueForUpdate,
				"", "",
				"", "", ""};

		String strValue = "";

		strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 1, 1,
				strDownloadName1);
		assertEquals("Event Snapshot for " + objEvent_data.strEventName + " - "
				+ strCurrentDate + " " + strHourFrExcel + ":" + strMinute1
				+ " Central Standard Time. Event Start: "
				+ strEventStartDateAndTime + ". Event End: " + strEventEndTime
				+ ". ", strValue);

		for (intCount = 1; intCount <= strHeaderName1.length; intCount++) {
			if(intCount == 10) {
				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 2,
						intCount, strDownloadName1);
				assertEquals(strHeaderName1[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 3,
						intCount, strDownloadName1);
				assertTrue(strData1[intCount - 1].equals(strValue) 
						|| strUpdateTime2.equals(strValue) || strUpdateTime3.equals(strValue));
			} else {
				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 2,
						intCount, strDownloadName1);
				assertEquals(strHeaderName1[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 3,
						intCount, strDownloadName1);
				assertEquals(strData1[intCount - 1], strValue);
			}
			
			/*summary part need to verify - refer bug id EMS-5027*/
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 4,
					intCount, strDownloadName1);
			assertEquals(strSummaryValue[intCount - 1], strValue);
		}

		gstrResult = "PASS";
	}
	
	/*********************************************************************************
	'Description : Verify that a 'Status Reason Detail' report can be generated.
	'Precondition:
	'Date	 	 : 15-Sep-2014
	'Author		 : Rensuhree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a 'Status Reason Detail' report can be generated.")
	public void testSmoke91289() throws Exception {

		gstrTCID = "91289";
		gstrTO = "Verify that a 'Status Reason Detail' report can be generated.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		StatusReason_data objStatusReason_data = new StatusReason_data();
		Map objMap = new Map(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType2 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName = file + "\\" + "TC91289" + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + "TC91289Excel" + "_"
				+ strTimeText + fileType2;

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		String strReasonVal = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusTypeList
				.navigateToStatusTypeListNew()
				.createPrivateStatusType(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList
				.clickOnReturnToStatusTypeList()
				.clickOnEditOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName)
				.selectStatusReason(strReasonVal)
				.clickOnSaveButton()
				.clickOnStatusesOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName)
				.editStatusForMultiStatusType(
						objStatusTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal)
				.clickOnSaveButton()
				.editStatusForMultiStatusType(
						objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusReasonForStatus(strReasonVal).clickOnSaveButton()
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonDetailOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		System.out.println(objUserdata.strNewUserName);
		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal, strStatusTypeValues[0],
						strStatusesValues[0]).clickOnSaveButton();
		
		String strUpdatedTime = dts.timeNow("HH:mm:ss");
		
		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName);

		String strUpdatedDateTime = objMap.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"MM/dd/yyyy HH:mm");
		
		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnStatusReports();

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts
				.converDateFormat(strCurrentDate, "MM/dd/yyyy",
						"dd-MMM-yyyy");

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal, strStatusesValues[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		
		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();
		
		String strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();

		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		double fltDurationDiff = (double) intDurationDiff / 3600;

		double dRounded = dts.roundTwoDecimals(fltDurationDiff);

		String strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("PDF generation duration " + strDurationDiffPDF);

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectExcelReportRadioBtn().clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal, strStatusesValues[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		
		File file2 = new File(strDownloadName1);
		boolean strCsv1 = file2.exists();

		String strExcelReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel1 = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel1 = strFetchAppDateTimeForExcel1.split(" ");

		String strRequiredAppEndTimeForExcel1 = dts.converDateFormat(
				strAppTimeForExcel1[0] + strAppTimeForExcel1[1] + strCurYear
						+ " " + strAppTimeForExcel1[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		int intExcelDurationDiff1 = dts.getTimeDiff1(
				strExcelReportGeneratedtime1, strUpdatedTime);

		double fltExcelDurationDiff1 = (double) intExcelDurationDiff1 / 3600;

		double dExcelRounded1 = dts.roundTwoDecimals(fltExcelDurationDiff1);

		String strExcelDurationDiffPDF1 = Double.toString(dExcelRounded1);

		System.out.println("CSV generation duration "
				+ strExcelDurationDiffPDF1);

		String strVerUpdatedTime = strRequiredUpdatedTime;

		if (strPdf1) {
			String[] strTestData = {
					"91289",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword ,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName,
					"",
					"",
					objReport_data.ExternalIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName,
					strRequiredAppEndTime,
					objStatusReason_data.strReasonName,
					objStatusTypes_data.strStatusNameInMulti + ","
							+ objStatusTypes_data.strStatusNameInMulti1, strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF, objStatusTypes_data.strStatusNameInMulti};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		if (strCsv1) {
			String[] strTestDataForExcel = {
					"91289",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
							objLogin_data.strRegionName,
					objStatusTypes_data.strMSTStatusTypeName,
					objStatusTypes_data.strStatusNameInMulti + ","
							+ objStatusTypes_data.strStatusNameInMulti1,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "",
					objStatusReason_data.strReasonName, strExcelDurationDiffPDF1,
					objReport_data.ExternalIP, strDownloadName1,
					strRequiredUpdatedTimeForExcel, strRequiredAppEndTimeForExcel1, objStatusTypes_data.strStatusNameInMulti};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		objLogin1.clickLogOut();

		if(strPdf1 &&  strCsv1){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	
	/****************************************************************************************************************
	'Description : Verify that 'Statewide Resource Details' report can be generated by RegAdmin in 'Statewide Florida' 
	 for all the resources for the selected criteria while generating report.
	'Precondition:
	'Date	 	 : 15-Sep-2014
	'Author		 : Sinchana
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Verify that 'Statewide Resource Details' report can be generated by RegAdmin in 'Statewide Florida'"
			+ " for all the resources for the selected criteria while generating report.")
	public void testSmoke109178() throws Exception {

		gstrTCID = "109178";
		gstrTO = "Verify that user with appropriate right can generate 'Event Snapshot' report for a multi region event.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Report_data objReport_data = new Report_data();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.reportFile;
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		AutoIT objAutoIT = new AutoIT(this.driver1);
		Report objReport1 = new Report(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strStdStatusValue[] = new String[1];
		String strStdResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRegionValue[] = new String[2];

		String strstatusTypeValuesInReg2[] = new String[1];
		String strStdStatusValueInReg2[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strStdResourceValueInReg2[] = new String[1];

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionStatewideFlorida);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogin_data.strRegionStatewideFlorida);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogin_data.strRegionName4);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// RoleBased Status Types in Region1
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strNumberStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strNSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStandardStatusTypename(
						objStatuTypes_data.strStandardStatusTypename);

		strStdStatusValue[0] = objStatusTypeList
				.getStandardStatusValue(objStatuTypes_data.strStandardStatusTypename);

		System.out.println(strStdStatusValue[0]);

		objStatusTypeList.clickOnSaveButton();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation in Region1
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create Resource in Region1
		objResource
				.navigateToResourceListPage()
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
				.enterStreetAddress(objResource_data.strStreetAddress)
				.selectState(objResource_data.strState)
				.enterCity(objResource_data.strCity)
				.enterzipCode(objResource_data.strZipcode)
				.selectCounty(objResource_data.strCounty)
				.clickOnLookupAddressBtn().verMap();

		String strLatitude = objResource.getLatitude();
		String strLogitude = objResource.getLongitude();

		strStdResourceValue[0] = objResource
				.getStandardResourceValue(objResource_data.strStandardResourceTypename);

		objResource.clickOnSaveButton().clickOnViewResChkBox()
				.clickOnSaveButton();

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName4
				.trim());

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// RoleBased Status Types in Region2
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strNumberStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strNSTStatusTypeName1)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStandardStatusTypename(
						objStatuTypes_data.strStandardStatusTypename);

		strStdStatusValueInReg2[0] = objStatusTypeList
				.getStandardStatusValue(objStatuTypes_data.strStandardStatusTypename);

		objStatusTypeList.clickOnSaveButton();

		strstatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		// Resource type creation in Region1
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName1,
				strstatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// create Resource in Region2
		objResource
				.navigateToResourceListPage()
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.enterStreetAddress(objResource_data.strStreetAddress)
				.selectState(objResource_data.strState)
				.enterCity(objResource_data.strCity)
				.enterzipCode(objResource_data.strZipcode)
				.selectCounty(objResource_data.strCounty)
				.clickOnLookupAddressBtn().verMap();

		String strLatitudeInReg2 = objResource.getLatitude();
		String strLogitudeInReg2 = objResource.getLongitude();

		strStdResourceValueInReg2[0] = objResource
				.getStandardResourceValue(objResource_data.strStandardResourceTypename);

		objResource.clickOnSaveButton().clickOnViewResChkBox()
				.clickOnSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objLogin_data.strRegionStatewideFlorida);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnResourceReports();

		objReport1.verifyResourceReportMenuPage()
				.clickOnStatewideResourceDetails()
				.verifyStatewideResourceDetailReportPage()
				.selectStandardResources(strStdResourceValue)
				.clickOnNextButtonInResourceDetailPage()
				.selectStandardStatus(strStdStatusValue)
				.clickOnGenerateReportBtn();

		Thread.sleep(20000);
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		int intCount = 0;
		int intCount1 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount1++;
					}

				} while (intCount1 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);
		
		String strValue = objOffCommonFunc.readInfoExcel(
				"Statewide Resource Detail Repor", 1, 1, strDownloadName1);
		assertEquals(objReport_data.strStatewideResourceDetailReport, strValue);

		int intRowCount = objOffCommonFunc.getRowsCountOfExceSheet(
				strDownloadName1, "Statewide Resource Detail Repor");

		String[] strHeaderNames = { "Region", "Resource Name", "Type",
				"Address", "County", "Latitude", "Longitude", "EMResource ID",
				"AHA ID", "External ID", "Website", "Contact", "Phone 1",
				"Phone 2", "Fax", "Email", "Notes", "Average Wait Time" };

		String[] strAnswers = {
				objLogin_data.strRegionStatewideFlorida,
				objResource_data.strResourceName,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStreetAddress + ", "
						+ objResource_data.strCity + ", "
						+ objResource_data.strCaliforniaCode + " "
						+ objResource_data.strZipcode + "",
				objResource_data.strCounty, strLogitude, strLatitude, "", "",
				"", "", "FN LN", "", "", "", "", "", "0" };

		String[] strAnswers2 = {
				objLogin_data.strRegionName4,
				objResource_data.strResourceName1,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStreetAddress + ", "
						+ objResource_data.strCity + ", "
						+ objResource_data.strCaliforniaCode + " "
						+ objResource_data.strZipcode + "",
				objResource_data.strCounty, strLogitudeInReg2,
				strLatitudeInReg2, "", "", "", "", "FN LN", "", "", "", "", "",
				"0" };

		for (int i = 1; i <= strHeaderNames.length; i++) {
			strValue = objOffCommonFunc.readInfoExcel(
					"Statewide Resource Detail Repor", 2, i, strDownloadName1);
			assertEquals(strHeaderNames[i - 1], strValue);
		}
		System.out.println(objResource_data.strResourceName);
		System.out.println(objResource_data.strResourceName1);

		String strRes1 = objResource_data.strResourceName;
		String strRes2 = objResource_data.strResourceName1;
		System.out.println(strAnswers);
		System.out.println(strAnswers2);

		int intcnt = 0;
		for (int i = intRowCount; i <= intRowCount; i--) {
			if (i != 0) {
				strValue = objOffCommonFunc.readInfoExcel(
						"Statewide Resource Detail Repor", i, 2,
						strDownloadName1);
				if (strValue.contains(strRes1) || strValue.contains(strRes2)) {
					for (int j = 1; j <= strAnswers.length; j++) {
						strValue = objOffCommonFunc.readInfoExcel(
								"Statewide Resource Detail Repor", i, j,
								strDownloadName1);
						assertTrue(strValue.contains(strAnswers[j - 1])
								|| strValue.contains(strAnswers2[j - 1]));
					}
					intcnt++;
				}
			}
			if (intcnt == 2)
				break;
		}
	
		gstrResult = "PASS";
	}	
	
	/*********************************************************************************
	'Description : Verify that a 'Status Reason Summary' report can be generated.
	'Precondition:
	'Date	 	 : 15-Sep-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a 'Status Reason Summary' report can be generated.")
	public void testSmoke91304() throws Exception {

		gstrTCID = "91304";
		gstrTO = "Verify that a 'Status Reason Summary' report can be generated.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);

		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strReasonVal[] = new String[2];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Map objMap1 = new Map(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);

		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);

		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + "TCID91304" + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + "TC91304_1" + "_" + strTimeText
				+ fileType;

		String strDownloadName2 = file + "\\" + "TC91304_2" + "_" + strTimeText
				+ fileType1;

		String strDownloadName3 = file + "\\" + "TC91304_3" + "_" + strTimeText
				+ fileType1;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName1,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[1] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName1);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes with selecting Reason
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal[0])
				.clickOnSaveButton()

				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal[0])
				.clickOnSaveButton()

				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// create private status type
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strpMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal[1])
				.selectPrivateStatusTypeRadioBtn()
				.clickOnSaveButton()

				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti1)
				.selectStatusReasonForStatus(strReasonVal[1])
				.clickOnSaveButton()

				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti1);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpMSTStatusTypeName);

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

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonSummaryOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("1u " + objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal[0], strstatusTypeValues[0],
						strStatusesValues[0])

				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[1])
				.selectMSTReasonValue(strReasonVal[1], strstatusTypeValues[1],
						strStatusesValues[1]).clickOnSaveButton();

		String strUpdatedTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedTime.split(" ");

		String strRequiredUpdatedTime = dts.converDateFormat(strTime[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonSummaryLink()
				  .enterReportStartDate(strCurrentDate)
				  .enterReportEndDate(strCurrentDate)
				  .selectResources(strResourceValue[0]).clickOnNextBtn()
				  .selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				  .clickOnNextBtn()
				  .selStatusReason(strReasonVal[0], strStatusesValues[0])
				  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		
		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonSummaryLink()
				  .enterReportStartDate(strCurrentDate)
				  .enterReportEndDate(strCurrentDate)
				  .selectResources(strResourceValue[0]).clickOnNextBtn()
				  .selStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				  .clickOnNextBtn()
				  .selStatusReason(strReasonVal[1], strStatusesValues[1])
				  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		
		File file2 = new File(strDownloadName1);
		boolean strPdf2 = file2.exists();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonSummaryLink()
				  .enterReportStartDate(strCurrentDate)
				  .enterReportEndDate(strCurrentDate)
				  .selectDataFileCommaSepatatedCSVRadioBtn()
				  .selectResources(strResourceValue[0]).clickOnNextBtn()
				  .selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				  .clickOnNextBtn()
				  .selStatusReason(strReasonVal[0], strStatusesValues[0])
				  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
		
		File file3 = new File(strDownloadName2);
		boolean strCsv1 = file3.exists();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonSummaryLink()
				  .enterReportStartDate(strCurrentDate)
				  .enterReportEndDate(strCurrentDate)
				  .selectDataFileCommaSepatatedCSVRadioBtn()
			  	  .selectResources(strResourceValue[0]).clickOnNextBtn()
				  .selStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				  .clickOnNextBtn()
				  .selStatusReason(strReasonVal[1], strStatusesValues[1])
				  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName3,
				strAutoITName);
		
		File file4 = new File(strDownloadName3);
		boolean strCsv2 = file4.exists();


		if (strCsv1) {
			String[] strTestData2 = {
					"91304",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strMSTStatusTypeName,
					objStatuTypes_data.strStatusNameInMulti,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "",
					objStatusReason_data.strReasonName, "",
					objReport_data.ExternalIP, strDownloadName2, "", "" };

			objOffCommonFunc.writeResultData(strTestData2,
					strPartialAutoResultsPath, "CSVDetails");
		}

		if (strCsv2) {
			String[] strTestData3 = {
					"91304",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strpMSTStatusTypeName,
					objStatuTypes_data.strStatusNameInMulti1,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "",
					objStatusReason_data.strReasonName1, "",
					objReport_data.ExternalIP, strDownloadName3, "", "" };

			objOffCommonFunc.writeResultData(strTestData3,
					strPartialAutoResultsPath, "CSVDetails");
		}

		if (strPdf1) {
			String[] strTestData = {
					"91304",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName, "", objStatusReason_data.strReasonName,
					objStatuTypes_data.strStatusNameInMulti, "", "", "" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");

			if (strPdf2) {
				String[] strTestData1 = {
						"91304",
						Login_data.strBuildName,
						objUser_data.strNewUserName + "/"
								+ objUser_data.strNewPassword,
						objTest_data.strRegionName, "", "",
						objResource_data.strResourceName,
						objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strpMSTStatusTypeName, "", "",
						objReport_data.ExternalIP, "", "",
						strRequiredUpdatedTime, strDownloadName1, "",
						objStatusReason_data.strReasonName1,
						objStatuTypes_data.strStatusNameInMulti1 };

				objOffCommonFunc.writeResultData(strTestData1,
						strPartialAutoResultsPath, "PDFDetails");
			}
		}
		objLogin1.clickLogOut();
		
		if(strPdf1 && strPdf2 && strCsv1 && strCsv2){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}

	/*********************************************************************************
	'Description : Verify that a 'Status Summary' report can be generated.
	'Precondition:
	'Date	 	 : 18-Sep-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a 'Status Summary' report can be generated.")
	public void testSmoke91256() throws Exception {

		gstrTCID = "91256";
		gstrTO = "Verify that a 'Status Summary' report can be generated.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);

		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strReasonVal[] = new String[4];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Map objMap1 = new Map(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);

		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);

		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + gstrTCID + "1_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + gstrTCID + "2_" + strTimeText
				+ fileType;

		String strDownloadName2 = file + "\\" + gstrTCID + "3_" + strTimeText
				+ fileType1;

		String strDownloadName3 = file + "\\" + gstrTCID + "4_" + strTimeText
				+ fileType1;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		// create statusReasons
		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName1,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[1] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName1);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName2,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[2] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName2);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName3,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[3] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName3);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes with selecting Reason
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal[0])
				.selectStatusReason(strReasonVal[1])
				.clickOnSaveButton()

				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal[0])
				.selectStatusReasonForStatus(strReasonVal[1])
				.clickOnSaveButton()

				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// create private status type
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strpMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal[2])
				.selectStatusReason(strReasonVal[3])
				.selectPrivateStatusTypeRadioBtn()
				.clickOnSaveButton()

				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti1)
				.selectStatusReasonForStatus(strReasonVal[2])
				.selectStatusReasonForStatus(strReasonVal[3])
				.clickOnSaveButton()

				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti1);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpMSTStatusTypeName);

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

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSummaryOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("1u " + objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(5000);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.verifyRegionalMapViewPgeIsDisplayed();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
			   .verUpdateStatusInPopupWindow()
			   .clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal[0], strstatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[1])
				.selectMSTReasonValue(strReasonVal[3], strstatusTypeValues[1],
						strStatusesValues[1]);

		objUpdateStatus_Page1.clickOnSaveButton();

		String strAppTime = objEventManagement1.getApplicationTime();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();

		String updatedtime = "(" + strAppTime + " " + objTest_data.timeZone
				+ ")";

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti, updatedtime);

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti1, updatedtime);

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				  .enterReportStartDate(strCurrentDate)
				  .enterReportEndDate(strCurrentDate)
				  .selectResources(strResourceValue[0])
				  .clickOnNextStepBtn()
				  .selectStatusType(objStatuTypes_data.strMSTStatusTypeName)
				  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
				
		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				  .enterReportStartDate(strCurrentDate)
				  .enterReportEndDate(strCurrentDate)
				  .selectResources(strResourceValue[0])
				  .clickOnNextStepBtn()
				  .selectStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		
		File file2 = new File(strDownloadName1);
		boolean strPdf2 = file2.exists();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				  .enterReportStartDate(strCurrentDate)
				  .enterReportEndDate(strCurrentDate)
			  	  .selectDataFileCommaSepatatedCSVRadioBtn()
				  .selectResources(strResourceValue[0])
				  .clickOnNextStepBtn()
				  .selectStatusType(objStatuTypes_data.strMSTStatusTypeName)
				  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file3 = new File(strDownloadName2);
		boolean strCsv1 = file3.exists();
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				  .enterReportStartDate(strCurrentDate)
				  .enterReportEndDate(strCurrentDate)
				  .selectDataFileCommaSepatatedCSVRadioBtn()
				  .selectResources(strResourceValue[0])
				  .clickOnNextStepBtn()
				  .selectStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				  .clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName3,
				strAutoITName);

		File file4 = new File(strDownloadName3);
		boolean strCsv2 = file4.exists();

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", updatedtime,
					strDownloadName, "", objStatusReason_data.strReasonName,
					objStatuTypes_data.strStatusNameInMulti, strCurrentDate,
					strCurrentDate, "" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");

			if (strPdf2) {
				String[] strTestData1 = {
						gstrTCID,
						Login_data.strBuildName,
						objUser_data.strNewUserName + "/"
								+ objUser_data.strNewPassword,
						objTest_data.strRegionName, "", "",
						objResource_data.strResourceName,
						objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strpMSTStatusTypeName, "", "",
						objReport_data.ExternalIP, "", "", updatedtime,
						strDownloadName1, "",
						objStatusReason_data.strReasonName3,
						objStatuTypes_data.strStatusNameInMulti1,
						strCurrentDate, strCurrentDate, "" };

				objOffCommonFunc.writeResultData(strTestData1,
						strPartialAutoResultsPath, "PDFDetails");
			}

			if (strCsv1) {
				String[] strTestData2 = {
						gstrTCID,
						Login_data.strBuildName,
						objUser_data.strNewUserName + "/"
								+ objUser_data.strNewPassword,
						objTest_data.strRegionName,
						objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusNameInMulti,
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName, "", "", "", "",
						objReport_data.ExternalIP, strDownloadName2, "", "", "" };

				objOffCommonFunc.writeResultData(strTestData2,
						strPartialAutoResultsPath, "CSVDetails");
			}

			if (strCsv2) {
				String[] strTestData3 = {
						gstrTCID,
						Login_data.strBuildName,
						objUser_data.strNewUserName + "/"
								+ objUser_data.strNewPassword,
						objTest_data.strRegionName,
						objStatuTypes_data.strpMSTStatusTypeName,
						objStatuTypes_data.strStatusNameInMulti1,
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName, "", "", "", "",
						objReport_data.ExternalIP, strDownloadName3, "", "", "" };

				objOffCommonFunc.writeResultData(strTestData3,
						strPartialAutoResultsPath, "CSVDetails");
			}
		}
		objLogin1.clickLogOut();
		
		if(strPdf1 && strPdf2 && strCsv1 && strCsv2){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	
	/*********************************************************************************
	'Description : Verify that a 'Status Detail' report can be generated for Number status type.
	'Precondition:
	'Date	 	 : 18-Sep-2014
	'Author		 : Rensuhree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a 'Status Detail' report can be generated for Number status type.")
	public void testSmoke91105() throws Exception {

		gstrTCID = "91105";
		gstrTO = "Verify that a 'Status Detail' report can be generated for Number status type.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName1 = file + "\\" + "TC91105_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC91105_2" + "_" + strTimeText
				+ fileType1;		
		String strDownloadName3 = file + "\\" + "TC91105_3" + "_" + strTimeText
				+ fileType;
		String strDownloadName4 = file + "\\" + "TC91105_4" + "_" + strTimeText
				+ fileType1;
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName2);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createPrivateStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusDetailOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate).clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strValueForUpdate);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts
		    .converDateFormat(strReportDate, "MM/dd/yyyy",
		      "dd-MMM-yyyy");

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strNSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strNSTStatusTypeName)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();

		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		double fltDurationDiff = (double) intDurationDiff / 3600;

		double dRounded = dts.roundTwoDecimals(fltDurationDiff);

		String strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("PDF generation duration " + strDurationDiffPDF);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		 
		File file1 = new File(strDownloadName1);
		boolean strPdf1 = file1.exists();

		if (strPdf1) {
			String[] strTestData = {
					"91105",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName2, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strNSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",strStartAndEndDate,strStartAndEndDate,
					strDurationDiffPDF , objView_data.strValueForUpdate};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strNSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strNSTStatusTypeName)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"M/dd/yyyy HH:mm");

		System.out.println(strRequiredAppEndTimeForExcel);
		
		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
	
		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					"91105",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					 objLogin_data.strRegionName2,
					objStatusTypes_data.strNSTStatusTypeName,
					"", objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					strExcelDurationDiffPDF,
					objReport_data.ExternalIP,strDownloadName2,strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel, objView_data.strValueForUpdate};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		
		// For private status type
		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[1])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForUpdate1).clickOnSaveButton();

		String strUpdatedTime1 = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime1 = objMap
				.getUpdatedTime(objView_data.strValueForUpdate1);
		String[] strTime1 = strUpdatedDateTime1.split(" ");
		String[] strDate1 = strTime[0].split("\\(");

		String strRequiredUpdatedTime1 = dts.converDateFormat(strDate1[0]
				+ strTime1[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel1 = dts.converDateFormat(
				strRequiredUpdatedTime1, "dd-MMM-yyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strNSTStatusTypeName1)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strNSTStatusTypeName1)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime1 = objEventManagement1.getApplicationTime();

		String[] strAppTime1 = strFetchAppDateTime1.split(" ");

		String strRequiredAppEndTime1 = dts.converDateFormat(strAppTime1[0]
				+ strAppTime1[1] + strCurYear + " " + strAppTime1[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff1 = dts.getTimeDiff1(strReportGeneratedtime1,
				strUpdatedTime1);

		double fltDurationDiff1 = (double) intDurationDiff1 / 3600;

		double dRounded1 = dts.roundTwoDecimals(fltDurationDiff1);

		String strDurationDiffPDF1 = Double.toString(dRounded1);

		System.out.println("PDF generation duration " + strDurationDiffPDF1);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName3,
				strAutoITName);
		
		File file3 = new File(strDownloadName3);
		boolean strPdf2 = file3.exists();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strNSTStatusTypeName1)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strNSTStatusTypeName1)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel1 = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel1 = strFetchAppDateTimeForExcel1.split(" ");

		String strRequiredAppEndTimeForExcel1 = dts.converDateFormat(
				strAppTimeForExcel1[0] + strAppTimeForExcel1[1] + strCurYear
						+ " " + strAppTimeForExcel1[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		int intExcelDurationDiff1 = dts.getTimeDiff1(
				strExcelReportGeneratedtime1, strUpdatedTime1);

		double fltExcelDurationDiff1 = (double) intExcelDurationDiff1 / 3600;

		double dExcelRounded1 = dts.roundTwoDecimals(fltExcelDurationDiff1);

		String strExcelDurationDiffPDF1 = Double.toString(dExcelRounded1);

		System.out.println("CSV generation duration "
				+ strExcelDurationDiffPDF1);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName4,
				strAutoITName);
		
		File file4 = new File(strDownloadName4);
		boolean strCsv2 = file4.exists();

		if (strPdf2) {
			String[] strTestData = {
					"91105",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName2, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strNSTStatusTypeName1, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime1,
					strDownloadName3, strRequiredAppEndTime1, "", "",strStartAndEndDate,strStartAndEndDate,
					strDurationDiffPDF1 , objView_data.strValueForUpdate};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		if (strCsv2) {
			String[] strTestDataForExcel = {
					"91105",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
							 objLogin_data.strRegionName2,
					objStatusTypes_data.strNSTStatusTypeName1,
					"", objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					strExcelDurationDiffPDF1,
					objReport_data.ExternalIP,strDownloadName4,strRequiredUpdatedTimeForExcel1,
					strRequiredAppEndTimeForExcel1, objView_data.strValueForUpdate1};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		
		objLogin1.clickLogOut();

		assertTrue(strPdf1&& strPdf2&& strCsv1&& strCsv2);
			gstrResult = "PASS";

	}
	
	/*********************************************************************************
	'Description : Verify that a 'Status Detail' report can be generated for Text status type.
	'Precondition:
	'Date	 	 : 19-Sep-2014
	'Author		 : Rensuhree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a 'Status Detail' report can be generated for Text status type.")
	public void testSmoke91141() throws Exception {

		gstrTCID = "91141";
		gstrTO = "Verify that a 'Status Detail' report can be generated for Text status type.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName1 = file + "\\" + "TC91141_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC91141_2" + "_" + strTimeText
				+ fileType1;
		String strDownloadName3 = file + "\\" + "TC91141_3" + "_" + strTimeText
				+ fileType;
		String strDownloadName4 = file + "\\" + "TC91141_4" + "_" + strTimeText
				+ fileType1;

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName2);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createPrivateStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusDetailOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate).clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strValueForUpdate);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"MM/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strTSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strTSTStatusTypeName)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();

		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		double fltDurationDiff = (double) intDurationDiff / 3600;

		double dRounded = dts.roundTwoDecimals(fltDurationDiff);

		String strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("PDF generation duration " + strDurationDiffPDF);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		
		File file1 = new File(strDownloadName1);
		boolean strPdf1 = file1.exists();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strTSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strTSTStatusTypeName)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();

		if (strPdf1) {
			String[] strTestData = {
					"91141",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName2, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strTSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",
					strDurationDiffPDF , objView_data.strValueForUpdate};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					"91141",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + ","
							+ objLogin_data.strRegionName2,
					objStatusTypes_data.strTSTStatusTypeName, "",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF, objReport_data.ExternalIP,
					strDownloadName2, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel,
					objView_data.strValueForUpdate };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		// For private status type
		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[1])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForUpdate1).clickOnSaveButton();

		String strUpdatedTime1 = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime1 = objMap
				.getUpdatedTime(objView_data.strValueForUpdate1);
		String[] strTime1 = strUpdatedDateTime1.split(" ");
		String[] strDate1 = strTime[0].split("\\(");

		String strRequiredUpdatedTime1 = dts.converDateFormat(strDate1[0]
				+ strTime1[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel1 = dts.converDateFormat(
				strRequiredUpdatedTime1, "dd-MMM-yyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strTSTStatusTypeName1)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strTSTStatusTypeName1)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime1 = objEventManagement1.getApplicationTime();

		String[] strAppTime1 = strFetchAppDateTime1.split(" ");

		String strRequiredAppEndTime1 = dts.converDateFormat(strAppTime1[0]
				+ strAppTime1[1] + strCurYear + " " + strAppTime1[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff1 = dts.getTimeDiff1(strReportGeneratedtime1,
				strUpdatedTime1);

		double fltDurationDiff1 = (double) intDurationDiff1 / 3600;

		double dRounded1 = dts.roundTwoDecimals(fltDurationDiff1);

		String strDurationDiffPDF1 = Double.toString(dRounded1);

		System.out.println("PDF generation duration " + strDurationDiffPDF1);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName3,
				strAutoITName);

		File file3 = new File(strDownloadName3);
		boolean strPdf2 = file3.exists();
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strTSTStatusTypeName1)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strTSTStatusTypeName1)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel1 = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel1 = strFetchAppDateTimeForExcel1.split(" ");

		String strRequiredAppEndTimeForExcel1 = dts.converDateFormat(
				strAppTimeForExcel1[0] + strAppTimeForExcel1[1] + strCurYear
						+ " " + strAppTimeForExcel1[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		int intExcelDurationDiff1 = dts.getTimeDiff1(
				strExcelReportGeneratedtime1, strUpdatedTime1);

		double fltExcelDurationDiff1 = (double) intExcelDurationDiff1 / 3600;

		double dExcelRounded1 = dts.roundTwoDecimals(fltExcelDurationDiff1);

		String strExcelDurationDiffPDF1 = Double.toString(dExcelRounded1);

		System.out.println("CSV generation duration "
				+ strExcelDurationDiffPDF1);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName4,
				strAutoITName);
		
		File file4 = new File(strDownloadName4);
		boolean strCsv2 = file4.exists();

		if (strPdf2) {
			String[] strTestData = {
					"91141",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName2, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strTSTStatusTypeName1, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime1,
					strDownloadName3, strRequiredAppEndTime1, "", "",
					strDurationDiffPDF1, objView_data.strValueForUpdate1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		if (strCsv2) {
			String[] strTestDataForExcel = {
					"91141",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + ","
							+ objLogin_data.strRegionName2,
					objStatusTypes_data.strTSTStatusTypeName1, "",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF1, objReport_data.ExternalIP,
					strDownloadName4, strRequiredUpdatedTimeForExcel1,
					strRequiredAppEndTimeForExcel1,
					objView_data.strValueForUpdate1 };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		objLogin1.clickLogOut();

		if(strPdf1 && strPdf2 && strCsv1 && strCsv2){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	
	/*********************************************************************************
	'Description :  Verify that a 'Status Detail' report can be generated for Multi status type.
	'Precondition:
	'Date	 	 : 19-Sep-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = " Verify that a 'Status Detail' report can be generated for Multi status type.")
	public void testSmoke91122() throws Exception {

		gstrTCID = "91122";
		gstrTO = "Verify that a 'Status Summary' report can be generated.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);

		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strReasonVal[] = new String[4];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Map objMap1 = new Map(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName1 = file + "\\" + "TC91122" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC91122" + "_" + strTimeText
				+ fileType1;
		String strDownloadName3 = file + "\\" + "SecTC91122" + "_"
				+ strTimeText + fileType;
		String strDownloadName4 = file + "\\" + "SecTC91122" + "_"
				+ strTimeText + fileType1;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		// create statusReasons
		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName1,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[1] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName1);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName2,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[2] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName2);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName3,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[3] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName3);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes with selecting Reason
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal[0])
				.selectStatusReason(strReasonVal[1])
				.clickOnSaveButton()

				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal[0])
				.selectStatusReasonForStatus(strReasonVal[1])
				.clickOnSaveButton()

				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// create private status type
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strpMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal[2])
				.selectStatusReason(strReasonVal[3])
				.selectPrivateStatusTypeRadioBtn()
				.clickOnSaveButton()

				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti1)
				.selectStatusReasonForStatus(strReasonVal[2])
				.selectStatusReasonForStatus(strReasonVal[3])
				.clickOnSaveButton()

				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti1);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpMSTStatusTypeName);

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
		System.out.println(objResource_data.strResourceName);
		System.out.println(objStatuTypes_data.strMSTStatusTypeName);
		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("1u " + objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strstatusTypeValues[0])
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal[0], strstatusTypeValues[0],
						strStatusesValues[0]).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap1
				.getUpdatedTime(objStatuTypes_data.strStatusNameInMulti);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"MM/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");

		objReport1.clickOnStatusDetail().verStatusDetailReportPgeIsDisplayed()
				  .enterReportStartDate(strReportDate)
				  .enterReportEndDate(strReportDate)
				  .selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				  .clickOnNextBtn().verStatusDetailReportPge2IsDisplayed()
				  .selectStatusCheckbox(strStatusesValues[0])
				  .selectResources(strResourceValue[0])
				  .clickOnGenerateReportBtn();

		String strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();

		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		double fltDurationDiff = (double) intDurationDiff / 3600;

		double dRounded = dts.roundTwoDecimals(fltDurationDiff);

		String strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("PDF generation duration " + strDurationDiffPDF);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		
		File file1 = new File(strDownloadName1);
		boolean strPdf1 = file1.exists();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusDetail().verStatusDetailReportPgeIsDisplayed()
				  .enterReportStartDate(strReportDate)
				  .enterReportEndDate(strReportDate)
				  .selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				  .selectExcelReportRadioBtn().clickOnNextBtn()
				  .verStatusDetailReportPge2IsDisplayed()
				  .selectStatusCheckbox(strStatusesValues[0])
				  .selectResources(strResourceValue[0])
				  .clickOnGenerateReportBtn();

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"dd-MMM-yyyy HH:mm");

		String[] strExcelRepTime = strRequiredAppEndTimeForExcel.split(" ");

		String strExcelReportGeneratedtime = strExcelRepTime[1];

		int intExcelDurationDiff = dts.getTimeDiff(strExcelReportGeneratedtime,
				strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
		
		File file2 = new File(strDownloadName2);
		boolean strCSV1 = file2.exists();

		String strCurrDate = dts.getCurrentDate("MM/dd/yyyy");
		String strDatePresenInPdfFormat = dts.converDateFormat(strCurrDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");

		if (strPdf1) {
			String[] strTestData = {
					"91122",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",
					strDurationDiffPDF };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		if (strCSV1) {
			String[] strTestData2 = {
					"91122",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strMSTStatusTypeName,
					objStatuTypes_data.strStatusNameInMulti,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "",
					objStatusReason_data.strReasonName,
					strExcelDurationDiffPDF, objReport_data.ExternalIP,
					strDownloadName2, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel, "" };

			objOffCommonFunc.writeResultData(strTestData2,
					strPartialAutoResultsPath, "CSVDetails");

		}

		// For private status type
		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strstatusTypeValues[1])
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[1])
				.selectMSTReasonValue(strReasonVal[3], strstatusTypeValues[1],
						strStatusesValues[1]).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedTime1 = dts.timeNow("HH:mm:ss");

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime1 = objMap1
				.getUpdatedTime(objStatuTypes_data.strStatusNameInMulti1);
		String[] strTime1 = strUpdatedDateTime1.split(" ");
		String[] strDate1 = strTime[0].split("\\(");

		String strRequiredUpdatedTime1 = dts.converDateFormat(strDate1[0]
				+ strTime1[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel1 = dts.converDateFormat(
				strRequiredUpdatedTime1, "dd-MMM-yyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusDetail().verStatusDetailReportPgeIsDisplayed()
				  .enterReportStartDate(strReportDate)
				  .enterReportEndDate(strReportDate)
				  .selStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				  .clickOnNextBtn().verStatusDetailReportPge2IsDisplayed()
				  .selectStatusCheckbox(strStatusesValues[1])
				  .selectResources(strResourceValue[0])
				  .clickOnGenerateReportBtn();

		String strReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime1 = objEventManagement1.getApplicationTime();

		String[] strAppTime1 = strFetchAppDateTime1.split(" ");

		String strRequiredAppEndTime1 = dts.converDateFormat(strAppTime1[0]
				+ strAppTime1[1] + strCurYear + " " + strAppTime1[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff1 = dts.getTimeDiff1(strReportGeneratedtime1,
				strUpdatedTime1);

		double fltDurationDiff1 = (double) intDurationDiff1 / 3600;

		double dRounded1 = dts.roundTwoDecimals(fltDurationDiff1);

		String strDurationDiffPDF1 = Double.toString(dRounded1);

		System.out.println("PDF generation duration " + strDurationDiffPDF1);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName3,
				strAutoITName);
		
		File file3 = new File(strDownloadName3);
		boolean strPdf2 = file3.exists();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusDetail().verStatusDetailReportPgeIsDisplayed()
				  .enterReportStartDate(strReportDate)
				  .enterReportEndDate(strReportDate)
				  .selStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				  .selectExcelReportRadioBtn().clickOnNextBtn()
				  .verStatusDetailReportPge2IsDisplayed()
				  .selectStatusCheckbox(strStatusesValues[1])
				  .selectResources(strResourceValue[0])
				  .clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel1 = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel1 = strFetchAppDateTimeForExcel1.split(" ");

		String strRequiredAppEndTimeForExcel1 = dts.converDateFormat(
				strAppTimeForExcel1[0] + strAppTimeForExcel1[1] + strCurYear
						+ " " + strAppTimeForExcel1[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		int intExcelDurationDiff1 = dts.getTimeDiff1(
				strExcelReportGeneratedtime1, strUpdatedTime1);

		double fltExcelDurationDiff1 = (double) intExcelDurationDiff1 / 3600;

		double dExcelRounded1 = dts.roundTwoDecimals(fltExcelDurationDiff1);

		String strExcelDurationDiffPDF1 = Double.toString(dExcelRounded1);

		System.out.println("CSV generation duration "
				+ strExcelDurationDiffPDF1);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName4,
				strAutoITName);

		File file4 = new File(strDownloadName4);
		boolean strCSV2 = file4.exists();

		if (strPdf2) {
			String[] strTestData = {
					"91122",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strpMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "",
					strDatePresenInPdfFormat + " " + strRequiredUpdatedTime1,
					strDownloadName3, strRequiredAppEndTime1, "", "",
					strDurationDiffPDF1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		if (strCSV2) {
			String[] strTestData3 = {
					"91122",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword + ","
							+ objTest_data.strRegionName,
					objStatuTypes_data.strpMSTStatusTypeName,
					objStatuTypes_data.strStatusNameInMulti1,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF1, objReport_data.ExternalIP,
					strDownloadName4, strRequiredUpdatedTimeForExcel1,
					strRequiredAppEndTimeForExcel1, "" };

			objOffCommonFunc.writeResultData(strTestData3,
					strPartialAutoResultsPath, "CSVDetails");

		}

		objLogin1.clickLogOut();

		assertTrue(strPdf1 && strPdf2 && strCSV1 && strCSV2);
			gstrResult = "PASS";

	}
	
	/*********************************************************************************
	'Description : Verify that a 'Status Detail' report can be generated for Saturation Score status type.
	'Precondition:
	'Date	 	 : 22-Sep-2014
	'Author		 : Rensuhree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a 'Status Detail' report can be generated for Saturation Score status type.")
	public void testSmoke91143() throws Exception {

		gstrTCID = "91143";
		gstrTO = "Verify that a 'Status Detail' report can be generated for Saturation Score status type.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		
		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName1 = file + "\\" + "TC91143_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC91143_2" + "_" + strTimeText
				+ fileType1;
		String strDownloadName3 = file + "\\" + "TC91143_3" + "_" + strTimeText
				+ fileType;
		String strDownloadName4 = file + "\\" + "TC91143_4" + "_" + strTimeText
				+ fileType1;
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);
		
		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);
		
		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createPrivateStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName1);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusDetailOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterUpdateSSTValues(strStatusTypeValues[0], objView_data.strValueForSST)
				.clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strUpdatedValForSST);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"MM/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		 String strStartAndEndDate = dts
				    .converDateFormat(strReportDate, "MM/dd/yyyy",
				      "dd-MMM-yyyy");

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strSSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strSSTStatusTypeName)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();

		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		double fltDurationDiff = (double) intDurationDiff / 3600;

		double dRounded = dts.roundTwoDecimals(fltDurationDiff);

		String strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("PDF generation duration " + strDurationDiffPDF);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		
		File file1 = new File(strDownloadName1);
		boolean strPdf1 = file1.exists();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strSSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strSSTStatusTypeName)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
		
		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();

		if (strPdf1) {
			String[] strTestData = {
					"91143",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strSSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, strStartAndEndDate, strStartAndEndDate,
					strDurationDiffPDF , objView_data.strUpdatedValForSST};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					"91143",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + ","
							+ objLogin_data.strRegionName,
							objStatuTypes_data.strSSTStatusTypeName, "",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF, objReport_data.ExternalIP,
					strDownloadName2, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel,
					objView_data.strUpdatedValForSST};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		// For private status type
		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[1])
				.enterUpdateSSTValues(strStatusTypeValues[1], objView_data.strValueForSST1)
				.clickOnSaveButton();

		String strUpdatedTime1 = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime1 = objMap
				.getUpdatedTime(objView_data.strUpdatedValForSST1);
		String[] strTime1 = strUpdatedDateTime1.split(" ");
		String[] strDate1 = strTime[0].split("\\(");

		String strRequiredUpdatedTime1 = dts.converDateFormat(strDate1[0]
				+ strTime1[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel1 = dts.converDateFormat(
				strRequiredUpdatedTime1, "dd-MMM-yyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strSSTStatusTypeName1)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strSSTStatusTypeName1)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime1 = objEventManagement1.getApplicationTime();

		String[] strAppTime1 = strFetchAppDateTime1.split(" ");

		String strRequiredAppEndTime1 = dts.converDateFormat(strAppTime1[0]
				+ strAppTime1[1] + strCurYear + " " + strAppTime1[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff1 = dts.getTimeDiff1(strReportGeneratedtime1,
				strUpdatedTime1);

		double fltDurationDiff1 = (double) intDurationDiff1 / 3600;

		double dRounded1 = dts.roundTwoDecimals(fltDurationDiff1);

		String strDurationDiffPDF1 = Double.toString(dRounded1);

		System.out.println("PDF generation duration " + strDurationDiffPDF1);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName3,
				strAutoITName);
		
		File file3 = new File(strDownloadName3);
		boolean strPdf2 = file3.exists();
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strSSTStatusTypeName1)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strSSTStatusTypeName1)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel1 = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel1 = strFetchAppDateTimeForExcel1.split(" ");

		String strRequiredAppEndTimeForExcel1 = dts.converDateFormat(
				strAppTimeForExcel1[0] + strAppTimeForExcel1[1] + strCurYear
						+ " " + strAppTimeForExcel1[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		int intExcelDurationDiff1 = dts.getTimeDiff1(
				strExcelReportGeneratedtime1, strUpdatedTime1);

		double fltExcelDurationDiff1 = (double) intExcelDurationDiff1 / 3600;

		double dExcelRounded1 = dts.roundTwoDecimals(fltExcelDurationDiff1);

		String strExcelDurationDiffPDF1 = Double.toString(dExcelRounded1);

		System.out.println("CSV generation duration "
				+ strExcelDurationDiffPDF1);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName4,
				strAutoITName);

		File file4 = new File(strDownloadName4);
		boolean strCsv2 = file4.exists();

		if (strPdf2) {
			String[] strTestData = {
					"91143",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strSSTStatusTypeName1, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime1,
					strDownloadName3, strRequiredAppEndTime1, strStartAndEndDate, strStartAndEndDate,
					strDurationDiffPDF1 ,objView_data.strUpdatedValForSST1};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		if (strCsv2) {
			String[] strTestDataForExcel = {
					"91143",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + ","
							+ objLogin_data.strRegionName,
							objStatuTypes_data.strSSTStatusTypeName1, "",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF1, objReport_data.ExternalIP,
					strDownloadName4, strRequiredUpdatedTimeForExcel1,
					strRequiredAppEndTimeForExcel1,
					objView_data.strUpdatedValForSST1};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();

		if(strPdf1 && strPdf2 && strCsv1 && strCsv2){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	/*******************************************************************************
	'Description : Verify that a 'Monthly Status Assessment' report can be generated.
	'Precondition:
	'Date	 	 : 25-Feb-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************/
	@Test(description = "Verify that a 'Monthly Status Assessment' report can be generated.")
	public void testSmoke91307() throws Exception {

		gstrTCID = "91307";
		gstrTO = "Verify that a 'Monthly Status Assessment' report can be generated.";
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		CSVFunctions objCSVFunctions = new CSVFunctions();
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.csvFile;

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		
		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName = file + "\\" + "TC" +gstrTCID+ "_" + strTimeText
				+ fileType;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();



		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		// User creation
		objUsersList1
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMonthlyStatusAssignmentOption()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin1.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();
		System.out.println(objResource_data.strResourceName);
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1
				.selectStatusTypes(strstatusTypeValues[0])
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[0])
						.clickOnSaveButton();

		String strCurrentDate = objDts.getCurrentDate("MM/dd/yyyy HH:mm");

		String[] strTime4 = strCurrentDate.split(" ");
		
		String[] strTime5 = strTime4[0].split("/");
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnMonthlyStatusSummaryLink();
		
		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objReport1.verifyDetailsInMonthlyStatusAssesmentPage1(strTime5[0], strTime5[2]);
		
		String strMonth = objReport1.getSelectedMonth();
		
		objReport1.selectResources(strResourceValue[0]).clickOnNextBtn()
		
		.verMonthlyStatusAssessmentReportPge2IsDisplayed()
		  .selStatusType(objStatusTypes_data.strMSTStatusTypeName)
		  .clickOnNextBtn()
		  .verMonthlyStatusAssessmentReportPge3IsDisplayed()
		  .verifyStatuses(strStatusesValues[0])
		  .verifyStatuses(strStatusesValues[1])
		  .selStatuses(strStatusesValues[0]);
		
		String mainWindowHandle = driver1.getWindowHandle();

		String strEventStartTime = objEventManagement1.getApplicationTimeWithCSTCDT();

		String strEventStartTime1 = dts.AddTimeToExistingTimeHourAndMin(strEventStartTime, 0, 1, "dd MMM HH:mm");
		String strStartTime[] = strEventStartTime.split(" ");

		String strReportTime = strStartTime[0]+" "+strStartTime[1]+" "+strTime5[2]+" "+strStartTime[2]+" "+objTest_data.timeZone;
		
		String strStartTime1[] = strEventStartTime1.split(" ");
		
		String strReportTime1 = strStartTime1[0]+" "+strStartTime1[1]+" "+strTime5[2]+" "+strStartTime1[2]+" "+objTest_data.timeZone;
		
		objReport1.clickOnGenerateReportBtn();

		Thread.sleep(10000);
		
		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		
		String TitleName = driver1.getTitle();
		assertTrue(TitleName.contains("Monthly Status Assessment Report"));

		String[] strHeaderName = {"Monthly Status Assessment Report for "+strMonth+" "+ strTime5[2],objStatusTypes_data.strMSTStatusTypeName };
		
		objReport1.verifyHeadersInHTMLMonthlyAssesmentReport(strHeaderName);
		
		String[] strHeaderName1  = {"Resource Selected: "+objResource_data.strResourceName+" (N=1)", "Status Selected: "+objStatuTypes_data.strStatusNameInMulti};
		objReport1.verifyRSAndSTInHTMLMonthlyAssesmentReport(strHeaderName1);
		
		objReport1.verifyFooterHTMLMonthlyAssesmentReport(strReportTime, strReportTime1);
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnMonthlyStatusSummaryLink();

		objReport1.selectCSVRadioBtn();
		
		objReport1.selectResources(strResourceValue[0]).clickOnNextBtn()
		
		  .selStatusType(objStatusTypes_data.strMSTStatusTypeName)
		  .clickOnNextBtn()
		  .verMonthlyStatusAssessmentReportPge3IsDisplayed()
		  .selStatuses(strStatusesValues[0]);

		objReport1.clickOnGenerateReportBtn();
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		
		File file1 = new File(strDownloadName);
		boolean strCsv1 = file1.exists();

		objLogin1.clickLogOut();

		String[][] strReportData = {{},{}, {},{}, {"\"Monthly Status Assessment Report for "+strMonth+" of "+strTime5[2]+"\""}, {"\""+objStatuTypes_data.strMSTStatusTypeName+"\""},{"\"Resource Selected: "+objResource_data.strResourceName+"(N=1)\""}, {"\"Status Selected: "+objStatuTypes_data.strStatusNameInMulti+"\""}, {"\"HOUR\""}};

		assertTrue(file1.exists());
		objCSVFunctions.verifyMonthlyAssesmentCSVData(strDownloadName, strReportData);
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strMSTStatusTypeName + ", ",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					"",
					objReport_data.ExternalIP,
					strDownloadName,"",
					"",
					 objStatuTypes_data.strStatusNameInMulti};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
			gstrResult = "PASS";
		}
	}

	/************************************************************************************************************************************
	 * 'Description : Verify that user with right ‘Report - Incoming Patient Notification Detail’ can generate IPN report in PDF format. 
	 * 'Date        : 12-Mar-2015 
	 * 'Author      : Rahul
	 ************************************************************************************************************************************/
	@Test(description = "Verify that user with right ‘Report - Incoming Patient Notification Detail’ can generate IPN report in PDF format")
	public void testSmoke148816() throws Exception {
		gstrTCID = "148816";
		gstrTO = "Verify that user with right ‘Report - Incoming Patient Notification Detail’ can generate IPN report in PDF format";

		// Objects for data
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		EMTrack_data objEMTrack_data = new EMTrack_data();
		Date_Time_settings objDts = new Date_Time_settings();

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		Regions Regions_Page = new Regions(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement EventManagement_Page1=new EventManagement(this.driver1);
		Report Report_Page1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		Roles_data objRolesData = new Roles_data();
		String strRoleValue[] = new String[1];
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		File file = new File(System.getProperty("user.dir") + fileDownloadPath) ;
		
		String strDownloadName = file + "\\" 
		        + "TC"+ gstrTCID
				+ "_" 
		        + strTimeText
				+ fileType;
		
		boolean blnTest = false;
		
		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strSetracReg);

		RegionDefault_page.selectFrame();

		NavigationToSubMenus_page.navigateToRegions();

		Regions_Page.clickOnEditRegions(objTest_data.strSetracReg)
				.selectIncomingPatientNotification().clickSaveButton();
		
		//New Role creation
		NavigationToSubMenus_page.navigateToRoles();
		
		objRoles1.clickOnCreateNewRoleBtn()
		.enterRoleName(objRolesData.strRoleName);	
		objRoles1.clickOnSaveBtn();
		
		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		// User creation
		UsersList_page.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectRunReportRight(objResource_data.strSetracResourceName)
				.clickAdvancedOptionAndExpand()		
				.selectReportIncomingPatientNotificationOption()
				.selectIncomingPatientNotificationOption()
				.clickSaveButton();

		login_page.clickLogOut();

		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strSetracRegion);

		EMTrackLogin_Page.navigateToPatientPage();

		Thread.sleep(10000);

		EMTrackLogin_Page.navToAddDailyPatientPage();

		EMTrackLogin_Page.enterPatientID(objEMTrack_data.strPatientID);

		EMTrackLogin_Page.selGender(objEMTrack_data.strMale);
		
		EMTrackLogin_Page.selRedTriageCategory();

		EMTrackLogin_Page.enterPatientAge(objEMTrack_data.strPatientAge);
		
		EMTrackLogin_Page.selDestinationLocation(objEMTrack_data.setracLocation);

		EMTrackLogin_Page.selProvider(objEMTrack_data.setracProvider);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.setracProviderUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		String strApplicationTime = EMTrackLogin_Page.getApplcnTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		String strArrivalTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");
		
		System.out.println(strApplicationTime);

		EMTrackLogin_Page.clkSaveBtn();
		
		EMTrackLogin_Page.clickLogOutLink();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		String strHeader = "Incoming Patient Notification for "+objEMTrack_data.setracLocation;

		String[] strHeaderNames = { "Sent By:", "Age:", "Complaint:",
				"Triage:", "Gender:", "Region:" };

		String[] strUpdatedValues = { objEMTrack_data.strQsgTester,
				objEMTrack_data.strPatientAge + " Years", "unknown",
				"Immediate", objEMTrack_data.strMale, objTest_data.strSetracReg };
		
		Thread.sleep(5000);

		RegionDefault_Page1
				.selectFrame()
				.verWebNotificationframe()
				.verIncomingPatientNotificationMsg(strHeader, strHeaderNames, strUpdatedValues,
						strArrivalTime)
				.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame()
				.selectFrame();
		
		objNavigationToSubMenus1.clickOnReports();
		
		objNavigationToSubMenus1.clickOnResourceReportsLink();
		
		Report_Page1.clickOnIPNLink();
		
		String strCurrentDate = EventManagement_Page1.getApplicationTime();
		
		String strDateAndMonth[] = strCurrentDate.split(" ");
		
		strCurrentYear = dts.timeNow("yyyy");
		
		strCurrentDate = strDateAndMonth[0]+"/"+strDateAndMonth[1]+"/"+strCurrentYear;
		
		strCurrentDate = dts.converDateFormat(strCurrentDate, "dd/MMM/yyyy", "MM/dd/yyyy");
		
		strCurrentDate = strCurrentDate.replace(" ", "");
		
		String strAcknolwedgeTime =  strCurrentDate+" "+strDateAndMonth[2];
		System.out.println(strAcknolwedgeTime);
		
		Thread.sleep(3000);
		
		Report_Page1.verrifyIncomingPatientNotificationPage()
		
		.enterReportStartDate(strCurrentDate)
		
		.enterReportEndDate(strCurrentDate)
		
		.clickOnPDFOption()
		
		.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName, strAutoITName);
		System.out.println(strDownloadName);
		
		String strPatientAgeWithYears = objEMTrack_data.strPatientAge+" Years";
			
		login_page1.clickLogOut();

		blnTest = true;
		
		if (blnTest) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strSetracReg,
					objResource_data.strSetracResourceName, strDownloadName,
					strCurrentDate, strCurrentDate, strArrivalTime,
					"Immediate", objEMTrack_data.strMale,
					strPatientAgeWithYears, objEMTrack_data.strComplaintData,
					objEMTrack_data.strQsgTester, strApplicationTime,
					strAcknolwedgeTime, objUser_data.strNewUserName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "IPNPDFDetails");
		}

		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a 'Form Detail' report can be generated.
	'Precondition:
	'Date	 	 : 22-Apr-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/

	@Test(description = "Verify that a 'Form Detail' report can be generated.")
	public void testSmoke91315() throws Exception {

		gstrTCID = "91315";
		gstrTO = "Verify that a 'Form Detail' report can be generated.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = objDts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.reportFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		// First file variables
		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";
		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

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
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectFirstRole()
				.clickSaveButton();
		
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectReportformDetail()
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);
		System.out.println(objUserdata.strNewUserName3);

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectFormActivation(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selectCompletedFormDelivery(
						objFormConfiguration_data.strUserToUsersAndResources)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName2)
				.clickOnNextButton()
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
				.selectRunReportChkBoxInSecurityPge(objUserdata.strNewUserName3)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		String strApplicationDate = objEventManagement.getApplicationTimeWithCSTCDT();
		String[] strDate = strApplicationDate.split(" ");
		String strCurrentDate = objDts.getCurrentDate("dd");
		String strStartDate = "";
		int intDate = Integer.parseInt(strDate[0]);
		int intCurrentDate = Integer.parseInt(strCurrentDate);
		
		if (intDate == intCurrentDate) {
			strStartDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate < intCurrentDate) {
				strStartDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strStartDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration.verTemplateDesignPage()
						    .clickOnInsert()
						    .clickOnGroupLink()
						    .verifyEditGroupOrTable()
						    .enterNewGroupName(objFormConfiguration_data.strGroupName)
						    .clickOnGroupDoneButton()
						    .clickOnAddButton(objFormConfiguration_data.strGroupName)
						    .clickOnFieldSet(objFormConfiguration_data.strGroupName)
						    .verifyEditFieldSetWindow()
						    .enterAttributesLabelName(objFormConfiguration_data.strAttributeName)
						    .clickOnEditFieldDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strNumeric)
						    .enterLabelName(objFormConfiguration_data.strLabelName)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()					    
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strText)
						    .enterLabelName(objFormConfiguration_data.strLabelName1)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()				    
						    .clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
Thread.sleep(5000);
		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
						 .selUserToFillOutForm(objUserdata.strNewUserName2)
						 .clickOnActivateForm();

		strApplicationDate = objEventManagement1.getApplicationTimeWithCSTCDT();
		String[] strDateInApplication = strApplicationDate.split(" ");
		String strActivationDate = "";
		int intDateInApplication = Integer.parseInt(strDateInApplication[0]);
		if (intDateInApplication == intCurrentDate) {
			strActivationDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDateInApplication < intCurrentDate) {
				strActivationDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strActivationDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		strDate = strApplicationDate.split(" ");

		String strActivationTime = strDate[2];

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName2,
								 objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(3000);
		
		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,objBlankFormData.strTextAnswer)
					.clickOnSave();
		
		Thread.sleep(5000);
		
		objBlankForm.clickOnComplete();
		
		Thread.sleep(5000);
		
		objDispatchForm.selUserToReceiveCompletedForm(objUserdata.strNewUserName3)
					   .selectResourcesInDispatch(objResource_data.strResourceName)
					   .clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners1.clickOnRefresh();

		Thread.sleep(1000);

		String strApplicationDate1 = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String[] strDate1 = strApplicationDate1.split(" ");
		String strEndDate = "";
		int intDate1 = Integer.parseInt(strDate1[0]);
		if (intDate1 == intCurrentDate) {
			strEndDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate1 < intCurrentDate) {
				strEndDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strEndDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}

		String strCompletedTime = strDate1[2];
		System.out.println("Completed Time: " + strCompletedTime);
		Thread.sleep(1000);

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName,
								 	objUserdata.strNewPassword);

//		String strMsg = "Submitted by "+objUserdata.strFullName2+" for "
//						+objResource_data.strResourceName+"\nSummary: | "
//						+ objFormConfiguration_data.strLabelName 
//						+ ": " + objBlankFormData.strNumericAnswer 
//						+ "| "+objFormConfiguration_data.strLabelName1+": "
//						+objBlankFormData.strTextAnswer;
		
		String strMsg = objRegionDefault1
				.getWebNotificationForResourceWith2Quest(
						objUserdata.strFullName2,
						objResource_data.strResourceName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);
		
		objRegionDefault1.selectFrame()
						 .verWebNotificationframe()
						 .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
										strMsg)				
						  .clickAcknowledgeAllForms();

		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName3,
			 			objUserdata.strNewPassword);

//		String strMsg1 = "Submitted by "+objUserdata.strFullName2+"\nSummary: | "
//							+ objFormConfiguration_data.strLabelName + ": "
//							+ objBlankFormData.strNumericAnswer + "| "
//							+ objFormConfiguration_data.strLabelName1+": "
//							+ objBlankFormData.strTextAnswer;
		
		String strMsg1 = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(
						objUserdata.strFullName2, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);
		
		objRegionDefault1.selectFrame()
						 .verWebNotificationframe()
						 .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
								strMsg1)
						 .clickAcknowledgeAllForms()
						 .selectFrame();

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.navigateToFormReport();

		objReport1.clickOnFormDetail()
				  .verifyFormDetailReportPage()
				  .enterReportStartDate(strStartDate)
				  .enterReportEndDate(strEndDate)
				  .selForm(objFormConfiguration_data.strFormName)
				  .clickOnGenerateReportBtn();

		Thread.sleep(5000);

		String[] strQuestions = { objFormConfiguration_data.strLabelName, objFormConfiguration_data.strLabelName1 };

		String[] strHeaderNames = ArrayUtils.addAll(
				objReport_data.strHtmlHeaderContents, strQuestions);

		String strDeliveredTo = objUserdata.strFullName3 + ", " + objResource_data.strResourceName;

		String[] strAnswers = { strActivationDate, strActivationTime,
				objUserdata.strNewUserName1, strDeliveredTo,
				strEndDate, strCompletedTime, objUserdata.strNewUserName2,
				objUserdata.strFullName2, objBlankFormData.strNumericAnswer,
				objBlankFormData.strTextAnswer };

		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objReport1
				.verifyFormNameStartDateAndEndDate(
						objFormConfiguration_data.strFormName, strStartDate,
						strEndDate)
				.verHTMLFormHeadersAndAnswers(strHeaderNames, strAnswers);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate).selectXlsxRadioBtn()
				.selForm(objFormConfiguration_data.strFormName);

		Thread.sleep(2000);
		objReport1.clickOnGenerateReportBtn();
		Thread.sleep(10000);
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		int intCount = 0;
		int intCount1 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
					assertTrue(new File(strCSVDownlRenamedPath).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount1++;
					}

				} while (intCount1 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);

		/*objxlsx2xls.convertXlsxToXls(strDownloadName, strDownloadName1);*/
		String strValue;

		String[] arrForm = { "Form", objFormConfiguration_data.strFormName };
		String[] arrStartDate = { "Start Date", strStartDate };
		String[] arrEndDate = { "End Date", strEndDate };

		for (intCount = 1; intCount <= arrForm.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 1,
					intCount, strDownloadName1);
			assertEquals(arrForm[intCount - 1], strValue);
		}

		for (intCount = 1; intCount <= arrStartDate.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 2,
					intCount, strDownloadName1);
			assertEquals(arrStartDate[intCount - 1], strValue);
		}

		for (intCount = 1; intCount <= arrEndDate.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 3,
					intCount, strDownloadName1);
			assertEquals(arrEndDate[intCount - 1], strValue);
		}

		String[] strValues = strAnswers;

		for (intCount = 1; intCount <= (strHeaderNames.length - 1); intCount++) {
			if (intCount == 2 || intCount == 6) {
				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						4, intCount, strDownloadName1);
				assertTrue(strValue.contains(strHeaderNames[intCount - 1]));

				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						5, intCount, strDownloadName1);
				String strTime = strValues[intCount - 1];
				String strTime1 = objDts
						.addTimetoExisting(strTime, -1, "HH:mm");
				String strTime2 = objDts.addTimetoExisting(strTime, 1, "HH:mm");
				assertTrue(strValue.contains(strValues[intCount - 1])
						|| strValue.contains(strTime1)
						|| strValue.contains(strTime2));
			} else {
				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						4, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						5, intCount, strDownloadName1);
				assertEquals(strValues[intCount - 1], strValue);
			}
		}

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that 'Form Summary' report can be generated. 
	'Precondition:
	'Date	 	 : 24-Apr-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that 'Form Summary' report can be generated.")
	public void testSmoke158843() throws Exception {

		gstrTCID = "158843";
		gstrTO = "Verify that 'Form Summary' report can be generated.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		Report_data objReport_data = new Report_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		BlankForm objBlankForm1 = new BlankForm(this.driver1);
		DispatchForm objDispatchForm1 = new DispatchForm(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		String strTimeText = objDts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.reportFile;
		AutoIT objAutoIT = new AutoIT(this.driver1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

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
		System.out.println(objResource_data.strResourceName);
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportformDetail()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectFormActivation(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selectCompletedFormDelivery(
						objFormConfiguration_data.strUserToUsersAndResources)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.selectCarteBlancheChkBoxInSecurityPge(
						objUserdata.strNewUserName2)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		String strApplicationDate = objEventManagement
				.getApplicationTimeWithCSTCDT();
		String[] strDate = strApplicationDate.split(" ");
		String strCurrentDate = objDts.getCurrentDate("dd");
		String strStartDate = "";
		int intDate = Integer.parseInt(strDate[0]);
		int intCurrentDate = Integer.parseInt(strCurrentDate);

		if (intDate == intCurrentDate) {
			strStartDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate < intCurrentDate) {
				strStartDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strStartDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(10000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration
				.verTemplateDesignPage()
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName)
				.clickOnEditFieldDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.clickOnDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)

				.selUserToFillOutForm(objUserdata.strNewUserName1)

				.clickOnActivateForm();

		strApplicationDate = objEventManagement1.getApplicationTimeWithCSTCDT();
		String[] strDateInApplication = strApplicationDate.split(" ");
		String strActivationDate = "";
		int intDateInApplication = Integer.parseInt(strDateInApplication[0]);
		if (intDateInApplication == intCurrentDate) {
			strActivationDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDateInApplication < intCurrentDate) {
				strActivationDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strActivationDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		strDate = strApplicationDate.split(" ");

		String strActivationTime = strDate[2];

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		System.out.println("dsf");

		String mainWindowHandle1 = driver1.getWindowHandle();

		objBlankForm1
				.switchToNewWin()
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer)
				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer).clickOnSave();

		Thread.sleep(5000);

		objBlankForm1.clickOnComplete();

		objDispatchForm1
				.selectResourcesInDispatch(objResource_data.strResourceName)
				.selUserToReceiveCompletedForm(objUserdata.strNewUserName3)
				.clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners1.clickOnRefresh();

		String strApplicationDate1 = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String[] strDate1 = strApplicationDate1.split(" ");
		String strEndDate = "";
		int intDate1 = Integer.parseInt(strDate1[0]);
		if (intDate1 == intCurrentDate) {
			strEndDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate1 < intCurrentDate) {
				strEndDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strEndDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}

		String strFilledOutDate = strEndDate;
		String strFilledOutTime = strDate1[2];

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName3,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName1
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//				+ ": " + objBlankFormData.strNumericAnswer + "| "
//				+ objFormConfiguration_data.strLabelName1 + ": "
//				+ objBlankFormData.strTextAnswer;

		String strMsg = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(
						objUserdata.strFullName1,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);
		
		Thread.sleep(5000);
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().switchToDefaultFrame()
				.selectFrame();
		
		objLinksAtTopRightCorners1.clickOnRefresh();

		Thread.sleep(2000);

		String strApplicationDate2 = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String[] strDate2 = strApplicationDate2.split(" ");
		String strAcknowledgedDate = "";
		int intDate2 = Integer.parseInt(strDate2[0]);
		if (intDate2 == intCurrentDate) {
			strAcknowledgedDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate2 < intCurrentDate) {
				strAcknowledgedDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strAcknowledgedDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}

		String strAcknowledgedTime1 = strDate2[2] ;
		System.out.println("Acknowledged Time: " + strAcknowledgedTime1);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

//		String strMsg1 = "Submitted by " + objUserdata.strFullName1 + " for "
//				+ objResource_data.strResourceName + "\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objBlankFormData.strNumericAnswer + "| "
//						+ objFormConfiguration_data.strLabelName1 + ": "
//						+ objBlankFormData.strTextAnswer;

		String strMsg1 = objRegionDefault1
				.getWebNotificationForResourceWith2Quest(
						objUserdata.strFullName1,
						objResource_data.strResourceName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);
		
		Thread.sleep(5000);
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg1)
				.clickAcknowledgeAllForms().switchToDefaultFrame()
				.selectFrame();

		objLinksAtTopRightCorners1.clickOnRefresh();

		Thread.sleep(2000);

		String strApplicationDate3 = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		String[] strDate3 = strApplicationDate3.split(" ");
		String strAcknowledgedDate3 = "";
		int intDate3 = Integer.parseInt(strDate3[0]);
		if (intDate3 == intCurrentDate) {
			strAcknowledgedDate3 = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate3 < intCurrentDate) {
				strAcknowledgedDate3 = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strAcknowledgedDate3 = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}

		String strAcknowledgedTime = strDate3[2] ;
		System.out.println("Acknowledged Time: " + strAcknowledgedTime);

		String strFirstRow = "Form Summary Report for "
				+ objFormConfiguration_data.strFormName + " between "
				+ strStartDate + " " + strDate[3] + " and " + strEndDate + " "
				+ strDate1[3];
		String[] arrForm = { strFirstRow };

		String[] strHeaderNames = ArrayUtils
				.addAll(objReport_data.strFormSummaryReport);

		String[] strAnswers = { objUserdata.strFullName+" ("+objUserdata.strNewUserName+")", strActivationDate,
				strActivationTime, objUserdata.strFullName1+" ("+objUserdata.strNewUserName1+")", "",
				strFilledOutDate, strFilledOutTime,
				objResource_data.strResourceName,objUserdata.strFullName2+" ("+objUserdata.strNewUserName2+")",
				strAcknowledgedDate, strAcknowledgedTime, "", "", "" };
		
		String[] strAnswers2 = { objUserdata.strFullName+" ("+objUserdata.strNewUserName+")", strActivationDate,
				strActivationTime, objUserdata.strFullName1+" ("+objUserdata.strNewUserName1+")", "",
				strFilledOutDate, strFilledOutTime,
				objUserdata.strFullName3+" ("+objUserdata.strNewUserName3+")",objUserdata.strFullName3+" ("+objUserdata.strNewUserName3+")",
				strAcknowledgedDate3, strAcknowledgedTime1, "", "", "" };

		objNavigationToSubmenus1.navigateToFormReport();

		System.out.println("Start Date: " + strStartDate);
		System.out.println("End Date: " + strEndDate);

		objReport1.clickOnFormSummary().verifyFormSummaryReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		int intCount = 0;
		int intCount1 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount1++;
					}

				} while (intCount1 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);
		
		String strValue;

		for (intCount = 1; intCount <= arrForm.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Summary Report", 1,
					intCount, strDownloadName1);
			assertEquals(arrForm[intCount - 1], strValue);
		}

		String[] strValues = strAnswers;

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
			System.out.println("intCount value: " + intCount);
			if (intCount == 3 || intCount == 7 || intCount == 11) {
				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 2, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 3, intCount, strDownloadName1);
				String strTime = strValues[intCount - 1];
				strTime = objDts.converDateFormat(strTime, "HH:mm", "hh:mm");
				String strTime1 = objDts
						.addTimetoExisting(strTime, -1, "hh:mm");
				String strTime2 = objDts.addTimetoExisting(strTime, 1, "hh:mm");
				assertTrue(strValue.contains(strTime)
							|| strValue.contains(strTime1)
							|| strValue.contains(strTime2));
				System.out.println(strHeaderNames[intCount - 1]);
				System.out.println(strValues[intCount - 1]);

			} else if (intCount == 2 || intCount == 6 || intCount == 10) {
				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 2, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 3, intCount, strDownloadName1);
				assertTrue(strValue.contains(strValues[intCount - 1]));
				System.out.println(strHeaderNames[intCount - 1]);
				System.out.println(strValues[intCount - 1]);
			} else {
				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 2, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 3, intCount, strDownloadName1);
				assertEquals(strValues[intCount - 1], strValue);
				System.out.println(strHeaderNames[intCount - 1]);
				System.out.println(strValues[intCount - 1]);
			}
		}
		
		strValues = strAnswers2;
		
		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
			System.out.println("intCount value: " + intCount);
			if (intCount == 3 || intCount == 7 || intCount == 11) {
				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 2, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 4, intCount, strDownloadName1);
				String strTime = strValues[intCount - 1];
				strTime = objDts.converDateFormat(strTime, "HH:mm", "hh:mm");
				String strTime1 = objDts
						.addTimetoExisting(strTime, -1, "hh:mm");
				String strTime2 = objDts.addTimetoExisting(strTime, 1, "hh:mm");
				assertTrue(strValue.contains(strTime)
							|| strValue.contains(strTime1)
							|| strValue.contains(strTime2));
				System.out.println(strHeaderNames[intCount - 1]);
				System.out.println(strValues[intCount - 1]);

			} else if (intCount == 2 || intCount == 6 || intCount == 10) {
				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 2, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 4, intCount, strDownloadName1);
				assertTrue(strValue.contains(strValues[intCount - 1]));
				System.out.println(strHeaderNames[intCount - 1]);
				System.out.println(strValues[intCount - 1]);
			} else {
				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 2, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel(
						"Form Summary Report", 4, intCount, strDownloadName1);
				assertEquals(strValues[intCount - 1], strValue);
				System.out.println(strHeaderNames[intCount - 1]);
				System.out.println(strValues[intCount - 1]);
			}
		}

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that only admin user can generate 'Notification History' report.
	'Precondition:
	'Date	 	 : 26-Aug-2015
	'Author		 : Sangappa.k
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/

	@Test(description ="Verify that only admin user can generate 'Notification History' report.")
	public void testSmoke166435() throws Exception {

		gstrTCID ="166435";
		gstrTO ="Verify that only admin user can generate 'Notification History' report.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(driver1);

		Date_Time_settings objDate_Time_settings = new Date_Time_settings();

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = objDts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.reportFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		// First file variables
		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectReportStatusSummaryOption()
				.selectReportStatusDetailOption()
				.selectReportEventDetailOption()
				.selectReportEventSnapshotOption()
				.selectReportStatusReasonSummaryOption()
				.selectReportStatusReasonDetailOption()
				.selectReportStatusSnapshotOption()
				.selectReporMonthlyStatusAssessment()
				.selecrReportFormReportsRight()
				.selectReporAuditResourceDetail()
				.selectReportStatewideResourceDetail()
				.selectReportIncomingPatientNotificationOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToAdminReports();
		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = objDate_Time_settings.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		String strStartDate = objDate_Time_settings.converDateFormat(
				strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy");

		objReport1.verifyAdminReportPage().clickOnNotificationHistory()
				.verifyNotificationHistoryPage()
				.enterNotificationHistoryStartDate(strStartDate)
				.enterNotificationHistoryEndDate(strStartDate)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		int intCount = 0;
		int intCount1 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strDownloadName1).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount1++;
					}

				} while (intCount1 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);

		assertTrue(new File(strDownloadName1).exists());

		String strValue = objOffCommonFunc.readInfoExcel(
				"Notification History", 1, 1, strDownloadName1);

		String[] strHeaderNames = objReport_data.NotificationHistoryReportHeader;

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {

			strValue = objOffCommonFunc.readInfoExcel("Notification History",
					2, intCount, strDownloadName1);

			System.out.println("Passed Headers  "
					+ strHeaderNames[intCount - 1]);

			System.out.println("Captured headers " + strValue);

			assertEquals(strHeaderNames[intCount - 1], strValue);

		}

		Thread.sleep(5000);
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.verAdminReportsNotExistUnderReports();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	

	/****************************************************************************************************************
	'Description : Verify that RegAdmin can generate IPN report
	'Date	 	 : 7-Sept-2015
	'Author		 : Sangappa.k
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                            	Modified By
	'Date					                                                                Name
	*****************************************************************************************************************/
	@Test(description ="Verify that RegAdmin can generate IPN report")
	public void testSmoke166436() throws Exception {

		gstrTCID ="166436";
		gstrTO ="Verify that RegAdmin can generate IPN report"; 

		Login_data objLogin_data = new Login_data();
		User_data objUserdata = new User_data();
		Report_data objReport_data = new Report_data();
		IncomingPationtNotificationData objIncomingPationtNotificationData = new IncomingPationtNotificationData();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(driver);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
				this.driver1);

		// ie
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Report Report_Page1 = new Report(this.driver1);
		EventManagement EventManagement_Page1 = new EventManagement(
				this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(
				driver1);

		String fileType = objReport_data.reportFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;
		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogin_data.strNewMexicoReg);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.selectFirstRole()
		.selectAssosciateResourceRight(
				objInterfaceInSetUp_data.strNewMexcoResource1)
		.clickAdvancedOptionAndExpand()
		.selectCreateIncomingPatientNotificationsOption()
		.selectReceiveIncomingPatientNotificationsOption()
		.clickSaveButton();
    System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus.navigateToInterfaces();

		objInterfacesInSetUp
				.verifyInterfaceListScreen()
				.verifyCreatedInterfaceTypeInList(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName,
						objInterfaceInSetUp_data.strInterfaceType13)
				.clickOnResourceLinkCorrespondingToInterface(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName)
				.selectResource(objInterfaceInSetUp_data.strNewMexcoResource1)
				.clickOnSave();
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();
		objIncomingPatientNotifications1
				.clickOnCreateNewIPNBtn()
				.selectGenderRdBtn(objIncomingPationtNotificationData.strMale)
				.enterAge(objIncomingPationtNotificationData.strAge)
				.enterCheafComplaint(
						objIncomingPationtNotificationData.strCheafComp)
				.selectTriageCategoryRdBtn(
						objIncomingPationtNotificationData.strRed)
				.selectLevelOfCategoeryRdBtn(
						objIncomingPationtNotificationData.strALS)
				.enterEMSAgency(objIncomingPationtNotificationData.strEmsAgency)
				.enterEMSUnit(objIncomingPationtNotificationData.strEMSUnit)
				.verResourcesUnderTransportDropDown(
						objInterfaceInSetUp_data.strNewMexcoResource1)
				.selectTransportingTo(
						objInterfaceInSetUp_data.strNewMexcoResource1)
				.enterETA(objIncomingPationtNotificationData.strETA);

		objIncomingPatientNotifications1.clickOnSave();
		String strCurrentDate = EventManagement_Page1.getApplicationTime();
		objIncomingPatientNotifications1.verIPNnotification();
		
		String strDateAndMonth[] = strCurrentDate.split(" ");

		String strCurrentYear = dts.timeNow("yyyy");

		strCurrentDate = strDateAndMonth[0] + "/" + strDateAndMonth[1] + "/"
				+ strCurrentYear;

		strCurrentDate = dts.converDateFormat(strCurrentDate, "dd/MMM/yyyy",
				"MM/dd/yyyy");

		strCurrentDate = strCurrentDate.replace(" ", "");

		objRegionDefault1.verWebNotificationframe();

		objRegionDefault1.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();

		String[] iPNTimings = new String[3];

		iPNTimings = objIncomingPatientNotifications1
				.getArrivalAndSentTime(objIncomingPationtNotificationData.strCheafComp);
		
		System.out.println("IPN Time 0" +iPNTimings[0]);
		System.out.println("IPN Time1 1" +iPNTimings[1]);
		System.out.println("IPN Time 2" +iPNTimings[2]);
		System.out.println(objIncomingPationtNotificationData.strCheafComp);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogin_data.strNewMexicoReg);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnResourceReports();

		Report_Page1.clickOnIPNLink();

		Report_Page1.verrifyIncomingPatientNotificationPage()

		.enterReportStartDate(strCurrentDate)

		.enterReportEndDate(strCurrentDate)

		.clickOnGenerateReportBtn();

		Thread.sleep(1000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		int intCount = 0;
		int intCount1 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strDownloadName1).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount1++;
					}

				} while (intCount1 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);

		assertTrue(new File(strDownloadName1).exists());

		Thread.sleep(1000);

		String strValue = "";

		int IPN1 = 0;
		int IPN2 = 0;
		int IPN3 = 0;

		// start date & end date & file name verification

		strCurrentDate = dts.converDateFormat(strCurrentDate, "MM/dd/yyyy",
				"yyyy-MM-dd");
		String strStartDate = strCurrentDate + " 00:00";
		String strEndDate = strCurrentDate + " 23:59";

		String strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 1, 1, strDownloadName1);
		assertEquals(objReport_data.strIPNHeader, strValue1);

		strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 2, 1, strDownloadName1);
		assertEquals(objReport_data.strStartDate1, strValue1);

		strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 3, 1, strDownloadName1);
		assertEquals(objReport_data.strEndDate1, strValue1);

		strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 2, 2, strDownloadName1);
		assertEquals(strStartDate, strValue1);

		strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 3, 2, strDownloadName1);
		assertEquals(strEndDate, strValue1);

		// headers verification

		for (intCount = 1; intCount <= objReport_data.IncomingPatientHeaders.length; intCount++) {
			strValue1 = objOffCommonFunc.readInfoExcel(
					objReport_data.strIPNSheetName, 4, intCount,
					strDownloadName1);
			assertEquals(objReport_data.IncomingPatientHeaders[intCount - 1],
					strValue1);

			IPN1++;
		}

		String[] strContent = { "ETA",
				objInterfaceInSetUp_data.strNewMexcoResource1,
				objIncomingPationtNotificationData.strAge + " " + "Years",
				"Male", objIncomingPationtNotificationData.strCheafComp, "Red",
				objUserdata.strNewUserName,
				objIncomingPationtNotificationData.strEmsAgency,
				objIncomingPationtNotificationData.strEMSUnit,
				objIncomingPationtNotificationData.strALS, "Recived",
				objUserdata.strNewUserName, "Acknoledgment" };

		// IPN content verification

		int MainCount;
		int userNameCount = 0;

		int rowCount = objOffCommonFunc.getRowsCountOfExceSheet(
				strDownloadName1, "Incoming Patient Notifications");

		for (MainCount = 1; MainCount <= rowCount; MainCount++) {

			strValue = objOffCommonFunc.readInfoExcel(
					"Incoming Patient Notifications", MainCount, 12,
					strDownloadName1);

			if (strValue.equals(objUserdata.strNewUserName)) {
				System.out.println(strValue);

				for (intCount = 1; intCount <= objReport_data.IncomingPatientHeaders.length; intCount++) {

					if (intCount == 1 || intCount == 11 || intCount == 13) {

						strValue = objOffCommonFunc.readInfoExcel(
								"Incoming Patient Notifications", MainCount,
								intCount, strDownloadName1);

						System.out.println("Captured" + strValue);

						assertTrue(strValue.equals(iPNTimings[0])
								|| strValue.equals(iPNTimings[1])
								|| strValue.equals(iPNTimings[2]));

						IPN2++;
					} else {
						strValue = objOffCommonFunc.readInfoExcel(
								"Incoming Patient Notifications", MainCount,
								intCount, strDownloadName1);
						System.out.println("Captured" + strValue);

						assertEquals(strContent[intCount - 1], strValue);

						IPN3++;
					}

				}

			}
		}

		assertTrue(IPN1 == objReport_data.IncomingPatientHeaders.length
				&& IPN2 == 3 && IPN3 == 10 && userNameCount <= 1,
				"user name repeated for more then one time in IPN report");
		Thread.sleep(5000);
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		Thread.sleep(1000);
		objLogin1.clickLogOut();
		gstrResult = "PASS";

	}

	/****************************************************************************************************************
	'Description :  Verify that user can generate IPN report
	'Date	 	 : 1-Sept-2015
	'Author		 : Sangappa.k
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                            	Modified By
	'Date					                                                                Name
	*****************************************************************************************************************/

	@Test(description ="Verify that user can generate IPN report")

	public void testSmoke166853() throws Exception {

		gstrTCID ="166853";
		gstrTO ="Verify that user can generate IPN report"; 

		Login_data objLogin_data = new Login_data();
		User_data objUserdata = new User_data();
		Report_data objReport_data = new Report_data();
		IncomingPationtNotificationData objIncomingPationtNotificationData = new IncomingPationtNotificationData();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(driver);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
				this.driver1);

		// ie
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(
				driver1);

		Report Report_Page1 = new Report(this.driver1);
		EventManagement EventManagement_Page1 = new EventManagement(
				this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		String fileType = objReport_data.reportFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;
		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogin_data.strNewMexicoReg);

		objRegionDefault.selectFrame();
	

		objNavigationToSubmenus.navigateToInterfaces();
		
		objInterfacesInSetUp
				.verifyInterfaceListScreen()
				.verifyCreatedInterfaceTypeInList(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName,
						objInterfaceInSetUp_data.strInterfaceType13)

				.clickOnResourceLinkCorrespondingToInterface(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName)
				.selectResource(objInterfaceInSetUp_data.strNewMexcoResource1)
				.clickOnSave();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectAssosciateResourceRight(
						objInterfaceInSetUp_data.strNewMexcoResource1)
				.clickAdvancedOptionAndExpand()
				.selectCreateIncomingPatientNotificationsOption()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectAssosciateResourceRight(
						objInterfaceInSetUp_data.strNewMexcoResource1)
				.selectRunReportRight(
						objInterfaceInSetUp_data.strNewMexcoResource1)
				.clickAdvancedOptionAndExpand()
				.selectReportIncomingPatientNotificationOption()
				.selectReceiveIncomingPatientNotificationsOption()
				.clickSaveButton();
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToSendIncomingPatientNotifications();
		objIncomingPatientNotifications1
				.verManualIPNEntrySceen()
				.selectGenderRdBtn(objIncomingPationtNotificationData.strMale)
				.enterAge(objIncomingPationtNotificationData.strAge)
				.enterCheafComplaint(
						objIncomingPationtNotificationData.strCheafComp)
				.selectTriageCategoryRdBtn(
						objIncomingPationtNotificationData.strRed)
				.selectLevelOfCategoeryRdBtn(
						objIncomingPationtNotificationData.strALS)
				.enterEMSAgency(objIncomingPationtNotificationData.strEmsAgency)
				.enterEMSUnit(objIncomingPationtNotificationData.strEMSUnit)
				.verResourcesUnderTransportDropDown(
						objInterfaceInSetUp_data.strNewMexcoResource1)
				.selectTransportingTo(
						objInterfaceInSetUp_data.strNewMexcoResource1)
				.enterETA(objIncomingPationtNotificationData.strETA);
			
		objIncomingPatientNotifications1
				.clickOnSave().verIPNnotification();
	
		String strCurrentDate = EventManagement_Page1.getApplicationTime();

		String strDateAndMonth[] = strCurrentDate.split(" ");

		String strCurrentYear = dts.timeNow("yyyy");

		strCurrentDate = strDateAndMonth[0] + "/" + strDateAndMonth[1] + "/"
				+ strCurrentYear;

		strCurrentDate = dts.converDateFormat(strCurrentDate, "dd/MMM/yyyy",
				"MM/dd/yyyy");

		strCurrentDate = strCurrentDate.replace(" ", "");

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verWebNotificationframe();

		objRegionDefault1.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame().selectFrame();
		
		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();

		String[] iPNTimings = new String[3];

		iPNTimings = objIncomingPatientNotifications1
				.getArrivalAndSentTime(objIncomingPationtNotificationData.strCheafComp);

		objNavigationToSubmenus1.clickOnResourceReports();

		Report_Page1.clickOnIPNLink();

		Report_Page1.verrifyIncomingPatientNotificationPage()
		
		.enterReportStartDate(strCurrentDate)

		.enterReportEndDate(strCurrentDate)

		.clickOnGenerateReportBtn();

		Thread.sleep(1000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		int intCount = 0;
		int intCount1 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strDownloadName1).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount1++;
					}

				} while (intCount1 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);

		assertTrue(new File(strDownloadName1).exists());

		Thread.sleep(1000);

		String strValue = "";

		int IPN1 = 0;
		int IPN2 = 0;
		int IPN3 = 0;

		// start date & end date & file name verification

		strCurrentDate = dts.converDateFormat(strCurrentDate, "MM/dd/yyyy",
				"yyyy-MM-dd");
		String strStartDate = strCurrentDate + " 00:00";
		String strEndDate = strCurrentDate + " 23:59";

		String strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 1, 1, strDownloadName1);
		assertEquals(objReport_data.strIPNHeader, strValue1);

		strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 2, 1, strDownloadName1);
		assertEquals(objReport_data.strStartDate1, strValue1);

		strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 3, 1, strDownloadName1);
		assertEquals(objReport_data.strEndDate1, strValue1);

		strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 2, 2, strDownloadName1);
		assertEquals(strStartDate, strValue1);

		strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 3, 2, strDownloadName1);
		assertEquals(strEndDate, strValue1);

		// headers verification

		for (intCount = 1; intCount <= objReport_data.IncomingPatientHeaders.length; intCount++) {
			strValue1 = objOffCommonFunc.readInfoExcel(
					objReport_data.strIPNSheetName, 4, intCount,
					strDownloadName1);
			assertEquals(objReport_data.IncomingPatientHeaders[intCount - 1],
					strValue1);

			IPN1++;
		}

		String[] strContent = {"ETA",
				objInterfaceInSetUp_data.strNewMexcoResource1,
				objIncomingPationtNotificationData.strAge + " " + "Years",
				"Male", objIncomingPationtNotificationData.strCheafComp, "Red",
				objUserdata.strNewUserName1,
				objIncomingPationtNotificationData.strEmsAgency,
				objIncomingPationtNotificationData.strEMSUnit,
				objIncomingPationtNotificationData.strALS, "Recived",
				objUserdata.strNewUserName2, "Acknoledgment"};

		// IPN content verification

		int MainCount;

		int userNameCount = 0;

		int rowCount = objOffCommonFunc.getRowsCountOfExceSheet(
				strDownloadName1, "Incoming Patient Notifications");

		for (MainCount = 1; MainCount <= rowCount; MainCount++) {

			strValue = objOffCommonFunc.readInfoExcel(
					"Incoming Patient Notifications", MainCount, 12,
					strDownloadName1);

			if (strValue.equals(objUserdata.strNewUserName2)) {
				System.out.println(strValue);

				userNameCount++;

				for (intCount = 1; intCount <= objReport_data.IncomingPatientHeaders.length; intCount++) {

					if (intCount == 1 || intCount == 11 || intCount == 13) {

						strValue = objOffCommonFunc.readInfoExcel(
								"Incoming Patient Notifications", MainCount,
								intCount, strDownloadName1);

						System.out.println("Captured" + strValue);

						assertTrue(strValue.equals(iPNTimings[0])
								|| strValue.equals(iPNTimings[1])
								|| strValue.equals(iPNTimings[2]));

						IPN2++;
					} else {
						strValue = objOffCommonFunc.readInfoExcel(
								"Incoming Patient Notifications", MainCount,
								intCount, strDownloadName1);
						System.out.println("Captured" + strValue);

						assertEquals(strContent[intCount - 1], strValue);

						IPN3++;
					}

				}

			}

		}

		assertTrue(IPN1 == objReport_data.IncomingPatientHeaders.length
				&& IPN2 == 3 && IPN3 == 10 && userNameCount <= 1,
				"user name repeated for more then one time in IPN report");
		Thread.sleep(5000);
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		Thread.sleep(1000);
		objLogin1.clickLogOut();
		gstrResult = "PASS";

	}

}