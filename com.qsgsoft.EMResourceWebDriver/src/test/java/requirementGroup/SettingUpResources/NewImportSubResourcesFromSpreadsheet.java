package requirementGroup.SettingUpResources;

import java.io.File;
import java.util.Properties;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.Upload_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.Upload;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewImportSubResourcesFromSpreadsheet extends TestNG_UI_EXTENSIONS{

	public NewImportSubResourcesFromSpreadsheet() throws Exception {
		super();
	}
	
	/***********************************************************************************************
	'Description : Verify that sub-resources can be uploaded under resources providing Resource ID
	'Precondition:
	'Date	 	 : 28-July-2015
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************/
	@Test(description = "Verify that sub-resources can be uploaded under resources providing Resource ID")
	public void testHappyDay107892() throws Exception {

		gstrTCID = "107892";
		gstrTO = "Verify that sub-resources can be uploaded under resources providing Resource ID";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();
		Upload_data objUpload_data = new Upload_data();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		Login_data objTest_data = new Login_data();
		Date_Time_settings dts = new Date_Time_settings();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strFilePath = file + fileUploadPath;

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		String strStatusTypes[] = { strStatusTypeValues[1] };

		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName, strStatusTypes);

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		// Create ReSource
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);

		String[] strTestData = { strResourceValue[0], "Y",
				objResource_data.strSubResourceName,
				objResource_data.strResourceAbbrivation,
				strSubResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objUserdata.strFirstName,
				objUserdata.strLastName, "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData, strFilePath,
				"Resource", 1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		objUpload1.clickOnUploadResourceBtn()
		          .verNewUploadPageIsDisplayed()
				  .verSpreadSheetAndBrowserBtnIsDisplayed().verTestIsDisplayed()
				  .uploadFile(strFilePath)
				  .verUploadedFilenameBeforeSave(objUpload_data.strExcelName)
				  .verTestCheckboxIsCheckedBeforeSave();

		objUpload1.deselectTestCheckBox()
		          .clickOnSaveBtn();
		
		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strCurDate = dts.converDateFormat(strAppTime[0] + strAppTime[1]
				+ strCurYear + " " + strAppTime[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		String[] strSplitDatetime = strCurDate.split(" ");
		
		String strCurDate1 = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "yyyy-MM-dd HH:mm");

		objUpload1
				.verUploadedFilename(objUpload_data.strExcelName)
				.verTestCheckboxIsUnchecked()
				.verUserName(objLogindata.strAdminUser)
				.verDate(strSplitDatetime[0])
				.verRowInUploadDetails(objUpload_data.strRow)
			 // .verResourceIDInUploadDetails(strResourceValue[0])
				.verResourceNameInUploadDetails(
						objResource_data.strSubResourceName)
				.verFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verGeocodeInUploadDetails(objUpload_data.strEmptyGeoCodeVal)
				.verUserIDInUploadDetails(" ")
				.verUserFullNameInUploadDetails(" ")
				.verUserFailedInUploadDetails(objUpload_data.strYesOrNoValue)
				.verReturnInUploadDetails()
				.clickOnReturnInUploadDetPage()
				.verUploadListPageIsDisplayed()
				.verUploadListHeaders()
				.verUploadListDetails(objLogindata.strAdminUser, strCurDate1,
						objUpload_data.strYesOrNoValue);

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1
				.verResourceListPageIsDisplayed()
				.verResourceNameAndDetailsInResourceList(
						objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName)
				.verifyEditLink(objResource_data.strResourceName)
				.verifyStatusTypeLink(objResource_data.strResourceName)
				.verifyUsersLink(objResource_data.strResourceName)
				.verSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.clickOnSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.verSubResourceListPageisDisplayed(
						objResource_data.strResourceName)
				.verSubResourcelistDetails(objResource_data.strSubResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strSubResourceTypeName)
				.clickOnEditLinkInSubResourceListPage(
						objResource_data.strSubResourceName)
				.verEditSubResourceOfPageIsDisplayed(
						objResource_data.strResourceName)

				.verifyResourceFieldsInEditResource(
						objResource_data.strSubResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strSubResourceTypeName,
						objUserdata.strFirstName, objUserdata.strLastName)
				.clickOncancelButton();

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.verifyStatusTypeIsSelectedAndDisabledUnderEditResLevelST(
						objStatusTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeIsSelectedAndDisabledUnderEditResLevelST(
						objStatusTypes_data.strTSTStatusTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	'Description : Verify that sub-resources cannot be uploaded by providing normal resource type id 
	               under 'ResourceType ID' column in the standard template
	'Precondition:
	'Date	 	 : 30-July-2015
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************/
	@Test(description = "Verify that sub-resources cannot be uploaded by providing normal resource type "
			+ "id under 'ResourceType ID' column in the standard template")
	public void testHappyDay107893() throws Exception {

		gstrTCID = "107893";
		gstrTO = "Verify that sub-resources cannot be uploaded by providing normal resource type id under "
				+ "'ResourceType ID' column in the standard template";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();
		Upload_data objUpload_data = new Upload_data();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		Login_data objTest_data = new Login_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Upload objUpload1 = new Upload(this.driver1);
		Resource objResource1 = new Resource(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strFilePath = file + fileUploadPath;

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		String strStatusTypes[] = { strStatusTypeValues[1] };

		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName, strStatusTypes);

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		// Create ReSource
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);

		String[] strTestData = { strResourceValue[0], "Y",
				objResource_data.strSubResourceName,
				objResource_data.strResourceAbbrivation,
				strResourceTypeValue[0], "",
				objResource_data.strStandardResTypeId, "", "N", "N", "", "",
				"", "", "", "", "", "", objUserdata.strFirstName,
				objUserdata.strLastName, "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "" };

		objOFC.writeResultDataToParticularRow(strTestData, strFilePath,
				"Resource", 1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUpload();

		objUpload1.clickOnUploadResourceBtn()
		          .verNewUploadPageIsDisplayed()
				  .verSpreadSheetAndBrowserBtnIsDisplayed().verTestIsDisplayed()
				  .uploadFile(strFilePath)
				  .verUploadedFilenameBeforeSave(objUpload_data.strExcelName)
				  .verTestCheckboxIsCheckedBeforeSave();

		objUpload1.deselectTestCheckBox()
		          .clickOnSaveBtn()
		          .verResCommentsInUploadDetails(objUpload_data.strInvalidResourceTypeID);

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1
				.verResourceListPageIsDisplayed()
				.verResourceNameAndDetailsInResourceList(
						objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName)
				.verifyEditLink(objResource_data.strResourceName)
				.verifyStatusTypeLink(objResource_data.strResourceName)
				.verifyUsersLink(objResource_data.strResourceName)
				.verifyDemoteLink(objResource_data.strResourceName)
				.verSubResources1LinkInResourceListIsNotDiaplayed(
						objResource_data.strResourceName)
				.verifySubResourcesLink(objResource_data.strResourceName)
				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verCreateNewSubResourceButtonIsPresent()
				.verifySubResourceIsNotDisplayed(
						objResource_data.strSubResourceName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}