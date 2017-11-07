package requirementGroup.SettingUpStatusTypes;

import static org.testng.Assert.assertTrue;
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
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewReceiveExpiredEtatusNotificationsForMultiStatusType extends TestNG_UI_EXTENSIONS{

	public NewReceiveExpiredEtatusNotificationsForMultiStatusType()
			throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*************************************************************************************
	'Description : Verify that user receives the following when the multi status of a resource expires at the EXPIRATION time: "+
					"1. Status update prompt."+
					"2. Expired status notification
	'Date	 	 : 25-May-2015
	'Author		 : Anitha
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user receives the following when the multi status of a resource expires at the EXPIRATION time: "
			+ "1. Status update prompt." + "2. Expired status notification")
	public void testHappyDay66703() throws Exception {

		gstrTCID = "66703";
		gstrTO = "Verify that user receives the following when the multi status of a resource expires at the EXPIRATION time: "
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
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		SystemNotifications objSystemNotifications_page = new SystemNotifications(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		StatusTypeList_page
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.clickOnSaveButton();

		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectEventExpirationOption()
				.selectExpirationMinute(objStatusTypes_data.strExpSec)
				.clickOnSaveButton();

		strStatusesValues[0] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.clickOnSaveButton();

		strStatusesValues[1] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		StatusTypeList_page.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

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
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMustUpdateOverdueStatusOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnsystemNotifyPreferences();

		objSystemNotifications_page.selectAndSaveExpiredStatusNotification();
		
		System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus.navigateToViews();
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strMSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, 
							objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
		objLogin.clickLogOut();
		
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objUpdateStatus1
				.verUpdateStatusPge()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0]).clickOnSaveButton();

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
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti);

		// wait until expiration time
		Thread.sleep(360000);

		objUpdateStatus1
				.verUpdateStatusPge()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[1]).clickOnSaveButton();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti1);

		objLogin1.clickLogOut();

		String strSubject = "Expired Status Notification: "
				+ objResource_data.strResourceName;

		String strSubject1 = "Expired Status: "
				+ objResource_data.strResourceAbbrivation;

		String strMsgBody1 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime);

		String strMsgBody2 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strMSTStatusTypeName,
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
	
	
	/***************************************************************************************************************
	'Description : Verify that a multi status can be auto changed to another status when expiration time is provided.
	'Date	 	 : 24-May-2015
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                  Modified By
	'Date					                                                              Name
	****************************************************************************************************************/
	@Test(description = "Verify that a multi status can be auto changed to another status when expiration time is provided.")
	public void testHappyDay69245() throws Exception {

		gstrTCID = "69245";
		gstrTO = "Verify that a multi status can be auto changed to another status when expiration time is provided.";

		Login_data objLogindata = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		View_data objView_data = new View_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource Resource_page = new Resource(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(this.driver1);
		ResourceType ResourceType_page = new ResourceType(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strMsgBody1 = "";
		String strMsgBody2 = "";
		String strSubjName="";

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.clickOnSaveButton();

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList
				.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusforStatus(objStatusTypes_data.strStatusNameInMulti)
				.selectEventExpirationOption()
				.selectExpirationMinute(objStatusTypes_data.strExpSec)
				.clickOnSaveButton();

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[0] = objStatusTypeList.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		ResourceType_page.navigateToResourceTypePage();

		ResourceType_page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = ResourceType_page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		Resource_page.navigateToResourceListPage();

		Resource_page.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation2,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_page
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strMSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
							objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
		System.out.println(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()

				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				
				.enterEmail(objUser_data.strPrimaryMailId)
				
				.entertextPagerId(objUser_data.strPrimaryMailId)

				.selectViewResourceRights(objResource_data.strResourceName)

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.selectFirstRole()

				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		Thread.sleep(2000);

		UsersList_page.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)
				
				.editUserDetails(objUser_data.strNewUserName)

		        .clickOnsystemNotifyPreferences();

		SystemNotifications_page.selectExpiredNotificationsEmail()

		                        .selectExpiredNotificationsPager()

		                        .clickOnSaveButton();
		
		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnViewMenu();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);

		objUpdateStatus1
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[1])
				.clickOnSaveButton();	
		
		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");

		System.out.println(strApplicationTime);
	    
	    objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti1);

	    // wait until expiration time
	    Thread.sleep(360000);
	    
	    objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti);
	        
	    objLogin1.clickLogOut();

	    strSubjName = "EMResource Expired Status Notification: "
				+ objResource_data.strResourceName;

		strMsgBody1 = objMailVerificationFunctions.getExpiredStatusEmailBody(
				objUser_data.strFullName, objLogindata.strRegionName,
				objStatusTypes_data.strMSTStatusTypeName,
				objResource_data.strResourceName, strApplicationTime);
		
		strMsgBody2 = objMailVerificationFunctions.getExpiredStatusPagerBody(
				objStatusTypes_data.strMSTStatusTypeName,
				objResource_data.strResourceName, strApplicationTime);

		boolean value[] = { false, false };

		System.out.println(strSubjName);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubjName);

		for (int intCount = 0; intCount < 2; intCount++) {
			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubjName);

			if (value[0] == false) {
				value[0] = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		
		strSubjName = "EMResource Expired Status: "
				+ objResource_data.strResourceAbbrivation2;

		for (int intCount = 0; intCount < 1; intCount++) {
			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubjName);

			if (value[1] == false) {
				value[1] = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(value[0] && value[1]);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/***********************************************************************************************************
	'Description : Verify that a multi status can be auto changed to another status when shift time is provided.
	'Date	 	 : 25-May-2015
	'Author		 : Anitha
	'-----------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                  Modified By
	'Date					                                                              Name
	************************************************************************************************************/
	@Test(description = "Verify that a multi status can be auto changed to another status when shift time is provided.")
	public void testHappyDay69246() throws Exception {

		gstrTCID = "69246";
		gstrTO = "Verify that a multi status can be auto changed to another status when shift time is provided.";

		Login_data objLogindata = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		View_data objView_data = new View_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource Resource_page = new Resource(this.driver1);
		EventManagement objEventManagement= new EventManagement(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(this.driver1);
		ResourceType ResourceType_page = new ResourceType(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strMsgBody1 = "";
		String strMsgBody2 = "";
		String strSubjName="";

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription);
		
		String strApplicationTime = objEventManagement.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strTimeInMin = objDts.addTimetoExisting(strTime[2], 10, "HH:mm");
		String strTime1[] = strTimeInMin.split(":");
		System.out.println(strTimeInMin);

		objStatusTypeList.selectShiftTime(strTime1[0], strTime1[1])
				.clickOnSaveButton();;
		
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList
				.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusforStatus(objStatusTypes_data.strStatusNameInMulti)
				.clickOnSaveButton();

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[0] = objStatusTypeList.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		ResourceType_page.navigateToResourceTypePage();

		ResourceType_page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = ResourceType_page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		Resource_page.navigateToResourceListPage();

		Resource_page.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation2,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_page
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strMSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
							objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
		System.out.println(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()

				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				
				.enterEmail(objUser_data.strPrimaryMailId)
				
				.entertextPagerId(objUser_data.strPrimaryMailId)

				.selectViewResourceRights(objResource_data.strResourceName)

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.selectFirstRole()

				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		Thread.sleep(2000);

		UsersList_page.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)
				
				.editUserDetails(objUser_data.strNewUserName)

		        .clickOnsystemNotifyPreferences();

		SystemNotifications_page.selectExpiredNotificationsEmail()

		                        .selectExpiredNotificationsPager()

		                        .clickOnSaveButton();
		
		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);

		objUpdateStatus1
				.verUpdateStatusPge()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[1]).clickOnSaveButton();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti1);

		// wait until expiration time
		objUpdateStatus1.waitUntilShiftTime(strTimeInMin);
    
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti);
	        
		String strCurrentDate = objDts.getCurrentDate("MM/dd/yyyy");
		String strExpTime = strCurrentDate + " " + strTimeInMin;

		System.out.println("Exp time:" + strExpTime);
		
		objLogin1.clickLogOut();

	    strSubjName = "EMResource Expired Status Notification: "
				+ objResource_data.strResourceName;

		strMsgBody1 = objMailVerificationFunctions.getExpiredStatusEmailBody(
				objUser_data.strFullName, objLogindata.strRegionName,
				objStatusTypes_data.strMSTStatusTypeName,
				objResource_data.strResourceName, strExpTime);
		
		strMsgBody2 = objMailVerificationFunctions.getExpiredStatusPagerBody(
				objStatusTypes_data.strMSTStatusTypeName,
				objResource_data.strResourceName, strExpTime);

		boolean value[] = { false, false };

		System.out.println(strSubjName);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubjName);

		for (int intCount = 0; intCount < 2; intCount++) {
			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubjName);

			if (value[0] == false) {
				value[0] = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		
		strSubjName = "EMResource Expired Status: "
				+ objResource_data.strResourceAbbrivation2;

		for (int intCount = 0; intCount < 1; intCount++) {
			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubjName);

			if (value[1] == false) {
				value[1] = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(value[0] && value[1]);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	'Description :Verify that user receives the following when the multi status of a resource expires at the SHIFT time:
					"1. Status update prompt."+
					"2. Expired status notification
	'Date	 	 : 25-May-2015
	'Author		 : Anitha
	'------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                                  Modified By
	'Date					                                                              Name
	*******************************************************************************************************************/
	@Test( description = "Verify that user receives the following when the multi status of a resource expires at the SHIFT time:"
			+ "1. Status update prompt." + "2. Expired status notification")
	public void testHappyDay66704() throws Exception {

		gstrTCID = "66704";
		gstrTO = "Verify that user receives the following when the multi status of a resource expires at the SHIFT time:"
				+ "1. Status update prompt." + "2. Expired status notification";

		Login_data objLogindata = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		View_data objView_data = new View_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource Resource_page = new Resource(this.driver1);
		EventManagement objEventManagement= new EventManagement(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(this.driver1);
		ResourceType ResourceType_page = new ResourceType(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strMsgBody1 = "";
		String strMsgBody2 = "";
		String strSubjName="";

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription);
		
		String strApplicationTime = objEventManagement.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strTimeInMin = objDts.addTimetoExisting(strTime[2], 10, "HH:mm");
		String strTime1[] = strTimeInMin.split(":");
		System.out.println(strTimeInMin);

		objStatusTypeList.selectShiftTime(strTime1[0], strTime1[1])
				.clickOnSaveButton();
		
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList
				.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectEventExpirationOption()
				.selectExpirationMinute(objStatusTypes_data.strExpSec)
				.clickOnSaveButton();

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[0] = objStatusTypeList.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		ResourceType_page.navigateToResourceTypePage();

		ResourceType_page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = ResourceType_page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		Resource_page.navigateToResourceListPage();

		Resource_page.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation2,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_page
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strMSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, 
				objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		UsersList_page
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName,
						objUser_data.strFirstName, objUser_data.strMiddleName,
						objUser_data.strLastName, objUser_data.strOrganization,
						objUser_data.strPhone, objUser_data.strPrimaryMailId,
						objUser_data.strPrimaryMailId,
						objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMustUpdateOverdueStatusOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickOnsystemNotifyPreferences();

		SystemNotifications_page.selectAndSaveExpiredStatusNotification();
		
		System.out.println(objUser_data.strNewUserName);
		
		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objUpdateStatus1
				.verUpdateStatusPge()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0]).clickOnSaveButton();

		// wait until expiration time
		objUpdateStatus1.waitUntilShiftTime(strTimeInMin);
    
		objUpdateStatus1
				.verUpdateStatusPge()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[1]).clickOnSaveButton();
        
		String strCurrentDate = objDts.getCurrentDate("MM/dd/yyyy");
		String strExpTime = strCurrentDate + " " + strTimeInMin;

		System.out.println("Exp time:" + strExpTime);
		
		objLogin1.clickLogOut();

	    strSubjName = "EMResource Expired Status Notification: "
				+ objResource_data.strResourceName;

		strMsgBody1 = objMailVerificationFunctions.getExpiredStatusEmailBody(
				objUser_data.strFullName, objLogindata.strRegionName,
				objStatusTypes_data.strMSTStatusTypeName,
				objResource_data.strResourceName, strExpTime);
		
		strMsgBody2 = objMailVerificationFunctions.getExpiredStatusPagerBody(
				objStatusTypes_data.strMSTStatusTypeName,
				objResource_data.strResourceName, strExpTime);

		boolean value[] = { false, false };

		System.out.println(strSubjName);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubjName);

		for (int intCount = 0; intCount < 2; intCount++) {
			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubjName);

			if (value[0] == false) {
				value[0] = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		
		strSubjName = "EMResource Expired Status: "
				+ objResource_data.strResourceAbbrivation2;

		for (int intCount = 0; intCount < 1; intCount++) {
			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubjName);

			if (value[1] == false) {
				value[1] = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(value[0] && value[1]);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}

}
