package requirementGroup.Reports;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.io.File;
import java.util.Properties;

import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.FileFormatConverter;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayNotificationHistoryReport extends TestNG_UI_EXTENSIONS {

	public HappyDayNotificationHistoryReport() throws Exception {
		super();
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that only admin user can generate 'Notification History' report.
	 * 'Date        : 19-June-2015 
	 * 'Author      : Sangappa.k
	 ***************************************************************************************************************/

	
	@Test(description ="Verify that only admin user can generate 'Notification History' report.")
	public void testHappyDay162281() throws Exception {
		gstrTCID = "162281";
		gstrTO ="Verify that only admin user can generate 'Notification History' report.";

		// Objects for data
		Login_data objTest_data = new Login_data();
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

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		User_data objUserdata = new User_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Report objReport1 = new Report(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);

		Date_Time_settings objDts1 = new Date_Time_settings();

		FileFormatConverter objFileFormatConverter = new FileFormatConverter();

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectReportEventDetailOption()
				.selectReportEventSnapshotOption().selectReportformDetail()
				.selectReportIncomingPatientNotificationOption()
				.selectReportStatusDetailOption()
				.selectReportStatusReasonDetailOption()
				.selectReportStatusReasonSummaryOption()
				.selectReportStatusSnapshotOption()
				.selectReportStatusSummaryOption()
				.selectReporAuditResourceDetail()
				.selectReportStatewideResourceDetail()
				.selectReporMonthlyStatusAssessment().clickSaveButton();
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToAdminReports();
		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = objDts1.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		String strStartDate = objDts1.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");

		objReport1.verifyAdminReportPage().clickOnNotificationHistory()
				.verifyNotificationHistoryPage()
				.enterNotificationHistoryStartDate(strStartDate)
				.enterNotificationHistoryEndDate(strStartDate)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		int intCount = 0;

		objFileFormatConverter.convertXlsxToXls(strDownloadName,
				strDownloadName1);

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
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		objRegionDefault1.selectFrame();
		objNavigationToSubMenus1.verAdminReportsNotExistUnderReports();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

}
