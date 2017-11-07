package requirementGroup.SettingUpStatusTypes;

import lib.dataObject.Login_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEdgeCaseCreateNumberStatusType extends TestNG_UI_EXTENSIONS{

	public NewEdgeCaseCreateNumberStatusType() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/************************************************************************************
	'Description : Verify that only RegAdmin can deactivate a number status type which is 
	               associated with standard status type.
	'Date	 	 : 15-Feb-2015
	'Author		 : Anitha
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************/
	@Test(description = "Verify that only RegAdmin can deactivate a number status type which is "
			+ "associated with standard status type.")
	public void testEdgeCase70455() throws Exception {

		gstrTCID = "70455";
		gstrTO = "Verify that only RegAdmin can deactivate a number status type which is "
				+ "associated with standard status type.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption().clickSaveButton();

		objLogin.clickLogOut();
		
		System.out.println("---Precondition ends and test execution starts---");
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToStatusTypesInSetup();
		
		objStatusTypeList1
				.verifyStatusTypeListPage()
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strNumberStatusType)
				.clickNextButton()
				.verifyCreateNumberStatusTypePage()
				.enterStatusTypeName(objStatusTypes_data.strNSTStatusTypeName)
				.selectStandardStatusTypename(
						objStatusTypes_data.strStandardStatusTypename)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.clickOnSaveButton()
				.verifyNameColumnForST(
						objStatusTypes_data.strNSTStatusTypeName)
				.verifyStandardTypeColumnForST(
						objStatusTypes_data.strNSTStatusTypeName,
						objStatusTypes_data.strStandardStatusTypename);

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToStatusTypesInSetup();
		
		objStatusTypeList1.verifyNameColumnForST(
				objStatusTypes_data.strNSTStatusTypeName)
				.clickOnEditOfStatusType(objStatusTypes_data.strNSTStatusTypeName)
				.verifyEditNumberStatusTypePage()
				.verifyActiveCheckBoxIsDisabled();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToStatusTypesInSetup();
		
		objStatusTypeList1
				.clickOnEditOfStatusType(
						objStatusTypes_data.strNSTStatusTypeName)
				.verifyActiveCheckBoxIsEnabled()
				.deselectActiveCheckBox()
				.clickOnSaveButton()
				.verifyStatusTypeIsNotListed(
						objStatusTypes_data.strNSTStatusTypeName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
