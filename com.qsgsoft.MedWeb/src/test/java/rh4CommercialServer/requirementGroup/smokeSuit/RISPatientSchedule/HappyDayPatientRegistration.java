package rh4CommercialServer.requirementGroup.smokeSuit.RISPatientSchedule;

import dataObject.Login_data;
import dataObject.PatientSchedule_data;
import dataObject.User_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.PatientScheduleRegistration;
import page.UserManagement;
import page.ViewPatients;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayPatientRegistration extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayPatientRegistration() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that a new patient can be registered by entering all the data in the New Patient form.     
    'Precondition  :
    'Date          : 06-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a new patient can be registered by entering all the data in the New Patient form.")
	public void testHappyDay62719() throws Exception {

		gstrTCID = "62719";
		gstrTO = "Verify that a new patient can be registered by entering all the data in the New Patient form.";

		Login_data objLogin_data = new Login_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		Home objHome = new Home(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);

		String str1 = objPatientSchedule_data.strPatient;
		String str2 = str1.substring(11);
		String str3 = str1.substring(0, 11);
		String str4 = str2.substring(0, 3);
		System.out.println(str2 + " str2");
		System.out.println(str3 + " str3");
		System.out.println(str4 + " str4");
		String ssn = objPatientSchedule_data.strSSN;
		String ssn1 = ssn + str2;
		System.out.println("ssn value "+ssn1);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnPatientSchedule();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objPatientScheduleRegistration
				.verPatientRegistrationPage()
				.enterTextInSSN(ssn1)
				.enterTextInLastName(str2)
				.enterTextInFirstName(str3)
				.enterTextInMiddleName(objPatientSchedule_data.strMiddleName)
				.enterTextInAlternatePatientID(objPatientSchedule_data.strAlternatePatientId)
				.enterTextInLastNameAlias(
						objPatientSchedule_data.strLastNameAlias)
				.enterTextInFirstNameAlias(
						objPatientSchedule_data.strFirstNameAlias)
						.enterTextInRace(objPatientSchedule_data.strRace)
						.enterTextInReligion(objPatientSchedule_data.strReligion)
						.enterTextInEthnicGroup(objPatientSchedule_data.strEthnicGroup)
						.enterTextInLanguage(objPatientSchedule_data.strLanguage)
				.enterTextInAddress(objPatientSchedule_data.strAddress)
				.enterTextInCity(objPatientSchedule_data.strCity)
				.enterTextInCountry(objPatientSchedule_data.strCountry)
				.enterTextInDateOfBirth(objPatientSchedule_data.strDOB)
				.enterTextInEMail(objPatientSchedule_data.strEmail)
				.enterTextInHomePhone(objPatientSchedule_data.strHomePhone)
				.enterTextInBusinessPhone(objPatientSchedule_data.strBuisinessPhone)
				.enterTextInVeteransMilitaryStatus(objPatientSchedule_data.strVeteransMilitaryStatus)
				.enterTextInAllergyType(objPatientSchedule_data.strAllergyType)
				.enterTextInSeverity(objPatientSchedule_data.strSeverity)
				.enterTextInCodeOrDescription(objPatientSchedule_data.strDescription)
				.enterTextInReaction(objPatientSchedule_data.strReaction)
				.enterTextInZip(objPatientSchedule_data.strZip)
				.selMaritalStatus(objPatientSchedule_data.strMaritaStatus)
				.selSex(objPatientSchedule_data.strSex)
				.selState(objPatientSchedule_data.strState)
				.selDateFromCalenderWindow(objPatientSchedule_data.strdate)
				.clickOnSavePatientData();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration.enterTextInLastName(str4);
		Thread.sleep(3000);
		objPatientScheduleRegistration.verPatientRegistration(str2);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the user from Scheduler group can login to the Patient Schedule page.     
    'Precondition  :
    'Date          : 09-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the user from Scheduler group can login to the Patient Schedule page.")
	public void testHappyDay68441() throws Exception {

		gstrTCID = "68441";
		gstrTO = "Verify that the user from Scheduler group can login to the Patient Schedule page.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		this.driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.schedulerGrp)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		Thread.sleep(3000);
		System.out.println(objUser_data.strNewUserName);
		objUserManagement.enterTextInUserNameSearchField(
				objUser_data.strNewUserName).clickOnSearch();
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserName);
		Capabilities cp = ((RemoteWebDriver) this.driver).getCapabilities();
		String bn = cp.getBrowserName();
		System.out.println(bn + " this is the curent browser");
		if (bn.equalsIgnoreCase("MicrosoftEdge")) {
			this.driver = objNavigationToSubMenus.clickOnLogout(true);
			Home objhome1 = new Home(this.driver);
			Login objLogin1 = new Login(this.driver);
			ViewPatients objViewPatients1 = new ViewPatients(this.driver);
			objhome1.launchApplication(objLogin_data.strAppURL);
			objhome1.clickOnViewPatients();
			objLogin1.loginAsUser(objUser_data.strNewUserName,
					objUser_data.strNewPassword).clickLogin();
			objViewPatients1.verifyUser(objUser_data.strNewUserName);
			objViewPatients1.clickOnLogout();
		} else {
			objHome.clickOnLogOut()/*.clickOnLogout()*/;
			Thread.sleep(5000);
			objHome.launchApplication(objLogin_data.strAppURL);
			driver.switchTo().defaultContent();
			objHome.clickOnViewPatients();
			objLogin.loginAsUser(objUser_data.strNewUserName,
					objUser_data.strNewPassword).clickLogin();
			objPatientScheduleRegistration.verPatientRegistrationPage()
					.verAllTabsDisplaying().clickOnLogOut();

		}

		gstrResult = "PASS";

	}
}
