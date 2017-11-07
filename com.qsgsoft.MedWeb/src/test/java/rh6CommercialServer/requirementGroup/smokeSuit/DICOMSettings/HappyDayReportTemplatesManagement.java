package rh6CommercialServer.requirementGroup.smokeSuit.DICOMSettings;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Groups_data;
import dataObject.Locations_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.User_data;
import dataObject.ViewPatients_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.DICOMSetting;
import page.Destinations;
import page.Groups;
import page.Home;
import page.Locations;
import page.Login;
import page.ReportTemplatesManagement;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.FileFormatConverter;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayReportTemplatesManagement extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayReportTemplatesManagement() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the "Delete" icon is not provided next to Medweb Standard Template 
                     in "Report Template Management" page.     
    'Precondition  :
    'Date          : 27-May-2015			
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Delete icon is not provided next to Medweb Standard Template"
			+ "in Report Template Management page.")
	public void testHappyDay122191() throws Exception {

		gstrTCID = "122191";
		gstrTO = "Verify that the Delete icon is not provided next to Medweb Standard Template in Report "
				+ "Template Management page.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ReportTemplatesManagement objReportTemplatesManagement = new ReportTemplatesManagement(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut92();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnAdminSite1();
		objLogin.enterUserName(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword).clickLogin();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnReportTemplatesManagementLink();
		objReportTemplatesManagement.verReportTemplatesManagementPage();
		String[] templates = objDICOMSettings_data.standardTemplates;
		System.out.println(templates.length);
		int i = templates.length;
		for (int j = 0; j < i; j++) {
			objReportTemplatesManagement
					.enterTextInTemplateNameTextField(templates[j])
					.clickOnStartSearch().verATemplateIsPresent(templates[j])
					.verDelATemplateIconNotPresent(templates[j]);
			System.out.println(" counta le " + j);
		}

		objHome.clickOnLogOut92();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnAdminSite1();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnReportTemplatesManagementLink();
		objReportTemplatesManagement.verReportTemplatesManagementPage();
		String[] templates1 = objDICOMSettings_data.standardTemplates1;
		System.out.println(templates1.length);
		int i1 = templates1.length;
		for (int j = 0; j < i1; j++) {
			objReportTemplatesManagement
					.enterTextInTemplateNameTextField(templates1[j])
					.clickOnStartSearch().verATemplateIsPresent(templates1[j])
					.verDelATemplateIconNotPresent(templates1[j]);
			System.out.println(" counta le " + j);
		}
		objHome.clickOnLogOut92();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that Report Template other than Medweb Standard Template can be deleted
	                   by clicking "Remove this template" icon next to the template .     
	  'Precondition  :
	  'Date          : 30-May-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Report Template other than Medweb Standard Template can be deleted by "
			+ "clicking 'Remove this template' icon next to the template.")
	public void testHappyDay122196() throws Exception {

		gstrTCID = "122196";
		gstrTO = "Verify that Report Template other than Medweb Standard Template can be deleted by clicking "
				+ "'Remove this template' icon next to the template .";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ReportTemplatesManagement objReportTemplatesManagement = new ReportTemplatesManagement(
				this.driver);

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
		Thread.sleep(3000);
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
										objCommonFunctions.clickOnContinueToThisWebsiteLink();
										Thread.sleep(5000);
										System.out
												.println(objViewPatients_data.strTemplate);
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
								Thread.sleep(5000);
								objViewPatients
										.selTemplateFromDropdown(objViewPatients_data.strTemplate);
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
		driver.switchTo().window(mainwindow);
		objHome.clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnReportTemplatesManagementLink();
		objReportTemplatesManagement.verReportTemplatesManagementPage();
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate).clickOnStartSearch()
				.clickOnDeleteATemplate(objViewPatients_data.strTemplate);
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		objReportTemplatesManagement.clickOnStartSearch();
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate).clickOnStartSearch()
				.verNoOrderMsg();
		objHome.clickOnLogOut92();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that Medweb Standard template cannot be saved by clicking 'Save' 
                     icon on top left corner of the template.     
    'Precondition  :
    'Date          : 31-May-2015			
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Medweb Standard template cannot be saved by clicking Save"
			+ "icon on top left corner of the template.")
	public void testHappyDay122194() throws Exception {

		gstrTCID = "122194";
		gstrTO = "Verify that the Delete icon is not provided next to Medweb Standard Template in Report "
				+ "Template Management page.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ReportTemplatesManagement objReportTemplatesManagement = new ReportTemplatesManagement(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnReportTemplatesManagementLink();
		objReportTemplatesManagement.verReportTemplatesManagementPage();
		String[] templates = objDICOMSettings_data.standardTemplates;
		System.out.println(templates.length);
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(templates[0])
				.clickOnStartSearch().clickOnATemplateLink(templates[0]);
		String mw = driver.getWindowHandle();
		for (String cw : driver.getWindowHandles()) {
			driver.switchTo().window(cw);
			driver.manage().window().maximize();
		}
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objViewPatients
				.clickOnClearDocumentIcon()
				.enterTextInTemplateEditorPage(objViewPatients_data.strTempText)
				.clickOnSaveTemplate()
				.verAlertMessage(objViewPatients_data.alertMsg);
		driver.close();
		driver.switchTo().window(mw);
		objHome.clickOnLogOut92();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that the Report Template other than Medweb Standard Template properties
	                   can be modified in "Template Properties" window.     
	  'Precondition  :
	  'Date          : 01-Jun-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Report Template other than Medweb Standard Template properties"
			+ "can be modified in Template Properties window.")
	public void testHappyDay122195() throws Exception {

		gstrTCID = "122195";
		gstrTO = "Verify that the Report Template other than Medweb Standard Template properties can be"
				+ "modified in Template Properties window.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ReportTemplatesManagement objReportTemplatesManagement = new ReportTemplatesManagement(
				this.driver);
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
		Thread.sleep(3000);
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
										objCommonFunctions
												.clickOnContinueToThisWebsiteLink();
										Thread.sleep(5000);
										System.out
												.println(objViewPatients_data.strTemplate);
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
										.selTemplateFromDropdown(objViewPatients_data.strTemplate);
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
		driver.switchTo().window(mainwindow);
		objHome.clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();

		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnReportTemplatesManagementLink();
		objReportTemplatesManagement.verReportTemplatesManagementPage();
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate).clickOnStartSearch()
				.clickOnModifyIconOfTemplate(objViewPatients_data.strTemplate);
		Thread.sleep(5000);
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr1 = aw.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients
						.enterTextInTemplateNameTextField(
								objViewPatients_data.strTemplate1)
						.selTemplateType(objViewPatients_data.strTemplateType1)
						.selTemplateSubType(
								objViewPatients_data.strTemplateSubType)
						.selTemplatePackage(
								objViewPatients_data.strTemplatePackage1)
						.selOwner(objUser_data.strNewUserName).clickOnAclLink();
				Thread.sleep(5000);
				System.out.println(driver.getWindowHandles().size()
						+ " no of windows");
				Set<String> aw2 = driver.getWindowHandles();
				Iterator<String> itr11 = aw2.iterator();
				while (itr11.hasNext()) {
					String cw2 = itr11.next().toString();
					if ((!cw2.contains(cw)) && (!cw2.contains(mw))) {
						driver.switchTo().window(cw2);
						driver.manage().window().maximize();
						objViewPatients.selSharedRadioButton()
								.selOphthalmologistCheckBox()
								.clickOnSaveChangesInAddTemplatePage();
						Thread.sleep(3000);
					}
				}
				driver.switchTo().window(cw);
				objViewPatients.clickOnDeleteTemplateField();
				objUserManagement.clickOnOkInAlertPopUp();
				objViewPatients
						.selTemplateField(
								objViewPatients_data.strTemplateField1)

						.enterTextInMatchTextField()
						.clickOnSaveChangesInAddTemplatePage();
				objViewPatients.clickOnSaveChangesInAddTemplatePage();
			}
		}
		String[] req = objViewPatients_data.strTemplateField1.split("-");
		String req1 = req[0].trim();
		System.out.println(req1);
		driver.switchTo().window(mw);
		objReportTemplatesManagement.enterTextInTemplateNameTextField(
				objViewPatients_data.strTemplate1).clickOnStartSearch();
		Thread.sleep(2000);
		objReportTemplatesManagement.clickOnStartSearch()
				.verModifiedTemplateDetails(
						objViewPatients_data.strTemplatePackage1,
						objViewPatients_data.strTemplate1,
						objViewPatients_data.strTemplateType1,
						objViewPatients_data.strAclTypeOptho,
						objUser_data.strNewUserName, req1);
		objHome.clickOnLogOut92();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that the user who created the template cannot modify the template when
	                   this template is Shared by the Administrator.     
	  'Precondition  :
	  'Date          : 02-Jun-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the user who created the template cannot modify the template "
			+ "when this template is Shared by the Administrator.")
	public void testHappyDay122213() throws Exception {

		gstrTCID = "122213";
		gstrTO = "Verify that the user who created the template cannot modify the template when this "
				+ "template is Shared by the Administrator.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
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
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ReportTemplatesManagement objReportTemplatesManagement = new ReportTemplatesManagement(
				this.driver);
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
		objHome.clickOnAdminSite1();
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
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox();

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
		objHome.clickOnLogOut92();
		objHome.launchApplication(objLogin_data.strAppURL1);
		Thread.sleep(3000);
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
												objViewPatients_data.strTempText)
										.clickOnAddTemplateIcon();
								System.out
										.println(objViewPatients_data.strTemplate);
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
										objCommonFunctions
												.clickOnContinueToThisWebsiteLink();
										Thread.sleep(3000);
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
												.selNominateCheckBox()
												// .selOwner(objUser_data.strNewUserName)
												.clickOnSaveChangesInAddTemplatePage()
												.clickOnSaveChangesInAddTemplatePage();
									}
								}

								driver.switchTo().window(childwindow2);
								objViewPatients
										.selTemplateFromDropdown(objViewPatients_data.strTemplate);
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
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		objHome.clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnReportTemplatesManagementLink();
		objReportTemplatesManagement.verReportTemplatesManagementPage();
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate).clickOnStartSearch()
				.clickOnModifyIconOfTemplate(objViewPatients_data.strTemplate);
		Thread.sleep(5000);
		String mw = driver.getWindowHandle();
		Set<String> aws = driver.getWindowHandles();
		Iterator<String> itrr = aws.iterator();
		while (itrr.hasNext()) {
			String cw = itrr.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.clickOnAclLink();
				Thread.sleep(5000);
				System.out.println(driver.getWindowHandles().size()
						+ " no of windows");
				Set<String> aw = driver.getWindowHandles();
				Iterator<String> itr1 = aw.iterator();
				while (itr1.hasNext()) {
					String cw1 = itr1.next().toString();
					if ((!cw1.contains(cw)) && (!cw1.contains(mw))) {
						driver.switchTo().window(cw1);
						driver.manage().window().maximize();
						objCommonFunctions.clickOnContinueToThisWebsiteLink();
						objViewPatients.selSharedRadioButton()
								.selOphthalmologistCheckBox()
								.clickOnSaveChangesInAddTemplatePage();
						Thread.sleep(3000);
					}
				}
				driver.switchTo().window(cw);
				objViewPatients.clickOnSaveChangesInAddTemplatePage();
			}
		}
		driver.switchTo().window(mw);
		objReportTemplatesManagement.enterTextInTemplateNameTextField(
				objViewPatients_data.strTemplate).clickOnStartSearch();
		objHome.clickOnLogOut92();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();

		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients
				.clickOnSearch()
				.clickOnSearch()
				.clickOnViewModifyWebReportsOfAStudy(
						objViewPatients_data.strStudy);
		String mainwindow1 = driver.getWindowHandle();
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr11 = allwindows1.iterator();
		while (itr11.hasNext()) {
			String childwindow = itr11.next().toString();
			if (!childwindow.contains(mainwindow1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(5000);
				objViewPatients.clickOnAddButton();
				Set<String> allwindows11 = driver.getWindowHandles();
				Iterator<String> itr111 = allwindows11.iterator();
				while (itr111.hasNext()) {
					String childwindow1 = itr111.next().toString();
					if ((!childwindow1.contains(mainwindow1))
							&& (!childwindow1.contains(childwindow))) {
						driver.switchTo().window(childwindow1);
						objViewPatients
								.selTemplateFromDropdown(objViewPatients_data.strTemplate);
						Thread.sleep(5000);
						objViewPatients.clickOnTemplateEditorIcon();
						Thread.sleep(5000);
						Set<String> allwindows2 = driver.getWindowHandles();
						Iterator<String> itr2 = allwindows2.iterator();
						while (itr2.hasNext()) {
							String childwindow2 = itr2.next().toString();
							if ((!childwindow2.contains(mainwindow1))
									&& (!childwindow2.contains(childwindow))
									&& (!childwindow2.contains(childwindow1))) {
								driver.switchTo().window(childwindow2);
								objViewPatients.clickOnTemplatePropertiesIcon();
								Thread.sleep(10000);
								Set<String> allwindows3 = driver
										.getWindowHandles();
								System.out.println(allwindows3.size()
										+ "total number of windows");
								Iterator<String> itr3 = allwindows3.iterator();
								while (itr3.hasNext()) {
									String childwindow3 = itr3.next()
											.toString();
									if ((!childwindow3.contains(mainwindow1))
											&& (!childwindow3
													.contains(childwindow))
											&& (!childwindow3
													.contains(childwindow1))
											&& (!childwindow3
													.contains(childwindow2))) {
										driver.switchTo().window(childwindow3);
										driver.manage().window().maximize();
										objCommonFunctions.clickOnContinueToThisWebsiteLink();
										Thread.sleep(5000);
										objViewPatients
												.verCannotModifyTemplateErrorMsg(
														objViewPatients_data.modifyTempErrMsg)
												.verSaveChangesNotDisplayed();
										driver.close();
									}
								}

								driver.switchTo().window(childwindow2);
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
		driver.switchTo().window(mainwindow1);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	  'Description   : Verify that the template which is shared cannot be deleted by any of the
	                   regular user or the user who created the template.     
	  'Precondition  :
	  'Date          : 03-Jun-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the template which is shared cannot be deleted by any of the "
			+ "regular user or the user who created the template.")
	public void testHappyDay122314() throws Exception {

		gstrTCID = "122314";
		gstrTO = "Verify that the template which is shared cannot be deleted by any of the regular "
				+ "user or the user who created the template.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
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
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ReportTemplatesManagement objReportTemplatesManagement = new ReportTemplatesManagement(
				this.driver);

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
		objHome.clickOnAdminSite1();
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
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox();

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
												objViewPatients_data.strTempText)
										.clickOnAddTemplateIcon();
								System.out
										.println(objViewPatients_data.strTemplate);
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
										objCommonFunctions
												.clickOnContinueToThisWebsiteLink();
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
												.selNominateCheckBox()
												.clickOnSaveChangesInAddTemplatePage()
												.clickOnSaveChangesInAddTemplatePage();
									}
								}

								driver.switchTo().window(childwindow2);
								objViewPatients
										.selTemplateFromDropdown(objViewPatients_data.strTemplate);
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
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		objHome.clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnReportTemplatesManagementLink();
		objReportTemplatesManagement.verReportTemplatesManagementPage();
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate).clickOnStartSearch()
				.clickOnModifyIconOfTemplate(objViewPatients_data.strTemplate);
		Thread.sleep(5000);
		String mw = driver.getWindowHandle();
		for (String cw : driver.getWindowHandles()) {
			driver.switchTo().window(cw);
		}
		driver.manage().window().maximize();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		String cw = driver.getWindowHandle();
		objViewPatients.clickOnAclLink();
		Thread.sleep(5000);
		System.out.println(driver.getWindowHandles().size() + " no of windows");
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr1 = aw.iterator();
		while (itr1.hasNext()) {
			String cw1 = itr1.next().toString();
			if ((!cw1.contains(cw)) && (!cw1.contains(mw))) {
				driver.switchTo().window(cw1);
				driver.manage().window().maximize();
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.selSharedRadioButton()
						.selOphthalmologistCheckBox()
						.clickOnSaveChangesInAddTemplatePage();
				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(cw);
		objViewPatients.clickOnSaveChangesInAddTemplatePage();
		driver.switchTo().window(mw);
		objReportTemplatesManagement.enterTextInTemplateNameTextField(
				objViewPatients_data.strTemplate).clickOnStartSearch();
		objHome.clickOnLogOut92();
		objHome.launchApplication(objLogin_data.strAppURL1);
		Thread.sleep(3000);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();

		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients
				.clickOnSearch()
				.clickOnSearch()
				.clickOnViewModifyWebReportsOfAStudy(
						objViewPatients_data.strStudy);
		String mainwindow1 = driver.getWindowHandle();
		Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> itr11 = allwindows1.iterator();
		while (itr11.hasNext()) {
			String childwindow = itr11.next().toString();
			if (!childwindow.contains(mainwindow1)) {
				driver.switchTo().window(childwindow);
				// driver1.close();
				Thread.sleep(5000);
				objViewPatients.clickOnAddButton();
				Set<String> allwindows11 = driver.getWindowHandles();
				Iterator<String> itr111 = allwindows11.iterator();
				while (itr111.hasNext()) {
					String childwindow1 = itr111.next().toString();
					if ((!childwindow1.contains(mainwindow1))
							&& (!childwindow1.contains(childwindow))) {
						driver.switchTo().window(childwindow1);
						objViewPatients
								.selTemplateFromDropdown(objViewPatients_data.strTemplate);
						Thread.sleep(5000);
						objViewPatients.clickOnTemplateEditorIcon();
						Thread.sleep(5000);
						Set<String> allwindows2 = driver.getWindowHandles();
						Iterator<String> itr2 = allwindows2.iterator();
						while (itr2.hasNext()) {
							String childwindow2 = itr2.next().toString();
							if ((!childwindow2.contains(mainwindow1))
									&& (!childwindow2.contains(childwindow))
									&& (!childwindow2.contains(childwindow1))) {
								driver.switchTo().window(childwindow2);
								objViewPatients.clickOnDeleteTemplateIcon();
								Thread.sleep(3000);

								objViewPatients
										.verAlertMessage(objViewPatients_data.cannotDeleteErrMsg);
								driver.switchTo().window(childwindow2);
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
		driver.switchTo().window(mainwindow1);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that the Report Template in zip format is uploaded to the Server using 
	                   Upload templates from .ZIP file option in Operations with Report Templates window.     
	  'Precondition  :
	  'Date          : 06-Jun-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Report Template in zip format is uploaded to the Server using "
			+ "Upload templates from .ZIP file option in Operations with Report Templates window.")
	public void testHappyDay122429() throws Exception {

		gstrTCID = "122429";
		gstrTO = "Verify that the Report Template in zip format is uploaded to the Server using Upload "
				+ "templates from .ZIP file option in Operations with Report Templates window.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ReportTemplatesManagement objReportTemplatesManagement = new ReportTemplatesManagement(
				this.driver);
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();

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
		
		//backup file
		
		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath = backfile + "\\" + objViewPatients_data.strFile + ".xml";
		String filepath = backfile + "\\" + objViewPatients_data.strFile + ".zip";
		System.out.println(backupfiledownloadpath);

		String autoit = pathProps.getProperty(objPathData./*autoItFilePath2*/strAutoITPath2);
		File autoitfile1 = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile1.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
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
										System.out.println(objViewPatients_data.strTemplate);
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
										.selTemplateFromDropdown(
												objViewPatients_data.strTemplate)
										/*.verSelectedTemplateDisplayed(
												objViewPatients_data.strTempText)*/;
								objViewPatients.clickOnDownloadTemplateIcon();
								Thread.sleep(5000);
								objAutoIT.DownloadTheReports1(autoitfilepath, backupfiledownloadpath,"Marr.exe");
								Thread.sleep(5000);
							
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
		driver.switchTo().window(mainwindow);
		objHome.clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnReportTemplatesManagementLink();
		objReportTemplatesManagement.verReportTemplatesManagementPage();
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate).clickOnStartSearch()
				.clickOnDeleteATemplate(objViewPatients_data.strTemplate);
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(7000);
		objReportTemplatesManagement.clickOnStartSearch();
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate).clickOnStartSearch()
				/*.verATemplateNotPresent(objViewPatients_data.strTemplate)*/.verNoOrderMsg();
		objFileFormatConverter.convertXmlToZip(backupfiledownloadpath, filepath,objViewPatients_data.strFile + ".xml");
		Thread.sleep(5000);
		objReportTemplatesManagement.clickOnManagement();
		String mw = driver.getWindowHandle();
		for(String cw: driver.getWindowHandles()){
			driver.switchTo().window(cw);
		}
		objReportTemplatesManagement.selUploadTemplateRadioButton().clickOnRun();
		objViewPatients.clickOnBrowse(filepath).clickOnUploadInTemplateEditor();
		objReportTemplatesManagement.clickOnSetTemplates().clickOnClose();
		driver.switchTo().window(mw);
		objReportTemplatesManagement
		.enterTextInTemplateNameTextField(
				objViewPatients_data.strTemplate).clickOnStartSearch().verATemplateIsPresent(objViewPatients_data.strTemplate);
		

		gstrResult = "PASS";
	}

	/*************************************************************************************
	 * 'Description  : Verify that the multiple templates selected can be downloaded to the system 
	 *                 and these templates can be uploaded to the Server successfully. 
	 * 'Precondition : 
	 * 'Date         : 27-Jun-2016 
	 * 'Author       : Hanumegowda
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that the multiple templates selected can be downloaded to the system"
			+ " and these templates can be uploaded to the Server successfully.")
	public void testHappyDay122538() throws Exception {

		gstrTCID = "122538";
		gstrTO = "Verify that the multiple templates selected can be downloaded to the system and these"
				+ " templates can be uploaded to the Server successfully.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ReportTemplatesManagement objReportTemplatesManagement = new ReportTemplatesManagement(
				this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
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

		// backup file

		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath = backfile + "\\"
				+ objViewPatients_data.strFile + ".zip";
		System.out.println(backupfiledownloadpath + " this download path");

		String autoit = pathProps
				.getProperty(objPathData./* autoItFilePath2 */strAutoITPath);
		File autoitfile1 = new File(System.getProperty("user.dir") + autoit);
		String autoitdownloadpath = autoitfile1.toString();

		String temp[] = { objViewPatients_data.strTemplate,
				objViewPatients_data.strTemplate2,
				objViewPatients_data.strTemplate3,
				objViewPatients_data.strTemplate4,
				objViewPatients_data.strTemplate5 };
		System.out.println(temp.length);
		System.out.println(temp[0]);
		System.out.println(temp[1]);
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		Thread.sleep(3000);
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

						for (int i = 0; i < temp.length; i++) {

							objViewPatients.clickOnTemplateEditorIcon();
							Thread.sleep(10000);
							Set<String> allwindows2 = driver.getWindowHandles();
							Iterator<String> itr2 = allwindows2.iterator();
							while (itr2.hasNext()) {
								String childwindow2 = itr2.next().toString();
								if ((!childwindow2.contains(mainwindow))
										&& (!childwindow2.contains(childwindow))
										&& (!childwindow2
												.contains(childwindow1))) {
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
									Iterator<String> itr3 = allwindows3
											.iterator();
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
											driver.switchTo().window(
													childwindow3);
											driver.manage().window().maximize();
											if(i==0){
											objCommonFunctions
													.clickOnContinueToThisWebsiteLink();
											}
											Thread.sleep(5000);
											System.out
													.println(objViewPatients_data.strTemplate);
											objViewPatients
													.enterTextInTemplateNameTextField(
															temp[i])
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
											.selTemplateFromDropdown(objViewPatients_data.strTemplate);
									driver.close();
								}
							}
							driver.switchTo().window(childwindow1);

						}

						driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);

		objViewPatients.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		Thread.sleep(3000);
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnReportTemplatesManagementLink();
		String str = (objViewPatients_data.strTemplate2).substring(18);
		objReportTemplatesManagement.verReportTemplatesManagementPage()
				.enterTextInTemplateNameTextField(str).clickOnStartSearch()
				.selATemplate(temp[0]).selATemplate(temp[1])
				.selATemplate(temp[2]).selATemplate(temp[3])
				.selATemplate(temp[4]).clickOnManagement();
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr1 = aw.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objReportTemplatesManagement
						.selDownloadSelectedTemplatesRadioButton().clickOnRun();
				objUserManagement.clickOnOkInAlertPopUp();
				Thread.sleep(5000);
				objAutoIT.DownloadTheReports1(autoitdownloadpath,
						backupfiledownloadpath, "Marr.exe");
				Thread.sleep(6000);
				driver.close();
			}
		}
		driver.switchTo().window(mw);
		objReportTemplatesManagement.clickOnDeleteIcon();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		for (int i = 0; i < temp.length; i++) {
			objReportTemplatesManagement
					.enterTextInTemplateNameTextField(temp[i])
					.clickOnStartSearch().verNoOrderMsg();
		}
		objReportTemplatesManagement.clickOnManagement();
		Set<String> aw1 = driver.getWindowHandles();
		Iterator<String> itr11 = aw1.iterator();
		while (itr11.hasNext()) {
			String cw = itr11.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				objReportTemplatesManagement.selUploadTemplateRadioButton()
						.clickOnRun();
				objViewPatients.clickOnBrowse(backupfiledownloadpath)
						.clickOnUploadInTemplateEditor();
				objReportTemplatesManagement.clickOnSetTemplates()
						.clickOnClose();
			}
		}
		driver.switchTo().window(mw);
		objReportTemplatesManagement.enterTextInTemplateNameTextField(
				temp[0].substring(18)).clickOnStartSearch();
		for (int i = 0; i < temp.length; i++) {
			objReportTemplatesManagement.verATemplateIsPresent(temp[i]);
		}
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the Administrator/Administrator user cannot modify the Medweb 
                     Standard template and can only view the template properties by clicking "Modify 
                     Template Property" pencil icon next to the template.     
    'Precondition  :
    'Date          : 14-Sep-2016			
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Administrator/Administrator user cannot modify the Medweb "
			+ "Standard template and can only view the template properties by clicking Modify Template"
			+ "Property pencil icon next to the template.")
	public void testHappyDay122190() throws Exception {

		gstrTCID = "122190";
		gstrTO = "Verify that the Administrator/Administrator user cannot modify the Medweb Standard "
				+ "template and can only view the template properties by clicking Modify Template Property"
				+ " pencil icon next to the template.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ReportTemplatesManagement objReportTemplatesManagement = new ReportTemplatesManagement(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.clickOnAdminSite1();
		driver.switchTo().defaultContent();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut92();
		objHome.launchApplication(objLogin_data.strAppURL1);
		driver.switchTo().defaultContent();
		objHome.clickOnAdminSite();
		objLogin.enterUserName(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword).clickLogin();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnReportTemplatesManagementLink();
		objReportTemplatesManagement.verReportTemplatesManagementPage();
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objDICOMSettings_data.standardTemplates[0])
				.clickOnStartSearch()
				.verATemplateIsPresent(
						objDICOMSettings_data.standardTemplates[0])
				.clickOnModifyIconOfTemplate(
						objDICOMSettings_data.standardTemplates[0]);
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr = aw.iterator();
		while (itr.hasNext()) {
			String cw = itr.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				Thread.sleep(5000);
				driver.manage().window().maximize();
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.verCannotModifyTemplateErrorMsg(
						objViewPatients_data.modifyStandardTempErrMsg)
						.verSaveChangesNotDisplayed();
				driver.close();
			}

		}
		driver.switchTo().window(mw);

		objHome.clickOnLogOut92();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnReportTemplatesManagementLink();
		objReportTemplatesManagement.verReportTemplatesManagementPage();
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objDICOMSettings_data.standardTemplates[0])
				.clickOnStartSearch()
				.verATemplateIsPresent(
						objDICOMSettings_data.standardTemplates[0])
				.clickOnModifyIconOfTemplate(
						objDICOMSettings_data.standardTemplates[0]);
		String mw1 = driver.getWindowHandle();
		Set<String> aw1 = driver.getWindowHandles();
		Iterator<String> itr1 = aw1.iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!cw.contains(mw1)) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.verCannotModifyTemplateErrorMsg(
						objViewPatients_data.modifyStandardTempErrMsg)
						.verSaveChangesNotDisplayed();
				driver.close();
			}

		}
		driver.switchTo().window(mw1);
		objHome.clickOnLogOut92();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description  : Verify that multiple templates selected is deleted when "Remove the selected
	 *                 entries" is clicked at the bottom of the page. 
	 * 'Precondition : 
	 * 'Date         : 15-Sep-2016 
	 * 'Author       : Hanumegowda
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that multiple templates selected is deleted when Remove the selected "
			+ "entries is clicked at the bottom of the page.")
	public void testHappyDay122197() throws Exception {

		gstrTCID = "122197";
		gstrTO = "Verify that multiple templates selected is deleted when Remove the selected entries"
				+ " is clicked at the bottom of the page.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ReportTemplatesManagement objReportTemplatesManagement = new ReportTemplatesManagement(
				this.driver);
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

		String temp[] = { objViewPatients_data.strTemplate,
				objViewPatients_data.strTemplate2,
				objViewPatients_data.strTemplate3,
				objViewPatients_data.strTemplate4,
				objViewPatients_data.strTemplate5 };
		System.out.println(temp.length);
		System.out.println(temp[0]);
		System.out.println(temp[1]);
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
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
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.clickOnAddButton();
				Set<String> allwindows1 = driver.getWindowHandles();
				Iterator<String> itr1 = allwindows1.iterator();
				while (itr1.hasNext()) {
					String childwindow1 = itr1.next().toString();
					if ((!childwindow1.contains(mainwindow))
							&& (!childwindow1.contains(childwindow))) {
						driver.switchTo().window(childwindow1);

						for (int i = 0; i < temp.length; i++) {

							objViewPatients.clickOnTemplateEditorIcon();
							Thread.sleep(10000);
							Set<String> allwindows2 = driver.getWindowHandles();
							Iterator<String> itr2 = allwindows2.iterator();
							while (itr2.hasNext()) {
								String childwindow2 = itr2.next().toString();
								if ((!childwindow2.contains(mainwindow))
										&& (!childwindow2.contains(childwindow))
										&& (!childwindow2
												.contains(childwindow1))) {
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
									Iterator<String> itr3 = allwindows3
											.iterator();
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
											driver.switchTo().window(
													childwindow3);
											driver.manage().window().maximize();
											if (i == 0) {
												objCommonFunctions
														.clickOnContinueToThisWebsiteLink();
											}
											Thread.sleep(5000);
											System.out
													.println(objViewPatients_data.strTemplate);
											objViewPatients
													.enterTextInTemplateNameTextField(
															temp[i])
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
											.selTemplateFromDropdown(objViewPatients_data.strTemplate);
									driver.close();
								}
							}
							driver.switchTo().window(childwindow1);

						}

						driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);

		objViewPatients.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.clickOnAdminSite1();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnReportTemplatesManagementLink();
		String str = (objViewPatients_data.strTemplate2).substring(18);
		objReportTemplatesManagement.verReportTemplatesManagementPage()
				.enterTextInTemplateNameTextField(str).clickOnStartSearch()
				.selATemplate(temp[0]).selATemplate(temp[1])
				.selATemplate(temp[2]).selATemplate(temp[3])
				.selATemplate(temp[4]);

		objReportTemplatesManagement.clickOnDeleteIcon();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		for (int i = 0; i < temp.length; i++) {
			objReportTemplatesManagement
					.enterTextInTemplateNameTextField(temp[i])
					.clickOnStartSearch().verNoOrderMsg();
		}
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}

}
