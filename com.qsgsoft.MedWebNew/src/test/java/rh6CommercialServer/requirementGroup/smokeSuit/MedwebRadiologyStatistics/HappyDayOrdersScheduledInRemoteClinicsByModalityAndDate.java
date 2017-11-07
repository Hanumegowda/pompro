package rh6CommercialServer.requirementGroup.smokeSuit.MedwebRadiologyStatistics;

import java.util.Iterator;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.PatientSchedule_data;
import dataObject.RISSettings_data;
import dataObject.ViewPatients_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.ControlPanel;
import page.DICOMRemapping;
import page.DICOMSetting;
import page.Destinations;
import page.Home;
import page.Login;
import page.MachineSchedule;
import page.MedwebSecureTunnel;
import page.PatientScheduleRegistration;
import page.RISSettings;
import page.Statistics;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayOrdersScheduledInRemoteClinicsByModalityAndDate extends
		TestNG_UI_EXTENSIONSForOneBrowser {
	public HappyDayOrdersScheduledInRemoteClinicsByModalityAndDate()
			throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that statistics of ORDERS scheduled in Remote Clinic for a selected 
                     Modalities are generated for a selected custom time period.     
    'Precondition  :
    'Date          : 16-May-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that statistics of ORDERS scheduled in Remote Clinic for a selected"
			+ " Modalities are generated for a selected custom time period.")
	public void testHappyDay69328() throws Exception {

		gstrTCID = "69328";
		gstrTO = "Verify that statistics of ORDERS scheduled in Remote Clinic for a selected Modalities"
				+ " are generated for a selected custom time period.";

		Login_data objLogin_data = new Login_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		Home objHome = new Home(this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		DICOMRemapping objDICOMRemapping = new DICOMRemapping(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		MachineSchedule objMachineSchedule = new MachineSchedule(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		MedwebSecureTunnel objMedwebSecureTunnel = new MedwebSecureTunnel(
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
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnRISSettings();
		objRISSettings.clickOnOpenPageOfMandatoryFields().clickOnPatientRegistrationLink().clickOnSetDefault().clickOnSaveChanges();
		objRISSettings.clickOnEnterOrderLink().clickOnSetDefault().clickOnSaveChanges();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objMedwebSecureTunnel.clickOnGenerateButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		String str5 = objMedwebSecureTunnel
				.getTextFromLocalhostPublicKeySection();
		String str31 = str5.trim();
		System.out.println(str31);
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnRISSettings();
		objRISSettings.clickOnOpenPageOfMandatoryFields().clickOnPatientRegistrationLink().clickOnSetDefault().clickOnSaveChanges();
		objRISSettings.clickOnEnterOrderLink().clickOnSetDefault().clickOnSaveChanges();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objControlPanel.clickOnAdd();
		objMedwebSecureTunnel.enterTextInRemoteHostPublicKeySection(str31);
		objAddUser.clickOnSaveChanges();
		objMedwebSecureTunnel.clickOnGenerateButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		String str21 = objMedwebSecureTunnel
				.getTextFromLocalhostPublicKeySection();
		String str41 = str21.trim();
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();

		objControlPanel.clickOnAdd();
		objMedwebSecureTunnel.enterTextInRemoteHostPublicKeySection(str41);
		objAddUser.clickOnSaveChanges();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnDestinations();
		objDestinations.clickOnAdd().verDestinationEditorPage();
		objDestinations.selectGenericStorageSCPCheckBox()
				.selectGenericStorageSCUCheckBox().selectMedwebDeviceCheckBox()
				.selectMitraReportSCPCheckBox().selectMitraReportSCUCheckBox()
				.selectPlaceStudiesSandboxCheckBox()
				.selectReceiveDSMECheckBox().selectRetrievePatientSCPCheckBox()
				.selectRetrievePatientSCUCheckBox()
				.selectRetrievePatientStudySCPCheckBox()
				.selectRetrievePatientStudySCUCheckBox()
				.selectRetrieveStudySCPCheckBox()
				.selectRetrieveStudySCUCheckBox();
		objDestinations.enterTextInAETitleField(objDICOMSettings_data.aETitle1)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddress)
				.enterTextInLabelField(objDICOMSettings_data.label)
				.selFTPOverSecureTunnelRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();

		objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
		objDICOMSetting.clickOnDicomRemapping();
		boolean actual1 = objDICOMRemapping.delAllRemappings();
		while (actual1 == true) {
			objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
			objDICOMSetting.clickOnDicomRemapping();
			actual1 = objDICOMRemapping.delAllRemappings();
			System.out.println(actual1 + " aa");

		}

		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnMedwebStatisticsParametersLink()
				.clickOnStatisticsServersTab()
				.delExistingStatisticServer(objDICOMSettings_data.ipAddress);
		// .delExistingStatisticServer1(objDICOMSettings_data.ipAddress);
		objControlPanel.clickOnAddNewServer()
				.selServerName(objDICOMSettings_data.ipAddress)
				.clickOnSaveChanges();
		// Thread.sleep(10000);
		objControlPanel.verAvailableStatus(objDICOMSettings_data.ipAddress);

		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics.clickOnRadiology()
				.clickOnOrdersScheduledInRemoteClinicsByModalityAndDate()
				.selectClinicCheckBox(objDICOMSettings_data.ipAddress)
				.selectClinicCheckBox(objDICOMSettings_data.strLocalClinic)
				.clickOnNext()
				.selAModalityCheckBox(objViewPatients_data.strModalityCT)
				.clickOnNext().clickOnToday().clickOnNext1();
		int i = objStatistics.getInitialCount(objDICOMSettings_data.ipAddress);
		int i1 = objStatistics
				.getInitialCount(objDICOMSettings_data.strLocalClinic);

		objPatientScheduleRegistration.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL1);
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
		objRISSettings.selModality(objViewPatients_data.strModalityCT);
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
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				doc = objMachineSchedule.selAnyDoctor();
				System.out.println(doc);
				driver.switchTo().window(mainwindow);
				objMachineSchedule.clickOnSaveAndBackButton();
			}
		}
		
		objHome.clickOnPatientSchedule();
		objPatientScheduleRegistration.verPatientRegistrationPage();
		objPatientScheduleRegistration.enterTextInLastName(str21)
				.enterTextInFirstName(str31)
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
		objRISSettings.selModality(objViewPatients_data.strModalityCT);
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
		String doc1;
		String mainwindow1 = driver.getWindowHandle();
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.equals(mainwindow1)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				Thread.sleep(3000);
				// objCommonFunctions.clickOnContinueToThisWebsiteLink();
				doc1 = objMachineSchedule.selAnyDoctor();
				System.out.println(doc1);
				driver.switchTo().window(mainwindow1);
				objMachineSchedule.clickOnSaveAndBackButton();
			}
		}
		objHome.clickOnPatientSchedule();
		objPatientScheduleRegistration.verPatientRegistrationPage();
		objPatientScheduleRegistration
				.enterTextInLastName(str21)
				.enterTextInFirstName(str31)
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
				.selClinic(objRISSettings_data.strClinicName)
				.selStatCheckbox().clickOnSave();
		objHome.clickOnStatistics();
		objStatistics.clickOnRadiology()
				.clickOnOrdersScheduledInRemoteClinicsByModalityAndDate()
				.selectClinicCheckBox(objDICOMSettings_data.ipAddress)
				.selectClinicCheckBox(objDICOMSettings_data.strLocalClinic)
				.clickOnNext()
				.selAModalityCheckBox(objViewPatients_data.strModalityCT)
				.clickOnNext().clickOnToday().clickOnNext1();
		objStatistics.verStudyReceivedByDifferentStatistics(
				objDICOMSettings_data.ipAddress, i);
		objStatistics.verStudyReceivedByDifferentStatistics(
				objDICOMSettings_data.strLocalClinic, i1);

		gstrResult = "PASS";

	}

}
