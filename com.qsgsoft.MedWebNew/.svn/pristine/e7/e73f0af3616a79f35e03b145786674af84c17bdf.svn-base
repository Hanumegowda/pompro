package rh4CommercialServer.requirementGroup.smokeSuit.Users;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import dataObject.ControlPanel_data;
import dataObject.Locations_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.User_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.ControlPanel;
import page.Home;
import page.LocalSiteInformation;
import page.Locations;
import page.Login;
import page.PublicSite;
import page.TemplatesList;
import page.UserManagement;
import page.ViewPatients;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.FileFormatConverter;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayCreateUser extends TestNG_UI_EXTENSIONSForOneBrowser {
	public HappyDayCreateUser() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that a user can be created when only mandatory fields are filled and the
                     created user can login to the system using the Password specified by the Administrator.     
    'Precondition  :
    'Date          : 15-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a user can be created when only mandatory fields are filled and"
			+ " the created user can login to the system using the Password specified by the Administrator.")
	public void testHappyDay127853() throws Exception {

		gstrTCID = "127853";
		gstrTO = "Verify that a user can be created when only mandatory fields are filled and the"
				+ " created user can login to the system using the Password specified by the Administrator.";

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
		this.driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		Thread.sleep(3000);
		System.out.println(objUser_data.strNewUserName);
		try{
		objUserManagement.enterTextInUserNameSearchField(objUser_data.strNewUserName).clickOnSearch();
		}
		catch(NoSuchElementException e){
		objUserManagement.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserName);
		}
		objUserManagement.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserName);
		Capabilities cp = ((RemoteWebDriver)this.driver).getCapabilities();
		String bn = cp.getBrowserName();
		System.out.println(bn+" this is the curent browser");
		if(bn.equalsIgnoreCase("MicrosoftEdge")){
		this.driver= objNavigationToSubMenus.clickOnLogout(true);
		Home objhome1= new  Home(this.driver);
		Login objLogin1 = new Login(this.driver);
		ViewPatients objViewPatients1 = new ViewPatients(this.driver);
		objhome1.launchApplication(objLogin_data.strAppURL);
		objhome1.clickOnViewPatients();
		objLogin1.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients1.verifyUser(objUser_data.strNewUserName);
		objViewPatients1.clickOnLogout();
		}
		else{
			objHome.clickOnLogOut();
		Thread.sleep(5000);
		objHome.launchApplication(objLogin_data.strAppURL);
		driver.switchTo().defaultContent();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		objViewPatients.verifyUser(objUser_data.strNewUserName);
		objViewPatients.clickOnLogout();
		}

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that the original Administrator can add users to Administrator Group.     
    'Precondition  :
    'Date          : 18-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the original Administrator can add users to Administrator Group.")
	public void testHappyDay67899() throws Exception {

		gstrTCID = "67899";
		gstrTO = "Verify that the original Administrator can add users to Administrator Group.";

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
		driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.administrator)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement.verifyUserWithRedBallandUserNeverLoggedIn(
				objUser_data.strNewUserName).verUserWithACLGroup(
				objUser_data.strNewUserName, objUser_data.administrator);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

	/*************************************************************************************
    'Description   : Verify that PDF files uploaded by the Administrator are displayed in Home page
                     when "Medical Licenses" checkbox is enabled in Modify User's page.     
    'Precondition  :
    'Date          : 22-Jun-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that PDF files uploaded by the Administrator are displayed in Home"
			+ "page when Medical Licenses checkbox is enabled in Modify User's page.")
	public void testHappyDay164649() throws Exception {

		gstrTCID = "164649";
		gstrTO = "Verify that PDF files uploaded by the Administrator are displayed in Home page"
				+ "when Medical Licenses checkbox is enabled in Modify User's page.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		ControlPanel_data objControlPanel_data = new ControlPanel_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		PublicSite objPublicSite = new PublicSite(this.driver);
		LocalSiteInformation objLocalSiteInformation = new LocalSiteInformation(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String filePDFDownloadPath = pathProps
				.getProperty(objPathData.strPdfFileUpload);

		File Pdffile = new File(System.getProperty("user.dir")
				+ filePDFDownloadPath);
		String strPdfPath = Pdffile.toString();
		System.out.println(strPdfPath);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		this.driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.verServiceSettings();
		objControlPanel.clickOnLocalSiteInfo();
		objLocalSiteInformation.verLocalSiteInfoPage()
				.selMedicalLicensesListCheckBox()
				.enterLinkName(objControlPanel_data.strLinkName);
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objUserManagement.clickOnModifyUser(objUser_data.strNewUserName);
		objAddUser.clickOnMedicalLicensesLink()
				.clickOnAddInMedicalLicensesPage()
				.clickOnBrowseInUploadMedicalLicenseFile(strPdfPath)
				.clickOnUploadButton().clickOnSaveChanges1().clickOnBackButton()
				.selMedicalLicensesCheckBox().clickOnSaveChanges();
		objNavigationToSubMenus.clickOnPublicSite();
		objPublicSite.clickOnLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objPublicSite.verDoctorsMedicalLicensesPage().verUploadedFile(
				objUser_data.strNewUserName, objUser_data.fileName);
		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that User's with Full name (First, Middle, Last) are imported successfully
                     using CSV file.     
    'Precondition  :
    'Date          : 20-Jun-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that User's with Full name (First, Middle, Last) are imported successfully using CSV file.")
	public void testHappyDay155832() throws Exception {

		gstrTCID = "155832";
		gstrTO = "Verify that User's with Full name (First, Middle, Last) are imported successfully using CSV file.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Locations objLocations = new Locations(this.driver);
		Login objLogin = new Login(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		TemplatesList objTemplatesList = new TemplatesList(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + objUser_data.strFile
				+ ".csv";
		String autoit = pathProps.getProperty(objPathData.strAutoITPath);
		File autoitfile = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnImportFromCSV().clickOnDownloadCSVTemplate();
		Thread.sleep(5000);
		objAutoIT.DownloadTheReports1(autoitfilepath, backupfiledownloadpath1,
				"IEDownload.exe");
		Thread.sleep(10000);
		System.out.println(backupfiledownloadpath1);
		List<String[]> li = new ArrayList<String[]>();
		li.add(objUser_data.csvuser4);
		System.out.println(li.size() + " this is initial size");
		objFileFormatConverter.writeToCSVFile(li, backupfiledownloadpath1);
		objTemplatesList.clickOnBrowse(backupfiledownloadpath1);
		objLocations.clickOnImportCSV();
		objNavigationToSubMenus.clickOnUser();
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.csvuser4[0]).clickOnSearch();
		} catch (NoSuchElementException e) {
			objUserManagement.verUserWithACLGroup(objUser_data.csvuser4[0],
					objUser_data.csvuser4[(objUser_data.csvuser3.length) - 1]);
		}
		objUserManagement.verUserWithACLGroup(objUser_data.csvuser4[0],
				objUser_data.csvuser4[(objUser_data.csvuser3.length) - 1]);
		objUserManagement.clickOnModifyUser(objUser_data.csvuser4[0])
				.verUserFirstName(objUser_data.csvuser4[2])
				.verUserMiddleName(objUser_data.csvuser4[3])
				.verUserLastName(objUser_data.csvuser4[4]);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that Users can be imported from CSV template when upper case letters 
                     are included in Username field.     
    'Precondition  :
    'Date          : 17-Jun-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Users can be imported from CSV template when upper case letters "
			+ "are included in Username field.")
	public void testHappyDay153427() throws Exception {

		gstrTCID = "153427";
		gstrTO = "Verify that Users can be imported from CSV template when upper case letters are"
				+ " included in Username field.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Locations objLocations = new Locations(this.driver);
		Login objLogin = new Login(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		TemplatesList objTemplatesList = new TemplatesList(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + objUser_data.strFile
				+ ".csv";
		String autoit = pathProps.getProperty(objPathData.strAutoITPath);
		File autoitfile = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnImportFromCSV().clickOnDownloadCSVTemplate();
		Thread.sleep(5000);
		objAutoIT.DownloadTheReports1(autoitfilepath, backupfiledownloadpath1,
				"IEDownload.exe");
		Thread.sleep(10000);
		System.out.println(backupfiledownloadpath1);
		List<String[]> li = new ArrayList<String[]>();
		li.add(objUser_data.csvuser3);
		System.out.println(li.size() + " this is initial size");
		objFileFormatConverter.writeToCSVFile(li, backupfiledownloadpath1);
		objTemplatesList.clickOnBrowse(backupfiledownloadpath1);
		objLocations.clickOnImportCSV();
		objNavigationToSubMenus.clickOnUser();
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.csvuser3[0]).clickOnSearch();
		} catch (NoSuchElementException e) {
			objUserManagement.verUserWithACLGroup(objUser_data.csvuser3[0],
					objUser_data.csvuser3[(objUser_data.csvuser3.length) - 1]);
		}
		objUserManagement.verUserWithACLGroup(objUser_data.csvuser3[0],
				objUser_data.csvuser3[(objUser_data.csvuser3.length) - 1]);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that upper case letters can be used in Username field to create new Users.     
    'Precondition  :
    'Date          : 17-Sep-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that upper case letters can be used in Username field to create new Users.")
	public void testHappyDay153425() throws Exception {

		gstrTCID = "153425";
		gstrTO = "Verify that upper case letters can be used in Username field to create new Users.";

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
		this.driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserNameUpperCase)
				.enterUserName(objUser_data.strNewUserNameUpperCase)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		Thread.sleep(3000);
		System.out.println(objUser_data.strNewUserNameUpperCase);
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strNewUserNameUpperCase).clickOnSearch();
		} catch (NoSuchElementException e) {
			objUserManagement
					.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserNameUpperCase);
		}
		objUserManagement
				.verifyUserWithRedBallandUserNeverLoggedIn(objUser_data.strNewUserNameUpperCase);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that one of the Full Name fields (First, Middle or last) are mandatory 
                     while creating user and last name is displayed as the Username.     
    'Precondition  :
    'Date          : 19-Sep-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that one of the Full Name fields (First, Middle or last) are mandatory"
			+ " while creating user and last name is displayed as the Username.")
	public void testHappyDay155777() throws Exception {

		gstrTCID = "155777";
		gstrTO = "Verify that one of the Full Name fields (First, Middle or last) are mandatory while "
				+ "creating user and last name is displayed as the Username.";

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
		this.driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage().selectOptionInACLgroupDropDown(
				objUser_data.radioLogist);
		objAddUser.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		objAddUser.verFullNameEssentialErrorMsg();
		objAddUser.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.verUserNameFieldText(objUser_data.strNewUserName);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that users Full name (First, Middle, Last) entered is displayed correctly
                     in the order Example First Name:- Asser Adel Ahmed, Lastname:- Ali, Middlename:- Khan
                     Order: Ali, Asser Adel Ahmed Khan.     
    'Precondition  :
    'Date          : 22-Sep-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that users Full name (First, Middle, Last) entered is displayed correctly"
			+ "in the order Example First Name:- Asser Adel Ahmed, Lastname:- Ali, Middlename:- Khan"
			+ "Order: Ali, Asser Adel Ahmed Khan.")
	public void testHappyDay165910() throws Exception {

		gstrTCID = "165910";
		gstrTO = "Verify that users Full name (First, Middle, Last) entered is displayed correctly"
				+ "in the order Example First Name:- Asser Adel Ahmed, Lastname:- Ali, Middlename:- Khan"
				+ "Order: Ali, Asser Adel Ahmed Khan.";

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
		this.driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage().selectOptionInACLgroupDropDown(
				objUser_data.radioLogist);
		objAddUser.enterFullNameFirst(objUser_data.strUserFirstName)
				.enterFullNameMiddle(objUser_data.strUserMiddleName)
				.enterFullNameLast(objUser_data.strUserLastName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		Thread.sleep(3000);
		System.out.println(objUser_data.strUserLastName);
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strUserLastName).clickOnSearch();
		} catch (NoSuchElementException e) {
			objUserManagement.verUserFullName(objUser_data.strUserLastName
					+ ", " + objUser_data.strUserFirstName + " "
					+ objUser_data.strUserMiddleName);
		}
		objUserManagement.verUserFullName(objUser_data.strUserLastName + ", "
				+ objUser_data.strUserFirstName + " "
				+ objUser_data.strUserMiddleName);
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that User can be imported from CSV template when all the user data 
                     is entered including checkboxes, radio options and text fields.     
    'Precondition  :
    'Date          : 06-Oct-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that User can be imported from CSV template when all the user "
			+ "data is entered including checkboxes, radio options and text fields.")
	public void testHappyDay167167() throws Exception {

		gstrTCID = "167167";
		gstrTO = "Verify that User can be imported from CSV template when all the user data is"
				+ " entered including checkboxes, radio options and text fields.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		PathData objPathData = new PathData();
		Locations_data objLocations_data = new Locations_data();
		FileFormatConverter objFileFormatConverter = new FileFormatConverter();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		Locations objLocations = new Locations(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		TemplatesList objTemplatesList = new TemplatesList(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		Login objLogin = new Login(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String backupfilepath = pathProps
				.getProperty(objPathData.strBackupfile);
		File backfile = new File(System.getProperty("user.dir")
				+ backupfilepath);
		String backupfiledownloadpath1 = backfile + "\\" + objUser_data.strFile
				+ ".csv";
		String autoit = pathProps.getProperty(objPathData.strAutoITPath);
		File autoitfile = new File(System.getProperty("user.dir") + autoit);
		String autoitfilepath = autoitfile.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		driver.switchTo().defaultContent();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		String[] str = { objUser_data.telemedicineRefMD,
				objUser_data.telemedicineRefMD, objUser_data.dentistGp,
				objUser_data.dermatologistGp };
		String[] str1 = { objUser_data.strNewUserName,
				objUser_data.strNewUserName1, objUser_data.strNewUserName2,
				objUser_data.strNewUserName3 };
		for (int i = 0; i < str.length; i++) {
			objUserManagement.clickOnAddUser();
			objAddUser.verAddNewUserPage()
					.selectOptionInACLgroupDropDown(str[i])
					.enterFullNameLast(str1[i])
					.enterPassWord(objUser_data.strNewPassword)
					.confirmPassWord(objUser_data.strNewPassword)
					.clickOnSaveChanges();
			System.out.println(str1[i]);
			try {
				objUserManagement.enterTextInUserNameSearchField(str1[i])
						.clickOnSearch();
			} catch (NoSuchElementException e) {

			}
			objUserManagement
					.verifyUserWithRedBallandUserNeverLoggedIn(str1[i]);
		}
		try {
			objUserManagement.enterTextInUserNameSearchField(
					objUser_data.strNewUserName).clickOnSearch();
		} catch (NoSuchElementException e) {
			System.out.println("");
		}
		objUserManagement.clickOnModifyUser(objUser_data.strNewUserName);
		objAddUser.clickOnEditOfByServiceLocation();
		String strrefloc = "", strrefloc1 = "", strrefloc2 = "";
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!mainwindow.contains(childwindow)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				strrefloc = objAddUser.selServiceLocationAndGetItsName(1);
				strrefloc1 = objAddUser.selServiceLocationAndGetItsName(2);
				strrefloc2 = objAddUser.selServiceLocationAndGetItsName(3);
				Thread.sleep(5000);
				objAddUser.clickOnSave();
			}
		}
		driver.switchTo().window(mainwindow);
		System.out.println(strrefloc + " location one");
		System.out.println(strrefloc1 + " location two");
		System.out.println(strrefloc2 + " location three");
		objNavigationToSubMenus.clickOnLocations();
		objLocations
				.verLocationListPage()
				.clickOnAddLocation()
				.verAddnewLocationPage()
				.enterTextInFacilityNameField(objLocations_data.strfacilityname)
				.enterTextInLocationIDField(objLocations_data.locationid)
				.enterTextInCityField(objLocations_data.city)
				.enterTextInCountryField(objLocations_data.country);
		objAddUser.clickOnSaveChanges();
		System.out.println(objLocations_data.strfacilityname);
		objLocations.clickOnAddReferralLocation()
				.enterTextInRefferalConditionsField(
						objLocations_data.strRefLocation);
		objAddUser.clickOnSaveChanges();
		objNavigationToSubMenus.clickOnUser();

		objUserManagement.clickOnImportFromCSV().clickOnDownloadCSVTemplate();
		System.out.println(backupfiledownloadpath1 + " this is final path");
		Thread.sleep(5000);
		objAutoIT.DownloadTheReports1(autoitfilepath, backupfiledownloadpath1,
				"IEDownload.exe");
		Thread.sleep(6000);
		System.out.println(objUser_data.strNewUserName4);
		System.out.println(backupfiledownloadpath1);
		List<String[]> li = new ArrayList<String[]>();
		String[] ud = {
				objUser_data.strNewUserName4,
				objUser_data.strNewPassword,
				objUser_data.strUserFirstName,
				objUser_data.strUserMiddleName,
				objUser_data.strUserLastName,
				objUser_data.telemedicineRefMD,
				objLocations_data.strfacilityname,
				objLocations_data.strRefLocation,
				objUser_data.emailAddress,
				objUser_data.additionalEmailAddress + ";"
						+ objUser_data.additionalEmailAddress1,
				objUser_data.phoneNum,
				objUser_data.fax,
				objUser_data.DoctorID,
				objUser_data.strActxfree,
				objUser_data.strViewer,
				"open",
				objUser_data.strNewUserName + ";"
						+ objUser_data.strNewUserName1,
				objUser_data.strNewUserName2 + ";"
						+ objUser_data.strNewUserName3,
				strrefloc + ";" + strrefloc1,
				objUser_data.strNewUserName2 + ";"
						+ objUser_data.strNewUserName3,
				objUser_data.strDermatology + ";"
						+ objUser_data.strOphthalmology, "y", "n", "y",
				"1 day", "1 week", "2 weeks", "1 month" };
		li.add(ud);
		System.out.println(li.size() + " this is initial size");
		Thread.sleep(5000);
		objFileFormatConverter.writeToCSVFile(li, backupfiledownloadpath1);
		objTemplatesList.clickOnBrowse(backupfiledownloadpath1);
		objLocations.clickOnImportCSV();
		Thread.sleep(5000);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.enterTextInUserNameSearchField(
				objUser_data.strNewUserName4).clickOnSearch();
		objUserManagement
				.verUserWithACLGroup(objUser_data.strNewUserName4,
						objUser_data.telemedicineRefMD)
				.clickOnModifyUser(objUser_data.strNewUserName4)
				.verUserFirstName(objUser_data.strUserFirstName)
				.verUserMiddleName(objUser_data.strUserMiddleName)
				.verUserLastName(objUser_data.strUserLastName)
				.verLocationAndRefLoc(objLocations_data.strfacilityname)
				.verLocationAndRefLoc(objLocations_data.strRefLocation)
				.verReceiveReferralsOpenRadioButtonIsSelected()
				.verEmailID(objUser_data.emailAddress)
				.verAdditionalEmailIDs(
						objUser_data.additionalEmailAddress + "|"
								+ objUser_data.additionalEmailAddress1)
				.verFax(objUser_data.fax)
				.verDoctorID(objUser_data.DoctorID)
				.verPhone(objUser_data.phoneNum)
				.verByReferring(
						objUser_data.strNewUserName + ";"
								+ objUser_data.strNewUserName1)
				.verByConsulting(
						objUser_data.strNewUserName2 + ";"
								+ objUser_data.strNewUserName3)
				.verByServiceLocation(strrefloc + ";" + strrefloc1)
				.verSpecialists(
						objUser_data.strNewUserName2 + ";"
								+ objUser_data.strNewUserName3)
				.verAllowedConsultTypesAndEMailNotificationsCheckboxesIsSelected(
						objUser_data.strDermatology)
				.verAllowedConsultTypesAndEMailNotificationsCheckboxesIsSelected(
						objUser_data.strOphthalmology)
				.verAllowedConsultTypesAndEMailNotificationsCheckboxesIsSelected(
						objUser_data.strConsReportAvoilable)
				.verAllowedConsultTypesAndEMailNotificationsCheckboxesIsSelected(
						objUser_data.strCaseReturned)
				.verAllowedConsultTypesAndEMailNotificationsCheckboxesIsNotSelected(
						objUser_data.strRepliesAddedToCase)
				.verCaseNotOpenedDropdownValue("1 day")
				.verSignedReportNotGeneratedDropdownValue("1 week")
				.verResponseNotAddedDropdownValue("2 weeks")
				.verCaseRemainedDraftDropdownValue("1 month")

				.verWithActiveXFreeRadioBtnSelected()
				.verWebViewerRadioBtnSelected();
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}

}
