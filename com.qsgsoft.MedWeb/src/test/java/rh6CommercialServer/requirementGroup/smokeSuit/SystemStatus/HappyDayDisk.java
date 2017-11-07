package rh6CommercialServer.requirementGroup.smokeSuit.SystemStatus;

import dataObject.Login_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.SystemStatus;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayDisk extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayDisk() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that total Disk Usage in MB is displayed for following section: 1. 
                     Operating system and programs 2.Users 3.Groups 4.Free Disk Space 5.Total Space.     
    'Precondition  :
    'Date          : 30-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that total Disk Usage in MB is displayed for following section: "
			+ "1. Operating system and programs 2. Users 3. Groups 4. Free Disk Space 5. Total Space.")
	public void testHappyDay68301() throws Exception {

		gstrTCID = "68301";
		gstrTO = "Verify that total Disk Usage in MB is displayed for following section: 1. Operating"
				+ " system and programs 2. Users 3. Groups 4. Free Disk Space 5. Total Space.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
		SystemStatus objSystemStatus = new SystemStatus(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnSystemStatus1();
		objSystemStatus.clickOnDisk1().verDiskUsageSummaryPageDisplayed()
				.verFreeDiskSpaceMemoryDisplayed()
				/* .verGroupsMemoryUsageDisplayed() */
				.verOperatingSystemAndProgramsMemoryUsageDisplayed()
				.verTotalSpaceMemoryDisplayed()/*
												 * .verUsersMemoryUsageDisplayed(
												 * )
												 */;
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that total Disk Usage in MB is displayed for following section: 
                     1. Operating system and programs 2. Free Disk Space 3. Total Space.     
    'Precondition  :
    'Date          : 30-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that total Disk Usage in MB is displayed for following section: "
			+ "1. Operating system and programs 2. Free Disk Space 3. Total Space.")
	public void testHappyDay179089() throws Exception {

		gstrTCID = "179089";
		gstrTO = "Verify that total Disk Usage in MB is displayed for following section: "
				+ "1. Operating system and programs 2. Free Disk Space 3. Total Space.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
		SystemStatus objSystemStatus = new SystemStatus(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnSystemStatus1();
		objSystemStatus.clickOnDisk1().verDiskUsageSummaryPageDisplayed()
				.verFreeDiskSpaceMemoryDisplayed()
				.verOperatingSystemAndProgramsMemoryUsageDisplayed()
				.verTotalSpaceMemoryDisplayed();

		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}

}
