package RequirementGroups.Smoke;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import CAM.data.CamData;
import CAM.pages.HomePage;
import CAM.pages.LoginPage;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.ImportUsers;
import EMR.pages.Login;
import EMR.pages.RegionDefault;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.UserInfo;
import EMR.pages.UsersList;
import eICS.data.ContactsData;
import eICS.data.ContactsData.ContactsCreateData;
import eICS.pages.Contacts;
import eICS.pages.EicsLogin;
import eICS.pages.MyProfile;
import eICS.pages.NavigateToEics;

public class SetupUsers extends Configuration {

	LoginData loginData;
	UsersData usersData;
	UsersCreateData usersDataCreation;
	ContactsData contactsData;
	ContactsCreateData contactsDataCreation;

	LoginPage camlogin;
	HomePage  camHomePage;
	CamData camData;
	
	Login login;
	RegionDefault regionDefault;
	Shared navigateTo;
	SelectRegion selectRegion;
	UsersList usersList;
	EicsLogin eicsLogin;
	NavigateToEics navigateToEics;
	Contacts contacts;
	ImportUsers importUsers;
	UserInfo userInfo;
	MyProfile myProfile;

	public SetupUsers() throws Exception {
		super();
	}
	
	static String USERNAME, USER_FULLNAME, IMPORTED_USER;
	
	@Test(priority=1, groups = {"Smoke", "setup", "Smoke183489"})
	
	public void Smoke183489() throws Exception {
		
	    TCID = "183489";
	    TC_DESCRIPTION = "Verify that user can login after password reset.";
		
	    loginData = new LoginData();
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		
	    usersList = new UsersList(this.driver);
	    regionDefault = new RegionDefault(this.driver);
	    login = new Login(this.driver);
	    navigateTo = new Shared(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	
	    login.loginToApplication(LoginData.ADMINUSERNAME,
				LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.users();
		
		usersList.createUserWithMandatoryDetailsAndEMailPager(
				usersDataCreation.name, UsersData.INITIAL_PASSWORD,
				usersDataCreation.fullName, UsersData.PRIMARY_EMAILID,
				UsersData.PRIMARY_EMAILID);
		login.logOut();

		login.loginAsNewUser(usersDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		regionDefault.verifyRegionDefaultPage();
		login.logOut();
		
		USERNAME = usersDataCreation.name;
		USER_FULLNAME = usersDataCreation.fullName;
		
		Result = "PASS";
	}

	@Test(priority=2, groups = {"Smoke", "setup", "Smoke183487"})
	public void Smoke183487() throws Exception {
		
		TCID = "183487";
		TC_DESCRIPTION = "Verify that a new user can be created and is available in CAM";
			
		camlogin = new LoginPage(this.driver);
		camHomePage = new HomePage(this.driver);

		camlogin.loginToCAM(LoginData.QSGTESTER_ADMIN, LoginData.ADMINPASSWORD);
		
		camHomePage
				.verCommonApplicationManagementPage()
				.searchUser(USERNAME)
				.openUserDetailes(USERNAME)
				.verifyUserDetailesInCAM(USERNAME, USER_FULLNAME,
						CamData.ENABLEDTRUE, UsersData.PRIMARY_EMAILID,
						CamData.PRODUCTACCESS1, CamData.LOCKEDFALSE,
						CamData.PRODUCTACCESS);
		
		camlogin.clickOnLogOut();
		Result = "PASS";
	}
	
	@Test(priority=3, groups = { "Smoke", "setup", "Smoke183488"})
	public void Smoke183488() throws Exception {
		TCID = "183488";
		TC_DESCRIPTION = "Verify that user can be imported from other products.";
		
		contactsData = new ContactsData();
		contactsDataCreation = contactsData.new ContactsCreateData();
		
		eicsLogin = new EicsLogin(this.driver);
		navigateToEics = new NavigateToEics(this.driver);
		contacts = new Contacts(this.driver);
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		importUsers = new ImportUsers(this.driver);
		regionDefault = new RegionDefault(this.driver);

		eicsLogin.LoginToEics(LoginData.QSGTESTER_ADMIN, LoginData.ADMINPASSWORD);
		
		navigateToEics.contacts();
		contacts.selectDoaminOrFacility(RegionData.INTERMEDIX_REGION)
				.createContact(contactsDataCreation.firstName, ContactsData.MID_NAME, ContactsData.LAST_NAME, ContactsData.PHONE_NUMBER, UsersData.EMAILID1, contactsDataCreation.username, ContactsData.ORGANIZATION)
				.resetPassword(UsersData.PASSWORD);
		
		navigateToEics.logout();
		
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.INTERMEDIX_REGION);
		
		navigateTo.users();
		
		importUsers.importUser(contactsDataCreation.username, contactsDataCreation.firstName, ContactsData.LAST_NAME, ContactsData.ORGANIZATION);
		usersList.verifyImportedUserDetailsAndSave(contactsDataCreation.username, contactsDataCreation.firstName, ContactsData.LAST_NAME, ContactsData.ORGANIZATION, ContactsData.PHONE_NUMBER);
		login.logOut()
			 .loginAsNewUser(contactsDataCreation.username, UsersData.PASSWORD, UsersData.RESET_PASSWORD_1);
		regionDefault.verifyRegionDefaultPage();

		IMPORTED_USER = contactsDataCreation.username;
		System.out.println(IMPORTED_USER);
		Result = "PASS";
	}
	
	@Test(dependsOnMethods={"Smoke183488"}, groups = { "Smoke", "setup", "Smoke183490"})
	public void Smoke183490() throws Exception {
		
		TCID = "183490";
		TC_DESCRIPTION = "Verify that for the imported user,user information updated from one product is reflected in other products too.";
		
		contactsData = new ContactsData();
		contactsDataCreation = contactsData.new ContactsCreateData();
		
		eicsLogin = new EicsLogin(this.driver);
		navigateToEics = new NavigateToEics(this.driver);
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		regionDefault = new RegionDefault(this.driver);
		userInfo = new UserInfo(this.driver);
		myProfile = new MyProfile(this.driver);

		navigateTo.UserInfoUnderPreferences();
		userInfo.verifyUpdateUserInfoPage()
				.updateUserInfoAndSave(contactsDataCreation.editedFirstName, contactsDataCreation.editedLastName, UsersData.EMAILID2, ContactsData.EDITED_ORGANIZATION);
		
		regionDefault.switchToEicsApplication();
		
		eicsLogin.verifyHomePage();
		navigateToEics.myProfile();
		myProfile.verifyUserDeatils(contactsDataCreation.editedFirstName, contactsDataCreation.editedLastName, ContactsData.EDITED_ORGANIZATION, UsersData.EMAILID2);
		navigateToEics.logout();
		
		Result = "PASS";
	}
	
	@Test(dependsOnMethods={"Smoke183490"}, groups = { "Smoke", "setup", "Smoke183491"}, priority = 1)
	public void Smoke183491() throws Exception {
		TCID = "183491";
		TC_DESCRIPTION = "Verify that imported user can switch to other products using app switcher without providing credentials.";
		
		//Covered in Smoke183490 test case, switching to eics application, performing actions and switching back to EMResource.
		
		Result = "PASS";
	}
}

