package requirementGroup.SetUp;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.OtherRegions;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.SystemNotifications;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewHappyDayUsers extends TestNG_UI_EXTENSIONS{

	public NewHappyDayUsers() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/***********************************************************************************
	 * 'Description :  Verify that all the regions are selected under "Views >> View other Regions" when select all option is selected while creating users
	 * 'Date :15-Sep-2014 
	 * 'Author :Anil
	 ************************************************************************************/

	@Test(description = " Verify that all the regions are selected under Views >> View other Regions when select all option is selected while creating users")
	public void testHappyDay138665() throws Exception {
		gstrTCID = "138665";
		gstrTO = " Verify that all the regions are selected under Views >> View other Regions when select all option is selected while creating users";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		OtherRegions objOtherRegions = new OtherRegions(this.driver1);
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		SelectRegion_page.selectRegionAndNavigate(objTest_data.strSetracReg);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectSelectAll();
		String strRegionValues[] = UsersList_page.getViewOtherRegView();
		UsersList_page.selectFirstRole()

				.clickSaveButton();

		login_page.clickLogOut();

		login_page.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		Thread.sleep(5000);
		
		RegionDefault_page.selectFrame();
		
		objOtherRegions.navigateToRegUnderOtherRegions();
		
		objOtherRegions.verifyOtherRegionViewsRegionList(strRegionValues);
		
		login_page.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that user is taken to 'Region default' view of last accessed region when he logs into application
	'Precondition	: None
	'Date 			: 18-Dec-2015 
	'Author 		: Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user is taken to 'Region default' view of last accessed region when he logs into application")
	public void testHappyDay138899() throws Exception {

		gstrTCID = "138899";
		gstrTO = "Verify that user is taken to 'Region default' view of last accessed region when he logs into application";

		Login_data objLogindata = new Login_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1
				.selectFrame()
				.verRegionName(objLogindata.strRegionName,
						objLogindata.strDomainName).verifyRegionDefaultPage();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strStateOfMissouri);

		objRegionDefault1
				.selectFrame()
				.verRegionName(objLogindata.strStateOfMissouri,
						objLogindata.strDomainName).verifyRegionDefaultPage();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strSpringfieldReg);

		objRegionDefault1
				.selectFrame()
				.verRegionName(objLogindata.strSpringfieldReg,
						objLogindata.strDomainName).verifyRegionDefaultPage();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1
				.selectFrame()
				.verRegionName(objLogindata.strSpringfieldReg,
						objLogindata.strDomainName).verifyRegionDefaultPage();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
