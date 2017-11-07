package rh4CommercialServer.requirementGroup.smokeSuit.ControlPanelServices;

import dataObject.ControlPanel_data;
import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.ControlPanel;
import page.Home;
import page.Login;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayWorkflowProxy extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayWorkflowProxy() throws Exception {
		super();
		
	}
	
	/*************************************************************************************
    'Description   : Verify that when a valid rule for encryption and decryption is created,
                     the tunnel listens on the lsitening port and trasmits data to the destination IP/port.     
    'Precondition  :
    'Date          : 13-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that when a valid rule for encryption and decryption is created, "
			+ "the tunnel listens on the lsitening port and trasmits data to the destination IP/port.")
	public void testHappyDay68191() throws Exception {

		gstrTCID = "68191";
		gstrTO = "Verify that when a valid rule for encryption and decryption is created, the tunnel "
				+ "listens on the lsitening port and trasmits data to the destination IP/port.";

		Login_data objLogin_data = new Login_data();
		ControlPanel_data objControlPanel_data = new ControlPanel_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel
				.verServiceSettings()
				.clickOnWorkflowProxyParametersLink()
				.verWorkflowProxyConfigurationPage()
				.clickOnAddRule()
				.verWorkflowProxyAddNewRulePage()
				.enterTextInListenToPortField(
						objControlPanel_data.strListenToPort)
				.selFunction(objControlPanel_data.strFunction)
				.enterTextInForwardToHostField(
						objControlPanel_data.strForwardToHost)
				.enterTextInPortField(objControlPanel_data.strPort);
		objAddUser.clickOnSaveChanges();
		objControlPanel
				.clickOnAddRule()
				.verWorkflowProxyAddNewRulePage()
				.enterTextInListenToPortField(
						objControlPanel_data.strListenToPort1)
				.selFunction(objControlPanel_data.strFunction1)
				.enterTextInForwardToHostField(
						objControlPanel_data.strForwardToHost)
				.enterTextInPortField(objControlPanel_data.strPort1);
		objAddUser.clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL + ":"
				+ objControlPanel_data.strListenToPort);
		objHome.verHomePage();

		gstrResult = "PASS";

	}

}
