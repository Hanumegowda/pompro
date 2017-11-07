package RequirementGroups.MultiRegion;

import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration;
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
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.ConfigureNewRelationship;
import EMR.pages.EventManagement;
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

public class CreateCustomView extends Configuration{
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
	Shared shared;
	EventManagement eventManagement;
	OtherRegionList OtherRegionList;

	public CreateCustomView() throws Exception{
		// TODO Auto-generated constructor stub
	}

	@Test(groups = {"HappyDay","Multi Region", "HappyDay69795"})
	public void HappyDay69795() throws Exception {

		TCID ="69795";
		TC_DESCRIPTION ="Verify that a user without 'View Custom View' right, does not have the option to add resource to custom view after searching for resources ";
		/***LoginAsUserWithoutCustomViewRight
		 * NavigateTosearchInToolBarOnHomePage
		 * SerchForResource
		 * VerifyAddToCustomViewOptionIsNotAvailble
		 * MouseHoverOnViewTab
		 * VerifyCustomViewOptionIsNotAvailble
		 * MouseHoverOnPreferencesTab
		 * VerifyCustomViewOptionIsNotAvailble
		 */
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		rolesList = new RolesList(this.driver);
		viewsList = new View(this.driver);

		usersData = new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		rolesData = new RolesData();
		rolesDataCreation = rolesData.new RolesCreateData();
		resourceData = new ResourceData();

		String roleValue = "";
		String resourceName = resourceData.preferenceResourceName;
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);

		navigateTo.roles();
		rolesList.createRole(rolesDataCreation.name);
		roleValue = rolesList.getRoleValue(rolesDataCreation.name);

		navigateTo.users();
		usersList.createUserWithMandatoryDetailsAndSave(userDataCreation.name, UsersData.INITIAL_PASSWORD,
				userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, roleValue);

		login.logOut()
		.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		viewsList.searchForResource(resourceName)
				 .verifyAddToCustomViewIsNotPresent();

		login.logOut();	

		Result = "PASS";	
	}
	
	@Test(groups = {"HappyDay","Multi Region", "HappyDay69804"})
	public void HappyDay69804() throws Exception {

		//Verification part of "Manage Users Option Not Available" after activating mutual aid relation in one region is covered in test case HappyDay172442.	

		TCID ="69804";
		TC_DESCRIPTION ="Verify that a user created by selecting a role with 'View custom view' right has "
				+ "the option to add resources to custom view after searching for resources. ";
		/***LoginAsUserWithCustomViewRight
		 * NavigateToCustomizedUnderPreferencesTab
		 * SerchForResourceRS1
		 * CreateCustomViewWithResorceRS1
		 * VerifyCustomIsCreated
		 * NavigateTosearchInToolBarOnHomePage
		 * SerchForResourceRS2
		 * VerifyresourceRsIsaddedToCustomView
		 * 

		 */
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		rolesList = new RolesList(this.driver);
		viewsList = new View(this.driver);

		usersData = new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		rolesData = new RolesData();
		rolesDataCreation = rolesData.new RolesCreateData();
		resourceData = new ResourceData();
		statusTypeData = new StatusTypeData();
		resourceTypeData = new ResourceTypeData();

		String roleValue = "";
		String resourceType = resourceTypeData.RT_NAME_MutualAgreementRegion1,
				resourceName_1 = resourceData.resourceNAME_MutualAgreement_RG1,
				resourceName_2 = resourceData.sharedResourceNAME1_MutualAgreement_RG1;
		String[] statusTypesValues = {statusTypeData.sharedNSTValue_InMutualAgreemnet_RG1, 
				statusTypeData.sharedMSTValue_InMutualAgreemnet_RG1, 
				statusTypeData.roleTSTValue_InMutualAgreemnet_RG1},
				statusTypeNames = {statusTypeData.sharedNSTName_InMutualAgreemnet_RG1,
				statusTypeData.sharedMSTName_InMutualAgreemnet_RG1,
				statusTypeData.roleTSTName_InMutualAgreemnet_RG1},
				resourceValue_1= {resourceData.resourceVALUE_MutualAgreement_RG1},
				resourcValue_2 = {resourceData.sharedResourceVALUE1_MutualAgreement_RG1};

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGION_WITH_MUTUAL_AGREEMENT1);

		navigateTo.roles();
		rolesList.createRoleWithViewCustomViewOption(rolesDataCreation.name);
		roleValue = rolesList.getRoleValue(rolesDataCreation.name);

		navigateTo.users();
		usersList.createUserWithMandatoryDetailsAndSave(userDataCreation.name1, UsersData.INITIAL_PASSWORD,
				userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, roleValue);

		login.logOut()
		.loginAsNewUser(userDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		viewsList.createCustomizedViewFromPreferences(resourceName_1, resourceValue_1, statusTypesValues)
				.verifyResourceTypeResourceAndStatusTypeInCustomizedView(resourceType, resourceName_1, statusTypeNames)
				.searchResourceAndAddToCustomView(resourceName_2, resourcValue_2, statusTypesValues)
				.verifyResourceTypeResourceAndStatusTypeInCustomizedView(resourceType, resourceName_2, statusTypeNames);
		login.logOut();

		Result = "PASS";	
	}

	@Test(groups = {"HappyDay","Multi Region", "HappyDay69812"})
	public void HappyDay69812() throws Exception {

		TCID ="69812";
		TC_DESCRIPTION ="Verify that only RegAdmin has the option to share resources.";

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
		otherRegionData=new OtherRegionData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		shared=new Shared(this.driver);
		viewsList =new View(this.driver);
		otherRegionList = new OtherRegionList(this.driver);

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);
		navigateTo.resources();	
		resources.createResource(resourceDataCreation.name, resourceDataCreation.abbrevation, 
				resourceTypeData.RT_NAME_MutualAgreementRegion1, ResourceData.STANDARDRESOURCETYPE, 
				ResourceData.FIRSTNAME, ResourceData.LASTNAME);
		resources.createResource(resourceDataCreation.name1, resourceDataCreation.abbrevation, 
				resourceTypeData.RT_NAME_MutualAgreementRegion1, 
				ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME);
		String[] resourcevalues={resources.getResourceValue(resourceDataCreation.name),resources.getResourceValue(resourceDataCreation.name1)};
		navigateTo.otherRegion();
		otherRegionList.VerifySystemAdminCanShareResourcesOnOtherRegionList(resourcevalues);
		login.logOut()
		.loginAsUser(usersData.UserInMutualAidRegion1_WithAdditionalRights,UsersData.PASSWORD);
		navigateTo.otherRegion();
		otherRegionList.VerifyUserCannotShareResourcesOnOtherRegionList(resourcevalues);
		Result = "PASS";
	}

	@Test(groups = {"HappyDay","Multi Region", "HappyDay84682"})
	public void HappyDay84682() throws Exception {

		//Verification part of "Manage Users Option Not Available" after activating mutual aid relation in one region is covered in test case HappyDay172442.	

		TCID ="84682";
		TC_DESCRIPTION ="Verify that only RegAdmin has the option to share status types.";

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
		eventData =new EventData();
		eventCreateData=eventData.new EventCreateData();
		eventSetUpData=new EventSetUpData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		eventManagement =new EventManagement(this.driver);
		viewsList =new View(this.driver);
		otherRegionList =new OtherRegionList(this.driver); 

		/***
		 *login as SystemAdmin for region.
		 *navigate to Status Type
		 *create shared Status Type
		 *create role Status Type
		 *create private Status Type
		 *navigate to Other region
		 *verify Shared Status Type button is displayed
		 *click on Shared Status Type
		 *verify Shared Status Type is selected and enabled
		 *verify Role based Status Type is deSelected and enabled
		 *verify private Status Type is not listed
		 *select Shared Status Type and Save
		 *click on Shared Status Type
		 *verify Shared Status Type is selected and enabled
		 *verify Role based Status Type is selected and enabled
		 *verify private Status Type is not listed
		 *logout
		 *login as user with Setup-Other Region Views right
		 *navigate to Other region
		 *click on Shared Status Type
		 *verify Shared Status Type is selected and disabled
		 *verify Role based Status Type is selected and disabled
		 *verify private Status Type is not listed
		 *logout
		 */

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
		.provideSetupOtherRegionViewsRightAndSave();
		navigateTo.viewUnderSetup();
		viewUnderSetup.createNewSection(viewDataCreation.section);
		navigateTo.statusTypes();
		statusTypes.createSharedStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.sharedNST, statusTypeDataCreation.description, viewDataCreation.section);
		String shareStatusValues = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedNST);

		statusTypes.createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.sharedTST, statusTypeDataCreation.description, viewDataCreation.section);
		String roleStatusValues = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedTST);
		statusTypes.createPrivateStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sharedSST, statusTypeDataCreation.description, viewDataCreation.section);
		String privateStatusValues = statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedSST);
		String[] allStatusTypes = {shareStatusValues ,roleStatusValues, privateStatusValues };
		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, allStatusTypes);
		navigateTo.otherRegion();
		otherRegionList.verifyStatusTypesCanSelected(shareStatusValues, roleStatusValues, privateStatusValues)
						.verifyRoleBasedStatusTypeIsSelectedAndEnabledAndSave(roleStatusValues);
		login.logOut()
				.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.otherRegion();
		otherRegionList.verifyStatusTypesAreDisabled(shareStatusValues, roleStatusValues, privateStatusValues);
		login.logOut();

		Result = "PASS";	
	}
}
