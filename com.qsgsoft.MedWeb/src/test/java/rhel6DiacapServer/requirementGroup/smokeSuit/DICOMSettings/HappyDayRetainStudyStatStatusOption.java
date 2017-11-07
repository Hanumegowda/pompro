package rhel6DiacapServer.requirementGroup.smokeSuit.DICOMSettings;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.ViewPatients_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.DICOMSetting;
import page.Home;
import page.Login;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayRetainStudyStatStatusOption extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayRetainStudyStatStatusOption() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that STAT status of the study is retained when study is marked as 
                     read for a STAT study after enabling "Retain Study STAT status" option in
                     Local Settings Page.     
    'Precondition  :
    'Date          : 03-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that STAT status of the study is retained when study is marked as read "
			+ "for a STAT study after enabling Retain Study STAT status option in Local Settings Page.")
	public void testHappyDay29961() throws Exception {

		gstrTCID = "29961";
		gstrTO = "Verify that STAT status of the study is retained when study is marked as read for a STAT "
				+ "study after enabling Retain Study STAT status option in Local Settings Page.";

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
		ViewPatients objViewPatients = new ViewPatients(this.driver);
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
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.selRetainStudySTATStatusCheckBox();
		objAddUser.clickOnSaveChanges();
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
				.selLayout(objViewPatients_data.strLayout)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnChangeStatStatusOfStudy();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> itr = allwindow.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.clickOnCloseLink();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients
				.selMarkStudyAsReadCheckbox(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().verStatStatus(objViewPatients_data.strStudy)
				.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that STAT status of the study is retained when signed report is 
                     added to the STAT study after enabling "Retain Study STAT status" option 
                     in Local Settings Page.     
    'Precondition  :
    'Date          : 20-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that STAT status of the study is retained when signed report is "
			+ "added to the STAT study after enabling Retain Study STAT status option in Local Settings Page.")
	public void testHappyDay29965() throws Exception {

		gstrTCID = "29965";
		gstrTO = "Verify that STAT status of the study is retained when signed report is added to the "
				+ "STAT study after enabling Retain Study STAT status option in Local Settings Page.";

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
		ViewPatients objViewPatients = new ViewPatients(this.driver);
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
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.selRetainStudySTATStatusCheckBox()
				.selHTMLReportEditorCheckBox()
				.deSelExpressTranscriptionCheckBox();
		objAddUser.clickOnSaveChanges();
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
				.selLayout(objViewPatients_data.strLayout)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnChangeStatStatusOfStudy();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> itr = allwindow.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.clickOnCloseLink();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr1 = aw.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!cw.contains(mainwindow)) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();
				objViewPatients.clickOnAddButton();
				Set<String> aw1 = driver.getWindowHandles();
				Iterator<String> itr2 = aw1.iterator();
				while (itr2.hasNext()) {
					String cw1 = itr2.next().toString();
					if ((!cw1.contains(mainwindow)) && (!cw1.contains(cw))) {
						driver.switchTo().window(cw1);
						driver.manage().window().maximize();
						objViewPatients.clickOnSaveSignReport()
								.clickOnSignReport();

					}
				}
				driver.switchTo().window(cw);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch()
				.verStatStatus(objViewPatients_data.strStudy).clickOnLogout();

		gstrResult = "PASS";
	}

}
