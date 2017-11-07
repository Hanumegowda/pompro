package requirementGroup.PreferencesStatusChangePrefs;

import static org.testng.Assert.assertTrue;
import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.NotificationValues;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayAddStatusChangePreferences extends TestNG_UI_EXTENSIONS {

	public HappyDayAddStatusChangePreferences() throws Exception {
		super();
	}
	
	/*************************************************************************************
	'Description 	: Verify that user can set the status change preferences for a Text status type and receives the notifications when the status changes
	'Precondition	: 
	'Date 			: 24-Nov-2014 
	'Author 		: Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user can set the status change preferences for a Text status type and receives the notifications when the status changes")
	public void testHappyDay130844() throws Exception {

		gstrTCID = "130844";
		gstrTO = "Verify that user can set the status change preferences for a Text status type and receives the notifications when the status changes";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName);
		
		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
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
						objUserdata.strPrimaryMailId).selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)
				.clickOnEmailNotification(objUserdata.strNewUserName, true)
				.clickOnPagerNotification(objUserdata.strNewUserName, true)
				.clickOnWebNotification(objUserdata.strNewUserName, true)
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objEventManagement1
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.selectResource(strResourceValue[0]).clickOnNotifications()
				.verEditMyStatusChangePrefPgeDisplayed()
				.expandUncategorizedSec();

		String[] strStatausTypesNames = {
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.streTSTStatusTypeName };

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objStatusChangePreference1
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames[i]);
		}

		objStatusChangePreference1
				.selEmailPagerWebChkBoxes(strResourceValue[0],
						strStatusTypeValues[0])
				.selEmailPagerWebChkBoxes(strResourceValue[0],
						strStatusTypeValues[1])
				.selEmailPagerWebChkBoxes(strResourceValue[0],
						strStatusTypeValues[2]).clickOnSave();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForTST)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForUpdate1).clickOnSaveButton();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");

		System.out.println(strUpdatedTime);

		String[] strUpdatedVlaues = { objView_data.strValueForTST,
				objView_data.strValueForUpdate, objView_data.strValueForUpdate1 };

		objUpdateStatus1.verWebNotificationframe();

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objUpdateStatus1
					.verWebNotificationForStatusUpdate(
							objResource_data.strResourceName,
							strStatausTypesNames[i], strUpdatedVlaues[i],
							strUpdatedTime);
		}
		objUpdateStatus1.clickAcknowledgeAllNotifications().selectFrame();

		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + "";

		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation;

		String strMsgBody1 = objMailVerificationFunctions
				.getStatusChangeEmailBody(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strTSTStatusTypeName,
						objView_data.strValueForTST,
						objLogindata.strRegionName2,objResourceType_data.strResourceTypeName);
		System.out.println(strMsgBody1);

		String strMsgBody2 = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strTSTStatusTypeName,
						objView_data.strValueForTST,
						objLogindata.strRegionName2);
		System.out.println(strMsgBody2);
		
		String strMsgBody3 = objMailVerificationFunctions
				.getStatusChangeEmailBody(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strTSTStatusTypeName1,
						objView_data.strValueForUpdate,
						objLogindata.strRegionName2, objResourceType_data.strResourceTypeName);
		System.out.println(strMsgBody3);
		
		String strMsgBody4 = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strTSTStatusTypeName1,
						objView_data.strValueForUpdate,
						objLogindata.strRegionName2);
		System.out.println(strMsgBody4);
		
		String strMsgBody5 = objMailVerificationFunctions
				.getStatusChangeEmailBody(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.streTSTStatusTypeName,
						objView_data.strValueForUpdate1,
						objLogindata.strRegionName2, objResourceType_data.strResourceTypeName);
		System.out.println(strMsgBody5);
		
		String strMsgBody6 = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.streTSTStatusTypeName,
						objView_data.strValueForUpdate1,
						objLogindata.strRegionName2);
		System.out.println(strMsgBody6);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;

		for (int intCount = 0; intCount < 6; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}

			if (boolCheck2 == false) {
				boolCheck2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody5);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck && boolCheck1 && boolCheck2);

		boolean boolCheck3 = false;
		boolean boolCheck4 = false;
		boolean boolCheck5 = false;
		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjectForPager);

			if (boolCheck3 == false) {
				boolCheck3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			if (boolCheck4 == false) {
				boolCheck4 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}

			if (boolCheck5 == false) {
				boolCheck5 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody6);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(boolCheck3 && boolCheck4 && boolCheck5);

		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that user can receive the status change notifications upon status change of a non-event related status type.
	'Precondition	: 
	'Date 			: 28-Dec-2015
	'Author 		: Sangappa K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description ="Verify that user can receive the status change notifications upon status change of a non-event related status type.")
	public void testHappyDay99136() throws Exception {

		gstrTCID ="99136";
		gstrTO ="Verify that user can receive the status change notifications upon status change of a non-event related status type.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();
		NotificationValues objNotificationValues = new NotificationValues();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[]= new String[2];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole()
			    .selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		String[] strStatausTypesNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };
		
		objViewsList.navigateToViewsList()
		.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatausTypesNames);
//		.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		System.out.println(objView_data.strViewName);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.selectResource(strResourceValue[0]).clickOnNotifications()
				.verEditMyStatusChangePrefPgeDisplayed()
				.expandUncategorizedSec();



		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objStatusChangePreference1
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames[i]);
		}

		objStatusChangePreference1
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[0])

				.enterAboveValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strAboveValForSST)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strBelowValForSST)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[2])

				.selWebChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[0])
				.selPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[0])
				.selEmailChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[0])

				.selWebChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[1])
				.selPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[1])
				.selEmailChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[1])
				.clickOnSave();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
		objUpdateStatus1
				.clickOnSelectAll()

				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strAboveValueForUpdate1)

				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[0])

				.enterUpdateSSTValues(strStatusTypeValues[2],
						objView_data.strValueForSST).clickOnSaveButton();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");

		System.out.println("strUpdatedTime" + strUpdatedTime);

		objUpdateStatus1.verWebNotificationframe();

		objUpdateStatus1.verWebNotificationForStatusUpdateForNST(
				objResource_data.strResourceName,
				objStatusTypes_data.strSSTStatusTypeName,
				objView_data.strUpdatedValForSST, strUpdatedTime);

		objUpdateStatus1.verWebNotificationForStatusUpdate(
				objResource_data.strResourceName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusNameInMulti, strUpdatedTime);

		objUpdateStatus1.clickAcknowledgeAllNotifications().selectFrame();

		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + "";

		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation;

		String strMsgBody1 = objMailVerificationFunctions
				.getStatusChangeEmailBodyForNST(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strAboveValueForUpdate1,
						objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName);
		System.out.println(strMsgBody1);

		String strMsgBody2 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strAboveValueForUpdate1,
						objLogindata.strRegionName);
		System.out.println(strMsgBody2);

		String strMsgBody3 = objMailVerificationFunctions
				.getStatusChangeEmailBodyForNST(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strSSTStatusTypeName,
						objView_data.strUpdatedValForSST,
						objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName);
		System.out.println(strMsgBody3);

		String strMsgBody4 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strSSTStatusTypeName,
						objView_data.strUpdatedValForSST,
						objLogindata.strRegionName);
		System.out.println(strMsgBody4);

		String strMsgBody5 = objMailVerificationFunctions
				.getStatusChangeEmailBody(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti,
						objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName);
		System.out.println(strMsgBody5);

		String strMsgBody6 = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti,
						objLogindata.strRegionName);
		System.out.println(strMsgBody6);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			if (boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}

			if (boolCheck2 == false) {
				boolCheck2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody5);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		boolean boolCheck3 = false;
		boolean boolCheck4 = false;
		boolean boolCheck5 = false;
		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjectForPager);

			if (boolCheck3 == false) {
				boolCheck3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			if (boolCheck4 == false) {
				boolCheck4 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody4);
			}

			if (boolCheck5 == false) {
				boolCheck5 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody6);
			}

			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(boolCheck3 && boolCheck4 && boolCheck5);
		assertTrue(boolCheck && boolCheck1 && boolCheck2);
		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that user can receive the status change notifications upon status change of an event related status type.
	'Precondition	: 
	'Date 			: 31-Dec-2015
	'Author 		: Sangappa K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description =" Verify that user can receive the status change notifications upon status change of an event related status type.")
	public void testHappyDay102854() throws Exception {

		gstrTCID ="102854";
		gstrTO = "Verify that user can receive the status change notifications upon status change of an event related status type.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();
		NotificationValues objNotificationValues = new NotificationValues();
		
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createEventStatusType(objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)
		
		
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

          strStatusesValues[0] = objStatusTypeList
		.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

           strStatusesValues[1] = objStatusTypeList
		.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
          
      objStatusTypeList.clickOnReturnToStatusTypeList();
      
 
      objStatusTypeList.navigateToStatusTypeListNew();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		String strApplicationTime = objEventManagement.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strTimeInMin = dts.addTimetoExisting(strTime[2], 5, "HH:mm");
		String strTime1[] = strTimeInMin.split(":");
		System.out.println(strTimeInMin);	

		objStatusTypeList.
		clickCreateNewStatusTypeButton()
		.selectStatusType(objStatusTypes_data.strSaturationScoreStatusType)
		.clickNextButton()
		.enterStatusTypeName(objStatusTypes_data.strSSTStatusTypeName)
		.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription)
		.selectEventOnlyOption()
		.selectShiftTime(strTime1[0], strTime1[1])
		.clickOnSaveButton();
		
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);
		
		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUserdata.strNewUserName, objUserdata.strNewPassword, objUserdata.strFullName)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1
		.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue)
		.clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName);
		
		System.out.println(objEvent_data.strEventName);

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.selectResource(strResourceValue[0]).clickOnNotifications()
				.verEditMyStatusChangePrefPgeDisplayed()
				.expandUncategorizedSec();

		String[] strStatausTypesNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objStatusChangePreference1
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames[i]);
		}

		objStatusChangePreference1
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[0])

				.enterAboveValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strAboveValForSST)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strBelowValForSST)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[2])

				.selWebChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[0])
				.selPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[0])
				.selEmailChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[0])

				.selWebChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[1])
				.selPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[1])
				.selEmailChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[1])
				.clickOnSave();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strAboveValueForUpdate1)

				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[1])

				.enterUpdateSSTValues(strStatusTypeValues[2],
						objView_data.strValueForSST).clickOnSaveButton();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");

		System.out.println(strUpdatedTime);

		objUpdateStatus1.verWebNotificationframe();

		objUpdateStatus1.verWebNotificationForStatusUpdateForNST(
				objResource_data.strResourceName,
				objStatusTypes_data.strSSTStatusTypeName,
				objView_data.strUpdatedValForSST, strUpdatedTime);

		objUpdateStatus1.verWebNotificationForStatusUpdate(
				objResource_data.strResourceName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusNameInMulti1, strUpdatedTime);
		
		objUpdateStatus1.clickAcknowledgeAllNotifications().selectFrame();

		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + "";

		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation;

		String strMsgBody1 = objMailVerificationFunctions
				.getStatusChangeEmailBodyForNST(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strAboveValueForUpdate1,
						objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName);
		System.out.println(strMsgBody1);

		String strMsgBody2 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strAboveValueForUpdate1,
						objLogindata.strRegionName);
		System.out.println(strMsgBody2);

		String strMsgBody3 = objMailVerificationFunctions
				.getStatusChangeEmailBodyForNST(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strSSTStatusTypeName,
						objView_data.strUpdatedValForSST,
						objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName);
		System.out.println(strMsgBody3);

		String strMsgBody4 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strSSTStatusTypeName,
						objView_data.strUpdatedValForSST,
						objLogindata.strRegionName);
		System.out.println(strMsgBody4);

		String strMsgBody5 = objMailVerificationFunctions
				.getStatusChangeEmailBody(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti1,
						objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName);
		System.out.println(strMsgBody5);

		String strMsgBody6 = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti1,
						objLogindata.strRegionName);
		System.out.println(strMsgBody6);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			if (boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}

			if (boolCheck2 == false) {
				boolCheck2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody5);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(boolCheck && boolCheck1 && boolCheck2);

		boolean boolCheck3 = false;
		boolean boolCheck4 = false;
		boolean boolCheck5 = false;
		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjectForPager);

			if (boolCheck3 == false) {
				boolCheck3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			if (boolCheck4 == false) {
				boolCheck4 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody4);
			}

			if (boolCheck5 == false) {
				boolCheck5 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody6);
			}

			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(boolCheck3 && boolCheck4 && boolCheck5);

		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that user with appropriate right can set status change notifications preferences for other users in a region
	'Precondition	: 
	'Date 			: 13-Jan-2016
	'Author 		: Sangappa K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description ="Verify that user with appropriate right can set status change notifications preferences for other users in a region")
	public void testHappyDay118096() throws Exception {

		gstrTCID ="118096";
		gstrTO = "Verify that user with appropriate right can set status change notifications preferences for other users in a region";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();
		NotificationValues objNotificationValues = new NotificationValues();
		
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
	
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// Role NSt

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		//event MST
		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		
		//Private SSt
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(
						objStatusTypes_data.strSaturationScoreStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strSSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectPrivateStatusTypeRadioBtn().clickOnSaveButton();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		// User1

		objUsersList
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectMaintainEventsOption()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		// User2

		objUsersList
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId).selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		System.out.println(objEvent_data.strEventName);

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.clickStatusChangeNotificationPreferencesIsDisplayed();
		objStatusChangePreference1
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.selectResource(strResourceValue[0]).clickOnNotifications()
				.expandUncategorizedSec();

		String[] strStatausTypesNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objStatusChangePreference1
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames[i]);
		}

		objStatusChangePreference1
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[0])

				.enterAboveValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strAboveValForSST)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strBelowValForSST)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[2])

				.selWebChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[0])
				.selPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[0])
				.selEmailChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[0])

				.selWebChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[1])
				.selPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[1])
				.selEmailChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[1])
				.clickOnSave();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatausTypesNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatausTypesNames[i]);
		}

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strAboveValueForUpdate1)

				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[1])

				.enterUpdateSSTValues(strStatusTypeValues[2],
						objView_data.strValueForSST).clickOnSaveButton();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");

		System.out.println(strUpdatedTime);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objUpdateStatus1.verWebNotificationframe();

		objUpdateStatus1.verWebNotificationForStatusUpdateForNST(
				objResource_data.strResourceName,
				objStatusTypes_data.strSSTStatusTypeName,
				objView_data.strUpdatedValForSST, strUpdatedTime);

		objUpdateStatus1.verWebNotificationForStatusUpdate(
				objResource_data.strResourceName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusNameInMulti1, strUpdatedTime);

		objUpdateStatus1.clickAcknowledgeAllNotifications().selectFrame();

		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + "";

		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation;

		String strMsgBody1 = objMailVerificationFunctions
		         .getStatusChangeEmailBodyForNST(objUserdata.strFullName,
				        strUpdatedTime, objResource_data.strResourceName,
				        objStatusTypes_data.strNSTStatusTypeName,
				        objView_data.strAboveValueForUpdate1,
				        objLogindata.strRegionName,
				        objResourceType_data.strResourceTypeName);
		
		String strMsgBody2 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strAboveValueForUpdate1,
						objLogindata.strRegionName);
	

		String strMsgBody3 = objMailVerificationFunctions
				.getStatusChangeEmailBodyForNST(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strSSTStatusTypeName,
						objView_data.strUpdatedValForSST,
						objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName);
		

		String strMsgBody4 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strSSTStatusTypeName,
						objView_data.strUpdatedValForSST,
						objLogindata.strRegionName);
	

		String strMsgBody5 = objMailVerificationFunctions
				.getStatusChangeEmailBody(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti1,
						objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName);
		

		String strMsgBody6 = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti1,
						objLogindata.strRegionName);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			if (boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}

			if (boolCheck2 == false) {
				boolCheck2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody5);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(boolCheck && boolCheck1 && boolCheck2);

		boolean boolCheck3 = false;
		boolean boolCheck4 = false;
		boolean boolCheck5 = false;
		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjectForPager);

			if (boolCheck3 == false) {
				boolCheck3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			if (boolCheck4 == false) {
				boolCheck4 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody4);
			}

			if (boolCheck5 == false) {
				boolCheck5 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody6);
			}

			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(boolCheck3 && boolCheck4 && boolCheck5);

		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	:Verify that status change preference notification are not received by the user when the status changes and when the status change preferences are not set for a text status type.
	'Precondition	: 
	'Date 			: 18-Jan-2016
	'Author 		: Sangappa K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description ="Verify that status change preference notification are not received by the user when the status changes and when the status change preferences are not set for a text status type.")
	public void testHappyDay118149() throws Exception {

		gstrTCID ="118149";
		gstrTO = "Verify that status change preference notification are not received by the user when the status changes and when the status change preferences are not set for a text status type.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();
		NotificationValues objNotificationValues = new NotificationValues();
		
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
	
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// Role Text

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		// User1

		objUsersList
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)		
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		System.out.println(objEvent_data.strEventName);

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
		
		.clickOnAdd()
		.enterResNameInWhatField(objResource_data.strResourceName)
		.clickOnSearch()
		.selectResource(strResourceValue[0])
		.clickOnNotifications()
		.expandUncategorizedSec()
		.verEditMyStatusChangePrefPgeDisplayed()
		.verStatusTypesUnderUncategorizedSec(
				objStatusTypes_data.strTSTStatusTypeName)
	   .verEmailPagerWebChkBoxesAreNotSlected(objStatusTypes_data.strTSTStatusTypeName);			
				
		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strTSTStatusTypeName);
	
		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForTST)
				.clickOnSaveButton();		
		
		objUpdateStatus1.verWebNotificationframeNotDisplyad();
		
		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + "";

		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation;

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubject);
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresentNew(strSubjectForPager);
		                           
		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	
	
	/*************************************************************************************
	'Description 	:Verify that user can set the status change preferences for a NEDOCS status type and thereafter receives the notifications when the status changes
	'Precondition	: 
	'Date 			:19-Jan-2015
	'Author 		:Sangappa K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description ="Verify that user can set the status change preferences for a NEDOCS status type and thereafter receives the notifications when the status changes")
	public void testHappyDay119702() throws Exception {

		gstrTCID ="119702";
		gstrTO = "Verify that user can set the status change preferences for a NEDOCS status type and thereafter receives the notifications when the status changes";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		NotificationValues objNotificationValues = new NotificationValues();
		Date_Time_settings dts = new Date_Time_settings();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

		String strStatusTypeValues[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName2);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName3,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName3);

		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation1,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		System.out.println(objEvent_data.strEventName);

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.selectResource(strResourceValue[0]).clickOnNotifications()
				.verEditMyStatusChangePrefPgeDisplayed()
				.expandUncategorizedSec();

		String[] strStatausTypesNames = {
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strNDSTStatusTypeName2,
				objStatusTypes_data.strNDSTStatusTypeName3 };

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objStatusChangePreference1
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames[i]);
		}

		objStatusChangePreference1
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strAboveValueForNDSt)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strBelowValueForNDSt)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[0])

				.enterAboveValues(strResourceValue[0], strStatusTypeValues[1],
						objNotificationValues.strAboveValueForNDSt)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[1],
						objNotificationValues.strBelowValueForNDSt)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[1])

				.enterAboveValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strAboveValueForNDSt)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strBelowValueForNDSt)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[2])

				.enterAboveValues(strResourceValue[0], strStatusTypeValues[3],
						objNotificationValues.strAboveValueForNDSt)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[3],
						objNotificationValues.strBelowValueForNDSt)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[3])
				.clickOnSave();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatausTypesNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatausTypesNames[i]);
		}

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST)
				.enterNedocsUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForNDST)
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST)
				.enterNedocsUpdateValue(strStatusTypeValues[3],
						objView_data.strValueForNDST).clickOnSaveButton();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");

		System.out.println(strUpdatedTime);

		objUpdateStatus1.verWebNotificationframe();

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objUpdateStatus1.verWebNotificationForStatusUpdateForNST(
					objResource_data.strResourceName, strStatausTypesNames[i],
					objView_data.strNEDOCVal, strUpdatedTime);
		}
		objUpdateStatus1.clickAcknowledgeAllNotifications().selectFrame();

		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + "";

		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation1;

		String strMailBody1 = objMailVerificationFunctions

		.getStatusChangeEmailBodyNEDocsSt(objUserdata.strFullName,
				strUpdatedTime, objResource_data.strResourceName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objView_data.strNEDOCVal, objLogindata.strRegionName,
				objResourceType_data.strResourceTypeName);

		String strMailBody2 = objMailVerificationFunctions
				.getStatusChangeEmailBodyNEDocsSt(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strNDSTStatusTypeName1,
						objView_data.strNEDOCVal, objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName);

		String strMailBody3 = objMailVerificationFunctions
				.getStatusChangeEmailBodyNEDocsSt(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strNDSTStatusTypeName2,
						objView_data.strNEDOCVal, objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName);

		String strMailBody4 = objMailVerificationFunctions
				.getStatusChangeEmailBodyNEDocsSt(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strNDSTStatusTypeName3,
						objView_data.strNEDOCVal, objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName);

		// pagers

		String strPagerBody1 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strNDSTStatusTypeName,
						objView_data.strNEDOCVal, objLogindata.strRegionName);

		String strPagerBody2 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strNDSTStatusTypeName1,
						objView_data.strNEDOCVal, objLogindata.strRegionName);

		String strPagerBody3 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strNDSTStatusTypeName2,
						objView_data.strNEDOCVal, objLogindata.strRegionName);

		String strPagerBody4 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strNDSTStatusTypeName3,
						objView_data.strNEDOCVal, objLogindata.strRegionName);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;
		boolean boolCheck3 = false;

		boolean boolCheck4 = false;
		boolean boolCheck5 = false;
		boolean boolCheck6 = false;
		boolean boolCheck7 = false;

		for (int intCount = 0; intCount < 4; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(strMailBody1);
			}

			if (boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailBody(strMailBody2);
			}

			if (boolCheck2 == false) {
				boolCheck2 = objMailVerificationFunctions
						.verifyMailBody(strMailBody3);
			}
			if (boolCheck3 == false) {
				boolCheck3 = objMailVerificationFunctions
						.verifyMailBody(strMailBody4);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck && boolCheck1 && boolCheck2 && boolCheck3);

		for (int intCount = 0; intCount < 4; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjectForPager);

			if (boolCheck4 == false) {
				boolCheck4 = objMailVerificationFunctions
						.verifyMailContainsBody(strPagerBody1);
			}

			if (boolCheck5 == false) {
				boolCheck5 = objMailVerificationFunctions
						.verifyMailBody(strPagerBody2);
			}

			if (boolCheck6 == false) {
				boolCheck6 = objMailVerificationFunctions
						.verifyMailBody(strPagerBody3);
			}

			if (boolCheck7 == false) {
				boolCheck7 = objMailVerificationFunctions
						.verifyMailBody(strPagerBody4);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(boolCheck4 && boolCheck5 && boolCheck6 && boolCheck7);

		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}

}
