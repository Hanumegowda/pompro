package rh4CommercialServer.requirementGroup.smokeSuit.RISSettings;

import dataObject.Login_data;
import dataObject.RISSettings_data;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.PatientScheduleRegistration;
import page.RISSettings;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayRISSettingsGeneral extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayRISSettingsGeneral() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the Patient ID Prefix in Patient Registration page starts with the
                     value specified in the Patient ID prefix field in RIS settings.     
    'Precondition  :
    'Date          : 15-Jun-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Patient ID Prefix in Patient Registration page starts with"
			+ " the value specified in the Patient ID prefix field in RIS settings.")
	public void testHappyDay68182() throws Exception {

		gstrTCID = "68182";
		gstrTO = "Verify that the Patient ID Prefix in Patient Registration page starts with the value "
				+ "specified in the Patient ID prefix field in RIS settings.";

		Login_data objLogin_data = new Login_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		String str = objRISSettings_data.strLocation.substring(13);
		objHome.launchApplication(objLogin_data.strAppURL);
		
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
        System.out.println(str);
		objNavigationToSubMenus.clickOnRISSettings();
		objRISSettings
				.clickOnOpenPageOfGeneralRISSettings()
				.enterTextInPatientIDPrefix(
						str)
				.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnPatientSchedule();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objPatientScheduleRegistration
				.verPatientIdPrefix(str);

		gstrResult = "PASS";
	}

}
