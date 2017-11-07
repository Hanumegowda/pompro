package DatabaseRefresh_DataCreation.HappyDay;

import org.testng.annotations.Test;

import EMR.data.InterfaceData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.RolesData;
import EMR.data.UsersData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.RolesData.RolesTags;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.UsersData.UsersTags;
import EMR.pages.ConfigureIncomingPatientNotifications;
import EMR.pages.InterfaceSetUp;
import EMR.pages.Login;
import EMR.pages.RegionList;
import EMR.pages.RolesList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.UsersList;
import qaFramework.Configurations.Configuration;

public class PreCondtionForEMResourceIntegartionWithEMTrack extends Configuration{
	
	public PreCondtionForEMResourceIntegartionWithEMTrack() throws Exception {
		super();		
	}
	
	UsersData usersData;
	UsersCreateData usersDataCreation;
	RolesData rolesData;
	RolesCreateData rolesDataCreation;
	
	Login login;
	SelectRegion selectRegion;
	Shared navigateTo;
	InterfaceSetUp interfaceSetup;
	UsersList usersList;
	RolesList rolesList;
	RegionList regionList;
	ConfigureIncomingPatientNotifications incomingPatientNotifications;
	
	/****
	 * Login as Admin to SETRAC region
	 * Navigate To Interface
	 * Verify interface of type 'Post Incoming Patient' is present
	 * Verify any of resource(e.g-Columbus Community*) is selected under 'Edit Interface -- Select Resources' page
	 * Create role by selecting 'IPN - Send Incoming Patient Notifications' right
	 * Create user with 'IPN - Send Incoming Patient Notifications' right
	 * Create user with 'IPN - Receive Incoming Patient Notifications' right
	 * Create user with 'IPN - Receive Incoming Patient Notifications' right and Run report right on any of resource(e.g-Columbus Community*) 
	 * 
	 ****/
	
	@Test(description ="Precondition for Incoming Patient Notification")
	public void Precondition_IncomingPatientNotification() throws Exception {

		TCID = "Precondition_IncomingPatientNotification";
	    TC_DESCRIPTION = "Precondition for Incoming patient notification test cases";
	    
	    usersData = new UsersData();
	    usersDataCreation = usersData.new UsersCreateData();
	    rolesData =new RolesData();
	    rolesDataCreation = rolesData.new RolesCreateData();
	    
	    login = new Login(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	    navigateTo = new Shared(this.driver);
	    interfaceSetup = new InterfaceSetUp(this.driver);
	    usersList = new UsersList(this.driver);
	    rolesList = new RolesList(this.driver);
	    regionList = new RegionList(this.driver);
	    incomingPatientNotifications = new ConfigureIncomingPatientNotifications(this.driver);
	    
	    String roleValue  = "",
	    	   roleValue1 = "";
	    
	    login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
	    selectRegion.selectRegionAndClickOnNext(RegionData.SETRACREGION);
	    
	    navigateTo.regions();
	    regionList.verifyIncomingPatientNotificationsIsEnabledForRegion(RegionData.SETRACREGION);
	    
	    navigateTo.interfaces();
	    interfaceSetup.verifyWebServiceActionIsActive(InterfaceData.POSTINCOMINGPATIENT_INTERFACE_IN_SETRAC, InterfaceData.WEBSERVICEACTION_FOR_POSTINCOMINGPATIENT)
	                  .verifyResourceIsSelectedUnderEditInterfaceSelectResourcesPage(InterfaceData.POSTINCOMINGPATIENT_INTERFACE_IN_SETRAC,ResourceData.SETRAC_RESOURCE_COLUMBUS_COMMUNITY);
	    
	    navigateTo.incomingPatient();
	    incomingPatientNotifications.verifyAllowIPNEnabledAndAllowManualEntryOfIPNIsSelected();
	    
	    navigateTo.roles();
	    
	    rolesList.createRole(rolesDataCreation.name);
	    roleValue = rolesList.getRoleValue(rolesDataCreation.name);
	    
	    rolesList.createRoleSelectingSendIncomingPatientNotifications(rolesDataCreation.name1);
	    roleValue1 = rolesList.getRoleValue(rolesDataCreation.name1);
	    
	    navigateTo.users();
	    usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(usersDataCreation.name, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName, UsersData.EMAILID1, UsersData.EMAILID1)
	             .provideSendIncomingPatientNotificationsRightAndSave()
	             .createUserWithMandatoryDetailsWithRoleWithoutSave(usersDataCreation.name1, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName1, UsersData.EMAILID1, UsersData.EMAILID1)
	             .selectUpdateStatusOfResource(ResourceData.SETRAC_RESOURCE_COLUMBUS_COMMUNITY)
	             .provideReceiveIncomingPatientNotificationsAndReportIPNDetailsRight()
	             .enableUserToReceivePagerAndMailNotifiactionsOfIPN(usersDataCreation.name1);
	    
	    login.logOut(); 
	    
	    login.loginAsNewUser(usersDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
		 .logOut();
	    
	    login.loginAsNewUser(usersDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
		 .logOut();
	    
	    usersDataCreation.writeUsersDataToXml(usersDataCreation.name, UsersTags.SETRAC_USER_WITH_SEND_INCOMING_PATIENT_NOTIFICATION_RIGHT);
	    usersDataCreation.writeUsersDataToXml(usersDataCreation.fullName, UsersTags.SETRAC_USER_WITH_SEND_INCOMING_PATIENT_NOTIFICATION_RIGHT_FULLNAME);
	    usersDataCreation.writeUsersDataToXml(usersDataCreation.name1, UsersTags.SETRAC_USER_WITH_RECEIVE_INCOMING_PATIENT_NOTIFICATION_RIGHT);
	    usersDataCreation.writeUsersDataToXml(usersDataCreation.fullName1, UsersTags.SETRAC_USER_WITH_RECEIVE_INCOMING_PATIENT_NOTIFICATION_RIGHT_FULLNAME);
		rolesDataCreation.writeRolesDataToXml(rolesDataCreation.name, RolesTags.SETRAC_REGION_ROLE_WITHOUT_ANY_RIGHT);
		rolesDataCreation.writeRolesDataToXml(roleValue, RolesTags.SETRAC_REGION_ROLE_VALUE_WITHOUT_ANY_RIGHT);
	}
}
