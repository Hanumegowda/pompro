package requirementGroup.CreatingAndManagingRoles;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEdgeCaseEditRole extends TestNG_UI_EXTENSIONS{

	public NewEdgeCaseEditRole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*******************************************************************************
	'Description : Edit a role and verify that newly selected right is marked with
	               asterisk when user is opened for editing. 
	'Date	 	 : 22-Feb-2016
	'Author		 : Anitha
	'-------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*******************************************************************************/
	@Test(description = " Edit a role and verify that newly selected right is marked with "
			+ "asterisk when user is opened for editing.")
	public void testEdgeCase111928() throws Exception {

		gstrTCID = "111928";
		gstrTO = " Edit a role and verify that newly selected right is marked with asterisk "
				+ "when user is opened for editing.";

		Login_data objLogindata = new Login_data();
		Roles_data objRolesData = new Roles_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String[] strRoleValue = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);

		objUsersList.selectSetupResourceTypesOption()
				.selectConfigureRegionalUserAccessOption();

		objRoles.clickOnSaveBtn();
		
		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList
			.clickCreateNewUserButton()
			.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
			.selectRoleCheckBox(strRoleValue[0])
			.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
	
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnEditLinkOfRole(objRolesData.strRoleName);

		objUsersList1.selectMaintainEventsOption();

		objRoles1.clickOnSaveBtn();

		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand()
				.verifyAsteriskIsDisplayedCorrespondingToRight(
						objUserdata.strMaintainEventsValue)
				.verifyAsteriskIsDisplayedCorrespondingToRight(
						objUserdata.strSetupResourceTypesValue)
				.verifyAsteriskIsDisplayedCorrespondingToRight(
						objUserdata.strConfigureRegionalUserAccessValue)
				.clickCancelButton();
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************
	'Description : Verify that the user rights are updated accordingly depending on 
	'				the rights selected in a role when the user is edited 
	'Date	 	 : 22-Feb-2016
	'Author		 : Pallavi
	'-------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*******************************************************************************/
	@Test(description = "Verify that the user rights are updated accordingly depending on the rights selected in a role when the user is edited")
	public void testEdgeCase111927() throws Exception {

		gstrTCID = "111927";
		gstrTO = "Verify that the user rights are updated accordingly depending on the rights selected in a role when the user is edited";

		Login_data objLogindata = new Login_data();
		Roles_data objRolesData = new Roles_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);

		String[] strRoleValue = new String[2];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName);

		objUsersList.selectSetupResourceTypesOption()
					.selectConfigureRegionalUserAccessOption();

		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName1);

		objUsersList.selectMaintainEventsOption()
					.selectFormUserMayActivateAndModifyFormsOption();

		objRoles.clickOnSaveBtn();

		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList
			.clickCreateNewUserButton()
			.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
			.selectRoleCheckBox(strRoleValue[0])
			.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objRolesData.strRoleName);
		
		objLogin.clickLogOut();
	
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
					 .editUserDetails(objUserdata.strNewUserName)
					 .deselectRoleCheckBox(strRoleValue[0])
					 .selectRoleCheckBox(strRoleValue[1])
					 .clickAdvancedOptionAndExpand()
					 .verifyAsteriskIsDisplayedCorrespondingToRight(
							 objUserdata.strMaintainEventsValue)
					 .verifyAsteriskIsDisplayedCorrespondingToRight(
							 objUserdata.strFormUserMayCreateAndModifyValue)
					 .verifyAsteriskIsNotDisplayedCorrespondingToRight(
							 objUserdata.strSetupResourceTypesValue)
					 .verifyAsteriskIsNotDisplayedCorrespondingToRight(
							 objUserdata.strConfigureRegionalUserAccessValue)
					 .clickSaveButton()
					 
					 .searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
					 .editUserDetails(objUserdata.strNewUserName)
					 .clickAdvancedOptionAndExpand()
					 .verifyAsteriskIsDisplayedCorrespondingToRight(
							 objUserdata.strMaintainEventsValue)
					 .verifyAsteriskIsDisplayedCorrespondingToRight(
							 objUserdata.strFormUserMayCreateAndModifyValue)
					 .verifyAsteriskIsNotDisplayedCorrespondingToRight(
							 objUserdata.strSetupResourceTypesValue)
					 .verifyAsteriskIsNotDisplayedCorrespondingToRight(
							 objUserdata.strConfigureRegionalUserAccessValue)
					 .clickCancelButton();
		
		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.clickOnEventLink()
						   .verifyEventManagementLinkIsDisplayed();
		
		objNavigationToSubmenus1.navigateToFormMenu();
		
		objFormConfiguration.verifyConfigureFormLinkIsDisplayed();
		
		objLogin1.clickLogOut()
				 .loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1
			.clickCreateNewUserButton()
			.selectRoleCheckBox(strRoleValue[0])
			.clickAdvancedOptionAndExpand()
			.verifyAsteriskIsDisplayedCorrespondingToRight(
							 objUserdata.strSetupResourceTypesValue)
			.verifyAsteriskIsDisplayedCorrespondingToRight(
					 objUserdata.strConfigureRegionalUserAccessValue)
			.clickCancelButton();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

	/*******************************************************************************
	'Description : Edit a role and verify that deselected right is not marked with 
	               asterisk when user is opened for editing.
	'Date	 	 : 22-Feb-2016
	'Author		 : Anitha
	'-------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*******************************************************************************/
	@Test(description = "Edit a role and verify that deselected right is not marked with"
			+ " asterisk when user is opened for editing.")
	public void testEdgeCase111929() throws Exception {

		gstrTCID = "111929";
		gstrTO = "Edit a role and verify that deselected right is not marked with asterisk "
				+ "when user is opened for editing.";

		Login_data objLogindata = new Login_data();
		Roles_data objRolesData = new Roles_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String[] strRoleValue = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName);

		objUsersList.selectSetupResourceTypesOption();

		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0]).clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
	
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnEditLinkOfRole(objRolesData.strRoleName);

		objUsersList1.deselectSetupResourceTypesOption()
				.selectMaintainEventsOption();

		objRoles1.clickOnSaveBtn();

		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
					 .editUserDetails(objUserdata.strNewUserName)
					 .clickAdvancedOptionAndExpand()
					 .verifyAsteriskIsDisplayedCorrespondingToRight(
							 objUserdata.strMaintainEventsValue)
					 .verifyAsteriskIsNotDisplayedCorrespondingToRight(
							 objUserdata.strSetupResourceTypesValue)
					 .clickCancelButton();
		
		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.clickOnEventLink()
						   .verifyEventManagementLinkIsDisplayed();

		objLogin1.clickLogOut()
				 .loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.selectRoleCheckBox(strRoleValue[0])
				.clickAdvancedOptionAndExpand()
				.verifyAsteriskIsDisplayedCorrespondingToRight(
						objUserdata.strMaintainEventsValue)
				.verifyAsteriskIsNotDisplayedCorrespondingToRight(
						objUserdata.strSetupResourceTypesValue)
				.clickCancelButton();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************
	'Description : Verify that user can not update status types when update right for status type is removed in a role. 
	'Date	 	 : 15-Mar-2016
	'Author		 : Renushree
	'-------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*******************************************************************************/
	@Test(description = "Verify that user can not update status types when update right for status type is removed in a role. ")
	public void testEdgeCase111930() throws Exception {

		gstrTCID = "111930";
		gstrTO = "Verify that user can not update status types when update right for status type is removed in a role. ";

		Login_data objLogindata = new Login_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);

		String[] strRoleValue = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);

		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		System.out.println(objRolesData.strRoleName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		System.out.println(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)
				
		   .createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objResourceType.navigateToResourceTypePage().createResourceType(
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

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName };

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strAllStatausTypes);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue).clickAdvancedOptionAndExpand()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnEditLinkOfRole(objRolesData.strRoleName)
				.deselectStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickOnSaveBtn();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strAllStatausTypes[i]);
		}

		objViewsList1.verUpdateKeyIcon()
				.clickOnUpdateStatus(objResource_data.strResourceName)
				.verUnauthorizedErrorMsg();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************
	'Description : Verify that user can update status types only when the status types are selected in a role to update. 
	'Date	 	 : 15-Mar-2016
	'Author		 : Renushree
	'-------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*******************************************************************************/
	@Test(description = "Verify that user can update status types only when the status types are selected in a role to update.")
	public void testEdgeCase111931() throws Exception {

		gstrTCID = "111931";
		gstrTO = "Verify that user can update status types only when the status types are selected in a role to update.";

		Login_data objLogindata = new Login_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String[] strRoleValue = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strstatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRolesData.strRoleName);

		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		System.out.println(objRolesData.strRoleName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		System.out.println(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		// Event statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);

		strstatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		
		strstatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objResourceType.navigateToResourceTypePage().createResourceType(
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

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName };

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strAllStatausTypes);

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue).clickAdvancedOptionAndExpand()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnEditLinkOfRole(objRolesData.strRoleName)
				.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValues)
				.clickOnSaveBtn();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strAllStatausTypes[i]);
		}

		objViewsList1.verUpdateKeyIcon()
				.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1.clickOnSelectAll();

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForUpdate);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[1],
				objView_data.strValueForNDST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForTST);

		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[3],
				strstatusesValues[0]);

		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues[4],
				objView_data.strValueForSST);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
				objView_data.strDateUpdateValue);

		objUpdateStatus1.clickOnSaveButton();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
