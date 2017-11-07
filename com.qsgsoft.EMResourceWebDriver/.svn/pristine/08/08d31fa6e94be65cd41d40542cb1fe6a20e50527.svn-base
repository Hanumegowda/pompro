package requirementGroup.SettingUpResources;

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
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseProvideResourceRights extends TestNG_UI_EXTENSIONS{
	
	public EdgeCaseProvideResourceRights() throws Exception {
		super();
	}
	
	/*************************************************************************************
	'Description : Verify that Associated right selected for a resource from 'Assign users for 
	               resources' screen remains selected for the resource RS in the edit user screen
	'Precondition:
	'Date	 	 : 10-Mar-2016
	'Author		 : Sangappa K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that Associated right selected for a resource from 'Assign users for resources' "
			+ "screen remains selected for the resource RS in the edit user screen")
	public void testEdgeCase112695() throws Exception {

		gstrTCID ="112695";
		gstrTO = "Verify that Associated right selected for a resource from 'Assign users for resources' screen remains"
				+ " selected for the resource RS in the edit user screen";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		String strStatusTypeValues[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithExpirationTime(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
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
				.clickOnSaveButton()

				.verAssignUserstoResourcePageIsDisplayed(
						objResource_data.strResourceName)
				.selectAssociatedWithCheckBox(objUserdata.strNewUserName)
				.selectViewResourceCheckBox(objUserdata.strNewUserName)
				.clickOnSaveButton();

		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strEquals)
				.editUserDetails(objUserdata.strNewUserName)
				.verAssociateWithOfResourceIsSelected(
						objResource_data.strResourceName)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName).clickSaveButton();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that Update right selected for a resource from 'Assign users for resources' screen remains selected for the resource RS in the edit user screen  
	'Precondition	: 
	'Date 			: 10-Mar-2016 
	'Author 		: Renushree 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that Update right selected for a resource from 'Assign users for resources' screen remains selected for the resource RS in the edit user screen ")
	public void testEdgeCase112699() throws Exception {

		gstrTCID = "112699";
		gstrTO = "Verify that Update right selected for a resource from 'Assign users for resources' screen remains selected for the resource RS in the edit user screen ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		String strstatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName);

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objResource1
				.navigateToResourceListPageNew()
				.verCreateNewResourceButtonIsPresent()
				.createResource(objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName)
				.clickOnUsersLink(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objUser_data.strNewUserName)
				.selectUpdateStatusOfResource(objUser_data.strNewUserName)
				.clickOnSaveButton();

		objUsersList1
				.navigateToUsersNew()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName)
				.verUpdateStatusOfResourceIsSelected(
						objResource_data.strResourceName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that Run report right selected for a resource from 'Assign users for resources' screen remains selected for the resource RS in the edit user screen  
	'Precondition	: 
	'Date 			: 10-Mar-2016 
	'Author 		: Renushree 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that Run report right selected for a resource from 'Assign users for resources' screen remains selected for the resource RS in the edit user screen")
	public void testEdgeCase112701() throws Exception {

		gstrTCID = "112701";
		gstrTO = " Verify that Run report right selected for a resource from 'Assign users for resources' screen remains selected for the resource RS in the edit user screen";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		String strstatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName);

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objResource1
				.navigateToResourceListPageNew()
				.verCreateNewResourceButtonIsPresent()
				.createResource(objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName)
				.clickOnUsersLink(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objUser_data.strNewUserName)
				.selectRunReportCheckBox(objUser_data.strNewUserName)
				.clickOnSaveButton();

		objUsersList1
				.navigateToUsersNew()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName)
				.verViewResourceCheckBoxIsChecked(
						objResource_data.strResourceName)
				.verRunReportRightSelected(
						objResource_data.strResourceName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that contact section on 'View Resource Detail' screen displays only the user's with associate right on resource RS.  
	'Precondition	: 
	'Date 			: 14-Mar-2016 
	'Author 		: Renushree 
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that contact section on 'View Resource Detail' screen displays only the user's with associate right on resource RS.")
	public void testEdgeCase112679() throws Exception {

		gstrTCID = "112679";
		gstrTO = "Verify that contact section on 'View Resource Detail' screen displays only the user's with associate right on resource RS.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Views objViews1 = new Views(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objResourceType.navigateToResourceTypePage().createResourceType(
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

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName};

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strAllStatausTypes);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName2)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName3,
						objUser_data.strNewPassword, objUser_data.strFullName3)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strAllStatausTypes[i]);
		}

		objViews1.clickOnResource(objResource_data.strResourceName)
				.verViewResourceDetailsPgeIsDisplayed()
				.verResourceScreenDisplayed(objResource_data.strResourceName);
		
		objViewsList1.verAssociatedUsrInContactTable(objUser_data.strFullName1)
				.verAssociatedUsrNotInContactTable(objUser_data.strFullName)
				.verAssociatedUsrNotInContactTable(objUser_data.strFullName2)
				.verAssociatedUsrNotInContactTable(objUser_data.strFullName3);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that private event associated with resource RS can be viewed by user who has update and run report right on resource RS
	'Precondition	:
	'Date 			: 14-Mar-2014 
	'Author 		: Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************/
	@Test(description = "Verify that private event associated with resource RS can be viewed by user who has update and run report right on resource RS")
	public void testEdgeCase112683() throws Exception {

		gstrTCID = "112683";
		gstrTO = "Verify that private event associated with resource RS can be viewed by user who has update and run report right on resource RS";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

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

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectMaintainEventsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName2)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName3,
						objUser_data.strNewPassword, objUser_data.strFullName3)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickPrivateCheckBox();

		objResource1.clickResource(strResourceValue);

		objEventManagement1.clickOnSaveButton();

		System.out.println("event name" + objEvent_data.strEventName);

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strEventName).clickOnEventNameInEventBanner(
				objEvent_data.strEventName);

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName};

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatausTypes[i]);
		}

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strEventName).clickOnEventNameInEventBanner(
				objEvent_data.strEventName);

		objEventStatus1.verifyErrorMessageDisplayed();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName3,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strEventName).clickOnEventNameInEventBanner(
				objEvent_data.strEventName);

		objEventStatus1.verifyErrorMessageDisplayed();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.verifyEventNameInEventBanner(
				objEvent_data.strEventName).clickOnEventNameInEventBanner(
				objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatausTypes[i]);
		}

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
