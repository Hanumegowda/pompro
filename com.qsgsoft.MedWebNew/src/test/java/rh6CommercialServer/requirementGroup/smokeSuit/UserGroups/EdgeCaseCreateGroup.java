package rh6CommercialServer.requirementGroup.smokeSuit.UserGroups;

import dataObject.Groups_data;
import dataObject.Login_data;
import dataObject.User_data;
import page.AddUser;
import page.AdministratorSite;
import page.Groups;
import page.Home;
import page.Login;
import page.UserManagement;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class EdgeCaseCreateGroup extends TestNG_UI_EXTENSIONSForOneBrowser{
	public EdgeCaseCreateGroup() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that users are assigned to the group when selected under "Group Users" section.     
    'Precondition  :
    'Date          : 07-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that users are assigned to the group when selected under Group Users section.")
	public void testEdgeCase84129() throws Exception {

		gstrTCID = "84129";
		gstrTO = "Verify that users are assigned to the group when selected under Group Users section.";

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
				.selectGroupUsers(objUser_data.strNewUserName);
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objGroups.verGroupNameInGroupList(objGroups_data.groupname)
				.verGroupNameAndGroupMemberInGroupList(
						objGroups_data.groupname, objUser_data.strNewUserName);

		gstrResult = "PASS";

	}

}
