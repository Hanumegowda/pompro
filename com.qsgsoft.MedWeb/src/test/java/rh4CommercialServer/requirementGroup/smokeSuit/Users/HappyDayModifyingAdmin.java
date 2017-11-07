package rh4CommercialServer.requirementGroup.smokeSuit.Users;

import dataObject.Login_data;
import dataObject.User_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSettings;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.UserManagement;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayModifyingAdmin extends TestNG_UI_EXTENSIONSForOneBrowser {
	public HappyDayModifyingAdmin() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the original Administrator can disable his own account upon which the server becomes inaccessible to the Admin.     
    'Precondition  :
    'Date          : 30-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that the original Administrator can disable his own account upon which the server becomes inaccessible to the Admin.")
	public void testHappyDay67962() throws Exception {

		gstrTCID = "67962";
		gstrTO = "Verify that the original Administrator can disable his own account upon which the server becomes inaccessible to the Admin.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		AdministratorSettings objAdministratorSettings = new AdministratorSettings(
				this.driver);
		Login objLogin = new Login(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objAdministratorSite.clickOnAdministratorTab();
		objAdministratorSettings.verAdministratorSettingsPage()
				.clickOnDisableAdminAccount();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin()
				.verAccountLockedErrMsg();
		objLogin.enterUserName(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword).clickLogin();
		objAdministratorSettings.clickOnEnableAdminAccount();
		objHome.clickOnLogOut();
		objHome.clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verUserManagementPage().verAdministratorSitePage();
		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that Admin User cannot access 'Administrator Settings' page.     
    'Precondition  :
    'Date          : 30-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that Admin User cannot access 'Administrator Settings' page.")
	public void testHappyDay159700() throws Exception {

		gstrTCID = "159700";
		gstrTO = "Verify that Admin User cannot access 'Administrator Settings' page.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		AdministratorSettings objAdministratorSettings = new AdministratorSettings(
				this.driver);
		Login objLogin = new Login(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
		objLogin.enterUserName(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword).clickLogin();
		objAdministratorSite.clickOnAdministratorTab();
		objAdministratorSettings.verOnlyOriginalAdminAccessThisPageMsg();
		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that the ‘Click here to disable admin account’ hyperlink is absent in 
                     Administrator settings when there are no other admin accounts.     
    'Precondition  :
    'Date          : 01-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that the ‘Click here to disable admin account’ hyperlink is absent"
			+ " in Administrator settings when there are no other admin accounts.")
	public void testHappyDay68003() throws Exception {

		gstrTCID = "68003";
		gstrTO = "Verify that the ‘Click here to disable admin account’ hyperlink is absent in Administrator"
				+ " settings when there are no other admin accounts.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		User_data objUser_data = new User_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
		AdministratorSettings objAdministratorSettings = new AdministratorSettings(
				this.driver);
		Login objLogin = new Login(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.selectOptionInACLGroupDropDown(objUser_data.administrator);
		Thread.sleep(3000);objUserManagement.clickOnSearch();
				boolean b = objUserManagement.selAllAdminUsers();
				if(b==true){
		objUserManagement.selectOptionInApplyForSelectedDropDown(objUser_data.removeuser)
				.clickOnApply().clickOnOkInAlertPopUp();
				}
		objAdministratorSite.clickOnAdministratorTab();
		objAdministratorSettings.verAdministratorSettingsPage()
				.verDisableAdminAccountLinkIsAbsent();
		
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strAdminUser)
				.enterPassWord(objUser_data.strAdminPwd)
				.confirmPassWord(objUser_data.strAdminPwd)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the ‘Click here to disable admin account’ hyperlink is absent in
                     Administrator settings when all other admin accounts are locked.     
    'Precondition  :
    'Date          : 01-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that the ‘Click here to disable admin account’ hyperlink is absent"
			+ " in Administrator settings when all other admin accounts are locked.")
	public void testHappyDay68006() throws Exception {

		gstrTCID = "68006";
		gstrTO = "Verify that the ‘Click here to disable admin account’ hyperlink is absent"
				+ " in Administrator settings when all other admin accounts are locked.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		AdministratorSettings objAdministratorSettings = new AdministratorSettings(
				this.driver);
		Login objLogin = new Login(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		// objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		boolean val;
		do {
			objUserManagement
					.selectOptionInACLGroupDropDown(objUser_data.administrator);
			Thread.sleep(3000);
			objUserManagement.clickOnSearch();
			val = objUserManagement.lockAllAdminUsers1();
			System.out.println(val + " er");
			Thread.sleep(5000);
		} while (val == true);
		System.out.println(val);
		objAdministratorSite.clickOnAdministratorTab();
		objAdministratorSettings.verAdministratorSettingsPage()
				.verDisableAdminAccountLinkIsAbsent();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.strAdminUser)
				.clickOnSearch().unlockUser(objUser_data.strAdminUser);
		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that Admin password cannot be changed without providing "Current Password".     
    'Precondition  :
    'Date          : 02-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that Admin password cannot be changed without providing 'Current Password'.")
	public void testHappyDay152168() throws Exception {

		gstrTCID = "152168";
		gstrTO = "Verify that Admin password cannot be changed without providing 'Current Password'.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		AdministratorSettings objAdministratorSettings = new AdministratorSettings(
				this.driver);
		Login objLogin = new Login(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objAdministratorSite.clickOnAdministratorTab();
		objAdministratorSettings.verAdministratorSettingsPage()
				.enterNewPwd(objLogin_data.strNewPwd)
				.enterNewPwdAgain(objLogin_data.strNewPwd);
		objAddUser.clickOnSaveChanges();
		objAdministratorSettings.verPwdMessage();
		objAdministratorSettings.enterCurrentPwd(objLogin_data.strAdminUserPwd)
				.enterNewPwd(objLogin_data.strNewPwd)
				.enterNewPwdAgain(objLogin_data.strNewPwd)
				.enterCurrentPwd(objLogin_data.strAdminUserPwd);
		objAddUser.clickOnSaveChanges();
		objAdministratorSettings.verPwdMessageNotDisplayed();
		objAdministratorSettings.enterCurrentPwd(objLogin_data.strNewPwd)
				.enterNewPwd(objLogin_data.strAdminUserPwd)
				.enterNewPwdAgain(objLogin_data.strAdminUserPwd)
				.enterCurrentPwd(objLogin_data.strNewPwd);
		objAddUser.clickOnSaveChanges();

		gstrResult = "PASS";

	}
}
