package rh6CommercialServer.requirementGroup.smokeSuit.ServiceStatus;


import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.ServiceStatus;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDaySNMP extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDaySNMP() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the status of the SNMP service is displayed in "SNMP" status page.     
    'Precondition  :
    'Date          : 09-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the status of the SNMP service is displayed in 'SNMP' status page.")
	public void testHappyDay125354() throws Exception {

		gstrTCID = "125354";
		gstrTO = "Verify that the status of the SNMP service is displayed in 'SNMP' status page.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ServiceStatus objServiceStatus = new ServiceStatus(this.driver);
		Login objLogin = new Login(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnServiceStatus();
		objServiceStatus.clickOnSNMP().verServiceStatusSNMPIsDisplayed();

		gstrResult = "PASS";

	}

}
