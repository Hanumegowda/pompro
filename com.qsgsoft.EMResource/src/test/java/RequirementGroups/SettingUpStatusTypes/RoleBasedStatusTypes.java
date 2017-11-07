
package RequirementGroups.SettingUpStatusTypes;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import EMR.data.EventData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.FormsData;
import EMR.data.FormsData.FormsCreateData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.RegionData.RegionCreateData;
import EMR.data.ResourceData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.RolesData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusReasonData;
import EMR.data.StatusReasonData.StatusReasonCreateData;
import EMR.data.StatusTypeData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UpdateStatusData;
import EMR.data.UpdateStatusData.UpdateStatusCreateData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.ConfigureNewRelationship;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.FormConfiguration;
import EMR.pages.Login;
import EMR.pages.Mails;
import EMR.pages.Map;
import EMR.pages.OtherRegionList;
import EMR.pages.RegionDefault;
import EMR.pages.RegionList;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.RolesList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.StatusChangePreferences;
import EMR.pages.StatusReasonList;
import EMR.pages.StatusTypes;
import EMR.pages.UpdateStatus;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewResourceDetail;
import EMR.pages.ViewsUnderSetup;

public class RoleBasedStatusTypes extends Configuration {

	LoginData loginData;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceCreateData resourceDataCreation;
	UsersCreateData userDataCreation;
	UsersData usersData;
	RolesData rolesData;
	RolesCreateData rolesDataCreation;
	ResourceData resourceData;
	ViewData viewData;
	ViewCreateData viewDataCreation;
	RegionData  regionData;
	RegionCreateData regionCreateData;
	EventSetUpData eventSetUpData;
	EventSetUpCreateData eventSetupDataCreation;
	StatusReasonData StatusReasonData;
	StatusReasonCreateData creatStatusReasonData;
	EventData eventData;
	EventCreateData  eventDataCreation;
	FormsData formdata;
	FormsCreateData formsDataCreation;
	UpdateStatusData updateStatusData;
	UpdateStatusCreateData updateDataCreation;

	Login login;
	UsersList usersList;
	SelectRegion selectRegion;
	RegionDefault regionDefault;
	Shared navigateTo;
	RegionList regionList;
	StatusChangePreferences statusChangePreferences;
	RolesList rolesList; 
	ViewsUnderSetup viewUnderSetup;
	OtherRegionList otherRegionList;
	ConfigureNewRelationship configurRelationShip;
	EventSetUp eventSetUp;
	EventManagement eventManagement;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	StatusReasonList statusReasonList;
	ViewsUnderSetup view;
	UpdateStatus updateStatus;
	View views;
	Mails mail;
	RolesList roles;
	FormConfiguration formConfiguration;
	Map map;
	ViewResourceDetail viewResourceDetaile;
	View viewsList;

	//Initialization and Deceleration of variables for HappyDay49714(Resource -Type Level).

	static String RESOURCE_NAME,RESOURCE_VALUE,RESOURCE_TYPE_NAME,RESOURCE_TYPE_VALUE,SECTION,VIEW,EVENT,USER,DEFAULT_ROLE_VALUE,SELECTED_ROLE_VALUE;

	static ArrayList<String> STATUSTYPE_VALUES= new ArrayList<String>();
	static ArrayList<String> STATUSTYPE_NAMES= new ArrayList<String>();
	static ArrayList<String> STATUSES_VALUES= new ArrayList<String>();
	static ArrayList<String> STATUSES_NAMES= new ArrayList<String>();

	static ArrayList<String> MULTI_STATUSTYPE_NAME= new ArrayList<String>();
	static ArrayList<String> MULTI_STATUSTYPE_VALUE= new ArrayList<String>();

	static ArrayList<String> RESOURCE_LEVEL_STATUSTYPE_VALUE= new ArrayList<String>();
	static ArrayList<String> RESOURCE_LEVEL_STATUSTYPE_NAME= new ArrayList<String>();

	//Initialization and Deceleration of variables for HappyDay44253(Resource-Level)

	static String RESOURCE_NAME1,RESOURCE_VALUE1,RESOURCE_TYPE_NAME1,RESOURCE_TYPE_VALUE1,SECTION1,VIEW1,EVENT1,USER1,DEFAULT_ROLE_VALUE1,SELECTED_ROLE_VALUE1;

	static ArrayList<String> STATUSTYPE_VALUES1= new ArrayList<String>();
	static ArrayList<String> STATUSTYPE_NAMES1= new ArrayList<String>();

	static ArrayList<String> STATUSES_VALUES1= new ArrayList<String>();
	static ArrayList<String> STATUSES_NAMES1= new ArrayList<String>();

	static ArrayList<String> MULTI_STATUSTYPE_NAME1= new ArrayList<String>();
	static ArrayList<String> MULTI_STATUSTYPE_VALUE1= new ArrayList<String>();

	public RoleBasedStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	} 

	// Resource-Type Level
	@Test(groups = {"HappyDay","Setting up Status Types","HappyDay49714","EMResource v3.17"})
	public void HappyDay49714() throws Exception {

		TCID ="49714";
		TC_DESCRIPTION ="Create a status type ST1 (role-based) and ST2 (shared) without selecting any roles (view/update) and verify that ST can be viewed by any user (non system admin) in the following setup pages:"+
				"a. Status Type List"
				+"b. Create New /Edit Resource Type"
				+"c. Create /Edit Role"
				+"d. Edit Resource Level Status Types"
				+"e. Create New/Edit/Copy View"
				+"f. Edit Resource Detail View Sections"
				+"g. Create/Edit Event Template"
				+"e. Edit event"
				+"f. While configuring the form";

		System.out.println("running 1st");

		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		rolesData = new RolesData();
		rolesDataCreation=rolesData.new RolesCreateData();
		statusTypeData=new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData=new ResourceTypeData();
		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		resourceData=new ResourceData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		usersData=new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		eventSetUpData = new EventSetUpData();
		eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();
		formdata = new FormsData();
		formsDataCreation=formdata.new FormsCreateData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		rolesList = new RolesList(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		statusReasonList = new StatusReasonList(this.driver);
		eventManagement = new EventManagement(this.driver);
		view = new ViewsUnderSetup(this.driver);
		mail = new Mails(this.driver);
		roles = new RolesList(this.driver);
		formConfiguration = new FormConfiguration(this.driver);
		viewsList = new View(this.driver);

		ArrayList<String> customViewStatusTypeValues = new ArrayList<String>();

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);

		navigateTo.views();
		viewUnderSetup.createNewSection(viewDataCreation.section);
		SECTION=viewDataCreation.section;

		navigateTo.roles();
		roles.createRole(rolesDataCreation.name);
		SELECTED_ROLE_VALUE = rolesList.getRoleValue(rolesDataCreation.name);

		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE,statusTypeDataCreation.nstName,statusTypeDataCreation.description,SECTION);
		STATUSTYPE_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName));
		STATUSTYPE_NAMES.add(statusTypeDataCreation.nstName);

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, STATUSTYPE_VALUES);
		RESOURCE_TYPE_VALUE  = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);
		RESOURCE_TYPE_NAME  = resourceTypeDataCreation.name;

		navigateTo.resources();
		resources.createResourceWithAddress(
				resourceDataCreation.name, resourceDataCreation.abbrevation1,
				RESOURCE_TYPE_NAME, ResourceData.STANDARDRESOURCETYPE,
				ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, 
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		RESOURCE_VALUE = resources.getResourceValue(resourceDataCreation.name);
		RESOURCE_NAME = resourceDataCreation.name;

		System.out.println(resourceDataCreation.name);
		navigateTo.eventSetUp();
		eventSetUp.createEventTemplateDeselectingWebOption(eventSetupDataCreation.name,eventSetupDataCreation.definition,RESOURCE_TYPE_VALUE,STATUSTYPE_VALUES);

		navigateTo.roles();
		DEFAULT_ROLE_VALUE= roles.getDefaultRoleValueIfExists();
		navigateTo.users();

		usersList.createUserWithMandatoryDetailsAndEMailPager(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID,SELECTED_ROLE_VALUE,DEFAULT_ROLE_VALUE)
		.provideSetupRolesRight()
		.provideSetUpStatusTypesRight()
		.provideSetupResourceTypesRight()
		.provideSetupResourcesAddAndEditRight()
		.provideMaintainEventTemplateRight()
		.provideMaintainEventsRight() 
		.provideViewCustomViewRight()
		.selectUpdateStatusOfResource(RESOURCE_NAME)
		.selectUserMayCreateAndModifyFormsRight()
		.provideEditStatusChangeNotificationPreferences()
		.provideConfigureRegionalUserAccessRight()
		.provideConfigureRegionViewsRightAndSave();

		USER=userDataCreation.name;
		System.out.println(USER);

		navigateTo.views();   
		view.createView(viewDataCreation.name,viewDataCreation.description,RESOURCE_NAME,STATUSTYPE_NAMES);
		VIEW=viewDataCreation.name;
		System.out.println(VIEW);
		login.logOut();

		login.loginAsNewUser(USER,UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.eventManagment();
		eventManagement.createEvent(eventSetupDataCreation.name,eventDataCreation.name,eventDataCreation.description,RESOURCE_NAME);
		EVENT = eventDataCreation.name;
		System.out.println(eventDataCreation.name);

		navigateTo.statusTypes();
		statusTypes.createStatusTypeWithoutSelectingAnyRolesUnderViewAndUpdateRolesSections(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName1,statusTypeDataCreation.description,SECTION);

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR);			
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName1));

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName2, StatusTypeData.STATUS_PURPLE_COLOR);			
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName2));

		statusTypes.clickOnReturnToStatusTypeList();
		STATUSTYPE_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName1));
		MULTI_STATUSTYPE_NAME.add(statusTypeDataCreation.mstName1);
		MULTI_STATUSTYPE_VALUE.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName1));

		statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName2, statusTypeDataCreation.description, SECTION);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName3, StatusTypeData.STATUS_PURPLE_COLOR);			
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName3));

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName4, StatusTypeData.STATUS_PURPLE_COLOR);			
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName4));

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName5, StatusTypeData.STATUS_PURPLE_COLOR);			
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName5));

		statusTypes.clickOnReturnToStatusTypeList();
		STATUSTYPE_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName2));

		STATUSTYPE_NAMES.addAll(Arrays.asList(statusTypeDataCreation.mstName1,statusTypeDataCreation.mstName2));
		STATUSES_NAMES.addAll(Arrays.asList(statusTypeDataCreation.statusesName3,statusTypeDataCreation.statusesName4,statusTypeDataCreation.statusesName5));

		navigateTo.resourceType();
		resourceTypes.addStatusTypesToResourceType(RESOURCE_TYPE_NAME,STATUSTYPE_VALUES)
		.verifyStatusTypesDisplayedUnderCreateNewResourceTypePage(STATUSTYPE_VALUES);

		navigateTo.roles();
		roles.editRoleAndVerifyStatusTypesDisplayedUnderRolePage(rolesDataCreation.name,STATUSTYPE_VALUES);

		navigateTo.resources();
		resources.verifyStatusTypesAtResourceLevel(RESOURCE_NAME,STATUSTYPE_NAMES);

		navigateTo.eventSetUp();
		eventSetUp.verifyStatusTypesInCreateEventTemplatePage(STATUSTYPE_VALUES);
		navigateTo.eventSetUp();
		eventSetUp.addStatusTypesToExistingEventTemplate(eventSetupDataCreation.name,STATUSTYPE_VALUES);

		navigateTo.eventManagment();
		eventManagement.addStatusTypesToExistingEvent(EVENT,STATUSTYPE_VALUES);

		navigateTo.configureForm();
		formConfiguration.verifyStatusTypesUnderFormActivationStatusTypeSectionOfCreatingNewFormTemplate(formsDataCreation.name, formsDataCreation.description, FormsData.ASCERTAINSTATUSCHANGES,STATUSTYPE_NAMES);

		customViewStatusTypeValues.addAll(Arrays.asList(STATUSTYPE_VALUES.get(0),STATUSTYPE_VALUES.get(2)));
		navigateTo.customView();
		viewsList.createCustomView(RESOURCE_NAME,RESOURCE_VALUE,customViewStatusTypeValues);

		navigateTo.views();
		view.openSectionUnderEdiResourceDetailViewAndVerifyStatusTypes(SECTION,STATUSTYPE_NAMES);

		navigateTo.views();
		view.verfiyStatusTypesUnderCreateViwPage(viewDataCreation.name1,viewDataCreation.description1,RegionData.REGIONNAME,RESOURCE_NAME,STATUSTYPE_NAMES)
		.verifyAndAddStatusTypesToExsistingView(VIEW,STATUSTYPE_NAMES)
		.verfiyStatusTypesWhileCopyingView(VIEW,STATUSTYPE_NAMES);

		login.logOut();
		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay49714"},groups = {"HappyDay","Setting up Status Types","HappyDay99087","EMResource v3.17"})
	public void HappyDay99087() throws Exception {

		TCID ="99087";
		TC_DESCRIPTION ="Create status type ST selecting a role R1 both under ‘Roles with view rights’ and ‘Roles with Update rights’ sections, associate ST with resource RS at resource TYPE level and verify that user with role R1 and with ‘Update Status’ right on RS CAN view and update the status of ST from following screens:"+
				"a. Region view"+
				"b. Map (in the status type dropdown and in resource pop up window)"+
				"c. View Resource Detail"+
				"d. Custom view"+
				"g. Event details";

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		eventManagement = new EventManagement(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		regionDefault = new RegionDefault(this.driver);
		formConfiguration = new FormConfiguration(this.driver);
		viewResourceDetaile = new ViewResourceDetail(this.driver);
		viewsList = new View(this.driver);
		map = new Map(this.driver);
		resourceTypes = new ResourceTypes(this.driver);

		ArrayList<String> statusTypeName = new ArrayList<String>();
		ArrayList<String> statusTypeValue = new ArrayList<String>();
		ArrayList<String> updatedStatuses = new ArrayList<String>();

		login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD);

		navigateTo.users();
		usersList.editUserSelectUpdateRightOnResource(USER,RESOURCE_NAME);

		navigateTo.resourceType();
		resourceTypes.addStatusTypesToResourceType(RESOURCE_TYPE_NAME,STATUSTYPE_VALUES);

		navigateTo.navigateToCustomViewTable();
		viewsList.createCustomViewByCustomizeLink(RESOURCE_NAME,RESOURCE_VALUE,STATUSTYPE_VALUES);

		login.logOut();
		login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD);

		//Update from Region view
		navigateTo.particularView(VIEW);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);
		updateStatus.selectStatusTypesToUpdate(STATUSTYPE_VALUES.get(2))
		.selectMSTUpdateValue(STATUSTYPE_VALUES.get(2),STATUSES_VALUES.get(2))
		.saveAndNavigateToUpdatedPage();

		statusTypeName.add(STATUSTYPE_NAMES.get(2));
		updatedStatuses.add(STATUSES_NAMES.get(0));
		statusTypeValue.add(STATUSTYPE_VALUES.get(2));
		viewsList.verifyUpdatedStatusTypeValue(RESOURCE_TYPE_VALUE,RESOURCE_VALUE,statusTypeValue,updatedStatuses);

		//Update from Map
		navigateTo.map();
		map.openResourceOnMapToUpdate(RESOURCE_NAME,statusTypeName);
		updateStatus.selectStatusTypesToUpdate(STATUSTYPE_VALUES.get(2))
		.selectMSTUpdateValue(STATUSTYPE_VALUES.get(2),STATUSES_VALUES.get(3))
		.saveAndNavigateToUpdatedPage();
		updatedStatuses.clear();
		updatedStatuses.add(STATUSES_NAMES.get(1));
		map.openResourceOnMapAndVerifyUpdatedValues(RESOURCE_NAME,updatedStatuses);

		//Update from Detail View
		map.clickViewInfoOnMapAndNavigateToResourceDetailPage(RESOURCE_NAME);
		viewResourceDetaile.verifyStatusTypesDispalyedUnderSectionOfViewResourceDetailScreen(statusTypeName,SECTION)
		.clickOnAnyStatusTypeLinkToUpdate(STATUSTYPE_NAMES.get(2));

		updateStatus.selectMSTUpdateValue(STATUSTYPE_VALUES.get(2),STATUSES_VALUES.get(4))
		.saveAndNavigateToUpdatedPage();
		updatedStatuses.clear();
		updatedStatuses.add(STATUSES_NAMES.get(2));
		viewResourceDetaile.verifyUpdatedStatusTypesValuesUnderSection(statusTypeName,updatedStatuses);

		//Update from Event
		eventManagement.selectEventFromBannerToUpdate(EVENT);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);
		updateStatus .selectStatusTypesToUpdate(STATUSTYPE_VALUES.get(2))
		.selectMSTUpdateValue(STATUSTYPE_VALUES.get(2),STATUSES_VALUES.get(2))
		.saveAndNavigateToUpdatedPage();

		updatedStatuses.clear();
		updatedStatuses.add(STATUSES_NAMES.get(0));
		eventManagement.verifyUpdatedStatusTypesValuesUnderEventStatus(RESOURCE_TYPE_VALUE,RESOURCE_VALUE,statusTypeValue,updatedStatuses);

		//Update from Custom view
		navigateTo.navigateToCustomViewTable();
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);
		updateStatus.selectStatusTypesToUpdate(STATUSTYPE_VALUES.get(2))
		.selectMSTUpdateValue(STATUSTYPE_VALUES.get(2),STATUSES_VALUES.get(3))
		.saveAndNavigateToUpdatedPage();

		updatedStatuses.clear();
		updatedStatuses.add(STATUSES_NAMES.get(1));

		viewsList.verifyUpdatedStatusTypesValuesUnderCustomViewTable(RESOURCE_TYPE_VALUE,RESOURCE_VALUE,statusTypeValue,updatedStatuses);
		navigateTo.showOnMap();
		map.openResourceOnMapAndVerifyUpdatedValues(RESOURCE_NAME,updatedStatuses);
		login.logOut();
		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay49714"},groups = {"HappyDay","Setting up Status Types","HappyDay99519","EMResource v3.17"})
	public void HappyDay99519() throws Exception {

		TCID ="99519";
		TC_DESCRIPTION ="Create status type ST selecting a role R1 under ‘Roles with view rights’, associate ST with resource RS at resource TYPE level and verify that user with role R1 and with only 'View Resource' right on RS CAN view ST on following screens:"+
				"a. Region view"+
				"b. Map (in the status type dropdown and in resource pop up window)"+
				"c. View Resource Detail"+
				"d. Custom view"+
				"e. Event details"+
				"f. Mobile view"+
				"g. Edit My Status Change preferences";

		login = new Login(this.driver); 
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		statusTypes= new StatusTypes(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		eventManagement = new EventManagement(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);
		viewResourceDetaile = new ViewResourceDetail(this.driver);
		viewsList = new View(this.driver);
		map = new Map(this.driver);

		login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD);
		navigateTo.users();
		usersList.editUserAndRemoveUpdateAndAssociateRightsOnResource(USER,RESOURCE_NAME);

		navigateTo.statusTypes();
		statusTypes.editAndDeselectRoleUnderViewAndUpdateSections(MULTI_STATUSTYPE_NAME.get(0),SELECTED_ROLE_VALUE)
		.selectRoleUnderViewRights(SELECTED_ROLE_VALUE)
		.saveEditedStatusType();

		navigateTo.navigateToCustomViewTable();
		viewsList.createCustomViewByCustomizeLink(RESOURCE_NAME,RESOURCE_VALUE,MULTI_STATUSTYPE_VALUE);
		login.logOut();

		login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD);

		navigateTo.map();
		map.openResourceOnMapAndVerifyResourceAndStatusTypes(RESOURCE_NAME,MULTI_STATUSTYPE_NAME)
		.verifyStatusTypeFromStatusTypeDropdown(MULTI_STATUSTYPE_NAME.get(0))
		.clickViewInfoOnMapAndNavigateToResourceDetailPage(RESOURCE_NAME);

		viewResourceDetaile.verifyStatusTypesDispalyedUnderSectionOfViewResourceDetailScreen(MULTI_STATUSTYPE_NAME,SECTION);

		navigateTo.particularView(VIEW);
		viewsList.verifyStatusTypesUnderPerticulerView(RESOURCE_TYPE_NAME,MULTI_STATUSTYPE_NAME);

		navigateTo.navigateToCustomViewTable();
		viewsList.verifyStatusTypesDisplayedUnderCustomViewTable(RESOURCE_TYPE_NAME,MULTI_STATUSTYPE_NAME);
		navigateTo.showOnMap();
		map.openResourceOnMapAndVerifyResourceAndStatusTypes(RESOURCE_NAME,MULTI_STATUSTYPE_NAME);

		eventManagement.verifyStatusTypesDisplayedUnderEventStatus(EVENT,RESOURCE_TYPE_NAME,MULTI_STATUSTYPE_NAME);

		navigateTo.navigateToStatusChangePrefsUnderPreferences();
		statusChangePreferences.setStatusChangeNotifications(RESOURCE_NAME,RESOURCE_VALUE,RESOURCE_TYPE_NAME)
		.verifyStatusTypesDisplayedUnderEditMyStatusChangePreferencesPage(MULTI_STATUSTYPE_NAME,SECTION);
		login.logOut();
		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay49714"},groups = {"HappyDay","Setting up Status Types","HappyDay49691","EMResource v3.17"})
	public void HappyDay49691() throws Exception {

		TCID ="49691";
		TC_DESCRIPTION ="Create status type ST without selecting any roles (view/update), associate ST with resource RS at resource TYPE level and verify that ST is NOT displayed for non system admin user on following screens:"+
				"a. Region view"+
				"b. Map (in the status type dropdown and in resource pop up window)"+
				"c. View Resource Detail"+
				"d. Custom view"+
				"e. Event details";

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		eventManagement = new EventManagement(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);
		viewResourceDetaile = new ViewResourceDetail(this.driver);
		viewsList = new View(this.driver);
		map = new Map(this.driver);

		login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD);
		navigateTo.statusTypes();
		statusTypes.editAndDeselectRoleUnderViewAndUpdateSections(MULTI_STATUSTYPE_NAME.get(0),SELECTED_ROLE_VALUE)
		.saveEditedStatusType();
		login.logOut();

		login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD);

		//Region view
		navigateTo.particularView(VIEW);
		viewsList.verifyStatusTypesNotDispalyedUnderParticularView(RESOURCE_TYPE_NAME,MULTI_STATUSTYPE_NAME);

		//Map
		navigateTo.map();
		map.openResourceOnMapAndVerifyStatusTypesNotDispalyedOnPopUpWindowOfMap(RESOURCE_NAME,MULTI_STATUSTYPE_NAME)
		.verifyStatusTypeNotListedInStatusTypeDropdown(MULTI_STATUSTYPE_NAME.get(0));

		//Detail view
		viewResourceDetaile.verifyStatusTypesNotDisplayedUnderViewResourceDetailScreen(RESOURCE_NAME,MULTI_STATUSTYPE_NAME,SECTION);

		//Event Status
		eventManagement.verifyStatusTypesNotDisplayedUnderEventStatus(EVENT,RESOURCE_TYPE_NAME,MULTI_STATUSTYPE_NAME);

		//Edit My Status Change Notification
		navigateTo.navigateToStatusChangePrefsUnderPreferences();
		statusChangePreferences.setStatusChangeNotifications(RESOURCE_NAME,RESOURCE_VALUE,RESOURCE_TYPE_NAME)
		.verifyStatusTypesNotUnderEditMyStatusChangePreferencesPage(MULTI_STATUSTYPE_NAME,SECTION);

		//Custom view
		navigateTo.navigateToCustomViewTable();
		navigateTo.clickOnCustomize();
		viewsList.clickOptionsVerifyStatusTypesNotInEditCustomViewOptionsScreen(MULTI_STATUSTYPE_NAME);
		navigateTo.navigateToCustomViewTable();
		viewsList.verifyStatusTypesNotInCustomView(RESOURCE_TYPE_NAME,MULTI_STATUSTYPE_NAME);
		map.navigateToCustomViewMapAndVerifyStatusTypesNotDispalyedOnPopUpWindowInMap(RESOURCE_NAME,MULTI_STATUSTYPE_NAME);
		login.logOut();
		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay49714"},groups = {"HappyDay","Setting up Status Types", "HappyDay100650","EMResource v3.17"})
	public void HappyDay100650() throws Exception {

		TCID ="100650";
		TC_DESCRIPTION ="Create status type ST selecting a role R1 under ‘Roles with view rights’ section, associate ST with resource RS at resource TYPE level and verify that a user with role R1 and ‘Update Status’ right on RS CAN only view ST but CANNOT update the status of ST from following screens:"+
				"a. Region view"+
				"b. Map screen (from resource pop up window)"+
				"c. View Resource Detail"+
				"d. Custom view"+
				"e. Event details";

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		eventManagement = new EventManagement(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);
		regionDefault = new RegionDefault(this.driver);
		viewResourceDetaile = new ViewResourceDetail(this.driver);
		viewsList = new View(this.driver);
		map = new Map(this.driver);

		ArrayList<String> removeStatusTypes =  new ArrayList<String>();

		removeStatusTypes.addAll(Arrays.asList(STATUSTYPE_VALUES.get(0),STATUSTYPE_VALUES.get(2)));

		login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD);
		navigateTo.users();
		usersList.editUserSelectUpdateRightOnResource(USER,RESOURCE_NAME);

		navigateTo.statusTypes();
		statusTypes.editAndDeselectRoleUnderViewAndUpdateSections(MULTI_STATUSTYPE_NAME.get(0),SELECTED_ROLE_VALUE)
		.selectRoleUnderViewRights(SELECTED_ROLE_VALUE)
		.saveEditedStatusType();

		navigateTo.resourceType();
		resourceTypes.removeStatusTypesFromResourceType(RESOURCE_TYPE_NAME,removeStatusTypes);

		navigateTo.navigateToCustomViewTable().clickOnCustomize();
		viewsList.searchForResource(RESOURCE_NAME)
		.selectResourceAndAddStatusTypesToCustomViewWithoutSummeryTotals(RESOURCE_VALUE,MULTI_STATUSTYPE_VALUE);
		login.logOut();

		login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD);

		//Region View
		navigateTo.particularView(VIEW);
		viewsList.verifyStatusCellOfStatusTypeCantUpdate(RESOURCE_VALUE,MULTI_STATUSTYPE_VALUE.get(0));
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);
		updateStatus.verifyYouAreNotAuthorizedToUpdateMessage();

		//Map
		navigateTo.map();
		map.openResourceOnMapToUpdate(RESOURCE_NAME,MULTI_STATUSTYPE_NAME);
		updateStatus.verifyYouAreNotAuthorizedToUpdateMessage();

		//Detail View
		navigateTo.map();
		map.openViewResourceDetailPage(RESOURCE_NAME);
		viewsList.verifyStatusCellOfStatusTypeCantUpdate(RESOURCE_VALUE,MULTI_STATUSTYPE_VALUE.get(0));

		//Event
		eventManagement.selectEventFromBannerToUpdate(EVENT);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);
		updateStatus.verifyYouAreNotAuthorizedToUpdateMessage();

		//Custom view table And Map
		navigateTo.navigateToCustomViewTable();
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);
		updateStatus.verifyYouAreNotAuthorizedToUpdateMessage();
		updateStatus.returnToViewAndShowOnCustomViewMap();
		map.openResourceOnMapToUpdate(RESOURCE_NAME,MULTI_STATUSTYPE_NAME);
		updateStatus.verifyYouAreNotAuthorizedToUpdateMessage();

		navigateTo.resourceType();
		resourceTypes.addStatusTypesToResourceType(RESOURCE_TYPE_NAME,STATUSTYPE_VALUES);
		login.logOut();
		Result = "PASS";
	}

	//Resource Level Tcs
	@Test(groups = {"HappyDay","Setting up Status Types","HappyDay44253","EMResource v3.17"})
	public void HappyDay44253() throws Exception {

		TCID ="44253";
		TC_DESCRIPTION = "Create a status type ST selecting a role R1 both under ‘Roles with view rights’ and ‘Roles with Update rights’ sections, add ST to resource RS at the resource level and verify that user with role R1 and with ‘Update Status’ right on resource RS CAN view and update the status of ST from following screens:"+
				"a. Region view"+
				"b. Map screen (from resource pop up window)"+
				"c. View Resource Detail"+
				"d. Custom view"+
				"e. Event details";

		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		rolesData = new RolesData();
		rolesDataCreation=rolesData.new RolesCreateData();
		statusTypeData=new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData=new ResourceTypeData();
		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		resourceData=new ResourceData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		usersData=new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		eventSetUpData = new EventSetUpData();
		eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		rolesList = new RolesList(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		eventManagement = new EventManagement(this.driver);
		view = new ViewsUnderSetup(this.driver);
		roles = new RolesList(this.driver);
		viewsList = new View(this.driver);
		regionDefault = new RegionDefault(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		map = new Map(this.driver);
		viewResourceDetaile = new ViewResourceDetail(this.driver);
		ArrayList<String> updatedStatus1 = new ArrayList<String>();

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);

		navigateTo.views();
		viewUnderSetup.createNewSection(viewDataCreation.section);
		SECTION=viewDataCreation.section;

		navigateTo.roles();
		roles.createRole(rolesDataCreation.name1);
		SELECTED_ROLE_VALUE1 = rolesList.getRoleValue(rolesDataCreation.name1);

		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE,statusTypeDataCreation.nstName1,statusTypeDataCreation.description,SECTION);
		STATUSTYPE_VALUES1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName1));
		STATUSTYPE_NAMES1.add(statusTypeDataCreation.nstName1);

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name1,STATUSTYPE_VALUES1);
		RESOURCE_TYPE_VALUE1  = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name1);
		RESOURCE_TYPE_NAME1  = resourceTypeDataCreation.name1;

		navigateTo.resources();
		resources.createResourceWithAddress(
				resourceDataCreation.name1, resourceDataCreation.abbrevation1,
				RESOURCE_TYPE_NAME1, ResourceData.STANDARDRESOURCETYPE,
				ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, 
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		RESOURCE_VALUE1 = resources.getResourceValue(resourceDataCreation.name1);
		RESOURCE_NAME1 = resourceDataCreation.name1;

		System.out.println(resourceDataCreation.name1);
		navigateTo.eventSetUp();
		eventSetUp.createEventTemplateDeselectingWebOption(eventSetupDataCreation.name1,eventSetupDataCreation.definition,RESOURCE_TYPE_VALUE1,STATUSTYPE_VALUES1);

		navigateTo.roles();
		DEFAULT_ROLE_VALUE1= roles.getDefaultRoleValueIfExists();
		navigateTo.users();

		usersList.createUserWithMandatoryDetailsAndEMailPager(userDataCreation.name1, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID,SELECTED_ROLE_VALUE1,DEFAULT_ROLE_VALUE1)
		.provideSetupRolesRight()
		.provideSetUpStatusTypesRight()
		.provideSetupResourceTypesRight()
		.provideSetupResourcesAddAndEditRight()
		.provideMaintainEventTemplateRight()
		.provideMaintainEventsRight() 
		.provideViewCustomViewRight()
		.selectUpdateStatusOfResource(RESOURCE_NAME1)
		.selectUserMayCreateAndModifyFormsRight()
		.provideEditStatusChangeNotificationPreferences()
		.provideConfigureRegionalUserAccessRight()
		.provideConfigureRegionViewsRightAndSave();

		USER1=userDataCreation.name1;
		System.out.println(USER1);

		navigateTo.views();   
		view.createView(viewDataCreation.name1,viewDataCreation.description,RESOURCE_NAME1,STATUSTYPE_NAMES1);
		VIEW1=viewDataCreation.name1;
		System.out.println(VIEW1);
		login.logOut();

		login.loginAsNewUser(USER1,UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.eventManagment();
		eventManagement.createEvent(eventSetupDataCreation.name1,eventDataCreation.name1,eventDataCreation.description,RESOURCE_NAME1);
		EVENT1 = eventDataCreation.name1;
		System.out.println(eventDataCreation.name1);

		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName3, statusTypeDataCreation.description,SECTION);

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName3, StatusTypeData.STATUS_PURPLE_COLOR);			
		STATUSES_VALUES1.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName3));

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName4, StatusTypeData.STATUS_PURPLE_COLOR);			
		STATUSES_VALUES1.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName4));

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName5, StatusTypeData.STATUS_PURPLE_COLOR);			
		STATUSES_VALUES1.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName5));
		statusTypes.clickOnReturnToStatusTypeList();

		STATUSTYPE_VALUES1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName3));
		MULTI_STATUSTYPE_NAME1.add( statusTypeDataCreation.mstName3);
		MULTI_STATUSTYPE_VALUE1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName3));
		STATUSES_NAMES1.addAll(Arrays.asList(statusTypeDataCreation.statusesName3,statusTypeDataCreation.statusesName4,statusTypeDataCreation.statusesName5));

		navigateTo.resources();
		resources.verifyAndAddStatusTypesAtResourceLevel(RESOURCE_NAME1,MULTI_STATUSTYPE_VALUE1);

		navigateTo.eventSetUp();
		eventSetUp.addStatusTypesToExistingEventTemplate(eventSetupDataCreation.name1,MULTI_STATUSTYPE_VALUE1);

		navigateTo.eventManagment();
		eventManagement.addStatusTypesToExistingEvent(EVENT1,MULTI_STATUSTYPE_VALUE1);

		navigateTo.navigateToCustomViewTable();
		viewsList.createCustomViewByCustomizeLink(RESOURCE_NAME1,RESOURCE_VALUE1,STATUSTYPE_VALUES1);

		navigateTo.views();
		view.verifyAndAddStatusTypesToExsistingView(VIEW1,MULTI_STATUSTYPE_NAME1);
		login.logOut();

		login.loginAsUserAndAcknowledgeWebNotification(USER1,UsersData.PASSWORD);

		//Update from Region view
		navigateTo.particularView(VIEW1);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME1);
		updateStatus.selectStatusTypesToUpdate(MULTI_STATUSTYPE_VALUE1.get(0))
		.selectMSTUpdateValue(MULTI_STATUSTYPE_VALUE1.get(0),STATUSES_VALUES1.get(0))
		.saveAndNavigateToUpdatedPage();
		updatedStatus1.add(STATUSES_NAMES1.get(0));
		viewsList.verifyUpdatedStatusTypeValue(RESOURCE_TYPE_VALUE1,RESOURCE_VALUE1,MULTI_STATUSTYPE_VALUE1,updatedStatus1);

		//Update from Map
		navigateTo.map();
		map.openResourceOnMapToUpdate(RESOURCE_NAME1,MULTI_STATUSTYPE_NAME1);
		updateStatus.selectStatusTypesToUpdate(MULTI_STATUSTYPE_VALUE1.get(0))
		.selectMSTUpdateValue(MULTI_STATUSTYPE_VALUE1.get(0),STATUSES_VALUES1.get(1))
		.saveAndNavigateToUpdatedPage();
		updatedStatus1.clear();
		updatedStatus1.add(STATUSES_NAMES1.get(1));
		map.openResourceOnMapAndVerifyUpdatedValues(RESOURCE_NAME1,updatedStatus1);

		//Update from Detail View
		map.clickViewInfoOnMapAndNavigateToResourceDetailPage(RESOURCE_NAME1);
		viewResourceDetaile.verifyStatusTypesDispalyedUnderSectionOfViewResourceDetailScreen(MULTI_STATUSTYPE_NAME1,SECTION)
		.clickOnAnyStatusTypeLinkToUpdate(MULTI_STATUSTYPE_NAME1.get(0));

		updateStatus.selectMSTUpdateValue(MULTI_STATUSTYPE_VALUE1.get(0),STATUSES_VALUES1.get(2))
		.saveAndNavigateToUpdatedPage();
		updatedStatus1.clear();
		updatedStatus1.add(STATUSES_NAMES1.get(2));
		viewResourceDetaile.verifyUpdatedStatusTypesValuesUnderSection(MULTI_STATUSTYPE_NAME1,updatedStatus1);

		//Update from Event
		eventManagement.selectEventFromBannerToUpdate(EVENT1);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME1);
		updateStatus.selectStatusTypesToUpdate(MULTI_STATUSTYPE_VALUE1.get(0))
		.selectMSTUpdateValue(MULTI_STATUSTYPE_VALUE1.get(0),STATUSES_VALUES1.get(1))
		.saveAndNavigateToUpdatedPage();
		updatedStatus1.clear();
		updatedStatus1.add(STATUSES_NAMES1.get(1));
		eventManagement.verifyUpdatedStatusTypesValuesUnderEventStatus(RESOURCE_TYPE_VALUE1,RESOURCE_VALUE1,MULTI_STATUSTYPE_VALUE1,updatedStatus1);

		//Update from Custom view-Table
		navigateTo.navigateToCustomViewTable();
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME1);
		updateStatus.selectStatusTypesToUpdate(MULTI_STATUSTYPE_VALUE1.get(0))
		.selectMSTUpdateValue(MULTI_STATUSTYPE_VALUE1.get(0),STATUSES_VALUES1.get(2))
		.saveAndNavigateToUpdatedPage();
		updatedStatus1.clear();
		updatedStatus1.add(STATUSES_NAMES1.get(2));
		viewsList.verifyUpdatedStatusTypesValuesUnderCustomViewTable(RESOURCE_TYPE_VALUE1,RESOURCE_VALUE1,MULTI_STATUSTYPE_VALUE1,updatedStatus1);

		//Update from Custom view-Map
		navigateTo.showOnMap();
		map.openResourceOnMapAndVerifyUpdatedValues(RESOURCE_NAME1,updatedStatus1);
		login.logOut();
		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay44253"},groups = {"HappyDay","Setting up Status Types", "HappyDay100652"})
	public void HappyDay100652() throws Exception {

		TCID ="100652";
		TC_DESCRIPTION = "Create status type ST selecting a role R1 under ‘Roles with view rights’ section, add ST to resource RS at the resource level and verify that the user with role R1 and ‘Update Status’ right on resource RS CAN only view ST but CANNOT update the status of ST from following screens:"+
				"a. Region view"+
				"b. Map screen (from resource pop up window)"+
				"c. View Resource Detail"+
				"d. Custom view"+
				"e. Event details";

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		rolesList = new RolesList(this.driver);
		regionDefault = new RegionDefault(this.driver);
		roles = new RolesList(this.driver);
		viewResourceDetaile = new ViewResourceDetail(this.driver);
		viewsList = new View(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		map = new Map(this.driver);
		eventManagement= new EventManagement(this.driver);

		login.loginAsUserAndAcknowledgeWebNotification(USER1,UsersData.PASSWORD);

		navigateTo.statusTypes();
		statusTypes.editAndDeselectRoleUnderViewAndUpdateSections(MULTI_STATUSTYPE_NAME1.get(0),SELECTED_ROLE_VALUE1)
		.selectRoleUnderViewRights(SELECTED_ROLE_VALUE1)
		.saveEditedStatusType();

		statusTypes.editAndDeselectRoleUnderViewAndUpdateSections(STATUSTYPE_NAMES1.get(0),SELECTED_ROLE_VALUE1)
		.saveEditedStatusType();

		login.logOut();
		login.loginAsUserAndAcknowledgeWebNotification(USER1,UsersData.PASSWORD);

		//Region View
		navigateTo.particularView(VIEW1);
		viewsList.verifyStatusCellOfStatusTypeCantUpdate(RESOURCE_VALUE1,MULTI_STATUSTYPE_VALUE1.get(0));
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME1);
		updateStatus.verifyYouAreNotAuthorizedToUpdateMessage();

		//Map
		navigateTo.map();
		map.openResourceOnMapToUpdate(RESOURCE_NAME1,MULTI_STATUSTYPE_NAME1);
		updateStatus.verifyYouAreNotAuthorizedToUpdateMessage();

		//Detail View
		navigateTo.map();
		map.openViewResourceDetailPage(RESOURCE_NAME1);
		viewsList.verifyStatusCellOfStatusTypeCantUpdate(RESOURCE_VALUE1,MULTI_STATUSTYPE_VALUE1.get(0));

		//Event
		eventManagement.selectEventFromBannerToUpdate(EVENT1);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME1);
		updateStatus.verifyYouAreNotAuthorizedToUpdateMessage();

		//Custom view table And Map
		navigateTo.navigateToCustomViewTable();
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME1);
		updateStatus.verifyYouAreNotAuthorizedToUpdateMessage();
		updateStatus.returnToViewAndShowOnCustomViewMap();
		map.openResourceOnMapToUpdate(RESOURCE_NAME1,MULTI_STATUSTYPE_NAME1);
		updateStatus.verifyYouAreNotAuthorizedToUpdateMessage();
		login.logOut();
		Result = "PASS";
	}


	/*	@Test(dependsOnMethods={"HappyDay49714"},groups = {"HappyDay","Setting up Status Types", "HappyDay99605"})
	public void HappyDay99605() throws Exception {

	TCID ="99605";
	TC_DESCRIPTION ="Create status type ST without selecting any roles (view/update), add ST to resource RS at resource level and verify that ST is NOT displayed for non system admin user on following screens: "+
					 "a. Region view screen"+
					 "b. Map (in the status type dropdown and in resource pop up window)"+
					 "c. View Resource Detail"+
					 "d. Custom view"+
					 "e. Event details"+
					 "f. Mobile view"+
                     "g. Edit My Status Change preferences";

    viewData = new ViewData();
    viewDataCreation = viewData.new ViewCreateData();
    rolesData = new RolesData();
    rolesDataCreation=rolesData.new RolesCreateData();
    statusTypeData=new StatusTypeData();
    statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
    resourceTypeData=new ResourceTypeData();
    resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
    resourceData=new ResourceData();
    resourceDataCreation=resourceData.new ResourceCreateData();
    usersData=new UsersData();
    userDataCreation=usersData.new UsersCreateData();
    eventSetUpData = new EventSetUpData();
    eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
    StatusReasonData = new StatusReasonData();
    creatStatusReasonData = StatusReasonData.new StatusReasonCreateData();
    eventData = new EventData();
    eventDataCreation = eventData.new EventCreateData();
    formdata = new FormsData();
    formsDataCreation=formdata.new FormsCreateData();

    login = new Login(this.driver); 
    statusTypes = new StatusTypes(this.driver);
    selectRegion = new SelectRegion(this.driver);
    navigateTo = new Shared(this.driver);
    viewUnderSetup = new ViewsUnderSetup(this.driver);
    rolesList = new RolesList(this.driver);
    usersList = new UsersList(this.driver);
    resourceTypes = new ResourceTypes(this.driver);
    resources = new Resources(this.driver);
    configurRelationShip = new ConfigureNewRelationship(this.driver);
    eventSetUp = new EventSetUp(this.driver);
    statusReasonList = new StatusReasonList(this.driver);
    eventManagement = new EventManagement(this.driver);
    updateStatus = new UpdateStatus(this.driver);
    statusChangePreferences = new StatusChangePreferences(this.driver);
    view = new ViewsUnderSetup(this.driver);
    views= new View(this.driver);
    regionDefault = new RegionDefault(this.driver);
    mail = new Mails(this.driver);
    roles = new RolesList(this.driver);
    formConfiguration = new FormConfiguration(this.driver);
    viewResourceDetaile = new ViewResourceDetail(this.driver);
    viewsList = new View(this.driver);

    login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD);

    navigateTo.users();
	usersList.editUserAndGiveViewRightsOnResource(USER,RESOURCE_NAME);--new

	navigateTo.statusTypes();
	statusTypes.editStatusTyepeAndRemoveAllRolesRightsUnderViewAndUpdateSections(STATUSTYPE_VALUE.get(1))
	           .save();

    navigateTo.resourceType();
    resource.removeStatusTypeFromResourceType(RESOURCE_TYPE, STATUSTYPE_VALUES.get(1))

    navigateTo.resource();
    resources.verifyAndAddStatusTypesAtResourceLevel(RESOURCE_NAME,STATUSTYPE_VALUE.get(1))
    login.logOut();

    login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD);

    navigateTo.particularView(VIEW);
    views.verifyStatusTypesNotDispalyedUnderParticularView(RESOURCE_TYPE, STATUSTYPE_VALUE.get(1));

    viewResourceDetaile.verifyStatusTypesNotDisplayedUnderViewResourceDetailScreen(RESOURCE_NAME,STATUSTYPE_VALUE.get(1),SECTION);

    navigateTo.map();
	map.openResourceOnMapAndVerifyStatusTypesNotDispalyedOnPopUpWindowOfMap(RESOURCE_NAME, STATUSTYPE_VALUE.get(1))
	   .verifyStatusTypeNotListedInStatusTypeDropdown(STATUSTYPE_VALUE.get(1))

	 navigateTo.customView();
	 viewsList.verifyStatusTypesNotDisplayedUnderCustomViewtable(RESOURCE_NAME, RESOURCE_VALUE, STATUSTYPE_VALUE.get(1))--new 
	 map.navigateToCustomViewMapAndVerifyStatusTypesNotInPopUpWindowInMap(RESOURCE_NAME,STATUSTYPE_VALUE.get(3))

	 eventManagement.selectEventFromBannerToUpdate(EVENT);
	 eventManagement.verifyStatusTypesNotDisplayedUnderEventStatus(EVENT, RESOURCE_TYPE, STATUSTYPE_VALUE.get(1))

	 navigateTo.navigateToStatusChangePrefsUnderPreferences();
	 statusChangePreferences.verifyStatusTypesNotPresentUnderUncategorizedSection(STATUSTYPE_NAMES.get(1)) 
	 login.logOut();
     Result = "PASS";

	}*/

	/*@Test(dependsOnMethods={"HappyDay49714"},groups = {"HappyDay","Setting up Status Types", "HappyDay100426"})
	public void HappyDay100426() throws Exception {

	TCID ="100426";
	TC_DESCRIPTION ="Create a status type ST selecting a role R1 under ‘Roles with view rights’, add ST to resource RS at the resource level and verify that user with role R1 & with 'View Resource' right on RS CAN view ST on following screens:"+
					 "a. Region view"+
					 "b. Map (in the status type dropdown and in resource pop up window)"+
					 "c. View Resource Detail"+
					 "d. Custom view"+
					 "e. Event details"+
					 "f. Mobile view"+
                     "g. Edit My Status Change preferences";

    viewData = new ViewData();
    viewDataCreation = viewData.new ViewCreateData();
    rolesData = new RolesData();
    rolesDataCreation=rolesData.new RolesCreateData();
    statusTypeData=new StatusTypeData();
    statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
    resourceTypeData=new ResourceTypeData();
    resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
    resourceData=new ResourceData();
    resourceDataCreation=resourceData.new ResourceCreateData();
    usersData=new UsersData();
    userDataCreation=usersData.new UsersCreateData();
    eventSetUpData = new EventSetUpData();
    eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
    StatusReasonData = new StatusReasonData();
    creatStatusReasonData = StatusReasonData.new StatusReasonCreateData();
    eventData = new EventData();
    eventDataCreation = eventData.new EventCreateData();
    formdata = new FormsData();
    formsDataCreation=formdata.new FormsCreateData();

    login = new Login(this.driver); 
    statusTypes = new StatusTypes(this.driver);
    selectRegion = new SelectRegion(this.driver);
    navigateTo = new Shared(this.driver);
    viewUnderSetup = new ViewsUnderSetup(this.driver);
    rolesList = new RolesList(this.driver);
    usersList = new UsersList(this.driver);
    resourceTypes = new ResourceTypes(this.driver);
    resources = new Resources(this.driver);
    configurRelationShip = new ConfigureNewRelationship(this.driver);
    eventSetUp = new EventSetUp(this.driver);
    statusReasonList = new StatusReasonList(this.driver);
    eventManagement = new EventManagement(this.driver);
    updateStatus = new UpdateStatus(this.driver);
    statusChangePreferences = new StatusChangePreferences(this.driver);
    view = new ViewsUnderSetup(this.driver);
    views= new View(this.driver);
    regionDefault = new RegionDefault(this.driver);
    mail = new Mails(this.driver);
    roles = new RolesList(this.driver);
    formConfiguration = new FormConfiguration(this.driver);
    viewResourceDetaile = new ViewResourceDetail(this.driver);
    viewsList = new View(this.driver);

    login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD);

    navigateTo.users();
	usersList.editUserAndGiveViewRightsOnResource(USER,RESOURCE_NAME);--new

    navigateTo.statusTypes();
    statusTypes.editStatusTyepeAndRemoveAllRolesRightsUnderViewAndUpdateSections(STATUSTYPE_VALUE.get(1))
               .selectRoleUnderViewSection(role)
	           .save();

	 navigateTo.resourceType();
     resource.removeStatusTypeFromResourceType(RESOURCE_TYPE, STATUSTYPE_VALUES.get(1))    

     navigateTo.resource();
     resources.verifyAndAddStatusTypesAtResourceLevel(RESOURCE_NAME,STATUSTYPE_VALUE.get(1))

	 navigateTo.customView();
	 viewsList.addStatusTypesToExistingCustomView(RESOURCE_LEVEL_STATUSTYPE_VALUE)
     login.logOut();

     login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD);
     navigateTo.map();
     map.openResourceOnMapAndVerifyResourceAndStatusTypes(RESOURCE_NAME, STATUSTYPE_VALUE)
          .verifyStatusTypeFromStatusTypeDropdown(STATUSTYPE_NAMES)
          .clickViewInfoOnMapAndNavigateToResourceDetailPage(RESOURCE_NAME);
     viewResourceDetaile.verifyStatusTypesDispalyedUnderSectionOfViewResourceDetailScreen(RESOURCE_LEVEL_STATUSTYPE_NAME,SECTION)

     navigateTo.particularView(VIEW);
     views.verifyStatusTypesDispalyedUnderParticularView(RESOURCE_TYPE,RESOURCE_LEVEL_STATUSTYPE_VALUE);

	 navigateTo.customView();
	 viewsList.verifyStatusTypesDisplayedUnderCustomViewtable(RESOURCE_NAME, RESOURCE_VALUE, RESOURCE_LEVEL_STATUSTYPE_VALUE)
	 map.navigateToCustomViewMapAndVerifyStatusTypesInPopUpWindowInMap(RESOURCE_NAME,RESOURCE_LEVEL_STATUSTYPE_VALUE)

	 eventManagement.selectEventFromBannerToUpdate(EVENT);
	 eventManagement.verifyStatusTypesDisplayedUnderEventStatus(EVENT,RESOURCE_TYPE,RESOURCE_LEVEL_STATUSTYPE_VALUE)

	 navigateTo.navigateToStatusChangePrefsUnderPreferences();
	 statusChangePreferences.verifyStatusTypesDisplayedUnderEditMyStatusChangeNotificationPage(RESOURCE_LEVEL_STATUSTYPE_NAME) 
	 login.logOut();
     Result = "PASS";
	}*/


}
