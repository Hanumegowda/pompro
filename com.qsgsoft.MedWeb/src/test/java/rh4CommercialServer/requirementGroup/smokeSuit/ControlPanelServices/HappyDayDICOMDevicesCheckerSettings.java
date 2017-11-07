package rh4CommercialServer.requirementGroup.smokeSuit.ControlPanelServices;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.ControlPanel;
import page.DICOMSetting;
import page.Home;
import page.Login;

import org.testng.annotations.Test;

import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayDICOMDevicesCheckerSettings extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayDICOMDevicesCheckerSettings() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that DICOM Devices checker displays the result in the "DICOM Settings >
                     DICOM Devices Checker Results" page when "Enable DICOM Devices Checker" is enabled
                     in "DICOM Devices Checker Settings" page.     
    'Precondition  :
    'Date          : 12-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that DICOM Devices checker displays the result in the DICOM Settings"
			+ " > DICOM Devices Checker Results page when Enable DICOM Devices Checker is enabled in"
			+ " DICOM Devices Checker Settings page.")
	public void testHappyDay61440() throws Exception {

		gstrTCID = "61440";
		gstrTO = "Verify that DICOM Devices checker displays the result in the DICOM Settings >"
				+ " DICOM Devices Checker Results page when Enable DICOM Devices Checker is enabled"
				+ " in DICOM Devices Checker Settings page.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Date_Time_settings dts = new Date_Time_settings();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime();
		String str = objControlPanel.getCurrentDate();
		String str1 = objControlPanel.getCurrentMonth();
		String str2 = objControlPanel.getCurrentYear();
		objControlPanel.getCurrentHourIn24HrFrmt();
		String str3 = str + str1 + str2;
		System.out.println(str3);
		String str4 = dts.converDateFormat(str3, "ddMMMyyyy", "MM.dd.yyyy");
		System.out.println(str4);
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings()
				.clickOnDICOMDevicesCheckerParametersLink()
				.verDICOMDevicesCheckerSettingsPage()
				.selEnableDICOMDevicesCheckerCheckbox();
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnDevicesCheckerTab()
				.verDICOMDevicesCheckerResultPageWithLatestResponse(str4,
						objDICOMSettings_data.ipAddress);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

}
