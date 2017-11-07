package RequirementGroups.CreateAndManageRoles;

import org.testng.annotations.Test;

import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.Login;
import EMR.pages.Shared;
import EMR.pages.UsersList;
import qaFramework.Configurations.Configuration;

public class AssigningUserToARole extends Configuration {

	public AssigningUserToARole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Login login;
	Shared navigateTo; 
	UsersList usersList;
	UsersCreateData userDataCreation;
	
	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay127961"})
	public void HappyDay127961() throws Exception {
		
		TCID = "127961";
		TC_DESCRIPTION = " Verify that users can be assigned a role from 'Roles List' screen ";
	
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(userDataCreation.name12, UsersData.INITIAL_PASSWORD, userDataCreation.fullName6, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
			     .clickOnSave();
		Result = "PASS";
	}
}
