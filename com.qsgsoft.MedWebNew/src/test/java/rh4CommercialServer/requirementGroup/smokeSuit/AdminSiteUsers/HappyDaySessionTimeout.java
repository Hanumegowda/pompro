package rh4CommercialServer.requirementGroup.smokeSuit.AdminSiteUsers;

import dataObject.Login_data;
import dataObject.SecurityDefaults_data;
import dataObject.User_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.ControlPanel;
import page.DICOMSetting;
import page.Groups;
import page.Home;
import page.Locations;
import page.Login;
import page.Maintenance;
import page.Network;
import page.RISSettings;
import page.SecurityDefaults;
import page.ServiceStatus;
import page.SystemStatus;
import page.UserManagement;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDaySessionTimeout extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDaySessionTimeout() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that Admin pages load correctly after logging into the Site without 
                     any error when session is expired for all the pages in Admin Site.     
    'Precondition  :
    'Date          : 14-Dec-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that Admin pages load correctly after logging into the Site without any"
			+ " error when session is expired for all the pages in Admin Site.")
	public void testHappyDay152273() throws Exception {

		gstrTCID = "152273";
		gstrTO = "Verify that Admin pages load correctly after logging into the Site without any error"
				+ " when session is expired for all the pages in Admin Site.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		SecurityDefaults_data objSecurityDefaults_data = new SecurityDefaults_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Locations objLocations = new Locations(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Groups objGroups = new Groups(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		SecurityDefaults objSecurityDefaults = new SecurityDefaults(this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		Network objNetwork = new Network(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		Maintenance objMaintenance = new Maintenance(this.driver);
		SystemStatus objSystemStatus = new SystemStatus(this.driver);
		ServiceStatus objServiceStatus = new ServiceStatus(this.driver);
		DICOMSetting objDICOMSettings = new DICOMSetting(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut();
		
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage()
				.enterTextInAutoLogoutIdleField(
						objSecurityDefaults_data.idleTime);
		objAddUser.clickOnSaveChanges();

		/*Thread.sleep(70000);
		objUserManagement.clickOnAddUser();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objHome.clickOnGroups();
		Thread.sleep(70000);
		objGroups.clickOnAddGroup();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objHome.clickOnGroups();
		objGroups.verGroupsPage();*/

		objNavigationToSubMenus.clickOnLocations();
		Thread.sleep(80000);
		objLocations.clickOnAddLocation();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnLocations();
		objLocations.verLocationListPage();

		objNavigationToSubMenus.clickOnRISSettings();
		Thread.sleep(70000);
		objRISSettings.clickClinicsAndMachines();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnRISSettings();
		objRISSettings.verRISConfigurationSettingsPage();

		objNavigationToSubMenus.clickOnNetwork();
		Thread.sleep(70000);
		objNetwork.clickOnPortChecker();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnNetwork();
		objNetwork.clickOnPortChecker();

		objNavigationToSubMenus.clickOnControlPanel();
		Thread.sleep(70000);
		objControlPanel.clickOnTime();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings();

		objNavigationToSubMenus.clickOnMaintenance();
		Thread.sleep(70000);
		objMaintenance.clickOnRestoreButton();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnMaintenance();
		objMaintenance.verBackupSettingsPage();

		objNavigationToSubMenus.clickOnSystemStatus();
		Thread.sleep(70000);
		objSystemStatus.clickOnCPU();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnSystemStatus();
		objSystemStatus.verMemoryStatusPage();

		objNavigationToSubMenus.clickOnServiceStatus();
		Thread.sleep(70000);
		objServiceStatus.clickOnSNMP();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnServiceStatus();
		objServiceStatus.verServiceStatusPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		Thread.sleep(70000);
		objDICOMSettings.clickOnDestinations();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSettings.verLocalDICOMSettingsPage();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that Public pages load correctly after logging into the Site without 
                     any error when session is expired for all the pages in Public Site.     
    'Precondition  :
    'Date          : 15-Dec-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that Public pages load correctly after logging into the Site without "
			+ "any error when session is expired for all the pages in Public Site.")
	public void testHappyDay152274() throws Exception {

		gstrTCID = "152274";
		gstrTO = "Verify that Public pages load correctly after logging into the Site without any "
				+ "error when session is expired for all the pages in Public Site.";

		Login_data objLogin_data = new Login_data();
		SecurityDefaults_data objSecurityDefaults_data = new SecurityDefaults_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Locations objLocations = new Locations(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Groups objGroups = new Groups(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		SecurityDefaults objSecurityDefaults = new SecurityDefaults(this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		Network objNetwork = new Network(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		Maintenance objMaintenance = new Maintenance(this.driver);
		SystemStatus objSystemStatus = new SystemStatus(this.driver);
		ServiceStatus objServiceStatus = new ServiceStatus(this.driver);
		DICOMSetting objDICOMSettings = new DICOMSetting(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnSetUserDefaults();
		objSecurityDefaults.verSecurityDefaultsPage()
				.enterTextInAutoLogoutIdleField(
						objSecurityDefaults_data.idleTime);
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();

		Thread.sleep(80000);
		objHome.clickOnViewPatients();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objHome.clickOnGroups();
		Thread.sleep(70000);
		objGroups.clickOnAddGroup();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objHome.clickOnGroups();
		objGroups.verGroupsPage();

		objNavigationToSubMenus.clickOnLocations();
		Thread.sleep(90000);
		objLocations.clickOnAddLocation();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnLocations();
		objLocations.verLocationListPage();

		objNavigationToSubMenus.clickOnRISSettings();
		Thread.sleep(90000);
		objRISSettings.clickClinicsAndMachines();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnRISSettings();
		objRISSettings.verRISConfigurationSettingsPage();

		objNavigationToSubMenus.clickOnNetwork();
		Thread.sleep(80000);
		objNetwork.clickOnPortChecker();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnNetwork();
		objNetwork.clickOnPortChecker();

		objNavigationToSubMenus.clickOnControlPanel();
		Thread.sleep(80000);
		objControlPanel.clickOnTime();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings();

		objNavigationToSubMenus.clickOnMaintenance();
		Thread.sleep(80000);
		objMaintenance.clickOnRestoreButton();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnMaintenance();
		objMaintenance.verBackupSettingsPage();

		objNavigationToSubMenus.clickOnSystemStatus();
		Thread.sleep(80000);
		objSystemStatus.clickOnCPU();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnSystemStatus();
		objSystemStatus.verMemoryStatusPage();

		objNavigationToSubMenus.clickOnServiceStatus();
		Thread.sleep(80000);
		objServiceStatus.clickOnSNMP();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnServiceStatus();
		objServiceStatus.verServiceStatusPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		Thread.sleep(80000);
		objDICOMSettings.clickOnDestinations();
		objUserManagement.clickOnOkInAlertPopUp();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSettings.verLocalDICOMSettingsPage();

		gstrResult = "PASS";
	}


}
