package requirementGroup.SettingUpStatusTypes;

import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.SystemNotifications;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayReceiveExpiredStatusNotificationsForNumberStatusType extends TestNG_UI_EXTENSIONS {

	public HappyDayReceiveExpiredStatusNotificationsForNumberStatusType() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*************************************************************************************
	'Description : Verify that user receives the following when the number status of a resource expires at the EXPIRATION time:"+
					"1. Status update prompt."+
					"2. Expired status notification
	'Precondition:
	'Date	 	 : 25-May-2015
	'Author		 : Rensuhree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user receives the following when the number status of a resource expires at the EXPIRATION time:"
			+ "1. Status update prompt." + "2. Expired status notification")
	public void testHappyDay85194() throws Exception {

		gstrTCID = "85194";
		gstrTO = "Verify that user receives the following when the number status of a resource expires at the EXPIRATION time:"
				+ "1. Status update prompt." + "2. Expired status notification";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		SystemNotifications objSystemNotifications_page = new SystemNotifications(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

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
				.clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption()
				.selectSetupResourceOption()
				.selectMustUpdateOverdueStatusOption()
				.selectConfigureRegionViewsOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnsystemNotifyPreferences();

		objSystemNotifications_page.selectAndSaveExpiredStatusNotification();

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		StatusTypeList_page.createStatusTypeWithExpirationTime(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);

		strStatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		// Resource creation
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objResource_Page
				.selectUsersLinkInResourceList(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objUserdata.strNewUserName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToViews();

		String[] strAllStatausTypes = { objStatusTypes_data.strNSTStatusTypeName };

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strAllStatausTypes.length; i++) {
//
//			objViewsList.selectStatusType(strAllStatausTypes[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
//				.verViewInList(objView_data.strViewName);

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, 
								objResource_data.strResourceName, strAllStatausTypes);
		
		objLogin.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objUpdateStatus1
				.verUpdateStatusPge()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate).clickOnSaveButton();

		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");

		System.out.println(strApplicationTime);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0], objView_data.strValueForUpdate);

		// wait until expiration time
		Thread.sleep(360000);

		objUpdateStatus1
				.verUpdateStatusPge()
				.verStatusTypeExpanded(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate1).clickOnSaveButton();
		
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0], objView_data.strValueForUpdate1);

		objLogin1.clickLogOut();

		String strSubject = "Expired Status Notification: "
				+ objResource_data.strResourceName;
		
		String strSubject1 = "Expired Status: "+objResource_data.strResourceAbbrivation;
		
		String strMsgBody1 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strNSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime);
		
		String strMsgBody2 = objMailVerificationFunctions.getExpiredStatusPagerBody(objStatusTypes_data.strNSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1);
		
		for (int intCount = 0; intCount < 1; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject1);

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg2);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description :  Verify that user receives the following when the number status of a resource expires at the SHIFT time:"
							+"1. Status update prompt."
							+"2. Expired status notification
	'Precondition:
	'Date	 	 : 25-May-2015
	'Author		 : Rensuhree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " Verify that user receives the following when the number status of a resource expires at the SHIFT time:"
			+ "1. Status update prompt." + "2. Expired status notification")
	public void testHappyDay66068() throws Exception {

		gstrTCID = "66068";
		gstrTO = " Verify that user receives the following when the number status of a resource expires at the SHIFT time:"
				+ "1. Status update prompt." + "2. Expired status notification";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		SystemNotifications objSystemNotifications_page = new SystemNotifications(
				this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

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
				.clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption()
				.selectSetupResourceOption()
				.selectMustUpdateOverdueStatusOption()
				.selectConfigureRegionViewsOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnsystemNotifyPreferences();

		objSystemNotifications_page.selectAndSaveExpiredStatusNotification();

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		StatusTypeList_page
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strNumberStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strNSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription);

		String strApplicationTime = objEventManagement.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strTimeInMin = objDts.addTimetoExisting(strTime[2], 10, "HH:mm");
		String strTime1[] = strTimeInMin.split(":");
		System.out.println(strTimeInMin);

		StatusTypeList_page.selectShiftTime(strTime1[0], strTime1[1])
				.clickOnSaveButton();

		strStatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		// Resource creation
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objResource_Page
				.selectUsersLinkInResourceList(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objUserdata.strNewUserName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToViews();

		String[] strAllStatausTypes = { objStatusTypes_data.strNSTStatusTypeName };

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
								objResource_data.strResourceName, strAllStatausTypes);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strAllStatausTypes.length; i++) {
//
//			objViewsList.selectStatusType(strAllStatausTypes[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
//				.verViewInList(objView_data.strViewName);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objUpdateStatus1
				.verUpdateStatusPge()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate).clickOnSaveButton();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0], objView_data.strValueForUpdate);

		// wait until expiration time
		objUpdateStatus1.waitUntilShiftTime(strTimeInMin);
TimeUnit.MINUTES.sleep(3);
		objUpdateStatus1
				.verUpdateStatusPge()
				.verStatusTypeExpanded(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate1).clickOnSaveButton();

		String strCurrentDate = objDts.getCurrentDate("MM/dd/yyyy");
		String strExpTime = strCurrentDate + " " + strTimeInMin;

		System.out.println("Exp time:" + strExpTime);

		objLogin1.clickLogOut();

		String strSubject = "Expired Status Notification: "
				+ objResource_data.strResourceName;

		String strSubject1 = "Expired Status: "
				+ objResource_data.strResourceAbbrivation;

		String strMsgBody1 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strNSTStatusTypeName,
						objResource_data.strResourceName, strExpTime);

		String strMsgBody2 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strNSTStatusTypeName,
						objResource_data.strResourceName, strExpTime);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1);

		for (int intCount = 0; intCount < 1; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject1);

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg2);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
}
