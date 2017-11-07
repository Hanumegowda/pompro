package rh4CommercialServer.requirementGroup.smokeSuit.Users;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dataObject.Login_data;
import dataObject.PathData;
import dataObject.User_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.AutoIT;
import page.Home;
import page.Locations;
import page.Login;
import page.TemplatesList;
import page.UserManagement;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.FileFormatConverter;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayImportFromCSV extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayImportFromCSV() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that multiple user detials added to the CSV template is imported and 
                     displayed in the Users Page when imported in the "Import Users from CSV" page.     
    'Precondition  :
    'Date          : 16-Jun-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that multiple user detials added to the CSV template is imported and "
			+ "displayed in the Users Page when imported in the Import Users from CSV page.")
	public void testHappyDay114205() throws Exception {

		gstrTCID = "114205";
		gstrTO = "Verify that multiple user detials added to the CSV template is imported and displayed in"
				+ " the Users Page when imported in the Import Users from CSV page.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Locations objLocations = new Locations(this.driver);
		Login objLogin = new Login(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		TemplatesList objTemplatesList = new TemplatesList(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + objUser_data.strFile
				+ ".csv";
		String autoit = pathProps.getProperty(objPathData.strAutoITPath);
		File autoitfile = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnImportFromCSV().clickOnDownloadCSVTemplate();
		System.out.println(backupfiledownloadpath1 + " this is final path");
		Thread.sleep(5000);
		objAutoIT.DownloadTheReports1(autoitfilepath, backupfiledownloadpath1,
				"IEDownload.exe");
		Thread.sleep(6000);
		System.out.println(backupfiledownloadpath1);
		List<String[]> li = new ArrayList<String[]>();
		li.add(objUser_data.csvuser1);
		li.add(objUser_data.csvuser2);
		li.add(objUser_data.csvuser3);
		System.out.println(li.size() + " this is initial size");
		Thread.sleep(5000);
		objFileFormatConverter.writeToCSVFile(li, backupfiledownloadpath1);
		objTemplatesList.clickOnBrowse(backupfiledownloadpath1);
		objLocations.clickOnImportCSV();
		objNavigationToSubMenus.clickOnUser();
		String[] user = { objUser_data.csvuser1[0], objUser_data.csvuser2[0],
				objUser_data.csvuser3[0] };
		String[] grp = {
				objUser_data.csvuser1[(objUser_data.csvuser1.length) - 1],
				objUser_data.csvuser2[(objUser_data.csvuser2.length) - 1],
				objUser_data.csvuser3[(objUser_data.csvuser3.length) - 1] };
		for (int i = 0; i < user.length; i++) {
			try {
				objUserManagement.enterTextInUserNameSearchField(user[i])
						.clickOnSearch();
			} catch (NoSuchElementException e) {
				System.out.println("");
			}
			objUserManagement.verUserWithACLGroup(user[i], grp[i]);
		}
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that Users are imported successfully from the CSV Template in "Import 
                     Users from CSV" page when spaces are specified in Username field.     
    'Precondition  :
    'Date          : 12-Sep-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Users are imported successfully from the CSV Template in Import "
			+ "Users from CSV page when spaces are specified in Username field.")
	public void testHappyDay147076() throws Exception {

		gstrTCID = "147076";
		gstrTO = "Verify that Users are imported successfully from the CSV Template in Import Users "
				+ "from CSV page when spaces are specified in Username field.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Locations objLocations = new Locations(this.driver);
		Login objLogin = new Login(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		TemplatesList objTemplatesList = new TemplatesList(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + objUser_data.strFile
				+ ".csv";
		String autoit = pathProps.getProperty(objPathData.strAutoITPath);
		File autoitfile = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnImportFromCSV().clickOnDownloadCSVTemplate();
		System.out.println(backupfiledownloadpath1 + " this is final path");
		Thread.sleep(5000);
		objAutoIT.DownloadTheReports1(autoitfilepath, backupfiledownloadpath1,
				"IEDownload.exe");
		Thread.sleep(6000);
		System.out.println(backupfiledownloadpath1);
		List<String[]> li = new ArrayList<String[]>();
		li.add(objUser_data.csvuser1);
		System.out.println(li.size() + " this is initial size");
		Thread.sleep(5000);
		objFileFormatConverter.writeToCSVFile(li, backupfiledownloadpath1);
		objTemplatesList.clickOnBrowse(backupfiledownloadpath1);
		objLocations.clickOnImportCSV();
		objNavigationToSubMenus.clickOnUser();
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.csvuser1[0]).clickOnSearch();
		} catch (NoSuchElementException e) {
			System.out.println("");
		}
		objUserManagement.verUserWithACLGroup(objUser_data.csvuser1[0],
				objUser_data.csvuser1[(objUser_data.csvuser1.length) - 1]);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

}