package RequirementGroups.SettingUpResources;

import java.awt.Event;

import javax.management.relation.Role;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.hpsf.Section;
import org.testng.annotations.Test;

import EMR.data.EventData;
import EMR.data.EventSetUpData;
import EMR.data.FormsData;
import EMR.data.FormsData.FormsCreateData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.ResourceTypeData;
import EMR.data.RolesData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.FormConfiguration;
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
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewsUnderSetup;
import RequirementGroups.SettingUpResourceTypes.CreateResourceType;
import qaFramework.Configurations.Configuration;
import qaFramework.UserDefinedFunctions.Date_Time_settings;

public class CreateResource extends Configuration{

	public CreateResource() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	ResourceTypeData resourceTypeData;
	ResourceData resourceData;
	ResourceCreateData resourceCreateData;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	RegionList regionList;
	Login login;
	Shared navigateTo;
	LoginData loginData;
	SelectRegion selectRegion;
	ViewsUnderSetup viewUnderSetup;
	ViewData viewData;
	ViewCreateData viewDataCreation;
	Map map;
	ResourceTypeCreateData resourceTypeDataCreation;
	EventSetUp eventSetUp;
	EventSetUpData eventSetUpData;
	EventSetUpCreateData eventSetUpCreateData;
	UsersData userdatData;
	UsersCreateData usersCreateData;
	RolesData rolesData;
	EventData eventData;
	EventCreateData eventCreateData;
	View view;
	FormsData formsData;
	FormsCreateData formsCreateData;
	

	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	Shared shared;
	UsersList usersList;
	EventManagement eventManagement;
	FormConfiguration formConfiguration;
	
	static  String resourceName;
	static  String resourceTypeValue;
	static  String resourceTypeName;
	static  String[] statusTypeValue=new String[6];
	static  String[] statusTypeName=new String[6];
	static  String[] resourceValue=new String[1];
	
	@Test (groups = {"HappyDay", "Setting Up Resources","Create Resource", "HappyDay69613"})
	public void HappyDay69613() throws Exception {
		 
		TCID = "69613";
		TC_DESCRIPTION = "Verify that a resource can be created.";

	    resourceTypeData=new ResourceTypeData();
	    resourceData=new ResourceData();
	    statusTypeData=new StatusTypeData();
		viewData = new ViewData();
	    viewDataCreation = viewData.new ViewCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData(); 
		
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		regionList = new RegionList(this.driver);
		statusTypes = new StatusTypes(this.driver);
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
	    resourceTypes = new ResourceTypes(this.driver);
	    resources = new Resources(this.driver);
	    resourceData = new ResourceData();
	    resourceCreateData = resourceData.new ResourceCreateData();
	    viewUnderSetup = new ViewsUnderSetup(this.driver);
	    map = new Map(this.driver);
	    resourceTypes = new ResourceTypes(this.driver); 
	    
		
		/****
		 * DEPEND ON HappyDay69388 TC 
		 * LoginToApplication
		 * createStatusType()
		 * createResource() ->Add status type at resource level.
		 * VerifyCreatedResourceDetailsUnderResourceListPage -> (new function)
		 * VerifyResourceIconDisplayedOnMap -> (new function)
		 * VerifyResourceIconDisplayedOnViewResourceDetailPage -> (new function)
		 * logout
		 ****/
	 
	    
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);
		navigateTo.viewUnderSetup();
		viewUnderSetup.createNewSection(viewDataCreation.section_1);
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description, viewDataCreation.section_1)
		 			.createStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.dateName, statusTypeDataCreation.description, viewDataCreation.section_1)
		 			.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description, viewDataCreation.section_1)
		 			.createNewStatus(statusTypeDataCreation.statusesName,StatusTypeData.STATUS_PURPLE_COLOR)
		 			.createNewStatus(statusTypeDataCreation.statusesName1,StatusTypeData.STATUS_PURPLE_COLOR);
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.tstName, statusTypeDataCreation.description, viewDataCreation.section_1)
		 			.createStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.nedocsName, statusTypeDataCreation.description, viewDataCreation.section_1)
		 			.createStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sstName, statusTypeDataCreation.description, viewDataCreation.section_1);
	
		statusTypeValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName);
		statusTypeValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName);
		statusTypeValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName);
		statusTypeValue[3] =  statusTypes.getStatusTypeValue(statusTypeDataCreation.nedocsName);
		statusTypeValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sstName);
		statusTypeValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.dateName);
		
		statusTypeName[0] =statusTypeDataCreation.nstName;
		statusTypeName[1] =statusTypeDataCreation.mstName;
		statusTypeName[2] =statusTypeDataCreation.tstName;
		statusTypeName[3] =statusTypeDataCreation.nedocsName;
		statusTypeName[4] =statusTypeDataCreation.sstName;
		statusTypeName[5] =statusTypeDataCreation.dateName;

	
		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, statusTypeValue);
		resourceTypeValue=resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);
		navigateTo.resources();
		resources.createResourceWithAddress(resourceCreateData.name1, resourceCreateData.abbrevation1,resourceTypeDataCreation.name , ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resourceValue[0]=resources.getResourceValue(resourceCreateData.name1);
		resources.verifyResourceIsPresentUnderResourceListPage(resourceCreateData.name1);
		navigateTo.map();
		map.openResourceOnMapAndVerifyResourceAndStatusTypes(resourceCreateData.name1, statusTypeName);
		map.clickViewInfoInPopupWindow();
		map.verifyViewResDetailScreenIsDisplayedWithResName(resourceCreateData.name1);
		login.logOut();
		
		resourceName=resourceCreateData.name1;
		resourceTypeName=resourceTypeDataCreation.name;
		Result = "PASS";
		
	}	
	
	@Test (dependsOnMethods={"HappyDay69613"},groups = {"HappyDay", "Setting Up Resources","Edit Resource", "HappyDay69690"})
	public void HappyDay69690() throws Exception {
		 
		TCID = "69690";
		TC_DESCRIPTION = " Verify that a resource can be edited.";

	    resourceTypeData=new ResourceTypeData();
	    resourceData=new ResourceData();
	    statusTypeData=new StatusTypeData();
		viewData = new ViewData();
	    viewDataCreation = viewData.new ViewCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData(); 
		eventSetUpData=new EventSetUpData();
		eventSetUpCreateData=eventSetUpData.new EventSetUpCreateData();
		userdatData=new UsersData();
		usersCreateData= userdatData.new UsersCreateData();
		rolesData= new RolesData();
		eventData=new EventData();
		eventCreateData=eventData.new EventCreateData();
		formsData=new FormsData();
		formsCreateData=formsData.new FormsCreateData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		shared = new Shared(this.driver);
		regionList = new RegionList(this.driver);
		statusTypes = new StatusTypes(this.driver);
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
	    resourceTypes = new ResourceTypes(this.driver);
	    resources = new Resources(this.driver);
	    resourceData = new ResourceData();
	    resourceCreateData = resourceData.new ResourceCreateData();
	    viewUnderSetup = new ViewsUnderSetup(this.driver);
	    map = new Map(this.driver);
	    resourceTypes = new ResourceTypes(this.driver); 
	    eventSetUp=new EventSetUp(this.driver);
	    usersList =new UsersList(this.driver);
	    eventManagement=new EventManagement(this.driver);
	    view=new View(this.driver);
	    formConfiguration=new FormConfiguration(this.driver);
	    
		
		
	    login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);
	    navigateTo.eventSetUp();
	    eventSetUp.createEventTemplate(eventSetUpCreateData.name1, eventSetUpCreateData.definition1, resourceTypeValue, statusTypeValue);
	    navigateTo.viewUnderSetup();
	    viewUnderSetup.createView(viewDataCreation.name1, viewDataCreation.description1, resourceName, statusTypeName);
	    navigateTo.users();
	    usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(usersCreateData.name1, UsersData.INITIAL_PASSWORD, usersCreateData.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
	    usersList.provideViewCustomViewRight();
	    usersList.provideFormUserMayActivateFormsRight();
	    usersList.provideMaintainEventsRightAndSave();
	    login.logOut();
	    
	    login.loginAsNewUser(usersCreateData.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
	    navigateTo.eventManagment();
	    eventManagement.createEvent(eventSetUpCreateData.name1, eventCreateData.name1, eventCreateData.description1, resourceName);
	    navigateTo.customView();
	    view.createCustomView(resourceName, resourceValue, statusTypeValue);
	    login.logOut();
	    
	    login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);
	    navigateTo.resources();
	    resources.editResourceName(resourceName, resourceCreateData.editName);
	    navigateTo.particularView(viewDataCreation.name1);
	    view.verifyResourceTypeAndResource(resourceTypeName, resourceCreateData.editName);
	    navigateTo.map();
	    map.openResourceOnMapAndVerifyResourceAndStatusTypes(resourceCreateData.editName, statusTypeName);
	    navigateTo.viewUnderSetup();
	    viewUnderSetup.VerifyResourceNameIsUpdated(viewDataCreation.name2, viewDataCreation.description2, resourceCreateData.editName);
	    eventManagement.clickOnEventBanner(eventCreateData.name1);
	    view.verifyResourceTypeAndResource(resourceTypeName, resourceCreateData.editName);
	    shared.clickOnSearchInToolBar();
		view.verifyResourceShouldNotRetrived(resourceTypeName, resourceName);
		view.verifyResourceShouldRetrived(resourceTypeName, resourceCreateData.editName);
		navigateTo.configureForm();
		formConfiguration.verifyResourceNameIsUpdatedInResourcesToFillFormPage(formsCreateData.name, formsCreateData.description, FormsData.USERINITIATEANDOTHERTOFILLOUT, FormsData.USERTOUSERSANDRESOURCES, resourceTypeName, resourceCreateData.editName);
		login.logOut();
		
		login.loginAsUser(usersCreateData.name1, UsersData.PASSWORD);
	    navigateTo.eventManagment();
	    eventManagement.editEventAndVerifyResourceNameIsUpdated(eventCreateData.name1, resourceTypeName, resourceCreateData.editName);
		navigateTo.customView();
		//view.verifyResourceTypeAndResourceUnderCustomView(resourceTypeName, resourceCreateData.editName);
		login.logOut();
		
	    Result = "PASS";
		
	}	
}
