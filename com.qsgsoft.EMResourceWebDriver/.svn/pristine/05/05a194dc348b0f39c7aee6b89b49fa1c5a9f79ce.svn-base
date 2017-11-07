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

public class HappyDayImportUsersAndResources extends TestNG_UI_EXTENSIONS{
	
	public HappyDayImportUsersAndResources() throws Exception {
		super();
	}

	/******************************************************************
	'Description : Verify that resources and users can be uploaded providing any of the affiliated right on the resources for the users.
	'Precondition:
	'Date	 	 : 25-Aug-2015
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that resources and users can be uploaded providing any of the affiliated right on the resources for the users.")
	public void testHappyDay103573() throws Exception {

		gstrTCID = "103573";
		gstrTO = "Verify that resources and users can be uploaded providing any of the affiliated right on the resources for the users.";

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
				"", "", "", "", "", "", "Y", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData1, strFilePath,
				"Resource", 1);

		String[] strTestData2 = { "", "N", objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				strResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objUser_data.strFirstName,
				objUser_data.strLastName, "", "", "", "", "",
				objUser_data.strNewUserName1, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName1, "", "",
				"", "", "", "", "", "", "", "Y", "" };

		objOFC.writeResultDataToParticularRow(strTestData2, strFilePath,
				"Resource", 2);

		String[] strTestData3 = { "", "N", objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				strResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objUser_data.strFirstName,
				objUser_data.strLastName, "", "", "", "", "",
				objUser_data.strNewUserName2, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName2, "", "",
				"", "", "", "", "", "", "", "", "Y" };

		objOFC.writeResultDataToParticularRow(strTestData3, strFilePath,
				"Resource", 3);

		objUpload1.clickOnUploadResourceBtn().verNewUploadPageIsDisplayed()
				.uploadFile(strFilePath).deselectTestCheckBox()
				.clickOnSaveBtn();

		objUpload1.verUploadedFilename(strFilePath)
				.clickOnReturnInUploadDetails();

		objNavigationToSubMenus1.navigateToUsers();

		objUserList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.verUserDetails(objUser_data.strNewUserName,
						objUser_data.strFullName, " ")
				.editUserDetails(objUser_data.strNewUserName)
				.verEditUserPageisDisplayed()
				.verNameInEditUserPage(objUser_data.strNewUserName)
				.verFullNameInEditUserPage(objUser_data.strFullName)
				.verAssociateWithOfResourceIsSelected(
						objResource_data.strResourceName)
				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName1)
				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName2)
				.verRunReportRightNotSelected(objResource_data.strResourceName1)
				.verRunReportRightNotSelected(objResource_data.strResourceName2)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName1)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName2).clickCancelButton();

		objUserList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.verUserDetails(objUser_data.strNewUserName1,
						objUser_data.strFullName1, " ")
				.editUserDetails(objUser_data.strNewUserName1)
				.verEditUserPageisDisplayed()
				.verNameInEditUserPage(objUser_data.strNewUserName1)
				.verFullNameInEditUserPage(objUser_data.strFullName1)
				.verUpdateStatusOfResourceIsSelected(
						objResource_data.strResourceName1)
				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName)
				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName2)
				.verRunReportRightNotSelected(objResource_data.strResourceName)
				.verRunReportRightNotSelected(objResource_data.strResourceName2)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName2).clickCancelButton();

		objUserList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName2)
				.clickSearchButton()
				.verUserDetails(objUser_data.strNewUserName2,
						objUser_data.strFullName2, " ")
				.editUserDetails(objUser_data.strNewUserName2)
				.verEditUserPageisDisplayed()
				.verNameInEditUserPage(objUser_data.strNewUserName2)
				.verFullNameInEditUserPage(objUser_data.strFullName2)
				.verRunReportRightSelected(objResource_data.strResourceName2)
				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName)
				.verUpdateStatusOfResourceIsNotSelected(
						objResource_data.strResourceName1)
				.verRunReportRightNotSelected(objResource_data.strResourceName)
				.verRunReportRightNotSelected(objResource_data.strResourceName1)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName1).clickCancelButton();

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1.clickOnUsersLink(objResource_data.strResourceName)
				.verAssociateRightChkboxIsSelected(objUser_data.strNewUserName)
				.clickOncancelButton();

		objResource1.clickOnUsersLink(objResource_data.strResourceName1)
				.verUpdateRightChkboxIsSelected(objUser_data.strNewUserName1)
				.clickOncancelButton();

		objResource1.clickOnUsersLink(objResource_data.strResourceName2)
				.verRunReportChkboxIsSelected(objUser_data.strNewUserName2)
				.clickOncancelButton();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description :  Verify that both resources and users can be imported at a time. 
	'Precondition:
	'Date	 	 : 22-Sep-2014
	'Author		 : Deepa
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = " Verify that both resources and users can be imported at a time. ")
	public void testHappyDay103541() throws Exception {

		gstrTCID = "103541";
		gstrTO = " Verify that both resources and users can be imported at a time. ";

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
				//.verUploadedFilename(strExcelName)
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
				objUpload_data.strYesValue, strCurDate,
				objTest_data.strUserName);

		objResource1.navigateToResourceListPage();

		objResource1.verResourceNotInList(objResource_data.strResourceName);

		objUserList1.navigateToUsersNew();

		objUserList1.clickEditForFirstUser();

		objUserList1
				.verResourceNameNotDispalyed(objResource_data.strResourceName);

		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Verify that resources and users can be uploaded providing 
				   all the affiliated right on the resources for the users. 
	'Precondition:
	'Date	 	 : 23-Sep-2014
	'Author		 : Deepa
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = " Verify that resources and users can be uploaded providing all the affiliated right on the resources for the users. ")
	public void testHappyDay103585() throws Exception {

		gstrTCID = "103585";
		gstrTO = " Verify that resources and users can be uploaded providing all the affiliated right on the resources for the users. ";

		Login_data objTest_data = new Login_data();
		Upload_data objUpload_data = new Upload_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		UsersList objUserList1 = new UsersList(this.driver1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();
		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strExcelName = "ImportResource.xls";
		String strFilePath = file + fileUploadPath;

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[3];
		String strRoleValue[] = new String[1];
		
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
		
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);
		
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

		String[] strTestData1 = { "", "N", objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				strResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objUser_data.strFirstName,
				objUser_data.strLastName, "", "", "", "", "",
				objUser_data.strNewUserName, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "Y", "Y", "Y" };

		objOFC.writeResultDataToParticularRow(strTestData1, strFilePath,
				"Resource", 1);
		
		objUpload1.clickOnUploadResourceBtn().verNewUploadPageIsDisplayed()
				.verSpreadSheetAndBrowserBtnIsDisplayed().verTestIsDisplayed()
				.deselectTestCheckBox();

		objUpload1.uploadFile(strFilePath)
				  .clickOnSaveBtn();

		objUpload1
				.verUploadedFilename(strExcelName)
				.verTestCheckboxIsChecked()
				.clickOnReturnInUploadDetails();

		objUserList1.navigateToUsersNew()
				    .clickOnShowAllUsersIfPresent();

		objUserList1.verUserInList(objUser_data.strNewUserName);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
