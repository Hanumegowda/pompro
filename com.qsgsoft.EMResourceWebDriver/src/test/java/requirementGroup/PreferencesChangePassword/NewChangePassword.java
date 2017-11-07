package requirementGroup.PreferencesChangePassword;

import lib.dataObject.Login_data;
	import lib.dataObject.User_data;
	import lib.module.NavigationToSubMenus;
	import lib.page.ChangePassword;
	import lib.page.Login;
	import lib.page.RegionDefault;
	import lib.page.SelectRegion;
	import lib.page.UsersList;
	
	import org.testng.annotations.Test;
	
	import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;
	
	public class NewChangePassword extends TestNG_UI_EXTENSIONS {
	
	public NewChangePassword() throws Exception {
			super();
			// TODO Auto-generated constructor stub
		}

	/******************************************************************
	'Description : Verify that user can change password from Preferences. 
	'Precondition:
	'Date	 	 : 24-June-2015
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that user can change password from Preferences.")
	public void testHappyDay84154() throws Exception {
	
		gstrTCID = "84154";
		gstrTO = "Verify that user can change password from Preferences.";
	
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
	
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
	
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ChangePassword objChangePassword1 = new ChangePassword(this.driver1);
	
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
	
		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);
	
		objRegionDefault.selectFrame();
		
		objNavigationToSubMenus.navigateToUsers();
		
		objUsersList.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.selectFirstRole()
		.clickSaveButton();
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToChangePasswordInPreferences();
		
		objChangePassword1.verChangePasswordScreenIsDisplayed()
					      .verChangePwdScreenWithClickHere()
					      .switchTochangePwdFrame()
					      .verChangePwdWindow()
					      .enterCurrentPassword(objUserdata.strNewPassword)
					      .changePassword(objUserdata.strNewPassword1, objUserdata.strNewPassword1)
					      .verPasswordStatusScreenIsDisplayedNew()
					      .clickOnClose();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplicationNew(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objLogin1.verifyInvalidUsernameAndPwdError()
		 		 .loginToApplication(objUserdata.strNewUserName, objUserdata.strNewPassword1);
		
		objRegionDefault1.selectFrame();
		
		objRegionDefault1.verifyRegionDefaultPage();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
