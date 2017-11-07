package requirementGroup.SettingUpRoles;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class RightsToViewUpdatePrivateStatusTypes extends TestNG_UI_EXTENSIONS {

	public RightsToViewUpdatePrivateStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*******************************************************************************************
	'Description 	: Verify that a role can be saved by selecting a private status type under Select the Status Types this Role may update: section.
	'Date 			: 04-Jan-2016 
	'Author 		: Renushree
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	                  Modified By
	'Date					                                              Name
	********************************************************************************************/
	@Test(description = "Verify that a role can be saved by selecting a private status type under Select the Status Types this Role may update: section.")
	public void testHappyDay49738() throws Exception {

		gstrTCID = "49738";
		gstrTO = "Verify that a role can be saved by selecting a private status type under Select the Status Types this Role may update: section.";

		Login_data objTest_data = new Login_data();
		Roles_data objRolesdata = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);

		String strRoleValue[] = new String[1];
		String strStatusTypeValues[] = new String[1];

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesdata.strRoleName)
				.deSelectAllCheckboxInRolesMayUpdatesec()
				.deSelectAllCheckboxInRolesMayViewsec().clickOnSaveBtn()
				.verifyCreatedRoleInRolesList(objRolesdata.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesdata.strRoleName);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strNumberStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strNSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectPrivateStatusTypeRadioBtn()
				.deSelectRoleUnderRolesWithViewRight()
				.deSelectRoleUnderRolesWithUpdateRight().clickOnSaveButton();

		objStatusTypeList1
				.verifyStatusTypeInList(objStatusTypes_data.strNSTStatusTypeName);

		strStatusTypeValues[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnEditLinkOfRole(objRolesdata.strRoleName)
				.verifyEditRolePageIsDisplayed()
				.verRoleMayUpdateChkBoxIsUnchecked(strStatusTypeValues[0])
				.verRoleMayViewChkBoxIsDisabled(strStatusTypeValues[0])
				.verRoleMayViewChkBoxIsChecked(strStatusTypeValues[0])
				.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues[0])
				.clickOnSaveBtn();

		objRoles1.clickOnEditLinkOfRole(objRolesdata.strRoleName)
				.verRoleMayViewChkBoxIsDisabled(strStatusTypeValues[0])
				.verRoleMayViewChkBoxIsChecked(strStatusTypeValues[0])
				.verRoleMayUpdateChkBoxIsSelected(strStatusTypeValues[0])
				.clickOnSaveBtn();

		objRoles1.clickOnCreateNewRoleBtn().verifyRoleListPageIsDisplayed()
				.enterRoleName(objRolesdata.strRoleName1)
				.verRoleMayUpdateChkBoxIsSelected(strStatusTypeValues[0])
				.verRoleMayViewChkBoxIsChecked(strStatusTypeValues[0])
				.verRoleMayViewChkBoxIsDisabled(strStatusTypeValues[0])
				.clickOnSaveBtn()
				.verifyCreatedRoleInRolesList(objRolesdata.strRoleName1);

		objRoles1.clickOnEditLinkOfRole(objRolesdata.strRoleName1)
				.verRoleMayViewChkBoxIsDisabled(strStatusTypeValues[0])
				.verRoleMayViewChkBoxIsChecked(strStatusTypeValues[0])
				.verRoleMayUpdateChkBoxIsSelected(strStatusTypeValues[0])
				.clickOnSaveBtn();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Create role R1 without selecting a private status type ST under ‘select the Status Types this Role may Update’ section & verify that ST can be viewed by any user with role R1 in the following setup pages:"
							+"a. Status Type List"
							+"b. Create/Edit Resource Type"
							+"c. Create/Edit Role"
							+"d. Edit Resource Level Status Types"
							+"e. Create New/Edit/Copy View"
							+"f. Edit Resource Detail View Sections"
							+"g. Create/Edit Event Temp"
							+"e. Edit event"
							+"f. While configuring the form 
	'Precondition:
	'Date	 	 : 05-Jan-2016
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Create role R1 without selecting a private status type ST under ‘select the Status Types this Role may Update’ section & verify that ST can be viewed by any user with role R1 in the following setup pages:"
			+ "a. Status Type List"
			+ "b. Create/Edit Resource Type"
			+ "c. Create/Edit Role"
			+ "d. Edit Resource Level Status Types"
			+ "e. Create New/Edit/Copy View"
			+ "f. Edit Resource Detail View Sections"
			+ "g. Create/Edit Event Temp"
			+ "e. Edit event"
			+ "f. While configuring the form ")
	public void testHappyDay48964() throws Exception {

		gstrTCID = "48964";
		gstrTO = "Create role R1 without selecting a private status type ST under ‘select the Status Types this Role may Update’ section & verify that ST can be viewed by any user with role R1 in the following setup pages:"
				+ "a. Status Type List"
				+ "b. Create/Edit Resource Type"
				+ "c. Create/Edit Role"
				+ "d. Edit Resource Level Status Types"
				+ "e. Create New/Edit/Copy View"
				+ "f. Edit Resource Detail View Sections"
				+ "g. Create/Edit Event Temp"
				+ "e. Edit event"
				+ "f. While configuring the form ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		Roles_data objRolesdata = new Roles_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();

		Login objLogin = new Login(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strEveTemplateValue[] = new String[1];
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strNumberStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strNSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectPrivateStatusTypeRadioBtn()
				.deSelectRoleUnderRolesWithViewRight()
				.deSelectRoleUnderRolesWithUpdateRight().clickOnSaveButton();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

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

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				objStatusTypes_data.strNSTStatusTypeName);
//				.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusType(objStatusTypes_data.strNSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		System.out.println(objView_data.strViewName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);

		objEventManagement.clickOnSaveButton();

		strEveTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectSetUpRolesRight().selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionViewsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesdata.strRoleName)
				.deselectStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickOnSaveBtn()
				.verifyCreatedRoleInRolesList(objRolesdata.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesdata.strRoleName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strEquals)
				.editUserDetails(objUserdata.strNewUserName)
				.selectRoleCheckBox(strRoleValue[0]).clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objStatusTypes_data.strNSTStatusTypeName);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType1.clickOnCreateNewResourceTypeButton()
				.verifyStatusTypeIsListed(strStatusTypeValues);

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn()
				.verRoleMayViewChkBoxIsDisabled(strStatusTypeValues[0])
				.verRoleMayUpdateChkBoxIsEnabled(strStatusTypeValues[0]);

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnEditLinkOfRole(objRolesdata.strRoleName)
				.verRoleMayViewChkBoxIsDisabled(strStatusTypeValues[0])
				.verRoleMayUpdateChkBoxIsEnabled(strStatusTypeValues[0])
				.clickOnSaveBtn();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1.clickOnStatusTypeLinkInResourcePage(
				objResource_data.strResourceName)
				.verifyStatusTypeIsDisplayedUnderEditResLevelST(
						objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickCreateNewViewButton()
					 .clickOnRegionsTab()
					 .selectRegionName(objLogindata.strRegionName)
					 .clickNextButton()
					 .selectResource(objResource_data.strResourceName)
					 .clickNextButton()
					 .verStatusTypeInViewUnderSetup(
				objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickOnEditLinkOfView(objView_data.strViewName)
					 .clickOnSTTab()
					 .verStatusTypeInViewUnderSetup(
							objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickOnCopyLinkOfView(objView_data.strViewName)
					 .clickOnSTTab()
					 .verStatusTypeInViewUnderSetup(
						objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1
				.clickOncustomizeResourceDetailView()
				.clickOnUncategorized()
				.verStatusTypesInList(objStatusTypes_data.strNSTStatusTypeName,
						strStatusTypeValues[0]);

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOncreateEventTemplate()
				.verifyStatusTypeIsDispInCreateNewEventTemp(
						objStatusTypes_data.strNSTStatusTypeName);

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
				.verifyStatusTypeIsDispInCreateNewEventTemp(
						objStatusTypes_data.strNSTStatusTypeName);

		objEventManagement1.navigateToEventManagementNew()
				.clickOnEditLink(objEvent_data.strEventName)
				.verifyStatusTypesIsSelected(strStatusTypeValues[0]);

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strAsCertainStatusChanges)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.verifyStatusTypeIsDisplayed(
						objStatusTypes_data.strNSTStatusTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
