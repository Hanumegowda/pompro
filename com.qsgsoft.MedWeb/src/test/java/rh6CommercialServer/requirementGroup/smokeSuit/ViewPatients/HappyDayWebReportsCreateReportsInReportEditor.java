package rh6CommercialServer.requirementGroup.smokeSuit.ViewPatients;

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
import page.Groups;
import page.Home;
import page.Login;
import page.UserManagement;
import page.ViewPatients;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayWebReportsCreateReportsInReportEditor extends TestNG_UI_EXTENSIONSForOneBrowser {
	public HappyDayWebReportsCreateReportsInReportEditor() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that a user with permission 'Attach documents to reports' is allowed
                     to upload attachments to reports in Web reporter page.     
    'Precondition  :
    'Date          : 11-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a user with permission 'Attach documents to reports' is allowed"
			+ " to upload attachments to reports in Web reporter page.")
	public void testHappyDay68553() throws Exception {

		gstrTCID = "68553";
		gstrTO = "Verify that a user with permission 'Attach documents to reports' is allowed to upload"
				+ " attachments to reports in Web reporter page.";

		Login_data objLogin_data = new Login_data();
		Groups_data objGroups_data = new Groups_data();
		PathData objPathData = new PathData();
		User_data objUser_data = new User_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
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
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileUploadPath = pathProps
				.getProperty(objPathData.strPdfFileUpload);

		File file = new File(System.getProperty("user.dir") + fileUploadPath);
		String strPath = file.toString();
		String a[] = strPath.split("\\\\");
		String b = a[(a.length) - 1];
		System.out.println(b);

		AutoIT objAutoIT = new AutoIT(this.driver);
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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objHome.clickOnGroups1();
		objGroups.clickOnAddGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectAllowedtoAccessServerCheckbox()
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedCreateNewStudiesCheckBox()
				.selectAttachDocumentsToReportsCheckBox()
				.selectAllowedToViewStudyReportsCheckBox();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut92();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		Thread.sleep(3000);
		objViewPatients.clickOnNewStudy();

		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);

		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();

		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);

		String mainwindowhandle = driver.getWindowHandle();
		System.out.println(mainwindowhandle);
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> ite = windowhandles.iterator();
		while (ite.hasNext()) {
			String childwindow = ite.next().toString();
			if (!childwindow.contains(mainwindowhandle)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.verWebReporterPage("Web-Reporter")
						.clickOnAttachDocumentIcon();
				Set<String> aw = driver.getWindowHandles();
				System.out.println(aw.size());
				Iterator<String> itr = aw.iterator();
				while (itr.hasNext()) {
					String cw = itr.next().toString();
					if ((!cw.contains(mainwindowhandle))
							&& (!cw.contains(childwindow))) {
						driver.switchTo().window(cw);
						driver.manage().window().maximize();
						objViewPatients.clickOnBrowseButton(strPath)
								.clickOnUploadButton1();
						Thread.sleep(5000);
					}

				}
				driver.switchTo().window(childwindow);
				driver.navigate().refresh();
				objViewPatients.verUploadedDocument(b);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindowhandle);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that a user with rights to add new reports is allowed to create reports
                     in 'Standard Report Editor'.     
    'Precondition  :
    'Date          : 12-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a user with rights to add new reports is allowed to create reports in "
			+ "'Standard Report Editor'.")
	public void testHappyDay68545() throws Exception {

		gstrTCID = "68545";
		gstrTO = "Verify that a user with rights to add new reports is allowed to create reports in 'Standard "
				+ "Report Editor'.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Groups_data objGroups_data = new Groups_data();
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
		AutoIT objAutoIT = new AutoIT(this.driver);
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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objHome.clickOnGroups1();
		objGroups.clickOnAddGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedtoAccessServerCheckbox()
				.selectAllowedToAddNewReportsCheckBox()
				.selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut92();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();

		Thread.sleep(3000);
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();

		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);

		String mainwindowhandle = driver.getWindowHandle();
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
				// driver.close();
				driver.switchTo().window(mainwindowHandle1);
				System.out.println(objUser_data.strNewUserName);
				objViewPatients.verWebReport(objUser_data.strNewUserName);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindowhandle);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the user with permission to 'Sign Reports' is allowed to Save
                     and Sign the reports in the Standard Report Editor.     
    'Precondition  :
    'Date          : 04-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the user with permission to 'Sign Reports' is allowed to "
			+ "Save and Sign the reports in the Standard Report Editor")
	public void testHappyDay68556() throws Exception {

		gstrTCID = "68556";
		gstrTO = "Verify that the user with permission to 'Sign Reports' is allowed to Save and Sign "
				+ "the reports in the Standard Report Editor.";

		Login_data objLogin_data = new Login_data();
		Groups_data objGroups_data = new Groups_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);

		AutoIT objAutoIT = new AutoIT(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objHome.clickOnGroups1();
		objGroups.clickOnAddGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectAllowedtoAccessServerCheckbox()
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedToViewStudyReportsCheckBox()
				.selectAllowedToSignReportsCheckBox()
				.selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut92();
		objHome.launchApplication(objLogin_data.strAppURL1);
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
				.selInLastOption(objDICOMSettings_data.hour).clickOnSearch1();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);

		String mainwindowhandle = driver.getWindowHandle();
		String childwindow;
		System.out.println(mainwindowhandle);
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> ite = windowhandles.iterator();
		while (ite.hasNext()) {
			childwindow = ite.next().toString();
			if (!childwindow.contains(mainwindowhandle)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
			}
		}

		objViewPatients.verWebReporterPage("Web-Reporter").clickOnAddButton();
		String mainwindowHandle1 = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> ite1 = allwindows.iterator();
		while (ite1.hasNext()) {
			String childwindow1 = ite1.next().toString();
			if ((!childwindow1.contains(mainwindowHandle1))
					&& (!childwindow1.contains(mainwindowhandle))) {
				driver.switchTo().window(childwindow1);
				objViewPatients.clickOnSaveSignReport();
				Thread.sleep(5000);
				objViewPatients.clickOnSignReport();
				driver.switchTo().window(mainwindowHandle1);
				driver.navigate().refresh();
				objViewPatients.verSignedByWebReport();

			}
		}
		driver.close();
		driver.switchTo().window(mainwindowhandle);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that files can be attached using 'Attach Education file' icon in Report editor.     
    'Precondition  :
    'Date          : 04-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that files can be attached using 'Attach Education file' icon in Report editor.")
	public void testHappyDay68564() throws Exception {

		gstrTCID = "68564";
		gstrTO = "Verify that files can be attached using 'Attach Education file' icon in Report editor.";

		Login_data objLogin_data = new Login_data();
		Groups_data objGroups_data = new Groups_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		User_data objUser_data = new User_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		String strTimeText = objDts.getCurrentDate(objPathData.dateFormat1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileUploadPath = pathProps
				.getProperty(objPathData.strPdfFileUpload);

		File file = new File(System.getProperty("user.dir") + fileUploadPath);
		String strPath = file.toString();
		String a[] = strPath.split("\\\\");
		String b = a[(a.length) - 1];
		System.out.println(b);

		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + strTimeText + ".pdf";
		String backupfiledownloadpath2 = backfile + "\\" + strTimeText + ".doc";
		String backupfiledownloadpath3 = backfile + "\\" + strTimeText
				+ ".docx";
		String backupfiledownloadpath4 = backfile + "\\" + strTimeText + ".xls";
		String backupfiledownloadpath5 = backfile + "\\" + strTimeText
				+ ".xlsx";
		System.out.println(backupfiledownloadpath1);

		// doc file

		String fileUploadPath1 = pathProps
				.getProperty(objPathData.strDocFileUpload);

		File file1 = new File(System.getProperty("user.dir") + fileUploadPath1);
		String strPath1 = file1.toString();
		String a1[] = strPath1.split("\\\\");
		String b1 = a1[(a1.length) - 1];
		System.out.println(b1);

		// docx file

		String fileUploadPath2 = pathProps
				.getProperty(objPathData.strDocxFileUpload);

		File file2 = new File(System.getProperty("user.dir") + fileUploadPath2);
		String strPath2 = file2.toString();
		String a2[] = strPath2.split("\\\\");
		String b2 = a2[(a2.length) - 1];
		System.out.println(b2);

		// xls file

		String fileUploadPath3 = pathProps
				.getProperty(objPathData.strXlsFileUpload);

		File file3 = new File(System.getProperty("user.dir") + fileUploadPath3);
		String strPath3 = file3.toString();
		String a3[] = strPath3.split("\\\\");
		String b3 = a3[(a3.length) - 1];
		System.out.println(b3);

		// xlsx file

		String fileUploadPath4 = pathProps
				.getProperty(objPathData.strXlsxFileUpload);

		File file4 = new File(System.getProperty("user.dir") + fileUploadPath4);
		String strPath4 = file4.toString();
		String a4[] = strPath4.split("\\\\");
		String b4 = a4[(a4.length) - 1];
		System.out.println(b4);

		String autoit = pathProps.getProperty(objPathData.strAutoITPath);
		File autoitfile = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile.toString();

		// autoIT CreateStudy File Path
		String autoItCreateStudy = pathProps
				.getProperty(objPathData.autoItFilePath2);
		System.out.println(autoItCreateStudy);

		File autoitfile1 = new File(System.getProperty("user.dir")
				+ autoItCreateStudy);
		String strAutoitPath = autoitfile1.toString();
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
		objGroups.clickOnAddGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectAllowedtoAccessServerCheckbox()
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedToAddNewReportsCheckBox()
				.selectAttachDocumentsToReportsCheckBox();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut92();
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
				.selInLastOption(objDICOMSettings_data.hour).clickOnSearch1();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);
		String[] files = { strPath, strPath1, strPath2, strPath3, strPath4 };
		String[] ft = { b, b1, b2, b3, b4 };
		String[] bp = { backupfiledownloadpath1, backupfiledownloadpath2,
				backupfiledownloadpath3, backupfiledownloadpath4,
				backupfiledownloadpath5 };

		String mainwindowhandle = driver.getWindowHandle();
		Set<String> aw1 = driver.getWindowHandles();
		Iterator<String> i1 = aw1.iterator();
		while (i1.hasNext()) {
			String ch1 = i1.next().toString();
			if (!(ch1.equals(mainwindowhandle))) {
				driver.switchTo().window(ch1);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.verWebReporterPage("Web-Reporter")
						.clickOnAddButton();
				Set<String> aw2 = driver.getWindowHandles();
				Iterator<String> i2 = aw2.iterator();
				while (i2.hasNext()) {
					String ch2 = i2.next().toString();
					if ((!ch2.contains(mainwindowhandle))
							&& (!ch2.contains(ch1))) {
						driver.switchTo().window(ch2);
						driver.manage().window().maximize();
						for (int i = 0; i < files.length; i++) {
							objViewPatients.clickOnAttachmentInEditReportPage();
							Thread.sleep(3000);
							Set<String> aw3 = driver.getWindowHandles();
							Iterator<String> i3 = aw3.iterator();
							while (i3.hasNext()) {
								String ch3 = i3.next().toString();
								if ((!ch3.contains(mainwindowhandle))
										&& (!ch3.contains(ch1))
										&& (!ch3.contains(ch2))) {
									driver.switchTo().window(ch3);
									objViewPatients.clickOnBrowse(files[i])
											.clickOnUploadButton1();
									Thread.sleep(3000);
									driver.switchTo().window(ch2);
								}
							}
						}
						objViewPatients.clickOnSaveReport();
					}
				}
				driver.switchTo().window(ch1);
				for (int i = 0; i < ft.length; i++) {
					objViewPatients.verAttachedFile(ft[i]).clickOnAttachedFile(
							ft[i]);
					Thread.sleep(5000);
					objAutoIT.DownloadTheReports1(autoitfilepath, bp[i],
							"Marr.exe");
					Thread.sleep(10000);
				}

				driver.close();

			}
		}
		driver.switchTo().window(mainwindowhandle);
		for (int i = 0; i < bp.length; i++) {
			objCommonFunctions.verDownloadedFile(bp[i]);
		}
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the replies posted to the reports in web reporter page are 
                     displayed in the report list of web reporter page.     
    'Precondition  :
    'Date          : 29-Aug-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the replies posted to the reports in web reporter page are "
			+ "displayed in the report list of web reporter page.")
	public void testHappyDay68554() throws Exception {

		gstrTCID = "68554";
		gstrTO = "Verify that the replies posted to the reports in web reporter page are displayed in"
				+ " the report list of web reporter page.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Groups_data objGroups_data = new Groups_data();
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
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);

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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		this.driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objHome.clickOnGroups1();
		objGroups.clickOnAddGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedtoAccessServerCheckbox()
				.selectAllowedToAddNewReportsCheckBox()
				.selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox()
				.selectAllowedToViewStudyReportsCheckBox()
				.selectAllowedToAddRepliesCheckBox();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut92();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();

		Thread.sleep(3000);
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(5000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();

		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);

		String mainwindowhandle = driver.getWindowHandle();
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
				// driver.close();
				driver.switchTo().window(mainwindowHandle1);
				objViewPatients.clickOnPostReplyIcon();
				Set<String> aw = driver.getWindowHandles();
				Iterator<String> itr = aw.iterator();
				while (itr.hasNext()) {
					String cw = itr.next().toString();
					if ((!cw.contains(mainwindowhandle))
							&& (!cw.contains(mainwindowHandle1))) {
						driver.switchTo().window(cw);
						driver.manage().window().maximize();
						objViewPatients.enterTextInPostReplyPage(
								objViewPatients_data.strPostReplyText)
								.clickOnSaveReport();
					}
				}
				driver.switchTo().window(mainwindowHandle1);
				objViewPatients.clickOnPostReplyNoteLink();
				Set<String> aw1 = driver.getWindowHandles();
				Iterator<String> itr1 = aw1.iterator();
				while (itr1.hasNext()) {
					String cw = itr1.next().toString();
					if ((!cw.contains(mainwindowhandle))
							&& (!cw.contains(mainwindowHandle1))) {
						driver.switchTo().window(cw);
						driver.manage().window().maximize();
						objViewPatients
								.verPostReplyTextIsDisplayed(objViewPatients_data.strPostReplyText);
						driver.close();
					}
				}

				driver.switchTo().window(mainwindowHandle1);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindowhandle);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
	  'Description   : Verify that the clinic header selected in 'Select Clinic header' dropdown
	                   box is inserted into the report.     
	  'Precondition  :
	  'Date          : 02-Sep-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the clinic header selected in 'Select Clinic header' dropdown "
			+ "box is inserted into the report.")
	public void testHappyDay68617() throws Exception {

		gstrTCID = "68617";
		gstrTO = "Verify that the clinic header selected in 'Select Clinic header' dropdown box is "
				+ "inserted into the report.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Date_Time_settings objDts = new Date_Time_settings();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Login objLogin = new Login(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		String strTimeText = objDts.getCurrentDate(objPathData.dateFormat1);

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

		// logo image
		String logoimagePath = pathProps
				.getProperty(objPathData.strLogoImageJpegFile);
		System.out.println(logoimagePath);

		File logoimageFile = new File(System.getProperty("user.dir")
				+ logoimagePath);
		String strLogoImagePath = logoimageFile.toString();

		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + strTimeText;
		System.out.println(backupfiledownloadpath1);

		String autoit = pathProps.getProperty(objPathData.strAutoITPath2);
		File autoitfile1 = new File(System.getProperty("user.dir") + autoit);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.selHTMLReportEditorCheckBox()
				.deSelExpressTranscriptionCheckBox();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();

		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnViewModifyWebReportsOfAStudy(
				objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.clickOnAddButton();
				Set<String> allwindows1 = driver.getWindowHandles();
				Iterator<String> itr1 = allwindows1.iterator();
				while (itr1.hasNext()) {
					String childwindow1 = itr1.next().toString();
					if ((!childwindow1.contains(mainwindow))
							&& (!childwindow1.contains(childwindow))) {
						driver.switchTo().window(childwindow1);
						objViewPatients.clickOnTemplateEditorIcon();
						Thread.sleep(10000);
						Set<String> allwindows2 = driver.getWindowHandles();
						Iterator<String> itr2 = allwindows2.iterator();
						while (itr2.hasNext()) {
							String childwindow2 = itr2.next().toString();
							if ((!childwindow2.contains(mainwindow))
									&& (!childwindow2.contains(childwindow))
									&& (!childwindow2.contains(childwindow1))) {
								driver.switchTo().window(childwindow2);
								objViewPatients
										.clickOnClearDocumentIcon()
										.enterTextInTemplateEditorPage(
												objViewPatients_data.strHeaderText)
										.clickOnAlignCenterIcon()
										.clickOnInsertImageIcon();
								Thread.sleep(5000);
								Set<String> aw = driver.getWindowHandles();
								System.out.println(aw.size() + " ayyoooo");
								Iterator<String> itr11 = aw.iterator();
								while (itr11.hasNext()) {
									String cw = itr11.next().toString();
									System.out.println(cw);
									if ((!cw.contains(mainwindow))
											&& (!cw.contains(childwindow))
											&& (!cw.contains(childwindow1))
											&& (!cw.contains(childwindow2))) {
										driver.switchTo().window(cw);
										driver.manage().window().maximize();
										objCommonFunctions.clickOnContinueToThisWebsiteLink();
										objViewPatients
												.clickOnBrowseButtonWhileInsertImage(
														strLogoImagePath)
												.clickOnInsertButton();
									}
								}
								driver.switchTo().window(childwindow2);
								objViewPatients.clickOnAlignCenterIcon();
								Thread.sleep(5000);
								objViewPatients.clickOnAddTemplateIcon();
								objUserManagement.clickOnOkInAlertPopUp();
								Thread.sleep(10000);
								Set<String> allwindows3 = driver
										.getWindowHandles();
								System.out.println(allwindows3.size()
										+ "total number of windows");
								Iterator<String> itr3 = allwindows3.iterator();
								while (itr3.hasNext()) {
									String childwindow3 = itr3.next()
											.toString();
									if ((!childwindow3.contains(mainwindow))
											&& (!childwindow3
													.contains(childwindow))
											&& (!childwindow3
													.contains(childwindow1))
											&& (!childwindow3
													.contains(childwindow2))) {
										driver.switchTo().window(childwindow3);
										driver.manage().window().maximize();
										Thread.sleep(5000);
										objViewPatients
												.enterTextInTemplateNameTextField(
														objViewPatients_data.strHeaderTemplate)
												.selTemplateType(
														objViewPatients_data.strTemplateType1)
												.selTemplatePackage(
														objViewPatients_data.strTemplatePackage)
												.selTemplateField(
														objViewPatients_data.strTemplateField)
												.enterTextInMatchTextField()
												.clickOnSaveChangesInAddTemplatePage()
												.clickOnSaveChangesInAddTemplatePage();
									}
								}

								driver.switchTo().window(childwindow2);
								objViewPatients
										.selTemplateFromDropdown1(objViewPatients_data.strHeaderTemplate);

								Thread.sleep(5000);
								driver.close();
							}
						}
						driver.switchTo().window(childwindow1);
						driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				objViewPatients.clickOnAddButton();
				Set<String> aw = driver.getWindowHandles();
				Iterator<String> itr11 = aw.iterator();
				while (itr11.hasNext()) {
					String cw = itr11.next().toString();
					if ((!cw.contains(mainwindow))
							&& (!cw.contains(childwindow))) {
						driver.switchTo().window(cw);
						objViewPatients.selHeaderTemplateOption(
								objViewPatients_data.strHeaderTemplate)
								.clickOnSaveReport();
					}
				}
				driver.switchTo().window(childwindow);
				objViewPatients.clickOnStudyInWebReporterPage();
				Set<String> aw1 = driver.getWindowHandles();
				Iterator<String> itr111 = aw1.iterator();
				while (itr111.hasNext()) {
					String cw = itr111.next().toString();
					if ((!cw.contains(mainwindow))
							&& (!cw.contains(childwindow))) {
						driver.switchTo().window(cw);
						driver.manage().window().maximize();
						objViewPatients.verClinicHeaderText(
								objViewPatients_data.strHeaderText)
								.verClinicHeaderLogo();
						driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
}
