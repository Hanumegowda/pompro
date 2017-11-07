package DatabaseRefresh_DataCreation.HappyDay;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;
import EMR.data.EventSetUpData;
import EMR.data.EventSetUpData.EventSetUpTags;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.RolesData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.RegionData.RegionCreateData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceData.ResourceTags;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.ResourceTypeData.ResourceTypeTags;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.StatusTypeData.StatusTypeTags;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.UsersData.UsersTags;
import EMR.data.ViewData.ViewCreateData;
import EMR.data.ViewData.ViewTags;
import EMR.pages.ConfigureNewRelationship;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
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
import EMR.pages.ViewsUnderSetup;
import qaFramework.Configurations.Configuration;

public class MultiRegion extends Configuration {

	public MultiRegion() throws Exception {
		super();
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

	@Test(description ="Precondition for MultiRegion")
	public void Precondition_MultiRegion() throws Exception {

		TC_DESCRIPTION = "Precondition for 172447,172445,172443,172444,172441,172440";

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

		//region1
		String sharedSTValue[] = new String[6];
		String sharedStatusValues[]= new String[3];
		String resourceValue[] = new String[3];
		String resourceTypeValue[] = new String[1];

		String roleSTValue[] = new String[6];
		String roleStatusValues[]= new String[3];

		String privateSTValue[] = new String[6];
		String privateStatusValues[]= new String[3];

		String eventPrivateSTValue[] = new String[6];
		String eventPrivateStatusValues[]= new String[3];

		String eventRoleSTValue[] = new String[6];
		String eventRoleStatusValues[]= new String[3];

		String eventSharedSTValue[] = new String[6];
		String eventSharedStatusValues[]= new String[3];


		//region2 -- 6 shared STs 3 roleSTs, 3 eventRoleSTs
		String sharedSTValueInRG2[] = new String[6];
		String sharedStatusValuesInRG2[]= new String[3];

		String roleSTValueInRG2[] = new String[3];
		String roleStatusValuesInRG2[]= new String[3];

		String eventRoleSTValueInRG2[] = new String[3];

		String resourceValueInRG2[] = new String[2];
		String resourceTypeValueInRG2[] = new String[1];



		//region3 -- 6 shared STs 3 roleSTs, 3 eventRoleSTs
		String sharedSTValueInRG3[] = new String[6];
		String sharedStatusValuesInRG3[]= new String[3];

		String roleSTValueInRG3[] = new String[3];
		String roleStatusValuesInRG3[]= new String[3];

		String eventRoleSTValueInRG3[] = new String[3];

		String resourceValueInRG3[] = new String[2];
		String resourceTypeValueInRG3[] = new String[1];	





		//login to application.
		//Select region RG1.
		//Navigate to SetUp >> Views.
		//Click on 'Customize Resource Detail' button.
		//Create section'Section1'.
		//Navigate to SetUp >> StatusTypes.
		//Create following shared status types with sectiocn Section1.
		//Number,Multi,Text,Saturation,Nedocs,Date.
		//Navigate to SetUp >> ResourceType.
		//Create ResourceType (Rt1) by selecting all shared Status types which are created above.
		//Navigate to SetUp >> Resource.
		//Create Shared resource Rs1 (with address) by selecting resource type Rt1 and by selecting 'Share with Other Regions:'.
		//Create Shared resource Rs2 with address by selecting resource type Rt1 and by selecting 'Share with Other Regions:'.
		//Navigate to SetUp >> Views
		//Click on edit link corresponding to "Region default".
		//Select Shared resources Rs1 and Rs2 and save
		//Create a user A with rights -->View - Custom View, Event - Maintain Events , Preferences - Edit Status Change Notification Preferences,Setup Other Region Views
		//User A provided with primary mail id and pager id's.

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);

		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT2);
		navigateTo.otherRegion();
		configurRelationShip.createMutualAgreementIfNotCreated(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);

		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);

		navigateTo.otherRegion();
		configurRelationShip.createMutualAgreementIfNotCreated(RegionData.REGION_WITH_MUTUAL_AGREEMENT2);
		configurRelationShip.createMutualAgreementIfNotCreated(RegionData.REGION_WITH_MUTUAL_AGREEMENT3);

		navigateTo.viewUnderSetup();
		viewUnderSetup.createNewSection(viewDataCreation.section);
		viewUnderSetup.createNewSection(viewDataCreation.section_1);
		navigateTo.statusTypes();
		statusTypes.createSharedStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.sharedNST, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypes.createSharedStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.sharedMST, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName2, StatusTypeData.STATUS_PURPLE_COLOR);

		sharedStatusValues[0]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName);
		sharedStatusValues[1]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName1);
		sharedStatusValues[2]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName2);

		statusTypes.clickOnReturnToStatusTypeList()
		.createSharedStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.sharedTST, statusTypeDataCreation.description, viewDataCreation.section)
		.createSharedStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.sharedNEDOCS, statusTypeDataCreation.description, viewDataCreation.section)
		.createSharedStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sharedSST, statusTypeDataCreation.description, viewDataCreation.section)
		.createSharedStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.sharedDST, statusTypeDataCreation.description, viewDataCreation.section);

		sharedSTValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNST);
		sharedSTValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedMST);
		sharedSTValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedTST);
		sharedSTValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNEDOCS);
		sharedSTValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedSST);
		sharedSTValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedDST);

		String[] sharedStatusesNames = {statusTypeDataCreation.statusesName, statusTypeDataCreation.statusesName1, statusTypeDataCreation.statusesName2};

		String[] sharedSTNames={statusTypeDataCreation.sharedNST,statusTypeDataCreation.sharedMST,statusTypeDataCreation.sharedTST,statusTypeDataCreation.sharedNEDOCS,statusTypeDataCreation.sharedSST,statusTypeDataCreation.sharedDST};

		statusTypes.createEventSharedStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.sharedNST_1, statusTypeDataCreation.description, viewDataCreation.section_1);
		statusTypes.createEventSharedStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.sharedMST_1, statusTypeDataCreation.description, viewDataCreation.section_1);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName3, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName4, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName5, StatusTypeData.STATUS_PURPLE_COLOR);

		eventSharedStatusValues[0]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName3);
		eventSharedStatusValues[1]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName4);
		eventSharedStatusValues[2]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName5);

		String[] eventSharedStatusesNames = {statusTypeDataCreation.statusesName3, statusTypeDataCreation.statusesName4, statusTypeDataCreation.statusesName5};

		statusTypes.clickOnReturnToStatusTypeList()
		.createEventSharedStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.sharedTST_1, statusTypeDataCreation.description, viewDataCreation.section_1)
		.createEventSharedStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.sharedNEDOC_1, statusTypeDataCreation.description, viewDataCreation.section_1)
		.createEventSharedStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sharedSST_1, statusTypeDataCreation.description, viewDataCreation.section_1)
		.createEventSharedStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.sharedDST_1, statusTypeDataCreation.description, viewDataCreation.section_1);

		eventSharedSTValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNST_1);
		eventSharedSTValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedMST_1);
		eventSharedSTValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedTST_1);
		eventSharedSTValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNEDOC_1);
		eventSharedSTValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedSST_1);
		eventSharedSTValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedDST_1);

		String[] eventSharedSTNames={statusTypeDataCreation.sharedNST_1,statusTypeDataCreation.sharedMST_1,statusTypeDataCreation.sharedTST_1,statusTypeDataCreation.sharedNEDOC_1,statusTypeDataCreation.sharedSST_1,statusTypeDataCreation.sharedDST_1};

		statusTypes.createEventPrivateStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.sharedNST_2, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypes.createEventPrivateStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.sharedMST_2, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName6, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName7, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName8, StatusTypeData.STATUS_PURPLE_COLOR);

		eventPrivateStatusValues[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName6);
		eventPrivateStatusValues[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName7);
		eventPrivateStatusValues[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName8);

		String[] eventPrivateStatusesNames = {statusTypeDataCreation.statusesName6, statusTypeDataCreation.statusesName7, statusTypeDataCreation.statusesName8};

		statusTypes.clickOnReturnToStatusTypeList()
		.createEventPrivateStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.sharedTST_2, statusTypeDataCreation.description, viewDataCreation.section)
		.createEventPrivateStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.sharedNEDOC_2, statusTypeDataCreation.description, viewDataCreation.section)
		.createEventPrivateStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sharedSST_2, statusTypeDataCreation.description, viewDataCreation.section)
		.createEventPrivateStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.sharedDST_2, statusTypeDataCreation.description, viewDataCreation.section);

		eventPrivateSTValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNST_2);
		eventPrivateSTValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedMST_2);
		eventPrivateSTValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedTST_2);
		eventPrivateSTValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNEDOC_2);
		eventPrivateSTValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedSST_2);
		eventPrivateSTValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedDST_2);

		String[] eventPrivateSTNames={statusTypeDataCreation.sharedNST_2,statusTypeDataCreation.sharedMST_2,statusTypeDataCreation.sharedTST_2,statusTypeDataCreation.sharedNEDOC_2,statusTypeDataCreation.sharedSST_2,statusTypeDataCreation.sharedDST_2};

		statusTypes.createEventStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.eventNst, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypes.createEventStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.eventMst, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName9, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName10, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName11, StatusTypeData.STATUS_PURPLE_COLOR);

		eventRoleStatusValues[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName9);
		eventRoleStatusValues[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName10);
		eventRoleStatusValues[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName11);

		String[] eventRoleStatusesNames = {statusTypeDataCreation.statusesName9, statusTypeDataCreation.statusesName10, statusTypeDataCreation.statusesName11};

		statusTypes.clickOnReturnToStatusTypeList()
		.createEventStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.eventTst, statusTypeDataCreation.description, viewDataCreation.section)
		.createEventStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.eventNdst, statusTypeDataCreation.description, viewDataCreation.section)
		.createEventStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.eventSst, statusTypeDataCreation.description, viewDataCreation.section)
		.createEventStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.eventDst, statusTypeDataCreation.description, viewDataCreation.section);

		eventRoleSTValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.eventNst);
		eventRoleSTValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.eventMst);
		eventRoleSTValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.eventTst);
		eventRoleSTValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.eventNdst);
		eventRoleSTValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.eventSst);
		eventRoleSTValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.eventDst);

		String[] eventSTNames={statusTypeDataCreation.eventNst,statusTypeDataCreation.eventMst,statusTypeDataCreation.eventTst,statusTypeDataCreation.eventNdst,statusTypeDataCreation.eventSst,statusTypeDataCreation.eventDst};

		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName12, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName13, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName14, StatusTypeData.STATUS_PURPLE_COLOR);

		roleStatusValues[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName12);
		roleStatusValues[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName13);
		roleStatusValues[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName14);

		statusTypes.clickOnReturnToStatusTypeList()
		.createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.tstName, statusTypeDataCreation.description, viewDataCreation.section)
		.createStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.nedocsName, statusTypeDataCreation.description, viewDataCreation.section)
		.createStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sstName, statusTypeDataCreation.description, viewDataCreation.section)
		.createStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.dateName, statusTypeDataCreation.description, viewDataCreation.section);

		roleSTValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName);
		roleSTValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName);
		roleSTValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName);
		roleSTValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nedocsName);
		roleSTValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sstName);
		roleSTValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.dateName);

		String[] roleStatusesNames = {statusTypeDataCreation.statusesName12, statusTypeDataCreation.statusesName13, statusTypeDataCreation.statusesName14};
		String[] roleSTNames = {statusTypeDataCreation.nstName,statusTypeDataCreation.mstName,statusTypeDataCreation.tstName,statusTypeDataCreation.nedocsName,statusTypeDataCreation.sstName,statusTypeDataCreation.dateName};

		statusTypes.createPrivateStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.privateNST, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypes.createPrivateStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.privateMST, statusTypeDataCreation.description, viewDataCreation.section);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName15, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName16, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName17, StatusTypeData.STATUS_PURPLE_COLOR);

		privateStatusValues[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName15);
		privateStatusValues[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName16);
		privateStatusValues[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName17);


		statusTypes.clickOnReturnToStatusTypeList()
		.createPrivateStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.privateTST, statusTypeDataCreation.description, viewDataCreation.section)
		.createPrivateStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.privateNedocST, statusTypeDataCreation.description, viewDataCreation.section)
		.createPrivateStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.privateSST, statusTypeDataCreation.description, viewDataCreation.section)
		.createPrivateStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.privateDST, statusTypeDataCreation.description, viewDataCreation.section);

		privateSTValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.privateNST);
		privateSTValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.privateMST);
		privateSTValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.privateTST);
		privateSTValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.privateNedocST);
		privateSTValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.privateSST);
		privateSTValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.privateDST);

		String[] privateStatusesNames = {statusTypeDataCreation.statusesName15, statusTypeDataCreation.statusesName16, statusTypeDataCreation.statusesName17};
		String[] privateSTNames = {statusTypeDataCreation.privateNST,statusTypeDataCreation.privateMST,statusTypeDataCreation.privateTST,statusTypeDataCreation.privateNedocST,statusTypeDataCreation.privateSST,statusTypeDataCreation.privateDST};

		String[] statusTypeValues = ArrayUtils.addAll(sharedSTValue, privateSTValue);
		statusTypeValues = ArrayUtils.addAll(statusTypeValues, eventPrivateSTValue);
		statusTypeValues = ArrayUtils.addAll(statusTypeValues, eventRoleSTValue);
		statusTypeValues = ArrayUtils.addAll(statusTypeValues, eventSharedSTValue);
		statusTypeValues = ArrayUtils.addAll(statusTypeValues, roleSTValue);

		String[] STNames =  ArrayUtils.addAll(roleSTNames, sharedSTNames);
		STNames = ArrayUtils.addAll(STNames, eventSharedSTNames);
		STNames = ArrayUtils.addAll(STNames, eventPrivateSTNames);
		STNames = ArrayUtils.addAll(STNames, eventSTNames);
		STNames = ArrayUtils.addAll(STNames, privateSTNames);
		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, statusTypeValues);
		resourceTypeValue[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);

		navigateTo.resources();
		resources.createResourceWithAddress(resourceDataCreation.name, resourceDataCreation.abbrevation, resourceTypeDataCreation.name, 
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
				ResourceData.LASTNAME, ResourceData.STREETADDRESS,
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resourceValue[0] = resources.getResourceValue(resourceDataCreation.name);

		resources.createSharedResourceWithAddress(
				resourceDataCreation.sharedRS_Name, resourceDataCreation.abbrevation1,
				resourceTypeDataCreation.name, ResourceData.STANDARDRESOURCETYPE,
				ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, 
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resourceValue[1] = resources.getResourceValue(resourceDataCreation.sharedRS_Name);

		resources.createSharedResourceWithAddress(
				resourceDataCreation.sharedRS_Name1, resourceDataCreation.abbrevation2,
				resourceTypeDataCreation.name, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
				ResourceData.LASTNAME, ResourceData.STREETADDRESS,
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resourceValue[2] = resources.getResourceValue(resourceDataCreation.sharedRS_Name1);

		String[] resourceNames={resourceDataCreation.name, resourceDataCreation.sharedRS_Name, resourceDataCreation.sharedRS_Name1};

		navigateTo.viewUnderSetup();
		viewUnderSetup.addResourceAndStatusTypesToRegionDefaultView(RegionData.REGION_WITH_MUTUAL_AGREEMENT1, resourceNames, STNames);
		navigateTo.users();
		usersList.createUserWithUpdateRightOnResource(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceNames)
		.provideViewCustomViewRight()
		.provideMaintainEventsRight()
		.provideSetupOtherRegionViewsRight()
		.provideEditStatusChangeNotificationPreferencesAndSave();

		navigateTo.eventSetUp();
		eventSetUp.createEventTemplate(eventSetupDataCreation.name, eventSetupDataCreation.definition, resourceTypeValue[0], statusTypeValues);

		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT2);

		navigateTo.otherRegion();
		configurRelationShip.createMutualAgreementIfNotCreated(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);

		navigateTo.viewUnderSetup();
		viewUnderSetup.createNewSection(viewDataCreation.section_2);

		//Create following shared status types with  Section1.
		//Number1,Multi1,Text1,Satiration1,Nedocs1,Date1.
		navigateTo.statusTypes();
		statusTypes.createSharedStatusType(StatusTypeData.DATETYPE,statusTypeDataCreation.sharedDST_3 , statusTypeDataCreation.description, viewDataCreation.section_2)
		.createSharedStatusType(StatusTypeData.MULTITYPE,statusTypeDataCreation.sharedMST_3 , statusTypeDataCreation.description, viewDataCreation.section_2)
		.createNewStatus(statusTypeDataCreation.statusesName18, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName19, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName20, StatusTypeData.STATUS_PURPLE_COLOR);

		sharedStatusValuesInRG2[0]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName18);
		sharedStatusValuesInRG2[1]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName19);
		sharedStatusValuesInRG2[2]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName20);

		statusTypes.clickOnReturnToStatusTypeList()
		.createSharedStatusType(StatusTypeData.NEDOCSTYPE,statusTypeDataCreation.sharedNEDOC_3 , statusTypeDataCreation.description, viewDataCreation.section_2)
		.createSharedStatusType(StatusTypeData.NUMBERTYPE,statusTypeDataCreation.sharedNST_3 , statusTypeDataCreation.description, viewDataCreation.section_2)
		.createSharedStatusType(StatusTypeData.SATURATIONSCORETYPE,statusTypeDataCreation.sharedSST_3 , statusTypeDataCreation.description, viewDataCreation.section_2)
		.createSharedStatusType(StatusTypeData.TEXTTYPE,statusTypeDataCreation.sharedTST_3 , statusTypeDataCreation.description, viewDataCreation.section_2);

		sharedSTValueInRG2[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNST_3);
		sharedSTValueInRG2[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedMST_3);
		sharedSTValueInRG2[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedTST_3);
		sharedSTValueInRG2[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNEDOC_3);
		sharedSTValueInRG2[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedSST_3);
		sharedSTValueInRG2[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedDST_3);

		String sharedSTNamesInRG2[]={statusTypeDataCreation.sharedNST_3,statusTypeDataCreation.sharedMST_3,statusTypeDataCreation.sharedTST_3,statusTypeDataCreation.sharedNEDOC_3,statusTypeDataCreation.sharedSST_3,statusTypeDataCreation.sharedDST_3};
		String[] sharedStatusesNamesInRG2 = {statusTypeDataCreation.statusesName18, statusTypeDataCreation.statusesName19, statusTypeDataCreation.statusesName20};

		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName1, statusTypeDataCreation.description, viewDataCreation.section_2);
		statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName1, statusTypeDataCreation.description, viewDataCreation.section_2);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName21, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName22, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName23, StatusTypeData.STATUS_PURPLE_COLOR);

		roleStatusValuesInRG2[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName21);
		roleStatusValuesInRG2[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName22);
		roleStatusValuesInRG2[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName23);

		statusTypes.clickOnReturnToStatusTypeList()
		.createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.tstName1, statusTypeDataCreation.description, viewDataCreation.section_2);

		roleSTValueInRG2[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName1);
		roleSTValueInRG2[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName1);
		roleSTValueInRG2[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName1);

		String[] roleStatusesNamesInRG2 = {statusTypeDataCreation.statusesName21, statusTypeDataCreation.statusesName22, statusTypeDataCreation.statusesName23};
		String[] roleSTNamesInRG2 = { statusTypeDataCreation.nstName1,statusTypeDataCreation.mstName1,statusTypeDataCreation.tstName1 };

		statusTypes.createEventStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.eventNdst1, statusTypeDataCreation.description, viewDataCreation.section_2)
		.createEventStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.eventSst1, statusTypeDataCreation.description, viewDataCreation.section_2)
		.createEventStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.eventDst1, statusTypeDataCreation.description, viewDataCreation.section_2);

		eventRoleSTValueInRG2[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.eventNdst1);
		eventRoleSTValueInRG2[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.eventSst1);
		eventRoleSTValueInRG2[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.eventDst1);

		String eventRoleSTNamesInRG2[]={statusTypeDataCreation.eventNdst1,statusTypeDataCreation.eventSst1,statusTypeDataCreation.eventDst1};

		String[] statusTypeValueInRG2 = ArrayUtils.addAll(sharedSTValueInRG2, roleSTValueInRG2);
		statusTypeValueInRG2 = ArrayUtils.addAll(statusTypeValueInRG2, eventRoleSTValueInRG2);

		String[] statusTypeNamesInRG2 = ArrayUtils.addAll(sharedSTNamesInRG2, roleSTNamesInRG2);
		statusTypeNamesInRG2 = ArrayUtils.addAll(statusTypeNamesInRG2, eventRoleSTNamesInRG2);

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name1, statusTypeValueInRG2);
		resourceTypeValueInRG2[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name1);

		navigateTo.resources();
		resources.createSharedResourceWithAddress(resourceDataCreation.sharedRS_Name2, resourceDataCreation.abbrevation3, resourceTypeDataCreation.name1, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,ResourceData.COUNTY );
		resources.createResourceWithAddress(resourceDataCreation.name2, resourceDataCreation.abbrevation4, resourceTypeDataCreation.name1, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,ResourceData.COUNTY );

		resourceValueInRG2[0]=resources.getResourceValue(resourceDataCreation.sharedRS_Name2);
		resourceValueInRG2[1]=resources.getResourceValue(resourceDataCreation.name2);

		String[] resourceNamesInRG2={resourceDataCreation.sharedRS_Name2,resourceDataCreation.name2};
		String[] resourceNamesInRG3={resourceDataCreation.sharedRS_Name3,resourceDataCreation.name3};
		String[] shared_RS_Names_RG3={resourceDataCreation.sharedRS_Name3};
		String[] shared_RS_Names_RG1={resourceDataCreation.sharedRS_Name, resourceDataCreation.sharedRS_Name1};
		String[] shared_RS_Names_RG2={resourceDataCreation.sharedRS_Name2};

		navigateTo.views();
		viewUnderSetup.addResourceAndStatusTypesToRegionDefaultView(RegionData.REGION_WITH_MUTUAL_AGREEMENT2, resourceNamesInRG2, statusTypeNamesInRG2)
		.addResourceAndStatusTypesToRegionDefaultView(RegionData.REGION_WITH_MUTUAL_AGREEMENT1, shared_RS_Names_RG1, sharedSTNames);

		//Create a user 'B' having update right on Rs3 and Rs4 and 'Maintain Event right' and 'Setup Other Region Views' under advanced section.
		navigateTo.users();
		usersList.createUserWithUpdateRightOnResource(userDataCreation.name1,UsersData.INITIAL_PASSWORD, userDataCreation.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceNamesInRG2)
		.provideSetupOtherRegionViewsRight()
		.provideViewCustomViewRight()
		.provideMaintainEventsRight()
		.provideEditStatusChangeNotificationPreferencesAndSave();

		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT3);

		navigateTo.otherRegion();
		configurRelationShip.createMutualAgreementIfNotCreated(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);

		navigateTo.viewUnderSetup();
		viewUnderSetup.createNewSection(viewDataCreation.section_3);

		//Create following shared status types with  Section1.
		//Number1,Multi1,Text1,Satiration1,Nedocs1,Date1.
		navigateTo.statusTypes();
		statusTypes.createSharedStatusType(StatusTypeData.DATETYPE,statusTypeDataCreation.sharedDST_4 , statusTypeDataCreation.description, viewDataCreation.section_3)
		.createSharedStatusType(StatusTypeData.MULTITYPE,statusTypeDataCreation.sharedMST_4 , statusTypeDataCreation.description, viewDataCreation.section_3)
		.createNewStatus(statusTypeDataCreation.statusesName24, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName25, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName26, StatusTypeData.STATUS_PURPLE_COLOR);

		sharedStatusValuesInRG3[0]	=statusTypes.getStatusesValue(statusTypeDataCreation.statusesName24);
		sharedStatusValuesInRG3[1]	=statusTypes.getStatusesValue(statusTypeDataCreation.statusesName25);
		sharedStatusValuesInRG3[2]	=statusTypes.getStatusesValue(statusTypeDataCreation.statusesName26);

		statusTypes.clickOnReturnToStatusTypeList()
		.createSharedStatusType(StatusTypeData.NEDOCSTYPE,statusTypeDataCreation.sharedNEDOC_4 , statusTypeDataCreation.description, viewDataCreation.section_3)
		.createSharedStatusType(StatusTypeData.NUMBERTYPE,statusTypeDataCreation.sharedNST_4 , statusTypeDataCreation.description, viewDataCreation.section_3)
		.createSharedStatusType(StatusTypeData.SATURATIONSCORETYPE,statusTypeDataCreation.sharedSST_4 , statusTypeDataCreation.description, viewDataCreation.section_3)
		.createSharedStatusType(StatusTypeData.TEXTTYPE,statusTypeDataCreation.sharedTST_4 , statusTypeDataCreation.description, viewDataCreation.section_3);

		sharedSTValueInRG3[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNST_4);
		sharedSTValueInRG3[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedMST_4);
		sharedSTValueInRG3[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedTST_4);
		sharedSTValueInRG3[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNEDOC_4);
		sharedSTValueInRG3[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedSST_4);
		sharedSTValueInRG3[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedDST_4);

		String sharedSTNamesInRG3[]={statusTypeDataCreation.sharedNST_4,statusTypeDataCreation.sharedMST_4,statusTypeDataCreation.sharedTST_4,statusTypeDataCreation.sharedNEDOC_4,statusTypeDataCreation.sharedSST_4,statusTypeDataCreation.sharedDST_4};
		String[] sharedStatusesNamesInRG3 = {statusTypeDataCreation.statusesName24, statusTypeDataCreation.statusesName25, statusTypeDataCreation.statusesName26};

		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName2, statusTypeDataCreation.description, viewDataCreation.section_3);
		statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName2, statusTypeDataCreation.description, viewDataCreation.section_3);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName27, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName28, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName29, StatusTypeData.STATUS_PURPLE_COLOR);

		roleStatusValuesInRG3[0] = statusTypes.getStatusesValue(statusTypeDataCreation.statusesName27);
		roleStatusValuesInRG3[1] = statusTypes.getStatusesValue(statusTypeDataCreation.statusesName28);
		roleStatusValuesInRG3[2] = statusTypes.getStatusesValue(statusTypeDataCreation.statusesName29);

		statusTypes.clickOnReturnToStatusTypeList()
		.createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.tstName2, statusTypeDataCreation.description, viewDataCreation.section_3);

		roleSTValueInRG3[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName2);
		roleSTValueInRG3[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName2);
		roleSTValueInRG3[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName2);

		String[] roleStatusesNamesInRG3 = {statusTypeDataCreation.statusesName27, statusTypeDataCreation.statusesName28, statusTypeDataCreation.statusesName29};
		String[] roleSTNamesInRG3 = { statusTypeDataCreation.nstName2,statusTypeDataCreation.mstName2,statusTypeDataCreation.tstName2 };

		statusTypes.createEventStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.eventNdst2, statusTypeDataCreation.description, viewDataCreation.section_3)
		.createEventStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.eventSst2, statusTypeDataCreation.description, viewDataCreation.section_3)
		.createEventStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.eventDst2, statusTypeDataCreation.description, viewDataCreation.section_3);

		eventRoleSTValueInRG3[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.eventNdst2);
		eventRoleSTValueInRG3[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.eventSst2);
		eventRoleSTValueInRG3[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.eventDst2);

		String eventRoleSTNamesInRG3[]={statusTypeDataCreation.eventNdst2,statusTypeDataCreation.eventSst2,statusTypeDataCreation.eventDst2};

		String[] statusTypeValueInRG3 = ArrayUtils.addAll(sharedSTValueInRG3, roleSTValueInRG3);
		statusTypeValueInRG3= ArrayUtils.addAll(statusTypeValueInRG3, eventRoleSTValueInRG3);

		String[] statusTypeNamesInRG3 = ArrayUtils.addAll(sharedSTNamesInRG3, roleSTNamesInRG3);
		statusTypeNamesInRG3 = ArrayUtils.addAll(statusTypeNamesInRG3, eventRoleSTNamesInRG3);

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name2, statusTypeValueInRG3);
		resourceTypeValueInRG3[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name2);

		navigateTo.resources();
		resources.createSharedResourceWithAddress(resourceDataCreation.sharedRS_Name3, resourceDataCreation.abbrevation5, resourceTypeDataCreation.name2, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,ResourceData.COUNTY );
		resources.createResourceWithAddress(resourceDataCreation.name3, resourceDataCreation.abbrevation6, resourceTypeDataCreation.name2, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE,ResourceData.COUNTY );

		resourceValueInRG3[0]=resources.getResourceValue(resourceDataCreation.sharedRS_Name3);
		resourceValueInRG3[1]=resources.getResourceValue(resourceDataCreation.name3);

		navigateTo.views();
		viewUnderSetup.addResourceAndStatusTypesToRegionDefaultView(RegionData.REGION_WITH_MUTUAL_AGREEMENT3, resourceNamesInRG3, statusTypeNamesInRG3)
		.addResourceAndStatusTypesToRegionDefaultView(RegionData.REGION_WITH_MUTUAL_AGREEMENT1, shared_RS_Names_RG1, sharedSTNames);

		navigateTo.users();
		usersList.createUserBySelectingFirstRole(userDataCreation.name2, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);

		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);

		navigateTo.views();
		viewUnderSetup.addResourceAndStatusTypesToRegionDefaultView(RegionData.REGION_WITH_MUTUAL_AGREEMENT3, shared_RS_Names_RG3, sharedSTNamesInRG3)
		.addResourceAndStatusTypesToRegionDefaultView(RegionData.REGION_WITH_MUTUAL_AGREEMENT2, shared_RS_Names_RG2, sharedSTNamesInRG2);

		//User A provided with primary mail id and pager id's.
		String[] allSharedST = ArrayUtils.addAll(sharedSTNames, sharedStatusesNames);
		String[] allEventSharedST = ArrayUtils.addAll(eventSharedSTNames, eventSharedStatusesNames);
		String[] allEventPrivateST = ArrayUtils.addAll(eventPrivateSTNames, eventPrivateStatusesNames);
		String[] allEventRoleST = ArrayUtils.addAll(eventSTNames, eventRoleStatusesNames);
		String[] allRoleST=ArrayUtils.addAll(roleSTNames, roleStatusesNames);
		String[] allPrivateST=ArrayUtils.addAll(privateSTNames, privateStatusesNames);

		String[] All36STsOfRG1_Name = ArrayUtils.addAll(allSharedST, allEventSharedST);
		All36STsOfRG1_Name = ArrayUtils.addAll(All36STsOfRG1_Name, allEventPrivateST);
		All36STsOfRG1_Name = ArrayUtils.addAll(All36STsOfRG1_Name, allEventRoleST);
		All36STsOfRG1_Name = ArrayUtils.addAll(All36STsOfRG1_Name, allRoleST);
		All36STsOfRG1_Name = ArrayUtils.addAll(All36STsOfRG1_Name, allPrivateST);

		String[] allSharedSTInRG2 = ArrayUtils.addAll(sharedSTNamesInRG2, sharedStatusesNamesInRG2);
		String[] allRoleSTInRG2=ArrayUtils.addAll(roleStatusesNamesInRG2, roleSTNamesInRG2);
		String[] allEventRoleSTInRG2 = ArrayUtils.addAll(eventSTNames);

		String[] All12STsOfRG2_Name = ArrayUtils.addAll(allSharedSTInRG2, allRoleSTInRG2);
		All12STsOfRG2_Name = ArrayUtils.addAll(All12STsOfRG2_Name, allEventRoleSTInRG2);

		String[] allSharedSTInRG3 = ArrayUtils.addAll(sharedSTNamesInRG3,sharedStatusesNamesInRG3);
		String[] allRoleSTInRG3=ArrayUtils.addAll(roleStatusesNamesInRG3, roleSTNamesInRG3);
		String[] allEventRoleSTInRG3 = ArrayUtils.addAll(eventRoleSTNamesInRG3);

		String[] All12STsOfRG3_Name = ArrayUtils.addAll(allSharedSTInRG3, allRoleSTInRG3);
		All12STsOfRG3_Name = ArrayUtils.addAll(All12STsOfRG3_Name, allEventRoleSTInRG3);


		String[] All36STsOfRG1_Nodes = {StatusTypeTags.SHARED_NST_IN_AGREEMENT_REGION1,StatusTypeTags.SHARED_MST_IN_AGREEMENT_REGION1,
				StatusTypeTags.SHARED_TST_IN_AGREEMENT_REGION1, StatusTypeTags.SHARED_NEDOC_IN_AGREEMENT_REGION1, StatusTypeTags.SHARED_SST_IN_AGREEMENT_REGION1, StatusTypeTags.SHARED_DATE_IN_AGREEMENT_REGION1,
				StatusTypeTags.SHARED_STATUSES_NAMES1_IN_AGREEMENT_REGION1,StatusTypeTags.SHARED_STATUSES_NAMES2_IN_AGREEMENT_REGION1,
				StatusTypeTags.SHARED_STATUSES_NAMES3_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_SHARED_NST_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_SHARED_MST_IN_AGREEMENT_REGION1,
				StatusTypeTags.EVENT_SHARED_TST_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_SHARED_NEDOC_IN_AGREEMENT_REGION1,
				StatusTypeTags.EVENT_SHARED_SST_IN_AGREEMENT_REGION1, StatusTypeTags.EVENT_SHARED_DATE_IN_AGREEMENT_REGION1, 
				StatusTypeTags.EVENT_SHARED_STATUSES_NAMES1_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_SHARED_STATUSES_NAMES2_IN_AGREEMENT_REGION1, 
				StatusTypeTags.EVENT_SHARED_STATUSES_NAMES3_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_PRIVATE_NST_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_PRIVATE_MST_IN_AGREEMENT_REGION1, 
				StatusTypeTags.EVENT_PRIVATE_TST_IN_AGREEMENT_REGION1, StatusTypeTags.EVENT_PRIVATE_NEDOC_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_PRIVATE_SST_IN_AGREEMENT_REGION1,
				StatusTypeTags.EVENT_PRIVATE_DATE_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_PRIVATE_STATUSES_NAMES1_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_PRIVATE_STATUSES_NAMES2_IN_AGREEMENT_REGION1,
				StatusTypeTags.EVENT_PRIVATE_STATUSES_NAMES3_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_ROLE_NST_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_ROLE_MST_IN_AGREEMENT_REGION1,
				StatusTypeTags.EVENT_ROLE_TST_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_ROLE_NEDOC_IN_AGREEMENT_REGION1, 
				StatusTypeTags.EVENT_ROLE_SST_IN_AGREEMENT_REGION1, StatusTypeTags.EVENT_ROLE_DATE_IN_AGREEMENT_REGION1, StatusTypeTags.EVENT_ROLE_STATUSES_NAMES1_IN_AGREEMENT_REGION1, 
				StatusTypeTags.EVENT_ROLE_STATUSES_NAMES2_IN_AGREEMENT_REGION1, StatusTypeTags.EVENT_ROLE_STATUSES_NAMES3_IN_AGREEMENT_REGION1,StatusTypeTags.ROLE_NST_IN_AGREEMENT_REGION1, StatusTypeTags.ROLE_MST_IN_AGREEMENT_REGION1, 
				StatusTypeTags.ROLE_TST_IN_AGREEMENT_REGION1, StatusTypeTags.ROLE_NEDOC_IN_AGREEMENT_REGION1, StatusTypeTags.ROLE_SST_IN_AGREEMENT_REGION1, StatusTypeTags.ROLE_DATE_IN_AGREEMENT_REGION1, StatusTypeTags.ROLE_STATUSES_NAMES1_IN_AGREEMENT_REGION1,
				StatusTypeTags.ROLE_STATUSES_NAMES2_IN_AGREEMENT_REGION1,StatusTypeTags.ROLE_STATUSES_NAMES3_IN_AGREEMENT_REGION1, StatusTypeTags.PRIVATE_NST_IN_AGREEMENT_REGION1,  StatusTypeTags.PRIVATE_MST_IN_AGREEMENT_REGION1,  StatusTypeTags.PRIVATE_TST_IN_AGREEMENT_REGION1,  StatusTypeTags.PRIVATE_NEDOC_IN_AGREEMENT_REGION1,
				StatusTypeTags.PRIVATE_SST_IN_AGREEMENT_REGION1,  StatusTypeTags.PRIVATE_DATE_IN_AGREEMENT_REGION1, StatusTypeTags.PRIVATE_STATUSES_NAMES1_IN_AGREEMENT_REGION1, StatusTypeTags.PRIVATE_STATUSES_NAMES2_IN_AGREEMENT_REGION1,  StatusTypeTags.PRIVATE_STATUSES_NAMES3_IN_AGREEMENT_REGION1};


		String[] All12STsOfRG2_Nodes = {StatusTypeTags.SHARED_NST_IN_AGREEMENT_REGION2,StatusTypeTags.SHARED_MST_IN_AGREEMENT_REGION2,StatusTypeTags.SHARED_TST_IN_AGREEMENT_REGION2,StatusTypeTags.SHARED_NEDOC_IN_AGREEMENT_REGION2, 
				StatusTypeTags.SHARED_SST_IN_AGREEMENT_REGION2,StatusTypeTags.SHARED_DATE_IN_AGREEMENT_REGION2, StatusTypeTags.SHARED_STATUSES_NAMES1_IN_AGREEMENT_REGION2,StatusTypeTags.SHARED_STATUSES_NAMES2_IN_AGREEMENT_REGION2, 
				StatusTypeTags.SHARED_STATUSES_NAMES3_IN_AGREEMENT_REGION2, StatusTypeTags.ROLE_STATUSES_NAMES1_IN_AGREEMENT_REGION2,StatusTypeTags.ROLE_STATUSES_NAMES2_IN_AGREEMENT_REGION2,
				StatusTypeTags.ROLE_STATUSES_NAMES3_IN_AGREEMENT_REGION2,StatusTypeTags.ROLE_NST_IN_AGREEMENT_REGION2,StatusTypeTags.ROLE_MST_IN_AGREEMENT_REGION2,
				StatusTypeTags.ROLE_TST_IN_AGREEMENT_REGION2,StatusTypeTags.EVENT_ROLE_NEDOC_IN_AGREEMENT_REGION2,StatusTypeTags.EVENT_ROLE_SST_IN_AGREEMENT_REGION2,StatusTypeTags.EVENT_ROLE_DATE_IN_AGREEMENT_REGION2};					 

		String[] All12STsOfRG3_Nodes = {StatusTypeTags.SHARED_NST_IN_AGREEMENT_REGION3, StatusTypeTags.SHARED_MST_IN_AGREEMENT_REGION3,StatusTypeTags.SHARED_TST_IN_AGREEMENT_REGION3,
				StatusTypeTags.SHARED_NEDOC_IN_AGREEMENT_REGION3,StatusTypeTags.SHARED_SST_IN_AGREEMENT_REGION3, StatusTypeTags.SHARED_DATE_IN_AGREEMENT_REGION3, StatusTypeTags.SHARED_STATUSES_NAMES1_IN_AGREEMENT_REGION3, 
				StatusTypeTags.SHARED_STATUSES_NAMES2_IN_AGREEMENT_REGION3, StatusTypeTags.SHARED_STATUSES_NAMES3_IN_AGREEMENT_REGION3, StatusTypeTags.ROLE_NST_IN_AGREEMENT_REGION3, StatusTypeTags.ROLE_MST_IN_AGREEMENT_REGION3, 
				StatusTypeTags.ROLE_TST_IN_AGREEMENT_REGION3, StatusTypeTags.ROLE_STATUSES_NAMES1_IN_AGREEMENT_REGION3, StatusTypeTags.ROLE_STATUSES_NAMES2_IN_AGREEMENT_REGION3, 
				StatusTypeTags.ROLE_STATUSES_NAMES3_IN_AGREEMENT_REGION3, StatusTypeTags.EVENT_ROLE_NEDOC_IN_AGREEMENT_REGION3, StatusTypeTags.EVENT_ROLE_SST_IN_AGREEMENT_REGION3, StatusTypeTags.EVENT_ROLE_DATE_IN_AGREEMENT_REGION3};

		statusTypeDataCreation.writeStatusTypesDataToXml(All36STsOfRG1_Name, All36STsOfRG1_Nodes);
		statusTypeDataCreation.writeStatusTypesDataToXml(All12STsOfRG2_Name, All12STsOfRG2_Nodes);
		statusTypeDataCreation.writeStatusTypesDataToXml(All12STsOfRG3_Name, All12STsOfRG3_Nodes);

		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeDataCreation.name, ResourceTypeTags.RT_NAME_IN_MUTUAL_AGREEMENT_RG1);
		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeValue[0], ResourceTypeTags.RT_VALUE_IN_MUTUAL_AGREEMENT_RG1);
		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeDataCreation.name1, ResourceTypeTags.RT_NAME_IN_MUTUAL_AGREEMENT_RG2);
		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeValueInRG2[0], ResourceTypeTags.RT_VALUE_IN_MUTUAL_AGREEMENT_RG2);
		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeDataCreation.name2, ResourceTypeTags.RT_NAME_IN_MUTUAL_AGREEMENT_RG3);
		resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeValueInRG3[0], ResourceTypeTags.RT_VALUE_IN_MUTUAL_AGREEMENT_RG3);

		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.sharedRS_Name, ResourceTags.SHARED_RESOURCE_NAME1_IN_MUTUAL_AID_REGION1_MR);
		resourceDataCreation.writeResourceDataToXml(resourceValue[1], ResourceTags.SHARED_RESOURCE_VALUE1_IN_MUTUAL_AID_REGION1_MR);

		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.sharedRS_Name1, ResourceTags.SHARED_RESOURCE_NAME2_IN_MUTUAL_AID_REGION1_MR);
		resourceDataCreation.writeResourceDataToXml(resourceValue[2], ResourceTags.SHARED_RESOURCE_VALUE2_IN_MUTUAL_AID_REGION1_MR);

		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.name, ResourceTags.NON_SHARED_RESOURCE_NAME_IN_MUTUAL_AID_REGION1_MR);
		resourceDataCreation.writeResourceDataToXml(resourceValue[0], ResourceTags.NON_SHARED_RESOURCE_VALUE_IN_MUTUAL_AID_REGION1_MR);

		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.sharedRS_Name2, ResourceTags.SHARED_RESOURCE_NAME1_IN_MUTUAL_AID_REGION2_MR);
		resourceDataCreation.writeResourceDataToXml(resourceValueInRG2[0], ResourceTags.SHARED_RESOURCE_VALUE1_IN_MUTUAL_AID_REGION2_MR);

		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.name2, ResourceTags.NON_SHARED_RESOURCE_NAME_IN_MUTUAL_AID_REGION2_MR);
		resourceDataCreation.writeResourceDataToXml(resourceValueInRG2[1], ResourceTags.NON_SHARED_RESOURCE_VALUE_IN_MUTUAL_AID_REGION2_MR);

		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.sharedRS_Name3, ResourceTags.SHARED_RESOURCE_NAME1_IN_MUTUAL_AID_REGION3_MR);
		resourceDataCreation.writeResourceDataToXml(resourceValueInRG3[0], ResourceTags.SHARED_RESOURCE_VALUE1_IN_MUTUAL_AID_REGION3_MR);

		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.name3, ResourceTags.NON_SHARED_RESOURCE_NAME_IN_MUTUAL_AID_REGION3_MR);
		resourceDataCreation.writeResourceDataToXml(resourceValueInRG3[1], ResourceTags.NON_SHARED_RESOURCE_VALUE_IN_MUTUAL_AID_REGION3_MR);

		viewDataCreation.writeViewDataToXml(viewDataCreation.section, ViewTags.SECTION_IN_MUTUAL_AID_REGION1);
		viewDataCreation.writeViewDataToXml(viewDataCreation.section_1, ViewTags.SECTION_FOR_EVENTS_ST_IN_MUTUAL_AID_REGION1);
		viewDataCreation.writeViewDataToXml(viewDataCreation.section_2, ViewTags.SECTION_IN_MUTUAL_AID_REGION2);
		viewDataCreation.writeViewDataToXml(viewDataCreation.section_3, ViewTags.SECTION_IN_MUTUAL_AID_REGION3);

		userDataCreation.writeUsersDataToXml(userDataCreation.name, UsersTags.USER_IN_MUTUAL_AID_REGION_1);
		userDataCreation.writeUsersDataToXml(userDataCreation.name1, UsersTags.USER_IN_MUTUAL_AID_REGION_2);
		userDataCreation.writeUsersDataToXml(userDataCreation.name2, UsersTags.USER_IN_MUTUAL_AID_REGION_3);

		String[] All36STsValueOfRG1_Nodes = {StatusTypeTags.SHARED_NST_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.SHARED_MST_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.SHARED_TST_VALUE_IN_AGREEMENT_REGION1, 
				StatusTypeTags.SHARED_NEDOC_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.SHARED_SST_VALUE_IN_AGREEMENT_REGION1, 
				StatusTypeTags.SHARED_DATE_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.SHARED_STATUSES_VALUE1_IN_AGREEMENT_REGION1, StatusTypeTags.SHARED_STATUSES_VALUE2_IN_AGREEMENT_REGION1, 
				StatusTypeTags.SHARED_STATUSES_VALUE3_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_SHARED_NST_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.EVENT_SHARED_MST_VALUE_IN_AGREEMENT_REGION1, 
				StatusTypeTags.EVENT_SHARED_TST_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.EVENT_SHARED_NEDOC_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.EVENT_SHARED_SST_VALUE_IN_AGREEMENT_REGION1, 
				StatusTypeTags.EVENT_SHARED_DATE_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.EVENT_SHARED_STATUSES_VALUE1_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_SHARED_STATUSES_VALUE2_IN_AGREEMENT_REGION1, 
				StatusTypeTags.EVENT_SHARED_STATUSES_VALUE3_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_PRIVATE_NST_VALUE_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_PRIVATE_MST_VALUE_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_PRIVATE_TST_VALUE_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_PRIVATE_NEDOC_VALUE_IN_AGREEMENT_REGION1,
				StatusTypeTags.EVENT_PRIVATE_SST_VALUE_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_PRIVATE_DATE_VALUE_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_PRIVATE_STATUSES_VALUE1_IN_AGREEMENT_REGION1,	StatusTypeTags.EVENT_PRIVATE_STATUSES_VALUE2_IN_AGREEMENT_REGION1,
				StatusTypeTags.EVENT_PRIVATE_STATUSES_VALUE3_IN_AGREEMENT_REGION1, StatusTypeTags.EVENT_ROLE_NST_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.EVENT_ROLE_MST_VALUE_IN_AGREEMENT_REGION1,		
				StatusTypeTags.EVENT_ROLE_TST_VALUE_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_ROLE_NEDOC_VALUE_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_ROLE_SST_VALUE_IN_AGREEMENT_REGION1,
				StatusTypeTags.EVENT_ROLE_DATE_VALUE_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_ROLE_STATUSES_VALUE1_IN_AGREEMENT_REGION1, StatusTypeTags.EVENT_ROLE_STATUSES_VALUE2_IN_AGREEMENT_REGION1,StatusTypeTags.EVENT_ROLE_STATUSES_VALUE3_IN_AGREEMENT_REGION1,
				StatusTypeTags.ROLE_NST_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.ROLE_MST_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.ROLE_TST_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.ROLE_NEDOC_VALUE_IN_AGREEMENT_REGION1,	
				StatusTypeTags.ROLE_SST_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.ROLE_DATE_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.ROLE_STATUSES_VALUE1_IN_AGREEMENT_REGION1, 
				StatusTypeTags.ROLE_STATUSES_VALUE2_IN_AGREEMENT_REGION1, StatusTypeTags.ROLE_STATUSES_VALUE3_IN_AGREEMENT_REGION1,StatusTypeTags.PRIVATE_NST_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.PRIVATE_MST_VALUE_IN_AGREEMENT_REGION1, 
				StatusTypeTags.PRIVATE_TST_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.PRIVATE_NEDOC_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.PRIVATE_SST_VALUE_IN_AGREEMENT_REGION1, 
				StatusTypeTags.PRIVATE_DATE_VALUE_IN_AGREEMENT_REGION1, StatusTypeTags.PRIVATE_STATUSES_VALUE1_IN_AGREEMENT_REGION1, StatusTypeTags.PRIVATE_STATUSES_VALUE2_IN_AGREEMENT_REGION1, 
				StatusTypeTags.PRIVATE_STATUSES_VALUE3_IN_AGREEMENT_REGION1};

		String[] All12STsValueOfRG2_Nodes = {StatusTypeTags.SHARED_NST_VALUE_IN_AGREEMENT_REGION2, StatusTypeTags.SHARED_MST_VALUE_IN_AGREEMENT_REGION2, StatusTypeTags.SHARED_TST_VALUE_IN_AGREEMENT_REGION2, StatusTypeTags.SHARED_NEDOC_VALUE_IN_AGREEMENT_REGION2,
				StatusTypeTags.SHARED_SST_VALUE_IN_AGREEMENT_REGION2, StatusTypeTags.SHARED_DATE_VALUE_IN_AGREEMENT_REGION2, StatusTypeTags.SHARED_STATUSES_VALUE1_IN_AGREEMENT_REGION2, StatusTypeTags.SHARED_STATUSES_VALUE2_IN_AGREEMENT_REGION2, StatusTypeTags.SHARED_STATUSES_VALUE3_IN_AGREEMENT_REGION2, 
				StatusTypeTags.ROLE_NST_VALUE_IN_AGREEMENT_REGION2, StatusTypeTags.ROLE_MST_VALUE_IN_AGREEMENT_REGION2, StatusTypeTags.ROLE_TST_VALUE_IN_AGREEMENT_REGION2, StatusTypeTags.ROLE_STATUSES_VALUE1_IN_AGREEMENT_REGION2, 
				StatusTypeTags.ROLE_STATUSES_VALUE2_IN_AGREEMENT_REGION2, StatusTypeTags.ROLE_STATUSES_VALUE3_IN_AGREEMENT_REGION2, StatusTypeTags.EVENT_ROLE_NEDOC_VALUE_IN_AGREEMENT_REGION2,
				StatusTypeTags.EVENT_ROLE_SST_VALUE_IN_AGREEMENT_REGION2, StatusTypeTags.EVENT_ROLE_DATE_VALUE_IN_AGREEMENT_REGION2};

		String[] All12STsValueOfRG3_Nodes = {StatusTypeTags.SHARED_NST_VALUE_IN_AGREEMENT_REGION3, StatusTypeTags.SHARED_MST_VALUE_IN_AGREEMENT_REGION3, StatusTypeTags.SHARED_TST_VALUE_IN_AGREEMENT_REGION3, StatusTypeTags.SHARED_NEDOC_VALUE_IN_AGREEMENT_REGION3, StatusTypeTags.SHARED_SST_VALUE_IN_AGREEMENT_REGION3, StatusTypeTags.SHARED_DATE_VALUE_IN_AGREEMENT_REGION3, 
				StatusTypeTags.SHARED_STATUSES_VALUE1_IN_AGREEMENT_REGION3, StatusTypeTags.SHARED_STATUSES_VALUE2_IN_AGREEMENT_REGION3, StatusTypeTags.SHARED_STATUSES_VALUE3_IN_AGREEMENT_REGION3, StatusTypeTags.ROLE_NST_VALUE_IN_AGREEMENT_REGION3, StatusTypeTags.ROLE_MST_VALUE_IN_AGREEMENT_REGION3, 
				StatusTypeTags.ROLE_TST_VALUE_IN_AGREEMENT_REGION3, StatusTypeTags.ROLE_STATUSES_VALUE1_IN_AGREEMENT_REGION3, StatusTypeTags.ROLE_STATUSES_VALUE2_IN_AGREEMENT_REGION3, StatusTypeTags.ROLE_STATUSES_VALUE3_IN_AGREEMENT_REGION3, 
				StatusTypeTags.EVENT_ROLE_NEDOC_VALUE_IN_AGREEMENT_REGION3,StatusTypeTags.EVENT_ROLE_SST_VALUE_IN_AGREEMENT_REGION3, StatusTypeTags.EVENT_ROLE_DATE_VALUE_IN_AGREEMENT_REGION3};

		String[] allSharedSTValue = ArrayUtils.addAll(sharedSTValue, sharedStatusValues);
		String[] allEventSharedSTValue = ArrayUtils.addAll(eventSharedSTValue, eventSharedStatusValues);
		String[] allEventPrivateSTValue = ArrayUtils.addAll(eventPrivateSTValue, eventPrivateStatusValues);
		String[] allEventRoleSTValue = ArrayUtils.addAll(eventRoleSTValue, eventRoleStatusValues);
		String[] allRoleSTValue = ArrayUtils.addAll(roleSTValue, roleStatusValues);
		String[] allPrivateSTValue = ArrayUtils.addAll(privateSTValue, privateStatusValues);

		String[] All36STsOfRG1_Value = ArrayUtils.addAll(allSharedSTValue, allEventSharedSTValue);
		All36STsOfRG1_Value = ArrayUtils.addAll(All36STsOfRG1_Value, allEventPrivateSTValue);
		All36STsOfRG1_Value = ArrayUtils.addAll(All36STsOfRG1_Value, allEventRoleSTValue);
		All36STsOfRG1_Value = ArrayUtils.addAll(All36STsOfRG1_Value, allRoleSTValue);
		All36STsOfRG1_Value = ArrayUtils.addAll(All36STsOfRG1_Value, allPrivateSTValue);

		String[] allSharedSTValueInRG2 = ArrayUtils.addAll(sharedSTValueInRG2, sharedStatusValuesInRG2);
		String[] allRoleSTValueInRG2=ArrayUtils.addAll(roleSTValueInRG2, roleStatusValuesInRG2);
		String[] allEventRoleSTValueInRG2 = ArrayUtils.addAll( eventRoleSTValueInRG2);

		String[] All12STsOfRG2_Value = ArrayUtils.addAll(allSharedSTValueInRG2, allRoleSTValueInRG2);
		All12STsOfRG2_Value = ArrayUtils.addAll(All12STsOfRG2_Value, allEventRoleSTValueInRG2);

		String[] allSharedSTValueInRG3 = ArrayUtils.addAll(sharedSTValueInRG3,sharedStatusValuesInRG3);
		String[] allRoleSTValueInRG3=ArrayUtils.addAll(roleSTValueInRG3, roleStatusValuesInRG3);
		String[] allEventRoleSTValueInRG3 = ArrayUtils.addAll(eventRoleSTValueInRG3);

		String[] All12STsOfRG3_Value = ArrayUtils.addAll(allSharedSTValueInRG3, allRoleSTValueInRG3);
		All12STsOfRG3_Value = ArrayUtils.addAll(All12STsOfRG3_Value, allEventRoleSTValueInRG3);

		statusTypeDataCreation.writeStatusTypesDataToXml(All36STsOfRG1_Value, All36STsValueOfRG1_Nodes);
		statusTypeDataCreation.writeStatusTypesDataToXml(All12STsOfRG2_Value, All12STsValueOfRG2_Nodes);
		statusTypeDataCreation.writeStatusTypesDataToXml(All12STsOfRG3_Value, All12STsValueOfRG3_Nodes);
		eventSetupDataCreation.writeEventDataToXml(eventSetupDataCreation.name, EventSetUpTags.EVENT_TEMPLATE_IN_MUTUAL_AGREEMENT_REGION_1);

		login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
		.logOut()
		.loginAsNewUser(userDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
		.logOut()
		.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
		.logOut();
		Result = "PASS";
	}
}
