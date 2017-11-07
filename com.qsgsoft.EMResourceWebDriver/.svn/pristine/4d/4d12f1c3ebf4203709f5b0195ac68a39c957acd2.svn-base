package requirementGroup.Reports;

import java.io.File;
import java.util.Properties;

import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
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

public class HappyDayStatusReasonDetail  extends TestNG_UI_EXTENSIONS {

	public HappyDayStatusReasonDetail() throws Exception {
		super();
	} 

	/*********************************************************************************
	'Description : Verify that sub-resources are not available while generating ' Status Reason Detail'
	'Precondition:
	'Date	 	 : 11-Dec-2014
	'Author		 : Rensuhree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that sub-resources are not available while generating ' Status Reason Detail'")
	public void testHappyDay151047() throws Exception {

		gstrTCID = "151047";
		gstrTO = "Verify that sub-resources are not available while generating ' Status Reason Detail'";

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
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceValue[] = new String[2];
		String strResourceTypeValue[] = new String[2];
		String strStatusesValues[] = new String[6];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.reportFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

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
		
		String strDownloadName = file + "\\" + "TC" + gstrTCID + ""
				+ strTimeText + fileType;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "Excel"
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

		String strReasonVal = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusTypeList
				.navigateToStatusTypeListNew()
				.createPrivateStatusType(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList
				.clickOnReturnToStatusTypeList()
				.clickOnEditOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName)
				.selectStatusReason(strReasonVal)
				.clickOnSaveButton()
				.clickOnStatusesOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName)
				.editStatusForMultiStatusType(
						objStatusTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal)
				.clickOnSaveButton()
				.editStatusForMultiStatusType(
						objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusReasonForStatus(strReasonVal).clickOnSaveButton()
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList
				.createSharedStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2);

		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti3,
				objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti3);
		strStatusesValues[3] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		objStatusTypeList
				.clickOnReturnToStatusTypeList()
				.clickOnEditOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName1)
				.selectStatusReason(strReasonVal)
				.clickOnSaveButton()
				.clickOnStatusesOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName1)
				.editStatusForMultiStatusType(
						objStatusTypes_data.strStatusNameInMulti2)
				.selectStatusReasonForStatus(strReasonVal)
				.clickOnSaveButton()
				.editStatusForMultiStatusType(
						objStatusTypes_data.strStatusNameInMulti3)
				.selectStatusReasonForStatus(strReasonVal).clickOnSaveButton()
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName2,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti4,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti4);

		strStatusesValues[4] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti4);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti5,
				objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti5);
		strStatusesValues[5] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti5);

		objStatusTypeList
				.clickOnReturnToStatusTypeList()
				.clickOnEditOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName2)
				.selectStatusReason(strReasonVal)
				.clickOnSaveButton()
				.clickOnStatusesOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName2)
				.editStatusForMultiStatusType(
						objStatusTypes_data.strStatusNameInMulti4)
				.selectStatusReasonForStatus(strReasonVal)
				.clickOnSaveButton()
				.editStatusForMultiStatusType(
						objStatusTypes_data.strStatusNameInMulti5)
				.selectStatusReasonForStatus(strReasonVal).clickOnSaveButton()
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName2);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objResourceType.createResourceType(
				objResourceType_data.strSubResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		objResourceType
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		objNavigationToSubmenus.navigateToResourceInSetup();

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

		objResource
				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.clickOnCreateNewSubResourceButton()
				.enterResourceName(objResource_data.strSubResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton()
				.verSubResourceInResourceListPage(
						objResource_data.strSubResourceName);

		strResourceValue[1] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonDetailOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
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
				.selectMSTReasonValue(strReasonVal, strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[2])
				.selectMSTReasonValue(strReasonVal, strStatusTypeValues[1],
						strStatusesValues[2])
				.selectMSTUpdateValue(strStatusTypeValues[2],
						strStatusesValues[4])
				.selectMSTReasonValue(strReasonVal, strStatusTypeValues[2],
						strStatusesValues[4]).clickOnSaveButton();

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

		objNavigationToSubMenus1.clickOnStatusReports();

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strCurrentDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.verSubResourceIsNotDisplayed(strResourceValue[1])
				.selectResources(strResourceValue[0]).clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal, strStatusesValues[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

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
				.verSubResourceIsNotDisplayed(strResourceValue[1])
				.selectResources(strResourceValue[0])
				.selectExcelReportRadioBtn().clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName1)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal, strStatusesValues[2])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		String strVerUpdatedTime = strRequiredUpdatedTime;

		blnTest = true;

		if (blnTest) {
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
		
		gstrResult = "PASS";
	}

	/*********************************************************************************
	'Description : Add a multi status type MST back to resource RS with the status reason and
	               update the status value of RS, generate the ‘Status Reason Detail Report’ and 
	               verify that the data is displayed appropriately in the report. 
	'Precondition:
	'Date	 	 : 24-Mar-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Add a multi status type MST back to resource RS with the status reason and"
			+ " update the status value of RS, generate the ‘Status Reason Detail Report’ "
			+ "and verify that the data is displayed appropriately in the report ")
	public void testHappyDay88954() throws Exception {

		gstrTCID = "88954";
		gstrTO = "Add a multi status type MST back to resource RS with the status reason and"
				+ " update the status value of RS, generate the ‘Status Reason Detail Report’ "
				+ "and verify that the data is displayed appropriately in the report ";

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
		Map objMap = new Map(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strstatusesValues[] = new String[2];
		String strStatusReasonValues[] = new String[2];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType2 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
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
		String strDownloadName = file + "\\" + gstrTCID + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + gstrTCID + "_" + strTimeText
				+ fileType2;

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strStatusReasonValues[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);
		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName1,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);
		strStatusReasonValues[1] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName1);

		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strstatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strstatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
		System.out.println(strStatusTypeValues1[0]);
		// objStatusTypeList
		// .clickOnReturnToStatusTypeList()
		objStatusTypeList
				.clickOnEditOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName)
				.selectStatusReason(strStatusReasonValues[0])
				.clickOnSaveButton()
				.clickOnStatusesOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName)
				.editStatusForMultiStatusType(
						objStatusTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strStatusReasonValues[0])
				.clickOnSaveButton()
				.editStatusForMultiStatusType(
						objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusReasonForStatus(strStatusReasonValues[0])
				.clickOnSaveButton().clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
		System.out.println(strStatusTypeValues1[0]);

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

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strStatusTypeValues1).clickOnSaveButton();
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
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption().clickSaveButton();

		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues1[0])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strstatusesValues[0])
				.selectMSTReasonValue(strStatusReasonValues[0],
						strStatusTypeValues1[0], strstatusesValues[0])
				.clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"MM/dd/yyyy HH:mm");

		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strStatusTypeValues1).clickOnSaveButton();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strStatusTypeValues1).clickOnSaveButton();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues1[0])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strstatusesValues[1])
				.selectMSTReasonValue(strStatusReasonValues[0],
						strStatusTypeValues1[0], strstatusesValues[1])
				.clickOnSaveButton();

		objNavigationToSubMenus1.clickOnStatusReports();

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts.converDateFormat(strCurrentDate,
				"MM/dd/yyyy", "dd-MMM-yyyy");

		objReport1
				.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strStatusReasonValues[0], strstatusesValues[0])
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

		objReport1
				.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strStatusReasonValues[0], strstatusesValues[0])
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
					objStatusTypes_data.strStatusNameInMulti + ","
							+ objStatusTypes_data.strStatusNameInMulti1,
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
					objStatusTypes_data.strStatusNameInMulti + ","
							+ objStatusTypes_data.strStatusNameInMulti1,
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

}
	