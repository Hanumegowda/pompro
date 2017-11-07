package rh4CommercialServer.requirementGroup.smokeSuit.Users;

import java.io.File;
import java.util.Properties;

import dataObject.Login_data;
import dataObject.PathData;
import dataObject.User_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.Home;
import page.Login;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class EdgeCaseCreateUser extends TestNG_UI_EXTENSIONSForOneBrowser{
	public EdgeCaseCreateUser() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that a user can be created when mandatory and non-mandatory fields are filled.     
    'Precondition  :
    'Date          : 16-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that a user can be created when mandatory and non-mandatory fields are filled.")
	public void testEdgeCase83893() throws Exception {

		gstrTCID = "83893";
		gstrTO = "Verify that a user can be created when mandatory and non-mandatory fields are filled.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
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
				.enterFax(objUser_data.fax)
				.enterPhoneNum(objUser_data.phoneNum)
				.enterDoctorID(objUser_data.DoctorID)
				.enterPowerScribeUserID(objUser_data.powerScribeUserID)
				.enterUPIN(objUser_data.UPIN).clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedInForNonMandatoryFieldsFilled(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.verifyUser(objUser_data.strNewUserName);
		objViewPatients.clickOnLogout();
		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that a user cannot be created when mandatory fields are not filled.     
    'Precondition  :
    'Date          : 17-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that a user cannot be created when mandatory fields are not filled.")
	public void testEdgeCase83894() throws Exception {

		gstrTCID = "83894";
		gstrTO = "Verify that a user cannot be created when mandatory fields are not filled.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser
				.verAddNewUserPage()
				.enterAIMScreenName(objUser_data.AIMScreenName)
				.enterEmailAddress(objUser_data.emailAddress)
				.enterAdditionalEmailAddress(
						objUser_data.additionalEmailAddress)
				.enterVideoConferencingAddress(
						objUser_data.videoConferencingAddress)
				.enterPagerAddress(objUser_data.pagerAddress)
				.enterFax(objUser_data.fax)
				.enterPhoneNum(objUser_data.phoneNum)
				.enterDoctorID(objUser_data.DoctorID)
				.enterPowerScribeUserID(objUser_data.powerScribeUserID)
				.enterUPIN(objUser_data.UPIN).clickOnSaveChanges();
		objAddUser.verFullNameEssentialErrorMsg();
		System.out.println(objUser_data.strNewUserName);
		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that a user account having a Password with upper case characters is not 
                     allowed access to the server when the Password is specified in lower case.     
    'Precondition  :
    'Date          : 17-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that a user account having a Password with upper case characters is "
			+ "not allowed access to the server when the Password is specified in lower case.")
	public void testEdgeCase83899() throws Exception {

		gstrTCID = "83899";
		gstrTO = "Verify that a user account having a Password with upper case characters is"
				+ "not allowed access to the server when the Password is specified in lower case.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord((objUser_data.strNewPassword1).toUpperCase());
				System.out.println((objUser_data.strNewPassword1).toUpperCase());
				objAddUser.confirmPassWord((objUser_data.strNewPassword1).toUpperCase())
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword1).clickLogin()
				.verifyInvalidCredentialErrMsg();
		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that a user account having a Password with lower case characters is not
                     allowed access to the server when the Password is specified in upper case.     
    'Precondition  :
    'Date          : 18-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that a user account having a Password with lower case characters is not"
			+ " allowed access to the server when the Password is specified in upper case.")
	public void testEdgeCase83900() throws Exception {

		gstrTCID = "83900";
		gstrTO = "Verify that a user account having a Password with lower case characters is not"
				+ " allowed access to the server when the Password is specified in upper case.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword1)
				.confirmPassWord(objUser_data.strNewPassword1)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				(objUser_data.strNewPassword1).toUpperCase()).clickLogin()
				.verifyInvalidCredentialErrMsg();
		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that a signature file can be uploaded while adding a new user.     
    'Precondition  :
    'Date          : 19-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that a signature file can be uploaded while adding a new user.")
	public void testEdgeCase83909() throws Exception {

		gstrTCID = " 83909 ";
		gstrTO = "Verify that a signature file can be uploaded while adding a new user.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		PathData objPathData = new PathData();
		Login objLogin = new Login(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String filePDFDownloadPath = pathProps
				.getProperty(objPathData.strSignatureFileUpload);

		File jpegfile = new File(System.getProperty("user.dir")
				+ filePDFDownloadPath);
		String strJpegPath = jpegfile.toString();
		System.out.println(strJpegPath);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword1)
				.confirmPassWord(objUser_data.strNewPassword1)
				.uploadFile1(strJpegPath).clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement.clickOnModifyUser(objUser_data.strNewUserName);
		objAddUser.verUploadedSignatureFile();
		gstrResult = "PASS";

	}

//	/*************************************************************************************
//    'Description   : Delete all the auto users.     
//    'Precondition  :
//    'Date          : 18-Jun-2015
//    'Author        : Hanumegowda
//    '---------------------------------------------------------------
//    'Modified Date                                               Modified By
//    'Date                                                         Name
//	**************************************************************************************/
//	@Test(description = "Delete all the auto users.")
//	public void deleteAllUsers() throws Exception {
//
//		Login_data objLogin_data = new Login_data();
//		User_data objUser_data = new User_data();
//
//		Home objHome = new Home(this.driver);
//		Frames objFrames = new Frames(this.driver);
//		AdministratorSite objAdministratorSite = new AdministratorSite(
//				this.driver);
//		Login objLogin = new Login(this.driver);
//		UserManagement objUserManagement = new UserManagement(this.driver);
//		objFrames.switchToMainMenuFrame();
//		objHome.verHomePage().clickOnAdminSite();
//		objLogin.loginAsAdmin(objLogin_data.strAdminUser,
//				objLogin_data.strAdminUserPwd).clickLogin();
//		objFrames.switchToDefaultFrame();
//		Thread.sleep(5000);
//		objFrames.switchToRightFrame();
//		objFrames.switchToSubMenuInRightFrame();
//		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
//		objFrames.switchToDefaultFrame();
//		objFrames.switchToRightFrame();
//		objFrames.switchToMainInRightFrame();
//		objUserManagement
//				.selectAllAutoUsers()
//				.selectOptionInApplyForSelectedDropDown(objUser_data.removeuser)
//				.clickOnApply().clickOnOkInAlertPopUp();
//
//		gstrResult = "PASS";
//
//	}
}
