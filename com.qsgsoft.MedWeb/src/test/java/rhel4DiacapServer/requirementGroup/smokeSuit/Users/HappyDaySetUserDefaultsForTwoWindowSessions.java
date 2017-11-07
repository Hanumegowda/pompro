package rhel4DiacapServer.requirementGroup.smokeSuit.Users;

import dataObject.ControlPanel_data;
import dataObject.Login_data;
import dataObject.SecurityDefaults_data;
import dataObject.User_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.ControlPanel;
import page.Home;
import page.Login;
import page.PersonalProfile;
import page.SecurityDefaults;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForTwoBrowsers;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;

public class HappyDaySetUserDefaultsForTwoWindowSessions extends TestNG_UI_EXTENSIONSForTwoBrowsers{
	public HappyDaySetUserDefaultsForTwoWindowSessions() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that a user's Password expires after the number of days specified in
                     'User's Password Expires in' field.     
    'Precondition  :
    'Date          : 29-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that a user's Password expires after the number of days specified"
			+ " in 'User's Password Expires in' field.")
	public void testHappyDay69340() throws Exception {

		gstrTCID = "69340";
		gstrTO = "Verify that a user's Password expires after the number of days specified in 'User's "
				+ "Password Expires in' field.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		SecurityDefaults_data objSecurityDefaults_data = new SecurityDefaults_data();
		ControlPanel_data objControlPanel_data = new ControlPanel_data();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		SecurityDefaults objSecurityDefaults = new SecurityDefaults(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver);
		Home objHome1 = new Home(this.driver1);
		Login objLogin1 = new Login(this.driver1);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults
				.verSecurityDefaultsPage()
				.selectEnablePasswordExpirationCheckBox()
				.enterTextInUsersPasswordExpiresInField(
						objControlPanel_data.strdays);
		objAddUser.clickOnSaveChanges();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime();
		String strmonth = /*objControlPanel.selectCurrentMonth()*/"";
		String strdate = /*objControlPanel.selectCurrentDate()*/"";
		String monthdate = strmonth + " " + strdate;
		String str = objDate_Time_settings.AddDaytoExistingDate(monthdate,
				Integer.parseInt(objControlPanel_data.strdays1), "MMM dd");
		String[] str1 = str.split(" ");
		String[] str2;
		String str3;
		if (str1[1].startsWith("0")) {
			str2 = str1[1].split("0");
			str3 = str2[1];
		} else {
			str3 = str1[1];
		}
		objControlPanel.selectRequiredMonth(str1[0]);
		objControlPanel.selectRequiredDate(str3);
		objAddUser.clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome1.clickOnViewPatients();
		objLogin1
				.loginAsUser(objUser_data.strNewUserName,
						objUser_data.strNewPassword).clickLogin()
				.verChangePwdErrMsg();

		objControlPanel.enterTextInNTPServerAddressField(
				objControlPanel_data.nTPServerAddress)
				.clickOnSynchronizeNowButton();
		objAddUser.clickOnSaveChanges();
		objUserManagement.clickOnAddUser();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults
				.verSecurityDefaultsPage()
				.deSelectEnablePasswordExpirationCheckBox()
				.enterTextInUsersPasswordExpiresInField(
						objSecurityDefaults_data.oldnumOfDays);
		objAddUser.clickOnSaveChanges();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description  : Verify that a user can re-modify his Password to an old Password only after
	 *                 creating new Passwords for the number of times specified in "How many new Passwords
	 *                 a user must create before they can reuse an old Password" field . 
	 * 'Precondition : 
	 * 'Date         : 03-Aug-2015 
	 * 'Author       : Hanumegowda
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(enabled=false,description = "Verify that a user can re-modify his Password to an old Password only after"
			+ " creating new Passwords for the number of times specified in How many new Passwords"
			+ " a user must create before they can reuse an old Password field ")
	public void testHappyDay151940() throws Exception {

		gstrTCID = "151940";
		gstrTO = "Verify that a user can re-modify his Password to an old Password only after creating new "
				+ "Passwords for the number of times specified in How many new Passwords a user must create"
				+ " before they can reuse an old Password field ";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		ControlPanel_data objControlPanel_data = new ControlPanel_data();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		SecurityDefaults_data objSecurityDefaults_data = new SecurityDefaults_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		SecurityDefaults objSecurityDefaults = new SecurityDefaults(this.driver);
		Home objHome1 = new Home(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		ViewPatients objViewPatients = new ViewPatients(this.driver1);
		PersonalProfile objPersonalProfile = new PersonalProfile(this.driver1);
		AddUser objAddUser1 = new AddUser(this.driver1);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults
				.verSecurityDefaultsPage()
				.enterNumInNewPasswordsField(objSecurityDefaults_data.newPwdNum)
				.enterNumInDaysField(objSecurityDefaults_data.numOfDays);
		objAddUser.clickOnSaveChanges();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime();
		String strmonth = objControlPanel.getCurrentMonth();
		String strdate = objControlPanel.getCurrentDate();
		String monthdate = strmonth + " " + strdate;
		String str = objDate_Time_settings.AddDaytoExistingDate(monthdate,
				Integer.parseInt(objControlPanel_data.strdays2), "MMM dd");
		String[] str1 = str.split(" ");
		String[] str2;
		String str3;
		if (str1[1].startsWith("0")) {
			str2 = str1[1].split("0");
			str3 = str2[1];
		} else {
			str3 = str1[1];
		}
		objControlPanel.selectRequiredMonth(str1[0]);
		objControlPanel.selectRequiredDate(str3);
		objAddUser.clickOnSaveChanges();
		objHome1.launchApplication(objLogin_data.strAppURL);
		objHome1.clickOnViewPatients();
		objLogin1.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.clickOnPreferences();
		objPersonalProfile
				.verPersonalProfilePagePfUser(objUser_data.strNewUserName);
		objAddUser1.enterPassWord(objUser_data.strNewPassword1)
				.confirmPassWord(objUser_data.strNewPassword1);
		objPersonalProfile.clickOnSaveChanges().verPwdSavedMsg();
		objViewPatients.clickOnLogout();
		String strmonth1 = objControlPanel.getCurrentMonth();
		String strdate1 = objControlPanel.getCurrentDate();
		String monthdate1 = strmonth1 + " " + strdate1;
		String strr = objDate_Time_settings.AddDaytoExistingDate(monthdate1,
				Integer.parseInt(objControlPanel_data.strdays2), "MMM dd");
		String[] strr1 = strr.split(" ");
		String[] strr2;
		String strr3;
		if (strr1[1].startsWith("0")) {
			strr2 = strr1[1].split("0");
			strr3 = strr2[1];
		} else {
			strr3 = strr1[1];
		}
		objControlPanel.selectRequiredMonth(strr1[0]);
		objControlPanel.selectRequiredDate(strr3);
		objAddUser.clickOnSaveChanges();

		objHome1.launchApplication(objLogin_data.strAppURL);
		objHome1.clickOnViewPatients();
		objLogin1.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword1).clickLogin();
		objViewPatients.clickOnPreferences();
		objPersonalProfile
				.verPersonalProfilePagePfUser(objUser_data.strNewUserName);
		objAddUser1.enterPassWord(objUser_data.strNewPassword).confirmPassWord(
				objUser_data.strNewPassword);
		objPersonalProfile.clickOnSaveChanges().verUsedRecentPwdErrMsg();
		objPersonalProfile
				.verPersonalProfilePagePfUser(objUser_data.strNewUserName);
		objAddUser1.enterPassWord(objUser_data.strNewPassword2)
				.confirmPassWord(objUser_data.strNewPassword2);
		objPersonalProfile.clickOnSaveChanges().verPwdSavedMsg();
		objViewPatients.clickOnLogout();
		String strmonth2 = objControlPanel.getCurrentMonth();
		String strdate2 = objControlPanel.getCurrentDate();
		String monthdate2 = strmonth2 + " " + strdate2;
		String strrr = objDate_Time_settings.AddDaytoExistingDate(monthdate2,
				Integer.parseInt(objControlPanel_data.strdays2), "MMM dd");
		String[] strrr1 = strrr.split(" ");
		String[] strrr2;
		String strrr3;
		if (strrr1[1].startsWith("0")) {
			strrr2 = strrr1[1].split("0");
			strrr3 = strrr2[1];
		} else {
			strrr3 = strrr1[1];
		}
		objControlPanel.selectRequiredMonth(strrr1[0]);
		objControlPanel.selectRequiredDate(strrr3);
		objAddUser.clickOnSaveChanges();
		objHome1.launchApplication(objLogin_data.strAppURL);
		objHome1.clickOnViewPatients();
		objLogin1.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword2).clickLogin();
		objViewPatients.clickOnPreferences();
		objPersonalProfile
				.verPersonalProfilePagePfUser(objUser_data.strNewUserName);
		objAddUser1.enterPassWord(objUser_data.strNewPassword).confirmPassWord(
				objUser_data.strNewPassword);
		objPersonalProfile.clickOnSaveChanges().verPwdSavedMsg();
		objControlPanel.enterTextInNTPServerAddressField(
				objControlPanel_data.nTPServerAddress)
				.clickOnSynchronizeNowButton();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults
				.verSecurityDefaultsPage()
				.enterNumInNewPasswordsField(
						objSecurityDefaults_data.oldnewPwdNum)
				.enterNumInDaysField(objSecurityDefaults_data.oldnumOfDays);
		objAddUser.clickOnSaveChanges();

		gstrResult = "PASS";

	}

}
