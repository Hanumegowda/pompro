package requirementGroup.CreatingAndManagingEvents;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewPrivateMultiRegionEvent extends TestNG_UI_EXTENSIONS{

	public NewPrivateMultiRegionEvent() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/***************************************************************************************************
	 * 'Description 	: Create a private Multi region event and verify that a user with 'Update status
	 *                    right on the resource can view the event related status types of the resource 
	 *                    participating in private Multi region event.
	 * 'Date 			: 09-Nov-2014 
	 * 'Author 			: Anitha
	 * '------------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                                         Modified By 
	 * 'Date                                                                             Name
	 ***************************************************************************************************/
	@Test(description ="Create a private Multi region event and verify that a user with 'Update status'"
			+ " right on the resource can view the event related status types of the resource participating"
			+ " in private Multi region event.")
	public void testHappyDay134398() throws Exception {

		gstrTCID = "134398";
		gstrTO ="Create a private Multi region event and verify that a user with 'Update status'"
				+ " right on the resource can view the event related status types of the resource participating"
				+ " in private Multi region event.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		Roles objRoles = new Roles(this.driver1);

		Login objLogin = new Login(this.driver1);
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
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[4];
		String strStatusTypeValuesInReg2[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[1];
		String strRoleValueInReg2[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status Types in Region1
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		String strAllStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		// Create Resource Type in Region1
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region1
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

		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region1	
		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllPagerOption().deselectSelectAllEmailOption()
				.deselectSelectAllWebOption();			

		System.out.println(objESetUp_data.strEventTemplate);

		// Create role
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println("1u " + objUser_data.strNewUserName);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status types in Region2
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti2)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti3)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();
		
		String strAllStatusTypeNames1[] = {
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1 };

		// Create Resource Type in Region2
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region2
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

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region2
		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate1,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValueInReg2, strStatusTypeValuesInReg2)
				.deselectSelectAllPagerOption().deselectSelectAllEmailOption()
				.deselectSelectAllWebOption();

		System.out.println(objESetUp_data.strEventTemplate1);

		// Create role in Region2
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValueInReg2[0] = objRoles
				.getRoleValue(objRoles_data.strRoleName);

		// Provide rights for users to Region2
		objUsersList
				.navigateToUsersNew()
				.searchUserName(objUser_data.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectRoleCheckBox(strRoleValueInReg2)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton()
				.clickSaveButton();
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.clickPrivateCheckBox()
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1).clickOnNextButton()
				.clickOnYesButton();

		System.out.println("Multi Region Event"
				+ objEvent_data.strMultiRegionEvent);
		
		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strAllStatusTypeNames);

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName1,
				objResource_data.strResourceName1);

		for (int i = 0; i < strAllStatusTypeNames1.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName1,
					strAllStatusTypeNames1[i]);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName1)
				.verResourceNameInPopupWindow(objResource_data.strResourceName1)
				.verStatusTypesInPopupWindow(strAllStatusTypeNames1);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************
	 * 'Description 	: Create a private Multi region event and verify that a user with 'Run Report' 
	 *                    right on the resource can view the event related status types of the resource
	 *                     participating in private Multi region event.
	 * 'Date 			: 09-Nov-2014 
	 * 'Author 			: Anitha
	 * '------------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                                         Modified By 
	 * 'Date                                                                             Name
	 ***************************************************************************************************/
	@Test(description ="Create a private Multi region event and verify that a user with 'Run Report' right on"
			+ " the resource can view the event related status types of the resource participating "
			+ "in private Multi region event.")
	public void testHappyDay134399() throws Exception {

		gstrTCID = "134399";
		gstrTO ="Create a private Multi region event and verify that a user with 'Run Report' right on the resource "
				+ "can view the event related status types of the resource participating in private Multi region event.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		Roles objRoles = new Roles(this.driver1);

		Login objLogin = new Login(this.driver1);
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
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[4];
		String strStatusTypeValuesInReg2[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[1];
		String strRoleValueInReg2[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status Types in Region1
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		String strAllStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		// Create Resource Type in Region1
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region1
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

		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region1	
		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllPagerOption().deselectSelectAllEmailOption()
				.deselectSelectAllWebOption();			

		System.out.println(objESetUp_data.strEventTemplate);

		// Create role
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println("1u " + objUser_data.strNewUserName);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status types in Region2
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti3)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();
		
		String strAllStatusTypeNames1[] = {
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1 };

		// Create Resource Type in Region2
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region2
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

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region2
		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate1,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValueInReg2, strStatusTypeValuesInReg2)
				.deselectSelectAllPagerOption().deselectSelectAllEmailOption()
				.deselectSelectAllWebOption();

		System.out.println(objESetUp_data.strEventTemplate1);

		// Create role in Region2
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValueInReg2[0] = objRoles
				.getRoleValue(objRoles_data.strRoleName);

		// Provide rights for users to Region2
		objUsersList
				.navigateToUsersNew()
				.searchUserName(objUser_data.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectRoleCheckBox(strRoleValueInReg2)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectRunReportsCheckBox(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton()
				.clickSaveButton();
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.clickPrivateCheckBox()
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1).clickOnNextButton()
				.clickOnYesButton();

		System.out.println("Multi Region Event"
				+ objEvent_data.strMultiRegionEvent);
		
		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strAllStatusTypeNames);

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName1,
				objResource_data.strResourceName1);

		for (int i = 0; i < strAllStatusTypeNames1.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName1,
					strAllStatusTypeNames1[i]);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName1)
				.verResourceNameInPopupWindow(objResource_data.strResourceName1)
				.verStatusTypesInPopupWindow(strAllStatusTypeNames1);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*****************************************************************************************************
	 * 'Description 	:Create a private Multi region event and verify that a user with 'Override viewing
	 *                   restrictions'right can view the event related status types of the resource
	 *                   participating in private Multi region event.
	 * 'Date 			: 09-Nov-2014 
	 * 'Author 			: Anitha
	 * '--------------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                                         Modified By 
	 * 'Date                                                                             Name
	 *****************************************************************************************************/
	@Test(description =" Create a private Multi region event and verify that a user with 'Override viewing restrictions'"
			+ "right can view the event related status types of the resource participating in private Multi region event.")
	public void testHappyDay134402() throws Exception {

		gstrTCID = "134402";
		gstrTO =" Create a private Multi region event and verify that a user with 'Override viewing restrictions'right"
				+ " can view the event related status types of the resource participating in private Multi region event.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		Roles objRoles = new Roles(this.driver1);

		Login objLogin = new Login(this.driver1);
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
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[4];
		String strStatusTypeValuesInReg2[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[1];
		String strRoleValueInReg2[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status Types in Region1
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		String strAllStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		// Create Resource Type in Region1
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region1
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

		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region1	
		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllPagerOption().deselectSelectAllEmailOption()
				.deselectSelectAllWebOption();			

		System.out.println(objESetUp_data.strEventTemplate);

		// Create role
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectOverrideViewingRestrictionOption()
				.clickSaveButton()
				
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println("1u " + objUser_data.strNewUserName);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status types in Region2
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,	objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti2)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti3)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();
		
		String strAllStatusTypeNames1[] = {
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1 };

		// Create Resource Type in Region2
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region2
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

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region2
		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate1,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValueInReg2, strStatusTypeValuesInReg2)
				.deselectSelectAllPagerOption().deselectSelectAllEmailOption()
				.deselectSelectAllWebOption();

		System.out.println(objESetUp_data.strEventTemplate1);

		// Create role in Region2
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValueInReg2[0] = objRoles
				.getRoleValue(objRoles_data.strRoleName);

		// Provide rights for users to Region2
		objUsersList
				.navigateToUsersNew()
				.searchUserName(objUser_data.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectRoleCheckBox(strRoleValueInReg2)
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectOverrideViewingRestrictionOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton()
				.clickSaveButton();
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.clickPrivateCheckBox()
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1).clickOnNextButton()
				.clickOnYesButton();

		System.out.println("Multi Region Event"
				+ objEvent_data.strMultiRegionEvent);
		
		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strAllStatusTypeNames);

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName1,
				objResource_data.strResourceName1);

		for (int i = 0; i < strAllStatusTypeNames1.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName1,
					strAllStatusTypeNames1[i]);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName1)
				.verResourceNameInPopupWindow(objResource_data.strResourceName1)
				.verStatusTypesInPopupWindow(strAllStatusTypeNames1);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/***************************************************************************************************
	 * 'Description 	:Create a private Multi region event and verify that a user with 'Associate with'
	 *                   right on the resource cannot view the event related status types of the resource
	 *                   participating in private Multi region event.
	 * 'Date 			: 09-Nov-2014 
	 * 'Author 			: Anil
	 * '------------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                                         Modified By 
	 * 'Date                                                                             Name
	 ***************************************************************************************************/
	@Test(description =" Create a private Multi region event and verify that a user with 'Associate with'"
			+ " right on the resource cannot view the event related status types of the resource "
			+ "participating in private Multi region event.")
	public void testHappyDay134400() throws Exception {

		gstrTCID = "134400";
		gstrTO =" Create a private Multi region event and verify that a user with 'Associate with' right on the "
				+ "resource cannot view the event related status types of the resource participating "
				+ "in private Multi region event.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		Roles objRoles = new Roles(this.driver1);

		Login objLogin = new Login(this.driver1);
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
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[4];
		String strStatusTypeValuesInReg2[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[1];
		String strRoleValueInReg2[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status Types in Region1
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		String strAllStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		// Create Resource Type in Region1
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region1
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

		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region1	
		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllPagerOption().deselectSelectAllEmailOption()
				.deselectSelectAllWebOption();			

		System.out.println(objESetUp_data.strEventTemplate);

		// Create role
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println("1u " + objUser_data.strNewUserName);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status types in Region2
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti3)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();
		
		String strAllStatusTypeNames1[] = {
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1 };

		// Create Resource Type in Region2
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region2
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

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region2
		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate1,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValueInReg2, strStatusTypeValuesInReg2)
				.deselectSelectAllPagerOption().deselectSelectAllEmailOption()
				.deselectSelectAllWebOption();

		System.out.println(objESetUp_data.strEventTemplate1);

		// Create role in Region2
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValueInReg2[0] = objRoles
				.getRoleValue(objRoles_data.strRoleName);

		// Provide rights for users to Region2
		objUsersList
				.navigateToUsersNew()
				.searchUserName(objUser_data.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectRoleCheckBox(strRoleValueInReg2)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.selectAssosciateResourceRight(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton()
				.clickSaveButton();
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.clickPrivateCheckBox()
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1).clickOnNextButton()
				.clickOnYesButton();

		System.out.println("Multi Region Event"
				+ objEvent_data.strMultiRegionEvent);
		
		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypeNotPresent(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}
		
		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesNotInPopupWindow(strAllStatusTypeNames);

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		for (int i = 0; i < strAllStatusTypeNames1.length; i++) {

			objEventStatus1.verStatusTypeNotPresent(
					objResourceType_data.strResourceTypeName1,
					strAllStatusTypeNames1[i]);
		}
		
		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName1)
				.verStatusTypesNotInPopupWindow(strAllStatusTypeNames1);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************
	 * 'Description 	:Create a private Multi region event and verify that a user with 'View Resource' 
	 *                   right on the resource cannot view the event related status types of the resource 
	 *                   participating in private Multi region event.
	 * 'Date 			: 09-Nov-2014 
	 * 'Author 			: Anitha
	 * '------------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                                         Modified By 
	 * 'Date                                                                             Name
	 ***************************************************************************************************/
	@Test(description ="Create a private Multi region event and verify that a user with 'View Resource' "
			+ "right on the resource cannot view the event related status types of the resource participating"
			+ " in private Multi region event.")
	public void testHappyDay134401() throws Exception {

		gstrTCID = "134401";
		gstrTO ="Create a private Multi region event and verify that a user with 'View Resource' right on the "
				+ "resource cannot view the event related status types of the resource participating in "
				+ "private Multi region event.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		Roles objRoles = new Roles(this.driver1);

		Login objLogin = new Login(this.driver1);
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
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[4];
		String strStatusTypeValuesInReg2[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[1];
		String strRoleValueInReg2[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status Types in Region1
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		String strAllStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		// Create Resource Type in Region1
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region1
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

		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region1	
		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllPagerOption().deselectSelectAllEmailOption()
				.deselectSelectAllWebOption();			

		System.out.println(objESetUp_data.strEventTemplate);

		// Create role
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println("1u " + objUser_data.strNewUserName);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status types in Region2
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor)
						
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti3)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithEvent(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();
		
		String strAllStatusTypeNames1[] = {
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1 };

		// Create Resource Type in Region2
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region2
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

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objEventSetUp.navigateToEventSetUp();

		// Create Event Template in Region2
		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate1,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValueInReg2, strStatusTypeValuesInReg2)
				.deselectSelectAllPagerOption().deselectSelectAllEmailOption()
				.deselectSelectAllWebOption();

		System.out.println(objESetUp_data.strEventTemplate1);

		// Create role in Region2
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValueInReg2[0] = objRoles
				.getRoleValue(objRoles_data.strRoleName);

		// Provide rights for users to Region2
		objUsersList
				.navigateToUsersNew()
				.searchUserName(objUser_data.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectRoleCheckBox(strRoleValueInReg2)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton()
				.clickSaveButton();
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.clickPrivateCheckBox()
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1).clickOnNextButton()
				.clickOnYesButton();

		System.out.println("Multi Region Event"
				+ objEvent_data.strMultiRegionEvent);
		
		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypeNotPresent(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}
		
		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesNotInPopupWindow(strAllStatusTypeNames);

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent);

		for (int i = 0; i < strAllStatusTypeNames1.length; i++) {

			objEventStatus1.verStatusTypeNotPresent(
					objResourceType_data.strResourceTypeName1,
					strAllStatusTypeNames1[i]);
		}
		
		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName1)
				.verStatusTypesNotInPopupWindow(strAllStatusTypeNames1);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************
	 * 'Description 	: Verify that user can NOT view the event related status types associated with a private event 
	 * 						of region RG1 from RG2 when there exists mutual agreement between the regions irrespective of the 
	 * 						resource viewing right in RG2.
	 * 'Date 			: 13-Jan-2016 
	 * 'Author 			: Renushree
	 * '------------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                                         Modified By 
	 * 'Date                                                                             Name
	 ***************************************************************************************************/
	@Test(description = " Verify that user can NOT view the event related status types associated with a private "
			+ "event of region RG1 from RG2 when there exists mutual agreement between the regions irrespective "
			+ "of the resource viewing right in RG2.")
	public void testHappyDay134438() throws Exception {

		gstrTCID = "134438";
		gstrTO = " Verify that user can NOT view the event related status types associated with a private "
				+ "event of region RG1 from RG2 when there exists mutual agreement between the regions "
				+ "irrespective of the resource viewing right in RG2.";

		Login_data objLogindata = new Login_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
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
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strEveStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strSetracReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strSetracReg);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strArkansasReg);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Status Types in Region1
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
					objStatusTypes_data.strStatusColor)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strEveStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
					objStatusTypes_data.strStatusColor)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti2)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti3)
				.clickOnReturnToStatusTypeList();

		strEveStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strEveStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strEveStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.streNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strEveStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNDSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strEveStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName);

		String[] strAllSTValues = ArrayUtils.addAll(strStatusTypeValues,
				strEveStatusTypeValues);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		// Create Resource Type in Region1
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strAllSTValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Create Resource in Region1
		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strAllSTValues);

		System.out.println("ET=" + objESetUp_data.strEventTemplate);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickPrivateCheckBox().selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strArkansasReg);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectOverrideViewingRestrictionOption()
				.selectViewOtherRegView(objLogindata.strSetracRegVal)
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToRegUnderOtherRegions(objLogindata.strSetracReg);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verifyErrorMessageDisplayed();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
