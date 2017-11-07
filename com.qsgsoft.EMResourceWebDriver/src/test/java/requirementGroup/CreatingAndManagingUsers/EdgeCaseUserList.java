package requirementGroup.CreatingAndManagingUsers;

import lib.dataObject.Login_data;
import lib.dataObject.Roles_data;
import lib.dataObject.User_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseUserList extends TestNG_UI_EXTENSIONS{
	
	public EdgeCaseUserList() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/****************************************************************************************************
	'Description : Verify that user created is listed on the 'Users List' screen.  
	'Date	 	 : 26-feb-2016
	'Author		 : Sandhya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "Verify that user created is listed on the 'Users List' screen.")
	public void testEdgeCase91316() throws Exception {

		gstrTCID = "91316";
		gstrTO = "Verify that user created is listed on the 'Users List' screen.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRolesdata = new Roles_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);
		
		String strRoleValue[] = new String[1];
		
		String[] strDropDownValues = {
				objUserdata.strContains,
				objUserdata.strEquals,
				objUserdata.strStartsWith,
				objUserdata.strEndsWith,
				objUserdata.strNotEqualTo};
		
		// precondition

		objLogin.loginToApplication(objLogindata.strAdminUser,
				                    objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRoles();	
		
		objRoles.clickOnCreateNewRoleBtn()
		        .enterRoleName(objRolesdata.strRoleName)		
		        .clickOnSaveBtn();
	
		strRoleValue[0] = objRoles.getRoleValue(objRolesdata.strRoleName);
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList.clickCreateNewUserButton()
				    .enterUserDetails(objUserdata.strNewUserName,
						              objUserdata.strNewPassword, 
						              objUserdata.strFullName)
				    .selectFirstRole()
				    .clickSaveButton()
		            .clickCreateNewUserButton()
	                .enterUserDetails(objUserdata.strNewUserName1,
			                          objUserdata.strNewPassword1, 
			                          objUserdata.strFullName1)
			        .selectFirstRole()
			        .clickSaveButton()
			        .enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				    .clickSearchButton()
				    .editUserDetails(objUserdata.strNewUserName1)
				    .clickOnUserDeactivateChkBox()
				    .clickSaveButton()
				    .verifyWarningPage(objUserdata.strNewUserName1, objUserdata.strFullName1)
					.clickOnYesDeactivateThisUserBtn()
					.verifyDeactivationConfirmPage(objUserdata.strNewUserName1, objUserdata.strFullName1)
					.clickOnReturnToListBtn();
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
									 objLogindata.strAdminUserPwd);
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1.verifyUserListPageIsDisplayed()
		             .enterUsernameInSearchInputField(objUserdata.strNewUserName)
		             .clickSearchButton()				     
		             .verUserInList(objUserdata.strNewUserName)
		             .createNewUserButtonIsPresent()
		             .verIncludeInactiveUsersChkBxIsPresent()
		             .verIncludeInactiveUsersChkBxIsEnabled()
     	             .verIncludeInactiveUsersChkBxIsNotSelected();
		
		objNavigationToSubmenus1.navigateToUsers();    
		
		int initalCount = objUsersList1.getUserCount();
		
		objUsersList1.clickCreateNewUserButton()
		             .verifyCreateUserPageIsDisplayed()
		             .verUserProfileTextIsPresent()
		             .verUsernameTextIsPresent()
		             .verInitialPasswordTextIsPresent()
		             .verConfirmPasswordTextIsPresent()
		             .verFullNameTextIsPresent()
		             .verFirstNameTextIsPresent()
		             .verMiddleNameTextIsPresent()
		             .verLastNameTextIsPresent()
		             .verOrganizationTextIsPresent()
		             .verContactPhoneTextIsPresent()
		             .verPrimaryEMailTextIsPresent()
		             .verEMailAddressesTextIsPresent()
		             .verTextPagerAddressesTextIsPresent()
		             .verAdministrativeCommentsTextIsPresent()
		             .verUserTypeRolesTextIsPresent()
		             .verWebServicesUserTextIsPresent()
		             .verRolesTextIsPresent()
		             .verViewsTextIsPresent()
		             .verDefaultViewTextIsPresent()
		             .verViewsInThisRegionTextIsPresent()
	                 .verResourceRightsTextIsPresent()
		             .verAnyResourceTypeDropDownIsPresent()
		             .verResourceNameDropDownIsPresent()
		             .verContainsDropDown(strDropDownValues)
		             .verAdvancedOptionsTextIsPresent()
		             .enterAllUserDetails(objUserdata.strNewUserName2, 
		            		 			  objUserdata.strNewPassword1, 
		            		 			  objUserdata.strFullName2, 
		            		 			  objUserdata.strFirstName, 
		            		 			  objUserdata.strMiddleName, 
		            		 			  objUserdata.strLastName, 
		            		 			  objUserdata.strOrganization, 
		            		 			  objUserdata.strPhone, 
		            		 			  objUserdata.strPrimaryMailId, 
		            		 			  objUserdata.strPrimaryMailId, 
		            		 			  objUserdata.strPrimaryMailId)
		             .selectRoleCheckBox(strRoleValue)
		             .clickSaveButton()
		             .verifyUserListPageIsDisplayed()
		             .enterUsernameInSearchInputField(objUserdata.strNewUserName2)
		             .clickSearchButton()	
		             .verUserDetails(objUserdata.strNewUserName2, objUserdata.strFullName2, objUserdata.strOrganization)
		             .verNeverTextIsDisplayed(objUserdata.strNewUserName2)
		             .verEditLink(objUserdata.strNewUserName2)
		             .verPasswordLink(objUserdata.strNewUserName2)
		             .verRegionsLink(objUserdata.strNewUserName2)
		             .verSwitchLink(objUserdata.strNewUserName2)
		             .clearUsernameInSearchInputField()
		             .clickSearchButton()
		             .verUserCountIsIncremented(1, initalCount)
		             .verActionsColIsPresent()
		             .verUsernameColIsPresent()
		             .verFullnameColIsPresent()
		             .verOrganizationColIsPresent()
		             .verLastLoginColIsPresent()
		             .verUserNotInList(objUserdata.strNewUserName1)
		             .verSearchOptionIsPresent()
		             .verPhoneColIsNotPresent()
		             .verRolesColIsNotPresent()		             
		             .verEmailColIsNotPresent();
		
		objLinksAtTopRightCorners1.verPrintLink()
								  .verExportLink()
								  .verHelpLink();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	
	/****************************************************************************************************
	'Description : Verify that the user details edited are updated on the 'Users List' screen.  
	'Date	 	 : 2-Mar-2016
	'Author		 : Sandhya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "Verify that the user details edited are updated on the 'Users List' screen.")
	public void testEdgeCase91317() throws Exception {

		gstrTCID = "91317";
		gstrTO = "Verify that the user details edited are updated on the 'Users List' screen.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRolesdata = new Roles_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);

		String strRoleValue[] = new String[1];

		String[] strDropDownValues = { objUserdata.strContains,
				objUserdata.strEquals, objUserdata.strStartsWith,
				objUserdata.strEndsWith, objUserdata.strNotEqualTo };

		// precondition

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesdata.strRoleName).clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesdata.strRoleName);

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
				.selectRoleCheckBox(strRoleValue)
				.clickSaveButton()
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword1, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.clickSaveButton()
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword1, objUserdata.strFullName2,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName2)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName2)
				.clickOnUserDeactivateChkBox()
				.clickSaveButton()
				.verifyWarningPage(objUserdata.strNewUserName2,
						objUserdata.strFullName2)
				.clickOnYesDeactivateThisUserBtn()
				.verifyDeactivationConfirmPage(objUserdata.strNewUserName2,
						objUserdata.strFullName2).clickOnReturnToListBtn();

		objLogin.clickLogOut();

		// Steps

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1.verifyUserListPageIsDisplayed()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton().verUserInList(objUserdata.strNewUserName)
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton().verUserInList(objUserdata.strNewUserName1)
				.createNewUserButtonIsPresent()
				.verIncludeInactiveUsersChkBxIsPresent()
				.verIncludeInactiveUsersChkBxIsEnabled()
				.verIncludeInactiveUsersChkBxIsNotSelected();

		objNavigationToSubmenus1.navigateToUsers();

		int initalCount = objUsersList1.getUserCount();

		objUsersList1
				.clickCreateNewUserButton()
				.verifyCreateUserPageIsDisplayed()
				.verUserProfileTextIsPresent()
				.verUsernameTextIsPresent()
				.verInitialPasswordTextIsPresent()
				.verConfirmPasswordTextIsPresent()
				.verFullNameTextIsPresent()
				.verFirstNameTextIsPresent()
				.verMiddleNameTextIsPresent()
				.verLastNameTextIsPresent()
				.verOrganizationTextIsPresent()
				.verContactPhoneTextIsPresent()
				.verPrimaryEMailTextIsPresent()
				.verEMailAddressesTextIsPresent()
				.verTextPagerAddressesTextIsPresent()
				.verAdministrativeCommentsTextIsPresent()
				.verUserTypeRolesTextIsPresent()
				.verWebServicesUserTextIsPresent()
				.verRolesTextIsPresent()
				.verViewsTextIsPresent()
				.verDefaultViewTextIsPresent()
				.verViewsInThisRegionTextIsPresent()
				.verResourceRightsTextIsPresent()
				.verContainsDropDown(strDropDownValues)
				.verAdvancedOptionsTextIsPresent()
				.enterAllUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword1, objUserdata.strFullName3,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue).clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton().verUserInList(objUserdata.strNewUserName)
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton().verUserInList(objUserdata.strNewUserName1)
				.createNewUserButtonIsPresent()
				.verIncludeInactiveUsersChkBxIsPresent()
				.verIncludeInactiveUsersChkBxIsEnabled()
				.verIncludeInactiveUsersChkBxIsNotSelected()
				.clearUsernameInSearchInputField().clickSearchButton()
				.verUserCountIsIncremented(1, initalCount);

		initalCount = objUsersList1.getUserCount();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName3)
				.clickSearchButton()
				.clickEditForFirstUser()
				.enterFullName(objUserdata.strEditedFullName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName3)
				.clickSearchButton()
				.verUserDetails(objUserdata.strNewUserName3,
						objUserdata.strEditedFullName,
						objUserdata.strOrganization)
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton().verUserInList(objUserdata.strNewUserName)
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton().verUserInList(objUserdata.strNewUserName1)
				.verIncludeInactiveUsersChkBxIsPresent()
				.verIncludeInactiveUsersChkBxIsEnabled()
				.verIncludeInactiveUsersChkBxIsNotSelected()
				.clearUsernameInSearchInputField().clickSearchButton()
				.verUserCountIsIncremented(0, initalCount);

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.verUserInList(objUserdata.strNewUserName)
				.verUserDetails(objUserdata.strNewUserName,
						objUserdata.strFullName, objUserdata.strOrganization)
				.verNeverTextIsDisplayed(objUserdata.strNewUserName)
				.verEditLink(objUserdata.strNewUserName)
				.verPasswordLink(objUserdata.strNewUserName)
				.verRegionsLink(objUserdata.strNewUserName)
				.verSwitchLink(objUserdata.strNewUserName)
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.verUserInList(objUserdata.strNewUserName1)
				.verUserDetails(objUserdata.strNewUserName1,
						objUserdata.strFullName1, objUserdata.strOrganization)
				.verNeverTextIsDisplayed(objUserdata.strNewUserName1)
				.verEditLink(objUserdata.strNewUserName1)
				.verPasswordLink(objUserdata.strNewUserName1)
				.verRegionsLink(objUserdata.strNewUserName1)
				.verSwitchLink(objUserdata.strNewUserName1)
				.verUserNotInList(objUserdata.strNewUserName2)
				.verPhoneColIsNotPresent().verRolesColIsNotPresent()
				.verEmailColIsNotPresent().verSearchOptionIsPresent();

		objLinksAtTopRightCorners1.verPrintLink().verExportLink().verHelpLink();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
}
