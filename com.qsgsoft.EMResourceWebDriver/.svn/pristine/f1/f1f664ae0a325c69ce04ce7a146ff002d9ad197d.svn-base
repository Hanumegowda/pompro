package requirementGroup.SettingUpResourceTypes;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
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

public class ChangeResourceTypeOfAResource extends TestNG_UI_EXTENSIONSThreeBrowser {

	public ChangeResourceTypeOfAResource() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that the resource type of a resource can be changed. 
	'Precondition:
	'Date	 	 : 11-Jan-2016
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that the resource type of a resource can be changed. ")
	public void testHappyDay69692() throws Exception {

		gstrTCID = "69692";
		gstrTO = "Verify that the resource type of a resource can be changed. ";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		
		Login objLogin2 = new Login(this.driver2);
		SelectRegion objSelectRegionpage2 = new SelectRegion(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		Resource objResource2 = new Resource(this.driver2);
		

		
		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[2];
		String strStatusesValues[] = new String[1];
		String strResourceTypeValue[] = new String[2];
		String strStatusTypeValues1[] = new String[1];
		
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToStatusTypesInSetup();


		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strGreenColor);
		
		strStatusesValues[0] = objStatusTypeList.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();
	
		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource type creation
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1, strStatusTypeValues1);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);
		
		// create resource with address
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

		
		// create resource with address
		objResource.createResourceWithAddress(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);
		
		objnNavigationToSubMenus.navigateToViews();

		String[] strStatusTypeNames = {
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName };
		
		String strResource[] = {objResource_data.strResourceName, objResource_data.strResourceName1};
		
		objViewsList.createViewForMultipleResourcesAndStatusTypes(objView_data.strViewName, objView_data.strViewDesc, 
									strResource, strStatusTypeNames);
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//		
//
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//					.selectResource(objResource_data.strResourceName1)
//				.clickOnSaveOfCreateNewView();
		
		
		objnNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1);
		Thread.sleep(3000);
		objUsersList.clickSaveButton();
		
		objLogin.clickLogOut();
		
		
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(5000);

		objnNavigationToSubMenus1.clickOnViewMenu();

		Thread.sleep(2000);
		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		Thread.sleep(2000);
		
		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0], objStatusTypes_data.strNSTStatusTypeName);

		objViewsList1.verResAndStatusTypes(strResourceTypeValue[0], objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName);
		
		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[1], objStatusTypes_data.strMSTStatusTypeName);
		
		objViewsList1.verResAndStatusTypes(strResourceTypeValue[1], objResource_data.strResourceName1, objStatusTypes_data.strMSTStatusTypeName);
		
		objLogin2.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage2
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault2.selectFrame();
		
		objResource2.navigateToResourceListPageNew();
		
		objResource2.verResourceListPageIsDisplayed();
		
		objResource2.clickOnEditLinkInResourcePage(objResource_data.strResourceName);
		
		objResource2.selectResourceTypename(objResourceType_data.strResourceTypeName1);
		
		objResource2.clickOnSaveButton();
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		
		Thread.sleep(5000);
		
		objLinksAtTopRightCorners1.clickOnRefresh();

		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[1], objStatusTypes_data.strMSTStatusTypeName);

		objViewsList1.verResAndStatusTypes(strResourceTypeValue[1], objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
		objViewsList1.verResAndStatusTypes(strResourceTypeValue[1], objResource_data.strResourceName1, objStatusTypes_data.strMSTStatusTypeName);
		
		objLogin1.clickLogOut();
		
		objLogin2.clickLogOut();
		
		gstrResult = "PASS";
	}

}
