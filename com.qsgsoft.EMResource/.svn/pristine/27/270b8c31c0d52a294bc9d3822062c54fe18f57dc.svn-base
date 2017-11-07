package RequirementGroups.MultiRegion;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;
import EMR.data.EventData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.RolesData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.RegionData.RegionCreateData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.ConfigureNewRelationship;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.OtherRegionList;
import EMR.pages.RegionDefault;
import EMR.pages.RegionList;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.RolesList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.StatusChangePreferences;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewsUnderSetup;
import qaFramework.Configurations.Configuration;

public class ManagingAndViewingOtherRegions extends Configuration {
	
	LoginData loginData;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceCreateData resourceDataCreation;
	UsersCreateData userDataCreation;
	UsersData usersData;
	RolesData rolesData;
	RolesCreateData rolesDataCreation;
	ResourceData resourceData;
	ViewData viewData;
	ViewCreateData viewDataCreation;
	RegionData  regionData;
	RegionCreateData regionCreateData;
	EventSetUpData eventSetUpData;
	EventSetUpCreateData eventSetupDataCreation;
	EventData eventData;
	EventCreateData eventCreateData;
	
	Login login;
	UsersList usersList;
	SelectRegion selectRegion;
	RegionDefault regionDefault;
	Shared navigateTo;
	RegionList regionList;
	StatusChangePreferences statusChangePreferences;
	RolesList rolesList; 
	View viewsList;
	ViewsUnderSetup viewUnderSetup;
	OtherRegionList otherRegionList;
	ConfigureNewRelationship configurRelationShip;
	EventSetUp eventSetUp;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	Shared shared;
	EventManagement eventManagement;

	public ManagingAndViewingOtherRegions() throws Exception {
		// TODO Auto-generated constructor stub
		
					
	}

	@Test (groups = {"HappyDay", "Multi Region","Managing And Viewing Other Regions", "HappyDay172911"})
	 public void HappyDay172911() throws Exception {
		    
			TCID ="172911";
			TC_DESCRIPTION ="Verify that user having access to multiple region views can view the resources added "
					+ "to 'Multi-Region' view from different regions for which he has access.";
		 
			viewData = new ViewData();
		    viewDataCreation = viewData.new ViewCreateData();
		    statusTypeData=new StatusTypeData();
		    statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		    resourceTypeData=new ResourceTypeData();
		    resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		    resourceData=new ResourceData();
		    resourceDataCreation=resourceData.new ResourceCreateData();
		    usersData=new UsersData();
		    
		    login = new Login(this.driver); 
		    statusTypes = new StatusTypes(this.driver);
		    selectRegion = new SelectRegion(this.driver);
		    navigateTo = new Shared(this.driver);
		    viewUnderSetup = new ViewsUnderSetup(this.driver);
		    usersList = new UsersList(this.driver);
		    resourceTypes = new ResourceTypes(this.driver);
		    resources = new Resources(this.driver);
		    shared=new Shared(this.driver);
		    viewsList =new View(this.driver);
		
		
		
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT2);
		String regionNames[] = {RegionData.REGION_WITH_MUTUAL_AGREEMENT1,RegionData.REGION_WITH_MUTUAL_AGREEMENT2};
		String resourseNames[] = {resourceData.sharedResourceNAME1_MutualAgreement_RG1, resourceData.resourceNAME_MutualAgreement_RG2};
		String[] statustypeNames = {statusTypeData.sharedNSTName_InMutualAgreemnet_RG1,statusTypeData.sharedMSTName_InMutualAgreemnet_RG1,statusTypeData.sharedTSTName_InMutualAgreemnet_RG1,
				statusTypeData.sharedNedocName_InMutualAgreemnet_RG1,statusTypeData.sharedSSTName_InMutualAgreemnet_RG1, statusTypeData.sharedDateName_InMutualAgreemnet_RG1, 
				statusTypeData.roleNSTName_InMutualAgreemnet_RG2, statusTypeData.roleMSTName_InMutualAgreemnet_RG2, statusTypeData.roleTSTName_InMutualAgreemnet_RG2};
		
		String[] statustypesOfRG1={statusTypeData.sharedNSTName_InMutualAgreemnet_RG1,statusTypeData.sharedMSTName_InMutualAgreemnet_RG1,statusTypeData.sharedTSTName_InMutualAgreemnet_RG1,
				statusTypeData.sharedNedocName_InMutualAgreemnet_RG1,statusTypeData.sharedSSTName_InMutualAgreemnet_RG1, statusTypeData.sharedDateName_InMutualAgreemnet_RG1 };
		
		String[] statustypesOfRG2={statusTypeData.roleNSTName_InMutualAgreemnet_RG2, statusTypeData.roleMSTName_InMutualAgreemnet_RG2, statusTypeData.roleTSTName_InMutualAgreemnet_RG2 };
		navigateTo.viewUnderSetup();
		
		viewUnderSetup.createMultiRegionView(viewDataCreation.multiRegViewName, viewDataCreation.description, regionNames, resourseNames, statustypeNames);
		
		login.logOut()
			 .loginAsUser(usersData.UserInMutualAidRegion2_WithAdditionalRights,UsersData.PASSWORD);
		navigateTo.particularView(viewDataCreation.multiRegViewName);
		viewsList.verifyResourceTypeAndStatusType(resourceTypeData.RT_NAME_MutualAgreementRegion1, statustypesOfRG1)
		.verifyResourceTypeAndStatusType(resourceTypeData.RT_NAME_MutualAgreementRegion2,statustypesOfRG2);
		
		Result = "PASS";
	 }
	 
	@Test (groups = {"HappyDay", "Multi Region","Managing And Viewing Other Regions", "HappyDay172913"})
	 public void HappyDay172913() throws Exception {
		
		TCID ="172913";
		TC_DESCRIPTION ="Verify that user having access to multiple region views can view the event related "
				+ "status updates done for the resources added to 'Multi-Region' view from different regions for "
				+ "which he has access to, only when there is an active event created selecting that resource in the region.";
		
		
		/******
		 * Region should have Mutual-Aid Agreement 
		 * MultiRegionView is created
		 * LoginAsNewUser(U1)[in region RG1]
		 * verifyEventStatusTypesAreNotDisplayed
		 * CreateEventInRG2
		 * LoginAsNewUser(U1)[in region RG1]
		 * verifyEventStatusTypesAreDisplayed
		*/
		
		viewData = new ViewData();
	    viewDataCreation = viewData.new ViewCreateData();
	    statusTypeData=new StatusTypeData();
	    statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
	    resourceTypeData=new ResourceTypeData();
	    resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
	    resourceData=new ResourceData();
	    resourceDataCreation=resourceData.new ResourceCreateData();
	    usersData=new UsersData();
	    userDataCreation=usersData.new UsersCreateData();	
	    eventData =new EventData();
	    eventCreateData=eventData.new EventCreateData();
	    eventSetUpData=new EventSetUpData();
	    
	    
	    login = new Login(this.driver); 
	    statusTypes = new StatusTypes(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	    navigateTo = new Shared(this.driver);
	    viewUnderSetup = new ViewsUnderSetup(this.driver);
	    usersList = new UsersList(this.driver);
	    resourceTypes = new ResourceTypes(this.driver);
	    resources = new Resources(this.driver);
	    eventManagement =new EventManagement(this.driver);
	    viewsList =new View(this.driver);
		String regionNames[] = {RegionData.REGION_WITH_MUTUAL_AGREEMENT1,RegionData.REGION_WITH_MUTUAL_AGREEMENT2};
		
		String resourseNames[] = {resourceData.sharedResourceNAME1_MutualAgreement_RG1,resourceData.sharedResourceNAME1_MutualAgreement_RG2};
		
		String eventSharedStatusTypeNamesInRG1[] = {statusTypeData.eventSharedDateName_InMutualAgreemnet_RG1,statusTypeData.eventSharedMSTName_InMutualAgreemnet_RG1,
				statusTypeData.eventSharedNedocName_InMutualAgreemnet_RG1,statusTypeData.eventSharedNSTName_InMutualAgreemnet_RG1,statusTypeData.eventSharedSSTName_InMutualAgreemnet_RG1,
				statusTypeData.eventSharedTSTName_InMutualAgreemnet_RG1};
		
		String sharedStatusTypeNamesInRG2[] = {statusTypeData.sharedDateName_InMutualAgreemnet_RG2,statusTypeData.sharedMSTName_InMutualAgreemnet_RG2,
				statusTypeData.sharedNedocName_InMutualAgreemnet_RG2,statusTypeData.sharedNSTName_InMutualAgreemnet_RG2,statusTypeData.sharedSSTName_InMutualAgreemnet_RG2,
				statusTypeData.sharedTSTName_InMutualAgreemnet_RG2};
		
		String eventTemplate=eventSetUpData.eventTemplateInMutualAidRegion1;
		
		String[] allStatusTypeNames = ArrayUtils.addAll(eventSharedStatusTypeNamesInRG1,sharedStatusTypeNamesInRG2);
	    
		
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT2);
		navigateTo.viewUnderSetup();
		viewUnderSetup.createMultiRegionView(viewDataCreation.multiRegViewName,viewDataCreation.description , regionNames, resourseNames, allStatusTypeNames);
		login.logOut();
		
		login.loginAsUser(usersData.UserInMutualAidRegion1_WithAdditionalRights, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.VerifyAndDeleteAllPreviouslyCreatedEvent(eventTemplate);
		login.logOut();
		
		login.loginAsUser(usersData.UserInMutualAidRegion2_WithAdditionalRights, UsersData.PASSWORD);
		navigateTo.particularView(viewDataCreation.multiRegViewName);
		viewsList.verifyResourceTypeAndResource(resourceTypeData.RT_NAME_MutualAgreementRegion2, resourceData.sharedResourceNAME1_MutualAgreement_RG2);
		viewsList.verifyResourceTypeAndStatusType(resourceTypeData.RT_NAME_MutualAgreementRegion2, sharedStatusTypeNamesInRG2);
		viewsList.verifyResourceTypeAndResource(resourceTypeData.RT_NAME_MutualAgreementRegion1, resourceData.sharedResourceNAME1_MutualAgreement_RG1);
		viewsList.verifyResourceTypeAndStatusTypeNotDisplayed(resourceTypeData.RT_NAME_MutualAgreementRegion1, eventSharedStatusTypeNamesInRG1);
		login.logOut();
		
		login.loginAsUser(usersData.UserInMutualAidRegion1_WithAdditionalRights, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.createEvent(eventTemplate, eventCreateData.name, eventCreateData.description, resourceData.sharedResourceNAME1_MutualAgreement_RG1);
		login.logOut();
		
		login.loginAsUser(usersData.UserInMutualAidRegion2_WithAdditionalRights, UsersData.PASSWORD);
		navigateTo.particularView(viewDataCreation.multiRegViewName);
		viewsList.verifyResourceTypeAndResource(resourceTypeData.RT_NAME_MutualAgreementRegion1, resourceData.sharedResourceNAME1_MutualAgreement_RG1);
		viewsList.verifyResourceTypeAndStatusType(resourceTypeData.RT_NAME_MutualAgreementRegion1, eventSharedStatusTypeNamesInRG1);
		viewsList.verifyResourceTypeAndResource(resourceTypeData.RT_NAME_MutualAgreementRegion2, resourceData.sharedResourceNAME1_MutualAgreement_RG2);
		viewsList.verifyResourceTypeAndStatusType(resourceTypeData.RT_NAME_MutualAgreementRegion2, sharedStatusTypeNamesInRG2);
		login.logOut();
		
		Result = "PASS";
	 }
	 
	@Test (groups = {"HappyDay", "Multi Region","Managing And Viewing Other Regions", "HappyDay172930"})
	 public void HappyDay172930() throws Exception {
		
		TCID ="172930";
		TC_DESCRIPTION ="Verify that system admin can manage users under '[activeRegions] can view' section on "
				+ "'Other Region List' page";
		
		//loginAsAdmin(R1)
		//verifyMutualAidAgreementBetweenRegion
		//VerifyRegionNameDisplayed(R2)
		//manageUserByAdmin(R1)
		//VerifyAdminCanAssignUsersToView
		
		//Result = "PASS";
	 }
	 
	@Test (groups = {"HappyDay", "Multi Region","Managing And Viewing Other Regions", "HappyDay172929"})
	 public void HappyDay172929() throws Exception {
		
		TCID ="172929";
		TC_DESCRIPTION ="Verify that user with 'Administer Other Region Views' right can manage users under "
				+ "'[activeRegions] can view' section on 'Other Region List' page ";
		
		//loginAsAdmin(R1)
		//Create user (U1) with 'Setup - Other Region Views' rights
		//verifyMutualAidAgreementBetweenRegion
		//loginAsUser(U1)
		//VerifyRegionNameDisplayed(R2)
		//selectUserToView(U1)
		//VerifyUserIsSelected
		
		viewData = new ViewData();
	    viewDataCreation = viewData.new ViewCreateData();
	    statusTypeData=new StatusTypeData();
	    statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
	    resourceTypeData=new ResourceTypeData();
	    resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
	    resourceData=new ResourceData();
	    resourceDataCreation=resourceData.new ResourceCreateData();
	    usersData=new UsersData();
	    userDataCreation=usersData.new UsersCreateData();	
	    eventData =new EventData();
	    eventCreateData=eventData.new EventCreateData();
	    eventSetUpData=new EventSetUpData();
	      	    
	    login = new Login(this.driver); 
	    statusTypes = new StatusTypes(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	    navigateTo = new Shared(this.driver);
	    viewUnderSetup = new ViewsUnderSetup(this.driver);
	    usersList = new UsersList(this.driver);
	    resourceTypes = new ResourceTypes(this.driver);
	    resources = new Resources(this.driver);
	    eventManagement =new EventManagement(this.driver);
	    viewsList =new View(this.driver);
	    otherRegionList =new OtherRegionList(this.driver); 

	    login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);
	    navigateTo.users();
	    usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
	    		 .provideSetupOtherRegionViewsRightAndSave()
	    		 .createUserBySelectingFirstRole(userDataCreation.name1, UsersData.INITIAL_PASSWORD, userDataCreation.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
	    		 .createUserBySelectingFirstRole(userDataCreation.name2, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
	    login.logOut();
	    login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD,UsersData.PASSWORD);
		navigateTo.otherRegion();
		otherRegionList.verifyManageUsersLink(RegionData.REGION_WITH_MUTUAL_AGREEMENT2)
						.clickOnManageUsersLink(RegionData.REGION_WITH_MUTUAL_AGREEMENT2)
						.verifyAssignUsersToViewRegionPage(RegionData.REGION_WITH_MUTUAL_AGREEMENT2)
						.deselectAssigneForAllUsers()
						.assignParticularUserToView(userDataCreation.name1)
						.deselectParticularUserToView(userDataCreation.name2)
						.clickOnSave();
		login.logOut()
				.loginAsNewUser(userDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.regionUnderOtherRegion(RegionData.REGION_WITH_MUTUAL_AGREEMENT2);
		otherRegionList.verifyMutualAidRegionPageDisplayed(RegionData.REGION_WITH_MUTUAL_AGREEMENT2);
		login.logOut()
				.loginAsNewUser(userDataCreation.name2,UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		otherRegionList.verifyMutualAidedRegionNotAvailable(RegionData.REGION_WITH_MUTUAL_AGREEMENT2);
		login.logOut();
		Result = "PASS";
	 }
	 
	@Test (groups = {"HappyDay", "Multi Region","Managing And Viewing Other Regions", "HappyDay172945"})
	 public void HappyDay172945() throws Exception {
		
		TCID ="172945";
		TC_DESCRIPTION ="Verify that user without access to any of the region views,can view only logged in "
				+ "region resources. ";
		
		//verifyMutualAidAgreementBetweenRegion
		//createSharedStatusType(R1)
		//createResourceType(R1)    
		//createSharedResource(R1) 
		//selectRegion(R2)
		//createStatusType(R2)
		//createResourceType(R2)    
		//createResource(R2) 
		//VerifyRegionNameDisplayed(R1)
		//deselectUserToView(U1)
		//VerifyUsersIsDeselected
		//loginAsUser(U1)   
		//verifySharedResourceNotListedCreatingView(R1)
		//createMultiRegionViewSelecting(R2,Resource,StatusType)
		//verifyShareResourceAndSharedStatusTypeNotDisplayedInView(R1)
	
		//Result = "PASS";
	 }
}
