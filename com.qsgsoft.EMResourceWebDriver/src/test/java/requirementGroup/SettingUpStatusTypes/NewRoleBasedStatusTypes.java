package requirementGroup.SettingUpStatusTypes;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
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
import lib.page.SystemNotifications;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewRoleBasedStatusTypes extends TestNG_UI_EXTENSIONS {

	public NewRoleBasedStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*************************************************************************************
	'Description :Status type ST is associated with resource RS at the resource type level. Verify that a user with ‘Update Status’ right on resource RS but without view/update rights for status type ST DOES NOT receive expired status notifications when the status of ST expires.
	'Date	 	 : 25-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Status type ST is associated with resource RS at the resource type level. Verify that a user with ‘Update Status’ right on resource RS but without view/update rights for status type ST DOES NOT receive expired status notifications when the status of ST expires.")
	public void testHappyDay44223() throws Exception {

		gstrTCID = "44223";
		gstrTO = "Status type ST is associated with resource RS at the resource type level. Verify that a user with ‘Update Status’ right on resource RS but without view/update rights for status type ST DOES NOT receive expired status notifications when the status of ST expires.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		SystemNotifications objSystemNotifications_page = new SystemNotifications(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strStatusesValues1[] = new String[2];
		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.deleteDefaultRoleIfExist();
		

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
				.selectEventExpirationOption()
				.selectExpirationMinute(objStatusTypes_data.strExpSec)
				.clickOnSaveButton();

		strStatusesValues[1] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		StatusTypeList_page.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		String strApplicationTime = objEventManagement.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strTimeInMin = objDts.addTimetoExisting(strTime[2], 10, "HH:mm");
		String strTime1[] = strTimeInMin.split(":");
		System.out.println(strTimeInMin);	

		StatusTypeList_page.createStatusTypeWithShiftTime(objStatusTypes_data.strMultiStatusType, objStatusTypes_data.strMSTStatusTypeName1, 
						objStatusTypes_data.strStatusDescription,strTime1[0], strTime1[1]);
		
			StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti2)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.clickOnSaveButton();
			
		strStatusesValues1[0] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti3)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.clickOnSaveButton();
		
		strStatusesValues1[1] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);
		
		StatusTypeList_page.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);
		
		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		// Resource creation
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page.createResourceWithAddress(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, 
				objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName, objResource_data.strStreetAddress, objResource_data.strCity, objResource_data.strState, objResource_data.strCounty, objResource_data.strZipcode);

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
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnsystemNotifyPreferences();
		objSystemNotifications_page.selectAndSaveExpiredStatusNotification();
		
		objUsersList.navigateToUsers();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.selectViewResourceRights(objResource_data.strResourceName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
		
		System.out.println(objResource_data.strResourceName);

		objLogin.clickLogOut();
		
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		objMap1.clickUpdateStatusInPopupWindow();
		objUpdateStatus1.clickOnSelectAll();
		
		objUpdateStatus1
				.verUpdateStatusPge()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues1[0])
				.clickOnSaveButton();

		objLogin1.clickLogOut();


		// wait until expiration time
		Thread.sleep(360000);
		
		String strSubject = "Expired Status Notification: "
				+ objResource_data.strResourceName;

		String strSubject1 = "Expired Status: "
				+ objResource_data.strResourceAbbrivation;

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubject);

		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresentNew(strSubject1);
		
		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	
	/*************************************************************************************
	'Description : Verify that the number status type of a resource can be updated from the following screens:
					1. View Screen
					2. Resource Detail Screen
					3. Map Screen
					4. Event Detail Screen 
	'Precondition:
	'Date	 	 : 19-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that the number status type of a resource can be updated from the following screens:"+
			"1. View Screen"+
			"2. Resource Detail Screen"+
			"3. Map Screen"+
			"4. Event Detail Screen")
	
	public void testHappyDay66027() throws Exception {

		gstrTCID = "66027";
		gstrTO = "Verify that the number status type of a resource can be updated from the following screens:"+
			"1. View Screen"+
			"2. Resource Detail Screen"+
			"3. Map Screen"+
			"4. Event Detail Screen";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();
		Event_data objEvent_data = new Event_data();
		Roles_data objRolesData = new Roles_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap = new Map(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strRoleValue[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

       objNavigationToSubmenus.navigateToRoles();
		
		objRoles.deleteDefaultRoleIfExist();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(objStatusTypes_data.strNumberStatusType, objStatusTypes_data.strNSTStatusTypeName, 
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.createResourceWithAddress(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName, objResource_data.strStreetAddress, objResource_data.strCity, objResource_data.strState, objResource_data.strCounty, objResource_data.strZipcode);


		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				objStatusTypes_data.strNSTStatusTypeName);
		/*objViewsList.clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc);
		objViewsList.selectViewType(objView_data.strResource);
		objViewsList.selectStatusType(objStatusTypes_data.strNSTStatusTypeName)
				.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();*/

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);

		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption()
				.selectSetupResourceOption()
				.selectEditResourcesOnlyOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectMaintainEventsOption()
				.selectViewcustomViewOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();
		objEventSetUp
		.clickOncreateEventTemplate()
		.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(
				objEventSetUp_data.strTemplateDefinition)
		.selectResourceType(strResourceTypeValue[0])
		.selectStatusType(strStatusTypeValues[0])
		.clickSaveButton()
		.deselectSelectAllEmailOption()
		.deselectSelectAllPagerOption()
		.deselectSelectAllWebOption()
		.verEveTemplateListScreenIsDisplayed();
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue[0])
		.clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName);
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objEvent_data.strEventName);
		System.out.println(objView_data.strViewName);
		
		objStatusTypeList1.navigateToStatusTypeList();
		
		objStatusTypeList1.clickCreateNewStatusTypeButton();
		objStatusTypeList1.selectStatusType(objStatusTypes_data.strMultiStatusType);
		objStatusTypeList1.clickNextButton();
		objStatusTypeList1.verifyCreateMultiStatusTypePage();
		objStatusTypeList1.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName);
		objStatusTypeList1.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList1.selectRoleUnderRolesWithViewRight(strRoleValue[0]);
		objStatusTypeList1.selectRoleUnderRolesWithUpdateRight(strRoleValue[0]);
		objStatusTypeList1.clickOnSaveButton();
		
		objStatusTypeList1.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);
		

		strStatusesValues[0] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
	
		
		objStatusTypeList1.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);
		

		strStatusesValues[0] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		
		objStatusTypeList1.clickOnReturnToStatusTypeList();
		
		objStatusTypeList1.verifyTypeColumnForST(objStatusTypes_data.strMultiStatusType, objStatusTypes_data.strMSTStatusTypeName);
		
		strStatusTypeValues1[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		
		objResource1.navigateToResourceListPage();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource1.selectStatusType(strStatusTypeValues1);
		objResource1.clickOnSaveButton();
		
		objResource1.verResourceInList(objResource_data.strResourceName);
		
		objNavigationToSubmenus1.navigateToViews();
		
		objViewsList1.clickOnEditLinkOfView(objView_data.strViewName)
					 .clickOnResourcesTab()
					 .selectResource(objResource_data.strResourceName)
					 .clickNextButton()
					 .selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
					 .clickOnSaveOfCreateNewView();
//		objViewsList1.selectResourceType(strResourceTypeValue[0]);
//		objViewsList1.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
//					.clickOnSaveOfCreateNewView();

		objViewsList1.verViewInList(objView_data.strViewName);
	
		objViewsList1.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection().clickOnSaveButton();
		
		objStatusTypeList1.navigateToStatusTypeListNew();
		
		objStatusTypeList1.clickOnEditOfStatusType(objStatusTypes_data.strMSTStatusTypeName);
		objStatusTypeList1.selectSectionName(objView_data.strSectionName);
		objStatusTypeList1.clickOnSaveButton();
		
		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0], objStatusTypes_data.strMSTStatusTypeName);
		
		objViewsList1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
		
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0], strStatusTypeValues1[0]);
		
//		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues1[0], strStatusesValues[0]);

		objUpdateStatus1.clickOnSaveButton();
		
		objViewsList1.verifyUpdatedValueAndComments(objStatusTypes_data.strMSTStatusTypeName, objView_data.strValueForUpdate, "");
	
		
		objNavigationToSubmenus1.navigateToMap();
		
		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName);
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		
		
		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues1[0], strStatusesValues[1])
				.clickOnSaveButton();

		
		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName);
		
		String strStatusType[] = {objStatusTypes_data.strMSTStatusTypeName};
		
		objMap.verStatusTypesInPopupWindow(strStatusType);
		
		objMap.verUpdateValuesInPopupWindow(objStatusTypes_data.strStatusNameInMulti1);

		
		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate);
		
		objEventSetUp1.selectStatusType(strStatusTypeValues1[0]);
		objEventSetUp1.clickSaveButton();
			
		objEventManagement1.clickOnEditLink(objEvent_data.strEventName);
		
		objEventManagement1.verifyResourceInSelectResourcePage(strResourceValue);
		objEventManagement1.selectStatusType(strStatusTypeValues1[0]);
		
		objEventManagement1.clickOnSaveButton();
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
				objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strNSTStatusTypeName);
		
		objEventStatus1.verStatusTypes(
				objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strMSTStatusTypeName);
		
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues1[0]);
		
		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues1[0], strStatusesValues[0])
		.clickOnSaveButton();
		
		objCustomUnderView1
			.clickOnAddMoreResources()
			.enterResNameInWhatField(objResource_data.strResourceName)
			.clickOnSearch()
			.selectResource(strResourceValue)
			.clickOnAddToCustomView()
			.clickOnOptions()
			.selectStatusTypes(strStatusTypeValues1)
			.clickOnSave();
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues1[1]);
		
		objCustomUnderView1.clickOnCustomeViewMap();
		
		objCustomUnderView1.verCustomViewMapScreenIsDisplayed();
		
		objCustomUnderView1.selectResourceName(objResource_data.strResourceName);
		
		objViewsList1.clickOnSaveButton();
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName)
		.verUpdateStatusInPopupWindow()
		.clickUpdateStatusInPopupWindow();

		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues1[0], strStatusesValues[1])
				.clickOnSaveButton();

		objCustomUnderView1.verCustomViewMapScreenIsDisplayed();
		
		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName);
	
		objMap.verStatusTypesInPopupWindow(strStatusType);
		
		objMap.verUpdateValuesInPopupWindow(objStatusTypes_data.strStatusNameInMulti1);
		
		objLogin1.clickLogOut();
			
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that the number status type of a resource can be updated from the following screens:
					1. View Screen
					2. Resource Detail Screen
					3. Map Screen
					4. Event Detail Screen 
	'Precondition:
	'Date	 	 : 19-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Create status type ST without selecting any roles (view/update), add ST to resource RS at resource level and verify that ST is NOT displayed for non system admin user on following screens:"+
			"a. Region view screen"+
			"b. Map (in the status type dropdown and in resource pop up window)"+
			"c. View Resource Detail"+
			"d. Custom view"+
			"e. Event details"+
			"f. Mobile view"+
			"g. Edit My Status Change Preferences")
	
	public void testHappyDay99605() throws Exception {

		gstrTCID = "99605";
		gstrTO = "Create status type ST without selecting any roles (view/update), add ST to resource RS at resource level and verify that ST is NOT displayed for non system admin user on following screens:"+
				"a. Region view screen"+
				"b. Map (in the status type dropdown and in resource pop up window)"+
				"c. View Resource Detail"+
				"d. Custom view"+
				"e. Event details"+
				"f. Mobile view"+
				"g. Edit My Status Change Preferences";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();
		Event_data objEvent_data = new Event_data();
		Roles_data objRolesData = new Roles_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap = new Map(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strRoleValue[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
objNavigationToSubmenus.navigateToRoles();
		
		objRoles.deleteDefaultRoleIfExist();
		

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(objStatusTypes_data.strNumberStatusType, objStatusTypes_data.strNSTStatusTypeName, 
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.createResourceWithAddress(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName, objResource_data.strStreetAddress, objResource_data.strCity, objResource_data.strState, objResource_data.strCounty, objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName);
		/*objViewsList.clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc);
		objViewsList.selectViewType(objView_data.strResource);
		objViewsList.selectStatusType(objStatusTypes_data.strNSTStatusTypeName)
				.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();*/

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);


		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption()
				.selectSetupResourceOption()
				.selectEditResourcesOnlyOption()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption()
				.selectEditStatusChangeNotPrefernceOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();
		objEventSetUp
		.clickOncreateEventTemplate()
		.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(
				objEventSetUp_data.strTemplateDefinition)
		.selectResourceType(strResourceTypeValue[0])
		.selectStatusType(strStatusTypeValues[0])
		.clickSaveButton()
		.deselectSelectAllEmailOption()
		.deselectSelectAllPagerOption()
		.deselectSelectAllWebOption()
		.verEveTemplateListScreenIsDisplayed();
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue[0])
		.clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName);
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objEvent_data.strEventName);
		System.out.println(objView_data.strViewName);
		
		objStatusTypeList1.navigateToStatusTypeList();
		
		objStatusTypeList1.clickCreateNewStatusTypeButton();
		objStatusTypeList1.selectStatusType(objStatusTypes_data.strMultiStatusType);
		objStatusTypeList1.clickNextButton();
		objStatusTypeList1.verifyCreateMultiStatusTypePage();
		objStatusTypeList1.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName);
		objStatusTypeList1.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList1.deSelectRoleUnderRolesWithUpdateRight();
		objStatusTypeList1.deSelectRoleUnderRolesWithViewRight();
		objStatusTypeList1.clickOnSaveButton();
		
		objStatusTypeList1.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);
		

		strStatusesValues[0] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
	
		
		objStatusTypeList1.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);
		

		strStatusesValues[0] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		
		objStatusTypeList1.clickOnReturnToStatusTypeList();
		
		objStatusTypeList1.verifyTypeColumnForST(objStatusTypes_data.strMultiStatusType, objStatusTypes_data.strMSTStatusTypeName);
		
		strStatusTypeValues1[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		
		objResource1.navigateToResourceListPage();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource1.selectStatusType(strStatusTypeValues1);
		objResource1.clickOnSaveButton();
		
		objResource1.verResourceInList(objResource_data.strResourceName);
		
		objNavigationToSubmenus1.navigateToViews();
		
		objViewsList1.clickOnEditLinkOfView(objView_data.strViewName)
					 .clickOnSTTab()
					 .selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
					 .clickOnSaveOfCreateNewView();
//		objViewsList1.selectResourceType(strResourceTypeValue[0]);
//		objViewsList1.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
//					.clickOnSaveOfCreateNewView();

		objViewsList1.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection().clickOnSaveButton();
		
		objStatusTypeList1.navigateToStatusTypeListNew();
		
		objStatusTypeList1.clickOnEditOfStatusType(objStatusTypes_data.strMSTStatusTypeName);
		objStatusTypeList1.selectSectionName(objView_data.strSectionName);
		objStatusTypeList1.clickOnSaveButton();
		
		
		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.verifyStatusTypeNameIsNotInView( objStatusTypes_data.strMSTStatusTypeName);
		
		objViewsList1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
		
		objViewsList1.verifyStatusTypeIsNotUnderSectionsInResourceDetailPage(objStatusTypes_data.strMSTStatusTypeName, objView_data.strSectionName);
		
		objNavigationToSubmenus1.navigateToMap();
		
		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName);
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName);
		
		objMap.verStatusTypesNotInPopupWindow(strStatusTypeValues1);
		
		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate);
		
		objEventSetUp1.selectStatusType(strStatusTypeValues1[0]);
		objEventSetUp1.clickSaveButton();
		
		objEventManagement1.navigateToEventManagement();
		
		objEventManagement1.clickOnEditLink(objEvent_data.strEventName);
		
		objEventManagement1.verifyResourceInSelectResourcePage(strResourceValue);
		objEventManagement1.selectStatusType(strStatusTypeValues1[0]);
		
		objEventManagement1.clickOnSaveButton();
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
				objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		objEventStatus1.verStatusTypeNotPresent(
				objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strMSTStatusTypeName);
		
		objNavigationToSubmenus1.navigateStatusChangeInPreferences();
		
		objStatusChangePreference1
		.verMyStatusChangePreferncePgeDisplayed()
		.clickOnAdd()
		.enterResNameInWhatField(objResource_data.strResourceName)
		.clickOnSearch()
		.selectResource(strResourceValue[0])
		.clickOnNotifications()

		.verStatusTypesNotDisplayed(
				objStatusTypes_data.strMSTStatusTypeName);
		
		objLogin1.clickLogOut();
			
		gstrResult = "PASS";
	}	
	
	
	/*************************************************************************************
	'Description : Create a status type ST selecting a role R1 under ‘Roles with view rights’ and ‘Roles with update 
					rights’ sections, associate ST with resource RS at the resource type level and verify that the user with role R1 
					and ‘Update Status’ right on resource RS receive expired status notification for resource RS when the status of ST expires. 
	'Precondition:
	'Date	 	 : 23-Jul-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Create a status type ST selecting a role R1 under ‘Roles with view rights’ and "
			+ "‘Roles with update rights’ sections, associate ST with resource RS at the resource type level "
			+ "and verify that the user with role R1 and ‘Update Status’ right on resource RS receive expired status "
			+ "notification for resource RS when the status of ST expires. ")
	public void testHappyDay44200() throws Exception {

		gstrTCID = "44200";
		gstrTO = "Create a status type ST selecting a role R1 under ‘Roles with view rights’ and "
				+ "‘Roles with update rights’ sections, associate ST with resource RS at the resource type level "
				+ "and verify that the user with role R1 and ‘Update Status’ right on resource RS receive expired status "
				+ "notification for resource RS when the status of ST expires. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
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
		Map objMap1 = new Map(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[4];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
objNavigationToSubmenus.navigateToRoles();
		
		objRoles.deleteDefaultRoleIfExist();
		

		StatusTypeList_page.navigateToStatusTypeList();

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		StatusTypeList_page.createNewStatusWithExpirationTime(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusExpirationTime);

		strStatusesValues[0] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		StatusTypeList_page.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
			      objStatusTypes_data.strStatusColor)
			      .verCreatedStatusInStatusListForMulti(
			          objStatusTypes_data.strStatusNameInMulti1)
			       .clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		StatusTypeList_page
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName1)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription);

		String strApplicationTime = objEventManagement.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strTimeInMin = objDts.addTimetoExisting(strTime[2], 10, "HH:mm");
		String strTime1[] = strTimeInMin.split(":");
		
		String strCurrentDate = objDts.getCurrentDate("MM/dd/yyyy");
		String strExpTime = strCurrentDate + " " + strTimeInMin;
		System.out.println(strTimeInMin);

		StatusTypeList_page.selectShiftTime(strTime1[0], strTime1[1])
				.clickOnSaveButton();

		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[2] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[3] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		StatusTypeList_page.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page
				.navigateToResourceListPage()
				.createResourceWithAddress(objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName,
						objResource_data.strStreetAddress,
						objResource_data.strCity, objResource_data.strState,
						objResource_data.strCounty, objResource_data.strZipcode);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);
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
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnsystemNotifyPreferences();
		
		System.out.println(objUserdata.strNewUserName);

		objSystemNotifications_page.selectAndSaveExpiredStatusNotification();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[2]).clickOnSaveButton();

		String strApplicationTime1 = objEventManagement1.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime1 = strApplicationTime1 + " " + strCurrentYear;

		strApplicationTime1 = objDts.converDateFormat(strApplicationTime1,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime1 = objDts.addTimetoExisting(strApplicationTime1, 5,
				"MM/dd/yyyy HH:mm");

		System.out.println(strApplicationTime1);
		
		objLogin1.clickLogOut();

		// wait until expiration time
		TimeUnit.MINUTES.sleep(6);
		TimeUnit.SECONDS.sleep(30);

		String strSubject = "Expired Status Notification: "
				+ objResource_data.strResourceName;

		String strSubject1 = "Expired Status: "
				+ objResource_data.strResourceAbbrivation;

		String strMsgBody1 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime1);
		
		String strMsgBody2 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime1);
		
		String strMsgBody3 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName, strExpTime);
		
		String strMsgBody4 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName, strExpTime);

		String strMsgBody5 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime1);
		
		String strMsgBody6 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName, strExpTime);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
		boolean blnMsg4 = false;

		for (int intCount = 0; intCount < 4; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}
			
			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}
			
			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}
			
			if (blnMsg4 == false) {
				blnMsg4 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody4);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2 && blnMsg3 && blnMsg4);

		blnMsg1 = false;
		blnMsg2 = false;
		
		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject1);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody5);
			}
			
			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody6);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Create a status type ST selecting a role R1 under ‘Roles with view rights’ section, 
					associate ST with resource RS at the resource type level and verify that the user with role R1 and ‘Update Status’ 
					right on resource RS receives expired status notification for resource RS when the status of ST expires
	'Precondition:
	'Date	 	 : 23-Jul-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Create a status type ST selecting a role R1 under ‘Roles with view rights’ section, "
			+ "associate ST with resource RS at the resource type level and verify that the user with role R1 and "
			+ "‘Update Status’ right on resource RS receives expired status notification for resource RS when the status of ST expires")
	public void testHappyDay44217() throws Exception {

		gstrTCID = "44217";
		gstrTO = "Create a status type ST selecting a role R1 under ‘Roles with view rights’ section, "
				+ "associate ST with resource RS at the resource type level and verify that the user with role R1 and "
				+ "‘Update Status’ right on resource RS receives expired status notification for resource RS when the status of ST expires";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Roles_data objRolesData = new Roles_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		SystemNotifications objSystemNotifications_page = new SystemNotifications(
				this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[4];
		String strRoleValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
       objNavigationToSubmenus.navigateToRoles();
		
		objRoles.deleteDefaultRoleIfExist();
		
		StatusTypeList_page.navigateToStatusTypeList();

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		StatusTypeList_page.createNewStatusWithExpirationTime(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusExpirationTime);

		strStatusesValues[0] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		StatusTypeList_page.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
			      						objStatusTypes_data.strStatusColor)
			      		   .verCreatedStatusInStatusListForMulti(
			      				   	objStatusTypes_data.strStatusNameInMulti1)
			      		   .clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		StatusTypeList_page
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName1)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription);

		String strApplicationTime = objEventManagement.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strTimeInMin = objDts.addTimetoExisting(strTime[2], 10, "HH:mm");
		String strTime1[] = strTimeInMin.split(":");
		
		String strCurrentDate = objDts.getCurrentDate("MM/dd/yyyy");
		String strExpTime = strCurrentDate + " " + strTimeInMin;
		System.out.println(strTimeInMin);

		StatusTypeList_page.selectShiftTime(strTime1[0], strTime1[1])
				.clickOnSaveButton();

		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[2] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[3] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		StatusTypeList_page.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page
				.navigateToResourceListPage()
				.createResourceWithAddress(objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName,
						objResource_data.strStreetAddress,
						objResource_data.strCity, objResource_data.strState,
						objResource_data.strCounty, objResource_data.strZipcode);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);
		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayUpdatesec()
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues);
		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.deSelectAllCheckboxInRolesMayUpdatesec()
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues);
		objRoles.clickOnSaveBtn();

		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);
		System.out.println(objRolesData.strRoleName1);

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
				.selectRoleCheckBox(strRoleValue[0])
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnsystemNotifyPreferences();
		
		System.out.println(objUserdata.strNewUserName);

		objSystemNotifications_page.selectAndSaveExpiredStatusNotification();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectRoleCheckBox(strRoleValue[1])
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();
          System.out.println(objUserdata.strNewUserName1);
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[2]).clickOnSaveButton();

		String strApplicationTime1 = objEventManagement1.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime1 = strApplicationTime1 + " " + strCurrentYear;

		strApplicationTime1 = objDts.converDateFormat(strApplicationTime1,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime1 = objDts.addTimetoExisting(strApplicationTime1, 5,
				"MM/dd/yyyy HH:mm");

		System.out.println(strApplicationTime1);

		objLogin1.clickLogOut();

		// wait until expiration time
		TimeUnit.MINUTES.sleep(6);
		TimeUnit.SECONDS.sleep(30);

		String strSubject = "Expired Status Notification: "
				+ objResource_data.strResourceName;

		String strSubject1 = "Expired Status: "
				+ objResource_data.strResourceAbbrivation;

		String strMsgBody1 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime1);
		
		String strMsgBody2 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime1);
		
		String strMsgBody3 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName, strExpTime);
		
		String strMsgBody4 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName, strExpTime);

		String strMsgBody5 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime1);
		
		String strMsgBody6 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName, strExpTime);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
		boolean blnMsg4 = false;

		for (int intCount = 0; intCount < 4; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}
			
			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}
			
			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody3);
			}
			
			if (blnMsg4 == false) {
				blnMsg4 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody4);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2 && blnMsg3 && blnMsg4);

		blnMsg1 = false;
		blnMsg2 = false;
		
		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject1);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody5);
			}
			
			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody6);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Create status type ST selecting a role R1 under ‘Roles with view rights’ section, associate ST with resource RS at resource TYPE level and verify that a user with role R1 and ‘Update Status’ right on RS CAN only view ST but CANNOT update the status of ST from following screens:
						a. Region view
						b. Map screen (from resource pop up window)
						c. Custom view
						d. View Resource Detail
						e. Event detail 
	'Precondition:
	'Date	 	 : 24-Jul-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Create status type ST selecting a role R1 under ‘Roles with view rights’ section, associate ST with resource RS at resource TYPE level and verify that a user with role R1 and ‘Update Status’ right on RS CAN only view ST but CANNOT update the status of ST from following screens:"
			+ "a. Region view"
			+ "b. Map screen (from resource pop up window)"
			+ "c. Custom view" + "d. View Resource Detail" + "e. Event detail ")
	public void testHappyDay100650() throws Exception {

		gstrTCID = "100650";
		gstrTO = "Create status type ST selecting a role R1 under ‘Roles with view rights’ section, associate ST with resource RS at resource TYPE level and verify that a user with role R1 and ‘Update Status’ right on RS CAN only view ST but CANNOT update the status of ST from following screens:"
				+ "a. Region view"
				+ "b. Map screen (from resource pop up window)"
				+ "c. Custom view"
				+ "d. View Resource Detail"
				+ "e. Event detail ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		EventManagement objEventManagementPage1 = new EventManagement(
				this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.deleteDefaultRoleIfExist();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

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

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayUpdatesec()
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues);
		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

		String[] strAllStatausTypes = { objStatusTypes_data.strNSTStatusTypeName };
		System.out.println(objStatusTypes_data.strNSTStatusTypeName);

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

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strAllStatausTypes);
		System.out.println(objView_data.strViewName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objStatusTypeList1.navigateToStatusTypeList();

		objStatusTypeList1
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectSectionName(objView_data.strSectionName)
				.deSelectRoleUnderRolesWithUpdateRight()
				.deSelectRoleUnderRolesWithViewRight()
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.clickOnSaveButton();

		objStatusTypeList1.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList1.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
					objStatusTypes_data.strStatusColor)
	   .verCreatedStatusInStatusListForMulti(
			   	objStatusTypes_data.strStatusNameInMulti1)
	   .clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType1
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.clickStatusType(strStatusTypeValues1).clickOnSaveButton();

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickOnEditLinkOfView(objView_data.strViewName)
				.clickOnSTTab()
				.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
				.clickOnSaveOfCreateNewView();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1
				.verStatusTypeCannotUpdate(strResourceTypeValue[0],
						objStatusTypes_data.strMSTStatusTypeName,
						strResourceValue[0], strStatusTypeValues1[0])
				.clickOnUpdateStatus(objResource_data.strResourceName)
				.verUnauthorizedErrorMsg();

		objNavigationToSubmenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strResourceName)
				.verSTCannotUpdateInResDetailPage(
						objStatusTypes_data.strMSTStatusTypeName,
						strResourceValue[0], strStatusTypeValues1[0]);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objViewsList1.verUnauthorizedErrorMsg();

		objNavigationToSubmenus1.navigateToCustomizedViewInPrefrences();

		objCustomUnderView1.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues1).clickOnSave();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName)
				.verUnauthorizedErrorMsg();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.verStatuaTypesCannotUpdate(
				objResource_data.strResourceName,
				objStatusTypes_data.strMSTStatusTypeName);

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objViewsList1.verUnauthorizedErrorMsg();

		objEventSetUp1.navigateToEventSetUp();
		
		
		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
				.selectStatusType(strStatusTypeValues1[0]).clickSaveButton();

		objEventManagementPage1
				.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventDetails(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton();

		Thread.sleep(3000);
		
		objEventManagementPage1
		.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verStatusTypes(
				objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strMSTStatusTypeName)
				.clickOnUpdateStatusKey(objResource_data.strResourceName);

		objViewsList1.verUnauthorizedErrorMsg()
		.clickOnReturnToView();

		objViewsList1.verStatusTypeCannotUpdate(strResourceTypeValue[0],
				objStatusTypes_data.strMSTStatusTypeName, strResourceValue[0],
				strStatusTypeValues1[0]);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Create status type ST selecting a role R1 under ‘Roles with view rights’ section, add ST to resource RS at the resource level and verify that the user with role R1 and ‘Update Status’ right on resource RS CAN only view ST but CANNOT update the status of ST from following screens:
						a. Region view
						b. Map screen (from resource pop up window)
						c. Custom view
						d. View Resource Detail
						e. Event detail 
	'Precondition:
	'Date	 	 : 27-Jul-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Create status type ST selecting a role R1 under ‘Roles with view rights’ section, add ST to resource RS at the resource level and verify that the user with role R1 and ‘Update Status’ right on resource RS CAN only view ST but CANNOT update the status of ST from following screens:"
			+ "a. Region view"
			+ "b. Map screen (from resource pop up window)"
			+ "c. Custom view" + "d. View Resource Detail" + "e. Event detail ")
	public void testHappyDay100652() throws Exception {

		gstrTCID = "100652";
		gstrTO = "Create status type ST selecting a role R1 under ‘Roles with view rights’ section, add ST to resource RS at the resource level and verify that the user with role R1 and ‘Update Status’ right on resource RS CAN only view ST but CANNOT update the status of ST from following screens:"
				+ "a. Region view"
				+ "b. Map screen (from resource pop up window)"
				+ "c. Custom view"
				+ "d. View Resource Detail"
				+ "e. Event detail ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventManagement objEventManagementPage1 = new EventManagement(
				this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusTypeValues2[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
       objNavigationToSubmenus.navigateToRoles();
		
		objRoles.deleteDefaultRoleIfExist();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(objResourceType_data.strResourceTypeName, strStatusTypeValues2);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

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

		objResource
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName)
				.selectStatusType(strStatusTypeValues).clickOnSaveButton();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayUpdatesec()
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues);
		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

		String[] strAllStatausTypes = { objStatusTypes_data.strNSTStatusTypeName };
		System.out.println(objStatusTypes_data.strNSTStatusTypeName);

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
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName);

		System.out.println(objView_data.strViewName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objStatusTypeList1.navigateToStatusTypeList();

		objStatusTypeList1
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectSectionName(objView_data.strSectionName)
				.deSelectRoleUnderRolesWithUpdateRight()
				.deSelectRoleUnderRolesWithViewRight()
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.clickOnSaveButton();

		objStatusTypeList1.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList1.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
										objStatusTypes_data.strStatusColor)
						   .verCreatedStatusInStatusListForMulti(
								   	objStatusTypes_data.strStatusNameInMulti1)
						   .clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName)
				.selectStatusType(strStatusTypeValues1).clickOnSaveButton();

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickOnEditLinkOfView(objView_data.strViewName)
				.clickOnSTTab()
				.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
				.clickOnSaveOfCreateNewView();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1
				.verStatusTypeCannotUpdate(strResourceTypeValue[0],
						objStatusTypes_data.strMSTStatusTypeName,
						strResourceValue[0], strStatusTypeValues1[0])
				.clickOnUpdateStatus(objResource_data.strResourceName)
				.verUnauthorizedErrorMsg();
		
		objNavigationToSubmenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strResourceName)
				.verSTCannotUpdateInResDetailPage(
						objStatusTypes_data.strMSTStatusTypeName,
						strResourceValue[0], strStatusTypeValues1[0]);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objViewsList1.verUnauthorizedErrorMsg();

		objNavigationToSubmenus1.navigateToCustomizedViewInPrefrences();

		objCustomUnderView1.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues1).clickOnSave();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName)
				.verUnauthorizedErrorMsg();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.verStatuaTypesCannotUpdate(
				objResource_data.strResourceName,
				objStatusTypes_data.strMSTStatusTypeName);

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objViewsList1.verUnauthorizedErrorMsg();

		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
				.selectStatusType(strStatusTypeValues1[0]).clickSaveButton();

		objEventManagementPage1
				.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventDetails(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton();

		Thread.sleep(3000);
		
		objEventManagementPage1
		.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verStatusTypes(
				objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strMSTStatusTypeName)
				.clickOnUpdateStatusKey(objResource_data.strResourceName);

		objViewsList1.verUnauthorizedErrorMsg()
		.clickOnReturnToView();

		objViewsList1.verStatusTypeCannotUpdate(strResourceTypeValue[0],
				objStatusTypes_data.strMSTStatusTypeName, strResourceValue[0],
				strStatusTypeValues1[0]);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/****************************************************************************************************************
	'Description : Create a status type ST selecting a role R1 under ‘Roles with view rights’ and ‘Roles with update
	 				rights’ sections, associate ST with resource RS at the resource level and verify that the user 
	 				with role R1 and ‘Update Status’ right on resource RS receive expired status notification for 
	 				resource RS when the status of ST expires.
	'Precondition:
	'Date	 	 : 24-Jul-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Create a status type ST selecting a role R1 under ‘Roles with view rights’ and ‘Roles with"
			+ " update rights’ sections, associate ST with resource RS at the resource level and verify that the "
			+ "user with role R1 and ‘Update Status’ right on resource RS receive expired status notification for"
			+ " resource RS when the status of ST expires.")
	public void testHappyDay44275() throws Exception {

		gstrTCID = "44275";
		gstrTO = "Create a status type ST selecting a role R1 under ‘Roles with view rights’ and ‘Roles with update"
				+ " rights’ sections, associate ST with resource RS at the resource level and verify that the user "
				+ "with role R1 and ‘Update Status’ right on resource RS receive expired status notification for "
				+ "resource RS when the status of ST expires.";
		
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Roles_data objRolesData = new Roles_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		SystemNotifications objSystemNotifications_page = new SystemNotifications(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		Map objMap1 = new lib.page.Map(this.driver1);

		String strRoleValue[] = new String[1];
		String strStatusesValue[] = new String[3];
		String[] strMultiStatusTypes = new String[2];
		String[] strResourceTypeValue = new String[1];
		String[] strResourceValue = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		System.out.println(objRolesData.strRoleName);
		System.out.println("M1" + objStatusTypes_data.strMSTStatusTypeName);
		System.out.println("s1" + objStatusTypes_data.strStatusNameInMulti);
		System.out.println("s2" + objStatusTypes_data.strStatusNameInMulti1);
		System.out.println("M2" + objStatusTypes_data.strMSTStatusTypeName1);
		System.out.println("s3" + objStatusTypes_data.strStatusNameInMulti2);
		System.out.println("RT:" + objResourceType_data.strResourceTypeName);
		System.out.println(objUserdata.strNewUserName);
		
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
	
		objRoles.deleteDefaultRoleIfExist();
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();
		
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectRoleUnderRolesWithUpdateRight(strRoleValue[0])
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.clickOnSaveButton()
				.createMultiStatusTypesWithExpirationTime(objStatusTypes_data.strStatusNameInMulti,
								objStatusTypes_data.strStatusExpirationTime);
		
		strStatusesValue[0] = objStatusTypeList
				.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createMultiStatusTypesWithExpirationTime(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusExpirationTime);
		
		strStatusesValue[1] = objStatusTypeList
				.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strMultiStatusTypes[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();
		
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName1)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription);
		
		String strApplicationTime = objEventManagement.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strTimeInMin = objDts.addTimetoExisting(strTime[2], 5, "HH:mm");
		String strTime1[] = strTimeInMin.split(":");
		
		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");
		
		System.out.println(strTimeInMin);

		objStatusTypeList
				.selectShiftTime(strTime1[0], strTime1[1])
				.selectRoleUnderRolesWithUpdateRight(strRoleValue[0])
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.clickOnSaveButton()
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor);
		
		strStatusesValue[2] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strMultiStatusTypes[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		String[] strStatusTypeNames = {
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName1 };

		objNavigationToSubmenus.navigateToResourceTypesInSetup();
		
		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strMultiStatusTypes);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objResource
				.navigateToResourceListPage()
				.createResourceWithAddress(objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName,
						objResource_data.strStreetAddress,
						objResource_data.strCity, objResource_data.strState,
						objResource_data.strCounty, objResource_data.strZipcode);

		System.out.println("RS:" + objResource_data.strResourceName);

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
						"",
						objUserdata.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue[0])
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnsystemNotifyPreferences();

		objSystemNotifications_page.selectAndSaveExpiredStatusNotification();

		objLogin.clickLogOut();
		
		System.out.println("-----Precondition over-----");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames)
				.clickUpdateStatusInPopupWindow();
		
		objUpdateStatus1.clickOnSelectAll()
						.selectMSTUpdateValue(strMultiStatusTypes[0], strStatusesValue[0])
						.selectMSTUpdateValue(strMultiStatusTypes[1], strStatusesValue[2])
						.clickOnSaveButton();
		
		// wait until expiration time
		TimeUnit.MINUTES.sleep(6);
		
		objLogin1.clickLogOut();

		String strSubject = "Expired Status Notification: "
				+ objResource_data.strResourceName;
		
		String strSubject1 = "Expired Status: "+objResource_data.strResourceAbbrivation;
		
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

		for (int intCount = 0; intCount < 1; intCount++) {

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

	/****************************************************************************************************************
	'Description : Create a status type ST selecting a role R1 under ‘Roles with view rights’ and ‘Roles with 
					update rights’ sections, associate ST with resource RS at the resource level and verify that 
					the user with role R1 and ‘Run Report’ right on resource RS DOES NOT receive expired status 
					notification for resource RS when the status of ST expires.
	'Precondition:
	'Date	 	 : 24-Jul-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Create a status type ST selecting a role R1 under ‘Roles with view rights’ and ‘Roles "
			+ "with update rights’ sections, associate ST with resource RS at the resource level and verify that "
			+ "the user with role R1 and ‘Run Report’ right on resource RS DOES NOT receive expired status "
			+ "notification for resource RS when the status of ST expires.")
	public void testHappyDay44610() throws Exception {

		gstrTCID = "44610";
		gstrTO = "Create a status type ST selecting a role R1 under ‘Roles with view rights’ and ‘Roles with "
				+ "update rights’ sections, associate ST with resource RS at the resource level and verify that "
				+ "the user with role R1 and ‘Run Report’ right on resource RS DOES NOT receive expired status "
				+ "notification for resource RS when the status of ST expires.";
		
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Roles_data objRolesData = new Roles_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		SystemNotifications objSystemNotifications_page = new SystemNotifications(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		Map objMap1 = new lib.page.Map(this.driver1);

		String strRoleValue[] = new String[1];
		String strStatusesValue[] = new String[3];
		String[] strMultiStatusTypes = new String[2];
		String[] strResourceTypeValue = new String[1];
		String[] strResourceValue = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		System.out.println(objRolesData.strRoleName);
		System.out.println("M1" + objStatusTypes_data.strMSTStatusTypeName);
		System.out.println("s1" + objStatusTypes_data.strStatusNameInMulti);
		System.out.println("s2:" + objStatusTypes_data.strStatusNameInMulti1);
		System.out.println("M2" + objStatusTypes_data.strMSTStatusTypeName1);
		System.out.println("s3" + objStatusTypes_data.strStatusNameInMulti2);
		System.out.println("RT:" + objResourceType_data.strResourceTypeName);
		System.out.println(objUserdata.strNewUserName);
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
      objNavigationToSubmenus.navigateToRoles();
		
		objRoles.deleteDefaultRoleIfExist();
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();
		
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectRoleUnderRolesWithUpdateRight(strRoleValue[0])
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.clickOnSaveButton()
				.createMultiStatusTypesWithExpirationTime(objStatusTypes_data.strStatusNameInMulti,
								objStatusTypes_data.strStatusExpirationTime);
		
		strStatusesValue[0] = objStatusTypeList
				.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createMultiStatusTypesWithExpirationTime(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusExpirationTime);
		
		strStatusesValue[1] = objStatusTypeList
				.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strMultiStatusTypes[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();
		
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName1)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription);
		
		String strApplicationTime = objEventManagement.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strTimeInMin = objDts.addTimetoExisting(strTime[2], 5, "HH:mm");
		String strTime1[] = strTimeInMin.split(":");
		
		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");
		
		System.out.println(strTimeInMin);

		objStatusTypeList
				.selectShiftTime(strTime1[0], strTime1[1])
				.selectRoleUnderRolesWithUpdateRight(strRoleValue[0])
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.clickOnSaveButton()
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor);
		
		strStatusesValue[2] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strMultiStatusTypes[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		String[] strStatusTypeNames = {
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName1 };

		objNavigationToSubmenus.navigateToResourceTypesInSetup();
		
		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strMultiStatusTypes);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objResource
				.navigateToResourceListPage()
				.createResourceWithAddress(objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName,
						objResource_data.strStreetAddress,
						objResource_data.strCity, objResource_data.strState,
						objResource_data.strCounty, objResource_data.strZipcode);

		System.out.println("RS:" + objResource_data.strResourceName);

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
						"",
						objUserdata.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue[0])
				.selectRunReportRight(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnsystemNotifyPreferences();

		objSystemNotifications_page.selectAndSaveExpiredStatusNotification();

		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectRoleCheckBox(strRoleValue[0])
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.clickSaveButton();

		objLogin.clickLogOut();
		
		System.out.println("-----Precondition over-----");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames)
				.clickUpdateStatusInPopupWindow();
		
		objUpdateStatus1.clickOnSelectAll()
						.selectMSTUpdateValue(strMultiStatusTypes[0], strStatusesValue[0])
						.selectMSTUpdateValue(strMultiStatusTypes[1], strStatusesValue[2])
						.clickOnSaveButton();
		
		// wait until expiration time
		System.out.println("wait for 6 mins");TimeUnit.MINUTES.sleep(6);System.out.println("wait for 6 mins over");
		
		objLogin1.clickLogOut();
		
		String strSubject = "Expired Status Notification: "
				+ objResource_data.strResourceName;
		
		String strSubject1 = "Expired Status: "+objResource_data.strResourceAbbrivation;
		
		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
		
		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		
		for (int intCount = 0; intCount < 2; intCount++) {
		
			objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubject);
			blnMsg1 = true;
			assertTrue(blnMsg1);
			blnMsg1 = false;
		}
		
		for (int intCount = 0; intCount < 2; intCount++) {
		
			objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubject1);
			blnMsg2 = true;
			assertTrue(blnMsg2);
			blnMsg2 = false;
		}
		
		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description :  Create a status type ST selecting a role R1 under ‘Roles with view rights’, add ST to resource RS at the resource level and verify that user with role R1 & with 'View Resource' right on RS CAN view ST on following screens:

				a. Region view screen
				b. Map (in the status type dropdown and in resource pop up window)
				c. View Resource Detail
				d. Custom view
				e. Event details
				f. Mobile view
				g. Edit My Status Change Preferences
	'Precondition:
	'Date	 	 : 19-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " Create a status type ST selecting a role R1 under ‘Roles with view rights’, add ST to resource RS at the resource level and verify that user with role R1 & with 'View Resource' right on RS CAN view ST on following screens:"+

				"a. Region view screen"+
				"b. Map (in the status type dropdown and in resource pop up window)"+
				"c. View Resource Detail"+
				"d. Custom view"+
				"e. Event details"+
				"f. Mobile view"+
				"g. Edit My Status Change Preferences")
	
	public void testHappyDay100426() throws Exception {

		gstrTCID = "100426";
		gstrTO = " Create a status type ST selecting a role R1 under ‘Roles with view rights’, add ST to resource RS at the resource level and verify that user with role R1 & with 'View Resource' right on RS CAN view ST on following screens:"+

				"a. Region view screen"+
				"b. Map (in the status type dropdown and in resource pop up window)"+
				"c. View Resource Detail"+
				"d. Custom view"+
				"e. Event details"+
				"f. Mobile view"+
				"g. Edit My Status Change Preferences";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();
		Event_data objEvent_data = new Event_data();
		Roles_data objRolesData = new Roles_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap = new Map(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusTypeValues2[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(objStatusTypes_data.strNumberStatusType, objStatusTypes_data.strNSTStatusTypeName, 
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(objStatusTypes_data.strNumberStatusType, objStatusTypes_data.strTSTStatusTypeName, 
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.createResourceWithAddress(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName, objResource_data.strStreetAddress, objResource_data.strCity, objResource_data.strState, objResource_data.strCounty, objResource_data.strZipcode);

		objResource.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource.selectStatusType(strStatusTypeValues2);
		objResource.clickOnSaveButton();
		
		objResource.verResourceInList(objResource_data.strResourceName);
		
		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();
		
		String strSTNames[] = {objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strTSTStatusTypeName};

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//		objViewsList.selectStatusType(objStatusTypes_data.strNSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName);
		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);


		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption()
				.selectSetupResourceOption()
				.selectEditResourcesOnlyOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectMaintainEventsOption()
				.selectViewcustomViewOption()
				.selectEditStatusChangeNotPrefernceOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();
		objEventSetUp
		.clickOncreateEventTemplate()
		.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(
				objEventSetUp_data.strTemplateDefinition)
		.selectResourceType(strResourceTypeValue[0])
		.selectStatusType(strStatusTypeValues[0])
		.clickSaveButton()
		.deselectSelectAllEmailOption()
		.deselectSelectAllPagerOption()
		.deselectSelectAllWebOption()
		.verEveTemplateListScreenIsDisplayed();
	
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue[0])
		.clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName);
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objEvent_data.strEventName);
		System.out.println(objView_data.strViewName);
		
		objStatusTypeList1.navigateToStatusTypeList();
		
		objStatusTypeList1.clickCreateNewStatusTypeButton();
		objStatusTypeList1.selectStatusType(objStatusTypes_data.strMultiStatusType);
		objStatusTypeList1.clickNextButton();
		objStatusTypeList1.verifyCreateMultiStatusTypePage();
		objStatusTypeList1.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName);
		objStatusTypeList1.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList1.selectRoleUnderRolesWithViewRight(strRoleValue[0]);
		objStatusTypeList1.selectRoleUnderRolesWithUpdateRight(strRoleValue[0]);
		objStatusTypeList1.clickOnSaveButton();
		
		objStatusTypeList1.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);
		

		strStatusesValues[0] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
	
		
		objStatusTypeList1.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1);
		

		strStatusesValues[0] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		
		objStatusTypeList1.clickOnReturnToStatusTypeList();
		
		objStatusTypeList1.verifyTypeColumnForST(objStatusTypes_data.strMultiStatusType, objStatusTypes_data.strMSTStatusTypeName);
		
		strStatusTypeValues1[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		
		objResource1.navigateToResourceListPage();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource1.selectStatusType(strStatusTypeValues1);
		objResource1.clickOnSaveButton();
		
		objResource1.verResourceInList(objResource_data.strResourceName);
		
		objNavigationToSubmenus1.navigateToViews();
		
		objViewsList1.clickOnEditLinkOfView(objView_data.strViewName)
					 .clickOnResourcesTab()
					 .selectResource(objResource_data.strResourceName)
					 .clickOnSTTab();
//		objViewsList1.selectResourceType(strResourceTypeValue[0]);
		objViewsList1.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
					 .clickOnSaveOfCreateNewView();

		objViewsList1.verViewInList(objView_data.strViewName);
	
		objViewsList1.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection().clickOnSaveButton();
		
		objStatusTypeList1.navigateToStatusTypeListNew();
		
		objStatusTypeList1.clickOnEditOfStatusType(objStatusTypes_data.strMSTStatusTypeName);
		objStatusTypeList1.selectSectionName(objView_data.strSectionName);
		objStatusTypeList1.clickOnSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0], objStatusTypes_data.strMSTStatusTypeName);
		
		objViewsList1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
		
		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(objStatusTypes_data.strMSTStatusTypeName, objView_data.strSectionName);
	
		
		objNavigationToSubmenus1.navigateToMap();
		
		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName);
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow();
		
		String strStatusTypeNames[] = {objStatusTypes_data.strMSTStatusTypeName, objStatusTypes_data.strNSTStatusTypeName};
		
		objMap.verStatusTypesInPopupWindow(strStatusTypeNames);
		
		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate);
		
		objEventSetUp1.selectStatusType(strStatusTypeValues1[0]);
		objEventSetUp1.clickSaveButton();
			
		objEventSetUp1.verifyEventTempName(objEventSetUp_data.strEventTemplate);
		
		objEventManagement1.navigateToEventManagementNew();
		
		objEventManagement1.clickOnEditLink(objEvent_data.strEventName);
		
		objEventManagement1.verifyResourceInSelectResourcePage(strResourceValue);
		objEventManagement1.selectStatusType(strStatusTypeValues1[0]);
		
		objEventManagement1.clickOnSaveButton();
		
		objNavigationToSubmenus1.navigateStatusChangeInPreferences();
		
		objStatusChangePreference1
		.verMyStatusChangePreferncePgeDisplayed()
		.clickOnAdd()
		.enterResNameInWhatField(objResource_data.strResourceName)
		.clickOnSearch()
		.selectResource(strResourceValue[0])
		.clickOnNotifications()
		.verStatusTypesUnderUncategorizedSec(objStatusTypes_data.strMSTStatusTypeName);

		objLogin1.clickLogOut();
			
		gstrResult = "PASS";
	}
	
	
	/*************************************************************************************
	'Description : Status type ST is associated with resource RS at the resource level. Verify that a user with ‘Update Status’ right on resource RS but without view/update permissions for status type ST DOES NOT receive expired status notifications when the status of ST expires.
	'Date	 	 : 25-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " Status type ST is associated with resource RS at the resource level. Verify that a user with ‘Update Status’ right on resource RS but without view/update permissions for status type ST DOES NOT receive expired status notifications when the status of ST expires.")
	public void testHappyDay44281() throws Exception {

		gstrTCID = "44281";
		gstrTO = " Status type ST is associated with resource RS at the resource level. Verify that a user with ‘Update Status’ right on resource RS but without view/update permissions for status type ST DOES NOT receive expired status notifications when the status of ST expires.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		SystemNotifications objSystemNotifications_page = new SystemNotifications(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strStatusesValues1[] = new String[2];
		String strStatusTypeValues1[] = new String[1];
		
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
				.selectEventExpirationOption()
				.selectExpirationMinute(objStatusTypes_data.strExpSec)
				.clickOnSaveButton();

		strStatusesValues[1] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		StatusTypeList_page.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		String strApplicationTime = objEventManagement.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strTimeInMin = objDts.addTimetoExisting(strTime[2], 10, "HH:mm");
		String strTime1[] = strTimeInMin.split(":");
		System.out.println(strTimeInMin);	

		StatusTypeList_page.createStatusTypeWithShiftTime(objStatusTypes_data.strMultiStatusType, objStatusTypes_data.strMSTStatusTypeName1, 
						objStatusTypes_data.strStatusDescription,strTime1[0], strTime1[1]);
		
			StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti2)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.clickOnSaveButton();
			
		strStatusesValues1[0] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti3)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.clickOnSaveButton();
		
		strStatusesValues1[1] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);
		
		StatusTypeList_page.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);
		
		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);
		
		System.out.println(objResourceType_data.strResourceTypeName);

		// Resource creation
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page.createResourceWithAddress(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName, objResource_data.strStreetAddress, objResource_data.strCity, objResource_data.strState, objResource_data.strCounty, objResource_data.strZipcode);
		
		objResource_Page.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource_Page.selectStatusType(strStatusTypeValues1);
		
		objResource_Page.clickOnSaveButton();
		
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
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnsystemNotifyPreferences();
		objSystemNotifications_page.selectAndSaveExpiredStatusNotification();
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.selectViewResourceRights(objResource_data.strResourceName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
		
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		objMap1.clickUpdateStatusInPopupWindow();
		objUpdateStatus1.clickOnSelectAll();
		
		objUpdateStatus1
				.verUpdateStatusPge()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues1[0])
				.clickOnSaveButton();

		objLogin1.clickLogOut();


		// wait until expiration time
		Thread.sleep(360000);
		
		String strSubject = "Expired Status Notification: "
				+ objResource_data.strResourceName;

		String strSubject1 = "Expired Status: "
				+ objResource_data.strResourceAbbrivation;

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubject);
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresentNew(strSubject1);
		
		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description : Create status type ST selecting a role R1 under ‘Roles with view rights’, associate ST with resource RS
	               at resource TYPE level and verify that user with role R1 and with only 'View Resource' right on RS CAN
	                view ST on following screens:
					a. Region view
					b. Map (status type dropdown and resource pop up window)
					c. View Resource Detail
					d. Custom view
					e. Event detail
					f. Mobile view
					g. Edit My Status Change preferences
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = "Create status type ST selecting a role R1 under ‘Roles with view rights’, associate ST with"
			+ " resource RS at resource TYPE level and verify that user with role R1 and with only 'View Resource' right on RS CAN view ST on following screens:"+
			"a. Region view screen"+
			"b. Map (in the status type dropdown and in resource pop up window)"+
			"c. View Resource Detail"+
			"d. Custom view"+
			"e. Event details"+
			"f. Mobile view"+
			"g. Edit My Status Change Preferences")
	
	public void testHappyDay99519() throws Exception {

		gstrTCID = "99519";
		gstrTO = "Create status type ST selecting a role R1 under ‘Roles with view rights’, associate ST with resource"
				+ " RS at resource TYPE level and verify that user with role R1 and with only 'View Resource' right on RS CAN view ST on following screens:"+
				"a. Region view screen"+
				"b. Map (in the status type dropdown and in resource pop up window)"+
				"c. View Resource Detail"+
				"d. Custom view"+
				"e. Event details"+
				"f. Mobile view"+
				"g. Edit My Status Change Preferences";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp ObjEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);	
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();
		
		//Role-Based Status Types
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

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
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		//User
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						"", "", "", "", "", objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption()
				.selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectEditResourcesOnlyOption()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption()
				.selectEditStatusChangeNotPrefernceOption()
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
        //View
		objViewsList.navigateToViewsList().createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				objStatusTypes_data.strNSTStatusTypeName);

		/*.clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc)
				.selectStatusTypeForView(strStatusTypeValues)
				.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();*/
		
		ObjEventSetUp.navigateToEventSetUp();

		ObjEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println("----------------Precodition execution ends---------");

		System.out.println("-----------------Test execution starts---------------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
		.enterAdHocEventName(objEventdata.strEventName)
		.enterAdHocEventDescription(objEventdata.strEventDescription)
		.selectResource(strResourceValue).clickOnSaveButton();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();
		
		objStatusTypeList1
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectSectionName(objView_data.strSectionName)
                .deSelectRoleUnderRolesWithUpdateRight()
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.clickOnSaveButton()

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList1.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList1.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();
		
		objResourceType1
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.clickStatusType(strStatusTypeValues1).clickOnSaveButton();
		
		objViewsList1.navigateToViewsList()
				.clickOnEditLinkOfView(objView_data.strViewName)
				.clickOnSTTab()
				.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
//				.selectStatusTypeForView(strStatusTypeValues1)
//				.selectResourceType(strResourceTypeValue[0])
				.clickOnSaveOfCreateNewView();	
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		//View
		
		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
				objStatusTypes_data.strMSTStatusTypeName);
		
		//View resource detail
		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strResourceName)

		.verifyStatusTypeUnderSectionsInResourceDetailPage(
				objStatusTypes_data.strMSTStatusTypeName,
				objView_data.strSectionName);
		
		String[] strStatusTypesValue={objStatusTypes_data.strMSTStatusTypeName};
		//View Map
		
		objNavigationToSubmenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName);
		
		objMap1.verStatusTypesInPopupWindow(strStatusTypesValue);
		
		//Event Management
		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1.clickOnEditTempLink(objEventSetUpdata.strEventTemplate)
				.selectStatusType(strStatusTypeValues1[0])
				.clickSaveButton();
			
		objEventManagement1.navigateToEventManagementNew()

		.clickOnEditLink(objEventdata.strEventName)
				.selectStatusType(strStatusTypeValues1[0]).clickOnSaveButton()
				.clickOnEventNameInEventBanner(objEventdata.strEventName);
		
		objEventStatus1.verStatusTypes(
				objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strMSTStatusTypeName);
		
		//Custom view Table	
		objNavigationToSubmenus1.navigateToCustomizedViewInPrefrences();
		
		objCustomUnderView1.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues1).clickOnSave();

		objCustomUnderView1
				.verStatusTypeInCustomViewTablePage(strStatusTypesValue);
		
		//Custom view Map

		objCustomUnderView1.clickOnCustomeViewMap();

		objCustomUnderView1.verCustomViewMapScreenIsDisplayed();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName);
		
		objMap1.verStatusTypesInPopupWindow(strStatusTypesValue);
		
		//Edit My Status Change preferences
		
		objNavigationToSubmenus1.navigateStatusChangeInPreferences();
		
		objStatusChangePreference1
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.expandUncategorizedSec()
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strMSTStatusTypeName);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	:  Create a status type ST selecting a role R1 under ‘Roles with view rights’ section, associate ST with resource RS at the resource level and verify that the user with role R1 and ‘Update Status’ right on resource RS receives expired status notification for resource RS when the status of ST expires.
	'Date 			: 05-Jan-2016
	'Author 		: Sangappa  k
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description ="Create a status type ST selecting a role R1 under ‘Roles with view rights’ section, associate ST with resource RS at the resource level and verify that the user with role R1 and ‘Update Status’ right on resource RS receives expired status notification for resource RS when the status of ST expires.")
	public void testHappyDay44279() throws Exception {

		gstrTCID ="44279";
		gstrTO = "Create a status type ST selecting a role R1 under ‘Roles with view rights’ section, associate ST with resource RS at the resource level and verify that the user with role R1 and ‘Update Status’ right on resource RS receives expired status notification for resource RS when the status of ST expires.";
	

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strStatusesValues1[] = new String[2];

		String strCurrentYear = "";

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
     objNavigationToSubmenus.navigateToRoles();
		
		objRoles.deleteDefaultRoleIfExist();

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
				.selectEventExpirationOption()
				.selectExpirationMinute(objStatusTypes_data.strExpSec)
				.clickOnSaveButton();

		strStatusesValues[1] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		StatusTypeList_page.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		String strApplicationTime = objEventManagement.getApplicationTime();
		String strTime[] = strApplicationTime.split(" ");
		String strTimeInMin = objDts.addTimetoExisting(strTime[2], 10, "HH:mm");
		String strTime1[] = strTimeInMin.split(":");
		System.out.println(strTimeInMin);

		strCurrentYear = objDts.getCurrentDate("yyyy");

		String strApplicationTime1 = strApplicationTime + " " + strCurrentYear;

		strApplicationTime1 = objDts.converDateFormat(strApplicationTime1,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime1 = objDts.addTimetoExisting(strApplicationTime1, 10,
				"MM/dd/yyyy HH:mm");

		System.out.println("strApplicationTime3 " + strApplicationTime1);

		StatusTypeList_page.createStatusTypeWithShiftTime(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription, strTime1[0],
				strTime1[1]);

		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti2)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.clickOnSaveButton();

		strStatusesValues1[0] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti3)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.clickOnSaveButton();

		strStatusesValues1[1] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		StatusTypeList_page.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		System.out.println(objStatusTypes_data.strMSTStatusTypeName1);

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		// Resource creation
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page.createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation1,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objResource_Page
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.verEditResourceLevelStatusTypesPageisDisplayed()
				.selectStatusType(strStatusTypeValues).clickOnSaveButton();

		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectFirstRole()
				.clickSaveButton()

				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)

				.clickSystemNotificationPreferences()
				.clickExpiredStatusNotificationsEmailCheckBox()
				.clickExpiredStatusNotificationsTextPagerCheckBox()
				.clickSaveButton().clickOnOkButton();

		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectSecRole().clickSaveButton();
		System.out.println(objUserdata.strNewUserName1);
		objLogin.clickLogOut();

		System.out
				.println("---Precondition ends and test execution starts----");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		objMap1.clickUpdateStatusInPopupWindow();
		objUpdateStatus1.clickOnSelectAll();

		objUpdateStatus1
				.verUpdateStatusPge()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[1])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues1[1]).clickOnSaveButton();

		strApplicationTime = EventManagement_page1.getApplicationTime();

		strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");

		System.out.println("// wait until expiration time");

		// Wait for 5 min
		TimeUnit.MINUTES.sleep(5);

		String strSubjName = "Expired Status Notification: "
				+ objResource_data.strResourceName;

		String strSubjName1 = "Expired Status: "
				+ objResource_data.strResourceAbbrivation1;

		String strMsgBody1 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime);

		String strMsgBody2 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime);

		String strMsgBody3 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName, strApplicationTime1);

		String strMsgBody4 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName, strApplicationTime1);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubjName);

		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;
		boolean boolCheck3 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjName);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			if (boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck && boolCheck1);

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjName1);

			if (boolCheck2 == false) {
				boolCheck2 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			if (boolCheck3 == false) {
				boolCheck3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody4);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck2 && boolCheck3);

		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description : Verify that when the view permissions of a status type are edited, the changes are reflected on ‘My Status Change Preferences’ screen.
	'Date 		: 06-Jan-2016
	'Author		 : Sangappa K
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = "Verify that when the view permissions of a status type are edited, the changes are reflected on ‘My Status Change Preferences’ screen.")
	
	public void testHappyDay44299() throws Exception {

		gstrTCID = "44299";
		gstrTO = "Verify that when the view permissions of a status type are edited, the changes are reflected on ‘My Status Change Preferences’ screen.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName).clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		// User
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		objLogin.clickLogOut();

		System.out
				.println("----------------Precodition execution ends---------");

		System.out
				.println("-----------------Test execution starts---------------");

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strNumberStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strNSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectRoleUnderRolesWithUpdateRight(strRoleValue[0])
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.clickOnSaveButton();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.deSelectRoleUnderRolesWithUpdateRight()
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.clickOnSaveButton()

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strTextStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strTSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.deSelectRoleUnderRolesWithUpdateRight()
				.deSelectRoleUnderRolesWithViewRight().clickOnSaveButton();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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
				.clickOnSaveButton().clickOnSaveButton();

		System.out.println(objResource_data.strResourceName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		// Edit My Status Change preferences

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.expandUncategorizedSec()
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strNSTStatusTypeName)
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strMSTStatusTypeName)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1
				.clickOnEditOfStatusType(
						objStatusTypes_data.strNSTStatusTypeName)
				.deSelectRoleUnderRolesWithUpdateRight()
				.deSelectRoleUnderRolesWithViewRight()
				.clickOnSaveButton()
				.verifyStatusTypeInList(
						objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList1
				.clickOnEditOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName)
				.selectRoleUnderRolesWithUpdateRight(strRoleValue[0])
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.clickOnSaveButton()
				.verifyStatusTypeInList(
						objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList1
				.clickOnEditOfStatusType(
						objStatusTypes_data.strTSTStatusTypeName)
				.deSelectRoleUnderRolesWithUpdateRight()
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.clickOnSaveButton()
				.verifyStatusTypeInList(
						objStatusTypes_data.strTSTStatusTypeName);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		// Edit My Status Change preferences

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.expandUncategorizedSec()
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strTSTStatusTypeName)
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strMSTStatusTypeName)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strNSTStatusTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*********************************************************************************************************************
	'Description : Create status type ST selecting a role R1 both under ‘Roles with view rights’ and ‘Roles with Update rights’ sections, "
					associate ST with resource RS at resource TYPE level and verify that user with role R1 and with ‘Update Status’ right on RS CAN view and update the status of ST from following screens:"
						"a. Region view"
						"b. Map screen (from resource pop window)"
						"c. Custom view" + "d. View Resource Detail" + "e. Event detail
	'Date		 : 19-Jan-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = "Create status type ST selecting a role R1 both under ‘Roles with view rights’ and ‘Roles with Update rights’ sections, "
			+ "associate ST with resource RS at resource TYPE level and verify that user with role R1 and with ‘Update Status’ right on RS CAN view and update the status of ST from following screens:"
			+ "a. Region view"
			+ "b. Map screen (from resource pop window)"
			+ "c. Custom view" + "d. View Resource Detail" + "e. Event detail")
	public void testHappyDay99087() throws Exception {

		gstrTCID = "99087";
		gstrTO = "Create status type ST selecting a role R1 both under ‘Roles with view rights’ and ‘Roles with Update rights’ sections, "
				+ "associate ST with resource RS at resource TYPE level and verify that user with role R1 and with ‘Update Status’ right on RS CAN view and update the status of ST from following screens:"
				+ "a. Region view"
				+ "b. Map screen (from resource pop window)"
				+ "c. Custom view"
				+ "d. View Resource Detail"
				+ "e. Event detail";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Role-Based Status Types

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

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

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);

		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption().clickSaveButton();

		objViewsList.navigateToViewsList()
				.createView(objView_data.strViewName,
								objView_data.strViewDesc, objResource_data.strResourceName,
								objStatusTypes_data.strNSTStatusTypeName);
		/*.clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc)
				.selectStatusTypeForView(strStatusTypeValues)
				.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();*/

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objStatusTypes_data.strMSTStatusTypeName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objStatusTypeList1.navigateToStatusTypeList()
				.createStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName);

		objStatusTypeList1.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.clickOnSaveButton();

		strStatusesValues[0] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList1.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnSaveButton();

		strStatusesValues[1] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList1.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType1
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.clickStatusType(strStatusTypeValues1).clickOnSaveButton();

		System.out.println(objView_data.strViewName);

		objViewsList1.navigateToViewsList()
				.clickOnEditLinkOfView(objView_data.strViewName)
				.clickOnSTTab()
				.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
				.clickOnSaveOfCreateNewView();

		Thread.sleep(2000);
		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues1[0])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[0]).clickOnSaveButton();

		objViewsList1.verifyUpdatedValue(strResourceValue[0],
				strStatusTypeValues1[0],
				objStatusTypes_data.strStatusNameInMulti);

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strResourceName)
				.clickOnIndividualUpdateStatus(strResourceValue[0],
						strStatusTypeValues1[0]);

		objUpdateStatus1
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[1])
				.enterComments(strStatusTypeValues1[0], objView_data.strComment)
				.clickOnSaveButton();

		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
				objStatusTypes_data.strMSTStatusTypeName,
				objView_data.strSectionName).verifyUpdatedValueAndComments(
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusNameInMulti1,
				objView_data.strComment);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues1[0])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[0]).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verUpdateValuesInPopupWindow(
				objStatusTypes_data.strStatusNameInMulti);

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objEventSetUpdata.strEventTemplate)
				.selectStatusType(strStatusTypeValues1[0]).clickSaveButton();

		objEventManagement1
				.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
				.enterAdHocEventName(objEventdata.strEventName)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventInformation(objEventdata.strEventName,
						objEventdata.strEventDescription);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues1[0])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[1]).clickOnSaveButton();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues1[0],
				objStatusTypes_data.strStatusNameInMulti1);

		objNavigationToSubmenus1.navigateToCustomizedViewInPrefrences();

		objCustomUnderView1.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues)
				.selectStatusTypes(strStatusTypeValues1).clickOnSave();

		System.out.println(objView_data.strCustomView);

		objNavigationToSubmenus1.navigateToCustomInView();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues1[0])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[0]).clickOnSaveButton();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues1[0],
				objStatusTypes_data.strStatusNameInMulti);

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues1[0])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[1]).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verUpdateValuesInPopupWindow(
				objStatusTypes_data.strStatusNameInMulti1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description : Create a status type ST selecting a role R1 both under ‘Roles with view rights’ and ‘Roles with Update rights’ sections, 
					add ST to resource RS at the resource level and verify that user with role R1 and with ‘Update Status’ right on resource RS CAN view and update the status of ST from following screens:
						a. Region view
						b. Map screen (from resource pop window)
						c. Custom view
						d. View Resource Detail
						e. Event detail
	'Date		 : 20-Jan-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = "Create status type ST selecting a role R1 both under ‘Roles with view rights’ and ‘Roles with Update rights’ sections, "
			+ "associate ST with resource RS at the resource level and verify that user with role R1 and with ‘Update Status’ right on RS CAN view and update the status of ST from following screens:"
			+ "a. Region view"
			+ "b. Map screen (from resource pop window)"
			+ "c. Custom view" + "d. View Resource Detail" + "e. Event detail")
	public void testHappyDay44253() throws Exception {

		gstrTCID = "44253";
		gstrTO = "Create status type ST selecting a role R1 both under ‘Roles with view rights’ and ‘Roles with Update rights’ sections, "
				+ "associate ST with resource RS at the resource level and verify that user with role R1 and with ‘Update Status’ right on RS CAN view and update the status of ST from following screens:"
				+ "a. Region view"
				+ "b. Map screen (from resource pop window)"
				+ "c. Custom view"
				+ "d. View Resource Detail"
				+ "e. Event detail";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Role-Based Status Types

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

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

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);

		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption()
				.clickSaveButton();

		objViewsList.navigateToViewsList()
//					.clickCreateNewViewButton()
//					.enterViewName(objView_data.strViewName)
//					.enterViewDesc(objView_data.strViewDesc)
//					.selectStatusTypeForView(strStatusTypeValues)
//					.selectResource(objResource_data.strResourceName)
//					.clickOnSaveOfCreateNewView()
					.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objStatusTypes_data.strMSTStatusTypeName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objStatusTypeList1.navigateToStatusTypeList()
				.createStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName);

		objStatusTypeList1.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.clickOnSaveButton();

		strStatusesValues[0] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList1.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnSaveButton();

		strStatusesValues[1] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList1.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType1
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.clickStatusType(strStatusTypeValues1).clickOnSaveButton();

		System.out.println(objView_data.strViewName);

		objViewsList1.navigateToViewsList()
				.clickOnEditLinkOfView(objView_data.strViewName)
				.clickOnSTTab()
				.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
				.clickOnSaveOfCreateNewView();

		Thread.sleep(2000);
		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues1[0])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[0]).clickOnSaveButton();

		objViewsList1.verifyUpdatedValue(strResourceValue[0],
				strStatusTypeValues1[0],
				objStatusTypes_data.strStatusNameInMulti);

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strResourceName)
				.clickOnIndividualUpdateStatus(strResourceValue[0],
						strStatusTypeValues1[0]);

		objUpdateStatus1
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[1])
				.enterComments(strStatusTypeValues1[0], objView_data.strComment)
				.clickOnSaveButton();

		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
				objStatusTypes_data.strMSTStatusTypeName,
				objView_data.strSectionName).verifyUpdatedValueAndComments(
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusNameInMulti1,
				objView_data.strComment);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues1[0])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[0]).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verUpdateValuesInPopupWindow(
				objStatusTypes_data.strStatusNameInMulti);

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objEventSetUpdata.strEventTemplate)
				.selectStatusType(strStatusTypeValues1[0]).clickSaveButton();

		objEventManagement1
				.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
				.enterAdHocEventName(objEventdata.strEventName)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventInformation(objEventdata.strEventName,
						objEventdata.strEventDescription);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues1[0])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[1]).clickOnSaveButton();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues1[0],
				objStatusTypes_data.strStatusNameInMulti1);

		objNavigationToSubmenus1.navigateToCustomizedViewInPrefrences();

		objCustomUnderView1.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues)
				.selectStatusTypes(strStatusTypeValues1).clickOnSave();

		System.out.println(objView_data.strCustomView);

		objNavigationToSubmenus1.navigateToCustomInView();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues1[0])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[0]).clickOnSaveButton();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues1[0],
				objStatusTypes_data.strStatusNameInMulti);

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues1[0])
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[1]).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verUpdateValuesInPopupWindow(
				objStatusTypes_data.strStatusNameInMulti1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description : Create status type ST without selecting any roles (view/update), associate ST with resource RS at resource TYPE level and verify that ST is NOT displayed for non system admin user on following screens:
						a. Region view
						b. Map (in the status type dropdown and in resource pop up window)
						c. View Resource Detail
						d. Custom view
						e. Event details
						f. Mobile view
						g. Edit My Status Change Preferences
	'Date		 : 27-Jan-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = "Create status type ST without selecting any roles (view/update), associate ST with resource RS at resource TYPE level and verify that ST is NOT displayed for non system admin user on following screens:"
			+ "a. Region view"
			+ "b. Map (in the status type dropdown and in resource pop up window)"
			+ "c. View Resource Detail"
			+ "d. Custom view"
			+ "e. Event details"
			+ "f. Mobile view" + "g. Edit My Status Change Preferences")
	
	public void testHappyDay49691() throws Exception {

		gstrTCID = "49691";
		gstrTO = "Create status type ST without selecting any roles (view/update), associate ST with resource RS at resource TYPE level and verify that ST is NOT displayed for non system admin user on following screens:"
				+ "a. Region view"
				+ "b. Map (in the status type dropdown and in resource pop up window)"
				+ "c. View Resource Detail"
				+ "d. Custom view"
				+ "e. Event details"
				+ "f. Mobile view"
				+ "g. Edit My Status Change Preferences";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
	
		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Role-Based Status Types

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

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

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);

		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption().clickSaveButton();

		objViewsList.navigateToViewsList()
					.createView(objView_data.strViewName,
									objView_data.strViewDesc, objResource_data.strResourceName,
									objStatusTypes_data.strNSTStatusTypeName);
					/*.clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc)
				.selectStatusTypeForView(strStatusTypeValues)
				.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();*/

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objStatusTypes_data.strMSTStatusTypeName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objStatusTypeList1
				.navigateToStatusTypeList()
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectSectionName(objView_data.strSectionName)
				.deSelectRoleUnderRolesWithUpdateRight()
				.deSelectRoleUnderRolesWithViewRight().clickOnSaveButton();

		objStatusTypeList1.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.clickOnSaveButton();

		strStatusesValues[0] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList1.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnSaveButton();

		strStatusesValues[1] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList1.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType1
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.clickStatusType(strStatusTypeValues1).clickOnSaveButton();

		System.out.println(objView_data.strViewName);

		objViewsList1.navigateToViewsList()
				.clickOnEditLinkOfView(objView_data.strViewName)
				.clickOnSTTab()
				.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
				.clickOnSaveOfCreateNewView();

		Thread.sleep(2000);
		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.verStatusTypesNotDisplayedWithRes(
				strResourceTypeValue[0], strResourceValue[0],
				objStatusTypes_data.strMSTStatusTypeName);

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strResourceName)
				.verifyStatusTypeIsNotUnderSectionsInResourceDetailPage(
						objStatusTypes_data.strMSTStatusTypeName,
						objView_data.strSectionName);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesNotInPopupWindow(strStatusTypeValues1)
				.verSTNotInStatusTypeDropDown(
						objStatusTypes_data.strMSTStatusTypeName);

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objEventSetUpdata.strEventTemplate)
				.selectStatusType(strStatusTypeValues1[0]).clickSaveButton();

		objEventManagement1
				.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
				.enterAdHocEventName(objEventdata.strEventName)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventInformation(objEventdata.strEventName,
						objEventdata.strEventDescription);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		objViewsList1.verStatusTypesNotDisplayedWithRes(
				strResourceTypeValue[0], strResourceValue[0],
				objStatusTypes_data.strMSTStatusTypeName);

		objNavigationToSubmenus1.navigateToCustomizedViewInPrefrences();

		objCustomUnderView1.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.verSTNotDisplayedInOptions(strStatusTypeValues1)
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		System.out.println(objView_data.strCustomView);

		objNavigationToSubmenus1.navigateToCustomInView();

		objViewsList1.verStatusTypesNotDisplayedWithRes(
				strResourceTypeValue[0], strResourceValue[0],
				objStatusTypes_data.strMSTStatusTypeName);

		objLogin1.clickLogOut();
		
		String[] strTestData = {
				gstrTCID,
				objLogindata.strRegionName,
				objUserdata.strNewUserName + "/" + objUserdata.strNewPassword,
				objStatusTypes_data.strNSTStatusTypeName + ", "
						+ objStatusTypes_data.strMSTStatusTypeName,
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName, objView_data.strViewName };

		objOffCommonFunc.writeResultData(strTestData,
				strPartialAutoResultsPath, "MobileTestData");

		gstrResult = "PASS";
	}
}
