package rh4CommercialServer.requirementGroup.smokeSuit.RISPatientSchedule;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import dataObject.Login_data;
import dataObject.PatientSchedule_data;
import dataObject.RISSettings_data;
import dataObject.User_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.Destinations;
import page.Home;
import page.Login;
import page.MachineSchedule;
import page.Monitor;
import page.PatientScheduleRegistration;
import page.RISSettings;
import page.UserManagement;
import page.ViewPatients;
import static org.testng.Assert.assertTrue;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.text.PDFTextStripper;
import org.bouncycastle.asn1.dvcs.PathProcInput;
import org.openqa.selenium.net.Urls;
import org.testng.annotations.Test;
import org.testng.internal.PropertiesFile;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.testngExtensions.sep14;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayCreateOrder extends sep14{
	public HappyDayCreateOrder() throws Exception {
		super();
	}
	public List<String> l1;
	
	/*************************************************************************************
    'Description   : Verify that the Order is marked as STAT and appears with a red circle in VP
                     page when the STAT checkbox is enabled.     
    'Precondition  :
    'Date          : 05-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Order is marked as STAT and appears with a red circle in"
			+ " VP page when the STAT checkbox is enabled .")
	public void testHappyDay62733() throws Exception {

		gstrTCID = "62733";
		gstrTO = "Verify that the Order is marked as STAT and appears with a red circle in VP page "
				+ "when the STAT checkbox is enabled .";

		Login_data objLogin_data = new Login_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		Home objHome = new Home(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		MachineSchedule objMachineSchedule = new MachineSchedule(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
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
		objRISSettings.clickOnOpenPageOfMandatoryFields().clickOnPatientRegistrationLink().clickOnSetDefault().clickOnSaveChanges();
		objRISSettings.clickOnEnterOrderLink().clickOnSetDefault().clickOnSaveChanges();
		objRISSettings.clickClinicsAndMachines();
		objAddUser.clickOnAddInMedicalLicensesPage();
		objRISSettings.enterTextInAddress(objRISSettings_data.strAdrress)
				.enterTextInEmail(objRISSettings_data.strEmail)
				.enterTextInMTF(objRISSettings_data.strMtf)
				.enterTextInName(objRISSettings_data.strClinicName)
				.enterTextInPhone(objRISSettings_data.strPhone)
				.enterTextInState(objRISSettings_data.strState);
		objRISSettings.clickOnSaveChanges();
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
		String doc;
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.equals(mainwindow)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				Thread.sleep(3000);
				doc = objMachineSchedule.selAnyDoctor();
				System.out.println(doc);
				driver.switchTo().window(mainwindow);
				objMachineSchedule.clickOnSaveAndBackButton();
			}
		}
		
		objHome.clickOnPatientSchedule();
		/*objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage();
		objHome.clickOnPatientSchedule();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();*/
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
		objPatientScheduleRegistration
				.selModality(objRISSettings_data.strModalityMr)
				.selClinic(objRISSettings_data.strClinicName).selStatCheckbox()
				.clickOnSave().verOrderIsMarkedAsStat(str2);
		objHome.clickOnViewPatients();
		objViewPatients.enterTextInFind(str2).clickOnSearch().clickOnSearch()
				.clickOnSearch().verStatStatusWithRedCircle(str2);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that when the order is created with the procedure length, the order 
                     is displayed in Scheduler page with the above procedure time.     
    'Precondition  :
    'Date          : 14-Dec-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that when the or der is created with the procedure length, the order"
			+ " is displayed in Scheduler page with the above procedure time.")
	public void testHappyDay104296() throws Exception {

		gstrTCID = "104296";
		gstrTO = "Verify that when the order is created with the procedure length, the order is"
				+ " displayed in Scheduler page with the above procedure time.";

		Login_data objLogin_data = new Login_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		Date_Time_settings dts = new Date_Time_settings();
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
				.enterTextInState(objRISSettings_data.strState);
		objRISSettings.clickOnSaveChanges();
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
		String doc;
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.equals(mainwindow)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				Thread.sleep(3000);
				doc = objMachineSchedule.selAnyDoctor();
				System.out.println(doc);
				driver.switchTo().window(mainwindow);
				objMachineSchedule.clickOnSaveAndBackButton();
			}
		}

		objHome.clickOnPatientSchedule();
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
		objPatientScheduleRegistration
				.selModality(objRISSettings_data.strModalityMr)
				.selClinic(objRISSettings_data.strClinicName)
				.selProcedureLength(objRISSettings_data.strDay).clickOnSave();
		String str = objPatientScheduleRegistration.getProcedureTime(str2);
		String[] str11 = str.split("-");
		String rtim = dts.getTimeDiffInMinutes(str11[0], str11[1]);
		System.out.println(rtim+" this is d minute");
		assertTrue(rtim.equals(objRISSettings_data.strDay));
		objPatientScheduleRegistration.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	@Test
	public void s() throws Exception{
		PathsProperties pf = new PathsProperties();
		Properties p = pf.Read_FilePath();
		String pdfpath = p.getProperty("UploadPdfFilePath");
	    File f = new File(System.getProperty("user.dir")+pdfpath);
	   // String ss = f.toString();
	    System.out.println("file:///"+(f.toString())+" this is d url");
	    driver.get("file:///"+(f.toString()));
	    Thread.sleep(15000);
	    URL u = new URL(driver.getCurrentUrl());
	    BufferedInputStream tf = new BufferedInputStream(u.openStream());
	    PDFParser pdp = new PDFParser(tf);
	    pdp.parse();
	    String txt = new PDFTextStripper().getText(pdp.getPDDocument());
	    System.out.println(txt+"   ********");
	}
	
	/*************************************************************************************
    'Description   : Verify that an Order is created by entering data in all fields in Enter Order page.     
    'Precondition  :
    'Date          : 15-Dec-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that an Order is created by entering data in all fields in Enter Order page.")
	public void testHappyDay62731() throws Exception {

		gstrTCID = "62731";
		gstrTO = "Verify that an Order is created by entering data in all fields in Enter Order page.";

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

		String str1 = objPatientSchedule_data.strPatient;
		String str2 = str1.substring(11);
		String str3 = str1.substring(0, 11);
		String str4 = str2.substring(0, 3);
		System.out.println(str2 + " str2");
		System.out.println(str3 + " str3");
		System.out.println(str4 + " str4");
		String ssn = objPatientSchedule_data.strSSN;
		String ssn1 = ssn + str2;
		System.out.println("ssn value " + ssn1);
		String cid = "" + System.currentTimeMillis();

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
		objNavigationToSubMenus.clickOnRISSettings();
		objRISSettings.clickOnOpenPageOfServiceLocations();
		objRISSettings.verServiceLocationPage().clickOnAdd()
				.enterTextInLocationName(objRISSettings_data.strLocation)
				.enterTextInLocationShortName(objRISSettings_data.strLocation1)
				.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnRISSettings();
		objRISSettings
				.clickOnOpenPageOfPatientLocations()
				.verPatientLocationPage()
				.clickOnAdd()
				.enterTextInLocationName(objRISSettings_data.strPatientLocation)
				.enterTextPLShortName("sn").clickOnSaveChanges();
		objNavigationToSubMenus.clickOnRISSettings();
		objRISSettings.clickOnOpenPageOfDoctors().clickOnAdd()
				.enterTextInDoctorLastName(objRISSettings_data.strDoctorLn)
				.enterTextInDoctorFirstName(objRISSettings_data.strDoctorFn)
				.enterTextInUPIN(objRISSettings_data.strMtf)
				.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnRISSettings();
		objRISSettings.clickOnOpenPageOfInsuranceCompanies().clickOnAdd()
				.enterTextInCompanyID(cid.substring((cid.length()) - 4))
				.enterTextInLocationName(objRISSettings_data.strCmpName)
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
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage();
		objHome.clickOnPatientSchedule();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objPatientScheduleRegistration
				.verPatientRegistrationPage()
				.enterTextInLastName(str2)
				.enterTextInFirstName(str3)
				.enterTextInAddress(objPatientSchedule_data.strAddress)
				.enterTextInCity(objPatientSchedule_data.strCity)
				.enterTextInCountry(objPatientSchedule_data.strCountry)
				.enterTextInZip(objPatientSchedule_data.strZip)
				.selState(objPatientSchedule_data.strState)
				.enterTextInSSN(ssn1)
				.enterTextInMiddleName(objPatientSchedule_data.strMiddleName)
				.clickOnInsuranceTab()
				.enterTextInInsurancePlanID(
						objPatientSchedule_data.strAlternatePatientId)
				.clickOnSearchIconOfCompanyId();
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr = aw.iterator();
		while (itr.hasNext()) {
			String cw = itr.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();
				objPatientScheduleRegistration.selInsuranceCompany(cid
						.substring((cid.length()) - 4));
				driver.switchTo().window(mw);
			}
		}

		objPatientScheduleRegistration.clickOnSearchIconOfPlanType();
		Set<String> aw1 = driver.getWindowHandles();
		Iterator<String> itr1 = aw1.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				objPatientScheduleRegistration.selInsurancePlan();
				driver.switchTo().window(mw);
			}
		}
		objPatientScheduleRegistration.clickOnPatientTab()
				.clickOnSavePatientData();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration.clickOnCreateTheOrder();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration
				.selModality(objRISSettings_data.strModalityMr)
				.selClinic(objRISSettings_data.strClinicName)
				.selSex(objPatientSchedule_data.strSex)
				.enterTextInDateOfBirth(objPatientSchedule_data.strDOB)
				.selPatientClass(objPatientSchedule_data.patientClassEmergency)
				.clickOnSearchIconOfPatientLocation();
		String mw1 = driver.getWindowHandle();
		Set<String> aw11 = driver.getWindowHandles();
		Iterator<String> itr11 = aw11.iterator();
		while (itr11.hasNext()) {
			String cw = itr11.next().toString();
			if (!cw.contains(mw1)) {
				driver.switchTo().window(cw);
				objPatientScheduleRegistration
						.selPatientLocation(objRISSettings_data.strPatientLocation);
				driver.switchTo().window(mw1);
			}
		}
		objPatientScheduleRegistration.clickOnSearchIconOfReferringPhysician();
		Set<String> aw111 = driver.getWindowHandles();
		Iterator<String> itr111 = aw111.iterator();
		while (itr111.hasNext()) {
			String cw = itr111.next().toString();
			if (!cw.contains(mw1)) {
				driver.switchTo().window(cw);
				objPatientScheduleRegistration
						.selDoctorOrRefPhy(objRISSettings_data.strDoctorLn);
				driver.switchTo().window(mw1);
			}
		}
		objPatientScheduleRegistration.clickOnSearchIconOfAssignProvider();
		Set<String> aw1111 = driver.getWindowHandles();
		Iterator<String> itr1111 = aw1111.iterator();
		while (itr1111.hasNext()) {
			String cw = itr1111.next().toString();
			if (!cw.contains(mw1)) {
				driver.switchTo().window(cw);
				objPatientScheduleRegistration
						.selDoctorOrRefPhy(objLogin_data.strAdminUser);
				driver.switchTo().window(mw1);
			}
		}

		objPatientScheduleRegistration.clickOnSearchIconOfAttendingDoctor();
		Set<String> aw11111 = driver.getWindowHandles();
		Iterator<String> itr11111 = aw11111.iterator();
		while (itr11111.hasNext()) {
			String cw = itr11111.next().toString();
			if (!cw.contains(mw1)) {
				driver.switchTo().window(cw);
				objPatientScheduleRegistration
						.selDoctorOrRefPhy(objLogin_data.strAdminUser);
				driver.switchTo().window(mw1);
			}
		}

		objPatientScheduleRegistration.clickOnSearchIconOfServiceLocation();
		Set<String> aw111111 = driver.getWindowHandles();
		Iterator<String> itr111111 = aw111111.iterator();
		while (itr111111.hasNext()) {
			String cw = itr111111.next().toString();
			if (!cw.contains(mw1)) {
				driver.switchTo().window(cw);
				objPatientScheduleRegistration
						.selDoctorOrRefPhy(objRISSettings_data.strLocation);
				driver.switchTo().window(mw1);
			}
		}

		objPatientScheduleRegistration.clickOnSearchIconOfInsuranceCompany();
		Set<String> aw12 = driver.getWindowHandles();
		Iterator<String> itr12 = aw12.iterator();
		while (itr12.hasNext()) {
			String cw = itr12.next().toString();
			if (!cw.contains(mw1)) {
				driver.switchTo().window(cw);
				objPatientScheduleRegistration.selDoctorOrRefPhy(cid
						.substring((cid.length()) - 4));
				driver.switchTo().window(mw1);
			}
		}

		l1 = objPatientScheduleRegistration.enterTextInProcedureCode(l);
		objPatientScheduleRegistration
				.selProcedureLength(objRISSettings_data.strDay)
				.enterTextInEMail(objRISSettings_data.strEmail)
				.selStatCheckbox();
		objPatientScheduleRegistration.clickOnSave();
		objPatientScheduleRegistration.clickOnSearchOrders()
				.enterTextInPatientNameIdSSN(str2)
				.clickOnSearchOrdersInOrderSearchPage()
				.verOrdersDisplayed(str2);
		objPatientScheduleRegistration.clickOnLogOut();

		gstrResult = "PASS";

	}

}
