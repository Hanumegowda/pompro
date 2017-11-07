package rhel6DiacapServer.requirementGroup.smokeSuit.RISPatientSchedule;

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

public class HappyDayOrderSearch extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayOrderSearch() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the total number of Orders created is displayed when 'All Days' 
                     is selected from the Time Period' dropdown.     
    'Precondition  :
    'Date          : 13-Apr-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the total number of Orders created is displayed when 'All Days' is "
			+ "selected from the Time Period' dropdown")
	public void testHappyDay62741() throws Exception {

		gstrTCID = "62741";
		gstrTO = "Verify that the total number of Orders created is displayed when 'All Days' is selected from"
				+ " the Time Period' dropdown";

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
		objRISSettings.clickOnOpenPageOfMandatoryFields()
				.clickOnPatientRegistrationLink().clickOnSetDefault()
				.clickOnSaveChanges();
		objRISSettings.clickOnEnterOrderLink().clickOnSetDefault()
				.clickOnSaveChanges();
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
		System.out.println(objRISSettings_data.strMachineId);
		objMachineSchedule.verMachineSchedulePage()
				.clickOnMachineLink(objRISSettings_data.strMachineId)
				.clickOnAvailableTimeSlot().verNewMachineEventPage()
				.clickOnSearchDoctorIcon();
		String actual;
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
				objMachineSchedule.clickOnSaveAndBackButton();
			}
		}
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage();
		objHome.clickOnPatientSchedule();
		objPatientScheduleRegistration.verPatientRegistrationPage()
				.clickOnSearchOrders()
				.selTimePeriod(objPatientSchedule_data.strTimePeriod);
		objPatientScheduleRegistration.clickOnSearchOrdersInOrderSearchPage();
		String actual1 = objPatientScheduleRegistration.getOrderCount();
		int i1 = Integer.parseInt(actual1);
		objHome.clickOnPatientSchedule()/*clickOnPatientScheduleForSecTime()*/;
		objPatientScheduleRegistration.enterTextInLastName(str2)
				.enterTextInFirstName(str3)
				.enterTextInAddress(objPatientSchedule_data.strAddress)
				.enterTextInCity(objPatientSchedule_data.strCity)
				.enterTextInCountry(objPatientSchedule_data.strCountry)
				.enterTextInZip(objPatientSchedule_data.strZip)
				.selState(objPatientSchedule_data.strState)
				.clickOnSavePatientData();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration.clickOnCreateTheOrder();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration
				.selModality(objRISSettings_data.strModalityMr)
				.selClinic(objRISSettings_data.strClinicName).selStatCheckbox()
				.clickOnSave();
		objPatientScheduleRegistration.clickOnSearchOrders().selTimePeriod(
				objPatientSchedule_data.strTimePeriod);
		objPatientScheduleRegistration.clickOnSearchOrdersInOrderSearchPage();
		String actual11 = objPatientScheduleRegistration.getOrderCount();
		int i2 = Integer.parseInt(actual11);
		objPatientScheduleRegistration.verOrdersCount(i1, i2);
		objPatientScheduleRegistration.enterTextInPatientNameIdSSN(str2)
				.clickOnSearchOrdersInOrderSearchPage()
				.verOrdersDisplayed(str2);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the Orders created for a particular Modality is displayed when 
                     modality is selected from the 'Modality' dropdown.     
    'Precondition  :
    'Date          : 10-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Orders created for a particular Modality is displayed when "
			+ "modality is selected from the 'Modality' dropdown.")
	public void testHappyDay68456() throws Exception {

		gstrTCID = "68456";
		gstrTO = "Verify that the Orders created for a particular Modality is displayed when modality"
				+ " is selected from the 'Modality' dropdown.";

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
		objRISSettings.clickOnOpenPageOfMandatoryFields()
				.clickOnPatientRegistrationLink().clickOnSetDefault()
				.clickOnSaveChanges();
		objRISSettings.clickOnEnterOrderLink().clickOnSetDefault()
				.clickOnSaveChanges();
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
		System.out.println(objRISSettings_data.strMachineId);
		objMachineSchedule.verMachineSchedulePage()
				.clickOnMachineLink(objRISSettings_data.strMachineId)
				.clickOnAvailableTimeSlot().verNewMachineEventPage()
				.clickOnSearchDoctorIcon();
		String actual;
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
				objMachineSchedule.clickOnSaveAndBackButton();
			}
		}
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage();
		objHome.clickOnPatientSchedule();
		objPatientScheduleRegistration.enterTextInLastName(str2)
				.enterTextInFirstName(str3)
				.enterTextInAddress(objPatientSchedule_data.strAddress)
				.enterTextInCity(objPatientSchedule_data.strCity)
				.enterTextInCountry(objPatientSchedule_data.strCountry)
				.enterTextInZip(objPatientSchedule_data.strZip)
				.selState(objPatientSchedule_data.strState)
				.clickOnSavePatientData();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration.clickOnCreateTheOrder();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration
				.selModality(objRISSettings_data.strModalityMr)
				.selClinic(objRISSettings_data.strClinicName).selStatCheckbox()
				.clickOnSave();
		objPatientScheduleRegistration.clickOnSearchOrders()
				.selTimePeriod(objPatientSchedule_data.strTimePeriod1)
				.selModalityInSearchOrder(objRISSettings_data.strModalityMr);
		Thread.sleep(3000);
		objPatientScheduleRegistration
				.enterTextInPatientNameIdSSN(str3.toUpperCase())
				.clickOnSearchOrdersInOrderSearchPage()
				.verOrdersDisplayed(str2);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the Orders created for a Machine is displayed when 'Machine'
                     is selected from the Machine dropdown.     
    'Precondition  :
    'Date          : 11-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Orders created for a Machine is displayed when 'Machine'"
			+ " is selected from the Machine dropdown.")
	public void testHappyDay68457() throws Exception {

		gstrTCID = "68457";
		gstrTO = "Verify that the Orders created for a Machine is displayed when 'Machine' is selected"
				+ " from the Machine dropdown.";

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
		objRISSettings.clickOnOpenPageOfMandatoryFields()
				.clickOnPatientRegistrationLink().clickOnSetDefault()
				.clickOnSaveChanges();
		objRISSettings.clickOnEnterOrderLink().clickOnSetDefault()
				.clickOnSaveChanges();
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
		objMachineSchedule.verMachineSchedulePage()
				.clickOnMachineLink(objRISSettings_data.strMachineId)
				.clickOnAvailableTimeSlot().verNewMachineEventPage()
				.clickOnSearchDoctorIcon();
		String actual;
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
				objMachineSchedule.clickOnSaveAndBackButton();
			}
		}
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage();
		objHome.clickOnPatientSchedule();
		objPatientScheduleRegistration.enterTextInLastName(str2)
				.enterTextInFirstName(str3)
				.enterTextInAddress(objPatientSchedule_data.strAddress)
				.enterTextInCity(objPatientSchedule_data.strCity)
				.enterTextInCountry(objPatientSchedule_data.strCountry)
				.enterTextInZip(objPatientSchedule_data.strZip)
				.selState(objPatientSchedule_data.strState)
				.clickOnSavePatientData();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration.clickOnCreateTheOrder();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration
				.selModality(objRISSettings_data.strModalityMr)
				.selClinic(objRISSettings_data.strClinicName).selStatCheckbox()
				.clickOnSave();
		objPatientScheduleRegistration
				.clickOnSearchOrders()
				.selTimePeriod(objPatientSchedule_data.strTimePeriod1)
				.selMachineInSearchOrder(
						objRISSettings_data.strMachineId + ": "
								+ objRISSettings_data.strModalityMr);
		Thread.sleep(3000);
		objPatientScheduleRegistration
				.enterTextInPatientNameIdSSN(str3.toUpperCase())
				.clickOnSearchOrdersInOrderSearchPage()
				.verOrdersDisplayed(str2);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the 'Scheduler' page is opened when 'Scheduler' link is clicked
                     next to a Order in 'Order Search' page.     
    'Precondition  :
    'Date          : 14-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the 'Scheduler' page is opened when 'Scheduler' link is clicked "
			+ "next to a Order in 'Order Search' page.")
	public void testHappyDay68459() throws Exception {

		gstrTCID = "68459";
		gstrTO = "Verify that the 'Scheduler' page is opened when 'Scheduler' link is clicked next to "
				+ "a Order in 'Order Search' page.";

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
		objRISSettings.clickOnOpenPageOfMandatoryFields()
				.clickOnPatientRegistrationLink().clickOnSetDefault()
				.clickOnSaveChanges();
		objRISSettings.clickOnEnterOrderLink().clickOnSetDefault()
				.clickOnSaveChanges();
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
		objMachineSchedule.verMachineSchedulePage()
				.clickOnMachineLink(objRISSettings_data.strMachineId)
				.clickOnAvailableTimeSlot().verNewMachineEventPage()
				.clickOnSearchDoctorIcon();
		String actual;
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
				objMachineSchedule.clickOnSaveAndBackButton();
			}
		}
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage();
		objHome.clickOnPatientSchedule();
		objPatientScheduleRegistration.enterTextInLastName(str2)
				.enterTextInFirstName(str3)
				.enterTextInAddress(objPatientSchedule_data.strAddress)
				.enterTextInCity(objPatientSchedule_data.strCity)
				.enterTextInCountry(objPatientSchedule_data.strCountry)
				.enterTextInZip(objPatientSchedule_data.strZip)
				.selState(objPatientSchedule_data.strState)
				.clickOnSavePatientData();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration.clickOnCreateTheOrder();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration
				.selModality(objRISSettings_data.strModalityMr)
				.selClinic(objRISSettings_data.strClinicName).selStatCheckbox()
				.clickOnSave();
		objPatientScheduleRegistration.clickOnSearchOrders().selTimePeriod(
				objPatientSchedule_data.strTimePeriod1);
		objPatientScheduleRegistration
				.enterTextInPatientNameIdSSN(str3.toUpperCase())
				.clickOnSearchOrdersInOrderSearchPage()
				.verOrdersDisplayed(str2)
				.clickOnSchedulerLinkOfOrder(str3.toUpperCase())
				.verOrderSchedulerPage().verScheduledOrder(str3.toUpperCase());

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the Report Search page is opened when 'Search Reports' button is clicked.     
    'Precondition  :
    'Date          : 15-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Report Search page is opened when 'Search Reports' button is clicked.")
	public void testHappyDay68460() throws Exception {

		gstrTCID = "68460";
		gstrTO = "Verify that the Report Search page is opened when 'Search Reports' button is clicked.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		Login objLogin = new Login(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage();
		objHome.clickOnPatientSchedule();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objPatientScheduleRegistration.clickOnSearchReports()
				.verReportSearchPage();

		gstrResult = "PASS";

	}

}
