package rhel4DiacapServer.requirementGroup.smokeSuit.ControlPanelLocalsiteInfo;

import java.io.File;
import java.util.Properties;

import dataObject.ControlPanel_data;
import dataObject.Login_data;
import dataObject.PathData;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.ControlPanel;
import page.Home;
import page.LocalSiteInformation;
import page.Login;
import page.PublicSite;
import page.UserManagement;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayLocalSiteInformationPage extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayLocalSiteInformationPage() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that Home page Note is displayed in the Home Page (Please find the
                     attached file) when Reset Public page button is clicked in Local Site Info.     
    'Precondition  :
    'Date          : 24-Aug-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Home page Note is displayed in the Home Page (Please find the attached file)"
			+ " when Reset Public page button is clicked in Local Site Info.")
	public void testHappyDay128538() throws Exception {

		gstrTCID = "128538";
		gstrTO = "Verify that Home page Note is displayed in the Home Page (Please find the attached file)"
				+ " when Reset Public page button is clicked in Local Site Info.";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		PublicSite objPublicSite = new PublicSite(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		LocalSiteInformation objLocalSiteInformation = new LocalSiteInformation(
				this.driver);
		Login objLogin = new Login(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnLocalSiteInfo();
		objLocalSiteInformation.verLocalSiteInfoPage()
				.clickOnResetPublicPageButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(3000);
		objLocalSiteInformation.verTextInWarningBannerField("")
				.verTextInLoginPromptWarningBannerField("")
				.verTextInGeneralInformationField("")
				.verTextInAddressDrivingDirectionsField("");
		objNavigationToSubMenus.clickOnPublicSite();
		objPublicSite.verHomePageNote();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that 'admin' can access and modify the Control Panel >Local Site Info page.     
    'Precondition  :
    'Date          : 29-Jul-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that 'admin' can access and modify the Control Panel >Local Site Info page.")
	public void testHappyDay68274() throws Exception {

		gstrTCID = "68274";
		gstrTO = "Verify that 'admin' can access and modify the Control Panel >Local Site Info page.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ControlPanel_data objControlPanel_data = new ControlPanel_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		PublicSite objPublicSite = new PublicSite(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		LocalSiteInformation objLocalSiteInformation = new LocalSiteInformation(
				this.driver);
		Login objLogin = new Login(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String filePDFDownloadPath = pathProps
				.getProperty(objPathData.strLogoImageJpegFile);

		File logoimagefile = new File(System.getProperty("user.dir")
				+ filePDFDownloadPath);
		String strlogoimagefilePath = logoimagefile.toString();
		System.out.println(strlogoimagefilePath);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnLocalSiteInfo();
		objLocalSiteInformation.verLocalSiteInfoPage()
				.clickOnResetPublicPageButton();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(3000);
		objLocalSiteInformation
				.selWarningBannerEnableCheckBox()
				.enterTextInWarningBanner(objControlPanel_data.strWarningBanner)
				.selLoginPromptWarningBannerEnableCheckBox()
				.enterTextInLoginPromptWarningBanner(
						objControlPanel_data.strLoginPromptWarningBanner)
				.selFacilityLogoEnableCheckBox()
				.clickOnBrowseOfLogoImage(strlogoimagefilePath)
				.selMedicalLicensesListCheckBox()
				.enterLinkName(objControlPanel_data.strLinkName)
				.selGeneralInformationEnableCheckBox()
				.enterTextInContacts(objControlPanel_data.strContact)
				.enterTextInBusinessHours(objControlPanel_data.strBusinessHr)
				.enterTextInAnnouncements(objControlPanel_data.strAnnouncement)
				.selAllCheckBoxUnderButtons()
				.enterTextInEmailRequestsTo(objControlPanel_data.strMail)
				.selAddressAndDrivingDirectionsEnableCheckBox()
				.enterTextInHowToReach(objControlPanel_data.strHowToReach)
				.selCountry(objControlPanel_data.strCountry)
				.enterTextInStreetAddress(objControlPanel_data.strStreetAddress)
				.enterTextInCityState(objControlPanel_data.strCity);
		objAddUser.clickOnSaveChanges();
		Thread.sleep(3000);

		objNavigationToSubMenus.clickOnPublicSite();
		System.out.println(objControlPanel_data.strStreetAddress + " "
				+ objControlPanel_data.strCity);
		objPublicSite
				.verWarningBannerText(objControlPanel_data.strWarningBanner)
				.verLogoImageDisplaying()
				.verLocalSiteInfoDisplaying(objControlPanel_data.strContact,
						objControlPanel_data.strBusinessHr,
						objControlPanel_data.strAnnouncement)
				.verLinkNameText(objControlPanel_data.strLinkName)
				.verAllNewConsultRequestButtons(objControlPanel_data.buttons)
				.verAddressAndDrivingDirectionsDisplaying(
						objControlPanel_data.strCountry,
						objControlPanel_data.strStreetAddress + " "
								+ objControlPanel_data.strCity);
		objHome.clickOnViewPatients();
		objLogin.verifyLoginPromptWarningBannerMsg(objControlPanel_data.strLoginPromptWarningBanner);

		gstrResult = "PASS";

	}

}
