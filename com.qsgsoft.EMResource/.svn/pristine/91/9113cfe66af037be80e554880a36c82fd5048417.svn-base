package RequirementGroups.SettingUpResources;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import EMR.pages.StatusChangePreferences;
import EMR.data.EventData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
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
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
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

public class UserAssignmentForViewingTheResourceAndStatusTypes extends Configuration {

	public UserAssignmentForViewingTheResourceAndStatusTypes() throws Exception {
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
	EventData eventData;
	EventCreateData eventCreateData;
	EventSetUpData eventSetUpData;
	EventSetUpCreateData eventSetUpCreateData;

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
	EventSetUp eventSetUp;
	EventManagement eventManagement;
	Map map;
	StatusChangePreferences statusChangePreferences;
	
	static ArrayList<String> ADD_ST_VALUE_RESOURCETYPE_LEVEL = new ArrayList<String>();

	static ArrayList<String> USER_NAME = new ArrayList<String>();
	static ArrayList<String> RESOURCE_NAME = new ArrayList<String>();

	
	
	@Test (priority=1,groups = {"HappyDay", "Setting Up Resources","User Assignment for viewing the resource and status types", "HappyDay49205"})
	public void HappyDay49205() throws Exception {
 
		TCID = "49205";
		TC_DESCRIPTION = "Verify that when the 'View Resource' right on a resource is removed for a user, the user cannot "
				+ "add the resource to his/her custom view.";
		
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
		
		 login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.TESTREGION);
		 navigateTo.viewUnderSetup();
		 viewUnderSetup.createNewSection(viewDataCreation.section_1);
		 navigateTo.statusTypes();
		 statusTypes.createStatusType(StatusTypeData.NUMBERTYPE,statusTypeDataCreation.nstName1,statusTypeDataCreation.description,viewDataCreation.section_1);
		 ADD_ST_VALUE_RESOURCETYPE_LEVEL.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName1));
		 navigateTo.resourceType();
		 resourceTypes.createResourceType(resourceTypeDataCreation.name1,ADD_ST_VALUE_RESOURCETYPE_LEVEL);
		 navigateTo.resources();
		 resources.createResourceWithAddress(resourceCreateData.name1,resourceCreateData.abbrevation1, resourceTypeDataCreation.name1,ResourceData.STANDARDRESOURCETYPE, 
		 				ResourceData.FIRSTNAME,ResourceData.LASTNAME, ResourceData.STREETADDRESS,ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,ResourceData.COUNTY);
		 navigateTo.users();
		 usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(usersCreateData.name, UsersData.INITIAL_PASSWORD,usersCreateData.fullName, UsersData.PRIMARY_EMAILID,
						UsersData.PRIMARY_EMAILID)
						.provideConfigureRegionalUserAccessRight()
						.provideSetupResourcesAddAndEditRight()
						.provideViewCustomViewRightAndSave();
		 navigateTo.resources();
		 resources.deselectViewResourceRightForResourceForCorrespondingUser(resourceCreateData.name1, usersCreateData.name);
		 login.logOut();
		   
		 login.loginAsNewUser(usersCreateData.name, UsersData.INITIAL_PASSWORD,UsersData.PASSWORD);
		 view.verifyResourceAreNotRetrivedInCustomizedView(resourceCreateData.name1,resourceTypeDataCreation.name1); 
		 login.logOut();
		
		 RESOURCE_NAME.add(resourceCreateData.name1);
		 USER_NAME.add(usersCreateData.name);
		 
		Result = "PASS";

		}
	
	@Test (priority=2,groups = {"HappyDay", "Setting Up Resources","User Assignment for viewing the resource and status types", "HappyDay49806"})
	public void HappyDay49806() throws Exception {
 
		TCID = "49806";
		TC_DESCRIPTION = " Verify that a user CANNOT be saved by selecting only the 'Update Status'/'Run Reports'/'"
				+ "Associated With' right on a resource without the ‘View Resource’ right.";
		
		/* Data used from HappyDay49205
		 * 1) RESOURCE_NAME
		 * 2) USER_NAME ->ConfigureRegionalUserAccessOption and SetupResourcesAddAndEdit rights
		 */
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		regionList = new RegionList(this.driver);
		resources = new Resources(this.driver);
		shared = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		 
		login.loginAsUser(usersCreateData.name,UsersData.PASSWORD);
		navigateTo.resources();
		resources.verifyOnlyUpdateStatusRightSelectedForResourceCorrespondingToUserIsNotSaved(RESOURCE_NAME.get(0),USER_NAME.get(0)) 
		 		.verifyOnlyRunReportsRightSelectedForResourceCorrespondingToUserIsNotSaved(RESOURCE_NAME.get(0),USER_NAME.get(0)) 
		 		.verifyOnlyAssociatedWithRightSelectedForResourceCorrespondingToUserIsNotSaved(RESOURCE_NAME.get(0),USER_NAME.get(0))	
		 		.verifyAllThreeRightSelectedExpectViewResourceRightForResourceCorrespondingToUserIsNotSaved(RESOURCE_NAME.get(0),USER_NAME.get(0))
		 		.verifyAllThreeRightSelectedIncludingViewResourceRightForResourceCorrespondingToUserIsSaved(RESOURCE_NAME.get(0),USER_NAME.get(0));
		navigateTo.users();
		usersList.verifyAllTheRightsAreSelectedCorrespondingToResource(RESOURCE_NAME.get(0),USER_NAME.get(0));
		navigateTo.resources();
		resources.verifyUserWithViewResourceAndUpdateStatusRightIsSaved(RESOURCE_NAME.get(0),USER_NAME.get(0)) 
		 		.verifyUserWithViewResourceAndRunReportsRightIsSaved(RESOURCE_NAME.get(0),USER_NAME.get(0))
		 		.verifyUserWithViewResourceAndAssociatedWithRightIsSaved(RESOURCE_NAME.get(0),USER_NAME.get(0)); 
		login.logOut();
		 
		Result = "PASS";

	}
	
/*	@Test (priority=3,groups = {"HappyDay", "Setting Up Resources","User Assignment for viewing the resource and status types", "HappyDay102572"})
	public void HappyDay102572() throws Exception {
 
		TCID = "102572";
		TC_DESCRIPTION = " For a resource, verify that status types can be refined for a user.";
	
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
		eventData = new EventData();
		eventCreateData = eventData.new EventCreateData();
		eventSetUpData = new EventSetUpData();
		eventSetUpCreateData =eventSetUpData.new EventSetUpCreateData();

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
		eventManagement = new EventManagement(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		statusChangePreferences = new EMR.pages.StatusChangePreferences(this.driver);
		
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.TESTREGION);
		navigateTo.viewUnderSetup();
		viewUnderSetup.createNewSection(viewDataCreation.section_1);
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE,statusTypeDataCreation.nstName1,statusTypeDataCreation.description,viewDataCreation.section_1)
		   .createStatusType(StatusTypeData.TEXTTYPE,statusTypeDataCreation.tstName1,statusTypeDataCreation.description,viewDataCreation.section_1);
		
		STATUSTYPE_VALUE.addAll(Arrays.asList(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName1),statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName1)));
		STATUSTYPE_NAME.addAll(Arrays.asList(statusTypeDataCreation.nstName1,statusTypeDataCreation.tstName1));
		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name1,ADD_ST_VALUE_RESOURCETYPE_LEVEL);
		
		RESOURCE_TYPE_VALUE.add(resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name1));
		RESOURCE_TYPE_NAME.add(resourceTypeDataCreation.name1);
		
		navigateTo.resources();
		resources.createResourceWithAddress(resourceCreateData.name1,resourceCreateData.abbrevation1, resourceTypeDataCreation.name1,ResourceData.STANDARDRESOURCETYPE, 
		 				ResourceData.FIRSTNAME,ResourceData.LASTNAME, ResourceData.STREETADDRESS,ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,ResourceData.COUNTY)
		   .createResourceWithAddress(resourceCreateData.name2,resourceCreateData.abbrevation2, resourceTypeDataCreation.name1,ResourceData.STANDARDRESOURCETYPE, 
		 				ResourceData.FIRSTNAME,ResourceData.LASTNAME, ResourceData.STREETADDRESS,ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,ResourceData.COUNTY);
		
		RESOURCE_VALUE.addAll(Arrays.asList(resources.getResourceValue(resourceCreateData.name1),resources.getResourceValue(resourceCreateData.name2)));
		RESOURCE_NAME.addAll(Arrays.asList(resourceCreateData.name1,resourceCreateData.name2));
		
		navigateTo.viewUnderSetup();
		viewUnderSetup.createView(viewDataCreation.name1, viewDataCreation.description1, RESOURCE_VALUE, STATUSTYPE_VALUE);
		navigateTo.eventSetUp();
		eventSetUp.createEventTemplate(eventSetUpCreateData.name1, eventSetUpCreateData.definition1, RESOURCE_TYPE_VALUE, STATUSTYPE_VALUE);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(usersCreateData.name1, UsersData.INITIAL_PASSWORD, usersCreateData.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
			.provideEditStatusChangeNotificationPreferences()
			.provideViewCustomViewRightAndSave();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(usersCreateData.name2, UsersData.INITIAL_PASSWORD, usersCreateData.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
		 	.provideMaintainEventsRight()
			.provideSetupResourcesAddAndEditRightAndSave();
		login.logOut();
		
		login.loginAsNewUser(usersCreateData.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.views();
		view.createCustomView(RESOURCE_NAME, RESOURCE_VALUE, STATUSTYPE_VALUE);
		login.logOut();
		
		login.loginAsNewUser(usersCreateData.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.eventManagment();
		eventManagement.createEvent(eventSetUpCreateData.name1, eventCreateData.name1, eventCreateData.description1, RESOURCE_VALUE);
		navigateTo.resources();
		//resources.refineStatusTypeForUserForParticularResource(resource,userName,statusType); - new function
		//->this.clickOnUsersLinkAndNavigateToAssignUsersPage(resource);
		//->this.refineStatusTypeForUserFormAssignUserToParticularResource(resource); - new function
		//      ->this.clickOnRefineForParticularUser(userName);	- new function
		//		->this.deselectStatusTypeFromRefinePopup(statusType);	- new function
		//		->this.clickOnSaveChange();	- new function
		//		->this.clickOnSave();
		login.logOut();
		
		login.loginAsUser(usersCreateData.name1, UsersData.PASSWORD);
		navigateTo.views();
		navigateTo.particularView(viewDataCreation.name1);
		
		ArrayList<String> values = new ArrayList<String>(Arrays.asList("N/A","--"));
		
		//view.verifyStatusTypeValueDisplayedInRegularView(resourceTypeDataCreation.name1, RESOURCE_NAME.get(0), STATUSTYPE_NAME, values.get(0)) -new function
	 	//.verifyStatusTypeValueDisplayedInRegularView(resourceTypeDataCreation.name1, RESOURCE_NAME.get(1), STATUSTYPE_NAME, values.get(1));
		navigateTo.customView();
		view.verifyStatusTypeValueDisplayedInCustomView(resourceTypeDataCreation.name1, RESOURCE_NAME.get(0), STATUSTYPE_NAME, values.get(0))
	 	.verifyStatusTypeValueDisplayedInCustomView(resourceTypeDataCreation.name1, RESOURCE_NAME.get(1), STATUSTYPE_NAME, values.get(1));
		 map.clickOnShowMapAndVerifyStatusTypesOnPopUpWindow(resourceCreateData.name1, STATUSTYPE_NAME)
		 	.openResourceOnMapAndVerifyResourceAndStatusTypes(resourceCreateData.name1,STATUSTYPE_NAME.get(1))
		 	.openResourceOnMapAndVerifyNoStatusTypesDisplayed(resourceCreateData.name2, STATUSTYPE_NAME.get(0));
		 navigateTo.map();
		 map.openResourceOnMapAndVerifyResourceAndStatusTypes(resourceCreateData.name1,STATUSTYPE_NAME)
		 	.openResourceOnMapAndVerifyResourceAndStatusTypes(resourceCreateData.name1,STATUSTYPE_NAME.get(1))
		 	.openResourceOnMapAndVerifyNoStatusTypesDisplayed(resourceCreateData.name2, STATUSTYPE_NAME.get(0));
		 eventManagement.clickOnEventBanner(eventCreateData.name1);
		 //eventManagement.verifyStatusTypeValueDisplayedInEventStatus(resourceTypeDataCreation.name1, RESOURCE_NAME.get(0), STATUSTYPE_NAME, values.get(0)) -new function
		 //eventManagement.verifyStatusTypeValueDisplayedInEventStatus(resourceTypeDataCreation.name1, RESOURCE_NAME.get(1), STATUSTYPE_NAME, values.get(1));
		 view.navigateToResourceDetail(resourceCreateData.name1);
		 //view.verifyStatusTypeDisplayedInViewResourceDetail(resourceName,statusType); -new function
		 //view.verifyStatusTypeDisplayedInNotViewResourceDetail(resourceName,statusType); -new function
		 eventManagement.clickOnEventBanner(eventCreateData.name1);
		//view.verifyStatusTypeDisplayedInViewResourceDetail(resourceName,statusType); 
		 
		 String rs=RESOURCE_NAME.get(0);
		 rs=rs.substring(14, 20);
		 
		 statusChangePreferences.setStatusChangeNotifications(rs, RESOURCE_VALUE, RESOURCE_TYPE_NAME);
		 statusChangePreferences.expandAndverifyStatusTypesUnderSection(STATUSTYPE_NAME.get(1), viewDataCreation.section_1);
		 statusChangePreferences.expandAndverifyStatusTypesNotUnderSection(STATUSTYPE_NAME.get(0), viewDataCreation.section_1);
		 statusChangePreferences.clickOnSave();
		 statusChangePreferences.expandAndverifyStatusTypesUnderSection(STATUSTYPE_NAME.get(1), viewDataCreation.section_1);
		 statusChangePreferences.expandAndverifyStatusTypesUnderSection(STATUSTYPE_NAME.get(0), viewDataCreation.section_1);
		 
		Result = "PASS";

	}*/
}
