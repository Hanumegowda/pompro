package rh6CommercialServer.requirementGroup.smokeSuit.ControlPanelServices;

import dataObject.Login_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.ControlPanel;
import page.HL7RouterAndServer;
import page.Home;
import page.Login;
import page.RISSettings;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayHL7Server extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayHL7Server() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that admin can enable the HL7 Server.     
    'Precondition  :
    'Date          : 17-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that admin can enable the HL7 Server.")
	public void testHappyDay85556() throws Exception {

		gstrTCID = "85556";
		gstrTO = "Verify that admin can enable the HL7 Server.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		Login objLogin = new Login(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		HL7RouterAndServer objHL7RouterAndServer = new HL7RouterAndServer(
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
		objControlPanel.verServiceSettings().clickOnHL7ServerParametersLink();
		objHL7RouterAndServer.selectEnableHL7ServiceCheckboxInHL7ServerPage();
		objAddUser.clickOnSaveChanges(); 
		objHL7RouterAndServer.verHL7ServerRunningStatus();
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}

}
