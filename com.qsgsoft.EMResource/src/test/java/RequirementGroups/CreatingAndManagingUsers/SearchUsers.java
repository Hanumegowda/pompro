package RequirementGroups.CreatingAndManagingUsers;

import java.util.ArrayList;
import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.RolesData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.Login;
import EMR.pages.RolesList;
import EMR.pages.Shared;
import EMR.pages.UsersList;

public class SearchUsers extends Configuration {

	public SearchUsers() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	UsersData usersData;
	UsersCreateData usersDataCreation;
	RolesData roleData;
	RolesCreateData rolesDataCreation;

	Login login;
	Shared navigateTo;
	UsersList usersList;
	RolesList roles;

	static String USER_1;

	@Test(groups = {"HappyDay", "Creating And Managing Users", "HappyDay69757"})
	public void HappyDay69757() throws Exception {

		TCID = "69757";
		TC_DESCRIPTION = "Verify that users can be searched by providing a search criteria in the user list screen.";

		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		roleData = new RolesData();
		rolesDataCreation= roleData.new RolesCreateData();

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		roles = new RolesList(this.driver);

		String username		= usersDataCreation.name,
				userFullName = usersDataCreation.fullName,
				username1		= usersDataCreation.name1,
				userFullName1 = usersDataCreation.fullName1,
				username2		= usersDataCreation.name2,
				userFullName2 = usersDataCreation.fullName2,
				role1		= rolesDataCreation.name,
				role2		= rolesDataCreation.name1,
				role3		= rolesDataCreation.name2,
				blank_search	= "";

		ArrayList<String> roleValues = new ArrayList<String>();
		USER_1 = username;

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);

		navigateTo.roles();
		roles.createRole(role1);
		roleValues.add(roles.getRoleValue(role1));

		roles.createRole(role2);
		roleValues.add(roles.getRoleValue(role2));

		roles.createRole(role3);
		roleValues.add(roles.getRoleValue(role3));

		navigateTo.users();
		usersList.createUserWithMandatoryDetailsAndSave(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, roleValues.get(0))
		.createUserWithMandatoryDetailsAndSave(username1, UsersData.INITIAL_PASSWORD, userFullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, roleValues.get(1))
		.createUserWithMandatoryDetailsAndSave(username2, UsersData.INITIAL_PASSWORD, userFullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, roleValues.get(2));

		usersList.searchUser(UsersData.SEARCH_ROLE, UsersData.SEARCH_RT, UsersData.SEARCH_FIELD_USERNAME, UsersData.SEARCH_CRITERIA, username)
		.verifyUserInUsersList(username)
		.searchUser(role1, UsersData.SEARCH_RT, UsersData.SEARCH_FIELD_USERNAME, UsersData.SEARCH_CRITERIA, blank_search)
		.verifyUserInUsersList(username);
		
		navigateTo.users();
		usersList.searchUser(UsersData.SEARCH_ROLE, UsersData.SEARCH_RT, UsersData.SEARCH_FIELD_USERNAME, UsersData.SEARCH_CRITERIA, username1)
		.verifyUserInUsersList(username1)
		.searchUser(role2, UsersData.SEARCH_RT, UsersData.SEARCH_FIELD_USERNAME, UsersData.SEARCH_CRITERIA, blank_search)
		.verifyUserInUsersList(username1);
		
		navigateTo.users();
		usersList.searchUser(UsersData.SEARCH_ROLE, UsersData.SEARCH_RT, UsersData.SEARCH_FIELD_USERNAME, UsersData.SEARCH_CRITERIA, username2)
		.verifyUserInUsersList(username2)
		.searchUser(role3, UsersData.SEARCH_RT, UsersData.SEARCH_FIELD_USERNAME, UsersData.SEARCH_CRITERIA, blank_search)
		.verifyUserInUsersList(username2);

		login.logOut();

		Result = "PASS";
	}
}