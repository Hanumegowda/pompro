package rh6CommercialServer.requirementGroup.smokeSuit.Network;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import module.NavigationToSubMenus;
import page.AdministratorSite;
import page.DICOMSetting;
import page.Destinations;
import page.Home;
import page.Login;
import page.Network;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayPortChecker extends TestNG_UI_EXTENSIONSForOneBrowser {
	public HappyDayPortChecker() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the services accessibility from host is shown as ''Available'' in
                     green color when correct working destination is selected in the'Select Destination' dropdown.     
    'Precondition  :
    'Date          : 05-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the services accessibility from host is shown as 'Available'"
			+ " in green color when correct working destination is selected in the 'Select Destination' dropdown.")
	public void testHappyDay68184() throws Exception {

		gstrTCID = "68184";
		gstrTO = "Verify that the services accessibility from host is shown as 'Available' in green color"
				+ " when correct working destination is selected in the 'Select Destination' dropdown.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		Network objNetwork = new Network(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		Login objLogin = new Login(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.verLocalDICOMSettingsPage().clickOnDestinations();
		objDestinations.clickOnAdd().verDestinationEditorPage();
		objDestinations.selectGenericStorageSCPCheckBox()
				.selectGenericStorageSCUCheckBox().selectMedwebDeviceCheckBox()
				.selectMitraReportSCPCheckBox().selectMitraReportSCUCheckBox()
				.selectPlaceStudiesSandboxCheckBox()
				.selectReceiveDSMECheckBox().selectRetrievePatientSCPCheckBox()
				.selectRetrievePatientSCUCheckBox()
				.selectRetrievePatientStudySCPCheckBox()
				.selectRetrievePatientStudySCUCheckBox()
				.selectRetrieveStudySCPCheckBox()
				.selectRetrieveStudySCUCheckBox();
		objDestinations.enterTextInAETitleField(objDICOMSettings_data.aETitle1)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddress)
				.enterTextInLabelField(objDICOMSettings_data.label);
		objDestinations.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnNetwork();
		objNetwork.clickOnPortChecker()
				.selectDestination1(objDICOMSettings_data.aETitle1)
				.clickOnCheckPort();
		objNetwork.verAvailabilityOfDICOMService()
				.verAvailabilityOfSecureTunnelService()
				.verAvailabilityOfSSHService();

		gstrResult = "PASS";

	}

}
