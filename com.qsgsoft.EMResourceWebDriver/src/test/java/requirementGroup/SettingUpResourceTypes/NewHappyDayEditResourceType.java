package requirementGroup.SettingUpResourceTypes;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewHappyDayEditResourceType extends TestNG_UI_EXTENSIONS {

	public NewHappyDayEditResourceType() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that a resource type can be edited.
	'Precondition:
	'Date	 	 : 28-May-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date: 06-Oct-2016                        	Modified By: Pallavi
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " Verify that a resource type can be edited.")
	public void testHappyDay103818() throws Exception {

		gstrTCID = "103818";
		gstrTO = "Verify that a resource type can be edited.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagementPage = new EventManagement(
				this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagementPage1 = new EventManagement(
				this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectViewcustomViewOption()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionViewsOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();
		System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		StatusTypeList_page.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		String strFirstStatusType[] = { strStatusTypeValues[0] };
		String strSecStatusType[] = { strStatusTypeValues[1] };

		System.out.println(objStatusTypes_data.strNumberStatusType);

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strFirstStatusType);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objResource_Page
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strSecStatusType).clickOnSaveButton();

		objResource_Page
				.selectUsersLinkInResourceList(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objUserdata.strNewUserName)
				.selectViewResourceCheckBox(objUserdata.strNewUserName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToViews();

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, 
							objResource_data.strResourceName, strAllStatausTypes);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strAllStatausTypes.length; i++) {
//
//			objViewsList.selectStatusType(strAllStatausTypes[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
//				.verViewInList(objView_data.strViewName);

		objNavigationToSubmenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();

		objEventManagementPage.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType_Page1
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.enterResourceTypeName(
						objResourceType_data.strEdResourceTypeName)
				.enterResourceTypeDescription(
						objResourceType_data.strEdResTypeDescription)
				.deselectStatusType(strFirstStatusType)
				.clickStatusType(strSecStatusType)
				.clickOnSaveButton()
				.verResourceTypeInList(
						objResourceType_data.strEdResourceTypeName);

		System.out.println(objResourceType_data.strEdResourceTypeName);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1
				.verifyStatusTypeNameInView(strResourceTypeValue[0],
						objStatusTypes_data.strTSTStatusTypeName)
				.verifyStatusTypeNameIsNotInUserView(strResourceTypeValue[0],
						objStatusTypes_data.strNSTStatusTypeName)
				.verifyResourceTypeNameInView(strResourceTypeValue[0],
						objResourceType_data.strEdResourceTypeName);

		objEventManagementPage1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verStatusTypes(
				objResourceType_data.strEdResourceTypeName,
				objStatusTypes_data.strTSTStatusTypeName)
				.verStatusTypeNotPresent(
						objResourceType_data.strEdResourceTypeName,
						objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strCustom);

		String[] strStatsuType = { objStatusTypes_data.strTSTStatusTypeName };
		String[] strResName = { objResource_data.strResourceName };

		objCustomUnderView1
				.verStatusTypeInCustomViewTablePage(strStatsuType)
				.verStatusTypeNotInCustomViewTablePage(
						objStatusTypes_data.strNSTStatusTypeName)
//	EMS-4137 - Edited ‘Resource Type’ name is NOT reflected in ‘Custom View’. -- As designed, modified script as suggested by sweta			
				.verResourceAndResTypeInCustomViewTablePage(strResName,
						objResourceType_data.strResourceTypeName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/******************************************************************************************************
	'Description : Verify that newly added status types for a resource type are updated on the View screen.
	'Date	 	 : 28-May-2015
	'Author		 : Anitha
	'------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                          Modified By
	'Date					                                                      Name
	*******************************************************************************************************/
	@Test(description = "Verify that newly added status types for a resource type are updated on the View screen.")
	public void testHappyDay69417() throws Exception {

		gstrTCID = "69417";
		gstrTO = "Verify that newly added status types for a resource type are updated on the View screen.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		Map objMap1=new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);

		String strStatusTypeValue1[] = new String[1];
		String strStatusTypeValue2[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValue1[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValue2[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValue1)
				.verResourceTypeInList(objResourceType_data.strResourceTypeName);

		// Resource creation
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page.createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);
		
		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);
		
		objNavigationToSubmenus.navigateToViews();
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
							objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strNSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objLogin.clickLogOut();
		
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnViewMenu();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		String[] strStatusTypeNames = { objStatusTypes_data.strNSTStatusTypeName };
		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}
		
		// Resource type Edition
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();
		
		objResourceType_Page1.clickOnEditLinkOfResourceType(objResourceType_data.strResourceTypeName)
		                     .verEditResourceTypeListPageIsDisplayed()
		                     .clickStatusTypeNew(strStatusTypeValue2)
		                     .clickOnSaveButton()
		                     .verResourceTypeListPageIsDisplayed();
		
		objNavigationToSubmenus1.navigateToViews();
		
		objViewsList1.verRegionViewListPageIsDisplayed()

		.clickOnEditLinkOfView(objView_data.strViewName)

		.clickOnSTTab()
		
		.selectStatusType(objStatusTypes_data.strTSTStatusTypeName)
		
		.clickOnSaveOfCreateNewView();
		Thread.sleep(5000);
		objNavigationToSubmenus1.clickOnViewMenu();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		String[] strStatusTypeNames1 = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };
		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames1[i]);
		}

		objNavigationToSubmenus1.navigateToMapPage();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
               .verStatusTypesInPopupWindow(strStatusTypeNames1);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/******************************************************************************************************************
	'Description : Verify that a status type deselected from a resource type is no longer displayed on the View screen.
	'Date	 	 : 28-May-2015
	'Author		 : Anitha
	'------------------------------------------------------------------------------------------------------------------
	'Modified Date			                        	                          Modified By
	'Date					                                                      Name
	*******************************************************************************************************************/
	@Test(description = "Verify that a status type deselected from a resource type is no longer displayed on the View screen.")
	public void testHappyDay100307() throws Exception {

		gstrTCID = "100307";
		gstrTO = "Verify that a status type deselected from a resource type is no longer displayed on the View screen.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);
		Views objViews1 = new Views(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);

		String strStatusTypeValue[] = new String[2];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		StatusTypeList_page.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValue[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValue[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValue)
				.verResourceTypeInList(objResourceType_data.strResourceTypeName);

		// Resource creation
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page.createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

		String[] strStatusTypeNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
							objResource_data.strResourceName, strStatusTypeNames);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusTypeForView(strStatusTypeValue);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objLogin.clickLogOut();
		
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnViewMenu();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);


		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		// Resource type Edition
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		String[] strStatusTypeValues = { strStatusTypeValue[1] };

		objResourceType_Page1
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.verEditResourceTypeListPageIsDisplayed()
				.deselectStatusType(strStatusTypeValues).clickOnSaveButton()
				.verResourceTypeListPageIsDisplayed();

		objNavigationToSubmenus1.clickOnViewMenu();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strNSTStatusTypeName);

		objViews1.verStatusTypesNotDisplayed(
				objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strTSTStatusTypeName);

		objViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViewsList1.verifyStatusTypeName(objStatusTypes_data.strNSTStatusTypeName);

		String[] strStatusTypeNames2 = { objStatusTypes_data.strTSTStatusTypeName };

		objViewsList1
				.verifyStatusTypeNameIsNotInView(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubmenus1.navigateToMapPage();

		String[] strStatusTypeNames1={objStatusTypes_data.strNSTStatusTypeName};
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames1)
				.verStatusTypesNotInPopupWindow(strStatusTypeNames2);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
