package requirementGroup.MultiRegion;

import static org.testng.Assert.assertTrue;
import lib.dataObject.Login_data;
import lib.dataObject.NotificationValues;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewNotifications extends TestNG_UI_EXTENSIONS {
	
	public NewNotifications() throws Exception {
		super();
	}

	/*************************************************************************************
	 * 'Description 	: Verify that status change preferences for resources of other regions can be edited.    
	 * 'Precondition	: 
	 * 'Date 			: 17-Jun-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that status change preferences for resources of other regions can be edited.")
	public void testHappyDay84631() throws Exception {

		gstrTCID = "84631";
		gstrTO = "Verify that status change preferences for resources of other regions can be edited. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Roles_data objRoles_data = new Roles_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();

		NotificationValues objNotificationValues = new NotificationValues();
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strStateWideReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createSharedStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createSharedResourceWithAddress(objResource_data.strResourceName,
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

		// Create role
		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRoles_data.strRoleName)
				.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectRoleCheckBox(strRoleValue)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objStatusTypes_data.strNSTStatusTypeName);
		System.out.println(objResource_data.strResourceName);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strArkansasReg);

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
						objUserdata.strPrimaryMailId).selectFirstRole()
				.selectViewOtherRegView(objLogindata.strStateWideOklahomaVal)
				.clickAdvancedOptionAndExpand()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		objUsersList
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickStatusChangeNotificationPreferencesIsDisplayed();

		objStatusChangePreference
				.verStatusChangePreferencesforUserPage(
						objUserdata.strNewUserName)
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.verEditMyStatusChangePrefForUserPgeDisplayed(
						objUserdata.strNewUserName).expandUncategorizedSec();

		String[] strStatausTypesNames = {
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName };

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objStatusChangePreference
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames[i]);
		}

		objStatusChangePreference
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strBelowVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strAboveVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[0])

				.enterAboveValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strAboveValForSST)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strBelowValForSST)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[2])

				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[0])
				.clickOnSave();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnEditInMyStatusChangePreferences(
						objResource_data.strResourceName)
				.verEditMyStatusChangePrefPgeDisplayed()
				.expandUncategorizedSec()
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strEdAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strEdBelowVal)
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strEdAboveValForSST)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strEdBelowValForSST)
				.deselEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[0])
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[1])
				.clickOnSave()
				.verMyStatusChangePreferncePgeDisplayed()
				.verAboveAndBelowValues(
						objStatusTypes_data.strNSTStatusTypeName,
						objNotificationValues.strEdAboveVal,
						objNotificationValues.strEdBelowVal)
				.verAboveAndBelowValues(
						objStatusTypes_data.strSSTStatusTypeName,
						objNotificationValues.strEdAboveValForSST,
						objNotificationValues.strEdBelowValForSST)
				.verValueForMultiST(objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti1);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strAboveValueForUpdate3)
				.enterUpdateSSTValues(strStatusTypeValues[2],
						objView_data.strValueForSST2).clickOnSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verWebNotificationframeIsNotPresent();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[1])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strAboveValueForUpdate2)
				.enterUpdateSSTValues(strStatusTypeValues[2],
						objView_data.strValueForSST3).clickOnSaveButton();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");

		System.out.println(strUpdatedTime);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String[] strPreviousVal = { objView_data.strUpdatedValForSST2,
				objView_data.strAboveValueForUpdate3,
				objStatusTypes_data.strStatusNameInMulti };
		String[] strUpdatedVal = { objView_data.strUpdatedValForSST3,
				objView_data.strAboveValueForUpdate2,
				objStatusTypes_data.strStatusNameInMulti1 };

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objUpdateStatus1
					.verWebNotificationForStatusUpdateOfAboveAndBeowValForRes(
							objResource_data.strResourceName,
							strStatausTypesNames[i], strPreviousVal[i],
							strUpdatedVal[i], strUpdatedTime);
		}

		objUpdateStatus1.clickAcknowledgeAllNotifications().selectFrame();

		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + "";

		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation;

		String strMsgBody1 = objMailVerificationFunctions
				.getStatusChangeRSEmailBodyAndOtherReg(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strAboveValueForUpdate3,
						objView_data.strAboveValueForUpdate2,
						objLogindata.strStateWideReg,
						objResourceType_data.strResourceTypeName);
		System.out.println(strMsgBody1);

		String strMsgBody2 = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strAboveValueForUpdate3,
						objView_data.strAboveValueForUpdate2,
						objLogindata.strStateWideReg);
		System.out.println(strMsgBody2);

		String strMsgBody3 = objMailVerificationFunctions
				.getStatusChangeRSEmailBodyAndOtherReg(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strSSTStatusTypeName,
						objView_data.strUpdatedValForSST2,
						objView_data.strUpdatedValForSST3,
						objLogindata.strStateWideReg,
						objResourceType_data.strResourceTypeName);
		System.out.println(strMsgBody3);

		String strMsgBody4 = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strSSTStatusTypeName,
						objView_data.strUpdatedValForSST2,
						objView_data.strUpdatedValForSST3,
						objLogindata.strStateWideReg);
		System.out.println(strMsgBody4);

		String strMsgBody5 = objMailVerificationFunctions
				.getStatusChangeRSEmailBodyAndOtherReg(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusNameInMulti1,
						objLogindata.strStateWideReg,
						objResourceType_data.strResourceTypeName);
		System.out.println(strMsgBody5);

		String strMsgBody6 = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusNameInMulti1,
						objLogindata.strStateWideReg);
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
	 * 'Description 	: Verify that status change preferences for resources of other regions can be deleted.     
	 * 'Precondition	: 
	 * 'Date 			: 17-Jun-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that status change preferences for resources of other regions can be deleted. ")
	public void testHappyDay84635() throws Exception {

		gstrTCID = "84635";
		gstrTO = "Verify that status change preferences for resources of other regions can be deleted. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();

		NotificationValues objNotificationValues = new NotificationValues();
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strStateWideReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createSharedStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createSharedResourceWithAddress(objResource_data.strResourceName,
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
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objStatusTypes_data.strNSTStatusTypeName);
		System.out.println(objResource_data.strResourceName);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strArkansasReg);

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
						objUserdata.strPrimaryMailId).selectFirstRole()
				.selectViewOtherRegView(objLogindata.strStateWideOklahomaVal)
				.clickAdvancedOptionAndExpand()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		objUsersList
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickStatusChangeNotificationPreferencesIsDisplayed();

		objStatusChangePreference
				.verStatusChangePreferencesforUserPage(
						objUserdata.strNewUserName)
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.verEditMyStatusChangePrefForUserPgeDisplayed(
						objUserdata.strNewUserName).expandUncategorizedSec();

		String[] strStatausTypesNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objStatusChangePreference
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames[i]);
		}

		objStatusChangePreference
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strBelowValForSST)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[0])
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[2],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[2])
				.selWebChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1], strStatusesValues[0])
				.clickOnSave();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnDeleteNotificationInMyStatusChangePreferences(
						objResource_data.strResourceName)
				.acceptDeleteNotificationPopUp()
				.verMyStatusChangePreferncePgeDisplayed()
				.verResNameNotDisplyadInMyStatusChangePreferences(
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strNSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strSSTStatusTypeName,
						objResource_data.strResourceName);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate1)
				.enterUpdateSSTValues(strStatusTypeValues[2],
						objView_data.strValueForSST2).clickOnSaveButton();

		objUpdateStatus1.verWebNotificationframeNotDisplyad();

		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + "";
		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation;

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions
				.NavToInboxAndVerEmailIsNotPresent(strSubject);
		
//		objMailVerificationFunctions.clickOnSelectedInbox();

		objMailVerificationFunctions
				.NavToInboxAndVerEmailIsNotPresentNew(strSubjectForPager);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
}
