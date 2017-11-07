package requirementGroup.CreatingAndManagingRoles;

import lib.dataObject.InstantMessaging_data;
import lib.dataObject.Login_data;
import lib.dataObject.Roles_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.FormSecurity;
import lib.page.InstantMessaging;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.RegionalInfo;
import lib.page.Resource;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewDeleteRole  extends TestNG_UI_EXTENSIONS{

	public NewDeleteRole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*********************************************************************************
	'Description : Verify that user with 'Setup Roles' right can delete a role
	'Precondition:
	'Date	 	 : 12-Jan-2016
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that user with 'Setup Roles' right can delete a role")
	public void testHappyDay127534() throws Exception {
		
		gstrTCID = "127534";
		gstrTO = "Verify that user with 'Setup Roles' right can delete a role";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRolesdata = new Roles_data();

		UsersList objUsersList_page = new UsersList(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
	
		String strRoleValue[] = new String[1];

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objUsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.clickAdvancedOptionAndExpand().selectSetUpRolesRight()
				.clickSaveButton();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().verifyRoleListPageIsDisplayed()
				.enterRoleName(objRolesdata.strRoleName);

		objUsersList_page.selectSetupResourceOption();

		objRoles.clickOnSaveBtn().verifyCreatedRoleInRolesList(
				objRolesdata.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesdata.strRoleName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList_page
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strEquals)
				.editUserDetails(objUserdata.strNewUserName)
				.selectRoleCheckBox(strRoleValue).clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnDeleteRole(objRolesdata.strRoleName);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.verResourceSubMenuNotPresent();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************
	'Description : Verify that system admin can delete a role.
	'Date	 	 : 13-Jan-2016
	'Author		 : Anitha
	'---------------------------------------------------------------
	'Modified Date			              Modified By
	'Date					              Name
	****************************************************************/
	@Test(description = " Verify that system admin can delete a role.")
	public void testHappyDay127532() throws Exception {
		
		gstrTCID = "127532";
		gstrTO = " Verify that system admin can delete a role.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRolesdata = new Roles_data();
		InstantMessaging_data objInstantMessagingdata=new InstantMessaging_data();

		Login objLogin = new Login(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		UsersList objUsersList_page1 = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList1=new StatusTypeList(this.driver1);
		RegionalInfo objRegionalInfo1=new RegionalInfo(this.driver1);
		Resource objResource1=new Resource(this.driver1);
		FormSecurity FormSecurity1=new FormSecurity(this.driver1);
		InstantMessaging objInstantMessaging1=new InstantMessaging(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);      
	
		String strRoleValue[] = new String[2];

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesdata.strRoleName).clickOnSaveBtn();
		
		strRoleValue[0] = objRoles.getRoleValue(objRolesdata.strRoleName);
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesdata.strRoleName1).clickOnSaveBtn();

		strRoleValue[1] = objRoles.getRoleValue(objRolesdata.strRoleName1);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.clickAdvancedOptionAndExpand()
				.selectInstantMessagingInitiateChatSessionOption()
				.clickSaveButton();

		objLogin.clickLogOut();
		
		System.out.println("----Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnDeleteRole(objRolesdata.strRoleName)
				.clickOnDeleteRole(objRolesdata.strRoleName1)
				.verifyRoleNotInRolesList(objRolesdata.strRoleName)
				.verifyRoleNotInRolesList(objRolesdata.strRoleName1);

		objUsersList_page1.navigateToUsersNew().clickCreateNewUserButton()
				.verifyRoleNameIsNotListed(strRoleValue[0])
				.verifyRoleNameIsNotListed(strRoleValue[1]).clickCancelButton()
				.clickEditForFirstUser()
				.verifyRoleNameIsNotListed(strRoleValue[0])
				.verifyRoleNameIsNotListed(strRoleValue[1]);
		
		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1.clickCreateNewStatusTypeButton()
		        .clickNextButton()
				.verifyRoleNameIsNotListed(strRoleValue[0])
				.verifyRoleNameIsNotListed(strRoleValue[1])
				.clickCancelButton()
				.clickOnEditOfFirstStatusType()
				.verifyRoleNameIsNotListed(strRoleValue[0])
				.verifyRoleNameIsNotListed(strRoleValue[1]);
		
		objUsersList_page1.navigateToUsersNew()
				.verRoleIsNotPresentInSearchDropDown(objRolesdata.strRoleName)
				.verRoleIsNotPresentInSearchDropDown(objRolesdata.strRoleName1);
		
		objNavigationToSubmenus1.navigateToUsersInRegionalInfo();
		
		objRegionalInfo1.verRoleIsNotPresentInSearchDropDown(
				objRolesdata.strRoleName).verRoleIsNotPresentInSearchDropDown(
				objRolesdata.strRoleName1);
		
		objNavigationToSubmenus1.navigateToResourceInSetup();
		
		objResource1.clickOnUsersLinkOfFirstRes()
				.verRoleIsNotPresentInSearchDropDown(objRolesdata.strRoleName)
				.verRoleIsNotPresentInSearchDropDown(objRolesdata.strRoleName1);
		
		objNavigationToSubmenus1.navigateToFormMenu().clickOnConfigureForm();
		
		FormSecurity1.clickOnSecurityLinkOfFirstForm()
				.verRoleIsNotPresentInSearchDropDown(objRolesdata.strRoleName)
				.verRoleIsNotPresentInSearchDropDown(objRolesdata.strRoleName1);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnIMTab();

		objRegionDefault1.switchToDefaultFrame();

		objInstantMessaging1.switchToInstantMessagingFrame()
				.clickOnNewPrivateChatButton()
				.selectFindUserType(objInstantMessagingdata.strUserType)
				.enterContainsText(objRolesdata.strRoleName).clickNextButton()
				.verifyErrorMsgInCreateNewChatPage(objRolesdata.strRoleName)
				.clickOnCancelButtonInPrivateChatWindow()

				.clickOnNewPrivateChatButton()
				.selectFindUserType(objInstantMessagingdata.strUserType)
				.enterContainsText(objRolesdata.strRoleName1).clickNextButton()
				.verifyErrorMsgInCreateNewChatPage(objRolesdata.strRoleName1)
				.clickOnCancelButtonInPrivateChatWindow();

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description : Verify that default role set can be deleted by a user with appropriate right.
	'Date	 	 : 13-Jan-2016
	'Author		 : Anitha
	'-------------------------------------------------------------------------------------------
	'Modified Date			              Modified By
	'Date					              Name
	********************************************************************************************/
	@Test(description = "Verify that default role set can be deleted by a user with appropriate right.")
	public void testHappyDay127533() throws Exception {
		
		gstrTCID = "127533";
		gstrTO = "Verify that default role set can be deleted by a user with appropriate right.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRolesdata = new Roles_data();
		InstantMessaging_data objInstantMessagingdata=new InstantMessaging_data();

		Login objLogin = new Login(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		UsersList objUsersList_page1 = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList1=new StatusTypeList(this.driver1);
		RegionalInfo objRegionalInfo1=new RegionalInfo(this.driver1);
		Resource objResource1=new Resource(this.driver1);
		FormSecurity FormSecurity1=new FormSecurity(this.driver1);
		InstantMessaging objInstantMessaging1=new InstantMessaging(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);      
	
		String strRoleValue[] = new String[1];

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName1);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesdata.strRoleName).clickOnSaveBtn();
		
		strRoleValue[0] = objRoles.getRoleValue(objRolesdata.strRoleName);
		
		objRoles.clickOnDefaultLinkOfRole(objRolesdata.strRoleName);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.clickAdvancedOptionAndExpand()
				.selectInstantMessagingInitiateChatSessionOption()
				.clickSaveButton();

		objLogin.clickLogOut();
		
		System.out.println("----Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName1);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnDeleteRole(objRolesdata.strRoleName)
				.verifyRoleNotInRolesList(objRolesdata.strRoleName);

		objUsersList_page1.navigateToUsersNew().clickCreateNewUserButton()
				.verifyRoleNameIsNotListed(strRoleValue[0])
				.clickCancelButton()
				.clickEditForFirstUser()
				.verifyRoleNameIsNotListed(strRoleValue[0]);
		
		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1.clickCreateNewStatusTypeButton()
		        .clickNextButton()
				.verifyRoleNameIsNotListed(strRoleValue[0])
				.clickCancelButton()
				.clickOnEditOfFirstStatusType()
				.verifyRoleNameIsNotListed(strRoleValue[0]);
		
		objUsersList_page1.navigateToUsersNew()
				.verRoleIsNotPresentInSearchDropDown(objRolesdata.strRoleName);
		
		objNavigationToSubmenus1.navigateToUsersInRegionalInfo();
		
		objRegionalInfo1.verRoleIsNotPresentInSearchDropDown(
				objRolesdata.strRoleName);
		
		objNavigationToSubmenus1.navigateToResourceInSetup();
		
		objResource1.clickOnUsersLinkOfFirstRes()
				.verRoleIsNotPresentInSearchDropDown(objRolesdata.strRoleName);
		
		objNavigationToSubmenus1.navigateToFormMenu().clickOnConfigureForm();
		
		FormSecurity1.clickOnSecurityLinkOfFirstForm()
				.verRoleIsNotPresentInSearchDropDown(objRolesdata.strRoleName);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnIMTab();

		objRegionDefault1.switchToDefaultFrame();

		objInstantMessaging1.switchToInstantMessagingFrame()
				.clickOnNewPrivateChatButton()
				.selectFindUserType(objInstantMessagingdata.strUserType)
				.enterContainsText(objRolesdata.strRoleName).clickNextButton()
				.verifyErrorMsgInCreateNewChatPage(objRolesdata.strRoleName)
				.clickOnCancelButtonInPrivateChatWindow();

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
