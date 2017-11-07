package rh6CommercialServer.requirementGroup.smokeSuit.DICOMSettings;

import java.io.File;
import java.util.Properties;

import dataObject.Login_data;
import dataObject.PathData;
import dataObject.Templates_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.DICOMSetting;
import page.Home;
import page.Login;
import page.TemplatesList;
import page.UserManagement;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayImportTemplatePage extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayImportTemplatePage() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that supported template (.dxf or .zip) are imported using 'Import Template'
                     button in 'Import New Template' page.     
    'Precondition  :
    'Date          : 07-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that supported template (.dxf or .zip) are imported using 'Import "
			+ "Template' button in 'Import New Template' page.")
	public void testHappyDay68344() throws Exception {

		gstrTCID = "68344";
		gstrTO = "Verify that supported template (.dxf or .zip) are imported using 'Import Template'"
				+ "button in 'Import New Template' page.";

		Login_data objLogin_data = new Login_data();
		Templates_data objTemplates_data = new Templates_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		TemplatesList objTemplatesList = new TemplatesList(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileUploadPath1 = pathProps
				.getProperty(objPathData.strUploadDxffile);

		File file1 = new File(System.getProperty("user.dir") + fileUploadPath1);
		String strPath1 = file1.toString();
		System.out.println(strPath1);
		String str1[] = strPath1.split("\\\\");
		String filename1 = str1[(str1.length - 1)];
		String filenamea[] = filename1.split("\\.");
		System.out.println(filename1);
		System.out.println(filenamea[0]);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnImportTemplatePageLink();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch();
		objTemplatesList.selectTemplates(filenamea[0]);
		objTemplatesList.deleteAllSelectedTemplates();
		objUserManagement.clickOnOkInAlertPopUp();
		objTemplatesList.clickOnAddTemplate();
		objTemplatesList.clickOnClearLog().clickOnBrowse(strPath1)
				.selTemplateType(objTemplates_data.strTemTypeStandard)
				.clickOnImport().verTemplateSuccessfullyImportedMsg()
				.clickOnBack();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch()
				.verTemplateIsPresent(filenamea[0]);
		
		gstrResult = "PASS";
	}

	/*************************************************************************************
    'Description   : Verify that template data modified are saved when 'Save Changes' button 
                     is clicked in the 'Modify Template fields'.     
    'Precondition  :
    'Date          : 08-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that template data modified are saved when 'Save Changes' button "
			+ "is clicked in the 'Modify Template fields'.")
	public void testHappyDay68348() throws Exception {

		gstrTCID = "68348";
		gstrTO = "Verify that template data modified are saved when 'Save Changes' button is clicked "
				+ "in the 'Modify Template fields'.";

		Login_data objLogin_data = new Login_data();
		Templates_data objTemplates_data = new Templates_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		TemplatesList objTemplatesList = new TemplatesList(this.driver);
		Login objLogin = new Login(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileUploadPath1 = pathProps
				.getProperty(objPathData.strUploadDxffile);

		File file1 = new File(System.getProperty("user.dir") + fileUploadPath1);
		String strPath1 = file1.toString();
		System.out.println(strPath1);
		String str1[] = strPath1.split("\\\\");
		String filename1 = str1[(str1.length - 1)];
		String filenamea[] = filename1.split("\\.");
		System.out.println(filename1);
		System.out.println(filenamea[0]);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnImportTemplatePageLink();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch();
		objTemplatesList.selectTemplates1(filenamea[0]);
		objUserManagement.clickOnOkInAlertPopUp();
		objTemplatesList.clickOnAddTemplate();
		objTemplatesList.clickOnClearLog().clickOnBrowse(strPath1)
				.selTemplateType(objTemplates_data.strTemTypeStandard)
				.clickOnImport().verTemplateSuccessfullyImportedMsg()
				.clickOnBack();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch()
				.verTemplateIsPresent(filenamea[0])
				.clickOnModifyTemplate(filenamea[0]);
		objTemplatesList.enterTextInBodyPart(objTemplates_data.bodyPart)
				.enterTextInOrientation(objTemplates_data.bodyPart)
				.enterTextInTemplateGroupInModifyTemplatePage(objTemplates_data.bodyPart)
				.enterTextInSize(objTemplates_data.size);
		objAddUser.clickOnSaveChanges();
		
		objTemplatesList
				.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0])
				.clickOnSearch()
				.verModifiedTemplate(filenamea[0], objTemplates_data.bodyPart,
						objTemplates_data.size);
		gstrResult = "PASS";
	}

	/*************************************************************************************
    'Description   : Verify that the selected template is removed from the server when "Remove
                     Selected Template" icon is clicked at the bottom of the page.     
    'Precondition  :
    'Date          : 08-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the selected template is removed from the server when 'Remove"
			+ " Selected Template' icon is clicked at the bottom of the page.")
	public void testHappyDay68351() throws Exception {

		gstrTCID = "68351";
		gstrTO = "Verify that the selected template is removed from the server when 'Remove Selected"
				+ " Template' icon is clicked at the bottom of the page .";

		Login_data objLogin_data = new Login_data();
		Templates_data objTemplates_data = new Templates_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		TemplatesList objTemplatesList = new TemplatesList(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileUploadPath1 = pathProps
				.getProperty(objPathData.strUploadDxffile);

		File file1 = new File(System.getProperty("user.dir") + fileUploadPath1);
		String strPath1 = file1.toString();
		System.out.println(strPath1);
		String str1[] = strPath1.split("\\\\");
		String filename1 = str1[(str1.length - 1)];
		String filenamea[] = filename1.split("\\.");
		String substr = filenamea[0].substring(0, (filenamea[0].length()) - 1);
		System.out.println(filename1);
		System.out.println(filenamea[0]);

		String fileUploadPath2 = pathProps
				.getProperty(objPathData.strUploadDxffile1);

		File file2 = new File(System.getProperty("user.dir") + fileUploadPath2);
		String strPath2 = file2.toString();
		System.out.println(strPath2);
		String str2[] = strPath2.split("\\\\");
		String filename2 = str2[(str2.length - 1)];
		String filenamea1[] = filename2.split("\\.");
		System.out.println(filename2);
		System.out.println(filenamea1[0]);

		String fileUploadPath3 = pathProps
				.getProperty(objPathData.strUploadDxffile2);

		File file3 = new File(System.getProperty("user.dir") + fileUploadPath3);
		String strPath3 = file3.toString();
		System.out.println(strPath3);
		String str3[] = strPath3.split("\\\\");
		String filename3 = str3[(str3.length - 1)];
		String filenamea2[] = filename3.split("\\.");
		System.out.println(filename3);
		System.out.println(filenamea2[0]);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnImportTemplatePageLink();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch()
				.selectTemplates1(filenamea[0]);
		objUserManagement.clickOnOkInAlertPopUp();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea1[0]).clickOnSearch()
				.selectTemplates1(filenamea1[0]);
		objUserManagement.clickOnOkInAlertPopUp();

		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea2[0]).clickOnSearch()
				.selectTemplates1(filenamea2[0]);
		objUserManagement.clickOnOkInAlertPopUp();

		objTemplatesList.clickOnAddTemplate();
		objTemplatesList.clickOnClearLog().clickOnBrowse(strPath1)
				.selTemplateType(objTemplates_data.strTemTypeStandard)
				.clickOnImport().verTemplateSuccessfullyImportedMsg()
				.clickOnBack();
		objTemplatesList.clickOnAddTemplate();
		objTemplatesList.clickOnClearLog().clickOnBrowse(strPath2)
				.selTemplateType(objTemplates_data.strTemTypeStandard)
				.clickOnImport().verTemplateSuccessfullyImportedMsg()
				.clickOnBack();

		objTemplatesList.clickOnAddTemplate();
		objTemplatesList.clickOnClearLog().clickOnBrowse(strPath3)
				.selTemplateType(objTemplates_data.strTemTypeStandard)
				.clickOnImport().verTemplateSuccessfullyImportedMsg()
				.clickOnBack();

		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInTemplateGroup(objTemplates_data.templateGroup)
				.clickOnSearch().verTemplateIsPresent(filenamea[0])
				.verTemplateIsPresent(filenamea1[0])
				.verTemplateIsPresent(filenamea2[0]);
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInTemplateGroup(objTemplates_data.templateGroup)
				.clickOnSearch().selectTemplates(filenamea[0]);
		objTemplatesList.selectTemplates(filenamea1[0]);
		objTemplatesList.selectTemplates(filenamea2[0]);
		objTemplatesList.deleteAllSelectedTemplates();
		objUserManagement.clickOnOkInAlertPopUp();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch()
				.verTemplateIsNotPresentErrMsg();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea1[0]).clickOnSearch()
				.verTemplateIsNotPresentErrMsg();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea2[0]).clickOnSearch()
				.verTemplateIsNotPresentErrMsg();
		gstrResult = "PASS";
	}

	/*************************************************************************************
    'Description   : Verify that the imported template is deleted when 'Remove Template' icon
                     is clicked next to respective template in 'Template List' page.     
    'Precondition  :
    'Date          : 09-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the imported template is deleted when 'Remove Template' "
			+ "icon is clicked next to respective template in 'Template List' page.")
	public void testHappyDay68349() throws Exception {

		gstrTCID = "68349";
		gstrTO = "Verify that the imported template is deleted when 'Remove Template' icon is"
				+ " clicked next to respective template in 'Template List' page.";

		Login_data objLogin_data = new Login_data();
		Templates_data objTemplates_data = new Templates_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		TemplatesList objTemplatesList = new TemplatesList(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileUploadPath1 = pathProps
				.getProperty(objPathData.strUploadDxffile);

		File file1 = new File(System.getProperty("user.dir") + fileUploadPath1);
		String strPath1 = file1.toString();
		System.out.println(strPath1);
		String str1[] = strPath1.split("\\\\");
		String filename1 = str1[(str1.length - 1)];
		String filenamea[] = filename1.split("\\.");
		System.out.println(filename1);
		System.out.println(filenamea[0]);
		String str = objTemplates_data.modTempName;
		System.out.println(str);
		String str3 = str.substring(8);
		System.out.println(str3);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnImportTemplatePageLink();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch()
				.selectTemplates1(filenamea[0]);
		// objTemplatesList.deleteAllSelectedTemplates();
		objUserManagement.clickOnOkInAlertPopUp();
		objTemplatesList.clickOnAddTemplate();
		objTemplatesList.clickOnClearLog().clickOnBrowse(strPath1)
				.selTemplateType(objTemplates_data.strTemTypeStandard)
				.clickOnImport().verTemplateSuccessfullyImportedMsg()
				.clickOnBack();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch()
				.verTemplateIsPresent(filenamea[0])

				.deleteATemplates(filenamea[0]);
		objUserManagement.clickOnOkInAlertPopUp();
		objTemplatesList.enterTextInPartNoField(filenamea[0]).clickOnSearch()
				.deleteATemplates(filenamea[0]);
		objUserManagement.clickOnOkInAlertPopUp();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch()
				.verTemplateIsNotPresentErrMsg();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that imported template is displayed in the 'Template List' page.     
    'Precondition  :
    'Date          : 26-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that imported template is displayed in the 'Template List' page.")
	public void testHappyDay68345() throws Exception {

		gstrTCID = "68345";
		gstrTO = "Verify that imported template is displayed in the 'Template List' page.";

		Login_data objLogin_data = new Login_data();
		Templates_data objTemplates_data = new Templates_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		TemplatesList objTemplatesList = new TemplatesList(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileUploadPath1 = pathProps
				.getProperty(objPathData.strUploadDxffile);

		File file1 = new File(System.getProperty("user.dir") + fileUploadPath1);
		String strPath1 = file1.toString();
		System.out.println(strPath1);
		String str1[] = strPath1.split("\\\\");
		String filename1 = str1[(str1.length - 1)];
		String filenamea[] = filename1.split("\\.");
		System.out.println(filename1);
		System.out.println(filenamea[0]);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnImportTemplatePageLink();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch();
		objTemplatesList.selectTemplates(filenamea[0]);
		objTemplatesList.deleteAllSelectedTemplates();
		objUserManagement.clickOnOkInAlertPopUp();
		objTemplatesList.clickOnAddTemplate();
		objTemplatesList.clickOnClearLog().clickOnBrowse(strPath1)
				.selTemplateType(objTemplates_data.strTemTypeStandard)
				.clickOnImport().verTemplateSuccessfullyImportedMsg()
				.clickOnBack();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch()
				.verTemplateIsPresent(filenamea[0]);

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that template imported can be saved to the local system when 'View Template'
                     icon is clicked next to the corresponding template in 'Template List' page.     
    'Precondition  :
    'Date          : 27-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that template imported can be saved to the local system when 'View Template'"
			+ " icon is clicked next to the corresponding template in 'Template List' page.")
	public void testHappyDay68346() throws Exception {

		gstrTCID = "68346";
		gstrTO = "Verify that template imported can be saved to the local system when 'View Template' icon"
				+ " is clicked next to the corresponding template in 'Template List' page.";

		Login_data objLogin_data = new Login_data();
		Templates_data objTemplates_data = new Templates_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		TemplatesList objTemplatesList = new TemplatesList(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		// dxf file
		String fileUploadPath1 = pathProps
				.getProperty(objPathData.strUploadDxffile);
		File file1 = new File(System.getProperty("user.dir") + fileUploadPath1);
		String strPath1 = file1.toString();
		System.out.println(strPath1);

		// autoit download file path
		String fileDownloadPath = pathProps
				.getProperty(objPathData.strAutoITPath);
		File file2 = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strPath2 = file2.toString();

		// backup file
		String backUpFile = pathProps.getProperty(objPathData.strBackupfile);
		File file21 = new File(System.getProperty("user.dir") + backUpFile
				+ "\\" + System.currentTimeMillis() + ".dxf");
		String strPath21 = file21.toString();
		System.out.println(strPath21 + " backup file path");

		String str1[] = strPath1.split("\\\\");
		String filename1 = str1[(str1.length - 1)];
		String filenamea[] = filename1.split("\\.");
		System.out.println(filename1);
		System.out.println(filenamea[0]);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnImportTemplatePageLink();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch();
		objTemplatesList.selectTemplates(filenamea[0]);
		objTemplatesList.deleteAllSelectedTemplates();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(2000);
		objTemplatesList.clickOnAddTemplate();
		objTemplatesList.clickOnClearLog().clickOnBrowse(strPath1)
				.selTemplateType(objTemplates_data.strTemTypeStandard)
				.clickOnImport().verTemplateSuccessfullyImportedMsg()
				.clickOnBack();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch()
				.verTemplateIsPresent(filenamea[0]);
		objTemplatesList.clickOnViewTemplateIcon(filenamea[0]);
		Thread.sleep(6000);
		if(objCommonFunctions.getBrowserName().equals("internet explorer")){
		objAutoIT.DownloadTheReports1(strPath2, strPath21, "IEDownload.exe");
		Thread.sleep(10000);
		objCommonFunctions.verDownloadedFile(strPath21);
		}
		else{
			objCommonFunctions.verDownloadedFile(bp1);
		}

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that the templates details are saved when modified in "Modify Selected
                     Template" page.     
    'Precondition  :
    'Date          : 28-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the templates details are saved when modified in Modify Selected "
			+ "Template page.")
	public void testHappyDay68350() throws Exception {

		gstrTCID = "68350";
		gstrTO = "Verify that the templates details are saved when modified in Modify Selected Template page.";

		Login_data objLogin_data = new Login_data();
		Templates_data objTemplates_data = new Templates_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		TemplatesList objTemplatesList = new TemplatesList(this.driver);
		Login objLogin = new Login(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileUploadPath1 = pathProps
				.getProperty(objPathData.strUploadDxffile);

		File file1 = new File(System.getProperty("user.dir") + fileUploadPath1);
		String strPath1 = file1.toString();
		System.out.println(strPath1);
		String str1[] = strPath1.split("\\\\");
		String filename1 = str1[(str1.length - 1)];
		String filenamea[] = filename1.split("\\.");
		System.out.println(filename1);
		System.out.println(filenamea[0]);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnImportTemplatePageLink();
		objTemplatesList.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0]).clickOnSearch();
		objTemplatesList.selectTemplates1(filenamea[0]);
		objUserManagement.clickOnOkInAlertPopUp();
		objTemplatesList.clickOnAddTemplate();
		objTemplatesList.clickOnClearLog().clickOnBrowse(strPath1)
				.selTemplateType(objTemplates_data.strTemTypeStandard)
				.clickOnImport().verTemplateSuccessfullyImportedMsg()
				.clickOnBack();
		objTemplatesList
				.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(filenamea[0])
				.clickOnSearch()
				.verTemplateIsPresent(filenamea[0])
				.selSelectOrUnselectAllCheckbox()
				.clickOnModifySelectedTemplatesIcon()
				.verModifySelectedTemplatesPage()
				.selAllTemplatesDataCheckBoxes()
				.enterTextInBodyPart(objTemplates_data.bodyPart1)
				.enterTextInTemplateGroupInModifyTemplatePage(
						objTemplates_data.templateGroup)
				.enterTextInOrientation(objTemplates_data.orientation)
				.enterTextInSize(objTemplates_data.size)
				.enterTextInPartNoInModifyPage(objTemplates_data.partNum)
				.enterTextInMirroredPartNo(objTemplates_data.mirroredPN)
				.enterTextInCalibFactor(objTemplates_data.bodyPart)
				.enterTextInRotation_Point_X(objTemplates_data.rotationPointXY)
				.enterTextInRotation_Point_Y(objTemplates_data.rotationPointXY)
				.enterTextInDescription(objTemplates_data.bodyPart);
		objAddUser.clickOnSaveChanges();
		objTemplatesList
				.verTemplatesListPageIsDisplayed()
				.enterTextInPartNoField(objTemplates_data.partNum)
				.clickOnSearch()
				.verAllModifiedTemplateFields(objTemplates_data.bodyPart1,
						objTemplates_data.templateGroup,
						objTemplates_data.orientation, objTemplates_data.size,
						objTemplates_data.partNum,
						objTemplates_data.mirroredPN, "1");
		objTemplatesList.verAllModifiedTemplateFields(
				objTemplates_data.bodyPart1, objTemplates_data.templateGroup,
				objTemplates_data.orientation, objTemplates_data.size,
				objTemplates_data.partNum, objTemplates_data.mirroredPN, "2");
		objHome.clickOnLogOut();

		gstrResult = "PASS";
	}

}
