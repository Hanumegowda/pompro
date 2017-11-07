package requirementGroup.CreatingAndManagingUsers;

import static org.testng.AssertJUnit.assertTrue;

import java.util.Iterator;
import java.util.Set;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.ChangePassword;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewForgotUserIDOrPasswordFunctionality extends TestNG_UI_EXTENSIONS{

	public NewForgotUserIDOrPasswordFunctionality() throws Exception {
		super();
	}
	
	/********************************************************************************************************************
	 * 'Description : Verify that user can reset password by answering the challenge password questions set for the user. 	
	 * 'Date        : 06/08/2015
	 * 'Author      : Sowmya
	 ********************************************************************************************************************/

	@Test(description = "Verify that user can reset password by answering the challenge password questions set for the user. ")
	public void testHappyDay127691() throws Exception {

		gstrTCID = "127691";
		gstrTO = "Verify that user can reset password by answering the challenge password questions set for the user. ";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login objlogin_page = new Login(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);

		Login objlogin_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ChangePassword objChangePassword1 = new ChangePassword(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		

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
						"", "", "", "", objUser_data.strEmail, objUser_data.strEmail, objUser_data.strEmail)

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objlogin_page.clickLogOut();

		System.out
				.println("-----------------Test execution starts---------------");
		
		objlogin_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame()
		                   .verifyRegionDefaultPage();

		objNavigationToSubMenus1.navigateToSecurityQuestionsInPreferences();

		RegionDefault_page1.verWebNotificationframe();

		RegionDefault_page1
				.verAndAnswerSecurityQuesAndAnswerPopUp(objUser_data.strEmail)
				.verSecQuestSavedPage()
				.clickOnCloseOnSecQuesAndAnswWind();

		objlogin_page1.clickLogOut();

		objlogin_page1.launchEMRurl()
		              .clkOnForgotPwdLink();

		objChangePassword1.verResetYourPwdPageIsDisplayed()
				.enterUserNameInResetYourPwdPage(objUser_data.strNewUserName)
				.clkOnSubmitBtnInResetYourPwdPage()
				.verVerificationStatusPage();
		
//		objMailVerificationFunctions.loginToMail(objUser_data.strEmail,
//				objUser_data.strPrimaryPwsd);
//		
//		String strSubject = "password reset email";
//
//		String strMsgBody1 = "We have received your request to reset your password for EMResource\n\n"
//				+ "Please follow the link to reset your password:\n\n";
//
//		System.out.println(strSubject);
//		
//		objMailVerificationFunctions.NavToInboxNew(strSubject);
//
//		boolean blnMsg1 = false;
//		String strUrlLink = "";
//
//		objMailVerificationFunctions.verEmailNew(objUser_data.strEmail,
//				strSubject);
//
//		String mainWindowHandle = driver.getWindowHandle();
//
//		Set<String> a = driver.getWindowHandles();
//		Iterator<String> ite = a.iterator();
//
//		while (ite.hasNext()) {
//			String popupHandle = ite.next().toString();
//
//			if (!popupHandle.contains(mainWindowHandle)) {
//				driver.switchTo().window(popupHandle);
//
//			}
//		}
//		
//		for (int intCount = 0; intCount < 1; intCount++) {
//
//			if (blnMsg1 == false) {
//				blnMsg1 = objMailVerificationFunctions
//						.verifyMailContainsBody(strMsgBody1);
//				if (blnMsg1 == true) {
//					strUrlLink = objMailVerificationFunctions
//							.GetUrlLinkFromMsgBody(
//									objUser_data.strEmail, strSubject);
//				}
//			}
//			driver.switchTo().window(mainWindowHandle);
//			objMailVerificationFunctions.backToMailInbox();
//		}
//		assertTrue(blnMsg1);

		objMailVerificationFunctions.logoutMail();
         System.out.println("");
		objMailVerificationFunctions.launchUrl("");

		objChangePassword1.verQuestionAndEnterAnswerInSecurityQuesPage(
				objTest_data.strQuestionLast4DigitsOfDL,
				objTest_data.strAnsForLast4DigitsOfDL);

		objlogin_page1.enterNewPassword(objTest_data.strNewPassword)
				.enterConfirmPassword(objTest_data.strNewPassword)
				.clickSubmit();

		objChangePassword1.verPasswordStatusPage();

		objlogin_page1.loginToApplication(objUser_data.strNewUserName,
				objTest_data.strNewPassword);

		RegionDefault_page1.selectFrame().verifyRegionDefaultPage();

		objlogin_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/********************************************************************************************************************
	 * 'Description : Verify that user can edit the challenge password questions set from Preferences > Challenge Password  	
	 * 'Date        : 24/08/2015
	 * 'Author      : Sowmya
	 ********************************************************************************************************************/

	@Test(description = "Verify that user can edit the challenge password questions set from Preferences > Challenge Password ")
	public void testHappyDay127893() throws Exception {

		gstrTCID = "127893";
		gstrTO = "Verify that user can edit the challenge password questions set from Preferences > Challenge Password ";
       //Invalid token error is displayed for 'forgot password' link.
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login objlogin_page = new Login(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);

		Login objlogin_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ChangePassword objChangePassword1 = new ChangePassword(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		

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
						"", "", "", "", objUser_data.strEmail,
						objUser_data.strEmail, objUser_data.strEmail)

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objlogin_page.clickLogOut();

		System.out
				.println("-----------------Test execution starts---------------");
		
		objlogin_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame()
		                   .verifyRegionDefaultPage();

		objNavigationToSubMenus1.navigateToSecurityQuestionsInPreferences();

		RegionDefault_page1.verWebNotificationframe();

		RegionDefault_page1				
				.selectQuestionFromSecurityQuestnAndAnswerWin(objTest_data.strQuestion)
				.enterAnswerInSecurityQuestnAndAnswerWin(objTest_data.strAnswer)
				.enterEmailInSecurityQuestnAndAnswerWin(objUser_data.strEmail)
				.clkOnSaveBtnInSecurityQuestnAndAnswerWin()
				.verSecQuestSavedPage()
				.clickOnCloseOnSecQuesAndAnswWind();

		objlogin_page1.clickLogOut();

		objlogin_page1.launchEMRurl()
		              .clkOnForgotPwdLink();

		objChangePassword1.verResetYourPwdPageIsDisplayed()
				.enterUserNameInResetYourPwdPage(objUser_data.strNewUserName)
				.clkOnSubmitBtnInResetYourPwdPage()
				.verVerificationStatusPage();
		
		objMailVerificationFunctions.loginToMail(objUser_data.strEmail,
				objUser_data.strPrimaryPwsd);
		
		String strSubject = "password reset email";

		String strMsgBody1 = "We have received your request to reset your password for EMResource\n\n"
				+ "Please follow the link to reset your password:\n\n";

		System.out.println(strSubject);
		
		objMailVerificationFunctions.NavToInboxNew(strSubject);

		boolean blnMsg1 = false;
		String strUrlLink = "";

		objMailVerificationFunctions.verEmailNew(objUser_data.strEmail,
				strSubject);

		for (int intCount = 0; intCount < 1; intCount++) {

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
				if (blnMsg1 == true) {
					strUrlLink = objMailVerificationFunctions
							.GetUrlLinkFromMsgBody(
									objUser_data.strEmail, strSubject);
				}
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1);

		objMailVerificationFunctions.logoutMail();

		objMailVerificationFunctions.launchUrl(strUrlLink);

		objChangePassword1.verQuestionAndEnterAnswerInSecurityQuesPage(
				objTest_data.strQuestion,
				objTest_data.strAnswer);

		objlogin_page1.enterNewPassword(objTest_data.strNewPassword)
				.enterConfirmPassword(objTest_data.strNewPassword)
				.clickSubmit();

		objChangePassword1.verPasswordStatusPage();

		gstrResult = "PASS";
	}
	
	/********************************************************************************************************************
	 * 'Description : Verify that when user has access to multiple regions the changes done to the challenge setup are
                      reflected across all the regions   	
	 * 'Date        : 25/08/2015
	 * 'Author      : Sowmya
	 ********************************************************************************************************************/

	@Test(description = "Verify that when user has access to multiple regions the changes done to the challenge setup are"
			+ " reflected across all the regions ")
	public void testHappyDay127884() throws Exception {

		gstrTCID = "127884";
		gstrTO = "Verify that when user has access to multiple regions the changes done to the challenge setup are reflected "
				+ "across all the regions ";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login objlogin_page = new Login(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);

		Login objlogin_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		
		String strRegionValue[] = new String[3];
		

		objlogin_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion_page
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault_page.selectFrame();
		
		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objTest_data.strRegionName);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objTest_data.strRegionName1);
		
		strRegionValue[2] = objRegions_page
				.getRegionValue(objTest_data.strRegionName2);

		// User creation
		objUsersList_page.navigateToUsersNew();

		objUsersList_page
				.clickCreateNewUserButton()

				.enterAllUserDetails(objUser_data.strNewUserName,
						objUser_data.strUserPwd, objUser_data.strFullName, "",
						"", "", "", "",objUser_data.strEmail,
						objUser_data.strEmail, objUser_data.strEmail)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1])
				.selectRegion(strRegionValue[2])
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objlogin_page.clickLogOut();

		System.out
				.println("-----------------Test execution starts---------------");
		
		objlogin_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame().verifyRegionDefaultPage();

		objNavigationToSubMenus1.navigateToSecurityQuestionsInPreferences();

		RegionDefault_page1.verWebNotificationframe();

		RegionDefault_page1
				.selectQuestionFromSecurityQuestnAndAnswerWin(
						objTest_data.strQuestion)
				.enterAnswerInSecurityQuestnAndAnswerWin(objTest_data.strAnswer)
				.enterEmailInSecurityQuestnAndAnswerWin(objUser_data.strEmail)
				.clkOnSaveBtnInSecurityQuestnAndAnswerWin()
				.verSecQuestSavedPage().clickOnCloseOnSecQuesAndAnswWind();

		objSelectRegionpage1
				.selectRegionAndNavigate(objTest_data.strRegionName1);

		RegionDefault_page1.selectFrame();

		objNavigationToSubMenus1.navigateToSecurityQuestionsInPreferences();

		RegionDefault_page1.verWebNotificationframe();

		RegionDefault_page1
				.verSelectedQuestionFromSecurityQuestnAndAnswerWin(
						objTest_data.strQuestion)
				.verEnteredAnswerInSecurityQuestnAndAnswerWin(
						objTest_data.strAnswer)
				.verEnteredEmailInSecurityQuestnAndAnswerWin(
						objUser_data.strEmail)
				.clkOnCancelBtnInSecurityQuestnAndAnswerWin();

		objlogin_page1.launchEMRurl()
				.enterUserName(objUser_data.strNewUserName)
				.enterPassword(objUser_data.strNewPassword).clickLogin();

		objSelectRegionpage1
				.selectRegionAndNavigate(objTest_data.strRegionName2);

		RegionDefault_page1.selectFrame();

		objNavigationToSubMenus1.navigateToSecurityQuestionsInPreferences();

		RegionDefault_page1.verWebNotificationframe();

		RegionDefault_page1
				.verSelectedQuestionFromSecurityQuestnAndAnswerWin(
						objTest_data.strQuestion)
				.verEnteredAnswerInSecurityQuestnAndAnswerWin(
						objTest_data.strAnswer)
				.verEnteredEmailInSecurityQuestnAndAnswerWin(
						objUser_data.strEmail)
				.clkOnCancelBtnInSecurityQuestnAndAnswerWin();

		gstrResult = "PASS";
	}
	/***************************************************************************************
	 * 'Description : Verify that user can retrieve the username by providing primary email 
	 *                address associated with his/her account. 	
	 * 'Date        : 02/Feb/2016
	 * 'Author      : Anitha
	 ***************************************************************************************/

	@Test(description = "Verify that user can retrieve the username by providing primary email "
			+ "address associated with his/her account. ")
	public void testHappyDay127692() throws Exception {

		gstrTCID = "127692";
		gstrTO = "Verify that user can retrieve the username by providing primary email address associated"
				+ " with his/her account. ";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login objlogin_page = new Login(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);

		Login objlogin_page1 = new Login(this.driver1);
		ChangePassword objChangePassword1 = new ChangePassword(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);		

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
						"", "", "", "", objUser_data.strEmail,
						"", "")
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objlogin_page.clickLogOut();

		System.out
				.println("-----------------Test execution starts---------------");		

		objlogin_page1.launchEMRurl()
		              .clkOnForgotUserNameLink()
				      .enterPrimaryEmail(objUser_data.strEmail);
		
		objChangePassword1.clickOnSubmit().verVerificationStatusPage();

		objMailVerificationFunctions.loginToMail(objUser_data.strEmail,
				objUser_data.strPrimaryPwsd);

		String strSubject = objMailVerificationFunctions.getForgotUserEmailSubject();

		objMailVerificationFunctions.NavToInboxNew(strSubject);

		boolean blnMsg1 = false;

		objMailVerificationFunctions.verEmailNew(objUser_data.strEmail,
				strSubject);

		for (int intCount = 0; intCount < 1; intCount++) {

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(objUser_data.strNewUserName);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	/***************************************************************************************
	 * 'Description : Verify that web service user can retrieve the username by providing email address associated with his/her account 	
	 * 'Date        : 02/Feb/2016
	 * 'Author      : Anil
	 ***************************************************************************************/

	@Test(description =" Verify that web service user can retrieve the username by providing email address associated with hisher account ")
	public void testHappyDay127825() throws Exception {

		gstrTCID = "127825";
		gstrTO = "Verify that web service user can retrieve the username by providing email address associated with his/her account ";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login objlogin_page = new Login(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);

		Login objlogin_page1 = new Login(this.driver1);
		ChangePassword objChangePassword1 = new ChangePassword(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);		

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
						"", "", objUser_data.strOrganization, "", objUser_data.strEmail,
						"", "")
				.selectWebServiceChkBox()
				.clickSaveButton();

		objUsersList_page
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUser_data.strNewUserName1,
				objUser_data.strUserPwd, objUser_data.strFullName, "",
				"", "", objUser_data.strOrganization, "", "",objUser_data.strEmail, "")
		.selectWebServiceChkBox()
		.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		objlogin_page.clickLogOut();

		System.out
				.println("-----------------Test execution starts---------------");		

		objlogin_page1.launchEMRurl()
		              .clkOnForgotUserNameLink()
				      .enterPrimaryEmail(objUser_data.strEmail);
		
		objChangePassword1.clickOnSubmit().verVerificationStatusPage();

		objMailVerificationFunctions.loginToMail(objUser_data.strEmail,
				objUser_data.strPrimaryPwsd);

		String strSubject = objMailVerificationFunctions.getForgotUserEmailSubject();

		objMailVerificationFunctions.NavToInboxNew(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		objMailVerificationFunctions.verEmailNew(objUser_data.strEmail,
				strSubject);

		for (int intCount = 0; intCount < 1; intCount++) {

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(objUser_data.strNewUserName);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailContainsBody(objUser_data.strNewUserName1);
			}
			
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1);
		assertTrue(!blnMsg2);
		
		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}

}