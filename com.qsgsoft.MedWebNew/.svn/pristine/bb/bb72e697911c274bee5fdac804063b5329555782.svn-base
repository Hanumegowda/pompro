package rh4CommercialServer.requirementGroup.smokeSuit.ServiceStatus;


import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.Home;
import page.Login;
import page.ServiceStatus;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDaySoftwareInfo extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDaySoftwareInfo() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that current version of Medweb Server is displayed in the "Software
                     On The Medweb Server" page.     
    'Precondition  :
    'Date          : 08-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that current version of Medweb Server is displayed in the "
			+ "Software On The Medweb Server page.")
	public void testHappyDay68305() throws Exception {

		gstrTCID = "68305";
		gstrTO = "Verify that current version of Medweb Server is displayed in the Software"
				+ " On The Medweb Server page.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		ServiceStatus objServiceStatus = new ServiceStatus(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		String str = objViewPatients.getVersionOfTheApp();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		
		objNavigationToSubMenus.clickOnServiceStatus();
		objServiceStatus.verMedwebServerVersionDisplayed(str);

		gstrResult = "PASS";
	}

}
