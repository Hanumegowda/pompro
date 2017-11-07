package requirementGroup.Reports;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;
import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
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
import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEventSnapshotReport extends TestNG_UI_EXTENSIONS {
	
	public NewEventSnapshotReport() throws Exception {
		super();
	}

	/****************************************************************************************************************
	'Description : Update statuses of status types added at the resource level for a resource RS. Verify that a user
	               with ‘Run Report’ & 'View Resource' rights on RS and with a role WITH only view right for these 
	               status types CAN view these status types in the Event Snapshot report.
	'Date	 	 : 09-Jul-2015
	'Author		 : Renushree
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Update statuses of status types added at the resource level for a resource RS. "
			+ "Verify that a user with ‘Run Report’ & 'View Resource' rights on RS and with a role WITH only "
			+ "view right for these status types CAN view these status types in the Event Snapshot report.")
	public void testHappyDay118662() throws Exception {

		gstrTCID = "118662";
		gstrTO = "Update statuses of status types added at the resource level for a resource RS. Verify"
				+ " that a user with ‘Run Report’ & 'View Resource' rights on RS and with a role WITH only"
				+ " view right for these status types CAN view these status types in the Event Snapshot report.";

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
						objStatusTypes_data.strStatusNameInMulti)
						
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

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

		objRoles.clickOnCreateNewRoleBtn()
		.enterRoleName(objRoles_data.strRoleName)
		.clickStatusTypeInRoleMayViewSection(strstatusTypeValues).deselectStatusTypeInRoleMayUpdateSection(strstatusTypeValues)
		.clickOnSaveBtn();

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
				.selectReportEventSnapshotOption()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName1,
				objUser_data.strNewPassword, objUser_data.strFullName1)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.selectMaintainEventsOption()
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
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
		
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();

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
				strCurrentDate, objStatuTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForUpdate, " ",
				strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName1};

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

		objReport1.clickOnEventSnapshot().selectExcelReportRadioBtn().enterStartDate(strCurrentDate)
				.enterEndDate(strCurrentDate);

		objReport1.selectEventTemplate(strEveTemplateValue[0]);

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
				objUser_data.strFullName1};

		/*summary part need to verify*/
		String[] strSummaryValue = { objTest_data.strSummary,
				objView_data.strZeroValue, objView_data.strZeroValue,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strZeroValue,
				"", "", "" };

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
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 4,
					intCount, strDownloadName1);
			assertEquals(strSummaryValue[intCount - 1], strValue);

		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/****************************************************************************************************************
	'Description :  Add a status type ST back to resource RS and update the status value of ST for RS, generate the 
	                ‘Event Snapshot Report’ and verify that the data is displayed appropriately in the report
	'Date	 	 : 09-Jul-2015
	'Author		 : Renushree
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = " Add a status type ST back to resource RS and update the status value of ST for RS,"
			+ " generate the ‘Event Snapshot Report’ and verify that the data is displayed appropriately in the report")
	public void testHappyDay118660() throws Exception {

		gstrTCID = "118660";
		gstrTO = " Add a status type ST back to resource RS and update the status value of ST for RS, generate the"
				+ " ‘Event Snapshot Report’ and verify that the data is displayed appropriately in the report";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Report_data objReport_data = new Report_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		String strstatusTypeValues[] = new String[5];
		String strstatusTypeValues1[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
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
		Resource objResource1 = new Resource(this.driver1);

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
						objStatusTypes_data.strStatusNameInMulti)
				
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

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

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues1);

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
		
		objResource.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName)
		.selectStatusType(strstatusTypeValues)
		.clickOnSaveButton();
		
		String strAllSTValues[] = ArrayUtils.addAll(strstatusTypeValues, strstatusTypeValues1);
		
		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strAllSTValues);

		objEventManagement.clickOnSaveButton();

		strEveTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectReportEventSnapshotOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
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
		
		String[] strOneStatus = {strstatusTypeValues[2]};
		
		objNavigationToSubMenus1.navigateToResourceInSetup();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName)
		.verEditResourceLevelStatusTypesPageisDisplayed()
		.deselectStatusType(strOneStatus)
		.clickOnSaveButton();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName)
		.verEditResourceLevelStatusTypesPageisDisplayed()
		.selectStatusType(strOneStatus)
		.clickOnSaveButton();

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
				.enterNSTAndTSTUpdateValue(strstatusTypeValues1[0],
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

		String strStartTim1[] = oneMinuteAdded.split(":");
		String strStartTim2[] = oneMinuteAdded1.split(":");
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
				strstatusTypeValues1[0], objView_data.strDateUpdateValue);
		
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
				strCurrentDate, objStatuTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForUpdate, " ",
				strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName};

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

		objReport1.clickOnEventSnapshot().selectExcelReportRadioBtn().enterStartDate(strCurrentDate)
				.enterEndDate(strCurrentDate);

		objReport1.selectEventTemplate(strEveTemplateValue[0]);

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
				objView_data.strUpdatedValForSST, objView_data.strValueForUpdate,
				"", strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName};

		/*summary part need to verify*/
		String[] strSummaryValue = { objTest_data.strSummary,
				objView_data.strZeroValue, objView_data.strZeroValue,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strZeroValue,
				"", "", "" };

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
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 4,
					intCount, strDownloadName1);
			assertEquals(strSummaryValue[intCount - 1], strValue);

		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/****************************************************************************************************************
	'Description :  Update statuses of status types added at the resource level for a resource RS. Verify that a user
	 				with ‘Run Report’ & 'View Resource' rights on RS and with a role WITHOUT view/update rights for
	 				 these status types CANNOT view these status types in the Event Snapshot Report.
	'Date	 	 : 13-Jul-2015
	'Author		 : Deepa
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Update statuses of status types added at the resource level for a resource RS. Verify that "
			+ "a user with ‘Run Report’ & 'View Resource' rights on RS and with a role WITHOUT view/update rights"
			+ " for these status types CANNOT view these status types in the Event Snapshot Report.")
	public void testHappyDay118881() throws Exception {

		gstrTCID = "118881";
		gstrTO = "Update statuses of status types added at the resource level for a resource RS. Verify that a user"
				+ " with ‘Run Report’ & 'View Resource' rights on RS and with a role WITHOUT view/update rights "
				+ "for these status types CANNOT view these status types in the Event Snapshot Report.";

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
						objStatusTypes_data.strStatusNameInMulti)
		     
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);


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

		objRoles.clickOnCreateNewRoleBtn()
		.enterRoleName(objRoles_data.strRoleName)
		.deSelStatusTypeInRoleMayViewSection(strstatusTypeValues)
		.deselectStatusTypeInRoleMayUpdateSection(strstatusTypeValues)
		.clickOnSaveBtn();

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
				.selectReportEventSnapshotOption()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName1,
				objUser_data.strNewPassword, objUser_data.strFullName1)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
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

		String strStartTim1[] = oneMinuteAdded.split(":");
		String strStartTim2[] = oneMinuteAdded1.split(":");
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
		
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();

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

		String strHeaderName[] = {
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };
		
		String strHeaderName1[] = {
				objResourceType_data.strResourceTypeName, "Comment",
				"Last Update", "By User"};
		
		objReport1.verifyHeadersInHTMLEventSnapshotReportAreNotDis(strHeaderName);
		
		objReport1.verifyHeadersInHTMLEventSnapshotReport(strHeaderName1);

		String[] strData = new String[] { objResource_data.strResourceName," ",
				strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName1 };

		objReport1.verifDataInHTMLEventSnapshotReport(strData);

		objReport1.verifSTNotAvlInSummaryTable(
				objStatuTypes_data.strNSTStatusTypeName);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

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
				objTest_data.strComment, objTest_data.strLastUpdate,
				objTest_data.strUpdatedBy };
		
		String[] strUpdatedStatusTypeNames1 = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };
		
		String[] strUpdatedExcelValues = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				"", strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName1 };
		
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

		}
		
		for (intCount = 0; intCount < strUpdatedStatusTypeNames1.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 2,
					3, strDownloadName1);
			assertNotEquals(strUpdatedStatusTypeNames1[intCount], strValue);
			/*summary part need to verify*/
			/*strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 4,
					intCount, strDownloadName1);
			assertNotEquals(strSummaryValue[intCount - 1], strValue);*/

		}
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/****************************************************************************************************************
	'Description :  Update statuses of status types added at the resource level for a resource RS. Verify that a user 
					with ‘Run Report’ & 'View Resource' rights on RS and with a role WITHOUT view/update rights for 
					these status types CANNOT view these status types in the Event Snapshot Report. 
	'Date	 	 : 09-Jul-2015
	'Author		 : Deepa
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = " Update statuses of status types added at the resource level for a resource RS. Verify "
			+ "that a user with ‘Run Report’ & 'View Resource' rights on RS and with a role WITHOUT view/update "
			+ "rights for these status types CANNOT view these status types in the Event Snapshot Report. ")
	public void testHappyDay118661() throws Exception {

		gstrTCID = "118661";
		gstrTO = " Update statuses of status types added at the resource level for a resource RS. Verify that a "
				+ "user with ‘Run Report’ & 'View Resource' rights on RS and with a role WITHOUT view/update"
				+ " rights for these status types CANNOT view these status types in the Event Snapshot Report. ";

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
		
		String strstatusTypeValues1[] = new String[1];
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
						objStatusTypes_data.strStatusNameInMulti)
		     
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2);

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
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues1);

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
		
		objResource.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName)
		.selectStatusType(strstatusTypeValues)
		.clickOnSaveButton();
		

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
		.enterRoleName(objRoles_data.strRoleName)
		.deSelStatusTypeInRoleMayViewSection(strstatusTypeValues)
		.deselectStatusTypeInRoleMayUpdateSection(strstatusTypeValues)
		.clickOnSaveBtn();

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
				.selectReportEventSnapshotOption()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName1,
				objUser_data.strNewPassword, objUser_data.strFullName1)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
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

		String strStartTim1[] = oneMinuteAdded.split(":");
		String strStartTim2[] = oneMinuteAdded1.split(":");
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
		
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();

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

		String strHeaderName[] = {
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };
		
		String strHeaderName1[] = {
				objResourceType_data.strResourceTypeName, "Comment",
				"Last Update", "By User"};
		
		objReport1.verifyHeadersInHTMLEventSnapshotReportAreNotDis(strHeaderName);
		
		objReport1.verifyHeadersInHTMLEventSnapshotReport(strHeaderName1);

		String[] strData = new String[] { objResource_data.strResourceName," ",
				strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName1 };

		objReport1.verifDataInHTMLEventSnapshotReport(strData);

		objReport1.verifSTNotAvlInSummaryTable(
				objStatuTypes_data.strNSTStatusTypeName);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

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
				objTest_data.strComment, objTest_data.strLastUpdate,
				objTest_data.strUpdatedBy };
		
		String[] strUpdatedStatusTypeNames1 = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };
		
		String[] strUpdatedExcelValues = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				"", strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName1 };
		
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

		}
		
		for (intCount = 0; intCount < strUpdatedStatusTypeNames1.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 2,
					3, strDownloadName1);
			assertNotEquals(strUpdatedStatusTypeNames1[intCount], strValue);
			/*summary part need to verify*/
			/*strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 4,
					intCount, strDownloadName1);
			assertNotEquals(strSummaryValue[intCount - 1], strValue);*/

		}
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/****************************************************************************************************************
	'Description : Update statuses of status types added at the resource type level for a resource RS. Verify that a 
				   user with ‘Run Report’ & 'View Resource' rights on RS and with a role WITH only view right for these 
				   status types CAN view these status types in the Event Snapshot report.
	'Date	 	 : 13-Jul-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Update statuses of status types added at the resource type level for a resource RS. Verify that a user "
			+ "with ‘Run Report’ & 'View Resource' rights on RS and with a role WITH only view right for these status types CAN"
			+ " view these status types in the Event Snapshot report.")
	public void testHappyDay118882() throws Exception {

		gstrTCID = "118882";
		gstrTO = "Update statuses of status types added at the resource type level for a resource RS. Verify that a user with"
				+ " ‘Run Report’ & 'View Resource' rights on RS and with a role WITH only view right for these status types "
				+ "CAN view these status types in the Event Snapshot report.";

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
						objStatusTypes_data.strStatusNameInMulti)
		
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti3);


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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
				
		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRoles_data.strRoleName)
				.deSelectAllCheckboxInRolesMayUpdatesec()
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
						strstatusTypeValues);

		objEventManagement.clickOnSaveButton();

		strEveTemplateValue[0] = objEventManagement
									.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		// User creation with only view and update rights
		objUsersList.navigateToUsers()
					.clickCreateNewUserButton()
					.enterUserDetails(objUser_data.strNewUserName1,
							objUser_data.strNewPassword, objUser_data.strFullName)
					.selectRoleCheckBox(strRoleValue)
					.clickAdvancedOptionAndExpand()
					.selectReportEventSnapshotOption()
					.selectViewResourceRights(objResource_data.strResourceName)
					.selectRunReportsCheckBox(objResource_data.strResourceName)
					.clickSaveButton()
					.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objUser_data.strNewUserName1);
		System.out.println(objEvent_data.strEventName 
						+ " " + objEvent_data.strEventDescription);

		objLogin.clickLogOut();
		
		System.out.println("----------Precondition ends----------");
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		// create Event
		objEventManagement1.navigateToEventManagement()
						  .clickOnCreateNewEvent()
						  .clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
						  .enterAdHocEventName(objEvent_data.strEventName)
						  .enterAdHocEventDescription(objEvent_data.strEventDescription)
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
		
		objEventManagement1.verWebNotificationframe()
						   .verWebNotificationAndAcknowledge(objEvent_data.strEventName,
								   		objEvent_data.strEventDescription)
						   .clickAcknowledgeAllNotifications();

		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame();
		
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
		
		objViewsList1.verifyResourceTypeNameInView(strResourceTypeValue[0], 
							objResourceType_data.strResourceTypeName);
		
		String strAppDateAndTime = objEventManagement1.getApplicationTimeWithCSTCDT();
		
		String[] strAppDateTime = strAppDateAndTime.split(" ");
		
		String strUpdateDate = "";
		String strCurrentDate = dts.getCurrentDate("dd");
		int intCurrentDate = Integer.parseInt(strCurrentDate);
		
		int intDate = Integer.parseInt(strAppDateTime[0]);
		if(intDate == intCurrentDate){
			strUpdateDate = dts.getCurrentDate("MM/dd/yyyy");
		} else {
			if(intDate < intCurrentDate){
				strUpdateDate = dts.getPastDayNew(1, "MM/dd/yyyy");
			}
			else {
				strUpdateDate = dts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		
		String strUpdateDate1 = dts.converDateFormat(strUpdateDate, "MM/dd/yyyy", "dd MMM yyyy");
		String[] strUpdateTime = strAppDateTime[2].split(":");
		
		String strUpdateTimePlus1 = dts.AddTimeToExistingTimeHourAndMin(strAppDateTime[2], 0, 1, "HH:mm");
		
		String[] strUpdatedTimePlusOne = strUpdateTimePlus1.split(":");
		
		String strStartDate = dts.converDateFormat(strEventStartDateAndTime, "dd MMM yyyy HH:mm", "MM/dd/yyyy");
		
		String strEndDate = dts.converDateFormat(strEventStartDateAndTime, "dd MMM yyyy HH:mm", "MM/dd/yyyy");
		
		System.out.println("Strat Date = " + strStartDate);
		System.out.println("End Date = " + strEndDate);
		
		objLogin1.clickLogOut()
				 .loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);
		
		System.out.println("wait for a minute.");
		TimeUnit.MINUTES.sleep(1);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToEventReports();
		
		objReport1.clickOnEventSnapshot()
				  .verifyEventSnapshotReport1stPage()
				  .verifySearchStartDate().verifySearchEndDate()
				  .enterStartDate(strStartDate)
				  .enterEndDate(strStartDate);
		
		objReport1.selectEventTemplate(strEveTemplateValue[0]);

		objReport1.clickOnNextBtn()
				  .selectEventRadioBtn(objEvent_data.strEventName)
				  .verifySnapshotDateAndTimeShouldFallBetweenOption()
				  .verifySnapshotDateOption().verifySnapshotTimeHourOption()
				  .verifySnapshotTimeMinutesOption()
				  .enterSnapshotDate(strUpdateDate)
				  .selectSnapshotTimeHour(strUpdatedTimePlusOne[0])
				  .selectSnapshotTimeMinutes(strUpdatedTimePlusOne[1]);
		
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
				objView_data.strDateUpdateValue, objStatuTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForTST, " ",
				strUpdateDate1 + " " + strUpdateTime[0] + ":" + strUpdateTime[1] ,
				objUser_data.strFullName };

		objReport1.verifDataInHTMLEventSnapshotReport(strData);

		objReport1.verifSummaryTable(objStatuTypes_data.strNSTStatusTypeName, 
				objView_data.strValueForUpdate);
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToEventReports();
		
		objReport1.clickOnEventSnapshot()
				  .verifyEventSnapshotReport1stPage()
				  .enterStartDate(strStartDate)
				  .enterEndDate(strStartDate)
				  .selectEventTemplate(strEveTemplateValue[0])
				  .selectExcelReportRadioBtn()
				  .clickOnNextBtn()
				  .selectEventRadioBtn(objEvent_data.strEventName)
				  .enterSnapshotDate(strUpdateDate)
				  .selectSnapshotTimeHour(strUpdatedTimePlusOne[0])
				  .selectSnapshotTimeMinutes(strUpdatedTimePlusOne[1]);
		
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
				"", strUpdateDate1 + " " + strUpdateTime,
				objUser_data.strFullName };

		/*summary part need to verify*/
		String[] strSummaryValue = { objTest_data.strSummary,
				objView_data.strZeroValue, objView_data.strZeroValue,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strZeroValue,
				"", "", "" };

		strValue = objOffCommonFunc.readInfoExcel(
				"Event Snapshot", 1, 1,
				strDownloadName1);
		assertEquals("Event Snapshot for " + objEvent_data.strEventName + " - "
				+ dts.converDateFormat(strEventStartDateAndTime, "dd MMM yyyy HH:mm", "mm/dd/yyyy") + " " + strUpdateTimePlus1
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
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 4,
					intCount, strDownloadName1);
			assertEquals(strSummaryValue[intCount - 1], strValue);

		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	

	/********************************************************************************
	'Description :Verify that Event snapshot report can be generated in XLSX format  
	'Date	 	 : 28-Dec-2015
	'Author		 : Sangappa K
	'------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************/
	@Test(description ="Verify that Event snapshot report can be generated in XLSX format ")
	public void testHappyDay162662() throws Exception {

		gstrTCID ="162662";
		gstrTO = "Verify that Event snapshot report can be generated in XLSX format"; 

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Report_data objReport_data = new Report_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		String strstatusTypeValues1[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
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
						objStatusTypes_data.strStatusNameInMulti)
		
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2);

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
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues1);

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

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strstatusTypeValues).clickOnSaveButton();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);

		objEventSetUp.navigateToEventSetUp();
		objEventSetUp
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllResOption().deselectSelectAllWebOption();

		strEveTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectReportEventSnapshotOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault.selectFrame();

		// create Event
		objEventManagement.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton();

		String strEventStartDateAndTime = objEventManagement
				.getEventStartTime(objEvent_data.strEventName);
		String strEventEndTime = objEventManagement
				.getEventEndTime(objEvent_data.strEventName);

		strEventStartDateAndTime = dts.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH:mm",
				"dd MMM yyyy HH:mm");

		strEventEndTime = dts.converDateFormat(strEventEndTime,
				"yyyy-MM-dd HH:mm", "dd MMM yyyy HH:mm");

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

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

		String strStartTim1[] = oneMinuteAdded.split(":");
		String strStartTim2[] = oneMinuteAdded1.split(":");
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

		Thread.sleep(30000);

		objNavigationToSubMenus1.navigateToEventReports();

		objReport1.clickOnEventSnapshot().selectExcelReportRadioBtn()
				.enterStartDate(strCurrentDate).enterEndDate(strCurrentDate);

		objReport1.selectEventTemplate(strEveTemplateValue[0]);

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

		String[] strUpdatedStatusTypeNamesHeaders = { "Resource Type",
				"Resource", objStatusTypes_data.strDateStatusTypeName,
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
				objStatuTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForUpdate,

				"", strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName };

		/* summary part need to verify */
		String[] strSummaryValue = { objTest_data.strSummary,
				objView_data.strZeroValue, objView_data.strZeroValue,
				objView_data.strNEDOCVal, objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST, objView_data.strZeroValue,
				"", "", "" };

		strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 1, 1,
				strDownloadName1);
		assertEquals("Event Snapshot for " + objEvent_data.strEventName + " - "
				+ strCurrentDate + " " + strHourFrExcel + ":" + strMinute1
				+ " Central Standard Time. Event Start: "
				+ strEventStartDateAndTime + ". Event End: " + strEventEndTime
				+ ". ", strValue);

		for (intCount = 1; intCount <= strUpdatedStatusTypeNamesHeaders.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 2,
					intCount, strDownloadName1);
			assertEquals(strUpdatedStatusTypeNamesHeaders[intCount - 1],
					strValue);

			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 3,
					intCount, strDownloadName1);
			assertEquals(strUpdatedExcelValues[intCount - 1], strValue);

		}

		for (intCount = 0; intCount < strSummaryValue.length; intCount++) {

			/* summary part need to verify */
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 4,
					intCount, strDownloadName1);
			assertNotEquals(strSummaryValue[intCount - 1], strValue);

		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************
	'Description : Verify that Event snapshot report can be generated in HTML format 
	'Date	 	 : 10-Sep-2014
	'Author		 : Anil
	'-------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************/
	@Test(description = "Verify that Event snapshot report can be generated in HTML format ")
	public void testHappyDay162658() throws Exception {

		gstrTCID = "162658";
		gstrTO = "Verify that Event snapshot report can be generated in HTML format ";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Roles_data objRoles_data = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Date_Time_settings objDts = new Date_Time_settings();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

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
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		
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
						objStatusTypes_data.strStatusNameInMulti)
						
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		

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
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
	
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
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

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
		
		String oneMinuteAdded = objDts
				.addTimetoExisting(strStartTi[2], 1, "HH:mm");

		String strStartTim1[] = oneMinuteAdded.split(":");
		String strHour1 = strStartTim1[0];
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
				.enterEndDate(strCurrentDate)
				.enterStartDate(strCurrentDate);

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
				objView_data.strValueForUpdate, " ",
				strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName };

		objReport1.verifDataInHTMLEventSnapshotReport(strData);
		
		objReport1.verifSummaryTable(objStatusTypes_data.strNSTStatusTypeName, objView_data.strValueForUpdate);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		
		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToEventReports();

		Thread.sleep(60000);

		objReport1.clickOnEventSnapshot().verifyEventSnapshotReport1stPage()
				.verifySearchStartDate().verifySearchEndDate()
				.enterEndDate(strCurrentDate)
				.enterStartDate(strCurrentDate);

		objReport1.selectEventTemplate(strEveTemplateValue[0]);

		objReport1.clickOnNextBtn()
				.selectEventRadioBtn(objEvent_data.strEventName)
				.verifySnapshotDateAndTimeShouldFallBetweenOption()
				.verifySnapshotDateOption().verifySnapshotTimeHourOption()
				.verifySnapshotTimeMinutesOption()
				.enterSnapshotDate(strCurrentDate)
				.selectSnapshotTimeHour(strHour1)
				.selectSnapshotTimeMinutes(strMinute1);

		mainWindowHandle = driver1.getWindowHandle();

		objReport1.clickOnGenerateReportBtn();

		System.out.println(objEvent_data.strEventName);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite2 = a1.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}


		objReport1.verifyHeadersInHTMLEventSnapshotReport(strHeaderName);

		objReport1.verifDataInHTMLEventSnapshotReport(strData);
		
		objReport1.verifSummaryTable(objStatusTypes_data.strNSTStatusTypeName, objView_data.strValueForUpdate);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}

	

	/*************************************************************************************************
	'Description : Verify that Event Snapshot report displays appropriate data for NEDOCS status type 
	'Date	 	 : 28-Dec-2015
	'Author		 : Anil
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***************************************************************************************************/
	@Test(description = "Verify that Event Snapshot report displays appropriate data for NEDOCS status type.")
	public void testHappyDay119794() throws Exception {

		gstrTCID = "119794";
		gstrTO = "Verify that Event Snapshot report displays appropriate data for NEDOCS status type.";

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

		String strstatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strEveTemplateValue[] = new String[1];

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
	
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

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
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
	
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
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

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
System.out.println(objUser_data.strNewUserName);
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strNDSTStatusTypeName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.enterNedocsUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForNDST)	
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
				strstatusTypeValues[0], objView_data.strNEDOCValue);

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
				objStatuTypes_data.strNDSTStatusTypeName, "Comment",
				"Last Update", "By User" };

		objReport1.verifyHeadersInHTMLEventSnapshotReport(strHeaderName);

		String[] strData = new String[] { objResource_data.strResourceName,
				objView_data.strNEDOCVal, " ",
				strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName };

		objReport1.verifDataInHTMLEventSnapshotReport(strData);

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
				objStatusTypes_data.strNDSTStatusTypeName,
				objTest_data.strComment, objTest_data.strLastUpdate,
				objTest_data.strUpdatedBy };
		
		String strUpdateTime1 = strTime + " " + strStartTi[2];
		
		String strUpdateTime2 = strTime + " " + strHour + ":" + strStartTim1[1];

		String[] strUpdatedExcelValues = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objView_data.strNEDOCVal,
				"", strUpdateTime1,
				objUser_data.strFullName };

		/*summary part need to verify*/
		
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
		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/********************************************************************************************************************
	'Description : Verify that user with appropriate right can generate 'Event Snapshot' report for a multi region event.
	'Date	 	 : 2-Feb-2016
	'Author		 : Anitha
	'-------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************************************/
	@Test(description = "Verify that user with appropriate right can generate 'Event Snapshot' report for a multi region event.")
	public void testHappyDay136429() throws Exception {

		gstrTCID = "136429";
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
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Report objReport1 = new Report(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		
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
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
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

		String filePath = file + "\\";

		System.out.println("-------Precondition started----------");
		
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

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

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
						objStatusTypes_data.strStatusNameInMulti)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		
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
				.selectRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		// Navigate to Region2
		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

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
						objStatusTypes_data.strStatusNameInMulti1)
						
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2);		

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
	
	/****************************************************************************************************************
	'Description :  Verify that 'Event Snapshot' report for a multi region event displays status updates of only logged in region resource.
	'Precondition:
	'Date	 	 : 2-Feb-2016
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = " Verify that 'Event Snapshot' report for a multi region event displays status updates of only logged in region resource.")
	public void testHappyDay136430() throws Exception {

		gstrTCID = "136430";
		gstrTO = " Verify that 'Event Snapshot' report for a multi region event displays status updates of only logged in region resource.";

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

		String strstatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strEveTemplateValue[] = new String[1];
		String strRegionValue[] = new String[2];
		String strStatusesValues[] = new String[2];

		String strstatusTypeValuesInReg2[] = new String[2];
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
						objStatusTypes_data.strStatusNameInMulti)
		      
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

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
				.selectRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

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
						objStatusTypes_data.strStatusNameInMulti1)
				
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2);		

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

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
				objStatusTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strNSTStatusTypeName};

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
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[0])
						.clickOnSaveButton();

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1],
				objStatusTypes_data.strStatusNameInMulti);

		objSelectRegion1.selectRegionAndNavigate(objLogin_data.strRegionName1);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName1,
				objResource_data.strResourceName1);

		String[] strStatusTypeNamesInReg2 = {
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strMSTStatusTypeName1 };

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
				.selectMSTUpdateValue(strstatusTypeValuesInReg2[1],
						strStatusesValues[1])
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
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strNSTStatusTypeName1, "Comment",
				"Last Update", "By User" };

		objReport1.verifyHeadersInHTMLEventSnapshotReport(strHeaderName);

		String[] strData = new String[] { objResource_data.strResourceName1,
				objStatuTypes_data.strStatusNameInMulti1,objView_data.strValueForUpdate, 
				" ",
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
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strNSTStatusTypeName, "Comment",
				"Last Update", "By User" };

		String strUpdateTime1 = strTime + " " + strStartTi[2];
		
		String strUpdateTime2 = strTime + " " + strHour + ":" + strStartTim1[1];
		
		String strUpdateTime3 = strTime + " " + strHour + ":" + strUpdatedTime[1];
		
		String[] strData1 = new String[] {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objStatuTypes_data.strStatusNameInMulti,
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
}
