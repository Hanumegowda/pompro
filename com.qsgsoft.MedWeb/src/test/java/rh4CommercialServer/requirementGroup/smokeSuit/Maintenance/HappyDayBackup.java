package rh4CommercialServer.requirementGroup.smokeSuit.Maintenance;

import java.io.File;
import java.util.Properties;

import dataObject.Login_data;
import dataObject.Maintenance_data;
import dataObject.PathData;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.ControlPanel;
import page.Home;
import page.Login;
import page.Maintenance;
import page.MedwebSecureTunnel;
import page.UserManagement;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayBackup extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayBackup() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the backup file is created and stored in the Medweb Server 
                     when 'Local Storage' is selected in type of transport.     
    'Precondition  :
    'Date          : 29-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the backup file is created and stored in the Medweb Server"
			+ " when 'Local Storage' is selected in type of transport.")
	public void testHappyDay68278() throws Exception {

		gstrTCID = "68278";
		gstrTO = "Verify that the backup file is created and stored in the Medweb Server when "
				+ "'Local Storage' is selected in type of transport.";

		Login_data objLogin_data = new Login_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Maintenance_data objMaintenance_data = new Maintenance_data();

		Home objHome = new Home(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		Maintenance objMaintenance = new Maintenance(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime();
		String strappdate = objControlPanel.getCurrentDate();
		String strappmonth = objControlPanel.getCurrentMonth();
		String strappyear = objControlPanel.getCurrentYear();
		String strapphour = objControlPanel.getCurrentHourIn24HrFrmt();
		String strappminute = objControlPanel.getCurrentMinute();
		int i = Integer.parseInt(strappminute);
		int i1 = i + 1;
		String req2 = i1 + "";
		String req = strappyear + "-" + strappmonth + "-" + strappdate;
		System.out.println(req);
		String date1 = objDts.converDateFormat(req, "yyy-MMM-dd", "yyyy.MM.dd");
		System.out.println(date1);
		String req1 = date1 + "-" + strapphour + ":" + strappminute;
		System.out.println(req1 + " " + req2 + "reffff");
		objNavigationToSubMenus.clickOnMaintenance();
		objMaintenance.selectOptionInTypeOfTransportDropDown(
				objMaintenance_data.strTransportLocalStorage)
				.enterTextInNumberOfBackups(objMaintenance_data.strBackUpNum);
		objAddUser.clickOnSaveChanges();
		objMaintenance.clickOnStartBackUpButton();
		Thread.sleep(20000);
		objMaintenance.clickOnRestoreButton();
		objMaintenance.verBackUpFileFromHost(req1, req2);
		objHome.clickOnLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
    'Description   : Verify that the backup file is created and saved in the Remote server when
                     'Remote – Medweb Secure Tunnel' option is selected under 'Type of Transport'.     
    'Precondition  :
    'Date          : 30-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the backup file is created and saved in the Remote server"
			+ " when 'Remote – Medweb Secure Tunnel' option is selected under 'Type of Transport'.")
	public void testHappyDay68279() throws Exception {

		gstrTCID = "68279";
		gstrTO = "Verify that the backup file is created and saved in the Remote server when "
				+ "'Remote – Medweb Secure Tunnel' option is selected under 'Type of Transport'.";

		Login_data objLogin_data = new Login_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Maintenance_data objMaintenance_data = new Maintenance_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		MedwebSecureTunnel objMedwebSecureTunnel = new MedwebSecureTunnel(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		Maintenance objMaintenance = new Maintenance(this.driver);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime();
		String strappdate = objControlPanel.getCurrentDate();
		String strappmonth = objControlPanel.getCurrentMonth();
		String strappyear = objControlPanel.getCurrentYear();
		String strapphour = objControlPanel.getCurrentHourIn24HrFrmt();
		String strappminute = objControlPanel.getCurrentMinute();
		int i = Integer.parseInt(strappminute);
		int i1 = i + 1;
		String req2 = i1 + "";
		String req = strappyear + "-" + strappmonth + "-" + strappdate;
		System.out.println(req);
		String date1 = objDts.converDateFormat(req, "yyy-MMM-dd", "yyyy.MM.dd");
		System.out.println(date1);
		String req1 = date1 + "-" + strapphour;
		System.out.println(req1 + "ref");
		objNavigationToSubMenus.clickOnControlPanel()/*
													 * clickOnControlPanelForSecondTime
													 * ()
													 */;
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objMedwebSecureTunnel.clickOnGenerateButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		String str1 = objMedwebSecureTunnel
				.getTextFromLocalhostPublicKeySection();
		String str3 = str1.trim();
		System.out.println(str3);
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objControlPanel.clickOnAdd();
		objMedwebSecureTunnel.enterTextInRemoteHostPublicKeySection(str3);
		objAddUser.clickOnSaveChanges();
		objMedwebSecureTunnel.clickOnGenerateButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		String str2 = objMedwebSecureTunnel
				.getTextFromLocalhostPublicKeySection();
		String str4 = str2.trim();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objControlPanel.clickOnAdd();
		objMedwebSecureTunnel.enterTextInRemoteHostPublicKeySection(str4);
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnMaintenance();
		objUserManagement.clickOnClearLog();
		objMaintenance.selectOptionInTypeOfTransportDropDown(
				objMaintenance_data.strTransportRemoteSecureTunnel)
				.enterTextInRemoteServerAddress(
						objMaintenance_data.backUpServer);
		objAddUser.clickOnSaveChanges();
		Thread.sleep(10000);
		objMaintenance.clickOnStartBackUpButton();
		Thread.sleep(10000);
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.verHomePage().clickOnAdminSite();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnMaintenance1();
		objMaintenance.clickOnRestoreButton1();
		objMaintenance.verBackUpFileFromRemoteServers(req1, "");
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the Backup file is created and user can save to the Local 
                     System when 'Direct Output' is selected in 'Type of transport'.     
    'Precondition  :
    'Date          : 25-Aug-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Backup file is created and user can save to the Local "
			+ "System when 'Direct Output' is selected in 'Type of transport'.")
	public void testHappyDay105527() throws Exception {

		gstrTCID = "105527";
		gstrTO = "Verify that the Backup file is created and user can save to the Local System "
				+ "when 'Direct Output' is selected in ''Type of transport'.";

		Login_data objLogin_data = new Login_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Maintenance_data objMaintenance_data = new Maintenance_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		Maintenance objMaintenance = new Maintenance(this.driver);
		String strTimeText = objDts.getCurrentDate(objPathData.dateFormat1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + strTimeText;
		System.out.println(backupfiledownloadpath1);

		String autoit = pathProps
				.getProperty(objPathData./* autoItFilePath2 */strAutoITPath);
		File autoitfile = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile.toString();
		String date = objDts.getCurrentDate("yyyy.MM.dd");
		String time = objDts.timeNow("HH");
		String str = date + "-" + time;
		System.out.println(str);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnMaintenance();
		objUserManagement.clickOnClearLog();
		objMaintenance
				.selMedwebSpecificConfigurationCheckBox()
				.selMedwebDatabaseDumpCheckBox()
				.deSelEnableScheduledBackupsCheckBox()
				.selectOptionInTypeOfTransportDropDown(
						objMaintenance_data.strDirectOutput);
		objAddUser.clickOnSaveChanges();
		objMaintenance.clickOnStartBackUpButton();
		Thread.sleep(15000);
		System.out.println(autoitfilepath + 1);
		System.out.println(backupfiledownloadpath1 + 2);
		Capabilities c = ((RemoteWebDriver) this.driver).getCapabilities();
		String br = c.getBrowserName().toLowerCase();
		System.out.println(br);
		if (br.equalsIgnoreCase("internet explorer")) {
			Thread.sleep(5000);
			objAutoIT.DownloadTheReports1(autoitfilepath,
					backupfiledownloadpath1, "Marr.exe");
			Thread.sleep(15000);
			objCommonFunctions.verDownloadedFile(backupfiledownloadpath1
					+ ".qub");
			System.out.println(backupfiledownloadpath1 + ".qub");
		} else {
			Thread.sleep(10000);
			objCommonFunctions.verDownloadedFile(bp2);
		}
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

}
