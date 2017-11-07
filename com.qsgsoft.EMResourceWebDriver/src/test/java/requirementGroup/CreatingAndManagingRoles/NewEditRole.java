package requirementGroup.CreatingAndManagingRoles;

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

public class NewEditRole extends TestNG_UI_EXTENSIONS{

	public NewEditRole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*********************************************************************************
	'Description : Verify that a role can be edited by RegAdmin. 
	'Precondition:
	'Date	 	 : 10-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a role can be edited by RegAdmin. ")
	public void testHappyDay69278() throws Exception {

		gstrTCID = "69278";
		gstrTO = "Verify that a role can be edited by RegAdmin. ";

		Login_data objLogin_data = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRolesData = new Roles_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);

		String strRoleValue[] = new String[1];

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();

		// Create role
		objNavigationToSubMenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.selectConfigureRegionalUserAccess().clickOnSaveBtn();

		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);

		objNavigationToSubMenus1.navigateToUsers();

		// User creation
		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0]).clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.verSetUpTabIsDisplayed();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();

		// Create role
		objNavigationToSubMenus1.navigateToRoles();

		objRoles1.clickOnEditLinkOfRole(objRolesData.strRoleName)
				.deselectConfigureRegionalUserAccess().clickOnSaveBtn();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.verSetUpTabIsNotDisplayed();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
