package requirementGroup.ViewingAndmanagingEMResourceEntitiesOnTheViewInterface;

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

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayViewResourceDetailScreen extends TestNG_UI_EXTENSIONS {
	
	public HappyDayViewResourceDetailScreen() throws Exception {
		super();
	}
	
	/*******************************************************************************************
	'Description 	: Verify that traffic can be viewed by selecting 'traffic' on the map displayed on 'View Resource Detail' page 
	'Precondition	: 
	'Date 			: 11-Nov-2014 
	'Author 		: Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that traffic can be viewed by selecting 'traffic' on the map displayed on 'View Resource Detail' page")
	public void testHappyDay135643() throws Exception {

		gstrTCID = "135643";
		gstrTO = "Verify that traffic can be viewed by selecting 'traffic' on the map displayed on 'View Resource Detail' page";

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

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Views objViews = new Views(this.driver1);

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
				.createView(objView_data.strViewName,
						objView_data.strViewDesc,
						objResource_data.strResourceName,
						strStatusTypeNames);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews.clickOnResource(objResource_data.strResourceName)
				.verResourceScreenDisplayed(objResource_data.strResourceName)
				.verTrafficBtnInMap().verMapAndSatelliteBtnInMap();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	 * 'Description : Verify that traffic can be viewed by selecting 'traffic'on the map displayed
	 * 				 on sub-resource's 'View Resource Detail' page 
	 * 'Date		: 11-Nov-2014 
	 * 'Author 		: sangappa.k
	 ************************************************************************************************/

	@Test(description = "Verify that traffic can be viewed by selecting 'traffic' on the map displayed on"
			+ "sub-resource's 'View Resource Detail' page ")
	public void testHappyDay135869() throws Exception {

		gstrTCID = "135869";
		gstrTO = "Verify that traffic can be viewed by selecting 'traffic' on the map displayed on"
				+ "sub-resource's 'View Resource Detail' page ";

		Login login_page1 = new Login(this.driver1);
		
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList1_page1 = new StatusTypeList(driver);
		ResourceType objResourceType_page1 = new ResourceType(driver);
		Resource objResource_page1 = new Resource(driver);
		UsersList objUsersList_page1 = new UsersList(driver);

		NavigationToSubMenus objNavigationToSubMenus_page1 = new NavigationToSubMenus(
				driver);
		ViewsList objviewsList_page1 = new ViewsList(driver);
		NavigationToSubMenus objNavigationToSubmenus2 = new NavigationToSubMenus(
				this.driver1);
		Login login_page2 = new Login(this.driver1);
		Views objViews_page2 = new Views(driver1);
		RegionDefault objRegionDefault_page2 = new RegionDefault(this.driver1);
		// data
		Login_data login_data = new Login_data();
		Resource_data objResourcedata_page1 = new Resource_data();
		ResourceType_data objResourceTypedata_page1 = new ResourceType_data();
		StatusTypes_data objStatusTypesdata_page1 = new StatusTypes_data();
		View_data objViewdata_page1 = new View_data();
		User_data objUserdata_page1 = new User_data();

		// array of String for all sources
		String strStatusTypeValues1[] = new String[3];
		String strStatusTypeValues2[] = new String[3];
		String strResourceTypeValue[] = new String[1];

		// subrestype values
		String strSubResourceTypeValue[] = new String[1];

		// login as admine
		login_page1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objRegionDefault_page1.selectFrame();

		objSelectRegion_page1
				.selectRegionAndNavigate(login_data.strRegionName1);

		objRegionDefault_page1.selectFrame();

		// create section
		objNavigationToSubMenus_page1.navigateToViews();

		objviewsList_page1.clickOncustomizeResourceDetailView()
				.enterSectionName(objViewdata_page1.strSectionName)
				.clickOnCreateSection().clickOnSave();

		// Status types

		objStatusTypeList1_page1.navigateToStatusTypeListNew();

		// number
		objStatusTypeList1_page1.createStatusTypeWithSection(
				objStatusTypesdata_page1.strNumberStatusType,
				objStatusTypesdata_page1.strNSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription,
				objViewdata_page1.strSectionName);

		strStatusTypeValues1[0] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strNSTStatusTypeName);

		// text
		objStatusTypeList1_page1.createStatusTypeWithSection(
				objStatusTypesdata_page1.strTextStatusType,
				objStatusTypesdata_page1.strTSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription,
				objViewdata_page1.strSectionName);

		strStatusTypeValues1[1] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strTSTStatusTypeName);

		// multi

		objStatusTypeList1_page1.createStatusTypeWithSection(
				objStatusTypesdata_page1.strMultiStatusType,
				objStatusTypesdata_page1.strMSTStatusTypeName,
				objStatusTypesdata_page1.strStatusDescription,
				objViewdata_page1.strSectionName)
				.createNewStatus(
						objStatusTypesdata_page1.strStatusNameInMulti,
				objStatusTypesdata_page1.strStatusColor)
			  .createNewStatus(objStatusTypesdata_page1.strStatusNameInMulti1,
					  objStatusTypesdata_page1.strStatusColor)
			  .verCreatedStatusInStatusListForMulti(
					  objStatusTypesdata_page1.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
					  objStatusTypesdata_page1.strStatusNameInMulti1)
			  .clickOnReturnToStatusTypeList();

		strStatusTypeValues1[2] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strMSTStatusTypeName);

		// date
		objStatusTypeList1_page1.createStatusTypeWithSection(
				objStatusTypesdata_page1.strDateStatusType,
				objStatusTypesdata_page1.strDateStatusTypeName1,
				objStatusTypesdata_page1.strStatusDescription,
				objViewdata_page1.strSectionName);

		strStatusTypeValues2[0] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strDateStatusTypeName1);

		// satauration score

		objStatusTypeList1_page1.createStatusTypeWithSection(
				objStatusTypesdata_page1.strSaturationScoreStatusType,
				objStatusTypesdata_page1.strSSTStatusTypeName1,
				objStatusTypesdata_page1.strStatusDescription,
				objViewdata_page1.strSectionName);

		strStatusTypeValues2[1] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strSSTStatusTypeName1);

		// NEDOCS calculation

		objStatusTypeList1_page1.createStatusTypeWithSection(
				objStatusTypesdata_page1.strNedocCalculationStatusType,
				objStatusTypesdata_page1.strNDSTStatusTypeName1,
				objStatusTypesdata_page1.strStatusDescription,
				objViewdata_page1.strSectionName);
		strStatusTypeValues2[2] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypesdata_page1.strNDSTStatusTypeName1);

		// resource Type

		objResourceType_page1.navigateToResourceTypePage().createResourceType(
				objResourceTypedata_page1.strResourceTypeName,
				strStatusTypeValues1);

		strResourceTypeValue[0] = objResourceType_page1
				.getResourceTypeValue(objResourceTypedata_page1.strResourceTypeName);

		// sub resource type

		objResourceType_page1.createSubResourceType(
				objResourceTypedata_page1.strSubResourceTypeName1,
				strStatusTypeValues2);

		strSubResourceTypeValue[0] = objResourceType_page1
				.getResourceTypeValue(objResourceTypedata_page1.strSubResourceTypeName1);

		// resource

		objResource_page1.navigateToResourceListPage();
		objResource_page1.createResourceWithAddress(
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

		// sub resource
		objResource_page1.createSubResourceWithAddress(
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
				  objStatusTypesdata_page1.strMSTStatusTypeName };
		  
		// views
		objviewsList_page1
				.navigateToViewsList()
//				.clickCreateNewViewButton()
//				.enterViewName(objViewdata_page1.strViewName)
//				.enterViewDesc(objViewdata_page1.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues1)
//				.selectResource(objResourcedata_page1.strResourceName)
//				.clickOnSaveOfCreateNewView()
				.createView(objViewdata_page1.strViewName,
						objViewdata_page1.strViewDesc,
						objResourcedata_page1.strResourceName,
						strStatusTypeNames)
				.clickOncustomizeResourceDetailView()
				.clickSubResourceButton()
				.clickOnSubResourceTypeName(
						objResourceTypedata_page1.strSubResourceTypeName1);

		objviewsList_page1
				.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0]);

		for (int i = 0; i < strStatusTypeValues2.length; i++) {

			objviewsList_page1
					.selectSubResourceCheckBox(strStatusTypeValues2[i]);

		}

		objviewsList_page1.clickOnSaveButton();

		// users

		objUsersList_page1
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata_page1.strNewUserName2,
						objUserdata_page1.strNewPassword,
						objUserdata_page1.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objResourcedata_page1.strResourceName)
				.clickSaveButton();

		login_page1.clickLogOut();

		// login new user

		login_page2.loginAsNewUser(objUserdata_page1.strNewUserName2,
				objUserdata_page1.strNewPassword);

		objRegionDefault_page2.selectFrame();

		objNavigationToSubmenus2
				.navigateToParticularViewUnderViewMenu(objViewdata_page1.strViewName);

		objViews_page2
				.verResource(objResourcedata_page1.strResourceName)
				.clickOnResource(objResourcedata_page1.strResourceName)
				.verResourceScreenDisplayed(
						objResourcedata_page1.strResourceName)

				.clickOnSubResources(objResourcedata_page1.strSubResourceName1)

				.verResourceScreenDisplayed(
						objResourcedata_page1.strSubResourceName1)
				.verTrafficBtnInMap().verMapAndSatelliteBtnInMap();

		login_page2.clickLogOut();

		gstrResult = "PASS";

	}
}
