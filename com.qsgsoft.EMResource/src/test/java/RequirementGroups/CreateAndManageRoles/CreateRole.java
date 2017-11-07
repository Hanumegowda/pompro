package RequirementGroups.CreateAndManageRoles;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.RolesData;
import EMR.data.StatusReasonData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusReasonData.StatusReasonCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.Login;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.RolesList;
import EMR.pages.Shared;
import EMR.pages.StatusReasonList;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewsUnderSetup;
import RequirementGroups.SettingUpStatusTypes.CreateStatusReason;
import qaFramework.Configurations.Configuration;

public class CreateRole extends Configuration {

	public CreateRole() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	Login login;
	StatusTypes statusTypes;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ViewData viewData;
	ViewCreateData viewDataCreation;
	Shared navigateTo; 
	ResourceTypes resourceTypes;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	Resources resources;
	ResourceCreateData resourceDataCreation;
	UsersList usersList;
	UsersCreateData usersDataCreation;
	RolesList rolesList;
	RolesData rolesData;
	RolesCreateData rolesDataCreation;
	View view;
	ViewsUnderSetup viewsUnderSetup;
	UsersData usersData;
	StatusReasonList statusReasonList;
	StatusReasonData StatusReasonData;
	StatusReasonCreateData creatStatusReasonData;
	
	ArrayList<String> StatusTypeName = new ArrayList<String>();
	ArrayList<String> statusTypeValue = new ArrayList<String>();
	
	@Test (groups = {"HappyDay", " Create And Manage Roles ", "HappyDay139772"})
	public void HappyDay139772() throws Exception {

		TCID = "139772";
		TC_DESCRIPTION = "Verify that user provided with 'Setup Resources' right in a role and with update status right on a resource can create/edit a sub-resource under it.";
	
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//		navigateTo.statusTypes();
//		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description, viewDataCreation.section);
//		statusTypeValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName));
//		statusTypes.createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.tstName, statusTypeDataCreation.description, viewDataCreation.section);
//		statusTypeValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName));
//		
//		navigateTo.resourceType();
//		/*createResourceType--------->NEW(by using ST1)
//		
//		navigateTo.resources();
//		resources.createResource(resourceDataCreation.name, resourceDataCreation.abbrevation, resourceTypeDataCreation.name, 
//				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME);
//		resources.createResource(resourceDataCreation.name1, resourceDataCreation.abbrevation, resourceTypeDataCreation.name1, 
//				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME);	
//		createSubResource---------->NEW(By selecting ST2)
//		
//		RolesList.createRoleSelectingSetUpResourceRight------------------->NEW
//					provideSetUpResourceRight
//		
//		UsersList.createUserWithViewResourceAndUpdateResourceRight------NEW(RES 1)
//				    viewResourceRightOn(RS2)
//				    createRoleDeselectUpdateRight	
//		viewUnderSetup.createViewSelectingMultipleRSAndST
//				    		
//		
//		*/
//		
//		Result = "PASS";
//	}
//	
////	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay139772"})
////	public void HappyDay139772() throws Exception {
////
////		TCID = "139772";
////		TC_DESCRIPTION = "Verify that user provided with 'Setup Resources' right in a role and with update status right on a resource can create/edit a sub-resource under it.";
////	
////		
////		Result = "PASS";
////	}
//	
//	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay69128"})
//	public void HappyDay69128() throws Exception {
//		
//		TCID = "69128";
//		TC_DESCRIPTION = " Verify that a user can be provided a role with right to update region setup information.";
//	
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//		
//	/*	navigateTo.users();
//		usersList.createUserWithRole(usersDataCreation.name, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName, UsersData.EMAILID1, UsersData.EMAILID1, roleValue)
//				  .clickOnSave();
//				  
//		navigateTo.roles();	
//		rolesList.clickOnCreateNewRoleBtn
//				 .createRoleWithSetupRegionInformationRight()--------------->NEW
//			  	  enterRoleName
//		usersList.provideSetupRegionInformationRight()-------------->NEW
//		role.verifyRoleCreated------------>NEW
//		
//		navigateTo.users();
//		usersList.clickOnEdit()
//				  selectRole()
//				  clickOnSave()
//				  verifyUserList();
//				  
//		login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
//		navigateTo.regions();
//		regionList.verifyRegionListPage();------------->NEW (doubt)
//					clickOnEdit
//					editRegionPage------------>NEW
//					editMAndatoryRegionData------------>NEW
//					clickOnSave
//					
//		navigateTo.map()
//		verifyRegionalMapViewPage------------------->NEW
//		verifySaveAsRegionDefaultButton--------------->NEW
//		clickSaveAsRegionDefault------------------>NEW
//		closePopUpWindow------------->NEW
//				  
//		*/
//		
//		Result = "PASS";
//	}
//	
//	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay69139"})
//	public void HappyDay69139() throws Exception {
//		
//		TCID = "69139";
//		TC_DESCRIPTION = "  Verify that a user can be provided a role with right to setup resource types.";
//		
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//		navigateTo.users();
//		usersList.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(userDataCreation.name12, UsersData.INITIAL_PASSWORD, userDataCreation.fullName6, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
//			     .clickOnSave();
//		
//	  /*navigateTo.roles();
//		rolesList.clickOnCreateNewRoleBtn();
//				 .verifyRoleListPage()------------------->NEW
//	 	String ROLE_VALUE = rolesList.getRoleValue(rolesDataCreation.name);
//		rolesList.createRole(rolesDataCreation.name1);
//				 createRoleWithSetupResourceType---------------->NEW
//				 verifyRoleInRoleListPage----------------->NEW
//		
//		navigateTo.statusTypes();
//		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description, viewDataCreation.section);
//		statusTypeValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName));	
//				 
//		navigateTo.users();
//		usersList.searchUserName
//				 clickOnEdit(userDataCreation.name12);
//				 deselectAllRoles()
//				 selectRole()
//				 clickOnSave()
//				 verifyUsersListPage
//				 
//		login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
//		navigateTo.resourceType();
//		resourceTypes.verifyResourceTypeListPage-------------->NEW
//		
//		resourceTypes.createResourceType
//				 	 VerifyResourceTypeInList()
//				 	 editMandatoryDeatailsOfResourceType()------------------>NEW
//				 	 				clickOnEdit
//				 	 				enterResourceTypesName(resourceTypeDataCreation.name);
//				 					clickOnSaveButton
//				 	VerifyResourceTypeInList()	
//		
//		navigateTo.resources();
//		resources.createResource(resourceDataCreation.name, resourceDataCreation.abbrevation, resourceTypeDataCreation.name, 
//		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME);	
//		
//		resources.createResource(resourceDataCreation.name1, resourceDataCreation.abbrevation, resourceTypeDataCreation.name, 
//				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME);	
//				 				
//		*/
//		
//		
//		Result = "PASS";
//	}
//	
//	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay69153"})
//	public void HappyDay69153() throws Exception {
//		
//		TCID = "69153";
//		TC_DESCRIPTION = "   Verify that a user can be provided a role with right to setup resource.";
//		
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
///*		
//		navigateTo.views();
//		viewsUnderSetup.createView(viewName, viewDescription, resourceName, statusTypeNames)
//		
//		navigateTo.users();
//					createUserWithUpdateRightOnResource();
//		
//		navigateTo.roles();
//		rolesList.clickOnCreateNewRoleBtn();
//				 .verifyRoleListPage()------------------->NEW
//	 	String ROLE_VALUE = rolesList.getRoleValue(rolesDataCreation.name);
//		rolesList.createRole(rolesDataCreation.name1);
//				 createRoleWithSetupResource---------------->NEW
//				 verifyRoleInRoleListPage----------------->NEW
//		
//		navigateTo.users();
//		usersList.searchUserName
//				 clickOnEdit(userDataCreation.name12);
//				 deselectAllRoles()
//				 selectRole(ROLE_VALUE)
//				 clickOnSave()
//				 verifyUsersListPage
//		
//		login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
//		navigateTo.resources();
//		resources.verifyResourceListPage-------------->NEW
//		
//		resources.createResource(resourceDataCreation.name3, resourceDataCreation.abbrevation, resourceTypeDataCreation.name, 
//				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME)
//				verifyResourceIsPresentUnderResourceListPage()
//		
//				editResourceName(resourceDataCreation.name1,resourceDataCreation.editName1);
//				verifyResourceIsPresentUnderResourceListPage()
//		
//		navigateTo.views();	
//				  .particularView(viewName)	
//				  clickOnResourceLinkUnderView--------------->NEW
//		resources.editResource(resourceDataCreation.edit1Name1)---------------------------->NEW
//				 		enterResourceName(resourceDataCreation.edit1Name2)
//				 		EnterAbrivation	
//						selectResourceType
//						selectStandardResourceType
//						enterFirstName
//						enterLastName
//						clickOnSave
//						verifyAssignUsersToResourcePage
//						clickOnSave
//						verifyResourceIsPresentUnderResourceListPage
//			resources.verifyResourceIsPresentUnderResourceListPage()		
//						
//		navigateTo.map();
//		map.selectResourceNameInFindResourceDropdown(resourceDataCreation.edit1Name2)
//			.verifyResourceInPopupWindow();
//		editInfo-------------->NEW
//				enterResourceName(resourceDataCreation.edit1Name3)	
//				EnterAbrivation
//				clickOnSave		
//				
//		navigateTo.map();
//		map.selectResourceNameInFindResourceDropdown(resourceDataCreation.name2)
//			.verifyResourceInPopupWindow();
//		editInfo-------------->NEW
//				enterResourceName(resourceDataCreation.editName2)	
//				EnterAbrivation
//				clickOnSave			
//		
//		*/
//		Result = "PASS";
//		
//	}
//	
//	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay69154"})
//	public void HappyDay69154() throws Exception {
//		
//		TCID = "69154";
//		TC_DESCRIPTION = " Verify that a user can be provided a role with right 'Edit resources only'";
//		
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//		
//		/*view created in tc HappyDay69153
//		 
//		 navigateTo.users();
//		     createUserWithUpdateRightOnResource ();
//		     
//		 navigateTo.roles();
//		rolesList.clickOnCreateNewRoleBtn();
//				 .verifyRoleListPage()------------------->NEW
//	 	String ROLE_VALUE = rolesList.getRoleValue(rolesDataCreation.name);
//		rolesList.createRole(rolesDataCreation.name1);
//				 createRoleWithEditResourceOnly---------------->NEW
//				 verifyRoleInRoleListPage----------------->NEW
//		
//		navigateTo.users();
//		usersList.searchUserName
//				 clickOnEdit(userDataCreation.name12);
//				 deselectAllRoles()
//				 selectRole(ROLE_VALUE)
//				 clickOnSave()
//				 verifyUsersListPage
//				 
//		login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
//		navigateTo.resources();
//		resources.verifyResourceListPage-------------->NEW		 
//				 verifyCreateNewResourceButtonIsNotPresent--------->NEW
//				 verifyResourceIsPresentUnderResourceListPage
//				 
//		editResourceName(resourceDataCreation.name1,resourceDataCreation.editName1);
//				verifyResourceIsPresentUnderResourceListPage()
//				 
//		navigateTo.views();	
//				  .particularView(viewName)	
//				  clickOnResourceLinkUnderView--------------->NEW
//		resources.editResource(resourceDataCreation.edit1Name1)---------------------------->NEW
//				 		enterResourceName(resourceDataCreation.edit1Name2)
//				 		EnterAbrivation	
//						selectResourceType
//						selectStandardResourceType
//						enterFirstName
//						enterLastName
//						clickOnSave
//						verifyAssignUsersToResourcePage
//						clickOnSave
//						verifyResourceIsPresentUnderResourceListPage
//		resources.verifyResourceIsPresentUnderResourceListPage()		
//								 
//		navigateTo.map();
//		map.selectResourceNameInFindResourceDropdown(resourceDataCreation.edit1Name2)
//			.verifyResourceInPopupWindow();
//		
//		editInfo-------------->NEW
//				enterResourceName(resourceDataCreation.edit1Name3)	
//				EnterAbrivation
//				clickOnSave		
//		
//		*/
		Result = "PASS";
	}	
	
	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay69155"," Create role","EMResource Base"})
	public void HappyDay69155() throws Exception {
		
		TCID = "69155";
		TC_DESCRIPTION = " Verify that a user can be provided a role with right to setup status reasons.";
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		
		usersList = new UsersList(this.driver);
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		statusReasonList = new StatusReasonList(this.driver);
		StatusReasonData = new StatusReasonData();
		creatStatusReasonData = StatusReasonData.new StatusReasonCreateData();
		rolesList = new RolesList(this.driver);
		rolesData = new RolesData();
		rolesDataCreation =rolesData. new RolesCreateData();
	  
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
	 		 
	    navigateTo.users();
	    usersList.createUserWithMandatoryDetailsAndEMailPager(usersDataCreation.name, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName, UsersData.EMAILID1, UsersData.EMAILID1);			
	    
	    navigateTo.roles();
	    rolesList.createRoleWithSetupStatusReason(rolesDataCreation.name);
	    String ROLE_VALUE = rolesList.getRoleValue(rolesDataCreation.name);	
	    rolesList.verifyRoleInRoleListPage(rolesDataCreation.name);
	  			
	    navigateTo.users();

	    usersList.searchUserName(usersDataCreation.name)
	    		 .clickOnEdit(usersDataCreation.name)
	    		 .deselectAllRoles()
	    		 .selectRole(ROLE_VALUE)
	    		 .clickOnSave()
	    		 .verifyUsersListPage();
	    
	    login.logOut();
				 
	  login.loginAsNewUser(usersDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
	  			 			
	  navigateTo.statusReasons();
	  statusReasonList.verifyStatusReasonList()
	  				  .createStatusReason(creatStatusReasonData.name, creatStatusReasonData.definition)
	  				  .verifyCreatedStatusReasonInList(creatStatusReasonData.name)
	  				  .editDefinitionAndAbbreviation(creatStatusReasonData.name, creatStatusReasonData.editDefinition,creatStatusReasonData.abbreviation)
	  				  .verifyCreatedStatusReasonInList(creatStatusReasonData.name);
	  				  	
		Result = "PASS";
	}
//	
//	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay69157"," Create role","EMResource Base"})
//	public void HappyDay69157() throws Exception {
//		
//		TCID = "69157";
//		TC_DESCRIPTION = " Verify that a user can be provided a role with right to view user information only.";
//		
	   /*login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
	    
	     navigateTo.users();
	     usersList.createUserWithMandatoryDetailsAndEMailPager(usersDataCreation.name, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName, UsersData.EMAILID1, UsersData.EMAILID1);			
	 
	     navigateTo.roles();
	     rolesList.createRoleWithViewUserInformationOnlyRight()----------->NEW
	     			clickOnCreateNewRoleBtn
	     			verifyCreateRolePage()----------------->Writing in previous tc
	  			    enterRoleName
	  			    provideViewUserInformationOnlyRight();--------->NEW
	  	String ROLE_VALUE = rolesList.getRoleValue(rolesDataCreation.name1);		    
	  			    verifyRoleInRoleListPage--------Writing in previous tc
	  			
	     navigateTo.users();
	     
	     usersList.searchUserName(usersDataCreation.name);
				 clickOnEdit(userDataCreation.name);
				 deselectAllRoles()
				 selectRole(ROLE_VALUE)
				 clickOnSave()
				 verifyUsersListPage
				 
	    login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);		 
	    navigateTo.usersUnderRegionalInfo();
	    usersList.verifyAllActiveUserInUserList();
	    		  verifyCreateLinkIsNotPresent();
	    		  verifyEditLinkIsNotPresent();
	    		  verifyPasswordResetLinkIsNotPresent();
	    
		navigateTo.verifyNoSetupTab();
		
       */		
//		Result = "PASS";
//	}
//	
//	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay69158"," Create role","EMResource Base"})
//	public void HappyDay69158() throws Exception {
//		
//		TCID = "69158";
//		TC_DESCRIPTION = " Verify that a user can be provided a role with right to setup Roles.";
		
		/*login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
	    
	     navigateTo.users();
	     usersList.createUserWithMandatoryDetailsAndEMailPager(usersDataCreation.name, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName, UsersData.EMAILID1, UsersData.EMAILID1);			
	
		 navigateTo.roles();
		 roleList.createRoleWithSetupRoleRight------------>NEW
		            clickOnCreateNewRoleBt
		            verifyCreateRolePage()----------------->Writing in previous tc
	  			    enterRoleName
	  			    provideSetupRoleRight---------->NEW
	  	 String ROLE_VALUE = rolesList.getRoleValue(rolesDataCreation.name1);		    
	  			    verifyRoleInRoleListPage--------Writing in previous tc
	  			
	
		 navigateTo.users();
	     usersList.searchUserName(usersDataCreation.name);
				 clickOnEdit(userDataCreation.name);
				 deselectAllRoles()
				 selectRole(ROLE_VALUE)
				 clickOnSave()
				 verifyUsersListPage
	
		 login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);	
		 
		 navigateTo.roles();
		 roleList.verifyRoleListPage();
		         .createRole();
		          verifyRoleInRoleListPage--------Writing in previous tc
		          clickEditRole
		          enterRoleName
		          clickOnSave
		         verifyRoleInRoleListPage--------Writing in previous tc
	
//	   */
//		Result = "PASS";
//	}
//	
//	@Test (groups = {"HappyDay", "Create And Manage Roles", "HappyDay69175"," Create role","EMResource Base"})
//	public void HappyDay69175() throws Exception {
//		
//		TCID = "69175";
//		TC_DESCRIPTION = "  Verify that a user can be provided a role with right to view custom view.";
//		
	/*	login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypeValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName));
		
		
		navigateTo.resourceType();
		createResourceType-------(by using ST1)
		
		navigateTo.resources();
		resources.createResource(resourceDataCreation.name, resourceDataCreation.abbrevation, resourceTypeDataCreation.name, 
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME);
		
		navigateTo.users();
	    usersList.createUserWithMandatoryDetailsAndEMailPager(usersDataCreation.name, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName, UsersData.EMAILID1, UsersData.EMAILID1);			
	
		navigateTo.roles();
		roleList.createRoleWithViewCustomViewOption------------>NEW
		          verifyRoleInRoleListPage--------Writing in previous tc
		         
		navigateTo.users();
	    usersList.searchUserName(usersDataCreation.name);
				 clickOnEdit(userDataCreation.name);
				 deselectAllRoles()
				 selectRole(ROLE_VALUE)
				 clickOnSave()
				 verifyUsersListPage            
	  			 
		login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);	
		
		navigateTo.customizedViewUnderPreferences();
		view.verifyEditCustomViewPage();
		     createCustomView();
		     verifyCreatedCustomView();---------------->NEW(verifyStatustype and Resource)
	    navigateTo.createCustomView
	    view.verifyCustomViewTablePage()
	          clickOnCustomize()
	          verifyEditCustomViewPage();
		     
		*/
//		Result = "PASS";
//	}	
}