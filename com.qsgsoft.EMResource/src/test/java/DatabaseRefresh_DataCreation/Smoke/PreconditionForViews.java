package DatabaseRefresh_DataCreation.Smoke;

import org.testng.annotations.Test;
import EMR.data.EventSetUpData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.RegionData.RegionCreateData;
import EMR.data.RegionData.RegionTags;
import EMR.data.ResourceData;
import EMR.data.ResourceData.ResourceTags;
import EMR.data.ResourceTypeData;
import EMR.data.ResourceTypeData.ResourceTypeTags;
import EMR.data.RolesData;
import EMR.data.StatusTypeData;
import EMR.data.StatusTypeData.StatusTypeTags;
import EMR.data.UsersData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.RolesData.RolesTags;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.UsersData.UsersTags;
import EMR.data.ViewData;
import EMR.data.ViewData.ViewCreateData;
import EMR.data.ViewData.ViewTags;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.RegionDefault;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.RolesList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.ViewsUnderSetup;
import EMR.pages.View;
import EMR.pages.StatusChangePreferences;
import EMR.data.StatusChangePreferncesData;
import qaFramework.Configurations.Configuration;
import EMR.pages.OtherRegionList;
import EMR.pages.ConfigureNewRelationship;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;

public class PreconditionForViews extends Configuration {

	ReadAndWriteFromXMLFile xml = new ReadAndWriteFromXMLFile();

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


	Login login;
	SelectRegion selectRegion;
	RegionDefault regionDefault;
	Shared navigateTo;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	StatusChangePreferences statusChangePreferences;
	UsersList usersList;
	RolesList rolesList;
	View viewsList;
	ViewsUnderSetup viewUnderSetup;
	OtherRegionList otherRegionList;
	ConfigureNewRelationship configurRelationShip;
	EventSetUp eventSetUp;

	public PreconditionForViews() throws Exception {
		super();
	}

	@Test(description ="Precondition for 186243, 187227 and 186259")
	public void Precondition_187226() throws Exception {

		TCID = "187226";
		TC_DESCRIPTION = "Precondition for 186243, 187227 and 186259";

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		regionDefault = new RegionDefault(this.driver);
		navigateTo = new Shared(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		statusTypes = new StatusTypes(this.driver);
		usersList = new UsersList(this.driver);
		rolesList = new RolesList(this.driver);
		viewsList = new View(this.driver);
		viewUnderSetup      = new ViewsUnderSetup(this.driver);
		statusChangePreferences= new StatusChangePreferences(this.driver);

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

		String statusTypeValue[] = new String[6];
		String statusValues[]= new String[2];
		String resourceValue[] = new String[2];
		String resourceTypeValue[] = new String[1];
		String roleValue = "";

		login.loginToApplication(
				LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);

		navigateTo.views();
		viewUnderSetup.createNewSection(viewDataCreation.section);

		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description,viewDataCreation.section);
		statusTypeValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName);

		statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description,viewDataCreation.section);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR);
		statusValues[0]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName);
		statusValues[1]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName1);
		statusTypes .clickOnReturnToStatusTypeList();
		statusTypeValue[1]= statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName);

		statusTypes.createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.tstName, statusTypeDataCreation.description,viewDataCreation.section);
		statusTypeValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName);

		statusTypes.createStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.nedocsName, statusTypeDataCreation.description,viewDataCreation.section);
		statusTypeValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nedocsName);

		statusTypes.createStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sstName,statusTypeDataCreation.description,viewDataCreation.section);
		statusTypeValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sstName);

		statusTypes.createStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.dateName,statusTypeDataCreation.description,viewDataCreation.section);
		statusTypeValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.dateName);

		String statusTypeNames[]={statusTypeDataCreation.nstName,statusTypeDataCreation.mstName,statusTypeDataCreation.tstName,statusTypeDataCreation.nedocsName,statusTypeDataCreation.sstName,statusTypeDataCreation.dateName};

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, statusTypeValue);
		resourceTypeValue[0]=resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);

		navigateTo.resources();
		resources.createResource(resourceDataCreation.name, resourceDataCreation.abbrevation, resourceTypeDataCreation.name, 
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME);
		resourceValue[0]=resources.getResourceValue(resourceDataCreation.name);

		resources.createResource(resourceDataCreation.name1, resourceDataCreation.abbrevation1, resourceTypeDataCreation.name, 
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME);
		resourceValue[1]=resources.getResourceValue(resourceDataCreation.name1);

		String[] resourcesToRegionDefaultView={resourceDataCreation.name,resourceDataCreation.name1};

		System.out.println("res name" + resourceDataCreation.name);
		System.out.println("res1 name" + resourceDataCreation.name1);
		System.out.println("User name" + userDataCreation.name);

		navigateTo.roles();
		rolesList.createRole(rolesDataCreation.name);
		roleValue = rolesList.getRoleValue(rolesDataCreation.name);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsAndEMailPager(userDataCreation.name, UsersData.INITIAL_PASSWORD,
				userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, roleValue)
				.provideUpdateRightOnResourcesAndSave(resourceDataCreation.name,resourceDataCreation.name1)
				.searchUser(userDataCreation.name)
				.clickOnStatusChangeNotificationPreferences();

		statusChangePreferences.assignUserToStatusChangeNotifications(resourceDataCreation.name1, resourceValue[1], userDataCreation.name, resourceTypeDataCreation.name)
		.expandAndverifyStatusTypesUnderUncategorizedSection(statusTypeNames)
		.provideReceiveStatusChangeNotificationsToNumberStatusType(resourceValue[1], statusTypeValue[0], StatusChangePreferncesData.ABOVEVALUEFORNST, StatusChangePreferncesData.BELOWVALUEFORNST)
		.provideReceiveStatusChangeNotificationsToSStStatusType(resourceValue[1], statusTypeValue[4], StatusChangePreferncesData.ABOVEVALUEFORSST, StatusChangePreferncesData.BELOWVALUEFORSST)
		.provideReceiveStatusChangeNotificationsToNedocsStatusType(resourceValue[1], statusTypeValue[3], StatusChangePreferncesData.ABOVEVALUEFORNDST, StatusChangePreferncesData.BELOWVALUEFORNDST)
		.provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(resourceValue[1], statusTypeValue[1], statusValues[0], statusValues[1])
		.provideReceiveStatusChangeNotificationsToDateStatusType(resourceValue[1], statusTypeValue[5])
		.provideReceiveStatusChangeNotificationsToTextStatusType(resourceValue[1], statusTypeValue[2])
		.clickOnSave();
		statusChangePreferences.verifyStatusTypesUnderResourceInStatusChangePreferncsPage(resourceDataCreation.name1, statusTypeNames);

		navigateTo.views();
		viewUnderSetup.addResourceAndStatusTypesToRegionDefaultView(RegionData.REGIONNAME,resourcesToRegionDefaultView, statusTypeNames);	
		navigateTo.regionDefault();
		regionDefault.verifyResourceAndCorrespondingStatusTypes(resourceTypeDataCreation.name, resourceDataCreation.name1, statusTypeNames)
		.verifyResourceAndCorrespondingStatusTypes(resourceTypeDataCreation.name, resourceDataCreation.name, statusTypeNames);
		login.logOut();

		login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
		.logOut();

		userDataCreation.writeUsersDataToXml(userDataCreation.name, UsersTags.STATUS_CHANGE_PREFERNCEUSER);
		userDataCreation.writeUsersDataToXml(userDataCreation.fullName, UsersTags.STATUS_CHANGE_PREFERNCEFULLNAME);
		rolesDataCreation.writeRolesDataToXml(rolesDataCreation.name, RolesTags.PREFERANCE_ROLE);
		rolesDataCreation.writeRolesDataToXml(roleValue, RolesTags.PREFERANCE_ROLE_VALUE);

		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.nstName,StatusTypeTags.ROLEBASED_NUMBER_STATUSTYPE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.mstName,StatusTypeTags.ROLEBASED_MULTI_STATUSTYPE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.statusesName,StatusTypeTags.STATUS1);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.statusesName1,StatusTypeTags.STATUS2);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.tstName,StatusTypeTags.ROLEBASED_TEXT_STATUSTYPE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.nedocsName,StatusTypeTags.ROLEBASED_NEDOCS_STATUSTYPE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.sstName,StatusTypeTags.ROLEBASED_SATURATION_STATUSTYPE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.dateName,StatusTypeTags.ROLEBASED_DATE_STATUSTYPE);
		viewDataCreation.writeViewDataToXml(viewDataCreation.section, ViewTags.SECTION_WITH_ROLED_STATUSTYPES);

		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeDataCreation.name, ResourceTypeTags.PREFERANCES_RESOURCETYPE);
		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeValue[0], ResourceTypeTags.PREFERANCES_RESOURCETYPE_VALUE);

		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.name, ResourceTags.ROLE_BASED_RESOURCE);
		resourceDataCreation.writeResourceDataToXml(resourceValue[0], ResourceTags.ROLE_BASED_RESOURCE_VALUE);

		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.name1, ResourceTags.PREFERANCE_RESOURCE);
		resourceDataCreation.writeResourceDataToXml(resourceValue[1], ResourceTags.PREFERANCE_RESOURCE_VALUE);
		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.abbrevation1, ResourceTags.PREFERANCE_RESOURCE1_ABBREVATION);

		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeValue[0],StatusTypeTags.ROLEBASED_NUMBER_STATUSTYPE_VALUE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeValue[1],StatusTypeTags.ROLEBASED_MULTI_STATUSTYPE_VALUE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusValues[0],StatusTypeTags.STATUS1_VALUE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusValues[1],StatusTypeTags.STATUS2_VALUE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeValue[2],StatusTypeTags.ROLEBASED_TEXT_STATUSTYPE_VALUE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeValue[3],StatusTypeTags.ROLEBASED_NEDOCS_STATUSTYPE_VALUE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeValue[4],StatusTypeTags.ROLEBASED_SATURATION_STATUSTYPE_VALUE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeValue[5],StatusTypeTags.ROLEBASED_DATE_STATUSTYPE_VALUE);

		Result = "PASS";
	}

	@Test(description ="Precondition for 186241")
	public void Precondition_186277() throws Exception {

		TCID = "186277";
		TC_DESCRIPTION = "Precondition for 186241";

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		regionDefault = new RegionDefault(this.driver);
		navigateTo = new Shared(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		statusTypes = new StatusTypes(this.driver);
		usersList = new UsersList(this.driver);
		rolesList = new RolesList(this.driver);
		viewsList = new View(this.driver);
		viewUnderSetup      = new ViewsUnderSetup(this.driver);
		configurRelationShip=new ConfigureNewRelationship(this.driver);
		otherRegionList = new OtherRegionList(this.driver);

		regionData=new RegionData();
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
		regionCreateData=regionData.new RegionCreateData();

		String sharedStatusTypeValue[] = new String[6];
		String sharedStatusValues[]= new String[2];
		String sharedResourceValue[] = new String[1];
		String resourceTypeValue[] = new String[1];
		String roleValue = "";

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGION_WITH_MUTUAL_AGREEMENT1);

		navigateTo.otherRegion();
		configurRelationShip.createMutualAgreementIfNotCreated(RegionData.REGION_WITH_MUTUAL_AGREEMENT2);

		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT2);
		navigateTo.otherRegion();
		configurRelationShip.createMutualAgreementIfNotCreated(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);

		navigateTo.roles();
		rolesList.createRole(rolesDataCreation.name);
		roleValue = rolesList.getRoleValue(rolesDataCreation.name);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsAndEMailPager(userDataCreation.name1, UsersData.INITIAL_PASSWORD,
				userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, roleValue)
				.verifyRegionNameDisplayedUnderViewOtherRegionsAndSave(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);
		System.out.println("Shared user" + userDataCreation.name1);

		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);

		navigateTo.viewUnderSetup();
		viewUnderSetup.createNewSection(viewDataCreation.section_1);

		navigateTo.statusTypes();
		statusTypes.createSharedStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.sharedNST, statusTypeDataCreation.description, viewDataCreation.section_1);
		sharedStatusTypeValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNST);

		statusTypes.createSharedStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.sharedMST, statusTypeDataCreation.description, viewDataCreation.section_1);
		statusTypes.createNewStatus(statusTypeDataCreation.sharedStatus, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.sharedStatus1, StatusTypeData.STATUS_PURPLE_COLOR);
		sharedStatusValues[0]	=  statusTypes .getStatusesValue(statusTypeDataCreation.sharedStatus);
		sharedStatusValues[1]	=  statusTypes .getStatusesValue(statusTypeDataCreation.sharedStatus1);
		statusTypes .clickOnReturnToStatusTypeList();
		sharedStatusTypeValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedMST);

		statusTypes.createSharedStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sharedSST,statusTypeDataCreation.description, viewDataCreation.section_1);
		sharedStatusTypeValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedSST);

		statusTypes.createSharedStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.sharedNEDOCS,statusTypeDataCreation.description, viewDataCreation.section_1);
		sharedStatusTypeValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNEDOCS);

		statusTypes.createSharedStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.sharedTST,statusTypeDataCreation.description, viewDataCreation.section_1);
		sharedStatusTypeValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedTST);

		statusTypes.createSharedStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.sharedDST,statusTypeDataCreation.description, viewDataCreation.section_1);
		sharedStatusTypeValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedDST);

		String shredStatusTypeNames[]={statusTypeDataCreation.sharedNST,statusTypeDataCreation.sharedMST,statusTypeDataCreation.sharedSST,statusTypeDataCreation.sharedNEDOCS,statusTypeDataCreation.sharedTST,statusTypeDataCreation.sharedDST};

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name1, sharedStatusTypeValue);
		resourceTypeValue[0]=resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name1); 

		navigateTo.resources();
		resources.createSharedResourceWithAddress(
				resourceDataCreation.sharedRS_Name,
				resourceDataCreation.abbrevation,
				resourceTypeDataCreation.name1,
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME,
				ResourceData.LASTNAME, ResourceData.STREETADDRESS,
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,
				ResourceData.COUNTY);
		String[] resourcesToRegionDefaultView={resourceDataCreation.sharedRS_Name};
		sharedResourceValue[0]=resources.getResourceValue(resourceDataCreation.sharedRS_Name);

		navigateTo.views();
		viewUnderSetup.addResourceAndStatusTypesToRegionDefaultView(RegionData.REGION_WITH_MUTUAL_AGREEMENT1,resourcesToRegionDefaultView, shredStatusTypeNames);	
		navigateTo.regionDefault();
		regionDefault.verifyResourceAndCorrespondingStatusTypes(resourceTypeDataCreation.name1, resourceDataCreation.sharedRS_Name, shredStatusTypeNames);
		login.logOut();

		login.loginAsNewUser(userDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
		.logOut();

		userDataCreation.writeUsersDataToXml(userDataCreation.name1, UsersTags.USER_IN_MUTUAL_AID_REGION2);
		userDataCreation.writeUsersDataToXml(userDataCreation.fullName, UsersTags.USERFULLNAME_IN_MUTUAL_AID_REGION2);
		rolesDataCreation.writeRolesDataToXml(rolesDataCreation.name, RolesTags.ROLE_IN_MUTUAL_AID_REGION2);
		rolesDataCreation.writeRolesDataToXml(roleValue, RolesTags.ROLE_VALUE_IN_MUTUAL_AID_REGION2);

		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.sharedNST,StatusTypeTags.SHARED_NUMBER_STATUSTYPE_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.sharedMST,StatusTypeTags.SHARED_MULTI_STATUSTYPE_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.sharedStatus,StatusTypeTags.SHARED_STATUS1_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.sharedStatus1,StatusTypeTags.SHARED_STATUS2_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.sharedSST,StatusTypeTags.SHARED_SATURATION_STATUSTYPE_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.sharedNEDOCS,StatusTypeTags.SHARED_NEDOCS_STATUSTYPE_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.sharedDST,StatusTypeTags.SHARED_DATE_STATUSTYPE_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.sharedTST,StatusTypeTags.SHARED_TEXT_STATUSTYPE_IN_MUTUAL_AID_REGION1);

		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeDataCreation.name1, ResourceTypeTags.RESOURCE_TYPE_IN_MUTUAL_AID_REGION1);
		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeValue[0], ResourceTypeTags.RESOURCE_TYPE_VALUE_IN_MUTUAL_AID_REGION1);
		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.sharedRS_Name, ResourceTags.SHARED_RESOURCE_IN_MUTUAL_AID_REGION1);
		resourceDataCreation.writeResourceDataToXml(sharedResourceValue[0], ResourceTags.SHARED_RESOURCE_VALUE_IN_MUTUAL_AID_REGION1);
		regionCreateData.writeRegionDataToXml(RegionData.REGION_WITH_MUTUAL_AGREEMENT1, RegionTags.REGION_WITH_MUTUAL_AGREEMENT1);
		regionCreateData.writeRegionDataToXml(RegionData.REGION_WITH_MUTUAL_AGREEMENT2, RegionTags.REGION_WITH_MUTUAL_AID1);

		statusTypeDataCreation.writeStatusTypesDataToXml(sharedStatusTypeValue[0],StatusTypeTags.SHARED_NUMBER_STATUSTYPE_VALUE_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(sharedStatusTypeValue[1],StatusTypeTags.SHARED_MULTI_STATUSTYPE_VALUE_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(sharedStatusValues[0],StatusTypeTags.SHARED_STATUS1_VALUE_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(sharedStatusValues[1],StatusTypeTags.SHARED_STATUS2_VALUE_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(sharedStatusTypeValue[2],StatusTypeTags.SHARED_SATURATION_STATUSTYPE_VALUE_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(sharedStatusTypeValue[3],StatusTypeTags.SHARED_NEDOCS_STATUSTYPE_VALUE_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(sharedStatusTypeValue[4],StatusTypeTags.SHARED_TEXT_STATUSTYPE_VALUE_IN_MUTUAL_AID_REGION1);
		statusTypeDataCreation.writeStatusTypesDataToXml(sharedStatusTypeValue[5],StatusTypeTags.SHARED_DATE_STATUSTYPE_VALUE_IN_MUTUAL_AID_REGION1);

		Result = "PASS";
	}

	@Test(groups = { "prerequisities" })
	public void prerequisistes_Views() throws Exception {

		TCID = "prerequisistes_Views";
		TC_DESCRIPTION = "prerequisistes_Views for 186199";

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		regionDefault = new RegionDefault(this.driver);
		navigateTo = new Shared(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		statusTypes = new StatusTypes(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		usersList = new UsersList(this.driver);
		viewsList = new View(this.driver);

		loginData = new LoginData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		resourceData = new ResourceData();
		resourceDataCreation = resourceData.new ResourceCreateData();
		eventSetUpData = new EventSetUpData();
		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		usersData = new UsersData();
		rolesData = new RolesData();
		userDataCreation = usersData.new UsersCreateData();

		String statusTypeValue[] = new String[4],
				statusesValues[] = new String[6],
				resourceTypeValue[] = new String[2],
				resourceValue[] = new String[4];

		//create section S1
		// Create 2 shared NSTs under S1
		//Create shared MST1 under S1 with 3 Statuses
		//create 3 statuses under MST1
		//Create shared MST2 selecting shift 1 as expiration under S1 with 3 Statuses
		//create 3 statuses under MST2
		//Create 2 ResourceTypes
		//Create 4 Resources selecting NST1, NST2, MST1, MST2 (RS1 & RS2 under RT1, RS3, RS4 under RT2)
		//Create shared RS1 & RS2 with Address under RT1
		//Creating shared RS3 & RS4 with Address under RT2
		//Edit region default view
		//Select resources RS1 and RS2 under 'Resources' Tab
		//Select NST1, NST2, MST1, & MST2 Under 'Status Types' Tab
		//Customize Region Default as below:
		//select 'Status By column' corresponding RT1
		//select 'Comments' corresponding RS1
		//de-select 'New RT added in future'
		//Create 'Alternate View' selecting resources RS1, RS2, RS3, RS4
		//and Status Types NST1, NST2, MST1, MST2
		//Customize 'Alternate View' as below:
		//select 'Status By column' corresponding RT1, RT2 & 'New RT added in future'
		//select 'Future Resources' corresponding RS1
		//Create 'Smoke Test View' selecting resources RS1 & RS2
		//and Status Types NST1 & MST2 
		//Customize 'Smoke Test View' as below:
		//select 'Status By column' corresponding RT1, RT2 & 'New RT added in future'
		//select 'Future Resources' corresponding RS1
		//select 'Comments' corresponding RT1, RT2
		//Create 'Smoke Test View2' selecting resources RS1 & RS2
		//and Status Types MST1
		//Customize 'Smoke Test View2' as below:
		//select 'Status By column' corresponding RT1, RT2 & 'New RT added in future'
		//select 'Future Resources' corresponding RT1
		//select 'Comments' corresponding RT1, RT2
		//Create 'Smoke Test View3' selecting resources RS1 & RS2
		//and Status Types NST2 & MST1
		//Customize 'Smoke Test View3' as below:
		//select 'Status By column' corresponding RT2 & 'New RT added in future'
		//select 'Future Resources' corresponding RS1
		//select 'Comments' corresponding RT1, RT2
		//de-select 'Comments' corresponding 'New RT added in future'
		//select 'Status' under 'Sort Resources' and select 'S2' corresponding to RT1
		//Create 'Smoke Test View4' selecting resources RS1 & RS2
		//and Status Types NST2 & MST2
		//Customize 'Smoke Test View4' as below:
		//select 'Status By column' corresponding RT1, RT2 & 'New RT added in future'
		//select 'Future Resources' corresponding RS1 & 'New RT added in future'
		//select 'Comments' corresponding RT1, RT2
		//de-select 'Comments' corresponding 'New RT added in future'
		//select 'Future Resources' corresponding RT1, RT2 & 'New RT added in future'
		//Create 'New View' selecting resources RS1 & RS2
		//and Status Types NST1, NST2, MST1 & MST2
		//Customize 'New View' as below:
		//select 'Status By column' corresponding RT1, RT2 & 'New RT added in future'
		//select 'Future Resources' corresponding RS1 & 'New RT added in future'
		//select 'Comments' corresponding RT1, RT2
		//de-select 'Comments' corresponding 'New RT added in future'
		//select 'Status' (MST2) under 'Sort Resources' and select 'S1' corresponding to RT1
		//select 'Status' (MST2) under 'Sort Resources' and select 'S2' corresponding to RT1
		//Create 'Test View' selecting resources RS1 & RS2
		//and Status Types NST2 & MST1
		//Customize 'Test View' as below:
		//select 'Status By column' corresponding RT1 & 'New RT added in future'
		//select 'Future Resources' corresponding RT1
		//select 'Comments' corresponding RT1
		//de-select 'Comments' corresponding 'New RT added in future'
		//Create a User B with Setup - Views right and Update Right on all resources.	

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.views();

		viewUnderSetup.createNewSection(viewDataCreation.section_2);

		navigateTo.statusTypes();
		statusTypes.createSharedStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description, viewDataCreation.section_2);
		statusTypeValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName);

		statusTypes.createSharedStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName1, statusTypeDataCreation.description, viewDataCreation.section_2);
		statusTypeValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName1);

		statusTypes.createSharedStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description, viewDataCreation.section_2);

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName, StatusTypeData.STATUS_PURPLE_COLOR);

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR);

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName2, StatusTypeData.STATUS_PURPLE_COLOR);

		statusesValues[0] = statusTypes.getStatusesValue(statusTypeDataCreation.statusesName);

		statusesValues[1] = statusTypes.getStatusesValue(statusTypeDataCreation.statusesName1);

		statusesValues[2] = statusTypes.getStatusesValue(statusTypeDataCreation.statusesName2);

		statusTypes.clickOnReturnToStatusTypeList();

		statusTypeValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName);

		statusTypes.createSharedStatusTypeWithShiftTime(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName1, statusTypeDataCreation.description, 
				StatusTypeData.SHIFTTIMEINHOUR, StatusTypeData.SHIFTTIMEINMIN, viewDataCreation.section_2);

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName3, StatusTypeData.STATUS_PURPLE_COLOR);

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName4, StatusTypeData.STATUS_PURPLE_COLOR);

		statusTypes.createNewStatus(statusTypeDataCreation.statusesName5, StatusTypeData.STATUS_PURPLE_COLOR);

		statusesValues[3] = statusTypes.getStatusesValue(statusTypeDataCreation.statusesName3);

		statusesValues[4] = statusTypes.getStatusesValue(statusTypeDataCreation.statusesName4);

		statusesValues[5] = statusTypes.getStatusesValue(statusTypeDataCreation.statusesName5);

		statusTypes.clickOnReturnToStatusTypeList();

		statusTypeValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName1);

		navigateTo.resourceType();

		resourceTypes.createResourceType(resourceTypeDataCreation.name, statusTypeValue);
		resourceTypeValue[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);

		resourceTypes.createResourceType(resourceTypeDataCreation.name1, statusTypeValue);

		resourceTypeValue[1] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name1);

		navigateTo.resources();

		resources.createSharedResourceWithAddress(resourceDataCreation.name, resourceDataCreation.abbrevation, resourceTypeDataCreation.name, 
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME,
				ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resourceValue[0] = resources.getResourceValue(resourceDataCreation.name);

		resources.createSharedResourceWithAddress(resourceDataCreation.name1, resourceDataCreation.abbrevation1, resourceTypeDataCreation.name, 
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME,
				ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resourceValue[1] = resources.getResourceValue(resourceDataCreation.name1);

		resources.createSharedResourceWithAddress(resourceDataCreation.name2, resourceDataCreation.abbrevation2, resourceTypeDataCreation.name1, 
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME,
				ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resourceValue[2] = resources.getResourceValue(resourceDataCreation.name2);

		resources.createSharedResourceWithAddress(resourceDataCreation.name3, resourceDataCreation.abbrevation3, resourceTypeDataCreation.name1, 
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME,
				ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resourceValue[3] = resources.getResourceValue(resourceDataCreation.name3);

		String statusTypeNames[] = {statusTypeDataCreation.nstName, statusTypeDataCreation.nstName1, statusTypeDataCreation.mstName, statusTypeDataCreation.mstName1};
		String resourceNames[] ={resourceDataCreation.name, resourceDataCreation.name1, resourceDataCreation.name2, resourceDataCreation.name3};		
		navigateTo.views();

		//		view.clickOnEditOfRegDefault();
		//
		//		view.clickOnResourcesSection()
		//		.selectResource(resourceDataCreation.name)
		//		.selectResource(resourceDataCreation.name1)
		//		.clickOnStatusTypeSection()
		//		.selectStatusType(statusTypeNames)
		//		.clickOnAdvancedSection()
		//		.selectStatusesByColumn(resourceTypeDataCreation.name)
		//		.selectComments(resourceTypeDataCreation.name)
		//		.deselectNewRTAddedInFutureComments()
		//		.clickOnSaveOfCreateNewView();

		viewUnderSetup.createViewSelectingMultipleRSAndST(viewDataCreation.name, viewDataCreation.description, resourceNames, statusTypeNames)
		.clickOnAdvancedSection()
		.selectStatusesByColumn(resourceTypeDataCreation.name)
		.selectStatusesByColumn(resourceTypeDataCreation.name1)
		.selectComments(resourceTypeDataCreation.name)
		.selectComments(resourceTypeDataCreation.name1)
		.selectTimeStamp(resourceTypeDataCreation.name)
		.selectTimeStamp(resourceTypeDataCreation.name1)
		.selectUser(resourceTypeDataCreation.name)
		.selectUser(resourceTypeDataCreation.name1)
		//		.selectNewRTAddedInFuture()
		//		.selectNewRTAddedInFutureStatusesbyColumn()
		//		.selectNewRTAddedInFutureComments()
		//		.selectFutureResources(resourceTypeDataCreation.name)
		//		.selectFutureResources(resourceTypeDataCreation.name1)
		//		.selectNewRTAddedInFutureResources()
		.clickOnSave();

		//		String statusTypeNames1[] = { statusTypeDataCreation.nstName1, statusTypeDataCreation.mstName1};

		viewUnderSetup.createViewSelectingMultipleRSAndST(viewDataCreation.name1, viewDataCreation.description1, resourceNames, statusTypeNames)//Smoke test view
		.clickOnAdvancedSection()
		.selectStatusesByColumn(resourceTypeDataCreation.name)
		.selectStatusesByColumn(resourceTypeDataCreation.name1)
		.deselectComments(resourceTypeDataCreation.name)
		.deselectComments(resourceTypeDataCreation.name1)
		.deselectTimeStamp(resourceTypeDataCreation.name)
		.deselectTimeStamp(resourceTypeDataCreation.name1)
		.deselectUser(resourceTypeDataCreation.name)
		.deselectUser(resourceTypeDataCreation.name1)
		//		.selectNewRTAddedInFuture()
		//		.selectNewRTAddedInFutureStatusesbyColumn()
		//		.deselectNewRTAddedInFutureComments()
		//		.selectFutureResources(resourceTypeDataCreation.name)
		//		.selectFutureResources(resourceTypeDataCreation.name1)
		//		.selectNewRTAddedInFutureResources()
		.clickOnSave();

		//		String statusTypeNames2[] = {statusTypeDataCreation.mstName};

		viewUnderSetup.createViewSelectingMultipleRSAndST(viewDataCreation.name2, viewDataCreation.description2, resourceNames, statusTypeNames)//Smoke test view2
		.clickOnAdvancedSection()
		.selectStatusesByColumn(resourceTypeDataCreation.name)
		.selectStatusesByColumn(resourceTypeDataCreation.name1)
		.selectComments(resourceTypeDataCreation.name)
		.selectComments(resourceTypeDataCreation.name1)
		.deselectTimeStamp(resourceTypeDataCreation.name)
		.deselectTimeStamp(resourceTypeDataCreation.name1)
		.deselectUser(resourceTypeDataCreation.name)
		.deselectUser(resourceTypeDataCreation.name1)
		//		.selectNewRTAddedInFuture()
		//		.selectNewRTAddedInFutureStatusesbyColumn()
		//		.deselectNewRTAddedInFutureComments()
		//		.selectFutureResources(resourceTypeDataCreation.name)
		//		.selectFutureResources(resourceTypeDataCreation.name1)
		//		.selectNewRTAddedInFutureResources()
		.clickOnSave();

		//		String statusTypeNames3[] = {statusTypeDataCreation.nstName, statusTypeDataCreation.mstName};

		viewUnderSetup.createViewSelectingMultipleRSAndST(viewDataCreation.name3, viewDataCreation.description3, resourceNames, statusTypeNames)//Smoke test view3
		.clickOnAdvancedSection()
		.deselectStatusesByColumn(resourceTypeDataCreation.name)
		.deselectStatusesByColumn(resourceTypeDataCreation.name1)
		.selectComments(resourceTypeDataCreation.name)
		.selectComments(resourceTypeDataCreation.name1)
		.selectTimeStamp(resourceTypeDataCreation.name)
		.selectTimeStamp(resourceTypeDataCreation.name1)
		.deselectUser(resourceTypeDataCreation.name)
		.deselectUser(resourceTypeDataCreation.name1)
		//		.selectNewRTAddedInFuture()
		//		.selectNewRTAddedInFutureStatusesbyColumn()
		//		.deselectNewRTAddedInFutureComments()
		//		.selectFutureResources(resourceTypeDataCreation.name)
		//		.selectFutureResources(resourceTypeDataCreation.name1)
		//		.selectNewRTAddedInFutureResources()
		//		.deselectnewRTAddedInFutureUser()
		//		.selectTimeStamp(resourceTypeDataCreation.name)
		.clickOnSave();

		//		String statusTypeNames4[] = {statusTypeDataCreation.nstName1, statusTypeDataCreation.mstName};
		//
		//		view.createViewSelectingMultipleRSAndST(viewDataCreation.name4, viewDataCreation.description4, resourceNames, statusTypeNames4)//Smoke test view4
		//		.clickOnAdvancedSection()
		//		.selectStatusesByColumn(resourceTypeDataCreation.name)
		//		.selectStatusesByColumn(resourceTypeDataCreation.name1)
		//		.selectComments(resourceTypeDataCreation.name)
		//		.selectComments(resourceTypeDataCreation.name1)
		//		.selectNewRTAddedInFuture()
		//		.selectNewRTAddedInFutureStatusesbyColumn()
		//		.deselectNewRTAddedInFutureComments()
		//		.selectFutureResources(resourceTypeDataCreation.name)
		//		.selectFutureResources(resourceTypeDataCreation.name1)
		//		.selectNewRTAddedInFutureResources()
		//		.clickOnSave();
		//
		//		view.createViewSelectingMultipleRSAndST(viewDataCreation.name5, viewDataCreation.description5, resourceNames, statusTypeNames)//Smoke test view5
		//		.clickOnAdvancedSection()
		//		.selectStatusesByColumn(resourceTypeDataCreation.name)
		//		.selectStatusesByColumn(resourceTypeDataCreation.name1)
		//		.selectComments(resourceTypeDataCreation.name)
		//		.selectComments(resourceTypeDataCreation.name1)
		//		.selectNewRTAddedInFuture()
		//		.selectNewRTAddedInFutureStatusesbyColumn()
		//		.deselectNewRTAddedInFutureComments()
		//		.selectFutureResources(resourceTypeDataCreation.name)
		//		.selectFutureResources(resourceTypeDataCreation.name1)
		//		.selectNewRTAddedInFutureResources()
		//		.clickOnSave();
		//
		//		view.createViewSelectingMultipleRSAndST(viewDataCreation.name6, viewDataCreation.description6, resourceNames, statusTypeNames)//Smoke test view5
		//		.clickOnAdvancedSection()
		//		.selectStatusesByColumn(resourceTypeDataCreation.name)
		//		.deselectStatusesByColumn(resourceTypeDataCreation.name1)
		//		.selectComments(resourceTypeDataCreation.name)
		//		.deselectComments(resourceTypeDataCreation.name1)
		//		.deselectNewRTAddedInFuture()
		//		.selectNewRTAddedInFutureStatusesbyColumn()
		//		.deselectNewRTAddedInFutureComments()
		//		.selectFutureResources(resourceTypeDataCreation.name)
		//		.selectFutureResources(resourceTypeDataCreation.name1)
		//		.deselectNewRTAddedInFutureResources()
		//		.clickOnSave();

		navigateTo.users();

		usersList.createUserWithUpdateRightOnResource(userDataCreation.name, UsersData.INITIAL_PASSWORD,
				userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceNames)
				.provideViewCustomViewRight()
				.provideConfigureRegionViewsRightAndSave();

		login.logOut()
		.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.customView();
		viewsList.createCustomView(resourceDataCreation.name.substring(3), resourceValue, statusTypeValue);
		login.logOut();

		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.nstName, StatusTypeTags.VIEWS_SHARED_NUMBER_STATUSTYPE_NAME);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.nstName1, StatusTypeTags.VIEWS_SHARED_NUMBER_STATUSTYPE_NAME_1);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.mstName, StatusTypeTags.VIEWS_SHARED_MULTI_STATUSTYPE_NAME);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.mstName1, StatusTypeTags.VIEWS_SHARED_MULTI_STATUSTYPE_NAME_1);

		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.statusesName, StatusTypeTags.VIEWS_STATUSES_NAME1);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.statusesName1, StatusTypeTags.VIEWS_STATUSES_NAME2);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.statusesName2, StatusTypeTags.VIEWS_STATUSES_NAME3);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.statusesName3, StatusTypeTags.VIEWS_STATUSES_NAME4);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.statusesName4, StatusTypeTags.VIEWS_STATUSES_NAME5);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeDataCreation.statusesName5, StatusTypeTags.VIEWS_STATUSES_NAME6);

		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeValue[0], StatusTypeTags.VIEWS_SHARED_NUMBER_STATUSTYPE_VALUE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeValue[1], StatusTypeTags.VIEWS_SHARED_NUMBER_STATUSTYPE_VALUE_1);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeValue[2], StatusTypeTags.VIEWS_SHARED_MULTI_STATUSTYPE_VALUE);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusTypeValue[3], StatusTypeTags.VIEWS_SHARED_MULTI_STATUSTYPE_VALUE_1);

		statusTypeDataCreation.writeStatusTypesDataToXml(statusesValues[0], StatusTypeTags.VIEWS_STATUSES_VALUE1);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusesValues[1], StatusTypeTags.VIEWS_STATUSES_VALUE2);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusesValues[2], StatusTypeTags.VIEWS_STATUSES_VALUE3);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusesValues[3], StatusTypeTags.VIEWS_STATUSES_VALUE4);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusesValues[4], StatusTypeTags.VIEWS_STATUSES_VALUE5);
		statusTypeDataCreation.writeStatusTypesDataToXml(statusesValues[5], StatusTypeTags.VIEWS_STATUSES_VALUE6);

		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeDataCreation.name, ResourceTypeTags.VIEWS_RESOURCE_TYPE_NAME);
		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeDataCreation.name1, ResourceTypeTags.VIEWS_RESOURCE_TYPE_NAME_1);
		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeValue[0], ResourceTypeTags.VIEWS_RESOURCE_TYPE_VALUE);
		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeValue[1], ResourceTypeTags.VIEWS_RESOURCE_TYPE_VALUE);

		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.name, ResourceTags.VIEWS_RESOURCE_NAME);
		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.name1, ResourceTags.VIEWS_RESOURCE_NAME_1);
		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.name2, ResourceTags.VIEWS_RESOURCE_NAME_2);
		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.name3, ResourceTags.VIEWS_RESOURCE_NAME_3);

		resourceDataCreation.writeResourceDataToXml(resourceValue[0], ResourceTags.VIEWS_RESOURCE_VALUE);
		resourceDataCreation.writeResourceDataToXml(resourceValue[1], ResourceTags.VIEWS_RESOURCE_VALUE_1);
		resourceDataCreation.writeResourceDataToXml(resourceValue[2], ResourceTags.VIEWS_RESOURCE_VALUE_2);
		resourceDataCreation.writeResourceDataToXml(resourceValue[3], ResourceTags.VIEWS_RESOURCE_VALUE_3);

		viewDataCreation.writeViewDataToXml(viewDataCreation.name, ViewTags.SMOKE_HYBRID_VIEW);
		viewDataCreation.writeViewDataToXml(viewDataCreation.name1, ViewTags.SMOKE_SUMMARY_VIEW);
		viewDataCreation.writeViewDataToXml(viewDataCreation.name2, ViewTags.SMOKE_SUMMARY_PLUS_VIEW);
		viewDataCreation.writeViewDataToXml(viewDataCreation.name3, ViewTags.SMOKE_RESOURCE_VIEW);

		userDataCreation.writeUsersDataToXml(userDataCreation.name, UsersTags.USER_WITH_VIEW_CUTOM_VIEW_RIGHT);
		userDataCreation.writeUsersDataToXml(userDataCreation.fullName, UsersTags.USER_FULLNAME_VIEW_CUTOM_VIEW_RIGHT);
		Result = "PASS";
	}
}
