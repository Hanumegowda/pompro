package RequirementGroups.CreatingAndManagingUsers;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.SharedData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.Login;
import EMR.pages.RegionDefault;
import EMR.pages.RegionList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.UsersList;

public class SwitchUser extends Configuration {

	public SwitchUser() throws Exception {
		super();
	}

	LoginData loginData;
	UsersData usersData;
	UsersCreateData usersDataCreation;

	Login login;
	RegionDefault regionDefault;
	Shared navigateTo;
	UsersList usersList;
	SelectRegion selectRegion;
	RegionList regions;
	
	static String USER_1, REGION_VALUE_2, USER_FULL_NAME;
	@Test(groups = {"HappyDay", "Creating And Managing Users", "HappyDay69042"})
	public void HappyDay69042() throws Exception {
		
		TCID = "69042";
		TC_DESCRIPTION = "Verify that RegAdmin can switch to another user.";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		regionDefault = new RegionDefault(this.driver);
		
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		
		String username		= usersDataCreation.name,
				   userFullName = usersDataCreation.fullName;
		USER_1 = username;
		USER_FULL_NAME = userFullName;
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);

		navigateTo.users();
		
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				.provideConfigureRegionalUserAccessRight()
				.clickOnSave()
				.searchUser(UsersData.SEARCH_ROLE, UsersData.SEARCH_RT, UsersData.SEARCH_FIELD_USERNAME, UsersData.SEARCH_CRITERIA, username)
				.switchToUserAsAdmin(username);
		
		navigateTo.verifySubMenuIsPresent(SharedData.USERS_UNDER_SETUP)
				  .users();
		
		regionDefault.verifyUsernameAtFooter(username, USER_FULL_NAME, LoginData.ADMINUSERNAME);
		login.logOut();
		
		Result = "PASS";
	}
	
	@Test(dependsOnMethods = {"HappyDay69042"}, groups = {"HappyDay", "Creating And Managing Users", "HappyDay162623"})
	public void HappyDay162623() throws Exception {
		
		TCID = "162623";
		TC_DESCRIPTION = "Switch to another user from System Admin and verify that the app switcher is disabled";
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);

		navigateTo.users();
		
		usersList.searchUser(UsersData.SEARCH_ROLE, UsersData.SEARCH_RT, UsersData.SEARCH_FIELD_USERNAME, UsersData.SEARCH_CRITERIA, USER_1)
				 .switchToUserAsAdmin(USER_1);
		
		navigateTo.verifyAppSwitcher_Disabled();
		login.logOut();
		
		Result = "PASS";
	}
	
	@Test(dependsOnMethods = {"HappyDay69032"}, groups = {"HappyDay", "Creating And Managing Users", "HappyDay32727", "Remove A User From A Region"})
	public void HappyDay32727() throws Exception {
		
		TCID = "32727";
		TC_DESCRIPTION = "Verify that RegAdmin can remove access from regions for a user who currently have access to multiple regions.";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		selectRegion = new SelectRegion(this.driver);
		regions = new RegionList(this.driver);
		regionDefault = new RegionDefault(this.driver);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGION_NAME_2);
		
		navigateTo.users();
		usersList.searchUser(UsersData.SEARCH_ROLE, UsersData.SEARCH_RT, UsersData.SEARCH_FIELD_USERNAME, UsersData.SEARCH_CRITERIA, USER_1)
		.removeMultiRegionAccessToUser(USER_1, REGION_VALUE_2);
		
		login.logOut()
		.loginAsUser(USER_1, UsersData.PASSWORD);
		regionDefault.verifyRegionName(RegionData.REGIONNAME);
		selectRegion.verifyUserCannotSwitchRegions();
		login.logOut();
		
		Result = "PASS";
	}
	
	@Test(dependsOnMethods = {"HappyDay69042"}, groups = {"HappyDay", "Creating And Managing Users", "HappyDay69032", "Provide Access To Regions For A Uuser"})
	public void HappyDay69032() throws Exception {
		
		TCID = "69032";
		TC_DESCRIPTION = "Give access to multiple regions for an active user and verify that the user can log into all the selected regions.";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		selectRegion = new SelectRegion(this.driver);
		regions = new RegionList(this.driver);
		regionDefault = new RegionDefault(this.driver);
		
		ArrayList<String> regionNames = new ArrayList<String>();
		regionNames.addAll(Arrays.asList(RegionData.REGIONNAME, RegionData.REGION_NAME_2));
		ArrayList<String> regionValues = new ArrayList<String>();
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		
		navigateTo.regions();
		regionValues.add(regions.getRegionValue(regionNames.get(0)));
		regionValues.add(regions.getRegionValue(regionNames.get(1)));
		REGION_VALUE_2 = regionValues.get(1);
		navigateTo.users();
		usersList.searchUser(UsersData.SEARCH_ROLE, UsersData.SEARCH_RT, UsersData.SEARCH_FIELD_USERNAME, UsersData.SEARCH_CRITERIA, USER_1)
				 .provideMultiRegionAccessToUser(USER_1, regionValues);
		
		login.logOut()
		.loginAsNewUser(USER_1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		regionDefault.verifyRegionDefaultPage()
					 .verifyRegionName_AccessToMultipleRegions(RegionData.REGION_NAME_2);
		login.logOut()
			.loginAsUser(USER_1, UsersData.PASSWORD);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		regionDefault.verifyRegionDefaultPage()
					 .verifyRegionName_AccessToMultipleRegions(RegionData.REGIONNAME);
		login.logOut();
		
		Result = "PASS";
	}
	
	@Test(dependsOnMethods = {"HappyDay69042"}, groups = {"HappyDay", "Creating And Managing Users", "HappyDay169283", "Creating And Managing Users"})
	public void HappyDay169283() throws Exception {
		
		TCID = "169283";
		TC_DESCRIPTION = "Verify that clicking on 'Return to Self' link returns to the previously logged in user account.";
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);

		navigateTo.users();
		
		usersList.searchUser(UsersData.SEARCH_ROLE, UsersData.SEARCH_RT, UsersData.SEARCH_FIELD_USERNAME, UsersData.SEARCH_CRITERIA, USER_1)
				 .switchToUserAsAdmin(USER_1);
		
		regionDefault.verifyUsernameAtFooter(USER_1, USER_FULL_NAME, LoginData.ADMINUSERNAME);
		usersList.returnToSelf();
		regionDefault.verifyUsernameAtFooter(LoginData.ADMINUSERNAME, LoginData.ADMIN_USER_FULL_NAME);
		
		login.logOut();
		
		Result = "PASS";
	}
}