package rh6CommercialServer.requirementGroup.smokeSuit.AddendumReports;

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
import page.Groups;
import page.Home;
import page.Login;
import page.MailVerificationFunctions;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayCreatingAddendumReports extends TestNG_UI_EXTENSIONSForOneBrowser{
	public  HappyDayCreatingAddendumReports() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that “Allowed to add addendum” group permission is enabled by default 
                     to the pre defined group "Radiologist" and "Add Addendum" icon is displayed in
                     Web-reports page only for the signed reports for the User belonging to this group.     
    'Precondition  :
    'Date          : 20-Sep-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that “Allowed to add addendum” group permission is enabled by default to"
			+ " the pre defined group Radiologist and Add Addendum icon is displayed in Web-reports page "
			+ "only for the signed reports for the User belonging to this group.")
	public void testHappyDay158046() throws Exception {

		gstrTCID = "158046";
		gstrTO = "Verify that “Allowed to add addendum” group permission is enabled by default to the "
				+ "pre defined group Radiologist and Add Addendum icon is displayed in Web-reports page only"
				+ " for the signed reports for the User belonging to this group.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Groups objGroups = new Groups(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		// autoIT CreateStudy File Path
		String autoItCreateStudy = pathProps
				.getProperty(objPathData.autoItFilePath2);
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
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		this.driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objHome.clickOnGroups1();
		objGroups.verGroupsPage()
				.clickOnViewGroupIcon(objUser_data.radioLogist)
				.verAllowedToAddAddendumsChkbxSelected();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		Thread.sleep(3000);
		System.out.println(objUser_data.strNewUserName);

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
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();
		objViewPatients.clickOnLogout();
		Thread.sleep(5000);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		Thread.sleep(3000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.selStatusOption(objViewPatients_data.ststusAny)
				.clickOnSearch();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);
		String dtousr = "";

		String mainwindowhandle = driver.getWindowHandle();
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> ite = windowhandles.iterator();
		while (ite.hasNext()) {
			String childwindow = ite.next().toString();
			if (!childwindow.contains(mainwindowhandle)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				Thread.sleep(3000);
				objViewPatients.verWebReporterPage("Web-Reporter")
						.clickOnAddButton();
				Set<String> allwindows = driver.getWindowHandles();
				Iterator<String> ite1 = allwindows.iterator();
				while (ite1.hasNext()) {
					String childwindow1 = ite1.next().toString();
					if ((!childwindow1.contains(childwindow))
							&& (!childwindow1.contains(mainwindowhandle))) {
						driver.switchTo().window(childwindow1);
						objViewPatients.clickOnSaveReport();
						Thread.sleep(5000);

					}
				}

				driver.switchTo().window(childwindow);
				objViewPatients.clickOnAddButton();
				Set<String> allwindows1 = driver.getWindowHandles();
				Iterator<String> ite11 = allwindows1.iterator();
				while (ite11.hasNext()) {
					String childwindow11 = ite11.next().toString();
					if ((!childwindow11.contains(mainwindowhandle))
							&& (!childwindow11.contains(childwindow))) {
						driver.switchTo().window(childwindow11);
						objViewPatients.clickOnSaveSignReport()
								.clickOnSignReport();

					}
				}
				driver.switchTo().window(childwindow);
				dtousr = objViewPatients.getDateTimeOfUnSignedReport();
				objViewPatients.verSignedReport()
						.verSavedReportIsDisplayed1(dtousr)
						.verAddendumIconNotDisplayingForSavedReport(dtousr)
						.verAddendumIconOfSignedReport();
				driver.close();
			}
		}
		driver.switchTo().window(mainwindowhandle);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that Addendum reports can be removed by clicking on "remove" link
                     only by Administrator.     
    'Precondition  :
    'Date          : 28-Sep-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Addendum reports can be removed by clicking on remove link "
			+ "only by Administrator.")
	public void testHappyDay168532() throws Exception {

		gstrTCID = "168532";
		gstrTO = "Verify that Addendum reports can be removed by clicking on remove link only by Administrator.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		// autoIT CreateStudy File Path
		String autoItCreateStudy = pathProps
				.getProperty(objPathData.autoItFilePath2);
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
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		this.driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		Thread.sleep(3000);
		System.out.println(objUser_data.strNewUserName);
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
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);
		String mainwindowhandle = driver.getWindowHandle();
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> ite = windowhandles.iterator();
		while (ite.hasNext()) {
			String childwindow = ite.next().toString();
			if (!childwindow.contains(mainwindowhandle)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				Thread.sleep(2000);
				objViewPatients.verWebReporterPage("Web-Reporter")
						.clickOnAddButton();
				Set<String> allwindows = driver.getWindowHandles();
				Iterator<String> ite1 = allwindows.iterator();
				while (ite1.hasNext()) {
					String childwindow1 = ite1.next().toString();
					if ((!childwindow1.contains(childwindow))
							&& (!childwindow1.contains(mainwindowhandle))) {
						driver.switchTo().window(childwindow1);
						objViewPatients.clickOnSaveSignReport()
								.clickOnSignReport();
						Thread.sleep(5000);

					}
				}

				driver.switchTo().window(childwindow);
				objViewPatients.clickOnNewAddEndumIcon();
				Set<String> allwindows1 = driver.getWindowHandles();
				Iterator<String> ite11 = allwindows1.iterator();
				while (ite11.hasNext()) {
					String childwindow11 = ite11.next().toString();
					if ((!childwindow11.contains(mainwindowhandle))
							&& (!childwindow11.contains(childwindow))) {
						driver.switchTo().window(childwindow11);
						objViewPatients
								.enterTextInReferringPhysicianFieldInAddendumReportEditorPage(
										objViewPatients_data.strRefPhyConstant)
								.clickOnSaveAndSignAddendum()
								.clickOnSignReport();

					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindowhandle);
		objViewPatients.clickOnLogout();
		Thread.sleep(5000);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		Thread.sleep(3000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.selStatusOption(objViewPatients_data.ststusAny)
				.clickOnSearch();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudyContainsSignedReport(objViewPatients_data.strStudy);

		String mainwindowhandle1 = driver.getWindowHandle();
		Set<String> windowhandles1 = driver.getWindowHandles();
		Iterator<String> ite1 = windowhandles1.iterator();
		while (ite1.hasNext()) {
			String childwindow = ite1.next().toString();
			if (!childwindow.contains(mainwindowhandle1)) {
				driver.switchTo().window(childwindow);
				objViewPatients.verRemoveLinkOfAddendumReportIsNotDisplayed();
				driver.close();
			}
		}
		driver.switchTo().window(mainwindowhandle1);
		objViewPatients.clickOnLogout();

		Thread.sleep(5000);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.selStatusOption(objViewPatients_data.ststusAny)
				.clickOnSearch();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudyContainsSignedReport(objViewPatients_data.strStudy);

		String mainwindowhandle11 = driver.getWindowHandle();
		Set<String> windowhandles11 = driver.getWindowHandles();
		Iterator<String> ite11 = windowhandles11.iterator();
		while (ite11.hasNext()) {
			String childwindow = ite11.next().toString();
			if (!childwindow.contains(mainwindowhandle11)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.verRemoveLinkOfAddendumReportIsDisplayed()
						.clickOnRemoveAddendum();
				objUserManagement.clickOnOkInAlertPopUp();
				Thread.sleep(5000);
				objViewPatients.verRemoveLinkOfAddendumReportIsNotDisplayed();
				driver.close();
			}
		}
		driver.switchTo().window(mainwindowhandle11);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
	  'Description   : Verify that Signed Addendum Report can be send to another recipient 
	                   by specifying the email address in "Send To" field.     
	  'Precondition  :
	  'Date          : 05-Oct-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Signed Addendum Report can be send to another recipient "
			+ "by specifying the email address in Send To field.")
	public void testHappyDay168530() throws Exception {

		gstrTCID = "168530";
		gstrTO = "Verify that Signed Addendum Report can be send to another recipient by specifying"
				+ " the email address in Send To field.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
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
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver);
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
				.selectAllowedToAddAddendumsCheckBox();

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
		objLogin.loginAsUser(
		/* objUser_data.strNewUserName */objLogin_data.strAdminUser,
		/* objUser_data.strNewPassword */objLogin_data.strAdminUserPwd)
				.clickLogin();
		Thread.sleep(3000);
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		System.out.println(objViewPatients_data.strStudy);

		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);
		String mainwindowhandle = driver.getWindowHandle();
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> ite = windowhandles.iterator();
		while (ite.hasNext()) {
			String childwindow = ite.next().toString();
			if (!childwindow.contains(mainwindowhandle)) {
				driver.switchTo().window(childwindow);

				objViewPatients.verWebReporterPage("Web-Reporter")
						.clickOnAddButton();
				Set<String> allwindows = driver.getWindowHandles();
				Iterator<String> ite1 = allwindows.iterator();
				while (ite1.hasNext()) {
					String childwindow1 = ite1.next().toString();
					if ((!childwindow1.contains(childwindow))
							&& (!childwindow1.contains(mainwindowhandle))) {
						driver.switchTo().window(childwindow1);
						objViewPatients.clickOnSaveSignReport()
								.clickOnSignReport();
						Thread.sleep(5000);

					}
				}

				driver.switchTo().window(childwindow);
				objViewPatients.clickOnNewAddEndumIcon();
				Set<String> allwindows1 = driver.getWindowHandles();
				Iterator<String> ite11 = allwindows1.iterator();
				while (ite11.hasNext()) {
					String childwindow11 = ite11.next().toString();
					if ((!childwindow11.contains(mainwindowhandle))
							&& (!childwindow11.contains(childwindow))) {
						driver.switchTo().window(childwindow11);
						objViewPatients
								.enterTextInReferringPhysicianFieldInAddendumReportEditorPage(
										objViewPatients_data.strRefPhyConstant)
								.enterTextInSendToFieldInEditReportPage(
										objViewPatients_data.strUN)
								.clickOnSaveAndSignAddendum();
						Thread.sleep(5000);
						objViewPatients.clickOnSignReport();

					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindowhandle);
		objViewPatients.clickOnSearch1().clickOnLogout();
		Thread.sleep(5000);
		objMailVerificationFunctions
				.loginToMail(objViewPatients_data.strUN,
						objViewPatients_data.strPWD)
				.navigateToInbox1(objViewPatients_data.strStudy)
				.verPdfFile(objViewPatients_data.strStudy)
				.clickOnMail(objViewPatients_data.strStudy,
						objViewPatients_data.strStudy + ".pdf")
				.clickOnMailLogout();

		gstrResult = "PASS";
	}

}
