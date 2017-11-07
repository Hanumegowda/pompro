package requirementGroup.Forms;

import static org.testng.Assert.assertEquals;
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
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseEditFrom extends TestNG_UI_EXTENSIONS {
	public EdgeCaseEditFrom() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description : Verify that table questionnaire added to a template can be edited  
    'Precondition:
    'Date        : 30-Mar-2015
    'Author      : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	    **************************************************************************************/
	@Test(description = "Verify that table questionnaire added to a template can be edited.")
	public void testEdgeCase152330() throws Exception {

		gstrTCID = "152330";
		gstrTO = "Verify that table questionnaire added to a template can be edited.";

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
				.addFirstTableColumn(objFormConfiguration_data.strColumnName1,
						objFormConfiguration_data.strText)
				.addNthTableColumn(objFormConfiguration_data.strColumnName3,
						objFormConfiguration_data.strNumeric)
				.clickOnEditFieldDoneButton()
				.clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);
		objFormConfiguration
				.clickOnEditTable()
				.enterThirdRowLabel(objFormConfiguration_data.strRow3,
						objFormConfiguration_data.strRow2)
				.addNthTableColumn(objFormConfiguration_data.strColumnName2,
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
				.verRowDetailsForThreeColumns(objFormConfiguration_data.strRow1)
				.verRowDetailsForThreeColumns(objFormConfiguration_data.strRow2)
				.verRowDetailsForThreeColumns(objFormConfiguration_data.strRow3)
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
						objBlankFormData.strTextAreaAnswer)
				.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow2,
						objBlankFormData.strTextAreaAnswer1)
				.enterAnswerInSecondColumnForTextArea(objFormConfiguration_data.strRow3,
						objBlankFormData.strTextAreaAnswer2)
				.enterAnswerInThirdColumn(objFormConfiguration_data.strRow1,
						objBlankFormData.num1)
				.enterAnswerInThirdColumn(objFormConfiguration_data.strRow2,
						objBlankFormData.num2)
				.enterAnswerInThirdColumn(objFormConfiguration_data.strRow3,
						objBlankFormData.num3)
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
//
//		String strMsg = "Submitted by " + objUserdata.strFullName
//				+ "\nSummary: | " + objFormConfiguration_data.strRow1 + ":"
//				+ objFormConfiguration_data.strColumnName1 + ": "
//				+ objBlankFormData.strTextAnswer + "| "
//				+ objFormConfiguration_data.strRow1 + ":"
//				+ objFormConfiguration_data.strColumnName2 + ": "
//				+ objBlankFormData.strTextAreaAnswer + "| "
//				+ objFormConfiguration_data.strRow1 + ":"
//				+ objFormConfiguration_data.strColumnName3 + ": "
//				+ objBlankFormData.num1 + "| "
//				+ objFormConfiguration_data.strRow2 + ":"
//				+ objFormConfiguration_data.strColumnName1 + ": "
//				+ objBlankFormData.strTextAnswer1 + "| "
//				+ objFormConfiguration_data.strRow2 + ":"
//				+ objFormConfiguration_data.strColumnName2 + ": "
//				+ objBlankFormData.strTextAreaAnswer1 + "| "
//				+ objFormConfiguration_data.strRow2 + ":"
//				+ objFormConfiguration_data.strColumnName3 + ": "
//				+ objBlankFormData.num2 + "| "
//				+ objFormConfiguration_data.strRow3 + ":"
//				+ objFormConfiguration_data.strColumnName1 + ": "
//				+ objBlankFormData.strTextAnswer2 + "| "
//				+ objFormConfiguration_data.strRow3 + ":"
//				+ objFormConfiguration_data.strColumnName2 + ": "
//				+ objBlankFormData.strTextAreaAnswer2 + "| "
//				+ objFormConfiguration_data.strRow3 + ":"
//				+ objFormConfiguration_data.strColumnName3 + ": "
//				+ objBlankFormData.num3 + "\n" + strmsg1 + "";

		String strMsg = objRegionDefault1.getWebNotificationForTable(
				objUserdata.strFullName, objLogindata.strRegionName,
				objFormConfiguration_data.strRow1,
				objFormConfiguration_data.strRow2,
				objFormConfiguration_data.strRow3,
				objFormConfiguration_data.strColumnName1,
				objFormConfiguration_data.strColumnName2,
				objFormConfiguration_data.strColumnName3,
				objBlankFormData.strTextAnswer,
				objBlankFormData.strTextAreaAnswer, objBlankFormData.num1,
				objBlankFormData.strTextAnswer1,
				objBlankFormData.strTextAreaAnswer1, objBlankFormData.num2,
				objBlankFormData.strTextAnswer2,
				objBlankFormData.strTextAreaAnswer2, objBlankFormData.num3);
				
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
	'Description :Edit a form, deselect the previously selected users and select different users for filling out the form and verify that: 1. The previously selected users are not available while activating the form. 2. The newly selected users are available while activating the form.
	'Precondition:
	'Date	 	 : 05-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Edit a form, deselect the previously selected users and select different users for filling out the form and verify that: 1. The previously selected users are not available while activating the form. 2. The newly selected users are available while activating the form.")
	public void testEdgeCase154706() throws Exception {

		gstrTCID = "154706";
		gstrTO = "Edit a form, deselect the previously selected users and select different users for filling out the form and verify that: 1. The previously selected users are not available while activating the form. 2. The newly selected users are available while activating the form.";

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
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);
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
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.clickSaveButton();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName2)
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
	    
	    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
	    .verifyEditQuestionWindow()    
	    .selectQuestionType(objFormConfiguration_data.strText)
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
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnEditFormLink(objFormConfiguration_data.strFormName)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName2)
				.deSelectUsersCheckBox(objUserdata.strNewUserName1)		
				.clickOnNextButton()
				.clickOnNextButton();

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName);
		
		objActivateForms1.verifyUserToFillOutForm(
							objUserdata.strNewUserName2);
		objActivateForms1.verifyUserToFillOutFormIsNotDisplayed(
							objUserdata.strNewUserName1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}


	/*************************************************************************************
	'Description : 	Edit a form and deselect the previously selected users and select new users for receiving completed form and verify that: 1. The newly selected users receive completed form and the previously selected users do not. 2. The newly selected users are available while activating the form.
	'Precondition:
	'Date	 	 : 06-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Edit a form and deselect the previously selected users and select new users for receiving completed form and verify that: 1. The newly selected users receive completed form and the previously selected users do not. 2. The newly selected users are available while activating the form.")
	public void testEdgeCase154708() throws Exception {

		gstrTCID = "154708";
		gstrTO = "Edit a form and deselect the previously selected users and select new users for receiving completed form and verify that: 1. The newly selected users receive completed form and the previously selected users do not. 2. The newly selected users are available while activating the form.";

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
				.selectFirstRole()
				.clickSaveButton();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName2)
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
						    .selectQuestionType(objFormConfiguration_data.strNumeric)
						    .enterLabelName(objFormConfiguration_data.strLabelName)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strText)
						    .enterLabelName(objFormConfiguration_data.strLabelName1)
						    .clickOnAddToSummary()
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
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnEditFormLink(objFormConfiguration_data.strFormName)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName2)
				.deSelectUsersCheckBox(objUserdata.strNewUserName1)		
				.clickOnNextButton();

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
					.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,objBlankFormData.strTextAnswer)
					.clickOnSave();

		objBlankForm.clickOnComplete();
		
		objDispatchForm.verifyUserIsDisplayedInReceiveCompletedForm(
							objUserdata.strNewUserName2);
		objDispatchForm.verifyUserIsNotDisplayedInReceiveCompletedForm(
							objUserdata.strNewUserName1)
					   .clickOnDispatchForm();

		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
     /*************************************************************************************
      'Description : Verify that all the previously saved data is retained when the form is opened for editing.   
      'Precondition:
      'Date        : 07-May-2015
      'Author      : Hanumegowda
      '---------------------------------------------------------------
      'Modified Date                                               Modified By
      'Date                                                         Name
      **************************************************************************************/
	@Test(description = "Verify that all the previously saved data is retained when the form is opened for editing.")
	public void testEdgeCase154704() throws Exception {

		gstrTCID = "154704";
		gstrTO = "Verify that all the previously saved data is retained when the form is opened for editing.";

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
				.selectRequiredCheckBox().clickOnAddToSummary()
				.clickOnDoneButton();

		objFormConfiguration
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.selectRequiredCheckBox().clickOnAddToSummary()
				.clickOnDoneButton();

		objFormConfiguration
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strTextArea)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.selectRequiredCheckBox().clickOnAddToSummary()
				.clickOnDoneButton().clickOnSaveButton();

		Thread.sleep(5000);
		objFormConfiguration.clickOnPublishButton();

		driver.close();
		driver.switchTo().window(mainWindowHandle);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnEditFormLink(objFormConfiguration_data.strFormName)
				.verifyEditFormTemplatePageIsDisplayed()
				.verifyFormTitleInEditFormTemplatePage(
						objFormConfiguration_data.strFormName)
				.verifyFormDescriptionInEditFormTemplatePage(
						objFormConfiguration_data.strDiscriptiveName)
				.clickOnNextButton()
				.verSelUserToRcvCompltdFormCheckBoxIsSelected(
						objUserdata.strNewUserName1).clickOnNextButtonInIEBrowser();
		objFormConfiguration1
				.clickOnSecurityLinkOfForm(
						objFormConfiguration_data.strFormName)
				.verifyUserInFormSecuritySettingIsSelected(
						objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySettingInIEBrowser();

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver1.getWindowHandle();

		Set<String> b = driver1.getWindowHandles();
		Iterator<String> ite1 = b.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.verTemplateDesignPage()
				.verifyFormNameInTemplateDesignPage(
						objFormConfiguration_data.strFormName)
				.verGroupNameInPreviewPage(
						objFormConfiguration_data.strGroupName)
				.verFieldSetNameInPreviewPage(
						objFormConfiguration_data.strAttributeName)
				.verFieldSetOrAttributeNameInTemplateDesignerPage(
						objFormConfiguration_data.strAttributeName)
				.verifyLabelNameInTemplateDesignPage(
						objFormConfiguration_data.strLabelName)
				.verifyLabelNameInTemplateDesignPage(
						objFormConfiguration_data.strLabelName1)
				.verifyLabelNameInTemplateDesignPage(
						objFormConfiguration_data.strLabelName2);
		driver1.close();
		driver1.switchTo().window(mainWindowHandle1);
		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

	/*************************************************************************************
    'Description : Verify that all the previously saved data is retained when the form is opened for editing.   
    'Precondition:
    'Date        : 08-May-2015
    'Author      : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
    **************************************************************************************/
	@Test(description = "Cancel the process of editing the form and verify that the previously saved data is retained.")
	public void testEdgeCase154717() throws Exception {

		gstrTCID = "154717";
		gstrTO = "Cancel the process of editing the form and verify that the previously saved data is retained.";

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
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)

				.clickOnNextButton().deSelectAllUsersCheckBox()
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnEditFormLink(objFormConfiguration_data.strFormName)
				.verifyEditFormTemplatePageIsDisplayed()

				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName2,
						objFormConfiguration_data.strEditedDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strUserToIndividualResources)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnCancelButton();

		objFormConfiguration1
				.clickOnEditFormLink(objFormConfiguration_data.strFormName)
				.verifyEditFormTemplatePageIsDisplayed()

				.verifyFormTitleInEditFormTemplatePage(
						objFormConfiguration_data.strFormName)
				.verifyFormDescriptionInEditFormTemplatePage(
						objFormConfiguration_data.strDiscriptiveName)
				.verSelectedActivationFieldInDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.verSelecetdCompletedFormDeliveryInDropDown(
						objFormConfiguration_data.strComptdFormDelvry)
				.verHowToNotifyCheckBoxesIsSelected(
						objFormConfiguration_data.strNotifyViaWeb)
				.verHowToNotifyCheckBoxesIsSelected(
						objFormConfiguration_data.strNotifyViaEmail)
				.verHowToNotifyCheckBoxesIsSelected(
						objFormConfiguration_data.strNotifyViaPager)
				.clickOnCancelButton();

		objFormConfiguration1
				.clickOnEditFormLink(objFormConfiguration_data.strFormName)
				.verifyEditFormTemplatePageIsDisplayed().clickOnNextButton()
				.deselUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnCancelButton();

		objFormConfiguration1
				.clickOnEditFormLink(objFormConfiguration_data.strFormName)
				.verifyEditFormTemplatePageIsDisplayed()
				.clickOnNextButton()

				.verSelUserToRcvCompltdFormCheckBoxIsSelected(
						objUserdata.strNewUserName1).clickOnCancelButton();

		objFormConfiguration1
				.clickOnSecurityLinkOfForm(
						objFormConfiguration_data.strFormName)
				.deselectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnCancelButton();
		objFormConfiguration1
				.clickOnSecurityLinkOfForm(
						objFormConfiguration_data.strFormName)

				.verifyUserInFormSecuritySettingIsSelected(
						objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySettingInIEBrowser();

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
	}
	
	/*************************************************************************************
	'Description :  Verify that the form can be saved by modifying only mandatory data
	'Precondition:
	'Date	 	 : 07-May-2015
	'Author		 : Sangappa.k
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that the form can be saved by modifying only mandatory data")
	public void testEdgeCase154705() throws Exception {

		gstrTCID = "154705";
		gstrTO = "Verify that the form can be saved by modifying only mandatory data";

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
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
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
						objFormConfiguration_data.strUserToIndividualUsers)
				.clickOnNextButton().deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();
		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnEditFormLink(objFormConfiguration_data.strFormName)
				.verEditFormTempltePage()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strEditeFormName,
						objFormConfiguration_data.strEditedDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strUserToIndividualUsers)
				.clickOnNextButton()
				.clickOnNextButton()
				.clickOnNextButton()
				.verFormConfigurePage()
				//.verFormTittle(objFormConfiguration_data.strEditeFormName)
				.verFormDescription(
						objFormConfiguration_data.strEditedDiscriptiveName)
				.clickOnEditFormLink(objFormConfiguration_data.strEditeFormName)
				.verEditFormTempltePage()
				.verFormTittleInFormField(
						objFormConfiguration_data.strEditeFormName)
				.verFormDescriptionInDescriptionField(
						objFormConfiguration_data.strEditedDiscriptiveName)
				.verSelectedActivationFieldInDropDown(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.verSelecetdCompletedFormDeliveryInDropDown(
						objFormConfiguration_data.strUserToIndividualUsers)
				.clickOnNextButton().clickOnNextButton().clickOnNextButton();
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Edit a inactive form and make it active and verify that the form is: 1. Available while providing security right to the form. 2. Available while Generating the form Detail report. 3. Available while activating the form. 
	'Precondition:
	'Date	 	 : 19-Dec-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Edit a inactive form and make it active and verify that the form is: 1. Available while providing security right to the form. 2. Available while Generating the form Detail report. 3. Available while activating the form. ")
	public void testEdgeCase154716() throws Exception {

		gstrTCID = "154716";
		gstrTO = "Edit a inactive form and make it active and verify that the form is: 1. Available while providing security right to the form. 2. Available while Generating the form Detail report. 3. Available while activating the form. ";
	
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		Date_Time_settings objDts = new Date_Time_settings();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);
		Report objReport1 = new Report(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		
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
				.selectReportformDetail()
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
				.deselectActiveFormCheckBox()
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selUserInFormSecuritySetting(objUserdata.strNewUserName)
				.selectRunReportChkBoxInSecurityPge(objUserdata.strNewUserName)
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
						    .selectQuestionType(objFormConfiguration_data.strNumeric)
						    .enterLabelName(objFormConfiguration_data.strLabelName)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strText)
						    .enterLabelName(objFormConfiguration_data.strLabelName1)
						    .clickOnAddToSummary()
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
		
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnEditFormLink(objFormConfiguration_data.strFormName)
				.selectActiveFormCheckBox()
				.clickOnNextButton()	
				.clickOnNextButton();
		objLogin1.clickLogOut();
		

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1.verifyFillFormIsDisplayed(objFormConfiguration_data.strFormName);

		objNavigationToSubmenus1.navigateToFormReport();

		String strApplicationDate = objEventManagement1.getApplicationTimeWithCSTCDT();
		String[] strDate = strApplicationDate.split(" ");
		String strCurrentDate = objDts.getCurrentDate("dd");
		String strStartDate = "";
		int intDate = Integer.parseInt(strDate[0]);
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
		
		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate).enterReportEndDate(strStartDate)
				.selForm(objFormConfiguration_data.strFormName);
		gstrResult = "PASS";
	}

	
	/*************************************************************************************
    'Description : Edit a form and select the form to be filled out by himself and verify that: 1. The form can be filled out by himself. 2. The completed form and generated report displays correct data.    
    'Precondition:
    'Date        : 11-May-2015
    'Author      : Anil
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
    **************************************************************************************/
	@Test(description = "Edit a form and select the form to be filled out by himself and verify that: 1. The form can be filled out by himself. 2. The completed form and generated report displays correct data. ")
	public void testEdgeCase154709() throws Exception {

		gstrTCID = "154709";
		gstrTO = "Edit a form and select the form to be filled out by himself and verify that: 1. The form can be filled out by himself. 2. The completed form and generated report displays correct data. ";


		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		Date_Time_settings objDts = new Date_Time_settings();
		BlankFormData objBlankFormData = new BlankFormData();
		Report_data objReport_data = new Report_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
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
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		BlankForm objBlankForm1 = new BlankForm(this.driver1);
		DispatchForm objDispatchForm1 = new DispatchForm(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = objDts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.reportFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		// First file variables
		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";
		
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
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectReportformDetail()
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
						objFormConfiguration_data.strUserToIndividualUsers)
				.clickOnNextButton()
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)			
				.clickOnNextButton()
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.selectRunReportChkBoxInSecurityPge(objUserdata.strNewUserName1)
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

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnEditFormLink(objFormConfiguration_data.strFormName)
				.verifyEditFormTemplatePageIsDisplayed()
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
				.selCompletedFormDelivery(
								objFormConfiguration_data.strUserToIndividualUsers)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.clickOnNextButton()
				.deSelectAllUsersCheckBox()
				.selUserToRcvCompltdForm(objUserdata.strNewUserName1)
				.clickOnNextButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();
		
		objActivateForms1
				.clickOnFillForm(objFormConfiguration_data.strFormName);
		
		Thread.sleep(2000);

		String strApplicationDate = objEventManagement1.getApplicationTimeWithCSTCDT();
		String[] strDate = strApplicationDate.split(" ");
		String strActivationDate = "";
		String strCurrentDate = objDts.getCurrentDate("dd");
		String strStartDate = "";
		int intDate = Integer.parseInt(strDate[0]);
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
		
		int intDateInApplication = Integer.parseInt(strDate[0]);
		if(intDateInApplication == intCurrentDate){
			strActivationDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if(intDateInApplication < intCurrentDate){
				strActivationDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			}
			else {
				strActivationDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		strDate = strApplicationDate.split(" ");
		
		String strActivationTime = strDate[2] ;
		
		System.out.println(strActivationTime);
		
		Thread.sleep(5000);

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

		objBlankForm1
				.verFormTitle(objFormConfiguration_data.strFormName)
				.verGroupName(objFormConfiguration_data.strGroupName)
				.verFieldSetName(objFormConfiguration_data.strAttributeName)
				.enterAnswerInField(objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer).clickOnSave();

		objBlankForm1.clickOnComplete();

		objDispatchForm1
				.selUserToReceiveCompletedForm(objUserdata.strNewUserName1)
				.clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);

		objRegionDefault1.selectFrame();
		
	    objLinksAtTopRightCorners1.clickOnRefresh();
		
		Thread.sleep(1000);
		
		String strApplicationDate1 = objEventManagement1.getApplicationTimeWithCSTCDT();

		String[] strDate1 = strApplicationDate1.split(" ");
		String strEndDate = "";
		int intDate1 = Integer.parseInt(strDate1[0]);
		if(intDate1 == intCurrentDate){
			strEndDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if(intDate1 < intCurrentDate){
				strEndDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			}
			else {
				strEndDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		
		String strCompletedTime = strDate1[2];
		System.out.println(strCompletedTime);
		Thread.sleep(5000);
		
		objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		/*String strMsg = "Submitted by " + objUserdata.strFullName
				+ "\nSummary: | " + objFormConfiguration_data.strLabelName
				+ ": " + objBlankFormData.strNumericAnswer + "";*/
		
		String strMsg = objRegionDefault1
				.getWebNotificationForOneQuestionnaire(objUserdata.strFullName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.verWebNotificationMsgForForms(
						objFormConfiguration_data.strFormName, strMsg)
				.clickAcknowledgeAllForms().switchToDefaultFrame();
				
		Thread.sleep(2000);
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToFormReport();

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate).enterReportEndDate(strEndDate)
				.selForm(objFormConfiguration_data.strFormName);

		Thread.sleep(2000);

		objReport1.clickOnGenerateReportBtn();


        Thread.sleep(5000);
        
        String[] strQuestions = {objFormConfiguration_data.strLabelName};

        String[] strHeaderNames = ArrayUtils.addAll(
                     objReport_data.strHtmlHeaderContents, strQuestions);
        
        String[] strAnswers = {strActivationDate,
        				strCompletedTime,
                     objUserdata.strNewUserName,
                     objUserdata.strFullName1,
                     strEndDate,
                     strCompletedTime,
                     objUserdata.strNewUserName,
                     objUserdata.strFullName,
                     objBlankFormData.strNumericAnswer};
        
        
		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objReport1.verifyFormNameStartDateAndEndDate(
				objFormConfiguration_data.strFormName, strStartDate,
				strEndDate)
				.verHTMLFormHeadersAndAnswers(strHeaderNames, strAnswers);
		

		driver1.close();
		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objReport1.clickOnFormDetail().verifyFormDetailReportPage()
				.enterReportStartDate(strStartDate)
				.enterReportEndDate(strEndDate).selectXlsxRadioBtn()
				.selForm(objFormConfiguration_data.strFormName);

		Thread.sleep(2000);
		objReport1.clickOnGenerateReportBtn();

		  objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
                  strAutoITName);
     int intCount = 0;
     int intCount1 = 0;
     do {

            try {
                  assertTrue(new File(strDownloadName).exists());
                  Thread.sleep(10000);
                  Runtime.getRuntime().exec(
                                "wscript " + autoItFiles + filePath + " "
                                              + strCSVFileNameRenamed);

                  intCount1 = 0;
                  do {
                         try {
                                assertTrue(new File(strCSVDownlRenamedPath).exists());
                                break;
                         } catch (AssertionError Ae) {
                                Thread.sleep(1000);
                                intCount1++;
                         }

                  } while (intCount1 < 60);

                  break;
            } catch (AssertionError Ae) {
                  Thread.sleep(1000);
                  intCount++;
            }
     } while (intCount < 60);

		String strValue;

		String[] arrForm = {"Form", objFormConfiguration_data.strFormName};
		String[] arrStartDate = {"Start Date", strStartDate};
		String[] arrEndDate = {"End Date", strEndDate};

		for (intCount = 1; intCount <= arrForm.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 1,
					intCount, strDownloadName1);
			assertEquals(arrForm[intCount - 1], strValue);
		}

		for (intCount = 1; intCount <= arrStartDate.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 2,
					intCount, strDownloadName1);
			assertEquals(arrStartDate[intCount - 1], strValue);
		}

		for (intCount = 1; intCount <= arrEndDate.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 3,
					intCount, strDownloadName1);
			assertEquals(arrEndDate[intCount - 1], strValue);
		}

		String[] strValues = strAnswers;

		for (intCount = 1; intCount <= (strHeaderNames.length); intCount++) {
			if (intCount == 2 || intCount == 6) {
				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						4, intCount, strDownloadName1);
				assertTrue(strValue.contains(strHeaderNames[intCount - 1]));

				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						5, intCount, strDownloadName1);
				
				String strTime = strValues[intCount - 1];
				String strTime1 = objDts
						.addTimetoExisting(strTime, -1, "HH:mm");
				String strTime2 = objDts.addTimetoExisting(strTime, 1, "HH:mm");
				assertTrue(strValue.contains(strValues[intCount - 1])
						|| strValue.contains(strTime1)
						|| strValue.contains(strTime2));
			} else {
				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						4, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);

				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						5, intCount, strDownloadName1);
				assertEquals(strValues[intCount - 1], strValue);
			}
		}

		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description :Edit a form and deselect the previously selected resources and select new resources for filling out the form and verify that:
	              1. The previously selected resources are not available while activating the form. 
	              2. The newly selected resources are available while activating the form.
	'Precondition:
	'Date	 	 : 08-May-2015
	'Author		 : Sangappa.k
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
  @Test(/*invocationCount=3,*/description = "Edit a form and deselect the previously selected resources and select new resources for filling out the form and verify that:"
              +"1. The previously selected resources are not available while activating the form." 
              +"2. The newly selected resources are available while activating the form.")
  
public void testEdgeCase154707() throws Exception {

	gstrTCID = "154707";
	gstrTO = "Edit a form and deselect the previously selected resources and select new resources for filling out the form and verify that:"
              +"1. The previously selected resources are not available while activating the form." 
              +"2. The newly selected resources are available while activating the form.";
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		lib.page.Resource objResource_Page = new lib.page.Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		String[] strStatusTypeValues = new String[1];

		String[] strResourceTypeValue = new String[1];
		String[] strResourceValue = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName1,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objResource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename1,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName1);

		objResource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource_Page
				.getResourceValue(objResource_data.strResourceName2);

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
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
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
						objFormConfiguration_data.strUserToIndividualResources)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton()
				.selectResources(objResource_data.strResourceName1)
				.clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

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
		Thread.sleep(5000);
		objFormConfiguration1.verTemplateDesignPage();
		Thread.sleep(50000);
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
				.clickOnAddToSummary()
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(50000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		/*
		 * objLogin.clickLogOut();
		 * 
		 * objLogin1.loginToApplication(objLogindata.strAdminUser,
		 * objLogindata.strAdminUserPwd);
		 * 
		 * objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName
		 * );
		 * 
		 * objRegionDefault1.selectFrame();
		 */

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnEditFormLink(objFormConfiguration_data.strFormName)
				.clickOnNextButton().clickOnNextButton()
				.selectResources(objResource_data.strResourceName2)
				.deselectResources(objResource_data.strResourceName1)
				.clickOnNextButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName);

		objActivateForms1.verifyResourcesToFillOutForm(
				objResource_data.strResourceName2)
				.verifyResourcesToFillOutFormIsNotDisplaed(
						objResource_data.strResourceName1);
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
  
	/*************************************************************************************
	'Description :  Edit a form and select to send the completed form to 'Users' and verify that:
	 				1. The completed form is sent to users. 
	 				2. The completed form and generated report displays correct data.
	'Precondition:
	'Date	 	 : 12-May-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Edit a form and select to send the completed form to 'Users' and verify that: "
			+ "1. The completed form is sent to users. "
			+ "2. The completed form and generated report displays correct data.")
	public void testEdgeCase154712() throws Exception {

		gstrTCID = "154712";
		gstrTO = "Edit a form and select to send the completed form to 'Users' and verify that: "
				+ "1. The completed form is sent to users. "
				+ "2. The completed form and generated report displays correct data.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		BlankFormData objBlankFormData = new BlankFormData();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
      StatusTypes_data objStatusTypes_data = new StatusTypes_data();
      Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);

		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		BlankForm objBlankForm = new BlankForm(this.driver1);
		DispatchForm objDispatchForm = new DispatchForm(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = objDts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.reportFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		// First file variables
		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;

		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String filePath = file + "\\";

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton()
				.clickOnViewResChkBox()
				.clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName, 
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1, 
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption()
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectReportformDetail()
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
			                      objFormConfiguration_data.strUserToIndividualResources)
			        .selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
			        .clickOnNextButton()
			        .selUserInUsersToFillOutForm(objUserdata.strNewUserName)
			        .clickOnNextButton()
			        .clickOnNextButton()
			        .selectActivateFormChkBox(objUserdata.strNewUserName1)
			        .selectRunReportChkBoxInSecurityPge(objUserdata.strNewUserName2)
			        .clickOnSaveOfFormSecuritySetting();
		
		System.out.println(objFormConfiguration_data.strFormName);
		
		String strApplicationDate = objEventManagement.getApplicationTimeWithCSTCDT();
		String[] strDate = strApplicationDate.split(" ");
		String strCurrentDate = objDts.getCurrentDate("dd");
		String strStartDate = "";
		int intDate = Integer.parseInt(strDate[0]);
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

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		Thread.sleep(2000);
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
						    .selectQuestionType(objFormConfiguration_data.strNumeric)
						    .enterLabelName(objFormConfiguration_data.strLabelName)
						    .clickOnAddToSummary()
						    .clickOnDoneButton()
						    .clickOnInsertElement(objFormConfiguration_data.strAttributeName)
						    .verifyEditQuestionWindow()    
						    .selectQuestionType(objFormConfiguration_data.strText)
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
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration1.verFormConfigurePage()
							 .clickOnEditFormLink(
									 objFormConfiguration_data.strFormName)
							 .selCompletedFormDelivery(
									objFormConfiguration_data.strUserToIndividualUsers)
							 .clickOnNextButton()
						 	 .verSelUserToRcvCompltdFormCheckBoxIsSelected(
						 			 objUserdata.strNewUserName)
						 	 .clickOnNextButton()
							 .clickOnNextButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1.clickOnSendForm(objFormConfiguration_data.strFormName)
						 .selUserToFillOutForm(objUserdata.strNewUserName)
						 .clickOnActivateForm();
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		
		Thread.sleep(2000);
		strApplicationDate = objEventManagement1.getApplicationTimeWithCSTCDT();
		String[] strDateInApplication = strApplicationDate.split(" ");
		String strActivationDate = "";
		int intDateInApplication = Integer.parseInt(strDateInApplication[0]);
		if(intDateInApplication == intCurrentDate){
			strActivationDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if(intDateInApplication < intCurrentDate){
				strActivationDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			}
			else {
				strActivationDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		strDate = strApplicationDate.split(" ");
		
		String strActivationTime = strDate[2] ;
		System.out.println("Activation Date: " + strActivationDate + "\nActivationTime: " + strActivationTime);

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName,
						 objUserdata.strNewPassword);

		Thread.sleep(2000);
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
		objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName,
							objBlankFormData.strNumericAnswer)
					.enterAnswerInField(objFormConfiguration_data.strLabelName1,
							objBlankFormData.strTextAnswer)
					.clickOnSave();
		
		objBlankForm.clickOnComplete();
		
		objDispatchForm.selUserToReceiveCompletedForm(
								objUserdata.strNewUserName2)
					   .verifyResourceSectionIsNotDisplayedInReceiveCompletedForm()
					   .clickOnDispatchForm();

		driver1.switchTo().window(mainWindowHandle1);
		
		objRegionDefault1.selectFrame();

		objLinksAtTopRightCorners1.clickOnRefresh();
		
		Thread.sleep(1000);
		
		String strApplicationDate1 = objEventManagement1.getApplicationTimeWithCSTCDT();

		String[] strDate1 = strApplicationDate1.split(" ");
		String strEndDate = "";
		int intDate1 = Integer.parseInt(strDate1[0]);
		if(intDate1 == intCurrentDate){
			strEndDate = objDts.getCurrentDate("MM/dd/yyyy");
		} else {
			if(intDate1 < intCurrentDate){
				strEndDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
			}
			else {
				strEndDate = objDts.getFutureDay(1, "MM/dd/yyyy");
			}
		}
		
		String strCompletedTime = strDate1[2];
		System.out.println("Completed Time: " + strCompletedTime);
		Thread.sleep(5000);

		objLogin1.clickLogOut()
				 .loginAsNewUser(objUserdata.strNewUserName2,
						 	objUserdata.strNewPassword);

		objRegionDefault1
				.selectFrame()
				.verWebNotificationframe()
				.clickAcknowledgeAllForms()
				.selectFrame().switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.navigateToFormReport();

		System.out.println("Start Date: " + strStartDate);
		System.out.println("End Date: " + strEndDate);
		
		objReport1.clickOnFormDetail()
				  .verifyFormDetailReportPage()
				  .enterReportStartDate(strStartDate)
				  .enterReportEndDate(strEndDate)
				  .selForm(objFormConfiguration_data.strFormName)
				  .clickOnGenerateReportBtn();

		Thread.sleep(5000);
		
		String[] strQuestions = {objFormConfiguration_data.strLabelName, objFormConfiguration_data.strLabelName1};
		
		String[] strHeaderNames = ArrayUtils.addAll(
				objReport_data.strHtmlHeaderContents, strQuestions);
		
		String[] strAnswers = {strActivationDate,
				strActivationTime,
				objUserdata.strNewUserName1,
				objUserdata.strFullName2,
				strEndDate,
				strCompletedTime,
				objUserdata.strNewUserName,
				objUserdata.strFullName,
				objBlankFormData.strNumericAnswer, 
				objBlankFormData.strTextAnswer };
		
		String mainWindowHandle2 = driver1.getWindowHandle();
		
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();
		
		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();
		
			if (!popupHandle.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle);
		
			}
		}
		
		objReport1.verifyFormNameStartDateAndEndDate(
						objFormConfiguration_data.strFormName, strStartDate,
						strEndDate)
				  .verHTMLFormHeadersAndAnswers(strHeaderNames, strAnswers);
		
		driver1.close();
		
		driver1.switchTo().window(mainWindowHandle2);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToFormReport();
		
		objReport1.clickOnFormDetail()
				  .verifyFormDetailReportPage()
				  .enterReportStartDate(strStartDate)
				  .enterReportEndDate(strEndDate)
				  .selForm(objFormConfiguration_data.strFormName)
				  .selectXlsxRadioBtn()
				  .clickOnGenerateReportBtn();
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		int intCount = 0;
		int intCount1 = 0;
		do {
		
			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed);
		
				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount1++;
					}
		
				} while (intCount1 < 60);
		
				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);
		
		String strValue;
		
		String[] arrForm = {"Form", objFormConfiguration_data.strFormName};
		String[] arrStartDate = {"Start Date", strStartDate};
		String[] arrEndDate = {"End Date", strEndDate};
		
		for (intCount = 1; intCount <= arrForm.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 1,
					intCount, strDownloadName1);
			assertEquals(arrForm[intCount - 1], strValue);
		}
		
		for (intCount = 1; intCount <= arrStartDate.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 2,
					intCount, strDownloadName1);
			assertEquals(arrStartDate[intCount - 1], strValue);
		}
		
		for (intCount = 1; intCount <= arrEndDate.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 3,
					intCount, strDownloadName1);
			assertEquals(arrEndDate[intCount - 1], strValue);
		}
		
		String[] strValues = strAnswers;
		
		for (intCount = 1; intCount <= (strHeaderNames.length); intCount++) {
			if (intCount == 2 || intCount == 6) {
				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						4, intCount, strDownloadName1);
				assertTrue(strValue.contains(strHeaderNames[intCount - 1]));
		
				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						5, intCount, strDownloadName1);
				String strTime = strValues[intCount - 1];
				String strTime1 = objDts
						.addTimetoExisting(strTime, -1, "HH:mm");
				String strTime2 = objDts.addTimetoExisting(strTime, 1, "HH:mm");
				assertTrue(strValue.contains(strValues[intCount - 1])
						|| strValue.contains(strTime1)
						|| strValue.contains(strTime2));
			} else {
				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						4, intCount, strDownloadName1);
				assertEquals(strHeaderNames[intCount - 1], strValue);
		
				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
						5, intCount, strDownloadName1);
				assertEquals(strValues[intCount - 1], strValue);
			}
		}
		gstrResult = "PASS";
	}
	
	  /***********************************************************************************************************************
		'Description : Edit a form and select the form to be filled by others and verify that: 1. The form can sent to the selected users. 2. The completed form and generated report displays correct data. 
		'Date	 	 : 11-May-2014
		'Author		 : Anil
		'---------------------------------------------------------------------------------------------------------------------
		'Modified Date			                        	                                               Modified By
		'Date					                                                                           Name
		***********************************************************************************************************************/
		@Test(description = "Edit a form and select the form to be filled by others and verify that: 1. The form can sent to the selected users. 2. The completed form and generated report displays correct data. ")
		public void testEdgeCase154710() throws Exception {

			gstrTCID = "154710";
			gstrTO = "Edit a form and select the form to be filled by others and verify that: 1. The form can sent to the selected users. 2. The completed form and generated report displays correct data. ";

			
			Login_data objLogindata = new Login_data();
			BlankFormData objBlankFormData = new BlankFormData();
			FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
			User_data objUserdata = new User_data();
			Resource_data objResource_data = new Resource_data();
			Report_data objReport_data = new Report_data();
			OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
			Date_Time_settings objDts = new Date_Time_settings();
			
			Login objLogin = new Login(this.driver1);
			SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
			UsersList objUsersList = new UsersList(this.driver1);
			RegionDefault objRegionDefault = new RegionDefault(this.driver1);
			NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
			FormConfiguration objFormConfiguration = new FormConfiguration(this.driver1);
			
			Login objLogin1 = new Login(this.driver1);
			RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
			SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
			NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
			FormConfiguration objFormConfiguration1 = new FormConfiguration(this.driver1);
			ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
			BlankForm objBlankForm = new BlankForm(this.driver1);
			DispatchForm objDispatchForm = new DispatchForm(this.driver1);
			Report objReport1 = new Report(this.driver1);
			EventManagement objEventManagement1 = new EventManagement(this.driver1);
			AutoIT objAutoIT = new AutoIT(this.driver1);
			
			PathsProperties objAP = new PathsProperties();
			Properties pathProps = objAP.ReadAutoit_FilePath();

			String strTimeText = objDts.getCurrentDate(objReport_data.dateFormat1);
			String fileType = objReport_data.reportFile;

			String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
			String strAutoItPath = ReadAutoItProperty
					.readDataFromAutoItPath(AutoIT_FILE_PATH);
			String strAutoITName = pathProps
					.getProperty(objReport_data.reportsDownloadAutoItName);
			String fileDownloadPath = pathProps
					.getProperty(objReport_data.reportsDownloadPath);

			String autoItFilesPath = pathProps
					.getProperty(objReport_data.autoItPath);

			File file = new File(System.getProperty("user.dir") + fileDownloadPath);

			File autoItFiles = new File(System.getProperty("user.dir")
					+ autoItFilesPath);

			// First file variables
			String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
					+ strTimeText + fileType;

			String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

			String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
					+ strTimeText + objReport_data.xlsFile;

			String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
					+ strTimeText + objReport_data.xlsFile;

			String filePath = file + "\\";

			
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
					.selectFirstRole()
					.clickSaveButton();

			objUsersList
					.clickCreateNewUserButton()
					.enterUserDetails(objUserdata.strNewUserName2,
							objUserdata.strNewPassword, objUserdata.strFullName2)
					.selectFirstRole()
					.clickAdvancedOptionAndExpand()
					.selectReportformDetail()
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
							objFormConfiguration_data.strInitiateAndFillOutHimOrHerself)
					.selCompletedFormDelivery(
							objFormConfiguration_data.strUserToIndividualUsers)
					.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
					.clickOnNextButton()
					.clickOnNextButton()
					.selectActivateFormChkBoxNew(objUserdata.strNewUserName)
					.selectRunReportChkBoxInSecurityPge(objUserdata.strNewUserName2)
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
			Thread.sleep(30000);

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
			
			objLogin1.loginToApplication(objLogindata.strAdminUser,
					objLogindata.strAdminUserPwd);
			
			objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

			objRegionDefault1.selectFrame();
			
			objNavigationToSubmenus1.clickOnConfigureForm();
			
			objFormConfiguration1.clickOnEditFormLink(objFormConfiguration_data.strFormName)
			.selectOptionInFormActivationDropDown(
					objFormConfiguration_data.strFormActivatnUIOTFO)
			.clickOnNextButton()
			.selUserToRcvCompltdForm(objUserdata.strNewUserName1)			
			.clickOnNextButton()
			.clickOnNextButton();

			objLogin1.clickLogOut();
			
			//Main functionality
			objLogin1.loginAsNewUser(objUserdata.strNewUserName,
					objUserdata.strNewPassword);

			objRegionDefault1.selectFrame();

			objNavigationToSubmenus1.navigateToActivateForm();

			String strApplicationDate = objEventManagement1.getApplicationTimeWithCSTCDT();
			String[] strDate = strApplicationDate.split(" ");
			String strActivationDate = "";
			String strCurrentDate = objDts.getCurrentDate("dd");
			String strStartDate = "";
			int intDate = Integer.parseInt(strDate[0]);
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
			
			int intDateInApplication = Integer.parseInt(strDate[0]);
			if(intDateInApplication == intCurrentDate){
				strActivationDate = objDts.getCurrentDate("MM/dd/yyyy");
			} else {
				if(intDateInApplication < intCurrentDate){
					strActivationDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
				}
				else {
					strActivationDate = objDts.getFutureDay(1, "MM/dd/yyyy");
				}
			}
			strDate = strApplicationDate.split(" ");
			
			String strActivationTime = strDate[2] ;
			
			System.out.println(strActivationTime);
			
			objActivateForms1
					.clickOnSendForm(objFormConfiguration_data.strFormName)
					.selUserToFillOutForm(objUserdata.strNewUserName1)
					.clickOnActivateForm();
			objLogin1.clickLogOut();
			
			objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
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
			objBlankForm.verFormTitle(objFormConfiguration_data.strFormName)
					.verGroupName(objFormConfiguration_data.strGroupName)
					.verFieldSetName(objFormConfiguration_data.strAttributeName)
					.enterAnswerInField(objFormConfiguration_data.strLabelName, objBlankFormData.strNumericAnswer)
					.clickOnSave();

			objBlankForm.clickOnComplete();

			objDispatchForm
					.selUserToReceiveCompletedForm(objUserdata.strNewUserName2)
					.clickOnDispatchForm();

			driver1.switchTo().window(mainWindowHandle1);

			objRegionDefault1.selectFrame();

			String strApplicationDate1 = objEventManagement1.getApplicationTimeWithCSTCDT();

			String[] strDate1 = strApplicationDate1.split(" ");
			String strEndDate = "";
			int intDate1 = Integer.parseInt(strDate1[0]);
			if(intDate1 == intCurrentDate){
				strEndDate = objDts.getCurrentDate("MM/dd/yyyy");
			} else {
				if(intDate1 < intCurrentDate){
					strEndDate = objDts.getPastDayNew(1, "MM/dd/yyyy");
				}
				else {
					strEndDate = objDts.getFutureDay(1, "MM/dd/yyyy");
				}
			}
			
			String strCompletedTime = strDate1[2];
			System.out.println(strCompletedTime);
			Thread.sleep(5000);
			
			objLogin1.clickLogOut().loginAsNewUser(objUserdata.strNewUserName2,
					objUserdata.strNewPassword);

			/*String strMsg = "Submitted by " + objUserdata.strFullName1 + " for "
					+ objResource_data.strResourceName + "\nSummary: | "
					+ objFormConfiguration_data.strLabelName + ": "
					+ objBlankFormData.strNumericAnswer + "";*/
			
		String strMsg = objRegionDefault1
				.getWebNotificationForResourceWithOneQuest(
						objUserdata.strFullName1,
						objResource_data.strResourceName,
						objLogindata.strRegionName,
						objFormConfiguration_data.strLabelName,
						objBlankFormData.strNumericAnswer);

			objRegionDefault1
					.selectFrame()
					.verWebNotificationframe()
					.verWebNotificationMsgForForms(
							objFormConfiguration_data.strFormName, strMsg)
					.clickAcknowledgeAllForms().switchToDefaultFrame().selectFrame();

			Thread.sleep(2000);
			objRegionDefault1.selectFrame();

			objNavigationToSubmenus1.navigateToFormReport();

			objReport1.clickOnFormDetail().verifyFormDetailReportPage()
					.enterReportStartDate(strStartDate).enterReportEndDate(strEndDate)
					.selForm(objFormConfiguration_data.strFormName);

			Thread.sleep(2000);

			objReport1.clickOnGenerateReportBtn();


	        Thread.sleep(5000);
	        
	        String[] strQuestions = {objFormConfiguration_data.strLabelName};

	        String[] strHeaderNames = ArrayUtils.addAll(
	                     objReport_data.strHtmlHeaderContents, strQuestions);
	        
	        String[] strAnswers = {strActivationDate,
	        			strActivationTime,
	                     objUserdata.strNewUserName,
	                     objUserdata.strFullName2,
	                     strEndDate,
	                     strCompletedTime,
	                     objUserdata.strNewUserName1,
	                     objUserdata.strFullName1,
	                     objBlankFormData.strNumericAnswer};
	        
	        
			String mainWindowHandle2 = driver1.getWindowHandle();
			Set<String> a2 = driver1.getWindowHandles();
			Iterator<String> ite2 = a2.iterator();

			while (ite2.hasNext()) {
				String popupHandle = ite2.next().toString();

				if (!popupHandle.contains(mainWindowHandle2)) {
					driver1.switchTo().window(popupHandle);

				}
			}

			objReport1.verifyFormNameStartDateAndEndDate(
					objFormConfiguration_data.strFormName, strStartDate,
					strEndDate)
					.verHTMLFormHeadersAndAnswers(strHeaderNames, strAnswers);
			

			driver1.close();
			driver1.switchTo().window(mainWindowHandle2);

			objRegionDefault1.selectFrame();

			objReport1.clickOnFormDetail().verifyFormDetailReportPage()
					.enterReportStartDate(strStartDate)
					.enterReportEndDate(strEndDate).selectXlsxRadioBtn()
					.selForm(objFormConfiguration_data.strFormName);

			Thread.sleep(2000);
			objReport1.clickOnGenerateReportBtn();

			  objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
	                  strAutoITName);
	     int intCount = 0;
	     int intCount1 = 0;
	     do {

	            try {
	                  assertTrue(new File(strDownloadName).exists());
	                  Thread.sleep(10000);
	                  Runtime.getRuntime().exec(
	                                "wscript " + autoItFiles + filePath + " "
	                                              + strCSVFileNameRenamed);

	                  intCount1 = 0;
	                  do {
	                         try {
	                                assertTrue(new File(strCSVDownlRenamedPath).exists());
	                                break;
	                         } catch (AssertionError Ae) {
	                                Thread.sleep(1000);
	                                intCount1++;
	                         }

	                  } while (intCount1 < 60);

	                  break;
	            } catch (AssertionError Ae) {
	                  Thread.sleep(1000);
	                  intCount++;
	            }
	     } while (intCount < 60);

			String strValue;

			String[] arrForm = {"Form", objFormConfiguration_data.strFormName};
			String[] arrStartDate = {"Start Date", strStartDate};
			String[] arrEndDate = {"End Date", strEndDate};

			for (intCount = 1; intCount <= arrForm.length; intCount++) {
				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 1,
						intCount, strDownloadName1);
				assertEquals(arrForm[intCount - 1], strValue);
			}

			for (intCount = 1; intCount <= arrStartDate.length; intCount++) {
				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 2,
						intCount, strDownloadName1);
				assertEquals(arrStartDate[intCount - 1], strValue);
			}

			for (intCount = 1; intCount <= arrEndDate.length; intCount++) {
				strValue = objOffCommonFunc.readInfoExcel("Form Detail Report", 3,
						intCount, strDownloadName1);
				assertEquals(arrEndDate[intCount - 1], strValue);
			}

			String[] strValues = strAnswers;

			for (intCount = 1; intCount <= (strHeaderNames.length); intCount++) {
				if (intCount == 2 || intCount == 6) {
					strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
							4, intCount, strDownloadName1);
					assertTrue(strValue.contains(strHeaderNames[intCount - 1]));

					strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
							5, intCount, strDownloadName1);
					
					String strTime = strValues[intCount - 1];
					String strTime1 = objDts
							.addTimetoExisting(strTime, -1, "HH:mm");
					String strTime2 = objDts.addTimetoExisting(strTime, 1, "HH:mm");
					assertTrue(strValue.contains(strValues[intCount - 1])
							|| strValue.contains(strTime1)
							|| strValue.contains(strTime2));
				} else {
					strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
							4, intCount, strDownloadName1);
					assertEquals(strHeaderNames[intCount - 1], strValue);

					strValue = objOffCommonFunc.readInfoExcel("Form Detail Report",
							5, intCount, strDownloadName1);
					assertEquals(strValues[intCount - 1], strValue);
				}
			}
			
			objLogin1.clickLogOut();

			gstrResult = "PASS";
		}
		
}

