package rh6CommercialServer.requirementGroup.smokeSuit.Users;


import dataObject.Login_data;
import dataObject.SecurityDefaults_data;
import dataObject.User_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.ModifyUser;
import page.PersonalProfile;
import page.SecurityDefaults;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDaySetUserDefaults extends TestNG_UI_EXTENSIONSForOneBrowser {
	public HappyDaySetUserDefaults() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the user account is locked for 5 minutes upon authorization urea when the
                     ‘lock method’ selected in user defaults is ‘lock for 5 min’ .     
    'Precondition  :
    'Date          : 28-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************//*
	@Test(description = "Verify that the user account is locked for 5 minutes upon authorization urea when the"
			+ " ‘lock method’ selected in user defaults is ‘lock for 5 min’ .")
	public void testHappyDay68014() throws Exception {

		gstrTCID = "68014";
		gstrTO = "Verify that the user account is locked for 5 minutes upon authorization urea when the "
				+ "‘lock method’ selected in user defaults is ‘lock for 5 min’ .";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		SecurityDefaults_data objSecurityDefaults_data = new SecurityDefaults_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		SecurityDefaults objSecurityDefaults = new SecurityDefaults(this.driver);
		objHome.launchApplication();
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage()
				.enterAccountlocks(objSecurityDefaults_data.accountlocksNum)
				.selectLockfor5min();
		objAddUser.clickOnSaveChanges();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserName);
		objAdministratorSite.clickOnLogout();
		objHome.launchApplication();
		objHome.clickOnViewPatients();
		for (int i = 1; i <= Integer
				.parseInt(objSecurityDefaults_data.accountlocksNum); i++) {
			objLogin.loginAsUser(objUser_data.strNewUserName,
					objUser_data.strNewPassword.toUpperCase()).clickLogin();
		}
		objLogin.verErrMsgInvalidCredentialsAccountBlockedFor5Min()
				.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin().verErrMsgAccountBlockedFor5Min();
		TimeUnit.MINUTES.sleep(6);
		objLogin.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin();
		objViewPatients.verifyUser(objUser_data.strNewUserName);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
*/
	/*************************************************************************************
    'Description   : Verify that the user account remains locked until Administrator unlocks the
                     account that is locked due to authorization ure when the ‘lock method’ selected
                     in user defaults is ‘Admin should unlock’.     
    'Precondition  :
    'Date          : 29-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that the user account remains locked until Administrator unlocks the "
			+ "account that is locked due to authorization ure when the ‘lock method’ selected in user"
			+ " defaults is ‘Admin should unlock’.")
	public void testHappyDay146381() throws Exception {

		gstrTCID = "146381";
		gstrTO = "Verify that the user account remains locked until Administrator unlocks the account that "
				+ "is locked due to authorization ure when the ‘lock method’ selected in user defaults is "
				+ "‘Admin should unlock’.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		SecurityDefaults_data objSecurityDefaults_data = new SecurityDefaults_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		SecurityDefaults objSecurityDefaults = new SecurityDefaults(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage()
				.enterAccountlocks(objSecurityDefaults_data.accountlocksNum)
				.selectAdminShouldUnlock();
		objAddUser.clickOnSaveChanges();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		for (int i = 1; i < Integer
				.parseInt(objSecurityDefaults_data.accountlocksNum); i++) {
			objLogin.loginAsUser(objUser_data.strNewUserName,
					objUser_data.strNewPassword.toUpperCase()).clickLogin()
					.verifyInvalidCredentialErrMsg();
		}
		objLogin.login(objUser_data.strNewUserName,
				objUser_data.strNewPassword.toUpperCase()).clickLogin();
		objLogin.verErrMsgInvalidCredentialsAccountlLocked()
				.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin().verAccountLockedErrMsg();
		objHome.clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objUserManagement.unlockUser(objUser_data.strNewUserName);
		Thread.sleep(3000);
		objUserManagement.verUserIsUnlocked(objUser_data.strNewUserName);
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage()
				.enterAccountlocks(objSecurityDefaults_data.accountlocksNum1);
		objAddUser.clickOnSaveChanges();
		
		objNavigationToSubMenus.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.verifyUser(objUser_data.strNewUserName);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}

	/*************************************************************************************
    'Description   : Verify that the Password field does not accept less than 3 characters when 
                     ' Password is obvious' checkbox is disabled .     
    'Precondition  :
    'Date          : 30-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that the Password field does not accept less than 3 characters when"
			+ " ' Password is obvious' checkbox is disabled.")
	public void testHappyDay69318() throws Exception {

		gstrTCID = "69318";
		gstrTO = "Verify that the Password field does not accept less than 3 characters when "
				+ "' Password is obvious' checkbox is disabled.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		SecurityDefaults objSecurityDefaults = new SecurityDefaults(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage().deSelectPasswordObvious();
		objAddUser.clickOnSaveChanges();
		objUserManagement.clickOnAddUser();
		System.out.println(objUser_data.strNewUserName);
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strpwd2char)
				.confirmPassWord(objUser_data.strpwd2char);
		objAddUser.clickOnSaveChanges();
		objAddUser.verPwdObviousErrorMsg();
		objAddUser.clickOnCancel();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	 * 'Description  : Verify that the Password of a new user expires on first login when the
	 *                option 'Create all new users with expired Passwords' is enabled. 
	 * 'Precondition : 
	 * 'Date         : 30-Jul-2015 
	 * 'Author       : Hanumegowda
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(enabled=false,description = "Verify that the Password of a new user expires on first login when the "
			+ "option 'Create all new users with expired Passwords' is enabled")
	public void testHappyDay109658() throws Exception {

		gstrTCID = "109658";
		gstrTO = "Verify that the Password of a new user expires on first login when the option"
				+ " 'Create all new users with expired Passwords' is enabled";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		SecurityDefaults objSecurityDefaults = new SecurityDefaults(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage()
				.selectCreateNewUsersWithExpiredPwdsCheckBox();
		objAddUser.clickOnSaveChanges();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin().verChangePwdErrMsg();
		objHome.clickOnAdminSite();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage()
				.deSelectCreateNewUsersWithExpiredPwdsCheckBox();
		objAddUser.clickOnSaveChanges();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
	 * 'Description  : Verify that the Password of a user expires immediately when the 'Expire
	 *                 Password Now' checkbox is enabled in Modify Users page. 
	 * 'Precondition : 
	 * 'Date         : 31-Jul-2015 
	 * 'Author       : Hanumegowda
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(enabled=false,description = "Verify that the Password of a user expires immediately when the 'Expire "
			+ "Password Now' checkbox is enabled in Modify Users page.")
	public void testHappyDay109661() throws Exception {

		gstrTCID = "109661";
		gstrTO = "Verify that the Password of a user expires immediately when the 'Expire Password Now'"
				+ " checkbox is enabled in Modify Users page.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		ModifyUser objModifyUser = new ModifyUser(this.driver);
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
		objUserManagement.clickOnModifyUser(objUser_data.strNewUserName);
		objModifyUser.verModifyUserPage(objUser_data.strNewUserName)
				.selectExpirePasswordNowCheckbox();
		objAddUser.clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin().verChangePwdErrMsg();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the user is automatically logged off from the application after
                     exceeding the idle time specified in User defaults.     
    'Precondition  :
    'Date          : 03-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that the user is automatically logged off from the application "
			+ "after exceeding the idle time specified in User defaults.")
	public void testHappyDay69368() throws Exception {

		gstrTCID = "69368";
		gstrTO = "Verify that the user is automatically logged off from the application"
				+ " after exceeding the idle time specified in User defaults.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		SecurityDefaults_data objSecurityDefaults_data = new SecurityDefaults_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		PersonalProfile objPersonalProfile = new PersonalProfile(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		SecurityDefaults objSecurityDefaults = new SecurityDefaults(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage()
				.enterTextInAutoLogoutIdleField(
						objSecurityDefaults_data.idleTime);
		objAddUser.clickOnSaveChanges();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		Thread.sleep(70000);
		objViewPatients.clickOnPreferences();
		objUserManagement.clickOnOkInAlertPopUpAndGetText(objUser_data.strSessionExpireMsg);
		objPersonalProfile
				.verPersonalProfilePagePfUserNotDisplayed(objUser_data.strNewUserName);
		// it is not the part of test case. Just to reset the values to
		// previous.
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage()
				.enterTextInAutoLogoutIdleField(
						objSecurityDefaults_data.oldnumOfDays);
		objAddUser.clickOnSaveChanges();

		gstrResult = "PASS";
		
	}
	
	/*************************************************************************************
    'Description   : Verify that password must include at least two digits, two lower case letters,
                     two upper case letters, at least one special character (#,@,$, etc.) when "Strong
                     security policy" option is enabled in User Defaults page.     
    'Precondition  :
    'Date          : 23-Sep-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that password must include at least two digits, two lower case letters,"
			+ " two upper case letters, at least one special character (#,@,$, etc.) when Strong "
			+ " security policy option is enabled in User Defaults page.")
	public void testHappyDay176204() throws Exception {

		gstrTCID = "176204";
		gstrTO = "Verify that password must include at least two digits, two lower case letters, two upper"
				+ " case letters, at least one special character (#,@,$, etc.) when Strong security policy "
				+ " option is enabled in User Defaults page.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		SecurityDefaults objSecurityDefaults = new SecurityDefaults(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage()
				.selectStrongSecurityPolicyChkbox();
		objAddUser.clickOnSaveChanges();
		objUserManagement.clickOnAddUser();
		System.out.println(objUser_data.strNewUserName);
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword3)
				.confirmPassWord(objUser_data.strNewPassword3);
		objAddUser.clickOnSaveChanges();
		objAddUser.verStrongPwdSecurityPolicyErrorMsg();
		objAddUser.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.enterPassWord(objUser_data.strNewPassword);
		objAddUser.clickOnSaveChanges();
		// objAddUser.clickOnSaveChanges();
		String bn = objCommonFunctions.getBrowserName();
		System.out.println(bn + "  nnnnnn");
		if (bn.equals("MicrosoftEdge")) {
			System.out.println("yes it is");
			objAddUser.clickOnSaveChanges();
		}
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.strNewUserName)
				.clickOnSearch()
				.verUserWithACLGroup(objUser_data.strNewUserName,
						objUser_data.radioLogist);
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.verifyUser(objUser_data.strNewUserName).clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage()
				.deSelectStrongSecurityPolicyChkbox();
		objAddUser.clickOnSaveChanges();

		gstrResult = "PASS";
	}

}
