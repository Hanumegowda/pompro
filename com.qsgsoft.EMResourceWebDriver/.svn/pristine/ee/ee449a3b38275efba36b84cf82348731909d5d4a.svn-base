package requirementGroup.EMResourceIntegartionWithEMTrack;

import static org.junit.Assert.assertTrue;
import lib.dataObject.EMTrack_data;
import lib.dataObject.Login_data;
import lib.dataObject.Resource_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EMTrackLogin;
import lib.page.EventManagement;
import lib.page.IncomingPatientNotifications;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Report;
import lib.page.Resource;
import lib.page.SelectRegion;
import lib.page.SystemNotifications;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseIncomingPatientNotification extends TestNG_UI_EXTENSIONS {
	
	public EdgeCaseIncomingPatientNotification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***************************************************************************************************************
	 * 'Description : Verify that IPN column is added under ‘Setup >> Resources page’ region in which IPN is enabled.
	 * 'Date        : 19-Sep-2014 
	 * 'Author      : Anitha
	 ***************************************************************************************************************/

	@Test(description = " Verify that IPN column is added under ‘Setup >> Resources page’ region in which IPN is enabled.")
	public void testEdgeCase144047() throws Exception {
		gstrTCID = "144047";
		gstrTO = " Verify that IPN column is added under ‘Setup >> Resources page’ region in which IPN is enabled.";

		// Objects for data
		Login_data objTest_data = new Login_data();

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		Regions Regions_Page = new Regions(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(this.driver1);
		Resource Resource_Page =new Resource(this.driver1);
		
		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		RegionDefault_page.selectFrame();

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName5);

		RegionDefault_page.selectFrame();

		NavigationToSubMenus_page.navigateToRegions();

		Regions_Page.clickOnEditRegions(objTest_data.strRegionName5)

		.selectIncomingPatientNotification()

		.clickSaveButton();
		
		Resource_Page.navigateToResourceListPage()
		
		.verIPNColoumnIsPresentInResourcesPage();

		gstrResult = "PASS";
	}
	
	/******************************************************************************************
	 * 'Description : Verify that user receives the IPN notification when 'Form - Do not participate 
	 *                in forms for resources' right is enabled for the user
	 * 'Date        : 22-Oct-2014 
	 * 'Author      : Sowmya
	 ******************************************************************************************/

	@Test(description = "Verify that user receives the IPN notification when 'Form - Do not participate "
			+ "in forms for resources' right is enabled for the user")
	
	public void testEdgeCase144479() throws Exception {
		gstrTCID = "144479";
		gstrTO = "Verify that user receives the IPN notification when 'Form - Do not participate in "
				+ "forms for resources' right is enabled for the user";

		// Objects for data
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		EMTrack_data objEMTrack_data = new EMTrack_data();
		Date_Time_settings objDts = new Date_Time_settings();

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		MailVerificationFunctions MailVerificationFunctions_page1 = new MailVerificationFunctions(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strSpringfieldReg);

		RegionDefault_page.selectFrame();

		NavigationToSubMenus_page.navigateToRegions();

//		Regions_Page.clickOnEditRegions(objTest_data.strSpringfieldReg)
//				.selectIncomingPatientNotification().clickSaveButton();

		NavigationToSubMenus_page.navigateToIncomingPationt();

		objIncomingPatientNotifications.selectEnabledCheckBox();
		
		objIncomingPatientNotifications.selectManualEntryCheckBox();
		
		objIncomingPatientNotifications.clickOnSaveButton();
		
		// User creation
		UsersList_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objResource_data.strNewMexicoResource1)
				.clickAdvancedOptionAndExpand()		
				.selectReceiveIncomingPatientNotificationsOption()
				.selectFormDoNotParticipateInFormsForResourcesOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickOnsystemNotifyPreferences();

		SystemNotifications_page.selectEmailIncomingPatientNotification()
				.selectPagerIncomingPatientNotification();

		SystemNotifications_page.clickOnSaveButton();

		login_page.clickLogOut();

		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strRegion);

		EMTrackLogin_Page.navigateToPatientPage();

		Thread.sleep(10000);

		EMTrackLogin_Page.navToAddDailyPatientPage();

//		EMTrackLogin_Page.enterPatientID(objEMTrack_data.strPatientID);

		EMTrackLogin_Page.enterPatientAge(objEMTrack_data.strPatientAge);
		
		EMTrackLogin_Page.selGender(objEMTrack_data.strMale);

		EMTrackLogin_Page.selDestinationLocation(objEMTrack_data.location1);

		EMTrackLogin_Page.selProvider(objEMTrack_data.provider1);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.strUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		String strApplicationTime = EMTrackLogin_Page.getApplcnTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");
		strApplicationTime = objDts.addTimetoExistingHour(strApplicationTime, -1, "MM/dd/yyyy HH:mm");
		String strApplicationTime1 = objDts.addTimetoExisting(strApplicationTime, 1,
				"MM/dd/yyyy HH:mm");
		strApplicationTime = strApplicationTime + " " + "MST";
		strApplicationTime1= strApplicationTime1+ " " + "MST";
		System.out.println(strApplicationTime);
		System.out.println(strApplicationTime1);

		EMTrackLogin_Page.clkSaveBtn();
		
		EMTrackLogin_Page.clickLogOutLink();

		System.out
				.println("-----Precondtion execution ends and execution starts------");
System.out.println(objUser_data.strNewUserName);
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		objEventManagement1.verWebNotificationframe()
		                   .verIncomingPatientNotification(objResource_data.strNewMexicoResource1)
						   .clickAcknowledgeAllNotifications()
						   .selectFrame();

		String strSubject = "Incoming Patient Notification for "+objResource_data.strNewMexicoResource1;


		String strUnknown= "unknown";
		String strNA = "N/A";
		String strBlank = "-";
		
		String strMsgBody1 = MailVerificationFunctions_page1.getIPNMail(objEMTrack_data.strQsgTester, objTest_data.strSpringfieldReg, strApplicationTime, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
	
		String strMsgBody2 = MailVerificationFunctions_page1.getIPNMail(objEMTrack_data.strQsgTester, objTest_data.strSpringfieldReg, strApplicationTime1, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		String strMsgBody3 = MailVerificationFunctions_page1.getIPNPager(objEMTrack_data.strQsgTester, objTest_data.strSpringfieldReg, strApplicationTime, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		String strMsgBody4 = MailVerificationFunctions_page1.getIPNPager(objEMTrack_data.strQsgTester, objTest_data.strSpringfieldReg, strApplicationTime1, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		MailVerificationFunctions_page1.loginToMail(
				objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);

		MailVerificationFunctions_page1.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			MailVerificationFunctions_page1.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = MailVerificationFunctions_page1
						.verifyMailBody(strMsgBody1);
				if (blnMsg1 == false) {
					blnMsg1 = MailVerificationFunctions_page1
							.verifyMailBody(strMsgBody2);
				}
			}

			if (blnMsg2 == false) {
				blnMsg2 = MailVerificationFunctions_page1
						.verifyMailBody(strMsgBody3);
				if (blnMsg2 == false) {
					blnMsg2 = MailVerificationFunctions_page1
							.verifyMailBody(strMsgBody4);
				}
			}
			MailVerificationFunctions_page1.backToMailInbox();

		}
		assertTrue(blnMsg1 && blnMsg2);

		MailVerificationFunctions_page1.logoutMail();
		gstrResult = "PASS";
	}
	
	

	/******************************************************************************************
	 * 'Description :  	Verify that user with right ‘Report - Incoming Patient Notification Detail’ can generate IPN report in Excel format. 
	 * 'Date        : 24-Nov-2014 
	 * 'Author      : Anil
	 ******************************************************************************************/

	@Test(description = "Verify that user with right ‘Report - Incoming Patient Notification Detail’ can generate IPN report in Excel format. ")
	
	public void testEdgecase144055() throws Exception {
		gstrTCID = "144055";
		gstrTO = "Verify that user with right ‘Report - Incoming Patient Notification Detail’ can generate IPN report in Excel format. ";

		// Objects for data
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		EMTrack_data objEMTrack_data = new EMTrack_data();
		Date_Time_settings objDts = new Date_Time_settings();

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);

		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report Report_Page1 = new Report(this.driver1);
		
		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strSpringfieldReg);

		RegionDefault_page.selectFrame();


		NavigationToSubMenus_page.navigateToIncomingPationt();

		objIncomingPatientNotifications.selectEnabledCheckBox();
		
		objIncomingPatientNotifications.selectManualEntryCheckBox();
		
		objIncomingPatientNotifications.clickOnSaveButton();

		// User creation
		UsersList_page.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objResource_data.strNewMexicoResource)
				.selectViewResourceRights(
						objResource_data.strNewMexicoResource)
				.selectAssosciateResourceRight(objResource_data.strNewMexicoResource)		
				.selectRunReportRight(
						objResource_data.strNewMexicoResource)
				.clickAdvancedOptionAndExpand()					
				.selectReceiveIncomingPatientNotificationsOption()
				.selectReportIncomingPatientNotificationOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickOnsystemNotifyPreferences();

		SystemNotifications_page.selectEmailIncomingPatientNotification()
				.selectPagerIncomingPatientNotification();

		SystemNotifications_page.clickOnSaveButton();

		UsersList_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objResource_data.strNewMexicoResource)
				.selectViewResourceRights(
						objResource_data.strNewMexicoResource)
				.selectAssosciateResourceRight(objResource_data.strNewMexicoResource)		
				.clickAdvancedOptionAndExpand()	
				.selectIncomingPatientNotificationOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName1)
				.clickOnsystemNotifyPreferences();

		SystemNotifications_page.selectEmailIncomingPatientNotification()
				.selectPagerIncomingPatientNotification();

		SystemNotifications_page.clickOnSaveButton();

		login_page.clickLogOut();

		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strRegion);

		EMTrackLogin_Page.navigateToPatientPage();

		Thread.sleep(10000);

		EMTrackLogin_Page.navToAddDailyPatientPage();

		EMTrackLogin_Page.selGender(objEMTrack_data.strMale);

		EMTrackLogin_Page.enterPatientAge(objEMTrack_data.strPatientAge);
		
		EMTrackLogin_Page.selDestinationLocation(objEMTrack_data.location2);

		EMTrackLogin_Page.selProvider(objEMTrack_data.strNewMexicoProvider);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.setracProviderUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		String strApplicationTime = EMTrackLogin_Page.getApplcnTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");


		System.out.println(strApplicationTime);

		EMTrackLogin_Page.clkSaveBtn();
		
		EMTrackLogin_Page.clickLogOutLink();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		objEventManagement1.verWebNotificationframe()
		                   .verIncomingPatientNotification(objResource_data.strNewMexicoResource)
						   .clickAcknowledgeAllNotifications()
		                   .selectFrame();

		objNavigationToSubMenus1.clickOnReports();
		
		Report_Page1.verifyResourceReportLinkIsNotDisplayed();
		
		login_page1.clickLogOut();
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		objEventManagement1.verWebNotificationframe()
		                   .verIncomingPatientNotification(objResource_data.strNewMexicoResource)
						   .clickAcknowledgeAllNotifications()
						   .selectFrame();

		objNavigationToSubMenus1.clickOnResourceReports();
		
		Report_Page1.clickOnIPNLink();
	
		gstrResult = "PASS";
	}
	
	/******************************************************************************************
	 * 'Description : Verify that 'PDF' report format is no longer available while generating IPN reports.
	 * 'Date        : 30-June-2015 
	 * 'Author      : Sangappa.k
	 ******************************************************************************************/

	@Test(description = "Verify that 'PDF' report format is no longer available while generating IPN reports.")
	public void testEdgeCase163144() throws Exception {
		gstrTCID = "163144";
		gstrTO = "Verify that 'PDF' report format is no longer available while generating IPN reports.";

		// Objects for data
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		// Objects for Page
		Login login_page1 = new Login(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page1 = new NavigationToSubMenus(
				this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);

		Report Report_Page1 = new Report(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strSetracReg);

		RegionDefault_page1.selectFrame();

		// User creation
		UsersList_page1.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page1
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectRunReportRight(objResource_data.strSetracResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectReportIncomingPatientNotificationOption()
				.clickSaveButton();

		NavigationToSubMenus_page1.clickOnResourceReports();
		Report_Page1.verifyResourceReportMenuPage()
				.clickOnIncomingPatientNotificationDetails();

		Report_Page1.verifyIncomingPatientNotificatioDetailsReportPage();

		Report_Page1.verifyPDFReportFormatIsNotThierInIPNReportPage();

		login_page1.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		NavigationToSubMenus_page1.clickOnResourceReports();
		Report_Page1.verifyResourceReportMenuPage()
				.clickOnIncomingPatientNotificationDetails();

		Report_Page1.verifyIncomingPatientNotificatioDetailsReportPage();

		Report_Page1.verifyPDFReportFormatIsNotThierInIPNReportPage();

		login_page1.clickLogOut();

		gstrResult = "PASS";

	}
}
