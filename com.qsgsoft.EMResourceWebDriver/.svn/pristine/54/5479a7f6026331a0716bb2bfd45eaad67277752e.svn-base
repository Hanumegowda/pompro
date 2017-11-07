package requirementGroup.CreatingAndManagingEvents;

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
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEventlists extends TestNG_UI_EXTENSIONS {
	
	public NewEventlists() throws Exception {
		super();
	}

	/*************************************************************************************
	 * 'Description 	: Verify that events are listed in the 'Events List' screen for all users. 
	 * 'Precondition	: 
	 * 'Date 			: 17-Jun-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that events are listed in the 'Events List' screen for all users. ")
	public void testHappyDay68339() throws Exception {

		gstrTCID = "68339";
		gstrTO = "Verify that events are listed in the 'Events List' screen for all users. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.clickSaveButton();

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		System.out.println(objResourceType_data.strResourceTypeName);
		
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

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
		.clickOncreateEventTemplate()
		.enterEventTemplateName(objESetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(
				objESetUp_data.strTemplateDefinition)
		.selectStatusType(strStatusTypeValues[0])
		.selectResourceType(strResourceTypeValue[0])
		.selectSecurityOption()
		.clickSaveButton()
		.deselectSelectAllWebOption()
		.verEveTemplateInList(objESetUp_data.strEventTemplate)
		.clickOnSecurityOfEveTemplate(objESetUp_data.strEventTemplate)
		.selectUserInEveSecutityPage(objUserdata.strNewUserName)
		.clickSaveButton();
		
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);

		objEventManagement1.clickOnSaveButton();
		
		String strEventStartTime = objEventManagement1.getEventStartTime(objEvent_data.strEventName);
		String strEventEndTime = objEventManagement1.getEventEndTime(objEvent_data.strEventName);

		objEventManagement1
				.navigateToEventListNew()
				.verifyEventAction(objEvent_data.strEventName,
						objEvent_data.strViewAction)
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
				.verifyEventNameAndTemplate(objEvent_data.strEventName,
						objESetUp_data.strEventTemplate)
				.verifyEventStartTime(objEvent_data.strEventName,
						strEventStartTime)
				.verifyEventEndTime(objEvent_data.strEventName,
						strEventEndTime)
				.verifyEventInformation(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.verifyDrill(objEvent_data.strEventName,
						objEvent_data.strNo)
				.verifyEventMultiStatus(objEvent_data.strEventName,
						objEvent_data.strNo)
				.verifyEventIcon(objEvent_data.strEventName,
						objEvent_data.strEveAmbulanceIconVal);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventList()
				.verifyEventAction(objEvent_data.strEventName,
						objEvent_data.strViewAction)
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
				.verifyEventNameAndTemplate(objEvent_data.strEventName,
						objESetUp_data.strEventTemplate)
				.verifyEventStartTime(objEvent_data.strEventName,
						strEventStartTime)
				.verifyEventEndTime(objEvent_data.strEventName,
						strEventEndTime)
				.verifyEventInformation(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.verifyDrill(objEvent_data.strEventName,
						objEvent_data.strNo)
				.verifyEventMultiStatus(objEvent_data.strEventName,
						objEvent_data.strNo)
				.verifyEventIcon(objEvent_data.strEventName,
						objEvent_data.strEveAmbulanceIconVal);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
