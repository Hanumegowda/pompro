package requirementGroup.HAvBED;

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

public class HappyDaySendingAggregateDataToHHS extends TestNG_UI_EXTENSIONS{

	public HappyDaySendingAggregateDataToHHS() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/***********************************************************************************************
	'Description : Verify that only System admin can assign "May schedule and activate the HAvBED Interface "right to a user. 
	'Date	 	 : 22-Mar-2016
	'Author		 : Sandhya
	************************************************************************************************/
	
	@Test(description = "Verify that only System admin can assign May schedule and activate the HAvBED Interface right to a user. ")
	public void testHappyDay162677() throws Exception {

		gstrTCID = "162677";
		gstrTO = "Verify that only System admin can assign May schedule and activate the HAvBED Interface right to a user.";

		Login_data login_data = new Login_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		objLogin.loginToApplication(login_data.strAdminUser,
				login_data.strAdminUserPwd);

		objSelectRegion.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(login_data.strAdminUser,
				login_data.strAdminUserPwd);
		
		objSelectRegion1.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton().clickEditForFirstUser()
				.clickAdvancedOptionAndExpand()
				.verHavBedScheduleAndActivateHaavBedInterfaceIsAvailable()
				.selectHavBedScheduleAndActivateHaavBedInterface()
				.clickSaveButton();
		
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton().clickEditForFirstUser()
				.clickAdvancedOptionAndExpand()
				.verifyRightsNameIsNotDisplayed(objUser_data.strHavBedRight);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
