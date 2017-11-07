package rhel4DiacapServer.requirementGroup.smokeSuit.ViewPatients;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

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
import page.UserManagement;
import page.ViewPatients;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayImageManagementToolsSendStudiesToDICOMStorage extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayImageManagementToolsSendStudiesToDICOMStorage() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that multiple studies can be routed to a destination by clicking 
                     the 'Batch Send Study' icon.     
    'Precondition  :
    'Date          : 27-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that multiple studies can be routed to a destination by clicking the "
			+ "'Batch Send Study' icon.")
	public void testHappyDay85522() throws Exception {

		gstrTCID = "85522";
		gstrTO = "Verify that multiple studies can be routed to a destination by clicking the 'Batch Send Study' icon.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		Login objLogin = new Login(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
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
		objUserManagement.clickOnAddUser();
		objAddUser.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName1);
		objHome.clickOnLogOut();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objUser_data.strNewUserName1,
				objUser_data.strNewPassword).clickLogin();
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
		objDestinations
				.enterTextInAETitleField(objDICOMSettings_data.aETitleFor91)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddressfor91)
				.enterTextInLabelField(objDICOMSettings_data.labelfor91)
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword).clickLogin();

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		// Thread.sleep(5000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients.clickOnSearch1();

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy1,
				objViewPatients_data.strStudy1, strImagePath,
				objViewPatients_data.strModalityDS);
		// Thread.sleep(3000);

		objViewPatients.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients.clickOnSearch1();

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy2,
				objViewPatients_data.strStudy2, strImagePath,
				objViewPatients_data.strModalityDS);
		// Thread.sleep(3000);

		objViewPatients.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients.clickOnSearch1();

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy3,
				objViewPatients_data.strStudy3, strImagePath,
				objViewPatients_data.strModalityDS);
		// Thread.sleep(3000);

		objViewPatients.selInLastOption(objDICOMSettings_data.hour);
		objViewPatients.clickOnSearch1();

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy4,
				objViewPatients_data.strStudy4, strImagePath,
				objViewPatients_data.strModalityDS);
		// Thread.sleep(3000);
		String stu = (objViewPatients_data.strStudy4).substring(13);

		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(stu);
		objViewPatients.clickOnSearch1();

		objViewPatients.selStudy(objViewPatients_data.strStudy);
		objViewPatients.selStudy(objViewPatients_data.strStudy1);
		objViewPatients.selStudy(objViewPatients_data.strStudy2);
		objViewPatients.selStudy(objViewPatients_data.strStudy3);
		objViewPatients.selStudy(objViewPatients_data.strStudy4);
		// driver.switchTo().window(mainWindow);
		objViewPatients.clickOnClickHereToSendSelectedStudiesIcon();
		String mainWindow = driver.getWindowHandle();
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
						objDICOMSettings_data.storageDevicefor91)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURLfor91);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objHome.clickOnIConsent().clickOnViewPatients11();
		/*
		 * objHome.clickOnIConsent().clickOnViewPatients();
		 * objLogin.loginAsUser(objLogin_data.strAdminUser,
		 * objLogin_data.strAdminUserPwd).clickLogin(); Thread.sleep(3000);
		 */
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy1);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy1);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy2);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy2);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy3);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy3);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy4);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy4);
		objViewPatients.clickOnLogout1();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that a study can be sent to the selected DICOM storage device.     
	  'Precondition  :
	  'Date          : 14-Jul-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that a study can be sent to the selected DICOM storage device.")
	public void testHappyDay68471() throws Exception {

		gstrTCID = "68471";
		gstrTO = "Verify that a study can be sent to the selected DICOM storage device.";

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
		AddUser objAddUser = new AddUser(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		Groups objGroups = new Groups(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
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

		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox()
				.selectAllowedToSendStudyToRemoteDeviceCheckBox();

		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
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
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(5000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.selInLastOption(objDICOMSettings_data.hour).clickOnSearch1();
		objViewPatients
				.clickOnSendThisStudyToDICOMStorageDevice(objViewPatients_data.strStudy);
		String mainWindow = driver.getWindowHandle();
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
				.clickOnSearch().clickOnSearchTillStudySent().clickOnLogout();
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
	  'Description   : Verify that the studies sent to DICOM storage is listed in the DICOM Spooler.     
	  'Precondition  :
	  'Date          : 23-Aug-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that the studies sent to DICOM storage is listed in the DICOM Spooler.")
	public void testHappyDay68474() throws Exception {

		gstrTCID = "68474";
		gstrTO = "Verify that the studies sent to DICOM storage is listed in the DICOM Spooler.";

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
		AddUser objAddUser = new AddUser(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
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
		driver.switchTo().defaultContent();
		objHome.verHomePage().clickOnAdminSite();
		driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox()
				.selectAllowedToSendStudyToRemoteDeviceCheckBox();

		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.grouptypeAdmin)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
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
		
		System.out.println(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		String[] studs = { objViewPatients_data.strStudy0,
				objViewPatients_data.strStudy1, objViewPatients_data.strStudy2,
				objViewPatients_data.strStudy3, objViewPatients_data.strStudy4};
		for (int i = 0; i < studs.length; i++) {
			objViewPatients.clickOnNewStudy();
			Thread.sleep(5000);
			objAutoIT.CreateStudy(strAutoitPath, studs[i], studs[i],
					strImagePath, objViewPatients_data.strModalityDS);
			Thread.sleep(5000);
		}
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy0.substring(15))
				.clickOnSearch1();
		objViewPatients.selSelectAllStudyCheckbox();
		objViewPatients.clickOnClickHereToSendSelectedStudiesIcon();
		String mainWindow = driver.getWindowHandle();
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
						objDICOMSettings_data.fakeStorageDevice)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);

		objViewPatients.clickOnSearch().clickOnImagesLeftToSendPlusIcon();
		Set<String> allwindows1 = driver.getWindowHandles();
		System.out.println(allwindows1.size());
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				System.out.println(driver.getTitle());
				for (int i = 0; i < studs.length; i++) {
					objViewPatients.VerifyStudyInDicomSpooler(studs[i]);
					System.out.println("1");
				}
				objViewPatients.clickOnDeleteInDicomSpooler();
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnLogout();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that all the studies to a single server in the queue are removed when the 'Delete' icon is clicked.     
	  'Precondition  :
	  'Date          : 24-Aug-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that all the studies to a single server in the queue are removed when the 'Delete' icon is clicked.")
	public void testHappyDay68608() throws Exception {

		gstrTCID = "68608";
		gstrTO = "Verify that all the studies to a single server in the queue are removed when the 'Delete' icon is clicked.";

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
		AddUser objAddUser = new AddUser(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
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
		driver.switchTo().defaultContent();
		objHome.verHomePage().clickOnAdminSite();
		driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox()
				.selectAllowedToSendStudyToRemoteDeviceCheckBox();

		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
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
		objDestinations
				.enterTextInAETitleField(objDICOMSettings_data.aETitleFake)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.fakeIpAddress)
				.enterTextInLabelField(objDICOMSettings_data.label2)
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		String[] studs = { objViewPatients_data.strStudy0,
				objViewPatients_data.strStudy1, objViewPatients_data.strStudy2,
				objViewPatients_data.strStudy3, objViewPatients_data.strStudy4 };
		for (int i = 0; i < studs.length; i++) {
			objViewPatients.clickOnNewStudy();
			Thread.sleep(5000);
			objAutoIT.CreateStudy(strAutoitPath, studs[i], studs[i],
					strImagePath, objViewPatients_data.strModalityDS);
			Thread.sleep(5000);
		}
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy0.substring(15))
				.clickOnSearch1();
		objViewPatients.selSelectAllStudyCheckbox();
		objViewPatients.clickOnClickHereToSendSelectedStudiesIcon();
		String mainWindow = driver.getWindowHandle();
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
						objDICOMSettings_data.fakeStorageDevice)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);

		objViewPatients.clickOnSearch().clickOnImagesLeftToSendPlusIcon();
		Set<String> allwindows1 = driver.getWindowHandles();
		System.out.println(allwindows1.size());
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				System.out.println(driver.getTitle());
				for (int i = 0; i < studs.length; i++) {
					objViewPatients.VerifyStudyInDicomSpooler(studs[i]);
					System.out.println("1");
				}
				objViewPatients.clickOnDeleteInDicomSpooler();
				Thread.sleep(5000);
				for (int i = 0; i < studs.length; i++) {
					objViewPatients
							.VerifyStudyNotDisplayedInDicomSpooler(studs[i]);
					System.out.println("1");
				}
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that the studies are routed to good destination when studies are 
	                   queued for good and bad destination in the DICOM spooler.     
	  'Precondition  :
	  'Date          : 17-Oct-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that the studies are routed to good destination when studies are "
			+ "queued for good and bad destination in the DICOM spooler.")
	public void testHappyDay68609() throws Exception {

		gstrTCID = "68609";
		gstrTO = "Verify that the studies are routed to good destination when studies are queued for "
				+ "good and bad destination in the DICOM spooler.";

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
		AddUser objAddUser = new AddUser(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
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
		driver.switchTo().defaultContent();
		objHome.verHomePage().clickOnAdminSite();
		driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.grouptypeAdmin)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
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
		objDestinations
				.enterTextInAETitleField(objDICOMSettings_data.aETitleFake)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.fakeIpAddress)
				.enterTextInLabelField(objDICOMSettings_data.label2)
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
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		String[] studs = { objViewPatients_data.strStudy0,
				objViewPatients_data.strStudy1 };
		for (int i = 0; i < studs.length; i++) {
			objViewPatients.clickOnNewStudy();
			Thread.sleep(5000);
			objAutoIT.CreateStudy(strAutoitPath, studs[i], studs[i],
					strImagePath, objViewPatients_data.strModalityDS);
			Thread.sleep(5000);
		}

		String mainWindow = driver.getWindowHandle();
		String[] servers = { objDICOMSettings_data.fakeStorageDevice,
				objDICOMSettings_data.storageDevice1 };
		for (int i = 0; i < studs.length; i++) {
			objViewPatients.selInLastOption(objDICOMSettings_data.hour)
					.enterTextInFind(studs[i]).clickOnSearch1();
			objViewPatients.clickOnSendThisStudyToDICOMStorageDevice(studs[i]);
			// String mainWindow = driver.getWindowHandle();
			Set<String> allwindows = driver.getWindowHandles();
			System.out.println(allwindows.size());
			Iterator<String> itr = allwindows.iterator();
			while (itr.hasNext()) {
				String childwindow = itr.next().toString();
				if (!childwindow.contains(mainWindow)) {
					driver.switchTo().window(childwindow);
					objViewPatients.selDICOMStorageDeviceRadioButton()
							.clickOnNextInSendStudyWizard();
					objViewPatients.selStorageDevice(servers[i])
							.clickOnFinishButton();
					Thread.sleep(3000);
					objViewPatients.clickOnFinishButton();
					driver.switchTo().window(mainWindow);
				}
			}
		}

		objViewPatients.clickOnSearch().clickOnImagesLeftToSendPlusIcon();
		Set<String> allwindows1 = driver.getWindowHandles();
		System.out.println(allwindows1.size());
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow = itr1.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				System.out.println(driver.getTitle());
				objViewPatients.clickOnRefreshLinkInDicomSpooler()
						.clickOnRefreshLinkInDicomSpooler();
				Thread.sleep(3000);
				objViewPatients.clickOnRefreshLinkInDicomSpooler()
						.VerifyStudyInDicomSpooler(studs[0])
						.VerifyStudyNotDisplayedInDicomSpooler(studs[1]);
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnLogout();
		String bn = objCommonFunctions.getBrowserName();
		objHome.launchApplication(objLogin_data.strAppURL1);
		if (bn.equals("internet explorer")) {
			objHome.clickOnContinuetothiswebsite();
		}
		objHome.verHomePage().clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(studs[1]).clickOnSearch()
				.verStudyFromOtherServer(studs[1]);
		objViewPatients.clickOnLogout();
		
		gstrResult = "PASS";
	}

}
