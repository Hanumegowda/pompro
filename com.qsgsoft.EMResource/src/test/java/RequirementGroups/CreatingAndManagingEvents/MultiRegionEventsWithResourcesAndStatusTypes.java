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
import qaFramework.Configurations.Configuration;
import qaFramework.UserDefinedFunctions.Date_Time_settings;

public class MultiRegionEventsWithResourcesAndStatusTypes extends Configuration{
	
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

	public MultiRegionEventsWithResourcesAndStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay135645"})
	public void HappyDay135645() throws Exception {

		TCID = "135645";
		TC_DESCRIPTION ="Verify that when a multi region event is ended, statuses of event related status types associated with the resources of "
				+ "the events gets cleared when there are no other events associated with these resources.";


		/****
		 * LoginAsUserWithmultiRegionEventrightAndUpdateRightOnResource(function already exist "createUserWithUpdateRightOnResourceAndMantainEventRightAndSave")
		 * createMultigionEventEvent(function already exist "createMultiregionEvent")
		 * NavigateToView(Need to write function)
		 * VerifyResourceandEventRelatedStatusYtpeIsdisplayed
		 * NavigateToEventManagmentPage(function already exist "eventManagment")
		 * EndMultiRegionEvent(function already exist "EndEvent")
		 * Navigate to view 
		 * VerifyResourcesAndEventRelatedStatustypesIsNotDisplayed(function already exist "verifyNoResourceTypeResourceAndStatusTypeIsPresent")
		 * 
		 */
		login 					= new Login(this.driver);
		usersData 				= new UsersData();
		selectRegion 			= new SelectRegion(this.driver);
		navigateTo				= new Shared(this.driver);
		eventManagement			= new EventManagement(this.driver);
		
		eventSetupData 			= new EventSetUpData();
		eventData 				= new EventData();
		eventDataCreation 		= eventData.new EventCreateData();
		regionData 				= new RegionData();
		usersList 				= new UsersList(this.driver);
		userDataCreation		=usersData.new UsersCreateData();
		
		resourceData 			= new ResourceData();
		regionList 				= new RegionList(this.driver);
		view 					= new View(this.driver);
		resourceTypeData   		= new ResourceTypeData();
	    statusTypeData			= new StatusTypeData();
	    updateStatus			= new UpdateStatus(this.driver);
	    updateStatusData		= new UpdateStatusData();
	    updateStatusCreateData 	= updateStatusData.new UpdateStatusCreateData();
	    statusTypeDataCreation 	= statusTypeData.new StatusTypeCreateData ();
		viewsUnderSetup 		= new ViewsUnderSetup(this.driver);
		viewData				= new ViewData();
		viewsDataCreation		= viewData.new ViewCreateData();
		
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		
		String RegionName = regionList.getRegionValue(RegionData.REGIONNAME);
		String RegionName1 = regionList.getRegionValue(RegionData.REGION_NAME_2);
		String regionValues[] ={RegionName, RegionName1};
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
	    String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
	    String resourceName = resourceData.resource_Name1_In_Region,
	    	   resourceType = resourceTypeData.RT_Name_In_Region;
	    String[] statusTypes = {statusTypeData.Event_Private_DST_In_Region, statusTypeData.Event_Private_MST_In_Region, statusTypeData.Event_Role_NEDOCST_In_Region, statusTypeData.Event_Role_NST_In_Region, statusTypeData.Event_Shared_TST_In_Region,statusTypeData.Event_Shared_SST_In_Region};
		
		navigateTo.users();
		usersList.createUserWithSetupRegionViewRightsAndMantainEventRightAndSave(userDataCreation.name2, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceData.resource_Name1_In_Region)
				 .searchUserName(userDataCreation.name2);
		usersList.provideMultiRegionAccessToUser(userDataCreation.name2, regionValues);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.users();
		usersList.searchUser(userDataCreation.name2)
				 .selectFirstRole()
				 .provideMaintainEventsRightAndSave()
				 .editUserAndProvideMultiRegionEventsRight(userDataCreation.name2, regionValues);
		login.logOut();
		
		login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.clickOnCreateNewMultiRegionEvent();
		eventManagement.createMultiregionEvent(eventDataCreation.name6, eventDataCreation.description, regionNames, eventTemplateNames, 1);
		navigateTo.viewUnderSetup();
		viewsUnderSetup.createView(viewsDataCreation.name2,viewsDataCreation.description2, resourceName, statusTypes);
		navigateTo.particularView(viewsDataCreation.name2);
		view.verifyResourceTypeResourceAndStatusType(resourceType, resourceName, statusTypes);
		navigateTo.eventManagment();
		eventManagement.endEvent(eventDataCreation.name6);
		navigateTo.particularView(viewsDataCreation.name2);
		view.verifyNoResourceTypeResourceAndStatusTypeIsPresent(resourceType, resourceName, statusTypes);
		Result = "PASS";
		
		}
		
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay135646"})
	public void HappyDay135646() throws Exception {

		TCID = "135646";
		TC_DESCRIPTION ="Verify that when a multi region event is ended, statuses of event related status types associated with the resources participating in the event are "
				+ "NOT cleared when there are other ongoing events associated with these resources.";

		/****
		 * LoginAsUserWithmultiRegionEventrightAndUpdateRightOnResource(function already exist "")
		 * createMultigionEventEvent1(function already exist "createMultiregionEvent")
		 * createMultigionEventEvent2(function already exist "createMultiregionEvent")
		 * navigateToEventStatusFromEventBanner
		 * NavigateToEventManagmentPage(function already exist "eventManagment")
		 * EndMultiRegionEvent1(function already exist "EndEvent")
		 * navigateToEventStatusFromEventBanner
		 * VerifyResourcesAndEventRelatedStatustypesIsDisplayed(function already exist "verifyResourceTypeResourceAndStatusType")
		 * 
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
	    updateStatus = new UpdateStatus(this.driver);
	    updateStatusData = new UpdateStatusData();
	    updateStatusCreateData =updateStatusData.new UpdateStatusCreateData();
	    statusTypeDataCreation = statusTypeData.new StatusTypeCreateData ();
		
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		
		String RegionName = regionList.getRegionValue(RegionData.REGIONNAME);
		String RegionName1 = regionList.getRegionValue(RegionData.REGION_NAME_2);
		String regionValues[] ={RegionName, RegionName1};
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
	    String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
	    String resourceName = resourceData.resource_Name1_In_Region,
	    		resourceType = resourceTypeData.RT_Name_In_Region;
	    String[] statusTypes = {statusTypeData.Event_Private_DST_In_Region, statusTypeData.Event_Private_MST_In_Region, statusTypeData.Event_Role_NEDOCST_In_Region, statusTypeData.Event_Role_NST_In_Region, statusTypeData.Event_Shared_TST_In_Region,statusTypeData.Event_Shared_SST_In_Region};
	
	    	
		navigateTo.users();
		usersList.createUserWithUpdateRightOnResourceAndMantainEventRightAndSave(userDataCreation.name2, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceData.resource_Name1_In_Region)
		.searchUserName(userDataCreation.name2);
		usersList.provideMultiRegionAccessToUser(userDataCreation.name2, regionValues);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
		navigateTo.users();
		usersList.searchUser(userDataCreation.name2)
		.selectFirstRole()
		.provideMaintainEventsRightAndSave()
		.editUserAndProvideMultiRegionEventsRight(userDataCreation.name2, regionValues);
		login.logOut();
		
		login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.eventManagment();
		eventManagement.clickOnCreateNewMultiRegionEvent();
		eventManagement.createMultiregionEvent(eventDataCreation.name4, eventDataCreation.description, regionNames, eventTemplateNames, 1);
		eventManagement.clickOnCreateNewMultiRegionEvent()
					   .createMultiregionEvent(eventDataCreation.name6, eventDataCreation.description, regionNames, eventTemplateNames, 2);
		eventManagement.navigateToEventStatusFromEventBanner(eventDataCreation.name4);  
		updateStatus.clickOnUpdateStatusKey(resourceName)
					.updateAllSixStatusTypes(statusTypeData.Event_Role_NST_Value_In_Region, statusTypeData.Event_Private_MST_Value_IN_Region,statusTypeData.Event_Shared_SST_Value_In_Region, 
											 statusTypeData.Event_Role_NEDOCST_Value_In_Region,statusTypeData.Event_Shared_TST_Value_In_Region,statusTypeData.Event_Private_DST_Value_IN_Region,
											 updateStatusCreateData.numberValueToUpdate,statusTypeData.eventPrivateStatusesValues1InRegion,UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE1,
											 UpdateStatusData.NEDOCS_VALUES_TO_UPDATE1,updateStatusCreateData.textValueToUpdate,updateStatusCreateData.currentDateToUpdate);
		
		navigateTo.eventManagment();
		eventManagement.endEvent(eventDataCreation.name4)
					   .navigateToEventStatusFromEventBanner(eventDataCreation.name6);
		view.verifyResourceTypeResourceAndStatusType(resourceType, resourceName, statusTypes);
		Result = "PASS";
		
		}
	

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay135774"})
	public void HappyDay135774() throws Exception {

		TCID = "135774";
		TC_DESCRIPTION ="Verify that 'Select Resources' page displays the appropriate resource types "
				+ "corresponding to the resources available in their respective regions.";
		/****
		 * NavigateToEventManagmentPage
		 * EditMultiRegionEvent2
		 * VerifyResourceOnSelectregionPagerespectToRegion
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
	    resourceTypeData=new ResourceTypeData();
	    resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		
		String eventTemplateNames[] = {eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region, eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1};
	    String regionNames[] ={RegionData.REGIONNAME, RegionData.REGION_NAME_2};
	    
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGION_NAME_2);
		navigateTo.eventManagment();
		eventManagement.clickOnCreateNewMultiRegionEvent()
		               .enterEventName(eventDataCreation.name1)
		               .enterEventDescription(eventDataCreation.description1)
					   .deselectIncludeAllResources()
					   .selectParticipatingRegion(regionNames, eventTemplateNames)
					   .navigateToSelectResourcePage()
					   .verifySelectResourcePageIsDisplayed(RegionData.REGION_NAME_2)
					   .verifyResourceIsDisplayedForParticularResourceType(resourceTypeData.RT_Name_In_Region1, resourceData.resource_Name1_In_Region1)
					   .navigateToSelectResourcePage()
					   .verifySelectResourcePageIsDisplayed(RegionData.REGIONNAME)
					   .verifyResourceIsDisplayedForParticularResourceType(resourceTypeData.RT_Name_In_Region, resourceData.resource_Name1_In_Region)
					   .clickNext();
		login.logOut();
		
		Result = "PASS";
		}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay135650"})
	public void HappyDay135650() throws Exception {

		TCID = "135650";
		TC_DESCRIPTION ="Verify that status types cannot be added/removed to the ongoing multi region event.";

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
	    resourceTypeData=new ResourceTypeData();
	    resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
	    
		String eventTemplateNames[] = { eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1,eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region};
	    String regionNames[] ={RegionData.REGION_NAME_2,RegionData.REGIONNAME};
	    
	    login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGION_NAME_2);
		navigateTo.eventManagment();
		eventManagement.clickOnCreateNewMultiRegionEvent();
		eventManagement.createMultiregionEvent(eventDataCreation.name, eventDataCreation.description, regionNames, eventTemplateNames, 1);
		eventManagement.verifyStatusTypePageIsNotDisplayedForMultiRegionEvent(regionNames, eventDataCreation.name);		
		login.logOut();
		
		Result = "PASS";
		}

}
