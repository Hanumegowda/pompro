package requirementGroup.Reports;

import java.io.File;
import java.util.Properties;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
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
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewStatusSummaryReport extends TestNG_UI_EXTENSIONS{

	public NewStatusSummaryReport() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/**************************************************************************************************************
	'Description : Generate 'Status Summary report' in PDF format and verify that the report displays correct data.
	'Date	 	 : 24-June-2015
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***************************************************************************************************************/
	@Test(description = "Generate 'Status Summary report' in PDF format and verify that the report displays correct data.")
	public void testHappyDay94235() throws Exception {

		gstrTCID = "94235";
		gstrTO = "Generate 'Status Summary report' in PDF format and verify that the report displays correct data.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		String strstatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[6];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Map objMap1 = new Map(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;

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

		String strDownloadName = file + "\\" + "TC94235" + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + "TC194235" + "_" + strTimeText
				+ fileType;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// create RoleBased statustypes 
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
				
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti2,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti2);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// create private status type		
		objStatusTypeList.createPrivateStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strpMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
				
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti3,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti3);
		
		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti4,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[3] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti4);

		objStatusTypeList.clickOnReturnToStatusTypeList();

//		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpMSTStatusTypeName);
		
		// create Shared status type		
		objStatusTypeList.createSharedStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strsMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)

		.createNewStatus(objStatuTypes_data.strStatusNameInMulti5,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[4] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti5);
		
		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti6,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[5] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti6);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strsMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSummaryOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(5000);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[2])
				.selectMSTUpdateValue(strstatusTypeValues[2],
						strStatusesValues[4]);

		objUpdateStatus_Page1.clickOnSaveButton();

		String strAppTime = objEventManagement1.getApplicationTime();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();

		String updatedtime = "(" + strAppTime + " " + objTest_data.timeZone
				+ ")";
		
		System.out.println(updatedtime);
		
		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti1, updatedtime);

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti3, updatedtime);

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti5, updatedtime);

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).clickOnNextStepBtn()
                .selectAllStatustypesChkBox()
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();

		if (strPdf1) {
			String[] strTestData = {
					"94235",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,"","",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strpMSTStatusTypeName + ", "
							+ objStatuTypes_data.strsMSTStatusTypeName + ", "
							+ objStatuTypes_data.strMSTStatusTypeName,"","",
					objReport_data.ExternalIP,"","",
					updatedtime,
					strDownloadName,"",
					objStatuTypes_data.strStatusNameInMulti1 + ","
							+ objStatuTypes_data.strStatusNameInMulti3 + ", "
							+ objStatuTypes_data.strStatusNameInMulti5,
					strCurrentDate, strCurrentDate, "" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		Thread.sleep(5000);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[1])
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[3])
				.selectMSTUpdateValue(strstatusTypeValues[2],
						strStatusesValues[5]);

		objUpdateStatus_Page1.clickOnSaveButton();

		strAppTime = objEventManagement1.getApplicationTime();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();

		updatedtime = "(" + strAppTime + " " + objTest_data.timeZone + ")";
		
		System.out.println(updatedtime);

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti2, updatedtime);

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti4, updatedtime);

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti6, updatedtime);

		strCurrentDate = dts.timeNow("MM/dd/yyyy");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.clickOnNextStepBtn()
				.selectAllStatustypesChkBox()
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file2 = new File(strDownloadName1);
		boolean strPdf2 = file2.exists();

		if (strPdf2) {
			String[] strTestData1 = {
					"94235",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,"","",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strpMSTStatusTypeName + ", "
							+ objStatuTypes_data.strsMSTStatusTypeName + ", "
							+ objStatuTypes_data.strMSTStatusTypeName,"","",
					objReport_data.ExternalIP,"","",
					updatedtime,
					strDownloadName1,"","",
					objStatuTypes_data.strStatusNameInMulti2 + ","
							+ objStatuTypes_data.strStatusNameInMulti4 + ", "
							+ objStatuTypes_data.strStatusNameInMulti6,
					strCurrentDate, strCurrentDate, "" };

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objLogin1.clickLogOut();

		if (strPdf1 && strPdf2) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}
	
	/**************************************************************************************************************
	'Description : Generate 'Status Summary report' in CSV format and verify that the report displays correct data.
	'Date	 	 : 24-June-2015
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                 Modified By
	'Date					                                                             Name
	***************************************************************************************************************/
	@Test(description = "Generate 'Status Summary report' in CSV format and verify that the report displays correct data.")
	public void testHappyDay94237() throws Exception {

		gstrTCID = "94237";
		gstrTO = "Generate 'Status Summary report' in CSV format and verify that the report displays correct data.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		String strstatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[6];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Map objMap1 = new Map(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.csvFile;

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

		String strDownloadName = file + "\\" + "TC94237" + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + "TC194237" + "_" + strTimeText
				+ fileType;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// create RoleBased statustypes 
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
				
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti2,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti2);

		objStatusTypeList.clickOnReturnToStatusTypeList();


		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// create private status type		
		objStatusTypeList.createPrivateStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strpMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
				
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti3,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti3);
		
		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti4,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[3] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti4);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strpMSTStatusTypeName);
		
		// create Shared status type		
		objStatusTypeList.createSharedStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strsMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)

		.createNewStatus(objStatuTypes_data.strStatusNameInMulti5,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[4] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti5);
		
		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti6,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[5] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti6);

		objStatusTypeList.clickOnReturnToStatusTypeList();


		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strsMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSummaryOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(5000);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[2])
				.selectMSTUpdateValue(strstatusTypeValues[2],
						strStatusesValues[4]);

		objUpdateStatus_Page1.clickOnSaveButton();

		String strAppTime = objEventManagement1.getApplicationTime();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();

		String updatedtime = "(" + strAppTime + " " + objTest_data.timeZone
				+ ")";
		
		System.out.println(updatedtime);
		
		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti1, updatedtime);

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti3, updatedtime);

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti5, updatedtime);

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectCSVRadioBtn()
				.selectResources(strResourceValue[0]).clickOnNextStepBtn()
                .selectAllStatustypesChkBox()
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		File file1 = new File(strDownloadName);
		boolean strCsv1 = file1.exists();

		if (strCsv1) {
			String[] strTestData = {
					"94237",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strpMSTStatusTypeName + ", "
							+ objStatuTypes_data.strsMSTStatusTypeName + ", "
							+ objStatuTypes_data.strMSTStatusTypeName,
							objStatuTypes_data.strStatusNameInMulti1 + ","
									+ objStatuTypes_data.strStatusNameInMulti3 + ", "
									+ objStatuTypes_data.strStatusNameInMulti5,
									objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,"","","","",
					objReport_data.ExternalIP,strDownloadName,
					updatedtime+ "/"+strCurrentDate};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "CSVDetails");
		}
		
		Thread.sleep(5000);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[1])
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[3])
				.selectMSTUpdateValue(strstatusTypeValues[2],
						strStatusesValues[5]);

		objUpdateStatus_Page1.clickOnSaveButton();

		strAppTime = objEventManagement1.getApplicationTime();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();

		updatedtime = "(" + strAppTime + " " + objTest_data.timeZone + ")";
		
		System.out.println(updatedtime);

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti2, updatedtime);

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti4, updatedtime);

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti6, updatedtime);

		strCurrentDate = dts.timeNow("MM/dd/yyyy");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectCSVRadioBtn()
				.selectResources(strResourceValue[0])
				.clickOnNextStepBtn()
				.selectAllStatustypesChkBox()
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file2 = new File(strDownloadName1);
		boolean strCsv2 = file2.exists();

		if (strCsv2) {
			String[] strTestData1 = {
					"94237",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strpMSTStatusTypeName + ", "
							+ objStatuTypes_data.strsMSTStatusTypeName + ", "
							+ objStatuTypes_data.strMSTStatusTypeName,
							objStatuTypes_data.strStatusNameInMulti2 + ","
									+ objStatuTypes_data.strStatusNameInMulti4 + ", "
									+ objStatuTypes_data.strStatusNameInMulti6,
									objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,"","","","",
					objReport_data.ExternalIP,strDownloadName,
					updatedtime+ "/"+strCurrentDate};

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "CSVDetails");
		}

		objLogin1.clickLogOut();

		if (strCsv1 && strCsv2) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}
	
	
	/**************************************************************************************************************
	'Description : Verify that resource selection and status type selection is on different pages while generating Status summary report 
	'Date	 	 : 31-Dec-2015
	'Author		 : Renushree
	'--------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***************************************************************************************************************/
	@Test(description = "Verify that resource selection and status type selection is on different pages while generating Status summary report ")
	public void testHappyDay162676() throws Exception {

		gstrTCID = "162676";
		gstrTO = "Verify that resource selection and status type selection is on different pages while generating Status summary report ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Map objMap1 = new Map(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;

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

		String strDownloadName = file + "\\" + "TC94235" + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + "TC194235" + "_" + strTimeText
				+ fileType;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// create RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)

		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.createNewStatus(
				objStatuTypes_data.strStatusNameInMulti2,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti2);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSummaryOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(5000);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1.selectStatusTypes(strstatusTypeValues[0]).selectMSTUpdateValue(
				strstatusTypeValues[0], strStatusesValues[0]);

		objUpdateStatus_Page1.clickOnSaveButton();

		String strAppTime = objEventManagement1.getApplicationTime();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();

		String updatedtime = "(" + strAppTime + " " + objTest_data.timeZone
				+ ")";

		System.out.println(updatedtime);

		objMap1.verifyUpdatedTimeInPopupWindow(
				objStatuTypes_data.strStatusNameInMulti1, updatedtime);

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.statusTypeCheckboxNotDisplayed(strstatusTypeValues[0])
				.clickOnNextStepBtn()
				.selectStatusTypeCheckbox(strstatusTypeValues[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();

		if (strPdf1) {
			String[] strTestData = {
					"94235",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", updatedtime,
					strDownloadName, "",
					objStatuTypes_data.strStatusNameInMulti1, strCurrentDate,
					strCurrentDate, "" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate).selectCSVRadioBtn()
				.selectResources(strResourceValue[0]).clickOnNextStepBtn()
				.selectAllStatustypesChkBox().clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		File file2 = new File(strDownloadName1);
		boolean strCsv1 = file2.exists();

		if (strCsv1) {
			String[] strTestData1 = {
					"94237",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strMSTStatusTypeName,
					objStatuTypes_data.strStatusNameInMulti1,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "", "",
					objReport_data.ExternalIP, strDownloadName,
					updatedtime + "/" + strCurrentDate };

			objOffCommonFunc.writeResultData(strTestData1,
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
