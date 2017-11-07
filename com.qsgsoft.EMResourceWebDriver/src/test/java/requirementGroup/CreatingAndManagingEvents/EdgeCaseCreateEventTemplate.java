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
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseCreateEventTemplate extends TestNG_UI_EXTENSIONS{

	public EdgeCaseCreateEventTemplate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*************************************************************************
	'Description	: Verify that creating an event template can be cancelled.
	'Date	 		: 23-Feb-2016
	'Author			: Anitha 
	**************************************************************************/
	
	@Test(description = "Verify that creating an event template can be cancelled.")
	public void testEdgeCase109413() throws Exception {

		gstrTCID = "109413";
		gstrTO = "Verify that creating an event template can be cancelled.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();
		
	    System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// create Event template
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
			    .selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues[0])
				.clickCancelButton()
				.verEveTemplateNotInList(objEventSetUp_data.strEventTemplate);

		EventManagement_page1
				.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.verifySelectEventTemplatePage()
				.verifyEventTemplateIsNotDisplayed(
						objEventSetUp_data.strEventTemplate);

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/************************************************************************************************
	'Description	: Create an Event Template associated with a Standard Event Type and verify that
	                  the Event Template is listed in the Event Template list along with the selected 
	                  Standard Event Type.
	'Date	 		: 23-Feb-2016
	'Author			: Anitha 
	*************************************************************************************************/
	
	@Test(description = "Create an Event Template associated with a Standard Event Type and verify that the"
			+ " Event Template is listed in the Event Template list along with the selected Standard Event Type.")
	public void testEdgeCase109414() throws Exception {

		gstrTCID = "109414";
		gstrTO = "Create an Event Template associated with a Standard Event Type and verify that the Event "
				+ "Template is listed in the Event Template list along with the selected Standard Event Type.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();
		
	    System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// create Event template
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectStdEventType(objEventSetUp_data.strStdEventType)
				.selectSecurityOption()
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues[0])
				.clickSaveButton()
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verAllcheckBoxes()
				.verUsersListedInEvePrefPage(objUser_data.strNewUserName)
				.deselectSelectAllWebOption()
				
				.selectInactiveEventTemplateCheckBox()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate)
				.verifyEditTempLinkIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verifyNotificationTempLinkIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verifySecurityLinkForTempIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verEveTemplateDescription(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition)
				.verEveTemplateIcon(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempIcon)
				.verStandardEventTypeID(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strStdEventType)
				.verEveTemplateIsActive(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempActive)
				.deSelectInactiveEventTemplateCheckBox();

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/************************************************************************************************
	'Description	: Verify that event can be created from a template associated with a Standard Event Type
	'Date	 		: 23-Feb-2016
	'Author			: Pallavi 
	*************************************************************************************************/
	
	@Test(description = "Verify that event can be created from a template associated with a Standard Event Type")
	public void testEdgeCase109415() throws Exception {

		gstrTCID = "109415";
		gstrTO = "Verify that event can be created from a template associated with a Standard Event Type";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objEventSetUp_data.strEventTemplate);

		login_page.clickLogOut();
		
	    System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// create Event template
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectETIcon(objEventSetUp_data.strAmberAlert)
				.selectETColor(objEventSetUp_data.strETBlueColor)
				.selectStdEventType(objEventSetUp_data.strStdEventType)
				.selectSecurityOption()
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues[0])
				.clickSaveButton()
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verAllcheckBoxes()
				.verUsersListedInEvePrefPage(objUser_data.strNewUserName)
				.deselectSelectAllWebOption()
				
				.selectInactiveEventTemplateCheckBox()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate)
				.verifyEditTempLinkIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verifyNotificationTempLinkIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verifySecurityLinkForTempIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verEveTemplateDescription(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition)
				.verEveTemplateIcon(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempIcon)
				.verStandardEventTypeID(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strStdEventType)
				.verEveTemplateIsActive(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempActive)
				.deSelectInactiveEventTemplateCheckBox()
				.clickOnSecurityOfEveTemplate(
						objEventSetUp_data.strEventTemplate)
				.selectUserInEveSecutityPage(objUser_data.strNewUserName)
				.clickSaveButton();

		objEventManagement1.navigateToEventManagementNew()
						   .clickOnCreateNewEvent()
						   .verifyEventTemplateIsDisplayed(
								objEventSetUp_data.strEventTemplate)
						   .clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
						   .enterAdHocEventName(objEvent_data.strEventName)
						   .enterAdHocEventDescription(
								objEvent_data.strEventDescription)
						   .enterAddress(objEventSetUp_data.strCity,
								objEventSetUp_data.strState,
								objEventSetUp_data.strCountry,
								objEventSetUp_data.strZipCode)
						   .selectResource(strResourceValue)
						   .clickOnSaveButton()
						   .verifyEventName(objEvent_data.strEventName)
						   .verEventColorAndIconInEventBanner(
								   objEvent_data.strEventName, objEventSetUp_data.strETBlueColor,
								   objEventSetUp_data.strEventTempIcon);
		
		login_page1.clickLogOut();

		gstrResult = "PASS";
	}

	/*******************************************************************************************
	'Description 	: Verify that user can create event templates with event colors Purple & Yellow.
	'Date 			: 1-Mar-2016 
	'Author 		: Sangappa K
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user can create event templates with event colors Purple & Yellow.s")
	public void testEdgeCase86060() throws Exception {

		gstrTCID = "86060";
		gstrTO = "Verify that user can create event templates with event colors Purple & Yellow.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

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

		objNavigationToSubmenus.navigateToRoles();

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objResource_data.strResourceName);
		System.out
				.println("--------Precondition ends Execution starts--------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		// create Event template
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectETColor(objEventSetUp_data.strETYelloColor)
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strStatusTypeValues[0]).clickSaveButton()
				.deselectSelectAllWebOption();

		System.out.println(objEventSetUp_data.strEventTemplate);

		objEventSetUp1
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate1)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectETColor(objEventSetUp_data.strETPurpuleColor)
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strStatusTypeValues[0]).clickSaveButton()
				.deselectSelectAllWebOption();

		System.out.println(objEventSetUp_data.strEventTemplate1);

		objRegionDefault1.clickOnHomeButton();

		objEventManagement1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate1)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		System.out.println(objEvent_data.strEventName);

		objEventManagement1
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate1)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate1)
				.enterAdHocEventName(objEvent_data.strEventName1)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName1);
		objRegionDefault1.clickOnHomeButton();

		objEventManagement1.verifyEventColorInEventBanner(
				objEvent_data.strEventName, objEventSetUp_data.strETYelloColor)
				.verifyEventColorInEventBanner(objEvent_data.strEventName1,
						objEventSetUp_data.strETPurpuleColor);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************
	'Description	:Create an event template ET by selecting status types ST1 and ST2 and
	                 resource types RT1 and RT2 where RT1 is associated with ST1 and RT2 is
	                 associated with ST2 and verify that the event detail screen of the event
	                 created under this template displays ST1 for RT1 and ST2 for RT2.
	'Date	 		: 2-Mar-2016 
	'Author			: Sangappa K 
	**************************************************************************/
	
	@Test(description = "Create an event template ET by selecting status types ST1 and ST2 and"
			+ " resource types RT1 and RT2 where RT1 is associated with ST1 and RT2 is associated "
			+ "with ST2 and verify that the event detail screen of the event created under this "
			+ "template displays ST1 for RT1 and ST2 for RT2.")
	public void testEdgeCase109412() throws Exception {

		gstrTCID = "109412";
		gstrTO = "Create an event template ET by selecting status types ST1 and ST2 and resource type"
				+ "s RT1 and RT2 where RT1 is associated with ST1 and RT2 is associated with ST2 and verify"
				+ " that the event detail screen of the event created under this template displays ST1 for RT1"
				+ " and ST2 for RT2.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strResourceValue[] = new String[2];
		String strstatusTypeValues1[] = new String[1];
		String strstatusTypeValues2[] = new String[1];
		String strResourceTypeValue[] = new String[2];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues1);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		ResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues2);

		strResourceTypeValue[1] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation1,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.selectAssosciateResourceRight(
						objResource_data.strResourceName1)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// create Event template
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectETColor(objEventSetUp_data.strETPurpuleColor)
				.selectETIcon(objEventSetUp_data.strETAmbulance)
				.selectResourceType(strResourceTypeValue[0])
				.selectResourceType(strResourceTypeValue[1])
				.selectStatusType(strstatusTypeValues1[0])
				.selectStatusType(strstatusTypeValues2[0]).clickSaveButton()
				.deselectSelectAllWebOption();

		System.out.println(objEventSetUp_data.strEventTemplate);

		RegionDefault_page1.clickOnHomeButton();

		EventManagement_page1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verifyResourceNameInCreateEventPage(
						objResource_data.strResourceName)
				.verifyResourceNameInCreateEventPage(
						objResource_data.strResourceName1)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		System.out.println(objEvent_data.strEventName);

		EventManagement_page1.verEventColorAndIconInEventBanner(
				objEvent_data.strEventName,
				objEventSetUp_data.strETPurpuleColor,
				objEventSetUp_data.strAmbulanceIcon)
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strNSTStatusTypeName)

				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName1,
						objResource_data.strResourceName1)

				.verStatusTypes(objResourceType_data.strResourceTypeName1,
						objStatusTypes_data.strTSTStatusTypeName);

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************
	 * 'Description :Create an event template ET by selecting status types ST1,
	 *               ST2 and resource type RT where RT is associated with status types ST1 and
	 *               ST2 and verify that the event detail screen of the event created under
	 *                this template displays both ST1 and ST2 for the resource type RT.
	 * 
	 * 'Date : 2-Mar-2016 
	 * 'Author : Sangappa K
	 **************************************************************************/
	
	@Test(description = "Create an event template ET by selecting status types ST1, ST2 and "
			+ "resource type RT where RT is associated with status types ST1 and ST2 and verify "
			+ "that the event detail screen of the event created under this template displays both"
			+ " ST1 and ST2 for the resource type RT.")
	public void testEdgeCase109411() throws Exception {

		gstrTCID = "109411";
		gstrTO = "Create an event template ET by selecting status types ST1, ST2 and resource type "
				+ "RT where RT is associated with status types ST1 and ST2 and verify that the event"
				+ " detail screen of the event created under this template displays both ST1 and ST2"
				+ " for the resource type RT.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues1[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues1);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// create Event template
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectETColor(objEventSetUp_data.strETPurpuleColor)
				.selectETIcon(objEventSetUp_data.strETAmbulance)
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues1[0])
				.selectStatusType(strstatusTypeValues1[1]).clickSaveButton()
				.deselectSelectAllWebOption();

		System.out.println(objEventSetUp_data.strEventTemplate);

		RegionDefault_page1.clickOnHomeButton();

		EventManagement_page1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verifyResourceNameInCreateEventPage(
						objResource_data.strResourceName)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		System.out.println(objEvent_data.strEventName);

		EventManagement_page1.verEventColorAndIconInEventBanner(
				objEvent_data.strEventName,
				objEventSetUp_data.strETPurpuleColor,
				objEventSetUp_data.strAmbulanceIcon)
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strNSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strTSTStatusTypeName);
		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************
	'Description	:Create an event template ET by selecting a status type ST1 and 
	                  resource type RT where RT is associated with two status types 
	                  ST1 and ST2 and verify that the event detail screen of the event
	                  created under this template displays only ST1 and not ST2 for the
	                  resource type RT.
	'Date	 		: 3-Mar-2016 
	'Author			: Sangappa K 
	**************************************************************************/
	
	@Test(description = "Create an event template ET by selecting a status type ST1 and resource "
			+ "type RT where RT is associated with two status types ST1 and ST2 and verify that the "
			+ "event detail screen of the event created under this template displays only ST1 and not "
			+ "ST2 for the resource type RT.")
	public void testEdgeCase109409() throws Exception {

		gstrTCID = "109409";
		gstrTO = "Create an event template ET by selecting a status type ST1 and resource type RT where RT"
				+ " is associated with two status types ST1 and ST2 and verify that the event detail screen "
				+ "of the event created under this template displays only ST1 and not ST2 for the resource type RT.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues1[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues1);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// create Event template
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectETColor(objEventSetUp_data.strETYelloColor)
				.selectETIcon(objEventSetUp_data.strAmberAlert)
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues1[1]).clickSaveButton()
				.deselectSelectAllWebOption();

		System.out.println(objEventSetUp_data.strEventTemplate);

		RegionDefault_page1.clickOnHomeButton();

		EventManagement_page1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verifyResourceNameInCreateEventPage(
						objResource_data.strResourceName)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		System.out.println(objEvent_data.strEventName);

		EventManagement_page1.verEventColorAndIconInEventBanner(
				objEvent_data.strEventName, objEventSetUp_data.strETYelloColor,
				objEventSetUp_data.strEventTempIcon)
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName)

				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strTSTStatusTypeName)

				.verStatusTypeNotPresent(
						objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strNSTStatusTypeName);
		login_page1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************
	'Description	:Create an event template ET by selecting a status type ST and resource type RT1 where
	                ST is associated with both RT1 and RT2 and verify that:
                     a. Resources under RT1 are available while creating an event under this template.
                     b. Resources under RT2 are not available while creating an event under this template.
	'Date	 		: 3-Mar-2016 
	'Author			: Sangappa K 
	**************************************************************************/
	
	@Test(description = "Create an event template ET by selecting a status type ST and resource type RT1 where ST "
			           + "is associated with both RT1 and RT2 and verify that:"+
                   "a. Resources under RT1 are available while creating an event under this template."+
                  "b. Resources under RT2 are not available while creating an event under this template.")
	public void testEdgeCase109410() throws Exception {

		gstrTCID = "109410";
		gstrTO = "Create an event template ET by selecting a status type ST and resource type RT1 where ST is "
				+ "associated with both RT1 and RT2 and verify that:"+
              "a. Resources under RT1 are available while creating an event under this template."+
              "b. Resources under RT2 are not available while creating an event under this template.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strResourceValue[] = new String[2];
		String strstatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[2];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues1);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		ResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues1);

		strResourceTypeValue[1] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.selectAssosciateResourceRight(
						objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		// create Event template
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectETColor(objEventSetUp_data.strETYelloColor)
				.selectETIcon(objEventSetUp_data.strAmberAlert)
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues1[0]).clickSaveButton()
				.deselectSelectAllWebOption();

		System.out.println(objEventSetUp_data.strEventTemplate);

		RegionDefault_page1.clickOnHomeButton();

		EventManagement_page1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verifyResourceNameInCreateEventPage(
						objResource_data.strResourceName)
				.verifyResourceNameNotDisplayedInCreateEventPage(
						objResource_data.strResourceName1)
				.selectResource(strResourceValue[0]).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		System.out.println(objEvent_data.strEventName);

		EventManagement_page1.verEventColorAndIconInEventBanner(
				objEvent_data.strEventName, objEventSetUp_data.strETYelloColor,
				objEventSetUp_data.strEventTempIcon)
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName)

				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strNSTStatusTypeName)

				.verResourceTypeAndResourceNameIsNotDisplayed(
						objResourceType_data.strResourceTypeName1,
						objStatusTypes_data.strNSTStatusTypeName)

				.verStatusTypeNotPresent(
						objResourceType_data.strResourceTypeName1,
						objStatusTypes_data.strNSTStatusTypeName);

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
		
}
