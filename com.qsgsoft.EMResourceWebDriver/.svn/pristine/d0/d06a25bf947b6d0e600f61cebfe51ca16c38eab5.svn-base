package requirementGroup.CreatingAndManagingEvents;

import java.util.Arrays;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
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

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEdgeCaseEditMultiRegionEvent extends TestNG_UI_EXTENSIONS {

	public NewEdgeCaseEditMultiRegionEvent() throws Exception {
		super();}
		// TODO Auto-generated constructor stub
		
		/*************************************************************************************
		 * 'Description 	:  Verify that option to edit / end multi region event is available under 
		 *                     'Event Management' screen in the newly participating region when a new\
		 *                      participating region is added.
		 * 'Precondition	: 
		 * 'Date 			: 26-Feb-2016 
		 * 'Author 			: Sangappa K
		 * '---------------------------------------------------------------
		 * 'Modified Date 			Modified By 
		 * 'Date Name
		 **************************************************************************************/
		@Test(description = " Verify that option to edit / end multi region event is available under "
				+ "'Event Management' screen in the newly participating region when a new participating"
				+ " region is added.")
		public void testEdgeCase135091() throws Exception {

			gstrTCID = "135091";
			gstrTO = " Verify that option to edit / end multi region event is available under 'Event Management'"
					+ " screen in the newly participating region when a new participating region is added.";

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

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusTypeValues2[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValue1[] = new String[1];
		String strResourceTypeValue2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strResourceValue2[] = new String[1];
		String strRegionValue[] = new String[3];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		String[] strAllRegions = { objLogindata.strRegionName,
				objLogindata.strRegionName1, objLogindata.strRegionName2 };
		Arrays.sort(strAllRegions);

		objSelectRegionpage.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page.getRegionValue(strAllRegions[0]);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page.getRegionValue(strAllRegions[1]);

		System.out.println(strRegionValue[1]);

		strRegionValue[2] = objRegions_page.getRegionValue(strAllRegions[2]);

		System.out.println(strRegionValue[2]);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

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
				.selectMaintainEventsOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[0])
				.selectRegion(strRegionValue[1])
				.selectRegion(strRegionValue[2]).clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOptionOnly().clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate);

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
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate1,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue1, strStatusTypeValues1)
				.deselectSelectAllWebOptionOnly().clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate1);

		objSelectRegionpage.clickRegionLink().selectRegionAndNavigate(
				strAllRegions[2]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		System.out.println(objStatusTypes_data.strSSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType
				.createResourceType(objResourceType_data.strResourceTypeName2,
						strStatusTypeValues2);

		strResourceTypeValue2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName2);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName2)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName2)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue2[0] = objResource
				.getResourceValue(objResource_data.strResourceName2);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton().editUserDetails(objUserdata.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.verifyRegionName(strRegionValue[2])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.selectUserRegion(strRegionValue[2]).clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate2,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue2, strStatusTypeValues2)
				.deselectSelectAllWebOptionOnly().clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate2);

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

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent).verifyEventName(
				objEvent_data.strMultiRegionEvent);

		objRegionDefault1.clickOnHomeButton();
		objEventManagement1.navigateToEventManagement()
				.verifyEditEventLink(objEvent_data.strMultiRegionEvent)
				.verifyEndEventLink(objEvent_data.strMultiRegionEvent);

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[2]);

		objRegionDefault1.selectFrame().clickOnHomeButton();

		objEventManagement1
				.verEveNotPresentInEveBanner(objEvent_data.strMultiRegionEvent)
				.navigateToEventManagement()
				.verifyEditEventIsNotDisplayed(
						objEvent_data.strMultiRegionEvent)
				.verifyEndEventIsNotDisplayed(objEvent_data.strMultiRegionEvent);

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[1]);

		objRegionDefault1.selectFrame().clickOnHomeButton();

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strMultiRegionEvent)
				.navigateToEventManagement()
				.verifyEditEventLink(objEvent_data.strMultiRegionEvent)
				.verifyEndEventLink(objEvent_data.strMultiRegionEvent)
				.clickOnEditLink(objEvent_data.strMultiRegionEvent)
				.selectEventTemplateForMRE(strRegionValue[2],
						objESetUp_data.strEventTemplate2)
				.clickOnNextButton()
				.clickOnNextButton()
				.clickOnNextButton()
				.selectResource(strResourceValue2)
				.clickOnNextButton()
				.verifyRegionAndETName(strAllRegions[0],
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(strAllRegions[1],
						objESetUp_data.strEventTemplate1)
				.verifyRegionAndETName(strAllRegions[2],
						objESetUp_data.strEventTemplate2).clickOnYesButton();

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[2]);

		objRegionDefault1.selectFrame().clickOnHomeButton();

		String strupdatedEve = "Update 1: " + objEvent_data.strMultiRegionEvent;

		objEventManagement1.verifyEventNameInEventBanner(strupdatedEve)
				.navigateToEventManagement()
				.verifyEditEventLink(objEvent_data.strMultiRegionEvent)
				.verifyEndEventLink(objEvent_data.strMultiRegionEvent);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

		
		/*************************************************************************************
		 * 'Description 	: Verify that option to edit / end multi region event is not displayed under
		 *                  'Event Management' screen in a region in which event is no longer participating.
		 * 'Precondition	: 
		 * 'Date 			: 29-Feb-2016 
		 * 'Author 			: Sangappa K
		 * '---------------------------------------------------------------
		 * 'Modified Date 			Modified By 
		 * 'Date Name
		 **************************************************************************************/
		@Test(description = "Verify that option to edit / end multi region event is not displayed under 'Event Management'"
				             + " screen in a region in which event is no longer participating.")
		public void testEdgeCase135090() throws Exception {

			gstrTCID ="135090";
			gstrTO = "Verify that option to edit / end multi region event is not displayed under 'Event Management' screen in a"
					+ " region in which event is no longer participating.";

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

		String strStatusTypeValues[] = new String[2];
		String strStatusTypeValues1[] = new String[2];

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
				objStatusTypes_data.strsSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsSSTStatusTypeName);

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
				.selectMaintainEventsOption().clickSaveButton();

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

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

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
				.clickSaveButton()

				.editUserDetails(objUserdata.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
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

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[1]);

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

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strMultiRegionEvent).verifyEventName(
				objEvent_data.strMultiRegionEvent);

		objRegionDefault1.clickOnHomeButton();
		objEventManagement1.navigateToEventManagement()
				.verifyEditEventLink(objEvent_data.strMultiRegionEvent)
				.verifyEndEventLink(objEvent_data.strMultiRegionEvent);

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strMultiRegionEvent);

		objRegionDefault1.clickOnHomeButton();
		objEventManagement1.navigateToEventManagement()
				.verifyEditEventLink(objEvent_data.strMultiRegionEvent)
				.verifyEndEventLink(objEvent_data.strMultiRegionEvent);
		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[1]);

		objRegionDefault1.selectFrame().clickOnHomeButton();

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strMultiRegionEvent)
				.navigateToEventManagement()
				.verifyEditEventLink(objEvent_data.strMultiRegionEvent)
				.verifyEndEventLink(objEvent_data.strMultiRegionEvent)
				.clickOnEditLink(objEvent_data.strMultiRegionEvent)

				.selectEventTemplateForMRE(strRegionValue[0],
						objESetUp_data.strNotParticipationg)
				.clickOnNextButton()
				.clickOnNextButton()
				.verifyRegionAndETName(strAllRegions[1],
						objESetUp_data.strEventTemplate1).clickOnYesButton();

		String strupdatedEve = "Update 1: " + objEvent_data.strMultiRegionEvent;

		objEventManagement1.verifyEventNameInEventBanner(strupdatedEve)
				.navigateToEventManagement()
				.verifyEditEventLink(objEvent_data.strMultiRegionEvent)
				.verifyEndEventLink(objEvent_data.strMultiRegionEvent);

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame().clickOnHomeButton();

		objEventManagement1
				.navigateToEventManagement()
				.verifyEditEventIsNotDisplayed(
						objEvent_data.strMultiRegionEvent)
				.verifyEndEventIsNotDisplayed(objEvent_data.strMultiRegionEvent)
				.verifyEventStatus(objEvent_data.strMultiRegionEvent,
						objEvent_data.strEnded);
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
		
	/*******************************************************************************************************************
	 * Description	: Verify that user can not edit a multi region event from the region in which event is no longer participating.
	 * Date			: 03-Mar-2016
	 * Author		: Pallavi
	 ********************************************************************************************************************/
	@Test(description = "Verify that user can not edit a multi region event from the region in which event is no longer participating.")
	public void testEdgeCase135082() throws Exception {
		
		gstrTCID = "135082";
		gstrTO	 = "Verify that user can not edit a multi region event from the region in which event is no longer participating.";

		Login_data objTest_data = new Login_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		String strRegionValue[] = new String[2];
		String strRegionNames[] = new String[2];

		String strFilePath = Login_data.strTestDataPath;
		
		strRegionNames[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 2, strFilePath);
		strRegionNames[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 3, strFilePath);
		
		strRegionValue[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 2, strFilePath);
		strRegionValue[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 3, strFilePath);

		String strResourceName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 16, strFilePath);
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);
		
		String strNotParticipatingET = objEvent_data.strNotParticipating;

		String strstatusTypeNames[] = new String[10];
		
		String strAllStatusTypeNames[] = new String[5];
		
		String strAllStatusTypeNames1[] = new String[5];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}

		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}
		
		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames1[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 9 + intCount, strFilePath);
		}

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		// User creation
		UsersList_page
		.navigateToUsers()
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName,
				objUser_data.strNewPassword, objUser_data.strFullName)
		.selectFirstRole()
		.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
		.enterEmail(objUser_data.strPrimaryMailId)
		.entertextPagerId(objUser_data.strPrimaryMailId)
		.selectUpdateStatusOfResource(strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton()
		.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)
		.clickRegionsLinkForUser(objUser_data.strNewUserName)
		.selectRegion(strRegionValue[1])
		.clickSaveButton();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page.selectFrame();

		UsersList_page
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(strResourceName1)
				.selectViewResourceRights(strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.verifySaveButton()
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyEditUserPageIsDisplayed()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUser_data.strNewUserName);
		System.out.println(strEventTemplate1);
		System.out.println(strEventTemplate);
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate1)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();
		
		login_page.clickLogOut();
		
		System.out
		.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1
				.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton()
				.verifyEventName(objEvent_data.strEventName)
				.clickOnEditLink(objEvent_data.strEventName)
				.selectEventTemplateForMRE(strRegionValue[1],
						strNotParticipatingET)
				.clickOnNextButton()
				.verifyRegionName(strRegionNames[0])
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessageForChangesMade()
				.clickOnYesButton()
				.verifyEventName(objEvent_data.strEventName)
				.verifyEventNameInEventBanner(
						objEvent_data.strUpdateEventName)
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
				.verifyEditEventLink(objEvent_data.strEventName)
				.verifyEndEventLink(objEvent_data.strEventName);
		
		SelectRegion_page1
		.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page1.selectFrame();
		
		EventManagement_page1
				.navigateToEventManagement()
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strEnded)
				.verifyEditEventIsNotDisplayed(objEvent_data.strEventName)
				.verifyViewHistoryLink(objEvent_data.strEventName);
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	:  Verify that user with appropriate right and without access to 
	 * 					  all the regions that are involved in MRE should not be able to 
	 * 					  update the event.
	 * 'Precondition	: 
	 * 'Date 			: 03-Mar-2016 
	 * 'Author 			: Pallavi
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that user with appropriate right and without access to all the regions that are involved"
			+ " in MRE should not be able to update the event.")
	public void testEdgeCase135644() throws Exception {

		gstrTCID = "135644";
		gstrTO = "Verify that user with appropriate right and without access to all the regions that are "
				+ "involved in MRE should not be able to update the event.";

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

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strStatusTypeValues2[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValue1[] = new String[1];
		String strResourceTypeValue2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strResourceValue2[] = new String[1];
		String strRegionValue[] = new String[3];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		String[] strAllRegions = { objLogindata.strRegionName,
				objLogindata.strRegionName1, objLogindata.strRegionName2 };

		objSelectRegionpage.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page.getRegionValue(strAllRegions[0]);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page.getRegionValue(strAllRegions[1]);

		System.out.println(strRegionValue[1]);

		strRegionValue[2] = objRegions_page.getRegionValue(strAllRegions[2]);

		System.out.println(strRegionValue[2]);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

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
				.clickOnSaveButton()
				.clickOnViewResChkBox()
				.clickOnSaveButton();

		System.out.println(objResource_data.strResourceName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[0])
				.selectRegion(strRegionValue[1])
				.selectRegion(strRegionValue[2])
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName1)
				.selectRegion(strRegionValue[0])
				.selectRegion(strRegionValue[1])
				.selectRegion(strRegionValue[2])
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName1);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllWebOption();

		System.out.println(objESetUp_data.strEventTemplate);

		objSelectRegionpage.selectRegionAndNavigate(strAllRegions[1]);

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
				.clickOnSaveButton()
				.clickOnViewResChkBox()
				.clickOnSaveButton();

		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate1,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue1, strStatusTypeValues1)
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllWebOption();

		System.out.println(objESetUp_data.strEventTemplate1);

		objSelectRegionpage.selectRegionAndNavigate(strAllRegions[2]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		System.out.println(objStatusTypes_data.strSSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType
				.createResourceType(objResourceType_data.strResourceTypeName2,
						strStatusTypeValues2);

		strResourceTypeValue2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName2);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName2)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName2)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton()
				.clickOnViewResChkBox()
				.clickOnSaveButton();

		strResourceValue2[0] = objResource
				.getResourceValue(objResource_data.strResourceName2);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.selectUserRegion(strRegionValue[2])
				.clickSaveButton()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.clickSaveButton()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objESetUp_data.strEventTemplate2,
						objESetUp_data.strTemplateDefinition,
						strResourceTypeValue2, strStatusTypeValues2)
				.deselectSelectAllWebOptionOnly().clickSaveButton();

		System.out.println(objESetUp_data.strEventTemplate2);

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends, execution starts-----");
		
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
				.selectEventTemplateForMRE(strRegionValue[2],
						objESetUp_data.strEventTemplate2)
				.clickOnNextButton()
				.verifyRegionAndETName(strAllRegions[0],
						objESetUp_data.strEventTemplate)
				.verifyRegionAndETName(strAllRegions[1],
						objESetUp_data.strEventTemplate1)
				.verifyRegionAndETName(strAllRegions[2],
						objESetUp_data.strEventTemplate2)
				.clickOnYesButton();

		System.out.println(objEvent_data.strMultiRegionEvent);

		objEventManagement1.verifyEventNameInEventBanner(
									objEvent_data.strMultiRegionEvent)
						   .verifyEventName(
								   objEvent_data.strMultiRegionEvent)
						   .navigateToEventManagement()
						   .verifyEditEventLink(
								   objEvent_data.strMultiRegionEvent)
						   .verifyEndEventLink(
								   objEvent_data.strMultiRegionEvent);

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[2]);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.verifyEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent)
			   .verifyEventName(
					   objEvent_data.strMultiRegionEvent)
//			   .navigateToEventManagement()
			   .verifyEditEventLink(
					   objEvent_data.strMultiRegionEvent)
			   .verifyEndEventLink(
					   objEvent_data.strMultiRegionEvent);

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[1]);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.verifyEventNameInEventBanner(objEvent_data.strMultiRegionEvent)
				.navigateToEventManagement()
				.verifyEditEventLink(objEvent_data.strMultiRegionEvent)
				.verifyEndEventLink(objEvent_data.strMultiRegionEvent)
				.verifyEventStatus(objEvent_data.strMultiRegionEvent,
						objEvent_data.strOngoing);

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.verifyEventNameInEventBanner(
						objEvent_data.strMultiRegionEvent)
			   .verifyEventName(
					   objEvent_data.strMultiRegionEvent)
			   .verifyEditEventLink(
					   objEvent_data.strMultiRegionEvent)
			   .verifyEndEventLink(
					   objEvent_data.strMultiRegionEvent);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objSelectRegionpage1.selectRegionAndNavigate(strAllRegions[0]);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.verifyEditEventIsNotDisplayed(
						objEvent_data.strMultiRegionEvent)
				.verifyEndEventIsNotDisplayed(
						objEvent_data.strMultiRegionEvent);
				
		gstrResult = "PASS";
	}
}
