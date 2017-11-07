package requirementGroup.Reports;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertTrue;

import java.io.File;
import java.util.Properties;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.FileFormatConverter;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseResourceDetailReports extends TestNG_UI_EXTENSIONS {

	public EdgeCaseResourceDetailReports() throws Exception {
		super();
		}
	
	/***************************************************************************************************************
	 * 'Description :  Verify that only those resources for which user has 'View' and 'Run' right are available while generating 'Resource Detail Report'
	 
	 * 'Date : 30-Apr-2014 
	 * 'Author : Sangappa.k
	 ***************************************************************************************************************/

	@Test(description = "Verify that only those resources for which user has 'View' and 'Run' right are available while generating 'Resource Detail Report'.")
	public void testEdgeCase152458() throws Exception {
		
		gstrTCID = "152458";
		gstrTO = "Verify that only those resources for which user has 'View' and 'Run' right are available while generating 'Resource Detail Report'";

		Login_data objTest_data = new Login_data();
		Report_data objReport_data = new Report_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		Login login_page1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList1_page1 = new StatusTypeList(driver);
		ResourceType objResourceType_page1 = new ResourceType(driver);
		Resource objResource_page1 = new Resource(driver);
		UsersList objUsersList_page1 = new UsersList(driver);
		UpdateStatus Updatestatus_page2 = new UpdateStatus(driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();

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

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String filePath = file + "\\";

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		// data
		Login_data login_data = new Login_data();
		Resource_data objResourcedata_page1 = new Resource_data();
		ResourceType_data objResourceTypedata_page1 = new ResourceType_data();
		StatusTypes_data objStatusTypesdata_page1 = new StatusTypes_data();
		View_data objViewdata_page1 = new View_data();
		User_data objUserdata_page1 = new User_data();

		// array of String for all sources
		String strStatusTypeValues1[] = new String[2];

		String strStatusTypeValues2[] = new String[2];

		String strMultiStatusesTypeValues2[] = new String[2];

		String strResourceTypeValue[] = new String[2];

		String[] Resvalue = new String[2];

		login_page1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault_page1.selectFrame();

		objStatusTypeList1_page1.navigateToStatusTypeList();

		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strNumberStatusType,
				objStatusTypesdata_page1.strNSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strNSTStatusTypeName);

		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strTextStatusType,
				objStatusTypesdata_page1.strTSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues1[1] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strTSTStatusTypeName);

		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strMultiStatusType,
				objStatusTypesdata_page1.strMSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);

		objStatusTypeList1_page1.createNewStatus(
				objStatusTypesdata_page1.strStatusNameInMulti,
				objStatusTypesdata_page1.strStatusColor);

		objStatusTypeList1_page1.createNewStatus(
				objStatusTypesdata_page1.strStatusNameInMulti1,
				objStatusTypesdata_page1.strStatusColor);

		strMultiStatusesTypeValues2[0] = objStatusTypeList1_page1
				.getStatusesValue(objStatusTypesdata_page1.strStatusNameInMulti);

		strMultiStatusesTypeValues2[1] = objStatusTypeList1_page1
				.getStatusesValue(objStatusTypesdata_page1.strStatusNameInMulti1);

		objStatusTypeList1_page1.clickOnReturnToStatusTypeList();

		strStatusTypeValues2[0] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strMSTStatusTypeName);

		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strDateStatusType,
				objStatusTypesdata_page1.strDateStatusTypeName1,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues2[1] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strDateStatusTypeName1);

		objResourceType_page1.navigateToResourceTypePage().createResourceType(
				objResourceTypedata_page1.strResourceTypeName,
				strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType_page1
				.getResourceTypeValue(objResourceTypedata_page1.strResourceTypeName);

		objResourceType_page1.navigateToResourceTypePage().createResourceType(
				objResourceTypedata_page1.strResourceTypeName1,
				strStatusTypeValues2);
		strResourceTypeValue[1] = objResourceType_page1
				.getResourceTypeValue(objResourceTypedata_page1.strResourceTypeName1);

		// resource 1

		objResource_page1
				.navigateToResourceListPage()
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResourcedata_page1.strResourceName)
				.enterResourceAbbrivation(
						objResourcedata_page1.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceTypedata_page1.strResourceTypeName)
				.selectStandardResourceTypename(
						objResourcedata_page1.strStandardResourceTypename)
				.enterResourceFirstName(
						objResourcedata_page1.strResourceFirstName)
				.enterResourceLastName(
						objResourcedata_page1.strResourceLastName)
				.enterStreetAddress(objResource_data.strStreetAddress)
				.selectState(objResource_data.strState)
				.enterCity(objResource_data.strCity)
				.enterzipCode(objResource_data.strZipcode)
				.selectCounty(objResource_data.strCounty)
				.clickOnLookupAddressBtn().verMap();
		objResource_page1.clickOnSaveButton();
		objResource_page1.clickOnSaveButton();

		Resvalue[0] = objResource_page1
				.getResourceValue(objResourcedata_page1.strResourceName);

		// resource 2

		objResource_page1
				.navigateToResourceListPage()
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResourcedata_page1.strResourceName1)
				.enterResourceAbbrivation(
						objResourcedata_page1.strResourceAbbrivation1)
				.selectResourceTypename(
						objResourceTypedata_page1.strResourceTypeName1)
				.selectStandardResourceTypename(
						objResourcedata_page1.strStandardResourceTypename1)
				.enterResourceFirstName(
						objResourcedata_page1.strResourceFirstName)
				.enterResourceLastName(
						objResourcedata_page1.strResourceLastName)

				.enterStreetAddress(objResource_data.strStreetAddress)
				.selectState(objResource_data.strState)
				.enterCity(objResource_data.strCity)
				.enterzipCode(objResource_data.strZipcode)
				.selectCounty(objResource_data.strCounty)
				.clickOnLookupAddressBtn().verMap().clickOnSaveButton()
				.clickOnSaveButton();

		Resvalue[1] = objResource_page1
				.getResourceValue(objResourcedata_page1.strResourceName1);

		objUsersList_page1
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata_page1.strNewUserName,
						objUserdata_page1.strNewPassword,
						objUserdata_page1.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(
						objResourcedata_page1.strResourceName)
				.selectRunReportRight(objResourcedata_page1.strResourceName)
				.selectUpdateStatusOfResource(
						objResourcedata_page1.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMayUpdateRegionSetupInformationOption()
				.clickSaveButton();
		System.out.println(" new user name" + objUserdata_page1.strNewUserName);

		login_page1.clickLogOut();

		// login as new user

		objLogin1.loginAsNewUser(objUserdata_page1.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		System.out.println("Resource name"
				+ objResourcedata_page1.strResourceName);

		objMap.selectResourceNameInFindResourceDropdown(
				objResourcedata_page1.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		Updatestatus_page2.clickOnSelectAll();

		Updatestatus_page2.enterNSTAndTSTUpdateValue(strStatusTypeValues1[0],
				objViewdata_page1.strValueForUpdate);

		Updatestatus_page2.enterNSTAndTSTUpdateValue(strStatusTypeValues1[1],
				objViewdata_page1.strValueForTST);
		Updatestatus_page2.clickOnSaveButton();
		objNavigationToSubMenus1.clickOnResourceReports();
		objReport1.clickOnResourceDetails();

		objReport1.verifyResourceDetailReportPage()
				.verOnlySingleResIsDisplayed(Resvalue[0])
				.selectResources(Resvalue[0]).clickOnNextBtn();

		for (int i = 0; i < strStatusTypeValues1.length; i++) {
			objReport1.selectStatusCheckbox(strStatusTypeValues1[i]);
		}
		objReport1.clickOnGenerateReportBtn();

		Thread.sleep(5000);
		// excel verfication
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
				"Resource Detail Report", 1, 1, strDownloadName1);
		assertEquals("Resource Detail Report for: "
				+ objTest_data.strRegionName + "", strValue);

		String[] strAnswers = { objResource_data.strResourceName,
				objResourceType_data.strResourceTypeName,
				objStatusTypesdata_page1.strNSTStatusTypeName,
				objStatusTypesdata_page1.strTSTStatusTypeName,
				objViewdata_page1.strValueForUpdate,
				objViewdata_page1.strValueForTST };

		String strResource = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 3, 1, strDownloadName1);
		String strResourceType = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 3, 2, strDownloadName1);
		String strNumberSTypes = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 2, 17, strDownloadName1);
		String strTextTypes = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 2, 18, strDownloadName1);
		String strNumber = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 3, 17, strDownloadName1);
		String strtext = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 3, 18, strDownloadName1);
		String xLData[] = { strResource, strResourceType, strNumberSTypes,
				strTextTypes, strNumber, strtext };

		for (int i = 0; i < xLData.length; i++) {

			assertEquals(strAnswers[i], xLData[i]);
		}

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		Thread.sleep(5000);
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that only active status types for which user has role to 'View' are available while generating 'Resource Detail Report'
	 * 'Date : 04-May-2014 
	 * 'Author : Sangappa.k
	 ***************************************************************************************************************/

	@Test(description = "Verify that only active status types for which user has role to 'View' are available while generating 'Resource Detail Report'")
	public void testEdgeCase152459() throws Exception {
		
		gstrTCID = "152459";
		gstrTO = "Verify that only active status types for which user has role to 'View' are available while generating 'Resource Detail Report'";

		Login_data objTest_data = new Login_data();
		Report_data objReport_data = new Report_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Roles_data objRoles_data = new Roles_data();

		Login login_page1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList1_page1 = new StatusTypeList(driver);
		ResourceType objResourceType_page1 = new ResourceType(driver);
		Resource objResource_page1 = new Resource(driver);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList_page1 = new UsersList(driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegion_page2 = new SelectRegion(driver1);
		UpdateStatus Updatestatus_page2 = new UpdateStatus(driver1);
		Login objLogin1 = new Login(driver1);
		StatusTypeList objStatusTypeList1_page2 = new StatusTypeList(driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				driver1);
		Report objReport1 = new Report(driver1);
		Map objMap = new Map(driver1);
		AutoIT objAutoIT = new AutoIT(driver1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();

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

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String filePath = file + "\\";

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		// data
		Login_data login_data = new Login_data();
		Resource_data objResourcedata_page1 = new Resource_data();
		ResourceType_data objResourceTypedata_page1 = new ResourceType_data();
		StatusTypes_data objStatusTypesdata_page1 = new StatusTypes_data();
		View_data objViewdata_page1 = new View_data();
		User_data objUserdata_page1 = new User_data();

		// array of String for all sources
		String strStatusTypeValues1[] = new String[6];

		String strMultiStatusesTypeValues2[] = new String[2];

		String strResourceTypeValue[] = new String[2];

		String[] Resvalue = new String[2];

		String[] strRoleValue1 = new String[2];

		// String strRoleValue2= new String[1];

		login_page1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault_page1.selectFrame();

		objStatusTypeList1_page1.navigateToStatusTypeList();

		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strNumberStatusType,
				objStatusTypesdata_page1.strNSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strNSTStatusTypeName);

		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strTextStatusType,
				objStatusTypesdata_page1.strTSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues1[1] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strTSTStatusTypeName);

		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strMultiStatusType,
				objStatusTypesdata_page1.strMSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);

		objStatusTypeList1_page1.createNewStatus(
				objStatusTypesdata_page1.strStatusNameInMulti,
				objStatusTypesdata_page1.strStatusColor);

		objStatusTypeList1_page1.createNewStatus(
				objStatusTypesdata_page1.strStatusNameInMulti1,
				objStatusTypesdata_page1.strStatusColor);

		strMultiStatusesTypeValues2[0] = objStatusTypeList1_page1
				.getStatusesValue(objStatusTypesdata_page1.strStatusNameInMulti);

		strMultiStatusesTypeValues2[1] = objStatusTypeList1_page1
				.getStatusesValue(objStatusTypesdata_page1.strStatusNameInMulti1);

		objStatusTypeList1_page1.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[2] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strMSTStatusTypeName);

		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strDateStatusType,
				objStatusTypesdata_page1.strDateStatusTypeName1,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues1[3] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strDateStatusTypeName1);

		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strNedocCalculationStatusType,
				objStatusTypesdata_page1.strNDSTStatusTypeName1,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues1[4] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strNDSTStatusTypeName1);

		objStatusTypeList1_page1.createStatusType(
				objStatusTypesdata_page1.strSaturationScoreStatusType,
				objStatusTypesdata_page1.strSSTStatusTypeName1,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues1[5] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strSSTStatusTypeName1);

		// ResType

		objResourceType_page1.navigateToResourceTypePage().createResourceType(
				objResourceTypedata_page1.strResourceTypeName,
				strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType_page1
				.getResourceTypeValue(objResourceTypedata_page1.strResourceTypeName);

		// Res

		objResource_page1
				.navigateToResourceListPage()
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResourcedata_page1.strResourceName)
				.enterResourceAbbrivation(
						objResourcedata_page1.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceTypedata_page1.strResourceTypeName)
				.selectStandardResourceTypename(
						objResourcedata_page1.strStandardResourceTypename)
				.enterResourceFirstName(
						objResourcedata_page1.strResourceFirstName)
				.enterResourceLastName(
						objResourcedata_page1.strResourceLastName)
				.enterStreetAddress(objResource_data.strStreetAddress)
				.selectState(objResource_data.strState)
				.enterCity(objResource_data.strCity)
				.enterzipCode(objResource_data.strZipcode)
				.selectCounty(objResource_data.strCounty)
				.clickOnLookupAddressBtn().verMap();
		objResource_page1.clickOnSaveButton().clickOnSaveButton();

		Resvalue[0] = objResource_page1
				.getResourceValue(objResourcedata_page1.strResourceName);

		// roles with View & update right for st
		objNavigationToSubMenus.navigateToRoles();
		objRoles.createRole(objRoles_data.strRoleName);
		strRoleValue1[0] = objRoles.getRoleValue(objRoles_data.strRoleName);
		String Role1[] = { strRoleValue1[0] };

		// roles with only View right st
		objNavigationToSubMenus.navigateToRoles();
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRoles_data.strRoleName1)
				.deSelectAllCheckboxInRolesMayUpdatesec().clickOnSaveBtn();

		strRoleValue1[1] = objRoles.getRoleValue(objRoles_data.strRoleName1);
		String Role2[] = { strRoleValue1[1] };
		objUsersList_page1
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata_page1.strNewUserName,
						objUserdata_page1.strNewPassword,
						objUserdata_page1.strFullName)
				.selectRoleCheckBox(Role1)
				.selectViewResourceCheckBox(
						objResourcedata_page1.strResourceName)
				.selectRunReportRight(objResourcedata_page1.strResourceName)
				.selectUpdateStatusOfResource(
						objResourcedata_page1.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMayUpdateRegionSetupInformationOption()
				.clickSaveButton();

		System.out.println("hjf");

		objUsersList_page1
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata_page1.strNewUserName1,
						objUserdata_page1.strNewPassword,
						objUserdata_page1.strFullName)
				.selectRoleCheckBox(Role2)
				.selectViewResourceCheckBox(
						objResourcedata_page1.strResourceName)
				.selectRunReportRight(objResourcedata_page1.strResourceName)
				.selectUpdateStatusOfResource(
						objResourcedata_page1.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMayUpdateRegionSetupInformationOption()
				.clickSaveButton();

		System.out.println(" new user name" + objUserdata_page1.strNewUserName);
		System.out
				.println(" new user name" + objUserdata_page1.strNewUserName1);

		login_page1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata_page1.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		System.out.println("Resource name"
				+ objResourcedata_page1.strResourceName);

		objMap.selectResourceNameInFindResourceDropdown(
				objResourcedata_page1.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		Updatestatus_page2.clickOnSelectAll();

		Updatestatus_page2.enterNSTAndTSTUpdateValue(strStatusTypeValues1[0],
				objViewdata_page1.strValueForUpdate);

		Updatestatus_page2
				.enterNSTAndTSTUpdateValue(strStatusTypeValues1[1],
						objViewdata_page1.strValueForTST)

				.selectMSTUpdateValue(strStatusTypeValues1[2],
						strMultiStatusesTypeValues2[0])

				.enterNSTAndTSTUpdateValue(strStatusTypeValues1[3],
						objViewdata_page1.strDateUpdateValue)

				.enterNedocsUpdateValue(strStatusTypeValues1[4],
						objViewdata_page1.strValueForNDST)

				.enterUpdateSSTValues(strStatusTypeValues1[5],
						objViewdata_page1.strValueForSST)

				.clickOnSaveButton();

		objLogin1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page2.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault1.selectFrame();

		objStatusTypeList1_page2.navigateToStatusTypeList();
		objStatusTypeList1_page2
				.clickOnEditOfStatusType(
						objStatusTypesdata_page1.strNDSTStatusTypeName1)
				.deselectActiveCheckBox().clickOnSaveButton();
		Thread.sleep(2000);

		objStatusTypeList1_page2
				.clickOnEditOfStatusType(
						objStatusTypesdata_page1.strSSTStatusTypeName1)
				.deselectActiveCheckBox().clickOnSaveButton();

		objLogin1.loginAsNewUser(objUserdata_page1.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnResourceReports();

		objReport1.clickOnResourceDetails();

		objReport1.verifyResourceDetailReportPage()
				.verOnlySingleResIsDisplayed(Resvalue[0])
				.selectResources(Resvalue[0]).clickOnNextBtn();

		String[] ActivatedST = { strStatusTypeValues1[0],
				strStatusTypeValues1[1], strStatusTypeValues1[2],
				strStatusTypeValues1[3] };

		for (int i = 0; i < ActivatedST.length; i++) {
			objReport1.selectStatusCheckbox(ActivatedST[i]);
		}
		objReport1.clickOnGenerateReportBtn();
		// excel verfication
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
				"Resource Detail Report", 1, 1, strDownloadName1);
		assertEquals("Resource Detail Report for: "
				+ objTest_data.strRegionName + "", strValue);

		String[] strAnswers = { objResource_data.strResourceName,
				objResourceType_data.strResourceTypeName,
				objStatusTypesdata_page1.strNSTStatusTypeName,
				objStatusTypesdata_page1.strTSTStatusTypeName,
				objStatusTypesdata_page1.strMSTStatusTypeName,
				objStatusTypesdata_page1.strDateStatusTypeName1,
				objViewdata_page1.strValueForUpdate,
				objViewdata_page1.strValueForTST,
				objStatusTypesdata_page1.strStatusNameInMulti,
				objViewdata_page1.strDateUpdateValue };
		// Status types & res
		String strResource = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 3, 1, strDownloadName1);
		String strResourceType = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 3, 2, strDownloadName1);
		String strNumberSTypes = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 2, 17, strDownloadName1);
		String strTextTypes = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 2, 18, strDownloadName1);
		String strMultiType = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 2, 19, strDownloadName1);
		String strDateType = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 2, 20, strDownloadName1);
		// values
		String strNumber = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 3, 17, strDownloadName1);
		String strtext = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 3, 18, strDownloadName1);
		String strMulti = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 3, 19, strDownloadName1);
		String strDate = objOffCommonFunc.readInfoExcel(
				"Resource Detail Report", 3, 20, strDownloadName1);

		String xLData[] = { strResource, strResourceType, strNumberSTypes,
				strTextTypes, strMultiType, strDateType, strNumber, strtext,
				strMulti, strDate };

		for (int i = 0; i < xLData.length; i++) {

			assertEquals(strAnswers[i], xLData[i]);
		}

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		Thread.sleep(5000);
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that resource detail report displays the detail to 6 decimal places for Lat/Long field. 
	 * 'Date : 25-May-2014 
	 * 'Author : Sangappa.k
	 ***************************************************************************************************************/

	@Test( description ="Verify that resource detail report displays the detail to 6 decimal places for Lat/Long field. ")
	public void testEdgeCase162553() throws Exception {

		gstrTCID = "162553";
		gstrTO = "Verify that resource detail report displays the detail to 6 decimal places for Lat/Long field. ";

		Report_data objReport_data = new Report_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		Login_data login_data = new Login_data();
		Resource_data objResourcedata_page1 = new Resource_data();
		ResourceType_data objResourceTypedata_page1 = new ResourceType_data();
		StatusTypes_data objStatusTypesdata_page1 = new StatusTypes_data();
		User_data objUserdata_page1 = new User_data();

		Login login_page = new Login(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList1_page = new StatusTypeList(driver);
		ResourceType objResourceType_page = new ResourceType(driver);
		Resource objResource_page = new Resource(driver);
		UsersList objUsersList_page = new UsersList(driver);

		Login objLogin1 = new Login(driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				driver1);
		Report objReport1 = new Report(driver1);
		AutoIT objAutoIT = new AutoIT(driver1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();

		String strLattitude, strLongitude;

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

		// array of String for all sources
		String strStatusTypeValues1[] = new String[2];

		String strResourceTypeValue[] = new String[1];

		String[] Resvalue = new String[1];

		// String strRoleValue2= new String[1];

		login_page.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault_page.selectFrame();

		objStatusTypeList1_page.navigateToStatusTypeList();

		objStatusTypeList1_page.createStatusType(
				objStatusTypesdata_page1.strNumberStatusType,
				objStatusTypesdata_page1.strNSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList1_page
				.getStatusValue(objStatusTypesdata_page1.strNSTStatusTypeName);

		objStatusTypeList1_page.createStatusType(
				objStatusTypesdata_page1.strTextStatusType,
				objStatusTypesdata_page1.strTSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues1[1] = objStatusTypeList1_page
				.getStatusValue(objStatusTypesdata_page1.strTSTStatusTypeName);

		// ResType

		objResourceType_page.navigateToResourceTypePage().createResourceType(
				objResourceTypedata_page1.strResourceTypeName,
				strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType_page
				.getResourceTypeValue(objResourceTypedata_page1.strResourceTypeName);

		// Res

		objResource_page
				.navigateToResourceListPage()
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResourcedata_page1.strResourceName)
				.enterResourceAbbrivation(
						objResourcedata_page1.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceTypedata_page1.strResourceTypeName)
				.selectStandardResourceTypename(
						objResourcedata_page1.strStandardResourceTypename)
				.enterResourceFirstName(
						objResourcedata_page1.strResourceFirstName)
				.enterResourceLastName(
						objResourcedata_page1.strResourceLastName)
				.enterStreetAddress(objResource_data.strStreetAddress)
				.selectState(objResource_data.strState)
				.enterCity(objResource_data.strCity)
				.enterzipCode(objResource_data.strZipcode)
				.selectCounty(objResource_data.strCounty)
				.clickOnLookupAddressBtn().verMap();

		strLattitude = objResource_page.getLatitudeWithFraction();
		strLongitude = objResource_page.getLongitudeWithFraction();

		System.out.println("Captured Lat" + strLattitude);

		System.out.println("Captured Long" + strLongitude);

		String str6DigitLaT = objResource_page
				.getDecimalFormatUpToSixDigits(strLattitude);
		String str6DigitLonG = objResource_page
				.getDecimalFormatUpToSixDigits(strLongitude);

		objResource_page.clickOnSaveButton().clickOnSaveButton();

		Resvalue[0] = objResource_page
				.getResourceValue(objResourcedata_page1.strResourceName);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata_page1.strNewUserName,
						objUserdata_page1.strNewPassword,
						objUserdata_page1.strFullName).selectFirstRole()
				.selectRunReportRight(objResourcedata_page1.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMayUpdateRegionSetupInformationOption()
				.clickSaveButton();

		System.out.println(" new user name" + objUserdata_page1.strNewUserName);

		login_page.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata_page1.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnResourceReports();

		objReport1.clickOnResourceDetails();

		objReport1.verifyResourceDetailReportPage()
				.verOnlySingleResIsDisplayed(Resvalue[0])
				.selectResources(Resvalue[0]).clickOnNextBtn();

		String[] ActivatedST = { strStatusTypeValues1[0],
				strStatusTypeValues1[1] };

		for (int i = 0; i < ActivatedST.length; i++) {
			objReport1.selectStatusCheckbox(ActivatedST[i]);
		}
		objReport1.clickOnGenerateReportBtn();

		// excel verfication

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		int intCount = 0;

		objFileFormatConverter.convertXlsxToXls(strDownloadName,
				strDownloadName1);

		assertTrue(new File(strDownloadName1).exists());

		String[] strHeaderNames = objReport_data.strResDetailRep;

		for (intCount = 1; intCount < strHeaderNames.length; intCount++) {
			String strValue = objOffCommonFunc.readInfoExcel(
					"Resource Detail Report", 2, intCount, strDownloadName1);
			System.out.println(strValue);
			assertEquals(strHeaderNames[intCount - 1], strValue);

			if (strValue.equals("Latitude") || strValue.equals("Longitude")) {

				String strLangAndLatt = objOffCommonFunc
						.readInfoExcel("Resource Detail Report", 3, intCount,
								strDownloadName1);
				System.out.println(strLangAndLatt);

				assertTrue(strLangAndLatt.equals(str6DigitLaT)
						|| strLangAndLatt.equals(str6DigitLonG));

			}

		}

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		Thread.sleep(5000);
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
}
	


	
	

	