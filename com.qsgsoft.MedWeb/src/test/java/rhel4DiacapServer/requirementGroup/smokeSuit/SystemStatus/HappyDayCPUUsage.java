package rhel4DiacapServer.requirementGroup.smokeSuit.SystemStatus;

import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.SystemStatus;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayCPUUsage extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayCPUUsage() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that 'CPU Load Average' graph indicating the load on the CPU is 
                     displayed when 'CPU' page.     
    'Precondition  :
    'Date          : 06-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that 'CPU Load Average' graph indicating the load on the CPU is "
			+ "displayed when 'CPU' page.")
	public void testHappyDay68300() throws Exception {

		gstrTCID = "68300";
		gstrTO = "Verify that 'CPU Load Average' graph indicating the load on the CPU is displayed when"
				+ " 'CPU' page.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		SystemStatus objSystemStatus = new SystemStatus(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnSystemStatus();
		objSystemStatus.clickOnCPU().verCPUUsagePage();
		Thread.sleep(10000);
		objSystemStatus.verChangeInCPULoad();
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

}
