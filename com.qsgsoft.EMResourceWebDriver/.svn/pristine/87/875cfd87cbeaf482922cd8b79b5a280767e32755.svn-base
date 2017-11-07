package requirementGroup.CreatingAndManagingUsers;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewRemoveAUserFromARegion extends TestNG_UI_EXTENSIONS{

	public NewRemoveAUserFromARegion() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that RegAdmin can remove access from regions for a user who currently have access to multiple regions. 
	'Precondition:
	'Date	 	 : 30-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that RegAdmin can remove access from regions for a user who currently have access to multiple regions.")
	public void testHappyDay32727() throws Exception {

		gstrTCID = "32727";
		gstrTO = "Verify that RegAdmin can remove access from regions for a user who currently have access to multiple regions.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		String strRegionValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1.enterUsernameInSearchInputField(objUserdata.strNewUserName)
		.clickSearchButton()
		.clickRegionsLinkForUser(objUserdata.strNewUserName)
		.deselectRegion(strRegionValue[1])
		.clickSaveButton()
		.verifyUserListPageIsDisplayed()
		.clickRegionsLinkForUser(objUserdata.strNewUserName)
		.verEditUserRegionPageisDisplayed()
		.verRegionsCheckBoxIsSelectd(strRegionValue[0])
		.verRegionsCheckBoxIsNotSelectd(strRegionValue[1]);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame()
		.verRegionName(objLogindata.strRegionName, objLogindata.strDomainName);
		
		objLogin1.clickLogOut();
		
		String[] strTestData = { Login_data.strBuildName, gstrTCID,
				objUserdata.strNewUserName + "/" + objUserdata.strNewPassword,
				"", "", "Verify select region not displayed on main menu", "",
				"", "", "" };

		objOffCommonFunc.writeResultData(strTestData,
				strPartialAutoResultsPath, "Events");
		
		gstrResult = "PASS";
	}
}
