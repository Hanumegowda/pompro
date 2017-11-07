package requirementGroup.VisibilityChanges;

import java.util.concurrent.TimeUnit;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewHappyDayVisibilityChanges extends TestNG_UI_EXTENSIONS {

	public NewHappyDayVisibilityChanges() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that changes made for the user are reflected upon 15 minutes of wait time upon navigation 
	'Precondition:
	'Date	 	 : 21-Dec-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that changes made for the user are reflected upon 15 minutes of wait time upon navigation ")
	public void testHappyDay129488() throws Exception {

		gstrTCID = "129488";
		gstrTO = "Verify that changes made for the user are reflected upon 15 minutes of wait time upon navigation ";

		Login_data objLogindata = new Login_data();
		Roles_data objRoles_data = new Roles_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
	
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strRoleValue[] = new String[1];
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRoles_data.strRoleName)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objNavigationToSubmenus.navigateToViews();
		
//		objViewsList.clickCreateNewViewButton()
//					 .enterViewName(objView_data.strViewName)
//					 .enterViewDesc(objView_data.strViewDesc);
//		
//		objViewsList.selectStatusType(objStatuTypes_data.strNSTStatusTypeName);
//					 
//		objViewsList.selectResource(objResource_data.strResourceName)
//					 .clickOnSaveOfCreateNewView()
//					 .verViewInList(objView_data.strViewName);
			
		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				objStatuTypes_data.strNSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objUsersList.navigateToUsers()
		.editUserDetails(objUserdata.strNewUserName)
		.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectConfigureRegionViewsOption().clickSaveButton();

		objLinksAtTopRightCorners1.clickOnRefresh();

		objNavigationToSubmenus1.verViewSubMenuNotPresent();

		objEventManagement1.verifyEventManagementLinkIsNotDisplayed();

		TimeUnit.MINUTES.sleep(15); //Waiting 15 min as per test case requirement
		
		objNavigationToSubmenus1.clickOnPreferences();

		objNavigationToSubmenus1.verViewSubMenuPresent();
		
		objEventManagement1.clickOnEventLink();

		objEventManagement1.verifyEventManagementLinkIsDisplayed();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
