package RequirementGroups.MultiRegion;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import EMR.data.EventData;
import EMR.data.EventSetUpData;
import EMR.data.LoginData;
import EMR.data.OtherRegionData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.RolesData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.EventData.EventCreateData;
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

public class CreatingAndManagingViews extends Configuration {
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
	OtherRegionData otherRegionData;


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
	EventManagement eventManagement;
	OtherRegionList OtherRegionList;


	public CreatingAndManagingViews() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(groups = {"HappyDay","Multi Region", "HappyDay173147"})
	public void HappyDay173147() throws Exception {

		TCID ="173147";
		TC_DESCRIPTION ="Verify that when a user from Region B views the Other Region view of A, the user should"
				+ " only see data from Region A, when there exists bidirectional agreement between region A and B.";

		usersData =new UsersData();
		regionData = new RegionData();
		statusTypeData = new StatusTypeData();
		resourceTypeData = new ResourceTypeData();
		resourceData = new ResourceData();
				
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		viewsList = new View(this.driver);
		
		
		String[] statustypesOfRG1={statusTypeData.sharedNSTName_InMutualAgreemnet_RG1,statusTypeData.sharedMSTName_InMutualAgreemnet_RG1,
				statusTypeData.sharedTSTName_InMutualAgreemnet_RG1,
				statusTypeData.sharedNedocName_InMutualAgreemnet_RG1,
				statusTypeData.sharedSSTName_InMutualAgreemnet_RG1, statusTypeData.sharedDateName_InMutualAgreemnet_RG1};
		
		login.loginAsUser(usersData.userInMutualAgreementRegion2, UsersData.PASSWORD);

		navigateTo.regionUnderOtherRegion(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);
		viewsList.verifyResourceTypesAndResource(resourceTypeData.RT_NAME_MutualAgreementRegion1, resourceData.sharedResourceNAME1_MutualAgreement_RG1);
		viewsList.verifyResourceTypeAndStatusType(resourceTypeData.RT_NAME_MutualAgreementRegion1, statustypesOfRG1);
		
		
		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Multi Region", "HappyDay173149"})
	public void HappyDay173149() throws Exception {

		TCID ="173149";
		TC_DESCRIPTION ="Verify that when a user from Region C views the Other Region view of "
				+ "A(regions have bidirectional agreement), the user should not be able to see event related "
				+ "status types from Region A,unless there is an active event selecting the resource.";

		
		usersData = new UsersData();
		regionData = new RegionData();
		statusTypeData = new StatusTypeData();
		resourceTypeData = new ResourceTypeData();
		resourceData = new ResourceData();
		eventSetUpData = new EventSetUpData();
		eventData = new EventData();
		eventCreateData = eventData.new EventCreateData();
				
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		viewsList = new View(this.driver);
		eventManagement = new EventManagement(this.driver);
				
		String eventSharedStatusTypeNamesInRG1[] = {statusTypeData.eventSharedDateName_InMutualAgreemnet_RG1,statusTypeData.eventSharedMSTName_InMutualAgreemnet_RG1,
				statusTypeData.eventSharedNedocName_InMutualAgreemnet_RG1,statusTypeData.eventSharedNSTName_InMutualAgreemnet_RG1,statusTypeData.eventSharedSSTName_InMutualAgreemnet_RG1,
				statusTypeData.eventSharedTSTName_InMutualAgreemnet_RG1};
		
		String[] statustypesOfRG1={statusTypeData.sharedNSTName_InMutualAgreemnet_RG1,statusTypeData.sharedMSTName_InMutualAgreemnet_RG1,
				statusTypeData.sharedTSTName_InMutualAgreemnet_RG1,
				statusTypeData.sharedNedocName_InMutualAgreemnet_RG1,
				statusTypeData.sharedSSTName_InMutualAgreemnet_RG1, statusTypeData.sharedDateName_InMutualAgreemnet_RG1};
		
		String eventTemplate=eventSetUpData.eventTemplateInMutualAidRegion1;
		
	    
		login.loginAsUser(usersData.UserInMutualAidRegion1_WithAdditionalRights, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.VerifyAndDeleteAllPreviouslyCreatedEvent(eventTemplate);
		login.logOut();
		
		login.loginAsUser(usersData.UserInMutualAidRegion2_WithAdditionalRights, UsersData.PASSWORD);
		navigateTo.regionUnderOtherRegion(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);
		viewsList.verifyResourceTypeAndResource(resourceTypeData.RT_NAME_MutualAgreementRegion1, resourceData.sharedResourceNAME1_MutualAgreement_RG1);
		viewsList.verifyResourceTypeAndStatusTypeNotDisplayed(resourceTypeData.RT_NAME_MutualAgreementRegion1, eventSharedStatusTypeNamesInRG1);
		login.logOut();
		
		login.loginAsUser(usersData.UserInMutualAidRegion1_WithAdditionalRights, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.createEvent(eventTemplate, eventCreateData.name, eventCreateData.description, resourceData.sharedResourceNAME1_MutualAgreement_RG1);
		login.logOut();
		
		login.loginAsUser(usersData.UserInMutualAidRegion2_WithAdditionalRights, UsersData.PASSWORD);
		navigateTo.regionUnderOtherRegion(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);
		viewsList.verifyResourceTypeAndResource(resourceTypeData.RT_NAME_MutualAgreementRegion1, resourceData.sharedResourceNAME1_MutualAgreement_RG1);
		viewsList.verifyResourceTypeAndStatusType(resourceTypeData.RT_NAME_MutualAgreementRegion1, statustypesOfRG1);
		viewsList.verifyResourceTypeAndStatusType(resourceTypeData.RT_NAME_MutualAgreementRegion1, eventSharedStatusTypeNamesInRG1);
		login.logOut();
		
		
		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Multi Region", "HappyDay173152"})
	public void HappyDay173152() throws Exception {

		TCID ="173152";
		TC_DESCRIPTION ="Verify that when multiple users from Region A (U1-having access to region B "
				+ "and U2 without access to region B)views the default multi region view set for the region, "
				+ "view should be same for both the users.";
		
		usersData = new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		regionData = new RegionData();
		statusTypeData = new StatusTypeData();
		resourceTypeData = new ResourceTypeData();
		resourceData = new ResourceData();
		statusTypeData = new StatusTypeData();
		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		viewsList = new View(this.driver);
		usersList = new UsersList(this.driver);
		otherRegionList = new OtherRegionList(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		
		String regionNames[] = {RegionData.REGION_WITH_MUTUAL_AGREEMENT1,RegionData.REGION_WITH_MUTUAL_AGREEMENT2};
		String resourseNames[] = {resourceData.resourceNAME_MutualAgreement_RG1,resourceData.sharedResourceNAME1_MutualAgreement_RG2};
		String[] statustypeNames = {statusTypeData.roleDateName_InMutualAgreemnet_RG1, statusTypeData.roleMSTName_InMutualAgreemnet_RG1,
				statusTypeData.roleNedocName_InMutualAgreemnet_RG1,statusTypeData.roleNSTName_InMutualAgreemnet_RG1,statusTypeData.roleTSTName_InMutualAgreemnet_RG1,
				statusTypeData.roleSSTName_InMutualAgreemnet_RG1,statusTypeData.sharedDateName_InMutualAgreemnet_RG2, 
				statusTypeData.sharedMSTName_InMutualAgreemnet_RG2,statusTypeData.sharedNedocName_InMutualAgreemnet_RG2, 
				statusTypeData.sharedNSTName_InMutualAgreemnet_RG2,statusTypeData.sharedSSTName_InMutualAgreemnet_RG2, statusTypeData.sharedTSTName_InMutualAgreemnet_RG2};
		
		String[] statustypesOfRG2 = {statusTypeData.sharedDateName_InMutualAgreemnet_RG2, statusTypeData.sharedMSTName_InMutualAgreemnet_RG2,
				statusTypeData.sharedNedocName_InMutualAgreemnet_RG2, 
				statusTypeData.sharedNSTName_InMutualAgreemnet_RG2,statusTypeData.sharedSSTValue_InMutualAgreemnet_RG2, statusTypeData.sharedTSTName_InMutualAgreemnet_RG2};
		
		login.loginAsAdmin(LoginData.QSGTESTER_ADMIN, LoginData.ADMINPASSWORD, RegionData.REGION_WITH_MUTUAL_AGREEMENT1);
		navigateTo.viewUnderSetup();
		viewUnderSetup.createMultiRegionView(viewDataCreation.multiRegViewName, viewDataCreation.description, regionNames, resourseNames, statustypeNames);
		navigateTo.users();
		usersList.createUserBySelectingFirstRole(userDataCreation.name, UsersData.PASSWORD, userDataCreation.fullName, 
											UsersData.EMAILID1 , UsersData.EMAILID2);
		navigateTo.otherRegion();
		otherRegionList.clickOnManageUsersLink(RegionData.REGION_WITH_MUTUAL_AGREEMENT2)
					   .deselectAssigneForAllUsers()
					   .deselectParticularUserToView(userDataCreation.name)
					   .clickOnSave();
		login.logOut()
			 .loginAsNewUser(userDataCreation.name, UsersData.PASSWORD, UsersData.RESET_PASSWORD_1);
		navigateTo.particularView(viewDataCreation.multiRegViewName);
		
		viewsList.verifyResourceTypeResourceAndStatusType(resourceTypeData.RT_NAME_MutualAgreementRegion2,
				resourceData.sharedResourceNAME1_MutualAgreement_RG2, statustypesOfRG2);
		login.logOut()
			 .loginAsUser(usersData.UserInMutualAidRegion1_WithAdditionalRights, UsersData.PASSWORD);
		navigateTo.particularView(viewDataCreation.multiRegViewName);
		viewsList.verifyResourceTypeResourceAndStatusType(resourceTypeData.RT_NAME_MutualAgreementRegion2, 
				resourceData.sharedResourceNAME1_MutualAgreement_RG2, statustypesOfRG2);
		
		Result = "PASS";
	}
}
