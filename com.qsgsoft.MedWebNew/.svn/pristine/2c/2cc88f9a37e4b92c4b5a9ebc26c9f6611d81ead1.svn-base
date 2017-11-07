package rh4CommercialServer.requirementGroup.smokeSuit.ViewPatients;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.ViewPatients_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.DICOMSetting;
import page.Home;
import page.Login;
import page.UserManagement;
import page.ViewPatients;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayWebReportsEditAndFormatTemplates extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayWebReportsEditAndFormatTemplates() throws Exception {
		super();
	}
	
	/*************************************************************************************
	  'Description   : Verify that the report template in .xml format can be uploaded to the 
	                   Template dropdown using "Upload Template" feature "Template Editor" page.     
	  'Precondition  :
	  'Date          : 08-Dec-2015
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the report template in .xml format can be uploaded to the "
			+ "Template dropdown using Upload Template feature Template Editor page.")
	public void testHappyDay68600() throws Exception {

		gstrTCID = "68600";
		gstrTO = "Verify that the report template in .xml format can be uploaded to the Template "
				+ "dropdown using Upload Template feature Template Editor page.";

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

		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + strTimeText;
		System.out.println(backupfiledownloadpath1);

		String autoit = pathProps.getProperty(objPathData.strAutoITPath2);
		File autoitfile1 = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile1.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
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
		objViewPatients
				.clickOnSearch1()
				.clickOnViewModifyWebReportsOfAStudy(
						objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.clickOnAddButton();
				Set<String> allwindows1 = driver.getWindowHandles();
				Iterator<String> itr1 = allwindows1.iterator();
				while (itr1.hasNext()) {
					String childwindow1 = itr1.next().toString();
					if ((!childwindow1.contains(mainwindow))
							&& (!childwindow1.contains(childwindow))) {
						driver.switchTo().window(childwindow1);
						objViewPatients.clickOnTemplateEditorIcon();
						Thread.sleep(5000);
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
												objViewPatients_data.strTempText)
										.clickOnAddTemplateIcon();
								objUserManagement.clickOnOkInAlertPopUp();
								Thread.sleep(5000);
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
														objViewPatients_data.strTemplate)
												.selTemplateType(
														objViewPatients_data.strTemplateType)
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
										.selTemplateFromDropdown1(
												objViewPatients_data.strTemplate)
										.verSelectedTemplateDisplayed(
												objViewPatients_data.strTempText)
										.clickOnDownloadTemplateIcon();
								Thread.sleep(10000);

								System.out.println(autoitfilepath + 1);
								System.out.println(backupfiledownloadpath1 + 2);
								Capabilities cap = ((RemoteWebDriver) this.driver)
										.getCapabilities();
								cap.getBrowserName();
								if (cap.getBrowserName().equalsIgnoreCase(
										"chrome")) {
									System.out
											.println("this is chrome browser");
								} else {
									objAutoIT.DownloadTheReports1(
											autoitfilepath,
											backupfiledownloadpath1,
											"/IE9Download.exe");
								}
								Thread.sleep(5000);
								objViewPatients.clickOnDeleteTemplateIcon();
								objUserManagement.clickOnOkInAlertPopUp();
								Thread.sleep(5000);
								objViewPatients
										.verTemplateNotPresentInDropdown(
												objViewPatients_data.strTemplate)
										.clickOnUploadTemplateIcon(
												backupfiledownloadpath1);
								Set<String> allwindows4 = driver
										.getWindowHandles();
								System.out.println(allwindows4.size()
										+ " windows count");
								Iterator<String> itr4 = allwindows4.iterator();
								while (itr4.hasNext()) {
									String childwindow4 = itr4.next()
											.toString();
									if ((!childwindow4.contains(mainwindow))
											&& (!childwindow4
													.contains(childwindow))
											&& (!childwindow4
													.contains(childwindow1))
											&& (!childwindow4
													.contains(childwindow2))) {
										driver.switchTo().window(childwindow4);
										System.out.println(" yyyyyyyyyyyyy");
										System.out
												.println(backupfiledownloadpath1
														+ ".xml");
										objViewPatients
												.clickOnBrowseButton(backupfiledownloadpath1
														+ ".xml");
										objViewPatients
												.clickOnUploadInTemplateEditor();
										Thread.sleep(10000);
										objViewPatients
												.clickOnCloseInMergeReportsPage();
										objUserManagement
												.clickOnOkInAlertPopUp();

									}
								}

								driver.switchTo().window(childwindow2);
								objUserManagement.clickOnOkInAlertPopUp();
								objViewPatients
										.selTemplateFromDropdown(
												objViewPatients_data.strTemplate)
										.verSelectedTemplateDisplayed(
												objViewPatients_data.strTempText);
								driver.close();
							}
						}
						driver.switchTo().window(childwindow1);
						driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}

		gstrResult = "PASS";
	}
	
	@Test(enabled=false,description = "Verify that the report template in .xml format can be uploaded to the "
			+ "Template dropdown using Upload Template feature Template Editor page.")
	public void testHappyDaysamp68600() throws Exception {

		gstrTCID = "68600";
		gstrTO = "Verify that the report template in .xml format can be uploaded to the Template "
				+ "dropdown using Upload Template feature Template Editor page.";

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
		AddUser objAddUser = new AddUser(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
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

		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + strTimeText;
		System.out.println(backupfiledownloadpath1);

		/*String autoit = pathProps.getProperty(objPathData.strAutoITPath2);
		File autoitfile1 = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile1.toString();*/

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
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
		objViewPatients
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnViewModifyWebReportsOfAStudy(
						objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
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
												objViewPatients_data.strTempText)
										.clickOnAddTemplateIcon();
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
														objViewPatients_data.strTemplate)
												.selTemplateType(
														objViewPatients_data.strTemplateType)
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
										.selTemplateFromDropdown1(
												objViewPatients_data.strTemplate)
										.verSelectedTemplateDisplayed(
												objViewPatients_data.strTempText)
										.clickOnDownloadTemplateIcon();
								Thread.sleep(3000);

								//System.out.println(autoitfilepath + 1);
								System.out.println(backupfiledownloadpath1 + 2);
								Capabilities cap = ((RemoteWebDriver) this.driver)
										.getCapabilities();
								cap.getBrowserName();
								if (cap.getBrowserName().equalsIgnoreCase(
										"chrome")) {
									System.out
											.println("this is chrome browser");
								} else {
									objCommonFunctions.downloadFileInIE(backupfiledownloadpath1);
								}
								Thread.sleep(5000);
								objViewPatients.clickOnDeleteTemplateIcon();
								objUserManagement.clickOnOkInAlertPopUp();
								Thread.sleep(5000);
								objViewPatients
										.verTemplateNotPresentInDropdown(
												objViewPatients_data.strTemplate)
										.clickOnUploadTemplateIcon(
												backupfiledownloadpath1);
								Set<String> allwindows4 = driver
										.getWindowHandles();
								System.out.println(allwindows4.size()
										+ " windows count");
								Iterator<String> itr4 = allwindows4.iterator();
								while (itr4.hasNext()) {
									String childwindow4 = itr4.next()
											.toString();
									if ((!childwindow4.contains(mainwindow))
											&& (!childwindow4
													.contains(childwindow))
											&& (!childwindow4
													.contains(childwindow1))
											&& (!childwindow4
													.contains(childwindow2))) {
										driver.switchTo().window(childwindow4);
										System.out.println(" yyyyyyyyyyyyy");
										System.out
												.println(backupfiledownloadpath1
														+ ".xml");
										objViewPatients
												.clickOnBrowseButton(backupfiledownloadpath1
														+ ".xml");
										objViewPatients
												.clickOnUploadInTemplateEditor();
										Thread.sleep(10000);
										objViewPatients
												.clickOnCloseInMergeReportsPage();
										objUserManagement
												.clickOnOkInAlertPopUp();

									}
								}

								driver.switchTo().window(childwindow2);
								objUserManagement.clickOnOkInAlertPopUp();
								objViewPatients
										.selTemplateFromDropdown(
												objViewPatients_data.strTemplate)
										.verSelectedTemplateDisplayed(
												objViewPatients_data.strTempText);
								driver.close();
							}
						}
						driver.switchTo().window(childwindow1);
						driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}

		gstrResult = "PASS";
	}

}
