package requirementGroup.EMResourceIntegartionWithEMTrack;

import static org.junit.Assert.assertTrue;
import java.util.Properties;
import lib.dataObject.EMTrack_data;
import lib.dataObject.IncomingPationtNotificationData;
import lib.dataObject.InterfaceInSetUp_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.Resource_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.ConfigureIncomingPatientNotifications;
import lib.page.EMTrackLogin;
import lib.page.EventManagement;
import lib.page.IncomingPatientNotifications;
import lib.page.InterfacesInSetUp;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.SelectRegion;
import lib.page.SystemNotifications;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class UserInterfaceForManualIPNEntry  extends TestNG_UI_EXTENSIONS{

	public UserInterfaceForManualIPNEntry() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/****************************************************************************************************************
	'Description : Verify that only the 'Resources' selected while creating 'Post Incoming Patient' interface are available under 'Transporting to' drop down
	'Date	 	 : 24-July-2015
	'Author		 : Sangappa.k
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                            	Modified By
	'Date					                                                                Name
	*****************************************************************************************************************/
	@Test(description ="Verify that only the 'Resources' selected while creating 'Post Incoming Patient' interface are available under 'Transporting to' drop down")
	public void testHappyDay171126() throws Exception {

		gstrTCID ="171126";
		gstrTO ="Verify that only the 'Resources' selected while creating 'Post Incoming Patient' interface are available under 'Transporting to' drop down"; 
		
		Login objLogin1 = new Login(this.driver1);
		Login_data objLogin_data = new Login_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		InterfacesInSetUp objInterfacesInSetUp1 = new InterfacesInSetUp(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(
				driver1);
		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogin_data.strNewMexicoReg);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToInterfaces();

		objInterfacesInSetUp1

				.verifyInterfaceListScreen()

				.verifyCreatedInterfaceTypeInList(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName,
						objInterfaceInSetUp_data.strInterfaceType13)

				.clickOnResourceLinkCorrespondingToInterface(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName)
				.selectResource(objInterfaceInSetUp_data.strNewMexcoResource1)
				.selectResource(objInterfaceInSetUp_data.strNewMexicoResource2)
				.selectResource(objInterfaceInSetUp_data.strNewMexicoResource3)
				
				.clickOnSave();

		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();
		objIncomingPatientNotifications1
				.clickOnCreateNewIPNBtn()
				.verResourcesUnderTransportDropDown(
						objInterfaceInSetUp_data.strNewMexcoResource1)
				.verResourcesUnderTransportDropDown(
						objInterfaceInSetUp_data.strNewMexicoResource2)
				.verResourcesUnderTransportDropDown(
						objInterfaceInSetUp_data.strNewMexicoResource3)
				.clickOnCancel();
		objNavigationToSubmenus1.navigateToSendIncomingPatientNotifications();
		objIncomingPatientNotifications1
				
				.verResourcesUnderTransportDropDown(
						objInterfaceInSetUp_data.strNewMexcoResource1)
				.verResourcesUnderTransportDropDown(
						objInterfaceInSetUp_data.strNewMexicoResource2)
				.verResourcesUnderTransportDropDown(
						objInterfaceInSetUp_data.strNewMexicoResource3)
		        .clickOnCancel();
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}

	/******************************************************************************************
	 * 'Description : Verify that admin user can manually setup IPN entry from Form>> Incoming Patient Notifications’.
	 *                (If enabled for region) 
	 * 'Date        : 8-Sept-2015
	 * 'Author      : Sangappa.k   
	 *  Status      : Deactivated
	 ******************************************************************************************/

	@Test(enabled=false,description = "Verify that admin user can manually setup IPN entry from Form>> Incoming Patient Notifications’"
			            +" . (If enabled for region) ")
	
	public void testHappyDay163399() throws Exception {
		gstrTCID ="163399";
		gstrTO = "Verify that admin user can manually setup IPN entry from Form>> Incoming Patient Notifications’."
				+ " (If enabled for region) ";

		//THIS TC IS DEACTIVATED DON'T RUN
		
		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();
		IncomingPationtNotificationData objIncomingPationtNotificationData = new IncomingPationtNotificationData();
		Date_Time_settings dts = new Date_Time_settings();
	
		// Objects for Page
		Login objLogin = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(this.driver1);
		
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
				this.driver1);
		
		
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
	
		MailVerificationFunctions MailVerificationFunctions_page1 = new MailVerificationFunctions(
				this.driver1);
	
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(
				driver1);

		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		EventManagement EventManagement_Page1 = new EventManagement(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
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

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objInterfaceInSetUp_data.strSetracResources)
				.selectUpdateStatusOfResource(
						objInterfaceInSetUp_data.strSertaceResoueces1)
				.clickAdvancedOptionAndExpand()
				.selectReceiveIncomingPatientNotificationsOption()
				.selectCreateIncomingPatientNotificationsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickOnsystemNotifyPreferences();

		SystemNotifications_page.selectEmailIncomingPatientNotification()
				.selectPagerIncomingPatientNotification().clickOnSaveButton();

		NavigationToSubMenus_page.navigateToInterfaces();

		objInterfacesInSetUp

				.verifyInterfaceListScreen()

				.verifyCreatedInterfaceTypeInList(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName,
						objInterfaceInSetUp_data.strInterfaceType13)

				.clickOnResourceLinkCorrespondingToInterface(
						objInterfaceInSetUp_data.strExistingPostIPNInterfaceName)
				.selectResource(objInterfaceInSetUp_data.strSetracResources)
				.selectResource(objInterfaceInSetUp_data.strSertaceResoueces1)

				.clickOnSave();
		objLogin.clickLogOut();

		// IE

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		System.out.println();

		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();
		objIncomingPatientNotifications1
				.clickOnCreateNewIPNBtn()
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
						objInterfaceInSetUp_data.strSetracResources)
				.selectTransportingTo(
						objInterfaceInSetUp_data.strSetracResources)
				.enterETA(objIncomingPationtNotificationData.strETA);

		String time = EventManagement_Page1.getApplicationTimeWithCSTCDT();

		String Apptime = time.substring(7);

		String strCurrentDate = EventManagement_Page1.getApplicationTime();

		String strDateAndMonth[] = strCurrentDate.split(" ");

		String strCurrentYear = dts.timeNow("yyyy");

		strCurrentDate = strDateAndMonth[0] + "/" + strDateAndMonth[1] + "/"
				+ strCurrentYear;

		strCurrentDate = dts.converDateFormat(strCurrentDate, "dd/MMM/yyyy",
				"MM/dd/yyyy");

		strCurrentDate = strCurrentDate.replace(" ", "");

		String strArrivalTimeETA = dts.addTimetoExisting(strCurrentDate + " "
				+ Apptime, objIncomingPationtNotificationData.strETA,
				"MM/dd/yyyy HH:mm");

		String strArrivalTimeETA1 = dts.addTimetoExisting(strCurrentDate + " "
				+ Apptime, objIncomingPationtNotificationData.strETA + 1,
				"MM/dd/yyyy HH:mm");

		System.out.println("ETA date & time  " + strArrivalTimeETA);

		objIncomingPatientNotifications1.clickOnSave().verIPNnotification();
	/*	objNavigationToSubmenus1.navigateToIncomingPatientNotifications();
		objIncomingPatientNotifications1
				.verIPNDetailesAreNotDispayedInIPNLast24HrPage(objUser_data.strNewUserName);*/
		
	
		String strHeader = "Incoming Patient Notification for "+objInterfaceInSetUp_data.strSetracResources;

		String[] strHeaderNames = { "Sent By:","Age:","Complaint:",
				"Triage:", "Gender:","Level of Care:","EMS Agency:","EMS Unit:","Region:"};

		String[] strUpdatedValues = { objUser_data.strNewUserName,
				objIncomingPationtNotificationData.strAge + " Years",
				objIncomingPationtNotificationData.strCheafComp, "Red", "Male",
				objIncomingPationtNotificationData.strALS,
				objIncomingPationtNotificationData.strEmsAgency,
				objIncomingPationtNotificationData.strEMSUnit,
				objTest_data.strSetracReg };

		Thread.sleep(5000);

		RegionDefault_Page1
				.verWebNotificationframe()
				.verIPNWebNotifaicationContent(strHeader, strHeaderNames, strUpdatedValues,
						strArrivalTimeETA,strArrivalTimeETA1)
				.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame()
				.selectFrame();
		Thread.sleep(1000);
		
		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();

		String strETA = objIncomingPatientNotifications1
				.getETADateAndTime(objUser_data.strNewUserName);

		System.out.println("strETA" + strETA);

		String[] strIPNData = {objUser_data.strNewUserName,
				objIncomingPationtNotificationData.strAge + " Years",
				objIncomingPationtNotificationData.strCheafComp, "Red", "Male",
				objInterfaceInSetUp_data.strSetracResources,
				objTest_data.strSetracReg, strETA };

		objIncomingPatientNotifications1.verIPNDetailesInIPNLast24HrPage(
				objUser_data.strNewUserName, strIPNData);

		objLogin1.clickLogOut();

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);
		

		String strMsgBody1 = "sent by: " + objUser_data.strNewUserName + " | "
				+ "age: " + objIncomingPationtNotificationData.strAge
				+ " Years" + " | " + "ETA: " + strETA + " | "
				+ "complaint: "
				+ objIncomingPationtNotificationData.strCheafComp + " | "
				+ "triage: " + "Red" + " | " + "gender: " + "Male" + " | "
				+ "level of care: " + objIncomingPationtNotificationData.strALS
				+ " | " + "ems agency: "
				+ objIncomingPationtNotificationData.strEmsAgency + " | "
				+ "ems unit: " + objIncomingPationtNotificationData.strEMSUnit
				+ " | " + "region: " + objTest_data.strSetracReg;
		
		System.out.println(strMsgBody1);
		
		String strMsgBody2 = "Message from system"
				+ "\n\n"
				+ "Please do not reply to this email message. You"
				+ " must log into EMResource to take any action that may be required."
				+ "\n\n" + "Sent By: " + objUser_data.strNewUserName + "\n"
				+ "Age: " + objIncomingPationtNotificationData.strAge + " Years" + "\n"
				+ "ETA: " + strETA + "\n"
				+ "Chief Complaint: " + objIncomingPationtNotificationData.strCheafComp + "\n" + "Triage Category: "
				+ "Red" + "\n" + "Gender: " + "Male" + "\n"
				+ "Level Of Care: " + objIncomingPationtNotificationData.strALS + "\n"
				+ "EMS Agency: " + objIncomingPationtNotificationData.strEmsAgency + "\n"
				+ "EMS Unit: " + objIncomingPationtNotificationData.strEMSUnit + "\n\n"
			
				+ "Region: " + objTest_data.strSetracReg;
		
		System.out.println(strMsgBody2);

		String strSubject = "Incoming Patient Notification for "
				+ objInterfaceInSetUp_data.strSetracResources;

		objMailVerificationFunctions.NavToInbox(strSubject);

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
						.verifyMailBody(strMsgBody1);
				if (blnMsg2 == false) {
					blnMsg2 = MailVerificationFunctions_page1
							.verifyMailBody(strMsgBody2);
				}
			}
			MailVerificationFunctions_page1.backToMailInbox();

		}
		assertTrue(blnMsg1 && blnMsg2);

		MailVerificationFunctions_page1.logoutMail();
		
		Thread.sleep(10000);
				
		//Add patient
		
		objLogin1.loginToApplication(objUser_data.strNewUserName,
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
						objInterfaceInSetUp_data.strSertaceResoueces1)
				.selectTransportingTo(
						objInterfaceInSetUp_data.strSertaceResoueces1)
				.enterETA(objIncomingPationtNotificationData.strETA1);
				
		String time1 = EventManagement_Page1.getApplicationTimeWithCSTCDT();

		String Apptime1 = time1.substring(7);

		String strCurrentDate1 = EventManagement_Page1.getApplicationTime();

		String strDateAndMonth1[] = strCurrentDate1.split(" ");

		String strCurrentYear1 = dts.timeNow("yyyy");

		strCurrentDate1 = strDateAndMonth1[0] + "/" + strDateAndMonth1[1] + "/"
				+ strCurrentYear1;

		strCurrentDate1 = dts.converDateFormat(strCurrentDate1, "dd/MMM/yyyy",
				"MM/dd/yyyy");

		strCurrentDate1 = strCurrentDate1.replace(" ", "");
		
		String strArrivalTimeETA3 = dts.addTimetoExisting(strCurrentDate1 + " "
				+ Apptime1, objIncomingPationtNotificationData.strETA1,
				"MM/dd/yyyy HH:mm");

		String strArrivalTimeETA4 = dts.addTimetoExisting(strCurrentDate1 + " "
				+ Apptime1, objIncomingPationtNotificationData.strETA1+1,
				"MM/dd/yyyy HH:mm");
		
		objIncomingPatientNotifications1.clickOnSave();/*.verIPNnotification();*/
		
		String strHeader1 = "Incoming Patient Notification for "+objInterfaceInSetUp_data.strSertaceResoueces1;

		String[] strHeaderNames1= { "Sent By:","Age:","Complaint:",
				"Triage:", "Gender:","Level of Care:","EMS Agency:","EMS Unit:","Region:"};

		String[] strUpdatedValues1 = { objUser_data.strNewUserName,
				objIncomingPationtNotificationData.strAge + " Years",
				objIncomingPationtNotificationData.strCheafComp, "Green", "Female",
				objIncomingPationtNotificationData.strBLS,
				objIncomingPationtNotificationData.strEmsAgency,
				objIncomingPationtNotificationData.strEMSUnit,
				objTest_data.strSetracReg };

		RegionDefault_Page1
				
				.verWebNotificationframe()
				.verIPNWebNotifaicationContent(strHeader1, strHeaderNames1, strUpdatedValues1,
						strArrivalTimeETA3,strArrivalTimeETA4)
				.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame()
				.selectFrame();
		Thread.sleep(10000);

		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();
		
		String strETA2=objIncomingPatientNotifications1.getETADateAndTimeFor2NdTime(objUser_data.strNewUserName);
		
	/*	objIncomingPatientNotifications1
		.verIPNDetailesAreNotDispayedInIPNLast24HrPage(objUser_data.strNewUserName);*/
		
		System.out.println("strETA2"+strETA2);
		
		String[] strIPNData1 = { objTest_data.strUserName,
				objIncomingPationtNotificationData.strAge + " Years",
				objIncomingPationtNotificationData.strCheafComp, "Green", "Female",
				objInterfaceInSetUp_data.strSertaceResoueces1,
				objTest_data.strSetracReg,strETA2};
		
			
	//	objIncomingPatientNotifications1.verIPNDetailesInIPNLast24HrPage(objUser_data.strNewUserName,strIPNData1);
		
		objLogin1.clickLogOut();
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);
		
		String strMsgBody3 = "sent by: " + objUser_data.strNewUserName + " | "
				+ "age: " + objIncomingPationtNotificationData.strAge
				+ " Years" + " | " + "ETA: " + strETA2 + " | "
				+ "complaint: "
				+ objIncomingPationtNotificationData.strCheafComp + " | "
				+ "triage: " + "Green" + " | " + "gender: " + "Female" + " | "
				+ "level of care: " + objIncomingPationtNotificationData.strBLS
				+ " | " + "ems agency: "
				+ objIncomingPationtNotificationData.strEmsAgency + " | "
				+ "ems unit: " + objIncomingPationtNotificationData.strEMSUnit
				+ " | " + "region: " + objTest_data.strSetracReg;
		
		
		System.out.println("strMsgBody3"+  strMsgBody3);
		
		String strMsgBody4 = "Message from system"
				+ "\n\n"
				+ "Please do not reply to this email message. You"
				+ " must log into EMResource to take any action that may be required."
				+ "\n\n" + "Sent By: " + objUser_data.strNewUserName + "\n"
				+ "Age: " + objIncomingPationtNotificationData.strAge + " Years" + "\n"
				+ "ETA: " + strETA2 + "\n"
				+ "Chief Complaint: " + objIncomingPationtNotificationData.strCheafComp + "\n" + "Triage Category: "
				+ "Green" + "\n" + "Gender: " + "Female" + "\n"
				+ "Level Of Care: " + objIncomingPationtNotificationData.strBLS + "\n"
				+ "EMS Agency: " + objIncomingPationtNotificationData.strEmsAgency + "\n"
				+ "EMS Unit: " + objIncomingPationtNotificationData.strEMSUnit + "\n\n"
			
				+ "Region: " + objTest_data.strSetracReg;
		
		System.out.println("strMsgBody4"+ strMsgBody4);

		String strSubject1 = "Incoming Patient Notification for "
				+ objInterfaceInSetUp_data.strSertaceResoueces1;

		objMailVerificationFunctions.NavToInbox(strSubject1);

		boolean blnMsg3 = false;
		boolean blnMsg4 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			MailVerificationFunctions_page1.verEmail(
					objUser_data.strPrimaryMailId, strSubject1);

			if (blnMsg3 == false) {
				blnMsg3 = MailVerificationFunctions_page1
						.verifyMailBody(strMsgBody3);
				if (blnMsg3 == false) {
					blnMsg3 = MailVerificationFunctions_page1
							.verifyMailBody(strMsgBody4);
				}
			}

			if (blnMsg4 == false) {
				blnMsg4 = MailVerificationFunctions_page1
						.verifyMailBody(strMsgBody3);
				if (blnMsg4 == false) {
					blnMsg4 = MailVerificationFunctions_page1
							.verifyMailBody(strMsgBody4);
				}
			}
			MailVerificationFunctions_page1.backToMailInbox();

		}
		
		System.out.println(blnMsg3);
		System.out.println(blnMsg4);
		
		assertTrue(blnMsg3 && blnMsg4);

		MailVerificationFunctions_page1.logoutMail();
		
		gstrResult = "PASS";
						
}

	
/******************************************************************************************
	 * 'Description : Verify that user with 'Create Incoming Patient Notifications' right can manually setup IPN entry 
                     from Form >> Add Incoming Patient Notifications’. 
	 *                (If enabled for region)
	 * 'Date        : 10-Sept-2015
	 * 'Author      : Sangappa.k
	 ******************************************************************************************/

	@Test(description ="Verify that user with 'Create Incoming Patient Notifications' right can manually setup IPN entry from Form >> Add Incoming Patient Notifications’."
			+ " (If enabled for region)")
	
	public void testHappyDay163631() throws Exception {
		gstrTCID ="163631";
		gstrTO = "Verify that user with 'Create Incoming Patient Notifications' right can manually setup IPN entry from Form >> Add Incoming Patient Notifications’"
				+ ". (If enabled for region)";

		
		
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
		SystemNotifications SystemNotifications_page = new SystemNotifications(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications = new IncomingPatientNotifications(this.driver1);
		
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(
				this.driver1);
	
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		MailVerificationFunctions MailVerificationFunctions_page1 = new MailVerificationFunctions(
				this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(
				driver1);
		EventManagement EventManagement_Page1 = new EventManagement(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);


		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strSetracReg);

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
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objInterfaceInSetUp_data.strSertaceResoueces1)		
				.clickAdvancedOptionAndExpand()		
				.selectReceiveIncomingPatientNotificationsOption()
				.clickSaveButton()
				
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.clickAdvancedOptionAndExpand()				
				.selectCreateIncomingPatientNotificationsOption()
				.clickSaveButton()
				
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickOnsystemNotifyPreferences();
	
		SystemNotifications_page.selectEmailIncomingPatientNotification()
				.selectPagerIncomingPatientNotification()
                .clickOnSaveButton();
		
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
	
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
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
				
		String time = EventManagement_Page1.getApplicationTimeWithCSTCDT();

		String Apptime = time.substring(7);

		String strCurrentDate = EventManagement_Page1.getApplicationTime();

		String strDateAndMonth[] = strCurrentDate.split(" ");

		String strCurrentYear = dts.timeNow("yyyy");

		strCurrentDate = strDateAndMonth[0] + "/" + strDateAndMonth[1] + "/"
				+ strCurrentYear;

		strCurrentDate = dts.converDateFormat(strCurrentDate, "dd/MMM/yyyy",
				"MM/dd/yyyy");

		strCurrentDate = strCurrentDate.replace(" ", "");
		
		String strArrivalTimeETA = dts.addTimetoExisting(strCurrentDate + " "
				+ Apptime, objIncomingPationtNotificationData.strETA,
				"MM/dd/yyyy HH:mm");

		String strArrivalTimeETA1 = dts.addTimetoExisting(strCurrentDate + " "
				+ Apptime, objIncomingPationtNotificationData.strETA+1,
				"MM/dd/yyyy HH:mm");

		
		System.out.println("ETA date & time  " + strArrivalTimeETA);
		
		objIncomingPatientNotifications1.clickOnSave().verIPNnotification();
			
		objLogin1.clickLogOut();
		
		
		//Login as User
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		String strHeader = "Incoming Patient Notification for "+objInterfaceInSetUp_data.strSertaceResoueces1;

		String[] strHeaderNames = { "Sent By:","Age:","Complaint:",
				"Triage:", "Gender:","Level of Care:","EMS Agency:","EMS Unit:","Region:"};

		String[] strUpdatedValues = { objUser_data.strNewUserName1,
				objIncomingPationtNotificationData.strAge + " Years",
				objIncomingPationtNotificationData.strCheafComp, "Red", "Male",
				objIncomingPationtNotificationData.strALS,
				objIncomingPationtNotificationData.strEmsAgency,
				objIncomingPationtNotificationData.strEMSUnit,
				objTest_data.strSetracReg };

		Thread.sleep(5000);

		RegionDefault_Page1
				.selectFrame()
				.verWebNotificationframe()
				.verIPNWebNotifaicationContent(strHeader, strHeaderNames, strUpdatedValues,
						strArrivalTimeETA,strArrivalTimeETA1)
				.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame()
				.selectFrame();
		Thread.sleep(1000);
		
		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();

		String strETA = objIncomingPatientNotifications1
				.getETADateAndTime(objUser_data.strNewUserName);

		System.out.println("strETA" + strETA);

		String[] strIPNData = { objUser_data.strNewUserName1,
				objIncomingPationtNotificationData.strAge + " Years",
				objIncomingPationtNotificationData.strCheafComp, "Red", "Male",
				objInterfaceInSetUp_data.strSertaceResoueces1,
				objTest_data.strSetracReg, strETA };

		objIncomingPatientNotifications1.verIPNDetailesInIPNLast24HrPage(
				objUser_data.strNewUserName, strIPNData);

		objLogin1.clickLogOut();

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);
		

		String strMsgBody1 = "sent by: " + objUser_data.strNewUserName1 + " | "
				+ "age: " + objIncomingPationtNotificationData.strAge
				+ " Years" + " | " + "ETA: " + strETA + " | "
				+ "complaint: "
				+ objIncomingPationtNotificationData.strCheafComp + " | "
				+ "triage: " + "Red" + " | " + "gender: " + "Male" + " | "
				+ "level of care: " + objIncomingPationtNotificationData.strALS
				+ " | " + "ems agency: "
				+ objIncomingPationtNotificationData.strEmsAgency + " | "
				+ "ems unit: " + objIncomingPationtNotificationData.strEMSUnit
				+ " | " + "region: " + objTest_data.strSetracReg;
		
		System.out.println(strMsgBody1);
		
		String strMsgBody2 = "Message from system"
				+ "\n\n"
				+ "Please do not reply to this email message. You"
				+ " must log into EMResource to take any action that may be required."
				+ "\n\n" + "Sent By: " + objUser_data.strNewUserName1 + "\n"
				+ "Age: " + objIncomingPationtNotificationData.strAge + " Years" + "\n"
				+ "ETA: " + strETA + "\n"
				+ "Chief Complaint: " + objIncomingPationtNotificationData.strCheafComp + "\n" + "Triage Category: "
				+ "Red" + "\n" + "Gender: " + "Male" + "\n"
				+ "Level Of Care: " + objIncomingPationtNotificationData.strALS + "\n"
				+ "EMS Agency: " + objIncomingPationtNotificationData.strEmsAgency + "\n"
				+ "EMS Unit: " + objIncomingPationtNotificationData.strEMSUnit + "\n\n"
			
				+ "Region: " + objTest_data.strSetracReg;
		
		System.out.println(strMsgBody2);

		String strSubject = "Incoming Patient Notification for "
				+ objInterfaceInSetUp_data.strSertaceResoueces1;

		objMailVerificationFunctions.NavToInbox(strSubject);

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
						.verifyMailBody(strMsgBody1);
				if (blnMsg2 == false) {
					blnMsg2 = MailVerificationFunctions_page1
							.verifyMailBody(strMsgBody2);
				}
			}
			MailVerificationFunctions_page1.backToMailInbox();

		}
		assertTrue(blnMsg1 && blnMsg2);

		gstrResult = "PASS";
						
 }
	
	/******************************************************************************************
	 * 'Description : Verify that only admin user can access / configure IPN fields from 'Form >> Incoming Patient' section.
	 *                (If enabled for region) 
	 * 'Date        : 21-Jan-2015
	 * 'Author      : Sangappa.k
	 ******************************************************************************************/

	@Test(description ="Verify that only admin user can access / configure IPN fields from 'Form >> Incoming Patient' section.")
	
	public void testHappyDay165604() throws Exception {
		gstrTCID ="165604";
		gstrTO ="Verify that only admin user can access / configure IPN fields from 'Form >> Incoming Patient' section.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		// Objects for Page
		Login objLogin1 = new Login(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(
				driver1);


		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strSetracReg);
		RegionDefault_page1.selectFrame();	
		objNavigationToSubmenus1.clickOnSetUp();
		objNavigationToSubmenus1.verIncomingPationtOption();
		objNavigationToSubmenus1.navigateToIncomingPationt();
		objIncomingPatientNotifications1.verConfigureIncomingPatientNotificationsPage()
		                                .verManualAllowEntryAndEnabledChkBoxes()
		                                .selectEnabledCheckBox()
		                                .selectManualEntryCheckBox()
                                        .clickOnSaveButton();
		
		objNavigationToSubmenus1.navigateToFormMenu()
		 .verIncmoingPatientNotificationSectionNotUnderForm();
		
		// User creation
		objNavigationToSubmenus1.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectReceiveIncomingPatientNotificationsOption()
				.selectCreateIncomingPatientNotificationsOption()
				.clickSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		UsersList_page.verSetUpIsNotPresent();
		
		objNavigationToSubmenus1.navigateToFormMenu()
		                         .verIncmoingPatientNotificationSectionUnderForm();
	
		objNavigationToSubmenus1.navigateToSendIncomingPatientNotifications();
		
		objIncomingPatientNotifications1.verManualIPNEntrySceen();
		
		objNavigationToSubmenus1.navigateToIncomingPatientNotifications();
		objIncomingPatientNotifications1.clickOnCreateNewIPNBtn();
		objIncomingPatientNotifications1.verManualIPNEntrySceen();	                         
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	
  }
		
}	



