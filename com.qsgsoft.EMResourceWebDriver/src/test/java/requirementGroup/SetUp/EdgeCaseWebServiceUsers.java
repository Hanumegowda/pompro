package requirementGroup.SetUp;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseWebServiceUsers extends TestNG_UI_EXTENSIONS{

	public EdgeCaseWebServiceUsers() throws Exception 
	{
		super();
	}
		// TODO Auto-generated constructor stub
		/****************************************************************************************************************
		'Description : Verify that a warning message is displayed when a web service user logs into the application
		'Date	 	 : 1-Feb-2016
		'Author		 : Sangappa K
		'----------------------------------------------------------------------------------------------------------------
		'Modified Date			                                                            	Modified By
		'Date					                                                                Name
		*****************************************************************************************************************/
		@Test(description =" Verify that a warning message is displayed when a web service user logs into the application")
		public void testEdgeCase164556() throws Exception {

			gstrTCID ="164556";
			gstrTO = " Verify that a warning message is displayed when a web service user logs into the application";
			Login_data objLogin_data = new Login_data();
			User_data objUserdata = new User_data();

			Login objLogin = new Login(this.driver1);
			UsersList objUsersList = new UsersList(driver);
			SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
			RegionDefault objRegionDefault = new RegionDefault(this.driver1);
			NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
					this.driver1);
			
			Login objLogin1 = new Login(this.driver1);
			
			objLogin.loginToApplication(objLogin_data.strEicsAdminUser,
					objLogin_data.strEicsAdminPwd);
			
			objSelectRegionpage.selectRegionAndNavigate(objLogin_data.strRegionName);
			
	        objRegionDefault.selectFrame();
	        
	        objNavigationToSubmenus.navigateToUsers();

		    objUsersList.clickCreateNewUserButton()
					.enterUsername(objUserdata.strNewUserName)	
					.enterPassword(objUserdata.strNewPassword)
					.enterConfirmPassword(objUserdata.strNewPassword)
					.enterFullName(objUserdata.strFullName)
					.enterOrganization(objUserdata.strOrganization)
					.enterPhone(objUserdata.strPhone)
					.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
					.selectWebServiceChkBox()
					.deselectAllViewResReightOption()
					.clickSaveButton();

		    System.out.println(objUserdata.strNewUserName);
			objLogin.clickLogOut();
			
			objLogin1.loginToApplication(objUserdata.strNewUserName, objUserdata.strNewPassword);
			
			objLogin1.verWebServiceAccountWarning();
			
			gstrResult = "PASS";
	}
	
		/****************************************************************************************************************
		'Description : Verify that user can proceed to application even though he receives web service account warning
		'Date	 	 :1-Feb-2016
		'Author		 : Sangappa K
		'----------------------------------------------------------------------------------------------------------------
		'Modified Date			                                                            	Modified By
		'Date					                                                                Name
		*****************************************************************************************************************/
	@Test(description = "Verify that user can proceed to application even though he receives web service account warning")
	public void testEdgeCase164557() throws Exception {

		gstrTCID = "164557";
		gstrTO = " Verify that user can proceed to application even though he receives web service account warning";
		Login_data objLogin_data = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(driver);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		/*objLogin.loginToApplication(objLogin_data.strEicsAdminUser,
				objLogin_data.strEicsAdminPwd);*/
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		
		objSelectRegionpage.selectRegionAndNavigate(objLogin_data.strRegionName);
		
		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList.clickCreateNewUserButton()
					.enterUsername(objUserdata.strNewUserName)
					.enterPassword(objUserdata.strNewPassword)
					.enterConfirmPassword(objUserdata.strNewPassword)
					.enterFullName(objUserdata.strFullName)
					.enterOrganization(objUserdata.strOrganization)
					.enterPhone(objUserdata.strPhone)
					.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
					.selectWebServiceChkBox().deselectAllViewResReightOption()
					.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objLogin1.verWebServiceAccountWarning()
				 .verWebServiceUserProceedToAppln()
				 .verifyLoginPage();//now login page is displayed instead of region default page web service user

		gstrResult = "PASS";
	}	
}

