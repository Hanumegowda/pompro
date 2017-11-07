package requirementGroup.Reports;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.SelectRegion;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayAdminReports extends TestNG_UI_EXTENSIONS {

	public HappyDayAdminReports() throws Exception {
		super();
	}

	/***************************************************************************************************************
	 * 'Description :  Verify that admin user can generate 'Roles/Rights Grid' report. 
	 * 'Date        : 09-Jan-2015 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = " Verify that admin user can generate 'Roles/Rights Grid' report. ")
	public void testHappyDay152265() throws Exception {
		gstrTCID = "152265";
		gstrTO = " Verify that admin user can generate 'Roles/Rights Grid' report. ";

		// Objects for data
		Login_data objTest_data = new Login_data();
		Report_data objReport_data = new Report_data();
		Date_Time_settings dts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
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
		
		File file = new File(System.getProperty("user.dir") + fileDownloadPath) ;
		
		File autoItFiles = new File(System.getProperty("user.dir")+autoItFilesPath);
		
		//First file variables
		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file+"\\";
		
		System.out.println("-----Precondtion execution starts------");
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegion1
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
	    
		objNavigationToSubMenus1.clickOnAdminReports();
		
		objReport1.verifyAdminReportPage();
		
		objReport1.verifyAdminReportLinks();
		
		objReport1.clickOnRoleRightGrid();
		
		objReport1.clickOnGenerateReportBtn();
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName, strAutoITName);
		int intCount = 0;
		int intCount1=0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript "+autoItFiles
								+ filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath)
								.exists());
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
		
		String strValue = objOffCommonFunc.readInfoExcel("Roles-Rights Grid", 1, 1, strDownloadName1);
		assertEquals("Roles/Rights Grid" , strValue);
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that admin user can generate 'Users With No Role In Region' report. 
	 * 'Date        : 12-Jan-2015 
	 * 'Author      : Renushree
	 ***************************************************************************************************************/

	@Test(enabled= false,description = "Verify that admin user can generate 'Users With No Role In Region' report. ")
	public void testHappyDay152268() throws Exception {

		gstrTCID = "152268";
		gstrTO = "Verify that admin user can generate 'Users With No Role In Region' report. ";

		// Objects for data
		Login_data objTest_data = new Login_data();
		Report_data objReport_data = new Report_data();
		Date_Time_settings dts = new Date_Time_settings();
		User_data objUserdata = new User_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

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

		objNavigationToSubMenus1.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.clickSaveButton()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.clickSaveButton();

		objNavigationToSubMenus1.clickOnAdminReports();

		objReport1.verifyAdminReportPage().verifyAdminReportLinks()
				.clickOnUsersWithNoRoleInRegion()
				.verifyUsersWithNoRoleInRegionPge()
				.selRegInUsersWithNoRoleInRegionReportPge(objTest_data.strRegionName)
				.clickOnGenerateReportBtn();
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

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
				objTest_data.strRegionName, 1, 1, strDownloadName1);
		String strValue1 = objOffCommonFunc.readInfoExcel(
				objTest_data.strRegionName, 2, 1, strDownloadName1);
		assertEquals("Users With No Roles In " + objTest_data.strRegionName
				+ " Region", strValue);
		assertEquals("User", strValue1);

		int strRowCount = objOffCommonFunc.getRowsCountOfExceSheet(
				strDownloadName1, objTest_data.strRegionName);

		ArrayList<String> strList = new ArrayList<String>();
		for (int i = 3; i <= strRowCount; i++) {
			String strUsers = objOffCommonFunc.readInfoExcel(
					objTest_data.strRegionName, i, 1, strDownloadName1);
			strList.add(strUsers);
		}

		assertTrue(strList.contains(objUserdata.strNewUserName), "User "
				+ objUserdata.strNewUserName + " is not displayed");
		assertTrue(strList.contains(objUserdata.strNewUserName1), "User "
				+ objUserdata.strNewUserName1 + " is not displayed");
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/**************************************************************************************************
	 * 'Description : Verify that user with 'Setup-Role' right can generate 'Roles/Rights Grid' report.
	 * 'Date        : 12-Jan-2015 
	 * 'Author      : Anil
	 **************************************************************************************************/

	@Test(description = "Verify that user with 'Setup-Role' right can generate 'Roles/Rights Grid' report.")
	public void testHappyDay152266() throws Exception {
		gstrTCID = "152266";
		gstrTO = "Verify that user with 'Setup-Role' right can generate 'Roles/Rights Grid' report.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		Report_data objReport_data = new Report_data();
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
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
		
		File file = new File(System.getProperty("user.dir") + fileDownloadPath) ;
		
		File autoItFiles = new File(System.getProperty("user.dir")+autoItFilesPath);
		
		//First file variables
		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file+"\\";
		
		System.out.println("-----Precondtion execution starts------");
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.clickAdvancedOptionAndExpand()
				.selectSetUpRolesRight()
				.clickSaveButton();
		objLogin.clickLogOut();
		
		System.out.println("-----Precondtion Ends And test execution starts------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
	    
		objNavigationToSubMenus1.clickOnAdminReports();
		
		objReport1.verifyAdminReportPage();
		
		objReport1.clickOnRoleRightGrid();
		
		objReport1.clickOnGenerateReportBtn();
		
		Thread.sleep(20000);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName, strAutoITName);
		int intCount = 0;
		int intCount1=0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript "+autoItFiles
								+ filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath)
								.exists());
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
		
		String strValue = objOffCommonFunc.readInfoExcel("Roles-Rights Grid", 1, 1, strDownloadName1);
		assertEquals("Roles/Rights Grid" , strValue);
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that user with 'Setup-role' right can generate 'Users With No Role In Region' report. 
	 * 'Date        : 12-Jan-2015 
	 * 'Author      : Deepa
	 ***************************************************************************************************************/

	@Test(enabled= false,description = "Verify that user with 'Setup-role' right can generate 'Users With No Role In Region' report. ")
	public void testHappyDay152269() throws Exception {

		gstrTCID = "152269";
		gstrTO = "Verify that user with 'Setup-role' right can generate 'Users With No Role In Region' report. ";

		// Objects for data
		Login_data objTest_data = new Login_data();
		Report_data objReport_data = new Report_data();
		Date_Time_settings dts = new Date_Time_settings();
		User_data objUserdata = new User_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

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

		objNavigationToSubMenus1.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectSetUpRolesRight()
				.clickSaveButton()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.clickSaveButton()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.clickSaveButton();
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

		objNavigationToSubMenus1.clickOnAdminReports();

		objReport1.verifyAdminReportPage().verifyAdminReportLinks()
				.clickOnUsersWithNoRoleInRegion()
				.verifyUsersWithNoRoleInRegionPge()
				.selRegInUsersWithNoRoleInRegionReportPge(objTest_data.strRegionName)
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

		String strValue = objOffCommonFunc.readInfoExcel(
				objTest_data.strRegionName, 1, 1, strDownloadName1);
		String strValue1 = objOffCommonFunc.readInfoExcel(
				objTest_data.strRegionName, 2, 1, strDownloadName1);
		assertEquals("Users With No Roles In " + objTest_data.strRegionName
				+ " Region", strValue);
		assertEquals("User", strValue1);

		int strRowCount = objOffCommonFunc.getRowsCountOfExceSheet(
				strDownloadName1, objTest_data.strRegionName);

		ArrayList<String> strList = new ArrayList<String>();
		for (int i = 3; i <= strRowCount; i++) {
			String strUsers = objOffCommonFunc.readInfoExcel(
					objTest_data.strRegionName, i, 1, strDownloadName1);
			strList.add(strUsers);
		}

		assertFalse(strList.contains(objUserdata.strNewUserName), "User "
				+ objUserdata.strNewUserName + " is not displayed");
		assertTrue(strList.contains(objUserdata.strNewUserName1), "User "
				+ objUserdata.strNewUserName + " is not displayed");
		assertTrue(strList.contains(objUserdata.strNewUserName2), "User "
				+ objUserdata.strNewUserName1 + " is not displayed");
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
}
