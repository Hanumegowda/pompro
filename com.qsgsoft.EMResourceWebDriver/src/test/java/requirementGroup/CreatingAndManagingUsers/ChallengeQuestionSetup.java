package requirementGroup.CreatingAndManagingUsers;

import java.io.File;
import java.util.Properties;

import lib.dataObject.Login_data;
import lib.dataObject.Roles_data;
import lib.dataObject.Upload_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.ChangePassword;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Roles;
import lib.page.SecurityQuestion;
import lib.page.SelectRegion;
import lib.page.Upload;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class ChallengeQuestionSetup extends TestNG_UI_EXTENSIONS{

	public ChallengeQuestionSetup() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/**********************************************************************************************
	 * 'Description :Verify that users are prompted to set up challenge question upon second login.
	 * 'Date        :17-Apr-2015
	 * 'Author      :Anitha
	 **********************************************************************************************/

	@Test(description = "Verify that users are prompted to set up challenge question upon second login.")
	public void testHappyDay155855() throws Exception {
		
		gstrTCID = "155855";
		gstrTO = "Verify that users are prompted to set up challenge question upon second login.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName2);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()

				.enterAllUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName,
						"", "","", "","", objUser_data.strEmail,
						objUser_data.strEmail,
						objUser_data.strEmail)
				.clickSaveButton();

		login_page.clickLogOut();

		System.out.println("-----------------Test execution starts---------------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame()
		
		.verifyRegionDefaultPage();
		
		login_page1.clickLogOut()
		
		.loginToApplicationSecondTime(objUser_data.strNewUserName,
				objUser_data.strNewPassword,objUser_data.strEmail);
		
		RegionDefault_page1.selectFrame()
		
		.verifyRegionDefaultPage();
		
		login_page1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/**********************************************************************************************
	 * 'Description : Verify that web service users are prompted to set challenge question upon first login. 	
	 * 'Date        : 27-Apr-2015
	 * 'Author      : Renushree
	 * Modified By : Sangappa K                      Date:30-May-2016
	 **********************************************************************************************/

	@Test(description = "Verify that web service users are prompted to set challenge question upon first login.")
	public void testHappyDay155944() throws Exception {

		gstrTCID = "155944";// This test case is invalid
		gstrTO = "Verify that web service users are prompted to set challenge question upon first login.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strUserPwd, objUserdata.strFullName, "",
						"", "", "Org1", "", objUserdata.strEmail,
						objUserdata.strEmail, objUserdata.strEmail)
				.selectWebServiceChkBox().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin1.clickLogOut();

		objLogin1.launchEMRurl()
				.enterUserName(objUserdata.strNewUserName)
				.enterPassword(objUserdata.strUserPwd).clickLogin();

		objRegionDefault1.selectFrame();
		
		objUsersList.verSetUpPasswordIsNotPresent();

		objRegionDefault1.verifyWebServiceAccountError();
		
		objRegionDefault1.verifyErrorMessage();
		
		objRegionDefault1.clickOnClickHereLink();
		
		objLogin1.verifyUserName();
		
		objLogin1.verPasswordField();
		
		objLogin1.verLoginButton();
		
		objLogin1.enterUserName(objUserdata.strNewUserName)
		.enterPassword(objUserdata.strUserPwd).clickLogin();

		objRegionDefault1.selectFrame();
		
		objUsersList.verSetUpPasswordIsNotPresent();
				
		objRegionDefault1.verifyWebServiceAccountError();
		
		objRegionDefault1.verifyErrorMessage();
		objRegionDefault1
		         .verifyErrorMessage()
		        .clickOnClickHereLink()
		        .verSecurityQuationPageNotDispalyed();
		objLogin1.verLoginButton()
		              .verPasswordField()
		              .verIntermedixLink();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description : Verify that uploaded users are prompted to set challenge question.
	'Precondition:
	'Date	 	 : 29-Apr-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that uploaded users are prompted to set challenge question.")
	public void testHappyDay155947() throws Exception {

		gstrTCID = "155947";
		gstrTO = "Verify that uploaded users are prompted to set challenge question.";

		Login objLogin = new Login(this.driver1);
		User_data objUser_data = new User_data();
		Login_data objTest_data = new Login_data();
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);
		Roles_data objRolesData = new Roles_data();
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		User_data objUserdata = new User_data();
		OfficeCommonFunctions objOFC = new OfficeCommonFunctions();
		Upload_data objUpload_data = new Upload_data();
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		UsersList UsersList_page = new UsersList(this.driver1);

		File file = new File(System.getProperty("user.dir"));
		String fileUploadPath = pathProps
				.getProperty(objUpload_data.strUploadResFile_Path);
		String strFilePath = file + fileUploadPath;

		Login objLogin1 = new Login(this.driver1);
		Upload objUpload = new Upload(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SecurityQuestion objSecurityQuestion = new SecurityQuestion(
				this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		// Create role

		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objNavigationToSubMenus.navigateToUpload();

		String[] strTestData = { "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "",
				objUserdata.strNewUserName, strRoleValue[0], "",
				objUserdata.strUserPwd, objUserdata.strFullName, "", "",
				"", "", "", objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryMailId, objUserdata.strPrimaryMailId,
				"N", "N", "N" };

		String[] strTestData1 = { "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "",
				objUserdata.strSecNewUserName, strRoleValue[0], "",
				objUserdata.strUserPwd, objUserdata.strFullName, "", "",
				"", "", "", "", "", "", "N", "N", "N" };

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strSecNewUserName);

		objOFC.writeResultDataToParticularRow(strTestData, strFilePath,
				"Resource", 1);

		objOFC.writeResultDataToParticularRow(strTestData1, strFilePath,
				"Resource", 2);
		objRegionDefault.selectFrame();
		objNavigationToSubMenus.navigateToUpload();

		objUpload.clickOnUploadResourceBtn().verNewUploadPageIsDisplayed()
				.deselectTestCheckBox().uploadFile(strFilePath)
				.clickOnSaveBtn();
		objRegionDefault.selectFrame();
		objNavigationToSubMenus.navigateToUsers();
		UsersList_page.searchUserName(objUserdata.strNewUserName,
				objRolesData.strRoleName, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption);

		UsersList_page.searchUserName(objUserdata.strSecNewUserName,
				objRolesData.strRoleName, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption);
		
		System.out.println(objUser_data.strResourceType);

		objLogin.clickLogOut();

		objLogin1.loginToApplicationNew(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		objLogin1.verifySetUpYourPasswordPage()
		        .enterCurrentPassword(objUserdata.strNewPassword)
				.enterNewPassword(objTest_data.strPassword)
				.enterConfirmPassword(objTest_data.strPassword).clickSubmit()
				.verifySecurityQuestionAndAnswerPageAndClickOnCancel();

		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut();
		objLogin1.loginToApplicationNew(objUserdata.strNewUserName,
				objTest_data.strPassword);
		objSecurityQuestion.verifySecurityQuestionAndAnswerHeading();
		objSecurityQuestion.enterSecurityAnswer(
				objTest_data.strAnswerLast4DigitsOfDL).clickOnSave();
		objRegionDefault1.selectFrame();
		objNavigationToSubMenus1.navigateToSecurityQuestionsInPreferences();

		RegionDefault_page1.verWebNotificationframe();

		objSecurityQuestion
				.verifySecurityQuestionAndAnswerHeading()
				.verifySecurityQuestion(objTest_data.strQuestionLast4DigitsOfDL)
				.verifySecurityAnswer(objTest_data.strAnswerLast4DigitsOfDL)
				.verifyEmailAddress(objUser_data.strPrimaryMailId)
				.clickOnCancel();
		RegionDefault_page1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();

		objLogin1.loginToApplicationNew(objUserdata.strSecNewUserName,
				objUserdata.strNewPassword);
		objLogin1.verifySetUpYourPasswordPage()
		         .enterCurrentPassword(objUserdata.strNewPassword)
				.enterNewPassword(objTest_data.strPassword)
				.enterConfirmPassword(objTest_data.strPassword).clickSubmit()
				.verifySecurityQuestionAndAnswerPageAndClickOnCancel();
		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut();

		objLogin1.loginToApplicationNew(objUserdata.strSecNewUserName,
				objTest_data.strPassword);
		objSecurityQuestion.verifySecurityQuestionAndAnswerHeading();
		objSecurityQuestion.verEmailAddressTextFiledIsEmpty()
				.enterSecurityAnswer(objTest_data.strAnswerLast4DigitsOfDL)
				.enterEmailAddress(objUserdata.strPrimaryMailId).clickOnSave();
		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}