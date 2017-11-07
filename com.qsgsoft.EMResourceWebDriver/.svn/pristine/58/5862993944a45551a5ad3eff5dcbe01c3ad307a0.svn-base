package requirementGroup.ViewingAndmanagingEMResourceEntitiesOnTheViewInterface;

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

public class NewViewResourceDetailScreen extends TestNG_UI_EXTENSIONS{

	public NewViewResourceDetailScreen() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*******************************************************************************************
	'Description 	: Verify that a resource can be edited from 'View Resource Detail' screen.
	'Date 			: 15-June-2014 
	'Author 		: Anitha
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that a resource can be edited from 'View Resource Detail' screen.")
	public void testHappyDay99413() throws Exception {

		gstrTCID = "99413";
		gstrTO = "Verify that a resource can be edited from 'View Resource Detail' screen.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Map objMap1 = new Map(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		Views objViews1 = new Views(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.createNewStatus(
			     objStatuTypes_data.strStatusNameInMulti,
			     objStatuTypes_data.strStatusColor)
			  .createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
			      objStatuTypes_data.strStatusColor)
			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti1)
			.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

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

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupResourceOption()
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("---------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickOnViewInfoInPopupWindow()
				.verViewResDetailScreenIsDisplayedWithResName(
						objResource_data.strResourceName);

		objViewsList1.verifyEditResourceDetailsLinkIsPresent()
				.clickOnEditResourceDetailsLink();

		objResource1.enterResourceName(objResource_data.strEditedResName)
				.clickOnSaveButton();

		objViews1.verResourceScreenDisplayed(objResource_data.strEditedResName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description 	: Verify that resource detail view can be configured from Setup module.
	'Date 			: 15-June-2014 
	'Author 		: Anil
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	                  Modified By
	'Date					                                              Name
	********************************************************************************************/
	@Test(description = "Verify that resource detail view can be configured from Setup module.")
	public void testHappyDay70180() throws Exception {

		gstrTCID = "70180";
		gstrTO = "Verify that resource detail view can be configured from Setup module.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.createNewStatus(
			     objStatuTypes_data.strStatusNameInMulti,
			     objStatuTypes_data.strStatusColor)
			  .createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
			      objStatuTypes_data.strStatusColor)
			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti1)
			.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

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

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectSetupStatusTypesOption()
				.clickSaveButton();

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName };
		
		objViewsList.navigateToViewsList()
//				.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strStatusTypeNames);

		objLogin.clickLogOut();

		System.out
				.println("---------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		String[] strAllStatausTypes = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName };

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strAllStatausTypes[i]);
		}
		
		objViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViews1
				.verViewResourceDetailsPgeIsDisplayed()
				.verStatusTypesUnderSection(
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strMSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strSSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strNDSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strDateStatusTypeName,
						objView_data.strSectionName);

		objnNavigationToSubMenus1.navigateToViews();

		objViewsList1.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName1)
				.verEditResourceDetailViewSectionsPageIsDisplayed()
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName1)
				.clickOnSaveButton();

		objStatusTypeList1
				.navigateToStatusTypeListNew()
				.clickOnEditOfStatusType(
						objStatuTypes_data.strTSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName1)
				.clickOnSaveButton()
				.clickOnEditOfStatusType(
						objStatuTypes_data.strSSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName1)
				.clickOnSaveButton();
		
		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViews1
				.verViewResourceDetailsPgeIsDisplayed()
				.verStatusTypesUnderSection(
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strMSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strNDSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strDateStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strSSTStatusTypeName,
						objView_data.strSectionName1)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
		
	/*******************************************************************************************
	'Description 	: Verify that resource detail view can be configured from resource detail screen.
	'Date 			: 15-June-2014 
	'Author 		: Anitha
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	                  Modified By
	'Date					                                              Name
	********************************************************************************************/
	@Test(description = "Verify that resource detail view can be configured from resource detail screen.")
	public void testHappyDay70181() throws Exception {

		gstrTCID = "70181";
		gstrTO = "Verify that resource detail view can be configured from resource detail screen.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.createNewStatus(
			     objStatuTypes_data.strStatusNameInMulti,
			     objStatuTypes_data.strStatusColor)
			  .createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
			      objStatuTypes_data.strStatusColor)
			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti1)
			.clickOnReturnToStatusTypeList();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

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

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectSetupStatusTypesOption()
				.clickSaveButton();

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName };
		
		objViewsList.navigateToViewsList()
//				.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strStatusTypeNames);

		objLogin.clickLogOut();

		System.out.println("-------Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViews1.verViewResourceDetailsPgeIsDisplayed().clickOnCustomizeLink();

		objViewsList1.enterSectionName(objView_data.strSectionName1)
				.verEditResourceDetailViewSectionsPageIsDisplayed()
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName1)
				.clickOnSaveButton();

		objStatusTypeList1
				.navigateToStatusTypeList()
				.clickOnEditOfStatusType(
						objStatuTypes_data.strTSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName1)
				.clickOnSaveButton()
				.clickOnEditOfStatusType(
						objStatuTypes_data.strSSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName1)
				.clickOnSaveButton();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViews1.clickOnCustomizeLink();

		objViewsList1
				.clickOnSection(objView_data.strSectionName)
				.verStatusTypesInList(objStatuTypes_data.strMSTStatusTypeName,
						strStatusTypeValues[2])
				.verStatusTypesInList(objStatuTypes_data.strNSTStatusTypeName,
						strStatusTypeValues[0])

				.clickOnSection(objView_data.strSectionName1)
				.verStatusTypesInList(objStatuTypes_data.strSSTStatusTypeName,
						strStatusTypeValues[3])
				.verStatusTypesInList(objStatuTypes_data.strTSTStatusTypeName,
						strStatusTypeValues[1]);
		
		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViews1
				.verStatusTypesUnderSection(
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strMSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strSSTStatusTypeName,
						objView_data.strSectionName1)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description 	: Verify that a section can be created selecting an event related status type in the resource detail configuration screen.
	'Date 			: 15-June-2014 
	'Author 		: Anil
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that a section can be created selecting an event related status type in the resource detail configuration screen.")
	public void testHappyDay99168() throws Exception {

		gstrTCID = "99168";
		gstrTO = "Verify that a section can be created selecting an event related status type in the resource detail configuration screen.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Views objViews1 = new Views(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		
		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
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
			      objStatuTypes_data.strStatusNameInMulti1)
			.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

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

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().selectConfigureRegionViewsOption()
				.selectSetupStatusTypesOption()
				.clickSaveButton();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues)				
				.deselectSelectAllWebOptionOnly()
				.clickSaveButton();
		
		objLogin.clickLogOut();

		System.out
				.println("---------Precondition ends and test execution starts---------");

		System.out.println(objUser_data.strNewUserName);
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription);
		
		objResource1.clickResource(strResourceValue);
	
		objEventManagement1.clickOnSaveButton();

		objStatusTypeList1.navigateToStatusTypeList();

		String strStatusTypes[] ={objStatuTypes_data.strNSTStatusTypeName, objStatuTypes_data.strMSTStatusTypeName, objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName, objStatuTypes_data.strNDSTStatusTypeName, objStatuTypes_data.strDateStatusTypeName};
		
		for(int intCount = 0; intCount<strStatusTypes.length;intCount++){
		objStatusTypeList1.clickOnEditOfStatusType(strStatusTypes[intCount])
		.selectSectionName(objView_data.strSectionName)
		.clickOnSaveButton();
		}
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypes.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypes[i]);
		}

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
		
		for(int intCount = 0; intCount<strStatusTypes.length; intCount++){
			objViews1.verStatusTypesUnderSection(strStatusTypes[intCount], objView_data.strSectionName);
		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
