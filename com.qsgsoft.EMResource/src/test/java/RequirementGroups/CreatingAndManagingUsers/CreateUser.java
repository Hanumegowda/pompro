package RequirementGroups.CreatingAndManagingUsers;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import EMR.data.EventSetUpData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.StatusReasonData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.RolesData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusTypeData;
import EMR.data.StatusReasonData.StatusReasonCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.Map;
import EMR.pages.RegionDefault;
import EMR.pages.RegionList;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.RolesList;
import EMR.pages.Shared;
import EMR.pages.StatusReasonList;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewResourceDetail;
import EMR.pages.ViewsUnderSetup;

public class CreateUser extends Configuration {

	public CreateUser() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginData loginData;
	UsersData usersData;
	UsersCreateData usersDataCreation;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	ResourceData resourceData;
	ResourceCreateData resourceDataCreation;
	ViewData viewData;
	ViewCreateData viewDataCreation;
	RolesData rolesData;
	RolesCreateData rolesDataCreation;
	EventSetUpData eventSetUpData;
	EventSetUpCreateData eventSetUpDataCreation;
	StatusReasonData StatusReasonData;
	StatusReasonCreateData creatStatusReasonData;

	Login login;
	Shared navigateTo;
	UsersList usersList;
	RegionList regions;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resource;
	ViewsUnderSetup setupView;
	View viewsList;
	Map map;
	RolesList roles;
	StatusReasonList statusReasonList;
	RegionDefault regionDefault;
	EventSetUp eventSetUp;
	EventManagement eventManagement;
	ViewResourceDetail resourceDetail;

	String RT_Name, RT_Value, NST_Name, MST_Name, ResourceName_1,
	ResourceName_2, ResourceValue_1, ResourceValue_2, View_1, Role_Value;

	ArrayList<String> statusType_Values = new ArrayList<String>();
	ArrayList<String> statusType_Names = new ArrayList<String>();
	ArrayList<String> statuses_Names = new ArrayList<String>();

	@Test(groups = {"HappyDay", "Creating And Managing Users", "HappyDay66134", "EMResource Base"}, priority = 1)
	public void HappyDay66134() throws Exception {

		TCID = "66134";
		TC_DESCRIPTION = "Verify that a user can be provided the right to setup status types.";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		statusTypes = new StatusTypes(this.driver);
		usersList = new UsersList(this.driver);
		setupView = new ViewsUnderSetup(this.driver);

		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();

		String username		= usersDataCreation.name,
			userFullName = usersDataCreation.fullName,
			sectionName	= viewDataCreation.section,
			edited_MST_name	= statusTypeDataCreation.editMST_Name;

		statuses_Names.addAll(Arrays.asList(statusTypeDataCreation.statusesName, statusTypeDataCreation.statusesName1, statusTypeDataCreation.statusesName2, statusTypeDataCreation.statusesName3));
		statusType_Names.addAll(Arrays.asList(statusTypeDataCreation.mstName, statusTypeDataCreation.nstName));
		ArrayList<String> statuses_reordered = new ArrayList<String>();
		statuses_reordered.addAll(Arrays.asList(statusTypeDataCreation.statusesName1, statusTypeDataCreation.statusesName2, statusTypeDataCreation.statusesName, statusTypeDataCreation.statusesName3));

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);

		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description, ViewData.NO_SECTION_ASSIGNED)
		.createNewStatus(statusTypeDataCreation.statusesName, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR)
		.createNewStatus(statusTypeDataCreation.statusesName2, StatusTypeData.STATUS_PURPLE_COLOR)
		.clickOnReturnToStatusTypeList();

		navigateTo.viewUnderSetup();
		setupView.createNewSection(sectionName);

		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
		.provideSetUpStatusTypesRightAndSave();

		login.logOut()
		.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusType_Names.get(1), statusTypeDataCreation.description, ViewData.NO_SECTION_ASSIGNED)
		.verifyStatusTypeInList(statusType_Names.get(1))
		.editMandatoryDataOfStatusType(statusType_Names.get(0), statusTypeDataCreation.editMST_Name, statusTypeDataCreation.edit_description, sectionName)
		.verifyStatusTypeDetailsInList(edited_MST_name, statusTypeDataCreation.edit_description, sectionName)
		.reorderStatuses_MultiStatusType(edited_MST_name, statusTypeDataCreation.statusesName, statusTypeDataCreation.statusesName1, statusTypeDataCreation.statusesName2)
		.createNewStatus(statusTypeDataCreation.statusesName3, StatusTypeData.STATUS_PURPLE_COLOR)
		.clickOnReturnToStatusTypeList()
		.verifyStatuses_MST(edited_MST_name, statuses_Names)
		.verifyStatusesOrder(edited_MST_name, statuses_reordered);
		login.logOut();
		NST_Name = statusTypeDataCreation.nstName;
		MST_Name = statusTypeDataCreation.editMST_Name;
		Result = "PASS";
	}

	@Test(groups = {"HappyDay", "Creating And Managing Users", "HappyDay66152", "EMResource Base"}, priority = 2)
	public void HappyDay66152() throws Exception {

		TCID = "66152";
		TC_DESCRIPTION = "Verify that a user can be provided the right to setup resource types.";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		statusTypes = new StatusTypes(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		
		String username	= usersDataCreation.name,
			userFullName = usersDataCreation.fullName,
			RT_Name = resourceTypeDataCreation.name,
			editRT_Name	= resourceTypeDataCreation.edited_name;

		statusType_Names.clear();
		statusType_Names.addAll(Arrays.asList(statusTypeDataCreation.nstName, statusTypeDataCreation.tstName));
		ArrayList<String> statusTypeValueToDeselect = new ArrayList<String>();
		ArrayList<String> statusTypeValueToSelect = new ArrayList<String>();

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);

		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				.provideSetupResourceTypesRightAndSave()
				.verifyUserInUsersList(username);

		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusType_Names.get(0), statusTypeDataCreation.description, ViewData.NO_SECTION_ASSIGNED)
		.createStatusType(StatusTypeData.TEXTTYPE, statusType_Names.get(1), statusTypeDataCreation.description, ViewData.NO_SECTION_ASSIGNED);
		statusType_Values.add(statusTypes.getStatusTypeValue(statusType_Names.get(0)));
		statusType_Values.add(statusTypes.getStatusTypeValue(statusType_Names.get(1)));
		statusTypeValueToDeselect.add(statusType_Values.get(0));
		statusTypeValueToSelect.add(statusType_Values.get(1));
		login.logOut()
		.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.resourceType();
		resourceTypes.createResourceType(RT_Name, statusType_Values)
		.editResorceTypeMandatoryDataDeselectAndSelectStatusTypesAndSave(RT_Name, editRT_Name, statusTypeValueToDeselect, statusTypeValueToSelect)
		.VerifyResourceTypeInList(editRT_Name)
		.clickOnEdit(editRT_Name)
		.verifyResourceTypeDetailsAreRetained(editRT_Name, statusTypeValueToSelect)
		.verifyStatusTypes_NotSelectedForResourceType(statusTypeValueToDeselect)
		.cancelAndReturnToResourceTypeList();
		
		this.RT_Name = editRT_Name;
		login.logOut();

		Result = "PASS";
	}

	@Test(groups = {"HappyDay", "Creating And Managing Users", "HappyDay66155", "EMResource Base"}, priority = 3)
	public void HappyDay66155() throws Exception {

		TCID = "66155";
		TC_DESCRIPTION = "Verify that a user can be provided the right to setup resource.";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		roles = new RolesList(this.driver);
		resource = new Resources(this.driver);
		setupView = new ViewsUnderSetup(this.driver);
		viewsList = new View(this.driver);
		resourceDetail = new ViewResourceDetail(this.driver);
		map = new Map(this.driver);
		
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		resourceData = new ResourceData();
		resourceDataCreation = resourceData.new ResourceCreateData();
		rolesData = new RolesData();
		rolesDataCreation = rolesData.new RolesCreateData();
		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		
		String username	= usersDataCreation.name,
			userFullName	= usersDataCreation.fullName,
			viewName	= viewDataCreation.name,
			clinic		= ResourceData.STANDARD_RT_CLINIC;
		String editResourceName_2 = resourceDataCreation.editName;
		
		ResourceName_1	= resourceDataCreation.name;
		ResourceName_2	= resourceDataCreation.name1;
		ArrayList<String> resourceNames = new ArrayList<String>();
		resourceNames.addAll(Arrays.asList(ResourceName_1, ResourceName_2));

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);

		navigateTo.resourceType();
		resourceTypes.editResourceTypeAndSelectStatusTypes(RT_Name, statusType_Values)
		.VerifyResourceTypeInList(RT_Name);

		navigateTo.roles();
		roles.createRole(rolesDataCreation.name);
		Role_Value = roles.getRoleValue(rolesDataCreation.name);

		navigateTo.resources();
		resource.createResourceWithAddress(ResourceName_1, resourceDataCreation.abbrevation, RT_Name, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		ResourceValue_1 = resource.getResourceValue(ResourceName_1);
		resource.createResourceWithAddress(ResourceName_2, resourceDataCreation.abbrevation1, RT_Name, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		ResourceValue_2 = resource.getResourceValue(ResourceName_2);

		navigateTo.users();
		usersList.createUserWithMandatoryDetailsAndUpdateRightOnResource(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, Role_Value, ResourceName_1)
		.selectViewResourceCheckBox(ResourceName_2)
		.provideSetupResourcesAddAndEditRightAndSave();

		navigateTo.viewUnderSetup();
		setupView.createView(viewName, viewDataCreation.description, resourceNames, statusType_Names);
		View_1 = viewName;
		
		login.logOut()
		.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.resources();
		resource.createResourceByUser(resourceDataCreation.name2, resourceDataCreation.abbrevation2, RT_Name, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY)
		.verifyResourceIsPresentUnderResourceListPage(resourceDataCreation.name2);
		resource.editResourceMandatoryDetails(ResourceName_2, editResourceName_2, resourceDataCreation.abbrevation3, clinic);
		resource.verifyResourceIsPresentUnderResourceListPage(editResourceName_2);
		ResourceName_2 = editResourceName_2;
		
		navigateTo.particularView(viewDataCreation.name);
		viewsList.verifyResourceTypeResourceAndStatusType(RT_Name, editResourceName_2, statusType_Names)
		.navigateToResourceDetail(editResourceName_2);
		
		resourceDetail.verifyResourceTypeInDetailViewPage(RT_Name)
				.editResourceFromViewResourceDetailScreen(editResourceName_2, resourceDataCreation.editName1)
				.verifyResourceTypeInDetailViewPage(RT_Name);

		navigateTo.map();
		map.selectResourceNameInFindResourceDropdown(resourceDataCreation.editName1)
		.verifyStatusTypesInPopupWindow(statusType_Names)
		.navigateToEditResourceFromMap();

		resource.updateResourceNameAndAbbreviation(resourceDataCreation.editName2, resourceDataCreation.abbrevation4);
		map.selectResourceNameInFindResourceDropdown(resourceDataCreation.editName2);
		
		navigateTo.resources();
		resource.editResourceMandatoryDetails(ResourceName_1, resourceDataCreation.name3, resourceDataCreation.abbrevation4, clinic);
		resource.verifyResourceIsPresentUnderResourceListPage(resourceDataCreation.name3);
		
		navigateTo.particularView(viewDataCreation.name);
		viewsList.verifyResourceTypeResourceAndStatusType(RT_Name, resourceDataCreation.name3, statusType_Names)
		.navigateToResourceDetail(resourceDataCreation.name3);
		
		resourceDetail.verifyResourceTypeInDetailViewPage(RT_Name)
				.editResourceFromViewResourceDetailScreen(resourceDataCreation.name3, resourceDataCreation.editName3)
				.verifyResourceTypeInDetailViewPage(RT_Name);

		navigateTo.map();
		map.selectResourceNameInFindResourceDropdown(resourceDataCreation.editName3)
		.verifyStatusTypesInPopupWindow(statusType_Names)
		.navigateToEditResourceFromMap();

		resource.updateResourceNameAndAbbreviation(resourceDataCreation.editName4, resourceDataCreation.abbrevation4);
		map.selectResourceNameInFindResourceDropdown(resourceDataCreation.editName4);
		
		login.logOut();

		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay", "Creating And Managing Users", "HappyDay66165", "EMResource Base"}, priority = 4)
	public void HappyDay66165() throws Exception {

		TCID = "66165";
		TC_DESCRIPTION = "Verify that a user can be provided the right 'Edit resources only'.";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resource = new Resources(this.driver);
		usersList = new UsersList(this.driver);
		viewsList = new View(this.driver);
		map = new Map(this.driver);

		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		resourceData = new ResourceData();
		resourceDataCreation = resourceData.new ResourceCreateData();

		String username		= usersDataCreation.name,
				userFullName = usersDataCreation.fullName,
				abb_1		= resourceDataCreation.abbrevation,
				abb_2		= resourceDataCreation.abbrevation1,
				edit_abb	= resourceDataCreation.abbrevation4,
				edit_abb1	=resourceDataCreation.abbrevation5,
				editResourceName_1	= resourceDataCreation.editName,
				clinic				= ResourceData.STANDARD_RT_CLINIC,
				editResourceName_2	= resourceDataCreation.editName1,
				editResourceName_3	= resourceDataCreation.editName2;

		ResourceName_1	= resourceDataCreation.name;
		ResourceName_2	= resourceDataCreation.name1;

		ArrayList<String> resourceNames = new ArrayList<String>();
		resourceNames.addAll(Arrays.asList(ResourceName_1, ResourceName_2));

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);

		navigateTo.resourceType();
		resourceTypes.editResourceTypeAndSelectStatusTypes(RT_Name, statusType_Values)
		.VerifyResourceTypeInList(RT_Name);

		navigateTo.roles();
		roles.createRole(rolesDataCreation.name);
		Role_Value = roles.getRoleValue(rolesDataCreation.name);

		navigateTo.resources();
		resource.createResourceWithAddress(ResourceName_1, abb_1, RT_Name, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		ResourceValue_1 = resource.getResourceValue(ResourceName_1);
		resource.createResourceWithAddress(ResourceName_2, abb_2, RT_Name, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		ResourceValue_2 = resource.getResourceValue(ResourceName_2);

		navigateTo.users();
		usersList.createUserWithMandatoryDetailsAndUpdateRightOnResource(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, Role_Value, ResourceName_1)
		.selectViewResourceCheckBox(ResourceName_2)
		.provideSetupResourcesEditOnlyRightAndSave();

		login.logOut()
		.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.resources();

		resource.verifyCreateNewResourceOptionNotAvailable()
		.editResourceMandatoryDetails(ResourceName_1, editResourceName_1, edit_abb, clinic)
		.verifyAbbreviation_InList(editResourceName_1, edit_abb);

		navigateTo.particularView(View_1);
		viewsList.verifyResourceTypeResourceAndStatusType(RT_Name, editResourceName_1, statusType_Names)
		.navigateToResourceDetail(editResourceName_1);

		resourceDetail.verifyResourceTypeInDetailViewPage(RT_Name)
		.editResourceFromViewResourceDetailScreen(editResourceName_1, editResourceName_2)
		.verifyResourceTypeInDetailViewPage(RT_Name);

		navigateTo.map();
		map.selectResourceNameInFindResourceDropdown(editResourceName_2)
		.verifyStatusTypesInPopupWindow(statusType_Names)
		.navigateToEditResourceFromMap();

		resource.updateResourceNameAndAbbreviation(editResourceName_3, edit_abb1);
		map.selectResourceNameInFindResourceDropdown(editResourceName_3)
		.verResourceInPopupWindow(editResourceName_3)
		.verifyStatusTypesInPopupWindow(statusType_Names)
		.selectResourceNameInFindResourceDropdown(ResourceName_2)
		.verifyEditOptionIsNotPresent()
		.clickViewInfoInPopupWindow();

		resourceDetail.verifyEditResourceDetailsLinkNotPresent(ResourceName_2);

		login.logOut();
		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay", "Creating And Managing Users", "HappyDay88053", "EMResource Base"}, priority = 5)
	public void HappyDay88053() throws Exception {

		TCID = "88053";
		TC_DESCRIPTION = "Verify that user can be created by providing only mandatory data.";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		regionDefault = new RegionDefault(this.driver);
		
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		
		String username		= usersDataCreation.name,
				userFullName = usersDataCreation.fullName;

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);

		navigateTo.users();
		usersList.createUserWithMandatoryDetailsAndEMailPager(username, UsersData.INITIAL_PASSWORD, userFullName, "", "");

		login.logOut()
		.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		regionDefault.verifyRegionDefaultPage()
		.verifyUsernameAtFooter(username, userFullName);

		login.logOut()
		.verifyUsernameField()
		.enterUserName(username)
		.enterPassword(UsersData.PASSWORD)
		.clickOnLogin()
		.clickOnCancelOfSecurityQuestionPage();
		
		navigateTo.selectFrame();
		regionDefault.verifyRegionDefaultPage()
		.verifyUsernameAtFooter(username, userFullName);

		login.logOut();

		Result = "PASS";
	}

	@Test(groups = {"HappyDay", "Creating And Managing Users", "HappyDay66661", "EMResource Base"}, priority = 6)
	public void HappyDay66661() throws Exception {

		TCID = "66661";
		TC_DESCRIPTION = "Verify that a user can be provided the right to setup status reasons.";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		statusReasonList = new StatusReasonList(this.driver);
		
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		StatusReasonData = new StatusReasonData();
		creatStatusReasonData = StatusReasonData.new StatusReasonCreateData();
		
		String username		= usersDataCreation.name,
			userFullName = usersDataCreation.fullName,
			statusResonName	= creatStatusReasonData.name,
			statusReasonDefinition	= creatStatusReasonData.definition,
			abbreviation	= creatStatusReasonData.abbreviation,
			edit_definition	= creatStatusReasonData.editDefinition,
			edit_abb	= creatStatusReasonData.abbreviation1;

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);

		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
								.provideSetupStatusReasonsRightAndSave();

		login.logOut()
		.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.statusReasons();
		statusReasonList.createStatusReason(statusResonName, statusReasonDefinition, abbreviation)
		.verifyStatusReasonDetailsInList(statusResonName, statusReasonDefinition, abbreviation)
		.editDefinitionAndAbbreviation(statusResonName, edit_definition, edit_abb)
		.verifyStatusReasonDetailsInList(statusResonName, edit_definition, edit_abb);

		login.logOut();

	}

//	@Test(groups = {"HappyDay", "Creating And Managing Users", "HappyDay66669", "EMResource Base"}, priority = 7)
//	public void HappyDay66669() throws Exception {
//
////		17 new functions
//		
//		TCID = "66669";
//		TC_DESCRIPTION = "Verify that a user can be provided the right to setup User accounts.";
//
//		String username		= usersDataCreation.name,
//				userFullName = usersDataCreation.fullName,
//				username_1		= usersDataCreation.name1,
//				userFullName_1 = usersDataCreation.fullName1,
//				username_2		= usersDataCreation.name2,
//				userFullName_2 = usersDataCreation.fullName2,
//				username_3		= usersDataCreation.name3,
//				userFullName_3 = usersDataCreation.fullName3,
//				username_4		= usersDataCreation.name4,
//				userFullName_4 = usersDataCreation.fullName4;
//
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//
//		navigateTo.users();
//		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
//		.provideConfigureRegionalUserAccessRight();
//
//		usersList.createUserWithMandatoryDetailsAndEMailPager(username_1, UsersData.INITIAL_PASSWORD, userFullName_1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
//		.createUserWithMandatoryDetailsAndEMailPager(username_2, UsersData.INITIAL_PASSWORD, userFullName_2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
//		.createUserWithMandatoryDetailsAndEMailPager(username_3, UsersData.INITIAL_PASSWORD, userFullName_3, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
////		.deactivateUser(username_3);	-- NEW
////						searchUser(username_3)
////						clickOnDeactivateUser()	--NEW
////						clickOnSave()
////						verifyWarningPage_DeactivateUser(username_3, userFullName_3)	--NEW
////						acceptToDeactivateUser()	--NEW
////						returnToUsersList()	--NEW
//
//		login.logOut()
//		.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
//		
//		navigateTo.users();
//		usersList.createUserWithMandatoryDetailsAndEMailPager(username_4, UsersData.INITIAL_PASSWORD, userFullName_1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
//		.verifyUserInUsersList(username_4);
////		verifyUserIsPresentInList(username_1)	--NEW
////				clickOnShowAllUsers_IfPresent()	--NEW (it should be without searching the user)
////		.verifyUserIsPresentInList(username_2)
////		.verifyInactiverUserInList(username_1)	--NEW
////				includeInactiverUsers()	--NEW
////				verifyUserIsPresentInList(username_1)
////		.deactivateUser(username_2)
////		.reactivateUser(username_3)	-- NEW
////				searchUser(username_3)
////				clickOnActivateUser()	--NEW
////				clickOnSave()
////				verifyWarningPage_ReactivateUser(username_3, userFullName_3)	--NEW
////				acceptToActivateUser()	--NEW
////				returnToUsersList()	--NEW
////		.searchUserName(username_1)
////		.updatePasswordOfUser(username_1, new_password)	-- NEW
////				clickOnPasswordOfUser(username_1)	-- NEW
////				switchToPasswordFrame()	-- NEW
////				provideNewPassword(UsersData.PASSWORD)	-- NEW (enter new pwd, re-enter new pwd)
////				clickOnSave()
////				switchToFrame()
////				clickOnClose()	-- NEW
//
//		login.logOut()
//		.loginAsNewUser(username_1, UsersData.PASSWORD, UsersData.RESET_PASSWORD_1);
//		
//		regionDefault.verifyRegionDefaultPage();
//		
//		login.logOut();
//
//	}
//	
//	@Test(groups = {"HappyDay", "Creating And Managing Users", "HappyDay66918", "EMResource Base"}, priority = 8)
//	public void HappyDay66918() throws Exception {
//
////		3 new functions
//		
//		TCID = "66918";
//		TC_DESCRIPTION = "Verify that a user can be provided the right to setup Roles.";
//
//		String username		= usersDataCreation.name,
//				userFullName = usersDataCreation.fullName,
//				roleName	= rolesDataCreation.name,
//				edit_roleName = rolesDataCreation.name2;
//
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//
//		navigateTo.users();
//		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
////		.provideSetupRolesRightAndSave()	-- NEW
//		
//		login.logOut()
//		.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
//		
//		navigateTo.roles();
//		
//		roles.createRole(roleName);
////		.verifyRoleInRoleList(roleName)	-- NEW
////		.editRole(roleName)	-- NEW
////			clickOnEditOfRole(roleName)
////			enterRoleName(edit_roleName)
////			clickOnSave()
////		.verifyRoleInRoleList(edit_roleName);
//
//		login.logOut();
//		
//	}
//	
//	@Test(groups = {"HappyDay", "Creating And Managing Users", "HappyDay66939", "EMResource Base"}, priority = 9)
//	public void HappyDay66939() throws Exception {
//
////		3 new functions
//		
//		TCID = "66939";
//		TC_DESCRIPTION = "Verify that a user can be provided the right to view custom view.";
//
//		String username		= usersDataCreation.name,
//				userFullName = usersDataCreation.fullName,
//				roleName	= rolesDataCreation.name,
//				edit_roleName = rolesDataCreation.name2;
//
////		use STs and resource from precondition: roleBasedNumberStatusType
////		resource from above PC only
//		
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//
//		navigateTo.users();
//		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
//		.provideViewCustomViewRightAndSave();
//		
//		login.logOut()
//		.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
//		
////		viewsList.createCustomizedViewFromPreferences(resourceName, resourceValues, statusTypesValues)
////		.verifyResourceTypeResourceAndStatusTypeInCustomizedView(_resourceType, _resource, _statusType);
//		viewsList.verifyCustomViewTablePage();
//		
//		navigateTo.customView();
//		
////		viewsList.createCustomizedViewFromPreferences(resourceName, resourceValues, statusTypesValues)
////		.verifyResourceTypeResourceAndStatusTypeInCustomizedView(_resourceType, _resource, _statusType);
//		viewsList.verifyEditCustomViewPage();
////		viewsList.clickOnCustomize();	-- NEW
//		viewsList.verifyEditCustomViewPage();
//		
//		login.logOut();
//		
//	}
//	
//	@Test(groups = {"HappyDay", "Creating And Managing Users", "HappyDay66939", "EMResource Base"}, priority = 10)
//	public void HappyDay67054() throws Exception {
//
//		TCID = "68091";
//		TC_DESCRIPTION = "Verify that a user can be provided the right to maintain event templates.";
//
////		2 NEW functions
//		
//		String username		= usersDataCreation.name,
//				userFullName = usersDataCreation.fullName,
//				username_1		= usersDataCreation.name1,
//				userFullName_1 = usersDataCreation.fullName1,
//				username_2		= usersDataCreation.name2,
//				userFullName_2 = usersDataCreation.fullName2,
//				username_3		= usersDataCreation.name3,
//				userFullName_3 = usersDataCreation.fullName3,
//				username_4		= usersDataCreation.name4,
//				userFullName_4 = usersDataCreation.fullName4;
//		
//		ArrayList<String> userName = new ArrayList<>();
//		userName.addAll(Arrays.asList(username_1, username_2));
//		
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//
//		navigateTo.users();
//		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
////		.provideMaintainEventTemplateRightAndSave()	-- NEW
//		usersList.verifyUserInUsersList(username);
//		
//		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username_1, UsersData.INITIAL_PASSWORD, userFullName_1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
//		.provideMaintainEventsRightAndSave()
//		.verifyUserInUsersList(username_1);
//		
//		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username_2, UsersData.INITIAL_PASSWORD, userFullName_2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
//		.provideMaintainEventsRightAndSave()
//		.verifyUserInUsersList(username_2);
//		
//		usersList.createUserWithMandatoryDetailsAndEMailPager(username_3, UsersData.INITIAL_PASSWORD, userFullName_3, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
//		.verifyUserInUsersList(username_3);
//		
//		navigateTo.eventSetUp();
//		eventSetUp.createEventTemplateDeselectingWebOption(eventSetUpDataCreation.name, eventSetUpDataCreation.definition, RT_Value1, statusType_Values)
//				  .selectNotificationsForUserAndSave(usersDataCreation.name)
//				  .clickOnNotificationsAndDeSelectAllNotifications(eventSetUpDataCreation.name);
//		
//		eventSetUp.createEventTemplateDeselectingWebOption(eventSetUpDataCreation.name1, eventSetUpDataCreation.definition1, RT_Value1, statusType_Values)
//		  .clickOnNotificationsAndDeSelectAllNotifications(eventSetUpDataCreation.name1);
//		
//		login.logOut()
//		.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
//		
//		navigateTo.eventSetUp();
////		eventSetUp.editEventTemplateMandatoryDetails(eventTemplateName, edit_name, edit_definition)	-- NEW, alrdy written by me
//		eventSetUp.navigateToEventSecurityForEventTemplateScreen(eventSetUpDataCreation.name1, userName);
////		verifyUsersNotPresentOnEventSecurityForEventTemplate(eventSetUpDataCreation.name1, username_3)	-- NEW
//		
//		login.logOut()
//		.loginAsNewUser(username_1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
//		
//		navigateTo.eventManagment();
//		eventManagement.clickOnCreateNewMultiRegionEvent()
//		
//		login.logOut();
//		
//	}
}