package RequirementGroups.SettingUpResources;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.Login;
import EMR.pages.Map;
import EMR.pages.RegionList;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewsUnderSetup;
import qaFramework.Configurations.Configuration;

public class EditStatusTypesAtResourceLevel extends Configuration {

	public EditStatusTypesAtResourceLevel() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginData loginData;
	ResourceTypeData resourceTypeData;
	ResourceData resourceData;
	ResourceCreateData resourceCreateData;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceTypeCreateData resourceTypeDataCreation;
	UsersData userdatData;
	UsersCreateData usersCreateData;
	ViewData viewData;
	ViewCreateData viewDataCreation;

	RegionList regionList;
	Login login;
	Shared navigateTo;
	SelectRegion selectRegion;
	ViewsUnderSetup viewUnderSetup;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	Shared shared;
	UsersList usersList;
	View view;
	Map map;

	static ArrayList<String> STATUS_TYPE_VALUE_RESOURCE_TYPE_LEVEL = new ArrayList<String>();
	static ArrayList<String> STATUS_TYPE_VALUE_RESOURCE_LEVEL = new ArrayList<String>();
	static ArrayList<String> RESOURCE_TYPE_VALUE = new ArrayList<String>();
	static ArrayList<String> RESOURCE_TYPE_NAME = new ArrayList<String>();
	static ArrayList<String> RESOURCE_VALUE = new ArrayList<String>();
	static ArrayList<String> RESOURCE_NAME = new ArrayList<String>();
	static ArrayList<String> USER_NAME = new ArrayList<String>();
	static ArrayList<String> STATUS_TYPE_VALUE = new ArrayList<String>();
	static ArrayList<String> STATUS_TYPE_NAME_RESOURCE_TYPE_LEVEL = new ArrayList<String>();
	static ArrayList<String> STATUS_TYPE_NAME_RESOURCE_LEVEL = new ArrayList<String>();
	static ArrayList<String> STATUS_TYPE_NAME = new ArrayList<String>();
	static ArrayList<String> ADD_ST_VALUE_TO_RT1 = new ArrayList<String>();
	static ArrayList<String> ADD_ST_VALUE_TO_RT2 = new ArrayList<String>();
	static ArrayList<String> ST_VALUE = new ArrayList<String>();
	static ArrayList<String> ADD_RS_VALUE = new ArrayList<String>();
	static ArrayList<String> ADD_RS_NAME = new ArrayList<String>();



	@Test(priority=1,groups = { "HappyDay", "Setting Up Resources",
			"Edit status types at resource level", "HappyDay49988" })
	public void HappyDay49988() throws Exception {

		TCID = "49988";
		TC_DESCRIPTION = "Verify that a user with ‘Setup Resource Type’ right can add the status types at the "
				+ "resource level.";

		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		userdatData = new UsersData();
		usersCreateData = userdatData.new UsersCreateData();
		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		regionList = new RegionList(this.driver);
		statusTypes = new StatusTypes(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		shared = new Shared(this.driver);
		usersList = new UsersList(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,
				RegionData.TESTREGION);
		navigateTo.viewUnderSetup();
		viewUnderSetup.createNewSection(viewDataCreation.section_1);
		navigateTo.statusTypes();
		statusTypes
				.createStatusType(StatusTypeData.NUMBERTYPE,
						statusTypeDataCreation.nstName,
						statusTypeDataCreation.description,
						viewDataCreation.section_1)
				.createStatusType(StatusTypeData.MULTITYPE,
						statusTypeDataCreation.mstName,
						statusTypeDataCreation.description,
						viewDataCreation.section_1)
				.createNewStatus(statusTypeDataCreation.statusesName,
						StatusTypeData.STATUS_PURPLE_COLOR)
				.createNewStatus(statusTypeDataCreation.statusesName1,
						StatusTypeData.STATUS_PURPLE_COLOR);
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.TEXTTYPE,
				statusTypeDataCreation.tstName,
				statusTypeDataCreation.description, viewDataCreation.section_1);

		STATUS_TYPE_VALUE_RESOURCE_TYPE_LEVEL.addAll(Arrays.asList(statusTypes
				.getStatusTypeValue(statusTypeDataCreation.nstName),statusTypes
				.getStatusTypeValue(statusTypeDataCreation.mstName)));
		STATUS_TYPE_VALUE_RESOURCE_LEVEL.add(statusTypes
				.getStatusTypeValue(statusTypeDataCreation.tstName));
		STATUS_TYPE_VALUE.addAll(Arrays.asList(statusTypes
				.getStatusTypeValue(statusTypeDataCreation.nstName),statusTypes
				.getStatusTypeValue(statusTypeDataCreation.mstName),statusTypes
				.getStatusTypeValue(statusTypeDataCreation.tstName)));
		
		STATUS_TYPE_NAME_RESOURCE_TYPE_LEVEL.addAll(Arrays.asList(statusTypeDataCreation.nstName,statusTypeDataCreation.mstName));
		STATUS_TYPE_NAME_RESOURCE_LEVEL.add(statusTypeDataCreation.tstName);
		STATUS_TYPE_NAME.addAll(Arrays.asList(statusTypeDataCreation.nstName,statusTypeDataCreation.mstName,statusTypeDataCreation.tstName));
		
		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name,
				STATUS_TYPE_VALUE_RESOURCE_TYPE_LEVEL);
		RESOURCE_TYPE_VALUE.add(resourceTypes
				.getResourceTypeValue(resourceTypeDataCreation.name));
		RESOURCE_TYPE_NAME.add(resourceTypeDataCreation.name);

		navigateTo.resources();
		resources.createResourceWithAddress(resourceCreateData.name1,
				resourceCreateData.abbrevation1, resourceTypeDataCreation.name,
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME,
				ResourceData.LASTNAME, ResourceData.STREETADDRESS,
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,
				ResourceData.COUNTY);
		RESOURCE_VALUE
				.add(resources.getResourceValue(resourceCreateData.name1));
		RESOURCE_NAME.add(resourceCreateData.name1);

		navigateTo.users();
		usersList
				.createUserWithMandatoryDetailsWithRoleWithoutSave(
						usersCreateData.name, UsersData.INITIAL_PASSWORD,
						usersCreateData.fullName, UsersData.PRIMARY_EMAILID,
						UsersData.PRIMARY_EMAILID)
				.provideSetupResourceTypesRight()
				.provideViewCustomViewRight()
				.provideSetupResourcesAddAndEditRightAndSave();
		login.logOut();

		login.loginAsNewUser(usersCreateData.name, UsersData.INITIAL_PASSWORD,
				UsersData.PASSWORD);
		navigateTo.resources();
		resources
				.verifyStatusTypesAddedAtResourceTypeLevelAreSelectedAndDisabled(
						RESOURCE_NAME.get(0),
						STATUS_TYPE_VALUE_RESOURCE_TYPE_LEVEL)
				.verifyStatusTypeAreUncheckedAndEnabled(
						STATUS_TYPE_VALUE_RESOURCE_LEVEL)
				.addStatusTypeFromResourceLevel(
						STATUS_TYPE_VALUE_RESOURCE_LEVEL)
				.verifyStatusTypeAreSelectedAndEnabled(RESOURCE_NAME.get(0),
						STATUS_TYPE_VALUE_RESOURCE_LEVEL);
		login.logOut();
		
		USER_NAME.add(usersCreateData.name);
		
		Result = "PASS";

	}
	
	@Test(priority=2,groups = { "HappyDay", "Setting Up Resources",
			"Edit status types at resource level", "HappyDay36746" })
	public void HappyDay36746() throws Exception {

		TCID = "36746";
		TC_DESCRIPTION = "Add a status type to a resource and verify that changing the resource type of the resource does "
				+ "not change the resource level status types.";
		
		/*Data used from HappyDay49988
		 * 1) USER_NAME -> SetupResourceTypesRight and SetupResourcesAddAndEditRight
		 * 2) STATUS_TYPE_VALUE
		 */
		
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		userdatData = new UsersData();
		usersCreateData = userdatData.new UsersCreateData();
		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		regionList = new RegionList(this.driver);
		statusTypes = new StatusTypes(this.driver); 
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		shared = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		
		ADD_ST_VALUE_TO_RT1.addAll(Arrays.asList(STATUS_TYPE_VALUE.get(0),STATUS_TYPE_VALUE.get(2)));
		ADD_ST_VALUE_TO_RT2.addAll(Arrays.asList(STATUS_TYPE_VALUE.get(1),STATUS_TYPE_VALUE.get(2)));
		ST_VALUE.add(STATUS_TYPE_VALUE.get(1));
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.TESTREGION);
		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name1,ADD_ST_VALUE_TO_RT1)
					.createResourceType(resourceTypeDataCreation.name2,ADD_ST_VALUE_TO_RT2);
		navigateTo.resources();
		resources.createResourceWithAddress(resourceCreateData.name1,resourceCreateData.abbrevation1, resourceTypeDataCreation.name1,ResourceData.STANDARDRESOURCETYPE, 
		 				ResourceData.FIRSTNAME,ResourceData.LASTNAME, ResourceData.STREETADDRESS,ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,ResourceData.COUNTY);		
		navigateTo.resources();
		resources.clickOnStatusTypesLink(resourceCreateData.name1)
				.addStatusTypeFromResourceLevel(ST_VALUE)
				.changeTheResourceType(resourceCreateData.name1,resourceTypeDataCreation.name2);
		login.logOut();
		 
		  
		login.loginAsUser(USER_NAME.get(0),UsersData.PASSWORD);
		navigateTo.resources();
		resources.verifyStatusTypesAreSelectedAndDisabledAndSave(resourceCreateData.name1,ADD_ST_VALUE_TO_RT2);
		login.logOut();	
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.TESTREGION);
		navigateTo.resources();
		resources.changeTheResourceType(resourceCreateData.name1,resourceTypeDataCreation.name1);
		resources.verifyStatusTypeAreSelectedAndEnabledAndSave(resourceCreateData.name1,ST_VALUE);
		login.logOut();
		
		login.loginAsUser(USER_NAME.get(0),UsersData.PASSWORD);
		navigateTo.resources();
		resources.verifyStatusTypesAreSelectedAndDisabledAndSave(resourceCreateData.name1,ADD_ST_VALUE_TO_RT1);
		resources.verifyStatusTypeAreSelectedAndEnabledAndSave(resourceCreateData.name1,ST_VALUE);			
		login.logOut();		
		 
		Result = "PASS";

	}
	
/*	@Test(groups = { "HappyDay", "Setting Up Resources",
			"Edit status types at resource level", "HappyDay36784" })
	public void HappyDay36784() throws Exception {

		TCID = "36784";
		TC_DESCRIPTION = "Add a status type to resource RS and verify that a user with “Update Status” right on the resource RS,"
				+ " “Must Update Overdue Status” right and the role to update the status type ST is prompted to update the status "
				+ "of ST on login.";
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.TESTREGION);
		navigateTo.viewUnderSetup();
		viewUnderSetup.createNewSection(viewDataCreation.section_1);
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE,statusTypeDataCreation.nstName1,statusTypeDataCreation.description,viewDataCreation.section_1)
					.createStatusType(StatusTypeData.MULTITYPE,statusTypeDataCreation.mstName1,statusTypeDataCreation.description,viewDataCreation.section_1)
					.createStatusType(StatusTypeData.TEXTTYPE,statusTypeDataCreation.tstName1,statusTypeDataCreation.description,viewDataCreation.section_1)
					.createStatusType(StatusTypeData.SATURATIONSCORETYPE,statusTypeDataCreation.sstName1,statusTypeDataCreation.description,viewDataCreation.section_1)
					.createStatusType(StatusTypeData.NEDOCSTYPE,statusTypeDataCreation.nedocsName1,statusTypeDataCreation.description,viewDataCreation.section_1)
					.createStatusType(StatusTypeData.DATETYPE,statusTypeDataCreation.dateName1,statusTypeDataCreation.description,viewDataCreation.section_1);
		ADD_ST_VALUE_RESOURCETYPE_LEVEL.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName1));
		ADD_ST_VALUE_RESOURCE_LEVEL.addAll(Arrays.asList(statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName1),
				statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName1),
				statusTypes.getStatusTypeValue(statusTypeDataCreation.sstName1),
				statusTypes.getStatusTypeValue(statusTypeDataCreation.nedocsName1),
				statusTypes.getStatusTypeValue(statusTypeDataCreation.dateName1)));
		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name1,ADD_ST_VALUE_RESOURCE_LEVEL);

		navigateTo.resources();
		resources.createResourceWithAddress(resourceCreateData.name1,resourceCreateData.abbrevation1, resourceTypeDataCreation.name1,ResourceData.STANDARDRESOURCETYPE, 
		 				ResourceData.FIRSTNAME,ResourceData.LASTNAME, ResourceData.STREETADDRESS,ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,ResourceData.COUNTY);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(usersCreateData.name, UsersData.INITIAL_PASSWORD,usersCreateData.fullName, UsersData.PRIMARY_EMAILID,
						UsersData.PRIMARY_EMAILID)
				.provideSetupResourceTypesRight()
				.provideSetupResourcesAddAndEditRightAndSave();	
		
		usersList.createUserWithUpdateRightOnResource(usersCreateData.name1, UsersData.INITIAL_PASSWORD, usersCreateData.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceCreateData.name1);
				//.provideUserMustUpdateOverdueStatusRightAndSave(); -> new function
		login.logOut();
		
		login.loginAsNewUser(usersCreateData.name, UsersData.INITIAL_PASSWORD,UsersData.PASSWORD);
		navigateTo.resources();
		resources.selectStatusTypesAtResourceLevel(ADD_ST_VALUE_RESOURCE_LEVEL);
		login.logOut();
		
		login.loginAsNewUser(usersCreateData.name, UsersData.INITIAL_PASSWORD,UsersData.PASSWORD);
		//.verifyOverdueStatusPageIsDisplayed();  -> new function
		//.verifyResourceLevelSelectedStatusTypesAreDisplayedForCorrespondingResource(resourceCreateData.name1,ADD_ALL_ST_VALUE_RESOURCE_LEVEL); -> new function
		   //->.verifyResourceLevelSelectedStatusTypesAreDisplayedForCorrespondingResource(resourceCreateData.name1,ADD_ST_VALUE_RESOURCE_LEVEL); -> new function
		   //->.verifyResourceTypeLevelSelectedStatusTypesAreDisplayedForCorrespondingResource(resourceCreateData.name1,ADD_ST_VALUE_RESOURCETYPE_LEVEL); -> new function
		//.updateAllStatustypeFromOverdueStatusPage(resourceCreateData.name1,ADD_ST_VALUE_RESOURCE_LEVEL); -> new function
		//.verifyUpdatedStatusTypeDisplayAppropriateValue(resourceCreateData.name1,ADD_ST_VALUE_RESOURCE_LEVEL); -> new function
		login.logOut();
		
		Result = "PASS";

	} */
	
	@Test(priority=3,groups = { "HappyDay", "Setting Up Resources",
			"Edit status types at resource level", "HappyDay36781" })
	public void HappyDay36781() throws Exception {

		TCID = "36781";
		TC_DESCRIPTION = "Add a status type to resource RS and verify that custom view can be created selecting newly added "
				+ "status type and resource RS.";
		
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		resourceData = new ResourceData();
		resourceCreateData = resourceData.new ResourceCreateData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		userdatData = new UsersData();
		usersCreateData = userdatData.new UsersCreateData();
		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		regionList = new RegionList(this.driver);
		statusTypes = new StatusTypes(this.driver); 
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		shared = new Shared(this.driver);
		usersList = new UsersList(this.driver);	
		view = new View(this.driver);
		map = new Map(this.driver);
		
	
		 login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.TESTREGION);
		 navigateTo.resources();
		 resources.createResourceWithAddress(resourceCreateData.name2,resourceCreateData.abbrevation1, RESOURCE_TYPE_NAME.get(0),ResourceData.STANDARDRESOURCETYPE, 
		 				ResourceData.FIRSTNAME,ResourceData.LASTNAME, ResourceData.STREETADDRESS,ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,ResourceData.COUNTY);
		
		 ADD_RS_VALUE.addAll(Arrays.asList(RESOURCE_VALUE.get(0),resources.getResourceValue(resourceCreateData.name2)));
		 ADD_RS_NAME.addAll(Arrays.asList(RESOURCE_NAME.get(0),resourceCreateData.name2));
		
		 login.logOut();
		 
		 ArrayList<String> values = new ArrayList<String>(Arrays.asList("--","N/A"));
		 
		 login.loginAsUser(USER_NAME.get(0),UsersData.PASSWORD);
		 
		 String rs=ADD_RS_NAME.get(0);
		 rs=rs.substring(0, 2);
		 
		 view.createCustomizedViewFromPreferences(rs, ADD_RS_VALUE, STATUS_TYPE_VALUE)
		 	.verifyStatusTypeValueDisplayedInCustomView(RESOURCE_TYPE_NAME.get(0), ADD_RS_NAME.get(0), STATUS_TYPE_NAME_RESOURCE_LEVEL, values.get(0))
		 	.verifyStatusTypeValueDisplayedInCustomView(RESOURCE_TYPE_NAME.get(0), ADD_RS_NAME.get(1), STATUS_TYPE_NAME_RESOURCE_LEVEL, values.get(1));
		 map.clickOnShowMapAndVerifyStatusTypesOnPopUpWindow(ADD_RS_NAME.get(0), STATUS_TYPE_NAME)
		 	.openResourceOnMapAndVerifyResourceAndStatusTypes(ADD_RS_NAME.get(0),STATUS_TYPE_NAME_RESOURCE_TYPE_LEVEL)
		 	.openResourceOnMapAndVerifyNoStatusTypesDisplayed(ADD_RS_NAME.get(1), STATUS_TYPE_NAME_RESOURCE_LEVEL);
		 login.logOut();
		
	Result = "PASS";

	}
	
}
