package requirementGroup.ResourceHierarchies;

import static org.testng.Assert.assertTrue;
import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.NotificationValues;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewCreatingAndDemoteResource extends TestNG_UI_EXTENSIONS{

	public NewCreatingAndDemoteResource() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*********************************************************************************************
	'Description : Verify that sub-resources are not available while creating/editing a resource.
	'Date	 	 : 05-Aug-2015
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************/
	@Test(description = "Verify that sub-resources are not available while creating/editing a resource.")
	public void testHappyDay123342() throws Exception {

		gstrTCID = "123342";
		gstrTO = "Verify that sub-resources are not available while creating/editing a resource.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Resource objResource1 = new Resource(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strstatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// create status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.clickOnCreateNewResourceTypeButton()
				.enterResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.clickStatusType(strstatusTypeValues1)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

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

		// Sub-Resource creation
		objResource.clickOnSubResourcesLink(objResource_data.strResourceName)
				.createSubResourceForResource(
						objResource_data.strSubResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);

		objLogin.clickLogOut();
		
		System.out.println("------------------Precondition ends--------------------");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objResource1
				.navigateToResourceListPageNew()
				.verResourceInList(objResource_data.strResourceName)
				.verifyEditLink(objResource_data.strResourceName)
				.verifyStatusTypeLink(objResource_data.strResourceName)
				.verifyUsersLink(objResource_data.strResourceName)
				.verSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.verCreateNewResourceButtonIsPresent()
				.clickOnEditLinkInResourcePage(objResource_data.strResourceName)
				.verifySRTNotInDropDown(
						objResourceType_data.strSubResourceTypeName)
				.clickOncancelButton()
				.clickOnCreateNewResourceButton()
				.verifySRTNotInDropDown(
						objResourceType_data.strSubResourceTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************
	'Description : Verify that RegAdmin can demote a resource to be a sub resource of another resource.
	'Date	 	 : 07-Jan-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************/
	@Test(description = "Verify that RegAdmin can demote a resource to be a sub resource of another resource.")
	public void testHappyDay105693() throws Exception {

		gstrTCID = "105693";
		gstrTO = "Verify that RegAdmin can demote a resource to be a sub resource of another resource.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// create status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.clickOnCreateNewResourceTypeButton()
				.enterResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.clickStatusType(strStatusTypeValues1)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

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

		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.verResourceListPageIsDisplayed()
				.clickOnDemoteLink(objResource_data.strResourceName)
				.verDemoteResorcePageIsDisplayed(objResource_data.strResourceName)
				.verSelResorceDisplyedAndDisabledInDemoteResPage(objResource_data.strResourceName)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.clickOnChkBoxForResource(objResource_data.strResourceName1)
				.clickOnSaveButton()
				.verResourceInNotInList(objResource_data.strResourceName)
				.clickOnSubResourcesLink(objResource_data.strResourceName1)
				.verSubResourceListPageisDisplayed(
						objResource_data.strResourceName1)
				.verSubResourceinSubResPage(objResource_data.strResourceName);

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.verResourceNameNotDispalyed(objResource_data.strResourceName)
				.verResourceName(objResource_data.strResourceName1)
				.clickCancelButton();

		objUsersList1.clickCreateNewUserButton()
				.verResourceNameNotDispalyed(objResource_data.strResourceName)
				.verResourceName(objResource_data.strResourceName1);

		gstrResult = "PASS";
	}

	
	/*********************************************************************************************
	'Description : Verify that a resource that already has sub resources created under it cannot be demoted.
	'Date	 	 : 11-Jan-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************/
	@Test(description = "Verify that a resource that already has sub resources created under it cannot be demoted.")
	public void testHappyDay107521() throws Exception {

		gstrTCID = "107521";
		gstrTO = "Verify that a resource that already has sub resources created under it cannot be demoted.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// create status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.clickOnCreateNewResourceTypeButton()
				.enterResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.clickStatusType(strStatusTypeValues1)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

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
		System.out.println(objResource_data.strResourceName);

		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName2);

		// Sub-Resource creation
		objResource.clickOnSubResourcesLink(objResource_data.strResourceName2)
				.createSubResourceForResource(
						objResource_data.strSubResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1.verifyEditLink(objResource_data.strResourceName)
				.verifyStatusTypeLink(objResource_data.strResourceName)
				.verifyUsersLink(objResource_data.strResourceName)
				.verifySubResourcesLink(objResource_data.strResourceName)
				.verifyDemoteLink(objResource_data.strResourceName);

		objResource1.verifyEditLink(objResource_data.strResourceName1)
				.verifyStatusTypeLink(objResource_data.strResourceName1)
				.verifyUsersLink(objResource_data.strResourceName1)
				.verifySubResourcesLink(objResource_data.strResourceName1)
				.verifyDemoteLink(objResource_data.strResourceName1);

		objResource1
				.verifyEditLink(objResource_data.strResourceName2)
				.verifyStatusTypeLink(objResource_data.strResourceName2)
				.verifyUsersLink(objResource_data.strResourceName2)
				.verSubResources1LinkInResourceList(objResource_data.strResourceName2)
				.verifyDemoteLinkNotDisplayed(objResource_data.strResourceName2);

		objResource1
				.verResourceListPageIsDisplayed()
				.clickOnDemoteLink(objResource_data.strResourceName)
				.verDemoteResorcePageIsDisplayed(
						objResource_data.strResourceName)
				.verSelResorceDisplyedAndDisabledInDemoteResPage(
						objResource_data.strResourceName)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.clickOnChkBoxForResource(objResource_data.strResourceName1)
				.clickOnSaveButton()
				.verResourceInNotInList(objResource_data.strResourceName)
				.clickOnSubResourcesLink(objResource_data.strResourceName1)
				.verSubResourceListPageisDisplayed(
						objResource_data.strResourceName1)
				.verSubResourceinSubResPage(objResource_data.strResourceName)
				.verCreateNewSubResourceButtonIsPresent();

		gstrResult = "PASS";
	}
	
	
	/*********************************************************************************************
	'Description :Verify that only RegAdmin can Demote a resource.
	'Date	 	 : 08-Jan-2016
	'Author		 : Sangappa K
	'---------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************/
	@Test(enabled=false,description = "Verify that only RegAdmin can Demote a resource.")
	public void testHappyDay107519() throws Exception {

		gstrTCID ="107519";
		gstrTO = "Verify that only RegAdmin can Demote a resource.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// create status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.clickOnCreateNewResourceTypeButton()
				.enterResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.clickStatusType(strStatusTypeValues1)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		System.out.println(objResourceType_data.strSubResourceTypeName);

		// Res1
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Res2

		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		System.out.println(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName1);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectSetupResourceOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.verResourceListPageIsDisplayed()
				.clickOnDemoteLink(objResource_data.strResourceName)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.clickOnChkBoxForResource(objResource_data.strResourceName1)
				.clickOnSaveButton()
				.verResourceInNotInList(objResource_data.strResourceName)
				.clickOnSubResourcesLink(objResource_data.strResourceName1)
				.verSubResourceListPageisDisplayed(
						objResource_data.strResourceName1)
				.verSubResourceinSubResPage(objResource_data.strResourceName);
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();
		
		objResource1.verDemoteLinkNotPresentForAscRes(objResource_data.strResourceName1)
		             .verSubResources1LinkInResourceList(objResource_data.strResourceName1)
		            .verifyEditLink(objResource_data.strResourceName1);        
		  objLogin1.clickLogOut();        

		gstrResult = "PASS";
	}
	
	
	/*********************************************************************************************
	'Description :Verify that user cannot demote a resource that is participating in an event.
	'Date	 	 : 11-Jan-2016
	'Author		 : Sangappa K
	'---------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************/
	@Test(enabled=false,description ="Verify that user cannot demote a resource that is participating in an event.")
	public void testHappyDay107522() throws Exception {

		gstrTCID ="107522";
		gstrTO = "Verify that user cannot demote a resource that is participating in an event.";
	
		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		User_data objUserdata = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement EventManagement_page = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// create status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.clickOnCreateNewResourceTypeButton()
				.enterResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.clickStatusType(strStatusTypeValues1)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		System.out.println("Sub REs" + objResourceType_data.strSubResourceTypeName);

		// Res1
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Res2

		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);
		
		

		System.out.println("RS1" +  objResource_data.strResourceName);

		
		System.out.println("RS2" +  objResource_data.strResourceName1);
	

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		
		// create Event template
				objEventSetUp.navigateToEventSetUp();

				String[] strstatusTypeValues1 = {strStatusTypeValues[0]};
				
				
				objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
						strstatusTypeValues1)
						.deselectSelectAllWebOption();
				objLogin.clickLogOut();
			    
			    System.out.println("-----Precondition ends and test execution starts-------");
			    
			    objLogin.loginAsNewUser(objUserdata.strNewUserName, objUserdata.strNewPassword);
			
			    objRegionDefault.selectFrame();
			
			    EventManagement_page.navigateToEventManagement()
			    
			    .clickOnCreateNewEvent()
			    
			    .clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
			    
			    .enterAdHocEventName(objEvent_data.strEventName)
				
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				
				.selectResource(strResourceValue[0])
			   
				.clickOnSaveButton()
				
				.verifyEventName(objEvent_data.strEventName);
			    
			    System.out.println(objEvent_data.strEventName);
	
		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.verResourceListPageIsDisplayed()
				.verResourceInList(objResource_data.strResourceName)
				.verResourceInList(objResource_data.strResourceName1)
				.clickOnDemoteLink(objResource_data.strResourceName)
	
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.clickOnChkBoxForResource(objResource_data.strResourceName1)
				.clickOnSaveButton()
				.verCantDemoteResInOnGoingEventErrorMsg()
				.clickOncancelButton()
				.clickOnSubResourcesLink(objResource_data.strResourceName1)
				.verSubResourceListPageisDisplayed(
						objResource_data.strResourceName1)
				.verSubResourceNotinSubResPage(
						objResource_data.strResourceName,
						objResourceType_data.strSubResourceTypeName)
				.verCreateNewSubResourceButtonIsPresent();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************
	'Description : Verify that user can demote a resource that is included in a region view.
	'Date	 	 : 12-Jan-2016
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************/
	@Test(description = "Verify that user can demote a resource that is included in a region view.")
	public void testHappyDay107524() throws Exception {

		gstrTCID = "107524";
		gstrTO = "Verify that user can demote a resource that is included in a region view.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Views objViews1 = new Views(this.driver1);

		String strStatusTypeValues[] = new String[4];
		String strStatusTypeValues1[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		// create status types
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);
		
		objStatusTypeList.createNewStatus(
			     objStatuTypes_data.strStatusNameInMulti,
			     objStatuTypes_data.strStatusColor)

			  .createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
			      objStatuTypes_data.strStatusColor)

			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.clickOnCreateNewResourceTypeButton()
				.enterResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.clickStatusType(strStatusTypeValues1)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

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
		System.out.println(objResource_data.strResourceName);

		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToViews();
//
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };

//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewName, objResource_data.strResourceName, strStatusTypeNames);
		
		System.out.println(objView_data.strViewName);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objViewsList1.verResAndStatusTypes(strResourceTypeValue[0],
					objResource_data.strResourceName, strStatusTypeNames[i]);
		}

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.verResourceListPageIsDisplayed()
				.clickOnDemoteLink(objResource_data.strResourceName)
				.verDemoteResorcePageIsDisplayed(
						objResource_data.strResourceName)
				.verSelResorceDisplyedAndDisabledInDemoteResPage(
						objResource_data.strResourceName)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.clickOnChkBoxForResource(objResource_data.strResourceName1)
				.clickOnSaveButton()
				.verResourceInNotInList(objResource_data.strResourceName)
				.clickOnSubResourcesLink(objResource_data.strResourceName1)
				.verSubResourceListPageisDisplayed(
						objResource_data.strResourceName1)
				.verSubResourceinSubResPage(objResource_data.strResourceName)
				.verCreateNewSubResourceButtonIsPresent();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.vererrorMsgInViewPage();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************************
	'Description :Verify that status change preferences set for a demoted resource is retained.
	'Date	 	 : 12-Jan-2016
	'Author		 : Sangappa K
	'---------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************/
	@Test(description ="Verify that status change preferences set for a demoted resource is retained.")
	public void testHappyDay122271() throws Exception {

		gstrTCID ="122271";
		gstrTO = "Verify that status change preferences set for a demoted resource is retained.";
		
		
		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		User_data objUserdata = new User_data();
		
		View_data objView_data = new View_data();
		NotificationValues objNotificationValues = new NotificationValues();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Date_Time_settings dts = new Date_Time_settings();
		

		String strStatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// create status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.
		
		createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)

		.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
				objStatuTypes_data.strStatusColor);

     strStatusesValues[0] = objStatusTypeList
		.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

      objStatusTypeList.createNewStatus(
    		  objStatuTypes_data.strStatusNameInMulti1,
		objStatuTypes_data.strStatusColor);

     strStatusesValues[1] = objStatusTypeList
		.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

        objStatusTypeList.clickOnReturnToStatusTypeList();

     strStatusTypeValues[1] = objStatusTypeList
		.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSSTStatusTypeName);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.clickOnCreateNewResourceTypeButton()
				.enterResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.clickStatusType(strStatusTypeValues)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		System.out.println("Sub REs" + objResourceType_data.strSubResourceTypeName);

		// Res1
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Res2

		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);
		
		System.out.println("RS1" +  objResource_data.strResourceName);
		System.out.println("RS2" +  objResource_data.strResourceName1);
	
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)		
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)	
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectEditStatusChangeNotPrefernceOption()
				.selectConfigureRegionViewsOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		
		objViewsList.navigateToViewsList();
		 String strStatusTypeNames[] = {objStatuTypes_data.strNSTStatusTypeName, objStatuTypes_data.strMSTStatusTypeName, objStatuTypes_data.strSSSTStatusTypeName};
		 String strResource[] = {objResource_data.strResourceName, objResource_data.strResourceName1};
		 
		objViewsList.createViewForMultipleResourcesAndStatusTypes(objView_data.strViewName, objView_data.strViewDesc, strResource, strStatusTypeNames);
//		.clickCreateNewViewButton()
//		.enterViewName(objView_data.strViewName)
//		.enterViewDesc(objView_data.strViewDesc)
//		.selectStatusTypeForView(strStatusTypeValues)
//		.selectResourceType(strResourceTypeValue[0])
//		.clickOnSaveOfCreateNewView();
//		
		System.out.println(objView_data.strViewName);
	
	    objLogin.clickLogOut();
			    
	System.out.println("-----Precondition ends and test execution starts-------");
			    
			    
	 objLogin1.loginAsNewUser(objUserdata.strNewUserName, objUserdata.strNewPassword);
			
		objRegionDefault1.selectFrame();
			    
		
	// Edit My Status Change preferences

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
						.clickOnAdd()
						.enterResNameInWhatField(objResource_data.strResourceName)
						.clickOnSearch()
						.selectResource(strResourceValue[0])
						.clickOnNotifications()
						.expandUncategorizedSec()
						.verStatusTypesUnderUncategorizedSec(
								objStatuTypes_data.strNSTStatusTypeName)
						.verStatusTypesUnderUncategorizedSec(
								objStatuTypes_data.strMSTStatusTypeName)
						.verStatusTypesUnderUncategorizedSec(
								objStatuTypes_data.strSSSTStatusTypeName);
		
		objStatusChangePreference1
		.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
				objNotificationValues.strAboveVal)
		.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
				objNotificationValues.strBelowVal)
		.selEmailPagerWebChkBoxesForAboveAndBelowVal(
				strResourceValue[0], strStatusTypeValues[0])

		.enterAboveValues(strResourceValue[0], strStatusTypeValues[2],
				objNotificationValues.strAboveValForSST)
		.enterBelowValues(strResourceValue[0], strStatusTypeValues[2],
				objNotificationValues.strBelowValForSST)
		.selEmailPagerWebChkBoxesForAboveAndBelowVal(
				strResourceValue[0], strStatusTypeValues[2])

		.selWebChkBoxForStatuses(strResourceValue[0],
				strStatusTypeValues[1], strStatusesValues[0])
		.selPagerChkBoxForStatuses(strResourceValue[0],
				strStatusTypeValues[1], strStatusesValues[0])
		.selEmailChkBoxForStatuses(strResourceValue[0],
				strStatusTypeValues[1], strStatusesValues[0])

		.selWebChkBoxForStatuses(strResourceValue[0],
				strStatusTypeValues[1], strStatusesValues[1])
		.selPagerChkBoxForStatuses(strResourceValue[0],
				strStatusTypeValues[1], strStatusesValues[1])
		.selEmailChkBoxForStatuses(strResourceValue[0],
				strStatusTypeValues[1], strStatusesValues[1])
		.clickOnSave();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
		objUpdateStatus1
				.clickOnSelectAll()
		
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strAboveValueForUpdate1)
		
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[1])
		
				.enterUpdateSSTValues(strStatusTypeValues[2],
						objView_data.strValueForSST).clickOnSaveButton();
		
		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");
		
		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");
		
		System.out.println("strUpdatedTime" + strUpdatedTime);
		
		objUpdateStatus1.verWebNotificationframe();
		
		objUpdateStatus1.verWebNotificationForStatusUpdateForNST(
				objResource_data.strResourceName,
				objStatuTypes_data.strSSSTStatusTypeName,
				objView_data.strUpdatedValForSST, strUpdatedTime);
		
		objUpdateStatus1.verWebNotificationForStatusUpdate(
				objResource_data.strResourceName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusNameInMulti1, strUpdatedTime);
		
		objUpdateStatus1.clickAcknowledgeAllNotifications().selectFrame();
		
		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + "";

		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation;


		String strMsgBody1 =
		objMailVerificationFunctions
				.getStatusChangeEmailBodyWithAsstdRescrsForNST(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strAboveValueForUpdate1,
						objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName,objResource_data.strResourceName1);
		

		String strMsgBody2 = objMailVerificationFunctions
				.getStatusChangeEmailBodyWithAssctdRescrsForMST(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusNameInMulti1,
						objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName,objResource_data.strResourceName1);
	

		String strMsgBody3 = objMailVerificationFunctions
				.getStatusChangeEmailBodyWithAsstdRescrsForNST(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatuTypes_data.strSSSTStatusTypeName,
						objView_data.strUpdatedValForSST,
						objLogindata.strRegionName,
						objResourceType_data.strResourceTypeName,objResource_data.strResourceName1);
	
		
		String strMsgBody4 = objMailVerificationFunctions
				.getStatusChangePagerBodyForWithAsstdRescrsForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strAboveValueForUpdate1,
						objLogindata.strRegionName,objResource_data.strResourceAbbrivation);
		
		String strMsgBody5 = objMailVerificationFunctions
				.getStatusChangePagerBodyForWithAsstdRescrsForMST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusNameInMulti1,
						objLogindata.strRegionName,objResource_data.strResourceAbbrivation);
		

		String strMsgBody6 = objMailVerificationFunctions
				.getStatusChangePagerBodyForWithAsstdRescrsForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatuTypes_data.strSSSTStatusTypeName,
						objView_data.strUpdatedValForSST,
						objLogindata.strRegionName,objResource_data.strResourceAbbrivation);
		

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
				
			}

			if (boolCheck1 == false) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}

			if (boolCheck2 == false) {
				boolCheck2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		

		assertTrue(boolCheck && boolCheck1 && boolCheck2);

		boolean boolCheck3 = false;
		boolean boolCheck4 = false;
		boolean boolCheck5 = false;
		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjectForPager);

			if (boolCheck3 == false) {
				boolCheck3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody4);
			}

			if (boolCheck4 == false) {
				boolCheck4 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody5);
			}

			if (boolCheck5 == false) {
				boolCheck5 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody6);
			}

			objMailVerificationFunctions.backToMailInbox();

		}
		
		assertTrue(boolCheck3 && boolCheck4 && boolCheck5);

		objMailVerificationFunctions.logoutMail();
	
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.verResourceListPageIsDisplayed()
				.verResourceInList(objResource_data.strResourceName)
				.verResourceInList(objResource_data.strResourceName1)
				.clickOnDemoteLink(objResource_data.strResourceName)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.clickOnChkBoxForResource(objResource_data.strResourceName1)
				.clickOnSaveButton()
				.verResourceInNotInList(objResource_data.strResourceName);
				
		objLogin1.clickLogOut();
		
		
	    objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

        objNavigationToSubmenus1.navigateStatusChangeInPreferences();
        
		objStatusChangePreference1
				.verStatusTypeNotificationBelow(
						objStatuTypes_data.strNSTStatusTypeName)
				.verStatusTypeNotificationBelow(
						objStatuTypes_data.strMSTStatusTypeName)
				.verStatusTypeNotificationBelow(
						objStatuTypes_data.strSSSTStatusTypeName);
  
		objStatusChangePreference1
				.verAboveAndBelowValues(
						objStatuTypes_data.strNSTStatusTypeName,
						objNotificationValues.strAboveVal,
						objNotificationValues.strBelowVal)
				.verAboveAndBelowValues(
						objStatuTypes_data.strSSSTStatusTypeName,
						objNotificationValues.strAboveValForSST,
						objNotificationValues.strBelowValForSST)
				.verValueForMultiST(objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusNameInMulti)
				.verValueForMultiST2(objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusNameInMulti1);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}	
}
