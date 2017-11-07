package rh4CommercialServer.requirementGroup.smokeSuit.MedwebRadiologyStatistics;

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
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.Destinations;
import page.Home;
import page.Login;
import page.ModifyStudy;
import page.Statistics;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayReportsCreatedByMTFDoctorsAndDate extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayReportsCreatedByMTFDoctorsAndDate() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that statistics of reports created in Local Clinic are generated for 
                     a selected custom time period.     
    'Precondition  :
    'Date          : 12-May-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that statistics of reports created in Local Clinic are generated for"
			+ "a selected custom time period.")
	public void testHappyDay69326() throws Exception {

		gstrTCID = "69326";
		gstrTO = "Verify that statistics of reports created in Local Clinic are generated for a "
				+ "selected custom time period.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Groups_data objGroups_data = new Groups_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		ModifyStudy objModifyStudy = new ModifyStudy(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Statistics objStatistics = new Statistics(this.driver);

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
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.grouptypeAdmin)
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
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();

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
						objViewPatients.clickOnSaveReport();
						Thread.sleep(5000);

					}
				}
				driver.switchTo().window(mainwindowHandle1);
				System.out.println(objUser_data.strNewUserName);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindowhandle);
		objViewPatients
				.clickOnSearch()
				.clickOnSearch()
				.clickOnModifyStudyFieldsOfAStudy(objViewPatients_data.strStudy);
		Set<String> aw = driver.getWindowHandles();
		for (String a : aw) {
			driver.switchTo().window(a);

		}
		objModifyStudy.enterTextInMTF(objDICOMSettings_data.mtfcode1);
		objDestinations.clickOnSaveChanges();
		objModifyStudy.clickOnClose();
		driver.switchTo().window(mainwindowhandle);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics
				.clickOnReportsCreatedByMTFDoctorsAndDate()
				.selDoctor(objUser_data.strNewUserName)
				.clickOnNext()
				.selDoctor(objDICOMSettings_data.mtfcode1)
				.clickOnNext()
				.clickOnNext1()
				.verStudyReceivedByDifferentStatistics(
						objUser_data.strNewUserName, 0);

		gstrResult = "PASS";

	}

}
