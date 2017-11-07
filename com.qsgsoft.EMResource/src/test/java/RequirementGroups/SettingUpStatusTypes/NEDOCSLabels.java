package RequirementGroups.SettingUpStatusTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.RolesData.RolesCreateData;
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

public class NEDOCSLabels extends Configuration {

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

	// Initializing ,Declaring variables for HappyDay162668
	static String USERNAME, VIEW_NAME, SECTION, RESOURCE_NAME, RESOURCE_VALUE,
	RESORCE_TYPE_NAME;
	static ArrayList<String> NEDOCS_STATUS_TYPES_VALUES = new ArrayList<String>();
	static ArrayList<String> NEDOCS_STATUS_TYPES_NAMES = new ArrayList<String>();

	// Initializing and Declaring variables for HappyDay119620
	static ArrayList<String> NEDOCS_STATUS_TYPES_VALUES_1 = new ArrayList<String>();
	static ArrayList<String> NEDOCS_STATUS_TYPES_NAME_1 = new ArrayList<String>();

	public NEDOCSLabels() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(groups = { "HappyDay", "Setting Up StatusTypes", "HappyDay162668" })
	public void HappyDay162668() throws Exception {

		TCID = "162668";
		TC_DESCRIPTION = "Verify that NEDOC labels are NOT displayed on the view screens corresponding to the calculated scores "
				+ "when 'Display NEDOCS labels' checkbox is deselected for the NEDOCS status type ";

		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		resourceData = new ResourceData();
		resourceDataCreation = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		updateStatusData = new UpdateStatusData();
		updateStatusCreateData = updateStatusData.new UpdateStatusCreateData();

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
		view = new ViewsUnderSetup(this.driver);
		views = new View(this.driver);

		String resourceValue = new String();

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,
				RegionData.REGIONNAME);
		navigateTo.views();
		viewUnderSetup.createNewSection(viewDataCreation.section);
		SECTION = viewDataCreation.section;

		navigateTo.statusTypes();
		statusTypes.createNedocsStatusTypeDeselectingDisplayLabels(
				StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.nedocsName,
				statusTypeDataCreation.description, SECTION);

		NEDOCS_STATUS_TYPES_VALUES.add(statusTypes
				.getStatusTypeValue(statusTypeDataCreation.nedocsName));
		NEDOCS_STATUS_TYPES_NAMES.add((statusTypeDataCreation.nedocsName));

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name,
				NEDOCS_STATUS_TYPES_VALUES);

		navigateTo.resources();
		resources.createResourceWithAddress(resourceDataCreation.name,
				resourceDataCreation.abbrevation1,
				resourceTypeDataCreation.name,
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME,
				ResourceData.LASTNAME, ResourceData.STREETADDRESS,
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,
				ResourceData.COUNTY);
		resourceValue = resources.getResourceValue(resourceDataCreation.name);

		navigateTo.users();
		usersList
		.createUserWithUpdateRightOnResource(userDataCreation.name,UsersData.INITIAL_PASSWORD, userDataCreation.fullName,UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID,resourceDataCreation.name)
		.provideSetupResourcesAddAndEditRight()
		.provideSetupResourceTypesRight()
		.provideSetUpStatusTypesRightAndSave();

		navigateTo.views();
		view.createView(viewDataCreation.name, viewDataCreation.description,resourceDataCreation.name, NEDOCS_STATUS_TYPES_NAMES);
		login.logOut();

		login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD,
				UsersData.PASSWORD);
		navigateTo.particularView(viewDataCreation.name);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(resourceDataCreation.name);

		updateStatus
		.selectStatusTypesToUpdate(NEDOCS_STATUS_TYPES_VALUES.get(0))
		.enterNedocsUpdateValue(NEDOCS_STATUS_TYPES_VALUES.get(0),UpdateStatusData.NEDOCS_VALUES_TO_UPDATE1)
		.saveAndNavigateToUpdatedPage();
		views.verifyUpdatedNedocsDoesNotIncludesDisasterTextInViewPage(resourceValue, NEDOCS_STATUS_TYPES_VALUES.get(0),UpdateStatusData.CALCULATED_NEDOCS_SCORE1);

		login.logOut();
		Result = "PASS";
		USERNAME = userDataCreation.name;
		VIEW_NAME = viewDataCreation.name;
		RESOURCE_NAME = resourceDataCreation.name;
		RESOURCE_VALUE = resourceValue;
		RESORCE_TYPE_NAME = resourceTypeDataCreation.name;
	}

	@Test(dependsOnMethods = { "HappyDay162668" }, groups = { "HappyDay",
			"Setting Up StatusTypes", "HappyDay162667" })
	public void HappyDay162667() throws Exception {

		TCID = "162667";
		TC_DESCRIPTION = "Verify that NEDOC labels are displayed on the view screens corresponding to the calculated scores when"
				+ "'Display NEDOCS labels' checkbox is selected for the NEDOCS status type";

		login = new Login(this.driver);
		statusTypes = new StatusTypes(this.driver);
		navigateTo = new Shared(this.driver);
		views = new View(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,
				RegionData.REGIONNAME);
		navigateTo.statusTypes();
		statusTypes.editNedocsStatusTypeAndSelectDisplayLabels(NEDOCS_STATUS_TYPES_NAMES.get(0));
		login.logOut();
		login.loginAsUserAndAcknowledgeWebNotification(USERNAME,UsersData.PASSWORD);
		navigateTo.particularView(VIEW_NAME);
		views.verifyUpdatedNedocsIncludesDisasterTextInViewPage(RESOURCE_VALUE,NEDOCS_STATUS_TYPES_VALUES.get(0),UpdateStatusData.CALCULATED_NEDOCS_SCORE1);
		login.logOut();
		Result = "PASS";
	}

	@Test(dependsOnMethods = { "HappyDay162668" }, groups = { "HappyDay",
			"Setting Up StatusTypes", "HappyDay131411" })
	public void HappyDay131411() throws Exception {

		TCID = "131411";
		TC_DESCRIPTION = "Verify that 'Display NEDOCS labels' checkbox is selected by default on 'Create NEDOCS Calculation Status Type' page";

		// Verification part of 'Display NEDOCS labels' checkbox is selected by
		// default on 'Create NEDOCS Calculation Status Type' page by admin user
		// is covered in HappyDay162668;

		login = new Login(this.driver);
		statusTypes = new StatusTypes(this.driver);
		navigateTo = new Shared(this.driver);

		login.loginAsUserAndAcknowledgeWebNotification(USERNAME,UsersData.PASSWORD);
		navigateTo.statusTypes();
		statusTypes.verifyDisplayNEDOCSLabelsIsSelectedByDefaultWhileCreatingNedocsStatusTypes(StatusTypeData.NEDOCSTYPE);
		login.logOut();
		Result = "PASS";
	}

	@Test(dependsOnMethods = { "HappyDay162667" }, groups = { "HappyDay",
			"Setting Up StatusTypes", "HappyDay162669" })
	public void HappyDay162669() throws Exception {

		TCID = "162669";
		TC_DESCRIPTION = "Verify that 'Display NEDOCS labels' checkbox is selected by default on 'Create NEDOCS Calculation Status Type' page";

		login = new Login(this.driver);
		statusTypes = new StatusTypes(this.driver);
		navigateTo = new Shared(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		view = new ViewsUnderSetup(this.driver);
		views = new View(this.driver);
		regionDefault = new RegionDefault(this.driver);
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		HashMap<String, String> nedocsUpdatedValues = new HashMap<String, String>();

		// Using ResourceType,Section,Resource ,View and User from script
		// HappyDay162668;

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,
				RegionData.REGIONNAME);

		// Creating Shared and Private Nedocs
		navigateTo.statusTypes();
		statusTypes.createSharedStatusType(StatusTypeData.NEDOCSTYPE,statusTypeDataCreation.sharedNEDOC_1,statusTypeDataCreation.description, SECTION);
		statusTypes.createPrivateStatusType(StatusTypeData.NEDOCSTYPE,statusTypeDataCreation.privateNedocST,statusTypeDataCreation.description, SECTION);
		NEDOCS_STATUS_TYPES_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNEDOC_1));
		NEDOCS_STATUS_TYPES_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.privateNedocST));
		NEDOCS_STATUS_TYPES_NAMES.addAll(Arrays.asList(statusTypeDataCreation.sharedNEDOC_1,statusTypeDataCreation.privateNedocST));

		navigateTo.resourceType();
		resourceTypes.addStatusTypesToResourceType(RESORCE_TYPE_NAME,NEDOCS_STATUS_TYPES_VALUES);

		navigateTo.views();
		view.verifyAndAddStatusTypesToExsistingView(VIEW_NAME,NEDOCS_STATUS_TYPES_NAMES);
		login.logOut();

		login.loginAsUserAndAcknowledgeWebNotification(USERNAME,UsersData.PASSWORD);
		navigateTo.particularView(VIEW_NAME);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);

		updateStatus
		.selectStatusTypesToUpdate(NEDOCS_STATUS_TYPES_VALUES.get(0))
		.enterNedocsUpdateValue(NEDOCS_STATUS_TYPES_VALUES.get(0),UpdateStatusData.NEDOCS_VALUES_TO_UPDATE1)

		.selectStatusTypesToUpdate(NEDOCS_STATUS_TYPES_VALUES.get(1))
		.enterNedocsUpdateValue(NEDOCS_STATUS_TYPES_VALUES.get(1),UpdateStatusData.NEDOCS_VALUES_TO_UPDATE2)
		.selectStatusTypesToUpdate(NEDOCS_STATUS_TYPES_VALUES.get(2))
		.enterNedocsUpdateValue(NEDOCS_STATUS_TYPES_VALUES.get(2),UpdateStatusData.NEDOCS_VALUES_TO_UPDATE3)
		.verifyDisasterLabelAfterClickOnCalculate(NEDOCS_STATUS_TYPES_VALUES.get(2))
		.saveAndNavigateToUpdatedPage();

		navigateTo.particularView(VIEW_NAME);
		nedocsUpdatedValues.put(NEDOCS_STATUS_TYPES_VALUES.get(0),UpdateStatusData.CALCULATED_NEDOCS_SCORE1);
		nedocsUpdatedValues.put(NEDOCS_STATUS_TYPES_VALUES.get(1),UpdateStatusData.CALCULATED_NEDOCS_SCORE2);
		nedocsUpdatedValues.put(NEDOCS_STATUS_TYPES_VALUES.get(2),UpdateStatusData.CALCULATED_NEDOCS_SCORE3);

		views.verifyUpdatedNedocsStatusTypesIncludesDisasterTextInViewPage(RESOURCE_VALUE, nedocsUpdatedValues);

		navigateTo.statusTypes();
		statusTypes.editNedocsStatusTypesAnddeSelectDisplayLabels(NEDOCS_STATUS_TYPES_NAMES);

		navigateTo.particularView(VIEW_NAME);
		regionDefault
		.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);

		updateStatus
		.selectStatusTypesToUpdate(NEDOCS_STATUS_TYPES_VALUES.get(0))
		.enterNedocsUpdateValue(NEDOCS_STATUS_TYPES_VALUES.get(0),UpdateStatusData.NEDOCS_VALUES_TO_UPDATE3)
		.selectStatusTypesToUpdate(NEDOCS_STATUS_TYPES_VALUES.get(1)).enterNedocsUpdateValue(NEDOCS_STATUS_TYPES_VALUES.get(1),UpdateStatusData.NEDOCS_VALUES_TO_UPDATE1)
		.selectStatusTypesToUpdate(NEDOCS_STATUS_TYPES_VALUES.get(2)).enterNedocsUpdateValue(NEDOCS_STATUS_TYPES_VALUES.get(2),UpdateStatusData.NEDOCS_VALUES_TO_UPDATE2)
		.saveAndNavigateToUpdatedPage();

		nedocsUpdatedValues.put(NEDOCS_STATUS_TYPES_VALUES.get(0),UpdateStatusData.CALCULATED_NEDOCS_SCORE3);
		nedocsUpdatedValues.put(NEDOCS_STATUS_TYPES_VALUES.get(1),UpdateStatusData.CALCULATED_NEDOCS_SCORE1);
		nedocsUpdatedValues.put(NEDOCS_STATUS_TYPES_VALUES.get(2),UpdateStatusData.CALCULATED_NEDOCS_SCORE2);

		views.verifyUpdatedNedocsStatusTypesDoesNotIncludesDisasterTextInViewPage(RESOURCE_VALUE, nedocsUpdatedValues);

		navigateTo.statusTypes();
		statusTypes
		.editNedocsStatusTypesAnSelectDisplayLabels(NEDOCS_STATUS_TYPES_NAMES);

		navigateTo.particularView(VIEW_NAME);
		regionDefault
		.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);

		updateStatus
		.selectStatusTypesToUpdate(NEDOCS_STATUS_TYPES_VALUES.get(0))
		.enterNedocsUpdateValue(NEDOCS_STATUS_TYPES_VALUES.get(0),UpdateStatusData.NEDOCS_VALUES_TO_UPDATE2)
		.selectStatusTypesToUpdate(NEDOCS_STATUS_TYPES_VALUES.get(1))
		.enterNedocsUpdateValue(NEDOCS_STATUS_TYPES_VALUES.get(1),UpdateStatusData.NEDOCS_VALUES_TO_UPDATE3)
		.selectStatusTypesToUpdate(NEDOCS_STATUS_TYPES_VALUES.get(2))
		.enterNedocsUpdateValue(NEDOCS_STATUS_TYPES_VALUES.get(2),UpdateStatusData.NEDOCS_VALUES_TO_UPDATE1)
		.saveAndNavigateToUpdatedPage();

		nedocsUpdatedValues.put(NEDOCS_STATUS_TYPES_VALUES.get(0),UpdateStatusData.CALCULATED_NEDOCS_SCORE2);
		nedocsUpdatedValues.put(NEDOCS_STATUS_TYPES_VALUES.get(1),UpdateStatusData.CALCULATED_NEDOCS_SCORE3);
		nedocsUpdatedValues.put(NEDOCS_STATUS_TYPES_VALUES.get(2),UpdateStatusData.CALCULATED_NEDOCS_SCORE1);
		views.verifyUpdatedNedocsStatusTypesIncludesDisasterTextInViewPage(RESOURCE_VALUE,nedocsUpdatedValues);
		login.logOut();
		Result = "PASS";
	}

	@Test(dependsOnMethods = { "HappyDay162668" }, groups = { "HappyDay",
			"Setting Up StatusTypes", "Create NEDOC Score Status Types",
	"HappyDay131411" })
	public void HappyDay119620() throws Exception {

		TCID = "119620";
		TC_DESCRIPTION = "Verify that user can create NEDOC Score status type. ";

		login = new Login(this.driver);
		statusTypes = new StatusTypes(this.driver);
		navigateTo = new Shared(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);

		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		resourceData = new ResourceData();
		resourceDataCreation = resourceData.new ResourceCreateData();

		login.loginAsUserAndAcknowledgeWebNotification(USERNAME,UsersData.PASSWORD);
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NEDOCSTYPE,statusTypeDataCreation.nedocsName1,statusTypeDataCreation.description, SECTION);
		NEDOCS_STATUS_TYPES_VALUES_1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nedocsName1));
		NEDOCS_STATUS_TYPES_NAME_1.add(statusTypeDataCreation.nedocsName1);

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name1,NEDOCS_STATUS_TYPES_VALUES_1);

		navigateTo.resources();
		resources.createResourceByUser(resourceDataCreation.name1,
				resourceDataCreation.abbrevation1,
				resourceTypeDataCreation.name1,
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME,
				ResourceData.LASTNAME, ResourceData.STREETADDRESS,
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,
				ResourceData.COUNTY);
		resources.verifyStatusTypesAtResourceLevel(resourceDataCreation.name1,
				NEDOCS_STATUS_TYPES_NAME_1);
		login.logOut();
		Result = "PASS";
	}

	@Test(dependsOnMethods = { "HappyDay119620" }, groups = { "HappyDay",
			"Setting Up StatusTypes", "Create NEDOC Score Status Types",
	"HappyDay119714" })
	public void HappyDay119714() throws Exception {

		TCID = "119714";
		TC_DESCRIPTION = "Verify that user can edit NEDOCS status type.";

		login = new Login(this.driver);
		statusTypes = new StatusTypes(this.driver);
		navigateTo = new Shared(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);

		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		resourceData = new ResourceData();
		resourceDataCreation = resourceData.new ResourceCreateData();
		ArrayList<String> editedNedocsStatusTypeName = new ArrayList<String>();

		login.loginAsUserAndAcknowledgeWebNotification(USERNAME,
				UsersData.PASSWORD);
		navigateTo.statusTypes();
		statusTypes.editStatusTypeNameAndDescription(NEDOCS_STATUS_TYPES_NAME_1.get(0),statusTypeDataCreation.editNedocsName,statusTypeDataCreation.description2);
		editedNedocsStatusTypeName.add(statusTypeDataCreation.editNedocsName);

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name2,
				NEDOCS_STATUS_TYPES_VALUES_1);

		navigateTo.resources();
		resources.createResourceByUser(resourceDataCreation.name2,
				resourceDataCreation.abbrevation2,
				resourceTypeDataCreation.name2,
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME,
				ResourceData.LASTNAME, ResourceData.STREETADDRESS,
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,
				ResourceData.COUNTY);
		resources.verifyStatusTypesAtResourceLevel(resourceDataCreation.name2,editedNedocsStatusTypeName);
		login.logOut();
		Result = "PASS";
	}

	@Test(dependsOnMethods = { "HappyDay162668" }, groups = { "HappyDay",
			"Setting Up StatusTypes", "NEDOC and Saturation score calculation",
	"HappyDay120528" })
	public void HappyDay120528() throws Exception {

		TCID = "120528";
		TC_DESCRIPTION = "Verify that scores for 'Saturation score' and 'NEDOC' is calculated only when clicked on 'Calculate' button ";

		login = new Login(this.driver);
		statusTypes = new StatusTypes(this.driver);
		navigateTo = new Shared(this.driver);
		map = new Map(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		updateStatus = new UpdateStatus(this.driver);

		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();

		ArrayList<String> saturationStatusTypeValue = new ArrayList<String>();
		ArrayList<String> NEDOCS_AND_SATURATION_STATUSTYPES_NAMES = new ArrayList<String>();

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.SATURATIONSCORETYPE,statusTypeDataCreation.sstName,statusTypeDataCreation.description, SECTION);
		saturationStatusTypeValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.sstName));
		NEDOCS_AND_SATURATION_STATUSTYPES_NAMES.addAll(Arrays.asList(NEDOCS_STATUS_TYPES_NAMES.get(0),statusTypeDataCreation.sstName));

		navigateTo.resourceType();
		resourceTypes.addStatusTypesToResourceType(RESORCE_TYPE_NAME,saturationStatusTypeValue);
		login.logOut();

		login.loginAsUserAndAcknowledgeWebNotification(USERNAME,UsersData.PASSWORD);
		navigateTo.map();
		map.openResourceOnMapToUpdate(RESOURCE_NAME,NEDOCS_AND_SATURATION_STATUSTYPES_NAMES);

		updateStatus
		.selectStatusTypesToUpdate(NEDOCS_STATUS_TYPES_VALUES.get(0))
		.enterNedocsUpdateValue(NEDOCS_STATUS_TYPES_VALUES.get(0),UpdateStatusData.NEDOCS_VALUES_TO_UPDATE1)
		.verifyNedocsScoresShouldBeCalculatedOnlyAfterClickingOnCalculateButton(NEDOCS_STATUS_TYPES_VALUES.get(0),UpdateStatusData.CALCULATED_DISASTER_SCORE_241)
		.selectStatusTypesToUpdate(saturationStatusTypeValue.get(0))
		.enterUpdateSSTValues(saturationStatusTypeValue.get(0),UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE1)
		.verifySaturationScoresShouldBeCalculatedOnlyAfterClickingOnCalculateButton(saturationStatusTypeValue.get(0),UpdateStatusData.CALCULATED_SATURATION_SCORE_429)
		.saveAndNavigateToUpdatedPage();
		login.logOut();
		Result = "PASS";
	}
}