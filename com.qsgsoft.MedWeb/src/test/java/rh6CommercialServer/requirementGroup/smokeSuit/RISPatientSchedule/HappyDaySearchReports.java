package rh6CommercialServer.requirementGroup.smokeSuit.RISPatientSchedule;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.PatientSchedule_data;
import dataObject.RISSettings_data;
import dataObject.ViewPatients_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.Home;
import page.Login;
import page.MachineSchedule;
import page.PatientScheduleRegistration;
import page.RISSettings;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDaySearchReports extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDaySearchReports() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the total number of Orders and studies having reports in Medweb Server
                     are displayed when 'All Days' is selected from the Time Period for the event 
                     'Report Created'.     
    'Precondition  :
    'Date          : 18-Apr-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the total number of Orders and studies having reports in Medweb "
			+ "Server are displayed when 'All Days' is selected from the Time Period for the event 'Report Created'")
	public void testHappyDay62743() throws Exception {

		gstrTCID = "62743";
		gstrTO = "Verify that the total number of Orders and studies having reports in Medweb Server are displayed"
				+ " when 'All Days' is selected from the Time Period for the event 'Report Created'";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		Home objHome = new Home(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		MachineSchedule objMachineSchedule = new MachineSchedule(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileCreateStudyAutoITPath = pathProps
				.getProperty(objPathData.autoItFilePath2);
		System.out.println(fileCreateStudyAutoITPath);

		File autoitfile = new File(System.getProperty("user.dir")
				+ fileCreateStudyAutoITPath);
		String strAutoitPath = autoitfile.toString();
		System.out.println(strAutoitPath + 1);

		// image
		String imagePath = pathProps.getProperty(objPathData.sudyWithImage);
		System.out.println(imagePath);

		File imageFile = new File(System.getProperty("user.dir") + imagePath);
		String strImagePath = imageFile.toString();

		String str1 = objPatientSchedule_data.strPatient;
		String str2 = str1.substring(11);
		String str3 = str1.substring(0, 11);
		String str4 = str2.substring(0, 3);
		System.out.println(str2 + " str2");
		System.out.println(str3 + " str3");
		System.out.println(str4 + " str4");

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnRISSettings1();
		objRISSettings.clickOnOpenPageOfMandatoryFields()
				.clickOnPatientRegistrationLink().clickOnSetDefault()
				.clickOnSaveChanges();
		objRISSettings.clickOnEnterOrderLink().clickOnSetDefault()
				.clickOnSaveChanges();
		objRISSettings.clickClinicsAndMachines1();
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
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				actual = objMachineSchedule.selAnyDoctor();
				System.out.println(actual);
				driver.switchTo().window(mainwindow);
				objMachineSchedule.clickOnSaveAndBackButton();
			}
		}

		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.verHomePage();
		objHome.clickOnViewPatients();
		Thread.sleep(3000);
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();

		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);

		String mainwindowhandle = driver.getWindowHandle();
		String childwindow;
		System.out.println(mainwindowhandle);
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> ite = windowhandles.iterator();
		while (ite.hasNext()) {
			childwindow = ite.next().toString();
			if (!childwindow.contains(mainwindowhandle)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.verWebReporterPage("Web-Reporter")
						.clickOnAddButton();
				String mainwindowHandle1 = driver.getWindowHandle();
				Set<String> aw = driver.getWindowHandles();
				Iterator<String> ite1 = aw.iterator();
				while (ite1.hasNext()) {
					String childwindow1 = ite1.next().toString();
					if ((!childwindow1.contains(mainwindowHandle1))
							&& (!childwindow1.contains(mainwindowhandle))) {
						driver.switchTo().window(childwindow1);
						objViewPatients.clickOnSaveReport();
						Thread.sleep(5000);

					}
				}
				driver.switchTo().window(mainwindowHandle1);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindowhandle);
		objViewPatients.clickOnSearch();
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
				.selClinic(objRISSettings_data.strClinicName).selStatCheckbox()
				.clickOnSave();
		objPatientScheduleRegistration.clickOnSearchOrders().selTimePeriod(
				objPatientSchedule_data.strTimePeriod1);
		objPatientScheduleRegistration.enterTextInPatientNameIdSSN(str2)
				.clickOnSearchOrdersInOrderSearchPage()
				.verOrdersDisplayed(str2)
				.clickOnReportsLinkOfAOrder(objRISSettings_data.strMachineId);
		String mainwindow1 = driver.getWindowHandle();
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!(cw.contains(mainwindow1))) {
				driver.switchTo().window(cw);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.verWebReporterPage("Web-Reporter")
						.clickOnAddButton();
				Set<String> allwindows11 = driver.getWindowHandles();
				Iterator<String> itr11 = allwindows11.iterator();
				while (itr11.hasNext()) {
					String cw1 = itr11.next().toString();
					if (!(cw1.contains(mainwindow1)) && (!(cw1.contains(cw)))) {
						driver.switchTo().window(cw1);
						objViewPatients.clickOnSaveReport();
					}
				}
				driver.switchTo().window(cw);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow1);

		objPatientScheduleRegistration.clickOnSearchReports()
				.enterTextInPatientNameIdSSN(str2)
				.clickOnSearchReportsInReportSearchPage()
				.verOrdersDisplayed(str2);

		objPatientScheduleRegistration
				.enterTextInPatientNameIdSSN(objViewPatients_data.strStudy)
				.clickOnSearchReportsInReportSearchPage()
				.verOrdersDisplayed(objViewPatients_data.strStudy)
				.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the total number of Orders having Reports in Medweb Server is 
                     displayed when 'All Days' is selected from the Time Period for the event 'Exam created'.     
    'Precondition  :
    'Date          : 24-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the total number of Orders having Reports in Medweb Server is "
			+ "displayed when 'All Days' is selected from the Time Period for the event 'Exam created'.")
	public void testHappyDay62742() throws Exception {

		gstrTCID = "62742";
		gstrTO = "Verify that the total number of Orders having Reports in Medweb Server is displayed "
				+ "when 'All Days' is selected from the Time Period for the event 'Exam created'.";

		Login_data objLogin_data = new Login_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		Home objHome = new Home(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		MachineSchedule objMachineSchedule = new MachineSchedule(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		String str1 = objPatientSchedule_data.strPatient;
		String str2 = str1.substring(11);
		String str3 = str1.substring(0, 11);
		String str4 = str2.substring(0, 3);
		System.out.println(str2 + " str2");
		System.out.println(str3 + " str3");
		System.out.println(str4 + " str4");

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnRISSettings1();
		objRISSettings.clickOnOpenPageOfMandatoryFields()
				.clickOnPatientRegistrationLink().clickOnSetDefault()
				.clickOnSaveChanges();
		objRISSettings.clickOnEnterOrderLink().clickOnSetDefault()
				.clickOnSaveChanges();
		objRISSettings.clickClinicsAndMachines1();
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
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				actual = objMachineSchedule.selAnyDoctor();
				System.out.println(actual);
				driver.switchTo().window(mainwindow);
				objMachineSchedule.clickOnSaveAndBackButton();
			}
		}

		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.verHomePage();
		objHome.clickOnPatientSchedule();
		objPatientScheduleRegistration.verPatientRegistrationPage()
				.enterTextInLastName(str2).enterTextInFirstName(str3)
				.enterTextInAddress(objPatientSchedule_data.strAddress)
				.enterTextInCity(objPatientSchedule_data.strCity)
				.enterTextInCountry(objPatientSchedule_data.strCountry)
				.enterTextInZip(objPatientSchedule_data.strZip)
				.selState(objPatientSchedule_data.strState)
				.clickOnSavePatientData();
		Thread.sleep(2000);
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration.clickOnCreateTheOrder();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration
				.selModality(objRISSettings_data.strModalityMr)
				.selClinic(objRISSettings_data.strClinicName).selStatCheckbox()
				.clickOnSave();
		objPatientScheduleRegistration.clickOnSearchOrders().selTimePeriod(
				objPatientSchedule_data.strTimePeriod1);
		objPatientScheduleRegistration.enterTextInPatientNameIdSSN(str2)
				.clickOnSearchOrdersInOrderSearchPage()
				.verOrdersDisplayed(str2)
				.clickOnReportsLinkOfAOrder(objRISSettings_data.strMachineId);
		String mainwindow1 = driver.getWindowHandle();
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!(cw.contains(mainwindow1))) {
				driver.switchTo().window(cw);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.verWebReporterPage("Web-Reporter")
						.clickOnAddButton();
				Set<String> allwindows11 = driver.getWindowHandles();
				Iterator<String> itr11 = allwindows11.iterator();
				while (itr11.hasNext()) {
					String cw1 = itr11.next().toString();
					if (!(cw1.contains(mainwindow1)) && (!(cw1.contains(cw)))) {
						driver.switchTo().window(cw1);
						objViewPatients.clickOnSaveReport();
					}
				}
				driver.switchTo().window(cw);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow1);

		objPatientScheduleRegistration.clickOnSearchReports();
		objPatientScheduleRegistration.enterTextInPatientNameIdSSN(str2)
				.clickOnSearchReportsInReportSearchPage()
				.verOrdersDisplayed(str2);
		objPatientScheduleRegistration.clickOnSearchOrders().selTimePeriod(
				objPatientSchedule_data.strTimePeriod);
		String actual11 = objPatientScheduleRegistration.getOrderCount();
		int i2 = Integer.parseInt(actual11);
		objPatientScheduleRegistration.verOrdersCount(0, i2).clickOnLogOut();

		gstrResult = "PASS";

	}

}
