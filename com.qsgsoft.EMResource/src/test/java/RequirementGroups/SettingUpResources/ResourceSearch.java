package RequirementGroups.SettingUpResources;

import java.util.ArrayList;

import org.testng.annotations.Test;

import EMR.data.EventData;
import EMR.data.EventSetUpData;
import EMR.data.FormsData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.RolesData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.FormsData.FormsCreateData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.ActivateForms;
import EMR.pages.BlankForm;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.FormConfiguration;
import EMR.pages.FormTemplateDesigner;
import EMR.pages.Login;
import EMR.pages.Map;
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
import qaFramework.Configurations.Configuration;

public class ResourceSearch extends Configuration{

	public ResourceSearch() throws Exception {
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
	RolesCreateData rolesCreateData;
	FormTemplateDesigner formTemplateDesigner;
	ActivateForms activateForms;
	

	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	Shared shared;
	UsersList usersList;
	EventManagement eventManagement;
	FormConfiguration formConfiguration;
	RolesList rolesList;
	BlankForm blankForm;
	
	static  String[] resourceName = new String[1];
	static  String resourceTypeValue;
	static  String resourceTypeName;
	static  String[] statusTypeValueRT=new String[3];
	static  String[] statusTypeValueSRT=new String[3];
	static  String[] statusTypeName=new String[6];
	static  String resourceValue;
	static  String subResourceTypeValue;
	static  String subResourceTypeName;
	static  String[] subResourceName = new String[2];
	static  String[] subResourceValue = new String[2];
	static  String subRs;
	static  String[] usersNames = new String[5];

	
	@Test (groups = {"HappyDay", "Setting Up Resources","Resource Search", "HappyDay107722"})
	public void HappyDay107722() throws Exception {
	 
		TCID = "107722";
		TC_DESCRIPTION = "Verify that user with 'Override Viewing Restrictions' right on the parent resource can search for "
				+ "sub resources from the 'Find Resources' screen.";

		 	resourceTypeData=new ResourceTypeData();
		 	resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		    resourceData=new ResourceData();
		    resourceCreateData = resourceData.new ResourceCreateData();
		    statusTypeData=new StatusTypeData();
		    statusTypeDataCreation = statusTypeData.new StatusTypeCreateData(); 
			viewData = new ViewData();
		    viewDataCreation = viewData.new ViewCreateData();
			eventSetUpData=new EventSetUpData();
			eventSetUpCreateData=eventSetUpData.new EventSetUpCreateData();
			userdatData=new UsersData();
			usersCreateData= userdatData.new UsersCreateData();
			rolesData= new RolesData();
			rolesCreateData=rolesData.new RolesCreateData();
			eventData=new EventData();
			eventCreateData=eventData.new EventCreateData();
			formsData=new FormsData();
			formsCreateData=formsData.new FormsCreateData();

			
			
			login = new Login(this.driver);
			selectRegion = new SelectRegion(this.driver);
			navigateTo = new Shared(this.driver);
			regionList = new RegionList(this.driver);
			statusTypes = new StatusTypes(this.driver);
		    resourceTypes = new ResourceTypes(this.driver);
		    resources = new Resources(this.driver);
		    viewUnderSetup = new ViewsUnderSetup(this.driver);
		    map = new Map(this.driver);
		    resourceTypes = new ResourceTypes(this.driver); 
		    formTemplateDesigner = new FormTemplateDesigner(this.driver);
			shared = new Shared(this.driver);
		    eventSetUp=new EventSetUp(this.driver);
		    usersList =new UsersList(this.driver);
		    eventManagement=new EventManagement(this.driver);
		    view=new View(this.driver);
		    formConfiguration=new FormConfiguration(this.driver);
		    rolesList = new RolesList(this.driver);
		    
		    
		    login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.TESTREGION);
			navigateTo.viewUnderSetup();
			viewUnderSetup.createNewSection(viewDataCreation.section_1);
			navigateTo.statusTypes();
			statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName, statusTypeDataCreation.description, viewDataCreation.section_1)
			 			.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description, viewDataCreation.section_1)
						.createNewStatus(statusTypeDataCreation.statusesName,StatusTypeData.STATUS_PURPLE_COLOR)
			 			.createNewStatus(statusTypeDataCreation.statusesName1,StatusTypeData.STATUS_PURPLE_COLOR);
			navigateTo.statusTypes();
			statusTypes.createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.tstName, statusTypeDataCreation.description, viewDataCreation.section_1)
			 			.createSharedStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.sstName, statusTypeDataCreation.description, viewDataCreation.section_1)
			 			.createPrivateStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.nedocsName, statusTypeDataCreation.description, viewDataCreation.section_1)
			 			.createStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.dateName, statusTypeDataCreation.description, viewDataCreation.section_1);
			
			statusTypeValueRT[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName);
			statusTypeValueRT[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName);
			statusTypeValueRT[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.tstName);
			statusTypeValueSRT[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.sstName);
			statusTypeValueSRT[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nedocsName);
			statusTypeValueSRT[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.dateName);
			
			navigateTo.resourceType();
			resourceTypes.createResourceType(resourceTypeDataCreation.name, statusTypeValueRT);
			resourceTypeValue=resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);
			resourceTypeName=resourceTypeDataCreation.name;
			
			resourceTypes.createSubResourceType(resourceTypeDataCreation.subRtName, statusTypeValueSRT);
			subResourceTypeValue=resourceTypes.getSubResourceTypeValue(resourceTypeDataCreation.subRtName);
			subResourceTypeName=resourceTypeDataCreation.subRtName;
			
			navigateTo.resources();
			resources.createResourceWithAddress(resourceCreateData.name1, resourceCreateData.abbrevation1,resourceTypeDataCreation.name , ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
			resourceValue=resources.getResourceValue(resourceCreateData.name1);
			resourceName[0]=resourceCreateData.name1;
			
			resources.createSubResource(resourceCreateData.subResName, resourceName[0],  resourceCreateData.abbrevation1, resourceTypeDataCreation.subRtName, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME);
			subResourceValue[0]=resources.getSubResourceValue(resourceCreateData.subResName);
			subResourceName[0]=resourceCreateData.subResName;
			
			resources.createSubResource(resourceCreateData.subResName1, resourceName[0],  resourceCreateData.abbrevation2, resourceTypeDataCreation.subRtName, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME);
			subResourceValue[1]=resources.getSubResourceValue(resourceCreateData.subResName1);
			subResourceName[1]=resourceCreateData.subResName1;
			
			navigateTo.users();
			usersList.createUserWithUpdateRightOnResourceAndSave(usersCreateData.name1, UsersData.INITIAL_PASSWORD, usersCreateData.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceName);
			usersList.createUserWithAssociateRightOnResourceAndSave(usersCreateData.name2, UsersData.INITIAL_PASSWORD, usersCreateData.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceName[0]);
			usersList.createUserWithRunReportRightOnResourceAndSave(usersCreateData.name3, UsersData.INITIAL_PASSWORD, usersCreateData.fullName3, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceName[0]);
			usersList.createUserWithOverrideViewingRestrictionAndSave(usersCreateData.name4, UsersData.INITIAL_PASSWORD, usersCreateData.fullName4, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceName);
			usersList.createUserWithoutSelectingAnyRightOnResourceAndSave(usersCreateData.name5, UsersData.INITIAL_PASSWORD, usersCreateData.fullName5, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, resourceName);
			usersNames[0]= usersCreateData.name1;
			usersNames[1]= usersCreateData.name2;
			usersNames[2]= usersCreateData.name3;
			usersNames[3]= usersCreateData.name4;
			usersNames[4]= usersCreateData.name5;
			login.logOut();
			
			login.loginAsNewUser(usersCreateData.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
			shared.clickOnSearchInToolBar();
			view.verifySubResourceShouldBeRetrived(resourceCreateData.name1,resourceCreateData.subResName, RegionData.TESTREGION, resourceTypeDataCreation.subRtName);
			view.verifySubResourceShouldBeRetrived(resourceCreateData.name1,resourceCreateData.subResName1, RegionData.TESTREGION, resourceTypeDataCreation.subRtName);
			login.logOut();
			
			login.loginAsNewUser(usersCreateData.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
			shared.clickOnSearchInToolBar();
			view.verifySubResourceShouldBeRetrived(resourceCreateData.name1,resourceCreateData.subResName, RegionData.TESTREGION, resourceTypeDataCreation.subRtName);
			view.verifySubResourceShouldBeRetrived(resourceCreateData.name1,resourceCreateData.subResName1, RegionData.TESTREGION, resourceTypeDataCreation.subRtName);
			login.logOut();
			
			login.loginAsNewUser(usersCreateData.name3, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
			shared.clickOnSearchInToolBar();
			view.verifySubResourceShouldBeRetrived(resourceCreateData.name1,resourceCreateData.subResName, RegionData.TESTREGION, resourceTypeDataCreation.subRtName);
			view.verifySubResourceShouldBeRetrived(resourceCreateData.name1,resourceCreateData.subResName1, RegionData.TESTREGION, resourceTypeDataCreation.subRtName);
			login.logOut();
			
			login.loginAsNewUser(usersCreateData.name4, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
			shared.clickOnSearchInToolBar();
			view.verifySubResourceShouldBeRetrived(resourceCreateData.name1,resourceCreateData.subResName, RegionData.TESTREGION, resourceTypeDataCreation.subRtName);
			view.verifySubResourceShouldBeRetrived(resourceCreateData.name1,resourceCreateData.subResName1, RegionData.TESTREGION, resourceTypeDataCreation.subRtName);
			login.logOut();
			
			login.loginAsNewUser(usersCreateData.name5, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
			shared.clickOnSearchInToolBar();
			view.verifySubResourceShouldNotRetrived(resourceCreateData.name1,resourceCreateData.subResName, RegionData.TESTREGION, resourceTypeDataCreation.subRtName);
			view.verifySubResourceShouldNotRetrived(resourceCreateData.name1,resourceCreateData.subResName1, RegionData.TESTREGION, resourceTypeDataCreation.subRtName);
			login.logOut();
			
			Result = "PASS";
	
	}


	@Test (dependsOnMethods={"HappyDay107722"},groups = {"HappyDay", "Setting Up Resources","Resource Search", "HappyDay107724"})
	public void HappyDay107724() throws Exception {
 
		TCID = "107724";
		TC_DESCRIPTION = "Verify that user with any of the affiliated right on the parent resource can search for sub resources"
				+ " from the 'Find Resources' screen.";
		
		String srs=subResourceName[0];
		subRs=srs.substring(0, 5);


		login.loginAsUser(usersNames[0], UsersData.PASSWORD);
		shared.clickOnSearchInToolBar();
		view.verifyTwoSubResourceShouldBeRetrivedWhileSearch(resourceName[0],subRs,subResourceName[0],subResourceName[1], RegionData.TESTREGION, subResourceTypeName);
		login.logOut();
		
		login.loginAsUser(usersNames[1], UsersData.PASSWORD);
		shared.clickOnSearchInToolBar();
		view.verifyTwoSubResourceShouldBeRetrivedWhileSearch(resourceName[0],subRs,subResourceName[0],subResourceName[1], RegionData.TESTREGION, subResourceTypeName);
		login.logOut();
		
		login.loginAsUser(usersNames[2], UsersData.PASSWORD);
		shared.clickOnSearchInToolBar();
		view.verifyTwoSubResourceShouldBeRetrivedWhileSearch(resourceName[0],subRs,subResourceName[0],subResourceName[1], RegionData.TESTREGION, subResourceTypeName);
		login.logOut();
		
		login.loginAsUser(usersNames[3], UsersData.PASSWORD);
		shared.clickOnSearchInToolBar();
		view.verifyTwoSubResourceShouldBeRetrivedWhileSearch(resourceName[0],subRs,subResourceName[0],subResourceName[1], RegionData.TESTREGION, subResourceTypeName);
		login.logOut();
		
		login.loginAsUser(usersNames[4], UsersData.PASSWORD);
		shared.clickOnSearchInToolBar();
		view.verifyResourceShouldBeRetrivedWhileSearch(resourceName[0],subRs,subResourceName[0],subResourceName[1], RegionData.TESTREGION, subResourceTypeName);
		login.logOut();
		
		Result = "PASS";
	
	}
}