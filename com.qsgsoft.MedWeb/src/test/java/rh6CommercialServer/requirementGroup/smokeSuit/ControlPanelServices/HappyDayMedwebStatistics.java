package rh6CommercialServer.requirementGroup.smokeSuit.ControlPanelServices;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.ControlPanel;
import page.Home;
import page.Login;
import page.MedwebSecureTunnel;
import page.Statistics;
import page.UserManagement;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayMedwebStatistics extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayMedwebStatistics() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the user can access the Statistics from the remote server on
                     the host server if the status is 'Available'.     
    'Precondition  :
    'Date          : 14-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the user can access the Statistics from the remote server on "
			+ "the host server if the status is 'Available'.")
	public void testHappyDay165867() throws Exception {

		gstrTCID = "165867";
		gstrTO = "Verify that the user can access the Statistics from the remote server on the host"
				+ " server if the status is 'Available'.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		MedwebSecureTunnel objMedwebSecureTunnel = new MedwebSecureTunnel(
				this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
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
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objControlPanel.clickOnAdd();
		objMedwebSecureTunnel.enterTextInRemoteHostPublicKeySection(str3);
		objAddUser.clickOnSaveChanges();
		objMedwebSecureTunnel.clickOnGenerateButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		String str2 = objMedwebSecureTunnel
				.getTextFromLocalhostPublicKeySection();
		String str4 = str2.trim();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();

		objControlPanel.clickOnAdd();
		objMedwebSecureTunnel.enterTextInRemoteHostPublicKeySection(str4);
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnMedwebStatisticsParametersLink()
				.clickOnStatisticsServersTab().clickOnAddNewServer()
				.selServerName(objDICOMSettings_data.ipAddress)
				.clickOnSaveChanges();
		Thread.sleep(5000);
		objControlPanel.verAvailableStatus(objDICOMSettings_data.ipAddress);
		objNavigationToSubMenus.clickOnLogout();
		objHome.clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics.clickOnRadiology().clickOnRemoteClinicsLinks()
				.verServerLinkIsPresent(objDICOMSettings_data.ipAddress);

		gstrResult = "PASS";

	}

}
