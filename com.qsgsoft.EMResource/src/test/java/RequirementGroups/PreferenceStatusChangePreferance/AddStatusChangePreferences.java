package RequirementGroups.PreferenceStatusChangePreferance;

import java.util.ArrayList;
import java.util.Arrays;
import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration_Mails;
import EMR.data.EventData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusChangePreferncesData;
import EMR.data.StatusTypeData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UpdateStatusData;
import EMR.data.UpdateStatusData.UpdateStatusCreateData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.Mails;
import EMR.pages.Map;
import EMR.pages.RegionDefault;
import EMR.pages.RegionList;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.StatusChangePreferences;
import EMR.pages.StatusTypes;
import EMR.pages.UpdateStatus;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewsUnderSetup;

public class AddStatusChangePreferences extends Configuration_Mails {

	LoginData loginData;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceCreateData resourceDataCreation;
	UsersCreateData userDataCreation;
	UsersData usersData;
	RolesCreateData rolesDataCreation;
	ResourceData resourceData;
	ViewData viewData;
	ViewCreateData viewDataCreation;
	UpdateStatusData updateStatusData;
	UpdateStatusCreateData updateStatusCreateData;
	EventSetUpData eventSetUpData;
	EventSetUpCreateData eventSetupDataCreation;
	EventData eventData;
	EventCreateData eventDataCreation;

	Login login;
	UsersList usersList;
	SelectRegion selectRegion;
	RegionDefault regionDefault;
	Shared navigateTo;
	RegionList regionList;
	StatusChangePreferences statusChangePreferences;
	ViewsUnderSetup viewUnderSetup;
	EventSetUp eventSetUp;
	EventManagement eventManagement;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	ViewsUnderSetup view;
	UpdateStatus updateStatus;
	View views;
	Mails mail;
	Map map;

	//HappyDay99136 variables Initialization and Declarations
	static String RESOURCE_NAME,RESOURCE_VALUE,RESOURCE_ABBRIVATION,RESOURCE_TYPE_NAME,SECTION_NAME,VIEW_NAME,USER_TO_EDIT_STATUS_CHANGE_NOTIFICATIONS,USER_FULL_NAME;

	static ArrayList<String> ROLE_BASED_STATUSTYPES_NAMES=new  ArrayList<String>();
	static ArrayList<String> STATUS_TYPES_VALUES=new  ArrayList<String>();
	static ArrayList<String> STATUSES_VALUES= new ArrayList<String>();
	static ArrayList<String> SECOND_TIME_UPDATED_VALUES;

	//HappyDay119702 variables Initialization and Declarations
	static String RESOURCE_NAME1,RESOURCE_VALUE1,RESOURCE_ABBRIVATION1,RESOURCE_TYPE_NAME1,SECTION_NAME1,EVENT_TEMPLATE1,EVENT_NAME1,USER_NAME1,USER_FULL_NAME1;

	static ArrayList<String> NEDOCS_STATUSTYPES_VALUES=new  ArrayList<String>();
	static ArrayList<String> TEXT_STATUSTYPES_VALUES=new  ArrayList<String>();
	static ArrayList<String> TEXT_AND_NEDOCS_STATUSTYPES_VALUES=new  ArrayList<String>();
	static ArrayList<String> NEDOCS_STATUSTYPES_NAMES=new  ArrayList<String>();
	static ArrayList<String> TEXT_STATUSTYPES_NAMES=new  ArrayList<String>();
	static ArrayList<String> NEDOCS_UPDATE_VALUES=new  ArrayList<String>();
	static ArrayList<String> TEXT_UPDATE_VALUES=new  ArrayList<String>();

	//HappyDay118149 variables Initialization and Declarations
	static String RESOURCE_NAME2,RESOURCE_VALUE2,RESOURCE_ABBRIVATION2,RESOURCE_TYPE_NAME2,SECTION_NAME2,EVENT_TEMPLATE2,EVENT_NAME2,USER_NAME2,USER_NAME3,USER_FULL_NAME2,TEXT_UPDATED_VALUE;
	static ArrayList<String> TEXT_AND_NUMBER_STATUSTYPES_VALUES=new  ArrayList<String>();
	static ArrayList<String> TEXT_AND_NUMBER_STATUSTYPES_NAMES=new  ArrayList<String>();


	public AddStatusChangePreferences() throws Exception  {
		super();}

	@Test(groups = {"HappyDay","Preferences Status ChangePreference","HappyDay99136"},priority=5)
	public void HappyDay99136() throws Exception {

		TCID ="99136";
		TC_DESCRIPTION ="Verify that user can receive the status change notifications upon status change of a non-event related status type.";

		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		statusTypeData=new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData=new ResourceTypeData();
		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		resourceData=new ResourceData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		usersData=new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		updateStatusData = new UpdateStatusData();
		updateStatusCreateData=updateStatusData.new UpdateStatusCreateData();
		eventSetUpData = new EventSetUpData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		regionDefault = new RegionDefault(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);
		view = new ViewsUnderSetup(this.driver);
		views= new View(this.driver);
		mail = new Mails(this.driver1);
		map = new Map(this.driver);

		String updatedDateWithTime;
		ArrayList<String> firstTimeUpdatedvalues;
		String resourceValue = new String();

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);
		navigateTo.views();

		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName,statusTypeDataCreation.description,SECTION_NAME);
		STATUS_TYPES_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName));

		statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description, SECTION_NAME);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR);
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName1));
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName2, StatusTypeData.STATUS_PURPLE_COLOR);			
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName2));
		statusTypes.clickOnReturnToStatusTypeList();
		STATUS_TYPES_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName));

		statusTypes.createStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sstName, statusTypeDataCreation.description,SECTION_NAME);
		STATUS_TYPES_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.sstName));
		ROLE_BASED_STATUSTYPES_NAMES.addAll(Arrays.asList(statusTypeDataCreation.nstName,statusTypeDataCreation.mstName,statusTypeDataCreation.sstName));

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, STATUS_TYPES_VALUES);

		navigateTo.resources();
		resources.createResourceWithAddress(
				resourceDataCreation.name, resourceDataCreation.abbrevation1,
				resourceTypeDataCreation.name, ResourceData.STANDARDRESOURCETYPE,
				ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, 
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resourceValue = resources.getResourceValue(resourceDataCreation.name);
		System.out.println(resourceDataCreation.name);

		navigateTo.users();
		usersList.createUserWithUpdateRightOnResource(userDataCreation.name,UsersData.INITIAL_PASSWORD,userDataCreation.fullName,UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID,resourceDataCreation.name)
		.provideEditStatusChangeNotificationPreferencesAndSave();

		navigateTo.views();   
		view.createView(viewDataCreation.name,viewDataCreation.description, resourceDataCreation.name,ROLE_BASED_STATUSTYPES_NAMES);
		System.out.println(userDataCreation.name);
		login.logOut();

		login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD,
				UsersData.PASSWORD);

		navigateTo.navigateToStatusChangePrefsUnderPreferences();
		statusChangePreferences
		.setStatusChangeNotifications(resourceDataCreation.name,resourceValue, resourceTypeDataCreation.name)
		.expandUncategorizedSection()
		.provideReceiveStatusChangeNotificationsToNumberStatusType(resourceValue, STATUS_TYPES_VALUES.get(0),StatusChangePreferncesData.ABOVE_VALUE_100,StatusChangePreferncesData.BELOW_VALUE_25)
		.provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(resourceValue, STATUS_TYPES_VALUES.get(1),STATUSES_VALUES.get(0), STATUSES_VALUES.get(1))
		.provideReceiveStatusChangeNotificationsToSStStatusType(resourceValue, STATUS_TYPES_VALUES.get(2),StatusChangePreferncesData.ABOVE_VALUE_80,StatusChangePreferncesData.BELOW_VALUE_20)
		.savePreferences();

		statusChangePreferences.verifyStatusTypesUnderResourceInStatusChangePreferncsPage(resourceDataCreation.name, ROLE_BASED_STATUSTYPES_NAMES);
		navigateTo.particularView(viewDataCreation.name);

		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(resourceDataCreation.name);

		updateStatus
		.verifyUpdateStatusPageAndSelectAllToUpdate()
		.enterNumberOrTextOrDateStatusTypesUpdateValue(STATUS_TYPES_VALUES.get(0), UpdateStatusData.VALUE_254)
		.selectMSTUpdateValue(STATUS_TYPES_VALUES.get(1),STATUSES_VALUES.get(1))
		.enterUpdateSSTValues(STATUS_TYPES_VALUES.get(2),UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE3)
		.saveAndNavigateToUpdatedPage();

		updatedDateWithTime=updateStatus.getStatusUpdatedDateAndTimeWithoutTimeZone();
		firstTimeUpdatedvalues = new ArrayList<String>(Arrays.asList(UpdateStatusData.ZERO_UPDATED, UpdateStatusData.NOT_UPDATED,UpdateStatusData.ZERO_UPDATED));
		SECOND_TIME_UPDATED_VALUES = new ArrayList<String>(Arrays.asList(UpdateStatusData.VALUE_254,statusTypeDataCreation.statusesName2,UpdateStatusData.CALCULATED_SATURATION_SCORE_17));
		updateStatus.verifyUpdateStatusWebNotificationAndAcknolewdge(resourceDataCreation.name, ROLE_BASED_STATUSTYPES_NAMES,firstTimeUpdatedvalues, SECOND_TIME_UPDATED_VALUES,updatedDateWithTime);
		mail.verifyMailAndPagerNotificationsForStatusChangeNotification(resourceDataCreation.abbrevation1, userDataCreation.fullName,updatedDateWithTime, resourceDataCreation.name,ROLE_BASED_STATUSTYPES_NAMES,firstTimeUpdatedvalues,SECOND_TIME_UPDATED_VALUES,RegionData.REGIONNAME,resourceTypeDataCreation.name);

		RESOURCE_NAME =resourceDataCreation.name;
		RESOURCE_VALUE = resourceValue;
		RESOURCE_ABBRIVATION = resourceDataCreation.abbrevation1;
		RESOURCE_TYPE_NAME = resourceTypeDataCreation.name;
		USER_TO_EDIT_STATUS_CHANGE_NOTIFICATIONS=userDataCreation.name;
		USER_FULL_NAME = userDataCreation.fullName;
		VIEW_NAME = viewDataCreation.name;
		Result = "PASS";		  
	}

	@Test(groups = {"HappyDay","Preferences StatusChange Preference","Delete status change preferences","HappyDay70186"},priority=6)
	public void HappyDay70187() throws Exception {

		TCID = "70187";
		TC_DESCRIPTION = "Verify that user can delete the status change notifications.";

		updateStatusData = new UpdateStatusData();
		updateStatusCreateData=updateStatusData.new UpdateStatusCreateData();

		login = new Login(this.driver); 
		navigateTo = new Shared(this.driver);

		updateStatus = new UpdateStatus(this.driver);
		regionDefault = new RegionDefault(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);
		mail = new Mails(this.driver1);

		navigateTo.navigateToStatusChangePrefsUnderPreferences();
		statusChangePreferences.deletePreferences(RESOURCE_NAME);
		statusChangePreferences.verifyStatusChangeNotificationPreferencesAreDeleted(RESOURCE_NAME, ROLE_BASED_STATUSTYPES_NAMES);

		navigateTo.particularView(VIEW_NAME);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);
		updateStatus .verifyUpdateStatusPageAndSelectAllToUpdate()
		.enterNumberOrTextOrDateStatusTypesUpdateValue(STATUS_TYPES_VALUES.get(0),UpdateStatusData.VALUE_19)
		.selectMSTUpdateValue(STATUS_TYPES_VALUES.get(1), STATUSES_VALUES.get(0))
		.enterUpdateSSTValues(STATUS_TYPES_VALUES.get(2), UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE1)
		.saveAndNavigateToUpdatedPage();

		regionDefault.verifyWebNotificationIsNotReceived(); 
		mail.verifyNoNewEmailAndPagerNotificationsRecievedForStatusChange(RESOURCE_NAME,RESOURCE_ABBRIVATION);
		login.logOut();
		Result = "PASS";
	}

	@Test(groups = {"HappyDay","Preferences Status ChangePreference","HappyDay119702"},priority=1)
	public void HappyDay119702() throws Exception {

		TCID ="119702";
		TC_DESCRIPTION ="Verify that user can set the status change preferences for a NEDOCS status type and thereafter receives the notifications when the status changes";

		statusTypeData=new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData=new ResourceTypeData();
		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		resourceData=new ResourceData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		usersData=new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		updateStatusData = new UpdateStatusData();
		updateStatusCreateData=updateStatusData.new UpdateStatusCreateData();
		eventSetUpData = new EventSetUpData();
		eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		eventData = new EventData();
		eventDataCreation=eventData.new EventCreateData();
		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		regionDefault = new RegionDefault(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);
		mail = new Mails(this.driver1);
		eventSetUp = new EventSetUp(this.driver);
		eventManagement = new EventManagement(this.driver);

		String resourceTypeValue_1 = new String();
		String resourceValue_1 = new String();
		ArrayList<String> previousUpdatedNedocsValues = new ArrayList<String>();
		String neDocsUpdatedDateWithTime;

		login.loginAsAdmin(LoginData.ADMINUSERNAME,
				LoginData.ADMINPASSWORD,RegionData.REGIONNAME); 

		navigateTo.views();
		viewUnderSetup.createNewSection(viewDataCreation.section);
		SECTION_NAME=viewDataCreation.section;

		//Creating Private,Event,Roled and shared Nedocs Sts		  
		navigateTo.statusTypes();		  
		statusTypes.createStatusType(StatusTypeData.NEDOCSTYPE,statusTypeDataCreation.nedocsName,statusTypeDataCreation.description,SECTION_NAME);
		NEDOCS_STATUSTYPES_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nedocsName));

		statusTypes.createPrivateStatusType(StatusTypeData.NEDOCSTYPE,statusTypeDataCreation.privateNedocST, statusTypeDataCreation.description, SECTION_NAME);
		NEDOCS_STATUSTYPES_VALUES .add(statusTypes.getStatusTypeValue(statusTypeDataCreation.privateNedocST));

		statusTypes.createSharedStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.sharedNEDOC_1,statusTypeDataCreation.description,SECTION_NAME);
		NEDOCS_STATUSTYPES_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNEDOC_1));

		statusTypes.createEventStatusType(StatusTypeData.NEDOCSTYPE,statusTypeDataCreation.eventNdst, statusTypeDataCreation.description,SECTION_NAME);
		NEDOCS_STATUSTYPES_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.eventNdst));

		//Creating private,event,roled and shared text Sts

		statusTypes.createStatusType(StatusTypeData.TEXTTYPE,statusTypeDataCreation.tstName1,statusTypeDataCreation.description,SECTION_NAME); 
		TEXT_STATUSTYPES_VALUES.add(statusTypes.getStatusTypeValue( statusTypeDataCreation.tstName1));

		statusTypes.createPrivateStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.privateTST,statusTypeDataCreation.description, SECTION_NAME);
		TEXT_STATUSTYPES_VALUES .add(statusTypes.getStatusTypeValue(statusTypeDataCreation.privateTST));

		statusTypes.createSharedStatusType(StatusTypeData.TEXTTYPE,statusTypeDataCreation.sharedTST,statusTypeDataCreation.description,SECTION_NAME);
		TEXT_STATUSTYPES_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation .sharedTST));

		statusTypes.createEventStatusType(StatusTypeData.TEXTTYPE,statusTypeDataCreation.eventTst, statusTypeDataCreation.description,SECTION_NAME);
		TEXT_STATUSTYPES_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.eventTst));

		NEDOCS_STATUSTYPES_NAMES.addAll(Arrays.asList(statusTypeDataCreation.nedocsName,statusTypeDataCreation.privateNedocST,statusTypeDataCreation.sharedNEDOC_1,statusTypeDataCreation.eventNdst));
		TEXT_STATUSTYPES_NAMES.addAll(Arrays.asList(statusTypeDataCreation.tstName1,statusTypeDataCreation.privateTST,statusTypeDataCreation.sharedTST,statusTypeDataCreation.eventTst));

		TEXT_AND_NEDOCS_STATUSTYPES_VALUES.addAll(NEDOCS_STATUSTYPES_VALUES);
		TEXT_AND_NEDOCS_STATUSTYPES_VALUES.addAll(TEXT_STATUSTYPES_VALUES);

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name2,TEXT_AND_NEDOCS_STATUSTYPES_VALUES);
		resourceTypeValue_1 = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name2);

		navigateTo.resources();
		resources.createResourceWithAddress(
				resourceDataCreation.name2, resourceDataCreation.abbrevation2,
				resourceTypeDataCreation.name2, ResourceData.STANDARDRESOURCETYPE,
				ResourceData.FIRSTNAME, ResourceData.LASTNAME,
				ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE,
				ResourceData.ZIPCODE, ResourceData.COUNTY); 
		resourceValue_1 =resources.getResourceValue(resourceDataCreation.name2);

		System.out.println(resourceDataCreation.name2);

		navigateTo.users();
		usersList.createUserWithUpdateRightOnResource(userDataCreation.name2,UsersData .INITIAL_PASSWORD,userDataCreation.fullName1,UsersData.PRIMARY_EMAILID ,UsersData.PRIMARY_EMAILID,resourceDataCreation.name2)
		.provideMaintainEventsRight() 
		.provideConfigureRegionalUserAccessRight()
		.provideEditStatusChangeNotificationPreferencesAndSave();

		navigateTo.eventSetUp();
		eventSetUp.createEventTemplateDeselectingWebOption(eventSetupDataCreation.name1, eventSetupDataCreation.definition1, resourceTypeValue_1,TEXT_AND_NEDOCS_STATUSTYPES_VALUES);
		login.logOut();

		login.loginAsNewUser(userDataCreation.name2,UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();

		eventManagement.createEvent(eventSetupDataCreation.name1, eventDataCreation.name1, eventDataCreation.description1, resourceDataCreation.name2);
		System.out.println(eventSetupDataCreation.name1);

		navigateTo.navigateToStatusChangePrefsUnderPreferences();
		statusChangePreferences.setStatusChangeNotifications(resourceDataCreation.name2, resourceValue_1, resourceTypeDataCreation.name2)
		.expandUncategorizedSection()
		.provideReceiveStatusChangeNotificationsToNedocsStatusType(resourceValue_1,TEXT_AND_NEDOCS_STATUSTYPES_VALUES.get(0),StatusChangePreferncesData.ABOVE_VALUE_200, StatusChangePreferncesData.BELOW_VALUE_150)
		.provideReceiveStatusChangeNotificationsToNedocsStatusType(resourceValue_1,TEXT_AND_NEDOCS_STATUSTYPES_VALUES.get(1),StatusChangePreferncesData.ABOVE_VALUE_200, StatusChangePreferncesData.BELOW_VALUE_150)
		.provideReceiveStatusChangeNotificationsToNedocsStatusType(resourceValue_1,TEXT_AND_NEDOCS_STATUSTYPES_VALUES.get(2),StatusChangePreferncesData.ABOVE_VALUE_200, StatusChangePreferncesData.BELOW_VALUE_150)
		.provideReceiveStatusChangeNotificationsToNedocsStatusType(resourceValue_1,TEXT_AND_NEDOCS_STATUSTYPES_VALUES.get(3),StatusChangePreferncesData.ABOVE_VALUE_200, StatusChangePreferncesData.BELOW_VALUE_150)

		.provideReceiveStatusChangeNotificationsToTextStatusType(resourceValue_1,TEXT_AND_NEDOCS_STATUSTYPES_VALUES.get(4))
		.provideReceiveStatusChangeNotificationsToTextStatusType(resourceValue_1,TEXT_AND_NEDOCS_STATUSTYPES_VALUES.get(5))
		.provideReceiveStatusChangeNotificationsToTextStatusType(resourceValue_1,TEXT_AND_NEDOCS_STATUSTYPES_VALUES.get(6))
		.provideReceiveStatusChangeNotificationsToTextStatusType(resourceValue_1,TEXT_AND_NEDOCS_STATUSTYPES_VALUES.get(7))
		.savePreferences();

		eventManagement.selectEventFromBannerToUpdate(eventDataCreation.name1);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(resourceDataCreation.name2);
		updateStatus.verifyUpdateStatusPageAndSelectAllToUpdate()
		.upDateMultipleNedocsStatusTypes(NEDOCS_STATUSTYPES_VALUES, UpdateStatusData.NEDOCS_VALUES_TO_UPDATE)
		.saveAndNavigateToUpdatedPage(); 

		neDocsUpdatedDateWithTime=updateStatus.getStatusUpdatedDateAndTimeWithoutTimeZone();
		previousUpdatedNedocsValues.addAll(Arrays.asList(UpdateStatusData.ZERO_UPDATED, UpdateStatusData.ZERO_UPDATED,UpdateStatusData.ZERO_UPDATED, UpdateStatusData.ZERO_UPDATED));

		NEDOCS_UPDATE_VALUES.addAll(Arrays.asList(UpdateStatusData.CALCULATED_DISASTER_SCORE_241,UpdateStatusData.CALCULATED_DISASTER_SCORE_241,UpdateStatusData.CALCULATED_DISASTER_SCORE_241,UpdateStatusData.CALCULATED_DISASTER_SCORE_241));
		updateStatus.verifyUpdateStatusWebNotificationAndAcknolewdge(resourceDataCreation.name2, NEDOCS_STATUSTYPES_NAMES,previousUpdatedNedocsValues, NEDOCS_UPDATE_VALUES,neDocsUpdatedDateWithTime);

		mail.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mail.verifyMailAndPagerNotificationsForStatusChangeNotification(resourceDataCreation.abbrevation2, userDataCreation.fullName1,neDocsUpdatedDateWithTime, resourceDataCreation.name2, NEDOCS_STATUSTYPES_NAMES,previousUpdatedNedocsValues,NEDOCS_UPDATE_VALUES,RegionData.REGIONNAME, resourceTypeDataCreation.name2); 

		RESOURCE_NAME1= resourceDataCreation.name2;
		RESOURCE_VALUE1=resourceValue_1;
		RESOURCE_ABBRIVATION1=resourceDataCreation.abbrevation2;
		RESOURCE_TYPE_NAME1=resourceTypeDataCreation.name2;
		EVENT_NAME1=eventDataCreation.name1;
		USER_NAME1=userDataCreation.name2;
		USER_FULL_NAME1=userDataCreation.fullName1;
		Result = "PASS";		
	}

	@Test(groups = {"HappyDay","Preferences Status ChangePreference","HappyDay130844"},priority=2)

	public void HappyDay130844() throws Exception {

		TCID ="130844";
		TC_DESCRIPTION ="Verify that user can set the status change preferences for a Text status type and receives the notifications when the status changes";

		statusTypeData=new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData=new ResourceTypeData();
		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		resourceData=new ResourceData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		usersData=new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		updateStatusData = new UpdateStatusData();
		updateStatusCreateData=updateStatusData.new UpdateStatusCreateData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		regionDefault = new RegionDefault(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);
		mail = new Mails(this.driver1);
		eventSetUp = new EventSetUp(this.driver);
		eventManagement = new EventManagement(this.driver);

		ArrayList<String> previousUpdatedTexts = new ArrayList<String>();
		String textUpdatedDateWithTime;

		eventManagement.selectEventFromBannerToUpdate(EVENT_NAME1);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME1);

		previousUpdatedTexts.addAll(Arrays.asList(UpdateStatusData.NOT_UPDATED,UpdateStatusData.NOT_UPDATED, UpdateStatusData.NOT_UPDATED,UpdateStatusData.NOT_UPDATED));

		TEXT_UPDATE_VALUES.addAll(Arrays.asList(updateStatusCreateData.textValueToUpdate,updateStatusCreateData.textValueToUpdate1,updateStatusCreateData.textValueToUpdate2,updateStatusCreateData.textValueToUpdate3));

		updateStatus.verifyUpdateStatusPageAndSelectAllToUpdate()
		.clearAllAndSelectStatusTypesToUpdate(TEXT_STATUSTYPES_VALUES)
		.upDateMultipleTextStatusTypes(TEXT_STATUSTYPES_VALUES,TEXT_UPDATE_VALUES).saveAndNavigateToUpdatedPage();

		textUpdatedDateWithTime = updateStatus.getStatusUpdatedDateAndTimeWithoutTimeZone();
		updateStatus.verifyUpdateStatusWebNotificationAndAcknolewdge(RESOURCE_NAME1, TEXT_STATUSTYPES_NAMES, previousUpdatedTexts,TEXT_UPDATE_VALUES, textUpdatedDateWithTime);
		mail.verifyMailAndPagerNotificationsForStatusChangeNotification(RESOURCE_ABBRIVATION1, USER_FULL_NAME1,textUpdatedDateWithTime, RESOURCE_NAME1,TEXT_STATUSTYPES_NAMES, previousUpdatedTexts,TEXT_UPDATE_VALUES, RegionData.REGIONNAME, RESOURCE_TYPE_NAME1);		
		login.logOut();
		Result = "PASS";
	}

	@Test(groups ={"HappyDay","Preferences Status ChangePreference","HappyDay118149"},priority=3)
	public void HappyDay118149() throws Exception {

		TCID ="118149";
		TC_DESCRIPTION ="Verify that status change preference notification are not received by the user when the status changes and when the status change preferences are not set for a text status type.";

		statusTypeData=new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData=new ResourceTypeData();
		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		resourceData=new ResourceData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		usersData=new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		updateStatusData = new UpdateStatusData();
		updateStatusCreateData=updateStatusData.new UpdateStatusCreateData();
		eventSetUpData = new EventSetUpData();
		eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		eventData = new EventData();
		eventDataCreation=eventData.new EventCreateData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		regionDefault = new RegionDefault(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);
		mail = new Mails(this.driver1);
		eventSetUp = new EventSetUp(this.driver);
		eventManagement = new EventManagement(this.driver);
		map = new Map(this.driver);
		String resourceTypeValue_2= new String();
		String resourceValue_2= new String();
		ArrayList<String> textStatusTypeName= new ArrayList<String>();

		login.loginAsAdmin(LoginData.ADMINUSERNAME,LoginData.ADMINPASSWORD,RegionData.REGIONNAME);
		navigateTo.statusTypes();

		//Creating role based Text and Event Number Sts

		statusTypes.createStatusType(StatusTypeData.TEXTTYPE,statusTypeDataCreation.tstName2,statusTypeDataCreation.description,SECTION_NAME);
		TEXT_AND_NUMBER_STATUSTYPES_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName2));

		statusTypes.createEventStatusType(StatusTypeData.NUMBERTYPE,statusTypeDataCreation.eventNst2,statusTypeDataCreation.description,SECTION_NAME);
		TEXT_AND_NUMBER_STATUSTYPES_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.eventNst2));
		textStatusTypeName.add(statusTypeDataCreation.tstName2);
		TEXT_AND_NUMBER_STATUSTYPES_NAMES.addAll(Arrays.asList(statusTypeDataCreation.tstName2,statusTypeDataCreation.eventNst2));

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name3,TEXT_AND_NUMBER_STATUSTYPES_VALUES);
		resourceTypeValue_2 = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name3);
		navigateTo.resources();

		resources.createResourceWithAddress(
				resourceDataCreation.name3, resourceDataCreation.abbrevation3,
				resourceTypeDataCreation.name3, ResourceData.STANDARDRESOURCETYPE,
				ResourceData.FIRSTNAME, ResourceData.LASTNAME,
				ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE,
				ResourceData.ZIPCODE, ResourceData.COUNTY);

		resourceValue_2 =resources.getResourceValue(resourceDataCreation.name3); 

		navigateTo.users();
		usersList.createUserWithUpdateRightOnResource(userDataCreation.name3,UsersData.INITIAL_PASSWORD,userDataCreation.fullName,UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID,resourceDataCreation.name3)
		.provideMaintainEventsRight()
		.provideConfigureRegionalUserAccessRight()
		.provideEditStatusChangeNotificationPreferencesAndSave(); //U2

		usersList
		.createUserBySelectingFirstRole(userDataCreation.name4,UsersData.INITIAL_PASSWORD,userDataCreation.fullName,UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID);

		navigateTo.eventSetUp();
		eventSetUp.createEventTemplateDeselectingWebOption(eventSetupDataCreation.name2, eventSetupDataCreation.definition2,resourceTypeValue_2,TEXT_AND_NUMBER_STATUSTYPES_VALUES);
		login.logOut();

		login.loginAsNewUser(userDataCreation.name3,UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.map();

		map.openResourceOnMapToUpdate(resourceDataCreation.name3,textStatusTypeName);
		updateStatus.selectStatusTypesToUpdate(TEXT_AND_NUMBER_STATUSTYPES_VALUES.get(0))
		.enterNumberOrTextOrDateStatusTypesUpdateValue(TEXT_AND_NUMBER_STATUSTYPES_VALUES.get(0),updateStatusCreateData.textValueToUpdate1)
		.saveAndNavigateToUpdatedPage();
		regionDefault.verifyWebNotificationIsNotReceived();

		mail.verifyNoNewEmailAndPagerNotificationsRecievedForStatusChange(resourceDataCreation.name3, resourceDataCreation.abbrevation3);

		RESOURCE_NAME2=resourceDataCreation.name3;
		RESOURCE_VALUE2=resourceValue_2;
		RESOURCE_ABBRIVATION2=resourceDataCreation.abbrevation3;
		RESOURCE_TYPE_NAME2=resourceTypeDataCreation.name3;
		EVENT_TEMPLATE2=eventSetupDataCreation.name2;
		USER_NAME2 =userDataCreation.name3;
		USER_NAME3 =userDataCreation.name4;
		USER_FULL_NAME2=userDataCreation.fullName;
		TEXT_UPDATED_VALUE=updateStatusCreateData.textValueToUpdate1;
		Result = "PASS";	 
	}	

	@Test(groups = {"HappyDay","Preferences Status ChangePreference","HappyDay118096"},priority=4)
	public void HappyDay118096() throws Exception {

		TCID ="118096";
		TC_DESCRIPTION ="Verify that user with appropriate right can set status change notifications preferences for other users in a region";

		statusTypeData=new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData=new ResourceTypeData();
		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		resourceData=new ResourceData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		usersData=new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		updateStatusData = new UpdateStatusData();
		updateStatusCreateData=updateStatusData.new UpdateStatusCreateData();
		eventData = new EventData();
		eventDataCreation=eventData.new EventCreateData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		regionDefault = new RegionDefault(this.driver); 
		statusChangePreferences = new StatusChangePreferences(this.driver);
		mail = new Mails(this.driver1);
		eventSetUp = new EventSetUp(this.driver);
		eventManagement = new EventManagement(this.driver);

		String textAndNumberStatusTypesUpdatedDateAndTime;
		ArrayList<String> textStatusTypeName= new ArrayList<String>();
		ArrayList<String> eventNumberStatusTypeName= new ArrayList<String>();
		ArrayList<String> beforeUpdatedNumberAndTextValues= new ArrayList<String>();
		ArrayList<String> afterUpdatedNumberAndTextValues= new ArrayList<String>();

		textStatusTypeName.add(TEXT_AND_NUMBER_STATUSTYPES_NAMES.get(0));
		eventNumberStatusTypeName.add(TEXT_AND_NUMBER_STATUSTYPES_NAMES.get(1));

		navigateTo.users();
		usersList.searchUser(USER_NAME3)
		.clickOnStatusChangeNotificationPreferences();

		statusChangePreferences
		.assignUserToStatusChangeNotifications(RESOURCE_NAME2,RESOURCE_VALUE2, USER_NAME3,RESOURCE_TYPE_NAME2)
		.expandAndverifyStatusTypesUnderUncategorizedSection(TEXT_AND_NUMBER_STATUSTYPES_NAMES)
		.provideReceiveStatusChangeNotificationsToTextStatusType(RESOURCE_VALUE2,TEXT_AND_NUMBER_STATUSTYPES_VALUES.get(0))
		.provideReceiveStatusChangeNotificationsToNumberStatusType(RESOURCE_VALUE2,TEXT_AND_NUMBER_STATUSTYPES_VALUES.get(1),StatusChangePreferncesData.ABOVE_VALUE_100,StatusChangePreferncesData.BELOW_VALUE_25)
		.savePreferences()
		.verifyStatusTypesUnderResourceInStatusChangePreferncsPage(RESOURCE_NAME2,TEXT_AND_NUMBER_STATUSTYPES_NAMES);

		navigateTo.map();
		map.openResourceOnMapAndVerifyResourceAndStatusTypes(RESOURCE_NAME2, textStatusTypeName)
		.verifyStatusTypesNotDisplayedInPopupWindow(eventNumberStatusTypeName)
		.selectToUpdateFromMapWindow();   
		updateStatus.verifyStatusTypesAreNotDisplayedToUpdate(TEXT_AND_NUMBER_STATUSTYPES_VALUES.get(1));

		navigateTo.eventManagment();
		eventManagement.createEvent(EVENT_TEMPLATE2, eventDataCreation.name2, eventDataCreation.description1, RESOURCE_NAME2);
		System.out.println(eventDataCreation.name2);
		navigateTo.users(); usersList.searchUser(USER_NAME3)
		.clickOnStatusChangeNotificationPreferences();

		eventManagement.clickOnEventBanner(eventDataCreation.name2);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME2);
		updateStatus.verifyUpdateStatusPageAndSelectAllToUpdate()
		.enterNumberOrTextOrDateStatusTypesUpdateValue(TEXT_AND_NUMBER_STATUSTYPES_VALUES.get(0),updateStatusCreateData.textValueToUpdate2)
		.enterNumberOrTextOrDateStatusTypesUpdateValue(TEXT_AND_NUMBER_STATUSTYPES_VALUES.get(1),UpdateStatusData.VALUE_19)
		.saveAndNavigateToUpdatedPage();

		textAndNumberStatusTypesUpdatedDateAndTime=updateStatus.getStatusUpdatedDateAndTimeWithoutTimeZone();
		login.logOut();

		login.loginAsNewUser(USER_NAME3,UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		beforeUpdatedNumberAndTextValues.addAll(Arrays.asList(TEXT_UPDATED_VALUE,UpdateStatusData.ZERO_UPDATED));
		afterUpdatedNumberAndTextValues.addAll(Arrays.asList(updateStatusCreateData.textValueToUpdate2,UpdateStatusData.VALUE_19));

		updateStatus.verifyUpdateStatusWebNotificationAndAcknolewdge(
				RESOURCE_NAME2,TEXT_AND_NUMBER_STATUSTYPES_NAMES,
				beforeUpdatedNumberAndTextValues,
				afterUpdatedNumberAndTextValues,
				textAndNumberStatusTypesUpdatedDateAndTime);

		mail.verifyMailAndPagerNotificationsForStatusChangeNotification(
				RESOURCE_ABBRIVATION2,USER_FULL_NAME2,
				textAndNumberStatusTypesUpdatedDateAndTime, RESOURCE_NAME2, TEXT_AND_NUMBER_STATUSTYPES_NAMES,
				beforeUpdatedNumberAndTextValues,
				afterUpdatedNumberAndTextValues,RegionData.REGIONNAME,RESOURCE_TYPE_NAME2);
		login.logOut();
		Result = "PASS"; 
	}
}