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
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseEditV3FormQuestionnaire extends TestNG_UI_EXTENSIONS {

	public EdgeCaseEditV3FormQuestionnaire() throws Exception {
		super();
	}

	/***********************************************************************************
	 * 'Description : Verify that 'Instructions' added while configuring cannot
	 * be edited while activating forms 'Date : 08-Jan-2015 'Author : Pallavi
	 * '--------------------------------------------------------------------------------
	 * - - - 'Modified Date Modified By 'Date Name
	 *************************************************************************************/
	@Test(description = "Verify that 'Instructions' added while configuring cannot be edited while activating forms")
	public void testEdgeCase152087() throws Exception {

		gstrTCID = "152087";
		gstrTO = "Verify that 'Instructions' added while configuring cannot be edited while activating forms";

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
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickSaveButton();

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
		String strPopUp1 = "";
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			strPopUp1 = popupHandle;
			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);
				driver.manage().window().maximize();
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
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary()
				.clickOnDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strInstructions)
				.selectInstructionFrame()
				.enterInstructions(objFormConfiguration_data.strInstructionData);

		driver.switchTo().window(strPopUp1);

		objFormConfiguration.clickOnDoneButton().clickOnSaveButton();

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
				.switchToFormFrame()
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.verifyEnteredInstructionIsRetained(
						objFormConfiguration_data.strInstructionData)
				.verifyInstructionInGroupIsNotPresent(
						objFormConfiguration_data.strGroupName)
				.verifyEditLinkNotPresentForInstructions(
						objFormConfiguration_data.strInstructionData);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	 * 'Description : Verify that user cannot update the choice type selected
	 * for 'Check box' 'Date : 19-Dec-2014 'Author : Deepa
	 * '----------------------------------------------------------------------------------
	 * - - - 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that user cannot update the choice type selected for 'Check box'.")
	public void testEdgeCase152169() throws Exception {

		gstrTCID = "152169";
		gstrTO = "Verify that user cannot update the choice type selected for 'Check box'.";

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		;

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
				.selectQuestionType(objFormConfiguration_data.strCheckBox)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.addChoices(objFormConfiguration_data.strChoice)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice2)
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strCheckBox)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary().clickOnUseStanderdListChkBox()
				.selValInListToUseDropDown(objFormConfiguration_data.strListToUseValue)
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

		System.out
				.println("--------Precondition Ends and test execution starts--------");

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

		Thread.sleep(10000);
		objFormConfiguration1
				.verTemplateDesignPage()
				.clickOnEditQuestionnaireNew(
						objFormConfiguration_data.strLabelName)
				.checkUseStanderdListChkBoxDisabeled()
				.clickOnDoneButton()
				.clickOnEditQuestionnaireNew(
						objFormConfiguration_data.strLabelName1)
				.verifyChioceOptionsNotPresent().clickOnDoneButton()
				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		objFormConfiguration1
				.verifyLabelNameInTemplateDesignPage(objFormConfiguration_data.strLabelName);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		Thread.sleep(2000);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	 * 'Description : Verify that 'Numeric' questionnaires of types 'Number,
	 * Percentage & Currency' can be added to the V3 form. 'Precondition: 'Date
	 * : 16-Jan-2015 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = " 	Verify that 'Numeric' questionnaires of types 'Number, Percentage & Currency' can be added to the V3 form. ")
	public void testEdgeCase152188() throws Exception {

		gstrTCID = "152188";
		gstrTO = " 	Verify that 'Numeric' questionnaires of types 'Number, Percentage & Currency' can be added to the V3 form.  ";

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
				.selectNumberType(objFormConfiguration_data.strNumber)
				.clickOnAddToSummary()
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.selectNumberType(objFormConfiguration_data.strPercentage)
				.clickOnAddToSummary()
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.selectNumberType(objFormConfiguration_data.strCurrency)
				.clickOnAddToSummary().clickOnDoneButton()

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
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer)
				.enterAnswerInFieldForCurrencyAndPercent(
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strNumericAnswer1)
				.enterAnswerInFieldForCurrencyAndPercent(
						objFormConfiguration_data.strLabelName2,
						objBlankFormData.strNumericAnswer2).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut().loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strNumericAnswer + "| "
				+ objFormConfiguration_data.strLabelName1 + ": "
				+ objBlankFormData.strNumericAnswer1 + "| "
				+ objFormConfiguration_data.strLabelName2 + ": "
				+ objBlankFormData.strNumericAnswer2;*/
		
		String strMsg = objRegionDefault1
				.getWebNotificationForThreeQuestionnaire(
						objUserdata.strFullName, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strNumericAnswer1,
						objFormConfiguration_data.strLabelName2,
						objBlankFormData.strNumericAnswer2);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions
				.getFormMailBodyForThreeLabel(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strNumericAnswer1,
						objFormConfiguration_data.strLabelName2,
						objBlankFormData.strNumericAnswer2);

		String strMsgBody1 = objMailVerificationFunctions
				.getFormPagerBodyForThreeLabel(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strNumericAnswer1,
						objFormConfiguration_data.strLabelName2,
						objBlankFormData.strNumericAnswer2);

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
	 * 'Description : Verify that user cannot select other attributes while
	 * adding 'Instructions' group 'Precondition: 'Date : 19-Jan-2015 'Author :
	 * Anil '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that user cannot select other attributes while adding 'Instructions' group 	")
	public void testEdgeCase152089() throws Exception {

		gstrTCID = "152089";
		gstrTO = "Verify that user cannot select other attributes while adding 'Instructions' group 	";

		Login objLogin1 = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);

		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.clickOnNextButton().deSelectAllUsersCheckBox();
		Thread.sleep(5000);
		objFormConfiguration1.clickOnNextButton()
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();
		Thread.sleep(10000);

		String popupHandle = "";
		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);
				System.out.println(popupHandle);
			}
		}

		objFormConfiguration1
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
				.selectQuestionType(objFormConfiguration_data.strInstructions)
				.verifyQuestionTypeIsNotDisplayed()
				.selectInstructionFrame()
				.enterInstructions(
						objFormConfiguration_data.strInstructionData2);
		driver1.switchTo().window(popupHandle);
		objFormConfiguration1.clickOnDoneButton();

		Thread.sleep(10000);
		objFormConfiguration1.clickOnSaveButton();
		Thread.sleep(10000);
		objFormConfiguration1
				.clickOnEditInstruction(objFormConfiguration_data.strInstructionData2);
		driver1.switchTo().window(popupHandle);
		objFormConfiguration1.verifyQuestionTypeIsNotDisplayed()
				.clickOnDoneButton().clickOnSaveButton();
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/******************************************************************************************************
	 * 'Description : Verify that user cannot update the choice type selected
	 * for 'Radio' button questionnaire. 'Date : 19-Dec-2014 'Author : Deepa
	 * '---------------------------------------------------------------------------------------------------
	 * - - - 'Modified Date Modified By 'Date Name
	 *******************************************************************************************************/
	@Test(description = "Verify that user cannot update the choice type selected for 'Radio' button questionnaire. ")
	public void testEdgeCase152170() throws Exception {

		gstrTCID = "152170";
		gstrTO = "Verify that user cannot update the choice type selected for 'Radio' button questionnaire. ";

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		;

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
				.selectQuestionType(objFormConfiguration_data.strRadio)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.addChoices(objFormConfiguration_data.strChoice)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice2)
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strRadio)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary().clickOnUseStanderdListChkBox()
				.selValInListToUseDropDown(objFormConfiguration_data.strListToUseValue)
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

		System.out
				.println("--------Precondition Ends and test execution starts--------");

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

		Thread.sleep(10000);
		objFormConfiguration1
				.verTemplateDesignPage()
				.clickOnEditQuestionnaireNew(
						objFormConfiguration_data.strLabelName)
				.checkUseStanderdListChkBoxDisabeled()
				.clickOnDoneButton()
				.clickOnEditQuestionnaireNew(
						objFormConfiguration_data.strLabelName1)
				.verifyChioceOptionsNotPresent().clickOnDoneButton()
				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		objFormConfiguration1
				.verifyLabelNameInTemplateDesignPage(objFormConfiguration_data.strLabelName);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		Thread.sleep(2000);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/******************************************************************************************************
	 * 'Description : Verify that user cannot update the choice type selected
	 * for 'Single-select' questionnaire. 'Date : 19-Dec-2014 'Author : Deepa
	 * '---------------------------------------------------------------------------------------------------
	 * - - - 'Modified Date Modified By 'Date Name
	 *******************************************************************************************************/
	@Test(description = "Verify that user cannot update the choice type selected for 'Single-select' questionnaire.")
	public void testEdgeCase152172() throws Exception {

		gstrTCID = "152172";
		gstrTO = "Verify that user cannot update the choice type selected for 'Single-select' questionnaire";

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		;

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
				.selectQuestionType(objFormConfiguration_data.strSingleSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.addChoices(objFormConfiguration_data.strChoice)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice2)
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionTypeNew(
						objFormConfiguration_data.strSingleSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary().clickOnUseStanderdListChkBox()
				.selValInListToUseDropDown(objFormConfiguration_data.strListToUseValue)
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

		System.out
				.println("--------Precondition Ends and test execution starts--------");

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

		objFormConfiguration1
				.verTemplateDesignPage()
				.clickOnEditQuestionnaireNew(
						objFormConfiguration_data.strLabelName)
				.checkUseStanderdListChkBoxDisabeled()
				.clickOnDoneButton()
				.clickOnEditQuestionnaireNew(
						objFormConfiguration_data.strLabelName1)
				.verifyChioceOptionsNotPresent().clickOnDoneButton()
				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		objFormConfiguration1
				.verifyLabelNameInTemplateDesignPage(objFormConfiguration_data.strLabelName);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		Thread.sleep(2000);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	

	/******************************************************************************************************
	 * 'Description : Verify that user cannot update the choice type selected
	 * for 'Multi-select' questionnaire. 'Date : 19-Feb-2014 'Author : Anitha
	 * '---------------------------------------------------------------------------------------------------
	 * - - - 'Modified Date Modified By 'Date Name
	 *******************************************************************************************************/
	@Test(description = "Verify that user cannot update the choice type selected for 'Multi-select' questionnaire.")
	public void testEdgeCase152171() throws Exception {

		gstrTCID = "152171";
		gstrTO = "Verify that user cannot update the choice type selected for 'Multi-select' questionnaire.";

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		;

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
				.selectQuestionType(objFormConfiguration_data.strSingleSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.addChoices(objFormConfiguration_data.strChoice)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice2)
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionTypeNew(objFormConfiguration_data.strMultiSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary().clickOnUseStanderdListChkBox()
				.selValInListToUseDropDown(objFormConfiguration_data.strListToUseValue)
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

		System.out
				.println("--------Precondition Ends and test execution starts--------");

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

		objFormConfiguration1
				.verTemplateDesignPage()
				.clickOnEditQuestionnaireNew(
						objFormConfiguration_data.strLabelName)
				.checkUseStanderdListChkBoxDisabeled()
				.clickOnDoneButton()
				.clickOnEditQuestionnaireNew(
						objFormConfiguration_data.strLabelName1)
				.verifyChioceOptionsNotPresent().clickOnDoneButton()
				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		objFormConfiguration1
				.verifyLabelNameInTemplateDesignPage(objFormConfiguration_data.strLabelName);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		Thread.sleep(2000);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	 * 'Description : Verify that updated choices for 'Single Select'
	 * questionnaire are reflected in all the notifications. 'Precondition:
	 * 'Date : 26-Feb-2015 
	 * 'Author : Pallavi
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that updated choices for 'Single Select' questionnaire are reflected in all the notifications.")
	public void testEdgeCase151910() throws Exception {

		gstrTCID = "151910";
		gstrTO = "Verify that updated choices for 'Single Select' questionnaire are reflected in all the notifications.";

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
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
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

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
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

		Thread.sleep(5000);

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
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.addChoices(objFormConfiguration_data.strChoice)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice1)
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

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		String mainWindowHandle3 = driver1.getWindowHandle();
		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		Thread.sleep(5000);

		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite3 = a3.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle3)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		Thread.sleep(2000);
		objFormConfiguration1
				.verTemplateDesignPage()
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName)
				.addNthChoice(objFormConfiguration_data.strThirdChoice,
						objFormConfiguration_data.strChoice2)
				.addNthChoice(objFormConfiguration_data.strFourthChoice,
						objFormConfiguration_data.strChoice3)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle3);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(5000);
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
				.verifyChoiceIsDisplayedForSingleSelectQtn(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice2)
				.verifyChoiceIsDisplayedForSingleSelectQtn(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice3)
				.selectSingleOption(objFormConfiguration_data.strChoice)
				.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objFormConfiguration_data.strChoice + "";
		*/
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strChoice);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strChoice);

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


	
	/*********************************************************************************
	'Description	:Verify that choices added to a questionnaire can be edited.
	'Date	 		:30-Jan-2015
	'Author			:Hanumegowda
	**********************************************************************************/
	@Test(description = "Verify that choices added to a questionnaire can be edited")
	public void testEdgeCase152224() throws Exception {
		gstrTCID = "152224";
		gstrTO = "Verify that choices added to a questionnaire can be edited";
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
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
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
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton().deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		Thread.sleep(5000);
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();
		String strPopUp1 = "";
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			strPopUp1 = popupHandle;
			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);
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
				.selectQuestionType(objFormConfiguration_data.strCheckBox)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				

				.addChoices(objFormConfiguration_data.strChoice)

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

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle1 = ite1.next().toString();

			if (!popupHandle1.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle1);

			}
		}
		
		Thread.sleep(5000);
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.verAddedChoice(objFormConfiguration_data.strChoice,objFormConfiguration_data.strLabelName)

				.clickOnSave().clickOnComplete();
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		Thread.sleep(5000);

		objLogin1.clickLogOut();
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		// objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);
		objRegionDefault.selectFrame();
		objNavigationToSubmenus.clickOnConfigureForm();
		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		Thread.sleep(5000);
		String mainWindowHandle2 = driver.getWindowHandle();

		Set<String> a2 = driver.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();
		String strPopUp2 = "";
		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();
			strPopUp2 = popupHandle;
			if (!popupHandle.contains(mainWindowHandle2)) {
				driver.switchTo().window(popupHandle);
				driver.manage().window().maximize();
			}
		}

		objFormConfiguration.verTemplateDesignPage();
		Thread.sleep(10000);
		objFormConfiguration
				.clickOnEditQuestionnaire1(objFormConfiguration_data.strChoice)

				.addChoices(objFormConfiguration_data.strChoice1)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle2);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		

		objRegionDefault1.selectFrame();
		Thread.sleep(10000);

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle3 = driver1.getWindowHandle();
		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite3 = a3.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle3)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.verAddedChoice(objFormConfiguration_data.strChoice1,objFormConfiguration_data.strLabelName)

				.clickOnSave().clickOnComplete();
		Thread.sleep(10000);
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();
		driver1.switchTo().window(mainWindowHandle3);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		gstrResult = "PASS";

	}
	
	/*************************************************************************************
	'Description : Verify that updated choices for 'Single select' questionnaire are not lost after second publish. 
	'Precondition:
	'Date	 	 : 27-Feb-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that updated choices for 'Single select' questionnaire are not lost after second publish.")
	public void testEdgeCase152207() throws Exception {

		gstrTCID = "152207";
		gstrTO = "Verify that updated choices for 'Single select' questionnaire are not lost after second publish.";

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
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
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

		objUsersList
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName2,
				objUserdata.strFirstName, objUserdata.strMiddleName,
				objUserdata.strLastName, objUserdata.strOrganization,
				objUserdata.strPhone, objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryMailId).selectFirstRole()
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
						    .addChoices(objFormConfiguration_data.strChoice)
							.addNthChoice(objFormConfiguration_data.strSecChoice,
										objFormConfiguration_data.strChoice1)
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
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.verFormConfigurePage()
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

		objFormConfiguration1.verTemplateDesignPage()
							.clickOnInsertElement(objFormConfiguration_data.strAttributeName)
				            .verifyEditQuestionWindow()    
				            .selectQuestionType(objFormConfiguration_data.strText)
				            .enterLabelName(objFormConfiguration_data.strLabelName1)
				            .clickOnAddToSummary()
				            .clickOnDoneButton()
				            .clickOnEditQuestionnaire(objFormConfiguration_data.strLabelName)
				            .addNthChoice(objFormConfiguration_data.strThirdChoice,
										objFormConfiguration_data.strChoice2)
							.addNthChoice(objFormConfiguration_data.strFourthChoice,
										objFormConfiguration_data.strChoice3)
							.clickOnDoneButton()
				            .clickOnSaveButton();
		
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		objBlankForm.verifyChoiceIsDisplayedForSingleSelectQtn(objFormConfiguration_data.strLabelName,
											objFormConfiguration_data.strChoice)
					.verifyChoiceIsDisplayedForSingleSelectQtn(objFormConfiguration_data.strLabelName,
											objFormConfiguration_data.strChoice1)
					.verifyChoiceIsDisplayedForSingleSelectQtn(objFormConfiguration_data.strLabelName,
											objFormConfiguration_data.strChoice2)
					.verifyChoiceIsDisplayedForSingleSelectQtn(objFormConfiguration_data.strLabelName,
											objFormConfiguration_data.strChoice3);
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
						 .selUserToFillOutForm(objUserdata.strNewUserName)
						 .clickOnActivateForm();

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName,
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
		Thread.sleep(10000);
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.verifyChoiceIsDisplayedForSingleSelectQtn(objFormConfiguration_data.strLabelName,
															objFormConfiguration_data.strChoice)
				    .verifyChoiceIsDisplayedForSingleSelectQtn(objFormConfiguration_data.strLabelName,
															objFormConfiguration_data.strChoice1)
					.verifyChoiceIsDisplayedForSingleSelectQtn(objFormConfiguration_data.strLabelName,
															objFormConfiguration_data.strChoice2)
					.verifyChoiceIsDisplayedForSingleSelectQtn(objFormConfiguration_data.strLabelName,
															objFormConfiguration_data.strChoice3)
					.selectSingleOption(objFormConfiguration_data.strChoice1)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,objBlankFormData.strTextAnswer)
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName2,
						 	objUserdata.strNewPassword);

		/*String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
						+ objFormConfiguration_data.strLabelName + ": "
						+ objFormConfiguration_data.strChoice1 + "| " 
						+ objFormConfiguration_data.strLabelName1
						+ ": "+objBlankFormData.strTextAnswer;
		*/
		String strMsg = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice1,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);

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
				objFormConfiguration_data.strChoice1,objFormConfiguration_data.strLabelName1,
				objBlankFormData.strTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strChoice1,objFormConfiguration_data.strLabelName1,
				objBlankFormData.strTextAnswer);

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
	 * 'Description : Verify that updated choices for 'Radio Button' questionnaire are not lost after second publish. 
	 * 'Date : 27-Feb-2015 
	 * 'Author : Hanumegowda
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that updated choices for 'Radio Button' questionnaire are not lost after second publish. ")
	public void testEdgeCase152205() throws Exception {

		gstrTCID = "152205";
		gstrTO = "Verify that updated choices for 'Radio Button' questionnaire are not lost after second publish. ";

		Login_data objLogindata = new Login_data();

		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();

		UsersList objUsersList = new UsersList(this.driver1);

		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration

		objFormConfiguration = new FormConfiguration(this.driver1);
		FormConfiguration

		objFormConfiguration1 = new FormConfiguration(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList

		.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName,

		objUserdata.strNewPassword, objUserdata.strFullName).selectFirstRole()
				.clickAdvancedOptionAndExpand()

				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()

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
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)

				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)

				.clickOnNextButton().deSelectAllUsersCheckBox()
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)

				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration
				.verTemplateDesignPage()

				.clickOnInsert()

				.clickOnGroupLink()

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

				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.addChoices(objFormConfiguration_data.strChoice)

				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice1)
				.clickOnDoneButton().clickOnSaveButton()
				.clickOnPublishButton();
		Thread.sleep(5000);
		objFormConfiguration
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.addNthChoice(objFormConfiguration_data.strThirdChoice,
						objFormConfiguration_data.strChoice2)
				.addNthChoice(objFormConfiguration_data.strFourthChoice,
						objFormConfiguration_data.strChoice3)
				.clickOnDoneButton();
		objFormConfiguration
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice)
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice1)
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice2)
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice3);
		Thread.sleep(2000);
		objFormConfiguration.clickOnSaveButton();
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(10000);

		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(10000);

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle1 = ite1.next().toString();

			if (!popupHandle1.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle1);

			}
		}
		Thread.sleep(5000);

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		objFormConfiguration1
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice)
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice1)
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice2)
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice3);
		objBlankForm.clickOnSave().clickOnComplete();
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut();
  gstrResult = "PASS";

	}
	
	/***********************************************************************************
	'Description : Verify that user can edit 'Instructions' while configuring forms
	'Date	 	 : 09-Feb-2015
	'Author		 : Hanumegowda
	'-----------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************/
	@Test(description = "Verify that user can edit 'Instructions' while configuring forms")
	public void testEdgeCase152086() throws Exception {

		gstrTCID = "152086";
		gstrTO = "Verify that user can edit 'Instructions' while configuring forms";

		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();

		UsersList objUsersList = new UsersList(this.driver1);

		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm1 = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);


		objRegionDefault1.selectFrame();

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
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.clickSaveButton();

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
		Thread.sleep(10000);

		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();
		String strPopUp1 = "";
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			strPopUp1 = popupHandle;
			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);
				driver1.manage().window().maximize();
			}
		}

		objFormConfiguration.verTemplateDesignPage();

		objFormConfiguration.clickOnInsert()
							.clickOnInstructionLink();
		objFormConfiguration.selectInstructionFrame().enterInstructions(
				objFormConfiguration_data.strInstructionData);

		driver1.switchTo().window(strPopUp1);
		objFormConfiguration.clickOnDoneButton();
		objFormConfiguration.clickOnSaveButton();
		objBlankForm
				.verifyEnteredInstructionIsRetained(objFormConfiguration_data.strInstructionData);
		Thread.sleep(5000);
		objFormConfiguration.clickOnInstructionEditElement(
				objFormConfiguration_data.strInstructionData)
				.selectInstructionFrame();
		objFormConfiguration
				.enterInstructions1(objFormConfiguration_data.strInstructionData1);

		driver1.switchTo().window(strPopUp1);
		objFormConfiguration.clickOnDoneButton();
		objBlankForm
				.verifyEnteredInstructionIsRetained(objFormConfiguration_data.strInstructionData1);
		objFormConfiguration.clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration.clickOnPublishButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle1 = ite1.next().toString();

			if (!popupHandle1.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle1);

			}
		}
		Thread.sleep(5000);

		objBlankForm1
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verifyEnteredInstructionIsRetained(
						objFormConfiguration_data.strInstructionData1)
				.clickOnSave()
				.clickOnComplete();
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		gstrResult = "PASS";

	}
	
	/*************************************************************************************
	 * 'Description :  	Verify that updated choices for 'Multi Select' questionnaire are not lost after second publish. 
	 * 'Date : 02-Mar-2015 
	 * 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = " 	Verify that updated choices for 'Multi Select' questionnaire are not lost after second publish. ")
	public void testEdgeCase152206() throws Exception {

		gstrTCID = "152206";
		gstrTO = " 	Verify that updated choices for 'Multi Select' questionnaire are not lost after second publish. ";

		Login_data objLogindata = new Login_data();

		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();

		UsersList objUsersList = new UsersList(this.driver1);

		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration

		objFormConfiguration = new FormConfiguration(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList

		.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName,

		objUserdata.strNewPassword, objUserdata.strFullName).selectFirstRole()
				.clickAdvancedOptionAndExpand()

				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()

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
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)

				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)

				.clickOnNextButton().deSelectAllUsersCheckBox()
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)

				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration
				.verTemplateDesignPage()

				.clickOnInsert()

				.clickOnGroupLink()

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

				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.addChoices(objFormConfiguration_data.strChoice)

				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice1)
				.clickOnDoneButton().clickOnSaveButton()
				.clickOnPublishButton();
		Thread.sleep(5000);
		objFormConfiguration
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.addNthChoice(objFormConfiguration_data.strThirdChoice,
						objFormConfiguration_data.strChoice2)
				.addNthChoice(objFormConfiguration_data.strFourthChoice,
						objFormConfiguration_data.strChoice3)
				.clickOnDoneButton();
		objFormConfiguration
				.verifyAddedQueChoiceIsDisplayed(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice)
				.verifyAddedQueChoiceIsDisplayed(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice1)
				.verifyAddedQueChoiceIsDisplayed(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice2)
				.verifyAddedQueChoiceIsDisplayed(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice3);
		Thread.sleep(2000);
		objFormConfiguration.clickOnSaveButton();
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(10000);

		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(10000);

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle1 = ite1.next().toString();

			if (!popupHandle1.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle1);

			}
		}
		Thread.sleep(5000);

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		objFormConfiguration1
				.verifyAddedQueChoiceIsDisplayed(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice)
				.verifyAddedQueChoiceIsDisplayed(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice1)
				.verifyAddedQueChoiceIsDisplayed(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice2)
				.verifyAddedQueChoiceIsDisplayed(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice3);
		objBlankForm.clickOnSave().clickOnComplete();
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut();
  gstrResult = "PASS";

	}
	
	/*************************************************************************************
	 * 'Description : Verify that updated choices for 'Check box' questionnaire are not lost after second publish.  
	 * 'Date        : 26-Mar-2015 
	 * 'Author      : Hanumegowda
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that updated choices for 'Check box' questionnaire are not lost after second publish.")
	public void testEdgeCase152204() throws Exception {

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		objNavigationToSubmenus.navigateToUsers();

		objUsersList

		.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName,

		objUserdata.strNewPassword, objUserdata.strFullName).selectFirstRole()
				.clickAdvancedOptionAndExpand()

				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()

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
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)

				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)

				.clickOnNextButton().deSelectAllUsersCheckBox()
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)

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

				.selectQuestionType(objFormConfiguration_data.strCheckBox)

				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.addChoices(objFormConfiguration_data.strChoice)

				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice1)
				.clickOnDoneButton().clickOnSaveButton()
				.clickOnPublishButton();
		Thread.sleep(5000);
		objFormConfiguration
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.addNthChoice(objFormConfiguration_data.strThirdChoice,
						objFormConfiguration_data.strChoice2)
				.addNthChoice(objFormConfiguration_data.strFourthChoice,
						objFormConfiguration_data.strChoice3)
				.clickOnDoneButton();
		objFormConfiguration
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice)
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice1)
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice2)
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice3);
		Thread.sleep(2000);
		objFormConfiguration.clickOnSaveButton();
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
		Thread.sleep(10000);

		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(10000);

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle1 = ite1.next().toString();

			if (!popupHandle1.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle1);

			}
		}
		Thread.sleep(5000);

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		objFormConfiguration1
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice)
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice1)
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice2)
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice3);
		objBlankForm.clickOnSave().clickOnComplete();
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		objLogin1.clickLogOut();
		gstrResult = "PASS";

	}
	
	/*************************************************************************************
	 * 'Description : Edit the Questionnaire before saving and modify data in all the fields
	 *                of a 'Single Line Text' question and verify the updated changes.
	 * 'Precondition:
	 * 'Date        : 12-May-2015 
	 * 'Author      : Sowmya
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire before saving and modify data in all the fields of a 'Single Line Text' question and verify the updated changes.")
	public void testEdgeCase154757() throws Exception {

		gstrTCID = "154757";
		gstrTO = " Edit the Questionnaire before saving and modify data in all the fields of a 'Single Line Text' question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();
		
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);

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
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
		        .entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
		        .entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

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
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.selectRequiredCheckBox()
				.enterDefaultValue(objFormConfiguration_data.strDecimalValue)
				.enterMinimumLength(objFormConfiguration_data.strMinimumvalue1)
				.enterMaximumLength(objFormConfiguration_data.strMaximumvalue1)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.selectRequiredCheckBox()
				.enterDefaultValue(objFormConfiguration_data.strDefaultNum)
				.enterMinimumLength(objFormConfiguration_data.strMinimumvalue)
				.enterMaximumLength(objFormConfiguration_data.strMaximumvalue)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strToolTipHelp)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel)
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
		
		//Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();
		
		//Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(5000);
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
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer)
				.clickOnSave()
				.verErrorMsgWhenTextExceedsMaxLength(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue,
						objFormConfiguration_data.strMaximumvalue)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		//Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strTextAnswer + "";*/
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(
						objUserdata.strFullName1, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAnswer);

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
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strTextAnswer);

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
	 * 'Description : Edit the Questionnaire before saving and modify data only in mandatory fields of
	 *                a 'Single Line Text' question and verify the updated changes. 
	 * 'Precondition:
	 * 'Date        : 21-May-2015 
	 * 'Author      : Hanumegowda 
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire before saving and modify data only in mandatory fields of a 'Single Line Text' question and verify the updated changes.")
	public void testEdgeCase154756() throws Exception {

		gstrTCID = "154756";
		gstrTO = "Edit the Questionnaire before saving and modify data only in mandatory fields of a 'Single Line Text' question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

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
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.selectRequiredCheckBox()
				.enterDefaultValue(objFormConfiguration_data.strDecimalValue)
				.enterMinimumLength(objFormConfiguration_data.strMinimumvalue1)
				.enterMaximumLength(objFormConfiguration_data.strMaximumvalue1)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1)
				.enterLabelName(objFormConfiguration_data.strLabelName)
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

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(5000);
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
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strTextAnswer + "";*/

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(
						objUserdata.strFullName1, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAnswer);

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
				objBlankFormData.strTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strTextAnswer);

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
	 * 'Description : Edit the Questionnaire after saving and modify data only in mandatory fields 
	 *                of a 'Single Line Text' question and verify the updated changes.  
	 * 'Precondition:
	 * 'Date        : 22-May-2015 
	 * 'Author      : Hanumegowda 
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire after saving and modify data only in mandatory fields of a 'Single Line Text' question and verify the updated changes.")
	public void testEdgeCase154759() throws Exception {

		gstrTCID = "154759";
		gstrTO = "Edit the Questionnaire after saving and modify data only in mandatory fields of a 'Single Line Text' question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

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
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.selectRequiredCheckBox()
				.enterDefaultValue(objFormConfiguration_data.strDecimalValue)
				.enterMinimumLength(objFormConfiguration_data.strMinimumvalue1)
				.enterMaximumLength(objFormConfiguration_data.strMaximumvalue1)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1)
				.clickOnDoneButton().clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnSaveButton().clickOnDoneButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(5000);
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
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strTextAnswer + "";*/
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(
						objUserdata.strFullName1, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAnswer);

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
				objBlankFormData.strTextAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strTextAnswer);

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
	 * 'Description : Edit the Questionnaire before saving and modify data only in mandatory fields of
	 *                a 'Numeric' question and verify the updated changes. 
	 * 'Date        : 22-May-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire before saving and modify data only in mandatory "
			           + "fields of a 'Numeric' question and verify the updated changes.")
	public void testEdgeCase154762() throws Exception {

		gstrTCID = "154762";
		gstrTO = "Edit the Questionnaire before saving and modify data only in mandatory fields of "
				  + "a 'Numeric' question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		
		

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration
				.verTemplateDesignPage();
			Thread.sleep(8000);	
			objFormConfiguration.clickOnInsert()
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
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.selectRequiredCheckBox()
				.enterDefaultValue(objFormConfiguration_data.strDecimalValue)
				.enterMinimumValue(objFormConfiguration_data.strMinimumvalue1)
				.enterMaximumValue(objFormConfiguration_data.strMaximumvalue1)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(7000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(8000);
		driver.close();
		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(5000);
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
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strNumericAnswer + "";*/
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(
						objUserdata.strFullName1, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);

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
				objBlankFormData.strNumericAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer);

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
	 * 'Description : Edit the Questionnaire after saving and modify data only in mandatory fields
	 *                of a 'Numeric' question and verify the updated changes. 
	 * 'Precondition:
	 * 'Date        : 25-May-2015 
	 * 'Author      : Hanumegowda 
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire after saving and modify data only in mandatory fields of a 'Numeric' question and verify the updated changes.")
	public void testEdgeCase154764() throws Exception {

		gstrTCID = "154764";
		gstrTO = "Edit the Questionnaire after saving and modify data only in mandatory fields of a 'Numeric' question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

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
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.selectRequiredCheckBox()
				.enterDefaultValue(objFormConfiguration_data.strDecimalValue)
				.enterMinimumValue(objFormConfiguration_data.strMinimumvalue)
				.enterMaximumValue(objFormConfiguration_data.strMaximumvalue)

				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1)
				.clickOnDoneButton().clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.enterLabelName(objFormConfiguration_data.strLabelName)
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

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(5000);
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
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strNumericAnswer + "";*/
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(
						objUserdata.strFullName1, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);

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
				objBlankFormData.strNumericAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer);

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
	 * 'Description : Edit the Questionnaire after saving and modify data only in mandatory 
	                  fields of a 'Single Select' question and verify the updated changes.   
	 * 'Precondition:
	 * 'Date        : 25-May-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire after saving and modify data only in mandatory fields of a 'Single Select' question and verify the updated changes.")
	public void testEdgeCase154798() throws Exception {

		gstrTCID = "154798";
		gstrTO = "Edit the Questionnaire after saving and modify data only in mandatory fields of a 'Single Select' question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

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
				.selectRequiredCheckBox()
				.addChoices(objFormConfiguration_data.strChoice)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice2)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1)
				.clickOnDoneButton().clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnSaveButton().clickOnDoneButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

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
				.selectSingleOption(objFormConfiguration_data.strChoice2)
				.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm
				.selUserToReceiveCompletedForm(objUserdata.strNewUserName2);
		Thread.sleep(10000);
		objDispatchForm.clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objFormConfiguration_data.strChoice2 + "";*/

		String strMsg = objRegionDefault1.getWebNotificationForOneQuestionnaire(
				objUserdata.strFullName1, objLogindata.strRegionName,
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
	 * 'Description : Edit the Questionnaire before saving and change the value in the 'Answer Max Length' 
	                 field and verify that the changes are updated.   
	 * 'Date        : 26-May-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire before saving and change the value in the 'Answer Max Length' "
			            + "field and verify that the changes are updated. ")
	public void testEdgeCase154758() throws Exception {

		gstrTCID = "154758";
		gstrTO = "Edit the Questionnaire after saving and modify data only in mandatory fields of a 'Single Line Text'"
				 + " question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		
		objFormConfiguration.verTemplateDesignPage();
				Thread.sleep(10000);
		objFormConfiguration.clickOnInsert()
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
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.selectRequiredCheckBox()
				.enterDefaultValue(objFormConfiguration_data.strDecimalValue)
				.enterMinimumLength(objFormConfiguration_data.strMinimumvalue)
				.enterMaximumLength(objFormConfiguration_data.strMaximumValue3)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1)
				.enterMaximumLength(objFormConfiguration_data.strMaximumvalue2)		
				.clickOnDoneButton()
				
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strTextArea)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.selectRequiredCheckBox()
				.enterDefaultValue(objFormConfiguration_data.strDecimalValue)
				.enterMinimumLength(objFormConfiguration_data.strMinimumvalue)
				.enterMaximumLength(objFormConfiguration_data.strMaximumValue3)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel)
				.enterMaximumLength(objFormConfiguration_data.strMaximumvalue2)		
				.clickOnDoneButton()
				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(10000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(5000);
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName);
			Thread.sleep(5000);	
			objBlankForm.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)

				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer3)	
				.enterAnswerInTextAreaField(objBlankFormData.strTextAnswer3).clickOnSave();
			Thread.sleep(5000);	
						
			objBlankForm.verErrorMsgWhenTextExceedsMaxLength(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strMinimumvalue,
						objFormConfiguration_data.strMaximumvalue2)
						
				.verErrorMsgWhenTextExceedsMaxLength(
						objFormConfiguration_data.strLabelName2,
						objFormConfiguration_data.strMinimumvalue,
						objFormConfiguration_data.strMaximumvalue2)
						
				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer2)	
				.enterAnswerInTextAreaField(objBlankFormData.strTextAnswer2);
			objBlankForm.clickOnSave();
			Thread.sleep(5000);	
			objBlankForm.clickOnSave();		
		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2);
			Thread.sleep(8000);	
		objDispatchForm.clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName1
				+ ": " + objBlankFormData.strTextAnswer2+"| "+ objFormConfiguration_data.strLabelName2
				+ ": " + objBlankFormData.strTextAnswer2;
*/
		String strMsg = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(
						objUserdata.strFullName1, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer2,
						objFormConfiguration_data.strLabelName2,
						objBlankFormData.strTextAnswer2);

		System.out.println("given text" + strMsg );
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms()
		
		.switchToDefaultFrame().selectFrame();
		
		Thread.sleep(5000);
		
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}

	
	/*************************************************************************************
	 * 'Description : Edit the Questionnaire after saving and modify data in all the fields of a 
	 *                'Numeric' question and verify the updated changes. 
	 * 'Precondition:
	 * 'Date        : 26-May-2015 
	 * 'Author      : Hanumegowda 
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire after saving and modify data in all the fields of a 'Numeric' question and verify the updated changes.")
	public void testEdgeCase154765() throws Exception {

		gstrTCID = "154765";
		gstrTO = "Edit the Questionnaire after saving and modify data in all the fields of a 'Numeric' question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

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
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.enterDecimalPlaceValue(
						objFormConfiguration_data.strDefaultNum)
				.enterDefaultValue(objFormConfiguration_data.strDecimalValue)
				.enterMinimumValue(objFormConfiguration_data.strMinimumvalue1)
				.enterMaximumValue(objFormConfiguration_data.strMaximumvalue1)

				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1)
				.clickOnDoneButton().clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.selectRequiredCheckBox()
				.enterDefaultValue(objFormConfiguration_data.strDefaultNum)
				.enterMinimumValue(objFormConfiguration_data.strMinimumvalue)
				.enterMaximumValue(objFormConfiguration_data.strMaximumvalue)
				.enterDecimalPlaceValue(
						objFormConfiguration_data.strDecimalValue)

				.enterTextInToolTipHelp(
						objFormConfiguration_data.strToolTipHelp)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel)
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

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(5000);
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		int minvalue = Integer
				.parseInt(objFormConfiguration_data.strMinimumvalue);
		int minvalue1 = minvalue - 1;
		int maxvalue = Integer
				.parseInt(objFormConfiguration_data.strMaximumvalue);
		int maxvalue1 = maxvalue + 1;
		// String[] ans = {maxvalue1

		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		objFormConfiguration.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		objBlankForm.verDefaultValue(objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strDefaultNum)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						"" + minvalue1 + "")
				.clickOnSave()
				.verErrorMsgWhenNumericValueExceedsSpecifiedMinAndMaxValue(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue,
						objFormConfiguration_data.strMaximumvalue);
		Thread.sleep(5000);
		objBlankForm
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						"" + maxvalue1 + "")
				.clickOnSave()
				.verErrorMsgWhenNumericValueExceedsSpecifiedMinAndMaxValue(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue,
						objFormConfiguration_data.strMaximumvalue);
		Thread.sleep(5000);
		objBlankForm
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue)
				.clickOnSave()
				.verErrorMsgNotDisplayedWhenNumericValueNotExceedsSpecifiedMinAndMaxValue(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue,
						objFormConfiguration_data.strMaximumvalue);
		objBlankForm
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMaximumvalue)
				.clickOnSave()
				.verErrorMsgNotDisplayedWhenNumericValueNotExceedsSpecifiedMinAndMaxValue(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue,
						objFormConfiguration_data.strMaximumvalue);

		int i1 = Integer.parseInt(objFormConfiguration_data.strDecimalValue);

		String[] str = {
				"" + objFormConfiguration_data.strMinimumvalue + ".22",
				"" + objFormConfiguration_data.strMinimumvalue + ".222",
				"" + objFormConfiguration_data.strMinimumvalue + ".22222" };
		for (int i = 0; i < str.length; i++) {

			objBlankForm.enterAnswerInField(
					objFormConfiguration_data.strLabelName, str[i]);

			objBlankForm.clickOnSave();
			String[] split = str[i].split("\\.");
			if (split[1].length() <= i1) {
				Thread.sleep(10000);
				objBlankForm
						.verEnteredDecimalvalueIsWithinAcceptedValueForNumericQuestionType(
								objFormConfiguration_data.strLabelName, str[i]);

			} else {
				objBlankForm
						.verEnteredDecimalvalueIsNotWithinAcceptedValueForNumericQuestionType(
								objFormConfiguration_data.strLabelName, str[i]);
			}
		}
		Thread.sleep(10000);
		objBlankForm
		.enterAnswerInField(objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strMinimumvalue)
		.clickOnSave();

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strNumericAnswer + "";*/
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(
						objUserdata.strFullName1, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);

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
				objBlankFormData.strNumericAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer);

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
	 * 'Description : Edit the Questionnaire after saving and modify data only in mandatory 
	                 fields of a 'Table' question and verify the updated changes. .   
	 * 'Date        : 27-May-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire after saving and modify"
			+ " data only in mandatory fields of a 'Table' question and verify the updated changes.")
	public void testEdgeCase154834() throws Exception {


		gstrTCID = "154834";
		gstrTO = "Edit the Questionnaire after saving and modify data only in mandatory fields of a"
				  + " 'Table' question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		
		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		
		objFormConfiguration.verTemplateDesignPage();
		Thread.sleep(20000);
		objFormConfiguration
				.clickOnInsert()
				.clickOnTableLink()
				.verifyEditFieldSetWindow()
				.enterFirstRowLabel(objFormConfiguration_data.strRow1)
				.enterThirdRowLabel(objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strRow3)
				.addFirstTableColumn(objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strText)
				.addNthTableColumn(objFormConfiguration_data.strColumnName2,
						objFormConfiguration_data.strTextArea)
				.clickOnEditFieldDoneButton().clickOnSaveButton();
				Thread.sleep(10000);
				
			
		objFormConfiguration.clickOnEditTable()
		
			//first column edit	
				.clickOnPencilIconInEditFieldSetOfTable(
						objFormConfiguration_data.firstColEdit)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.selectRequiredCheckBox()
				.enterDefaultValue(objFormConfiguration_data.strDecimalValue)
				.enterMinimumLength(objFormConfiguration_data.strMinimumvalue)
				.enterMaximumLength(objFormConfiguration_data.strMaximumvalue)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1).clickOnDoneButton();	
				Thread.sleep(5000);
				
			// second column edit
				
	objFormConfiguration.clickOnPencilIconInEditFieldSetOfTable(
						objFormConfiguration_data.secColEdit)
				.selectRequiredCheckBox1()
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.enterDefaultValue(objFormConfiguration_data.strDecimalValue)
				.enterMinimumLength(objFormConfiguration_data.strMinimumvalue)
				.enterMaximumLength(objFormConfiguration_data.strMaximumvalue)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1);
	           Thread.sleep(5000);
	    objFormConfiguration.clickOnDoneButton()
				  .clickOnEditFieldDoneButton().clickOnSaveButton();
				
		System.out.println("started");
		Thread.sleep(10000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(10000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver.getWindowHandle();

		Thread.sleep(5000);
		Set<String> a1 = driver.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver.switchTo().window(popupHandle);

			}
		}
		
		String str3[] = { objFormConfiguration_data.strLabelName1,
				objFormConfiguration_data.strLabelName2 };


		objBlankForm
		.verFormTitle(objFormConfiguration_data.strFormName);
		Thread.sleep(8000);
	
		//objBlankForm .verColumnDetails(str3)
		objBlankForm.enterAnswerInFirstColumn(objFormConfiguration_data.strRow1,
				objFormConfiguration_data.strText,
				objBlankFormData.strTextAnswer)
		.enterAnswerInFirstColumn(objFormConfiguration_data.strRow2,
				objFormConfiguration_data.strText,
				objBlankFormData.strTextAnswer1)
		.enterAnswerInFirstColumn(objFormConfiguration_data.strRow3,
				objFormConfiguration_data.strText,
				objBlankFormData.strTextAnswer2)
		.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow1,
				objBlankFormData.strTextAreaAnswer3)
		.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow2,
				objBlankFormData.strTextAreaAnswer3)
		.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow3,
				objBlankFormData.strTextAreaAnswer3);

		objBlankForm.clickOnSave();	
		Thread.sleep(20000);	
		objBlankForm.clickOnComplete();
		Thread.sleep(8000);	
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2);
			Thread.sleep(8000);	
		objDispatchForm.clickOnDispatchForm();

		driver.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		String strMsg = "Submitted by " + objUserdata.strFullName1
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName1
				+ ": " + objBlankFormData.strTextAnswer+"| "+ objFormConfiguration_data.strLabelName1
				+ ": " + objBlankFormData.strTextAnswer1+"| "+ objFormConfiguration_data.strLabelName1
				+ ": " + objBlankFormData.strTextAnswer2+"| "+ objFormConfiguration_data.strLabelName2
				+ ": " + objBlankFormData.strTextAreaAnswer3 +"| "+ objFormConfiguration_data.strLabelName2
				+ ": " + objBlankFormData.strTextAreaAnswer3+"| "+ objFormConfiguration_data.strLabelName2
				+ ": " + objBlankFormData.strTextAreaAnswer3; 
		
		System.out.println("given text" + strMsg );
		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms()
				.selectFrame();
		
				objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions
				.getFormMailBodyForTable(objUserdata.strFullName1,
						objLogindata.strRegionName,
						objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strRow3,
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strLabelName2,
						objBlankFormData.strTextAnswer,
						objBlankFormData.strTextAnswer1,
						objBlankFormData.strTextAnswer2,
						objBlankFormData.strTextAreaAnswer3,
						objBlankFormData.strTextAreaAnswer3,
						objBlankFormData.strTextAreaAnswer3);

		String strMsgBody1 = objMailVerificationFunctions
				.getFormPagerBodyForTable(objUserdata.strFullName1,
						objLogindata.strRegionName,
						objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strRow3,
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strLabelName2,
						objBlankFormData.strTextAnswer,
						objBlankFormData.strTextAnswer1,
						objBlankFormData.strTextAnswer2,
						objBlankFormData.strTextAreaAnswer3,
						objBlankFormData.strTextAreaAnswer3,
						objBlankFormData.strTextAreaAnswer3);

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
	}
	
	/*************************************************************************************
	 * 'Description : Edit the Questionnaire before saving and modify data in all the fields of a
	 *                'Numeric' question and verify the updated changes. 
	 * 'Precondition:
	 * 'Date        : 27-May-2015 
	 * 'Author      : Hanumegowda 
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire before saving and modify data in all the fields of a 'Numeric' question and verify the updated changes.")
	public void testEdgeCase154763() throws Exception {

		gstrTCID = "154763";
		gstrTO = "Edit the Questionnaire before saving and modify data in all the fields of a 'Numeric' question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

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
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.enterDecimalPlaceValue(objFormConfiguration_data.strDefaultNum)
				.enterDefaultValue(objFormConfiguration_data.strDecimalValue)
				.enterMinimumValue(objFormConfiguration_data.strMinimumvalue1)
				.enterMaximumValue(objFormConfiguration_data.strMaximumvalue1)

				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1);
		Thread.sleep(5000);
		objFormConfiguration
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.selectRequiredCheckBox()
				.enterDefaultValue(objFormConfiguration_data.strDefaultNum)
				.enterMinimumValue(objFormConfiguration_data.strMinimumvalue)
				.enterMaximumValue(objFormConfiguration_data.strMaximumvalue)
				.enterDecimalPlaceValue(
						objFormConfiguration_data.strDecimalValue)

				.enterTextInToolTipHelp(
						objFormConfiguration_data.strToolTipHelp)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel)
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

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(5000);
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		int minvalue = Integer
				.parseInt(objFormConfiguration_data.strMinimumvalue);
		int minvalue1 = minvalue - 1;
		int maxvalue = Integer
				.parseInt(objFormConfiguration_data.strMaximumvalue);
		int maxvalue1 = maxvalue + 1;

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		objFormConfiguration
				.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		objBlankForm
				.verDefaultValue(objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strDefaultNum)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						"" + minvalue1 + "")
				.clickOnSave()
				.verErrorMsgWhenNumericValueExceedsSpecifiedMinAndMaxValue(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue,
						objFormConfiguration_data.strMaximumvalue);
		Thread.sleep(5000);
		objBlankForm
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						"" + maxvalue1 + "")
				.clickOnSave()
				.verErrorMsgWhenNumericValueExceedsSpecifiedMinAndMaxValue(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue,
						objFormConfiguration_data.strMaximumvalue);
		Thread.sleep(5000);
		objBlankForm
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue)
				.clickOnSave()
				.verErrorMsgNotDisplayedWhenNumericValueNotExceedsSpecifiedMinAndMaxValue(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue,
						objFormConfiguration_data.strMaximumvalue);
		objBlankForm
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMaximumvalue)
				.clickOnSave()
				.verErrorMsgNotDisplayedWhenNumericValueNotExceedsSpecifiedMinAndMaxValue(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue,
						objFormConfiguration_data.strMaximumvalue);

		int i1 = Integer.parseInt(objFormConfiguration_data.strDecimalValue);

		String[] str = {
				"" + objFormConfiguration_data.strMinimumvalue + ".22",
				"" + objFormConfiguration_data.strMinimumvalue + ".222",
				"" + objFormConfiguration_data.strMinimumvalue + ".22222" };
		for (int i = 0; i < str.length; i++) {

			objBlankForm.enterAnswerInField(
					objFormConfiguration_data.strLabelName, str[i]);

			objBlankForm.clickOnSave();
			String[] split = str[i].split("\\.");
			if (split[1].length() <= i1) {
				Thread.sleep(10000);
				objBlankForm
						.verEnteredDecimalvalueIsWithinAcceptedValueForNumericQuestionType(
								objFormConfiguration_data.strLabelName, str[i]);

			} else {
				objBlankForm
						.verEnteredDecimalvalueIsNotWithinAcceptedValueForNumericQuestionType(
								objFormConfiguration_data.strLabelName, str[i]);
			}
		}
		Thread.sleep(10000);
		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);
/*
		String strMsg = "Submitted by " + objUserdata.strFullName1
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strNumericAnswer + "";
		*/
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(
						objUserdata.strFullName1, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);

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
				objBlankFormData.strNumericAnswer);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strNumericAnswer);

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
	 * 'Description : Edit the Questionnaire after saving and modify data only in mandatory fields
	 *                of a 'Check Box' question and verify the updated changes. 
	 * 'Precondition:
	 * 'Date        : 28-May-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire after saving and modify data only in mandatory fields of a 'Check Box' question and verify the updated changes.")
	public void testEdgeCase154777() throws Exception {

		gstrTCID = "154777";
		gstrTO = "Edit the Questionnaire after saving and modify data only in mandatory fields of a 'Check Box' question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		//ie

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

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
				.selectQuestionType(objFormConfiguration_data.strCheckBox)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.addChoices(objFormConfiguration_data.strChoice1)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
							  objFormConfiguration_data.strChoice2)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1)
				.selectRequiredCheckBox()
				.clickOnDoneButton().clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnSaveButton().clickOnDoneButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(5000);
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		
		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName);
				Thread.sleep(80000);
		objBlankForm.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInChkBox(objFormConfiguration_data.strChoice2)
		        .enterAnswerInChkBox(objFormConfiguration_data.strChoice1).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);
		
		/*String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName1
				+ ": " + objFormConfiguration_data.strChoice1 + ","
				+ objFormConfiguration_data.strChoice2;*/

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(
						objUserdata.strFullName, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice1 + ","
								+ objFormConfiguration_data.strChoice2);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

	
		
		String strMsgBody = objMailVerificationFunctions.getFormMailBodyFor2Choices(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName1,objFormConfiguration_data.strChoice1,
				objFormConfiguration_data.strChoice2);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBodyFor2Choices(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName1,objFormConfiguration_data.strChoice1,
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
	 * 'Description : Edit the Questionnaire before saving and modify data only in mandatory fields
	 *                of a 'Date' question and verify the updated changes. 
	 * 'Precondition:
	 * 'Date        : 28-May-2015 
	 * 'Author      : Hanumegowda 
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire before saving and modify data only in mandatory fields of a 'Date' question and verify the updated changes.")
	public void testEdgeCase154767() throws Exception {

		gstrTCID = "154767";
		gstrTO = "Edit the Questionnaire before saving and modify data only in mandatory fields of a 'Date' question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

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
				.selectDateType(objFormConfiguration_data.strDate)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.enterDefaultValue(objFormConfiguration_data.strDecimalValue)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1)
				.clickOnAnyDatesAllowedRadioButton();
		Thread.sleep(5000);
		objFormConfiguration
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		System.out.println(objBlankFormData.strCurrentDate);
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(mainWindowHandle);
		objRegionDefault.selectFrame();
		objLogin.clickLogOut();

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();
		objLogin1.clickLogOut();

		// Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

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
				.enterAnswerInDateField(objBlankFormData.strCurrentDate);
		Thread.sleep(5000);
		objBlankForm.clickOnSave();
		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strCurrentDate + "";
		*/
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(
						objUserdata.strFullName1, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strCurrentDate);

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
				objBlankFormData.strCurrentDate);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strCurrentDate);

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
	 * 'Description : Edit the Questionnaire after saving and modify data in all the fields of a 
	 *                'Single Select' question and verify the updated changes. 
	 * 'Precondition:
	 * 'Date        : 29-May-2015 
	 * 'Author      : Sangappa.k
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire after saving and modify data in all the fields of a 'Single Select' question and verify the updated changes.")
	public void testEdgeCase154799() throws Exception {

		gstrTCID = "154799";
		gstrTO = "Edit the Questionnaire after saving and modify data in all the fields of a 'Single Select' question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		//ie

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

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
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1)
				.addChoices(objFormConfiguration_data.strChoice2)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice3)		
				.clickOnDoneButton().clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.selectRequiredCheckBox()
				
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strToolTipHelp)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel)
				.addChoices(objFormConfiguration_data.strChoice)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice1)		
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

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		// Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(5000);
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName);
		Thread.sleep(90000);
		objBlankForm
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.verifyChoiceIsDisplayedForSingleSelectQtn(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice)
				.verifyChoiceIsDisplayedForSingleSelectQtn(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice1)
			    .selectSingleOption(objFormConfiguration_data.strChoice);
		objFormConfiguration1
				.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);		
				objBlankForm.clickOnSave();
		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

// Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);
		
		/*String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objFormConfiguration_data.strChoice; 
*/
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
		
		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,objFormConfiguration_data.strChoice);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,objFormConfiguration_data.strChoice);

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
	 * 'Description : Edit the Questionnaire after saving and modify data only in mandatory fields of
	 *                a 'Date' question and verify the updated changes.  
	 * 'Precondition:
	 * 'Date        : 29-May-2015 
	 * 'Author      : Hanumegowda 
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Edit the Questionnaire after saving and modify data only in mandatory fields of a 'Date' question and verify the updated changes.")
	public void testEdgeCase154769() throws Exception {

		gstrTCID = "154769";
		gstrTO = "Edit the Questionnaire after saving and modify data only in mandatory fields of a 'Date' question and verify the updated changes.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();

		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

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
						objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();

		Thread.sleep(5000);

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
				.selectDateType(objFormConfiguration_data.strDate)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.enterDefaultValue(objFormConfiguration_data.strDecimalValue)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strWheneverStatusIsBelow)
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel1)
				.clickOnAnyDatesAllowedRadioButton().clickOnDoneButton()
				.clickOnSaveButton();
		Thread.sleep(10000);
		objFormConfiguration
				.clickOnEditQuestionnaire(
						objFormConfiguration_data.strLabelName1)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnDoneButton();
		Thread.sleep(5000);
		objFormConfiguration.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		System.out.println(objBlankFormData.strCurrentDate);
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(mainWindowHandle);
		objRegionDefault.selectFrame();
		objLogin.clickLogOut();

		// Log in as user 1
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();
		objLogin1.clickLogOut();

		// Login as user 2
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 = driver1.getWindowHandle();

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
				.enterAnswerInDateField(objBlankFormData.strCurrentDate);
		Thread.sleep(5000);
		objBlankForm.clickOnSave();
		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName2).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		// Login as user 3
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName1
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strCurrentDate + "";
		*/
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(
						objUserdata.strFullName1, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strCurrentDate);

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
				objBlankFormData.strCurrentDate);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName1, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strCurrentDate);

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
	
	@Test(description = "Edit a user to associate the user with a role R1 that was created selecting the right 'Form - User may create and modify forms' and verify that user can configure forms.")
	public void testEdgeCase21519() throws Exception {

		gstrTCID = "21519";
		gstrTO = "Edit a user to associate the user with a role R1 that was created selecting the right 'Form - User may create and modify forms' and verify that user can configure forms.";
		
		gstrResult = "FAIL";
	}
}
