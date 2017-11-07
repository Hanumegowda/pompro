package RequirementGroups.CreatingAndManagingEvents;

import java.util.ArrayList;
import org.testng.annotations.Test;
import EMR.data.EventData;
import EMR.data.EventSetUpData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.Mails;
import EMR.pages.Map;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.Shared;
import EMR.pages.UsersList;
import qaFramework.Configurations.Configuration;

public class CreatePrivateEvent extends Configuration{
	
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceData resourceData;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	ResourceCreateData resourceDataCreation;
	UsersData usersData;
	UsersCreateData userDataCreation;
	EventSetUpData eventSetUpData;
	EventSetUpCreateData eventSetupDataCreation;
	EventData eventData;
	EventCreateData eventDataCreation;
	
	Login login;
	Shared navigateTo;
	EventManagement eventManagement;
	UsersList usersList;
	EventSetUp eventSetUp;
	ResourceTypes resourceTypes;
	Resources resources;
	Mails mails;
	Map map;
	
	static String RESOURCE_TYPE_NAME, RESOURCE_TYPE_VALUE, RESOURCE_NAME, RESOURCE_VALUE, USER_WITH_CONFIGURE_REGIONAL_USER_ACCESS_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, EVENT_TEMPLATE_WITH_OUT_ADDRESS;
    static ArrayList<String> roleBasedAndEventOnlyStatusTypesValues, roleBasedAndEventOnlyStatusTypesNames;

	public CreatePrivateEvent() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay68347", "EMResource Base"})
	public void HappyDay68347() throws Exception {

		TCID = "68347";
		TC_DESCRIPTION = "Verify that a user with 'View all resources in private event' right can view the event related status types of resources associated with private event.";
		
//		statusTypeData = new StatusTypeData();
//		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
//		resourceData = new ResourceData();
//		resourceDataCreation=resourceData.new ResourceCreateData();
//		resourceTypeData = new ResourceTypeData();
//		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
//		usersData=new UsersData();
//		userDataCreation = usersData.new UsersCreateData();
//		eventSetUpData = new EventSetUpData();
//	    eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
//	    eventData = new EventData();
//		eventDataCreation = eventData.new EventCreateData();
//		
//		login = new Login(this.driver);
//		navigateTo = new Shared(this.driver);
//		usersList = new UsersList(this.driver);
//		eventManagement =  new EventManagement(this.driver);
//		eventSetUp = new EventSetUp(this.driver);
//		resourceTypes = new ResourceTypes(this.driver);
//		resources = new Resources(this.driver);
//		map = new Map(this.driver);
//		
//		String resourceTypeValue[] = new String[1];
//		String resourceValues[] = new String[1];
//		
//		roleBasedAndEventOnlyStatusTypesValues = new ArrayList<String>();
//		roleBasedAndEventOnlyStatusTypesValues.addAll(Arrays.asList(statusTypeData.Role_NST_Value_In_Region,statusTypeData.Role_MST_Value_In_Region,statusTypeData.Role_SST_Value_In_Region,statusTypeData.Role_TST_Value_In_Region,statusTypeData.Role_DST_Value_In_Region,statusTypeData.Role_NEDOCST_Value_In_Region,
//				statusTypeData.Event_Role_NST_Value_In_Region, statusTypeData.Event_Role_MST_Value_IN_Region, statusTypeData.Event_Role_SST_Value_In_Region, statusTypeData.Event_Role_TST_Value_In_Region, statusTypeData.Event_Role_DST_Value_IN_Region, statusTypeData.Event_Role_NEDOCST_Value_In_Region));
//		roleBasedAndEventOnlyStatusTypesNames = new ArrayList<String>();
//		roleBasedAndEventOnlyStatusTypesNames.addAll(Arrays.asList(statusTypeData.Role_NST_In_Region,statusTypeData.Role_MST_In_Region,statusTypeData.Role_SST_In_Region,statusTypeData.Role_TST_In_Region,statusTypeData.Role_DST_In_Region,statusTypeData.Role_NEDOCST_In_Region,
//				statusTypeData.Event_Role_NST_In_Region, statusTypeData.Event_Role_MST_In_Region, statusTypeData.Event_Role_SST_In_Region, statusTypeData.Event_Role_TST_In_Region, statusTypeData.Event_Role_DST_In_Region, statusTypeData.Event_Role_NEDOCST_In_Region));
//		
//		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
//	    
//		// precondition data	
//	    navigateTo.resourceType();
//	    resourceTypes.createResourceType(resourceTypeDataCreation.name, roleBasedAndEventOnlyStatusTypesValues);
//	    resourceTypeValue[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);
//		RESOURCE_TYPE_NAME = resourceTypeDataCreation.name;
//		RESOURCE_TYPE_VALUE = resourceTypeValue[0];
//	    
//	    navigateTo.resources();
//	    resources.createResourceWithAddress(resourceDataCreation.name, resourceDataCreation.abbrevation, RESOURCE_TYPE_NAME, 
//	    		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
//	    		ResourceData.LASTNAME, ResourceData.STREETADDRESS,
//	    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
//	    resourceValues[0] = resources.getResourceValue(resourceDataCreation.name);
//	    RESOURCE_NAME = resourceDataCreation.name;
//	    RESOURCE_VALUE = resourceValues[0];
//	    
//	    System.out.println(RESOURCE_TYPE_NAME);
//	    System.out.println(RESOURCE_TYPE_VALUE);
//	    System.out.println(RESOURCE_NAME);
//	    System.out.println(RESOURCE_VALUE);
//	    
//	    //TCID-162617 starts
//		navigateTo.users();
//		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
//		         .provideConfigureRegionalUserAccessMainTainEventAndMaintainEventTemplateRights();
//		USER_WITH_CONFIGURE_REGIONAL_USER_ACCESS_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT = userDataCreation.name;
//		
//		navigateTo.eventSetUp();
//		eventSetUp.createEventTemplateSelectingWebOption(eventSetupDataCreation.name, eventSetupDataCreation.definition, RESOURCE_TYPE_VALUE, roleBasedAndEventOnlyStatusTypesValues, USER_WITH_CONFIGURE_REGIONAL_USER_ACCESS_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT);
//		EVENT_TEMPLATE_WITH_OUT_ADDRESS = eventSetupDataCreation.name;
//		
//		login.logOut();
//		
//		login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
//		navigateTo.eventManagment();
//		eventManagement.verifyEventManagementPage()
//		               .createPrivateEvent(eventSetupDataCreation.name, eventDataCreation.name, eventDataCreation.description, resourceDataCreation.name)
//		               .verifyEventOnEventManagementPage(eventDataCreation.name);
//		navigateTo.users();
//		usersList.verifyUsersListPage();
//		/*usersList.editUserAndProvideViewOverrideViewingRestrictionsRight()------>NEW        
//		                     .searchUser(userDataCreation.name)
//		                     .provideOverideviewingRistrictionRight()
//		                     .clickOnSave()*/
//      login.logOut();
//		
//		login.loginAsUser(userDataCreation.name, UsersData.PASSWORD);
//		eventManagement.clickOnEventBanner(eventDataCreation.name)
//		               .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(eventDataCreation.name, RESOURCE_TYPE_NAME, roleBasedAndEventOnlyStatusTypesNames, RESOURCE_NAME);
//		navigateTo.map();
//		map.openResourceOnMapAndVerifyResourceAndStatusTypes(resourceDataCreation.name, roleBasedAndEventOnlyStatusTypesNames);
//		map.clickViewInfoInPopupWindow();
//		map.verifyViewResDetailScreenIsDisplayedWithResName(resourceDataCreation.name);
//		   .verifyStatusTypesUnderSection(ArrayList);------>NEW   
//		login.logOut();
//		//incomplete
//		Result="PASS";
//	    Mobile View, mobile device part not automated
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay68367", "EMResource Base"})
	public void HappyDay68367() throws Exception {

		TCID = "68367";
		TC_DESCRIPTION = "Verify that a user with 'Update status' right on the resource can view the event related status types of the resource associated with private event.";
		
//		login.loginAsUser(USER_WITH_CONFIGURE_REGIONAL_USER_ACCESS_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
//	    navigateTo.eventManagment();
//		eventManagement.verifyEventManagementPage()
//		               .createPrivateEvent(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name1, eventDataCreation.description1, RESOURCE_NAME)
//		               .verifyEventOnEventManagementPage(eventDataCreation.name1);
//		navigateTo.users();
//		usersList.verifyUsersListPage()
//		         .editUserDeselectOverrideviewingRestrictionRight(USER_WITH_CONFIGURE_REGIONAL_USER_ACCESS_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT)------>NEW
//								this.searchUserName(username);
//								this.clickOnEdit(username);
//								this.deselectOverrideviewingRestrictionRight(resourceName);
//								this.clickOnSave();
//		         .editUserSelectUpdateRightOnResource(USER_WITH_CONFIGURE_REGIONAL_USER_ACCESS_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, RESOURCE_NAME);
//	    login.logOut();
//		
//		login.loginAsUser(userDataCreation.name, UsersData.PASSWORD);
//		eventManagement.clickOnEventBanner(eventDataCreation.name)
//		               .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(eventDataCreation.name, RESOURCE_TYPE_NAME, roleBasedAndEventOnlyStatusTypesNames, RESOURCE_NAME);
//		navigateTo.map();
//		map.openResourceOnMapAndVerifyResourceAndStatusTypes(resourceDataCreation.name, roleBasedAndEventOnlyStatusTypesNames);
//		map.clickViewInfoInPopupWindow();
//		map.verifyViewResDetailScreenIsDisplayedWithResName(resourceDataCreation.name);
//     	   .verifyStatusTypesUnderSection(ArrayList);
//     	login.logOut();
//     	Result="PASS";
//  	    Mobile View, mobile device part not automated
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay68368", "EMResource Base"})
	public void HappyDay68368() throws Exception {

		TCID = "68368";
		TC_DESCRIPTION = "Verify that a user with 'Run report' right on the resource can view the event related status types of the resource associated with private event.";
		
//		login.loginAsUser(USER_WITH_CONFIGURE_REGIONAL_USER_ACCESS_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
//	    navigateTo.eventManagment();
//		eventManagement.verifyEventManagementPage()
//		               .createPrivateEvent(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name2, eventDataCreation.description2, RESOURCE_NAME)
//		               .verifyEventOnEventManagementPage(eventDataCreation.name1);
//		navigateTo.users();
//		usersList.verifyUsersListPage()
		         /*.editUserDeselectUpdateRightOfResource()
		         					this.searchUserName(username);
	                				this.clickOnEdit(username);
	                				this.deselectUpdateResourceRightOfResource(resourceName);
	                				this.clickOnSave();
	                				this.verifyUsersListPage();*/
		         /*.editUserSelectRunReportRightOnResource(USER_WITH_CONFIGURE_REGIONAL_USER_ACCESS_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, RESOURCE_NAME);---->NEW
	                            this.searchUserName(username);
		 		                this.clickOnEdit(username);
				                this.selectRunReportRightOnResource(resourceName);
				                this.clickOnSave();
				                this.verifyUsersListPage();*/
//		login.logOut();
//		
//		login.loginAsUser(userDataCreation.name, UsersData.PASSWORD);
//		eventManagement.clickOnEventBanner(eventDataCreation.name)
//		               .verifyResourceResourceTypeAndStatusTypesUnderEventStatus(eventDataCreation.name, RESOURCE_TYPE_NAME, roleBasedAndEventOnlyStatusTypesNames, RESOURCE_NAME);
//		navigateTo.map();
//		map.openResourceOnMapAndVerifyResourceAndStatusTypes(resourceDataCreation.name, roleBasedAndEventOnlyStatusTypesNames);
//		map.clickViewInfoInPopupWindow();
//		map.verifyViewResDetailScreenIsDisplayedWithResName(resourceDataCreation.name);
//     	   .verifyStatusTypesUnderSection(ArrayList);
//     	login.logOut();
//		Result="PASS";
//	    Mobile View, mobile device part not automated
}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay68369", "EMResource Base"})
	public void HappyDay68369() throws Exception {

		TCID = "68369";
		TC_DESCRIPTION = "Verify that a user with 'Associated with' right on the resource cannot view the event related status types of the resource associated with private event.";

//		login.loginAsUser(USER_WITH_CONFIGURE_REGIONAL_USER_ACCESS_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
//	    navigateTo.eventManagment();
//		eventManagement.verifyEventManagementPage()
//		               .createPrivateEvent(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name2, eventDataCreation.description2, RESOURCE_NAME)
//		               .verifyEventOnEventManagementPage(eventDataCreation.name1);
//		navigateTo.users();
//		usersList.verifyUsersListPage()
		 /*.editUserDeselectRunReportRightOfResource()
					this.searchUserName(username);
					this.clickOnEdit(username);
					this.deselectRunReportRightOfResource(resourceName);
					this.clickOnSave();
					this.verifyUsersListPage();*/
		 /*.editUserSelectAssociateRightOnResource(USER_WITH_CONFIGURE_REGIONAL_USER_ACCESS_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, RESOURCE_NAME);---->NEW
                            this.searchUserName(username);
         					this.clickOnEdit(username);
        					this.selectAssociateRightOnResource(resourceName);
        					this.clickOnSave();
        					this.verifyUsersListPage();*/
//      login.logOut();
//
//      login.loginAsUser(userDataCreation.name, UsersData.PASSWORD);
//		eventManagement.clickOnEventBanner(eventDataCreation.name)
//		 			   .verifyErrorMessage()---->NEW
//		navigateTo.map();
//		map.openResourceOnMapAndVerifyResourceAndStatusTypes(resourceDataCreation.name, roleBasedStatusTypesNames)
//		   .openResourceOnMapAndVerifyNoStatusTypesDisplayed(resourceDataCreation.name, roleBasedEventOnlyStatusTypesNames)
//		map.clickViewInfoInPopupWindow();
//		map.verifyViewResDetailScreenIsDisplayedWithResName(resourceDataCreation.name)
//  	   .verifyStatusTypesUnderSection(ArrayList)
//		   .verifyStatusTypesNotUnderSection(ArrayList);---->NEW
//		login.logOut();
//		Result="PASS";
//	    Mobile View, mobile device part not automated
}
	
	@Test (groups = {"HappyDay", "Creating And Managing Events", "HappyDay68370", "EMResource Base"})
	public void HappyDay68370() throws Exception {

		TCID = "68370";
		TC_DESCRIPTION = "Verify that a user with 'View Resource' right cannot view the event related status types of the resource associated with private event.";

//		login.loginAsUser(USER_WITH_CONFIGURE_REGIONAL_USER_ACCESS_MAINTAIN_EVENT_MAINTAIN_EVENT_TEMPLATE_RIGHT, UsersData.PASSWORD);
//	    navigateTo.eventManagment();
//		eventManagement.verifyEventManagementPage()
//		               .createPrivateEvent(EVENT_TEMPLATE_WITH_OUT_ADDRESS, eventDataCreation.name2, eventDataCreation.description2, RESOURCE_NAME)
//		               .verifyEventOnEventManagementPage(eventDataCreation.name1);
//		navigateTo.users();
//		usersList.verifyUsersListPage()
		 /*.editUserDeselectAssociateRightOnResource()---->NEW
					this.searchUserName(username);
					this.clickOnEdit(username);
					this.deselectAssociatedWithRightOfResource(resourceName);
					this.verifyViewResourceRightOfResourceIsSelected(resourceName);---->NEW
					this.clickOnSave();
					this.verifyUsersListPage();*/
//		 login.logOut();
//
//		       login.loginAsUser(userDataCreation.name, UsersData.PASSWORD);
//		 		eventManagement.clickOnEventBanner(eventDataCreation.name)
//		 		 			   .verifyErrorMessage()---->NEW
//		 		navigateTo.map();
//		 		map.openResourceOnMapAndVerifyResourceAndStatusTypes(resourceDataCreation.name, roleBasedStatusTypesNames)
//		 		   .openResourceOnMapAndVerifyNoStatusTypesDisplayed(resourceDataCreation.name, roleBasedEventOnlyStatusTypesNames)
//		 		map.clickViewInfoInPopupWindow();
//		 		map.verifyViewResDetailScreenIsDisplayedWithResName(resourceDataCreation.name)
//		   	   .verifyStatusTypesUnderSection(ArrayList)
//		 		   .verifyStatusTypesNotUnderSection(ArrayList);---->NEW
//		 		login.logOut();
//		 		Result="PASS";
//		 	    Mobile View, mobile device part not automated
	}		
}
