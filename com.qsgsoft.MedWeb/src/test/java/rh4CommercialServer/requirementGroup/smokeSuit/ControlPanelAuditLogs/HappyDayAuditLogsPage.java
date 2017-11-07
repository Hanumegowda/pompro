package rh4CommercialServer.requirementGroup.smokeSuit.ControlPanelAuditLogs;

import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.AuditLogs;
import page.ControlPanel;
import page.Home;
import page.Login;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayAuditLogsPage extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayAuditLogsPage() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that 'Admin' can access the Control Panel > Audit Logs page.     
    'Precondition  :
    'Date          : 25-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that 'Admin' can access the Control Panel > Audit Logs page.")
	public void testHappyDay68275() throws Exception {

		gstrTCID = "68275";
		gstrTO = "Verify that 'Admin' can access the Control Panel > Audit Logs page.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		Login objLogin = new Login(this.driver);
		AuditLogs objAuditLogs = new AuditLogs(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnAuditLogs();
		objAuditLogs.verAuditLogsPage();

		gstrResult = "PASS";

	}

}
