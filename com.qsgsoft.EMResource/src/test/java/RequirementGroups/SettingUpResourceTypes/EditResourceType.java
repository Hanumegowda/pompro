package RequirementGroups.SettingUpResourceTypes;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import EMR.data.EventData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.LoginData;
import EMR.data.OtherRegionData;
import EMR.data.RegionData;
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
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.ConfigureNewRelationship;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
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
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewResourceDetail;
import EMR.pages.ViewsUnderSetup;

public class EditResourceType extends Configuration {

	public EditResourceType() throws Exception {
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
	EventData eventData;
	EventCreateData eventCreateData;
	OtherRegionData otherRegionData;


	Login login;
	UsersList usersList;
	SelectRegion selectRegion;
	RegionDefault regionDefault;
	Shared navigateTo;
	RegionList regionList;
	StatusChangePreferences statusChangePreferences;
	RolesList rolesList; 
	View viewsList;
	ViewsUnderSetup viewUnderSetup;
	OtherRegionList otherRegionList;
	ConfigureNewRelationship configurRelationShip;
	EventSetUp eventSetUp;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	EventManagement eventManagement;
	OtherRegionList OtherRegionList;
	Map map;
	ViewResourceDetail viewResourceDetail;

	static ArrayList<String> StatusTypeNames = new ArrayList<String>();
	static ArrayList<String> STValue = new ArrayList<String>();
	static ArrayList<String> STValueAtResourceTypeLevel = new ArrayList<String>();
	static ArrayList<String> STValueAtResourceLevel = new ArrayList<String>();
	static ArrayList<String> RSValue = new ArrayList<String>();
	static String RTValue;
	static ArrayList<String> StatusTypeName1 = new ArrayList<String>();
	static ArrayList<String> StatusTypeName2 = new ArrayList<String>();
	static ArrayList<String> StatusTypeName3 = new ArrayList<String>();
	static String SectionName;
	static String ViewName;
	static String RTName;
	static ArrayList<String> StatusTypeNames1 = new ArrayList<String>();
	static ArrayList<String> STValue1 = new ArrayList<String>();
	static ArrayList<String> StatusTypeName4 = new ArrayList<String>();
	static ArrayList<String> StatusTypeName5 = new ArrayList<String>();
	static ArrayList<String> StatusType4Value = new ArrayList<String>();
	static ArrayList<String> StatusType5Value = new ArrayList<String>();
	static String RSName;
	static ArrayList<String> StatusTypeNames2 = new ArrayList<String>();
	static ArrayList<String> STValue2 = new ArrayList<String>();
	static ArrayList<String> StatusTypeName6 = new ArrayList<String>();
	static ArrayList<String> StatusType6Value = new ArrayList<String>();
	static String EventName;
	static String UserName;

	@Test (groups = {"HappyDay", "Setting Up ResourceTypes", "HappyDay103818"})
	public void HappyDay103818() throws Exception {

		TCID = "103818";
		TC_DESCRIPTION = "Verify that a resource type can be edited.";

		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		regionData = new RegionData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData(); 
		resourceData = new ResourceData();
		resourceDataCreation = resourceData.new ResourceCreateData();
		eventSetUpData = new EventSetUpData();
		eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		eventData = new EventData();
		eventCreateData = eventData.new EventCreateData();
		loginData = new LoginData();
		regionData = new RegionData();
		regionCreateData =regionData.new RegionCreateData();
		usersData = new UsersData();
		userDataCreation =usersData.new UsersCreateData();


		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		viewsList = new View(this.driver);
		statusTypes = new StatusTypes(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		usersList = new UsersList(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);

		navigateTo.views();
		viewUnderSetup.createNewSection(viewDataCreation.section_1);
		SectionName=viewDataCreation.section_1;

		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.dateName, statusTypeDataCreation.description, viewDataCreation.section_1)
		.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description, viewDataCreation.section_1)
		.createStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.nedocsName, statusTypeDataCreation.description, viewDataCreation.section_1);
		STValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.dateName));
		STValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName));
		STValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nedocsName));

		STValueAtResourceTypeLevel.add(STValue.get(0));
		STValueAtResourceTypeLevel.add(STValue.get(1));
		STValueAtResourceLevel.add(STValue.get(2));
		StatusTypeNames.addAll(Arrays.asList(statusTypeDataCreation.dateName,statusTypeDataCreation.nstName,
				statusTypeDataCreation.nedocsName));

		StatusTypeName1.add(StatusTypeNames.get(0));
		StatusTypeName2.add(StatusTypeNames.get(1));
		StatusTypeName3.add(StatusTypeNames.get(2));

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, STValueAtResourceTypeLevel);
		RTValue = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);

		navigateTo.resources();
		resources.createResourceWithAddress(resourceDataCreation.name1, resourceDataCreation.abbrevation1,
				resourceTypeDataCreation.name, ResourceData.STANDARDRESOURCETYPE, 
				ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, 
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resources.selectStatusTypesForResource(resourceDataCreation.name1,STValueAtResourceLevel);
		RSValue.add(resources.getResourceValue(resourceDataCreation.name1));
		RSName = resourceDataCreation.name1;

		navigateTo.eventSetUp();
		eventSetUp.createEventTemplateDeselectingWebOption(eventSetupDataCreation.name, eventSetupDataCreation.definition, RTValue, STValue);

		navigateTo.views();
		viewUnderSetup.createView(viewDataCreation.name1, viewDataCreation.description, resourceDataCreation.name1, StatusTypeNames);
		ViewName = viewDataCreation.name1;

		navigateTo.users();
		usersList.createUserWithUpdateRightOnSigleResourceMantainEventRightCustomViewRightAndSave(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.EMAILID1, UsersData.EMAILID2, resourceDataCreation.name1);
		UserName = userDataCreation.name;

		login.logOut()
		.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);


		navigateTo.eventManagment();
		eventManagement.createEvent(eventSetupDataCreation.name, eventCreateData.name, eventCreateData.description, resourceDataCreation.name1);
		EventName = eventCreateData.name;
		
		navigateTo.customView();
		viewsList.createCustomView(resourceDataCreation.name1, RSValue, STValue);

		login.logOut()
		.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);

		navigateTo.resourceType();
		resourceTypes.editResorceTypeMandatoryDataDeselectAndSelectStatusTypesAndSave(resourceTypeDataCreation.name, resourceTypeDataCreation.edited_name, STValueAtResourceTypeLevel,STValueAtResourceLevel);
		RTName = resourceTypeDataCreation.edited_name;

		navigateTo.particularView(viewDataCreation.name1);
		viewsList.verifyStatusTypesNotDispalyedUnderParticularView(resourceTypeDataCreation.edited_name, StatusTypeName2)
		.verifyResourceTypeAndStatusType(resourceTypeDataCreation.edited_name, StatusTypeName3);

		login.logOut()
		.loginAsUser(userDataCreation.name, UsersData.PASSWORD);

		navigateTo.customView();
		viewsList.verifyStatusTypesNotDispalyedUnderParticularView(resourceTypeDataCreation.name,StatusTypeName2)
		.verifyResourceTypeAndStatusTypesUnderCustomView(resourceTypeDataCreation.name, StatusTypeName3);

		eventManagement.clickOnEventBanner(eventCreateData.name)
		.verifyStatusTypesNotDisplayedUnderEventStatus(eventCreateData.name, resourceTypeDataCreation.edited_name, StatusTypeName2)
		.verifyResourceTypeAndStatusTypesUnderEventStatus(eventCreateData.name, resourceTypeDataCreation.edited_name, StatusTypeName3);

		login.logOut();
	}

	@Test (dependsOnMethods ={"HappyDay103818"} , groups = {"HappyDay", "Setting Up ResourceTypes", "HappyDay100307"})
	public void HappyDay100307() throws Exception {

		TCID = "100307";
		TC_DESCRIPTION = "Verify that a status type deselected from a resource type is no longer displayed on the View screen.";

		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		regionData = new RegionData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData(); 
		resourceData = new ResourceData();
		resourceDataCreation = resourceData.new ResourceCreateData();
		eventSetUpData = new EventSetUpData();
		eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		eventData = new EventData();
		eventCreateData = eventData.new EventCreateData();
		loginData = new LoginData();
		regionData = new RegionData();
		regionCreateData =regionData.new RegionCreateData();
		usersData = new UsersData();
		userDataCreation =usersData.new UsersCreateData();

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		viewsList = new View(this.driver);
		statusTypes = new StatusTypes(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		usersList = new UsersList(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		viewResourceDetail = new ViewResourceDetail(this.driver);
		map = new Map(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);

		navigateTo.statusTypes();
		statusTypes.CreateStatusTypeSelectingResourcetype(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName1, statusTypeDataCreation.description, 
				SectionName, RTValue);
		statusTypes.CreateStatusTypeSelectingResourcetype(StatusTypeData.TEXTTYPE, statusTypeDataCreation.tstName1, statusTypeDataCreation.description, 
				SectionName, RTValue);
		STValue1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName1));
		STValue1.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName1));
		StatusType5Value.add(STValue1.get(1));
		StatusTypeNames1.addAll(Arrays.asList(statusTypeDataCreation.nstName1,statusTypeDataCreation.tstName1));

		StatusTypeName4.add(StatusTypeNames1.get(0));
		StatusTypeName5.add(StatusTypeNames1.get(1));

		navigateTo.resourceType();
		resourceTypes.editResourceTypeAndSelectStatusTypes(RTName, STValue1);

		navigateTo.viewUnderSetup();
		viewUnderSetup.editViewAndSelectStatusTypes(ViewName, StatusTypeNames1);

		navigateTo.particularView(ViewName);
		viewsList.verifyResourceTypeAndStatusType(RTName, StatusTypeNames1);

		navigateTo.resourceType();
		resourceTypes.removeStatusTypesFromResourceType(RTName, StatusType5Value);

		navigateTo.particularView(ViewName);
		viewsList.verifyStatusTypesNotDispalyedUnderParticularView(RTName, StatusTypeName5)
		.verifyResourceTypeAndStatusType(RTName, StatusTypeName4);

		viewsList.navigateToResourceDetail(RSName);
		viewResourceDetail.verifyStatusTypesNotDispalyedUnderSectionOfViewResourceDetailScreen(StatusTypeName5, SectionName)
		.verifyStatusTypesDispalyedUnderSectionOfViewResourceDetailScreen(StatusTypeName4, SectionName);

		navigateTo.map();
		map.selectResourceNameInFindResourceDropdown(RSName)
		.verifyStatusTypeNotListedInStatusTypeDropdown(StatusTypeName5)
		.verifyStatusTypesInPopupWindow(StatusTypeName4);

	}

	@Test (dependsOnMethods ={"HappyDay103818"} , groups = {"HappyDay", "Setting Up ResourceTypes", "HappyDay69417"})
	public void HappyDay69417() throws Exception {

		TCID = "69417";
		TC_DESCRIPTION = "Verify that newly added status types for a resource type are updated on the View screen. ";

		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		regionData = new RegionData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData(); 
		resourceData = new ResourceData();
		resourceDataCreation = resourceData.new ResourceCreateData();
		eventSetUpData = new EventSetUpData();
		eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		eventData = new EventData();
		eventCreateData = eventData.new EventCreateData();
		loginData = new LoginData();
		regionData = new RegionData();
		regionCreateData =regionData.new RegionCreateData();
		usersData = new UsersData();
		userDataCreation =usersData.new UsersCreateData();

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		viewsList = new View(this.driver);
		statusTypes = new StatusTypes(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		usersList = new UsersList(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		viewResourceDetail = new ViewResourceDetail(this.driver);
		map = new Map(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);

		navigateTo.statusTypes();
		statusTypes.CreateStatusTypeSelectingResourcetype(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName2, statusTypeDataCreation.description, 
				SectionName, RTValue);
		STValue2.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName2));
		StatusType5Value.add(STValue2.get(0));
		StatusType5Value.add(STValueAtResourceTypeLevel.get(0));
		StatusTypeNames2.addAll(Arrays.asList(statusTypeDataCreation.nstName2,StatusTypeNames.get(0)));

		StatusTypeName6.add(StatusTypeNames2.get(0));

		navigateTo.resourceType();
		resourceTypes.editResourceTypeAndSelectStatusTypes(RTName, StatusType5Value);

		navigateTo.viewUnderSetup();
		viewUnderSetup.editViewAndSelectStatusTypes(ViewName, StatusTypeNames2);

		navigateTo.particularView(ViewName);
		viewsList.verifyResourceTypeAndStatusType(RTName, StatusTypeNames2);

		navigateTo.map();
		map.selectResourceNameInFindResourceDropdown(RSName)
		.verifyStatusTypesInPopupWindow(StatusTypeNames2);

	}

	@Test (dependsOnMethods ={"HappyDay103818"} , groups = {"HappyDay", "Setting Up ResourceTypes","Inactivate resource type" ,"HappyDay102889"})
	public void HappyDay102889() throws Exception {

		TCID = "102889";
		TC_DESCRIPTION = "Deactivate a resource type and verify that the resource type and the resource under it is not displayed on the following screens:"
				+ "1. View"
				+ "2. Map"
				+ "3. Event Detail"
				+ "4. Custom View ";

		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData(); 
		resourceData = new ResourceData();
		resourceDataCreation = resourceData.new ResourceCreateData();
		eventSetUpData = new EventSetUpData();
		eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		eventData = new EventData();
		eventCreateData = eventData.new EventCreateData();
		loginData = new LoginData();
		usersData = new UsersData();
		userDataCreation =usersData.new UsersCreateData();

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		viewsList = new View(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		usersList = new UsersList(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		viewResourceDetail = new ViewResourceDetail(this.driver);
		map = new Map(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);

		navigateTo.resourceType();
		resourceTypes.deActivateResourceType(RTName);

		navigateTo.particularView(ViewName);
		viewsList.verifyResourceTypeAndResourceNotDisplayed(RTName, RSName);

		navigateTo.map();
		map.verifyResourceIsNotFindresourceDropDown(RSName);

		login.logOut()
		.loginAsUser(UserName, UsersData.PASSWORD);

		eventManagement.clickOnEventBanner(EventName)
		.verifyResourceAndResourcetypeIsNotDisplayedOnEventStatus(RTName, RSName);

		navigateTo.customView();
		viewsList.verifyResourceTypeAndResourceNotDisplayed(RTName, RSName)
		.verifyResourceAreNotRetrivedInCustomizedView(RTName, RSName);
	}

	@Test (dependsOnMethods ={"HappyDay102889"} , groups = {"HappyDay", "Setting Up ResourceTypes","Inactivate resource type" ,"HappyDay102899"})
	public void HappyDay102899() throws Exception {

		TCID = "102889";
		TC_DESCRIPTION = "Reactivate a resource type and verify that the resource type and the resource under it is displayed on the following views:"
				+ "1. View"
				+ "2. Map"
				+ "3. Event Detail";

		/***
		 * login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);
			navigateTo.resourceType();[resource available in HappyDay102899]
			resourceTypes.reActivateResourceType();--new

			navigateTo.particularView(ViewName);
			viewsList.verifyResourceTypeAndResource(_resourceType, _resource)

			navigateTo.map();
			map.verifyStatusTypesInPopupWindow(statusTypesName);

			eventManagement.clickOnEventBanner(eventCreateData.name)
			.eventManagement.verifyResourceIsDisplayedForParticularResourceType(resourceTypeName, resourceName);

		 */

	}


}
