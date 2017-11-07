package requirementGroup.CreatingAndManagingRoles;

import lib.dataObject.Login_data;
import lib.dataObject.Roles_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseAssigningUserToARole extends TestNG_UI_EXTENSIONS{
	
	public EdgeCaseAssigningUserToARole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*****************************************************************************************************
	'Description : Verify that changes made for user's roles are reflected on 'Assign Users roles' screen.
	'Date	 	 : 12-Jan-2016
	'Author		 : Anitha
	'-----------------------------------------------------------------------------------------------------
	'Modified Date			                        	                    Modified By
	'Date					                                                Name
	******************************************************************************************************/
	@Test(description = "Verify that changes made for user's roles are reflected on 'Assign Users roles' screen.")
	public void testEdgeCase127977() throws Exception {
		
		gstrTCID = "127977";
		gstrTO = "Verify that changes made for user's roles are reflected on 'Assign Users roles' screen.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRolesData = new Roles_data();

		Login objLogin1 = new Login(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventManagement EventManagement1=new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strRoleValue[] = new String[2];

		System.out.println("-----Precondtion execution starts------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);

		objUsersList1.selectMaintainEventsOption();

		objRoles1.clickOnSaveBtn();

		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		objRoles1.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName1);

		objUsersList1.selectViewcustomViewOption();

		objRoles1.clickOnSaveBtn();

		strRoleValue[1] = objRoles1.getRoleValue(objRolesData.strRoleName1);

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0]).clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnUsersLinkOfRole(objRolesData.strRoleName)
				.verifyUserAssignToRole(objUserdata.strNewUserName);

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.deselectRoleCheckBox(strRoleValue[0])
				.selectRoleCheckBox(strRoleValue[1]).clickSaveButton();

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnUsersLinkOfRole(objRolesData.strRoleName)
				.verifyUserNotAssignToRole(objUserdata.strNewUserName);
		
		objNavigationToSubmenus1.navigateToRoles();
		
		objRoles1.clickOnUsersLinkOfRole(objRolesData.strRoleName1)
				.verifyUserAssignToRole(objUserdata.strNewUserName);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();

		EventManagement1.verifyEventManagementLinkIsNotDisplayed();
		
		objNavigationToSubmenus1.clickOnViewMenu().verCustomIsDisplayed();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
