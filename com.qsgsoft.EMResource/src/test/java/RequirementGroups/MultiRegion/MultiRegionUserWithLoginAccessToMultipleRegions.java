package RequirementGroups.MultiRegion;

import java.util.ArrayList;
import java.util.Arrays;
import org.testng.annotations.Test;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.RolesData;
import EMR.data.StatusChangePreferncesData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData;
import EMR.pages.Login;
import EMR.pages.Map;
import EMR.pages.RegionList;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.RolesList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.StatusChangePreferences;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewResourceDetail;
import qaFramework.Configurations.Configuration;

public class MultiRegionUserWithLoginAccessToMultipleRegions extends Configuration{
	
	RolesData rolesData;
	RolesCreateData rolesDataCreation;
	UsersData usersData;
	UsersCreateData userDataCreation;
	ResourceData resourceData;
	ResourceTypeData resourceTypeData;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ViewData viewData;
	ResourceTypeCreateData resourceTypeDataCreation;
	ResourceCreateData resourceDataCreation;
	
	Login login;
	SelectRegion selectRegion;
	Shared navigateTo;
	RolesList rolesList;
	UsersList usersList;
	RegionList regionList;
	StatusChangePreferences statusChangePreferences;
	ResourceTypes resourceTypes;
	Resources resources;
	View view;
	Map map;
	ViewResourceDetail viewResourceDetail;
	
	static String ROLE_WITH_VIEW_RIGHT, RESOURCETYPE_NAME, RESOURCE_NAME, RESOURCE_VALUE, USER_WITH_UPDATE_RIGHT_ON_RESOURCE, USER_WITH_VIEW_CUSTOM_VIEW_RIGHT;

	static ArrayList<String> allStatusTypesValues, allstatusTypeNames, roleAndSharedstatusTypeNames, roleAndSharedStatusTypeValues, privatestatusTypesNames, resourceValues;
	
	public MultiRegionUserWithLoginAccessToMultipleRegions() throws Exception {
		super();
	}
	
	@Test (priority = 1, groups = {"HappyDay", "Multi Region", "HappyDay43656"})
	public void HappyDay43656() throws Exception {

		TCID = "43656";
		TC_DESCRIPTION = "User U1 has login access to regions A & B and has status change preferences set for a resource. After removing the user's role in region A, verify that user CANNOT view/edit status change preferences for those status types from region B.";

		rolesData =new RolesData();
		rolesDataCreation = rolesData.new RolesCreateData();
		usersData=new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		resourceData = new ResourceData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		viewData = new ViewData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		rolesList = new RolesList(this.driver);
		usersList = new UsersList(this.driver);
		regionList = new RegionList(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		
		String resourceTypeValue[] = new String[1];
		String resourceValues[] = new String[1];
		String roleValue1  = "";
				
		allStatusTypesValues = new ArrayList<String>();
		allStatusTypesValues.addAll(Arrays.asList(statusTypeData.Role_NST_Value_In_Region,statusTypeData.Role_MST_Value_In_Region,statusTypeData.Role_SST_Value_In_Region,statusTypeData.Role_TST_Value_In_Region,statusTypeData.Role_DST_Value_In_Region,statusTypeData.Role_NEDOCST_Value_In_Region,
				statusTypeData.Private_NST_Value_In_Region,statusTypeData.Private_MST_Value_In_Region,statusTypeData.Private_SST_Value_In_Region,statusTypeData.Private_TST_Value_In_Region,statusTypeData.Private_DST_Value_In_Region,statusTypeData.Private_NEDOCST_Value_In_Region,
				statusTypeData.Shared_NST_Value_In_Region,statusTypeData.Shared_MST_Value_In_Region,statusTypeData.Shared_SST_Value_In_Region,statusTypeData.Shared_TST_Value_In_Region,statusTypeData.Shared_DST_Value_In_Region,statusTypeData.Shared_NEDOCST_Value_In_Region));
		
		allstatusTypeNames = new ArrayList<String>();
		allstatusTypeNames.addAll(Arrays.asList(statusTypeData.Role_NST_In_Region,statusTypeData.Role_MST_In_Region,statusTypeData.Role_SST_In_Region,statusTypeData.Role_TST_In_Region,statusTypeData.Role_DST_In_Region,statusTypeData.Role_NEDOCST_In_Region,
				statusTypeData.Private_NST_In_Region,statusTypeData.Private_MST_In_Region,statusTypeData.Private_SST_In_Region,statusTypeData.Private_TST_In_Region,statusTypeData.Private_DST_In_Region,statusTypeData.Private_NEDOCST_In_Region,
				statusTypeData.Shared_NST_In_Region,statusTypeData.Shared_MST_In_Region,statusTypeData.Shared_SST_In_Region,statusTypeData.Shared_TST_In_Region,statusTypeData.Shared_DST_In_Region,statusTypeData.Shared_NEDOCST_In_Region));
		
		roleAndSharedstatusTypeNames = new ArrayList<String>();
		roleAndSharedstatusTypeNames.addAll(Arrays.asList(statusTypeData.Role_NST_In_Region,statusTypeData.Role_MST_In_Region,statusTypeData.Role_SST_In_Region,statusTypeData.Role_TST_In_Region,statusTypeData.Role_DST_In_Region,statusTypeData.Role_NEDOCST_In_Region,
				statusTypeData.Shared_NST_In_Region,statusTypeData.Shared_MST_In_Region,statusTypeData.Shared_SST_In_Region,statusTypeData.Shared_TST_In_Region,statusTypeData.Shared_DST_In_Region,statusTypeData.Shared_NEDOCST_In_Region));
		
		roleAndSharedStatusTypeValues = new ArrayList<String>();
		roleAndSharedStatusTypeValues.addAll(Arrays.asList(statusTypeData.Role_NST_Value_In_Region,statusTypeData.Role_MST_Value_In_Region,statusTypeData.Role_SST_Value_In_Region,statusTypeData.Role_TST_Value_In_Region,statusTypeData.Role_DST_Value_In_Region,statusTypeData.Role_NEDOCST_Value_In_Region,
				statusTypeData.Shared_NST_Value_In_Region,statusTypeData.Shared_MST_Value_In_Region,statusTypeData.Shared_SST_Value_In_Region,statusTypeData.Shared_TST_Value_In_Region,statusTypeData.Shared_DST_Value_In_Region,statusTypeData.Shared_NEDOCST_Value_In_Region));
		
		privatestatusTypesNames = new ArrayList<String>();
		privatestatusTypesNames.addAll(Arrays.asList(statusTypeData.Private_NST_In_Region,statusTypeData.Private_MST_In_Region,statusTypeData.Private_SST_In_Region,statusTypeData.Private_TST_In_Region,statusTypeData.Private_DST_In_Region,statusTypeData.Private_NEDOCST_In_Region));
	
		// precondition data	
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
	    navigateTo.roles();
	    rolesList.createRoleDeselectUpdateRight(rolesDataCreation.name);
	    roleValue1 = rolesList.getRoleValue(rolesDataCreation.name);
	    ROLE_WITH_VIEW_RIGHT = roleValue1;
	    
	    navigateTo.resourceType();
	    resourceTypes.createResourceType(resourceTypeDataCreation.name, allStatusTypesValues);
	    resourceTypeValue[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);
		RESOURCETYPE_NAME = resourceTypeDataCreation.name;
	    
	    navigateTo.resources();
	    resources.createResourceWithAddress(resourceDataCreation.name, resourceDataCreation.abbrevation, RESOURCETYPE_NAME, 
	    		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
	    		ResourceData.LASTNAME, ResourceData.STREETADDRESS,
	    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
	    resourceValues[0] = resources.getResourceValue(resourceDataCreation.name);
	    RESOURCE_NAME = resourceDataCreation.name;
	    RESOURCE_VALUE = resourceValues[0];
	    
	    System.out.println(RESOURCE_NAME);
	    System.out.println(RESOURCE_VALUE);
	    System.out.println(ROLE_WITH_VIEW_RIGHT);

	    //TCID-43656 starts
	    
	    String regionName2 = regionList.getRegionValue(RegionData.REGION_NAME_2);
	    navigateTo.users();
	    usersList.createUserWithRole(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, roleValue1)
	    		 .provideUpdateRightOnResourceAndSave(RESOURCE_NAME)
	    		 .searchUserName(userDataCreation.name)
	             .provideRegionAccessToUser(userDataCreation.name,regionName2 );
	    
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
	    navigateTo.users();
	    usersList.searchUser(userDataCreation.name)
	    		 .selectFirstRole()
	    		 .provideEditStatusChangeNotificationPreferencesAndSave();
	    login.logOut();
	    
	    login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
	    navigateTo.navigateToStatusChangePrefsUnderPreferences();
	    statusChangePreferences.setStatusChangeNotifications(RESOURCE_NAME, RESOURCE_VALUE, RESOURCETYPE_NAME)
	    					   .expandAndverifyStatusTypesUnderSection(allstatusTypeNames, viewData.sectionInRegionName)
                               .provideReceiveStatusChangeNotificationsToNumberStatusType(RESOURCE_VALUE, statusTypeData.Role_NST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNST, StatusChangePreferncesData.BELOWVALUEFORNST)
	    					   .provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(RESOURCE_VALUE, statusTypeData.Role_MST_Value_In_Region, statusTypeData.roleStatusesValues1InRegion, statusTypeData.roleStatusesValues2InRegion)
                               .provideReceiveStatusChangeNotificationsToSStStatusType(RESOURCE_VALUE, statusTypeData.Role_SST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORSST, StatusChangePreferncesData.BELOWVALUEFORSST)
	    					   .provideReceiveStatusChangeNotificationsToTextStatusType(RESOURCE_VALUE, statusTypeData.Role_TST_Value_In_Region)
                               .provideReceiveStatusChangeNotificationsToDateStatusType(RESOURCE_VALUE, statusTypeData.Role_DST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToNedocsStatusType(RESOURCE_VALUE, statusTypeData.Role_NEDOCST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNDST, StatusChangePreferncesData.BELOWVALUEFORNDST)
	    					   
	    					   .provideReceiveStatusChangeNotificationsToNumberStatusType(RESOURCE_VALUE, statusTypeData.Private_NST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNST, StatusChangePreferncesData.BELOWVALUEFORNST)
	    					   .provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(RESOURCE_VALUE, statusTypeData.Private_MST_Value_In_Region, statusTypeData.privateStatusesValues1InRegion, statusTypeData.privateStatusesValues2InRegion)
	    					   .provideReceiveStatusChangeNotificationsToSStStatusType(RESOURCE_VALUE, statusTypeData.Private_SST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORSST, StatusChangePreferncesData.BELOWVALUEFORSST)
	    					   .provideReceiveStatusChangeNotificationsToTextStatusType(RESOURCE_VALUE, statusTypeData.Private_TST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToDateStatusType(RESOURCE_VALUE, statusTypeData.Private_DST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToNedocsStatusType(RESOURCE_VALUE, statusTypeData.Private_NEDOCST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNDST, StatusChangePreferncesData.BELOWVALUEFORNDST)
	    					   
	    					   .provideReceiveStatusChangeNotificationsToNumberStatusType(RESOURCE_VALUE, statusTypeData.Shared_NST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNST, StatusChangePreferncesData.BELOWVALUEFORNST)
	    					   .provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(RESOURCE_VALUE, statusTypeData.Shared_MST_Value_In_Region, statusTypeData.sharedStatusesValues1InRegion, statusTypeData.sharedStatusesValues2InRegion)
	    					   .provideReceiveStatusChangeNotificationsToSStStatusType(RESOURCE_VALUE, statusTypeData.Shared_SST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORSST, StatusChangePreferncesData.BELOWVALUEFORSST)
	    					   .provideReceiveStatusChangeNotificationsToTextStatusType(RESOURCE_VALUE, statusTypeData.Shared_TST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToDateStatusType(RESOURCE_VALUE, statusTypeData.Shared_DST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToNedocsStatusType(RESOURCE_VALUE, statusTypeData.Shared_NEDOCST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNDST, StatusChangePreferncesData.BELOWVALUEFORNDST)
	    					   .clickOnSave();
		statusChangePreferences.verifyStatusTypesUnderResourceInStatusChangePreferencesPage(RESOURCE_NAME, allstatusTypeNames);
		login.logOut();
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
	    navigateTo.roles();
	    rolesList.deleteRole(rolesDataCreation.name);
	    login.logOut();
	    
	    login.loginToRegionAsUser(userDataCreation.name, UsersData.PASSWORD, RegionData.REGION_NAME_2);
	    navigateTo.navigateToStatusChangePrefsUnderPreferences();
	    statusChangePreferences.verifyStatusTypesUnderResourceInStatusChangePreferencesPage(RESOURCE_NAME, privatestatusTypesNames)
	    					   .editPreference(RESOURCE_NAME)
	    					   .expandAndverifyStatusTypesUnderSection(privatestatusTypesNames, viewData.sectionInRegionName);
	    login.logOut();
	    
	    Result = "PASS";
	}
	
	@Test (priority = 2, groups = {"HappyDay", "Multi Region", "HappyDay46474"})
	public void HappyDay46474() throws Exception {

		TCID = "46474";
		TC_DESCRIPTION = "User U1 has login access to regions A & B and has added resource and associated status types to custom view. Verify that, after removing the View Resource right for the in region A, user CANNOT view/add resource on/to custom view from region B.";

		/****
		 * LoginAsAdmin(RegionData.REGIONNAME)
		 * Create a role'R2' to view role based and shared status types.
		 * Create user'U2' with role 'R2', update right on resource 'RS509-24-2016-070150' and provide access to 'Z_Auto_BQSPatch_rel12' region.
		 * Switch to 'Z_Auto_BQSPatch_rel12' region 
		 * Edit the user'U2' and provide 'View Custom View' right
		 * Login as user'U2' to region 'Z_Auto_BQSPatch_rel12'
		 * Create a custom view selecting resources 'RS509-24-2016-070150'[need to write function]
		 * Login as qsgtester/Abc@1234 to region 'Z_NewSmokeSuite_Region
		 * navigateToUsers 
		 * Edit the user'U2' and deselect the 'View Resource' right for resource 'RS509-24-2016-070150'[need to write function]
		 * Login as user'U2' to region 'Z_Auto_BQSPatch_rel12'
		 * NavigateToCustomView
		 * Verify the error message[need to write function]
		 * clickOnShowMap and verify 'Custom View - Map' screen is displayed.[need to write function] 
		 * verify Resource 'RS509-24-2016-070150' is not displayed in the 'Find Resource' drop down.[need to write function]
		 * clickOnCustomizelink[need to write function]
		 * verify Resource 'RS509-24-2016-070150' is not displayed on 'Edit Custom View' screen.[need to write function]
		 * search for the Resources'RS509-24-2016-070150'.[need to write function] 
		 * verify the error message[need to write function]
		 * clickOnCancel 
		 * verify 'Edit Custom View' screen is displayed. 
		 * clickOnOptions 
		 * verify status types are not displayed on 'Edit Custom View Options (Columns)' screen.[need to write function]
		 ****/
		
		resourceValues = new ArrayList<String>();
		resourceValues.add(RESOURCE_VALUE);
		
		rolesData =new RolesData();
		rolesDataCreation = rolesData.new RolesCreateData();
		usersData=new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		resourceData = new ResourceData();
		resourceTypeData = new ResourceTypeData();
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		viewData = new ViewData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		rolesList = new RolesList(this.driver);
		usersList = new UsersList(this.driver);
		regionList = new RegionList(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);
		view = new View(this.driver);
		map = new Map(this.driver);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		String regionName2 = regionList.getRegionValue(RegionData.REGION_NAME_2);
		navigateTo.users();
	    usersList.createUserWithRole(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, ROLE_WITH_VIEW_RIGHT)
	    		 .provideUpdateRightOnResourceAndSave(RESOURCE_NAME)
	    		 .searchUserName(userDataCreation.name)
	             .provideRegionAccessToUser(userDataCreation.name,regionName2 );
	    
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
	    navigateTo.users();
	    usersList.searchUser(userDataCreation.name)
	    		 .selectFirstRole()
	    		 .provideViewCustomViewRightAndSave();
	    USER_WITH_VIEW_CUSTOM_VIEW_RIGHT = userDataCreation.name;
	    login.logOut();
	    
	    login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
	    navigateTo.customView();
	    view.createCustomView(RESOURCE_NAME, resourceValues, allStatusTypesValues);
	    login.logOut();
	    
	    login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
	    navigateTo.users();
	    usersList.editAnddeselectUpdateViewResourceRightofresource(userDataCreation.name,RESOURCE_NAME);
	    login.logOut();
	    
	    login.loginToRegionAsUser(userDataCreation.name, UsersData.PASSWORD, RegionData.REGION_NAME_2);
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
	    navigateTo.customView();
	    view.verifyErrorMessageOnCustomViewTableScreen();
	    map.navigateToMapAndVerifyResourceIsNotFindresourceDropDown(RESOURCE_NAME);
	    String resourceNameWithItsResourceType = RESOURCE_NAME + " ["+ RESOURCETYPE_NAME+"]";
	    view.clickOnCustomizeVerifyResourceIsNotOnEditCustomViewScreen(resourceNameWithItsResourceType)
	        .searchResourceAndVerifyErrorMessageForResource(RESOURCE_NAME)
	        .clickCancelVerifyEditCustomViewPage()
	        .clickOptionsVerifyStatusTypesNotInEditCustomViewOptionsScreen(allstatusTypeNames);
	    login.logOut();
	    
	    Result = "PASS";
	}
	
//	@Test (priority = 3, groups = {"HappyDay", "Multi Region", "HappyDay46510"})
//	public void HappyDay46510() throws Exception {
//
//		TCID = "46510";
//		TC_DESCRIPTION = "For a user U1 who has login access to regions A & B, deselect status types in the ‘Refine’ window from region A and save. Verify that user cannot view/add those status types on/to custom view from region B.";
//
//		/****
//		 * LoginAsAdmin(RegionData.REGIONNAME)
//		 * navigateToUsers 
//		 * click on Edit link of the user'TC46474user'(select view resource right 'RS509-24-2016-070150')
//		 * clickOnRefine link corresponding to resource 'RS509-24-2016-070150'[need to write function]
//		 * deselect the role based and shared status types and save the user[doubt will it affect the RS]
//		 * Login as user'TC46474user' to region 'Z_Auto_BQSPatch_rel12'
//		 * NavigateToCustomView
//		 * verify only private status types are displayed
//		 * clickOnCustomizelink
//		 * clickOnOptions
//		 * verify only private status types are displayed
//		 * clickOnShowMap 
//		 * select the resource'RS509-24-2016-070150'
//		 * verify only private status types are displayed on the resource pop-up window
//		 * clickOnViewInfo link
//		 * verify only private status types are displayed on the 'View Resource Detail' page 
//		 ****/
////		BUG[EMS-7543] = User having login access to multiple regions (regions do not have mutual aid agreement) is unable to view role based and private status types of region �RG1� from �RG2� on �Custom View� screen. 
//		viewData = new ViewData();
//		statusTypeData = new StatusTypeData();
//		
//		login = new Login(this.driver);
//		navigateTo = new Shared(this.driver);
//		usersList = new UsersList(this.driver);
//		view = new View(this.driver);
//		map = new Map(this.driver);
//		viewResourceDetail = new ViewResourceDetail(this.driver);
//		
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//	    navigateTo.users();
//	    usersList.editAndSelectUpdateViewResourceRightofresource(USER_WITH_VIEW_CUSTOM_VIEW_RIGHT, RESOURCE_NAME)
//	             .clickRefineAndDeselectStatusType(RESOURCE_NAME, roleAndSharedStatusTypeValues);
//	    login.logOut();
//		
//	    login.loginToRegionAsUser(USER_WITH_VIEW_CUSTOM_VIEW_RIGHT, UsersData.PASSWORD, RegionData.REGION_NAME_2);
//	    navigateTo.customView();
//	    view.verifyResourceTypeAndStatusTypesUnderCustomView(RESOURCETYPE_NAME, privatestatusTypesNames)
//	        .verifyStatusTypesNotInCustomView(RESOURCETYPE_NAME, roleAndSharedstatusTypeNames)
//	        .clickCustomizeVerifyEditCustomViewPage()
//	        .clickOptionsVerifyStatusTypesNotInEditCustomViewOptionsScreen(roleAndSharedstatusTypeNames)
//	        .verifyStatusTypesInEditCustomViewOptionsScreen(privatestatusTypesNames)
//	        .clickCancel();
//	    map.clickOnShowMapAndVerifyStatusTypesOnPopUpWindow(RESOURCE_NAME, privatestatusTypesNames)
//	       .verifyStatusTypesNotDisplayedInPopupWindow(roleAndSharedstatusTypeNames)
//	       .clickViewInfoAndverifyViewResDetailScreen(RESOURCE_NAME);
//	    viewResourceDetail.verifyStatusTypesUnderSection(privatestatusTypesNames, viewData.sectionInRegionName)
//	                      .verifyStatusTypesNotDispalyedUnderSectionOfViewResourceDetailScreen(roleAndSharedstatusTypeNames, viewData.sectionInRegionName);
//	    login.logOut();
//	    
//	    Result = "PASS";
//	}
	
	@Test (priority = 4, groups = {"HappyDay", "Multi Region", "HappyDay46576"})
	public void HappyDay46576() throws Exception {

		TCID = "46576";
		TC_DESCRIPTION = "For a user U1 who has login access to regions A and B, deselect status types in the Refine window from region A and save. Verify that user cannot view/edit status change preferences for the status type from region B.";

		usersData=new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		resourceTypeData=new ResourceTypeData();
	    resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
	    resourceData=new ResourceData();
	    resourceDataCreation=resourceData.new ResourceCreateData();
	    statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		viewData = new ViewData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
	    resources = new Resources(this.driver);
	    regionList = new RegionList(this.driver);
	    statusChangePreferences = new StatusChangePreferences(this.driver);
	    
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		String regionName2 = regionList.getRegionValue(RegionData.REGION_NAME_2);
		
		navigateTo.users();
	    usersList.createUserWithRole(userDataCreation.name1, UsersData.INITIAL_PASSWORD, userDataCreation.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, ROLE_WITH_VIEW_RIGHT)
	             .provideUpdateRightOnResourceAndSave(RESOURCE_NAME)
	             .searchUserName(userDataCreation.name1)
	             .provideRegionAccessToUser(userDataCreation.name1, regionName2);
	    USER_WITH_UPDATE_RIGHT_ON_RESOURCE = userDataCreation.name1;
	    
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
	    navigateTo.users();
	    usersList.searchUser(userDataCreation.name1)
	             .selectFirstRole()
	             .selectAllViewResourceRight()
	             .provideEditStatusChangeNotificationPreferencesAndSave();
        login.logOut();
	    
	    login.loginAsNewUser(userDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
	    navigateTo.navigateToStatusChangePrefsUnderPreferences();
	    statusChangePreferences.setStatusChangeNotifications(RESOURCE_NAME, RESOURCE_VALUE, RESOURCETYPE_NAME)
	    					   .expandAndverifyStatusTypesUnderSection(allstatusTypeNames, viewData.sectionInRegionName)
                               .provideReceiveStatusChangeNotificationsToNumberStatusType(RESOURCE_VALUE, statusTypeData.Role_NST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNST, StatusChangePreferncesData.BELOWVALUEFORNST)
	    					   .provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(RESOURCE_VALUE, statusTypeData.Role_MST_Value_In_Region, statusTypeData.roleStatusesValues1InRegion, statusTypeData.roleStatusesValues2InRegion)
                               .provideReceiveStatusChangeNotificationsToSStStatusType(RESOURCE_VALUE, statusTypeData.Role_SST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORSST, StatusChangePreferncesData.BELOWVALUEFORSST)
	    					   .provideReceiveStatusChangeNotificationsToTextStatusType(RESOURCE_VALUE, statusTypeData.Role_TST_Value_In_Region)
                               .provideReceiveStatusChangeNotificationsToDateStatusType(RESOURCE_VALUE, statusTypeData.Role_DST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToNedocsStatusType(RESOURCE_VALUE, statusTypeData.Role_NEDOCST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNDST, StatusChangePreferncesData.BELOWVALUEFORNDST)
	    					   
	    					   .provideReceiveStatusChangeNotificationsToNumberStatusType(RESOURCE_VALUE, statusTypeData.Private_NST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNST, StatusChangePreferncesData.BELOWVALUEFORNST)
	    					   .provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(RESOURCE_VALUE, statusTypeData.Private_MST_Value_In_Region, statusTypeData.privateStatusesValues1InRegion, statusTypeData.privateStatusesValues2InRegion)
	    					   .provideReceiveStatusChangeNotificationsToSStStatusType(RESOURCE_VALUE, statusTypeData.Private_SST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORSST, StatusChangePreferncesData.BELOWVALUEFORSST)
	    					   .provideReceiveStatusChangeNotificationsToTextStatusType(RESOURCE_VALUE, statusTypeData.Private_TST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToDateStatusType(RESOURCE_VALUE, statusTypeData.Private_DST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToNedocsStatusType(RESOURCE_VALUE, statusTypeData.Private_NEDOCST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNDST, StatusChangePreferncesData.BELOWVALUEFORNDST)
	    					   
	    					   .provideReceiveStatusChangeNotificationsToNumberStatusType(RESOURCE_VALUE, statusTypeData.Shared_NST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNST, StatusChangePreferncesData.BELOWVALUEFORNST)
	    					   .provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(RESOURCE_VALUE, statusTypeData.Shared_MST_Value_In_Region, statusTypeData.sharedStatusesValues1InRegion, statusTypeData.sharedStatusesValues2InRegion)
	    					   .provideReceiveStatusChangeNotificationsToSStStatusType(RESOURCE_VALUE, statusTypeData.Shared_SST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORSST, StatusChangePreferncesData.BELOWVALUEFORSST)
	    					   .provideReceiveStatusChangeNotificationsToTextStatusType(RESOURCE_VALUE, statusTypeData.Shared_TST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToDateStatusType(RESOURCE_VALUE, statusTypeData.Shared_DST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToNedocsStatusType(RESOURCE_VALUE, statusTypeData.Shared_NEDOCST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNDST, StatusChangePreferncesData.BELOWVALUEFORNDST)
	    					   .clickOnSave();
		statusChangePreferences.verifyStatusTypesUnderResourceInStatusChangePreferencesPage(RESOURCE_NAME, allstatusTypeNames);
		login.logOut();
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
	    navigateTo.users();
	    usersList.searchUser(userDataCreation.name1)
	             .clickRefineAndDeselectStatusType(RESOURCE_NAME, roleAndSharedStatusTypeValues);
	    login.logOut();
	    
	    login.loginToRegionAsUser(userDataCreation.name1, UsersData.PASSWORD, RegionData.REGION_NAME_2);
	    navigateTo.navigateToStatusChangePrefsUnderPreferences();
	    statusChangePreferences.verifyStatusTypesUnderResourceInStatusChangePreferencesPage(RESOURCE_NAME, privatestatusTypesNames)
	                           .verifyStatusChangeNotificationPreferencesAreDeleted(RESOURCE_NAME, roleAndSharedstatusTypeNames)
	    					   .editPreference(RESOURCE_NAME)
	    					   .expandAndverifyStatusTypesUnderSection(privatestatusTypesNames, viewData.sectionInRegionName)
	    					   .verifyStatusTypesNotUnderSection(roleAndSharedStatusTypeValues, viewData.sectionInRegionName)
	    					   .clickOnCancel()
	    					   .setStatusChangeNotifications(RESOURCE_NAME, RESOURCE_VALUE, RESOURCETYPE_NAME)
	    					   .expandAndverifyStatusTypesUnderSection(privatestatusTypesNames, viewData.sectionInRegionName)
	    					   .verifyStatusTypesNotUnderSection(roleAndSharedStatusTypeValues, viewData.sectionInRegionName);
	    login.logOut();
	    
	    Result = "PASS";	
	}
	
	@Test (priority=5,groups = {"HappyDay", "Multi Region", "HappyDay46577"})
	public void HappyDay46577() throws Exception {

		TCID = "46577";
		TC_DESCRIPTION = "User U1 has login access to regions A & B. Verify that, after removing the View Resource right for the in region A, user CANNOT view/edit status change preferences for resource from region B.";

		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);
		view = new View(this.driver);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
	    navigateTo.users();
	    usersList.editAnddeselectUpdateViewResourceRightofresource(USER_WITH_UPDATE_RIGHT_ON_RESOURCE,RESOURCE_NAME);
	    login.logOut();
	    
	    login.loginToRegionAsUser(USER_WITH_UPDATE_RIGHT_ON_RESOURCE, UsersData.PASSWORD, RegionData.REGION_NAME_2);
	    navigateTo.navigateToStatusChangePrefsUnderPreferences();
	    statusChangePreferences.verifyStatusChangeNotificationPreferencesAreDeleted(RESOURCE_NAME, allstatusTypeNames)
	                           .searchResource(RESOURCE_NAME);
	    view.verifyErrorMessageForResource();
	    login.logOut();
	    
	    Result = "PASS";
	}
	
	@Test (priority = 6, groups = {"HappyDay", "Multi Region", "HappyDay50625"})
	public void HappyDay50625() throws Exception {

		TCID = "50625";
		TC_DESCRIPTION = "User U1 has login access to regions A & B. Verify that user CANNOT view/edit status change preferences for private status types of region A from region B when affiliated resource rights for the resource are removed in region A.";

		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		usersData=new UsersData();
		userDataCreation = usersData.new UsersCreateData();
		viewData = new ViewData();
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		selectRegion = new SelectRegion(this.driver);
		usersList = new UsersList(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);
		regionList = new RegionList(this.driver);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		String regionName2 = regionList.getRegionValue(RegionData.REGION_NAME_2);
		navigateTo.users();
	    usersList.createUserWithRole(userDataCreation.name2, UsersData.INITIAL_PASSWORD, userDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, ROLE_WITH_VIEW_RIGHT)
	             .provideAllAffiliatedRightOnResource(RESOURCE_NAME)
	             .searchUserName(userDataCreation.name2)
	             .provideRegionAccessToUser(userDataCreation.name2, regionName2);
	
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
	    navigateTo.users();
	    usersList.searchUser(userDataCreation.name2)
	             .selectFirstRole()
	             .selectAllViewResourceRight()
	             .provideEditStatusChangeNotificationPreferencesAndSave();
        login.logOut();
	    
	    login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
	    navigateTo.navigateToStatusChangePrefsUnderPreferences();
	    statusChangePreferences.setStatusChangeNotifications(RESOURCE_NAME, RESOURCE_VALUE, RESOURCETYPE_NAME)
	    					   .expandAndverifyStatusTypesUnderSection(allstatusTypeNames, viewData.sectionInRegionName)
                               .provideReceiveStatusChangeNotificationsToNumberStatusType(RESOURCE_VALUE, statusTypeData.Role_NST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNST, StatusChangePreferncesData.BELOWVALUEFORNST)
	    					   .provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(RESOURCE_VALUE, statusTypeData.Role_MST_Value_In_Region, statusTypeData.roleStatusesValues1InRegion, statusTypeData.roleStatusesValues2InRegion)
                               .provideReceiveStatusChangeNotificationsToSStStatusType(RESOURCE_VALUE, statusTypeData.Role_SST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORSST, StatusChangePreferncesData.BELOWVALUEFORSST)
	    					   .provideReceiveStatusChangeNotificationsToTextStatusType(RESOURCE_VALUE, statusTypeData.Role_TST_Value_In_Region)
                               .provideReceiveStatusChangeNotificationsToDateStatusType(RESOURCE_VALUE, statusTypeData.Role_DST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToNedocsStatusType(RESOURCE_VALUE, statusTypeData.Role_NEDOCST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNDST, StatusChangePreferncesData.BELOWVALUEFORNDST)
	    					   
	    					   .provideReceiveStatusChangeNotificationsToNumberStatusType(RESOURCE_VALUE, statusTypeData.Private_NST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNST, StatusChangePreferncesData.BELOWVALUEFORNST)
	    					   .provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(RESOURCE_VALUE, statusTypeData.Private_MST_Value_In_Region, statusTypeData.privateStatusesValues1InRegion, statusTypeData.privateStatusesValues2InRegion)
	    					   .provideReceiveStatusChangeNotificationsToSStStatusType(RESOURCE_VALUE, statusTypeData.Private_SST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORSST, StatusChangePreferncesData.BELOWVALUEFORSST)
	    					   .provideReceiveStatusChangeNotificationsToTextStatusType(RESOURCE_VALUE, statusTypeData.Private_TST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToDateStatusType(RESOURCE_VALUE, statusTypeData.Private_DST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToNedocsStatusType(RESOURCE_VALUE, statusTypeData.Private_NEDOCST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNDST, StatusChangePreferncesData.BELOWVALUEFORNDST)
	    					   
	    					   .provideReceiveStatusChangeNotificationsToNumberStatusType(RESOURCE_VALUE, statusTypeData.Shared_NST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNST, StatusChangePreferncesData.BELOWVALUEFORNST)
	    					   .provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(RESOURCE_VALUE, statusTypeData.Shared_MST_Value_In_Region, statusTypeData.sharedStatusesValues1InRegion, statusTypeData.sharedStatusesValues2InRegion)
	    					   .provideReceiveStatusChangeNotificationsToSStStatusType(RESOURCE_VALUE, statusTypeData.Shared_SST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORSST, StatusChangePreferncesData.BELOWVALUEFORSST)
	    					   .provideReceiveStatusChangeNotificationsToTextStatusType(RESOURCE_VALUE, statusTypeData.Shared_TST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToDateStatusType(RESOURCE_VALUE, statusTypeData.Shared_DST_Value_In_Region)
	    					   .provideReceiveStatusChangeNotificationsToNedocsStatusType(RESOURCE_VALUE, statusTypeData.Shared_NEDOCST_Value_In_Region, StatusChangePreferncesData.ABOVEVALUEFORNDST, StatusChangePreferncesData.BELOWVALUEFORNDST)
	    					   .clickOnSave();
		statusChangePreferences.verifyStatusTypesUnderResourceInStatusChangePreferencesPage(RESOURCE_NAME, allstatusTypeNames);
		login.logOut();
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
	    navigateTo.users();
	    usersList.editAnddeselectAllAffiliatedRightOnResource(userDataCreation.name2,RESOURCE_NAME);
	    login.logOut();
	    
	    login.loginToRegionAsUser(userDataCreation.name2, UsersData.PASSWORD, RegionData.REGION_NAME_2);
	    navigateTo.navigateToStatusChangePrefsUnderPreferences();
	    statusChangePreferences.verifyStatusTypesUnderResourceInStatusChangePreferencesPage(RESOURCE_NAME, roleAndSharedstatusTypeNames)
	    					   .verifyStatusChangeNotificationPreferencesAreDeleted(RESOURCE_NAME, privatestatusTypesNames)
	    					   .editPreference(RESOURCE_NAME)
	    					   .expandAndverifyStatusTypesUnderSection(roleAndSharedstatusTypeNames, viewData.sectionInRegionName)
	    					   .verifyStatusTypesNotUnderSection(privatestatusTypesNames, viewData.sectionInRegionName);
	    login.logOut();
	    
	    Result = "PASS";
	}
}
