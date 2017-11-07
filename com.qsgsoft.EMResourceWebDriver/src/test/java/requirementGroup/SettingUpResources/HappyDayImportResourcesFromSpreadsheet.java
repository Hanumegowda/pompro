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

public class HappyDayImportResourcesFromSpreadsheet extends TestNG_UI_EXTENSIONS{
	
	public HappyDayImportResourcesFromSpreadsheet() throws Exception {
		super();
	}
	
	/******************************************************************
	'Description : Verify that user can 'Test' prior to uploading resources. 
	'Precondition:
	'Date	 	 : 22-Jul-2014
	'Author		 : Deepa
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that user can 'Test' prior to uploading resources. ")
	public void testBQS102965() throws Exception {

		gstrTCID = "102965";
		gstrTO = "Verify that user can 'Test' prior to uploading resources. ";

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
	'Description : Verify that user can upload resources providing data
	 			   in the mandatory field.
	'Precondition:
	'Date	 	 : 24-Jul-2014
	'Author		 : Deepa
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that user can upload resources providing data in the mandatory field.")
	public void testBQS102966() throws Exception {

		gstrTCID = "102966";
		gstrTO = "Verify that user can upload resources providing data in the mandatory field.";

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

		String[] strTestData1 = {"", "N", objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation, strResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objUser_data.strFirstName,
				objUser_data.strLastName, "", "", "", "", "",
				objUser_data.strNewUserName, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName, "", "",
				"", "", "", "", "", "", "", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData1, strFilePath,
				"Resource", 1);

		objUpload1.clickOnUploadResourceBtn().verNewUploadPageIsDisplayed()
				.verSpreadSheetAndBrowserBtnIsDisplayed().verTestIsDisplayed().deselectTestCheckBox();

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
				objUpload_data.strYesOrNoValue, strCurDate,
				objTest_data.strUserName);

		objNavigationToSubMenus1.navigateToResourceInSetup();
		
		objResource1
				.verResourceInList(objResource_data.strResourceName)
				.clickOnEditLinkInResourcePage(objResource_data.strResourceName)
				.verifyResourceNameInEditResource(
						objResource_data.strResourceName)
				.verifyResourceTypenameInEditResource(
						objResourceType_data.strResourceTypeName)
				.verAbbreviationInEditResource(
						objResource_data.strResourceAbbrivation)
				.verifyResourceFirstNameInEditResource(
						objUser_data.strFirstName)
				.verifyResourceLastNameInEditResource(objUser_data.strLastName);
		
		objUserList1.navigateToUsersNew();

		objUserList1.clickEditForFirstUser();

		objUserList1
				.verResourceName(objResource_data.strResourceName);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Verify that only RegAdmin (EMSystems Administrator) can import resources.
	'Precondition:
	'Date	 	 : 28-Jul-2014
	'Author		 : Deepa
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that only RegAdmin (EMSystems Administrator) can import resources.")
	public void testBQS102968() throws Exception {

		gstrTCID = "102968";
		gstrTO = "Verify that only RegAdmin (EMSystems Administrator) can import resources.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		User_data objUserdata = new User_data();

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Upload objUpload1 = new Upload(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objNavigationToSubMenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.selectReportformDetail().clickSaveButton();

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

		objUpload1.clickOnUploadResourceBtn();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnSetUp()
				.verUploadSubMenuIsNotDisplayed();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Verify that user cannot upload duplicate resources.
	'Precondition:
	'Date	 	 : 29-Jul-2014
	'Author		 : Deepa
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that user cannot upload duplicate resources.")
	public void testBQS102967() throws Exception {

		gstrTCID = "102967";
		gstrTO = "Verify that user cannot upload duplicate resources.";

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
		String strResNames[] = new String[4];
		String strResFailedValues[] = new String[4];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);

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

		String[] strTestData2 = { "", "N", objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				strResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objUser_data.strFirstName,
				objUser_data.strLastName, "", "", "", "", "",
				objUser_data.strNewUserName1, strRoleValue[0], "",
				objUser_data.strNewPassword, objUser_data.strFullName1, "", "",
				"", "", "", "", "", "", "", "", "" };

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
				"", "", "", "", "", "", "", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData3, strFilePath,
				"Resource", 3);

		objOFC.writeResultDataToParticularRow(strTestData3, strFilePath,
				"Resource", 4);

		strResNames[0] = objResource_data.strResourceName;
		strResNames[1] = objResource_data.strResourceName1;
		strResNames[2] = objResource_data.strResourceName2;
		strResNames[3] = objResource_data.strResourceName2;

		strResFailedValues[0] = "Yes";
		strResFailedValues[1] = "Yes";
		strResFailedValues[2] = "No";
		strResFailedValues[3] = "Yes";

		objUpload1.clickOnUploadResourceBtn().verNewUploadPageIsDisplayed()
				.verSpreadSheetAndBrowserBtnIsDisplayed().verTestIsDisplayed()
				.deselectTestCheckBox();

		objUpload1.uploadFile(strFilePath).clickOnSaveBtn();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

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
				.verResFailedInUploadDetails(strResNames, strResFailedValues)
				.verDuplicateResComment(objResource_data.strResourceName)
				.verDuplicateResComment(objResource_data.strResourceName1)
				.verDuplicateResComment(objResource_data.strResourceName2);

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1.verResourceInList(objResource_data.strResourceName2)
				.verResourceIsDisplayedOnceInList(objResource_data.strResourceName)
				.verResourceIsDisplayedOnceInList(objResource_data.strResourceName1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Verify that latitude and longitude are calculated 
				   accordingly while importing resources for which address is provided.
	'Precondition:
	'Date	 	 : 28-Jul-2014
	'Author		 : Deepa
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that latitude and longitude are calculated accordingly while importing resources for which address is provided.")
	public void testBQS103104() throws Exception {

		gstrTCID = "103104";
		gstrTO = "Verify that latitude and longitude are calculated accordingly while importing resources for which address is provided.";

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
				"135south,84th street,Suit150", "Milwaukee", "WI", "53214",
				"WI", "US", objUser_data.strFirstName,
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
				.verUserFailedInUploadDetails(objUpload_data.strYesOrNoValue);

		objNavigationToSubMenus1.navigateToResourceInSetup();
		
		objResource1
				.verResourceInList(objResource_data.strResourceName)
				.clickOnEditLinkInResourcePage(objResource_data.strResourceName)
				.verifyResourceNameInEditResource(
						objResource_data.strResourceName)
				.verifyResourceTypenameInEditResource(
						objResourceType_data.strResourceTypeName)
				.verAbbreviationInEditResource(
						objResource_data.strResourceAbbrivation)
				.verifyResourceFirstNameInEditResource(
						objUser_data.strFirstName)
				.verifyResourceLastNameInEditResource(objUser_data.strLastName)
				.verifyStreetInEditResource("135south,84th street,Suit150")
				.verifyCityInEditResource("Milwaukee")
				.verifyStateInEditResource("WI")
				.verLattitudePopulated()
				.verLongitudePopulated();

		gstrResult = "PASS";
	}
	
}
