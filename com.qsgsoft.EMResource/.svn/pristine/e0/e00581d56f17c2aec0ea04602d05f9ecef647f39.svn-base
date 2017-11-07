package RequirementGroups.CreatingAndManagingEvents;

import java.util.ArrayList;

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
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.EventManagement;
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
import qaFramework.Configurations.Configuration_Mails;
import qaFramework.UserDefinedFunctions.Date_Time_settings;

public class EndMultiRegionEvent extends Configuration_Mails {
	
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
	UpdateStatus updateStatus;
	

	public EndMultiRegionEvent() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay133944"})
	public void HappyDay133944() throws Exception {

		TCID = "133944";
		TC_DESCRIPTION ="Verify that a never ending multi-region event can be edited to end on a certain date at a specified time";

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
		String applicationTime = eventManagement.createNeverEndMultiRegionEvent(eventDataCreation.name15, eventDataCreation.description3,regionNames, eventTemplateNames);
		eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.name15, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.description3, applicationTime, EventData.NEVER_END)
	                   .verifyEventIconAndColour(EventSetUpData.RED_COLOUR_IN_EVENT_BANNER, EventData.AMBULANCE_ICON, eventDataCreation.name15);
	    String endDate = eventManagement.editEventSelectSpecificEndDateTime(eventDataCreation.name15, eventDataCreation.editname, EventData.FOUR_DAYS, EventData.FOUR_HOURS);
	    eventManagement.verifyEventDetails(eventDataCreation.editname, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.description3, applicationTime, endDate);
		login.logOut();
		Result = "PASS";
	}	

	
	@Test(groups = {"HappyDay","Creating and managing events", "HappyDay133943"})
	public void HappyDay133943() throws Exception {

		TCID ="133943";
		TC_DESCRIPTION = "Verify that a never ending multi-region event can be edited to end after certain number of hours.";

		/***
		 * DOES NOT DEPEND ON ANY TC
		 * LoginAsUserToRegion(UserWithCreateMRERight, MRE_Region1)
		 * createNeverEndingMRE(EventName, EventDescription, ET1, RG1Name, ET2, RG2Name)
		 * EditMREToEndAtDifferentTime(future time) say after 5 mins
		 * EndTime = getEventEndTime
		 * verifyEventEndTime(future time)
		 */

		usersData = new UsersData();
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		regionList = new RegionList(this.driver);
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region, eventSetupData.Multi_Region_Event_Template4_With_Notification_In_Region1};
	    String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		String applicationTime = eventManagement.createNeverEndMultiRegionEvent(eventDataCreation.name17, eventDataCreation.description3,regionNames, eventTemplateNames);
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name17, eventDataCreation.description3);
		eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.name17, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region, eventDataCreation.description3, applicationTime, EventData.NEVER_END)
	                   .verifyEventIconAndColour(EventSetUpData.GREEN_COLOUR_IN_EVENT_BANNER, EventData.DOCTOR_ICON, eventDataCreation.name17);
	    String endDate = eventManagement.editEventSelectSpecificHoursOfAnEvent(eventDataCreation.name17, eventDataCreation.editname, EventData.FIVE_HOUR, applicationTime, EventData.FIVE_HOURS);
	    String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.editname;
	    eventManagement.verifyWebNotificationAndClickOnAcknowledge(updateEventName, eventDataCreation.description3);
	    eventManagement.verifyEventDetails(eventDataCreation.editname, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region, eventDataCreation.description3, applicationTime, endDate);
	    login.logOut();

		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Creating and managing events", "HappyDay133942"})
	public void HappyDay133942() throws Exception {

		TCID ="133942";
		TC_DESCRIPTION = "Edit multi-region event and change the end time and verify that the event ends at the newly provided time.";

		/***
		 * DEPENDS ON HappyDay133943
		 * waitForSpecifiedTime(number of mins) say 5 mins as in prev TC
		 * verifyEventStatusAsEnded(EndTime)
		 */
		
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
		String[] applicationTime = eventManagement.createMultiregionEvent(eventDataCreation.name13, eventDataCreation.description3, regionNames, eventTemplateNames, EventData.TWENTYFOUR_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.name13, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.description3, applicationTime[0], applicationTime[1])
	                   .verifyEventIconAndColour(EventSetUpData.RED_COLOUR_IN_EVENT_BANNER, EventData.AMBULANCE_ICON, eventDataCreation.name13);
	    String endDate = eventManagement.editEventSelectSpecificEndDateTime(eventDataCreation.name13, eventDataCreation.editname, EventData.FOUR_DAYS, EventData.FOUR_HOURS);
	    eventManagement.verifyEventDetails(eventDataCreation.editname, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.description3, applicationTime[0], endDate);
		login.logOut();

		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay164144"})
	public void HappyDay164144() throws Exception {

		TCID = "164144";
		TC_DESCRIPTION ="Verify that ending multi-region event in a region ends the event in other regions as well. ";

		usersData = new UsersData();
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		regionList = new RegionList(this.driver);
		mails = new Mails(this.driver1);
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region, eventSetupData.Multi_Region_Event_Template4_With_Notification_In_Region1, eventSetupData.eventTemplate2WithNotificationInMutualAidRegion3};
	    String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2, RegionData.REGION_WITH_MUTUAL_AGREEMENT3};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		String applicationTime = eventManagement.createNeverEndMultiRegionEvent(eventDataCreation.name19, eventDataCreation.description3,regionNames, eventTemplateNames);
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name19, eventDataCreation.description3);
		eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.name19, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region, eventDataCreation.description3, applicationTime, EventData.NEVER_END)
                       .verifyEventIconAndColour(EventSetUpData.GREEN_COLOUR_IN_EVENT_BANNER, EventData.DOCTOR_ICON, eventDataCreation.name19);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.eventManagment();
		eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.name19, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template4_With_Notification_In_Region1, eventDataCreation.description3, applicationTime, EventData.NEVER_END)
		               .verifyEventIconAndColour(EventSetUpData.AMBER_COLOUR_IN_EVENT_BANNER, EventData.ENVELOPE_ICON, eventDataCreation.name19);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT3);
		navigateTo.eventManagment();
		eventManagement.verifyEventDetailsWithNeverEnd(eventDataCreation.name19, EventData.ONGOING_STATUS, eventSetupData.eventTemplate2WithNotificationInMutualAidRegion3, eventDataCreation.description3, applicationTime, EventData.NEVER_END)
		               .verifyEventIconAndColour(EventSetUpData.BLUE_COLOUR_IN_EVENT_BANNER, EventData.VOLCANO_ICON, eventDataCreation.name19);
		String endedEventName = eventDataCreation.endedEvent + eventDataCreation.name19;
		
		eventManagement.endEvent(eventDataCreation.name19)		
	                   .verifyEndedEventWebNotification(eventDataCreation.name19, endedEventName,eventDataCreation.endedEventDescription);

	    String webNotificationDateAndTime = eventManagement.getTimeInWebNotification();

	    eventManagement.clickOnAcknowledgeAllNotifications();
		login.switchToDefaultWindow();
		login.selectFrame();
	
	    navigateTo.eventManagment();
	    eventManagement.verifyEventAction(eventDataCreation.name19)
	                   .verifyEventStatus(eventDataCreation.name19, EventData.ENDED_STATUS)
	                   .verifyEventIsNotPresentInEventBanner(eventDataCreation.name19);
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
	    navigateTo.eventManagment();
	    eventManagement.verifyEventAction(eventDataCreation.name19)
	                   .verifyEventStatus(eventDataCreation.name19, EventData.ENDED_STATUS)
	                   .verifyEventIsNotPresentInEventBanner(eventDataCreation.name19);
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
	    navigateTo.eventManagment();
	    eventManagement.verifyEventAction(eventDataCreation.name19)
	                   .verifyEventStatus(eventDataCreation.name19, EventData.ENDED_STATUS)
	                   .verifyEventIsNotPresentInEventBanner(eventDataCreation.name19);
	
	    mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
	    mails.verifyMailAndPagerNotificationsForMultiRegionEventEnded(usersData.MultiRegionEventUserFullName, eventDataCreation.name19, RegionData.REGION_NAME_2, RegionData.REGION_WITH_MUTUAL_AGREEMENT3, RegionData.REGIONNAME,webNotificationDateAndTime)
		     .logoutMail();
		
		login.logOut();
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay133948"})
	public void HappyDay133948() throws Exception {

		TCID = "133948";
		TC_DESCRIPTION ="Verify that multi-region event starts and ends at the newly provided date "
				+ "and time before the previously provided event start and end date/time for a future multi-region event.";

		login = new Login(this.driver);
		usersData = new UsersData();
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		regionData = new RegionData();
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
	    String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
	    eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
	    ArrayList<String> dates = eventManagement.createMultiregionWithFutureDateAndTime(eventDataCreation.name18, eventDataCreation.description4, EventData.FIFTEEN_DAYS,EventData.ONE_HOUR, EventData.THIRTYTWO_DAYS, EventData.ONE_HOUR, regionNames,eventTemplateNames);
		eventManagement.verifyEventDetails(eventDataCreation.name18, EventData.FUTURE_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.description4, dates.get(0), dates.get(0));
		ArrayList<String> dates1 = eventManagement.editEventWithMandatoryData(eventDataCreation.name18, eventDataCreation.editname1, eventDataCreation.editdescription1, EventData.ONE_DAY, EventData.ONE_HOUR, EventData.FOUR_DAYS, EventData.TWO_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.editname1, EventData.FUTURE_STATUS,  eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.editdescription1, dates1.get(1), dates1.get(1));
		login.logOut();
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay133946"})
	public void HappyDay133946() throws Exception {

		TCID = "133946";
		TC_DESCRIPTION ="Verify that multi-region event ends at the newly spcified End date and time when event end date is "
				+ "edited to a time later than the previously provided end date and time.";

		login = new Login(this.driver);
		usersData = new UsersData();
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		regionData = new RegionData();
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
	    String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
	    eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
	    ArrayList<String> dates = eventManagement.createMultiregionWithFutureDateAndTime(eventDataCreation.name18, eventDataCreation.description4, EventData.FIVE_DAYS,EventData.ONE_HOUR, EventData.FIVE_DAYS, EventData.TWO_HOURS, regionNames,eventTemplateNames);
		eventManagement.verifyEventDetails(eventDataCreation.name18, EventData.FUTURE_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.description4, dates.get(0), dates.get(0));
		ArrayList<String> dates1 = eventManagement.editEventWithMandatoryData(eventDataCreation.name18, eventDataCreation.editname1, eventDataCreation.editdescription1, EventData.FIVE_DAYS, EventData.ONE_HOUR, EventData.FIFTEEN_DAYS, EventData.FIVE_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.editname1, EventData.FUTURE_STATUS,  eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.editdescription1, dates1.get(1), dates1.get(1));
		login.logOut();
		Result = "PASS";
	}	
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay133945"})
	public void HappyDay133945() throws Exception {

		TCID = "133945";
		TC_DESCRIPTION ="Verify that multi-region event ends at the newly spcified End date"
				+ "and time when event end date is edited to a time later than the previously provided end date and time.";
		
		login = new Login(this.driver);
		usersData = new UsersData();
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		regionData = new RegionData();
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
	    String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
	    eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
	    ArrayList<String> dates = eventManagement.createMultiregionWithFutureDateAndTime(eventDataCreation.name23, eventDataCreation.description1, EventData.FIVE_DAYS,EventData.ONE_HOUR, EventData.FIFTEEN_DAYS, EventData.FIVE_HOURS, regionNames,eventTemplateNames);
		eventManagement.verifyEventDetails(eventDataCreation.name23, EventData.FUTURE_STATUS, eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.description1, dates.get(0), dates.get(0));
		ArrayList<String> dates1 = eventManagement.editEventWithMandatoryData(eventDataCreation.name23, eventDataCreation.editname1, eventDataCreation.editdescription1, EventData.FIVE_DAYS, EventData.ONE_HOUR, EventData.FIVE_DAYS, EventData.TWO_HOURS);
		eventManagement.verifyEventDetails(eventDataCreation.editname1, EventData.FUTURE_STATUS,  eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventDataCreation.editdescription1, dates1.get(1), dates1.get(1));
		login.logOut();
		Result = "PASS";
	}	
}
