package requirementGroup.SettingUpRoles;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewRoleWithOverrideViewingRestrictionsRight extends TestNG_UI_EXTENSIONS {

	public NewRoleWithOverrideViewingRestrictionsRight() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*******************************************************************************************
	'Description 	: Verify that user can be provided a role in which the only right ‘Override 
	                  Viewing restrictions’ right is selected
	'Date 			: 15-June-2014 
	'Author 		: Anitha
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	                  Modified By
	'Date					                                              Name
	********************************************************************************************/
	@Test(description = "Verify that user can be provided a role in which the only right ‘Override Viewing "
			+ "restrictions’ right is selected.")
	public void testHappyDay81344() throws Exception {

		gstrTCID = "81344";
		gstrTO = "Verify that user can be provided a role in which the only right ‘Override Viewing"
				+ " restrictions’ right is selected.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		View_data objView_data = new View_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventSetUp ObjEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Map objMap1 = new Map(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		Views objViews1 = new Views(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagementPage1 = new EventManagement(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);

		String strStatusTypeValues[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
				objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti)
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.clickSaveButton();

		// User1 creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
		
		String strStatusTypeNames[] = {objStatuTypes_data.strNSTStatusTypeName,objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName, 
				objStatuTypes_data.strSSTStatusTypeName};
		
        //View
		objViewsList.navigateToViewsList()
					.createView(objView_data.strViewName, objView_data.strViewDesc, 
								objResource_data.strResourceName, strStatusTypeNames);

//		
//		.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		ObjEventSetUp.navigateToEventSetUp();

		ObjEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		
		objLogin.clickLogOut();

		System.out.println("-------Precondition ends and test execution starts-------");
		
		objLogin.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		objEventManagement.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
				.enterAdHocEventName(objEventdata.strEventName)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton();

		objLogin.clickLogOut();

		System.out.println("-------Precondition ends and test execution starts-------");
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);

		objUsersList1.selectOverrideViewingRestrictionOption();

		objRoles1.clickOnSaveBtn();

		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);

		objnNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectRoleCheckBox(strRoleValue[0]).clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1
				.verifyStatusTypeNameInView(strResourceTypeValue[0],
						objStatuTypes_data.strMSTStatusTypeName)
				.verifyStatusTypeNameInView(strResourceTypeValue[0],
						objStatuTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeNameInView(strResourceTypeValue[0],
						objStatuTypes_data.strSSTStatusTypeName)
				.verifyStatusTypeNameInView(strResourceTypeValue[0],
						objStatuTypes_data.strTSTStatusTypeName);

		objViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViews1
				.verStatusTypesUnderSection(
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strMSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strSSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName);
		
		objEventManagementPage1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		objEventStatus1
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strMSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strNSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strSSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strTSTStatusTypeName);
		
		objnNavigationToSubMenus1.navigateToMapPage();

		String[] strStatusTypeNames1 = {
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/********************************************************************************************************************
	'Description 	: Verify that user with ‘Override Viewing restrictions’ right can view all the refined status type on
						1. Region View screen
						2. View Resource Detail screen
						3. Map screen
						4. Event Status screen 
	'Date 			: 15-June-2014 
	'Author 		: Anitha
	'--------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                  Modified By
	'Date					                                              Name
	*********************************************************************************************************************/
	@Test(description ="Verify that user with ‘Override Viewing restrictions’ right can view all the refined status type on"
			+ "1. Region View screen"
			+ "2. View Resource Detail screen"
			+ "+3. Map screen" + "4. Event Status screen")
	public void testHappyDay104569() throws Exception {

		gstrTCID = "104569";
		gstrTO = "Verify that user with ‘Override Viewing restrictions’ right can view all the refined status type on"
				+ "1. Region View screen"
				+ "2. View Resource Detail screen"
				+ "+3. Map screen" + "4. Event Status screen";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		View_data objView_data = new View_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventSetUp ObjEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Map objMap1 = new Map(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		Views objViews1 = new Views(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagementPage1 = new EventManagement(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[2];
		String strRoleValue[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1, strStatusTypeValues);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

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
		
		objResource.createResourceWithAddress(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.clickSaveButton();

		// User1 creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
        //View
		String strResourceName[] = {objResource_data.strResourceName, objResource_data.strResourceName1};
		String strStatusTypeNames[] = {objStatuTypes_data.strNSTStatusTypeName,objStatuTypes_data.strTSTStatusTypeName };
		
		objViewsList.navigateToViewsList()
		.createViewForMultipleResourcesAndStatusTypes(objView_data.strViewName, objView_data.strViewDesc, strResourceName, strStatusTypeNames);
		
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues)
//				.selectResource(objResource_data.strResourceName)
//				.selectResource(objResource_data.strResourceName1)
//				.clickOnSaveOfCreateNewView();
		
		ObjEventSetUp.navigateToEventSetUp();

		ObjEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		objLogin.loginAsNewUser(objUser_data.strNewUserName1,
						objUser_data.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		objEventManagement.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
				.enterAdHocEventName(objEventdata.strEventName)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton();

		objLogin.clickLogOut();

		System.out.println("-------Precondition ends and test execution starts-------");
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);

		objUsersList1.selectOverrideViewingRestrictionOption();

		objRoles1.clickOnSaveBtn();

		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);

		objnNavigationToSubMenus1.navigateToUsers();

		String[] strStatusTypeValues1={strStatusTypeValues[0]};
		
		objUsersList1
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectRoleCheckBox(strRoleValue[0])
				.clickSaveButton()
				.editUserDetails(objUser_data.strNewUserName)
				.clickRefineLinkOfViewResource(objResource_data.strResourceName)
				.selectFrameOfRefineVisibleStatusTypes()
				.deselectStatusTypesInRefine(strStatusTypeValues1)
				.clickSaveChangesButtonInRefine()
				.selectFrame()
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
				objStatuTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeNameInView(strResourceTypeValue[0],
						objStatuTypes_data.strTSTStatusTypeName);
		
		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[1],
				objStatuTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeNameInView(strResourceTypeValue[1],
						objStatuTypes_data.strTSTStatusTypeName);

		objViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViews1.verStatusTypesUnderSection(
				objStatuTypes_data.strNSTStatusTypeName,
				objView_data.strSectionName).verStatusTypesUnderSection(
				objStatuTypes_data.strTSTStatusTypeName,
				objView_data.strSectionName);

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName1);

		objViews1.verStatusTypesUnderSection(
				objStatuTypes_data.strNSTStatusTypeName,
				objView_data.strSectionName).verStatusTypesUnderSection(
				objStatuTypes_data.strTSTStatusTypeName,
				objView_data.strSectionName);

		objEventManagementPage1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		objEventStatus1
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strNSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strTSTStatusTypeName);
		
		objEventStatus1.verStatusTypes(
				objResourceType_data.strResourceTypeName1,
				objStatuTypes_data.strNSTStatusTypeName).verStatusTypes(
				objResourceType_data.strResourceTypeName1,
				objStatuTypes_data.strTSTStatusTypeName);
		
		objnNavigationToSubMenus1.navigateToMapPage();

		String[] strStatusTypeNames1 = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames1);
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName1)
				.verStatusTypesInPopupWindow(strStatusTypeNames1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
