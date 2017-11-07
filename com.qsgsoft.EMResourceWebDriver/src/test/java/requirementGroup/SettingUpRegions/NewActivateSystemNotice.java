package requirementGroup.SettingUpRegions;

import static org.testng.AssertJUnit.assertTrue;
import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewActivateSystemNotice extends TestNG_UI_EXTENSIONS {

	public NewActivateSystemNotice() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description :  Verify that system notice can be activated.
	'Precondition:
	'Date	 	 : 01-Jun-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " Verify that system notice can be activated.")
	public void testHappyDay64790() throws Exception {

		gstrTCID = "64790";
		gstrTO = " Verify that system notice can be activated.";

		Login_data objLogindata = new Login_data();
		
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Regions objRegions = new Regions(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToRegions();
		
		objRegions.clickManageSysNotification()		
		.verEditSystemNotificationPage()
		.selActivechkbox()
		.enterSystemNoticeTitle(objLogindata.strSystemNoticeTitle)
		.enterSystemNoticeDescription(objLogindata.strDescription);
		
		objRegions.clickSaveButton()
		.verifyRegionListPage()
		.clickOnSystemNoticeLink();
		
		objEventManagement1.verWebNotificationframe();
		objRegions.verifySystemNoticeTitleAndDescription(objLogindata.strSystemNoticeTitle, objLogindata.strDescription);
		
		gstrResult = "PASS";
	}
	
	
	/*************************************************************************************
	'Description : Verify that system notice can be deactivated.
	'Precondition:
	'Date	 	 : 01-Jun-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that system notice can be deactivated.")
	public void testHappyDay64794() throws Exception {

		gstrTCID = "64794";
		gstrTO = "Verify that system notice can be deactivated.";

		Login_data objLogindata = new Login_data();
		
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Regions objRegions = new Regions(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToRegions();
		
		objRegions.clickManageSysNotification()		
		.verEditSystemNotificationPage()
		.deSelActivechkbox();
		
		objRegions.clickSaveButton()
		.verifyRegionListPage()
		.verifySystemNoticeLinkNotDisplayed();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/********************************************************************************************************************
	 * 'Description : Verify that user who has subscribed for System notice via email, pager and web receives the system 
	 *                notifications when system admin activates the system notice 
	 * 'Date        : 26/08/2015
	 * 'Author      : Sowmya
	 ********************************************************************************************************************/

	@Test(description = "Verify that user who has subscribed for System notice via email, pager and web receives the "
			+ "system notifications when system admin activates the system notice")
	public void testHappyDay184570() throws Exception {

		gstrTCID = "184570";//Old TC ID 127947 is deactivated
		gstrTO = "Verify that user who has subscribed for System notice via email, pager and web receives the system "
				+ "notifications when system admin activates the system notice";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login objlogin_page = new Login(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);

		Login objlogin_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionPage1 = new SelectRegion(this.driver1);
		
		UsersList objUsersList_page1 = new UsersList(this.driver1);
		Regions objRegions1 = new Regions(this.driver1);

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
				.selectFirstRole().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objUsersList_page
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUser_data.strNewUserName1,
						objUser_data.strUserPwd, objUser_data.strFullName, "",
						"", "", "", "", objUser_data.strEmail1,
						objUser_data.strEmail1, objUser_data.strEmail1)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);
		
		Thread.sleep(5000);

		objlogin_page.clickLogOut();
		
		Thread.sleep(3000);

		System.out
				.println("-----------------Test execution starts---------------");

		objlogin_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame().verifyRegionDefaultPage();

		objnNavigationToSubMenus1.navigateToSystemNotificationInPreferences();

		objUsersList_page1.selSystemNotificationsCheckBoxes()
		                  .clickSaveButton()
				          .clickOnOkButton();

		objlogin_page1.clickLogOut();

		objlogin_page1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame().verifyRegionDefaultPage();

		objnNavigationToSubMenus1.navigateToSystemNotificationInPreferences();

		objUsersList_page1.verSystemNotificationsEmailCheckBoxIsNotSelected()
				.verSystemNotificationsPagerCheckBoxIsNotSelected()
				.verSystemNotificationsWebCheckBoxIsNotSelected()
				.clickSaveButton().clickOnOkButton();

		objlogin_page1.clickLogOut();

		objlogin_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegionPage1
				.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame().verifyRegionDefaultPage();

		objnNavigationToSubMenus1.navigateToRegions();

		objRegions1.clickManageSysNotification()
				.verEditSystemNotificationPage()
				.deSelActivechkbox()
				.enterSystemNoticeTitle(objTest_data.strSystemNoticeTitle)
				.enterSystemNoticeDescription(objTest_data.strDescription);

		objRegions1.clickSaveButton().verifyRegionListPage();
		
		objRegions1.clickManageSysNotification()
		           .verEditSystemNotificationPage()
		           .selActivechkbox()
		           .enterSystemNoticeTitle(objTest_data.strSystemNoticeTitle1)
		           .enterSystemNoticeDescription(objTest_data.strDescription);

         objRegions1.clickSaveButton().verifyRegionListPage();

		objlogin_page1.clickLogOut();

		objlogin_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();
		
		String systemNotification = "Intermedix: " + objTest_data.strSystemNoticeTitle1;//strSystemNoticeTitle1
		String systemDes  = objTest_data.strSystemNoticeTitle1 + ": " + objTest_data.strDescription;

		EventManagement_page1.verWebNotificationframe()
		.verWebNotificationAndAcknowledge(systemNotification,
				systemDes)

		.clickAcknowledgeAllNotifications().selectFrame();
		
		objlogin_page1.clickLogOut();

		objMailVerificationFunctions.loginToMail(objUser_data.strEmail,
				objUser_data.strPrimaryPwsd);

		String strEmailSubject = "EMResource Intermedix: " + objTest_data.strSystemNoticeTitle1;

		String strEmailMsgBody1 = objTest_data.strDescription + "\n\n"  + "*This is an automated message from Intermedix." +
				" Please do not respond to it. It was sent to you because your account is set" +
				" up to receive System Notifications. You can disable this if you wish by going to" +
				" https://emresource.qa.intermedix.com and modifying your system notification preferences.";

		System.out.println(strEmailSubject);

		objMailVerificationFunctions.NavToInboxNew(strEmailSubject);

		boolean blnMsg1 = false;

		objMailVerificationFunctions
				.verEmailNew(objUser_data.strEmail, strEmailSubject);

		for (int intCount = 0; intCount < 3; intCount++) {

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strEmailMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}	
		
		String strPagerSubject = "Intermedix Alert";

		String strPagerMsgBody = objTest_data.strSystemNoticeTitle1 + ": "
				+ objTest_data.strDescription;
		
		objMailVerificationFunctions
		.verEmail(objUser_data.strEmail, strPagerSubject);
		boolean blnMsg = false;

		objMailVerificationFunctions
				.verEmail(objUser_data.strEmail, strPagerSubject);

		blnMsg = objMailVerificationFunctions.verifyMailBody(strPagerMsgBody);

		assertTrue(blnMsg1 && blnMsg);
		
		objMailVerificationFunctions.logoutMail();

		objlogin_page1.loginToApplication(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame().verifyRegionDefaultPage();

		EventManagement_page1.verWebNotificationframeNotPresent();

		objlogin_page1.clickLogOut();
		
		objMailVerificationFunctions.loginToMail(objUser_data.strEmail1,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions
				.NavToInboxAndVerEmailIsNotPresent(strEmailSubject);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/********************************************************************************************************************
	 * 'Description : Verify that user who has opted to receive system notice selecting ONLY the 'web page' receives web
	 *                notification when system admin activates the system notice
	 * 'Date        : 26/08/2015
	 * 'Author      : Sowmya
	 ********************************************************************************************************************/

	@Test(description = "Verify that user who has opted to receive system notice selecting ONLY the 'web page' "
			+ "receives web notification when system admin activates the system notice")
	public void testHappyDay162657() throws Exception {

		gstrTCID = "162657";
		gstrTO = "Verify that user who has opted to receive system notice selecting ONLY the 'web page' receives "
				+ "web notification when system admin activates the system notice";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login objlogin_page = new Login(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);

		Login objlogin_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionPage1 = new SelectRegion(this.driver1);
		
		UsersList objUsersList_page1 = new UsersList(this.driver1);
		Regions objRegions1 = new Regions(this.driver1);

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
				.selectFirstRole().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objlogin_page.clickLogOut();

		System.out
				.println("-----------------Test execution starts---------------");

		objlogin_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame().verifyRegionDefaultPage();

		objnNavigationToSubMenus1.navigateToSystemNotificationInPreferences();

		objUsersList_page1.clickSystemNotificationsWebCheckBox()
		                  .clickSaveButton()
				          .clickOnOkButton();

		objlogin_page1.clickLogOut();

		objlogin_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegionPage1
				.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame().verifyRegionDefaultPage();

		objnNavigationToSubMenus1.navigateToRegions();

		objRegions1.clickManageSysNotification()
				.verEditSystemNotificationPage().clickOnActivechkbox()
				.enterSystemNoticeTitle(objTest_data.strSystemNoticeTitle)
				.enterSystemNoticeDescription(objTest_data.strDescription);

		objRegions1.clickSaveButton().verifyRegionListPage();
		
		objRegions1.clickManageSysNotification()
				.verEditSystemNotificationPage().selActivechkbox()
				.enterSystemNoticeTitle(objTest_data.strSystemNoticeTitle1)
				.enterSystemNoticeDescription(objTest_data.strDescription);

         objRegions1.clickSaveButton().verifyRegionListPage();

		objlogin_page1.clickLogOut();

		objlogin_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		String systemNotification = "Intermedix: " + objTest_data.strSystemNoticeTitle1;
		String systemDes  = objTest_data.strSystemNoticeTitle1 + ": " + objTest_data.strDescription;

		EventManagement_page1.verWebNotificationframe()
		.verWebNotificationAndAcknowledge(systemNotification,
				systemDes)

		.clickAcknowledgeAllNotifications();

		objMailVerificationFunctions.loginToMail(objUser_data.strEmail,
				objUser_data.strPrimaryPwsd);

		String strSubject = "EMResource Intermedix: " + objTest_data.strSystemNoticeTitle1;

		System.out.println(strSubject);

		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubject);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/********************************************************************************************************************
	 * 'Description : Verify that user who has opted to receive system notice selecting 'web page' will not receive web 
	 *                notification when system admin deactivates system notice
	 * 'Date        : 26/08/2015
	 * 'Author      : Sowmya
	 ********************************************************************************************************************/

	@Test(description = "Verify that user who has opted to receive system notice selecting 'web page' will not receive "
			+ "web notification when system admin deactivates system notice")
	public void testHappyDay162659() throws Exception {

		gstrTCID = "162659";
		gstrTO = "Verify that user who has opted to receive system notice selecting 'web page' will not receive web "
				+ "notification when system admin deactivates system notice";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login objlogin_page = new Login(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);

		Login objlogin_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionPage1 = new SelectRegion(this.driver1);
		
		UsersList objUsersList_page1 = new UsersList(this.driver1);
		Regions objRegions1 = new Regions(this.driver1);

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
				.selectFirstRole().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objlogin_page.clickLogOut();

		System.out
				.println("-----------------Test execution starts---------------");

		objlogin_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame().verifyRegionDefaultPage();

		objnNavigationToSubMenus1.navigateToSystemNotificationInPreferences();

		objUsersList_page1.clickSystemNotificationsWebCheckBox()
		                  .clickSaveButton()
				          .clickOnOkButton();

		objlogin_page1.clickLogOut();

		objlogin_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegionPage1
				.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame().verifyRegionDefaultPage();

		objnNavigationToSubMenus1.navigateToRegions();

		objRegions1.clickManageSysNotification()
				.verEditSystemNotificationPage()
				.deSelActivechkbox();

		objRegions1.clickSaveButton().verifyRegionListPage();
		
		objlogin_page1.clickLogOut();

		objlogin_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.verWebNotificationframeNotPresent();

		objMailVerificationFunctions.loginToMail(objUser_data.strEmail,
				objUser_data.strPrimaryPwsd);

		String strSubject = "EMResource Intermedix: " + objTest_data.strSystemNoticeTitle1;

		System.out.println(strSubject);

		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubject);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
}