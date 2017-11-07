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

public class EdgeCaseStatusTypes1 extends TestNG_UI_EXTENSIONSThreeBrowser {

	public EdgeCaseStatusTypes1() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***********************************************************************************
	 * 'Description :Verify that status types associated to resource type while creating status types are displayed on ‘Region Default’ view. 
	 * 'Date :12-Sep-2014 
	 * 'Author :Anil
	 ************************************************************************************/

	@Test(description = "Verify that status types associated to resource type while creating status types are displayed on ‘Region Default’ view. ")
	public void testEdgeCase143818() throws Exception {
		gstrTCID = "143818";
		gstrTO = "Verify that status types associated to resource type while creating status types are displayed on ‘Region Default’ view. ";

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

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		Views Views_Page1 = new Views(this.driver1);

		Login login_page2 = new Login(this.driver2);
		RegionDefault RegionDefault_Page2 = new RegionDefault(this.driver2);
		StatusTypeList StatusTypeList_page2 = new StatusTypeList(this.driver2);
		SelectRegion SelectRegion_page2 = new SelectRegion(this.driver2);
		ViewsList ViewsList_Page2 = new ViewsList(this.driver2);

		String strstatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strstatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];

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

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage();

		ResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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
		ViewsList_Page.navigateToViewsList()
					.clickOnEditLinkOfView(
							objView_data.strRegionDefaultName)
					.clickOnResourcesTab()
					.selectResource(objResource_data.strResourceName)
					.clickNextButton()
					.selectStatusType(
							objStatusTypes_data.strNSTStatusTypeName);
		
//		ViewsList_Page.selectStatusTypeForView(strstatusTypeValues);

		ViewsList_Page
				.clickOnSaveOfCreateNewView()

		.verViewInList(objView_data.strRegionDefaultName);

		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		Thread.sleep(5000);

		RegionDefault_Page1.verifyRegionDefaultPage();

		Views_Page1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		Views_Page1.verStatusTypes(objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strNSTStatusTypeName);

		login_page2.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		Thread.sleep(10000);

		RegionDefault_Page2.selectFrame();

		SelectRegion_page2.clickRegionLink();

		SelectRegion_page2.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_Page2.selectFrame();

		StatusTypeList_page2.navigateToStatusTypeList();

		StatusTypeList_page2.createStatusTypeSelectingRT(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription, strResourceTypeValue);

		strstatusTypeValues1[0] = StatusTypeList_page2
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		ViewsList_Page2.navigateToViewsList()
					   .clickOnEditLinkOfView(
							   objView_data.strRegionDefaultName)
					   .clickOnSTTab()
					   .selectStatusType(
							   objStatusTypes_data.strTSTStatusTypeName1)

//		ViewsList_Page2.selectStatusTypeForView(strstatusTypeValues1)

		.clickOnSaveOfCreateNewView();

		login_page2.clickLogOut();

		login_page1.clickLogOut();

		Thread.sleep(10000);

		login_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame()

		.verifyRegionDefaultPage();

		Views_Page1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		Views_Page1.verStatusTypes(objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strNSTStatusTypeName);

		Views_Page1.verStatusTypes(objResourceType_data.strResourceTypeName,
				objStatusTypes_data.strTSTStatusTypeName1);

		gstrResult = "PASS";
	}

	/***********************************************************************************
	 * 'Description : Edit the status type, deselect the SRT1 and select SRT2 and verify that SRT2 status types are displayed on 'Sub Resource detail' page 
	 * 'Date :16-Sep-2014 
	 * 'Author :Anil
	 ************************************************************************************/

	@Test(description = " 	Edit the status type, deselect the SRT1 and select SRT2 and verify that SRT2 status types are displayed on 'Sub Resource detail' page ")
public void testEdgeCase144282() throws Exception {
	gstrTCID = "144282";
	gstrTO = " 	Edit the status type, deselect the SRT1 and select SRT2 and verify that SRT2 status types are displayed on 'Sub Resource detail' page ";

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
	
	String strstatusTypeValues[] = new String[4];
	String strResourceValue[] = new String[1];
	String strSubResourceTypeValue[] = new String[2];
	String strResourceTypeValue[] = new String[1];
	String strSubResourceValue[] = new String[2];
	
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
			objStatusTypes_data.strSaturationScoreStatusType,
			objStatusTypes_data.strSSTStatusTypeName,
			objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

	strstatusTypeValues[1] = StatusTypeList_page
			.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);
	
	StatusTypeList_page.createStatusTypeWithSection(
			objStatusTypes_data.strNedocCalculationStatusType,
			objStatusTypes_data.strNDSTStatusTypeName,
			objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

	strstatusTypeValues[2] = StatusTypeList_page
			.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);
	
	
	StatusTypeList_page.createStatusTypeWithSection(
			objStatusTypes_data.strTextStatusType,
			objStatusTypes_data.strTSTStatusTypeName,
			objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

	strstatusTypeValues[3] = StatusTypeList_page
			.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
	
	// Resource type creation
	ResourceType_Page.navigateToResourceTypePage();

	ResourceType_Page.createResourceType(
			objResourceType_data.strResourceTypeName, strstatusTypeValues);

	strResourceTypeValue[0] = ResourceType_Page.getResourceTypeValue(objResourceType_data.strResourceTypeName);
	
	String strstatusTypeValues1[] = {strstatusTypeValues[0], strstatusTypeValues[1]};
	
	String strstatusTypeValues2[] = {strstatusTypeValues[2], strstatusTypeValues[3]};
	
	
	ResourceType_Page.createSubResourceType(objResourceType_data.strSubResourceTypeName, strstatusTypeValues1);
	
	strSubResourceTypeValue[0] = ResourceType_Page.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);
	
	ResourceType_Page.createSubResourceType(objResourceType_data.strSubResourceTypeName1, strstatusTypeValues2);
	
	strSubResourceTypeValue[1] = ResourceType_Page.getResourceTypeValue(objResourceType_data.strSubResourceTypeName1);
	
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
	
	Resource_Page.createSubResourceForResource(objResource_data.strSubResourceName1, objResource_data.strResourceAbbrivation, 
			objResourceType_data.strSubResourceTypeName1, objResource_data.strStandardResourceTypename,objResource_data.strResourceFirstName,
			objResource_data.strResourceLastName);
	
	strSubResourceValue[1] = Resource_Page
			.getSubResourceValue(objResource_data.strSubResourceName1);
	
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
	
	String[] strSTNames = {objStatusTypes_data.strNSTStatusTypeName,objStatusTypes_data.strSSTStatusTypeName,objStatusTypes_data.strNDSTStatusTypeName,objStatusTypes_data.strTSTStatusTypeName};
	
		ViewsList_Page.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strSTNames).verViewInList(objView_data.strViewName);

	ViewsList_Page.clickOncustomizeResourceDetailView();
	ViewsList_Page.clickSubResourceButton();
	
	ViewsList_Page.clickOnSubResourceTypeName(objResourceType_data.strSubResourceTypeName);
	
	ViewsList_Page.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0]);
	
	ViewsList_Page.selectSubResourceCheckBox(strstatusTypeValues[0]);
	
	ViewsList_Page.selectSubResourceCheckBox(strstatusTypeValues[1]);
	
	ViewsList_Page.clickOnSubResourceTypeName(objResourceType_data.strSubResourceTypeName1);
	
	ViewsList_Page.selectSubResourceTypeCheckBox(strSubResourceTypeValue[1]);
	
	ViewsList_Page.selectSubResourceCheckBox(strstatusTypeValues[2]);
	
	ViewsList_Page.selectSubResourceCheckBox(strstatusTypeValues[3]);
	
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
	
	ViewsList_Page1.verifyStatusTypeName(objStatusTypes_data.strSSTStatusTypeName);
	
	ViewsList_Page1.navigateToCreatedView(objView_data.strViewName);
	
	ViewsList_Page1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

	ViewsList_Page1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strSubResourceName1);
	
	ViewsList_Page1.verifyStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName);
	
	ViewsList_Page1.verifyStatusTypeName(objStatusTypes_data.strTSTStatusTypeName);
	
	login_page2.loginToApplication(objTest_data.strUserName,
			objTest_data.strPassword);

	Thread.sleep(10000);
	
	RegionDefault_Page2.selectFrame();
	
	SelectRegion_page2.clickRegionLink();
	
	SelectRegion_page2.selectRegionAndNavigate(objTest_data.strRegionName);
	
	RegionDefault_Page2.selectFrame();
	
	StatusTypeList_page2.navigateToStatusTypeList();
	
	StatusTypeList_page2.clickOnEditOfStatusType(objStatusTypes_data.strNDSTStatusTypeName);
	
	StatusTypeList_page2.deSelectResourceType(strSubResourceTypeValue[1]);
	
	StatusTypeList_page2.selectResourceType(strSubResourceTypeValue[0]);
	
	StatusTypeList_page2.clickOnSaveButton();
	
	StatusTypeList_page2.clickOnEditOfStatusType(objStatusTypes_data.strTSTStatusTypeName);
	
	StatusTypeList_page2.deSelectResourceType(strSubResourceTypeValue[1]);
	
	StatusTypeList_page2.selectResourceType(strSubResourceTypeValue[0]);
	
	StatusTypeList_page2.clickOnSaveButton();
	
	ViewsList_Page2.navigateToViewsList();

	ViewsList_Page2.clickOncustomizeResourceDetailView();
	
	ViewsList_Page2.clickSubResourceButton();
	
	ViewsList_Page2.clickOnSubResourceTypeName(objResourceType_data.strSubResourceTypeName);
	
	ViewsList_Page2.selectSubResourceCheckBox(strstatusTypeValues[2]);
	
	ViewsList_Page2.selectSubResourceCheckBox(strstatusTypeValues[3]);
	
	ViewsList_Page2.clickOnSaveButton();
	
	login_page2.clickLogOut();
	
	ViewsList_Page1.navigateToCreatedView(objView_data.strViewName);
	
	ViewsList_Page1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
	
	ViewsList_Page1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strSubResourceName);

	ViewsList_Page1.verifyStatusTypeName(objStatusTypes_data.strNSTStatusTypeName);
	
	ViewsList_Page1.verifyStatusTypeName(objStatusTypes_data.strSSTStatusTypeName);
	
	ViewsList_Page1.verifyStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName);
	
	ViewsList_Page1.verifyStatusTypeName(objStatusTypes_data.strTSTStatusTypeName);
	
	gstrResult = "PASS";
}


}
