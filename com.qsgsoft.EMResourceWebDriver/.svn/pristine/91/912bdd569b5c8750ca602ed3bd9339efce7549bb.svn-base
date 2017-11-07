package requirementGroup.Notifications;

import static org.testng.AssertJUnit.assertTrue;
import lib.dataObject.EMTrack_data;
import lib.dataObject.Login_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EMTrackLogin;
import lib.page.EventManagement;
import lib.page.IncomingPatientNotifications;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.SystemNotifications;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayIncomingPatientNotifications extends TestNG_UI_EXTENSIONS{
	
	public HappyDayIncomingPatientNotifications() throws Exception {
		super();
	}

	/***************************************************************************************************************
	 * 'Description : Add a daily patient in EMTrack and verify that user in EMResource recieves incoming patient 
	 *                notifications via email, pager and web.
	 * 'Date        : 12-Mar-2015 
	 * 'Author      : Sowmya
	 ***************************************************************************************************************/
	@Test(description = " Add a daily patient in EMTrack and verify that user in EMResource recieves incoming patient notifications via email, pager and web.")
	public void testHappyDay25652() throws Exception {
		gstrTCID = "25652";
		gstrTO = " Add a daily patient in EMTrack and verify that user in EMResource recieves incoming patient notifications via email, pager and web.";

		// Objects for data
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EMTrack_data objEMTrack_data = new EMTrack_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Roles_data objRolesData = new Roles_data();

		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		
		String strRoleValue[] = new String[1];

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		EventManagement EventManagement_Page1=new EventManagement(this.driver1);
		SystemNotifications SystemNotifications_page1 = new SystemNotifications(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		System.out.println("-----Precondtion execution starts------");
		
		//IE 9
		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		RegionDefault_Page1.selectFrame();

		SelectRegion_page1
				.selectRegionAndNavigate(objTest_data.strNewMexicoReg);

		RegionDefault_Page1.selectFrame();

		NavigationToSubMenus_page.navigateToIncomingPationt();

		objIncomingPatientNotifications.selectEnabledCheckBox();
		
		objIncomingPatientNotifications.selectManualEntryCheckBox();
		
		objIncomingPatientNotifications.clickOnSaveButton();
		
		//New Role creation
		objNavigationToSubMenus1.navigateToRoles();
		
		objRoles1.clickOnCreateNewRoleBtn()
		.enterRoleName(objRolesData.strRoleName);	
		objRoles1.clickOnSaveBtn();
		
		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		// User creation
		UsersList_page1.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page1
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.selectAssociateWithOfResource(objResource_data.strNewMexicoResourceName1)
				.clickAdvancedOptionAndExpand()		
				.selectIncomingPatientNotificationOption()
				.clickSaveButton();
		
		UsersList_page1.searchUserName(objUser_data.strNewUserName, objUser_data.strRole, objUser_data.strResourceType, 
      		  objUser_data.strUsername, objUser_data.strEquals)
      		  .editUserDetails(objUser_data.strNewUserName);
				
				
		UsersList_page1.clickOnsystemNotifyPreferences();
				
		SystemNotifications_page1.selectEmailIncomingPatientNotification()
				.selectPagerIncomingPatientNotification()
				.clickOnSaveButton();

		objNavigationToSubMenus1.navigateToRegDefault();
	
		//Firefox
		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strNewMexicoRegion);

		EMTrackLogin_Page.navigateToPatientPage();

		Thread.sleep(10000);

		EMTrackLogin_Page.navToAddDailyPatientPage();

		EMTrackLogin_Page.selGender(objEMTrack_data.strMale);

		EMTrackLogin_Page.enterPatientAge(objEMTrack_data.strPatientAge);
		
		EMTrackLogin_Page.selDestinationLocation(objEMTrack_data.strNewMexicoLocation1);

		EMTrackLogin_Page.selProvider(objEMTrack_data.strNewMexicoProvider);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.setracProviderUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		EMTrackLogin_Page.clkSaveBtn();

		System.out
				.println("-----Precondtion execution ends and execution starts------");
			
		objMap1.clickOnRefreshLink();
		
		String strApplicationTime = EventManagement_Page1.getApplicationTime();
		
		String strDateAndMonth[] = strApplicationTime.split(" ");

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strDateAndMonth[0] + " " + strDateAndMonth[1] + " " + strDateAndMonth[2] + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		
		strApplicationTime = strApplicationTime + " " + strDateAndMonth[3];

		String strArrivalTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");
		

		String strArrivalTime1 = objDts.addTimetoExisting(strApplicationTime, 6,
				"MM/dd/yyyy HH:mm");
		
		String strArrivalTime2 = objDts.addTimetoExisting(strApplicationTime, 4,
				"MM/dd/yyyy HH:mm");
		
		strArrivalTime = strArrivalTime + " " + strDateAndMonth[3];
		strArrivalTime1 = strArrivalTime1 + " " + strDateAndMonth[3];
		strArrivalTime2 = strArrivalTime2 + " " + strDateAndMonth[3];
		
		System.out.println(strArrivalTime);
		
		login_page1.clickLogOut();
		String strUnknown= "unknown";
		String strNA = "N/A";
		String strBlank = "-";
		
		

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		String strHeader = "Incoming Patient Notification for "+objResource_data.strNewMexicoResourceName1;	
		
		String[] strHeaderNames = { "Sent By:", "Age:", "Complaint:",
				"Triage:", "Gender:", "Level of Care:", "EMS Agency:", "EMS Unit:",  "Region:" };

		String[] strUpdatedValues = { objEMTrack_data.strQsgTester,
				objEMTrack_data.strPatientAge + " Years", strUnknown,
				strNA, objEMTrack_data.strMale, strBlank, strBlank,strBlank, objTest_data.strNewMexicoReg };

		Thread.sleep(5000);
		


		RegionDefault_Page1
				.selectFrame()
				.verWebNotificationframe()
				.verIncomingPatientNotificationMsgs(strHeader, strHeaderNames,
						strUpdatedValues, strArrivalTime, strArrivalTime1, strArrivalTime2);
//				.clickReviewButton();
//		
//		Thread.sleep(5000);
//
//		Set<String> b = driver1.getWindowHandles();
//		Iterator<String> ite2 = b.iterator();
//
//		while (ite2.hasNext()) {
//			String popupHandle = ite2.next().toString();
//
//			if (!popupHandle.contains(mainWindowHandle2)) {
//				driver1.switchTo().window(popupHandle);
//
//			}
//		}
//		
//		RegionDefault_Page1.verIncomingPatientNotificationMsgReviewPopupWindows(
//				strHeader, strSubmittedTime, strHeaderNames, strUpdatedValues,
//				strArrivalTime, strArrivalTime1, strArrivalTime2);		
//		
//		driver1.close();
//		driver1.switchTo().window(mainWindowHandle2);
		RegionDefault_Page1.clickAcknowledgeAllNotifications();
	RegionDefault_Page1.switchToDefaultFrame()
				.selectFrame();
	
	login_page1.clickLogOut();
		
		String strMsgBody1 = objMailVerificationFunctions.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strNewMexicoReg, strArrivalTime, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
	
		String strMsgBody2 = objMailVerificationFunctions.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strNewMexicoReg, strArrivalTime1, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		String strMsgBody3 = objMailVerificationFunctions.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strNewMexicoReg, strArrivalTime, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		String strMsgBody4 = objMailVerificationFunctions.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strNewMexicoReg, strArrivalTime1, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		String strMsgBody5 = objMailVerificationFunctions.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strNewMexicoReg, strArrivalTime2, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		String strMsgBody6 = objMailVerificationFunctions.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strNewMexicoReg, strArrivalTime2, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		String strSubject = objMailVerificationFunctions.getIPNEMailSubject(objResource_data.strNewMexicoResourceName1);
		
		System.out.println(strSubject);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
				if (blnMsg1 == false) {
					blnMsg1 = objMailVerificationFunctions
							.verifyMailBody(strMsgBody2);
				}
				if (blnMsg1 == false) {
					blnMsg1 = objMailVerificationFunctions
							.verifyMailBody(strMsgBody5);
				}
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
				if (blnMsg2 == false) {
					blnMsg2 = objMailVerificationFunctions
							.verifyMailBody(strMsgBody4);
				}
				if (blnMsg2 == false) {
					blnMsg2 = objMailVerificationFunctions
							.verifyMailBody(strMsgBody6);
				}
			}
			objMailVerificationFunctions.backToMailInbox();

		}

		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		


		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Add a Vaccination patient in EMTrack and verify that user in EMResource recieves incoming patient 
	 *                notifications via email, pager and web
	 * 'Date        : 12-Mar-2015 
	 * 'Author      : Sowmya
	 ***************************************************************************************************************/
	@Test(description = " Add a Vaccination patient in EMTrack and verify that user in EMResource recieves incoming patient notifications via email, pager and web")
	public void testHappyDay25696() throws Exception {
		gstrTCID = "25696";
		gstrTO = " Add a Vaccination patient in EMTrack and verify that user in EMResource recieves incoming patient notifications via email, pager and web";

		// Objects for data
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EMTrack_data objEMTrack_data = new EMTrack_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Roles_data objRolesData = new Roles_data();

		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		
		String strRoleValue[] = new String[1];

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		EventManagement EventManagement_Page1=new EventManagement(this.driver1);
		SystemNotifications SystemNotifications_page1 = new SystemNotifications(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page1 = new NavigationToSubMenus(
				this.driver1);
		System.out.println("-----Precondtion execution starts------");
		
		//IE 9
		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		RegionDefault_Page1.selectFrame();

		SelectRegion_page1
				.selectRegionAndNavigate(objTest_data.strNewMexicoReg);

		RegionDefault_Page1.selectFrame();

		NavigationToSubMenus_page1.navigateToIncomingPationt();

		objIncomingPatientNotifications1.selectEnabledCheckBox();
		
		objIncomingPatientNotifications1.selectManualEntryCheckBox();
		
		objIncomingPatientNotifications1.clickOnSaveButton();
		
		//New Role creation
		objNavigationToSubMenus1.navigateToRoles();
		
		objRoles1.clickOnCreateNewRoleBtn()
		.enterRoleName(objRolesData.strRoleName);	
		objRoles1.clickOnSaveBtn();
		
		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		// User creation
		UsersList_page1.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page1
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.selectAssociateWithOfResource(objResource_data.strNewMexicoResourceName2)
				.clickAdvancedOptionAndExpand()		
				.selectIncomingPatientNotificationOption()
				.clickSaveButton();
		
		UsersList_page1.searchUserName(objUser_data.strNewUserName, objUser_data.strRole, objUser_data.strResourceType, 
      		  objUser_data.strUsername, objUser_data.strEquals)
      		  .editUserDetails(objUser_data.strNewUserName);
				
				
		UsersList_page1.clickOnsystemNotifyPreferences();
				
		SystemNotifications_page1.selectEmailIncomingPatientNotification()
				.selectPagerIncomingPatientNotification()
				.clickOnSaveButton();

		objNavigationToSubMenus1.navigateToRegDefault();

		// Firefox
		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strNewMexicoRegion);

		EMTrackLogin_Page.navigateToPatientPage();

		Thread.sleep(10000);

		EMTrackLogin_Page.navToVaccinationPatientPage();

		EMTrackLogin_Page
				.enterVaccinationPatientID(objEMTrack_data.strPatientID);

		EMTrackLogin_Page
				.selVaccDestinationLocation(objEMTrack_data.strNewMexicoLocation2);

		EMTrackLogin_Page.selVaccProvider(objEMTrack_data.strNewMexicoProvider);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.setracProviderUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		EMTrackLogin_Page.clkSaveBtn();

		System.out
				.println("-----Precondtion execution ends and execution starts------");
			
		objMap1.clickOnRefreshLink();
		
		String strApplicationTime = EventManagement_Page1.getApplicationTime();
		
		String strDateAndMonth[] = strApplicationTime.split(" ");

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strDateAndMonth[0] + " " + strDateAndMonth[1] + " " + strDateAndMonth[2] + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		String strArrivalTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");

		String strArrivalTime1 = objDts.addTimetoExisting(strApplicationTime, 6,
				"MM/dd/yyyy HH:mm");
		
		String strArrivalTime2 = objDts.addTimetoExisting(strApplicationTime, 4,
				"MM/dd/yyyy HH:mm");
		System.out.println(strArrivalTime);
		
		strArrivalTime = strArrivalTime + " " + strDateAndMonth[3];
		strArrivalTime1 = strArrivalTime1 + " " + strDateAndMonth[3];
		strArrivalTime2 = strArrivalTime2 + " " + strDateAndMonth[3];
		
		
		login_page1.clickLogOut();
	
		
		
		String strUnknown= "unknown";
		String strNA = "N/A";
		String strBlank = "-";
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		String strHeader = "Incoming Patient Notification for "+objEMTrack_data.strNewMexicoLocation2;	
		
		String strSubmittedTime = strApplicationTime;
		
		String[] strHeaderNames = { "Sent By:", "Age:", "Complaint:",
				"Triage:", "Gender:", "Level of Care:", "EMS Agency:", "EMS Unit:",  "Region:" };

		String[] strUpdatedValues = { objEMTrack_data.strQsgTester,
				strUnknown, strUnknown,
				strNA, strUnknown, strBlank, strBlank,strBlank, objTest_data.strNewMexicoReg };
		
		Thread.sleep(5000);
		
		String mainWindowHandle2 = driver1.getWindowHandle();

		RegionDefault_Page1
				.selectFrame()
				.verWebNotificationframe()
				.verIncomingPatientNotificationMsgs(strHeader, strHeaderNames,
						strUpdatedValues, strArrivalTime, strArrivalTime1, strArrivalTime2);
//				.clickReviewButton();
//		
//		Thread.sleep(5000);
//
//		Set<String> b = driver1.getWindowHandles();
//		Iterator<String> ite2 = b.iterator();
//
//		while (ite2.hasNext()) {
//			String popupHandle = ite2.next().toString();
//
//			if (!popupHandle.contains(mainWindowHandle2)) {
//				driver1.switchTo().window(popupHandle);
//
//			}
//		}
//		
//		RegionDefault_Page1.verIncomingPatientNotificationMsgReviewPopupWindow(
//				strHeader, strSubmittedTime, strHeaderNames, strUpdatedValues,
//				strArrivalTime);		
//		
//		driver1.close();
//		driver1.switchTo().window(mainWindowHandle2);
		
	RegionDefault_Page1.clickAcknowledgeAllNotifications();
	RegionDefault_Page1.switchToDefaultFrame()
				.selectFrame();
	
	login_page1.clickLogOut();
	
	String strMsgBody1 = objMailVerificationFunctions.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strNewMexicoReg, strArrivalTime, strUnknown,
			strUnknown, strUnknown, strNA, strBlank, strBlank, strBlank);

	String strMsgBody2 = objMailVerificationFunctions.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strNewMexicoReg, strArrivalTime1, strUnknown,
			strUnknown, strUnknown, strNA, strBlank, strBlank, strBlank);
	
	String strMsgBody3 = objMailVerificationFunctions.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strNewMexicoReg, strArrivalTime, strUnknown,
			strUnknown, strUnknown, strNA, strBlank, strBlank, strBlank);
	
	String strMsgBody4 = objMailVerificationFunctions.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strNewMexicoReg, strArrivalTime1, strUnknown,
			strUnknown, strUnknown, strNA, strBlank, strBlank, strBlank);
	
	String strMsgBody5 = objMailVerificationFunctions.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strNewMexicoReg, strArrivalTime2, strUnknown,
			strUnknown, strUnknown, strNA, strBlank, strBlank, strBlank);
	
	String strMsgBody6 = objMailVerificationFunctions.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strNewMexicoReg, strArrivalTime2, strUnknown,
			strUnknown, strUnknown, strNA, strBlank, strBlank, strBlank);
	
	objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
			objUser_data.strPrimaryPwsd);

	String strSubject = objMailVerificationFunctions.getIPNEMailSubject(objEMTrack_data.strNewMexicoLocation2);
	
	System.out.println(strSubject);

	objMailVerificationFunctions.NavToInbox(strSubject);

	boolean blnMsg1 = false;
	boolean blnMsg2 = false;

	for (int intCount = 0; intCount < 2; intCount++) {

		objMailVerificationFunctions.verEmail(
				objUser_data.strPrimaryMailId, strSubject);

		if (blnMsg1 == false) {
			blnMsg1 = objMailVerificationFunctions
					.verifyMailBody(strMsgBody1);
			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}
			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody5);
			}
		}

		if (blnMsg2 == false) {
			blnMsg2 = objMailVerificationFunctions
					.verifyMailBody(strMsgBody3);
			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}
			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody6);
			}
		}
		objMailVerificationFunctions.backToMailInbox();

	}

	assertTrue(blnMsg1 && blnMsg2);

	objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}
	
	/**********************************************************************************************************************************************************
	 * 'Description : Add a MCI Triage patient in EMTrack and verify that user in EMResource recieves incoming patient notifications via email, pager and web.
	 * 'Date        : 13-Mar-2015 
	 * 'Author      : Rahul
	 **********************************************************************************************************************************************************/
	@Test(description = "Add a MCI Triage patient in EMTrack and verify that user in EMResource recieves incoming patient notifications via email, pager and web.")
	public void testHappyDay25694() throws Exception {
		gstrTCID = "25694";
		gstrTO = "Add a MCI Triage patient in EMTrack and verify that user in EMResource recieves incoming patient notifications via email, pager and web.";

		// Objects for data
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EMTrack_data objEMTrack_data = new EMTrack_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Roles_data objRolesData = new Roles_data();

		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);

		String strRoleValue[] = new String[1];

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		EventManagement EventManagement_Page1 = new EventManagement(
				this.driver1);
		SystemNotifications SystemNotifications_page1 = new SystemNotifications(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page1 = new NavigationToSubMenus(
				this.driver1);
		System.out.println("-----Precondtion execution starts------");

		// IE 9
		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_Page1.selectFrame();

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strSetracReg);

		RegionDefault_Page1.selectFrame();

		NavigationToSubMenus_page1.navigateToIncomingPationt();

		objIncomingPatientNotifications1.selectEnabledCheckBox();
		
		objIncomingPatientNotifications1.selectManualEntryCheckBox();
		
		objIncomingPatientNotifications1.clickOnSaveButton();

		// New Role creation
		objNavigationToSubMenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);
		objRoles1.clickOnSaveBtn();

		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		// User creation
		UsersList_page1.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page1
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.selectAssociateWithOfResource(
						objResource_data.strSetracResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectIncomingPatientNotificationOption().clickSaveButton();

		UsersList_page1.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName);

		UsersList_page1.clickOnsystemNotifyPreferences();

		SystemNotifications_page1.selectEmailIncomingPatientNotification()
				.selectPagerIncomingPatientNotification().clickOnSaveButton();

		objNavigationToSubMenus1.navigateToRegDefault();

		// Firefox
		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strSetracRegion);

		EMTrackLogin_Page.navigateToPatientPage();

		Thread.sleep(10000);

		EMTrackLogin_Page.navToMCITriagePage();

		EMTrackLogin_Page.enterPatientID(objEMTrack_data.strPatientID);

		EMTrackLogin_Page.enterPatientAge(objEMTrack_data.strPatientAge);

		EMTrackLogin_Page.selRedTriageCategory();

		EMTrackLogin_Page.selIncident(objEMTrack_data.setracIncident1);

		EMTrackLogin_Page
				.selDestinationLocationForMci(objEMTrack_data.setracLocation1);

		EMTrackLogin_Page.selProviderForMci(objEMTrack_data.setracProvider1);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.setracProviderUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		EMTrackLogin_Page.clkSaveBtn();

		Thread.sleep(5000);

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		objMap1.clickOnRefreshLink();

		String strApplicationTime = EventManagement_Page1.getApplicationTime();

		String strDateAndMonth[] = strApplicationTime.split(" ");

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strDateAndMonth[0] + " " + strDateAndMonth[1]
				+ " " + strDateAndMonth[2] + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		String strArrivalTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");
		

		String strArrivalTime1 = objDts.addTimetoExisting(strApplicationTime, 6,
				"MM/dd/yyyy HH:mm");
		
		String strArrivalTime2 = objDts.addTimetoExisting(strApplicationTime, 4,
				"MM/dd/yyyy HH:mm");

		System.out.println(strArrivalTime);

		login_page1.clickLogOut();


		String strSubject =  objMailVerificationFunctions.getIPNEMailSubject(objEMTrack_data.setracLocation1);

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		String strHeader = "Incoming Patient Notification for "
				+ objEMTrack_data.setracLocation1;

		String strSubmittedTime = strApplicationTime;

		String strUnknown= "unknown";
		String strNA = "N/A";
		String strBlank = "-";
		String strImmediate = "Immediate";
		String[] strHeaderNames = { "Sent By:", "Age:", "Complaint:",
				"Triage:", "Gender:", "Level of Care:", "EMS Agency:", "EMS Unit:",  "Region:" };

		String[] strUpdatedValues = { objEMTrack_data.strQsgTester,
				objEMTrack_data.strPatientAge + " Years", strUnknown,
				strImmediate, strUnknown, strBlank, strBlank,strBlank, objTest_data.strSetracReg };

		Thread.sleep(5000);

		String mainWindowHandle2 = driver1.getWindowHandle();

		RegionDefault_Page1
				.selectFrame()
				.verWebNotificationframe()
				.verIncomingPatientNotificationMsgs(strHeader, strHeaderNames,
						strUpdatedValues, strArrivalTime, strArrivalTime1, strArrivalTime2);
		
//		.clickReviewButton();
//
//		Thread.sleep(5000);
//
//		Set<String> b = driver1.getWindowHandles();
//		Iterator<String> ite2 = b.iterator();
//
//		while (ite2.hasNext()) {
//			String popupHandle = ite2.next().toString();
//
//			if (!popupHandle.contains(mainWindowHandle2)) {
//				driver1.switchTo().window(popupHandle);
//
//			}
//		}
//
//		RegionDefault_Page1.verIncomingPatientNotificationMsgReviewPopupWindow(
//				strHeader, strSubmittedTime, strHeaderNames, strUpdatedValues,
//				strArrivalTime);
//
//		driver1.close();
//		driver1.switchTo().window(mainWindowHandle2);
		RegionDefault_Page1.clickAcknowledgeAllNotifications();
		RegionDefault_Page1.switchToDefaultFrame().selectFrame();

		login_page1.clickLogOut();

		
		
		String strMsgBody1 = objMailVerificationFunctions.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strSetracReg, strArrivalTime, strUnknown,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strImmediate, strBlank, strBlank, strBlank);
	
		String strMsgBody2 = objMailVerificationFunctions.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strSetracReg, strArrivalTime1, strUnknown,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strImmediate, strBlank, strBlank, strBlank);
		
		String strMsgBody3 = objMailVerificationFunctions.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strSetracReg, strArrivalTime, strUnknown,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strImmediate, strBlank, strBlank, strBlank);
		
		String strMsgBody4 = objMailVerificationFunctions.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strSetracReg, strArrivalTime1, strUnknown,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strImmediate, strBlank, strBlank, strBlank);
		
		String strMsgBody5 = objMailVerificationFunctions.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strSetracReg, strArrivalTime2,strUnknown ,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strImmediate, strBlank, strBlank, strBlank);
		
		String strMsgBody6 = objMailVerificationFunctions.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strSetracReg, strArrivalTime2, strUnknown,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strImmediate, strBlank, strBlank, strBlank);
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);
		
		System.out.println(strSubject);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
				if (blnMsg1 == false) {
					blnMsg1 = objMailVerificationFunctions
							.verifyMailBody(strMsgBody2);
				}
				if (blnMsg1 == false) {
					blnMsg1 = objMailVerificationFunctions
							.verifyMailBody(strMsgBody5);
				}
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
				if (blnMsg2 == false) {
					blnMsg2 = objMailVerificationFunctions
							.verifyMailBody(strMsgBody4);
				}
				if (blnMsg2 == false) {
					blnMsg2 = objMailVerificationFunctions
							.verifyMailBody(strMsgBody6);
				}
			}
			objMailVerificationFunctions.backToMailInbox();

		}

		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}
	
	/**********************************************************************************************************************************************************
	 * 'Description : Add a Evacuee patient in EMTrack and verify that user in EMResource recieves incoming patient notifications via email, pager and web. 
	 * 'Date        : 18-Mar-2015 
	 * 'Author      : Rahul
	 **********************************************************************************************************************************************************/
	@Test(description = "Add a Evacuee patient in EMTrack and verify that user in EMResource recieves incoming patient notifications via email, pager and web.")
	public void testHappyDay25695() throws Exception {
		gstrTCID = "25695";
		gstrTO = "Add a Evacuee patient in EMTrack and verify that user in EMResource recieves incoming patient notifications via email, pager and web.";

		// Objects for data
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EMTrack_data objEMTrack_data = new EMTrack_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Roles_data objRolesData = new Roles_data();

		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		
		String strRoleValue[] = new String[1];

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		EventManagement EventManagement_Page1=new EventManagement(this.driver1);
		SystemNotifications SystemNotifications_page1 = new SystemNotifications(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(this.driver1);
		
		System.out.println("-----Precondtion execution starts------");
		
		//IE 9
		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		RegionDefault_Page1.selectFrame();

		SelectRegion_page1
				.selectRegionAndNavigate(objTest_data.strSetracReg);

		RegionDefault_Page1.selectFrame();

		
		objNavigationToSubMenus1.navigateToIncomingPationt();

		objIncomingPatientNotifications1.selectEnabledCheckBox();
		
		objIncomingPatientNotifications1.selectManualEntryCheckBox();
		
		objIncomingPatientNotifications1.clickOnSaveButton();
		
		//New Role creation
		objNavigationToSubMenus1.navigateToRoles();
		
		objRoles1.clickOnCreateNewRoleBtn()
		.enterRoleName(objRolesData.strRoleName);	
		objRoles1.clickOnSaveBtn();
		
		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		// User creation
		UsersList_page1.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page1
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.selectAssociateWithOfResource(objResource_data.strSetracResourceName2)
				.clickAdvancedOptionAndExpand()		
				.selectIncomingPatientNotificationOption()
				.clickSaveButton();
		
		UsersList_page1.searchUserName(objUser_data.strNewUserName, objUser_data.strRole, objUser_data.strResourceType, 
      		  objUser_data.strUsername, objUser_data.strEquals)
      		  .editUserDetails(objUser_data.strNewUserName);
				
				
		UsersList_page1.clickOnsystemNotifyPreferences();
				
		SystemNotifications_page1.selectEmailIncomingPatientNotification()
				.selectPagerIncomingPatientNotification()
				.clickOnSaveButton();

		objNavigationToSubMenus1.navigateToRegDefault();
	
		//Firefox
		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strSetracRegion);

		EMTrackLogin_Page.navigateToPatientPage();

		Thread.sleep(10000);

		EMTrackLogin_Page.navToAddEvacueePage();
		
		EMTrackLogin_Page.enterPatientIDForEvacuee(objEMTrack_data.strPatientID);
		
		EMTrackLogin_Page.enterPatientAge(objEMTrack_data.strPatientAge);
		
		EMTrackLogin_Page.selRedTriageCategory();
		
		EMTrackLogin_Page.selIncident(objEMTrack_data.setracIncident);
		
		EMTrackLogin_Page.selDestinationLocationForMci(objEMTrack_data.setracLocation2);

		EMTrackLogin_Page.selProviderForMci(objEMTrack_data.setracProvider);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.setracProviderUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		EMTrackLogin_Page.clkSaveBtn();
		
		Thread.sleep(5000);

		System.out
				.println("-----Precondtion execution ends and execution starts------");
			
		objMap1.clickOnRefreshLink();
		
		String strApplicationTime = EventManagement_Page1.getApplicationTime();
		
		String strDateAndMonth[] = strApplicationTime.split(" ");

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strDateAndMonth[0] + " " + strDateAndMonth[1] + " " + strDateAndMonth[2] + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		String strArrivalTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");
		

		String strArrivalTime1 = objDts.addTimetoExisting(strApplicationTime, 6,
				"MM/dd/yyyy HH:mm");
		
		String strArrivalTime2 = objDts.addTimetoExisting(strApplicationTime, 4,
				"MM/dd/yyyy HH:mm");
		System.out.println(strArrivalTime);
		
		login_page1.clickLogOut();
		
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		String strHeader = "Incoming Patient Notification for "+objResource_data.strSetracResourceName2;	
		
		String strSubmittedTime = strApplicationTime;
		
		String strUnknown= "unknown";
		String strNA = "N/A";
		String strBlank = "-";
		String strImmediate = "Immediate";
		String[] strHeaderNames = { "Sent By:", "Age:", "Complaint:",
				"Triage:", "Gender:", "Level of Care:", "EMS Agency:", "EMS Unit:",  "Region:" };

		String[] strUpdatedValues = { objEMTrack_data.strQsgTester,
				objEMTrack_data.strPatientAge + " Years", strUnknown,
				strImmediate, strUnknown, strBlank, strBlank,strBlank, objTest_data.strSetracReg };
		
		Thread.sleep(5000);
		
		String mainWindowHandle2 = driver1.getWindowHandle();

		RegionDefault_Page1
				.selectFrame()
				.verWebNotificationframe()
				.verIncomingPatientNotificationMsgs(strHeader, strHeaderNames,
						strUpdatedValues, strArrivalTime, strArrivalTime1, strArrivalTime2);
//				.clickReviewButton();
//		
//		Thread.sleep(5000);
//
//		Set<String> b = driver1.getWindowHandles();
//		Iterator<String> ite2 = b.iterator();
//
//		while (ite2.hasNext()) {
//			String popupHandle = ite2.next().toString();
//
//			if (!popupHandle.contains(mainWindowHandle2)) {
//				driver1.switchTo().window(popupHandle);
//
//			}
//		}
//		
//		RegionDefault_Page1.verIncomingPatientNotificationMsgReviewPopupWindow(
//				strHeader, strSubmittedTime, strHeaderNames, strUpdatedValues,
//				strArrivalTime);		
//		
//		driver1.close();
//		driver1.switchTo().window(mainWindowHandle2);
		
		RegionDefault_Page1.clickAcknowledgeAllNotifications();
	RegionDefault_Page1.switchToDefaultFrame()
				.selectFrame();
	
	login_page1.clickLogOut();

	
		
	String strMsgBody1 = objMailVerificationFunctions.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strSetracReg, strArrivalTime, strUnknown,
			objEMTrack_data.strPatientAge+" Years", strUnknown, strImmediate, strBlank, strBlank, strBlank);

	String strMsgBody2 = objMailVerificationFunctions.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strSetracReg, strArrivalTime1, strUnknown,
			objEMTrack_data.strPatientAge+" Years", strUnknown, strImmediate, strBlank, strBlank, strBlank);
	
	String strMsgBody3 = objMailVerificationFunctions.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strSetracReg, strArrivalTime, strUnknown,
			objEMTrack_data.strPatientAge+" Years", strUnknown, strImmediate, strBlank, strBlank, strBlank);
	
	String strMsgBody4 = objMailVerificationFunctions.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strSetracReg, strArrivalTime1, strUnknown,
			objEMTrack_data.strPatientAge+" Years", strUnknown, strImmediate, strBlank, strBlank, strBlank);
	
	String strMsgBody5 = objMailVerificationFunctions.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strSetracReg, strArrivalTime2,strUnknown ,
			objEMTrack_data.strPatientAge+" Years", strUnknown, strImmediate, strBlank, strBlank, strBlank);
	
	String strMsgBody6 = objMailVerificationFunctions.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strSetracReg, strArrivalTime2, strUnknown,
			objEMTrack_data.strPatientAge+" Years", strUnknown, strImmediate, strBlank, strBlank, strBlank);
	
	objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
			objUser_data.strPrimaryPwsd);
	
	String strSubject =  objMailVerificationFunctions.getIPNEMailSubject(objResource_data.strSetracResourceName2);
	
	System.out.println(strSubject);

	objMailVerificationFunctions.NavToInbox(strSubject);

	boolean blnMsg1 = false;
	boolean blnMsg2 = false;

	for (int intCount = 0; intCount < 2; intCount++) {

		objMailVerificationFunctions.verEmail(
				objUser_data.strPrimaryMailId, strSubject);

		if (blnMsg1 == false) {
			blnMsg1 = objMailVerificationFunctions
					.verifyMailBody(strMsgBody1);
			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}
			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody5);
			}
		}

		if (blnMsg2 == false) {
			blnMsg2 = objMailVerificationFunctions
					.verifyMailBody(strMsgBody3);
			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}
			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody6);
			}
		}
		objMailVerificationFunctions.backToMailInbox();

	}

	assertTrue(blnMsg1 && blnMsg2);
	
	objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}
}