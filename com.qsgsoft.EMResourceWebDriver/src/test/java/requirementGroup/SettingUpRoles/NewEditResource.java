package requirementGroup.SettingUpRoles;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
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
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEditResource extends TestNG_UI_EXTENSIONS {
	
	public NewEditResource() throws Exception {
		super();
	}
	
	/****************************************************************************************************************
	'Description : Verify that a resource can be edited.
	'Precondition:
	'Date	 	 : 13-Jan-2016
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Verify that a resource can be edited.")
	public void testHappyDay69690() throws Exception {

		gstrTCID = "69690";
		gstrTO = "Verify that a resource can be edited.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();

		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		CustomUnderView ObjCustomUnderView = new CustomUnderView(this.driver1);
		
		String strstatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strEveTemplateValue[] = new String[1];
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		Views objViews1 = new Views(this.driver1);
		Map objMap1 = new Map(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();


		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);
		
		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);

		objEventManagement.clickOnSaveButton();

		strEveTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectViewcustomViewOption()
				.selectFormUserMayConfigureFormSecurity()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objViewsList.navigateToViewsList();
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, 
				objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName);
		
//		objViewsList.clickCreateNewViewButton()
//		.enterViewName(objView_data.strViewName)
//		.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strNSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
//		objViewsList.verViewInList(objView_data.strViewName);
		
		objLogin.clickLogOut();


		objLogin.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		// create Event
		objEventManagement.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		
		objNavigationToSubMenus.navigateToCustomInView();
		String[] strResource1Val = { strResourceValue[0] };
		
		ObjCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResource1Val)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strstatusTypeValues).clickOnSave();
		
		objLogin.clickLogOut();
		
		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName};

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strNSTStatusTypeName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)	
				.clickOnSaveButton();
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);
		
		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objResource1.navigateToResourceListPageNew();
		objResource1.clickOnEditLinkInResourcePage(objResource_data.strResourceName);
		
		objResource1.enterResourceName(objResource_data.strEditedResName1);
		objResource1.enterResourceAbbrivation(objResource_data.strEditedResAbb);
		objResource1.enterResourceFirstName(objResource_data.strEditedResFirstName);
		objResource1.clickOnSaveButton();
		
		objResource1.verResourceNameAndDetailsInResourceList(objResource_data.strEditedResName1, objResource_data.strEditedResAbb, objResourceType_data.strResourceTypeName);
		
		objNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strEditedResName1);

		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0], objStatusTypes_data.strNSTStatusTypeName);
		
		objViewsList1.verifyUpdatedValue(strResourceValue[0], strstatusTypeValues[0], objView_data.strValueForUpdate);
		
		objViewsList1
		.clickOnResourceAndNavigateToResourceDetail(objResource_data.strEditedResName1);
		objViewsList1.verifyStatuessInResourceDetailPage(
				objStatusTypes_data.strNSTStatusTypeName,
				objView_data.strSectionName,
				objView_data.strValueForUpdate);

		objNavigationToSubMenus1.navigateToMapPage();
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strEditedResName1);
		
		objMap1.verResourceNameInPopupWindow(objResource_data.strEditedResName1);
		
		objMap1.verStatusTypesInPopupWindow(strStatusTypeNames);
		
		objMap1.verUpdateValuesInPopupWindow(objView_data.strValueForUpdate);
		

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strEditedResName1);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);
		
		objNavigationToSubMenus1.clickOnConfigureForm();

		objFormConfiguration1
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strUserToIndividualResources)
				.clickOnNextButton()
				.deselectAllResources()
				.verifyResourceNameIsDisplayed(objResource_data.strEditedResName1);

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnEditLink(objEvent_data.strEventName)
		.verifyResourceNameInCreateEventPage(objResource_data.strEditedResName1);
		
		objNavigationToSubMenus1.navigateToCustomInView();
		
		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strEditedResName1);
		
		objViews1.verStatusTypesInCustomViewTable(
				objResourceType_data.strResourceTypeName,
				objStatuTypes_data.strNSTStatusTypeName);
		
		objLinksAtTopRightCorners1.clickOnSearch();
		
		objCustomUnderView1.verifyFindResourcesPage();
		
		objCustomUnderView1.enterResNameInWhatField(objResource_data.strResourceName)
		.clickOnSearch()
		.verErrorMessgaeForResource()
				.enterResNameInWhatField(objResource_data.strEditedResName1)
		.clickOnSearch()
		.verResourceNameInSearch(objResource_data.strEditedResName1);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

}