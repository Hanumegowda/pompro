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
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.Mails;
import EMR.pages.RegionList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.UsersList;
import qaFramework.Configurations.Configuration_Mails;

public class DirectedEvents extends Configuration_Mails{
	
	UsersData usersData;
	UsersCreateData userDataCreation;
	ResourceData resourceData;
	EventSetUpData eventSetUpData;
	EventData eventData;
	EventCreateData eventDataCreation;
	EventSetUpData eventSetupData;
	EventSetUpCreateData eventSetupDataCreation;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceTypeData resourceTypeData;
	
	Login login;
	SelectRegion selectRegion;
	Shared navigateTo;
	UsersList usersList;
	EventManagement eventManagement;
	RegionList regionList;
	Mails mails;
	EventSetUp eventSetUp;
	
	static String USER_WITH_ASSOCIATE_RIGHT_ON_RESOURCE, USER_WITH_UPDATE_RIGHT_ON_RESOURCE, USER_WITH_RUN_REPORT_RIGHT_ON_RESOURCE, USER_WITH_ASSOCIATE_RIGHT_ON_RESOURCE_FULL_NAME,
	USER_WITH_UPDATE_RIGHT_ON_RESOURCE_FULL_NAME, USER_WITH_RUN_REPORT_RIGHT_ON_RESOURCE_FULL_NAME, USER_WITH_MY_RESOURCE_EVENT_NOTIFICATION, MULTI_REGION_EVENT_TEMPLATE_IN_REGION_NAME,
	MULTI_REGION_EVENT_TEMPLATE_IN_REGION_NAME2;
	
	static ArrayList<String> statusTypeNames, statusTypeValuesInRegion, statusTypeValuesInRegion1;
	
	public DirectedEvents() throws Exception {
		super();
	}

	@Test (priority = 1, groups = {"HappyDay", "Creating And Managing Events", "HappyDay138972"})
	public void HappyDay138972() throws Exception {

		TCID = "138972";
		TC_DESCRIPTION = "Verify that users can subscribe to receive My Resources Only notifications.";

		resourceData=new ResourceData();
		usersData=new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		eventSetupData = new EventSetUpData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();  
	    usersList.createUserWithAssociateRightOnResource(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceData.resource_Name2_In_Region)
	             .provideMaintainEventsMaintainEventTemplatesEditEventNotificationPreferencesRightSave();
	    login.logOut();
	    
	    login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
	    navigateTo.eventNotificationUnderPreferences()
	              .verifyAllNotificationMethods(eventSetupData.EventTemplate2WithNotificationInRegion)
	              .selectMyResourcesOnlyEmailNotificationMethod(eventSetupData.EventTemplate2WithNotificationInRegion);
	    login.logOut();
	    Result = "PASS";
	}
	
	@Test (priority = 2,groups = {"HappyDay", "Creating And Managing Events", "HappyDay138973"})
	public void HappyDay138973() throws Exception {

		TCID = "138973";
		TC_DESCRIPTION = "Verify that user with any of the affiliated rights on the resource, who has subscribed to receive �My Resources Only� notification, receives the notification when an event is created selecting his/her resources.";

		resourceData=new ResourceData();
		usersList = new UsersList(this.driver);
		usersData=new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		eventManagement = new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		mails = new Mails(this.driver1);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		
		navigateTo.users();  
	    usersList.createUserWithAssociateRightOnResource(userDataCreation.name1, UsersData.INITIAL_PASSWORD, userDataCreation.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceData.resource_Name2_In_Region)
	             .provideMaintainEventsMaintainEventTemplatesEditEventNotificationPreferencesRightSave()
	             .createUserWithUpdateRightOnResourceAndSave(userDataCreation.name2, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceData.resource_Name2_In_Region)
	             .createUserWithRunReportRightOnResourceAndSave(userDataCreation.name3, UsersData.INITIAL_PASSWORD, userDataCreation.fullName3, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceData.resource_Name2_In_Region);
	    USER_WITH_ASSOCIATE_RIGHT_ON_RESOURCE = userDataCreation.name1;
	    USER_WITH_UPDATE_RIGHT_ON_RESOURCE = userDataCreation.name2;
	    USER_WITH_RUN_REPORT_RIGHT_ON_RESOURCE = userDataCreation.name3;
	    USER_WITH_ASSOCIATE_RIGHT_ON_RESOURCE_FULL_NAME = userDataCreation.fullName1;
	    USER_WITH_UPDATE_RIGHT_ON_RESOURCE_FULL_NAME = userDataCreation.fullName2;
	    USER_WITH_RUN_REPORT_RIGHT_ON_RESOURCE_FULL_NAME = userDataCreation.fullName3;
	    
	    ArrayList<String> userFullNames = new ArrayList<String>();
	    userFullNames.addAll(Arrays.asList(userDataCreation.fullName1, userDataCreation.fullName2, userDataCreation.fullName3));
	    
	    ArrayList<String> userNames = new ArrayList<String>();
		userNames.addAll(Arrays.asList(userDataCreation.name1, userDataCreation.name2, userDataCreation.name3));
		
		navigateTo.eventSetUp();
		eventSetUp.clickOnNotificationsAndDeSelectAllNotifications(eventSetupData.EventTemplate2WithNotificationInRegion);
		
		navigateTo.users();  
		usersList.enableUserToReceiveMyResourcesOnlyEmailForEventNotification(userNames, eventSetupData.EventTemplate2WithNotificationInRegion);
		login.logOut();
		
		login.loginAsNewUser(userDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
	    navigateTo.eventNotificationUnderPreferences()
	              .verifyAllNotificationMethods(eventSetupData.EventTemplate2WithNotificationInRegion);
	    navigateTo.eventManagment();
	    eventManagement.verifyCreateNewEventOnEventManagementPage()
	                   .navigateToCreateNewEventScreen()
	                   .verifyEventTemplateOnSelectEventTemplateScreen(eventSetupData.EventTemplate2WithNotificationInRegion)
	                   .selectEventTemplate(eventSetupData.EventTemplate2WithNotificationInRegion)
	                   .verifyCreateEventScreen();
	    
	    String applicationTime = eventManagement.createEvent(eventDataCreation.name, eventDataCreation.description, resourceData.resource_Name2_In_Region);
	    String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.TWENTYFOUR_HOURS);                           
	    eventManagement.verifyEventDetails(eventDataCreation.name, EventData.ONGOING_STATUS, eventSetupData.EventTemplate2WithNotificationInRegion, eventDataCreation.description, applicationTime, applicationTimePlusHour);
	    navigateTo.eventList();
	    eventManagement.verifyEventListScreen()
	                   .verifyEventDetailsOnEventList(eventDataCreation.name, EventData.ONGOING_STATUS, eventSetupData.EventTemplate2WithNotificationInRegion, eventDataCreation.description, applicationTime, applicationTimePlusHour)
	                   .verifyEventActionOnEventList(eventDataCreation.name)
	                   .verifyEventIconAndColour(EventSetUpData.RED_COLOUR_IN_EVENT_BANNER, EventData.AMBER_ALERT_MISSING_CHILD_ICON, eventDataCreation.name)
	                   .verifyEventInEventBanner(eventDataCreation.name);
	    login.logOut();
	    
	    mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailNotificationForAnEventCreated(userFullNames, userDataCreation.fullName1, RegionData.REGIONNAME, eventDataCreation.description, eventDataCreation.name)
			 .logoutMail();
		Result = "PASS";
	}
	
	@Test (priority = 3,groups = {"HappyDay", "Creating And Managing Events", "HappyDay142384"})
	public void HappyDay142384() throws Exception {

		TCID = "142384";
		TC_DESCRIPTION = "Verify that user having affiliated right on resource and subscribed to receive 'My Resource' notification receives event update notification when his / her resource is added to an ongoing event.";

		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		resourceData=new ResourceData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		eventManagement = new EventManagement(this.driver);
		mails = new Mails(this.driver1);
		
		ArrayList<String> userFullNames = new ArrayList<String>();
	    userFullNames.addAll(Arrays.asList(USER_WITH_ASSOCIATE_RIGHT_ON_RESOURCE_FULL_NAME, USER_WITH_UPDATE_RIGHT_ON_RESOURCE_FULL_NAME, USER_WITH_RUN_REPORT_RIGHT_ON_RESOURCE_FULL_NAME));
	    ArrayList<String> userNames = new ArrayList<String>();
		userNames.addAll(Arrays.asList(USER_WITH_ASSOCIATE_RIGHT_ON_RESOURCE, USER_WITH_UPDATE_RIGHT_ON_RESOURCE, USER_WITH_RUN_REPORT_RIGHT_ON_RESOURCE));
		
        login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		
		navigateTo.users();
		usersList.deselectMaintainEventTemplatesRightAndSave(USER_WITH_ASSOCIATE_RIGHT_ON_RESOURCE)
		         .enableUserToReceivePagerAndWebEventNotification(userNames, eventSetupData.EventTemplate2WithNotificationInRegion);
		
		login.logOut();
		
		login.loginAsUser(USER_WITH_ASSOCIATE_RIGHT_ON_RESOURCE, UsersData.PASSWORD);
		navigateTo.eventManagment();
	    eventManagement.createEventWithOutSelectingResource(eventSetupData.EventTemplate2WithNotificationInRegion, eventDataCreation.name, eventDataCreation.description)
	                   .verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name, eventDataCreation.description)
	                   .editEventSelectResource(eventDataCreation.name, resourceData.resource_Name2_In_Region);
	    String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.name;
	    eventManagement.verifyWebNotificationAndClickOnAcknowledge(updateEventName, eventDataCreation.description);
	    login.logOut();
	    
	    mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationForAnEventCreated(userFullNames, USER_WITH_ASSOCIATE_RIGHT_ON_RESOURCE_FULL_NAME, RegionData.REGIONNAME, eventDataCreation.description, updateEventName)
			 .logoutMail();
		Result = "PASS";
	}
	
	@Test (priority = 4,groups = {"HappyDay", "Creating And Managing Events", "HappyDay142410"})
	public void HappyDay142410() throws Exception {

		TCID = "142410";
		TC_DESCRIPTION = "Verify that user having affiliated right on resource and subscribed to receive 'My Resource' notification receives event update notification when his / her resource is added to an ongoing Ad Hoc event .";

		usersData=new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		resourceData = new ResourceData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		eventManagement =  new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		mails = new Mails(this.driver1);
		
		statusTypeNames = new ArrayList<String>();
		statusTypeNames.addAll(Arrays.asList(statusTypeData.Role_NST_In_Region,statusTypeData.Role_MST_In_Region,statusTypeData.Role_SST_In_Region,statusTypeData.Role_TST_In_Region,statusTypeData.Role_DST_In_Region,statusTypeData.Role_NEDOCST_In_Region));
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
	    navigateTo.users();
	    usersList.createUserWithAssociateRightOnResource(userDataCreation.name4, UsersData.INITIAL_PASSWORD, userDataCreation.fullName4, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceData.resource_Name2_In_Region)
	             .provideMaintainEventAndMaintainAdHocEventsRightSave()
	             .createUserWithUpdateRightOnResourceAndSave(userDataCreation.name5, UsersData.INITIAL_PASSWORD, userDataCreation.fullName5, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceData.resource_Name2_In_Region);
		
	    ArrayList<String> userNames = new ArrayList<String>();
		userNames.addAll(Arrays.asList(userDataCreation.name4, userDataCreation.name5));
		
		ArrayList<String> userFullNames = new ArrayList<String>();
	    userFullNames.addAll(Arrays.asList(userDataCreation.fullName4, userDataCreation.fullName5));
	    
		navigateTo.eventSetUp();
		eventSetUp.clickOnNotificationsAndDeSelectAllNotifications(EventData.AD_HOC_EVENT);
		navigateTo.users();
		usersList.enableUserToReceiveAllEventNotification(userNames, EventData.AD_HOC_EVENT);
	    login.logOut();
	    
	    login.loginAsNewUser(userDataCreation.name4, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.navigateToCreateAdHocEventScreen()
		               .createAdHocEvent(eventDataCreation.name, eventDataCreation.description)
		               .verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name, eventDataCreation.description)
		               .verifyEventOnEventManagementPage(eventDataCreation.name)
		               .editEventSelectResourceAndStatusType(eventDataCreation.name, eventDataCreation.editname, eventDataCreation.editdescription, resourceData.resource_Name2_In_Region, statusTypeNames);
		String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.editname;               
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(updateEventName, eventDataCreation.editdescription)
		               .verifyEventIconAndColour(EventSetUpData.RED_COLOUR_IN_EVENT_BANNER, EventData.WARNING_ICON, updateEventName);
		login.logOut();
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForAnEditedEvent(userFullNames, userDataCreation.fullName4, RegionData.REGIONNAME, eventDataCreation.editdescription, updateEventName);
		mails.logoutMail();	
		Result="PASS";
	}
	
	@Test (priority = 5,groups = {"HappyDay", "Creating And Managing Events", "HappyDay142453"})
	public void HappyDay142453() throws Exception {

		TCID = "142453";
		TC_DESCRIPTION = "Verify that user having affiliated right on resource and subscribed to receive 'My Resource' notification receives event update notification when his / her resource is added to an ongoing Multi region event.";

		usersData=new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		eventSetUpData = new EventSetUpData();
	    eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
	    resourceTypeData = new ResourceTypeData();
	    statusTypeData = new StatusTypeData();
		resourceData=new ResourceData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		regionList = new RegionList(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		eventManagement =  new EventManagement(this.driver);
		selectRegion = new SelectRegion(this.driver);
		mails = new Mails(this.driver1);
		
		statusTypeValuesInRegion = new ArrayList<String>();
		statusTypeValuesInRegion.addAll(Arrays.asList(statusTypeData.Role_NST_Value_In_Region,statusTypeData.Role_MST_Value_In_Region,statusTypeData.Role_SST_Value_In_Region,statusTypeData.Role_TST_Value_In_Region,statusTypeData.Role_DST_Value_In_Region,statusTypeData.Role_NEDOCST_Value_In_Region));
		
		statusTypeValuesInRegion1 = new ArrayList<String>();
		statusTypeValuesInRegion1.addAll(Arrays.asList(statusTypeData.Role_NST_Value_In_Region1,statusTypeData.Role_MST_Value_In_Region1,statusTypeData.Role_SST_Value_In_Region1,statusTypeData.Role_TST_Value_In_Region1,statusTypeData.Role_DST_Value_In_Region1,statusTypeData.Role_NEDOCST_Value_In_Region1));
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		
		String regionName = regionList.getRegionValue(RegionData.REGIONNAME);
		String regionName2 = regionList.getRegionValue(RegionData.REGION_NAME_2);
		ArrayList<String> regionValues = new ArrayList<String>();
	    regionValues.addAll(Arrays.asList(regionName, regionName2));
	    ArrayList<String> regionNames = new ArrayList<String>();
	    regionNames.addAll(Arrays.asList(RegionData.REGIONNAME, RegionData.REGION_NAME_2));
	    
		navigateTo.users();
	    usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name6, UsersData.INITIAL_PASSWORD, userDataCreation.fullName6, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
	             .provideMaintainEventsRightAndSave()
                 .searchUserName(userDataCreation.name6)
                 .provideRegionAccessToUser(userDataCreation.name6, regionName2);
	    
	    navigateTo.eventSetUp();
	    eventSetUp.createMultiRegionEventTemplateSelectingWebOption(eventSetupDataCreation.name1, eventSetupDataCreation.definition1, EventSetUpData.DOCTOR_ICON, EventSetUpData.GREEN_COLOUR, resourceTypeData.RT_Value_In_Region, statusTypeValuesInRegion, userDataCreation.name6);
        MULTI_REGION_EVENT_TEMPLATE_IN_REGION_NAME = eventSetupDataCreation.name1;
	    
        selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
	    navigateTo.users();
	    usersList.searchUser(userDataCreation.name6)
	             .selectFirstRole().selectAllViewResourceRight()
	             .provideMaintainEventsRightAndSave()
	             .editUserAndProvideMultiRegionEventsRight(userDataCreation.name6, regionValues)
	             .editUserSelectUpdateRightOnResource(userDataCreation.name6, resourceData.resource_Name2_In_Region1);
	    USER_WITH_MY_RESOURCE_EVENT_NOTIFICATION = userDataCreation.name6;
	    
	    navigateTo.eventSetUp();
	    eventSetUp.createMultiRegionEventTemplateSelectingWebOption(eventSetupDataCreation.name2, eventSetupDataCreation.definition2, EventSetUpData.ENVELPOE_ICON, EventSetUpData.AMBER_COLOUR, resourceTypeData.RT_Value_In_Region1, statusTypeValuesInRegion1, userDataCreation.name6);
	    MULTI_REGION_EVENT_TEMPLATE_IN_REGION_NAME2 = eventSetupDataCreation.name2;
	    
	    ArrayList<String> eventTemplateNames = new ArrayList<String>();
	    eventTemplateNames.addAll(Arrays.asList(eventSetupDataCreation.name1, eventSetupDataCreation.name2));
	    login.logOut();
	    login.loginAsNewUser(userDataCreation.name6, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
	    navigateTo.eventManagment();
	    eventManagement.createMultiregionEventSelectOneResource(eventDataCreation.name, eventDataCreation.description, regionNames, eventTemplateNames,resourceData.resource_Name2_In_Region)
	                   .verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name, eventDataCreation.description)
	                   .verifyEditAndEndLink(eventDataCreation.name)
	                   .editEventAndSelectResource(eventDataCreation.name,resourceData.resource_Name2_In_Region1);
	    String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.name;
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(updateEventName, eventDataCreation.description)
		               .verifyEventIconAndColour(EventSetUpData.GREEN_COLOUR_IN_EVENT_BANNER, EventData.DOCTOR_ICON, updateEventName);
		login.logOut();
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForMultiRegionEvent(userDataCreation.fullName6, eventDataCreation.description, userDataCreation.fullName6, RegionData.REGION_NAME_2, RegionData.REGIONNAME, updateEventName);
		mails.logoutMail();
		Result="PASS";
	}
	
	@Test (dependsOnMethods={"HappyDay142453"},groups = {"HappyDay", "Creating And Managing Events", "HappyDay142469"})
	public void HappyDay142469() throws Exception {

		TCID = "142469";
		TC_DESCRIPTION = "Verify that users subscribed for 'My Resource' notification does not receive event update notification when user's region is removed from MRE.";

		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		eventSetupData = new EventSetUpData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		
		ArrayList<String> regionNames = new ArrayList<String>();
		regionNames.addAll(Arrays.asList(RegionData.REGIONNAME, RegionData.REGION_NAME_2));
		
		ArrayList<String> eventTemplateNames = new ArrayList<String>();
		eventTemplateNames.addAll(Arrays.asList(MULTI_REGION_EVENT_TEMPLATE_IN_REGION_NAME, MULTI_REGION_EVENT_TEMPLATE_IN_REGION_NAME2));
		
		login.loginToRegionAsUser(USER_WITH_MY_RESOURCE_EVENT_NOTIFICATION, UsersData.PASSWORD, RegionData.REGION_NAME_2);
		
		navigateTo.eventManagment();
		
		eventManagement.createMultiregionEvent(eventDataCreation.name, eventDataCreation.description, regionNames, eventTemplateNames);
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name, eventDataCreation.description)
		               .verifyEventIconAndColour(EventSetUpData.AMBER_COLOUR_IN_EVENT_BANNER, EventData.ENVELOPE_ICON, eventDataCreation.name);
		               
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.verifyEventIconAndColour(EventSetUpData.GREEN_COLOUR_IN_EVENT_BANNER, EventData.DOCTOR_ICON, eventDataCreation.name);
		String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.name;
		eventManagement.editEventAndDeselectTemplateWithApplicationTime(eventDataCreation.name, regionNames.get(0), EventData.NOT_PARTICIPATING_REGION, updateEventName, eventDataCreation.description, EventData.ONE_MINUTE);
		eventManagement.verifyDisplayInEventBannerNotPresent(updateEventName);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		eventManagement.verifyEventInEventBanner(updateEventName);
		login.logOut();
		Result="PASS";
	}
}
