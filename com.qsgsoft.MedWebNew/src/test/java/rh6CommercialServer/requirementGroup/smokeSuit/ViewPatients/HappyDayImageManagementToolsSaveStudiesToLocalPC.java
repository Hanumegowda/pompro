package rh6CommercialServer.requirementGroup.smokeSuit.ViewPatients;

import java.io.File;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Groups_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.User_data;
import dataObject.ViewPatients_data;
import module.CommonFunctions;
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
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayImageManagementToolsSaveStudiesToLocalPC extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayImageManagementToolsSaveStudiesToLocalPC() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that a study can be saved to local PC storage device when mandatory 
                     and non-mandatory (all) fields are filled in ‘save to local PC storage device’ page.     
    'Precondition  :
    'Date          : 15-Apr-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a study can be saved to local PC storage device when mandatory and "
			+ "non-mandatory (all) fields are filled in ‘save to local PC storage device’ page.")
	public void testHappyDay68479() throws Exception {

		gstrTCID = "68479";
		gstrTO = "Verify that a study can be saved to local PC storage device when mandatory and non-mandatory"
				+ " (all) fields are filled in ‘save to local PC storage device’ page.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Groups_data objGroups_data = new Groups_data();
		User_data objUser_data = new User_data();
		Date_Time_settings objDts = new Date_Time_settings();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Groups objGroups = new Groups(this.driver);
		String strTimeText = objDts.getCurrentDate(objPathData.dateFormat1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		System.out.println(pathProps);

		// backup
		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		System.out.println(backfile);
		String backupfiledownloadpath1 = backfile + "\\" + strTimeText;
		System.out.println(backupfiledownloadpath1 + " see here");

		AutoIT objAutoIT = new AutoIT(this.driver);
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
		objNavigationToSubMenus.clickOnGroups();
		objGroups.clickOnAddGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectAllowedtoAccessServerCheckbox()
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectShowUploadDICOMFilesCheckBox()
				.clickOnSaveChanges();
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
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		objViewPatients.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		Thread.sleep(1000);
		objViewPatients
				.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSendThisStudyToDICOMStorageDevice1(
						objViewPatients_data.strStudy);
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		for (String cw : aw) {
			driver.switchTo().window(cw);
		}
		objViewPatients.sellocalpcRadioButton().clickOnNextInSendStudyWizard()
				.enterTextInLocalPath(backupfiledownloadpath1)
				.selSaveDcmCheckbox().clickOnFinishButton();
		objUserManagement.clickOnOkInAlertPopUp();
		driver.switchTo().window(mw);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch();
		objCommonFunctions.verDownloadedFile(backupfiledownloadpath1);

		gstrResult = "PASS";
	}

}
