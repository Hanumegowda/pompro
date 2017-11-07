package RequirementGroups.ViewingAndManagingEMResourceEntitiesOnTheViewInterface;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.collections.CollectionUtils;
import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import EMR.data.EventData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
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
import EMR.data.StatusTypeData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData;
import EMR.data.UpdateStatusData.UpdateStatusCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.Map;
import EMR.pages.RegionDefault;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.RolesList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.StatusTypes;
import EMR.pages.UpdateStatus;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewResourceDetail;
import EMR.pages.ViewsUnderSetup;

public class ViewResourceDetailScreen extends Configuration {

	public ViewResourceDetailScreen() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

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
	UpdateStatusData updateStatusData;
	UpdateStatusCreateData updateStatusCreateData;

	Login login;
	SelectRegion selectRegion;
	RegionDefault regionDefault;
	Shared navigateTo;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	UsersList usersList;
	RolesList rolesList;
	View viewsList;
	ViewsUnderSetup viewUnderSetup;
	EventSetUp eventSetUp;
	EventManagement eventManagement;
	ViewResourceDetail viewResourceDetail;
	EventData eventData;
	EventCreateData eventDataCreation;
	UpdateStatus updateStatus;
	Map map;

	static String USER_1, RESOURCE_NAME, RESOURCE_TYPE_NAME, VIEW_NAME, SECTION_1, SECTION_2;
	ArrayList<String> StatusTypeValue_1 = new ArrayList<String>();
	ArrayList<String> StatusTypeNames_1 = new ArrayList<String>();
	ArrayList<String> stauses = new ArrayList<String>();
	ArrayList<String> StatusTypeNames_2 = new ArrayList<String>();
	ArrayList<String> eventStatusTypeValue_1 = new ArrayList<String>();
	ArrayList<String> eventStatusTypeNames_1 = new ArrayList<String>();
	ArrayList<String> eventStauses = new ArrayList<String>();

	@Test(groups = {"HappyDay", "Viewing And Managing EMResource Entities On The 'View' Interface", "HappyDay70180"}, priority = 1)
	public void HappyDay70180() throws Exception {

		TCID = "70180";
		TC_DESCRIPTION = "Verify that resource detail view can be configured from Setup module.";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		statusTypes = new StatusTypes(this.driver);
		usersList = new UsersList(this.driver);
		viewsList = new View(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		viewResourceDetail = new ViewResourceDetail(this.driver);

		statusTypeData = new StatusTypeData();
		resourceData = new ResourceData();
		usersData = new UsersData();
		viewData= new ViewData();
		resourceTypeData = new ResourceTypeData();
		userDataCreation = usersData.new UsersCreateData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		viewDataCreation = viewData.new ViewCreateData();

		String username			= userDataCreation.name,
				fullName			= userDataCreation.fullName;

		USER_1 = username;
		VIEW_NAME = viewDataCreation.name;
		RESOURCE_TYPE_NAME = resourceTypeDataCreation.name;
		RESOURCE_NAME = resourceDataCreation.name;
		SECTION_1 = viewDataCreation.section; 
		SECTION_2 = viewDataCreation.section_1;

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);

		navigateTo.views();
		viewUnderSetup.createNewSection(SECTION_1)
		.createNewSection(SECTION_2);

		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description,viewDataCreation.section);
		StatusTypeValue_1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName));

		statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description,viewDataCreation.section);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR);
		stauses.add(statusTypes .getStatusesValue(statusTypeDataCreation.statusesName));
		stauses.add(statusTypes .getStatusesValue(statusTypeDataCreation.statusesName1));
		statusTypes .clickOnReturnToStatusTypeList();
		StatusTypeValue_1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName));

		statusTypes.createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.tstName, statusTypeDataCreation.description,viewDataCreation.section);
		StatusTypeValue_1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName));

		statusTypes.createStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.nedocsName, statusTypeDataCreation.description,viewDataCreation.section);
		StatusTypeValue_1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nedocsName));

		statusTypes.createStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sstName,statusTypeDataCreation.description,viewDataCreation.section);
		StatusTypeValue_1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.sstName));

		statusTypes.createStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.dateName,statusTypeDataCreation.description,viewDataCreation.section);
		StatusTypeValue_1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.dateName));
		StatusTypeNames_1.addAll(Arrays.asList(statusTypeDataCreation.nstName, statusTypeDataCreation.mstName, statusTypeDataCreation.tstName, statusTypeDataCreation.nedocsName, statusTypeDataCreation.sstName, statusTypeDataCreation.dateName));
		StatusTypeNames_2.addAll(Arrays.asList(statusTypeDataCreation.mstName, statusTypeDataCreation.tstName, statusTypeDataCreation.nedocsName));

		navigateTo.resourceType();
		resourceTypes.createResourceType(RESOURCE_TYPE_NAME, StatusTypeValue_1);

		navigateTo.resources();
		resources.createResource(RESOURCE_NAME, resourceDataCreation.abbrevation, RESOURCE_TYPE_NAME, 
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME);

		navigateTo.users();
		usersList.createUserWithUpdateRightOnResource(USER_1, UsersData.INITIAL_PASSWORD, fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, RESOURCE_NAME)
		.provideSetUpStatusTypesRight()
		.provideConfigureRegionViewsRightAndSave();

		navigateTo.viewUnderSetup();
		viewUnderSetup.createView(VIEW_NAME, viewDataCreation.description, RESOURCE_NAME, StatusTypeNames_1);

		login.logOut()
		.loginAsNewUser(USER_1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.particularView(VIEW_NAME);
		viewsList.verifyResourceTypeResourceAndStatusType(RESOURCE_TYPE_NAME, RESOURCE_NAME, StatusTypeNames_1)
		.navigateToResourceDetail(RESOURCE_NAME);
		viewResourceDetail.verifyViewResourceDetailsPage()
		.verifyResourceInViewResourceDetailsPage(RESOURCE_NAME)
		.verifyStatusTypesUnderSection(StatusTypeNames_1, SECTION_1);
		navigateTo.statusTypes();
		statusTypes.editSectionOfStatusType(StatusTypeNames_2, SECTION_2);

		@SuppressWarnings("unchecked")
		ArrayList<String> Excluding_ST_Names_2 = (ArrayList<String>) CollectionUtils.subtract(StatusTypeNames_1, StatusTypeNames_2);

		navigateTo.particularView(VIEW_NAME);
		viewsList.verifyResourceTypeResourceAndStatusType(RESOURCE_TYPE_NAME, RESOURCE_NAME, StatusTypeNames_1)
		.navigateToResourceDetail(RESOURCE_NAME);
		viewResourceDetail.verifyViewResourceDetailsPage()
		.verifyResourceInViewResourceDetailsPage(RESOURCE_NAME)
		.verifyStatusTypesUnderSection(Excluding_ST_Names_2, SECTION_1);
		login.logOut();
		Result = "PASS";
	}

	@Test(groups = {"HappyDay", "Viewing And Managing EMResource Entities On The 'View' Interface", "HappyDay70181"}, priority = 2)
	public void HappyDay70181() throws Exception {

		TCID = "70181";
		TC_DESCRIPTION = "Verify that resource detail view can be configured from resource detail screen.";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		viewsList = new View(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		viewResourceDetail = new ViewResourceDetail(this.driver);

		statusTypeData = new StatusTypeData();
		resourceData = new ResourceData();
		usersData = new UsersData();
		viewData= new ViewData();
		resourceTypeData = new ResourceTypeData();
		rolesData = new RolesData();
		userDataCreation = usersData.new UsersCreateData();
		rolesDataCreation = rolesData.new RolesCreateData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		viewDataCreation = viewData.new ViewCreateData();


		login.loginAsUser(USER_1, UsersData.PASSWORD);

		navigateTo.particularView(VIEW_NAME);
		viewsList.verifyResourceTypeResourceAndStatusType(RESOURCE_TYPE_NAME, RESOURCE_NAME, StatusTypeNames_1)
		.navigateToResourceDetail(RESOURCE_NAME);

		@SuppressWarnings("unchecked")
		ArrayList<String> Excluding_ST_Names_2 = (ArrayList<String>) CollectionUtils.subtract(StatusTypeNames_1, StatusTypeNames_2);

		viewResourceDetail.verifyViewResourceDetailsPage()
		.verifyResourceInViewResourceDetailsPage(RESOURCE_NAME)
		.verifyStatusTypesUnderSection(StatusTypeNames_2, SECTION_2)
		.verifyStatusTypesUnderSection(Excluding_ST_Names_2, SECTION_1);

		navigateTo.customizeViewResourceDetailScreen();
		viewUnderSetup.enterSectionName(viewDataCreation.section_2)
		.clickOnCreateSection()
		.moveStatusTypeToAnotherSection(StatusTypeNames_1, SECTION_1, viewDataCreation.section_2);

		viewResourceDetail.verifyViewResourceDetailsPage()
		.verifyResourceInViewResourceDetailsPage(RESOURCE_NAME)
		.verifyStatusTypesUnderSection(StatusTypeNames_1, viewDataCreation.section_2);

		login.logOut();

		Result = "PASS";
	}

	@Test(groups = {"HappyDay", "Viewing And Managing EMResource Entities On The 'View' Interface", "HappyDay99168"}, priority = 3)
	public void HappyDay99168() throws Exception {

		TCID = "99168";
		TC_DESCRIPTION = "Verify that a section can be created selecting an event related status type in the resource detail configuration screen.";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		statusTypes = new StatusTypes(this.driver);
		usersList = new UsersList(this.driver);
		viewsList = new View(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		eventManagement = new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		viewResourceDetail = new ViewResourceDetail(this.driver);

		statusTypeData = new StatusTypeData();
		resourceData = new ResourceData();
		usersData = new UsersData();
		viewData= new ViewData();
		resourceTypeData = new ResourceTypeData();
		userDataCreation = usersData.new UsersCreateData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		viewDataCreation = viewData.new ViewCreateData();
		eventSetUpData = new EventSetUpData();
		eventSetupDataCreation=eventSetUpData.new EventSetUpCreateData();
		eventData = new EventData();
		eventSetUpData = new EventSetUpData();
		eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();

		 String username			= userDataCreation.name1,
				fullName			= userDataCreation.fullName1,
				eventTemplate		= eventSetupDataCreation.name,
				eventName			= eventDataCreation.name,
				resourceType_Value	= "";
		VIEW_NAME = viewDataCreation.name1;

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);

		navigateTo.statusTypes();
		statusTypes.createEventStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.eventNst, statusTypeDataCreation.description,SECTION_1);
		eventStatusTypeValue_1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.eventNst));

		statusTypes.createEventStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.eventMst, statusTypeDataCreation.description,SECTION_1);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR);
		eventStauses.add(statusTypes .getStatusesValue(statusTypeDataCreation.statusesName));
		eventStauses.add(statusTypes .getStatusesValue(statusTypeDataCreation.statusesName1));
		statusTypes.clickOnReturnToStatusTypeList();
		eventStatusTypeValue_1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.eventMst));

		statusTypes.createEventStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.eventTst, statusTypeDataCreation.description,viewDataCreation.section);
		eventStatusTypeValue_1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.eventTst));

		statusTypes.createEventStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.eventNdst, statusTypeDataCreation.description,viewDataCreation.section);
		eventStatusTypeValue_1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.eventNdst));

		statusTypes.createEventStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.eventSst,statusTypeDataCreation.description,viewDataCreation.section);
		eventStatusTypeValue_1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.eventSst));

		statusTypes.createEventStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.eventDst,statusTypeDataCreation.description,viewDataCreation.section);
		eventStatusTypeValue_1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.eventDst));
		eventStatusTypeNames_1.addAll(Arrays.asList(statusTypeDataCreation.eventNst, statusTypeDataCreation.eventMst, statusTypeDataCreation.eventTst, statusTypeDataCreation.eventNdst, statusTypeDataCreation.eventSst, statusTypeDataCreation.eventDst));

		navigateTo.resourceType();
		resourceTypes.addStatusTypesToResourceType(RESOURCE_TYPE_NAME, eventStatusTypeNames_1);
		resourceType_Value = resourceTypes.getResourceTypeValue(RESOURCE_TYPE_NAME);

		navigateTo.users();
		usersList.createUserWithUpdateRightOnResource(username, UsersData.INITIAL_PASSWORD, fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, RESOURCE_NAME)
		.provideSetUpStatusTypesRight()
		.provideMaintainEventsRightAndSave();

		navigateTo.eventSetUp();
		eventSetUp.createEventTemplate(eventSetupDataCreation.name, eventSetupDataCreation.definition, resourceType_Value, eventStatusTypeValue_1);

		login.logOut()
		.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.eventManagment();
		eventManagement.createEvent(eventTemplate, eventName, eventDataCreation.description, RESOURCE_NAME)
		.clickOnEventBanner(eventName)
		.verifyEventStatusPage();
		viewsList.verifyResourceTypeResourceAndStatusType(RESOURCE_TYPE_NAME, RESOURCE_NAME, eventStatusTypeNames_1);

		navigateTo.viewUnderSetup();
		viewUnderSetup.createNewSection(viewDataCreation.section_3);

		navigateTo.statusTypes();
		statusTypes.editSectionOfStatusType(eventStatusTypeNames_1, viewDataCreation.section_3);

		eventManagement.clickOnEventBanner(eventName)
		.verifyEventStatusPage();
		viewsList.verifyResourceTypeResourceAndStatusType(RESOURCE_TYPE_NAME, RESOURCE_NAME, eventStatusTypeNames_1);
		viewsList.navigateToResourceDetail(RESOURCE_NAME);
		viewResourceDetail.verifyViewResourceDetailsPage()
		.verifyResourceInViewResourceDetailsPage(RESOURCE_NAME)
		.verifyStatusTypesUnderSection(StatusTypeNames_1, viewDataCreation.section_3);

		login.logOut();
		Result = "PASS";
	}

	@Test(groups = {"HappyDay", "Viewing And Managing EMResource Entities On The 'View' Interface", "HappyDay135643"}, priority = 4)
	public void HappyDay135643() throws Exception {

		TCID = "135643";
		TC_DESCRIPTION = "Verify that traffic can be viewed by selecting 'traffic' on the map displayed on 'View Resource Detail' page";

		resourceTypeData 	= new ResourceTypeData();
		resourceData 		= new ResourceData();
		statusTypeData		= new StatusTypeData();
		usersData = new UsersData();
		userDataCreation = usersData.new UsersCreateData();

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		map = new Map(this.driver);
		usersList = new UsersList(this.driver);
		viewResourceDetail = new ViewResourceDetail(this.driver);

		String username			= userDataCreation.name2,
				fullName			= userDataCreation.fullName2;

		ArrayList<String> StatusTypeNames = new ArrayList<String>();
		StatusTypeNames.addAll(Arrays.asList(statusTypeData.Role_NST_In_Region,
				statusTypeData.Role_MST_In_Region, statusTypeData.Role_SST_In_Region,
				statusTypeData.Role_TST_In_Region, statusTypeData.Role_NEDOCST_In_Region,
				statusTypeData.Role_DST_In_Region));

		String resourceName_2 = resourceData.resource_Name1_In_Region;

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		
		navigateTo.users();
		usersList.createUserWithUpdateRightOnResource(username, UsersData.INITIAL_PASSWORD, fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceName_2)
		.provideConfigureRegionViewsRightAndSave();
		
		login.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.map();
		map.openViewResourceDetailPage(resourceName_2);
		viewResourceDetail.verifyResourceInViewResourceDetailsPage(resourceName_2)
			.verifyTrafficInMap()
			.verifyMapAndSatelliteInMap();
		
		login.logOut();
		Result = "PASS";
	}
}