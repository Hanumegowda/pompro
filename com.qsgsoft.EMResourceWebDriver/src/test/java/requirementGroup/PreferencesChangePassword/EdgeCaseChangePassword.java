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

public class EdgeCaseChangePassword extends TestNG_UI_EXTENSIONS {


public EdgeCaseChangePassword() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***********************************************************************************************
	 * 'Description : Verify that appropriate error message is displayed while resetting the password
	 *                 when the password entered in the fields does not match.
	 * 'Date		: 13-Nov-2014 
	 * 'Author 		: sangappa.k
	 ************************************************************************************************/

	@Test(description = "Verify that appropriate error message is displayed while resetting the password"
			+ " when the password entered in the fields does not match")
	public void testEdgeCase129625() throws Exception {

		gstrTCID = "129625";
		gstrTO = "Verify that appropriate error message is displayed while resetting the password"
				+ " when the password entered in the fields does not match)";

		// objects
		Login login_page1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		RegionDefault objRegionDefault_page2 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);
		
		Login login_page2 = new Login(this.driver1);
        ChangePassword objChangePassword_page2 = new ChangePassword(driver1);
        NavigationToSubMenus objNavigationToSubmenus2 = new NavigationToSubMenus(this.driver1);
        UsersList objUsersList_page1 = new UsersList(driver);

		// data
		Login_data login_data = new Login_data();
		User_data objUserdata_page1 = new User_data();

		login_page1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page1
				.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault_page1.selectFrame();

		// create new user

		objUsersList_page1
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata_page1.strNewUserName2,
						objUserdata_page1.strNewPassword,
						objUserdata_page1.strFullName).selectSecRole()

				.clickSaveButton();
		
		System.out.println(objUserdata_page1.strNewUserName2);
		System.out.println(objUserdata_page1.strNewPassword);

		login_page1.clickLogOut();

		login_page2.loginToApplicationNew(objUserdata_page1.strNewUserName2,
				objUserdata_page1.strUserPwd);

		 login_page2 .verifySetUpYourPasswordPage().verifyNewPasswordField()
				.verifyVerifyPasswordField()
				.enterNewPassword(objUserdata_page1.strNewPassword1)
				.enterConfirmPassword(objUserdata_page1.strNewPassword)
				.clickSubmit().verifyDonotMatchPasswordMsg()
				.enterNewPassword(objUserdata_page1.strNewPassword)
				.enterConfirmPassword(objUserdata_page1.strNewPassword)
				.clickSubmit();

		// navigate to prefernces

		objRegionDefault_page2.selectFrame();

		objNavigationToSubmenus2.navigateToChangePasswordInPreferences();

		objChangePassword_page2.verChangePasswordScreenIsDisplayed()
				.switchTochangePwdFrame().verChangePwdWindow()
				.enterNewPassword(objUserdata_page1.strNewPassword1)
				.enterConfirmPassword(objUserdata_page1.strNewPassword)
				.clickOnSubmit().verifyDonotMatchPasswordMsgInPopUp()
				.enterNewPassword(objUserdata_page1.strNewPassword)
				.enterConfirmPassword(objUserdata_page1.strNewPassword)
				.clickOnSubmit().verPasswordStatusScreenIsDisplayed()
				.clickOnClose();
		login_page2.clickLogOut();
		
		gstrResult = "PASS";
	}
}
