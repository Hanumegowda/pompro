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
import page.Destinations;
import page.Groups;
import page.Home;
import page.Login;
import page.ModifyStudy;
import page.UserManagement;
import page.ViewPatients;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayImageManagementToolsManageStudiesFields extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayImageManagementToolsManageStudiesFields() throws Exception{
		super();
	}
	
	 /*************************************************************************************
	  'Description   : Verify that deleted studies are removed from View Patients page.     
	  'Precondition  :
	  'Date          : 28-Sep-2015
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that deleted studies are removed from View Patients page.")
	public void testHappyDay68486() throws Exception {

		gstrTCID = "68486";
		gstrTO = "Verify that deleted studies are removed from View Patients page.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
		User_data objUser_data = new User_data();
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
		objHome.clickOnGroups1();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox();

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
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();
		objViewPatients.delAPerticularStudy(objViewPatients_data.strStudy);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch()
				.verNoStudiesAvailableErrorMessage();
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that status of a study is changed to 'Unread' when the 'Read/Unread' checkbox is disabled.     
    'Precondition  :
    'Date          : 09-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that status of a study is changed to 'Unread' when the 'Read/Unread' checkbox is disabled.")
	public void testHappyDay68501() throws Exception {

		gstrTCID = "68501";
		gstrTO = "Verify that status of a study is changed to 'Unread' when the 'Read/Unread' checkbox is disabled.";

		Login_data objLogin_data = new Login_data();
		Groups_data objGroups_data = new Groups_data();
		User_data objUser_data = new User_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
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
				.clickOnCopy()
				.selectAllowedToChangeReadUnreadStatusOfStudyCheckBox();
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
				.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch1();
		objViewPatients.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.selLayout(objViewPatients_data.strLayout)
				.enterTextInFind(objViewPatients_data.strStudy).clickOnSearch()
				.selMarkStudyAsReadCheckbox(objViewPatients_data.strStudy)
				.selStatusOption(objViewPatients_data.strStatus1)
				.selInLastOption(objDICOMSettings_data.hour).clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.selLayout(objViewPatients_data.strLayout)
				.deSelMarkStudyAsReadCheckbox(objViewPatients_data.strStudy)
				.selStatusOption(objViewPatients_data.strStatus2)
				.clickOnSearch().clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
	  'Description   : Verify that when reports are moved to a selected study Using 'merge Studies',
	                   the reports are added to the selected study and removed from the original studies.     
	  'Precondition  :
	  'Date          : 01-Dec-2015
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that when reports are moved to a selected study Using 'merge Studies', "
			+ "the reports are added to the selected study and removed from the original studies.")
	public void testHappyDay68524() throws Exception {

		gstrTCID = "68524";
		gstrTO = "Verify that when reports are moved to a selected study Using 'merge Studies', the reports "
				+ "are added to the selected study and removed from the original studies.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
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
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!mainwindow.contains(childwindow)) {
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
						objViewPatients.clickOnSaveReport();
						Thread.sleep(3000);
						// driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy);

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy2,
				objViewPatients_data.strStudy2, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);

		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy2);
		objViewPatients.clickOnSearch1();
		driver.switchTo().window(mainwindow);
		System.out.println(objViewPatients_data.strStudy);
		System.out.println(objViewPatients_data.strStudy2);
		String stu = (objViewPatients_data.strStudy2).substring(14);
		System.out.println(stu);
		objViewPatients.enterTextInFind(stu)
				.selInLastOption(objDICOMSettings_data.hour).clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.selStudy(objViewPatients_data.strStudy);
		objViewPatients.selStudy(objViewPatients_data.strStudy2);
		objViewPatients.clickOnMergeReportsIcon();
		String mw = driver.getWindowHandle();
		Set<String> allwindows3 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows3.iterator();
		while(itr1.hasNext()){
			String cw = itr1.next().toString();
			if(!cw.contains(mw)){
				driver.switchTo().window(cw);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
			}
		}
		objViewPatients
				.selStudyInMergeReportsPage(objViewPatients_data.strStudy2)
				.selMoveReportsRadioButtonInMergeReportsPage()
				.clickOnYesInMergeReportsPage()
				.clickOnCloseInMergeReportsPage();
		driver.switchTo().window(mw);
		objViewPatients
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnViewModifyWebReportsOfAStudy(
						objViewPatients_data.strStudy2);
		Set<String> allwindows4 = driver.getWindowHandles();
		Iterator<String> itr2 = allwindows4.iterator();
		while (itr2.hasNext()) {
			String str = itr2.next().toString();
			if (!(str.contains(mainwindow))) {
				driver.switchTo().window(str);
				driver.navigate().refresh();

				objViewPatients.verSavedReportIsDisplayed();
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows5 = driver.getWindowHandles();
		for (String all : allwindows5) {
			driver.switchTo().window(all);
		}
		objViewPatients.verSavedReportNotDisplayed();
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that when reports are copied to selected study using 'Merge Study' icon,
	                   the reports are added to the selected study and are not removed from the original studies.     
	  'Precondition  :
	  'Date          : 02-Dec-2015
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that when reports are copied to selected study using 'Merge Study' icon,"
			+ "the reports are added to the selected study and are not removed from the original studies.")
	public void testHappyDay90713() throws Exception {

		gstrTCID = "90713";
		gstrTO = "Verify that when reports are copied to selected study using 'Merge Study' icon, the reports "
				+ "are added to the selected study and are not removed from the original studies.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
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
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!mainwindow.contains(childwindow)) {
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
						objViewPatients.clickOnSaveReport();
						Thread.sleep(3000);
						// driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch();

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy2,
				objViewPatients_data.strStudy2, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy2);
		objViewPatients.clickOnSearch1();
		System.out.println(objViewPatients_data.strStudy);
		System.out.println(objViewPatients_data.strStudy2);
		String stu = (objViewPatients_data.strStudy2).substring(13);
		System.out.println(stu);
		objViewPatients.enterTextInFind(stu)
				.selInLastOption(objDICOMSettings_data.hour).clickOnSearch()
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.selStudy(objViewPatients_data.strStudy);
		objViewPatients.selStudy(objViewPatients_data.strStudy2);
		objViewPatients.clickOnMergeReportsIcon();
		String mw = driver.getWindowHandle();
		Set<String> allwindows3 = driver.getWindowHandles();
		Iterator<String> itr1 = allwindows3.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
			}
		}
		objViewPatients
				.selStudyInMergeReportsPage(objViewPatients_data.strStudy2)
				.selCopyReportsRadioButtonInMergeReportsPage()
				.clickOnYesInMergeReportsPage()
				.clickOnCloseInMergeReportsPage();
		driver.switchTo().window(mainwindow);
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy2);
		Set<String> allwindows4 = driver.getWindowHandles();
		for (String all : allwindows4) {
			driver.switchTo().window(all);
		}
		driver.manage().window().maximize();
		objViewPatients.verSavedReportIsDisplayed();
		driver.close();
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);
		Set<String> allwindows5 = driver.getWindowHandles();
		for (String all : allwindows5) {
			driver.switchTo().window(all);
		}
		objViewPatients.verSavedReportIsDisplayed();
		driver.close();
		driver.switchTo().window(mainwindow);

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that multiple studies can be deleted from 'View Patients' page.     
    'Precondition  :
    'Date          : 22-Aug-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that multiple studies can be deleted from 'View Patients' page.")
	public void testHappyDay68531() throws Exception {

		gstrTCID = "68531";
		gstrTO = "Verify that multiple studies can be deleted from 'View Patients' page.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
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
				.enterTextInFind((objViewPatients_data.strStudy).substring(14))
				.clickOnSearch1().selSelectAllStudyCheckbox();
		objViewPatients.delAllSelectedStudiesWithoutSecurityLink();
		for (int i = 0; i < studs.length; i++) {
			objViewPatients.enterTextInFind(studs[i]).clickOnSearch()
					.verNoStudiesAvailableErrorMessage();

		}
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
	  'Description   : Verify that the study fields can be modified using the 'Modify Study Field' icon.     
	  'Precondition  :
	  'Date          : 31-Aug-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that the study fields can be modified using the 'Modify Study Field' icon.")
	public void testHappyDay128903() throws Exception {

		gstrTCID = "128903";
		gstrTO = "Verify that the study fields can be modified using the 'Modify Study Field' icon.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		ModifyStudy objModifyStudy = new ModifyStudy(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
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
		this.driver.switchTo().defaultContent();
		objHome.verHomePage().clickOnViewPatients();
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
				.clickOnModifyStudyFieldsOfAStudy(objViewPatients_data.strStudy);
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr = aw.iterator();
		while (itr.hasNext()) {
			String cw = itr.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objModifyStudy
						.enterTextInPatientNameTextField(
								objViewPatients_data.strModifyStudy)
						.enterTextInPatientIDTextField(
								objViewPatients_data.strModPatientId)
						.enterTextInPatientSex(objViewPatients_data.strSex)
						.enterTextInAccessionNumber(
								objViewPatients_data.strModPatientId)
						.enterTextInStudyDateTextField(
								objViewPatients_data.strStudyDate)
						.enterTextInStudyTimeTextField(
								objViewPatients_data.strStudyTime)
						.enterTextInStudyDescription(
								objViewPatients_data.strDescription)
						.enterTextInBodyPartExamined(
								objViewPatients_data.strBodyPartExamined)
						.enterTextInProtocolName(
								objViewPatients_data.strProtocolName)
						.enterTextInDOBTextField(objViewPatients_data.dob)
						.enterTextInModalityTextField(
								objViewPatients_data.strModalityCT)
						.enterTextInInstitutionNameTextField(
								objViewPatients_data.strInstitutionName)
						.enterTextInReferringPhysicianName(
								objViewPatients_data.strRefPhy)
						.enterTextInReferringPhysicianAddress(
								objViewPatients_data.strRefPhyAddr)
						.enterTextInReferringPhysicianTelephoneNumber(
								objViewPatients_data.pid)
						.enterTextInCommentsTextField(
								objViewPatients_data.strComment)
						.enterTextInLocation(objViewPatients_data.strLocation)
						.enterTextInMTF(objViewPatients_data.strMtf);

				objDestinations.clickOnSaveChanges();
				objModifyStudy.clickOnClose();

			}
		}
		driver.switchTo().window(mw);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strModifyStudy)
				.clickOnSearch().clickOnSearch();
		objViewPatients
				.clickOnModifyStudyFieldsOfAStudy(objViewPatients_data.strModifyStudy);
		Set<String> aw1 = driver.getWindowHandles();
		Iterator<String> itr1 = aw1.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();
				objModifyStudy
						.verTextInPatientNameTextField(
								objViewPatients_data.strModifyStudy)
						.verTextInPatientIDTextField(
								objViewPatients_data.strModPatientId)
						.verTextInPatientSex(objViewPatients_data.strSex)
						.verTextInAccessionNumber(
								objViewPatients_data.strModPatientId)
						.verTextInStudyDateTextField(
								objViewPatients_data.strStudyDate)
						.verTextInStudyTimeTextField(
								objViewPatients_data.strStudyTime)
						.verTextInStudyDescription(
								objViewPatients_data.strDescription)
						.verTextInBodyPartExamined(
								objViewPatients_data.strBodyPartExamined)
						.verTextInProtocolName(
								objViewPatients_data.strProtocolName)
						.verTextInDOBTextField(objViewPatients_data.dob)
						.verTextInModalityTextField(
								objViewPatients_data.strModalityCT)
						.verTextInInstitutionNameTextField(
								objViewPatients_data.strInstitutionName)
						.verTextInReferringPhysicianName(
								objViewPatients_data.strRefPhy)
						.verTextInReferringPhysicianAddress(
								objViewPatients_data.strRefPhyAddr)
						.verTextInReferringPhysicianTelephoneNumber(
								objViewPatients_data.pid)
						.verTextInCommentsTextField(
								objViewPatients_data.strComment)
						.verTextInLocation(objViewPatients_data.strLocation)
						.verTextInMTF(objViewPatients_data.strMtf);
				driver.close();

			}
		}
		driver.switchTo().window(mw);
		objViewPatients.clickOnLogout();
		gstrResult = "PASS";
	}

}
