package requirementGroup.Reports;

import static org.testng.Assert.*;

import java.io.File;
import java.util.Properties;

import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusReason_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusReasonList;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewHappyDayStatusReasonSummary extends TestNG_UI_EXTENSIONS {

	public NewHappyDayStatusReasonSummary() throws Exception {
		super();
	}

	/*************************************************************************************************************
	'Description :  Add a multi status type MST back to resource RS with the status reason and update the status 
	                value of RS, generate the ‘Status Reason Summary Report’ and verify that the data is displayed 
	                appropriately in the report
	'Date	 	 : 07-Jul-2015
	'Author		 : Renushree
	'------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************************************/
	@Test(description = "Add a multi status type MST back to resource RS with the status reason and update the status value of RS, generate the ‘Status Reason Summary Report’ and verify that the data is displayed appropriately in the report")
	public void testHappyDay37559() throws Exception {

		gstrTCID = "37559";
		gstrTO = "Add a multi status type MST back to resource RS with the status reason and update the status value of RS, generate the ‘Status Reason Summary Report’ and verify that the data is displayed appropriately in the report";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strReasonVal[] = new String[2];

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
		Resource objResource1 = new Resource(this.driver1);

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_1" + "_"
				+ strTimeText + fileType;
		String strDownloadName2 = file + "\\" + "TC" + gstrTCID + "_2" + "_"
				+ strTimeText + fileType1;

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubMenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);
		
		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName1,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[1] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName1);

		objStatusTypeList.navigateToStatusTypeListNew().clickCreateNewStatusTypeButton()
		.selectStatusType(objStatuTypes_data.strMultiStatusType)
		.clickNextButton()
		.enterStatusTypeName(objStatuTypes_data.strMSTStatusTypeName)
		.enterStatusTypeDescription(
				objStatuTypes_data.strStatusDescription)
		.selectStatusReason(strReasonVal[0])
		.clickOnSaveButton();
		System.out.println(objStatuTypes_data.strMSTStatusTypeName);
		objStatusTypeList.clickOnCreateNewStatus()
		.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
		.selectStatusReasonForStatus(strReasonVal[0])
		.clickOnSaveButton()

		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.clickOnCreateNewStatus()
		.enterStatusName(objStatuTypes_data.strStatusNameInMulti1)
		.selectStatusReasonForStatus(strReasonVal[0])
		.clickOnSaveButton()

				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();		
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

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
		
		System.out.println(objResource_data.strResourceName);

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectReportStatusReasonSummaryOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();

		String[] strOneStatus = { strStatusTypeValues[0] };

		objResource1.selectStatusType(strOneStatus).clickOnSaveButton();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[1])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[0], strStatusesValues[1])
				.clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti1);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts.converDateFormat(
				strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm", "M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strReportDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");
		
		objReport1.clickOnStatusReasonSummaryLink()
			.verifyStatusReasonSummaryPage1()
		  .enterReportStartDate(strReportDate)
		  .enterReportEndDate(strReportDate)
		  .selectResources(strResourceValue[0]).clickOnNextBtn()
		  .verifyStatusReasonSummaryPage2()
		  .selStatusType(objStatuTypes_data.strMSTStatusTypeName)
		  .clickOnNextBtn()
		  .verifyStatusReasonSummaryPage3()
		  .selStatusReason(strReasonVal[0], strStatusesValues[1])
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
		
		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file1 = new File(strDownloadName1);
		boolean strPdf1 = file1.exists();

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonSummaryLink()
		.selectDataFileCommaSepatatedCSVRadioBtn()
		  .enterReportStartDate(strReportDate)
		  .enterReportEndDate(strReportDate)
		  .selectResources(strResourceValue[0]).clickOnNextBtn()
		  .selStatusType(objStatuTypes_data.strMSTStatusTypeName)
		  .clickOnNextBtn()
		  .selStatusReason(strReasonVal[0], strStatusesValues[1])
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
		
		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();

		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strMSTStatusTypeName, "",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF, objReport_data.ExternalIP,
					strDownloadName2, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1 && strCsv1);

		if (strPdf1 && strCsv1) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}
	
	/*************************************************************************************************
	'Description : Update status of a multi status type MST with a status reason where MST is added at
	               the resource level for resource RS. Verify that a user with ‘Run Report’ and 'View 
	               Resource' rights right on RS and with a role with only VIEW right for MST can view 
	               the details of selected reason in the generated ‘Status Reason Summary Report’.
	'Date	 	 : 07-July-2014
	'Author		 : Anitha
	'-------------------------------------------------------------------------------------------------
	'Modified Date			                        	                 Modified By
	'Date					                                             Name
	**************************************************************************************************/
	@Test(description = "Update status of a multi status type MST with a status reason where MST is added at the "
			+ "resource level for resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights "
			+ "right on RS and with a role with only VIEW right for MST can view the details of selected reason"
			+ " in the generated ‘Status Reason Summary Report’.")
	public void testHappyDay42739() throws Exception {

		gstrTCID = "42739";
		gstrTO = "Update status of a multi status type MST with a status reason where MST is added at the resource"
				+ " level for resource RS. Verify that a user with ‘Run Report’ and 'View Resource' rights right"
				+ " on RS and with a role with only VIEW right for MST can view the details of selected reason "
				+ "in the generated ‘Status Reason Summary Report’.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strReasonVal[] = new String[2];

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

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_1" + "_"
				+ strTimeText + fileType;
		String strDownloadName2 = file + "\\" + "TC" + gstrTCID + "_2" + "_"
				+ strTimeText + fileType1;
		
		System.out.println("--------precondition starts----------");

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName1,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[1] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName1);

		objStatusTypeList
				.navigateToStatusTypeListNew()
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal[0]).clickOnSaveButton();
		System.out.println(objStatuTypes_data.strMSTStatusTypeName);
		objStatusTypeList
				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal[0])
				.clickOnSaveButton()

				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList
				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti1)
				.selectStatusReasonForStatus(strReasonVal[0])
				.clickOnSaveButton()

				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

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

		System.out.println(objResource_data.strResourceName);
		
		objResource
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource.verEditResourceLevelStatusTypesPageisDisplayed();

		String[] strOneStatus = { strStatusTypeValues[0] };

		objResource.selectStatusType(strOneStatus).clickOnSaveButton();

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonSummaryOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("--------Precondition ends and test execution starts---------");

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
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[1])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[0],
						strStatusesValues[1]).clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti1);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts.converDateFormat(
				strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm", "M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strReportDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");

		objReport1.clickOnStatusReasonSummaryLink()
				.verifyStatusReasonSummaryPage1()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selectResources(strResourceValue[0]).clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verifyStatusReasonSummaryPage3()
				.selStatusReason(strReasonVal[0], strStatusesValues[1])
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

		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file1 = new File(strDownloadName1);
		boolean strPdf1 = file1.exists();

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonSummaryLink()
				.selectDataFileCommaSepatatedCSVRadioBtn()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selectResources(strResourceValue[0]).clickOnNextBtn()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn()
				.selStatusReason(strReasonVal[0], strStatusesValues[1])
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

		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();

		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strMSTStatusTypeName, "",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF, objReport_data.ExternalIP,
					strDownloadName2, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1 && strCsv1);

		if (strPdf1 && strCsv1) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}
	
	/*************************************************************************************************
	'Description : Update status of a multi private status type pMST with a status reason where pMST is 
					added at the resource level for resource RS. Verify that a user with ‘Run Report’ and 'View Resource' 
					rights right on RS and without any role can view the details of selected reason in the generated ‘Status Reason Summary Report’.
	'Date	 	 : 08-July-2014
	'Author		 : Renushree
	'-------------------------------------------------------------------------------------------------
	'Modified Date			                        	                 Modified By
	'Date					                                             Name
	**************************************************************************************************/
	@Test(description = "Update status of a multi private status type pMST with a status reason where pMST is "
			+ "added at the resource level for resource RS. Verify that a user with ‘Run Report’ and 'View Resource' "
			+ "rights right on RS and without any role can view the details of selected reason in the generated ‘Status Reason Summary Report’.")
	public void testHappyDay48857() throws Exception {

		gstrTCID = "48857";
		gstrTO = "Update status of a multi private status type pMST with a status reason where pMST is "
				+ "added at the resource level for resource RS. Verify that a user with ‘Run Report’ and 'View Resource' "
				+ "rights right on RS and without any role can view the details of selected reason in the generated ‘Status Reason Summary Report’.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strReasonVal[] = new String[2];

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

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_1" + "_"
				+ strTimeText + fileType;
		String strDownloadName2 = file + "\\" + "TC" + gstrTCID + "_2" + "_"
				+ strTimeText + fileType1;
		
		System.out.println("--------precondition starts----------");

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName1,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[1] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName1);

		objStatusTypeList
				.navigateToStatusTypeListNew()
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strpMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectPrivateStatusTypeRadioBtn()
				.selectStatusReason(strReasonVal[0]).clickOnSaveButton();
		System.out.println(objStatuTypes_data.strpMSTStatusTypeName);
		objStatusTypeList
				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal[0])
				.clickOnSaveButton()

				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList
				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti1)
				.selectStatusReasonForStatus(strReasonVal[0])
				.clickOnSaveButton()

				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

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

		System.out.println(objResource_data.strResourceName);
		
		objResource
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource.verEditResourceLevelStatusTypesPageisDisplayed();

		String[] strOneStatus = { strStatusTypeValues[0] };

		objResource.selectStatusType(strOneStatus).clickOnSaveButton();

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonSummaryOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("--------Precondition ends and test execution starts---------");

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
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[1])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[0],
						strStatusesValues[1]).clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti1);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts.converDateFormat(
				strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm", "M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strReportDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");

		objReport1.clickOnStatusReasonSummaryLink()
				.verifyStatusReasonSummaryPage1()
				.selectResources(strResourceValue[0])
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				.clickOnNextBtn().verifyStatusReasonSummaryPage3()
				.selStatusReason(strReasonVal[0], strStatusesValues[1])
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

		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file1 = new File(strDownloadName1);
		boolean strPdf1 = file1.exists();

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strpMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonSummaryLink()
				.selectDataFileCommaSepatatedCSVRadioBtn()
				.selectResources(strResourceValue[0])
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.clickOnNextBtn()
				.selStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				.clickOnNextBtn()
				.selStatusReason(strReasonVal[0], strStatusesValues[1])
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

		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();

		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strpMSTStatusTypeName, "",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF, objReport_data.ExternalIP,
					strDownloadName2, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1 && strCsv1);

		if (strPdf1 && strCsv1) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}
	
	/*************************************************************************************************
	'Description : Update status of a multi status type MST with a status reason where MST is added at the 
	resource type level for resource RS. Verify that a user with ‘Run Report’ & 'View Resource' rights on RS 
	and with a role with only VIEW right for MST can view the details of selected reason in the generated ‘Status Reason Summary Report’.
	'Date	 	 : 08-July-2014
	'Author		 : Renushree
	'-------------------------------------------------------------------------------------------------
	'Modified Date			                        	                 Modified By
	'Date					                                             Name
	**************************************************************************************************/
	@Test(description = "Update status of a multi status type MST with a status reason where MST is added at the "
			+ "resource type level for resource RS. Verify that a user with ‘Run Report’ & 'View Resource' rights on RS "
			+ "and with a role with only VIEW right for MST can view the details of selected reason in the generated ‘Status Reason Summary Report’.")
	public void testHappyDay42742() throws Exception {

		gstrTCID = "42742";
		gstrTO = "Update status of a multi status type MST with a status reason where MST is added at the "
				+ "resource type level for resource RS. Verify that a user with ‘Run Report’ & 'View Resource' rights on RS "
				+ "and with a role with only VIEW right for MST can view the details of selected reason in the generated ‘Status Reason Summary Report’.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strReasonVal[] = new String[2];

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

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_1" + "_"
				+ strTimeText + fileType;
		String strDownloadName2 = file + "\\" + "TC" + gstrTCID + "_2" + "_"
				+ strTimeText + fileType1;
		
		System.out.println("--------precondition starts----------");

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName1,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[1] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName1);

		objStatusTypeList
				.navigateToStatusTypeListNew()
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal[0]).clickOnSaveButton();
		System.out.println(objStatuTypes_data.strMSTStatusTypeName);
		objStatusTypeList
				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal[0])
				.clickOnSaveButton()
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList
				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti1)
				.selectStatusReasonForStatus(strReasonVal[0])
				.clickOnSaveButton()

				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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

		System.out.println(objResource_data.strResourceName);
		
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonSummaryOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("--------Precondition ends and test execution starts---------");

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
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[1])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[0],
						strStatusesValues[1]).clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti1);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts.converDateFormat(
				strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm", "M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strReportDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");

		objReport1.clickOnStatusReasonSummaryLink()
				.verifyStatusReasonSummaryPage1()
				.selectResources(strResourceValue[0])
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verifyStatusReasonSummaryPage3()
				.selStatusReason(strReasonVal[0], strStatusesValues[1])
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

		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file1 = new File(strDownloadName1);
		boolean strPdf1 = file1.exists();

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonSummaryLink()
				.selectDataFileCommaSepatatedCSVRadioBtn()
				.selectResources(strResourceValue[0])
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.clickOnNextBtn()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn()
				.selStatusReason(strReasonVal[0], strStatusesValues[1])
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

		Thread.sleep(3000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();

		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strMSTStatusTypeName, "",
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "",
					strExcelDurationDiffPDF, objReport_data.ExternalIP,
					strDownloadName2, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel,
					objStatusTypes_data.strStatusNameInMulti1 };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}
		objLogin1.clickLogOut();
		assertTrue(strPdf1 && strCsv1);

		if (strPdf1 && strCsv1) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}
	
	/**************************************************************************************************
	'Description : Verify that, status reason details of a status type is not displayed in the 'Status Reason Summary' report for a particular resource for which it is refined.
	'Date	 	 : 12-Feb-2016
	'Author		 : Renushree
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                   Modified By
	'Date					                                               Name
	***************************************************************************************************/
	@Test(description = "Verify that, status reason details of a status type is not displayed in the 'Status Reason Summary' report for a particular resource for which it is refined.")
	public void testHappyDay63426() throws Exception {

		gstrTCID = "63426";
		gstrTO = "Verify that, status reason details of a status type is not displayed in the 'Status Reason Summary' report for a particular resource for which it is refined.";

		Login_data objLogin_data = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		UsersList objUsersList = new UsersList(this.driver1);
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType2 = objReport_data.csvFile;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName = file + "\\" + "TC42745_1" + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + "TC42745_2" + "_" + strTimeText
				+ fileType2;

		String strDownloadName2 = file + "\\" + "TC42745_2" + "_" + strTimeText
				+ fileType;

		String strDownloadName3 = file + "\\" + "TC42745_3" + "_" + strTimeText
				+ fileType2;

		String strStatusTypeValues[] = new String[2];
		String strStatusTypeValues1[] = new String[1];
		String strResourceValue[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strStatusesValues1[] = new String[1];
		String strReasonVal[] = new String[2];
		String strReasonVal1[] = new String[1];
		String strRoleValue[] = new String[2];

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName1,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[1] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName1);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName2,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal1[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName2);

		objStatusTypeList
				.navigateToStatusTypeListNew()
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal[0]).clickOnSaveButton();

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal[0])
				.clickOnSaveButton();
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
				
				
		objStatusTypeList		
		 .createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
			      objStatusTypes_data.strStatusColor)
  
	     .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti2);	      
		 
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strMSTStatusTypeName1)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal[1]).clickOnSaveButton();

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti1)
				.selectStatusReasonForStatus(strReasonVal[1])
				.clickOnSaveButton();
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList		
		 .createNewStatus(objStatusTypes_data.strStatusNameInMulti3,
			      objStatusTypes_data.strStatusColor)
 
	     .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti3);	

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strMSTStatusTypeName2)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal1[0]).clickOnSaveButton();

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti2)
				.selectStatusReasonForStatus(strReasonVal1[0])
				.clickOnSaveButton();
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,
			      objStatusTypes_data.strStatusColor)

			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti3);
		
		strStatusesValues1[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName2);

		// Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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

		objResource.createResourceWithAddress(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		System.out.println(objResource_data.strResourceName);

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.verEditResourceLevelStatusTypesPageisDisplayed()
				.selectStatusType(strStatusTypeValues1).clickOnSaveButton();

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName1)
				.verEditResourceLevelStatusTypesPageisDisplayed()
				.selectStatusType(strStatusTypeValues1).clickOnSaveButton();

		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayViewsec()
				.deselectStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues1)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1).clickOnSaveBtn();

		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);
		System.out.println(objRolesData.strRoleName1);

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonSummaryOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectRoleCheckBox(strRoleValue[1])
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		System.out
				.println("---------Precondition ends and test execution starts-----------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[1])
				.selectMSTReasonValue(strReasonVal[1], strStatusTypeValues[1],
						strStatusesValues[1])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues1[0])
				.selectMSTReasonValue(strReasonVal1[0],
						strStatusTypeValues1[0], strStatusesValues1[0])
				.clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap1
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts.converDateFormat(
				strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm", "M/dd/yyyy HH:mm");

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName1)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[1])
				.selectMSTReasonValue(strReasonVal[1], strStatusTypeValues[1],
						strStatusesValues[1])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues1[0])
				.selectMSTReasonValue(strReasonVal1[0],
						strStatusTypeValues1[0], strStatusesValues1[0])
				.clickOnSaveButton();

		String strUpdatedTime1 = dts.timeNow("HH:mm:ss");

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName1);

		String strUpdatedDateTime1 = objMap1
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti);
		String[] strTime1 = strUpdatedDateTime1.split(" ");
		String[] strDate1 = strTime1[0].split("\\(");

		String strRequiredUpdatedTime1 = dts.converDateFormat(strDate1[0]
				+ strTime1[1] + strCurYear + " " + strTime1[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel1 = dts
				.converDateFormat(strRequiredUpdatedTime1, "dd-MMM-yyyy HH:mm",
						"M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.navigateToUsers();

		String strST[] = { strStatusTypeValues[1] };
		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickRefineLinkOfViewResource(objResource_data.strResourceName)
				.selectFrameOfRefineVisibleStatusTypes()
				.deselectStatusTypesInRefine(strST)
				.deselectStatusTypesInRefine(strStatusTypeValues1)
				.clickSaveChangesButtonInRefine().switchToDefaultFrame()
				.selectFrame().clickOnUsernameField();
		Thread.sleep(2000);
		objUsersList1.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnStatusReports();

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strCurrentDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");

		objReport1.clickOnStatusReasonSummaryLink()
				.verifyStatusReasonSummaryPage1()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectResources(strResourceValue[1]).clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName1)
				.clickOnNextBtn().verifyStatusReasonSummaryPage3()
				.selStatusReason(strReasonVal[1], strStatusesValues[1])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();

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

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonSummaryLink()
				.verifyStatusReasonSummaryPage1()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectResources(strResourceValue[1])
				.selectExcelReportRadioBtn().clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName1)
				.clickOnNextBtn().verifyStatusReasonSummaryPage3()
				.selStatusReason(strReasonVal[1], strStatusesValues[1])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file2 = new File(strDownloadName1);
		boolean strCsv1 = file2.exists();

		String strExcelReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel1 = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel1 = strFetchAppDateTimeForExcel1.split(" ");

		String strRequiredAppEndTimeForExcel1 = dts.converDateFormat(
				strAppTimeForExcel1[0] + strAppTimeForExcel1[1] + strCurYear
						+ " " + strAppTimeForExcel1[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		int intExcelDurationDiff1 = dts.getTimeDiff1(
				strExcelReportGeneratedtime1, strUpdatedTime);

		double fltExcelDurationDiff1 = (double) intExcelDurationDiff1 / 3600;

		double dExcelRounded1 = dts.roundTwoDecimals(fltExcelDurationDiff1);

		String strExcelDurationDiffPDF1 = Double.toString(dExcelRounded1);

		System.out.println("CSV generation duration "
				+ strExcelDurationDiffPDF1);

		String strVerUpdatedTime = strRequiredUpdatedTime;

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + ","
							+ objUserdata.strNewUserName1 + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName + ","
							+ objResource_data.strResourceName1,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName + ","
							+ objStatusTypes_data.strMSTStatusTypeName1 + ","
							+ objStatusTypes_data.strMSTStatusTypeName2,
					"",
					"",
					objReport_data.strExtIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName,
					strRequiredAppEndTime,
					objStatusReason_data.strReasonName + ","
							+ objStatusReason_data.strReasonName1 + ","
							+ objStatusReason_data.strReasonName2,
					objStatusTypes_data.strStatusNameInMulti + ","
							+ objStatusTypes_data.strStatusNameInMulti1 + ","
							+ objStatusTypes_data.strStatusNameInMulti2,
					strStartAndEndDate,
					strStartAndEndDate,
					strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti1,
					"Verify only" + objStatusTypes_data.strMSTStatusTypeName1
							+ " is dispalyed only for resource "
							+ objResource_data.strResourceName1 + "" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + ","
							+ objUserdata.strNewUserName1 + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strMSTStatusTypeName + ","
							+ objStatusTypes_data.strMSTStatusTypeName1 + ","
							+ objStatusTypes_data.strMSTStatusTypeName2,
					objStatusTypes_data.strStatusNameInMulti + ","
							+ objStatusTypes_data.strStatusNameInMulti1 + ","
							+ objStatusTypes_data.strStatusNameInMulti2,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName + ","
							+ objResource_data.strResourceName1,
					"",
					"",
					objStatusReason_data.strReasonName + ","
							+ objStatusReason_data.strReasonName1 + ","
							+ objStatusReason_data.strReasonName2,
					strExcelDurationDiffPDF1,
					objReport_data.strExtIP,
					strDownloadName1,
					strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel1,
					objStatusTypes_data.strStatusNameInMulti1,
					"Verify only" + objStatusTypes_data.strMSTStatusTypeName1
							+ " is dispalyed only for resource "
							+ objResource_data.strResourceName1 + "" };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonSummaryLink()
				.verifyStatusReasonSummaryPage1()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectResources(strResourceValue[1]).clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName2)
				.clickOnNextBtn().verifyStatusReasonSummaryPage3()
				.selStatusReason(strReasonVal1[0], strStatusesValues1[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file3 = new File(strDownloadName2);
		boolean strPdf2 = file3.exists();

		String strReportGeneratedtime2 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime2 = objEventManagement1.getApplicationTime();

		String[] strAppTime2 = strFetchAppDateTime2.split(" ");

		String strRequiredAppEndTime2 = dts.converDateFormat(strAppTime2[0]
				+ strAppTime2[1] + strCurYear + " " + strAppTime2[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff2 = dts.getTimeDiff1(strReportGeneratedtime2,
				strUpdatedTime1);

		double fltDurationDiff2 = (double) intDurationDiff2 / 3600;

		double dRounded2 = dts.roundTwoDecimals(fltDurationDiff2);

		String strDurationDiffPDF2 = Double.toString(dRounded2);
		System.out.println("PDF generation duration " + strDurationDiffPDF2);

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonSummaryLink()
				.verifyStatusReasonSummaryPage1()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectResources(strResourceValue[1])
				.selectExcelReportRadioBtn().clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName2)
				.clickOnNextBtn().verifyStatusReasonSummaryPage3()
				.selStatusReason(strReasonVal1[0], strStatusesValues1[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName3,
				strAutoITName);

		File file4 = new File(strDownloadName3);
		boolean strCsv2 = file4.exists();

		String strExcelReportGeneratedtime2 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel2 = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel2 = strFetchAppDateTimeForExcel2.split(" ");

		String strRequiredAppEndTimeForExcel2 = dts.converDateFormat(
				strAppTimeForExcel2[0] + strAppTimeForExcel2[1] + strCurYear
						+ " " + strAppTimeForExcel2[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		int intExcelDurationDiff2 = dts.getTimeDiff1(
				strExcelReportGeneratedtime2, strUpdatedTime);

		double fltExcelDurationDiff2 = (double) intExcelDurationDiff2 / 3600;

		double dExcelRounded2 = dts.roundTwoDecimals(fltExcelDurationDiff2);

		String strExcelDurationDiffPDF2 = Double.toString(dExcelRounded2);
		
		System.out.println("CSV generation duration "
				+ strExcelDurationDiffPDF2);

		if (strPdf2) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName + ","
							+ objResource_data.strResourceName1,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName + ","
							+ objStatusTypes_data.strMSTStatusTypeName1 + ","
							+ objStatusTypes_data.strMSTStatusTypeName2,
					"",
					"",
					objReport_data.strExtIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName2,
					strRequiredAppEndTime2,
					objStatusReason_data.strReasonName + ","
							+ objStatusReason_data.strReasonName1 + ","
							+ objStatusReason_data.strReasonName2,
					objStatusTypes_data.strStatusNameInMulti + ","
							+ objStatusTypes_data.strStatusNameInMulti1 + ","
							+ objStatusTypes_data.strStatusNameInMulti2,
					strStartAndEndDate,
					strStartAndEndDate,
					strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti2,
					"Verify only" + objStatusTypes_data.strMSTStatusTypeName2
							+ " is dispalyed only for resource "
							+ objResource_data.strResourceName1 + "" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		if (strCsv2) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword + ","
							+ objUserdata.strNewUserName1 + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strMSTStatusTypeName + ","
							+ objStatusTypes_data.strMSTStatusTypeName1 + ","
							+ objStatusTypes_data.strMSTStatusTypeName2,
					objStatusTypes_data.strStatusNameInMulti + ","
							+ objStatusTypes_data.strStatusNameInMulti1 + ","
							+ objStatusTypes_data.strStatusNameInMulti2,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName + ","
							+ objResource_data.strResourceName1,
					"",
					"",
					objStatusReason_data.strReasonName + ","
							+ objStatusReason_data.strReasonName1 + ","
							+ objStatusReason_data.strReasonName2,
					strExcelDurationDiffPDF1,
					objReport_data.strExtIP,
					strDownloadName1,
					strRequiredUpdatedTimeForExcel1,
					strRequiredAppEndTimeForExcel2,
					objStatusTypes_data.strStatusNameInMulti2,
					"Verify only" + objStatusTypes_data.strMSTStatusTypeName2
							+ " is dispalyed only for resource "
							+ objResource_data.strResourceName1 + "" };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		if (strCsv1 && strCsv2 && strPdf1 && strPdf2) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}
}
