package requirementGroup.CreatingAndManagingEvents;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewForAddStatusTypesToCurrentlyRunningEvent extends TestNG_UI_EXTENSIONS {
	
	public NewForAddStatusTypesToCurrentlyRunningEvent() throws Exception {
		super();
	}

	/*************************************************************************************
	 * 'Description 	: Select new status types while editing an event and verify that newly selected status type is displayed in event detail screen. 
	 * 'Precondition	: 
	 * 'Date 			: 30-Jun-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Select new status types while editing an event and verify that newly selected status type is displayed in event detail screen. ")
	public void testHappyDay44524() throws Exception {

		gstrTCID = "44524";
		gstrTO = "Select new status types while editing an event and verify that newly selected status type is displayed in event detail screen. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		Date_Time_settings objDts = new Date_Time_settings();
		View_data objView_data = new View_data();
		Report_data objReport_data = new Report_data();
		String strTimeText = objDts.getCurrentDate(objReport_data.dateFormat1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		AutoIT objAutoIT = new AutoIT(this.driver1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strEveTemplateValue[] = new String[1];

		String fileType = objReport_data.reportFile;
		String fileType1 = objReport_data.pdfFile;

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

		String strDownloadName2 = file + "\\" + "TC_2nd" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed2 = "TC_2nd" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath2 = file + "\\" + "TC_2nd" + gstrTCID
				+ "_" + strTimeText + objReport_data.xlsFile;

		String strDownloadName3 = file + "\\" + "TC_2nd" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName4 = file + "\\" + "TC91308" + "_" + strTimeText
				+ fileType1;

		String filePath = file + "\\";

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		System.out.println(objResourceType_data.strResourceTypeName);

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectReportEventDetailOption()
				.selectReportEventSnapshotOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objESetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objESetUp_data.strTemplateDefinition)
				.selectStatusType(strStatusTypeValues[0])
				.selectResourceType(strResourceTypeValue[0]).clickSaveButton()
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objESetUp_data.strEventTemplate);

		strEveTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objESetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objStatusTypes_data.strNumberStatusType);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		String strDrill = objEventManagement1
				.getDrillVal(objEvent_data.strEventName);

		String strEventStartDateAndTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);

		String strEventStartDateAndTimeForExcel = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);
		String strEventEndTimeForExcel = objEventManagement1
				.getEventEndTime(objEvent_data.strEventName);

		strEventStartDateAndTimeForExcel = objDts.converDateFormat(
				strEventStartDateAndTimeForExcel, "yyyy-MM-dd HH:mm",
				"dd MMM yyyy HH:mm");

		strEventEndTimeForExcel = objDts.converDateFormat(
				strEventEndTimeForExcel, "yyyy-MM-dd HH:mm",
				"dd MMM yyyy HH:mm");

		String strEventVal = objEventManagement1
				.getEventValue(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verifyCreatedByDesc(objUserdata.strFullName,
				strEventStartDateAndTime, objEvent_data.strEventDescription);

		objEventStatus1
				.clickOnUpdateStatusKey(objResource_data.strResourceName);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForUpdate).clickOnSaveButton();

		String strEventStartTime = objEventManagement1.getApplicationTime();

		String strStartTime[] = strEventStartTime.split(":");

		String strStartTi[] = strEventStartTime.split(" ");

		String strStartTime1[] = strStartTime[0].split(" ");

		String strDate = strStartTime1[0];

		String strMonth = strStartTime1[1];

		String strHour = strStartTime1[2];

		String strMinute = strStartTime[1];

		String oneMinuteAdded1 = objDts.addTimetoExisting(strStartTi[2], 2,
				"H:mm");
		String oneMinuteAdded = objDts.addTimetoExisting(strStartTi[2], 2,
				"HH:mm");

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

		strEventStartDateAndTime = objDts.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH mm", "MM/dd/yy HH mm");

		Thread.sleep(120000);

		objEventManagement1.navigateToEventManagement()
				.clickOnEditLink(objEvent_data.strEventName)
				.verStatusTypeSelectedAndDisabled(strStatusTypeValues[0])
				.selectStatusTypeInEditEventPage(strStatusTypeValues[1])
				.clickOnSaveButton();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.clickOnUpdateStatusKey(objResource_data.strResourceName);

		objUpdateStatus1.clickOnSelectAll();

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForUpdate);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[1],
				objView_data.strValueForTST).clickOnSaveButton();

		String strEventTimeAfterAddingSecST = objEventManagement1
				.getApplicationTime();

		String strAfterStartTime[] = strEventTimeAfterAddingSecST.split(":");

		String strAfterStartTi[] = strEventTimeAfterAddingSecST.split(" ");

		String strAfterStartTime1[] = strAfterStartTime[0].split(" ");

		String strAfterDate = strAfterStartTime1[0];

		String strAfterMonth = strAfterStartTime1[1];

		String strAfterHour = strAfterStartTime1[2];

		String strAfterMinute = strAfterStartTime[1];

		String oneMinuteAdded2 = objDts.addTimetoExisting(strAfterStartTi[2],
				2, "H:mm");
		String oneMinuteAdded3 = objDts.addTimetoExisting(strAfterStartTi[2],
				2, "HH:mm");

		String strAfterStartTim1[] = oneMinuteAdded3.split(":");
		String strAfterStartTim2[] = oneMinuteAdded2.split(":");
		String strHour2 = strAfterStartTim1[0];
		String strHourFrExcel2 = strAfterStartTim2[0];
		String strMinute2 = strAfterStartTim1[1];

		String strCurrentDate2 = objDts.getCurrentDate("MM/dd/yyyy HH:mm");

		String strStartTime3[] = strCurrentDate2.split(" ");

		String strCurrentDate3 = strStartTime3[0];

		String strYear3[] = strCurrentDate3.split("/");

		String strYear2 = strYear3[2];

		String strTime2 = strAfterDate + " " + strAfterMonth + " " + strYear2;

		strEventStartDateAndTime = objDts.converDateFormat(
				strEventStartDateAndTime, "yyyy-MM-dd HH mm", "MM/dd/yy HH mm");

		objNavigationToSubmenus1.navigateToEventReports();

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
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment",
				"Last Update", "By User" };

		objReport1.verifyHeadersInHTMLEventSnapshotReport(strHeaderName);

		String[] strData = new String[] { objResource_data.strResourceName,
				objView_data.strValueForUpdate, " ", " ",
				strTime + " " + strHour + ":" + strMinute,
				objUserdata.strFullName };

		objReport1.verifDataInHTMLEventSnapshotReport(strData);

		objReport1.verifSummaryTable(objStatusTypes_data.strNSTStatusTypeName,
				objView_data.strValueForUpdate);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.navigateToEventReports();

		objReport1.clickOnEventSnapshot().selectExcelReportRadioBtn()
				.enterStartDate(strCurrentDate1).enterEndDate(strCurrentDate1)
				.selectEventTemplate(strEveTemplateValue[0]).clickOnNextBtn()
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
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objLogindata.strComment, objLogindata.strLastUpdate,
				objLogindata.strUpdatedBy };

		String strUpdateTime1 = strTime + " " + strStartTi[2];

		String strUpdateTime2 = strTime + " " + strHour + ":" + strStartTim1[1];

		String[] strUpdatedExcelValues = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objView_data.strValueForUpdate, "", "", strUpdateTime1,
				objUserdata.strFullName };

		/* * summary part need to verify */
		String[] strSummaryValue = { objLogindata.strSummary,
				objView_data.strValueForUpdate, "", "", "" };

		strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 1, 1,
				strDownloadName1);
		assertEquals("Event Snapshot for " + objEvent_data.strEventName + " - "
				+ strCurrentDate + " " + strHourFrExcel + ":" + strMinute1
				+ " Central Standard Time. Event Start: "
				+ strEventStartDateAndTimeForExcel + ". Event End: "
				+ strEventEndTimeForExcel + ". ", strValue);

		for (intCount = 1; intCount <= strUpdatedStatusTypeNames.length; intCount++) {
			if (intCount == 10) {
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

			/* * summary part need to verify - refer bug id EMS-5027 */
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 4,
					intCount, strDownloadName1);
			assertEquals(strSummaryValue[intCount - 1], strValue);

		}

		// After adding 2nd ST

		objNavigationToSubmenus1.navigateToEventReports();

		objReport1.clickOnEventSnapshot().verifyEventSnapshotReport1stPage()
				.verifySearchStartDate().verifySearchEndDate()
				.enterStartDate(strCurrentDate3).enterEndDate(strCurrentDate3);

		objReport1.selectEventTemplate(strEveTemplateValue[0]);

		objReport1.clickOnNextBtn()
				.selectEventRadioBtn(objEvent_data.strEventName)
				.verifySnapshotDateAndTimeShouldFallBetweenOption()
				.verifySnapshotDateOption().verifySnapshotTimeHourOption()
				.verifySnapshotTimeMinutesOption()
				.enterSnapshotDate(strCurrentDate3)
				.selectSnapshotTimeHour(strHour2)
				.selectSnapshotTimeMinutes(strMinute2);

		String mainWindowHandle1 = driver1.getWindowHandle();

		objReport1.clickOnGenerateReportBtn();

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		String TitleName1 = driver1.getTitle();
		assertTrue(TitleName1.contains("Event Snapshot Report"));

		String strHeaderName2[] = { objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName, "Comment",
				"Last Update", "By User" };

		objReport1.verifyHeadersInHTMLEventSnapshotReport(strHeaderName2);

		String[] strData2 = new String[] { objResource_data.strResourceName,
				objView_data.strValueForUpdate, objView_data.strValueForTST,
				" ", strTime2 + " " + strAfterHour + ":" + strAfterMinute,
				objUserdata.strFullName };

		objReport1.verifDataInHTMLEventSnapshotReport(strData2);

		objReport1.verifSummaryTable(objStatusTypes_data.strNSTStatusTypeName,
				objView_data.strValueForUpdate);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.navigateToEventReports();

		objReport1.clickOnEventSnapshot().selectExcelReportRadioBtn()
				.enterStartDate(strCurrentDate3).enterEndDate(strCurrentDate3)
				.selectEventTemplate(strEveTemplateValue[0]).clickOnNextBtn()
				.selectEventRadioBtn(objEvent_data.strEventName)
				.enterSnapshotDate(strCurrentDate3)
				.selectSnapshotTimeHour(strHour2)
				.selectSnapshotTimeMinutes(strMinute2)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
		intCount = 0;
		intCount1 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName2).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed2);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath2).exists());
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

		strValue = "";

		String[] strUpdatedStatusTypeNames1 = { "Resource Type", "Resource",
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objLogindata.strComment, objLogindata.strLastUpdate,
				objLogindata.strUpdatedBy };

		String strUpdateTime3 = strTime2 + " " + strAfterStartTi[2];

		String strUpdateTime4 = strTime2 + " " + strAfterHour + ":"
				+ strAfterStartTim1[1];

		String[] strUpdatedExcelValues1 = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objView_data.strValueForUpdate, objView_data.strValueForTST,
				"", strUpdateTime3, objUserdata.strFullName };

		/** summary part need to verify */
		String[] strSummaryValue1 = { objLogindata.strSummary,
				objView_data.strValueForUpdate, "", "", "" };

		strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 1, 1,
				strDownloadName3);
		assertEquals("Event Snapshot for " + objEvent_data.strEventName + " - "
				+ strCurrentDate + " " + strHourFrExcel2 + ":" + strMinute2
				+ " Central Standard Time. Event Start: "
				+ strEventStartDateAndTimeForExcel + ". Event End: "
				+ strEventEndTimeForExcel + ". ", strValue);

		for (intCount = 1; intCount <= strUpdatedStatusTypeNames1.length; intCount++) {
			if (intCount == 10) {
				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 2,
						intCount, strDownloadName3);
				assertEquals(strUpdatedStatusTypeNames1[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 3,
						intCount, strDownloadName3);
				assertTrue(strUpdatedExcelValues1[intCount - 1]
						.equals(strValue) || strUpdateTime4.equals(strValue));
			} else {
				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 2,
						intCount, strDownloadName3);
				assertEquals(strUpdatedStatusTypeNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 3,
						intCount, strDownloadName3);
				assertEquals(strUpdatedExcelValues1[intCount - 1], strValue);
			}

			/* * summary part need to verify - refer bug id EMS-5027 */
			strValue = objOffCommonFunc.readInfoExcel("Event Snapshot", 4,
					intCount, strDownloadName1);
			assertEquals(strSummaryValue1[intCount - 1], strValue);

		}

		objNavigationToSubmenus1.navigateToEventReports();

		objReport1.clickOnEventDetailLink()
				.verEventDetailReportPgeIsDisplayed()
				.enterStartDate(strCurrentDate3).enterEndDate(strCurrentDate3)
				.selectEventTemplate(strEveTemplateValue[0]).clickOnNextBtn()
				.verEventDetailReportPge2IsDisplayed()
				.enterReportStartDate(strCurrentDate3)
				.enterReportEndDate(strCurrentDate3).selectEvent(strEventVal)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName4,
				strAutoITName);

		File file2 = new File(strDownloadName);
		boolean strPdf1 = file2.exists();
		objLogin1.clickLogOut();

		String strUpdatedTime = strEventStartTime;
		String strUpdate = objReport_data.strUpdate;

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + ","
							+ objLogindata.strRegionName,
					objEvent_data.strEventName,
					objESetUp_data.strEventTemplate,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strNumberStatusType + ","
							+ objStatusTypes_data.strTSTStatusTypeName,
					strEventStartDateAndTimeForExcel, strEventEndTimeForExcel,
					objReport_data.ExternalIP, strDrill, strUpdate,
					strUpdatedTime, strDownloadName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		if (strPdf1 = true) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}
}
