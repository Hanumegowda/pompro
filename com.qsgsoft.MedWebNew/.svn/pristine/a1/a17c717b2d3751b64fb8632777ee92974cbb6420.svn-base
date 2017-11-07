package rh6CommercialServer.requirementGroup.smokeSuit.ViewPatients;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Groups_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.User_data;
import dataObject.ViewPatients_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.Groups;
import page.Home;
import page.Login;
import page.MailVerificationFunctions;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayImageManagementToolsSendingPDFReports extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayImageManagementToolsSendingPDFReports() throws Exception {
		super();
	}
	
	/*************************************************************************************
	  'Description   : Verify that a study can be sent to an e-mail recipient when mandatory
	                   and non-mandatory (all) fields are filled in ‘Send study to recipient as PDF report by
	                   E-Fax/Mail’ page.     
	  'Precondition  :
	  'Date          : 25-Sep-2015
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a study can be sent to an e-mail recipient when mandatory "
			+ "and non-mandatory (all) fields are filled in ‘Send study to recipient as PDF report by E-Fax/Mail’ page.")
	public void testHappyDay68465() throws Exception {

		gstrTCID = "68465";
		gstrTO = "Verify that a study can be sent to an e-mail recipient when mandatory and non-mandatory"
				+ " (all) fields are filled in ‘Send study to recipient as PDF report by E-Fax/Mail’ page.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver);
		User_data objUser_data = new User_data();
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
		
		//image
		String imagePath = pathProps
				.getProperty(objPathData.sudyWithImage);
		System.out.println(imagePath);

		File imageFile = new File(System.getProperty("user.dir")
				+ imagePath);
		String strImagePath = imageFile.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox();

		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		Thread.sleep(3000);
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy, objViewPatients_data.strStudy, strImagePath, 
				objViewPatients_data.strModalityDS);
Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour).enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1()
				.clickOnSendThisStudyToDICOMStorageDevice(objViewPatients_data.strStudy);

		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.selRecipientPDFReportByEFaxRadioButton()
						.clickOnNextInSendStudyWizard()
						.enterTextInToField(objViewPatients_data.strUN)
						.enterTextInSubField(objViewPatients_data.subname1)
						.clickOnFinishButton().clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		
		objMailVerificationFunctions
		.loginToMail(objViewPatients_data.strUN,
				objViewPatients_data.strPWD)
		.navigateToInbox1(objViewPatients_data.subname1).verPdfFile(objViewPatients_data.subname1);

		gstrResult = "PASS";
	}
	
}