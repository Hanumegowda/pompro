package rh4CommercialServer.requirementGroup.smokeSuit.ViewPatients;

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
import page.ControlPanel;
import page.DICOMSetting;
import page.Destinations;
import page.Home;
import page.Login;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayTransportStatusInfoInTheNetColumn extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayTransportStatusInfoInTheNetColumn() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify the Pop-up window "Study routing history" displays the history of study
                     sent with columns "Event", "User", "Dest.AE", "Status", "Started" & "Updated" when
                     user clicks on "green" square box.     
    'Precondition  :
    'Date          : 13-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify the Pop-up window Study routing history displays the history of"
			+ " study sent with columns Event, User, Dest.AE, Status, Started & Updated when user"
			+ "clicks on green square box.")
	public void testHappyDay73694() throws Exception {

		gstrTCID = "73694";
		gstrTO = "Verify the Pop-up window Study routing history displays the history of"
				+ " study sent with columns Event, User, Dest.AE, Status, Started & Updated when user"
				+ "clicks on green square box.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Date_Time_settings dts = new Date_Time_settings();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
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
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime();
		String str = objControlPanel.getCurrentDate();
		String str1 = objControlPanel.getCurrentMonth();
		String str2 = objControlPanel.getCurrentYear();
		String str3 = str + str1 + str2;
		System.out.println(str3);
		String str4 = dts.converDateFormat(str3, "ddMMMyyyy", "yyyy-MM-dd");
		System.out.println(str4);
		String str5 = objControlPanel.getCurrentHour();
		if (Integer.parseInt(str5) < 10) {
			str5 = "0" + str5;
			System.out.println(str5 + "  yes it is single digt");
		}
		String str6 = objControlPanel.getCurrentMinute();
		int i1 = (Integer.parseInt(str6)) + 1;
		String str9 = Integer.toString(i1);
		String str10 = dts.get24hrDateFormate(str5 + ":" + str9);
		String str7 = dts.get24hrDateFormate(str5 + ":" + str6);
		String str8 = str4 + " " + str7;
		String str11 = str4 + " " + str10;
		System.out.println(str8);
		System.out.println(str11);
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
		Thread.sleep(3000);
		System.out.println(objViewPatients_data.strStudy);
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
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice1)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.selLayout(objViewPatients_data.strLayout1)
				.enterTextInFind(objViewPatients_data.strStudy).clickOnSearch()
				.clickOnSearch();
		Thread.sleep(3000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnGreenSquareBoxOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!childwindow1.contains(mainwindow)) {
				driver.switchTo().window(childwindow1);
				objViewPatients.verStudyRoutingHistoryPageIsDisplayed();
				String[] req = { "send", "admin",
						objDICOMSettings_data.aETitle1, "SUCCESS,COMPLETE",
						str4, str4 };
				objViewPatients
						.verStudyRoutingHistory(
								objViewPatients_data.strStudyRoutingHistory,
								req, str11);
			}

		}
		driver.close();
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify the Pop-up window "Study routing history" displays the history of study 
                     sent with columns "Event", "User", "Dest.AE", "Status", "Started" & "Updated" 
                     when user clicks on "red" quare box.     
    'Precondition  :
    'Date          : 26-Aug-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify the Pop-up window Study routing history displays the history of "
			+ "study sent with columns Event, User, Dest.AE, Status, Started & Updated when user "
			+ "clicks on red quare box.")
	public void testHappyDay73692() throws Exception {

		gstrTCID = "73692";
		gstrTO = "Verify the Pop-up window Study routing history displays the history of study"
				+ " sent with columns Event, User, Dest.AE, Status, Started & Updated when user clicks on red quare box.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Date_Time_settings dts = new Date_Time_settings();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
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
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime();
		String str = objControlPanel.getCurrentDate();
		String str1 = objControlPanel.getCurrentMonth();
		String str2 = objControlPanel.getCurrentYear();
		String str3 = str + str1 + str2;
		System.out.println(str3);
		String str4 = dts.converDateFormat(str3, "ddMMMyyyy", "yyyy-MM-dd");
		System.out.println(str4);
		String str5 = objControlPanel.getCurrentHour();
		if (Integer.parseInt(str5) < 10) {
			str5 = "0" + str5;
			System.out.println(str5 + "  yes it is single digt");
		}
		String str6 = objControlPanel.getCurrentMinute();
		int i1 = (Integer.parseInt(str6)) + 1;
		String str9 = Integer.toString(i1);
		String str10 = dts.get24hrDateFormate(str5 + ":" + str9);
		String str7 = dts.get24hrDateFormate(str5 + ":" + str6);
		String str8 = str4 + " " + str7;
		String str11 = str4 + " " + str10;
		System.out.println(str8);
		System.out.println(str11);
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
		objDestinations.enterTextInAETitleField(objDICOMSettings_data.aETitleFake)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.fakeIpAddress)
				.enterTextInLabelField(objDICOMSettings_data.label2)
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
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		System.out.println(objViewPatients_data.strStudy);
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
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(
								objDICOMSettings_data.fakeStorageDevice)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch();
		objViewPatients.selLayout(objViewPatients_data.strLayout1)
				.enterTextInFind(objViewPatients_data.strStudy).clickOnSearch1()
				.clickOnSearch().clickOnSearch();
		Thread.sleep(10000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnRedSquareBoxOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!childwindow1.contains(mainwindow)) {
				driver.switchTo().window(childwindow1);
				objViewPatients.verStudyRoutingHistoryPageIsDisplayed();
				String[] req = { "send", "admin",
						objDICOMSettings_data.aETitle1, "FAIL,IN PROGRESS",
						str4, str4 };
				objViewPatients
						.verStudyRoutingHistory(
								objViewPatients_data.strStudyRoutingHistory,
								req, str11);
			}

		}
		driver.close();
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that Network Stat is displayed as Green when study is auto-routed 
                     (Enhanced engine) to destination server successfully.     
    'Precondition  :
    'Date          : 30-Aug-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Network Stat is displayed as Green when study is auto-routed"
			+ " (Enhanced engine) to destination server successfully.")
	public void testHappyDay165601() throws Exception {

		gstrTCID = "165601";
		gstrTO = "Verify that Network Stat is displayed as Green when study is auto-routed (Enhanced engine)"
				+ " to destination server successfully.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);

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
			objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
			objDICOMSetting.clickOnAETitleRouting();
			actual = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual + " aa");

		}

		objDestinations.clickOnAdd();
		objAETitleRouting.selectAEDestinationInDropDown(
				objDICOMSettings_data.aeTitleDestination)
				.selectAttributeInRule1DropDown(
						objDICOMSettings_data.strPatientName);
		objAETitleRouting
				.enterTextInMatchKeyOfRule1(objDICOMSettings_data.strmatchkey1);
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
		objViewPatients.clickOnSearch1();

		objViewPatients.selLayout(objViewPatients_data.strLayout1)
				.clickOnSearch().clickOnSearch()
				.verGreenSqaureBoxIsDisplaying(objViewPatients_data.strStudy);
		objHome.clickOnAdminSite();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnAETitleRouting();
		boolean actual1 = objAETitleRouting.delAllExistingRoute();
		while (actual1 == true) {
			objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
			objDICOMSetting.clickOnAETitleRouting();
			actual1 = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual1 + " aa");

		}
		objHome.clickOnLogOut();
		
		gstrResult = "PASS";
	}

}
