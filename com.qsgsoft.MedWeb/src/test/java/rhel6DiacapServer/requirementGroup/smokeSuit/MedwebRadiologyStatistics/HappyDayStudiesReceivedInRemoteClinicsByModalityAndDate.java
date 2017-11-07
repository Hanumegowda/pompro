package rhel6DiacapServer.requirementGroup.smokeSuit.MedwebRadiologyStatistics;

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
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.ControlPanel;
import page.DICOMRemapping;
import page.DICOMSetting;
import page.Destinations;
import page.Home;
import page.Login;
import page.MedwebSecureTunnel;
import page.PatientScheduleRegistration;
import page.Statistics;
import page.UserManagement;
import page.ViewPatients;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayStudiesReceivedInRemoteClinicsByModalityAndDate extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayStudiesReceivedInRemoteClinicsByModalityAndDate() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the statistics of studies received to all the Clinics are generated
                     for a selected custom time period.     
    'Precondition  :
    'Date          : 11-May-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the statistics of studies received to all the Clinics are generated "
			+ "for a selected custom time period.")
	public void testHappyDay69323() throws Exception {

		gstrTCID = "69323";
		gstrTO = "Verify that the statistics of studies received to all the Clinics are generated for a "
				+ "selected custom time period.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Home objHome = new Home(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		MedwebSecureTunnel objMedwebSecureTunnel = new MedwebSecureTunnel(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		DICOMRemapping objDICOMRemapping = new DICOMRemapping(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		Destinations objDestinations = new Destinations(this.driver);

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
		String rurl = objLogin_data.strAppURL1;
		String rurl1[] = rurl.split("//");
		String rul2 = rurl1[1];
		System.out.println(rul2 + " this is the clinic");
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objMedwebSecureTunnel.clickOnGenerateButton();
		Thread.sleep(5000);
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		String str5 = objMedwebSecureTunnel
				.getTextFromLocalhostPublicKeySection();
		String str3 = str5.trim();
		System.out.println(str3);
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
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
		objHome.clickOnLogOut92();
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

		objNavigationToSubMenus.clickOnDICOMSettings();
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
		objControlPanel.clickOnAddNewServer()
				.selServerName(objDICOMSettings_data.ipAddress)
				.clickOnSaveChanges();
		objControlPanel.verAvailableStatus(objDICOMSettings_data.ipAddress);
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics.clickOnRadiology()
				.clickOnStudiesReceivedInRemoteClinicsByModalityAndDate()
				.selectClinicCheckBox(objDICOMSettings_data.ipAddress)
				.selectClinicCheckBox(objDICOMSettings_data.strLocalClinic)
				.clickOnNext()
				.selAModalityCheckBox(objViewPatients_data.strModalityMR)
				.selAModalityCheckBox(objViewPatients_data.strModalityNM)
				.clickOnNext().clickOnToday().clickOnNext1();
		int i = objStatistics.getInitialCount(objDICOMSettings_data.ipAddress);
		int i1 = objStatistics
				.getInitialCount(objDICOMSettings_data.strLocalClinic);

		objPatientScheduleRegistration.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.verHomePage().clickOnAdminSite();
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
				.selRouteEngineType(objDICOMSettings_data.routeEngineStandard);
		objDestinations.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityMR);
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
		objViewPatients.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy1,
				objViewPatients_data.strStudy1, strImagePath,
				objViewPatients_data.strModalityNM);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();
		Thread.sleep(3000);
		objHome.clickOnStatistics();
		objStatistics.clickOnRadiology()
				.clickOnStudiesReceivedInRemoteClinicsByModalityAndDate()
				.selectClinicCheckBox(objDICOMSettings_data.ipAddress)
				.selectClinicCheckBox(objDICOMSettings_data.strLocalClinic)
				.clickOnNext()
				.selAModalityCheckBox(objViewPatients_data.strModalityMR)
				.selAModalityCheckBox(objViewPatients_data.strModalityNM)
				.clickOnNext().clickOnToday().clickOnNext1();
		objStatistics.verStudyReceivedByDifferentStatistics(
				objDICOMSettings_data.ipAddress, i)
				.verStudyReceivedByDifferentStatistics(
						objDICOMSettings_data.strLocalClinic, i1);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

}
