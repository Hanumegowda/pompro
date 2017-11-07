package requirementGroup.CreatingAndManagingRoles;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewDefaultRole extends TestNG_UI_EXTENSIONS{

	public NewDefaultRole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/****************************************************************************************************
	'Description : Verify that a role set as default is selected while creating a new user 
	'Date	 	 : 13-Oct-2015
	'Author		 : Renushree
	'----------------------------------------------------------------------------------------------------
	'Modified Date			                        	                    Modified By
	'Date					                                                Name
	*****************************************************************************************************/
	@Test(description = "Verify that a role set as default is selected while creating a new user ")
	public void testHappyDay127929() throws Exception {
		
		gstrTCID = "127929";
		gstrTO = "Verify that a role set as default is selected while creating a new user ";
				
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Report objReport1 = new Report(this.driver1);
		
		String strRoleValue[] = new String[1];
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		
		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Role based status types
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage()
					   .createResourceType(
							objResourceType_data.strResourceTypeName,
							strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		// Create Resource
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName);
		
		objRoles.clickOnSaveBtn().verifyCreatedRoleInRolesList(
				objRolesData.strRoleName);
		
		objRoles.clickOnDefaultLinkOfRole(objRolesData.strRoleName);
		
		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.verRoleCheckBoxIsSelected(strRoleValue[0])
		.selectRunReportRight(objResource_data.strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectViewcustomViewOption()
		.selectMaintainEventsOption()
		.selectReportStatusSummaryOption()
		.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToCustomInView();
		
		objEventManagement1.navigateToEventManagement();
		
		objNavigationToSubmenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/****************************************************************************************************
	 * 'Description : Verify that when a user is provided access to multiple
	 *                 regions, user will be provided with the default role set in that region
	 *                 and has the default viewing rights for the resources added in region's
	 *                  default view when the user is opened for editing 
	 * 'Date :      14-Jan-2016
	 * 'Author :    Sangappa k
	 * '---------------------------------------------------------------------------------------------------
	 * - 'Modified Date Modified By 'Date Name
	 *****************************************************************************************************/
	@Test(description ="Verify that when a user is provided access to multiple regions, user will be provided "
			+ "with the default role set in that region and has the default viewing rights for the resources added"
			+ " in region's default view when the user is opened for editing")
	public void testHappyDay127945() throws Exception {
		
		gstrTCID ="127945";
		gstrTO = "Verify that when a user is provided access to multiple regions, user will be provided with "
				+ "the default role set in that region and has the default viewing rights for the resources "
				+ "added in region's default view when the user is opened for editing";
				
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		
		String strRoleValue[] = new String[2];
		String strStatusTypeValues1[] = new String[1];
		String strStatusTypeValues2[] = new String[1];
		String strResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[2];
		String strRegionValue[] = new String[2];
		
		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Role based status types
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Resource
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);

		objRoles.clickOnSaveBtn().verifyCreatedRoleInRolesList(
				objRolesData.strRoleName);

		objRoles.clickOnDefaultLinkOfRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOnEditOfRegDefault();

//		.selectStatusType(objStatusTypes_data.strNSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.clickOnResourcesTab()
				.selectResource(objResource_data.strResourceName)
				.clickNextButton()
				.selectStatusType(objStatusTypes_data.strNSTStatusTypeName)
				.clickOnSaveOfCreateNewView();
		
		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Role based status types
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strStatusTypeValues2);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Create Resource
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation1,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName1);

		objRoles.clickOnSaveBtn().verifyCreatedRoleInRolesList(
				objRolesData.strRoleName1);

		objRoles.clickOnDefaultLinkOfRole(objRolesData.strRoleName1);

		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);
		System.out.println(objRolesData.strRoleName1);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOnEditOfRegDefault()
					.clickOnResourcesTab()
					.selectResource(
							objResource_data.strResourceName1)
					.clickNextButton()
					.selectStatusType(
							objStatusTypes_data.strNSTStatusTypeName1)
				    .clickOnSaveOfCreateNewView();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.clickSaveButton()

				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		// Login In IE

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.verRoleCheckBoxIsSelected(strRoleValue[0]).clickSaveButton();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1.clickOnUsersLink(objResource_data.strResourceName)
				.verViewResourceChkboxIsSelected(objUserdata.strNewUserName)
				.clickOnSaveButton();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.verRoleCheckBoxIsSelected(strRoleValue[1]).clickSaveButton();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1.clickOnUsersLink(objResource_data.strResourceName1)
				.verViewResourceChkboxIsSelected(objUserdata.strNewUserName)
				.clickOnSaveButton();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

}
