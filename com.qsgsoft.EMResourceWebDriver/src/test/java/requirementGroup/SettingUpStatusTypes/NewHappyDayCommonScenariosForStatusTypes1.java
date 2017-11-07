package requirementGroup.SettingUpStatusTypes;

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
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSThreeBrowser;

public class NewHappyDayCommonScenariosForStatusTypes1   extends TestNG_UI_EXTENSIONSThreeBrowser {
	
	public NewHappyDayCommonScenariosForStatusTypes1() throws Exception {
		super();
	}
	

	/****************************************************************************************************************
	'Description : Verify that user can deactivate a status type displayed in the Other Region view.
	'Precondition:
	'Date	 	 : 10-Sep-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Verify that user can deactivate a status type displayed in the Other Region view.")
	public void testHappyDay69671() throws Exception {

		gstrTCID = "69671";
		gstrTO = "Verify that user can deactivate a status type displayed in the Other Region view.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		String strstatusTypeValues[] = new String[4];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Views objViews1 = new Views(this.driver1);
		
		Login objLogin2 = new Login(this.driver2);
		SelectRegion objSelectRegion2 = new SelectRegion(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		StatusTypeList objStatusTypeList2 = new StatusTypeList(this.driver2);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strStateWideReg);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createSharedStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

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
			      objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
		objResource.navigateToResourceListPage().createSharedResourceWithAddress(
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

		objNavigationToSubMenus.navigateToViews();
		
		objViewsList.clickOnEditLinkOfView(objView_data.strRegionDefaultName)
					.clickOnResourcesTab()
					.selectResource(objResource_data.strResourceName)
					.clickNextButton();
		
		String[] strStatusTypes = {objStatuTypes_data.strNSTStatusTypeName, objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,  objStatuTypes_data.strSSTStatusTypeName};
		
		for(int intCount = 0 ; intCount<strStatusTypes.length;intCount++){
			
		objViewsList.selectStatusType(strStatusTypes[intCount]);
		}
		objViewsList
				.clickOnSaveOfCreateNewView();
		
		objSelectRegion.selectRegionAndNavigate(objTest_data.strArkansasReg);

		objRegionDefault.selectFrame();

		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectViewOtherRegView(objTest_data.strStateWideOklahomaVal)
//				.selectadministerOtherRegionViewsOption()
				.clickSaveButton();
	
//		// User creation
//		objUsersList.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
//		.clickSearchButton();
//		objUsersList.editUserDetails(strUserName)
//		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();
		System.out.println(objUser_data.strNewUserName);
		System.out.println("-----Precondition ends and test execution starts-------");
		
		objLogin1 .loginAsNewUser(objUser_data.strNewUserName,
				 objUser_data.strNewPassword);
		
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
		.navigateToRegUnderOtherRegions(objTest_data.strStateWideReg);

		objRegionDefault1
		.verifyParticularRegPageIsDisplayed(objTest_data.strStateWideReg);
		
		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypes.length; i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypes[i]);
		}

		objLogin2.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion2.selectRegionAndNavigate(objTest_data.strStateWideReg);

		objRegionDefault2.selectFrame();

		objStatusTypeList2.navigateToStatusTypeList();

		objStatusTypeList2.clickOnEditOfStatusType(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList2.deselectActiveCheckBox();
		
		objStatusTypeList2.clickOnSaveButton();
		
		objStatusTypeList2.verifyStatusTypeIsNotListed(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList2.selectInactiveStatusTypesCheckBox();
		
		objStatusTypeList2.verifyStatusTypeInList(objStatuTypes_data.strSSTStatusTypeName);
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		
		Thread.sleep(5000);
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		
		for (int i = 0; i < (strStatusTypes.length-1); i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypes[i]);
		}
		objViews1.verStatusTypesNotDisplayed(objResourceType_data.strResourceTypeName,
				objStatuTypes_data.strSSTStatusTypeName);/* EMS-4707- Deactivated status type is retained on ‘Other Region’ view screen on refresh.*/
		
		objStatusTypeList2.clickOnEditOfStatusType(objStatuTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList2.deselectActiveCheckBox();
		
		objStatusTypeList2.clickOnSaveButton();
		
		objStatusTypeList2.verifyStatusTypeIsNotListed(objStatuTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList2.selectInactiveStatusTypesCheckBox();
		
		objStatusTypeList2.verifyStatusTypeInList(objStatuTypes_data.strTSTStatusTypeName);
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		
		for (int i = 0; i < (strStatusTypes.length-2); i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypes[i]);
		}
		objViews1.verStatusTypesNotDisplayed(objResourceType_data.strResourceTypeName,
				objStatuTypes_data.strTSTStatusTypeName);/* EMS-4707- Deactivated status type is retained on ‘Other Region’ view screen on refresh.*/
		

		objStatusTypeList2.clickOnEditOfStatusType(objStatuTypes_data.strMSTStatusTypeName);
		
		objStatusTypeList2.deselectActiveCheckBox();
		
		objStatusTypeList2.clickOnSaveButton();
		
		objStatusTypeList2.verifyStatusTypeIsNotListed(objStatuTypes_data.strMSTStatusTypeName);
		
		objStatusTypeList2.selectInactiveStatusTypesCheckBox();
		
		objStatusTypeList2.verifyStatusTypeInList(objStatuTypes_data.strMSTStatusTypeName);
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		
		for (int i = 0; i < (strStatusTypes.length-3); i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypes[i]);
		}
		objViews1.verStatusTypesNotDisplayed(objResourceType_data.strResourceTypeName,
				objStatuTypes_data.strMSTStatusTypeName);/* EMS-4707- Deactivated status type is retained on ‘Other Region’ view screen on refresh.*/

		objStatusTypeList2.clickOnEditOfStatusType(objStatuTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList2.deselectActiveCheckBox();
		
		objStatusTypeList2.clickOnSaveButton();
		
		objStatusTypeList2.verifyStatusTypeIsNotListed(objStatuTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList2.selectInactiveStatusTypesCheckBox();
		
		objStatusTypeList2.verifyStatusTypeInList(objStatuTypes_data.strNSTStatusTypeName);
		
		objLinksAtTopRightCorners1.clickOnRefresh();
	
		objViews1.verStatusTypesNotDisplayed(objResourceType_data.strResourceTypeName,
				objStatuTypes_data.strNSTStatusTypeName);/* EMS-4707- Deactivated status type is retained on ‘Other Region’ view screen on refresh.*/
		
		objViews1.verResourceTypeAndResourceNameNotInView(objResourceType_data.strResourceTypeName, objResource_data.strResourceName);
		
		objLogin1.clickLogOut();

		objLogin2.clickLogOut();
		
		gstrResult = "PASS";
	}
}
