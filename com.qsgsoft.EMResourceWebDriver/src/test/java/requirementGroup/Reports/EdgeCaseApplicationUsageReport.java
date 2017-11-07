package requirementGroup.Reports;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Properties;

import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.module.NavigationToSubMenus;
import lib.page.ApplicationUsageReportsMenu;
import lib.page.AutoIT;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.SelectRegion;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.CSVFunctions;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseApplicationUsageReport extends TestNG_UI_EXTENSIONS {

	public EdgeCaseApplicationUsageReport() throws Exception {
		super();
	}
	/*********************************************************************************
	 * 'Description : Verify that 'Normal Usage' report now includes 'Create MRE' column.
	 *    'Date     : 23-09-2015 
	 *   'Author    : Sandhya
	 **********************************************************************************/
	@Test(description = " Verify that 'Normal Usage' report now includes 'Create MRE' column.")
	public void testEdgeCase167486() throws Exception {
		gstrTCID = "167486";
		gstrTO = " Verify that 'Normal Usage' report now includes 'Create MRE' column.";
		// Objects for data
		Login_data objTest_data = new Login_data();
		AutoIT objAutoIT = new AutoIT(this.driver1);
		CSVFunctions objCSVFunctions = new CSVFunctions();

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strTimeText = objDate_Time_settings
				.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.csvFile;

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
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Report objReport1 = new Report(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		ApplicationUsageReportsMenu objApplicationUsageReportsMenu1 = new ApplicationUsageReportsMenu(
				driver1);
		Date_Time_settings objDts1 = new Date_Time_settings();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToApplicationUsageReports();

		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = objDts1.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		String strEndDate = objDts1.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");

		String strStartDate = objDts1.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");

		objApplicationUsageReportsMenu1
				.verApplicationUsageReportsPageIsDisplayed()
				.clickOnNormalUsage().enterStartDate(strStartDate)
				.enterEndDate(strEndDate);

		objReport1.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		int intCount = 0;

		File file1 = new File(strDownloadName);

		assertTrue(file1.exists(), "file not  found");

		String strHeaders[] = objReport_data.AppUsageHeaders;

		String strData = objCSVFunctions.readCSVFileData(strDownloadName, 5);

		System.out.println("strHeaders is " + strHeaders);

		System.out.println("strData is " + strData);

		boolean strCheck = false;
		int strCount=0;

		String[] CsvData = strData.split(",");

		for (intCount = 0; intCount <= strHeaders.length - 1; intCount++) {

			if (CsvData[intCount].equals("MRE Events Created")) {
				
				strCount++;
				strCheck = true;

			}

		}
		assertTrue(strCheck&&strCount==1,
				"'MRE Events Created' column is not exists in generated Report or repeated more then one time");

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
