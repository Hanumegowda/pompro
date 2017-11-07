package requirementGroup.MultiRegion;

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
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewRegionsWithMutualAgreementAndOtherRegionViewRight extends TestNG_UI_EXTENSIONS{

	public NewRegionsWithMutualAgreementAndOtherRegionViewRight() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**********************************************************************************
	 * 'Description :  Verify that the resource of RG1 cannot be edited from RG2 when RG1 and RG2 have other region agreement.
	 * 'Date        :15-Jun-2015
	 * 'Author      :Anil
	 **********************************************************************************/

	@Test(description = "Verify that the resource of RG1 cannot be edited from RG2 when RG1 and RG2 have other region agreement.")
	public void testHappyDay71246() throws Exception {
		gstrTCID = "71246";
		gstrTO = "Verify that the resource of RG1 cannot be edited from RG2 when RG1 and RG2 have other region agreement.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		
		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus_page1 = new NavigationToSubMenus(this.driver1);
		CustomUnderView ObjCustomUnderView1 = new CustomUnderView(this.driver1);
		Map objMap1 = new Map(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strStateWideReg);

		RegionDefault_page.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objTest_data.strStateWideReg);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objTest_data.strArkansasReg);

		System.out.println(strRegionValue[1]);
		
		StatusTypeList_page
				.navigateToStatusTypeListNew()
				.createSharedStatusType(objStatuTypes_data.strNumberStatusType, objStatuTypes_data.strNSTStatusTypeName, objStatuTypes_data.strStatusDescription);
	
	strstatusTypeValues[0] = StatusTypeList_page
			.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

	// Resource type creation
	ResourceType_Page.navigateToResourceTypePage();

	ResourceType_Page.createResourceType(
			objResourceType_data.strResourceTypeName, strstatusTypeValues);

	strResourceTypeValue[0] = ResourceType_Page.getResourceTypeValue(objResourceType_data.strResourceTypeName);
	
	// Resource creation
	Resource_Page.navigateToResourceListPage();

	Resource_Page.createSharedResourceWithAddress(objResource_data.strResourceName,
			objResource_data.strResourceAbbrivation,
			objResourceType_data.strResourceTypeName,
			objResource_data.strStandardResourceTypename,
			objResource_data.strResourceFirstName,
			objResource_data.strResourceLastName,
			objResource_data.strStreetAddress,
			objResource_data.strCity, objResource_data.strState,
			objResource_data.strCounty, objResource_data.strZipcode);

	strResourceValue[0] = Resource_Page
			.getResourceValue(objResource_data.strResourceName);

	objViewsList.navigateToViewsList()
	.clickOnEditLinkOfView(objView_data.strRegionDefaultName)
	.clickOnResourcesTab()
	.selectResource(objResource_data.strResourceName)
	.clickNextButton()
	.selectStatusType(objStatuTypes_data.strNSTStatusTypeName)
//	.selectStatusTypeForView(strstatusTypeValues)
	
	.clickOnSaveOfCreateNewView();
	
	login_page.clickLogOut();
	
	login_page.loginToApplication(objTest_data.strUserName,
			objTest_data.strPassword);

	SelectRegion_page.selectRegionAndNavigate(objTest_data.strArkansasReg);

	RegionDefault_page.selectFrame();
	
		// User creation
		UsersList_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.selectFirstRole()
				
				.selectViewOtherRegView(objTest_data.strStateWideOklahomaVal)
				
				.clickAdvancedOptionAndExpand()

				.selectViewcustomViewOption()
				
				.selectSetupResourceOption()

				.clickSaveButton();
//				
//				.searchUserName(objUser_data.strNewUserName,
//						objUser_data.strRole, objUser_data.strResourceType,
//						objUser_data.strUsername, objUser_data.strsearchOption)
//				.clickRegionsLinkForUser(objUser_data.strNewUserName)
//				.selectRegion(strRegionValue[1]).clickSaveButton();
//
//		login_page.clickLogOut();
//		
//		login_page.loginToApplication(objTest_data.strUserName,
//				objTest_data.strPassword);
//
////		SelectRegion_page.selectRegionAndNavigate(objTest_data.strArkansasReg);
//
//		RegionDefault_page.selectFrame();
//
//		// User creation
//		UsersList_page.navigateToUsers();
//
//		System.out.println(objUser_data.strNewUserName);
//
//		UsersList_page.searchUserName(objUser_data.strNewUserName,
//						objUser_data.strRole, objUser_data.strResourceType,
//						objUser_data.strUsername, objUser_data.strsearchOption)
//						
//				.editUserDetails(objUser_data.strNewUserName)
//				.selectFirstRole()
//				
//				.clickAdvancedOptionAndExpand()
//
//				.selectSetupResourceOption()
//
//				.selectViewcustomViewOption()
//				
//				.clickSaveButton();
		
		login_page.clickLogOut();
		
		System.out.println("----------------Precodition execution ends---------");

		System.out.println("-----------------Test execution starts---------------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

//		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strArkansasReg);

		RegionDefault_page1.selectFrame();

		objNavigationToSubmenus_page1.navigateToCustomizedViewInPrefrences();
		
		String[] strResource = {objResource_data.strResourceName};
		String[] strStatusTypes = {objStatuTypes_data.strNSTStatusTypeName};
		
		ObjCustomUnderView1.verEditCustomViewScreenIsDisplayed()
						  .clickOnAddMoreResources()
						  .enterResNameInWhatField(objResource_data.strResourceName)
						  .clickOnSearch().selectResource(strResourceValue)
						  .clickOnAddToCustomView().clickOnOptions()
						  .selectAllChkBoxInOptions()
						  .selectStatusTypes(strstatusTypeValues)
						  .clickOnSave()
						  .verResourceAndResTypeInCustomViewTablePage(strResource, objResourceType_data.strResourceTypeName)
						  .verStatusTypeInCustomViewTablePage(strStatusTypes)
						  .clickOnCustomeViewMap()
						  .verCustomViewMapScreenIsDisplayed()
						  .selectResourceName(objResource_data.strResourceName);
		objMap1.verfyEditInfoLinkNotPresent()
		.clickOnViewInfoInPopupWindow();
		
		objViewsList1.verifyEditResourceDetailsLinkIsNotPresent();
		
		objNavigationToSubmenus_page1.navigateToRegUnderOtherRegions(objTest_data.strStateWideReg);

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
		
		objViewsList1.verifyEditResourceDetailsLinkIsNotPresent();
		
		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description :  Verify that custom view can be created by selecting region RG1's resource from region RG2,
	 				when RG1 and RG2 have other region view agreement.
	'Precondition:
	'Date	 	 : 10-Feb-2016
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = " Verify that custom view can be created by selecting region RG1's resource from "+ 
					"region RG2, when RG1 and RG2 have other region view agreement.")
	public void testHappyDay70785() throws Exception {
		
		gstrTCID = "70785";
		gstrTO =  " Verify that custom view can be created by selecting region RG1's resource from "+ 
				"region RG2, when RG1 and RG2 have other region view agreement.";
		
		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEventdata = new Event_data();
		
		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Regions objRegions = new Regions(this.driver1);
		
		String strstatusTypeValues[] = new String[14];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[3];
		String strRegionValue[] = new String[2];
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		CustomUnderView ObjCustomUnderView1 = new CustomUnderView(this.driver1);
		Map objMap1 = new Map(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateWideReg);

		objRegionDefault.selectFrame();
		
		objNavigationToSubMenus.navigateToRegions();
		
		strRegionValue[0] = objRegions.getRegionValue(objTest_data.strStateWideReg);

		strRegionValue[1] = objRegions.getRegionValue(objTest_data.strAmariloTXReg);
		
		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription , objView_data.strSectionName);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);
		
		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);
	//
	
		// RoleBased statustypes
		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[6] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[7] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription , objView_data.strSectionName);

		strstatusTypeValues[8] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti);
		
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[9] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[10] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName1);
		
		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[11] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName1);
			
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName2,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[12] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName2);
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strTSTStatusTypeName2,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[13] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName2);
		
		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createSharedResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation3,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);


		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objResource.navigateToResourceListPage().createSharedResourceWithAddress(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation3,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);


		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objResource.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation3,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);


		strResourceValue[2] = objResource
				.getResourceValue(objResource_data.strResourceName2);
		
		
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)
				.deselectSelectAllWebOption();


		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.selectViewResourceCheckBox(objResource_data.strResourceName2)	
				.selectUpdateStatusOfResource(objResource_data.strResourceName2)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.verUserInList(objUser_data.strNewUserName);
		System.out.println(objUser_data.strNewUserName);
		// create view
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName};
		
		String[] strStatusTypeNames2 = {
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strDateStatusTypeName1,
				objStatuTypes_data.strNSTStatusTypeName2,
				objStatuTypes_data.strTSTStatusTypeName2};
		
		objSelectRegion
		.selectRegionAndNavigate(objTest_data.strAmariloTXReg);
		
		objRegionDefault.selectFrame();
		
		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectViewOtherRegView(objTest_data.strStOklahomaOtherRegValFromAmrillo)
				.clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption()
				.selectEditStatusChangeNotPrefernceOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption);
		
		System.out.println(objUser_data.strNewUserName1);
		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		objEventManagement.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEventdata.strEventName)
		.enterAdHocEventDescription(objEventdata.strEventDescription)
		.selectResource(strResourceValue).clickOnSaveButton()
		.verifyEventName(objEventdata.strEventName);
		
		objLogin.clickLogOut();
		
		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);
//
//		objSelectRegion1
//		.selectRegionAndNavigate(objTest_data.strRegionName);
		
		objRegionDefault1.selectFrame();

		
		// Custom View
		Thread.sleep(3000);
		objNavigationToSubMenus1.navigateToCustomInView();
		
		String strRS = objResource_data.strResourceName.substring(3);
		String strstatusTypeValues1[] = {strstatusTypeValues[0],strstatusTypeValues[1],strstatusTypeValues[2],strstatusTypeValues[3],strstatusTypeValues[4], strstatusTypeValues[5] };
		String strResourceVal[] = {strResourceValue[0], strResourceValue[1]};
		ObjCustomUnderView1.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(strRS)
				.clickOnSearch()
				.verResourceNameInSearch(objResource_data.strResourceName)
				.verResourceNameInSearch(objResource_data.strResourceName1)
				.selectResource(strResourceVal)
				.clickOnAddToCustomView()
				.verEditCustomViewScreenIsDisplayed()
				.verifyRSRTAndRegionName(objResource_data.strResourceName, objResourceType_data.strResourceTypeName, objTest_data.strStateWideReg)
				.verifyRSRTAndRegionName(objResource_data.strResourceName1, objResourceType_data.strResourceTypeName, objTest_data.strStateWideReg)
				.clickOnOptions()
				.verEditCustomViewOptionsColumnIsDisplayed()
				.selectAllChkBoxInOptions()
				.verifyStatusTypesAreDisplayed(strStatusTypeNames)
				.selectStatusTypes(strstatusTypeValues1)
				.verifyStatusTypesAreNotDisplayed(strStatusTypeNames2)
				.clickOnSave()
				.verStatusTypeInCustomViewTablePage(strStatusTypeNames);
				
		ObjCustomUnderView1.clickOnCustomeViewMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName)
			   .verStatusTypesInPopupWindow(strStatusTypeNames);

		objMap1.verResourceNameInPopupWindow(objResource_data.strResourceName);
		
		objMap1.verStatusTypesInPopupWindow(strStatusTypeNames);/*EMS-4090 Shared status types are not displayed in the resource pop up 
					
																window of shared resource of another region on "Custom View - Map" screen.*/
		try {
			objMap1.verStatusTypesNotInPopupWindow(strStatusTypeNames2);
		} catch (AssertionError ae) {
			System.out.println("Event related status types will be displayed if there exists "
					+ "an active event if the STs are selected for the event.");
			strStatusTypeNames2 = ArrayUtils.removeElement(strStatusTypeNames2, objStatuTypes_data.strNSTStatusTypeName2);
			strStatusTypeNames2 = ArrayUtils.removeElement(strStatusTypeNames2, objStatuTypes_data.strTSTStatusTypeName2);
			objMap1.verStatusTypesInPopupWindow(strStatusTypeNames2);
		}
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description :   Verify that user cannot view the event related status types associated with a 
					private event of region RG1 from RG2.
	'Precondition:
	'Date	 	 : 10-Feb-2016
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = " Verify that user cannot view the event related status types associated with a "+
					"private event of region RG1 from RG2.")
	public void testHappyDay71242() throws Exception {
		
		gstrTCID = "71242";
		gstrTO =  " Verify that user cannot view the event related status types associated with a "+
				"private event of region RG1 from RG2.";
		
		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEventdata = new Event_data();
		NotificationValues objNotificationValues = new NotificationValues();
		
		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Regions objRegions = new Regions(this.driver1);
		
		String strstatusTypeValues[] = new String[12];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		String strRegionValue[] = new String[2];
		String strStatusesValues[] = new String[2];
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		CustomUnderView ObjCustomUnderView1 = new CustomUnderView(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strStateWideReg);

		objRegionDefault.selectFrame();
		
		objNavigationToSubMenus.navigateToRegions();
		
		strRegionValue[0] = objRegions.getRegionValue(objTest_data.strStateWideReg);

		strRegionValue[1] = objRegions.getRegionValue(objTest_data.strAmariloTXReg);
		
		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription , objView_data.strSectionName);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);
		
		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti1);
		
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);
	
		// RoleBased statustypes
		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[6] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[7] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription , objView_data.strSectionName);

		strstatusTypeValues[8] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti);
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strstatusTypeValues[9] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[10] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName1);
		
		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName1,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[11] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName1);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);
		
		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createSharedResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation3,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objResource.navigateToResourceListPage().createSharedResourceWithAddress(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation3,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);


		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);
		
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)
				.deselectSelectAllWebOption();

		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();
	
		// create view
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName};
		
		String[] strStatusTypeNames2 = {
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strDateStatusTypeName1};
		
		String[] strStatusTypeNames1 = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strDateStatusTypeName1};
		
				
		objSelectRegion
		.selectRegionAndNavigate(objTest_data.strAmariloTXReg);
		
		objRegionDefault.selectFrame();
		System.out.println(objUser_data.strNewUserName1);
		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.selectViewOtherRegView(objTest_data.strStOklahomaOtherRegValFromAmrillo)
				.clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption()
				.selectEditStatusChangeNotPrefernceOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption);

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		objEventManagement.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEventdata.strEventName)
		.enterAdHocEventDescription(objEventdata.strEventDescription)
		.selectPrivateField()
		.selectResource(strResourceValue).clickOnSaveButton()
		.verifyEventName(objEventdata.strEventName);
		
		objLogin.clickLogOut();
		
		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();

		
		// Custom View
		Thread.sleep(3000);
		objNavigationToSubMenus1.navigateToCustomInView();
		
		String strRS = objResource_data.strResourceName.substring(3);
		String strstatusTypeValues1[] = {strstatusTypeValues[0],strstatusTypeValues[1],strstatusTypeValues[2],strstatusTypeValues[3],strstatusTypeValues[4], strstatusTypeValues[5] };
		String strResourceVal[] = {strResourceValue[0], strResourceValue[1]};
		ObjCustomUnderView1.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(strRS)
				.clickOnSearch()
				.verResourceNameInSearch(objResource_data.strResourceName)
				.verResourceNameInSearch(objResource_data.strResourceName1)
				.selectResource(strResourceVal)
				.clickOnAddToCustomView()
				.verEditCustomViewScreenIsDisplayed()
				.verifyRSRTAndRegionName(objResource_data.strResourceName, objResourceType_data.strResourceTypeName, objTest_data.strStateWideReg)
				.verifyRSRTAndRegionName(objResource_data.strResourceName1, objResourceType_data.strResourceTypeName, objTest_data.strStateWideReg)
				.clickOnOptions()
				.verEditCustomViewOptionsColumnIsDisplayed()
				.selectAllChkBoxInOptions()
				.verifyStatusTypesAreDisplayed(strStatusTypeNames)
				.selectStatusTypes(strstatusTypeValues1)
				.verifyStatusTypesAreNotDisplayed(strStatusTypeNames2)
				.clickOnSave()
				.verStatusTypeInCustomViewTablePage(strStatusTypeNames);
				
		ObjCustomUnderView1.clickOnCustomeViewMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName)
			   .verStatusTypesInPopupWindow(strStatusTypeNames);

		objMap1.verResourceNameInPopupWindow(objResource_data.strResourceName);
		
		objMap1.verResourceNameInPopupWindow(objResource_data.strResourceName1);
																/*EMS-4090 Shared status types are not displayed in the resource pop up 
																window of shared resource of another region on "Custom View - Map" screen.*/
		objMap1.verStatusTypesNotInPopupWindow(strStatusTypeNames2);
		
		objNavigationToSubMenus1
		.navigateToRegUnderOtherRegions(objTest_data.strStateWideReg);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEventdata.strEventName);
		
		objEventStatus1.verifyErrorMessageDisplayed();
		
		objNavigationToSubMenus1.navigateStatusChangeInPreferences();
		
		objStatusChangePreference
		.verMyStatusChangePreferncePgeDisplayed()
		.clickOnAdd()
		.enterResNameInWhatField(objResource_data.strResourceName)
		.clickOnSearch()
		.verResourceDisplayedInFindResScreen(
				objResource_data.strResourceName)
		.verResourceDisplayedInFindResScreen(objResource_data.strResourceName)
		.selectResource(strResourceValue[0])
		.clickOnNotifications()
		.expandUncategorizedSec();
		
		for (int i = 0; i < strStatusTypeNames1.length; i++) {
			objStatusChangePreference
					.verStatusTypesUnderUncategorizedSec(strStatusTypeNames1[i]);
		}
		
		objStatusChangePreference
				.enterAboveValues(strResourceValue[0], strstatusTypeValues[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strstatusTypeValues[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[0],
						strstatusTypeValues[0])
						
				.enterAboveValues(strResourceValue[0], strstatusTypeValues[1],
						objNotificationValues.strAboveValueForNDSt)
				.enterBelowValues(strResourceValue[0], strstatusTypeValues[1],
						objNotificationValues.strBelowValueForNDSt)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[0],
						strstatusTypeValues[1])
						
				.selEmailPagerWebChkBoxes(strResourceValue[0], strstatusTypeValues[2])
				
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
				strstatusTypeValues[3], strStatusesValues[0])
				
				.enterAboveValues(strResourceValue[0], strstatusTypeValues[4],
						objNotificationValues.strAboveValForSST)
				.enterBelowValues(strResourceValue[0], strstatusTypeValues[4],
						objNotificationValues.strBelowValForSST)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[0],
						strstatusTypeValues[4])
						
				.selEmailPagerWebChkBoxes(strResourceValue[0], strstatusTypeValues[5])
								
				.enterAboveValues(strResourceValue[0], strstatusTypeValues[6],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strstatusTypeValues[6],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[0],
						strstatusTypeValues[6])		
						
						
				.enterAboveValues(strResourceValue[0], strstatusTypeValues[7],
						objNotificationValues.strAboveValueForNDSt)
				.enterBelowValues(strResourceValue[0], strstatusTypeValues[7],
						objNotificationValues.strBelowValueForNDSt)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[0],
						strstatusTypeValues[7])
						
				.selEmailPagerWebChkBoxes(strResourceValue[0], strstatusTypeValues[8])
				
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
				strstatusTypeValues[9], strStatusesValues[1])
				
				.enterAboveValues(strResourceValue[0], strstatusTypeValues[10],
						objNotificationValues.strAboveValForSST)
				.enterBelowValues(strResourceValue[0], strstatusTypeValues[10],
						objNotificationValues.strBelowValForSST)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[0],
						strstatusTypeValues[10])
						
				.selEmailPagerWebChkBoxes(strResourceValue[0], strstatusTypeValues[11])
		.clickOnSave();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		
		for(int intCount= 6; intCount<strstatusTypeValues.length; intCount++){
			objUpdateStatus1
			.selectStatusTypes(strstatusTypeValues[intCount]);	
		}

		objUpdateStatus1
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[6],
						objView_data.strValueForUpdate)
				.enterNedocsUpdateValue(strstatusTypeValues[7],
						objView_data.strValueForNDST)
				.clickOnCalculate()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[8],
						objView_data.strValueForUpdate)
				.selectMSTUpdateValue(strstatusTypeValues[9],
						strStatusesValues[1])
				.enterUpdateSSTValues(strstatusTypeValues[10],
						objView_data.strValueForSST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[11],
						objView_data.strDateUpdateValue)
				.clickOnSaveButton();
		objEventManagement1.verWebNotificationframeNotPresent();
		
		objLogin1.clickLogOut();
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(objResource_data.strResourceName);
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresentNew(objResource_data.strResourceAbbrivation3);
		
		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}


}
