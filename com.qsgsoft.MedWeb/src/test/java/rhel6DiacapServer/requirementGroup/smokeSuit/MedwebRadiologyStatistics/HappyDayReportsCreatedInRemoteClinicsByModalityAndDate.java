package rhel6DiacapServer.requirementGroup.smokeSuit.MedwebRadiologyStatistics;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.User_data;
import dataObject.ViewPatients_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.ControlPanel;
import page.DICOMSetting;
import page.Destinations;
import page.Home;
import page.Login;
import page.MedwebSecureTunnel;
import page.Statistics;
import page.UserManagement;
import page.ViewPatients;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayReportsCreatedInRemoteClinicsByModalityAndDate extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayReportsCreatedInRemoteClinicsByModalityAndDate() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that statistics of reports created in Remote Clinic are generated 
                     for a selected custom time period.     
    'Precondition  :
    'Date          : 13-May-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that statistics of reports created in Remote Clinic are generated for "
			+ "a selected custom time period.")
	public void testHappyDay69327() throws Exception {

		gstrTCID = "69327";
		gstrTO = "Verify that statistics of reports created in Remote Clinic are generated for a selected"
				+ " custom time period.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		MedwebSecureTunnel objMedwebSecureTunnel = new MedwebSecureTunnel(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		// autoIT CreateStudy File Path
		String autoItCreateStudy = pathProps
				.getProperty(objPathData.autoItFilePath2);
		System.out.println(autoItCreateStudy);

		File autoitfile = new File(System.getProperty("user.dir")
				+ autoItCreateStudy);
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
		objAdministratorSite.verAdministratorSitePage();
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
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnMedwebStatisticsParametersLink()
				.clickOnStatisticsServersTab()
				.delExistingStatisticServer(objDICOMSettings_data.ipAddress);
		objControlPanel.clickOnAddNewServer().selServerName(
				objDICOMSettings_data.ipAddress);
		Thread.sleep(3000);
		objControlPanel.clickOnSaveChanges();
		objControlPanel.verAvailableStatus(objDICOMSettings_data.ipAddress);
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics.clickOnReportsCreatedInRemoteClinicsByModalityAndDate()
				.selectClinicCheckBox(objDICOMSettings_data.ipAddress)
				.clickOnNext()
				.selAModalityCheckBox(objViewPatients_data.strModalityDS)
				.clickOnNext().clickOnNext1();
		int actual = objStatistics
				.getStatisticsCountOfParticularModality(objDICOMSettings_data.ipAddress);
		System.out.println(actual + "actual value");
		objViewPatients.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL1);
		// objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		String mainwindowhandle = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr = aw.iterator();
		while (itr.hasNext()) {
			String cw = itr.next().toString();
			if (!(cw.contains(mainwindowhandle))) {
				driver.switchTo().window(cw);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
			}
		}
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		// driver.switchTo().window(mainwindowhandle);
		Thread.sleep(2000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);

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
				Set<String> allwindows = driver.getWindowHandles();
				Iterator<String> ite1 = allwindows.iterator();
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
				System.out.println(objUser_data.strNewUserName);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindowhandle);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objStatistics.clickOnRadiology()
				.clickOnReportsCreatedInRemoteClinicsByModalityAndDate()
				.selectClinicCheckBox(objDICOMSettings_data.ipAddress)
				.clickOnNext()
				.selAModalityCheckBox(objViewPatients_data.strModalityDS)
				.clickOnNext().clickOnNext1();
		int actual1 = objStatistics
				.getStatisticsCountOfParticularModality(objDICOMSettings_data.ipAddress);
		System.out.println(actual1 + "actual1 value");
		objStatistics.verStudyReceivedByDifferentStatistics(
				objDICOMSettings_data.ipAddress, actual);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

}
