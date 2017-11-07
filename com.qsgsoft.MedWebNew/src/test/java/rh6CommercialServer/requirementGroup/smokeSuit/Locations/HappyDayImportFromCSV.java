package rh6CommercialServer.requirementGroup.smokeSuit.Locations;

import java.io.File;
import java.util.Properties;

import dataObject.Locations_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.User_data;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.AutoIT;
import page.Home;
import page.Locations;
import page.Login;
import page.TemplatesList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.FileFormatConverter;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayImportFromCSV extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayImportFromCSV() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that multiple location detials added to the CSV template is imported 
                     and displayed in the Locations Page when imported in the 'Import Locations from CSV' page.     
    'Precondition  :
    'Date          : 07-Jun-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that multiple location detials added to the CSV template is imported "
			+ "and displayed in the Locations Page when imported in the 'Import Locations from CSV' page.")
	public void testHappyDay114204() throws Exception {

		gstrTCID = "114204";
		gstrTO = "Verify that multiple location detials added to the CSV template is imported and displayed "
				+ "in the Locations Page when imported in the 'Import Locations from CSV' page.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		Locations_data objLocations_data = new Locations_data();
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
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
		System.out.println(backupfiledownloadpath1 + " ????????????");

		String autoit = pathProps.getProperty(objPathData.strAutoITPath);
		File autoitfile = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnLocations();
		objLocations.verLocationListPage().clickOnImportFromCSV();
		Thread.sleep(5000);
		objLocations.clickOnDownloadCSVTemplateLink();
		System.out.println("hiii");
		Thread.sleep(5000);
		objAutoIT.DownloadTheReports1(autoitfilepath, backupfiledownloadpath1,
				"IEDownload.exe");
		Thread.sleep(10000);
		System.out.println(backupfiledownloadpath1);
		String[] str = (objLocations_data.loc1).split(";");
		System.out.println(str[0] + " wow");
		System.out.println((str[7]).trim() + " wow1");
		String[] str1 = (objLocations_data.loc2).split(";");
		String[] str2 = (objLocations_data.loc3).split(";");
		String[] str3 = (objLocations_data.loc4).split(";");
		objFileFormatConverter.writetocsv(backupfiledownloadpath1,
				objLocations_data.loc, objLocations_data.loc1,
				objLocations_data.loc2, objLocations_data.loc3,
				objLocations_data.loc4);
		objTemplatesList.clickOnBrowse(backupfiledownloadpath1);
		objLocations.clickOnImportCSV().clickOnBack()
				.verLocationIsDisplayed(str[0], (str[7]).trim())
				.verLocationIsDisplayed(str1[0], (str1[7]).trim())
				.verLocationIsDisplayed(str2[0], (str2[7]).trim())
				.verLocationIsDisplayed(str3[0], (str3[7]).trim());

		gstrResult = "PASS";

	}

}
