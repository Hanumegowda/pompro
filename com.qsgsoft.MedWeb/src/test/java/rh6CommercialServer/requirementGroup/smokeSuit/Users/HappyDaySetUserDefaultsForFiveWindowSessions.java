package rh6CommercialServer.requirementGroup.smokeSuit.Users;

import dataObject.Login_data;
import dataObject.SecurityDefaults_data;
import dataObject.User_data;
import page.AddUser;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.SecurityDefaults;
import page.UserManagement;
import page.ViewPatients;
import module.CommonFunctions;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForFiveBrowsersSessions;

public class HappyDaySetUserDefaultsForFiveWindowSessions extends TestNG_UI_EXTENSIONSForFiveBrowsersSessions{
	public HappyDaySetUserDefaultsForFiveWindowSessions() throws Exception {
		super();
	}
	
	/*************************************************************************************
	 * 'Description  : Verify that a user can simultaneously open the allowed number of sessions
	 *                 in Set User Defaults. 
	 * 'Precondition : 
	 * 'Date         : 04-Aug-2015 
	 * 'Author       : Hanumegowda
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(enabled = false, description = "Verify that a user can simultaneously open the allowed number of sessions in Set User Defaults.")
	public void testHappyDay69381() throws Exception {

		gstrTCID = "69381";
		gstrTO = "Verify that a user can simultaneously open the allowed number of sessions in Set User Defaults.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		Home objHome1 = new Home(this.driver1);
		Home objHome2 = new Home(this.driver2);
		Home objHome3 = new Home(this.driver3);
		Home objHome4 = new Home(this.driver4);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		CommonFunctions objCommonFunctions1 = new CommonFunctions(this.driver1);
		CommonFunctions objCommonFunctions2 = new CommonFunctions(this.driver2);
		CommonFunctions objCommonFunctions3 = new CommonFunctions(this.driver3);
		CommonFunctions objCommonFunctions4 = new CommonFunctions(this.driver4);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		ViewPatients objViewPatients1 = new ViewPatients(this.driver1);
		ViewPatients objViewPatients2 = new ViewPatients(this.driver2);
		ViewPatients objViewPatients3 = new ViewPatients(this.driver3);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		Login objLogin1 = new Login(this.driver1);
		Login objLogin2 = new Login(this.driver2);
		Login objLogin3 = new Login(this.driver3);
		Login objLogin4 = new Login(this.driver4);
		SecurityDefaults_data objSecurityDefaults_data = new SecurityDefaults_data();
		SecurityDefaults objSecurityDefaults = new SecurityDefaults(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage()
				.enterTextInLimitNumberOfSessionsField(
						objSecurityDefaults_data.sessionsNum);
		objAddUser.clickOnSaveChanges();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		/*
		 * objUserManagement.clickOnAddUser(); objAddUser.verAddNewUserPage()
		 * .selectOptionInACLgroupDropDown(objUser_data.administrator)
		 * .enterFullNameLast(objUser_data.strNewUserName1)
		 * .enterPassWord(objUser_data.strNewPassword)
		 * .confirmPassWord(objUser_data.strNewPassword) .clickOnSaveChanges();
		 * System.out.println(objUser_data.strNewUserName);
		 */
		objHome.clickOnLogOut();

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.verifyUser(objUser_data.strNewUserName);

		objHome1.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions1.clickOnContinueToThisWebsiteLink();
		objHome1.clickOnViewPatients();
		objLogin1.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients1.verifyUser(objUser_data.strNewUserName);

		objHome2.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions2.clickOnContinueToThisWebsiteLink();
		objHome2.clickOnViewPatients();
		objLogin2.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients2.verifyUser(objUser_data.strNewUserName);

		objHome3.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions3.clickOnContinueToThisWebsiteLink();
		objHome3.clickOnViewPatients();
		objLogin3.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients3.verifyUser(objUser_data.strNewUserName);

		objHome4.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions4.clickOnContinueToThisWebsiteLink();
		objHome4.clickOnViewPatients();
		objLogin4.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objLogin4.verSessionLimitExceededErrMsg();
		// this is not a part of test case, just to reset the values to
		// previous.
		objViewPatients.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage()
				.enterTextInLimitNumberOfSessionsField(
						objSecurityDefaults_data.oldnumOfDays);
		objAddUser.clickOnSaveChanges();

		gstrResult = "PASS";

	}

}
