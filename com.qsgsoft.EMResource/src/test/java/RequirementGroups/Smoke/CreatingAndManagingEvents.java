package RequirementGroups.Smoke;

import EMR.data.EventData;
import EMR.data.EventSetUpData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.UsersData;
import EMR.data.ResourceData;
import EMR.pages.EventManagement;
import EMR.pages.Login;
import EMR.pages.Mails;
import EMR.pages.Shared;
import EMR.pages.RegionDefault;
import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration_Mails;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;
import EMR.data.EventData.EventCreateData;

public class CreatingAndManagingEvents extends Configuration_Mails {

	public CreatingAndManagingEvents() throws Exception {
		super();
	}

	LoginData loginData;
	EventData eventData;
	UsersData usersData;
	EventSetUpData eventSetUpData;
	ResourceData resourceData;

	Login login;
	RegionDefault regionDefault;
	Shared navigateTo;
	EventManagement event;
	Mails mails;
	EventCreateData eventDataCreation;
	ReadAndWriteFromXMLFile xml = new ReadAndWriteFromXMLFile();
	
	@Test(groups = {"Smoke", "Events", "Smoke185941"})
	public void Smoke185941() throws Exception {
		
		TCID = "185941";
	    TC_DESCRIPTION = "Verify that user with appropriate is able to create event and end created event";
	    
		event = new EventManagement(this.driver);
		mails = new Mails(this.driver1);
		regionDefault = new RegionDefault(this.driver);
		navigateTo = new Shared(this.driver);
		login= new Login(this.driver);
		
		loginData = new LoginData();
		eventData = new EventData();
		eventSetUpData = new EventSetUpData();
		eventDataCreation = eventData.new EventCreateData();
		resourceData = new ResourceData();
		usersData = new UsersData();
		
		login.loginAsUserAndAcknowledgeWebNotification(usersData.eventsUserName, UsersData.PASSWORD);
		regionDefault.verifyRegionName(RegionData.REGIONNAME); 
		navigateTo.eventManagment();
		
		event.createEvent(eventSetUpData.SmokeEventTemplate, eventDataCreation.name,
				eventDataCreation.description, resourceData.eventsResourceName)
			 .verifyEventNameIsDisplayed(eventDataCreation.name)
     		 .verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name, eventDataCreation.description);
		
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForAnEventCreated(
				usersData.eventsUserFullName, usersData.eventsUserFullName,
				RegionData.REGIONNAME, eventDataCreation.description, eventDataCreation.name)
			 .logoutMail();
		
		event.endEvent(eventDataCreation.name)
		     .verifyEndedEventWebNotification(eventDataCreation.name, eventDataCreation.endedEventName,eventDataCreation.endedEventDescription);

		String webNotificationDateAndTime = event.getTimeInWebNotification();
		
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		System.out.println(eventDataCreation.name);
		mails.verifyMailAndPagerNotificationsForAnEventEnded(usersData.eventsUserFullName, eventDataCreation.name, RegionData.REGIONNAME, webNotificationDateAndTime, UsersData.PRIMARY_EMAILID)
			 .logoutMail();
		
		Result = "PASS";
	}
}
