package requirementGroup.Reports;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Properties;

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
import lib.page.Login;
import lib.page.Map;
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

public class HappyDayStatusSnapshotReport  extends TestNG_UI_EXTENSIONS {

	public HappyDayStatusSnapshotReport() throws Exception {
		super();
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that appropriate value is displayed for date status type in Status Snapshot report 	
	 * 'Date        : 02-Mar-2015 
	 * 'Author      : Renushree
	 ***************************************************************************************************************/

	@Test(description = "Verify that appropriate value is displayed for date status type in Status Snapshot report")
	public void testHappyDay155102() throws Exception {
		gstrTCID = "155102";
		gstrTO = "Verify that appropriate value is displayed for date status type in Status Snapshot report";

		// Objects for data
		Login_data objTest_data = new Login_data();
		UsersList objUsersList_page = new UsersList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

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
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Report objReport1 = new Report(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

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

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource_Page
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
				.clickOnLookupAddressBtn()
				.clickOnSaveButton().clickOnSaveButton();

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.deselectAllViewResReightOption()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSnapshotOption()
				.clickSaveButton();
		
		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1.selectStatusTypes(strStatusTypeValues[0]);

		objUpdateStatus1
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strDateUpdateValue)
				.clickOnSaveButton();

		Thread.sleep(5000);
		
		String strEventStartTime = objEventManagement1.getApplicationTimeWithCSTCDT();

		String strStartTime[] = strEventStartTime.split(":");

		String strTimeZone[] = strStartTime[1].split(" ");
		
		String strStartTime1[] = strStartTime[0].split(" ");

		String strDate2 = strStartTime1[0];
		
		String strMonth = strStartTime1[1];
		
		strMonth = objDate_Time_settings.converDateFormat(strMonth, "MMM", "MM");
		
		String strYear = objDate_Time_settings.getFutureYear(0, "yyyy");
		
		String strHour = strStartTime1[2];

		String strMinute = strStartTime[1];
		
		String strMinute1 = objDate_Time_settings.addTimetoExisting(strMinute, 1, "mm");
		
		String strCurrentDate = strMonth+"/"+strDate2+"/"+strYear;
		
		String strTime = objDate_Time_settings.getCurrentDate("HH:mm");
		
		strCurrentDate = strCurrentDate+" "+strTime;
		
		String[] strDate = strCurrentDate.split(" ");
		
		System.out.println(strCurrentDate);
		String strLastUpdatedDateInReport = objDate_Time_settings.converDateFormat(strCurrentDate, "MM/dd/yyyy HH:mm", "dd MMM yyyy HH:mm");
		String str[] = strLastUpdatedDateInReport.split(" ");
		strLastUpdatedDateInReport = str[0]+" "+str[1]+" "+str[2]+" "+strHour+":"+strMinute;
		System.out.println(strLastUpdatedDateInReport);
		objNavigationToSubMenus1.clickOnStatusReports();
		
		Thread.sleep(180000);
		
		objReport1.clickOnStatusSnapshot().enterReportDate(strDate[0])
		.selectHour(strHour).selectMinute(strMinute1)
		.clickOnGenerateReportBtn();
		
		Thread.sleep(60000);
		
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
				"Status Snapshot", 1, 1, strDownloadName1);
		assertEquals("Status Snapshot - "+strDate[0]+" "+strHour+":"+strMinute1+" "+strTimeZone[1]+"", strValue);

		String[] strHeaderNames = objReport_data.strStatusSnapshot;

		String[] strAnswers = {
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objStatusTypes_data.strDateStatusTypeName,
				objView_data.strDateUpdateValue,
				"",strLastUpdatedDateInReport};

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Status Snapshot",
					2, intCount, strDownloadName1);
			assertEquals(strHeaderNames[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel("Status Snapshot",
					3, intCount, strDownloadName1);
			assertTrue(strAnswers[intCount - 1].contains(strValue));
		}
		
		gstrResult = "PASS";
	}
}
