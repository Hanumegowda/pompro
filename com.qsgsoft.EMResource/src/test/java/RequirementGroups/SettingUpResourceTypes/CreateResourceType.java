package RequirementGroups.SettingUpResourceTypes;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import EMR.data.EventData;
import EMR.data.EventSetUpData;
import EMR.data.LoginData;
import EMR.data.OtherRegionData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.RolesData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.RegionData.RegionCreateData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.ResourceTypeData.ResourceTypeTags;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
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
import EMR.pages.UpdateStatus;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewsUnderSetup;
import qaFramework.WaitTimeConstants;
import qaFramework.Configurations.Configuration;
import qaFramework.UserDefinedFunctions.WaitForElement;

public class CreateResourceType extends Configuration {


	public CreateResourceType() throws Exception {
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
	UpdateStatus updateStatus;

	static String ResourceType;
	static String MultiStatusType;
	static String NumberStatustype;

	static ArrayList<String> ST_names = new ArrayList<String>();
	static ArrayList<String> STValue = new ArrayList<String>();
	static ArrayList<String> StatusValues = new ArrayList<String>();
	static ArrayList<String> StatusTypeNames = new ArrayList<String>();
	static String RSValue, statusName;

	@Test (groups = {"HappyDay", "Setting Up ResourceTypes", "HappyDay69388"})
	public void HappyDay69388() throws Exception {

		TCID = "69388";
		TC_DESCRIPTION = "Verify that a resource type can be created.";

		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		regionData = new RegionData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData(); 
		resourceData = new ResourceData();

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		viewsList = new View(this.driver);
		statusTypes = new StatusTypes(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		statusName = statusTypeDataCreation.statusesName;

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);
		navigateTo.viewUnderSetup();
		viewUnderSetup.createNewSection(viewDataCreation.section_1);
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.dateName, statusTypeDataCreation.description, viewDataCreation.section_1)
		.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description, viewDataCreation.section_1)
		.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description, viewDataCreation.section_1)
		.createNewStatus(statusName,StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName1,StatusTypeData.STATUS_PURPLE_COLOR);
		StatusValues.add(statusTypes .getStatusesValue(statusName));
		StatusValues.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName1));
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.tstName, statusTypeDataCreation.description, viewDataCreation.section_1)
		.createStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.nedocsName, statusTypeDataCreation.description, viewDataCreation.section_1)
		.createStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sstName, statusTypeDataCreation.description, viewDataCreation.section_1);
		STValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName));
		STValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName));
		STValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName));
		STValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nedocsName));
		STValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.sstName));
		STValue.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.dateName));


		StatusTypeNames.addAll(Arrays.asList(statusTypeDataCreation.nstName,statusTypeDataCreation.mstName,
				statusTypeDataCreation.tstName,statusTypeDataCreation.nedocsName,
				statusTypeDataCreation.sstName,statusTypeDataCreation.dateName));

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, STValue);
		resourceTypes.VerifyResourceTypeInList(resourceTypeDataCreation.name);

		ResourceType = resourceTypeDataCreation.name;
		MultiStatusType = statusTypeDataCreation.mstName;
		NumberStatustype = statusTypeDataCreation.nstName;


		Result = "PASS";
	}

	@Test (dependsOnMethods={"HappyDay69388"},groups = {"HappyDay", "Setting Up ResourceTypes", "HappyDay69390"})
	public void HappyDay69390() throws Exception {

		TCID = "69390";
		TC_DESCRIPTION = " 	Verify that a Multi status type can be selected as the default status type of a resource type.";

		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		regionData = new RegionData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData(); 
		resourceData = new ResourceData();
		resourceDataCreation = resourceData.new ResourceCreateData();
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
		map = new Map(this.driver);
		updateStatus= new UpdateStatus(this.driver);
		
		String statusColor="";
		

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);
		navigateTo.resourceType();
		resourceTypes.editResorceTypeAndSelectDefaultMultiStatusType(ResourceType, MultiStatusType);
		navigateTo.resources();
		resources.createResourceWithAddress(resourceDataCreation.name1, resourceDataCreation.abbrevation1,
				ResourceType , ResourceData.STANDARDRESOURCETYPE, 
				ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, 
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		RSValue = resources.getResourceValue(resourceDataCreation.name1);
		navigateTo.statusTypes();
		statusColor = statusTypes.getStatusColoronStatusTypeListPage(MultiStatusType, statusName);
		
		navigateTo.users();
		usersList.createUserWithUpdateRightOnSigleResource(userDataCreation.name1, UsersData.INITIAL_PASSWORD, userDataCreation.fullName1, 
				UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceDataCreation.name1)
				.clickOnSave();

		navigateTo.viewUnderSetup();
		viewUnderSetup.createView(viewDataCreation.name1, viewDataCreation.description, resourceDataCreation.name1, StatusTypeNames);
		login.logOut();
		login.loginAsNewUser(userDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.map();
		map.selectResourceNameInFindResourceDropdown(resourceDataCreation.name1);
		map.clickUpdateStatusInPopupWindow();
		updateStatus.clickOnStatusType(STValue.get(1));
		updateStatus.selectMSTUpdateValue(STValue.get(1), StatusValues.get(0))
		.clickOnSave();
		map.selectResourceNameInFindResourceDropdown(resourceDataCreation.name1);
		updateStatus.verifyUpdatedValuePurpleColor(statusName, statusColor);
		//navigateTo.particularView(viewDataCreation.name1);
		//viewsList.verifyUpdatedValuePurpleColor(RSValue,STValue.get(1),StatusValues.get(0));
	}
	
	

}
