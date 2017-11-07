package requirementGroup.PreferencesUserInfo;

import lib.dataObject.Login_data;
import lib.dataObject.UpdateStatus_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.UpdateUserInfo;
import lib.page.UsersList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EditUserInformation extends TestNG_UI_EXTENSIONS {

	public EditUserInformation() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/**********************************************************************************************
	 * 'Description : Verify that user can edit user info from Preferences.
	 * 'Date        : 24-Jun-2015
	 * 'Author      : Sangappa.k
	 **********************************************************************************************/

	@Test(description = "Verify that user can edit user info from Preferences.")
	public void testHappyDay84526() throws Exception {
		
		gstrTCID = "84526";
		gstrTO = "Verify that user can edit user info from Preferences.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		UpdateUserInfo objUpdateUserInfo1 = new UpdateUserInfo(driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);
		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.clickSaveButton();

		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		objNavigationToSubMenus1.navigateToUsersInfoInPreferences();

		// User creation
		UsersList_page1.enterFullName(objUser_data.strEditedFullName)
				.enterFirstName(objUser_data.strEditedFirstName)
				.enterLastName(objUser_data.strEditedLastName)
				.enterMiddleName(objUser_data.strEditedMiddleName)
				.enterOrganization(objUser_data.strEditedOrganization)
				.enterPhone(objUser_data.strEditedPhone1)
				.enterPrimaryEmailId(objUser_data.strEmail)
				.entertextPagerId(objUser_data.strEmail)
				.enterEmail(objUser_data.strEmail).clickSaveButton()
				.veruserFullNameAtFooterOfApp(objUser_data.strEditedFullName);

		objUpdateUserInfo1.verPreferencesMenuPageIsDisplayed();
		objNavigationToSubMenus1.navigateToUsersInfoInPreferences();
		objUpdateUserInfo1.verifyUserDetailsAreRetrieved(
				objUser_data.strEditedFullName,
				objUser_data.strEditedFirstName,
				objUser_data.strEditedMiddleName,
				objUser_data.strEditedLastName,
				objUser_data.strEditedOrganization,
				objUser_data.strEditedPhone1, objUser_data.strEmail,
				objUser_data.strEmail, objUser_data.strEmail)
				.clickOnSaveButton();
		login_page1.clickLogOut();

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame();

		// User creation
		UsersList_page1.navigateToUsers()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName);

		objUpdateUserInfo1.verifyUserDetailsAreRetrieved(
				objUser_data.strEditedFullName,
				objUser_data.strEditedFirstName,
				objUser_data.strEditedMiddleName,
				objUser_data.strEditedLastName,
				objUser_data.strEditedOrganization,
				objUser_data.strEditedPhone1, objUser_data.strEmail,
				objUser_data.strEmail, objUser_data.strEmail)
				.clickOnSaveButton();
		login_page1.clickLogOut();
		gstrResult = "PASS";

	}

}


