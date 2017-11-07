package DatabaseRefresh_DataCreation.Smoke;

import org.testng.annotations.Test;

import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.RolesData;
import EMR.data.RolesData.RolesTags;
import EMR.data.UsersData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.UsersData.UsersTags;
import EMR.pages.Login;
import EMR.pages.RolesList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.UsersList;
import qaFramework.Configurations.Configuration;

public class PreconditionForIntegrationWithOtherProducts extends Configuration {

	public PreconditionForIntegrationWithOtherProducts() throws Exception {
		super();
	}

	UsersCreateData userDataCreation;
	UsersData usersData;
	RolesData rolesData;
	RolesCreateData rolesDataCreation;
	
	Login login;
	SelectRegion selectRegion;
	Shared navigateTo;
	
	UsersList usersList;
	RolesList rolesList;
	
	@Test(description = "Precondition for tc 186548")
	public void Precondition_186546() throws Exception {

		TCID = "186546";
	    TC_DESCRIPTION = "Precondition for tc 186548";
	    
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		rolesList = new RolesList(this.driver);
		
		usersData = new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		rolesData = new RolesData();
		rolesDataCreation = rolesData.new RolesCreateData();
		String roleValue = "";

		login.loginToApplication(
				LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.STATE_OF_MISSOURI);
		
		navigateTo.roles();
		rolesList.createRole(rolesDataCreation.name);
		roleValue = rolesList.getRoleValue(rolesDataCreation.name);
		
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsAndUpdateRightOnResource(userDataCreation.name, UsersData.INITIAL_PASSWORD,
				userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, roleValue, ResourceData.SETRAC_RESOURCE_FREEMAN_WEST)
				 .clickOnSave();
		
		login.logOut();

		login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
			 .logOut();

		userDataCreation.writeUsersDataToXml(userDataCreation.name, UsersTags.USER_WITH_UPDATE_RIGHT_ON_FRREMAN_WEST);
		rolesDataCreation.writeRolesDataToXml(roleValue, RolesTags.STATE_OF_MISSOURI_ROLE_VALUE);
		rolesDataCreation.writeRolesDataToXml(rolesDataCreation.name, RolesTags.STATE_OF_MISSOURI_ROLE_NAME);
		
		Result = "PASS";
	}
	
	@Test(description ="Precondition for 186230")
	public void Precondition_186278() throws Exception {

		TCID = "186278";
	    TC_DESCRIPTION = "Precondition for 186230";
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);

		usersList = new UsersList(this.driver);
		rolesList = new RolesList(this.driver);

		usersData = new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		rolesData = new RolesData();
		rolesDataCreation = rolesData.new RolesCreateData();
		String roleValue = "";

		login.loginToApplication(
				LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);

		selectRegion.selectRegionAndClickOnNext(RegionData.SETRACREGION);

		navigateTo.roles();
		rolesList.createRole(rolesDataCreation.name);
		roleValue = rolesList.getRoleValue(rolesDataCreation.name);

		System.out.println("roleValue"+ roleValue);

		navigateTo.users();
		usersList.createUserWithMandatoryDetailsAndEMailPager(userDataCreation.name, UsersData.INITIAL_PASSWORD,
				userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, roleValue)
				.selectUpdateStatusOfResource(ResourceData.SETRAC_RESOURCE_BAYSHORE_MEDICAL)
				.provideReceiveIncomingPatientNotificationsRightAndSave()
				.enableUserToReceivePagerAndMailNotifiactionsOfIPN(userDataCreation.name);
		System.out.println(userDataCreation.fullName);
		login.logOut();
		System.out.println(userDataCreation.fullName);

		login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD) 
		.logOut();

		userDataCreation.writeUsersDataToXml(userDataCreation.name, UsersTags.SETRAC_IPN_USER);
		userDataCreation.writeUsersDataToXml(userDataCreation.fullName, UsersTags.SETRAC_IPN_USER_FULLNAME);
		rolesDataCreation.writeRolesDataToXml(rolesDataCreation.name, RolesTags.SETRAC_REGION_ROLE);
		rolesDataCreation.writeRolesDataToXml(roleValue, RolesTags.SETRAC_REGION_ROLE_VALUE);
		
		Result = "PASS";
	}
}
