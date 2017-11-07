package requirementGroup.SettingUpResources;

import java.io.File;
import java.util.Properties;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.Upload_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.Upload;
import lib.page.UploadList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayImportUsersFromSpreadsheet extends TestNG_UI_EXTENSIONS{
	
	public HappyDayImportUsersFromSpreadsheet() throws Exception {
		super();
	}
	
	/******************************************************************
	'Description : Verify that user can 'Test' prior to uploading users.
	'Precondition:
	'Date	 	 : 30-Jul-2014
	'Author		 : Deepa
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that user can 'Test' prior to uploading users.")
	public void testHappyDay103107() throws Exception {

		gstrTCID = "103107";
		gstrTO = "Verify that user can 'Test' prior to uploading users.";

		Login_data objTest_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Upload_data objUpload_data = new Upload_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UploadList objUploadList = new UploadList(this.driver1);
		UsersList objUserList1 = new UsersList(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strExcelName = "ImportResource.xls";
		String strFilePath = file + fileUploadPath;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// First resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame().clickRegionLink();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		String[] strTestData1 = { "", "N", "",
				"",
				"", "",
				"", "", "N", "N", "", "",
				"", "", "", "", "", "", objUser_data.strFirstName,
				objUser_data.strLastName, "", "", "", "", "",
				objUser_data.strNewUserName, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData1, strFilePath,
				"Resource", 1);

		objUpload1.clickOnUploadResourceBtn().verNewUploadPageIsDisplayed()
				.verSpreadSheetAndBrowserBtnIsDisplayed().verTestIsDisplayed();

		objUpload1.uploadFile(strFilePath).clickOnSaveBtn();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strCurDate = dts.converDateFormat(strAppTime[0] + strAppTime[1]
				+ strCurYear + " " + strAppTime[2], "ddMMMyyyy HH:mm",
				"yyyy-MM-dd HH:mm");

		String strCurDate1 = dts.converDateFormat(strAppTime[0] + strAppTime[1]
				+ strCurYear + " " + strAppTime[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy");

		String strDate[] = strCurDate1.split(" ");

		objUpload1
				.verUploadedFilename(strExcelName)
				.verTestCheckboxIsChecked()
				.verUserName(objTest_data.strUserName)
				.verDate(strDate[0])
				.verRowInUploadDetails(objUpload_data.strRow)
				.verResourceNameInUploadDetails(
						" ")
				.verResCommentsInUploadDetails(objUpload_data.strNoResComment)
				.verFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verUserIDInUploadDetails(objUser_data.strNewUserName)
				.verUserFullNameInUploadDetails(objUser_data.strFullName)
				.verUserFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verReturnInUploadDetails().clickOnReturnInUploadDetails();

		objUploadList.verUploadedFileDetailsInUploadList(
				objUpload_data.strYesValue, strCurDate,
				objTest_data.strUserName);

		objResource1.navigateToResourceListPage();

		objResource1.clickOnUsersLinkOfFirstRes();

		objResource1.verUserIsNotDisInUsersList(objUser_data.strNewUserName);

		objUserList1.navigateToUsersNew();

		objUserList1.verUserNotInList(objUser_data.strNewUserName);

		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Verify that users can be uploaded providing only the
	 		       mandatory data in the template.
	'Precondition:
	'Date	 	 : 31-Jul-2014
	'Author		 : Deepa
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that users can be uploaded providing only the mandatory data in the template.")
	public void testHappyDay103114() throws Exception {

		gstrTCID = "103114";
		gstrTO = "Verify that users can be uploaded providing only the mandatory data in the template.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Upload_data objUpload_data = new Upload_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);
		Resource objResource = new Resource(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strResourceValue[] = new String[3];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UploadList objUploadList = new UploadList(this.driver1);
		UsersList objUserList1 = new UsersList(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strExcelName = "ImportResource.xls";
		String strFilePath = file + fileUploadPath;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// First resource type creation
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
		
		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame().clickRegionLink();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		String[] strTestData1 = { "", "N", "",
				objResource_data.strResourceAbbrivation,
				"", "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objUser_data.strFirstName,
				objUser_data.strLastName, "", "", "", "", "",
				objUser_data.strNewUserName, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData1, strFilePath,
				"Resource", 1);

		objUpload1.clickOnUploadResourceBtn().verNewUploadPageIsDisplayed()
				.verSpreadSheetAndBrowserBtnIsDisplayed().verTestIsDisplayed()
				.deselectTestCheckBox();

		objUpload1.uploadFile(strFilePath).clickOnSaveBtn();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strCurDate = dts.converDateFormat(strAppTime[0] + strAppTime[1]
				+ strCurYear + " " + strAppTime[2], "ddMMMyyyy HH:mm",
				"yyyy-MM-dd HH:mm");

		String strCurDate1 = dts.converDateFormat(strAppTime[0] + strAppTime[1]
				+ strCurYear + " " + strAppTime[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy");

		String strDate[] = strCurDate1.split(" ");

		objUpload1
				.verUploadedFilename(strExcelName)
				.verTestCheckboxIsChecked()
				.verUserName(objTest_data.strUserName)
				.verDate(strDate[0])
				.verRowInUploadDetails(objUpload_data.strRow)
				.verResourceNameInUploadDetails(
						" ")
				.verResCommentsInUploadDetails(objUpload_data.strNoResComment)
				.verFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verUserIDInUploadDetails(objUser_data.strNewUserName)
				.verUserFullNameInUploadDetails(objUser_data.strFullName)
				.verUserFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verReturnInUploadDetails().clickOnReturnInUploadDetails();

		objUploadList.verUploadedFileDetailsInUploadList(
				objUpload_data.strYesOrNoValue, strCurDate,
				objTest_data.strUserName);

		objUserList1.navigateToUsersNew().clickOnShowAllUsersIfPresent();

		objUserList1.verUserInList(objUser_data.strNewUserName)
				.editUserDetails(objUser_data.strNewUserName)
				.verNameInEditUserPage(objUser_data.strNewUserName)
				.verFullNameInEditUserPage(objUser_data.strFullName)
				.verRoleCheckBoxIsSelected(strRoleValue[0]);

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1.clickOnUsersLink(objResource_data.strResourceName)
				.verViewResourceChkboxIsSelected(objUser_data.strNewUserName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Verify that users can be imported providing the ResourceID.
	'Precondition:
	'Date	 	 : 31-Jul-2014
	'Author		 : Deepa
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that users can be imported providing the ResourceID.")
	public void testHappyDay103123() throws Exception {

		gstrTCID = "103123";
		gstrTO = "Verify that users can be imported providing the ResourceID.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Upload_data objUpload_data = new Upload_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UploadList objUploadList = new UploadList(this.driver1);
		UsersList objUserList1 = new UsersList(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strExcelName = "ImportResource.xls";
		String strFilePath = file + fileUploadPath;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// First resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame().clickRegionLink();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		String[] strTestData1 = { "", "N", objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				strResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objUser_data.strFirstName,
				objUser_data.strLastName, "", "", "", "", "",
				objUser_data.strNewUserName, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData1, strFilePath,
				"Resource", 1);

		objUpload1.clickOnUploadResourceBtn().verNewUploadPageIsDisplayed()
				.verSpreadSheetAndBrowserBtnIsDisplayed().verTestIsDisplayed()
				.deselectTestCheckBox();

		objUpload1.uploadFile(strFilePath).clickOnSaveBtn();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strCurDate = dts.converDateFormat(strAppTime[0] + strAppTime[1]
				+ strCurYear + " " + strAppTime[2], "ddMMMyyyy HH:mm",
				"yyyy-MM-dd HH:mm");

		String strCurDate1 = dts.converDateFormat(strAppTime[0] + strAppTime[1]
				+ strCurYear + " " + strAppTime[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy");

		String strDate[] = strCurDate1.split(" ");

		objUpload1
				.verUploadedFilename(strExcelName)
				.verTestCheckboxIsChecked()
				.verUserName(objTest_data.strUserName)
				.verDate(strDate[0])
				.verRowInUploadDetails(objUpload_data.strRow)
				.verResourceNameInUploadDetails(
						objResource_data.strResourceName)
				.verFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verUserIDInUploadDetails(objUser_data.strNewUserName)
				.verUserFullNameInUploadDetails(objUser_data.strFullName)
				.verUserFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verReturnInUploadDetails().clickOnReturnInUploadDetails();

		objUploadList.verUploadedFileDetailsInUploadList(
				objUpload_data.strYesOrNoValue, strCurDate,
				objTest_data.strUserName);

		objUserList1.navigateToUsersNew().clickOnShowAllUsersIfPresent();

		objUserList1.verUserInList(objUser_data.strNewUserName)
				.editUserDetails(objUser_data.strNewUserName)
				.verNameInEditUserPage(objUser_data.strNewUserName)
				.verFullNameInEditUserPage(objUser_data.strFullName)
				.verRoleCheckBoxIsSelected(strRoleValue[0]);

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1.clickOnUsersLink(objResource_data.strResourceName)
				.verViewResourceChkboxIsSelected(objUser_data.strNewUserName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************************
	'Description : Verify that user is not imported when 'UserID' is not specified in the spreadsheet.
	'Date	 	 : 30-Jul-2014
	'Author		 : Deepa
	'-------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***************************************************************************************************/
	@Test(description ="Verify that user is not imported when 'UserID' is not specified in the spreadsheet.")
	public void testHappyDay103108() throws Exception {

		gstrTCID = "103108";
		gstrTO ="Verify that user is not imported when 'UserID' is not specified in the spreadsheet.";

		Login_data objTest_data = new Login_data();
		Upload_data objUpload_data = new Upload_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();

		Login objLogin = new Login(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		UsersList objUserList1 = new UsersList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strFilePath = file + fileUploadPath;

		String strRoleValue[] = new String[1];
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		String[] strTestData1 = { "", "N", "", "", "", "", "", "", "N", "N",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				strRoleValue[0], "", objUser_data.strNewPassword,
				objUser_data.strFullName, "", "", "", "", "", "", "", "", "",
				"", "" };

		objOFC.writeResultDataToParticularRow(strTestData1, strFilePath,
				"Resource", 1);

		objUpload1.clickOnUploadResourceBtn().verNewUploadPageIsDisplayed()
				.verSpreadSheetAndBrowserBtnIsDisplayed().verTestIsDisplayed();

		objUpload1.uploadFile(strFilePath).clickOnSaveBtn();

		objUpload1.verRowInUploadDetails(objUpload_data.strRow)
				.verResourceNameInUploadDetails(
						" ")
				.verResCommentsInUploadDetails(objUpload_data.strNoResComment)
				.verFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verUserIDInUploadDetails(" ")
				.verUserFullNameInUploadDetails(" ")
				.verUserFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verReturnInUploadDetails().clickOnReturnInUploadDetails();

		objUserList1
				.navigateToUsersNew()
				.searchUserNameAndVerifyItIsNotDisplayed(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption);

		gstrResult = "PASS";
	}

	/************************************************************************************************
	'Description : Verify that duplicate UserID provided in the standard template cannot be uploaded.
	'Date	 	 : 06-Jul-2014
	'Author		 : Deepa
	'------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************/
	@Test(description = "Verify that duplicate UserID provided in the standard template cannot be uploaded.")
	public void testHappyDay101824() throws Exception {

		gstrTCID = "101824";
		gstrTO = "Verify that duplicate UserID provided in the standard template cannot be uploaded.";

		Login_data objTest_data = new Login_data();
		Upload_data objUpload_data = new Upload_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);

		String strRoleValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		UsersList objUserList1 = new UsersList(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strFilePath = file + fileUploadPath;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame().clickRegionLink();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		String[] strTestData1 = { "", "N", "", "", "", "", "", "", "N", "N",
				"", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "",
				objUser_data.strNewUserName, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData1, strFilePath,
				"Resource", 1);

		objUpload1.clickOnUploadResourceBtn().deselectTestCheckBox()
				.uploadFile(strFilePath).clickOnSaveBtn();

		objUserList1
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.clickSaveButton();
		
		String[] strTestData2 = { "", "N", "", "", "", "", "", "", "N", "N",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				objUser_data.strNewUserName, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "", "", "" };
		
		objOFC.writeResultDataToParticularRow(strTestData2, strFilePath,
				"Resource", 1);

		String[] strTestData3 = { "", "N", "", "", "", "", "", "", "N", "N",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				objUser_data.strNewUserName2, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "", "", "" };
		
		objOFC.writeResultDataToParticularRow(strTestData3, strFilePath,
				"Resource", 2);

		String[] strTestData4 = { "", "N", "", "", "", "", "", "", "N", "N",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				objUser_data.strNewUserName3, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "", "", "" };
		
		objOFC.writeResultDataToParticularRow(strTestData4, strFilePath,
				"Resource", 3);

		String[] strTestData5 = { "", "N", "", "", "", "", "", "", "N", "N",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				objUser_data.strNewUserName3, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "", "", "" };
		
		objOFC.writeResultDataToParticularRow(strTestData5, strFilePath,
				"Resource", 4);
		
		objNavigationToSubMenus1.navigateToUpload();

		objUpload1
				.clickOnUploadResourceBtn()
				.deselectTestCheckBox()
				.uploadFile(strFilePath)
				.clickOnSaveBtn()
				.verUserDeatailsInUploadDetails(objUpload_data.strYesValue, 1)
				.verUserDeatailsInUploadDetails(objUpload_data.strYesValue, 2)
				.verUserDeatailsInUploadDetails(objUpload_data.strYesOrNoValue,3)
				.verUserDeatailsInUploadDetails(objUpload_data.strYesValue, 4)
				.verUserCommentsInUploadDetailsRowWise(
						objUpload_data.strUserComments, 1)
				.verUserCommentsInUploadDetailsRowWise(
						objUpload_data.strUserComments, 2)
				.verUserComments(" ", 3)
				.verUserCommentsInUploadDetailsRowWise(
						objUpload_data.strUserComments2, 4);

		objUserList1
				.navigateToUsersNew()
				.searchUserName(objUser_data.strNewUserName3,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.verUserInList(objUser_data.strNewUserName3)
				.VerifyNoOfRowsForUsers(objUser_data.strNewUserName3)
				
				.searchUserName(objUser_data.strNewUserName2,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.VerifyNoOfRowsForUsers(objUser_data.strNewUserName2)
				
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.VerifyNoOfRowsForUsers(objUser_data.strNewUserName);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/****************************************************************************************************
	'Description : Verify that users can be imported providing resource ID and all the affiliated rights.
	'Date	 	 : 07-Jan-2014
	'Author		 : Anil
	'----------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "Verify that users can be imported providing resource ID and all the affiliated rights.")
	public void testHappyDay103478() throws Exception {

		gstrTCID = "103478";
		gstrTO = "Verify that users can be imported providing resource ID and all the affiliated rights.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Upload_data objUpload_data = new Upload_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[4];
		String strRoleValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UsersList objUserList1 = new UsersList(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strFilePath = file + fileUploadPath;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// First resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		objNavigationToSubMenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objResource.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);
		
		objResource.createResource(objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[2] = objResource
				.getResourceValue(objResource_data.strResourceName2);
		
		objResource.createResource(objResource_data.strResourceName3,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[3] = objResource
				.getResourceValue(objResource_data.strResourceName3);

		System.out.println(objResource_data.strResourceName);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame().clickRegionLink();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		String[] strTestData1 = { strResourceValue[0], "N", objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				strResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName, "", "", "", "", "",
				objUser_data.strNewUserName, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "Y", "Y", "Y" };

		objOFC.writeResultDataToParticularRow(strTestData1, strFilePath,
				"Resource", 1);

		objUpload1.clickOnUploadResourceBtn().deselectTestCheckBox();

		objUpload1.uploadFile(strFilePath).clickOnSaveBtn();
				
		objUpload1
				.verRowInUploadDetails(objUpload_data.strRow)
			    .verResourceIDInUploadDetailsRowWise(strResourceValue[0],1)
			    .verResourceNameInUploadDetailsRowWise(objResource_data.strResourceName,1)
				.verFailedInUploadDetailsRowWise(objUpload_data.strYesOrNoValue,1)
				.verGeocodeInUploadDetailsRowWise(objUpload_data.strEmptyGeoCodeVal,1)
				.verResCommentsInUploadDetailsRowWise(objUpload_data.strResComment,1)
				.verUserIDInUploadDetailsRowWise(objUser_data.strNewUserName,1)
				.verUserFullNameInUploadDetailsRowWise(objUser_data.strFullName,1)
				.verUserDeatailsInUploadDetails(objUpload_data.strYesOrNoValue,1)
				.verUserComments(" ", 1)
				.verReturnInUploadDetails();

		objUserList1.navigateToUsersNew()
		.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.verUpdateStatusOfResourceIsSelected(objResource_data.strResourceName)
				.verAssociateWithOfResourceIsSelected(objResource_data.strResourceName)
				.verRunReportRightSelected(objResource_data.strResourceName)
				
				.verViewResourceCheckBoxIsChecked(objResource_data.strResourceName1)
				.verViewResourceCheckBoxIsChecked(objResource_data.strResourceName2)
				.verViewResourceCheckBoxIsChecked(objResource_data.strResourceName3)
				
				.verRunReportRightNotSelected(objResource_data.strResourceName1)
				.verRunReportRightNotSelected(objResource_data.strResourceName2)
				.verRunReportRightNotSelected(objResource_data.strResourceName3)
				
				.verUpdateStatusOfResourceIsNotSelected(objResource_data.strResourceName1)
				.verUpdateStatusOfResourceIsNotSelected(objResource_data.strResourceName2)
				.verUpdateStatusOfResourceIsNotSelected(objResource_data.strResourceName3)
		
				.verAssociateWithOfResourceIsNotSelected(objResource_data.strResourceName1)
				.verAssociateWithOfResourceIsNotSelected(objResource_data.strResourceName2)
				.verAssociateWithOfResourceIsNotSelected(objResource_data.strResourceName3);	

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1.clickOnUsersLink(objResource_data.strResourceName)
				.verViewResourceChkboxIsSelected(objUser_data.strNewUserName)
				.verAssociateRightChkboxIsSelected(objUser_data.strNewUserName)
				.verRunReportChkboxIsSelected(objUser_data.strNewUserName)
				.verUpdateRightChkboxIsSelected(objUser_data.strNewUserName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/****************************************************************************************************
	'Description : Verify that users can be imported providing resource ID and all the affiliated rights.
	'Date	 	 : 07-Jan-2014
	'Author		 : Anitha
	'----------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "Verify that users can be imported providing resource ID and all the affiliated rights.")
	public void testHappyDay103133() throws Exception {

		gstrTCID = "103133";
		gstrTO = "Verify that users can be imported providing resource ID and all the affiliated rights.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Upload_data objUpload_data = new Upload_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[4];
		String strRoleValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UsersList objUserList1 = new UsersList(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strFilePath = file + fileUploadPath;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// First resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		objNavigationToSubMenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objResource.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);
		
		objResource.createResource(objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[2] = objResource
				.getResourceValue(objResource_data.strResourceName2);
		
		objResource.createResource(objResource_data.strResourceName3,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[3] = objResource
				.getResourceValue(objResource_data.strResourceName3);

		System.out.println(objResource_data.strResourceName);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		String[] strTestData = { strResourceValue[0], "N",
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				strResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName, "", "", "", "", "",
				objUser_data.strNewUserName, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "Y", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData, strFilePath,
				"Resource", 1);
		
		String[] strTestData1 = { strResourceValue[0], "N",
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				strResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName, "", "", "", "", "",
				objUser_data.strNewUserName1, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName1, "", "",
				"", "", "", "", "", "", "", "Y", "" };

		objOFC.writeResultDataToParticularRow(strTestData1, strFilePath,
				"Resource", 2);
		
		String[] strTestData2 = { strResourceValue[0], "N",
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				strResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName, "", "", "", "", "",
				objUser_data.strNewUserName2, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName2, "", "",
				"", "", "", "", "", "", "", "", "Y" };

		objOFC.writeResultDataToParticularRow(strTestData2, strFilePath,
				"Resource", 3);

		objUpload1.clickOnUploadResourceBtn().deselectTestCheckBox();

		objUpload1.uploadFile(strFilePath).clickOnSaveBtn();
				
		objUpload1
				.verRowInUploadDetails(objUpload_data.strRow)
			    .verResourceIDInUploadDetailsRowWise(strResourceValue[0],1)
			    .verResourceNameInUploadDetailsRowWise(objResource_data.strResourceName,1)
				.verFailedInUploadDetailsRowWise(objUpload_data.strYesOrNoValue,1)
				.verGeocodeInUploadDetailsRowWise(objUpload_data.strEmptyGeoCodeVal,1)
				.verResCommentsInUploadDetailsRowWise(objUpload_data.strResComment,1)
				.verUserIDInUploadDetailsRowWise(objUser_data.strNewUserName,1)
				.verUserFullNameInUploadDetailsRowWise(objUser_data.strFullName,1)
				.verUserDeatailsInUploadDetails(objUpload_data.strYesOrNoValue,1)
				.verUserComments(" ", 1)
				.verReturnInUploadDetails();

		objUserList1
				.navigateToUsersNew()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.verAssociateWithOfResourceIsSelected(
						objResource_data.strResourceName)

				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName1)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName2)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName3)

				.verRunReportRightNotSelected(objResource_data.strResourceName1)
				.verRunReportRightNotSelected(objResource_data.strResourceName2)
				.verRunReportRightNotSelected(objResource_data.strResourceName3)

				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName1)
				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName2)
				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName3)

				.verAssociateWithOfResourceIsNotSelected(
						objResource_data.strResourceName1)
				.verAssociateWithOfResourceIsNotSelected(
						objResource_data.strResourceName2)
				.verAssociateWithOfResourceIsNotSelected(
						objResource_data.strResourceName3).clickCancelButton();

		objUserList1
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName1)
				.verUpdateStatusOfResourceIsSelected(
						objResource_data.strResourceName)

				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName1)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName2)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName3)

				.verRunReportRightNotSelected(objResource_data.strResourceName1)
				.verRunReportRightNotSelected(objResource_data.strResourceName2)
				.verRunReportRightNotSelected(objResource_data.strResourceName3)

				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName1)
				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName2)
				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName3)

				.verAssociateWithOfResourceIsNotSelected(
						objResource_data.strResourceName1)
				.verAssociateWithOfResourceIsNotSelected(
						objResource_data.strResourceName2)
				.verAssociateWithOfResourceIsNotSelected(
						objResource_data.strResourceName3).clickCancelButton();

		objUserList1
				.searchUserName(objUser_data.strNewUserName2,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName2)
				.verRunReportRightSelected(objResource_data.strResourceName)

				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName1)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName2)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName3)

				.verRunReportRightNotSelected(objResource_data.strResourceName1)
				.verRunReportRightNotSelected(objResource_data.strResourceName2)
				.verRunReportRightNotSelected(objResource_data.strResourceName3)

				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName1)
				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName2)
				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName3)

				.verAssociateWithOfResourceIsNotSelected(
						objResource_data.strResourceName1)
				.verAssociateWithOfResourceIsNotSelected(
						objResource_data.strResourceName2)
				.verAssociateWithOfResourceIsNotSelected(
						objResource_data.strResourceName3).clickCancelButton();

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1.clickOnUsersLink(objResource_data.strResourceName)
				.verViewResourceChkboxIsSelected(objUser_data.strNewUserName)
				.verViewResourceChkboxIsSelected(objUser_data.strNewUserName1)
				.verViewResourceChkboxIsSelected(objUser_data.strNewUserName1)
				.verAssociateRightChkboxIsSelected(objUser_data.strNewUserName)
				.verUpdateRightChkboxIsSelected(objUser_data.strNewUserName1)
				.verRunReportChkboxIsSelected(objUser_data.strNewUserName2);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
