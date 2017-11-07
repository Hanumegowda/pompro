package rhel6DiacapServer.requirementGroup.smokeSuit.ControlPanelServices;

import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.ControlPanel;
import page.HL7RouterAndServer;
import page.Home;
import page.Login;
import page.RISSettings;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayHL7Router extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayHL7Router() throws Exception {
		super();
		
	}
	
	/*************************************************************************************
    'Description   : Verify that the administrator can enable HL7 Services.     
    'Precondition  :
    'Date          : 13-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the administrator can enable HL7 Services.")
	public void testHappyDay85551() throws Exception {

		gstrTCID = "85551";
		gstrTO = "Verify that the administrator can enable HL7 Services.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		Login objLogin = new Login(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		HL7RouterAndServer objHL7RouterAndServer = new HL7RouterAndServer(
				this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings().clickOnHL7RouterParametersLink();
		objHL7RouterAndServer.selectEnableHL7ServiceCheckbox();
		objRISSettings.clickOnSaveChanges();
		objHL7RouterAndServer.verRunningStatus();
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

}
