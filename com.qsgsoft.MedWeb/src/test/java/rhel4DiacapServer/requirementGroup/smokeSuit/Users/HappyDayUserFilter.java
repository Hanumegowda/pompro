package rhel4DiacapServer.requirementGroup.smokeSuit.Users;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Groups_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.PatientSchedule_data;
import dataObject.RISSettings_data;
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
import page.Groups;
import page.Home;
import page.Login;
import page.MachineSchedule;
import page.PatientScheduleRegistration;
import page.RISSettings;
import page.TelemedicineService;
import page.TelemedicineSettingsPage;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayUserFilter extends TestNG_UI_EXTENSIONSForOneBrowser {
	String strmtf;
	public HappyDayUserFilter() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the user is allowed to view studies from the user specified in
                     'By Referring' field entered while creating users.      
    'Precondition  :
    'Date          : 23-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the user is allowed to view studies from the user specified in"
			+ " 'By Referring' field entered while creating users.")
	public void testHappyDay107527() throws Exception {

		gstrTCID = "107527";
		gstrTO = "Verify that the user is allowed to view studies from the user specified in 'By Referring'"
				+ "field entered while creating users.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();

		Home objHome = new Home(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		AddUser objAddUser = new AddUser(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()/*
														 * .verUserManagementPage
														 * ()
														 */;
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnDestinations();
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

		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy1(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS,
				objViewPatients_data.strRefPhy);
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
				.clickOnCopy()
				.selectUseGroupUsertoRestrictUsersStudylistCheckBox()
				.selectAllowedToModifyStudiesCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox();
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		Thread.sleep(10000);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		System.out.println(objGroups_data.groupname);
		System.out.println(objUser_data.strNewUserName);
		System.out.println(objViewPatients_data.strRefPhy);
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.enterByReferringName(objViewPatients_data.strRefPhy);
		objAddUser.clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		objViewPatients
				.verRefPhysicianOfAllStudies(objViewPatients_data.strRefPhy)
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.verSecondStudyIsNotPresent();
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	
	/*************************************************************************************
    'Description   : Verify that the user is allowed to view studies from the user specified in
                     'By Consulting' field entered while creating users.      
    'Precondition  :
    'Date          : 26-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the user is allowed to view studies from the user specified in"
			+ " 'By Consulting' field entered while creating users.")
	public void testHappyDay83928() throws Exception {

		gstrTCID = "83928";
		gstrTO = "Verify that the user is allowed to view studies from the user specified in 'By Consulting'"
				+ " field entered while creating users.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Groups_data objGroups_data = new Groups_data();
		PathData objPathData = new PathData();

		Home objHome = new Home(this.driver);
		Groups objGroups = new Groups(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		TelemedicineService objTelemedicineService = new TelemedicineService(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		// autoitfile
		String fileuploadpath = pathProps
				.getProperty(objPathData.uploadAutoITFilePath);
		System.out.println(fileuploadpath);
		File autoitfile = new File(System.getProperty("user.dir")
				+ fileuploadpath);
		String strAutoitPath = autoitfile.toString();
		System.out.println(strAutoitPath + 1);

		// image
		String imagePath = pathProps.getProperty(objPathData.sudyWithImage);
		System.out.println(imagePath);

		File imageFile = new File(System.getProperty("user.dir") + imagePath);
		String strImagePath = imageFile.toString();

		String[] str = { strAutoitPath, strImagePath };

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		this.driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy()
				.selectUseGroupUsertoRestrictUsersStudylistCheckBox()
				.selectAllowedToModifyStudiesCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox();
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUser();
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser
				.selectOptionInACLgroupDropDown(objUser_data.telemedicineRefMD)
				.enterFullNameLast(objUser_data.strtelUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strtelUserName);

		objUserManagement.clickOnAddUser();
		objAddUser.selectOptionInACLgroupDropDown(objUser_data.generalist)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName1);

		objUserManagement.clickOnAddUser();
		objAddUser.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName2)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnEditOfByConsultingField();
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr = aw.iterator();
		while (itr.hasNext()) {
			String cw = itr.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();
				objAddUser.selConsultingPhysician(objUser_data.strNewUserName1)
						.clickOnSave();
			}

		}
		driver.switchTo().window(mw);

		objAddUser.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName2);
		objHome.clickOnLogOut();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strtelUserName,
				objUser_data.strNewPassword).clickLogin();
		objTelemedicineService.clickOnGeneral();
		String mainwindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> itr1 = windowHandles.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!cw.contains(mainwindowHandle)) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();

				objTelemedicineService
						.selConsultingMDFromDropdown(
								objUser_data.strNewUserName1)
						.enterLastName(objUser_data.strCaseLastName1)
						.enterFirstName(objUser_data.strCaseFirstName1)
						.enterInsurance("abcd123").selDayFromDropdown("")
						.selMonthFromDropdown("").selYearFromDropdown("")
						.clickOnDataFiles();
				objTelemedicineService
						.selImageSourceDropdownOption("Image files on disk");
				objTelemedicineService.clickOnAcquireButton();
				objAutoIT.executeAutoItFile(str);
				objTelemedicineService.clickOnSubmit();
				Thread.sleep(3000);
				objTelemedicineService.clickOnOkButton();
				driver.close();
				Thread.sleep(3000);
				objUserManagement.clickOnOkInAlertPopUp();
			}
		}

		driver.switchTo().window(mainwindowHandle);
		objTelemedicineService.verCase(objUser_data.strCaseLastName1);
		objTelemedicineService.clickOnLogOut();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword).clickLogin();
		objTelemedicineService.verCase(objUser_data.strCaseLastName1)
				.clickOnLogOut();
		Thread.sleep(3000);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.verStudyFromOtherServer(objUser_data.strCaseLastName1)
				.verSecondStudyIsNotPresent().clickOnLogout();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that the user is allowed to view studies from the MTF when MTF name
                     is entered in 'By MTF List' field entered while creating users.      
    'Precondition  :
    'Date          : 26-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the user is allowed to view studies from the MTF when MTF "
			+ "name is entered in 'By MTF List' field entered while creating users.")
	public void testHappyDay83936() throws Exception {

		gstrTCID = "83936";
		gstrTO = "Verify that the user is allowed to view studies from the MTF when MTF name is "
				+ "entered in 'By MTF List' field entered while creating users.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();

		Home objHome = new Home(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
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
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.enterTextInMTFCode(objDICOMSettings_data.mtfcode1)
		.selAddMTFToAccessionNumberRadioButton()
				.clickOnSaveChanges().clickOnDestinations();
		objDestinations.clickOnAdd().verDestinationEditorPage();
		System.out.println(objDICOMSettings_data.mtfcode1);
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
		String mainWindow = driver.getWindowHandle();
		Set<String> str = driver.getWindowHandles();
		Iterator<String> itr = str.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			System.out.println(childwindow + "firstcldwnd");
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
		objViewPatients
				.clickOnSearch1()
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
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objViewPatients.clickOnLogout();

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
				.clickOnCopy()
				.selectAllowedToViewStudiesInQcSandboxCheckBox()
				.selectUseGroupUsertoRestrictUsersStudylistCheckBox()
				.selectAllowedToModifyStudiesCheckBox();
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnEditOfByMTF();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr11 = allwindows.iterator();
		while (itr11.hasNext()) {
			String childwindow = itr11.next().toString();
			if (!mainwindow.contains(childwindow)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				objAddUser.selAMTFName(objDICOMSettings_data.mtfcode1);
				Thread.sleep(5000);
				objAddUser.clickOnSave();
			}
		}
		driver.switchTo().window(mainwindow);
		objAddUser.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.clickOnSearch();
		Thread.sleep(5000);
		objViewPatients.verMtfOfAllStudies(objDICOMSettings_data.mtfcode1);
		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that the user is allowed to view studies from the Institution when 
                     institution name is entered in 'By Inst Name' field entered while creating users.      
    'Precondition  :
    'Date          : 27-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the user is allowed to view studies from the Institution when"
			+ " institution name is entered in 'By Inst Name' field entered while creating users .")
	public void testHappyDay83945() throws Exception {

		gstrTCID = "83945";
		gstrTO = "Verify that the user is allowed to view studies from the Institution when institution"
				+ " name is entered in 'By Inst Name' field entered while creating users .";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		User_data objUser_data = new User_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();

		Home objHome = new Home(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		AddUser objAddUser = new AddUser(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting
				.enterTextInInstitutionNameTextField(
						objDICOMSettings_data.strInstitute)
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
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
			}
		}
		// driver.switchTo().window(mainWindow);
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
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objViewPatients.clickOnLogout();
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
				.clickOnCopy()
				.selectUseGroupUsertoRestrictUsersStudylistCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox()
				.selectAllowedToModifyStudiesCheckBox();
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		System.out.println(objUser_data.strNewUserName);
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnEditOfByInstName();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr11 = allwindows.iterator();
		while (itr11.hasNext()) {
			String childwindow = itr11.next().toString();
			if (!mainwindow.contains(childwindow)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				System.out.println(objDICOMSettings_data.strInstitute);
				objAddUser
						.selAInstitutionAndGetItsName(objDICOMSettings_data.strInstitute);
				objAddUser.clickOnSave();
			}
		}
		driver.switchTo().window(mainwindow);
		Thread.sleep(5000);
		objAddUser.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.selLayout(objViewPatients_data.strLayout)
				.clickOnSearch();
		Thread.sleep(5000);
		objViewPatients.verInstitutionNameOfAllStudies(
				objDICOMSettings_data.strInstitute,
				objViewPatients_data.strinst);
		objViewPatients.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL1);
		// objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		// objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.enterTextInInstitutionNameTextField(
				objDICOMSettings_data.strInstitute1).clickOnSaveChanges();
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the user is allowed to view studies from the Station when Station
                     name is entered in 'By Station Name' field entered while creating users.      
    'Precondition  :
    'Date          : 27-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the user is allowed to view studies from the Station when "
			+ "Station name is entered in 'By Station Name' field entered while creating users.")
	public void testHappyDay83955() throws Exception {

		gstrTCID = "83955";
		gstrTO = "Verify that the user is allowed to view studies from the Station when Station "
				+ "name is entered in 'By Station Name' field entered while creating users.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();

		Home objHome = new Home(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups objGroups = new Groups(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Groups_data objGroups_data = new Groups_data();
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
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
		objAdministratorSite.verAdministratorSitePage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting
				.enterTextInStationName(objDICOMSettings_data.strStation)
				.clickOnSaveChanges();

		objDICOMSetting.clickOnDestinations();
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

		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objViewPatients.clickOnNewStudy();
		// objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
				.clickOnCopy()
				.selectUseGroupUsertoRestrictUsersStudylistCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox()
				.selectAllowedToModifyStudiesCheckBox();
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnEditOfByStationName();
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr1 = aw.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!mw.contains(cw)) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();
				objAddUser.selAMTFName(objDICOMSettings_data.strStation)
						.clickOnSave();
			}
		}
		driver.switchTo().window(mw);
		objAddUser.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		Thread.sleep(5000);
		objViewPatients.selLimitOption(objViewPatients_data.strLimit)
				.selLayout(objViewPatients_data.strLayout)
				.verSelectedStation(objDICOMSettings_data.strStation)
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.verSecondStationNotPresent();
		objViewPatients.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL1);
		// objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		// objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.enterTextInStationName(
				objDICOMSettings_data.strStation1).clickOnSaveChanges();
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the user is allowed to view studies from the Service Location when
                     Service Location is entered in 'By Service Location' field entered while creating users.     
    'Precondition  :
    'Date          : 13-Jun-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the user is allowed to view studies from the Service Location when Service "
			+ "Location is entered in 'By Service Location' field entered while creating users.")
	public void testHappyDay106196() throws Exception {

		gstrTCID = "106196";
		gstrTO = "Verify that the user is allowed to view studies from the Service Location when Service Location "
				+ "is entered in 'By Service Location' field entered while creating users.";

		Login_data objLogin_data = new Login_data();
		Groups_data objGroups_data = new Groups_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		Home objHome = new Home(this.driver);
		Groups objGroups = new Groups(this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		MachineSchedule objMachineSchedule = new MachineSchedule(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileAutoITDownloadPath = pathProps
				.getProperty(objPathData.autoItFilePathLocalService);
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

		String str1 = objPatientSchedule_data.strPatient;
		String str2 = str1.substring(11);
		String str3 = str1.substring(0, 11);
		String str4 = str2.substring(0, 3);
		System.out.println(str2 + " str2");
		System.out.println(str3 + " str3");
		System.out.println(str4 + " str4");

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
		objNavigationToSubMenus.clickOnRISSettings1();
		objRISSettings.clickOnOpenPageOfServiceLocations()
				.verServiceLocationPage().clickOnAdd()
				.enterTextInLocationName(objRISSettings_data.strLocation)
				.enterTextInLocationShortName(objRISSettings_data.strLocation1)
				.clickOnSaveChanges();

		objNavigationToSubMenus.clickOnRISSettingsForSecondTime();
		objRISSettings.clickOnOpenPageOfMandatoryFields()
				.clickOnPatientRegistrationLink().clickOnSetDefault()
				.clickOnSaveChanges();
		objRISSettings.clickOnEnterOrderLink().clickOnSetDefault()
				.clickOnSaveChanges();
		objRISSettings.clickClinicsAndMachines1();
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
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				Thread.sleep(3000);
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
		objPatientScheduleRegistration.clickOnSearchIconOfServiceLocation();
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr1 = aw.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!(cw.contains(mw))) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();
				// objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objPatientScheduleRegistration
						.selServiceLocation(objRISSettings_data.strLocation);
			}
		}
		/*
		 * for (String cw : driver.getWindowHandles()) {
		 * System.out.println((driver.getWindowHandles()).size() +
		 * " thes is the no of windows"); driver.switchTo().window(cw);
		 * Thread.sleep(5000);
		 * objCommonFunctions.clickOnContinueToThisWebsiteLink();
		 * driver.manage().window().maximize(); objPatientScheduleRegistration
		 * .selServiceLocation(objRISSettings_data.strLocation); }
		 */
		driver.switchTo().window(mw);
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
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch()
				.clickOnSendThisStudyToDICOMStorageDevice(str2);
		String mainWindow = driver.getWindowHandle();
		Set<String> str11 = driver.getWindowHandles();
		Iterator<String> itr11 = str11.iterator();
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
				.clickOnCopy()
				.selectUseGroupUsertoRestrictUsersStudylistCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox();
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnEditOfByServiceLocation();
		String mainwindow1 = driver.getWindowHandle();
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr111 = allwindows1.iterator();
		while (itr111.hasNext()) {
			String childwindow = itr111.next().toString();
			if (!mainwindow1.contains(childwindow)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				objAddUser.selAMTFName(objRISSettings_data.strLocation1);
				Thread.sleep(5000);
				objAddUser.clickOnSave();
			}
		}
		driver.switchTo().window(mainwindow1);
		objAddUser.clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(str3).clickOnSearch().clickOnSearch()
				.clickOnSearch();
		objViewPatients.verStudyFromOtherServer(str2).clickOnLogout();

		gstrResult = "PASS";

	}

}