package requirementGroup.PreferencesStatusChangePrefs;

import static org.testng.AssertJUnit.assertTrue;
import lib.dataObject.Event_data;
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
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewDeleteStatusChangePreferences extends TestNG_UI_EXTENSIONS {

	public NewDeleteStatusChangePreferences() throws Exception {
		super();
	}
	
	/******************************************************************
	'Description : Verify that user can delete the status change notifications.
	'Precondition:
	'Date	 	 : 09-Feb-2016
	'Author		 : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that user can delete the status change notifications.")
	public void testHappyDay70187() throws Exception {

		gstrTCID = "70187";
		gstrTO = "Verify that user can delete the status change notifications.";

		Login_data objTest_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		Roles_data objRoles_data = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Date_Time_settings objDts = new Date_Time_settings();
		NotificationValues objNotificationValues = new NotificationValues();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		String strstatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
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

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

			// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation3,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName1);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName1);

		System.out.println(objUser_data.strNewUserName);

		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectEditStatusChangeNotPrefernceOption()
				.clickSaveButton();
		
		objNavigationToSubMenus.navigateToViews();

		String[] strStatausTypesNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatausTypesNames);
		
//		objViewsList.clickCreateNewViewButton()
//		.enterViewName(objView_data.strViewName)
//		.enterViewDesc(objView_data.strViewDesc);
//
//
//			for (int i = 0; i < strStatausTypesNames.length; i++) {
//			
//				objViewsList.selectStatusType(strStatausTypesNames[i]);
//			}
//
//			objViewsList.selectResource(objResource_data.strResourceName)
//					.clickOnSaveOfCreateNewView();
		
		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateStatusChangeInPreferences();

		objStatusChangePreference
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
			objStatusChangePreference
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames[i]);
		}

		objStatusChangePreference
				.enterAboveValues(strResourceValue[0], strstatusTypeValues[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strstatusTypeValues[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strstatusTypeValues[0])

				.enterAboveValues(strResourceValue[0], strstatusTypeValues[2],
						objNotificationValues.strAboveValForSST)
				.enterBelowValues(strResourceValue[0], strstatusTypeValues[2],
						objNotificationValues.strBelowValForSST)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strstatusTypeValues[2])

				.selWebChkBoxForStatuses(strResourceValue[0],
						strstatusTypeValues[1], strStatusesValues[0])
				.selPagerChkBoxForStatuses(strResourceValue[0],
						strstatusTypeValues[1], strStatusesValues[0])
				.selEmailChkBoxForStatuses(strResourceValue[0],
						strstatusTypeValues[1], strStatusesValues[0])

				.selWebChkBoxForStatuses(strResourceValue[0],
						strstatusTypeValues[1], strStatusesValues[1])
				.selPagerChkBoxForStatuses(strResourceValue[0],
						strstatusTypeValues[1], strStatusesValues[1])
				.selEmailChkBoxForStatuses(strResourceValue[0],
						strstatusTypeValues[1], strStatusesValues[1])
				.clickOnSave();
		
		
		objLogin.clickLogOut();
		
		System.out.println(objUser_data.strNewUserName);
		System.out.println(objEvent_data.strEventName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1.clickOnSelectAll();
		
		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strAboveValueForUpdate)
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[0])
				.enterUpdateSSTValues(strstatusTypeValues[2],
						objView_data.strValueForSST)

				.clickOnSaveButton();
		
	   String strApplicationTime = objEventManagement1.getApplicationTime();
	    
	  String  strCurrentYear = objDts.getCurrentDate("yyyy");
	    
	    strApplicationTime = strApplicationTime+" "+strCurrentYear;
	    
	    String strUpdatedTime = objDts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "dd MMM yyyy HH:mm");
	    
	    System.out.println(strApplicationTime);

		objUpdateStatus1.verWebNotificationframe();

		objUpdateStatus1.verWebNotificationForStatusUpdateForNST(
				objResource_data.strResourceName,
				objStatusTypes_data.strSSTStatusTypeName,
				objView_data.strUpdatedValForSST, strUpdatedTime);

		objUpdateStatus1.verWebNotificationForStatusUpdate(
				objResource_data.strResourceName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusNameInMulti, strUpdatedTime);

		objUpdateStatus1.verWebNotificationForStatusUpdateForNST(
				objResource_data.strResourceName,
				objStatusTypes_data.strNSTStatusTypeName,
				objView_data.strAboveValueForUpdate, strUpdatedTime);
		
		objUpdateStatus1.clickAcknowledgeAllNotifications().selectFrame();

		
		objLogin1.clickLogOut();
		
		String strMsgBody1 = objMailVerificationFunctions
				.getStatusChangeEmailBodyForNST(objUser_data.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strAboveValueForUpdate,
						objTest_data.strRegionName,
						objResourceType_data.strResourceTypeName);

		String strMsgBody2 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strAboveValueForUpdate,
						objTest_data.strRegionName);

		String strMsgBody3 = objMailVerificationFunctions
				.getStatusChangeEmailBodyForNST(objUser_data.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strSSTStatusTypeName,
						objView_data.strUpdatedValForSST,
						objTest_data.strRegionName,
						objResourceType_data.strResourceTypeName);

		String strMsgBody4 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strSSTStatusTypeName,
						objView_data.strUpdatedValForSST,
						objTest_data.strRegionName);

		String strMsgBody5 = objMailVerificationFunctions
				.getStatusChangeEmailBody(objUser_data.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti,
						objTest_data.strRegionName,
						objResourceType_data.strResourceTypeName);

		String strMsgBody6 = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti,
						objTest_data.strRegionName);


		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);


		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + "";

		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation3;

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

		System.out.println(boolCheck3);
		System.out.println(boolCheck4);
		System.out.println(boolCheck5);
		
		objMailVerificationFunctions.logoutMail();
		
		Thread.sleep(5000);
		
		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateStatusChangeInPreferences();
		
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
		objNavigationToSubMenus1.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1.clickOnSelectAll();
		
		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strAboveValueForUpdate)
				.selectMSTUpdateValue(strstatusTypeValues[1],
						strStatusesValues[0])
				.enterUpdateSSTValues(strstatusTypeValues[2],
						objView_data.strValueForSST)

				.clickOnSaveButton();

		objUpdateStatus1.verWebNotificationframeNotDisplyad();
		
		objLogin1.clickLogOut();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions
				.NavToInboxAndVerEmailIsNotPresent(strSubject);

		objMailVerificationFunctions
				.NavToInboxAndVerEmailIsNotPresentNew(strSubjectForPager);
		
		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}
	
  }