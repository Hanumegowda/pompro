package RequirementGroups.CreatingAndManagingEvents;

import java.util.ArrayList;

import org.testng.annotations.Test;

import EMR.data.EventData;
import EMR.data.EventSetUpData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.ViewData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.StatusTypeData;
import EMR.data.EventData.EventCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UpdateStatusData;
import EMR.data.UpdateStatusData.UpdateStatusCreateData;
import EMR.data.UsersData;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.Mails;
import EMR.pages.OtherRegionList;
import EMR.pages.RegionDefault;
import EMR.pages.RegionList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.UpdateStatus;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewsUnderSetup;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData.ViewCreateData;
import qaFramework.Configurations.Configuration_Mails;
import qaFramework.UserDefinedFunctions.Date_Time_settings;

public class MultiRegionEvent extends Configuration_Mails{
	
	EventSetUpData eventSetupData;
	EventCreateData eventDataCreation;
	EventData eventData;
	ResourceData resourceData;
	ResourceCreateData resourceCreateData;
	UsersData usersData;
	RegionData regionData;
	SelectRegion selectRegion;
	ResourceTypeData resourceTypeData;
	StatusTypeData statusTypeData;
	
	RegionList regionList;
	Date_Time_settings dts;
	Login login;
	Shared navigateTo;
	EventManagement eventManagement;
	ResourceTypeCreateData resourceTypeDataCreation;
	Mails mails;
	View view;
	UsersList usersList;
	UsersCreateData userDataCreation;
	LoginData loginData;
	RegionDefault regionDefault;
	OtherRegionList otherRegionList;
	EventSetUp eventSetUp;
	UpdateStatus updateStatus;
	UpdateStatusData updateStatusData;
	UpdateStatusCreateData updateStatusCreateData;
	StatusTypeCreateData statusTypeDataCreation;
	ViewsUnderSetup viewsUnderSetup;
	ViewCreateData viewsDataCreation;
	ViewData viewData;

	public MultiRegionEvent() throws Exception {
		super();
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay139575"})
	public void HappyDay139575() throws Exception {

		TCID = "139575";
		TC_DESCRIPTION = "Verify that when a MRE is created to start immediately and end after a specific time period (say, 5 hrs), the event starts immediately and ends after the specified number of hours.";

		usersData = new UsersData();
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		regionList = new RegionList(this.driver);
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1, eventSetupData.eventTemplate1WithoutNotificationInMutualAidRegion3};
	    String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2, RegionData.REGION_WITH_MUTUAL_AGREEMENT3};
		
	    login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
	    eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
	    String[] dates = eventManagement.createMultiRegionEventWithEndAtSpecificDate(eventDataCreation.name, eventDataCreation.description, EventData.FIVE_HOUR, regionNames, eventTemplateNames, EventData.FIVE_HOURS);
	    eventManagement.verifyEventDetails(eventDataCreation.name, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.description, dates[0], dates[1])
	    .verifyEventIconAndColour(EventSetUpData.RED_COLOUR_IN_EVENT_BANNER, EventData.AMBULANCE_ICON, eventDataCreation.name);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.eventManagment();
		eventManagement.verifyEventDetails(eventDataCreation.name, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1, eventDataCreation.description, dates[0], dates[1])
		.verifyEventIconAndColour(EventSetUpData.PURPLE_COLOUR_IN_EVENT_BANNER, EventData.CHEMICAL_ICON, eventDataCreation.name);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT3);
		navigateTo.eventManagment();
		eventManagement.verifyEventDetails(eventDataCreation.name, EventData.ONGOING_STATUS, eventSetupData.eventTemplate1WithoutNotificationInMutualAidRegion3, eventDataCreation.description, dates[0], dates[1])
		.verifyEventIconAndColour(EventSetUpData.SILVER_COLOUR_IN_EVENT_BANNER, EventData.LANDSLIDE_ICON, eventDataCreation.name);
		login.logOut();
		
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay139693"})
	public void HappyDay139693() throws Exception {

		TCID = "139693";
		TC_DESCRIPTION = "Verify that multi-region event can be modified by clicking on 'Modify' button on 'Multi-Region Event Confirmation' page";

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
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
		String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		ArrayList<String> dates = eventManagement.createAndModifyMultiregionEventWithFutureStartAndEndDate(eventDataCreation.name1, eventDataCreation.description1,EventData.ONE_DAY,EventData.ONE_HOUR, EventData.THIRTYTWO_DAYS, EventData.FIVE_HOURS, regionNames,eventTemplateNames,EventData.FIVE_DAYS,EventData.ONE_HOUR);
		eventManagement.verifyEventDetails(eventDataCreation.name1, EventData.FUTURE_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region,eventDataCreation.description1,  dates.get(0), dates.get(2));
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.eventManagment();
		eventManagement.verifyEventDetails(eventDataCreation.name1, EventData.FUTURE_STATUS, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1,eventDataCreation.description1, dates.get(0), dates.get(2));
		
		login.logOut();
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay139086"})
	public void HappyDay139086() throws Exception {

		TCID = "139086";
		TC_DESCRIPTION = " Verify that when a MRE is created to start immediately and end after a specific date & time (say, 5:00 PM on date X+1, where X is the current date), the event starts immediately and ends at the specified time on the date set (5:00 PM on date X+1)";

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
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
	    String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
	    eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		String[] dates = eventManagement.createMultiRegionEventWithEndAtSpecificDate(eventDataCreation.name4, eventDataCreation.description4, EventData.ONEDAY, regionNames, eventTemplateNames, EventData.FIVE_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.name4, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region,  eventDataCreation.description4, dates[0], dates[1])
		.verifyEventIconAndColour(EventSetUpData.RED_COLOUR_IN_EVENT_BANNER, EventData.AMBULANCE_ICON, eventDataCreation.name4);
		 
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.eventManagment();
		eventManagement.verifyEventDetails(eventDataCreation.name4, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1,  eventDataCreation.description4, dates[0], dates[1])
		 .verifyEventIconAndColour(EventSetUpData.PURPLE_COLOUR_IN_EVENT_BANNER, EventData.CHEMICAL_ICON, eventDataCreation.name4);
		
		login.logOut();
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay139480"})
	public void HappyDay139480() throws Exception {

		TCID = "139480";
		TC_DESCRIPTION = " Verify that the MRE starts immediately and does not display the end date when a MRE is created selecting to start immediately and to end never.";

		usersData = new UsersData();
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		regionList = new RegionList(this.driver);
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
	    String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		String applicationTime = eventManagement.createNeverEndMultiRegionEvent(eventDataCreation.name3, eventDataCreation.description3,regionNames, eventTemplateNames);
	    eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.name3, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.description3, applicationTime, EventData.NEVER_END)
	    .verifyEventIconAndColour(EventSetUpData.RED_COLOUR_IN_EVENT_BANNER, EventData.AMBULANCE_ICON, eventDataCreation.name3);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.eventManagment();
		eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.name3, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1, eventDataCreation.description3, applicationTime, EventData.NEVER_END)
		.verifyEventIconAndColour(EventSetUpData.PURPLE_COLOUR_IN_EVENT_BANNER, EventData.CHEMICAL_ICON, eventDataCreation.name3);
		login.logOut();
		
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay139563"})
	public void HappyDay139563() throws Exception {

		TCID = "139563";
		TC_DESCRIPTION = "Verify that a MRE can be created selecting to start the event at specified date (say, 4:00 PM & day as x+1 where x is current date) and end after 4 hours";

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
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
		String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		String startDate = eventManagement.createMultiregionEventWithSpecificStartAndEndDateTime(eventDataCreation.name5, eventDataCreation.description1, EventData.ONE_DAY, EventData.ONE_HOUR, EventData.FOUR_HOUR, regionNames, eventTemplateNames);
		String endDate = eventManagement.addTimeToExistingTime(startDate, EventData.FOUR_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.name5, EventData.FUTURE_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region,eventDataCreation.description1, startDate, endDate)
		               .verifyEventIcon(eventDataCreation.name5, EventData.AMBULANCE_ICON);
		
		selectRegion.clickRegion()
		.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.eventManagment();
		eventManagement.verifyEventDetails(eventDataCreation.name5, EventData.FUTURE_STATUS, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1,eventDataCreation.description1, startDate, endDate)
		               .verifyEventIcon(eventDataCreation.name5, EventData.CHEMICAL_ICON);
		login.logOut();
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay139566"})
	public void HappyDay139566() throws Exception {

		TCID = "139566";
		TC_DESCRIPTION = "Verify that a MRE can be created selecting to start & end the event at specified date & time (Start say, 4:00 PM & day as x+1 & end at 3:00 PM and day as x+2 where x is current date )";

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
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
	    String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
	    ArrayList<String> dates = eventManagement.createMultiregionEventWithFutureStartAndEndDate(eventDataCreation.name7, eventDataCreation.description1, EventData.ONE_DAY, EventData.FIVE_HOURS, EventData.TWO_DAYS, EventData.TWO_HOURS, regionNames, eventTemplateNames);
		eventManagement.verifyEventDetails(eventDataCreation.name7, EventData.FUTURE_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region,  eventDataCreation.description1, dates.get(0), dates.get(1));
		 
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.eventManagment();
		eventManagement.verifyEventDetails(eventDataCreation.name7, EventData.FUTURE_STATUS, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1,  eventDataCreation.description1, dates.get(0), dates.get(1));
		login.logOut();
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay139566"})
	public void HappyDay139573() throws Exception {

		TCID = "139573";
		TC_DESCRIPTION = " Verify that a MRE can be created selecting to start the event at specified date & time (say, 4:00 PM & day as x+1 where x is current date) and to end never";

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
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
		String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		ArrayList<String> dates = eventManagement.createMultiRegionEventWithStartAtSpecificDateAndNeverEnds(eventDataCreation.name6, eventDataCreation.description4, EventData.ONE_DAY, EventData.ONE_HOUR, regionNames, eventTemplateNames);
		eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.name6, EventData.FUTURE_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.description4, dates.get(0), EventData.NEVER_END)
		               .verifyEventIcon(eventDataCreation.name6, EventData.AMBULANCE_ICON);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.eventManagment();
		eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.name6, EventData.FUTURE_STATUS, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1, eventDataCreation.description4, dates.get(0), EventData.NEVER_END)
		               .verifyEventIcon(eventDataCreation.name6, EventData.CHEMICAL_ICON);
		login.logOut();
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay139594"})
	public void HappyDay139594() throws Exception {

		TCID = "139594";
		TC_DESCRIPTION = "Verify that multi-region event can be created by deselecting the option 'Display in Event Banner'.";

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
		String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		String[] dates = eventManagement.createMultiRegionEventWithEndAtSpecificDateAndDeselectDisplayEventBanner(eventDataCreation.name8, eventDataCreation.description4, EventData.FIVE_HOUR, regionNames, eventTemplateNames, EventData.FIVE_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.name8, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.description4, dates[0], dates[1])
		               .verifyDisplayInEventBannerNotPresent(eventDataCreation.name8);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.eventManagment();
		eventManagement.verifyEventDetails(eventDataCreation.name8, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1, eventDataCreation.description4, dates[0], dates[1])
		               .verifyDisplayInEventBannerNotPresent(eventDataCreation.name8);
		login.logOut();
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay139634"})
	public void HappyDay139634() throws Exception {

		TCID = "139634";
		TC_DESCRIPTION = "Verify that multi-region event can be created selecting a event template in which 'Mandatory address' check box is selected.";

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		mails = new Mails(this.driver1);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template_With_Address +EventData.ADDRESS_REQUIRED ,eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
		String regionNames[] ={RegionData.REGIONNAME,RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		String[] dates = eventManagement.createMultiregionEventWithMandatoryAddress(eventDataCreation.name10, eventDataCreation.description4,EventData.CITY, EventData.STATE, EventData.ZIP_CODE, EventData.COUNTY, regionNames, eventTemplateNames,EventData.TWENTYFOUR_HOURS);
		System.out.println();	
		eventManagement.verifyEventDetails(eventDataCreation.name10, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template_With_Address, eventDataCreation.description4, dates[0], dates[1])
		               .verifyWebNotificationWithAddressAndClickOnAcknowledge(eventDataCreation.name10, eventDataCreation.description4,EventData.CITY,  EventData.COUNTY, EventData.ZIP_CODE, EventData.HAWAII_STATE);
		
		login.logOut();
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForEventWithAddress(eventDataCreation.description4, EventData.CITY, EventData.HAWAII_STATE, EventData.ZIP_CODE, EventData.COUNTY, usersData.MultiRegionEventUserFullName,RegionData.REGION_NAME_2, RegionData.REGIONNAME, eventDataCreation.name10);
		mails.logoutMail();
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay139645"})
	public void HappyDay139645() throws Exception {

		TCID = "139645";
		TC_DESCRIPTION = "Verify that all the resources under the selected event template while creating a multi-region are added to the multi-region event when 'Include all resources?' checkbox is selected.";

		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
	    resourceTypeData = new ResourceTypeData();
	    statusTypeData = new StatusTypeData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
	    view = new View(this.driver);
		
		String resourceName = resourceData.resource_Name1_In_Region,
				resourceName1 = resourceData.resource_Name1_In_Region1,
				resourceType = resourceTypeData.RT_Name_In_Region,
				resourceType1= resourceTypeData.RT_Name_In_Region1;
		String[] statusTypes = {statusTypeData.Role_DST_In_Region};
		String[] statusTypes1 =	{statusTypeData.Role_DST_In_Region1};	
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
		String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		String[] dates = eventManagement.createMultiregionEvent(eventDataCreation.name12, eventDataCreation.description4, regionNames, eventTemplateNames, EventData.TWENTYFOUR_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.name12, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.description4, dates[0], dates[1])
		.navigateToEventStatusFromEventBanner(eventDataCreation.name12);
		view.verifyResourceTypeResourceAndStatusType(resourceType, resourceName, statusTypes);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.eventManagment();
		eventManagement.verifyEventDetails(eventDataCreation.name12, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1, eventDataCreation.description4, dates[0], dates[1])
		               .navigateToEventStatusFromEventBanner(eventDataCreation.name12);
		view.verifyResourceTypeResourceAndStatusType(resourceType1, resourceName1, statusTypes1);
		login.logOut();
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay139647"})
	public void HappyDay139647() throws Exception {

		TCID = "139647";
		TC_DESCRIPTION = "Verify that resources are not included in the multi-region event created when 'Include all resources?' check box is deselected.";

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		view = new View(this.driver);
		
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
	    resourceTypeData = new ResourceTypeData();
	    statusTypeData = new StatusTypeData();
	    
	    login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		
		String resourceName = resourceData.resource_Name1_In_Region,
				resourceName1 = resourceData.resource_Name1_In_Region1,
				resourceType = resourceTypeData.RT_Name_In_Region,
				resourceType1= resourceTypeData.RT_Name_In_Region1;
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
		String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		String[] dates = eventManagement.createMultiregionEventBydeselectingResource(eventDataCreation.name25, eventDataCreation.description4, regionNames, eventTemplateNames,EventData.TWENTYFOUR_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.name25, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.description4, dates[0], dates[1])	   
		               .navigateToEventStatusFromEventBanner(eventDataCreation.name25);
		view.verifyResourceTypeAndResource(resourceType, resourceName);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.eventManagment();
		eventManagement.verifyEventDetails(eventDataCreation.name25, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1, eventDataCreation.description4, dates[0], dates[1])	   
		 			   .navigateToEventStatusFromEventBanner(eventDataCreation.name25);
		view.verifyResourceTypeAndResource(resourceType1, resourceName1);
		login.logOut();
		Result = "PASS";
	}
	

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay139697"})
	public void HappyDay139697() throws Exception {

		TCID = "139697";
		TC_DESCRIPTION ="Verify that admin user cannot Create/Edit 'Multi Region' event"; 

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		usersData = new UsersData();
		regionData = new RegionData();
		loginData = new LoginData();
		
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.clickOnEvents();
		eventManagement.verifyEventManagementLinkNotPresent();
		login.logOut();
		
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay164135"})
	public void HappyDay164135() throws Exception {

		TCID = "164135";
		TC_DESCRIPTION ="Verify that user with appropriate right is able to view 'Event Status'"
				+ " by clicking on event icon displayed corresponding to the resource on tabular views (Region Views, Custom Views, Other Region Views).";

		/****
		 * Create a user 'U1' with 'View - Custom View' right[function already exists]
		 * Login as user 'U1' to region 'RG1 (Z_NewSmokeSuite_Region)[function already exists]
		 * create a custom view [function already exists]
		 * Navigate to event >>Event Management [function already exists "eventManagment"]
		 * Create Multi Region Event[function already exists "createMultiregionEvent"]
		 * Verify the event details on event management screen [function already exists "verifyEventDetails"]
		 * Navigate to view [function already exists]
		 * Click event icon associated with the resource [need to write function]
		 * Verify 'Event Status' screen
		 * Navigate to custom view  [function already exists]
		 * Click event icon associated with the resource [need to write function]
		 * Verify 'Event Status' screen
		 * Navigate to other region view[need to write function]
		 * Click event icon associated with the resource [need to write function]
		 * Verify 'Event Status' screen
		 */
		
		Result = "PASS";
	}

	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay68595", "EMResource Base"})
	public void HappyDay68595() throws Exception {

		TCID = "68595";
		TC_DESCRIPTION ="Verify that resources can be added to a multi region event.";
	
//		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
//		navigateTo.eventManagment();
//		/*eventManagement.createMultiregionEventBydeselectingResource(eventName, eventDescription, regionName, eventTemplateName, hour)
//		               .verifyEventDetails()	  
//		               .clickOnEventBanner(eventName)
//		               .verifyErrorMessage()*/
//		navigateTo.eventManagment();
//		eventManagement.editMultiRegionEventAndSelectResource()------->NEW
//									this.verifyEventManagementPage();
//									this.clickEditLink(eventName);
//									this.verifyEditMultiregionEventPage();
//									this.clickOnNext();
//									this.verifySelectResourcesPageIsDisplayed();
//									this.selectResource(resourceName);
//									this.clickOnNext();
//									this.clickOnNext();
//									this.clickYes();
//		String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.name;
//		eventManagement.clickOnEventBanner(updateEventName)	
//		               .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(eventName, resourceTypeName, statusTypeNames, resourceName);
//		
//		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
//		navigateTo.eventManagment();
//		eventManagement.clickOnEventBanner(eventName)
//                       .verifyErrorMessage()
//		eventManagement.editMultiRegionEventSelectResource()------->NEW
//									this.verifyEventManagementPage();
//									this.clickEditLink(eventName);
//									this.verifyEditMultiregionEventPage();
//									this.clickOnNext();
//									this.clickOnNext();
//									this.verifySelectResourcesPageIsDisplayed();
//									this.selectResource(resourceName);
//									this.clickOnNext();
//									this.clickYes();
//		String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.name;
//		eventManagement.clickOnEventBanner(updateEventName)	
//					   .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(eventName, resourceTypeName, statusTypeNames, resourceName);
//	login.logOut();
//		
//		Result = "PASS";								
	}
}
