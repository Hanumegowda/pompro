package requirementGroup.Reports;

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

public class NewStatusReasonDetailReport extends TestNG_UI_EXTENSIONS {

	public NewStatusReasonDetailReport() throws Exception {
		super();
	}

	/*********************************************************************************
	'Description : Verify that a 'Status Reason Detail' report can be generated.
	'Precondition:
	'Date	 	 : 24-Jun-2015
	'Author		 : Anil
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Generate 'Status Reason Detail report' in PDF format and verify that the report displays correct data")
	public void testHappyDay103967() throws Exception {

		gstrTCID = "103967";
		gstrTO = "Generate 'Status Reason Detail report' in PDF format and verify that the report displays correct data";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
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
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		StatusReason_data objStatusReason_data = new StatusReason_data();
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strStatusesValues1[] = new String[2];
		String strStatusesValues2[] = new String[2];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
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
		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strDownloadName1 = file + "\\" + "TC1" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strDownloadName2 = file + "\\" + "TC2" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strReasonVal[] = new String[2];

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
				.createPrivateStatusTypeWithReason(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strpMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription, strReasonVal)
				.createNewStatusWithReason(
						objStatusTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatusWithReason(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpMSTStatusTypeName);

		objStatusTypeList
				.createSharedStatusTypeWithReason(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strsMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription, strReasonVal)
				.createNewStatusWithReason(
						objStatusTypes_data.strStatusNameInMulti2,
						objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2);
		strStatusesValues1[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		objStatusTypeList.createNewStatusWithReason(
				objStatusTypes_data.strStatusNameInMulti3,
				objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti3);
		strStatusesValues1[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		objStatusTypeList.clickOnReturnToStatusTypeList();
		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsMSTStatusTypeName);

		objStatusTypeList
				.createStatusTypeWithReason(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription, strReasonVal)
				.createNewStatusWithReason(
						objStatusTypes_data.strStatusNameInMulti4,
						objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti4);
		strStatusesValues2[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti4);

		objStatusTypeList.createNewStatusWithReason(
				objStatusTypes_data.strStatusNameInMulti5,
				objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti5);
		strStatusesValues2[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti5);

		objStatusTypeList.clickOnReturnToStatusTypeList();
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.verifyRegionalMapViewPgeIsDisplayed();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[0],
						strStatusesValues[0])

				.selectStatusTypes(strStatusTypeValues[1])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues1[1])
				.selectMSTReasonValue(strReasonVal[1], strStatusTypeValues[1],
						strStatusesValues1[1])

				.selectStatusTypes(strStatusTypeValues[2])
				.selectMSTUpdateValue(strStatusTypeValues[2],
						strStatusesValues2[0])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[2],
						strStatusesValues2[0]).clickOnSaveButton();

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
		//
		// objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
		// strStatusTypeValues[0], objStatusTypes_data.strStatusNameInMulti);
		//
		// objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
		// strStatusTypeValues[1], objStatusTypes_data.strStatusNameInMulti3);
		//
		// objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
		// strStatusTypeValues[2], objStatusTypes_data.strStatusNameInMulti4);

		objNavigationToSubMenus1.clickOnStatusReports();

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strCurrentDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed().verifyStartDate()
				.verifyEndDate().verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn().enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				.verifyNextBtn().verCancelButton().clickOnNextBtn()
				.verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[0], strStatusesValues[0])
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
		//
		// String strCurrentDate = dts.timeNow("MM/dd/yyyy");
		// String strStartAndEndDate = dts
		// .converDateFormat(strCurrentDate, "MM/dd/yyyy",
		// "dd-MMM-yyyy");

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed().verifyStartDate()
				.verifyEndDate().verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn().enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).verifyNextBtn()
				.verCancelButton().clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strsMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[1], strStatusesValues1[1])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file2 = new File(strDownloadName1);
		boolean strPdf2 = file2.exists();

		String strReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime1 = objEventManagement1.getApplicationTime();

		String[] strAppTime1 = strFetchAppDateTime1.split(" ");

		String strRequiredAppEndTime1 = dts.converDateFormat(strAppTime1[0]
				+ strAppTime1[1] + strCurYear + " " + strAppTime1[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff1 = dts.getTimeDiff1(strReportGeneratedtime1,
				strUpdatedTime);

		double fltDurationDiff1 = (double) intDurationDiff1 / 3600;

		double dRounded2 = dts.roundTwoDecimals(fltDurationDiff1);

		String strDurationDiffPDF2 = Double.toString(dRounded2);
		System.out.println("PDF generation duration " + strDurationDiffPDF2);

		String strVerUpdatedTime = strRequiredUpdatedTime;

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed().verifyStartDate()
				.verifyEndDate().verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn().enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).verifyNextBtn()
				.verCancelButton().clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[0], strStatusesValues2[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file3 = new File(strDownloadName2);
		boolean strPdf3 = file3.exists();

		String strReportGeneratedtime2 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime2 = objEventManagement1.getApplicationTime();

		String[] strAppTime2 = strFetchAppDateTime2.split(" ");

		String strRequiredAppEndTime2 = dts.converDateFormat(strAppTime2[0]
				+ strAppTime2[1] + strCurYear + " " + strAppTime2[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff2 = dts.getTimeDiff1(strReportGeneratedtime2,
				strUpdatedTime);

		double fltDurationDiff2 = (double) intDurationDiff2 / 3600;

		double dRounded3 = dts.roundTwoDecimals(fltDurationDiff2);

		String strDurationDiffPDF3 = Double.toString(dRounded3);
		System.out.println("PDF generation duration " + strDurationDiffPDF3);

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strpMSTStatusTypeName,
					"",
					"",
					objReport_data.ExternalIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName,
					strRequiredAppEndTime,
					objStatusReason_data.strReasonName,
					objStatusTypes_data.strStatusNameInMulti + ","
							+ objStatusTypes_data.strStatusNameInMulti1,
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");

		}
		if (strPdf2) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strsMSTStatusTypeName,
					"",
					"",
					objReport_data.ExternalIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName1,
					strRequiredAppEndTime1,
					objStatusReason_data.strReasonName1,
					objStatusTypes_data.strStatusNameInMulti2 + ","
							+ objStatusTypes_data.strStatusNameInMulti3,
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti3 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");

		}

		if (strPdf3) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName,
					"",
					"",
					objReport_data.ExternalIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName2,
					strRequiredAppEndTime2,
					objStatusReason_data.strReasonName,
					objStatusTypes_data.strStatusNameInMulti4 + ","
							+ objStatusTypes_data.strStatusNameInMulti5,
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti4 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");

		}

		objLogin1.clickLogOut();

		if (strPdf1 && strPdf2 && strPdf3) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}

	/**********************************************************************************************************************
	'Description : Generate 'Status Reason Detail report' in CSV format and verify that the report displays correct data.
	'Date	 	 : 24-Jun-2015
	'Author		 : Anil
	'----------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***********************************************************************************************************************/
	@Test(description = " Generate 'Status Reason Detail report' in CSV format and verify that the report displays correct data.")
	public void testHappyDay103968() throws Exception {

		gstrTCID = "103968";
		gstrTO = " Generate 'Status Reason Detail report' in CSV format and verify that the report displays correct data.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
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
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		StatusReason_data objStatusReason_data = new StatusReason_data();
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strStatusesValues1[] = new String[2];
		String strStatusesValues2[] = new String[2];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
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
		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strDownloadName1 = file + "\\" + "TC1" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strDownloadName2 = file + "\\" + "TC2" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strReasonVal[] = new String[2];

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
				.createPrivateStatusTypeWithReason(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strpMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription, strReasonVal)
				.createNewStatusWithReason(
						objStatusTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatusWithReason(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpMSTStatusTypeName);

		objStatusTypeList
				.createSharedStatusTypeWithReason(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strsMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription, strReasonVal)
				.createNewStatusWithReason(
						objStatusTypes_data.strStatusNameInMulti2,
						objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2);
		strStatusesValues1[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		objStatusTypeList.createNewStatusWithReason(
				objStatusTypes_data.strStatusNameInMulti3,
				objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti3);
		strStatusesValues1[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		objStatusTypeList.clickOnReturnToStatusTypeList();
		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsMSTStatusTypeName);

		objStatusTypeList
				.createStatusTypeWithReason(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription, strReasonVal)
				.createNewStatusWithReason(
						objStatusTypes_data.strStatusNameInMulti4,
						objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti4);
		strStatusesValues2[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti4);

		objStatusTypeList.createNewStatusWithReason(
				objStatusTypes_data.strStatusNameInMulti5,
				objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti5);
		strStatusesValues2[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti5);

		objStatusTypeList.clickOnReturnToStatusTypeList();
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

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

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.verifyRegionalMapViewPgeIsDisplayed();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[0],
						strStatusesValues[0])

				.selectStatusTypes(strStatusTypeValues[1])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues1[1])
				.selectMSTReasonValue(strReasonVal[1], strStatusTypeValues[1],
						strStatusesValues1[1])

				.selectStatusTypes(strStatusTypeValues[2])
				.selectMSTUpdateValue(strStatusTypeValues[2],
						strStatusesValues2[0])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[2],
						strStatusesValues2[0]).clickOnSaveButton();

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
		//
		// objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
		// strStatusTypeValues[0], objStatusTypes_data.strStatusNameInMulti);
		//
		// objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
		// strStatusTypeValues[1], objStatusTypes_data.strStatusNameInMulti3);
		//
		// objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
		// strStatusTypeValues[2], objStatusTypes_data.strStatusNameInMulti4);

		objNavigationToSubMenus1.clickOnStatusReports();

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strCurrentDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed().verifyStartDate()
				.verifyEndDate().verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn().selectCSVRadioBtn()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				.verifyNextBtn().verCancelButton().clickOnNextBtn()
				.verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[0], strStatusesValues[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		File file1 = new File(strDownloadName);
		boolean strCSV1 = file1.exists();

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
		//
		// String strCurrentDate = dts.timeNow("MM/dd/yyyy");
		// String strStartAndEndDate = dts
		// .converDateFormat(strCurrentDate, "MM/dd/yyyy",
		// "dd-MMM-yyyy");

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed().verifyStartDate()
				.verifyEndDate().verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn().selectCSVRadioBtn()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).verifyNextBtn()
				.verCancelButton().clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strsMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[1], strStatusesValues1[1])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file2 = new File(strDownloadName1);
		boolean strCSV2 = file2.exists();

		String strReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime1 = objEventManagement1.getApplicationTime();

		String[] strAppTime1 = strFetchAppDateTime1.split(" ");

		String strRequiredAppEndTime1 = dts.converDateFormat(strAppTime1[0]
				+ strAppTime1[1] + strCurYear + " " + strAppTime1[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff1 = dts.getTimeDiff1(strReportGeneratedtime1,
				strUpdatedTime);

		double fltDurationDiff1 = (double) intDurationDiff1 / 3600;

		double dRounded2 = dts.roundTwoDecimals(fltDurationDiff1);

		String strDurationDiffPDF2 = Double.toString(dRounded2);
		System.out.println("PDF generation duration " + strDurationDiffPDF2);

		String strVerUpdatedTime = strRequiredUpdatedTime;

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed().verifyStartDate()
				.verifyEndDate().verifyPDFOptionIsSelected()
				.verifyCSVRadioBtn().selectCSVRadioBtn()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).verifyNextBtn()
				.verCancelButton().clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[0], strStatusesValues2[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file3 = new File(strDownloadName2);
		boolean strCSV3 = file3.exists();

		String strReportGeneratedtime2 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime2 = objEventManagement1.getApplicationTime();

		String[] strAppTime2 = strFetchAppDateTime2.split(" ");

		String strRequiredAppEndTime2 = dts.converDateFormat(strAppTime2[0]
				+ strAppTime2[1] + strCurYear + " " + strAppTime2[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff2 = dts.getTimeDiff1(strReportGeneratedtime2,
				strUpdatedTime);

		double fltDurationDiff2 = (double) intDurationDiff2 / 3600;

		double dRounded3 = dts.roundTwoDecimals(fltDurationDiff2);

		String strDurationDiffPDF3 = Double.toString(dRounded3);
		System.out.println("PDF generation duration " + strDurationDiffPDF3);

		if (strCSV1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strpMSTStatusTypeName,
					"",
					"",
					objReport_data.ExternalIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName,
					strRequiredAppEndTime,
					objStatusReason_data.strReasonName,
					objStatusTypes_data.strStatusNameInMulti + ","
							+ objStatusTypes_data.strStatusNameInMulti1,
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "CSVDetails");

		}
		if (strCSV2) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strsMSTStatusTypeName,
					"",
					"",
					objReport_data.ExternalIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName1,
					strRequiredAppEndTime1,
					objStatusReason_data.strReasonName1,
					objStatusTypes_data.strStatusNameInMulti2 + ","
							+ objStatusTypes_data.strStatusNameInMulti3,
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti3 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "CSVDetails");

		}

		if (strCSV3) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName,
					"",
					"",
					objReport_data.ExternalIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName2,
					strRequiredAppEndTime2,
					objStatusReason_data.strReasonName,
					objStatusTypes_data.strStatusNameInMulti4 + ","
							+ objStatusTypes_data.strStatusNameInMulti5,
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti4 };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "CSVDetails");

		}

		objLogin1.clickLogOut();

		if (strCSV1 && strCSV2 && strCSV3) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
		System.out.println(gstrResult);
	}

	/**************************************************************************************************
	'Description : Update status of a multi status type MST with a status reason where MST is added at
	               the resource level for resource RS. Verify that a user with ‘Run Report’ & 'View 
	               Resource' rights on RS and with a role with only VIEW right for MST can view the 
	               details of selected reason in the generated ‘Status Reason Detail Report’.
	'Date	 	 : 08-July-2014
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                   Modified By
	'Date					                                               Name
	***************************************************************************************************/
	@Test(description = "Update status of a multi status type MST with a status reason where MST is added at the"
			+ " resource level for resource RS. Verify that a user with ‘Run Report’ & 'View Resource' rights "
			+ "on RS and with a role with only VIEW right for MST can view the details of selected reason in"
			+ " the generated ‘Status Reason Detail Report’.")
	public void testHappyDay42745() throws Exception {

		gstrTCID = "42745";
		gstrTO = "Update status of a multi status type MST with a status reason where MST is added at the resource"
				+ " level for resource RS. Verify that a user with ‘Run Report’ & 'View Resource' rights on RS "
				+ "and with a role with only VIEW right for MST can view the details of selected reason in "
				+ "the generated ‘Status Reason Detail Report’.";

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

		String strDownloadName1 = file + "\\" + "TC42745_2" + "_"
				+ strTimeText + fileType2;
		
		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strReasonVal[] = new String[1];
		String strRoleValue[] = new String[1];

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

		objStatusTypeList
				.navigateToStatusTypeListNew()
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal[0]).clickOnSaveButton();

		objStatusTypeList
				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal[0])
				.clickOnSaveButton();
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
      objStatusTypeList
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
					  objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		//Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

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
		
		System.out.println(objResource_data.strResourceName);
		
		objResource
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource.verEditResourceLevelStatusTypesPageisDisplayed();

		String[] strOneStatus = { strStatusTypeValues[0] };

		objResource.selectStatusType(strOneStatus).clickOnSaveButton();
		
		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
                .clickSaveButton()
                .verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();
		
		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("---------Precondition ends and test execution starts-----------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[0],
						strStatusesValues[0]).clickOnSaveButton();

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
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnStatusReports();

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strCurrentDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[0], strStatusesValues[0])
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

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectExcelReportRadioBtn().clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[0], strStatusesValues[0])
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
					"42745",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName,
					"",
					"",
					objReport_data.ExternalIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName,
					strRequiredAppEndTime,
					objStatusReason_data.strReasonName,
					objStatusTypes_data.strStatusNameInMulti,
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		if (strCsv1) {
			String[] strTestDataForExcel = {
					"42745",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strMSTStatusTypeName,
					objStatusTypes_data.strStatusNameInMulti,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "",
					objStatusReason_data.strReasonName,
					strExcelDurationDiffPDF1, objReport_data.ExternalIP,
					strDownloadName1, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel1,
					objStatusTypes_data.strStatusNameInMulti };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		objLogin1.clickLogOut();

		if (strPdf1 && strCsv1) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
		System.out.println(gstrResult);
	}
	
	/**************************************************************************************************
	'Description :  Update status of a multi status type MST with a status reason where MST is added at 
	                the resource type level for resource RS. Verify that a user with ‘Run Report’ &'View 
	                Resource' rights on RS and with a role with only VIEW right for MST can view the
	                 details of selected reason in the generated ‘Status Reason Detail Report’.
	'Date	 	 : 08-July-2014
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                   Modified By
	'Date					                                               Name
	***************************************************************************************************/
	@Test(description = " Update status of a multi status type MST with a status reason where MST is added at "
			+ "the resource type level for resource RS. Verify that a user with ‘Run Report’ & 'View Resource'"
			+ " rights on RS and with a role with only VIEW right for MST can view the details of selected reason"
			+ " in the generated ‘Status Reason Detail Report’.")
	public void testHappyDay42748() throws Exception {

		gstrTCID = "42748";
		gstrTO = " Update status of a multi status type MST with a status reason where MST is added at the resource "
				+ "type level for resource RS. Verify that a user with ‘Run Report’ & 'View Resource' rights on RS"
				+ " and with a role with only VIEW right for MST can view the details of selected reason in the"
				+ " generated ‘Status Reason Detail Report’.";

		Login_data objLogin_data = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		Roles_data objRolesData = new Roles_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);	

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
		String strDownloadName = file + "\\" + "TC42748_1" + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + "TC42748_2" + "_"
				+ strTimeText + fileType2;
		
		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strReasonVal[] = new String[1];
		String strRoleValue[] = new String[1];

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

		objStatusTypeList
				.navigateToStatusTypeListNew()
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal[0]).clickOnSaveButton();

		objStatusTypeList
				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal[0])
				.clickOnSaveButton();
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

       objStatusTypeList
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
					  objStatuTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		//Resource Type
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
		
		System.out.println(objResource_data.strResourceName);
		

		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
                .clickSaveButton()
                .verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		
		System.out.println("---------Precondition ends and test execution starts-----------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[0],
						strStatusesValues[0]).clickOnSaveButton();

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
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnStatusReports();

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strCurrentDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[0], strStatusesValues[0])
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

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectExcelReportRadioBtn().clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[0], strStatusesValues[0])
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
					"42748",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName,
					"",
					"",
					objReport_data.ExternalIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName,
					strRequiredAppEndTime,
					objStatusReason_data.strReasonName,
					objStatusTypes_data.strStatusNameInMulti,
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		if (strCsv1) {
			String[] strTestDataForExcel = {
					"42748",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strMSTStatusTypeName,
					objStatusTypes_data.strStatusNameInMulti ,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "",
					objStatusReason_data.strReasonName,
					strExcelDurationDiffPDF1, objReport_data.ExternalIP,
					strDownloadName1, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel1,
					objStatusTypes_data.strStatusNameInMulti };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		objLogin1.clickLogOut();

		if (strPdf1 && strCsv1) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
		System.out.println(gstrResult);
	}
	
	/**************************************************************************************************
	'Description : Update status of a multi private status type pMST with a status reason where pMST is 
	               added at the resource level for resource RS. Verify that a user with ‘Run Report’ & 
	               'View Resource' rights on RS and without any role can view the details of selected 
	               reason in the generated ‘Status Reason Detail Report’.
	'Date	 	 : 08-July-2014
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                   Modified By
	'Date					                                               Name
	***************************************************************************************************/
	@Test(description = "Update status of a multi private status type pMST with a status reason where pMST "
			+ "is added at the resource level for resource RS. Verify that a user with ‘Run Report’ & 'View"
			+ " Resource' rights on RS and without any role can view the details of selected reason in the "
			+ "generated ‘Status Reason Detail Report’.")
	public void testHappyDay48860() throws Exception {

		gstrTCID = "48860";
		gstrTO = "Update status of a multi private status type pMST with a status reason where pMST is added at"
				+ " the resource level for resource RS. Verify that a user with ‘Run Report’ & 'View Resource' "
				+ "rights on RS and without any role can view the details of selected reason in the generated "
				+ "‘Status Reason Detail Report’.";

		Login_data objLogin_data = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);		
		UsersList objUsersList = new UsersList(this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);	

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
		String strDownloadName = file + "\\" + "TC48860_1" + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + "TC48860_2" + "_"
				+ strTimeText + fileType2;
		
		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strReasonVal[] = new String[1];

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
		
		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal[0])
				.clickOnSaveButton();
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		   objStatusTypeList
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
					objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
						  objStatuTypes_data.strStatusNameInMulti1);
			
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		//Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

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
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
		        .clickSaveButton()
		        .verifyUserListPageIsDisplayed();
		
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();
		
		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("---------Precondition ends and test execution starts-----------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[0],
						strStatusesValues[0]).clickOnSaveButton();

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
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnStatusReports();

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strCurrentDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[0], strStatusesValues[0])
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

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectExcelReportRadioBtn().clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strpMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[0], strStatusesValues[0])
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
					"48860",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strpMSTStatusTypeName,
					"",
					"",
					objReport_data.ExternalIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName,
					strRequiredAppEndTime,
					objStatusReason_data.strReasonName,
					objStatusTypes_data.strStatusNameInMulti,
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		if (strCsv1) {
			String[] strTestDataForExcel = {
					"48860",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strpMSTStatusTypeName,
					objStatusTypes_data.strStatusNameInMulti,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "",
					objStatusReason_data.strReasonName,
					strExcelDurationDiffPDF1, objReport_data.ExternalIP,
					strDownloadName1, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel1,
					objStatusTypes_data.strStatusNameInMulti };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		objLogin1.clickLogOut();

		if (strPdf1 && strCsv1) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}
	
	/**************************************************************************************************
	'Description : Add a multi status type MST back to resource RS with the status reason and update the
	               status value of RS, generate the ‘Status Reason Detail Report’ and verify that the 
	               data is displayed appropriately in the report.
	'Date	 	 : 08-July-2014
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                   Modified By
	'Date					                                               Name
	***************************************************************************************************/
	@Test(description = "Add a multi status type MST back to resource RS with the status reason and update "
			+ "the status value of RS, generate the ‘Status Reason Detail Report’ and verify that the data"
			+ " is displayed appropriately in the report.")
	public void testHappyDay88954() throws Exception {

		gstrTCID = "88954";
		gstrTO = "Add a multi status type MST back to resource RS with the status reason and update the status"
				+ " value of RS, generate the ‘Status Reason Detail Report’ and verify that the data is "
				+ "displayed appropriately in the report";

		Login_data objLogin_data = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);		
		UsersList objUsersList = new UsersList(this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Map objMap1 = new Map(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);	

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
		String strDownloadName = file + "\\" + "TC88954_1" + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + "TC88954_2" + "_"
				+ strTimeText + fileType2;
		
		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strReasonVal[] = new String[1];

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
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
					objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
						  objStatuTypes_data.strStatusNameInMulti1);
			

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		//Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

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
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
		        .selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectEditResourcesOnlyOption()
				.selectReportStatusReasonDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();
		
		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("---------Precondition ends and test execution starts-----------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();

		objResource1.deselectStatusType(strOneStatus)

		.clickOnSaveButton();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();

		objResource1.selectStatusType(strOneStatus)

		.clickOnSaveButton();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal[0], strStatusTypeValues[0],
						strStatusesValues[0]).clickOnSaveButton();

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

		objNavigationToSubMenus1.clickOnStatusReports();

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strCurrentDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[0], strStatusesValues[0])
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

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectExcelReportRadioBtn().clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal[0], strStatusesValues[0])
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
					"88954",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName,
					"",
					"",
					objReport_data.ExternalIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName,
					strRequiredAppEndTime,
					objStatusReason_data.strReasonName,
					objStatusTypes_data.strStatusNameInMulti,
					strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF,
					objStatusTypes_data.strStatusNameInMulti };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		if (strCsv1) {
			String[] strTestDataForExcel = {
					"88954",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName,
					objStatusTypes_data.strMSTStatusTypeName,
					objStatusTypes_data.strStatusNameInMulti,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "",
					objStatusReason_data.strReasonName,
					strExcelDurationDiffPDF1, objReport_data.ExternalIP,
					strDownloadName1, strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel1,
					objStatusTypes_data.strStatusNameInMulti };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		objLogin1.clickLogOut();

		if (strPdf1 && strCsv1) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}
	
	/**************************************************************************************************
	'Description : Verify that, status reason details of a status type is not displayed in the 'Status Reason Detail' report for a particular resource for which it is refined.
	'Date	 	 : 10-Feb-2016
	'Author		 : Renushree
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                   Modified By
	'Date					                                               Name
	***************************************************************************************************/
	@Test(description = "Verify that, status reason details of a status type is not displayed in the 'Status Reason Detail' report for a particular resource for which it is refined.")
	public void testHappyDay63435() throws Exception {

		gstrTCID = "63435";
		gstrTO = "Verify that, status reason details of a status type is not displayed in the 'Status Reason Detail' report for a particular resource for which it is refined.";

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
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
					objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
						  objStatuTypes_data.strStatusNameInMulti1);
			

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
		strStatusesValues1[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		   objStatusTypeList
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
					objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
						  objStatuTypes_data.strStatusNameInMulti1);
			
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
				.selectReportStatusReasonDetailOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectRoleCheckBox(strRoleValue[1])
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

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

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectResources(strResourceValue[1]).clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName1)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
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

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectResources(strResourceValue[1])
				.selectExcelReportRadioBtn().clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName1)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
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

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectResources(strResourceValue[1]).clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName2)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
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

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectResources(strResourceValue[1])
				.selectExcelReportRadioBtn().clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName2)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
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
	