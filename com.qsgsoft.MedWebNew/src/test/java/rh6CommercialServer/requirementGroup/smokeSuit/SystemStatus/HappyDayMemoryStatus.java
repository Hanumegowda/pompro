package rh6CommercialServer.requirementGroup.smokeSuit.SystemStatus;

import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.SystemStatus;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayMemoryStatus extends TestNG_UI_EXTENSIONSForOneBrowser {
	public HappyDayMemoryStatus() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Veirfy that the ball icon is displayed in front of the virtual memory 
                     usage information in Memory Status page.     
    'Precondition  :
    'Date          : 25-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Veirfy that the ball icon is displayed in front of the virtual memory usage"
			+ " information in Memory Status page.")
	public void testHappyDay68298() throws Exception {

		gstrTCID = "68298";
		gstrTO = "Veirfy that the ball icon is displayed in front of the virtual memory usage information"
				+ " in Memory Status page.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
		SystemStatus objSystemStatus = new SystemStatus(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnSystemStatus();
		objSystemStatus.verMemoryStatusPage()
				.verBallIconIndicatingMemoryInUse();
		String str = objSystemStatus.getPercentageOfMemoryUsage();
		System.out.println(str);
		String[] str1 = str.split("\\.");
		System.out.println(str1[0]);
		int i = Integer.parseInt((str1[0]).trim());
		assertTrue(i>=1);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the "Active Monitor" button at the bottom of the page shows 
                     CPU memory and Disk status.     
    'Precondition  :
    'Date          : 05-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the 'Active Monitor' button at the bottom of the page shows "
			+ "CPU memory and Disk status.")
	public void testHappyDay93349() throws Exception {

		gstrTCID = "93349";
		gstrTO = "Verify that the 'Active Monitor' button at the bottom of the page shows "
				+ "CPU memory and Disk status.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
		SystemStatus objSystemStatus = new SystemStatus(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objAdministratorSite.clickOnActiveMonitor();
		objSystemStatus.verCpuStatusIsDisplayed().verMemoryStatusIsDisplayed()
				.verDiskStatusIsDisplayed();

		gstrResult = "PASS";

	}

}
