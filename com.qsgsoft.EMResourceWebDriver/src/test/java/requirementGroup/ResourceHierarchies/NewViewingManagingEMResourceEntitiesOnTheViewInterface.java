package requirementGroup.ResourceHierarchies;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
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

public class NewViewingManagingEMResourceEntitiesOnTheViewInterface extends TestNG_UI_EXTENSIONS{

	public NewViewingManagingEMResourceEntitiesOnTheViewInterface()
			throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*********************************************************************************************
	'Description : Verify that sub-resources are not listed on the Map view
	'Date	 	 : 05-Aug-2015
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************/
	@Test(description = "Verify that sub-resources are not listed on the Map view.")
	public void testHappyDay107430() throws Exception {

		gstrTCID = "107430";
		gstrTO = "Verify that sub-resources are not listed on the Map view.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Map objMap1=new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);

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

		// Sub-Resource creation
		objResource.createSubResourceWithAddress(
				objResource_data.strSubResourceName,
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation1,
				objResourceType_data.strSubResourceTypeName,
				objResource_data.strStandardResourceTypename1,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress,
				objResource_data.strState, objResource_data.strCity,
				objResource_data.strZipcode,
				objResource_data.strCounty);

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);
		
		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();
		
		System.out.println("------------------Precondition ends--------------------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		// View Map
		objNavigationToSubmenus1.navigateToMapPage();

		objMap1.verResourceNotInFindResourceDropDown(objResource_data.strSubResourceName);

		String[] strStatusTypeName1 = { objStatuTypes_data.strNSTStatusTypeName };
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeName1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	 * 'Description 	: Verify that sub resources are not listed while creating a region view. 
	 * 'Date 			: 28-Aug-2015 
	 * 'Author 			: Anitha
	 * '----------------------------------------------------------------------------------------
	 * 'Modified Date 			                                          Modified By 
	 * 'Date                                                              Name
	 *******************************************************************************************/
	@Test(description = "Verify that sub resources are not listed while creating a region view. ")
	public void testHappyDay107428() throws Exception {

		gstrTCID = "107428";
		gstrTO = "Verify that sub resources are not listed while creating a region view. ";

		Login_data objLogindata = new Login_data();
		View_data objView_data = new View_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views ObjViews1 = new Views(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[4];
		String strStatusTypeValues1[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

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
						objResource_data.strSubResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("------------------Precondition ends--------------------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToViews();

		// Create view
		String[] strStatusTypeNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName};

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickCreateNewViewButton()
					 .enterViewName(objView_data.strViewName)
					 .enterViewDesc(objView_data.strViewDesc)
					 .clickNextButton()
					 .selectRegionName(objLogindata.strRegionName)
					 .clickNextButton()
					 .VerResourceInCreateViewPage(objResource_data.strResourceName)
					 .selectResource(objResource_data.strResourceName)
					 .VerSubResourceNotInCreateView(
						objResource_data.strSubResourceName)
					 .clickNextButton();

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViewsList1.selectStatusType(strStatusTypeNames[i]);
		}

		objViewsList1.clickOnSaveOfCreateNewView();
		
//		objViewsList1
//				.selectResourceType(strResourceTypeValue[0])
//				.VerResourceInCreateViewPage(objResource_data.strResourceName)
//				.VerSubResourceNotInCreateView(
//						objResource_data.strSubResourceName)
//				.clickOnSaveOfCreateNewView()
//				.VerViewInViewList(objView_data.strViewName);
		
		objNavigationToSubmenus1
				.navigateToViews()
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		ObjViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		for (int j = 0; j < strStatusTypeNames.length; j++) {
			ObjViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}
		
		objResource1
				.verifySubResourceIsNotDisplayed(objResource_data.strSubResourceName);

		System.out.println(objView_data.strViewName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that user cannot add sub resources to a custom view. 
	 * 'Precondition	: 
	 * 'Date 			: 28-Aug-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that user cannot add sub resources to a custom view. ")
	public void testHappyDay116624() throws Exception {

		gstrTCID = "116624";
		gstrTO = "Verify that user cannot add sub resources to a custom view. ";

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
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);

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
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName);

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
				.selectViewcustomViewOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1
				.verCustomViewTableScreenIsDisplayed()
				.verPageWhenCustomViewNotCreated()
				.clickOnSetupCustomViewLink()
				.verEditCustomViewScreenIsDisplayed()
				.verSaveAndCancelButtonInEditCustomViewPage()
				.verAddMoreResSortAllAndOptionsInEditCustomViewPage()
				.clickOnAddMoreResources()
				.verifyFindResourcesPage()
				.verSearchButtonIsPresent()
				.verCancelButtonIsPresent()
				.enterResNameInWhatField(objResource_data.strResourceName1)
				.clickOnSearch()
				.verSubResource(objResource_data.strResourceName,
						objResource_data.strResourceName1)
				.selectResource(strSubResourceValue)
				.clickOnAddToCustomView()
				.verifyFindResourcesPage()
				.verErrorWhenSubResourceSelected(
						objResource_data.strResourceName,
						objResource_data.strResourceName1);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	 * 'Description 	: Verify that sub resources added to the resource detail are not displayed on region view.
	 * 'Date 			: 28-Aug-2015 
	 * 'Author 			: Anil
	 * '----------------------------------------------------------------------------------------
	 * 'Modified Date 			                                          Modified By 
	 * 'Date                                                              Name
	 *******************************************************************************************/
	@Test(description = "Verify that sub resources added to the resource detail are not displayed on region view.")
	public void testHappyDay106291() throws Exception {

		gstrTCID = "106291";
		gstrTO = "Verify that sub resources added to the resource detail are not displayed on region view.";

		Login_data objLogindata = new Login_data();
		View_data objView_data = new View_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views ObjViews1 = new Views(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[4];
		String strStatusTypeValues1[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

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
				.clickSaveButton();

		objNavigationToSubmenus.navigateToViews();

		// Create view
		String[] strStatusTypeNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName};

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickCreateNewViewButton()
					.enterViewName(objView_data.strViewName)
					.enterViewDesc(objView_data.strViewDesc)
					.clickNextButton()
					.selectRegionName(objLogindata.strRegionName)
					.clickNextButton()
					.VerResourceInCreateViewPage(objResource_data.strResourceName)
					.VerSubResourceNotInCreateView(
						objResource_data.strResourceName1)
					.selectResource(objResource_data.strResourceName)
					.clickNextButton();

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViewsList.selectStatusType(strStatusTypeNames[i]);
		}

		objViewsList.clickOnSaveOfCreateNewView()
					.VerViewInViewList(objView_data.strViewName);
		
//		objViewsList
//				.selectResourceType(strResourceTypeValue[0])
//				.VerResourceInCreateViewPage(objResource_data.strResourceName)
//				.VerSubResourceNotInCreateView(
//						objResource_data.strResourceName1)
//				.clickOnSaveOfCreateNewView()
//				.VerViewInViewList(objView_data.strViewName);
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("------------------Precondition ends--------------------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToViews()
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		ObjViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		for (int j = 0; j < strStatusTypeNames.length; j++) {
			ObjViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}
		ObjViews1.clickOnResource(objResource_data.strResourceName);

		for (int j = 0; j < strStatusTypeNames.length; j++) {
			ObjViews1.verStatusTypesUnderSection(strStatusTypeNames[j], objView_data.strSectionName);
		}
		// Create view
		String[] strStatusTypeNames1 = {
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1};

		for (int j = 0; j < strStatusTypeNames1.length; j++) {
			ObjViews1.verStatusTypesNotUnderSection(strStatusTypeNames1[j], objView_data.strSectionName);
		}

		ObjViews1.verSubResourcesSectionIsNotDisplayed();
		
		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickOncustomizeResourceDetailView()
					.verEditResourceDetailViewSectionsPageIsDisplayed()
					.verifySaveButton().verifyCancelButton()
					.verifySubResourceButton().verifySortAllButton()
					.clickSubResourceButton()
					.verEditSubResourceDetailViewSectionsPageIsDisplayed();

		objViewsList1
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0])
				.selectSubResourceCheckBox(strStatusTypeValues1[0])
				.selectSubResourceCheckBox(strStatusTypeValues1[1])
				.clickOnSaveButton().verRegionViewListPageIsDisplayed();
		System.out.println(objView_data.strViewName);

		objNavigationToSubmenus1
		.navigateToViews()
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		ObjViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		for (int j = 0; j < strStatusTypeNames.length; j++) {
			ObjViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}
		
		objResource1
				.verifySubResourceIsNotDisplayed(objResource_data.strSubResourceName);
		
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that sub-resources can be added to the resource detail view. 
	 * 'Precondition	: 
	 * 'Date 			: 07-Sep-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that sub-resources can be added to the resource detail view.")
	public void testHappyDay107431() throws Exception {

		gstrTCID = "107431";
		gstrTO = "Verify that sub-resources can be added to the resource detail view.";

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
				.selectAssosciateResourceRight(objResource_data.strResourceName)
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

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViewsList1.verResAndStatusTypes(strResourceTypeValue[0],
					objResource_data.strResourceName, strAllStatausTypes[i]);
		}

		objViews1.clickOnResource(objResource_data.strResourceName)
				.verViewResourceDetailsPgeIsDisplayed()
				.verResourceScreenDisplayed(objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {
			objViews1.verStatusTypesUnderSection(strAllStatausTypes[i],
					objView_data.strSectionName);
		}

		objViewsList1
				.verSubResourceNotDisplayedInResourceDetailView(objResource_data.strResourceName1);

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
		objViewsList1.verifyStatusTypeNameInView(strSubResourceTypeValue[0],
				objStatusTypes_data.strNSTStatusTypeName1)
				.verifyStatusTypeNameInView(strSubResourceTypeValue[0],
						objStatusTypes_data.strTSTStatusTypeName1);

		objViewsList1.verUpdateStatusOfSubResource(
				objResource_data.strResourceName1)
				.verAssociatedUsrInContactTable(objUserdata.strFullName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
