package requirementGroup.Forms;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import lib.dataObject.BlankFormData;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.ActivateForms;
import lib.page.AutoIT;
import lib.page.BlankForm;
import lib.page.DispatchForm;
import lib.page.EventManagement;
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.junit.Assert;
import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseCreateV3FormQuestionnaire extends TestNG_UI_EXTENSIONS {

	public EdgeCaseCreateV3FormQuestionnaire() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***********************************************************************************************
	'Description : Verify that user can 'Preview' currently editing form template.
	'Date	 	 : 19-Jan-2015
	'Author		 : Pallavi
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description = "Verify that user can 'Preview' currently editing form template.")
	public void testEdgeCase152081() throws Exception {

		gstrTCID = "152081";
		gstrTO = "Verify that user can 'Preview' currently editing form template.";
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

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
				.clickOnNextButton()
				.clickOnNextButton()
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
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.clickOnDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strTextArea)
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
		
		System.out.println("--------End of precondition---------");
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration1.verFormConfigurePage();
		
		Thread.sleep(5000);
		
		objFormConfiguration1
						.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		
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
		objFormConfiguration1.verTemplateDesignPage()
							 .verifyFormTitle(objFormConfiguration_data.strFormName)
							 .verifyPreviewButtonIsDisplayed()
							 .clickPreviewButton();
		
		driver1.close();
		driver1.switchTo().window(mainWindowHandle1);
		
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
		objFormConfiguration1
				.verifyFormTitleInPreviewPage(objFormConfiguration_data.strFormName);

		objBlankForm
				.verGroupName(objFormConfiguration_data.strGroupName);
		
		objFormConfiguration1
				.verifyNumericOrSingleLineTextQuestionIsDisabled(objFormConfiguration_data.strLabelName)
				.verifyMultiLineTextQuestionIsDisabled(objFormConfiguration_data.strLabelName1)
				.verifyInsertLinkNotDisplayed()
				.verifyAddButtonForGroupIsNotDisplayed(objFormConfiguration_data.strGroupName);
		
		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);
		
		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	'Description : Verify that user can preview the form template while configuring forms
	'Date	 	 : 23-Jan-2015
	'Author		 : Pallavi
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description = "Verify that user can preview the form template while configuring forms")
	public void testEdgeCase152508() throws Exception {

		gstrTCID = "152508";
		gstrTO = "Verify that user can preview the form template while configuring forms";

		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.clickOnNextButtonInIEBrowser();
		Thread.sleep(5000);
		objFormConfiguration1.clickOnNextButtonInIEBrowser();
		Thread.sleep(5000);
		objFormConfiguration1.clickOnNextButtonInIEBrowser();
		Thread.sleep(5000);
		objFormConfiguration1.clickOnSaveOfFormSecuritySettingInIEBrowser();
		
		System.out.println(objFormConfiguration_data.strFormName);
		Thread.sleep(5000);
		
		objFormConfiguration1
				.clickOnAcknowledgeFormInIEBrowser(objFormConfiguration_data.strFormName);

		Thread.sleep(5000);
		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
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
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.clickOnDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strTextArea)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary()
				.clickOnDoneButton()
				.clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration1.verifyPreviewButtonIsDisplayed()
							 .clickPreviewButton();
		
		driver1.close();
		driver1.switchTo().window(mainWindowHandle);
		
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
		objFormConfiguration1
				.verifyFormTitle(objFormConfiguration_data.strFormName);

		objBlankForm
				.verGroupName(objFormConfiguration_data.strGroupName);
		
		objFormConfiguration1
				.verifyNumericOrSingleLineTextQuestionIsDisabled(objFormConfiguration_data.strLabelName)
				.verifyMultiLineTextQuestionIsDisabled(objFormConfiguration_data.strLabelName1)
				.verifyInsertLinkNotDisplayed()
				.verifyAddButtonForGroupIsNotDisplayed(objFormConfiguration_data.strGroupName);
		
		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);
		
		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that questionnaires added to a form is displayed only when it is published  
	'Precondition:
	'Date	 	 : 27-Jan-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that questionnaires added to a form is displayed only when it is published")
	public void testEdgeCase152574() throws Exception {

		gstrTCID = "152574";
		gstrTO = "Verify that questionnaires added to a form is displayed only when it is published";

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
						    .selectQuestionType(objFormConfiguration_data.strNumeric)
						    .enterLabelName(objFormConfiguration_data.strLabelName)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()
						    .clickOnSaveButton();

		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

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
	
		objBlankForm.verErrorWenFormIsNotPublished();
		
		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/****************************************************************************************************
	'Description : Verify that 'Date' questionnaires of types 'Date, Time, Date/Time' can be added to the V3 form.
	'Date	 	 : 16-Feb-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "Verify that 'Date' questionnaires of types 'Date, Time, Date/Time' can be added to the V3 form.")
	public void testEdgeCase152189() throws Exception {

		gstrTCID = "152189";
		gstrTO = "Verify that 'Date' questionnaires of types 'Date, Time, Date/Time' can be added to the V3 form.";

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
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
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
				.clickSaveButton();

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
						    .selectQuestionType(objFormConfiguration_data.strDateQuestion)
						    .enterLabelName(objFormConfiguration_data.strLabelName)
						    .selectDateType(objFormConfiguration_data.strDate)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()
						    
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()
						    .selectQuestionType(objFormConfiguration_data.strDateQuestion)
						    .enterLabelName(objFormConfiguration_data.strLabelName1)
						    .selectDateType(objFormConfiguration_data.strDateTime)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()
						    
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()
						    .selectQuestionType(objFormConfiguration_data.strDateQuestion)
						    .enterLabelName(objFormConfiguration_data.strLabelName2)
						    .selectDateType(objFormConfiguration_data.strTime)
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
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1.clickOnFillForm(objFormConfiguration_data.strFormName);
		
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
					.enterAnswerInField(objFormConfiguration_data.strLabelName,objBlankFormData.strCurrentDate)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,objBlankFormData.strCurrentDateTime)
					.enterAnswerInField(objFormConfiguration_data.strLabelName2,objBlankFormData.strCurrentTime)
					.clickOnSave();

		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
							objUserdata.strNewUserName1)
					   .clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName1,
						 		 objUserdata.strNewPassword);
		
//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//						+ objFormConfiguration_data.strLabelName + ": "
//						+ objBlankFormData.strCurrentDate + "| "
//						+ objFormConfiguration_data.strLabelName1 + ": "
//						+ objBlankFormData.strCurrentDateTime + "| "
//						+ objFormConfiguration_data.strLabelName2 + ": "
//						+ objBlankFormData.strCurrentTime;

		String strMsg = objRegionDefault1
				.getWebNotificationForThreeQuestionnaire(
						objUserdata.strFullName, objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strCurrentDate,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strCurrentDateTime,
						objFormConfiguration_data.strLabelName2,
						objBlankFormData.strCurrentTime);
		
		Thread.sleep(5000);
        
        objRegionDefault1.selectFrame()
                       	 .verWebNotificationframe()
                         .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
                                     						strMsg)
						.clickAcknowledgeAllForms()
						.selectFrame();

        objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
        										objUserdata.strPrimaryPwsd);
        
		String strMsgBody = objMailVerificationFunctions.getFormMailBodyForThreeLabel(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strCurrentDate, objFormConfiguration_data.strLabelName1,
				objBlankFormData.strCurrentDateTime, objFormConfiguration_data.strLabelName2,
				objBlankFormData.strCurrentTime);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBodyForThreeLabel(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strCurrentDate, objFormConfiguration_data.strLabelName1,
				objBlankFormData.strCurrentDateTime, objFormConfiguration_data.strLabelName2,
				objBlankFormData.strCurrentTime);

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
	
	/****************************************************************************************************
	'Description : Verify that 'Required' check box for check box questionnaire is available when there are
	 				more than one choice added to it. 
	'Date	 	 : 13-Feb-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description = "Verify that 'Required' check box for check box questionnaire is available when there "
			+ "are more than one choice added to it. ")
	public void testEdgeCase153312() throws Exception {

		gstrTCID = "153312";
		gstrTO = "Verify that 'Required' check box for check box questionnaire is available when there are more "
				+ "than one choice added to it. ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		BlankForm objBlankForm1 = new BlankForm(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		DispatchForm objDispatchForm1 = new DispatchForm(this.driver1);
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
				.clickSaveButton();

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
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objFormConfiguration_data.strFormName);
		
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

		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration1
				.clickOnAcknowledgeFormInIEBrowser(objFormConfiguration_data.strFormName);
		
		Thread.sleep(10000);

		String mainWindowHandle = driver1.getWindowHandle();
		
		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();
		
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
		
			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);
		
			}
		}
		
		objFormConfiguration1
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
				.verRequiredCheckboxIsNotDisplayd()
				.addNthChoice(objFormConfiguration_data.strSecChoice,
							  objFormConfiguration_data.strChoice2)
				.verRequiredCheckboxIsDisplayed()
				.selectRequiredCheckBox()
				.clickOnDoneButton()
				.clickOnSaveButton();
		
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
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
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm1
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.verifyRequiedTextForMandatoryQuestion(objFormConfiguration_data.strLabelName)
				.enterAnswerInChkBox(objFormConfiguration_data.strChoice2)
			    .clickOnSave();
		Thread.sleep(5000);
		objBlankForm1.clickOnComplete();
		
		objDispatchForm1.selUserToReceiveCompletedForm(objUserdata.strNewUserName1)
						.clickOnDispatchForm();
		
		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName1,
						 	objUserdata.strNewPassword);

//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//				+ objFormConfiguration_data.strLabelName + ": "
//				+ objFormConfiguration_data.strChoice2;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice2);
		
		Thread.sleep(5000);
		
		objRegionDefault1.selectFrame()
		               	 .verWebNotificationframe()
		                 .verWebNotificationMsgForForms(
		                		 objFormConfiguration_data.strFormName, strMsg)
						 .clickAcknowledgeAllForms()
						 .selectFrame();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strChoice2);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
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
	'Description : Verify that a question added by filling only mandatory fields of ‘Numeric’ question can be previewed by filling only mandatory fields of a question 
	'Precondition:
	'Date	 	 : 02-Apr-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a question added by filling only mandatory fields of ‘Numeric’ question can be previewed by filling only mandatory fields of a question ")
	public void testEdgecase152600() throws Exception {

		gstrTCID = "152600";
		gstrTO = "Verify that a question added by filling only mandatory fields of ‘Numeric’ question can be previewed by filling only mandatory fields of a question ";

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
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);
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
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
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
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		
		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration1
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
		
		objFormConfiguration1.verTemplateDesignPage()
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
						    .clickOnAddToSummary()
						    .selectRequiredCheckBox()
						    .clickOnDoneButton()				    
						    .clickOnSaveButton();
		
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);
		
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(10000);
		
		String currentWindowHandle = driver1.getWindowHandle();
		for(String childwindow:driver1.getWindowHandles())
		{
			driver1.switchTo().window(childwindow);
			driver1.manage().window().maximize();
		}

		objFormConfiguration1.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		
		driver1.close();
		
		driver1.switchTo().window(currentWindowHandle);
		
		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle);
		
		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1.clickOnFillForm(objFormConfiguration_data.strFormName);
		
		String mainWindowHandle1 = driver1.getWindowHandle();
		
		Thread.sleep(3000);
		
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
					.verFieldSetName(objFormConfiguration_data.strAttributeName);
		
		objFormConfiguration1.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		
		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer);

		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
							objUserdata.strNewUserName1)
					   .clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName1,
						 		 objUserdata.strNewPassword);
		
//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//						+ objFormConfiguration_data.strLabelName + ": "
//						+ objBlankFormData.strNumericAnswer;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);
		
		Thread.sleep(5000);
        
        objRegionDefault1.selectFrame()
                       	 .verWebNotificationframe()
                         .verWebNotificationMsgForForms(
                        		 objFormConfiguration_data.strFormName, strMsg)
                         .clickReviewForm();
        
        Thread.sleep(10000);
          
        String mainWindowHandle2 = driver1.getWindowHandle();
        
        String strPopUpName = "";
        
        Set<String> a2 = driver1.getWindowHandles();
        Iterator<String> ite2 = a2.iterator();

        while (ite2.hasNext()) {
                 String popupHandle = ite2.next().toString();
                 if (!popupHandle.contains(mainWindowHandle2)) {
                       driver1.switchTo().window(popupHandle);
                       strPopUpName = driver1.getWindowHandle();
                 }
          }
          
        objBlankForm.verFormTitleInReviewForm(objFormConfiguration_data.strFormName)
        			.verifyEnteredValueIsDisplayed(objFormConfiguration_data.strLabelName,
        											objBlankFormData.strNumericAnswer);
        
//        objFormConfiguration1.clickOnPreviewButton();
//        
//        Set<String> a3 = driver1.getWindowHandles();
//        Iterator<String> ite3 = a3.iterator();
//
//        while (ite3.hasNext()) {
//                 String popupHandle1 = ite3.next().toString();
//                 if (!(popupHandle1.contains(mainWindowHandle2))||(popupHandle1.contains(strPopUpName))) {
//                       driver1.switchTo().window(popupHandle1);
//                 }
//          }
//
//        driver1.close();
//        
//        driver1.switchTo().window(strPopUpName);
        
        objFormConfiguration1.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
        
        driver1.close();
        
        driver1.switchTo().window(mainWindowHandle2);
        
        objRegionDefault1.selectFrame()
						.verWebNotificationframe()
						.clickAcknowledgeAllForms()
						.selectFrame();

		gstrResult = "PASS";
	}
	

	
	/*************************************************************************************
	'Description :  Verify that the form can be previewed by filling only mandatory fields of a ‘Date’ question . 
	'Precondition:
	'Date	 	 : 02-Apr-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that the form can be previewed by filling only mandatory fields of a ‘Date’ question . ")
	public void testEdgecase152609() throws Exception {

		gstrTCID = "152609";
		gstrTO = " 	Verify that the form can be previewed by filling only mandatory fields of a ‘Date’ question . ";

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
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);
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
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
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
				.clickOnMandatoryCheckbox()
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		
		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration1
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
		
		objFormConfiguration1.verTemplateDesignPage()
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
						    .selectQuestionType(objFormConfiguration_data.strDateQuestion)
						    .enterLabelName(objFormConfiguration_data.strLabelName)
						    .clickOnAddToSummary()
						    .selectRequiredCheckBox()
						    .clickOnDoneButton()				    
						    .clickOnSaveButton();
		
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);
		
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(10000);
		
		String currentWindowHandle = driver1.getWindowHandle();
		for(String childwindow:driver1.getWindowHandles())
		{
			driver1.switchTo().window(childwindow);
			driver1.manage().window().maximize();
		}

		objFormConfiguration1.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		
		
		driver1.close();
		
		driver1.switchTo().window(currentWindowHandle);
		
		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle);
		
		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1.clickOnFillForm(objFormConfiguration_data.strFormName);
		
		String mainWindowHandle1 = driver1.getWindowHandle();
		
		Thread.sleep(3000);
		
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
					.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strCurrentDate);
        objFormConfiguration1.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
        objBlankForm.clickOnSave();

		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
							objUserdata.strNewUserName1)
					   .clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName1,
						 		 objUserdata.strNewPassword);
		
//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//						+ objFormConfiguration_data.strLabelName + ": "
//						+ objBlankFormData.strCurrentDate;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);
		
		Thread.sleep(5000);
        
        objRegionDefault1.selectFrame()
                       	 .verWebNotificationframe()
                         .verWebNotificationMsgForForms(
                        		 objFormConfiguration_data.strFormName, strMsg)
                         .clickReviewForm();
        Thread.sleep(10000);
          
        String mainWindowHandle2 = driver1.getWindowHandle();
        
        String strPopUpName = "";
        
        Set<String> a2 = driver1.getWindowHandles();
        Iterator<String> ite2 = a2.iterator();

        while (ite2.hasNext()) {
                 String popupHandle = ite2.next().toString();
                 if (!popupHandle.contains(mainWindowHandle2)) {
                       driver1.switchTo().window(popupHandle);
                       strPopUpName = driver1.getWindowHandle();
                 }
          }
          
        objBlankForm.verFormTitleInReviewForm(objFormConfiguration_data.strFormName)
        			.verifyEnteredValueIsDisplayed(objFormConfiguration_data.strLabelName,
        											objBlankFormData.strCurrentDate);
        
//        objFormConfiguration1.clickOnPreviewButton();
//        
//        Set<String> a3 = driver1.getWindowHandles();
//        Iterator<String> ite3 = a3.iterator();
//
//        while (ite3.hasNext()) {
//                 String popupHandle1 = ite3.next().toString();
//                 if (!(popupHandle1.contains(mainWindowHandle2))||(popupHandle1.contains(strPopUpName))) {
//                       driver1.switchTo().window(popupHandle1);
//                 }
//          }

        objFormConfiguration1.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
        
        driver1.close();
        
        driver1.switchTo().window(strPopUpName);
        
        driver1.close();
        
        driver1.switchTo().window(mainWindowHandle2);
        
        objRegionDefault1.selectFrame()
						.verWebNotificationframe()
						.clickAcknowledgeAllForms()
						.selectFrame();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description : Verify that a question added by filling only mandatory fields of ‘Single Line 
                   Text’ can be previewed by filling only mandatory fields of a question.  
    'Precondition:
    'Date        : 02-Apr-2015
    'Author      : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	    **************************************************************************************/
	@Test(description = "Verify that a question added by filling only mandatory fields of ‘Single Line Text’ "
			+ "can be previewed by filling only mandatory fields of a question.")
	public void testEdgeCase152597() throws Exception {

		gstrTCID = "152597";
		gstrTO = "Verify that a question added by filling only mandatory fields of ‘Single Line Text’ "
				+ "can be previewed by filling only mandatory fields of a question.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		BlankFormData objBlankFormData = new BlankFormData();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(80000);

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
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.selectRequiredCheckBox()
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		objFormConfiguration.verifyPreviewButtonIsDisplayed()
				.clickPreviewButton();

		Thread.sleep(10000);
		driver.close();
		driver.switchTo().window(mainWindowHandle);

		String mainWindowHandle2 = driver.getWindowHandle();
		Set<String> a2 = driver.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver.switchTo().window(popupHandle);
			}
		}

		objFormConfiguration
				.verFormInPreviewPage(objFormConfiguration_data.strFormName);

		objFormConfiguration.verGroupNameInPreviewPage(
				objFormConfiguration_data.strGroupName)
				.verFieldSetNameInPreviewPage(
						objFormConfiguration_data.strAttributeName);
		objFormConfiguration.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		objFormConfiguration.verQuestionTypesInPreviewPage(
				objFormConfiguration_data.strAttributeName,
				objFormConfiguration_data.strLabelName);

		objFormConfiguration.verPreviewButtonInPreviewPage();
		objFormConfiguration.verPrintButtonInPreviewPage();
		driver.close();
		driver.switchTo().window(mainWindowHandle2);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(5000);

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		objFormConfiguration1.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		Thread.sleep(5000);

		objRegionDefault1.selectFrame().verWebNotificationframe()
				.clickReviewForm();

		String mainWindowHandle3 = driver1.getWindowHandle();

		Set<String> b = driver1.getWindowHandles();
		Iterator<String> ite3 = b.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle3)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitleInReviewForm(
				objFormConfiguration_data.strFormName)
				.verifyEnteredValueIsDisplayed(
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strTextAnswer);
		objFormConfiguration1.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		driver1.close();
		driver1.switchTo().window(mainWindowHandle3);
		objRegionDefault1.selectFrame().verWebNotificationframe()
				.clickAcknowledgeAllForms().switchToDefaultFrame()
				.selectFrame();
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}

	/*************************************************************************************
	 * 'Description 	: Verify that user can add Instructions at Group, Field Set and Question level of form. 	
	 * 'Precondition 	: None
	 * 'Date 			: 02-Apr-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 ********************************************************************************************/
	@Test(description = "Verify that user can add Instructions at Group, Field Set and Question level of form.")
	public void testEdgeCase152220() throws Exception {

		gstrTCID = "152220";
		gstrTO = "Verify that user can add Instructions at Group, Field Set and Question level of form.";

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
		Thread.sleep(10000);
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.clickOnDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary()
				.clickOnDoneButton()

				.clickOnInsert()
				.clickOnInstructionLink()
				.selectInstructionFrame()
				.enterInstructions(objFormConfiguration_data.strInstructionData);
		driver.switchTo().window(strPopUp1);
		objFormConfiguration
				.clickOnDoneButton()

				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnInstructionInGroup(
						objFormConfiguration_data.strGroupName)
				.selectInstructionFrame()
				.enterInstructions(
						objFormConfiguration_data.strInstructionData1);
		driver.switchTo().window(strPopUp1);
		objFormConfiguration
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strInstructions)
				.selectInstructionFrame()
				.enterInstructions(
						objFormConfiguration_data.strInstructionData2);
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
		Thread.sleep(10000);
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
				.verifyEnteredInstructionIsRetained(
						objFormConfiguration_data.strInstructionData)
				.verifyEnteredInstructionIsRetained(
						objFormConfiguration_data.strInstructionData1)
				.verifyEnteredInstructionIsRetained(
						objFormConfiguration_data.strInstructionData2)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer)
				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//				+ ": " + objBlankFormData.strNumericAnswer + "| "
//				+ objFormConfiguration_data.strLabelName1 + ": "
//				+ objBlankFormData.strTextAnswer;

		String strMsg = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);
		
		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().switchToDefaultFrame()
				.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	
	/*************************************************************************************
	'Description :  Verify that a question added by filling only mandatory fields of ‘Single Select’ 
	                can be previewed while filling only mandatory fields of a question 
	'Precondition:
	'Date	 	 : 03-Apr-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a question added by filling only mandatory fields of ‘Single Select’ "
			+ "can be previewed while filling only mandatory fields of a question")
	public void testEdgecase152638() throws Exception {

		gstrTCID = "152638";
		gstrTO = "Verify that a question added by filling only mandatory fields of ‘Single Select’ "
				+ "can be previewed while filling only mandatory fields of a question";

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
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
				.clickOnMandatoryCheckbox().clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
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

		objFormConfiguration1.verTemplateDesignPage();
		Thread.sleep(10000);
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
				.selectQuestionType(objFormConfiguration_data.strSingleSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.selectRequiredCheckBox()
				.addChoices(objFormConfiguration_data.strChoice)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice1)
				.clickOnAddToSummary()
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strSingleSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.addChoices(objFormConfiguration_data.strChoice2)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice3)
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);

		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(10000);

		String currentWindowHandle = driver1.getWindowHandle();
		for (String childwindow : driver1.getWindowHandles()) {
			driver1.switchTo().window(childwindow);
			driver1.manage().window().maximize();
		}

		objFormConfiguration1
				.verFormInPreviewPage(objFormConfiguration_data.strFormName);

		objFormConfiguration1.verGroupNameInPreviewPage(
				objFormConfiguration_data.strGroupName)
				.verFieldSetNameInPreviewPage(
						objFormConfiguration_data.strAttributeName);

		objFormConfiguration1
				.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		objFormConfiguration1.verQuestionTypesInPreviewPage(
				objFormConfiguration_data.strAttributeName,
				objFormConfiguration_data.strLabelName1);

		objFormConfiguration1.verPreviewButtonInPreviewPage();
		objFormConfiguration1.verPrintButtonInPreviewPage();

		driver1.close();

		driver1.switchTo().window(currentWindowHandle);

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

		Thread.sleep(3000);

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
				.selectSingleOption(objFormConfiguration_data.strChoice);
		objFormConfiguration1
				.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		objBlankForm.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		Thread.sleep(5000);

		objRegionDefault1.selectFrame().verWebNotificationframe()
				.clickReviewForm();
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

		objBlankForm.verFormTitleInReviewForm(
				objFormConfiguration_data.strFormName)
				.verifyEnteredValueIsDisplayedForSingleSelectInPreviewPage(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice);
		objFormConfiguration1
				.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);
		objRegionDefault1.selectFrame().verWebNotificationframe()
				.clickAcknowledgeAllForms().switchToDefaultFrame()
				.selectFrame();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description : Verify that user can select different question types to column of a table.  
    'Precondition:
    'Date        : 01-Apr-2015
    'Author      : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	    **************************************************************************************/
	@Test(description = "Verify that user can select different question types to column of a table.")
	public void testEdgeCase152320() throws Exception {

		gstrTCID = "152320";
		gstrTO = "Verify that user can select different question types to column of a table.";

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
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(8000);

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
				.clickOnTableLink()
				.verifyEditFieldSetWindow()
				.enterFirstRowLabel(objFormConfiguration_data.strRow1)
				.enterThirdRowLabel(objFormConfiguration_data.strRow3,
						objFormConfiguration_data.strRow2)
				.addFirstTableColumn(objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strNumeric)

				.addNthTableColumn(objFormConfiguration_data.strColumnName5,
						objFormConfiguration_data.strSingleSelect)
				.addNthTableColumn(objFormConfiguration_data.strColumnName4,
						objFormConfiguration_data.strTextArea)
				.addNthTableColumn(objFormConfiguration_data.strColumnName3,
						objFormConfiguration_data.strText)
				.addNthTableColumn(objFormConfiguration_data.strColumnName2,
						objFormConfiguration_data.strCheckBox)
				.clickOnEditFieldDoneButton().clickOnSaveButton();

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
		Thread.sleep(5000);

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();
		Thread.sleep(2000);
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);
				driver1.manage().window().maximize();
			}
		}
		String[] columns = { objFormConfiguration_data.strColumnName1,
				objFormConfiguration_data.strColumnName2,
				objFormConfiguration_data.strColumnName3,
				objFormConfiguration_data.strColumnName4,
				objFormConfiguration_data.strColumnName5 };
		String[] answer1 = { "1", "text1", "multitext1" };
		String[] answer2 = { "2", "text2", "multitext2" };
		String[] answer3 = { "3", "text3", "multitext3" };

		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verRowAndQuestionTypeOfTable(
						objFormConfiguration_data.strRow1, columns)
				.verRowAndQuestionTypeOfTable(
						objFormConfiguration_data.strRow2, columns)
				.verRowAndQuestionTypeOfTable(
						objFormConfiguration_data.strRow3, columns)
				.enterAnswerInRows(objFormConfiguration_data.strRow1, columns,
						answer1)
				.enterAnswerInRows(objFormConfiguration_data.strRow2, columns,
						answer2)
				.enterAnswerInRows(objFormConfiguration_data.strRow3, columns,
						answer3)

				.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
//		String strmsg1 = "Review Form Print Form";
//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strRow1 + ":"
//				+ objFormConfiguration_data.strColumnName1 + ": " + answer1[0]
//				+ "| " + objFormConfiguration_data.strRow1 + ":"
//				+ objFormConfiguration_data.strColumnName2 + ": "
//				+ "New Choice" + "| " + objFormConfiguration_data.strRow1 + ":"
//				+ objFormConfiguration_data.strColumnName3 + ": " + answer1[1]
//				+ "| " + objFormConfiguration_data.strRow1 + ":"
//				+ objFormConfiguration_data.strColumnName4 + ": " + answer1[2]
//				+ "| " + objFormConfiguration_data.strRow1 + ":"
//				+ objFormConfiguration_data.strColumnName5 + ": "
//				+ "New Choice" + "| "
//
//				+ objFormConfiguration_data.strRow2 + ":"
//				+ objFormConfiguration_data.strColumnName1 + ": " + answer2[0]
//				+ "| " + objFormConfiguration_data.strRow2 + ":"
//				+ objFormConfiguration_data.strColumnName2 + ": "
//				+ "New Choice" + "| " + objFormConfiguration_data.strRow2 + ":"
//				+ objFormConfiguration_data.strColumnName3 + ": " + answer2[1]
//				+ "| " + objFormConfiguration_data.strRow2 + ":"
//				+ objFormConfiguration_data.strColumnName4 + ": " + answer2[2]
//				+ "| " + objFormConfiguration_data.strRow2 + ":"
//				+ objFormConfiguration_data.strColumnName5 + ": "
//				+ "New Choice" + "| "
//
//				+ objFormConfiguration_data.strRow3 + ":"
//				+ objFormConfiguration_data.strColumnName1 + ": " + answer3[0]
//				+ "| " + objFormConfiguration_data.strRow3 + ":"
//				+ objFormConfiguration_data.strColumnName2 + ": "
//				+ "New Choice" + "| " + objFormConfiguration_data.strRow3 + ":"
//				+ objFormConfiguration_data.strColumnName3 + ": " + answer3[1]
//				+ "| " + objFormConfiguration_data.strRow3 + ":"
//				+ objFormConfiguration_data.strColumnName4 + ": " + answer3[2]
//				+ "| " + objFormConfiguration_data.strRow3 + ":"
//				+ objFormConfiguration_data.strColumnName5 + ": "
//				+ "New Choice" + "\n" + strmsg1 + "";

		String strMsg = objRegionDefault1.getWebNotificationForTable(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strRow1,
				objFormConfiguration_data.strRow2,
				objFormConfiguration_data.strRow3,
				objFormConfiguration_data.strColumnName1,
				objFormConfiguration_data.strColumnName2,
				objFormConfiguration_data.strColumnName3,
				objFormConfiguration_data.strColumnName4,
				objFormConfiguration_data.strColumnName5, answer1[0],
				objFormConfiguration_data.strNewChoice, answer1[1], answer1[2],
				objFormConfiguration_data.strNewChoice, answer2[0],
				objFormConfiguration_data.strNewChoice, answer2[1], answer2[2],
				objFormConfiguration_data.strNewChoice, answer3[0],
				objFormConfiguration_data.strNewChoice, answer3[1], answer3[2],
				objFormConfiguration_data.strNewChoice);
		
		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms();

		Thread.sleep(2000);
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}


/*************************************************************************************
'Description :  Verify that a question can be added by filling all fields of ‘Numeric’ question.
'Precondition:
'Date	 	 : 06-Apr-2015
'Author		 : Hanumegowda
'---------------------------------------------------------------
'Modified Date			                        	Modified By
'Date					                            Name
**************************************************************************************/
	@Test(description = "Verify that a question can be added by filling all fields of ‘Numeric’ question.")
	public void testEdgecase152601() throws Exception {

		gstrTCID = "152601";
		gstrTO = "Verify that a question can be added by filling all fields of ‘Numeric’ question.";

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
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);

		/*objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
*/
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
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName,
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

		objFormConfiguration.verTemplateDesignPage();
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.enterDecimalPlaceValue(
						objFormConfiguration_data.strDecimalValue)
				.enterTextInToolTipHelp(
						objFormConfiguration_data.strToolTipHelp)
				.clickOnAddToSummary()
				.enterTextInReportLabel(
						objFormConfiguration_data.strReportLabel)
				.selectRequiredCheckBox()
				.enterMinimumValue(objFormConfiguration_data.strMinimumvalue)
				.enterMaximumValue(objFormConfiguration_data.strMaximumvalue)
				.enterDefaultValue(objFormConfiguration_data.strDefaultNum)
				.clickOnDoneButton()

				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(8000);
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

		Thread.sleep(3000);

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName);

		objFormConfiguration1.verifyMandatoryMarkForQuestion(
				objFormConfiguration_data.strLabelName)
				.verifyToolTipQuestionMarkSymbol(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strToolTipHelp);
		objBlankForm
				.verNumericDefaultValue(objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strDefaultNum)
				.enterAndVerMinMaxValForNumericQuesType(
						objFormConfiguration_data.strMinimumvalue,
						objFormConfiguration_data.strMaximumvalue,
						objFormConfiguration_data.strLabelName)
				.enterAnswerInField(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue);

		objBlankForm.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		Thread.sleep(5000);
//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//				+ ": " + objFormConfiguration_data.strMinimumvalue
//				+ "\nReview Form Print Form";

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue);
		
		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)

				.clickAcknowledgeAllForms().switchToDefaultFrame()
				.selectFrame();
		objLogin1.clickLogOut();

		Thread.sleep(3000);
		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody = objMailVerificationFunctions.getFormMailBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strMinimumvalue);

		String strMsgBody1 = objMailVerificationFunctions.getFormPagerBody(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strMinimumvalue);

		String strSubject = objFormConfiguration_data.strFormName;

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
		int intCount;

		for (intCount = 0; intCount < 3; intCount++) {

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
	'Description :  Add a 'Numeric' question by providing a value X and Y in the 'Min' & 'Max' value
	                field and verify that: Appropriate validation is displayed when attempted to update apart form the selected range. 
	'Precondition:
	'Date	 	 : 07-Apr-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Add a 'Numeric' question by providing a value X and Y in the 'Min' & 'Max' value"
			+ "field and verify that: Appropriate validation is displayed when attempted to update apart form the selected range.")
	public void testEdgecase152604() throws Exception {

		gstrTCID = "152604";
		gstrTO = "Add a 'Numeric' question by providing a value X and Y in the 'Min' & 'Max' value"
				+ " field and verify that: Appropriate validation is displayed when attempted to update apart form the selected range.";

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
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

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

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration.verTemplateDesignPage();
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)

				.clickOnAddToSummary()

				.enterMinimumValue(objFormConfiguration_data.strMinimumvalue)
				.enterMaximumValue(objFormConfiguration_data.strMaximumvalue)

				.clickOnDoneButton()

				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(8000);
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

		Thread.sleep(3000);

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName);

		objBlankForm.enterAndVerMinMaxValForNumericQuesType(
				objFormConfiguration_data.strMinimumvalue,
				objFormConfiguration_data.strMaximumvalue,
				objFormConfiguration_data.strLabelName)
				.enterAnswerInField(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue);

		objBlankForm.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		Thread.sleep(5000);
//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//				+ ": " + objFormConfiguration_data.strMinimumvalue
//				+ "\nReview Form Print Form";

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strMinimumvalue);
		
		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)

				.clickAcknowledgeAllForms().switchToDefaultFrame()
				.selectFrame();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that the form can be previewed by filling only mandatory fields of a ‘Multi Line Text’ question .
	'Precondition:
	'Date	 	 : 03-Apr-2015
	'Author		 : Sangappa.k
	
	**************************************************************************************/
	@Test(description = "Verify that the form can be previewed by filling only mandatory fields of a ‘Multi Line Text’ question . ")
	public void testEdgecase152619() throws Exception {

		gstrTCID = "152619";
		gstrTO = "Verify that the form can be previewed by filling only mandatory fields of a ‘Multi Line Text’ question . ";

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
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);
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
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
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
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		
		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration1
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
		Thread.sleep(10000);
		
		
		objFormConfiguration1.verTemplateDesignPage();
		Thread.sleep(18000);
		objFormConfiguration1.clickOnInsert()
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
						    .selectQuestionType(objFormConfiguration_data.strTextArea)
						    .enterLabelName(objFormConfiguration_data.strLabelName)
						    .clickOnAddToSummary()
						    .selectRequiredCheckBox()
						    .clickOnDoneButton()				    
						    .clickOnSaveButton();
		Thread.sleep(10000);
		
		objFormConfiguration1.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		
		System.out.println("started");
		Thread.sleep(5000);
	    System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);
		
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(10000);
		
		String TempPage = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(TempPage)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		
		driver1.close();
		
		driver1.switchTo().window(TempPage);
		
		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle);
		
		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1.clickOnFillForm(objFormConfiguration_data.strFormName);
		
		String mainWindowHandle1 = driver1.getWindowHandle();
		
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
					.verFieldSetName(objFormConfiguration_data.strAttributeName);
		
		objFormConfiguration1.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		System.out.println("abc");
		Thread.sleep(10000);
		objBlankForm.enterAnswerInTextAreaField(objBlankFormData.strMultiLineTextAnswer);

		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
							objUserdata.strNewUserName1)
					   .clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName1,
						 		 objUserdata.strNewPassword);
		
//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//						+ objFormConfiguration_data.strLabelName + ": "
//						+ objBlankFormData.strMultiLineTextAnswer;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strMultiLineTextAnswer);
		
		Thread.sleep(5000);
        
        objRegionDefault1.selectFrame()
                       	 .verWebNotificationframe()
                         .verWebNotificationMsgForForms(
                        		 objFormConfiguration_data.strFormName, strMsg)
                         .clickReviewForm();
        Thread.sleep(10000);
          
        String mainWindowHandle2 = driver1.getWindowHandle();
        
        String strPopUpName = "";
        
        Set<String> a3 = driver1.getWindowHandles();
        Iterator<String> ite3 = a3.iterator();

        while (ite3.hasNext()) {
                 String popupHandle = ite3.next().toString();
                 if (!popupHandle.contains(mainWindowHandle2)) {
                       driver1.switchTo().window(popupHandle);
                       strPopUpName = driver1.getWindowHandle();
                 }
          }
          
        objBlankForm.verFormTitleInReviewForm(objFormConfiguration_data.strFormName)
        			.verifyEnteredValueIsDisplayed(objFormConfiguration_data.strLabelName,
        					                   objBlankFormData.strMultiLineTextAnswer);
               
        objFormConfiguration1.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
        
        driver1.close();
        
        driver1.switchTo().window(mainWindowHandle2);
        
        objRegionDefault1.selectFrame()
						.verWebNotificationframe()
						.clickAcknowledgeAllForms()
						.selectFrame();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description : Add a mandatory 'Numeric' question and verify that: 1. The question is marked
     as mandatory in the 'Template Designer' screen. 2. When the form is tested (in the 'Review 
     your changes' screen) without answering this question, it is indicated that the question is 
     mandatory. 3. The question is marked as mandatory when filling out the form. 4. The form cannot
     be submitted without answering that question..  
    'Precondition:
    'Date        : 07-Apr-2015
    'Author      : Sangappa.k
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	    **************************************************************************************/
	@Test(description = "Add a mandatory 'Numeric' question and verify that: 1. The question is marked"
     +"as mandatory in the 'Template Designer' screen. 2. When the form is tested (in the 'Review" 
    + "your changes' screen) without answering this question, it is indicated that the question is" 
     +"mandatory. 3. The question is marked as mandatory when filling out the form. 4. The form cannot"
    +" be submitted without answering that question.")
    		
	public void testEdgeCase152602() throws Exception {

		gstrTCID = "152602";
		gstrTO = "Add a mandatory 'Numeric' question and verify that: 1. The question is marked"
     +"as mandatory in the 'Template Designer' screen. 2. When the form is tested (in the 'Review" 
     +"your changes' screen) without answering this question, it is indicated that the question is" 
     +"mandatory. 3. The question is marked as mandatory when filling out the form. 4. The form cannot"
     +" be submitted without answering that question.)";
		
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
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeFormOnIE(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		Thread.sleep(10000);

		objFormConfiguration1.verTemplateDesignPage();
		Thread.sleep(18000);
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.selectNumberType(objFormConfiguration_data.strNumber)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary().selectRequiredCheckBox()
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.selectNumberType(objFormConfiguration_data.strCurrency)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary().selectRequiredCheckBox()
				.clickOnDoneButton()
			
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.selectNumberType(objFormConfiguration_data.strPercentage)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.clickOnAddToSummary().selectRequiredCheckBox()
				.clickOnDoneButton()
				
	           .clickOnSaveButton();
		Thread.sleep(10000);
		//ver All 3 Qsn types
		objFormConfiguration1
		.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		objFormConfiguration1
		.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName1);
        objFormConfiguration1
		.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName2);



		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);

		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(12000);

		String Templatepage = driver1.getWindowHandle();

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle1 = ite1.next().toString();

			if (!popupHandle1.contains(Templatepage)) {
				driver1.switchTo().window(popupHandle1);
				
			}
		}
 
		objFormConfiguration1
		.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName)
	    .verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName1)
        .verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName2);
		driver1.close();

		driver1.switchTo().window(Templatepage);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

	
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(10000);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(10000);

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);

		objFormConfiguration1
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName)
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName1)
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName2);
		Thread.sleep(10000);
		objBlankForm.clickOnSave();
       
		objBlankForm
				.verifyRequiedTextForMandatoryQuestion(
						objFormConfiguration_data.strLabelName)
				.verifyRequiedTextForMandatoryQuestion(
						objFormConfiguration_data.strLabelName1)
				.verifyRequiedTextForMandatoryQuestion(
						objFormConfiguration_data.strLabelName2);

		objBlankForm
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer)
				.enterAnswerInField(objFormConfiguration_data.strLabelName1,
						objBlankFormData.strNumericAnswer2)
				.enterAnswerInField(objFormConfiguration_data.strLabelName2,
						objBlankFormData.strNumericAnswer1);

		objBlankForm.clickOnComplete();
		Thread.sleep(10000);  
		
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName3).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description : Add a mandatory 'Date' question and verify that: 1. The
	 * question is marked as mandatory in the 'Template Designer' screen. 2.
	 * When the form is Priviewed without answering this question, it is
	 * indicated that the question is mandatory. 3. The question is marked as
	 * mandatory when filling out the form. 4. The form cannot be submitted
	 * without answering that. 'Date : 06-Apr-2015 'Author : Sangappa.k
	 **************************************************************************************/
	@Test(description = "Add a mandatory 'Date' question and verify that: 1. The question is marked as"
			+ "mandatory in the 'Template Designer' screen. 2. When the form is Priviewed without answering this"
			+ " question, it is indicated that the question is mandatory. 3. The question is marked as mandatory "
			+ " when filling out the form. 4. The form cannot be submitted without answering that  ")
	public void testEdgecase152610() throws Exception {

		gstrTCID = "152610";
		gstrTO = "Add a mandatory 'Date' question and verify that: 1. The question is marked as"
				+ "mandatory in the 'Template Designer' screen. 2. When the form is Priviewed without answering this"
				+ " question, it is indicated that the question is mandatory. 3. The question is marked as mandatory "
				+ " when filling out the form. 4. The form cannot be submitted without answering that ";

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
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
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
		Thread.sleep(10000);

		objFormConfiguration1.verTemplateDesignPage();
		Thread.sleep(18000);
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

				// Date type
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strDateQuestion)
				.selectDateType(objFormConfiguration_data.strDate)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.selectRequiredCheckBox()
				.clickOnDoneButton()
				// Time Type
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strDateQuestion)
				.selectDateType(objFormConfiguration_data.strDateTime)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary()
				.selectRequiredCheckBox()
				.clickOnDoneButton()
				// date & Time Type
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strDateQuestion)
				.selectDateType(objFormConfiguration_data.strTime)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.clickOnAddToSummary().selectRequiredCheckBox()
				.clickOnDoneButton()

				.clickOnSaveButton();
		Thread.sleep(10000);

		objFormConfiguration1
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName)
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName1)
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName2);

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);

		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(12000);

		String TempPage = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(TempPage)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName)
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName1)
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName2);

		driver1.close();

		driver1.switchTo().window(TempPage);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(10000);

		String mainWindowHandle1 = driver1.getWindowHandle();

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName);

		objFormConfiguration1
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName)
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName1)
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName2);

		Thread.sleep(10000);
		objBlankForm.clickOnSave();

		objBlankForm
				.verifyRequiedTextForMandatoryQuestion(
						objFormConfiguration_data.strLabelName)
				.verifyRequiedTextForMandatoryQuestion(
						objFormConfiguration_data.strLabelName1)
				.verifyRequiedTextForMandatoryQuestion(
						objFormConfiguration_data.strLabelName2);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				objBlankFormData.strCurrentDate);

		objBlankForm.enterAnswerInField(
				objFormConfiguration_data.strLabelName1,
				objBlankFormData.strCurrentDateTime);

		objBlankForm
				.enterAnswerInField(objFormConfiguration_data.strLabelName2,
						objBlankFormData.strCurrentTime).clickOnSave()
				.clickOnComplete();
		Thread.sleep(10000);
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName3).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Add a 'Numeric' question by providing a value X in the 'Min' field and verify that: 
	               1. In the 'Template Designer' screen: a. Answer with a value less than X is not accepted. 
	               b. Answer with a value equal to X is accepted. c. Answer with a value greater than X is accepted. 
	               2. While filling out the form: a. Answer with a value less than X is not accepted. b. Answer with
	                a value equal to X is accepted. c. Answer with a value greater than X is accepted. 
	'Precondition:
	'Date	 	 : 09-Apr-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Add a 'Numeric' question by providing a value X in the 'Min' field and verify that: "
			+ "1. In the 'Template Designer' screen: a. Answer with a value less than X is not accepted. "
			+ "b. Answer with a value equal to X is accepted. c. Answer with a value greater than X is accepted. "
			+ "2. While filling out the form: a. Answer with a value less than X is not accepted. b. Answer with a value equal to X is accepted."
			+ " c. Answer with a value greater than X is accepted. ")
	public void testEdgecase152606() throws Exception {

		gstrTCID = "152606";
		gstrTO = "Add a 'Numeric' question by providing a value X in the 'Min' field and verify that: "
				+ "1. In the 'Template Designer' screen: a. Answer with a value less than X is not accepted. "
				+ "b. Answer with a value equal to X is accepted. c. Answer with a value greater than X is accepted. "
				+ "2. While filling out the form: a. Answer with a value less than X is not accepted. "
				+ "b. Answer with a value equal to X is accepted. c. Answer with a value greater than X is accepted. ";

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
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

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

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration.verTemplateDesignPage();
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)

				.clickOnAddToSummary()

				.enterMinimumValue(objFormConfiguration_data.strMinimumvalue)

				.clickOnDoneButton()

				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(8000);
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

		Thread.sleep(3000);

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		int int1 = Integer.parseInt(objFormConfiguration_data.strMinimumvalue);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				"" + (int1 + 1) + "").clickOnSave();
		objBlankForm.verErrorMsgNotDisplayedWhenEnteringNumForMinValue(
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strMinimumvalue);
		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				"" + (int1 - 1) + "").clickOnSave();

		objBlankForm.verErrorMsgWhenNumericValueExceedsMinValue(
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strMinimumvalue);
		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strMinimumvalue).clickOnSave();
		objBlankForm.verErrorMsgNotDisplayedWhenEnteringNumForMinValue(
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strMinimumvalue);

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	'Description : Verify that a question can be added to the form by entering only mandatory data in 
	               the 'Template Designer' screen.
	'Date	 	 : 9-Apr-2015
	'Author		 : Sangappa.k
	
	'-----------------------------------------------------------------------------------------------
	'Modified Date			                        	               Modified By
	'Date					                                           Name
	************************************************************************************************/
	@Test(description = "Verify that a question can be added to the form by entering only mandatory data in the 'Template Designer' screen.")
	public void testEdgeCase152595() throws Exception {

		gstrTCID = "152595";
		gstrTO = "Verify that a question can be added to the form by entering only mandatory data in the 'Template Designer' screen.";
	
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);	
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

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
				.clickOnNextButton()
				.clickOnNextButton()
				.clickOnSaveOfFormSecuritySetting();
		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		String mainWindowHandle = driver1.getWindowHandle();

		String strPopUp1 = "";
		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			strPopUp1 =popupHandle;
			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		
		Thread.sleep(10000);
		objFormConfiguration
		.verTemplateDesignPage();
		Thread.sleep(5000);
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
//Numeric QSn	
		.clickOnInsertElement(
				objFormConfiguration_data.strAttributeName)
		.verifyEditQuestionWindow()
		.selectQuestionType(objFormConfiguration_data.strNumeric)
		.enterLabelName(objFormConfiguration_data.strLabelName)
		.clickOnAddToSummary()
		.clickOnDoneButton()	
//Single line text Qsn	
		.clickOnInsertElement(
				objFormConfiguration_data.strAttributeName)
		.verifyEditQuestionWindow()
		.selectQuestionType(objFormConfiguration_data.strText)
		.enterLabelName(objFormConfiguration_data.strLabelName1)
		.clickOnAddToSummary()
		.clickOnDoneButton()	
 //Date Qsn	
		.clickOnInsertElement(
				objFormConfiguration_data.strAttributeName)
		.verifyEditQuestionWindow()
		.selectQuestionType(objFormConfiguration_data.strDateQuestion)
		.enterLabelName(objFormConfiguration_data.strLabelName2)
		.clickOnAddToSummary()
		.clickOnDoneButton()	
// Multi Text Qsn
		.clickOnInsertElement(
				objFormConfiguration_data.strAttributeName)
		.verifyEditQuestionWindow()
		.selectQuestionType(objFormConfiguration_data.strTextArea)
		.enterLabelName(objFormConfiguration_data.strLabelName3)
		.clickOnAddToSummary()
		.clickOnDoneButton()
//	Boolean	
		.clickOnInsertElement(
				objFormConfiguration_data.strAttributeName)
		.verifyEditQuestionWindow()
		.selectQuestionType(objFormConfiguration_data.strBoolean)
		.enterLabelName(objFormConfiguration_data.strLabelName4)
		.clickOnAddToSummary()
		.clickOnDoneButton()	
//Cheack Box
		.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strCheckBox)
				.enterLabelName(objFormConfiguration_data.strLabelName5)
				.clickOnAddToSummary()
				.addChoices(objFormConfiguration_data.strChoice1)
				.clickOnDoneButton()				
//Radio Button				
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strRadio)
				.enterLabelName(objFormConfiguration_data.strLabelName6)
				.clickOnAddToSummary()
				.addChoices(objFormConfiguration_data.strChoice2)
				.clickOnDoneButton()		
 //Single Select		
			 .clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data. strSingleSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName7)
				.clickOnAddToSummary()
				.addChoices(objFormConfiguration_data.strChoice3)
				.clickOnDoneButton()				
//Multi Select			
			 .clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data. strMultiSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName8)
				.clickOnAddToSummary()
				.addChoices(objFormConfiguration_data.strChoice4)
				.clickOnDoneButton()		
//Instruction		
			 .clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data. strInstructions)
				.enterInstructions(objFormConfiguration_data.strInstructionData)
				.clickOnDoneButton()		
              .clickOnSaveButton();
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.clickOnConfigureForm();
		
		Thread.sleep(5000);
		
		objFormConfiguration
						.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		
		Thread.sleep(10000);
		
		String mainWindowHandle1 = driver1.getWindowHandle();
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		System.out.println("mainWindowHandle1 : " +mainWindowHandle1);
		objFormConfiguration.verTemplateDesignPage()
							 .verifyFormTitle(objFormConfiguration_data.strFormName);		

			 
	    //verify all Qsn types					 					 
		objFormConfiguration.verifyLabelNameInTemplateDesignPage(objFormConfiguration_data.strLabelName);		
		objFormConfiguration.verifyLabelNameInTemplateDesignPage(objFormConfiguration_data.strLabelName1);	
		objFormConfiguration.verifyLabelNameInTemplateDesignPage(objFormConfiguration_data.strLabelName2);
		objFormConfiguration.verifyLabelNameInTemplateDesignPage(objFormConfiguration_data.strLabelName3);	
		objFormConfiguration.verifyLabelNameInTemplateDesignPage(objFormConfiguration_data.strLabelName4);
		objFormConfiguration.verifyLabelNameInTemplateDesignPage(objFormConfiguration_data.strLabelName6);
		objFormConfiguration.verifyLabelNameInTemplateDesignPage(objFormConfiguration_data.strLabelName7);
		objFormConfiguration.verifyLabelNameInTemplateDesignPage(objFormConfiguration_data.strLabelName8);
							 
		objFormConfiguration
				.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName5,
						objFormConfiguration_data.strChoice1)
						
						.verifyAddedSecQueChoiceIsDis(
						objFormConfiguration_data.strLabelName6,
						objFormConfiguration_data.strChoice2);
					        			
		objFormConfiguration.clickOnSaveButton();
			
			System.out.println("started");
			Thread.sleep(5000);
			System.out.println("ended");
			objFormConfiguration.clickOnPublishButton();
			Thread.sleep(5000);
							 
		driver1.close();
		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Add a 'Numeric' question by providing a value X in the 'Max' field and verify that: 
	               1. In the 'Template Designer' screen: a. Answer with a value greater than X is not accepted. 
	               b. Answer with a value equal to X is accepted. c. Answer with a value less than X is accepted. 
	               2. While filling out the form: a. Answer with a value greater than X is not accepted. 
	               b. Answer with a value equal to X is accepted. c. Answer with a value less than X is accepted  
	'Precondition:
	'Date	 	 : 10-Apr-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Add a 'Numeric' question by providing a value X in the 'Max' field and verify that: "
			+ "1. In the 'Template Designer' screen: a. Answer with a value greater than X is not accepted. "
			+ "b. Answer with a value equal to X is accepted. c. Answer with a value less than X is accepted. "
			+ "2. While filling out the form: a. Answer with a value greater than X is not accepted. "
			+ "b. Answer with a value equal to X is accepted. c. Answer with a value less than X is accepted ")
	public void testEdgecase152607() throws Exception {

		gstrTCID = "152607";
		gstrTO = "Add a 'Numeric' question by providing a value X in the 'Max' field and verify that: "
				+ "1. In the 'Template Designer' screen: a. Answer with a value greater than X is not accepted. "
				+ "b. Answer with a value equal to X is accepted. c. Answer with a value less than X is accepted. "
				+ "2. While filling out the form: a. Answer with a value greater than X is not accepted. "
				+ "b. Answer with a value equal to X is accepted. c. Answer with a value less than X is accepted ";

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
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

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

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration.verTemplateDesignPage();
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)

				.clickOnAddToSummary()

				.enterMaximumValue(objFormConfiguration_data.strMaximumvalue)

				.clickOnDoneButton()

				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(8000);
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

		Thread.sleep(3000);

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		int int1 = Integer.parseInt(objFormConfiguration_data.strMaximumvalue);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				"" + (int1 + 1) + "").clickOnSave();
		objBlankForm.verErrorMsgWhenNumericValueExceedsMaxValue(
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strMaximumvalue);
		Thread.sleep(10000);
		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				"" + (int1 - 1) + "");
		Thread.sleep(10000);
		objBlankForm.clickOnSave();

		objBlankForm.verErrorMsgNotDisplayedWhenEnteringNumForMaxValue(
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strMaximumvalue);
		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strMaximumvalue).clickOnSave();
		objBlankForm.verErrorMsgNotDisplayedWhenEnteringNumForMaxValue(
				objFormConfiguration_data.strLabelName,
				objFormConfiguration_data.strMaximumvalue);

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*********************************************************************************
	 * 'Description :Verify that user cannot select 'Use Standard List' option
	 * once a choice is added. 
	 * 'Date :26-Jan-2015
	 *  'Author :Hanumegowda
	 **********************************************************************************/
	@Test(description = "Verify that user cannot select 'Use Standard List' option once a choice is added. ")
	public void testEdgeCase152222() throws Exception {

		gstrTCID = "152222";
		gstrTO = "Verify that user cannot select 'Use Standard List' option once a choice is added. ";
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);

		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

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
				.clickOnNextButton().clickOnNextButton()
				.clickOnSaveOfFormSecuritySetting();
		Thread.sleep(10000);

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		Thread.sleep(15000);

		// objRegionDefault1.selectFrame();
		objFormConfiguration
				.clickOnAcknowledgeForm1(objFormConfiguration_data.strFormName);
		Thread.sleep(10000);

		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		Thread.sleep(15000);

		objFormConfiguration.verTemplateDesignPage();
		Thread.sleep(15000);
		objFormConfiguration

		.clickOnInsert();
		Thread.sleep(15000);
		objFormConfiguration

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
						objFormConfiguration_data.strAttributeName);
		objFormConfiguration.verifyEditQuestionWindow().selectQuestionType(
				objFormConfiguration_data.strCheckBox);
		objFormConfiguration.clickOnAddChoicePlusButton();
		objFormConfiguration.verifyuserStandardUserListCheckBox()
				.clickOnDoneButton();
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin.clickLogOut();
		gstrResult = "PASS";

	}

	/*********************************************************************************
	'Description	:Verify that user cannot add choices once 'Use Standard List' option is selected.
	'Date	 		:27-Jan-2015
	'Author			:Hanumegowda
	**********************************************************************************/

	@Test(description = " Verify that user cannot add choices once 'Use Standard List' option is selected. ")
	public void testEdgeCase152232() throws Exception {

		gstrTCID = "152232";
		gstrTO = "Verify that user cannot add choices once 'Use Standard List' option is selected. ";
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);

		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		objRegionDefault1.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration1.verFormConfigurePage();
		objFormConfiguration1.createNewFormTempltete();
		objFormConfiguration1
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
				.clickOnNextButton().clickOnNextButton().clickOnNextButton()

				.clickOnSaveOfFormSecuritySetting()

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

		objFormConfiguration1
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
						objFormConfiguration_data.strAttributeName);
		objFormConfiguration1.verifyEditQuestionWindow().selectQuestionType(
				objFormConfiguration_data.strCheckBox);
		objFormConfiguration1.clickOnUserStandardListCheckBox();
		objFormConfiguration1.verifyChoiceBoxAddisDisabeled()
				.verifyChoiceBoxMinusisDisabeled().clickOnDoneButton();
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin.clickLogOut();
		gstrResult = "PASS";

	}

	/*********************************************************************************
	'Description	:Verify that 'Preview' window is in non-editable format. 
	'Date	 		:12-Feb-2015
	'Author			:Hanumegowda
	**********************************************************************************/

	@Test(description = "Verify that 'Preview' window is in non-editable format. ")
	public void testEdgeCase152082() throws Exception {

		gstrTCID = "152082";
		gstrTO = "Verify that 'Preview' window is in non-editable format.  ";
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();
		objNavigationToSubmenus.navigateToUsers();
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();
		Thread.sleep(10000);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
		Thread.sleep(10000);
		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();
		// String strPopUp1 = "";
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			// strPopUp1 = popupHandle;
			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);
				driver1.manage().window().maximize();
			}
		}

		objFormConfiguration.verTemplateDesignPage();
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
						objFormConfiguration_data.strAttributeName);
		Thread.sleep(5000);
		objFormConfiguration.clickOnEditFieldDoneButton();

		objFormConfiguration
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnDoneButton();
		objFormConfiguration
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strTextArea)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnDoneButton();

		objFormConfiguration
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.clickOnDoneButton();

		objFormConfiguration
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strDateQuestion)
				.enterLabelName(objFormConfiguration_data.strLabelName3)
				.clickOnDoneButton();

		objFormConfiguration
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strCheckBox)
				.enterLabelName(objFormConfiguration_data.strLabelName4)
				.clickOnDoneButton();

		objFormConfiguration
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strRadio)
				.enterLabelName(objFormConfiguration_data.strLabelName5)
				.clickOnDoneButton();

		objFormConfiguration
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strSingleSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName6)
				.clickOnDoneButton();
		objFormConfiguration
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType1(objFormConfiguration_data.multiselectvalue)
				.enterLabelName(objFormConfiguration_data.strLabelName7)

				.clickOnDoneButton();
		Thread.sleep(5000);
		objFormConfiguration.clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration.clickOnPreviewButton();
		Thread.sleep(10000);
		Thread.sleep(10000);
		String currentWindowHandle = driver1.getWindowHandle();
		for (String childwindow : driver1.getWindowHandles()) {
			driver1.switchTo().window(childwindow);
			driver1.manage().window().maximize();
		}
		objFormConfiguration
				.verifyFormTitleInPreviewPage(objFormConfiguration_data.strFormName);
		Thread.sleep(10000);
		objFormConfiguration.verGroupNameInPreviewPage(
				objFormConfiguration_data.strGroupName)
				.verFieldSetNameInPreviewPage(
						objFormConfiguration_data.strAttributeName);
		objFormConfiguration.verNumericOrSingleLineTextQuestionIsDisabled(
				objFormConfiguration_data.strAttributeName,
				objFormConfiguration_data.strLabelName);
		objFormConfiguration
				.vermultiLineTextQuestionIsDisabled(objFormConfiguration_data.strLabelName1);
		objFormConfiguration.verNumericOrSingleLineTextQuestionIsDisabled(
				objFormConfiguration_data.strAttributeName,
				objFormConfiguration_data.strLabelName2);
		objFormConfiguration.verNumericOrSingleLineTextQuestionIsDisabled(
				objFormConfiguration_data.strAttributeName,
				objFormConfiguration_data.strLabelName3);
		objFormConfiguration.verNumericOrSingleLineTextQuestionIsDisabled(
				objFormConfiguration_data.strAttributeName,
				objFormConfiguration_data.strLabelName4);
		objFormConfiguration.verNumericOrSingleLineTextQuestionIsDisabled(
				objFormConfiguration_data.strAttributeName,
				objFormConfiguration_data.strLabelName5);
		objFormConfiguration
				.verSingleSelectQuestionIsDisabled(objFormConfiguration_data.strLabelName6);
		objFormConfiguration
				.verMultiSelectQuestionIsDisabled(objFormConfiguration_data.strLabelName7);
		driver1.close();
		driver1.switchTo().window(currentWindowHandle);
		driver1.close();
		driver1.switchTo().window(mainWindowHandle);
		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		gstrResult = "PASS";

	}
	/*********************************************************************************
	'Description	:Verify that user can provide decimal values while adding 'Numeric.' 
	                 questionnaire to the V3 form  
	'Date	 		:13-Feb-2015
	'Author			:Hanumegowda
	**********************************************************************************/
	@Test(description = "Verify that user can provide decimal values while adding 'Numeric'"
			+ " questionnaire to the V3 form ")
	public void testEdgeCase152190() throws Exception {

		gstrTCID = "152190";
		gstrTO = " Verify that user can provide decimal values while adding 'Numeric' "
				+ "questionnaire to the V3 form";

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
		// String strPopUp1 = "";
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			// strPopUp1 = popupHandle;
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.enterDecimalPlaceValue(
						objFormConfiguration_data.strDecimalValue)
				.selectRequiredCheckBox().clickOnDoneButton()
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
		Thread.sleep(5000);
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		objBlankForm.enterAnswerInField(
				objFormConfiguration_data.strLabelName1,
				objFormConfiguration_data.strDecimalNum);

		objBlankForm.clickOnSave().clickOnComplete();
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description : Add an optional 'Single Line Text' question and verify that: 1. The question is 
    not marked as mandatory in the 'Template Designer' screen. 2. When the form is tested (in the 'Review your changes' screen)
     without answering this question, nothing is indicated. 3. The question is not marked as mandatory when filling out the form.
      4. The form can be submitted without answering that question. 
    'Precondition:
    'Date        : 13-Apr-2015
    'Author      : Sangappa.k
	    **************************************************************************************/
	@Test(description = "Add an optional 'Single Line Text' question and verify that: 1. The question is not marked as mandatory"
			+ " in the 'Template Designer' screen. 2. When the form is tested (in the 'Review your changes' screen) without answering"
			+ " this question, nothing is indicated. 3. The question is not marked as mandatory when filling out the form. 4. The form"
			+ " can be submitted without answering that question. ")
    		
	public void testEdgeCase152599() throws Exception {

		gstrTCID = "152599";
		gstrTO = "Add an optional 'Single Line Text' question and verify that: 1. The question is not marked as mandatory in the 'Template Designer'"
				+ " screen. 2. When the form is tested (in the 'Review your changes' screen) without answering this question, nothing is indicated. 3. "
				+ "The question is not marked as mandatory when filling out the form. 4. The form can be submitted without answering that question. ";
		
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
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeFormInIE(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		Thread.sleep(10000);

		objFormConfiguration1.verTemplateDesignPage();
		Thread.sleep(18000);
		objFormConfiguration1.clickOnInsert()
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
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();
		objFormConfiguration1
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(12000);

		String TempPage = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(TempPage)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);

		driver1.close();

		driver1.switchTo().window(TempPage);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(10000);

		String mainWindowHandle1 = driver1.getWindowHandle();

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName);

		objFormConfiguration1
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);
		Thread.sleep(10000);
		objBlankForm.clickOnSave();

		objFormConfiguration1
				.verRequiredTextIsNotDisplayedForOptionalQuestionType(objFormConfiguration_data.strLabelName);

		objBlankForm.clickOnComplete();

		objDispatchForm
				.selUserToReceiveCompletedForm(objUserdata.strNewUserName3);
		System.out.println("user3 " + objUserdata.strNewUserName3);

		objDispatchForm.clickOnDispatchForm();
		Thread.sleep(30000);
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	

	/*************************************************************************************
    'Description : Add a mandatory 'Single Line Text' question and verify that: 1. The question
                   is marked as mandatory in the 'Template Designer' screen. 2. When the form is tested 
                 (in the 'Review your changes' screen) without answering this question, it is indicated that
                 the question is mandatory. 3. The question is marked as mandatory when filling out the form.
               4. The form cannot be submitted without answering that question. 5. The question is marked as 
                  mandatory in the completed form (check) 
    'Precondition:
    'Date        : 07-Apr-2015
    'Author      : Sangappa.k
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	    **************************************************************************************/
	@Test(description = "Add a mandatory 'Single Line Text' question and verify that: 1. The question"
			+ " is marked as mandatory in the 'Template Designer' screen. 2. When the form is tested "
			+ "(in the 'Review your changes' screen) without answering this question, it is indicated that"
			+ " the question is mandatory. 3. The question is marked as mandatory when filling out the form"
			+ ". 4. The form cannot be submitted without answering that question. 5. The question is marked as"
			+ " mandatory in the completed form (check)")
    		
	public void testEdgeCase152598() throws Exception {

		gstrTCID = "152598";
		gstrTO = "Add a mandatory 'Single Line Text' question and verify that: 1. The question is marked as "
				+ "mandatory in the 'Template Designer' screen. 2. When the form is tested (in the 'Review your "
				+ "changes' screen) without answering this question, it is indicated that the question is mandatory. "
				+ "3. The question is marked as mandatory when filling out the form. 4. The form cannot besubmitted "
				+ "without answering that question. 5. The question is marked as mandatory in the completed form (check)";
		
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
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeFormOnIE(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);
				
			}
		}
		Thread.sleep(10000);

		objFormConfiguration1.verTemplateDesignPage();
		Thread.sleep(18000);
		objFormConfiguration1.clickOnInsert();
		objFormConfiguration1.clickOnGroupLink()
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
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary().selectRequiredCheckBox()
				.clickOnDoneButton()
	           .clickOnSaveButton();
	
		objFormConfiguration1
		.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(12000);
		
		String Templatepage = driver1.getWindowHandle();

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle1 = ite1.next().toString();

			if (!popupHandle1.contains(Templatepage)) {
				driver1.switchTo().window(popupHandle1);
				
			}
		}
		
		objFormConfiguration1
		.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
	   
		driver1.close();

		driver1.switchTo().window(Templatepage);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

	
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(10000);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);

		objFormConfiguration1
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName);
	
		objBlankForm.clearAnswerField(objFormConfiguration_data.strLabelName);
		objBlankForm.clickOnSave();
       
		objBlankForm
				.verifyRequiedTextForMandatoryQuestion(
						objFormConfiguration_data.strLabelName);
				

		objBlankForm
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strSinglelineTextAnswer);
			
		objBlankForm.clickOnComplete();
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName3);
		System.out.println("user3 " + objUserdata.strNewUserName3);
		objDispatchForm.clickOnDispatchForm();
		
		Thread.sleep(30000);  
		driver1.switchTo().window(mainWindowHandle1);
         
		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Verify that a question can be added by filling only mandatory fields of ‘Multi Line Text’question.  
    'Precondition  :
    'Peer Reviewed : Anil
    'Date          : 13-Apr-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	    **************************************************************************************/
	@Test(description = "Verify that a question can be added by filling only mandatory fields of ‘Multi Line Text’question.")
	public void testEdgeCase152618() throws Exception {

		gstrTCID = "152618";
		gstrTO = "Verify that a question can be added by filling only mandatory fields of ‘Multi Line Text’question.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		BlankFormData objBlankFormData = new BlankFormData();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(80000);

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}
		driver.navigate().refresh();

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
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.selectRequiredCheckBox().clickOnAddToSummary()
				.clickOnDoneButton().clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		objFormConfiguration.verifyPreviewButtonIsDisplayed()
				.clickPreviewButton();

		Thread.sleep(10000);
		driver.close();
		driver.switchTo().window(mainWindowHandle);

		String mainWindowHandle2 = driver.getWindowHandle();
		Set<String> a2 = driver.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver.switchTo().window(popupHandle);
			}
		}

		objFormConfiguration
				.verFormInPreviewPage(objFormConfiguration_data.strFormName);

		objFormConfiguration.verGroupNameInPreviewPage(
				objFormConfiguration_data.strGroupName)
				.verFieldSetNameInPreviewPage(
						objFormConfiguration_data.strAttributeName);
		objFormConfiguration
				.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		objFormConfiguration.verQuestionTypesInPreviewPage(
				objFormConfiguration_data.strAttributeName,
				objFormConfiguration_data.strLabelName)
				.verifyMultiLineTextQuestionIsDisabled(
						objFormConfiguration_data.strLabelName);

		objFormConfiguration.verPreviewButtonInPreviewPage();
		objFormConfiguration.verPrintButtonInPreviewPage();
		driver.close();
		driver.switchTo().window(mainWindowHandle2);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		Thread.sleep(5000);

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

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		objFormConfiguration1
				.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		objBlankForm.enterAnswerForMultiLineText(
				objFormConfiguration_data.strLabelName,
				objBlankFormData.strMultiLineTextAnswer).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		gstrResult= "PASS";
	}
	
	/*************************************************************************************
    'Description : Add a mandatory 'Multi Line Text' question and verify that: 
    1. The question is marked as mandatory in the 'Template Designer' screen. 
    2. When the form is previewed without answering this question, it is indicated that the question is mandatory. 
    3. The question is marked as mandatory when filling out the form. 
    4. The form cannot be submitted without answering that question.
    'Date        : 14-Apr-2015
    'Author      : Sangappa.k
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	    **************************************************************************************/
	@Test(description = "Add a mandatory 'Multi Line Text' question and verify that:"
			+ " 1. The question is marked as mandatory in the 'Template Designer' screen."
			+ " 2. When the form is previewed without answering this question, it is indicated that the question is mandatory."
			+ " 3. The question is marked as mandatory when filling out the form."
			+ " 4. The form cannot be submitted without answering that question.")
    		
	public void testEdgeCase152620() throws Exception {

		gstrTCID = "152620";
		gstrTO = "Add a mandatory 'Multi Line Text' question and verify that:"
				+ " 1. The question is marked as mandatory in the 'Template Designer' screen."
				+ " 2. When the form is previewed without answering this question, it is indicated that the question is mandatory"
				+ " 3. The question is marked as mandatory when filling out the form. "
				+ "4. The form cannot be submitted without answering that question.";
		
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
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
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
		Thread.sleep(10000);

		objFormConfiguration1.verTemplateDesignPage();
		Thread.sleep(18000);
		objFormConfiguration1.clickOnInsert();
		objFormConfiguration1.clickOnGroupLink()
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
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary().selectRequiredCheckBox()
				.clickOnDoneButton()
	           .clickOnSaveButton();
	
		objFormConfiguration1
		.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(12000);

		String TempPage = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(TempPage)) {
				driver1.switchTo().window(popupHandle);

			}
		}
 
		objFormConfiguration1
		.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		
		Thread.sleep(12000);
		driver1.close();
		
		driver1.switchTo().window(TempPage);
  
		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

	
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

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

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);

		objFormConfiguration1
				.verifyMandatoryMarkForQuestion(
						objFormConfiguration_data.strLabelName);

		objBlankForm.clickOnSave();
		Thread.sleep(10000);
       
		objBlankForm
				.verifyRequiedTextForMandatoryQuestion(
						objFormConfiguration_data.strLabelName);
	
		objBlankForm
				.enterAnswerInTextAreaField(objBlankFormData.strMultiLineTextAnswer);
		
		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName3);
		
		System.out.println("user3 " + objUserdata.strNewUserName3);
		
		objDispatchForm.clickOnDispatchForm();
		Thread.sleep(30000);  
		driver1.switchTo().window(mainWindowHandle1);
         
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Add an optional 'Date' question and verify that: 1. The question is not
                     marked as mandatory in the 'Template Designer' screen. 2. When the form is
                     previewed without answering this question, nothing is indicated. 3. The question
                     is not marked as mandatory when filling out the form. 4. The form can be submitted
                     without answering that question.  
    'Precondition  :
    'Peer Reviewed : Anil
    'Date          : 14-Apr-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	    **************************************************************************************/
	@Test(description = "Add an optional 'Date' question and verify that: 1. The question is not marked"
			+ " as mandatory in the 'Template Designer' screen. 2. When the form is previewed without"
			+ " answering this question, nothing is indicated. 3. The question is not marked as mandatory"
			+ " when filling out the form. 4. The form can be submitted without answering that question.")
	public void testEdgeCase152611() throws Exception {

		gstrTCID = "152611";
		gstrTO = "Add an optional 'Date' question and verify that: 1. The question is not marked as mandatory"
				+ " in the 'Template Designer' screen. 2. When the form is previewed without answering this question,"
				+ " nothing is indicated. 3. The question is not marked as mandatory when filling out the form. 4. "
				+ "The form can be submitted without answering that question.";

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(80000);

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}
		driver.navigate().refresh();

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
				.selectDateType(objFormConfiguration_data.strDate)
				.clickOnDoneButton();

		objFormConfiguration
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strDateQuestion)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.selectDateType(objFormConfiguration_data.strTime)
				.clickOnDoneButton();

		objFormConfiguration
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strDateQuestion)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.selectDateType(objFormConfiguration_data.strDateTime)
				.clickOnDoneButton();

		objFormConfiguration.clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		objFormConfiguration
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);
		objFormConfiguration
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName1);
		objFormConfiguration
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName2);

		objFormConfiguration.verifyPreviewButtonIsDisplayed()
				.clickPreviewButton();

		Thread.sleep(10000);
		driver.close();
		driver.switchTo().window(mainWindowHandle);

		String mainWindowHandle2 = driver.getWindowHandle();
		Set<String> a2 = driver.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver.switchTo().window(popupHandle);
			}
		}

		objFormConfiguration
				.verFormInPreviewPage(objFormConfiguration_data.strFormName);

		objFormConfiguration.verGroupNameInPreviewPage(
				objFormConfiguration_data.strGroupName)
				.verFieldSetNameInPreviewPage(
						objFormConfiguration_data.strAttributeName);
		objFormConfiguration
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);
		objFormConfiguration
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName1);
		objFormConfiguration
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName2);

		driver.close();
		driver.switchTo().window(mainWindowHandle2);

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

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		objFormConfiguration1
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);
		objFormConfiguration1
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName1);
		objFormConfiguration1
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName2);
		objBlankForm.clickOnSave();

		objFormConfiguration1
				.verRequiredTextIsNotDisplayedForOptionalQuestionType(
						objFormConfiguration_data.strLabelName)
				.verRequiredTextIsNotDisplayedForOptionalQuestionType(
						objFormConfiguration_data.strLabelName1)
				.verRequiredTextIsNotDisplayedForOptionalQuestionType(
						objFormConfiguration_data.strLabelName2);

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		gstrResult= "PASS";
	}


/*************************************************************************************
    'Description : Add an optional 'Numeric' question and verify that:
       1. The question is not marked as mandatory in the 'Template Designer' screen. 
       2. When the form is tested (in the 'Review your changes' screen)without answering this question, nothing is indicated.
       3. The question is not marked as mandatory when filling out the form.
       4. The form can be submitted without answering that question. 
    'Precondition:
    'Date        : 15-Apr-2015
    'Author      : Sangappa.k
	    **************************************************************************************/
	@Test(description = "Add an optional 'Numeric' question and verify that: 1. The question is not marked as mandatory"
			+ " in the 'Template Designer' screen. 2. When the form is tested (in the 'Review your changes' screen) without answering"
			+ " this question, nothing is indicated. 3. The question is not marked as mandatory when filling out the form. 4. The form"
			+ " can be submitted without answering that question. ")
    		
	public void testEdgeCase152603() throws Exception {

		gstrTCID = "152603";
		gstrTO = "Add an optional 'Numeric' question and verify that: 1. The question is not marked as mandatory in the 'Template Designer'"
				+ " screen. 2. When the form is tested (in the 'Review your changes' screen) without answering this question, nothing is indicated. 3. "
				+ "The question is not marked as mandatory when filling out the form. 4. The form can be submitted without answering that question. ";
		
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
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeFormOnIE(objFormConfiguration_data.strFormName);
		Thread.sleep(10000);
		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		
		objFormConfiguration1.verTemplateDesignPage();
		Thread.sleep(18000);
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();
		objFormConfiguration1
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(5000);

		String TempPage = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(TempPage)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);

		driver1.close();

		driver1.switchTo().window(TempPage);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objUserdata.strNewUserName2);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(10000);

		String mainWindowHandle1 = driver1.getWindowHandle();

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName);

		objFormConfiguration1
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);

		Thread.sleep(10000);
		objBlankForm.clickOnSave();

		objFormConfiguration1
				.verRequiredTextIsNotDisplayedForOptionalQuestionType(objFormConfiguration_data.strLabelName);

		objBlankForm.clickOnComplete();

		objDispatchForm
				.selUserToReceiveCompletedForm(objUserdata.strNewUserName3);
		System.out.println("user3 " + objUserdata.strNewUserName3);

		objDispatchForm.clickOnDispatchForm();
		Thread.sleep(30000);
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();
		
		

		gstrResult= "PASS";
	}
	
	/*************************************************************************************
    'Description   : Add an optional 'Multi Line Text' question and verify that: 1. The question is
                     not marked as mandatory in the 'Template Designer' screen. 2. When the form is
                     previewed without answering this question, nothing is indicated. 3. The question
                     is not marked as mandatory when filling out the form. 4. The form can be submitted
                     without answering that question. 
    'Precondition  :
    'Peer Reviewed : Anil
    'Date          : 15-Apr-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	    **************************************************************************************/
	@Test(description = "Add an optional 'Multi Line Text' question and verify that:"
			+ " 1. The question is not marked as mandatory in the 'Template Designer' screen. 2. When the"
			+ " form is previewed without answering this question, nothing is indicated. 3. The question is"
			+ " not marked as mandatory when filling out the form. 4. The form can be submitted without answering that question.")
	public void testEdgeCase152621() throws Exception {

		gstrTCID = "152621";
		gstrTO = " 	Add an optional 'Multi Line Text' question and verify that: 1. The question is not marked as"
				+ " mandatory in the 'Template Designer' screen. 2. When the form is previewed without answering this"
				+ " question, nothing is indicated. 3. The question is not marked as mandatory when filling out the form."
				+ " 4. The form can be submitted without answering that question.";

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(80000);

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
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnDoneButton();

		objFormConfiguration.clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		objFormConfiguration
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);

		objFormConfiguration.verifyPreviewButtonIsDisplayed()
				.clickPreviewButton();

		Thread.sleep(10000);

		String mainWindowHandle2 = driver.getWindowHandle();
		Set<String> a2 = driver.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver.switchTo().window(popupHandle);
			}
		}

		objFormConfiguration
				.verFormInPreviewPage(objFormConfiguration_data.strFormName);

		objFormConfiguration.verGroupNameInPreviewPage(
				objFormConfiguration_data.strGroupName)
				.verFieldSetNameInPreviewPage(
						objFormConfiguration_data.strAttributeName);
		objFormConfiguration
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);

		driver.close();
		driver.switchTo().window(mainWindowHandle2);
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

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		objFormConfiguration1
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);
		objBlankForm.clickOnSave();

		objFormConfiguration1
				.verRequiredTextIsNotDisplayedForOptionalQuestionType(objFormConfiguration_data.strLabelName);

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Add an optional 'Single Select' question and verify that: 1. The question
                     is not marked as mandatory in the 'Template Designer' screen. 2. When the
                     form is previewed without answering this question, nothing is indicated.
                     3. The question is not marked as mandatory when filling out the form.
                     4. The form can be submitted without answering that question.  
    'Precondition  :
    'Peer Reviewed : Anil
    'Date          : 16-Apr-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	    **************************************************************************************/
	@Test(description = "Add an optional 'Single Select' question and verify that: "
			+ "1. The question is not marked as mandatory in the 'Template Designer' screen. 2. When the form is "
			+ "previewed without answering this question, nothing is indicated. 3. The question is not marked as "
			+ "mandatory when filling out the form. 4. The form can be submitted without answering that question. ")
	public void testEdgeCase152640() throws Exception {

		gstrTCID = "152640";
		gstrTO = "Add an optional 'Single Select' question and verify that: 1. The question is not marked as"
				+ " mandatory in the 'Template Designer' screen. 2. When the form is previewed without answering"
				+ " this question, nothing is indicated. 3. The question is not marked as mandatory when filling"
				+ " out the form. 4. The form can be submitted without answering that question. ";

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(80000);

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
				.enterChoice(objFormConfiguration_data.strChoice)
				.enterNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice1)
				.selectDefaultForSingleSelect(
						objFormConfiguration_data.strChoice)
				.clickOnDoneButton();

		objFormConfiguration.clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		objFormConfiguration
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);

		objFormConfiguration.verifyPreviewButtonIsDisplayed()
				.clickPreviewButton();

		Thread.sleep(10000);

		String mainWindowHandle2 = driver.getWindowHandle();
		Set<String> a2 = driver.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver.switchTo().window(popupHandle);
			}
		}

		objFormConfiguration
				.verFormInPreviewPage(objFormConfiguration_data.strFormName);

		objFormConfiguration.verGroupNameInPreviewPage(
				objFormConfiguration_data.strGroupName)
				.verFieldSetNameInPreviewPage(
						objFormConfiguration_data.strAttributeName);
		objFormConfiguration
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);

		driver.close();
		driver.switchTo().window(mainWindowHandle2);
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

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		objFormConfiguration1
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);
		objBlankForm.clickOnSave();

		objFormConfiguration1
				.verRequiredTextIsNotDisplayedForOptionalQuestionType(objFormConfiguration_data.strLabelName);

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objFormConfiguration_data.strChoice;

		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickReviewForm();
		Thread.sleep(10000);

		String mainWindowHandle3 = driver1.getWindowHandle();

		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite3 = a3.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();
			if (!popupHandle.contains(mainWindowHandle3)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objBlankForm.verFormTitleInReviewForm(
				objFormConfiguration_data.strFormName)
				.verifyEnteredValueIsDisplayed(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice);

		objFormConfiguration1
				.verifyMandatoryMarkForQuestionIsNotDisplayed(objFormConfiguration_data.strLabelName);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle3);

		objRegionDefault1.selectFrame().verWebNotificationframe()
				.clickAcknowledgeAllForms();
		Thread.sleep(2000);
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description   : Add a 'Multi Select' questionnaire and verify that multiple answers can be
	                 selected from the dropdown: 1. In the 'Template Designer' screen. 2. While filling out form. 
	'Precondition  :
	'Peer Reviewed : Anil
	'Date	 	   : 17-Apr-2015
	'Author		   : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Add a 'Multi Select' questionnaire and verify that multiple answers can be "
			+ "selected from the dropdown: 1. In the 'Template Designer' screen. 2. While filling out form.")
	public void testEdgecase152641() throws Exception {

		gstrTCID = "152641";
		gstrTO = "Add a 'Multi Select' questionnaire and verify that multiple answers can be selected from"
				+ " the dropdown: 1. In the 'Template Designer' screen. 2. While filling out form.";

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
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
				.clickOnMandatoryCheckbox().clickOnNextButton()
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

		objFormConfiguration.verTemplateDesignPage();
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
				.selectQuestionType(objFormConfiguration_data.strMultiSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.addChoices(objFormConfiguration_data.strChoice)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice1)
				.clickOnAddToSummary().clickOnDoneButton();
		Thread.sleep(5000);
		objFormConfiguration
				.verifyAddedQueChoiceIsDisplayed(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice)
				.verifyAddedQueChoiceIsDisplayed(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice1)

				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(8000);

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

		Thread.sleep(3000);

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
				.selectSingleOption(objFormConfiguration_data.strChoice)
				.selectSingleOption(objFormConfiguration_data.strChoice1);

		objBlankForm.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//				+ ": " + objFormConfiguration_data.strChoice + ","
//				+ objFormConfiguration_data.strChoice1;

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strChoice1);
		
		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms();
		Thread.sleep(2000);
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();

		gstrResult = "PASS";

	}
	

	/*************************************************************************************
	'Description : Verify that a question can be added to the form by entering data in all the fields in the 'Template Designer' screen.
	'Precondition:
	'Date	 	 : 20-Apr-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a question can be added to the form by entering data in all the fields in the 'Template Designer' screen.")
	public void testEdgeCase152596() throws Exception {

		gstrTCID = "152596";
		gstrTO = "Verify that a question can be added to the form by entering data in all the fields in the 'Template Designer' screen.";

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
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);
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
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
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
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration1.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();
		
		Thread.sleep(10000);
		
		Set<String> a = driver1.getWindowHandles();
		
		Iterator<String> ite = a.iterator();
		
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
		
			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);
				System.out.println("new window");
			}
		}
		
		objFormConfiguration1.verTemplateDesignPage()
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
						    .selectNumberType(objFormConfiguration_data.strNumber)
						    .clickOnAddToSummary()
						    .selectRequiredCheckBox()
						   .enterDecimalPlaceValue(
								   	objFormConfiguration_data.strDecimalValue)
						    .enterDefaultValue(objFormConfiguration_data.strDefaultNum)
							.enterMinimumValue(objFormConfiguration_data.strMinimumvalue)
							.enterMaximumValue(objFormConfiguration_data.strMaximumvalue)
						    .enterTextInToolTipHelp(
						    			objFormConfiguration_data.strToolTipHelp)
							.enterTextInReportLabel(
									objFormConfiguration_data.strReportLabel)
						    .clickOnDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strText)
						    .enterLabelName(objFormConfiguration_data.strLabelName1)
						    .clickOnAddToSummary()
						    .enterTextInToolTipHelp(
						    			objFormConfiguration_data.strToolTipHelp)
							.enterTextInReportLabel(
									objFormConfiguration_data.strReportLabel)
							.selectRequiredCheckBox()
							.enterMinimumLength(objFormConfiguration_data.strMinimumvalue)
						    .enterMaximumLength(objFormConfiguration_data.strMaximumvalue)
							.enterDefaultValue(objBlankFormData.strTextAnswer1)
						    .clickOnDoneButton()				    
						    .clickOnSaveButton();
		
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);
		
		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle);
		
		objRegionDefault1.selectFrame();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1.clickOnFillForm(objFormConfiguration_data.strFormName);
		
		String mainWindowHandle1 = driver1.getWindowHandle();
		
		Thread.sleep(3000);
		
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
					.verDefaultValue(objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strDefaultNum)
					.verDefaultValue(objFormConfiguration_data.strLabelName1,
								objBlankFormData.strTextAnswer1);
		
		objFormConfiguration1.verifyMandatoryMarkForQuestion(
				objFormConfiguration_data.strLabelName)
				.verifyMandatoryMarkForQuestion(
				objFormConfiguration_data.strLabelName1)
				.verifyToolTipQuestionMarkSymbol(
						objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strToolTipHelp)	
				.verifyToolTipQuestionMarkSymbol(
						objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strToolTipHelp);
		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,objBlankFormData.strTextAnswer)
					.clickOnSave();

		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
							objUserdata.strNewUserName1)
					   .clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName1,
						 		 objUserdata.strNewPassword);
		
//		String strMsg = "Submitted by "+objUserdata.strFullName+"\nSummary: | "
//						+ objFormConfiguration_data.strLabelName + ": "
//						+ objBlankFormData.strNumericAnswer + "| "
//						+ objFormConfiguration_data.strLabelName1 + ": "
//						+ objBlankFormData.strTextAnswer;

		String strMsg = objRegionDefault1
				.getWebNotificationForTwoQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer,
						objFormConfiguration_data.strLabelName1,
						objBlankFormData.strTextAnswer);
		
		Thread.sleep(5000);
        
        objRegionDefault1.selectFrame()
                       	 .verWebNotificationframe()
                         .verWebNotificationMsgForForms(objFormConfiguration_data.strFormName,
                                     						strMsg)
						.clickAcknowledgeAllForms()
						.selectFrame();
        
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Add a mandatory 'Single Select' question and verify that: 1. The question is
                     marked as mandatory in the 'Template Designer' screen. 2. When the form is previewed
                     without answering this question, it is indicated that the question is mandatory. 
                     3. The question is marked as mandatory when filling out the form. 
                     4. The form cannot be submitted without answering that question.
    'Precondition  :
    'Peer Reviewed : Anil
    'Date          : 20-Apr-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Add a mandatory 'Single Select' question and verify that: 1. The question is"
			+ "marked as mandatory in the 'Template Designer' screen. 2. When the form is previewed"
			+ " without answering this question, it is indicated that the question is mandatory. "
			+ "3. The question is marked as mandatory when filling out the form. "
			+ "4. The form cannot be submitted without answering that question.")
	public void testEdgeCase152639() throws Exception {

		gstrTCID = "152639";
		gstrTO = "Add a mandatory 'Single Select' question and verify that: 1. The question is marked as"
				+ " mandatory in the 'Template Designer' screen. 2. When the form is previewed without answering "
				+ "this question, it is indicated that the question is mandatory. 3. The question is marked as mandatory"
				+ " when filling out the form. 4. The form cannot be submitted without answering that question.";

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(80000);

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
				.enterChoice(objFormConfiguration_data.strChoice)
				.enterNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice1)
				.selectRequiredCheckBox().clickOnDoneButton();

		objFormConfiguration.clickOnSaveButton();
		objFormConfiguration
				.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		Thread.sleep(5000);
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		objFormConfiguration.verifyPreviewButtonIsDisplayed()
				.clickPreviewButton();

		Thread.sleep(10000);

		String mainWindowHandle2 = driver.getWindowHandle();
		Set<String> a2 = driver.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver.switchTo().window(popupHandle);
			}
		}

		objFormConfiguration
				.verFormInPreviewPage(objFormConfiguration_data.strFormName);

		objFormConfiguration.verGroupNameInPreviewPage(
				objFormConfiguration_data.strGroupName)
				.verFieldSetNameInPreviewPage(
						objFormConfiguration_data.strAttributeName);
		objFormConfiguration
				.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);

		driver.close();
		driver.switchTo().window(mainWindowHandle2);
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

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		objFormConfiguration1
				.verifyMandatoryMarkForQuestion(objFormConfiguration_data.strLabelName);
		objBlankForm.clickOnSave();
		objBlankForm
				.verRequiredTextIsDisplayedForMandatoryQuestionType(objFormConfiguration_data.strLabelName);
		objBlankForm.selectSingleOption(objFormConfiguration_data.strChoice);

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Add a 'Multi Line Text' question by providing a value X in the 'Max length' field and verify that: 
                     1. In the 'Template Designer' screen: 
                     a. Answer more thanX characters is not accepted. 
                     b. Answer upto X characters is accepted. 
                     2. While filling out the form:
                     a. Answer more than X characters is not accepted. 
                     b. Answer unto X characters is accepted. 
    'Precondition  :
    'Peer Reviewed : Anil
    'Date          : 21-Apr-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Add a 'Multi Line Text' question by providing a value X in the 'Max length' field and verify that:"
			+ " 1. In the 'Template Designer' screen: a. Answer more than X characters is not accepted."
			+ " b. Answer upto X characters is accepted. 2. While filling out the form: a. Answer more than X "
			+ "characters is not accepted. b. Answer unto X characters is accepted.")
	public void testEdgeCase152632() throws Exception {

		gstrTCID = "152632";
		gstrTO = "Add a 'Multi Line Text' question by providing a value X in the 'Max length' field and verify that: "
				+ "1. In the 'Template Designer' screen: a. Answer more than X characters is not accepted. b. Answer "
				+ "upto X characters is accepted. 2. While filling out the form: a. Answer more than X characters is not accepted."
				+ " b. Answer unto X characters is accepted. ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormData = new BlankFormData();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();
		Thread.sleep(80000);

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
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
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.enterMaximumLength(objFormConfiguration_data.strMaximumvalue1)
				.clickOnDoneButton();

		objFormConfiguration1.clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration1.clickOnPublishButton();
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
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName);
		int i1 = Integer.parseInt(objFormConfiguration_data.strMaximumvalue1);
		String str1 = "";
		while (str1.length() < i1) {
			str1 = str1 + objBlankFormData.strMultiLineTextAnswer;
		}

		String str[] = {
				objBlankFormData.strMultiLineTextAnswer,
				str1,
				str1.substring(
						0,
						((objBlankFormData.strMultiLineTextAnswer).length()) - 2) };
		for (int i = 0; i < str.length; i++) {

			objBlankForm.enterAnswerForMultiLineText(
					objFormConfiguration_data.strLabelName, str[i])
					.clickOnSave();
			Thread.sleep(10000);
			if (str[i].length() <= i1) {
				objBlankForm
						.verErrorMsgNotDisplayedForMaxLengthForMultiLineTextQuestionType(
								objFormConfiguration_data.strLabelName,
								objFormConfiguration_data.strMaximumvalue1);

			} else {
				objBlankForm
						.verErrorMsgDisplayedForMaxLengthForMultiLineTextQuestionType(
								objFormConfiguration_data.strLabelName,
								objFormConfiguration_data.strMaximumvalue1);

			}

		}

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	
	/*************************************************************************************
    'Description : Add a 'Date' question by selecting only 'Future dates only (excluding today)'and
     verify that: 1. In the 'Template Designer' screen: a. Current date is not accepted. b. Past date
     is not accepted. c. Future date is accepted. 2. While filling out the form: a. Current date is 
      not accepted. b. Past date is not accepted. c. Future date is accepted.  
    'Precondition:
    'Date        : 21-Apr-2015
    'Author      : Sangappa.k
	    **************************************************************************************/
	@Test(description = "Add a 'Date' question by selecting only 'Future dates only"
			+ " (excluding today)' and verify that: 1. In the 'Template Designer' screen: a. Current date is "
			+ "not accepted. b. Past date is not accepted. c. Future date is accepted. 2. While filling out the"
			+ " form: a. Current date is not accepted. b. Past date is not accepted. c. Future date is accepted.")
    		
	public void testEdgeCase152613() throws Exception {

		gstrTCID = "152613";
		gstrTO = "Add a 'Date' question by selecting only 'Future dates only (excluding today)' and verify that: 1."
				+ " In the 'Template Designer' screen: a. Current date is not accepted. b. Past date is not accepted."
				+ " c. Future date is accepted. 2. While filling out the form: a. Current date is not accepted. b. Past"
				+ " date is not accepted. c. Future date is accepted. ";
		
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
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Date_Time_settings Dts = new Date_Time_settings();
		EventManagement objEventManagement1 = new EventManagement(driver1);

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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
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
		Thread.sleep(10000);

		objFormConfiguration1.verTemplateDesignPage();
		Thread.sleep(18000);
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

				// Date type
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strDateQuestion)
				.selectDateType(objFormConfiguration_data.strDate)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.selectAllowedDatesRadioButtonForDateQuestionType(
						objFormConfiguration_data.strFutureDatesonlyExcludingToday)
				.clickOnDoneButton().clickOnSaveButton();
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);

		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(12000);

		String TempPage = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(TempPage)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1.verQuestionTypesInPreviewPage(
				objFormConfiguration_data.strAttributeName,
				objFormConfiguration_data.strLabelName);

		driver1.close();

		driver1.switchTo().window(TempPage);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		objRegionDefault1.selectFrame();
		Thread.sleep(10000);
		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = Dts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		String Currentdate = Dts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");
		String Futuredate = Dts.AddDaytoExistingDate(Currentdate, 1,
				"MM/dd/yyyy");
		String[] Pastdate = Currentdate.split("/");
		Integer x = Integer.valueOf(Pastdate[1]);
		x = x - 3;
		String Pastdate1 = String.valueOf(x);
		String pastdate1 = Pastdate[0] + "/" + Pastdate1 + "/" + Pastdate[2];

		System.out.println("current  date " + Currentdate);
		System.out.println(" futre date " + Futuredate);
		System.out.println("past date " + pastdate1);

		System.out.println("x date " + Pastdate1);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(10000);

		String mainWindowHandle1 = driver1.getWindowHandle();

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				pastdate1).strClickOnDoneButtonOfCalender();
		Thread.sleep(8000);
		objBlankForm
				.verTextIsDisplayedForFutureDatesOnlyExcludingOrIncludingToday(
						objFormConfiguration_data.strLabelName, Futuredate)
				.clearAnswerField(objFormConfiguration_data.strLabelName);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				Currentdate).strClickOnDoneButtonOfCalender();
		Thread.sleep(8000);
		objBlankForm
				.verTextIsDisplayedForFutureDatesOnlyExcludingOrIncludingToday(
						objFormConfiguration_data.strLabelName, Futuredate);

		objBlankForm.clearAnswerField(objFormConfiguration_data.strLabelName);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				Futuredate).strClickOnDoneButtonOfCalender();
		Thread.sleep(8000);
		objBlankForm.clickOnSave();
		Thread.sleep(8000);
		objBlankForm.clickOnComplete();
		Thread.sleep(10000);
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName3).clickOnDispatchForm();
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description : Add a 'Date' question by selecting 'Date range between mm/dd/yyyy and mm/dd/yyyy'
     and verify that: 1. In the 'Template Designer' screen: a. Date apart from the provided range is
     not accepted. b. Date in the provided range is accepted 2. While filling out the form: a. Date apart
      from the provided range is not accepted. b. Date in the provided range is accepted   
    'Precondition:
    'Date        : 22-Apr-2015
    'Author      : Sangappa.k
	    **************************************************************************************/
	@Test( description = "Add a 'Date' question by selecting 'Date range between"
			+ " mm/dd/yyyy and mm/dd/yyyy' and verify that: 1. In the 'Template Designer' screen: a. "
			+ "Date apart from the provided range is not accepted. b. Date in the provided range is accepted "
			+ "2. While filling out the form: a. Date apart from the provided range is not accepted. b. Date in"
			+ " the provided range is accepted ")
    		
	public void testEdgeCase152615() throws Exception {

		gstrTCID = "152615";
		gstrTO = "Add a 'Date' question by selecting 'Date range between mm/dd/yyyy and mm/dd/yyyy' and verify that: "
				+ "1. In the 'Template Designer' screen: a. Date apart from the provided range is not accepted. b. Date"
				+ " in the provided range is accepted 2. While filling out the form: a. Date apart from the provided range"
				+ " is not accepted. b. Date in the provided range is accepted";
		
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
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Date_Time_settings Dts = new Date_Time_settings();
		EventManagement objEventManagement1 = new EventManagement(driver1);

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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = Dts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		String strFromDate = Dts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");
		String strToDate = Dts.AddDaytoExistingDate(strFromDate, 4,
				"MM/dd/yyyy");
		System.out.println("from date " + strFromDate);
		System.out.println("To date " + strToDate);

		String[] strFromdate = strFromDate.split("/");
		String[] strTodate = strToDate.split("/");

		objFormConfiguration1
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
		Thread.sleep(10000);

		objFormConfiguration1.verTemplateDesignPage();
		Thread.sleep(18000);
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
				.selectQuestionType(objFormConfiguration_data.strDateQuestion)
				.selectDateType(objFormConfiguration_data.strDate)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.selectDateRangeBetweenRadioBtnForDateQuestionType()
				.entereStartDateForDateRangeBetweenRadioBtn(strFromDate)
				.entereEndDateForDateRangeBetweenRadioBtn(strToDate)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(12000);
		
		String TempPage = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(TempPage)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		

		objFormConfiguration1.verQuestionTypesInPreviewPage(
				objFormConfiguration_data.strAttributeName,
				objFormConfiguration_data.strLabelName);

		driver1.close();

		driver1.switchTo().window(TempPage);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		objRegionDefault1.selectFrame();
		Thread.sleep(10000);
		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(10000);

		String mainWindowHandle1 = driver1.getWindowHandle();

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName);

		// entere Before  date
		int x = Integer.valueOf(strFromdate[1]);
		x = x - 2;
		String x1 = String.valueOf(x);
		String strBeforeFromDate = strFromdate[0] + "/" + x1 + "/"
				+ strFromdate[2];
		System.out.println("Berfore date  " + strBeforeFromDate);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				strBeforeFromDate).strClickOnDoneButtonOfCalender();

		Thread.sleep(8000);

		objBlankForm.verTextIsDisplayedForDateRangeBetweenRadioBtn(
				objFormConfiguration_data.strLabelName, strFromDate, strToDate)

		.clearAnswerField(objFormConfiguration_data.strLabelName);

		// entere After date
		
		int y = Integer.valueOf(strTodate[1]);
		y = y + 2;
		String y1 = String.valueOf(y);
		String strAftereToDate = strTodate[0] + "/" + y1 + "/" + strTodate[2];

		System.out.println("Aftere date  " + strAftereToDate);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				strAftereToDate).strClickOnDoneButtonOfCalender();

		Thread.sleep(8000);
		objBlankForm.verTextIsDisplayedForDateRangeBetweenRadioBtn(
				objFormConfiguration_data.strLabelName, strFromDate, strToDate);

		objBlankForm.clearAnswerField(objFormConfiguration_data.strLabelName);

		// enter date which is between range
		int z = Integer.valueOf(strFromdate[1]);
		z = z + 1;
		String z1 = String.valueOf(z);
		String strDateBetween = strFromdate[0] + "/" + z1 + "/"
				+ strFromdate[2];
         System.out.println("Between date  " + strBeforeFromDate);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				strDateBetween).strClickOnDoneButtonOfCalender();

		Thread.sleep(8000);
		objBlankForm.clickOnSave();
		Thread.sleep(8000);
		objBlankForm.clickOnComplete();
		Thread.sleep(10000);
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName3).clickOnDispatchForm();
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Add a 'Date' question by selecting only 'Past dates only (excluding today)' and verify that:
                     1. In the 'Template Designer' screen: a. Current date is not accepted. b. Future date is not accepted.
                     c. Past date is accepted. 2. While filling out the form: a. Current date is not accepted. 
                     b. Future date is not accepted. c. Past date is accepted. 
    'Precondition  :
    'Peer Reviewed : Anil
    'Date          : 22-Apr-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Add a 'Date' question by selecting only 'Past dates only (excluding today)' and verify that:"
			+ " 1. In the 'Template Designer' screen: a. Current date is not accepted. b. Future date is not accepted."
			+ " c. Past date is accepted. 2. While filling out the form: a. Current date is not accepted. "
			+ "b. Future date is not accepted. c. Past date is accepted.")
	public void testEdgeCase152612() throws Exception {

		gstrTCID = "152612";
		gstrTO = " 	Add a 'Date' question by selecting only 'Past dates only (excluding today)' and verify that:"
				+ " 1. In the 'Template Designer' screen: a. Current date is not accepted. b. Future date is not accepted."
				+ " c. Past date is accepted. 2. While filling out the form: a. Current date is not accepted."
				+ " b. Future date is not accepted. c. Past date is accepted.";

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();

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
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();
		Thread.sleep(80000);

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
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
				.clickOnPastDatesOnlyExcludingTodayRadioButton()
				.clickOnDoneButton();

		objFormConfiguration1.clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String strApplicationDate = objEventManagement
				.getApplicationTimeWithCSTCDT();
		System.out.println(strApplicationDate);

		String[] strDate = strApplicationDate.split(" ");
		System.out.println(strDate);

		String strCurrentDate = objDts.getCurrentDate("dd");
		System.out.println(strCurrentDate);

		String strStartDate = "";
		int intDate = Integer.parseInt(strDate[0]);
		System.out.println(intDate);

		int intCurrentDate = Integer.parseInt(strCurrentDate);

		if (intDate == intCurrentDate) {
			strStartDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate < intCurrentDate) {
				strStartDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strStartDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}

		String str1 = objDts
				.AddDaytoExistingDate(strStartDate, 1, "MM/dd/yyyy");
		String str2 = objDts.AddDaytoExistingDate(strStartDate, -1,
				"MM/dd/yyyy");
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

				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						strStartDate).strClickOnDoneButtonOfCalender();
		Thread.sleep(10000);
		objBlankForm
				.verErrorMsgDisplayedForPastDateOnlyExcludingOrIncludingTodayDateQuestionType(
						objFormConfiguration_data.strLabelName, str2)

				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						str1).strClickOnDoneButtonOfCalender();
		Thread.sleep(10000);
		objBlankForm
				.verErrorMsgDisplayedForPastDateOnlyExcludingOrIncludingTodayDateQuestionType(
						objFormConfiguration_data.strLabelName, str2);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				str2);
		Thread.sleep(10000);
		objBlankForm.strClickOnDoneButtonOfCalender();
		Thread.sleep(10000);
		objBlankForm.clickOnSave();
		Thread.sleep(10000);
		objBlankForm
				.verErrorMsgNotDisplayedForPastDateOnlyExcludingOrIncludingTodayDateQuestionType(
						objFormConfiguration_data.strLabelName, str2);

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
    'Description   : Add a 'Date' question by selecting only 'Past dates only (including today)' and verify that:
                     1. In the 'Template Designer' screen: a. Current date is accepted. b. Future date is not accepted.
                     c. Past date is accepted. 2. While filling out the form: a. Current date is accepted. 
                     b. Future date is not accepted. c. Past date is accepted.  
    'Precondition  :
    'Peer Reviewed : Anil
    'Date          : 23-Apr-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Add a 'Date' question by selecting only 'Past dates only (including today)' and verify that:"
			+ " 1. In the 'Template Designer' screen: a. Current date is accepted. b. Future date is not accepted."
			+ " c. Past date is accepted. 2. While filling out the form: a. Current date is accepted. b. Future date is not accepted. "
			+ "c. Past date is accepted. ")
	public void testEdgeCase152617() throws Exception {

		gstrTCID = "152617";
		gstrTO = "Add a 'Date' question by selecting only 'Past dates only (including today)' and verify that: "
				+ "1. In the 'Template Designer' screen: a. Current date is accepted. b. Future date is not accepted. "
				+ "c. Past date is accepted. 2. While filling out the form: a. Current date is accepted. b. Future date is not accepted."
				+ " c. Past date is accepted. ";

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();

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
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();
		Thread.sleep(8000);

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
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
				.selectAllowedDatesRadioButtonForDateQuestionType(
						objFormConfiguration_data.strPastdateonlyIncludingToday)
				.clickOnDoneButton();

		objFormConfiguration1.clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String strApplicationDate = objEventManagement
				.getApplicationTimeWithCSTCDT();
		System.out.println(strApplicationDate);

		String[] strDate = strApplicationDate.split(" ");
		System.out.println(strDate);

		String strCurrentDate = objDts.getCurrentDate("dd");
		System.out.println(strCurrentDate);

		String strStartDate = "";
		int intDate = Integer.parseInt(strDate[0]);
		System.out.println(intDate);

		int intCurrentDate = Integer.parseInt(strCurrentDate);

		if (intDate == intCurrentDate) {
			strStartDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate < intCurrentDate) {
				strStartDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strStartDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}

		String str1 = objDts
				.AddDaytoExistingDate(strStartDate, 1, "MM/dd/yyyy");
		String str2 = objDts.AddDaytoExistingDate(strStartDate, -1,
				"MM/dd/yyyy");
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

				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						strStartDate).strClickOnDoneButtonOfCalender();
		Thread.sleep(10000);
		objBlankForm
				.verErrorMsgNotDisplayedForPastDateOnlyExcludingOrIncludingTodayDateQuestionType(
						objFormConfiguration_data.strLabelName, strStartDate)

				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						str1).strClickOnDoneButtonOfCalender();
		Thread.sleep(10000);
		objBlankForm
				.verErrorMsgDisplayedForPastDateOnlyExcludingOrIncludingTodayDateQuestionType(
						objFormConfiguration_data.strLabelName, strStartDate);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				str2);
		Thread.sleep(10000);
		objBlankForm.strClickOnDoneButtonOfCalender();
		Thread.sleep(10000);
		objBlankForm.clickOnSave();
		Thread.sleep(10000);
		objBlankForm
				.verErrorMsgNotDisplayedForPastDateOnlyExcludingOrIncludingTodayDateQuestionType(
						objFormConfiguration_data.strLabelName, strStartDate);

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
   /*************************************************************************************
    'Description   : Add a 'Date' question by selecting only 'Future dates only (including today)' and verify that:
                     1. In the 'Template Designer' screen: a. Current date is accepted. b. Past date is not accepted.
                     c. Future date is accepted. 2. While filling out the form: a. Current date is accepted.
                     b. Past date is not accepted. c. Future date is accepted.   
    'Precondition  :
    'Peer Reviewed : Anil
    'Date          : 24-Apr-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Add a 'Date' question by selecting only 'Future dates only (including today)' and verify that:"
			+ " 1. In the 'Template Designer' screen: a. Current date is accepted. b. Past date is not accepted."
			+ " c. Future date is accepted. 2. While filling out the form: a. Current date is accepted."
			+ " b. Past date is not accepted. c. Future date is accepted. ")
	public void testEdgeCase152616() throws Exception {

		gstrTCID = "152616";
		gstrTO = "Add a 'Date' question by selecting only 'Future dates only (including today)' and verify that:"
				+ " 1. In the 'Template Designer' screen: a. Current date is accepted. b. Past date is not accepted. "
				+ "c. Future date is accepted. 2. While filling out the form: a. Current date is accepted. b. Past date is not accepted."
				+ " c. Future date is accepted. ";

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
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();

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
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();
		Thread.sleep(8000);

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
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
				.selectAllowedDatesRadioButtonForDateQuestionType(
						objFormConfiguration_data.strFutureDatesonlyIncludingToday)
				.clickOnDoneButton();

		objFormConfiguration1.clickOnSaveButton();
		Thread.sleep(5000);
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();
		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String strApplicationDate = objEventManagement
				.getApplicationTimeWithCSTCDT();
		System.out.println(strApplicationDate);

		String[] strDate = strApplicationDate.split(" ");
		System.out.println(strDate);

		String strCurrentDate = objDts.getCurrentDate("dd");
		System.out.println(strCurrentDate);

		String strStartDate = "";
		int intDate = Integer.parseInt(strDate[0]);
		System.out.println(intDate);

		int intCurrentDate = Integer.parseInt(strCurrentDate);

		if (intDate == intCurrentDate) {
			strStartDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if (intDate < intCurrentDate) {
				strStartDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			} else {
				strStartDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}

		String str1 = objDts
				.AddDaytoExistingDate(strStartDate, 1, "MM/dd/yyyy");
		String str2 = objDts.AddDaytoExistingDate(strStartDate, -1,
				"MM/dd/yyyy");
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

				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						strStartDate);//.strClickOnDoneButtonOfCalender();
		Thread.sleep(10000);
		objBlankForm
				.verTextIsNotDisplayedForFutureDatesOnlyExcludingOrIncludingToday(
						objFormConfiguration_data.strLabelName, strStartDate)

				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						str1).strClickOnDoneButtonOfCalender();
		Thread.sleep(10000);
		objBlankForm.verTextIsNotDisplayedForFutureDatesOnlyExcludingOrIncludingToday(
				objFormConfiguration_data.strLabelName, strStartDate);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				str2);
		Thread.sleep(10000);
		objBlankForm.strClickOnDoneButtonOfCalender();
		Thread.sleep(10000);
		objBlankForm.clickOnSave();
		Thread.sleep(10000);
		objBlankForm.verTextIsDisplayedForFutureDatesOnlyExcludingOrIncludingToday(
				objFormConfiguration_data.strLabelName, strStartDate);

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*************************************************************************************
    'Description : Add a 'Date' question by selecting 'Date range between XXXX days ago and YYYY days
     from now' and verify that: 1. In the 'Template Designer' screen: a. Date before 'XXXX' days is not
     accepted. b. XXXX days date is accepted. c. Date after YYYY is not accepted. 2. While filling out
     the form: a. Date before 'XXXX' days is not accepted. b. XXXX days date is accepted. c. Date after
      YYYY is not accepted. 
    'Date        : 23-Apr-2015
    'Author      : Sangappa.k
	    **************************************************************************************/
	@Test(description = "Add a 'Date' question by selecting 'Date range between "
			+ "XXXX days ago and YYYY days from now' and verify that: 1. In the 'Template Designer' screen: "
			+ "a. Date before 'XXXX' days is not accepted. b. XXXX days date is accepted. c. Date after YYYY "
			+ "is not accepted. 2. While filling out the form: a. Date before 'XXXX' days is not accepted."
			+ " b. XXXX days date is accepted. c. Date after YYYY is not accepted. ")
    		
	public void testEdgeCase152614() throws Exception {

		gstrTCID = "152614";
		gstrTO = "Add a 'Date' question by selecting 'Date range between XXXX days ago and YYYY days from now'"
				+ " and verify that: 1. In the 'Template Designer' screen: a. Date before 'XXXX' days is not "
				+ "accepted. b. XXXX days date is accepted. c. Date after YYYY is not accepted. 2. While filling "
				+ "out the form: a. Date before 'XXXX' days is not accepted. b. XXXX days date is accepted. "
				+ "c. Date after YYYY is not accepted. ";
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		BlankFormData objBlankFormdata = new BlankFormData();
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
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Date_Time_settings Dts = new Date_Time_settings();
		EventManagement objEventManagement1 = new EventManagement(driver1);

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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = Dts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		String strApptime = Dts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy");
		objFormConfiguration1
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
		Thread.sleep(10000);

		objFormConfiguration1.verTemplateDesignPage();
		Thread.sleep(18000);
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
				.selectQuestionType(objFormConfiguration_data.strDateQuestion)
				.selectDateType(objFormConfiguration_data.strDate)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.selXDayAgoAndYDaysFromNowRadioBtn()
				.enterStartCountForXDaysAgoField(
						objBlankFormdata.strXDaysAgoCount)
				.entersEndCountForYDaysNowField(
						objBlankFormdata.strYDaysFromNowCount)
				.clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(12000);
		String TempPage = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(TempPage)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1.verQuestionTypesInPreviewPage(
				objFormConfiguration_data.strAttributeName,
				objFormConfiguration_data.strLabelName);

		driver1.close();

		driver1.switchTo().window(TempPage);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		objRegionDefault1.selectFrame();
		Thread.sleep(10000);
		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(10000);

		String mainWindowHandle1 = driver1.getWindowHandle();

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName);

		// get start date
		String strMinusDay = "-" + objBlankFormdata.strXDaysAgoCount;
		int x = Integer.valueOf(strMinusDay);
		String strStartDate = Dts.AddDaytoExistingDate(strApptime, x,
				"MM/dd/yyyy");
		System.out.println("start date  " + strStartDate);

		// get end date
		String strPlusDay = objBlankFormdata.strYDaysFromNowCount;
		int y = Integer.valueOf(strPlusDay);
		String strEndDate = Dts.AddDaytoExistingDate(strApptime, y,
				"MM/dd/yyyy");
		System.out.println("End date  " + strEndDate);

		// Date before start day

		String strDateBeforStartDate = Dts.AddDaytoExistingDate(strStartDate,
				-4, "MM/dd/yyyy");
		System.out.println("date before start day  " + strDateBeforStartDate);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				strDateBeforStartDate).strClickOnDoneButtonOfCalender();

		Thread.sleep(8000);

		objBlankForm.verTxtIsDisplayedForXdaysAgoAndYdaysAfterRdBtn(
				objFormConfiguration_data.strLabelName, strStartDate,
				strEndDate)

		.clearAnswerField(objFormConfiguration_data.strLabelName);

		// Date after end date

		String strDateAfterEndDate = Dts.AddDaytoExistingDate(strEndDate, +2,
				"MM/dd/yyyy");
		System.out.println("Aftere date  " + strDateAfterEndDate);

		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				strDateAfterEndDate).strClickOnDoneButtonOfCalender();

		Thread.sleep(8000);
		objBlankForm.verTxtIsDisplayedForXdaysAgoAndYdaysAfterRdBtn(
				objFormConfiguration_data.strLabelName, strStartDate,
				strEndDate);

		objBlankForm.clearAnswerField(objFormConfiguration_data.strLabelName);

		// start day
		objBlankForm.enterAnswerInField(objFormConfiguration_data.strLabelName,
				strStartDate).strClickOnDoneButtonOfCalender();

		Thread.sleep(8000);
		objBlankForm.clickOnSave();
		Thread.sleep(8000);
		objBlankForm.clickOnComplete();
		Thread.sleep(10000);
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName3).clickOnDispatchForm();
		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	
	/*************************************************************************************
	'Description : Verify that a question can be added by filling only mandatory fields of ‘Date’ question 
	'Precondition:
	'Date	 	 : 04-May-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a question can be added by filling only mandatory fields of ‘Date’ question")
	public void testEdgecase152608() throws Exception {

		gstrTCID = "152608";
		gstrTO = "Verify that a question can be added by filling only mandatory fields of ‘Date’ question";

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
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
				.clickOnMandatoryCheckbox().clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
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
		Thread.sleep(10000);
		objFormConfiguration1.verTemplateDesignPage();
		Thread.sleep(10000);
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
				.selectQuestionType(objFormConfiguration_data.strDateTime)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnDoneButton()

				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(8000);

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

		Thread.sleep(3000);

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName);

		objBlankForm.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Add a 'Numeric' question by providing a value X in the 'Decimal places' field and verify that:
	               1. In the 'Template Designer' screen: a. Answer more than X decimal digits is not accepted. 
	               b. Answer upto X decimal digits is accepted. 2. While filling out the form: 
	               a. Answer more than X decimal digits is not accepted. b. Answer upto X decimal digits is accepted.  
	'Precondition:
	'Date	 	 : 05-May-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Add a 'Numeric' question by providing a value X in the 'Decimal places' field and verify that:"
			+ " 1. In the 'Template Designer' screen: a. Answer more than X decimal digits is not accepted. "
			+ "b. Answer upto X decimal digits is accepted. 2. While filling out the form: a. Answer more than"
			+ " X decimal digits is not accepted. b. Answer upto X decimal digits is accepted.")
	public void testEdgecase152605() throws Exception {

		gstrTCID = "152605";
		gstrTO = "Add a 'Numeric' question by providing a value X in the 'Decimal places' field and verify that: 1. In the 'Template Designer' screen:"
				+ " a. Answer more than X decimal digits is not accepted. b. Answer upto X decimal digits is accepted. 2. While filling out the form: "
				+ "a. Answer more than X decimal digits is not accepted. b. Answer upto X decimal digits is accepted.";

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
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

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

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration.verTemplateDesignPage();
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
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.enterDecimalPlaceValue(
						objFormConfiguration_data.strDecimalValue)
				.clickOnDoneButton()

				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(8000);
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

		Thread.sleep(3000);

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
				.verFieldSetName(objFormConfiguration_data.strAttributeName);

		int i1 = Integer.parseInt(objFormConfiguration_data.strDecimalValue);

		String[] str = { "22.22", "22.222", "22.22222" };
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

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Delete multiple questions and verify that the particular questions are no longer displayed in the Form creator screen
	'Precondition:
	'Date	 	 : 05-May-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Delete multiple questions and verify that the particular questions are no longer displayed in the Form creator screen")
	public void testEdgeCase154828() throws Exception {
		
		gstrTCID = "154828";
		gstrTO = "Delete multiple questions and verify that the particular questions are no longer displayed in the Form creator screen";

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
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName1)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(80000);
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
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary()
				.clickOnDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.selectQuestionType(objFormConfiguration_data.strMultiSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName3)
				.clickOnAddToSummary()
				.clickOnDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.selectQuestionType(objFormConfiguration_data.strSingleSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName4)
				.clickOnAddToSummary()
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

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1.verFormConfigurePage().clickOnAcknowledgeForm(
				objFormConfiguration_data.strFormName);

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
				.deleteAQuestion(objFormConfiguration_data.strLabelName3)
				.deleteAQuestion(objFormConfiguration_data.strLabelName4)
				.clickOnSaveButton();

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

		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle3 = driver1.getWindowHandle();

		objBlankForm
				.switchToNewWin()
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer)
				.enterAnswerInTextField(objBlankFormData.strTextAnswer)
				.verifyChkBoxIsNotDisplayed(
						objFormConfiguration_data.strLabelName4,
						objFormConfiguration_data.strChoice).clickOnSave();

		objBlankForm.clickOnComplete();

		Thread.sleep(3000);

		objDispatchForm
				.selUserToReceiveCompletedForm(objUserdata.strNewUserName);

		objDispatchForm.clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle3);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description :  Verify that a question can be added by filling only mandatory fields of ‘Table’ question
	'Date	 	 : 05-May-2015
	'Author		 : Sangappa.k
	**************************************************************************************/
	@Test(description = " Verify that a question can be added by filling only mandatory fields of ‘Table’ question ")
	public void testEdgeCase154784() throws Exception {

		gstrTCID = "154784";
		gstrTO =  " Verify that a question can be added by filling only mandatory fields of ‘Table’ question";

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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);
		Thread.sleep(10000);
		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);
			}
		}

		objFormConfiguration1
				.verTemplateDesignPage()
				.clickOnInsert()
				.clickOnTableLink()
				.verifyEditFieldSetWindow()
				.enterFirstRowLabel(objFormConfiguration_data.strRow1)
				.enterThirdRowLabel(objFormConfiguration_data.strRow3,
						objFormConfiguration_data.strRow2)
				.addFirstTableColumn(objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strNumeric)

				.addNthTableColumn(objFormConfiguration_data.strColumnName5,
						objFormConfiguration_data.strSingleSelect)
				.addNthTableColumn(objFormConfiguration_data.strColumnName4,
						objFormConfiguration_data.strTextArea)
				.addNthTableColumn(objFormConfiguration_data.strColumnName3,
						objFormConfiguration_data.strText)
				.addNthTableColumn(objFormConfiguration_data.strColumnName2,
						objFormConfiguration_data.strCheckBox)
				.clickOnEditFieldDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(8000);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(8000);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		String[] columns = { objFormConfiguration_data.strColumnName1,
				objFormConfiguration_data.strColumnName2,
				objFormConfiguration_data.strColumnName3,
				objFormConfiguration_data.strColumnName4,
				objFormConfiguration_data.strColumnName5 };
		String[] answer1 = { "1", "text1", "multitext1" };
		String[] answer2 = { "2", "text2", "multitext2" };
		String[] answer3 = { "3", "text3", "multitext3" };

		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verRowAndQuestionTypeOfTable(
						objFormConfiguration_data.strRow1, columns)
				.verRowAndQuestionTypeOfTable(
						objFormConfiguration_data.strRow2, columns)
				.verRowAndQuestionTypeOfTable(
						objFormConfiguration_data.strRow3, columns)
				.enterAnswerInRows(objFormConfiguration_data.strRow1, columns,
						answer1)
				.enterAnswerInRows(objFormConfiguration_data.strRow2, columns,
						answer2)
				.enterAnswerInRows(objFormConfiguration_data.strRow3, columns,
						answer3)
				.clickOnSave();
		Thread.sleep(5000);
		objBlankForm.clickOnComplete();
		Thread.sleep(5000);
		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName3).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
	'Description : Add an optional 'row' to a table question and verify that:
                1. The row is not marked as mandatory in the 'Review your changes' screen.
                2. When the form is tested (in the 'Review your changes' screen) without answering this row, nothing is 

indicated.
                3. The row is not marked as mandatory when filling out the form.
                4. The form can be submitted without answering that row.
                5. The row is not marked as mandatory in the completed form (check)
	'Date	 	 : 6-May-2015
	'Author		 : Sangappa.k
	**************************************************************************************/
	@Test(description = " Add an optional 'row' to a table question and verify that:"
			           +" 1. The row is not marked as mandatory in the 'Review your changes' screen."
                       +"  2. When the form is tested (in the 'Review your changes' screen) without answering this row,nothing is indicated."
                       +" 3. The row is not marked as mandatory when filling out the form."
                       +"  4. The form can be submitted without answering that row."
                       +"  5. The row is not marked as mandatory in the completed form (check) ")
	public void testEdgeCase154789() throws Exception {

		gstrTCID = "154789";
		gstrTO =  " Add an optional 'row' to a table question and verify that:"
			           +" 1. The row is not marked as mandatory in the 'Review your changes' screen."
                       +"  2. When the form is tested (in the 'Review your changes' screen) without answering this row, nothing is indicated."
                       +" 3. The row is not marked as mandatory when filling out the form."
                       +"  4. The form can be submitted without answering that row."
                       +"  5. The row is not marked as mandatory in the completed form (check) ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(driver);
		UsersList objUsersList = new UsersList(driver);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				driver);
		FormConfiguration objFormConfiguration = new FormConfiguration(driver);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(driver1);

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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}}
		Thread.sleep(10000);
		objFormConfiguration1
				.verTemplateDesignPage()
				.verTemplateDesignPage()
				.clickOnInsert()
				.clickOnTableLink()
				.verifyEditFieldSetWindow()
				.enterFirstRowLabel(objFormConfiguration_data.strRow1)
				.enterSecondRowLabel(objFormConfiguration_data.strRow2)
				.addFirstTableColumn(objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strNumeric)

				.addNthTableColumn(objFormConfiguration_data.strColumnName5,
						objFormConfiguration_data.strSingleSelect)

				.addNthTableColumn(objFormConfiguration_data.strColumnName2,
						objFormConfiguration_data.strCheckBox)
				.clickOnEditFieldDoneButton().clickOnSaveButton();
		Thread.sleep(5000);

		String[] columns = { objFormConfiguration_data.strColumnName1,
				objFormConfiguration_data.strColumnName5,
				objFormConfiguration_data.strColumnName2 };
		String[] rows = { objFormConfiguration_data.strRow1,
				objFormConfiguration_data.strRow2 };

		for (int i = 0; i < columns.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsNotDisplayedForTableColumn(columns[i]);
		}

		for (int i = 0; i < rows.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsNotDisplayedForTableRow(rows[i]);
		}

		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(5000);

		String TempPage = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(TempPage)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		for (int i = 0; i < columns.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsNotDisplayedForTableColumn(columns[i]);
		}

		for (int i = 0; i < rows.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsNotDisplayedForTableRow(rows[i]);
		}

		driver1.close();

		driver1.switchTo().window(TempPage);

		driver1.close();
		Thread.sleep(5000);
		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(8000);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(8000);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.clickOnSave();

		for (int i = 0; i < columns.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsNotDisplayedForTableColumn(columns[i]);
		}

		for (int i = 0; i < rows.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsNotDisplayedForTableRow(rows[i]);
		}

		Thread.sleep(5000);
		objBlankForm.clickOnComplete();
		Thread.sleep(5000);
		objDispatchForm
				.selUserToReceiveCompletedForm(objUserdata.strNewUserName3);
		Thread.sleep(10000);
		objDispatchForm.clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName3,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(8000);

		objRegionDefault1.verWebNotificationframe().clickReviewForm();

		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> b = driver1.getWindowHandles();
		Iterator<String> ite3 = b.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		for (int i = 0; i < columns.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsNotDisplayedForTableColumn(columns[i]);
		}

		for (int i = 0; i < rows.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsNotDisplayedForTableRow(rows[i]);
		}

		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle2);
		
		objRegionDefault1.selectFrame()
						 .verWebNotificationframe()
						 .clickAcknowledgeAllForms();
		
		Thread.sleep(5000);
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description : Verify that duplicate row names are not accepted in the same table question. 
    'Precondition:
    'Date        : 11-May-2015
    'Author      : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that duplicate row names are not accepted in the same table question.")
	public void testEdgeCase154775() throws Exception {

		gstrTCID = "154775";
		gstrTO = "Verify that duplicate row names are not accepted in the same table question.";

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
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(80000);

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
				.clickOnTableLink()
				.verifyEditFieldSetWindow()
				.enterFirstRowLabel(objFormConfiguration_data.strRow1)
				.enterThirdRowLabel(objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strRow1)
				.addFirstTableColumn(objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strText)
				.addNthTableColumn(objFormConfiguration_data.strColumnName2,
						objFormConfiguration_data.strTextArea)
				.clickOnEditFieldDoneButton().clickOnSaveButton();

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
		Thread.sleep(5000);

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

		String str1[] = { "text1", "text2", "text3" };
		String str2[] = { "text4", "text5", "text6" };

		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verRowDetails(objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strText)
				.verRowDetails(objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strText)
				.verRowDetails(objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strText)
				.enterAnswerInFirstColumnOfDuplicateRows(
						objFormConfiguration_data.strRow1, str1)

				.enterAnswerInSecondColumnOfDuplicateRows(
						objFormConfiguration_data.strRow1, str2).clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strRow1 + ":"
				+ objFormConfiguration_data.strColumnName1 + ": " + str1[0]
				+ "| " + objFormConfiguration_data.strRow1 + ":"
				+ objFormConfiguration_data.strColumnName2 + ": " + str2[0]
				+ "| " + objFormConfiguration_data.strRow1 + ":"
				+ objFormConfiguration_data.strColumnName1 + ": " + str1[1]
				+ "| " + objFormConfiguration_data.strRow1 + ":"
				+ objFormConfiguration_data.strColumnName2 + ": " + str2[1]
				+ "| " + objFormConfiguration_data.strRow1 + ":"
				+ objFormConfiguration_data.strColumnName1 + ": " + str1[2]
				+ "| " + objFormConfiguration_data.strRow1 + ":"
				+ objFormConfiguration_data.strColumnName2 + ": " + str2[2];

		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)

				.clickAcknowledgeAllForms();
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
    'Description : Verify that duplicate column names are not accepted in the same table question.  
    'Precondition:
    'Date        : 12-May-2015
    'Author      : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	 **************************************************************************************/
	@Test(description = "Verify that duplicate column names are not accepted in the same table question.")
	public void testEdgeCase154776() throws Exception {

		gstrTCID = "154776";
		gstrTO = "Verify that duplicate column names are not accepted in the same table question.";

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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(80000);

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
		Thread.sleep(5000);

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

		String str3[] = { objFormConfiguration_data.strColumnName1,
				objFormConfiguration_data.strColumnName1 };

		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verColumnDetails(str3)
				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer)
				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer1)
				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow3,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer2)
				.enterAnswerInSecondColumn(objFormConfiguration_data.strRow1,
						objBlankFormData.strTextAnswer)
				.enterAnswerInSecondColumn(objFormConfiguration_data.strRow2,
						objBlankFormData.strTextAnswer1)
				.enterAnswerInSecondColumn(objFormConfiguration_data.strRow3,
						objBlankFormData.strTextAnswer2);

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strRow1 + ":"
				+ objFormConfiguration_data.strColumnName1 + ": "
				+ objBlankFormData.strTextAnswer + "| "
				+ objFormConfiguration_data.strRow1 + ":"
				+ objFormConfiguration_data.strColumnName1 + ": "
				+ objBlankFormData.strTextAnswer + "| "
				+ objFormConfiguration_data.strRow3 + ":"
				+ objFormConfiguration_data.strColumnName1 + ": "
				+ objBlankFormData.strTextAnswer2 + "| "
				+ objFormConfiguration_data.strRow3 + ":"
				+ objFormConfiguration_data.strColumnName1 + ": "
				+ objBlankFormData.strTextAnswer2 + "| "
				+ objFormConfiguration_data.strRow2 + ":"
				+ objFormConfiguration_data.strColumnName1 + ": "
				+ objBlankFormData.strTextAnswer1 + "| "
				+ objFormConfiguration_data.strRow2 + ":"
				+ objFormConfiguration_data.strColumnName1 + ": "
				+ objBlankFormData.strTextAnswer1;

		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)

				.clickAcknowledgeAllForms();
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	 /*************************************************************************************
    'Description : Verify that the form can be previewed by filling only mandatory fields of a ‘Table’ question. 
    'Precondition:
    'Date        : 13-May-2015
    'Author      : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the form can be previewed by filling only mandatory fields of a ‘Table’ question.")
	public void testEdgeCase154786() throws Exception {

		gstrTCID = "154786";
		gstrTO = "Verify that the form can be previewed by filling only mandatory fields of a ‘Table’ question.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		BlankFormData objBlankFormData = new BlankFormData();
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(80000);

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
				.clickOnTableLink()
				.verifyEditFieldSetWindow()
				.enterFirstRowLabel(objFormConfiguration_data.strRow1)
				.enterSecondRowLabel(objFormConfiguration_data.strRow2)
				.addFirstTableColumn(objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strText)
				.clickOnPencilIconInEditFieldSetOfTable(
						objFormConfiguration_data.firstColEdit)
				.selectRequiredCheckBox()
				.clickOnDoneButton()
				.addNthTableColumn(objFormConfiguration_data.strColumnName3,
						objFormConfiguration_data.strTextArea)
				.clickOnPencilIconInEditFieldSetOfTable(
						objFormConfiguration_data.secColEdit)
				.selectRequiredCheckBox()
				.clickOnDoneButton()
				.addNthTableColumn(objFormConfiguration_data.strColumnName2,
						objFormConfiguration_data.strNumeric)

				.clickOnEditFieldDoneButton().clickOnSaveButton();

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
		Thread.sleep(5000);

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

				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer)
				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer1)
				.enterAnswerInNthColumn(objFormConfiguration_data.strRow1,
						objBlankFormData.strTextAreaAnswer,
						objBlankFormData.num2)
				.enterAnswerInNthColumn(objFormConfiguration_data.strRow2,
						objBlankFormData.strTextAreaAnswer1,
						objBlankFormData.num2)

				.clickOnSave();
		Thread.sleep(5000);
		objBlankForm
				.verErrorMsgIsNotDisplayedForNonMandatoryFieldOfTableQuestion(
						objFormConfiguration_data.strRow1)
				.verErrorMsgIsNotDisplayedForNonMandatoryFieldOfTableQuestion(
						objFormConfiguration_data.strRow2);

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strRow1 + ":"
//				+ objFormConfiguration_data.strColumnName1 + ": "
//				+ objBlankFormData.strTextAnswer + "| "
//				+ objFormConfiguration_data.strRow1 + ":"
//				+ objFormConfiguration_data.strColumnName3 + ": "
//				+ objBlankFormData.strTextAreaAnswer + "| "
//				+ objFormConfiguration_data.strRow2 + ":"
//				+ objFormConfiguration_data.strColumnName1 + ": "
//				+ objBlankFormData.strTextAnswer1 + "| "
//				+ objFormConfiguration_data.strRow2 + ":"
//				+ objFormConfiguration_data.strColumnName3 + ": "
//				+ objBlankFormData.strTextAreaAnswer1;

		String strMsg = objRegionDefault1.getWebNotificationForTable(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strRow1,
				objFormConfiguration_data.strColumnName1,
				objBlankFormData.strTextAnswer,
				objFormConfiguration_data.strColumnName3,
				objBlankFormData.strTextAreaAnswer,
				objFormConfiguration_data.strRow2,
				objBlankFormData.strTextAnswer1,
				objBlankFormData.strTextAreaAnswer1);
		
		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)

				.clickAcknowledgeAllForms().selectFrame();
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Add a mandatory 'column' to a table question and verify that:
                  1. The column is marked as mandatory in the 'Review your changes' screen.
                  2. When the form is tested (in the 'Review your changes' screen) without answering this column, it is indicated that the column is mandatory.
                  3. The column is marked as mandatory when filling out the form.
                  4. The form cannot be submitted without answering that column.
                  5. The column is marked as mandatory in the completed form 
	'Date	 	 : 13-May-2015
	'Author		 : Sangappa.k
	**************************************************************************************/
	@Test(description = "Add a mandatory 'column' to a table question and verify that:"
                   +" 1. The column is marked as mandatory in the 'Review your changes' screen."
                   +"2. When the form is tested (in the 'Review your changes' screen) without answering this column, it is indicated that the column is mandatory."
                   +"3. The column is marked as mandatory when filling out the form."
                   +" 4. The form cannot be submitted without answering that column."
                   +" 5. The column is marked as mandatory in the completed form ")
	public void testEdgeCase154790() throws Exception {

		gstrTCID = "154790";
		gstrTO = "Add a mandatory 'column' to a table question and verify that:"
                   +" 1. The column is marked as mandatory in the 'Review your changes' screen."
                   +"2. When the form is tested (in the 'Review your changes' screen) without answering this column, it is indicated that the column is mandatory."
                   +"3. The column is marked as mandatory when filling out the form."
                   +" 4. The form cannot be submitted without answering that column."
                   +" 5. The column is marked as mandatory in the completed form ";
 
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(driver);
		UsersList objUsersList = new UsersList(driver);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				driver);
		FormConfiguration objFormConfiguration = new FormConfiguration(driver);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(driver1);

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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
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
		objFormConfiguration1
				.verTemplateDesignPage()
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
				.clickOnEditFieldDoneButton()
				.clickOnEditTable()
				.clickOnPencilIconInEditFieldSetOfTable(
						objFormConfiguration_data.firstColEdit)
				.selectRequiredCheckBox1()
				.clickOnDoneButton()
				.clickOnPencilIconInEditFieldSetOfTable(
						objFormConfiguration_data.secColEdit)
				.selectRequiredCheckBox1().clickOnDoneButton()
				.clickOnEditFieldDoneButton().clickOnSaveButton();

		String[] columns = { objFormConfiguration_data.strColumnName1,
				objFormConfiguration_data.strColumnName2 };

		String[] rows = { objFormConfiguration_data.strRow1,
				objFormConfiguration_data.strRow2 };

		for (int i = 0; i < columns.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsDisplayedForTableColumn(columns[i]);
		}

		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(5000);

		String TempPage = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(TempPage)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		for (int i = 0; i < columns.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsDisplayedForTableColumn(columns[i]);
		}
		driver1.close();
		Thread.sleep(5000);
		driver1.switchTo().window(TempPage);
		driver1.close();
		Thread.sleep(5000);
		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(8000);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(8000);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verColumnDetails(columns).clickOnSave();

		for (int i = 0; i < columns.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsDisplayedForTableColumn(columns[i]);
		}

		objBlankForm
				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer)
				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer1)
				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow3,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer2)
				.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow1,
						objBlankFormData.strTextAnswer)
				.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow2,
						objBlankFormData.strTextAnswer1)
				.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow3,
						objBlankFormData.strTextAnswer2).clickOnSave();

		Thread.sleep(5000);
		objBlankForm.clickOnComplete();
		Thread.sleep(5000);
		objDispatchForm
				.selUserToReceiveCompletedForm(objUserdata.strNewUserName3);
		Thread.sleep(10000);
		objDispatchForm.clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName3,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(8000);

		objRegionDefault1.verWebNotificationframe().clickReviewForm();

		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> b = driver1.getWindowHandles();
		Iterator<String> ite3 = b.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		for (int i = 0; i < columns.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsDisplayedForTableColumn(columns[i]);
		}

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);
		objRegionDefault1.selectFrame().verWebNotificationframe()
				.clickAcknowledgeAllForms();
		Thread.sleep(5000);
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

      /*************************************************************************************
       'Description : Verify that duplicate row names are accepted in different table questions of the same form. 
       'Precondition:
       'Date        : 14-May-2015
       'Author      : Hanumegowda
       '---------------------------------------------------------------
       'Modified Date                                               Modified By
       'Date                                                         Name
      **************************************************************************************/
	@Test(description = "Verify that duplicate row names are accepted in different table questions of the same form.")
	public void testEdgeCase154778() throws Exception {

		gstrTCID = "154778";
		gstrTO = "Verify that duplicate row names are accepted in different table questions of the same form.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		BlankFormData objBlankFormData = new BlankFormData();
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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)

				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

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
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver.getWindowHandle();
		Thread.sleep(80000);

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
				.clickOnTableLink()
				.verifyEditFieldSetWindow()
				.enterFirstRowLabel(objFormConfiguration_data.strRow1)
				.enterSecondRowLabel(objFormConfiguration_data.strRow2)
				.addFirstTableColumn(objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strText)

				.addNthTableColumn(objFormConfiguration_data.strColumnName2,
						objFormConfiguration_data.strTextArea)

				.clickOnEditFieldDoneButton();

		objFormConfiguration
				.clickOnInsert()
				.clickOnTableLink()
				.verifyEditFieldSetWindow()
				.enterFirstRowLabel(objFormConfiguration_data.strRow1)
				.enterSecondRowLabel(objFormConfiguration_data.strRow2)
				.addFirstTableColumn(objFormConfiguration_data.strColumnName3,
						objFormConfiguration_data.strText)

				.addNthTableColumn(objFormConfiguration_data.strColumnName4,
						objFormConfiguration_data.strTextArea)

				.clickOnEditFieldDoneButton()

				.clickOnSaveButton();
		String[] str = { objFormConfiguration_data.strRow1,
				objFormConfiguration_data.strRow2 };
		objFormConfiguration.verRowsOfDifferentTablesAreDuplicate(str);

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
		Thread.sleep(5000);

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
				.verRowDetails(objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strText)
				.verRowDetails(objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strText)

				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer)
				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer1)
				.enterAnswerInNthColumn(objFormConfiguration_data.strRow1,
						objBlankFormData.strTextAreaAnswer,
						objBlankFormData.num2)
				.enterAnswerInNthColumn(objFormConfiguration_data.strRow2,
						objBlankFormData.strTextAreaAnswer1,
						objBlankFormData.num2)

				.verRowDetailsInSecondTableOfSameForm(
						objFormConfiguration_data.strRow1)
				.verRowDetailsInSecondTableOfSameForm(
						objFormConfiguration_data.strRow2)
				.enterAnswerInNthColumnInSecondTableOfSameForm(
						objFormConfiguration_data.strRow1,
						objBlankFormData.strTextAnswer, objBlankFormData.num1,
						objFormConfiguration_data.strText)
				.enterAnswerInNthColumnInSecondTableOfSameForm(
						objFormConfiguration_data.strRow1,
						objBlankFormData.strTextAreaAnswer,
						objBlankFormData.num2,
						objFormConfiguration_data.strTextArea)
				.enterAnswerInNthColumnInSecondTableOfSameForm(
						objFormConfiguration_data.strRow2,
						objBlankFormData.strTextAnswer1, objBlankFormData.num1,
						objFormConfiguration_data.strText)
				.enterAnswerInNthColumnInSecondTableOfSameForm(
						objFormConfiguration_data.strRow2,
						objBlankFormData.strTextAreaAnswer1,
						objBlankFormData.num2,
						objFormConfiguration_data.strTextArea)

				.clickOnSave();
		Thread.sleep(5000);

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(
				objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strRow1 + ":"
				+ objFormConfiguration_data.strColumnName1 + ": "
				+ objBlankFormData.strTextAnswer + "| "
				+ objFormConfiguration_data.strRow1 + ":"
				+ objFormConfiguration_data.strColumnName2 + ": "
				+ objBlankFormData.strTextAreaAnswer + "| "
				+ objFormConfiguration_data.strRow2 + ":"
				+ objFormConfiguration_data.strColumnName1 + ": "
				+ objBlankFormData.strTextAnswer1 + "| "
				+ objFormConfiguration_data.strRow2 + ":"
				+ objFormConfiguration_data.strColumnName2 + ": "
				+ objBlankFormData.strTextAreaAnswer1 + "| "

				+ objFormConfiguration_data.strRow1 + ":"
				+ objFormConfiguration_data.strColumnName3 + ": "
				+ objBlankFormData.strTextAnswer + "| "
				+ objFormConfiguration_data.strRow1 + ":"
				+ objFormConfiguration_data.strColumnName4 + ": "
				+ objBlankFormData.strTextAreaAnswer + "| "
				+ objFormConfiguration_data.strRow2 + ":"
				+ objFormConfiguration_data.strColumnName3 + ": "
				+ objBlankFormData.strTextAnswer1 + "| "
				+ objFormConfiguration_data.strRow2 + ":"
				+ objFormConfiguration_data.strColumnName4 + ": "
				+ objBlankFormData.strTextAreaAnswer1;

		Thread.sleep(5000);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)

				.clickAcknowledgeAllForms().selectFrame();
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that duplicate column names are accepted in different table questions of the same form.
	'Date	 	 : 14-May-2015
	'Author		 : Sangappa.k
	**************************************************************************************/
	@Test(description ="Verify that duplicate column names are accepted in different table questions of the same form.")
	public void testEdgeCase154780() throws Exception {

		gstrTCID = "154780";
		gstrTO = "Verify that duplicate column names are accepted in different table questions of the same form.";
 
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(driver);
		UsersList objUsersList = new UsersList(driver);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				driver);
		FormConfiguration objFormConfiguration = new FormConfiguration(driver);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(driver1);

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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
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

		objFormConfiguration1
				.verTemplateDesignPage()
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
				.clickOnEditFieldDoneButton()
				// table2
				.clickOnInsert()
				.clickOnTableLink()
				.verifyEditFieldSetWindow()
				.enterFirstRowLabel(objFormConfiguration_data.strRow2)
				.enterThirdRowLabel(objFormConfiguration_data.strRow3,
						objFormConfiguration_data.strRow4)
				.addFirstTableColumn(objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strText)
				.addNthTableColumn(objFormConfiguration_data.strColumnName2,
						objFormConfiguration_data.strTextArea)
				.clickOnEditFieldDoneButton()

				// table3
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnTableLinkUnderGroup(
						objFormConfiguration_data.strGroupName)

				.enterFirstRowLabel(objFormConfiguration_data.strRow4)
				.enterThirdRowLabel(objFormConfiguration_data.strRow5,
						objFormConfiguration_data.strRow6)
				.addFirstTableColumn(objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strText)
				.addNthTableColumn(objFormConfiguration_data.strColumnName2,
						objFormConfiguration_data.strTextArea)
				.clickOnEditFieldDoneButton().clickOnSaveButton();
		Thread.sleep(5000);

		String[] strDuplicateComumns = {
				objFormConfiguration_data.strColumnName1,
				objFormConfiguration_data.strColumnName2 };

		for (int i = 0; i < strDuplicateComumns.length; i++) {

			objFormConfiguration1.verDuplicateColumnNamesOfTable1And2(
					strDuplicateComumns[i])

			.verDuplicateColumnNamesOfTableUnderGroup(
					objFormConfiguration_data.strGroupName,
					strDuplicateComumns[i]);
		}

		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(9000);
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(5000);

		String TempPage = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(TempPage)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		for (int i = 0; i < strDuplicateComumns.length; i++) {

			objFormConfiguration1.verDuplicateColumnNamesOfTable1And2(
					strDuplicateComumns[i])

			.verDuplicateColumnNamesOfTableUnderGroup(
					objFormConfiguration_data.strGroupName,
					strDuplicateComumns[i]);
		}
		driver1.close();
		Thread.sleep(7000);
		driver1.switchTo().window(TempPage);
		driver1.close();
		Thread.sleep(5000);
		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(8000);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(8000);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName);

		for (int i = 0; i < strDuplicateComumns.length; i++) {

			objFormConfiguration1.verDuplicateColumnNamesOfTable1And2(
					strDuplicateComumns[i])

			.verDuplicateColumnNamesOfTableUnderGroup(
					objFormConfiguration_data.strGroupName,
					strDuplicateComumns[i]);
		}

		objBlankForm
				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow1,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer)
				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow2,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer1)
				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow3,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer2)
				.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow1,
						objBlankFormData.strTextAnswer)
				.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow2,
						objBlankFormData.strTextAnswer1)
				.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow3,
						objBlankFormData.strTextAnswer2)

				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow4,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer)
				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow5,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer1)
				.enterAnswerInFirstColumn(objFormConfiguration_data.strRow6,
						objFormConfiguration_data.strText,
						objBlankFormData.strTextAnswer2)
				.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow4,
						objBlankFormData.strTextAnswer)
				.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow5,
						objBlankFormData.strTextAnswer1)
				.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow6,
						objBlankFormData.strTextAnswer2)
				.clickOnSave();

		Thread.sleep(5000);
		objBlankForm.clickOnComplete();
		Thread.sleep(5000);
		objDispatchForm
				.selUserToReceiveCompletedForm(objUserdata.strNewUserName3);
		Thread.sleep(10000);
		objDispatchForm.clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Add an optional 'column' to a table question and verify that:
                  1. The column is not marked as mandatory in the 'Review your changes' screen.
                  2. When the form is tested (in the 'Review your changes' screen) without answering this column, nothing is indicated.
                  3. The column is not marked as mandatory when filling out the form.
                  4. The form can be submitted without answering that column.
                  5. The column is not marked as mandatory in the completed form (check) 
	'Date	 	 : 14-May-2015
	'Author		 : Sangappa.k
	**************************************************************************************/
	@Test(description = "Add an optional 'column' to a table question and verify that:"
           + "1. The column is not marked as mandatory in the 'Review your changes' screen."
           +"2. When the form is tested (in the 'Review your changes' screen) without answering this column, nothing is indicated."
           +"3. The column is not marked as mandatory when filling out the form."
          + "4. The form can be submitted without answering that column."
          + "5. The column is not marked as mandatory in the completed form (check) ")
	public void testEdgeCase154791() throws Exception {

		gstrTCID = "154791";
		gstrTO = "Add an optional 'column' to a table question and verify that:"
           + "1. The column is not marked as mandatory in the 'Review your changes' screen."
           +"2. When the form is tested (in the 'Review your changes' screen) without answering this column, nothing is indicated."
           +"3. The column is not marked as mandatory when filling out the form."
          + "4. The form can be submitted without answering that column."
          + "5. The column is not marked as mandatory in the completed form (check) ";
 
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(driver);
		UsersList objUsersList = new UsersList(driver);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				driver);
		FormConfiguration objFormConfiguration = new FormConfiguration(driver);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(driver1);

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
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton();

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
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
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

		objFormConfiguration1
				.verTemplateDesignPage()
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

		String[] columns = { objFormConfiguration_data.strColumnName1,
				objFormConfiguration_data.strColumnName2 };
		
		for (int i = 0; i < columns.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsNotDisplayedForTableColumn(columns[i]);
		}

		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);
		objFormConfiguration1.clickOnPreviewButton();
		Thread.sleep(5000);

		String TempPage = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(TempPage)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		for (int i = 0; i < columns.length; i++) {
			objFormConfiguration1
					.verMandotryMarkIsNotDisplayedForTableColumn(columns[i]);
		}
		driver1.close();
		Thread.sleep(5000);
		driver1.switchTo().window(TempPage);
		driver1.close();
		Thread.sleep(5000);
		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.navigateToActivateForm();
		Thread.sleep(5000);
		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.selUserToFillOutForm(objUserdata.strNewUserName1)
				.clickOnActivateForm();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(8000);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Thread.sleep(8000);

		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
				.verColumnDetails(columns).clickOnSave();

		for (int i = 0; i < columns.length; i++) {
			objFormConfiguration1
			.verMandotryMarkIsNotDisplayedForTableColumn(columns[i]);
		}
		objBlankForm.clickOnComplete();
		Thread.sleep(5000);
		objDispatchForm
				.selUserToReceiveCompletedForm(objUserdata.strNewUserName3);
		Thread.sleep(10000);
		objDispatchForm.clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName3,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(8000);

		objRegionDefault1.verWebNotificationframe().clickReviewForm();

		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> b = driver1.getWindowHandles();
		Iterator<String> ite3 = b.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		for (int i = 0; i < columns.length; i++) {
			objFormConfiguration1
			.verMandotryMarkIsNotDisplayedForTableColumn(columns[i]);
		}

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);
		objRegionDefault1.selectFrame().verWebNotificationframe()
				.clickAcknowledgeAllForms();
		Thread.sleep(5000);
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}	
	
	/*************************************************************************************
	 * 'Description : Verify that user can provide default value while adding
	 * 'Numeric & Date/Time' questionnaire 'Precondition: 'Date : 13-Feb-2015
	 * 'Author : Deepa
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that user can provide default value while adding 'Numeric & Date/Time' questionnaire ")
	public void testEdgeCase152191() throws Exception {

		gstrTCID = "152191";
		gstrTO = "Verify that user can provide default value while adding 'Numeric & Date/Time' questionnaire ";

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
				.enterDefaultValue(objFormConfiguration_data.strDefaultNum)
				.clickOnAddToSummary()
				.clickOnDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strDateQuestion)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.enterDefaultValue(objFormConfiguration_data.strDefaultDate)
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
				driver1.navigate().refresh();

			}
		}
		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.verNumericDefaultValue(objFormConfiguration_data.strLabelName,
						objFormConfiguration_data.strDefaultNum)
				.verDateDefaultValue(objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strDefaultDate).clickOnSave();
		
		objBlankForm.clickOnComplete();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description : Verify that user can select default values while adding 'Check box,Radio button, Single select, Multi select' questionnaire
	 * 'Precondition:
	 * 'Date : 26-Feb-2015 
	 * 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/

	@Test(description = "Verify that user can select default values while adding 'Check box,Radio button, Single select, Multi select' questionnaire")
	public void testEdgeCase152192() throws Exception {

		gstrTCID = "152192";
		gstrTO = "Verify that user can select default values while adding 'Check box,Radio button, Single select, Multi select' questionnaire";

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
		FormConfiguration

		objFormConfiguration = new FormConfiguration(this.driver1);

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

		.enterUserDetails(objUserdata.strNewUserName,

		objUserdata.strNewPassword, objUserdata.strFullName).selectFirstRole()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()

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

				.selectActivateFormChkBox

				(objUserdata.strNewUserName1)

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

				.clickOnAddToSummary()

				.addChoices(objFormConfiguration_data.strChoice)

				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice1)

				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)

				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strRadio)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.clickOnAddToSummary()

				.addChoices(objFormConfiguration_data.strChoice2)
				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice3)
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)

				.verifyEditQuestionWindow()

				.selectQuestionType(objFormConfiguration_data.strMultiSelect)

				.enterLabelName(objFormConfiguration_data.strLabelName3)

				.clickOnAddToSummary()

				.addChoices(objFormConfiguration_data.strChoice4)

				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice5)

				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)

				.verifyEditQuestionWindow()

				.selectQuestionType(objFormConfiguration_data.strSingleSelect)

				.enterLabelName(objFormConfiguration_data.strLabelName4)

				.clickOnAddToSummary()

				.addChoices(objFormConfiguration_data.strChoice6)

				.addNthChoice(objFormConfiguration_data.strSecChoice,
						objFormConfiguration_data.strChoice7)

				.clickOnDoneButton()

				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");

		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		objFormConfiguration
				.editQuestion(objFormConfiguration_data.strLabelName1)

				.verifyEditQuestionWindow()

				.selectDefaultForSingleSelect(
						objFormConfiguration_data.strChoice1)

				.clickOnDoneButton()

				.editQuestion(objFormConfiguration_data.strLabelName2)

				.verifyEditQuestionWindow()

				.selectDefaultForSingleSelect(
						objFormConfiguration_data.strChoice3)

				.clickOnDoneButton()

				.editQuestion(objFormConfiguration_data.strLabelName3)

				.verifyEditQuestionWindow()

				.selectDefaultForSingleSelect(
						objFormConfiguration_data.strChoice4)
				.clickOnDoneButton()

				.editQuestion(objFormConfiguration_data.strLabelName4)

				.verifyEditQuestionWindow()

				.selectDefaultForSingleSelect(
						objFormConfiguration_data.strChoice6)

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

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)

				.selUserToFillOutForm(objUserdata.strNewUserName)

				.clickOnActivateForm();

		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		String mainWindowHandle1 =

		driver1.getWindowHandle();
		Set<String> a1 =

		driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator

		();

		while (ite1.hasNext()) {
			String popupHandle =

			ite1.next().toString();

			if (!popupHandle.contains

			(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		objBlankForm
				.verFormTitle(objFormConfiguration_data.strFormName)

				.verGroupName(objFormConfiguration_data.strGroupName)

				.verFieldSetName(objFormConfiguration_data.strAttributeName)

				.verifyDefaultValue(objFormConfiguration_data.strLabelName1,
						objFormConfiguration_data.strChoice1)

				.verifyDefaultValue(objFormConfiguration_data.strLabelName2,
						objFormConfiguration_data.strChoice3)

				.verifyDefaultSelectedValue(
						objFormConfiguration_data.strLabelName3,
						objFormConfiguration_data.strChoice4)

				.verifyDefaultSelectedValue(
						objFormConfiguration_data.strLabelName4,
						objFormConfiguration_data.strChoice6)

				.clickOnSave();

		objBlankForm.clickOnComplete();

		objDispatchForm.selUserToReceiveCompletedForm(

		objUserdata.strNewUserName1).clickOnDispatchForm();

		driver1.switchTo().window

		(mainWindowHandle1);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut()

		.loginToApplication(objUserdata.strNewUserName1,

		objUserdata.strNewPassword);

//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
//				+ ": " +
//				objBlankFormData.strNumericAnswer + "";

		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);
		
		objRegionDefault1.selectFrame()

		.verWebNotificationframe()

		.verWebNotificationMsgForForms

		(objFormConfiguration_data.strFormName,

		strMsg).clickAcknowledgeAllForms().selectFrame();

		gstrResult = "PASS";
	}
}