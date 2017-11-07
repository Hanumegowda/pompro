package requirementGroup.SmokeTestSuite;

import static org.testng.Assert.*;
import java.util.Iterator;
import java.util.Set;
import lib.dataObject.EMTrack_data;
import lib.dataObject.IncomingPationtNotificationData;
import lib.dataObject.InterfaceInSetUp_data;
import lib.dataObject.Login_data;
import lib.dataObject.Resource_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EMTrackLogin;
import lib.page.EventManagement;
import lib.page.IncomingPatientNotifications;
import lib.page.InterfacesInSetUp;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.SystemNotifications;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class SmokeEMResourceIntegrationEMTrack extends TestNG_UI_EXTENSIONS{

	public SmokeEMResourceIntegrationEMTrack() throws Exception 
	{
		super();
	}
	
/****************************************************************************************************************
'Description    : Add patient in EMResource and verify user receives Incoming Patient Notification
'Precondition 	: 1.On 'Configure Incoming Patient Notifications' page 'Enabled' and 'Allow Manual Entry?' check box are selected
                  2.Resource 'RS' is available in both EMResource and EMTrack
                  3.User 'U1' is created with the affiliated right on the resource 'RS' and 'Create Incoming Patient Notifications' right
                  4.User 'U2' is created with the affiliated right on the resource 'RS' and 'Receive Incoming Patient Notifications' right and subscribed to receive incoming patient notification via email,pager
                  5.postIPN interface is created and resources are selected under it
'Date	 	    : 29-Jan-2016
'Author		    : Sangappa K
'----------------------------------------------------------------------------------------------------------------
'Modified Date			                                                            	Modified By
'Date					                                                                Name
*****************************************************************************************************************/

@Test(description = "Add patient in EMResource and verify user receives Incoming Patient Notification")
public void testSmoke166457() throws Exception {

	gstrTCID ="166457";
	gstrTO = " Add patient in EMResource and verify user receives Incoming Patient Notification";
		Login_data objLogin_data = new Login_data();

		User_data objUserdata = new User_data();

		Resource_data objResource_data = new Resource_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();

		IncomingPationtNotificationData objIncomingPationtNotificationData = new IncomingPationtNotificationData();

		Login objLogin = new Login(this.driver1);

		UsersList objUsersList = new UsersList(driver);

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);

		RegionDefault objRegionDefault = new RegionDefault(this.driver1);

		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		SystemNotifications objSystemNotifications = new SystemNotifications(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(
				this.driver1);
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
				this.driver1);

		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(
				this.driver1);

		MailVerificationFunctions objMailVerificationFunctions1 = new MailVerificationFunctions(
				this.driver1);

		EventManagement objEventManagementPage1 = new EventManagement(
				this.driver1);

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogin_data.strSetracReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToIncomingPationt();

		objIncomingPatientNotifications.selectEnabledCheckBox();

		objIncomingPatientNotifications.selectManualEntryCheckBox();

		objIncomingPatientNotifications.clickOnSaveButton();

		objNavigationToSubmenus.navigateToInterfaces();
		objInterfacesInSetUp
				.verifyInterfaceListScreen()

				.verifyCreatedInterfaceTypeInList(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName,
						objInterfaceInSetUp_data.strInterfaceType13)
				.clickOnResourceLinkCorrespondingToInterface(objInterfaceInSetUp_data.strExistingPostIPNInterfaceName)
				.selectResource(objResource_data.strSetracResourceName2)
				.clickOnSave();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objResource_data.strSetracResourceName2)
				.clickAdvancedOptionAndExpand()
				.selectCreateIncomingPatientNotificationsOption()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objResource_data.strSetracResourceName2)
				.clickAdvancedOptionAndExpand()
				.selectReceiveIncomingPatientNotificationsOption()
				.clickSaveButton();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName2)
				.clickSearchButton().clickEditForFirstUser()
				.clickSystemNotificationPreferences();

		objSystemNotifications.selectEmailIncomingPatientNotification()
				.selectPagerIncomingPatientNotification().clickOnSaveButton();

		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToSendIncomingPatientNotifications();

		objIncomingPatientNotifications1
				.selectGenderRdBtn(objIncomingPationtNotificationData.strMale)
				.enterAge(objIncomingPationtNotificationData.strAges)
				.enterCheafComplaint(
						objIncomingPationtNotificationData.strComplaint)
				.selectTriageCategoryRdBtn(
						objIncomingPationtNotificationData.strGreen)
				.selectLevelOfCategoeryRdBtn(
						objIncomingPationtNotificationData.strBLS)
				.enterEMSAgency(objIncomingPationtNotificationData.strEMSAgency)
				.enterEMSUnit(objIncomingPationtNotificationData.strEMSUnits)
				.selectTransportingTo(objResource_data.strSetracResourceName2)
				.enterETA(objIncomingPationtNotificationData.strETAs)
				.clickOnSave().verIncomingPatientNotificationIsSent();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		Thread.sleep(5000);

		objRegionDefault1.selectFrame();

		String strSubject = "Incoming Patient Notification for "
				+ objResource_data.strSetracResourceName2;

		String strApplicationTime = objEventManagementPage1
				.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		String strArrivalTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");

		String strArrivalTime1 = objDts.addTimetoExisting(strApplicationTime,
				6, "MM/dd/yyyy HH:mm");

		System.out.println("strArrivalTime" + strArrivalTime);

		System.out.println("strArrivalTime1" + strArrivalTime1);

		String[] arrHeaderNames = { "Sent By:", "Age:", "Complaint:",
				"Triage:", "Gender:", "Level of Care:", "EMS Agency:",
				"EMS Unit:", "Region:", };

		String[] arrAnswers = { objUserdata.strNewUserName1,
				objIncomingPationtNotificationData.strAges + " Years",
				objIncomingPationtNotificationData.strComplaint,
				objIncomingPationtNotificationData.strGreenNotifn,
				objIncomingPationtNotificationData.strMaleNotifn,
				objIncomingPationtNotificationData.strBLS,
				objIncomingPationtNotificationData.strEMSAgency,
				objIncomingPationtNotificationData.strEMSUnits,
				objIncomingPationtNotificationData.strSetracRegion };

		objRegionDefault1
				.verWebNotificationframe()
				.verIPNWebNotifaicationContent(strSubject, arrHeaderNames,
						arrAnswers, strArrivalTime, strArrivalTime1)
				.clickAcknowledgeAllNotifications().switchToDefaultFrame()
				.selectFrame();

		String strAcknowledgementDate = objEventManagementPage1
				.getAcknowledgementDate();

		strAcknowledgementDate = strAcknowledgementDate + " " + strCurrentYear;

		strAcknowledgementDate = objDts
				.converDateFormat(strAcknowledgementDate, "dd MMM HH:mm yyyy",
						"MM/dd/yyyy HH:mm");

		String strAcknowledgementDate1 = objDts.addTimetoExisting(
				strAcknowledgementDate, 0, "MM/dd/yyyy HH:mm");

		System.out.println("strAcknowledgementDate1" + strAcknowledgementDate1);

		String[] arrAnswers1 = { objUserdata.strNewUserName1,
				objIncomingPationtNotificationData.strAges + " Years",
				objIncomingPationtNotificationData.strComplaint,
				objIncomingPationtNotificationData.strGreenNotifn,
				objIncomingPationtNotificationData.strMaleNotifn,
				objIncomingPationtNotificationData.strSetracRegion,
				strAcknowledgementDate1, strArrivalTime };

		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();

		objIncomingPatientNotifications1
				.verCreateNewIncomingPatientNotifnbuttonIsNotDisplayed();

		objIncomingPatientNotifications1.verIPNDetailesInIPNLast24HrPage(
				objUserdata.strNewUserName2, arrAnswers1);

		objLogin1.clickLogOut();

		String strMsgBody1 = objMailVerificationFunctions1.getIPNMail(
				objUserdata.strNewUserName1,
				objIncomingPationtNotificationData.strSetracRegion,
				strArrivalTime,
				objIncomingPationtNotificationData.strMaleNotifn,
				objIncomingPationtNotificationData.strAges + " Years",
				objIncomingPationtNotificationData.strComplaint,
				objIncomingPationtNotificationData.strGreenNotifn,
				objIncomingPationtNotificationData.strBLS,
				objIncomingPationtNotificationData.strEMSAgency,
				objIncomingPationtNotificationData.strEMSUnits);
		
		String strMsgBody2 = objMailVerificationFunctions1.getIPNMail(
				objUserdata.strNewUserName1,
				objIncomingPationtNotificationData.strSetracRegion,
				strArrivalTime1,
				objIncomingPationtNotificationData.strMaleNotifn,
				objIncomingPationtNotificationData.strAges + " Years",
				objIncomingPationtNotificationData.strComplaint,
				objIncomingPationtNotificationData.strGreenNotifn,
				objIncomingPationtNotificationData.strBLS,
				objIncomingPationtNotificationData.strEMSAgency,
				objIncomingPationtNotificationData.strEMSUnits);
		
		String strMsgBody3 = objMailVerificationFunctions1.getIPNPager(
				objUserdata.strNewUserName1,
				objIncomingPationtNotificationData.strSetracRegion,
				strArrivalTime,
				objIncomingPationtNotificationData.strMaleNotifn,
				objIncomingPationtNotificationData.strAges + " Years",
				objIncomingPationtNotificationData.strComplaint,
				objIncomingPationtNotificationData.strGreenNotifn,
				objIncomingPationtNotificationData.strBLS,
				objIncomingPationtNotificationData.strEMSAgency,
				objIncomingPationtNotificationData.strEMSUnits);
		
		String strMsgBody4 = objMailVerificationFunctions1.getIPNPager(
				objUserdata.strNewUserName1,
				objIncomingPationtNotificationData.strSetracRegion,
				strArrivalTime1,
				objIncomingPationtNotificationData.strMaleNotifn,
				objIncomingPationtNotificationData.strAges + " Years",
				objIncomingPationtNotificationData.strComplaint,
				objIncomingPationtNotificationData.strGreenNotifn,
				objIncomingPationtNotificationData.strBLS,
				objIncomingPationtNotificationData.strEMSAgency,
				objIncomingPationtNotificationData.strEMSUnits);

		objMailVerificationFunctions1.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions1.NavToInbox(strSubject);

		boolean blnMsg1 = false;

		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions1.verEmail(
					objUserdata.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions1
						.verifyMailBody(strMsgBody1);

				if (blnMsg1 == false) {
					blnMsg1 = objMailVerificationFunctions1
							.verifyMailBody(strMsgBody2);
				}
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions1
						.verifyMailBody(strMsgBody3);
				if (blnMsg2 == false) {
					blnMsg2 = objMailVerificationFunctions1
							.verifyMailBody(strMsgBody4);
				}
			}

			objMailVerificationFunctions1.backToMailInbox();

		}

		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions1.logoutMail();

		gstrResult = "PASS";
	}

/****************************************************************************************************************
'Description : Add a daily patient in EMTrack and verify that user in EMResource receives incoming patient notifications via email, pager and web.
'Date	 	 : 10-July-2015
'Author		 : Sangappa.k
'----------------------------------------------------------------------------------------------------------------
'Modified Date			                                                            	Modified By
'Date					                                                                Name
*****************************************************************************************************************/
@Test(description ="Add a daily patient in EMTrack and verify that user in EMResource recieves incoming patient notifications via email, pager and web.")
public void testSmoke91489() throws Exception {

	gstrTCID ="91489";
	gstrTO ="Add a daily patient in EMTrack and verify that user in EMResource recieves incoming patient notifications via email, pager and web."; 

		Login_data objLogin_data = new Login_data();
		User_data objUserdata = new User_data();
		EMTrack_data objEMTrack_data = new EMTrack_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(driver);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EMTrackLogin EMTrackLogin_Page1 = new EMTrackLogin(this.driver1);
		MailVerificationFunctions MailVerificationFunctions_page1 = new MailVerificationFunctions(
				this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogin_data.strSetracReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.selectAssosciateResourceRight(objEMTrack_data.setracLocation3)
				.clickAdvancedOptionAndExpand()
				.selectReceiveIncomingPatientNotificationsOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName1);

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.clickOnsystemNotifyPreferences();
		SystemNotifications_page.selectEmailIncomingPatientNotification()
				.selectPagerIncomingPatientNotification().clickOnSaveButton();

		objLogin.clickLogOut();

		EMTrackLogin_Page1.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);
		Thread.sleep(10000);
		EMTrackLogin_Page1.changeLocation(objEMTrack_data.strSetracRegion);
		EMTrackLogin_Page1.navigateToPatientPage();
		EMTrackLogin_Page1.navToAddDailyPatientPage();
		EMTrackLogin_Page1.enterPatientID(objEMTrack_data.strPatientID);
		EMTrackLogin_Page1.selGender(objEMTrack_data.strMale);

		EMTrackLogin_Page1.selRedTriageCategory();

		EMTrackLogin_Page1.enterPatientAge(objEMTrack_data.strPatientAge);

		EMTrackLogin_Page1
				.selDestinationLocation(objEMTrack_data.setracLocation3);

		EMTrackLogin_Page1.selProvider(objEMTrack_data.setracProvider1);

		EMTrackLogin_Page1.enterUnitValue(objEMTrack_data.setracProviderUnit);

		EMTrackLogin_Page1.enterETAValue(objEMTrack_data.strETA3);

		String strApplicationTime = EMTrackLogin_Page1.getApplcnTime();
		
		EMTrackLogin_Page1.clkSaveBtn();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		String strArrivalTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");
		String strArrivalTime1 = objDts.addTimetoExisting(strApplicationTime,
				6, "MM/dd/yyyy HH:mm");
		
		strArrivalTime=strArrivalTime + " " + objLogin_data.timeZone;
		
		strArrivalTime1=strArrivalTime1 + " " + objLogin_data.timeZone;
		
		System.out.println("strArrivalTime" + strArrivalTime );
		
		System.out.println("strArrivalTime1" + strArrivalTime1);

		EMTrackLogin_Page1.clickLogOutLink();

		// Login as User1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		String strHeader = "Incoming Patient Notification for "
				+ objEMTrack_data.setracLocation3;

		String[] strHeaderNames = { "Sent By:", "Age:", "Complaint:",
				"Triage:", "Gender:", "Region:" };

		String[] strUpdatedValues = { objEMTrack_data.strQsgTester,
				objEMTrack_data.strPatientAge + " Years", "unknown",
				"Immediate", objEMTrack_data.strMale,
				objLogin_data.strSetracReg };

		Thread.sleep(5000);
		String mainWindowHandle2 = driver1.getWindowHandle();

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verIPNWebNotifaicationContent(strHeader, strHeaderNames,
						strUpdatedValues, strArrivalTime, strArrivalTime1);

		objRegionDefault1.clickReviewButtonOfIPN();

		Thread.sleep(5000);

		Set<String> b = driver1.getWindowHandles();
		Iterator<String> ite2 = b.iterator();

		while (ite2.hasNext()) {
			
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		String strSubmittedTime = strApplicationTime;
		strSubmittedTime=strSubmittedTime + " " + objLogin_data.timeZone;

		objRegionDefault1.verIncomingPatientNotificationMsgReviewPopupWindow(
				strHeader, strSubmittedTime, strHeaderNames, strUpdatedValues,
				strArrivalTime);

		driver1.close();

		Thread.sleep(5000);
		driver1.switchTo().window(mainWindowHandle2);
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objRegionDefault1.verWebNotificationframe();
		objRegionDefault1.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		MailVerificationFunctions_page1.loginToMail(
				objUserdata.strPrimaryMailId, objUserdata.strPrimaryPwsd);

		String strSubject = "Incoming Patient Notification for "
				+ objEMTrack_data.setracLocation3;

		String strUnknown = "unknown";
		String strTriage = "Immediate";
		String strBlank = "-";

		String strMsgBody1 = MailVerificationFunctions_page1.getIPNMail(
				objEMTrack_data.strQsgTester, objLogin_data.strSetracReg,
				strArrivalTime, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge + " Years", strUnknown,
				strTriage, strBlank, strBlank, strBlank);
		
		String strMsgBody2 = MailVerificationFunctions_page1.getIPNMail(
				objEMTrack_data.strQsgTester, objLogin_data.strSetracReg,
				strArrivalTime1, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge + " Years", strUnknown,
				strTriage, strBlank, strBlank, strBlank);

		String strMsgBody3 = MailVerificationFunctions_page1.getIPNPager(
				objEMTrack_data.strQsgTester, objLogin_data.strSetracReg,
				strArrivalTime, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge + " Years", strUnknown,
				strTriage, strBlank, strBlank, strBlank);
		
		String strMsgBody4 = MailVerificationFunctions_page1.getIPNPager(
				objEMTrack_data.strQsgTester, objLogin_data.strSetracReg,
				strArrivalTime1, objEMTrack_data.strMale,
				objEMTrack_data.strPatientAge + " Years", strUnknown,
				strTriage, strBlank, strBlank, strBlank);
	
		MailVerificationFunctions_page1.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			MailVerificationFunctions_page1.verEmail(
					objUserdata.strPrimaryMailId, strSubject);

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
 * 'Description : Verify that user can add patient in EMResource.            
 * 'Date        : 20-Oct-2015
 * 'Author      : Sangappa.k
 ******************************************************************************************/

@Test(description ="Verify that user can add patient in EMResource")

public void testsSmoke166458() throws Exception {
	gstrTCID ="166458";
	gstrTO = "Verify that user can add patient in EMResource";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();
		IncomingPationtNotificationData objIncomingPationtNotificationData = new IncomingPationtNotificationData();
		Date_Time_settings dts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(
				this.driver1);
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
				this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(
				driver1);

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strSetracReg);

		RegionDefault_page.selectFrame();

		NavigationToSubMenus_page.navigateToIncomingPationt();

		objIncomingPatientNotifications.selectEnabledCheckBox();

		objIncomingPatientNotifications.selectManualEntryCheckBox();

		objIncomingPatientNotifications.clickOnSaveButton();

		// User creation
		NavigationToSubMenus_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(
						objInterfaceInSetUp_data.strSertaceResoueces1)
				.selectAssosciateResourceRight(
						objInterfaceInSetUp_data.strSertaceResoueces1)
				.clickAdvancedOptionAndExpand()
				.selectCreateIncomingPatientNotificationsOption()
				.clickSaveButton();
		NavigationToSubMenus_page.navigateToInterfaces();
		objInterfacesInSetUp
				.verifyInterfaceListScreen()

				.verifyCreatedInterfaceTypeInList(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName,
						objInterfaceInSetUp_data.strInterfaceType13)

				.clickOnResourceLinkCorrespondingToInterface(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName)
				.selectResource(objInterfaceInSetUp_data.strSertaceResoueces1)
				.clickOnSave();
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToSendIncomingPatientNotifications();
		objIncomingPatientNotifications1
				.verManualIPNEntrySceen()
				.selectGenderRdBtn(objIncomingPationtNotificationData.strMale)
				.enterAge(objIncomingPationtNotificationData.strAge)
				.enterCheafComplaint(
						objIncomingPationtNotificationData.strCheafComp)
				.selectTriageCategoryRdBtn(
						objIncomingPationtNotificationData.strRed)
				.selectLevelOfCategoeryRdBtn(
						objIncomingPationtNotificationData.strALS)
				.enterEMSAgency(objIncomingPationtNotificationData.strEmsAgency)
				.enterEMSUnit(objIncomingPationtNotificationData.strEMSUnit)
				.verResourcesUnderTransportDropDown(
						objInterfaceInSetUp_data.strSertaceResoueces1)
				.selectTransportingTo(
						objInterfaceInSetUp_data.strSertaceResoueces1)
				.enterETA(objIncomingPationtNotificationData.strETA);

		objIncomingPatientNotifications1.clickOnSave().verIPNnotification();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
