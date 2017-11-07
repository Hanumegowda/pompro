package RequirementGroups.CreateAndManageRoles;

import org.testng.annotations.Test;

import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.UsersData;
import EMR.pages.Login;
import EMR.pages.Shared;
import qaFramework.Configurations.Configuration;

public class EditRole extends Configuration {

	public EditRole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Login login;
	Shared navigateTo;
	
	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay69278"})
	public void HappyDay69278() throws Exception {
		
		TCID = "69278";
		TC_DESCRIPTION = " Verify that a role can be edited by RegAdmin";
		
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//		navigateTo.roles();
//		/*rolesList.createRoleWithsetupUserAccountRight(rolesDataCreation.name);-------------->NEW
//		 			clickOnCreateNewRoleBtn
//		 			enterRoleName
//		 usersList.provideSetupUserAccount()----------->NEW	
//		 			clickOnSave
//		roleValue = rolesList.getRoleValue(rolesDataCreation.name);
//		
//		navigateTo.users();
//		usersList.createUserWithRole(usersDataCreation.name, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName, UsersData.EMAILID1, UsersData.EMAILID1, roleValue)
//				  .clickOnSave();
//		
//		login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
//		navigateTo.verifySetUpLink();
//		
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//		navigateTo.roles();
//		role.verifyRoleListPage()---------->NEW
//			 clickEditRole
//			 verifyEditRolePage()------------->NEW
//			 deselectSetupUserAccountRight----------->NEW
//			 clickOnSave();
//			 
//		login.loginAsUser(userDataCreation.name2,UsersData.PASSWORD);
//		role.noRoleIsAvailableToUser()------------------>NEW
//		
//		*/
//		Result = "PASS";
	}
}
