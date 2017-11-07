package DatabaseRefresh_DataCreation.Smoke;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;
import EMR.data.EventSetUpData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.EventSetUpData.EventSetUpTags;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ViewData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceData.ResourceTags;
import EMR.data.ResourceTypeData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.RolesData.RolesTags;
import EMR.data.StatusTypeData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.UsersData.UsersTags;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.Shared;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.SelectRegion;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.RolesList;
import EMR.pages.ViewsUnderSetup;
import EMR.data.RolesData;
import EMR.data.RolesData.RolesCreateData;

public class PreconditionForEvents extends Configuration {

	ReadAndWriteFromXMLFile xml = new ReadAndWriteFromXMLFile();
	
	LoginData loginData;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceCreateData resourceDataCreation;
	EventSetUpCreateData eventSetUpDataCreation;
	UsersCreateData userDataCreation;
	UsersData usersData;
	RolesData rolesData;
	RolesCreateData rolesDataCreation;
	ResourceData resourceData;
	EventSetUpData eventSetUpData;
	ViewData viewData;
	ViewCreateData viewDataCreation;
	
	Login login;
	SelectRegion selectRegion;
	Shared navigateTo;	
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	EventSetUp eventSetUp;
	UsersList usersList;
	RolesList rolesList;
	ViewsUnderSetup viewUnderSetup;

	public PreconditionForEvents() throws Exception {
		super();
	}
	
	@Test(description = "Precondition for tc 185941")
	public void Precondition_186280() throws Exception {

		TCID = "186280";
	    TC_DESCRIPTION = "Precondition for tc 185941";
	    
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		statusTypes = new StatusTypes(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		usersList = new UsersList(this.driver);
		rolesList = new RolesList(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		
		loginData = new LoginData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceData = new ResourceData();
		resourceDataCreation = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		eventSetUpData = new EventSetUpData();
		eventSetUpDataCreation = eventSetUpData.new EventSetUpCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		rolesData = new RolesData();
		rolesDataCreation = rolesData.new RolesCreateData();
	    viewData = new ViewData();
	    viewDataCreation = viewData.new ViewCreateData();
		
		String statusTypeValue[] = new String[1];
		String roleValue = "";

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		
		navigateTo.viewUnderSetup();
	    viewUnderSetup.createNewSection(viewDataCreation.section);
	    
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypeValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName);
		
		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, statusTypeValue);
		String resourceTypeValue = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);
		
		navigateTo.resources();
		resources.createResource(resourceDataCreation.name, resourceDataCreation.abbrevation, resourceTypeDataCreation.name, 
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME);
		
		navigateTo.roles();
		rolesList.createRole(rolesDataCreation.name);
		roleValue = rolesList.getRoleValue(rolesDataCreation.name);
		
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsAndEMailPager(userDataCreation.name, UsersData.INITIAL_PASSWORD,
				userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, roleValue)
				.provideMaintainEventsRightAndSave();
		
		navigateTo.eventSetUp();
		eventSetUp.createEventTemplate(eventSetUpDataCreation.name, eventSetUpDataCreation.definition, resourceTypeValue, statusTypeValue[0])
				  .selectNotificationsForUserAndSave(userDataCreation.name);

		login.logOut();

		login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
			 .logOut();

		userDataCreation.writeUsersDataToXml(userDataCreation.name, UsersTags.EVENTS_USERNAME);
		userDataCreation.writeUsersDataToXml(userDataCreation.fullName, UsersTags.EVENTS_USERFULLNAME);
		eventSetUpDataCreation.writeEventDataToXml(eventSetUpDataCreation.name, EventSetUpTags.SMOKE_EVENT_TEMPLATE);
		rolesDataCreation.writeRolesDataToXml(rolesDataCreation.name, RolesTags.ROLE_NAME_1);
		rolesDataCreation.writeRolesDataToXml(roleValue, RolesTags.ROLE_VALUE_1);
		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.name, ResourceTags.EVENTS_RESOURCE_NAME);
		
		Result = "PASS";
	}
}
