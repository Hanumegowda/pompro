package rh4CommercialServer.requirementGroup.smokeSuit.RISSettings;

import dataObject.Login_data;
import dataObject.RISSettings_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.PatientScheduleRegistration;
import page.RISSettings;
import page.UserManagement;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayClinicsAndMachines extends TestNG_UI_EXTENSIONSForOneBrowser {
	public HappyDayClinicsAndMachines() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the saved clinic is displayed in the Clinic List section of 
                     Clinics and Machines' page.     
    'Precondition  :
    'Date          : 21-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the saved clinic is displayed in the Clinic List section of"
			+ " Clinics and Machines' page.")
	public void testHappyDay62755() throws Exception {

		gstrTCID = "62755";
		gstrTO = "Verify that the saved clinic is displayed in the Clinic List section of Clinics"
				+ " and Machines' page.";

		Login_data objLogin_data = new Login_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnRISSettings();
		objRISSettings.clickClinicsAndMachines();
		objAddUser.clickOnAddInMedicalLicensesPage();
		objRISSettings.enterTextInAddress(objRISSettings_data.strAdrress)
				.enterTextInEmail(objRISSettings_data.strEmail)
				.enterTextInMTF(objRISSettings_data.strMtf)
				.enterTextInName(objRISSettings_data.strClinicName)
				.enterTextInPhone(objRISSettings_data.strPhone)
				.enterTextInState(objRISSettings_data.strState);
		objAddUser.clickOnSaveChanges();
		objRISSettings.verClinic(objRISSettings_data.strClinicName);

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that Clinics and Machines added at RIS settings is displayed in Patient Schedule page.     
    'Precondition  :
    'Date          : 29-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date : 17-Dec-2015(old ID:148815)                   Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Clinics and Machines added at RIS settings is displayed in Patient Schedule page.")
	public void testHappyDay171659() throws Exception {

		gstrTCID = "171659";
		gstrTO = "Verify that Clinics and Machines added at RIS settings is displayed in Patient Schedule page.";

		Login_data objLogin_data = new Login_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnRISSettings();
		objRISSettings.clickClinicsAndMachines();
		objAddUser.clickOnAddInMedicalLicensesPage();
		String req = (objRISSettings_data.strClinicName).substring(0, 6);
		System.out.println(req + " reqclinic");
		objRISSettings.enterTextInAddress(objRISSettings_data.strAdrress)
				.enterTextInEmail(objRISSettings_data.strEmail)
				.enterTextInMTF(objRISSettings_data.strMtf)
				.enterTextInName(objRISSettings_data.strClinicName)
				.enterTextInPhone(objRISSettings_data.strPhone)
				.enterTextInState(objRISSettings_data.strState)
				.enterTextInDescription(objRISSettings_data.strdescription)
				.enterTextInCity(objRISSettings_data.strCity)
				.enterTextInZip(objRISSettings_data.strZip)
				.enterTextInContact(objRISSettings_data.strZip)
				.enterTextInFax(objRISSettings_data.strZip)
				.enterTextInWeb(objRISSettings_data.strWeb);
		objRISSettings.clickOnSaveChanges();
		objRISSettings.verClinic(objRISSettings_data.strClinicName)
				.clickOnClinicLink(objRISSettings_data.strClinicName)
				.clickOnSecAddButton()
				.enterTextInMachineID(objRISSettings_data.strMachineId1)
				.enterTextInPhoneAddMachine(objRISSettings_data.strPhone)
				.enterTextInInfo(objRISSettings_data.strInfo)
				.enterTextInLocation(objRISSettings_data.strState)
				.selModality(objRISSettings_data.strModality);
		objUserManagement.clickOnOkInAlertPopUp();
		objRISSettings.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnPatientSchedule();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objPatientScheduleRegistration.clickOnEnterOrder();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration
				.selModality(objRISSettings_data.strModality);
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration
				.selClinic(objRISSettings_data.strClinicName);
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration
				.selMachine(objRISSettings_data.strMachineId1)
				.clickOnScheduler()
				.verClinicsAndMachines(objRISSettings_data.strClinicName,
						objRISSettings_data.strMachineId1);

		gstrResult = "PASS";
	}

}
