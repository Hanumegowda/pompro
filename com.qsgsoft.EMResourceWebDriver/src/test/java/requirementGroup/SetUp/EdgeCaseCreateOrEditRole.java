package requirementGroup.SetUp;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseCreateOrEditRole extends TestNG_UI_EXTENSIONS{

	public EdgeCaseCreateOrEditRole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/***********************************************************************************
	 * 'Description : Verify that user full name along with user name (user name (user full name) 
	 *                 )on all the EMResource pages. 
	 * 'Date       : 19-June-2015
	 * 'Author     : Sangappa.k
	 ************************************************************************************/

	@Test(description =" Verify that user full name along with user name (user name (user full name) )on all the EMResource pages. ")
    public void testEdgeCase161479() throws Exception {
	gstrTCID = "161479";
	gstrTO = " Verify that user full name along with user name (user name (user full name) )on all the EMResource pages. ";
	
		// Objects for data
	Login_data objTest_data = new Login_data();
	User_data objUserdata = new User_data();
	Login objLogin = new Login(this.driver1);
	SelectRegion objSelectRegion = new SelectRegion(this.driver1);
	RegionDefault objRegionDefault = new RegionDefault(this.driver1);
	UsersList objUsersList = new UsersList(this.driver1);
	Login objLogin1 = new Login(this.driver1);
	RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
	NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
			this.driver1);

   System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		objRegionDefault1.selectFrame();
	
		objUsersList.verUserNameIsDispaledAtFooterOfApp(
				objUserdata.strNewUserName, objUserdata.strFullName);

		objNavigationToSubMenus1.clickOnViewMenu();

		objUsersList.verUserNameIsDispaledAtFooterOfApp(
				objUserdata.strNewUserName, objUserdata.strFullName);

		objNavigationToSubMenus1.navigateToEventList();

		objUsersList.verUserNameIsDispaledAtFooterOfApp(
				objUserdata.strNewUserName, objUserdata.strFullName);

		objNavigationToSubMenus1.navigateStatusChangeInPreferences();
		objUsersList.verUserNameIsDispaledAtFooterOfApp(
				objUserdata.strNewUserName, objUserdata.strFullName);

		objNavigationToSubMenus1.navigateToFormList();
		objUsersList.verUserNameIsDispaledAtFooterOfApp(
				objUserdata.strNewUserName, objUserdata.strFullName);

		objNavigationToSubMenus1.navigateToCalendarInRegionalInfo();
		objUsersList.verUserNameIsDispaledAtFooterOfApp(
				objUserdata.strNewUserName, objUserdata.strFullName);
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";

	}
}

