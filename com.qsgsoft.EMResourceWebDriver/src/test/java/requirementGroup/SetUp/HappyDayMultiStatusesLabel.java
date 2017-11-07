package requirementGroup.SetUp;

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
import lib.page.Regions;
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

public class HappyDayMultiStatusesLabel extends TestNG_UI_EXTENSIONS {
	
	public HappyDayMultiStatusesLabel() throws Exception {
		super();
	}

	/*************************************************************************************
	 * 'Description 	: Verify that statuses created with 25 character can be viewed in all the view screens 
	 * 'Precondition	: 
	 * 'Date 			: 11-Feb-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that statuses created with 25 character can be viewed in all the view screens ")
	public void testHappyDay149938() throws Exception {

		gstrTCID = "149938";
		gstrTO = "Verify that statuses created with 25 character can be viewed in all the view screens ";

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
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Views objViews = new Views(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strStatusesValues[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		String strRegionValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strArkansasReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strArkansasReg);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strStateWideReg);

		System.out.println(strRegionValue[1]);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection().clickOnSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList
				.createSharedStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList
				.createStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti4,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti3)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti4);

		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);

		strStatusesValues[3] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti4);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName,
				strStatusTypeValues);

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.createResourceWithAddress(objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName,
						objResource_data.strStreetAddress,
						objResource_data.strCity, objResource_data.strState,
						objResource_data.strCounty, objResource_data.strZipcode)
				.clickOnEditLinkInResourcePage(objResource_data.strResourceName)
				.clickOnshareWithOtherReg().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objResource
				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.clickOnCreateNewSubResourceButton()
				.verCreateNewSubResourceForPageIsDisplayed(
						objResource_data.strResourceName)
				.enterResourceName(objResource_data.strSubResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton()
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName);

		strResourceValue[1] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);

		String[] strStatusTypeNames = {
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName1 };

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypeNames);

		objViewsList.clickOnEditOfRegDefault();

//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
		
		objViewsList.clickOnResourcesTab()
		.selectResource(objResource_data.strResourceName)
		.clickNextButton();

		for (int i = 0; i < strStatusTypeNames.length; i++) {
		objViewsList.selectStatusType(strStatusTypeNames[i]);
		}
		
		objViewsList.clickOnSaveOfCreateNewView()
				.clickOncustomizeResourceDetailView()
				.clickSubResourceButton()
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName);

		objViewsList.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0]);

		for (int i = 0; i < strStatusTypeValues.length; i++) {

			objViewsList.selectSubResourceCheckBox(strStatusTypeValues[i]);

		}

		objViewsList.clickOnSaveButton();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.clickSaveButton();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
		.clickSaveButton();
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);


		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strStateWideReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectFirstRole()
				.selectViewOtherRegView(objLogindata.strArkansasRegVal2)
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();
		
		objEventManagement.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch();

		String[] strResVal = { strResourceValue[0] };

		objCustomUnderView1.selectResource(strResVal).clickOnAddToCustomView()
				.clickOnOptions().selectStatusTypes(strStatusTypeValues)
				.clickOnSave();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[2]).clickOnSaveButton();
		
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.
		 strResourceName)
		 .verUpdateValuesInPopupWindow(objStatusTypes_data.strStatusNameInMulti)
		 .verUpdateValuesInPopupWindow(objStatusTypes_data.strStatusNameInMulti3);

		objNavigationToSubmenus1.navigateToRegDefault();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[1],
						objStatusTypes_data.strStatusNameInMulti3);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[1],
						objStatusTypes_data.strStatusNameInMulti3);

		objViews.clickOnResource(objResource_data.strResourceName)
				.verStatusTypesUnderSection(
						objStatusTypes_data.strMSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatusTypes_data.strMSTStatusTypeName1,
						objView_data.strSectionName)
				.verUpdatedStatus(strStatusTypeValues[0],
						objStatusTypes_data.strStatusNameInMulti)
				.verUpdatedStatus(strStatusTypeValues[1],
						objStatusTypes_data.strStatusNameInMulti3)
				.clickOnUpdateStatusKeyInViewResDetailPage(
						objResource_data.strSubResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[1])
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[3]).clickOnSaveButton();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[1],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti1)
				.verifyUpdatedStatusValues(strResourceValue[1],
						strStatusTypeValues[1],
						objStatusTypes_data.strStatusNameInMulti4);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[1],
						objStatusTypes_data.strStatusNameInMulti3);

		objNavigationToSubmenus1.navigateToCustomInView();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[1],
						objStatusTypes_data.strStatusNameInMulti3);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToRegUnderOtherRegions(objLogindata.strArkansasReg);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
