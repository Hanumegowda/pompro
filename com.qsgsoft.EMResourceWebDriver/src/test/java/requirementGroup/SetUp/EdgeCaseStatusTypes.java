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
import lib.page.SystemNotifications;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseStatusTypes extends TestNG_UI_EXTENSIONS{

	public EdgeCaseStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/******************************************************************************************
	 * 'Description : Edit the status type, deselect the RT1 and select RT2 and verify that RT2 
	 *                status types are displayed on 'Resource detail' page 
	 * 'Date        : 11-Sep-2014 
	 * 'Author      : Anil
	 ******************************************************************************************/

	@Test(description = "Edit the status type, deselect the RT1 and select RT2 and verify that RT2 status types are displayed on 'Resource detail' page.")
	public void testEdgeCase143816() throws Exception {
		gstrTCID = "143816";
		gstrTO = " Edit the status type, deselect the RT1 and select RT2 and verify that RT2 status types are displayed on 'Resource detail' page.";

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
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		StatusTypeList StatusTypeList_page1 = new StatusTypeList(this.driver1);
		ViewsList ViewsList_Page1 = new ViewsList(this.driver1);

		String strstatusTypeValues[] = new String[4];
		String strResourceValue[] = new String[2];
		String strResourceTypeValue[] = new String[2];

		System.out.println("-----Precondtion execution starts------");
		
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
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		StatusTypeList_page.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

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

		String[] strstatusTypeValues1={strstatusTypeValues[0],strstatusTypeValues[1]};
		ResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues1);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		String[] strstatusTypeValues2={strstatusTypeValues[2],strstatusTypeValues[3]};
		ResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName1, strstatusTypeValues2);

		strResourceTypeValue[1] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);
	
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
		
		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

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

		String[] strResName = {objResource_data.strResourceName, objResource_data.strResourceName1};
		String[] strSTNames = {objStatusTypes_data.strNSTStatusTypeName,objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,objStatusTypes_data.strTSTStatusTypeName};
		
		ViewsList_Page.navigateToViewsList()

		.createViewForMultipleResourcesAndStatusTypes(objView_data.strViewName,
				objView_data.strViewDesc, strResName, strSTNames);

		login_page.clickLogOut();

		System.out.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		Thread.sleep(5000);

		RegionDefault_Page1.verifyRegionDefaultPage();

		ViewsList_Page1.navigateToCreatedView(objView_data.strViewName);

		ViewsList_Page1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		String strStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		for (int intCount = 0; intCount < strStatusTypeNames.length; intCount++) {
			ViewsList_Page1.verifyStatusTypeName(strStatusTypeNames[intCount]);
		}
		
		ViewsList_Page1.navigateToCreatedView(objView_data.strViewName);

		ViewsList_Page1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName1);

		String strStatusTypeNames1[] = {
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		for (int intCount = 0; intCount < strStatusTypeNames1.length; intCount++) {
			ViewsList_Page1.verifyStatusTypeName(strStatusTypeNames1[intCount]);
		}

		login_page1.clickLogOut();

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		Thread.sleep(5000);
		RegionDefault_Page1.selectFrame();

		SelectRegion_page1.clickRegionLink();

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_Page1.selectFrame();

		StatusTypeList_page1.navigateToStatusTypeList()

		.clickOnEditOfStatusType(objStatusTypes_data.strNSTStatusTypeName)

		.deSelectResourceType(strResourceTypeValue[0])
		
		.selectResourceType(strResourceTypeValue[1])

		.clickOnSaveButton()

		.clickOnEditOfStatusType(objStatusTypes_data.strSSTStatusTypeName)

		.deSelectResourceType(strResourceTypeValue[0])
		
		.selectResourceType(strResourceTypeValue[1])

		.clickOnSaveButton();

		login_page1.clickLogOut();

		login_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		ViewsList_Page1.navigateToCreatedView(objView_data.strViewName)
		
	    .clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName1);

		String strStatusTypeNames3[] = {
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		for (int intCount = 0; intCount < strStatusTypeNames3.length; intCount++) {
			ViewsList_Page1.verifyStatusTypeName(strStatusTypeNames3[intCount]);
		}

		gstrResult = "PASS";
	}


	/***********************************************************************************
	 * 'Description : Verify that web check box is displayed corresponding to
	 * 'Expired Status notifications' and is disabled on 'Preferences >> System
	 * Notification' screen 'Date :15-Sep-2014 'Author :Anil
	 ************************************************************************************/

	@Test(description = " Verify that web check box is displayed corresponding to 'Expired Status notifications' and is disabled on 'Preferences >> System Notification' screen ")
	public void testEdgeCase143779() throws Exception {
		gstrTCID = "143779";
		gstrTO = " 	Verify that web check box is displayed corresponding to 'Expired Status notifications' and is disabled on 'Preferences >> System Notification' screen  ";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		SystemNotifications SystemNotifications_Page = new SystemNotifications(
				this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page.selectFrame();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.selectFirstRole()

				.clickSaveButton();
		SystemNotifications_Page.navigateToStatusPreferences();

		SystemNotifications_Page.verifyExpiredStatusWebNotificationDisabled();

		login_page.clickLogOut();

		login_page.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		Thread.sleep(5000);
		
		RegionDefault_page.selectFrame();
		
		SystemNotifications_Page.navigateToStatusPreferences();

		SystemNotifications_Page.verifyExpiredStatusWebNotificationDisabled();
		gstrResult = "PASS";
	}
	/******************************************************************************************
	 * 'Description : Edit the status type, deselect the RT1 and select RT2 and verify that RT1 status 
	 *                 types are not displayed on 'Resource detail' page
	 * 'Date        : 16-Sep-2014 
	 * 'Author      : Anil
	 ******************************************************************************************/

	@Test(description = "Edit the status type, deselect the RT1 and select RT2 and verify that RT1 status types are not displayed on 'Resource detail' page.")
	public void testEdgeCase143817() throws Exception {
		gstrTCID = "143817";
		gstrTO = "Edit the status type, deselect the RT1 and select RT2 and verify that RT1 status types are not displayed on 'Resource detail' page.";

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
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		StatusTypeList StatusTypeList_page1 = new StatusTypeList(this.driver1);
		ViewsList ViewsList_Page1 = new ViewsList(this.driver1);

		String strstatusTypeValues[] = new String[4];
		String strResourceValue[] = new String[2];
		String strResourceTypeValue[] = new String[2];

		System.out.println("-----Precondtion execution starts------");

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
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		StatusTypeList_page.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[2] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		StatusTypeList_page.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[3] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage();

		String[] strstatusTypeValues1 = { strstatusTypeValues[0],
				strstatusTypeValues[1] };
		ResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues1);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		String[] strstatusTypeValues2 = { strstatusTypeValues[2],
				strstatusTypeValues[3] };
		ResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues2);

		strResourceTypeValue[1] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

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

		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

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
		
		String[] strResName = {objResource_data.strResourceName, objResource_data.strResourceName1};
		String[] strSTNames = {objStatusTypes_data.strNSTStatusTypeName,objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,objStatusTypes_data.strTSTStatusTypeName};

		ViewsList_Page.navigateToViewsList()

		.createViewForMultipleResourcesAndStatusTypes(objView_data.strViewName,
				objView_data.strViewDesc, strResName, strSTNames);

		login_page.clickLogOut();

		System.out
				.println("-----Precondtion execution ends and execution starts------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		Thread.sleep(5000);

		RegionDefault_Page1.verifyRegionDefaultPage();

		ViewsList_Page1.navigateToCreatedView(objView_data.strViewName);

		ViewsList_Page1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		String strStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		for (int intCount = 0; intCount < strStatusTypeNames.length; intCount++) {
			ViewsList_Page1.verifyStatusTypeName(strStatusTypeNames[intCount]);
		}

		login_page1.clickLogOut();

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_Page1.selectFrame();

		SelectRegion_page1.clickRegionLink();

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_Page1.selectFrame();

		StatusTypeList_page1.navigateToStatusTypeList()

		.clickOnEditOfStatusType(objStatusTypes_data.strSSTStatusTypeName)

		.deSelectResourceType(strResourceTypeValue[0])
		
		.selectResourceType(strResourceTypeValue[1])

		.clickOnSaveButton();

		login_page1.clickLogOut();

		Thread.sleep(3000);
		
		login_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_Page1.selectFrame();

		ViewsList_Page1.navigateToCreatedView(objView_data.strViewName)

		.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strResourceName1);

		String strStatusTypeNames1[] = { objStatusTypes_data.strSSTStatusTypeName, objStatusTypes_data.strNDSTStatusTypeName, 
				objStatusTypes_data.strTSTStatusTypeName};

		for (int intCount = 0; intCount < strStatusTypeNames1.length; intCount++) {
			ViewsList_Page1.verifyStatusTypeName(strStatusTypeNames1[intCount]);
		}

		String strStatusTypeNames2[] = { objStatusTypes_data.strNSTStatusTypeName };

		for (int intCount = 0; intCount < strStatusTypeNames2.length; intCount++) {
			ViewsList_Page1
					.verifyStatusTypeNameIsNotInView(strStatusTypeNames2[intCount]);
		}

		gstrResult = "PASS";
	}
}
