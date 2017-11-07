package rhel4DiacapServer.requirementGroup.smokeSuit.Locations;

import dataObject.Locations_data;
import dataObject.Login_data;
import dataObject.User_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.Home;
import page.Locations;
import page.Login;
import page.ModifyUser;
import page.UserManagement;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayAddLocations extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayAddLocations() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the location added appears in the 'Location' dropdown in Modify User screen.     
    'Precondition  :
    'Date          : 07-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the location added appears in the 'Location' dropdown in Modify User screen.")
	public void testHappyDay68158() throws Exception {

		gstrTCID = "68158";
		gstrTO = "Verify that the location added appears in the 'Location' dropdown in Modify User screen.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Locations_data objLocations_data = new Locations_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Locations objLocations = new Locations(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		ModifyUser objModifyUser = new ModifyUser(this.driver);
		Login objLogin = new Login(this.driver);
		
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnLocations();
		objLocations
				.verLocationListPage()
				.clickOnAddLocation()
				.verAddnewLocationPage()
				.enterTextInFacilityNameField(objLocations_data.strfacilityname)
				.enterTextInLocationIDField(objLocations_data.locationid)
				.enterTextInCityField(objLocations_data.city)
				.enterTextInCountryField(objLocations_data.country);
		objAddUser.clickOnSaveChanges();
		System.out.println(objLocations_data.strfacilityname);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnModifyUser(objUser_data.strNewUserName);
		objModifyUser.verModifyUserPage(objUser_data.strNewUserName)
				.selectLocation(objLocations_data.strfacilityname);
		objAddUser.clickOnSaveChanges();
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

}
