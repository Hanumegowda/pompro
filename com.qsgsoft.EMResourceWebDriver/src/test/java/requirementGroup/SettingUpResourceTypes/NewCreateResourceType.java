package requirementGroup.SettingUpResourceTypes;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewCreateResourceType extends TestNG_UI_EXTENSIONS {

	public NewCreateResourceType() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that a resource type can be created.
	'Precondition:
	'Date	 	 : 27-May-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a resource type can be created.")
	public void testHappyDay69388() throws Exception {

		gstrTCID = "69388";
		gstrTO = "Verify that a resource type can be created.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);

		String strStatusTypeValues[] = new String[1];

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType_Page1
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValues)
				.verResourceTypeInList(objResourceType_data.strResourceTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	

	/*************************************************************************************
	'Description : Verify that a Multi status type can be selected as the default status type of a resource type.
	'Precondition:
	'Date	 	 : 11-Jan-2016
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a Multi status type can be selected as the default status type of a resource type.")
	public void testHappyDay69390() throws Exception {

		gstrTCID = "69390";
		gstrTO = "Verify that a Multi status type can be selected as the default status type of a resource type.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		
		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		boolean blnTest = false;
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strGreenColor);
		
		strStatusesValues[0] = objStatusTypeList.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();
	
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		
		objnNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickSaveButton();
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		// Resource type creation
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();
		
		objResourceType_Page1.verResourceTypeListPageIsDisplayed();
		
		objResourceType_Page1.clickOnCreateNewResourceTypeButton();
		objResourceType_Page1.enterResourceTypeName(objResourceType_data.strResourceTypeName);
		objResourceType_Page1.clickStatusType(strStatusTypeValues);
		objResourceType_Page1.selectDefaultStatusType(objStatusTypes_data.strMSTStatusTypeName);
		objResourceType_Page1.clickOnSaveButton();

		objResourceType_Page1.verResourceTypeInList(objResourceType_data.strResourceTypeName);

		strResourceTypeValue[0] = objResourceType_Page1.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		// create resource with address
		objResource1.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource1
				.getResourceValue(objResource_data.strResourceName);

		objnNavigationToSubMenus1.navigateToViews();
		
		objViewsList1.createView(objView_data.strViewName, objView_data.strViewDesc,
				objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
//		objViewsList1.clickCreateNewViewButton()
//		.enterViewName(objView_data.strViewName)
//		.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList1.selectStatusType(objStatusTypes_data.strMSTStatusTypeName);
//
//
//		objViewsList1.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
//		objViewsList1.verViewInList(objView_data.strViewName);

		objViewsList1.clickOncustomizeResourceDetailView()
		 .clickOnUncategorized()
		 .enterSectionName(objView_data.strSectionName)
		 .clickOnCreateSection()
		 .verCreatedSection(objView_data.strSectionName)
		 .clickOnSaveButton();
		
		objViewsList1.verRegionViewListPageIsDisplayed();
		
		objnNavigationToSubMenus1.navigateToStatusTypesInSetup();
		
		objStatusTypeList1.clickOnEditOfStatusType(objStatusTypes_data.strMSTStatusTypeName);
		
		objStatusTypeList1.selectSectionName(objView_data.strSectionName);
		
		objStatusTypeList1.clickOnSaveButton();
		
		objnNavigationToSubMenus1.navigateToUsers();
		System.out.println(objUserdata.strNewUserName);
		objUsersList1.enterUsernameInSearchInputField(objUserdata.strNewUserName);
		objUsersList1.clickSearchButton();
		objUsersList1.editUserDetails(objUserdata.strNewUserName);
		objUsersList1.selectUpdateStatusOfResource(objResource_data.strResourceName);
		objUsersList1.clickSaveButton();

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName, objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objnNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		
		objUpdateStatus1.clickOnStatusType(strStatusTypeValues[0]);
		
		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[0],
				strStatusesValues[0]).clickOnSaveButton();
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName);
		
		objUpdateStatus1.verifyUpdatedValueGreenColor(objStatusTypes_data.strStatusNameInMulti);
		
		objnNavigationToSubMenus1.clickOnViewMenu();
		
		objnNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0], objStatusTypes_data.strMSTStatusTypeName);
		
		objViewsList1.verifyUpdatedValueGreenColor(strResourceValue[0], strStatusTypeValues[0],objStatusTypes_data.strStatusNameInMulti);
		
		objLogin1.clickLogOut();
		
		blnTest = true;
		
		if (blnTest) {
			
		String[] strTestData1 = { gstrTCID, objLogindata.strRegionName,objUserdata.strNewUserName+"/"+ objUserdata.strNewPassword,
				objStatusTypes_data.strMSTStatusTypeName, objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName, objView_data.strViewName};
		
		objOffCommonFunc.writeResultData(strTestData1,
				strPartialAutoResultsPath, "MobileTestData");
		}
		gstrResult = "PASS";
	}

}
