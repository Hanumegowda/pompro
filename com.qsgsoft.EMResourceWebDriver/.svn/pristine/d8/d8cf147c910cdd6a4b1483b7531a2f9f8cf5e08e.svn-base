package requirementGroup.SmokeTestSuite;

import static org.testng.AssertJUnit.assertTrue;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.dataObject.eICS_Data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.Map;
import lib.page.MySystemNotificationPreferences;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;
import lib.page.eICSFunction;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class SmokeEMResourceIntegrationWithHospitalICS extends TestNG_UI_EXTENSIONS  {

	public SmokeEMResourceIntegrationWithHospitalICS() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description 	: Verify that user with Override viewing restrictions right receives the ICS notification when a Exercise/Drill incident is created in HICS
	'Precondition	: None
	'Date 			: 10-Oct-2014 
	'Author 		: Renushree 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user with Override viewing restrictions right receives the ICS notification when a Exercise/Drill incident is created in HICS")
	public void testSmoke129457() throws Exception {

		gstrTCID = "129457";
		gstrTO = " Verify that user with Override viewing restrictions right receives the ICS notification when a Exercise/Drill incident is created in HICS";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		eICS_Data objEICS_Data = new eICS_Data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		eICSFunction objEICSFunction = new eICSFunction(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		MySystemNotificationPreferences objMySystemNotificationPreferences1 = new MySystemNotificationPreferences(
				this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToResourceInSetup();

		strResourceValue[0] = objResource
				.getResourceValue(objEICS_Data.strExistingResourceNameForEICS);

		objnNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objEICS_Data.strExistingResourceNameForEICS)
				.selectRunReportsCheckBox(
						objEICS_Data.strExistingResourceNameForEICS)
				.selectAssociateWithOfResource(
						objEICS_Data.strExistingResourceNameForEICS)
				.clickAdvancedOptionAndExpand()
				.selectOverrideViewingRestrictionOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.navigateToSystemNotificationInPreferences();

		objMySystemNotificationPreferences1
				.verMySystemNotPreferncePgeDisplayed()
				.selEmailPagerWebForICSNotifications().clickOnSaveButton()
				.verMySystemNotPreferncePgeDisplayed()
				.verEmailPagerWebForICSNotifications();

		objLogin1.clickLogOut();

		objEICSFunction
				.launchEICSUrl()
				.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
				.navigateToResCreateIncident()
				.selFacility(objEICS_Data.streICSRegName)
				.clkExerciseRadioBtn()
				.selIrgAndClkNext(objEICS_Data.strIRGName)
				.provideIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc)
				.clkOnAllowStateRegToViewInc()
				.activateIncident()
				.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc).logoutWithConfirmation();

		String strSubjName1 = "Incident Alert for "
				+ objEICS_Data.strExistingResourceNameForEICS;
		String strDesc = "*** THIS IS A DRILL *** The following message is"
				+ " a Exercise/Drill at "
				+ objEICS_Data.strExistingResourceNameForEICS
				+ " is experiencing"
				+ " "
				+ objEICS_Data.strIncidentName
				+ ". "
				+ objEICS_Data.strIncidentDesc
				+ "."
				+ " * Contact your facility with any questions. Do not reply directly to this email.";
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objRegionDefault1.verWebNotificationframe()
				.verWebNotificationMsg(strSubjName1, strDesc)
				.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame();

		objRegionDefault1.selectFrame();

		objRegionDefault1.verEICSIconInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResourceNameForEICS);

		objLogin1.clickLogOut();
		
		String strMsgBody = "*** THIS IS A DRILL ***"
				+ "\n"
				+ " The following message is a Exercise/Drill at "
				+ objEICS_Data.strExistingResourceNameForEICS
				+ " is "
				+ "experiencing "
				+ objEICS_Data.strIncidentName
				+ "."
				+ "\n"
				+ " "
				+ objEICS_Data.strIncidentDesc
				+ "."
				+ "\n"
				+ " * Contact your facility with any questions. Do not reply directly to this email.";

		String strSubject = "Incident Alert for "
				+ objEICS_Data.strExistingResourceNameForEICS;

		System.out.println(strMsgBody);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
		
		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strEmail,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}
			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();
		
		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault.selectFrame();
		
		objnNavigationToSubMenus.navigateToUsers();

		objUsersList.enterUsernameInSearchInputField(objUserdata.strNewUserName)
					.clickSearchButton()
					.editUserDetails(objUserdata.strNewUserName)
					.removeEmailsFromUser()
					.clickSaveButton();
		
		objLogin.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that user with Override viewing restrictions right receives the ICS notification when a Exercise/Drill incident is created in HICS
	'Precondition	: None
	'Date 			: 13-oct-2014
	'Author 		: Shradha 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user with any of the affiliated rights on a resource receives the ICS notification when a Actual incident is created in HICS")
	public void testSmoke128973() throws Exception {

		gstrTCID = "128973";
        gstrTO ="Verify that user with any of the affiliated rights on a resource receives the ICS notification when a Actual incident is created in HICS";
        
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		eICS_Data objEICS_Data = new eICS_Data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		eICSFunction objEICSFunction = new eICSFunction(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		MySystemNotificationPreferences objMySystemNotificationPreferences1 = new MySystemNotificationPreferences(
				this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToResourceInSetup();

		strResourceValue[0] = objResource
				.getResourceValue(objEICS_Data.strExistingResourceNameForEICS);

		objnNavigationToSubMenus.navigateToUsers();
		objUsersList
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName,
				objUserdata.strFirstName, objUserdata.strMiddleName,
				objUserdata.strLastName, objUserdata.strOrganization,
				objUserdata.strPhone, objUserdata.strEmail,
				objUserdata.strEmail,
				objUserdata.strEmail)
		.selectFirstRole()
		.selectAssociateWithOfResource(
				objEICS_Data.strExistingResourceNameForEICS)
		.clickSaveButton();
		System.out.println(objUserdata.strNewUserName1);
		objUsersList
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName,
				objUserdata.strFirstName, objUserdata.strMiddleName,
				objUserdata.strLastName, objUserdata.strOrganization,
				objUserdata.strPhone, objUserdata.strEmail,
				objUserdata.strEmail,
				objUserdata.strEmail)
		.selectFirstRole()
		.selectRunReportsCheckBox(
				objEICS_Data.strExistingResourceNameForEICS)
		.clickSaveButton();
		System.out.println(objUserdata.strNewUserName2);
		objUsersList
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUserdata.strNewUserName3,
				objUserdata.strNewPassword, objUserdata.strFullName,
				objUserdata.strFirstName, objUserdata.strMiddleName,
				objUserdata.strLastName, objUserdata.strOrganization,
				objUserdata.strPhone, objUserdata.strEmail,
				objUserdata.strEmail,
				objUserdata.strEmail)
		.selectFirstRole()
		.selectUpdateStatusOfResource(
				objEICS_Data.strExistingResourceNameForEICS)
		.clickSaveButton();
		System.out.println(objUserdata.strNewUserName3);
		objUsersList
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUserdata.strNewUserName4,
				objUserdata.strNewPassword, objUserdata.strFullName,
				objUserdata.strFirstName, objUserdata.strMiddleName,
				objUserdata.strLastName, objUserdata.strOrganization,
				objUserdata.strPhone, objUserdata.strEmail,
				objUserdata.strEmail,
				objUserdata.strEmail)
		.selectFirstRole()
		.verViewResourceCheckBoxIsChecked(objEICS_Data.strExistingResourceNameForEICS)
		.clickSaveButton();
		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName4);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(3000);
		
		objnNavigationToSubMenus1.navigateToSystemNotificationInPreferences();

		objMySystemNotificationPreferences1
				.verMySystemNotPreferncePgeDisplayed()
				.selEmailPagerWebForICSNotifications().clickOnSaveButton()
				.verMySystemNotPreferncePgeDisplayed()
				.verEmailPagerWebForICSNotifications();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.navigateToSystemNotificationInPreferences();

		objMySystemNotificationPreferences1
				.verMySystemNotPreferncePgeDisplayed()
				.selEmailPagerWebForICSNotifications().clickOnSaveButton()
				.verMySystemNotPreferncePgeDisplayed()
				.verEmailPagerWebForICSNotifications();

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName3,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.navigateToSystemNotificationInPreferences();

		objMySystemNotificationPreferences1
				.verMySystemNotPreferncePgeDisplayed()
				.selEmailPagerWebForICSNotifications().clickOnSaveButton()
				.verMySystemNotPreferncePgeDisplayed()
				.verEmailPagerWebForICSNotifications();

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName4,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.navigateToSystemNotificationInPreferences();

		objMySystemNotificationPreferences1
				.verMySystemNotPreferncePgeDisplayed()
				.selEmailPagerWebForICSNotifications().clickOnSaveButton()
				.verMySystemNotPreferncePgeDisplayed()
				.verEmailPagerWebForICSNotifications();

		objLogin1.clickLogOut();

		objEICSFunction
		.launchEICSUrl()
		.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
		.navigateToResCreateIncident()
		.selFacility(objEICS_Data.streICSRegName)
		.selIrgAndClkNext(objEICS_Data.strIRGName)
		.provideIncidentDetails(objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc)
		.activateIncident()
		.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc).logoutWithConfirmation();
		
		String strSubjName = "Incident Alert for "
				+ objEICS_Data.strExistingResourceNameForEICS;
		
		String strDesc = "*** THIS IS AN ACTUAL INCIDENT *** This message is to inform you that "
				+ objEICS_Data.strExistingResourceNameForEICS
				+ " is experiencing "
				+ objEICS_Data.strIncidentName
				+ ". "
				+ objEICS_Data.strIncidentDesc
				+ ". * Contact your facility with any questions. Do not reply directly to this email.";

		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objRegionDefault1.verWebNotificationframe()
				.verWebNotificationMsg(strSubjName, strDesc)
				.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame()
				.selectFrame();

		objRegionDefault1.verEICSIconInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResourceNameForEICS);

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objRegionDefault1.verWebNotificationframe()
				.verWebNotificationMsg(strSubjName, strDesc)
				.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame()
				.selectFrame();

		objRegionDefault1.verEICSIconInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResourceNameForEICS);

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName3,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objRegionDefault1.verWebNotificationframe()
				.verWebNotificationMsg(strSubjName, strDesc)
				.clickAcknowledgeAllNotifications()
				.switchToDefaultFrame()
				.selectFrame();

		objRegionDefault1.verEICSIconInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResourceNameForEICS);

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName4,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objRegionDefault1.verWebNotificationframeIsNotPresent();

		objRegionDefault1.verEICSIconInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResourceNameForEICS);

		objLogin1.clickLogOut();
		
		String strMsgBody = "*** THIS IS AN ACTUAL INCIDENT ***"
		+ "\n"
		+ " This message is to inform you that "
		+ objEICS_Data.strExistingResourceNameForEICS
		+ " is experiencing "
		+ objEICS_Data.strIncidentName
		+ "."
		+ "\n"
		+ " "
		+ objEICS_Data.strIncidentDesc
		+ "."
		+ "\n"
		+ " * Contact your facility with any questions. Do not reply directly to this email.";
		
		String strSubject = "Incident Alert for "
				+ objEICS_Data.strExistingResourceNameForEICS;


		objMailVerificationFunctions.loginToMail(objUserdata.strEmail,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strEmail,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}
			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	
	/***************************************************************************************
	 * 'Description : Verify that a user with 'View Resource' right on resource can view the 
	 *                eICS incident and its information on 'View Resource Detail' screen.
	 * 'Date        : 20-Oct-2014 
	 * 'Author      : Anitha
	 ***************************************************************************************/

	@Test(description = "Verify that a user with 'View Resource' right on resource can view the eICS "
			+ "incident and its information on 'View Resource Detail' screen.")
	public void testSmoke148826() throws Exception {
		gstrTCID = "148826";
		gstrTO = "Verify that a user with 'View Resource' right on resource can view the eICS incident "
				+ "and its information on 'View Resource Detail' screen.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		eICS_Data objEICS_Data = new eICS_Data();
		
		String strResourceValue[] = new String[1];

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		eICSFunction eICSFunction_page = new eICSFunction(this.driver1);
		Map Map_page1=new Map(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		RegionDefault_page.selectFrame();
		
		objnNavigationToSubMenus.navigateToResourceInSetup();

		strResourceValue[0] = objResource
				.getResourceValue(objEICS_Data.strExistingResourceNameForEICS);

		objnNavigationToSubMenus.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.selectFirstRole()

				.selectViewResourceCheckBox(
						objEICS_Data.strExistingResourceNameForEICS)

				.clickSaveButton();
		
	 System.out.println("-----Precondtion execution ends and execution starts------");

		eICSFunction_page
				.launchEICSUrl()

				.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
				// Incident 1
				.navigateToResCreateIncident()

				.selFacility(objEICS_Data.streICSRegName)

				.selIrgAndClkNext(objEICS_Data.strIRGName)

				.provideIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc)

				.clkOnAllowStateRegToViewInc()

				.activateIncident()
				
		.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc).logoutWithConfirmation();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		eICSFunction_page.clickOnICSIconForResource(strResourceValue[0],
				objEICS_Data.strExistingResourceNameForEICS,
				objEICS_Data.strIconName);
		
		Map_page1.verIncidentInViewResourceDetailScreen(
				objEICS_Data.strIncidentName, objEICS_Data.strIncidentDesc);

		RegionDefault_Page1.selectFrame();
		
		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************
	 * 'Description  : Update the status of event related status type in EMR and verify that 
	 * 					the status is updated in the facility status view of HICS. 
	 * 'Precondition : None 
	 * 'Date         : 23-Mar-2015 
	 * 'Author       : Renushree
	 * '------------------------------------------------------------------------------------
	 * 'Modified Date                                                   Modified By
	 * 'Date                                                           Name
	 ***************************************************************************************/
	@Test(description = "Update the status of event related status type in EMR and verify that "
			+ "the status is updated in the facility status view of HICS.")
	public void testSmoke129048() throws Exception {

		gstrTCID = "129048";
		gstrTO = "Update the status of event related status type in EMR and verify that the "
				+ "status is updated in the facility status view of HICS.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		eICS_Data objEICS_Data = new eICS_Data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Event_data objEvent_data = new Event_data();

		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		eICSFunction objEICSFunction1 = new eICSFunction(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[1];
		String strResourceTypeValue = "";
		String strSectionVal = "";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton().clickOncustomizeResourceDetailView();
		strSectionVal = objViewsList
				.getSectionValue(objView_data.strSectionName);

		ResourceType_Page.navigateToResourceTypePage();

		strResourceTypeValue = ResourceType_Page
				.getResourceTypeValue(objEICS_Data.strExistingResourceTypeNameForEICS);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createEventOnlySharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNSTStatusTypeName);

		objStatusTypeList.createEventOnlySharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.streNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNDSTStatusTypeName);

		objStatusTypeList.createEventOnlySharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName);

		objStatusTypeList
				.createEventOnlySharedStatusTypeWithSectionAndRT(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.streMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName, strResourceTypeValue)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strstatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createEventOnlySharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName);

		objStatusTypeList.createEventOnlySharedStatusTypeWithSectionAndRT(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName, strResourceTypeValue);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName);

		objnNavigationToSubMenus.navigateToResourceInSetup();

		strResourceValue[0] = objResource
				.getResourceValue(objEICS_Data.strExistingResourceNameForEICS);

		objnNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(
						objEICS_Data.strExistingResourceNameForEICS)
				.selectUpdateStatusOfResource(
						objEICS_Data.strExistingResourceNameForEICS)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainAdHocEventsOption()
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()

				.clickOnCreateAdHocEventButton()

				.enterAdHocEventDetails(objEvent_data.strEventName,
						objEvent_data.strEventDescription)

				.clickOnNextButton()

				.selectResource(strResourceValue)

				.clickOnNextButton()

				.selectStatusType(strstatusTypeValues[0])

				.selectStatusType(strstatusTypeValues[1])

				.selectStatusType(strstatusTypeValues[2])

				.selectStatusType(strstatusTypeValues[3])

				.selectStatusType(strstatusTypeValues[4])

				.selectStatusType(strstatusTypeValues[5])

				.clickOnNextButton()

				.clickOnYesButton();

		EventManagement_page1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objViewsList1
				.clickOnUpdateStatus(objEICS_Data.strExistingResourceNameForEICS);
		

		for (int intCount = 0; intCount < strstatusTypeValues.length; intCount++) {
			UpdateStatus_page1.clickOnStatusType(strstatusTypeValues[intCount]);
		}

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
				objView_data.strValueForUpdate);

		UpdateStatus_page1.enterNedocsUpdateValue(strstatusTypeValues[1],
				objView_data.strValueForNDST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
				objView_data.strValueForTST);

		UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[3],
				strstatusesValues[0]);

		UpdateStatus_page1.enterUpdateSSTValues(strstatusTypeValues[4],
				objView_data.strValueForSST);

		UpdateStatus_page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
				objView_data.strDateUpdateValue);

		UpdateStatus_page1.clickOnSaveButton();
		
		String[] strUpdatedValues = { objView_data.strValueForUpdate,
				objView_data.strValueForTST,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strUpdatedValForSST, objView_data.strNEDOCValue,
				objView_data.strDateUpdateValue };

		objLogin1.clickLogOut();
		
		objEICSFunction1
				.launchEICSUrl()
				.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
				.navigateToResCreateIncident()
				.selFacility(objEICS_Data.streICSRegName)
				.selIrgAndClkNext(objEICS_Data.strIRGName)
				.provideIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc)
				.clkOnAllowStateRegToViewInc()
				.activateIncident()
				.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc)
				.clkOnFacilityStatusTab()
				.switchToFacStatusFrame();

		String[] strAllStatusTypeNames = {
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.streNDSTStatusTypeName,
				objStatusTypes_data.streDateStatusTypeName};

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			objEICSFunction1.verifyupdateValueInIncidentPage(
					strSectionVal, strAllStatusTypeNames[i],
					strUpdatedValues[i]);
		}
		
		objEICSFunction1.switchToDefaultPage();

		objEICSFunction1.logoutWithConfirmation();

		gstrResult = "PASS";
	}
}
