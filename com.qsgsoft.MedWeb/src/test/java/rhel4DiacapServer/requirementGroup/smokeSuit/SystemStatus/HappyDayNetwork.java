package rhel4DiacapServer.requirementGroup.smokeSuit.SystemStatus;

import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.SystemStatus;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayNetwork extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayNetwork() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that following columns are displayed in Network Usage page: 1. Network
                     Packets 2. Sent 3. Received.     
    'Precondition  :
    'Date          : 30-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that following columns are displayed in Network Usage page: "
			+ "1. Network Packets 2. Sent 3. Received.")
	public void testHappyDay68302() throws Exception {

		gstrTCID = "68302";
		gstrTO = "Verify that following columns are displayed in Network Usage page: 1. Network Packets"
				+ " 2. Sent 3. Received.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		SystemStatus objSystemStatus = new SystemStatus(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnSystemStatus();
		objSystemStatus.clickOnNetwork().verNetworkUsagePageDisplayed();
		objSystemStatus.verCollisionsIsDisplayedInNetworkPacketsColumn()
				.verDroppedIsDisplayedInNetworkPacketsColumn()
				.verErrorIsDisplayedInNetworkPacketsColumn()
				.verGoodIsDisplayedInNetworkPacketsColumn()
				.verSentColumnIsDisplayed().verReceivedColumnIsDisplayed();
		String val = objSystemStatus.getValueFromSentColumnOfRowGood();
		System.out.println(val);
		String vai1 = objSystemStatus.getValueFromReceivedColumnOfRowGood();
		System.out.println(vai1);
		assertTrue(Integer.parseInt((val).trim()) > 100);
		assertTrue(Integer.parseInt((vai1).trim()) > 100);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

}
