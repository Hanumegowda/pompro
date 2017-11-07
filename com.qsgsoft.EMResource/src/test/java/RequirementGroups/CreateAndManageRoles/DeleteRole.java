package RequirementGroups.CreateAndManageRoles;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import EMR.data.InstantMessagingData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.RolesData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.FormConfiguration;
import EMR.pages.InstantMessaging;
import EMR.pages.Login;
import EMR.pages.RegionDefault;
import EMR.pages.Resources;
import EMR.pages.RolesList;
import EMR.pages.Shared;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import qaFramework.Configurations.Configuration;

public class DeleteRole extends Configuration{

	public DeleteRole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Login login;
	RolesList rolesList;
	RolesData rolesData;
	RolesCreateData rolesDataCreation;
	Shared navigateTo; 
	UsersList usersList;
	UsersData usersData;
	UsersCreateData usersDataCreation;
	StatusTypes statusTypes;
	StatusTypeData statusTypeData;
	Resources resources;
	FormConfiguration formConfiguration;
	InstantMessaging instantMessaging;
	InstantMessagingData instantMessagingData;
	RegionDefault regionDefault;
	
	
	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay127532"," Delete Role","EMResource v3.24"})
	public void HappyDay127532() throws Exception {
		
		TCID = "127532";
		TC_DESCRIPTION = "Verify that system admin can delete a role ";
		
		login = new Login(this.driver);
		rolesData = new RolesData();
		rolesDataCreation =rolesData. new RolesCreateData();
		rolesList = new RolesList(this.driver);
		navigateTo = new Shared(this.driver);
		usersList =new UsersList(this.driver);
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		statusTypes = new StatusTypes(this.driver);
		statusTypeData = new StatusTypeData();
		resources = new Resources(this.driver);
		formConfiguration = new FormConfiguration(this.driver);
		instantMessaging = new InstantMessaging(this.driver);
		instantMessagingData =new InstantMessagingData();
		regionDefault = new RegionDefault(this.driver);
		
		ArrayList<String> roleValues = new ArrayList<String>();
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.roles();
		rolesList.createRole(rolesDataCreation.name);
		String ROLE_VALUE = rolesList.getRoleValue(rolesDataCreation.name);
		rolesList.createRole(rolesDataCreation.name1);
		String ROLE_VALUE1 = rolesList.getRoleValue(rolesDataCreation.name1);
		roleValues.addAll(Arrays.asList(ROLE_VALUE, ROLE_VALUE1));
		
		navigateTo.users();
		usersList.createUserWithRole(usersDataCreation.name, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName, UsersData.EMAILID1, UsersData.EMAILID1, roleValues.get(0))
				 .clickOnSave();
		
		navigateTo.roles();
		rolesList.deleteRole(rolesDataCreation.name)
				 .verifyRoleIsNotPresentInRoleList(rolesDataCreation.name);
		navigateTo.users();
		usersList.clickOnCreateNewUser()
				 .verifyRoleIsNotPresentInUserPage(roleValues)
				 .clickOnCancel()
				 .searchUser(usersDataCreation.name)
				 .verifyRoleIsNotPresentInUserPage(roleValues)
				 .clickOnCancel()
				 .verifyRoleIsNotPresentInDropDown(roleValues);
		
		navigateTo.statusTypes();
		statusTypes.clickCreateNewStatusTypeButton()
				   .selectStatusType(StatusTypeData.NUMBERTYPE)
				   .clickNextButton()
				   .verifyRoleIsNotPresentInStatusTypePage(roleValues)
				   .clickOnCancel()
				   .editFirstStatusType()
				   .verifyRoleIsNotPresentInStatusTypePage(roleValues)
				   .clickOnCancel();
		
		navigateTo.usersUnderRegionalInfo();
		usersList.verifyRoleIsNotPresentInDropDown(roleValues);
		
		navigateTo.resources();
		resources.navigateTo_AssignUsersToResourcePage();
		usersList.verifyRoleIsNotPresentInDropDown(roleValues);
					
		navigateTo.configureForm();
		formConfiguration.navigateToFormSecuritySettingPage()
						 .verifyRoleNotPresentOnFormSecuritySettingPage(roleValues)
						 .clickOnCancel();
		login.logOut();
		
		login.loginAsUser(usersDataCreation.name, UsersData.PASSWORD);
		
		navigateTo.instantMessaging();
		regionDefault.switchToDefaultFrame();
		instantMessaging.switchToInstantMessagingFrame()
						.navigateToCreateNewChat()
						.selectFindUserType(InstantMessagingData.FIND_USER_TYPE)
						.searchContentText(rolesDataCreation.name)
						.clickOnNext()
						.verifyErrorMessageInCreateNewChatPage(rolesDataCreation.name)
						.clickOncancel();
		
		login.logOut();
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay127533","Delete Role","EMResource v3.24"})
	public void HappyDay127533() throws Exception {
		
		TCID = "127533";
		TC_DESCRIPTION = "Verify that default role set can be deleted by a user with appropriate right";
	
		login = new Login(this.driver);
		rolesData = new RolesData();
		rolesDataCreation =rolesData. new RolesCreateData();
		rolesList = new RolesList(this.driver);
		navigateTo = new Shared(this.driver);
		usersList =new UsersList(this.driver);
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		statusTypes = new StatusTypes(this.driver);
		statusTypeData = new StatusTypeData();
		resources = new Resources(this.driver);
		formConfiguration = new FormConfiguration(this.driver);
		instantMessaging = new InstantMessaging(this.driver);
		instantMessagingData =new InstantMessagingData();
		regionDefault = new RegionDefault(this.driver);

		ArrayList<String> roleValues = new ArrayList<String>();
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		
		navigateTo.roles();
		rolesList.createRole(rolesDataCreation.name);
		String ROLE_VALUE = rolesList.getRoleValue(rolesDataCreation.name);
		roleValues.add(ROLE_VALUE);
		rolesList.makeRoleDefault(rolesDataCreation.name);
		
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithoutSave(usersDataCreation.name, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName, UsersData.EMAILID1, UsersData.EMAILID1)
				 .provideSetupRolesRight()
				 .selectInstantMessaging_InitiateChatSessionRight()
				 .clickOnSave();
		login.logOut();
		
		login.loginAsNewUser(usersDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		
		navigateTo.roles();
		rolesList.deleteRole(rolesDataCreation.name)
				 .verifyRoleIsNotPresentInRoleList(rolesDataCreation.name);
		
		login.logOut();
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.clickOnCreateNewUser()
				 .verifyRoleIsNotPresentInUserPage(roleValues)
				 .clickOnCancel()
				 .searchUser(usersDataCreation.name)
				 .verifyRoleIsNotPresentInUserPage(roleValues)
				 .clickOnCancel()
				 .verifyRoleIsNotPresentInDropDown(roleValues);
			
			navigateTo.statusTypes();
			statusTypes.clickCreateNewStatusTypeButton()
					   .selectStatusType(StatusTypeData.NUMBERTYPE)
					   .clickNextButton()
					   .verifyRoleIsNotPresentInStatusTypePage(roleValues)
					   .clickOnCancel()
					   .editFirstStatusType()
					   .verifyRoleIsNotPresentInStatusTypePage(roleValues)
					   .clickOnCancel();
			
			navigateTo.usersUnderRegionalInfo();
			usersList.verifyRoleIsNotPresentInDropDown(roleValues);
			
			navigateTo.resources();
			resources.navigateTo_AssignUsersToResourcePage();
			usersList.verifyRoleIsNotPresentInDropDown(roleValues);
						
			navigateTo.configureForm();
			formConfiguration.navigateToFormSecuritySettingPage()
							 .verifyRoleNotPresentOnFormSecuritySettingPage(roleValues)
							 .clickOnCancel();
			login.logOut();
			login.loginAsUser(usersDataCreation.name, UsersData.PASSWORD);
			
			navigateTo.instantMessaging();
			regionDefault.switchToDefaultFrame();
			instantMessaging.switchToInstantMessagingFrame()
							.navigateToCreateNewChat()
							.selectFindUserType(InstantMessagingData.FIND_USER_TYPE)
							.searchContentText(rolesDataCreation.name)
							.clickOnNext()
							.verifyErrorMessageInCreateNewChatPage(rolesDataCreation.name)
							.clickOncancel();
		 
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay127534", "Delete Role", "EMResource v3.24"})
	public void HappyDay127534() throws Exception {
		
		TCID = "127534";
		TC_DESCRIPTION = "Verify that user with 'Setup Roles' right can delete a role";
	
		login = new Login(this.driver);
		rolesData = new RolesData();
		rolesDataCreation =rolesData. new RolesCreateData();
		rolesList = new RolesList(this.driver);
		navigateTo = new Shared(this.driver);
		usersList =new UsersList(this.driver);
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		
		navigateTo.roles();
		rolesList.createRole(rolesDataCreation.name2);
		
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithoutSave(usersDataCreation.name12, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName, UsersData.EMAILID1, UsersData.EMAILID1)
				 .provideSetupRolesRight()
				 .clickOnSave();
		login.logOut();
		
		login.loginAsNewUser(usersDataCreation.name12, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		
		navigateTo.roles();
		rolesList.deleteRole(rolesDataCreation.name2)
			     .verifyRoleIsNotPresentInRoleList(rolesDataCreation.name2);
		
		/*navigateTo.users();
//		usersList.createUserWithSetupRoleRight------------------->NEW
//					clickOnCreateNewUser
//					enterUserMandatoryDetailsWithEMailAndPager
//					provideSetUpRoleRight---------->NEW
//					selectRole
//					.clickOnSave();
//					
//		login.loginAsUser(username, password);	
//		
//		*/
//		Result = "PASS";
	}
}
