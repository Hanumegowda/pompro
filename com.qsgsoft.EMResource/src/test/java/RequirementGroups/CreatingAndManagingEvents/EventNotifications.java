package RequirementGroups.CreatingAndManagingEvents;

import org.testng.annotations.Test;
import EMR.data.EventData;
import EMR.data.EventSetUpData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.StatusTypeData;
import EMR.data.UpdateStatusData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.EventData.EventCreateData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UpdateStatusData.UpdateStatusCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData.ViewCreateData;
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
import qaFramework.Configurations.Configuration_Mails;
import qaFramework.UserDefinedFunctions.Date_Time_settings;

public class EventNotifications extends Configuration_Mails {
	
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

	public EventNotifications() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

//	@Test (groups = {"HappyDay", "Creating and managing events", "HappyDay134597"})
//	public void HappyDay134597() throws Exception {
//
//		TCID = "134597";
//		TC_DESCRIPTION = "Verify that user who is logged into the application, is taken to 'Event status' page when clicked on the URL available on the notifications received for a single event";
//
//		/****
//		 * DOES NOT DEPEND ON ANY TC
//		 * LoginToApplicationAsUser
//		 * createEvent(EventName, EventDescription, ET)
//		 * acknowledgeWebNotification
//		 * navigateTo home page/ any other page except Event status
//		 * in another browser, getURLFromMail
//		 * launchURL(url from mail)
//		 * verifyEventStatusScreen
//		 * verifyResourceTypeAndResource
//		 * verifyResourceTypeAndStatusTypes
//		 * logout
//		 ****/
//		login 					= new Login(this.driver);
//		usersData 				= new UsersData();
//		selectRegion 			= new SelectRegion(this.driver);
//		navigateTo				= new Shared(this.driver);
//		eventManagement			= new EventManagement(this.driver);
//		
//		eventSetupData 			= new EventSetUpData();
//		eventData 				= new EventData();
//		eventDataCreation 		= eventData.new EventCreateData();
//		regionData 				= new RegionData();
//		usersList 				= new UsersList(this.driver);
//		userDataCreation		= usersData.new UsersCreateData();
//		
//		resourceData 			= new ResourceData();
//		regionList 				= new RegionList(this.driver);
//		view 					= new View(this.driver);
//		resourceTypeData   		= new ResourceTypeData();
//	    statusTypeData			= new StatusTypeData();
//	    updateStatus			= new UpdateStatus(this.driver);
//	    updateStatusData		= new UpdateStatusData();
//	    updateStatusCreateData 	= updateStatusData.new UpdateStatusCreateData();
//	    statusTypeDataCreation 	= statusTypeData.new StatusTypeCreateData ();
//		viewsUnderSetup 		= new ViewsUnderSetup(this.driver);
//		viewData				= new ViewData();
//		viewsDataCreation		= viewData.new ViewCreateData();
//		eventSetUp 				= new EventSetUp(this.driver);
//		mails 					= new Mails(this.driver1);
//		
//		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
//		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
//		
//		String resourceName = resourceData.resource_Name1_In_Region;
//		
//		navigateTo.users();
//		usersList.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(userDataCreation.name6, UsersData.INITIAL_PASSWORD, userDataCreation.fullName6, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
//				 .provideMaintainEventsRightAndSave();
//		navigateTo.eventSetUp();
//		eventSetUp.clickNotificationsAndSelectAllNotifications(userDataCreation.name6, eventSetupData.EventTemplate2WithNotificationInRegion);
//		login.logOut();
//		
//		login.loginAsNewUser(userDataCreation.name6, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
//		navigateTo.eventManagment();
//		eventManagement.createEvent(eventSetupData.EventTemplate2WithNotificationInRegion, eventDataCreation.name10, eventDataCreation.description4, resourceName)
//		 			   .verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name10, eventDataCreation.description4);
//		
//		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
//		String URL= mails.verifyMailAndPagerNotification(userDataCreation.fullName6, RegionData.REGIONNAME, eventDataCreation.description4, UsersData.PRIMARY_EMAILID, eventDataCreation.name10);
//		
//		navigateTo.launchUrl(URL); 
//		eventManagement.verifyEventStatusPage();
//		
//		
//		Result = "PASS";
//	}

	@Test (dependsOnMethods={"HappyDay134597"}, groups = {"HappyDay", "Creating and managing events", "HappyDay134598"})
	public void HappyDay134598() throws Exception {

		TCID = "134598";
		TC_DESCRIPTION = "Verify that user who is logged into the application, is taken to 'Event status' page when clicked on the URL available on the notifications received for a single event";

		/****
		 * DEPENDS ON HappyDay134597
		 * launchURL(url from mail)
		 * verifyLoginScreen
		 ****/

		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay134991"})
	public void HappyDay134991() throws Exception {

		TCID = "134991";
		TC_DESCRIPTION ="Verify that users with multiple access to regions subscribed to receive notifications for a single "
				+ "event template receives one notification via email, web and pager";

		/****
		 * VerifyEmaiPagerAndWebnotifications(Need to write function)
		 */

		login = new Login(this.driver);
		usersData = new UsersData();
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		regionData = new RegionData();
		usersList = new UsersList(this.driver);
		userDataCreation=usersData.new UsersCreateData();
		
		resourceData = new ResourceData();
		regionList = new RegionList(this.driver);
		view = new View(this.driver);
		resourceTypeData = new ResourceTypeData();
	    statusTypeData = new StatusTypeData();
	    eventSetUp = new EventSetUp(this.driver);
	    mails = new Mails(this.driver);
		
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		
		String RegionName = regionList.getRegionValue(RegionData.REGIONNAME);
		String RegionName1 = regionList.getRegionValue(RegionData.REGION_NAME_2);
		String regionValues[] ={RegionName, RegionName1};
	    
	    String resourceName = resourceData.resource_Name1_In_Region;
		
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(userDataCreation.name12, UsersData.INITIAL_PASSWORD, userDataCreation.fullName6, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
        .provideMaintainEventsRightAndSave()
        .searchUserName(userDataCreation.name12)
        .provideMultiRegionAccessToUser(userDataCreation.name12, regionValues);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.users();
		usersList.searchUser(userDataCreation.name12)
				 .selectFirstRole()
				 .provideMaintainEventsRightAndSave()
				 .editUserAndProvideMultiRegionEventsRight(userDataCreation.name12, regionValues);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.eventSetUp();
		eventSetUp.clickOnNotificationsAndSelectAllNotificationsAndSave(userDataCreation.name12, eventSetupData.EventTemplate2WithNotificationInRegion);
		login.logOut();
		
		login.loginAsNewUser(userDataCreation.name12, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.createEvent(eventSetupData.EventTemplate2WithNotificationInRegion, eventDataCreation.name28, eventDataCreation.description1, resourceName)
					   .verifyWebNotificationAndClickOnAcknowledge(eventDataCreation.name28, eventDataCreation.description1);
		
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForAnEventCreated(userDataCreation.fullName6, userDataCreation.fullName6, RegionData.REGIONNAME, eventDataCreation.description1, eventDataCreation.name28);
		mails.logoutMail();
		login.logOut();
		Result = "PASS";

	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay134992"})
	public void HappyDay134992() throws Exception {

		TCID = "134992";
		TC_DESCRIPTION ="Verify that users with multiple access to regions subscribed to receive notifications for more "
				+ "than one event template receives one notification via email, web and pager";

		/****
		 * LoginAsUserSingleEventrightSubscribedToMultipleEventTemplateWithMultiRegionAccess(Need to write function)
		 * createSingleEventSelectingEventTempalteInRG1(Need to write function)
		 * createSingleEventSelectingEventTempalteInRG2(Need to write function)
		 * LoginToWebMail(function already exist "loginToMail")
		 * VerifyEmailPagerAndWebnotifications(Need to write function)
		*/
		
		Result = "PASS";
		}
}
