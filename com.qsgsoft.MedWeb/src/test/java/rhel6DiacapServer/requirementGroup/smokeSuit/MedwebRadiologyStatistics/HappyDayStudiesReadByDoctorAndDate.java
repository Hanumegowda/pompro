package rhel6DiacapServer.requirementGroup.smokeSuit.MedwebRadiologyStatistics;

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
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.Groups;
import page.Home;
import page.Login;
import page.Statistics;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayStudiesReadByDoctorAndDate extends
		TestNG_UI_EXTENSIONSForOneBrowser {
	public HappyDayStudiesReadByDoctorAndDate() throws Exception {
		super();

	}

    /*************************************************************************************
    'Description   : Verify that statistics of studies read by doctor and date for the selected 
                     doctors is displayed for the current date when 'Today' is selected in Time Period.     
    'Precondition  :
    'Date          : 28-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
    **************************************************************************************/
	@Test(description = "Verify that statistics of studies read by doctor and date for the selected "
			+ "doctors is displayed for the current date when 'Today' is selected in Time Period.")
	public void testHappyDay167321() throws Exception {

		gstrTCID = "167321";
		gstrTO = "Verify that statistics of studies read by doctor and date for the selected doctors"
				+ " is displayed for the current date when 'Today' is selected in Time Period.";

		Login_data objLogin_data = new Login_data();
		Groups_data objGroups_data = new Groups_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Statistics objStatistics = new Statistics(this.driver);
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
				.clickOnCopy().selectAllowedToViewStudyReportsCheckBox()
				.selectAllowedToSignReportsCheckBox()
				.selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox();
		objAddUser.clickOnSaveChanges();
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
						objViewPatients.clickOnSaveSignReport();
						Thread.sleep(5000);
						objViewPatients.clickOnSignReport();
						driver.switchTo().window(mainwindowHandle1);
						driver.navigate().refresh();
						objViewPatients.verSignedByWebReport();

					}
				}
				driver.close();
			}
		}
		Thread.sleep(3000);
		driver.switchTo().window(mainwindowhandle);
		objViewPatients.selStatusOption(objViewPatients_data.ststusAny)
				.clickOnSearch().clickOnSearch().clickOnSearch();
		Thread.sleep(3000);
				objViewPatients.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnStatistics();
		Thread.sleep(2000);
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics
				.clickOnRadiology()
				.clickOnStudiesReadByDoctorAndDate()
				.selDoctor(objUser_data.strNewUserName)
				.clickOnNext()
				.clickOnToday()
				.clickOnNext1()
				.verStudyReceivedByDifferentStatistics(
						objUser_data.strNewUserName, 0);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

}
