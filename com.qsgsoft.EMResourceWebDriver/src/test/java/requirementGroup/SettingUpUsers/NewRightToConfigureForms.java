package requirementGroup.SettingUpUsers;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewRightToConfigureForms extends TestNG_UI_EXTENSIONS{

	public NewRightToConfigureForms() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/****************************************************************************************************
	'Description : Verify that only a system admin users can assign the right 'Form - User may create and modify forms' to users from 'Setup>>Setup Users'.
	'Date	 	 : 01-Jul-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "Verify that only a system admin users can assign the right 'Form - User may create and modify forms' to users from 'Setup>>Setup Users'.")
	public void testHappyDay46608() throws Exception {

		gstrTCID = "46608";
		gstrTO = "Verify that only a system admin users can assign the right 'Form - User may create and modify forms' to users from 'Setup>>Setup Users'.";

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
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

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
				.selectFormUserMayActivateAndModifyFormsOption()
				.selectReportformDetail().clickSaveButton();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.verSelectFormUserMayActivateandModifyFormsOptionIsSelected()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateAndModifyFormsOption().clickSaveButton();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.verSelectFormUserMayActivateandModifyFormsOptionIsSelected()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName2);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1.clickCreateNewUserButton().clickAdvancedOptionAndExpand()
				.verSelectFormUserMayActivateAndModifyFormsOptionNotAvl()
				.clickCancelButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.clickAdvancedOptionAndExpand()
				.verSelectFormUserMayActivateAndModifyFormsOptionNotDisplayed();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
