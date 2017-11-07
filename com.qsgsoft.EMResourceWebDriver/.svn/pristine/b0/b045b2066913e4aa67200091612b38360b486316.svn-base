package requirementGroup.SetUp;

import lib.dataObject.Login_data;
import lib.dataObject.Roles_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseCreateAndManageRoles extends  TestNG_UI_EXTENSIONS{

	public EdgeCaseCreateAndManageRoles() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/******************************************************************************************
	 * 'Description :Verify that all the users without role are retrieved when searched providing 'No Role'
	                  criteria by admin user. 
	 * 'Date        : 11-Dec-2014 
	 * 'Author      : sangappa.k
	 ******************************************************************************************/

	@Test(description = "Verify that all the users without role are retrieved when searched providing "
			+ "'No Role' criteria by admin user. ")
	public void testEdgeCase150854() throws Exception {
		
		gstrTCID = "108092";
		gstrTO = "Reactivate a Resource Type and verify that it is displayed on following screens: "+
    " a. Create/Edit view."+
     " b. Create/Edit event template."+
     " c. Resource Type drop down while searching user/resource.";

		// Objects for data
		
		User_data objUser_data = new User_data();
		Login_data objLogindata = new Login_data();
		
		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(driver1);
		
		String strRegionValue[] = new String[1];
		
		login_page.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
	
		SelectRegion_page.selectRegionAndNavigate(objLogindata.strRegionName);

		RegionDefault_page.selectFrame();

		System.out.println(objUser_data.strNewUserName);

		NavigationToSubMenus_page.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);
	
		NavigationToSubMenus_page.navigateToUsers();
		
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterOrganization(objUser_data.strOrganization)			
				.selectFirstRole()		
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)	
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[0])
				.clickSaveButton();
		System.out.println(objUser_data.strNewUserName);

		// create User2

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterOrganization(objUser_data.strOrganization)		
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName1);

		UsersList_page.verifyUserListPageIsDisplayed();
		
			UsersList_page
			.selectRoleOptionInUsersList(objUser_data.strNoRole);
			Thread.sleep(2000);
		UsersList_page.selectSearchOptionInUsersList(objUser_data.strsearchOption)
			.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
			.clickSearchButton()		
         .verUserDetails(objUser_data.strNewUserName1,
						objUser_data.strFullName, objUser_data.strOrganization);
		
		
	SelectRegion_page.selectRegionAndNavigate(objLogindata.strRegionName1);
	
	           RegionDefault_page.selectFrame();
		
			NavigationToSubMenus_page.navigateToUsers();
			
			UsersList_page
			.selectRoleOptionInUsersList(objUser_data.strNoRole);
			Thread.sleep(2000);
			UsersList_page.selectSearchOptionInUsersList(objUser_data.strsearchOption)
			.enterUsernameInSearchInputField(objUser_data.strNewUserName)
			.clickSearchButton()
			.verUserNotInList(objUser_data.strNewUserName);		
          login_page.clickLogOut();
					
		gstrResult = "PASS";

	}
	
	/******************************************************************************************
	 * 'Description :Verify that all the users without role are retrieved when searched providing 
	 *               'No Role' criteria by user with 'Configure Regional User Access' right.
	 * 'Date        : 11-Dec-2014 
	 * 'Author      : sangappa.k
	 ******************************************************************************************/

	@Test(description = "Verify that all the users without role are retrieved when searched providing"
			+ " 'No Role' criteria by user with 'Configure Regional User Access' right. ")

	public void testEdgeCase150855() throws Exception {
		gstrTCID = "150855";
		gstrTO ="Verify that all the users without role are retrieved when searched providing 'No Role'"
				+ " criteria by user with 'Configure Regional User Access' right.";

		// Objects for data
		
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		
		// Objects for Page
		Login login_page = new Login(this.driver1);
		Login login_page2 = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		SelectRegion SelectRegion_page2 = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		RegionDefault RegionDefault_page2 = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		UsersList UsersList_page2 = new UsersList(this.driver1);

		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page2 = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(driver);
		
		//login to Application

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		NavigationToSubMenus_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		// create User1
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
                .clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		// create User2 
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		NavigationToSubMenus_page.navigateToRegions();
		String regValueForUserB = objRegions_page
				.getRegionValue(objTest_data.strRegionName1);

		NavigationToSubMenus_page.navigateToUsers();
		
		UsersList_page.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
		               .clickSearchButton()
                      .clickRegionsLinkForUser(objUser_data.strNewUserName1)
                     .selectRegion(regValueForUserB)
                    .clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		// create User3
		UsersList_page
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName2,
				objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()		
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton();
	System.out.println(objUser_data.strNewUserName2);			
		
		login_page2.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);

		RegionDefault_page2.selectFrame();

		UsersList_page2.navigateToUsers();
		
		UsersList_page2.enterUsernameInSearchInputField(objUser_data.strNewUserName)
                        .clickSearchButton();
		
		UsersList_page2.verUserInList(objUser_data.strNewUserName);
		
		UsersList_page2.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
                       .clickSearchButton();
		
		UsersList_page2.verUserInList(objUser_data.strNewUserName1);
		
		UsersList_page2.enterUsernameInSearchInputField(objUser_data.strNewUserName2)
                            .clickSearchButton();

        UsersList_page2.verUserInList(objUser_data.strNewUserName2);
		
		UsersList_page2.selectRoleOptionInUsersList(objUser_data.strNoRole)

		.clickSearchButton()

		.verUserInList(objUser_data.strNewUserName)

		.verUserNotInList(objUser_data.strNewUserName1);

		login_page2.clickLogOut();

		login_page2.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page2.selectFrame();
		
		SelectRegion_page2.selectRegionAndNavigate(objTest_data.strRegionName1);

		RegionDefault_page2.selectFrame();

		NavigationToSubMenus_page2.navigateToUsers();

		UsersList_page2.selectRoleOptionInUsersList(objUser_data.strNoRole)

		.clickSearchButton()

		.verUserInList(objUser_data.strNewUserName1);

		login_page2.clickLogOut();
		
		gstrResult = "PASS";
	}
}
