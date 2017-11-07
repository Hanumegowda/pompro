package rh4CommercialServer.requirementGroup.smokeSuit.MedwebRadiologyStatistics;

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
import page.AdministratorSite;
import page.AutoIT;
import page.DICOMRemapping;
import page.DICOMSetting;
import page.Destinations;
import page.Home;
import page.Login;
import page.Statistics;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappDayStudiesReceivedByReferringDoctorModalityAndDate extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappDayStudiesReceivedByReferringDoctorModalityAndDate() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the statistics of Studies Received by all the Referring Doctors 
                     and for all the modalities are generated for a selected custom time period.     
    'Precondition  :
    'Date          : 05-May-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the statistics of Studies Received by all the Referring Doctors and"
			+ " for all the modalities are generated for a selected custom time period.")
	public void testHappyDay69324() throws Exception {

		gstrTCID = "69324";
		gstrTO = "Verify that the statistics of Studies Received by all the Referring Doctors and for all the "
				+ "modalities are generated for a selected custom time period.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		DICOMRemapping objDICOMRemapping = new DICOMRemapping(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileAutoITDownloadPath = pathProps
				.getProperty(objPathData.autoItFilePath5);
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

		objHome.launchApplication(objLogin_data.strAppURL).clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics.clickOnRadiology()
				.clickOnStudiesReceivedByReferringDoctorModalityAndDate()
				.verSelectReferringDoctorsPage()
				.selDoctor(objViewPatients_data.strRefPhyConstant)
				.selDoctor(objViewPatients_data.strRefPhyConstant1)
				.clickOnNext()
				.selAModalityCheckBox(objViewPatients_data.strModalityDS)
				.clickOnNext().clickOnNext1();
		int i = objStatistics
				.getInitialCount(objViewPatients_data.strRefPhyConstant);
		int i1 = objStatistics
				.getInitialCount(objViewPatients_data.strRefPhyConstant1);
		objHome.clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnDicomRemapping();
		boolean actual1 = objDICOMRemapping.delAllRemappings();
		while (actual1 == true) {
			objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
			objDICOMSetting.clickOnDicomRemapping();
			actual1 = objDICOMRemapping.delAllRemappings();
			System.out.println(actual1 + " aa");

		}
		objHome.clickOnLogOut();
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
		Thread.sleep(3000);
		String mainWindow = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr = aw.iterator();
		while (itr.hasNext()) {
			String cw = itr.next().toString();
			if (!(cw.contains(mainWindow))) {
				driver.switchTo().window(cw);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
			}
		}
		objAutoIT.CreateStudy1(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS,
				objViewPatients_data.strRefPhyConstant);
		System.out.println(objViewPatients_data.strStudy);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1()
				.clickOnSendThisStudyToDICOMStorageDevice(
						objViewPatients_data.strStudy);
		Set<String> str = driver.getWindowHandles();
		Iterator<String> itr11 = str.iterator();
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
				.clickOnSearch().clickOnSearch();
		objViewPatients.clickOnLogout();

		objHome.launchApplication(objLogin_data.strAppURL);

		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy1(strAutoitPath, objViewPatients_data.strStudy1,
				objViewPatients_data.strStudy1, strImagePath,
				objViewPatients_data.strModalityDS,
				objViewPatients_data.strRefPhyConstant1);
		Thread.sleep(3000);
		System.out.println(objViewPatients_data.strStudy1);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy1);
		objViewPatients.clickOnSearch1();
		objHome.clickOnStatistics();
		objStatistics
				.clickOnRadiology()
				.clickOnStudiesReceivedByReferringDoctorModalityAndDate()
				.verSelectReferringDoctorsPage()
				.selDoctor(objViewPatients_data.strRefPhyConstant)
				.selDoctor(objViewPatients_data.strRefPhyConstant1)
				.clickOnNext()
				.selAModalityCheckBox(objViewPatients_data.strModalityDS)
				.clickOnNext()
				.clickOnNext1()
				.verStudyReceivedByDifferentStatistics(
						objViewPatients_data.strRefPhyConstant, i)
				.verStudyReceivedByDifferentStatistics(
						objViewPatients_data.strRefPhyConstant1, i1);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

}
