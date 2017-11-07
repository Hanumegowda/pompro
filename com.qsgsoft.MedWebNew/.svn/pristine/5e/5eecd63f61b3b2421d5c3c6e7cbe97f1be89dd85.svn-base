package rh6CommercialServer.requirementGroup.smokeSuit.MedwebRadiologyStatistics;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.ViewPatients_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AETitleRouting;
import page.AdministratorSite;
import page.AutoIT;
import page.DICOMRemapping;
import page.DICOMSetting;
import page.Destinations;
import page.Home;
import page.Login;
import page.PatientScheduleRegistration;
import page.Statistics;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayStudiesStudiesReceivedByModalityAndDate extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayStudiesStudiesReceivedByModalityAndDate() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that statistics of Studies received by Modality and Date are generated
                     for all Modality for a selected custom time period.     
    'Precondition  :
    'Date          : 13-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that statistics of Studies received by Modality and Date are "
			+ "generated for all Modality for a selected custom time period.")
	public void testHappyDay69314() throws Exception {

		gstrTCID = "69314";
		gstrTO = "Verify that statistics of Studies received by Modality and Date are generated "
				+ "for all Modality for a selected custom time period.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileAutoITDownloadPath = pathProps
				.getProperty(objPathData.autoItFilePath2);
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
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics.clickOnRadiology()
				.clickOnStudiesReceivedByModalityAndDate().clickOnSelectAll()
				.clickOnNext();

		objStatistics.clickOnToday().clickOnNext1();
		int actual = objStatistics
				.getStatisticsCountOfParticularModality(objViewPatients_data.strModalitySC);
		//objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

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
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objViewPatients.clickOnNewStudy();
		// objCommonFunctions.clickOnContinueToThisWebsiteLink();
		Thread.sleep(2000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalitySC);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSendThisStudyToDICOMStorageDevice(
						objViewPatients_data.strStudy);
		String mainWindow = driver.getWindowHandle();
		Set<String> str1 = driver.getWindowHandles();
		Iterator<String> itr = str1.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
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
				.clickOnSearch().clickOnSearch();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnStatistics();
		/*objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();*/
		objStatistics.clickOnRadiology()
				.clickOnStudiesReceivedByModalityAndDate().clickOnSelectAll()
				.clickOnNext();

		objStatistics
				.clickOnToday()
				.clickOnNext1()
				.verStudyReceivedByDifferentStatistics(
						objViewPatients_data.strModalitySC, actual);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that statistics of Studies received by Modality and Date created from 
                     'SC' modality is displayed for the current date when 'Today' is selected in Time Period.     
    'Precondition  :
    'Date          : 07-Dec-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that statistics of Studies received by Modality and Date created from 'SC'"
			+ " modality is displayed for the current date when 'Today' is selected in Time Period.")
	public void testHappyDay171887() throws Exception {

		gstrTCID = "171887";
		gstrTO = "Verify that statistics of Studies received by Modality and Date created from 'SC' modality is"
				+ " displayed for the current date when 'Today' is selected in Time Period.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		DICOMRemapping objDICOMRemapping = new DICOMRemapping(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileAutoITDownloadPath = pathProps
				.getProperty(objPathData.autoItFilePath2);
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
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage()
		.clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnAETitleRouting();
		boolean actual = objAETitleRouting.delAllExistingRoute();
		while (actual == true) {
			objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
			objDICOMSetting.clickOnAETitleRouting();
			actual = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual + " aa");

		}
		objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
		objDICOMSetting.clickOnDicomRemapping();
		boolean actual1 = objDICOMRemapping.delAllRemappings();
		while (actual1 == true) {
			objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
			objDICOMSetting.clickOnDicomRemapping();
			actual1 = objDICOMRemapping.delAllRemappings();
			System.out.println(actual1 + " aa");

		}
		objNavigationToSubMenus.clickOnPublicSite();
	    objHome.clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics.clickOnRadiology()
				.clickOnStudiesReceivedByModalityAndDate().selAModalityCheckBox(objViewPatients_data.strModalitySC)
				.clickOnNext();

		objStatistics.clickOnToday().clickOnNext1();
		int actual11 = objStatistics
				.getStatisticsCountOfParticularModality(objViewPatients_data.strModalitySC);
		objPatientScheduleRegistration.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

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
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objViewPatients.clickOnNewStudy();
		// objCommonFunctions.clickOnContinueToThisWebsiteLink();
		Thread.sleep(5000);
		System.out.println(objViewPatients_data.strStudy);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalitySC);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients
				.clickOnSearch1()
				.clickOnSendThisStudyToDICOMStorageDevice(
						objViewPatients_data.strStudy);
		String mainWindow = driver.getWindowHandle();
		Set<String> str1 = driver.getWindowHandles();
		Iterator<String> itr = str1.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
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
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		Thread.sleep(5000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		Thread.sleep(10000);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics.clickOnRadiology()
				.clickOnStudiesReceivedByModalityAndDate()
				.selAModalityCheckBox(objViewPatients_data.strModalitySC).clickOnNext();

		objStatistics
				.clickOnToday()
				.clickOnNext1()
				.verStudyReceivedByDifferentStatistics(
						objViewPatients_data.strModalitySC, actual11);

		gstrResult = "PASS";

	}

}
