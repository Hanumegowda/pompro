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

public class NewInactivateResourceType1 extends TestNG_UI_EXTENSIONS {

	public NewInactivateResourceType1() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*****************************************************************************************************
	'Description : Deactivate a resource type and verify that the resource type and the resource under it 
	               is not displayed on the following screens:1. View 2. Map 3. Event Detail 4. Custom View
	'Date	 	 : 28-May-2015
	'Author		 : Anitha
	'-----------------------------------------------------------------------------------------------------
	'Modified Date			                        	                          Modified By
	'Date					                                                      Name
	******************************************************************************************************/
	@Test(description = "Deactivate a resource type and verify that the resource type and the resource under it is not displayed on the following screens:"+
						"1. View 2. Map"+
						"3. Event Detail 4. Custom View")
	public void testHappyDay102889() throws Exception {

		gstrTCID = "102889";
		gstrTO = "Deactivate a resource type and verify that the resource type and the resource under it is not displayed on the following screens:"+
				"1. View 2. Map"+
				"3. Event Detail 4. Custom View";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		CustomUnderView ObjCustomUnderView = new CustomUnderView(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);
		Views objViews1 = new Views(this.driver1);
		Map objMap1=new Map(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);

		String strStatusTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

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

		strStatusTypeValue[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValue);
		
		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption()
				.selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();
		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strStatusTypeValue[0]).clickSaveButton()
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllWebOption();


		System.out.println(objUserdata.strNewUserName);
		System.out.println(objEvent_data.strEventName);
		System.out.println(objView_data.strViewName);
		
		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objEventManagement.selectFrame();
		
		objEventManagement.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton();
		
		objNavigationToSubmenus.navigateToCustomInView();
		
		ObjCustomUnderView.clickOnSetupCustomViewLink()
						  .clickOnAddMoreResources()
						  .enterResNameInWhatField(objResource_data.strResourceName)
						  .clickOnSearch().selectResource(strResourceValue)
						  .clickOnAddToCustomView().clickOnOptions()
						  .selectAllChkBoxInOptions()
						  .selectStatusTypes(strStatusTypeValue).clickOnSave();

		objLogin.clickLogOut();
	
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
			
		// Resource type Edition
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();
		
		objResourceType_Page1
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.verEditResourceTypeListPageIsDisplayed()
				.deselectActiveCheckBox()
				.clickOnSaveButton()
				.verResourceTypeNotInList(
						objResourceType_data.strResourceTypeName);
		//View
		objNavigationToSubmenus1.clickOnViewMenu();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceNameNotInView(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objViews1.verStatusTypesNotDisplayed(
				objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strNSTStatusTypeName);
		//View Map
		objNavigationToSubmenus1.navigateToMapPage();

		objMap1.verResourceNotInFindResourceDropDown(objResource_data.strResourceName);
		
		objEventManagement1.clickOnEventNameInEventBanner(
				objEvent_data.strEventName)
				.verifyResourceTypeAndResourceNameIsNotDisplayed(
						objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strNSTStatusTypeName);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToCustomInView();
		
		objViews1.vererrorMsgInCustomView();
		
		objViews1.clickOnCustomizeLink();
		
		objCustomUnderView1.verEditCustomViewScreenIsDisplayed()
		                   .clickOnAddMoreResources()
		                   .enterResNameInWhatField(objResource_data.strResourceName)
						   .clickOnSearch()
						   .verErrorMessgaeForResource();
		               
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*****************************************************************************************************
	'Description : Reactivate a resource type and verify that the resource type and the resource under it 
	               is displayed on the following views:1. View 2. Map 3. Event Detail 4. Custom View
	'Date	 	 : 28-May-2015
	'Author		 : Anitha
	'-----------------------------------------------------------------------------------------------------
	'Modified Date			                        	                          Modified By
	'Date					                                                      Name
	******************************************************************************************************/
	@Test(description = "Reactivate a resource type and verify that the resource type and the resource under"
			+ " it is displayed on the following views:"+
						"1. View 2. Map"+
						"3. Event Detail 4. Custom View")
	public void testHappyDay102899() throws Exception {

		gstrTCID = "102899";
		gstrTO = "Reactivate a resource type and verify that the resource type and the resource under it is "
				+ "displayed on the following views:"+
				"1. View 2. Map"+
				"3. Event Detail 4. Custom View";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		CustomUnderView ObjCustomUnderView = new CustomUnderView(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		UpdateStatus objUpdateStatus=new UpdateStatus(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);
		Views objViews1 = new Views(this.driver1);
		Map objMap1=new Map(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);

		String strStatusTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

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

		strStatusTypeValue[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValue);
		
		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectViewcustomViewOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();
		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strStatusTypeValue[0]).clickSaveButton()
				.deselectSelectAllEmailOption().deselectSelectAllPagerOption()
				.deselectSelectAllWebOption();


		System.out.println(objUserdata.strNewUserName);
		System.out.println(objEvent_data.strEventName);
		System.out.println(objView_data.strViewName);
		
		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objEventManagement.selectFrame();
		
		objEventManagement.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton();
		
		objNavigationToSubmenus.navigateToCustomInView();
		
		ObjCustomUnderView.clickOnSetupCustomViewLink()
						  .clickOnAddMoreResources()
						  .enterResNameInWhatField(objResource_data.strResourceName)
						  .clickOnSearch().selectResource(strResourceValue)
						  .clickOnAddToCustomView().clickOnOptions()
						  .selectAllChkBoxInOptions()
						  .selectStatusTypes(strStatusTypeValue).clickOnSave();
		
		objNavigationToSubmenus.clickOnViewMenu();

		objNavigationToSubmenus
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViewsList.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValue[0]);
		
		objUpdateStatus.enterNSTAndTSTUpdateValue(strStatusTypeValue[0],
						objView_data.strValueForUpdate).clickOnSaveButton();
		
		objLogin.clickLogOut();
	
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		// Resource type Edition
		objNavigationToSubmenus.navigateToResourceTypesInSetup();
		
		objResourceType_Page
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.deselectActiveCheckBox().clickOnSaveButton();
		
		objLogin.clickLogOut();
		
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
			
		// Resource type Edition
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();
		
		objResourceType_Page1
				.selectIncludeInActiveCheckBox()
				.verResourceTypeInList(objResourceType_data.strResourceTypeName)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.selectActiveCheckBox()
				.clickOnSaveButton()
				.verResourceTypeIsActive(objResourceType_data.strResourceTypeName)
				.deselectIncludeInActiveCheckBox();
		//View
		objNavigationToSubmenus1.clickOnViewMenu();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strNSTStatusTypeName);
		
		//View Map
		objNavigationToSubmenus1.navigateToMapPage();

		String[] strStatusTypeNames={objStatusTypes_data.strNSTStatusTypeName};
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
               .verStatusTypesInPopupWindow(strStatusTypeNames);
		
		objEventManagement1.clickOnEventNameInEventBanner(
				objEvent_data.strEventName).verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToCustomInView();
		
		String[] strResourceNames = { objResource_data.strResourceName };
		
		objCustomUnderView1.verResourceAndResTypeInCustomViewTablePage(
				strResourceNames, objResourceType_data.strResourceTypeName)
				.verStatusTypeInCustomViewTablePage(strStatusTypeNames);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
