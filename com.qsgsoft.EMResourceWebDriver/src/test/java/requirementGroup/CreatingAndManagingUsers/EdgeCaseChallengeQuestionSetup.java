package requirementGroup.CreatingAndManagingUsers;

import java.util.concurrent.TimeUnit;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SecurityQuestion;
import lib.page.SelectRegion;
import lib.page.UpdateUserInfo;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseChallengeQuestionSetup extends TestNG_UI_EXTENSIONS{

	public EdgeCaseChallengeQuestionSetup() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**********************************************************************************************
	 * 'Description : Verify that user is not prompted to set challenge question once user clicks on 'Cancel' in the prompt.
	 * 'Date        :17-Apr-2015
	 * 'Author      :Anitha
	 **********************************************************************************************/

	@Test(description = " Verify that user is not prompted to set challenge question once user clicks on 'Cancel' in the prompt.")
	public void testEdgeCase155945() throws Exception {
		
		gstrTCID = "155945";
		gstrTO = " Verify that user is not prompted to set challenge question once user clicks on 'Cancel' in the prompt.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName2);

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

		System.out.println("-----------------Test execution starts---------------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame()
		
		.verifyRegionDefaultPage();
		
		login_page1.clickLogOut()
		
		.loginSecondTimeAndCancel(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame()
		
		.verifyRegionDefaultPage();
		
		objEventManagement1.navigateToEventList();
		
		login_page1.verSecurityQuestionWindowIsNotDisplayed()
		
		.clickLogOut();
		
		gstrResult = "PASS";
	}

	/**********************************************************************************************
	 * 'Description : Verify that appropriate validation message is displayed when user is idle for
	 * 				  more than 5min on 'Challenge SetUp' screen and attempts to submit the page.
	 * 'Date        : 27-Apr-2015
	 * 'Author      : Pallavi
	 **********************************************************************************************/

	@Test(description = "Verify that appropriate validation message is displayed when user is idle for more than 5min on "
			+ "'Challenge SetUp' screen and attempts to submit the page.")
	public void testEdgeCase158011() throws Exception {
		
		gstrTCID = "158011";
		gstrTO = "Verify that appropriate validation message is displayed when user is idle for more than 5min on "
					+ "'Challenge SetUp' screen and attempts to submit the page.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		SecurityQuestion objSecurityQuestion = new SecurityQuestion(this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName2);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName,
						objUser_data.strFirstName, objUser_data.strMiddleName,
						objUser_data.strLastName, objUser_data.strOrganization,
						objUser_data.strPhone, objUser_data.strPrimaryMailId,
						objUser_data.strPrimaryMailId,
						objUser_data.strPrimaryMailId)
				.clickSaveButton();

		login_page.clickLogOut();

		System.out.println("-------Test execution starts---------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
							objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame()
						   .verifyRegionDefaultPage();
		
		objNavigationToSubMenus.navigateToSecurityQuestionsInPreferences();

		RegionDefault_page1.verWebNotificationframe();

		objSecurityQuestion.verifySecurityQuestionAndAnswerHeading()
						   .selectSecurityQuestion(objTest_data.strQuestionLast4DigitsOfDL)
						   .enterSecurityAnswer(objTest_data.strAnswerLast4DigitsOfDL)
						   .verifyEmailAddress(objUser_data.strPrimaryMailId);

		//Wait for 5 Minutes
		System.out.println("5 minutes waiting");
		TimeUnit.MINUTES.sleep(5);
		System.out.println("wait ended");
		
		objSecurityQuestion.clickOnSave()
						   .verifyValidationMsgWhenScreenIsIdleFor5Mins();
		
		RegionDefault_page1.switchToDefaultFrame()
						   .selectFrame();

		objSecurityQuestion.clickOnClose();

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}

	/**********************************************************************************************
	 * 'Description : Verify that appropriate validation message is displayed when user is idle for
	 * 				  more than 5min on 'Challenge SetUp' screen and attempts to submit the page.
	 * 'Date        : 28-Apr-2015
	 * 'Author      : Pallavi
	 **********************************************************************************************/

	@Test(description = "Verify that edit password challenge page is renamed to 'Security Question and Answer'.")
	public void testEdgeCase157809() throws Exception {
		
		gstrTCID = "157809";
		gstrTO = "Verify that edit password challenge page is renamed to 'Security Question and Answer'.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		SecurityQuestion objSecurityQuestion = new SecurityQuestion(this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// User creation
		objUsersList.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.clickSaveButton();

		login_page.clickLogOut();

		System.out.println("-----------------Test execution starts---------------");

		login_page1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objSecurityQuestion.verifySecurityQuestionPageNotDisplayed();

		RegionDefault_page1.selectFrame()
						   .switchToDefaultFrame()
						   .selectFrame()
						   .verifyRegionDefaultPage();
		
		objNavigationToSubMenus.navigateToSecurityQuestionsInPreferences();

		RegionDefault_page1.verWebNotificationframe();

		objSecurityQuestion.verifySecurityQuestionAndAnswerHeading()
						   .clickOnCancel();

		RegionDefault_page1.switchToDefaultFrame().selectFrame();

		login_page1.clickLogOut()
				   .launchEMRurl()
				   .enterUserName(objUserdata.strNewUserName)
				   .enterPassword(objUserdata.strNewPassword)
				   .clickLogin();
		
		objSecurityQuestion.verifySecurityQuestionAndAnswerHeading()
						   .selectSecurityQuestion(objTest_data.strQuestionLast4DigitsOfDL)
						   .enterSecurityAnswer(objTest_data.strAnswerLast4DigitsOfDL)
						   .verifyEmailAddress(objUserdata.strPrimaryMailId)
						   .clickOnSave();

		RegionDefault_page1.selectFrame()
						   .switchToDefaultFrame()
						   .selectFrame()
						   .verifyRegionDefaultPage();

		objNavigationToSubMenus.navigateToSecurityQuestionsInPreferences();

		RegionDefault_page1.verWebNotificationframe();
		
		objSecurityQuestion.verifySecurityQuestionAndAnswerHeading()
						   .verifySecurityQuestion(objTest_data.strQuestionLast4DigitsOfDL)
						   .verifySecurityAnswer(objTest_data.strAnswerLast4DigitsOfDL)
						   .verifyEmailAddress(objUserdata.strPrimaryMailId);

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that users without e-mail address are prompted to provide e-mail address 
                     on setup challenge question upon login.    
    'Precondition  :
    'Peer Reviewed : Anil
    'Date          : 27-Apr-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that users without e-mail address are prompted to provide e-mail address"
			+ " on setup challenge question upon login.")
	public void testEdgeCase155854() throws Exception {

		gstrTCID = "155854";
		gstrTO = "Verify that users without e-mail address are prompted to provide e-mail address on setup"
				+ " challenge question upon login.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		SecurityQuestion objSecurityQuestion = new SecurityQuestion(
				this.driver1);
		UpdateUserInfo objUpdateUserInfo1 = new UpdateUserInfo(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut();

		objLogin1.loginToApplicationNew(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		objSecurityQuestion.verifySecurityQuestionAndAnswerHeading();
		objSecurityQuestion.verEmailAddressTextFiledIsEmpty()
				.enterSecurityAnswer(objTest_data.strAnswerLast4DigitsOfDL)
				.enterEmailAddress(objUserdata.strPrimaryMailId).clickOnSave();
		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.navigateToUsersInfoInPreferences();
		objUpdateUserInfo1
				.verPrimaryMailAddressIsDisplayed(objUserdata.strPrimaryMailId);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
    'Description   : Verify that 'Challenge Setup' is renamed as 'Security Question' under 'Preferences'.    
    'Precondition  :
    'Peer Reviewed : Anil
    'Date          : 28-Apr-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that 'Challenge Setup' is renamed as 'Security Question' under 'Preferences'")
	public void testEdgeCase157569() throws Exception {

		gstrTCID = "157569";
		gstrTO = "Verify that 'Challenge Setup' is renamed as 'Security Question' under 'Preferences'";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		SecurityQuestion objSecurityQuestion = new SecurityQuestion(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.clickOnPreferences();
		objSecurityQuestion
				.verSecurityQuestionLinkIsDisplayedUnderPreferences();
		Thread.sleep(10000);
		objSecurityQuestion
				.verChallengeSetupLinkIsNotDisplayedUnderPreferences();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
