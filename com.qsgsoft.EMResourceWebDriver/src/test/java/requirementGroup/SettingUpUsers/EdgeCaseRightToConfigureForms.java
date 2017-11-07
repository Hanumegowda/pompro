package requirementGroup.SettingUpUsers;

import lib.dataObject.Login_data;
import lib.dataObject.Roles_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseRightToConfigureForms extends TestNG_UI_EXTENSIONS {

	public EdgeCaseRightToConfigureForms() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that only a system admin user can assign the right 'Form - User may create and modify forms' to users from 'Setup>>Setup Users'.
	'Date	 	 : 25-Feb-2016
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that only a system admin user can assign the right 'Form - User may create and modify forms' to users from 'Setup>>Setup Users'.")
	public void testEdgeCase53063() throws Exception {

		gstrTCID = "53063";
		gstrTO = "Verify that only a system admin user can assign the right 'Form - User may create and modify forms' to users from 'Setup>>Setup Users'.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);;

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
							objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
					objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole().clickAdvancedOptionAndExpand()
		.selectConfigureRegionalUserAccessOption()
		.clickSaveButton();
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		
		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();
		
		objUsersList1.navigateToUsers()
		.enterUsernameInSearchInputField(objUserdata.strNewUserName)
		.clickSearchButton()
		.editUserDetails(objUserdata.strNewUserName)
		.clickAdvancedOptionAndExpand()
		.selectFormUserMayActivateAndModifyFormsOption()
		.clickCancelButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
					objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objUsersList1.navigateToUsers()
		.enterUsernameInSearchInputField(objUserdata.strNewUserName)
		.clickSearchButton()
		.editUserDetails(objUserdata.strNewUserName)
		.clickAdvancedOptionAndExpand()
		.verFormUserMayActivateAndModifyFormsOptionIsNotAvailable();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/****************************************************************************************************
	'Description : As a system admin, select the right 'Form - User may create and modify forms' for a role R1 and save. From another user U2 with 'Setup Roles' right, save the 'Edit Role' screen of R1. Verify that when system admin opens role R1 for editing, 'Form - User may create and modify forms' right remains selected. 
	'Date	 	 : 25-feb-2016
	'Author		 : Sandhya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "As a system admin, select the right 'Form - User may create and modify forms' for a role R1 and save. From another user U2 with 'Setup Roles' right, save the 'Edit Role' screen of R1. Verify that when system admin opens role R1 for editing, 'Form - User may create and modify forms' right remains selected.")
	public void testEdgeCase53052() throws Exception {

		gstrTCID = "53052";
		gstrTO = "As a system admin, select the right 'Form - User may create and modify forms' for a role R1 and save. From another user U2 with 'Setup Roles' right, save the 'Edit Role' screen of R1. Verify that when system admin opens role R1 for editing, 'Form - User may create and modify forms' right remains selected.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRolesdata = new Roles_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		// precondition

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectSetUpRolesRight().clickSaveButton();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.verRoleListPageIsDisplayed().clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesdata.strRoleName)
				.selectformUserMayCreateAndModifyForms().clickOnSaveBtn();

		objLogin.clickLogOut();

		// Steps

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.verRoleListPageIsDisplayed()
				.clickOnEditLinkOfRole(objRolesdata.strRoleName)
				.verifyEditRolePageIsDisplayed().clickOnSaveBtn()
				.verRoleListPageIsDisplayed();
		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.verRoleListPageIsDisplayed()
				.clickOnEditLinkOfRole(objRolesdata.strRoleName)
				.verifyEditRolePageIsDisplayed()
				.verifyformUserMayCreateAndModifyFormsChkBxIsSelected();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/****************************************************************************************************
	'Description : As a system admin, select the right 'Form - User may create and modify forms' for a role R1 and save. From another user U2 with 'Setup Roles' right, save the 'Edit Role' screen of R1. Verify that when system admin opens role R1 for editing, 'Form - User may create and modify forms' right remains selected. 
	'Date	 	 : 25-feb-2016
	'Author		 : Sandhya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "As a system admin, select the right 'Form - User may create and modify forms' for a user U1 and save. From another user U2 with 'User-Setup User Accounts' right, save the 'Edit User' screen of U1. Verify that when system admin opens user U1's account for editing, 'Form - User may create and modify forms' right remains selected.")
	public void testEdgeCase53060() throws Exception {

		gstrTCID = "53060";
		gstrTO = "As a system admin, select the right 'Form - User may create and modify forms' for a user U1 and save. From another user U2 with 'User-Setup User Accounts' right, save the 'Edit User' screen of U1. Verify that when system admin opens user U1's account for editing, 'Form - User may create and modify forms' right remains selected.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		// precondition

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.verifyUserListPageIsDisplayed()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();

		objLogin.clickLogOut();

		// Steps

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1.verifyUserListPageIsDisplayed()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1.verifyUserListPageIsDisplayed()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.verEditUserPageisDisplayed()
				.verFormUserMayActivateAndModifyFormsOptionIsSelected();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
