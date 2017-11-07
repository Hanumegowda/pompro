package requirementGroup.SystemNotifications;


import static org.testng.AssertJUnit.assertTrue;
import lib.dataObject.EMTrack_data;
import lib.dataObject.IncomingPationtNotificationData;
import lib.dataObject.Login_data;
import lib.dataObject.Region_data;
import lib.dataObject.Resource_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.IncomingPatientNotifications;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.SelectRegion;
import lib.page.SystemNotifications;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseSystemNotification extends TestNG_UI_EXTENSIONS {
	
	public EdgeCaseSystemNotification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***************************************************************************************************************
	 * 'Description : Verify that email system notification is prefixed with "Intermedix" instead of "EMSystems".
	 * 'Date        : 4-Feb-2016 
	 * 'Author      : Sangappa K
	 ***************************************************************************************************************/

	@Test(description = " Verify that email system notification is prefixed with Intermedix instead of EMSystems ")
	public void testEdgeCase167097() throws Exception {
		gstrTCID ="167097";
		gstrTO = " Verify that email system notification is prefixed with Intermedix instead of EMSystems ";
		
		// Objects for data
		Login_data objLogin_data = new Login_data();
		Region_data objRegion_data = new Region_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		Regions objRegions1 = new Regions(this.driver1);
		UsersList objUsersList1 = new UsersList(driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SystemNotifications objSystemNotifications1 = new SystemNotifications(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions1 = new MailVerificationFunctions(
				this.driver1);

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strEmail,
						objUserdata.strEmail, objUserdata.strEmail)
				.selectFirstRole().clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickSystemNotificationPreferences();

		objSystemNotifications1.selectEmailSystemNotificationChkBx()
				.clickOnSaveButton();

		objNavigationToSubmenus1.navigateToRegions();

		objRegions1.clickManageSysNotification()
				.enterSystemNoticeTitle(objRegion_data.strTitle)
				.enterSystemNoticeDescription(objRegion_data.strDescription)
				.enterSystemNoticeHoverText(objRegion_data.strHoverText)
				.deselAndSelActivechkbox();

		objLogin1.clickLogOut();

		String strSubject = "Intermedix: " + objRegion_data.strTitle;

		String strMsgBody = objRegion_data.strDescription
				+ "\n\n*This is an automated message from Intermedix. Please do not respond to it. It was sent to you because your account is set up to receive System Notifications. You can disable this if you wish by going to https://emresource.qa.intermedix.com and modifying your system notification preferences.";

		objMailVerificationFunctions1.loginToMail(objUserdata.strEmail,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions1.NavToInbox(strSubject);

		boolean blnMsg = false;

		objMailVerificationFunctions1
				.verEmail(objUserdata.strEmail, strSubject);

		blnMsg = objMailVerificationFunctions1.verifyMailBody(strMsgBody);

		assertTrue(blnMsg);

		objMailVerificationFunctions1.logoutMail();

		gstrResult = "PASS";
	}

	/***************************************************************************************************************
	 * 'Description : Verify that pager system notification is prefixed with "Intermedix" instead of "EMSystems".
	 * 'Date        : 4-Feb-2016 
	 * 'Author      :Sangappa K
	 ***************************************************************************************************************/

	@Test(description = " Verify that pager system notification is prefixed with Intermedix instead of EMSystems")
	public void testEdgeCase167098() throws Exception {
		gstrTCID ="167098";
		gstrTO = " Verify that pager system notification is prefixed with Intermedix instead of EMSystems";
		
		// Objects for data
		Login_data objLogin_data = new Login_data();
		Region_data objRegion_data = new Region_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		Regions objRegions1 = new Regions(this.driver1);
		UsersList objUsersList1 = new UsersList(driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SystemNotifications objSystemNotifications1 = new SystemNotifications(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions1 = new MailVerificationFunctions(
				this.driver1);

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strEmail,
						objUserdata.strEmail, objUserdata.strEmail)
				.selectFirstRole().clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickSystemNotificationPreferences();

		objSystemNotifications1.selectTextPagerSystemNotificationChkBx()
				.clickOnSaveButton();

		objNavigationToSubmenus1.navigateToRegions();

		objRegions1.clickManageSysNotification()
				.enterSystemNoticeTitle(objRegion_data.strTitle)
				.enterSystemNoticeDescription(objRegion_data.strDescription)
				.enterSystemNoticeHoverText(objRegion_data.strHoverText)
				.deselAndSelActivechkbox();
		System.out.println(objRegion_data.strTitle);

		objLogin1.clickLogOut();

		String strSubject = "Intermedix Alert";

		String strMsgBody = objRegion_data.strTitle + ": "
				+ objRegion_data.strDescription;

		objMailVerificationFunctions1.loginToMail(objUserdata.strEmail,
				objUserdata.strPrimaryPwsd);
		System.out.println(objUserdata.strEmail);
		System.out.println(objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions1.NavToInbox(strSubject);

		boolean blnMsg = false;

		objMailVerificationFunctions1
				.verEmail(objUserdata.strEmail, strSubject);

		blnMsg = objMailVerificationFunctions1.verifyMailBody(strMsgBody);

		assertTrue(blnMsg);

		objMailVerificationFunctions1.logoutMail();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that web system notification is prefixed with "Intermedix" instead of "EMSystems".
	 * 'Date        : 2-Feb-2016
	 * 'Author      : Sangappa K
	 ***************************************************************************************************************/

	@Test(description = " Verify that web system notification is prefixed with Intermedix instead of EMSystems")
	public void testEdgeCase167099() throws Exception {
		gstrTCID ="167099";
		gstrTO = " Verify that web system notification is prefixed with Intermedix instead of EMSystems";
		
		// Objects for data
		Login_data objLogin_data = new Login_data();

		Region_data objRegion_data = new Region_data();

		User_data objUserdata = new User_data();

		// Objects for Page
		Login objLogin1 = new Login(this.driver1);

		Regions objRegions1 = new Regions(this.driver1);

		UsersList objUsersList1 = new UsersList(driver1);

		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		SystemNotifications objSystemNotifications1 = new SystemNotifications(
				this.driver1);

		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		Date_Time_settings objDts = new Date_Time_settings();

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strEmail,
						objUserdata.strEmail, objUserdata.strEmail)
				.selectFirstRole().clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickSystemNotificationPreferences();

		objSystemNotifications1.selectWebPageSystemNotificationChkBx()
				.clickOnSaveButton();

		objNavigationToSubmenus1.navigateToRegions();

		objRegions1.clickManageSysNotification()
				.enterSystemNoticeTitle(objRegion_data.strTitle)
				.enterSystemNoticeDescription(objRegion_data.strDescription)
				.enterSystemNoticeHoverText(objRegion_data.strHoverText)
				.deselAndSelActivechkbox();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		String strSubject = "Intermedix: " + objRegion_data.strTitle;
		String strNotificationMsg = objRegion_data.strTitle + ": "
				+ objRegion_data.strDescription;

		String strApplicationTime = objEventManagement1.getApplicationTime();
		String strCurrentYear = objDts.getCurrentDate("yyyy");
		strApplicationTime = strApplicationTime + " " + strCurrentYear;
		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		System.out.println("strApplicationTime is=" + strApplicationTime);

		objRegionDefault1.verWebNotificationframe()
				.verWebNotificationMsg(strSubject, strNotificationMsg)
				.clickAcknowledgeAllNotifications().switchToDefaultFrame()
				.selectFrame();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
