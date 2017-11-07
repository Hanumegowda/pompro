package requirementGroup.ResourceHierarchies;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
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

public class NewCreatingAndManagingUsers extends TestNG_UI_EXTENSIONS{

	public NewCreatingAndManagingUsers() throws Exception {
		super();
	}

	/***********************************************************************************************
	'Description : Verify that sub-resources are not listed while creating users
	'Precondition:
	'Date	 	 : 26-Aug-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************/
	@Test(description = "Verify that a sub-resource type can be created.")
	public void testHappyDay107190() throws Exception {

		gstrTCID = "107190";
		gstrTO = "Verify that sub-resources are not listed while creating users";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Role based status types
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

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

		// Sub-Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createSubResourceType(objResourceType_data.strResourceTypeName1,
				strStatusTypeValues1);

		objResource
				.navigateToResourceListPage()

				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.createSubResourceForResource(
						objResource_data.strResourceName1,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName1,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.verifyUserListPageIsDisplayed()
				.createNewUserButtonIsPresent()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.verResourceNameIsNotPresent(objResource_data.strResourceName1)
				.verAllViewResReightOptionIsSelected().clickSaveButton();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	'Description : Verify that sub-resources are not listed while editing users
	'Precondition:
	'Date	 	 : 26-Aug-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************/
	@Test(description = "Verify that a sub-resource type can be created.")
	public void testHappyDay107191() throws Exception {

		gstrTCID = "107191";
		gstrTO = "Verify that sub-resources are not listed while editing users";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusTypeValues1[] = new String[1];
		String strResourceValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Role based status types
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

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

		// Sub-Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createSubResourceType(objResourceType_data.strResourceTypeName1,
				strStatusTypeValues1);

		objResource
				.navigateToResourceListPage()

				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.createSubResourceForResource(
						objResource_data.strResourceName1,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName1,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1.verifyUserListPageIsDisplayed()
				.createNewUserButtonIsPresent()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.verEditUserPageisDisplayed()
				.verNameInEditUserPage(objUserdata.strNewUserName)
				.verFullNameInEditUserPage(objUserdata.strFullName)
				.verResourceNameIsNotPresent(objResource_data.strResourceName1)
				.clickSaveButton();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Verify that user with setup resource types right can create a sub resource type.
	'Precondition:
	'Date	 	 : 27-Aug-2015
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that user with setup resource types right can create a sub resource type.")
	public void testHappyDay107194() throws Exception {

		gstrTCID = "107194";
		gstrTO = "Verify that user with setup resource types right can create a sub resource type.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strEveStatusTypeValues[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		// RoleBased statustypes
				.createEventStatusType(
						objStatuTypes_data.strSaturationScoreStatusType,
						objStatuTypes_data.strSSTStatusTypeName,
						objStatuTypes_data.strStatusDescription);

		strEveStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.clickAdvancedOptionAndExpand()
				.selectSetupResourceTypesOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToResourceTypesInSetup();

		// Resource type creation
		objResourceType1
				.verResourceTypeListPageIsDisplayed()
				.verCreateNewResourceTypeButtonIsPresent()
				.clickOnCreateNewResourceTypeButton()
				.verCreateNewResourceTypePageIsDisplayed()
				.enterResourceTypeName(objResourceType_data.strResourceTypeName)
				.selectSubResourceTypeCheckBox()
				.clickStatusType(strEveStatusTypeValues)
				.clickOnSaveButton()
				.verErrWhenEventRelatedSTIsSelectedForSubRT(
						objStatuTypes_data.strSSTStatusTypeName)
				.verCreateNewResourceTypePageIsDisplayed()
				.clickStatusType(strStatusTypeValues).clickOnSaveButton();

		objResourceType1
				.verResourceTypeInList(objResourceType_data.strResourceTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that sub resources inherits rights from the parent resource. 
	 * 'Precondition	: 
	 * 'Date 			: 31-Aug-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that sub resources inherits rights from the parent resource. ")
	public void testHappyDay107192() throws Exception {

		gstrTCID = "107192";
		gstrTO = "Verify that sub resources inherits rights from the parent resource. ";

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

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strStatusTypeValues1[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		System.out.println(strRegionValue[1]);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)		
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.navigateToResourceTypePage()
				.createResourceType(
						objResourceType_data.strSubResourceTypeName,
						strStatusTypeValues1)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.enterResourceTypeDescription(
						objResourceType_data.strResTypeDescription)
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

		objResource.clickOnSubResourcesLink(objResource_data.strResourceName)
				.createSubResourceForResource(
						objResource_data.strResourceName1,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption().clickSaveButton();

		objNavigationToSubmenus.navigateToViews();

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName };

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

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strAllStatausTypes);
		
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.verRegionViewListPageIsDisplayed()
				.verCreateNewViewReorderAndCustomizeDetailViewButton();

		objViewsList1
				.clickOncustomizeResourceDetailView()
				.verEditResourceDetailViewSectionsPageIsDisplayed()
				.verifySubResourceButton()
				.verifyCancelButton()
				.verifySortAllButton()
				.verifySaveButton()
				.clickSubResourceButton()
				.verEditSubResourceDetailViewSectionsPageIsDisplayed()
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0])
				.selectSubResourceCheckBox(strStatusTypeValues1[0])
				.selectSubResourceCheckBox(strStatusTypeValues1[1])
				.verSubResourceTypeNameIsNotPresentInEditSubResPage(
						objResourceType_data.strResourceTypeName)
				.clickOnSaveButton().verRegionViewListPageIsDisplayed();

		System.out.println(objView_data.strViewName);
		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViewsList1.verResAndStatusTypes(strResourceTypeValue[0],
					objResource_data.strResourceName, strAllStatausTypes[i]);
		}

		objViewsList1.verUpdateKeyIcon();

		objViews1.clickOnResource(objResource_data.strResourceName)
				.verViewResourceDetailsPgeIsDisplayed()
				.verResourceScreenDisplayed(objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {
			objViews1.verStatusTypesUnderSection(strAllStatausTypes[i],
					objView_data.strSectionName);
		}

		objViewsList1.verUpdateStatusOfSubResource(
				objResource_data.strResourceName1)
				.clickOnUpdateStatusOfSubResource(
						objResource_data.strResourceName1);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues1[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues1[1],
						objView_data.strValueForUpdate1).clickOnSaveButton();

		objViewsList1.verifyUpdatedValue(strSubResourceValue[0],
				strStatusTypeValues1[0], objView_data.strValueForUpdate)
				.verifyUpdatedValue(strSubResourceValue[0],
						strStatusTypeValues1[1],
						objView_data.strValueForUpdate1);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that newly added rights for a resource is inherited by the sub resource. 
	 * 'Precondition	: 
	 * 'Date 			: 01-Sep-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that newly added rights for a resource is inherited by the sub resource. ")
	public void testHappyDay107193() throws Exception {

		gstrTCID = "107193";
		gstrTO = "Verify that newly added rights for a resource is inherited by the sub resource. ";

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

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strStatusTypeValues1[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		System.out.println(strRegionValue[1]);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
						
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)		
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.navigateToResourceTypePage()
				.createResourceType(
						objResourceType_data.strSubResourceTypeName,
						strStatusTypeValues1)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.enterResourceTypeDescription(
						objResourceType_data.strResTypeDescription)
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

		objResource.clickOnSubResourcesLink(objResource_data.strResourceName)
				.createSubResourceForResource(
						objResource_data.strResourceName1,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption().clickSaveButton();

		objNavigationToSubmenus.navigateToViews();

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName };
		
		String[] strAllSubResStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1};
//
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

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
								objResource_data.strResourceName, strAllStatausTypes);
		
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.verRegionViewListPageIsDisplayed()
				.verCreateNewViewReorderAndCustomizeDetailViewButton();

		objViewsList1
				.clickOncustomizeResourceDetailView()
				.verEditResourceDetailViewSectionsPageIsDisplayed()
				.verifySubResourceButton()
				.verifyCancelButton()
				.verifySortAllButton()
				.verifySaveButton()
				.clickSubResourceButton()
				.verEditSubResourceDetailViewSectionsPageIsDisplayed()
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0])
				.selectSubResourceCheckBox(strStatusTypeValues1[0])
				.selectSubResourceCheckBox(strStatusTypeValues1[1])
				.verSubResourceTypeNameIsNotPresentInEditSubResPage(
						objResourceType_data.strResourceTypeName)
				.clickOnSaveButton().verRegionViewListPageIsDisplayed();

		System.out.println(objView_data.strViewName);
		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViewsList1.verResAndStatusTypes(strResourceTypeValue[0],
					objResource_data.strResourceName, strAllStatausTypes[i]);
		}

		objViewsList1.verUpdateKeyIcon();

		objViews1.clickOnResource(objResource_data.strResourceName)
				.verViewResourceDetailsPgeIsDisplayed()
				.verResourceScreenDisplayed(objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {
			objViews1.verStatusTypesUnderSection(strAllStatausTypes[i],
					objView_data.strSectionName);
		}

		objViewsList1.verUpdateStatusOfSubResource(
				objResource_data.strResourceName1)
				.clickOnUpdateStatusOfSubResource(
						objResource_data.strResourceName1);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues1[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues1[1],
						objView_data.strValueForUpdate1).clickOnSaveButton();

		objViewsList1.verifyUpdatedValue(strSubResourceValue[0],
				strStatusTypeValues1[0], objView_data.strValueForUpdate)
				.verifyUpdatedValue(strSubResourceValue[0],
						strStatusTypeValues1[1],
						objView_data.strValueForUpdate1);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1.enterUsernameInSearchInputField(objUserdata.strNewUserName)
		.clickSearchButton()
		.editUserDetails(objUserdata.strNewUserName)
		.verEditUserPageisDisplayed()
		.deselectUpdateStatusOfResource(objResource_data.strResourceName)
		.selectAssosciateResourceRight(objResource_data.strResourceName)
		.clickSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViewsList1.verResAndStatusTypes(strResourceTypeValue[0],
					objResource_data.strResourceName, strAllStatausTypes[i]);
		}

		objViewsList1.verUpdateKeyIconNotDispalyed();
		
		objViews1.clickOnResource(objResource_data.strResourceName)
		.verViewResourceDetailsPgeIsDisplayed()
		.verResourceScreenDisplayed(objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {
			objViews1.verStatusTypesUnderSection(strAllStatausTypes[i],
					objView_data.strSectionName);
		}
		
		objViewsList1.verUpdateStatusOfSubResourceNotDisplayed(
				objResource_data.strResourceName1)
				.verAssociatedUsrInContactTable(objUserdata.strFullName);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
