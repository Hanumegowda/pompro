package requirementGroup.SetUp;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
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

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSThreeBrowser;

public class HappyDayStatusTypes1 extends TestNG_UI_EXTENSIONSThreeBrowser {

	public HappyDayStatusTypes1() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***********************************************************************************
	 * 'Description :Verify that status types associated to resource type while
	 * creating status types are displayed on view page 'Date :10-Sep-2014
	 * 'Author :Anitha
	 ************************************************************************************/

	@Test(description = "Verify that status types associated to resource type while creating status types are displayed on view page.")
	public void testHappyDay143813() throws Exception {
		gstrTCID = "143813";
		gstrTO = "Verify that status types associated to resource type while creating status types are displayed on view page";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		View_data objView_data = new View_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Views objViews1 = new Views(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		Login login_page2 = new Login(this.driver2);
		RegionDefault RegionDefault_page2 = new RegionDefault(this.driver2);
		SelectRegion SelectRegion_page2 = new SelectRegion(this.driver2);
		ResourceType ResourceType_Page2 = new ResourceType(this.driver2);
		NavigationToSubMenus objNavigationToSubmenus2 = new NavigationToSubMenus(
				this.driver2);
		ViewsList objViewsList2 = new ViewsList(this.driver2);

		String strstatusTypeValues[] = new String[3];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondtion execution starts------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		StatusTypeList_page.navigateToStatusTypeList();

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage();

		String[] strstatusTypeValues1 = { strstatusTypeValues[0],
				strstatusTypeValues[1] };
		ResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues1);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation

		Resource_Page.navigateToResourceListPage();

		Resource_Page.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();
		
		String[] strSTNames = {objStatusTypes_data.strNSTStatusTypeName,objStatusTypes_data.strNDSTStatusTypeName};
		
		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strSTNames);

		UsersList_page.navigateToUsersNew();

		UsersList_page.clickCreateNewUserButton();

		UsersList_page
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(
						objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		RegionDefault_page1.verifyRegionDefaultPage();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verViewScreenIsDisplayed(objView_data.strViewName)
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName };

		objViews1.verStatusTypesInUserViewScreen(
				objResourceType_data.strResourceTypeName, strStatusTypeNames);

		// b2
		login_page2.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page2.selectFrame();
		Thread.sleep(5000);
		SelectRegion_page2.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page2.selectFrame();

		String[] strstatusTypeValues2 = { strstatusTypeValues[2] },
				strSTNameTST = { objStatusTypes_data.strTSTStatusTypeName };

		ResourceType_Page2
				.navigateToResourceTypePageNew()
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.clickStatusType(strstatusTypeValues2)
				.clickOnSaveButton();

		objNavigationToSubmenus2.navigateToViews();

		objViewsList2.clickOnEditLinkOfView(objView_data.strViewName)
					 .clickOnSTTab()
					 .selectStatusType(
							 objStatusTypes_data.strTSTStatusTypeName)
//
//		.selectStatusTypeForView(strstatusTypeValues2)

		.clickOnSaveOfCreateNewView();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		String[] strStatusTypeNames1 = {
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		objViews1.verStatusTypesInUserViewScreen(
				objResourceType_data.strResourceTypeName, strStatusTypeNames1);

		gstrResult = "PASS";
	}

	/***********************************************************************************
	 * 'Description :Verify that status types associated to resource type while
	 * creating status types are displayed on ‘Resource Detail’ screens. 'Date
	 * :11-Sep-2014 'Author :Anil
	 ************************************************************************************/

	@Test(description = "Verify that status types associated to resource type while creating status types are displayed on ‘Resource Detail’ screens. 	")
public void testHappyDay143752() throws Exception {
	gstrTCID = "143752";
	gstrTO = "Verify that status types associated to resource type while creating status types are displayed on ‘Resource Detail’ screens. 	";

	// Objects for data
	ResourceType_data objResourceType_data = new ResourceType_data();
	Resource_data objResource_data = new Resource_data();
	Login_data objTest_data = new Login_data();
	User_data objUser_data = new User_data();
	StatusTypes_data objStatusTypes_data = new StatusTypes_data();
	View_data objView_data = new View_data();
	
	// Objects for Page
	Login login_page = new Login(this.driver1);
	SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
	RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
	StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
	ResourceType ResourceType_Page = new ResourceType(this.driver1);
	Resource Resource_Page = new Resource(this.driver1);
	UsersList UsersList_page = new UsersList(this.driver1);
	ViewsList ViewsList_Page = new ViewsList(this.driver1);
	NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(this.driver1);
	
	Login login_page1 = new Login(this.driver1);
	RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
	ViewsList ViewsList_Page1 = new ViewsList(this.driver1);
	
	Login login_page2 = new Login(this.driver2);
	RegionDefault RegionDefault_Page2 = new RegionDefault(this.driver2);
	StatusTypeList StatusTypeList_page2 = new StatusTypeList(this.driver2);
	SelectRegion SelectRegion_page2 = new SelectRegion(this.driver2);
	
	String strstatusTypeValues[] = new String[5];
	String strResourceValue[] = new String[1];
	String strstatusesValues[] = new String[1];
	String strstatusTypeValues1[] = new String[1];
	String strResourceTypeValue[] = new String[1];
	
	login_page.loginToApplication(objTest_data.strUserName,
			objTest_data.strPassword);

	SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

	RegionDefault_page.selectFrame();

	NavigationToSubMenus_page.navigateToViews();
	
	ViewsList_Page.createNewSection(objView_data.strSectionName);
	
	StatusTypeList_page.navigateToStatusTypeListNew();

	StatusTypeList_page.createStatusTypeWithSection(
			objStatusTypes_data.strNumberStatusType,
			objStatusTypes_data.strNSTStatusTypeName,
			objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

	strstatusTypeValues[0] = StatusTypeList_page
			.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

	StatusTypeList_page.createStatusTypeWithSection(
			objStatusTypes_data.strMultiStatusType,
			objStatusTypes_data.strMSTStatusTypeName,
			objStatusTypes_data.strStatusDescription, objView_data.strSectionName)

	.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
	
	.verCreatedStatusInStatusListForMulti(
			objStatusTypes_data.strStatusNameInMulti);
	
	strstatusesValues[0] = StatusTypeList_page.getStatusesValue(
			objStatusTypes_data.strStatusNameInMulti);
			
	StatusTypeList_page.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
			objStatusTypes_data.strStatusColor)
	.verCreatedStatusInStatusListForMulti(
			objStatusTypes_data.strStatusNameInMulti1)
	.clickOnReturnToStatusTypeList()
	
	.navigateToStatusTypeListNew();
	
	strstatusTypeValues[1] = StatusTypeList_page
			.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

	StatusTypeList_page.createStatusTypeWithSection(
			objStatusTypes_data.strSaturationScoreStatusType,
			objStatusTypes_data.strSSTStatusTypeName,
			objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

	strstatusTypeValues[2] = StatusTypeList_page
			.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

	StatusTypeList_page.createStatusTypeWithSection(
			objStatusTypes_data.strNedocCalculationStatusType,
			objStatusTypes_data.strNDSTStatusTypeName,
			objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

	strstatusTypeValues[3] = StatusTypeList_page
			.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

	StatusTypeList_page.createStatusTypeWithSection(
			objStatusTypes_data.strTextStatusType,
			objStatusTypes_data.strTSTStatusTypeName,
			objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

	strstatusTypeValues[4] = StatusTypeList_page
			.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

	// Resource type creation
	ResourceType_Page.navigateToResourceTypePage();

	ResourceType_Page.createResourceType(
			objResourceType_data.strResourceTypeName, strstatusTypeValues);

	strResourceTypeValue[0] = ResourceType_Page.getResourceTypeValue(objResourceType_data.strResourceTypeName);
	
	// Resource creation
	Resource_Page.navigateToResourceListPage();

	Resource_Page.createResource(objResource_data.strResourceName,
			objResource_data.strResourceAbbrivation,
			objResourceType_data.strResourceTypeName,
			objResource_data.strStandardResourceTypename,
			objResource_data.strResourceFirstName,
			objResource_data.strResourceLastName);

	strResourceValue[0] = Resource_Page
			.getResourceValue(objResource_data.strResourceName);

	// User creation

	UsersList_page.navigateToUsersNew();

	System.out.println(objUser_data.strNewUserName);
	
	UsersList_page
			.clickCreateNewUserButton()
			
			.enterUserDetails(objUser_data.strNewUserName,
					objUser_data.strNewPassword, objUser_data.strFullName)

			.selectFirstRole()

			.selectViewResourceCheckBox(objResource_data.strResourceName)

			.selectUpdateStatusOfResource(objResource_data.strResourceName)

			.clickSaveButton();

	ViewsList_Page.navigateToViewsList();
	
	String[] strSTNames = {objStatusTypes_data.strNSTStatusTypeName,objStatusTypes_data.strMSTStatusTypeName,
			objStatusTypes_data.strSSTStatusTypeName,objStatusTypes_data.strNDSTStatusTypeName,objStatusTypes_data.strTSTStatusTypeName};
	
		ViewsList_Page.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strSTNames).verViewInList(objView_data.strViewName);

	login_page.clickLogOut();

	login_page1.loginAsNewUser(objUser_data.strNewUserName,
			objUser_data.strNewPassword);

	RegionDefault_Page1.selectFrame();
	
	Thread.sleep(5000);
	
	RegionDefault_Page1.verifyRegionDefaultPage();
	
	ViewsList_Page1.navigateToCreatedView(objView_data.strViewName);
	
	ViewsList_Page1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
	
	String strStatusTypeNames[] = {objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strMSTStatusTypeName, objStatusTypes_data.strSSTStatusTypeName ,
			objStatusTypes_data.strTSTStatusTypeName, objStatusTypes_data.strNDSTStatusTypeName};
	
	for(int intCount = 0; intCount<strStatusTypeNames.length; intCount++){
		ViewsList_Page1.verifyStatusTypeName(strStatusTypeNames[intCount]);
	}
	
	login_page2.loginToApplication(objTest_data.strUserName,
			objTest_data.strPassword);

	RegionDefault_Page2.selectFrame();
	
	SelectRegion_page2.clickRegionLink();
	
	SelectRegion_page2.selectRegionAndNavigate(objTest_data.strRegionName);
	
	RegionDefault_Page2.selectFrame();
	
	StatusTypeList_page2.navigateToStatusTypeList();
	
	StatusTypeList_page2.createStatusTypeWithSectionAndRT(
			objStatusTypes_data.strTextStatusType,
			objStatusTypes_data.strTSTStatusTypeName1,
			objStatusTypes_data.strStatusDescription, objView_data.strSectionName, strResourceTypeValue[0]);

	strstatusTypeValues1[0] = StatusTypeList_page2
			.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);
	
	login_page2.clickLogOut();
	
	login_page1.clickLogOut();
	
	Thread.sleep(10000);
	
	login_page1.loginToApplication(objUser_data.strNewUserName,
			objUser_data.strNewPassword);

	RegionDefault_Page1.selectFrame()
	
	.verifyRegionDefaultPage();
	
	ViewsList_Page1.navigateToCreatedView(objView_data.strViewName);
	
	ViewsList_Page1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
	
	for(int intCount = 0; intCount<strStatusTypeNames.length; intCount++){
		ViewsList_Page1.verifyStatusTypeName(strStatusTypeNames[intCount]);
	}
	
	ViewsList_Page1.verifyStatusTypeName(objStatusTypes_data.strTSTStatusTypeName1);
	
	gstrResult = "PASS";
}



	/***********************************************************************************
	 * 'Description : 	Verify that status types associated to sub resource type while creating status types are displayed on sub-resource detail page 
	 * 'Date :12-Sep-2014 
	 * 'Author :Anil
	 ************************************************************************************/

	@Test(description = " 	Verify that status types associated to sub resource type while creating status types are displayed on sub-resource detail page ")
public void testHappyDay144280() throws Exception {
	gstrTCID = "144280";
	gstrTO = " 	Verify that status types associated to sub resource type while creating status types are displayed on sub-resource detail page ";

	// Objects for data
	ResourceType_data objResourceType_data = new ResourceType_data();
	Resource_data objResource_data = new Resource_data();
	Login_data objTest_data = new Login_data();
	User_data objUser_data = new User_data();
	StatusTypes_data objStatusTypes_data = new StatusTypes_data();
	View_data objView_data = new View_data();
	
	// Objects for Page
	Login login_page = new Login(this.driver1);
	SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
	RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
	StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
	ResourceType ResourceType_Page = new ResourceType(this.driver1);
	Resource Resource_Page = new Resource(this.driver1);
	UsersList UsersList_page = new UsersList(this.driver1);
	ViewsList ViewsList_Page = new ViewsList(this.driver1);
	NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(this.driver1);
	
	Login login_page1 = new Login(this.driver1);
	RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
	ViewsList ViewsList_Page1 = new ViewsList(this.driver1);
	
	Login login_page2 = new Login(this.driver2);
	RegionDefault RegionDefault_Page2 = new RegionDefault(this.driver2);
	StatusTypeList StatusTypeList_page2 = new StatusTypeList(this.driver2);
	SelectRegion SelectRegion_page2 = new SelectRegion(this.driver2);
	ViewsList ViewsList_Page2 = new ViewsList(this.driver2);
	
	String strstatusTypeValues[] = new String[1];
	String strResourceValue[] = new String[1];
	String strSubResourceTypeValue[] = new String[1];
	String strstatusTypeValues1[] = new String[1];
	String strResourceTypeValue[] = new String[1];
	String strSubResourceValue[] = new String[1];
	
	login_page.loginToApplication(objTest_data.strUserName,
			objTest_data.strPassword);

	SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

	RegionDefault_page.selectFrame();

	NavigationToSubMenus_page.navigateToViews();
	
	ViewsList_Page.createNewSection(objView_data.strSectionName);
	
	StatusTypeList_page.navigateToStatusTypeListNew();

	StatusTypeList_page.createStatusTypeWithSection(
			objStatusTypes_data.strNumberStatusType,
			objStatusTypes_data.strNSTStatusTypeName,
			objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

	strstatusTypeValues[0] = StatusTypeList_page
			.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

	// Resource type creation
	ResourceType_Page.navigateToResourceTypePage();

	ResourceType_Page.createResourceType(
			objResourceType_data.strResourceTypeName, strstatusTypeValues);

	strResourceTypeValue[0] = ResourceType_Page.getResourceTypeValue(objResourceType_data.strResourceTypeName);
	
	ResourceType_Page.createSubResourceType(objResourceType_data.strSubResourceTypeName, strstatusTypeValues);
	
	strSubResourceTypeValue[0] = ResourceType_Page.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);
	
	// Resource creation
	Resource_Page.navigateToResourceListPage();

	Resource_Page.createResource(objResource_data.strResourceName,
			objResource_data.strResourceAbbrivation,
			objResourceType_data.strResourceTypeName,
			objResource_data.strStandardResourceTypename,
			objResource_data.strResourceFirstName,
			objResource_data.strResourceLastName);

	strResourceValue[0] = Resource_Page
			.getResourceValue(objResource_data.strResourceName);

	Resource_Page.createSubResource(objResource_data.strSubResourceName, objResource_data.strResourceName, objResource_data.strResourceAbbrivation, 
			objResourceType_data.strSubResourceTypeName, objResource_data.strStandardResourceTypename,objResource_data.strResourceFirstName,
			objResource_data.strResourceLastName);
	
	strSubResourceValue[0] = Resource_Page
			.getSubResourceValue(objResource_data.strSubResourceName);
	
	System.out.println(strSubResourceValue[0]);
	// User creation

	UsersList_page.navigateToUsersNew();

	System.out.println(objUser_data.strNewUserName);
	
	UsersList_page
			.clickCreateNewUserButton()
			
			.enterUserDetails(objUser_data.strNewUserName,
					objUser_data.strNewPassword, objUser_data.strFullName)

			.selectFirstRole()

			.selectViewResourceCheckBox(objResource_data.strResourceName)

			.selectUpdateStatusOfResource(objResource_data.strResourceName)

			.clickSaveButton();
	System.out.println(objUser_data.strNewUserName);
	ViewsList_Page.navigateToViewsList();

	ViewsList_Page.createView(objView_data.strViewName,
			objView_data.strViewDesc, objResource_data.strResourceName,
			objStatusTypes_data.strNSTStatusTypeName).verViewInList(objView_data.strViewName)
		.verViewInList(objView_data.strViewName);
	
	ViewsList_Page.clickOncustomizeResourceDetailView();
	ViewsList_Page.clickSubResourceButton();
	
	ViewsList_Page.clickOnSubResourceTypeName(objResourceType_data.strSubResourceTypeName);
	
	ViewsList_Page.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0]);
	
	ViewsList_Page.selectSubResourceCheckBox(strstatusTypeValues[0]);
	
	ViewsList_Page.clickOnSaveButton();
	
	login_page.clickLogOut();

	login_page1.loginAsNewUser(objUser_data.strNewUserName,
			objUser_data.strNewPassword);

	RegionDefault_Page1.selectFrame();
	
	Thread.sleep(5000);
	
	RegionDefault_Page1.verifyRegionDefaultPage();
	
	ViewsList_Page1.navigateToCreatedView(objView_data.strViewName);
	
	ViewsList_Page1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

	ViewsList_Page1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strSubResourceName);
	
		ViewsList_Page1.verifyStatusTypeName(objStatusTypes_data.strNSTStatusTypeName);
	
	login_page2.loginToApplication(objTest_data.strUserName,
			objTest_data.strPassword);

	Thread.sleep(10000);
	
	RegionDefault_Page2.selectFrame();
	
	SelectRegion_page2.clickRegionLink();
	
	SelectRegion_page2.selectRegionAndNavigate(objTest_data.strRegionName);
	
	RegionDefault_Page2.selectFrame();
	
	StatusTypeList_page2.navigateToStatusTypeList();
	
	StatusTypeList_page2.createStatusTypeWithSectionAndRT(
			objStatusTypes_data.strTextStatusType,
			objStatusTypes_data.strTSTStatusTypeName1,
			objStatusTypes_data.strStatusDescription, objView_data.strSectionName, strSubResourceTypeValue[0]);

	strstatusTypeValues1[0] = StatusTypeList_page2
			.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);
	
	ViewsList_Page2.navigateToViewsList();

	ViewsList_Page2.clickOncustomizeResourceDetailView();
	
	ViewsList_Page2.clickSubResourceButton();
	
	ViewsList_Page2.clickOnSubResourceTypeName(objResourceType_data.strSubResourceTypeName);
	
	ViewsList_Page2.selectSubResourceCheckBox(strstatusTypeValues1[0]);
	
	ViewsList_Page2.clickOnSaveButton();
	
	login_page2.clickLogOut();
	
	login_page1.clickLogOut();
	
	Thread.sleep(10000);
	
	login_page1.loginToApplication(objUser_data.strNewUserName,
			objUser_data.strNewPassword);

	RegionDefault_Page1.selectFrame()
	
	.verifyRegionDefaultPage();
	
	System.out.println(objView_data.strViewName);
	
	ViewsList_Page1.navigateToCreatedView(objView_data.strViewName);
	
	ViewsList_Page1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
	
	ViewsList_Page1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strSubResourceName);

	ViewsList_Page1.verifyStatusTypeName(objStatusTypes_data.strNSTStatusTypeName);
	
	ViewsList_Page1.verifyStatusTypeName(objStatusTypes_data.strTSTStatusTypeName1);
	
	gstrResult = "PASS";
}


}
