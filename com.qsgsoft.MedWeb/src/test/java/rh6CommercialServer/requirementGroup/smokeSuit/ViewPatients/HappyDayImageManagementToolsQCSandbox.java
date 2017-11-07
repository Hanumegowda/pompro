package rh6CommercialServer.requirementGroup.smokeSuit.ViewPatients;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import dataObject.DICOMSettings_data;
import dataObject.Groups_data;
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
import page.DICOMSetting;
import page.Destinations;
import page.Groups;
import page.Home;
import page.Login;
import page.ModifyStudy;
import page.UserManagement;
import page.ViewPatients;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayImageManagementToolsQCSandbox extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayImageManagementToolsQCSandbox() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that studies from an Aetitle are placed in the QC Sandbox when the
                     option "Place studies from this aetitle into the Trauma sandbox" is enabled
                     in Destination Editor.    
    'Precondition  :
    'Date          : 22-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that studies from an Aetitle are placed in the QC Sandbox when the"
			+ " option 'Place studies from this aetitle into the Trauma sandbox' is enabled in Destination Editor.")
	public void testHappyDay59393() throws Exception {

		gstrTCID = "59393";
		gstrTO = "Verify that studies from an Aetitle are placed in the QC Sandbox when the option 'Place studies from "
				+ "this aetitle into the Trauma sandbox' is enabled in Destination Editor.";

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
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
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnNewStudy();
		String mainWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
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
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice1)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch();
		Thread.sleep(10000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		objViewPatients.selStatusOption(objViewPatients_data.strStatus);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch().clickOnSearch().clickOnSearch();
		objViewPatients.verStudyFromOtherServer(objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the selected image series is deleted from the study when the
                     'Delete Selected' button is clicked.     
    'Precondition  :
    'Date          : 17-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the selected image series is deleted from the study when"
			+ "the 'Delete Selected' button is clicked.")
	public void testHappyDay68532() throws Exception {

		gstrTCID = "68532";
		gstrTO = "Verify that the selected image series is deleted from the study when the "
				+ "'Delete Selected' button is clicked.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		Login objLogin = new Login(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnModifyStudyIconOfAStudy(
				objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selLayout(objViewPatients_data.strLayout)
				.clickOnSearch().clickOnSearch();
		String actual = objViewPatients
				.getCountOfImagesOfStudy(objViewPatients_data.strStudy);
		System.out.println(actual + " factual");
		int i = Integer.parseInt(actual);
		objViewPatients
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selOneOrMoreCompleteSeriesInThisStudyRadioButton()
						.clickOnProceedButton()
						.selImageInSplitMergeMoveWizard()
						.clickOnDeleteSelectedInSplitMergeMoveWizard()
						.clickOnYesInSplitMergeMoveWizard()
						.clickOnDoneInSplitMergeMoveWizard();
			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch();
		String actual1 = objViewPatients
				.getCountOfImagesOfStudy(objViewPatients_data.strStudy);
		System.out.println(actual1 + " actual");
		int i1 = Integer.parseInt(actual1);
		assertEquals(i1, (i - 4));
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the new study created is released from QC when "Release new study
                     from QC sandbox" option is selected in "Copy selected series where?" page.     
    'Precondition  :
    'Date          : 17-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the new study created is released from QC when Release new"
			+ " study from QC sandbox option is selected in Copy selected series where? page.")
	public void testHappyDay62003() throws Exception {

		gstrTCID = "62003";
		gstrTO = "Verify that the new study created is released from QC when Release new study from"
				+ " QC sandbox option is selected in Copy selected series where? page.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch()
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selLayout(objViewPatients_data.strLayout)
				.clickOnSearch().clickOnSearch();
		String actual = objViewPatients
				.getCountOfImagesOfStudy(objViewPatients_data.strStudy);
		int i = Integer.parseInt(actual);
		objViewPatients
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selOneOrMoreCompleteSeriesInThisStudyRadioButton()
						.clickOnProceedButton()
						.selImageInSplitMergeMoveWizard()
						.clickOnCopyInSplitMergeMoveWizard()
						.selReleaseNewStudyFromQCSandboxCheckBox()
						.clickOnNewStudyInSplitMergeMoveWizard()
						.clickOnOKInSplitMergeMoveWizard();

			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch()
				.selStatusOption(objViewPatients_data.strStatus)
				.clickOnSearch().clickOnSearch()
				.verCopyOfAStudyNotDisplayed(objViewPatients_data.strStudy)
				.selStatusOption(objViewPatients_data.ststusAny)
				.clickOnSearch().clickOnSearch()
				.verNonQCStudyIsDisplayed(objViewPatients_data.strStudy);
		String str2 = objViewPatients
				.getCountOfImagesOfSecondStudy(objViewPatients_data.strStudy);
		int i1 = Integer.parseInt(str2);
		assertEquals(i, i1);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that a New study is created with the same name and ID when image series 
                     is copied to a New Study and copied images are retained in original study.     
    'Precondition  :
    'Date          : 18-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a New study is created with the same name and ID when image series"
			+ " is copied to a New Study and copied images are retained in original study.")
	public void testHappyDay167444() throws Exception {

		gstrTCID = "167444";
		gstrTO = "Verify that a New study is created with the same name and ID when image series is copied"
				+ " to a New Study and copied images are retained in original study.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
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

		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();
		objViewPatients
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selLayout(objViewPatients_data.strLayout)
				.clickOnSearch().clickOnSearch();
		String actual = objViewPatients
				.getCountOfImagesOfStudy(objViewPatients_data.strStudy);
		System.out.println(actual + " 1st");
		int i = Integer.parseInt(actual);
		String strid = objViewPatients
				.getIdOfParticularStudy(objViewPatients_data.strStudy);
		objViewPatients
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selOneOrMoreCompleteSeriesInThisStudyRadioButton()
						.clickOnProceedButton()
						.selImageInSplitMergeMoveWizard()
						.clickOnCopyInSplitMergeMoveWizard()
						.clickOnNewStudyInSplitMergeMoveWizard()
						.clickOnOKInSplitMergeMoveWizard();

			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.verStudyAndCopyOfAStudyIsDisplayed(
						objViewPatients_data.strStudy, strid).clickOnSearch()
				.clickOnSearch();
		String str2 = objViewPatients
				.getCountOfImagesOfSecondStudy(objViewPatients_data.strStudy);
		System.out.println(str2 + " 2st");
		int i1 = Integer.parseInt(str2);
		assertEquals(i, i1);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the selected image is deleted from the study when the 'Delete 
                     Selected' button is clicked.     
    'Precondition  :
    'Date          : 18-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the selected image is deleted from the study when the 'Delete Selected' button is clicked.")
	public void testHappyDay68540() throws Exception {

		gstrTCID = "68540";
		gstrTO = "Verify that the selected image is deleted from the study when the 'Delete Selected' button is clicked.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		Login objLogin = new Login(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();
		objViewPatients
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selLayout(objViewPatients_data.strLayout)
				.clickOnSearch().clickOnSearch();
		String actual = objViewPatients
				.getCountOfImagesOfStudy(objViewPatients_data.strStudy);
		System.out.println(actual + " fc");
		int i = Integer.parseInt(actual);
		objViewPatients
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selIndividualImagesInThisStudyRadioButton()
						.clickOnProceedButton()
						.selImageInSplitMergeMoveWizardForIndividualImagesRadioButton()
						.clickOnDeleteSelectedInSplitMergeMoveWizard()
						.clickOnYesInSplitMergeMoveWizard()
						.clickOnDoneInSplitMergeMoveWizard();

			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		String str2 = objViewPatients
				.getCountOfImagesOfStudy(objViewPatients_data.strStudy);
		System.out.println(str2 + " sc");
		int i1 = Integer.parseInt(str2);
		assertEquals((i - 1), i1);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the resulting study is released from QC when "Release resulting 
                     study from QC sandbox" option is selected in "Delete selected series" page.     
    'Precondition  :
    'Date          : 19-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the resulting study is released from QC when Release resulting"
			+ " study from QC sandbox option is selected in Delete selected series page.")
	public void testHappyDay85350() throws Exception {

		gstrTCID = "85350";
		gstrTO = "Verify that the resulting study is released from QC when Release resulting study"
				+ " from QC sandbox option is selected in Delete selected series page.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnModifyStudyIconOfAStudy(
				objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
				.selLayout(objViewPatients_data.strLayout).clickOnSearch()
				.clickOnSearch();
		String actual = objViewPatients
				.getCountOfImagesOfStudy(objViewPatients_data.strStudy);
		int i = Integer.parseInt(actual);
		objViewPatients
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients
						.selOneOrMoreCompleteSeriesInThisStudyRadioButton()
						.clickOnProceedButton()
						.selImageInSplitMergeMoveWizard()
						.clickOnDeleteSelectedInSplitMergeMoveWizard()
						.selReleaseNewStudyFromQCSandboxCheckBox()
						.clickOnYesInSplitMergeMoveWizard()
						.clickOnDoneInSplitMergeMoveWizard();
			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy).clickOnSearch()
				.clickOnSearch().verNoStudiesAvailableErrorMessage();
		objViewPatients.selStatusOption(objViewPatients_data.ststusAny)
				.selLayout(objViewPatients_data.strLayout)
				.enterTextInFind(objViewPatients_data.strStudy).clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch();
		String actual1 = objViewPatients
				.getCountOfImagesOfStudy(objViewPatients_data.strStudy);
		int i1 = Integer.parseInt(actual1);
		assertEquals(i1, (i - 4));
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the new study created is released from QC when "Release new 
                     study from QC sandbox" option is selected in "Move Where?" page for one or 
                     more complete series.     
    'Precondition  :
    'Date          : 19-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the new study created is released from QC when Release new "
			+ "study from QC sandbox option is selected in Move Where? page for one or more complete series.")
	public void testHappyDay147077() throws Exception {

		gstrTCID = "147077";
		gstrTO = "Verify that the new study created is released from QC when Release new study from QC sandbox"
				+ " option is selected in Move Where? page for one or more complete series.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		Login objLogin = new Login(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnModifyStudyIconOfAStudy(
				objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selOneOrMoreCompleteSeriesInThisStudyRadioButton()
						.clickOnProceedButton()
						.selImageInSplitMergeMoveWizard()
						.clickOnMoveInSplitMergeMoveWizard()
						.selReleaseNewStudyFromQCSandboxCheckBox()
						.clickOnNewStudyInSplitMergeMoveWizard()
						.clickOnOKInSplitMergeMoveWizard();

			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch()
				.selStatusOption(objViewPatients_data.strStatus)
				.clickOnSearch().clickOnSearch()
				.verCopyOfAStudyNotDisplayed(objViewPatients_data.strStudy)
				.selStatusOption(objViewPatients_data.ststusAny)
				.clickOnSearch().clickOnSearch()
				.verNonQCStudyIsDisplayed1(objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the resulting study is released from QC when "Release resulting 
                     study from QC sandbox" option is selected in "Delete selected images" page.     
    'Precondition  :
    'Date          : 20-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the resulting study is released from QC when Release "
			+ "resulting study from QC sandbox option is selected in Delete selected images page.")
	public void testHappyDay62010() throws Exception {

		gstrTCID = "62010";
		gstrTO = "Verify that the resulting study is released from QC when Release resulting study"
				+ " from QC sandbox option is selected in Delete selected images page.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		Login objLogin = new Login(this.driver);

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
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnModifyStudyIconOfAStudy(
				objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
				.selLayout(objViewPatients_data.strLayout).clickOnSearch()
				.clickOnSearch();
		String actual = objViewPatients
				.getCountOfImagesOfStudy(objViewPatients_data.strStudy);
		int i = Integer.parseInt(actual);
		objViewPatients
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selIndividualImagesInThisStudyRadioButton()
						.clickOnProceedButton()
						.selImageInSplitMergeMoveWizardForIndividualImagesRadioButton()
						.clickOnDeleteSelectedInSplitMergeMoveWizard()
						.selReleaseNewStudyFromQCSandboxCheckBox()
						.clickOnYesInSplitMergeMoveWizard()
						.clickOnDoneInSplitMergeMoveWizard();
			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy).clickOnSearch()
				.clickOnSearch().verNoStudiesAvailableErrorMessage();
		objViewPatients.selStatusOption(objViewPatients_data.ststusAny)
				.enterTextInFind(objViewPatients_data.strStudy)
				.selLayout(objViewPatients_data.strLayout).clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch();
		String actual1 = objViewPatients
				.getCountOfImagesOfStudy(objViewPatients_data.strStudy);
		int i1 = Integer.parseInt(actual1);
		assertEquals(i1, (i - 1));
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the new study created is released from QC when "Release new study
                     from QC sandbox" option is selected in "Step 3: Move selected images where?" page.     
    'Precondition  :
    'Date          : 23-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the new study created is released from QC when Release new"
			+ " study from QC sandbox option is selected in Step 3: Move selected images where? page.")
	public void testHappyDay62012() throws Exception {

		gstrTCID = "62012";
		gstrTO = "Verify that the new study created is released from QC when Release new study from QC"
				+ " sandbox option is selected in Step 3: Move selected images where? page.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

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
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnModifyStudyIconOfAStudy(
				objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selIndividualImagesInThisStudyRadioButton()
						.clickOnProceedButton()
						.selImageInSplitMergeMoveWizardForIndividualImagesRadioButton()
						.clickOnMoveInSplitMergeMoveWizard()
						.selReleaseNewStudyFromQCSandboxCheckBox()
						.clickOnNewStudyInSplitMergeMoveWizard()
						.clickOnOKInSplitMergeMoveWizard();

			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch()
				.selStatusOption(objViewPatients_data.strStatus)
				.clickOnSearch().clickOnSearch()
				.verNoStudiesAvailableErrorMessage();
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the new study created is released from QC when "Release new 
                     study from QC sandbox" option is selected in "Copy selected images where?" page.     
    'Precondition  :
    'Date          : 23-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the new study created is released from QC when Release new study"
			+ " from QC sandbox option is selected in Copy selected images where? page.")
	public void testHappyDay62028() throws Exception {

		gstrTCID = "62028";
		gstrTO = "Verify that the new study created is released from QC when Release new study from QC"
				+ " sandbox option is selected in Copy selected images where? page.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnModifyStudyIconOfAStudy(
				objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selIndividualImagesInThisStudyRadioButton()
						.clickOnProceedButton()
						.selImageInSplitMergeMoveWizardForIndividualImagesRadioButton()
						.clickOnCopyInSplitMergeMoveWizard()
						.selReleaseNewStudyFromQCSandboxCheckBox()
						.clickOnNewStudyInSplitMergeMoveWizard()
						.clickOnOKInSplitMergeMoveWizard();

			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch()
				.selStatusOption(objViewPatients_data.strStatus)
				.clickOnSearch().clickOnSearch()
				.verCopyOfAStudyNotDisplayed(objViewPatients_data.strStudy)
				.selStatusOption(objViewPatients_data.ststusAny)
				.clickOnSearch().clickOnSearch()
				.verNonQCStudyIsDisplayed(objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the resulting study is released from QC when "Release resulting 
                     study from QC sandbox" option is selected in "Step 4: Enter search string and
                     select result" page for one or more complete series.     
    'Precondition  :
    'Date          : 24-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the resulting study is released from QC when Release resulting"
			+ " study from QC sandbox option is selected in Step 4: Enter search string and select result"
			+ " page for one or more complete series.")
	public void testHappyDay147078() throws Exception {

		gstrTCID = "147078";
		gstrTO = "Verify that the resulting study is released from QC when Release resulting study from"
				+ " QC sandbox option is selected in Step 4: Enter search string and select result page for"
				+ " one or more complete series.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnModifyStudyIconOfAStudy(
				objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		System.out.println(objViewPatients_data.strStudy1);
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy1,
				objViewPatients_data.strStudy1, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);

		objViewPatients.selStatusOption(objViewPatients_data.ststusAny)
				.enterTextInFind(objViewPatients_data.strStudy1);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		Thread.sleep(3000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch()
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy1);
		Set<String> allwindows2 = driver.getWindowHandles();
		Iterator<String> itr2 = allwindows2.iterator();
		while (itr2.hasNext()) {
			String childwindow = itr2.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
				.enterTextInFind(objViewPatients_data.strStudy1);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch();
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch()
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selOneOrMoreCompleteSeriesInThisStudyRadioButton()
						.clickOnProceedButton()
						.selImageInSplitMergeMoveWizard()
						.clickOnMoveInSplitMergeMoveWizard()
						.clickOnExistingStudyInSplitMergeMoveWizard()
						.selSearchForOptionInSplitMergeMoveWizard(
								objViewPatients_data.strSearchForOptionName)
						.enterSearchForOptionFieldInSplitMergeMoveWizard(
								objViewPatients_data.strStudy1)
						.clickOnGoInSplitMergeMoveWizard()
						.selStudyInSplitMergeMoveWizard()
						.selReleaseNewStudyFromQCSandboxCheckBox()
						.clickOnMoveInSplitMergeMoveWizard()
						.clickOnOKInSplitMergeMoveWizard();

			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch()
				.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy1)
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().verNoStudiesAvailableErrorMessage()
		/* .verStudyIsNotDisplayed(objViewPatients_data.strStudy1) */;
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the resulting study is released from QC when "Release resulting study
                     from QC sandbox" option is selected in "Step 4: Enter search string and select result"
                     page for one or more complete series is selected for copying.     
    'Precondition  :
    'Date          : 25-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the resulting study is released from QC when Release resulting"
			+ " study from QC sandbox option is selected in Step 4: Enter search string and select result"
			+ " page for one or more complete series is selected for copying.")
	public void testHappyDay62005() throws Exception {

		gstrTCID = "62005";
		gstrTO = "Verify that the resulting study is released from QC when Release resulting study from QC "
				+ "sandbox option is selected in Step 4: Enter search string and select result page for one or "
				+ "more complete series is selected for copying.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		Thread.sleep(3000);
		objViewPatients.clickOnSearch1().clickOnModifyStudyIconOfAStudy(
				objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		System.out.println(objViewPatients_data.strStudy1);
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy1,
				objViewPatients_data.strStudy1, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);

		objViewPatients.selStatusOption(objViewPatients_data.ststusAny)
				.enterTextInFind(objViewPatients_data.strStudy1);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		Thread.sleep(3000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch()
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy1);
		Set<String> allwindows2 = driver.getWindowHandles();
		Iterator<String> itr2 = allwindows2.iterator();
		while (itr2.hasNext()) {
			String childwindow = itr2.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
				.enterTextInFind(objViewPatients_data.strStudy1);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch();
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch()
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.selOneOrMoreCompleteSeriesInThisStudyRadioButton()
						.clickOnProceedButton()
						.selImageInSplitMergeMoveWizard()
						.clickOnCopyInSplitMergeMoveWizard()
						.verCopySelectedSeriesWherePageIsDisplayed()
						.clickOnExistingStudyInSplitMergeMoveWizard()
						.selSearchForOptionInSplitMergeMoveWizard(
								objViewPatients_data.strSearchForOptionName)
						.enterSearchForOptionFieldInSplitMergeMoveWizard(
								objViewPatients_data.strStudy1)
						.clickOnGoInSplitMergeMoveWizard()
						.selStudyInSplitMergeMoveWizard()
						.selReleaseNewStudyFromQCSandboxCheckBox()
						.clickOnCopyInSplitMergeMoveWizard()
						.clickOnOKInSplitMergeMoveWizard();

			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch()
				.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy1)
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().verNoStudiesAvailableErrorMessage();
		objViewPatients.clickOnLogout();
		/* .verStudyIsNotDisplayed(objViewPatients_data.strStudy1); */

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the resulting study is released from QC when "Release resulting study 
                     from QC sandbox" option is selected in "Step 4: Enter search string and select result"
                     page for induvidual images of the study.     
    'Precondition  :
    'Date          : 25-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the resulting study is released from QC when Release resulting"
			+ " study from QC sandbox option is selected in Step 4: Enter search string and select result"
			+ " page for induvidual images of the study.")
	public void testHappyDay62017() throws Exception {

		gstrTCID = "62017";
		gstrTO = "Verify that the resulting study is released from QC when Release resulting study from"
				+ " QC sandbox option is selected in Step 4: Enter search string and select result page for"
				+ " induvidual images of the study.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objcCommonFunctions = new CommonFunctions(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objcCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnModifyStudyIconOfAStudy(
				objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objcCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		System.out.println(objViewPatients_data.strStudy1);
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy1,
				objViewPatients_data.strStudy1, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);

		objViewPatients.selStatusOption(objViewPatients_data.ststusAny)
				.enterTextInFind(objViewPatients_data.strStudy1);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		Thread.sleep(3000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch1()
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy1);
		Set<String> allwindows2 = driver.getWindowHandles();
		Iterator<String> itr2 = allwindows2.iterator();
		while (itr2.hasNext()) {
			String childwindow = itr2.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objcCommonFunctions.clickOnContinueToThisWebsiteLink();
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
				.enterTextInFind(objViewPatients_data.strStudy1);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch();
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch()
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objcCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients
						.selIndividualImagesInThisStudyRadioButton()
						.clickOnProceedButton()
						.selImageInSplitMergeMoveWizardForIndividualImagesRadioButton()
						.clickOnMoveInSplitMergeMoveWizard()
						.clickOnExistingStudyInSplitMergeMoveWizard()
						.selSearchForOptionInSplitMergeMoveWizard(
								objViewPatients_data.strSearchForOptionName)
						.enterSearchForOptionFieldInSplitMergeMoveWizard(
								objViewPatients_data.strStudy1)
						.clickOnGoInSplitMergeMoveWizard()
						.selStudyInSplitMergeMoveWizard()
						.selReleaseNewStudyFromQCSandboxCheckBox()
						.clickOnMoveInSplitMergeMoveWizard()
						.clickOnOKInSplitMergeMoveWizard();

			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch()
				.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy1)
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().verNoStudiesAvailableErrorMessage();
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the resulting study is released from QC when "Release resulting study
                     from QC sandbox" option is selected in "Step 4: Enter search string and select result"
                     page when induvidual images is selected for copying.     
    'Precondition  :
    'Date          : 26-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the resulting study is released from QC when Release resulting "
			+ "study from QC sandbox option is selected in Step 4: Enter search string and select result"
			+ " page when induvidual images is selected for copying.")
	public void testHappyDay62033() throws Exception {

		gstrTCID = "62033";
		gstrTO = "Verify that the resulting study is released from QC when Release resulting study from"
				+ " QC sandbox option is selected in Step 4: Enter search string and select result page "
				+ "when induvidual images is selected for copying .";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		Thread.sleep(15000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		Thread.sleep(3000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		System.out.println(objViewPatients_data.strStudy1);
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy1,
				objViewPatients_data.strStudy1, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);

		objViewPatients.selStatusOption(objViewPatients_data.ststusAny)
				.enterTextInFind(objViewPatients_data.strStudy1);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		Thread.sleep(3000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch()
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy1);
		Set<String> allwindows2 = driver.getWindowHandles();
		Iterator<String> itr2 = allwindows2.iterator();
		while (itr2.hasNext()) {
			String childwindow = itr2.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
				.enterTextInFind(objViewPatients_data.strStudy1);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch();
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch()
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients
						.selIndividualImagesInThisStudyRadioButton()
						.clickOnProceedButton()
						.selImageInSplitMergeMoveWizardForIndividualImagesRadioButton()
						.clickOnCopyInSplitMergeMoveWizard()
						.clickOnExistingStudyInSplitMergeMoveWizard()
						.selSearchForOptionInSplitMergeMoveWizard(
								objViewPatients_data.strSearchForOptionName)
						.enterSearchForOptionFieldInSplitMergeMoveWizard(
								objViewPatients_data.strStudy1)
						.clickOnGoInSplitMergeMoveWizard()
						.selStudyInSplitMergeMoveWizard()
						.selReleaseNewStudyFromQCSandboxCheckBox()
						.clickOnCopyInSplitMergeMoveWizard()
						.clickOnOKInSplitMergeMoveWizard();

			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch()
				.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy1)
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().verNoStudiesAvailableErrorMessage();
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the studies released from QC are auto-forwarded using Aetitle rule.     
    'Precondition  :
    'Date          : 20-May-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the studies released from QC are auto-forwarded using Aetitle rule.")
	public void testHappyDay85348() throws Exception {

		gstrTCID = "85348";
		gstrTO = "Verify that the studies released from QC are auto-forwarded using Aetitle rule.";

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
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
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
				.selectRetrieveStudySCUCheckBox()
				.selectPlaceStudiesSandboxCheckBox();
		objDestinations.enterTextInAETitleField(objDICOMSettings_data.aETitle2)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddress1)
				.enterTextInLabelField(objDICOMSettings_data.label1)
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();

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
		objDestinations
				.enterTextInAETitleField(objDICOMSettings_data.aETitleFor91)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddressfor91)
				.enterTextInLabelField(objDICOMSettings_data.labelfor91)
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
		objDestinations.clickOnAdd();
		objAETitleRouting
				.selectAEDestinationInDropDown(
						objDICOMSettings_data.aeTitleDestinationFor91)
				.selRoutingModeChechbox()
				.selectAttributeInRule1DropDown(
						objDICOMSettings_data.strPatientName)
				.selRouteStudiesChechbox();

		objAETitleRouting
				.enterTextInMatchKeyOfRule1(objDICOMSettings_data.strmatchkey1);
		objDestinations.clickOnSaveChanges();
		objHome.clickOnLogOut92();
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
		Thread.sleep(3000);
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
		Iterator<String> itr1 = str.iterator();
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
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		Thread.sleep(10000);
		objViewPatients.clickOnSearch().clickOnSearch();
		objViewPatients.clickOnLogout();

		objHome.launchApplication(objLogin_data.strAppURL1);
		// objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch();
		Thread.sleep(5000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.verGreenSqaureBoxNotDisplaying(objViewPatients_data.strStudy)
				.clickOnReleaseStudyFromQc();
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
		Thread.sleep(10000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		objViewPatients.clickOnLogout();

		objHome.launchApplication(objLogin_data.strAppURLfor91);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objHome.clickOnIConsent().clickOnViewPatients11();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout1();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that a folder with a green arrow icon (Release study from QC) is 
                     displayed for a study in QC.     
    'Precondition  :
    'Date          : 04-Jul-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a folder with a green arrow icon (Release study from QC) "
			+ "is displayed for a study in QC.")
	public void testHappyDay59395() throws Exception {

		gstrTCID = "59395";
		gstrTO = "Verify that a folder with a green arrow icon (Release study from QC) is displayed"
				+ " for a study in QC.";

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
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
		objHome.clickOnLogOut92();
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
		String mainWindow = driver.getWindowHandle();
		Set<String> str = driver.getWindowHandles();
		Iterator<String> itr = str.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(3000);
				driver.switchTo().window(mainWindow);
				System.out.println("haaaaaa");
			}
		}
		Thread.sleep(3000);

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
		// String mainWindow = driver.getWindowHandle();
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
		objViewPatients.clickOnSearchTillStudySent();
		objViewPatients.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients
				.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.verReleaseStudyFromQCGreenArrowIconIsDisplayed(
						objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
	 /*************************************************************************************
	  'Description   : Verify that "Edit DICOM" button is displayed for the QC study for the User
	                   with group permissions "Allowed to Modify studies" and "Allowed to edit DICOM data".     
	  'Precondition  :
	  'Date          : 07-Jul-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that Edit DICOM button is displayed for the QC study for the User with"
			+ " group permissions Allowed to Modify studies and Allowed to edit DICOM data.")
	public void testHappyDay131374() throws Exception {

		gstrTCID = "131374";
		gstrTO = "Verify that Edit DICOM button is displayed for the QC study for the User with group"
				+ " permissions Allowed to Modify studies and Allowed to edit DICOM data.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		ModifyStudy objModifyStudy = new ModifyStudy(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
		User_data objUser_data = new User_data();

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objHome.clickOnGroups1();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedToEditDICOMDataCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox()
				.selectAllowedToSplitMoveAndMergeQCStudiesCheckBox()
				.selectAllowedToSplitMoveAndMergeAnyStudyCheckBox()
				.selectAllowedToModifyStudiesCheckBox();
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
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
		objDICOMSetting.clickOnAETitleRouting1();
		boolean actual = objAETitleRouting.delAllExistingRoute();
		while (actual == true) {
			objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
			objDICOMSetting.clickOnAETitleRouting();
			actual = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual + " aa");

		}
		objHome.clickOnLogOut92();
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
		String mainWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);

			}
		}
		driver.switchTo().defaultContent();
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
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice1)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch();
		Thread.sleep(10000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();

		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch()
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr11 = allwindows1.iterator();
		while (itr11.hasNext()) {
			String childwindow = itr11.next().toString();
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients
						.selOneOrMoreCompleteSeriesInThisStudyRadioButton()
						.clickOnProceedButton()
						.clickOnSelAllInSplitMergeMoveWizard()
						.clickOnEditDicom();
				Thread.sleep(3000);
				System.out.println(driver.getWindowHandles()
						+ " this num of windows");
				Set<String> aw = driver.getWindowHandles();
				Iterator<String> itr2 = aw.iterator();
				while (itr2.hasNext()) {
					String cw = itr2.next().toString();
					if ((!cw.contains(mainWindow))
							&& (!cw.contains(childwindow))) {
						driver.switchTo().window(cw);
						driver.manage().window().maximize();
						objViewPatients
								.enterTextInIdModalityField(objViewPatients_data.strModalityCT);
						objDestinations.clickOnSaveChanges();
						objModifyStudy.clickOnClose();
					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}

	 /*************************************************************************************
	  'Description   : Verify that User is allowed to view and modify only QC Studies when the
	                   group permissions "Allowed to view studies in QC sandbox" and "Allowed to 
	                   split, move and merge QC studies" are enabled.     
	  'Precondition  :
	  'Date          : 08-Jul-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that User is allowed to view and modify only QC Studies when the "
			+ "group permissions Allowed to view studies in QC sandbox and Allowed to split,"
			+ "move and merge QC studies are enabled.")
	public void testHappyDay167451() throws Exception {

		gstrTCID = "167451";
		gstrTO = "Verify that User is allowed to view and modify only QC Studies when the group "
				+ "permissions Allowed to view studies in QC sandbox and Allowed to split, move and merge"
				+ " QC studies are enabled.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
		User_data objUser_data = new User_data();

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();

		objHome.clickOnGroups1();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox()
				.selectAllowedToSplitMoveAndMergeQCStudiesCheckBox()
				.selectAllowedToReleaseStudiesFromQCSandboxCheckBox();
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
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
		objHome.clickOnLogOut92();
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
		String mainWindow = driver.getWindowHandle();
		driver.switchTo().defaultContent();
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
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice1)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch();
		Thread.sleep(10000);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		Thread.sleep(3000);
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy).clickOnSearch()
				.clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.verModifyStudyIconDisplayed(objViewPatients_data.strStudy);
		try {
			objViewPatients.clickOnReleaseStudyFromQc();
			Thread.sleep(5000);
			Set<String> aw = driver.getWindowHandles();
			Iterator<String> itr11 = aw.iterator();
			while (itr11.hasNext()) {
				String cw = itr11.next().toString();
				System.out.println(" a");
				if (!cw.contains(mainWindow)) {
					System.out.println(" b");
					driver.switchTo().window(cw);
					driver.manage().window().maximize();
					objViewPatients.clickOnOkInReleaseStudyFromQcWindow();
					objCommonFunctions.clickOnContinueToThisWebsiteLink();
					objViewPatients.clickOnCloseInMergeReportsPage();
				}
			}
			driver.switchTo().window(mainWindow);
		} catch (NoSuchElementException ne) {
			System.out.println("element not present");
		}
		objViewPatients.selStatusOption(objViewPatients_data.ststusAny)
				.enterTextInFind(objViewPatients_data.strStudy).clickOnSearch()
				.clickOnSearch().verModifyStudyIconNotDisplayed();
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that User is allowed to modify any study(QC and non QC) when the 
	                   group permission "Allowed to view studies in QC sandbox" and "Allowed to
	                   split, move and merge ANY study" are enabled.     
	  'Precondition  :
	  'Date          : 11-Jul-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that User is allowed to modify any study(QC and non QC) when the "
			+ "group permission Allowed to view studies in QC sandbox and Allowed to split, move "
			+ "and merge ANY study are enabled.")
	public void testHappyDay167455() throws Exception {

		gstrTCID = "167455";
		gstrTO = "Verify that User is allowed to modify any study(QC and non QC) when the group "
				+ "permission Allowed to view studies in QC sandbox and Allowed to split, move and merge ANY study are enabled.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		User_data objUser_data = new User_data();

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();

		objHome.clickOnGroups1();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox()
				.selectAllowedToSplitMoveAndMergeAnyStudyCheckBox()
				.selectAllowedToReleaseStudiesFromQCSandboxCheckBox();
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		System.out.println(objViewPatients_data.strStudy);
		System.out.println(objUser_data.strNewUserName);
		objViewPatients.clickOnNewStudy();
		Thread.sleep(3000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch().clickOnSearch();
		objViewPatients.clickOnNewStudy();
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy1,
				objViewPatients_data.strStudy1, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);

		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch()
				.clickOnModifyStudyIconOfAStudy(objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
		System.out.println(objViewPatients_data.strStudy);
		System.out.println(objViewPatients_data.strStudy1);
		objViewPatients.selStatusOption(objViewPatients_data.strStatus)
				.enterTextInFind(objViewPatients_data.strStudy)
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.verModifyStudyIconDisplayed(objViewPatients_data.strStudy);
		objViewPatients.selStatusOption(objViewPatients_data.ststusAny)
				.enterTextInFind(objViewPatients_data.strStudy1)
				.clickOnSearch().clickOnSearch()
				.verModifyStudyIconDisplayed(objViewPatients_data.strStudy1);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}

}
