package rh6CommercialServer.requirementGroup.smokeSuit.ControlPanelAccessRights;

import dataObject.Login_data;
import dataObject.User_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.ControlPanel;
import page.Home;
import page.Login;
import page.ModifyUser;
import page.UserManagement;
import page.ViewPatients;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayUserAddAndRemoveAndPublicSiteAccess extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayUserAddAndRemoveAndPublicSiteAccess() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the Users in Administrator Group cannot add users to DICOM 
                     Server when the 'Restricted' option is selected under 'User Add and Remove'.     
    'Precondition  :
    'Date          : 17-Aug-2015
    'Author        : Hanumegowda
    '-------------------------------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Users in Administrator Group cannot add users to DICOM"
			+ " Server when the 'Restricted' option is selected under 'User Add and Remove'.")
	public void testHappyDay68246() throws Exception {

		gstrTCID = "68246";
		gstrTO = "Verify that the Users in Administrator Group cannot add users to DICOM Server"
				+ " when the 'Restricted' option is selected under 'User Add and Remove'.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selRestrictedRadioBtnOfUserAddAndRemoveSection();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut92();
		objHome.clickOnAdminSite1();
		objLogin.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin();
		objUserManagement.clickOnAddUser()
				.verOnlyAdminUserAccessThisPageErrMsg();
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the Users in Administrator Group cannot delete users in DICOM 
                     Server when the 'Restricted' option is selected under 'User Add and Remove'.     
    'Precondition  :
    'Date          : 18-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Users in Administrator Group cannot delete users in DICOM"
			+ " Server when the 'Restricted' option is selected under 'User Add and Remove'")
	public void testHappyDay68249() throws Exception {

		gstrTCID = "68249";
		gstrTO = "Verify that the Users in Administrator Group cannot delete users in DICOM"
				+ " Server when the 'Restricted' option is selected under 'User Add and Remove'";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selRestrictedRadioBtnOfUserAddAndRemoveSection();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut92();
		objHome.clickOnAdminSite1();
		objLogin.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin();
		objUserManagement.clickOnRemoveUser(objUser_data.strNewUserName)
				.clickOnOkInAlertPopUp();
		objUserManagement.verOnlyAdminUserAccessThisPageErrMsg1();
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}
	
	   /*************************************************************************************
       'Description   : Verify that the original admin can add/modify and delete user accounts 
                        when the 'Restricted' option is selected under 'User Add and Remove'.     
       'Precondition  :
       'Date          : 18-Aug-2015
       'Author        : Hanumegowda
       '---------------------------------------------------------------
       'Modified Date                                               Modified By
       'Date                                                         Name
	   **************************************************************************************/
	@Test(description = "Verify that the original admin can add/modify and delete user accounts "
			+ "when the 'Restricted' option is selected under 'User Add and Remove'")
	public void testHappyDay68251() throws Exception {

		gstrTCID = "68251";
		gstrTO = "Verify that the original admin can add/modify and delete user accounts when"
				+ " the 'Restricted' option is selected under 'User Add and Remove'";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		ModifyUser objModifyUser = new ModifyUser(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selRestrictedRadioBtnOfUserAddAndRemoveSection();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedIn(
						objUser_data.strNewUserName)
				.enterTextInUserNameSearchField(objUser_data.strNewUserName)
				.clickOnSearch().clickOnModifyUser(objUser_data.strNewUserName);
		objModifyUser.verModifyUserPage(objUser_data.strNewUserName);
		objAddUser.enterFullNameLast(objUser_data.strModNewUserName)
				.enterFullNameLast(objUser_data.strModNewUserName)
				.clickOnSaveChanges();
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strModNewUserName).clickOnSearch();
		} catch (NoSuchElementException e) {
			System.out.println("getting exception");
		}
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strModNewUserName);
		objUserManagement.clickOnRemoveUser(objUser_data.strNewUserName)
				.clickOnOkInAlertPopUp();
		Thread.sleep(3000);
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strModNewUserName).clickOnSearch();
		} catch (NoSuchElementException e) {
			System.out.println("getting exception");
		}
		objUserManagement.verUserNotFoundErrMsg();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selOpenRadioBtnOfUserAddAndRemoveSection();
		objAddUser.clickOnSaveChanges();
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that the users in the Administrator group can add users in DICOM 
                     server when the 'Open' option is selected under 'User Add and Remove'.     
    'Precondition  :
    'Date          : 19-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the users in the Administrator group can add users in DICOM "
			+ "server when the 'Open' option is selected under 'User Add and Remove'.")
	public void testHappyDay68259() throws Exception {

		gstrTCID = "68259";
		gstrTO = "Verify that the users in the Administrator group can add users in DICOM server"
				+ " when the 'Open' option is selected under 'User Add and Remove'.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selOpenRadioBtnOfUserAddAndRemoveSection();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut92();
		objHome.clickOnAdminSite1();
		objLogin.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strNewUserName1).clickOnSearch();
		} catch (NoSuchElementException e) {
			System.out.println("");
		}
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserName1);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the users in the Administrator group can delete users in DICOM
                     server when the 'Open' option is selected under 'User Add and Remove'.     
    'Precondition  :
    'Date          : 20-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the users in the Administrator group can delete users in"
			+ " DICOM server when the 'Open' option is selected under 'User Add and Remove'.")
	public void testHappyDay68266() throws Exception {

		gstrTCID = "68266";
		gstrTO = "Verify that the users in the Administrator group can delete users in DICOM "
				+ "server when the 'Open' option is selected under 'User Add and Remove'.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selOpenRadioBtnOfUserAddAndRemoveSection();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);

		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName1);
		objHome.clickOnLogOut92();
		objHome.clickOnAdminSite1();
		objLogin.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin();
		objUserManagement.clickOnRemoveUser(objUser_data.strNewUserName1)
				.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		try {
			objUserManagement
					.enterTextInUserNameSearchField(
							objUser_data.strNewUserName1).clickOnSearch()
					.verUserNotFoundErrMsg();
		} catch (NoSuchElementException e) {
			objUserManagement
					.verifyUserWithRedBallandUserNeverLoggedInIsNotDisplayed(objUser_data.strNewUserName1);
			System.out.println("catched");
		}
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the users in the Administrator group cannot add users to 
                     Administrator group when the 'Open' option is selected under 'User Add and Remove'.     
    'Precondition  :
    'Date          : 20-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the users in the Administrator group cannot add users to "
			+ "Administrator group when the 'Open' option is selected under 'User Add and Remove'.")
	public void testHappyDay68267() throws Exception {

		gstrTCID = "68267";
		gstrTO = "Verify that the users in the Administrator group cannot add users to Administrator"
				+ " group when the 'Open' option is selected under 'User Add and Remove'.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);

		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selOpenRadioBtnOfUserAddAndRemoveSection();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut92();
		objHome.clickOnAdminSite1();
		objLogin.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		objAddUser.verAdministratorErrorMsg();
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the users in the Administrator group cannot modify/delete users
                     from Administrator group when the 'Open' option is selected under 'User Add and Remove'.     
    'Precondition  :
    'Date          : 21-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the users in the Administrator group cannot modify/delete "
			+ "users from Administrator group when the 'Open' option is selected under 'User Add and Remove'.")
	public void testHappyDay68269() throws Exception {

		gstrTCID = "68269";
		gstrTO = "Verify that the users in the Administrator group cannot modify/delete users "
				+ "from Administrator group when the 'Open' option is selected under 'User Add and Remove'.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ModifyUser objModifyUser = new ModifyUser(this.driver);

		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selOpenRadioBtnOfUserAddAndRemoveSection();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName1);
		objHome.clickOnLogOut92();
		objHome.clickOnAdminSite1();
		objLogin.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin();
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strNewUserName1).clickOnSearch();
		} catch (NoSuchElementException e) {
			System.out.println("");
		}
		objUserManagement.clickOnModifyUser(objUser_data.strNewUserName1);
		objModifyUser.verModifyUserPage(objUser_data.strNewUserName1);
		objAddUser.enterFullNameLast(objUser_data.strModNewUserName)
				.enterFullNameLast(objUser_data.strModNewUserName)
				.clickOnSaveChanges().verAdministratorErrorMsg();
		objNavigationToSubMenus.clickOnUser1();
		objUserManagement.clickOnRemoveUser(objUser_data.strNewUserName1)
				.clickOnOkInAlertPopUp();
		Thread.sleep(3000);
		objUserManagement.verAdminUserDeleteErrorMsg();
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the Users in Administrator Group cannot modify users in DICOM Server
                     when the 'Restricted' option is selected under 'User Add and Remove'.     
    'Precondition  :
    'Date          : 14-Jun-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Users in Administrator Group cannot modify users in DICOM Server"
			+ " when the 'Restricted' option is selected under 'User Add and Remove'.")
	public void testHappyDay68248() throws Exception {

		gstrTCID = "68248";
		gstrTO = "Verify that the Users in Administrator Group cannot modify users in DICOM Server when the"
				+ " 'Restricted' option is selected under 'User Add and Remove'.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selRestrictedRadioBtnOfUserAddAndRemoveSection();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName1);
		objHome.clickOnLogOut92();
		Thread.sleep(3000);
		objHome.clickOnAdminSite1();
		objLogin.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin();
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strNewUserName1).clickOnSearch();
		} catch (NoSuchElementException e) {
			System.out.println("");
		}
		objUserManagement.clickOnModifyUser(objUser_data.strNewUserName1)
				.verOnlyAdminUserAccessThisPageErrMsg();
		objHome.clickOnLogOut92();
		Thread.sleep(3000);
		objHome.clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selOpenRadioBtnOfUserAddAndRemoveSection();
		objAddUser.clickOnSaveChanges();
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the users in the Administrator group can modify users in DICOM 
                     server when the 'Open' option is selected under 'User Add and Remove'.     
    'Precondition  :
    'Date          : 10-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the users in the Administrator group can modify users in DICOM"
			+ " server when the 'Open' option is selected under 'User Add and Remove'.")
	public void testHappyDay68261() throws Exception {

		gstrTCID = "68261";
		gstrTO = "Verify that the users in the Administrator group can modify users in DICOM server"
				+ " when the 'Open' option is selected under 'User Add and Remove'.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ModifyUser objModifyUser = new ModifyUser(this.driver);

		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selOpenRadioBtnOfUserAddAndRemoveSection();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName1);
		objHome.clickOnLogOut92();
		objHome.clickOnAdminSite1();
		objLogin.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin();
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strNewUserName1).clickOnSearch();
		} catch (NoSuchElementException e) {

		}
		objUserManagement.clickOnModifyUser(objUser_data.strNewUserName1);
		objModifyUser.verModifyUserPage(objUser_data.strNewUserName1);
		objAddUser.enterFullNameLast(objUser_data.strModNewUserName)
				.enterFullNameLast(objUser_data.strModNewUserName)
				.clickOnSaveChanges();
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strModNewUserName).clickOnSearch();
		} catch (NoSuchElementException e) {
			System.out.println("");
		}
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strModNewUserName);
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that Login screen is displayed when attempting to access the Medweb
                     Server Home Page when the option 'Restricted' is selected under Public Site
                     Access (i.e. /cobalt/).     
    'Precondition  :
    'Date          : 12-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Login screen is displayed when attempting to access the Medweb "
			+ "Server Home Page when the option 'Restricted' is selected under Public Site Access (i.e. /cobalt/).")
	public void testHappyDay68271() throws Exception {

		gstrTCID = "68271";
		gstrTO = "Verify that Login screen is displayed when attempting to access the Medweb Server Home "
				+ "Page when the option 'Restricted' is selected under Public Site Access (i.e. /cobalt/).";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		this.driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selRestrictedRadioBtnOfPublicSiteAccessSection();
		objAddUser.clickOnSaveChanges();
		objHome.clickOnLogOut92();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objLogin.verifyLoginPageIsDisplaying()
				.login(objLogin_data.strAdminUser,
						objLogin_data.strAdminUserPwd).clickLogin();
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selOpenRadioBtnOfPublicSiteAccessSection();
		objAddUser.clickOnSaveChanges();
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the Home page of the Medweb Server is avaialble to anyone in 
                     the world, when the option 'Open' is selected under Public Site Access (i.e. /cobalt/).     
    'Precondition  :
    'Date          : 18-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Home page of the Medweb Server is avaialble to anyone in the"
			+ " world, when the option 'Open' is selected under Public Site Access (i.e. /cobalt/).")
	public void testHappyDay68270() throws Exception {

		gstrTCID = "68270";
		gstrTO = "Verify that the Home page of the Medweb Server is avaialble to anyone in the world,"
				+ " when the option 'Open' is selected under Public Site Access (i.e. /cobalt/).";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		this.driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights1()
				.selOpenRadioBtnOfPublicSiteAccessSection();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut92();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.verHomePage().verHomeButton().clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.verifyUser(objUser_data.strNewUserName).clickOnLogout();

		gstrResult = "PASS";

	}

}
