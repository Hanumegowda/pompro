package requirementGroup.CreatingAndManagingMultiRegionViews;

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
import lib.page.Login;
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

public class HappyDayCreatingMultiRegionViews extends TestNG_UI_EXTENSIONS{
	
	public HappyDayCreatingMultiRegionViews() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*************************************************************************************
	'Description :  Verify that Summary totals of the numeric status types that are created 
					selecting "Display Summary Totals" are displayed under each Resource Type
					 added to ‘Region default View’.
	'Precondition:
	'Date	 	 : 06-Aug-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " Verify that Summary totals of the numeric status types that are created "
			+ "selecting 'Display Summary Totals' are displayed under each Resource "
			+ "Type added to ‘Region default View’.")
	public void testHappyDay179864() throws Exception {

		gstrTCID = "179864";
		gstrTO =" Verify that Summary totals of the numeric status types that are created "
				+ "selecting 'Display Summary Totals' are displayed under each Resource "
				+ "Type added to ‘Region default View’.";

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
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.clickCreateNewStatusTypeButton()
						.selectStatusType(objStatuTypes_data.strNumberStatusType)
						.clickNextButton()
						.enterStatusTypeName(objStatuTypes_data.strNSTStatusTypeName)
						.enterStatusTypeDescription(objStatuTypes_data.strStatusDescription)
						.selectDisplaySummaryTotalsCheckBox()
						.clickOnSaveButton();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

	
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objNavigationToSubMenus.navigateToViews();

		objViewsList.clickOnEditOfRegDefault();
		
		objViewsList.clickOnResourcesTab()
		.selectResource(objResource_data.strResourceName)
		.clickNextButton();

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName};
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {	
		objViewsList.selectStatusType(strStatusTypeNames[i]);
		}
		
		objViewsList.clickOnSaveOfCreateNewView();

		objLogin.clickLogOut();

		System.out.println(objUser_data.strNewUserName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objViewsList1.verifySummaryTableIsDisplayed(objResourceType_data.strResourceTypeName);
		
		objViewsList1.verResAndStatuaTypesWithValue(strResourceTypeValue[0], objResource_data.strResourceName,
						objStatuTypes_data.strNSTStatusTypeName, objView_data.strHyphen);
		
		objViewsList1.verifyValueDisplayedInSummary(objResourceType_data.strResourceTypeName, objView_data.strZero);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objViewsList1.verifySummaryTableIsDisplayed(objResourceType_data.strResourceTypeName);
		
		objViewsList1.verResAndStatuaTypesWithValue(strResourceTypeValue[0], objResource_data.strResourceName, 
				objStatuTypes_data.strNSTStatusTypeName, objView_data.strHyphen);
		
		objViewsList1.verifyValueDisplayedInSummary(objResourceType_data.strResourceTypeName, objView_data.strZero);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
		
		objUpdateStatus_Page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
				objView_data.strValueForUpdate);
		
		objUpdateStatus_Page1.clickOnSaveButton();
		
		objViewsList1.verResAndStatuaTypesWithValue(strResourceTypeValue[0], objResource_data.strResourceName,
				objStatuTypes_data.strNSTStatusTypeName, objView_data.strValueForUpdate);
		
		objViewsList1.verifyValueDisplayedInSummary(objResourceType_data.strResourceTypeName, objView_data.strValueForUpdate);
		
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that user with ‘Setup Region Views’ can update‘Region Default’ view.
	'Precondition	: 
	'Date 			: 22-Mar-2016
	'Author 		: Pallavi
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user with ‘Setup Region Views’ can update‘Region Default’ view.")
	public void testHappyDay179586() throws Exception {

		gstrTCID = "179586";
		gstrTO = "Verify that user with ‘Setup Region Views’ can update‘Region Default’ view.";
		
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		View_data objView_data = new View_data();
		User_data objUser_data = new User_data();
		
		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
						     objStatuTypes_data.strStatusColor)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
			.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
		
		// First resource type creation
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValues);

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
		
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName };

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strStatusTypeNames);
		
		System.out.println(objView_data.strViewName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(
						objResource_data.strResourceName)
				.selectUpdateStatusOfResource(
						objResource_data.strResourceName)
				.selectRunReportsCheckBox(
						objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToViews();
		
		objViewsList1.clickOnEditLinkOfView(objView_data.strRegionDefaultName)
					 .clickOnResourcesTab()
					 .selectResource(objResource_data.strResourceName)
					 .clickNextButton();
		
		for(int i = 0; i<strStatusTypeNames.length; i++) {
			objViewsList1.selectStatusType(strStatusTypeNames[i]);
		}
		
		objViewsList1.clickOnSaveButton()
					 .navigateToCreatedView(objView_data.strRegionDefault);
		
		for(int i=0; i<strStatusTypeNames.length;i++) {
			objViewsList1.verResAndStatusTypes(strResourceTypeValue[0],
					objResource_data.strResourceName, strStatusTypeNames[i]);
		}
		
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that newly created view appears in the user's View Menu immediately. 
	 * 'Date        : 22-Mar-2016 
	 * 'Author      : Renushree
	 ***************************************************************************************************************/
	@Test(description = "Verify that newly created view appears in the user's View Menu immediately.")
	public void testHappyDay180272() throws Exception {

		gstrTCID = "180272";
		gstrTO = "Verify that newly created view appears in the user's View Menu immediately.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		UsersList objUsersList = new UsersList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		objViewsList.getRegionNameFromHeader();

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

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

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

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

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

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToViews();

		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		objViewsList1.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strStatusTypeNames);

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verViewScreenIsDisplayed(objView_data.strViewName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	 * 'Description :  Verify that SubResources or SubResource Types are not available while creating or editing the views.
	 * 'Date		: 22-Mar-2016 
	 * 'Author 		: Sangappa.k
	 ************************************************************************************************/

	@Test(description = " Verify that SubResources or SubResource Types are not available while creating or editing the views.")
	public void testHappyDay179807() throws Exception {

		gstrTCID = "179807";
		gstrTO = " Verify that SubResources or SubResource Types are not available while creating or editing the views.";
		
		Login_data login_data = new Login_data();
		Resource_data objResourcedata_page1 = new Resource_data();
		ResourceType_data objResourceTypedata_page1 = new ResourceType_data();
		StatusTypes_data objStatusTypesdata_page1 = new StatusTypes_data();
		View_data objViewdata_page1 = new View_data();

		Login login_page = new Login(this.driver1);
		RegionDefault objRegionDefault_page = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList1_page = new StatusTypeList(driver);
		ResourceType objResourceType_page = new ResourceType(driver);
		Resource objResource_page = new Resource(driver);
		NavigationToSubMenus objNavigationToSubMenus_page = new NavigationToSubMenus(
				driver);

		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);
		Login login_page1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		ViewsList objviewsList_page1 = new ViewsList(driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];

		String strSubResourceTypeValue[] = new String[1];

		login_page.loginToApplication(login_data.strUserName,
				login_data.strPassword);
		objSelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);
		objRegionDefault_page.selectFrame();

		objNavigationToSubMenus_page.navigateToStatusTypesInSetup();

		objStatusTypeList1_page.createStatusType(
				objStatusTypesdata_page1.strNumberStatusType,
				objStatusTypesdata_page1.strNSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList1_page
				.getStatusValue(objStatusTypesdata_page1.strNSTStatusTypeName);

		objStatusTypeList1_page.createStatusType(
				objStatusTypesdata_page1.strTextStatusType,
				objStatusTypesdata_page1.strTSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList1_page
				.getStatusValue(objStatusTypesdata_page1.strTSTStatusTypeName);

		objStatusTypeList1_page
				.createStatusType(objStatusTypesdata_page1.strMultiStatusType,
						objStatusTypesdata_page1.strMSTStatusTypeName,
						objStatusTypesdata_page1.strStatusDescription)

				.createNewStatus(objStatusTypesdata_page1.strStatusNameInMulti,
						objStatusTypesdata_page1.strStatusColor)

				.createNewStatus(objStatusTypesdata_page1.strStatusNameInMulti1,
						objStatusTypesdata_page1.strStatusColor)
.verCreatedStatusInStatusListForMulti(objStatusTypesdata_page1.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatusTypesdata_page1.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[2] = objStatusTypeList1_page
				.getStatusValue(objStatusTypesdata_page1.strMSTStatusTypeName);

		objStatusTypeList1_page.createStatusType(
				objStatusTypesdata_page1.strDateStatusType,
				objStatusTypesdata_page1.strDateStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList1_page
				.getStatusValue(objStatusTypesdata_page1.strDateStatusTypeName);

		objStatusTypeList1_page.createStatusType(
				objStatusTypesdata_page1.strSaturationScoreStatusType,
				objStatusTypesdata_page1.strSSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList1_page
				.getStatusValue(objStatusTypesdata_page1.strSSTStatusTypeName);

		objStatusTypeList1_page.createStatusType(
				objStatusTypesdata_page1.strNedocCalculationStatusType,
				objStatusTypesdata_page1.strNDSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription);
		strStatusTypeValues[5] = objStatusTypeList1_page
				.getStatusValue(objStatusTypesdata_page1.strNDSTStatusTypeName);

		objResourceType_page.navigateToResourceTypePage().createResourceType(
				objResourceTypedata_page1.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_page
				.getResourceTypeValue(objResourceTypedata_page1.strResourceTypeName);

		objResourceType_page.createSubResourceType(
				objResourceTypedata_page1.strSubResourceTypeName1,
				strStatusTypeValues);

		strSubResourceTypeValue[0] = objResourceType_page
				.getResourceTypeValue(objResourceTypedata_page1.strSubResourceTypeName1);

		objResource_page.navigateToResourceListPage();
		objResource_page.createResourceWithAddress(
				objResourcedata_page1.strResourceName,
				objResourcedata_page1.strResourceAbbrivation1,
				objResourceTypedata_page1.strResourceTypeName,
				objResourcedata_page1.strStandardResourceTypename,
				objResourcedata_page1.strResourceFirstName,
				objResourcedata_page1.strResourceLastName,
				objResourcedata_page1.strStreetAddress,
				objResourcedata_page1.strCity, objResourcedata_page1.strState,
				objResourcedata_page1.strCounty,
				objResourcedata_page1.strZipcode);

		System.out.println(objResourcedata_page1.strResourceName);

		// sub resource
		objResource_page.createSubResourceWithAddress(
				objResourcedata_page1.strSubResourceName1,
				objResourcedata_page1.strResourceName,
				objResourcedata_page1.strResourceAbbrivation1,
				objResourceTypedata_page1.strSubResourceTypeName1,
				objResourcedata_page1.strStandardResourceTypename1,
				objResourcedata_page1.strResourceFirstName,
				objResourcedata_page1.strResourceLastName,
				objResourcedata_page1.strStreetAddress,
				objResourcedata_page1.strState, objResourcedata_page1.strCity,
				objResourcedata_page1.strZipcode,
				objResourcedata_page1.strCounty);

		String[] strStatusTypeNames = {
				objStatusTypesdata_page1.strNSTStatusTypeName,
				objStatusTypesdata_page1.strTSTStatusTypeName,
				objStatusTypesdata_page1.strMSTStatusTypeName,
				objStatusTypesdata_page1.strDateStatusTypeName,
				objStatusTypesdata_page1.strSSTStatusTypeName,
				objStatusTypesdata_page1.strNDSTStatusTypeName };

		login_page.clickLogOut();

		login_page1.loginToApplication(login_data.strUserName,
				login_data.strPassword);
		objSelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName);
		objRegionDefault_page1.selectFrame().clickOnHomeButton();
		objNavigationToSubmenus1.navigateToViews();

		objviewsList_page1
				.clickCreateNewViewButton()
				.enterViewName(objViewdata_page1.strViewName)
				.enterViewDesc(objViewdata_page1.strViewDesc)
				.clickNextButton()
				.selectRegionName(login_data.strRegionName)
				.clickNextButton()
				.eneterResnameInSearchResField(
						objResourceTypedata_page1.strSubResourceTypeName1)
				.verifySubRSOrSubRTAreNotDispInResTab(
						objResourceTypedata_page1.strSubResourceTypeName1)
				.eneterResnameInSearchResField(
						objResourcedata_page1.strSubResourceName1)
				.verifySubRSOrSubRTAreNotDispInResTab(
						objResourcedata_page1.strSubResourceName1)
				.eneterResnameInSearchResField(
						objResourcedata_page1.strResourceName)
				.selectResource(objResourcedata_page1.strResourceName)
				.clickNextButton();
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objviewsList_page1.selectStatusType(strStatusTypeNames[i]);
		}
		objviewsList_page1
				.clickOnSaveOfCreateNewView()
				.verViewInList(objViewdata_page1.strViewName)
				.clickOnEditLinkOfView(objViewdata_page1.strViewName)
				.clickOnResourcesTabInIE()
				.eneterResnameInSearchResField(
						objResourceTypedata_page1.strSubResourceTypeName1)
				.verifySubRSOrSubRTAreNotDispInResTab(
						objResourceTypedata_page1.strSubResourceTypeName1)
				.eneterResnameInSearchResField(
						objResourcedata_page1.strSubResourceName1)
				.verifySubRSOrSubRTAreNotDispInResTab(
						objResourcedata_page1.strSubResourceName1)
				.clickOnSaveOfCreateNewView();
		login_page1.clickLogOut();
		gstrResult = "PASS";

	}
	
	/*************************************************************************************
	'Description :  Verify that Summary totals of the numeric status types that are created 
					selecting "Display Summary Totals" are displayed under each Resource Type
					 added to ‘Region default View’.
	'Precondition:
	'Date	 	 : 06-Aug-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that Summary totals is not displayed under each Resource Type"
			+ " if the numeric status types added to ‘Region default View’ is created by "
			+ "deselecting 'Display Summary Totals'")
	public void testHappyDay179865() throws Exception {

		gstrTCID = "179865";
		gstrTO ="Verify that Summary totals is not displayed under each Resource Type"
				+ " if the numeric status types added to ‘Region default View’ is created by "
				+ "deselecting 'Display Summary Totals'";

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
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.clickCreateNewStatusTypeButton()
						.selectStatusType(objStatuTypes_data.strNumberStatusType)
						.clickNextButton()
						.enterStatusTypeName(objStatuTypes_data.strNSTStatusTypeName)
						.enterStatusTypeDescription(objStatuTypes_data.strStatusDescription)
						.deselectDisplaySummaryTotalsCheckBox()
						.clickOnSaveButton();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

	
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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
				.selectFirstRole()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		objNavigationToSubMenus.navigateToViews();

		objViewsList.clickOnEditOfRegDefault();
		
		objViewsList.clickOnResourcesTab()
		.selectResource(objResource_data.strResourceName)
		.clickNextButton();

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName};
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {	
		objViewsList.selectStatusType(strStatusTypeNames[i]);
		}
		
		objViewsList.clickOnSaveOfCreateNewView();

		objLogin.clickLogOut();

		System.out.println(objUser_data.strNewUserName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objViewsList1.verifySummaryTableIsNotDisplayed(objResourceType_data.strResourceTypeName);
		
		objViewsList1.verResAndStatuaTypesWithValue(strResourceTypeValue[0], objResource_data.strResourceName,
						objStatuTypes_data.strNSTStatusTypeName, objView_data.strHyphen);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objViewsList1.verifySummaryTableIsNotDisplayed(objResourceType_data.strResourceTypeName);
		
		objViewsList1.verResAndStatuaTypesWithValue(strResourceTypeValue[0], objResource_data.strResourceName, 
				objStatuTypes_data.strNSTStatusTypeName, objView_data.strHyphen);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
		
		objUpdateStatus_Page1.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
				objView_data.strValueForUpdate);
		
		objUpdateStatus_Page1.clickOnSaveButton();
		
		objViewsList1.verResAndStatuaTypesWithValue(strResourceTypeValue[0], objResource_data.strResourceName,
				objStatuTypes_data.strNSTStatusTypeName, objView_data.strValueForUpdate);
		
		objViewsList1.verifySummaryTableIsNotDisplayed(objResourceType_data.strResourceTypeName);
		
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that appropriate view name provided is displayed as a page title on 'Create / Edit' view screen. 
	 * 'Date        : 23-Mar-2016 
	 * 'Author      : Renushree
	 ***************************************************************************************************************/
	@Test(description = "Verify that appropriate view name provided is displayed as a page title on 'Create / Edit' view screen.")
	public void testHappyDay180297() throws Exception {

		gstrTCID = "180297";
		gstrTO = "Verify that appropriate view name provided is displayed as a page title on 'Create / Edit' view screen.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		UsersList objUsersList = new UsersList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[1];
		String strStatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		objViewsList.getRegionNameFromHeader();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

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

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption().clickSaveButton();

		objNavigationToSubMenus.navigateToViews();

		String[] strStatusTypeNames = {objStatusTypes_data.strMSTStatusTypeName};
	}
}
