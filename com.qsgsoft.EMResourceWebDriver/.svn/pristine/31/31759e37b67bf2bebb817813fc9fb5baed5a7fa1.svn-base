package requirementGroup.SettingUpResources;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewResourceSearch extends TestNG_UI_EXTENSIONS{

	public NewResourceSearch() throws Exception {
		super();
	}
	
	/***********************************************************************************************
	'Description : Verify that user with 'Override Viewing Restrictions' right on the parent resource 
	               can search for sub resources from the 'Find Resources' screen.
	'Precondition:
	'Date	 	 : 31-July-2015
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************/
	@Test(description = "Verify that user with 'Override Viewing Restrictions' right on the parent resource "
			+ "can search for sub resources from the 'Find Resources' screen.")
	public void testHappyDay107722() throws Exception {

		gstrTCID = "107722";
		gstrTO = "Verify that user with 'Override Viewing Restrictions' right on the parent resource can search "
				+ "for sub resources from the 'Find Resources' screen.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners = new LinksAtTopRightCorners(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[2];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Role based status types
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
								objStatusTypes_data.strStatusColor)
						.verCreatedStatusInStatusListForMulti(
								objStatusTypes_data.strStatusNameInMulti1)
						.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		// Create Private status type
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription).createNewStatus(
				objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		objStatusTypeList.createNewStatus(
							     objStatusTypes_data.strStatusNameInMulti,
							     objStatusTypes_data.strStatusColor)
					     .createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
					    		 	objStatusTypes_data.strStatusColor)
						 .verCreatedStatusInStatusListForMulti(
								objStatusTypes_data.strStatusNameInMulti1)
						 .clickOnReturnToStatusTypeList();

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);

		// Shared status type
		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		// Resource type creation
		String[] strStatusTypeValuesForRT = { strStatusTypeValues[0],
				strStatusTypeValues[1], strStatusTypeValues[2] };

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName,
				strStatusTypeValuesForRT);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		String strStatusTypesValuesForSRT[] = { strStatusTypeValues[3],
				strStatusTypeValues[4], strStatusTypeValues[5] };

		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName,
				strStatusTypesValuesForSRT);

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		// Create ReSource
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Create Sub-Resources
		Resource_Page.createSubResource(objResource_data.strSubResourceName,
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strSubResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strSubResourceValue[0] = Resource_Page
				.getSubResourceValue(objResource_data.strSubResourceName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		Resource_Page.createSubResource(objResource_data.strSubResourceName1,
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strSubResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strSubResourceValue[1] = Resource_Page
				.getSubResourceValue(objResource_data.strSubResourceName1);

		// Create user
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectOverrideViewingRestrictionOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("U1: " + objUser_data.strNewUserName);

		// Create user U2
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("U2: " + objUser_data.strNewUserName1);

		// Create user U3
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName2,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("U3: " + objUser_data.strNewUserName2);

		// Create user U4
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName3,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectAssociateWithOfResource(objResource_data.strResourceName)

				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName3,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("U4: " + objUser_data.strNewUserName3);

		// Create user U5
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName4,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName4,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("U5: " + objUser_data.strNewUserName4);
		
		objLogin.clickLogOut();
						
	//-----------------------Precondition ends-----------------------------------//		

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();

		String strResAndSubRes = objResource_data.strResourceName + ": "
				+ objResource_data.strSubResourceName;
		
		objLinksAtTopRightCorners.clickOnSearch();

		objCustomUnderView1.verifyFindResourcesPage()
				.verSearchButtonIsPresent().verCancelButtonIsPresent()
				.enterResNameInWhatField(objResource_data.strSubResourceName)
				.clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes);

		String strResAndSubRes1 = objResource_data.strResourceName + ": "
				+ objResource_data.strSubResourceName1;

		objCustomUnderView1.enterResNameInWhatField(
				objResource_data.strSubResourceName1).clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes1);
		
		objLogin1.clickLogOut();

		// U2
		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objLinksAtTopRightCorners.clickOnSearch();

		objCustomUnderView1.verifyFindResourcesPage()
				.verSearchButtonIsPresent().verCancelButtonIsPresent()
				.enterResNameInWhatField(objResource_data.strSubResourceName)
				.clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes);

		objCustomUnderView1.enterResNameInWhatField(
				objResource_data.strSubResourceName1).clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes1);
		
		objLogin1.clickLogOut();

		// U3
		objLogin1.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objLinksAtTopRightCorners.clickOnSearch();

		objCustomUnderView1.verifyFindResourcesPage()
				.verSearchButtonIsPresent().verCancelButtonIsPresent()
				.enterResNameInWhatField(objResource_data.strSubResourceName)
				.clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes);

		objCustomUnderView1.enterResNameInWhatField(
				objResource_data.strSubResourceName1).clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes1);
		
		objLogin1.clickLogOut();

		// U4
		objLogin1.loginAsNewUser(objUser_data.strNewUserName3,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objLinksAtTopRightCorners.clickOnSearch();
		
		objCustomUnderView1.verifyFindResourcesPage()
				.verSearchButtonIsPresent().verCancelButtonIsPresent()
				.enterResNameInWhatField(objResource_data.strSubResourceName)
				.clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes);

		objCustomUnderView1.enterResNameInWhatField(
				objResource_data.strSubResourceName1).clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes1);
		
		objLogin1.clickLogOut();

		// U5
		objLogin1.loginAsNewUser(objUser_data.strNewUserName4,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objLinksAtTopRightCorners.clickOnSearch();

		objCustomUnderView1.verifyFindResourcesPage()
				.verSearchButtonIsPresent().verCancelButtonIsPresent()
				.enterResNameInWhatField(objResource_data.strSubResourceName)
				.clickOnSearch().verErrorMessgaeForResource();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	'Description : Verify that user with any of the affiliated right on the parent resource can search 
	               for sub resources from the 'Find Resources' screen.
	'Precondition:
	'Date	 	 : 03-Aug-2015
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************/
	@Test(description = "Verify that user with any of the affiliated right on the parent resource can search for "
			+ "sub resources from the 'Find Resources' screen.")
	public void testHappyDay107724() throws Exception {

		gstrTCID = "107724";
		gstrTO = "Verify that user with any of the affiliated right on the parent resource can search for sub "
				+ "resources from the 'Find Resources' screen.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners = new LinksAtTopRightCorners(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[2];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Role based status types
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
							     objStatusTypes_data.strStatusNameInMulti1,
							     objStatusTypes_data.strStatusColor)
					     .verCreatedStatusInStatusListForMulti(
								objStatusTypes_data.strStatusNameInMulti1)
					     .clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		// Create Private status type
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription).createNewStatus(
				objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		objStatusTypeList.createNewStatus(
			     objStatusTypes_data.strStatusNameInMulti,
			     objStatusTypes_data.strStatusColor)
	     .verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti)
		.createNewStatus(
			     objStatusTypes_data.strStatusNameInMulti1,
			     objStatusTypes_data.strStatusColor)
	     .verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1)
	     .clickOnReturnToStatusTypeList();

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);

		// Shared status type
		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		// Resource type creation
		String[] strStatusTypeValuesForRT = { strStatusTypeValues[0],
				strStatusTypeValues[1], strStatusTypeValues[2] };

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName,
				strStatusTypeValuesForRT);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		String strStatusTypesValuesForSRT[] = { strStatusTypeValues[3],
				strStatusTypeValues[4], strStatusTypeValues[5] };

		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName,
				strStatusTypesValuesForSRT);

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		// Create ReSource
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Create Sub-Resources
		Resource_Page.createSubResource(objResource_data.strSubResourceName,
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strSubResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strSubResourceValue[0] = Resource_Page
				.getSubResourceValue(objResource_data.strSubResourceName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		Resource_Page.createSubResource(objResource_data.strSubResourceName1,
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strSubResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strSubResourceValue[1] = Resource_Page
				.getSubResourceValue(objResource_data.strSubResourceName1);

		// Create user U1
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("U2: " + objUser_data.strNewUserName1);

		// Create user U2
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName2,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("U3: " + objUser_data.strNewUserName2);

		// Create user U3
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName3,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectAssociateWithOfResource(objResource_data.strResourceName)

				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName3,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("U4: " + objUser_data.strNewUserName3);

		// Create user U4
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName4,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName4,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("U5: " + objUser_data.strNewUserName4);
		
		objLogin.clickLogOut();
						
	//-----------------------Precondition ends-----------------------------------//		

		// U1
		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		String strResAndSubRes = objResource_data.strResourceName + ": "
				+ objResource_data.strSubResourceName;
		
		objLinksAtTopRightCorners.clickOnSearch();

		objCustomUnderView1.verifyFindResourcesPage()
				.verSearchButtonIsPresent().verCancelButtonIsPresent()
				.enterResNameInWhatField(objResource_data.strSubResourceName)
				.clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes);
		
		String strResAndSubRes1 = objResource_data.strResourceName + ": "
				+ objResource_data.strSubResourceName1;

		objCustomUnderView1.enterResNameInWhatField(
				objResource_data.strSubResourceName1).clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes1);
		
		objLogin1.clickLogOut();

		// U2
		objLogin1.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objLinksAtTopRightCorners.clickOnSearch();

		objCustomUnderView1.verifyFindResourcesPage()
				.verSearchButtonIsPresent().verCancelButtonIsPresent()
				.enterResNameInWhatField(objResource_data.strSubResourceName)
				.clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes);

		objCustomUnderView1.enterResNameInWhatField(
				objResource_data.strSubResourceName1).clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes1);
		
		objLogin1.clickLogOut();

		// U3
		objLogin1.loginAsNewUser(objUser_data.strNewUserName3,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objLinksAtTopRightCorners.clickOnSearch();
		
		objCustomUnderView1.verifyFindResourcesPage()
				.verSearchButtonIsPresent().verCancelButtonIsPresent()
				.enterResNameInWhatField(objResource_data.strSubResourceName)
				.clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes);

		objCustomUnderView1.enterResNameInWhatField(
				objResource_data.strSubResourceName1).clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes1);
		
		objLogin1.clickLogOut();

		// U4
		objLogin1.loginAsNewUser(objUser_data.strNewUserName4,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();
		
		objLinksAtTopRightCorners.clickOnSearch();

		objCustomUnderView1.verifyFindResourcesPage()
				.verSearchButtonIsPresent().verCancelButtonIsPresent()
				.enterResNameInWhatField(objResource_data.strSubResourceName)
				.clickOnSearch().verErrorMessgaeForResource();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	'Description : Verify that user can search for sub resources providing multiple characters 
	               (parent resource along with sub resource) in the search criteria.
	'Precondition:
	'Date	 	 : 03-Aug-2015
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************/
	@Test(description = "Verify that user can search for sub resources providing multiple characters "
			+ "(parent resource along with sub resource) in the search criteria.")
	public void testHappyDay122243() throws Exception {

		gstrTCID = "122243";
		gstrTO = "Verify that user can search for sub resources providing multiple characters "
				+ "(parent resource along with sub resource) in the search criteria.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners = new LinksAtTopRightCorners(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[2];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Role based status types
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
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
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		// Create Private status type
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription).createNewStatus(
				objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
								objStatusTypes_data.strStatusColor)
						.verCreatedStatusInStatusListForMulti(
								objStatusTypes_data.strStatusNameInMulti)
						.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
										objStatusTypes_data.strStatusColor)
						.verCreatedStatusInStatusListForMulti(
								objStatusTypes_data.strStatusNameInMulti1)
						.clickOnReturnToStatusTypeList();

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);

		// Shared status type
		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		// Resource type creation
		String[] strStatusTypeValuesForRT = { strStatusTypeValues[0],
				strStatusTypeValues[1], strStatusTypeValues[2] };

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName,
				strStatusTypeValuesForRT);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		String strStatusTypesValuesForSRT[] = { strStatusTypeValues[3],
				strStatusTypeValues[4], strStatusTypeValues[5] };

		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName,
				strStatusTypesValuesForSRT);

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		// Create ReSource
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Create Sub-Resources
		Resource_Page.createSubResource(objResource_data.strSubResourceName,
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strSubResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strSubResourceValue[0] = Resource_Page
				.getSubResourceValue(objResource_data.strSubResourceName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		Resource_Page.createSubResource(objResource_data.strSubResourceName1,
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strSubResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strSubResourceValue[1] = Resource_Page
				.getSubResourceValue(objResource_data.strSubResourceName1);

		// Create user U1
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("U2: " + objUser_data.strNewUserName1);

		objLogin.clickLogOut();
						
	//-----------------------Precondition ends-----------------------------------//		

		// U1
		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objRegionDefault1.verifyRegionDefaultPage();

		String strResAndSubRes = objResource_data.strResourceName + ": "
				+ objResource_data.strSubResourceName;

		String strResAndSubRes1 = objResource_data.strResourceName + ": "
				+ objResource_data.strSubResourceName1;

		objLinksAtTopRightCorners.clickOnSearch();

		String strResourceAndSubResourceName = objResource_data.strResourceName
				+ " " + objResource_data.strSubResourceName;

		objCustomUnderView1.verifyFindResourcesPage()
				.verSearchButtonIsPresent().verCancelButtonIsPresent()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch();
		
		objStatusChangePreference1
		.verResourceDisplayedInFindResScreen(objResource_data.strResourceName);

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes);

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes1);

		objCustomUnderView1.enterResNameInWhatField(
				strResourceAndSubResourceName).clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes);

		String strResourceAndSubResourceName1 = objResource_data.strResourceName
				+ " " + objResource_data.strSubResourceName1;

		objCustomUnderView1.enterResNameInWhatField(
				strResourceAndSubResourceName1).clickOnSearch();

		objStatusChangePreference1
				.verResourceDisplayedInFindResScreen(strResAndSubRes1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}