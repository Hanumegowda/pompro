package requirementGroup.CreatingAndManagingUsers;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.SelectRegion;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEdgeCaseSwitchUser extends TestNG_UI_EXTENSIONS{

	public NewEdgeCaseSwitchUser() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/****************************************************************************************
	'Description : Verify that RegAdmin can switch to a user who has access to single region.
	'Date	 	 : 17-Feb-2016
	'Author		 : Anitha
	'----------------------------------------------------------------------------------------
	'Modified Date			                        	                   Modified By
	'Date					                                               Name
	*****************************************************************************************/
	@Test(description ="Verify that RegAdmin can switch to a user who has access to single region.")
	public void testEdgeCase88871() throws Exception {

		gstrTCID = "88871";
		gstrTO = "Verify that RegAdmin can switch to a user who has access to single region.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
			    .clickAdvancedOptionAndExpand()
		        .selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.verEditLink(objUserdata.strNewUserName)
				.verPasswordLink(objUserdata.strNewUserName)
				.verRegionsLink(objUserdata.strNewUserName)
				.clickOnSwitchLink(objUserdata.strNewUserName);
		
		objRegionDefault.verifyRegionDefaultPage();

		objNavigationToSubmenus.clickOnSetUp()
				.verifyOnlyUsersIsDispUnderSetup();

		objRegionDefault.verifyUserNameInFooter(objUserdata.strFullName);

		objLogin.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description : Verify that RegAdmin can switch to a user who has access to multiple regions.
	'Date	 	 : 17-Feb-2016
	'Author		 : Anitha
	'------------------------------------------------------------------------------------------
	'Modified Date			                        	                   Modified By
	'Date					                                               Name
	********************************************************************************************/
	@Test(description ="Verify that RegAdmin can switch to a user who has access to multiple regions.")
	public void testEdgeCase88872() throws Exception {

		gstrTCID = "88872";
		gstrTO = "Verify that RegAdmin can switch to a user who has access to multiple regions.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strRegionValue[] = new String[3];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page.getRegionValue(objLogindata.strRegionName);
		strRegionValue[1] = objRegions_page.getRegionValue(objLogindata.strRegionName1);	
		strRegionValue[2] = objRegions_page.getRegionValue(objLogindata.strRegionName2);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[0])
				.selectRegion(strRegionValue[1])
				.selectRegion(strRegionValue[2]).clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
		
		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName1);
		
		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();
		
		objLogin.clickLogOut();
			
		System.out.println("Precondition ends and test execution ");
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.verEditLink(objUserdata.strNewUserName)
				.verPasswordLink(objUserdata.strNewUserName)
				.verRegionsLink(objUserdata.strNewUserName)
				.clickOnSwitchLink(objUserdata.strNewUserName);

		objRegionDefault1.verifyRegionDefaultPage();

		objNavigationToSubmenus1.clickOnSetUp()
				.verifyOnlyUsersIsDispUnderSetup();

		objRegionDefault1.verifyUserNameInFooter(objUserdata.strFullName);
		
		//region 2
		
		objSelectRegionpage1.clickRegionLink().verInstructionInSelectRegPage();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objEventManagement1.clickOnEventLink();

		objEventManagement1.verifyEventManagementLinkIsDisplayed();

		objRegionDefault1.verifyUserNameInFooter(objUserdata.strFullName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
