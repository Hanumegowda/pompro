package requirementGroup.CreatingAndManagingUsers;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewSwitchUser extends TestNG_UI_EXTENSIONS{

	public NewSwitchUser() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/****************************************************************************************************
	'Description : Switch to another user from System Admin and verify that the app switcher is disabled.
	'Date	 	 : 23-Dec-2015
	'Author		 : Anitha
	'----------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description ="Switch to another user from System Admin and verify that the app switcher is disabled.")
	public void testHappyDay162623() throws Exception {

		gstrTCID = "162623";
		gstrTO = "Switch to another user from System Admin and verify that the app switcher is disabled.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strEicsAdminUser,
				objLogindata.strEicsAdminPwd);
		
		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.verUserInList(objUserdata.strNewUserName)
				.clickOnSwitchLink(objUserdata.strNewUserName);
		
		objRegionDefault.verifyRegionDefaultPage()
				.verifyUserNameInFooter(objUserdata.strFullName)
				.clickOnAppSwitcher().verifyAppSwitcherIsDisabled();

		objLogin.clickLogOut();

		gstrResult = "PASS";
	}
}
