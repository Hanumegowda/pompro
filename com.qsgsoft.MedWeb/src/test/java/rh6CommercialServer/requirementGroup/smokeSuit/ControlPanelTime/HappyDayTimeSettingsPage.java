package rh6CommercialServer.requirementGroup.smokeSuit.ControlPanelTime;

import dataObject.ControlPanel_data;
import dataObject.Login_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.ControlPanel;
import page.Home;
import page.Login;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayTimeSettingsPage extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayTimeSettingsPage() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that time and date of the Medweb Server can be set in the Time.     
    'Precondition  :
    'Date          : 24-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that time and date of the Medweb Server can be set in the Time.")
	public void testHappyDay68273() throws Exception {

		gstrTCID = "68273";
		gstrTO = "Verify that time and date of the Medweb Server can be set in the Time.";

		Login_data objLogin_data = new Login_data();
		ControlPanel_data objControlPanel_data = new ControlPanel_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime1().verTimeSettingsPage()
				.selectRequiredMonth(objControlPanel_data.strMonth)
				.selectRequiredDate(objControlPanel_data.strDate)
				.selectRequiredYear(objControlPanel_data.strYear)
				.selectRequiredHour(objControlPanel_data.strHour)
				.selectRequiredMinutes(objControlPanel_data.strMinutes);
		objAddUser.clickOnSaveChanges();
		Thread.sleep(3000);
		objControlPanel
				.verMonth(objControlPanel_data.strMonth)
				.verDate(objControlPanel_data.strDate)
				.verYear(objControlPanel_data.strYear)
				.verHour(objControlPanel_data.strHour)
				.verMinutes(objControlPanel_data.strMinutes)
				.enterTextInNTPServerAddressField(
						objControlPanel_data.nTPServerAddress)
				.clickOnSynchronizeNowButton();
		Thread.sleep(3000);
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}

}
