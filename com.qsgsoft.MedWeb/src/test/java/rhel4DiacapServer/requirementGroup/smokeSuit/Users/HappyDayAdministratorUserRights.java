package rhel4DiacapServer.requirementGroup.smokeSuit.Users;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dataObject.Login_data;
import dataObject.PathData;
import dataObject.User_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.ControlPanel;
import page.Home;
import page.Locations;
import page.Login;
import page.ModifyUser;
import page.TemplatesList;
import page.UserManagement;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.FileFormatConverter;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayAdministratorUserRights extends
		TestNG_UI_EXTENSIONSForOneBrowser {
	public HappyDayAdministratorUserRights() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that user belonging to the Administrator group is not allowed to add users to Administrator Group.     
    'Precondition  :
    'Date          : 24-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that user belonging to the Administrator group is not allowed to add users to Administrator Group.")
	public void testHappyDay67927() throws Exception {

		gstrTCID = "67927";
		gstrTO = "Verify that user belonging to the Administrator group is not allowed to add users to Administrator Group.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
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
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		objAddUser.verAdministratorErrorMsg();
		objHome.clickOnLogOut();
		
		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that user belonging to the Administrator group is allowed to add users to ACL groups other than Administrator.     
    'Precondition  :
    'Date          : 24-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that user belonging to the Administrator group is allowed to add users to ACL groups other than Administrator.")
	public void testHappyDay67929() throws Exception {

		gstrTCID = "67929";
		gstrTO = "Verify that user belonging to the Administrator group is allowed to add users to ACL groups other than Administrator.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
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
		objHome.clickOnAdminSite();
		objLogin.enterUserName(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword).clickLogin();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName1);
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserName1);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that user belonging to the Administrator group is not allowed to modify users from Admin group.     
    'Precondition  :
    'Date          : 25-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that user belonging to the Administrator group is not allowed to modify users from Admin group.")
	public void testHappyDay67930() throws Exception {

		gstrTCID = "67930";
		gstrTO = "Verify that user belonging to the Administrator group is not allowed to modify users from Admin group.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
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
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
		objLogin.enterUserName(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword).clickLogin();
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.strNewUserName1)
				.clickOnSearch()
				.clickOnModifyUser(objUser_data.strNewUserName1);
		objModifyUser.verModifyUserPage(objUser_data.strNewUserName1);
		objAddUser.enterPassWord(objUser_data.strNewPassword1)
				.confirmPassWord(objUser_data.strNewPassword1)
				.clickOnSaveChanges();
		objAddUser.verAdministratorErrorMsg();
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that user belonging to the Administrator group is not allowed to change the ACL group of another Admin User.     
    'Precondition  :
    'Date          : 26-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that user belonging to the Administrator group is not allowed to change the ACL group of another Admin User.")
	public void testHappyDay71141() throws Exception {

		gstrTCID = "71141";
		gstrTO = "Verify that user belonging to the Administrator group is not allowed to change the ACL group of another Admin User.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
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
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
		objLogin.enterUserName(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword).clickLogin();
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.strNewUserName1)
				.clickOnSearch()
				.clickOnModifyUser(objUser_data.strNewUserName1);
		objModifyUser.verModifyUserPage(objUser_data.strNewUserName1);
		objAddUser.selectOptionInACLgroupDropDown(objUser_data.radioLogist);
		Thread.sleep(2000);
		objAddUser.clickOnSaveChanges();
		objAddUser.verAdministratorACLGroupErrorMsg();
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that Admin User is allowed to modify users from groups other than Administrator.     
    'Precondition  :
    'Date          : 25-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Admin User is allowed to modify users from groups other than Administrator.")
	public void testHappyDay67941() throws Exception {

		gstrTCID = "67941";
		gstrTO = "Verify that Admin User is allowed to modify users from groups other than Administrator.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
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
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
		objLogin.enterUserName(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword).clickLogin();
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.strNewUserName1)
				.clickOnSearch()
				.clickOnModifyUser(objUser_data.strNewUserName1);
		objModifyUser.verModifyUserPage(objUser_data.strNewUserName1);
		objAddUser.enterFullNameLast(objUser_data.strNewUserName2)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName2);
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserName2);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that Admin User is not allowed to delete users from Administrator group.     
    'Precondition  :
    'Date          : 26-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Admin User is not allowed to delete users from Administrator group.")
	public void testHappyDay67954() throws Exception {

		gstrTCID = "67954";
		gstrTO = "Verify that Admin User is not allowed to delete users from Administrator group.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
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
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName1);
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
		objLogin.enterUserName(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword).clickLogin();
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.strNewUserName1)
				.clickOnSearch()
				.clickOnRemoveUser(objUser_data.strNewUserName1);
		objUserManagement.clickOnOkInAlertPopUp();
		objUserManagement.verAdminUserDeleteErrorMsg();
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that Admin User is allowed to delete users from groups other than Administrator group.     
    'Precondition  :
    'Date          : 29-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Admin User is allowed to delete users from groups other than Administrator group.")
	public void testHappyDay67958() throws Exception {

		gstrTCID = "67958";
		gstrTO = "Verify that Admin User is allowed to delete users from groups other than Administrator group.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
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
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName1);
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
		objLogin.enterUserName(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword).clickLogin();
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strNewUserName1).clickOnSearch();
		} catch (NoSuchElementException e) {
			System.out.println("");
		}
		objUserManagement.clickOnRemoveUser(objUser_data.strNewUserName1)
				.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strNewUserName1).clickOnSearch();
		} catch (NoSuchElementException e) {
			System.out.println("");
		}
		objUserManagement.verUserNotFoundErrMsg();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that Administrator users cannot modify a user's ACL group to Administrator.     
    'Precondition  :
    'Date          : 29-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Administrator users cannot modify a user's ACL group to Administrator.")
	public void testHappyDay67960() throws Exception {

		gstrTCID = "67960";
		gstrTO = "Verify that Administrator users cannot modify a user's ACL group to Administrator.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
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
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.guest)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName1);
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
		objLogin.enterUserName(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword).clickLogin();
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strNewUserName1).clickOnSearch();
		} catch (NoSuchElementException e) {
			System.out.println("");
		}
		objUserManagement.clickOnModifyUser(objUser_data.strNewUserName1);
		objModifyUser.verModifyUserPage(objUser_data.strNewUserName1);
		objAddUser.selectOptionInACLgroupDropDown(objUser_data.administrator);
		Thread.sleep(2000);
		objAddUser.clickOnSaveChanges();
		objAddUser.verAdministratorErrorMsg();
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that user belonging to the Administrator group is not allowed to 
                     import (via CSV) Users to Administrator Group.     
    'Precondition  :
    'Date          : 21-Jun-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that user belonging to the Administrator group is not allowed to "
			+ "import (via CSV) Users to Administrator Group.")
	public void testHappyDay165611() throws Exception {

		gstrTCID = "165611";
		gstrTO = "Verify that user belonging to the Administrator group is not allowed to import (via CSV)"
				+ " Users to Administrator Group.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);

		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		TemplatesList objTemplatesList = new TemplatesList(this.driver);
		Locations objLocations = new Locations(this.driver);
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();
		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + objUser_data.strFile
				+ ".csv";
		String autoit = pathProps.getProperty(objPathData.strAutoITPath);
		File autoitfile = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAccessRights()
				.selOpenRadioBtnOfUserAddAndRemoveSection();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut();
		Thread.sleep(3000);
		objHome.clickOnAdminSite();
		objLogin.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnImportFromCSV().clickOnDownloadCSVTemplate();
		System.out.println(backupfiledownloadpath1 + " this is final path");
		Thread.sleep(5000);
		objAutoIT.DownloadTheReports1(autoitfilepath, backupfiledownloadpath1,
				"IEDownload.exe");
		Thread.sleep(5000);
		System.out.println(backupfiledownloadpath1);
		List<String[]> li = new ArrayList<String[]>();
		li.add(objUser_data.csvuser2);
		li.add(objUser_data.csvuser4);
		System.out.println(li.size() + " this is initial size");
		Thread.sleep(5000);
		objFileFormatConverter.writeToCSVFile(li, backupfiledownloadpath1);
		objUserManagement.clickOnClearLog();
		objTemplatesList.clickOnBrowse(backupfiledownloadpath1);
		objLocations.clickOnImportCSV();
		Thread.sleep(5000);
		objUserManagement.verCannotImportAdministratorErrorMsg(
				objUser_data.csvuser2[0]).verCannotImportAdministratorErrorMsg(
				objUser_data.csvuser4[0]);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.csvuser2[0])
				.clickOnSearch().verUserNotFoundErrMsg();
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.csvuser4[0])
				.clickOnSearch().verUserNotFoundErrMsg();
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}
}
