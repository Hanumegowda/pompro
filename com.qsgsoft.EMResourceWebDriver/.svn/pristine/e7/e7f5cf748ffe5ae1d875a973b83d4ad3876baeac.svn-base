package requirementGroup.SettingUpUsers;

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
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewRefineStatusTypes extends TestNG_UI_EXTENSIONS{

	public NewRefineStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**************************************************************************************************
	'Description : Verify that the list of status types changes in the 'Refine Visible Status Types' window when a role is changed for the user. 
	'Date	 	 : 14-July-2015
	'Author		 : Renushree
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = "Verify that the list of status types changes in the 'Refine Visible Status Types' window when a role is changed for the user. ")
	public void testHappyDay48322() throws Exception {

		gstrTCID = "48322";
		gstrTO = "Verify that the list of status types changes in the 'Refine Visible Status Types' window when a role is changed for the user. ";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusTypeValues2[] = new String[1];
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

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		System.out.println(objStatuTypes_data.strNSTStatusTypeName);
		System.out.println(objStatuTypes_data.strTSTStatusTypeName);
		System.out.println(objStatuTypes_data.strNDSTStatusTypeName);

		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues1)
				.deselectStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.deselectStatusTypeInRoleMayUpdateSection(strStatusTypeValues1)
				.deSelStatusTypeInRoleMayViewSection(strStatusTypeValues2)
				.deselectStatusTypeInRoleMayUpdateSection(strStatusTypeValues2)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues1)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues2)
				.deselectStatusTypeInRoleMayUpdateSection(strStatusTypeValues1)
				.deselectStatusTypeInRoleMayUpdateSection(strStatusTypeValues2)
				.deSelStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.deselectStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickOnSaveBtn();

		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);

		System.out.println(objRolesData.strRoleName1);

		// User creation
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.verifyUserListPageIsDisplayed()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectRoleCheckBox(strRoleValue[0]).clickSaveButton()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.verUserInList(objUser_data.strNewUserName1)
				.editUserDetails(objUser_data.strNewUserName1);

		String strResName = objUsersList1
				.clickRefineLinkOfViewResourceAndFetchResName();

		objUsersList1.verCloseInRefine()
				.selectFrameOfRefineVisibleStatusTypes()
				.verSTDisplayedInRefineWin(strStatusTypeValues)
				.verSTDisplayedInRefineWin(strStatusTypeValues1)
				.verSTSelectedInRefineWin(strStatusTypeValues)
				.verSTSelectedInRefineWin(strStatusTypeValues1)
				.verSTNotDisplayedInRefineWin(strStatusTypeValues2)
				.clickSaveChangesButtonInRefine().selectFrame();

		objUsersList1.deselectRoleCheckBox(strRoleValue[0])
				.selectRoleCheckBox(strRoleValue[1])
				.clickRefineLinkOfViewResource(strResName)
				.selectFrameOfRefineVisibleStatusTypes()
				.verErrorInRefineWindow().switchToDefaultFrame().selectFrame()
				.clickOnCloseInRefine();

		objUsersList1.clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName1)
				.clickRefineLinkOfViewResource(strResName)
				.selectFrameOfRefineVisibleStatusTypes()
				.verSTDisplayedInRefineWin(strStatusTypeValues1)
				.verSTDisplayedInRefineWin(strStatusTypeValues2)
				.verSTSelectedInRefineWin(strStatusTypeValues1)
				.verSTSelectedInRefineWin(strStatusTypeValues2)
				.verSTNotDisplayedInRefineWin(strStatusTypeValues)
				.deselectStatusTypesInRefine(strStatusTypeValues1)
				.clickSaveChangesButtonInRefine().selectFrame()
				.clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName1)
				.clickRefineLinkOfViewResource(strResName)
				.selectFrameOfRefineVisibleStatusTypes()
				.verSTDisplayedInRefineWin(strStatusTypeValues1)
				.verSTDisplayedInRefineWin(strStatusTypeValues2)
				.verSTDeselectedInRefineWin(strStatusTypeValues1)
				.clickSaveChangesButtonInRefine().selectFrame()
				.deselectRoleCheckBox(strRoleValue[1])
				.selectRoleCheckBox(strRoleValue[0]).clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName1)
				.clickRefineLinkOfViewResource(strResName)
				.selectFrameOfRefineVisibleStatusTypes()
				.verSTDisplayedInRefineWin(strStatusTypeValues)
				.verSTDisplayedInRefineWin(strStatusTypeValues1)
				.verSTDeselectedInRefineWin(strStatusTypeValues1)
				.clickSaveChangesButtonInRefine().selectFrame()
				.selectRoleCheckBox(strRoleValue[1]).clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName1)
				.clickRefineLinkOfViewResource(strResName)
				.selectFrameOfRefineVisibleStatusTypes()
				.verSTDisplayedInRefineWin(strStatusTypeValues)
				.verSTDisplayedInRefineWin(strStatusTypeValues1)
				.verSTDisplayedInRefineWin(strStatusTypeValues2)
				.verSTDeselectedInRefineWin(strStatusTypeValues1)
				.selectStatusTypesInRefine(strStatusTypeValues1)
				.clickSaveChangesButtonInRefine().selectFrame()
				.clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName1)
				.clickRefineLinkOfViewResource(strResName)
				.selectFrameOfRefineVisibleStatusTypes()
				.verSTDisplayedInRefineWin(strStatusTypeValues)
				.verSTDisplayedInRefineWin(strStatusTypeValues1)
				.verSTDisplayedInRefineWin(strStatusTypeValues2)
				.verSTSelectedInRefineWin(strStatusTypeValues)
				.verSTSelectedInRefineWin(strStatusTypeValues1)
				.verSTSelectedInRefineWin(strStatusTypeValues2)
				.deselectStatusTypesInRefine(strStatusTypeValues)
				.deselectStatusTypesInRefine(strStatusTypeValues1)
				.deselectStatusTypesInRefine(strStatusTypeValues2)
				.clickSaveChangesButtonInRefine().selectFrame()
				.clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName1)
				.clickRefineLinkOfViewResource(strResName)
				.selectFrameOfRefineVisibleStatusTypes()
				.verSTDisplayedInRefineWin(strStatusTypeValues)
				.verSTDisplayedInRefineWin(strStatusTypeValues1)
				.verSTDisplayedInRefineWin(strStatusTypeValues2)
				.verSTDeselectedInRefineWin(strStatusTypeValues)
				.verSTDeselectedInRefineWin(strStatusTypeValues1)
				.verSTDeselectedInRefineWin(strStatusTypeValues2).selectFrame()
				.clickSaveButton();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/**************************************************************************************************
	'Description : For a user U1, deselect a status type in the 'Refine Visible Status Types' window for 
					a resource and save, verify that the user cannot view the deselected status type from all the view screens 
					for that particular resource.
	'Date	 	 : 21-July-2015
	'Author		 : Renushree
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = " For a user U1, deselect a status type in the 'Refine Visible Status Types' window "
			+ "for a resource and save, verify that the user cannot view the deselected status type from all "
			+ "the view screens for that particular resource.")
	public void testHappyDay48417() throws Exception {

		gstrTCID = "48417";
		gstrTO = " For a user U1, deselect a status type in the 'Refine Visible Status Types' window "
				+ "for a resource and save, verify that the user cannot view the deselected status type from all "
				+ "the view screens for that particular resource.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

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

		objNavigationToSubMenus.navigateToRoles();

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

		objNavigationToSubMenus.navigateToViews();

		String[] strAllStatausTypes = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName};
		
		String[] strResNames = {objResource_data.strResourceName,objResource_data.strResourceName1};

		objViewsList.createViewForMultipleResourcesAndStatusTypes(objView_data.strViewName, objView_data.strViewDesc, strResNames, strAllStatausTypes)
		/*objViewsList.clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc);

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViewsList.selectStatusType(strAllStatausTypes[i]);
		}

		objViewsList.selectResource(objResource_data.strResourceName)
				.selectResource(objResource_data.strResourceName1)
				.clickOnSaveOfCreateNewView()*/
				.verViewInList(objView_data.strViewName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);

		
		// User creation
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault.selectFrame();
		// Event creation
		objEventManagement.navigateToEventManagement()
						.clickOnCreateNewEvent()
						.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
						.enterAdHocEventName(objEvent_data.strEventName)
						.enterAdHocEventDescription(objEvent_data.strEventDescription);

		objResource.clickResource(strResourceValue);

		objEventManagement.clickOnSaveButton();

		objNavigationToSubMenus.navigateToCustomInView();

		String strRes = objResource_data.strResourceName.substring(4);

		objCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources().enterResNameInWhatField(strRes)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToUsers();

		String strOneSt[] = { strStatusTypeValues[0] };

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName)
				.clickRefineLinkOfViewResource(objResource_data.strResourceName)
				.selectFrameOfRefineVisibleStatusTypes()
				.deselectStatusTypesInRefine(strOneSt)
				.clickSaveChangesButtonInRefine().selectFrame()
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.verResAndStatuaTypesWithValue(strResourceTypeValue[0],
				objResource_data.strResourceName,
				objStatuTypes_data.strNSTStatusTypeName,
				objView_data.strNotApplicable)
				.verResAndStatuaTypesWithValue(strResourceTypeValue[0],
						objResource_data.strResourceName1,
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strHyphen);

		objnNavigationToSubMenus1.navigateToCustomInView();

		objCustomUnderView1.verResAndStatuaTypesWithValue(
				strResourceTypeValue[0], objResource_data.strResourceName,
				objStatuTypes_data.strNSTStatusTypeName,
				objView_data.strNotApplicable)
				.verResAndStatuaTypesWithValue(strResourceTypeValue[0],
						objResource_data.strResourceName1,
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strHyphen);

		objLinksAtTopRightCorners1.clickOnShowMap();

		String[] strStatusType1 = { objStatuTypes_data.strNSTStatusTypeName };
		String[] strStatusType2 = { objStatuTypes_data.strTSTStatusTypeName };

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesNotInPopupWindow(strStatusType1)
				.verStatusTypesInPopupWindow(strStatusType2)
				.selectResourceNameInFindResourceDropdown(
						objResource_data.strResourceName1)
				.verStatusTypesInPopupWindow(strStatusType1)
				.verStatusTypesInPopupWindow(strStatusType2);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objViewsList1.verResAndStatuaTypesWithValue(strResourceTypeValue[0],
				objResource_data.strResourceName,
				objStatuTypes_data.strNSTStatusTypeName,
				objView_data.strNotApplicable)
				.verResAndStatuaTypesWithValue(strResourceTypeValue[0],
						objResource_data.strResourceName1,
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strHyphen);

		objEventStatus1.clickOnResource(strResourceValue[0]);

		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
				objStatuTypes_data.strTSTStatusTypeName,
				objView_data.strSectionName)
				.verifyStatusTypeIsNotUnderSectionsInResourceDetailPage(
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName);

		objLogin1.clickLogOut();

		String[] strTestData = {
				Login_data.strBuildName,
				gstrTCID,
				objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
				objEventSetUp_data.strEventTemplate,
				objEvent_data.strEventName,
				"Verify mobile end condition with event name ,resources and status types",
				objStatuTypes_data.strNSTStatusTypeName + ", "
						+ objStatuTypes_data.strTSTStatusTypeName,
				objResource_data.strResourceName + ", "
						+ objResource_data.strResourceName1,
				objResourceType_data.strResourceTypeName,
				objTest_data.strRegionName, objView_data.strSectionName };

		objOffCommonFunc.writeResultData(strTestData,
				strPartialAutoResultsPath, "Events");

		gstrResult = "PASS";
	}
	
	/**************************************************************************************************
	'Description : Verify that when the status type is added back in 'Refine Visible Status Types' window for a resource, the changes are reflected on all view screens for the user. 
	'Date	 	 : 22-July-2015
	'Author		 : Renushree
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = "Verify that when the status type is added back in 'Refine Visible Status Types' window for a resource, the changes are reflected on all view screens for the user. ")
	public void testHappyDay48614() throws Exception {

		gstrTCID = "48614";
		gstrTO = "Verify that when the status type is added back in 'Refine Visible Status Types' window for a resource, the changes are reflected on all view screens for the user. ";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

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

		objNavigationToSubMenus.navigateToRoles();

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

		objNavigationToSubMenus.navigateToViews();

		String[] strAllStatausTypes = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strAllStatausTypes)
		/*objViewsList.clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc);

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViewsList.selectStatusType(strAllStatausTypes[i]);
		}

		objViewsList.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView()*/
				.verViewInList(objView_data.strViewName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);

		// User creation
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault.selectFrame();

		// Event creation
		objEventManagement.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		objResource.clickResource(strResourceValue);

		objEventManagement.clickOnSaveButton();

		objNavigationToSubMenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToUsers();

		String strOneSt[] = { strStatusTypeValues[0] };

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName)
				.clickRefineLinkOfViewResource(objResource_data.strResourceName)
				.selectFrameOfRefineVisibleStatusTypes()
				.deselectStatusTypesInRefine(strOneSt)
				.clickSaveChangesButtonInRefine().selectFrame()
				.clickOnUsernameField()
				.clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName)
				.clickRefineLinkOfViewResource(objResource_data.strResourceName)
				.selectFrameOfRefineVisibleStatusTypes()
				.selectStatusTypesInRefine(strOneSt)
				.clickSaveChangesButtonInRefine().selectFrame()
				.clickOnUsernameField()
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };

		objViewsList1
				.verResAndStatusTypes(strResourceTypeValue[0],
						objResource_data.strResourceName, strStatusTypeNames[0])
				.verResAndStatusTypes(strResourceTypeValue[0],
						objResource_data.strResourceName, strStatusTypeNames[1]);

		objnNavigationToSubMenus1.navigateToCustomInView();

		String[] strResName = { objResource_data.strResourceName };

		objCustomUnderView1.verResourceAndResTypeInCustomViewTablePage(
				strResName, objResourceType_data.strResourceTypeName)
				.verStatusTypeInCustomViewTablePage(strStatusTypeNames);

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verStatusTypesInPopupWindow(
				strStatusTypeNames);

		objnNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verStatusTypesInPopupWindow(
				strStatusTypeNames);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objViewsList1
				.verResAndStatusTypes(strResourceTypeValue[0],
						objResource_data.strResourceName, strStatusTypeNames[0])
				.verResAndStatusTypes(strResourceTypeValue[0],
						objResource_data.strResourceName, strStatusTypeNames[1]);

		objEventStatus1.clickOnResource(strResourceValue[0]);

		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
				objStatuTypes_data.strTSTStatusTypeName,
				objView_data.strSectionName)
				.verifyStatusTypeUnderSectionsInResourceDetailPage(
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName);

		objLogin1.clickLogOut();

		String[] strTestData = {
				Login_data.strBuildName,
				gstrTCID,
				objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
				objEventSetUp_data.strEventTemplate,
				objEvent_data.strEventName,
				"Verify mobile end condition with event name ,resources and status types",
				objStatuTypes_data.strNSTStatusTypeName + ", "
						+ objStatuTypes_data.strTSTStatusTypeName,
				objResource_data.strResourceName,
				objResourceType_data.strResourceTypeName,
				objTest_data.strRegionName, objView_data.strSectionName };

		objOffCommonFunc.writeResultData(strTestData,
				strPartialAutoResultsPath, "Events");

		gstrResult = "PASS";
	}
	
	/**************************************************************************************************
	'Description : For a user U1, verify that when a status type is deselected in the 'Refine Visible Status Types' window for a resource RS, the user cannot update the status of that status type for resource RS.  
	'Date	 	 : 22-July-2015
	'Author		 : Renushree
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = "For a user U1, verify that when a status type is deselected in the 'Refine Visible Status Types' window for a resource RS, the user cannot update the status of that status type for resource RS. ")
	public void testHappyDay48545() throws Exception {

		gstrTCID = "48545";
		gstrTO = "For a user U1, verify that when a status type is deselected in the 'Refine Visible Status Types' window for a resource RS, the user cannot update the status of that status type for resource RS. ";

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
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

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

		objNavigationToSubMenus.navigateToRoles();

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

		objNavigationToSubMenus.navigateToViews();

		String[] strAllStatausTypes = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strAllStatausTypes)
		/*objViewsList.clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc);

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViewsList.selectStatusType(strAllStatausTypes[i]);
		}

		objViewsList.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView()*/
				.verViewInList(objView_data.strViewName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);

		// User creation
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().selectViewcustomViewOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

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
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToUsers();

		String strOneSt[] = { strStatusTypeValues[0] };

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName)
				.clickRefineLinkOfViewResource(objResource_data.strResourceName)
				.selectFrameOfRefineVisibleStatusTypes()
				.deselectStatusTypesInRefine(strOneSt)
				.clickSaveChangesButtonInRefine().selectFrame()
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();
		
		// Event creation
		objEventManagement1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		objResource1.clickResource(strResourceValue);

		objEventManagement1.clickOnSaveButton();


		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };

		objViewsList1
				.verResAndStatusTypes(strResourceTypeValue[0],
						objResource_data.strResourceName, strStatusTypeNames[1])
				.verStatusTypesNotDisplayedWithRes(strResourceTypeValue[0],
						objResource_data.strResourceName, strStatusTypeNames[0]);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.verStatusTypeDisplayed(strStatusTypeValues[1],
						objStatuTypes_data.strTSTStatusTypeName)
				.verStatusTypeNotDisplayed(strStatusTypeValues[0],
						objStatuTypes_data.strNSTStatusTypeName)
				.clickOnShowAllStatuses()
				.verStatusTypeDisplayed(strStatusTypeValues[1],
						objStatuTypes_data.strTSTStatusTypeName)
				.verStatusTypeNotDisplayed(strStatusTypeValues[0],
						objStatuTypes_data.strNSTStatusTypeName);

		objnNavigationToSubMenus1.navigateToCustomInView();

		String[] strResName = { objResource_data.strResourceName };
		String[] strStatusTypeName1 = { objStatuTypes_data.strNSTStatusTypeName };
		String[] strStatusTypeName2 = { objStatuTypes_data.strTSTStatusTypeName };

		objCustomUnderView1
				.verResourceAndResTypeInCustomViewTablePage(strResName,
						objResourceType_data.strResourceTypeName)
				.verStatusTypeInCustomViewTablePage(strStatusTypeName2)
				.verStatusTypeNotInCustomViewTablePage(
						objStatuTypes_data.strNSTStatusTypeName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.verStatusTypeDisplayed(strStatusTypeValues[1],
						objStatuTypes_data.strTSTStatusTypeName)
				.verStatusTypeNotDisplayed(strStatusTypeValues[0],
						objStatuTypes_data.strNSTStatusTypeName)
				.clickOnShowAllStatuses()
				.verStatusTypeDisplayed(strStatusTypeValues[1],
						objStatuTypes_data.strTSTStatusTypeName)
				.verStatusTypeNotDisplayed(strStatusTypeValues[0],
						objStatuTypes_data.strNSTStatusTypeName);

		objnNavigationToSubMenus1.navigateToCustomInView();

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeName2)
				.verStatusTypesNotInPopupWindow(strStatusTypeName1)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1.verStatusTypeDisplayed(strStatusTypeValues[1],
				objStatuTypes_data.strTSTStatusTypeName)
				.verStatusTypeNotDisplayed(strStatusTypeValues[0],
						objStatuTypes_data.strNSTStatusTypeName);

		objnNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeName2)
				.verStatusTypesNotInPopupWindow(strStatusTypeName1)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.verStatusTypeDisplayed(strStatusTypeValues[1],
						objStatuTypes_data.strTSTStatusTypeName)
				.verStatusTypeNotDisplayed(strStatusTypeValues[0],
						objStatuTypes_data.strNSTStatusTypeName)
				.clickOnSaveButton();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objViewsList1
				.verResAndStatusTypes(strResourceTypeValue[0],
						objResource_data.strResourceName, strStatusTypeNames[1])
				.verStatusTypesNotDisplayedWithRes(strResourceTypeValue[0],
						objResource_data.strResourceName, strStatusTypeNames[0]);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.verStatusTypeDisplayed(strStatusTypeValues[1],
						objStatuTypes_data.strTSTStatusTypeName)
				.verStatusTypeNotDisplayed(strStatusTypeValues[0],
						objStatuTypes_data.strNSTStatusTypeName)
				.clickOnShowAllStatuses()
				.verStatusTypeDisplayed(strStatusTypeValues[1],
						objStatuTypes_data.strTSTStatusTypeName)
				.verStatusTypeNotDisplayed(strStatusTypeValues[0],
						objStatuTypes_data.strNSTStatusTypeName)
				.clickOnSaveButton();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.clickOnResource(strResourceValue[0]);

		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
				objStatuTypes_data.strTSTStatusTypeName,
				objView_data.strSectionName)
				.verifyStatusTypeIsNotUnderSectionsInResourceDetailPage(
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName);

		objViewsList1.selStatusTypeInResDetailScreenToUpdate(
				objStatuTypes_data.strTSTStatusTypeName, strResourceValue[0],
				strStatusTypeValues[1]);

		objUpdateStatus1
				.verStatusTypeDisplayed(strStatusTypeValues[1],
						objStatuTypes_data.strTSTStatusTypeName)
				.verStatusTypeNotDisplayed(strStatusTypeValues[0],
						objStatuTypes_data.strNSTStatusTypeName)
				.clickOnShowAllStatuses()
				.verStatusTypeDisplayed(strStatusTypeValues[1],
						objStatuTypes_data.strTSTStatusTypeName)
				.verStatusTypeNotDisplayed(strStatusTypeValues[0],
						objStatuTypes_data.strNSTStatusTypeName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
