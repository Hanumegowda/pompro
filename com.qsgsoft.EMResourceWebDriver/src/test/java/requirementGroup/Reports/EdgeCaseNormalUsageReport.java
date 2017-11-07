package requirementGroup.Reports;
import static org.testng.Assert.*;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import lib.dataObject.BlankFormData;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.ActivateForms;
import lib.page.ApplicationUsageReportsMenu;
import lib.page.AutoIT;
import lib.page.BlankForm;
import lib.page.DispatchForm;
import lib.page.EventManagement;
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.CSVFunctions;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseNormalUsageReport extends TestNG_UI_EXTENSIONS
{

 public EdgeCaseNormalUsageReport() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
 
 /***********************************************************************************************
	'Description : Verify that the Nrmal Usage report cannot be generated without providing start and end dates. 
	'Date	 	 : 15-May-2015
	'Author		 : Sangappa.k
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description = "Verify that the Nrmal Usage report cannot be generated without providing start and end dates. .")
	public void testEdgeCase162329() throws Exception {

		gstrTCID = "162329";
		gstrTO = "Verify that the Nrmal Usage report cannot be generated without providing start and end dates. ";
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
	    Report objReports=new Report(this.driver1);
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToApplicationUsageReports();
		objReports.verifyApplicationUsageReportsMenuPage()
		                               .clickOnNormalUsage()
		                               .verifyAppUsgNonAdmPage()
		                               .clickOnGenerateReportBtn1()
		                               .verErrorMsgWithoutSatrtAndEndDate();                         
		objLogin.clickLogOut();                        
		gstrResult = "PASS";
}
	
	/***********************************************************************************************
	'Description : Verify that the report cannot be generated if only Start date is provided.  
	'Date	 	 : 18-May-2015
	'Author		 : Hanumegowda
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description = "Verify that the report cannot be generated if only Start date is provided.")
	public void testEdgeCase162323() throws Exception {

		gstrTCID = "162323";
		gstrTO = "Verify that the report cannot be generated if only Start date is provided.";
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ApplicationUsageReportsMenu objApplicationUsageReportsMenu = new ApplicationUsageReportsMenu(
				this.driver1);
		Report objReport = new Report(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		objNavigationToSubmenus.clickOnReports();
		objReport.verApplicationUsageReportsIsDisplayed()
				.clickOnApplicationUsageReports();
		objApplicationUsageReportsMenu
				.verApplicationUsageReportsPageIsDisplayed()
				.clickOnNormalUsage();

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

		String strStartDate1 = objDts.AddDaytoExistingDate(strStartDate, -1,
				"MM/dd/yyyy");
		System.out.println(strStartDate);
		System.out.println(strStartDate1);

		objApplicationUsageReportsMenu
				.verApplicationUsageReportNonAdministrativePageIsDisplayed();
		objApplicationUsageReportsMenu.enterStartDate(strStartDate1);

		objReport.clickOnGenerateReportBtn();
		objApplicationUsageReportsMenu.verEndDateRequiredErrorMsg();

		objLogin.clickLogOut();
		gstrResult = "PASS";

	}
	
	/***********************************************************************************************
	'Description : Verify that the report cannot be generated if only End date is provided.  
	'Date	 	 : 19-May-2015
	'Author		 : Hanumegowda
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description = "Verify that the report cannot be generated if only End date is provided.")
	public void testEdgeCase162322() throws Exception {

		gstrTCID = "162322";
		gstrTO = "Verify that the report cannot be generated if only End date is provided.";
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ApplicationUsageReportsMenu objApplicationUsageReportsMenu = new ApplicationUsageReportsMenu(
				this.driver1);
		Report objReport = new Report(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		objNavigationToSubmenus.clickOnReports();
		objReport.verApplicationUsageReportsIsDisplayed()
				.clickOnApplicationUsageReports();
		objApplicationUsageReportsMenu
				.verApplicationUsageReportsPageIsDisplayed()
				.clickOnNormalUsage();

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

		String strStartDate1 = objDts.AddDaytoExistingDate(strStartDate, -1,
				"MM/dd/yyyy");
		System.out.println(strStartDate);
		System.out.println(strStartDate1);

		objApplicationUsageReportsMenu
				.verApplicationUsageReportNonAdministrativePageIsDisplayed();
		objApplicationUsageReportsMenu.enterEndDate(strStartDate);

		objReport.clickOnGenerateReportBtn();
		objApplicationUsageReportsMenu.verStartDateRequiredErrorMsg();

		objLogin.clickLogOut();
		gstrResult = "PASS";

	}
	/***********************************************************************************************
	'Description :Verify that the report cannot be generated if End date provided is earlier than the Start date. . 
	'Date	 	 : 19-May-2015
	'Author		 : Sangappa.k
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description ="Verify that the report cannot be generated if End date provided is earlier than the Start date.")
	public void testEdgeCase162319() throws Exception {

		gstrTCID = "162319";
		gstrTO ="Verify that the report cannot be generated if End date provided is earlier than the Start date.";
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
	    Report objReports=new Report(this.driver1);
	    EventManagement objEventManagement = new EventManagement(this.driver1);
	    ApplicationUsageReportsMenu objApplicationUsageReportsMenu = new ApplicationUsageReportsMenu(
				driver1);
		Date_Time_settings objDts = new Date_Time_settings();
	    
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		
		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToApplicationUsageReports();
		
		String strApplicationTime = objEventManagement.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		String strStartDate = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");
		String strEndDate = objDts.AddDaytoExistingDate(strStartDate, -2,
				"MM/dd/yyyy");
		
		System.out.println(strEndDate);
		System.out.println(strEndDate);
		
		if(strStartDate.equals(strEndDate))
		{
		strEndDate =  objDts.AddDaytoExistingDate(strStartDate, -2,
				"MM/dd/yyyy");
		}
		
		objReports.verifyApplicationUsageReportsMenuPage();
		                      objReports.clickOnNormalUsage()
		                              .verifyAppUsgNonAdmPage();
		  objApplicationUsageReportsMenu.enterStartDate(strStartDate)
				                         .enterEndDate(strEndDate);
		                   objReports.clickOnGenerateReportBtn1()
		                               .verErrorTextStarDateMayNoteLaterThanToday();                         
		objLogin.clickLogOut();  
		gstrResult = "PASS";
		
		}	

	/***********************************************************************************************
	'Description :Verify that the report can be generated by selecting the time period as
                  Single day.
                  Month
                  Year 
	'Date	 	 : 19-May-2015
	'Author		 : Sangappa.k
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description = "Verify that the report can be generated by selecting the time period as"
                 +" Single day."
                 +"Month"
                 + "Year ")
	public void testEdgeCase162546() throws Exception {

		gstrTCID = "162546";
		gstrTO = "Verify that the report can be generated by selecting the time period as"
                +" Single day."
                +"Month"
                + "Year ";
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Report objReports = new Report(this.driver1);
		ApplicationUsageReportsMenu objApplicationUsageReportsMenu = new ApplicationUsageReportsMenu(
				driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Report_data objReport_data = new Report_data();
		Date_Time_settings Dts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strTimeText = objDts.getCurrentDate(objReport_data.dateFormat1);

		PathsProperties objAP = new PathsProperties();
		String fileType = objReport_data.csvFile;
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Properties pathProps = objAP.ReadAutoit_FilePath();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String steFutureTimetext = Dts.AddTimeToExistingTimeHourAndMin(
				strTimeText, 1, 5, "MM-dd-yyyy-HHmmss");

		String strDownloadName2 = file + "\\" + "TC" + gstrTCID + "_"
				+ steFutureTimetext + fileType;

		String steFutureTimetext1 = Dts.AddTimeToExistingTimeHourAndMin(
				strTimeText, 1, 7, "MM-dd-yyyy-HHmmss");

		String strDownloadName3 = file + "\\" + "TC" + gstrTCID + "_"
				+ steFutureTimetext1 + fileType;

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToApplicationUsageReports();

		String strApplicationTime = objEventManagement.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		String strEndDate = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");
		String strStartDate = objDts.AddDaytoExistingDate(strEndDate, -1,
				"MM/dd/yyyy");

		System.out.println(strStartDate);
		System.out.println(strEndDate);

		if (strStartDate == strEndDate) {
			strStartDate = objDts.AddDaytoExistingDate(strEndDate, -1,
					"MM/dd/yyyy");
		}

		objReports.verifyApplicationUsageReportsMenuPage().clickOnNormalUsage()
				.verifyAppUsgNonAdmPage();
		objApplicationUsageReportsMenu.enterStartDate(strStartDate)
				.enterEndDate(strEndDate);
		objReports.clickOnGenerateReportBtn1();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		File file1 = new File(strDownloadName1);
		boolean strCsv1 = file1.exists();
		if (strCsv1) {

			String[] strTestDataForExcel = { "Non-Administrative", "161066",
					Login_data.strBuildName, objLogindata.strRegionName,
					strStartDate, strEndDate, objReport_data.ExternalIP,
					strDownloadName1 };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		Thread.sleep(10000);
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objReports.clickOnNormalUsage().verifyAppUsgNonAdmPage();

		String strStartDate1[] = strStartDate.split("/");

		Integer x = Integer.valueOf(strStartDate1[0]);
		x = x - 1;
		String y = String.valueOf(x);

		String strStartMonth = y + "/" + strStartDate1[1] + "/"
				+ strStartDate1[2];
		String strEndMonth = strEndDate;

		System.out.println("start  month" + strStartMonth);
		System.out.println("end month" + strEndMonth);

		objApplicationUsageReportsMenu.enterStartDate(strStartMonth)
				.enterEndDate(strEndMonth);
		objReports.clickOnGenerateReportBtn1();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
		Thread.sleep(10000);
		File file2 = new File(strDownloadName2);
		boolean strCsv2 = file2.exists();

		if (strCsv2) {

			String[] strTestDataForExcel = { "Non-Administrative", "161066",
					Login_data.strBuildName, objLogindata.strRegionName,
					strStartMonth, strEndMonth, objReport_data.ExternalIP,
					strDownloadName2 };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		Thread.sleep(10000);
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objReports.clickOnNormalUsage().verifyAppUsgNonAdmPage();

		String strStartYear1[] = strStartDate.split("/");

		Integer x1 = Integer.valueOf(strStartYear1[2]);
		x1 = x1 - 1;
		String y1 = String.valueOf(x1);

		String strStartYear = strStartYear1[0] + "/" + strStartYear1[1] + "/"
				+ y1;
		String strEndYear = strEndDate;

		System.out.println("start Year" + strStartYear);
		System.out.println("end Year" + strEndYear);

		objApplicationUsageReportsMenu.enterStartDate(strStartYear)
				.enterEndDate(strEndYear);
		objReports.clickOnGenerateReportBtn1();
		
		Thread.sleep(10000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName3,
				strAutoITName);
		File file3 = new File(strDownloadName3);
		boolean strCsv3 = file3.exists();

		if (strCsv3) {

			String[] strTestDataForExcel = { "Non-Administrative", "161066",
					Login_data.strBuildName, objLogindata.strRegionName,
					strStartYear, strEndYear, objReport_data.ExternalIP,
					strDownloadName3 };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		if (strCsv1 && strCsv2 && strCsv3) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}

		Thread.sleep(10000);
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin.clickLogOut();
		
		

	}

	/***********************************************************************************************
	'Description : Verify that the report cannot be generated if Start date provided is later than the current date.  
	'Date	 	 : 20-May-2015
	'Author		 : Hanumegowda
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description = "Verify that the report cannot be generated if Start date provided is later than the current date.")
	public void testEdgeCase162303() throws Exception {

		gstrTCID = "162303";
		gstrTO = "Verify that the report cannot be generated if Start date provided is later than the current date.";
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ApplicationUsageReportsMenu objApplicationUsageReportsMenu = new ApplicationUsageReportsMenu(
				this.driver1);
		Report objReport = new Report(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		objNavigationToSubmenus.clickOnReports();
		objReport.verApplicationUsageReportsIsDisplayed()
				.clickOnApplicationUsageReports();
		objApplicationUsageReportsMenu
				.verApplicationUsageReportsPageIsDisplayed()
				.clickOnNormalUsage();

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

		String strStartDate1 = objDts.AddDaytoExistingDate(strStartDate, 2,
				"MM/dd/yyyy");
		System.out.println(strStartDate);
		System.out.println(strStartDate1);

		objApplicationUsageReportsMenu
				.verApplicationUsageReportNonAdministrativePageIsDisplayed();
		objApplicationUsageReportsMenu.enterStartDate(strStartDate1)
				.enterEndDate(strStartDate);

		objReport.clickOnGenerateReportBtn();
		objApplicationUsageReportsMenu
				.verStartDateMayNotBeLaterThanTodayErrorMsg();

		objLogin.clickLogOut();
		gstrResult = "PASS";

	}
	
	/***********************************************************************************************
	'Description : Cancel the process of generating the report and verify that the report is not generated.  
	'Date	 	 : 18-May-2015
	'Author		 : Sangappa.k
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description = "Cancel the process of generating the report and verify that the report is not generated. ")
	public void testEdgeCase162282() throws Exception {

		gstrTCID = "162282";
		gstrTO = "Cancel the process of generating the report and verify that the report is not generated. ";
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ApplicationUsageReportsMenu objApplicationUsageReportsMenu = new ApplicationUsageReportsMenu(
				this.driver1);
		Report objReport = new Report(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		String strTimeText = objDts.getCurrentDate(objReport_data.dateFormat1);
		PathsProperties objAP = new PathsProperties();

		String fileType = objReport_data.csvFile;

		Properties pathProps = objAP.ReadAutoit_FilePath();

		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		objNavigationToSubmenus.navigateToApplicationUsageReports();
		objApplicationUsageReportsMenu
				.verApplicationUsageReportsPageIsDisplayed()
				.clickOnNormalUsage();

		String strApplicationTime = objEventManagement.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		String strEndDate = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");

		String strStartDate = objDts.AddDaytoExistingDate(strEndDate, -2,
				"MM/dd/yyyy");

		System.out.println(strStartDate);
		System.out.println(strEndDate);

		objApplicationUsageReportsMenu
				.verApplicationUsageReportNonAdministrativePageIsDisplayed();
		objApplicationUsageReportsMenu.enterStartDate(strStartDate)
				.enterEndDate(strEndDate);

		objReport.clickOnCancelBtn();
		objApplicationUsageReportsMenu
				.verApplicationUsageReportsPageIsDisplayed();

		File file2 = new File(strDownloadName1);

		if (!file2.exists())

		{
          objLogin.clickLogOut();
		  gstrResult = "PASS";

		} else {
		 gstrResult = "FAIL";
		}

	}
	
	/***********************************************************************************************
	'Description : Verify that details about "Roles rights grid" and "Users with no role in the region" report details are not available in the 'Normal Usage' report.   
	'Date	 	 : 2-July-2015
	'Author		 : Sangappa.k
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description = "Verify that details about ' Roles rights grid' and 'Users with no role' in the region report details are not available in the 'Normal Usage' report. ")
	public void testEdgeCase162394() throws Exception {

		gstrTCID = "162394";
		gstrTO = "Verify that details about 'Roles rights grid' and 'Users with no role' in the region report details are not available in the 'Normal Usage' report. ";
		
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
		User_data objUserdata = new User_data();
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Report objReport1 = new Report(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		ApplicationUsageReportsMenu objApplicationUsageReportsMenu1= new ApplicationUsageReportsMenu(driver1);

		Date_Time_settings objDts1 = new Date_Time_settings();

		System.out.println(objUserdata.strNewUserName);

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
	
		String strStartDate=objDts1.AddDaytoExistingDate(strEndDate, -7, "MM/dd/yyyy");
		
		objApplicationUsageReportsMenu1
		  .verApplicationUsageReportsPageIsDisplayed()
		  .clickOnNormalUsage()
		.verApplicationUsageReportNonAdministrativePageIsDisplayed()
				.enterStartDate(strStartDate)
				.enterEndDate(strEndDate);
			objReport1.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		int intCount = 0;
		
	File file1 =new File(strDownloadName);

	assertTrue(file1.exists(),"file not found");

	String strHeaders[]=objReport_data.AppUsageHeaders;
	
	String strData=objCSVFunctions.readCSVFileData(strDownloadName,5);
	
	System.out.println(strData);
	
	String[] CsvData   =  strData.split(",");
	
	for(intCount=0;intCount<=strHeaders.length-1;intCount++)
	{
	
			assertNotEquals(CsvData[intCount], "Users With No Role In Region",
					"'Users With No Role In Region' column is exsist in generatted report");
			
		    assertNotEquals(CsvData[intCount], "Roles Rights Grid",
					"'Roles Rights Grid' column is exsist in generatted report");
	
	}
	
	objLogin1.clickLogOut();
	
	gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	'Description : Verify that details about "Roles rights grid" and "Users with no role in the region" report details are available in the 'Admin Usage' report   
	'Date	 	 : 3-July-2015
	'Author		 : Sangappa.k
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description ="Verify that details about 'Roles rights grid' and 'Users with no role in the region' report details are available in the 'Admin Usage' report ")
	public void testEdgeCase160606() throws Exception {

		gstrTCID ="160606";
		gstrTO ="Verify that details about 'Roles rights grid' and 'Users with no role in the region' report details are available in the 'Admin Usage' report ";
		
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
		User_data objUserdata = new User_data();

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

		System.out.println(objUserdata.strNewUserName);

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

		String strStartDate = objDts1.AddDaytoExistingDate(strEndDate, -7,
				"MM/dd/yyyy");

		objApplicationUsageReportsMenu1
				.verApplicationUsageReportsPageIsDisplayed();

		objReport1.clickOnAdminUsage().enterStartDateOfAdminUsage(strStartDate)
				.enterEndDateOfAdminUsage(strEndDate)
		         .clickOutSide();
		objReport1.clickOnGenerateReportBtn();
		
		System.out.println("dsff");

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		int intCount = 0;

		File file1 = new File(strDownloadName);

		assertTrue(file1.exists(), "file not found");

		String strHeaders[] = objReport_data.AppUsageHeaders2;

		String strData = objCSVFunctions.readCSVFileData(strDownloadName, 5);

		System.out.println(strData);

		boolean strCheack1 = false, strCheack2 = false;

		String[] CsvData = strData.split(",");

		for (intCount = 0; intCount <= strHeaders.length - 1; intCount++) {

			if (CsvData[intCount]
					.equals("Reports: Users With No Role In Region")) {

				strCheack1 = true;

			} else if (CsvData[intCount].equals("Reports: Roles Rights Grid")) {

				strCheack2 = true;
			}

		}

		assertTrue(
				strCheack1 && strCheack2,
				"'Reports: Users With No Role In Region' AND 'Reports: Roles Rights Grid' not exist in generated Report");

		objLogin1.clickLogOut();

		gstrResult = "PASS";

	}

}
	
	
	
	

