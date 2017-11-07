package requirementGroup.SmokeTestSuite;

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
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSThreeBrowser;

public class SmokeSetup1 extends TestNG_UI_EXTENSIONSThreeBrowser {

	public SmokeSetup1() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***********************************************************************************
	 * 'Description :Verify that status types associated to resource type while creating status types are displayed on ‘Resource Detail’ screens 
	 *  'Date:21-Nov-2014 
	 *  'Author :Anil
	 ************************************************************************************/

	@Test(description = "Verify that status types associated to resource type while creating status types are displayed on ‘Resource Detail’ screens ")
public void testSmoke148824() throws Exception {
	gstrTCID = "148824";
	gstrTO = "Verify that status types associated to resource type while creating status types are displayed on ‘Resource Detail’ screens ";

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
			
	StatusTypeList_page.clickOnReturnToStatusTypeList()
	
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

		String strStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName };
	
	ViewsList_Page.navigateToViewsList()
//	.clickCreateNewViewButton()
//	.enterViewName(objView_data.strViewName)
//	.enterViewDesc(objView_data.strViewDesc);
//
//	ViewsList_Page.selectStatusTypeForView(strstatusTypeValues)
//	
//	ViewsList_Page.selectResource(objResource_data.strResourceName)
//		.clickOnSaveOfCreateNewView()
//		.verViewInList(objView_data.strViewName);
		.createView(objView_data.strViewName, objView_data.strViewDesc,
				objResource_data.strResourceName, strStatusTypeNames);
	
	login_page.clickLogOut();

	login_page1.loginAsNewUser(objUser_data.strNewUserName,
			objUser_data.strNewPassword);

	RegionDefault_Page1.selectFrame();
	
	Thread.sleep(5000);
	
	RegionDefault_Page1.verifyRegionDefaultPage();
	
	ViewsList_Page1.navigateToCreatedView(objView_data.strViewName);
	
	ViewsList_Page1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
	
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
}
