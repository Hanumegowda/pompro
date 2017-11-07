package rhel4DiacapServer.requirementGroup.smokeSuit.DICOMSettings;

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
import page.DICOMSetting;
import page.Destinations;
import page.Home;
import page.Login;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayAetitleRouting extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayAetitleRouting() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the study is routed to the destination AE if the study matches
                     all the three rules.     
    'Precondition  :
    'Date          : 15-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the study is routed to the destination AE if the study matches"
			+ " all the three rules.")
	public void testHappyDay68385() throws Exception {

		gstrTCID = "68385";
		gstrTO = "Verify that the study is routed to the destination AE if the study matches all the"
				+ " three rules.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
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
				.selectAttributeInRule2DropDown(
						objDICOMSettings_data.strManufacturer)
				.selectAttributeInRule3DropDown(
						objDICOMSettings_data.strModality)
				.selRouteStudiesChechbox();
		objAETitleRouting
				.enterTextInMatchKeyOfRule1(objDICOMSettings_data.strmatchkey1)
				.enterTextInMatchKeyOfRule2(objDICOMSettings_data.strmatchkey2)
				.enterTextInMatchKeyOfRule3(objDICOMSettings_data.strmatchkey3);
		objDestinations.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityCT);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnSearchTillStudySent();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that the studies are routed to the destination AE when an appropriate
                     Match Filter is specified for the Attribute 'Patient name'.     
    'Precondition  :
    'Date          : 16-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the studies are routed to the destination AE when an appropriate"
			+ " Match Filter is specified for the Attribute 'Patient name' .")
	public void testHappyDay68393() throws Exception {

		gstrTCID = "68393";
		gstrTO = "Verify that the studies are routed to the destination AE when an appropriate Match"
				+ " Filter is specified for the Attribute 'Patient name'.";

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
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
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
		objDICOMSetting.clickOnDestinations();
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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that only the signed reports of the study are routed when the 'Only
                     signed reports' option is enabled under Route Reports section.     
    'Precondition  :
    'Date          : 18-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that only the signed reports of the study are routed when the"
			+ " 'Only signed reports' option is enabled under Route Reports section.")
	public void testHappyDay68387() throws Exception {

		gstrTCID = "68387";
		gstrTO = "Verify that only the signed reports of the study are routed when the "
				+ "'Only signed reports' option is enabled under Route Reports section.";

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
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
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
		objDICOMSetting.clickOnDestinations();
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
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);
		String mainWindow = driver.getWindowHandle();
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!(childwindow1.contains(mainWindow))) {
				driver.switchTo().window(childwindow1);
				objViewPatients.clickOnAddButton();
				Set<String> allwindows2 = driver.getWindowHandles();
				Iterator<String> itr2 = allwindows2.iterator();
				while (itr2.hasNext()) {
					String childwindow2 = itr2.next().toString();
					if (!(childwindow2.contains(mainWindow))
							&& (!(childwindow2.contains(childwindow1)))) {
						driver.switchTo().window(childwindow2);
						objViewPatients.clickOnSaveReport();
						Thread.sleep(3000);

					}
				}
				driver.switchTo().window(childwindow1);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.verBlankReportIconOfAStudy(objViewPatients_data.strStudy);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnAETitleRouting();
		objAETitleRouting
				.clickOnEditRoutingDestination(
						objDICOMSettings_data.strmatchkey1)
				.disableRouteStudiesChechbox()
				.selOnlySignedReportsRadioButton();
		objDestinations.clickOnSaveChanges();

		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients
				.selInLastOption(objDICOMSettings_data.hour)
				.clickOnSearch()
				.clickOnViewModifyWebReportsOfAStudy(
						objViewPatients_data.strStudy);
		String str = "";
		String mainWindow1 = driver.getWindowHandle();
		Set<String> allwindows11 = driver.getWindowHandles();
		Iterator<String> itr11 = allwindows11.iterator();
		while (itr11.hasNext()) {
			String childwindow11 = itr11.next().toString();
			if (!(childwindow11.contains(mainWindow1))) {
				driver.switchTo().window(childwindow11);
				objViewPatients.clickOnAddButton();
				Set<String> allwindows21 = driver.getWindowHandles();
				Iterator<String> itr21 = allwindows21.iterator();
				while (itr21.hasNext()) {
					String childwindow2 = itr21.next().toString();
					if (!(childwindow2.contains(mainWindow1))
							&& (!(childwindow2.contains(childwindow11)))) {
						driver.switchTo().window(childwindow2);
						objViewPatients.clickOnSaveReport();
						Thread.sleep(3000);

					}
				}
				driver.switchTo().window(childwindow11);
				str = objViewPatients.getDateTimeOfUnSignedReport();
				objViewPatients.clickOnAddButton();
				Set<String> allwindows3 = driver.getWindowHandles();
				Iterator<String> itr3 = allwindows3.iterator();
				while (itr3.hasNext()) {
					String childwindow3 = itr3.next().toString();
					if (!(childwindow3.contains(mainWindow1))
							&& (!(childwindow3.contains(childwindow11)))) {
						driver.switchTo().window(childwindow3);
						objViewPatients.clickOnSaveSignReport()
								.clickOnSignReport();
						Thread.sleep(3000);

					}
				}
				driver.switchTo().window(childwindow11);
				Thread.sleep(3000);
				driver.navigate().refresh();
				// TimeUnit.MINUTES.sleep(2);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow1);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.clickOnSearch().clickOnSearch().clickOnSearch();

		objHome.launchApplication(objLogin_data.strAppURL1);
		// objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		Thread.sleep(3000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients
				.selInLastOption(objDICOMSettings_data.hour)
				.clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.clickOnViewModifyWebReportsOfAStudy(
						objViewPatients_data.strStudy);
		Set<String> allwindows21 = driver.getWindowHandles();
		Iterator<String> itr21 = allwindows21.iterator();
		while (itr21.hasNext()) {
			String childwindow2 = itr21.next().toString();
			if (!(childwindow2.contains(mainWindow1))) {
				driver.switchTo().window(childwindow2);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.verSignedReport().verSavedReportNotDisplayed1(
						str);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow1);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that all the reports of the study are routed when the 'All reports'
                     option is enabled under Route Reports section.     
    'Precondition  :
    'Date          : 21-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that all the reports of the study are routed when the 'All reports'"
			+ " option is enabled under Route Reports section.")
	public void testHappyDay68389() throws Exception {

		gstrTCID = "68389";
		gstrTO = "Verify that all the reports of the study are routed when the 'All reports' "
				+ "option is enabled under Route Reports section.";

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
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
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
		objDICOMSetting.clickOnDestinations();
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
		objViewPatients.clickOnSearch1().clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.verBlankReportIconOfAStudy(objViewPatients_data.strStudy);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnAETitleRouting();
		objAETitleRouting
				.clickOnEditRoutingDestination(
						objDICOMSettings_data.strmatchkey1)
				.disableRouteStudiesChechbox().selAllReportsRadioButton();
		objDestinations.clickOnSaveChanges();

		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients
				.selInLastOption(objDICOMSettings_data.hour)
				.clickOnSearch()
				.clickOnViewModifyWebReportsOfAStudy(
						objViewPatients_data.strStudy);
		String str1 = "";
		String mainWindow = driver.getWindowHandle();
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!(childwindow1.contains(mainWindow))) {
				driver.switchTo().window(childwindow1);
				objViewPatients.clickOnAddButton();
				Set<String> allwindows2 = driver.getWindowHandles();
				Iterator<String> itr2 = allwindows2.iterator();
				while (itr2.hasNext()) {
					String childwindow2 = itr2.next().toString();
					if (!(childwindow2.contains(mainWindow))
							&& (!(childwindow2.contains(childwindow1)))) {
						driver.switchTo().window(childwindow2);
						objViewPatients.clickOnSaveReport();
						Thread.sleep(3000);

					}
				}
				driver.switchTo().window(childwindow1);
				str1 = objViewPatients.getDateTimeOfUnSignedReport();
				objViewPatients.clickOnAddButton();
				Set<String> allwindows3 = driver.getWindowHandles();
				Iterator<String> itr3 = allwindows3.iterator();
				while (itr3.hasNext()) {
					String childwindow3 = itr3.next().toString();
					if (!(childwindow3.contains(mainWindow))
							&& (!(childwindow3.contains(childwindow1)))) {
						driver.switchTo().window(childwindow3);
						objViewPatients.clickOnSaveSignReport()
								.clickOnSignReport();
						Thread.sleep(3000);

					}
				}
				driver.switchTo().window(childwindow1);
				Thread.sleep(3000);
				driver.navigate().refresh();
				// TimeUnit.MINUTES.sleep(1);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.clickOnSearch();

		objHome.launchApplication(objLogin_data.strAppURL1);
		// objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		Thread.sleep(3000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients
				.selInLastOption(objDICOMSettings_data.hour)
				.clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.clickOnViewModifyWebReportsOfAStudyContainsSignedReport(
						objViewPatients_data.strStudy);
		String mw = driver.getWindowHandle();
		Set<String> allwindows2 = driver.getWindowHandles();
		Iterator<String> itr2 = allwindows2.iterator();
		while (itr2.hasNext()) {
			String childwindow2 = itr2.next().toString();
			if (!(childwindow2.contains(mainWindow))) {
				driver.switchTo().window(childwindow2);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.verSignedReport();
				objViewPatients.verSavedReportIsDisplayed1(str1);
			}
		}
		driver.close();
		driver.switchTo().window(mw);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnAETitleRouting();
		boolean actual1 = objAETitleRouting.delAllExistingRoute();
		while (actual1 == true) {
			objNavigationToSubMenus.clickOnDICOMSettings();
			objDICOMSetting.clickOnAETitleRouting();
			actual1 = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual1 + " aa");

		}
		objHome.clickOnLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that the reports are not routed with the study when the 'No' option
                     is selected under 'Route Reports'.     
    'Precondition  :
    'Date          : 07-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the reports are not routed with the study when the 'No' "
			+ "option is selected under 'Route Reports'.")
	public void testHappyDay68386() throws Exception {

		gstrTCID = "68386";
		gstrTO = "Verify that the reports are not routed with the study when the 'No' option is"
				+ " selected under 'Route Reports'.";

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
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
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
		objDICOMSetting.clickOnDestinations();
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
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);
		String mainWindow = driver.getWindowHandle();
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!(childwindow1.contains(mainWindow))) {
				driver.switchTo().window(childwindow1);
				objViewPatients.clickOnAddButton();
				Set<String> allwindows2 = driver.getWindowHandles();
				Iterator<String> itr2 = allwindows2.iterator();
				while (itr2.hasNext()) {
					String childwindow2 = itr2.next().toString();
					if (!(childwindow2.contains(mainWindow))
							&& (!(childwindow2.contains(childwindow1)))) {
						driver.switchTo().window(childwindow2);
						objViewPatients.clickOnSaveReport();
						Thread.sleep(3000);

					}
				}
				driver.switchTo().window(childwindow1);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnLogout();

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.verBlankReportIconOfAStudy(objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the studies are routed to the destination AE when an appropriate 
                     Match Filter is specified for the Attribute Accession Number.     
    'Precondition  :
    'Date          : 08-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the studies are routed to the destination AE when an appropriate "
			+ "Match Filter is specified for the Attribute Accession Number.")
	public void testHappyDay68392() throws Exception {

		gstrTCID = "68392";
		gstrTO = "Verify that the studies are routed to the destination AE when an appropriate Match "
				+ "Filter is specified for the Attribute Accession Number.";

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
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);

		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileAutoITDownloadPath = pathProps
				.getProperty(objPathData.autoItFileWithAccessionNum);
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
		objAETitleRouting.selectAEDestinationInDropDown(
				objDICOMSettings_data.aeTitleDestination)
				.selectAttributeInRule1DropDown(
						objDICOMSettings_data.strAccessionNumber);
		objAETitleRouting
				.enterTextInMatchKeyOfRule1(objDICOMSettings_data.strmatchkey4);
		objDestinations.clickOnSaveChanges();
		System.out.println(objDICOMSettings_data.strmatchkey4
				+ " this is d accnum");

		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		String str[] = { strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS, "tried",
				objDICOMSettings_data.strmatchkey4 };

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.executeAutoItFile(str);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();
		objViewPatients.clickOnSearchTillStudySent().clickOnSearch()
				.clickOnSearch().clickOnLogout();

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that Study is auto-routed to different Servers when released from 
                     QC Sandbox one having * in routing rule and another having "Modality: CT" as routing rule.     
    'Precondition  :
    'Date          : 25-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Study is auto-routed to different Servers when released from QC Sandbox "
			+ "one having * in routing rule and another having Modality: CT as routing rule.")
	public void testHappyDay144793() throws Exception {

		gstrTCID = "144793";
		gstrTO = "Verify that Study is auto-routed to different Servers when released from QC Sandbox "
				+ "one having * in routing rule and another having Modality: CT as routing rule.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
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

		// rh6(92) server
		objDICOMSetting.clickOnDestinations();
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
				.selectPlaceStudiesSandboxCheckBox()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();

		// rhel4(91) server
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
		objDestinations
				.enterTextInAETitleField(objDICOMSettings_data.aETitleFor91)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddressfor91)
				.enterTextInLabelField(objDICOMSettings_data.labelfor91)
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();

		// rhel6(94) server
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
		objDestinations
				.enterTextInAETitleField(objDICOMSettings_data.aETitleFor94)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddressfor94)
				.enterTextInLabelField(objDICOMSettings_data.labelfor94)
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

		// aetitle of 91
		objDestinations.clickOnAdd();
		objAETitleRouting
				.selectAEDestinationInDropDown(
						objDICOMSettings_data.aeTitleDestinationFor91)
				.selectAttributeInRule1DropDown(
						objDICOMSettings_data.strModality)
				.selRouteStudiesChechbox();
		objAETitleRouting
				.enterTextInMatchKeyOfRule1(objDICOMSettings_data.strmatchkey5);
		objDestinations.clickOnSaveChanges();

		// aetitle of 94
		objDestinations.clickOnAdd();
		objAETitleRouting
				.selectAEDestinationInDropDown(
						objDICOMSettings_data.aeTitleDestinationFor94)
				.selectAttributeInRule1DropDown(
						objDICOMSettings_data.strModality)
				.selRouteStudiesChechbox();
		objAETitleRouting
				.enterTextInMatchKeyOfRule1(objDICOMSettings_data.strmatchkey3);
		objDestinations.clickOnSaveChanges();
		objHome.clickOnLogOut();

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objNavigationToSubMenus.clickOnDICOMSettings();

		// rh4(93) server
		objDICOMSetting.clickOnDestinations();
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
		objDestinations.enterTextInAETitleField(objDICOMSettings_data.aETitle2)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddress1)
				.enterTextInLabelField(objDICOMSettings_data.label1)
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();
		objDICOMSetting.clickOnAETitleRouting1();
		boolean actual1 = objAETitleRouting.delAllExistingRoute();
		while (actual1 == true) {
			objNavigationToSubMenus.clickOnDICOMSettings();
			objDICOMSetting.clickOnAETitleRouting();
			actual1 = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual1 + " aa");

		}
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityCT);
		Thread.sleep(3000);
		String mainWindow = driver.getWindowHandle();
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
		objViewPatients.clickOnSearchTillStudySent().clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnReleaseStudyFromQc();
		Thread.sleep(5000);
		String mw = driver.getWindowHandle();
		Set<String> aw1 = driver.getWindowHandles();
		Iterator<String> itr2 = aw1.iterator();
		while (itr2.hasNext()) {
			String cw = itr2.next().toString();
			if (!(cw.contains(mw))) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();
				objViewPatients.clickOnOkInReleaseStudyFromQcWindow()
						.clickOnCloseInMergeReportsPage();
			}
		}
		driver.switchTo().window(mw);
		objViewPatients.clickOnSearchTillStudySent().clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURLfor91);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objHome.clickOnIConsent().clickOnViewPatients11();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.clickOnLogout1();
		objHome.launchApplication(objLogin_data.strAppURLfor94);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnIConsent().clickOnViewPatients11();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.clickOnLogout1();

		gstrResult = "PASS";
	}

}
