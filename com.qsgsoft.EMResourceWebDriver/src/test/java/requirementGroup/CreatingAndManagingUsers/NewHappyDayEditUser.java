package requirementGroup.CreatingAndManagingUsers;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import lib.dataObject.BlankFormData;
import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.UpdateStatus_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.module.UserFunctions;
import lib.page.ActivateForms;
import lib.page.BlankForm;
import lib.page.DispatchForm;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.FormConfiguration;
import lib.page.FormList;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.Map;
import lib.page.MyEventNotificationPreferences;
import lib.page.RegionDefault;
import lib.page.RegionalInfo;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UpdateUserInfo;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewHappyDayEditUser extends TestNG_UI_EXTENSIONS {

	public NewHappyDayEditUser() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**********************************************************************************************
	 * 'Description : Verify that a user can be edited by RegAdmin.
	 * 'Date        : 04-Jun-2015
	 * 'Author      : Pallavi
	 **********************************************************************************************/

	@Test(description = "Verify that a user can be edited by RegAdmin.")
	public void testHappyDay68427() throws Exception {
		
		gstrTCID = "68427";
		gstrTO = "Verify that a user can be edited by RegAdmin.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName, 
						objUser_data.strNewPassword, 
						objUser_data.strFullName)
				.clickSaveButton().verifyUserListPageIsDisplayed();
		
		login_page.clickLogOut();
		
		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame();

		// User creation
		UsersList_page1.navigateToUsers()
					   .enterUsernameInSearchInputField(
							   objUser_data.strNewUserName)
					   .clickSearchButton()
					   .editUserDetails(objUser_data.strNewUserName)
					   .enterFullName("Edt" + objUser_data.strFullName)
					   .clickSaveButton().verifyUserListPageIsDisplayed()
					   .verUserInList(objUser_data.strNewUserName)
					   .verUserDetails(objUser_data.strNewUserName,
							   "Edt" + objUser_data.strFullName, " ");
		
		login_page1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/**********************************************************************************************
	 * 'Description : Edit a user and deselect role and verify that the role is no longer assigned to the user.
	 * 'Date        : 05-Jun-2015
	 * 'Author      : Anil
	 **********************************************************************************************/

	@Test(description = "Edit a user and deselect role and verify that the role is no longer assigned to the user.")
	public void testHappyDay68478() throws Exception {
		
		gstrTCID = "68478";
		gstrTO = "Edit a user and deselect role and verify that the role is no longer assigned to the user.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		
		String strRoleValue[] = new String[1];
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		
		// role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
		         .enterRoleName(objRolesData.strRoleName);
		
		objUsersList.selectConfigureRegionalUserAccessOption();
		
		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName)		             
		        .selectRoleCheckBox(strRoleValue)
		        .clickSaveButton().verifyUserListPageIsDisplayed();
		
		objLogin.clickLogOut();
		
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objUsersList1.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
						.editUserDetails(objUser_data.strNewUserName)
						.deSelectRoleCheckBox(strRoleValue)
						.clickSaveButton().verifyUserListPageIsDisplayed();
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();

		objUsersList1.verSetUpIsNotPresent();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

	
	/**********************************************************************************************
	 * 'Description : Edit a user and select new role and verify that the user has the right selected for the role.
	 * 'Date        : 05-Jun-2015
	 * 'Author      : Anil
	 **********************************************************************************************/

	@Test(description = "Edit a user and select new role and verify that the user has the right selected for the role.")
	public void testHappyDay68485() throws Exception {
		
		gstrTCID = "68485";
		gstrTO = "Edit a user and select new role and verify that the user has the right selected for the role.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		
		String strRoleValue[] = new String[1];
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		
		// role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
		         .enterRoleName(objRolesData.strRoleName);
		
		objUsersList.selectConfigureRegionalUserAccessOption();
		
		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName)		             
		        .clickSaveButton().verifyUserListPageIsDisplayed();
		
		objLogin.clickLogOut();
			
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objUsersList1.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
						.editUserDetails(objUser_data.strNewUserName)
						.selectRoleCheckBox(strRoleValue)
						.clickSaveButton().verifyUserListPageIsDisplayed()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();

		objUsersList1.verSetUpIsPresent();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	/**********************************************************************************************
	'Description : Edit a user and select new right and verify that the user has the right.
	'Date	 	 : 05-June-2015
	'Author		 : Anitha
	'----------------------------------------------------------------------------------------------
	'Modified Date			                        	                       Modified By
	'Date					                                                   Name
	***********************************************************************************************/
	@Test(description = "Edit a user and select new right and verify that the user has the right.")
	public void testHappyDay68558() throws Exception {

		gstrTCID = "68558";
		gstrTO = "Edit a user and select new right and verify that the user has the right.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.clickSaveButton().verifyUserListPageIsDisplayed();

		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
	
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName).selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objUsersList1.verSetUpIsPresent();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.createNewUserButtonIsPresent()

				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.verPasswordLink(objUserdata.strNewUserName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a user account can be deactivated by RegAdmin. 
	'Precondition:
	'Date	 	 : 05-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a user account can be deactivated by RegAdmin.")
	public void testHappyDay111895() throws Exception {

		gstrTCID = "111895";
		gstrTO = "Verify that a user account can be deactivated by RegAdmin.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickSaveButton().verifyUserListPageIsDisplayed()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.verUserDetails(objUserdata.strNewUserName,
						objUserdata.strFullName, objUserdata.strOrganization);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnUserDeactivateChkBox()
				.clickSaveButton().verifyUserListPageIsDisplayed()
				.verifyWarningPage(objUserdata.strNewUserName,
						objUserdata.strFullName)
				.clickOnYesDeactivateThisUserBtn()
				.verifyDeactivationConfirmPage(objUserdata.strNewUserName,
						objUserdata.strFullName)
				.clickOnReturnToListBtn()
				.clickOnIncludeInactiveChkBox()
				.verifyInactiveUserIsPresent(objUserdata.strNewUserName,
						objUserdata.strFullName);

		objLogin1.clickLogOut().enterUserName(objUserdata.strNewUserName)
				.enterPassword(objUserdata.strNewPassword).clickLogin()
				.verifyInvalidUsernameAndPwdError();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Reactivate an inactive user and verify that the user can successfully login to EMResource. 
	'Precondition:
	'Date	 	 : 05-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Reactivate an inactive user and verify that the user can successfully login to EMResource.")
	public void testHappyDay68453() throws Exception {
		
		gstrTCID = "68453";
		gstrTO = "Reactivate an inactive user and verify that the user can successfully login to EMResource.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickSaveButton().verifyUserListPageIsDisplayed()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.verUserDetails(objUserdata.strNewUserName,
						objUserdata.strFullName, objUserdata.strOrganization);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnUserDeactivateChkBox()
				.clickSaveButton()
				.verifyWarningPage(objUserdata.strNewUserName,
						objUserdata.strFullName)
				.clickOnYesDeactivateThisUserBtn()
				.verifyDeactivationConfirmPage(objUserdata.strNewUserName,
						objUserdata.strFullName)
				.clickOnReturnToListBtn()
				.clickOnIncludeInactiveChkBox()
				.verifyInactiveUserIsPresent(objUserdata.strNewUserName,
						objUserdata.strFullName);

		objLogin1.clickLogOut();

		objLogin1.enterUserName(objUserdata.strNewUserName);
		objLogin1.enterPassword(objUserdata.strNewPassword);
		objLogin1.clickLogin();

		objLogin1.verifyInvalidUsernameAndPwdError().loginToApplication(
				objLogindata.strUserName, objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickOnIncludeInactiveChkBox()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnUserActivateChkBox()
				.clickSaveButton()
				.verifyReactivatedConfmMsg(objUserdata.strNewUserName,
						objUserdata.strFullName)
				.clickOnReturnToListBtn()
				.verFullName(objUserdata.strNewUserName,
						objUserdata.strFullName);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that data provided in the mandatory fields for a user can be edited.
	'Precondition:
	'Date	 	 : 05-Jun-2015
	'Author		 : Deepa
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that data provided in the mandatory fields for a user can be edited.")
	public void testHappyDay88831() throws Exception {
		gstrTCID = "88831";
		gstrTO = "Verify that data provided in the mandatory fields for a user can be edited.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		RegionalInfo objRegionalInfo1 = new RegionalInfo(this.driver1);
		UserFunctions objUserFunctions1 = new UserFunctions(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strQuickLinkRegion);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.verifyUserListPageIsDisplayed()
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.verUserDetails(objUserdata.strNewUserName,
						objUserdata.strFullName, objUserdata.strOrganization);

		objNavigationToSubmenus1.navigateToUsersInRegionalInfo();

		objUserFunctions1.enterUsernameInSearchInputField(
				objUserdata.strNewUserName).clickSearchButton();

		objRegionalInfo1.verUserDetailsInUserListPgeOfRegionalInfo(
				objUserdata.strNewUserName, objUserdata.strFullName,
				objUserdata.strOrganization, objUserdata.strPhone,
				objUserdata.strPrimaryMailId, objUserdata.strPrimaryMailId);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyUserNameInFooter(
				objUserdata.strEditedFullName);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strQuickLinkRegion);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objUsersList1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.enterFullName(objUserdata.strEditedFullName)
				.enterFirstName(objUserdata.strEditedFirstName)
				.enterMiddleName(objUserdata.strEditedMiddleName)
				.enterLastName(objUserdata.strEditedLastName)
				.enterOrganization(objUserdata.strEditedOrganization)
				.enterPhone(objUserdata.strEditedPhone)
				.enterPrimaryEmailId(objUserdata.strEmail)
				.enterEmail(objUserdata.strEmail)
				.entertextPagerId(objUserdata.strEmail)
				.clickSaveButton()
				.verUserDetails(objUserdata.strNewUserName,
						objUserdata.strEditedFullName,
						objUserdata.strEditedOrganization);

		objNavigationToSubmenus1.navigateToUsersInRegionalInfo();

		objUserFunctions1.enterUsernameInSearchInputField(
				objUserdata.strNewUserName).clickSearchButton();

		objRegionalInfo1.verUserDetailsInUserListPgeOfRegionalInfo(
				objUserdata.strNewUserName, objUserdata.strEditedFullName,
				objUserdata.strEditedOrganization, objUserdata.strEditedPhone,
				objUserdata.strEmail, objUserdata.strEmail);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyUserNameInFooter(
				objUserdata.strEditedFullName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/***************************************************************************************
	'Description : Edit a user and deselect a right and verify that the user no longer has the right.
	'Date	 	 : 05-Jun-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	****************************************************************************************/
	@Test(description = "Edit a user and deselect a right and verify that the user no longer has the right.")
	public void testHappyDay68507() throws Exception {

		gstrTCID = "68507";
		gstrTO = "Edit a user and deselect a right and verify that the user no longer has the right.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);
		objRegionDefault.selectFrame();
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption().clickSaveButton();
		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);
		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.navigateToUsers();
		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption().clickSaveButton();

		objLogin1.clickLogOut();
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.verSetUpTabIsNotDisplayed();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/**********************************************************************************************
	 * 'Description : Verify that a user with 'Update status' right on a resource receives the blank form sent to the resource.
	 * 'Date        : 05-Jun-2015
	 * 'Author      : Pallavi
	 **********************************************************************************************/

	@Test(description = "Verify that a user with 'Update status' right on a resource receives the blank form sent to the resource.")
	public void testHappyDay69665() throws Exception {
		
		gstrTCID = "69665";
		gstrTO = "Verify that a user with 'Update status' right on a resource receives the blank form sent to the resource.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		BlankFormData objBlankFormData = new BlankFormData();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
                this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
                this.driver1);

		Login login_page1 = new Login(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
        NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
                     this.driver1);
        ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
        BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

        String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		// User creation
		objUsersList.navigateToUsers();

		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName, 
						objUserdata.strNewPassword, 
						objUserdata.strFullName)
				.selectFirstRole()
				.clickSaveButton().verifyUserListPageIsDisplayed()
			    .clickCreateNewUserButton()
			    .enterUserDetails(objUserdata.strNewUserName1,
	                      objUserdata.strNewPassword, objUserdata.strFullName1)
	            .selectFirstRole()
	            .clickAdvancedOptionAndExpand()
	            .selectFormUserMayActivateFormsOption()
	            .clickSaveButton().verifyUserListPageIsDisplayed()
	            .clickCreateNewUserButton()
	            .enterAllUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2,
	                    objUserdata.strFirstName, objUserdata.strMiddleName,
	                    objUserdata.strLastName, objUserdata.strOrganization,
	                    objUserdata.strPhone, objUserdata.strPrimaryMailId,
	                    objUserdata.strPrimaryMailId,
	                    objUserdata.strPrimaryMailId)
	            .selectFirstRole()
	            .clickSaveButton().verifyUserListPageIsDisplayed();
				
		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton()
				.clickOnViewResChkBox()
				.clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
       objNavigationToSubmenus.clickOnConfigureForm();

       objFormConfiguration
                       .verFormConfigurePage()
                       .createNewFormTempltete()
                       .entireTittleName_DescriptionName(
                                     objFormConfiguration_data.strFormName,
                                     objFormConfiguration_data.strDiscriptiveName)
                       .selectOptionInFormActivationDropDown(
                                     objFormConfiguration_data.strFormActivatnUIOTFO)
                       .selCompletedFormDelivery(
                                     objFormConfiguration_data.strComptdFormDelvry)
                       .selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
                       .selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
                       .selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
                       .clickOnNextButton()
                       .clickOnNextButton()
                       .selectResources(objResourceType_data.strResourceTypeName)
                       .clickOnNextButton()
                       .selectActivateFormChkBox(objUserdata.strNewUserName1)
                       .clickOnSaveOfFormSecuritySetting();

        System.out.println(objFormConfiguration_data.strFormName);

        objFormConfiguration
                       .clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

        String mainWindowHandle = driver.getWindowHandle();
        
        Set<String> a = driver.getWindowHandles();
        Iterator<String> ite = a.iterator();

          while (ite.hasNext()) {
                 String popupHandle = ite.next().toString();

                 if (!popupHandle.contains(mainWindowHandle)) {
                       driver.switchTo().window(popupHandle);

                 }
          }

        objFormConfiguration.verTemplateDesignPage()
						    .clickOnInsert()
						    .clickOnGroupLink()
						    .verifyEditGroupOrTable()
						    .enterNewGroupName(objFormConfiguration_data.strGroupName)
						    .clickOnGroupDoneButton()
						    .clickOnAddButton(objFormConfiguration_data.strGroupName)
						    .clickOnFieldSet(objFormConfiguration_data.strGroupName)
						    .verifyEditFieldSetWindow()
						    .enterAttributesLabelName(objFormConfiguration_data.strAttributeName)
						    .clickOnEditFieldDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strNumeric)
						    .enterLabelName(objFormConfiguration_data.strLabelName)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()					    
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strText)
						    .enterLabelName(objFormConfiguration_data.strLabelName1)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()				    
						    .clickOnSaveButton();

        System.out.println("started");
        Thread.sleep(5000);
        System.out.println("ended");
        objFormConfiguration.clickOnPublishButton();
        Thread.sleep(5000);

        driver.close();

        driver.switchTo().window(mainWindowHandle);

        objRegionDefault.selectFrame();
		
		login_page.clickLogOut();
		
		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1.searchUserName(objUserdata.strNewUserName,
							objUserdata.strRole, objUserdata.strResourceType,
							objUserdata.strUsername, objUserdata.strsearchOption)
					 .editUserDetails(objUserdata.strNewUserName)
					 .selectViewResourceCheckBox(objResource_data.strResourceName)
					 .selectAssociateWithOfResource(objResource_data.strResourceName)
					 .clickSaveButton().verifyUserListPageIsDisplayed();
		
		login_page1.clickLogOut()
				   .loginAsNewUser(objUserdata.strNewUserName1,
	                      objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
        objNavigationToSubmenus1.navigateToActivateForm();

        objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
        				 .selResourceToFillOutForm(strResourceValue[0])
                         .clickOnActivateForm();
        
        login_page1.clickLogOut()
        		   .loginAsNewUser(objUserdata.strNewUserName,
        				   objTest_data.strPassword);
		
		objRegionDefault1.selectFrame();
		
		Thread.sleep(5000);
        String mainWindowHandle1 = driver1.getWindowHandle();
        Set<String> a1 = driver1.getWindowHandles();
        Iterator<String> ite1 = a1.iterator();

        while (ite1.hasNext()) {
                 String popupHandle = ite1.next().toString();

                 if (!popupHandle.contains(mainWindowHandle1)) {
                       driver1.switchTo().window(popupHandle);
                 }
          }

        objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName, 
							objBlankFormData.strNumericAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1, 
							objBlankFormData.strTextAnswer)
					.clickOnSave();
        Thread.sleep(5000);
        objBlankForm.clickOnComplete();
        
        Thread.sleep(7000);
		objDispatchForm.selUserToReceiveCompletedForm(
							objUserdata.strNewUserName2)
					   .clickOnDispatchForm();

        driver1.switchTo().window(mainWindowHandle1);

        objRegionDefault1.selectFrame();

        login_page1.clickLogOut()
        		   .loginAsNewUser(objUserdata.strNewUserName2,
                       objUserdata.strNewPassword);

	/*	String strMsg = "Submitted by " + objUserdata.strFullName 
						+ " at "
						+ objResource_data.strResourceName
						+ "\nSummary: | "
						+ objFormConfiguration_data.strLabelName + ": "
						+ objBlankFormData.strNumericAnswer + "| "
						+ objFormConfiguration_data.strLabelName1 + ": "
						+ objBlankFormData.strTextAnswer;*/
        
        String strMsg = objRegionDefault1.getWebNotificationWhenResourceFillsFormForTwoQuest(
				objUserdata.strFullName, objResource_data.strResourceName,
				objTest_data.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer,
				objFormConfiguration_data.strLabelName1,
				objBlankFormData.strTextAnswer);
        System.out.println(strMsg);
        Thread.sleep(5000);
		objRegionDefault1
                       .selectFrame()
                       .verWebNotificationframe()
                       .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
                                     strMsg)//EMS-6471 Resource name is not displayed in the web notification of the completed form.
                         .clickAcknowledgeAllForms()
                         .selectFrame();
        
        objRegionDefault1.switchToDefaultFrame()
        				 .selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
		 
		String strMsgBody = objMailVerificationFunctions.getFormMailBodyWithResource(
				objUserdata.strFullName, objTest_data.strRegionName, objResource_data.strResourceName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer,
				objFormConfiguration_data.strLabelName1,
				objBlankFormData.strTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBodyWithResource(
				objUserdata.strFullName, objTest_data.strRegionName, objResource_data.strResourceName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer,
				objFormConfiguration_data.strLabelName1,
				objBlankFormData.strTextAnswer);

		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			} else if (blnMsg3 == false && blnMsg1 == true) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions.logoutMail();

        gstrResult = "PASS";
	}

	/******************************************************************************************
	'Description : Verify that a user with only ‘Associated with’ right on a resource receives the
	 			   completed form sent to the resource.
	'Date	 	 : 05-Jun-2015
	'Author      : Pallavi
	'------------------------------------------------------------------------------------------
	'Modified Date			                        	                     Modified By
	'Date					                                                 Name
	*******************************************************************************************/
	@Test(description = "Verify that a user with only ‘Associated with’ right on a resource receives the completed"
			+ " form sent to the resource.")
	public void testHappyDay69679() throws Exception {

		gstrTCID = "69679";
		gstrTO = "Verify that a user with only ‘Associated with’ right on a resource receives the completed form"
				+ " sent to the resource.";

		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		
		String strStatusTypeValues [] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue    [] = new String[1];
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormList objFormList1 = new FormList(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
	                    objUserdata.strFirstName, objUserdata.strMiddleName,
	                    objUserdata.strLastName, objUserdata.strOrganization,
	                    objUserdata.strPhone, objUserdata.strPrimaryMailId,
	                    objUserdata.strPrimaryMailId,
	                    objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickSaveButton().verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
						.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton().verifyUserListPageIsDisplayed();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.selectFormActivation(objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selectCompletedFormDelivery(objFormConfiguration_data.strUserToIndividualResources)
				.clickOnNextButton()
				.deselectAllResources()
				.selectResources(objResource_data.strResourceName)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration.verTemplateDesignPage()
						    .clickOnInsert()
						    .clickOnGroupLink()
						    .verifyEditGroupOrTable()
		                    .enterNewGroupName(objFormConfiguration_data.strGroupName)
						    .clickOnGroupDoneButton()
						    .clickOnAddButton(objFormConfiguration_data.strGroupName)
						    .clickOnFieldSet(objFormConfiguration_data.strGroupName)
						    .verifyEditFieldSetWindow()
						    .enterAttributesLabelName(objFormConfiguration_data.strAttributeName)
						    .clickOnEditFieldDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strNumeric)
						    .enterLabelName(objFormConfiguration_data.strLabelName)
						    .clickOnAddToSummary()
						    .clickOnDoneButton();					    

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();
		
		System.out.println("-------precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1.searchUserName(objUserdata.strNewUserName,
							objUserdata.strRole, objUserdata.strResourceType,
							objUserdata.strUsername, objUserdata.strsearchOption)
					.editUserDetails(objUserdata.strNewUserName)		
					.selectViewResourceCheckBox(objResource_data.strResourceName)
					.selectUpdateStatusOfResource(objResource_data.strResourceName)
					.clickSaveButton().verifyUserListPageIsDisplayed();
		
		objLogin1.clickLogOut()			
				 .loginAsNewUser(objUserdata.strNewUserName1,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1.clickOnFillForm(objFormConfiguration_data.strFormName);

        String mainWindowHandle1 = driver1.getWindowHandle();
		
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();
		
		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();
		
			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);
		
			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName);
		
		Thread.sleep(2000);
		
		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToFormList();
		
		objFormList1.verifyFormIsListedUnderMyInProgressForm(objFormConfiguration_data.strFormName);
        
        objActivateForms1.clickOnFillOut(objFormConfiguration_data.strFormName);
		
		String mainWindowHandle2 = driver1.getWindowHandle();
		
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();
		
		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();
			
			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);				
			}
		}
		
		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer)
				.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		Thread.sleep(3000);
		objDispatchForm.selectResourcesInDispatch(
								objResource_data.strResourceName)
						.clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1 + " for "
				+ objResource_data.strResourceName + "\nSummary: | "
				+ objFormConfiguration_data.strLabelName + ": "
				+ objBlankFormData.strNumericAnswer;
		*/
		String strMsg = objRegionDefault1
				.getWebNotificationForResourceWithOneQuest(
						objUserdata.strFullName1,
						objResource_data.strResourceName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms()
				.switchToDefaultFrame()
				.selectFrame();
		
		objLogin1.clickLogOut();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
		 
		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer);

		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			} else if (blnMsg3 == false && blnMsg1 == true) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}	
	
	/******************************************************************************************
	'Description : Edit the event notification Preferences of User A while editing the user account
	 				of User A and verify that:
					a. The selected notification methods for event templates are retained when User A opens
					 	the event notification screen.
					b. User A receives event notification as selected.
	'Date	 	 : 08-Jun-2015
	'Author      : Pallavi
	'------------------------------------------------------------------------------------------
	'Modified Date			                        	                     Modified By
	'Date					                                                 Name
	*******************************************************************************************/
	@Test(description = "Edit the event notification Preferences of User A while editing the user account of User A and verify that:"
		+	"a. The selected notification methods for event templates are retained when User A opens the event notification screen."
		+	"b. User A receives event notification as selected.")
	public void testHappyDay68601() throws Exception {

		gstrTCID = "68601";
		gstrTO = "Edit the event notification Preferences of User A while editing the user account of User A and verify that:"
		+	"a. The selected notification methods for event templates are retained when User A opens the event notification screen."
		+	"b. User A receives event notification as selected.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		MyEventNotificationPreferences objMyEventNotificationPreferences_page1 = new MyEventNotificationPreferences(
				this.driver1);
		UpdateUserInfo objUpdateUserInfo = new UpdateUserInfo(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
		        .verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectEditEventNotificationPreferencesOption()
				.clickSaveButton().verifyUserListPageIsDisplayed();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton().verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(
				objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1.searchUserName(objUserdata.strNewUserName,
							objUserdata.strRole, objUserdata.strResourceType,
							objUserdata.strUsername, objUserdata.strsearchOption)
					 .editUserDetails(objUserdata.strNewUserName)
					 .clickOnEveNotPreferences()
					 .verEventNotificationPreferencesPageisDisplayed(
							 objUserdata.strNewUserName)
					 .verEveTemplateListed(objEventSetUp_data.strEventTemplate);
		
		objMyEventNotificationPreferences_page1.selectEmailNotification(
													   objEventSetUp_data.strEventTemplate)
											   .selectTextPagerIndNotification(
													   objEventSetUp_data.strEventTemplate)
											   .selectWebIndNotification(
													   objEventSetUp_data.strEventTemplate)
											   .clickOnSaveButton();
		
// issue is still open, un-comment when the issue is resolved
		objUsersList1.verifyEditUserPageIsDisplayed();

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToEventNotificationInPreferences();
		
		objMyEventNotificationPreferences_page1.verifyMyEventNotificationPrefPageIsDisp()
											   .verEveTemplateIsDisplayed(
													   objEventSetUp_data.strEventTemplate)
											   .verTextPagerChecked(
													   objEventSetUp_data.strEventTemplate)
												.verWebNotificationChecked(
														objEventSetUp_data.strEventTemplate)
												.verEmailNotificationChecked(
														objEventSetUp_data.strEventTemplate);
		
// Issue is still open, un-comment when the issue is resolved
		objUpdateUserInfo.verPreferencesMenuPageIsDisplayed();
		
		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName1,
							objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
						   .clickOnCreateNewEvent()
						   .clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
						   .enterAdHocEventName(objEvent_data.strEventName)
						   .enterAdHocEventDescription(objEvent_data.strEventDescription)
						   .selectResource(strResourceValue).clickOnSaveButton()
						   .verifyEventName(objEvent_data.strEventName);

		objLogin1.clickLogOut()
				 .loginToApplication(objUserdata.strNewUserName,
						 	objUserdata.strNewPassword);

		objRegionDefault1.selectFrame()
						 .verWebNotificationframe()
						 .verWebNotificationMsg(objEvent_data.strEventName, 
								 objEvent_data.strEventDescription)
						 .clickAcknowledgeAllNotifications()
						 .selectFrame().switchToDefaultFrame().selectFrame();
		
		objLogin1.clickLogOut();
		
		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
	
		String strSubject = objEvent_data.strEventName;
		
		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(
				objUserdata.strFullName, objUserdata.strFullName1,
				objLogindata.strRegionName, objEvent_data.strEventDescription);

		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objEvent_data.strEventDescription);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck= false;
		boolean boolCheck1 = false;
		
		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (boolCheck1 == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck && boolCheck1);
		
		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	

	/*************************************************************************************
	'Description 	: Verify that user with 'Edit Resource Only' right and update right on 
	                  a resource can edit sub-resources for their facility.
	'Date 			: 12-Dec-2015 
	'Author 		: Anitha
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user with 'Edit Resource Only' right and update right on "
			+ "a resource can edit sub-resources for their facility.")
	public void testHappyDay112340() throws Exception {

		gstrTCID = "112340";
		gstrTO = "Verify that user with 'Edit Resource Only' right and update right on a resource"
				+ " can edit sub-resources for their facility.";

		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		Views objViews1 = new Views(this.driver1);
		ViewsList ViewsList1 = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[2];
		String strSubResourceValue[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		String[] strstatusType1 = { strStatusTypeValues[0] };
		String[] strstatusType2 = { strStatusTypeValues[1] };

		// First resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusType1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// First Sub resource type creation
		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName, strstatusType2)
				.verResourceTypeInList(
						objResourceType_data.strSubResourceTypeName);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		// Resource creation
		objResource
				.navigateToResourceListPage()
				.createResource(objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName)

				.createResource(objResource_data.strResourceName1,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);
		// Sub Resource creation
		objResource
				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.clickOnCreateNewSubResourceButton()
				.enterResourceName(objResource_data.strSubResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton();

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);

		objResource
				.navigateToResourceListPage()
				.clickOnSubResourcesLink(objResource_data.strResourceName1)
				.clickOnCreateNewSubResourceButton()
				.enterResourceName(objResource_data.strSubResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton();

		strSubResourceValue[1] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName1);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand().selectEditResourcesOnlyOption()
				.clickSaveButton().verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objNavigationToSubmenus.navigateToViews();

		String strStatusTypeNames[]= {objStatuTypes_data.strNSTStatusTypeName};
		String strResourceName[]= {objResource_data.strResourceName, objResource_data.strResourceName1};
		objViewsList.createViewForMultipleResourcesAndStatusTypes(objView_data.strViewName, objView_data.strViewDesc, strResourceName, strStatusTypeNames);
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatuTypes_data.strNSTStatusTypeName)
//				.selectStatusType(objStatuTypes_data.strTSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.selectResource(objResource_data.strResourceName1)
//				.clickOnSaveOfCreateNewView();

		objViewsList
				.clickOncustomizeResourceDetailView()
				.clickSubResourceButton()
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strResourceTypeValue[1]);

		objViewsList.selectSubResourceCheckBox(strStatusTypeValues[1]);

		objViewsList.clickOnSaveButton();

		objLogin.clickLogOut();

		System.out.println("------Precondiotion ends test execution starts-----");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1
				.navigateToResourceListPageNew()
				.verResourceInList(objResource_data.strResourceName)
				.verResourceInNotInList(objResource_data.strResourceName1)
				.clickOnSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verCreateNewSubResourceButtonIsPresent()
				.verSubResourceInResourceListPage(
						objResource_data.strSubResourceName);

		objResource1
				.clickOnEditLinkInSubResourceListPage(
						objResource_data.strSubResourceName)
				.verEditSubResourceOfPageIsDisplayed(
						objResource_data.strResourceName)
				.enterResourceName(objResource_data.strSubResourceName2)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename1)
				.clickOnSaveButton()
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verSubResourceInSubResPage(
						objResource_data.strSubResourceName2)
				.verIconForSubResource(objResource_data.strSubResourceName2,
						objResource_data.strSubResourceIcon1)
				.verSubResourceAbbInSubResPage(
						objResource_data.strSubResourceName2,
						objResource_data.strResourceAbbrivation1);

		// View
		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		ViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViews1
				.verifyCreateNewSubResourceBtnUnderSubResourceSection()
				.verSubResourceInViewResDetailPage(
						objResource_data.strSubResourceName2,
						strSubResourceValue[0],
						objResourceType_data.strSubResourceTypeName,
						strResourceTypeValue[1])
				.verSTUnderSubResourceSection(strResourceTypeValue[1],
						strStatusTypeValues[1])
				.clickOnSubResourceNameLinkUnderSubResSection(
						strSubResourceValue[0], strResourceTypeValue[1])
				.verViewResourceDetailsPgeIsDisplayed()
				.verSubResourceNameAndItsDetails(
						objResource_data.strSubResourceName2,
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		ViewsList1.clickOnEditResourceDetailsLink();

		objResource1.enterResourceName(objResource_data.strSubResourceName3)
				.enterResourceFirstName(objResource_data.strEditedResFirstName)
				.enterResourceLastName(objResource_data.strEditedResLastName)
				.clickOnSaveButton();

		objViews1.verViewResourceDetailsPgeIsDisplayed()
				.verSubResourceNameAndItsDetails(
						objResource_data.strSubResourceName3,
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strEditedResFirstName,
						objResource_data.strEditedResLastName);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		ViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName1);
		objResource1.verCreateNewSubResourceButtonIsNotPresent();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that user with 'Setup Resources' right and update right on a 
	                   resource can edit sub-resources under it.
	'Date 			: 12-Dec-2015 
	'Author 		: Anitha
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user with 'Setup Resources' right and update right on a "
			+ "resource can edit sub-resources under it.")
	public void testHappyDay112341() throws Exception {

		gstrTCID = "112341";
		gstrTO = "Verify that user with 'Setup Resources' right and update right on a resource"
				+ " can edit sub-resources under it.";
	

		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		Views objViews1 = new Views(this.driver1);
		ViewsList ViewsList1 = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[2];
		String strSubResourceValue[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()
		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		String[] strstatusType1 = { strStatusTypeValues[0] };
		String[] strstatusType2 = { strStatusTypeValues[1] };

		// First resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusType1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// First Sub resource type creation
		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName, strstatusType2)
				.verResourceTypeInList(
						objResourceType_data.strSubResourceTypeName);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		// Resource creation
		objResource
				.navigateToResourceListPage()
				.createResource(objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName)

				.createResource(objResource_data.strResourceName1,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);
		// Sub Resource creation
		objResource
				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.clickOnCreateNewSubResourceButton()
				.enterResourceName(objResource_data.strSubResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton();

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);

		objResource
				.navigateToResourceListPage()
				.clickOnSubResourcesLink(objResource_data.strResourceName1)
				.clickOnCreateNewSubResourceButton()
				.enterResourceName(objResource_data.strSubResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton();

		strSubResourceValue[1] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName1);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand().selectSetupResourceOption()
				.clickSaveButton().verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objNavigationToSubmenus.navigateToViews();
		
		String strResourceName[]= {objResource_data.strResourceName, objResource_data.strResourceName1};
		String strStatusTypeNames[] = {objStatuTypes_data.strNSTStatusTypeName};
		

		objViewsList.createViewForMultipleResourcesAndStatusTypes(objView_data.strViewName, objView_data.strViewDesc, strResourceName, strStatusTypeNames);
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatuTypes_data.strNSTStatusTypeName)
//				.selectStatusType(objStatuTypes_data.strTSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.selectResource(objResource_data.strResourceName1)
//				.clickOnSaveOfCreateNewView();

		objViewsList
				.clickOncustomizeResourceDetailView()
				.clickSubResourceButton()
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strResourceTypeValue[1]);

		objViewsList.selectSubResourceCheckBox(strStatusTypeValues[1]);

		objViewsList.clickOnSaveButton();

		objLogin.clickLogOut();

		System.out.println("------Precondiotion ends test execution starts-----");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1
				.navigateToResourceListPageNew()
				.verResourceInList(objResource_data.strResourceName)
				.verResourceInList(objResource_data.strResourceName1)
				.clickOnSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verCreateNewSubResourceButtonIsPresent()
				.verSubResourceInResourceListPage(
						objResource_data.strSubResourceName);

		objResource1
				.clickOnEditLinkInSubResourceListPage(
						objResource_data.strSubResourceName)
				.verEditSubResourceOfPageIsDisplayed(
						objResource_data.strResourceName)
				.enterResourceName(objResource_data.strSubResourceName2)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename1)
				.clickOnSaveButton()
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verSubResourceInSubResPage(
						objResource_data.strSubResourceName2)
				.verIconForSubResource(objResource_data.strSubResourceName2,
						objResource_data.strSubResourceIcon1)
				.verSubResourceAbbInSubResPage(
						objResource_data.strSubResourceName2,
						objResource_data.strResourceAbbrivation1);
		
		objResource1.navigateToResourceListPage()
		.clickOnSubResources1LinkInResourceList(
						objResource_data.strResourceName1)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName1)
				.verCreateNewSubResourceButtonIsPresent()
				.verEditLinkForSubResource(objResource_data.strSubResourceName1)
				.clickOnEditLinkInSubResourceListPage(
						objResource_data.strSubResourceName1)
				.verEditSubResourceOfPageIsDisplayed(
						objResource_data.strResourceName1)
				.enterResourceName(objResource_data.strSubResourceName3)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename1)
				.clickOnSaveButton()
				.verSubResourceInSubResPage(
						objResource_data.strSubResourceName3)
				.verIconForSubResource(objResource_data.strSubResourceName3,
						objResource_data.strSubResourceIcon1)
				.verSubResourceAbbInSubResPage(
						objResource_data.strSubResourceName3,
						objResource_data.strResourceAbbrivation1);

		// View
		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		ViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViews1
				.verifyCreateNewSubResourceBtnUnderSubResourceSection()
				.verSubResourceInViewResDetailPage(
						objResource_data.strSubResourceName2,
						strSubResourceValue[0],
						objResourceType_data.strSubResourceTypeName,
						strResourceTypeValue[1])
				.verSTUnderSubResourceSection(strResourceTypeValue[1],
						strStatusTypeValues[1]);
		
		objViews1.clickOnSubResourceNameLinkUnderSubResSection(
						strSubResourceValue[0], strResourceTypeValue[1])
				.verViewResourceDetailsPgeIsDisplayed();

		ViewsList1.clickOnEditResourceDetailsLink();

		objResource1.enterResourceName(objResource_data.strSubResourceName4)
				.enterResourceFirstName(objResource_data.strEditedResFirstName)
				.enterResourceLastName(objResource_data.strEditedResLastName)
				.clickOnSaveButton();

		objViews1.verViewResourceDetailsPgeIsDisplayed()
				.verSubResourceNameAndItsDetails(
						objResource_data.strSubResourceName4,
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strEditedResFirstName,
						objResource_data.strEditedResLastName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/******************************************************************************************
	'Description : Edit the status change notification Preferences of User A while editing the user account of User A and verify that:
                  a. The selected notification methods for the resources are retained when User A opens the status change notification screen.
                  b. User A receives status change notification as selected.
	'Date	 	 : 21-Dec-2015
	'Author      : Sangappa K
	'------------------------------------------------------------------------------------------
	'Modified Date			                        	                     Modified By
	'Date					                                                 Name
	*******************************************************************************************/
	@Test(description ="Edit the status change notification Preferences of User A while editing the user account of User A and verify that:"+
     "a. The selected notification methods for the resources are retained when User A opens the status change notification screen."+
     "b. User A receives status change notification as selected.")
	public void testHappyDay69680() throws Exception {

		gstrTCID ="69680";
		gstrTO = "Edit the status change notification Preferences of User A while editing the user account of User A and verify that:"+
     "a. The selected notification methods for the resources are retained when User A opens the status change notification screen."+
     "b. User A receives status change notification as selected.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		UpdateStatus_data objUpdateStatus_data = new UpdateStatus_data();

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Date_Time_settings dts = new Date_Time_settings();

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource

		.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.enterEmail(objUserdata.strPrimaryMailId)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton().verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton().verifyUserListPageIsDisplayed();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickStatusChangeNotificationPreferencesIsDisplayed();

		objStatusChangePreference

				.verStatusChangePreferencesforUserPage(
						objUserdata.strNewUserName)
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.verEditMyStatusChangePrefForUserPgeDisplayed(
						objUserdata.strNewUserName).expandUncategorizedSec();

		objStatusChangePreference
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strNSTStatusTypeName)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[0])
				.clickOnSave();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();
		objStatusChangePreference1.verMyStatusChangePreferncePgeDisplayed()
				.verStatusTypeNotification(
						objStatusTypes_data.strNSTStatusTypeName);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		objMap1.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.verUpdateStatusPge()
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objUpdateStatus_data.strNSTUpdateValue)
				.clickOnSaveButton();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");

		System.out.println("strUpdatedTime");
		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verWebNotificationframe();

		objUpdateStatus1
				.verWebNotificationForStatusUpdateForNST(
						objResource_data.strResourceName,
						objStatusTypes_data.strNSTStatusTypeName,
						objUpdateStatus_data.strNSTUpdateValue, strUpdatedTime)
				.clickAcknowledgeAllNotifications().selectFrame();

		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName;

		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation;

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);
			if (boolCheck == true) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailContainsBody(objMailVerificationFunctions
								.getStatusChangeEmailBodyForNST(
										objUserdata.strFullName,
										strUpdatedTime,
										objResource_data.strResourceName,
										objStatusTypes_data.strNSTStatusTypeName,
										objUpdateStatus_data.strNSTUpdateValue,
										objLogindata.strRegionName,
										objResourceType_data.strResourceTypeName));
			}

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(objMailVerificationFunctions
								.getStatusChangeEmailBodyForNST(
										objUserdata.strFullName,
										strUpdatedTime,
										objResource_data.strResourceName,
										objStatusTypes_data.strNSTStatusTypeName,
										objUpdateStatus_data.strNSTUpdateValue,
										objLogindata.strRegionName,
										objResourceType_data.strResourceTypeName));
			}
			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck && boolCheck1);

		objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
				strSubjectForPager);

		boolCheck2 = objMailVerificationFunctions
				.verifyMailBody(objMailVerificationFunctions
						.getStatusChangePagerBodyForNST(strUpdatedTime,
								objResource_data.strResourceName,
								objStatusTypes_data.strNSTStatusTypeName,
								objUpdateStatus_data.strNSTUpdateValue,
								objLogindata.strRegionName));
		assertTrue(boolCheck2);
		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";

	}

	/*************************************************************************************
	'Description 	: Verify that a user with 'Update status' right on a resource receives expired status notification when the status of the resource expires.
	'Date 			: 04-Jan-2016
	'Author 		: Sangappa  k
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description ="Verify that a user with 'Update status' right on a resource receives expired status notification when the status of the resource expires.")
	public void testHappyDay66038() throws Exception {

		gstrTCID ="66038";
		gstrTO = "Verify that a user with 'Update status' right on a resource receives expired status notification when the status of the resource expires.";
	

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		

		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strStatusesValues1[] = new String[2];
		
		String strCurrentYear = "";

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		StatusTypeList_page
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.clickOnSaveButton();

		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectEventExpirationOption()
				.selectExpirationMinute(objStatusTypes_data.strExpSec)
				.clickOnSaveButton();

		strStatusesValues[0] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectEventExpirationOption()
				.selectExpirationMinute(objStatusTypes_data.strExpSec)
				.clickOnSaveButton();

		strStatusesValues[1] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		StatusTypeList_page.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		String strApplicationTime = objEventManagement.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strTimeInMin = objDts.addTimetoExisting(strTime[2], 10, "HH:mm");
		String strTime1[] = strTimeInMin.split(":");
		System.out.println(strTimeInMin);

		strCurrentYear = objDts.getCurrentDate("yyyy");

		String strApplicationTime3 = strApplicationTime + " " + strCurrentYear;

		strApplicationTime3 = objDts.converDateFormat(strApplicationTime3,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime3 = objDts.addTimetoExisting(strApplicationTime3, 10,
				"MM/dd/yyyy HH:mm");

		System.out.println("strApplicationTime3 " + strApplicationTime3);

		StatusTypeList_page.createStatusTypeWithShiftTime(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription, strTime1[0],
				strTime1[1]);

		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti2)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.clickOnSaveButton();

		strStatusesValues1[0] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti3)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.clickOnSaveButton();

		strStatusesValues1[1] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		StatusTypeList_page.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		System.out.println(objStatusTypes_data.strMSTStatusTypeName1);

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		// Resource creation
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page.createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation1,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton().verifyUserListPageIsDisplayed();
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("---Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUsers();
		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton().verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)

				.clickSystemNotificationPreferences()
				.clickExpiredStatusNotificationsEmailCheckBox()
				.clickExpiredStatusNotificationsTextPagerCheckBox()
				.clickSaveButton().clickOnOkButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		objMap1.clickUpdateStatusInPopupWindow();
		objUpdateStatus1.clickOnSelectAll();

		objUpdateStatus1
				.verUpdateStatusPge()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues1[0]).clickOnSaveButton();

		strApplicationTime = EventManagement_page1.getApplicationTime();

		strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");

		System.out.println("// wait until expiration time");

		// Wait for 5 min
		TimeUnit.MINUTES.sleep(6);Thread.sleep(15000);

		String strSubjName = "EMResource Expired Status Notification: "
				+ objResource_data.strResourceName;

		String strSubjName1 = "EMResource Expired Status: "
				+ objResource_data.strResourceAbbrivation1;

		String strMsgBody1 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime);

		String strMsgBody2 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime);

		String strMsgBody3 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName, strApplicationTime3);

		String strMsgBody4 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName, strApplicationTime3);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubjName);

		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;
		boolean boolCheck3 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjName);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			if (boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck && boolCheck1);

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjName1);

			if (boolCheck2 == false) {
				boolCheck2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			if (boolCheck3 == false) {
				boolCheck3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody4);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck2 && boolCheck3);

		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}
	
	/*****************************************************************************************
	'Description : Verify that a user with 'Update status' right on a resource receives status
	               update prompt when the status of the resource expires.
	'Date	 	 : 11-Feb-2016
	'Author		 : Anil
	'-----------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************/
	@Test( description = "Verify that a user with 'Update status' right on a resource receives status"
			+ " update prompt when the status of the resource expires.")
	public void testHappyDay105969() throws Exception {

		gstrTCID = "105969";
		gstrTO = "Verify that a user with 'Update status' right on a resource receives status update "
				+ "prompt when the status of the resource expires.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Roles_data objRolesData = new Roles_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		EventManagement objEventManagement= new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[4];
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName).clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		StatusTypeList_page
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.selectRoleUnderRolesWithUpdateRight(strRoleValue[0])
				.clickOnSaveButton();

		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectEventExpirationOption()
				.selectExpirationMinute(objStatusTypes_data.strExpSec)
				.clickOnSaveButton();

		strStatusesValues[0] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectEventExpirationOption()
				.selectExpirationMinute(objStatusTypes_data.strExpSec)
				.clickOnSaveButton();

		strStatusesValues[1] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		StatusTypeList_page.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		
		StatusTypeList_page
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName1)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription);

		String strApplicationTime = objEventManagement.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strTimeInMin = objDts.addTimetoExisting(strTime[2], 10, "HH:mm");
		String strTime1[] = strTimeInMin.split(":");
		System.out.println(strTimeInMin);

		StatusTypeList_page.selectShiftTime(strTime1[0], strTime1[1])
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.selectRoleUnderRolesWithUpdateRight(strRoleValue[0])
				.clickOnSaveButton();

		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[2] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti3,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[3] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		StatusTypeList_page.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		// Resource creation
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMustUpdateOverdueStatusOption().clickSaveButton().verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
		
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objUpdateStatus1.verUpdateStatusPge();
		
		objRegionDefault1
				.verifyResourceStatusOverDueStatus(objResource_data.strResourceName);
		for (int intCount = 0; intCount < strStatusTypeValues.length; intCount++) {
			objUpdateStatus1
					.verifyOverDueStatusIsDisplayed(strStatusTypeValues[intCount]);
		}
		objUpdateStatus1.clickOnRemindMeIn10MinBtn();
		
		objRegionDefault1.verifyRegionDefaultPage();
		
		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[2]).clickOnSaveButton();

		// wait until expiration time
		Thread.sleep(360000);
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		
		objUpdateStatus1.verifyOverDueStatusIsNotDisplayed(strStatusTypeValues[0]);
		
		// wait until Shift time
		objUpdateStatus1.waitUntilShiftTime(strTimeInMin);
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		
		objUpdateStatus1.verifyOverDueStatusIsNotDisplayed(strStatusTypeValues[1]);
		
		// Wait for 10 min
		TimeUnit.MINUTES.sleep(10);
		TimeUnit.MINUTES.sleep(1);
		objRegionDefault1.verifyUpdateStatusPage();
		
		objRegionDefault1
				.verifyResourceStatusOverDueStatus(objResource_data.strResourceName);
		for (int intCount = 0; intCount < strStatusTypeValues.length; intCount++) {
			objUpdateStatus1
					.verifyOverDueStatusIsDisplayed(strStatusTypeValues[intCount]);
		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}