package rh4CommercialServer.requirementGroup.smokeSuit.DICOMSettings;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.ControlPanel;
import page.DICOMSetting;
import page.Destinations;
import page.Home;
import page.Login;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;

public class HappyDayDICOMDevicesChecker extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayDICOMDevicesChecker() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that following columns are displayed in the 'DICOM device checker'
                     page 1. AE Title 2. IP Address 3. Port 4. Latest successfully response.     
    'Precondition  :
    'Date          : 08-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that following columns are displayed in the 'DICOM device checker'"
			+ " page 1. AE Title 2. IP Address 3. Port 4. Latest successfully response.")
	public void testHappyDay68383() throws Exception {

		gstrTCID = "68383";
		gstrTO = "Verify that following columns are displayed in the 'DICOM device checker'"
				+ " page 1. AE Title 2. IP Address 3. Port 4. Latest successfully response.";

		Login_data objLogin_data = new Login_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);

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
		String req = strappyear + "-" + strappmonth + "-" + strappdate + "-"
				+ strapphour;
		System.out.println(req);
		String date1 = objDts
				.converDateFormat(req, "yyyy-MMM-dd", "MM.dd.yyyy");
		System.out.println(date1);
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnDevicesCheckerTab()
				.verDICOMDevicesCheckerResultsPage().verAETitleColumn()
				.verIPAddressColumn().verPortColumn()
				.verLatestSuccessfulResponseColumn(date1);
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that the DICOM devices added in destination is displayed in "DICOM Settings >
                     DICOM device checker result" page when 'Enable DICOM Devices Checker' is enabled.     
    'Precondition  :
    'Date          : 05-Dec-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the DICOM devices added in destination is displayed in DICOM Settings > "
			+ "DICOM device checker result page when 'Enable DICOM Devices Checker' is enabled.")
	public void testHappyDay68378() throws Exception {

		gstrTCID = "68378";
		gstrTO = "Verify that the DICOM devices added in destination is displayed in DICOM Settings >"
				+ " DICOM device checker result page when 'Enable DICOM Devices Checker' is enabled.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Date_Time_settings dts = new Date_Time_settings();
		Home objHome = new Home(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);

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

		objNavigationToSubMenus.clickOnDICOMSettings();

		// rh6(92) server
		objDICOMSetting.clickOnDestinations();
		objDestinations.clickOnAdd().verDestinationEditorPage();
		objDestinations.selectGenericStorageSCPCheckBox()
				.selectGenericStorageSCUCheckBox().selectMedwebDeviceCheckBox()
				.selectMitraReportSCPCheckBox().selectMitraReportSCUCheckBox()
				.selectRetrievePatientSCPCheckBox()
				.selectRetrievePatientSCUCheckBox()
				.selectRetrievePatientStudySCPCheckBox()
				.selectRetrievePatientStudySCUCheckBox()
				.selectRetrieveStudySCPCheckBox()
				.selectRetrieveStudySCUCheckBox();
		objDestinations.enterTextInAETitleField(objDICOMSettings_data.aETitle1)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddress)
				.enterTextInLabelField(objDICOMSettings_data.label)
				.selDICOMProtocolRadioButton()
				.selectPlaceStudiesSandboxCheckBox()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();

		// rhel4(91) server
		objDestinations.clickOnAdd().verDestinationEditorPage();
		objDestinations.selectGenericStorageSCPCheckBox()
				.selectGenericStorageSCUCheckBox().selectMedwebDeviceCheckBox()
				.selectMitraReportSCPCheckBox().selectMitraReportSCUCheckBox()
				.selectRetrievePatientSCPCheckBox()
				.selectRetrievePatientSCUCheckBox()
				.selectRetrievePatientStudySCPCheckBox()
				.selectRetrievePatientStudySCUCheckBox()
				.selectRetrieveStudySCPCheckBox()
				.selectRetrieveStudySCUCheckBox();
		objDestinations
				.enterTextInAETitleField(objDICOMSettings_data.aETitleFor91)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddressfor91)
				.enterTextInLabelField(objDICOMSettings_data.labelfor91)
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();

		// rhel6(94) server
		objDestinations.clickOnAdd().verDestinationEditorPage();
		objDestinations.selectGenericStorageSCPCheckBox()
				.selectGenericStorageSCUCheckBox().selectMedwebDeviceCheckBox()
				.selectMitraReportSCPCheckBox().selectMitraReportSCUCheckBox()
				.selectRetrievePatientSCPCheckBox()
				.selectRetrievePatientSCUCheckBox()
				.selectRetrievePatientStudySCPCheckBox()
				.selectRetrievePatientStudySCUCheckBox()
				.selectRetrieveStudySCPCheckBox()
				.selectRetrieveStudySCUCheckBox();
		objDestinations
				.enterTextInAETitleField(objDICOMSettings_data.aETitleFor94)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddressfor94)
				.enterTextInLabelField(objDICOMSettings_data.labelfor94)
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnDICOMDevicesCheckerParametersLink()
				.verDICOMDevicesCheckerSettingsPage()
				.selEnableDICOMDevicesCheckerCheckbox().clickOnSaveChanges();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting
				.clickOnDevicesCheckerTab()
				.verDICOMDevicesCheckerResultsPage()
				.verDICOMDevicesCheckerResultPageWithLatestResponse(str4,
						objDICOMSettings_data.ipAddress)
				.verDICOMDevicesCheckerResultPageWithLatestResponse(str4,
						objDICOMSettings_data.ipAddressfor91)
				.verDICOMDevicesCheckerResultPageWithLatestResponse(str4,
						objDICOMSettings_data.ipAddressfor94);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

}
