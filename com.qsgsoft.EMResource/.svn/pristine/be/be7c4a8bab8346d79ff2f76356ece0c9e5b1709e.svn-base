package RequirementGroups.SettingUpUsers;

import java.util.ArrayList;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import EMR.data.EventData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
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
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.ConfigureNewRelationship;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.Mails;
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
import EMR.pages.ViewsUnderSetup;

public class RightsToViewUpdateRoleBasedStatusTypes extends Configuration {

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
	RolesList roles;
	Mails mail;

	static String USER1,USER2,RESOURCE_NAME,VIEW,EVENT,RESOURCE_VALUE,RESOURCE_TYPE_NAME,RESOURCE_TYPE_VALUE,ROLE1_VALUE,ROLE2_VALUE,DEFAULT_ROLE_VALUE,SECTION;

	ArrayList<String> STATUSTYPE_VALUES= new ArrayList<String>();
	ArrayList<String> STATUSES_VALUES= new ArrayList<String>();
	ArrayList<String> STATUSTYPE_NAMES= new ArrayList<String>();
	ArrayList<String> UPDATED_STATUS= new ArrayList<String>();

	public RightsToViewUpdateRoleBasedStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(groups = {"HappyDay","Setting up users","HappyDay46284","EMResource v3.17"})
	public void HappyDay46284() throws Exception {

		TCID ="46284";
		TC_DESCRIPTION ="User A has role R1 where R1 has the view right for status type ST1 and view & update right for status type ST2. Role R2 has only view right for status type ST2 and not for ST1. Verify that when user A's role is changed from R1 to R2, user A:"+ 
				"1. Can only add status change preferences for ST2 and not for ST1"+ 
				"2. Can edit status change preferences for ST2 and not for ST1";

		/*viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
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

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
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
		roles = new RolesList(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);

		navigateTo.views();
		viewUnderSetup.createNewSection(viewDataCreation.section);
		SECTION=viewDataCreation.section;

		navigateTo.statusTypes();

		statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName,statusTypeDataCreation.description, SECTION);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName3, StatusTypeData.STATUS_PURPLE_COLOR);			
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName3));

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName4, StatusTypeData.STATUS_PURPLE_COLOR);			
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName4));
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName5, StatusTypeData.STATUS_PURPLE_COLOR);			
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName5));

		statusTypes.clickOnReturnToStatusTypeList();
		STATUSTYPE_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName));

		STATUSTYPE_NAMES.add(statusTypeDataCreation.mstName);

		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE,statusTypeDataCreation.nstName,statusTypeDataCreation.description,SECTION);
		STATUSTYPE_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName));
		STATUSTYPE_NAMES.add(statusTypeDataCreation.nstName);

		navigateTo.roles();
		roles.createRoleWithMandatoryDetailes(rolesDataCreation.name1).deSelectUpdateRight(ST1).save();..new  
		ROLE1_VALUE = rolesList.getRoleValue(rolesDataCreation.name1);    

		roles.createRoleWithMandatoryDetailes(rolesDataCreation.name2)
		.deSelectUpdateRight(ST2).deselectUpdateRight(ST21).deselectViewRight(ST1).save();..new
		ROLE2_VALUE = rolesList.getRoleValue(rolesDataCreation.name2);

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, STATUSES_VALUES);
		RESOURCE_TYPE_VALUE = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);
		RESOURCE_TYPE_NAME = resourceTypeDataCreation.name;

		navigateTo.resources();
		resources.createResourceWithAddress(
				resourceDataCreation.name, resourceDataCreation.abbrevation1,
				resourceTypeDataCreation.name, ResourceData.STANDARDRESOURCETYPE,
				ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, 
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		RESOURCE_VALUE=resources.getResourceValue(resourceDataCreation.name);
		RESOURCE_NAME=resourceDataCreation.name;

		navigateTo.roles();
		DEFAULT_ROLE_VALUE= roles.getDefaultRoleValueIfExists();
		navigateTo.users();

		usersList.createUserWithMandatoryDetailsAndEMailPager(userDataCreation.name1,UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID,ROLE1_VALUE,DEFAULT_ROLE_VALUE)
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

		USER1=userDataCreation.name1;

		usersList.searchUser(USER1).clickOnStatusChangeNotificationPreferences();

		statusChangePreferences.assignUserToStatusChangeNotifications(RESOURCE_NAME, RESOURCE_VALUE,USER1,RESOURCE_TYPE_NAME)
		.expandAndverifyStatusTypesUnderSection(STATUSTYPE_NAMES,SECTION)
		.provideReceiveStatusChangeNotificationsToNumberStatusType(RESOURCE_VALUE,STATUSTYPE_VALUES.get(0), StatusChangePreferncesData.ABOVE_VALUE_150, StatusChangePreferncesData.BELOW_VALUE_25)
		.provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(RESOURCE_VALUE,STATUSTYPE_VALUES.get(1), STATUSES_VALUES.get(0),  STATUSES_VALUES.get(1))
		.savePreferences();
		statusChangePreferences.verifyStatusTypesUnderResourceInStatusChangePreferncsPage(RESOURCE_NAME, STATUSTYPE_NAMES);

		login.logOut();   

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);

		navigateTo.users();
		usersList.editUserDeselectAllRolesAndSelectPerticulerRole(USER1,ROLE2_VALUE)--new
		         .searchUser(USER1)
		         .deselectAllRoles()
		         .selectRole(ROLE2_VALUE);         
		login.logOut(); 

		login.loginAsNewUser(USER1,UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.navigateToStatusChangePrefsUnderPreferences();

		statusChangePreferences.verifyMyStatusChangePreferencesPage() 
		.verifyStatusTypesUnderResourceInStatusChangePreferncsPage(RESOURCE_NAME, STATUSTYPE_NAMES)
		.verifyRetainedAboveAndBelowValuesOfNumberOrSaturationOrNedocsStatustype(STATUSTYPE_NAMES.get(0),StatusChangePreferncesData.ABOVE_VALUE_150, StatusChangePreferncesData.BELOW_VALUE_25)
		.verifyStatusTypesNotUnderResourceInStatusChangePreferncsPage(RESOURCE_NAME, STATUSTYPE_NAMES)

		.EditAndNavigateToEditMyStatusChangeNotifications(RESOURCE_NAME)
		.expandAndverifyStatusTypesUnderSection(STATUSTYPE_NAMES,SECTION)
		.expandAndverifyStatusTypesNotUnderSection(STATUSTYPE_NAMES,SECTION)
		.cancelPreferences()

		statusChangePreferences.verifyMyStatusChangePreferencesPage() 
		.verifyStatusTypesUnderResourceInStatusChangePreferncsPage(RESOURCE_NAME, STATUSTYPE_NAMES)
		.verifyRetainedAboveAndBelowValuesOfNumberOrSaturationOrNedocsStatustype(STATUSTYPE_NAMES.get(0),StatusChangePreferncesData.ABOVE_VALUE_150, StatusChangePreferncesData.BELOW_VALUE_25)
		.verifyStatusTypesNotUnderResourceInStatusChangePreferncsPage(RESOURCE_NAME, STATUSTYPE_NAMES)

		.setStatusChangeNotifications(RESOURCE_NAME,RESOURCE_VALUE,RESOURCE_TYPE_NAME)
		.expandAndverifyStatusTypesUnderSection(STATUSTYPE_NAMES,SECTION)
		.expandAndverifyStatusTypesNotUnderSection(STATUSTYPE_NAMES,SECTION)
		.cancelPreferences();
		login.logOut();
	}	 */  
	}


	@Test(dependsOnMethods={"HappyDay46284"},groups = {"HappyDay","Setting up users","HappyDay49204","EMResource v3.17"})
	public void HappyDay92597() throws Exception {

		TCID ="92597";
		TC_DESCRIPTION ="User A has role R1 where R1 has the view right for status type ST1 and view & update right for status"
				+ "type ST2. Role R2 has only view right for status type ST2 and not for ST1. Verify that when user A's role is "
				+ "changed from R1 to R2, user A can only view status type ST2 and not ST1 while adding status types to the custom "
				+ "view.";

		/*
		login = new Login(this.driver); 
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		view = new ViewsUnderSetup(this.driver);
		viewsList= new View(this.driver);
		regionDefault = new RegionDefault(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);
		navigateTo.users();
		usersList.editUserDeselectAllRolesAndSelectPerticulerRole(USER1,ROLE1_VALUE)
		login.logOut();

		login.loginAsUserAndAcknowledgeWebNotification(USER1,UsersData.PASSWORD);
	    navigateTo.navigateToCustomViewTable();
		viewsList.createCustomViewByCustomizeLink(RESOURCE_NAME,RESOURCE_VALUE,STATUSTYPE_VALUES);
		login.logOut();

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);
		navigateTo.users();
		usersList.editUserDeselectAllRolesAndSelectPerticulerRole(USER1,ROLE2_VALUE)
		login.logOut();

	    login.loginAsUserAndAcknowledgeWebNotification(USER1,UsersData.PASSWORD);

	   viewsList.verifyStatusTypesDisplayedUnderCustomViewTable(RESOURCE_TYPE_NAME,ST2)
	   .verifyStatusTypesNotDisplayedUnderCustomViewTable(RESOURCE_TYPE_NAME,ST1)
	   .clickOnCustomize()
	   .clickOptionsVerifyStatusTypesNotInEditCustomViewOptionsScreen(MULTI_STATUSTYPE_NAME);
	   login.logOut();   
	}	 */  
	}
	@Test(dependsOnMethods={"HappyDay92597"},groups = {"HappyDay","Setting up users","HappyDay49204","EMResource v3.17"})
	public void HappyDay49204() throws Exception {

		TCID ="49204";
		TC_DESCRIPTION ="User A has role R1 where R1 has the view right for status type ST1 and view & update right for status type ST2. Verify that when adding/editing status change preferences for user A from another user B, only ST1 and ST2 are displayed and no other status types are displayed.";

		/*v
		statusTypeData=new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		views= new View(this.driver);
		roles = new RolesList(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);
		navigateTo.statusTypes();

		statusTypes.createStatusType(StatusTypeData.TEXTTYPE,statusTypeDataCreation.tstName,statusTypeDataCreation.description,SECTION);
		STATUSTYPE_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName));
		STATUSTYPE_NAMES.add(statusTypeDataCreation.tstName);

		navigateTo.roles();

		roles.editRole(ROLE1_VALUE).selectBothTheRights(ST2).deselectUpdateRight(ST1).selectViewRight(ST1).save();..new

		roles.editRole(ROLE2_VALUE).selectBothTheRights(ST1).selectBothTheRights(ST2).selectBothTheRights(ST3).save();..new

	    navigateTo.users();
		usersList.editUserDeselectAllRolesAndSelectPerticulerRole(USER1,ROLE1_VALUE)--new

	    usersList.createUserWithMandatoryDetailsAndEMailPager(userDataCreation.name2,UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID,ROLE2_VALUE,DEFAULT_ROLE_VALUE)
		.provideConfigureRegionalUserAccessRightAndSave()

		USER2=userDataCreation.name2;

		navigateTo.resourceType();
		resourceTypes.addStatusTypesToResourceType(RESOURCE_TYPE_NAME,ST3);
	    login.logOut();   

	    login.loginAsNewUser(USER2,UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		usersList.searchUser(USER1).clickOnStatusChangeNotificationPreferences();

		statusChangePreferences.assignUserToStatusChangeNotifications(RESOURCE_NAME, RESOURCE_VALUE,USER1,RESOURCE_TYPE_NAME)
		.expandAndverifyStatusTypesUnderSection(ST1 and ST2,SECTION)
		.verifyStatusTypesNotDisplayedUnderSection(ST3,SECTION)..new
		 login.logOut();   
	}	 */  
	}	
	
	@Test(/*dependsOnMethods={"HappyDay92597"},*/groups = {"HappyDay","Setting up users","HappyDay49535","EMResource v3.17"})
	public void HappyDay49535() throws Exception {

		TCID ="49535";
		TC_DESCRIPTION ="User A has role R1 where R1 has the view right for status type ST1 and view & update right for status type ST2."+
				" Role R2 has only view right for status type ST2 and not for ST1. Verify that when user A's role is changed from R1 to R2,"+
				" the changes are reflected on following view screens:";


		/*
		statusTypeData=new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		views= new View(this.driver);
		roles = new RolesList(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);

		navigateTo.roles();

		roles.editRole(ROLE1_VALUE).selectBothTheRights(ST2).deselectUpdateRight(ST1).selectViewRight(ST1).save();..new

		roles.editRole(ROLE2_VALUE).deselectBothRights(ST1).selectViewRight(ST2).save();..new

		navigateTo.eventSetUp();
		eventSetUp.createEventTemplateDeselectingWebOption(eventSetupDataCreation.name,eventSetupDataCreation.definition,RESOURCE_TYPE_VALUE,STATUSTYPE_VALUES);

       navigateTo.views();   
	   view.createView(viewDataCreation.name,viewDataCreation.description,RESOURCE_NAME,STATUSTYPE_NAMES);
	   VIEW=viewDataCreation.name;
	   System.out.println(VIEW);
	   login.logOut();   

	   	login.loginAsUserAndAcknowledgeWebNotification(USER1,UsersData.PASSWORD);

	   	navigateTo.customView();
		viewsList.createCustomView(RESOURCE_NAME,RESOURCE_VALUE,STATUSTYPE_VALUES);
		 login.logOut(); 

       login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);

       navigateTo.users();
		usersList.editUserDeselectAllRolesAndSelectPerticulerRole(USER1,ROLE2_VALUE)
		login.logOut();

		login.loginAsUserAndAcknowledgeWebNotification(USER1,UsersData.PASSWORD);

		//Region view

		navigateTo.particularView(VIEW);
		viewsList.verifyStatusTypesUnderPerticulerView(RESOURCE_TYPE_NAME,MULTI_STATUSTYPE_NAME);

		navigateTo.map();
		map.openResourceOnMapAndVerifyResourceAndStatusTypes(RESOURCE_NAME,MULTI_STATUSTYPE_NAME)
		.verifyStatusTypeFromStatusTypeDropdown(MULTI_STATUSTYPE_NAME.get(0))
		.clickViewInfoOnMapAndNavigateToResourceDetailPage(RESOURCE_NAME);

		//Detail view

		viewResourceDetaile.verifyStatusTypesDispalyedUnderSectionOfViewResourceDetailScreen(MULTI_STATUSTYPE_NAME,SECTION);

		//custom view
		navigateTo.navigateToCustomViewTable();
		viewsList.verifyStatusTypesDisplayedUnderCustomViewTable(RESOURCE_TYPE_NAME,MULTI_STATUSTYPE_NAME);
		navigateTo.showOnMap();
		map.openResourceOnMapAndVerifyResourceAndStatusTypes(RESOURCE_NAME,MULTI_STATUSTYPE_NAME);
         login.logOut();


	}	 */  
	}

	@Test(/*dependsOnMethods={"HappyDay92597"},*/groups = {"HappyDay","Setting up users","HappyDay48631","EMResource v3.17"})
	public void HappyDay48631() throws Exception {

		TCID ="48631";
		TC_DESCRIPTION ="Verify that when a user is provided both ‘View Resource’ and 'Update Status' right on resource RS and a "
				+ "role for only viewing the associated status type ST (regardless of ST associated at the resource level/resource "
				+ "type level), then the user CAN only view but CANNOT update the status of ST.";

		/*
		statusTypeData=new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		views= new View(this.driver);
		roles = new RolesList(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);

		navigateTo.resourceType();
		resourceTypes.removeStatusTypesFromResourceType(RESOURCE_TYPE_NAME,MULTI_STATUSTYPE_VALUE);

		navigateTo.resources();
		resources.verifyAndAddStatusTypesAtResourceLevel(RESOURCE_NAME1,MULTI_STATUSTYPE_VALUE1);

	    login.logOut();   

	   	login.loginAsUserAndAcknowledgeWebNotification(USER1,UsersData.PASSWORD);

	   	usersList.createUserWithMandatoryDetailsAndEMailPager(userDataCreation.name1,UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID,ROLE1_VALUE,DEFAULT_ROLE_VALUE)
		.selectUpdateStatusOfResourceAndSave(RESOURCE_NAME)
		USER3=userDataCreation.name3;

	    login.loginAsNewUser(USER3,UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

	    navigateTo.particularView(VIEW1);
		viewsList.verifyStatusCellOfStatusTypeCantUpdate(RESOURCE_VALUE1,MULTI_STATUSTYPE_VALUE1.get(0));
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME1);
		updateStatus.verifyYouAreNotAuthorizedToUpdateMessage();

		//Map
		navigateTo.map();
		map.openResourceOnMapToUpdate(RESOURCE_NAME1,MULTI_STATUSTYPE_NAME1);
		updateStatus.verifyYouAreNotAuthorizedToUpdateMessage();

		//Event
		eventManagement.selectEventFromBannerToUpdate(EVENT1);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME1);
		updateStatus.verifyYouAreNotAuthorizedToUpdateMessage();

		login.logOut(); 

	}	 */  
 }
}
