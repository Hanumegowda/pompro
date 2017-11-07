package RequirementGroups.CreatingAndManagingEvents;

import java.util.ArrayList;
import java.util.Arrays;
import org.testng.annotations.Test;
import EMR.data.EventData;
import EMR.data.EventSetUpData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.ViewsUnderSetup;
import qaFramework.Configurations.Configuration;

public class CreateEventTemplate extends Configuration{
	
	ViewData viewData;
	ViewCreateData viewDataCreation;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	EventSetUpData eventSetUpData;
	EventSetUpCreateData eventSetupDataCreation;
	ResourceData resourceData;
	ResourceCreateData resourceDataCreation;
	UsersData usersData;
	UsersCreateData userDataCreation;
	EventData eventData;
	EventCreateData eventDataCreation;
	
	Login login;
	SelectRegion selectRegion;
	Shared navigateTo;
	ViewsUnderSetup viewUnderSetup;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	EventSetUp eventSetUp;
	UsersList usersList;
	EventManagement eventManagement;
	
	static String RESOURCE_TYPE_NAME1, RESOURCE_TYPE_VALUE1, RESOURCE_NAME1, RESOURCE_VALUE1, RESOURCE_TYPE_NAME2, RESOURCE_TYPE_VALUE2, RESOURCE_NAME2, RESOURCE_VALUE2,EVENT_TEMPLATE_WITH_FIFTY_STATUS_TYPES, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, EVENT_TEMPLATE_WITH_ICON_COLOR, SECTION_NAME, NUMBER_STATUS_TYPES_VALUE, MULTI_STATUS_TYPES_VALUE, SATURATION_SCORE_STATUS_TYPES_VALUE, TEXT_STATUS_TYPES_VALUE, EVENT_WITH_ADDRESS;
	
	static ArrayList<String> allStatusTypesValues, allstatusTypeNames, roleStatusTypesValues, allStatusTypesValue, roleStatusTypesNames, userNames;

	public CreateEventTemplate() throws Exception {
		super();
	}

	@Test (priority= 1, groups = {"HappyDay", "Creating And Managing Events", "HappyDay162663", "EMResource v3.24.1"})
	public void HappyDay162663() throws Exception {

		TCID = "162663";
		TC_DESCRIPTION = "Verify that event template can be created selecting 50 status types";
		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		eventSetUpData = new EventSetUpData();
	    eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		resourceData = new ResourceData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		usersData=new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		statusTypes = new StatusTypes(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
	    resources = new Resources(this.driver);
	    eventSetUp = new EventSetUp(this.driver);
	    usersList = new UsersList(this.driver);
		
		String statusTypeValue[] = new String[4],
			   statusesValues[] = new String[3],
		       resourceTypeValue[] = new String[1],
		       resourceValues[] = new String[1];
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.views();
		viewUnderSetup.createNewSection(viewDataCreation.section);
		SECTION_NAME = viewDataCreation.section;
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypeValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName);
		NUMBER_STATUS_TYPES_VALUE = statusTypeValue[0];
		
		statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName2, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName3, StatusTypeData.STATUS_PURPLE_COLOR);
		
		statusesValues[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName1);
		statusesValues[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName2);
		statusesValues[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName3);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sstName, statusTypeDataCreation.description, viewDataCreation.section)
	    		   .createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.tstName, statusTypeDataCreation.description, viewDataCreation.section);
	    statusTypeValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName);
	    statusTypeValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sstName);
	    statusTypeValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName);
	    MULTI_STATUS_TYPES_VALUE = statusTypeValue[1];
	    SATURATION_SCORE_STATUS_TYPES_VALUE = statusTypeValue[2];
	    TEXT_STATUS_TYPES_VALUE = statusTypeValue[3];
	    System.out.println(statusTypeDataCreation.tstName);
	    
	    allStatusTypesValues = new ArrayList<String>();
		allStatusTypesValues.addAll(Arrays.asList(statusTypeData.Role_NST_Value_In_Region,statusTypeData.Role_MST_Value_In_Region,statusTypeData.Role_SST_Value_In_Region,statusTypeData.Role_TST_Value_In_Region,statusTypeData.Role_DST_Value_In_Region,statusTypeData.Role_NEDOCST_Value_In_Region,
				statusTypeData.Private_NST_Value_In_Region,statusTypeData.Private_MST_Value_In_Region,statusTypeData.Private_SST_Value_In_Region,statusTypeData.Private_TST_Value_In_Region,statusTypeData.Private_DST_Value_In_Region,statusTypeData.Private_NEDOCST_Value_In_Region,
				statusTypeData.Shared_NST_Value_In_Region,statusTypeData.Shared_MST_Value_In_Region,statusTypeData.Shared_SST_Value_In_Region,statusTypeData.Shared_TST_Value_In_Region,statusTypeData.Shared_DST_Value_In_Region,statusTypeData.Shared_NEDOCST_Value_In_Region,
				statusTypeData.Event_Role_NST_Value_In_Region, statusTypeData.Event_Role_MST_Value_IN_Region, statusTypeData.Event_Role_SST_Value_In_Region, statusTypeData.Event_Role_TST_Value_In_Region, statusTypeData.Event_Role_DST_Value_IN_Region,statusTypeData.Event_Role_NEDOCST_Value_In_Region,
				statusTypeData.Event_Private_NST_Value_In_Region, statusTypeData.Event_Private_MST_Value_IN_Region, statusTypeData.Event_Private_SST_Value_In_Region, statusTypeData.Event_Private_TST_Value_In_Region, statusTypeData.Event_Private_DST_Value_IN_Region, statusTypeData.Event_Private_NEDOCST_Value_In_Region,
				statusTypeData.Event_Shared_NST_Value_In_Region, statusTypeData.Event_Shared_MST_Value_In_Region, statusTypeData.Event_Shared_SST_Value_In_Region, statusTypeData.Event_Shared_TST_Value_In_Region, statusTypeData.Event_Shared_DST_Value_In_Region ,statusTypeData.Event_Shared_NEDOCST_Value_In_Region,
				statusTypeData.sharedNumberStatusTypeValue1_Region,statusTypeData.sharedNumberStatusTypeValue2_Region,statusTypeData.sharedMultiStatusTypeValue1_Region,statusTypeData.sharedMultiStatusTypeValue2_Region,
				statusTypeData.roleBasedNumberStatusTypeValue,statusTypeData.roleBasedMultiStatusTypeValue,statusTypeData.roleBasedSaturationStatusTypeValue,statusTypeData.roleBasedTextStatusTypeValue,statusTypeData.roleBasedDateStatusTypeValue,statusTypeData.roleBasedNedocsStatusTypeValue,
				statusTypeValue[0],statusTypeValue[1],statusTypeValue[2],statusTypeValue[3]));
		
		allstatusTypeNames = new ArrayList<String>();
		allstatusTypeNames.addAll(Arrays.asList(statusTypeData.Role_NST_In_Region,statusTypeData.Role_MST_In_Region,statusTypeData.Role_SST_In_Region,statusTypeData.Role_TST_In_Region,statusTypeData.Role_DST_In_Region,statusTypeData.Role_NEDOCST_In_Region,
				statusTypeData.Private_NST_In_Region,statusTypeData.Private_MST_In_Region,statusTypeData.Private_SST_In_Region,statusTypeData.Private_TST_In_Region,statusTypeData.Private_DST_In_Region,statusTypeData.Private_NEDOCST_In_Region,
				statusTypeData.Shared_NST_In_Region,statusTypeData.Shared_MST_In_Region,statusTypeData.Shared_SST_In_Region,statusTypeData.Shared_TST_In_Region,statusTypeData.Shared_DST_In_Region,statusTypeData.Shared_NEDOCST_In_Region,
				statusTypeData.Event_Role_NST_In_Region,statusTypeData.Event_Role_MST_In_Region,statusTypeData.Event_Role_SST_In_Region,statusTypeData.Event_Role_TST_In_Region,statusTypeData.Event_Role_DST_In_Region,statusTypeData.Event_Role_NEDOCST_In_Region,
				statusTypeData.Event_Private_NST_In_Region,statusTypeData.Event_Private_MST_In_Region,statusTypeData.Event_Private_SST_In_Region,statusTypeData.Event_Private_TST_In_Region,statusTypeData.Event_Private_DST_In_Region,statusTypeData.Event_Private_NEDOCST_In_Region,
				statusTypeData.Event_Shared_NST_In_Region,statusTypeData.Event_Shared_MST_In_Region,statusTypeData.Event_Shared_SST_In_Region,statusTypeData.Event_Shared_TST_In_Region,statusTypeData.Event_Shared_DST_In_Region,statusTypeData.Event_Shared_NEDOCST_In_Region,
				statusTypeData.roleBasedNumberStatusType,statusTypeData.roleBasedMultiStatusType,statusTypeData.roleBasedSaturationStatusType,statusTypeData.roleBasedTextStatusType,statusTypeData.roleBasedDateStatusType,statusTypeData.roleBasedNedocsStatusType,
				statusTypeData.sharedNumberStatusTypeName1_Region,statusTypeData.sharedNumberStatusTypeName2_Region,statusTypeData.sharedMultiStatusTypeName1_Region,statusTypeData.sharedMultiStatusTypeName2_Region,
				statusTypeDataCreation.nstName, statusTypeDataCreation.mstName, statusTypeDataCreation.sstName, statusTypeDataCreation.tstName));

	    navigateTo.resourceType();
	    resourceTypes.createResourceType(resourceTypeDataCreation.name1, allStatusTypesValues);
	    resourceTypeValue[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name1);
	    RESOURCE_TYPE_NAME1 = resourceTypeDataCreation.name1;
	    RESOURCE_TYPE_VALUE1 = resourceTypeValue[0];
	    System.out.println("RESOURCE_TYPE_NAME1" + RESOURCE_TYPE_NAME1);
	    System.out.println("RESOURCE_TYPE_VALUE1" + RESOURCE_TYPE_VALUE1);
	    
	    navigateTo.resources();
		resources.createResourceWithAddress(resourceDataCreation.name1, resourceDataCreation.abbrevation, RESOURCE_TYPE_NAME1, 
		    		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
		    		ResourceData.LASTNAME, ResourceData.STREETADDRESS,
		    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resourceValues[0] = resources.getResourceValue(resourceDataCreation.name1);
		RESOURCE_NAME1 = resourceDataCreation.name1;
		RESOURCE_VALUE1 = resourceValues[0];
		System.out.println("RESOURCE_NAME1" + RESOURCE_NAME1);
	    System.out.println("RESOURCE_VALUE1" + RESOURCE_VALUE1);
		
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
		         .provideConfigureRegionalUserAccessMainTainEventAndMaintainEventTemplateRights();
		
		USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT = userDataCreation.name;
	    
	    navigateTo.eventSetUp();
	    eventSetUp.createNewEventTemplate(eventSetupDataCreation.name, eventSetupDataCreation.definition, EventSetUpData.HELICOPTER_ICON, EventSetUpData.ORANGE_COLOUR, RESOURCE_TYPE_VALUE1, allStatusTypesValues, userDataCreation.name);
	    login.logOut();
	    Result="PASS";
	}
	
	@Test (priority=2, groups = {"HappyDay", "Creating And Managing Events", "HappyDay162664", "Edit Event Template", "EMResource v3.24.1"})
	public void HappyDay162664() throws Exception {

		TCID = "162664";
		TC_DESCRIPTION = "Verify that event template can be edited and saved by selecting 50 status types";
		
		eventSetUpData = new EventSetUpData();
	    eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		
		String statusTypeValue[] = new String[1];
		
		allStatusTypesValues = new ArrayList<String>();
		allStatusTypesValues.addAll(Arrays.asList(statusTypeData.Role_NST_Value_In_Region,statusTypeData.Role_MST_Value_In_Region,statusTypeData.Role_SST_Value_In_Region,statusTypeData.Role_TST_Value_In_Region,statusTypeData.Role_DST_Value_In_Region,statusTypeData.Role_NEDOCST_Value_In_Region,
				statusTypeData.Private_NST_Value_In_Region,statusTypeData.Private_MST_Value_In_Region,statusTypeData.Private_SST_Value_In_Region,statusTypeData.Private_TST_Value_In_Region,statusTypeData.Private_DST_Value_In_Region,statusTypeData.Private_NEDOCST_Value_In_Region,
				statusTypeData.Shared_NST_Value_In_Region,statusTypeData.Shared_MST_Value_In_Region,statusTypeData.Shared_SST_Value_In_Region,statusTypeData.Shared_TST_Value_In_Region,statusTypeData.Shared_DST_Value_In_Region,statusTypeData.Shared_NEDOCST_Value_In_Region,
				statusTypeData.Event_Role_NST_Value_In_Region, statusTypeData.Event_Role_MST_Value_IN_Region, statusTypeData.Event_Role_SST_Value_In_Region, statusTypeData.Event_Role_TST_Value_In_Region, statusTypeData.Event_Role_DST_Value_IN_Region,statusTypeData.Event_Role_NEDOCST_Value_In_Region,
				statusTypeData.Event_Private_NST_Value_In_Region, statusTypeData.Event_Private_MST_Value_IN_Region, statusTypeData.Event_Private_SST_Value_In_Region, statusTypeData.Event_Private_TST_Value_In_Region, statusTypeData.Event_Private_DST_Value_IN_Region, statusTypeData.Event_Private_NEDOCST_Value_In_Region,
				statusTypeData.Event_Shared_NST_Value_In_Region, statusTypeData.Event_Shared_MST_Value_In_Region, statusTypeData.Event_Shared_SST_Value_In_Region, statusTypeData.Event_Shared_TST_Value_In_Region, statusTypeData.Event_Shared_DST_Value_In_Region ,statusTypeData.Event_Shared_NEDOCST_Value_In_Region,
				statusTypeData.sharedNumberStatusTypeValue1_Region,statusTypeData.sharedNumberStatusTypeValue2_Region,statusTypeData.sharedMultiStatusTypeValue1_Region,statusTypeData.sharedMultiStatusTypeValue2_Region,
				statusTypeData.roleBasedNumberStatusTypeValue,statusTypeData.roleBasedMultiStatusTypeValue,statusTypeData.roleBasedSaturationStatusTypeValue,statusTypeData.roleBasedTextStatusTypeValue,statusTypeData.roleBasedDateStatusTypeValue,statusTypeData.roleBasedNedocsStatusTypeValue,
				NUMBER_STATUS_TYPES_VALUE, MULTI_STATUS_TYPES_VALUE,SATURATION_SCORE_STATUS_TYPES_VALUE));
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName1, statusTypeDataCreation.description1, SECTION_NAME);
		statusTypeValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName1);
		
		navigateTo.resourceType();
	    resourceTypes.addStatusTypesToResourceType(RESOURCE_TYPE_NAME1, statusTypeValue[0]);
		
		navigateTo.eventSetUp();
	    eventSetUp.createEventTemplate(eventSetupDataCreation.name1, eventSetupDataCreation.definition1, RESOURCE_TYPE_VALUE1, statusTypeValue[0])
	              .clickOnSave();
		eventSetUp.editTemplateSelectStatusTypes(eventSetupDataCreation.name1, eventSetupDataCreation.editname, eventSetupDataCreation.editdescription, EventSetUpData.HELICOPTER_ICON, EventSetUpData.ORANGE_COLOUR, allStatusTypesValues);
	    login.logOut();
	    Result="PASS";
	}
	
	@Test (priority=3,groups = {"HappyDay", "Creating And Managing Events", "HappyDay68108", "EMResource Base"})
	public void HappyDay68108() throws Exception {

		TCID = "68108";
		TC_DESCRIPTION = "Create an event template selecting resource types, status types and verify that the associated resource is available while creating an event under it.";
		
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		resourceData = new ResourceData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		eventSetUpData = new EventSetUpData();
	    eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		eventManagement = new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		
		String resourceTypeValue[] = new String[1],
			   resourceValues[] = new String[1];
		
		roleStatusTypesNames = new ArrayList<String>();
		roleStatusTypesNames.addAll(Arrays.asList(statusTypeData.Role_NST_In_Region,statusTypeData.Role_MST_In_Region,statusTypeData.Role_SST_In_Region,statusTypeData.Role_TST_In_Region,statusTypeData.Role_DST_In_Region,statusTypeData.Role_NEDOCST_In_Region));
		
		roleStatusTypesValues = new ArrayList<String>();
		roleStatusTypesValues.addAll(Arrays.asList(statusTypeData.Role_NST_Value_In_Region,statusTypeData.Role_MST_Value_In_Region,statusTypeData.Role_SST_Value_In_Region,statusTypeData.Role_TST_Value_In_Region,statusTypeData.Role_DST_Value_In_Region,statusTypeData.Role_NEDOCST_Value_In_Region));
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name2, roleStatusTypesValues);
		    resourceTypeValue[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name2);
			RESOURCE_TYPE_NAME2 = resourceTypeDataCreation.name2;
			RESOURCE_TYPE_VALUE2 = resourceTypeValue[0];
		System.out.println("RESOURCE_TYPE_NAME2" + RESOURCE_TYPE_NAME2);   
		System.out.println("RESOURCE_TYPE_VALUE2" + RESOURCE_TYPE_VALUE2);   
		navigateTo.resources();
		resources.createResourceWithAddress(resourceDataCreation.name2, resourceDataCreation.abbrevation, RESOURCE_TYPE_NAME2, 
		    		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
		    		ResourceData.LASTNAME, ResourceData.STREETADDRESS,
		    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resourceValues[0] = resources.getResourceValue(resourceDataCreation.name2);
		RESOURCE_NAME2 = resourceDataCreation.name2;
		RESOURCE_VALUE2 = resourceValues[0];
		System.out.println("RESOURCE_NAME2" + RESOURCE_NAME2);   
		System.out.println("RESOURCE_VALUE2" + RESOURCE_VALUE2);  
		login.logOut();
		
		login.loginAsNewUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventSetUp();
	    eventSetUp.createNewEventTemplate(eventSetupDataCreation.name2, eventSetupDataCreation.definition2, EventSetUpData.VOLCANO_ICON, EventSetUpData.BLUE_COLOUR, RESOURCE_TYPE_VALUE2, roleStatusTypesValues, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT);
		EVENT_TEMPLATE_WITH_ICON_COLOR = eventSetupDataCreation.name2;
		System.out.println("EVENT_TEMPLATE_WITH_ICON_COLOR" + EVENT_TEMPLATE_WITH_ICON_COLOR);
		navigateTo.eventManagment();
		eventManagement.verifyCreateNewEventOnEventManagementPage()
                       .navigateToCreateNewEventScreen()
                       .verifyEventTemplateOnSelectEventTemplateScreen(eventSetupDataCreation.name2)
                       .selectEventTemplate(eventSetupDataCreation.name2)
                       .verifyCreateEventScreen()
                       .verifyResourceUnderResourcesToParticipateInThisEventSection(RESOURCE_NAME2);
		String applicationTime = eventManagement.createEvent(eventDataCreation.name, eventDataCreation.description, RESOURCE_NAME2);
		String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.TWENTYFOUR_HOURS);                           
	    eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name, eventDataCreation.description)
	    			   .verifyEventDetails(eventDataCreation.name, EventData.ONGOING_STATUS, eventSetupDataCreation.name2, eventDataCreation.description, applicationTime, applicationTimePlusHour);
	    navigateTo.eventList();
	    eventManagement.verifyEventListScreen()
	                   .verifyEventDetailsOnEventList(eventDataCreation.name, EventData.ONGOING_STATUS, eventSetupDataCreation.name2, eventDataCreation.description, applicationTime, applicationTimePlusHour)
	                   .verifyEventActionOnEventList(eventDataCreation.name)
	                   .verifyEventIconAndColour(EventSetUpData.BLUE_COLOUR_IN_EVENT_BANNER, EventData.VOLCANO_ICON, eventDataCreation.name)
	                   .verifyEventInEventBanner(eventDataCreation.name)
	                   .clickOnEventBanner(eventDataCreation.name)
	                   .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(RESOURCE_TYPE_NAME2, roleStatusTypesNames, RESOURCE_NAME2);
	    login.logOut();
	    Result="PASS";
	}
	
	@Test (priority=4, groups = {"HappyDay", "Creating And Managing Events", "HappyDay68109", "Providing Security To Event Template", "EMResource Base"})
	public void HappyDay68109() throws Exception {

		TCID = "68109";
		TC_DESCRIPTION = "Verify that security can be provided for an event template.";
		
		usersData=new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		eventSetUpData = new EventSetUpData();
	    eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		statusTypeData = new StatusTypeData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name1, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
		         .provideMaintainEventAndMaintainEventTemplateRight();
		login.logOut();
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		navigateTo.eventSetUp();
		userNames = new ArrayList<String>();
		userNames.addAll(Arrays.asList(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, userDataCreation.name1 ));
		
	    eventSetUp.createEventTemplateWithSecurity(eventSetupDataCreation.name3, eventSetupDataCreation.definition3, RESOURCE_TYPE_VALUE2, statusTypeData.Role_NST_Value_In_Region)
		          .verifyEventTemplateOnEventTemplateList(eventSetupDataCreation.name3)
		          .navigateToEventSecurityForEventTemplateScreen(eventSetupDataCreation.name3, userNames)
		          .selectUserOnEventSecurityForEventTemplateScreen(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT)
		          .clickOnSave()
		          .verifyEventTemplateListPage();
		
		navigateTo.eventManagment();
		eventManagement.verifyCreateNewEventOnEventManagementPage()
                       .navigateToCreateNewEventScreen()
                       .verifyEventTemplateOnSelectEventTemplateScreen(eventSetupDataCreation.name3)
                       .selectEventTemplate(eventSetupDataCreation.name3)
                       .verifyCreateEventScreen();
        String applicationTime = eventManagement.createEvent(eventDataCreation.name, eventDataCreation.description, RESOURCE_NAME2);
        String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.TWENTYFOUR_HOURS);                           
	    eventManagement.verifyEventDetails(eventDataCreation.name, EventData.ONGOING_STATUS, eventSetupDataCreation.name3, eventDataCreation.description, applicationTime, applicationTimePlusHour);
	    navigateTo.eventList();
	    eventManagement.verifyEventListScreen()
	                   .verifyEventDetailsOnEventList(eventDataCreation.name, EventData.ONGOING_STATUS, eventSetupDataCreation.name3, eventDataCreation.description, applicationTime, applicationTimePlusHour)
	                   .verifyEventActionOnEventList(eventDataCreation.name);
        login.logOut();
        
        login.loginAsNewUser(userDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.verifyEditAndEndLinkIsNotPresent(eventDataCreation.name)
		               .navigateToCreateNewEventScreen()
		               .verifyEventTemplateIsNotOnSelectEventTemplateScreen(eventSetupDataCreation.name3);
		login.logOut();
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.verifyEditAndEndLink(eventDataCreation.name)
		               .editSingleEvent(eventDataCreation.name, eventDataCreation.editname, eventDataCreation.editdescription)
		               .verifyEventDetails(eventDataCreation.editname, EventData.ONGOING_STATUS, eventSetupDataCreation.name3, eventDataCreation.editdescription, applicationTime, applicationTimePlusHour)
		               .verifyEventInEventBanner(eventDataCreation.updatedEventName + eventDataCreation.editname)
		               .endEvent(eventDataCreation.editname)
		               .verifyEventStatus(eventDataCreation.editname, EventData.ENDED_STATUS)
		               .verifyEventIsNotPresentInEventBanner(eventDataCreation.updatedEventName + eventDataCreation.editname);
		login.logOut();
		Result="PASS";
	}
	
	@Test (priority=5, groups = {"HappyDay", "Creating And Managing Events", "HappyDay68110",  "Edit Event Template", "EMResource Base"})
	public void HappyDay68110() throws Exception {

		TCID = "68110";
		TC_DESCRIPTION = "Verify that an event template can be edited.";
		
		eventSetUpData = new EventSetUpData();
	    eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		eventManagement = new EventManagement(this.driver);
		usersList = new UsersList(this.driver);
		
        login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		
		navigateTo.users();
		usersList.searchUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT)
		         .deselectConfigureRegionalUserAccess()
		         .clickOnSave();
		navigateTo.eventSetUp(); 
		eventSetUp.clickOnNotificationsAndDeSelectAllNotifications(EVENT_TEMPLATE_WITH_ICON_COLOR);
		login.logOut();
		
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.verifyCreateNewEventOnEventManagementPage()
                       .navigateToCreateNewEventScreen()
                       .verifyEventTemplateOnSelectEventTemplateScreen(EVENT_TEMPLATE_WITH_ICON_COLOR)
                       .selectEventTemplate(EVENT_TEMPLATE_WITH_ICON_COLOR)
                       .verifyCreateEventScreen();
        String applicationTime = eventManagement.createEvent(eventDataCreation.name, eventDataCreation.description, RESOURCE_NAME2);
        String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.TWENTYFOUR_HOURS);                           
        eventManagement.verifyEventDetails(eventDataCreation.name, EventData.ONGOING_STATUS, EVENT_TEMPLATE_WITH_ICON_COLOR, eventDataCreation.description, applicationTime, applicationTimePlusHour)
                       .verifyEventInEventBanner(eventDataCreation.name)
                       .verifyEventIconAndColour(EventSetUpData.BLUE_COLOUR_IN_EVENT_BANNER, EventData.VOLCANO_ICON, eventDataCreation.name)
                       .clickOnEventBanner(eventDataCreation.name)
                       .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(RESOURCE_TYPE_NAME2, roleStatusTypesNames, RESOURCE_NAME2);
        navigateTo.eventSetUp();               
        eventSetUp.editTemplate(EVENT_TEMPLATE_WITH_ICON_COLOR, eventSetupDataCreation.editname, eventSetupDataCreation.editdescription, EventSetUpData.HELICOPTER_ICON, EventSetUpData.ORANGE_COLOUR);
                            
        EVENT_TEMPLATE_WITH_ICON_COLOR = eventSetupDataCreation.editname;
        System.out.println("EVENT_TEMPLATE_WITH_ICON_COLOR" + EVENT_TEMPLATE_WITH_ICON_COLOR);
        eventSetUp.verifyEventTemplateNameDescriptionIconOnEventTemplateList(eventSetupDataCreation.editname, eventSetupDataCreation.editdescription, EventData.HELICOPTER_ICON, EventSetUpData.ORANGE_COLOUR_IN_EVENT_BANNER, eventDataCreation.name);
        navigateTo.eventManagment();
        eventManagement.verifyEventTemplateNameIconOneventManagement(eventDataCreation.name, eventSetupDataCreation.editname, EventData.HELICOPTER_ICON)
                       .navigateToCreateNewEventScreen()
                       .verifyEventTemplateNameDescriptionIconOnSelectEventTemplateScreen(eventSetupDataCreation.editname, eventSetupDataCreation.editdescription, EventData.HELICOPTER_ICON);
        navigateTo.eventList();
        eventManagement.verifyEventListScreen()
                       .verifyEventDetailsOnEventList(eventDataCreation.name, EventData.ONGOING_STATUS, eventSetupDataCreation.editname, eventDataCreation.description, applicationTime, applicationTimePlusHour)
                       .verifyEventActionOnEventList(eventDataCreation.name);
        login.logOut();
        Result="PASS";
	}
	
	@Test (priority=6, groups = {"HappyDay", "Creating And Managing Events", "HappyDay68111",  "Edit Event Template", "EMResource Base"})
	public void HappyDay68111() throws Exception {

		TCID = "68111";
		TC_DESCRIPTION = "Edit the event template, select/deselect resource types, status types and verify that the already created events are not affected.";
		
		eventSetUpData = new EventSetUpData();
	    eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		eventManagement = new EventManagement(this.driver);
		usersList = new UsersList(this.driver);
		
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.createEvent(EVENT_TEMPLATE_WITH_ICON_COLOR, eventDataCreation.name, eventDataCreation.description, RESOURCE_NAME2)
		               .clickOnEventBanner(eventDataCreation.name)
		               .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(RESOURCE_TYPE_NAME2, roleStatusTypesNames, RESOURCE_NAME2);
		navigateTo.eventSetUp();               
        eventSetUp.editTemplateDeselectAndSelectOtherResourceType(EVENT_TEMPLATE_WITH_ICON_COLOR, eventSetupDataCreation.editname, eventSetupDataCreation.editdescription, RESOURCE_TYPE_VALUE2, RESOURCE_TYPE_VALUE1);
        EVENT_TEMPLATE_WITH_ICON_COLOR = eventSetupDataCreation.editname; 
        System.out.println("EVENT_TEMPLATE_WITH_ICON_COLOR" + EVENT_TEMPLATE_WITH_ICON_COLOR);
		eventManagement.clickOnEventBanner(eventDataCreation.name)
                       .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(RESOURCE_TYPE_NAME2, roleStatusTypesNames, RESOURCE_NAME2);
		navigateTo.eventManagment();
		eventManagement.navigateToCreateNewEventScreen()
		               .selectEventTemplate(EVENT_TEMPLATE_WITH_ICON_COLOR)
		               .verifyResourceUnderResourcesToParticipateInThisEventSection(RESOURCE_NAME1)
		               .verifyResourceNotUnderResourcesToParticipateInThisEventSection(RESOURCE_NAME2);
		eventManagement.createEvent(eventDataCreation.name1, eventDataCreation.description1, RESOURCE_NAME1);
		eventManagement.clickOnEventBanner(eventDataCreation.name1)
                       .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(RESOURCE_TYPE_NAME1, roleStatusTypesNames, RESOURCE_NAME1);
		login.logOut();
		Result="PASS";
	}
	
	@Test (priority=7, groups = {"HappyDay", "Creating And Managing Events", "HappyDay68112",  "Edit Event Template", "EMResource Base"})
	public void HappyDay68112() throws Exception {

		TCID = "68112";
		TC_DESCRIPTION = "Verify that an event template can be deactivated.";
		
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.createEventWithAddress(EVENT_TEMPLATE_WITH_ICON_COLOR, eventDataCreation.name, eventDataCreation.description, EventData.CITY, EventData.STATE, EventData.ZIP_CODE, EventData.COUNTY, RESOURCE_NAME1);
		EVENT_WITH_ADDRESS = eventDataCreation.name;
		navigateTo.eventSetUp();
		eventSetUp.deActivateEventTemplate(EVENT_TEMPLATE_WITH_ICON_COLOR)
		          .verifyEventTemplateNotOnEventTemplateList(EVENT_TEMPLATE_WITH_ICON_COLOR)
		          .selectIncludeInactiveEventTypes()
		          .verifyEventTemplateOnEventTemplateList(EVENT_TEMPLATE_WITH_ICON_COLOR)
		          .verifyEventTemplateStatus(EVENT_TEMPLATE_WITH_ICON_COLOR, EventSetUpData.EVENT_TEMPLATE_DISABLED_STATUS);
	   navigateTo.eventManagment(); 
	   eventManagement.verifyEventOnEventManagementPage(eventDataCreation.name)
	                  .verifyEditAndEndLink(eventDataCreation.name)
	                  .navigateToCreateNewEventScreen()
	                  .verifyEventTemplateNotOnSelectEventTemplateScreen(EVENT_TEMPLATE_WITH_ICON_COLOR);
	   login.logOut();
	   Result="PASS";
//	   Map,Mobile View, mobile device part not automated
	}
	
	@Test (priority=8, groups = {"HappyDay", "Creating And Managing Events", "HappyDay68113",  "Edit Event Template", "EMResource Base"})
	public void HappyDay68113() throws Exception {

		TCID = "68113";
		TC_DESCRIPTION = "Verify that an event template can be re-activated.";
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		navigateTo.eventSetUp();
		eventSetUp.verifyEventTemplateListPage()
		          .selectIncludeInactiveEventTypes()
		          .verifyEventTemplateOnEventTemplateList(EVENT_TEMPLATE_WITH_ICON_COLOR)
                  .verifyEventTemplateStatus(EVENT_TEMPLATE_WITH_ICON_COLOR, EventSetUpData.EVENT_TEMPLATE_DISABLED_STATUS)
                  .activateEventTemplate(EVENT_TEMPLATE_WITH_ICON_COLOR)
		          .verifyEventTemplateOnEventTemplateList(EVENT_TEMPLATE_WITH_ICON_COLOR)
		          .verifySelectIncludeInactiveEventTypesRemainsSelected()
                  .verifyEventTemplateStatus(EVENT_TEMPLATE_WITH_ICON_COLOR, EventSetUpData.EVENT_TEMPLATE_ACTIVE_STATUS);
		navigateTo.eventManagment(); 
	    eventManagement.verifyEventOnEventManagementPage(EVENT_WITH_ADDRESS)
	                   .verifyEditAndEndLink(EVENT_WITH_ADDRESS)
	                   .navigateToCreateNewEventScreen()
	                   .verifyEventTemplateOnSelectEventTemplateScreen(EVENT_TEMPLATE_WITH_ICON_COLOR);            
	    login.logOut();
		Result="PASS";
	}
	
}
