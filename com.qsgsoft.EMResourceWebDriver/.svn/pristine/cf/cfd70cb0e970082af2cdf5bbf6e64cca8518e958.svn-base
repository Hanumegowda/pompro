package requirementGroup.CreatingAndManagingRoles;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Login_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseCreateRole extends TestNG_UI_EXTENSIONS{

	public EdgeCaseCreateRole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/**********************************************************************
	'Description : Verify that process of creating a role can be cancelled. 
	'Date	 	 : 19-Feb-2016
	'Author		 : Anitha
	'----------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***********************************************************************/
	@Test(description = "Verify that process of creating a role can be cancelled. ")
	public void testEdgeCase111918() throws Exception {

		gstrTCID = "111918";
		gstrTO = "Verify that process of creating a role can be cancelled. ";

		Login_data objLogindata = new Login_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValue[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objLogin.clickLogOut();
	
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRoles();

		objRoles1.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.clickStatusTypeInRoleMayViewSection(strStatusTypeValue)
				.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValue);

		objUsersList1.selectSetupResourceTypesOption();

		objRoles1.clickOnCancelButton().verifyRoleNotInRolesList(
				objRolesData.strRoleName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/********************************************************************************************
	'Description : Verify that a user can be provided a role with 'Maintain Event Template' right.
	'Date	 	 : 19-Feb-2016
	'Author		 : Anitha
	'--------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*********************************************************************************************/
	@Test(description = "Verify that a user can be provided a role with 'Maintain Event Template' right.")
	public void testEdgeCase111919() throws Exception {

		gstrTCID = "111919";
		gstrTO = "Verify that a user can be provided a role with 'Maintain Event Template' right.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Roles_data objRolesdata = new Roles_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strRoleValue[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList
			.clickCreateNewUserButton()
			.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
			.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
		
		System.out.println("Precondition ends and test execution starts");
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToRoles();
		
		objRoles1.clickOnCreateNewRoleBtn()
				 .verifyRoleListPageIsDisplayed()
				 .enterRoleName(objRolesdata.strRoleName);
		
		objUsersList1.selectMaintainEventTemplateOption();
		
		objRoles1.clickOnSaveBtn()
				 .verifyCreatedRoleInRolesList(objRolesdata.strRoleName);
		
		strRoleValue[0] = objRoles1.getRoleValue(objRolesdata.strRoleName);
		
		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.selectRoleCheckBox(strRoleValue).clickSaveButton();

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName, 
						 objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.clickSaveButton()
				.verEveTemplateListScreenIsDisplayed()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate)
				.verEveNotPrePageIsNotDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verifyEditTempLinkIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verifySecurityLinkForTempIsNotDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verifyNotificationTempLinkIsNotDisplayed(
						objEventSetUp_data.strEventTemplate);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/********************************************************************************************
	'Description : Verify that a user can be provided a role with 'Maintain Event Template' and 
	'				'User-setup user accounts' rights
	'Date	 	 : 19-Feb-2016
	'Author		 : Pallavi
	'--------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*********************************************************************************************/
	@Test(description = "Verify that a user can be provided a role with 'Maintain Event Template' and 'User-setup user accounts' rights")
	public void testEdgeCase111920() throws Exception {

		gstrTCID = "111920";
		gstrTO = "Verify that a user can be provided a role with 'Maintain Event Template' and 'User-setup user accounts' rights";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Roles_data objRolesdata = new Roles_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strRoleValue[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList
			.clickCreateNewUserButton()
			.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
			.clickAdvancedOptionAndExpand()
			.selectConfigureRegionalUserAccessOption()
			.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
		
		System.out.println("Precondition ends and test execution starts");
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToRoles();
		
		objRoles1.clickOnCreateNewRoleBtn()
				 .verifyRoleListPageIsDisplayed()
				 .enterRoleName(objRolesdata.strRoleName);
		
		objUsersList1.selectMaintainEventTemplateOption();
		
		objRoles1.clickOnSaveBtn()
				 .verifyCreatedRoleInRolesList(objRolesdata.strRoleName);
		
		strRoleValue[0] = objRoles1.getRoleValue(objRolesdata.strRoleName);
		
		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.selectRoleCheckBox(strRoleValue).clickSaveButton();

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName, 
						 objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.clickSaveButton()
				.verEveNotPreferenceScreenIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.deselectSelectAllWebOptionOnly()
				.clickOnWebCheckBox(objUserdata.strNewUserName)
				.clickOnEmailCheckBox(objUserdata.strNewUserName)
				.clickOnPagerCheckBox(objUserdata.strNewUserName)
				.clickSaveButton()
				.verEveTemplateListScreenIsDisplayed()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate)
				.verifyEditTempLinkIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verifyNotificationTempLinkIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verifySecurityLinkForTempIsNotDisplayed(
						objEventSetUp_data.strEventTemplate);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
