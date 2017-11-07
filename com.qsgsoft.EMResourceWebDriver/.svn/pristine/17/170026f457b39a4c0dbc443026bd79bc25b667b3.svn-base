package requirementGroup.CreatingAndManagingUsers;

import lib.dataObject.Login_data;
import lib.dataObject.Roles_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewForEMR315 extends TestNG_UI_EXTENSIONS{

	
	public NewForEMR315() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/****************************************************************************************************************
	'Description : Edit a user to deselect the role R1 which was created selecting the right 'Form - User may create and modify forms' and verify that user cannot configure forms.
	'Date	 	 : 23-Mar-2015
	'Author		 : Anil
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                            	Modified By
	'Date					                                                                Name
	*****************************************************************************************************************/
	@Test(description = "Edit a user to deselect the role R1 which was created selecting the right 'Form - User may create and modify forms' and verify that user cannot configure forms.")
	public void testHappyDay21520() throws Exception {

		gstrTCID = "21520";
		gstrTO = "Edit a user to deselect the role R1 which was created selecting the right 'Form - User may create and modify forms' and verify that user cannot configure forms.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();


		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);

		UsersList objUsersList = new UsersList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);



		String strRoleValue[] = new String[1];


		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();


		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
		         .enterRoleName(objRolesData.strRoleName);
		
		objUsersList.selectFormUserMayActivateAndModifyFormsOption();
		
		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)		
				.selectRoleCheckBox(strRoleValue)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objUsersList1
				.navigateToUsers()
				
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
						
				.editUserDetails(objUser_data.strNewUserName)
		             
		        .deselectRoleCheckBox(strRoleValue)
		             
		             .clickSaveButton();
		
		objLogin1.clickLogOut();
		//New user login
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToFormMenu();
		
		objNavigationToSubMenus1.verifyConfigureFormIsNotDisplayed();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
		}
}
