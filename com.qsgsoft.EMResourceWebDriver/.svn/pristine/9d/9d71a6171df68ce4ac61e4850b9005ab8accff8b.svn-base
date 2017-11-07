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
import lib.page.EventStatus;
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

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewMultiRegionEventsWithResourcesAndStatusTypes extends TestNG_UI_EXTENSIONS {

	public NewMultiRegionEventsWithResourcesAndStatusTypes() throws Exception {
		super();
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that 'Select Resources' page displays the appropriate resource types corresponding to the resources 
	 * 						available in their respective regions.
	 * 'Precondition	: 
	 * 'Date 			: 04-Dec-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = " Verify that 'Select Resources' page displays the appropriate resource types corresponding to the "
			+ "resources available in their respective regions.")
	public void testHappyDay135774() throws Exception {

		gstrTCID = "135774";
		gstrTO = " Verify that 'Select Resources' page displays the appropriate resource types corresponding to the "
				+ "resources available in their respective regions.";

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

		String strStatusTypeValues[] = new String[6];
		String strStatusTypeValuesInReg2[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];

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

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,	objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti2)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti3)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
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

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

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
				.clickOnNextButton()
				.verifyRegionName(strAllRegions[1])
				.verifyRSAndRTName(objResource_data.strResourceName1,
						objResourceType_data.strResourceTypeName1)
				.selectResource(strResourceValueInReg2)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************
	 * 'Description 	: Verify that status types cannot be added/removed to the ongoing multi region event. 
	 * 'Date 			: 04-Dec-2015 
	 * 'Author 			: Renushree
	 * '----------------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                                      Modified By 
	 * 'Date                                                                          Name
	 *******************************************************************************************************/
	@Test(description = "Verify that status types cannot be added/removed to the ongoing multi region event.")
	public void testHappyDay135650() throws Exception {

		gstrTCID = "135650";
		gstrTO = "Verify that status types cannot be added/removed to the ongoing multi region event. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);		
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);		
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strStatusTypeValuesInReg2[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];

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

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
			    .createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
		        .verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
			    .clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		String[] strStatusTypeValues1={strStatusTypeValues[0], strStatusTypeValues[1]};
		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues1)
				.deselectSelectAllWebOption();

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

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
					objStatusTypes_data.strStatusColor)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti2)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti3)
        .clickOnReturnToStatusTypeList();

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
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

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objUsersList.navigateToUsersNew()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName).selectFirstRole()
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		String[] strStatusTypeValues2 = { strStatusTypeValuesInReg2[0],
				strStatusTypeValuesInReg2[1] };
		objEventSetUp.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate1,
				objEventSetUp_data.strTemplateDefinition,
				strResourceTypeValueInReg2, strStatusTypeValues2)
				.deselectSelectAllWebOption();

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
				.selectEventTemplateForMRE(strRegionValue[0],
						objEventSetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objEventSetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.clickOnYesButton();
		
		String[] strStatusTypeName = { objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName };

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		for (int i = 0; i < strStatusTypeName.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeName[i]);
		}

		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
				.selectStatusType(strStatusTypeValues[2]).clickSaveButton();
		
		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verStatusTypeNotPresent(
				objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strTSTStatusTypeName);
		
		// 2Nd Region

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault1.selectFrame();
		
		String[] strStatusTypeName1 = { objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strNSTStatusTypeName1 };

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		for (int i = 0; i < strStatusTypeName.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName1,
					strStatusTypeName1[i]);
		}

		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate1)
				.selectStatusType(strStatusTypeValuesInReg2[2]).clickSaveButton();
		
		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verStatusTypeNotPresent(
				objResourceType_data.strResourceTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*****************************************************************************************************
	 * 'Description 	: Verify that when a multi region event is ended, statuses of event related status 
	 *                    types associated with the resources of the events gets cleared when there are no 
	 *                    other events associated with these resources. 
	 * 'Date 			: 04-Dec-2015 
	 * 'Author 			: Renushree
	 * '--------------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                                      Modified By 
	 * 'Date                                                                          Name
	 *****************************************************************************************************/
	@Test(description = " Verify that when a multi region event is ended, statuses of event related status "
			+ "types associated with the resources of the events gets cleared when there are no other events"
			+ " associated with these resources.")
	public void testHappyDay135645() throws Exception {

		gstrTCID = "135645";
		gstrTO = " Verify that when a multi region event is ended, statuses of event related status types "
				+ "associated with the resources of the events gets cleared when there are no other events"
				+ " associated with these resources.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		Event_data objEvent_data = new Event_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);		
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);	
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strStatusTypeValuesInReg2[] = new String[3];
		String strStatusValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];

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

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventStatusType(objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)
				
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
					objStatusTypes_data.strStatusColor)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)
        .clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
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
				.deselectSelectAllWebOption();

		objSelectRegionpage
				.selectRegionAndNavigate(strAllRegions[1]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
					objStatusTypes_data.strStatusColor);
		
		strStatusValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti3)
        .clickOnReturnToStatusTypeList();
		
		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
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

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objUsersList.navigateToUsersNew()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName).selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate1,
				objEventSetUp_data.strTemplateDefinition,
				strResourceTypeValueInReg2, strStatusTypeValuesInReg2)
				.deselectSelectAllWebOption();

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
				.selectEventTemplateForMRE(strRegionValue[0],
						objEventSetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objEventSetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.clickOnYesButton();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.clickOnUpdateStatusKey(objResource_data.strResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate)
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForTST).clickOnSaveButton();
		
		objUpdateStatus1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0], objView_data.strValueForUpdate)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[1],
						objStatusTypes_data.strStatusNameInMulti)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[2], objView_data.strValueForTST);
		// 2Nd Region

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.clickOnUpdateStatusKey(objResource_data.strResourceName1);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValuesInReg2[0],
						objView_data.strValueForUpdate)
				.selectMSTUpdateValue(strStatusTypeValuesInReg2[1],
						strStatusValues[1])
				.enterNSTAndTSTUpdateValue(strStatusTypeValuesInReg2[2],
						objView_data.strValueForTST).clickOnSaveButton();

		objUpdateStatus1
				.verifyUpdatedStatusValues(strResourceValueInReg2[0],
						strStatusTypeValuesInReg2[0],
						objView_data.strValueForUpdate)
				.verifyUpdatedStatusValues(strResourceValueInReg2[0],
						strStatusTypeValuesInReg2[1],
						objStatusTypes_data.strStatusNameInMulti2)
				.verifyUpdatedStatusValues(strResourceValueInReg2[0],
						strStatusTypeValuesInReg2[2],
						objView_data.strValueForTST);
		
		objEventManagement1
				.navigateToEventManagement()
				.clickOnEndEvent(objEvent_data.strEventName);
		
		objEventManagement1
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName1)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objEventSetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objEventSetUp_data.strEventTemplate1)
				.clickOnNextButton().clickOnYesButton()
				.clickOnEventNameInEventBanner(objEvent_data.strEventName1);

		objUpdateStatus1
				.verifyUpdatedStatusValues1(strResourceValueInReg2[0],
						strStatusTypeValuesInReg2[0])
				.verifyUpdatedStatusValues1(strResourceValueInReg2[0],
						strStatusTypeValuesInReg2[1])
				.verifyUpdatedStatusValues1(strResourceValueInReg2[0],
						strStatusTypeValuesInReg2[2]);
		
		// 1St Region

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName1);

		objUpdateStatus1
				.verifyUpdatedStatusValues1(strResourceValue[0],
						strStatusTypeValues[0])
				.verifyUpdatedStatusValues1(strResourceValue[0],
						strStatusTypeValues[1])
				.verifyUpdatedStatusValues1(strResourceValue[0],
						strStatusTypeValues[2]);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
		
	/*****************************************************************************************************
	 * 'Description 	: Verify that when a multi region event is ended, statuses of event related status 
	 *                    types associated with the resources participating in the event are NOT cleared 
	 *                    when there are other ongoing events associated with these resources.
	 * 'Date 			: 04-Dec-2015 
	 * 'Author 			: Renushree
	 * '--------------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                                      Modified By 
	 * 'Date                                                                          Name
	 *****************************************************************************************************/
	@Test(description = " Verify that when a multi region event is ended, statuses of event related status"
			+ " types associated with the resources participating in the event are NOT cleared when there "
			+ "are other ongoing events associated with these resources.")
	public void testHappyDay135646() throws Exception {

		gstrTCID = "135646";
		gstrTO = " Verify that when a multi region event is ended, statuses of event related status types "
				+ "associated with the resources participating in the event are NOT cleared when there are"
				+ " other ongoing events associated with these resources.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		Event_data objEvent_data = new Event_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);		
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);	
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strStatusTypeValuesInReg2[] = new String[3];
		String strStatusValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValueInReg2[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceValueInReg2[] = new String[1];
		String strRegionValue[] = new String[2];

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

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventStatusType(objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);
		
		strStatusValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplateWithMultiRegion(
						objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption();

		objSelectRegionpage
				.selectRegionAndNavigate(strAllRegions[1]);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createEventStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor);
		
		strStatusValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,objStatusTypes_data.strStatusColor)
		                 .verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti2)
                         .verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti3)
		.clickOnReturnToStatusTypeList();

		strStatusTypeValuesInReg2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValuesInReg2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1,
				strStatusTypeValuesInReg2);

		strResourceTypeValueInReg2[0] = objResourceType
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

		strResourceValueInReg2[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objUsersList.navigateToUsersNew()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName).selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate1,
				objEventSetUp_data.strTemplateDefinition,
				strResourceTypeValueInReg2, strStatusTypeValuesInReg2)
				.deselectSelectAllWebOption();

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
				.selectEventTemplateForMRE(strRegionValue[0],
						objEventSetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objEventSetUp_data.strEventTemplate1)
				.clickOnNextButton()
				.clickOnYesButton();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.clickOnUpdateStatusKey(objResource_data.strResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate)
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForTST).clickOnSaveButton();
		
		objUpdateStatus1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0], objView_data.strValueForUpdate)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[1],
						objStatusTypes_data.strStatusNameInMulti)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[2], objView_data.strValueForTST);
		// 2Nd Region

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.clickOnUpdateStatusKey(objResource_data.strResourceName1);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValuesInReg2[0],
						objView_data.strValueForUpdate)
				.selectMSTUpdateValue(strStatusTypeValuesInReg2[1],
						strStatusValues[1])
				.enterNSTAndTSTUpdateValue(strStatusTypeValuesInReg2[2],
						objView_data.strValueForTST).clickOnSaveButton();

		objUpdateStatus1
				.verifyUpdatedStatusValues(strResourceValueInReg2[0],
						strStatusTypeValuesInReg2[0],
						objView_data.strValueForUpdate)
				.verifyUpdatedStatusValues(strResourceValueInReg2[0],
						strStatusTypeValuesInReg2[1],
						objStatusTypes_data.strStatusNameInMulti2)
				.verifyUpdatedStatusValues(strResourceValueInReg2[0],
						strStatusTypeValuesInReg2[2],
						objView_data.strValueForTST);
		
		objEventManagement1.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName1)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						objEventSetUp_data.strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						objEventSetUp_data.strEventTemplate1)
				.clickOnNextButton().clickOnYesButton();
		
		objEventManagement1.clickOnEndEvent(
				objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName1);

		objUpdateStatus1
				.verifyUpdatedStatusValues(strResourceValueInReg2[0],
						strStatusTypeValuesInReg2[0],
						objView_data.strValueForUpdate)
				.verifyUpdatedStatusValues(strResourceValueInReg2[0],
						strStatusTypeValuesInReg2[1],
						objStatusTypes_data.strStatusNameInMulti2)
				.verifyUpdatedStatusValues(strResourceValueInReg2[0],
						strStatusTypeValuesInReg2[2],
						objView_data.strValueForTST);
		
		// 1St Region

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName1);

		objUpdateStatus1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0], objView_data.strValueForUpdate)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[1],
						objStatusTypes_data.strStatusNameInMulti)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[2], objView_data.strValueForTST);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
