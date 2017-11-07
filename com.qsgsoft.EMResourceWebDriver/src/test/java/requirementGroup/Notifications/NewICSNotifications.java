package requirementGroup.Notifications;

import static org.testng.AssertJUnit.assertTrue;
import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.dataObject.eICS_Data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.MySystemNotificationPreferences;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.SelectRegion;
import lib.page.UsersList;
import lib.page.eICSFunction;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewICSNotifications extends TestNG_UI_EXTENSIONS  {

	public NewICSNotifications() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description 	: Verify that user with update status right on a resource receives the ICS notification when an incident is created under that facility in HICS
	'Precondition	: None
	'Date 			: 19-oct-2015
	'Author 		: Anil 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user with update status right on a resource receives the ICS notification when an incident is created under that facility in HICS")
	public void testHappyDay125746() throws Exception {

		gstrTCID = "125746";
        gstrTO ="Verify that user with update status right on a resource receives the ICS notification when an incident is created under that facility in HICS";
        
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
				objUserdata.strPhone, objUserdata.strEmail,
				objUserdata.strEmail,
				objUserdata.strEmail)
		.selectFirstRole()
		.selectUpdateStatusOfResource(objEICS_Data.strExistingResourceNameForEICS)
		.clickSaveButton();

		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
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

		objEICSFunction
		.launchEICSUrl()
		.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
		.navigateToResCreateIncident()
		.selFacility(objEICS_Data.streICSRegName)
		.selIrgAndClkNext(objEICS_Data.strIRGName)
		.provideIncidentDetails(objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc)
		.deselectNotification()
		.activateIncident()
		.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc).logoutWithConfirmation();
		
		String strSubjName = objEICSFunction.getICSNotificationSubject(objEICS_Data.strExistingResourceNameForEICS);
		
		String strDesc = objEICSFunction.getICSNotificationBody(objEICS_Data.strExistingResourceNameForEICS, objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc);

		objLogin1.loginToApplication(objUserdata.strNewUserName,
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
		
		
		String strMsgBody = objMailVerificationFunctions.getICSEMailBody(objEICS_Data.strExistingResourceNameForEICS, objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc);
		
		String strSubject = objMailVerificationFunctions.getICSEMailSubject(objEICS_Data.strExistingResourceNameForEICS);
	

		objMailVerificationFunctions.loginToMail(objUserdata.strEmail,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strEmail,
					strSubject);


			if (blnMsg1 == true) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}
			
			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}	


	/*************************************************************************************
	'Description 	: Verify that user with associate with right on a resource receives the ICS notification when an incident is created under that facility in HICS 
	'Precondition	: None
	'Date 			: 19-oct-2015
	'Author 		: Anil 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user with associate with right on a resource receives the ICS notification when an incident is created under that facility in HICS ")
	public void testHappyDay125748() throws Exception {

		gstrTCID = "125748";
        gstrTO ="Verify that user with associate with right on a resource receives the ICS notification when an incident is created under that facility in HICS ";
        
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
				objUserdata.strPhone, objUserdata.strEmail,
				objUserdata.strEmail,
				objUserdata.strEmail)
		.selectFirstRole()
		.selectAssociateWithOfResource(objEICS_Data.strExistingResourceNameForEICS)
		.clickSaveButton();

		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
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

		objEICSFunction
		.launchEICSUrl()
		.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
		.navigateToResCreateIncident()
		.selFacility(objEICS_Data.streICSRegName)
		.selIrgAndClkNext(objEICS_Data.strIRGName)
		.provideIncidentDetails(objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc)
				.deselectNotification()
		.activateIncident()
		.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc).logoutWithConfirmation();
		
		String strSubjName = objEICSFunction.getICSNotificationSubject(objEICS_Data.strExistingResourceNameForEICS);
		
		String strDesc = objEICSFunction.getICSNotificationBody(objEICS_Data.strExistingResourceNameForEICS, objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc);

		objLogin1.loginToApplication(objUserdata.strNewUserName,
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
		
		
		String strMsgBody = objMailVerificationFunctions.getICSEMailBody(objEICS_Data.strExistingResourceNameForEICS, objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc);
		
		String strSubject = objMailVerificationFunctions.getICSEMailSubject(objEICS_Data.strExistingResourceNameForEICS);
	

		objMailVerificationFunctions.loginToMail(objUserdata.strEmail,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strEmail,
					strSubject);


			if (blnMsg1 == true) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}
			
			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}	

	/*******************************************************************************************
	'Description 	: Verify that user with Override viewing restrictions right receives the ICS 
	                  notification when an incident is created under that facility in HICS.
	'Date 			: 19-oct-2015
	'Author 		: Anitha
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user with Override viewing restrictions right receives the ICS "
			+ "notification when an incident is created under that facility in HICS.")
	public void testHappyDay125749() throws Exception {

		gstrTCID = "125749";
        gstrTO ="Verify that user with Override viewing restrictions right receives the ICS notification "
        		+ "when an incident is created under that facility in HICS.";
        
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
						objUserdata.strPhone, objUserdata.strEmail,
						objUserdata.strEmail, objUserdata.strEmail)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectOverrideViewingRestrictionOption()
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
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

		objEICSFunction
				.launchEICSUrl()
				.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
				.navigateToResCreateIncident()
				.selFacility(objEICS_Data.streICSRegName)
				.selIrgAndClkNext(objEICS_Data.strIRGName)
				.provideIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc)
				.deselectNotification()
				.activateIncident()
				.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc).logoutWithConfirmation();

		String strSubjName = objEICSFunction
				.getICSNotificationSubject(objEICS_Data.strExistingResourceNameForEICS);

		String strDesc = objEICSFunction.getICSNotificationBody(
				objEICS_Data.strExistingResourceNameForEICS,
				objEICS_Data.strIncidentName, objEICS_Data.strIncidentDesc);

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verWebNotificationframe()
				.verWebNotificationMsg(strSubjName, strDesc)
				.clickAcknowledgeAllNotifications().switchToDefaultFrame()
				.selectFrame();

		objRegionDefault1.verEICSIconInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResourceNameForEICS);

		objLogin1.clickLogOut();

		String strMsgBody = objMailVerificationFunctions.getICSEMailBody(
				objEICS_Data.strExistingResourceNameForEICS,
				objEICS_Data.strIncidentName, objEICS_Data.strIncidentDesc);

		String strSubject = objMailVerificationFunctions
				.getICSEMailSubject(objEICS_Data.strExistingResourceNameForEICS);

		objMailVerificationFunctions.loginToMail(objUserdata.strEmail,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strEmail,
					strSubject);

			if (blnMsg1 == true) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that user with run report right on a resource receives the ICS notification when an incident is created under that facility in HICS 
	'Precondition	: None
	'Date 			: 19-Oct-2015
	'Author 		: Renushree 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user with run report right on a resource receives the ICS notification when an incident is created under that facility in HICS ")
	public void testHappyDay125747() throws Exception {

		gstrTCID = "125747";
        gstrTO ="Verify that user with run report right on a resource receives the ICS notification when an incident is created under that facility in HICS ";
        
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
				objUserdata.strPhone, objUserdata.strEmail,
				objUserdata.strEmail,
				objUserdata.strEmail)
		.selectFirstRole()
		.selectRunReportsCheckBox(objEICS_Data.strExistingResourceNameForEICS)
		.clickSaveButton();

		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
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

		objEICSFunction
		.launchEICSUrl()
		.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
		.navigateToResCreateIncident()
		.selFacility(objEICS_Data.streICSRegName)
		.selIrgAndClkNext(objEICS_Data.strIRGName)
		.provideIncidentDetails(objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc)
		.deselectNotification()
		.activateIncident()
		.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc).logoutWithConfirmation();
		
		String strSubjName = objEICSFunction.getICSNotificationSubject(objEICS_Data.strExistingResourceNameForEICS);
		
		String strDesc = objEICSFunction.getICSNotificationBody(objEICS_Data.strExistingResourceNameForEICS, objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc);

		objLogin1.loginToApplication(objUserdata.strNewUserName,
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
		
		
		String strMsgBody = objMailVerificationFunctions.getICSEMailBody(objEICS_Data.strExistingResourceNameForEICS, objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc);
		
		String strSubject = objMailVerificationFunctions.getICSEMailSubject(objEICS_Data.strExistingResourceNameForEICS);
	

		objMailVerificationFunctions.loginToMail(objUserdata.strEmail,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strEmail,
					strSubject);


			if (blnMsg1 == true) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}
			
			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}	
	
	/*************************************************************************************
	'Description 	: Verify that user with any of the affiliated rights on a resource receives the ICS notification when a Exercise/Drill incident is created in HICS  
	'Precondition	: None
	'Date 			: 22-oct-2015
	'Author 		: Renushree 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user with any of the affiliated rights on a resource receives the ICS notification when a Exercise/Drill incident is created in HICS ")
	public void testHappyDay125754() throws Exception {

		gstrTCID = "125754";
		gstrTO = "Verify that user with any of the affiliated rights on a resource receives the ICS notification when a Exercise/Drill incident is created in HICS ";

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
						objUserdata.strPhone, objUserdata.strEmail,
						objUserdata.strEmail, objUserdata.strEmail)
				.selectFirstRole()
				.selectAssociateWithOfResource(
						objEICS_Data.strExistingResourceNameForEICS)
				.clickSaveButton();

		objLogin.clickLogOut();

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
				.selAllowStateRegToViewIncindent()
				.deselectNotification()
				.activateIncident()
				.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc).logoutWithConfirmation();

		String strSubjName = objEICSFunction
				.getICSNotificationSubject(objEICS_Data.strExistingResourceNameForEICS);

		String strDesc = objEICSFunction.getICSNotificationBodyForDrilInc(
				objEICS_Data.strExistingResourceNameForEICS,
				objEICS_Data.strIncidentName, objEICS_Data.strIncidentDesc);

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verWebNotificationframe()
				.verWebNotificationMsg(strSubjName, strDesc)
				.clickAcknowledgeAllNotifications().switchToDefaultFrame()
				.selectFrame();

		objRegionDefault1.verEICSIconInRegDefault(objEICS_Data.strIconName,
				strResourceValue[0],
				objEICS_Data.strExistingResourceNameForEICS);

		objLogin1.clickLogOut();

		String strMsgBody = objMailVerificationFunctions.getICSEMailBodyForDrillInc(
				objEICS_Data.strExistingResourceNameForEICS,
				objEICS_Data.strIncidentName, objEICS_Data.strIncidentDesc);

		String strSubject = objMailVerificationFunctions
				.getICSEMailSubject(objEICS_Data.strExistingResourceNameForEICS);

		objMailVerificationFunctions.loginToMail(objUserdata.strEmail,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strEmail,
					strSubject);

			if (blnMsg1 == true) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}	
	
	/*************************************************************************************
	'Description 	: Verify that user who has subscribed for 'web page' ICS notifications receives only the web notifications when an incident is created in eICS
	'Precondition	: None
	'Date 			: 27-Oct-2015
	'Author 		: Anil 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user who has subscribed for 'web page' ICS notifications receives only the web notifications when an incident is created in eICS")
	public void testHappyDay162635() throws Exception {

		gstrTCID = "162635";
        gstrTO ="Verify that user who has subscribed for 'web page' ICS notifications receives only the web notifications when an incident is created in eICS";
        
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
				objUserdata.strPhone, objUserdata.strEmail,
				objUserdata.strEmail,
				objUserdata.strEmail)
		.selectFirstRole()
		.selectRunReportsCheckBox(objEICS_Data.strExistingResourceNameForEICS)
		.clickSaveButton();

		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(3000);
		
		objnNavigationToSubMenus1.navigateToSystemNotificationInPreferences();

		objMySystemNotificationPreferences1
				.verMySystemNotPreferncePgeDisplayed()
				.selWebForICSNotifications().clickOnSaveButton()
				.verMySystemNotPreferncePgeDisplayed()
				.verWebForICSNotificationsIsSelected();
		
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
				.deselectNotification()
		.activateIncident()
		.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc).logoutWithConfirmation();
		
		String strSubjName = objEICSFunction.getICSNotificationSubject(objEICS_Data.strExistingResourceNameForEICS);
		
		String strDesc = objEICSFunction.getICSNotificationBody(objEICS_Data.strExistingResourceNameForEICS, objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc);

		objLogin1.loginToApplication(objUserdata.strNewUserName,
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
		
		gstrResult = "PASS";
	}	


	/*************************************************************************************
	'Description 	: Verify that user without any of the affiliated rights on a resource cannot receive the ICS notification when an incident is created in HICS selecting that facility. 
	'Precondition	: None
	'Date 			: 19-oct-2015
	'Author 		: Anil 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user without any of the affiliated rights on a resource cannot receive the ICS notification when an incident is created in HICS selecting that facility. ")
	public void testHappyDay125750() throws Exception {

		gstrTCID = "125750";
        gstrTO ="Verify that user without any of the affiliated rights on a resource cannot receive the ICS notification when an incident is created in HICS selecting that facility. ";
        
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

		objResource.clickOnUsersLink(objEICS_Data.strExistingResourceNameForEICSBartonCounty);
		
		objResource.deselectAllAssociatedWithOption();
		
		objResource.deselectAllUpdateStatusOption();
		
		objResource.deselectAllRunReportsOption();
		
		objResource.deselectAllViewResourceOption();
		
		objResource.clickOnSaveButton();
		strResourceValue[0] = objResource
				.getResourceValue(objEICS_Data.strExistingResourceNameForEICSBartonCounty);

		objnNavigationToSubMenus.navigateToUsers();

		objUsersList
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName,
				objUserdata.strFirstName, objUserdata.strMiddleName,
				objUserdata.strLastName, objUserdata.strOrganization,
				objUserdata.strPhone, objUserdata.strEmail,
				objUserdata.strEmail,
				objUserdata.strEmail)
		.selectFirstRole()
		.clickSaveButton();

		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
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

		objEICSFunction
		.launchEICSUrl()
		.loginToEICS(objTest_data.strEicsAdminUser,
						objTest_data.strEicsAdminPwd)
		.navigateToResCreateIncident()
		.selFacility(objEICS_Data.strBartonCountyMem)
		.selIrgAndClkNext(objEICS_Data.strEarthquake)
		.provideIncidentDetails(objEICS_Data.strIncidentName,
				objEICS_Data.strIncidentDesc)
				.deselectNotification()
		.activateIncident()
		.verCreatedIncidentDetails(objEICS_Data.strIncidentName,
						objEICS_Data.strIncidentDesc).logoutWithConfirmation();
		
		String strSubjName = objEICSFunction.getICSNotificationSubject(objEICS_Data.strExistingResourceNameForEICSBartonCounty);

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objRegionDefault1
				.verWebNotificationframeIsNotPresent();

		objLogin1.clickLogOut();
		
		objMailVerificationFunctions.loginToMail(objUserdata.strEmail,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubjName);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}

	

	/*************************************************************************************
	'Description 	: Verify that user without any of the affiliated rights on a resource cannot receive the ICS notification when an incident is created in HICS selecting that facility. 
	'Precondition	: None
	'Date 			: 19-oct-2015
	'Author 		: Anil 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user without any of the affiliated rights on a resource cannot receive the ICS notification when an incident is created in HICS selecting that facility. ")
	public void testRemoveMailId() throws Exception {

		gstrTCID = "125750";
        gstrTO ="Verify that user without any of the affiliated rights on a resource cannot receive the ICS notification when an incident is created in HICS selecting that facility. ";
        
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateOfMissouri);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToUsers();

		for(int intCount=0; intCount<200; intCount++){
			objUsersList.selectUserDetailsOptionInUsersList(objUserdata.strEmailAddress);
			objUsersList.enterUsernameInSearchInputField(objUserdata.strEmail);
			objUsersList.clickSearchButton();

		objUsersList.editFirstUserDetails();
		objUsersList.enterEmail("");
		objUsersList.enterPrimaryEmailId("");
		objUsersList.entertextPagerId("");
		
		objUsersList.clickSaveButton();
		
		}
		
		objLogin.clickLogOut();
	
		
		gstrResult = "PASS";
	}	

}
