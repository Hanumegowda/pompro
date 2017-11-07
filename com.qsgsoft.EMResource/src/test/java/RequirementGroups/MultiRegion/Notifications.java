package RequirementGroups.MultiRegion;

import java.util.ArrayList;
import java.util.Arrays;
import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration_Mails;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusChangePreferncesData;
import EMR.data.StatusTypeData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UpdateStatusData;
import EMR.data.UpdateStatusData.UpdateStatusCreateData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.Mails;
import EMR.pages.Map;
import EMR.pages.RegionDefault;
import EMR.pages.RegionList;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.StatusChangePreferences;
import EMR.pages.StatusTypes;
import EMR.pages.UpdateStatus;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewsUnderSetup;

public class Notifications extends Configuration_Mails {
	
	LoginData loginData;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceCreateData resourceDataCreation;
	UsersCreateData userDataCreation;
	UsersData usersData;
	RolesCreateData rolesDataCreation;
	ResourceData resourceData;
	ViewData viewData;
	ViewCreateData viewDataCreation;
	UpdateStatusData updateStatusData;
	UpdateStatusCreateData updateStatusCreateData;

	Login login;
	UsersList usersList;
	SelectRegion selectRegion;
	RegionDefault regionDefault;
	Shared navigateTo;
	RegionList regionList;
	StatusChangePreferences statusChangePreferences;
	ViewsUnderSetup viewUnderSetup;
	EventSetUp eventSetUp;
	EventManagement eventManagement;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	ViewsUnderSetup view;
	UpdateStatus updateStatus;
	View views;
	Mails mail;
	Map map;
	
	static String USER_TO_UPDATE, USER_TO_EDIT_STATUSCHANGE_NOTIFICATIONS, SHARED_RESOURCE_NAME, RESOURCE_TYPE , RESOURCE_ABBREVATION;
	
	static ArrayList<String> STATUSTYPE_NAMES= new ArrayList<String>();
	static ArrayList<String> STATUSTYPE_VALUES= new ArrayList<String>();
	static ArrayList<String> STATUSES_VALUES= new ArrayList<String>();

	public Notifications() throws Exception {
		super();}
	
	@Test(groups = {"HappyDay","MultiRegion","HappyDay84631"})
	public void HappyDay84631() throws Exception {

	TCID ="84631";
	TC_DESCRIPTION ="Verify that status change preferences for resources of other regions can be edited.";
	
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
	    updateStatusData = new UpdateStatusData();
	    updateStatusCreateData=updateStatusData.new UpdateStatusCreateData();
	    
	    login = new Login(this.driver); 
	    statusTypes = new StatusTypes(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	    navigateTo = new Shared(this.driver);
	    viewUnderSetup = new ViewsUnderSetup(this.driver);
	    usersList = new UsersList(this.driver);
	    resourceTypes = new ResourceTypes(this.driver);
	    resources = new Resources(this.driver);
	    updateStatus = new UpdateStatus(this.driver);
	    regionDefault = new RegionDefault(this.driver);
	    statusChangePreferences = new StatusChangePreferences(this.driver);
	    view = new ViewsUnderSetup(this.driver);
	    views= new View(this.driver);
	    mail = new Mails(this.driver1);
	    map = new Map(this.driver);
	    
	    ArrayList<String> firstTimeUpdatedvalues;
	    ArrayList<String> secondTimeUpdatedvalues;
	    ArrayList<String> statusTypesValues= new ArrayList<String>();
	    ArrayList<String> statusesValues= new ArrayList<String>();
	    ArrayList<String> statusTypesNames;
	    String[] resourceTypeValue = new String[1];
	    String[] resourceValue = new String[1];
		    
	login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD,RegionData.REGION_WITH_MUTUAL_AGREEMENT3);
	navigateTo.views();
	viewUnderSetup.createNewSection(viewDataCreation.section);
	navigateTo.statusTypes();
	
	//shared nst
	statusTypes.createSharedStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName,statusTypeDataCreation.description,viewDataCreation.section);
	statusTypesValues.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName));

	//shared mst
    statusTypes.createSharedStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description, viewDataCreation.section);
	statusTypes.createNewStatus(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR);
	statusesValues.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName1));
	statusTypes.createNewStatus(statusTypeDataCreation.statusesName2, StatusTypeData.STATUS_PURPLE_COLOR);			
	statusesValues.add(statusTypes.getStatusesValue(statusTypeDataCreation.statusesName2));
	statusTypes.clickOnReturnToStatusTypeList();
	statusTypesValues.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName));
	
	//shared saturation	
	statusTypes.createSharedStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sstName, statusTypeDataCreation.description,viewDataCreation.section);
	statusTypesValues.add(statusTypes.getStatusTypeValue(statusTypeDataCreation.sstName));

	statusTypesNames = new ArrayList<String>(Arrays.asList(statusTypeDataCreation.nstName,statusTypeDataCreation.mstName,statusTypeDataCreation.sstName));

	navigateTo.resourceType();
	resourceTypes.createResourceType(resourceTypeDataCreation.name, statusTypesValues);
    resourceTypeValue[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);
   
    navigateTo.resources();
    resources.createSharedResourceWithAddress(
    		resourceDataCreation.name, resourceDataCreation.abbrevation1,
    		resourceTypeDataCreation.name, ResourceData.STANDARDRESOURCETYPE,
    		ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, 
    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
    resourceValue[0] = resources.getResourceValue(resourceDataCreation.name);
    String resourceName[] ={resourceDataCreation.name};
    System.out.println(resourceDataCreation.name);
    
    navigateTo.users();
    usersList.createUserWithUpdateRightOnResource(userDataCreation.name2,UsersData.INITIAL_PASSWORD,userDataCreation.fullName,UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID,resourceName)
    .clickOnSave();
    System.out.println(userDataCreation.name2);
    
	selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);
	
    navigateTo.users();
    usersList.enterUserDetailsWithEMailAndPager(userDataCreation.name1,UsersData.INITIAL_PASSWORD,userDataCreation.fullName,UsersData.PRIMARY_EMAILID,UsersData.PRIMARY_EMAILID)
             .provideEditStatusChangeNotificationPreferences()
             .provideSetupOtherRegionViewsRightAndSave()
             .searchUser(userDataCreation.name1)
	         .clickOnStatusChangeNotificationPreferences();

	 statusChangePreferences
	                 .assignUserToStatusChangeNotifications(resourceDataCreation.name,resourceValue[0], userDataCreation.name1, resourceTypeDataCreation.name)
                     .expandAndverifyStatusTypesUnderUncategorizedSection(statusTypesNames)
                     .provideReceiveStatusChangeNotificationsToNumberStatusType(resourceValue[0], statusTypesValues.get(0), StatusChangePreferncesData.ABOVE_VALUE_100, StatusChangePreferncesData.BELOW_VALUE_20)
                     .provideReceiveStatusChangeNotificationsToSingleStatusUnderMultiStatusType(resourceValue[0], statusTypesValues.get(1), statusesValues.get(0))
                     .provideReceiveStatusChangeNotificationsToSStStatusType(resourceValue[0],statusTypesValues.get(2),StatusChangePreferncesData.ABOVE_VALUE_100, StatusChangePreferncesData.BELOW_VALUE_20)
                     .savePreferences();
	 statusChangePreferences
	                 .verifyStatusTypesUnderResourceInStatusChangePreferncsPage(resourceDataCreation.name,statusTypesNames);
     login.logOut();
     
     login.loginAsNewUser(userDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
     navigateTo.navigateToStatusChangePrefsUnderPreferences();
     statusChangePreferences
                     .verifyRetainedStatusChangePreferenceValues(statusTypeDataCreation.nstName, statusTypeDataCreation.mstName, statusTypeDataCreation.sstName, StatusChangePreferncesData.ABOVE_VALUE_100, StatusChangePreferncesData.BELOW_VALUE_20, statusTypeDataCreation.statusesName1)
                     .EditAndNavigateToEditMyStatusChangeNotifications(resourceDataCreation.name)
 	                 .expandAndverifyStatusTypesUnderUncategorizedSection(statusTypesNames)
 	                 .changeAboveAndBelowValuesForNumberStatusType(resourceValue[0], statusTypesValues.get(0), StatusChangePreferncesData.ABOVE_VALUE_80, StatusChangePreferncesData.BELOW_VALUE_15)
 	                 .deSelectMailWebPagerToSingleStatusUnderMultiStatusType(resourceValue[0], statusTypesValues.get(1), statusesValues.get(0))
	                 .provideReceiveStatusChangeNotificationsToSingleStatusUnderMultiStatusType(resourceValue[0], statusTypesValues.get(1), statusesValues.get(1))
	                 .changeAboveAndBelowValuesForSaturationStatusType(resourceValue[0],statusTypesValues.get(2),StatusChangePreferncesData.ABOVE_VALUE_80, StatusChangePreferncesData.BELOW_VALUE_15)
	                 .savePreferences();
     login.logOut();
     
     login.loginAsNewUser(userDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
     navigateTo.map();
     map.openResourceOnMapToUpdate(resourceDataCreation.name,statusTypesNames);
	 updateStatus.verifyUpdateStatusPageAndSelectAllToUpdate()
                 .enterNumberOrTextOrDateStatusTypesUpdateValue(statusTypesValues.get(0),UpdateStatusData.VALUE_19)
	             .selectMSTUpdateValue(statusTypesValues.get(1), statusesValues.get(0))
	             .enterUpdateSSTValues(statusTypesValues.get(2), UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE3)
	             .saveAndNavigateToUpdatedPage();
	 
	firstTimeUpdatedvalues = new ArrayList<String>(Arrays.asList(UpdateStatusData.VALUE_19,statusTypeDataCreation.statusesName1,UpdateStatusData.CALCULATED_SATURATION_SCORE_17));
	 login.logOut();
	 
	 login.loginAsUser(userDataCreation.name1,UsersData.PASSWORD);
	 regionDefault.verifyWebNotificationIsNotReceived();     
	 login.logOut();
	 
	 login.loginAsUser(userDataCreation.name2,UsersData.PASSWORD);
     navigateTo.map();
     map.openResourceOnMapToUpdate(resourceDataCreation.name,statusTypesNames);
	 updateStatus.verifyUpdateStatusPageAndSelectAllToUpdate();
	  	         
	 updateStatus .enterNumberOrTextOrDateStatusTypesUpdateValue(statusTypesValues.get(0),UpdateStatusData.VALUE_90)
	              .selectMSTUpdateValue(statusTypesValues.get(1), statusesValues.get(1))
	              .enterUpdateSSTValues(statusTypesValues.get(2), UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE1)
	              .saveAndNavigateToUpdatedPage();
	  map.selectResourceNameInFindResourceDropdown(resourceDataCreation.name);
	  
	  String updatedDateAndTime =map.getUpdatedDateAndTimeFromMap();
	  
	  secondTimeUpdatedvalues = new ArrayList<String>(Arrays.asList(UpdateStatusData.VALUE_90,statusTypeDataCreation.statusesName2,UpdateStatusData.CALCULATED_SATURATION_SCORE1));
	
	  login.logOut();
	  
	  login.loginAsUser(userDataCreation.name1, UsersData.PASSWORD);
	  
	  updateStatus.verifyUpdateStatusWebNotificationAndAcknolewdge(
						resourceDataCreation.name, statusTypesNames,
						firstTimeUpdatedvalues, secondTimeUpdatedvalues,
						updatedDateAndTime);
	  login.logOut();
	  
	  mail.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
	  mail.verifyMailAndPagerNotificationsForStatusChangeNotifications(
				resourceDataCreation.abbrevation1, userDataCreation.fullName,
				updatedDateAndTime, resourceDataCreation.name,
				statusTypesNames, firstTimeUpdatedvalues,
				secondTimeUpdatedvalues,RegionData.REGION_WITH_MUTUAL_AGREEMENT3,resourceTypeDataCreation.name)
				.logoutMail();
	  
	  USER_TO_UPDATE=userDataCreation.name2; 
	  USER_TO_EDIT_STATUSCHANGE_NOTIFICATIONS=userDataCreation.name1;
	  SHARED_RESOURCE_NAME = resourceDataCreation.name;
	  RESOURCE_TYPE = resourceTypeDataCreation.name;
	  STATUSTYPE_NAMES = statusTypesNames;
	  STATUSTYPE_VALUES=statusTypesValues;
	  STATUSES_VALUES=statusesValues;
	  RESOURCE_ABBREVATION=resourceDataCreation.abbrevation1;
	  Result = "PASS";
	  
	}
	    
  @Test(dependsOnMethods={"HappyDay84631"},groups = {"HappyDay","MultiRegion","HappyDay84635"})
	 public void HappyDay84635() throws Exception {

	TCID ="84635";
	TC_DESCRIPTION ="Verify that status change preferences for resources of other regions can be deleted.";
		
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
	    updateStatusData = new UpdateStatusData();
	    updateStatusCreateData=updateStatusData.new UpdateStatusCreateData();
	    
	    login = new Login(this.driver); 
	    statusTypes = new StatusTypes(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	    navigateTo = new Shared(this.driver);
	    viewUnderSetup = new ViewsUnderSetup(this.driver);
	    usersList = new UsersList(this.driver);
	    resourceTypes = new ResourceTypes(this.driver);
	    resources = new Resources(this.driver);
	    updateStatus = new UpdateStatus(this.driver);
	    regionDefault = new RegionDefault(this.driver);
	    statusChangePreferences = new StatusChangePreferences(this.driver);
	    view = new ViewsUnderSetup(this.driver);
	    views= new View(this.driver);
	    mail = new Mails(this.driver1);
	    map = new Map(this.driver);

		login.loginAsUserAndAcknowledgeWebNotification(USER_TO_EDIT_STATUSCHANGE_NOTIFICATIONS, UsersData.PASSWORD);
		navigateTo.navigateToStatusChangePrefsUnderPreferences();
		statusChangePreferences .deletePreferences(SHARED_RESOURCE_NAME);
		
		statusChangePreferences.verifyStatusChangeNotificationPreferencesAreDeleted(SHARED_RESOURCE_NAME, STATUSTYPE_NAMES);
		login.logOut();
		
		login.loginAsUser(USER_TO_UPDATE, UsersData.PASSWORD);
		navigateTo.map();
		map.openResourceOnMapToUpdate(SHARED_RESOURCE_NAME,STATUSTYPE_NAMES);
		updateStatus
				.verifyUpdateStatusPageAndSelectAllToUpdate()
				.enterNumberOrTextOrDateStatusTypesUpdateValue(
						STATUSTYPE_VALUES.get(0), UpdateStatusData.VALUE_90)
				.selectMSTUpdateValue(STATUSTYPE_VALUES.get(1),
						STATUSES_VALUES.get(1))
				.enterUpdateSSTValues(STATUSTYPE_VALUES.get(2),
						UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE1)
				.saveAndNavigateToUpdatedPage();
		login.logOut();
		
		 login.loginAsUser(USER_TO_EDIT_STATUSCHANGE_NOTIFICATIONS,UsersData.PASSWORD);
		 regionDefault.verifyWebNotificationIsNotReceived();     
		 login.logOut();
 
		mail.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mail.verifyNoNewEmailAndPagerNotificationsRecievedForStatusChange(SHARED_RESOURCE_NAME,RESOURCE_ABBREVATION)
	    .logoutMail();
		Result = "PASS";
	}
 
	
}