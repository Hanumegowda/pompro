package requirementGroup.SettingUpRoles;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.FormConfigeration_data;
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
import lib.page.FormConfiguration;
import lib.page.Login;
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
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewRightsToViewUpdateRoleBasedStatusTypes  extends TestNG_UI_EXTENSIONS{

	public NewRightsToViewUpdateRoleBasedStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*****************************************************************************************************************
	'Description 	:Create role R1 selecting a status type ST only under ‘select the Status Types this Role may view’ 
	                 section, associate ST with resource RS at resource TYPE level and verify that a user with role R1
	                 and ‘Update Status’ right on RS CAN only view ST but CANNOT update the status of ST from 
	                 following screens: a. Region view
									    b. Map (from resource pop up window)
									    c. Custom view
									    d. View Resource Detail
									    e. Event detail
	'Date		 	: 22-Jan-2016 
	'Author 		: Anitha
	'---------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	****************************************************************************************************************/
	@Test( description = "Create role R1 selecting a status type ST only under ‘select the Status Types this Role may view’"
			+ " section, associate ST with resource RS at resource TYPE level and verify that a user with role R1 and "
			+ "‘Update Status’ right on RS CAN only view ST but CANNOT update the status of ST from following screens:"+
						"a. Region view"+
						"b. Map (from resource pop up window)"+
						"c. Custom view"+
						"d. View Resource Detail"+
						"e. Event detail")
	public void testHappyDay46609() throws Exception {

		gstrTCID = "46609";
		gstrTO = "Create role R1 selecting a status type ST only under ‘select the Status Types this Role may "
				+ "view’ section, associate ST with resource RS at the resource level and verify that a user with role R1"
				+ " and ‘Update Status’ right on RS CAN only view ST but CANNOT update the status of ST from following screens:"+
							"a. Region view"+
							"b. Map (from resource pop up window)"+
							"c. Custom view"+
							"d. View Resource Detail"+
							"e. Event detail";

		Login_data objLogindata = new Login_data();
		Roles_data objRolesData = new Roles_data();
		View_data objViewData = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventSetUp ObjEventSetUp = new EventSetUp(this.driver1);
		CustomUnderView ObjCustomUnderView = new CustomUnderView(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Map objMap1 = new Map(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objViewData.strSectionName);
		
		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objStatusTypeList.navigateToStatusTypeListNew();
		
		// create status types
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectSectionName(objViewData.strSectionName)
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.selectRoleUnderRolesWithUpdateRight(strRoleValue[0])
				.clickOnSaveButton();

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
								objStatusTypes_data.strStatusColor)
						.verCreatedStatusInStatusListForMulti(
								objStatusTypes_data.strStatusNameInMulti)
						.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						      objStatusTypes_data.strStatusColor)
						.verCreatedStatusInStatusListForMulti(
						      objStatusTypes_data.strStatusNameInMulti1)
						.clickOnReturnToStatusTypeList();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption()
				.selectSetUpRolesRight()
				.selectConfigureRegionalUserAccessOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption().selectMaintainEventsOption()
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		ObjEventSetUp.navigateToEventSetUp();

		ObjEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)
				.deselectSelectAllWebOption();

		objNavigationToSubMenus.navigateToViews();

		// create view
		String[] strStatusTypeNames = { objStatusTypes_data.strMSTStatusTypeName};

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createView(objViewData.strViewName, objViewData.strViewDesc, 
				objResource_data.strResourceName, strStatusTypeNames);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objViewData.strViewName)
//				.enterViewDesc(objViewData.strViewDesc);
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objEventManagement.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
				.enterAdHocEventName(objEventdata.strEventName)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEventdata.strEventName);

		// Custom View
		Thread.sleep(3000);
		objNavigationToSubMenus.navigateToCustomInView();
		String[] strResource1Val = { strResourceValue[0] };
		ObjCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResource1Val)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strstatusTypeValues).clickOnSave();

		objLogin.clickLogOut();
		
		System.out.println("----Precondition ends and test execution starts-----");

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		// Create role
		objNavigationToSubMenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues)
				.clickOnSaveBtn();

		strRoleValue[1] = objRoles1.getRoleValue(objRolesData.strRoleName1);

		objUsersList1
				.navigateToUsersNew()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.deselectRoleCheckBox(strRoleValue[0])
				.selectRoleCheckBox(strRoleValue[1]).clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objViewData.strViewName);

		objViewsList1
				.verStatusTypeCannotUpdate(strResourceTypeValue[0],
						objStatusTypes_data.strMSTStatusTypeName,
						strResourceValue[0], strstatusTypeValues[0])
				.clickOnUpdateStatus(objResource_data.strResourceName)
				.verUnauthorizedErrorMsg();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objViewData.strViewName);

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strResourceName)
				.verSTCannotUpdateInResDetailPage(
						objStatusTypes_data.strMSTStatusTypeName,
						strResourceValue[0], strstatusTypeValues[0]);

		objNavigationToSubMenus1.navigateToViews().navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objViewsList1.verUnauthorizedErrorMsg();

		objNavigationToSubMenus1.navigateToCustomInView();

		objCustomUnderView1.verStatuaTypesCannotUpdate(
				objResource_data.strResourceName,
				objStatusTypes_data.strMSTStatusTypeName);

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objViewsList1.verUnauthorizedErrorMsg();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName)
				.verifyResourceInEventBanner(
						objResource_data.strResourceName)
				.clickOnUpdateStatusKey(
						objResource_data.strResourceName);

		objViewsList1.verUnauthorizedErrorMsg();
		
		gstrResult = "PASS";

	}

	/*****************************************************************************************************************
	'Description 	: Create role R1 selecting a status type ST only under ‘select the Status Types this Role may view’
	                  section, associate ST with resource RS at the resource level and verify that a user with role R1 
	                  and ‘Update Status’ right on RS CAN only view ST but CANNOT update the status of ST from 
	                  following screens:  a. Region view
										  b. Map (from resource pop up window)
										  c. Custom view
										  d. View Resource Detail
										  e. Event detail
	'Date		 	: 22-Jan-2016 
	'Author 		: Anitha
	'---------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	****************************************************************************************************************/
	@Test( description = " Create role R1 selecting a status type ST only under ‘select the Status Types this Role may "
			+ "view’ section, associate ST with resource RS at the resource level and verify that a user with role R1 "
			+ "and ‘Update Status’ right on RS CAN only view ST but CANNOT update the status of ST from following screens:"+
						"a. Region view"+
						"b. Map (from resource pop up window)"+
						"c. Custom view"+
						"d. View Resource Detail"+
						"e. Event detail")
	public void testHappyDay46625() throws Exception {

		gstrTCID = "46625";
		gstrTO = " Create role R1 selecting a status type ST only under ‘select the Status Types this Role may view’ "
				+ "section, associate ST with resource RS at the resource level and verify that a user with role R1"
				+ " and ‘Update Status’ right on RS CAN only view ST but CANNOT update the status of ST from following screens:"+
							"a. Region view"+
							"b. Map (from resource pop up window)"+
							"c. Custom view"+
							"d. View Resource Detail"+
							"e. Event detail";

		Login_data objLogindata = new Login_data();
		Roles_data objRolesData = new Roles_data();
		View_data objViewData = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventSetUp ObjEventSetUp = new EventSetUp(this.driver1);
		CustomUnderView ObjCustomUnderView = new CustomUnderView(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Map objMap1 = new Map(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[2];
		String strstatusTypeValues1[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objViewData.strSectionName);
		
		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		// create status types
		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectSectionName(objViewData.strSectionName)
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.selectRoleUnderRolesWithUpdateRight(strRoleValue[0])
				.clickOnSaveButton();

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
								objStatusTypes_data.strStatusColor)
						.verCreatedStatusInStatusListForMulti(
								objStatusTypes_data.strStatusNameInMulti)
						.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						      objStatusTypes_data.strStatusColor)
						.verCreatedStatusInStatusListForMulti(
						      objStatusTypes_data.strStatusNameInMulti1)
						.clickOnReturnToStatusTypeList();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues1);

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

		objResource.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName)
		.selectStatusType(strstatusTypeValues).clickOnSaveButton();
		
		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption()
				.selectSetUpRolesRight()
				.selectConfigureRegionalUserAccessOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption().selectMaintainEventsOption()
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		ObjEventSetUp.navigateToEventSetUp();

		ObjEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)
				.deselectSelectAllWebOption();

		objNavigationToSubMenus.navigateToViews();

		// create view
		String[] strStatusTypeNames = { objStatusTypes_data.strMSTStatusTypeName};

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createView(objViewData.strViewName, objViewData.strViewDesc,
				objResource_data.strResourceName, strStatusTypeNames);
//		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objViewData.strViewName)
//				.enterViewDesc(objViewData.strViewDesc);
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objEventManagement.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
				.enterAdHocEventName(objEventdata.strEventName)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEventdata.strEventName);

		// Custom View
		Thread.sleep(3000);
		objNavigationToSubMenus.navigateToCustomInView();
		String[] strResource1Val = { strResourceValue[0] };
		ObjCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResource1Val)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strstatusTypeValues).clickOnSave();

		objLogin.clickLogOut();
		
		System.out.println("----Precondition ends and test execution starts-----");

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		// Create role
		objNavigationToSubMenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues)
				.clickOnSaveBtn();

		strRoleValue[1] = objRoles1.getRoleValue(objRolesData.strRoleName1);

		objUsersList1
				.navigateToUsersNew()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.deselectRoleCheckBox(strRoleValue[0])
				.selectRoleCheckBox(strRoleValue[1]).clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objViewData.strViewName);

		objViewsList1
				.verStatusTypeCannotUpdate(strResourceTypeValue[0],
						objStatusTypes_data.strMSTStatusTypeName,
						strResourceValue[0], strstatusTypeValues[0])
				.clickOnUpdateStatus(objResource_data.strResourceName)
				.verUnauthorizedErrorMsg();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objViewData.strViewName);

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strResourceName)
				.verSTCannotUpdateInResDetailPage(
						objStatusTypes_data.strMSTStatusTypeName,
						strResourceValue[0], strstatusTypeValues[0]);

		objNavigationToSubMenus1.navigateToViews().navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objViewsList1.verUnauthorizedErrorMsg();

		objNavigationToSubMenus1.navigateToCustomInView();

		objCustomUnderView1.verStatuaTypesCannotUpdate(
				objResource_data.strResourceName,
				objStatusTypes_data.strMSTStatusTypeName);

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objViewsList1.verUnauthorizedErrorMsg();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		objViewsList1.verUnauthorizedErrorMsg();
		
		gstrResult = "PASS";

	}
	/*********************************************************************************************************************
	'Description : Create role R1 selecting a status type ST under ‘select the Status Types this Role may view’ section, where ST is associated with resource RS at the resource level and verify that user with role R1 and with only 'View resource' right on RS CAN view ST on following screens:
				a. Region view
				b. Map (status type dropdown and resource pop up window)
				c. View Resource Detail
				d. Custom view
				e. Event detail
				f. Mobile view
				g. Edit My Status Change preferences 
	'Date		 : 22-Jan-2016
	'Author		 : Anil
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = "Create role R1 selecting a status type ST under ‘select the Status Types this Role may view’ section, where ST is associated with resource RS at the resource level and verify that user with role R1 and with only 'View resource' right on RS CAN view ST on following screens:"+
				"a. Region view"+
				"b. Map (status type dropdown and resource pop up window)"+
				"c. View Resource Detail"+
				"d. Custom view"+
				"e. Event detail"+
				"f. Mobile view"+
				"g. Edit My Status Change preferences ")
	public void testHappyDay65609() throws Exception {

		gstrTCID = "65609";
		gstrTO = "Create role R1 selecting a status type ST under ‘select the Status Types this Role may view’ section, where ST is associated with resource RS at the resource level and verify that user with role R1 and with only 'View resource' right on RS CAN view ST on following screens:"+
				"a. Region view"+
				"b. Map (status type dropdown and resource pop up window)"+
				"c. View Resource Detail"+
				"d. Custom view"+
				"e. Event detail"+
				"f. Mobile view"+
				"g. Edit My Status Change preferences ";

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
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[2];
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

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.clickOnSaveButton();

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnSaveButton();

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

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

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strStatusTypeValues1).clickOnSaveButton();

		objViewsList.navigateToViewsList()
				.createView(objView_data.strViewName, objView_data.strViewDesc, 
						objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
//				.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues1)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
//System.out.println(objResource_data.strResourceName);
		
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
				.selectRoleCheckBox(strRoleValue[0])
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption()
				.selectEditStatusChangeNotPrefernceOption()
				.selectSetUpRolesRight()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues1).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objStatusTypes_data.strMSTStatusTypeName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement();
		objEventManagement1.creatEvent(objEventSetUpdata.strEventTemplate, objEventdata.strEventName, objEventdata.strEventDescription, strResourceValue[0]);
		objEventManagement1.verifyEventName(objEventdata.strEventName);
		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues)
				.selectStatusTypes(strStatusTypeValues1).clickOnSave();

		System.out.println(objView_data.strCustomView);

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues1)
				.deSelectAllCheckboxInRolesMayUpdatesec()
				.clickOnSaveBtn()
				.verifyCreatedRoleInRolesList(objRolesData.strRoleName1);

		strRoleValue[1] = objRoles1.getRoleValue(objRolesData.strRoleName1);

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton();
		objUsersList1.editUserDetails(objUserdata.strNewUserName)
				.deselectRoleCheckBox(strRoleValue[0])
				.selectRoleCheckBox(strRoleValue[1]).clickSaveButton()
				.verUserInList(objUserdata.strNewUserName);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0], objStatusTypes_data.strMSTStatusTypeName);

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strResourceName);

		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
				objStatusTypes_data.strMSTStatusTypeName,
				objView_data.strSectionName);
		String[] strStatusTypes= {objStatusTypes_data.strMSTStatusTypeName};
		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypes);

		objNavigationToSubmenus1.navigateToCustomInView();
	
		objCustomUnderView1.verStatusTypeInCustomViewTablePage(strStatusTypes);

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName);

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypes);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		objEventManagement1.verifyStatusTypesInEventBanner(strStatusTypes, objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.selectResource(strResourceValue[0])
				.clickOnNotifications();
		
		objStatusChangePreference1
					.verStatusTypesUnderUncategorizedSec(objStatusTypes_data.strMSTStatusTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description : Create role R1 selecting a status type ST under ‘select the Status Types this Role may view’ and ‘select the Status Types this Role may Update’ sections, "
					associate ST with resource RS at the resource TYPE level and verify that user with role R1 and with ‘Update Status’ right on RS CAN view and update the status of ST from following screens:"
						a. Region view "
						b. Map screen (from resource pop window) "
						c. Custom view"
						d. View Resource Detail "
						e. Event detail
	'Date		 : 22-Jan-2016
	'Author		 : Anil
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = "Create role R1 selecting a status type ST under ‘select the Status Types this Role may view’ and ‘select the Status Types this Role may Update’ sections, "
			+ "associate ST with resource RS at the resource TYPE level and verify that user with role R1 and with ‘Update Status’ right on RS CAN view and update the status of ST from following screens:"
			+ "a. Region view "
			+ "b. Map screen (from resource pop window) "
			+ "c. Custom view"
			+ "d. View Resource Detail "
			+ "e. Event detail")
	public void testHappyDay46596() throws Exception {

		gstrTCID = "46596";
		gstrTO = "Create role R1 selecting a status type ST only under ‘select the Status Types this Role may "
				+ "view’ section, associate ST with resource RS at the resource TYPE level and verify that a user with role R1"
				+ " and ‘Update Status’ right on RS CAN only view ST but CANNOT update the status of ST from following screens:"+
							"a. Region view"+
							"b. Map (from resource pop up window)"+
							"c. Custom view"+
							"d. View Resource Detail"+
							"e. Event detail";

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
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Roles objRoles1 = new Roles(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strRoleValue1[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.clickOnSaveButton();

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnSaveButton();

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

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

		objViewsList.navigateToViewsList();
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, 
				objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
//		.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

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
				.selectSetUpRolesRight()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

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

		objEventManagement1.navigateToEventManagement();
		
		objEventManagement1.creatEvent(objEventSetUpdata.strEventTemplate, objEventdata.strEventName, objEventdata.strEventDescription, strResourceValue[0]);
		
		objEventManagement1.verifyEventName(objEventdata.strEventName);
		
		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues)
				.clickOnSave();

		System.out.println(objView_data.strCustomView);

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickOnSaveBtn()
				.verifyCreatedRoleInRolesList(objRolesData.strRoleName1);

		strRoleValue1[0] = objRoles1.getRoleValue(objRolesData.strRoleName1);

		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1.enterUsernameInSearchInputField(objUserdata.strNewUserName)
		.clickSearchButton();
		
		objUsersList1.editUserDetails(objUserdata.strNewUserName)
				.deselectRoleCheckBox(strRoleValue[0])
				.selectRoleCheckBox(strRoleValue1[0]).clickSaveButton()
				.verUserInList(objUserdata.strNewUserName);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[1]).clickOnSaveButton();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti1);

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strResourceName)
				.clickOnIndividualUpdateStatus(strResourceValue[0],
						strStatusTypeValues[0]);

		objUpdateStatus1
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.enterComments(strStatusTypeValues[0], objView_data.strComment)
				.clickOnSaveButton();

		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
				objStatusTypes_data.strMSTStatusTypeName,
				objView_data.strSectionName).verifyUpdatedValueAndComments(
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strComment);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[1]).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verUpdateValuesInPopupWindow(
				objStatusTypes_data.strStatusNameInMulti1);

		objNavigationToSubmenus1.navigateToCustomInView();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0]).clickOnSaveButton();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti);

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[1]).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verUpdateValuesInPopupWindow(
				objStatusTypes_data.strStatusNameInMulti1);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0]).clickOnSaveButton();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description : Create role R1 selecting a status type ST under ‘select the Status Types this Role may view’ and ‘select the Status Types this Role may Update’ sections, "
					associate ST with resource RS at the resource level and verify that user with role R1 and with ‘Update Status’ right on RS CAN view and update the status of ST from following screens:"
						a. Region view "
						b. Map screen (from resource pop window) "
						c. Custom view"
						d. View Resource Detail "
						e. Event detail
	'Date		 : 22-Jan-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = "Create role R1 selecting a status type ST under ‘select the Status Types this Role may view’ and ‘select the Status Types this Role may Update’ sections, "
			+ "associate ST with resource RS at the resource level and verify that user with role R1 and with ‘Update Status’ right on RS CAN view and update the status of ST from following screens:"
			+ "a. Region view "
			+ "b. Map screen (from resource pop window) "
			+ "c. Custom view"
			+ "d. View Resource Detail "
			+ "e. Event detail")
	public void testHappyDay46623() throws Exception {

		gstrTCID = "46623";
		gstrTO = "Create role R1 selecting a status type ST under ‘select the Status Types this Role may view’ and ‘select the Status Types this Role may Update’ sections, "
				+ "associate ST with resource RS at the resource level and verify that user with role R1 and with ‘Update Status’ right on RS CAN view and update the status of ST from following screens:"
				+ "a. Region view "
				+ "b. Map screen (from resource pop window) "
				+ "c. Custom view"
				+ "d. View Resource Detail "
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
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Roles objRoles1 = new Roles(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[2];
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

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.clickOnSaveButton();

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnSaveButton();

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

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

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strStatusTypeValues1).clickOnSaveButton();

		objViewsList.navigateToViewsList()
					.createView(objView_data.strViewName, objView_data.strViewDesc,
							objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
//		.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues1)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

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
				.selectRoleCheckBox(strRoleValue[0])
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectSetUpRolesRight()
				.selectEditResourcesOnlyOption().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues1).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objStatusTypes_data.strMSTStatusTypeName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues)
				.selectStatusTypes(strStatusTypeValues1).clickOnSave();

		System.out.println(objView_data.strCustomView);

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues1)
				.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues1)
				.clickOnSaveBtn()
				.verifyCreatedRoleInRolesList(objRolesData.strRoleName1);

		strRoleValue[1] = objRoles1.getRoleValue(objRolesData.strRoleName1);

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.deselectRoleCheckBox(strRoleValue[0])
				.selectRoleCheckBox(strRoleValue[1]).clickSaveButton()
				.verUserInList(objUserdata.strNewUserName);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[1]).clickOnSaveButton();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues1[0],
				objStatusTypes_data.strStatusNameInMulti1);

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strResourceName)
				.clickOnIndividualUpdateStatus(strResourceValue[0],
						strStatusTypeValues1[0]);

		objUpdateStatus1
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[0])
				.enterComments(strStatusTypeValues1[0], objView_data.strComment)
				.clickOnSaveButton();

		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
				objStatusTypes_data.strMSTStatusTypeName,
				objView_data.strSectionName).verifyUpdatedValueAndComments(
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusNameInMulti,
				objView_data.strComment);

		objNavigationToSubmenus1.navigateToMap();

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
		
		objEventManagement1.navigateToEventManagement();

		objEventManagement1.creatEvent(objEventSetUpdata.strEventTemplate,
				objEventdata.strEventName, objEventdata.strEventDescription,
				strResourceValue[0]);

		objEventManagement1.verifyEventName(objEventdata.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.selectMSTUpdateValue(strStatusTypeValues1[0],
						strStatusesValues[0]).clickOnSaveButton();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues1[0],
				objStatusTypes_data.strStatusNameInMulti);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*********************************************************************************************************************
	'Description : Create role R1 selecting a status type ST under ‘select the Status Types this Role may view’ section,
	               where ST is associated with resource RS at resource TYPE level and verify that user with role R1 and 
	               without any rights on RS CAN view ST on following screens:"
						a. Region view "
						b. Map screen (from resource pop window) "
						c. Custom view"
						d. View Resource Detail "
						e. Event detail
	'Date		 : 22-Jan-2016
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = "Create role R1 selecting a status type ST under ‘select the Status Types this Role may view’ "
			+ "section, where ST is associated with resource RS at resource TYPE level and verify that user with"
			+ " role R1 and without any rights on RS CAN view ST on following screens:"
			+ "a. Region view "
			+ "b. Map screen (from resource pop window) "
			+ "c. Custom view"
			+ "d. View Resource Detail "
			+ "e. Event detail"
			+ "F. Edit My Status Change preferences")
	public void testHappyDay46578() throws Exception {

		gstrTCID = "46578";
		gstrTO = "Create role R1 selecting a status type ST under ‘select the Status Types this Role may view’ section,"
				+ " where ST is associated with resource RS at resource TYPE level and verify that user with role R1 and"
				+ " without any rights on RS CAN view ST on following screens:"+
							"a. Region view"+
							"b. Map (from resource pop up window)"+
							"c. Custom view"+
							"d. View Resource Detail"+
							"e. Event detail"+
							"F. Edit My Status Change preferences";

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
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strRoleValue1[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		// Create role
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// create status types
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectSectionName(objView_data.strSectionName)
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.selectRoleUnderRolesWithUpdateRight(strRoleValue[0])
				.clickOnSaveButton();
		
		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.clickOnSaveButton();

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
		      objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
		      objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

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

		objViewsList.navigateToViewsList()
					.createView(objView_data.strViewName, objView_data.strViewDesc,
							objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
//		.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption()
				.selectSetUpRolesRight()
				.selectEditStatusChangeNotPrefernceOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objEventManagement.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
				.enterAdHocEventName(objEventdata.strEventName)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEventdata.strEventName);

		// Custom View
		Thread.sleep(3000);		
		objNavigationToSubmenus.navigateToCustomInView();	
		String[] strResource1Val = { strResourceValue[0] };		
		objCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResource1Val)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		objLogin.clickLogOut();
		
		System.out.println("----Precondition ends and test execution starts-----");

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		// Create role
		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickOnSaveBtn()
				.verifyCreatedRoleInRolesList(objRolesData.strRoleName1);

		strRoleValue1[0] = objRoles1.getRoleValue(objRolesData.strRoleName1);

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1.enterUsernameInSearchInputField(
				objUserdata.strNewUserName).clickSearchButton();

		objUsersList1.editUserDetails(objUserdata.strNewUserName)
				.deselectRoleCheckBox(strRoleValue[0])
				.selectRoleCheckBox(strRoleValue1[0]).clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
				objStatusTypes_data.strMSTStatusTypeName);

		objViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
				objStatusTypes_data.strMSTStatusTypeName,
				objView_data.strSectionName);
		
		String[] strStatusTypes = { objStatusTypes_data.strMSTStatusTypeName };
		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verStatusTypesInPopupWindow(
				strStatusTypes);

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.verStatusTypeInCustomViewTablePage(strStatusTypes);

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verStatusTypesInPopupWindow(
				strStatusTypes);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		objEventManagement1.verifyStatusTypesInEventBanner(strStatusTypes,
				objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.selectResource(strResourceValue[0]).clickOnNotifications();

		objStatusChangePreference1
				.verStatusTypesUnderUncategorizedSec(objStatusTypes_data.strMSTStatusTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	
	/*********************************************************************************************************************
	'Description :  Create role R1 without selecting any status types under ‘select the Status Types this Role may view/Update’ sections and verify that user with only role R1 CANNOT view any status types from the following screens: 
				a. Region view
				b. Map (status type dropdown and resource pop up window)
				c. View Resource Detail
				d. Custom view
				e. Event detail
				f. Mobile view
				g. Edit My Status Change preferences 
	'Date		 : 22-Jan-2016
	'Author		 : Anil
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = " Create role R1 without selecting any status types under ‘select the Status Types this Role may view/Update’ sections "+
						"and verify that user with only role R1 CANNOT view any status types from the following screens: "+
				"c. View Resource Detail"+
				"d. Custom view"+
				"e. Event detail"+
				"f. Mobile view"+
				"g. Edit My Status Change preferences ")
	public void testHappyDay98542() throws Exception {

		gstrTCID = "98542";
		gstrTO = " Create role R1 without selecting any status types under ‘select the Status Types this Role may view/Update’ sections "+
				"and verify that user with only role R1 CANNOT view any status types from the following screens: "+
				"a. Region view"+
				"b. Map (status type dropdown and resource pop up window)"+
				"c. View Resource Detail"+
				"d. Custom view"+
				"e. Event detail"+
				"f. Mobile view"+
				"g. Edit My Status Change preferences ";

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
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[2];
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

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.clickOnSaveButton();

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnSaveButton();

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

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

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strStatusTypeValues1).clickOnSaveButton();

		objViewsList.navigateToViewsList()
		.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
//		.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues1)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
//System.out.println(objResource_data.strResourceName);
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
				.selectRoleCheckBox(strRoleValue[0])
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption()
				.selectEditStatusChangeNotPrefernceOption()
				.selectSetUpRolesRight()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues1).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objStatusTypes_data.strMSTStatusTypeName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement();
		objEventManagement1.creatEvent(objEventSetUpdata.strEventTemplate, objEventdata.strEventName, objEventdata.strEventDescription, strResourceValue[0]);
		objEventManagement1.verifyEventName(objEventdata.strEventName);
		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues)
				.selectStatusTypes(strStatusTypeValues1).clickOnSave();

		System.out.println(objView_data.strCustomView);

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickOnSaveBtn()
				.verifyCreatedRoleInRolesList(objRolesData.strRoleName1);

		strRoleValue[1] = objRoles1.getRoleValue(objRolesData.strRoleName1);

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton();
		objUsersList1.editUserDetails(objUserdata.strNewUserName)
				.deselectRoleCheckBox(strRoleValue[0])
				.selectRoleCheckBox(strRoleValue[1]).clickSaveButton()
				.verUserInList(objUserdata.strNewUserName);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String[] strStatusTypes= {objStatusTypes_data.strMSTStatusTypeName};
		
		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesNotInPopupWindow(strStatusTypes);
		
		objNavigationToSubmenus1.navigateToCustomInView();
	
		objCustomUnderView1.verStatusTypeNotInCustomViewTablePage(objStatusTypes_data.strMSTStatusTypeName);
		
		objLinksAtTopRightCorners1.clickOnShowMap();
		
//		objMap1.verResourceNotInFindResourceDropDown(objResource_data.strResourceName);
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesNotInPopupWindow(strStatusTypes);
		//Modified on 7-Apr-2016; RS will be present but ST will not be present
		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		objEventStatus1.verStatusTypeNotPresent(
				objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strMSTStatusTypeName);
		
		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.selectResource(strResourceValue[0])
				.clickOnNotifications();
		
		objStatusChangePreference1
					.verStatusTypesNotDisplayed(objStatusTypes_data.strMSTStatusTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	
	/*********************************************************************************************************************
	'Description : Create role R1 without selecting status type ST1(role-based), ST2(Shared) under ‘select the Status
	               Types this Role may view/Update’ sections & verify that ST1 & ST2 can be viewed by any user with 
	               role R1 in the following setup pages:
					a. Status Type List
					b. Create/Edit Resource Type
					c. Create/Edit Role
					d. Edit Resource Level Status Types
					e. Create New/Edit/Copy View
					f. Edit Resource Detail View Sections
					g. Create/Edit Event Temp
					e. Edit event
					f. While 
	'Date		 : 2-Feb-2016
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = "Create role R1 without selecting status type ST1(role-based), ST2(Shared) under ‘select the "
			+ "Status Types this Role may view/Update’ sections & verify that ST1 & ST2 can be viewed by any user "
			+ "with role R1 in the following setup pages:"+
					"a. Status Type List"+
					"b. Create/Edit Resource Type"+
					"c. Create/Edit Role"+
					"d. Edit Resource Level Status Types"+
					"e. Create New/Edit/Copy View"+
					"f. Edit Resource Detail View Sections"+
					"g. Create/Edit Event Temp"+
					"e. Edit event"+
					"f. While")
	public void testHappyDay46509() throws Exception {

		gstrTCID = "46509";
		gstrTO = "Create role R1 without selecting status type ST1(role-based), ST2(Shared) under ‘select the "
				+ "Status Types this Role may view/Update’ sections & verify that ST1 & ST2 can be viewed by any user "
				+ "with role R1 in the following setup pages:"+
						"a. Status Type List"+
						"b. Create/Edit Resource Type"+
						"c. Create/Edit Role"+
						"d. Edit Resource Level Status Types"+
						"e. Create New/Edit/Copy View"+
						"f. Edit Resource Detail View Sections"+
						"g. Create/Edit Event Temp"+
						"e. Edit event"+
						"f. While";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// create status types
		objStatusTypeList.createStatusType(objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createSharedStatusType(
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
		String strStatusTypeNames[] = {objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strTSTStatusTypeName};
		
		objViewsList.navigateToViewsList()
					.createView(objView_data.strViewName, objView_data.strViewDesc, 
								objResource_data.strResourceName, strStatusTypeNames);
		
//		.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();
		
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.selectSetUpRolesRight()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objEventManagement.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
				.enterAdHocEventName(objEventdata.strEventName)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton();
		
		objLogin.clickLogOut();
		
		System.out.println("----Precondition ends and test execution starts-----");

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		// Create role
		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1.enterUsernameInSearchInputField(
				objUserdata.strNewUserName).clickSearchButton();

		objUsersList1.editUserDetails(objUserdata.strNewUserName)
				.selectRoleCheckBox(strRoleValue[0]).clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		//Resource Type page
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();
		
		objResourceType1
				.clickOnCreateNewResourceTypeButton()
				.verifyStatusTypeIsListed(strStatusTypeValues);
		
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();
		
		objResourceType1.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.verifyStatusTypeIsListed(strStatusTypeValues);
		
		//Roles page
		objNavigationToSubmenus1.navigateToRoles();
		
		objRoles1
				.clickOnEditLinkOfRole(objRolesData.strRoleName)
				.verifyStatusTypeNameWithUpdateAndViewRightChkBox(
						objStatusTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeNameWithUpdateAndViewRightChkBox(
						objStatusTypes_data.strTSTStatusTypeName);
		//Resource page
		objNavigationToSubmenus1.navigateToResourceInSetup();
		
		objResource1
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.verifyStatusTypeIsDisplayedUnderEditResLevelST(
						objStatusTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeIsDisplayedUnderEditResLevelST(
						objStatusTypes_data.strTSTStatusTypeName);
		//Views page
		objViewsList1.navigateToViewsList()
					 .clickCreateNewViewButton().clickNextButton()
					 .selectRegionName(objLogindata.strRegionName)
					 .clickNextButton()
					 .selectResource(objResource_data.strResourceName)
					 .clickOnSTTab()
					 .verifyStatusTypeInViewsPageIsDisplayed(objStatusTypes_data.strNSTStatusTypeName)
					 .verifyStatusTypeInViewsPageIsDisplayed(objStatusTypes_data.strTSTStatusTypeName)
					 
//				.verifyStatusTypesViewsPage(strStatusTypeValues)
//				.clickOnCancelButton()
//				.clickOnEditLinkOfView(objView_data.strViewName)
//				.verifyStatusTypesViewsPage(strStatusTypeValues)
//				.clickOnCancelButton()
//				.clickOnCopyLinkOfView(objView_data.strViewName)
//				.verifyStatusTypesViewsPage(strStatusTypeValues)
				.clickOnCancelButton()
				.clickOncustomizeResourceDetailView()
				.clickOnUncategorized()
				.verStatusTypesInList(objStatusTypes_data.strNSTStatusTypeName,
						strStatusTypeValues[0])
				.verStatusTypesInList(objStatusTypes_data.strTSTStatusTypeName,
						strStatusTypeValues[1]);
		
		//Event template page
		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1
				.clickOncreateEventTemplate()
				.verifyStatusTypeIsDispInCreateNewEventTemp(
						objStatusTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeIsDispInCreateNewEventTemp(
						objStatusTypes_data.strTSTStatusTypeName);
		
		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1
				.clickOnEditTempLink(objEventSetUpdata.strEventTemplate)
				.verifyStatusTypeIsDispInCreateNewEventTemp(
						objStatusTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeIsDispInCreateNewEventTemp(
						objStatusTypes_data.strTSTStatusTypeName);
		
		//Events page
		objEventManagement1.navigateToEventManagementNew()
				.clickOnEditLink(objEventdata.strEventName)
				.verifyStatusTypesInEditEvePage(strStatusTypeValues);
		
		//Forms page
		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strAsCertainStatusChanges)
				.clickOnNextButton()
				.verStatusTypeIsDisplyedInFormActivationPage(
						strStatusTypeValues[0])
				.verStatusTypeIsDisplyedInFormActivationPage(
						strStatusTypeValues[0]);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
