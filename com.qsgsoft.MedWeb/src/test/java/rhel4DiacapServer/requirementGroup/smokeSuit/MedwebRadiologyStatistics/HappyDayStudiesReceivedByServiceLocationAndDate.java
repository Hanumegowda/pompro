package rhel4DiacapServer.requirementGroup.smokeSuit.MedwebRadiologyStatistics;

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
import page.DICOMSetting;
import page.Destinations;
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
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayStudiesReceivedByServiceLocationAndDate extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayStudiesReceivedByServiceLocationAndDate() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the statistics of studies received to all the Service Location 
                     are generated for a selected custom time period.     
    'Precondition  :
    'Date          : 09-Jun-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the statistics of studies received to all the Service Location "
			+ "are generated for a selected custom time period.")
	public void testHappyDay103383() throws Exception {

		gstrTCID = "103383";
		gstrTO = "Verify that the statistics of studies received to all the Service Location are "
				+ "generated for a selected custom time period.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		Home objHome = new Home(this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		MachineSchedule objMachineSchedule = new MachineSchedule(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileAutoITDownloadPath = pathProps
				.getProperty(objPathData.autoItFilePathLocalService);
		System.out.println(fileAutoITDownloadPath);

		File autoitfile = new File(System.getProperty("user.dir")
				+ fileAutoITDownloadPath);
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
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
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
		objDestinations.enterTextInAETitleField(objDICOMSettings_data.aETitle2)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddress1)
				.enterTextInLabelField(objDICOMSettings_data.label1)
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnRISSettings1();
		objRISSettings.clickOnOpenPageOfServiceLocations()
				.verServiceLocationPage().clickOnAdd()
				.enterTextInLocationName(objRISSettings_data.strLocation)
				.enterTextInLocationShortName(objRISSettings_data.strLocation1)
				.clickOnSaveChanges();

		objNavigationToSubMenus.clickOnRISSettingsForSecondTime();
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
		objRISSettings.selModality(objViewPatients_data.strModalityCT);
		objUserManagement.clickOnOkInAlertPopUp();
		objRISSettings.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite().clickOnMachineSchedule();
		System.out.println(objRISSettings_data.strMachineId);
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
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
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				Thread.sleep(3000);
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
		objPatientScheduleRegistration.clickOnSearchIconOfServiceLocation();
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr1 = aw.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				Thread.sleep(5000);
				objPatientScheduleRegistration
						.selServiceLocation(objRISSettings_data.strLocation);
			}
		}
		driver.switchTo().window(mw);
		objPatientScheduleRegistration
				.selModality(objViewPatients_data.strModalityCT)
				.selClinic(objRISSettings_data.strClinicName).selStatCheckbox()
				.clickOnSave();
		objHome.clickOnViewPatients();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(str3).clickOnSearch().clickOnStudy(str2);
		Thread.sleep(2000);
		objAutoIT.addImagesToTheExistingStudyOrOrder(strAutoitPath,
				strImagePath);
		Thread.sleep(3000);
		/*objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(str3);*/
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch()
				.clickOnSendThisStudyToDICOMStorageDevice(str2);
		String mainWindow = driver.getWindowHandle();
		Set<String> str11 = driver.getWindowHandles();
		Iterator<String> itr11 = str11.iterator();
		while (itr11.hasNext()) {
			String childwindow = itr11.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics
				.clickOnRadiology()
				.clickOnStudiesReceivedByServiceLocationAndDate()
				.selDoctor(objRISSettings_data.strLocation1)
				.clickOnNext()
				.clickOnNext1()
				.verStudyReceivedByDifferentStatistics1(
						objRISSettings_data.strLocation1, 0);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

}
