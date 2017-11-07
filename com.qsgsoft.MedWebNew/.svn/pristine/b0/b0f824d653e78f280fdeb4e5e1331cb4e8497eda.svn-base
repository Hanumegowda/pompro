package rh4CommercialServer.requirementGroup.smokeSuit.UserGroups;

import dataObject.Groups_data;
import dataObject.Login_data;
import dataObject.User_data;
import page.AddUser;
import page.AdministratorSite;
import page.Groups;
import page.Home;
import page.Login;
import page.ModifyUser;
import page.UserManagement;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayCreateGroup extends TestNG_UI_EXTENSIONSForOneBrowser {
	public HappyDayCreateGroup() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that a group can be created when only mandatory fields are filled.     
    'Precondition  :
    'Date          : 02-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a group can be created when only mandatory fields are filled.")
	public void testHappyDay68015() throws Exception {

		gstrTCID = "68015";
		gstrTO = "Verify that a group can be created when only mandatory fields are filled.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname);
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objGroups.verGroupNameInGroupList(objGroups_data.groupname);
		objGroups.deleteGroup(objGroups_data.groupname);
		objUserManagement.clickOnOkInAlertPopUp();
		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that a new group cannot be created with a group name that is same as that of an existing group.     
    'Precondition  :
    'Date          : 03-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a new group cannot be created with a group name that is same as that of an existing group.")
	public void testHappyDay84079() throws Exception {

		gstrTCID = "84079";
		gstrTO = "Verify that a new group cannot be created with a group name that is same as that of an existing group.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname);
		System.out.println(objGroups_data.groupname);
		objAddUser.clickOnSaveChanges();
		objGroups.verGroupNameInGroupList(objGroups_data.groupname);
		objGroups.clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname);
		System.out.println(objGroups_data.groupname);
		objAddUser.clickOnSaveChanges();
		objGroups.verErrMsgForDuplicateGroupName(objGroups_data.groupname);
		objGroups.clickOnGroups();
		objGroups.deleteGroup(objGroups_data.groupname);
		objUserManagement.clickOnOkInAlertPopUp();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that all users belonging to the Administrator group are allowed to add groups.     
    'Precondition  :
    'Date          : 03-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that all users belonging to the Administrator group are allowed to add groups.")
	public void testHappyDay68028() throws Exception {

		gstrTCID = "68028";
		gstrTO = "Verify that all users belonging to the Administrator group are allowed to add groups.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();

		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
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
		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname);
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objGroups.verGroupNameInGroupList(objGroups_data.groupname);
		objGroups.deleteGroup(objGroups_data.groupname);
		objUserManagement.clickOnOkInAlertPopUp();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that a Administrator user modified to a non-Administrator group cannot add groups.     
    'Precondition  :
    'Date          : 06-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a Administrator user modified to a non-Administrator group cannot add groups.")
	public void testHappyDay66695() throws Exception {

		gstrTCID = "66695";
		gstrTO = "Verify that a Administrator user modified to a non-Administrator group cannot add groups.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		ModifyUser objModifyUser = new ModifyUser(this.driver);
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
		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname);
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objGroups.verGroupNameInGroupList(objGroups_data.groupname);
		objGroups.deleteGroup(objGroups_data.groupname);
		objUserManagement.clickOnOkInAlertPopUp();
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objUserManagement.clickOnModifyUser(objUser_data.strNewUserName);
		objModifyUser.verModifyUserPage(objUser_data.strNewUserName);
		objAddUser.selectOptionInACLgroupDropDown(objUser_data.radioLogist);
		Thread.sleep(3000);
		objAddUser.clickOnSaveChanges();
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
		objLogin.enterUserName(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword).clickLogin()
				.verInvalidGroupErrMsg();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that a group can be created when mandatory and non-mandatory fields are filled.     
    'Precondition  :
    'Date          : 06-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a group can be created when mandatory and non-mandatory fields are filled.")
	public void testHappyDay84068() throws Exception {

		gstrTCID = "84068";
		gstrTO = "Verify that a group can be created when mandatory and non-mandatory fields are filled.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
		User_data objUser_data = new User_data();
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
		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedMTFListCheckBox()
				.selectAllowedInstitutionNameListCheckBox()
				.selectAllowedModalityListCheckBox()
				.selectAllowedProjectsListCheckBox()
				.selectGroupUsers(objUser_data.strNewUserName);
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objGroups.verGroupNameAndGroupMemberInGroupList(
				objGroups_data.groupname, objUser_data.strNewUserName);

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that new group can be created by copying permissions selected in 'Copy Permissions from' dropdown when 'Copy' button is clicked.     
    'Precondition  :
    'Date          : 07-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that new group can be created by copying permissions selected in 'Copy Permissions from' dropdown when 'Copy' button is clicked.")
	public void testHappyDay125792() throws Exception {

		gstrTCID = "125792";
		gstrTO = "Verify that new group can be created by copying permissions selected in 'Copy Permissions from' dropdown when 'Copy' button is clicked.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy();
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objGroups.verGroupNameInGroupList(objGroups_data.groupname);
		objGroups.deleteGroup(objGroups_data.groupname);
		objUserManagement.clickOnOkInAlertPopUp();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that a group cannot be created by copying permissions from the Administrator group.     
    'Precondition  :
    'Date          : 07-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a group cannot be created by copying permissions from the Administrator group.")
	public void testHappyDay84091() throws Exception {

		gstrTCID = "84091";
		gstrTO = "Verify that a group cannot be created by copying permissions from the Administrator group.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup()
				.verAdministratorNotPresentINCopyPermissionsFromOption(
						objGroups_data.grouptypeAdmin);

		gstrResult = "PASS";

	}

}
