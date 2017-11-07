package rh4CommercialServer.requirementGroup.smokeSuit.ViewPatients;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import static org.testng.Assert.assertTrue;
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
import page.Destinations;
import page.Groups;
import page.Home;
import page.Login;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.FileFormatConverter;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayViewPatientsPageForStudies extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayViewPatientsPageForStudies() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the user can create a New Study in the Demographics & Acquisition
                     screen by entering all data and uploading images.     
    'Precondition  :
    'Date          : 21-Mar-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the user can create a New Study in the Demographics & "
			+ "Acquisition screen by entering all data and uploading images.")
	public void testHappyDay128719() throws Exception {

		gstrTCID = "128719";
		gstrTO = "Verify that the user can create a New Study in the Demographics & Acquisition"
				+ " screen by entering all data and uploading images.";

		Login_data objLogin_data = new Login_data();
		Groups_data objGroups_data = new Groups_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		User_data objUser_data = new User_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
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
		objGroups.verGroupsPage().clickOnAddGroup().verAddNewGroup()
				.enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedToModifyStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedCreateNewStudiesCheckBox().clickOnSaveChanges();
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
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.selInLastOption(objDICOMSettings_data.hour)
				.selLayout(objViewPatients_data.strLayout)
				.selStatusOption(objViewPatients_data.ststusAny)
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		String mainwindow = driver.getWindowHandle();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients
						.verDefaultReportOfStudy(objUser_data.strNewUserName);
				driver.close();
			}
			
		}
		driver.switchTo().window(mainwindow);

		gstrResult = "PASS";

	}

	/*************************************************************************************
	 * 'Description  : Verify that user can upload 5 zip files with file format
	 *                 (ClinicalTrialID)-(SequenceNumber).Zip. 
	 * 'Precondition : 
	 * 'Date         : 10-Aug-2015 
	 * 'Author       : Hanumegowda
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that user can upload 5 zip files with file format (ClinicalTrialID)-(SequenceNumber).Zip.")
	public void testHappyDay128721() throws Exception {

		gstrTCID = "128721";
		gstrTO = "Verify that user can upload 5 zip files with file format (ClinicalTrialID)-(SequenceNumber).Zip.";

		Login_data objLogin_data = new Login_data();
		Groups_data objGroups_data = new Groups_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		/* 1 */

		String fileUploadPath1 = pathProps
				.getProperty(objPathData.strUploadzipfile1);

		File file1 = new File(System.getProperty("user.dir") + fileUploadPath1);
		String strPath1 = file1.toString();
		String str1[] = strPath1.split("\\\\");
		String filename1 = str1[(str1.length - 1)];
		String filenamea[] = filename1.split("\\.");
		System.out.println(filename1);
		System.out.println(filenamea[0]);
		String substr = filename1.substring(0, 8);
		System.out.println(substr);

		/* 2 */

		String fileUploadPath2 = pathProps
				.getProperty(objPathData.strUploadzipfile2);

		File file2 = new File(System.getProperty("user.dir") + fileUploadPath2);
		String strPath2 = file2.toString();
		String str2[] = strPath2.split("\\\\");
		String filename2 = str2[(str2.length - 1)];
		String filenameb[] = filename2.split("\\.");
		System.out.println(filename2);

		/* 3 */

		String fileUploadPath3 = pathProps
				.getProperty(objPathData.strUploadzipfile3);

		File file3 = new File(System.getProperty("user.dir") + fileUploadPath3);
		String strPath3 = file3.toString();
		String str3[] = strPath3.split("\\\\");
		String filename3 = str3[(str3.length - 1)];
		String filenamec[] = filename3.split("\\.");
		System.out.println(filename3);

		/* 4 */

		String fileUploadPath4 = pathProps
				.getProperty(objPathData.strUploadzipfile4);

		File file4 = new File(System.getProperty("user.dir") + fileUploadPath4);
		String strPath4 = file4.toString();
		String str4[] = strPath4.split("\\\\");
		String filename4 = str4[(str4.length - 1)];
		String filenamed[] = filename4.split("\\.");
		System.out.println(filename4);

		/* 5 */

		String fileUploadPath5 = pathProps
				.getProperty(objPathData.strUploadzipfile5);

		File file5 = new File(System.getProperty("user.dir") + fileUploadPath5);
		String strPath5 = file5.toString();
		String str5[] = strPath5.split("\\\\");
		String filename5 = str5[(str5.length - 1)];
		String filenamee[] = filename5.split("\\.");
		System.out.println(filename5);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnGroups();
		objGroups.clickOnAddGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectAllowedtoAccessServerCheckbox()
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectShowUploadZipFilesCheckBox().clickOnSaveChanges();
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
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.enterTextInFind(substr).clickOnSearch().clickOnSearch().clickOnSearch();
		boolean value = objViewPatients.selSelectAllStudyCheckbox();
		if(value==true){
		objViewPatients.delAllSelectedStudies();
		objViewPatients.clickOnSearch();
		System.out.println("study not dr");
		}
		objViewPatients.clickOnUploadZipLink().verUploadZipFilesPage()
				.clickOnBrowse1(strPath1).clickOnBrowse2(strPath2)
				.clickOnBrowse3(strPath3).clickOnBrowse4(strPath4)
				.clickOnBrowse5(strPath5).clickOnUploadButton();
		objUserManagement.clickOnOkInAlertPopUp();
		objUserManagement.clickOnOkInAlertPopUp();
		objUserManagement.clickOnOkInAlertPopUp();
		objUserManagement.clickOnOkInAlertPopUp();
		objUserManagement.clickOnOkInAlertPopUp();
		objViewPatients.clickOnBackButton();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour).enterTextInFind(substr).clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.verUploadZipFile(filenamea[0]).verUploadZipFile(filenameb[0])
				.verUploadZipFile(filenamec[0]).verUploadZipFile(filenamed[0])
				.verUploadZipFile(filenamee[0]);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that a user can upload 5 DICOM files in the Upload DCM page.     
    'Precondition  :
    'Date          : 09-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a user can upload 5 DICOM files in the Upload DCM page.")
	public void testHappyDay68403() throws Exception {

		gstrTCID = "68403";
		gstrTO = "Verify that a user can upload 5 DICOM files in the Upload DCM page.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Groups_data objGroups_data = new Groups_data();
		User_data objUser_data = new User_data();
		Date_Time_settings objDts = new Date_Time_settings();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Groups objGroups = new Groups(this.driver);
		String strTimeText = objDts.getCurrentDate(objPathData.dateFormat1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		System.out.println(pathProps);

		// backup
		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		System.out.println(backfile);
		String backupfiledownloadpath1 = backfile + "\\" + strTimeText;
		System.out.println(backupfiledownloadpath1 + " see here");
		String file1 = backupfiledownloadpath1 + "\\" + "DICOM" + "\\"
				+ "IMA00000000.dcm";
		String file2 = backupfiledownloadpath1 + "\\" + "DICOM" + "\\"
				+ "IMA00000001.dcm";
		String file3 = backupfiledownloadpath1 + "\\" + "DICOM" + "\\"
				+ "IMA00000002.dcm";
		String file4 = backupfiledownloadpath1 + "\\" + "DICOM" + "\\"
				+ "IMA00000003.dcm";
		String file5 = backupfiledownloadpath1 + "\\" + "DICOM" + "\\"
				+ "IMA00000004.dcm";
		System.out.println(file1 + " f1");
		System.out.println(file2 + " f2");
		System.out.println(file3 + " f3");
		System.out.println(file4 + " f4");
		System.out.println(file5 + " f5");

		AutoIT objAutoIT = new AutoIT(this.driver);
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
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnGroups();
		objGroups.clickOnAddGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectAllowedtoAccessServerCheckbox()
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectShowUploadDICOMFilesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedCreateNewStudiesCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox()
				.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUser();
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
		objViewPatients
				.clickOnSearch1()
				.clickOnSendThisStudyToDICOMStorageDevice(
						objViewPatients_data.strStudy);
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		for (String cw : aw) {
			driver.switchTo().window(cw);
		}
		objViewPatients.sellocalpcRadioButton().clickOnNextInSendStudyWizard()
				.enterTextInLocalPath(backupfiledownloadpath1);
		objViewPatients.selSaveDcmCheckbox().clickOnFinishButton();
		Thread.sleep(10000);
		objUserManagement.clickOnOkInAlertPopUp();
		driver.switchTo().window(mw);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch().clickOnSearch();
		objViewPatients.delAPerticularStudy(objViewPatients_data.strStudy);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch().clickOnSearch();
		objViewPatients.verNoStudiesAvailableErrorMessage();
		Thread.sleep(3000);
		objViewPatients.clickOnUploadDCMLink().verUploadDICOMFilePage()
				.clickOnBrowse1(file1);
		Thread.sleep(3000);
		objViewPatients.clickOnBrowse2(file2);
		Thread.sleep(3000);
		objViewPatients.clickOnBrowse3(file3);
		Thread.sleep(3000);
		objViewPatients.clickOnBrowse4(file4);
		Thread.sleep(3000);
		objViewPatients.clickOnBrowse5(file5);
		Thread.sleep(3000);
		objViewPatients.clickOnUploadButton().clickOnBackButton();
		objViewPatients.selLayout(objViewPatients_data.strLayout)
				.enterTextInFind(objViewPatients_data.strStudy).clickOnSearch()
				.clickOnSearch()
				.verStudyFromOtherServer1(objViewPatients_data.strStudy);

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that View Patients page is displayed when user logs into the Public site.     
    'Precondition  :
    'Date          : 05-Jul-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that View Patients page is displayed when user logs into the Public site.")
	public void testHappyDay68394() throws Exception {

		gstrTCID = "68394";
		gstrTO = "Verify that View Patients page is displayed when user logs into the Public site.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.verNewStudyLinkIsDisplayed().verAStudyColumnHeadersIsDisplayed();
		
		gstrResult = "PASS";
	}
	
	 /*************************************************************************************
	  'Description   : Verify that the link 'New Study' is displayed in View Patients page when 
	                   the user has permission 'Show New Study link on Patients Page' and 'Allowed
	                   to create studies' permssion.     
	  'Precondition  :
	  'Date          : 06-Jul-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that the link 'New Study' is displayed in View Patients page when "
			+ "the user has permission 'Show New Study link on Patients Page' and 'Allowed to create"
			+ " studies' permssion.")
	public void testHappyDay68395() throws Exception {

		gstrTCID = "68395";
		gstrTO = "Verify that the link 'New Study' is displayed in View Patients page when the user "
				+ "has permission 'Show New Study link on Patients Page' and 'Allowed to create studies' permssion.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
		User_data objUser_data = new User_data();

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
				.selectShowNewStudyLinkOnPatientPageCheckBox();

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
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.verNewStudyLinkIsDisplayed().clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that when the license expires the new license once used cannot be reused.     
    'Precondition  :
    'Date          : 12-Jul-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that when the license expires the new license once used cannot be reused.")
	public void testHappyDay83579() throws Exception {

		gstrTCID = "83579";
		gstrTO = "Verify that when the license expires the new license once used cannot be reused.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileUploadPath = pathProps
				.getProperty(objPathData.strLicenseTextFile);
		String fileUploadPath1 = System.getProperty("user.dir")
				+ fileUploadPath;

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.verNewStudyLinkIsDisplayed().clickOnUpdateLicense();
		String actual = objViewPatients.getDaysLeftCount();
		StringBuilder req = objFileFormatConverter
				.getTextFromTextFile(fileUploadPath1);
		objViewPatients.enterTextInEnterNewLicenseField(req.toString());
		objDestinations.clickOnSaveChanges();
		Thread.sleep(5000);
		objViewPatients.verLicenseErrorMsg();
		String actual1 = objViewPatients.getDaysLeftCount();
		assertTrue(actual.equals(actual1));

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that selected studies reports are downloaded in the zip format 
	                   when clicked on "Click here to download selected studies reports" icon.     
	  'Precondition  :
	  'Date          : 01-Sep-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that selected studies reports are downloaded in the zip format when"
			+ "clicked on Click here to download selected studies reports icon.")
	public void testHappyDay153210() throws Exception {

		gstrTCID = "153210";
		gstrTO = "Verify that selected studies reports are downloaded in the zip format when clicked "
				+ "on Click here to download selected studies reports icon.";

		Login_data objLogin_data = new Login_data();
		Date_Time_settings objDts = new Date_Time_settings();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		String strTimeText = objDts.getCurrentDate(objPathData.dateFormat1);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileCreateStudyAutoITPath = pathProps
				.getProperty(objPathData.autoItFilePath2);
		System.out.println(fileCreateStudyAutoITPath);

		File fileCreateStudyAutoITPath1 = new File(
				System.getProperty("user.dir") + fileCreateStudyAutoITPath);
		String strAutoitPath = fileCreateStudyAutoITPath1.toString();
		System.out.println(strAutoitPath + 1);

		// image
		String imagePath = pathProps.getProperty(objPathData.sudyWithImage);
		System.out.println(imagePath);

		File imageFile = new File(System.getProperty("user.dir") + imagePath);
		String strImagePath = imageFile.toString();

		// backup file
		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + strTimeText;
		System.out.println(backupfiledownloadpath1);

		String autoit = pathProps.getProperty(objPathData.strAutoITPath);
		File autoitfile = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile.toString();
		objHome.launchApplication(objLogin_data.strAppURL);
		driver.switchTo().defaultContent();
		objHome.verHomePage().clickOnViewPatients();
		driver.switchTo().defaultContent();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		String[] studs = { objViewPatients_data.strStudy0,
				objViewPatients_data.strStudy1, objViewPatients_data.strStudy2,
				objViewPatients_data.strStudy3, objViewPatients_data.strStudy4 };
		for (int i = 0; i < studs.length; i++) {
			objViewPatients.clickOnNewStudy();
			Thread.sleep(4000);
			objAutoIT.CreateStudy(strAutoitPath, studs[i], studs[i],
					strImagePath, objViewPatients_data.strModalityDS);
			Thread.sleep(5000);
			objViewPatients.selInLastOption(objDICOMSettings_data.hour)
					.enterTextInFind(studs[i]).clickOnSearch1();
			objViewPatients.clickOnViewModifyWebReportsOfAStudy(studs[i]);
			String mw = driver.getWindowHandle();
			Set<String> aw = driver.getWindowHandles();
			Iterator<String> itr = aw.iterator();
			while (itr.hasNext()) {
				String cw = itr.next().toString();
				if (!cw.contains(mw)) {
					driver.switchTo().window(cw);
					objViewPatients.clickOnAddButton();
					Set<String> aw1 = driver.getWindowHandles();
					Iterator<String> itr1 = aw1.iterator();
					while (itr1.hasNext()) {
						String cw1 = itr1.next().toString();
						if ((!cw1.contains(mw)) && (!cw1.contains(cw))) {
							driver.switchTo().window(cw1);
							objViewPatients.clickOnSaveReport();
						}
					}
					driver.switchTo().window(cw);
					driver.close();
				}
			}
			driver.switchTo().window(mw);
			objViewPatients.clickOnSearch().clickOnSearch();
		}
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy0.substring(15))
				.clickOnSearch().clickOnSearch();
		objViewPatients.selSelectAllStudyCheckbox();
		objViewPatients.clickOnClickHereToDownloadSelectedStudiesReportsIcon();
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr = aw.iterator();
		while (itr.hasNext()) {
			String cw = itr.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				//driver.manage().window().maximize();
				objViewPatients.clickOnDownloadReportsAsZipFileButton();
				Thread.sleep(5000);
				objAutoIT.DownloadTheReports1(autoitfilepath,
						backupfiledownloadpath1, "Marr.exe");
				Thread.sleep(10000);
			}
		}
		driver.close();
		driver.switchTo().window(mw);
		objViewPatients.clickOnSearch().clickOnSearch();
		objCommonFunctions.verDownloadedFile(backupfiledownloadpath1 + ".zip");
		objViewPatients.clickOnLogout();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that the Viewer can be downloaded and saved to the Local System.     
	  'Precondition  :
	  'Date          : 29-Sep-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that the Viewer can be downloaded and saved to the Local System.")
	public void testHappyDay68406() throws Exception {

		gstrTCID = "68406";
		gstrTO = "Verify that the Viewer can be downloaded and saved to the Local System.";

		Login_data objLogin_data = new Login_data();
		Date_Time_settings objDts = new Date_Time_settings();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		String strTimeText = objDts.getCurrentDate(objPathData.dateFormat1);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		// backup file1
		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + strTimeText + ".exe";
		System.out.println(backupfiledownloadpath1);

		// backup file2
		String backupfilepath1 = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile1 = new File(System.getProperty("user.dir")
				+ backupfilepath1);
		String backupfiledownloadpath11 = backfile1 + "\\" + strTimeText
				+ "1.exe";
		System.out.println(backupfiledownloadpath11);

		String autoit = pathProps.getProperty(objPathData.strAutoITPath);
		File autoitfile = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
		driver.switchTo().defaultContent();
		objHome.verHomePage().clickOnViewPatients();
		driver.switchTo().defaultContent();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objViewPatients.clickOnGetLatestPlugins()
				.clickOnDownloadLinkOfRequiredSoftware(
						objViewPatients_data.strSoftwareMAV);
		if((objCommonFunctions.getBrowserName()).equals("internet explorer")){
		Thread.sleep(3000);
		objAutoIT.DownloadTheReports1(autoitfilepath, backupfiledownloadpath1,
				"autoit.exe");
		}
		objViewPatients
				.clickOnDownloadLinkOfRequiredSoftware(objViewPatients_data.strSoftwareMTV);
		if((objCommonFunctions.getBrowserName()).equals("internet explorer")){
		Thread.sleep(3000);
		objAutoIT.DownloadTheReports1(autoitfilepath, backupfiledownloadpath11,
				"autoit.exe");
		}
		Thread.sleep(8000);
		objCommonFunctions.verDownloadedFile(backupfiledownloadpath1);
		objCommonFunctions.verDownloadedFile(backupfiledownloadpath11);
		objViewPatients.clickOnLogout();
		
		gstrResult = "PASS";
	}
	
}
