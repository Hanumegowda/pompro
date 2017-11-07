package requirementGroup.SettingUpResources;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.FindResources;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewUserAssignmentForViewingTheResourceAndStatusTypes extends TestNG_UI_EXTENSIONS{

	public NewUserAssignmentForViewingTheResourceAndStatusTypes()
			throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/**********************************************************************************************
	'Description : Verify that when the 'View Resource' right on a resource is removed for a user,
	               the user cannot add the resource to his/her custom view.
	'Date	 	 : 01-July-2015
	'Author		 : Anitha
	'----------------------------------------------------------------------------------------------
	'Modified Date			                        	                        Modified By
	'Date					                                                     Name
	***********************************************************************************************/
	@Test(description ="Verify that when the 'View Resource' right on a resource is removed for a user,"
			+ " the user cannot add the resource to his/her custom view.")
	public void testHappyDay49205() throws Exception {

		gstrTCID = "49205";
		gstrTO = "Verify that when the 'View Resource' right on a resource is removed for a user, the"
				+ " user cannot add the resource to his/her custom view.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		Resource objResource = new Resource(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);
		FindResources objFindResources = new FindResources(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
		
		System.out.println("---------Precondition ends test execution starts-------");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.selectUsersLinkInResourceList(objResource_data.strResourceName)
				.verAssignUserstoResourcePageIsDisplayed(
						objResource_data.strResourceName)
				.deSelectViewResourceCheckBox(objUserdata.strNewUserName)
				.clickOnSaveButton().verResourceListPageIsDisplayed();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomizedViewInPrefrences();

		objCustomUnderView.verEditCustomViewScreenIsDisplayed()
				.clickOnAddMoreResources();

		objFindResources.verifyFindResourcePageDisplayed();

		objCustomUnderView.enterResNameInWhatField(
				objResource_data.strResourceName).clickOnSearch();

		objFindResources.verifyErrorMsgInFindResourcePage();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/**********************************************************************************************
	'Description : Verify that a user CANNOT be saved by selecting only the 'Update Status'/'Run Reports
	               '/'Associated With' right on a resource without the ‘View Resource’ right.
	'Date	 	 : 01-July-2015
	'Author		 : Anitha
	'----------------------------------------------------------------------------------------------
	'Modified Date			                        	                        Modified By
	'Date					                                                     Name
	***********************************************************************************************/
	@Test(description = "Verify that a user CANNOT be saved by selecting only the 'Update Status'/'Run Reports"
			+ "'/'Associated With' right on a resource without the ‘View Resource’ right.")
	public void testHappyDay49806() throws Exception {

		gstrTCID = "49806";
		gstrTO = "Verify that a user CANNOT be saved by selecting only the 'Update Status'/'Run Reports'"
				+ "/'Associated With' right on a resource without the ‘View Resource’ right.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		Resource objResource = new Resource(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList_page1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectSetupResourceOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
		
		System.out.println("---------Precondition ends test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.selectUsersLinkInResourceList(objResource_data.strResourceName)
				.verAssignUserstoResourcePageIsDisplayed(
						objResource_data.strResourceName)
				.deSelectViewResourceCheckBox(objUserdata.strNewUserName)
				
				.selectUpdateStatusOfResource(objUserdata.strNewUserName)
				.clickOnSaveButton()
				.verifyErrorMsgInAssignResourcePage()				
				.deSelectUpdateStatusOfResource(objUserdata.strNewUserName)
				
				.selectRunReportCheckBox(objUserdata.strNewUserName)
				.clickOnSaveButton()
				.verifyErrorMsgInAssignResourcePage()
				.deSelectRunReportCheckBox(objUserdata.strNewUserName)
				
				.selectAssociatedWithCheckBox(objUserdata.strNewUserName)
				.clickOnSaveButton()
				.verifyErrorMsgInAssignResourcePage()
				
				.selectViewResourceCheckBox(objUserdata.strNewUserName)
				.selectRunReportCheckBox(objUserdata.strNewUserName)
				.selectAssociatedWithCheckBox(objUserdata.strNewUserName)
				.selectUpdateStatusOfResource(objUserdata.strNewUserName)
				.clickOnSaveButton().verResourceListPageIsDisplayed();

		objUsersList_page1
				.navigateToUsersNew()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.verifyResourceRightsSelected(strResourceValue[0])
				.clickCancelButton();
		
		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.selectUsersLinkInResourceList(objResource_data.strResourceName)
				.deSelectUpdateStatusOfResource(objUserdata.strNewUserName)
				.deSelectRunReportCheckBox(objUserdata.strNewUserName)
				.deSelectAssociatedWithCheckBox(objUserdata.strNewUserName)

				.selectUpdateStatusOfResource(objUserdata.strNewUserName)
				.clickOnSaveButton()

				.selectUsersLinkInResourceList(objResource_data.strResourceName)
				.deSelectUpdateStatusOfResource(objUserdata.strNewUserName)
				.selectRunReportCheckBox(objUserdata.strNewUserName)
				.clickOnSaveButton()

				.selectUsersLinkInResourceList(objResource_data.strResourceName)
				.deSelectRunReportCheckBox(objUserdata.strNewUserName)
				.selectAssociatedWithCheckBox(objUserdata.strNewUserName)
				.clickOnSaveButton();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/**********************************************************************************
	'Description : For a resource, verify that status types can be refined for a user.
	'Date	 	 : 12-July-2014
	'Author		 : Anil
	'----------------------------------------------------------------------------------
	'Modified Date : 30-May-2016			            Modified By 
	'Date					                            Name  : Sangappa K
	***********************************************************************************/
	@Test(description = "For a resource, verify that status types can be refined for a user.")
	public void testHappyDay102572() throws Exception {
		
		gstrTCID = "102572";
		gstrTO	 = "For a resource, verify that status types can be refined for a user.";
		
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		Map objMap1 = new Map(this.driver1);
		StatusChangePreference objStatusChangePreference=new StatusChangePreference(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		
		String strstatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew()

		// RoleBased statustypes
				.createStatusTypeWithSection(
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
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address

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
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// create view
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };
		String strResourceName[] = {objResource_data.strResourceName, objResource_data.strResourceName1};
		
		objNavigationToSubMenus.navigateToViews();

		objViewsList.createViewForMultipleResourcesAndStatusTypes(objView_data.strViewName, objView_data.strViewDesc, 
									strResourceName, strStatusTypeNames);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.selectResource(objResource_data.strResourceName1)
//				.clickOnSaveOfCreateNewView();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues).deselectSelectAllWebOption();


		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.selectEditStatusChangeNotPrefernceOption()
				.selectSetupResourceOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		objLogin.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToCustomizedViewInPrefrences();

		String[] strResourceValue1={strResourceValue[0]};
		String[] strResourceValue2={strResourceValue[1]};
		
		objCustomUnderView.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue1)
				.clickOnAddToCustomView()
				
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName1)
				.clickOnSearch()
				.selectResource(strResourceValue2)
				.clickOnAddToCustomView()
				
				.clickOnOptions()
				.selectStatusTypes(strstatusTypeValues).clickOnSave();

		objLogin.clickLogOut();
		
		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		// Event creation
		objEventManagement1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		objEventManagement1.selectResource(strResourceValue1);
		objEventManagement1.selectResource(strResourceValue2);
		
		objEventManagement1.clickOnSaveButton();
		
		objResource1.navigateToResourceListPageNew();
		
		objResource1
				.selectUsersLinkInResourceList(objResource_data.strResourceName)
				.clickRefineLinkOfUserName(objUser_data.strNewUserName);
		
		objUsersList1.selectFrameOfRefineVisibleStatusTypes();

		String[] strstatusTypeValue={strstatusTypeValues[0]};
		
		objUsersList1.deselectStatusTypesInRefine(strstatusTypeValue)
				     .clickSaveChangesButtonInRefine().selectFrame();

		Thread.sleep(5000);

		objResource1.clickOnSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViews1
				.verST1ForResource(objResource_data.strResourceName,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strNotApllicable)
				.verST2ForResource(objResource_data.strResourceName,
						objStatuTypes_data.strTSTStatusTypeName,
						objStatuTypes_data.strDashStatusTypes)
				.verST1ForResource(objResource_data.strResourceName1,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strDashStatusTypes)
				.verST2ForResource(objResource_data.strResourceName1,
						objStatuTypes_data.strTSTStatusTypeName,
						objStatuTypes_data.strDashStatusTypes);
		
		objNavigationToSubMenus1.navigateToCustomInView();
		
		objViews1
				.verST1ForResource(objResource_data.strResourceName,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strNotApllicable)
				.verST2ForResource(objResource_data.strResourceName,
						objStatuTypes_data.strTSTStatusTypeName,
						objStatuTypes_data.strDashStatusTypes)
				.verST1ForResource(objResource_data.strResourceName1,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strDashStatusTypes)
				.verST2ForResource(objResource_data.strResourceName1,
						objStatuTypes_data.strTSTStatusTypeName,
						objStatuTypes_data.strDashStatusTypes);

		objNavigationToSubMenus1.navigateToMap();
		
		String[] strStatusType1 = {objStatuTypes_data.strNSTStatusTypeName};		
		String[] strStatusType2 = {objStatuTypes_data.strTSTStatusTypeName};
		
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName)
			   .verStatusTypesInPopupWindow(strStatusType2)
			   .verStatusTypesNotInPopupWindow(strStatusType1);
		
		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objViews1
				.verST1ForResource(objResource_data.strResourceName,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strNotApllicable)
				.verST2ForResource(objResource_data.strResourceName,
						objStatuTypes_data.strTSTStatusTypeName,
						objStatuTypes_data.strDashStatusTypes)
				.verST1ForResource(objResource_data.strResourceName1,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strDashStatusTypes)
				.verST2ForResource(objResource_data.strResourceName1,
						objStatuTypes_data.strTSTStatusTypeName,
						objStatuTypes_data.strDashStatusTypes);
						
		objViews1.clickOnResource(objResource_data.strResourceName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesNotUnderSection(
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objViews1
				.clickOnResource(objResource_data.strResourceName1)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName);
		
		objNavigationToSubMenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.verStatusTypesUnderUncategorizedSec(
						objStatuTypes_data.strTSTStatusTypeName)
				.verStatusTypesNotDisplayed(
						objStatuTypes_data.strNSTStatusTypeName);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
