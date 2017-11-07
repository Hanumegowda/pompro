package rhel4DiacapServer.requirementGroup.smokeSuit.ViewPatients;

import java.io.File;
import java.util.Properties;

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
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayImageManagementToolsBurnStudyToCDROM extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayImageManagementToolsBurnStudyToCDROM() throws Exception {
		super();
	}
	
	/*************************************************************************************
	  'Description   : Verify that a CD icon is displayed in the management column and at the 
	                   bottom of the View Pateints page for a user with permission 'Allowed to 
	                   burn study to CD ROM'.     
	  'Precondition  :
	  'Date          : 13-Jul-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that a CD icon is displayed in the management column and at the bottom"
			+ " of the View Pateints page for a user with permission 'Allowed to burn study to CD ROM'.")
	public void testHappyDay14351() throws Exception {

		gstrTCID = "14351";
		gstrTO = "Verify that a CD icon is displayed in the management column and at the bottom of the View"
				+ " Pateints page for a user with permission 'Allowed to burn study to CD ROM'.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
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
				.selectShowNewStudyLinkOnPatientPageCheckBox()
				.selectAllowedToViewStudiesInQcSandboxCheckBox()
				.selectAllowedToBurnStudyToCDROMCheckBox();

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
		String studies[] = { objViewPatients_data.strStudy,
				objViewPatients_data.strStudy1, objViewPatients_data.strStudy2 };
		for (int i = 0; i < 3; i++) {
			objViewPatients.clickOnNewStudy();
			Thread.sleep(5000);
			objAutoIT.CreateStudy(strAutoitPath, studies[i], studies[i],
					strImagePath, objViewPatients_data.strModalityDS);
			Thread.sleep(3000);
			objViewPatients.enterTextInFind(studies[i])
					.selInLastOption(objDICOMSettings_data.hour)
					.clickOnSearch().clickOnSearch().clickOnSearch();
		}

		objViewPatients.enterTextInFind(studies[0].substring(14))
				.selInLastOption(objDICOMSettings_data.hour).clickOnSearch()
				.clickOnSearch().clickOnSearch()
				.verCDIconDisplayedInfrontOfAStudy(studies[0])
				.verCDIconDisplayedInfrontOfAStudy(studies[1])
				.verCDIconDisplayedInfrontOfAStudy(studies[2])
				.verCDIconDisplayedAtBottomOfPage();
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}

}
