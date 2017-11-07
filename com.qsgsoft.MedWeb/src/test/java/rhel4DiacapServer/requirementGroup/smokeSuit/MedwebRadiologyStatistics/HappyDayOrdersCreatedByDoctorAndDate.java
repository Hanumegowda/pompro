package rhel4DiacapServer.requirementGroup.smokeSuit.MedwebRadiologyStatistics;

import java.util.Iterator;
import java.util.Set;

import dataObject.Login_data;
import dataObject.MedwebRadiologyStatistics_data;
import dataObject.PatientSchedule_data;
import dataObject.RISSettings_data;
import dataObject.User_data;
import dataObject.ViewPatients_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.MachineSchedule;
import page.PatientScheduleRegistration;
import page.RISSettings;
import page.Statistics;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayOrdersCreatedByDoctorAndDate extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayOrdersCreatedByDoctorAndDate() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that statistics of Orders created by each doctor for the current date
                     is displayed when "Today" is selected from the time period.     
    'Precondition  :
    'Date          : 26-May-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that statistics of Orders created by each doctor for the current date is"
			+ " displayed when Today is selected from the time period.")
	public void testHappyDay104299() throws Exception {

		gstrTCID = "104299";
		gstrTO = "Verify that statistics of Orders created by each doctor for the current date is displayed "
				+ "when Today is selected from the time period.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		MedwebRadiologyStatistics_data objMedwebRadiologyStatistics_data = new MedwebRadiologyStatistics_data();
		Home objHome = new Home(this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		MachineSchedule objMachineSchedule = new MachineSchedule(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
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
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
		objLogin.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin();
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
		objRISSettings.selModality(objViewPatients_data.strModalityCT);
		objUserManagement.clickOnOkInAlertPopUp();
		objRISSettings.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite().clickOnMachineSchedule();
		System.out.println(objRISSettings_data.strMachineId);
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objMachineSchedule.verMachineSchedulePage()
				.clickOnMachineLink(objRISSettings_data.strMachineId)
				.clickOnAvailableTimeSlot().verNewMachineEventPage()
				.clickOnSearchDoctorIcon();
		String doc;
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.equals(mainwindow)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				doc = objMachineSchedule.selAnyDoctor();
				System.out.println(doc);
				driver.switchTo().window(mainwindow);
				objMachineSchedule.clickOnSaveAndBackButton();
			}
		}
		objHome.clickOnPatientSchedule();
		objPatientScheduleRegistration.verPatientRegistrationPage();
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
				.selModality(objViewPatients_data.strModalityCT)
				.selClinic(objRISSettings_data.strClinicName).selStatCheckbox()
				.clickOnSave();
		objPatientScheduleRegistration.clickOnLogOut();
		Thread.sleep(3000);
		objHome.clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics
				.clickOnRadiology()
				.clickOnOrdersCreatedByDoctorAndDate()
				.clickOnExpandArrowOfAGroup(
						objMedwebRadiologyStatistics_data.strAdminGroup)
				.selDoctor1(objUser_data.strNewUserName)
				.clickOnNext()
				.clickOnNext1()
				.verOrderCreatedByDoctorAndDatePage()
				.verStudyReceivedByDifferentStatistics(
						objUser_data.strNewUserName, 0);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

}
