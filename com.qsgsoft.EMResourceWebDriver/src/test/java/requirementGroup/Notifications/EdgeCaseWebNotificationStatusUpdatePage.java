package requirementGroup.Notifications;

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
import lib.page.UpdateStatus;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSThreeBrowser;

public class EdgeCaseWebNotificationStatusUpdatePage  extends TestNG_UI_EXTENSIONSThreeBrowser {

	public EdgeCaseWebNotificationStatusUpdatePage() throws Exception {
		super();
	}
	
	/******************************************************************
	'Description : Verify that when user is on update status screen of resource RS and the event is edited that contains the same resource, user receives web notification for event update 
	'Precondition:
	'Date	 	 : 28-Nov-2014
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that when user is on update status screen of resource RS and the event is edited that contains the same resource, user receives web notification for event update")
	public void testEdgeCase139703() throws Exception {

		gstrTCID = "139703";
		gstrTO = "Verify that when user is on update status screen of resource RS and the event is edited that contains the same resource, user receives web notification for event update";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		Login objLogin2 = new Login(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		EventManagement objEventManagement2 = new EventManagement(this.driver2);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strAdminUser,
				objTest_data.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusColor)
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,	objStatuTypes_data.strStatusColor)
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton();
				
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.selectFirstRole()
		.selectViewResourceRights(objResource_data.strResourceName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMustUpdateOverdueStatusOption()
		.clickSaveButton();
		
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)
				.clickOnWebNotification(objUserdata.strNewUserName, true)
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objUpdateStatus1.verUpdateStatusPge();
		
		objLogin2.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objRegionDefault2.selectFrame();

		objEventManagement2
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton();
		
		Thread.sleep(210000);
		
		objEventManagement1
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		objEventManagement2.clickOnEditLink(objEvent_data.strEventName)
						   .enterAdHocEventName(objEvent_data.strEditedEventName)
						   .enterAdHocEventDescription(
								   objEvent_data.strEditedEventDescription)
						   .clickOnSaveButton()
						   .verifyEventName(objEvent_data.strEditedEventName);
		
		String strEditedEvent = "Update 1: " + objEvent_data.strEditedEventName;
		
		objEventManagement2.verUpdateInEveBanner(strEditedEvent);
		
		Thread.sleep(210000);
		
		objEventManagement1
		.verWebNotificationframe()
		.verWebNotificationAndAcknowledge(strEditedEvent,
				objEvent_data.strEditedEventDescription)
		.clickAcknowledgeAllNotifications().selectFrame();
		
		objLogin1.clickLogOut();
		
		objLogin2.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Verify that when user is on update status screen of resource RS and the event is ended that contains the same resource, user receives end event web notification. 
	'Precondition:
	'Date	 	 : 28-Nov-2014
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that when user is on update status screen of resource RS and the event is ended that contains the same resource, user receives end event web notification.")
	public void testEdgeCase139707() throws Exception {

		gstrTCID = "139707";
		gstrTO = "Verify that when user is on update status screen of resource RS and the event is ended that contains the same resource, user receives end event web notification.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		Login objLogin2 = new Login(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		EventManagement objEventManagement2 = new EventManagement(this.driver2);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strAdminUser,
				objTest_data.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusColor)
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusColor)
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton();
				
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.selectFirstRole()
		.selectViewResourceRights(objResource_data.strResourceName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMustUpdateOverdueStatusOption()
		.clickSaveButton();
		
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)
				.clickOnWebNotification(objUserdata.strNewUserName, true)
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objUpdateStatus1.verUpdateStatusPge();
		
		objLogin2.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objRegionDefault2.selectFrame();

		objEventManagement2
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton();
		
		Thread.sleep(210000);
		
		objEventManagement1
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		objEventManagement2.clickOnEndEvent(objEvent_data.strEventName)
						   .verifyViewHistoryLink(objEvent_data.strEventName);
		
		objEventManagement2.verifyEventNotDisplayedInBanner(objEvent_data.strEventName);
		
		Thread.sleep(210000);
		
		objEventManagement1
		.verWebNotificationframe()
		.verWebNotificationAndAcknowledge(
				"Ended: " + objEvent_data.strEventName,
				objEvent_data.strEventEndDescription)
		.clickAcknowledgeAllNotifications().selectFrame();
		
		objLogin1.clickLogOut();
		
		objLogin2.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Verify that when user is on update status screen of resource RS and a MRE is edited that contains the same resource, user receives web notification for MRE update 
	'Precondition:
	'Date	 	 : 03-Dec-2014
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that when user is on update status screen of resource RS and a MRE is edited that contains the same resource, user receives web notification for MRE update")
	public void testEdgeCase139710() throws Exception {

		gstrTCID = "139710";
		gstrTO = "Verify that when user is on update status screen of resource RS and a MRE is edited that contains the same resource, user receives web notification for MRE update";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);

		Login objLogin2 = new Login(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		EventManagement objEventManagement2 = new EventManagement(this.driver2);
		SelectRegion objSelectRegion2 = new SelectRegion(this.driver2);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusTypeValuesInReg2[] = new String[2];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];

		objLogin.loginToApplication(objTest_data.strAdminUser,
				objTest_data.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objTest_data.strRegionName1);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objTest_data.strRegionName2);

		System.out.println(strRegionValue[1]);
		
		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName1)
				.selectRegion(strRegionValue[1]).clickSaveButton();
				
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMustUpdateOverdueStatusOption().clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)
				.clickOnWebNotification(objUserdata.strNewUserName, true)
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName2);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streNSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton().clickSaveButton();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.selectFirstRole()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(objEventSetUp_data.strEventTemplate1,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValueInReg2, strStatusTypeValuesInReg2)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate1)
				.clickOnWebNotification(objUserdata.strNewUserName, true)
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate1);
		
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName1);

		objRegionDefault1.selectFrame();

		objUpdateStatus1.verUpdateStatusPge();

		objLogin2.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault2.selectFrame();

		objSelectRegion2.selectRegionAndNavigate(objTest_data.strRegionName2);
		
		objRegionDefault2.selectFrame();

		objEventManagement2
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objEventSetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objEventSetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage().clickOnYesButton();
		
		Thread.sleep(210000);
		
		objEventManagement1
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();
		
		objEventManagement2.clickOnEditLink(objEvent_data.strEventName)
						   .enterAdHocEventName(objEvent_data.strEditedEventName)
						   .enterAdHocEventDescription(
					           objEvent_data.strEditedEventDescription)
					       .clickOnNextButton()
					       .clickOnNextButton()
					       .clickOnNextButton()
					       .clickOnYesButton()
					       .verifyEventName(objEvent_data.strEditedEventName);
	
		String strEditedEvent = "Update 1: " + objEvent_data.strEditedEventName;
	
		objEventManagement2.verUpdateInEveBanner(strEditedEvent);
	
		Thread.sleep(210000);
	
		objEventManagement1
					.verWebNotificationframe()
					.verWebNotificationAndAcknowledge(strEditedEvent,
							objEvent_data.strEditedEventDescription)
					.clickAcknowledgeAllNotifications().selectFrame();
	
		objLogin1.clickLogOut();
	
		objLogin2.clickLogOut();
		
		gstrResult = "PASS";		
	}
	
	/******************************************************************
	'Description : Verify that when user is on update status screen of resource RS and MRE is ended that contains the same resource, user receives end MRE web notification. 
	'Precondition:
	'Date	 	 : 03-Dec-2014
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that when user is on update status screen of resource RS and MRE is ended that contains the same resource, user receives end MRE web notification.")
	public void testEdgeCase139711() throws Exception {

		gstrTCID = "139711";
		gstrTO = "Verify that when user is on update status screen of resource RS and MRE is ended that contains the same resource, user receives end MRE web notification.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);

		Login objLogin2 = new Login(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		EventManagement objEventManagement2 = new EventManagement(this.driver2);
		SelectRegion objSelectRegion2 = new SelectRegion(this.driver2);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusTypeValuesInReg2[] = new String[2];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];

		objLogin.loginToApplication(objTest_data.strAdminUser,
				objTest_data.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objTest_data.strRegionName1);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objTest_data.strRegionName2);

		System.out.println(strRegionValue[1]);
		
		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName1)
				.selectRegion(strRegionValue[1]).clickSaveButton();
				
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMustUpdateOverdueStatusOption().clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate)
				.clickOnWebNotification(objUserdata.strNewUserName, true)
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName2);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streNSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName1)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton().clickSaveButton();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.selectFirstRole()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(objEventSetUp_data.strEventTemplate1,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValueInReg2, strStatusTypeValuesInReg2)
				.deselectSelectAllWebOption()
				.navigateToEventNotificationPreferences(
						objEventSetUp_data.strEventTemplate1)
				.clickOnWebNotification(objUserdata.strNewUserName, true)
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate1);
		
		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName1);

		objRegionDefault1.selectFrame();

		objUpdateStatus1.verUpdateStatusPge();

		objLogin2.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault2.selectFrame();

		objSelectRegion2.selectRegionAndNavigate(objTest_data.strRegionName2);
		
		objRegionDefault2.selectFrame();

		objEventManagement2
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objEventSetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objEventSetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage().clickOnYesButton();
		
		Thread.sleep(210000);
		
		objEventManagement1
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();
		
		objEventManagement2.clickOnEndEvent(objEvent_data.strEventName)
		   .verifyViewHistoryLink(objEvent_data.strEventName);
		
		objEventManagement2.verifyEventNotDisplayedInBanner(objEvent_data.strEventName);
		
		Thread.sleep(210000);
		
		objEventManagement1
						.verWebNotificationframe()
						.verWebNotificationAndAcknowledge(
								"Ended: " + objEvent_data.strEventName,
								objEvent_data.strEventEndDescription)
						.clickAcknowledgeAllNotifications().selectFrame();
		
		objLogin1.clickLogOut();
		
		objLogin2.clickLogOut();

		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Verify that when user is on update status screen and any other user edits the system notification in that region, user receives web notification. 
	'Precondition:
	'Date	 	 : 05-Dec-2014
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that when user is on update status screen and any other user edits the system notification in that region, user receives web notification.")
	public void testEdgeCase139733() throws Exception {

		gstrTCID = "139733";
		gstrTO = "Verify that when user is on update status screen and any other user edits the system notification in that region, user receives web notification.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		Login objLogin2 = new Login(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		SelectRegion objSelectRegion2 = new SelectRegion(this.driver2);
		Regions objRegions_page2 = new Regions(this.driver2);
		NavigationToSubMenus objNavigationToSubMenus2 = new NavigationToSubMenus(
				this.driver2);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strAdminUser,
				objTest_data.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToRegions();

		objRegions_page.clickManageSysNotification();

		String strTitle = objRegions_page.getTitleMessage();
		String strDescMessage = objRegions_page.getDescriptionMessage();

		objRegions_page.selActivechkbox().clickSaveButton();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusColor)
		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMustUpdateOverdueStatusOption().clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickSystemNotificationPreferences()
				.clickSystemNotificationsWebCheckBox().clickSaveButton()
				.clickOnOkButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objUpdateStatus1.verUpdateStatusPge();

		objLogin2.loginToApplication(objTest_data.strAdminUser,
				objTest_data.strAdminUserPwd);

		objRegionDefault2.selectFrame();

		objSelectRegion2.selectRegionAndNavigate(objTest_data.strRegionName1);

		objRegionDefault2.selectFrame();

		objNavigationToSubMenus2.navigateToRegions();

		objRegions_page2.clickManageSysNotification()
				.verEditSystemNotificationPage().selActivechkbox()
				.clickSaveButton().clickManageSysNotification()
				.verEditSystemNotificationPage().selActivechkbox()
				.clickSaveButton();

		objEventManagement1.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(strTitle, strDescMessage)
				.clickAcknowledgeAllNotifications().selectFrame();

		objLogin1.clickLogOut();

		objLogin2.clickLogOut();
	}
}
