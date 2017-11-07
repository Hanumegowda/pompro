package rhel6DiacapServer.requirementGroup.smokeSuit.DICOMSettings;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.User_data;
import dataObject.ViewPatients_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AETitleRouting;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.ControlPanel;
import page.DICOMSetting;
import page.Destinations;
import page.Home;
import page.Login;
import page.MedwebSecureTunnel;
import page.UserManagement;
import page.ViewPatients;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayAddingDestination extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayAddingDestination() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the studies are routed to destination server using DICOM Protocol
                     when the option 'DICOM Protocol' is enabled under Transport(included 167476,167477).     
    'Precondition  :
    'Date          : 09-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the studies are routed to destination server using DICOM "
			+ "Protocol when the option ' DICOM Protocol' is enabled under Transport.")
	public void testHappyDay167476() throws Exception {

		gstrTCID = "167476";
		gstrTO = "Verify that the studies are routed to destination server using DICOM Protocol"
				+ " when the option 'DICOM Protocol' is enabled under Transport.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		Login objLogin = new Login(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);

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
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);

		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);

		objViewPatients.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients
				.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch1()
				.clickOnSendThisStudyToDICOMStorageDevice(
						objViewPatients_data.strStudy);
		String mainWindow = driver.getWindowHandle();
		Set<String> str = driver.getWindowHandles();
		Iterator<String> itr = str.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice1)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.selStudy(objViewPatients_data.strStudy);
		objViewPatients.delAllSelectedStudies();
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verNoStudiesAvailableErrorMessage();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
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
				.selRouteEngineType(objDICOMSettings_data.routeEngineStandard);
		objDestinations.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);

		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy2,
				objViewPatients_data.strStudy2, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);

		objViewPatients.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients
				.enterTextInFind(objViewPatients_data.strStudy2)
				.clickOnSearch1()
				.clickOnSendThisStudyToDICOMStorageDevice(
						objViewPatients_data.strStudy2);
		Set<String> str1 = driver.getWindowHandles();
		Iterator<String> itr1 = str1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice1)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy2)
				.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that the studies are routed to destination server using DICOM Protocol
                     when the option 'DICOM Protocol' is enabled under Transport(included 167476,167477).     
    'Precondition  :
    'Date          : 09-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that the studies are routed to destination server using DICOM "
			+ "Protocol when the option ' DICOM Protocol' is enabled under Transport.")
	public void testHappyDay167477() throws Exception {

		gstrTCID = "167477";
		gstrTO = "Verify that the studies are routed to destination server using DICOM Protocol"
				+ " when the option 'DICOM Protocol' is enabled under Transport.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
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
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
        TimeUnit.MINUTES.sleep(2);
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that the studies are routed to destination server using FTP over 
                     secure tunnel Protocol when the option 'FTP over Secure Tunnel (for slow/satellite
                     links)' is enabled under Transport(167478,167479 included in this only).     
    'Precondition  :
    'Date          : 10-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the studies are routed to destination server using FTP over"
			+ " secure tunnel Protocol when the option 'FTP over Secure Tunnel (for slow/satellite links)'"
			+ " is enabled under Transport.")
	public void testHappyDay167478() throws Exception {

		gstrTCID = "167478";
		gstrTO = "Verify that the studies are routed to destination server using FTP over secure"
				+ " tunnel Protocol when the option ' FTP over Secure Tunnel (for slow/satellite links)'"
				+ " is enabled under Transport.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Home objHome = new Home(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		MedwebSecureTunnel objMedwebSecureTunnel = new MedwebSecureTunnel(
				this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);

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
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objMedwebSecureTunnel.clickOnGenerateButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		String str5 = objMedwebSecureTunnel
				.getTextFromLocalhostPublicKeySection();
		String str3 = str5.trim();
		System.out.println(str3);
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objControlPanel.clickOnAdd();
		objMedwebSecureTunnel.enterTextInRemoteHostPublicKeySection(str3);
		objAddUser.clickOnSaveChanges();
		objMedwebSecureTunnel.clickOnGenerateButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		String str2 = objMedwebSecureTunnel
				.getTextFromLocalhostPublicKeySection();
		String str4 = str2.trim();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();

		objControlPanel.clickOnAdd();
		objMedwebSecureTunnel.enterTextInRemoteHostPublicKeySection(str4);
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
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objViewPatients.clickOnNewStudy();
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
		String mainWindow = driver.getWindowHandle();
		Set<String> str = driver.getWindowHandles();
		Iterator<String> itr = str.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice2)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
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
				.selRouteEngineType(objDICOMSettings_data.routeEngineStandard);
		objDestinations.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);

		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy2,
				objViewPatients_data.strStudy2, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy2);
		objViewPatients.clickOnSearch1()
				.clickOnSendThisStudyToDICOMStorageDevice(
						objViewPatients_data.strStudy2);
		Set<String> str1 = driver.getWindowHandles();
		Iterator<String> itr1 = str1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice2)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy2);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy2)
				.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that the studies are routed to destination server using FTP over 
                     secure tunnel Protocol when the option 'FTP over Secure Tunnel (for slow/satellite
                     links)' is enabled under Transport(167478,167479 included in this only).     
    'Precondition  :
    'Date          : 10-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that the studies are routed to destination server using FTP over"
			+ " secure tunnel Protocol when the option 'FTP over Secure Tunnel (for slow/satellite links)'"
			+ " is enabled under Transport.")
	public void testHappyDay167479() throws Exception {

		gstrTCID = "167479";
		gstrTO = "Verify that the studies are routed to destination server using FTP over secure"
				+ " tunnel Protocol when the option ' FTP over Secure Tunnel (for slow/satellite links)'"
				+ " is enabled under Transport.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
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
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		TimeUnit.MINUTES.sleep(2);

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that the studies are routed to destination server using DICOM over
                     secure tunnel Protocol when the option 'DICOM over Secure Tunnel is enabled
                     under Transport (68374,68375,68373,167481,167480 included in this only).     
    'Precondition  :
    'Date          : 14-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the studies are routed to destination server using DICOM "
			+ "over secure tunnel Protocol when the option 'DICOM over Secure Tunnel is enabled"
			+ " under Transport .")
	public void testHappyDay167481() throws Exception {

		gstrTCID = "167481";
		gstrTO = "Verify that the studies are routed to destination server using DICOM over secure"
				+ " tunnel Protocol when the option 'DICOM over Secure Tunnel is enabled under Transport.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Home objHome = new Home(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		MedwebSecureTunnel objMedwebSecureTunnel = new MedwebSecureTunnel(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);

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
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objMedwebSecureTunnel.clickOnGenerateButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		String str5 = objMedwebSecureTunnel
				.getTextFromLocalhostPublicKeySection();
		String str3 = str5.trim();
		System.out.println(str3);
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objControlPanel.clickOnAdd();
		objMedwebSecureTunnel.enterTextInRemoteHostPublicKeySection(str3);
		objAddUser.clickOnSaveChanges();
		objMedwebSecureTunnel.clickOnGenerateButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		String str2 = objMedwebSecureTunnel
				.getTextFromLocalhostPublicKeySection();
		String str4 = str2.trim();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();

		objControlPanel.clickOnAdd();
		objMedwebSecureTunnel.enterTextInRemoteHostPublicKeySection(str4);
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
				.selDICOMOverSecureTunnelRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();
		objDICOMSetting.clickOnAETitleRouting();
		// objAETitleRouting.delExistingRoute(objDICOMSettings_data.aETitle2);
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
		String mainWindow = driver.getWindowHandle();
		Set<String> str = driver.getWindowHandles();
		Iterator<String> itr = str.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(
								objDICOMSettings_data.storageDeviceForDICOMOverSecureTunnelProtocol)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
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
				.selDICOMOverSecureTunnelRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineStandard);
		objDestinations.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objViewPatients.clickOnNewStudy();

		Thread.sleep(5000);

		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy2,
				objViewPatients_data.strStudy2, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy2);
		objViewPatients.clickOnSearch1()
				.clickOnSendThisStudyToDICOMStorageDevice(
						objViewPatients_data.strStudy2);
		Set<String> str1 = driver.getWindowHandles();
		Iterator<String> itr1 = str1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(
								objDICOMSettings_data.storageDeviceForDICOMOverSecureTunnelProtocol)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy2);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy2)
				.clickOnLogout();

		gstrResult = "PASS";
	}

	/*************************************************************************************
    'Description   : Verify that the studies are routed to destination server using DICOM over
                     secure tunnel Protocol when the option 'DICOM over Secure Tunnel is enabled
                     under Transport (68374,68375,68373,167481,167480 included in this only).     
    'Precondition  :
    'Date          : 14-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that the studies are routed to destination server using DICOM "
			+ "over secure tunnel Protocol when the option 'DICOM over Secure Tunnel is enabled"
			+ " under Transport .")
	public void testHappyDay167480() throws Exception {

		gstrTCID = "167480";
		gstrTO = "Verify that the studies are routed to destination server using DICOM over secure"
				+ " tunnel Protocol when the option 'DICOM over Secure Tunnel is enabled under Transport.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
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
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		TimeUnit.MINUTES.sleep(2);
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that the study routed to the destination does not have data of Study 
	                   Management Events ( Create Study, Read etc) when the checkbox 'Receive Detached
	                   Study Management events' is enabled.     
	  'Precondition  :
	  'Date          : 22-Nov-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that the study routed to the destination does not have data of Study "
			+ "Management Events ( Create Study, Read etc) when the checkbox 'Receive Detached Study "
			+ "Management events' is enabled.")
	public void testHappyDay85046() throws Exception {

		gstrTCID = "85046";
		gstrTO = "Verify that the study routed to the destination does not have data of Study Management"
				+ " Events ( Create Study, Read etc) when the checkbox 'Receive Detached Study Management "
				+ "events' is enabled.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
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
		objDICOMSetting.selHTMLReportEditorCheckBox().clickOnSaveChanges()
				.clickOnDestinations();
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
		objDICOMSetting.clickOnAETitleRouting();
		boolean actual = objAETitleRouting.delAllExistingRoute();
		while (actual == true) {
			objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
			objDICOMSetting.clickOnAETitleRouting();
			actual = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual + " aa");

		}
		System.out.println(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(5000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.selInLastOption(objDICOMSettings_data.hour).clickOnSearch1();
		String mainWindow = driver.getWindowHandle();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr1 = aw.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!cw.contains(mainWindow)) {
				driver.switchTo().window(cw);
				objViewPatients.verWebReporterPage("Web-Reporter")
						.clickOnAddButton();
				Set<String> aw1 = driver.getWindowHandles();
				Iterator<String> itr2 = aw1.iterator();
				while (itr2.hasNext()) {
					String cw1 = itr2.next().toString();
					if ((!cw1.contains(mainWindow)) && (!cw1.contains(cw))) {
						driver.switchTo().window(cw1);
						objViewPatients.clickOnSaveReport();
						Thread.sleep(3000);
					}
				}
				driver.switchTo().window(cw);
				objViewPatients.verWebReporterPage("Web-Reporter")
						.clickOnAddButton();
				Set<String> aw2 = driver.getWindowHandles();
				Iterator<String> itr3 = aw2.iterator();
				while (itr3.hasNext()) {
					String cw3 = itr3.next().toString();
					if ((!cw3.contains(mainWindow)) && (!cw3.contains(cw))) {
						driver.switchTo().window(cw3);
						objViewPatients.clickOnSaveSignReport();
						objViewPatients.clickOnSignReport();
						Thread.sleep(3000);

					}
				}
				driver.switchTo().window(cw);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		objViewPatients
				.selMarkStudyAsReadCheckbox(objViewPatients_data.strStudy);
		objViewPatients
				.clickOnSendThisStudyToDICOMStorageDevice(objViewPatients_data.strStudy);
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println(allwindows.size());
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard();
				objViewPatients.selStorageDevice(
						objDICOMSettings_data.storageDevice1)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1()
				.selStatusOption(objViewPatients_data.strStatus2)
				.clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.verBlankReportIconOfAStudy(objViewPatients_data.strStudy)
				.selStatusOption(objViewPatients_data.strStatus1)
				.clickOnSearch().verNoStudiesAvailableErrorMessage()
				.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that a destination added is displayed in the "Current dicom image
	                   destinations" list when the following mandatory fields are filled: 1) AE Title
	                   2) IP address 3) Dicom IP Port 4) Label.     
	  'Precondition  :
	  'Date          : 24-Nov-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that a destination added is displayed in the Current dicom image destinations"
			+ " list when the following mandatory fields are filled: 1) AE Title 2) IP address 3) Dicom IP Port 4) Label.")
	public void testHappyDay128694() throws Exception {

		gstrTCID = "128694";
		gstrTO = "Verify that a destination added is displayed in the Current dicom image destinations"
				+ " list when the following mandatory fields are filled: 1) AE Title 2) IP address 3) Dicom IP Port 4) Label.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Login objLogin = new Login(this.driver);

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
		objDestinations.verAddedDestination(objDICOMSettings_data.aETitle1,
				objDICOMSettings_data.ipAddress,
				objDICOMSettings_data.dICOMIPPort, objDICOMSettings_data.label);
		objHome.clickOnLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that the images are delivered to the destination without time lag
	                   when the option 'deliver images immediately' is selected.     
	  'Precondition  :
	  'Date          : 02-Dec-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that the images are delivered to the destination without time lag "
			+ "when the option 'deliver images immediately' is selected.")
	public void testHappyDay68376() throws Exception {

		gstrTCID = "68376";
		gstrTO = "Verify that the images are delivered to the destination without time lag when "
				+ "the option 'deliver images immediately' is selected.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
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
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced)
				.selDeliverImagesImmediatelyRadioButton();
		objDestinations.clickOnSaveChanges();
		objDICOMSetting.clickOnAETitleRouting();
		boolean actual = objAETitleRouting.delAllExistingRoute();
		while (actual == true) {
			objNavigationToSubMenus.clickOnDICOMSettings();
			objDICOMSetting.clickOnAETitleRouting();
			actual = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual + " aa");

		}
		System.out.println(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(5000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.selInLastOption(objDICOMSettings_data.hour).clickOnSearch1();
		String mainWindow = driver.getWindowHandle();
		objViewPatients
				.clickOnSendThisStudyToDICOMStorageDevice(objViewPatients_data.strStudy);
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println(allwindows.size());
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard();
				objViewPatients.selStorageDevice(
						objDICOMSettings_data.storageDevice1)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch();
		boolean a = objViewPatients.clickOnPlusIconOfImagesToSend();
		if (a) {
			Set<String> aw = driver.getWindowHandles();
			Iterator<String> itr1 = aw.iterator();
			while (itr1.hasNext()) {
				String cw = itr1.next().toString();
				if (!cw.contains(mainWindow)) {
					driver.switchTo().window(cw);
					objViewPatients
							.VerifyStudyInDicomSpooler(
									objViewPatients_data.strStudy)
							.clickOnRefreshLinkInDicomSpooler()
							.clickOnRefreshLinkInDicomSpooler()
							.VerifyStudyNotDisplayedInDicomSpooler(
									objViewPatients_data.strStudy);
					driver.close();
				}
			}
			driver.switchTo().window(mainWindow);
			objViewPatients.clickOnLogout();
		}

		else {
			objHome.launchApplication(objLogin_data.strAppURL1);
			objCommonFunctions.clickOnContinueToThisWebsiteLink();
			objHome.clickOnViewPatients();
			objLogin.loginAsUser(objLogin_data.strAdminUser,
					objLogin_data.strAdminUserPwd).clickLogin();
			Thread.sleep(3000);
			objViewPatients.selInLastOption(objDICOMSettings_data.hour)
					.enterTextInFind(objViewPatients_data.strStudy);
			objViewPatients.clickOnSearch().clickOnSearch()
					.verStudyFromOtherServer(objViewPatients_data.strStudy);

		}
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}

}
