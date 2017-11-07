package requirementGroup.CreatingAndManagingEvents;

import java.util.Arrays;

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
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseMultiRegionEventsWithResourcesAndStatusTypes extends TestNG_UI_EXTENSIONS {

	public EdgeCaseMultiRegionEventsWithResourcesAndStatusTypes() throws Exception {
		super();
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that sub-resources are not available on 'Select Resources' page while creating/editing a multi-region event
	 * 'Precondition	: 
	 * 'Date 			: 04-Dec-2015 
	 * 'Author 			: Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that sub-resources are not available on 'Select Resources' page while creating/editing a multi-region event")
	public void testHappyDay135781() throws Exception {

		gstrTCID = "135781";
		gstrTO = "Verify that sub-resources are not available on 'Select Resources' page while creating/editing a multi-region event";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
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
		Resource_data objResource_data = new Resource_data();
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strStatusTypeValuesInReg2[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];
		String strSubResourceTypeValue[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		String[] strAllRegions = {objLogindata.strRegionName1, objLogindata.strRegionName2};
		Arrays.sort(strAllRegions);

		objSelectRegionpage
				.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(strAllRegions[0]);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(strAllRegions[1]);

		System.out.println(strRegionValue[1]);

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

		// Create Sub-Resource Type
		String strStatusTypesValuesForSRT[] = { strStatusTypeValues[1] };

		objResourceType.createSubResourceType(
							objResourceType_data.strSubResourceTypeName,
							strStatusTypesValuesForSRT);

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);
		
		
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

		objResource.clickOnSubResourcesLink(objResource_data.strResourceName);
		objResource.createSubResourceForResource(objResource_data.strSubResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strSubResourceTypeName,objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);
		
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)
				.clickOnWebNotification(objUserdata.strFullName, true)
				.clickSaveButton();

		objSelectRegionpage
				.selectRegionAndNavigate(strAllRegions[1]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		String strStatusTypesValuesForSRTInReg2[] = { strStatusTypeValuesInReg2[1] };
		
		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName1,
				strStatusTypesValuesForSRTInReg2);

		strSubResourceTypeValue[0] = objResourceType
			.getResourceTypeValue(objResourceType_data.strSubResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);


		objResource.clickOnSubResourcesLink(objResource_data.strResourceName1);
		objResource.createSubResourceForResource(objResource_data.strSubResourceName1, objResource_data.strResourceAbbrivation, objResourceType_data.strSubResourceTypeName1,objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);
		
		objUsersList.navigateToUsersNew()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName).selectFirstRole()
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objEventSetUp_data.strEventTemplate1,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValueInReg2, strStatusTypeValuesInReg2)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate1)
				.clickOnWebNotification(objUserdata.strFullName, true)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.deselectIncludeAllResourcesOption()
				.selectEventTemplateForMRE(strRegionValue[0],
						objEventSetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objEventSetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyRegionName(strAllRegions[0])
				.verifyRSAndRTName(objResource_data.strResourceName,
						objResourceType_data.strResourceTypeName)
				.verifySRSNameIsNotDisplayed(objResource_data.strSubResourceName)
				.selectResource(strResourceValue)
				.clickOnNextButton()
				.verifyRegionName(strAllRegions[1])
				.verifyRSAndRTName(objResource_data.strResourceName1,
						objResourceType_data.strResourceTypeName1)
				.verifySRSNameIsNotDisplayed(objResource_data.strSubResourceName1)
				.selectResource(strResourceValueInReg2)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame()
				.verifyEventName(objEvent_data.strEventName)
				.clickOnEditLink(objEvent_data.strEventName)
				.clickOnNextButton()
				.verifyRegionName(strAllRegions[0])
				.verifyRSAndRTName(objResource_data.strResourceName,
						objResourceType_data.strResourceTypeName)
				.verifySRSNameIsNotDisplayed(objResource_data.strSubResourceName)
				.selectResource(strResourceValue)
				.clickOnNextButton()
				.verifyRegionName(strAllRegions[1])
				.verifyRSAndRTName(objResource_data.strResourceName1,
						objResourceType_data.strResourceTypeName1)
				.verifySRSNameIsNotDisplayed(objResource_data.strSubResourceName1)
				.selectResource(strResourceValueInReg2)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.clickOnYesButton()
				.verifyEventName(objEvent_data.strEventName);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*************************************************************************************
	 * 'Description 	: Select new status type while editing an event template and verify
	 *                   that newly selected status type is displayed in the newly created 
	 *                    multi region event.
	 * 'Precondition	: 
	 * 'Date 			: 14-March-2016 
	 * 'Author 			: Sangappa K
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Select new status type while editing an event template and verify that"
			+ " newly selected status type is displayed in the newly created multi region event.")
	public void testEdgeCase135906() throws Exception {

		gstrTCID = "135906";
		gstrTO = "Select new status type while editing an event template and verify that newly "
				+ "selected status type is displayed in the newly created multi region event.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValue1[] = new String[1];

		String strResourceValue[] = new String[1];
		String strResourceValue1[] = new String[1];

		String strRegionValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		String[] strAllRegions = { objLogindata.strRegionName,
				objLogindata.strRegionName1 };
		Arrays.sort(strAllRegions);

		objSelectRegionpage.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page.getRegionValue(strAllRegions[0]);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page.getRegionValue(strAllRegions[1]);

		System.out.println(strRegionValue[1]);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		System.out.println(objStatusTypes_data.strNumberStatusType);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		String str1StStatusTypeValue[] = { strStatusTypeValues[0] };

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		System.out.println(objResourceType_data.strResourceTypeName);

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

		System.out.println(objResource_data.strResourceName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[0])
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, str1StStatusTypeValue)
				.deselectSelectAllWebOptionOnly().clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate);

		objSelectRegionpage.clickRegionLink().selectRegionAndNavigate(
				strAllRegions[1]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		System.out.println(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strStatusTypeValues1);

		strResourceTypeValue1[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton().editUserDetails(objUserdata.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate1,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue1, strStatusTypeValues1)
				.deselectSelectAllWebOptionOnly().clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate1);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objESetUp_data.strEventTemplate)
				.selectStatusType(strStatusTypeValues[1])
				.selectStatusType(strStatusTypeValues[2]).clickSaveButton();

		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.verifyCreateMultiRegionEventPage()
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyRegionAndETName(strAllRegions[0],
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(strAllRegions[1],
						objESetUp_data.strEventTemplate1).clickOnYesButton();

		System.out.println(objEvent_data.strMultiRegionEvent);

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strMultiRegionEvent)
				.verifyEventName(objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strSSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strNSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strNDSTStatusTypeName);
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Remove a status type from a resource type and verify that the status 
	 *                    type is not available on 'Event Status' screen of multi region event.
	 * 'Precondition	: 
	 * 'Date 			: 15-March-2016 
	 * 'Author 			: Sangappa K
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Remove a status type from a resource type and verify that the status type "
			+ "is not available on 'Event Status' screen of multi region event.")
	public void testEdgeCase135649() throws Exception {

		gstrTCID = "135649";
		gstrTO = " Remove a status type from a resource type and verify that the status type is not available "
				+ "on 'Event Status' screen of multi region event.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Resource_data objResource_data = new Resource_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValue1[] = new String[1];

		String strResourceValue[] = new String[1];
		String strResourceValue1[] = new String[1];

		String strRegionValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		String[] strAllRegions = { objLogindata.strRegionName,
				objLogindata.strRegionName1 };
		Arrays.sort(strAllRegions);

		objSelectRegionpage.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page.getRegionValue(strAllRegions[0]);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page.getRegionValue(strAllRegions[1]);

		System.out.println(strRegionValue[1]);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		System.out.println(objStatusTypes_data.strNumberStatusType);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		System.out.println(objResourceType_data.strResourceTypeName);

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

		System.out.println(objResource_data.strResourceName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[0])
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOptionOnly().clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate);

		objSelectRegionpage.clickRegionLink().selectRegionAndNavigate(
				strAllRegions[1]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		System.out.println(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strStatusTypeValues1);

		strResourceTypeValue1[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton().editUserDetails(objUserdata.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate1,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue1, strStatusTypeValues1)
				.deselectSelectAllWebOptionOnly().clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate1);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();
		objEventManagement1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.verifyCreateMultiRegionEventPage()
				.enterAdHocEventName(objEvent_data.strMultiRegionEvent)
				.enterAdHocEventDescription(
						objEvent_data.strMultiRegionEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyRegionAndETName(strAllRegions[0],
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(strAllRegions[1],
						objESetUp_data.strEventTemplate1).clickOnYesButton();

		System.out.println(objEvent_data.strMultiRegionEvent);

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strMultiRegionEvent)
				.verifyEventName(objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strSSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strNSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strNDSTStatusTypeName);
		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		String[] strDeselectedSTs = { strStatusTypeValues[1],
				strStatusTypeValues[2] };

		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType1
				.verResourceTypeInList(objResourceType_data.strResourceTypeName)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.deselectStatusType(strDeselectedSTs).clickOnSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame().clickOnHomeButton();

		objEventManagement1
				.navigateToEventManagement()
				.verifyEventNameInEventBanner(objEvent_data.strMultiRegionEvent)
				.verifyEventName(objEvent_data.strMultiRegionEvent)
				.clickOnEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strNSTStatusTypeName)
				.verStatusTypeNotPresent(
						objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strSSTStatusTypeName)
				.verStatusTypeNotPresent(
						objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strNDSTStatusTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Select new status types while editing an event template
	 			and verify that newly selected status type is not displayed
	 			 in the ongoing multi-region event detail screen.
	'Precondition:
	'Date	 	 : 03-Sep-2014
	'Author		 : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Select new status types while editing an event "
			+ "template and verify that newly selected status type is not "
			+ "displayed in the ongoing multi-region event detail screen.")
	public void testEdgeCase135648() throws Exception {

		gstrTCID = "135648";
		gstrTO = "Select new status types while editing an event "
				+ "template and verify that newly selected status type is not "
				+ "displayed in the ongoing multi-region event detail screen.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		Regions objRegions = new Regions(this.driver1);

		String strstatusTypeValues[] = new String[2];
		String strstatusTypeValues2[] = new String[1];
		
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strstatusTypeValues1[] = new String[2];
		String strstatusTypeValues3[] = new String[1];
		String strResourceTypeValue1[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strRegionValue[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		
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
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.createNewStatus(
				objStatuTypes_data.strStatusNameInMulti,
				objStatuTypes_data.strStatusColor)
	.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
			objStatuTypes_data.strStatusColor)
	.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
	.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
.clickOnReturnToStatusTypeList();

		strstatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// create multi region Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);

		objEventSetUp.deselectSelectAllWebOption();
		
		System.out.println("ET1 " + objESetUp_data.strEventTemplate);

		// User1 creation
		String[] strRegionNames = { objTest_data.strRegionName2,
				objTest_data.strRegionName };

		objNavigationToSubMenus.navigateToRegions();

		strRegionValue[0] = objRegions.getRegionValue(strRegionNames[0]);

		strRegionValue[1] = objRegions.getRegionValue(strRegionNames[1]);

		System.out.println(strRegionValue[0]);
		System.out.println(strRegionValue[1]);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectSetupResourceTypesOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[0])
				.selectRegion(strRegionValue[1])
				.clickSaveButton();

		System.out.println("user1 " + objUser_data.strNewUserName);

		// Navigate to Region B

//		objRegionDefault.clickRegionLink();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName1);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName1);
		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
				objStatuTypes_data.strStatusColor)
	.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
			         objStatuTypes_data.strStatusColor)
	.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
	.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues3[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues1);

		strResourceTypeValue1[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// create multi region Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objESetUp_data.strEventTemplate1,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue1,
				strstatusTypeValues1);

		objEventSetUp.deselectSelectAllWebOption();
		
		System.out.println("ET2 " + objESetUp_data.strEventTemplate1);

		// User2 creation
		objUsersList
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectSetupResourceTypesOption()
				.selectMaintainEventTemplateOption()
				.clickSaveButton();
		
		objUsersList.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifySelectAllButton()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.clickOnRegionName(strRegionValue[0])
				.clickOnRegionName(strRegionValue[1]).clickSaveButton()
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");


		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				.createNewMultiEventButton().verifyCreateMultiRegionEventPage();

		objEventManagement1.enterAdHocEventName(
				objEvent_data.strMultiRegionEvent).enterAdHocEventDescription(
				objEvent_data.strMultiRegionEventDescription);

		objEventManagement1
				.selectEventTemplateForMRE(strRegionValue[1],
						objESetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyEventTitleInMREC(objEvent_data.strMultiRegionEvent)
				.verifyEventInformationInMREC(
						objEvent_data.strMultiRegionEventDescription);

		objEventManagement1
				.verifyRegionAndETName(objTest_data.strRegionName,
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(objTest_data.strRegionName2,
						objESetUp_data.strEventTemplate1).verifyYesButton()
				.verifyNoButton().clickOnYesButton();

		objEventManagement1
				.verifyEventName(objEvent_data.strMultiRegionEvent);

		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strMultiRegionEvent);

		
		String strStatusTypeNames[] = {objStatuTypes_data.strNSTStatusTypeName, objStatuTypes_data.strTSTStatusTypeName};
		
		objEventManagement1.verifyStatusTypesInEventBannerPage(objResourceType_data.strResourceTypeName, strStatusTypeNames);
		
		objEventManagement1.verifyStatusTypesIsNotInEventBannerPage(objResourceType_data.strResourceTypeName, objStatuTypes_data.strMSTStatusTypeName);
		
		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName2);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				           .verifyEventManagementPage()
				           .verifyEventName(objEvent_data.strMultiRegionEvent);
 
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strMultiRegionEvent);
		
		String strStatusTypeNames1[] = {objStatuTypes_data.strNSTStatusTypeName1, objStatuTypes_data.strTSTStatusTypeName1};
		
		objEventManagement1.verifyStatusTypesInEventBannerPage(objResourceType_data.strResourceTypeName1, strStatusTypeNames1);
		
		objEventManagement1.verifyStatusTypesIsNotInEventBannerPage(objResourceType_data.strResourceTypeName1, objStatuTypes_data.strMSTStatusTypeName1);
		
		objResourceType1.navigateToResourceTypePageNew();
		
		objResourceType1.clickOnEditLinkOfResourceType(objResourceType_data.strResourceTypeName1);
		
		objResourceType1.clickStatusType(strstatusTypeValues3);
		
		objResourceType1.clickOnSaveButton();
		
		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1.clickOnEditTempLink(objESetUp_data.strEventTemplate1);
		
		for(int intCount = 0; intCount<strstatusTypeValues3.length; intCount++){
			objEventSetUp1.selectStatusType(strstatusTypeValues3[intCount]);
		}
		objEventSetUp1.clickSaveButton();
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strMultiRegionEvent);
		
		objEventManagement1.verifyStatusTypesInEventBannerPage(objResourceType_data.strResourceTypeName1, strStatusTypeNames1);
		
		objEventManagement1.verifyStatusTypesIsNotInEventBannerPage(objResourceType_data.strResourceTypeName1, objStatuTypes_data.strMSTStatusTypeName1);
		
		
		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objResourceType1.navigateToResourceTypePageNew();
		
		objResourceType1.clickOnEditLinkOfResourceType(objResourceType_data.strResourceTypeName);
		
		objResourceType1.clickStatusType(strstatusTypeValues2);
		
		objResourceType1.clickOnSaveButton();
		
		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1.clickOnEditTempLink(objESetUp_data.strEventTemplate);
		
		for(int intCount = 0; intCount<strstatusTypeValues2.length; intCount++){
			objEventSetUp1.selectStatusType(strstatusTypeValues2[intCount]);
		}
		objEventSetUp1.clickSaveButton();
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strMultiRegionEvent);
		objEventManagement1.verifyStatusTypesInEventBannerPage(objResourceType_data.strResourceTypeName, strStatusTypeNames);
		
		objEventManagement1.verifyStatusTypesIsNotInEventBannerPage(objResourceType_data.strResourceTypeName, objStatuTypes_data.strMSTStatusTypeName);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

}
