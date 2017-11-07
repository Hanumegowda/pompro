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
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.Mails;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.Shared;
import EMR.pages.UsersList;
import qaFramework.Configurations.Configuration_Mails;

public class CreateEvent extends Configuration_Mails{
	
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceData resourceData;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	ResourceCreateData resourceDataCreation;
	UsersData usersData;
	UsersCreateData userDataCreation;
	EventSetUpData eventSetUpData;
	EventSetUpCreateData eventSetupDataCreation;
	EventData eventData;
	EventCreateData eventDataCreation;
	
	Login login;
	Shared navigateTo;
	EventManagement eventManagement;
	UsersList usersList;
	EventSetUp eventSetUp;
	ResourceTypes resourceTypes;
	Resources resources;
	Mails mails;
	
	static String RESOURCE_TYPE_NAME, RESOURCE_TYPE_VALUE, RESOURCE_NAME, RESOURCE_VALUE, RESOURCE_NAME1, RESOURCE_VALUE1,USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, EVENT_TEMPLATE_WITH_ADDRESS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, FUTURE_EVENT_NEVER_ENDS, EVENT_TO_BE_EDITED, FUTURE_EVENT_STARTS_AND_ENDS_AT_SPECIFIC_DATE_TIME,UPDATED_EVENT_TO_BE_EDITED;
	
	static ArrayList<String> roleBasedStatusTypesValues, roleBasedStatusTypesNames;
	
	public CreateEvent() throws Exception {
		super();
	}

	@Test (priority = 1, groups = {"HappyDay", "Creating And Managing Events", "HappyDay162617", "EMResource v3.23"})
	public void HappyDay162617() throws Exception {

		TCID = "162617";
		TC_DESCRIPTION = "Create an event template selecting mandatory address check box and verify that City, State and County are required when an event is created under it.";
		
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceData = new ResourceData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		usersData=new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		eventSetUpData = new EventSetUpData();
	    eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
	    eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		eventManagement =  new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		
		String resourceTypeValue[] = new String[1];
		String resourceValues[] = new String[1];
		
		roleBasedStatusTypesValues = new ArrayList<String>();
		roleBasedStatusTypesValues.addAll(Arrays.asList(statusTypeData.Role_NST_Value_In_Region,statusTypeData.Role_MST_Value_In_Region,statusTypeData.Role_SST_Value_In_Region,statusTypeData.Role_TST_Value_In_Region,statusTypeData.Role_DST_Value_In_Region,statusTypeData.Role_NEDOCST_Value_In_Region));
		roleBasedStatusTypesNames = new ArrayList<String>();
		roleBasedStatusTypesNames.addAll(Arrays.asList(statusTypeData.Role_NST_In_Region,statusTypeData.Role_MST_In_Region,statusTypeData.Role_SST_In_Region,statusTypeData.Role_TST_In_Region,statusTypeData.Role_DST_In_Region,statusTypeData.Role_NEDOCST_In_Region));
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
	    
		// precondition data	
	    navigateTo.resourceType();
	    resourceTypes.createResourceType(resourceTypeDataCreation.name, roleBasedStatusTypesValues);
	    resourceTypeValue[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);
		RESOURCE_TYPE_NAME = resourceTypeDataCreation.name;
		RESOURCE_TYPE_VALUE = resourceTypeValue[0];
	    
	    navigateTo.resources();
	    resources.createResourceWithAddress(resourceDataCreation.name, resourceDataCreation.abbrevation, RESOURCE_TYPE_NAME, 
	    		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
	    		ResourceData.LASTNAME, ResourceData.STREETADDRESS,
	    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
	    resourceValues[0] = resources.getResourceValue(resourceDataCreation.name);
	    RESOURCE_NAME = resourceDataCreation.name;
	    RESOURCE_VALUE = resourceValues[0];
	    
	    resources.createResourceWithAddress(resourceDataCreation.name1, resourceDataCreation.abbrevation, RESOURCE_TYPE_NAME, 
	    		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
	    		ResourceData.LASTNAME, ResourceData.STREETADDRESS,
	    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
	    resourceValues[0] = resources.getResourceValue(resourceDataCreation.name1);
	    RESOURCE_NAME1 = resourceDataCreation.name1;
	    RESOURCE_VALUE1 = resourceValues[0];
	    
	    System.out.println(RESOURCE_TYPE_NAME);
	    System.out.println(RESOURCE_TYPE_VALUE);
	    System.out.println(RESOURCE_NAME);
	    System.out.println(RESOURCE_VALUE);
	    System.out.println(RESOURCE_NAME1);
	    System.out.println(RESOURCE_VALUE1);
	    
	    //TCID-162617 starts
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
		         .provideConfigureRegionalUserAccessMainTainEventAndMaintainEventTemplateRights();
		
		USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT = userDataCreation.name;
		USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME = userDataCreation.fullName;
		login.logOut();
		
	    login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventSetUp();
		eventSetUp.createEventTemplateWithAddress(eventSetupDataCreation.name, eventSetupDataCreation.definition, EventSetUpData.HELICOPTER_ICON, EventSetUpData.ORANGE_COLOUR, RESOURCE_TYPE_VALUE, roleBasedStatusTypesValues, userDataCreation.name)
		          .verifyEventTemplateOnEventTemplateList(eventSetupDataCreation.name);
		
		EVENT_TEMPLATE_WITH_ADDRESS = eventSetupDataCreation.name;
		
		navigateTo.eventManagment();
		eventManagement.createEvent(eventSetupDataCreation.name, eventDataCreation.name, eventDataCreation.description, RESOURCE_NAME)
		               .verifyAddressRequiredMessage()
		               .verifyCityStateCountyAreMandatory()
		               .createEventWithAddress(eventDataCreation.name, eventDataCreation.description, EventData.CITY, EventData.STATE, EventData.ZIP_CODE, EventData.COUNTY)
		               .verifyWebNotificationWithAddressAndClickOnAcknowledge(eventDataCreation.name, eventDataCreation.description, EventData.CITY, EventData.COUNTY, EventData.ZIP_CODE, EventData.HAWAII_STATE)
                       .verifyEventOnEventManagementPage(eventDataCreation.name);
		login.logOut();
		Result="PASS";
	}
	
	@Test (priority = 2, groups = {"HappyDay", "Creating And Managing Events", "HappyDay162559", "EMResource v3.23"})
	public void HappyDay162559() throws Exception {

		TCID = "162559";
		TC_DESCRIPTION = "Verify that address fields are not mandatory if 'Mandatory address' is selected for an event template after the event was created";
	
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		eventSetUpData = new EventSetUpData();
	    eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		navigateTo.eventSetUp();
		eventSetUp.createEventTemplateSelectingWebOption(eventSetupDataCreation.name1, eventSetupDataCreation.definition1, RESOURCE_TYPE_VALUE, roleBasedStatusTypesValues, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT);
		EVENT_TEMPLATE_WITH_OUT_ADDRESS = eventSetupDataCreation.name1;
		
		navigateTo.eventManagment();  
		eventManagement.createEvent(eventSetupDataCreation.name1, eventDataCreation.name1, eventDataCreation.description1, RESOURCE_NAME)
		               .verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name1, eventDataCreation.description1)
		               .verifyEventOnEventManagementPage(eventDataCreation.name1);
		
		navigateTo.eventSetUp();
		eventSetUp.editEventTemplateSelectMandatoryAddress(eventSetupDataCreation.name1);
		navigateTo.eventManagment();
		eventManagement.editSingleEvent(eventDataCreation.name1, eventDataCreation.editname, eventDataCreation.editdescription);
		String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.editname;               
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(updateEventName, eventDataCreation.editdescription)
		               .verifyEventOnEventManagementPage(eventDataCreation.editname);
		login.logOut();
		Result="PASS";
	}
	
	@Test (priority = 3, groups = {"HappyDay", "Creating And Managing Events", "HappyDay118243", "EMResource v3.23"})
	public void HappyDay118243() throws Exception {

		TCID = "118243";
		TC_DESCRIPTION = "Create an event selecting to start immediately and to end after a certain number of hours and verify that user who created the event is displayed in the Event notification.";
	
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		mails = new Mails(this.driver1);
		
        login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		
		navigateTo.users();
		usersList.searchUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT)
		         .deselectConfigureRegionalUserAccess()
		         .clickOnSave();
		login.logOut();
		
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
	    
		navigateTo.eventSetUp();
		eventSetUp.editEventTemplateDeselectMandatoryAddress(EVENT_TEMPLATE_WITH_OUT_ADDRESS);
		
	    navigateTo.eventManagment();
	    eventManagement.createEventStartImmediatelyAndEndAtSpecificHour(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name1, eventDataCreation.description1, EventData.TWO_HOUR, RESOURCE_NAME);
	    eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name1, eventDataCreation.description1);
	    login.logOut();
	    
	    mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForAnEventCreated(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME,
				RegionData.REGIONNAME, eventDataCreation.description1, eventDataCreation.name1)
			 .logoutMail();
		Result="PASS";
	}
	
	@Test (priority = 4, groups = {"HappyDay", "Creating And Managing Events", "HappyDay118980", "EMResource v3.23"})
	public void HappyDay118980() throws Exception {

		TCID = "118980";
		TC_DESCRIPTION = "Verify that address is displayed in the ‘Event Banner’ when an event is created selecting a template with ‘Mandatory Address’.";
	
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		mails = new Mails(this.driver1);
		
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		
		navigateTo.eventManagment();  
		eventManagement.createEventWithAddress(EVENT_TEMPLATE_WITH_ADDRESS, eventDataCreation.name, eventDataCreation.description, EventData.CITY, EventData.STATE, EventData.ZIP_CODE, EventData.COUNTY, RESOURCE_NAME)
		               .verifyWebNotificationWithAddressAndClickOnAcknowledge(eventDataCreation.name, eventDataCreation.description, EventData.CITY, EventData.COUNTY, EventData.ZIP_CODE, EventData.HAWAII_STATE);
		String eventStartDateAndTime = eventManagement.getEventStartDate(eventDataCreation.name);
		eventManagement.verifyEventIsPresentInEventBanner(eventDataCreation.name)
		               .verifyAddressOnEventBanner(eventDataCreation.name, eventStartDateAndTime, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, eventDataCreation.description, EventData.CITY, EventData.HAWAII_STATE, EventData.ZIP_CODE, EventData.COUNTY);
		login.logOut(); 
		
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsOfSingleRegionEventWithAddress(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, RegionData.REGIONNAME, eventDataCreation.description, EventData.CITY, EventData.HAWAII_STATE, EventData.ZIP_CODE, EventData.COUNTY, eventDataCreation.name);
		mails.logoutMail();
		Result="PASS";
	}
	
	@Test (priority = 5, groups = {"HappyDay", "Creating And Managing Events", "HappyDay119026", "EMResource v3.23"})
	public void HappyDay119026() throws Exception {

		TCID = "119026";
		TC_DESCRIPTION = "Verify that event notification displays the address provided for an event which is created selecting a template for which ‘Mandatory Address’ check box is selected.";
	
		//Covered in HappyDay118980 test case, email and pager notification verification
		Result="PASS";
	}
	
	@Test (priority = 6, groups = {"HappyDay", "Creating And Managing Events", "HappyDay118981", "EMResource v3.23"})
	public void HappyDay118981() throws Exception {

		TCID = "118981";
		TC_DESCRIPTION = "Verify that address is not displayed in the ‘Event Banner’ when an event is created selecting a template for which ‘Mandatory Address’ is not selected.";
	
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		
		navigateTo.eventManagment();  
		eventManagement.createEvent(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name1, eventDataCreation.description1, RESOURCE_NAME);
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name1, eventDataCreation.description1);
		String eventStartDateAndTime = eventManagement.getEventStartDate(eventDataCreation.name1);
		eventManagement.verifyEventIsPresentInEventBanner(eventDataCreation.name1)
		               .verifyAddressIsNotOnEventBanner(eventDataCreation.name1, eventStartDateAndTime, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, eventDataCreation.description1, EventData.CITY, EventData.HAWAII_STATE, EventData.ZIP_CODE, EventData.COUNTY);
		login.logOut();   
		Result="PASS";
	}
	
	
	@Test (priority = 7, groups = {"HappyDay", "Creating And Managing Events", "HappyDay119027", "EMResource v3.23"})
	public void HappyDay119027() throws Exception {

		TCID = "119027";
		TC_DESCRIPTION = "Verify that event notification does not display the address provided for an event which is created selecting a template for which ‘Mandatory Address’ checkbox is not selected.";
	
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		mails = new Mails(this.driver1);
		
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		
		navigateTo.eventManagment();  
		eventManagement.createEventWithAddress(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name1, eventDataCreation.description1, EventData.CITY, EventData.STATE, EventData.ZIP_CODE, EventData.COUNTY, RESOURCE_NAME)		
		               .verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name1, eventDataCreation.description1);
		String eventStartDateAndTime = eventManagement.getEventStartDate(eventDataCreation.name1);
		eventManagement.verifyEventIsPresentInEventBanner(eventDataCreation.name1)
		               .verifyAddressIsNotOnEventBanner(eventDataCreation.name1, eventStartDateAndTime, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, eventDataCreation.description1, EventData.CITY, EventData.HAWAII_STATE, EventData.ZIP_CODE, EventData.COUNTY);
		login.logOut();  
		
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForAnEventCreated(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, RegionData.REGIONNAME, eventDataCreation.description1, eventDataCreation.name1);
		mails.logoutMail();
		Result="PASS";
	}
	
	@Test (priority = 8, groups = {"HappyDay", "Creating And Managing Events", "HappyDay118078", "EMResource Base"})
	public void HappyDay118078() throws Exception {

		TCID = "118078";
		TC_DESCRIPTION = "Create an event selecting to start immediately and to end after a certain number of hours and verify that the event starts immediately and ends after the specified number of hours.";
	
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		mails = new Mails(this.driver1);
		
        login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		
		navigateTo.eventManagment();  
		String applicationTime = eventManagement.createEventStartImmediatelyAndEndAtSpecificHour(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name1, eventDataCreation.description1, EventData.TWO_HOUR, RESOURCE_NAME);
	    String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.TWO_HOURS); 
	    eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name1, eventDataCreation.description1)
	                   .verifyEventOnEventManagementPage(eventDataCreation.name1)
	                   .verifyEventDetails(eventDataCreation.name1, EventData.ONGOING_STATUS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.description1, applicationTime, applicationTimePlusHour)
	                   .verifyEditAndEndLink(eventDataCreation.name1)
	                   .verifyEventInEventBanner(eventDataCreation.name1);
	    navigateTo.eventList();
	    eventManagement.verifyEventDetailsOnEventList(eventDataCreation.name1, EventData.ONGOING_STATUS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.description1, applicationTime, applicationTimePlusHour)
	                   .verifyEventActionOnEventList(eventDataCreation.name1)
	                   .verifyEventOnEventList(eventDataCreation.name1);
	    login.logOut();
	    
	    mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForAnEventCreated(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME,
				RegionData.REGIONNAME, eventDataCreation.description1, eventDataCreation.name1)
			 .logoutMail();
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
	    navigateTo.eventManagment();
	    eventManagement.endEvent(eventDataCreation.name1);
	    String endedEventName = eventDataCreation.endedEvent + eventDataCreation.name1;
	    eventManagement.verifyEndedEventWebNotification(eventDataCreation.name1, endedEventName,eventDataCreation.endedEventDescription);
	    String webNotificationDateAndTime = eventManagement.getTimeInWebNotification();
	    String eventEndedDateTime = eventManagement.getTimeInWebNotificationAndChangeDateFormat();
	    eventManagement.clickOnAcknowledgeAllNotifications();
		login.switchToDefaultWindow();
		login.selectFrame();
	    eventManagement.verifyEventDetails(eventDataCreation.name1, EventData.ENDED_STATUS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.description1, applicationTime,eventEndedDateTime);
	    navigateTo.eventList();
	    eventManagement.verifyEventDetailsOnEventList(eventDataCreation.name1, EventData.ENDED_STATUS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.description1, applicationTime, eventEndedDateTime)
	                   .verifyEventAction(eventDataCreation.name1)
	                   .verifyEventOnEventList(eventDataCreation.name1);
	    login.logOut();
	    mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
	    mails.verifyMailAndPagerNotificationsForAnEventEnded(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, eventDataCreation.name1, RegionData.REGIONNAME, webNotificationDateAndTime, UsersData.PRIMARY_EMAILID)
		     .logoutMail();
	    Result="PASS";
//	    Mobile View, mobile device part not automated
	}
	
	@Test (priority = 9, groups = {"HappyDay", "Creating And Managing Events", "HappyDay118079", "EMResource Base"})
	public void HappyDay118079() throws Exception {

		TCID = "118079";
		TC_DESCRIPTION = "Create an event selecting to start immediately and to end at a certain date and time and verify that the event starts immediately and ends at the specified date and time.";
	
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		mails = new Mails(this.driver1);
		
        login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		
		navigateTo.eventManagment(); 
		ArrayList<String> dates = eventManagement.createEventStartImmediatelyAndEndAtSpecificDateAndTime(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name3, eventDataCreation.description3,EventData.FIVE_DAYS,EventData.TWO_HOURS, RESOURCE_NAME);
	    eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name3, eventDataCreation.description3)
	                   .verifyEventOnEventManagementPage(eventDataCreation.name3)
	                   .verifyEventDetails(eventDataCreation.name3, EventData.ONGOING_STATUS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.description3, dates.get(1), dates.get(0))
	                   .verifyEditAndEndLink(eventDataCreation.name3)
	                   .verifyEventInEventBanner(eventDataCreation.name3);
	    navigateTo.eventList();
	    eventManagement.verifyEventDetailsOnEventList(eventDataCreation.name3, EventData.ONGOING_STATUS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.description3, dates.get(1), dates.get(0))
	                   .verifyEventActionOnEventList(eventDataCreation.name3)
	                   .verifyEventOnEventList(eventDataCreation.name3);
	    login.logOut();
	    
	    mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForAnEventCreated(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME,
				RegionData.REGIONNAME, eventDataCreation.description3, eventDataCreation.name3)
			 .logoutMail();
		Result="PASS";
//	    Mobile View, mobile device and Wait till event ends part not automated
	}
	
	@Test (priority = 10, groups = {"HappyDay", "Creating And Managing Events", "HappyDay118080", "EMResource Base"})
	public void HappyDay118080() throws Exception {

		TCID = "118080";
		TC_DESCRIPTION = "Create an event selecting to start immediately and to end never and verify that the event starts immediately and does not have an end date.";
        
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		mails = new Mails(this.driver1);
		
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		
		navigateTo.eventManagment(); 
		String applicationTime = eventManagement.createEventStartImmediatelyAndNeverEnd(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name4, eventDataCreation.description4, RESOURCE_NAME);
	    eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name4, eventDataCreation.description4)
	                   .verifyEventOnEventManagementPage(eventDataCreation.name4)
	                   .verifyEventDetailsWithNeverEnd(eventDataCreation.name4, EventData.ONGOING_STATUS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.description4, applicationTime, EventData.NEVER_END)
	                   .verifyEditAndEndLink(eventDataCreation.name4)
	                   .verifyEventInEventBanner(eventDataCreation.name4);
	    navigateTo.eventList();
	    eventManagement.verifyEventDetailsWithNeverEndOnEventListScreen(eventDataCreation.name4, EventData.ONGOING_STATUS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.description4, applicationTime, EventData.NEVER_END)
	                   .verifyEventActionOnEventList(eventDataCreation.name4)
	                   .verifyEventOnEventList(eventDataCreation.name4);
	    login.logOut();
	    
	    mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
	    mails.verifyMailAndPagerNotificationsForAnEventCreated(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME,
				RegionData.REGIONNAME, eventDataCreation.description4, eventDataCreation.name4)
			 .logoutMail();
	    Result="PASS";
//	    Mobile View, mobile device part not automated
	}
	
	@Test (priority = 11, groups = {"HappyDay", "Creating And Managing Events", "HappyDay118081", "EMResource Base"})
	public void HappyDay118081() throws Exception {

		TCID = "118081";
		TC_DESCRIPTION = "Create an event selecting to start at a specified date and time and to end after a certain number of hours and verify that the event starts at the specified time and ends after the specified number of hours.";
        
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		
        login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		
		navigateTo.eventManagment(); 
		eventManagement.verifyEventManagementPage();
		String applicationTime = eventManagement.createEventWithStartAtSpecificDateAndTimeAndEndAtSpecificHour(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name1, eventDataCreation.description1, EventData.TWO_DAYS, EventData.TWO_HOURS, EventData.TWO_HOUR, RESOURCE_NAME);
	    String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.TWO_HOURS); 
	    eventManagement.verifyEventOnEventManagementPage(eventDataCreation.name1)
	                   .verifyEventDetails(eventDataCreation.name1, EventData.FUTURE_STATUS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.description1, applicationTime, applicationTimePlusHour)
	                   .verifyEditAndCancelLink(eventDataCreation.name1);
	    navigateTo.eventList();
	    eventManagement.verifyEventNotInEventList(eventDataCreation.name1);
	    login.logOut();
	    
	    Result="PASS";
//	    Mobile View, mobile device, wait for N hours part not automated
	}
	
	@Test (priority = 12, groups = {"HappyDay", "Creating And Managing Events", "HappyDay118082", "EMResource Base"})
	public void HappyDay118082() throws Exception {

		TCID = "118082";
		TC_DESCRIPTION = "Create an event selecting to start at a specified date and time and to end at a certain date and time and verify that the event starts at the specified time and ends at the specified date and time.";
		
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		
        login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		
		navigateTo.eventManagment(); 
		ArrayList<String> dates = eventManagement.createEventStartAndEndAtSpecificDateAndTime(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name1, eventDataCreation.description1, EventData.ONE_DAY, EventData.ONE_HOUR, EventData.TWO_DAYS, EventData.TWO_HOURS, RESOURCE_NAME);
		FUTURE_EVENT_STARTS_AND_ENDS_AT_SPECIFIC_DATE_TIME = eventDataCreation.name1;
		eventManagement.verifyEventOnEventManagementPage(eventDataCreation.name1)
	                   .verifyEventDetails(eventDataCreation.name1, EventData.FUTURE_STATUS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.description1, dates.get(0), dates.get(1))
	                   .verifyEditAndCancelLink(eventDataCreation.name1);
	    navigateTo.eventList();
	    eventManagement.verifyEventNotInEventList(eventDataCreation.name1);
	    login.logOut();
		
		Result="PASS";
//	    Mobile View, mobile device, wait for N hours part not automated
	}
	
	@Test (priority = 13, groups = {"HappyDay", "Creating And Managing Events", "HappyDay118083", "EMResource Base"})
	public void HappyDay118083() throws Exception {

		TCID = "118083";
		TC_DESCRIPTION = "Create an event selecting to start at a specified date and time and to end never and verify that the event starts at the specified time and does not have an end date.";

		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		
        login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		
		navigateTo.eventManagment(); 
		String applicationTime = eventManagement.createEventStartSpecificDateAndTimeAndNeverEnds(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name2, eventDataCreation.description, EventData.ONE_DAY, EventData.ONE_HOUR, RESOURCE_NAME);
		FUTURE_EVENT_NEVER_ENDS = eventDataCreation.name2;
		eventManagement.verifyEventOnEventManagementPage(eventDataCreation.name2)
	                   .verifyEventDetailsWithNeverEnd(eventDataCreation.name2, EventData.FUTURE_STATUS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.description, applicationTime, EventData.NEVER_END)
	                   .verifyEditAndCancelLink(eventDataCreation.name2);
	    navigateTo.eventList();
	    eventManagement.verifyEventNotInEventList(eventDataCreation.name2);
	    login.logOut();
		Result="PASS";
//	    Mobile View, mobile device, wait for N hours part not automated
	}
	
//	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay118085"})
//	public void HappyDay118085() throws Exception {
//
//		TCID = "118085";
//		TC_DESCRIPTION = "Verify that a file can be attached to an event.";
//		Result="PASS";
//	}
	
	@Test (priority = 14, groups = {"HappyDay", "Creating And Managing Events", "HappyDay92364", "EMResource Base"})
	public void HappyDay92364() throws Exception {

		TCID = "92364";
		TC_DESCRIPTION = "Verify that an event can be created by providing data only in the mandatory fields.";
		
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		
        login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		
		navigateTo.eventManagment(); 
		eventManagement.verifyEventHeaderAndPosition(EventData.EVENT_HEADERS)
		               .verifyCreateNewEventOnEventManagementPage()
		               .navigateToCreateNewEventScreen()
		               .verifyEventTemplateOnSelectEventTemplateScreen(EVENT_TEMPLATE_WITH_OUT_ADDRESS)
		               .selectEventTemplate(EVENT_TEMPLATE_WITH_OUT_ADDRESS)
		               .verifyCreateEventScreen()
		               .verifyAllFieldsOnCreateEventScreen(RESOURCE_NAME);
		String applicationTime = eventManagement.createEvent(eventDataCreation.name, eventDataCreation.description, RESOURCE_NAME);
		String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.TWENTYFOUR_HOURS); 
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name, eventDataCreation.description)
		               .verifyEventOnEventManagementPage(eventDataCreation.name)
		               .verifyEventDetails(eventDataCreation.name, EventData.AMBER_ALERT_MISSING_CHILD_ICON, EventData.ONGOING_STATUS, applicationTime, applicationTimePlusHour, EventData.NO_DRILL, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.description);
		                           
		navigateTo.eventList();                          
		eventManagement.verifyEventActionOnEventList(eventDataCreation.name);
		String eventStartDateAndTime = eventManagement.getEventStartDate(eventDataCreation.name);
		eventManagement.verifyEventDetailsOnEventBanner(eventDataCreation.name, eventStartDateAndTime, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, eventDataCreation.description);
		login.logOut();
		
		Result="PASS";
//	    Mobile device part not automated
	}
	
	@Test (priority = 15, groups = {"HappyDay", "Creating And Managing Events", "HappyDay118120", "Edit event"})
	public void HappyDay118120() throws Exception {

		TCID = "118120";
		TC_DESCRIPTION = "Edit event and change the start time and verify that the event starts at the newly provided time.";
		
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		mails = new Mails(this.driver1);
		
        login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		
		navigateTo.eventManagment(); 
		String startDateAndTime = eventManagement.updateFutureEventStartDate(FUTURE_EVENT_NEVER_ENDS, eventDataCreation.editname, eventDataCreation.editdescription, EventData.FIVE_HOURS);
		FUTURE_EVENT_NEVER_ENDS = eventDataCreation.editname;
		eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.editname, EventData.FUTURE_STATUS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.editdescription, startDateAndTime, EventData.NEVER_END)
		               .verifyEditAndCancelLink(eventDataCreation.editname);
		navigateTo.waitForSpecificMinutes(EventSetUpData.SIX)
		          .eventManagment(); 
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.editname, eventDataCreation.editdescription)
		               .verifyEventDetailsWithNeverEnd(eventDataCreation.editname, EventData.ONGOING_STATUS, EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.editdescription, startDateAndTime, EventData.NEVER_END)
		               .verifyEditAndEndLinkUnderAction(eventDataCreation.editname);
		login.logOut();
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForAnEventCreated(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME, USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT_FULL_NAME,
					RegionData.REGIONNAME, eventDataCreation.editdescription, eventDataCreation.editname)
				 .logoutMail();
		Result="PASS";
//	    Mobile View, mobile device part not automated
	}
	
//	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay118121", "Edit event"})
//	public void HappyDay118121() throws Exception {
//
//		TCID = "118121";
//		TC_DESCRIPTION = "Edit event and change the end time and verify that the event ends at the newly provided time.";
//        
//		eventData = new EventData();
//		eventDataCreation = eventData.new EventCreateData();
//		
//		login = new Login(this.driver);
//		navigateTo = new Shared(this.driver);
//		eventManagement =  new EventManagement(this.driver);
//		mails = new Mails(this.driver1);
//		
//		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
//		
//		navigateTo.eventManagment(); 
//		ArrayList<String> dates = eventManagement.createFutureEventStartWithSpecificDateTime(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name, eventDataCreation.description, EventData.FIVE_HOURS, RESOURCE_NAME, EventData.FIFTEEN_DAYS);
//		eventManagement.updateFutureEventEndDate(eventDataCreation.name, eventDataCreation.editname, eventDataCreation.editdescription, EventData.TEN_MINUTES);
//		int waitTime = eventManagement.getApplicationTimeAndStartTimeDifference(eventDataCreation.editname);
//		navigateTo.waitForSpecificMinutes(waitTime+1)
//		          .eventManagment();
//		Result="PASS";
////	    Mobile View, mobile device part not automated
//	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay68436", "Edit event"})
	public void HappyDay68436() throws Exception {

		TCID = "68436";
		TC_DESCRIPTION = "Edit event and add new resources and verify that the newly added resources are displayed in the 'Event Status' screen.";
		
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.verifyEventManagementPage()
		               .navigateToCreateNewEventScreen()
		               .verifySelectEventTemplateScreen()
		               .selectEventTemplate(EVENT_TEMPLATE_WITH_OUT_ADDRESS)
		               .verifyCreateEventScreen()
		               .createEvent(eventDataCreation.name, eventDataCreation.description, RESOURCE_NAME);
		EVENT_TO_BE_EDITED = eventDataCreation.name;
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name, eventDataCreation.description)
					   .verifyEventOnEventManagementPage(eventDataCreation.name)
		               .clickOnEventBanner(eventDataCreation.name)
		               .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(RESOURCE_TYPE_NAME, roleBasedStatusTypesNames, RESOURCE_NAME);
		navigateTo.eventManagment();
		eventManagement.addResourceToExistingEvent(eventDataCreation.name, RESOURCE_NAME1);
		String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.name; 
		UPDATED_EVENT_TO_BE_EDITED  = updateEventName;
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(updateEventName, eventDataCreation.description)
		               .verifyEventOnEventManagementPage(eventDataCreation.name)
		               .clickOnEventBanner(updateEventName)
		               .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(RESOURCE_TYPE_NAME, roleBasedStatusTypesNames, RESOURCE_NAME1)
		               .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(RESOURCE_TYPE_NAME, roleBasedStatusTypesNames, RESOURCE_NAME);
		login.logOut();
		Result="PASS";
//	    Mobile View, mobile device part not automated
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay68437", "Edit event"})
	public void HappyDay68437() throws Exception {

		TCID = "68437";
		TC_DESCRIPTION = "Edit event and remove resources and verify that the removed resources are no longer displayed in the event detail screen.";
		
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement =  new EventManagement(this.driver);
		
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.verifyEventOnEventManagementPage(EVENT_TO_BE_EDITED)
                       .clickOnEventBanner(UPDATED_EVENT_TO_BE_EDITED)
                       .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(RESOURCE_TYPE_NAME, roleBasedStatusTypesNames, RESOURCE_NAME)
                       .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(RESOURCE_TYPE_NAME, roleBasedStatusTypesNames, RESOURCE_NAME1)
		               .editEventDeselectResource(EVENT_TO_BE_EDITED, eventDataCreation.name1, eventDataCreation.description1,RESOURCE_NAME1);
		String updateEventName1 = eventDataCreation.updatedEventName1 + eventDataCreation.name1;                        
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(updateEventName1, eventDataCreation.description)
		               .verifyEventOnEventManagementPage(eventDataCreation.name1)
                       .clickOnEventBanner(updateEventName1)
                       .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(RESOURCE_TYPE_NAME, roleBasedStatusTypesNames, RESOURCE_NAME);
		login.logOut();
		Result="PASS";
//	    Mobile View, mobile device part not automated
	}
}
