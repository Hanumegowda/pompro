package requirementGroup.SettingUpStatusTypes;

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
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewPrivateStatusTypes extends TestNG_UI_EXTENSIONS {

	public NewPrivateStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*********************************************************************************************************************
	'Description :Create a private status type ST and verify that ST can be viewed by any user (non system admin) in the following setup pages even if the user does not have any resource rights on the associated resource:
						a. Status Type List
						b. Create New /Edit Resource Type
						c. Create /Edit Role
						d. Edit Resource Level Status Types
						e. Create New/Edit/Copy View
						f. Edit Resource Detail View Sections
						g. Create/Edit Event Template
						e. Edit event
						f. While configuring the form
	'Date		 : 28-Jan-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = "Create a private status type ST and verify that ST can be viewed by any user (non system admin) in the following setup pages even if the user does not have any resource rights on the associated resource:"
								+ "a. Status Type List"
								+ "b. Create New /Edit Resource Type"
								+ "c. Create /Edit Role"
								+ "d. Edit Resource Level Status Types"
								+ "e. Create New/Edit/Copy View"
								+ "f. Edit Resource Detail View Sections"
								+ "g. Create/Edit Event Template"
								+ "e. Edit event"
								+ "f. While configuring the form")
	public void testHappyDay48712() throws Exception {

		gstrTCID = "48712";
		gstrTO = "Create a private status type ST and verify that ST can be viewed by any user (non system admin) in the following setup pages even if the user does not have any resource rights on the associated resource:"
				+ "a. Status Type List"
				+ "b. Create New /Edit Resource Type"
				+ "c. Create /Edit Role"
				+ "d. Edit Resource Level Status Types"
				+ "e. Create New/Edit/Copy View"
				+ "f. Edit Resource Detail View Sections"
				+ "g. Create/Edit Event Template"
				+ "e. Edit event"
				+ "f. While configuring the form";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();

		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strEveTemplateValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Role-Based Status Types

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
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

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);

		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objNavigationToSubmenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusType(objStatusTypes_data.strNSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName);
		
		System.out.println(objView_data.strViewName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);

		objEventManagement.clickOnSaveButton();

		strEveTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUpdata.strEventTemplate);

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption().selectSetUpRolesRight()
				.selectFormUserMayActivateAndModifyFormsOption()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objStatusTypes_data.strNSTStatusTypeName);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
				.enterAdHocEventName(objEventdata.strEventName)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton()
				.verifyEventName(objEventdata.strEventName);

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1.createPrivateStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList1.createPrivateStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[1] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList1.createPrivateStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		objStatusTypeList1.createNewStatus(
			     objStatusTypes_data.strStatusNameInMulti,
			     objStatusTypes_data.strStatusColor)
			  .createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
			      objStatusTypes_data.strStatusColor)
			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti1)
			  .clickOnReturnToStatusTypeList();

		strStatusTypeValues1[2] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList1.createPrivateStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[3] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList1.createPrivateStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[4] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList1.createPrivateStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[5] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType1
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.clickStatusType(strStatusTypeValues1).clickOnSaveButton();

		String[] strStNames = { objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strDateStatusTypeName };

		objResourceType1.clickOnCreateNewResourceTypeButton();

		for (int i = 0; i < strStNames.length; i++) {
			objResourceType1.verifyStatusTypeNameIsListed(strStNames[i]);
		}

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnEditLinkOfRole(objRolesData.strRoleName);

		for (int i = 0; i < strStatusTypeValues1.length; i++) {
			objRoles1.verRoleMayViewChkBoxIsDisabled(strStatusTypeValues1[i]);
		}

		for (int i = 0; i < strStatusTypeValues1.length; i++) {
			objRoles1.verRoleMayUpdateChkBoxIsEnabled(strStatusTypeValues1[i]);
		}

		for (int i = 0; i < strStatusTypeValues1.length; i++) {
			objRoles1
					.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues1[i]);
		}

		objRoles1.clickOnSaveBtn();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);

		for (int i = 0; i < strStNames.length; i++) {
			objResource1
					.verifyStatusTypeIsDisplayedUnderEditResLevelST(strStNames[i]);
		}

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickCreateNewViewButton()
					 .clickOnRegionsTab()
					 .selectRegionName(objLogindata.strRegionName)
					 .clickNextButton()
					 .selectResource(objResource_data.strResourceName)
					 .clickNextButton();

		for (int i = 0; i < strStNames.length; i++) {
			objViewsList1.verStatusTypeInViewUnderSetup(strStNames[i]);
		}
		objViewsList1.clickOnCancelButton();
		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickOnEditLinkOfView(objView_data.strViewName)
					 .clickOnSTTab();

		for (int i = 0; i < strStNames.length; i++) {
			objViewsList1.verStatusTypeInViewUnderSetup(strStNames[i]);
		}

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickOnCopyLinkOfView(objView_data.strViewName)
					 .clickOnSTTab();

		for (int i = 0; i < strStNames.length; i++) {
			objViewsList1.verStatusTypeInViewUnderSetup(strStNames[i]);
		}

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickOncustomizeResourceDetailView()
				.clickOnUncategorized();

		for (int i = 0; i < strStNames.length; i++) {
			objViewsList1.verStatusTypesInList(strStNames[i],
					strStatusTypeValues1[i]);
		}

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOncreateEventTemplate();

		for (int i = 0; i < strStNames.length; i++) {
			objEventSetUp1
					.verifyStatusTypeIsDispInCreateNewEventTemp(strStNames[i]);
		}

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objEventSetUpdata.strEventTemplate);

		for (int i = 0; i < strStNames.length; i++) {
			objEventSetUp1
					.verifyStatusTypeIsDispInCreateNewEventTemp(strStNames[i]);
		}

		for (int i = 0; i < strStatusTypeValues1.length; i++) {
			objEventSetUp1.selectStatusType(strStatusTypeValues1[i]);
		}

		objEventSetUp1.clickSaveButton();

		objEventManagement1.navigateToEventManagementNew().clickOnEditLink(
				objEventdata.strEventName);
		
		objEventManagement1
					.verifyStatusTypesInEditEvePage(strStatusTypeValues1);

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
				.clickOnNextButton();

		objFormConfiguration1
				.verifyStatusTypeIsDisplayed(
						objStatusTypes_data.strNSTStatusTypeName1)
				.verifyStatusTypeIsDisplayed(
						objStatusTypes_data.strMSTStatusTypeName1)
				.verifyStatusTypeIsDisplayed(
						objStatusTypes_data.strSSTStatusTypeName1)
				.verifyStatusTypeIsDisplayed(
						objStatusTypes_data.strNDSTStatusTypeName1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*********************************************************************************************************************
	'Description : Create private status type ST selecting a role R1 under ‘Roles with Update rights’ section, associate ST with resource RS
	 			at resource TYPE level and verify that user with role R1 and with ‘Update Status’ right on RS CAN update the status of ST from following screens:
				a. Region view
				b. Map
				c. Custom view
				d. View Resource Detail
				e. Event detail
	'Date		 : 22-Jan-2016
	'Author		 : Anil
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = "Create private status type ST selecting a role R1 under ‘Roles with Update rights’ section, associate ST with resource RS"+
	 			"at resource TYPE level and verify that user with role R1 and with ‘Update Status’ right on RS CAN update the status of ST from following screens:"+
				"a. Region view"+
				"b. Map"+
				"c. Custom view"+
				"d. View Resource Detail"+
				"e. Event detail")
	public void testHappyDay48958() throws Exception {

		gstrTCID = "48958";
		gstrTO = "Create private status type ST selecting a role R1 under ‘Roles with Update rights’ section, associate ST with resource RS"+
	 			"at resource TYPE level and verify that user with role R1 and with ‘Update Status’ right on RS CAN update the status of ST from following screens:"+
				"a. Region view"+
				"b. Map"+
				"c. Custom view"+
				"d. View Resource Detail"+
				"e. Event detail";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strRoleValue1[] = new String[1];
		String strStatusTypeValues1[] = new String[4];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		// Create role
		objNavigationToSubmenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// create status types
		objStatusTypeList.createStatusTypeWithSection(objStatusTypes_data.strNumberStatusType, objStatusTypes_data.strNSTStatusTypeName1, objStatusTypes_data.strStatusDescription,objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
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

		objViewsList.navigateToViewsList();
//		.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				objStatusTypes_data.strNSTStatusTypeName1);
		
		System.out.println(objView_data.strViewName);
		
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectEditResourcesOnlyOption().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption()
				.selectSetUpRolesRight()
				.selectEditStatusChangeNotPrefernceOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		objLogin.clickLogOut();

	
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objEventManagement.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
				.enterAdHocEventName(objEventdata.strEventName)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEventdata.strEventName);

		// Custom View
		Thread.sleep(3000);		
		objNavigationToSubmenus.navigateToCustomInView();	
		String[] strResource1Val = { strResourceValue[0] };		
		objCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResource1Val)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objStatusTypeList1.navigateToStatusTypeList();
		
		objStatusTypeList1.createPrivateStatusTypeWithSection(objStatusTypes_data.strNumberStatusType, objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strStatusDescription, objView_data.strSectionName);
		strStatusTypeValues1[0] = objStatusTypeList1.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList1.createPrivateStatusTypeWithSection(objStatusTypes_data.strMultiStatusType, objStatusTypes_data.strMSTStatusTypeName, objStatusTypes_data.strStatusDescription, objView_data.strSectionName);
		
		objStatusTypeList1.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor);
		strStatusesValues[0] = objStatusTypeList1.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList1.createNewStatus(objStatusTypes_data.strStatusNameInMulti1, objStatusTypes_data.strStatusColor);
		strStatusesValues[1] = objStatusTypeList1.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList1.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues1[1] = objStatusTypeList1.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		

		
		objStatusTypeList1.createPrivateStatusTypeWithSection(objStatusTypes_data.strTextStatusType, objStatusTypes_data.strTSTStatusTypeName, objStatusTypes_data.strStatusDescription, objView_data.strSectionName);
		strStatusTypeValues1[2] = objStatusTypeList1.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList1.createPrivateStatusTypeWithSection(objStatusTypes_data.strSaturationScoreStatusType, objStatusTypes_data.strSSTStatusTypeName, objStatusTypes_data.strStatusDescription, objView_data.strSectionName);
		strStatusTypeValues1[3] = objStatusTypeList1.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);	
		
		
		objResourceType1.navigateToResourceTypePage();
		
		objResourceType1.clickOnEditLinkOfResourceType(objResourceType_data.strResourceTypeName);
		
		objResourceType1.clickStatusType(strStatusTypeValues1);
		
		objResourceType1.clickOnSaveButton();
		
		objResourceType1.verResourceTypeInList(objResourceType_data.strResourceTypeName);	

		objNavigationToSubmenus1.navigateToViews();

		String[] strSTNames1 = { objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };
		
		objViewsList1.clickOnEditLinkOfView(objView_data.strViewName)
					 .clickOnSTTab();
		
		for(int i=0; i<strSTNames1.length; i++) {
			objViewsList1.selectStatusType(strSTNames1[i]);
		}

		
		objViewsList1.clickOnSaveOfCreateNewView();
		
//		objViewsList1.selectStatusTypeForView(strStatusTypeValues1)
//		.clickOnSaveOfCreateNewView();

		objNavigationToSubmenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		String[] strStatusTypeNames = { objStatusTypes_data.strNSTStatusTypeName,  objStatusTypes_data.strMSTStatusTypeName,  
				objStatusTypes_data.strTSTStatusTypeName,  objStatusTypes_data.strSSTStatusTypeName};
		
		for(int intCount= 0; intCount<strStatusTypeNames.length; intCount++){
		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
				strStatusTypeNames[intCount]);
		}
			
		objEventSetUp1.navigateToEventSetUp();
		objEventSetUp1.clickOnEditTempLink(objEventSetUpdata.strEventTemplate);
		for(int intCount= 0; intCount<strStatusTypeNames.length; intCount++){
			objEventSetUp1.selectStatusType(strStatusTypeValues1[intCount]);
		}
		
		objEventSetUp1.clickSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
			.clickOnEditLink(objEventdata.strEventName);
		
		for(int intCount= 0; intCount<strStatusTypeNames.length; intCount++){
			objEventManagement1.selectStatusType(strStatusTypeValues1[intCount]);
		}
			
		objEventManagement1.clickOnSaveButton()
		.verifyEventName(objEventdata.strEventName);
		
		objNavigationToSubmenus1.navigateToCustomizedViewInPrefrences();
		
		objCustomUnderView1.clickOnOptions()
		.selectStatusTypes(strStatusTypeValues1).clickOnSave();
		
		objNavigationToSubmenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for(int intCount= 0; intCount<strStatusTypeNames.length; intCount++){
		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
				strStatusTypeNames[intCount]);
		}
		
		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
		
		objUpdateStatus1.clickOnSelectAll();
		
		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues1[0],
				objView_data.strValueForUpdate);
		
		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues1[1],
				strStatusesValues[0]);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues1[2],
				objView_data.strValueForTST);
		
		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues1[3],
				objView_data.strValueForSST).clickOnSaveButton();
		
		String[] strUpdatedValues = {objView_data.strValueForUpdate, objStatusTypes_data.strStatusNameInMulti,
				objView_data.strValueForTST, objView_data.strUpdatedValForSST };
		
		for(int intCount= 0; intCount<strStatusTypeNames.length; intCount++){
		objViewsList1.verifyUpdatedValue(strResourceValue[0], strStatusTypeValues1[intCount], strUpdatedValues[intCount]);
		}
		
		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.verStatusTypeInCustomViewTablePage(strStatusTypeNames);
		
		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
		
		objUpdateStatus1.clickOnSelectAll();
		
		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues1[0],
				objView_data.strValueForUpdate1);
		
		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues1[1],
				strStatusesValues[1]);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues1[2],
				objView_data.strValueForTST1);
		
		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues1[3],
				objView_data.strValueForSST1).clickOnSaveButton();

		String[] strUpdatedValues1 = {objView_data.strValueForUpdate1, objStatusTypes_data.strStatusNameInMulti1,
				objView_data.strValueForTST1, objView_data.strUpdatedValForSST1 };
		
		for(int intCount= 0; intCount<strStatusTypeNames.length; intCount++){
		objViewsList1.verifyUpdatedValue(strResourceValue[0], strStatusTypeValues1[intCount], strUpdatedValues1[intCount]);
		}
		

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verStatusTypesInPopupWindow(
						strStatusTypeNames);
		
		objMap1.clickUpdateStatusInPopupWindow();
		
		
		objUpdateStatus1.clickOnSelectAll();
		
		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues1[0],
				objView_data.strValueForUpdate);
		
		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues1[1],
				strStatusesValues[0]);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues1[2],
				objView_data.strValueForTST);
		
		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues1[3],
				objView_data.strValueForSST).clickOnSaveButton();
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verStatusTypesInPopupWindow(
						strStatusTypeNames);
		
		for(int intCount= 0; intCount<strStatusTypeNames.length; intCount++){
			objMap1.verUpdateValuesInPopupWindow(strUpdatedValues[intCount]);
		}
		
		objNavigationToSubmenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verStatusTypesInPopupWindow(
						strStatusTypeNames);
		
		objMap1.clickUpdateStatusInPopupWindow();
		
		
		objUpdateStatus1.clickOnSelectAll();
		
		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues1[0],
				objView_data.strValueForUpdate1);
		
		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues1[1],
				strStatusesValues[1]);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues1[2],
				objView_data.strValueForTST1);
		
		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues1[3],
				objView_data.strValueForSST1).clickOnSaveButton();
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verStatusTypesInPopupWindow(
						strStatusTypeNames);
		
		for(int intCount= 0; intCount<strStatusTypeNames.length; intCount++){
			objMap1.verUpdateValuesInPopupWindow(strUpdatedValues1[intCount]);
		}
		
		objMap1.clickOnViewInfoInPopupWindow();

		for(int intCount= 0; intCount<strStatusTypeNames.length; intCount++){
		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
				strStatusTypeNames[intCount],
				objView_data.strSectionName);
		
		}
		
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0], strStatusTypeValues1[0]);
		
		objUpdateStatus1.verifyStatusNameAndDefinitionUpdateStatusScreen(strStatusTypeValues1[0],  objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strStatusDescription);
		
		objUpdateStatus1.clickOnShowAllStatuses();
		
		for(int intCount= 0; intCount<strStatusTypeNames.length; intCount++){
		objUpdateStatus1.verifyStatusNameAndDefinitionUpdateStatusScreen(strStatusTypeValues1[intCount],  strStatusTypeNames[intCount], objStatusTypes_data.strStatusDescription);
		}
		objUpdateStatus1.clickOnSelectAll();
		
		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues1[0],
				objView_data.strValueForUpdate);
		
		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues1[1],
				strStatusesValues[0]);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues1[2],
				objView_data.strValueForTST);
		
		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues1[3],
				objView_data.strValueForSST).clickOnSaveButton();
		
		for(int intCount= 0; intCount<strStatusTypeNames.length; intCount++){
			objViewsList1.verifyUpdatedValuesInResourceDetailPage(strStatusTypeNames[intCount], strUpdatedValues[intCount]);
		}


		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		objEventManagement1.verifyStatusTypesInEventBannerPage(objResourceType_data.strResourceTypeName, strStatusTypeNames);
		
		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
		
		objUpdateStatus1.clickOnSelectAll();
		
		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues1[0],
				objView_data.strValueForUpdate1);
		
		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues1[1],
				strStatusesValues[1]);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues1[2],
				objView_data.strValueForTST1);
		
		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues1[3],
				objView_data.strValueForSST1).clickOnSaveButton();
		
		for(int intCount= 0; intCount<strStatusTypeNames.length; intCount++){
			objViewsList1.verifyUpdatedValue(strResourceValue[0], strStatusTypeValues1[intCount], strUpdatedValues1[intCount]);
		}
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************************************
	'Description :Create a private status type ST and verify that ST can be viewed by any user (non system admin) in the following setup pages even if the user does not have any resource rights on the associated resource:
						a. Status Type List
						b. Create New /Edit Resource Type
						c. Create /Edit Role
						d. Edit Resource Level Status Types
						e. Create New/Edit/Copy View
						f. Edit Resource Detail View Sections
						g. Create/Edit Event Template
						e. Edit event
						f. While configuring the form
	'Date		 : 28-Jan-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************************************/
	@Test(description = "Create private status type ST, associate ST with resource RS at resource TYPE level and verify that users can view the status type only if they have any of the affiliated resource rights on RS from following screens:"
			+ "a. Region view"
			+ "b. Map"
			+ "c. Custom view"
			+ "d. View Resource Detail" + "e. Event detail")
	public void testHappyDay48884() throws Exception {

		gstrTCID = "48884";
		gstrTO = "Create private status type ST, associate ST with resource RS at resource TYPE level and verify that users can view the status type only if they have any of the affiliated resource rights on RS from following screens:"
				+ "a. Region view"
				+ "b. Map"
				+ "c. Custom view"
				+ "d. View Resource Detail" + "e. Event detail";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		Map objMap1 = new Map(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strEveTemplateValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Role-Based Status Types

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
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

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);

		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objNavigationToSubmenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusType(objStatusTypes_data.strNSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName);
		
		System.out.println(objView_data.strViewName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);

		objEventManagement.clickOnSaveButton();

		strEveTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUpdata.strEventTemplate);

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectViewcustomViewOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.createNewStatus(
			     objStatusTypes_data.strStatusNameInMulti,
			     objStatusTypes_data.strStatusColor)
			  .createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
			      objStatusTypes_data.strStatusColor)
			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti1)
			  .clickOnReturnToStatusTypeList();

		strStatusTypeValues1[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues1[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues1[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues1[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.clickStatusType(strStatusTypeValues1)
				.clickOnSaveButton();

		String[] strStNames = { objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strDateStatusTypeName };

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnUsersLink(objResource_data.strResourceName)
				.verAssignUserstoResourcePageIsDisplayed(
						objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objUserdata.strNewUserName)
				.selectRunReportCheckBox(objUserdata.strNewUserName1)
				.selectAssociatedWithCheckBox(objUserdata.strNewUserName2)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOnEditLinkOfView(objView_data.strViewName)
					.clickOnSTTab();
		
		for(int i=0; i <strStNames.length; i++) {
			objViewsList.selectStatusType(strStNames[i]);
		}
		
		objViewsList.clickOnSaveOfCreateNewView();
//				.selectStatusTypeForView(strStatusTypeValues1)
//				.clickOnSaveOfCreateNewView();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
				.enterAdHocEventName(objEventdata.strEventName)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton()
				.verifyEventName(objEventdata.strEventName);

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues1).clickOnSave();

		objEventManagement1.navigateToEventManagement().clickOnEditLink(
				objEventdata.strEventName);

		for (int i = 0; i < strStatusTypeValues1.length; i++) {
			objEventManagement1
					.selectStatusTypeInEditEventPage(strStatusTypeValues1[i]);
		}

		objEventManagement1.clickOnSaveButton();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strStNames.length; i++) {
			objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
					strStNames[i]);
		}

		objNavigationToSubmenus1.navigateToCustomInView();

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(
						strStNames);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStNames)
				.verSTInStatusTypeDropDown(
						objStatusTypes_data.strMSTStatusTypeName1)
				.clickOnViewInfoInPopupWindow();

		for (int i = 0; i < strStNames.length; i++) {
			objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
					strStNames[i], objView_data.strSectionName);
		}

		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		for (int i = 0; i < strStNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName, strStNames[i]);
		}

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues1).clickOnSave();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strStNames.length; i++) {
			objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
					strStNames[i]);
		}

		objNavigationToSubmenus1.navigateToCustomInView();

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verStatusTypesInPopupWindow(
						strStNames);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStNames)
				.verSTInStatusTypeDropDown(
						objStatusTypes_data.strMSTStatusTypeName1)
				.clickOnViewInfoInPopupWindow();

		for (int i = 0; i < strStNames.length; i++) {
			objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
					strStNames[i], objView_data.strSectionName);
		}

		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		for (int i = 0; i < strStNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName, strStNames[i]);
		}

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues1).clickOnSave();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strStNames.length; i++) {
			objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
					strStNames[i]);
		}

		objNavigationToSubmenus1.navigateToCustomInView();

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verStatusTypesInPopupWindow(
						strStNames);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStNames)
				.verSTInStatusTypeDropDown(
						objStatusTypes_data.strMSTStatusTypeName1)
				.clickOnViewInfoInPopupWindow();

		for (int i = 0; i < strStNames.length; i++) {
			objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
					strStNames[i], objView_data.strSectionName);
		}

		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		for (int i = 0; i < strStNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName, strStNames[i]);
		}

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName3,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strStNames.length; i++) {
			objViewsList1.verStatusTypesNotDisplayedWithRes(
					strResourceTypeValue[0], objResource_data.strResourceName,
					strStNames[i]);
		}

		objNavigationToSubmenus1.navigateToCustomInView();

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesNotInPopupWindow(strStNames);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesNotInPopupWindow(strStNames)
				.verSTNotInStatusTypeDropDown(
						objStatusTypes_data.strMSTStatusTypeName1)
				.clickOnViewInfoInPopupWindow();

		for (int i = 0; i < strStNames.length; i++) {
			objViewsList1
					.verifyStatusTypeIsNotUnderSectionsInResourceDetailPage(
							strStNames[i], objView_data.strSectionName);
		}

		objEventManagement1
				.clickOnEventNameInEventBanner(objEventdata.strEventName);

		for (int i = 0; i < strStNames.length; i++) {
			objEventStatus1.verStatusTypeNotPresent(
					objResourceType_data.strResourceTypeName, strStNames[i]);
		}

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
		
	}
	
}
