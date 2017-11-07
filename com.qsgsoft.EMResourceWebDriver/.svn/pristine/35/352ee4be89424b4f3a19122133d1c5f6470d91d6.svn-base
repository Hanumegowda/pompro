package requirementGroup.SettingUpStatusTypes;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.LinksAtTopRightCorners;
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

public class CommonScenariosForStatusTypes extends TestNG_UI_EXTENSIONSThreeBrowser {
	
	public CommonScenariosForStatusTypes() throws Exception {
		super();
	}

	/*************************************************************************************
	 * 'Description 	: Verify that user can reactivate a status type which was displayed in the Other Region view.
	 * 'Precondition	: 
	 * 'Date 			: 24-Mar-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = " Verify that user can reactivate a status type which was displayed in the Other Region view.")
	public void testHappyDay69672() throws Exception {

		gstrTCID = "69672";
		gstrTO = " Verify that user can reactivate a status type which was displayed in the Other Region view.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Views objViews1 = new Views(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);

		Login objLogin2 = new Login(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		SelectRegion objSelectRegionpage2 = new SelectRegion(this.driver2);
		NavigationToSubMenus objNavigationToSubmenus2 = new NavigationToSubMenus(
				this.driver2);
		StatusTypeList objStatusTypeList2 = new StatusTypeList(this.driver2);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strStateWideReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createSharedStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				      objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
				      objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createSharedResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		System.out.println(objResource_data.strResourceName);
		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

		String[] strStatusTypeNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName};
		
		System.out.println(strStatusTypeNames);
		System.out.println(objResource_data.strResourceName);

		objViewsList.clickOnEditOfRegDefault();

//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.clickOnResourcesTab()
		.selectResource(objResource_data.strResourceName)
		.clickNextButton();

		for (int i = 0; i < strStatusTypeNames.length; i++) {
		objViewsList.selectStatusType(strStatusTypeNames[i]);
		}
		
		objViewsList.clickOnSaveOfCreateNewView();
		
		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strArkansasReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewOtherRegView(objLogindata.strStateWideOklahomaVal)
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strStateWideReg);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		for (int i = 0; i < (strStatusTypeNames.length-1); i++) {
			objStatusTypeList.clickOnEditOfStatusType(strStatusTypeNames[i])
					.deselectActiveCheckBox().clickOnSaveButton();
		}

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToRegUnderOtherRegions(objLogindata.strStateWideReg);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < (strStatusTypeNames.length-1); i++) {
			objViews1.verStatusTypesNotDisplayed(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objLogin2.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault2.selectFrame();

		objSelectRegionpage2
				.selectRegionAndNavigate(objLogindata.strStateWideReg);

		objRegionDefault2.selectFrame();

		objNavigationToSubmenus2.navigateToStatusTypesInSetup();
		
		objStatusTypeList2.selectInactiveStatusTypesCheckBox();
		
		for (int i = 0; i < (strStatusTypeNames.length-1); i++) {
			objStatusTypeList2.clickOnEditOfStatusType(strStatusTypeNames[i])
					.selectActiveCheckBox().clickOnSaveButton();
		}

		objLinksAtTopRightCorners1.clickOnRefresh();
		
		Thread.sleep(2000);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}
		
		objLogin1.clickLogOut();
		
		objLogin2.clickLogOut();
		
		gstrResult = "PASS";
	}
}
