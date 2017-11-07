package requirementGroup.SmokeTestSuite;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.EventManagement;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class SmokeViews extends TestNG_UI_EXTENSIONS {

	public SmokeViews() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*******************************************************************************************
	'Description : Verify that user will be redirected to View resource detail when clicked on the link from WebEOC application
	'Precondition:
	'Date	 	 : 25-Sep-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user will be redirected to View resource detail when clicked on the link from WebEOC application")
	public void testSmoke137576() throws Exception {
		gstrTCID = "137576";
		gstrTO = "Verify that user will be redirected to View resource detail when clicked on the link from WebEOC application";

		Login_data objTest_data = new Login_data();
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		User_data objUser_data = new User_data();
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		Views objViews1 = new Views(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName5);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strColoradoResource2)
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUserToWebeoc(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		objViews1.verViewResourceDetailsPgeIsDisplayed();

		String[] strResource = objResource_data.strColoradoResource2.split("  ");
		
		String strResNameInViewDetailScreen = strResource[0]+" "+strResource[1];
		
		objViews1
				.verResourceScreenDisplayed(strResNameInViewDetailScreen);

		objViews1.verStatusTypes(objResource_data.strStatusTypesOfLutheran);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that user can generate snapshot of ‘Region-View’ providing past time in 'excel' format. 
	 * 'Date        : 20-Nov-2014 
	 * 'Author      : Renushree
	 ***************************************************************************************************************/
	@Test(description = "Verify that user can generate snapshot of ‘Region-View’ providing past time in 'excel' format. ")
	public void testSmoke148819() throws Exception {
		gstrTCID = "148819";
		gstrTO = "Verify that user can generate snapshot of ‘Region-View’ providing past time in 'excel' format. ";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
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

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		String filePath = file + "\\";
		String strApplicationTime = "";
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		objViewsList.getRegionNameFromHeader();
		
		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strstatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strstatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objnNavigationToSubMenus.navigateToResourceInSetup();

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

		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectReportStatusSnapshotOption()

				.clickSaveButton();

		objnNavigationToSubMenus.navigateToViews();

		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypeNames);
		
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(5000);

		objnNavigationToSubMenus1.clickOnViewMenu();

		Thread.sleep(2000);
		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		Thread.sleep(2000);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.clickOnSelectAll();

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
				objView_data.strValueForUpdate);

		UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1],
				objView_data.strValueForNDST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
				objView_data.strValueForTST);

		UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3],
				strstatusesValues[0]);

		UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4],
				objView_data.strValueForSST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
				objView_data.strDateUpdateValue);

		UpdateStatus_page1.clickOnSaveButton();
		
		strApplicationTime = objEventManagement1.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strTime[0]+" "+strTime[1]+" "+strTime[2] + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(
				strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");
		
		Thread.sleep(180000);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.clickOnSelectAll();

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
				objView_data.strValueForUpdate1);

		UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1],
				objView_data.strValueForNDST1);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
				objView_data.strValueForTST1);

		UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3],
				strstatusesValues[1]);

		UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4],
				objView_data.strValueForSST1);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
				objView_data.strDateUpdateFutureValue);

		UpdateStatus_page1.clickOnSaveButton();

		Thread.sleep(5000);

		RegionDefault_page1.clickExcelOption();

		String strDate = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "mm");
		
		 String strDateInExcel = objDts.converDateFormat(strDate,
					"MM/dd/yyyy", "yyyy-MM-dd");

		 Thread.sleep(2000);
		 
		RegionDefault_page1.selectAndEnterDateAndTime(strDate, strHour,
				strMinutes);

		Thread.sleep(2000);

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
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName1);
		assertEquals("" + strDateInExcel + " " + strHour + ":"+strMinutes + " "
				+ objView_data.strViewName + " View Snapshot", strValue);
		
		String[] strHeaderNames = {objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		String[] strUpdatedValues = { objResource_data.strResourceName, objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST };

		for (intCount = 1; intCount <= (strHeaderNames.length) ; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName1);
			assertEquals(strHeaderNames[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName1);
			assertEquals(strUpdatedValues[intCount - 1], strValue);
		}
		gstrResult = "PASS";
	}
	

	
	/***************************************************************************************************************
	 * 'Description :Verify that user without ‘Report-Event Snapshot’ cannot generate 'excel' snapshot of event status screen. 
	 * 'Date        : 20-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = "Verify that user without ‘Report-Event Snapshot’ cannot generate 'excel' snapshot of event status screen. ")
	public void testSmoke148820() throws Exception {
		gstrTCID = "148820";
		gstrTO = " 	Verify that user without ‘Report-Event Snapshot’ cannot generate 'excel' snapshot of event status screen. ";

		// Objects for data
		Login_data objTest_data = new Login_data();
		Event_data objEvent_data = new Event_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();


		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()
				.selectMaintainAdHocEventsOption()
				.selectReportStatusSnapshotOption()

				.clickSaveButton();
			System.out.println(objUserdata.strNewUserName);
			

			objLogin.clickLogOut();
			
			objLogin1.loginAsNewUser(objUserdata.strNewUserName,
					objUserdata.strNewPassword);
			
			objRegionDefault1.selectFrame();
			
		objEventManagement1.navigateToEventManagement()
				.clickOnCreateAdHocEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnNextButton()
				.clickOnNextButton();

		objEventManagement1.clickOnNextButton().clickOnYesButton()

		.verifyEventName(objEvent_data.strEventName);
//
//
//		Thread.sleep(5000);
//		
//		objRegionDefault1.verifyRegionDefaultPage();
		
		objEventManagement1.verifyEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verifyEventStatus();
	
		RegionDefault_page1.clickPrintOption();
		
		RegionDefault_page1.verSnapshotWindowNotDisplayed();
		
		objRegionDefault1.selectFrame();
		
		RegionDefault_page1.clickExcelOption();

		RegionDefault_page1.verSnapshotWindowNotDisplayed();
			
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that user can generate snapshot of ‘Region-View’ providing past time
	 * 'Date        : 03-Mar-2015
	 * 'Author      : Renushree
	 ***************************************************************************************************************/

	@Test(description = "Verify that user can generate snapshot of ‘Region-View’ providing past time")
	public void testSmoke148817() throws Exception {
		gstrTCID = "148817";
		gstrTO = "Verify that user can generate snapshot of ‘Region-View’ providing past time";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

		UsersList UsersList_page = new UsersList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Report objReport1 = new Report(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		String strApplicationTime = "";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strstatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strstatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objnNavigationToSubMenus.navigateToResourceInSetup();

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

		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectReportStatusSnapshotOption()

				.clickSaveButton();

		objnNavigationToSubMenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);

		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
				objResource_data.strResourceName, strStatusTypeNames);

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(5000);

		objnNavigationToSubMenus1.clickOnViewMenu();

		Thread.sleep(2000);
		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		Thread.sleep(2000);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.clickOnSelectAll();

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
				objView_data.strValueForUpdate);

		UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1],
				objView_data.strValueForNDST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
				objView_data.strValueForTST);

		UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3],
				strstatusesValues[0]);

		UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4],
				objView_data.strValueForSST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
				objView_data.strDateUpdateValue);

		UpdateStatus_page1.clickOnSaveButton();
		
		strApplicationTime = objEventManagement1.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strTime[0]+" "+strTime[1]+" "+strTime[2] + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		
		strApplicationTime = objDts.AddTimeToExistingTimeHourAndMin(
				strApplicationTime, 0, 1, "MM/dd/yyyy HH:mm");
		
		String strApplicationTime1 = objDts.converDateFormat(strApplicationTime, "MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");

		Thread.sleep(180000);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		UpdateStatus_page1.clickOnSelectAll();

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
				objView_data.strValueForUpdate1);

		UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1],
				objView_data.strValueForNDST1);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
				objView_data.strValueForTST1);

		UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3],
				strstatusesValues[1]);

		UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4],
				objView_data.strValueForSST1);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
				objView_data.strDateUpdateFutureValue);

		UpdateStatus_page1.clickOnSaveButton();

		Thread.sleep(5000);

		objRegionDefault1.clickPrintOption();

		String strDate = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "MM/dd/yyyy");
		String strHour = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "HH");
		String strMinutes = objDts.converDateFormat(strApplicationTime,
				"MM/dd/yyyy HH:mm", "mm");
		objRegionDefault1.selectAndEnterDateAndTime(strDate, strHour,
				strMinutes);

		Thread.sleep(2000);

		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		String[] strHeaderNames = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment" };

		String[] strUpdatedValues = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCValue, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST,
				"" };

		objReport1.verifyViewNameInRegionViewHtmlReport(
				objView_data.strViewName, strApplicationTime1)
				.verHTMLFormHeadersAndAnswersInRegionViewRep(strHeaderNames,
						strUpdatedValues);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that user can generate snapshot of ‘Region Default view’ with current date and time. 
	 * 'Date        : 2-Mar-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/
	@Test(description = "Verify that user can generate snapshot of ‘Region Default view’ with current date and time.")
	public void testSmoke148818() throws Exception {
		gstrTCID = "148818";
		gstrTO = "Verify that user can generate snapshot of ‘Region Default view’ with current date and time.";

		// Objects for data
		Login_data objTest_data = new Login_data();

		UsersList objUsersList_page = new UsersList(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strTimeText = objDate_Time_settings.getCurrentDate(objReport_data.dateFormat1);
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

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Views objViews1 = new Views(this.driver1);

		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		String filePath = file + "\\";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

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

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

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

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource_Page.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objUsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectReportStatusSnapshotOption()

				.clickSaveButton();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.clickOnEditOfRegDefault();

		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.clickNextButton()
		.selectRegionName(objTest_data.strRegionName)
		.clickOnResourcesTab()
					.selectResource(objResource_data.strResourceName)
					.clickNextButton();
		for (int i = 0; i < strStatusTypeNames.length; i++) {	
			objViewsList.selectStatusType(strStatusTypeNames[i]);
		}
		
		objViewsList.clickOnSaveOfCreateNewView();
		
		objLogin.clickLogOut();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
	
		objUpdateStatus.clickOnSelectAll();
		
		objUpdateStatus.selectMSTUpdateValue(strStatusTypeValues[1],
				strStatusesValues[0]);
		
		objUpdateStatus.enterNedocsUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForNDST);
		
		objUpdateStatus.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
				objView_data.strValueForUpdate);

		objUpdateStatus.enterUpdateSSTValues(strStatusTypeValues[4],
				objView_data.strValueForSST);

		objUpdateStatus.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strValueForTST);
		
		objUpdateStatus.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strDateUpdateValue)
				.clickOnSaveButton();

		Thread.sleep(120000);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
		
		objUpdateStatus.clickOnSelectAll();

		objUpdateStatus.selectMSTUpdateValue(strStatusTypeValues[1],
				strStatusesValues[1]);
		
		objUpdateStatus.enterNedocsUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForNDST1);
		
		objUpdateStatus.enterNSTAndTSTUpdateValue(strStatusTypeValues[3],
				objView_data.strValueForUpdate1);

		objUpdateStatus.enterUpdateSSTValues(strStatusTypeValues[4],
				objView_data.strValueForSST1);

		objUpdateStatus.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strValueForTST1);
		
		objUpdateStatus.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strDateUpdateFutureValue)
				.clickOnSaveButton();


		String strUpdateTime = objEventManagement1.getApplicationTime();
		System.out.println(strUpdateTime);
		
		String strUpdateTime2 = objEventManagement1.getApplicationTime();
		System.out.println(strUpdateTime2);
		String strCurrentDate = objDate_Time_settings.getCurrentDate("yyyy-MM-dd");
		String[] strDateTime = strUpdateTime.split(" ");
		String[] strHourAndMin = strDateTime[2].split(":");
		String strMinute = objDate_Time_settings.addTimetoExisting(strHourAndMin[1], 1, "mm");

		Thread.sleep(2000);
		objRegionDefault_page1.clickExcelOption();
		Thread.sleep(2000);

		objRegionDefault_page1.clickOnGenerateReportOption();

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
				objResourceType_data.strResourceTypeName, 1, 1,
				strDownloadName1);
		assertTrue(("" + strCurrentDate + " " + strHourAndMin[0]+":"
				+ strMinute + " Region Default View Snapshot").equals(strValue)||("" + strCurrentDate + " " + strHourAndMin[0]+":"
						+ strHourAndMin[1] + " Region Default View Snapshot").equals(strValue));

		String[] strHeaderNames = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,"Comment" };

		String[] strUpdatedValues = { objResource_data.strResourceName,
				objView_data.strDateUpdateFutureValue,
				objStatusTypes_data.strStatusNameInMulti1,
				objView_data.strNEDOCValue1, objView_data.strValueForUpdate1, objView_data.strUpdatedValForSST1,
				objView_data.strValueForTST1,"" };

		String[] strUpdatedValues1 = { objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCValue, objView_data.strValueForUpdate, objView_data.strUpdatedValForSST,
				objView_data.strValueForTST,"" };
		
		for (intCount = 1; intCount <= (strHeaderNames.length); intCount++) {
			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 2, intCount,
					strDownloadName1);
			assertEquals(strHeaderNames[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel(
					objResourceType_data.strResourceTypeName, 3, intCount,
					strDownloadName1);
			assertEquals(strUpdatedValues[intCount - 1], strValue);
			if((strUpdatedValues1[intCount - 1])!=objResource_data.strResourceName){
				if((strUpdatedValues1[intCount - 1])!=""){					
			assertFalse((strUpdatedValues1[intCount - 1]).equals(strValue));
				}
			}
		}
		gstrResult = "PASS";
	}
}
