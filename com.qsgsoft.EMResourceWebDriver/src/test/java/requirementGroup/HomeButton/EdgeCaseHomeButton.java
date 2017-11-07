package requirementGroup.HomeButton;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateUserInfo;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseHomeButton extends TestNG_UI_EXTENSIONS{

	public EdgeCaseHomeButton() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/***********************************************************************************************
	'Description : Verify that clicking on the 'Home' button takes the user to region default screen 
	'Date	 	 : 21-Oct-2014
	'Author		 : Anitha
	************************************************************************************************/
	
	@Test(description ="Change the region default view to 'map' and verify that clicking on the 'Home' button takes the user to map screen")
	public void testEdgeCase147099() throws Exception {
	
		gstrTCID = "147099";
		gstrTO = "Change the region default view to 'map' and verify that clicking on the 'Home' button takes the user to map screen";

		Login_data login_data = new Login_data();
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		login_page1.loginToApplication(login_data.strUserName, login_data.strPassword);
	    	    	
		RegionDefault_page1.selectFrame();
		
		SelectRegion_page1.selectRegionAndNavigate(login_data.strQuickLinkRegion);
	    
	    RegionDefault_page1.selectFrame();

	    objNavigationToSubmenus1.navigateToMap();
	    
	    RegionDefault_page1.clickOnHomeButton();
	    
	    RegionDefault_page1.verifyRegionDefaultPage();
  
	    login_page1.clickLogOut();
	    
	    gstrResult = "PASS";

	}
	
	/***********************************************************************************************
	'Description : Change the region default view to 'Custom' and verify that clicking on the 'Home' button
	               takes the user to 'Custom View - Table' [Edit]. 
	'Date	 	 : 3-Nov-2014.
	'Author		 : sangappa.k.
	************************************************************************************************/
	@Test(description = "Change the region default view to 'Custom' and verify that clicking on the 'Home' button"
			+ " takes the user to 'Custom View - Table' [Edit]. ")
	public void testEdgeCase147100() throws Exception {

		gstrTCID = "147100";
		gstrTO = "Change the region default view to 'Custom' and verify that clicking on the 'Home' button"
				+ " takes the user to 'Custom View - Table' [Edit]. ";
		// login data
		Login_data login_data = new Login_data();
		Login login_page1 = new Login(this.driver1);
		
		// objects
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(driver1);
		ResourceType objResourceType_page1 = new ResourceType(driver1);
		Resource objResource_page1 = new Resource(driver1);
		UsersList objUsersList_page1 = new UsersList(driver1);
		CustomUnderView objCustomUnderView_page1 = new CustomUnderView(driver1);
		UpdateUserInfo objUpdateUserInfo_page1 = new UpdateUserInfo(driver1);
		NavigationToSubMenus objNavigationToSubMenus_page1 = new NavigationToSubMenus(
				driver1);
		// data
		Resource_data resource_data = new Resource_data();
		ResourceType_data resourceType_data = new ResourceType_data();
		StatusTypes_data statusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		User_data objUser_data = new User_data();
		
		// array of String for all sources
		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		login_page1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objRegionDefault_page1.selectFrame();

		objSelectRegion_page1
				.selectRegionAndNavigate(login_data.strRegionName1);

		objRegionDefault_page1.selectFrame();

		// status type number
		objStatusTypeList1.navigateToStatusTypeList();

		objStatusTypeList1.createStatusType(
				statusTypes_data.strNumberStatusType,
				statusTypes_data.strNSTStatusTypeName,
				statusTypes_data.strStatusDescription);
		strStatusTypeValues[0] = objStatusTypeList1
				.getStatusValue(statusTypes_data.strNSTStatusTypeName);

		// text

		objStatusTypeList1.createStatusType(statusTypes_data.strTextStatusType,
				statusTypes_data.strTSTStatusTypeName,
				statusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList1
				.getStatusValue(statusTypes_data.strTSTStatusTypeName);

		// resource Type

		objResourceType_page1.navigateToResourceTypePage();

		objResourceType_page1.createResourceType(
				resourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_page1
				.getResourceTypeValue(resourceType_data.strResourceTypeName);

		// resource
		objResource_page1.navigateToResourceListPage();

		objResource_page1.createResource(resource_data.strResourceName,
				resource_data.strResourceAbbrivation1,
				resourceType_data.strResourceTypeName,
				resource_data.strStandardResourceTypename,
				resource_data.strResourceFirstName,
				resource_data.strResourceLastName);

		strResourceValue[0] = objResource_page1
				.getResourceValue(resource_data.strResourceName);

		// user A
		objUsersList_page1.navigateToUsersNew();

		objUsersList_page1.clickCreateNewUserButton().enterUserDetails(
				objUser_data.strNewUserName2, objUser_data.strNewPassword,
				objUser_data.strFullName);
		objUsersList_page1.selectFirstRole();

		objUsersList_page1.clickAdvancedOptionAndExpand();
		objUsersList_page1.selectViewcustomViewOption();

		objUsersList_page1.clickSaveButton();
		login_page1.clickLogOut();

		System.out.println(objUser_data.strNewUserName2);
		
		// login as new user
		login_page1.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);
		objRegionDefault_page1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView_page1.clickOnSetupCustomViewLink();

		objCustomUnderView_page1.clickOnAddMoreResources();

		objCustomUnderView_page1
				.enterResNameInWhatField(resource_data.strResourceName);

		objCustomUnderView_page1.clickOnSearch();

		objCustomUnderView_page1.selectResource(strResourceValue);

		objCustomUnderView_page1.clickOnAddToCustomView();

		objCustomUnderView_page1.clickOnOptions();

		objCustomUnderView_page1.selectStatusTypes(strStatusTypeValues);

		objCustomUnderView_page1.selectAllChkBoxInOptions();

		objCustomUnderView_page1.clickOnSave();

		// prefernces
		objNavigationToSubMenus_page1.navigateToUsersInfoInPreferences();

		objUpdateUserInfo_page1.selectDefaultViewName(objView_data.strCustom);

		objUpdateUserInfo_page1.clickOnSaveButton();

		objRegionDefault_page1.clickOnHomeButton();

		String[] strResourceNames = { resource_data.strResourceName };
		String[] strStatusTypeNames = { statusTypes_data.strNSTStatusTypeName,
				statusTypes_data.strTSTStatusTypeName };

		objCustomUnderView_page1.verResourceAndResTypeInCustomViewTablePage(
				strResourceNames, resourceType_data.strResourceTypeName);

		objCustomUnderView_page1
				.verStatusTypeInCustomViewTablePage(strStatusTypeNames);

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	'Description : Change the region default view to 'View2' from 'View1' and verify that clicking on 
	                 the 'Home' button takes the user to View2 (Region default view)'
	'Date	 	 : 7-Nov-2014
	'Author		 : sangappa.k
	************************************************************************************************/
	@Test(description = "Change the region default view to 'View2' from 'View1' and verify that"
			+ "clicking on the 'Home' button takes the user to View2 (Region default view)")
	public void testEdgeCase147098() throws Exception {

		gstrTCID = "147098";
		gstrTO = "Change the region default view to 'View2' from 'View1' and verify that"
				+ "clicking on the 'Home' button takes the user to View2 (Region default view)";
		Login_data login_data = new Login_data();
		Login login_page1 = new Login(this.driver1);// ie
		Login login_page = new Login(this.driver1);// fire

		// objects

		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		RegionDefault objRegionDefault_page2 = new RegionDefault(this.driver1);

		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);

		StatusTypeList objStatusTypeList1_page1 = new StatusTypeList(driver);
		ResourceType objResourceType_page1 = new ResourceType(driver);
		Resource objResource_page1 = new Resource(driver);
		UsersList objUsersList_page1 = new UsersList(driver);

		UpdateUserInfo objUpdateUserInfo_page1 = new UpdateUserInfo(driver1);
		NavigationToSubMenus objNavigationToSubMenus_page1 = new NavigationToSubMenus(
				driver1);
		ViewsList objviewsList_page1 = new ViewsList(driver);
		Views objViews_page1 = new Views(driver1);

		// data

		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		User_data objUser_data = new User_data();

		// arrays for STV,RTV,RSV
		String strStatusTypeValues1[] = new String[3];
		String strStatusTypeValues2[] = new String[3];
		String strStatusTypeValues[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		login_page.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objRegionDefault_page1.selectFrame();

		objSelectRegion_page1
				.selectRegionAndNavigate(login_data.strRegionName1);

		objRegionDefault_page1.selectFrame();

		objStatusTypeList1_page1.navigateToStatusTypeList();

		// number

		objStatusTypeList1_page1.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// text

		objStatusTypeList1_page1.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[1] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		// multi

		objStatusTypeList1_page1.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,objStatusTypes_data.strStatusColor)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[2] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// date

		objStatusTypeList1_page1.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[0] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);
		// satauration score

		objStatusTypeList1_page1.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[1] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		// NEDOCS calculation

		objStatusTypeList1_page1.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[2] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		strStatusTypeValues = ArrayUtils.addAll(strStatusTypeValues1,
				strStatusTypeValues2);

		// resource Type

		objResourceType_page1.navigateToResourceTypePage();

		objResourceType_page1.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_page1
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// resource

		objResource_page1.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation1,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource_page1
				.getResourceValue(objResource_data.strResourceName);

		// create the 1st views in setup
		String strStatusTypeNames1[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName };
		
		objviewsList_page1.navigateToViewsList();
		objviewsList_page1.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypeNames1);

//		.clickCreateNewViewButton().enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues1)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		// create the 2nd views in setup

		objviewsList_page1.navigateToViewsList();
		// ver Status types for view 2
		String strStatusTypeNames2[] = {
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strNDSTStatusTypeName1 };
		
		objviewsList_page1.createView(objView_data.strViewName2, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypeNames2);
		
//		.clickCreateNewViewButton().enterViewName(objView_data.strViewName2)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues2)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		// new user
		objUsersList_page1
				.navigateToUsersNew()
				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickSaveButton();

		login_page.clickLogOut();

		// login as a new user

		login_page1.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);

		objRegionDefault_page2.selectFrame();

		objNavigationToSubMenus_page1.navigateToUsersInfoInPreferences();

		objUpdateUserInfo_page1.verUpdateUserInfoIsDisplayed()
				.selectDefaultViewName(objView_data.strViewName)
				.clickOnSaveButton();

		objRegionDefault_page2.clickOnHomeButton();

		objViews_page1.verViewScreenIsDisplayed(objView_data.strViewName)
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName);

		// ver Status types view 1

		for (int i = 0; i < strStatusTypeNames1.length; i++) {

			System.out.println(strStatusTypeNames1[i]);

			objViews_page1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames1[i]);
		}

		objNavigationToSubMenus_page1.navigateToUsersInfoInPreferences();

		objUpdateUserInfo_page1
				.selectDefaultViewName(objView_data.strViewName2)
				.clickOnSaveButton();

		objRegionDefault_page2.clickOnHomeButton();
		objViews_page1.verViewScreenIsDisplayed(objView_data.strViewName2)

		.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames2.length; i++) {
			objViews_page1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames2[i]);
		}

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
}
