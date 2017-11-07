package rh4CommercialServer.requirementGroup.smokeSuit.MedwebRadiologyStatistics;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.MedwebRadiologyStatistics_data;
import dataObject.PathData;
import dataObject.ViewPatients_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.AutoIT;
import page.ControlPanel;
import page.DICOMSetting;
import page.Destinations;
import page.Home;
import page.Login;
import page.Statistics;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayTurnaroundTimeReportExternalReads extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayTurnaroundTimeReportExternalReads() throws Exception{
		super();	
	}
	
	/*************************************************************************************
    'Description   : Verify that statistics of time period from when the studies are sent to the
                     another server and signed report arrived for this study to the local Server for
                     the current year is displayed when 'This Year' is selected from the 'Time Period' dropdown.     
    'Precondition  :
    'Date          : 18-May-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that statistics of time period from when the studies are sent to the another"
			+ " server and signed report arrived for this study to the local Server for the current year is "
			+ "displayed when 'This Year' is selected from the 'Time Period' dropdown.")
	public void testHappyDay69336() throws Exception {

		gstrTCID = "69336";
		gstrTO = "Verify that statistics of time period from when the studies are sent to the another server and"
				+ " signed report arrived for this study to the local Server for the current year is displayed when"
				+ " 'This Year' is selected from the 'Time Period' dropdown.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		MedwebRadiologyStatistics_data objMedwebRadiologyStatistics_data = new MedwebRadiologyStatistics_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		Login objLogin = new Login(this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		Date_Time_settings dts = new Date_Time_settings();

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
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime();
		String strd = objControlPanel.getCurrentDate();
		String strm = objControlPanel.getCurrentMonth();
		String stry = objControlPanel.getCurrentYear();
		String strt = objControlPanel.getCurrentHourIn24HrFrmt();
		String str3 = strd + strm + stry;
		System.out.println(str3);
		String str4 = dts.converDateFormat(str3, "ddMMMyyyy", /*"yyyy/MM/dd"*/"MM-dd-yyyy");
		String req = str4 + " " + strt + ":";
		System.out.println(req);
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		System.out.println(objViewPatients_data.strStudy);

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
				Thread.sleep(2000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objViewPatients.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
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
		objViewPatients
				.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch()
				.clickOnSearch()
				.clickOnViewModifyWebReportsOfAStudy(
						objViewPatients_data.strStudy);
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itrr = aw.iterator();
		while (itrr.hasNext()) {
			String cw = itrr.next().toString();
			if (!(cw.contains(mw))) {
				driver.switchTo().window(cw);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.clickOnAddButton();
				Set<String> aw1 = driver.getWindowHandles();
				Iterator<String> itr1 = aw1.iterator();
				while (itr1.hasNext()) {
					String cw1 = itr1.next().toString();
					if ((!(cw1.contains(mw))) && (!(cw1.contains(cw)))) {
						driver.switchTo().window(cw1);
						objViewPatients.clickOnSaveSignReport()
								.clickOnSignReport();
					}
				}
				driver.switchTo().window(cw);
				objViewPatients.clickOnSendThisReportTo();
				Thread.sleep(3000);
				Set<String> aw2 = driver.getWindowHandles();
				System.out.println(aw2.size() + " no of windows");
				Iterator<String> itr2 = aw2.iterator();
				while (itr2.hasNext()) {
					String cw2 = itr2.next().toString();
					if ((!(cw2.contains(cw))) && (!(cw2.contains(mw)))) {
						driver.switchTo().window(cw2);
						objViewPatients
								.selDestination(
										objDICOMSettings_data.storageDevice)
								.clickOnFinishButton().clickOnFinishButton();
					}
				}
				driver.switchTo().window(cw);
				driver.close();
			}
		}
		driver.switchTo().window(mw);
		objViewPatients.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics.clickOnRadiology()
				.clickOnTurnaroundTimeReportExternalReads()
				.selTimePeriod(objMedwebRadiologyStatistics_data.strThisYear)
				.enterTextInFindField(objViewPatients_data.strStudy)
				.clickOnSearch().verReportReceiveTime(req).verResponseTime();

		gstrResult = "PASS";

	}
}
