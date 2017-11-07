package requirementGroup.EMResourceIntegartionWithEMTrack;

import lib.dataObject.EMTrack_data;
import lib.dataObject.IncomingPationtNotificationData;
import lib.dataObject.InterfaceInSetUp_data;
import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EMTrackLogin;
import lib.page.EventManagement;
import lib.page.IncomingPatientNotifications;
import lib.page.InterfacesInSetUp;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewHappyDayEMResourceIntegrationWithEMTrack extends TestNG_UI_EXTENSIONS {

	public NewHappyDayEMResourceIntegrationWithEMTrack() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/******************************************************************************************
	 * 'Description : Verify that a user with ‘IPN - Receive Incoming Patient Notifications’ / ‘IPN - Create Incoming Patient Notifications’ 
	 *                right can view Patients added from EMResource or EMtrack on ‘Incoming Patient Notifications In Last 24 Hours’ page
	 * 'Date        : 09-Feb-2016
	 * 'Author      : Sangappa.k
	 ******************************************************************************************/

	@Test(description ="Verify that a user with ‘IPN - Receive Incoming Patient Notifications’ / ‘IPN - Create Incoming Patient Notifications’"
			+ "         right can view Patients added from EMResource or EMtrack on ‘Incoming Patient Notifications In Last 24 Hours’ page")
	
	public void testHappyDay175970() throws Exception {
		gstrTCID ="175970";
		gstrTO = " Verify that a user with ‘IPN - Receive Incoming Patient Notifications’ / ‘IPN - Create Incoming Patient Notifications’ right "
				+ "can view Patients added from EMResource or EMtrack on ‘Incoming Patient Notifications In Last 24 Hours’ page";

	
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();
		IncomingPationtNotificationData objIncomingPationtNotificationData = new IncomingPationtNotificationData();
		Date_Time_settings dts = new Date_Time_settings();
		EMTrack_data objEMTrack_data = new EMTrack_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(
				this.driver1);
		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
				this.driver1);

		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(
				driver1);
		EventManagement EventManagement_Page1 = new EventManagement(
				this.driver1);

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

		// User1

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objInterfaceInSetUp_data.strSetracResources2)
				.selectViewResourceRights(
						objInterfaceInSetUp_data.strSetracResources2)
				.selectUpdateStatusOfResource(
						objInterfaceInSetUp_data.strSetracResources3)
				.selectViewResourceRights(
						objInterfaceInSetUp_data.strSetracResources3)
				.clickAdvancedOptionAndExpand()
				.selectReceiveIncomingPatientNotificationsOption()
				.clickSaveButton()

				// User2

				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objInterfaceInSetUp_data.strSetracResources2)
				.selectViewResourceRights(
						objInterfaceInSetUp_data.strSetracResources2)
				.selectUpdateStatusOfResource(
						objInterfaceInSetUp_data.strSetracResources3)
				.selectViewResourceRights(
						objInterfaceInSetUp_data.strSetracResources3)
				.clickAdvancedOptionAndExpand()
				.selectCreateIncomingPatientNotificationsOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		NavigationToSubMenus_page.navigateToInterfaces();

		objInterfacesInSetUp

				.verifyInterfaceListScreen()

				.verifyCreatedInterfaceTypeInList(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName,
						objInterfaceInSetUp_data.strInterfaceType13)

				.clickOnResourceLinkCorrespondingToInterface(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName)
				.selectResource(objInterfaceInSetUp_data.strSetracResources2)
				.selectResource(objInterfaceInSetUp_data.strSetracResources3)
				.clickOnSave();
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToSendIncomingPatientNotifications();
		objIncomingPatientNotifications1
				.verManualIPNEntrySceen()
				.selectGenderRdBtn(objIncomingPationtNotificationData.strFemale)
				.enterAge(objIncomingPationtNotificationData.strAge)
				.enterCheafComplaint(
						objIncomingPationtNotificationData.strCheafComp)
				.selectTriageCategoryRdBtn(
						objIncomingPationtNotificationData.strGreen)
				.selectLevelOfCategoeryRdBtn(
						objIncomingPationtNotificationData.strBLS)
				.enterEMSAgency(objIncomingPationtNotificationData.strEmsAgency)
				.enterEMSUnit(objIncomingPationtNotificationData.strEMSUnit)
				.verResourcesUnderTransportDropDown(
						objInterfaceInSetUp_data.strSetracResources2)
				.selectTransportingTo(
						objInterfaceInSetUp_data.strSetracResources2)
				.enterETA(objIncomingPationtNotificationData.strETA);

		String time = EventManagement_Page1.getApplicationTimeWithCSTCDT();

		objIncomingPatientNotifications1.clickOnSave().verIPNnotification();

		String Apptime = time.substring(7);
		 String timeZone[]= time.split(" ");

		String strCurrentDate = EventManagement_Page1.getApplicationTime();

		String strDateAndMonth[] = strCurrentDate.split(" ");

		String strCurrentYear = dts.timeNow("yyyy");

		strCurrentDate = strDateAndMonth[0] + "/" + strDateAndMonth[1] + "/"
				+ strCurrentYear;

		strCurrentDate = dts.converDateFormat(strCurrentDate, "dd/MMM/yyyy",
				"MM/dd/yyyy");

		strCurrentDate = strCurrentDate.replace(" ", "");

		String strSentTime1 = dts.addTimetoExisting(strCurrentDate + " "
				+ Apptime, 0, "MM/dd/yyyy HH:mm");

		String strSentTime2 = dts.addTimetoExisting(strCurrentDate + " "
				+ Apptime, 1, "MM/dd/yyyy HH:mm");

		String strArrivalTimeETA = dts.addTimetoExisting(strCurrentDate + " "
				+ Apptime, objIncomingPationtNotificationData.strETA,
				"MM/dd/yyyy HH:mm");

		String strArrivalTimeETA1 = dts.addTimetoExisting(strCurrentDate + " "
				+ Apptime, objIncomingPationtNotificationData.strETA + 1,
				"MM/dd/yyyy HH:mm");

		strSentTime1 = strSentTime1 +" "+timeZone[3];
		System.out.println("strSentTime1 " +strSentTime1); 
		strSentTime2 = strSentTime2 +" "+timeZone[3];
		String ArrivalTimeFromEMR = strArrivalTimeETA +" "+timeZone[3];
		String ArrivalTimeFromEMR1 = strArrivalTimeETA1 +" "+timeZone[3];

		System.out.println("strSentTime1  " + strSentTime1);
		System.out.println("strSentTime2  " + strSentTime2);
		System.out.println("ArrivalTimeFromEMR  " + ArrivalTimeFromEMR);
		System.out.println("ArrivalTimeFromEMR1  " + ArrivalTimeFromEMR1);

		objLogin1.clickLogOut();

		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		Thread.sleep(3000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strSetracRegion);

		EMTrackLogin_Page.navigateToPatientPage();

		Thread.sleep(10000);

		EMTrackLogin_Page.navToAddDailyPatientPage();

		EMTrackLogin_Page.enterPatientID(objEMTrack_data.strPatientID);

		EMTrackLogin_Page.selGender(objEMTrack_data.strMale);

		EMTrackLogin_Page.selRedTriageCategory();

		EMTrackLogin_Page.enterPatientAge(objEMTrack_data.strPatientAge);

		EMTrackLogin_Page
				.selDestinationLocation(objEMTrack_data.setracLocation4);

		EMTrackLogin_Page.selProvider(objEMTrack_data.setracProvider1);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.setracProviderUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		String strApplicationTime = EMTrackLogin_Page.getApplcnTime();

		EMTrackLogin_Page.clkSaveBtn();

		String strCurrentYear1 = dts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear1;

		strApplicationTime = dts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		String strSentTimeEMT = dts.addTimetoExisting(strApplicationTime, 0,
				"MM/dd/yyyy HH:mm");

		String strSentTimeEMT1 = dts.addTimetoExisting(strApplicationTime, 1,
				"MM/dd/yyyy HH:mm");

		String strArrivalTime = dts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");

		String strArrivalTime1 = dts.addTimetoExisting(strApplicationTime, 6,
				"MM/dd/yyyy HH:mm");

		strSentTimeEMT = strSentTimeEMT +" "+timeZone[3];
		strSentTimeEMT1 = strSentTimeEMT1 +" "+timeZone[3];
		String strArrivalTimeFromEMT = strArrivalTime +" "+timeZone[3];
		String strArrivalTimeFromEMT1 = strArrivalTime1 +" "+timeZone[3];

		System.out.println("strSentTimeEMT" + strSentTimeEMT);
		System.out.println("strSentTimeEMT1" + strSentTimeEMT1);
		System.out.println("strArrivalFromEMT" + strArrivalTimeFromEMT);
		System.out.println("strArrivalFromEMT1" + strArrivalTimeFromEMT1);

		EMTrackLogin_Page.clickLogOutLink();

		// Login as User

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		String strEMRPatientHeader = "Incoming Patient Notification for "
				+ objInterfaceInSetUp_data.strSetracResources2;

		String[] strEMRPatientHeaders = { "Sent By:", "Age:", "Complaint:",
				"Triage:", "Gender:", "Level of Care:", "EMS Agency:",
				"EMS Unit:", "Region:" };

		String[] strEMRPatientData = { objUser_data.strNewUserName1,
				objIncomingPationtNotificationData.strAge + " Years",
				objIncomingPationtNotificationData.strCheafComp,
				objIncomingPationtNotificationData.strgreen,
				objIncomingPationtNotificationData.strFeMaleNotifn,
				objIncomingPationtNotificationData.strBLS,
				objIncomingPationtNotificationData.strEmsAgency,
				objIncomingPationtNotificationData.strEMSUnit,
				objTest_data.strSetracReg };

		String strEmTrackPatienLoctaion = "Incoming Patient Notification for "
				+ objEMTrack_data.setracLocation4;

		String[] strEmTrackPatienHeaders = { "Sent By:", "Age:", "Complaint:",
				"Triage:", "Gender:", "Level of Care:", "EMS Agency:",
				"EMS Unit:", "Region:" };

		String[] strEmTrackPatienData = { objEMTrack_data.strQsgTester,
				objEMTrack_data.strPatientAge + " Years",
				objEMTrack_data.strComplaintData,
				objEMTrack_data.strImmeditteTraige, objEMTrack_data.strMale,
				"-", "-", "-", objTest_data.strSetracReg };

		Thread.sleep(5000);

		RegionDefault_Page1
				.selectFrame()
				.verWebNotificationframe()
				.verIPNWebNotifaication(strEmTrackPatienLoctaion,
						strEmTrackPatienHeaders, strEmTrackPatienData,
						strArrivalTimeFromEMT, strArrivalTimeFromEMT1)

				.verIPNWebNotifaication(strEMRPatientHeader,
						strEMRPatientHeaders, strEMRPatientData,
						ArrivalTimeFromEMR, ArrivalTimeFromEMR1);

		Thread.sleep(5000);
		RegionDefault_Page1.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame().selectFrame();
		Thread.sleep(1000);

		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();

		String[] strIPNDataFromEMR = { objUser_data.strNewUserName,
				objIncomingPationtNotificationData.strAge + " Years",
				objIncomingPationtNotificationData.strCheafComp,
				objIncomingPationtNotificationData.strgreen,
				objIncomingPationtNotificationData.strFeMaleNotifn,
				objInterfaceInSetUp_data.strSetracResources2,
				objTest_data.strSetracReg };

		String[] strIPNDataFromEmtrack = {
				objEMTrack_data.strPatientAge + " Years",
				objEMTrack_data.strComplaintData,
				objEMTrack_data.strImmeditteTraige, objEMTrack_data.strMale,
				objEMTrack_data.setracLocation4, objTest_data.strSetracReg };

		objIncomingPatientNotifications1.verIPNDetailesInIPNLast24HrPage1(
				objUser_data.strNewUserName1, strIPNDataFromEMR, strSentTime1,
				strSentTime2, ArrivalTimeFromEMR, ArrivalTimeFromEMR1);

		objIncomingPatientNotifications1.verIPNDetailesInIPNLast24HrPage1(
				objEMTrack_data.strQsgTester, strIPNDataFromEmtrack,
				strSentTimeEMT, strSentTimeEMT1, strArrivalTimeFromEMT,
				strArrivalTimeFromEMT1);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();

		objIncomingPatientNotifications1.verIPNDetailesInIPNLast24HrPage1(
				objUser_data.strNewUserName1, strIPNDataFromEMR, strSentTime1,
				strSentTime2, ArrivalTimeFromEMR, ArrivalTimeFromEMR1);

		objIncomingPatientNotifications1
				.verIPNDetailesAreNotDisplayedInIPNLast24HrPage(
						objEMTrack_data.strQsgTester, strSentTimeEMT,
						strSentTimeEMT1);

		objLogin1.clickLogOut();
		gstrResult = "PASS";

	}
	
	/******************************************************************************************
	 * 'Description :  Verify that only the patients which are added by user ‘U1 (IPN - Create Incoming Patient Notifications’ right)’ 
	 *                ‘are listed under ‘Incoming Patient Notifications in Last 24 Hours’ page.
	 * 'Date        : 09-Feb-2016
	 * 'Author      : Sangappa.k
	 ******************************************************************************************/

	@Test(description =" Verify that only the patients which are added by user ‘U1 (IPN - Create Incoming Patient Notifications’ right)’"
			         + " ‘are listed under ‘Incoming Patient Notifications in Last 24 Hours’ page.")
	
	public void testHappyDay175974() throws Exception {
		gstrTCID ="176775";
		gstrTO = " Verify that only the patients which are added by user ‘U1 (IPN - Create Incoming Patient Notifications’ right)’"
				+ "‘are listed under ‘Incoming Patient Notifications in Last 24 Hours’ page.";

	
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();
		IncomingPationtNotificationData objIncomingPationtNotificationData = new IncomingPationtNotificationData();
		Date_Time_settings dts = new Date_Time_settings();
		EMTrack_data objEMTrack_data = new EMTrack_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(
				this.driver1);
		EMTrackLogin EMTrackLogin_Page = new EMTrackLogin(this.driver1);
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
				this.driver1);

		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(
				driver1);
		EventManagement EventManagement_Page1 = new EventManagement(
				this.driver1);

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

		// User1

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objInterfaceInSetUp_data.strSetracResources3)
				.selectViewResourceRights(
						objInterfaceInSetUp_data.strSetracResources3)
				.clickAdvancedOptionAndExpand()
				.selectCreateIncomingPatientNotificationsOption()
				.clickSaveButton()

				// User2

				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()

				.selectUpdateStatusOfResource(
						objInterfaceInSetUp_data.strSetracResources3)
				.selectViewResourceRights(
						objInterfaceInSetUp_data.strSetracResources3)
				.clickAdvancedOptionAndExpand()
				.selectReceiveIncomingPatientNotificationsOption()
				.selectCreateIncomingPatientNotificationsOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		NavigationToSubMenus_page.navigateToInterfaces();

		objInterfacesInSetUp

				.verifyInterfaceListScreen()

				.verifyCreatedInterfaceTypeInList(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName,
						objInterfaceInSetUp_data.strInterfaceType13)

				.clickOnResourceLinkCorrespondingToInterface(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName)
				.selectResource(objInterfaceInSetUp_data.strSetracResources3)
				.clickOnSave();
		objLogin.clickLogOut();

		EMTrackLogin_Page.loginToApplication(objEMTrack_data.strQsgTester,
				objEMTrack_data.strQsgTesterPwd);

		 Thread.sleep(30000);

		EMTrackLogin_Page.changeLocation(objEMTrack_data.strSetracRegion);

		EMTrackLogin_Page.navigateToPatientPage();

		Thread.sleep(10000);

		EMTrackLogin_Page.navToAddDailyPatientPage();

		EMTrackLogin_Page.enterPatientID(objEMTrack_data.strPatientID1);

		EMTrackLogin_Page.selGender(objEMTrack_data.strMale);

		EMTrackLogin_Page.selRedTriageCategory();

		EMTrackLogin_Page.enterPatientAge(objEMTrack_data.strPatientAge);

		EMTrackLogin_Page
				.selDestinationLocation(objEMTrack_data.setracLocation4);

		EMTrackLogin_Page.selProvider(objEMTrack_data.setracProvider1);

		EMTrackLogin_Page.enterUnitValue(objEMTrack_data.setracProviderUnit);

		EMTrackLogin_Page.enterETAValue(objEMTrack_data.strETA3);

		String strApplicationTime = EMTrackLogin_Page.getApplcnTime();

		EMTrackLogin_Page.clkSaveBtn();

		String strCurrentYear1 = dts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear1;

		strApplicationTime = dts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		String strSentTimeEMT = dts.addTimetoExisting(strApplicationTime, 0,
				"MM/dd/yyyy HH:mm");

		String strSentTimeEMT1 = dts.addTimetoExisting(strApplicationTime, 1,
				"MM/dd/yyyy HH:mm");

		String strArrivalTime = dts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");

		String strArrivalTime1 = dts.addTimetoExisting(strApplicationTime, 6,
				"MM/dd/yyyy HH:mm");

		EMTrackLogin_Page.clickLogOutLink();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToSendIncomingPatientNotifications();
		objIncomingPatientNotifications1
				.verManualIPNEntrySceen()
				.selectGenderRdBtn(objIncomingPationtNotificationData.strFemale)
				.enterAge(objIncomingPationtNotificationData.strAge1)
				.enterCheafComplaint(
						objIncomingPationtNotificationData.strCheafComp)
				.selectTriageCategoryRdBtn(
						objIncomingPationtNotificationData.strGreen)
				.selectLevelOfCategoeryRdBtn(
						objIncomingPationtNotificationData.strBLS)
				.enterEMSAgency(objIncomingPationtNotificationData.strEmsAgency)
				.enterEMSUnit(objIncomingPationtNotificationData.strEMSUnit)
				.verResourcesUnderTransportDropDown(
						objInterfaceInSetUp_data.strSetracResources3)
				.selectTransportingTo(
						objInterfaceInSetUp_data.strSetracResources3)
				.enterETA(objIncomingPationtNotificationData.strETA);

		String time = EventManagement_Page1.getApplicationTimeWithCSTCDT();

		objIncomingPatientNotifications1.clickOnSave().verIPNnotification();

		String Apptime = time.substring(7);
		
		 String timeZone[]= time.split(" ");

		String strCurrentDate = EventManagement_Page1.getApplicationTime();

		String strDateAndMonth[] = strCurrentDate.split(" ");

		String strCurrentYear = dts.timeNow("yyyy");

		strCurrentDate = strDateAndMonth[0] + "/" + strDateAndMonth[1] + "/"
				+ strCurrentYear;

		strCurrentDate = dts.converDateFormat(strCurrentDate, "dd/MMM/yyyy",
				"MM/dd/yyyy");

		strCurrentDate = strCurrentDate.replace(" ", "");

		String strSentTime1 = dts.addTimetoExisting(strCurrentDate + " "
				+ Apptime, 0, "MM/dd/yyyy HH:mm");

		String strSentTime2 = dts.addTimetoExisting(strCurrentDate + " "
				+ Apptime, 1, "MM/dd/yyyy HH:mm");

		String strArrivalTimeETA = dts.addTimetoExisting(strCurrentDate + " "
				+ Apptime, objIncomingPationtNotificationData.strETA,
				"MM/dd/yyyy HH:mm");

		String strArrivalTimeETA1 = dts.addTimetoExisting(strCurrentDate + " "
				+ Apptime, objIncomingPationtNotificationData.strETA + 1,
				"MM/dd/yyyy HH:mm");

		strSentTime1 = strSentTime1 +" "+timeZone[3];
		strSentTime2 = strSentTime2 +" "+timeZone[3];
		String ArrivalTimeFromEMR = strArrivalTimeETA +" "+timeZone[3];
		String ArrivalTimeFromEMR1 = strArrivalTimeETA1 +" "+timeZone[3];

		System.out.println("strSentTime1  " + strSentTime1);
		System.out.println("strSentTime2  " + strSentTime2);
		System.out.println("ArrivalTimeFromEMR  " + ArrivalTimeFromEMR);
		System.out.println("ArrivalTimeFromEMR1  " + ArrivalTimeFromEMR1);
		
		
		strSentTimeEMT = strSentTimeEMT +" "+timeZone[3];
		strSentTimeEMT1 = strSentTimeEMT1 +" "+timeZone[3];
		String strArrivalTimeFromEMT = strArrivalTime +" "+timeZone[3];
		String strArrivalTimeFromEMT1 = strArrivalTime1 +" "+timeZone[3];

		System.out.println("strSentTimeEMT" + strSentTimeEMT);
		System.out.println("strSentTimeEMT1" + strSentTimeEMT1);
		System.out.println("strArrivalFromEMT" + strArrivalTimeFromEMT);
		System.out.println("strArrivalFromEMT1" + strArrivalTimeFromEMT1);

		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();

		String[] strIPNDataFromEMR = {
				objIncomingPationtNotificationData.strAge1 + " Years",
				objIncomingPationtNotificationData.strCheafComp,
				objIncomingPationtNotificationData.strgreen,
				objIncomingPationtNotificationData.strFeMaleNotifn,
				objInterfaceInSetUp_data.strSetracResources3,
				objTest_data.strSetracReg, "-", "-" };

		objIncomingPatientNotifications1.verIPNDetailesInIPNLast24HrPage1(
				objUser_data.strNewUserName, strIPNDataFromEMR, strSentTime1,
				strSentTime2, ArrivalTimeFromEMR, ArrivalTimeFromEMR1);

		objIncomingPatientNotifications1
				.verIPNDetailesAreNotDisplayedInIPNLast24HrPage(
						objEMTrack_data.strQsgTester, strSentTimeEMT,
						strSentTimeEMT1);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame().verWebNotificationframe()
				.clickAcknowledgeAllNotifications();

		Thread.sleep(8000);
		RegionDefault_Page1.switchToDefaultFrame().selectFrame();
		Thread.sleep(1000);
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
						objInterfaceInSetUp_data.strSetracResources3)
				.selectTransportingTo(
						objInterfaceInSetUp_data.strSetracResources3)
				.enterETA(objIncomingPationtNotificationData.strETA);

		String time2 = EventManagement_Page1.getApplicationTimeWithCSTCDT();

		objIncomingPatientNotifications1.clickOnSave().verIPNnotification();

		String Apptime2 = time2.substring(7);

		String strCurrentDate2 = EventManagement_Page1.getApplicationTime();

		String strDateAndMonth2[] = strCurrentDate2.split(" ");

		strCurrentDate2 = strDateAndMonth2[0] + "/" + strDateAndMonth2[1] + "/"
				+ strCurrentYear;

		strCurrentDate2 = dts.converDateFormat(strCurrentDate2, "dd/MMM/yyyy",
				"MM/dd/yyyy");

		strCurrentDate2 = strCurrentDate2.replace(" ", "");

		String strSentTime3 = dts.addTimetoExisting(strCurrentDate2 + " "
				+ Apptime2, 0, "MM/dd/yyyy HH:mm");

		String strSentTime4 = dts.addTimetoExisting(strCurrentDate2 + " "
				+ Apptime2, 1, "MM/dd/yyyy HH:mm");

		String strArrivalTimeETA2 = dts.addTimetoExisting(strCurrentDate2 + " "
				+ Apptime2, objIncomingPationtNotificationData.strETA,
				"MM/dd/yyyy HH:mm");

		String strArrivalTimeETA3 = dts.addTimetoExisting(strCurrentDate2 + " "
				+ Apptime2, objIncomingPationtNotificationData.strETA + 1,
				"MM/dd/yyyy HH:mm");

		strSentTime3 = strSentTime3 +" "+timeZone[3];
		strSentTime4 = strSentTime4 +" "+timeZone[3];

		String ArrivalTimeFromEMR2 = strArrivalTimeETA2 +" "+timeZone[3];
		String ArrivalTimeFromEMR3 = strArrivalTimeETA3 +" "+timeZone[3];

		System.out.println("strSentTime3  " + strSentTime3);
		System.out.println("strSentTime4  " + strSentTime4);
		System.out.println("ArrivalTimeFromEMR2  " + ArrivalTimeFromEMR2);
		System.out.println("ArrivalTimeFromEMR3  " + ArrivalTimeFromEMR3);

		RegionDefault_Page1.selectFrame().verWebNotificationframe()
				.clickAcknowledgeAllNotifications();
		Thread.sleep(8000);
		RegionDefault_Page1.switchToDefaultFrame().selectFrame();
		Thread.sleep(1000);

		RegionDefault_Page1.clickOnHomeButton();

		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();

		String[] strIPNDataFromEMR1 = {
				objIncomingPationtNotificationData.strAge1 + " Years",
				objIncomingPationtNotificationData.strCheafComp,
				objIncomingPationtNotificationData.strgreen,
				objIncomingPationtNotificationData.strFeMaleNotifn,
				objInterfaceInSetUp_data.strSetracResources3,
				objTest_data.strSetracReg, objUser_data.strNewUserName1 };

		String[] strIPNDataFromEMR2 = {
				objIncomingPationtNotificationData.strAge + " Years",
				objIncomingPationtNotificationData.strCheafComp,
				objIncomingPationtNotificationData.strRED,
				objIncomingPationtNotificationData.strMaleNotifn,
				objInterfaceInSetUp_data.strSetracResources3,
				objTest_data.strSetracReg, objUser_data.strNewUserName1 };

		String[] strEmtIpnData = { objEMTrack_data.strPatientAge + " Years",
				objEMTrack_data.strComplaintData,
				objEMTrack_data.strImmeditteTraige, objEMTrack_data.strMale,
				objEMTrack_data.setracLocation4, objTest_data.strSetracReg,
				objUser_data.strNewUserName1 };

		objIncomingPatientNotifications1.verIPNDetailesInIPNLast24HrPage1(
				objUser_data.strNewUserName, strIPNDataFromEMR1, strSentTime1,
				strSentTime2, ArrivalTimeFromEMR, ArrivalTimeFromEMR1);

		objIncomingPatientNotifications1.verIPNDetailesInIPNLast24HrPage1(
				objUser_data.strNewUserName1, strIPNDataFromEMR2, strSentTime3,
				strSentTime2, ArrivalTimeFromEMR2, ArrivalTimeFromEMR3);

		objIncomingPatientNotifications1.verIPNDetailesInIPNLast24HrPage1(
				objEMTrack_data.strQsgTester, strEmtIpnData, strSentTimeEMT,
				strSentTimeEMT1, strArrivalTimeFromEMT, strArrivalTimeFromEMT1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";

	}

	
	/******************************************************************************************
	 * 'Description :  Verify that 'Form -> Incoming Patient Notification' is available for the 
	 * 				users based on region settings. 
	 * 'Date        : 09-Feb-2016
	 * 'Author      : Anil
	 ******************************************************************************************/

	@Test(description =" Verify that 'Form -> Incoming Patient Notification' is available for the"
			+ " users based on region settings. ")
	
	public void testHappyDay176884() throws Exception {
		gstrTCID ="176884";
		gstrTO = " Verify that 'Form -> Incoming Patient Notification' is available for the users"
				+ "based on region settings. ";

	
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(
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

		// User1

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectReceiveIncomingPatientNotificationsOption()
				.clickSaveButton()

				// User2

				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectCreateIncomingPatientNotificationsOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToFormMenu();

		objIncomingPatientNotifications1.verifyIncomingPatientNotificationsLinkIsDisplayed();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToFormMenu();

		objIncomingPatientNotifications1.verifyIncomingPatientNotificationsLinkIsDisplayed();

		objIncomingPatientNotifications1.verifyaddincomingpatientNotificationIsDisplayed();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";

	}
}
