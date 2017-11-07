package requirementGroup.SettingUpResources;

import java.util.concurrent.TimeUnit;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
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

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEditStatusTypesAtResourceLevel extends TestNG_UI_EXTENSIONS {

	public NewEditStatusTypesAtResourceLevel() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Add a status type to a resource and verify that changing the resource type of the resource does not change the resource level status types.
	'Precondition:
	'Date	 	 : 29-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Add a status type to a resource and verify that changing the resource type of the resource does not change the resource level status types.")
	public void testHappyDay36746() throws Exception {

		gstrTCID = "36746";
		gstrTO = "Add a status type to a resource and verify that changing the resource type of the resource does not change the resource level status types.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		
		UsersList objUsersList_page = new UsersList(this.driver1);

		String strStatusTypeValues[] = new String[3];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

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
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);
		String[] strStatusValues = {strStatusTypeValues[0], strStatusTypeValues[2]};
		String[] strStatusValues1 = {strStatusTypeValues[1], strStatusTypeValues[2]};
		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusValues)
				.verResourceTypeInList(objResourceType_data.strResourceTypeName);

		objResourceType_Page
		.createResourceType(objResourceType_data.strResourceTypeName1,
				strStatusValues1)
		.verResourceTypeInList(objResourceType_data.strResourceTypeName1);
		
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, 
				objResource_data.strStandardResourceTypename,objResource_data.strResourceFirstName, objResource_data.strResourceLastName);

		objResource.createResource(objResource_data.strResourceName1, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName1, 
				objResource_data.strStandardResourceTypename,objResource_data.strResourceFirstName, objResource_data.strResourceLastName);
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList_page
		.navigateToUsersNew()
		.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectSetupResourceOption()
		.selectSetupResourceTypesOption()
		.clickSaveButton();
		
		objLogin.clickLogOut();
		
		Thread.sleep(5000);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();
		
		String[] strOneStatus = {strStatusTypeValues[1]};
		
		objResource1.selectStatusType(strOneStatus)
		.clickOnSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		
		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1
		.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
	
		objNavigationToSubmenus1.navigateToResourceInSetup();
		
		objResource1.clickOnEditLinkInResourcePage(objResource_data.strResourceName)
		.selectResourceTypename(objResourceType_data.strResourceTypeName1)
		.clickOnSaveButton();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		objResource1.verifyStatusTypeIsSelectedAndDisabledUnderEditResLevelST(objStatusTypes_data.strDateStatusTypeName);
		objResource1.verifyStatusTypeIsSelectedAndDisabledUnderEditResLevelST(objStatusTypes_data.strTSTStatusTypeName);
		objResource1.clickOncancelButton();
		
		objResource1.verResourceListPageIsDisplayed();
		
		objResource1.clickOnEditLinkInResourcePage(objResource_data.strResourceName)
		.selectResourceTypename(objResourceType_data.strResourceTypeName)
		.clickOnSaveButton();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		objResource1.verifyStatusTypeIsSelectedAndDisabledUnderEditResLevelST(objStatusTypes_data.strDateStatusTypeName);
		objResource1.verifyStatusTypeIsSelectedAndDisabledUnderEditResLevelST(objStatusTypes_data.strNSTStatusTypeName);	
		objResource1.verifyStatusTypeIsSelectedUnderEditResLevelST(objStatusTypes_data.strTSTStatusTypeName);
		objResource1.clickOncancelButton();
		gstrResult = "PASS";
	}
	
	/*****************************************************************************************************************
	'Description : Verify that a user with ‘Setup Resource Type’ right can add the status types at the resource level.
	'Date	 	 : 01-July-2015
	'Author		 : Anitha
	'-----------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                      Modified By
	'Date					                                                                  Name
	******************************************************************************************************************/
	@Test(description ="Verify that a user with ‘Setup Resource Type’ right can add the status types at the resource level.")
	public void testHappyDay49988() throws Exception {

		gstrTCID = "49988";
		gstrTO = "Verify that a user with ‘Setup Resource Type’ right can add the status types at the resource level.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		Resource objResource = new Resource(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);

		String strStatusTypeValues[] = new String[3];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

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

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		String[] strStatusValues = { strStatusTypeValues[0],
				strStatusTypeValues[1] };

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusValues);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton();

		objLogin.clickLogOut();
		
		System.out.println("---------Precondition ends test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.verCreateNewResourceButtonIsPresent()
				.verifyEditLink(objResource_data.strResourceName)
				.verifyUsersLink(objResource_data.strResourceName)
				.verifyStatusTypeLink(objResource_data.strResourceName)

				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.verEditResourceLevelStatusTypesPageisDisplayed()
				.verifyStatusTypeIsSelectedAndDisabledUnderEditResLevelST(
						objStatusTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeIsSelectedAndDisabledUnderEditResLevelST(
						objStatusTypes_data.strTSTStatusTypeName)
				.verifyStatusTypeIsNotSelectedAndEnabledUnderEditResLevelST(
						objStatusTypes_data.strDateStatusTypeName);

		String[] strOneStatus = { strStatusTypeValues[2] };

		objResource1
				.selectStatusType(strOneStatus)
				.clickOnSaveButton()
				.verResourceListPageIsDisplayed()
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.verifyStatusTypeIsSelectedAndEnabledUnderEditResLevelST(
						objStatusTypes_data.strDateStatusTypeName)
				.clickOncancelButton();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Add a status type to resource RS and verify that a user with “Update Status” right on the resource RS, “Must Update Overdue Status” right and the role to update the status type ST is prompted to update the status of ST on login.
	'Precondition:
	'Date	 	 : 29-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Add a status type to resource RS and verify that a user with “Update Status” right on the resource RS, “Must Update Overdue Status” right and the role to update the status type ST is prompted to update the status of ST on login.")
	public void testHappyDay36784() throws Exception {

		gstrTCID = "36784";
		gstrTO = "Add a status type to resource RS and verify that a user with “Update Status” right on the resource RS, “Must Update Overdue Status” right and the role to update the status type ST is prompted to update the status of ST on login.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UpdateStatus UpdateStatus_Page1 = new UpdateStatus(
				this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		
		String strStatusTypeValues[] = new String[4];
		String strStatusTypeValues1[] = new String[1];
		String strStatusesValues[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);
		
		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti,objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);
						
		strStatusesValues[0] = objStatusTypeList.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();
		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValues1)
				.verResourceTypeInList(objResourceType_data.strResourceTypeName);

		
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, 
				objResource_data.strStandardResourceTypename,objResource_data.strResourceFirstName, objResource_data.strResourceLastName, 
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);
		objResource.createResourceWithAddress(objResource_data.strResourceName1, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, 
				objResource_data.strStandardResourceTypename,objResource_data.strResourceFirstName, objResource_data.strResourceLastName, 
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList_page
		.navigateToUsersNew()
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectSetupResourceOption()
		.selectSetupResourceTypesOption()
		.clickSaveButton();
		
		objUsersList_page.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectViewResourceCheckBox(objResource_data.strResourceName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.selectMustUpdateOverdueStatusOption()
		.clickSaveButton();
		System.out.println(objUserdata.strNewUserName1);
		objLogin.clickLogOut();
		
		Thread.sleep(5000);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();
		
		objResource1.selectStatusType(strStatusTypeValues)
		.clickOnSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objRegionDefault1.verifyUpdateStatusPage();
		objRegionDefault1.verifyResourceStatusOverDueStatus(objResource_data.strResourceName);
		for(int intCount = 0; intCount<strStatusTypeValues.length; intCount++){
		UpdateStatus_Page1.verifyOverDueStatusIsDisplayed(strStatusTypeValues[intCount]);
		}
		UpdateStatus_Page1.clickOnRemindMeIn10MinBtn();
		
		objRegionDefault1.verifyRegionDefaultPage();

		objRegionDefault1.verifyUpdateStatusPageNotDisplayed();
		
		// Wait for 10 min
		TimeUnit.MINUTES.sleep(11);

		objLinksAtTopRightCorners1.clickOnRefresh();
		
		objRegionDefault1.verifyUpdateStatusPage();
		objRegionDefault1.verifyResourceStatusOverDueStatus(objResource_data.strResourceName);
		for(int intCount = 0; intCount<strStatusTypeValues.length; intCount++){
		UpdateStatus_Page1.verifyOverDueStatusIsDisplayed(strStatusTypeValues[intCount]);
		}

		UpdateStatus_Page1.selectMSTUpdateValue(strStatusTypeValues[3], strStatusesValues[0]);
		
		UpdateStatus_Page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0], objView_data.strValueForUpdate);
		
		UpdateStatus_Page1.enterNSTAndTSTUpdateValue(strStatusTypeValues[1], objView_data.strValueForTST);
		
		UpdateStatus_Page1.enterUpdateSSTValues(strStatusTypeValues[2], objView_data.strValueForSST);
		
		UpdateStatus_Page1.clickOnSaveButton();
		
		objNavigationToSubmenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();
		
		objMap1.verUpdateValuesInPopupWindow(objView_data.strValueForUpdate);
		
		objMap1.verUpdateValuesInPopupWindow(objView_data.strValueForTST);
		
		objMap1.verUpdateValuesInPopupWindow(objView_data.strUpdatedValForSST);
		
		objMap1.verUpdateValuesInPopupWindow(objStatusTypes_data.strStatusNameInMulti);
		
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	
	/*************************************************************************************
	'Description : Add a status type to resource RS and verify that custom view can be created selecting newly added status type and resource RS.
	'Precondition:
	'Date	 	 : 29-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " Add a status type to resource RS and verify that custom view can be created selecting newly added status type and resource RS.")
	public void testHappyDay36781() throws Exception {

		gstrTCID = "36781";
		gstrTO = " Add a status type to resource RS and verify that custom view can be created selecting newly added status type and resource RS.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UpdateStatus UpdateStatus_Page1 = new UpdateStatus(
				this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValue1[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);
		
		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objResourceType_Page.navigateToResourceTypePage();
		
		objResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValues1)
				.verResourceTypeInList(objResourceType_data.strResourceTypeName);

		
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, 
				objResource_data.strStandardResourceTypename,objResource_data.strResourceFirstName, objResource_data.strResourceLastName, 
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);
		
		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objResource.createResourceWithAddress(objResource_data.strResourceName1, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, 
				objResource_data.strStandardResourceTypename,objResource_data.strResourceFirstName, objResource_data.strResourceLastName, 
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);
		
		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList_page
		.navigateToUsersNew()
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectSetupResourceOption()
		.selectSetupResourceTypesOption()
		.selectViewcustomViewOption()
		.clickSaveButton();
		
		objLogin.clickLogOut();
		
		Thread.sleep(5000);
		System.out.println(objUserdata.strNewUserName);
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource1.verEditResourceLevelStatusTypesPageisDisplayed();
		
		objResource1.selectStatusType(strStatusTypeValues)
		.clickOnSaveButton();
		
		objResource1.verResourceListPageIsDisplayed();
		
		objNavigationToSubmenus1.navigateToCustomizedViewInPrefrences();
		
		String arrResourceNames[] = { objResource_data.strResourceName};
		String strStatusTypeNames[] = {objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strTSTStatusTypeName};
		
		objCustomUnderView1.verEditCustomViewScreenIsDisplayed()
								  .clickOnAddMoreResources()
						  .enterResNameInWhatField(objResource_data.strResourceName)
						  .clickOnSearch()
						  .selectResource(strResourceValue)
						  .enterResNameInWhatField(objResource_data.strResourceName1)
						  .clickOnSearch()
						  .selectResource(strResourceValue1)
						  .clickOnAddToCustomView()
						  .clickOnOptions()
						  .selectStatusTypes(strStatusTypeValues)
						  .selectStatusTypes(strStatusTypeValues1)
						  .clickOnSave()					  
						  .verResourceAndResTypeInCustomViewTablePage(arrResourceNames,
								  objResourceType_data.strResourceTypeName)
						.clickOnCustomeViewMap()
						.verCustomViewMapScreenIsDisplayed()
						.selectResourceName(objResource_data.strResourceName);
		objMap1.verStatusTypesInPopupWindow(strStatusTypeNames);
//		objCustomUnderView1.verStatusTypesInPopupWindow(strStatusTypeValues1);
		objCustomUnderView1.selectResourceName(objResource_data.strResourceName1);
		String[] strStatusType = { objStatusTypes_data.strTSTStatusTypeName};
		
		objMap1.verStatusTypesInPopupWindow(strStatusType);
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
