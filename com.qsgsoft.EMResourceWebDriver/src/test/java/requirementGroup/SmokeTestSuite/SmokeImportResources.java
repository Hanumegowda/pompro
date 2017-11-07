package requirementGroup.SmokeTestSuite;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.Properties;

import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.Upload_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.Upload;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class SmokeImportResources extends TestNG_UI_EXTENSIONS {

	public SmokeImportResources() throws Exception {
		super();
	}
	
	/******************************************************************
	'Description : Verify that RegAdmin can upload resource providing mandatory data.
	'Precondition:
	'Date	 	 : 26-Sep-2014
	'Author		 : Sowmya
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that RegAdmin can upload resource providing mandatory data.")
	public void testSmoke126266() throws Exception {

		gstrTCID = "126266";
		gstrTO = "Verify that RegAdmin can upload resource providing mandatory data.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Report_data objReport_data = new Report_data();
		Upload_data objUpload_data = new Upload_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();

		// String strExcelName = "UploadResourcesTemplate.xls";

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.xlsFile;

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strExcelName = "ImportResource.xls";
		String strFilePath = file + fileUploadPath;

		/*
		 * // Auto it path String AutoIT_FILE_PATH =
		 * objReport_data.UploadTemplateFilePath; String strAutoItPath =
		 * ReadAutoItProperty .readDataFromAutoItPath(AutoIT_FILE_PATH); String
		 * strAutoFileName = pathProps
		 * .getProperty(objReport_data.UploadTemplateFileName); String
		 * fileDownloadPath = pathProps
		 * .getProperty(objReport_data.reportsDownloadPath); File file = new
		 * File(System.getProperty("user.dir") + fileDownloadPath); String
		 * strDownloadName = file + "\\" + "142238" + "_" + strTimeText +
		 * fileType;
		 */

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

		Thread.sleep(5000);

		objRegionDefault1.selectFrame().clickRegionLink();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		/*
		  objUpload1.verUploadListPageIsDisplayed()
		  .verUploadTemplateIsDisplayed() .verUploadResourceBtnIsDisplayed();
		  
		  objAutoIT.downloadUploadTemplate(strAutoItPath, strAutoFileName,
		  strDownloadName);
		  
		  String[][] strTestData = { { "ResourceID", "SubResource",
		  "ResourceName", "Abbrev", "ResourceTypeID", "ResourceType",
		  "StandardResourceTypeID", "StandardResourceType", "HAvBED", "Shared",
		  "AhaID", "ExternalID", "StreetAddress", "City", "State", "ZipCode",
		  "County", "ContactFirstName", "ContactLastName", "ContactAddress",
		  "ContactPhone1", "ContactPhone2", "ContactFax", "ContactEMail",
		  "UserID", "RoleID", "RoleName", "Password", "FullName", "FirstName",
		  "MiddleName", "LastName", "Organization", "WorkPhone",
		  "PrimaryEMail", "AlternateEMails", "TextPager", "Associated",
		 "Update", "Reports" } };
		  
		  objOFC.readAndVerifyDataExcelNew(strTestData, strFilePath);
		 */

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
				.verSpreadSheetAndBrowserBtnIsDisplayed().verTestIsDisplayed();

		objUpload1.uploadFile(strFilePath).clickOnSaveBtn();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strCurDate = dts.converDateFormat(strAppTime[0] + strAppTime[1]
				+ strCurYear + " " + strAppTime[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		String strDate[] = strCurDate.split(" ");

		objUpload1
				.verUploadedFilename(strFilePath)
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

		objUpload1.clickOnUploadResourceBtn().verNewUploadPageIsDisplayed()
				.deselectTestCheckBox();

		objUpload1.uploadFile(strFilePath).clickOnSaveBtn();

		objUpload1
				.verUploadedFilename(strFilePath)
				.verTestCheckboxIsUnchecked()
				.verUserName(objTest_data.strUserName)
				.verDate(strDate[0])
				.verRowInUploadDetails(objUpload_data.strRow)
				.verResourceNameInUploadDetails(
						objResource_data.strResourceName)
				.verFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verUserIDInUploadDetails(objUser_data.strNewUserName)
				.verUserFullNameInUploadDetails(objUser_data.strFullName)
				.verUserFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verReturnInUploadDetails();

		String strResourceId = objUpload1.getResourceIdInUploadDetails();

		objUpload1.clickOnResourceId(objResource_data.strResourceName);

		objResource1
				.verEditResourcePageisDisplayed()
				.verifyResourceFieldsInEditResource(
						objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objUser_data.strFirstName, objUser_data.strLastName)
				.clickOncancelButton()
				.verResourceListPageIsDisplayed()
				.verResourceNameAndDetailsInResourceList(
						objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName)
				.verifyEditLink(objResource_data.strResourceName)
				.verifyStatusTypeLink(objResource_data.strResourceName)
				.verifyUsersLink(objResource_data.strResourceName)
				.verifySubResourcesLink(objResource_data.strResourceName)
				.verifyDemoteLink(objResource_data.strResourceName);

		String strResValue = objResource1
				.getResourceValue(objResource_data.strResourceName);

		assertEquals(strResourceId, strResValue);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
		
	}

	/*************************************************************************************
	 * 'Description 	: Verify that 'Test' can be performed prior to uploading
	 * both resources and users. 
	 * 'Precondition 	: 
	 * 'Date 			: 26-Sep-2014 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 ********************************************************************************************/
	@Test(description = "Verify that 'Test' can be performed prior to uploading both resources and users.")
	public void testSmoke109023() throws Exception {

		gstrTCID = "109023";
		gstrTO = "Verify that 'Test' can be performed prior to uploading both resources and users.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();
		Upload_data objUpload_data = new Upload_data();

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strFilePath = file + fileUploadPath;

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objNavigationToSubMenus.navigateToUpload();

		String[] strTestData = { "", "N", objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				strResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objUser_data.strFirstName,
				objUser_data.strLastName, "", "", "", "", "",
				objUser_data.strNewUserName, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData, strFilePath,
				"Resource", 1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		objUpload1.clickOnUploadResourceBtn().verNewUploadPageIsDisplayed()
				.uploadFile(strFilePath).clickOnSaveBtn();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strCurDate = dts.converDateFormat(strAppTime[0] + strAppTime[1]
				+ strCurYear + " " + strAppTime[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		String strDate[] = strCurDate.split(" ");

		objUpload1
				.verUploadedFilename(strFilePath)
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
				.verReturnInUploadDetails();

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1.verResourceInNotInList(objResource_data.strResourceName);

		objNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.verUserNotInList(objUser_data.strNewUserName);

		objNavigationToSubMenus1.navigateToUpload();

		String strDateInUploadList = dts.converDateFormat(strCurDate,
				"MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");

		objUpload1.verUploadListPageIsDisplayed()
				.clickOnViewDetails(strDateInUploadList)
				.verUserIsNotHyperLinked(objUser_data.strNewUserName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description :Verify that user can be uploaded providing mandatory data in the standard template used for uploading
	'Precondition:
	'Date	 	 : 26-Sep-2014
	'Author		 : Prasanna Lakshmi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user can be uploaded providing mandatory data in the standard template used for uploading")
	public void testSmoke108932() throws Exception {

		gstrTCID = "108932";
		gstrTO = "Verify that user can be uploaded providing mandatory data in the standard template used for uploading";

		Login objLogin = new Login(this.driver1);
		Login_data objTest_data = new Login_data();
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		Roles_data objRolesData = new Roles_data();
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();
		Date_Time_settings dts = new Date_Time_settings();
		Upload_data objUpload_data = new Upload_data();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		Resource objResource = new Resource(this.driver1);

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strFilePath = file + fileUploadPath;

		Login objLogin1 = new Login(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		String strRoleValue[] = new String[1];
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased status types

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// resource creation

		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Create role
		
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objNavigationToSubMenus.navigateToUpload();

		String[] strTestData = { "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "",
				objUserdata.strNewUserName, strRoleValue[0], "",
				objUserdata.strNewPassword, objUserdata.strFullName, "", "",
				"", "", "", "", "", "", "N", "N", "N" };

		objOFC.writeResultDataToParticularRow(strTestData, strFilePath,
				"Resource", 1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		String strCurDate = dts.getCurrentDate("MM/dd/yyyy");

		objUpload1
				.clickOnUploadResourceBtn()
				.verNewUploadPageIsDisplayed()
				.uploadFile(strFilePath)
				.clickOnSaveBtn()
				.verUploadedFilename(strFilePath)
				.verTestCheckboxIsChecked()
				.verUserName(objTest_data.strUserName)
				.verDate(strCurDate)
				.verRowInUploadDetails(objUpload_data.strRow)
				.verResourceNameInUploadDetails(
						" ")
				.verFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verGeocodeInUploadDetails(objUpload_data.strEmptyGeoCodeVal)
				.verUserIDInUploadDetails(objUserdata.strNewUserName)
				.verUserFullNameInUploadDetails(objUserdata.strFullName)
				.verUserFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verReturnInUploadDetails().clickOnReturnInUploadDetPage()
				.clickOnUploadResourceBtn().uploadFile(strFilePath)
				.deselectTestCheckBox().clickOnSaveBtn();

		objUpload1
				.verUploadedFilename(strFilePath)
				.verTestCheckboxIsUnchecked()
				.verUserName(objTest_data.strUserName)
				.verDate(strCurDate)
				.verRowInUploadDetails(objUpload_data.strRow)
				.verResourceNameInUploadDetails(
						" ")
				.verFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verGeocodeInUploadDetails(objUpload_data.strEmptyGeoCodeVal)
				.verUserIDLinkInUploadDetails(objUserdata.strNewUserName)
				.verUserFullNameInUploadDetails(objUserdata.strFullName)
				.verUserFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.clickOnUserName(objUserdata.strNewUserName);

		objUsersList1
				.verEditUserPageisDisplayed()
				.verResourceNameIsDisplayedInEditUserPage(
						objResource_data.strResourceName)
				.verResourceTypeIsDisplayedInEditUserPage(
						objResourceType_data.strResourceTypeName)
				.verifyRoleNameInEditUserPage(strRoleValue[0])
				.clickCancelButton()
				.verifyUserListPageIsDisplayed()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.verFullName(objUserdata.strNewUserName,
						objUserdata.strFullName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description :"Verify that user can import sub resource providing mandatory data.")
	'Precondition:
	'Date	 	 : 29-Sep-2014
	'Author		 : Shradha
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	
	@Test(description = "Verify that user can import sub resource providing mandatory data.")
	public void testSmoke108933() throws Exception {
		gstrTCID = "108933";
		gstrTO = "Verify that user can import sub resource providing mandatory data.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		Login_data objTest_data = new Login_data();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();
		Upload_data objUpload_data = new Upload_data();
		Date_Time_settings dts = new Date_Time_settings();
		Resource objResource1 = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[2];
		String strResourceTypeValue[] = new String[2];

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strFilePath = file + fileUploadPath;

		// login to the page
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// create two status types1
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// create two status types2
		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// navigate to resource type
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		// create resource type
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		String strStatusTypes[] = { strStatusTypeValues[1] };

		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName, strStatusTypes);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);
		
		objResource.navigateToResourceListPage();
		
		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		String[] strTestData = { strResourceValue[0],
				"Y",
				objResource_data.strSubResourceName,
				objResource_data.strResourceAbbrivation,
				strResourceTypeValue[1], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objUserdata.strFirstName,
				objUserdata.strLastName, "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData, strFilePath,
				"Resource", 1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		objUpload1.clickOnUploadResourceBtn().verNewUploadPageIsDisplayed()
				.uploadFile(strFilePath).clickOnSaveBtn();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strCurDate = dts.converDateFormat(strAppTime[0] + strAppTime[1]
				+ strCurYear + " " + strAppTime[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		String[] strSplitDatetime = strCurDate.split(" ");

		objUpload1
				.verUploadedFilename(strFilePath)
				.verTestCheckboxIsChecked()
				.verUserName(objTest_data.strUserName)
				.verDate(strSplitDatetime[0])
				.verRowInUploadDetails(objUpload_data.strRow)
				.verResourceIDInUploadDetails(strResourceValue[0])
				.verResourceNameInUploadDetails(
						objResource_data.strSubResourceName)
				.verFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verGeocodeInUploadDetails(objUpload_data.strEmptyGeoCodeVal)
				.verUserIDInUploadDetails(" ")
				.verUserFullNameInUploadDetails(" ")
				.verUserFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verReturnInUploadDetails().clickOnReturnInUploadDetPage()
		        .clickOnUploadResourceBtn().uploadFile(strFilePath)
				.deselectTestCheckBox()
				.clickOnSaveBtn()
				.clickOnResourceId(objResource_data.strSubResourceName);

		objResource1
				.verEditSubResourcePageisDisplayed()
				.clickOncancelButton()
				.verResourceListPageIsDisplayed()
				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verSubResourcelistDetails(
						objResource_data.strSubResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strSubResourceTypeName);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

	/*******************************************************************************************
	'Description : Verify that both resource and user can be uploaded to web."
	'Precondition:
	'Date	 	 : 07-oct-2014
	'Author		 : Shradha
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	
	@Test(description = "Verify that both resource and user can be uploaded to web")
	public void testSmoke108934() throws Exception {
		gstrTCID = "108934";
		gstrTO = "Verify that user can import sub resource providing mandatory data.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();
		Upload_data objUpload_data = new Upload_data();

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		Date_Time_settings dts = new Date_Time_settings();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strFilePath = file + fileUploadPath;

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objNavigationToSubMenus.navigateToUpload();

		String[] strTestData = { "", "N",objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				strResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objUser_data.strFirstName,
				objUser_data.strLastName, "", "", "", "", "",
				objUser_data.strNewUserName, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData, strFilePath,
				"Resource", 1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToUpload();

		objUpload1.clickOnUploadResourceBtn().verNewUploadPageIsDisplayed()
				.uploadFile(strFilePath).deselectTestCheckBox().clickOnSaveBtn();
		
		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strCurDate = dts.converDateFormat(strAppTime[0] + strAppTime[1]
				+ strCurYear + " " + strAppTime[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");
		
		String strDate[] = strCurDate.split(" ");
	
		objUpload1
				.verUploadedFilename(strFilePath)
				.verTestCheckboxIsChecked()
				.verUserName(objTest_data.strUserName)
				.verDate(strDate[0])
				.verRowInUploadDetails(objUpload_data.strRow)
				.verResourceIdIsHperlinked(objResource_data.strResourceName)
				.verResourceNameInUploadDetails(
						objResource_data.strResourceName)
				.verFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verUserIDInUploadDetails(objUser_data.strNewUserName)
				.verUserIdIsHperlinked(objUser_data.strNewUserName)
				.verUserFullNameInUploadDetails(objUser_data.strFullName)
				.verUserFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verReturnInUploadDetails();
		
	
		objUpload1.clickOnResourceId(objResource_data.strResourceName);
		
		objResource1.verEditResourcePageisDisplayed();
		
		objNavigationToSubMenus1.navigateToResourceInSetup();
		
		System.out.println(objResource_data.strResourceName);
		
		objResource1.verResourceListPageIsDisplayed()
					.verResourceInList(objResource_data.strResourceName)
					.verResourceAbbrivationInResourceListPage(objResource_data.strResourceAbbrivation)
					.verResourceTypeInResourceListPage(objResourceType_data.strResourceTypeName)
					.clickOnEditLinkInResourcePage(objResource_data.strResourceName)
					.verEditResourcePageisDisplayed()
					.verNameInEditResource(objResource_data.strResourceName)
					.verAbbreviationInEditResource(objResource_data.strResourceAbbrivation)
					.verResourceTypenameInEditResource(objResourceType_data.strResourceTypeName)
					.verStandardResourceTypenameInEditResource(objResource_data.strStandardResourceTypename1)
					.verResourcefirstNameInEditResource(objUser_data.strFirstName)
					.verResourceLastNameInEditResource(objUser_data.strLastName)
					.clickOncancelButton();
		
		objNavigationToSubMenus1.navigateToUsers();
		
		objUsersList1.verifyUserListPageIsDisplayed()
					 .enterUsernameInSearchInputField(objUser_data.strNewUserName)
					 .clickSearchButton()
					 .verUserDetails(objUser_data.strNewUserName, objUser_data.strFullName," ")
					 .editUserDetails(objUser_data.strNewUserName)
					 .verEditUserPageisDisplayed()
					 .verNameInEditUserPage(objUser_data.strNewUserName)
					 .verFullNameInEditUserPage(objUser_data.strFullName)
					 .selectRoleCheckBox(strRoleValue)
					 .verViewResourceCheckBoxIsChecked(objResource_data.strResourceName);
        
		objNavigationToSubMenus1.navigateToResourceInSetup();
       
		objResource1.verResourceListPageIsDisplayed()
        			.selectUsersLinkInResourceList(objResource_data.strResourceName)
        			.verAssignUserstoResourcePageIsDisplayed(objResource_data.strResourceName)
        			.verViewResourceChkboxIsSelected(objUser_data.strNewUserName);
             
		String strDateInUploadList = dts.converDateFormat(strCurDate,
				"MM/dd/yyyy HH:mm", "yyyy-MM-dd HH:mm");
		
        objNavigationToSubMenus1.navigateToUpload();
        
        objUpload1.verUploadListPageIsDisplayed()
        		  .clickOnViewDetails(strDateInUploadList)
        		  .verUploadDetaillPageisDisplayed()
        		  .clickOnUserName(objUser_data.strNewUserName);
        
        objUsersList1.verEditUserPageisDisplayed()
        			 .verNameInEditUserPage(objUser_data.strNewUserName)
        			 .verFullNameInEditUserPage(objUser_data.strFullName);
        
        objLogin1.clickLogOut();
        
    	gstrResult = "PASS";
	}
}



