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
import EMR.data.UpdateStatusData;
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

public class PrivateStatusTypes extends Configuration {

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
	ViewResourceDetail viewResourceDetail;
	View viewsList;

	static String RESOURCE_NAME,RESOURCE_VALUE, RESOURCE_TYPE,RESOURCE_TYPE_VALUE,SECTION_NAME,VIEW_NAME,EVENT_NAME,USER;
	static ArrayList<String> ROLED_STATUSTYPE_VALUE= new ArrayList<String>();
	static ArrayList<String> PRIVATE_STATUSTYPE_NAMES= new ArrayList<String>();
	static ArrayList<String> PRIVATE_STATUSTYPE_VALUES= new ArrayList<String>();
	static ArrayList<String> STATUSES_VALUES= new ArrayList<String>();
	static ArrayList<String> STATUSES_NAMES= new ArrayList<String>();

	public PrivateStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	} 
	@Test(groups = {"HappyDay","Setting up Status Types", "HappyDay48712"})
	public void HappyDay48712() throws Exception {

		TCID ="48712";
		TC_DESCRIPTION ="Create a private status type ST and verify that ST can be viewed by any user (non system admin) in the following setup pages even if the user does not have any resource rights on the associated resource:"+
				"a. Status Type List"
				+"b. Create New /Edit Resource Type"
				+"c. Create /Edit Role"
				+"d. Edit Resource Level Status Types"
				+"e. Create New/Edit/Copy View"
				+"f. Edit Resource Detail View Sections"
				+"g. Create/Edit Event Template"
				+"e. Edit event"
				+"f. While configuring the form";

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
		viewResourceDetail = new ViewResourceDetail(this.driver);
		viewsList = new View(this.driver);

		ArrayList<String> privateStatusTypesNamesInFormActivationPage;
		String roleValue;

		login.loginAsAdmin(
				LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);

		navigateTo.views();
		viewUnderSetup.createNewSection(viewDataCreation.section);
		SECTION_NAME=viewDataCreation.section;

		navigateTo.roles();
		//roles.removeDefaultRoleIfExists();
		roles.createRole(rolesDataCreation.name);
		roleValue = rolesList.getRoleValue(rolesDataCreation.name);

		navigateTo.statusTypes();					
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName,statusTypeDataCreation.description,SECTION_NAME);
		ROLED_STATUSTYPE_VALUE.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName));

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, ROLED_STATUSTYPE_VALUE);
		RESOURCE_TYPE_VALUE = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);

		navigateTo.resources();
		resources.createResourceWithAddress(
				resourceDataCreation.name, resourceDataCreation.abbrevation1,
				resourceTypeDataCreation.name, ResourceData.STANDARDRESOURCETYPE,
				ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, 
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		RESOURCE_VALUE = resources.getResourceValue(resourceDataCreation.name);

		System.out.println(resourceDataCreation.name);
		navigateTo.eventSetUp();
		eventSetUp.createEventTemplateDeselectingWebOption(eventSetupDataCreation.name, eventSetupDataCreation.definition, RESOURCE_TYPE_VALUE, ROLED_STATUSTYPE_VALUE.get(0));

		navigateTo.users();
		usersList.createUserWithMandatoryDetailsAndEMailPager(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, roleValue)
		.provideSetupRolesRight()
		.provideSetUpStatusTypesRight()
		.provideSetupResourceTypesRight()
		.provideSetupResourcesAddAndEditRight()
		.provideMaintainEventTemplateRight()
		.provideMaintainEventsRight() 
		.provideViewCustomViewRight()
		.selectUpdateStatusOfResource(resourceDataCreation.name)
		.selectUserMayCreateAndModifyFormsRight()
		.provideConfigureRegionViewsRightAndSave();
		System.out.println(userDataCreation.name);
		String [] roledStatusTypeName={statusTypeDataCreation.nstName};

		navigateTo.views();   
		view.createView(viewDataCreation.name, viewDataCreation.description, resourceDataCreation.name,roledStatusTypeName);
		System.out.println(viewDataCreation.name);
		login.logOut();

		login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.customView();
		views.createCustomView(resourceDataCreation.name, RESOURCE_VALUE, ROLED_STATUSTYPE_VALUE);

		navigateTo.eventManagment();
		eventManagement.createEvent(eventSetupDataCreation.name, eventDataCreation.name, eventDataCreation.description, resourceDataCreation.name);
		eventManagement.verifyEventInformation(eventDataCreation.name, eventDataCreation.description);

		System.out.println(eventDataCreation.name);
		navigateTo.statusTypes();

		//private nst
		statusTypes.createPrivateStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.privateNST, statusTypeDataCreation.description, viewDataCreation.section);
		PRIVATE_STATUSTYPE_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.privateNST));

		//private mst
		statusTypes.createPrivateStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.privateMST, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR);
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName1));
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName2, StatusTypeData.STATUS_PURPLE_COLOR);			
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName2));
		statusTypes.clickOnReturnToStatusTypeList();
		PRIVATE_STATUSTYPE_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.privateMST));

		//private tst
		statusTypes.createPrivateStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.privateTST, statusTypeDataCreation.description, viewDataCreation.section);
		PRIVATE_STATUSTYPE_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.privateTST));

		//private saturation	
		statusTypes.createPrivateStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.privateSST, statusTypeDataCreation.description, viewDataCreation.section);
		PRIVATE_STATUSTYPE_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.privateSST));

		PRIVATE_STATUSTYPE_NAMES.addAll(Arrays.asList(statusTypeDataCreation.privateNST,statusTypeDataCreation.privateMST,statusTypeDataCreation.privateTST,statusTypeDataCreation.privateSST));
		STATUSES_NAMES.addAll(Arrays.asList(statusTypeDataCreation.statusesName1,statusTypeDataCreation.statusesName2));

		privateStatusTypesNamesInFormActivationPage = new ArrayList<String>(Arrays.asList(statusTypeDataCreation.privateNST,statusTypeDataCreation.privateMST,statusTypeDataCreation.privateSST));
		System.out.println(resourceTypeDataCreation.name);

		navigateTo.resourceType();
		resourceTypes.addStatusTypesToResourceType(resourceTypeDataCreation.name,PRIVATE_STATUSTYPE_VALUES)
		.verifyStatusTypesDisplayedUnderCreateNewResourceTypePage(PRIVATE_STATUSTYPE_VALUES);

		navigateTo.roles();
		roles.editRoleAndVerifyStatusTypesUnderRoleUpdateSection(rolesDataCreation.name,PRIVATE_STATUSTYPE_VALUES)
		.verifyStatusTypesUnderRoleMayViewRightAndIsDisabledAndChecked(PRIVATE_STATUSTYPE_VALUES);

		navigateTo.resources();
		resources.verifyAndAddStatusTypesAtResourceLevel(resourceDataCreation.name,PRIVATE_STATUSTYPE_VALUES);

		navigateTo.eventSetUp();
		eventSetUp.addStatusTypesToExistingEventTemplate(eventSetupDataCreation.name,PRIVATE_STATUSTYPE_VALUES);

		navigateTo.eventManagment();
		eventManagement.addStatusTypesToExistingEvent(eventSetupDataCreation.name, PRIVATE_STATUSTYPE_VALUES);

		navigateTo.configureForm();
		formConfiguration.verifyStatusTypesUnderFormActivationStatusTypeSectionOfCreatingNewFormTemplate(formsDataCreation.name, formsDataCreation.description, FormsData.ASCERTAINSTATUSCHANGES, privateStatusTypesNamesInFormActivationPage);

		navigateTo.views();
		view.verfiyStatusTypesUnderCreateViwPage(viewDataCreation.name1,viewDataCreation.description1,RegionData.REGIONNAME,resourceDataCreation.name,PRIVATE_STATUSTYPE_NAMES)
		.verifyAndAddStatusTypesToExsistingView(viewDataCreation.name,PRIVATE_STATUSTYPE_NAMES)
		.verfiyStatusTypesWhileCopyingView(viewDataCreation.name,PRIVATE_STATUSTYPE_NAMES);
		login.logOut();

		RESOURCE_NAME  = resourceDataCreation.name;
		RESOURCE_TYPE  =resourceTypeDataCreation.name;
		SECTION_NAME = viewDataCreation.section;
		VIEW_NAME=viewDataCreation.name;
		EVENT_NAME = eventDataCreation.name;
		USER = userDataCreation.name;
		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay48712"},groups = {"HappyDay","Setting up Status Types", "HappyDay48884"})
	public void HappyDay48884() throws Exception {

		TCID ="48884";
		TC_DESCRIPTION ="Create private status type ST, associate ST with resource RS at resource TYPE level and verify that users can view the status type only if they have any of the affiliated resource rights on RS from following screens:"
				+"a. Region view"
				+"b. Map"
				+"c. Custom view"
				+"d. View Resource Detail"
				+"e. Event detail";

		usersData=new UsersData();
		userDataCreation=usersData.new UsersCreateData();

		login = new Login(this.driver); 
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		usersList = new UsersList(this.driver);
		eventManagement = new EventManagement(this.driver);
		view = new ViewsUnderSetup(this.driver);
		views= new View(this.driver);
		map = new Map(this.driver);
		viewResourceDetail = new ViewResourceDetail(this.driver);

		login.loginAsAdmin(
				LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);

		navigateTo.users();

		usersList.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(userDataCreation.name1,UsersData.INITIAL_PASSWORD,userDataCreation.fullName1,UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID)
		.provideViewCustomViewRightAndSave()

		.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(userDataCreation.name2,UsersData.INITIAL_PASSWORD,userDataCreation.fullName2,UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID)
		.provideViewCustomViewRightAndSave()

		.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(userDataCreation.name3,UsersData.INITIAL_PASSWORD,userDataCreation.fullName3,UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID)
		.provideViewCustomViewRightAndSave()

		.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(userDataCreation.name4,UsersData.INITIAL_PASSWORD,userDataCreation.fullName4,UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID)
		.provideViewCustomViewRightAndSave();

		navigateTo.resources();
		resources.clickOnUsersLinkAndNavigateToAssignUsersPage(RESOURCE_NAME)
		.provideUpdateRightToUser(userDataCreation.name1)
		.provideRunReportRightToUser(userDataCreation.name2)
		.provideAssociateRightToUser(userDataCreation.name3)
		.clickOnSave();
		login.logOut();

		login.loginAsNewUser(userDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.customView();
		views.createCustomView(RESOURCE_NAME, RESOURCE_VALUE, ROLED_STATUSTYPE_VALUE);
		login.logOut();

		login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.customView();
		views.createCustomView(RESOURCE_NAME, RESOURCE_VALUE, ROLED_STATUSTYPE_VALUE);
		login.logOut();

		login.loginAsNewUser(userDataCreation.name3, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.customView();
		views.createCustomView(RESOURCE_NAME, RESOURCE_VALUE, ROLED_STATUSTYPE_VALUE);
		login.logOut();

		login.loginAsNewUser(userDataCreation.name4, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.customView();
		views.createCustomView(RESOURCE_NAME, RESOURCE_VALUE, ROLED_STATUSTYPE_VALUE);
		login.logOut();

		login.loginAsUser(userDataCreation.name1,UsersData.PASSWORD);
		navigateTo.map();

		map.openResourceOnMapAndVerifyResourceAndStatusTypes(RESOURCE_NAME, PRIVATE_STATUSTYPE_NAMES)
		.verifyStatusTypeFromStatusTypeDropdown(PRIVATE_STATUSTYPE_NAMES.get(1));
		viewResourceDetail.verifyStatusTypesUnderViewResourceDetailScreen(RESOURCE_NAME,PRIVATE_STATUSTYPE_NAMES,SECTION_NAME);
		eventManagement.verifyResourceTypeAndStatusTypesUnderEventStatus(EVENT_NAME,RESOURCE_TYPE, PRIVATE_STATUSTYPE_NAMES);
		map.navigateToCustomViewMapAndVerifyStatusTypesInPopUpWindowInMap(RESOURCE_NAME,PRIVATE_STATUSTYPE_NAMES);
		navigateTo.particularView(VIEW_NAME);
		views.verifyResourceTypeAndStatusTypesUnderPerticulerView(RESOURCE_TYPE, PRIVATE_STATUSTYPE_NAMES);
		login.logOut();

		login.loginAsUser(userDataCreation.name2,UsersData.PASSWORD);
		navigateTo.map();
		map.openResourceOnMapAndVerifyResourceAndStatusTypes(RESOURCE_NAME, PRIVATE_STATUSTYPE_NAMES)
		.verifyStatusTypeFromStatusTypeDropdown(PRIVATE_STATUSTYPE_NAMES.get(1));
		viewResourceDetail.verifyStatusTypesUnderViewResourceDetailScreen(RESOURCE_NAME,PRIVATE_STATUSTYPE_NAMES,SECTION_NAME);
		eventManagement.verifyResourceTypeAndStatusTypesUnderEventStatus(EVENT_NAME,RESOURCE_TYPE, PRIVATE_STATUSTYPE_NAMES);
		map.navigateToCustomViewMapAndVerifyStatusTypesInPopUpWindowInMap(RESOURCE_NAME,PRIVATE_STATUSTYPE_NAMES);
		navigateTo.particularView(VIEW_NAME);
		views.verifyResourceTypeAndStatusTypesUnderPerticulerView(RESOURCE_TYPE, PRIVATE_STATUSTYPE_NAMES);
		login.logOut();

		login.loginAsUser(userDataCreation.name3,UsersData.PASSWORD);
		navigateTo.map();
		map.openResourceOnMapAndVerifyResourceAndStatusTypes(RESOURCE_NAME, PRIVATE_STATUSTYPE_NAMES)
		.verifyStatusTypeFromStatusTypeDropdown(PRIVATE_STATUSTYPE_NAMES.get(1));
		viewResourceDetail.verifyStatusTypesUnderViewResourceDetailScreen(RESOURCE_NAME,PRIVATE_STATUSTYPE_NAMES,SECTION_NAME);
		eventManagement.verifyResourceTypeAndStatusTypesUnderEventStatus(EVENT_NAME,RESOURCE_TYPE, PRIVATE_STATUSTYPE_NAMES);
		map.navigateToCustomViewMapAndVerifyStatusTypesInPopUpWindowInMap(RESOURCE_NAME,PRIVATE_STATUSTYPE_NAMES);
		navigateTo.particularView(VIEW_NAME);
		views.verifyResourceTypeAndStatusTypesUnderPerticulerView(RESOURCE_TYPE, PRIVATE_STATUSTYPE_NAMES);
		login.logOut();

		login.loginAsUser(userDataCreation.name4,UsersData.PASSWORD);
		navigateTo.map();
		map.openResourceOnMapAndVerifyStatusTypesNotDispalyedOnPopUpWindowOfMap(RESOURCE_NAME, PRIVATE_STATUSTYPE_NAMES)
		.verifyStatusTypeNotListedInStatusTypeDropdown(PRIVATE_STATUSTYPE_NAMES.get(1));
		viewResourceDetail.verifyStatusTypesNotDisplayedUnderViewResourceDetailScreen(RESOURCE_NAME,PRIVATE_STATUSTYPE_NAMES,SECTION_NAME);
		eventManagement.verifyStatusTypesNotDisplayedUnderEventStatus(EVENT_NAME,RESOURCE_TYPE, PRIVATE_STATUSTYPE_NAMES);
		map.navigateToCustomViewMapAndVerifyStatusTypesNotDispalyedOnPopUpWindowInMap(RESOURCE_NAME,PRIVATE_STATUSTYPE_VALUES);
		navigateTo.particularView(VIEW_NAME);
		viewsList.verifyStatusTypesNotDispalyedUnderParticularView(RESOURCE_TYPE, PRIVATE_STATUSTYPE_NAMES);
		login.logOut();
		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay48884"},groups = {"HappyDay","Setting up Status Types", "HappyDay48958"})
	public void HappyDay48958() throws Exception {

		TCID ="48958";
		TC_DESCRIPTION ="Create private status type ST selecting a role R1 under â€˜Roles with Update rightsâ€™ section, associate ST with resource RS at resource TYPE level and verify that user with role R1 and with â€˜Update Statusâ€™ right on RS CAN update the status of ST from following screens: "+
				"a. Region view"
				+"b. Map"
				+"c. Custom view"
				+"d. View Resource Detail"
				+"e. Event detail";

		viewData = new ViewData();
		updateStatusData= new UpdateStatusData();
		updateDataCreation = updateStatusData.new UpdateStatusCreateData();
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
		regionDefault = new RegionDefault(this.driver);
		roles = new RolesList(this.driver);
		formConfiguration = new FormConfiguration(this.driver);
		viewResourceDetail = new ViewResourceDetail(this.driver);
		viewsList = new View(this.driver);
		map = new Map(this.driver);

		ArrayList<String> updatedValues= new ArrayList<String>();

		login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD);		

		//Update from Custom view
		navigateTo.navigateToCustomViewTable();
		viewsList.addStatusTypesToExistingCustomView(PRIVATE_STATUSTYPE_VALUES);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);

		updateStatus.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(0))
		.enterNumberOrTextOrDateStatusTypesUpdateValue(PRIVATE_STATUSTYPE_VALUES.get(0), UpdateStatusData.VALUE_19)
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(1))
		.selectMSTUpdateValue(PRIVATE_STATUSTYPE_VALUES.get(1), STATUSES_VALUES.get(1))
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(2))
		.enterNumberOrTextOrDateStatusTypesUpdateValue(PRIVATE_STATUSTYPE_VALUES.get(2), updateDataCreation.textValueToUpdate1)
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(3))
		.enterUpdateSSTValues(PRIVATE_STATUSTYPE_VALUES.get(3),UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE2)
		.saveAndNavigateToUpdatedPage();

		updatedValues.addAll(Arrays.asList(UpdateStatusData.VALUE_19,STATUSES_NAMES.get(1),updateDataCreation.textValueToUpdate1,UpdateStatusData.CALCULATED_SATURATION_SCORE_481));

		viewsList.verifyUpdatedStatusTypesValuesUnderCustomViewTable(RESOURCE_TYPE_VALUE, RESOURCE_VALUE, PRIVATE_STATUSTYPE_VALUES, updatedValues);
		navigateTo.clickOnShowMap();
		map.openResourceOnMapAndVerifyUpdatedValues(RESOURCE_NAME, updatedValues);

		//Update from Map
		navigateTo.map();
		map.verifyStatusTypeFromStatusTypeDropdown(PRIVATE_STATUSTYPE_NAMES.get(1));
		map.openResourceOnMapToUpdate(RESOURCE_NAME,PRIVATE_STATUSTYPE_NAMES);

		updateStatus
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(0))
		.enterNumberOrTextOrDateStatusTypesUpdateValue(PRIVATE_STATUSTYPE_VALUES.get(0), UpdateStatusData.VALUE_90)
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(1))
		.selectMSTUpdateValue(PRIVATE_STATUSTYPE_VALUES.get(1), STATUSES_VALUES.get(0))
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(2))
		.enterNumberOrTextOrDateStatusTypesUpdateValue(PRIVATE_STATUSTYPE_VALUES.get(2), updateDataCreation.textValueToUpdate)
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(3))
		.enterUpdateSSTValues(PRIVATE_STATUSTYPE_VALUES.get(3),UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE1)
		.saveAndNavigateToUpdatedPage();

		updatedValues.clear();
		updatedValues.addAll(Arrays.asList(UpdateStatusData.VALUE_90,STATUSES_NAMES.get(0),updateDataCreation.textValueToUpdate,UpdateStatusData.CALCULATED_SATURATION_SCORE_429));
		map.openResourceOnMapAndVerifyUpdatedValues(RESOURCE_NAME, updatedValues);

		//Update from View resource detail view
		map.clickViewInfoOnMapAndNavigateToResourceDetailPage(RESOURCE_NAME);
		viewResourceDetail.verifyStatusTypesDispalyedUnderSectionOfViewResourceDetailScreen(PRIVATE_STATUSTYPE_NAMES, SECTION_NAME);
		updateStatus.selectStatustypeAndNavigateToUpdateStatusPageAndSelectToShowAll(PRIVATE_STATUSTYPE_NAMES.get(0))

		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(0))
		.enterNumberOrTextOrDateStatusTypesUpdateValue(PRIVATE_STATUSTYPE_VALUES.get(0), UpdateStatusData.VALUE_254)
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(1))
		.selectMSTUpdateValue(PRIVATE_STATUSTYPE_VALUES.get(1), STATUSES_VALUES.get(1))
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(2))
		.enterNumberOrTextOrDateStatusTypesUpdateValue(PRIVATE_STATUSTYPE_VALUES.get(2), updateDataCreation.textValueToUpdate1)
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(3))
		.enterUpdateSSTValues(PRIVATE_STATUSTYPE_VALUES.get(3),UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE2)
		.saveAndNavigateToUpdatedPage();

		updatedValues.clear();
		updatedValues.addAll(Arrays.asList(UpdateStatusData.VALUE_254,STATUSES_NAMES.get(1),updateDataCreation.textValueToUpdate1,UpdateStatusData.CALCULATED_SATURATION_SCORE_481));
		viewResourceDetail.verifyUpdatedStatusTypesValuesUnderSection(PRIVATE_STATUSTYPE_NAMES, updatedValues);

		//Update from Event
		eventManagement.selectEventFromBannerToUpdate(EVENT_NAME);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);

		updateStatus
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(0))
		.enterNumberOrTextOrDateStatusTypesUpdateValue(PRIVATE_STATUSTYPE_VALUES.get(0), UpdateStatusData.VALUE_90)
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(1))
		.selectMSTUpdateValue(PRIVATE_STATUSTYPE_VALUES.get(1), STATUSES_VALUES.get(0))
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(2))
		.enterNumberOrTextOrDateStatusTypesUpdateValue(PRIVATE_STATUSTYPE_VALUES.get(2), updateDataCreation.textValueToUpdate)
		.selectStatusTypesToUpdate(PRIVATE_STATUSTYPE_VALUES.get(3))
		.enterUpdateSSTValues(PRIVATE_STATUSTYPE_VALUES.get(3),UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE1)
		.saveAndNavigateToUpdatedPage();

		updatedValues.clear();
		updatedValues.addAll(Arrays.asList(UpdateStatusData.VALUE_90,STATUSES_NAMES.get(0),updateDataCreation.textValueToUpdate,UpdateStatusData.CALCULATED_SATURATION_SCORE_429));
		eventManagement.verifyUpdatedStatusTypesValuesUnderEventStatus(RESOURCE_TYPE_VALUE, RESOURCE_VALUE, PRIVATE_STATUSTYPE_VALUES, updatedValues);
		login.logOut();
		Result = "PASS";
	}
}