package requirementGroup.Forms;

import static org.testng.Assert.assertTrue;



import java.util.Iterator;
import java.util.Set;

import lib.dataObject.BlankFormData;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.ActivateForms;
import lib.page.BlankForm;
import lib.page.DispatchForm;
import lib.page.EventManagement;
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayEditV3FormQuestionnaire extends TestNG_UI_EXTENSIONS{

	public HappyDayEditV3FormQuestionnaire() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that user with 'Form - User may create and modify forms' right can
	               update a form questionnaire of type 'Single line Text'.
	'Precondition:
	'Date	 	 : 19-Dec-2014
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user with 'Form - User may create and modify forms' right"
			+ " can update a form questionnaire of type 'Single line Text'.")
	public void testHappyDay151898() throws Exception {

		gstrTCID = "151898";
		gstrTO = "Verify that user with 'Form - User may create and modify forms' right can update"
				+ " a form questionnaire of type 'Single line Text'.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);


		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
						.selectFirstRole()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		
		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();
		
		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();
		
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
		
			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);
		
			}
		}
		
		Thread.sleep(5000);
		
		objFormConfiguration.verTemplateDesignPage()
						    .clickOnInsert()
						    .clickOnGroupLink()
						    .verifyEditGroupOrTable()
						    .enterNewGroupName(objFormConfiguration_data.strGroupName)
						    .clickOnGroupDoneButton()
						    .clickOnAddButton(objFormConfiguration_data.strGroupName)
						    .clickOnFieldSet(objFormConfiguration_data.strGroupName)
						    .verifyEditFieldSetWindow()
						    .enterAttributesLabelName(objFormConfiguration_data.strAttributeName)
						    .clickOnEditFieldDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strText)
						    .enterLabelName(objFormConfiguration_data.strLabelName1)
						    .clickOnAddToSummary()
						    .enterMinimumLength(objFormConfiguration_data.strMinimumvalue)
						    .enterMaximumLength(objFormConfiguration_data.strMaximumvalue)
						    .clickOnDoneButton()				    
						    .clickOnSaveButton();
		
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);
		
		driver.close();
		
		driver.switchTo().window(mainWindowHandle);
		
		objRegionDefault.selectFrame();
		
		objLogin.clickLogOut();
		
		System.out.println("-----------------Execution started---------------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration1
		.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle2 = driver1.getWindowHandle();

		Thread.sleep(5000);
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		
		objFormConfiguration1
		        .clickOnEditQuestionnaire(objFormConfiguration_data.strLabelName1)
				.enterMinimumLength(objFormConfiguration_data.strMinimumvalue1)
				.enterMaximumLength(objFormConfiguration_data.strMaximumvalue1)
				.clickOnDoneButton()
				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();
		
		//Activate Form

		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1.clickOnFillForm(objFormConfiguration_data.strFormName);
		Thread.sleep(5000);
		String mainWindowHandle1 = driver1.getWindowHandle();
		
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();
		
		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();
		
			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);
		
			}
		}

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,objBlankFormData.strSinglelineTextAnswer)
					.clickOnSave();

		Thread.sleep(5000);
		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
							objUserdata.strNewUserName1)
					   .clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that 'Numeric' question can be added to the V3 form. 
	'Date	 	 : 15-Dec-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user with 'Form - User may create and modify forms' right can update a form questionnaire of type 'Numeric'. ")
	public void testHappyDay151900() throws Exception {

		gstrTCID = "151900";
		gstrTO = "Verify that user with 'Form - User may create and modify forms' right can update a form questionnaire of type 'Numeric'. ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration.verTemplateDesignPage()
						    .clickOnInsert()
						    .clickOnGroupLink()
						    .verifyEditGroupOrTable()
						    .enterNewGroupName(objFormConfiguration_data.strGroupName)
						    .clickOnGroupDoneButton()
						    .clickOnAddButton(objFormConfiguration_data.strGroupName)
						    .clickOnFieldSet(objFormConfiguration_data.strGroupName)
						    .verifyEditFieldSetWindow()
						    .enterAttributesLabelName(objFormConfiguration_data.strAttributeName)
						    .clickOnEditFieldDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()
						    .selectQuestionType(objFormConfiguration_data.strNumeric)
						    .enterLabelName(objFormConfiguration_data.strLabelName)
						    .clickOnDoneButton()
						    .clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);

		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName)
				.selectNumberType(objFormConfiguration_data.strPercentage)
				.clickOnDoneButton()

				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		String mainWindowHandle1 = driver1.getWindowHandle();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInNumericFieldForPercentage(objFormConfiguration_data.strLabelName,
								objBlankFormData.strNumericAnswer1)
				.clickOnSave();

		Thread.sleep(5000);
		objBlankForm.clickOnComplete();

		Thread.sleep(5000);
		
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName1
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//				+ ": " + objBlankFormData.strNumericAnswer;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName1,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame();

		gstrResult = "PASS";
	}
	/***********************************************************************************
	'Description : Verify that user with 'Form - User may create and modify forms' right 
	                can update a form questionnaire of type 'Multi Line Text'. 
	'Date	 	 : 26-Dec-2014
	'Author		 : Anitha
	'-----------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************/
	@Test(description = "Verify that user with 'Form - User may create and modify forms' right"
			+ " can update a form questionnaire of type 'Multi Line Text'. ")
	public void testHappyDay151899() throws Exception {

		gstrTCID = "151899";
		gstrTO = "Verify that user with 'Form - User may create and modify forms' right can"
				+ " update a form questionnaire of type 'Multi Line Text'. ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration
				.verTemplateDesignPage()
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName)
				.clickOnEditFieldDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strTextArea)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary()
				.enterMinimumLength(objFormConfiguration_data.strMinimumvalue)
				.enterMaximumLength(objFormConfiguration_data.strMaximumvalue)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		System.out.println("-----------------Execution started---------------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.enterMinimumLength(
						objFormConfiguration_data.strMinimumvalue1)
				.enterMaximumLength(
						objFormConfiguration_data.strMaximumvalue1)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		// Activate Form

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle1 = driver1.getWindowHandle();

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerForMultiLineText(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strMultiLineTextAnswer)
						.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut()
		
		         .loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName1
//				+ ": " + objBlankFormData.strMultiLineTextAnswer;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strMultiLineTextAnswer);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms()
				.selectFrame();
		
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that user with 'Form - User may create and modify forms' right can update a form questionnaire of type 'Checkbox'.
	'Date	 	 : 15-Dec-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user with 'Form - User may create and modify forms' right can update a form questionnaire of type 'Checkbox'.")
	public void testHappyDay151901() throws Exception {

		gstrTCID = "151901";
		gstrTO = "Verify that user with 'Form - User may create and modify forms' right can update a form questionnaire of type 'Checkbox'.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration.verTemplateDesignPage()
						    .clickOnInsert()
						    .clickOnGroupLink()
						    .verifyEditGroupOrTable()
						    .enterNewGroupName(objFormConfiguration_data.strGroupName)
						    .clickOnGroupDoneButton()
						    .clickOnAddButton(objFormConfiguration_data.strGroupName)
						    .clickOnFieldSet(objFormConfiguration_data.strGroupName)
						    .verifyEditFieldSetWindow()
						    .enterAttributesLabelName(objFormConfiguration_data.strAttributeName)
						    .clickOnEditFieldDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()
						    .selectQuestionType(objFormConfiguration_data.strCheckBox)
						    .enterLabelName(objFormConfiguration_data.strLabelName)
						    .addChoices(objFormConfiguration_data.strChoice)
						    .addNthChoice(objFormConfiguration_data.strSecChoice,objFormConfiguration_data.strChoice2)
						    .clickOnDoneButton()
						    .clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(10000);
		Thread.sleep(5000);

		String mainWindowHandle2 = driver1.getWindowHandle();

		
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName)
							 .addNthChoice(objFormConfiguration_data.strThirdChoice,
									 	   objFormConfiguration_data.strChoice3)
							 .addNthChoice(objFormConfiguration_data.strFourthChoice,
									 	   objFormConfiguration_data.strChoice4)
				.clickOnDoneButton()

				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		String mainWindowHandle1 = driver1.getWindowHandle();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.verifyChkBoxIsDisplayed(objFormConfiguration_data.strLabelName, objFormConfiguration_data.strChoice)
				.verifyChkBoxIsDisplayed(objFormConfiguration_data.strLabelName, objFormConfiguration_data.strChoice2)
				.verifyChkBoxIsDisplayed(objFormConfiguration_data.strLabelName, objFormConfiguration_data.strChoice4)
				.enterAnswerInChkBox(objFormConfiguration_data.strChoice2)
				.clickOnSave();

		Thread.sleep(5000);
		objBlankForm.clickOnComplete();

		Thread.sleep(5000);
		
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName1
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//				+ ": " + objFormConfiguration_data.strChoice2;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName1,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice2);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that user with 'Form - User may create and modify forms' right can 
						update a form questionnaire of type 'Radio button'.  
	'Date	 	 : 26-Dec-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user with 'Form - User may create and modify forms' right "
			+ "can update a form questionnaire of type 'Radio button'. ")
	public void testHappyDay151902() throws Exception {

		gstrTCID = "151902";
		gstrTO = "Verify that user with 'Form - User may create and modify forms' right can update a "
				+ "form questionnaire of type 'Radio button'. ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton().deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration
				.verTemplateDesignPage()
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName)
				.clickOnEditFieldDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strRadio)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.addChoices(objFormConfiguration_data.strChoice1)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice2)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		Thread.sleep(5000);

		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName)
				.addNthChoice(objFormConfiguration_data.strThirdChoice,
						objFormConfiguration_data.strChoice3)
				.addNthChoice(objFormConfiguration_data.strFourthChoice,
						objFormConfiguration_data.strChoice4)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);
		Thread.sleep(2000);
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		String mainWindowHandle1 = driver1.getWindowHandle();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);
		Thread.sleep(5000);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInRadioBtn(objFormConfiguration_data.strChoice1)
				.clickOnSave();

		Thread.sleep(5000);
		objBlankForm.clickOnComplete();

		Thread.sleep(5000);

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName1
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//				+ ": " + objFormConfiguration_data.strChoice1;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName1,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice1);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strChoice1);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strChoice1);

		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			} else if (blnMsg3 == false && blnMsg1 == true) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/************************************************************************************
	'Description :  Verify that user with 'Form - User may create and modify forms' right 
	                can update a form questionnaire of type 'Date'.
	'Date	 	 : 26-Dec-2014
	'Author		 : Anitha
	'-----------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************/
	@Test(description = " Verify that user with 'Form - User may create and modify forms' right can"
			+ " update a form questionnaire of type 'Date'. ")
	public void testHappyDay151908() throws Exception {

		gstrTCID = "151908";
		gstrTO = " Verify that user with 'Form - User may create and modify forms' right can update"
				+ " a form questionnaire of type 'Date'.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton().verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration
				.verTemplateDesignPage()
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName)
				.clickOnEditFieldDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strDateQuestion)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary()
				.clickOnAnyDatesAllowedRadioButton()
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		System.out.println("-----------------Execution started---------------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		
		Thread.sleep(5000);
		
		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.clickOnFutureDateIncludingToday()
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		
		String strApplicationTime = objEventManagement1.getApplicationTime();
		
		String  strCurrentYear = dts.getCurrentDate("yyyy");
	    
		strApplicationTime = strApplicationTime+" "+strCurrentYear;
			    
		strApplicationTime = dts.converDateFormat(strApplicationTime, "yyyy-MM-dd HHmm", "MM/dd/yyyy");
		
		String[] strdate=strApplicationTime.split(" "); 
		
		System.out.println(strdate[0]);

		// Activate Form

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle1 = driver1.getWindowHandle();

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInDateField(
						strdate[0])
						.clickOnSave();
		Thread.sleep(5000);
		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut()
		
		         .loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName1
//				+ ": " + strdate[0];
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName1,
						strdate[0]);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms()
				.selectFrame();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that user with 'Form - User may create and modify forms' right can 
					update a form questionnaire of type 'Multi Select'. 
	'Date	 	 : 26-Dec-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user with 'Form - User may create and modify forms' right "
			+ "can update a form questionnaire of type 'Multi Select'. ")
	public void testHappyDay151906() throws Exception {

		gstrTCID = "151906";
		gstrTO = "Verify that user with 'Form - User may create and modify forms' right can "
				+ "update a form questionnaire of type 'Multi Select'. ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton().deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration
				.verTemplateDesignPage()
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName)
				.clickOnEditFieldDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strMultiSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.addChoices(objFormConfiguration_data.strChoice1)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice2)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);

		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName)
				.addNthChoice(objFormConfiguration_data.strThirdChoice,
						objFormConfiguration_data.strChoice3)
				.addNthChoice(objFormConfiguration_data.strFourthChoice,
						objFormConfiguration_data.strChoice4)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);
		Thread.sleep(2000);
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		String mainWindowHandle1 = driver1.getWindowHandle();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInMultiSelectBox(objFormConfiguration_data.strChoice2)
				.clickOnSave();

		Thread.sleep(5000);
		objBlankForm.clickOnComplete();

		Thread.sleep(5000);

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName1
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//				+ ": " + objFormConfiguration_data.strChoice2;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName1,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice2);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strChoice2);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strChoice2);

		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			} else if (blnMsg3 == false && blnMsg1 == true) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that user with 'Form - User may create and modify forms' right
					can update a form questionnaire of type 'Single Select'.
	'Precondition:
	'Date	 	 : 26-Dec-2014
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user with 'Form - User may create and modify forms' right can update a form questionnaire of type 'Single Select'.")
	public void testHappyDay151904() throws Exception {

		gstrTCID = "151904";
		gstrTO = "Verify that user with 'Form - User may create and modify forms' right can update a form questionnaire of type 'Single Select'.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration.verTemplateDesignPage()
						    .clickOnInsert()
						    .clickOnGroupLink()
						    .verifyEditGroupOrTable()
						    .enterNewGroupName(objFormConfiguration_data.strGroupName)
						    .clickOnGroupDoneButton()
						    .clickOnAddButton(objFormConfiguration_data.strGroupName)
						    .clickOnFieldSet(objFormConfiguration_data.strGroupName)
						    .verifyEditFieldSetWindow()
						    .enterAttributesLabelName(objFormConfiguration_data.strAttributeName)
						    .clickOnEditFieldDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strSingleSelect)
						    .enterLabelName(objFormConfiguration_data.strLabelName)
					        .clickOnAddToSummary()
					        .addChoices(objFormConfiguration_data.strChoice1)
					        .addNthChoice(objFormConfiguration_data.strSecChoice,objFormConfiguration_data.strChoice2)
					        .clickOnDoneButton()
					        .clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.verFormConfigurePage()
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		
		Thread.sleep(7000);

		String mainWindowHandle1 = driver1.getWindowHandle();
		
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();
		
		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();
		
			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);
		
			}
		}
		
		objFormConfiguration1.verTemplateDesignPage()
					.clickOnEditQuestionnaire(
							objFormConfiguration_data.strLabelName)
					.addNthChoice(objFormConfiguration_data.strThirdChoice,
							objFormConfiguration_data.strChoice3)
					.addNthChoice(objFormConfiguration_data.strFourthChoice,
							objFormConfiguration_data.strChoice4)
					.clickOnDoneButton()
					.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.selectFrame();
		
		Thread.sleep(5000);
		
		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1
					.clickOnFillForm(objFormConfiguration_data.strFormName);
		Thread.sleep(5000);
		String mainWindowHandle2 = driver1.getWindowHandle();
		
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();
		
		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();
		
			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);
		
			}
		}
		
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.verifyChoiceIsDisplayedForSingleSelectQtn(objFormConfiguration_data.strLabelName,
															objFormConfiguration_data.strChoice1)
				    .verifyChoiceIsDisplayedForSingleSelectQtn(objFormConfiguration_data.strLabelName,
															objFormConfiguration_data.strChoice2)
				    .verifyChoiceIsDisplayedForSingleSelectQtn(objFormConfiguration_data.strLabelName,
															objFormConfiguration_data.strChoice3)
				    .verifyChoiceIsDisplayedForSingleSelectQtn(objFormConfiguration_data.strLabelName,
															objFormConfiguration_data.strChoice4)
					.selectSingleOption(objFormConfiguration_data.strChoice4)
					.clickOnSave();
		Thread.sleep(2000);
		objBlankForm.clickOnComplete();
		Thread.sleep(2000);
		
		objDispatchForm.selUserToReceiveCompletedForm(objUserdata.strNewUserName1)
					   .clickOnDispatchForm();
		
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objFormConfiguration_data.strChoice4;
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice4);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
						strMsg)
				.clickAcknowledgeAllForms()
				.selectFrame();
		
		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
	
		 
		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strChoice4);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strChoice4);

		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			} else if (blnMsg3 == false && blnMsg1 == true) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that user with 'Form - User may create and modify forms' right
				   can update a form questionnaire of type 'Table'.
	'Date	 	 : 29-Dec-2014
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user with 'Form - User may create and modify forms' right can update a form questionnaire of type 'Table'.")
	public void testHappyDay151897() throws Exception {

		gstrTCID = "151897";
		gstrTO = "Verify that user with 'Form - User may create and modify forms' right can update a form questionnaire of type 'Table'.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
                this.driver1);
		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickSaveButton().verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(10000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration.verTemplateDesignPage()
						    .clickOnInsert()
						    .clickOnTableLink()
                            .verifyEditFieldSetWindow()
                            .enterFirstRowLabel(objFormConfiguration_data.strRow1)
                            .enterSecondRowLabel(objFormConfiguration_data.strRow2)
                            .addFirstTableColumn(objFormConfiguration_data.strColumnName1,
                            					objFormConfiguration_data.strText)
                            .addNthTableColumn(objFormConfiguration_data.strColumnName2,
                            				  objFormConfiguration_data.strTextArea)
                            .addNthTableColumn(objFormConfiguration_data.strColumnName3,
                            				  objFormConfiguration_data.strNumeric)				  
       					    .clickOnEditFieldDoneButton()
       					    .clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.verFormConfigurePage()
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		
		Thread.sleep(7000);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1.clickOnEditTable()
							 .removeNthColumn(objFormConfiguration_data.strSecChoice)
							 .clickOnEditFieldDoneButton()
	       					 .clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		
		Thread.sleep(2000);
		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1
					.clickOnFillForm(objFormConfiguration_data.strFormName);
		Thread.sleep(5000);
		String mainWindowHandle2 = driver1.getWindowHandle();
		
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();
		
		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();
		
			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);
		
			}
		}
		
		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verRowDetailsForTextAndNumeric(
						objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer,
						objFormConfiguration_data.strNumeric,
						objBlankFormData.strTextAnswer)
				.verRowDetailsForTextAndNumeric(
						objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer,
						objFormConfiguration_data.strNumeric,
						objBlankFormData.strTextAnswer)
	.enterAnswerInFirstColumn(objFormConfiguration_data.strRow1,
			            					  objFormConfiguration_data.strText,
			            					  objBlankFormData.strTextAnswer)
			        .enterAnswerInFirstColumn(objFormConfiguration_data.strRow2,
			            					  objFormConfiguration_data.strText,
			            					  objBlankFormData.strTextAnswer1)
			        .enterAnswerInSecondColumn(objFormConfiguration_data.strRow1,
					   						   objBlankFormData.strNumericAnswer)
	            	.enterAnswerInSecondColumn(objFormConfiguration_data.strRow2,
					   						   objBlankFormData.strNumericAnswer3)
					.clickOnSave();
		Thread.sleep(5000);
		objBlankForm.clickOnComplete();
		Thread.sleep(5000);
		
		objDispatchForm.selUserToReceiveCompletedForm(
								objUserdata.strNewUserName1)
					   .clickOnDispatchForm();
		
		driver1.switchTo().window(mainWindowHandle2);
		
		objRegionDefault1.selectFrame();
		
        objLogin1.clickLogOut();

        objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
                       objUserdata.strNewPassword);
        
//        String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//        				+ objFormConfiguration_data.strRow1 + ":" + objFormConfiguration_data.strColumnName1
//        				+ ": " + objBlankFormData.strTextAnswer + "| "
//        				+ objFormConfiguration_data.strRow1 + ":" + objFormConfiguration_data.strColumnName2
//        				+ ": " + objBlankFormData.strTextAreaAnswer + "| "
//        				+ objFormConfiguration_data.strRow2 + ":" + objFormConfiguration_data.strColumnName1
//        				+ ": " + objBlankFormData.strTextAnswer1 + "| "
//        				+ objFormConfiguration_data.strRow2 + ":" + objFormConfiguration_data.strColumnName2
//        				+ ": " + objBlankFormData.strTextAreaAnswer1 + "";
        
		String strMsg = objRegionDefault1.getWebNotificationForTable(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strRow1,
				objFormConfiguration_data.strColumnName1,
				objBlankFormData.strTextAnswer,
				objFormConfiguration_data.strColumnName3,
				objBlankFormData.strNumericAnswer,
				objFormConfiguration_data.strRow2,
				objBlankFormData.strTextAnswer1,
				objBlankFormData.strNumericAnswer3);
		
        Thread.sleep(5000);
        
        objRegionDefault1
                       .selectFrame()
                       .verWebNotificationframe()
                       .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
                                     strMsg)
                       .clickAcknowledgeAllForms()
        			   .selectFrame();
        
        objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
                                                  objUserdata.strPrimaryPwsd);
        
        String strMsgBody = objMailVerificationFunctions.getFormMailBodyForTable(objUserdata.strFullName,
				objLogindata.strRegionName, objFormConfiguration_data.strRow1,
				objFormConfiguration_data.strRow2,
				objFormConfiguration_data.strColumnName1,
				objFormConfiguration_data.strColumnName3,
				objBlankFormData.strTextAnswer,
				objBlankFormData.strTextAnswer1,
				objBlankFormData.strNumericAnswer,
				objBlankFormData.strNumericAnswer3);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBodyForTable(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strColumnName3,
						objBlankFormData.strTextAnswer,
						objBlankFormData.strTextAnswer1,
						objBlankFormData.strNumericAnswer,
						objBlankFormData.strNumericAnswer3);

		String strSubject = objFormConfiguration_data.strFormName;
		
		objMailVerificationFunctions.NavToInbox(strSubject);
		
		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
		
		for (int intCount = 0; intCount < 3; intCount++) {
		
			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			} else if (blnMsg3 == false && blnMsg1 == true) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description : Verify that updated choices for 'Check box' questionnaire are not lost after second publish.
	 * 'Precondition:
	 * 'Date : 06-Mar-2015 
	 * 'Author : sangappa.k
	 * 
	 **************************************************************************************/

		@Test(description = "Verify that updated choices for 'Check box' questionnaire are not lost after second publish.")
		public void testEdgeCase152204 () throws Exception {

		gstrTCID = "152204";
		gstrTO = "Verify that updated choices for 'Check box' questionnaire are not lost after second publish.";
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		MailVerificationFunctions objMailverification=new MailVerificationFunctions(driver);
		

			objLogin.loginToApplication(objLogindata.strUserName,
					objLogindata.strPassword);

			objSelectRegionpage
					.selectRegionAndNavigate(objLogindata.strRegionName);

			objRegionDefault.selectFrame();

			objNavigationToSubmenus.navigateToUsers();
		
		//User A
			objUsersList
					.clickCreateNewUserButton()
					.enterAllUserDetails(objUserdata.strNewUserName1,
							objUserdata.strNewPassword, objUserdata.strFullName,
							objUserdata.strFirstName, objUserdata.strMiddleName,
							objUserdata.strLastName, objUserdata.strOrganization,
							objUserdata.strPhone, objUserdata.strPrimaryMailId,
							objUserdata.strPrimaryMailId,
							objUserdata.strPrimaryMailId).selectFirstRole()
					.clickAdvancedOptionAndExpand()
					.selectFormUserMayActivateFormsOption().clickSaveButton()
					.verifyUserListPageIsDisplayed();
			System.out.println(objUserdata.strNewUserName1);
			System.out.println(objUserdata.strNewPassword);
		
		//User B
			
			objUsersList
			.clickCreateNewUserButton()
			.enterAllUserDetails(objUserdata.strNewUserName2,
					objUserdata.strNewPassword, objUserdata.strFullName,
					objUserdata.strFirstName, objUserdata.strMiddleName,
					objUserdata.strLastName, objUserdata.strOrganization,
					objUserdata.strPhone, objUserdata.strPrimaryMailId,
					objUserdata.strPrimaryMailId,
					objUserdata.strPrimaryMailId).selectFirstRole()
			.clickAdvancedOptionAndExpand()
			.selectFormUserMayActivateFormsOption().clickSaveButton()
			.verifyUserListPageIsDisplayed();
	System.out.println(objUserdata.strNewUserName2);
			
	  //User C
			
			objUsersList
			.clickCreateNewUserButton()
			.enterAllUserDetails(objUserdata.strNewUserName3,
					objUserdata.strNewPassword, objUserdata.strFullName,
					objUserdata.strFirstName, objUserdata.strMiddleName,
					objUserdata.strLastName, objUserdata.strOrganization,
					objUserdata.strPhone, objUserdata.strPrimaryMailId,
					objUserdata.strPrimaryMailId,
					objUserdata.strPrimaryMailId).selectFirstRole()
			.clickAdvancedOptionAndExpand()
			.selectFormUserMayActivateFormsOption().clickSaveButton()
			.verifyUserListPageIsDisplayed();
			 System.out.println(objUserdata.strNewUserName3);
			 		 
			 
		objNavigationToSubmenus.clickOnConfigureForm();
		objFormConfiguration
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName2,
						objFormConfiguration_data.strDiscriptiveName)
				.selectFormActivation(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selectCompletedFormDelivery(
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
                .selUserInUsersToFillOutForm(objUserdata.strNewUserName2)
				.clickOnNextUsersToFillOutForm();
Thread.sleep(2000);
		objFormConfiguration
				.clickOnNextInResourcesToFillFormPage()
				.verFormSecurityPage(objFormConfiguration_data.strFormName2)
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
				.selectRunReportChkBoxInSecurityPge(objUserdata.strNewUserName2)
				.clickOnSaveOfFormSecuritySetting().verFormConfigurePage()
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName2);

		Thread.sleep(5000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> str = driver.getWindowHandles();
		Iterator<String> itr = str.iterator();
		String strPopUp2 = "";
		while (itr.hasNext()) {
			String popUpWindow = itr.next().toString();
			strPopUp2 = popUpWindow;
			if (!popUpWindow.contains(mainWindowHandle)) {
				driver.switchTo().window(popUpWindow);
				driver.manage().window().maximize();
			}
		}

		objFormConfiguration.verTemplateDesignPage();
		Thread.sleep(10000);
		Thread.sleep(10000);
		objFormConfiguration
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName1)
				.clickOnGroupDoneButton()

				.clickOnAddButton(objFormConfiguration_data.strGroupName1)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName1)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName1)
				.clickOnEditFieldDoneButton()
                .clickOnInsertElement(
						objFormConfiguration_data.strAttributeName1)
                 .selectQuestionType(objFormConfiguration_data.strCheckBox)
                 .enterLabelName(objFormConfiguration_data.strLabelName1)
                 .addChoices(objFormConfiguration_data.strChoice)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice1)
				.clickOnDoneButton().clickOnSaveButton();
	     	Thread.sleep(5000);
		         objFormConfiguration.clickOnPublishButton();
		    Thread.sleep(5000);

		objFormConfiguration
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice)
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice1)
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice2)
				.clickOnDoneButton().clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);
			
	   objFormConfiguration.verifyAddedSecQueChoiceIsDis(
				objFormConfiguration_data.strLabelName1,
				objFormConfiguration_data.strChoice2);

		   driver.close();
	       driver.switchTo().window(mainWindowHandle);
	       objRegionDefault.selectFrame();
	       objLogin.clickLogOut();
	       
    objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		objRegionDefault1.selectFrame();
		Thread.sleep(10000);

		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName2)
				.selUserToFillOutForm(objUserdata.strNewUserName2)
				.clickOnActivateForm();
		objLogin1.clickLogOut();
		
			
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName2)
				.verGroupName(objFormConfiguration_data.strGroupName1)
				.verFieldSetName(objFormConfiguration_data.strAttributeName1)
				.enterAnswerInChkBox(objFormConfiguration_data.strChoice)
				.enterAnswerInChkBox(objFormConfiguration_data.strChoice1)
				.enterAnswerInChkBox(objFormConfiguration_data.strChoice2)
				.clickOnSave();
		Thread.sleep(5000);
		objBlankForm.clickOnComplete();
		Thread.sleep(6000);
		objDispatchForm
				.selUserToReceiveCompletedForm(objUserdata.strNewUserName3);

		Thread.sleep(6000);
		objDispatchForm.clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);
		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName3,
				objUserdata.strNewPassword);
		objRegionDefault.selectFrame();
		Thread.sleep(10000);

		String webContent = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName1
				+ ": " + objFormConfiguration_data.strChoice + ","
				+ objFormConfiguration_data.strChoice2 + ","
				+ objFormConfiguration_data.strChoice1;

		Thread.sleep(5000);

		objRegionDefault
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName2, webContent);

		objRegionDefault.clickAcknowledgeAllForms().switchToDefaultFrame()
				.selectFrame();

		Thread.sleep(5000);
		objLogin.clickLogOut();

		objMailverification.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
	
		 
		String strMsgBody = objMailverification.getFormMailBodyForChoices(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName1,objFormConfiguration_data.strChoice,
				objFormConfiguration_data.strChoice2,objFormConfiguration_data.strChoice1);

		String strMsgBody1 = objMailverification.getFormPagerBodyForChoices(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName1,objFormConfiguration_data.strChoice,
				objFormConfiguration_data.strChoice2,objFormConfiguration_data.strChoice1);
		
		System.out.println("Msg passed "+ strMsgBody);
		System.out.println("Msg1 passed "+ strMsgBody1);
  
		String strSubject = objFormConfiguration_data.strFormName2;

		objMailverification.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailverification.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailverification.verifyMailBody(strMsgBody);
			} else if (blnMsg3 == false && blnMsg1 == true) {
				blnMsg3 = objMailverification.verifyMailBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailverification.verifyMailBody(strMsgBody1);
			}

			objMailverification.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailverification.logoutMail();
		
		gstrResult = "PASS";
  
	}

		/*************************************************************************************
		'Description :  Verify that 'Check box' question of an new form questionnaire can be edited.
		'Date	 	 : 15-Dec-2014
		'Author		 : Anil
		'---------------------------------------------------------------
		'Modified Date			                        	Modified By
		'Date					                            Name
		**************************************************************************************/
		@Test(description = "Verify that 'Check box' question of an new form questionnaire can be edited.")
		public void testHappyDay69425() throws Exception {

			gstrTCID = "69425";
			gstrTO = " Verify that 'Check box' question of an new form questionnaire can be edited.";

			Login objLogin = new Login(this.driver1);
			Login_data objLogindata = new Login_data();
			FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
			User_data objUserdata = new User_data();
			SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
			UsersList objUsersList = new UsersList(this.driver1);
			RegionDefault objRegionDefault = new RegionDefault(this.driver1);
			NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
					this.driver1);
			FormConfiguration objFormConfiguration = new FormConfiguration(
					this.driver1);

			Login objLogin1 = new Login(this.driver1);
			RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
			NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
					this.driver1);
			ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
			BlankForm objBlankForm = new BlankForm(this.driver1);
			DispatchForm objDispatchForm = new DispatchForm(this.driver1);
			FormConfiguration objFormConfiguration1 = new FormConfiguration(
					this.driver1);
			MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
					this.driver1);
			SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
			
			objLogin.loginToApplication(objLogindata.strUserName,
					objLogindata.strPassword);

			objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

			objRegionDefault.selectFrame();

			objNavigationToSubmenus.navigateToUsers();

			objUsersList
					.clickCreateNewUserButton()
					.enterAllUserDetails(objUserdata.strNewUserName,
							objUserdata.strNewPassword, objUserdata.strFullName,
							objUserdata.strFirstName, objUserdata.strMiddleName,
							objUserdata.strLastName, objUserdata.strOrganization,
							objUserdata.strPhone, objUserdata.strPrimaryMailId,
							objUserdata.strPrimaryMailId,
							objUserdata.strPrimaryMailId).selectFirstRole()
					.clickSaveButton()
					.verifyUserListPageIsDisplayed();

			objUsersList
					.clickCreateNewUserButton()
					.enterUserMandatoryDetails(objUserdata.strNewUserName1,
							objUserdata.strNewPassword, objUserdata.strFullName1)
					.selectFirstRole()
					.clickAdvancedOptionAndExpand()
					.selectFormUserMayActivateFormsOption()
					.selectFormUserMayActivateAndModifyFormsOption()
					.clickSaveButton().verifyUserListPageIsDisplayed();

			System.out.println(objUserdata.strNewUserName);
			System.out.println(objUserdata.strNewUserName1);

			objNavigationToSubmenus.clickOnConfigureForm();

			objFormConfiguration
					.verFormConfigurePage()
					.createNewFormTempltete()
					.entireTittleName_DescriptionName(
							objFormConfiguration_data.strFormName,
							objFormConfiguration_data.strDiscriptiveName)
					.selectOptionInFormActivationDropDown(
							objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
					.selCompletedFormDelivery(
							objFormConfiguration_data.strComptdFormDelvry)
					.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
					.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
					.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
					.clickOnNextButton()
					.deSelectAllUsersCheckBox()
					.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
					.clickOnNextButton()
					.selUserInFormSecuritySetting(objUserdata.strNewUserName1)
					.clickOnSaveOfFormSecuritySetting();

			System.out.println(objFormConfiguration_data.strFormName);

			objFormConfiguration
					.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

			String mainWindowHandle = driver.getWindowHandle();

			Set<String> a = driver.getWindowHandles();
			Iterator<String> ite = a.iterator();

			while (ite.hasNext()) {
				String popupHandle = ite.next().toString();

				if (!popupHandle.contains(mainWindowHandle)) {
					driver.switchTo().window(popupHandle);

				}
			}

			objFormConfiguration.verTemplateDesignPage()
							    .clickOnInsert()
							    .clickOnGroupLink()
							    .verifyEditGroupOrTable()
							    .enterNewGroupName(objFormConfiguration_data.strGroupName)
							    .clickOnGroupDoneButton()
							    .clickOnAddButton(objFormConfiguration_data.strGroupName)
							    .clickOnFieldSet(objFormConfiguration_data.strGroupName)
							    .verifyEditFieldSetWindow()
							    .enterAttributesLabelName(objFormConfiguration_data.strAttributeName)
							    .clickOnEditFieldDoneButton()
							    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
							    .verifyEditQuestionWindow()
							    .selectQuestionType(objFormConfiguration_data.strCheckBox)
							    .enterLabelName(objFormConfiguration_data.strLabelName)
							    .addChoices(objFormConfiguration_data.strChoice)
							    .addNthChoice(objFormConfiguration_data.strSecChoice,objFormConfiguration_data.strChoice2)
							    .clickOnDoneButton()
							    .clickOnSaveButton();

			System.out.println("started");
			Thread.sleep(5000);
			System.out.println("ended");
			objFormConfiguration.clickOnPublishButton();
			Thread.sleep(5000);

			driver.close();

			driver.switchTo().window(mainWindowHandle);

			objRegionDefault.selectFrame();

			objLogin.clickLogOut();

			objLogin1.loginToApplication(objLogindata.strUserName,
					objLogindata.strPassword);

			objRegionDefault1.selectFrame();
			
			objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

			objRegionDefault1.selectFrame();

			objNavigationToSubmenus1.clickOnConfigureForm();

			objFormConfiguration1
					.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

			Thread.sleep(10000);

			String mainWindowHandle2 = driver1.getWindowHandle();

			
			Set<String> a2 = driver1.getWindowHandles();
			Iterator<String> ite2 = a2.iterator();

			while (ite2.hasNext()) {
				String popupHandle = ite2.next().toString();

				if (!popupHandle.contains(mainWindowHandle2)) {
					driver1.switchTo().window(popupHandle);

				}
			}

			objFormConfiguration1
					.clickOnEditQuestionnaire(
							objFormConfiguration_data.strLabelName)
								 .addNthChoice(objFormConfiguration_data.strThirdChoice,
										 	   objFormConfiguration_data.strChoice3)
								 .addNthChoice(objFormConfiguration_data.strFourthChoice,
										 	   objFormConfiguration_data.strChoice4)
					.clickOnDoneButton()

					.clickOnSaveButton()
					.verifyAddedChoices(objFormConfiguration_data.strChoice4)
					.verifyAddedChoices(objFormConfiguration_data.strChoice3)
					.verifyAddedChoices(objFormConfiguration_data.strChoice2)
					.verifyAddedChoices(objFormConfiguration_data.strChoice);
			
			System.out.println("started");
			Thread.sleep(5000);
			System.out.println("ended");
			objFormConfiguration1.clickOnPublishButton();
			Thread.sleep(5000);

			driver1.close();

			driver1.switchTo().window(mainWindowHandle2);

			objRegionDefault1.selectFrame();
			
			objLogin1.clickLogOut();
					
			objLogin1.loginAsNewUser(objUserdata.strNewUserName1, objUserdata.strNewPassword);
			
			objRegionDefault1.selectFrame();

			objNavigationToSubmenus1.navigateToActivateForm();
			String mainWindowHandle1 = driver1.getWindowHandle();

			objActivateForms1
					.clickOnFillForm(objFormConfiguration_data.strFormName);

			Thread.sleep(10000);
			
			Set<String> a1 = driver1.getWindowHandles();
			Iterator<String> ite1 = a1.iterator();

			while (ite1.hasNext()) {
				String popupHandle = ite1.next().toString();

				if (!popupHandle.contains(mainWindowHandle1)) {
					driver1.switchTo().window(popupHandle);

				}
			}
			objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.verifyChkBoxIsDisplayed(objFormConfiguration_data.strLabelName, objFormConfiguration_data.strChoice)
					.verifyChkBoxIsDisplayed(objFormConfiguration_data.strLabelName, objFormConfiguration_data.strChoice2)
					.verifyChkBoxIsDisplayed(objFormConfiguration_data.strLabelName, objFormConfiguration_data.strChoice3)
					.verifyChkBoxIsDisplayed(objFormConfiguration_data.strLabelName, objFormConfiguration_data.strChoice4)
					.enterAnswerInChkBox(objFormConfiguration_data.strChoice2)
					.clickOnSave();

			Thread.sleep(5000);
			objBlankForm.clickOnComplete();

			Thread.sleep(5000);
			
			objDispatchForm.selUserToReceiveCompletedForm(
					objUserdata.strNewUserName).clickOnDispatchForm();

			driver1.switchTo().window(mainWindowHandle1);

			objRegionDefault1.selectFrame();
			objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName,
					objUserdata.strNewPassword);

//			String strMsg = "Submitted by " + objUserdata.strFullName1
//					+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//					+ ": " + objFormConfiguration_data.strChoice2;

			String strMsg = objRegionDefault1
					.getWebNotificationForOneQuestionnaire(objUserdata.strFullName1,
							objLogindata.strRegionName,
							objFormConfiguration_data.strLabelName,
							objFormConfiguration_data.strChoice2);
			
			objRegionDefault1
					.selectFrame()
					.verWebNotificationframe()
					.verWebNotificationMsgForForms(
							objFormConfiguration_data.strFormName, strMsg)
					.clickAcknowledgeAllForms().selectFrame();
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			objRegionDefault1.selectFrame();
			objLogin1.clickLogOut();
			
			
			objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
					objUserdata.strPrimaryPwsd);
		
			 
			String strMsgBody = objMailVerificationFunctions.getFormMailBody(
					objUserdata.strFullName1, objLogindata.strRegionName,
					objFormConfiguration_data.strLabelName,
					objFormConfiguration_data.strChoice2);

			String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
					objUserdata.strFullName1, objLogindata.strRegionName,
					objFormConfiguration_data.strLabelName,
					objFormConfiguration_data.strChoice2);

			String strSubject = objFormConfiguration_data.strFormName;

			objMailVerificationFunctions.NavToInbox(strSubject);

			boolean blnMsg1 = false;
			boolean blnMsg2 = false;
			boolean blnMsg3 = false;

			for (int intCount = 0; intCount < 3; intCount++) {

				objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
						strSubject);

				if (blnMsg1 == false) {
					blnMsg1 = objMailVerificationFunctions
							.verifyMailBody(strMsgBody);
				} else if (blnMsg3 == false && blnMsg1 == true) {
					blnMsg3 = objMailVerificationFunctions
							.verifyMailBody(strMsgBody);
				}

				if (blnMsg2 == false) {
					blnMsg2 = objMailVerificationFunctions
							.verifyMailBody(strMsgBody1);
				}

				objMailVerificationFunctions.backToMailInbox();
			}
			assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

			objMailVerificationFunctions.logoutMail();
			
			gstrResult = "PASS";
		}

		/*************************************************************************************
		'Description : Verify that 'Numeric' question of an new form questionnaire can be edited.
		'Date	 	 : 18-Mar-2015
		'Author		 : Renushree
		'---------------------------------------------------------------
		'Modified Date			                        	Modified By
		'Date					                            Name
		**************************************************************************************/
		@Test( description = "Verify that 'Numeric' question of an new form questionnaire can be edited.")
		public void testHappyDay69384() throws Exception {

			gstrTCID = "69384";
			gstrTO = "Verify that 'Numeric' question of an new form questionnaire can be edited.";

			Login objLogin = new Login(this.driver1);
			Login_data objLogindata = new Login_data();
			BlankFormData objBlankFormData = new BlankFormData();
			FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
			User_data objUserdata = new User_data();
			SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
			UsersList objUsersList = new UsersList(this.driver1);
			RegionDefault objRegionDefault = new RegionDefault(this.driver1);
			NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
					this.driver1);
			FormConfiguration objFormConfiguration = new FormConfiguration(
					this.driver1);

			Login objLogin1 = new Login(this.driver1);
			RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
			NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
					this.driver1);
			ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
			BlankForm objBlankForm = new BlankForm(this.driver1);
			DispatchForm objDispatchForm = new DispatchForm(this.driver1);
			FormConfiguration objFormConfiguration1 = new FormConfiguration(
					this.driver1);
			 MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
	                 driver1);
			 SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
			objLogin.loginToApplication(objLogindata.strUserName,
					objLogindata.strPassword);

			objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

			objRegionDefault.selectFrame();

			objNavigationToSubmenus.navigateToUsers();

			objUsersList
					.clickCreateNewUserButton()
					.enterAllUserDetails(objUserdata.strNewUserName,
							objUserdata.strNewPassword, objUserdata.strFullName,
							objUserdata.strFirstName, objUserdata.strMiddleName,
							objUserdata.strLastName, objUserdata.strOrganization,
							objUserdata.strPhone, objUserdata.strPrimaryMailId,
							objUserdata.strPrimaryMailId,
							objUserdata.strPrimaryMailId).selectFirstRole()
					.clickSaveButton().verifyUserListPageIsDisplayed();

			objUsersList
					.clickCreateNewUserButton()
					.enterAllUserDetails(objUserdata.strNewUserName1,
							objUserdata.strNewPassword, objUserdata.strFullName1,
							objUserdata.strFirstName, objUserdata.strMiddleName,
							objUserdata.strLastName, objUserdata.strOrganization,
							objUserdata.strPhone, objUserdata.strPrimaryMailId,
							objUserdata.strPrimaryMailId,
							objUserdata.strPrimaryMailId).selectFirstRole()
					.clickAdvancedOptionAndExpand()
					.selectFormUserMayActivateFormsOption()
					.selectFormUserMayActivateAndModifyFormsOption()
					.clickSaveButton().verifyUserListPageIsDisplayed();

			System.out.println(objUserdata.strNewUserName);
			System.out.println(objUserdata.strNewUserName1);

			objNavigationToSubmenus.clickOnConfigureForm();

			objFormConfiguration
					.verFormConfigurePage()
					.createNewFormTempltete()
					.entireTittleName_DescriptionName(
							objFormConfiguration_data.strFormName,
							objFormConfiguration_data.strDiscriptiveName)
					.selectOptionInFormActivationDropDown(
							objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
					.selCompletedFormDelivery(
							objFormConfiguration_data.strComptdFormDelvry)
					.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
					.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
					.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
					.clickOnNextButton()
					.deSelectAllUsersCheckBox()
					.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
					.clickOnNextButton()
					.selUserInFormSecuritySetting(objUserdata.strNewUserName1)
					.clickOnSaveOfFormSecuritySetting();

			System.out.println(objFormConfiguration_data.strFormName);

			objFormConfiguration
					.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

			Thread.sleep(5000);
			String mainWindowHandle = driver.getWindowHandle();

			Set<String> a = driver.getWindowHandles();
			Iterator<String> ite = a.iterator();

			while (ite.hasNext()) {
				String popupHandle = ite.next().toString();

				if (!popupHandle.contains(mainWindowHandle)) {
					driver.switchTo().window(popupHandle);

				}
			}

			objFormConfiguration.verTemplateDesignPage()
							    .clickOnInsert()
							    .clickOnGroupLink()
							    .verifyEditGroupOrTable()
							    .enterNewGroupName(objFormConfiguration_data.strGroupName)
							    .clickOnGroupDoneButton()
							    .clickOnAddButton(objFormConfiguration_data.strGroupName)
							    .clickOnFieldSet(objFormConfiguration_data.strGroupName)
							    .verifyEditFieldSetWindow()
							    .enterAttributesLabelName(objFormConfiguration_data.strAttributeName)
							    .clickOnEditFieldDoneButton()
							    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
							    .verifyEditQuestionWindow()
							    .selectQuestionType(objFormConfiguration_data.strNumeric)
							    .enterLabelName(objFormConfiguration_data.strLabelName)
							    .clickOnDoneButton()
							    .clickOnSaveButton();

			System.out.println("started");
			Thread.sleep(5000);
			System.out.println("ended");
			objFormConfiguration.clickOnPublishButton();
			Thread.sleep(5000);

			driver.close();

			driver.switchTo().window(mainWindowHandle);

			objRegionDefault.selectFrame();

			objLogin.clickLogOut();

			objLogin1.loginToApplication(objLogindata.strUserName,
					objLogindata.strPassword);
			objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);
			objRegionDefault1.selectFrame();
			
			objNavigationToSubmenus1.clickOnConfigureForm();

			objFormConfiguration1
					.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

			Thread.sleep(5000);

			String mainWindowHandle2 = driver1.getWindowHandle();

			Set<String> a2 = driver1.getWindowHandles();
			Iterator<String> ite2 = a2.iterator();

			while (ite2.hasNext()) {
				String popupHandle = ite2.next().toString();

				if (!popupHandle.contains(mainWindowHandle2)) {
					driver1.switchTo().window(popupHandle);

				}
			}

			objFormConfiguration1
					.clickOnEditQuestionnaire(
							objFormConfiguration_data.strLabelName)
					.enterLabelName(objFormConfiguration_data.strEditedLabelName)
					.selectNumberType(objFormConfiguration_data.strPercentage)
					.clickOnDoneButton()
					.clickOnSaveButton();

			System.out.println("started");
			Thread.sleep(5000);
			System.out.println("ended");
			objFormConfiguration1.clickOnPublishButton();
								 /*.verifyPreviewButtonIsDisplayed()
								 .clickPreviewButton();*/
			
			driver1.close();

			driver1.switchTo().window(mainWindowHandle2);
			
			/*String mainWindowHandle3 = driver1.getWindowHandle();
			Set<String> a3 = driver1.getWindowHandles();
			Iterator<String> ite3 = a3.iterator();

			while (ite3.hasNext()) {
				String popupHandle = ite3.next().toString();

				if (!popupHandle.contains(mainWindowHandle3)) {
					driver1.switchTo().window(popupHandle);
				}
			}

			System.out.println("mainWindowHandle3 : " +mainWindowHandle3);
			objFormConfiguration1
					.verifyFormTitle(objFormConfiguration_data.strFormName);

			objBlankForm
					.verGroupName(objFormConfiguration_data.strGroupName);
			
			objFormConfiguration1
					.verifyNumericOrSingleLineTextQuestionIsDisabled(objFormConfiguration_data.strEditedLabelName)
					.verifyInsertLinkNotDisplayed()
					.verifyAddButtonForGroupIsNotDisplayed(objFormConfiguration_data.strGroupName);*/
			
			objRegionDefault1.selectFrame();

			objLogin1.clickLogOut();
			
			objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
					objUserdata.strNewPassword);

			objRegionDefault1.selectFrame();

			objNavigationToSubmenus1.navigateToActivateForm();
			String mainWindowHandle1 = driver1.getWindowHandle();

			objActivateForms1
					.clickOnFillForm(objFormConfiguration_data.strFormName);

			Thread.sleep(5000);
			Set<String> a1 = driver1.getWindowHandles();
			Iterator<String> ite1 = a1.iterator();

			while (ite1.hasNext()) {
				String popupHandle = ite1.next().toString();

				if (!popupHandle.contains(mainWindowHandle1)) {
					driver1.switchTo().window(popupHandle);

				}
			}
			objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInNumericFieldForPercentage(objFormConfiguration_data.strEditedLabelName,
									objBlankFormData.strNumericAnswer1)
					.clickOnSave();

			Thread.sleep(5000);
			objBlankForm.clickOnComplete();

			Thread.sleep(5000);
			
			objDispatchForm.selUserToReceiveCompletedForm(
					objUserdata.strNewUserName).clickOnDispatchForm();

			driver1.switchTo().window(mainWindowHandle1);

			objRegionDefault1.selectFrame();
			objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName,
					objUserdata.strNewPassword);

//			String strMsg = "Submitted by " + objUserdata.strFullName1
//					+ "\nSummary: | " + objFormConfiguration_data.strEditedLabelName
//					+ ": " + objBlankFormData.strNumericAnswer1;

			String strMsg = objRegionDefault1
					.getWebNotificationForOneQuestionnaire(objUserdata.strFullName1,
							objLogindata.strRegionName,
							objFormConfiguration_data.strEditedLabelName,
							objBlankFormData.strNumericAnswer1);
			
			objRegionDefault1
					.selectFrame()
					.verWebNotificationframe()
					.verWebNotificationMsgForForms(
							objFormConfiguration_data.strFormName, strMsg)
					.clickAcknowledgeAllForms().switchToDefaultFrame().selectFrame();
			
			objLogin1.clickLogOut();
			
			 String strMsgBody = objMailVerificationFunctions.getFormMailBody(
	                 objUserdata.strFullName1, objLogindata.strRegionName,
	                 objFormConfiguration_data.strEditedLabelName,
	                 objBlankFormData.strNumericAnswer1);

	        String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
	                     objUserdata.strFullName1, objLogindata.strRegionName,
	                     objFormConfiguration_data.strEditedLabelName,
	                     objBlankFormData.strNumericAnswer1);
	        
	        String strSubject = objFormConfiguration_data.strFormName;
	        
	        objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
					objUserdata.strPrimaryPwsd);

	        objMailVerificationFunctions.NavToInbox(strSubject);

	        boolean blnMsg1 = false;
	        boolean blnMsg2 = false;
	        boolean blnMsg3 = false;

	        for (int intCount = 0; intCount < 3; intCount++) {

	               objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
	                            strSubject);

	               if (blnMsg1 == false) {
	                     blnMsg1 = objMailVerificationFunctions.verifyMailBody(strMsgBody);
	               } else if (blnMsg3 == false && blnMsg1 == true) {
	                     blnMsg3 = objMailVerificationFunctions.verifyMailBody(strMsgBody);
	               }

	               if (blnMsg2 == false) {
	                     blnMsg2 = objMailVerificationFunctions.verifyMailBody(strMsgBody1);
	               }

	               objMailVerificationFunctions.backToMailInbox();
	        }
	        assertTrue(blnMsg1 && blnMsg2 && blnMsg3, blnMsg1 + " " + blnMsg2 + " " + blnMsg3);

	        objMailVerificationFunctions.logoutMail();

			gstrResult = "PASS";
		}
	
	/************************************************************************************
	'Description : Verify that 'Date' question of an new form questionnaire can be edited.
	'Date	 	 : 18-Mar-2015
	'Author		 : Pallavi
	'-----------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************/
	@Test(description = "Verify that 'Date' question of an new form questionnaire can be edited.")
	public void testHappyDay69385() throws Exception {

		gstrTCID = "69385";
		gstrTO = "Verify that 'Date' question of an new form questionnaire can be edited.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton().verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickSaveButton().verifyUserListPageIsDisplayed();

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration
				.verTemplateDesignPage()
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName)
				.clickOnEditFieldDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strDateQuestion)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary()
				.clickOnAnyDatesAllowedRadioButton()
				.clickOnDoneButton()
				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		System.out.println("-----------------Execution started---------------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.verFormConfigurePage()
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		Thread.sleep(2000);
		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);
			}
		}

		objFormConfiguration1
				.verTemplateDesignPage()
				.clickOnEditQuestionnaire(objFormConfiguration_data.strLabelName1)
				.enterLabelName("Edt" + objFormConfiguration_data.strLabelName1)
				.selectDateType(objFormConfiguration_data.strDateTime)
				.clickOnFutureDateIncludingToday()
				.clickOnDoneButton()
				.clickOnSaveButton();
		

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("Previewing");
//		objFormConfiguration1.verifyPreviewButtonIsDisplayed()
//		 					 .clickPreviewButton();
//		Thread.sleep(5000);
//		
//		String mainWindowHandle3 = driver1.getWindowHandle();
//
//		Set<String> a3 = driver1.getWindowHandles();
//		Iterator<String> ite3 = a3.iterator();
//
//		while (ite3.hasNext()) {
//			String popupHandle = ite3.next().toString();
//
//			if (!popupHandle.contains(mainWindowHandle3)
//					&& !popupHandle.contains(mainWindowHandle2)) {
//				driver1.switchTo().window(popupHandle);
//			}
//		}
//		
//		objFormConfiguration1
//				.verifyFormTitleInPreviewScreen(objFormConfiguration_data.strFormName);
//
//				objBlankForm
//						.verGroupName(objFormConfiguration_data.strGroupName);
//				
//				objFormConfiguration1.verifyNumericOrSingleLineTextQuestionIsDisabled("Edt" + objFormConfiguration_data.strLabelName1);
//		
//		driver1.close();
//		driver1.switchTo().window(mainWindowHandle3);
		
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName,
		        		 objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame();
		
		String strFutureDate = dts.FutureDate(2, "MM/dd/yyyy");
		System.out.println(strFutureDate);
		
		String strApplicationDate = objEventManagement1.getApplicationTimeWithCSTCDT();

		System.out.println(strApplicationDate);

		String[] strDate = strApplicationDate.split(" ");
		strFutureDate = strFutureDate + " " + strDate[2];
		// Activate Form
		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);
				driver1.manage().window().maximize();
			}
		}

		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField("Edt" + objFormConfiguration_data.strLabelName1,
						strFutureDate)
				.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(objUserdata.strNewUserName1)
					   .clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut()
		         .loginAsNewUser(objUserdata.strNewUserName1,
		        		 objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + "Edt" + objFormConfiguration_data.strLabelName1
//				+ ": " + strFutureDate;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						"Edt" + objFormConfiguration_data.strLabelName1,
						strFutureDate);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms()
				.selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
		
		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				"Edt" + objFormConfiguration_data.strLabelName1,
				strFutureDate);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				"Edt" + objFormConfiguration_data.strLabelName1,
				strFutureDate);
		
		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions.verifyMailBody(strMsgBody);
			} else if (blnMsg3 == false && blnMsg1 == true) {
				blnMsg3 = objMailVerificationFunctions.verifyMailBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/************************************************************************************
	'Description : Verify that 'Text Area' question of an new form questionnaire can be edited.
	'Date	 	 : 19-Mar-2015
	'Author		 : Pallavi
	'-----------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************/
	@Test(description = "Verify that 'Text Area' question of an new form questionnaire can be edited.")
	public void testHappyDay69386() throws Exception {

		gstrTCID = "69386";
		gstrTO = "Verify that 'Text Area' question of an new form questionnaire can be edited.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton().verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration
				.verTemplateDesignPage()
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName)
				.clickOnEditFieldDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strTextArea)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary()
				.enterMinimumLength(objFormConfiguration_data.strMinimumvalue)
				.enterMaximumLength(objFormConfiguration_data.strMaximumvalue)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		System.out.println("-----------------Execution started---------------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.verFormConfigurePage()
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		Thread.sleep(2000);
		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);
			}
		}

		objFormConfiguration1
				.verTemplateDesignPage()
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.enterLabelName(
						objFormConfiguration_data.strEditedLabelName)
				.enterMinimumLength(
						objFormConfiguration_data.strMinimumvalue1)
				.enterMaximumLength(
						objFormConfiguration_data.strMaximumvalue1)
				.clickOnDoneButton()
				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("Previewing");
		objFormConfiguration1.verifyPreviewButtonIsDisplayed()
		 					 .clickPreviewButton();
		Thread.sleep(5000);
		
		String mainWindowHandle3 = driver1.getWindowHandle();

		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite3 = a3.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle3)
					&& !popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);
			}
		}
		
		objFormConfiguration1
				.verifyFormTitleInPreviewScreen(objFormConfiguration_data.strFormName);
//
//				objBlankForm
//						.verGroupName(objFormConfiguration_data.strGroupName);
//				
//				objFormConfiguration1.verifyNumericOrSingleLineTextQuestionIsDisabled(objFormConfiguration_data.strEditedLabelName);
		
		driver1.close();
		driver1.switchTo().window(mainWindowHandle3);
		
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName,
		        		 objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame();
		
		// Activate Form
		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerForMultiLineText(
						objFormConfiguration_data.strEditedLabelName,
						objBlankFormData.strTextAreaAnswer)
				.clickOnSave()
				.verErrorMsgWhenTextExceedsMaxLength(
						objFormConfiguration_data.strEditedLabelName,
						objFormConfiguration_data.strMinimumvalue1,
						objFormConfiguration_data.strMaximumvalue1)
				.enterAnswerForMultiLineText(
						objFormConfiguration_data.strEditedLabelName,
						objBlankFormData.strMultiLineTextAnswer)
				.clickOnGrpNameVirtually(objFormConfiguration_data.strGroupName)
				.clickOnSave();
		Thread.sleep(5000);
		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(objUserdata.strNewUserName1)
					   .clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut()
		         .loginAsNewUser(objUserdata.strNewUserName1,
		        		 objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strEditedLabelName
//				+ ": " + objBlankFormData.strMultiLineTextAnswer;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strEditedLabelName,
						objBlankFormData.strMultiLineTextAnswer);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms()
				.selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
		
		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strEditedLabelName,
				objBlankFormData.strMultiLineTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strEditedLabelName,
				objBlankFormData.strMultiLineTextAnswer);
		
		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions.verifyMailBody(strMsgBody);
			} else if (blnMsg3 == false && blnMsg1 == true) {
				blnMsg3 = objMailVerificationFunctions.verifyMailBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that 'Table' question of an new form questionnaire can be edited.
	'Date	 	 : 20-Mar-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that 'Table' question of an new form questionnaire can be edited.")
	public void testHappyDay69427() throws Exception {

		gstrTCID = "69427";
		gstrTO = "Verify that 'Table' question of an new form questionnaire can be edited.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
                this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton().verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickSaveButton().verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration.verTemplateDesignPage()
						    .clickOnInsert()
						    .clickOnTableLink()
                            .verifyEditFieldSetWindow()
                            .enterFirstRowLabel(objFormConfiguration_data.strRow1)
                            .enterSecondRowLabel(objFormConfiguration_data.strRow2)
                            .addFirstTableColumn(objFormConfiguration_data.strColumnName1,
                            					objFormConfiguration_data.strText)
                            .addNthTableColumn(objFormConfiguration_data.strColumnName2,
                            				  objFormConfiguration_data.strNumeric)
                            .addNthTableColumn(objFormConfiguration_data.strColumnName3,
                            				  objFormConfiguration_data.strTextArea)				  
       					    .clickOnEditFieldDoneButton()
       					    .clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();
		
		System.out.println("-----------------Execution started---------------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.verFormConfigurePage()
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		Thread.sleep(2000);
		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);
			}
		}

		objFormConfiguration1
				.verTemplateDesignPage()
				.clickOnEditTable()
				.removeNthColumn(objFormConfiguration_data.strSecChoice)
				.enterFirstRowLabel("Edt" + objFormConfiguration_data.strRow1)
				.editSecondRowLabel("Edt" + objFormConfiguration_data.strRow2)
				.enterLabelForFirstColumn("Edt" + objFormConfiguration_data.strColumnName1)
				.editLabelForNthColumn(objFormConfiguration_data.strSecChoice, "Edt" + objFormConfiguration_data.strColumnName3)
				.clickOnEditFieldDoneButton()
				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("Previewing");
		objFormConfiguration1.verifyPreviewButtonIsDisplayed()
		 					 .clickPreviewButton();
		Thread.sleep(5000);
		
		String mainWindowHandle3 = driver1.getWindowHandle();

		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite3 = a3.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle3)
					&& !popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);
			}
		}
		
		objFormConfiguration1
				.verifyFormTitleInPreviewScreen(objFormConfiguration_data.strFormName)
				.verifyColumnsOfTypeNumOrTxtQtnsAreDisabled("Edt" + objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strOneColumn)
				.verifyColumnsOfTypeNumOrTxtQtnsAreDisabled("Edt" + objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strOneColumn)
				.verifyColumnsOfMultiLineTxtQtnsAreDisabled("Edt" + objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strTwoColumn)
				.verifyColumnsOfMultiLineTxtQtnsAreDisabled("Edt" + objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strTwoColumn);
		
		driver1.close();
		driver1.switchTo().window(mainWindowHandle3);
		Thread.sleep(2000);
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName,
		        		 objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame();
		
		// Activate Form
		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle4 = driver1.getWindowHandle();
		
		Set<String> a4 = driver1.getWindowHandles();
		Iterator<String> ite4 = a4.iterator();
		
		while (ite4.hasNext()) {
			String popupHandle = ite4.next().toString();
		
			if (!popupHandle.contains(mainWindowHandle4)) {
				driver1.switchTo().window(popupHandle);
		
			}
		}
		
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verRowDetails("Edt" + objFormConfiguration_data.strRow1,
        						   objFormConfiguration_data.strText)
        			.verRowDetails("Edt" + objFormConfiguration_data.strRow2,
        						   objFormConfiguration_data.strText)
        			.enterAnswerInFirstColumn("Edt" + objFormConfiguration_data.strRow1,
			            					  objFormConfiguration_data.strText,
			            					  objBlankFormData.strTextAnswer)
			        .enterAnswerInFirstColumn("Edt" + objFormConfiguration_data.strRow2,
			            					  objFormConfiguration_data.strText,
			            					  objBlankFormData.strTextAnswer1)
			        .enterAnswerInSecondColumnForTextArea("Edt" + objFormConfiguration_data.strRow1,
					   						   objBlankFormData.strTextAreaAnswer)
	            	.enterAnswerInSecondColumnForTextArea("Edt" + objFormConfiguration_data.strRow2,
					   						   objBlankFormData.strTextAreaAnswer1)
					.clickOnSave();
		Thread.sleep(5000);
		objBlankForm.clickOnComplete();
		Thread.sleep(5000);
		
		objDispatchForm.selUserToReceiveCompletedForm(
								objUserdata.strNewUserName1)
					   .clickOnDispatchForm();
		
		driver1.switchTo().window(mainWindowHandle4);
		
		objRegionDefault1.selectFrame();
		
        objLogin1.clickLogOut();

        objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
                       objUserdata.strNewPassword);
        
//        String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//        				+ "Edt" + objFormConfiguration_data.strRow1 + ":" + "Edt" + objFormConfiguration_data.strColumnName1
//        				+ ": " + objBlankFormData.strTextAnswer + "| "
//        				+ "Edt" + objFormConfiguration_data.strRow1 + ":" + "Edt" + objFormConfiguration_data.strColumnName2
//        				+ ": " + objBlankFormData.strTextAreaAnswer + "| "
//        				+ "Edt" + objFormConfiguration_data.strRow2 + ":" + "Edt" + objFormConfiguration_data.strColumnName1
//        				+ ": " + objBlankFormData.strTextAnswer1 + "| "
//        				+ "Edt" + objFormConfiguration_data.strRow2 + ":" + "Edt" + objFormConfiguration_data.strColumnName2
//        				+ ": " + objBlankFormData.strTextAreaAnswer1 + "";
        
		String strMsg = objRegionDefault1.getWebNotificationForTable(
				objUserdata.strFullName, objLogindata.strRegionName,
				"Edt" + objFormConfiguration_data.strRow1,
				"Edt" + objFormConfiguration_data.strColumnName1,
				objBlankFormData.strTextAnswer,
				"Edt" + objFormConfiguration_data.strColumnName3,
				objBlankFormData.strTextAreaAnswer,
				"Edt" + objFormConfiguration_data.strRow2,
				objBlankFormData.strTextAnswer1,
				objBlankFormData.strTextAreaAnswer1);
		
        Thread.sleep(5000);
        
        objRegionDefault1
                       .selectFrame()
                       .verWebNotificationframe()
                       .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
                                     strMsg)
                       .clickAcknowledgeAllForms()
        			   .selectFrame();
        
        objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
                                                  objUserdata.strPrimaryPwsd);
        
        String strMsgBody = objMailVerificationFunctions.getFormMailBodyForTable(objUserdata.strFullName,
				objLogindata.strRegionName, "Edt" + objFormConfiguration_data.strRow1,
				"Edt" + objFormConfiguration_data.strRow2,
				"Edt" + objFormConfiguration_data.strColumnName1,
				"Edt" + objFormConfiguration_data.strColumnName3,
				objBlankFormData.strTextAnswer,
				objBlankFormData.strTextAnswer1,
				objBlankFormData.strTextAreaAnswer,
				objBlankFormData.strTextAreaAnswer1);

		String strMsgBody1 = objMailVerificationFunctions
				.getFormPagerBodyForTable(objUserdata.strFullName,
						objLogindata.strRegionName, "Edt"
								+ objFormConfiguration_data.strRow1, "Edt"
								+ objFormConfiguration_data.strRow2, "Edt"
								+ objFormConfiguration_data.strColumnName1,
						"Edt" + objFormConfiguration_data.strColumnName3,
						objBlankFormData.strTextAnswer,
						objBlankFormData.strTextAnswer1,
						objBlankFormData.strTextAreaAnswer,
						objBlankFormData.strTextAreaAnswer1);

		String strSubject = objFormConfiguration_data.strFormName;
		
		objMailVerificationFunctions.NavToInbox(strSubject);
		
		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
		
		for (int intCount = 0; intCount < 3; intCount++) {
		
			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			} else if (blnMsg3 == false && blnMsg1 == true) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}

	/************************************************************************************
	'Description : Verify that 'Selection List' question of an new form questionnaire can be edited. 
	'Date	 	 : 19-Mar-2015
	'Author		 : Hanumegowda
	'-----------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************/
	@Test(description = "Verify that 'Selection List' question of an new form questionnaire can be edited.")
	public void testHappyDay69426() throws Exception {

		gstrTCID = "69426";
		gstrTO = "Verify that 'Selection List' question of an new form questionnaire can be edited.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton().deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration
				.verTemplateDesignPage()
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName)
				.clickOnEditFieldDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strSingleSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.addChoices(objFormConfiguration_data.strChoice)
				.clickOnDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType1(objFormConfiguration_data.strMultiSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.addChoices(objFormConfiguration_data.strChoice2)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		System.out.println("-----------------Execution started---------------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1.verFormConfigurePage().clickOnAcknowledgeForm(
				objFormConfiguration_data.strFormName);

		Thread.sleep(2000);
		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);
			}
		}

		objFormConfiguration1
				.verTemplateDesignPage()
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.enterLabelName("Edt" + objFormConfiguration_data.strLabelName1)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice1)
				.clickOnDoneButton()
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName2)
				.enterLabelName("Edt" + objFormConfiguration_data.strLabelName2)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice3)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("Previewing");

		// objFormConfiguration1.verifyPreviewButtonIsDisplayed()
		// .clickPreviewButton();
		// Thread.sleep(5000);
		//
		// String mainWindowHandle3 = driver1.getWindowHandle();
		//
		// Set<String> a3 = driver1.getWindowHandles();
		// Iterator<String> ite3 = a3.iterator();
		//
		// while (ite3.hasNext()) {
		// String popupHandle = ite3.next().toString();
		//
		// if (!popupHandle.contains(mainWindowHandle3)
		// && !popupHandle.contains(mainWindowHandle2)) {
		// driver1.switchTo().window(popupHandle);
		// }
		// }
		//
		/* objFormConfiguration1
		 .verifyFormTitleInPreviewScreen(objFormConfiguration_data.strFormName);*/
		//
		// objBlankForm
		// .verGroupName(objFormConfiguration_data.strGroupName);
		//
		// objFormConfiguration1.verMultiSelectQuestionIsDisabled("Edt" +
		// objFormConfiguration_data.strLabelName1);
		// objFormConfiguration1.verMultiSelectQuestionIsDisabled("Edt" +
		// objFormConfiguration_data.strLabelName2);
		//
		// driver1.close();
		// driver1.switchTo().window(mainWindowHandle3);

		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);
				driver1.manage().window().maximize();
			}
		}

		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInMultiSelectBoxWithLable(
						"Edt" + objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice)
				.enterAnswerInMultiSelectBoxWithLable(
						"Edt" + objFormConfiguration_data.strLabelName2,
						objFormConfiguration_data.strChoice2)

				.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + "Edt"
//				+ objFormConfiguration_data.strLabelName1 + ": "
//				+ objFormConfiguration_data.strChoice + "| " + "Edt"
//				+ objFormConfiguration_data.strLabelName2 + ": "
//				+ objFormConfiguration_data.strChoice2;

		String strMsg = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName, "Edt"
								+ objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice, "Edt"
								+ objFormConfiguration_data.strLabelName2,
						objFormConfiguration_data.strChoice2);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName, "Edt"
						+ objFormConfiguration_data.strLabelName1,
				objFormConfiguration_data.strChoice, "Edt"
						+ objFormConfiguration_data.strLabelName2,
				objFormConfiguration_data.strChoice2);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName, "Edt"
						+ objFormConfiguration_data.strLabelName1,
				objFormConfiguration_data.strChoice, "Edt"
						+ objFormConfiguration_data.strLabelName2,
				objFormConfiguration_data.strChoice2);

		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			} else if (blnMsg3 == false && blnMsg1 == true) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	'Description :  Verify that 'Text' question of an new form questionnaire can be edited..
	'Date	 	 : 24-Jan-2015
	'Author		 : Sangappa.k
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description =" Verify that 'Text' question of an new form questionnaire can be edited.")
	public void testHappyDay69380() throws Exception {

		gstrTCID = "69380";
		gstrTO = " Verify that 'Text' question of an new form questionnaire can be edited.";
		
		
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata=new User_data();
		BlankFormData objBlankFormData = new BlankFormData();
		
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);
		UsersList objUsersList= new UsersList(driver);
		Login objLogin = new Login(this.driver1);
		
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);
		BlankForm objBlankForm1 = new BlankForm(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		ActivateForms objActivateForms1= new ActivateForms(driver1);
		DispatchForm objDispatchForm1= new DispatchForm(driver1);
		MailVerificationFunctions objMailVerificationFunctions1 = new MailVerificationFunctions(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.enterEmail(objUserdata.strPrimaryMailId)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
		   .clickCreateNewUserButton()
		   .enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName)
		  .enterEmail(objUserdata.strPrimaryMailId)
		  .enterPrimaryEmailId(objUserdata.strPrimaryMailId)
		  .entertextPagerId(objUserdata.strPrimaryMailId)				
		  .selectFirstRole().clickSaveButton()
		  .verifyUserListPageIsDisplayed();
		

		System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)	
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)	
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)	
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName) 
				.clickOnSaveOfFormSecuritySetting();
	
		
		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(10000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration
					.clickOnInsert()
				    .clickOnGroupLink()
				    .verifyEditGroupOrTable()
				    .enterNewGroupName(objFormConfiguration_data.strGroupName)
				    .clickOnGroupDoneButton()
				    .clickOnAddButton(objFormConfiguration_data.strGroupName)
				    .clickOnFieldSet(objFormConfiguration_data.strGroupName)
				    .verifyEditFieldSetWindow()
				    .enterAttributesLabelName(objFormConfiguration_data.strAttributeName)
				    .clickOnEditFieldDoneButton()
				    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
				    .verifyEditQuestionWindow()    
				    .selectQuestionType(objFormConfiguration_data.strText)
				    .enterLabelName(objFormConfiguration_data.strLabelName1)
				    .clickOnDoneButton()				    
				    .clickOnSaveButton();
		
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();
		
		System.out.println("--------End of precondition---------");
		
		
	//Ie login
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration1
						.clickOnAcknowledgeFormOnIE(objFormConfiguration_data.strFormName);
		
		Thread.sleep(10000);
		
		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		System.out.println("mainWindowHandle1 : " +mainWindowHandle1);
		Thread.sleep(50000);
		objFormConfiguration1.verTemplateDesignPage()
							 .verifyFormTitle(objFormConfiguration_data.strFormName)
							 .verifyPreviewButtonIsDisplayed()
							 .clickOnEditQuestionnaire(objFormConfiguration_data.strLabelName1)
				             .enterLabelName(objFormConfiguration_data.strLabelName2)
				             .enterTextInReportLabel(objFormConfiguration_data.strReportLabel)
				             .enterTextInToolTipHelp(objFormConfiguration_data.strToolTipHelp)
				             .clickOnDoneButton()
							 .clickPreviewButton();
		
		
		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);
			}
		}

		System.out.println("mainWindowHandle2 : " +mainWindowHandle2);
		objFormConfiguration1.verifyFormTitleInPreviewScreen(objFormConfiguration_data.strFormName)
				         .verifyLabelNameInPreviewPage(objFormConfiguration_data.strLabelName2);
					
		driver1.close();
	
		driver1.switchTo().window(mainWindowHandle2);
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(7000);
		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut();
		
		//Login As Activte user
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle4 = driver1.getWindowHandle();

		Set<String> a4 = driver1.getWindowHandles();
		Iterator<String> ite4 = a4.iterator();

		while (ite4.hasNext()) {
			String popupHandle = ite4.next().toString();

			if (!popupHandle.contains(mainWindowHandle4)) {
				driver1.switchTo().window(popupHandle);
				driver1.manage().window().maximize();
			}
		}

		objBlankForm1
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName2,objBlankFormData.strSinglelineTextAnswer)
				.clickOnSave();

		objBlankForm1.clickOnComplete();

		objDispatchForm1.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle4);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();
		
		//Acknowledge form
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		
//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName2
//				+ ": " + objBlankFormData.strSinglelineTextAnswer;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName2,
						objBlankFormData.strSinglelineTextAnswer);
		
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame();


		objMailVerificationFunctions1.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
		
		String strMsgBody = objMailVerificationFunctions1.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				  objFormConfiguration_data.strLabelName2,
				objBlankFormData.strSinglelineTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions1.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				  objFormConfiguration_data.strLabelName2,
				objBlankFormData.strSinglelineTextAnswer);
		
		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions1.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			objMailVerificationFunctions1.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions1.verifyMailBody(strMsgBody);
			} else if (blnMsg3 == false && blnMsg1 == true) {
				blnMsg3 = objMailVerificationFunctions1.verifyMailBody(strMsgBody);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions1.verifyMailBody(strMsgBody1);
			}

			objMailVerificationFunctions1.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2 && blnMsg3);

		objMailVerificationFunctions1.logoutMail();

		gstrResult = "PASS";
	}	
	
}
