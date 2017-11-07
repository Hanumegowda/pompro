package rh4CommercialServer.requirementGroup.smokeSuit.HomePage;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.Login_data;
import dataObject.PathData;
import dataObject.PatientSchedule_data;
import dataObject.User_data;
import dataObject.ViewPatients_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.CloudConsult;
import page.ControlPanel;
import page.Home;
import page.LocalSiteInformation;
import page.Login;
import page.PatientScheduleRegistration;
import page.UserManagement;
import page.ViewPatients;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.testngExtensions.sep14;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayNewConsultRequest extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayNewConsultRequest() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that new patient registration is done using Patient Registration 
                     page opened by clicking "Admit" button.     
    'Precondition  :
    'Date          : 03-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that new patient registration is done using Patient Registration"
			+ "page opened by clicking Admit button.")
	public void testHappyDay163576() throws Exception {

		gstrTCID = "163576";
		gstrTO = "Verify that new patient registration is done using Patient Registration page opened"
				+ " by clicking Admit button.";

		Login_data objLogin_data = new Login_data();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		Home objHome = new Home(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		LocalSiteInformation objLocalSiteInformation = new LocalSiteInformation(this.driver);
		AddUser objAddUser = new AddUser(this.driver);

		String str1 = objPatientSchedule_data.strPatient;
		String str2 = str1.substring(11);
		String str3 = str1.substring(0, 11);
		String str4 = str2.substring(0, 3);
		System.out.println(str1);
		System.out.println(str2 + " str2");
		System.out.println(str3 + " str3");
		System.out.println(str4 + " str4");

		objHome.launchApplication(objLogin_data.strAppURL);
		
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnLocalSiteInfo();
		objLocalSiteInformation.selEnableCheckBox().selAdmitCheckBox();
		objAddUser.clickOnSaveChanges();
		objHome.launchApplication(objLogin_data.strAppURL);
		
		objHome.verHomePage().clickOnAdmit();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				try{
				objLogin.login(objLogin_data.strAdminUser,
						objLogin_data.strAdminUserPwd).clickLogin();
				}
				catch(NoSuchElementException ele){
					
				}
				objPatientScheduleRegistration.enterTextInLastName1(str2)
						.clickOnSavePatientData1();
				objUserManagement.clickOnOkInAlertPopUp();
				driver.close();
			}
		}

		driver.switchTo().window(mainwindow);
		objHome.clickOnPatientSchedule();
		//objLogin.loginAsUser(objLogin_data.strAdminUser, objLogin_data.strAdminUserPwd)
		/*objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd)*/
		objPatientScheduleRegistration.enterTextInLastName(str4);
		objPatientScheduleRegistration.verPatientRegistration(str2)
				.clickOnEnterOrder();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration.enterTextInPatientsLastName(str4)
				.verPatientRegistration(str2);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that the study with type "Cloud Consult" is displayed in the View 
                     Patients Page when case is submited in the Consult Consult page.     
    'Precondition  :
    'Date          : 01-Dec-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the study with type Cloud Consult is displayed in the View "
			+ "Patients Page when case is submited in the Consult Consult page.")
	public void testHappyDay96530() throws Exception {

		gstrTCID = "96530";
		gstrTO = "Verify that the study with type Cloud Consult is displayed in the View Patients Page "
				+ "when case is submited in the Consult Consult page.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Home objHome = new Home(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		CloudConsult objCloudConsult = new CloudConsult(this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		LocalSiteInformation objLocalSiteInformation = new LocalSiteInformation(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		// autoitfile
		String fileuploadpath = pathProps
				.getProperty(objPathData.uploadAutoITFilePath);
		System.out.println(fileuploadpath);
		File autoitfile = new File(System.getProperty("user.dir")
				+ fileuploadpath);
		String strAutoitPath = autoitfile.toString();
		System.out.println(strAutoitPath + 1);

		// image
		String imagePath = pathProps.getProperty(objPathData.sudyWithImage);
		System.out.println(imagePath);

		File imageFile = new File(System.getProperty("user.dir") + imagePath);
		String strImagePath = imageFile.toString();

		String[] str = { strAutoitPath, strImagePath };

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnLocalSiteInfo();
		objLocalSiteInformation.selEnableCheckBox().selCloudConsultCheckBox();
		objAddUser.clickOnSaveChanges();
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);

		objHome.verHomePage().clickOnCloudConsult();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				objLogin.login(objLogin_data.strAdminUser,
						objLogin_data.strAdminUserPwd).clickLogin();
				objCloudConsult.enterFirstName(objViewPatients_data.strStudy)
						.enterLastName(objViewPatients_data.strStudy).selDOB()
						.selConsultingMDEmail().clickOnFileCapture();
				objAutoIT.executeAutoItFile(str);
				objCloudConsult.clickOnSubmit();
				Thread.sleep(2000);
				objUserManagement.clickOnOkInAlertPopUp();
				driver.close();
			}
		}

		driver.switchTo().window(mainwindow);
		objHome.clickOnViewPatients();
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy)
				.verCloudConsultType().clickOnLogout();

		gstrResult = "PASS";

	}

}
