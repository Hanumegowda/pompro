package requirementGroup.SetUp;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
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
import lib.page.StatusTypeList;
import lib.page.SystemNotifications;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayStatusTypes extends TestNG_UI_EXTENSIONS {

	public HappyDayStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*******************************************************************************************************************
	 * 'Description : Verify that status types associated to resource type while
	 * creating status types are displayed on 'Event Status' page Date :
	 * 09-Sep-2014 'Author : Anil
	 ********************************************************************************************************************/
	@Test(description = "Verify that status types associated to resource type while creating status types are displayed on 'Event Status' page")
	public void testHappyDay143844() throws Exception {

		gstrTCID = "143844";
		gstrTO = "Verify that status types associated to resource type while creating status types are displayed on 'Event Status' page";

		Login_data objTest_data = new Login_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		String strStatusTypeValues[] = new String[2];
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition);

		for (int intCount = 0; intCount < strResourceTypeValue.length; intCount++) {
			objEventSetUp.selectResourceType(strResourceTypeValue[intCount]);
		}

		for (int intCount = 0; intCount < strStatusTypeValues.length; intCount++) {
			objEventSetUp.selectStatusType(strStatusTypeValues[intCount]);
		}

		objEventSetUp.clickSaveButton().deselectSelectAllWebOption();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName)
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objNavigationToSubmenus1.navigateToEventMenu();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeSelectingRT(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, strResourceTypeValue);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objEventManagement1.navigateToEventManagementNew().clickOnEditLink(
				objEvent_data.strEventName);

		for (int intCount = 0; intCount < strStatusTypeNames.length; intCount++) {

			objEventManagement1
					.verifyStatusTypesIsSelected(strStatusTypeValues[intCount]);
		}

		objEventManagement1.selectStatusType(strStatusTypeValues1[0])

		.clickOnSaveButton().verifyEventName(objEvent_data.strEventName)
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames1 = {
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames1[i]);
		}

		gstrResult = "PASS";
	}

	/*******************************************************************************************************************
	 * 'Description : Verify that user do not receive 'Expired Status Notification' via web when the status type expires. 
	 * Date : 10-Sep-2014
	 * 'Author : Anil
	 ********************************************************************************************************************/
	@Test(description = "Verify that user do not receive 'Expired Status Notification' via web when the status type expires. ")
	public void testHappyDay143778() throws Exception {

		gstrTCID = "143778";
		gstrTO = "Verify that user do not receive 'Expired Status Notification' via web when the status type expires. ";

		// Objects for data
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(
				this.driver1);
		ViewsList ViewsList_Page = new ViewsList(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		UpdateStatus UpdateStatus_Page1 = new UpdateStatus(
				this.driver1);
		
		String strstatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];
		String strstatusesValues[] = new String[1];
		
		String strResource = objResource_data.strResourceName;
		String strSubject = "Expired Status Notification: "
				+ strResource;
		String strSubject1 = "Expired Status: "+objResource_data.strResourceAbbrivation;

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		StatusTypeList_page.navigateToStatusTypeList();

		StatusTypeList_page.createStatusTypeWithExpirationTime(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)

		.createNewStatusWithExpirationTime(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusExpirationTime)
		
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);
		
		strstatusesValues[0] = StatusTypeList_page.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti);
				
		StatusTypeList_page.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList()
		
		.navigateToStatusTypeListNew();
		
		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		StatusTypeList_page.createStatusTypeWithExpirationTime(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);

		strstatusTypeValues[2] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		StatusTypeList_page.createStatusTypeWithExpirationTime(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);

		strstatusTypeValues[3] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		StatusTypeList_page.createStatusTypeWithExpirationTime(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);

		strstatusTypeValues[4] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage();

		ResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		// Resource creation
		Resource_Page.navigateToResourceListPage();

		Resource_Page.createResource(strResource,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceTypeValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation

		UsersList_page.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);
		
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

				.selectViewResourceCheckBox(objResource_data.strResourceName)

				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMustUpdateOverdueStatusOption()

				.clickSaveButton();

		UsersList_page.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption);

		UsersList_page.editUserDetails(objUser_data.strNewUserName);

		UsersList_page.clickOnsystemNotifyPreferences();

		SystemNotifications_page.selectAndSaveExpiredStatusNotification();

		String[] strSTNames= {objStatusTypes_data.strNSTStatusTypeName,objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,objStatusTypes_data.strNDSTStatusTypeName,objStatusTypes_data.strTSTStatusTypeName};
		
		ViewsList_Page
				.navigateToStatusTypeList()
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strSTNames)
				.verViewInList(objView_data.strViewName);

		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame()

		.verifyUpdateStatusPage();	
		
		UpdateStatus_Page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0], objView_data.strValueForUpdate);
		
		UpdateStatus_Page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[4], objView_data.strValueForTST);
		
		UpdateStatus_Page1.enterUpdateSSTValues(strstatusTypeValues[2], objView_data.strValueForSST);		
		
		UpdateStatus_Page1.enterNedocsUpdateValue(strstatusTypeValues[3], objView_data.strValueForNDST);

		UpdateStatus_Page1.selectMSTUpdateValue(strstatusTypeValues[1], strstatusesValues[0]);
		
		UpdateStatus_Page1.clickOnSaveButton();
		
		System.out.println("Wait for 5 minutes");
		Thread.sleep(360000);
		System.out.println("Waiting is completed");

		RegionDefault_Page1.verifyUpdateStatusPage();
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		int intTotalCount = 0;
		
		while(intTotalCount < 15){
			int intCount = 0;
			int intCount1 = 0;
			intCount = objMailVerificationFunctions.getTotalEMailCount(strSubject);
			intCount1 = objMailVerificationFunctions.getTotalEMailCount(strSubject1);
			intTotalCount = intTotalCount+ intCount + intCount1;
			objMailVerificationFunctions.clickOnNextButton();
			
		}
		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	/***********************************************************************************
	'Description	:Verify that status types associated to resource type while creating
	                 status types are displayed on map page
	'Date	 		:11-Sep-2014
	'Author			:Anitha
	************************************************************************************/

	@Test(description = "Verify that status types associated to resource type while creating status types are displayed on map page")
	public void testHappyDay143814() throws Exception {
		gstrTCID = "143814";
		gstrTO = "Verify that status types associated to resource type while creating status types are displayed on map page";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1= new SelectRegion(this.driver1);
		StatusTypeList StatusTypeList_Page1 = new StatusTypeList(this.driver1);
		Map Map_Page1 = new Map(this.driver1);
		NavigationToSubMenus NavigationToSubmenus_Page1 = new NavigationToSubMenus(
				this.driver1);	

		String strstatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		StatusTypeList_page.navigateToStatusTypeList();

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage();

		ResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation

		Resource_Page.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page.navigateToUsersNew();

		UsersList_page.clickCreateNewUserButton();

		UsersList_page
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.selectFirstRole()

				.selectViewResourceCheckBox(objResource_data.strResourceName)

				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		NavigationToSubmenus_Page1.navigateToMap();

		String[] strStatusTypeNames = {
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName };
		Map_Page1
				.selectResourceNameInFindResourceDropdown(
						objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames);

		login_page1.clickLogOut();

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page1.selectFrame();

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame();

		NavigationToSubmenus_Page1.navigateToStatusTypesInSetup();

		StatusTypeList_Page1.createStatusTypeSelectingRT(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, strResourceTypeValue);

		login_page1.clickLogOut();

		login_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		NavigationToSubmenus_Page1.navigateToMap();

		String[] strStatusTypeNames1 = {
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };
		Map_Page1
				.selectResourceNameInFindResourceDropdown(
						objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames1);

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	'Description	:Verify that sub-resource text is appended to sub resource types on create / edit status type screen.
	'Date	 		:12-Sep-2014
	'Author			:Anitha
	********************************************************************************************************************/

	@Test(description = "Verify that sub-resource text is appended to sub resource types on create / edit status type screen.")
	public void testHappyDay143925() throws Exception {
		gstrTCID = "143925";
		gstrTO = "Verify that sub-resource text is appended to sub resource types on create / edit status type screen.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		StatusTypeList StatusTypeList_Page1 = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page1 = new ResourceType(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page1.selectFrame();
		
		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame();

		StatusTypeList_Page1.navigateToStatusTypeList();

		StatusTypeList_Page1.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_Page1
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		System.out.println(objStatusTypes_data.strNSTStatusTypeName);
		
		System.out.println(strstatusTypeValues[0]);

		// Resource type creation
		ResourceType_Page1.navigateToResourceTypePage();

		ResourceType_Page1.createSubResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page1
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		StatusTypeList_Page1.navigateToStatusTypeListNew();

		StatusTypeList_Page1
				.clickCreateNewStatusTypeButton()
				.selectStatusType(
						objStatusTypes_data.strNedocCalculationStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
						
				.verSubresourceTextForRT(strResourceTypeValue[0],
						objResourceType_data.strResourceTypeName)
				.selectResourceType(strResourceTypeValue[0])
				.clickOnSaveButton()

				.clickOnEditOfStatusType(
						objStatusTypes_data.strNSTStatusTypeName)
				.verSubresourceTextForRT(strResourceTypeValue[0],
						objResourceType_data.strResourceTypeName);

		gstrResult = "PASS";
	}
	
}
