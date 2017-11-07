package rhel6DiacapServer.requirementGroup.smokeSuit.RISMonitor;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import dataObject.Login_data;
import dataObject.PatientSchedule_data;
import dataObject.RISSettings_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.Destinations;
import page.Home;
import page.Login;
import page.Monitor;
import page.PatientScheduleRegistration;
import page.RISSettings;
import page.UserManagement;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayMonitor extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayMonitor() throws Exception{
		super();
	}
	public List<String> l1;
	
	/*************************************************************************************
    'Description   : Verify that the Patient Name and description entered in Web Scheduler page 
                     is displayed in the box corresponding to the selected time slot & Machine.     
    'Precondition  :
    'Date          : 25-May-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Patient Name and description entered in Web Scheduler page is"
			+ " displayed in the box corresponding to the selected time slot & Machine.")
	public void testHappyDay107967() throws Exception {

		gstrTCID = "107967";
		gstrTO = "Verify that the Patient Name and description entered in Web Scheduler page is displayed in"
				+ " the box corresponding to the selected time slot & Machine.";

		Login_data objLogin_data = new Login_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		Home objHome = new Home(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Monitor objMonitor = new Monitor(this.driver);

		String str1 = objPatientSchedule_data.strPatient;
		String str2 = str1.substring(11);
		String str3 = str1.substring(0, 11);
		String str4 = str2.substring(0, 3);
		System.out.println(str2 + " str2");
		System.out.println(str3 + " str3");
		System.out.println(str4 + " str4");

		objHome.launchApplication(objLogin_data.strAppURL);
		Thread.sleep(5000);
		String w1 = driver.getWindowHandle();
		System.out.println(w1);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnRISSettings();
		objRISSettings.clickOnOpenPageOfMandatoryFields()
				.clickOnPatientRegistrationLink().clickOnSetDefault()
				.clickOnSaveChanges();
		objRISSettings.clickOnEnterOrderLink().clickOnSetDefault()
				.clickOnSaveChanges();
		objRISSettings.clickOnClinicProcedure();
		List<String> l = objRISSettings.selClinicProcedureCheckbox();
		System.out.println(l.size());
		System.out.println(l.get(0));
		System.out.println(l.get(2));
		System.out.println(l.get(3));
		System.out.println(l.get(1));
		objDestinations.clickOnSaveChanges();
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
				.enterTextInMachineID(objRISSettings_data.strMachineId)
				.selAlwaysAvailableRadioButton();
		objRISSettings.selModality(objRISSettings_data.strModalityMr);
		objUserManagement.clickOnOkInAlertPopUp();
		System.out.println(objRISSettings_data.strMachineId);
		objRISSettings.clickOnSaveChanges();
		for (int i = 1; i <= 2; i++) {
			objHome.launchApplication(objLogin_data.strAppURL);
			objHome.verHomePage();
			objHome.clickOnPatientSchedule();
			objLogin.loginAsUser(objLogin_data.strAdminUser,
					objLogin_data.strAdminUserPwd).clickLogin();
			objPatientScheduleRegistration.verPatientRegistrationPage()
					.enterTextInLastName(str2).enterTextInFirstName(str3)
					.enterTextInAddress(objPatientSchedule_data.strAddress)
					.enterTextInCity(objPatientSchedule_data.strCity)
					.enterTextInCountry(objPatientSchedule_data.strCountry)
					.enterTextInZip(objPatientSchedule_data.strZip)
					.selState(objPatientSchedule_data.strState)
					.clickOnSavePatientData();
			objUserManagement.clickOnOkInAlertPopUp();
			objPatientScheduleRegistration.clickOnCreateTheOrder();
			objUserManagement.clickOnOkInAlertPopUp();
			objPatientScheduleRegistration.selModality(
					objRISSettings_data.strModalityMr).selClinic(
					objRISSettings_data.strClinicName);
			l1 = objPatientScheduleRegistration.enterTextInProcedureCode(l);
			objPatientScheduleRegistration.clickOnSave();
			objPatientScheduleRegistration.clickOnLogOut();
		}

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage();
		objHome.clickOnMonitor();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objMonitor.deSelectAllMachinesCheckbox()
				.selectAMachineCheckbox(objRISSettings_data.strMachineId)
				.clickOnOpenCentralRadiologyMonitorButton();
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr = aw.iterator();
		while (itr.hasNext()) {
			String cw = itr.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				System.out.println(l1.get(0));
				System.out.println(l1.get(1));
				System.out.println(l1.get(2));
				System.out.println(l1.get(3));
				objMonitor.verMachineDescriptionIsDisplayed(l, l1, str2 + " "
						+ str3.toUpperCase());
				driver.close();
			}
		}
		driver.switchTo().window(mw);
		objPatientScheduleRegistration.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the 'Central Radiology' page is opened when 'Monitor' button is
                     clicked in Public Site Page.     
    'Precondition  :
    'Date          : 17-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the 'Central Radiology' page is opened when 'Monitor' button is"
			+ " clicked in Public Site Page.")
	public void testHappyDay70553() throws Exception {

		gstrTCID = "70553";
		gstrTO = "Verify that the 'Central Radiology' page is opened when 'Monitor' button is clicked "
				+ "in Public Site Page.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		Login objLogin = new Login(this.driver);
		Monitor objMonitor = new Monitor(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnMonitor();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objMonitor.verCentralRadiologyPage();
		objPatientScheduleRegistration.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the time range for viewing graphical representation of the schedule 
                     of current appointments is dispayed in the left box of 'Central Radiology' page.     
    'Precondition  :
    'Date          : 18-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the time range for viewing graphical representation of the schedule"
			+ " of current appointments is dispayed in the left box of 'Central Radiology' page.")
	public void testHappyDay70554() throws Exception {

		gstrTCID = "70554";
		gstrTO = "Verify that the time range for viewing graphical representation of the schedule of "
				+ "current appointments is dispayed in the left box of 'Central Radiology' page.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		Login objLogin = new Login(this.driver);
		Monitor objMonitor = new Monitor(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnMonitor();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objMonitor.verCentralRadiologyPage()
				.verDiffTimeRangesForCentralRadiologyMonitorIsDisplaying();
		objPatientScheduleRegistration.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the Machines for viewing the central radiology monitor is displayed
                     on the right box of 'Central Radiology' window.     
    'Precondition  :
    'Date          : 21-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Machines for viewing the central radiology monitor is displayed"
			+ " on the right box of 'Central Radiology' window.")
	public void testHappyDay70556() throws Exception {

		gstrTCID = "70556";
		gstrTO = "Verify that the Machines for viewing the central radiology monitor is displayed on the "
				+ "right box of 'Central Radiology' window.";

		Login_data objLogin_data = new Login_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		Home objHome = new Home(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Monitor objMonitor = new Monitor(this.driver);

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
				.enterTextInMachineID(objRISSettings_data.strMachineId)
				.selAlwaysAvailableRadioButton();
		objRISSettings.selModality(objRISSettings_data.strModalityMr);
		objUserManagement.clickOnOkInAlertPopUp();
		System.out.println(objRISSettings_data.strMachineId);
		objRISSettings.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnMonitor();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objMonitor.verCentralRadiologyPage().verMachineInCentralRadiologyPage(
				objRISSettings_data.strMachineId);
		objPatientScheduleRegistration.clickOnLogOut();

		gstrResult = "PASS";

	}

}
