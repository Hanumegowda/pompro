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

public class EditMultiRegionEvent extends Configuration_Mails{
	
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
	


	public EditMultiRegionEvent() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay164139"})
	public void HappyDay164139() throws Exception {

		TCID = "164139";
		TC_DESCRIPTION ="Verify that user receives event update notifications when a region is added or removed from multi-region event.";

		/****
		 * Login as user 'U1' to region 'RG1'(Z_NewSmokeSuite_Region)
		 * Navigate to event >>Event Management
		 * Create Multi Region Event 
		 * Verify the event details on event management screen 
		 * Navigate to event >>Event Management
		 * Click edit link associated with the 'MRE' and deselect the 'Event template' of RG1(Z_NewSmokeSuite_Region)
		 * Verify User 'U1' receives the notification
		 * Navigate to event >>Event Management
		 * Click edit link associated with the 'MRE' and select the 'Event template' of RG1 (Z_NewSmokeSuite_Region) 
		 * Verify User 'U1' receives the notification
		 */

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region,eventSetupData.Multi_Region_Event_Template4_With_Notification_In_Region1};
		String eventTemplateNames1[] = {EventData.NOT_PARTICIPATING_REGION};
		String eventTemplateNames2[] = {eventSetupData.Multi_Region_Event_Template4_With_Notification_In_Region1};
		String regionNames[] ={RegionData.REGIONNAME,RegionData.REGION_NAME_2};
		String regionNames1[] ={RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		String[] dates = eventManagement.createMultiregionEvent(eventDataCreation.name14, eventDataCreation.description4, regionNames, eventTemplateNames, EventData.TWENTYFOUR_HOURS);
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name14, eventDataCreation.description4)
		.verifyEventDetails(eventDataCreation.name14,EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region, eventDataCreation.description4, dates[0], dates[1]);
		String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.name14;
		eventManagement.editEventAndUpdateTemplate(eventDataCreation.name14, regionNames1,eventTemplateNames1 ,updateEventName, eventDataCreation.description4);
		String updateEventName1= eventDataCreation.updatedEventName1 + eventDataCreation.name14;
		eventManagement.editEventAndUpdateTemplateSecondTime(eventDataCreation.name14, regionNames1,eventTemplateNames2 ,updateEventName1, eventDataCreation.description4);
		
		Result = "PASS";
	}
		
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay164140"})
	public void HappyDay164140() throws Exception {

		TCID = "164140";
		TC_DESCRIPTION ="Verify that user with appropriate right can edit a multi region event and add participating regions to it.";

		/****
		 *Login as user 'U1' to region 'RG1'(Z_NewSmokeSuite_Region)
		 *Navigate to event >>Event Management
		 *Create multi region event  
		 *Verify the event details on event management screen 
		 *Navigate to event >>Event Management
		 *click edit link associated with the 'MRE' and select the 'Event template' of RG1 (Z_NewSmokeSuite_Region)
		 *Verify User 'U1' receives the notification  
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
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region,eventSetupData.Multi_Region_Event_Template4_With_Notification_In_Region1 };
		String regionNames[] = {RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		String eventTemplateNames1[] = { EventData.NOT_PARTICIPATING_REGION, eventSetupData.Multi_Region_Event_Template4_With_Notification_In_Region1 };
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		String[] dates = eventManagement.createMultiregionEvent(eventDataCreation.name16, eventDataCreation.description4, regionNames, eventTemplateNames, EventData.TWENTYFOUR_HOURS);
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name16, eventDataCreation.description4)
		.verifyEventDetails(eventDataCreation.name16,EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region, eventDataCreation.description4, dates[0], dates[1]);
		String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.name16;
		eventManagement.editEventAndUpdateTemplate(eventDataCreation.name16, regionNames,eventTemplateNames1 ,updateEventName, eventDataCreation.description4);
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay164141"})
	public void HappyDay164141() throws Exception {

		TCID = "164141";
		TC_DESCRIPTION ="Verify that user with appropriate right can edit a multi region event and remove template from region to --Not Participating--.";

		/****
		 * Login as user 'U1' to region 'RG1'(Z_NewSmokeSuite_Region)
		 * Navigate to event >>Event Management
		 * Create multi region event
		 * Verify the event details on event management screen
		 * Navigate to event >>Event Management
		 * click edit link associated with the Event 
		 * remove template from region to --Not Participating--. 
		 * Verify User 'U1' receives the notification
		 */
		

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		mails = new Mails(this.driver1);
		
		eventData = new EventData();
		eventDataCreation =eventData.new EventCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		regionData = new RegionData();
		eventSetupData = new EventSetUpData();
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region, eventSetupData.Multi_Region_Event_Template4_With_Notification_In_Region1};
		String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		String eventTemplateName1[] = {EventData.NOT_PARTICIPATING_REGION};
		String regionName1[] ={RegionData.REGIONNAME};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		String[] dates = eventManagement.createMultiregionEvent(eventDataCreation.name11, eventDataCreation.description1, regionNames, eventTemplateNames, EventData.TWENTYFOUR_HOURS);
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name11, eventDataCreation.description1)
		               .verifyEventIconAndColour(EventSetUpData.GREEN_COLOUR_IN_EVENT_BANNER, EventData.DOCTOR_ICON, eventDataCreation.name11)
		               .verifyEventDetails(eventDataCreation.name11, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region, eventDataCreation.description1, dates[0], dates[1]);
		navigateTo.eventManagment();
		String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.name11;
		String endDate = eventManagement.editEventAndDeselectTemplateWithApplicationTime(eventDataCreation.name11, regionName1, eventTemplateName1,updateEventName, eventDataCreation.description1, EventData.ONE_MINUTE);
		eventManagement.verifyDisplayInEventBannerNotPresent(updateEventName);
		
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForAnEventNoLongerParticipatingInRegion(usersData.MultiRegionEventUserFullName, RegionData.REGIONNAME, RegionData.REGION_NAME_2, eventDataCreation.description1, endDate, updateEventName)
		     .logoutMail();
		
		login.logOut();
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay164142"})
	public void HappyDay164142() throws Exception {

		TCID = "164142";
		TC_DESCRIPTION ="Verify that event banner of multi region event is not displayed in the region in which it is no longer participating.";

		/****
		 * Login as user 'MultiRegionEventUser' to region 'RG1(Z_NewSmokeSuite_Region)
		 * Navigate to event >>Event Management
		 * Create multi region event 
		 * Verify the event details on event management screen
		 * Click edit link associated with the Event and deselect the 'Event template' of RG1 (Z_NewSmokeSuite_Region)
		 * Verify User 'U1' receives the notification and event banner is not displayed in region 'RG1'(Z_NewSmokeSuite_Region) 
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
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region, eventSetupData.Multi_Region_Event_Template4_With_Notification_In_Region1};
		String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		String eventTemplateName1[] = {EventData.NOT_PARTICIPATING_REGION};
		String regionName1[] ={RegionData.REGIONNAME};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
		String[] dates = eventManagement.createMultiregionEvent(eventDataCreation.name9, eventDataCreation.description1, regionNames, eventTemplateNames, EventData.TWENTYFOUR_HOURS);
		eventManagement.verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name9, eventDataCreation.description1)
		               .verifyEventIconAndColour(EventSetUpData.GREEN_COLOUR_IN_EVENT_BANNER, EventData.DOCTOR_ICON, eventDataCreation.name9);
		eventManagement.verifyEventDetails(eventDataCreation.name9, EventData.ONGOING_STATUS, eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region, eventDataCreation.description1, dates[0], dates[1]);
		navigateTo.eventManagment();
		String updateEventName = eventDataCreation.updatedEventName + eventDataCreation.name9;
		eventManagement.editEventAndUpdateTemplate(eventDataCreation.name9, regionName1, eventTemplateName1,updateEventName, eventDataCreation.description1)
		               .verifyDisplayInEventBannerNotPresent(updateEventName);
		login.logOut();
		
		Result = "PASS";
	}
		
	@Test(groups = {"HappyDay","Creating and managing events", "HappyDay164143"})
	public void HappyDay164143() throws Exception {

		TCID ="164143";
		TC_DESCRIPTION = "Verify that event banner of multi region event is not displayed in the region in which it is no longer participating.";

		/***
		 * DOES NOT DEPEND ON ANY TC
		 * CreateFutureMRE(EventName_1, EventDesc_1, RG1, ET1, RG2, ET2, Start after 5 mins)
		 * EditMandatoryDataOfEvent(Edit_EventName_1, Edit_EventDesc_1)
		 * WaitFor5Mins
		 * verifyEventAsOngoing(Edit_EventName_1)
		 * verifyWebNotification(Edit_EventName_1)
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
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region, eventSetupData.Multi_Region_Event_Template4_With_Notification_In_Region1};
	    String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
	    eventManagement.verifyAllFieldsInCreateEventsScreen(regionNames);
	    ArrayList<String> dates = eventManagement.createMultiregionWithFutureDateAndTime(eventDataCreation.name18, eventDataCreation.description4, EventData.FIVE_DAYS,EventData.ONE_HOUR, EventData.THIRTYTWO_DAYS, EventData.FIVE_HOURS, regionNames,eventTemplateNames);
	    eventManagement.verifyEventDetails(eventDataCreation.name18, EventData.FUTURE_STATUS, eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region,eventDataCreation.description4,  dates.get(0), dates.get(0));
	    ArrayList<String> dates1 = eventManagement.editEventWithMandatoryData(eventDataCreation.name18, eventDataCreation.editname1, eventDataCreation.editdescription1, EventData.ONE_DAY, EventData.ONE_HOUR, EventData.FIFTEEN_DAYS, EventData.TWO_HOURS);
	    eventManagement.verifyEventDetails(eventDataCreation.editname1, EventData.FUTURE_STATUS,  eventSetupData.Multi_Region_Event_Template2_With_Notification_In_Region, eventDataCreation.editdescription1, dates1.get(1), dates1.get(1));
		eventManagement.verifyEventIsNotPresentInEventBanner(eventDataCreation.editname1);
		
		login.logOut();
		Result = "PASS";
	}
}
