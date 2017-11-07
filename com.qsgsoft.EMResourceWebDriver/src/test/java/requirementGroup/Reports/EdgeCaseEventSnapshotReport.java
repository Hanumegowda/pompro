package requirementGroup.Reports;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.*;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

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

public class EdgeCaseEventSnapshotReport  extends TestNG_UI_EXTENSIONS {
	
	public EdgeCaseEventSnapshotReport() throws Exception {
		super();
	}

	/****************************************************************************************************************
	'Description : Verify that ‘Event Snapshot’ report does not display summary section for saturation score and NEDOC calculation status types.
	'Precondition:
	'Date	 	 : 28-Apr-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Verify that ‘Event Snapshot’ report does not display summary section for saturation score and NEDOC calculation status types.")
	public void testEdgeCase136431() throws Exception {

		gstrTCID = "136431";
		gstrTO = "Verify that ‘Event Snapshot’ report does not display summary section for saturation score and NEDOC calculation status types.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Roles_data objRoles_data = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
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

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

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
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectReportEventSnapshotOption()
				.selectViewResourceRights(objResource_data.strResourceName)
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
		
		// create Event
		objEventManagement1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton();

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
				objStatuTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
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
				strCurrentDate, objStatuTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForUpdate, " ",
				strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName };

		objReport1.verifDataInHTMLEventSnapshotReport(strData);

		objReport1.verifSummaryTable(objStatuTypes_data.strNSTStatusTypeName, objView_data.strValueForUpdate);

		objReport1.verifSTNotAvlInSummaryTable(
				objStatuTypes_data.strSSTStatusTypeName)
				.verifSTNotAvlInSummaryTable(
						objStatuTypes_data.strNDSTStatusTypeName);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToEventReports();

		objReport1.clickOnEventSnapshot().enterStartDate(strCurrentDate)
				.enterEndDate(strCurrentDate);

		objReport1.selectEventTemplate(strEveTemplateValue[0]);

		objReport1.selectExcelReportRadioBtn();

		objReport1.clickOnNextBtn()
				.selectEventRadioBtn(objEvent_data.strEventName)
				.enterSnapshotDate(strCurrentDate)
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

		String[] strUpdatedExcelValues = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objView_data.strDateUpdateValue,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strValueForTST,
				"", strTime + " " + strHour + ":" + strUpdatedTime[1],
				objUser_data.strFullName };

		/*summary part need to verify*/
		/*String[] strSummaryValue = { objTest_data.strSummary,
				objView_data.strZeroValue, objView_data.strZeroValue,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strZeroValue,
				"", "", "" };*/

		strValue = objOffCommonFunc.readInfoExcel(
				"Event Snapshot", 1, 1,
				strDownloadName1);
		assertEquals("Event Snapshot for " + objEvent_data.strEventName + " - "
				+ strCurrentDate + " " + strHourFrExcel + ":" + strMinute1
				+ " Central Standard Time. Event Start: "
				+ strEventStartDateAndTime + ". Event End: " + strEventEndTime
				+ ". ", strValue);

		for (intCount = 1; intCount <= strUpdatedStatusTypeNames.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 2,
					intCount, strDownloadName1);
			assertEquals(strUpdatedStatusTypeNames[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 3,
					intCount, strDownloadName1);
			assertEquals(strUpdatedExcelValues[intCount - 1], strValue);
			/*summary part need to verify*/
			/*strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 4,
					intCount, strDownloadName1);
			assertEquals(strSummaryValue[intCount - 1], strValue);*/

		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/****************************************************************************************************************
	'Description : Verify that future events will not be listed on 'Event Snapshot report' (2 of 2) screen.
	'Precondition:
	'Date	 	 : 30-Apr-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Verify that future events will not be listed on 'Event Snapshot report' (2 of 2) screen.")
	public void testEdgeCase142348() throws Exception {

		gstrTCID = "142348";
		gstrTO = "Verify that future events will not be listed on 'Event Snapshot report' (2 of 2) screen.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Roles_data objRoles_data = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		Date_Time_settings dts = new Date_Time_settings();

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
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Report objReport1 = new Report(this.driver1);
		
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

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

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
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectReportEventSnapshotOption()
				.selectViewResourceRights(objResource_data.strResourceName)
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
		
		// create Event
		objEventManagement1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName1)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton();

		// create Event
		objEventManagement1.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue);
		
		String strEventStartTime = objEventManagement1
				.getEventStartDateAndTime();
		
		objEvent_data.strEventStartTime = dts.converDateFormat(
				strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");
		
		objEvent_data.strGetEventStartTime = dts
				.AddTimeToExistingTimeHourAndMin(
						objEvent_data.strEventStartTime, 1, 2,
						"yyyy-MM-dd HH:mm");
		
		String strEventStartTimeTime = dts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm",
				"yyyy MMM dd HH mm");
		
		String strStartTime[] = strEventStartTimeTime.split(" ");
		
		objEventManagement1.selectEventStartDateAndTime(strStartTime);
		
		String strGetEventEndTime = dts.AddTimeToExistingTimeHourAndMin(
				objEvent_data.strEventStartTime, 1, 10, "yyyy-MM-dd HH:mm");
		
		String strUpdatedEventEndTime = dts.converDateFormat(
				strGetEventEndTime, "yyyy-MM-dd HH:mm", "yyyy MMM dd HH mm");
		
		String strEndTime[] = strUpdatedEventEndTime.split(" ");
		
		objEventManagement1.selectEventEndDateAndTime(strEndTime);
		
		objEventManagement1.clickOnSaveButton();
		
		String strEventStartDateAndTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);
		String strEventEndTime = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);
		
		strEventStartDateAndTime = dts.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH:mm",
				"dd MMM yyyy HH:mm");
		
		strEventEndTime = dts.converDateFormat(strEventEndTime,
				"yyyy-MM-dd HH:mm", "dd MMM yyyy HH:mm");

		String strCurrentDate1 = dts.getCurrentDate("MM/dd/yyyy HH:mm");

		String strStartTime2[] = strCurrentDate1.split(" ");

		String strCurrentDate = strStartTime2[0];

		objNavigationToSubMenus1.navigateToEventReports();

		objReport1.clickOnEventSnapshot().verifyEventSnapshotReport1stPage()
				.verifySearchStartDate().verifySearchEndDate()
				.enterStartDate(strCurrentDate).enterEndDate(strCurrentDate);

		objReport1.selectEventTemplate(strEveTemplateValue[0]);

		objReport1.clickOnNextBtn().verEventIsNotDisplayed(
				objEvent_data.strEventName)
				.verEventIsDisplayed(objEvent_data.strEventName1);

		objNavigationToSubMenus1.navigateToEventReports();

		objReport1.clickOnEventSnapshot().enterStartDate(strCurrentDate)
				.enterEndDate(strCurrentDate);

		objReport1.selectEventTemplate(strEveTemplateValue[0]);

		objReport1.selectExcelReportRadioBtn();

		objReport1.clickOnNextBtn().verEventIsNotDisplayed(
				objEvent_data.strEventName).verEventIsDisplayed(objEvent_data.strEventName1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/****************************************************************************************************************
	'Description : Verify that never ending events are listed on 'Event Snapshot report' (2 of 2) screen.
	'Date	 	 : 30-Apr-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Verify that never ending events are listed on 'Event Snapshot report' (2 of 2) screen.")
	public void testEdgeCase142347() throws Exception {

		gstrTCID = "142347";
		gstrTO = "Verify that never ending events are listed on 'Event Snapshot report' (2 of 2) screen.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Roles_data objRoles_data = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
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

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

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
		objResource.navigateToResourceListPage()
				   .createResourceWithAddress(objResource_data.strResourceName,
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
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectReportEventSnapshotOption()
				.selectViewResourceRights(objResource_data.strResourceName)
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
		
		// create Event
		objEventManagement1.navigateToEventManagement()
						  .clickOnCreateNewEvent()
						  .clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
						  .enterAdHocEventName(objEvent_data.strEventName)
						  .enterAdHocEventDescription(objEvent_data.strEventDescription)
						  .clickEventNeverEndRadioButton()
						  .selectResource(strResourceValue)
						  .clickOnSaveButton()
						  .verifyEventName(objEvent_data.strEventName);

		String strEventStartDateAndTime = objEventManagement1.getEventStartTime(objEvent_data.strEventName);
		String strEventEndTime = objEventManagement1.getEventEndTime(objEvent_data.strEventName);

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
				objStatuTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
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
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForTST)
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

		String oneMinuteAdded1 = dts
				.addTimetoExisting(strStartTi[2], 1, "H:mm");
		String oneMinuteAdded = dts
				.addTimetoExisting(strStartTi[2], 1, "HH:mm");

		String strStartTim1[] = oneMinuteAdded.split(":");
		String strStartTim2[] = oneMinuteAdded1.split(":");
		String strHour1 = strStartTim1[0];
		String strHourFrExcel = strStartTim2[0];
		String strMinute1 = strStartTim1[1];

		String strCurrentDate = dts.getCurrentDate("dd");
		String strCurrentDate1 = "";
		int intDate = Integer.parseInt(strDate);
		int intCurrentDate = Integer.parseInt(strCurrentDate);

		if (intDate == intCurrentDate) {
			strCurrentDate1 = dts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate < intCurrentDate) {
				strCurrentDate1 = dts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strCurrentDate1 = dts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		
		String strYear[] = strCurrentDate1.split("/");

		String strYear1 = strYear[2];

		String strTime = strDate + " " + strMonth + " " + strYear1;

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], objView_data.strValueForTST);

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

		objReport1.clickOnEventSnapshot()
				  .verifyEventSnapshotReport1stPage()
				  .verifySearchStartDate()
				  .verifySearchEndDate()
				  .enterStartDate(strCurrentDate1)
				  .enterEndDate(strCurrentDate1);

		objReport1.selectEventTemplate(strEveTemplateValue[0]);

		objReport1.clickOnNextBtn()
				.selectEventRadioBtn(objEvent_data.strEventName)
				.verifySnapshotDateAndTimeShouldFallBetweenOption()
				.verifySnapshotDateOption().verifySnapshotTimeHourOption()
				.verifySnapshotTimeMinutesOption()
				.enterSnapshotDate(strCurrentDate1)
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
				strCurrentDate1, objStatuTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForTST, " ",
				strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName };

		objReport1.verifDataInHTMLEventSnapshotReport(strData);

		objReport1.verifSummaryTable(objStatuTypes_data.strNSTStatusTypeName,objView_data.strValueForUpdate);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame();
		
		objNavigationToSubMenus1.navigateToEventReports();

		objReport1.clickOnEventSnapshot()
				  .enterStartDate(strCurrentDate1)
				  .enterEndDate(strCurrentDate1)
				  .selectExcelReportRadioBtn()
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
				objView_data.strUpdatedValForSST, objView_data.strValueForTST,
				"", strUpdateTime1,
				objUser_data.strFullName };

		/*summary part need to verify*/
		String[] strSummaryValue = { objTest_data.strSummary,
				"", "",
				"", objView_data.strValueForUpdate,
				"", "",
				"", "", "" };

		strValue = objOffCommonFunc.readInfoExcel(
				"Event Snapshot", 1, 1,
				strDownloadName1);
		assertEquals("Event Snapshot for " + objEvent_data.strEventName + " - "
				+ strCurrentDate1 + " " + strHourFrExcel + ":" + strMinute1
				+ " Central Standard Time. Event Start: "
				+ strEventStartDateAndTime + ". Event End: " + objEvent_data.endDateForNeverEndEvent, strValue);

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

			/*summary part need to verify- refer bug id EMS-5027*/
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 4,
					intCount, strDownloadName1);
			assertEquals(strSummaryValue[intCount - 1], strValue);
		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
