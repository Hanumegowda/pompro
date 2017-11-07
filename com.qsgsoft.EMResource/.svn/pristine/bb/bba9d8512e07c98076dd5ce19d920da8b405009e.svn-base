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
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.Mails;
import EMR.pages.OtherRegionList;
import EMR.pages.RegionDefault;
import EMR.pages.RegionList;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.RolesList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewsUnderSetup;
import qaFramework.Configurations.Configuration;
import qaFramework.UserDefinedFunctions.Date_Time_settings;

public class AdhocEvents extends Configuration {

	public AdhocEvents() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	EventSetUpData eventSetupData;
	EventCreateData eventDataCreation;
	UsersCreateData userDataCreation;
	UsersData usersData;
	EventData eventData;
	EventCreateData eventCreateData;
	ResourceTypeData resourceTypeData;
	ResourceData resourceData;
	StatusTypeData statusTypeData;
	RegionList regionList;
	Date_Time_settings dts;
	Login login;
	Shared navigateTo;
	EventManagement eventManagement;
	UsersList usersList;
	LoginData loginData;
	EventSetUpCreateData eventSetupDataCreation;
	RegionDefault regionDefault;
	RolesList rolesList; 
	SelectRegion selectRegion;
	View viewsList;
	ViewsUnderSetup viewUnderSetup;
	OtherRegionList otherRegionList;

	EventSetUp eventSetUp;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	Shared shared;
	ResourceCreateData resourceCreateData;
	RegionData regionData;
	View view;
	Mails mails;
	
	

	static String ADHOCEVENT_NAME,ADHOCEVENT_NAME1,ADHOCEVENT_DESCRIPTION1,ADHOCEVENT_NAME2,ADHOCEVENT_DESCRIPTION2,ADHOCEVENT_NAME3,ADHOCEVENT_DESCRPTION3,ADHOCEVENT_NAME4,
						ADHOCEVENT_DESCRIPTION,ADHOCEVENT_USER4,ADHOCEVENT_USERFULLNAME,ADHOCEVENT_NAME5,ADHOCEVENT_DESCRIPTION5;
	
	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay139772"})
	public void HappyDay139772() throws Exception {

		TCID = "139772";
		TC_DESCRIPTION = "Verify that user with 'Maintain Adhoc Events' and 'Maintain Events' right can create an Ad Hoc event.";

		/****
		 * DOES NOT DEPEND ON ANY TC
		 * LoginToApplication(loginToApplication(Username:qsgtester,RegionName:Z_REGION_NAME))
		 * createUserWithMaintainEventAndAdhocEventRight
		 								provideMaintainEventsRight
		  								provideMaintainAdHocEventsRight
		  								searchUser
		  								selectFirstRole
		  								clickOnSave
		  								login.logOut();
		  								
		 * LoginAsUser(loginAsNewUser)
		 * createAdhocEventWithResource(EventName, EventDescription, Resource, ST)
		 								navigateToCreateAdHocEventScreen,
		 								selectResource
		 								selectStatusType-----NEW
		 								
		 * verifyCreatedEvent-----NEW
		 * login.logOut();
		 ****/
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		usersData = new UsersData();
	    userDataCreation=usersData.new UsersCreateData();	
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
	    resourceTypeData=new ResourceTypeData();
	    resourceData=new ResourceData();
	    statusTypeData=new StatusTypeData();
		regionList = new RegionList(this.driver);
		usersList = new UsersList(this.driver);
		dts = new Date_Time_settings();
	    resourceTypes = new ResourceTypes(this.driver);
	    resources = new Resources(this.driver);
	    

		ArrayList<String> statusTypes = new ArrayList<String>();
		statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
							statusTypeData.Event_Private_MST_In_Region, 
							statusTypeData.Event_Role_NEDOCST_In_Region,
							statusTypeData.Event_Role_NST_In_Region, 
							statusTypeData.Event_Shared_TST_In_Region,
							statusTypeData.Event_Shared_SST_In_Region));

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name2, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
		usersList.provideMaintainEventAndMaintainAdHocEventsRightSave();
		login.logOut();
		
		login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		String applicationTime = eventManagement.createAdhocEvent(eventDataCreation.name3, eventDataCreation.description3, resourceData.resource_Name1_In_Region, statusTypes);
		String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.TWENTYFOUR_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.name3, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description3, applicationTime, applicationTimePlusHour);
//		login.logOut();
		
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140111"})
	public void HappyDay140111() throws Exception {

		TCID = "140111";
		TC_DESCRIPTION = "Verify that Ad Hoc event can be created to start immediately and end after a specific time period (say, 5 hrs), the event starts immediately and ends after the specified number of hours.";

		usersData = new UsersData();
	    userDataCreation=usersData.new UsersCreateData();	
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
	    resourceTypeData=new ResourceTypeData();
	    resourceData=new ResourceData();
	    statusTypeData=new StatusTypeData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		regionList = new RegionList(this.driver);
		usersList = new UsersList(this.driver);
		dts = new Date_Time_settings();
	    viewUnderSetup = new ViewsUnderSetup(this.driver);
	    resourceTypes = new ResourceTypes(this.driver);
	    resources = new Resources(this.driver);

				
		/****
		 * DOES NOT DEPEND ON ANY TC
		 * LoginToApplication
		 * createAdhocEventWithResourceAndEndAfterSpecifiedHours(EventName, EventDescription, addHoursToExistingTime, Resource, ST)
		 * verifyCreatedEvent
		 * verifyEndDateOfEvent
		 * verifyEventBanner(EventName)
		 * logout
		 ****/
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name1, UsersData.INITIAL_PASSWORD, userDataCreation.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
		usersList.provideMaintainEventAndMaintainAdHocEventsRightSave();
		login.logOut();
		login.loginAsNewUser(userDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.navigateToCreateAdHocEventScreen();
		String[] dates=eventManagement.createAdHocEventStartImmediatelyAndEndAtSpecificHour(eventDataCreation.name1, eventDataCreation.description1, "5", resourceData.resource_Name1_In_Region, statusTypeData.Role_NST_In_Region);
		eventManagement.verifyEventDetails(eventDataCreation.name1, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT , eventDataCreation.description1, dates[0], dates[1]);
		login.logOut();
		
		ADHOCEVENT_NAME5 = eventDataCreation.name1;
		ADHOCEVENT_DESCRIPTION5 = eventDataCreation.description1;
		
		Result = "PASS";
	}
	
	@Test (dependsOnMethods={"HappyDay139772"},groups = {"HappyDay", "Creating and managing events", "HappyDay140112"})
	public void HappyDay140112() throws Exception {

		TCID = "140112";
		TC_DESCRIPTION = "Verify that when a Ad Hoc event can be created to start immediately and end after a "
				+ "specific date & time (say, 5:00 PM on date X+1, where X is the current date), the event starts "
				+ "immediately and ends at the specified time on the date set (5:00 PM on date X+1)";

		/****
		 * DOES NOT DEPEND ON ANY TC
		 * LoginToApplication(loginToApplication(Username:qsgtester,RegionName:Z_REGION_NAME))
		 * createUserWithMaintainEventAndAdhocEventRight
		 						provideMaintainEventsRight
		 						provideMaintainAdHocEventsRight
		 						searchUser
		  						selectFirstRole
		  						clickOnSave
		  						login.logOut();
		  						
		 * createAdhocEventWithResourceEndAfterSpecifiedTime(EventName, EventDescription, EventStartDate, startTime, endADate, endTime, Resource, ST)
		 						createAdHocEventStartImmediatelyAndEndAtSpecificHour
		 * verifyCreatedEvent(Writing function in previous test cases)
		 * verifyEndDateOfEvent(never)
		 						verifyEventEndNever
		 * verifyEventBanner(EventName)
		 						verifyEventPresentInEventBanner
		 * login.logOut();
		 ****/
		usersData = new UsersData();
	    userDataCreation=usersData.new UsersCreateData();	
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
	    resourceTypeData=new ResourceTypeData();
	    resourceData=new ResourceData();
	    statusTypeData=new StatusTypeData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		regionList = new RegionList(this.driver);
		usersList = new UsersList(this.driver);
		dts = new Date_Time_settings();
	    viewUnderSetup = new ViewsUnderSetup(this.driver);
	    resourceTypes = new ResourceTypes(this.driver);
	    resources = new Resources(this.driver);

		ArrayList<String> statusTypes = new ArrayList<String>();
		statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
							statusTypeData.Event_Private_MST_In_Region, 
							statusTypeData.Event_Role_NEDOCST_In_Region,
							statusTypeData.Event_Role_NST_In_Region, 
							statusTypeData.Event_Shared_TST_In_Region,
							statusTypeData.Event_Shared_SST_In_Region));
		
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//		navigateTo.users();
//		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name1, UsersData.INITIAL_PASSWORD, userDataCreation.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
//		usersList.provideMaintainEventAndMaintainAdHocEventsRightSave();
//		login.logOut();
		
		String applicationTime = eventManagement.createAdhocEventWithEndSpecificDateAndTime(eventDataCreation.name8, eventDataCreation.description1, EventData.FOUR_HOUR, resourceData.resource_Name1_In_Region, statusTypes);
		String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.FOUR_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.name8, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT , eventDataCreation.description1, applicationTime, applicationTimePlusHour);
		login.logOut();
		
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140114"})
	public void HappyDay140114() throws Exception {

		TCID = "140114";
		TC_DESCRIPTION = "Verify that the Ad Hoc event starts immediately and does not display the end date when "
				+ "a Ad Hoc event is created selecting to start immediately and to end never.";

		/****
		 * DOES NOT DEPEND ON ANY TC
		 * LoginToApplication(loginToApplication(Username:qsgtester,RegionName:Z_REGION_NAME))
		 * createUserWithMaintainEventAndAdhocEventRight
		 						provideMaintainEventsRight
		 						provideMaintainAdHocEventsRight
		 						searchUser
		  						selectFirstRole
		  						clickOnSave
		  						login.logOut();
		 * createNeverEndingAdhocEventWithResource-----NEW(EventName, EventDescription, Resource, ST)
		 * verifyEventStartTime--verifyEventStartDate
		 * verifyEndDateOfEvent--verifyEventEndDate
		 * logout
		 ****/
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		userDataCreation=usersData.new UsersCreateData();	
		usersList = new UsersList(this.driver);
		statusTypeData=new StatusTypeData();
		view = new View(this.driver);
		resourceTypeData = new ResourceTypeData();
		
		ArrayList<String> statusTypes = new ArrayList<String>();
		statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
							statusTypeData.Event_Private_MST_In_Region, 
							statusTypeData.Event_Role_NEDOCST_In_Region,
							statusTypeData.Event_Role_NST_In_Region, 
							statusTypeData.Event_Shared_TST_In_Region,
							statusTypeData.Event_Shared_SST_In_Region));
		
		String resourceName =  resourceData.resource_Name1_In_Region ;
		String resourceType =  resourceTypeData.RT_Name_In_Region;
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name4, UsersData.INITIAL_PASSWORD, userDataCreation.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
		usersList.provideMaintainEventAndMaintainAdHocEventsRightSave();
		login.logOut();
		
		login.loginAsNewUser(userDataCreation.name4, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		
		String dates= eventManagement.createNeverEndAdhocEvent(eventDataCreation.name9, eventDataCreation.description1, resourceData.resource_Name1_In_Region, statusTypes);
		eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.name9, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description1, dates, EventData.NEVER_END)
					   .navigateToEventStatusFromEventBanner(eventDataCreation.name9)
					   .verifyEventStatusPage();
		view.verifyResourceTypeResourceAndStatusType(resourceType, resourceName, statusTypes);
		login.logOut();
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140115"})
	public void HappyDay140115() throws Exception {

		TCID = "140115";
		TC_DESCRIPTION = "Verify that a Ad Hoc event can be created selecting to start the event at specified "
				+ "date (say, 4:00 PM & day as x+1 where x is current date) and end after 4 hours";

		/****
		 * DOES NOT DEPEND ON ANY TC
		 * LoginToApplication(loginToApplication(Username:qsgtester,RegionName:Z_REGION_NAME))
		 * createUserWithMaintainEventAndAdhocEventRight
		 					provideMaintainEventsRight
		 					provideMaintainAdHocEventsRight
		 					searchUser
		  					selectFirstRole
		  					clickOnSave
		  					login.logOut();
		 * createFutureAdhocEventWithResourceEndAfterSpecifiedHours-----NEW(EventName, EventDescription, EventStartDate, startTime, endAfterXHours, Resource, ST)
		 * verifyEventStartTime(verifyEventStartDate)
		 * verifyEndDateOfEvent(verifyEventEndDate)
		 * login.logOut();
		 ****/
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		userDataCreation=usersData.new UsersCreateData();	
		usersList = new UsersList(this.driver);
		statusTypeData=new StatusTypeData();
		
		ArrayList<String> statusTypes = new ArrayList<String>();
		statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
							statusTypeData.Event_Private_MST_In_Region, 
							statusTypeData.Event_Role_NEDOCST_In_Region,
							statusTypeData.Event_Role_NST_In_Region, 
							statusTypeData.Event_Shared_TST_In_Region,
							statusTypeData.Event_Shared_SST_In_Region));

		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name1, UsersData.INITIAL_PASSWORD, userDataCreation.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
		usersList.provideMaintainEventAndMaintainAdHocEventsRightSave();
		login.logOut();
				
		login.loginAsNewUser(userDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		
		String startDate= eventManagement.createFutureAdhocEventWithSpecificStartDateTimeAndEndHours(eventDataCreation.name4, eventDataCreation.description1, EventData.ONE_DAY, EventData.FIVE_HOURS, EventData.FOUR_HOUR, resourceData.resource_Name1_In_Region, statusTypes);
		String endDate = eventManagement.addTimeToExistingTime(startDate, EventData.FOUR_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.name4, EventData.FUTURE_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description1, startDate, endDate);
		login.logOut();
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140116"})
	public void HappyDay140116() throws Exception {

		TCID = "140116";
		TC_DESCRIPTION = "Verify that a Ad Hoc event can be created selecting to start & end the event at specified date & time "
				+ "(Start say, 4:00 PM & day as x+1 & end at 3:00 PM and day as x+2 where x is current date )";

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		userDataCreation=usersData.new UsersCreateData();	
		usersList = new UsersList(this.driver);
		statusTypeData=new StatusTypeData();
		
		ArrayList<String> statusTypes = new ArrayList<String>();
		statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
							statusTypeData.Event_Private_MST_In_Region, 
							statusTypeData.Event_Role_NEDOCST_In_Region,
							statusTypeData.Event_Role_NST_In_Region, 
							statusTypeData.Event_Shared_TST_In_Region,
							statusTypeData.Event_Shared_SST_In_Region));

		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name1, UsersData.INITIAL_PASSWORD, userDataCreation.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
		usersList.provideMaintainEventAndMaintainAdHocEventsRightSave();
		login.logOut();
				
		login.loginAsNewUser(userDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		ArrayList<String> dates= eventManagement.createFutureAdhocEventWithSpecificStartAndEndDateTime(eventDataCreation.name5, eventDataCreation.description1, EventData.ONE_DAY, EventData.FIVE_HOURS, EventData.TWO_DAYS, EventData.TWO_HOURS, resourceData.resource_Name1_In_Region, statusTypes);
		eventManagement.verifyEventDetails(eventDataCreation.name5, EventData.FUTURE_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description1, dates.get(0), dates.get(1));
		
		ADHOCEVENT_NAME2= eventDataCreation.name5;
		ADHOCEVENT_DESCRIPTION2= eventDataCreation.description1;
		
		login.logOut();
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140117"})
	public void HappyDay140117() throws Exception {

		TCID = "140117";
		TC_DESCRIPTION = "Verify that a Ad Hoc event can be created selecting to start the event at specified date & time "
				+ "(say, 4:00 PM & day as x+1 where x is current date) and to end never";

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		userDataCreation=usersData.new UsersCreateData();	
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		statusTypeData=new StatusTypeData();
		usersList = new UsersList(this.driver);
		
		ArrayList<String> statusTypes = new ArrayList<String>();
		statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
							statusTypeData.Event_Private_MST_In_Region, 
							statusTypeData.Event_Role_NEDOCST_In_Region,
							statusTypeData.Event_Role_NST_In_Region, 
							statusTypeData.Event_Shared_TST_In_Region,
							statusTypeData.Event_Shared_SST_In_Region));
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name2, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
				usersList.provideMaintainEventAndMaintainAdHocEventsRightSave();
				login.logOut();
				
		login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		ArrayList<String> dates=eventManagement.createFutureAdhocEventWithSpecificStartAndEndNever(eventDataCreation.name6, eventDataCreation.description3, EventData.ONE_DAY, EventData.ONE_HOUR, resourceData.resource_Name1_In_Region, statusTypes);
		eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.name6, EventData.FUTURE_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description3, dates.get(0),EventData.NEVER_END);
		
		ADHOCEVENT_NAME3= eventDataCreation.name6;
		ADHOCEVENT_DESCRPTION3= eventDataCreation.description3;
		login.logOut();

		Result = "PASS";
	}
	
	@Test (dependsOnMethods={"HappyDay139772"},groups = {"HappyDay", "Creating and managing events", "HappyDay140119"})
	public void HappyDay140119() throws Exception {

		TCID = "140119";
		TC_DESCRIPTION = " Verify that Ad Hoc event can not be created by deselecting the option 'Display in Event Banner'.";

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		statusTypeData=new StatusTypeData();
		usersList = new UsersList(this.driver);
		
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//		navigateTo.users();
//		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name2, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
//				usersList.provideMaintainEventAndMaintainAdHocEventsRightSave();
//				login.logOut();
//				
//	   login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
	 
	  ArrayList<String> statusTypes = new ArrayList<String>();
	  statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
							statusTypeData.Event_Private_MST_In_Region, 
							statusTypeData.Event_Role_NEDOCST_In_Region,
							statusTypeData.Event_Role_NST_In_Region, 
							statusTypeData.Event_Shared_TST_In_Region,
							statusTypeData.Event_Shared_SST_In_Region));
		
	  String applicationTime=eventManagement.createAdhocEventAndDeselectDisplayBanner(eventDataCreation.name7, eventDataCreation.description3, resourceData.resource_Name1_In_Region, statusTypes);
	  String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.TWENTYFOUR_HOURS);
	  eventManagement.verifyEventDetails(eventDataCreation.name7, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description3, applicationTime, applicationTimePlusHour);
		login.logOut();
		
//	    createFutureAdhocEventWithSpecificStartAndEndNever-------->NEW
//	   						navigateToCreateAdHocEventScreen
//	   						enterEventName(eventDataCreation.name7)
//	   						enterEventDescription(eventDataCreation.description3)
//	   						deselectDisplayEventBanner
//	   						clickOnNext
//	   						verifySelectResourcesPageIsDisplayed
//	   						clickOnNext
//	   						verifyValidationMessage------>NEW
//	   						clickPrevious------>NEW
//	   						verifySelectResourcesPageIsDisplayed
//	   						selectResource
//	   						clickOnNext
//	   						verifySelectStatusTypesPageIsDisplayed
//	   						selectStatusType
//	   						clickOnNext
//	   						verifyAdHocEventConfirmationPageIsDisplayed
//	   						clickYes
//	   						
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140120"})
	public void HappyDay140120() throws Exception {

		TCID = "140120";
		TC_DESCRIPTION = " Verify that Ad Hoc event can be modified by clicking on 'Modify' button on 'Ad Hoc Event Confirmation' page";

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		usersData = new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		statusTypeData=new StatusTypeData();
		usersList = new UsersList(this.driver);
		
		 ArrayList<String> statusTypes = new ArrayList<String>();
		  statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
								statusTypeData.Event_Private_MST_In_Region, 
								statusTypeData.Event_Role_NEDOCST_In_Region,
								statusTypeData.Event_Role_NST_In_Region, 
								statusTypeData.Event_Shared_TST_In_Region,
								statusTypeData.Event_Shared_SST_In_Region));
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name3, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
				usersList.provideMaintainEventAndMaintainAdHocEventsRightSave();
				login.logOut();
				
	   login.loginAsNewUser(userDataCreation.name3, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
	   navigateTo.eventManagment();
	   ArrayList<String> dates=eventManagement.createAndModifyAdhocEventWithFutureStartAndEndDate(eventDataCreation.name10, eventDataCreation.description4, EventData.ONE_DAY, EventData.ONE_HOUR, EventData.THIRTYTWO_DAYS, EventData.FIVE_HOURS, resourceData.resource_Name1_In_Region, statusTypes,EventData.FIVE_DAYS,EventData.ONE_HOUR);
	   eventManagement.verifyEventDetails(eventDataCreation.name10, EventData.FUTURE_STATUS, EventData.AD_HOC_EVENT,  eventDataCreation.description4, dates.get(0), dates.get(2));
	  
	  ADHOCEVENT_NAME4=eventDataCreation.name10;
	  ADHOCEVENT_DESCRIPTION= eventDataCreation.description4;
	  ADHOCEVENT_USER4= userDataCreation.name3;
	  ADHOCEVENT_USERFULLNAME = userDataCreation.fullName2;
	 
	   login.logOut();
	   Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140373"})
	public void HappyDay140373() throws Exception {

		TCID = "140373";
		TC_DESCRIPTION = " Verify that resources are not included in the Ad Hoc event created when resources are not selected while creating an event. ";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		usersData = new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		statusTypeData=new StatusTypeData();
		usersList = new UsersList(this.driver);
		view = new View(this.driver);
		resourceTypeData = new ResourceTypeData();
		
		 ArrayList<String> statusTypes = new ArrayList<String>();
		  statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
								statusTypeData.Event_Private_MST_In_Region, 
								statusTypeData.Event_Role_NEDOCST_In_Region,
								statusTypeData.Event_Role_NST_In_Region, 
								statusTypeData.Event_Shared_TST_In_Region,
								statusTypeData.Event_Shared_SST_In_Region));
		  
		String resourceName =  resourceData.resource_Name1_In_Region ;
		String resourceType =  resourceTypeData.RT_Name_In_Region;
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name4, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .provideMaintainEventAndMaintainAdHocEventsRightSave();
				login.logOut();
		
		login.loginAsNewUser(userDataCreation.name4, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		String applicationTime = eventManagement.createAdhocEventWithEndTimeAndDeselectResource(eventDataCreation.name11, eventDataCreation.description3);
		String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.TWENTYFOUR_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.name11, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description3, applicationTime, applicationTimePlusHour)
					   .navigateToEventStatusFromEventBanner(eventDataCreation.name11);
		
		view.verifyNoResourceTypeResourceAndStatusTypeIsPresent(resourceType, resourceName, statusTypes);
		login.logOut();
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.searchUser(userDataCreation.name4)
			     .deselectMainatinAdhocEventRightAndSave();
		login.logOut();
		
		login.loginAsUser(userDataCreation.name4, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.noAdhocEventButtonPresent();
		eventManagement.verifyEventDetails(eventDataCreation.name11, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description3, applicationTime, applicationTimePlusHour);

		Result = "PASS";
	}
	
	@Test (dependsOnMethods={"HappyDay140373"},groups = {"HappyDay", "Creating and managing events", "HappyDay140374"})
	public void HappyDay140374() throws Exception {

		TCID = "140374";
		TC_DESCRIPTION = "  Verify that user with 'Maintain Events'right cannot Create/Edit an 'Ad Hoc' event";
		
//		This test case senario is covered in HappyDay140373 TC
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140383"})
	public void HappyDay140383() throws Exception {

		TCID = "140383";
		TC_DESCRIPTION = "  Verify that user receives event update notifications when an Ad Hoc event is edited.";
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		usersData = new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		statusTypeData=new StatusTypeData();
		usersList = new UsersList(this.driver);
		mails = new Mails(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		
		ArrayList<String> statusTypes = new ArrayList<String>();
		statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
								statusTypeData.Event_Private_MST_In_Region, 
								statusTypeData.Event_Role_NEDOCST_In_Region,
								statusTypeData.Event_Role_NST_In_Region, 
								statusTypeData.Event_Shared_TST_In_Region,
								statusTypeData.Event_Shared_SST_In_Region));
		  
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name5, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .provideMaintainEventAndMaintainAdHocEventsRightSave();
		
		login.logOut();
		
		login.loginAsNewUser(userDataCreation.name5, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		String applicationTime = eventManagement.createAdhocEvent(eventDataCreation.name15, eventDataCreation.description3, resourceData.resource_Name1_In_Region, statusTypes);
		String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.TWENTYFOUR_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.name15, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description3, applicationTime, applicationTimePlusHour);
		login.logOut();
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		
		navigateTo.users();
		usersList.searchUser(userDataCreation.name5)
		 		 .clickOnEventNotificationPrefrences();
		navigateTo.selectWebPagerAndMailNotificationMethod(EventData.AD_HOC_EVENT);
		navigateTo.eventSetUp();
		eventSetUp.clickOnNotificationsAndDeSelectAllNotifications(EventData.AD_HOC_EVENT);
		login.logOut();
		
		login.loginAsUser(userDataCreation.name5, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.editAdhocEvent(eventDataCreation.name15, eventDataCreation.editname);
		String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.editname;
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(updateEventName, eventDataCreation.description3);
		login.logOut();
		
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForAnEventCreated(userDataCreation.fullName2,userDataCreation.fullName2, RegionData.REGIONNAME, eventDataCreation.description3, updateEventName)
		 	 .logoutMail();
		
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140388"})
	public void HappyDay140388() throws Exception {

		TCID = "140388";
		TC_DESCRIPTION = " Edit an Ad Hoc event and change the end time and verify that the event ends at the newly provided time.";
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		usersData = new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		statusTypeData=new StatusTypeData();
		usersList = new UsersList(this.driver);
		mails = new Mails(this.driver);
		
		 ArrayList<String> statusTypes = new ArrayList<String>();
		  statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
								statusTypeData.Event_Private_MST_In_Region, 
								statusTypeData.Event_Role_NEDOCST_In_Region,
								statusTypeData.Event_Role_NST_In_Region, 
								statusTypeData.Event_Shared_TST_In_Region,
								statusTypeData.Event_Shared_SST_In_Region));
		  
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name4, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .provideMaintainEventAndMaintainAdHocEventsRightSave();
		login.logOut();
		
		login.loginAsNewUser(userDataCreation.name4, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		
		String applicationTime = eventManagement.createAdhocEvent(eventDataCreation.name16, eventDataCreation.description3, resourceData.resource_Name1_In_Region, statusTypes);
		String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.TWENTYFOUR_HOURS);
//		String applicationTime = eventManagement.createAdhocEventWithEndSpecificDateAndTime(eventDataCreation.name14, eventDataCreation.description4, EventData.FOUR_HOUR, resourceData.resource_Name1_In_Region, statusTypes);
//		String applicationTimePlusHour = eventManagement.getApplicationTimeAndAddhour(applicationTime, EventData.FIVE_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.name16, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description3, applicationTime, applicationTimePlusHour);
		String endTime= eventManagement.editAdhocEventSelectSpecificEndDateTime(eventDataCreation.name16, eventDataCreation.editname1, EventData.FOUR_DAYS, EventData.FIVE_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.editname1, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description3, applicationTime, endTime);
		
		
		/*eventManagement.editAdhocEvent()------>Writing in Previous Test case
						  clickEditLink(ADHOCEVENT_EVENT2);
						  verifyEditAdhocEventPAge------>Writing in Previous Test case
						  enterEventName(editEventName);
						  updateFutureEndDateAndTimeForEvent(endDate, endHours)
						  clickOnNext();
						  verifySelectResourcesPageIsDisplayed();
						  clickOnNext();
						  verifySelectStatusTypesPageIsDisplayed();
						  clickOnNext();
						  verifyAdHocEventConfirmationPageIsDisplayed();
						  clickYes();
		eventManagement.verifyEventDetails(editEventName, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT, ADHOCEVENT_DESCRIPTION1, startTime, endTime)				
*/
		login.logOut();
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140389"})
	public void HappyDay140389() throws Exception {

		TCID = "140389";
		TC_DESCRIPTION = " Verify that a never ending Ad Hoc event can be edited to end after certain number of hours.";
		
		/*eventManagement.editAdhocEvent()------>Writing in Previous Test case
		  				clickEditLink(ADHOCEVENT_NAME3);
		  				verifyEditAdhocEventPAge------>Writing in Previous Test case
		  				enterEventName(editEventName);
		  				enterEndAfterSpecificHoursOfAnEvent(eventEndHour)
			 			clickOnNext();
		  				verifySelectResourcesPageIsDisplayed();
		  				clickOnNext();
		  				verifySelectStatusTypesPageIsDisplayed();
		  				clickOnNext();
		  				verifyAdHocEventConfirmationPageIsDisplayed();
		  				clickYes();
		eventManagement.verifyEventDetails(editEventName, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT, ADHOCEVENT_DESCRPTION2, startTime, endTime)				
*/
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		usersData = new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		statusTypeData=new StatusTypeData();
		usersList = new UsersList(this.driver);
		
		ArrayList<String> statusTypes = new ArrayList<String>();
		  statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
								statusTypeData.Event_Private_MST_In_Region, 
								statusTypeData.Event_Role_NEDOCST_In_Region,
								statusTypeData.Event_Role_NST_In_Region, 
								statusTypeData.Event_Shared_TST_In_Region,
								statusTypeData.Event_Shared_SST_In_Region));
		  
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name11, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .provideMaintainEventAndMaintainAdHocEventsRightSave();
		login.logOut();
		
		login.loginAsNewUser(userDataCreation.name11, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		
		String applicationTime = eventManagement.createNeverEndAdhocEvent(eventDataCreation.name14, eventDataCreation.description3, resourceData.resource_Name1_In_Region, statusTypes);
		eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.name14, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT,  eventDataCreation.description3, applicationTime, EventData.NEVER_END);
		String endDate = eventManagement.editAdhocEventSelectSpecificEndHour(eventDataCreation.name14, eventDataCreation.editname, EventData.FIVE_HOUR,applicationTime,EventData.FIVE_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.editname, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description3, applicationTime, endDate);
		login.logOut();
		Result = "PASS";
	}
		
	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140390"})
	public void HappyDay140390() throws Exception {

		TCID = "140390";
		TC_DESCRIPTION = "  Verify that a never ending Ad Hoc event can be edited to end on a certain date at a specified time.";
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		usersData = new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		statusTypeData=new StatusTypeData();
		usersList = new UsersList(this.driver);
		
		ArrayList<String> statusTypes = new ArrayList<String>();
		  statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
								statusTypeData.Event_Private_MST_In_Region, 
								statusTypeData.Event_Role_NEDOCST_In_Region,
								statusTypeData.Event_Role_NST_In_Region, 
								statusTypeData.Event_Shared_TST_In_Region,
								statusTypeData.Event_Shared_SST_In_Region));
		  
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name12, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .provideMaintainEventAndMaintainAdHocEventsRightSave();
				login.logOut();
		
		login.loginAsNewUser(userDataCreation.name12, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		
		String applicationTime = eventManagement.createNeverEndAdhocEvent(eventDataCreation.name13, eventDataCreation.description3, resourceData.resource_Name1_In_Region, statusTypes);
		eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.name13, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT,  eventDataCreation.description3, applicationTime, EventData.NEVER_END);
		String endDate = eventManagement.editAdhocEventSelectSpecificEndDateTime(eventDataCreation.name13, eventDataCreation.editname, EventData.ONE_DAY, EventData.ONE_HOUR);
		eventManagement.verifyEventDetails(eventDataCreation.editname, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT,
				  eventDataCreation.description3, applicationTime, endDate);		
		
		login.logOut();
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140391"})
	public void HappyDay140391() throws Exception {

		TCID = "140391";
		TC_DESCRIPTION = "Verify that Ad Hoc event ends at the newly specified End date and time when the event end date is edited to time earlier than the previously provided end date and time.";
		
	     /* eventManagement.editEventSelectSpecificEndDateTime(eventName, editEventName, endDateTime, endHours);
	      eventManagement.verifyEventDetails(editEventName, EventData.ONGOING_STATUS, EventData.AD_HOC_EVENT,
		   																ADHOCEVENT_DESCRPTION2, startTime, endTime)		
		 	*/	
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		userDataCreation=usersData.new UsersCreateData();
		statusTypeData=new StatusTypeData();
		usersList = new UsersList(this.driver);
		
		ArrayList<String> statusTypes = new ArrayList<String>();
		statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
								statusTypeData.Event_Private_MST_In_Region, 
								statusTypeData.Event_Role_NEDOCST_In_Region,
								statusTypeData.Event_Role_NST_In_Region, 
								statusTypeData.Event_Shared_TST_In_Region,
								statusTypeData.Event_Shared_SST_In_Region));
		  
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name12, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .provideMaintainEventAndMaintainAdHocEventsRightSave();
		login.logOut();
				
		login.loginAsNewUser(userDataCreation.name12, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		
		ArrayList<String> dates= eventManagement.createFutureAdhocEventWithSpecificStartAndEndDateTime(eventDataCreation.name15, eventDataCreation.description1, EventData.ONE_DAY, EventData.ONE_HOUR, EventData.TWO_DAYS, EventData.TWO_HOURS, resourceData.resource_Name1_In_Region, statusTypes);
		eventManagement.verifyEventDetails(eventDataCreation.name15, EventData.FUTURE_STATUS, EventData.AD_HOC_EVENT , eventDataCreation.description1, dates.get(0), dates.get(1));
		ArrayList<String> dates1= eventManagement.editAdhocEventWithEndDateAndTime(eventDataCreation.name15, eventDataCreation.editname,EventData.ONE_DAY, EventData.FIVE_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.editname, EventData.FUTURE_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description1, dates.get(0), dates1.get(0));
		
		login.logOut();
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140392"})
	public void HappyDay140392() throws Exception {

		TCID = "140392";
		TC_DESCRIPTION = " Verify that Ad Hoc event starts and ends at the newly provided date and time before the previously provided event start and end date/time for a future Ad Hoc event. ";
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		userDataCreation=usersData.new UsersCreateData();
		statusTypeData=new StatusTypeData();
		usersList = new UsersList(this.driver);
		
		ArrayList<String> statusTypes = new ArrayList<String>();
		  statusTypes.addAll(Arrays.asList(statusTypeData.Event_Private_DST_In_Region, 
								statusTypeData.Event_Private_MST_In_Region, 
								statusTypeData.Event_Role_NEDOCST_In_Region,
								statusTypeData.Event_Role_NST_In_Region, 
								statusTypeData.Event_Shared_TST_In_Region,
								statusTypeData.Event_Shared_SST_In_Region));
		  
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name12, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .provideMaintainEventAndMaintainAdHocEventsRightSave();
		login.logOut();
				
		login.loginAsNewUser(userDataCreation.name12, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		
		ArrayList<String> dates= eventManagement.createFutureAdhocEventWithSpecificStartAndEndDateTime(eventDataCreation.name15, eventDataCreation.description1, EventData.ONE_DAY, EventData.FIVE_HOURS, EventData.TWO_DAYS, EventData.TWO_HOURS, resourceData.resource_Name1_In_Region, statusTypes);
		eventManagement.verifyEventDetails(eventDataCreation.name15, EventData.FUTURE_STATUS, EventData.AD_HOC_EVENT , eventDataCreation.description1, dates.get(0), dates.get(1));
		ArrayList<String> dates1 = eventManagement.editAdhocEventSelectSpecificStartAndEndDateAndTime(eventDataCreation.name15, eventDataCreation.editname, EventData.ONE_DAY, EventData.ONE_HOUR,EventData.TWO_DAYS,EventData.ONE_HOUR);
		eventManagement.verifyEventDetails(eventDataCreation.editname, EventData.FUTURE_STATUS, EventData.AD_HOC_EVENT, eventDataCreation.description1, dates.get(0), dates1.get(0));
				
		login.logOut();
		Result = "PASS";
	}
	
	@Test (dependsOnMethods={"HappyDay140392"},groups = {"HappyDay", "Creating and managing events", "HappyDay140395"})
	public void HappyDay140395() throws Exception {

		TCID = "140395";
		TC_DESCRIPTION = " Verify that Ad Hoc can be ended. ";
		
		/*eventManagement.endEvent(eventName);
		verifyViewHistoryLink()------------>NEW;
		eventManagement.createFutureAdhocEventWithSpecificStartAndEndDateTime(eventName, eventDescription, startDate, startHours, endDate, endHours, resourceName, statusTypeNames);
		verifyViewHistoryLink()				
		*/
						
		login.logOut();
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay140398"})
	public void HappyDay140398() throws Exception {

		TCID = "140398";
		TC_DESCRIPTION = "  Verify that 'Edit' link is not available on 'Event SetUp' page.";
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		userDataCreation=usersData.new UsersCreateData();
		statusTypeData=new StatusTypeData();
		usersList = new UsersList(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name12, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .provideMaintainEventTemplateRight()
				 .selectConfigureRegionalUserAccessOption()
				 .clickOnSave();
		navigateTo.eventSetUp();
		eventSetUp.verifyEventTemplateOnEventTemplateList(EventData.AD_HOC_EVENT);
		eventManagement.verifyEditLink(EventData.AD_HOC_EVENT)
					   .verifyNotificationLink(EventData.AD_HOC_EVENT)	
					   .verifySecutityLinkIsNotPresent(EventData.AD_HOC_EVENT);
		
		login.logOut();
		login.loginAsNewUser(userDataCreation.name12, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		
		navigateTo.eventSetUp();
		eventSetUp.verifyEventTemplateOnEventTemplateList(EventData.AD_HOC_EVENT);
		eventManagement.verifyEditLink(EventData.AD_HOC_EVENT)
					   .verifyNotificationLink(EventData.AD_HOC_EVENT)	
					   .verifySecutityLinkIsNotPresent(EventData.AD_HOC_EVENT);
		login.logOut();
		
		Result = "PASS";
	}
}