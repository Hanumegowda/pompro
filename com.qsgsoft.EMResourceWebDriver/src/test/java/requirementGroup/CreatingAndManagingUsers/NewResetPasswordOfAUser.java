package requirementGroup.CreatingAndManagingUsers;

import static org.testng.AssertJUnit.assertTrue;
import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.page.ChangePassword;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewResetPasswordOfAUser extends TestNG_UI_EXTENSIONS {

	public NewResetPasswordOfAUser() throws Exception {
		super();
	}

	/********************************************************************************************************************
	 * 'Description : Verify that user whose password is changed by another user in a region is notified via primary email 
	 * 'Date        : 26/08/2015
	 * 'Author      : Sowmya
	 ********************************************************************************************************************/

	@Test(description = " Verify that user whose password is changed by another user in a region is notified via primary email")
	public void testHappyDay127845() throws Exception {

		gstrTCID = "127845";
		gstrTO = " Verify that user whose password is changed by another user in a region is notified via primary email";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login objlogin_page = new Login(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);

		Login objlogin_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		ChangePassword objChangePassword1 = new ChangePassword(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		UsersList objUsersList_page1 = new UsersList(this.driver1);

		objlogin_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion_page
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault_page.selectFrame();

		// User creation
		objUsersList_page.navigateToUsers();

		objUsersList_page
				.clickCreateNewUserButton()

				.enterAllUserDetails(objUser_data.strNewUserName,
						objUser_data.strUserPwd, objUser_data.strFullName, "",
						"", "", "", "", objUser_data.strEmail, "", "")

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objUsersList_page
				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.clickAdvancedOptionAndExpand()

				.selectConfigureRegionalUserAccessOption()

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		objlogin_page.clickLogOut();

		System.out
				.println("-----------------Test execution starts---------------");

		objlogin_page1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame().verifyRegionDefaultPage();

		objUsersList_page1
				.navigateToUsers()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.clickOnPasswordLink(objUser_data.strNewUserName);

		objChangePassword1
				.switchTochangePwdFrame()
				.verChangePwdWindow()
				.changePassword(objUser_data.strNewPassword1,
						objUser_data.strNewPassword1)
				.verPasswordStatusScreenIsDisplayedNew().clickOnClose();

		objMailVerificationFunctions.loginToMail(objUser_data.strEmail,
				objUser_data.strPrimaryPwsd);

		String strSubject = "Your password has changed";

		String strMsgBody1 = "Username: " + objUser_data.strNewUserName;

		System.out.println(strSubject);

		objMailVerificationFunctions.NavToInboxNew(strSubject);

		boolean blnMsg1 = false;

		objMailVerificationFunctions
				.verEmailNew(objUser_data.strEmail, strSubject);

		for (int intCount = 0; intCount < 1; intCount++) {

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}

	/************************************************************************************************
	 * 'Description : Verify that user receives a notification when the user's password is changed 
	 * 'Date        : 27/08/2015 
	 * 'Author      : Sowmya
	 ************************************************************************************************/

	@Test(description = "Verify that user receives a notification when the user's password is changed")
	public void testHappyDay127839() throws Exception {

		gstrTCID = "127839";
		gstrTO = "Verify that user receives a notification when the user's password is changed";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login objlogin_page = new Login(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);

		Login objlogin_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		ChangePassword objChangePassword1 = new ChangePassword(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		UsersList objUsersList_page1 = new UsersList(this.driver1);

		objlogin_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion_page
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault_page.selectFrame();

		// User creation
		objUsersList_page.navigateToUsers();

		objUsersList_page
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUser_data.strNewUserName,
						objUser_data.strUserPwd, objUser_data.strFullName, "",
						"", "", "", "", objUser_data.strEmail, "", "")
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objlogin_page.clickLogOut();

		System.out
				.println("-----------------Test execution starts---------------");

		objlogin_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame().verifyRegionDefaultPage();

		objUsersList_page1.navigateToUsers();

		objUsersList_page1
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUser_data.strNewUserName1,
						objUser_data.strUserPwd, objUser_data.strFullName, "",
						"", "", "", "", objUser_data.strEmail, "", "")
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.clickOnPasswordLink(objUser_data.strNewUserName);

		objChangePassword1
				.switchTochangePwdFrame()
				.verChangePwdWindow()
				.changePassword(objUser_data.strNewPassword1,
						objUser_data.strNewPassword1)
				.verQuestionAndEnterAnswerInSecurityQuesPage()
				.clickOnClose();
		
		objlogin_page1.clickLogOut();
		
		
		objlogin_page1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame().verifyRegionDefaultPage();
		
		objlogin_page1.clickLogOut();

		objMailVerificationFunctions.loginToMail(objUser_data.strEmail,
				objUser_data.strPrimaryPwsd);

		String strSubject = "Your password has changed";

		String strMsgBody1 = "Username: " + objUser_data.strNewUserName;
		
		String strMsgBody2 = "Username: " + objUser_data.strNewUserName1;

		System.out.println(strSubject);

		objMailVerificationFunctions.NavToInboxNew(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmailNew(objUser_data.strEmail,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}
			
			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			objMailVerificationFunctions.backToMailInbox();

		}

		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
}