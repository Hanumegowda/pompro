package requirementGroup.MultiRegion;

import lib.dataObject.Login_data;
import lib.dataObject.NotificationValues;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewMultiRegionUserWithLoginAccessToMultipleRegions extends TestNG_UI_EXTENSIONS{

	public NewMultiRegionUserWithLoginAccessToMultipleRegions()
			throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/***************************************************************************************************************
	 * 'Description :User U1 has login access to regions A & B and has status change preferences set for a resource.
	 *               After removing the user's role in region A, verify that user CANNOT view/edit status change
	 *                preferences for those status types from region B.
	 * 'Date        :15-Jun-2015
	 * 'Author      :Anitha
	 ***************************************************************************************************************/

	@Test(description = "User U1 has login access to regions A & B and has status change preferences set for a resource."
			+ " After removing the user's role in region A, verify that user CANNOT view/edit status change "
			+ "preferences for those status types from region B.")
	public void testHappyDay43656() throws Exception {
		gstrTCID = "43656";
		gstrTO = "User U1 has login access to regions A & B and has status change preferences set for a resource."
				+ " After removing the user's role in region A, verify that user CANNOT view/edit status change "
				+ "preferences for those status types from region B.";
	
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		NotificationValues objNotificationValues = new NotificationValues();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[12];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[3];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		System.out.println(strRegionValue[1]);
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		//Shared Status Types
		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
			      objStatusTypes_data.strStatusColor);

		objStatusTypeList.clickOnReturnToStatusTypeList();

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
		
		//Role-Based Status Types
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[6] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[7] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);
		
		//Private Status Types
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[8] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2, objStatusTypes_data.strStatusColor);

		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti3, objStatusTypes_data.strStatusColor);

		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[9] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);
		
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[10] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[11] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName2);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
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
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		//User
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						"", "", "", "", "", objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();
		
		objUsersList.navigateToUsers()
		            .searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				    .editUserDetails(objUserdata.strNewUserName)
				    .clickAdvancedOptionAndExpand()
				    .selectEditStatusChangeNotPrefernceOption()
				    .clickSaveButton();
	
		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objSelectRegionpage.selectRegion(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateStatusChangeInPreferences();

		objStatusChangePreference
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.expandUncategorizedSec()
				
				//3-MST
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1],strStatusesValues[0])	
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[5],strStatusesValues[1])	
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[9],strStatusesValues[2])	

				//3-NST
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[0])	
						
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[4],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[4],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[4])
						
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[8],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[8],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[8])

				//3-SST
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[3],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[3],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[3])
				
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[7],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[7],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[7])
				
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[11],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[11],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[11])
							
				//3-TST
				.selEmailPagerWebChkBoxes(
						strResourceValue[0], strStatusTypeValues[2])
				.selEmailPagerWebChkBoxes(
						strResourceValue[0], strStatusTypeValues[6])
				.selEmailPagerWebChkBoxes(strResourceValue[0],
						strStatusTypeValues[10]).clickOnSave();

		objLogin.clickLogOut();

		System.out.println("----------------Precodition execution ends---------");

		System.out.println("-----------------Test execution starts---------------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.deselectRoleCheckBox(strRoleValue).clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strNSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strTSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strSSTStatusTypeName,
						objResource_data.strResourceName)

				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strNSTStatusTypeName1,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strTSTStatusTypeName1,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strSSTStatusTypeName1,
						objResource_data.strResourceName)

				.verStatusTypeNotification(
						objStatusTypes_data.strMSTStatusTypeName2)
				.verStatusTypeNotification(
						objStatusTypes_data.strNSTStatusTypeName2)
				.verStatusTypeNotificationBelow(
						objStatusTypes_data.strNSTStatusTypeName2)
				.verStatusTypeNotification(
						objStatusTypes_data.strSSTStatusTypeName2)
				.verStatusTypeNotificationBelow(
						objStatusTypes_data.strSSTStatusTypeName2)
				.verStatusTypeNotification(
						objStatusTypes_data.strTSTStatusTypeName2);

		objStatusChangePreference1
				.clickOnEditInMyStatusChangePreferences(
						objResource_data.strResourceName)
				.expandUncategorizedSec()
				.verNotificationChkBoxSelectedForMST(strResourceValue[0],
						strStatusTypeValues[9],strStatusesValues[2])

				.verNotificationChkBoxSelectedForOtherAbove(
						strResourceValue[0], strStatusTypeValues[8])
				.verNotificationChkBoxSelectedForOtherBelow(
						strResourceValue[0], strStatusTypeValues[8])

				.verNotificationChkBoxSelectedForOtherAbove(
						strResourceValue[0], strStatusTypeValues[11])
				.verNotificationChkBoxSelectedForOtherBelow(
						strResourceValue[0], strStatusTypeValues[11])

				.verNotificationChkBoxSelectedForTST(strResourceValue[0],
						strStatusTypeValues[10])

				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strNSTStatusTypeName)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strMSTStatusTypeName)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strTSTStatusTypeName)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strSSTStatusTypeName)

				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strNSTStatusTypeName1)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strMSTStatusTypeName1)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strTSTStatusTypeName1)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strSSTStatusTypeName1)
				.clickOnCancelNew();
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/****************************************************************************************************************
	'Description : User U1 has login access to regions A & B and has added resource and associated status types to 
				   custom view. After removing the user's role in region A, verify that user CANNOT view/add status
				    types on/to custom view from region B.
	'Precondition:
	'Date	 	 : 21-Jul-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "User U1 has login access to regions A & B and has added resource and associated status types "
			+ "to custom view. After removing the user's role in region A, verify that user CANNOT view/add status "
			+ "types on/to custom view from region B.")
	public void testHappyDay42183() throws Exception {

		gstrTCID = "42183";
		gstrTO = "User U1 has login access to regions A & B and has added resource and associated status types to "
				+ "custom view. After removing the user's role in region A, verify that user CANNOT view/add status "
				+ "types on/to custom view from region B.";
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();
		Regions objRegions_page = new Regions(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		Views objViews1 = new Views(this.driver1);
		Map objMap1 = new Map(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strPrivateStatusTypeValues[] = new String[6];
		String strSharedStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault.selectFrame();
		
		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		System.out.println(strRegionValue[0]);
		System.out.println(strRegionValue[1]);
		System.out.println("Section Name: "+objView_data.strSectionName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName1);
		System.out.println("RS:"+objResource_data.strResourceName);
		System.out.println("RT:"+objResourceType_data.strResourceTypeName);
		System.out.println(objStatusTypes_data.strNumberStatusType);
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayUpdatesec()
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[0])
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);
		
		objRegionDefault.switchToDefaultFrame().selectFrame();
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.clickOnSaveBtn();

		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);
		
		objUsersList
				.navigateToUsersNew()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.selectRoleCheckBox(strRoleValue[1])
				.clickSaveButton();
		
		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		//Role based status types
		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
		System.out.println("role" + objStatusTypes_data.strNSTStatusTypeName1);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
		objStatusTypeList.createNewStatus(
			     objStatusTypes_data.strStatusNameInMulti,
			     objStatusTypes_data.strStatusColor)

			  .createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
			      objStatusTypes_data.strStatusColor)

			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti1)

			.clickOnReturnToStatusTypeList();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);
		
		//private status types
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strPNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
		System.out.println("private"+objStatusTypes_data.strPNSTStatusTypeName);

		strPrivateStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strPNSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strpTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpTSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strpMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.createNewStatus(
			     objStatusTypes_data.strStatusNameInMulti,
			     objStatusTypes_data.strStatusColor)

			  .createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
			      objStatusTypes_data.strStatusColor)

			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti1)

			.clickOnReturnToStatusTypeList();

		strPrivateStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpMSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strpSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpSSTStatusTypeName);
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strpNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpNDSTStatusTypeName);
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strpDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpDateStatusTypeName);
		
		//Shared status types
		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strsNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strSharedStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsNSTStatusTypeName1);
		
		

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strsTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strSharedStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsTSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strsMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.createNewStatus(
			     objStatusTypes_data.strStatusNameInMulti,
			     objStatusTypes_data.strStatusColor)

			  .createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
			      objStatusTypes_data.strStatusColor)

			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti1)

			.clickOnReturnToStatusTypeList();
		
		strSharedStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsMSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strsSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strSharedStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsSSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strsNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
		strSharedStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsNDSTStatusTypeName1);
		
		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
		strSharedStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName2);
		
		String[] strAllSTValues = ArrayUtils.addAll(
				strSharedStatusTypeValues, strPrivateStatusTypeValues);
		
		String[] strAllStatusTypeValues = ArrayUtils.addAll(strAllSTValues, strStatusTypeValues);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage()
					   .createResourceType(objResourceType_data.strResourceTypeName,
							   	strAllStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		System.out.println(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()
				   .createResourceWithAddress(
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
		System.out.println(objResource_data.strResourceName);
		
//		objSelectRegionpage
//			.selectRegionAndNavigate(objLogindata.strRegionName1);
//
//		objRegionDefault.switchToDefaultFrame().selectFrame();
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList.searchUserName(objUserdata.strNewUserName,
							objUserdata.strRole, objUserdata.strResourceType,
							objUserdata.strUsername, objUserdata.strsearchOption)
					.editUserDetails(objUserdata.strNewUserName)
					.selectViewResourceRights(
						objResource_data.strResourceName)
					.selectUpdateStatusOfResource(
							objResource_data.strResourceName)
					.clickSaveButton();
		
		objLogin.clickLogOut()
				.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objSelectRegionpage.selectRegion(objLogindata.strRegionName2)
						   .clickNextButton();
		
		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(
						objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue)
				.clickOnAddToCustomView()
				.clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strAllStatusTypeValues)
				.clickOnSave();

		objLogin.clickLogOut();
		
		System.out.println("-------Precondition Ends-------");
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName1);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1.searchUserName(objUserdata.strNewUserName,
							objUserdata.strRole, objUserdata.strResourceType,
							objUserdata.strUsername, objUserdata.strsearchOption)
					.editUserDetails(objUserdata.strNewUserName)
					.deselectRoleCheckBox(strRoleValue[1])
					.clickSaveButton();
		
		objLogin1.clickLogOut()
				 .loginToApplication(objUserdata.strNewUserName, 
						 objUserdata.strNewPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName2);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToCustomInView();
		
		String strPrivateStatusTypeNames[] = {objStatusTypes_data.strPNSTStatusTypeName,
				objStatusTypes_data.strpTSTStatusTypeName,
				objStatusTypes_data.strpMSTStatusTypeName,
				objStatusTypes_data.strpSSTStatusTypeName,
				objStatusTypes_data.strpNDSTStatusTypeName,
				objStatusTypes_data.strpDateStatusTypeName };

		String strSharedAndRoleSTNames[] = {objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strsNSTStatusTypeName1,
				objStatusTypes_data.strsTSTStatusTypeName1,
				objStatusTypes_data.strsMSTStatusTypeName1,
				objStatusTypes_data.strsSSTStatusTypeName1,
				objStatusTypes_data.strsNDSTStatusTypeName1,
				objStatusTypes_data.strDateStatusTypeName2 };
		
		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
//		EMS-7543 - User having login access to multiple regions (regions do not have mutual aid agreement) is unable to view role based and private status types of region ‘RG1’ from ‘RG2’ on ‘Custom View’ screen. 
		for (int j = 0; j < strPrivateStatusTypeValues.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strPrivateStatusTypeNames[j]);
		}

		System.out.println("Please wait, negative validation takes time: (20 seconds * 12 ST not present)");
		
		for (int i = 0; i < strSharedAndRoleSTNames.length; i++) {
			System.out.println(i);
			objCustomUnderView1.verStatusTypeNotInCustomViewTablePage(strSharedAndRoleSTNames[i]);
		}		
		
		objViews1.clickOnCustomizeLink();
		
		objCustomUnderView1.verEditCustomViewScreenIsDisplayed()		
						   .clickOnOptions()
						   .verEditCustomViewOptionsColumnIsDisplayed()
						   .verSTNotDisplayedInOptions(strSharedStatusTypeValues)
						   .verSTNotDisplayedInOptions(strStatusTypeValues)
						   .verSTDisplayedAndCheckedInOptions(strPrivateStatusTypeValues)
						   .clickOnCancel()
						   .clickOnCustomeViewMap()
						   .selectResourceName(objResource_data.strResourceName);
		
		objMap1.verStatusTypesInPopupWindow(strPrivateStatusTypeNames)
			   .verStatusTypesNotInPopupWindow(strSharedAndRoleSTNames);
		
		gstrResult = "PASS";
	}

	/****************************************************************************************************************
	'Description : For a user U1 who has login access to regions A & B, deselect status types in the ‘Refine’ 
				   window from region A and save. Verify that user cannot view/add those status types on/to 
				   custom view from region B.
	'Precondition:
	'Date	 	 : 22-Jul-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "For a user U1 who has login access to regions A & B, deselect status types in the ‘Refine’"
			+ " window from region A and save. Verify that user cannot view/add those status types on/to custom "
			+ "view from region B.")
	public void testHappyDay46510() throws Exception {

		gstrTCID = "46510";
		gstrTO = "For a user U1 who has login access to regions A & B, deselect status types in the ‘Refine’ "
				+ "window from region A and save. Verify that user cannot view/add those status types on/to "
				+ "custom view from region B.";
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();
		Regions objRegions_page = new Regions(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		Views objViews1 = new Views(this.driver1);
		Map objMap1 = new Map(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strPrivateStatusTypeValues[] = new String[6];
		String strSharedStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		System.out.println(strRegionValue[0]);
		System.out.println(strRegionValue[1]);
		System.out.println("Section Name: "+objView_data.strSectionName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objRolesData.strRoleName);
		System.out.println("RS:"+objResource_data.strResourceName);
		System.out.println("RT:"+objResourceType_data.strResourceTypeName);
		System.out.println(objStatusTypes_data.strNumberStatusType);
		
		objRegionDefault.selectFrame();
		
		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayUpdatesec()
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[0])
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);
		
		objRegionDefault.switchToDefaultFrame().selectFrame();
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.clickOnSaveBtn();

		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);
		
		objUsersList
				.navigateToUsersNew()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.selectRoleCheckBox(strRoleValue[1])
				.clickSaveButton();
		
		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		//Role based status types
		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);
		
		System.out.println(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
				
		objStatusTypeList
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)

				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)

				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);
		
		//private status types
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strPNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strPNSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strpTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpTSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strpMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
	
		objStatusTypeList
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)

				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)

				.clickOnReturnToStatusTypeList();

		strPrivateStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpMSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strpSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpSSTStatusTypeName);
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strpNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpNDSTStatusTypeName);
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strpDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpDateStatusTypeName);
		
		//Shared status types
		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strsNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strSharedStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsNSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strsTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strSharedStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsTSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strsMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		

		objStatusTypeList.createNewStatus(
			     objStatusTypes_data.strStatusNameInMulti,
			     objStatusTypes_data.strStatusColor)

			  .createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
			      objStatusTypes_data.strStatusColor)

			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti1)

			.clickOnReturnToStatusTypeList();
		
		strSharedStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsMSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strsSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strSharedStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsSSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strsNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
		strSharedStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsNDSTStatusTypeName1);
		
		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
		strSharedStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName2);
		
		String[] strAllSTValues = ArrayUtils.addAll(
				strSharedStatusTypeValues, strPrivateStatusTypeValues);
		
		String[] strAllStatusTypeValues = ArrayUtils.addAll(strAllSTValues, strStatusTypeValues);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage()
					   .createResourceType(objResourceType_data.strResourceTypeName,
							   	strAllStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()
				   .createResourceWithAddress(
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
		
		System.out.println(objResource_data.strResourceName);
		
//		objSelectRegionpage
//			.selectRegionAndNavigate(objLogindata.strRegionName1);
//
//		objRegionDefault.switchToDefaultFrame().selectFrame();
		
		objNavigationToSubmenus.navigateToUsers();
		
		System.out.println(objUserdata.strNewUserName);
		
		objUsersList.searchUserName(objUserdata.strNewUserName,
							objUserdata.strRole, objUserdata.strResourceType,
							objUserdata.strUsername, objUserdata.strsearchOption)
					.editUserDetails(objUserdata.strNewUserName)
					.selectViewResourceRights(
						objResource_data.strResourceName)
					.selectUpdateStatusOfResource(
							objResource_data.strResourceName)
					.clickSaveButton();
		
		objLogin.clickLogOut()
				.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objSelectRegionpage.selectRegion(objLogindata.strRegionName2)
						   .clickNextButton();
		
		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(
						objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue)
				.clickOnAddToCustomView()
				.clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strAllStatusTypeValues)
				.clickOnSave();

		objLogin.clickLogOut();
		
		System.out.println("-------Precondition Ends-------");
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName1);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				     .editUserDetails(objUserdata.strNewUserName)
				     .clickRefineLinkOfViewResource(objResource_data.strResourceName);
				
		objRegionDefault1.verWebNotificationframe();
		
		objUsersList1.deselectStatusTypesInRefine(strStatusTypeValues)
				     .deselectStatusTypesInRefine(strSharedStatusTypeValues)
				     .clickSaveChangesButtonInRefine();
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		
		objUsersList1.clickSaveButton();
		
		objLogin1.clickLogOut()
				 .loginToApplication(objUserdata.strNewUserName, 
						 objUserdata.strNewPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName2);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToCustomInView();
		
		String strPrivateStatusTypeNames[] = {objStatusTypes_data.strPNSTStatusTypeName,
				objStatusTypes_data.strpTSTStatusTypeName,
				objStatusTypes_data.strpMSTStatusTypeName,
				objStatusTypes_data.strpSSTStatusTypeName,
				objStatusTypes_data.strpNDSTStatusTypeName,
				objStatusTypes_data.strpDateStatusTypeName };

		String strSharedAndRoleSTNames[] = {objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strsNSTStatusTypeName1,
				objStatusTypes_data.strsTSTStatusTypeName1,
				objStatusTypes_data.strsMSTStatusTypeName1,
				objStatusTypes_data.strsSSTStatusTypeName1,
				objStatusTypes_data.strsNDSTStatusTypeName1,
				objStatusTypes_data.strDateStatusTypeName2 };
		
		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		for (int j = 0; j < strPrivateStatusTypeValues.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strPrivateStatusTypeNames[j]);
		}

		System.out.println("Please wait, negative validation takes time: (20 seconds * 12 ST not present)");
		
		for (int i = 0; i < strSharedAndRoleSTNames.length; i++) {
			System.out.println(i);
			objCustomUnderView1.verStatusTypeNotInCustomViewTablePage(strSharedAndRoleSTNames[i]);
		}		
		
		objViews1.clickOnCustomizeLink();
		
		objCustomUnderView1.verEditCustomViewScreenIsDisplayed()		
						   .clickOnOptions()
						   .verEditCustomViewOptionsColumnIsDisplayed()
						   .verSTNotDisplayedInOptions(strSharedStatusTypeValues)
						   .verSTNotDisplayedInOptions(strStatusTypeValues)
						   .verSTDisplayedAndCheckedInOptions(strPrivateStatusTypeValues)
						   .clickOnCancel()
						   .clickOnCustomeViewMap()
						   .selectResourceName(objResource_data.strResourceName);
		
		objMap1.verStatusTypesInPopupWindow(strPrivateStatusTypeNames)
			   .verStatusTypesNotInPopupWindow(strSharedAndRoleSTNames);
		
		gstrResult = "PASS";
	}

	/***************************************************************************************************************
	 * 'Description :User U1 has login access to regions A & B. Verify that user CANNOT view/edit status change
	 *               preferences for private status types of region A from region B when affiliated resource rights
	 *                for the resource are removed in region A.
	 * 'Date        :15-Jun-2015
	 * 'Author      :Anitha
	 ***************************************************************************************************************/

	@Test(description = "User U1 has login access to regions A & B. Verify that user CANNOT view/edit status change "
			+ "preferences for private status types of region A from region B when affiliated resource rights "
			+ "for the resource are removed in region A.")
	public void testHappyDay50625() throws Exception {
		gstrTCID = "50625";
		gstrTO = "User U1 has login access to regions A & B. Verify that user CANNOT view/edit status "
				+ "change preferences for private status types of region A from region B when affiliated"
				+ " resource rights for the resource are removed in region A.";
	
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		NotificationValues objNotificationValues = new NotificationValues();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[8];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[2];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		System.out.println(strRegionValue[1]);
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		//Role-Based Status Types
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);
		
		//Private Status Types
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2, objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1, objStatusTypes_data.strStatusColor);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);
		
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[6] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[7] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName2);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
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
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		//User
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						"", "", "", "", "", objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();
		
		objUsersList.navigateToUsers()
		            .searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				    .editUserDetails(objUserdata.strNewUserName)
				    .clickAdvancedOptionAndExpand()
				    .selectEditStatusChangeNotPrefernceOption()
				    .clickSaveButton();
	
		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objSelectRegionpage.selectRegion(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateStatusChangeInPreferences();

		objStatusChangePreference
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.expandUncategorizedSec()
				
				//3-MST
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1],strStatusesValues[0])	
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[5],strStatusesValues[1])	

				//3-NST
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[0])	
						
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[4],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[4],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[4])

				//3-SST
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[3],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[3],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[3])
				
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[7],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[7],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[7])
							
				//3-TST
				.selEmailPagerWebChkBoxes(strResourceValue[0],
						strStatusTypeValues[2])
				.selEmailPagerWebChkBoxes(strResourceValue[0],
						strStatusTypeValues[6]).clickOnSave();

		objLogin.clickLogOut();

		System.out.println("----------------Precodition execution ends---------");

		System.out.println("-----------------Test execution starts---------------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.deselectUpdateStatusOfResource(objResource_data.strResourceName)
				.deselectRunReportRight(objResource_data.strResourceName)
				.deselectAssociatedRightCheckBox(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
                .verStatusTypeNotification(
						objStatusTypes_data.strMSTStatusTypeName1)
				.verStatusTypeNotification(
						objStatusTypes_data.strNSTStatusTypeName1)
				.verStatusTypeNotificationBelow(
						objStatusTypes_data.strNSTStatusTypeName1)
				.verStatusTypeNotification(
						objStatusTypes_data.strSSTStatusTypeName1)
				.verStatusTypeNotificationBelow(
						objStatusTypes_data.strSSTStatusTypeName1)
				.verStatusTypeNotification(
						objStatusTypes_data.strTSTStatusTypeName1);

		objStatusChangePreference1
				.clickOnEditInMyStatusChangePreferences(
						objResource_data.strResourceName)
				.expandUncategorizedSec()
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strNSTStatusTypeName1)
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strMSTStatusTypeName1)
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strTSTStatusTypeName1)
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strSSTStatusTypeName1)

				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strNSTStatusTypeName2)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strMSTStatusTypeName2)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strTSTStatusTypeName2)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strSSTStatusTypeName2)
				.clickOnCancelNew();
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description :User U1 has login access to regions A & B and has added
	 *				 resource and associated status types to custom view. Verify that, after
	 * 				removing the “View Resource” right for the in region A, user CANNOT
	 * 				view/add resource on/to custom view from region B. 
	 * 'Date :15-Jun-2015
	 * 'Author :Anil
	 ***************************************************************************************************************/

	@Test(enabled = false,description = "User U1 has login access to regions A & B and has added resource and associated status types to custom view. Verify that, after removing the “View Resource” right for the in region A, user CANNOT view/add resource on/to custom view from region B.")
	public void testHappyDay46474() throws Exception {
		gstrTCID = "46474";
		gstrTO = "User U1 has login access to regions A & B and has added resource and associated status types to custom view. Verify that, after removing the “View Resource” right for the in region A, user CANNOT view/add resource on/to custom view from region B.";
	
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		View_data objView_data = new View_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Views objViews1= new Views(this.driver1);
		LinksAtTopRightCorners objAtTopRightCorners1=new LinksAtTopRightCorners(this.driver1);
		Map objMap1=new Map(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		
		String strStatusTypeValues[] = new String[12];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[3];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		System.out.println(strRegionValue[1]);
		
		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		//Shared Status Types
		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);
		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);
		
		//Role-Based Status Types
		
		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);
		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);
		strStatusTypeValues[6] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);
		strStatusTypeValues[7] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);
		
		//Private Status Types
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);
		strStatusTypeValues[8] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription,  objView_data.strSectionName)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2, objStatusTypes_data.strStatusColor);

		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti3, objStatusTypes_data.strStatusColor);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[9] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);
		strStatusTypeValues[10] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription,objView_data.strSectionName);
		strStatusTypeValues[11] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName2);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);
		
		System.out.println(objResource_data.strResourceName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		//User
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);
		
//		System.out.println(objUserdata.strNewUserName);
//
//		objLogin.clickLogOut();
//		
//		objLogin.loginToApplication(objLogindata.strUserName,
//				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();
		
		objUsersList.navigateToUsers()
		            .searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				    .editUserDetails(objUserdata.strNewUserName)
				    .selectFirstRole()
				    .clickAdvancedOptionAndExpand()
				    .selectViewcustomViewOption()
				    .clickSaveButton();
	
		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		objLogin.clickLogOut();
		
		objLogin.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToCustomizedViewInPrefrences();

		objCustomUnderView
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue)
				.clickOnAddToCustomView()
				.clickOnOptions()
				.selectStatusTypes(strStatusTypeValues)
				.clickOnSave();
		


		objLogin.clickLogOut();

		System.out.println("----------------Precodition execution ends---------");

		System.out.println("-----------------Test execution starts---------------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.deselectUpdateStatusOfResource(objResource_data.strResourceName)
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objViews1.vererrorMsgInCustomView();
		objAtTopRightCorners1.clickOnShowMap();
		objCustomUnderView1.verCustomViewMapScreenIsDisplayed();
		objMap1.verResourceNotInFindResourceDropDown(objResource_data.strResourceName);

		objAtTopRightCorners1.clickOnCustomize();
		objCustomUnderView1.verEditCustomViewScreenIsDisplayed();
				
		String[] strResource = {objResource_data.strResourceName};
				
		objCustomUnderView1.verResourceAndResTypeNotDisplayedInCustomViewTablePage(strResource, objResourceType_data.strResourceTypeName);
		objCustomUnderView1
			.clickOnAddMoreResources()
			.verifyFindResourcesPage()
			.enterResNameInWhatField(objResource_data.strResourceName)
			.clickOnSearch()
			.verErrorMessgaeForResource()
			.clickOnCancel();
		objCustomUnderView1.verEditCustomViewScreenIsDisplayed();
		objCustomUnderView1.clickOnOptions();
		objCustomUnderView1.verEditCustomViewOptionsColumnIsDisplayed();
		objCustomUnderView1.verSTNotDisplayedInOptions(strStatusTypeValues);
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

	/****************************************************************************************************************
	'Description : User U1 has login access to regions A & B. Verify that user CANNOT view/add private status types of
	 			   region A on/to his custom view from region B when affiliated resource rights for the resource 
	 			   are removed in region A.
	'Precondition:
	'Date	 	 : 23-Jul-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "User U1 has login access to regions A & B. Verify that user CANNOT view/add private "
			+ "status types of region A on/to his custom view from region B when affiliated resource rights for"
			+ " the resource are removed in region A.")
	public void testHappyDay50477() throws Exception {

		gstrTCID = "50477";
		gstrTO = "User U1 has login access to regions A & B. Verify that user CANNOT view/add private status "
				+ "types of region A on/to his custom view from region B when affiliated resource rights for the"
				+ " resource are removed in region A.";
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();
		Regions objRegions_page = new Regions(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		Views objViews1 = new Views(this.driver1);
		Map objMap1 = new Map(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strPrivateStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault.selectFrame();
		
		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		System.out.println(strRegionValue[0]);
		System.out.println(strRegionValue[1]);
		System.out.println("Section Name: "+objView_data.strSectionName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName1);
		System.out.println("RS:"+objResource_data.strResourceName);
		System.out.println("RT:"+objResourceType_data.strResourceTypeName);
		System.out.println(objStatusTypes_data.strNumberStatusType);
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.deSelectAllCheckboxInRolesMayUpdatesec()
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						"", "", "", "", "", objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue[0])
				.clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[0])
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);
		
		objRegionDefault.switchToDefaultFrame().selectFrame();
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1)
				.clickOnSaveBtn();

		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);
		
		objUsersList
				.navigateToUsersNew()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.selectRoleCheckBox(strRoleValue[1])
				.clickSaveButton();
		
		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		//Role based status types
		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
				
		objStatusTypeList
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)

				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)

				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);
		
		//private status types
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strPNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strPNSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strpTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpTSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strpMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
		objStatusTypeList
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)

				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)

				.clickOnReturnToStatusTypeList();

		strPrivateStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpMSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strpSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpSSTStatusTypeName);
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strpNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpNDSTStatusTypeName);
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strpDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpDateStatusTypeName);
		
		String[] strAllStatusTypeValues = ArrayUtils.addAll(strPrivateStatusTypeValues, strStatusTypeValues);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage()
					   .createResourceType(objResourceType_data.strResourceTypeName,
							   	strAllStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()
				   .createResourceWithAddress(
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
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList.searchUserName(objUserdata.strNewUserName,
							objUserdata.strRole, objUserdata.strResourceType,
							objUserdata.strUsername, objUserdata.strsearchOption)
					.editUserDetails(objUserdata.strNewUserName)
					.selectViewResourceRights(
						objResource_data.strResourceName)
					.selectUpdateStatusOfResource(
							objResource_data.strResourceName)
					.clickSaveButton();
		
		objLogin.clickLogOut()
				.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objSelectRegionpage.selectRegion(objLogindata.strRegionName2)
						   .clickNextButton();
		
		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(
						objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue)
				.clickOnAddToCustomView()
				.clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strAllStatusTypeValues)
				.clickOnSave();

		objLogin.clickLogOut();
		
		System.out.println("-------Precondition Ends-------");
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName1);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				     .editUserDetails(objUserdata.strNewUserName)
				     .deselectUpdateStatusOfResource(
				    		 objResource_data.strResourceName)
				     .deselectRunReportRight(
				    		 objResource_data.strResourceName)
				     .deselectAssociatedRightCheckBox(
				    		 objResource_data.strResourceName)
				     .clickSaveButton();
		
		objLogin1.clickLogOut()
				 .loginToApplication(objUserdata.strNewUserName,
						 objUserdata.strNewPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(
				objLogindata.strRegionName2);
		
objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToCustomInView();
		
		String strPrivateStatusTypeNames[] = {objStatusTypes_data.strPNSTStatusTypeName,
				objStatusTypes_data.strpTSTStatusTypeName,
				objStatusTypes_data.strpMSTStatusTypeName,
				objStatusTypes_data.strpSSTStatusTypeName,
				objStatusTypes_data.strpNDSTStatusTypeName,
				objStatusTypes_data.strpDateStatusTypeName };

		String strRoleBasedSTNames[] = {objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName};
		
		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		for (int j = 0; j < strPrivateStatusTypeValues.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strRoleBasedSTNames[j]);
		}

		System.out.println("Please wait, negative validation takes time: (20 seconds * 6 STs) not present");
		
		for (int i = 0; i < strAllStatusTypeValues.length; i++) {
			System.out.println(i);
			objCustomUnderView1.verStatusTypeNotInCustomViewTablePage(strPrivateStatusTypeNames[i]);
		}		
		
		objViews1.clickOnCustomizeLink();
		
		objCustomUnderView1.verEditCustomViewScreenIsDisplayed()		
						   .clickOnOptions()
						   .verEditCustomViewOptionsColumnIsDisplayed()
						   .verSTNotDisplayedInOptions(strPrivateStatusTypeValues)
						   .verSTDisplayedAndCheckedInOptions(strStatusTypeValues)
						   .clickOnCancel()
						   .clickOnCustomeViewMap()
						   .selectResourceName(objResource_data.strResourceName);
		
		objMap1.verStatusTypesInPopupWindow(strRoleBasedSTNames)
			   .verStatusTypesNotInPopupWindow(strPrivateStatusTypeNames);
		
		gstrResult = "PASS";
	}
	/*****************************************************************************************************************
	 * 'Description : User U1 has login access to regions A & B. Verify that, after removing the “View Resource” right
	 *                for the in region A, user CANNOT view/edit status change preferences for resource from region B.
	 * 'Date        :15-Jun-2015
	 * 'Author      :Anil
	 *****************************************************************************************************************/

	@Test(description = " User U1 has login access to regions A & B. Verify that, after removing the “View Resource” "
			+ "right for the in region A, user CANNOT view/edit status change preferences for resource from region B.")
	public void testHappyDay46577() throws Exception {
		gstrTCID = "46577";
		gstrTO = " User U1 has login access to regions A & B. Verify that, after removing the “View Resource” right for"
				+ " the in region A, user CANNOT view/edit status change preferences for resource from region B.";
	
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		NotificationValues objNotificationValues = new NotificationValues();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[12];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[3];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		System.out.println(strRegionValue[1]);
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		//Shared Status Types
		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
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
		
		//Role-Based Status Types
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[6] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[7] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);
		
		//Private Status Types
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[8] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2, objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti3, objStatusTypes_data.strStatusColor);

		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[9] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);
		
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[10] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[11] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName2);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
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
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		//User
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						"", "", "", "", "", objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();
		
		objUsersList.navigateToUsers()
		            .searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				    .editUserDetails(objUserdata.strNewUserName)
				    .clickAdvancedOptionAndExpand()
				    .selectEditStatusChangeNotPrefernceOption()
				    .clickSaveButton();
	
		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objSelectRegionpage.selectRegion(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateStatusChangeInPreferences();

		objStatusChangePreference
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.expandUncategorizedSec()
				
				//3-MST
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1],strStatusesValues[0])	
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[5],strStatusesValues[1])	
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[9],strStatusesValues[2])	

				//3-NST
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[0])	
						
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[4],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[4],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[4])
						
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[8],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[8],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[8])

				//3-SST
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[3],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[3],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[3])
				
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[7],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[7],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[7])
				
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[11],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[11],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[11])
							
				//3-TST
				.selEmailPagerWebChkBoxes(
						strResourceValue[0], strStatusTypeValues[2])
				.selEmailPagerWebChkBoxes(
						strResourceValue[0], strStatusTypeValues[6])
				.selEmailPagerWebChkBoxes(strResourceValue[0],
						strStatusTypeValues[10]).clickOnSave();

		objLogin.clickLogOut();

		System.out.println("----------------Precodition execution ends---------");

		System.out.println("-----------------Test execution starts---------------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.deselectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strNSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strTSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strSSTStatusTypeName,
						objResource_data.strResourceName)

				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strNSTStatusTypeName1,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strTSTStatusTypeName1,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strSSTStatusTypeName1,
						objResource_data.strResourceName)

				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strNSTStatusTypeName2,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strMSTStatusTypeName2,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strTSTStatusTypeName2,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strSSTStatusTypeName2,
						objResource_data.strResourceName)

		        .clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch();
		
		objCustomUnderView1.verErrorMessgaeForResource();
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************************************
	 * 'Description : For a user U1 who has login access to regions A and B, deselect status types in the ‘Refine’
	 *                 window from region A and save. Verify that user cannot view/edit status change preferences
	 *                  for the status type from region B.
	 * 'Date        :15-Jun-2015
	 * 'Author      :Anil
	 *************************************************************************************************************/

	@Test(description = "For a user U1 who has login access to regions A and B, deselect status types in the ‘Refine’"
			+ " window from region A and save. Verify that user cannot view/edit status change preferences for"
			+ " the status type from region B.")
	public void testHappyDay46576() throws Exception {
		gstrTCID = "46576";
		gstrTO = "For a user U1 who has login access to regions A and B, deselect status types in the ‘Refine’ window "
				+ "from region A and save. Verify that user cannot view/edit status change preferences for the"
				+ " status type from region B.";
	
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Roles_data objRolesData = new Roles_data();
		NotificationValues objNotificationValues = new NotificationValues();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[12];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];
		String strRoleValue[] = new String[1];
		String strStatusesValues[] = new String[3];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName2);

		System.out.println(strRegionValue[1]);
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		//Shared Status Types
		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)

		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor);


		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

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
		
		//Role-Based Status Types
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[6] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[7] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);
		
		//Private Status Types
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[8] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2, objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti3, objStatusTypes_data.strStatusColor);

		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[9] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);
		
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[10] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription);
		strStatusTypeValues[11] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName2);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
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
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		//User
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						"", "", "", "", "", objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);
System.out.println(objResource_data.strResourceName);
		objLogin.clickLogOut();
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();
		
		objUsersList.navigateToUsers()
		            .searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				    .editUserDetails(objUserdata.strNewUserName)
				    .clickAdvancedOptionAndExpand()
				    .selectEditStatusChangeNotPrefernceOption()
				    .clickSaveButton();
	
		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objSelectRegionpage.selectRegion(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateStatusChangeInPreferences();

		objStatusChangePreference
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.expandUncategorizedSec()
				
				//3-MST
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[1],strStatusesValues[0])	
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[5],strStatusesValues[1])	
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[9],strStatusesValues[2])	

				//3-NST
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[0])	
						
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[4],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[4],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[4])
						
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[8],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[8],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[8])

				//3-SST
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[3],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[3],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[3])
				
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[7],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[7],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[7])
				
				.enterAboveValues(strResourceValue[0], strStatusTypeValues[11],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[0], strStatusTypeValues[11],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(
						strResourceValue[0], strStatusTypeValues[11])
							
				//3-TST
				.selEmailPagerWebChkBoxes(
						strResourceValue[0], strStatusTypeValues[2])
				.selEmailPagerWebChkBoxes(
						strResourceValue[0], strStatusTypeValues[6])
				.selEmailPagerWebChkBoxes(strResourceValue[0],
						strStatusTypeValues[10]).clickOnSave();

		objLogin.clickLogOut();

		System.out.println("----------------Precodition execution ends---------");

		System.out.println("-----------------Test execution starts---------------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		String[] strStatusTypeValues1 = { strStatusTypeValues[0],
				strStatusTypeValues[1], strStatusTypeValues[2],
				strStatusTypeValues[3], strStatusTypeValues[4],
				strStatusTypeValues[5], strStatusTypeValues[6],
				strStatusTypeValues[7] };
		
		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickRefineLinkOfViewResource(objResource_data.strResourceName)
				.selectFrameOfRefineVisibleStatusTypes()
				.deselectStatusTypesInRefine(strStatusTypeValues1)
				.clickSaveChangesButtonInRefine()
				.selectFrame()
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

		objStatusChangePreference1
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strNSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strTSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strSSTStatusTypeName,
						objResource_data.strResourceName)

				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strNSTStatusTypeName1,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strTSTStatusTypeName1,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strSSTStatusTypeName1,
						objResource_data.strResourceName)

				.verStatusTypeNotification(
						objStatusTypes_data.strMSTStatusTypeName2)
				.verStatusTypeNotification(
						objStatusTypes_data.strNSTStatusTypeName2)
				.verStatusTypeNotificationBelow(
						objStatusTypes_data.strNSTStatusTypeName2)
				.verStatusTypeNotification(
						objStatusTypes_data.strSSTStatusTypeName2)
				.verStatusTypeNotificationBelow(
						objStatusTypes_data.strSSTStatusTypeName2)
				.verStatusTypeNotification(
						objStatusTypes_data.strTSTStatusTypeName2);

		objStatusChangePreference1
				.clickOnEditInMyStatusChangePreferences(
						objResource_data.strResourceName)
				.expandUncategorizedSec()
				
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strNSTStatusTypeName2)
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strMSTStatusTypeName2)
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strTSTStatusTypeName2)
				.verStatusTypesUnderUncategorizedSec(
						objStatusTypes_data.strSSTStatusTypeName2)

				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strNSTStatusTypeName)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strMSTStatusTypeName)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strTSTStatusTypeName)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strSSTStatusTypeName)

				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strNSTStatusTypeName1)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strMSTStatusTypeName1)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strTSTStatusTypeName1)
				.verStatusTypesNotDisplayed(
						objStatusTypes_data.strSSTStatusTypeName1);
						
		objNavigationToSubmenus1.navigateStatusChangeInPreferences();
						
		objStatusChangePreference1.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue[0])
				.clickOnNotifications()
				.expandUncategorizedSec()
				
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strNSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strMSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strTSTStatusTypeName,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strSSTStatusTypeName,
						objResource_data.strResourceName)

				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strNSTStatusTypeName1,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strMSTStatusTypeName1,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strTSTStatusTypeName1,
						objResource_data.strResourceName)
				.verStatusTypesNotDispalyed(
						objStatusTypes_data.strSSTStatusTypeName1,
						objResource_data.strResourceName);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}

