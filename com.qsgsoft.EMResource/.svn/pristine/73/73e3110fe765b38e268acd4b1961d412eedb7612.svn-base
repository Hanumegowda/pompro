package RequirementGroups.Smoke;

import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration_Mails;
import EMR.data.FormsData;
import EMR.data.FormsData.FormsTags;
import EMR.data.RegionData;
import EMR.data.UsersData;
import EMR.data.FormsData.FormsCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.LoginData;
import EMR.pages.ActivateForms;
import EMR.pages.BlankForm;
import EMR.pages.FormConfiguration;
import EMR.pages.FormTemplateDesigner;
import EMR.pages.Login;
import EMR.pages.Mails;
import EMR.pages.Shared;
import EMR.pages.RegionDefault;
import EMR.pages.SelectRegion;

public class CreatingAndManagingForms extends Configuration_Mails {

	public CreatingAndManagingForms() throws Exception {
		super();
	}
	
	LoginData loginData;
	FormsData formsData;
	FormsCreateData formsDataCreation;
	UsersData usersData;
	UsersCreateData usersDataCreation;
	
	Login login;
	SelectRegion selectRegion;	
	RegionDefault regionDefault;
	Shared navigationTo;
	FormConfiguration formConfiguration;
	FormTemplateDesigner formTemplateDesigner;
	ActivateForms activateForms;
	BlankForm blankForm;	
	Mails mails;
	
	static String FORM_NAME, DESCRIPTION, GROUP, FIELDSET, LABELNAME, LABELNAME1, LABELNAME2;
	static String  CHOICE;
		
	@Test(groups = {"Smoke", "Forms", "Smoke186197" })
	public void Smoke186197() throws Exception {
		
		TCID = "186197";
	    TC_DESCRIPTION = "Verify that form can be created.";
	    
	    login = new Login(this.driver);
		formConfiguration = new FormConfiguration(this.driver);
		formTemplateDesigner = new FormTemplateDesigner(this.driver);
		
		formsData = new FormsData();
		formsDataCreation = formsData.new FormsCreateData();
		usersData = new UsersData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);		
		navigationTo = new Shared(this.driver);
		
		loginData = new LoginData();
		formsData = new FormsData();

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigationTo.configureForm();
		
		formConfiguration.clickOnCreateNewFormTemplate()
				         .enterTitleAndDescription(formsDataCreation.name, formsDataCreation.description)
				         .createFormWithInitiateAndOtherToFillOutAndIndividualUsers(FormsData.USERINITIATEANDOTHERTOFILLOUT, FormsData.USERTOINDIVIDUALUSERS, usersData.userToFillOut,
						                                                            usersData.userToActivateForm) 
		                 .clickOnQuestionnaire(formsDataCreation.name);

		String mainWindowHandle = driver.getWindowHandle();

		formTemplateDesigner.switchToFormTemplateWindow(mainWindowHandle)
				            .enterGroupFieldSet(formsDataCreation.group, formsDataCreation.fieldSet)
				            .addQuestionnaire(formsDataCreation.fieldSet, FormsData.QUESTIONNAIRETYPENUMERIC, formsDataCreation.labelName)
				            .addQuestionnaire(formsDataCreation.fieldSet, FormsData.QUESTIONNAIRETYPETEXT,
						                      formsDataCreation.labelName1)
				            .addQuestionnaireCheckBox(formsDataCreation.fieldSet, FormsData.QUESTIONNAIRETYPECHECKBOX, formsDataCreation.labelName2,
						                              formsDataCreation.choiceName)
				            .publishAndCloseTemplateDesignerWindow()
				            .switchToMainWindow(mainWindowHandle);
		login.logOut();

		FORM_NAME   = formsDataCreation.name;
		DESCRIPTION = formsDataCreation.description;
		GROUP 		= formsDataCreation.group;
		FIELDSET 	= formsDataCreation.fieldSet;
		LABELNAME 	= formsDataCreation.labelName;
		LABELNAME1 	= formsDataCreation.labelName1;
		LABELNAME2 	= formsDataCreation.labelName2;
		CHOICE 		= formsDataCreation.choiceName;
		
		Result = "PASS";
	}
	
	@Test(dependsOnMethods= {"Smoke186197"}, groups = {"Smoke", "Forms", "Smoke186195" })
	public void Smoke186195() throws Exception {
		
		TCID = "186195";
	    TC_DESCRIPTION = "Verify that user with appropriate right can activate and fill the form.";
		
		login = new Login(this.driver);
		navigationTo = new Shared(this.driver);
		activateForms = new ActivateForms(this.driver);
		regionDefault = new RegionDefault(this.driver);
		formConfiguration = new FormConfiguration(this.driver);
		mails = new Mails(this.driver1);
		blankForm = new BlankForm(this.driver);
				
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
				
		login.loginAsUser(usersData.userToActivateForm, UsersData.PASSWORD);
		navigationTo.activateForms();
		activateForms.selectUserToFillOutAndActivate(FORM_NAME, usersData.userToFillOut);
		login.logOut();
		
		login.loginAsUser(usersData.userToFillOut, UsersData.PASSWORD);
		String mainWindowHandle = driver.getWindowHandle();
		blankForm.switchToBlankFormWindow(mainWindowHandle)
				 .verifyTitleGroupField(FORM_NAME, GROUP, FIELDSET)
				 .enterAnswerInNumericOrTextField(LABELNAME, FormsData.NUMERICANSWER)
				 .enterAnswerInNumericOrTextField(LABELNAME1, FormsData.TEXTANSWER)
				 .enterAnswerInCheckBox(CHOICE)
				 .clickOnSave()
				 .clickOnSubmit()
				 .selectUserToReceiveCompletedForm(usersData.userToReceiveCompletedForm)
				 .clickOnDispatchForm(mainWindowHandle);		
		login.logOut();
		
		login.loginAsUser(usersData.userToReceiveCompletedForm, UsersData.PASSWORD);	
		String message1 = regionDefault.getWebNotificationForThreeQuestionnaire(usersData.userFullnameToFillOutForm, RegionData.REGIONNAME,	
																				LABELNAME, FormsData.NUMERICANSWER,
																				LABELNAME1, FormsData.TEXTANSWER,
																				LABELNAME2, CHOICE);
		regionDefault.verifyWebNotificationframe();
		formConfiguration.verifyWebNotificationMessageForForms(FORM_NAME, message1);
		regionDefault.acknowledgeAllForms();
		login.selectFrame()
		     .logOut();
		
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);	
		mails.verifyMailAndPagerNotificationsForFormWithThreeQuestionnaire(usersData.userFullnameToFillOutForm,
                RegionData.REGIONNAME, FORM_NAME, LABELNAME, FormsData.NUMERICANSWER, LABELNAME1, FormsData.TEXTANSWER, LABELNAME2, CHOICE, UsersData.PRIMARY_EMAILID)
		     .logoutMail();

		Result = "PASS";
	}
	
	@Test(dependsOnMethods= {"Smoke186195"}, groups = {"Smoke", "forms", "Smoke186196" })
	public void Smoke186196() throws Exception {

		TCID = "186196";
	    TC_DESCRIPTION = "Verify that user with appropriate right can edit a form";

	    login = new Login(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	    navigationTo = new Shared(this.driver);
	    formConfiguration = new FormConfiguration(this.driver);
	    activateForms = new ActivateForms(this.driver);
	    blankForm = new BlankForm(this.driver);
	    regionDefault = new RegionDefault(this.driver);
	    mails = new Mails(this.driver1);
	    
	    usersData = new UsersData();
	    formsData = new FormsData();
		formsDataCreation = formsData.new FormsCreateData();
	    
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigationTo.configureForm();

		formConfiguration.verifyFormTitleAndDescription(FORM_NAME, DESCRIPTION)
				         .editFormTitleAndDescription(FORM_NAME, formsDataCreation.editName,
						                              formsDataCreation.editDescription);				
		login.logOut();
		
		login.loginAsUser(usersData.userToActivateForm, UsersData.PASSWORD);
		navigationTo.activateForms();
		activateForms.selectUserToFillOutAndActivate(formsDataCreation.editName, usersData.userToFillOut);
		login.logOut();
		
		login.loginAsUser(usersData.userToFillOut, UsersData.PASSWORD);
		String mainWindowHandle = driver.getWindowHandle();
		blankForm.switchToBlankFormWindow(mainWindowHandle)
				 .verifyTitleGroupField(formsDataCreation.editName, GROUP, FIELDSET)
				 .enterAnswerInNumericOrTextField(LABELNAME, FormsData.NUMERICANSWER)
				 .enterAnswerInNumericOrTextField(LABELNAME1, FormsData.TEXTANSWER)
				 .enterAnswerInCheckBox(CHOICE)
				 .clickOnSave()
				 .clickOnSubmit()
				 .selectUserToReceiveCompletedForm(usersData.userToReceiveCompletedForm)
				 .clickOnDispatchForm(mainWindowHandle);
		login.logOut();
		
		login.loginAsUser(usersData.userToReceiveCompletedForm, UsersData.PASSWORD)
		     .selectFrame();	
		String message1 = regionDefault.getWebNotificationForThreeQuestionnaire(usersData.userFullnameToFillOutForm, RegionData.REGIONNAME,	LABELNAME,
                                                                                FormsData.NUMERICANSWER,LABELNAME1, FormsData.TEXTANSWER,LABELNAME2, CHOICE);
		regionDefault.verifyWebNotificationframe();
		formConfiguration.verifyWebNotificationMessageForForms(formsDataCreation.editName, message1);
		regionDefault.acknowledgeAllForms();
		login.selectFrame()
		     .logOut();
		
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);	
		mails.verifyMailAndPagerNotificationsForFormWithThreeQuestionnaire(usersData.userFullnameToFillOutForm,
                RegionData.REGIONNAME, formsDataCreation.editName, LABELNAME, FormsData.NUMERICANSWER, LABELNAME1, FormsData.TEXTANSWER, LABELNAME2, CHOICE, UsersData.PRIMARY_EMAILID)
		     .logoutMail();

		Result = "PASS";
	}

	@Test(groups = {"Smoke", "forms", "Smoke187097" }, priority = 1)	
	public void Smoke187097() throws Exception {

		TCID = "187097";
	    TC_DESCRIPTION = "Verify that old form can be edited.";
		
	    login = new Login(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	    navigationTo = new Shared(this.driver);
	    formConfiguration = new FormConfiguration(this.driver);
	    activateForms = new ActivateForms(this.driver);
	    blankForm = new BlankForm(this.driver);
	    regionDefault = new RegionDefault(this.driver);
	    mails = new Mails(this.driver1);
	    
	    usersData = new UsersData();
	    formsData = new FormsData();
		formsDataCreation = formsData.new FormsCreateData();
	    
	    login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigationTo.configureForm();

		formConfiguration.verifyFormTitleAndDescription(formsData.oldFormName, formsData.oldFormDescription)
				         .editFormTitleDescriptionActivationAndCompletedFormDelivery(formsData.oldFormName, formsDataCreation.editName, formsDataCreation.editDescription,
						                                                             FormsData.INITIATEANDFILLOUTHIMORHERSELF, FormsData.USERTOINDIVIDUALUSERS, usersData.userToReceiveCompletedForm );
		login.logOut();
		
		formsDataCreation.writeFormsDataToXml(formsDataCreation.editName, FormsTags.EXISTINGFORMNAME);
		formsDataCreation.writeFormsDataToXml(formsDataCreation.editDescription, FormsTags.EXISTINGFORMDESCRIPTION);
		
		login.loginAsUser(usersData.userToActivateForm, UsersData.PASSWORD);
		navigationTo.activateForms();
		activateForms.clickOnFillForm(formsDataCreation.editName);		
		
		String mainWindowHandle = driver.getWindowHandle();
		
		blankForm.switchToBlankFormWindow(mainWindowHandle)
				 .verifyTitleGroupField(formsDataCreation.editName, formsData.formGroup, formsData.formFieldset)
				 .enterAnswerInNumericOrTextField(formsData.formLabelName, FormsData.NUMERICANSWER)
				 .enterAnswerInNumericOrTextField(formsData.formLabelName1, FormsData.TEXTANSWER)
				 .enterAnswerInTextAreaField(formsData.formLabelName2, FormsData.MULTITEXTANSWER)
				 .clickOnSave()
				 .clickOnSubmit()
				 .selectUserToReceiveCompletedForm(usersData.userToReceiveCompletedForm)
				 .clickOnDispatchForm(mainWindowHandle);
		login.logOut();
		
		login.loginAsUser(usersData.userToReceiveCompletedForm, UsersData.PASSWORD)
		     .selectFrame();	
		String message1 = regionDefault.getWebNotificationForThreeQuestionnaire(usersData.userFullnameToActivateForm, RegionData.REGIONNAME, formsData.formLabelName, FormsData.NUMERICANSWER, formsData.formLabelName1, FormsData.TEXTANSWER, formsData.formLabelName2, FormsData.MULTITEXTANSWER);
		regionDefault.verifyWebNotificationframe();
		formConfiguration.verifyWebNotificationMessageForForms(formsDataCreation.editName, message1);
		regionDefault.acknowledgeAllForms();
		login.switchToDefaultWindow()
		     .selectFrame()
		     .logOut();
		
		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);	
		mails.verifyMailAndPagerNotificationsForFormWithThreeQuestionnaire(usersData.userFullnameToActivateForm,
                RegionData.REGIONNAME, formsDataCreation.editName, formsData.formLabelName, FormsData.NUMERICANSWER, formsData.formLabelName1, FormsData.TEXTANSWER, formsData.formLabelName2, FormsData.MULTITEXTANSWER, UsersData.PRIMARY_EMAILID)
		     .logoutMail();

		Result = "PASS";		
	}
}