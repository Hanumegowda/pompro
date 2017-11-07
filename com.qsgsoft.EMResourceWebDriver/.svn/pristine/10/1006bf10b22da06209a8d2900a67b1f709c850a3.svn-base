package requirementGroup.Forms;

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
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseDeleteV3FormQuestionnaire extends TestNG_UI_EXTENSIONS {

	public EdgeCaseDeleteV3FormQuestionnaire() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/***********************************************************************************************
	'Description : Verify that user can cancel the process of deleting questionnaire added to a form
	'Date	 	 : 02-Jan-2015
	'Author		 : Anitha
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description = "Verify that user can cancel the process of deleting questionnaire added to a form.")
	public void testEdgeCase152231() throws Exception {

		gstrTCID = "152231";
		gstrTO = "Verify that user can cancel the process of deleting questionnaire added to a form.";

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
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName).selectFirstRole()
		.clickSaveButton();
		
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();

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
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
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
		
	System.out.println("----------Precondition end and test execution starts--------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

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

		objFormConfiguration1.verTemplateDesignPage()
				.cancelDeleteLinkOfAQuestion(objFormConfiguration_data.strLabelName)
				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);
		
		objFormConfiguration1.verifyLabelNameInTemplateDesignPage(objFormConfiguration_data.strLabelName);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);
		
		Thread.sleep(2000);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/************************************************************************************************************
	'Description :  Verify that attributes added under field set in a form can be deleted
	'Date	 	 : 16-Jan-2015
	'Author		 : Pallavi
	'------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                             	Modified By
	'Date					                                                                Name
	*************************************************************************************************************/
	@Test(description = "Verify that attributes added under field set in a form can be deleted")
	public void testEdgeCase152230() throws Exception {

		gstrTCID = "152230";
		gstrTO = "Verify that attributes added under field set in a form can be deleted";

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);
		
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
				.clickSaveButton();

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
				.selectReportformDetail()
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton();

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
							objFormConfiguration_data.strFormActivatnUIOTFO)
					.selCompletedFormDelivery(
							objFormConfiguration_data.strComptdFormDelvry)
					.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
					.clickOnNextButton()
					.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
					.clickOnNextButton()
					.clickOnNextButton()
					.selectActivateFormChkBox(objUserdata.strNewUserName1)
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
					.enterLabelName(objFormConfiguration_data.strLabelName)
					.clickOnAddToSummary()
					.clickOnDoneButton()
					.clickOnInsertElement(
							objFormConfiguration_data.strAttributeName)
					.verifyEditQuestionWindow()
					.selectQuestionType(objFormConfiguration_data.strNumeric)
					.enterLabelName(objFormConfiguration_data.strLabelName1)
					.clickOnAddToSummary()
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
		
		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
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
		
		objFormConfiguration1.verifyFormTitle(objFormConfiguration_data.strFormName);

		objFormConfiguration1.deleteAQuestion(objFormConfiguration_data.strLabelName)
							 .verifyQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);
		
		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that user can not delete any questions in the popped up form. 
	'Precondition:
	'Date	 	 : 16-Jan-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user can not delete any questions in the popped up form.")
	public void testEdgeCase152201() throws Exception {

		gstrTCID = "152201";
		gstrTO = "Verify that user can not delete any questions in the popped up form.";

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
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickSaveButton();

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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

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
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();

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

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName)
				.clickOnActivateForm();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName,
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
		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.verDeleteLinkOfQuestionIsNotDisplayed(
						objFormConfiguration_data.strLabelName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that choices added to a questionnaire can be deleted 
	'Precondition:
	'Date	 	 : 16-Jan-2015
	'Author		 : Deepa
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that choices added to a questionnaire can be deleted ")
	public void testEdgeCase152225() throws Exception {

		gstrTCID = "152225";
		gstrTO = "Verify that choices added to a questionnaire can be deleted ";

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

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();
		
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
				.clickSaveButton();

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
				.selectFormUserMayActivateFormsOption().clickSaveButton();
		
		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName)
				.clickOnNextButton()
				.clickOnNextButton()
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();

		Thread.sleep(10000);
		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

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
					        .clickOnAddToSummary()
					        .addChoices(objFormConfiguration_data.strChoice)
					        .addNthChoice(objFormConfiguration_data.strSecChoice,objFormConfiguration_data.strChoice2)
					        .clickOnDoneButton()
					        .verifyAddedFirstQueChoiceIsDis(objFormConfiguration_data.strLabelName
					        						,objFormConfiguration_data.strChoice)
					        .verifyAddedSecQueChoiceIsDis(objFormConfiguration_data.strLabelName
					        						,objFormConfiguration_data.strChoice2)
					        .editQuestion(objFormConfiguration_data.strLabelName)
					        .removeFirstChoice()
					        .clickOnDoneButtonInEditQueWin()
					        .verifyFirstQueChoiceIsNotDis(objFormConfiguration_data.strLabelName
	        						,objFormConfiguration_data.strChoice);
		
		gstrResult = "PASS";
	}
	
}
