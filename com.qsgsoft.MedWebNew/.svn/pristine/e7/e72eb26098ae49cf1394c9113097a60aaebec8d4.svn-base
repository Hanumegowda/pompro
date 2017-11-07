package rh6CommercialServer.requirementGroup.smokeSuit.RISMachineSchedule;

import java.util.Iterator;
import java.util.Set;

import dataObject.Login_data;
import dataObject.PatientSchedule_data;
import dataObject.RISSettings_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.MachineSchedule;
import page.PatientScheduleRegistration;
import page.RISSettings;
import page.UserManagement;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayMachineSchedule extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayMachineSchedule() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the Machine Event is saved for the selected event, time & doctor and
			         is navigated to Machine Schedule page when 'Save & Back' button is clicked.     
    'Precondition  :
    'Date          : 22-Apr-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Machine Event is saved for the selected event, time & doctor and "
			+ "is navigated to Machine Schedule page when 'Save & Back' button is clicked")
	public void testHappyDay70213() throws Exception {

		gstrTCID = "70213";
		gstrTO = "Verify that the Machine Event is saved for the selected event, time & doctor and is navigated"
				+ " to Machine Schedule page when 'Save & Back' button is clicked";

		Login_data objLogin_data = new Login_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		Home objHome = new Home(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		MachineSchedule objMachineSchedule = new MachineSchedule(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);

		String str1 = objPatientSchedule_data.strPatient;
		String str2 = str1.substring(11);
		String str3 = str1.substring(0, 11);
		String str4 = str2.substring(0, 3);
		System.out.println(str2 + " str2");
		System.out.println(str3 + " str3");
		System.out.println(str4 + " str4");

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
				.enterTextInState(objRISSettings_data.strState)
				.clickOnSaveChanges();
		objRISSettings.verClinic(objRISSettings_data.strClinicName)
				.clickOnClinicLink(objRISSettings_data.strClinicName)
				.clickOnSecAddButton()
				.enterTextInMachineID(objRISSettings_data.strMachineId);
		objRISSettings.selModality(objRISSettings_data.strModalityMr);
		objUserManagement.clickOnOkInAlertPopUp();
		objRISSettings.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite().clickOnMachineSchedule();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objMachineSchedule.verMachineSchedulePage()
				.clickOnMachineLink(objRISSettings_data.strMachineId)
				.clickOnAvailableTimeSlot().verNewMachineEventPage()
				.selDateFromDropDown(objRISSettings_data.strDay)
				.selDateFromDropDown1(objRISSettings_data.strDay1)
				.selBeginTimeHour(objRISSettings_data.strDay)
				.clickOnSelectAllLink().clickOnSearchDoctorIcon();
		String actual;
		String firstSchedule = objRISSettings_data.strDay + ":00-24:00";

		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.equals(mainwindow)) {
				driver.switchTo().window(childwindow);
				actual = objMachineSchedule.selAnyDoctor();
				System.out.println(actual);
				driver.switchTo().window(mainwindow);
				objMachineSchedule.clickOnSaveAndBackButton()
						.clickOnRequiredDate(objRISSettings_data.strDay)
						.verScheduledEvent(firstSchedule, actual)
						.clickOnRequiredDate(objRISSettings_data.strDay1)
						.verScheduledEvent(firstSchedule, actual);
			}
		}

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the Clinics and Machines added in 'Administrator Site > Clinics
                     & Machines' are displayed in the Machine Schedule page.     
    'Precondition  :
    'Date          : 16-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Clinics and Machines added in 'Administrator Site > Clinics"
			+ " & Machines' are displayed in the Machine Schedule page.")
	public void testHappyDay68461() throws Exception {

		gstrTCID = "68461";
		gstrTO = "Verify that the Clinics and Machines added in 'Administrator Site > Clinics & Machines'"
				+ " are displayed in the Machine Schedule page.";

		Login_data objLogin_data = new Login_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		Home objHome = new Home(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		MachineSchedule objMachineSchedule = new MachineSchedule(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);

		String str1 = objPatientSchedule_data.strPatient;
		String str2 = str1.substring(11);
		String str3 = str1.substring(0, 11);
		String str4 = str2.substring(0, 3);
		System.out.println(str2 + " str2");
		System.out.println(str3 + " str3");
		System.out.println(str4 + " str4");

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
				.enterTextInState(objRISSettings_data.strState)
				.clickOnSaveChanges();
		objRISSettings.verClinic(objRISSettings_data.strClinicName)
				.clickOnClinicLink(objRISSettings_data.strClinicName)
				.clickOnSecAddButton()
				.enterTextInMachineID(objRISSettings_data.strMachineId);
		System.out.println(objRISSettings_data.strClinicName + " clinic name");
		System.out.println(objRISSettings_data.strMachineId + " machine id");
		objRISSettings.selModality(objRISSettings_data.strModalityMr);
		objUserManagement.clickOnOkInAlertPopUp();
		objRISSettings.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite().clickOnMachineSchedule();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		System.out.println(objRISSettings_data.strMachineId);
		objMachineSchedule
				.verMachineSchedulePage()
				.verClinicInMachineSchedulePage(
						objRISSettings_data.strClinicName)
				.verMachineInMachineSchedulePage(
						objRISSettings_data.strMachineId);
		objPatientScheduleRegistration.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the 'New Machine Event' page is displayed when 'Create New Event'
                     button is clicked.     
    'Precondition  :
    'Date          : 17-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the 'New Machine Event' page is displayed when 'Create New Event' button is clicked.")
	public void testHappyDay68463() throws Exception {

		gstrTCID = "68463";
		gstrTO = "Verify that the 'New Machine Event' page is displayed when 'Create New Event' button is clicked.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		Login objLogin = new Login(this.driver);
		MachineSchedule objMachineSchedule = new MachineSchedule(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver); 

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage();
		objNavigationToSubMenus.clickOnMachineSchedule();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objMachineSchedule.verMachineSchedulePage()
				.clickOnCreateNewEventButton().verNewMachineEventPage();
		objPatientScheduleRegistration.clickOnLogOut();

		gstrResult = "PASS";

	}

}
