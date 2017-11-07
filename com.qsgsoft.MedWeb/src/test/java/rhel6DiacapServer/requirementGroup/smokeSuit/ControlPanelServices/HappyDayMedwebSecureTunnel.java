package rhel6DiacapServer.requirementGroup.smokeSuit.ControlPanelServices;

import dataObject.Login_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.ControlPanel;
import page.Home;
import page.Login;
import page.MedwebSecureTunnel;
import page.Network;
import page.UserManagement;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayMedwebSecureTunnel extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayMedwebSecureTunnel() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that when public key of the sending server is added, host name of
                     the server is displayed in the list of 'Known remote hosts'.     
    'Precondition  :
    'Date          : 07-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that when public key of the sending server is added, host name"
			+ " of the server is displayed in the list of 'Known remote hosts'.")
	public void testHappyDay78048() throws Exception {

		gstrTCID = "78048";
		gstrTO = "Verify that when public key of the sending server is added, host name of "
				+ "the server is displayed in the list of 'Known remote hosts'.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		Network objNetwork = new Network(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		MedwebSecureTunnel objMedwebSecureTunnel = new MedwebSecureTunnel(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnNetwork();
		String strHostName = objNetwork.getHostName();
		System.out.println(strHostName);
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objMedwebSecureTunnel.clickOnGenerateButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		String str1 = objMedwebSecureTunnel
				.getTextFromLocalhostPublicKeySection();
		String str3 = str1.trim();
		System.out.println(str3);
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objMedwebSecureTunnel.delHostNameOfServer();
		objControlPanel.clickOnAdd();
		objMedwebSecureTunnel.enterTextInRemoteHostPublicKeySection(str3);
		objAddUser.clickOnSaveChanges();
		objMedwebSecureTunnel.verHostNameOfServer(strHostName);
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}

}
