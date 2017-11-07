package rh4CommercialServer.requirementGroup.smokeSuit.ControlPanelServices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import dataObject.ControlPanel_data;
import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.ControlPanel;
import page.DICOMRemapping;
import page.Home;
import page.Login;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayPatientPageLayout extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayPatientPageLayout() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that New Layout saved is displayed in the "Layout" dropdown in View
                     Patients page.     
    'Precondition  :
    'Date          : 03-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that New Layout saved is displayed in the Layout dropdown in"
			+ " View Patients page.")
	public void testHappyDay125357() throws Exception {

		gstrTCID = "125357";
		gstrTO = "Verify that New Layout saved is displayed in the Layout dropdown in View Patients page.";

		Login_data objLogin_data = new Login_data();
		ControlPanel_data objControlPanel_data = new ControlPanel_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		DICOMRemapping objDICOMRemapping = new DICOMRemapping(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnPatientsPageLayoutParametersLink().clickOnClone()
				.enterLayoutText(objControlPanel_data.strLayout);
		objDICOMRemapping.clickOnSave();
		Thread.sleep(5000);
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		System.out.println(objControlPanel_data.strLayout);
		System.out.println(((objControlPanel_data.strLayout).split("="))[1]);
		System.out.println((((objControlPanel_data.strLayout).split("="))[1])
				.trim());
		objViewPatients.selLayout(
				(((objControlPanel_data.strLayout).split("="))[1]).trim())
				.clickOnSearch();
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
}
