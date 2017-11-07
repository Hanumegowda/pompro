package requirementGroup.SettingUpUsers;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
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

import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewViewResourceRight extends TestNG_UI_EXTENSIONS{

	public NewViewResourceRight() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*********************************************************************************************
	'Description 	: Verify that when the 'View Resource' right on a resource is removed for a user, the user cannot view the resource on all the view screens. 
	'Date 			: 02-Jul-2015 
	'Author 		: Renushree
	'---------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************/
	@Test(description = " Verify that when the 'View Resource' right on a resource is removed for a user, the user cannot view the resource on all the view screens. ")
	public void testHappyDay48268() throws Exception {

		gstrTCID = "48268";
		gstrTO = "Verify that when the 'View Resource' right on a resource is removed for a user, the user cannot view the resource on all the view screens. ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

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
		EventManagement objEventManagement = new EventManagement(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

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

		objStatusTypeList.createPrivateStatusType(
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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName2,
				objUser_data.strNewPassword, objUser_data.strFullName2)
		.selectFirstRole().clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption().clickSaveButton();
		
		objViewsList.navigateToViewsList();
		
		String strSTNames[] = {objStatuTypes_data.strNSTStatusTypeName,objStatuTypes_data.strTSTStatusTypeName};
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strSTNames);
		/*objViewsList.clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc);

		objViewsList.selectStatusType(objStatuTypes_data.strNSTStatusTypeName)
				.selectStatusType(objStatuTypes_data.strTSTStatusTypeName);

		objViewsList.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();*/

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption();

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		objEventManagement.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.verifyUserListPageIsDisplayed()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName)
				.verifyEditUserPageIsDisplayed()
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.deselectAssociatedRightCheckBox(
						objResource_data.strResourceName).clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceNameNotInView(objResource_data.strResourceName);

		objNavigationToSubMenus1.navigateToCustomInView();

		objViews1.verResourceNameNotInView(objResource_data.strResourceName);

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.verResourceNotInFindResourceDropDown(objResource_data.strResourceName);

		objLinksAtTopRightCorners1.clickOnCustomize();

		objCustomUnderView1
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceNamesNotInList(objResource_data.strResourceName,
						objTest_data.strRegionName,
						objResourceType_data.strResourceTypeName)
				.clickOnCancel().clickOnOptions()
				.verSTNotDisplayedInOptions(strStatusTypeValues);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.verResourceNotInFindResourceDropDown(objResource_data.strResourceName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.verResourceNameIsNotDisplayed(objResource_data.strResourceName);

		objLogin1.clickLogOut();
		
		String[] strTestData = {
				Login_data.strBuildName,
				gstrTCID,
				objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
				objEventSetUp_data.strEventTemplate,
				objEvent_data.strEventName,
				"Verify mobile end condition that in all view screen RS not dispalyed.",
				objStatuTypes_data.strNSTStatusTypeName + ", "
						+ objStatuTypes_data.strTSTStatusTypeName,
				objResource_data.strResourceName,
				objResourceType_data.strResourceTypeName,
				objTest_data.strRegionName, "", objView_data.strViewName};

		objOffCommonFunc.writeResultData(strTestData,
				strPartialAutoResultsPath, "Events");
		
		gstrResult = "PASS";
	}
	
	/*********************************************************************************************
	'Description 	:  Verify that a user CANNOT be saved by selecting only the 'Update Status'/'Run Reports'/'Associated With' right on a resource without the ‘View Resource’ right.  
	'Date 			: 02-Jul-2015 
	'Author 		: Renushree
	'---------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************/
	@Test(description = "Verify that a user CANNOT be saved by selecting only the 'Update Status'/'Run Reports'/'Associated With' right on a resource without the ‘View Resource’ right. ")
	public void testHappyDay63726() throws Exception {

		gstrTCID = "63726";
		gstrTO = "Verify that a user CANNOT be saved by selecting only the 'Update Status'/'Run Reports'/'Associated With' right on a resource without the ‘View Resource’ right. ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Resource objResource1 = new Resource(this.driver1);

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
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectSetupResourceOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.verErrorHeading()
				.verErrorMsgWhenViewResNotGiven()
				.enterPassword(objUser_data.strUserPwd)
				.enterConfirmPassword(objUser_data.strUserPwd)
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.deselectUpdateStatusOfResource(
						objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickSaveButton()
				.verErrorHeading()
				.verErrorMsgWhenViewResNotGiven()
				.enterPassword(objUser_data.strUserPwd)
				.enterConfirmPassword(objUser_data.strUserPwd)
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.deselectRunReportRight(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickSaveButton()
				.verErrorHeading()
				.verErrorMsgWhenViewResNotGiven()
				.enterPassword(objUser_data.strUserPwd)
				.enterConfirmPassword(objUser_data.strUserPwd)
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickSaveButton()
				.verErrorHeading()
				.verErrorMsgWhenViewResNotGiven()
				.enterPassword(objUser_data.strUserPwd)
				.enterConfirmPassword(objUser_data.strUserPwd)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickSaveButton().enterUsernameInSearchInputField(objUser_data.strNewUserName1).clickSearchButton().verUserInList(objUser_data.strNewUserName1);

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1
				.clickOnUsersLink(objResource_data.strResourceName)
				.verViewResourceChkboxIsSelected(objUser_data.strNewUserName1)
				.verRunReportChkboxIsSelected(objUser_data.strNewUserName1)
				.verUpdateRightChkboxIsSelected(objUser_data.strNewUserName1)
				.verAssociateRightChkboxIsSelected(objUser_data.strNewUserName1);

		objNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName1)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName)
				.verUpdateStatusOfResourceIsSelected(
						objResource_data.strResourceName)
				.verAssociateWithOfResourceIsSelected(
						objResource_data.strResourceName)
				.verRunReportRightSelected(objResource_data.strResourceName)
				.deselectRunReportRight(objResource_data.strResourceName)
				.deselectAssociatedRightCheckBox(
						objResource_data.strResourceName).clickSaveButton()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1).clickSearchButton()
				.verUserInList(objUser_data.strNewUserName1);

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName1)
				.deselectUpdateStatusOfResource(
						objResource_data.strResourceName)
				.deselectAssociatedRightCheckBox(
						objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1).clickSearchButton()
				.verUserInList(objUser_data.strNewUserName1);

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName1)
				.deselectUpdateStatusOfResource(
						objResource_data.strResourceName)
				.deselectRunReportRight(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1).clickSearchButton()
				.verUserInList(objUser_data.strNewUserName1);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
