package requirementGroup.SettingUpStatusTypes;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.Map;
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

public class NewAssociatingSectionToAStatusType extends TestNG_UI_EXTENSIONS {

	public NewAssociatingSectionToAStatusType()
			throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/******************************************************************
	'Description : Verify that section can be selected while creating a status type 
	'Precondition:
	'Date	 	 : 09-Oct-2015
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that section can be selected while creating a status type ")
	public void testHappyDay124083() throws Exception {

		gstrTCID = "124083";
		gstrTO = "Verify that section can be selected while creating a status type ";

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

		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		Views objViews1 = new Views(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName)
				.createNewStatus(
				     objStatuTypes_data.strStatusNameInMulti,
				     objStatuTypes_data.strStatusColor)
				  .createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				      objStatuTypes_data.strStatusColor)
				  .verCreatedStatusInStatusListForMulti(
				      objStatuTypes_data.strStatusNameInMulti)
				  .verCreatedStatusInStatusListForMulti(
				      objStatuTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickOnViewInfoInPopupWindow();

		String[] strAllStatusTypes = { objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName };

		for (int i = 0; i <strAllStatusTypes.length; i++) {
			objViews1.verStatusTypesUnderSection(strAllStatusTypes[i],
					objView_data.strSectionName);
		}

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Verify that section can be selected while editing a status type 
	'Precondition:
	'Date	 	 : 12-Oct-2015
	'Author		 : Renushree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that section can be selected while editing a status type ")
	public void testHappyDay124084() throws Exception {

		gstrTCID = "124084";
		gstrTO = "Verify that section can be selected while editing a status type ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		String strstatusTypeValues[] = new String[6];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();
		
		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();
		
		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.verStatusTypeAndSectionValInList(
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strUncategorizedValInSection);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.verStatusTypeAndSectionValInList(
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strUncategorizedValInSection);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

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

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.verStatusTypeAndSectionValInList(
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strUncategorizedValInSection);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.verStatusTypeAndSectionValInList(
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strUncategorizedValInSection);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.verStatusTypeAndSectionValInList(
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strUncategorizedValInSection);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		objStatusTypeList.verStatusTypeAndSectionValInList(
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strUncategorizedValInSection);

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList
				.clickOnEditOfStatusType(
						objStatuTypes_data.strNSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName)
				.clickOnSaveButton();

		objStatusTypeList.verStatusTypeAndSectionValInList(
				objStatuTypes_data.strNSTStatusTypeName,
				objView_data.strSectionName);

		objStatusTypeList
				.clickOnEditOfStatusType(
						objStatuTypes_data.strTSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName)
				.clickOnSaveButton();

		objStatusTypeList.verStatusTypeAndSectionValInList(
				objStatuTypes_data.strTSTStatusTypeName,
				objView_data.strSectionName);

		objStatusTypeList
				.clickOnEditOfStatusType(
						objStatuTypes_data.strMSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName)
				.clickOnSaveButton();

		objStatusTypeList.verStatusTypeAndSectionValInList(
				objStatuTypes_data.strMSTStatusTypeName,
				objView_data.strSectionName);

		objStatusTypeList
				.clickOnEditOfStatusType(
						objStatuTypes_data.strSSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName)
				.clickOnSaveButton();

		objStatusTypeList.verStatusTypeAndSectionValInList(
				objStatuTypes_data.strSSTStatusTypeName,
				objView_data.strSectionName);

		objStatusTypeList
				.clickOnEditOfStatusType(
						objStatuTypes_data.strNDSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName)
				.clickOnSaveButton();

		objStatusTypeList.verStatusTypeAndSectionValInList(
				objStatuTypes_data.strNDSTStatusTypeName,
				objView_data.strSectionName);

		objStatusTypeList
				.clickOnEditOfStatusType(
						objStatuTypes_data.strDateStatusTypeName)
				.selectSectionName(objView_data.strSectionName)
				.clickOnSaveButton();

		objStatusTypeList.verStatusTypeAndSectionValInList(
				objStatuTypes_data.strDateStatusTypeName,
				objView_data.strSectionName);

		objLogin.clickLogOut();
		
		gstrResult = "PASS";
	}
}
