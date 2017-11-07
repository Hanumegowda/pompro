package rhel6DiacapServer.requirementGroup.smokeSuit.SystemStatus;

import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.SystemStatus;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayModem extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayModem() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : The following information about the Modem is dsipalyed in the Modem Status table 
                     1. Status 2. Time Connected 3. Bytes Received 4. Bytes Trasmitted.     
    'Precondition  :
    'Date          : 02-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "The following information about the Modem is dsipalyed in the Modem Status table "
			+ "1. Status 2. Time Connected 3. Bytes Received 4. Bytes Trasmitted.")
	public void testHappyDay68303() throws Exception {

		gstrTCID = "68303";
		gstrTO = "The following information about the Modem is dsipalyed in the Modem Status table "
				+ "1. Status 2. Time Connected 3. Bytes Received 4. Bytes Trasmitted.";

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
		objSystemStatus.clickOnModem().verModemStatusPageDisplayed()
				.verBytesReceivedRowDisplayed()
				.verBytesTransmittedRowDisplayed()
				.verTimeConnectedRowDisplayed().verStatusRowDisplayed();
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

}
