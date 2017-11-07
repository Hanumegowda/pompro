package requirementGroup.EMResourceIntegartionWithEMTrack;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.Properties;

import lib.dataObject.EMTrack_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.EMTrackLogin;
import lib.page.EventManagement;
import lib.page.IncomingPatientNotifications;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Report;
import lib.page.Resource;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.SystemNotifications;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayIncomingPatientNotification extends TestNG_UI_EXTENSIONS{

	public HappyDayIncomingPatientNotification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/******************************************************************************************
	 * 'Description : Verify that user incoming patient notification is not received by the user 
	 *                if the Incoming patient notification option is not enabled for that region
	 * 'Date        : 18-Sep-2014 
	 * 'Author      : Anitha
	 ******************************************************************************************/

	@Test(description = "Verify that user incoming patient notification is not received by the user if the Incoming"
			+ " patient notification option is not enabled for that region.")
	public void testHappyDay144032() throws Exception {
		gstrTCID = "144032";
		gstrTO = "Verify that user incoming patient notification is not received by the user if the Incoming patient"
				+ " notification option is not enabled for that region.";

		// Objects for data
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		EMTrack_data objEMTrack_data = new EMTrack_data();

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(this.driver1);
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_Page1=new EventManagement(this.driver1);
		MailVerificationFunctions MailVerificationFunctions_page1 = new MailVerificationFunctions(
				this.driver1);

		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName5);

		RegionDefault_page.selectFrame();

		NavigationToSubMenus_page.navigateToIncomingPationt();

		objIncomingPatientNotifications.deselectEnabledCheckBox();
		
		objIncomingPatientNotifications.deselectManualEntryCheckBox();
		
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

				.selectViewResourceCheckBox(
						objResource_data.strColoradoResource)
						
				.selectRunReportsCheckBox(
						objResource_data.strColoradoResource)

				.clickSaveButton();

		login_page.clickLogOut();
		
		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strColoradoRegion);

		EMTrackLogin_Page.navigateToPatientPage();

		EMTrackLogin_Page.navToMCITriagePage();

		EMTrackLogin_Page.enterPatientID(objEMTrack_data.strPatientID);

		EMTrackLogin_Page.selDestinationLocationForMci(objEMTrack_data.location);

		EMTrackLogin_Page.selProviderForMci(objEMTrack_data.provider);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.strUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		EMTrackLogin_Page.clkSaveBtn();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		Thread.sleep(60000);
		
		EventManagement_Page1.verWebNotificationframeNotPresent();

		String strSubject = "Incoming Patient Notification for "+objResource_data.strColoradoResource;
		
		MailVerificationFunctions_page1.loginToMail(
				objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		MailVerificationFunctions_page1
				.NavToInboxAndVerEmailIsNotPresent(strSubject);

		MailVerificationFunctions_page1.logoutMail();

		gstrResult = "PASS";
	}
	
	/******************************************************************************************
	 * 'Description :  Verify that user with appropriate right and without affiliated right on 
	 *              resource do not receive IPN notification when a patient is added in EMTrack
	 * 'Date        : 18-Sep-2014 
	 * 'Author      : Anitha
	 ******************************************************************************************/

	@Test(description = " Verify that user with appropriate right and without affiliated right on"
			+ " resource do not receive IPN notification when a patient is added in EMTrack.")
	public void testHappyDay144045() throws Exception {
		gstrTCID = "144045";
		gstrTO = "Verify that user with appropriate right and without affiliated right on resource do"
				+ " not receive IPN notification when a patient is added in EMTrack.";

		// Objects for data
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		EMTrack_data objEMTrack_data = new EMTrack_data();

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_Page1=new EventManagement(this.driver1);
		MailVerificationFunctions MailVerificationFunctions_page1 = new MailVerificationFunctions(
				this.driver1);

		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName5);

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

				.selectViewResourceCheckBox(
						objResource_data.strColoradoResource)

				.clickSaveButton();

//				.searchUserName(objUser_data.strNewUserName,
//						objUser_data.strRole, objUser_data.strResourceType,
//						objUser_data.strUsername, objUser_data.strsearchOption)
//
//				.editUserDetails(objUser_data.strNewUserName)
//
//				.clickOnsystemNotifyPreferences();
//
//		SystemNotifications_page.selectEmailIncomingPatientNotification()
//
//		.clickOnSaveButton();

		login_page.clickLogOut();

		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strColoradoRegion);

		Thread.sleep(5000);
		
		EMTrackLogin_Page.navigateToPatientPage();

		EMTrackLogin_Page.navToMCITriagePage();

		EMTrackLogin_Page.enterPatientID(objEMTrack_data.strPatientID);

		EMTrackLogin_Page.selDestinationLocationForMci(objEMTrack_data.location);

		EMTrackLogin_Page.selProviderForMci(objEMTrack_data.provider);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.strUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		EMTrackLogin_Page.clkSaveBtn();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		Thread.sleep(60000);
		
		EventManagement_Page1.verWebNotificationframeNotPresent();

		MailVerificationFunctions_page1.loginToMail(
				objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);

		String strSubject = "Incoming Patient Notification for Memorial Hospital North^";

		MailVerificationFunctions_page1
				.NavToInboxAndVerEmailIsNotPresent(strSubject);

		MailVerificationFunctions_page1.logoutMail();

		gstrResult = "PASS";
	}
	
	
	/******************************************************************************************
	 * 'Description : Verify that user cannot generate IPN report when 'Run Report' right on resource is not given 
	 * 'Date        : 18-Sep-2014 
	 * 'Author      : Anil
	 ******************************************************************************************/

	@Test( description = "Verify that user cannot generate IPN report when 'Run Report' right on resource is not given ")
	public void testHappyDay144536() throws Exception {
		gstrTCID = "144536";
		gstrTO = "Verify that user cannot generate IPN report when 'Run Report' right on resource is not given ";

		// Objects for Page
		Login login_page = new Login(this.driver1);
		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		
		EventManagement EventManagement_Page1 = new EventManagement(this.driver1);
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_Page1 = new NavigationToSubMenus(
				this.driver1);
		Report Report_Page1 = new Report(this.driver1);
		
		EMTrack_data objEMTrack_data = new EMTrack_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings dts = new Date_Time_settings();
		
		String strPatientID = objEMTrack_data.strPatientID;
		String strDestination = objEMTrack_data.location;
		String strProvider = objEMTrack_data.provider;
		String strUnit = objEMTrack_data.strUnit;
		String strETA = objEMTrack_data.strETA3;
				
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName5);

		RegionDefault_page.selectFrame();

		NavigationToSubMenus_page.navigateToIncomingPationt();

		objIncomingPatientNotifications.selectEnabledCheckBox();
		
		objIncomingPatientNotifications.selectManualEntryCheckBox();
		
		objIncomingPatientNotifications.clickOnSaveButton();
		
		UsersList_page.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()

		.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

		.selectFirstRole()

		.selectRunReportsCheckBox(objResource_data.strColoradoResource)
		
		.clickAdvancedOptionAndExpand()
		
		.selectIncomingPatientNotificationOption()
		
		.selectReportIncomingPatientNotificationOption()
		
		.selectReceiveIncomingPatientNotificationsOption()
		
		.clickSaveButton();
		
		login_page.clickLogOut();
		
		//Firefox
		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strColoradoRegion);
		
		Thread.sleep(5000);
		EMTrackLogin_Page.navigateToPatientPage();

		EMTrackLogin_Page.navToMCITriagePage();
		
		EMTrackLogin_Page.enterPatientID(strPatientID);
		
		EMTrackLogin_Page.selDestinationLocationForMci(strDestination);
		
		EMTrackLogin_Page.selProviderForMci(strProvider);
		
		EMTrackLogin_Page.enterUnitValue(strUnit);
		
		EMTrackLogin_Page.enterETAValue(strETA);
		
		EMTrackLogin_Page.clkSaveBtn();	
		
		EMTrackLogin_Page.clickLogOutLink();
		Thread.sleep(5000);
//		objUser_data.strNewUserName= "Auto1440497941027";
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
						objUser_data.strNewPassword);
		
//		RegionDefault_Page1.selectFrame();
//		
//		RegionDefault_Page1.verWebNotificationframe();
//		
//		RegionDefault_Page1.clickAcknowledgeAllNotifications();
//		Thread.sleep(5000);
		RegionDefault_Page1.selectFrame();
		
		NavigationToSubMenus_Page1.clickOnResourceReports();
		
		Report_Page1.clickOnIPNLink();
		
		String strCurrentDate = EventManagement_Page1.getApplicationTime();
		
		String strDateAndMonth[] = strCurrentDate.split(" ");
		
		String strCurrentYear = dts.timeNow("yyyy");
		
		strCurrentDate = strDateAndMonth[0]+"/"+strDateAndMonth[1]+"/"+strCurrentYear;
		
		strCurrentDate = dts.converDateFormat(strCurrentDate, "dd/MMM/yyyy", "MM/dd/yyyy");
		
		strCurrentDate = strCurrentDate.replace(" ", "");
		
		Report_Page1.verrifyIncomingPatientNotificationPage()
		
		.enterReportStartDate(strCurrentDate)
		
		.enterReportEndDate(strCurrentDate)
		
		.clickOnFilterButton()
		
		.verrifyIncomingPatientNotificationPage()
		
		.verifyResourceNameIsDisplayed(objResource_data.strColoradoResource)
		
		.verifyResourceNameNotDisplayed(objResource_data.strColoradoResource1);
		
		login_page1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/******************************************************************************************
	 * 'Description : Verify that user with appropriate right receives web mail notification when 
	 *                patient is submitted from EMTrack
	 * 'Date        : 20-Oct-2014 
	 * 'Author      : Sowmya
	 ******************************************************************************************/

	@Test( description = "Verify that user with appropriate right receives web mail notification when "
			+ "patient is submitted from EMTrack")
	
	public void testHappyDay147972() throws Exception {
		gstrTCID = "147972";
		gstrTO = "Verify that user with appropriate right receives web mail notification when patient "
				+ "is submitted from EMTrack";

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
				.selectRegionAndNavigate(objTest_data.strNewMexicoReg);

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
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objResource_data.strNewMexicoResource)
				.clickAdvancedOptionAndExpand()		
				.selectReceiveIncomingPatientNotificationsOption()
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


		EMTrackLogin_Page.navToAddDailyPatientPage();

		EMTrackLogin_Page.selGender(objEMTrack_data.strMale);

		EMTrackLogin_Page.enterPatientAge(objEMTrack_data.strPatientAge);
		
		EMTrackLogin_Page.selDestinationLocation(objEMTrack_data.strNewMexicoLoc);

		EMTrackLogin_Page.selProvider(objEMTrack_data.strNewMexicoProvider);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.setracProviderUnit);

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
		strApplicationTime = strApplicationTime + " " + "MDT";
		strApplicationTime1= strApplicationTime1+ " " + "MDT";
		System.out.println(strApplicationTime);
		System.out.println(strApplicationTime1);
		EMTrackLogin_Page.clkSaveBtn();
		
		EMTrackLogin_Page.clickLogOutLink();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		objEventManagement1.verWebNotificationframe()
		                   .verIncomingPatientNotification(objResource_data.strNewMexicoResource)
						   .clickAcknowledgeAllNotifications()
						   .selectFrame();
		
		String strSubject = MailVerificationFunctions_page1.getIPNEMailSubject(objResource_data.strSpringfieldResource);

//		String strMsgBody1 = "Message from system"
//				+ "\n\n"
//				+ "Please do not reply to this email message. You must log into "
//				+ "EMResource to take any action that may be required."
//				+ "\n\n" + "Sent By: " + objEMTrack_data.strQsgTester
//				+ "\nAge: " + "unknown" + "\nEstimated Time of Arrival: "
//				+ strApplicationTime + "\nChief Complaint: " + "unknown"
//				+ "\nTriage: " + "N/A" + "\nGender: " + objEMTrack_data.strMale
//				+ "\n\nRegion: " + objTest_data.strSpringfieldReg;

//		String strMsgBody2 = "sent by: " + objEMTrack_data.strQsgTester
//				+ " | age: " + "unknown" + " | arrival: " + strApplicationTime
//				+ " | complaint: " + "unknown" + " | triage: " + "N/A"
//				+ " | gender: " + objEMTrack_data.strMale + " | region: "
//				+ objTest_data.strSpringfieldReg;
String strUnknown= "unknown";
String strNA = "N/A";
String strBlank = "-";
//String strApplicationTime="08/28/2015 03:43 MST";

		String strMsgBody1 = MailVerificationFunctions_page1.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strSpringfieldReg, strApplicationTime, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
	
		String strMsgBody2 = MailVerificationFunctions_page1.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strSpringfieldReg, strApplicationTime1, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		String strMsgBody3 = MailVerificationFunctions_page1.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strSpringfieldReg, strApplicationTime, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		String strMsgBody4 = MailVerificationFunctions_page1.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strSpringfieldReg, strApplicationTime1, objEMTrack_data.strMale,
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
	 * 'Description : Verify that user who have ‘Receive Incoming Patient Notifications’ and 
	 *                affiliated right on resources is able to receive IPN notification
	 * 'Date        : 21-Oct-2014 
	 * 'Author      : Sowmya
	 ******************************************************************************************/

	@Test(description = " Verify that user who have ‘Receive Incoming Patient Notifications’ and "
			+ "affiliated right on resources is able to receive IPN notification")
	
	public void testHappyDay144052() throws Exception {
		gstrTCID = "144052";
		gstrTO = " Verify that user who have ‘Receive Incoming Patient Notifications’ and affiliated "
				+ "right on resources is able to receive IPN notification";

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
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objResource_data.strNewMexicoResource)
				.selectViewResourceCheckBox(
						objResource_data.strNewMexicoResource)
				.selectAssociateWithOfResource(objResource_data.strNewMexicoResource)		
				.selectRunReportsCheckBox(
						objResource_data.strNewMexicoResource)
				.clickAdvancedOptionAndExpand()		
				.selectReceiveIncomingPatientNotificationsOption()
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

		EMTrackLogin_Page.selGender(objEMTrack_data.strMale);

		EMTrackLogin_Page.enterPatientAge(objEMTrack_data.strPatientAge);
		
		EMTrackLogin_Page.selDestinationLocation(objEMTrack_data.strNewMexicoLoc);

		EMTrackLogin_Page.selProvider(objEMTrack_data.strNewMexicoProvider);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.setracProviderUnit);

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
		strApplicationTime = strApplicationTime + " " + "MDT";
		strApplicationTime1= strApplicationTime1+ " " + "MDT";
		System.out.println(strApplicationTime);
		System.out.println(strApplicationTime1);

		EMTrackLogin_Page.clkSaveBtn();
		
		EMTrackLogin_Page.clickLogOutLink();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		objEventManagement1.verWebNotificationframe()
		                   .verIncomingPatientNotification(objResource_data.strNewMexicoResource)
						   .clickAcknowledgeAllNotifications()
						   .selectFrame();

		String strSubject = MailVerificationFunctions_page1.getIPNEMailSubject(objResource_data.strSpringfieldResource);

//		String strMsgBody1 = "Message from system"
//				+ "\n\n"
//				+ "Please do not reply to this email message. You must log into "
//				+ "EMResource to take any action that may be required."
//				+ "\n\n" + "Sent By: " + objEMTrack_data.strQsgTester
//				+ "\nAge: " + objEMTrack_data.strPatientAge + "\nEstimated Time of Arrival: "
//				+ strApplicationTime + "\nChief Complaint: " + "unknown"
//				+ "\nTriage: " + "N/A" + "\nGender: " + objEMTrack_data.strMale
//				+ "\n\nRegion: " + objTest_data.strSpringfieldReg;
//
//		String strMsgBody2 = "sent by: " + objEMTrack_data.strQsgTester
//				+ " | age: " + objEMTrack_data.strPatientAge + " | arrival: " + strApplicationTime
//				+ " | complaint: " + "unknown" + " | triage: " + "N/A"
//				+ " | gender: " + objEMTrack_data.strMale + " | region: "
//				+ objTest_data.strSpringfieldReg;

		String strUnknown= "unknown";
		String strNA = "N/A";
		String strBlank = "-";
		
		String strMsgBody1 = MailVerificationFunctions_page1.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strSpringfieldReg, strApplicationTime, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
	
		String strMsgBody2 = MailVerificationFunctions_page1.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strSpringfieldReg, strApplicationTime1, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		String strMsgBody3 = MailVerificationFunctions_page1.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strSpringfieldReg, strApplicationTime, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		String strMsgBody4 = MailVerificationFunctions_page1.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strSpringfieldReg, strApplicationTime1, objEMTrack_data.strMale,
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
	 * 'Description : Verify that user receives the IPN notifications to the updated notification 
	 *                method when a patient is added / submitted from EMTrack
	 * 'Date        : 27-Oct-2014 
	 * 'Author      : Sowmya
	 ******************************************************************************************/

	@Test(description = "Verify that user receives the IPN notifications to the updated notification "
			+ "method when a patient is added / submitted from EMTrack")
	
	public void testHappyDay144034() throws Exception {
		gstrTCID = "144034";
		gstrTO = "Verify that user receives the IPN notifications to the updated notification method "
				+ "when a patient is added / submitted from EMTrack";

		// Objects for data
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		
		EMTrack_data objEMTrack_data = new EMTrack_data();
		Date_Time_settings objDts = new Date_Time_settings();

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(this.driver1);
		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(this.driver1);
		Resource objResource = new Resource(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		MailVerificationFunctions MailVerificationFunctions_page1 = new MailVerificationFunctions(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		SystemNotifications SystemNotifications_page1 = new SystemNotifications(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		
		EMTrackLogin EMTrackLogin_Page1 = new EMTrackLogin(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strNewMexicoReg);

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
				.enterEmail(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objResource_data.strNewMexicoResource)
				.clickAdvancedOptionAndExpand()
				.selectReceiveIncomingPatientNotificationsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickOnsystemNotifyPreferences();

		SystemNotifications_page.selectEmailIncomingPatientNotification()
		                        .clickOnSaveButton();

		NavigationToSubMenus_page.navigateToResourceInSetup();

		objResource
				.selectUsersLinkInResourceList(
						objResource_data.strNewMexicoResource)
				.deselectAllAssociatedWithOption()
				.deselectAllRunReportsOption().deselectAllUpdateStatusOption()
				.deselectAllViewResourceOption()
		        .selectUpdateStatusOfResource(objUser_data.strNewUserName)
				.selectViewResourceCheckBox(objUser_data.strNewUserName)
	 	        .clickOnSaveButton();

		login_page.clickLogOut();
		
		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strNewMexicoReg);

		EMTrackLogin_Page.navigateToPatientPage();


		EMTrackLogin_Page.navToAddDailyPatientPage();


		EMTrackLogin_Page.selGender(objEMTrack_data.strMale);

		EMTrackLogin_Page.selDestinationLocation(objEMTrack_data.location2);

		EMTrackLogin_Page.selProvider(objEMTrack_data.strProvider2);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.strUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		String strApplicationTime = EMTrackLogin_Page.convertApplcnTimeFromCDTtoMDT();
		
		EMTrackLogin_Page.clkSaveBtn();
		
		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");
		String strApplicationTime1 = objDts.addTimetoExisting(strApplicationTime, 1,
				"MM/dd/yyyy HH:mm");
		strApplicationTime = strApplicationTime + " " + "MST";
		
		strApplicationTime1 = strApplicationTime1 + " " + "MST";
		System.out.println(strApplicationTime);

		EMTrackLogin_Page.clickLogOutLink();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		objEventManagement1
				.verWebNotificationframe()
				.verIncomingPatientNotification(objResource_data.strNewMexicoResource)
				.clickAcknowledgeAllNotifications()
				.selectFrame();

		login_page1.clickLogOut();
		
		String strSubject = "Incoming Patient Notification for "+objResource_data.strNewMexicoResource;

//		String strMsgBody1 = "Message from system"
//				+ "\n\n"
//				+ "Please do not reply to this email message. You must log into "
//				+ "EMResource to take any action that may be required."
//				+ "\n\n" + "Sent By: " + objEMTrack_data.strQsgTester
//				+ "\nAge: " + "unknown" + "\nEstimated Time of Arrival: "
//				+ strApplicationTime + "\nChief Complaint: " + "unknown"
//				+ "\nTriage: " + "N/A" + "\nGender: " + objEMTrack_data.strMale
//				+ "\n\nRegion: " + objTest_data.strNewMexicoReg;

		String strUnknown= "unknown";
		String strNA = "N/A";
		String strBlank = "-";
		
		String strMsgBody1 = MailVerificationFunctions_page1.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strNewMexicoReg, strApplicationTime, objEMTrack_data.strMale,
				strUnknown, strUnknown, strNA, strBlank, strBlank, strBlank);
	
		String strMsgBody2 = MailVerificationFunctions_page1.getIPNMail(objEMTrack_data.strQsgTester,  objTest_data.strSpringfieldReg, strApplicationTime1, objEMTrack_data.strMale,
				strUnknown, strUnknown, strNA, strBlank, strBlank, strBlank);
		
		MailVerificationFunctions_page1.loginToMail(
				objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);

		MailVerificationFunctions_page1.NavToInbox(strSubject);

		boolean blnMsg1 = false;

		for (int intCount = 0; intCount < 1; intCount++) {

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
			MailVerificationFunctions_page1.backToMailInbox();

		}
		assertTrue(blnMsg1);

		MailVerificationFunctions_page1.logoutMail();

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page1.selectFrame();
		
		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strNewMexicoReg);
		
		RegionDefault_page1.selectFrame();
		
		Thread.sleep(5000);

		// User creation
		UsersList_page1.navigateToUsers();

		String strPrimaryMailId = "";

		UsersList_page1
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.enterEmail(strPrimaryMailId)
				.clickSaveButton()
				.editUserDetails(objUser_data.strNewUserName)
				.clickOnsystemNotifyPreferences();

		SystemNotifications_page1.deselectEmailIncomingPatientNotification()
			              	     .selectPagerIncomingPatientNotification();

		SystemNotifications_page1.clickOnSaveButton();

		login_page1.clickLogOut();

		EMTrackLogin_Page1.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page1.changeLocation(objEMTrack_data.strNewMexicoReg);

		EMTrackLogin_Page1.navigateToPatientPage();

		Thread.sleep(10000);

		EMTrackLogin_Page1.navToAddDailyPatientPage();

		EMTrackLogin_Page1.selGender(objEMTrack_data.strMale);

		EMTrackLogin_Page1.selDestinationLocation(objEMTrack_data.location2);

		EMTrackLogin_Page1.selProvider(objEMTrack_data.strProvider2);

		EMTrackLogin_Page1.enterUnitValue(objEMTrack_data.strUnit);

		EMTrackLogin_Page1.enterETAValue(objEMTrack_data.strETA3);

		strApplicationTime1 = EMTrackLogin_Page1.convertApplcnTimeFromCDTtoMDT();
		
		EMTrackLogin_Page1.clkSaveBtn();

		strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");
		strApplicationTime1 = objDts.addTimetoExisting(strApplicationTime, 1,
				"MM/dd/yyyy HH:mm");
		strApplicationTime = strApplicationTime + " " + "MST";
		
		strApplicationTime1 = strApplicationTime1 + " " + "MST";
		
		System.out.println(strApplicationTime);

		EMTrackLogin_Page1.clickLogOutLink();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		objEventManagement1
				.verWebNotificationframe()
				.verIncomingPatientNotification(objResource_data.strNewMexicoResource)
				.clickAcknowledgeAllNotifications().selectFrame();
		login_page1.clickLogOut();
		
//		String strMsgBody2 = "sent by: " + objEMTrack_data.strQsgTester
//				+ " | age: " + "unknown" + " | arrival: " + strApplicationTime1
//				+ " | complaint: " + "unknown" + " | triage: " + "N/A"
//				+ " | gender: " + objEMTrack_data.strMale + " | region: "
//				+ objTest_data.strNewMexicoReg;
		
		String strMsgBody3 = MailVerificationFunctions_page1.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strSpringfieldReg, strApplicationTime, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		String strMsgBody4 = MailVerificationFunctions_page1.getIPNPager(objEMTrack_data.strQsgTester,  objTest_data.strSpringfieldReg, strApplicationTime1, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge+" Years", strUnknown, strNA, strBlank, strBlank, strBlank);
		
		MailVerificationFunctions_page1.loginToMail(
				objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);

		MailVerificationFunctions_page1.NavToInbox(strSubject);

		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 1; intCount++) {

			MailVerificationFunctions_page1.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

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
		assertTrue(blnMsg2);

		MailVerificationFunctions_page1.logoutMail();

		gstrResult = "PASS";
	}
	
	/******************************************************************************************
	 * 'Description : verify that user receives previous unacknowledged IPN notifications when ‘Receive 
	 *                Incoming Patient Notifications’ and affiliated right on resources is provided.
	 * 'Date        : 29-Oct-2014 
	 * 'Author      : Sowmya
	 ******************************************************************************************/

	@Test(description = "verify that user receives previous unacknowledged IPN notifications when "
			+ "‘Receive Incoming Patient Notifications’ and affiliated right on resources is provided.")
	
	public void testHappyDay144277() throws Exception {
		gstrTCID = "144277";
		gstrTO = "verify that user receives previous unacknowledged IPN notifications when ‘Receive "
				+ "Incoming Patient Notifications’ and affiliated right on resources is provided.";

		// Objects for data
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		EMTrack_data objEMTrack_data = new EMTrack_data();

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page1 = new NavigationToSubMenus(
				this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(this.driver1);
		
		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strNewMexicoReg);

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
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption);

		NavigationToSubMenus_page.navigateToResourceInSetup();

		objResource
				.selectUsersLinkInResourceList(
						objResource_data.strNewMexicoResource1)
				.deselectAllAssociatedWithOption()
				.deselectAllRunReportsOption().deselectAllUpdateStatusOption()
				.deselectAllViewResourceOption()
				.selectViewResourceCheckBox(objUser_data.strNewUserName)
				.clickOnSaveButton();

		login_page.clickLogOut();

		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strNewMexicoReg);

		EMTrackLogin_Page.navigateToPatientPage();

		EMTrackLogin_Page.navToAddDailyPatientPage();

		EMTrackLogin_Page.selGender(objEMTrack_data.strMale);

		EMTrackLogin_Page
				.selDestinationLocation(objEMTrack_data.strNewMexicolocation3);

		EMTrackLogin_Page.selProvider(objEMTrack_data.strProvider2);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.strUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		EMTrackLogin_Page.clkSaveBtn();

		EMTrackLogin_Page.clickLogOutLink();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		objEventManagement.verWebNotificationframeNotPresent();

		login_page1.clickLogOut();
		
		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page1.selectFrame();

		SelectRegion_page1
				.selectRegionAndNavigate(objTest_data.strNewMexicoReg);

		RegionDefault_page1.selectFrame();

		NavigationToSubMenus_page1.navigateToIncomingPationt();

		objIncomingPatientNotifications1.selectEnabledCheckBox();
		
		objIncomingPatientNotifications1.selectManualEntryCheckBox();
		
		objIncomingPatientNotifications1.clickOnSaveButton();

		// User creation
		UsersList_page1.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page1
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectUpdateStatusOfResource(
						objResource_data.strNewMexicoResource1)
				.selectViewResourceCheckBox(
						objResource_data.strNewMexicoResource1)
				.selectAssociateWithOfResource(
						objResource_data.strNewMexicoResource1)
				.selectRunReportsCheckBox(
						objResource_data.strNewMexicoResource1)
				.clickAdvancedOptionAndExpand()
				.selectReceiveIncomingPatientNotificationsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption);

		login_page1.clickLogOut();

		login_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		objEventManagement1.verWebNotificationframe()
				           .clickAcknowledgeAllNotifications()
				           .selectFrame();

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	
	/******************************************************************************************
	 * 'Description :  	Verify that user with right ‘Report - Incoming Patient Notification Detail’ can generate IPN report in PDF format. 
	 * 'Date        : 24-Nov-2014 
	 * 'Author      : Anil                           
	 * Modified by : Sangappa k                  Date of Modifiaction : 10-May-2016
	 ******************************************************************************************/
//Redundent test case  
	@Test( description = "Verify that user with right ‘Report - Incoming Patient Notification Detail’ can generate IPN report in PDF format. ")
	
	public void testHappyDay144054() throws Exception {
		gstrTCID = "144054";
		gstrTO = "Verify that user with right ‘Report - Incoming Patient Notification Detail’ can generate IPN report in PDF format. ";

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
		Regions Regions_Page = new Regions(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);

		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement EventManagement_Page1=new EventManagement(this.driver1);
		Report Report_Page1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		String fileType = objReport_data.pdfFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
//
//		String autoItFilesPath = pathProps
//				.getProperty(objReport_data.autoItPath);
		
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		
		String strTimeText = objDate_Time_settings.getCurrentDate(objReport_data.dateFormat1);
		
		String strDownloadName2 = file + "\\" + "2ndTC" + gstrTCID + "_"
				+ strTimeText + fileType;
	
//
//		File autoItFiles = new File(System.getProperty("user.dir")
//				+ autoItFilesPath);
//		String filePath = file + "\\";
		
		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strSpringfieldReg);

		RegionDefault_page.selectFrame();

		NavigationToSubMenus_page.navigateToRegions();

		Regions_Page.clickOnEditRegions(objTest_data.strSpringfieldReg)
				.selectIncomingPatientNotification().clickSaveButton();

		// User creation
		UsersList_page.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objResource_data.strNewMexicoResource)
				.selectViewResourceRights(
						objResource_data.strNewMexicoResource)
				.selectAssosciateResourceRight(objResource_data.strNewMexicoResource)		
				.selectRunReportRight(
						objResource_data.strNewMexicoResource)
				.clickAdvancedOptionAndExpand()		
				.selectReportIncomingPatientNotificationOption()
				.selectIncomingPatientNotificationOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickOnsystemNotifyPreferences();
System.out.println(objUser_data.strNewUserName);
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
		
		EMTrackLogin_Page.selDestinationLocation(objEMTrack_data.strNewMexicoLoc);

		EMTrackLogin_Page.selProvider(objEMTrack_data.strNewMexicoProvider);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.setracProviderUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);


		String strApplicationTime = EMTrackLogin_Page.getApplcnTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");

		strApplicationTime = strApplicationTime + " " + "MST";

		System.out.println(strApplicationTime);

		EMTrackLogin_Page.clkSaveBtn();
		
		EMTrackLogin_Page.clickLogOutLink();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		objEventManagement1.verWebNotificationframe()
		                   .verIncomingPatientNotification(objResource_data.strNewMexicoResource)
						   .clickAcknowledgeAllNotifications()
						   .selectFrame();

		objNavigationToSubMenus1.clickOnResourceReports();
		
		Report_Page1.clickOnIPNLink();
		
		String strCurrentDate = EventManagement_Page1.getApplicationTime();
		
		String strDateAndMonth[] = strCurrentDate.split(" ");
		
		strCurrentYear = dts.timeNow("yyyy");
		
		strCurrentDate = strDateAndMonth[0]+"/"+strDateAndMonth[1]+"/"+strCurrentYear;
		
		strCurrentDate = dts.converDateFormat(strCurrentDate, "dd/MMM/yyyy", "MM/dd/yyyy");
		
		strCurrentDate = strCurrentDate.replace(" ", "");
		
		Report_Page1.verrifyIncomingPatientNotificationPage()
		
		.enterReportStartDate(strCurrentDate)
		
		.enterReportEndDate(strCurrentDate)
		
		.clickOnFilterButton()
		
		.verrifyIncomingPatientNotificationPage()
		
		.verifyResourceNameIsDisplayed(objResource_data.strNewMexicoResource)
		
		.selectResourceName(objResource_data.strNewMexicoResource)
		
		.clickOnGenerateReportBtn();

		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
		int intCount2 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName2).exists());
				Thread.sleep(10000);
				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount2++;
			}
		} while (intCount2 < 60);
		gstrResult = "PASS";
	}
	

	/******************************************************************************************
	 * 'Description :  	Verify that user with right ‘Report - Incoming Patient Notification Detail’ can generate IPN report in Excel format. 
	 * 'Date        : 24-Nov-2014 
	 * 'Author      : Anil
	 ******************************************************************************************/

	@Test(description = "Verify that user with right ‘Report - Incoming Patient Notification Detail’ can generate IPN report in Excel format. ")
	
	public void testHappyDay144055() throws Exception {
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
		EventManagement EventManagement_Page = new EventManagement(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement EventManagement_Page1 = new EventManagement(
				this.driver1);
		Report Report_Page1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		Roles_data objRolesData = new Roles_data();
		String strRoleValue[] = new String[1];
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.reportFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";

		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strSetracReg);

		RegionDefault_page.selectFrame();

		NavigationToSubMenus_page.navigateToIncomingPationt();

		objIncomingPatientNotifications.selectEnabledCheckBox();

		objIncomingPatientNotifications.selectManualEntryCheckBox();

		objIncomingPatientNotifications.clickOnSaveButton();

		String time = EventManagement_Page.getApplicationTimeWithCSTCDT();
		String timeZone[] = time.split(" ");

		// New Role creation
		NavigationToSubMenus_page.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);
		objRoles1.clickOnSaveBtn();

		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		// User creation
		UsersList_page.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectRunReportRight(objResource_data.strSetracResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportIncomingPatientNotificationOption()
				.selectIncomingPatientNotificationOption().clickSaveButton();

		// User creation
		UsersList_page.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectRoleCheckBox(strRoleValue)
				.selectRunReportRight(objResource_data.strSetracResourceName)
				.clickSaveButton();

		login_page.clickLogOut();

		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strSetracRegion);

		EMTrackLogin_Page.navigateToPatientPage();

		Thread.sleep(10000);

		EMTrackLogin_Page.navToAddDailyPatientPage();

		EMTrackLogin_Page.enterPatientID(objEMTrack_data.strPatientID);

		EMTrackLogin_Page.selGender(objEMTrack_data.strMale);

		EMTrackLogin_Page.selRedTriageCategory();

		EMTrackLogin_Page.enterPatientAge(objEMTrack_data.strPatientAge);

		EMTrackLogin_Page
				.selDestinationLocation(objEMTrack_data.setracLocation);

		EMTrackLogin_Page.selProvider(objEMTrack_data.setracProvider1);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.setracProviderUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		String strApplicationTime = EMTrackLogin_Page.getApplcnTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		String strArrivalTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");

		strArrivalTime = strArrivalTime + " " + timeZone[3];

		System.out.println("strArrivalTime" + strArrivalTime);

		System.out.println(strApplicationTime);

		EMTrackLogin_Page.clkSaveBtn();

		EMTrackLogin_Page.clickLogOutLink();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		String strHeader = "Incoming Patient Notification for "
				+ objEMTrack_data.setracLocation;

		String[] strHeaderNames = { "Sent By:", "Age:", "Complaint:",
				"Triage:", "Gender:", "Region:" };

		String[] strUpdatedValues = { objEMTrack_data.strQsgTester,
				objEMTrack_data.strPatientAge + " Years", "unknown",
				"Immediate", objEMTrack_data.strMale, objTest_data.strSetracReg };

		Thread.sleep(5000);

		RegionDefault_Page1
				.selectFrame()
				.verWebNotificationframe()
				.verIncomingPatientNotificationMsg(strHeader, strHeaderNames,
						strUpdatedValues, strArrivalTime);
		String strETA = RegionDefault_Page1.getETATime();
		RegionDefault_Page1.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame().selectFrame();

		objNavigationToSubMenus1.clickOnReports();

		objNavigationToSubMenus1.clickOnResourceReportsLink();

		Report_Page1.clickOnIPNLink();

		String strCurrentDate = EventManagement_Page1.getApplicationTime();

		String strDateAndMonth[] = strCurrentDate.split(" ");

		strCurrentYear = dts.timeNow("yyyy");

		strCurrentDate = strDateAndMonth[0] + "/" + strDateAndMonth[1] + "/"
				+ strCurrentYear;

		strCurrentDate = dts.converDateFormat(strCurrentDate, "dd/MMM/yyyy",
				"MM/dd/yyyy");

		strCurrentDate = strCurrentDate.replace(" ", "");

		String strAcknolwedgeTime = strCurrentDate + " " + strDateAndMonth[2];
		System.out.println(strAcknolwedgeTime);

		Thread.sleep(3000);

		Report_Page1.verrifyIncomingPatientNotificationPage()

		.enterReportStartDate(strCurrentDate)

		.enterReportEndDate(strCurrentDate)

		.enterReportStartDate(strCurrentDate)

		.enterReportEndDate(strCurrentDate)

		.clickOnExcelOption()

		.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		System.out.println(strDownloadName);
		int intCount = 0;
		int intCount1 = 0;

		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount1++;
					}

				} while (intCount1 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);

		strCurrentDate = dts.converDateFormat(strCurrentDate, "MM/dd/yyyy",
				"yyyy-MM-dd");
		String strStartDate = strCurrentDate + " 00:00";
		String strEndDate = strCurrentDate + " 23:59";

		String strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 1, 1, strDownloadName1);
		assertEquals(objReport_data.strIPNHeader, strValue1);

		strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 2, 1, strDownloadName1);
		assertEquals(objReport_data.strStartDate, strValue1);

		strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 3, 1, strDownloadName1);
		assertEquals(objReport_data.strEndDate, strValue1);

		strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 2, 2, strDownloadName1);
		assertEquals(strStartDate, strValue1);

		strValue1 = objOffCommonFunc.readInfoExcel(
				objReport_data.strIPNSheetName, 3, 2, strDownloadName1);
		assertEquals(strEndDate, strValue1);

		for (intCount = 1; intCount <= objReport_data.strExcelContents.length; intCount++) {
			strValue1 = objOffCommonFunc.readInfoExcel(
					objReport_data.strIPNSheetName, 4, intCount,
					strDownloadName1);
			assertEquals(objReport_data.strExcelContents[intCount - 1],
					strValue1);
		}

		intCount = 4;

		String strValue = "";

		do {
			// strValue =
			// objOffCommonFunc.readInfoExcel(objReport_data.strIPNSheetName,
			// intCount, 9, strDownloadName1);
			// if(strValue.equals(objUser_data.strNewUserName)){
			strValue = objOffCommonFunc.readInfoExcel(
					objReport_data.strIPNSheetName, intCount, 1,
					strDownloadName1);
			if (strETA.equals(strValue)) {
				break;
			}
			// }
			intCount++;
		} while (strValue != "");

		String strPatientAgeWithYears = objEMTrack_data.strPatientAge
				+ " Years";

		String[] strUserDetails = { strETA,
				objResource_data.strSetracResourceName, strPatientAgeWithYears,
				objEMTrack_data.strMale, objEMTrack_data.strComplaintData,
				"Immediate", objEMTrack_data.strQsgTester, "", "", "",
				strApplicationTime + " " + timeZone[3],
				objUser_data.strNewUserName,
				strAcknolwedgeTime + " " + timeZone[3] };

		for (intCount1 = 1; intCount1 <= strUserDetails.length; intCount1++) {
			strValue1 = objOffCommonFunc.readInfoExcel(
					objReport_data.strIPNSheetName, intCount, intCount1,
					strDownloadName1);
			assertEquals(strUserDetails[intCount1 - 1], strValue1);
		}

		login_page1.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		Thread.sleep(5000);

		RegionDefault_Page1.selectFrame();

		objNavigationToSubMenus1.verifyReportsIsNotDisplayed();

		gstrResult = "PASS";
	}
	
	/******************************************************************************************************************
	 * 'Description : Verify that acknowledge column is updated in IPN report once user acknowledges the notification. 
	 * 'Date        : 10-Mar-2015 
	 * 'Author      : Rahul
	 *****************************************************************************************************************/
	@Test(description = "Verify that acknowledge column is updated in IPN report once user acknowledges the notification ")
	public void testHappyDay144049() throws Exception {
		gstrTCID = "144049";
		gstrTO = " 	Verify that acknowledge column is updated in IPN report once user acknowledges the notification ";

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
		Roles objRoles1 = new Roles(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement EventManagement_Page1=new EventManagement(this.driver1);
		Report Report_Page1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		Roles_data objRolesData = new Roles_data();
		String strRoleValue[] = new String[1];
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.reportFile;
		
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
	
		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);
		
		File file = new File(System.getProperty("user.dir") + fileDownloadPath) ;
		
		File autoItFiles = new File(System.getProperty("user.dir")+autoItFilesPath);
		
		String strDownloadName = file + "\\" 
		        + "TC"+ gstrTCID
				+ "_" 
		        + strTimeText
				+ fileType;
		String strCSVFileNameRenamed =  "TC"+ gstrTCID
				+ "_" 
		        + strTimeText;
		
		String strCSVDownlRenamedPath =  file + "\\" 
		        + "TC"+ gstrTCID
				+ "_" 
		        + strTimeText+  objReport_data.xlsFile;
			
		String strDownloadName1 = file + "\\" 
		        + "TC"+ gstrTCID
				+ "_" 
		        + strTimeText
				+  objReport_data.xlsFile;
		
		String filePath = file+"\\";
		
		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strSetracReg);

		RegionDefault_page.selectFrame();


		NavigationToSubMenus_page.navigateToIncomingPationt();

		objIncomingPatientNotifications.selectEnabledCheckBox();
		
		objIncomingPatientNotifications.selectManualEntryCheckBox();
		
		objIncomingPatientNotifications.clickOnSaveButton();
		
		//New Role creation
		NavigationToSubMenus_page.navigateToRoles();
		
		objRoles1.clickOnCreateNewRoleBtn()
		.enterRoleName(objRolesData.strRoleName);	
		objRoles1.clickOnSaveBtn();
		
		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		// User creation
		UsersList_page.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectRunReportRight(objResource_data.strSetracResourceName)
				.clickAdvancedOptionAndExpand()		
				.selectReportIncomingPatientNotificationOption()
				.selectIncomingPatientNotificationOption()
				.clickSaveButton();

		login_page.clickLogOut();

		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(5000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strSetracRegion);

		EMTrackLogin_Page.navigateToPatientPage();

		Thread.sleep(10000);

		EMTrackLogin_Page.navToAddDailyPatientPage();

		EMTrackLogin_Page.enterPatientID(objEMTrack_data.strPatientID);

		EMTrackLogin_Page.selGender(objEMTrack_data.strMale);
		
		EMTrackLogin_Page.selRedTriageCategory();

		EMTrackLogin_Page.enterPatientAge(objEMTrack_data.strPatientAge);
		
		EMTrackLogin_Page.selDestinationLocation(objEMTrack_data.setracLocation);

		EMTrackLogin_Page.selProvider(objEMTrack_data.busProvider);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.setracProviderUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		String strApplicationTime = EMTrackLogin_Page.getApplcnTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		String strArrivalTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");
		
		System.out.println(strApplicationTime);

		EMTrackLogin_Page.clkSaveBtn();
		
		EMTrackLogin_Page.clickLogOutLink();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		String strHeader = "Incoming Patient Notification for "+objEMTrack_data.setracLocation;

		String[] strHeaderNames = { "Sent By:", "Age:", "Complaint:",
				"Triage:", "Gender:", "Region:" };

		String[] strUpdatedValues = { objEMTrack_data.strQsgTester,
				objEMTrack_data.strPatientAge + " Years", "unknown",
				"Immediate", objEMTrack_data.strMale, objTest_data.strSetracReg };
		
		Thread.sleep(5000);

		RegionDefault_Page1
				.selectFrame()
				.verWebNotificationframe()
				.verIncomingPatientNotificationMsg(strHeader, strHeaderNames, strUpdatedValues,
						strArrivalTime);
			String strETA = 	RegionDefault_Page1.getETATime();
			RegionDefault_Page1.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame()
				.selectFrame();
		
		objNavigationToSubMenus1.clickOnReports();
		
		objNavigationToSubMenus1.clickOnResourceReportsLink();
		
		Report_Page1.clickOnIPNLink();
		
		String strCurrentDate = EventManagement_Page1.getApplicationTime();
		
		String strDateAndMonth[] = strCurrentDate.split(" ");
		
		strCurrentYear = dts.timeNow("yyyy");
		
		strCurrentDate = strDateAndMonth[0]+"/"+strDateAndMonth[1]+"/"+strCurrentYear;
		
		strCurrentDate = dts.converDateFormat(strCurrentDate, "dd/MMM/yyyy", "MM/dd/yyyy");
		
		strCurrentDate = strCurrentDate.replace(" ", "");
		
		String strAcknolwedgeTime =  strCurrentDate+" "+strDateAndMonth[2];
		System.out.println(strAcknolwedgeTime);

		Thread.sleep(3000);
		
		Report_Page1.verrifyIncomingPatientNotificationPage()
		
		.enterReportStartDate(strCurrentDate)
		
		.enterReportEndDate(strCurrentDate)
		
		.clickOnExcelOption()
		
		.clickOnGenerateReportBtn();

		Thread.sleep(10000);
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName, strAutoITName);
		System.out.println(strDownloadName);
		int intCount = 0;
		int intCount1=0;
		
		do {
		
			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript "+autoItFiles
								+ filePath + " "
								+ strCSVFileNameRenamed);
		
				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath)
								.exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount1++;
					}
		
				} while (intCount1 < 60);
		
				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);
		
		strCurrentDate= dts.converDateFormat(strCurrentDate, "MM/dd/yyyy", "yyyy-MM-dd");
		String strStartDate= strCurrentDate+" 00:00";
		String strEndDate= strCurrentDate+" 23:59";
		
		String strValue1 = objOffCommonFunc.readInfoExcel(objReport_data.strIPNSheetName, 1, 1, strDownloadName1);
		assertEquals(objReport_data.strIPNHeader, strValue1);
		
		strValue1 = objOffCommonFunc.readInfoExcel(objReport_data.strIPNSheetName, 2, 1, strDownloadName1);
		assertEquals(objReport_data.strStartDate, strValue1);
		
		strValue1 = objOffCommonFunc.readInfoExcel(objReport_data.strIPNSheetName, 3, 1, strDownloadName1);
		assertEquals(objReport_data.strEndDate, strValue1);
		
		strValue1 = objOffCommonFunc.readInfoExcel(objReport_data.strIPNSheetName, 2, 2, strDownloadName1);
		assertEquals(strStartDate, strValue1);
		
		strValue1 = objOffCommonFunc.readInfoExcel(objReport_data.strIPNSheetName, 3, 2, strDownloadName1);
		assertEquals(strEndDate, strValue1);
		
		for(intCount = 1; intCount<=objReport_data.strExcelContents.length;intCount++ ){
			strValue1 = objOffCommonFunc.readInfoExcel(objReport_data.strIPNSheetName, 4, intCount, strDownloadName1);
			assertEquals(objReport_data.strExcelContents[intCount-1], strValue1);
		}
	
		intCount = 4;
		
		String strValue = "";
		
		do{
		//	strValue = objOffCommonFunc.readInfoExcel(objReport_data.strIPNSheetName, intCount, 9,  strDownloadName1);
		//	if(strValue.equals(objUser_data.strNewUserName)){
				strValue = objOffCommonFunc.readInfoExcel(objReport_data.strIPNSheetName, intCount, 1,  strDownloadName1);
				if(strETA.equals(strValue)){
					break;
				}		
		//	}
			intCount++;
		}while(strValue != "");
		
		String strPatientAgeWithYears = objEMTrack_data.strPatientAge+" Years";
		
		String[] strUserDetails = {strETA,objResource_data.strSetracResourceName, strPatientAgeWithYears, objEMTrack_data.strMale, objEMTrack_data.strComplaintData,
				"Immediate", objEMTrack_data.strQsgTester, "", "", "", strApplicationTime, objUser_data.strNewUserName, strAcknolwedgeTime};
		
		for(intCount1 = 1; intCount1<=strUserDetails.length;intCount1++ ){
			strValue1 = objOffCommonFunc.readInfoExcel(objReport_data.strIPNSheetName, intCount, intCount1, strDownloadName1);
			assertEquals(strUserDetails[intCount1-1], strValue1);
		}
	
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that acknowledge column is updated in ‘Form >> Incoming patient Notification’ once user 
	 *                acknowledges the notification 
	 * 'Date        : 11-Mar-2015 
	 * 'Author      : Sowmya
	 ***************************************************************************************************************/
	@Test(description = "Verify that acknowledge column is updated in ‘Form >> Incoming patient Notification’ once user acknowledges the notification")
	public void testHappyDay144051() throws Exception {
		gstrTCID = "144051";
		gstrTO = "Verify that acknowledge column is updated in ‘Form >> Incoming patient Notification’ once user acknowledges the notification";

		// Objects for data
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EMTrack_data objEMTrack_data = new EMTrack_data();
		Date_Time_settings objDts = new Date_Time_settings();
	    Date_Time_settings dts = new Date_Time_settings();
		Roles_data objRolesData = new Roles_data();

		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		String strRoleValue[] = new String[1];

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		Map objMap1 = new Map(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotificationsPage1 = new IncomingPatientNotifications(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		EventManagement EventManagement_Page1=new EventManagement(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(this.driver1);
		
		System.out.println("-----Precondtion execution starts------");
		
		//IE 9
		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		RegionDefault_Page1.selectFrame();

		SelectRegion_page1
				.selectRegionAndNavigate(objTest_data.strNewMexicoReg);

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
				.selectRoleCheckBox(strRoleValue)
				.selectRunReportRight(objResource_data.strNewMexicoResourceName)
				.clickAdvancedOptionAndExpand()		
				.selectReportIncomingPatientNotificationOption()
				.selectIncomingPatientNotificationOption()
				.clickSaveButton();
		
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
		
		EMTrackLogin_Page.selDestinationLocation(objEMTrack_data.strNewMexicoLoc);

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

		String strArrivalTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");
		
		strArrivalTime = strArrivalTime + " " + strDateAndMonth[3];
	   
		System.out.println(strArrivalTime);
		
		login_page1.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		String strHeader = "Incoming Patient Notification for "+objEMTrack_data.strNewMexicoLoc;	
		
		String[] strHeaderNames = { "Sent By:", "Age:", "Complaint:",
				"Triage:", "Gender:", "Region:" };

		String[] strUpdatedValues = { objEMTrack_data.strQsgTester,
				objEMTrack_data.strPatientAge + " Years", "unknown",
				"N/A", objEMTrack_data.strMale, objTest_data.strNewMexicoReg };

		Thread.sleep(5000);

		System.out.println(strArrivalTime);
		RegionDefault_Page1
				.selectFrame()
				.verWebNotificationframe()
				.verIncomingPatientNotificationMsgForOtherTime(strHeader, strHeaderNames, strUpdatedValues,
						strArrivalTime)
				.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame()
				.selectFrame();
		
        String strCurrentDate = EventManagement_Page1.getApplicationTime();
		
        String strDateAndMonth1[] = strCurrentDate.split(" ");
		
		String strCurrentYear1 = dts.timeNow("yyyy");
		
		strCurrentDate = strDateAndMonth1[0]+"/"+strDateAndMonth1[1]+"/"+strCurrentYear1;
		
		strCurrentDate = dts.converDateFormat(strCurrentDate, "dd/MMM/yyyy", "MM/dd/yyyy");
		
		strCurrentDate = strCurrentDate.replace(" ", "");
		
		String AcknowledgeTime = strCurrentDate+" "+strDateAndMonth[2];
		
		String AcknowledgementDate =  strCurrentDate+" "+strDateAndMonth[2] + " " + strDateAndMonth[3];
		
		String AcknowledgementDateOneMinAdded = objDts
				.AddTimeToExistingTimeHourAndMin(AcknowledgeTime, 0, 0,
						"MM/dd/yyyy HH:mm");
		
		 AcknowledgementDateOneMinAdded = AcknowledgementDateOneMinAdded + " " + strDateAndMonth[3];
		 
		 System.out.println(AcknowledgementDateOneMinAdded);
		 System.out.println(AcknowledgementDate);
		objNavigationToSubMenus1.navigateToIncomingPatientNotifications();
		
		String strData[] = { strArrivalTime, "unknown",
				"N/A", objEMTrack_data.strMale,
				objResource_data.strNewMexicoResourceName,
				objTest_data.strNewMexicoReg, objUser_data.strNewUserName
				 };
		
		String[] strData1 = { strArrivalTime, objEMTrack_data.strPatientAge + " " + "Years",
				objEMTrack_data.strQsgTester };

		objIncomingPatientNotificationsPage1
				.verifIncomingPatientNotificationDetails(strData,
						AcknowledgementDate, AcknowledgementDateOneMinAdded);

		objIncomingPatientNotificationsPage1
				.verifIncomingPatientNotificationDetails1(strData1);

		gstrResult = "PASS";
	}
}