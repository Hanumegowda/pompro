package requirementGroup.Reports;

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

public class HappyDayStatusDetailReport extends TestNG_UI_EXTENSIONS {

	public HappyDayStatusDetailReport() throws Exception {
		super();
	}
	
	/*********************************************************************************
	'Description : Verify that 'Status Detail' report for date status type displays the appropriate data.
	'Precondition:
	'Date	 	 : 04-Mar-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that 'Status Detail' report for date status type displays the appropriate data.")
	public void testHappyDay155101() throws Exception {

		gstrTCID = "155101";
		gstrTO = "Verify that 'Status Detail' report for date status type displays the appropriate data.";
		
		// Objects for data
		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		boolean blnTest = false;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName1 = file + "\\" + "TC155101_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC155101_2" + "_" + strTimeText
				+ fileType1;		
		String strDownloadName3 = file + "\\" + "TC155101_3" + "_" + strTimeText
				+ fileType;
		String strDownloadName4 = file + "\\" + "TC155101_4" + "_" + strTimeText
				+ fileType1;

		System.out.println(strDownloadName1);
		System.out.println(strDownloadName2);
		System.out.println(strDownloadName3);
		System.out.println(strDownloadName4);
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);
		
		// create private status type
				objStatusTypeList.createPrivateStatusType(
						objStatusTypes_data.strDateStatusType,
						objStatusTypes_data.strDateStatusTypeName1,
						objStatusTypes_data.strStatusDescription);
				
		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
		objResource.navigateToResourceListPage()
				   .createResourceWithAddress(
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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		String strApplicationDate = objEventManagement.getApplicationTimeWithCSTCDT();
		String[] strDate3 = strApplicationDate.split(" ");
		String strCurrentDate = dts.getCurrentDate("dd");
		String strStartDate = "";
		int intDate = Integer.parseInt(strDate3[0]);
		int intCurrentDate = Integer.parseInt(strCurrentDate);
		
		if (intDate == intCurrentDate) {
			strStartDate = dts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate < intCurrentDate) {
				strStartDate = dts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strStartDate = dts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		System.out
				.println("-----Precondition ends and test execution starts-------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strDateUpdateValue).clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objView_data.strDateUpdateValue);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strApplicationDate1 = objEventManagement1.getApplicationTimeWithCSTCDT();

		String[] strDate4 = strApplicationDate1.split(" ");
		String strEndDate = "";
		int intDate1 = Integer.parseInt(strDate4[0]);
		if(intDate1 == intCurrentDate){
			strEndDate = dts.getCurrentDate("MM/dd/yyyy");
		} else {
			if(intDate1 < intCurrentDate){
				strEndDate = dts.getPastDayNew(1, "MM/dd/yyyy");
			}
			else {
				strEndDate = dts.getFutureDay(1, "MM/dd/yyyy");
			}
		}

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selStatusType(objStatuTypes_data.strDateStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strDateStatusTypeName)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();

		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		double fltDurationDiff = (double) intDurationDiff / 3600;

		double dRounded = dts.roundTwoDecimals(fltDurationDiff);

		String strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("PDF generation duration " + strDurationDiffPDF);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file1 = new File(strDownloadName1);
		boolean strPdf1 = file1.exists();

		if (strPdf1) {
			String[] strTestData = {
					"155101",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strDateStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",strStartDate,strEndDate,
					strDurationDiffPDF , objView_data.strDateUpdateValue};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selStatusType(objStatuTypes_data.strDateStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strDateStatusTypeName)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"M/dd/yyyy HH:mm");

		System.out.println(strRequiredAppEndTimeForExcel);
		
		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					"155101",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					 objLogin_data.strRegionName,
					objStatusTypes_data.strDateStatusTypeName,
					"", objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					strExcelDurationDiffPDF,
					objReport_data.ExternalIP,strDownloadName2,strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel, objView_data.strDateUpdateValue};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		
		// For private status type
		objNavigationToSubMenus1.clickOnViewMenu().navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[1])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[1],
						objView_data.strDateUpdateFutureValue).clickOnSaveButton();

		String strUpdatedTime1 = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime1 = objMap
				.getUpdatedTime(objView_data.strDateUpdateFutureValue);
		String[] strTime1 = strUpdatedDateTime1.split(" ");
		String[] strDate1 = strTime[0].split("\\(");

		String strRequiredUpdatedTime1 = dts.converDateFormat(strDate1[0]
				+ strTime1[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel1 = dts.converDateFormat(
				strRequiredUpdatedTime1, "dd-MMM-yyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selStatusType(objStatuTypes_data.strDateStatusTypeName1)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strDateStatusTypeName1)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime1 = objEventManagement1.getApplicationTime();

		String[] strAppTime1 = strFetchAppDateTime1.split(" ");

		String strRequiredAppEndTime1 = dts.converDateFormat(strAppTime1[0]
				+ strAppTime1[1] + strCurYear + " " + strAppTime1[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff1 = dts.getTimeDiff1(strReportGeneratedtime1,
				strUpdatedTime1);

		double fltDurationDiff1 = (double) intDurationDiff1 / 3600;

		double dRounded1 = dts.roundTwoDecimals(fltDurationDiff1);

		String strDurationDiffPDF1 = Double.toString(dRounded1);

		System.out.println("PDF generation duration " + strDurationDiffPDF1);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName3,
				strAutoITName);
		
		File file3 = new File(strDownloadName3);
		boolean strPdf2 = file3.exists();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate)
				.selStatusType(objStatuTypes_data.strDateStatusTypeName1)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strDateStatusTypeName1)
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel1 = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel1 = strFetchAppDateTimeForExcel1.split(" ");

		String strRequiredAppEndTimeForExcel1 = dts.converDateFormat(
				strAppTimeForExcel1[0] + strAppTimeForExcel1[1] + strCurYear
						+ " " + strAppTimeForExcel1[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		int intExcelDurationDiff1 = dts.getTimeDiff1(
				strExcelReportGeneratedtime1, strUpdatedTime1);

		double fltExcelDurationDiff1 = (double) intExcelDurationDiff1 / 3600;

		double dExcelRounded1 = dts.roundTwoDecimals(fltExcelDurationDiff1);

		String strExcelDurationDiffPDF1 = Double.toString(dExcelRounded1);

		System.out.println("CSV generation duration "
				+ strExcelDurationDiffPDF1);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName4,
				strAutoITName);

		File file4 = new File(strDownloadName4);
		boolean strCsv2 = file4.exists();

		blnTest = true;

		if (strPdf2) {
			String[] strTestData = {
					"155101",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strDateStatusTypeName1, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime1,
					strDownloadName3, strRequiredAppEndTime1, "", "",strStartDate,strEndDate,
					strDurationDiffPDF1 , objView_data.strDateUpdateValue};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		if (strCsv2) {
			String[] strTestDataForExcel = {
					"155101",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
							 objLogin_data.strRegionName,
					objStatusTypes_data.strDateStatusTypeName1,
					"", objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					strExcelDurationDiffPDF1,
					objReport_data.ExternalIP,strDownloadName4,strRequiredUpdatedTimeForExcel1,
					strRequiredAppEndTimeForExcel1, objView_data.strDateUpdateFutureValue};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		
		objLogin1.clickLogOut();

		if(strPdf1 && strPdf2 && strCsv1 && strCsv2){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
}