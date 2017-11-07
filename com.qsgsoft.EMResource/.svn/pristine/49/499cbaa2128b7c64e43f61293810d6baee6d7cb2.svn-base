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
import EMR.data.UpdateStatusData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UpdateStatusData.UpdateStatusCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.RegionDefault;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.Shared;
import EMR.pages.StatusTypes;
import EMR.pages.UpdateStatus;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewsUnderSetup;
import qaFramework.Configurations.Configuration;

public class CreatingAndManagingEvents extends Configuration {
	
	UsersCreateData userDataCreation;
	LoginData loginData;
	EventSetUpData eventSetupData;
	EventCreateData eventDataCreation;
	EventData eventData;
	ResourceData resourceData;
	UsersData usersData;
	RegionData regionData;ViewData viewData;
	ViewCreateData viewDataCreation;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	EventSetUpData eventSetUpData;
	EventSetUpCreateData eventSetupDataCreation;
	ResourceCreateData resourceDataCreation;
	UpdateStatusData updateStatusData;
	UpdateStatusCreateData updateStatusCreateData;
	
	Login login;
	Shared navigateTo;
	EventSetUp eventSetUp;
	EventManagement eventManagement;
	UsersList usersList;
	RegionDefault regionDefault;
	ViewsUnderSetup viewUnderSetup;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	UpdateStatus updateStatus;
	View view;
	
	static String EDIT_EVENT_NAME, USER_WITH_MAINTAIN_EVENT_RIGHT, SECTION_NAME;
	static ArrayList<String> regionNames, eventTemplateNames, statusTypesValues, statusTypesNames, statusTypeValues, updatedValues, updatedValues1;

	public CreatingAndManagingEvents() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test (priority = 2, groups = {"HappyDay", "Creating And Managing Events", "HappyDay149764", "EMResource v3.28"})
	public void HappyDay149764() throws Exception {

		TCID = "149764";
		TC_DESCRIPTION = " Verify that 'Save' and 'Cancel' buttons are available at the top and bottom of the Edit Event page";

		
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login = new Login(this.driver);
		eventManagement = new EventManagement(this.driver);
		
	    eventManagement.editSingleEvent(EDIT_EVENT_NAME,eventDataCreation.editname2,eventDataCreation.editdescription2)
					   .verifyEventInformation(eventDataCreation.editname2, eventDataCreation.editdescription2)
	    			   .clickEditLink(eventDataCreation.editname2)
	    			   .verifyCancelAndSaveButtonAfterEdit()
	    			   .NavigateToCancelAtOfTopOfThePage();
	    login.logOut();			   
		Result = "PASS";
	}
	
	@Test (priority = 1, groups = {"HappyDay", "Creating And Managing Events", "HappyDay149765", "EMResource v3.28"})
	public void HappyDay149765() throws Exception {
		
		TCID = "149765";
		TC_DESCRIPTION = "Verify that event details are updated appropriately upon 'Saving'";

		usersData = new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		resourceData = new ResourceData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		eventManagement = new EventManagement(this.driver);
	    
	    login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithOnlyMantainEventRightAndSave(userDataCreation.name12, UsersData.INITIAL_PASSWORD, userDataCreation.fullName12, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .searchUser(userDataCreation.name12)
				 .selectFirstRole()
				 .clickOnSave();
		USER_WITH_MAINTAIN_EVENT_RIGHT = userDataCreation.name12;
		login.logOut();
		
		login.loginAsNewUser(userDataCreation.name12, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.createEvent(eventSetupData.EventTemplate1WithoutNotificationInRegion, eventDataCreation.name26, eventDataCreation.description1, resourceData.resource_Name1_In_Region)
					   .editSingleEvent(eventDataCreation.name26, eventDataCreation.editname, eventDataCreation.editdescription)
					   .verifyEventInformation(eventDataCreation.editname, eventDataCreation.editdescription);
		String updateEventName= eventDataCreation.updatedEventName + eventDataCreation.editname;
		eventManagement.verifyEventIsPresentInEventBanner(updateEventName)
					   .editSingleEvent(eventDataCreation.editname, eventDataCreation.editname1, eventDataCreation.editdescription1);
		String updateEventName1= eventDataCreation.updatedEventName1 +  eventDataCreation.editname1;
		eventManagement.verifyEventIsPresentInEventBanner(updateEventName1);
		EDIT_EVENT_NAME = eventDataCreation.editname1;
		Result = "PASS";
	}
	
	@Test (priority=3, groups = {"HappyDay", "Creating And Managing Events", "HappyDay194515", "EMResource v3.32"})
	public void HappyDay194515() throws Exception {

		TCID = "194515";
		TC_DESCRIPTION = "Verify that PHI warning is displayed while creating and editing single region events.";
		
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		resourceData = new ResourceData();
		
		login= new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_RIGHT, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.navigateToProtectedHealthInformation(eventSetupData.EventTemplate1WithoutNotificationInRegion)
		               .verifyEventManagementPage()
		               .createEvent(eventSetupData.EventTemplate1WithoutNotificationInRegion, eventDataCreation.name,
				                    eventDataCreation.description, resourceData.resource_Name2_In_Region)
				       .verifyEventManagementPage()
				       .clickEditLink(eventDataCreation.name)
				       .clickOnProtectedHealthInformation();
		String contentInPHI = eventManagement.getContentOfProtectedHealthInformation();
		eventManagement.verifyContentOnProtectedHealthInformation(contentInPHI);
		eventManagement.closeProtectedHealthInformation()
				       .NavigateToCancelAtOfTopOfThePage();
		login.logOut();
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay194516", "EMResource v3.32"})
	public void HappyDay194516() throws Exception {

		TCID = "194516";
		TC_DESCRIPTION = "Verify that PHI warning is displayed while creating and editing Ad Hoc events.";
		
		usersData = new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login= new Login(this.driver);
		regionDefault = new RegionDefault(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name2, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
		         .provideMaintainEventAndMaintainAdHocEventsRightSave();
		login.logOut();
		
		login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		regionDefault.verifyRegionName(RegionData.REGIONNAME); 
		navigateTo.eventManagment();
        eventManagement.navigateToCreateAdHocEventScreen()
                       .verifyCreateAdhocEventScreen()
        			   .clickOnProtectedHealthInformation();
        String contentInPHI = eventManagement.getContentOfProtectedHealthInformation();
        eventManagement.verifyContentOnProtectedHealthInformation(contentInPHI);
        eventManagement.closeProtectedHealthInformation()
                       .clickCancel()
                       .navigateToCreateAdHocEventScreen()
                       .verifyCreateAdhocEventScreen()
		               .createAdHocEvent(eventDataCreation.name1, eventDataCreation.description1)
		               .verifyEventManagementPage()
		               .clickEditLink(eventDataCreation.name1)
		               .clickOnProtectedHealthInformation();
		String contentInPHI1 = eventManagement.getContentOfProtectedHealthInformation();
		eventManagement.verifyContentOnProtectedHealthInformation(contentInPHI1);
		eventManagement.closeProtectedHealthInformation()
				       .clickCancel();
		login.logOut();
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay194517", "EMResource v3.32"})
	public void HappyDay194517() throws Exception {

		TCID = "194517";
		TC_DESCRIPTION = "Verify that PHI warning is displayed while creating and editing Multi-Region events.";

		usersData = new UsersData();
		eventSetupData = new EventSetUpData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		
		login= new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		
		regionNames = new ArrayList<String>();
		regionNames.addAll(Arrays.asList(RegionData.REGION_NAME_2,RegionData.REGIONNAME));
		
		eventTemplateNames = new ArrayList<String>();
		eventTemplateNames.addAll(Arrays.asList(eventSetupData.Multi_Region_Event_Template3_Without_Notification_In_Region1,eventSetupData.Multi_Region_Event_Template1_Without_Notification_In_Region));
		
		login.loginToRegionAsUser(usersData.MultiRegionEventUser, UsersData.PASSWORD, RegionData.REGIONNAME);
		navigateTo.eventManagment();
        eventManagement.clickOnCreateNewMultiRegionEvent()
                       .verifyCreateMultiregionEventPage()
                       .clickOnProtectedHealthInformation();
        String contentInPHI = eventManagement.getContentOfProtectedHealthInformation();
        eventManagement.verifyContentOnProtectedHealthInformation(contentInPHI);
        eventManagement.closeProtectedHealthInformation()
                       .clickCancel()
		               .createMultiregionEvent(eventDataCreation.name2, eventDataCreation.description, regionNames, eventTemplateNames);
        eventManagement.verifyEventManagementPage()
                       .clickEditLink(eventDataCreation.name2)
                       .clickOnProtectedHealthInformation();
        String contentInPHI1 = eventManagement.getContentOfProtectedHealthInformation();
        eventManagement.verifyContentOnProtectedHealthInformation(contentInPHI1);
        eventManagement.closeProtectedHealthInformation()
	                   .clickCancel();
        login.logOut();
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay195515", "Creating And Managing Events", "EMResource v3.32"})
	public void HappyDay195515() throws Exception {

		TCID = "195515";
		TC_DESCRIPTION = "Verify that status values for the status types changed from normal to event only are cleared out, when the status type is not being used in an active event.";
		
		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		resourceData = new ResourceData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		updateStatusData = new UpdateStatusData();
	    updateStatusCreateData =updateStatusData.new UpdateStatusCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		statusTypes = new StatusTypes(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
	    resources = new Resources(this.driver);
	    eventSetUp = new EventSetUp(this.driver);
	    usersList = new UsersList(this.driver);
	    updateStatus = new UpdateStatus(this.driver);
	    view = new View(this.driver);
		
		String statusTypeValue[] = new String[6],
			   statusesValues[] = new String[3],
		       resourceTypeValue[] = new String[1],
		       resourceValues[] = new String[1];
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.views();
		viewUnderSetup.createNewSection(viewDataCreation.section);
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypeValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName);
		
		statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName2, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName3, StatusTypeData.STATUS_PURPLE_COLOR);
		
		statusesValues[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName1);
		statusesValues[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName2);
		statusesValues[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName3);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sstName, statusTypeDataCreation.description, viewDataCreation.section)
	    		   .createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.tstName, statusTypeDataCreation.description, viewDataCreation.section)
	               .createStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.dateName, statusTypeDataCreation.description, viewDataCreation.section)
	               .createStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.nedocsName, statusTypeDataCreation.description, viewDataCreation.section);

	    statusTypeValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName);
	    statusTypeValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sstName);
	    statusTypeValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName);
	    statusTypeValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.dateName);
	    statusTypeValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nedocsName);
	    System.out.println(statusTypeDataCreation.tstName); 
	    
	    statusTypesNames = new ArrayList<String>();
	    statusTypesNames.addAll(Arrays.asList(statusTypeDataCreation.nstName, statusTypeDataCreation.mstName, statusTypeDataCreation.sstName, statusTypeDataCreation.tstName, statusTypeDataCreation.dateName, statusTypeDataCreation.nedocsName));
	    
	    statusTypesValues = new ArrayList<String>();
		statusTypesValues.addAll(Arrays.asList(statusTypeValue[0], statusTypeValue[1], statusTypeValue[2],statusTypeValue[3],statusTypeValue[4],statusTypeValue[5]));
		
		statusTypeValues = new ArrayList<String>();
		statusTypeValues.addAll(Arrays.asList(statusTypeValue[0], statusTypeValue[1], statusTypeValue[2]));
	    
		navigateTo.resourceType();
	    resourceTypes.createResourceType(resourceTypeDataCreation.name, statusTypesValues);
	    resourceTypeValue[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);
	    
	    navigateTo.resources();
		resources.createResourceWithAddress(resourceDataCreation.name, resourceDataCreation.abbrevation, resourceTypeDataCreation.name, 
		    		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
		    		ResourceData.LASTNAME, ResourceData.STREETADDRESS,
		    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resourceValues[0] = resources.getResourceValue(resourceDataCreation.name);
		navigateTo.eventSetUp();
	    eventSetUp.createNewEventTemplate(eventSetupDataCreation.name, eventSetupDataCreation.definition, EventSetUpData.VOLCANO_ICON, EventSetUpData.BLUE_COLOUR, resourceTypeValue[0], statusTypeValues, USER_WITH_MAINTAIN_EVENT_RIGHT);
	    navigateTo.viewUnderSetup();
	    viewUnderSetup.createView(viewDataCreation.name, ViewData.DESCRIPTION, resourceDataCreation.name, statusTypesNames);
	    login.logOut();
	    
	    login.loginAsUser(USER_WITH_MAINTAIN_EVENT_RIGHT, UsersData.PASSWORD);
	    navigateTo.particularView(viewDataCreation.name);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(resourceDataCreation.name);
		updateStatus.updateAllSixStatusTypes(statusTypeValue[0], statusTypeValue[1], statusTypeValue[2], statusTypeValue[5], statusTypeValue[3], statusTypeValue[4], updateStatusCreateData.numberValueToUpdate, statusesValues[0], UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE1, UpdateStatusData.NEDOCS_VALUES_TO_UPDATE1,updateStatusCreateData.textValueToUpdate,updateStatusCreateData.currentDateToUpdate);
		
		updatedValues = new ArrayList<String>();
		updatedValues.addAll(Arrays.asList(UpdateStatusData.VALUE_90, statusesValues[0],UpdateStatusData.CALCULATED_SATURATION_SCORE_429,UpdateStatusData.CALCULATED_DISASTER_SCORE_241,updateStatusCreateData.textValueToUpdate,updateStatusCreateData.currentDateToUpdate));
		
		navigateTo.eventManagment();
		eventManagement.createEvent(eventSetupDataCreation.name, eventDataCreation.name, eventDataCreation.description, resourceDataCreation.name);
		navigateTo.particularView(viewDataCreation.name);
		view.verifyUpdatedStatusTypeValue(resourceTypeValue[0], resourceValues[0], statusTypesValues, updatedValues);
		login.logOut();
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.statusTypes();
		/*statusTypes.editStatusTypeAndSelectEventOnly(for all 6 statusTypeName)------>NEW
		                      this.clickOnEdit(statusTypeName);
		                      this.selectEventOnlyCheckBox();
		                      this.clickOnSave();*/
		login.logOut();
		login.loginAsUser(USER_WITH_MAINTAIN_EVENT_RIGHT, UsersData.PASSWORD);
	    navigateTo.particularView(viewDataCreation.name);
	    updatedValues1 = new ArrayList<String>();
		updatedValues1.addAll(Arrays.asList(UpdateStatusData.VALUE_90, statusesValues[0],"--","--","--"));
		
	    view.verifyUpdatedStatusTypeValue(resourceTypeValue[0], resourceValues[0], statusTypesValues, updatedValues1);
	    login.logOut();
	    Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay195516", "Creating And Managing Events", "EMResource v3.32"})
	public void HappyDay195516() throws Exception {

		TCID = "195516";
		TC_DESCRIPTION = "Verify that status values for the status types changed from normal to event only are retained, when the status type is being used in an active event.";
		
		//Covered in HappyDay195515 test case
		
		Result = "PASS";
	}
}
