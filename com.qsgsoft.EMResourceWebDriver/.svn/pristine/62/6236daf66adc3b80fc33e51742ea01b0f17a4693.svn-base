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

public class NewEdgeCaseEditEventTemplate extends TestNG_UI_EXTENSIONS{

	public NewEdgeCaseEditEventTemplate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*******************************************************************************************
	'Description 	: Verify that event template can be edited by updating data in only mandatory fields
	'Date 			: 23-Feb-2016 
	'Author 		: Pallavi
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that event template can be edited by updating data in only mandatory fields")
	public void testEdgeCase109420() throws Exception {

		gstrTCID = "109420";
		gstrTO = "Verify that event template can be edited by updating data in only mandatory fields";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		Roles_data objRolesData = new Roles_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String[] strRoleValue = new String[1];
		
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

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(
						objRolesData.strRoleName)
				.clickOnSaveBtn();
		
		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectUpdateStatusOfResource(
						objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.clickSaveButton();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
						strStatusTypeValues)				
					 .deselectSelectAllWebOptionOnly()
					 .clickSaveButton();

		objLogin.clickLogOut();
		
		System.out.println(objEventSetUp_data.strEventTemplate);
		System.out.println(objUser_data.strNewUserName);
		System.out.println(objResource_data.strResourceName);
		System.out.println("--------Precondition ends Execution starts--------");
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
						objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToEventMenu();
		
		objEventManagement1
				.navigateToEventManagementNew()
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
				.verifyEventName(objEvent_data.strEventName);
		
		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1.verEveTemplateListScreenIsDisplayed()
					  .clickOnEditTempLink(
						objEventSetUp_data.strEventTemplate)
					  .enterEventTemplateName(
							  objEventSetUp_data.strEDITEventTemplate)
					  .enterEventTemplateDefintion(
							  objEventSetUp_data.strEDITemplateDefn)
					  .selectETColor(objEventSetUp_data.strETBlueColor)
					  .selectETIcon(objEventSetUp_data.strETAmbulance);
		
		objEventSetUp1.clickSaveButton()
					  .verifyEventTempName(
							  objEventSetUp_data.strEDITEventTemplate)
					  .verEveTemplateIcon(
							  objEventSetUp_data.strEDITEventTemplate,
							  objEventSetUp_data.strAmbulanceIcon)
					  .verEveTemplateDescription(
							  objEventSetUp_data.strEDITEventTemplate, 
							  objEventSetUp_data.strEDITemplateDefn);
		
		objEventManagement1.navigateToEventListNew()
						   .verifyEventNameAndTemplate(objEvent_data.strEventName,
								   objEventSetUp_data.strEDITEventTemplate)
				.verEventColorAndIconInEventBanner(objEvent_data.strEventName,
						objEventSetUp_data.strETBlueColor,
						objEventSetUp_data.strAmbulanceIcon);
		
		objEventManagement1
				.navigateToEventManagementNew()
				.verifyEventNameAndTemplate(objEvent_data.strEventName,
						objEventSetUp_data.strEDITEventTemplate)
				.verifyEventIcon(objEvent_data.strEventName,
						objEventSetUp_data.strAmbulanceIcon);

		gstrResult = "PASS";
	}

	/*******************************************************************************************
	'Description 	: Edit an event template and select the Security option and verify that:
                     a. Security option is available for the template on the event template list screen.
                     b. The template is not available for any of the users in Event List screen.
	'Date 			: 23-Feb-2016
	'Author 		: Sangappa K
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = " Edit an event template and select the Security option and verify that:"+
                        "a. Security option is available for the template on the event template list screen."+
                        "b. The template is not available for any of the users in Event List screen.")
	public void testEdgeCase109422() throws Exception {

		gstrTCID = "109422";
		gstrTO = " Edit an event template and select the Security option and verify that:"+
                   "a. Security option is available for the template on the event template list screen."+
                   "b. The template is not available for any of the users in Event List screen.";

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
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

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

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		System.out.println(objUser_data.strNewUserName1);

		// create Event template

		objLogin.clickLogOut();

		System.out
				.println("---------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventSetUp1.navigateToEventSetUp();

		System.out.println(objEventSetUp_data.strEventTemplate);

		objEventSetUp1
				.clickOncreateEventTemplate()

				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectSecurityOption()
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strStatusTypeValues[0])
				.clickSaveButton()
				.deselectSelectAllWebOptionOnly()
				.clickSaveButton()
				.verEveTemplateDescription(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition)
				.verifyEditTempLinkIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verifySecurityLinkForTempIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnSecurityOfEveTemp(objEventSetUp_data.strEventTemplate)
				.verUsersListedInEveSecurityPage(objUser_data.strNewUserName)
				.verUsersListedInEveSecurityPage(objUser_data.strNewUserName1)
				.selectUserInEveSecutityPage(objUser_data.strNewUserName)
				.clickSaveButton();

		objRegionDefault1.clickOnHomeButton();
		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);
		objResource1.clickResource(strResourceValue);
		objEventManagement1.clickOnSaveButton();

		System.out.println(objEvent_data.strEventName);

		objRegionDefault1.clickOnHomeButton();

		objNavigationToSubMenus1.navigateToEventList();

		objEventManagement1.verifyEventName(objEvent_data.strEventName);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame().clickOnHomeButton();

		objEventManagement1.navigateToEventManagement();

		objEventManagement1
				.verifyEventName(objEvent_data.strEventName)
				.verifyEditEventIsNotDisplayed(objEvent_data.strEventName)
				.verifyEndEventIsNotDisplayed(objEvent_data.strEventName)
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsNotDisplayed(
						objEventSetUp_data.strEventTemplate);
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*******************************************************************************************
	'Description 	: Create an event template ET selecting status type ST1 and resource type RT, create an event EVE1 under ET selecting resource RS, edit the template and add ST2, create a new event EVE2 under ET selecting resource RS and verify that:
                      a. In the event detail view of EVE1, only ST1 is displayed.
                      b. In the event detail view of EVE2, both ST1 and ST2 are displayed.
	'Date 			: 24-Feb-2016
	'Author 		: Sangappa K
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Create an event template ET selecting status type ST1 and resource type RT, create an event EVE1 under ET selecting resource RS, edit the template and add ST2, create a new event EVE2 under ET selecting resource RS and verify that:"
                       + "a. In the event detail view of EVE1, only ST1 is displayed."
                        +"b. In the event detail view of EVE2, both ST1 and ST2 are displayed.")
	public void testEdgeCase109425() throws Exception {

		gstrTCID = "109425";
		gstrTO ="Create an event template ET selecting status type ST1 and resource type RT, create an event EVE1 under ET selecting resource RS, edit the template and add ST2, create a new event EVE2 under ET selecting resource RS and verify that:"
                + "a. In the event detail view of EVE1, only ST1 is displayed."
                +"b. In the event detail view of EVE2, both ST1 and ST2 are displayed.";

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
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		System.out.println(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

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

		String[] strSt1 = { strStatusTypeValues[0] };

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strSt1).clickOnSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strSt1)
				.deselectSelectAllWebOptionOnly().clickSaveButton();
		System.out.println(objEventSetUp_data.strEventTemplate);

		// User1 creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("---------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.clickOnHomeButton();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);
		objResource1.clickResource(strResourceValue);
		objEventManagement1.clickOnSaveButton();

		System.out.println(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		objEventStatus1
				.verifyEventStatus()
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strNSTStatusTypeName);

		objRegionDefault1.clickOnHomeButton();

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
				.selectStatusType(strStatusTypeValues[1]).clickSaveButton();

		objRegionDefault1.clickOnHomeButton();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName1)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);
		objResource1.clickResource(strResourceValue);
		objEventManagement1.clickOnSaveButton();

		System.out.println(objEvent_data.strEventName1);

		objEventManagement1.verifyEventName(objEvent_data.strEventName);

		objEventManagement1.verifyEventName(objEvent_data.strEventName1);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.verifyEventStatus()
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strNSTStatusTypeName)
				.verStatusTypeNotPresent(
						objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strTSTStatusTypeName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName1);

		objEventStatus1
				.verifyEventStatus()
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strNSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strTSTStatusTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*******************************************************************************************
	'Description 	: Create an event template ET selecting status types ST1, ST2 and resource type RT, create an event EVE1 under ET selecting resource RS, edit the template and remove ST2, create a new event EVE2 under ET selecting resource RS and verify that:
                     a. In the event detail view of EVE1, both ST1 and ST2 are displayed.
                     b. In the event detail view of EVE2, only ST1 is displayed.
	'Date 			: 24-Feb-2016
	'Author 		: Sangappa K
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Create an event template ET selecting status types ST1, ST2 and resource type RT, create an event EVE1 under ET selecting resource RS, edit the template and remove ST2, create a new event EVE2 under ET selecting resource RS and verify that:"
                        +"a. In the event detail view of EVE1, both ST1 and ST2 are displayed."
                        +"b. In the event detail view of EVE2, only ST1 is displayed.")
	public void testEdgeCase109426() throws Exception {

		gstrTCID ="109426";
		gstrTO ="Create an event template ET selecting status types ST1, ST2 and resource type RT, create an event EVE1 under ET selecting resource RS, edit the template and remove ST2, create a new event EVE2 under ET selecting resource RS and verify that:"
                +"a. In the event detail view of EVE1, both ST1 and ST2 are displayed."
                +"b. In the event detail view of EVE2, only ST1 is displayed.";

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
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		System.out.println(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

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

		String[] strSt1 = { strStatusTypeValues[0] };

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strSt1).clickOnSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOptionOnly().clickSaveButton();
		System.out.println(objEventSetUp_data.strEventTemplate);

		// User1 creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("---------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.clickOnHomeButton();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);
		objResource1.clickResource(strResourceValue);
		objEventManagement1.clickOnSaveButton();

		System.out.println(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		objEventStatus1
				.verifyEventStatus()
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strNSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strTSTStatusTypeName);

		objRegionDefault1.clickOnHomeButton();

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
				.deselectStatusType(strStatusTypeValues[1]).clickSaveButton();

		objRegionDefault1.clickOnHomeButton();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName1)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);
		objResource1.clickResource(strResourceValue);
		objEventManagement1.clickOnSaveButton();

		System.out.println(objEvent_data.strEventName1);

		objEventManagement1.verifyEventName(objEvent_data.strEventName);

		objEventManagement1.verifyEventName(objEvent_data.strEventName1);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.verifyEventStatus()
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strNSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strTSTStatusTypeName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName1);

		objEventStatus1
				.verifyEventStatus()
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strNSTStatusTypeName)
				.verStatusTypeNotPresent(
						objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strTSTStatusTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*******************************************************************************************
	'Description 	: Verify that event template can be edited by updating data in only mandatory fields
	'Date 			: 23-Feb-2016 
	'Author 		: Pallavi
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that data in all the fields can be edited for an event template")
	public void testEdgeCase118053() throws Exception {

		gstrTCID = "118053";
		gstrTO = "Verify that data in all the fields can be edited for an event template";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		Roles_data objRolesData = new Roles_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String[] strRoleValue = new String[1];
		
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
		objResource.navigateToResourceListPage()
				   .createResourceWithAddress(
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
				.enterRoleName(
						objRolesData.strRoleName)
				.clickOnSaveBtn();
		
		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectUpdateStatusOfResource(
						objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.clickSaveButton();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.clickOncreateEventTemplate()
					 .enterEventTemplateName(objEventSetUp_data.strEventTemplate)
					 .enterEventTemplateDefintion(objEventSetUp_data.strTemplateDefinition)
					 .enterDefaultEventName(objEventSetUp_data.strDefaultEventName)
					 .enterDefaultEventDefinition(objEventSetUp_data.strDefaultEventDefinition)
					 .selectETIcon(objEventSetUp_data.strAmberAlert)
					 .selectETColor(objEventSetUp_data.strETBlueColor)
					 .selectResourceType(strResourceTypeValue[0])
					 .selectStatusType(strStatusTypeValues[0])
					 .clickSaveButton()
					 .deselectSelectAllWebOptionOnly()
					 .clickSaveButton();
					 
		objLogin.clickLogOut();
		
		System.out.println(objEventSetUp_data.strEventTemplate);
		System.out.println(objUser_data.strNewUserName);
		System.out.println(objResource_data.strResourceName);
		System.out.println("--------Precondition ends Execution starts--------");
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
						objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToEventMenu();
		
		objEventManagement1
				.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEventDescription)
				.verAddressFieldsAreNotMandatory()
				.selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		
		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1.verEveTemplateListScreenIsDisplayed()
					  .clickOnEditTempLink(
						objEventSetUp_data.strEventTemplate)
					  .enterEventTemplateName(
							  objEventSetUp_data.strEDITEventTemplate)
					  .enterEventTemplateDefintion(
							  objEventSetUp_data.strEDITemplateDefn)
					  .enterDefaultEventName(objEventSetUp_data.strEditDefaultEventName)
					  .enterDefaultEventDefinition(objEventSetUp_data.strEditDefaultEventDefinition)
					  .selMandatoryAddInCreateTemplatePage()
					  .selectETColor(objEventSetUp_data.strETYelloColor)
					  .selectETIcon(objEventSetUp_data.strETAmbulance);
		
		objEventSetUp1.clickSaveButton()
					  .verifyEventTempName(
							  objEventSetUp_data.strEDITEventTemplate)
					  .verEveTemplateIcon(
							  objEventSetUp_data.strEDITEventTemplate,
							  objEventSetUp_data.strAmbulanceIcon)
					  .verEveTemplateDescription(
							  objEventSetUp_data.strEDITEventTemplate, 
							  objEventSetUp_data.strEDITemplateDefn);
		
		objEventManagement1.navigateToEventListNew()
						   .verifyEventNameAndTemplate(objEvent_data.strEventName,
								   objEventSetUp_data.strEDITEventTemplate)
							.verEventColorAndIconInEventBanner(
									objEvent_data.strEventName,
									objEventSetUp_data.strETYelloColor,
									objEventSetUp_data.strAmbulanceIcon);
		
		objEventManagement1
				.navigateToEventManagementNew()
				.verifyEventNameAndTemplate(objEvent_data.strEventName,
						objEventSetUp_data.strEDITEventTemplate)
				.verifyEventIcon(objEvent_data.strEventName,
						objEventSetUp_data.strAmbulanceIcon)
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEDITEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEDITEventTemplate)
				.verifyEventNameInCreateEventPage(objEventSetUp_data.strEditDefaultEventName)
				.verifyEventInfoInCreateEventPage(objEventSetUp_data.strEditDefaultEventDefinition)
				.verAddressFieldsAreMandatory()
				.enterAddress(objEventSetUp_data.strCity,
								objEventSetUp_data.strState,
								objEventSetUp_data.strCountry,
								objEventSetUp_data.strZipCode)
				.selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventName(objEventSetUp_data.strEditDefaultEventName);
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description 	: Verify that event template can be edited by updating data in only mandatory fields
	'Date 			: 23-Feb-2016 
	'Author 		: Pallavi
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that editing an event template can be cancelled")
	public void testEdgeCase109423() throws Exception {

		gstrTCID = "109423";
		gstrTO = "Verify that editing an event template can be cancelled";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		Roles_data objRolesData = new Roles_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String[] strRoleValue = new String[1];
		
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
		objResource.navigateToResourceListPage()
				   .createResourceWithAddress(
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
				.enterRoleName(
						objRolesData.strRoleName)
				.clickOnSaveBtn();
		
		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectUpdateStatusOfResource(
						objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.clickSaveButton();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues)				
			 .deselectSelectAllWebOptionOnly()
			 .clickSaveButton();
					 
		objLogin.clickLogOut();
		
		System.out.println(objEventSetUp_data.strEventTemplate);
		System.out.println(objUser_data.strNewUserName);
		System.out.println(objResource_data.strResourceName);
		System.out.println("--------Precondition ends Execution starts--------");
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
						objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToEventMenu();
		
		objEventManagement1
				.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEventDescription)
				.selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		
		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1.verEveTemplateListScreenIsDisplayed()
					  .clickOnEditTempLink(
						objEventSetUp_data.strEventTemplate)
					  .enterEventTemplateName(
							  objEventSetUp_data.strEDITEventTemplate)
					  .enterEventTemplateDefintion(
							  objEventSetUp_data.strEDITemplateDefn);
		
		objEventSetUp1.clickCancelButton()
					  .verifyEventTempName(
							  objEventSetUp_data.strEventTemplate)
					  .verEveTemplateDescription(
							  objEventSetUp_data.strEventTemplate, 
							  objEventSetUp_data.strTemplateDefinition);
		
		objEventManagement1.navigateToEventListNew()
						   .verifyEventNameAndTemplate(objEvent_data.strEventName,
								   objEventSetUp_data.strEventTemplate);
		
		objEventManagement1
				.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verETNotDisplayad(
							  objEventSetUp_data.strEDITEventTemplate);
		
		gstrResult = "PASS";
	}
}
