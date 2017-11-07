package requirementGroup.PreferencesStatusChangePrefs;

import static org.testng.Assert.assertTrue;
import lib.dataObject.Login_data;
import lib.dataObject.NotificationValues;
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
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEditStatusChangePreferences extends TestNG_UI_EXTENSIONS {

	public NewEditStatusChangePreferences() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description 	: Verify that user can edit the status change notifications.
	'Precondition	: 
	'Date 			: 09-Feb-2016 
	'Author 		: Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user can edit the status change notifications.")
	public void testHappyDay70186() throws Exception {

		gstrTCID = "70186";
		gstrTO = "Verify that user can edit the status change notifications.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();
		ResourceType_data objResourceType_data = new ResourceType_data();
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
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strStatusesValues[]= new String[2];
		String strResourceTypeValue[] = new String[1];
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
				objResource_data.strResourceAbbrivation3,
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
			    .selectViewResourceRights(
			    		objResource_data.strResourceName)
				.selectUpdateStatusOfResource(
						objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectEditStatusChangeNotPrefernceOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		String[] strStatausTypesNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };
		
		objViewsList.navigateToViewsList()
					.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatausTypesNames);
		
//		objViewsList.navigateToViewsList()
//				    .clickCreateNewViewButton()
//				    .enterViewName(
//				    		objView_data.strViewName)
//				    .enterViewDesc(
//				    		objView_data.strViewDesc)
//				    .selectStatusTypeForView(
//				    		strStatusTypeValues)
//				    .selectResource(
//				    		objResource_data.strResourceName)
//				    .clickOnSaveOfCreateNewView();

		System.out.println(objView_data.strViewName);
		
		objLogin.clickLogOut()
				.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

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
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1.verMyStatusChangePreferncePgeDisplayed()
								  .clickOnEditInMyStatusChangePreferences(
										  objResource_data.strResourceName)
								  .expandUncategorizedSec()
								  .verNotificationChkBoxSelectedForMST(
										  strResourceValue[0], strStatusTypeValues[1],
										  strStatusesValues[0])
								  .verNotificationChkBoxSelectedForMST(
										  strResourceValue[0], strStatusTypeValues[1],
										  strStatusesValues[1])
								  .verNotificationChkBoxSelectedForOtherAbove(
										  strResourceValue[0], strStatusTypeValues[0])
								  .verNotificationChkBoxSelectedForOtherBelow(
										  strResourceValue[0], strStatusTypeValues[0])
								  .verNotificationChkBoxSelectedForOtherAbove(
										  strResourceValue[0], strStatusTypeValues[2])
								  .verNotificationChkBoxSelectedForOtherBelow(
										  strResourceValue[0], strStatusTypeValues[2])
								  .deselEmailChkBoxForStatuses(
										  strResourceValue[0], strStatusTypeValues[1],
										  strStatusesValues[0])
								  .deselEmailChkBoxForStatuses(
										  strResourceValue[0], strStatusTypeValues[1],
										  strStatusesValues[1])
								 .deselWebChkBoxForStatuses(
										  strResourceValue[0], strStatusTypeValues[1],
										  strStatusesValues[0])
								 .deselWebChkBoxForStatuses(
										  strResourceValue[0], strStatusTypeValues[1],
										  strStatusesValues[1])
								.deSelPagerChkBoxForAboveAndBelowVal(
										strResourceValue[0], strStatusTypeValues[0])
								.deselWebChkBoxForAboveAndBelowVal(
										strResourceValue[0], strStatusTypeValues[0])
								.deSelEmailChkBoxForAboveAndBelowVal(
										 strResourceValue[0], strStatusTypeValues[2])
								.deSelPagerChkBoxForAboveAndBelowVal(
										strResourceValue[0], strStatusTypeValues[2])
								.clickOnSave();
		
		objNavigationToSubmenus1.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
		
		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues[1],
								strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strAboveValueForUpdate1)
				.enterUpdateSSTValues(strStatusTypeValues[2],
						objView_data.strValueForSST)
				.clickOnSaveButton();
		
		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");
		
		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");
		
		System.out.println("strUpdatedTime " + strUpdatedTime);
		
		objUpdateStatus1.verWebNotificationframe();
		
		objUpdateStatus1.verWebNotificationForStatusUpdateForNST(
								objResource_data.strResourceName,
								objStatusTypes_data.strSSTStatusTypeName,
								objView_data.strUpdatedValForSST, strUpdatedTime)
						.verWebNotificationDoesNotContainParticularST(
								objResource_data.strResourceName,
								objStatusTypes_data.strNSTStatusTypeName,
								objView_data.strAboveValueForUpdate1, strUpdatedTime)
						.verWebNotificationDoesNotContainMST(
								objResource_data.strResourceName,
								objStatusTypes_data.strMSTStatusTypeName,
								objStatusTypes_data.strStatusNameInMulti,
								strUpdatedTime)
						.clickAcknowledgeAllNotifications()
						.selectFrame();
		
		objLogin1.clickLogOut();
		
		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + "";

		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation3;
		
		String strEmailBody = objMailVerificationFunctions
								.getStatusChangeEmailBodyForNST(
										objUserdata.strFullName, strUpdatedTime,
										objResource_data.strResourceName,
										objStatusTypes_data.strNSTStatusTypeName,
										objView_data.strAboveValueForUpdate1,
										objLogindata.strRegionName,
										objResourceType_data.strResourceTypeName);
		
		String strEmailBodyForMST = objMailVerificationFunctions
				.getStatusChangeEmailBodyForNST(
						objUserdata.strFullName, strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti,
						objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName);
		
		String strPagerBody = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti,
						objLogindata.strRegionName);
		
		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;
		boolean boolCheck1 = false;boolean blnCheck2 = false;

		for (int i = 0; i < 2; i++) {
			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(strEmailBody);
			}

			if (blnCheck2 == false) {
				blnCheck2 = objMailVerificationFunctions
						.verifyMailContainsBody(strEmailBodyForMST);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		
		assertTrue(boolCheck&&blnCheck2);

		objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
				strSubjectForPager);

		if (boolCheck1 == false) {
			boolCheck1 = objMailVerificationFunctions
					.verifyMailContainsBody(strPagerBody);
		}
		
		objMailVerificationFunctions.backToMailInbox();
		
		assertTrue(boolCheck1);
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresentNew(strSubject);
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresentNew(strSubjectForPager);
		
		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
}
