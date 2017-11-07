package rh4CommercialServer.requirementGroup.smokeSuit.SystemStatus;

import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.ControlPanel;
import page.Home;
import page.Login;
import page.SystemStatus;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayUptime extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayUptime() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that 'Uptime' & 'current System Time' is displayed in 'Uptime' Page.     
    'Precondition  :
    'Date          : 02-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that 'Uptime' & 'current System Time' is displayed in 'Uptime' Page.")
	public void testHappyDay68304() throws Exception {

		gstrTCID = "68304";
		gstrTO = "Verify that 'Uptime' & 'current System Time' is displayed in 'Uptime' Page.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		SystemStatus objSystemStatus = new SystemStatus(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime();
		String str1 = objControlPanel.getCurrentDate();
		int i = Integer.parseInt(str1);
		String str2 = objControlPanel.getCurrentMonth();
		String str5 = Integer.toString(i);
		String str4 = str2 + " " + str5;
		System.out.println(str4 + "required");
		objNavigationToSubMenus.clickOnSystemStatus();
		objSystemStatus.clickOnUptime().verUptimeSummaryPageDisplayed()
				.verUptimeRowDisplayed().verCurrentSystemTimeRowDisplayed(str4);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

}
