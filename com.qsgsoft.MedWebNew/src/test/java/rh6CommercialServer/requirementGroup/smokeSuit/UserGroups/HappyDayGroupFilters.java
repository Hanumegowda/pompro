package rh6CommercialServer.requirementGroup.smokeSuit.UserGroups;

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
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.ControlPanel;
import page.DICOMSetting;
import page.Destinations;
import page.Groups;
import page.Home;
import page.Login;
import page.TelemedicineService;
import page.TelemedicineSettingsPage;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayGroupFilters extends TestNG_UI_EXTENSIONSForOneBrowser{
	String strmtf;
	public HappyDayGroupFilters() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that a MTF list can be defined for a new group so that studies 
                     received from the allowed MTF are dislayed in the View Patients page.     
    'Precondition  :
    'Date          : 19-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a MTF list can be defined for a new group so that studies "
			+ "received from the allowed MTF are dislayed in the View Patients page.")
	public void testHappyDay68032() throws Exception {

		gstrTCID = "68032";
		gstrTO = "Verify that a MTF list can be defined for a new group so that studies received"
				+ " from the allowed MTF are dislayed in the View Patients page.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();

		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		AddUser objAddUser = new AddUser(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
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
				.selectAllowedToViewStudiesInQcSandboxCheckBox()
				.selectAllowedMTFListCheckBox()
				.enterTextInAllowedMTFListField(objDICOMSettings_data.mtfcode1);
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
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objNavigationToSubMenus.clickOnDICOMSettings1();
		objDICOMSetting.enterTextInMTFCode(objDICOMSettings_data.mtfcode1)
				.selAddMTFToAccessionNumberRadioButton().clickOnSaveChanges()
				.clickOnDestinations1();
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

		objNavigationToSubMenus.clickOnPublicSite1();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnNewStudy();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println(allwindows.size() + " no of windows");
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				driver.switchTo().window(mainwindow);
				System.out.println(" yes window is dr");

			}
		}
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		System.out.println(objViewPatients_data.strStudy);
		Thread.sleep(5000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch1();
		objViewPatients
				.clickOnSendThisStudyToDICOMStorageDevice(objViewPatients_data.strStudy);

		Set<String> all1 = driver.getWindowHandles();
		Iterator<String> itr2 = all1.iterator();
		while (itr2.hasNext()) {
			String childwindow2 = itr2.next().toString();
			if (!childwindow2.contains(mainwindow)) {
				driver.switchTo().window(childwindow2);
				Thread.sleep(3000);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearchTillStudySent().clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients/*.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy)*/.clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objViewPatients
				.clickOnModifyStudyFieldsOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!childwindow1.contains(mainwindow)) {
				driver.switchTo().window(childwindow1);
				Thread.sleep(3000);
				objViewPatients.verMTFCode(objDICOMSettings_data.mtfcode1);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.verSecondStudyIsNotPresent();
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that user belonging to a group is allowed to view only the studies
                     that have the Modality allowed while creating a group.     
    'Precondition  :
    'Date          : 20-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that user belonging to a group is allowed to view only the studies "
			+ "that have the Modality allowed while creating a group.")
	public void testHappyDay68036() throws Exception {

		gstrTCID = "68036";
		gstrTO = "Verify that user belonging to a group is allowed to view only the studies that "
				+ "have the Modality allowed while creating a group.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();

		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
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
				.selectAllowedModalityListCheckBox()
				.enterTextInAllowedModalityListField(objGroups_data.modality)
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
				.clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.clickOnSearch().clickOnSearch()
				.clickOnModifyStudyFieldsIconOfAnyStudy();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!childwindow1.contains(mainwindow)) {
				driver.switchTo().window(childwindow1);
				objViewPatients.verModality(objGroups_data.modality);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		int i = objGroups_data.modalities.length;
		System.out.println(i+" modalities");
		for(int i1=0;i1<i;i1++){
		objViewPatients.selModalityOption(objGroups_data.modalities[i1]).clickOnSearch();
		objViewPatients.verNoStudiesAvailableErrorMessage();
		}

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   :Verify that Group Filters are not applied when the permission 'Use Group/User
                    filters to restrict users study list' is disabled.     
    'Precondition  :
    'Date          : 20-Oct-2015h
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Group Filters are not applied when the permission 'Use Group/User"
			+ " filters to restrict users study list' is disabled .")
	public void testHappyDay68041() throws Exception {

		gstrTCID = "68041";
		gstrTO = "Verify that Group Filters are not applied when the permission 'Use Group/User filters"
				+ " to restrict users study list' is disabled .";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();

		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
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
				.deSelectUseGroupUsertoRestrictUsersStudylistCheckBox()
				.enterTextInAllowedModalityListField(objGroups_data.modality1)

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
				.clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.selModalityOption(objGroups_data.modality1).clickOnSearch().clickOnSearch()
				.clickOnModifyStudyFieldsIconOfAnyStudy();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!childwindow1.contains(mainwindow)) {
				driver.switchTo().window(childwindow1);
				objViewPatients.verAnyModality(objGroups_data.modality1);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.selModalityOption(objGroups_data.modality).clickOnSearch().clickOnSearch().clickOnSearch()
		.clickOnSearch().clickOnModifyStudyFieldsIconOfAnyStudy();
		Set<String> allwindows2 = driver.getWindowHandles();
		Iterator<String> itr2 = allwindows2.iterator();
		while (itr2.hasNext()) {
			String childwindow1 = itr2.next().toString();
			if (!childwindow1.contains(mainwindow)) {
				driver.switchTo().window(childwindow1);
				objViewPatients.verAnyModality(objGroups_data.modality1);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that users in a group can view only the studies in the Institution
                     allowed while creating the group.     
    'Precondition  :
    'Date          : 21-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that users in a group can view only the studies in the Institution"
			+ "allowed while creating the group.")
	public void testHappyDay68034() throws Exception {

		gstrTCID = "68034";
		gstrTO = "Verify that users in a group can view only the studies in the Institution allowed "
				+ "while creating the group.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();

		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement.clickOnModifyUser(objUser_data.strNewUserName);
		objAddUser.clickOnEditOfByInstName();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!(childwindow.contains(mainwindow))) {
				driver.switchTo().window(childwindow);
				strmtf = objAddUser.getMTF();
				driver.close();
			}

		}

		driver.switchTo().window(mainwindow);
		System.out.println(strmtf);
		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy()
				.selectUseGroupUsertoRestrictUsersStudylistCheckBox()
				.selectAllowedToModifyStudiesCheckBox()
				.selectAllowedInstitutionNameListCheckBox()
				.enterTextInAllowedInstitutionNameListField(strmtf);

		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnModifyUser(objUser_data.strNewUserName);
		objAddUser.selectOptionInACLgroupDropDown(objGroups_data.groupname);
		Thread.sleep(5000);
		objAddUser.clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.clickOnSearch().clickOnSearch()
				.clickOnModifyStudyFieldsIconOfAnyStudy();
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows1.iterator();
		while (itr1.hasNext()) {
			String childwindow1 = itr1.next().toString();
			if (!childwindow1.contains(mainwindow)) {
				driver.switchTo().window(childwindow1);
				objViewPatients.verInstitutionName(strmtf);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that user belonging to a group is allowed to view only the studies
                     that have the Project allowed while creating a group.     
    'Precondition  :
    'Date          : 22-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that user belonging to a group is allowed to view only the studies"
			+ " that have the Project allowed while creating a group.")
	public void testHappyDay68038() throws Exception {

		gstrTCID = "68038";
		gstrTO = "Verify that user belonging to a group is allowed to view only the studies that have"
				+ " the Project allowed while creating a group.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();

		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		/* 1 */
		String fileUploadPath1 = pathProps
				.getProperty(objPathData.strUploadzipfile1);

		File file1 = new File(System.getProperty("user.dir") + fileUploadPath1);
		String strPath1 = file1.toString();
		System.out.println(strPath1);
		String str1[] = strPath1.split("\\\\");
		String filename1 = str1[(str1.length - 1)];
		String filenamea[] = filename1.split("\\.");
		System.out.println(filename1);
		System.out.println(filenamea[0]);
		String substr = filename1.substring(0, 3);
		System.out.println(substr);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnUploadZipLink().verUploadZipFilesPage()
				.clickOnBrowse1(strPath1).clickOnUploadButton();
		objUserManagement.clickOnOkInAlertPopUp();
		objViewPatients.clickOnLogout();
		objHome.clickOnAdminSite();
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
				.selectAllowedProjectsListCheckBox()

				.enterTextInAllowedProjectsListField(substr);
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
		System.out.println(objUser_data.strNewUserName);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(filenamea[0]);
		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   :Verify that users in a group can view studies created by a Referring Physician
                    when the Referring Physician name is entered in 'Allowed by Referring MD filter'.     
    'Precondition  :
    'Date          : 22-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that users in a group can view studies created by a Referring Physician"
			+ " when the Referring Physician name is entered in 'Allowed by Referring MD filter'.")
	public void testHappyDay84151() throws Exception {

		gstrTCID = "84151";
		gstrTO = "Verify that users in a group can view studies created by a Referring Physician when the "
				+ "Referring Physician name is entered in 'Allowed by Referring MD filter'.";

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
		objNavigationToSubMenus.clickOnDICOMSettings1();
		objDICOMSetting.clickOnDestinations1();
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

		objNavigationToSubMenus.clickOnPublicSite1();
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
				.selectAllowedByUserReferringMDFilterCheckBox()
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
    'Description   : Verify that the studies of the institution that exactly matches with the
                     institution name is displayed in the View Patients page when institution name
                     starting with tilde symbol is entered in “Allowed Institution name list”.     
    'Precondition  :
    'Date          : 28-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the studies of the institution that exactly matches with the institution"
			+ " name is displayed in the View Patients page when institution name starting with tilde symbol is "
			+ "entered in “Allowed Institution name list”.")
	public void testHappyDay72910() throws Exception {

		gstrTCID = "72910";
		gstrTO = "Verify that the studies of the institution that exactly matches with the institution name is"
				+ " displayed in the View Patients page when institution name starting with tilde symbol is entered"
				+ " in “Allowed Institution name list”.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();

		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups objGroups = new Groups(this.driver);
		Groups_data objGroups_data = new Groups_data();
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups
				.verAddNewGroup()
				.enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy()
				.selectUseGroupUsertoRestrictUsersStudylistCheckBox()
				.selectAllowedToModifyStudiesCheckBox()
				.selectAllowedInstitutionNameListCheckBox()
				.enterTextInAllowedInstitutionNameListField(
						objGroups_data.institutionName);
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
		System.out.println(objUser_data.strNewUserName);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.selLayout(objViewPatients_data.strLayout)
				.selLimitOption(objViewPatients_data.strLimit).clickOnSearch()
				.clickOnSearch().verSite(objGroups_data.institutionName1);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that users in a group can view studies assigned to a Consulting MD 
                     when the Consulting Physician name is entered in 'Allowed by Consulting MD filter'.      
    'Precondition  :
    'Date          : 08-Dec-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that users in a group can view studies assigned to a Consulting MD "
			+ "when the Consulting Physician name is entered in 'Allowed by Consulting MD filter'.")
	public void testHappyDay166355() throws Exception {

		gstrTCID = "166355";
		gstrTO = "Verify that users in a group can view studies assigned to a Consulting MD when the"
				+ " Consulting Physician name is entered in 'Allowed by Consulting MD filter'.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Groups_data objGroups_data = new Groups_data();
		PathData objPathData = new PathData();

		Home objHome = new Home(this.driver);
		Groups objGroups = new Groups(this.driver);
		TelemedicineSettingsPage objTelemedicineSettingsPage = new TelemedicineSettingsPage(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		TelemedicineService objTelemedicineService = new TelemedicineService(
				this.driver);
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
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTelemedicineSettingsPageParametersLink();
		objTelemedicineSettingsPage.verTelemedicineSettingsPage()
				.deSelectDisplayUnassignedCases();
		objTelemedicineSettingsPage.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUser();
		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.gpTypeConsultingPhysician)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeDent)
				.clickOnCopy()
				.selectUseGroupUserFiltersToRestrictUsersStudyListCheckBox()
				.selectAllowedByUserConsultingMDFilterCheckBox();
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
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
		String[] cases1 = {objUser_data.strCaseLastName1,objUser_data.strCaseLastName2,objUser_data.strCaseLastName3,
				objUser_data.strCaseLastName4,objUser_data.strCaseLastName5};
		String[] cases2 = {objUser_data.strCaseFirstName1,objUser_data.strCaseFirstName2,objUser_data.strCaseFirstName3,
				objUser_data.strCaseFirstName4,objUser_data.strCaseFirstName5};
		for(int i=0;i<cases1.length;i++){
		objTelemedicineService.clickOnGeneral();
		String mainwindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String element : windowHandles) {
			if (!element.equals(mainwindowHandle)) {
				driver.switchTo().window(element);
				driver.manage().window().maximize();

				objTelemedicineService
						.selConsultingMDFromDropdown(
								objUser_data.strNewUserName1)
						.enterLastName(cases1[i])
						.enterFirstName(cases2[i])
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
		objTelemedicineService.verCase(cases1[i]);
		}
		objTelemedicineService
				.clickOnLogOut();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword).clickLogin();
		objTelemedicineService.verCase(objUser_data.strCaseLastName1).verCase(objUser_data.strCaseLastName2).verCase(objUser_data.strCaseLastName3)
		.verCase(objUser_data.strCaseLastName4).verCase(objUser_data.strCaseLastName5)
				.clickOnLogOut();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword).clickLogin();
		objTelemedicineService.verCase(objUser_data.strCaseLastName1).verCase(objUser_data.strCaseLastName2).verCase(objUser_data.strCaseLastName3)
		.verCase(objUser_data.strCaseLastName4).verCase(objUser_data.strCaseLastName5)
				.clickOnLogOut();

		gstrResult = "PASS";

	}

}
