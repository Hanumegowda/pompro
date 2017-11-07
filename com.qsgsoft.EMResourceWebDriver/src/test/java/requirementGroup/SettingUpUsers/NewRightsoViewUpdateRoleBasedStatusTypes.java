package requirementGroup.SettingUpUsers;

import static org.testng.AssertJUnit.assertTrue;
import lib.dataObject.EventSetUp_data;
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
import lib.page.Views;
import lib.page.ViewsList;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewRightsoViewUpdateRoleBasedStatusTypes extends TestNG_UI_EXTENSIONS{

	public NewRightsoViewUpdateRoleBasedStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/**************************************************************************************************
	'Description : User A has role R1 where R1 has the view right for status type ST1 and view & update   
	               right for status type ST2. Role R2 has only view right for status type ST2 and not 
	               for ST1. Verify that when user A's role is changed from R1 to R2, user A:
					1. Can only add status change preferences for ST2 and not for ST1
					2. Can edit status change preferences for ST2 and not for ST1
	'Date	 	 : 13-July-2015
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = "User A has role R1 where R1 has the view right for status type ST1 and view & update "
			+ "right for status type ST2. Role R2 has only view right for status type ST2 and not for ST1. Verify"
			+ " that when user A's role is changed from R1 to R2, user A:"+
				"1. Can only add status change preferences for ST2 and not for ST1"+
				"2. Can edit status change preferences for ST2 and not for ST1.")
	public void testHappyDay46284() throws Exception {

		gstrTCID = "46284";
		gstrTO = "User A has role R1 where R1 has the view right for status type ST1 and view & update "
			+ "right for status type ST2. Role R2 has only view right for status type ST2 and not for ST1. Verify"
			+ " that when user A's role is changed from R1 to R2, user A:"+
				"1. Can only add status change preferences for ST2 and not for ST1"+
				"2. Can edit status change preferences for ST2 and not for ST1.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		NotificationValues objNotificationValues = new NotificationValues();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		
		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
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
		
		String[] strstatusTypeValues1={strStatusTypeValues[0]};
		String[] strstatusTypeValues2={strStatusTypeValues[1]};

		objNavigationToSubMenus.navigateToRoles();
	
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues1)
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues2)
				.clickStatusTypeInRoleMayUpdateSection(strstatusTypeValues2)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues2)
				.clickOnSaveBtn();

		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);
		
		System.out.println(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName1);
		
		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateStatusChangeInPreferences();

		objStatusChangePreference
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.expandUncategorizedSec()
				
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[0])	
						
			    .selEmailPagerWebChkBoxes(strResourceValue[0],
						strStatusTypeValues[1])
				.clickOnSave();
		
		objLogin.clickLogOut();
		
	System.out.println("--------Precondition ends and test execution starts---------");
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToUsers();
		
		String[] strRoleValues1={strRoleValue[0]};
		String[] strRoleValues2={strRoleValue[1]};
		
		objUsersList1
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.deselectRoleCheckBox(strRoleValues1)
				.selectRoleCheckBox(strRoleValues2)
				.clickSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.verStatusTypeIsDispalyed(
						objStatuTypes_data.strTSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatuTypes_data.strNSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypeNotification(
						objStatuTypes_data.strTSTStatusTypeName)

				.clickOnEditInMyStatusChangePreferences(
						objResource_data.strResourceName)
				.expandUncategorizedSec()
				.verNotificationChkBoxSelectedForTST(strResourceValue[0],
						strStatusTypeValues[1])
				.verStatusTypesUnderUncategorizedSec(
						objStatuTypes_data.strTSTStatusTypeName)
				.verStatusTypesNotDisplayed(
						objStatuTypes_data.strNSTStatusTypeName)
				.clickOnCancelNew()

				.verStatusTypeIsDispalyed(
						objStatuTypes_data.strTSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatuTypes_data.strNSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypeNotification(
						objStatuTypes_data.strTSTStatusTypeName)

				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				
				.expandUncategorizedSec()
				.verNotificationChkBoxSelectedForTST(strResourceValue[0],
						strStatusTypeValues[1])
				.verStatusTypesUnderUncategorizedSec(
						objStatuTypes_data.strTSTStatusTypeName)
				.verStatusTypesNotDisplayed(
						objStatuTypes_data.strNSTStatusTypeName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/**************************************************************************************************
	'Description : Verify that when a user is provided both ‘View Resource’ and 'Update Status' right on 
	               resource RS and a role for only viewing the associated status type ST (regardless of
	                ST associated at the resource level/resource type level), then the user CAN only 
	                view but CANNOT update the status of ST.
	'Date	 	 : 13-July-2015
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = "Verify that when a user is provided both ‘View Resource’ and 'Update Status' right on "
			+ "resource RS and a role for only viewing the associated status type ST (regardless of ST associated"
		+ " at the resource level/resource type level), then the user CAN only view but CANNOT update the status of ST.")
	public void testHappyDay48631() throws Exception {

		gstrTCID = "48631";
		gstrTO = "Verify that when a user is provided both ‘View Resource’ and 'Update Status' right on resource RS"
				+ " and a role for only viewing the associated status type ST (regardless of ST associated at the "
				+ "resource level/resource type level), then the user CAN only view but CANNOT update the status of ST.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Roles_data objRolesData = new Roles_data();
		View_data objViewData = new View_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp ObjEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventManagement objEventManagementPage1 = new EventManagement(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName).clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		System.out.println(objRolesData.strRoleName);

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strNumberStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strNSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.deSelectRoleUnderRolesWithViewRight()
				.deSelectRoleUnderRolesWithUpdateRight()
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.clickOnSaveButton();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strTextStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strTSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.deSelectRoleUnderRolesWithViewRight()
				.deSelectRoleUnderRolesWithUpdateRight()
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.clickOnSaveButton();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		String[] strStatusTypeValues1 = { strStatusTypeValues[0] };
		String[] strStatusTypeValues2 = { strStatusTypeValues[1] };

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
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
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		objResource.verEditResourceLevelStatusTypesPageisDisplayed();

		objResource.selectStatusType(strStatusTypeValues2).clickOnSaveButton();

		// create view
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };

		objNavigationToSubMenus.navigateToViews();
		
		objViewsList.createView(objViewData.strViewName,
				objViewData.strViewDesc, objResource_data.strResourceName,
				strStatusTypeNames);

		/*objViewsList.clickCreateNewViewButton()
				.enterViewName(objViewData.strViewName)
				.enterViewDesc(objViewData.strViewDesc);

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViewsList.selectStatusType(strStatusTypeNames[i]);
		}

		objViewsList.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();
*/
		ObjEventSetUp.navigateToEventSetUp();

		ObjEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();
		
	System.out.println("--------Precondition ends and test execution starts---------");
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();
		
		objEventManagementPage1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
		.enterAdHocEventName(objEventdata.strEventName)
		.enterAdHocEventDescription(objEventdata.strEventDescription)
		.selectResource(strResourceValue).clickOnSaveButton();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objViewData.strViewName);

		objViewsList1
				.verifyStatusTypeNameInView(strResourceTypeValue[0],
						objStatuTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeNameInView(strResourceTypeValue[0],
						objStatuTypes_data.strTSTStatusTypeName)
				.clickOnKeyIcon().verUnauthorizedErrorMsg()
				.clickOnReturnToView();

		objEventManagementPage1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		objEventStatus1.verStatusTypes(
				objResourceType_data.strResourceTypeName,
				objStatuTypes_data.strTSTStatusTypeName).verStatusTypes(
						objResourceType_data.strResourceTypeName,
				objStatuTypes_data.strNSTStatusTypeName);

		objViewsList1.clickOnKeyIcon().verUnauthorizedErrorMsg()
				.clickOnReturnToView();

		objnNavigationToSubMenus1.navigateToMapPage();

		String[] strStatusTypeNames1 = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames1)
				.clickUpdateStatusInPopupWindow();

		objViewsList1.verUnauthorizedErrorMsg().clickOnReturnToView();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

	/****************************************************************************************************************
	'Description : User A has role R1 where R1 has the view right for status type ST1 and view & update right for status 
				   type ST2. Role R2 has only view right for status type ST2 and not for ST1. Verify that when user A's 
				   role is changed from R1 to R2, the changes are reflected on following view screens:
					1. Region view
					2. Map
					3. Custom views
					4. Event detail
					5. View Resource detail
					6. Mobile view
	'Precondition:
	'Date	 	 : 14-Jul-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "User A has role R1 where R1 has the view right for status type ST1 and view & update right for status "
			+ "type ST2. Role R2 has only view right for status type ST2 and not for ST1. Verify that when user A's role is "
			+ "changed from R1 to R2, the changes are reflected on following view screens:"
		    + "1. Region view"
			+ "2. Map"
			+ "3. Custom views"
			+ "4. Event detail"
			+ "5. View Resource detail"
			+ "6. Mobile view")
	public void testHappDay49535() throws Exception {

		gstrTCID = "49535";
		gstrTO = "User A has role R1 where R1 has the view right for status type ST1 and view & update right for status "
			+ "type ST2. Role R2 has only view right for status type ST2 and not for ST1. Verify that when user A's role is "
			+ "changed from R1 to R2, the changes are reflected on following view screens:"
		    + "1. Region view"
			+ "2. Map"
			+ "3. Custom views"
			+ "4. Event detail"
			+ "5. View Resource detail"
			+ "6. Mobile view";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		Views objViews1 = new Views(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		
		String strstatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
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
		
		objNavigationToSubMenus.navigateToViews();

		String[] strSTNames = {objStatusTypes_data.strNSTStatusTypeName,objStatusTypes_data.strTSTStatusTypeName};
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strSTNames);
		
		/*objViewsList.clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc)
				.selectStatusType(objStatusTypes_data.strNSTStatusTypeName)
				.selectStatusType(objStatusTypes_data.strTSTStatusTypeName)
				.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();
		*/
		String[] strstatusTypeValues1={strstatusTypeValues[0]};
		String[] strstatusTypeValues2={strstatusTypeValues[1]};
		
		String[] strStatusTypeNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};
		
		objNavigationToSubMenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues1)
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues2)
				.clickStatusTypeInRoleMayUpdateSection(strstatusTypeValues2)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues2)
				.clickOnSaveBtn();

		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);
		
		System.out.println(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName1);
		
		objEventSetUp.navigateToEventSetUp();
		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues[0])
				.selectStatusType(strstatusTypeValues[1])
				.clickSaveButton()
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllWebOption()
				.verEveTemplateListScreenIsDisplayed();
		
		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectViewcustomViewOption()
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
	
		System.out.println(objView_data.strViewName);
		
		objLogin.clickLogOut()
				.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		objEventManagement.navigateToEventManagement()
		  .clickOnCreateNewEvent()
		  .clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		  .enterAdHocEventName(objEvent_data.strEventName)
		  .enterAdHocEventDescription(objEvent_data.strEventDescription)
		  .selectResource(strResourceValue[0])
		  .clickOnSaveButton()
		  .verifyEventName(objEvent_data.strEventName);
		
		System.out.println(objEvent_data.strEventName);
		
		objNavigationToSubMenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(
						objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue)
				.clickOnAddToCustomView()
				.clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strstatusTypeValues)
				.clickOnSave();

		objLogin.clickLogOut();
		
		System.out.println("-----Precondition ends-------");

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1
				.verifyStatusTypeNameInView(strResourceTypeValue[0],
						objStatuTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeNameInView(strResourceTypeValue[0],
						objStatuTypes_data.strTSTStatusTypeName);
		
		objViewsList1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
		
		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName)
					  .verifyStatusTypeUnderSectionsInResourceDetailPage(
						objStatuTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName);
		
		objEventManagement1
			.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verStatusTypes(
				objResourceType_data.strResourceTypeName,
				objStatuTypes_data.strTSTStatusTypeName).verStatusTypes(
						objResourceType_data.strResourceTypeName,
				objStatuTypes_data.strNSTStatusTypeName);
		
		objNavigationToSubMenus1.navigateToMapPage();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames);
		
		objNavigationToSubMenus1.navigateToCustomInView();
		
		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		for (int j = 0; j < strStatusTypeNames.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}
		
		objLogin1.clickLogOut()
				 .loginToApplication(objTest_data.strUserName,
							objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		String[] strFirstRoleValue = { strRoleValue[0] };
		
		objUsersList1
			.navigateToUsers()
			.searchUserName(objUser_data.strNewUserName,
							objUser_data.strRole, objUser_data.strResourceType,
							objUser_data.strUsername, objUser_data.strsearchOption)
			.editUserDetails(objUser_data.strNewUserName)
			.deSelectRoleCheckBox(strFirstRoleValue)
			.selectRoleCheckBox(strRoleValue[1])
			.clickSaveButton();
		
		objLogin1.clickLogOut()
			 	 .loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1
				.verifyStatusTypeNameInView(strResourceTypeValue[0],
						objStatuTypes_data.strTSTStatusTypeName)
				.verifyStatusTypeNameIsNotInUserView(strResourceTypeValue[0],
						objStatuTypes_data.strNSTStatusTypeName);
		
		objViewsList1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
		
		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
						objStatuTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName)
					  .verifyStatusTypeNameIsNotInView(
							  objStatuTypes_data.strNSTStatusTypeName);
		
		objEventManagement1
			.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verStatusTypes(objResourceType_data.strResourceTypeName,
								objStatuTypes_data.strTSTStatusTypeName)
					   .verStatusTypeNotPresent(objResourceType_data.strResourceTypeName,
								objStatuTypes_data.strNSTStatusTypeName);
		
		objNavigationToSubMenus1.navigateToMapPage();

		String[] strStatusTypeNames2 = { objStatuTypes_data.strTSTStatusTypeName };
		String[] strStatusTypeNames3 = { objStatuTypes_data.strNSTStatusTypeName };

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames2)
				.verStatusTypesNotInPopupWindow(strStatusTypeNames3);
		
		objNavigationToSubMenus1.navigateToCustomInView();
		
		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		for (int j = 0; j < strStatusTypeNames2.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames2[j]);
		}
		
		objCustomUnderView1.verStatusTypeNotInCustomViewTablePage(
				objStatuTypes_data.strNSTStatusTypeName);
		
		gstrResult = "PASS";
	}

	/****************************************************************************************************************
	'Description : User A has role R1 where R1 has the view right for status type ST1 and view & update right for status
	 				type ST2. Verify that when adding/editing status change preferences for user A from another user B, 
	 				only ST1 and ST2 are displayed and no other status types are displayed.
	'Precondition:
	'Date	 	 : 14-Jul-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "User A has role R1 where R1 has the view right for status type ST1 and view & update right for "
			+ "status type ST2. Verify that when adding/editing status change preferences for user A from another user B, "
			+ "only ST1 and ST2 are displayed and no other status types are displayed.")
	public void testHappDay49204() throws Exception {

		gstrTCID = "49204";
		gstrTO = "User A has role R1 where R1 has the view right for status type ST1 and view & update right for "
				+ "status type ST2. Verify that when adding/editing status change preferences for user A from another user B, "
				+ "only ST1 and ST2 are displayed and no other status types are displayed.";
		
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		
		String strstatusTypeValues[] = new String[3];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
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
		
		String[] strstatusTypeValues1={strstatusTypeValues[0]};
		String[] strstatusTypeValues2={strstatusTypeValues[1]};
		String[] strstatusTypeValues3={strstatusTypeValues[2]};
		
		String[] strStatusTypeNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};
		
		objNavigationToSubMenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues1)
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues2)
				.clickStatusTypeInRoleMayUpdateSection(strstatusTypeValues2)
				.clickOnSaveBtn();
		
		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues1)
				.clickStatusTypeInRoleMayUpdateSection(strstatusTypeValues1)
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues2)
				.clickStatusTypeInRoleMayUpdateSection(strstatusTypeValues2)
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues3)
				.clickStatusTypeInRoleMayUpdateSection(strstatusTypeValues3)
				.clickOnSaveBtn();
		
		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);
		
		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectRoleCheckBox(strRoleValue[1])
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectEditStatusChangeNotPrefernceOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
		System.out.println(objUser_data.strNewUserName1);
		System.out.println(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName1);

		objLogin.clickLogOut();
		
		System.out.println("---------Precondition ends---------");
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
						objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objUsersList1.navigateToUsers()
					 .searchUserName(objUser_data.strNewUserName,
							objUser_data.strRole, objUser_data.strResourceType,
							objUser_data.strUsername, objUser_data.strsearchOption)
					 .editUserDetails(objUser_data.strNewUserName)
					 .clickStatusChangeNotificationPreferencesIsDisplayed();
		
		objStatusChangePreference1
				.verStatusChangePreferencesforUserPage(
						objUser_data.strNewUserName)
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.verEditMyStatusChangePrefForUserPgeDisplayed(
						objUser_data.strNewUserName)
				.expandUncategorizedSec();
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objStatusChangePreference1
					.verStatusTypesUnderUncategorizedSec(strStatusTypeNames[i]);
		}
		
		objStatusChangePreference1.verStatusTypesNotDisplayed(
				objStatusTypes_data.strSSTStatusTypeName);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/**************************************************************************************************
	'Description : User A has role R1 where R1 has the view right for status type ST1 and view & update 
	               right for status type ST2. Role R2 has only view right for status type ST2 and not for
	                ST1. Verify that when user A's role is changed from R1 to R2, user A receives expired 
	                status notification for only status type ST2 and not ST1.
	'Date	 	 : 13-July-2015
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = "User A has role R1 where R1 has the view right for status type ST1 and view & update right"
			+ " for status type ST2. Role R2 has only view right for status type ST2 and not for ST1. Verify that"
			+ " when user A's role is changed from R1 to R2, user A receives expired status notification for only"
			+ " status type ST2 and not ST1.")
	public void testHappyDay49187() throws Exception {

		gstrTCID = "49187";
		gstrTO = "User A has role R1 where R1 has the view right for status type ST1 and view & update right "
				+ "for status type ST2. Role R2 has only view right for status type ST2 and not for ST1. Verify "
				+ "that when user A's role is changed from R1 to R2, user A receives expired status notification "
				+ "for only status type ST2 and not ST1.";

		//in last step mail Receive for two status types because it is designed changed and made it as as designed
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Roles_data objRolesData = new Roles_data();
		View_data objView_data = new View_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SystemNotifications objSystemNotifications_page = new SystemNotifications(
				this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithExpirationTime(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objStatuTypes_data.strStatusExpirationTime);
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithExpirationTime(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objStatuTypes_data.strStatusExpirationTime);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
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
		
		String[] strstatusTypeValues1={strStatusTypeValues[0]};
		String[] strstatusTypeValues2={strStatusTypeValues[1]};

		objNavigationToSubMenus.navigateToRoles();
	
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues1)
				.clickStatusTypeInRoleMayUpdateSection(strstatusTypeValues1)
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues2)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.deSelectAllCheckboxInRolesMayViewsec()
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues2)
				.clickStatusTypeInRoleMayUpdateSection(strstatusTypeValues2)
				.clickStatusTypeInRoleMayViewSection(strstatusTypeValues1)
				.clickOnSaveBtn();

		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);
		
		System.out.println(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName1);
		
		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName,
						"", "", "", "", "", objUser_data.strPrimaryMailId,
						objUser_data.strPrimaryMailId,
						objUser_data.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue[0])
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickOnsystemNotifyPreferences();

		objSystemNotifications_page.selectAndSaveExpiredStatusNotification();
		
		System.out.println(objUser_data.strNewUserName);
		
		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName1);

		objLogin.clickLogOut();
		
	System.out.println("--------Precondition ends and test execution starts---------");
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForTST).clickOnSaveButton();

		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");

		System.out.println(strApplicationTime);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objRegionDefault_page1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);
		
		objRegionDefault_page1.selectFrame();

		objUsersList1.navigateToUsers();

		String[] strRoleValues1 = { strRoleValue[0] };
		String[] strRoleValues2 = { strRoleValue[1] };

		objUsersList1
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.deselectRoleCheckBox(strRoleValues1)
				.selectRoleCheckBox(strRoleValues2)
				.clickSaveButton();

		// wait until expiration time
		Thread.sleep(360000);

		objLogin1.clickLogOut();

		String strSubject = "Expired Status Notification: "
				+ objResource_data.strResourceName;

		String strSubject1 = "Expired Status: "
				+ objResource_data.strResourceAbbrivation;

		String strMsgBody1 = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUser_data.strFullName,
						objTest_data.strRegionName,
						objStatuTypes_data.strTSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime);

		String strMsgBody2 = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						objStatuTypes_data.strTSTStatusTypeName,
						objResource_data.strResourceName, strApplicationTime);

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1);

		for (int intCount = 0; intCount < 1; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject1);

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
	
	/**************************************************************************************************
	'Description : User A has role R1 where R1 has the view right for status type ST1 and view & update 
					right for status type ST2. Role R2 has only view right for status type ST2 and not for ST1. Verify that when user A's role is 
					changed from R1 to R2, user A can only view status type ST2 and not ST1 while adding status types to the custom view.
	'Date	 	 : 14-July-2015
	'Author		 : Renushree
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = "User A has role R1 where R1 has the view right for status type ST1 and view & update "
			+ "right for status type ST2. Role R2 has only view right for status type ST2 and not for ST1. "
			+ "Verify that when user A's role is changed from R1 to R2, user A can only view status type ST2 and not ST1 "
			+ "while adding status types to the custom view.")
	public void testHappyDay92597() throws Exception {

		gstrTCID = "92597";
		gstrTO = "User A has role R1 where R1 has the view right for status type ST1 and view & update "
				+ "right for status type ST2. Role R2 has only view right for status type ST2 and not for ST1. "
				+ "Verify that when user A's role is changed from R1 to R2, user A can only view status type ST2 "
				+ "and not ST1 while adding status types to the custom view.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.deselectStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues1)
				.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues1)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.deselectStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.deSelStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues1)
				.deselectStatusTypeInRoleMayUpdateSection(strStatusTypeValues1)
				.clickOnSaveBtn();

		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);

		System.out.println(objRolesData.strRoleName1);

		String strAllSTValues[] = ArrayUtils.addAll(strStatusTypeValues,
				strStatusTypeValues1);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strAllSTValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
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
		objNavigationToSubMenus
				.navigateToUsers();
		
		objUsersList.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues)
				.selectStatusTypes(strStatusTypeValues1).clickOnSave();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName)
				.deselectRoleCheckBox(strRoleValue[0])
				.selectRoleCheckBox(strRoleValue[1]).clickSaveButton()
				.verUserInList(objUser_data.strNewUserName);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToCustomInView();

		String strStName[] = { objStatuTypes_data.strTSTStatusTypeName };

		objCustomUnderView1.verStatusTypeInCustomViewTablePage(strStName)
				.verStatusTypeNotInCustomViewTablePage(
						objStatuTypes_data.strNSTStatusTypeName);

		objnNavigationToSubMenus1.navigateToCustomizedViewInPrefrences();

		objCustomUnderView1.clickOnOptions()
				.verSTDisplayedAndCheckedInOptions(strStatusTypeValues1)
				.verSTNotDisplayedInOptions(strStatusTypeValues);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
