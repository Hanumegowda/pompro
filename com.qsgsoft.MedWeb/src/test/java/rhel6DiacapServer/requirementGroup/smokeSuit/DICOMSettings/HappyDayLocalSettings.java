package rhel6DiacapServer.requirementGroup.smokeSuit.DICOMSettings;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.PatientSchedule_data;
import dataObject.RISSettings_data;
import dataObject.Study_data;
import dataObject.ViewPatients_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AETitleRouting;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.DICOMRemapping;
import page.DICOMSetting;
import page.Destinations;
import page.Home;
import page.Login;
import page.MachineSchedule;
import page.ModifyStudy;
import page.PatientScheduleRegistration;
import page.PersonalProfile;
import page.RISSettings;
import page.UserManagement;
import page.ViewPatients;

import org.openqa.selenium.NoSuchWindowException;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayLocalSettings extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayLocalSettings() throws Exception {
		super();
		
	}
	
	/*************************************************************************************
    'Description   : Verify that incoming study is marked as STAT and the same study records
                     are replaced by fake data when both "Mark Study as STAT" & "Anonymize Study"
                     options are enabled in "Add new alias" page.     
    'Precondition  :
    'Date          : 26-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(/* enabled=false, */description = "Verify that incoming study is marked as STAT and the same study records "
			+ "are replaced by fake data when both 'Mark Study as STAT' & 'Anonymize Study' options are"
			+ " enabled in 'Add new alias' page.")
	public void testHappyDay100685() throws Exception {

		gstrTCID = "100685";
		gstrTO = "Verify that incoming study is marked as STAT and the same study records are"
				+ " replaced by fake data when both 'Mark Study as STAT' & 'Anonymize Study' options"
				+ " are enabled in 'Add new alias' page.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
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
		objHome.verHomePage().clickOnAdminSite();
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
		objDestinations.enterTextInAETitleField(objDICOMSettings_data.aETitle1)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddress)
				.enterTextInLabelField(objDICOMSettings_data.label)
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnAliasesLinkOfAeTitle()
				.clickOnAddInDICOMAliases()
				.enterAliasName(objDICOMSettings_data.aliasName)
				.selAnonymizeStudyCheckBox().selMarkStudySTATCheckBox()
				.selProxyQRRequestsToCheckBox().selProxyQRRequestServerCheckBox(objDICOMSettings_data.aETitle1)
				.clickOnSaveChanges();
		Thread.sleep(5000);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
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
		objDestinations.clickOnModifyServer(objLogin_data.server);
		objDestinations
				.enterTextInAETitleField(objDICOMSettings_data.aliasName)
				.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objViewPatients.clickOnNewStudy();

		String mainWindow = driver.getWindowHandle();
		Set<String> str = driver.getWindowHandles();
		Iterator<String> itr = str.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				driver.switchTo().window(mainWindow);
			}
		}

		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1()
				.clickOnSendThisStudyToDICOMStorageDevice(
						objViewPatients_data.strStudy);
		Set<String> str1 = driver.getWindowHandles();
		Iterator<String> itr1 = str1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
			}
		}
		objViewPatients.selDICOMStorageDeviceRadioButton()
				.clickOnNextInSendStudyWizard()
				.selStorageDevice(objDICOMSettings_data.storageDevice)
				.clickOnFinishButton();
		Thread.sleep(3000);

		Set<String> str2 = driver.getWindowHandles();
		Iterator<String> itr2 = str2.iterator();
		while (itr2.hasNext()) {
			String childwindow1 = itr2.next().toString();
			System.out.println(childwindow1 + "secondcldwnd");
			if (!childwindow1.contains(mainWindow)) {
				driver.switchTo().window(childwindow1);
				objViewPatients.clickOnFinishButton();
			}
		}
		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.selLimitOption(objViewPatients_data.strLimit);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verIncommingStudy();
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the DICOM fields specified in Remapping table is replaced with 
                     the value in Regexp field for arriving studies from the specified AE.     
    'Precondition  :
    'Date          : 27-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the DICOM fields specified in Remapping table is replaced with"
			+ " the value in Regexp field for arriving studies from the specified AE.")
	public void testHappyDay68316() throws Exception {

		gstrTCID = "68316";
		gstrTO = "Verify that the DICOM fields specified in Remapping table is replaced with the value"
				+ " in Regexp field for arriving studies from the specified AE.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		DICOMRemapping objDICOMRemapping = new DICOMRemapping(this.driver);
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
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnDicomRemapping();
		boolean actual1 = objDICOMRemapping.delAllRemappings();
		while (actual1 == true) {
			objNavigationToSubMenus.clickOnDICOMSettings();
			objDICOMSetting.clickOnDicomRemapping();
			actual1 = objDICOMRemapping.delAllRemappings();
			System.out.println(actual1 + " aa");

		}
		objDICOMRemapping.enterTextInAETitleField(
				objDICOMSettings_data.aETitle1)
				.clickOnDicomDictionaryIconOfDestField();
		String mainwindow = driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		Iterator<String> itr = all.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objDICOMRemapping.selIDMODALITYOption(
						objDICOMSettings_data.dicomTag).clickOnSave();
			}
		}
		driver.switchTo().window(mainwindow);
		objDICOMRemapping.clickOnDicomDictionaryIconOfSrcField();
		Set<String> all1 = driver.getWindowHandles();
		Iterator<String> itr1 = all1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objDICOMRemapping.selIDMODALITYOption(
						objDICOMSettings_data.dicomTag).clickOnSave();
			}
		}
		driver.switchTo().window(mainwindow);
		objDICOMRemapping.enterTextInRegexpField(objDICOMSettings_data.regexp);
		objAddUser.clickOnSaveChanges();

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		Thread.sleep(3000);
		objHome.clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnAETitleRouting1();
		// objAETitleRouting.delExistingRoute(objDICOMSettings_data.aETitle2);
		boolean actual = objAETitleRouting.delAllExistingRoute();
		while (actual == true) {
			objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
			objDICOMSetting.clickOnAETitleRouting1();
			actual = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual + " aa");

		}

		objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
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
		Thread.sleep(3000);
		objViewPatients.clickOnNewStudy();

		String mainWindow = driver.getWindowHandle();
		Set<String> str = driver.getWindowHandles();
		Iterator<String> itr2 = str.iterator();
		while (itr2.hasNext()) {
			String childwindow = itr2.next().toString();
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				System.out.println(" yes win is pre");
				driver.switchTo().window(mainwindow);
			}
		}
		Thread.sleep(5000);
		System.out.println(objViewPatients_data.strStudy);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1()
				.clickOnSendThisStudyToDICOMStorageDevice(
						objViewPatients_data.strStudy);
		Set<String> str1 = driver.getWindowHandles();
		Iterator<String> itr3 = str1.iterator();
		while (itr3.hasNext()) {
			String childwindow = itr3.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();

				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice)
						.clickOnFinishButton();
				objViewPatients.clickOnFinishButton();
				Thread.sleep(3000);
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		Thread.sleep(3000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);

		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.selLayout(objViewPatients_data.strLayout)
				.selModalityOption(objViewPatients_data.strModalityCT)
				.verChangedModalityOfIncommingStudyToCT(
						objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the HTML report editor opens when adding reports in Web Reporter 
                     page if 'Use HTML Report Editor' option is enabled in Local Settings.     
    'Precondition  :
    'Date          : 28-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the HTML report editor opens when adding reports in Web"
			+ " Reporter page if 'Use HTML Report Editor' option is enabled in Local Settings.")
	public void testHappyDay68321() throws Exception {

		gstrTCID = "68321";
		gstrTO = "Verify that the HTML report editor opens when adding reports in Web Reporter"
				+ " page if 'Use HTML Report Editor' option is enabled in Local Settings.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
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
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.selHTMLReportEditorCheckBox()
				.deSelExpressTranscriptionCheckBox().clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.clickOnNewStudy();
		Thread.sleep(10000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnViewModifyWebReportsOfAStudy(
				objViewPatients_data.strStudy);

		String mainwindow = driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		Iterator<String> itr = all.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.clickOnAddButton();

				Set<String> all1 = driver.getWindowHandles();
				Iterator<String> itr1 = all1.iterator();
				while (itr1.hasNext()) {
					String childwindow1 = itr1.next().toString();
					if (!childwindow1.contains(mainwindow)
							&& (!childwindow1.contains(childwindow))) {
						driver.switchTo().window(childwindow1);
						Thread.sleep(3000);
						objViewPatients
								.verRadiologyReportPageIsDisplayed(objViewPatients_data.strEditReportTitle);
						driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the "Express Transcription" form is made as default report 
                     and the same is opened when "Use Express Transcription as default report editor" is enabled .     
    'Precondition  :
    'Date          : 31-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the 'Express Transcription' form is made as default report "
			+ "and the same is opened when 'Use Express Transcription as default report editor' is enabled.")
	public void testHappyDay64047() throws Exception {

		gstrTCID = "64047";
		gstrTO = "Verify that the 'Express Transcription ' form is made as default report and the same is"
				+ " opened when 'Use Express Transcription as default report editor' is enabled .";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
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
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.selExpressTranscriptionCheckBox().clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(10000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);

		String mainwindow = driver.getWindowHandle();
		String childwindow = "";
		Set<String> all = driver.getWindowHandles();
		Iterator<String> itr = all.iterator();
		while (itr.hasNext()) {
			childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.clickOnAddButton();

				Set<String> all1 = driver.getWindowHandles();
				Iterator<String> itr1 = all1.iterator();
				while (itr1.hasNext()) {
					String childwindow1 = itr1.next().toString();
					if (!childwindow1.contains(mainwindow)
							&& (!childwindow1.contains(childwindow))) {
						driver.switchTo().window(childwindow1);
						Thread.sleep(3000);
						String strwindowtitle = driver.getTitle();
						System.out.println(strwindowtitle);
						objViewPatients
								.verExpressTranscriptionPageIsDisplayed(objViewPatients_data.expressTranscription);
						driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that the study is automatically marked as 'Read' when the option 
                     'Mark study as 'Read' when the report is signed' is enabled.     
    'Precondition  :
    'Date          : 31-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the study is automatically marked as 'Read' when the option "
			+ "'Mark study as 'Read' when the report is signed' is enabled.")
	public void testHappyDay68326() throws Exception {

		gstrTCID = "68326";
		gstrTO = "Verify that the study is automatically marked as 'Read' when the option "
				+ "'Mark study as 'Read' when the report is signed' is enabled.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
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
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.selMarkStudyAsReadCheckBox()
				.selHTMLReportEditorCheckBox()
				.deSelExpressTranscriptionCheckBox().clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		Thread.sleep(3000);
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.selInLastOption(objDICOMSettings_data.hour).clickOnSearch1();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);

		String mainwindow = driver.getWindowHandle();
		String childwindow = "";
		Set<String> all = driver.getWindowHandles();
		Iterator<String> itr = all.iterator();
		while (itr.hasNext()) {
			childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.clickOnAddButton();
			}
		}

		Set<String> all1 = driver.getWindowHandles();
		Iterator<String> itr1 = all1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!childwindow1.contains(mainwindow)
					&& (!childwindow1.contains(childwindow))) {
				driver.switchTo().window(childwindow1);
				Thread.sleep(3000);

				objViewPatients.clickOnSaveSignReport().clickOnSignReport();
				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(childwindow);
		driver.close();
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch();
		objViewPatients
				.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch()
				.clickOnSearch()
				.selLayout(objViewPatients_data.strLayout)
				.verThisStudyReadCheckBoxIsEnabled(
						objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that the digital signature appears at the bottom of a signed report
                     when 'Add Digital Signature block to Signed reports' option is enabled.     
    'Precondition  :
    'Date          : 01-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the digital signature appears at the bottom of a signed report"
			+ " when 'Add Digital Signature block to Signed reports' option is enabled.")
	public void testHappyDay68324() throws Exception {

		gstrTCID = "68324";
		gstrTO = "Verify that the digital signature appears at the bottom of a signed report when "
				+ "'Add Digital Signature block to Signed reports' option is enabled.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		PersonalProfile objPersonalProfile = new PersonalProfile(this.driver);

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

		String fileSignaturePath = pathProps
				.getProperty(objPathData.strSignatureFileUpload);

		File jpegfile = new File(System.getProperty("user.dir")
				+ fileSignaturePath);
		String strJpegPath = jpegfile.toString();
		System.out.println(strJpegPath);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.selAddDigitalSignatureBlockCheckBox()
				.selHTMLReportEditorCheckBox()
				.deSelExpressTranscriptionCheckBox().clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnPreferences();
		objAddUser.uploadFile1(strJpegPath);
		objPersonalProfile.clickOnSaveChanges();
		objHome.clickOnViewPatients();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(10000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients.clickOnSearch1().clickOnViewModifyWebReportsOfAStudy(
				objViewPatients_data.strStudy);

		String mainwindow = driver.getWindowHandle();
		String childwindow = "";
		Set<String> all = driver.getWindowHandles();
		Iterator<String> itr = all.iterator();
		while (itr.hasNext()) {
			childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.clickOnAddButton();
			}
		}

		Set<String> all1 = driver.getWindowHandles();
		Iterator<String> itr1 = all1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!childwindow1.contains(mainwindow)
					&& (!childwindow1.contains(childwindow))) {
				driver.switchTo().window(childwindow1);
				Thread.sleep(3000);

				objViewPatients.clickOnSaveSignReport().clickOnSignReport();
				Thread.sleep(3000);
			}
		}
		// driver.close();
		driver.switchTo().window(childwindow);
		driver.navigate().refresh();
		objViewPatients.clickOnStudyInWebReporterPage();

		Set<String> all2 = driver.getWindowHandles();
		Iterator<String> itr2 = all2.iterator();
		while (itr2.hasNext()) {
			String childwindow2 = itr2.next().toString();
			if (!childwindow2.contains(mainwindow)
					&& (!childwindow2.contains(childwindow))) {
				driver.switchTo().window(childwindow2);
				Thread.sleep(3000);
				objViewPatients.verUploadedSigFileInWebReporterPage();
				driver.close();

			}
		}
		driver.switchTo().window(childwindow);
		driver.close();
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that an Accession number is automatically assigned for the incoming
                     studies which are not having Accession number when option 'Assign unique Accession
                     number to the study if this field is not set' is enabled.     
    'Precondition  :
    'Date          : 02-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that an Accession number is automatically assigned for the incoming"
			+ " studies which are not having Accession number when option 'Assign unique Accession number"
			+ " to the study if this field is not set' is enabled.")
	public void testHappyDay59406() throws Exception {

		gstrTCID = "59406";
		gstrTO = "Verify that an Accession number is automatically assigned for the incoming studies which"
				+ " are not having Accession number when option 'Assign unique Accession number to the study if"
				+ " this field is not set' is enabled ";

		Login_data objLogin_data = new Login_data();
		Study_data objStudy_data = new Study_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		ModifyStudy objModifyStudy = new ModifyStudy(this.driver);
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
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting
				.enterTextInMTFCode(objDICOMSettings_data.mtfcode)
				.selAssignUniqueAccessionNumberRadioButton()
				.enterTextInACCNUMTemplate(objDICOMSettings_data.ACCNUMTemplate)
				.clickOnSaveChanges();
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
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();

		objHome.clickOnLogOut();

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		Thread.sleep(3000);
		objHome.clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clearMTFCode()
				.selAddMTFToMedwebDicomFieldOnlyRadioButton()
				.clickOnSaveChanges().clickOnDestinations();
		objDestinations.clickOnAdd().verDestinationEditorPage();
		objDestinations.selectGenericStorageSCPCheckBox()
				.selectGenericStorageSCUCheckBox().selectMedwebDeviceCheckBox()
				.selectMitraReportSCPCheckBox().selectMitraReportSCUCheckBox()
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

		objDICOMSetting.clickOnAETitleRouting();
		boolean actual = objAETitleRouting.delAllExistingRoute();
		while (actual == true) {
			objNavigationToSubMenus.clickOnDICOMSettings();
			objDICOMSetting.clickOnAETitleRouting();
			actual = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual + " aa");

		}

		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println(allwindows.size() + " no of windows");
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				driver.switchTo().window(mainwindow);
				System.out.println(" yes window is dr");

			}
		}
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		System.out.println(objViewPatients_data.strStudy);
		Thread.sleep(5000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch1();
		objViewPatients
				.clickOnModifyStudyFieldsOfAStudy(objViewPatients_data.strStudy);
		String childwindow1 = "";
		Set<String> all = driver.getWindowHandles();
		Iterator<String> itr1 = all.iterator();
		while (itr1.hasNext()) {
			childwindow1 = itr1.next().toString();
			if (!childwindow1.contains(mainwindow)) {
				driver.switchTo().window(childwindow1);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objModifyStudy.clearTextInAccessionNumber();
				objDestinations.clickOnSaveChanges();
				objModifyStudy.clickOnClose();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients
				.clickOnSendThisStudyToDICOMStorageDevice(objViewPatients_data.strStudy);

		Set<String> all1 = driver.getWindowHandles();
		Iterator<String> itr2 = all1.iterator();
		while (itr2.hasNext()) {
			String childwindow2 = itr2.next().toString();
			if (!childwindow2.contains(mainwindow)) {
				driver.switchTo().window(childwindow2);
				Thread.sleep(3000);
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		Thread.sleep(3000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy).clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objViewPatients
				.clickOnModifyStudyFieldsOfAStudy(objViewPatients_data.strStudy);
		Set<String> all2 = driver.getWindowHandles();
		Iterator<String> itr3 = all2.iterator();
		while (itr3.hasNext()) {
			String childwindow3 = itr3.next().toString();
			if (!childwindow3.contains(mainwindow)) {
				driver.switchTo().window(childwindow3);
				objModifyStudy
						.getTextInAccessionNumberAndVerWithNumber(objDICOMSettings_data.mtfcode
								+ "#" + objStudy_data.accessionNumber);

			}
		}
		driver.close();
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that MTF code of the receiving server is added to the "Accession Number"
                     & "DICOM Fields" when study received does not have MTF and "Add MTF to Accession number
                     and Medweb DICOM field" option is enabled in the receiving server.     
    'Precondition  :
    'Date          : 03-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that MTF code of the receiving server is added to the 'Accession"
			+ " Number' & 'DICOM Fields' when study received does not have MTF and 'Add MTF to Accession"
			+ " number and Medweb DICOM field' option is enabled in the receiving server ")
	public void testHappyDay167035() throws Exception {

		gstrTCID = "167035";
		gstrTO = "Verify that MTF code of the receiving server is added to the 'Accession Number' & "
				+ "'DICOM Fields' when study received does not have MTF and 'Add MTF to Accession number"
				+ " and Medweb DICOM field' option is enabled in the receiving server ";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		ModifyStudy objModifyStudy = new ModifyStudy(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileAutoITDownloadPath = pathProps
				.getProperty(objPathData.autoItFilePath3);
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
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clearMTFCode().clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.enterTextInMTFCode(objDICOMSettings_data.mtfcode)
				.selAddMTFToAccessionNumberRadioButton().clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> itr3 = allwin.iterator();
		if (itr3.hasNext() == true) {
			while (itr3.hasNext()) {
				String chwn = itr3.next().toString();
				if (!chwn.contains(mainwindow)) {
					driver.switchTo().window(chwn);
					objCommonFunctions.clickOnContinueToThisWebsiteLink();
				}
			}
			// driver.switchTo().window(mainwindow);
		}
		Thread.sleep(5000);

		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch1();
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients
				.clickOnSendThisStudyToDICOMStorageDevice(objViewPatients_data.strStudy);

		Set<String> all1 = driver.getWindowHandles();
		Iterator<String> itr1 = all1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!childwindow1.contains(mainwindow)) {
				driver.switchTo().window(childwindow1);
				Thread.sleep(3000);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy).clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objViewPatients
				.clickOnModifyStudyFieldsOfAStudy(objViewPatients_data.strStudy);
		Set<String> all2 = driver.getWindowHandles();
		Iterator<String> itr2 = all2.iterator();
		while (itr2.hasNext()) {
			String childwindow2 = itr2.next().toString();
			if (!childwindow2.contains(mainwindow)) {
				driver.switchTo().window(childwindow2);
				String actual = objModifyStudy
						.getTextInAccessionNumberAndVer(objDICOMSettings_data.mtfcode);
				objModifyStudy
						.getTextInMTFFieldAndVer(objDICOMSettings_data.mtfcode);

				String[] actual1 = actual.split("#");
				System.out.println(actual1[0]);
				System.out.println(actual1[1]);
			}
		}
		driver.close();
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that MTF code of the receiving server is added to the "DICOM Fields"
                     only when study received does not have MTF and "Add MTF to Medweb DICOM field
                     only (7deb:0103)" option is enabled in the receiving server.     
    'Precondition  :
    'Date          : 04-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that MTF code of the receiving server is added to the DICOM Fields"
			+ " only when study received does not have MTF and Add MTF to Medweb DICOM field only "
			+ "(7deb:0103) option is enabled in the receiving server.")
	public void testHappyDay167038() throws Exception {

		gstrTCID = "167038";
		gstrTO = "Verify that MTF code of the receiving server is added to the DICOM Fields only "
				+ "when study received does not have MTF and Add MTF to Medweb DICOM field only (7deb:0103)"
				+ " option is enabled in the receiving server.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		ModifyStudy objModifyStudy = new ModifyStudy(this.driver);
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
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clearMTFCode().clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.enterTextInMTFCode(objDICOMSettings_data.mtfcode)
				.selAddMTFToMedwebDicomFieldOnlyRadioButton()
				.clickOnSaveChanges().clickOnDestinations();
		objDestinations.clickOnAdd().verDestinationEditorPage();
		objDestinations.selectGenericStorageSCPCheckBox()
				.selectGenericStorageSCUCheckBox().selectMedwebDeviceCheckBox()
				.selectMitraReportSCPCheckBox().selectMitraReportSCUCheckBox()
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
		objDICOMSetting.clickOnAETitleRouting1();
		boolean actual = objAETitleRouting.delAllExistingRoute();
		while (actual == true) {
			objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
			objDICOMSetting.clickOnAETitleRouting();
			actual = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual + " aa");

		}
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> itr3 = allwin.iterator();
		if (itr3.hasNext() == true) {
			while (itr3.hasNext()) {
				String chwn = itr3.next().toString();
				if (!chwn.contains(mainwindow)) {
					driver.switchTo().window(chwn);
					objCommonFunctions.clickOnContinueToThisWebsiteLink();
				}
			}
		}
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);

		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch1();
		objViewPatients
				.clickOnSendThisStudyToDICOMStorageDevice(objViewPatients_data.strStudy);

		Set<String> all1 = driver.getWindowHandles();
		Iterator<String> itr1 = all1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!childwindow1.contains(mainwindow)) {
				driver.switchTo().window(childwindow1);
				Thread.sleep(3000);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy).clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objViewPatients
				.clickOnModifyStudyFieldsOfAStudy(objViewPatients_data.strStudy);
		Set<String> all2 = driver.getWindowHandles();
		Iterator<String> itr2 = all2.iterator();
		while (itr2.hasNext()) {
			String childwindow2 = itr2.next().toString();
			if (!childwindow2.contains(mainwindow)) {
				driver.switchTo().window(childwindow2);
				objModifyStudy
						.getTextInAccessionNumberAndVerNotContainMtfCode(objDICOMSettings_data.mtfcode);
				objModifyStudy
						.getTextInMTFFieldAndVer(objDICOMSettings_data.mtfcode);

			}
		}
		driver.close();
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	
	/*************************************************************************************
    'Description   : Verify that MTF code of the receiving server is not added to the "Accession
                     Number" nor to the "DICOM Fields" when receiving study does not have MTF and
                     "Disable MTF" option is enabled in the receiving server.     
    'Precondition  :
    'Date          : 04-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that MTF code of the receiving server is not added to the Accession"
			+ " Number nor to the DICOM Fields when receiving study does not have MTF and Disable MTF"
			+ " option is enabled in the receiving server.")
	public void testHappyDay167039() throws Exception {

		gstrTCID = "167039";
		gstrTO = "Verify that MTF code of the receiving server is not added to the Accession Number"
				+ " nor to the DICOM Fields when receiving study does not have MTF and Disable MTF option"
				+ " is enabled in the receiving server.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		ModifyStudy objModifyStudy = new ModifyStudy(this.driver);
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
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clearMTFCode().clickOnSaveChanges();
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
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.enterTextInMTFCode(objDICOMSettings_data.mtfcode)
				.selDisableMTFRadioButton().clickOnSaveChanges()
				.clickOnDestinations();
		objDestinations.clickOnAdd().verDestinationEditorPage();
		objDestinations.selectGenericStorageSCPCheckBox()
				.selectGenericStorageSCUCheckBox().selectMedwebDeviceCheckBox()
				.selectMitraReportSCPCheckBox().selectMitraReportSCUCheckBox()
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
		objDICOMSetting.clickOnAETitleRouting1();
		boolean actual = objAETitleRouting.delAllExistingRoute();
		while (actual == true) {
			objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
			objDICOMSetting.clickOnAETitleRouting();
			actual = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual + " aa");

		}
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> itr3 = allwin.iterator();
		if (itr3.hasNext() == true) {
			while (itr3.hasNext()) {
				String chwn = itr3.next().toString();
				if (!chwn.contains(mainwindow)) {
					driver.switchTo().window(chwn);
					objCommonFunctions.clickOnContinueToThisWebsiteLink();
				}
			}
			// driver.switchTo().window(mainwindow);
		}
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch1();
		objViewPatients
				.clickOnSendThisStudyToDICOMStorageDevice(objViewPatients_data.strStudy);
		System.out.println(objViewPatients_data.strStudy);

		Set<String> all1 = driver.getWindowHandles();
		Iterator<String> itr1 = all1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!childwindow1.contains(mainwindow)) {
				driver.switchTo().window(childwindow1);
				Thread.sleep(3000);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy).clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objViewPatients
				.clickOnModifyStudyFieldsOfAStudy(objViewPatients_data.strStudy);
		Set<String> all2 = driver.getWindowHandles();
		Iterator<String> itr2 = all2.iterator();
		while (itr2.hasNext()) {
			String childwindow2 = itr2.next().toString();
			if (!childwindow2.contains(mainwindow)) {
				driver.switchTo().window(childwindow2);
				objModifyStudy
						.getTextInAccessionNumberAndVerNotContainMtfCode(objDICOMSettings_data.mtfcode);
				objModifyStudy
						.getTextInMTFFieldAndVerMtfCodeNotDisplayed(objDICOMSettings_data.mtfcode);

			}
		}
		driver.close();
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the QC sandbox studies are released after modifying the patient 
                     name or patient ID or DOB when "Release studies from Trauma Sandbox when new data
                     was added to the DICOM fields" is enabled in the Local Settings page.     
    'Precondition  :
    'Date          : 14-Apr-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the QC sandbox studies are released after modifying the patient name or "
			+ "patient ID or DOB when Release studies from Trauma Sandbox when new data was added to the DICOM fields"
			+ " is enabled in the Local Settings page.")
	public void testHappyDay68341() throws Exception {

		gstrTCID = "68341";
		gstrTO = "Verify that the QC sandbox studies are released after modifying the patient name or patient "
				+ "ID or DOB when Release studies from Trauma Sandbox when new data was added to the DICOM fields"
				+ " is enabled in the Local Settings page.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);

		AutoIT objAutoIT = new AutoIT(this.driver);
		ModifyStudy objModifyStudy = new ModifyStudy(this.driver);

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
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.selReleaseStudiesFromTraumaSandboxCheckBox()
				.clickOnSaveChanges();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		for(int i=0;i<3;i++){
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1()
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selOneOrMoreCompleteSeriesInThisStudyRadioButton()
						.clickOnProceedButton()
						.clickOnSelAllInSplitMergeMoveWizard()
						.clickOnMoveInSplitMergeMoveWizard()
						.clickOnNewStudyInSplitMergeMoveWizard()
						.clickOnOKInSplitMergeMoveWizard();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.clickOnSearch().clickOnSearch();

		objViewPatients
				.clickOnModifyStudyFieldsOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.equals(mainwindow)) {
				driver.switchTo().window(childwindow);
				if(i==0){
				objModifyStudy
						.enterTextInDOBTextField(objViewPatients_data.dob);
				objDestinations.clickOnSaveChanges();
				objModifyStudy.clickOnClose();
				}
				else if(i==1) {
					objModifyStudy
					.enterTextInPatientIDTextField(objViewPatients_data.pid);
			objDestinations.clickOnSaveChanges();
			objModifyStudy.clickOnClose();
				}
				else{
					objModifyStudy
					.enterTextInPatientNameTextField(objViewPatients_data.pn);
			objDestinations.clickOnSaveChanges();
			objModifyStudy.clickOnClose();
				}
				driver.switchTo().window(mainwindow);
					
				}
			}
		
		
		//driver.switchTo().window(mainwindow);
	if(i==0 ||i==1){
		objViewPatients.clickOnSearch().clickOnSearch()
				.verNoStudiesAvailableErrorMessage()
				.selStatusOption(objViewPatients_data.ststusAny)
				.clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy);
	}
	else{
		objViewPatients.enterTextInFind(objViewPatients_data.pn).clickOnSearch().clickOnSearch()
		.verNoStudiesAvailableErrorMessage()
		.selStatusOption(objViewPatients_data.ststusAny)
		.clickOnSearch()
		.verStudyFromOtherServer(objViewPatients_data.pn);
		
	}
		}
		objViewPatients.clickOnLogout();
	

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that all the studies in the QC state are released automatically 
                     from the QC when Release studies from QC Sandbox after xxx mins is enabled 
                     in 'DICOM Settings > Local Settings page.     
    'Precondition  :
    'Date          : 23-Jun-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled = false, description = "Verify that all the studies in the QC state are released automatically from "
			+ "the QC when Release studies from QC Sandbox after xxx mins is enabled in 'DICOM Settings >"
			+ " Local Settings page.")
	public void testHappyDay68342() throws Exception {

		gstrTCID = "68342";
		gstrTO = "Verify that all the studies in the QC state are released automatically from the QC when Release"
				+ " studies from QC Sandbox after xxx mins is enabled in 'DICOM Settings > Local Settings page.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);

		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileAutoITDownloadPath = pathProps
				.getProperty(objPathData.autoItFilePath4);
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
		objHome.verHomePage().clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		System.out.println(objViewPatients_data.strStudy);
		String str[] = { objViewPatients_data.strStudy,
				objViewPatients_data.strStudy1 };
		for (int i = 0; i < 2; i++) {
			objViewPatients.clickOnNewStudy();
			Thread.sleep(5000);
			objAutoIT.CreateStudy(strAutoitPath, str[i], str[i], strImagePath,
					objViewPatients_data.strModalityDS);
			Thread.sleep(3000);
			objViewPatients.selInLastOption(objDICOMSettings_data.hour)
					.enterTextInFind(str[i]);
			objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
					.clickOnSearch().clickOnSearch().clickOnSearch()
					.clickOnSearch().clickOnModifyStudyIconOfAStudy(str[i]);
			String mainwindow = driver.getWindowHandle();
			Set<String> allwindows = driver.getWindowHandles();
			Iterator<String> itr = allwindows.iterator();
			while (itr.hasNext()) {
				String childwindow = itr.next().toString();
				if (!childwindow.contains(mainwindow)) {
					driver.switchTo().window(childwindow);
					objViewPatients
							.selOneOrMoreCompleteSeriesInThisStudyRadioButton()
							.clickOnProceedButton()
							.clickOnSelAllInSplitMergeMoveWizard()
							.clickOnMoveInSplitMergeMoveWizard()
							.clickOnNewStudyInSplitMergeMoveWizard()
							.clickOnOKInSplitMergeMoveWizard();
				}
			}
			driver.switchTo().window(mainwindow);
			objViewPatients.selStatusOption(objViewPatients_data.strStatus)
					.clickOnSearch().clickOnSearch();
		}
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(str[0].substring(10)).clickOnSearch()
				.clickOnSearch().verStudyFromOtherServer(str[0])
				.verStudyFromOtherServer(str[1]);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting
				.selReleaseStudiesFromQCSandboxAfterXXXMinutesCheckBox()
				.enterTextReleaseStudiesFromQCSandboxAfterXXXMinutesField(
						objDICOMSettings_data.strTime).clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnViewPatients();
		TimeUnit.MINUTES.sleep(Integer.parseInt(objDICOMSettings_data.strTime));
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.clickOnSearch().clickOnSearch()
				.verNoStudiesAvailableErrorMessage();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the incoming study is marked as STAT when 'Mark study as STAT' is enabled.     
    'Precondition  :
    'Date          : 14-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the incoming study is marked as STAT when 'Mark study as STAT' is enabled.")
	public void testHappyDay68311() throws Exception {

		gstrTCID = "68311";
		gstrTO = "Verify that the incoming study is marked as STAT when 'Mark study as STAT' is enabled.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
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
		objHome.verHomePage().clickOnAdminSite();
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
		objDestinations.enterTextInAETitleField(objDICOMSettings_data.aETitle1)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddress)
				.enterTextInLabelField(objDICOMSettings_data.label)
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnAliasesLinkOfAeTitle()
				.clickOnAddInDICOMAliases()
				.enterAliasName(objDICOMSettings_data.aliasName)
				.selMarkStudySTATCheckBox().selProxyQRRequestsToCheckBox()
				.selDestinationAetitleCheckBox(objDICOMSettings_data.aETitle1)
				.clickOnSaveChanges();
		System.out.println(objDICOMSettings_data.aliasname);
		Thread.sleep(5000);
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
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
		objDestinations.clickOnModifyServer(objLogin_data.server);
		objDestinations
				.enterTextInAETitleField(objDICOMSettings_data.aliasName)
				.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		System.out.println(objViewPatients_data.strStudy);

		objViewPatients.clickOnNewStudy();

		String mainWindow = driver.getWindowHandle();
		Set<String> str = driver.getWindowHandles();
		Iterator<String> itr = str.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				driver.switchTo().window(mainWindow);
			}
		}

		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1()
				.clickOnSendThisStudyToDICOMStorageDevice(
						objViewPatients_data.strStudy);
		Set<String> str1 = driver.getWindowHandles();
		Iterator<String> itr1 = str1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice)
						.clickOnFinishButton();
				Thread.sleep(3000);
			}
		}

		Set<String> str2 = driver.getWindowHandles();
		Iterator<String> itr2 = str2.iterator();
		while (itr2.hasNext()) {
			String childwindow1 = itr2.next().toString();
			System.out.println(childwindow1 + "secondcldwnd");
			if (!childwindow1.contains(mainWindow)) {
				driver.switchTo().window(childwindow1);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch();
		Thread.sleep(2000);
		objViewPatients.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStatStatus(objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the received private records are replaced by fake data when 
                     'Anonymize Study' option is enabled.     
    'Precondition  :
    'Date          : 19-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the received private records are replaced by fake data when "
			+ "'Anonymize Study' option is enabled.")
	public void testHappyDay68315() throws Exception {

		gstrTCID = "68315";
		gstrTO = "Verify that the received private records are replaced by fake data when 'Anonymize"
				+ " Study' option is enabled.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
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
		objHome.verHomePage().clickOnAdminSite();
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
		objDestinations.enterTextInAETitleField(objDICOMSettings_data.aETitle1)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddress)
				.enterTextInLabelField(objDICOMSettings_data.label)
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnAliasesLinkOfAeTitle()
				.clickOnAddInDICOMAliases()
				.enterAliasName(objDICOMSettings_data.aliasNameAnonymize)
				.selAnonymizeStudyCheckBox().selProxyQRRequestsToCheckBox()
				.selDestinationAetitleCheckBox(objDICOMSettings_data.aETitle1)
				.clickOnSaveChanges();
		Thread.sleep(5000);
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnDestinations();
		objDestinations.DelDestination(objDICOMSettings_data.ipAddress1)
				.clickOnAdd().verDestinationEditorPage();
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
		objDestinations.clickOnModifyServer(objLogin_data.server);
		objDestinations.enterTextInAETitleField(
				objDICOMSettings_data.aliasNameAnonymize).clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnNewStudy();
		String mainWindow = driver.getWindowHandle();
		Set<String> str = driver.getWindowHandles();
		Iterator<String> itr = str.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				driver.switchTo().window(mainWindow);
			}
		}

		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityNM);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();
		String strtime = objViewPatients.getTimeOfAStudy(
				objViewPatients_data.strStudy).trim();
		System.out.println(strtime + " this is the study time");
		objViewPatients
				.clickOnSendThisStudyToDICOMStorageDevice(objViewPatients_data.strStudy);
		Set<String> str1 = driver.getWindowHandles();
		Iterator<String> itr1 = str1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
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
		objViewPatients.clickOnSearch().clickOnSearch();
		Thread.sleep(3000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.selModalityOption(objViewPatients_data.strModalityNM);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verFakeDataOfStudy(strtime);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that Stat of the study is retained that is auto-forwarded to the 
                     Destination Server when "Convert images to JPEG2000 before auto-forwarding" option
                     is enabled and images are uploaded in the "CaptureApp" interface in the Source Server.     
    'Precondition  :
    'Date          : 25-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Stat of the study is retained that is auto-forwarded to the Destination "
			+ "Server when Convert images to JPEG2000 before auto-forwarding option is enabled and images are"
			+ " uploaded in the CaptureApp interface in the Source Server.")
	public void testHappyDay68340() throws Exception {

		gstrTCID = "68340";
		gstrTO = "Verify that Stat of the study is retained that is auto-forwarded to the Destination "
				+ "Server when Convert images to JPEG2000 before auto-forwarding option is enabled and"
				+ " images are uploaded in the CaptureApp interface in the Source Server.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		MachineSchedule objMachineSchedule = new MachineSchedule(this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String fileAutoITCreateStudyPath = pathProps
				.getProperty(objPathData.autoItFilePathLocalService);
		System.out.println(fileAutoITCreateStudyPath);
		File autoitfile = new File(System.getProperty("user.dir")
				+ fileAutoITCreateStudyPath);
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

		objHome.launchApplication(objLogin_data.strAppURL);
		driver.switchTo().defaultContent();
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting
				.selConvertImagesToJPEG2000BeforeAutoForwardingCheckBox()
				.clickOnSaveChanges().clickOnDestinations();
		objDestinations.clickOnAdd().verDestinationEditorPage();
		objDestinations.selectGenericStorageSCPCheckBox()
				.selectGenericStorageSCUCheckBox().selectMedwebDeviceCheckBox()
				.selectMitraReportSCPCheckBox().selectMitraReportSCUCheckBox()
				.selectRetrievePatientSCPCheckBox()
				.selectRetrievePatientSCUCheckBox()
				.selectRetrievePatientStudySCPCheckBox()
				.selectRetrievePatientStudySCUCheckBox()
				.selectRetrieveStudySCPCheckBox()
				.selectRetrieveStudySCUCheckBox();
		objDestinations.enterTextInAETitleField(objDICOMSettings_data.aETitle1)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddress)
				.enterTextInLabelField(objDICOMSettings_data.label)
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();

		objDICOMSetting.clickOnAETitleRouting();
		boolean actual = objAETitleRouting.delAllExistingRoute();
		while (actual == true) {
			objNavigationToSubMenus.clickOnDICOMSettings();
			objDICOMSetting.clickOnAETitleRouting();
			actual = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual + " aa");

		}
		objDestinations.clickOnAdd();
		objAETitleRouting
				.selectAEDestinationInDropDown(
						objDICOMSettings_data.aeTitleDestination)
				.selectAttributeInRule1DropDown(
						objDICOMSettings_data.strPatientName)
				.selRouteStudiesChechbox();
		objAETitleRouting
				.enterTextInMatchKeyOfRule1(objDICOMSettings_data.strmatchkey5);
		objDestinations.clickOnSaveChanges();
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
				Thread.sleep(2000);
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
		objHome.clickOnViewPatients();
		objViewPatients.clickOnPreferences().selAdvancedViewerIERadioButton()
				.clickOnSaveChanges();
		objHome.clickOnViewPatients();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(str3).clickOnSearch().clickOnStudy(str2);
		Thread.sleep(2000);
		objAutoIT.addImagesToTheExistingStudyOrOrder(strAutoitPath,
				strImagePath);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(str3);
		objViewPatients.clickOnSearch1().clickOnSearchTillStudySent()
				.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients.enterTextInFind(str2).clickOnSearch().clickOnSearch()
				.verStatStatus(str2).clickOnLogout();

		gstrResult = "PASS";
	}

}
