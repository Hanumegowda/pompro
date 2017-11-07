package rhel4DiacapServer.requirementGroup.smokeSuit.Users;

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

public class HappyDaySearchUsers extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDaySearchUsers() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that Users can be searched by their Fullname, Username, Email Adress, 
                     ACL Group and Location.     
    'Precondition  :
    'Date          : 11-Dec-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Users can be searched by their Fullname, Username, Email Adress,"
			+ " ACL Group and Location.")
	public void testHappyDay164183() throws Exception {

		gstrTCID = "164183";
		gstrTO = "Verify that Users can be searched by their Fullname, Username, Email Adress, ACL Group "
				+ "and Location.";

		Login_data objLogin_data = new Login_data();
		Locations_data objLocations_data = new Locations_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Locations objLocations = new Locations(this.driver);
		ModifyUser objModifyUser = new ModifyUser(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
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
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.enterEmailAddress(objUser_data.emailAddress)
				.enterUserName(objUser_data.strNewUserName3);
		objModifyUser.selectLocation(objLocations_data.strfacilityname);
		objAddUser.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.strNewUserName)
				.clickOnSearch()
				.verifyUserWithRedBallandUserNeverLoggedInForNonMandatoryFieldsFilled(
						objUser_data.strNewUserName3);
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.emailAddress)
				.clickOnSearch()
				.verifyUserWithRedBallandUserNeverLoggedInForNonMandatoryFieldsFilled(
						objUser_data.strNewUserName3);
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.strNewUserName3)
				.clickOnSearch()
				.verifyUserWithRedBallandUserNeverLoggedInForNonMandatoryFieldsFilled(
						objUser_data.strNewUserName3);
		objUserManagement
				.selectOptionInACLGroupDropDown(objUser_data.radioLogist)
				.clickOnSearch()
				.verifyUserWithRedBallandUserNeverLoggedInForNonMandatoryFieldsFilled(
						objUser_data.strNewUserName3);
		objUserManagement
				.selectOptionInLocationDropDown(
						objLocations_data.strfacilityname)
				.clickOnSearch()
				.verifyUserWithRedBallandUserNeverLoggedInForNonMandatoryFieldsFilled(
						objUser_data.strNewUserName3);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that location added for a User is displayed in the Location column 
                     for a particular User in Users List.     
    'Precondition  :
    'Date          : 21-Sep-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that location added for a User is displayed in the Location column "
			+ "for a particular User in Users List.")
	public void testHappyDay164191() throws Exception {

		gstrTCID = "164191";
		gstrTO = "Verify that location added for a User is displayed in the Location column for a "
				+ "particular User in Users List.";

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
		driver.switchTo().defaultContent();
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
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.strNewUserName)
				.clickOnSearch().clickOnModifyUser(objUser_data.strNewUserName);
		objModifyUser.verModifyUserPage(objUser_data.strNewUserName)
				.selectLocation(objLocations_data.strfacilityname);
		objAddUser.clickOnSaveChanges();
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.strNewUserName)
				.selectOptionInLocationDropDown(
						objLocations_data.strfacilityname)
				.clickOnSearch()
				.verUserWithLocation(objUser_data.strNewUserName,
						objLocations_data.strfacilityname);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

}
