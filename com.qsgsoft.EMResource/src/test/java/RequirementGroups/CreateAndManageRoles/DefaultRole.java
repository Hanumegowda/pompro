package RequirementGroups.CreateAndManageRoles;

import java.util.ArrayList;

import org.testng.annotations.Test;

import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.RolesData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.EventManagement;
import EMR.pages.Login;
import EMR.pages.Reports;
import EMR.pages.RolesList;
import EMR.pages.Shared;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.View;
import qaFramework.Configurations.Configuration;

public class DefaultRole extends Configuration {

	public DefaultRole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Login login;
	Shared navigateTo; 
	RolesList rolesList;
	RolesData rolesData;
	RolesCreateData rolesDataCreation;
	UsersList usersList;
	UsersData usersData;
	UsersCreateData usersDataCreation;
	EventManagement eventManagement;
	View view;
	ViewCreateData viewDataCreation;
	StatusTypes statusTypes;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceData resourceData;
	Reports reports;
	
	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay127929"," Default Role","EMResource v3.24"})
	public void HappyDay127929() throws Exception {
		
		TCID = "127929";
		TC_DESCRIPTION = " Verify that a role set as default is selected while creating a new user ";
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement= new EventManagement(this.driver);
		view = new View(this.driver);
		
		rolesData = new RolesData();
		rolesDataCreation =rolesData. new RolesCreateData();
		rolesList = new RolesList(this.driver);
		usersList =new UsersList(this.driver);
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		resourceData=new ResourceData();
		reports = new Reports(this.driver);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		
		navigateTo.roles();
		rolesList.createRole(rolesDataCreation.name2);
		String ROLE_VALUE = rolesList.getRoleValue(rolesDataCreation.name2);
		rolesList.makeRoleDefault(rolesDataCreation.name2);
		
		navigateTo.users();
		
		usersList.createUserWithMandatoryDetailsWithoutSave(usersDataCreation.name2, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName, UsersData.EMAILID1, UsersData.EMAILID1)
				 .verifyRoleIsSelected(ROLE_VALUE)
				 .selectRunReportRightOnResource(resourceData.preferenceResourceName)
				 .provideMaintainEventsRight()
				 .selectViewCustomViewOption()
				 .selectStatusSummuryRight()
				 .clickOnSave();
		
		login.logOut();
		
		login.loginAsNewUser(usersDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.verifyEventManagementPage();
		
		navigateTo.customView();
		view.verifyCustomViewTablePage();
		
		navigateTo.navigateToStatusReports();
		reports.verifyStatusSummaryLink();
		
		Result = "PASS";
	}

//	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay127945"})
//	public void HappyDay127945() throws Exception {
//		
//		TCID = "127945";
//		TC_DESCRIPTION = " Verify that when a user is provided access to multiple regions, user will be provided with the"
//							+ " default role set in that region and has the default viewing rights for the resources added "
//								+ "in region's default view when the user is opened for editing ";
//		
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGION_NAME_2);
//		navigateTo.users();
//		/*usersList.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(userDataCreation.name12, UsersData.INITIAL_PASSWORD, userDataCreation.fullName6, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
//			       .clickOnSave();
//				    provideMultiRegionAccessToUser();
//		
//		navigateTo.users();	
//		usersList.clickOnEdit()
//		role.verifyRoleIsSelected();-------->Writing in previous TC
//	
//		navigateTo.viewUnderSetup();
//		editRegionDefault();--------------->NEW
//		selectResource
//		selectStatusType
//		clickOnSave()
//		
//		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);			
//		verifyResourceInRegionDefaultPage----------->NEW	     
//			     
//		*/
//		
//		Result = "PASS";
//}
}