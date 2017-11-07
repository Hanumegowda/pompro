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

public class NewHappyDaySwitchUser extends TestNG_UI_EXTENSIONS {

	public NewHappyDaySwitchUser() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**********************************************************************************************
	 * 'Description : Verify that RegAdmin can switch to another user.
	 * 'Date        : 08-Jun-2015
	 * 'Author      : Pallavi
	 **********************************************************************************************/

	@Test(description = "Verify that RegAdmin can switch to another user.")
	public void testHappyDay69042() throws Exception {
		
		gstrTCID = "69042";
		gstrTO = "Verify that RegAdmin can switch to another user.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName,
				objUserdata.strFirstName, objUserdata.strMiddleName,
				objUserdata.strLastName, objUserdata.strOrganization,
				objUserdata.strPhone, objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryMailId)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectConfigureRegionalUserAccessOption()
		.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1.searchUserName(objUserdata.strNewUserName,
							objUserdata.strRole, objUserdata.strResourceType,
							objUserdata.strUsername, objUserdata.strsearchOption)
					 .clickOnSwitchLink(objUserdata.strNewUserName);
		
		objNavigationToSubmenus1.clickOnSetUp()
								.verifyOnlyUsersIsDispUnderSetup();
		
		objRegionDefault1.verifyUserNameInFooter(objUserdata.strFullName);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
