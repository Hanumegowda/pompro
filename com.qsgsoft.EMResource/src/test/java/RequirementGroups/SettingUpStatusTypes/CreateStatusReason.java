package RequirementGroups.SettingUpStatusTypes;

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

public class CreateStatusReason extends Configuration { 

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
	Mails mail;

	static String USER,RESOURCE_NAME,VIEW,RESOURCE_VALUE,RESOURCE_TYPE_VALUE;

	ArrayList<String> STATUS_TYPES_VALUES= new ArrayList<String>();
	ArrayList<String> STATUSES_VALUES= new ArrayList<String>();
	ArrayList<String> STATUS_RESONS_VALUES= new ArrayList<String>();
	ArrayList<String> STATUS_TYPES_NAMES= new ArrayList<String>();
	ArrayList<String> UPDATED_RESON= new ArrayList<String>();
	ArrayList<String> UPDATED_STATUS= new ArrayList<String>();

	public CreateStatusReason() throws Exception {
		super();
	}

	@Test(groups = {"HappyDay","Setting up Status types", "HappyDay68890"})
	public void HappyDay68890() throws Exception {

		TCID ="68890";
		TC_DESCRIPTION ="Verify that status reasons selected while updating multi status type are displayed on status change notifications(Web,email and pager)";

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

		login.loginToApplication(
				LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);

		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);

		navigateTo.views();
		viewUnderSetup.createNewSection(viewDataCreation.section);

		navigateTo.users();
		usersList.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
		.provideSetUpStatusTypesRight()
		.provideSetupResourceTypesRight()
		.provideStatusReasonRight()
		.provideSetupResourcesAddAndEditRight()
		.provideConfigureRegionalUserAccessRight()
		.provideConfigureRegionViewsRightAndSave();

		USER=userDataCreation.name;
		System.out.println(userDataCreation.name);

		login.logOut();   
		login.loginAsNewUser(USER,UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);  

		navigateTo.statusReasons();
		statusReasonList.createStatusReason(creatStatusReasonData.name, creatStatusReasonData.definition)
		.createStatusReason(creatStatusReasonData.name1, creatStatusReasonData.definition1)
		.verifyCreatedStatusReasonInList(creatStatusReasonData.name)
		.verifyCreatedStatusReasonInList(creatStatusReasonData.name1);

		STATUS_RESONS_VALUES.add(statusReasonList.getStatusReasonValue(creatStatusReasonData.name));
		STATUS_RESONS_VALUES.add(statusReasonList.getStatusReasonValue(creatStatusReasonData.name1));

		System.out.println(creatStatusReasonData.name);

		navigateTo.statusTypes();
		statusTypes.createStatusTypeWithReasons(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description,viewDataCreation.section,STATUS_RESONS_VALUES);
		statusTypes.createNewStatusSelectingReasonsWithStatusReasonRequired(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR, STATUS_RESONS_VALUES);
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName1));
		statusTypes.createNewStatusSelectingReasonsWithStatusReasonRequired(statusTypeDataCreation.statusesName2, StatusTypeData.STATUS_PURPLE_COLOR, STATUS_RESONS_VALUES);			
		STATUSES_VALUES.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName2));
		statusTypes.clickOnReturnToStatusTypeList();

		STATUS_TYPES_VALUES.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName));
		STATUS_TYPES_NAMES.add(statusTypeDataCreation.mstName);

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, STATUS_TYPES_VALUES);
		RESOURCE_TYPE_VALUE = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);

		navigateTo.resources();
		resources.createResourceWithAddress(
				resourceDataCreation.name, resourceDataCreation.abbrevation1,
				resourceTypeDataCreation.name, ResourceData.STANDARDRESOURCETYPE,
				ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, 
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		RESOURCE_VALUE=resources.getResourceValue(resourceDataCreation.name);
		RESOURCE_NAME=resourceDataCreation.name;

		System.out.println(resourceDataCreation.name);

		navigateTo.users();
		usersList.editUserAndProvideUpdateRight(USER,RESOURCE_NAME);

		navigateTo.views();   
		view.createViewByUser(viewDataCreation.name,viewDataCreation.description,RESOURCE_NAME,STATUS_TYPES_NAMES,RegionData.REGIONNAME);
		VIEW=viewDataCreation.name;
		System.out.println(viewDataCreation.name);
		login.logOut();

		login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD); 
		navigateTo.particularView(VIEW);

		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);
		updateStatus.verifyUpdateStatusPage()
		.tryToUpdateWithoutSelectingReasonAndVerifyError(STATUS_TYPES_NAMES.get(0),STATUS_TYPES_VALUES.get(0),STATUSES_VALUES.get(1),statusTypeDataCreation.statusesName2)
		.updateWithReason(STATUS_TYPES_VALUES.get(0),STATUSES_VALUES.get(1),STATUS_RESONS_VALUES.get(1));

		UPDATED_RESON.add(creatStatusReasonData.name1);
		UPDATED_STATUS.add(statusTypeDataCreation.statusesName2);

		views.verifyUpdatedStatusTypeValue(RESOURCE_TYPE_VALUE, RESOURCE_VALUE, STATUS_TYPES_VALUES,UPDATED_STATUS)
		.verifyUpdatedReasonsUnderCommentSection(RESOURCE_NAME,UPDATED_RESON);

		login.logOut();
		Result = "PASS";	
	}	   

	@Test(dependsOnMethods={"HappyDay68890"},groups = {"HappyDay","Setting up Status types", "HappyDay68940","Edit status reason","EMResource Base"})
	public void HappyDay68940() throws Exception {

		TCID ="68940";
		TC_DESCRIPTION ="Verify that user can edit a status reason.";

		StatusReasonData = new StatusReasonData();
		creatStatusReasonData = StatusReasonData.new StatusReasonCreateData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		statusReasonList = new StatusReasonList(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		view = new ViewsUnderSetup(this.driver);
		views= new View(this.driver);

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);

		navigateTo.statusReasons();
		statusReasonList.editNameAndDefinition(UPDATED_RESON.get(0),creatStatusReasonData.editName, creatStatusReasonData.editDefinition)
		.verifyReasonNameAndDefinition(creatStatusReasonData.editName,creatStatusReasonData.editDefinition);
		login.logOut();

		login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD); 
		navigateTo.particularView(VIEW);

		views.verifyUpdatedStatusTypeValue(RESOURCE_TYPE_VALUE, RESOURCE_VALUE, STATUS_TYPES_VALUES,UPDATED_STATUS)
		.verifyUpdatedReasonsUnderCommentSection(RESOURCE_NAME, UPDATED_RESON);

		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);
		updateStatus.verifyUpdateStatusPage()
		.selectMSTUpdateValue(STATUS_TYPES_VALUES.get(0), STATUSES_VALUES.get(1))
		.updateWithReason(STATUS_TYPES_VALUES.get(0),STATUSES_VALUES.get(1),STATUS_RESONS_VALUES.get(1));
		UPDATED_RESON.clear();
		UPDATED_RESON.add(creatStatusReasonData.editName);

		views.verifyUpdatedStatusTypeValue(RESOURCE_TYPE_VALUE, RESOURCE_VALUE, STATUS_TYPES_VALUES,UPDATED_STATUS)
		.verifyUpdatedReasonsUnderCommentSection(RESOURCE_NAME, UPDATED_RESON);
		UPDATED_STATUS.clear();
		UPDATED_STATUS.add(statusTypeDataCreation.statusesName1);
		login.logOut();
		Result = "PASS";	
	}

	@Test(dependsOnMethods={"HappyDay68940"},groups = {"HappyDay","Status Update", "HappyDay197270","Updating status","EMResource v3.26"})
	public void HappyDay197270() throws Exception {

		TCID ="197270";
		TC_DESCRIPTION ="Verify that user is prompted to 'Save the changes' when user navigates to other pages without clicking on 'Save'";

		login = new Login(this.driver); 
		navigateTo = new Shared(this.driver);
		regionDefault= new RegionDefault(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		views= new View(this.driver);

		login.loginAsUserAndAcknowledgeWebNotification(USER,UsersData.PASSWORD); 
		navigateTo.particularView(VIEW);

		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);
		updateStatus.verifyUpdateStatusPage()

		.selectMSTUpdateValue(STATUS_TYPES_VALUES.get(0), STATUSES_VALUES.get(0))
		.navigateToOtherPageAndVerifyUserIsPromptedToSaveChanges()
		.updateWithReason(STATUS_TYPES_VALUES.get(0),STATUSES_VALUES.get(0),STATUS_RESONS_VALUES.get(1))
		.verifyNoAlertIsPromptedToSaveChanges();

		views.verifyUpdatedStatusTypeValue(RESOURCE_TYPE_VALUE, RESOURCE_VALUE, STATUS_TYPES_VALUES,UPDATED_STATUS)
		.verifyUpdatedReasonsUnderCommentSection(RESOURCE_NAME, UPDATED_RESON);
		login.logOut();
		Result = "PASS";	
	}
	
	/*@Test(dependsOnMethods={"HappyDay197270"},groups = {"HappyDay","Status Update", "HappyDay84453","Updating status","EMResource v3.26"})
	public void HappyDay84453() throws Exception {

		TCID ="84453";
		TC_DESCRIPTION =" Verify that a status can be edited.";

		login = new Login(this.driver); 
		navigateTo = new Shared(this.driver);
		regionDefault= new RegionDefault(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		views= new View(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGIONNAME);

		navigateTo.statusTypes();
		statusTypes.editstatusNameAndDecription();

		navigateTo.particularView(VIEW);
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(RESOURCE_NAME);

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

		login.logOut();
		Result = "PASS";	*/
	
}