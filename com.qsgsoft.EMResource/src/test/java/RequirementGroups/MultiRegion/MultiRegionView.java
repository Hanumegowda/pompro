package RequirementGroups.MultiRegion;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import EMR.data.EventData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.LoginData;
import EMR.data.OtherRegionData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData;
import EMR.data.RolesData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.OtherRegionList;
import EMR.pages.RegionList;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.RolesList;
import EMR.pages.Shared;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewsUnderSetup;

public class MultiRegionView extends Configuration {

	public MultiRegionView() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginData loginData;
	ResourceTypeData resourceTypeData;
	StatusTypeData statusTypeData;
	ResourceCreateData resourceDataCreation;
	UsersData usersData;
	RolesData rolesData;
	ResourceData resourceData;
	ViewData viewData;
	ViewCreateData viewDataCreation;
	RegionData  regionData;
	EventSetUpData eventSetUpData;
	EventSetUpCreateData eventSetupDataCreation;
	EventData eventData;
	EventCreateData eventCreateData;
	OtherRegionData otherRegionData;


	Login login;
	UsersList usersList;
	Shared navigateTo;
	RegionList regionList;
	RolesList rolesList; 
	View viewsList;
	ViewsUnderSetup viewUnderSetup;
	OtherRegionList otherRegionList;
	EventSetUp eventSetUp;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	EventManagement eventManagement;
	
	@Test(groups = {"HappyDay","Multi Region", "HappyDay176119"})
	public void HappyDay176119() throws Exception {

		TCID ="176119";
		TC_DESCRIPTION ="Verify that Event-Only status types included in a future event, doesn’t display on multi "
				+ "region view until the future event get started.";

		usersData = new UsersData();
		statusTypeData = new StatusTypeData();
		resourceTypeData = new ResourceTypeData();
		resourceData = new ResourceData();
		viewData = new ViewData();
	    viewDataCreation = viewData.new ViewCreateData();
	    eventSetUpData = new EventSetUpData();
	    eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
	    
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		viewsList = new View(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		String[] statustypesOfRG1 = {statusTypeData.eventSharedNSTName_InMutualAgreemnet_RG1,statusTypeData.eventSharedMSTName_InMutualAgreemnet_RG1,
				statusTypeData.eventSharedTSTName_InMutualAgreemnet_RG1,
				statusTypeData.eventSharedDateName_InMutualAgreemnet_RG1,
				statusTypeData.eventSharedSSTName_InMutualAgreemnet_RG1, statusTypeData.eventSharedNedocName_InMutualAgreemnet_RG1},
		statusTypesOfRG2 = {statusTypeData.roleNSTName_InMutualAgreemnet_RG2},
		statusTypeNames = ArrayUtils.addAll(statustypesOfRG1, statusTypesOfRG2),
		regionNames =  {RegionData.REGION_WITH_MUTUAL_AGREEMENT1,RegionData.REGION_WITH_MUTUAL_AGREEMENT2},
		resourceNames = {resourceData.sharedResourceNAME1_MutualAgreement_RG1,resourceData.resourceNAME_MutualAgreement_RG2};
		String username_RG1	= usersData.UserInMutualAidRegion1_WithAdditionalRights,
			   username_RG2 = usersData.UserInMutualAidRegion2_WithAdditionalRights,
			   eventTemplate = eventSetUpData.eventTemplateInMutualAidRegion1,
			   resourceType_RG1 = resourceTypeData.RT_NAME_MutualAgreementRegion1,
			   eventStartDate = "";
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGION_WITH_MUTUAL_AGREEMENT2);

		navigateTo.viewUnderSetup();
		
		viewUnderSetup.createMultiRegionView(viewDataCreation.multiRegViewName, viewDataCreation.description, regionNames, resourceNames, statusTypeNames);
		
		login.logOut()
			 .loginAsUser(username_RG1, UsersData.PASSWORD);
		System.out.println(username_RG1);
		navigateTo.eventManagment();
		eventManagement.VerifyAndDeleteAllPreviouslyCreatedEvent(eventTemplate);
		
		eventStartDate = eventManagement.createEventWithFutureStartDate(eventTemplate, eventSetupDataCreation.name, eventSetupDataCreation.definition, EventSetUpData.ZERO, EventSetUpData.ZERO, EventSetUpData.SIX, resourceNames[0]);
		login.logOut()
			 .loginAsUser(username_RG2, UsersData.PASSWORD);
		System.out.println(username_RG2);
		navigateTo.particularView(viewDataCreation.multiRegViewName);
		viewsList.verifyNoResourceTypeResourceAndStatusTypeIsPresent(resourceType_RG1, resourceNames[0], statustypesOfRG1);
		
		login.logOut()
		 .loginAsUser(username_RG1, UsersData.PASSWORD);
		//As per TC requirement, need to wait for event to start.
		navigateTo.waitForSpecificMinutes(EventSetUpData.FIVE)
				  .eventManagment();
		eventManagement.verifyEventStatus(eventSetupDataCreation.name, EventData.ONGOING_STATUS)
					   .verifyEventStartDate(eventSetupDataCreation.name, eventStartDate);
		login.logOut()
		 .loginAsUser(username_RG2, UsersData.PASSWORD);
		navigateTo.particularView(viewDataCreation.multiRegViewName);
		viewsList.verifyResourceTypeResourceAndStatusType(resourceType_RG1, resourceNames[0], statustypesOfRG1);
		Result = "PASS";
	}
}
