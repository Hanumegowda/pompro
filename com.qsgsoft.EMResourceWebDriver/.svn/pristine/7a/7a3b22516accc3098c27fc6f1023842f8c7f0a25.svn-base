package requirementGroup.CreatingAndManagingUsers;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.SelectRegion;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEdgeCaseProvideAccessToRegionsForAUser extends TestNG_UI_EXTENSIONS{

	public NewEdgeCaseProvideAccessToRegionsForAUser() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/**************************************************************************************
	'Description : Verify that the process of assigning regions to a user can be cancelled.
	'Date	 	 : 16-Feb-2016
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***************************************************************************************/
	@Test(description = " Verify that the process of assigning regions to a user can be cancelled.")
	public void testEdgeCase88876() throws Exception {

		gstrTCID = "88876";
		gstrTO = " Verify that the process of assigning regions to a user can be cancelled.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Regions objRegions_page1 = new Regions(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strRegionValue[] = new String[2];

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRegions();

		strRegionValue[0] = objRegions_page1
				.getRegionValue(objLogindata.strRegionName);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page1
				.getRegionValue(objLogindata.strRegionName1);

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickCancelButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().clickRegionLink();
		
		objSelectRegionpage1.verSelectRegionPageIsNotPresent();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
