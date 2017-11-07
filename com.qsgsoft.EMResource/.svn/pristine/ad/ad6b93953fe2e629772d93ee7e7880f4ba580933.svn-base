package DatabaseRefresh_DataCreation.Smoke;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import EMR.data.FormsData;
import EMR.data.FormsData.FormsCreateData;
import EMR.data.FormsData.FormsTags;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ViewData;
import EMR.data.RegionData.RegionCreateData;
import EMR.data.ResourceData;
import EMR.data.ResourceData.ResourceTags;
import EMR.data.RolesData;
import EMR.data.UsersData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusTypeData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.UsersData.UsersTags;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.ActivateForms;
import EMR.pages.FormConfiguration;
import EMR.pages.FormTemplateDesigner;
import EMR.pages.Login;
import EMR.pages.RolesList;
import EMR.pages.Shared;
import EMR.pages.RegionDefault;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.SelectRegion;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.ViewsUnderSetup;

public class PreconditionForForms extends Configuration {
	
	LoginData loginData;
	RolesData rolesData;
	RolesCreateData rolesDataCreation;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	ResourceData resourceData;
	ResourceCreateData resourceDataCreation;
	UsersData usersData;
	UsersCreateData usersDataCreation;
	FormsData formData;
	FormsCreateData formsDataCreation;
	RegionData regionData;
	RegionCreateData regionDataCreation;
	ViewData viewData;
	ViewCreateData viewDataCreation;
	
	Login login;
	SelectRegion selectRegion;
	RegionDefault regionDefault;
	Shared navigateTo;
	RolesList rolesList;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;	
	Resources resources;
	UsersList usersList;	
	FormConfiguration formConfiguration;
	FormTemplateDesigner formTemplateDesigner;
	ActivateForms activateForms;
	ViewsUnderSetup viewUnderSetup;
	
	public PreconditionForForms() throws Exception {
		super();
	}
	
	@Test
	public void PreCondition_186279() throws Exception {
		
		TCID = "186279";
	    TC_DESCRIPTION = "Precondition for forms.";
	    
		login= new Login(driver);
		selectRegion= new SelectRegion(driver);
		rolesData = new RolesData();
		rolesDataCreation = rolesData.new RolesCreateData();
		regionDefault= new RegionDefault(driver);
		resourceTypes = new ResourceTypes(driver);
		resources = new Resources(driver);
		statusTypes = new StatusTypes(driver);
		usersList= new UsersList(driver);
		rolesList = new RolesList(this.driver);
		activateForms= new ActivateForms(driver);
		formConfiguration=new FormConfiguration(driver);
		navigateTo = new Shared(driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		formTemplateDesigner= new FormTemplateDesigner(driver);
		
		loginData    = new  LoginData(); 
		statusTypeData = new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData = new ResourceTypeData();
		resourceTypeDataCreation = resourceTypeData.new ResourceTypeCreateData();
		resourceData = new ResourceData();
		resourceDataCreation = resourceData.new ResourceCreateData();
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		formData = new FormsData();
		formsDataCreation = formData.new FormsCreateData();
	    viewData = new ViewData();
	    viewDataCreation = viewData.new ViewCreateData();
		
		String statusTypeValue[] = new String[1];
		
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		
		navigateTo.viewUnderSetup();
	    viewUnderSetup.createNewSection(viewDataCreation.section);
	    
		navigateTo.statusTypes();
		statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.nstName,	statusTypeDataCreation.description, viewDataCreation.section);
		statusTypeValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.nstName);
		
		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, statusTypeValue);
		
		navigateTo.resources();
		resources.createResource(resourceDataCreation.name, resourceDataCreation.abbrevation, resourceTypeDataCreation.name, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME);
		
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsAndEMailPager(usersDataCreation.name, UsersData.INITIAL_PASSWORD,
				usersDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID, rolesData.roleValue1)
				.provideUserMayCreateAndModifyFormsAndUserMayActivateFormsRight()
		        .createUserWithMandatoryDetailsAndEMailPager(usersDataCreation.name1, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName1, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
		        .createUserWithMandatoryDetailsAndEMailPager(usersDataCreation.name2, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName2, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
				 
		navigateTo.configureForm();		
		formConfiguration.clickOnCreateNewFormTemplate()
				         .enterTitleAndDescription(formsDataCreation.name, formsDataCreation.description)
				         .createFormWithInitiateAndOtherToFillOutAndUsersToUsersAndResources(
				        		 FormsData.USERINITIATEANDOTHERTOFILLOUT,
				        		 FormsData.USERTOUSERSANDRESOURCES, usersDataCreation.name1,
				        		 resourceDataCreation.name, usersDataCreation.name)
				         .clickOnQuestionnaire(formsDataCreation.name);

		String mainWindowHandle = driver.getWindowHandle();		
		formTemplateDesigner.switchToFormTemplateWindow(mainWindowHandle)		                   
							.enterGroupFieldSet(formsDataCreation.group, formsDataCreation.fieldSet)
							.addQuestionnaire(formsDataCreation.fieldSet, FormsData.QUESTIONNAIRETYPENUMERIC, formsDataCreation.labelName)
							.addQuestionnaire(formsDataCreation.fieldSet, FormsData.QUESTIONNAIRETYPETEXT, formsDataCreation.labelName1)
							.addQuestionnaire(formsDataCreation.fieldSet, FormsData.QUESTIONNAIRETYPETEXTAREA, formsDataCreation.labelName2)							
							.publishAndCloseTemplateDesignerWindow()
							.switchToMainWindow(mainWindowHandle);		

		login.selectFrame();
		login.logOut();
		         
		login.loginAsNewUser(usersDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
		     .logOut();
		
		login.loginAsNewUser(usersDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
		     .logOut();
		
		login.loginAsNewUser(usersDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
		     .logOut();			
		
		usersDataCreation.writeUsersDataToXml(usersDataCreation.name, UsersTags.USER_TO_ACTIVATE_FORM);
		usersDataCreation.writeUsersDataToXml(usersDataCreation.name1, UsersTags.USER_TO_FILLOUT_FORM);
		usersDataCreation.writeUsersDataToXml(usersDataCreation.name2, UsersTags.USER_TO_RECEIVE_COMPLETED_FORM);
		usersDataCreation.writeUsersDataToXml(usersDataCreation.fullName, UsersTags.USERFULLNAME_TO_ACTIVATE_FORM);
		usersDataCreation.writeUsersDataToXml(usersDataCreation.fullName1, UsersTags.USERFULLNAME_TO_FILLOUT_FORM);
		usersDataCreation.writeUsersDataToXml(usersDataCreation.fullName2, UsersTags.USERFULLNAME_TO_RECEIVE_COMPLETED_FORM);
		resourceDataCreation.writeResourceDataToXml(resourceDataCreation.name, ResourceTags.FORM_RESOURCE_NAME);
		formsDataCreation.writeFormsDataToXml(formsDataCreation.name, FormsTags.EXISTINGFORMNAME);
		formsDataCreation.writeFormsDataToXml(formsDataCreation.description, FormsTags.EXISTINGFORMDESCRIPTION);
		formsDataCreation.writeFormsDataToXml(formsDataCreation.group, FormsTags.FORMGROUP);
		formsDataCreation.writeFormsDataToXml(formsDataCreation.fieldSet, FormsTags.FORMFIELDSET);
		formsDataCreation.writeFormsDataToXml(formsDataCreation.labelName, FormsTags.FORMLABELNAME);
		formsDataCreation.writeFormsDataToXml(formsDataCreation.labelName1, FormsTags.FORMLABELNAME1);
		formsDataCreation.writeFormsDataToXml(formsDataCreation.labelName2, FormsTags.FORMLABELNAME2);
		
		Result = "PASS";
	}
}