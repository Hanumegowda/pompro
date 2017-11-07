package rh4CommercialServer.requirementGroup.smokeSuit.PersonalProfile;

import java.io.File;
import java.util.Properties;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.User_data;
import dataObject.ViewPatients_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.Home;
import page.Login;
import page.ModifyUser;
import page.PersonalProfile;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayPersonalProfilePage extends
		TestNG_UI_EXTENSIONSForOneBrowser {
	public HappyDayPersonalProfilePage() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the user information entered in the Administrator Site when creating
                     user is displayed in the Personal Profile page.     
    'Precondition  :
    'Date          : 31-Jul-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the user information entered in the Administrator Site when"
			+ " creating user is displayed in the Personal Profile page.")
	public void testHappyDay128701() throws Exception {

		gstrTCID = "128701";
		gstrTO = "Verify that the user information entered in the Administrator Site when creating"
				+ " user is displayed in the Personal Profile page.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		ModifyUser objModifyUser = new ModifyUser(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		PersonalProfile objPersonalProfile = new PersonalProfile(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser
				.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.enterAIMScreenName(objUser_data.AIMScreenName)
				.enterEmailAddress(objUser_data.emailAddress)
				.enterAdditionalEmailAddress(
						objUser_data.additionalEmailAddress)
				.enterVideoConferencingAddress(
						objUser_data.videoConferencingAddress)
				.enterPagerAddress(objUser_data.pagerAddress)
				.enterFax(objUser_data.fax);
		boolean val = objModifyUser.selectLocation();
		objAddUser.enterPhoneNum(objUser_data.phoneNum)
				.enterDoctorID(objUser_data.DoctorID)
				.enterPowerScribeUserID(objUser_data.powerScribeUserID)
				.enterUPIN(objUser_data.UPIN).clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedInForNonMandatoryFieldsFilled(objUser_data.strNewUserName);
		objUserManagement.clickOnModifyUser(objUser_data.strNewUserName);
		String req = (objModifyUser.getSelectedLocation()).trim();
		objAddUser.clickOnSaveChanges();
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnPersonalProfile();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objPersonalProfile
				.verPersonalProfilePagePfUser(objUser_data.strNewUserName);
		objPersonalProfile
				.verFullNameOfUser(objUser_data.strNewUserName)
				.verACLgroup(objUser_data.radioLogist)
				.verUserName(objUser_data.strNewUserName)
				.verAIMScreenName(objUser_data.AIMScreenName)
				.verEmailAddress(objUser_data.emailAddress)
				.verVideoConferencingAddress(
						objUser_data.videoConferencingAddress)
				.verPagerAddress(objUser_data.pagerAddress)
				.verPhone(objUser_data.phoneNum).verFax(objUser_data.fax)
				.verDoctorID(objUser_data.DoctorID)
				.verPowerScribeUserID(objUser_data.powerScribeUserID)
				.verUPIN(objUser_data.UPIN);
		if(val==true){
			objPersonalProfile.verLocation(req);
		}

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that compression level of all studies in Medweb Server is changed to 
                     the option selected in "Default compression level" when "Reset compression
                     levels to default" is enabled.     
    'Precondition  :
    'Date          : 07-Dec-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that compression level of all studies in Medweb Server is changed to "
			+ "the option selected in Default compression level when Reset compression levels to default"
			+ " is enabled.")
	public void testHappyDay84688() throws Exception {

		gstrTCID = "84688";
		gstrTO = "Verify that compression level of all studies in Medweb Server is changed to the option "
				+ "selected in Default compression level when Reset compression levels to default is enabled.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Home objHome = new Home(this.driver);
		PersonalProfile objPersonalProfile = new PersonalProfile(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileAutoITDownloadPath = pathProps
				.getProperty(objPathData.autoItFilePath2);
		System.out.println(fileAutoITDownloadPath);

		File autoitfile = new File(System.getProperty("user.dir")
				+ fileAutoITDownloadPath);
		String strAutoitPath = autoitfile.toString();
		System.out.println(strAutoitPath + 1);

		// image
		String imagePath = pathProps.getProperty(objPathData.sudyWithImage);
		System.out.println(imagePath);

		File imageFile = new File(System.getProperty("user.dir") + imagePath);
		String strImagePath = imageFile.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnViewPatients();

		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		String[] studies = { objViewPatients_data.strStudy1,
				objViewPatients_data.strStudy2, objViewPatients_data.strStudy3,
				objViewPatients_data.strStudy4, objViewPatients_data.strStudy5 };
		String[] modalities = { objViewPatients_data.strModalityDS,
				objViewPatients_data.strModalityCT,
				objViewPatients_data.strModalityMR,
				objViewPatients_data.strModalityNM,
				objViewPatients_data.strModalitySC };

		for (int i = 0; i < studies.length; i++) {
			objViewPatients.clickOnNewStudy();
			Thread.sleep(5000);
			objAutoIT.CreateStudy(strAutoitPath, studies[i], studies[i],
					strImagePath, modalities[i]);
			Thread.sleep(5000);
			objViewPatients.enterTextInFind(studies[i])
					.selInLastOption(objDICOMSettings_data.hour)
					.clickOnSearch1().verStudyFromOtherServer(studies[i]);
		}
		String[] cl = { objViewPatients_data.strCompressionLevelLow,
				objViewPatients_data.strCompressionLevelHigh,
				objViewPatients_data.strCompressionLevelLowest };
		for (int i = 0; i < cl.length; i++) {
			objViewPatients.clickOnPreferences();
			objPersonalProfile.selCompressionLevelOption(cl[i])
					.selResetCompressionLevelsToDefaultChckBox()
					.clickOnSaveChanges();
			objUserManagement.clickOnOkInAlertPopUp();
			objHome.clickOnViewPatients();
			objViewPatients
					.enterTextInFind(
							(objViewPatients_data.strStudy1)
									.substring((objViewPatients_data.strStudy1)
											.length() - 3))
					.selInLastOption(objDICOMSettings_data.hour)
					.clickOnSearch();
			for (int i1 = 0; i1 < modalities.length; i1++) {
				objViewPatients.verSelectedCompressionLevel(modalities[i1],
						cl[i]);
			}
		}
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
}
