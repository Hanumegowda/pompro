package requirementGroup.ViewingAndmanagingEMResourceEntitiesOnTheViewInterface;

import lib.dataObject.Login_data;
import lib.dataObject.Resource_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEMResourceIntegrationWithWebEOC  extends TestNG_UI_EXTENSIONS {

	public NewEMResourceIntegrationWithWebEOC() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*******************************************************************************************
	'Description : Verify that user will be redirected to View resource detail when clicked on the link from WebEOC application
	'Precondition:
	'Date	 	 : 26-Oct-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user will be redirected to View resource detail when clicked on the link from WebEOC application")
	public void testHappyDay131088() throws Exception {
		gstrTCID = "131088";
		gstrTO = "Verify that user will be redirected to View resource detail when clicked on the link from WebEOC application";

		Login_data objTest_data = new Login_data();
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		User_data objUser_data = new User_data();
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		Views objViews1 = new Views(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName5);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strColoradoResource2)
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUserToWebeoc(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		objViews1.verViewResourceDetailsPgeIsDisplayed();

		String[] strResource = objResource_data.strColoradoResource2.split("  ");
		
		String strResNameInViewDetailScreen = strResource[0]+" "+strResource[1];
		
		objViews1
				.verResourceScreenDisplayed(strResNameInViewDetailScreen);

		objViews1.verStatusTypes(objResource_data.strStatusTypesOfLutheran);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description : Verify that warning message will be displayed when an attempt is made to login to EMR providing user credentials in any other region
	'Precondition:
	'Date	 	 : 27-Oct-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that warning message will be displayed when an attempt is made to login to EMR providing user credentials in any other region")
	public void testHappyDay131089() throws Exception {
	
		gstrTCID = "131089";
		gstrTO = "Verify that warning message will be displayed when an attempt is made to login to EMR providing user credentials in any other region";

		Login_data objTest_data = new Login_data();
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		User_data objUser_data = new User_data();

		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickSaveButton();
		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUserToWebeoc(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();

		objViewsList1.verEMRWarningMsg();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
