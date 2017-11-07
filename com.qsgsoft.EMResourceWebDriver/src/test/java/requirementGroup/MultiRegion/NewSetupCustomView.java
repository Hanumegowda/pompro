package requirementGroup.MultiRegion;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.NotificationValues;
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
import lib.page.FindResources;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.Map;
import lib.page.OtherRegions;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewSetupCustomView extends TestNG_UI_EXTENSIONS {
	
	public NewSetupCustomView() throws Exception {
		super();
	}

	/*************************************************************************************
	 * 'Description 	: Verify that a user without 'View Custom View' right, does not have the option to add resource to custom view after searching for resources. 
	 * 'Precondition	: 
	 * 'Date 			: 15-Jun-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that a user without 'View Custom View' right, does not have the option to add resource to custom view after searching for resources.")
	public void testHappyDay69795() throws Exception {

		gstrTCID = "69795";
		gstrTO = "Verify that a user without 'View Custom View' right, does not have the option to add resource to custom view after searching for resources.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		FindResources objFindResources1 = new FindResources(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners1.clickOnSearch();

		objFindResources1.verifyFindResourcePageDisplayed()
				.enterResNameInSearchField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceNamesInList(objResource_data.strResourceName)
				.verAddToCustomViewNotdisplayed();

		objNavigationToSubmenus1.mouseHoverOnPreferences()
				.verCustumizedViewOfPrefNotDisplayed();

		objNavigationToSubmenus1.clickOnPreferences()
				.verCustumizedViewOfPrefNotDisplayed();

		objNavigationToSubmenus1.mouseHoverOnViewMenu().verCustomNotDisplayed();

		objNavigationToSubmenus1.clickOnViewMenu().verCustomNotDisplayed();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that a user created by selecting a role with 'View custom view' right has the option to add resources to custom view after searching for resources. 
	 * 'Precondition	: 
	 * 'Date 			: 15-Jun-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that a user created by selecting a role with 'View custom view' right has the option to add resources to custom view after searching for resources.")
	public void testHappyDay69804() throws Exception {

		gstrTCID = "69804";
		gstrTO = "Verify that a user created by selecting a role with 'View custom view' right has the option to add resources to custom view after searching for resources.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Roles_data objRoles_data = new Roles_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		FindResources objFindResources1 = new FindResources(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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
		
		objResource.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);
		
		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRoles_data.strRoleName)
				.selectViewCustomView().clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToCustomizedViewInPrefrences();
		
		String arrResourceNames[] = { objResource_data.strResourceName };
		String arrResVal[] = {strResourceValue[0]};
		String [] strStatusTypeNames = {objStatusTypes_data.strNSTStatusTypeName};
		
		objCustomUnderView.verEditCustomViewScreenIsDisplayed()
						  .clickOnAddMoreResources()
						  .enterResNameInWhatField(objResource_data.strResourceName)
						  .clickOnSearch()
						  .selectResource(arrResVal)
						  .clickOnAddToCustomView()
						  .clickOnOptions()
						  .selectStatusTypes(strStatusTypeValues)
						  .clickOnSave()
						  .verResourceAndResTypeInCustomViewTablePage(arrResourceNames,
								  objResourceType_data.strResourceTypeName)
						  .verStatusTypeInCustomViewTablePage(strStatusTypeNames);

		objLinksAtTopRightCorners1.clickOnSearch();

		String arrResourceNames1[] = { objResource_data.strResourceName, objResource_data.strResourceName1 };
		String arrResVal1[] = {strResourceValue[1]};
		
		objFindResources1.verifyFindResourcePageDisplayed()
				.enterResNameInSearchField(objResource_data.strResourceName1)
				.clickOnSearch();
		
		objCustomUnderView.selectResource(arrResVal1)
				  .clickOnAddToCustomView()
				  .clickOnOptions()
				  .verEditCustomViewOptionsColumnIsDisplayed()
				  .clickOnSave()
				  .verResourceAndResTypeInCustomViewTablePage(arrResourceNames1,
						  objResourceType_data.strResourceTypeName)
				  .verStatusTypeInCustomViewTablePage(strStatusTypeNames);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that only RegAdmin has the option to share resources.  
	 * 'Precondition	: 
	 * 'Date 			: 16-Jun-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that only RegAdmin has the option to share resources. ")
	public void testHappyDay69812() throws Exception {

		gstrTCID = "69812";
		gstrTO = "Verify that only RegAdmin has the option to share resources. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		OtherRegions objOtherRegions = new OtherRegions(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		OtherRegions objOtherRegions1 = new OtherRegions(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strStateWideReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectadministerOtherRegionViewsOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createSharedResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objResource.createSharedResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToOtherRegions();

		objOtherRegions.verifyOtherRegionListPage()
				.verSharedResourcesBtnPresent()
				.verSharedStatusTypesBtnPresent();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToOtherRegions();
		
		objOtherRegions1.verifyOtherRegionListPage()
				.verSharedResourcesBtnPresent()
				.verSharedStatusTypesBtnPresent();

		objLogin1.clickLogOut();
		
		System.out.println(objResourceType_data.strResourceTypeName);

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strStateWideReg);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToOtherRegions();

		objOtherRegions1
				.clickSharedResources()
				.verEditOtherRegionSecurityResourcesScreenIsDisplayed()
				.verResourcesListedInEditOtherRegionSecResScreen(
						objResource_data.strResourceName,
						objResourceType_data.strResourceTypeName)
				.verResourcesListedInEditOtherRegionSecResScreen(
						objResource_data.strResourceName1,
						objResourceType_data.strResourceTypeName)
				.selResourceInEditOtherRegionSecResScreen(strResourceValue[0])
				.selResourceInEditOtherRegionSecResScreen(strResourceValue[1])
				.clickOnSave()
				.verifyOtherRegionListPage()
				.clickSharedResources()
				.verResourceInEditOtherRegionSecResScreenSelected(
						strResourceValue[0])
				.verResourceInEditOtherRegionSecResScreenSelected(
						strResourceValue[1]);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToOtherRegions();

		objOtherRegions1
				.clickSharedResources()
				.verifyOtherRegionSharedResourcesPage()
				.verResSelectedAndDisabledInViewOtherRegionSecurityRes(
						strResourceValue[0])
				.verResSelectedAndDisabledInViewOtherRegionSecurityRes(
						strResourceValue[1]).clickBackButton();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that only RegAdmin has the option to share status types.   
	 * 'Precondition	: 
	 * 'Date 			: 16-Jun-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that only RegAdmin has the option to share status types. ")
	public void testHappyDay84682() throws Exception {

		gstrTCID = "84682";
		gstrTO = "Verify that only RegAdmin has the option to share status types. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		OtherRegions objOtherRegions1 = new OtherRegions(this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strStateWideReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectadministerOtherRegionViewsOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createSharedResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objLogin.clickLogOut();

		System.out.println(objResourceType_data.strResourceTypeName);

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strStateWideReg);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToOtherRegions();

		objOtherRegions1
				.clickSharedStatusTypes()
				.verEditOtherRegionSecurityScreenIsDisplayed()
				.verStatusTypeInEditOtherRegionSecurityStatusTypes(
						objStatusTypes_data.strTSTStatusTypeName)
				.verStatusTypeInEditOtherRegionSecurityStatusTypesSelected(
						strStatusTypeValues[0])
				.verStatusTypeNotInEditOtherRegionSecurityStatusTypes(
						objStatusTypes_data.strNDSTStatusTypeName)
				.selStatusTypeInEditOtherRegionSecurityStatusTypes(
						strStatusTypeValues[1])
				.clickOnSave()
				.verifyOtherRegionListPage()
				.clickSharedStatusTypes()
				.verStatusTypeInEditOtherRegionSecurityStatusTypesSelected(
						strStatusTypeValues[0])
				.verStatusTypeInEditOtherRegionSecurityStatusTypesSelected(
						strStatusTypeValues[1]);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToOtherRegions();

		objOtherRegions1
				.clickSharedStatusTypes()
				.verifyOtherRegionSharedStatusTypePage()
				.verSTSelectedAndDisabledInViewOtherRegionSecurityS(
						strStatusTypeValues[0])
				.verSTSelectedAndDisabledInViewOtherRegionSecurityS(
						strStatusTypeValues[1])
				.verStatusTypeNotInEditOtherRegionSecurityStatusTypes(
						objStatusTypes_data.strNDSTStatusTypeName)
				.clickBackButton();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************************
	 * 'Description 	: Create a custom view selecting multiple resources, verify that event banners
	                      of only the region to which the resource belongs to and the region to
	                      which the user has logged in are displayed in the resource detail screen.
	 * 'Date 			: 11-Feb-2016 
	 * 'Author 			: Anitha
	 * '----------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                                    Modified By 
	 * 'Date                                                                        Name
	 **************************************************************************************************/
	//Bug exist(EMS-    )In step 6 it fails
	@Test(description = "Create a custom view selecting multiple resources, verify that event banners of "
			+ "only the region to which the resource belongs to and the region to which the user has"
			+ " logged in are displayed in the resource detail screen.")
	public void testHappyDay71363() throws Exception {

		gstrTCID = "71363";
		gstrTO = "Create a custom view selecting multiple resources, verify that event banners of only "
				+ "the region to which the resource belongs to and the region to which the user has logged "
				+ "in are displayed in the resource detail screen.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEventdata = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		Views objViews1=new Views(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		CustomUnderView ObjCustomUnderView1 = new CustomUnderView(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[4];
		String strResourceTypeValue[] = new String[4];
		String strResourceValue[] = new String[4];
		String strRegionValue[] = new String[4];
		
		String strRegionA = objLogindata.strAbileneRegion;
		String strRegionB = objLogindata.strStateWideReg;
		String strRegionC = objLogindata.strArkansasReg;
		String strRegionD = objLogindata.strTexacBracRegion;

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(strRegionA);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page.getRegionValue(strRegionA);

		strRegionValue[1] = objRegions_page.getRegionValue(strRegionB);

		strRegionValue[2] = objRegions_page.getRegionValue(strRegionC);

		strRegionValue[3] = objRegions_page.getRegionValue(strRegionD);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewOtherRegView(objLogindata.strTexacBracOtherRegionValue)
				.clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName1,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName1)
				.selectRegion(strRegionValue[1])
				.selectRegion(strRegionValue[2])
				.selectRegion(strRegionValue[3]).clickSaveButton();
		
		//Region B
		objSelectRegionpage.selectRegionAndNavigate(strRegionB);
		
		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.selectFirstRole()
				.selectViewOtherRegView(
						objLogindata.strArkansasRegVal2)
				.clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption()
				.clickSaveButton()
				
				.searchUserName(objUserdata.strNewUserName1,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
						.editUserDetails(objUserdata.strNewUserName1)			
						.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();
		
		//Region A
		objSelectRegionpage.selectRegionAndNavigate(strRegionA);
				
		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		String[] strStatusTypeValues1 = { strStatusTypeValues[0] };
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
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
		
		System.out.println(objResourceType_data.strResourceTypeName);
		
		objEventSetUp.navigateToEventSetUp();

		String[] strResourceTypeValue1={strResourceTypeValue[0]};
		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition,
				strResourceTypeValue1, strStatusTypeValues1)
				.deselectSelectAllWebOption();
		
		//Region B
		objSelectRegionpage.selectRegionAndNavigate(strRegionB);
		
		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		String[] strStatusTypeValues2 = { strStatusTypeValues[1] };
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1, strStatusTypeValues2);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);
		
		System.out.println(objResourceType_data.strResourceTypeName1);
		
		objEventSetUp.navigateToEventSetUp();

		String[] strResourceTypeValue2={strResourceTypeValue[1]};
		
		objEventSetUp.createEventTemplate(
				objEventSetUp_data.strEventTemplate1,
				objEventSetUp_data.strTemplateDefinition,
				strResourceTypeValue2, strStatusTypeValues2)
				.deselectSelectAllWebOption();
		
		//Region C
		objSelectRegionpage.selectRegionAndNavigate(strRegionC);
		
		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName2);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		String[] strStatusTypeValues3 = { strStatusTypeValues[2] };
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName2, strStatusTypeValues3);

		strResourceTypeValue[2] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName2);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createSharedResourceWithAddress(objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName2,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[2] = objResource
				.getResourceValue(objResource_data.strResourceName2);
		
		System.out.println(objResourceType_data.strResourceTypeName2);
		
		objEventSetUp.navigateToEventSetUp();

		String[] strResourceTypeValue3={strResourceTypeValue[2]};
		
		objEventSetUp.createEventTemplate(
				objEventSetUp_data.strEventTemplate2,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue3,
				strStatusTypeValues3)
				.deselectSelectAllWebOption();
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.searchUserName(objUserdata.strNewUserName1,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName1)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();
		
		//Region D
		objSelectRegionpage.selectRegionAndNavigate(strRegionD);
		
		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName3,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName3);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		String[] strStatusTypeValues4 = { strStatusTypeValues[3] };
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName3, strStatusTypeValues4);

		strResourceTypeValue[3] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName3);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createSharedResourceWithAddress(objResource_data.strResourceName3,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName3,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[3] = objResource
				.getResourceValue(objResource_data.strResourceName3);
		
		System.out.println(objResourceType_data.strResourceTypeName3);
		
		objEventSetUp.navigateToEventSetUp();

		String[] strResourceTypeValue4={strResourceTypeValue[3]};
		
		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate3,
				objEventSetUp_data.strTemplateDefinition,
				strResourceTypeValue4, strStatusTypeValues4)
				.deselectSelectAllWebOption();
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.searchUserName(objUserdata.strNewUserName1,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName1)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();
		
		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		//Region A Event1
		objSelectRegionpage.selectRegionAndNavigate(strRegionA);

		objRegionDefault.selectFrame();
		
		String[] strResourceValue1={strResourceValue[0]};
		objEventManagement.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEventdata.strEventName)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue1).clickOnSaveButton();
		
		//Region B Event2
		objSelectRegionpage.selectRegionAndNavigate(strRegionB);
		
		objRegionDefault.selectFrame();
		
		String[] strResourceValue2={strResourceValue[1]};
		objEventManagement.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate1)
				.enterAdHocEventName(objEventdata.strEventName1)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue2).clickOnSaveButton();
		
		//Region C Event3
		objSelectRegionpage.selectRegionAndNavigate(strRegionC);
		
		objRegionDefault.selectFrame();

		String[] strResourceValue3 = { strResourceValue[2] };
		objEventManagement.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate2)
				.enterAdHocEventName(objEventdata.strEventName2)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue3).clickOnSaveButton();
		
		//Region D Event4
		objSelectRegionpage.selectRegionAndNavigate(strRegionD);
		
		objRegionDefault.selectFrame();

		String[] strResourceValue4 = { strResourceValue[3] };
		objEventManagement.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate3)
				.enterAdHocEventName(objEventdata.strEventName3)
				.enterAdHocEventDescription(objEventdata.strEventDescription)
				.selectResource(strResourceValue4).clickOnSaveButton();
		
		objLogin.clickLogOut();
	
		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objSelectRegionpage1.selectRegionAndNavigate(strRegionB);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomizedViewInPrefrences();
		
		String strRS = objResource_data.strResourceName.substring(3);
		
		ObjCustomUnderView1.clickOnAddMoreResources()
				.enterResNameInWhatField(strRS).clickOnSearch()
				.selectResource(strResourceValue).clickOnAddToCustomView()
				.clickOnOptions().selectStatusTypes(strStatusTypeValues)
				.selectAllChkBoxInOptions().clickOnSave();

		//RS1
		objViews1.clickOnResource(objResource_data.strResourceName);

		objEventManagement1.verifyEventNameInOtherRegion(strRegionB,
				objEventdata.strEventName1).verifyEventNameInOtherRegion(
				strRegionA, objEventdata.strEventName);

		objEventManagement1.verifyEventNameNotDisplayedInEventBanner(
				objEventdata.strEventName2)
				.verifyEventNameNotDisplayedInEventBanner(
						objEventdata.strEventName3);
		
		//RS2
		objNavigationToSubmenus1.navigateToCustomInView();
		
		objViews1.clickOnResource(objResource_data.strResourceName1);
		
		objEventManagement1
				.verifyEventNameInEventBanner(objEventdata.strEventName1);

		objEventManagement1
				.verifyEventNameNotDisplayedInEventBanner(
						objEventdata.strEventName2)
				.verifyEventNameNotDisplayedInEventBanner(
						objEventdata.strEventName3)
				.verifyEventNameNotDisplayedInEventBanner(
						objEventdata.strEventName);
		//RS3
		objNavigationToSubmenus1.navigateToCustomInView();
		
		objViews1.clickOnResource(objResource_data.strResourceName2);
		
		objEventManagement1.verifyEventNameInOtherRegion(strRegionB,
				objEventdata.strEventName1).verifyEventNameInOtherRegion(
				strRegionC, objEventdata.strEventName2);

		objEventManagement1.verifyEventNameNotDisplayedInEventBanner(
				objEventdata.strEventName)
				.verifyEventNameNotDisplayedInEventBanner(
						objEventdata.strEventName3);

		//RS4
		objNavigationToSubmenus1.navigateToCustomInView();
		
		objViews1.clickOnResource(objResource_data.strResourceName3);
		
		objEventManagement1.verifyEventNameInOtherRegion(strRegionB,
				objEventdata.strEventName1).verifyEventNameInOtherRegion(
				strRegionD, objEventdata.strEventName3);

		objEventManagement1.verifyEventNameNotDisplayedInEventBanner(
				objEventdata.strEventName)
				.verifyEventNameNotDisplayedInEventBanner(
						objEventdata.strEventName2);

		objLogin.clickLogOut();

		gstrResult = "PASS";
	}	

}
