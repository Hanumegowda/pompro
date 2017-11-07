package RequirementGroups.SettingUpResources;

import org.testng.annotations.Test;

import EMR.data.EventData;
import EMR.data.EventSetUpData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
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
import EMR.pages.StatusChangePreferences;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewsUnderSetup;
import qaFramework.Configurations.Configuration;

public class ImportResourcesFromSpreadsheet  extends Configuration{

	public ImportResourcesFromSpreadsheet() throws Exception {
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
	
	@Test (priority=1,groups = {"HappyDay", "Setting Up Resources","Import Resources from Spreadsheet", "HappyDay102968"})
	public void HappyDay102968() throws Exception {
 
		TCID = "102968";
		TC_DESCRIPTION = "Verify that only RegAdmin (EMSystems Administrator) can import resources.";
	
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
		
		
		/* login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.TESTREGION);
		 * navigateTo.users();
		 * usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(usersCreateData.name, UsersData.INITIAL_PASSWORD,usersCreateData.fullName, UsersData.PRIMARY_EMAILID,
						UsersData.PRIMARY_EMAILID)
		 * .provideConfigureRegionalUserAccessRight();
		 * navigateTo.upload(); -> new function
		 * upload.verifyUploadOptionIsAvailableForSystemAdmin(); -> new function
		 * 		this.verifyUploadListPageIsDisplayed();	-> new function
		 * 		this.verifyUploadResourcesIsAvailable(); -> new function
		 * 		this.verifyUploadTemplateIsAvailable(); -> new function
		 * 		this.clickOnUploadResources(); -> new function
		 * 		this.verifyNewUploadPageIsDisplayed(); -> new function
		 * 		this.verifyBrowseSpreedSheetIsAvailable(); -> new function
		 * 		this.verifyTestIsSelected();  -> new function
		 * 		this.verifySave(); -> new function
		 * 		this.verifyCancel(); -> new function
		 * login.logout();
		 * 
		 * login.loginAsNewUser(usersCreateData.name, UsersData.INITIAL_PASSWORD,UsersData.PASSWORD);
		 * upload.verifyUploadOptionIsNotAvailableForUser(); -> new function
		 * 		this.verifyUploadIsNotAvailableInSetupMenu();	-> new function
		 * login.logOut();
		 * 
		 * 
		*/
		//Result = "PASS";

	}
	
	@Test (priority=2,groups = {"HappyDay", "Setting Up Resources","Import Resources from Spreadsheet", "HappyDay102966"})
	public void HappyDay102966() throws Exception {
 
		TCID = "102966";
		TC_DESCRIPTION = "Verify that user can upload resources providing data in the mandatory field. ";
	
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
		
		/* login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.TESTREGION);
		 * navigateTo.viewUnderSetup();
		 * viewUnderSetup.createNewSection(viewDataCreation.section_1);
		 * navigateTo.statusTypes();
		 * statusTypes.createStatusType(StatusTypeData.NUMBERTYPE,statusTypeDataCreation.nstName1,statusTypeDataCreation.description,viewDataCreation.section_1);
		 * STATUSTYPE_VALUE_.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName1));
		 * navigateTo.resourceType();
		 * resourceTypes.createResourceType(resourceTypeDataCreation.name1,STATUSTYPE_VALUE_);
		 * RESOURCETYPE_VALUE.add(resourceType.getResourceTypeValue(resourceTypeDataCreation.name1));
		 * navigateTo.upload();	-> new function
		 * upload.uploadResourceFromSpreedSheet(); -> new function
		 * 		this.clickOnUploadResource(); -> new function
		 * 		this.addfile(); -> new function
		 * 		this.deselctTest(); -> new function
		 * 		this.clickOnSave(); -> new function
		 * 		this.verifyUploadDetailsPageIsDisplayed(); -> new function
		 * upload.verifyAppropraiteDetailsAreDisplayedInUploadDetailsPage(); -> new function
		 * 		this.verifySpreadSheetName(); -> new function
		 * 		this.verifyTestIsChecked(); -> new function
		 * 		this.verifyUserName(); -> new function
		 * 		this.verifyDate(); -> new function
		 * upload.verifyAppropraiteValueDisplayedInColumnOfUploadDetailsPage(); -> new function
		 * 		this.verifyRowNumber(); -> new function
		 * 		this.verifyResourceID(); -> new function
		 * 		this.verifyResourceName(); -> new function
		 * 		this.verifyFailedColumn(); -> new function
		 * 		this.verifyGeocode(); -> new function
		 * 		this.vrifyResourceComments(); -> new function
		 * 		this.clickOnRetuen(); -> new function
		 * upload.verifyAppropraiteValueDisplayedInUploadListPage(); -> new function
		 * 		this.verifyTestColumn(); -> new function
		 * 		this.verifyDate(); -> new function
		 * 		this.verifyUser(); -> new function
		 * navigateTo.resources();
		 * resources.verifyUploadedResourceIsListedAndAppropraiteValueDisplayed(); -> new function
		 * resources.editResdource(); 
		 * resources.verifyUploadedResourceValueAreRetained(); -> new function
		 * resources.verifyStatusTypeIsSelectedAndDisabled(); -> new function
		 * navigateTo.users();
		 * userslists.verifyUploadedResourceIsListedUnderResourceRightsSection(); -> new function
		 * userslists.verifyViewResourceRightIsSelectedForUploadedResource(); -> new function
		 * login.logout();
		*/

		//Result = "PASS";

	}
}
