package rh6CommercialServer.requirementGroup.smokeSuit.Maintenance;

import java.io.File;
import java.util.Properties;

import dataObject.Login_data;
import dataObject.Maintenance_data;
import dataObject.PathData;
import dataObject.User_data;
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

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayRestore extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayRestore() throws Exception {
		
	}
	
	/*************************************************************************************
    'Description   : Verify that the backup file saved to the Remote server are displayed
                     in the 'Restore' page of Remote Server.     
    'Precondition  :
    'Date          : 30-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the backup file saved to the Remote server are displayed"
			+ " in the 'Restore' page of Remote Server.")
	public void testHappyDay68296() throws Exception {

		gstrTCID = "68296";
		gstrTO = "Verify that the backup file saved to the Remote server are displayed in the"
				+ " 'Restore' page of Remote Server.";

		Login_data objLogin_data = new Login_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Maintenance_data objMaintenance_data = new Maintenance_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		MedwebSecureTunnel objMedwebSecureTunnel = new MedwebSecureTunnel(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		Maintenance objMaintenance = new Maintenance(this.driver);

		String date = objDts.getCurrentDate("yyyy.MM.dd");
		String time = objDts.timeNow("HH");
		String str = date + "-" + time;
		System.out.println(str);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime1();
		String strappdate = objControlPanel.getCurrentDate();
		String strappmonth = objControlPanel.getCurrentMonth();
		String strappyear = objControlPanel.getCurrentYear();
		String strapphour = objControlPanel.getCurrentHourIn24HrFrmt();
		//2017.01.11-11
		String reqdate = objDts.converDateFormat(strappyear+"."+strappmonth+"."+strappdate+"-"+strapphour, "yyyy.MMM.DD-HH", "yyyy.MM.DD-HH");
		System.out.println(reqdate+ " ohohkkjkjjjkjjkjkjkjjkjkjkjjkj");
		objNavigationToSubMenus.clickOnControlPanelForSecondTime();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();
		objMedwebSecureTunnel.clickOnGenerateButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		String str1 = objMedwebSecureTunnel
				.getTextFromLocalhostPublicKeySection();
		String str3 = str1.trim();
		System.out.println(str3);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
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
		objHome.launchApplication(objLogin_data.strAppURL1);
		objHome.verHomePage().clickOnAdminSite();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnMedwebSecureTunnelParametersLink();

		objControlPanel.clickOnAdd();
		objMedwebSecureTunnel.enterTextInRemoteHostPublicKeySection(str4);
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnMaintenance1();
		objMaintenance.selectOptionInTypeOfTransportDropDown(
				objMaintenance_data.strTransportRemoteSecureTunnel)
				.enterTextInRemoteServerAddress(
						objMaintenance_data.backUpServer1);
		objAddUser.clickOnSaveChanges();
		objMaintenance.clickOnStartBackUpButton();
		Thread.sleep(10000);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnMaintenance();
		objMaintenance.clickOnRestoreButton();
		objMaintenance.verBackUpFileFromRemoteServers(/*date*/reqdate, "");
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the Backup file stored in the Local System can be restored
                     on Medweb Server under 'File Restore' section.     
    'Precondition  :
    'Date          : 01-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the Backup file stored in the Local System can be restored"
			+ " on Medweb Server under 'File Restore' section.")
	public void testHappyDay68286() throws Exception {

		gstrTCID = "68286";
		gstrTO = "Verify that the Backup file stored in the Local System can be restored on Medweb "
				+ "Server under 'File Restore' section.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Maintenance_data objMaintenance_data = new Maintenance_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		Maintenance objMaintenance = new Maintenance(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		String strTimeText = objDts.getCurrentDate(objPathData.dateFormat1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + strTimeText;
		System.out.println(backupfiledownloadpath1);

		String autoit = pathProps.getProperty(objPathData.strAutoITPath);
		File autoitfile = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile.toString();
		String date = objDts.getCurrentDate("yyyy.MM.dd");
		String time = objDts.timeNow("HH");
		String str = date + "-" + time;
		System.out.println(str);

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();

		objNavigationToSubMenus.clickOnMaintenance1();
		objMaintenance.selSelectUnselectAllCheckBox()
				.selectOptionInTypeOfTransportDropDown(
						objMaintenance_data.strDirectOutput);
		objAddUser.clickOnSaveChanges();
		objMaintenance.clickOnStartBackUpButton();
		Thread.sleep(10000);
		System.out.println(autoitfilepath + 1);
		System.out.println(backupfiledownloadpath1 + 2);
		Thread.sleep(5000);
		objAutoIT.DownloadTheReports1(autoitfilepath, backupfiledownloadpath1,
				"Marr.exe");
		Thread.sleep(10000);
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnMaintenance1();
		objMaintenance.clickOnRestoreButton1().clickOnBrowseButton(
				backupfiledownloadpath1 + ".qub");
		objMaintenance.clickOnRestoreBackUpFileButton()
				.clickOnRestoreBackUpFileButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(10000);
		objNavigationToSubMenus.clickOnUserForSecondTime();
		try{
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.strNewUserName)
				.clickOnSearch().verUserNotFoundErrMsg();
		}
		catch(NoSuchElementException e){
			objUserManagement.verifyUserWithRedBallandUserNeverLoggedInIsNotDisplayed(objUser_data.strNewUserName);	
		}
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Veirfy that the backup file saved is restored when 'Restore this entry' 
                     icon is clicked next to the backup file.     
    'Precondition  :
    'Date          : 05-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Veirfy that the backup file saved is restored when 'Restore this entry'"
			+ " icon is clicked next to the backup file.")
	public void testHappyDay68292() throws Exception {

		gstrTCID = "68292";
		gstrTO = "Veirfy that the backup file saved is restored when 'Restore this entry' icon is"
				+ " clicked next to the backup file .";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Maintenance_data objMaintenance_data = new Maintenance_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		Maintenance objMaintenance = new Maintenance(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);

		String date = objDts.getCurrentDate("yyyy.MM.dd");
		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage()
				.verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime1();
		String str = date + "-";
		objNavigationToSubMenus.clickOnMaintenance1();
		objMaintenance.selSelectUnselectAllCheckBox()
				.selectOptionInTypeOfTransportDropDown(
						objMaintenance_data.strTransportLocalStorage);

		objAddUser.clickOnSaveChanges();
		objMaintenance.clickOnStartBackUpButton();
		Thread.sleep(10000);
		objNavigationToSubMenus.clickOnUserForSecondTime();
		objUserManagement.clickOnAddUser();
		objAddUser.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strNewUserName).clickOnSearch();
			objUserManagement
					.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserName);
		} catch (NoSuchElementException e) {
			objUserManagement
					.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserName);
		}
		objNavigationToSubMenus.clickOnMaintenance1();
		objMaintenance.clickOnRestoreButton1();
		Thread.sleep(10000);
		objMaintenance.clickOnRestoreConfiguration(str);
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(10000);
		objNavigationToSubMenus.clickOnUserForSecondTime();
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strNewUserName).clickOnSearch();
			objUserManagement.verUserNotFoundErrMsg();
		} catch (NoSuchElementException e) {
			objUserManagement
					.verifyUserWithRedBallandUserNeverLoggedInIsNotDisplayed(objUser_data.strNewUserName);
		}
		objHome.clickOnLogOut92();

		gstrResult = "PASS";

	}

}
