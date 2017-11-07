package rh6CommercialServer.requirementGroup.smokeSuit.Users;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
import page.UserManagement;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.FileFormatConverter;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayUserInterfaceAndViewerOptionsInCSVFile extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayUserInterfaceAndViewerOptionsInCSVFile() throws Exception{
		
	}
	
	/*************************************************************************************
    'Description   : Verify that "User Interface" and "Viewer" options can be imported through CSV file.     
    'Precondition  :
    'Date          : 08-Sep-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that User Interface and Viewer options can be imported through CSV file.")
	public void testHappyDay125778() throws Exception {

		gstrTCID = "125778";
		gstrTO = "Verify that User Interface and Viewer options can be imported through CSV file.";

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
		Thread.sleep(5000);
		objAutoIT.DownloadTheReports1(autoitfilepath, backupfiledownloadpath1,
				"IEDownload.exe");
		Thread.sleep(10000);
		System.out.println(backupfiledownloadpath1);
		List<String[]> li = new ArrayList<String[]>();
		li.add(objUser_data.csvuser5);
		System.out.println(li.size() + " this is initial size");
		objFileFormatConverter.writeToCSVFile(li, backupfiledownloadpath1);
		objTemplatesList.clickOnBrowse(backupfiledownloadpath1);
		objLocations.clickOnImportCSV();
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.csvuser5[0])
				.clickOnSearch()
				.verUserWithACLGroup(
						objUser_data.csvuser5[0],
						objUser_data.csvuser5[5])
				.clickOnModifyUser(objUser_data.csvuser5[0])
				.verUserFirstName(objUser_data.csvuser5[2])
				.verUserMiddleName(objUser_data.csvuser5[3])
				.verUserLastName(objUser_data.csvuser5[4])
				.verFax(objUser_data.csvuser5[11])
				.verDoctorID(objUser_data.csvuser5[12])
				.verPhone(objUser_data.csvuser5[10])
				.verEmailID(objUser_data.csvuser5[8])
				.verWithActiveXFreeRadioBtnSelected()
				.verWebViewerRadioBtnSelected();
		System.out.println(objUser_data.csvuser5[0]);

		gstrResult = "PASS";

	}

}
