package requirementGroup.CreatingAndManagingUsers;

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

public class NewSearchUsers extends TestNG_UI_EXTENSIONS{

	public NewSearchUsers() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that users can be searched by providing a search criteria in the user list screen. 
	'Precondition:
	'Date	 	 : 08-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that users can be searched by providing a search criteria in the user list screen.")
	public void testHappyDay69757() throws Exception {

		gstrTCID = "69757";
		gstrTO = "Verify that users can be searched by providing a search criteria in the user list screen.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRoles_data = new Roles_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);

		String strRoleValue[] = new String[3];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		// Create role
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		objRoles.createRole(objRoles_data.strRoleName1);

		strRoleValue[1] = objRoles.getRoleValue(objRoles_data.strRoleName1);

		objRoles.createRole(objRoles_data.strRoleName2);

		strRoleValue[2] = objRoles.getRoleValue(objRoles_data.strRoleName2);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0]).clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectRoleCheckBox(strRoleValue[1]).clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectRoleCheckBox(strRoleValue[2]).clickSaveButton();

		objUsersList.searchUserName(objUserdata.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUserdata.strContains);

		objUsersList.searchUserName(objUserdata.strNewUserName1,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUserdata.strContains);

		objUsersList.searchUserName(objUserdata.strNewUserName2,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUserdata.strContains);

		objUsersList.selectRoleOptionInUsersList(objRoles_data.strRoleName)
				.clearUsernameInSearchInputField().clickSearchButton()
				.verUserInList(objUserdata.strNewUserName);

		objUsersList.selectRoleOptionInUsersList(objRoles_data.strRoleName1)
				.clearUsernameInSearchInputField().clickSearchButton()
				.verUserInList(objUserdata.strNewUserName1);

		objUsersList.selectRoleOptionInUsersList(objRoles_data.strRoleName2)
				.clearUsernameInSearchInputField().clickSearchButton()
				.verUserInList(objUserdata.strNewUserName2);

		objLogin.clickLogOut();

		gstrResult = "PASS";
	}
}
