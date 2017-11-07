package RequirementGroups.ViewingAndManagingEMResourceEntitiesOnTheViewInterface;

import java.util.ArrayList;
import java.util.Arrays;
import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.Login;
import EMR.pages.RegionDefault;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewResourceDetail;
import EMR.pages.ViewsUnderSetup;

public class SettingUpOfRegionViews extends Configuration {

	public SettingUpOfRegionViews() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginData loginData;
	UsersData usersData;
	UsersCreateData usersDataCreation;
	RegionData regionData;
	ResourceTypeData resourceTypeData;
	ResourceData resourceData;
	StatusTypeData statusTypeData;
	ViewData viewsData;
	ViewCreateData viewsDataCreation;

	Login login;
	RegionDefault regionDefault;
	Shared navigateTo;
	SelectRegion selectRegion;
	UsersList usersList;
	ViewsUnderSetup views;
	View viewsList;
	ViewResourceDetail viewResourceDetail;
	ViewData viewData;
	
	static String VIEW_NAME, USER_1, COPIED_VIEW_NAME;
	
	@Test(groups = {"HappyDay", "Viewing And Managing EMResource Entities On The 'View' Interface", "HappyDay69805"})
	public void HappyDay69805() throws Exception {
		
	    TCID = "69805";
	    TC_DESCRIPTION = " Verify that a view can be edited from the view screen.";
		
	    resourceTypeData 	= new ResourceTypeData();
	    resourceData 		= new ResourceData();
	    statusTypeData		= new StatusTypeData();
	    viewsData			= new ViewData();
	    viewsDataCreation	= viewsData.new ViewCreateData();
	    usersData			= new UsersData();
	    usersDataCreation	= usersData.new UsersCreateData();
	    
	    usersList = new UsersList(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	    regionDefault = new RegionDefault(this.driver);
	    login = new Login(this.driver);
	    navigateTo = new Shared(this.driver);
	    views = new ViewsUnderSetup(this.driver);
	    viewsList = new View(this.driver);
	
	    ArrayList<String> StatusTypeNames_1 = new ArrayList<String>();
	    StatusTypeNames_1.addAll(Arrays.asList(statusTypeData.roleBasedNumberStatusType,
									statusTypeData.roleBasedMultiStatusType,
									statusTypeData.roleBasedNedocsStatusType,
									statusTypeData.roleBasedSaturationStatusType));
	    
	    ArrayList<String> StatusTypeNames_2 = new ArrayList<String>();
	    StatusTypeNames_2.addAll(Arrays.asList(statusTypeData.roleBasedTextStatusType));
	    
	    String username		= usersDataCreation.name,
			   userFullName = usersDataCreation.fullName,
			   resourceName = resourceData.preferenceResourceName;
	    USER_1 = username;
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .selectViewResourceCheckBox(resourceName)
				 .provideConfigureRegionViewsRightAndSave();
		navigateTo.viewUnderSetup();
		views.createView(viewsDataCreation.name, ViewData.DESCRIPTION, resourceName, StatusTypeNames_1);
		navigateTo.particularView(viewsDataCreation.name)
		  		  .verifyViewName(viewsDataCreation.name);
		viewsList.verifyResourceTypeResourceAndStatusType(resourceTypeData.preferanceResourceType, resourceName, StatusTypeNames_1);
		login.logOut()
			 .loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		
		navigateTo.particularView(viewsDataCreation.name)
				  .verifyViewName(viewsDataCreation.name)
				  .editViewFromCustomizeLink();
		
		views.enterViewName(viewsDataCreation.editedName)
			 .clickOnNext()
			 .selectRegionName(RegionData.REGIONNAME)
			 .clickOnNext()
			 .selectResource(resourceName)
			 .clickOnNext()
			 .selectStatusType(StatusTypeNames_2)
			 .clickOnSave();
		VIEW_NAME = viewsDataCreation.editedName;
		navigateTo.verifyViewName(viewsDataCreation.editedName);
		
		viewsList.verifyResourceTypeResourceAndStatusType(resourceTypeData.preferanceResourceType, resourceName, StatusTypeNames_1)
				 .verifyResourceTypeResourceAndStatusType(resourceTypeData.preferanceResourceType, resourceName, StatusTypeNames_2);
		
		login.logOut();
		
		Result = "PASS";
	}
	
	@Test(dependsOnMethods = {"HappyDay69805"}, groups = {"HappyDay", "Viewing And Managing EMResource Entities On The 'View' Interface", "HappyDay69810"})
	public void HappyDay69810() throws Exception {
		
	    TCID = "69810";
	    TC_DESCRIPTION = "Verify that status types can be added/removed from a view.";
		
	    resourceTypeData 	= new ResourceTypeData();
	    resourceData 		= new ResourceData();
	    statusTypeData		= new StatusTypeData();
	    viewsData			= new ViewData();
	    viewsDataCreation	= viewsData.new ViewCreateData();
	    
	    login = new Login(this.driver);
	    navigateTo = new Shared(this.driver);
	    views = new ViewsUnderSetup(this.driver);
	    viewsList = new View(this.driver);
	
	    ArrayList<String> statusTypeRemove = new ArrayList<String>();
	    statusTypeRemove.addAll(Arrays.asList(statusTypeData.roleBasedNumberStatusType,
									statusTypeData.roleBasedMultiStatusType));
	    
	    ArrayList<String> statusTypeAdd = new ArrayList<String>();
	    statusTypeAdd.addAll(Arrays.asList(statusTypeData.roleBasedTextStatusType,
						statusTypeData.roleBasedDateStatusType));
	    
	    ArrayList<String> StatusTypeNames_2 = new ArrayList<String>();
	    StatusTypeNames_2.addAll(Arrays.asList(statusTypeData.roleBasedTextStatusType,
									statusTypeData.roleBasedNedocsStatusType,
									statusTypeData.roleBasedSaturationStatusType,
									statusTypeData.roleBasedDateStatusType));
	    
	    String resourceName = resourceData.preferenceResourceName;

		login.loginAsUser(USER_1, UsersData.PASSWORD);
		
		navigateTo.viewUnderSetup();
		
		views.clickOnEdit(VIEW_NAME)
			 .enterViewName(viewsDataCreation.name2)
			 .clickOnStatusTypeSection()
			 .deSelectStatusType(statusTypeRemove)
			 .selectStatusType(statusTypeAdd)
			 .clickOnSave()
			 .verifyViewInList(viewsDataCreation.name2);
		
		VIEW_NAME = viewsDataCreation.name2;
		
		navigateTo.particularView(VIEW_NAME)
				  .verifyViewName(VIEW_NAME);
		
		viewsList.verifyResourceTypeResourceAndStatusType(resourceTypeData.preferanceResourceType, resourceName, StatusTypeNames_2);
		
		login.logOut();
		
		Result = "PASS";
	}
	
	@Test(dependsOnMethods = {"HappyDay69810"}, groups = {"HappyDay", "Viewing And Managing EMResource Entities On The 'View' Interface", "HappyDay69809"})
	public void HappyDay69809() throws Exception {
		
	    TCID = "69809";
	    TC_DESCRIPTION = "Verify that resources can be added/removed from a view.";
		
	    resourceTypeData 	= new ResourceTypeData();
	    resourceData 		= new ResourceData();
	    statusTypeData		= new StatusTypeData();
	    viewsData			= new ViewData();
	    viewsDataCreation	= viewsData.new ViewCreateData();
	    
	    login = new Login(this.driver);
	    navigateTo = new Shared(this.driver);
	    views = new ViewsUnderSetup(this.driver);
	    viewsList = new View(this.driver);

	    ArrayList<String> StatusTypeNames = new ArrayList<String>();
	    StatusTypeNames.addAll(Arrays.asList(statusTypeData.roleBasedTextStatusType,
									statusTypeData.roleBasedNedocsStatusType,
									statusTypeData.roleBasedSaturationStatusType,
	    							statusTypeData.roleBasedDateStatusType));
	    
	    String resourceName_1 = resourceData.preferenceResourceName,
	    	   resourceName_2 = resourceData.roleBasedResourceName;

		login.loginAsUser(USER_1, UsersData.PASSWORD);
		
		navigateTo.viewUnderSetup();
		
		views.clickOnEdit(VIEW_NAME)
			 .enterViewName(viewsDataCreation.name3)
			 .clickOnResourcesSection()
			 .deSelectResource(resourceName_1)
			 .selectResource(resourceName_2)
			 .clickOnStatusTypeSection()
			 .selectStatusType(StatusTypeNames)
			 .clickOnSave()
			 .verifyViewInList(viewsDataCreation.name3);
		
		VIEW_NAME = viewsDataCreation.name3;
		
		navigateTo.particularView(VIEW_NAME)
				  .verifyViewName(VIEW_NAME);
		
		viewsList.verifyResourceTypeResourceAndStatusType(resourceTypeData.preferanceResourceType, resourceName_2, StatusTypeNames)
				 .verifyResourceTypeAndResourceNotDisplayed(resourceTypeData.preferanceResourceType, resourceName_1);
		
		login.logOut();
		
		Result = "PASS";
	}
	
	@Test(dependsOnMethods = { "HappyDay69809" }, groups = {"HappyDay", "Viewing And Managing EMResource Entities On The 'View' Interface", "HappyDay186191"})
	public void HappyDay186191() throws Exception {
		
	    TCID = "186191";
	    TC_DESCRIPTION = "Verify that users can be assigned to access region views.";
		
	    resourceTypeData 	= new ResourceTypeData();
	    resourceData 		= new ResourceData();
	    statusTypeData		= new StatusTypeData();
	    viewsData			= new ViewData();
	    viewsDataCreation	= viewsData.new ViewCreateData();
	    usersData			= new UsersData();
	    usersDataCreation	= usersData.new UsersCreateData();
	    
	    usersList = new UsersList(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	    regionDefault = new RegionDefault(this.driver);
	    login = new Login(this.driver);
	    navigateTo = new Shared(this.driver);
	    views = new ViewsUnderSetup(this.driver);
	    viewsList = new View(this.driver);
	    
	    String resourceName = resourceData.roleBasedResourceName,
	    	   username2	= usersDataCreation.name1,
			   userFullName2= usersDataCreation.fullName1,
			   username3	= usersDataCreation.name2,
			   userFullName3= usersDataCreation.fullName2;
	    
	    ArrayList<String> StatusTypeNames = new ArrayList<String>();
	    StatusTypeNames.addAll(Arrays.asList(statusTypeData.roleBasedTextStatusType,
									statusTypeData.roleBasedNedocsStatusType,
									statusTypeData.roleBasedSaturationStatusType,
	    							statusTypeData.roleBasedDateStatusType));
	    
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username2, UsersData.INITIAL_PASSWORD, userFullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .selectViewResourceCheckBox(resourceName)
				 .clickOnSave()
				 .createUserWithMandatoryDetailsWithRoleWithoutSave(username3, UsersData.INITIAL_PASSWORD, userFullName3, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .selectViewResourceCheckBox(resourceName)
				 .clickOnSave();
		
		login.logOut()
			 .loginAsUser(USER_1, UsersData.PASSWORD);
		
		navigateTo.viewUnderSetup();
		views.clickOnEdit(VIEW_NAME)
			 .provideAccessToViewForUser(USER_1)
			 .provideAccessToViewForUserAndSave(username2)
			 .verifyViewInList(VIEW_NAME);
		login.logOut()
		.loginAsNewUser(username2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.particularView(VIEW_NAME);
		viewsList.verifyResourceTypeResourceAndStatusType(resourceTypeData.preferanceResourceType, resourceName, StatusTypeNames);
		login.logOut()
			 .loginAsNewUser(username3, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.verifySubMenuIsNotPresent(VIEW_NAME)
				  .clickOnView();
		viewsList.verifyViewIsNotPresentUnderViewsList(VIEW_NAME);
		login.logOut();
		
		Result = "PASS";
	}
	
	@Test(dependsOnMethods = { "HappyDay69809" }, groups = {"HappyDay", "Viewing And Managing EMResource Entities On The 'View' Interface", "Copy Region View", "HappyDay69824"})
	public void HappyDay69824() throws Exception {
		
	    TCID = "69824";
	    TC_DESCRIPTION = "Verify that a View can be created by copying from an existing View.";
		
	    resourceData 		= new ResourceData();
	    statusTypeData		= new StatusTypeData();
	    viewsData			= new ViewData();
	    viewsDataCreation	= viewsData.new ViewCreateData();

	    login = new Login(this.driver);
	    navigateTo = new Shared(this.driver);
	    views = new ViewsUnderSetup(this.driver);
	    viewsList = new View(this.driver);

	    ArrayList<String> StatusTypeNames = new ArrayList<String>();
	    StatusTypeNames.addAll(Arrays.asList(statusTypeData.roleBasedTextStatusType,
									statusTypeData.roleBasedNedocsStatusType,
									statusTypeData.roleBasedSaturationStatusType,
	    							statusTypeData.roleBasedDateStatusType));
	    
	    String resourceName = resourceData.roleBasedResourceName;
	    
	    login.loginAsUser(USER_1, UsersData.PASSWORD);
	    navigateTo.viewUnderSetup();
	    views.clickOnCopyOfView(VIEW_NAME)
	    	.enterViewName(viewsDataCreation.name4)
	    	.clickOnRegionsSection()
	    	.verifyRegionIsSelected(RegionData.REGIONNAME)
	    	.clickOnResourcesSection()
	    	.verifyResourceIsSelected(resourceName)
	    	.clickOnStatusTypeSection()
	    	.verifyStatusTypesAreSelected(StatusTypeNames)
	    	.clickOnSave();
	    COPIED_VIEW_NAME = viewsDataCreation.name4;
	    views.verifyViewInList(COPIED_VIEW_NAME);
	    
	    login.logOut();
	    
		Result = "PASS";
	}
	
	@Test(dependsOnMethods = { "HappyDay69809" }, groups = {"HappyDay", "Viewing And Managing EMResource Entities On The 'View' Interface", "Delete Region View", "HappyDay69869"})
	public void HappyDay69869() throws Exception {

		TCID = "69869";
		TC_DESCRIPTION = "Verify that a region view can be deleted.";

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		views = new ViewsUnderSetup(this.driver);

		login.loginAsUser(USER_1, UsersData.PASSWORD);
		navigateTo.viewUnderSetup();

		views.deleteView(COPIED_VIEW_NAME)
			 .verifyViewIsNotPresentInViewList(COPIED_VIEW_NAME);

		login.logOut();

		Result = "PASS";
	}
}