package requirementGroup.Reports;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Properties;

import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.SelectRegion;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

import org.testng.annotations.Test;

public class EdgeCaseAdminReports extends TestNG_UI_EXTENSIONS {
	public EdgeCaseAdminReports() throws Exception {
		super();
	}
	/*********************************************************************************
	 * 'Description :Verify that admin users are not listed in the 'Users With
	 *               No Role In Region' report.
	 *    'Date     :19-01-2015 
	 *   'Author    :Hanumegowda
	 **********************************************************************************/
	@Test(description = " Verify that admin users are not listed in the 'Users With No Role In Region' report.")
	public void testEdgeCase152271() throws Exception {
		gstrTCID = "152271";
		gstrTO = " Verify that admin users are not listed in the 'Users With No Role In Region' report. ";
		// Objects for data
		Login_data objTest_data = new Login_data();
		Report_data objReport_data = new Report_data();
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		Date_Time_settings dts = new Date_Time_settings();
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

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

		// First file variables
		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";

		System.out.println("-----Precondtion execution starts------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		objRegionDefault1.selectFrame();
		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnAdminReports();

		objReport1
				.verifyAdminReportPage()
				.verifyAdminReportLinks()
				.clickOnUsersWithNoRoleInRegion()
				.verifyUsersWithNoRoleInRegionPge()
				.selRegInUsersWithNoRoleInRegionReportPge(
						objTest_data.strRegionName).clickOnGenerateReportBtn();
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
		gstrResult = "PASS";

	}
	

}
