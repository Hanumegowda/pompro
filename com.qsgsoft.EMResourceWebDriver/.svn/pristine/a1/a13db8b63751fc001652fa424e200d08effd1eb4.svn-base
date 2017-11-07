package requirementGroup.MultiRegion;

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

public class EdgeCaseStandardStatusTypeLabels extends TestNG_UI_EXTENSIONS{

	public EdgeCaseStandardStatusTypeLabels() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**********************************************************************************
	 * 'Description :Verify that users other than RegAdmin cannot edit the SST labels.
	 * 'Date        :26-Sep-2014 
	 * 'Author      :Anitha
	 **********************************************************************************/

	@Test(description = "Verify that users other than RegAdmin cannot edit the SST labels")
	public void testEdgeCase156603() throws Exception {
		gstrTCID = "156603";
		gstrTO = "Verify that users other than RegAdmin cannot edit the SST labels";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus_page1 = new NavigationToSubMenus(this.driver1);
		StatusTypeList StatusTypeList_page_page1 = new StatusTypeList(this.driver1);
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		StatusTypeList_page
				.navigateToStatusTypeList()
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strNumberStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strNSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStandardStatusTypename(
						objStatuTypes_data.strStandardStatusTypename)
				.clickOnSaveButton();

		// User creation
		UsersList_page.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.selectFirstRole()

				.clickAdvancedOptionAndExpand()

				.selectSetupStatusTypesOption()

				.clickSaveButton();

		login_page.clickLogOut();

		System.out.println("----------------Precodition execution ends---------");

		System.out.println("-----------------Test execution starts---------------");

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page1.selectFrame();

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame();

		objNavigationToSubmenus_page1.navigateToStatusTypesInSetup();

		StatusTypeList_page_page1
				.clickStanderdStatusTypeButton()

				.verStdStatusTypeLabelsIsEditable(
						objStatuTypes_data.strStandardStatusTypeLabel)

				.clickCancelButton()

				.verifyStatusTypeListPage();

		login_page1.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		objNavigationToSubmenus_page1.navigateToStatusTypesInSetup();

		StatusTypeList_page_page1
				.clickStanderdStatusTypeButton()

				.verifyViewStandardStatusTypeLabelsPage()

				.verStdStatusTypeLabelsNotEditable(
						objStatuTypes_data.strStandardStatusTypeLabel)

				.clickBackButton()

				.verifyStatusTypeListPage();

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
}
