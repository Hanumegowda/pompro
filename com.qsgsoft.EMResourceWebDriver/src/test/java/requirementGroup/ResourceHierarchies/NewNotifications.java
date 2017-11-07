package requirementGroup.ResourceHierarchies;

import static org.testng.Assert.assertTrue;
import lib.dataObject.Login_data;
import lib.dataObject.NotificationValues;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.SystemNotifications;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewNotifications extends TestNG_UI_EXTENSIONS{

	public NewNotifications() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*****************************************************************************************************************
	'Description : Verify that user can set status change preferences for status types associated with a sub resource.
	'Date	 	 : 10-Feb-2016
	'Author		 : Anitha
	'-----------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description="Verify that user can set status change preferences for status types associated with a sub resource.")
	public void testHappyDay107475() throws Exception {
		
		gstrTCID = "107475";
		gstrTO = "Verify that user can set status change preferences for status types associated with a sub resource.";

		Login_data objTest_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Resource_data objResource_data = new Resource_data();
		NotificationValues objNotificationValues = new NotificationValues();
		Date_Time_settings dts = new Date_Time_settings();
		
		Login objLogin = new Login(this.driver1);
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strStatusTypeValues2[] = new String[3];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		Views objViews1 = new Views(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		//sNST(shared)
		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		//'pMST'(private)
		objStatusTypeList
				.createPrivateStatusType(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		//rSST (role based)
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objResourceType.createResourceType(
				objResourceType_data.strSubResourceTypeName,
				strStatusTypeValues2);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		objResourceType
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation3)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objResource.clickOnSubResourcesLink(objResource_data.strResourceName)
				.clickOnCreateNewSubResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation3)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton()
				.verSubResourceInResourceListPage(
						objResource_data.strResourceName1);

		strResourceValue[1] = objResource
				.getSubResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId, "",
						objUserdata.strPrimaryMailId).selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		objNavigationToSubmenus.navigateToViews();

		String[] strStatausTypesNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatausTypesNames);
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strStatausTypesNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatausTypesNames[i]);
//		}
//
//		objViewsList
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
//				.verViewInList(objView_data.strViewName)
				objViewsList.clickOncustomizeResourceDetailView()
				.clickSubResourceButton()
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strResourceTypeValue[1]);

		for (int i = 0; i < strStatusTypeValues2.length; i++) {

			objViewsList.selectSubResourceCheckBox(strStatusTypeValues2[i]);
		}

		objViewsList.clickOnSaveButton();

		objLogin.clickLogOut();
		
		System.out.println(objUserdata.strNewUserName);

		System.out.println("-----Precondition ends and test execution starts----");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objNavigationToSubMenus1.navigateStatusChangeInPreferences();

		String strResAndSubRes = objResource_data.strResourceName + ": "
				+ objResource_data.strResourceName1;

		String[] strStatausTypesNames2 = {
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1 };

		objStatusChangePreference
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.verResourceDisplayedInFindResScreen(strResAndSubRes)
				.selectResource(strResourceValue[1])
				.clickOnNotifications()
				.verEditMyStatusChangePrefPgeDisplayed()
				.verSubRTAndResSubResIsDisplayedAsSubHeader(
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strResourceName,
						objResource_data.strResourceName1)
				.expandUncategorizedSec();

		for (int i = 0; i < strStatausTypesNames2.length; i++) {
			objStatusChangePreference
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames2[i]);
		}

		objStatusChangePreference
				.enterAboveValues(strResourceValue[1], strStatusTypeValues2[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[1], strStatusTypeValues2[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[1],
						strStatusTypeValues2[0])
						
				.enterAboveValues(strResourceValue[1], strStatusTypeValues2[2],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[1], strStatusTypeValues2[2],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[1],
						strStatusTypeValues2[2])
						
				.selWebChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[0])
				.selPagerChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[0])
				.selEmailChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[0])

				.selWebChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[1])
				.selPagerChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[1])
				.selEmailChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[1])
				.clickOnSave();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatausTypesNames[i]);
		}

		objViews1.clickOnResource(objResource_data.strResourceName);

		objViewsList1
				.clickOnUpdateStatusOfSubResource(objResource_data.strResourceName1);

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues2[1],
						strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues2[0],
						objView_data.strAboveValueForUpdate)
				.enterUpdateSSTValues(strStatusTypeValues2[2],
						objView_data.strValueForSST).clickOnSaveButton();
		
		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");
		
		System.out.println(strUpdatedTime);

		String[] strStatausTypesNames2InWebNot = {
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strNSTStatusTypeName1};

		String[] strUpdatedVlaues = { objView_data.strUpdatedValForSST,
				objView_data.strAboveValueForUpdate};

		objUpdateStatus1.verWebNotificationframe();
		
		for (int i = 0; i < strStatausTypesNames2InWebNot.length; i++) {
			objUpdateStatus1
					.verWebNotificationForStatusUpdateOfAboveAndBeowValForSubRes(
							objResource_data.strResourceName,
							objResource_data.strResourceName1,
							strStatausTypesNames2InWebNot[i],
							strUpdatedVlaues[i], strUpdatedTime);
		}	
		objUpdateStatus1.verWebNotificationForStatusUpdateOfMSTForSubRes(
				objResource_data.strResourceName,
				objResource_data.strResourceName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusNameInMulti1, strUpdatedTime);

		objUpdateStatus1.clickAcknowledgeAllNotifications().selectFrame();

		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + ": "
				+ objResource_data.strResourceName1 + "";
		
		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation3;

		String strMsgBody1 = objMailVerificationFunctions
				.getStatusChangeSubRSEmailBodyForNST(objUserdata.strFullName,
						strUpdatedTime, strResAndSubRes,
						objStatusTypes_data.strNSTStatusTypeName1,
						objView_data.strAboveValueForUpdate,
						objTest_data.strRegionName);

		String strMsgBody2 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						strResAndSubRes,
						objStatusTypes_data.strNSTStatusTypeName1,
						objView_data.strAboveValueForUpdate,
						objTest_data.strRegionName);

		String strMsgBody3 = objMailVerificationFunctions
				.getStatusChangeSubRSEmailBodyForNST(objUserdata.strFullName,
						strUpdatedTime, strResAndSubRes,
						objStatusTypes_data.strSSTStatusTypeName1,
						objView_data.strUpdatedValForSST,
						objTest_data.strRegionName);

		String strMsgBody4 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						strResAndSubRes,
						objStatusTypes_data.strSSTStatusTypeName1,
						objView_data.strUpdatedValForSST,
						objTest_data.strRegionName);
		
		String strMsgBody5 = objMailVerificationFunctions
				.getStatusChangeSubRSEmailBody(objUserdata.strFullName,
						strUpdatedTime, strResAndSubRes,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusNameInMulti1,
						objTest_data.strRegionName);

		String strMsgBody6 = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						strResAndSubRes,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusNameInMulti1,
						objTest_data.strRegionName);
		
		System.out.println(strMsgBody1);
		System.out.println(strMsgBody2);
		System.out.println(strMsgBody3);
		System.out.println(strMsgBody4);
		System.out.println(strMsgBody5);
		System.out.println(strMsgBody6);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
		boolean blnMsg4 = false;
		boolean blnMsg5 = false;
		boolean blnMsg6 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}
			
			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody5);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjectForPager);

			if (blnMsg4 == false) {
				blnMsg4 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			if (blnMsg5 == false) {
				blnMsg5 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}
			
			if (blnMsg6 == false) {
				blnMsg6 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody6);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg4 && blnMsg5 && blnMsg6);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}


	/*****************************************************************************************************************
	'Description : Verify that user can delete status change preferences set for status types associated with a sub resource. 
	'Date	 	 : 23-Sep-2014
	'Author		 : Anil
	'-----------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description="Verify that user can delete status change preferences set for status types associated with a sub resource. ")
	public void testHappyDay124975() throws Exception {
		
		gstrTCID = "124975";
		gstrTO = "Verify that user can delete status change preferences set for status types associated with a sub resource. ";

		Login_data objTest_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Resource_data objResource_data = new Resource_data();
		NotificationValues objNotificationValues = new NotificationValues();
		Date_Time_settings dts = new Date_Time_settings();
		
		Login objLogin = new Login(this.driver1);
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strStatusTypeValues2[] = new String[3];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		Views objViews1 = new Views(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		//sNST(shared)
		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		//'pMST'(private)
		objStatusTypeList
				.createPrivateStatusType(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		//rSST (role based)
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objResourceType.createResourceType(
				objResourceType_data.strSubResourceTypeName,
				strStatusTypeValues2);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		objResourceType
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation3)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objResource.clickOnSubResourcesLink(objResource_data.strResourceName)
				.clickOnCreateNewSubResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation3)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton()
				.verSubResourceInResourceListPage(
						objResource_data.strResourceName1);

		strResourceValue[1] = objResource
				.getSubResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId, "",
						objUserdata.strPrimaryMailId).selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		objNavigationToSubmenus.navigateToViews();

		String[] strStatausTypesNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatausTypesNames);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strStatausTypesNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatausTypesNames[i]);
//		}
//
//		objViewsList
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
//				.verViewInList(objView_data.strViewName)
		objViewsList.clickOncustomizeResourceDetailView()
				.clickSubResourceButton()
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strResourceTypeValue[1]);

		for (int i = 0; i < strStatusTypeValues2.length; i++) {

			objViewsList.selectSubResourceCheckBox(strStatusTypeValues2[i]);
		}

		objViewsList.clickOnSaveButton();

		objLogin.clickLogOut();
		
		System.out.println(objUserdata.strNewUserName);

		System.out.println("-----Precondition ends and test execution starts----");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objNavigationToSubMenus1.navigateStatusChangeInPreferences();

		String strResAndSubRes = objResource_data.strResourceName + ": "
				+ objResource_data.strResourceName1;

		String[] strStatausTypesNames2 = {
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1 };

		objStatusChangePreference
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.verResourceDisplayedInFindResScreen(strResAndSubRes)
				.selectResource(strResourceValue[1])
				.clickOnNotifications()
				.verEditMyStatusChangePrefPgeDisplayed()
				.verSubRTAndResSubResIsDisplayedAsSubHeader(
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strResourceName,
						objResource_data.strResourceName1)
				.expandUncategorizedSec();

		for (int i = 0; i < strStatausTypesNames2.length; i++) {
			objStatusChangePreference
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames2[i]);
		}

		objStatusChangePreference
				.enterAboveValues(strResourceValue[1], strStatusTypeValues2[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[1], strStatusTypeValues2[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[1],
						strStatusTypeValues2[0])
						
				.enterAboveValues(strResourceValue[1], strStatusTypeValues2[2],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[1], strStatusTypeValues2[2],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[1],
						strStatusTypeValues2[2])
						
				.selWebChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[0])
				.selPagerChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[0])
				.selEmailChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[0])

				.selWebChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[1])
				.selPagerChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[1])
				.selEmailChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[1])
				.clickOnSave();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatausTypesNames[i]);
		}

		objViews1.clickOnResource(objResource_data.strResourceName);

		objViewsList1
				.clickOnUpdateStatusOfSubResource(objResource_data.strResourceName1);

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues2[1],
						strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues2[0],
						objView_data.strAboveValueForUpdate)
				.enterUpdateSSTValues(strStatusTypeValues2[2],
						objView_data.strValueForSST).clickOnSaveButton();
		
		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");
		
		System.out.println(strUpdatedTime);

		String[] strStatausTypesNames2InWebNot = {
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strNSTStatusTypeName1};

		String[] strUpdatedVlaues = { objView_data.strUpdatedValForSST,
				objView_data.strAboveValueForUpdate};

		objUpdateStatus1.verWebNotificationframe();
		
		for (int i = 0; i < strStatausTypesNames2InWebNot.length; i++) {
			objUpdateStatus1
					.verWebNotificationForStatusUpdateOfAboveAndBeowValForSubRes(
							objResource_data.strResourceName,
							objResource_data.strResourceName1,
							strStatausTypesNames2InWebNot[i],
							strUpdatedVlaues[i], strUpdatedTime);
		}	
		objUpdateStatus1.verWebNotificationForStatusUpdateOfMSTForSubRes(
				objResource_data.strResourceName,
				objResource_data.strResourceName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusNameInMulti1, strUpdatedTime);

		objUpdateStatus1.clickAcknowledgeAllNotifications().selectFrame();

		Thread.sleep(3000);
		
		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + ": "
				+ objResource_data.strResourceName1 + "";
		
		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation3;

		String strMsgBody1 = objMailVerificationFunctions
				.getStatusChangeSubRSEmailBodyForNST(objUserdata.strFullName,
						strUpdatedTime, strResAndSubRes,
						objStatusTypes_data.strNSTStatusTypeName1,
						objView_data.strAboveValueForUpdate,
						objTest_data.strRegionName);

		String strMsgBody2 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						strResAndSubRes,
						objStatusTypes_data.strNSTStatusTypeName1,
						objView_data.strAboveValueForUpdate,
						objTest_data.strRegionName);

		String strMsgBody3 = objMailVerificationFunctions
				.getStatusChangeSubRSEmailBodyForNST(objUserdata.strFullName,
						strUpdatedTime, strResAndSubRes,
						objStatusTypes_data.strSSTStatusTypeName1,
						objView_data.strUpdatedValForSST,
						objTest_data.strRegionName);

		String strMsgBody4 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						strResAndSubRes,
						objStatusTypes_data.strSSTStatusTypeName1,
						objView_data.strUpdatedValForSST,
						objTest_data.strRegionName);
		
		String strMsgBody5 = objMailVerificationFunctions
				.getStatusChangeSubRSEmailBody(objUserdata.strFullName,
						strUpdatedTime, strResAndSubRes,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusNameInMulti1,
						objTest_data.strRegionName);

		String strMsgBody6 = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						strResAndSubRes,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusNameInMulti1,
						objTest_data.strRegionName);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
		boolean blnMsg4 = false;
		boolean blnMsg5 = false;
		boolean blnMsg6 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}
			
			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody5);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjectForPager);

			if (blnMsg4 == false) {
				blnMsg4 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			if (blnMsg5 == false) {
				blnMsg5 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}
			
			if (blnMsg6 == false) {
				blnMsg6 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody6);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg4 && blnMsg5 && blnMsg6);

		objMailVerificationFunctions.logoutMail();
		Thread.sleep(5000);
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objNavigationToSubMenus1.navigateStatusChangeInPreferences();
		
		objStatusChangePreference
		.verMyStatusChangePreferncePgeDisplayed()
		.clickOnDeleteNotificationInMyStatusChangePreferences(objResource_data.strResourceName + ": "
				+ objResource_data.strResourceName1)
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
		
		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatausTypesNames[i]);
		}

		objViews1.clickOnResource(objResource_data.strResourceName);

		objViewsList1
				.clickOnUpdateStatusOfSubResource(objResource_data.strResourceName1);

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

	/*****************************************************************************************************************
	'Description : Verify that user can edit the status change preferences set for status types associated with a 
	'			   sub resource.
	'Date	 	 : 10-Feb-2016
	'Author		 : Pallavi
	'-----------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description="Verify that user can edit the status change preferences set for status types associated"
			+ " with a sub resource.")
	public void testHappyDay124974() throws Exception {
		
		gstrTCID = "124974";
		gstrTO = "Verify that user can edit the status change preferences set for status types associated "
				+ "with a sub resource.";

		Login_data objTest_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Resource_data objResource_data = new Resource_data();
		NotificationValues objNotificationValues = new NotificationValues();
		Date_Time_settings dts = new Date_Time_settings();
		
		Login objLogin = new Login(this.driver1);
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strStatusTypeValues2[] = new String[3];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		Views objViews1 = new Views(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		//sNST(shared)
		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		//'pMST'(private)
		objStatusTypeList
				.createPrivateStatusType(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		//rSST (role based)
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objResourceType.createResourceType(
				objResourceType_data.strSubResourceTypeName,
				strStatusTypeValues2);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		objResourceType
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objResource.clickOnSubResourcesLink(objResource_data.strResourceName)
				.clickOnCreateNewSubResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation3)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton()
				.verSubResourceInResourceListPage(
						objResource_data.strResourceName1);

		strResourceValue[1] = objResource
				.getSubResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId, "",
						objUserdata.strPrimaryMailId).selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		objNavigationToSubmenus.navigateToViews();

		String[] strStatausTypesNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
								objResource_data.strResourceName, strStatausTypesNames);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strStatausTypesNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatausTypesNames[i]);
//		}
//
//		objViewsList
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
//				.verViewInList(objView_data.strViewName)
		objViewsList.clickOncustomizeResourceDetailView()
				.clickSubResourceButton()
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strResourceTypeValue[1]);

		for (int i = 0; i < strStatusTypeValues2.length; i++) {

			objViewsList.selectSubResourceCheckBox(strStatusTypeValues2[i]);
		}

		objViewsList.clickOnSaveButton();

		objLogin.clickLogOut();
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objResource_data.strResourceName);
		System.out.println(objView_data.strViewName);

		System.out.println("-----Precondition ends and test execution starts----");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objNavigationToSubMenus1.navigateStatusChangeInPreferences();

		String strResAndSubRes = objResource_data.strResourceName + ": "
				+ objResource_data.strResourceName1;

		String[] strStatausTypesNames2 = {
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1 };

		objStatusChangePreference
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.verResourceDisplayedInFindResScreen(strResAndSubRes)
				.selectResource(strResourceValue[1])
				.clickOnNotifications()
				.verEditMyStatusChangePrefPgeDisplayed()
				.verSubRTAndResSubResIsDisplayedAsSubHeader(
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strResourceName,
						objResource_data.strResourceName1)
				.expandUncategorizedSec();

		for (int i = 0; i < strStatausTypesNames2.length; i++) {
			objStatusChangePreference
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames2[i]);
		}

		objStatusChangePreference
				.enterAboveValues(strResourceValue[1], strStatusTypeValues2[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[1], strStatusTypeValues2[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[1],
						strStatusTypeValues2[0])
						
				.enterAboveValues(strResourceValue[1], strStatusTypeValues2[2],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[1], strStatusTypeValues2[2],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[1],
						strStatusTypeValues2[2])
						
				.selWebChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[0])
				.selPagerChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[0])
				.selEmailChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[0])

				.selWebChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[1])
				.selPagerChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[1])
				.selEmailChkBoxForStatuses(strResourceValue[1],
						strStatusTypeValues2[1], strStatusesValues[1])
				.clickOnSave();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatausTypesNames[i]);
		}

		objViews1.clickOnResource(objResource_data.strResourceName);

		objViewsList1
				.clickOnUpdateStatusOfSubResource(objResource_data.strResourceName1);

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues2[1],
						strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues2[0],
						objView_data.strAboveValueForUpdate)
				.enterUpdateSSTValues(strStatusTypeValues2[2],
						objView_data.strValueForSST).clickOnSaveButton();
		
		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");
		
		System.out.println(strUpdatedTime);

		String[] strStatausTypesNames2InWebNot = {
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strNSTStatusTypeName1};

		String[] strUpdatedVlaues = { objView_data.strUpdatedValForSST,
				objView_data.strAboveValueForUpdate};

		objUpdateStatus1.verWebNotificationframe();
		
		for (int i = 0; i < strStatausTypesNames2InWebNot.length; i++) {
			objUpdateStatus1
					.verWebNotificationForStatusUpdateOfAboveAndBeowValForSubRes(
							objResource_data.strResourceName,
							objResource_data.strResourceName1,
							strStatausTypesNames2InWebNot[i],
							strUpdatedVlaues[i], strUpdatedTime);
		}	
		objUpdateStatus1.verWebNotificationForStatusUpdateOfMSTForSubRes(
				objResource_data.strResourceName,
				objResource_data.strResourceName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusNameInMulti1, strUpdatedTime);

		objUpdateStatus1.clickAcknowledgeAllNotifications().selectFrame();

		Thread.sleep(3000);
		
		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + ": "
				+ objResource_data.strResourceName1 + "";
		
		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation3;

		String strMsgBody1 = objMailVerificationFunctions
				.getStatusChangeSubRSEmailBodyForNST(objUserdata.strFullName,
						strUpdatedTime, strResAndSubRes,
						objStatusTypes_data.strNSTStatusTypeName1,
						objView_data.strAboveValueForUpdate,
						objTest_data.strRegionName);

		String strMsgBody2 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						strResAndSubRes,
						objStatusTypes_data.strNSTStatusTypeName1,
						objView_data.strAboveValueForUpdate,
						objTest_data.strRegionName);

		String strMsgBody3 = objMailVerificationFunctions
				.getStatusChangeSubRSEmailBodyForNST(objUserdata.strFullName,
						strUpdatedTime, strResAndSubRes,
						objStatusTypes_data.strSSTStatusTypeName1,
						objView_data.strUpdatedValForSST,
						objTest_data.strRegionName);

		String strMsgBody4 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						strResAndSubRes,
						objStatusTypes_data.strSSTStatusTypeName1,
						objView_data.strUpdatedValForSST,
						objTest_data.strRegionName);
		
		String strMsgBody5 = objMailVerificationFunctions
				.getStatusChangeSubRSEmailBody(objUserdata.strFullName,
						strUpdatedTime, strResAndSubRes,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusNameInMulti1,
						objTest_data.strRegionName);

		String strMsgBody6 = objMailVerificationFunctions
				.getStatusChangePagerBody(strUpdatedTime,
						strResAndSubRes,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusNameInMulti1,
						objTest_data.strRegionName);
		
		System.out.println(strMsgBody1);
		System.out.println(strMsgBody2);
		System.out.println(strMsgBody3);
		System.out.println(strMsgBody4);
		System.out.println(strMsgBody5);
		System.out.println(strMsgBody6);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
		boolean blnMsg4 = false;
		boolean blnMsg5 = false;
		boolean blnMsg6 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}
			
			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody5);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjectForPager);

			if (blnMsg4 == false) {
				blnMsg4 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			if (blnMsg5 == false) {
				blnMsg5 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}
			
			if (blnMsg6 == false) {
				blnMsg6 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody6);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg4 && blnMsg5 && blnMsg6);

		objMailVerificationFunctions.logoutMail();

		Thread.sleep(3000);
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objNavigationToSubMenus1.navigateStatusChangeInPreferences();
		
		objStatusChangePreference.verMyStatusChangePreferncePgeDisplayed()
							  	 .clickOnEditInMyStatusChangePreferences(
							  			 strResAndSubRes)
							  	 .expandUncategorizedSec()
//							  	 .verNotificationChkBoxSelectedForMST(
//										  strResourceValue[1], strStatusTypeValues2[1],
//										  strStatusesValues[0])
//								  .verNotificationChkBoxSelectedForMST(
//										  strResourceValue[1], strStatusTypeValues2[1],
//										  strStatusesValues[1])
//								  .verNotificationChkBoxSelectedForOtherAbove(
//										  strResourceValue[1], strStatusTypeValues2[0])
//								  .verNotificationChkBoxSelectedForOtherBelow(
//										  strResourceValue[1], strStatusTypeValues2[0])
//								  .verNotificationChkBoxSelectedForOtherAbove(
//										  strResourceValue[1], strStatusTypeValues2[2])
//								  .verNotificationChkBoxSelectedForOtherBelow(
//										  strResourceValue[1], strStatusTypeValues2[2])
								  .deselEmailChkBoxForStatuses(
										  strResourceValue[1], strStatusTypeValues2[1],
										  strStatusesValues[0])
								  .deselEmailChkBoxForStatuses(
										  strResourceValue[1], strStatusTypeValues2[1],
										  strStatusesValues[1])
								  .deSelPagerChkBoxForAboveAndBelowVal(
										strResourceValue[1], strStatusTypeValues2[0])
								  .deSelPagerChkBoxForAboveAndBelowVal(
										strResourceValue[1], strStatusTypeValues2[2])
								  .clickOnSave();
		
		objNavigationToSubMenus1
			.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatausTypesNames[i]);
		}

		objViews1.clickOnResource(objResource_data.strResourceName);

		objViewsList1
				.clickOnUpdateStatusOfSubResource(objResource_data.strResourceName1);

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues2[1],
						strStatusesValues[1])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues2[0],
						objView_data.strAboveValueForUpdate1)
				.enterUpdateSSTValues(strStatusTypeValues2[2],
						objView_data.strValueForSST2)
				.clickOnSaveButton();

		strFetchAppDateTime = objEventManagement1.getApplicationTime();
		strCurYear = dts.getCurrentDate("yyyy");
		strAppTime = strFetchAppDateTime.split(" ");

		strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");

		System.out.println(strUpdatedTime);

		String[] strStatausTypesNames2InWebNotif1 = {
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strNSTStatusTypeName1 };

		String[] strUpdatedVlaues1 = { objView_data.strUpdatedValForSST2,
				objView_data.strAboveValueForUpdate1};

		objUpdateStatus1.verWebNotificationframe();

		for (int i = 0; i < strStatausTypesNames2InWebNotif1.length; i++) {
			objUpdateStatus1
					.verWebNotificationForStatusUpdateOfAboveAndBeowValForSubRes(
							objResource_data.strResourceName,
							objResource_data.strResourceName1,
							strStatausTypesNames2InWebNotif1[i],strUpdatedVlaues[i],
							strUpdatedVlaues1[i], strUpdatedTime);
		}
		
		objUpdateStatus1.verWebNotificationForStatusUpdateOfAboveAndBeowValForSubRes(
				objResource_data.strResourceName,
				objResource_data.strResourceName1,
				objStatusTypes_data.strMSTStatusTypeName1,objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusNameInMulti2, strUpdatedTime);

		objUpdateStatus1.clickAcknowledgeAllNotifications()
					    .selectFrame();

		objLogin1.clickLogOut();
		
		strMsgBody1 = objMailVerificationFunctions
				.getStatusChangeSubRSEmailBody(objUserdata.strFullName,
						strUpdatedTime, strResAndSubRes,
						objStatusTypes_data.strNSTStatusTypeName1,objView_data.strAboveValueForUpdate,
						objView_data.strAboveValueForUpdate1,
						objTest_data.strRegionName);
		
		strMsgBody3 = objMailVerificationFunctions
				.getStatusChangeSubRSEmailBody(objUserdata.strFullName,
						strUpdatedTime, strResAndSubRes,
						objStatusTypes_data.strSSTStatusTypeName1,objView_data.strUpdatedValForSST,
						objView_data.strUpdatedValForSST2,
						objTest_data.strRegionName);
		
		strMsgBody6 = objMailVerificationFunctions
					.getStatusChangePagerBody(strUpdatedTime,
							strResAndSubRes,
							objStatusTypes_data.strMSTStatusTypeName1,objStatusTypes_data.strStatusNameInMulti1,
							objStatusTypes_data.strStatusNameInMulti2,
							objTest_data.strRegionName);
		
		System.out.println("2nd Email for NST: " + strMsgBody1);
		System.out.println("2nd Email for SST: " + strMsgBody3);
		System.out.println("2nd pager for MST: " + strMsgBody6);
		
		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		blnMsg1 = false;
		blnMsg2 = false;
		blnMsg3 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}
			
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
				strSubjectForPager);

		if (blnMsg3 == false) {
			blnMsg3 = objMailVerificationFunctions
					.verifyMailContainsBody(strMsgBody6);
		}

		objMailVerificationFunctions.backToMailInbox();

		assertTrue(blnMsg3);

		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresentNew(strSubject);
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresentNew(strSubjectForPager);
		
		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that expired status notification is received for a sub resource.  
	 * 'Precondition	: 
	 * 'Date 			: 10-Feb-2016 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that expired status notification is received for a sub resource. ")
	public void testHappyDay120502() throws Exception {

		gstrTCID = "120502";
		gstrTO = "Verify that sub-resources can be added to the resource detail view.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Date_Time_settings objDts = new Date_Time_settings();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		SystemNotifications objSystemNotifications_page = new SystemNotifications(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createSharedStatusTypeWithExpirationTimeAndSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName,
				objStatusTypes_data.strStatusExpirationTime);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectSectionName(objView_data.strSectionName)
				.clickOnSaveButton();

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectEventExpirationOption()
				.selectExpirationMinute(objStatusTypes_data.strExpSec)
				.clickOnSaveButton();

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.clickOnSaveButton();

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithExpirationTimeAndSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName,
				objStatusTypes_data.strStatusExpirationTime);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithExpirationTimeAndSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName,
				objStatusTypes_data.strStatusExpirationTime);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithExpirationTimeAndSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName,
				objStatusTypes_data.strStatusExpirationTime);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithExpirationTimeAndSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName,
				objStatusTypes_data.strStatusExpirationTime);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.navigateToResourceTypePage()
				.createResourceType(
						objResourceType_data.strSubResourceTypeName,
						strStatusTypeValues)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.enterResourceTypeDescription(
						objResourceType_data.strResTypeDescription)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
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

		objResource.clickOnSubResourcesLink(objResource_data.strResourceName)
				.createSubResourceForResource(
						objResource_data.strSubResourceName,
						objResource_data.strResourceAbbrivation1,
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId, "",
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnsystemNotifyPreferences();

		objSystemNotifications_page.selectAndSaveExpiredStatusNotification();

		System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.verRegionViewListPageIsDisplayed()
				.verCreateNewViewReorderAndCustomizeDetailViewButton();

		objViewsList
				.clickOncustomizeResourceDetailView()
				.verEditResourceDetailViewSectionsPageIsDisplayed()
				.verifySubResourceButton()
				.verifyCancelButton()
				.verifySortAllButton()
				.verifySaveButton()
				.clickSubResourceButton()
				.verEditSubResourceDetailViewSectionsPageIsDisplayed()
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0]);

		for (int i = 0; i < strStatusTypeValues.length; i++) {
			objViewsList.selectSubResourceCheckBox(strStatusTypeValues[i]);
		}
		objViewsList.clickOnSaveButton().verRegionViewListPageIsDisplayed();

		objLogin.clickLogOut();

		System.out
				.println("---Precondition ends and test execution starts----");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickOnViewInfoInPopupWindow();

		objViewsList1
				.clickOnUpdateStatusOfSubResource(objResource_data.strSubResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate)
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForUpdate1)
				.enterUpdateSSTValues(strStatusTypeValues[3],
						objView_data.strValueForSST)
				.enterNedocsUpdateValue(strStatusTypeValues[4],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
						objView_data.strDateUpdateValue).clickOnSaveButton();

		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");

		System.out.println(strApplicationTime);

		// wait until expiration time
		Thread.sleep(360000);

		objLogin1.clickLogOut();

		String strSubject = "Expired Status Notification: "
				+ objResource_data.strResourceName + ": "
				+ objResource_data.strSubResourceName;

		String strSubject1 = "Expired Status: "
				+ objResource_data.strResourceAbbrivation1;

		String strMsgBody1 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strNSTStatusTypeName,
						objResource_data.strResourceName + ": "
								+ objResource_data.strSubResourceName,
						strApplicationTime);

		String strMsgBody2 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strNSTStatusTypeName,
						objResource_data.strResourceName + ": "
								+ objResource_data.strSubResourceName,
						strApplicationTime);

		String strMsgBody3 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName + ": "
								+ objResource_data.strSubResourceName,
						strApplicationTime);

		String strMsgBody4 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName + ": "
								+ objResource_data.strSubResourceName,
						strApplicationTime);

		String strMsgBody5 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strTSTStatusTypeName,
						objResource_data.strResourceName + ": "
								+ objResource_data.strSubResourceName,
						strApplicationTime);

		String strMsgBody6 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strTSTStatusTypeName,
						objResource_data.strResourceName + ": "
								+ objResource_data.strSubResourceName,
						strApplicationTime);

		String strMsgBody7 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strSSTStatusTypeName,
						objResource_data.strResourceName + ": "
								+ objResource_data.strSubResourceName,
						strApplicationTime);

		String strMsgBody8 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strSSTStatusTypeName,
						objResource_data.strResourceName + ": "
								+ objResource_data.strSubResourceName,
						strApplicationTime);

		String strMsgBody9 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strNDSTStatusTypeName,
						objResource_data.strResourceName + ": "
								+ objResource_data.strSubResourceName,
						strApplicationTime);

		String strMsgBody10 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strNDSTStatusTypeName,
						objResource_data.strResourceName + ": "
								+ objResource_data.strSubResourceName,
						strApplicationTime);

		String strMsgBody11 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strDateStatusTypeName,
						objResource_data.strResourceName + ": "
								+ objResource_data.strSubResourceName,
						strApplicationTime);

		String strMsgBody12 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strDateStatusTypeName,
						objResource_data.strResourceName + ": "
								+ objResource_data.strSubResourceName,
						strApplicationTime);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;
		boolean boolCheck3 = false;
		boolean boolCheck4 = false;
		boolean boolCheck5 = false;

		for (int intCount = 0; intCount < 6; intCount++) {

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

			if (boolCheck3 == false) {
				boolCheck3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody7);
			}
			if (boolCheck4 == false) {
				boolCheck4 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody9);
			}

			if (boolCheck5 == false) {
				boolCheck5 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody11);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(boolCheck && boolCheck1 && boolCheck2 && boolCheck3
				&& boolCheck4 && boolCheck5);

		boolCheck = false;
		boolCheck1 = false;
		boolCheck2 = false;
		boolCheck3 = false;
		boolCheck4 = false;
		boolCheck5 = false;

		for (int intCount = 0; intCount < 6; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject1);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}

			if (boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}
			if (boolCheck2 == false) {
				boolCheck2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody6);
			}

			if (boolCheck3 == false) {
				boolCheck3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody8);
			}
			if (boolCheck4 == false) {
				boolCheck4 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody10);
			}

			if (boolCheck5 == false) {
				boolCheck5 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody12);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(boolCheck && boolCheck1 && boolCheck2 && boolCheck3
				&& boolCheck4 && boolCheck5);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
}
